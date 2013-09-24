package droidsafe.analyses.rcfg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.AnySubType;
import soot.ArrayType;
import soot.Body;
import soot.MethodOrMethodContext;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.NewExpr;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.internal.JAssignStmt;
import soot.jimple.spark.geom.geomPA.CgEdge;
import soot.jimple.spark.geom.geomPA.GeomPointsTo;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.util.Chain;
import soot.util.queue.QueueReader;
import soot.Type;
import soot.RefLikeType;

import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.helper.CallGraphContextVisitor;
import droidsafe.analyses.helper.CallGraphTraversal;
import droidsafe.android.app.EntryPoints;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Project;
import droidsafe.android.app.resources.Resources;
import droidsafe.android.system.API;
import droidsafe.transforms.AddAllocsForAPICalls;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;
import droidsafe.utils.Utils;


/**
 * This class represents the reduced control flow graph starting from
 * the entry points defined as edge from API to user code.  It is 
 * built on top of the geometric points to analysis from soot.  
 * 
 * @author mgordon
 *
 */
public class RCFG extends CallGraphContextVisitor {
    /** logger object */
    private static final Logger logger = LoggerFactory.getLogger(RCFG.class);
     /** Singleton of this class */
    private static RCFG v;
     /** File name for output of unreachable user methods */
    private static final String UNREACHABLES_FILE_NAME = "unreachable-user-methods.txt"; 
    /** list of names of methods to ignore when creating the RCFG output events */
    private static final Set<String> IGNORE_SYS_METHOD_WITH_NAME = 
            new HashSet<String>(Arrays.asList("<clinit>", "finalize"));
    /** list of package name REs in which to ignore output events */
    private static final Pattern[] IGNORE_INPUT_EVENTS_IN = 
            {Pattern.compile("android.support.*")};
    /** Map of entry edge to the rcfg node representing it */
    private Map<Edge,RCFGNode> entryEdgeToNode;
    /** methods we have visited in our search */
    private Set<SootMethod> visitedMethods;
    /** alloc nodes that are either a receiver or argument for an api call */
    private Set<AllocNode> apiCallNodes;
    
    /**
     * Return the singleton of this class.
     */
    public static RCFG v() {
        return v;
    }

    /**
     * Generate the rCFG.
     */
    public static void generate() {
        v = new RCFG();
        CallGraphTraversal.accept(v);
        //print unreachable methods to the debug log
        v.printUnreachableSrcMethods();
    }
    
    private RCFG() {
        this.visitedMethods = new HashSet<SootMethod>();
        this.entryEdgeToNode = new LinkedHashMap<Edge, RCFGNode>();
        this.apiCallNodes = new HashSet<AllocNode>();
    }

    /**
     * Get the nodes of the rCFG (a forrest).
     */
    public Collection<RCFGNode> getNodes() {
        return entryEdgeToNode.values();
    }
    
    public RCFGNode getNodeForEntryEdge(Edge entryEdge) {
        if (!entryEdgeToNode.containsKey(entryEdge)) {
            logger.info("Creating new RCFG node from edge {}", entryEdge);
            entryEdgeToNode.put(entryEdge, new RCFGNode(entryEdge));
        }
        
        return entryEdgeToNode.get(entryEdge);
    }
    
    public void visitEntryContextAnd1CFA(SootMethod method, Edge entryEdge, Edge edgeInto) {
        //remember that we have visited this method
        visitedMethods.add(method);
        
        //only add to the rcfg node if there is a call from app code (non-system method) into the api (system method)
        //and the called system method is interesting
        //and we should not ignore it.
        if (API.v().isSystemMethod(method) && 
                !API.v().isSystemMethod(edgeInto.src()) &&
                API.v().isInterestingMethod(method) &&
                !IGNORE_SYS_METHOD_WITH_NAME.contains(method.getName())) {

            RCFGNode node = getNodeForEntryEdge(entryEdge);

            SourceLocationTag line = 
                    SootUtils.getSourceLocation(edgeInto.srcStmt(), edgeInto.src().getDeclaringClass());

            InvokeExpr invoke = edgeInto.srcStmt().getInvokeExpr();
            if (invoke instanceof InstanceInvokeExpr) {
                InstanceInvokeExpr iie = (InstanceInvokeExpr)invoke;
                for (AllocNode an : GeoPTA.v().getPTSet(iie.getBase(), entryEdge)) {
                    OutputEvent oe = new OutputEvent(edgeInto, entryEdge, node, an, line);
                    logger.debug("Found output event: {} {}", edgeInto.tgt(), an);
                    node.addOutputEvent(oe);
                    //remember interesting alloc nodes
                    apiCallNodes.add(an);
                    apiCallNodes.addAll(oe.getAllArgsPTSet());
                }
            } else {
                OutputEvent oe = new OutputEvent(edgeInto, entryEdge, node, null, line);
                logger.debug("Found output event: {} (null receiver)", edgeInto.tgt());
                node.addOutputEvent(oe);
                apiCallNodes.addAll(oe.getAllArgsPTSet());
            }
        }
    }
  
    /**
     * Find and return a string of all invoke statements that could invoke an API call.
     */
    private String checkForCompleteness(SootMethod src) {

        if (!src.isConcrete())
            return "";

        if (Project.v().isLibClass(src.getDeclaringClass().toString()))
            return "";

        StringBuilder strBuilder = new StringBuilder();
        StmtBody stmtBody = (StmtBody)src.retrieveActiveBody();

        // get body's unit as a chain
        Chain<Unit> units = stmtBody.getUnits();

        // get a snapshot iterator of the unit since we are going to
        // mutate the chain when iterating over it.
        Iterator<Unit> stmtIt = units.snapshotIterator();

        while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt)stmtIt.next();
            if (!stmt.containsInvokeExpr())
                continue;
            InvokeExpr invokeExpr = stmt.getInvokeExpr();

            SootMethod method = invokeExpr.getMethod();
            
            if (API.v().isInterestingMethod(method))
                strBuilder.append("\t" + method + "\n");
        }
        
        return strBuilder.toString();
    }

    /**
     * Loop over methods in the application we did not hit, because the analysis thinks they
     * are unreachable, and inform the user of any api calls in unreachable methods.
     */
    private void printUnreachableSrcMethods() {

        try {
            FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + UNREACHABLES_FILE_NAME);
            
            fw.write("# Unreachable Methods and the api calls they Invoke \n");
            fw.write("# DroidSafe determined that these methods are unreachable, but that may be unsound\n");
            fw.write("# due to Android api errors or omissions.\n\n");
            
            
            for (SootClass clz : Scene.v().getClasses()) {
                if (clz.isApplicationClass() && Project.v().isSrcClass(clz.toString()) &&
                        !Project.v().isGenClass(clz.toString())) {
                    for (SootMethod method : clz.getMethods()) {
                        if (!visitedMethods.contains(method)) {
                            String apiCalls = checkForCompleteness(method);
                            
                            if (!apiCalls.isEmpty()) {
                                fw.write(method + ":\n" + apiCalls + "\n\n");
                            }
                        }
                    }
                }
            }
            
            fw.close();
        } catch (IOException e) {
            logger.error("Error writing unreachable user methods summary files.");
            droidsafe.main.Main.exit(1);
        } 
    }
    
    /** 
     * Return true if the class of the input event is in the ignore list, and thus the 
     * input event should be ignored.
     */
    private boolean shouldIgnoreInputEventFromClass(String clzName) {
        for (Pattern re : IGNORE_INPUT_EVENTS_IN) {
            Matcher matcher = re.matcher(clzName); 
            if (matcher.matches())
                return true;
        }
        return false;
    }
    
    /**
     * Return string representation of RCFG.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (RCFGNode node : entryEdgeToNode.values()) {
            str.append(node + "\n");
        }

        return str.toString();
    }
}
