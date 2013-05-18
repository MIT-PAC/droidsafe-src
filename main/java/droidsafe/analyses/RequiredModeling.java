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

import droidsafe.analyses.rcfg.OutputEvent;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.rcfg.RCFGNode;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.main.Config;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;
import droidsafe.utils.Utils;
import soot.Body;
import soot.MethodOrMethodContext;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.spark.pag.AllocNode;
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
    private final static Logger logger = LoggerFactory.getLogger(RequiredModeling.class);

    /**
     * Run various checks the API modeling (concrete semantics).  Dump the results to 
     * a file in the app droidsafe directory. 
     */
    public static void run() {
        Set<String> toModel = new TreeSet<String>();

        for (SootMethod method : GeoPTA.v().getAllReachableMethods()) {
            //loop through all reachable methods, and find system methods that are not modeled
            //or system methods that do not exist (but are called)
            if (API.v().isSystemClass(method.getDeclaringClass()) && 
                    !API.v().isAPIModeledMethod(method))
                toModel.add(method.getSignature());
        }

        try {
            FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + 
                    "api-modeling-summary.txt");
            fw.write("Unmodeled Methods:\n\n");
            for (String m : toModel) {
                fw.write(m + "\n");
            }
            fw.write("\nErrors in PTA:\n\n");
            checkAllocations(fw);

            fw.write("\nFields Missing from API Modeling " +
                    "(versus abstract semantics of Value Analysis):\n\n");
            checkConcreteVSAbstractSemantics(fw);

            fw.close();
        } catch (Exception e) {
            logger.error("Cannot write required modeling file", e);
            System.exit(1);
        }
    }

    /**
     * Check that all fields defined in classes that are modeled in the abstract semantics 
     * of value analysis have a corresponding definition in the concrete semantics of the 
     * model of the API.
     */
    private static void checkConcreteVSAbstractSemantics(FileWriter fw) throws Exception {
        //for all sootlclasses, see if we have a corresponding modeling class
        for (SootClass concreteClz: Scene.v().getClasses()) {
            if (!API.v().isSystemClass(concreteClz)) 
                continue;

            Class<?> absClz = null;
            try {
                absClz = Class.forName(AttributeModeling.PACKAGE_PREFIX + "." + 
                        concreteClz.getName());
            } catch (ClassNotFoundException e) {
                //could not find class, so ignore
            }

            if (absClz != null) {
                for (Field absField : absClz.getDeclaredFields()) {
                    //did we find a match in the concrete semantics?
                    boolean matched = false;
                    //get a string representation of the type of the field 
                    //from the abstract semantics
                    String typeStr = absField.getType().getName();
                    //remove the modeling package name from the type if it exists
                    if (typeStr.startsWith(AttributeModeling.PACKAGE_PREFIX))
                        typeStr = typeStr.substring(AttributeModeling.PACKAGE_PREFIX.length() + 1);

                    //ignore logger fields
                    if ("org.slf4j.Logger".equals(typeStr)) {
                        continue;
                    }

                    //see if we find a matching field in the concrete semantics with the same name
                    //and type string
                    if (concreteClz.declaresFieldByName(absField.getName())) {
                        SootField concreteField = concreteClz.getFieldByName(absField.getName());
                        if (concreteField.getType().toString().equals(typeStr))
                            matched = true;
                    }             

                    if (!matched) {
                        fw.write(String.format("Field name: %s, type = %s, class = %s\n", 
                            absField.getName(), typeStr, concreteClz.getName()));
                    }
                }
            }

        }
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
                if (meth.isConcrete()) {
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
                SootMethod resolved = null;
                for (AllocNode node : GeoPTA.v().getPTSetContextIns(iie.getBase())) {
                    if ( node.getType() instanceof RefType ) {
                        SootClass sc = ((RefType)node.getType()).getSootClass();
                        try {
                            resolved = SootUtils.resolveConcreteDispatch(sc, iie.getMethod());
                        } catch (CannotFindMethodException e) {
                            resolved = null;
                        }
                    }
                    if (resolved != null)
                        break;
                }
                if (resolved == null) 
                    fw.write(String.format
                        ("No valid allocations for receiver of %s of type %s in %s (%s).\n\n",
                            iie.getMethod(), iie.getBase().getType(), m, 
                            SootUtils.getSourceLocation(stmt, m.getDeclaringClass())));
            }
        }
    }
}
