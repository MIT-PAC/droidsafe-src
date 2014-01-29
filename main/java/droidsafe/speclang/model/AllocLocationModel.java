package droidsafe.speclang.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.SootMethod;
import soot.jimple.Expr;
import soot.jimple.NewExpr;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.pta.IAllocNode;
import droidsafe.analyses.MethodCallsOnAlloc;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Project;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;

/**
 * A CodeLocationModel that represents the source line of an AllocNode.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 *
 */
public class AllocLocationModel extends CodeLocationModel {
    
    /**
     * Serialization id for class.
     */
    private static final long serialVersionUID = 370671779358834915L;

    /**
     * Standard logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(AllocLocationModel.class);

    /**
     * The type string for the new expression associated with the underlying AllocNode.
     */
    private String type;
    
    /**
     * List of source lines for the calls in the user code that might change the value
     * at the location corresponding to the underlying AllocNode.
     */
    private List<CallLocationModel> callsOnAlloc = new ArrayList<CallLocationModel>();

    /** True if the source line resides in an API class. */
    private boolean fromAPI;
    
    /**
     * Create an AllocNode source line model and compute its fields.
     * 
     * @param clz name of the class where the new expression for the AllocNode resides in
     * @param line the line number for the new expression corresponding to the underlying AllocNode
     * @param node the underlying AllocNode
     */
    public AllocLocationModel(String clz, int line, IAllocNode node) {
        super(clz, line);
        fromAPI = !Project.v().isSrcClass(clz);
        Object expr = node.getNewExpr();
        if (expr != null && expr instanceof NewExpr)
            type = ((NewExpr) expr).getType().toString();
        Set<Edge> callEdges = MethodCallsOnAlloc.v().getCalls(node);

        if (callEdges != null) {
            for (Edge callEdge: callEdges) {
                CallLocationModel callLine = CallLocationModel.get(callEdge);
                if (callLine != null) {
                    String className = callLine.getClz();
                    // only consider the calls in the user code
                    if (Project.v().isSrcClass(className)) {
                        callsOnAlloc.add(callLine);
                    }
                }
            }
            Collections.sort(callsOnAlloc);
        };
    }

    /**
     * Create an AllocNode source line model and compute its fields.
     * 
     * @param line the source location tag for the new expression corresponding to the underlying AllocNode
     * @param node the underlying AllocNode
     */
    public AllocLocationModel(SourceLocationTag line, IAllocNode node) {
        this(line.getClz(), line.getLine(), node);
    }

    /**
     * Return the type string for the new expression associated with the underlying AllocNode..
     */
    public String getType() {
        return type;
    }

    /**
     * Return true if the source line resides in an API class.
     */
    public boolean getFromAPI() {
        return fromAPI;
    }

    /**
     * Return the list of source lines for the calls in the user code that might change the value
     * at the location corresponding to the underlying AllocNode.
     */
    public List<CallLocationModel> getCallsOnAlloc() {
        return callsOnAlloc;
    }
    
    @Override
    public String toString() {
        String clz = getClz();
        int line = getLine();
        String str = clz + " line: " + line;
        if (type == null)
            return str;
        return type + " - " + str;
    }

    private static Map<IAllocNode, AllocLocationModel> map = new HashMap<IAllocNode, AllocLocationModel>();
    
    /**
     * Clear the static map from AllocNodes to their associated source line models.
     */
    public static void reset() {
        map.clear();
    }

    /**
     * Return the source line model for the give AllocNode. Return null if there are any problems.
     */
    public static AllocLocationModel get(IAllocNode node) {
        AllocLocationModel line = map.get(node);
        if (line == null) {
            Object expr = PTABridge.v().getNewExpr(node);

            if (expr == null || !(expr instanceof Expr)) {
                logger.debug("Cannot find new expression for allocnode: {}", node);
                return null;
            }

            Stmt stmt = JimpleRelationships.v().getEnclosingStmt((Expr)expr);
            if (stmt == null) {
                logger.debug("Cannot find enclosing statement for expression: {}", expr);
                return null;
            }

            SootMethod method = JimpleRelationships.v().getEnclosingMethod(stmt);
            if (method == null) {
                logger.debug("Cannot find enclosing method for statement: {}", stmt);
                return null;
            }

            // LWG
            SourceLocationTag srcLoc =  SootUtils.getSourceLocation(stmt, method.getDeclaringClass());
            if (srcLoc == null) {
                logger.debug("Cannot find source location for statement: {}", stmt);
                return null;
            }
            line = new AllocLocationModel(srcLoc, node);
            map.put(node, line);
        }
        return line;
    }

}
