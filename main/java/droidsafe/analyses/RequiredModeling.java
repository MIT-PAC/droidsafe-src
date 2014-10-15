package droidsafe.analyses;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.rcfg.OutputEvent;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.rcfg.RCFGNode;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.main.Config;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;
import droidsafe.utils.Utils;
import soot.Body;
import soot.MethodOrMethodContext;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Value;
import soot.ValueBox;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.StaticFieldRef;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.VirtualInvokeExpr;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.callgraph.ReachableMethods;
import soot.util.Chain;
import soot.util.queue.QueueReader;

/**
 * This class will create a file that includes the method that require modeling and
 * other errors about the concrete semantics of the api model.
 * 
 * @author mgordon
 *
 */
public class RequiredModeling {
    /** logger field */
    private static final Logger logger = LoggerFactory.getLogger(RequiredModeling.class);

    /**
     * Run various checks the API modeling (concrete semantics).  Dump the results to 
     * a file in the app droidsafe directory. 
     */
    public static void run() {
        Set<String> toModel = new TreeSet<String>();
        
        for (SootMethod method : PTABridge.v().getReachableMethods()) {
            //loop through all reachable methods, and find system methods that are not modeled
            //or system methods that do not exist (but are called)
            //ignore clinits
            
                        
            if (API.v().isSystemClass(method.getDeclaringClass()) && 
                    !ignoreNotModeled(method) &&  
                    !API.v().isAPIModeledMethod(method) &&
                    !SootMethod.staticInitializerName.equals(method.getName())) {

                if (method.isPhantom()) {
                    System.out.println("Reachable phantom method: " + method);
                }

                logger.debug("Method {}: hasbody-{}, abstract-{}, concrete-{}",
                    method,
                    method.hasActiveBody(),
                    method.isAbstract(),
                    method.isConcrete());

                SootMethod resolved  = SootUtils.resolveMethod(method);
                if (resolved != method && resolved != null) {
                    logger.debug("Method {} has an implementation {} ", method, resolved);
                    if (API.v().isAPIModeledMethod(resolved))
                        continue;
                }
                toModel.add(method.getSignature());
            }
        }

        try {
            FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + 
                    "api-modeling-summary.txt");
            fw.write("Unmodeled Methods:\n\n");
            for (String m : toModel) {
                fw.write(m + "\n");
            }

            checkHandlers(fw);

            fw.write("\nErrors in PTA for reachable methods:\n\n");
            checkAllocations(fw);

            fw.close();
        } catch (Exception e) {
            logger.error("Cannot write required modeling file", e);
            droidsafe.main.Main.exit(1);
        }

        reportMissingAPIFieldsAndMethods();
        printGetAddTaintCalls();
    }

    private static void printGetAddTaintCalls() {
        try {
            
            FileWriter taintCalls = new FileWriter(Project.v().getOutputDir() + File.separator + 
                    "taint-calls.txt");
            
            for (SootClass clz : Scene.v().getClasses()) {
                for (SootMethod method : clz.getMethods()) {
                    if (!method.isConcrete()) 
                        continue;

                    StmtBody stmtBody = (StmtBody)method.retrieveActiveBody();

                    // get body's unit as a chain
                    Chain units = stmtBody.getUnits();

                    Iterator stmtIt = units.iterator(); 

                    while (stmtIt.hasNext()) {
                        Stmt stmt = (Stmt)stmtIt.next();

                        if (stmt.containsInvokeExpr()) {
                            Set<SootMethod> targets = PTABridge.v().getTargetsInsNoContext(stmt);
                            for (SootMethod t : targets) {
                                if ("addTaint".equals(t.getName()) || "getTaint".equals(t.getName())) {
                                    taintCalls.write(SootUtils.getSourceLocation(stmt) + " calls " + t + "\n");                                    
                                }
                            }
                        }

                    }

                }
            }
            taintCalls.close();
        } catch (Exception e) {

        }
    }
    
    private static void reportMissingAPIFieldsAndMethods() {
        try {
            FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + 
                    "generated-phantom-summary.txt");
            
            for (SootClass clz : Scene.v().getClasses()) {
                if (!(Project.v().isLibClass(clz) || Project.v().isSrcClass(clz)))
                    continue;
                //only check classes of application
                for (SootMethod method : clz.getMethods()) {
                    if (!method.isConcrete()) 
                        continue;

                    StmtBody stmtBody = (StmtBody)method.retrieveActiveBody();

                    // get body's unit as a chain
                    Chain units = stmtBody.getUnits();

                    Iterator stmtIt = units.iterator(); 

                    while (stmtIt.hasNext()) {
                        Stmt stmt = (Stmt)stmtIt.next();

                        if (stmt.containsInvokeExpr()) {
                            Set<SootMethod> targets = PTABridge.v().getTargetsInsNoContext(stmt);
                            for (SootMethod t : targets) {
                                if ((t.isPhantom() || SootUtils.isRuntimeStubMethod(t)))
                                    fw.write(String.format("Found call to phantom method %s in %s\n", t, method));
                            }
                        }

                        for (Object box : stmt.getUseAndDefBoxes()) {
                            if (box instanceof ValueBox) {
                                Value v = ((ValueBox)box).getValue();
                                if (v instanceof StaticFieldRef) {
                                    SootField f = ((StaticFieldRef)v).getField();
                                    if (f.isPhantom() && API.v().isSystemClass(f.getDeclaringClass())) {
                                        logger.warn("Reference of phantom api class field {} in {}", f, method);
                                    }
                                }
                            }
                        }
                    }

                }
            }
            fw.close();
        } catch (Exception e) {

        }
    }


    /** 
     * Is the method an autogenerated method that could not possibly be modeled.
     */
    private static boolean ignoreNotModeled(SootMethod method) {
        SootClass clz = method.getDeclaringClass();

        //ignore methods of enums that don't have the synthetic flag set for some reason
        if (SootUtils.isEnum(clz) && "values".equals(method.getName()))
            return true;

        //ignore all constructors of inner classes
        if (clz.getName().contains("$") && "<init>".equals(method.getName()))
            return true;

        return SootUtils.isSynthetic(clz) || SootUtils.isSynthetic(method);
    }

    /**
     * Check that an app method that overrides a system method is called from the modeling.  This will be a 
     * conservative check that callbacks in the application are modeled correctly.  It has the potential for 
     * false positives if there are callbacks defined by never registered. 
     */
    private static void checkHandlers(FileWriter fw) throws Exception {
        //for all user classes, check for implemented api method, and then check
        //to see if there is a call from the api (not the harness)

        Set<InvokeExpr> invokesInSystem = getAllSystemInvokes();

        fw.write("\n\nMethods overriding a system method that are not called from model: \n");

        for (SootClass clz : Scene.v().getClasses()) {
            if (!(Project.v().isLibClass(clz) || Project.v().isSrcClass(clz)))
                continue;
            //only check classes of application
            for (SootMethod method : clz.getMethods()) {
                if (method.isConcrete() && 
                        Hierarchy.isImplementedSystemMethod(method)) {

                    //if an init of a component, then ignore, because this is done in the harness
                    if (Hierarchy.isAndroidComponentClass(clz) && 
                            (method.isConstructor() || "void <clinit>()".equals(method.getSubSignature())))
                        continue;

                    //find a call to it that is not from the harness
                    boolean found = false;
                    for (SootMethod srcMeth: PTABridge.v().incomingEdgesIns(method)) {                        
                        if (API.v().isSystemMethod(srcMeth)) {
                            found = true;
                            break;
                        }
                    }

                    if (!found && !API.v().isSystemClass(method.getDeclaringClass())) {
                        fw.write(method + " overrides " + API.v().getClosestOverridenAPIMethod(method) + "\n");

                        //now search invokes in the library and see if it is called
                        List<SootMethod> couldCall = new LinkedList<SootMethod>();
                        for (InvokeExpr invoke : invokesInSystem) {
                            if (SootUtils.couldCallBasedOnTypes(invoke, method))
                                couldCall.add(JimpleRelationships.v().getEnclosingMethod(invoke));
                        }

                        if (couldCall.isEmpty()) {
                            fw.write("\tMethod not called anywhere in Android API/Runtime!\n");
                        } else {
                            fw.write("\tMethod could be called from following Android API/Runtime Methods:\n");
                            for (SootMethod m : couldCall ) 
                                fw.write("\t  " + m + "\n");
                        }
                    }
                }
            }
        }

        fw.write("\n");
    }

    /**
     * Return set of all invoke statements in system methods;
     */
    private static Set<InvokeExpr>getAllSystemInvokes() {
        Set<InvokeExpr> invokes = new HashSet<InvokeExpr>();

        for (SootClass clz : Scene.v().getClasses()) {
            for (SootMethod method : clz.getMethods()) {
                if (!API.v().isSystemMethod(method))
                    continue;

                if (!method.isConcrete()) 
                    continue;
                StmtBody stmtBody = (StmtBody)method.retrieveActiveBody();

                // get body's unit as a chain
                Chain units = stmtBody.getUnits();

                Iterator stmtIt = units.iterator(); 

                while (stmtIt.hasNext()) {
                    Stmt stmt = (Stmt)stmtIt.next();
                    if (stmt.containsInvokeExpr()) {
                        invokes.add(stmt.getInvokeExpr());
                    }
                }
            }
        }

        return invokes;
    }

    /**
     * For each virtual invoke statement check that the reference receiver of the invoke can
     * point to an actual alloc node.  If not, and the pta set is empty, it is good indication
     * that we are missing something in modeling.  Do this only for calls on api objects.  
     */
    public static void checkAllocations(FileWriter fw) throws Exception {
        //loop over all code and find calls for with any tracked as received or arg
        for (SootClass clazz : Scene.v().getApplicationClasses()) {
            if (clazz.isInterface() || clazz.getName().equals(Harness.HARNESS_CLASS_NAME) ||
                    clazz.getName().equals("edu.mit.csail.droidsafe.DroidSafeCalls"))
                continue;

            //don't add entry points into the system classes...
            if (API.v().isSystemClass(clazz))
                continue;

            for (SootMethod meth : clazz.getMethods()) {
                if (meth.isConcrete() && PTABridge.v().isReachableMethod(meth)) {
                    checkInvokes(meth, meth.retrieveActiveBody(), fw);
                }
            }
        }
    }

    /**
     * Called by checkAllocations() above to check all invoke statements of a method.  Checks 
     * virtual invokes on api objects to make sure that the receiver reference has something 
     * in its pta set.
     */
    private static void checkInvokes(SootMethod m, Body b, FileWriter fw) throws Exception {
        StmtBody stmtBody = (StmtBody)b;

        // get body's unit as a chain
        Chain units = stmtBody.getUnits();

        Iterator stmtIt = units.snapshotIterator();

        while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt)stmtIt.next();

            if (!stmt.containsInvokeExpr()) {
                continue;
            }

            InvokeExpr expr = (InvokeExpr)stmt.getInvokeExpr();


            //get the receiver, receivers are only present for instance invokes 
            InstanceInvokeExpr iie = SootUtils.getInstanceInvokeExpr(stmt);
            if (iie != null) {
                Collection<SootMethod> resolved = null;

                resolved = PTABridge.v().getTargetsInsNoContext(stmt);

                if (resolved == null || resolved.isEmpty()) 
                    fw.write(String.format
                        ("No valid allocations for receiver of %s of type %s in %s (%s).\n\n",
                            iie.getMethod(), iie.getBase().getType(), m, 
                            SootUtils.getSourceLocation(stmt, m.getDeclaringClass())));
            }
        }
    }
}
