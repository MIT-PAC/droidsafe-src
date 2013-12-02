package droidsafe.transforms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.BodyTransformer;
import soot.Local;
import soot.NormalUnitPrinter;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Unit;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.Jimple;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;
import soot.util.Chain;
import droidsafe.android.app.Project;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;

/**
 * Transformation called on all application classes that finds all invocations
 * of Uri.parse(String) and replaces them with new Uri (String). This
 * replacement moves the allocation from a central place (Uri.parse) into the
 * application code so that the points to results can be more precise
 * 
 * This should be extended to support a variety of different calls for which we
 * would like to hoist their allocations into the application. But for now it is
 * specific to Uri.parse()
 *
 * @author jhp
 */
public class HoistAllocations extends BodyTransformer {

    /** Logging field */
    private static final Logger logger = LoggerFactory.getLogger(HoistAllocations.class);

    /** Enable/Disable the transformation **/
    static boolean enabled = true;
    
    /** Modify all instances of Uri.parse(String) with new Uri(String) **/
    public static void run() {

        if (!enabled) return;
        
        // Currently hardcoded to URI.parse, this is the beginnings of 
        // a more generic approach
        if (false) {
            // Get all of the android classes and find the methods to be hoisted
            List<SootClass> android_classes = SootUtils.get_android_classes();
            for (SootClass clz : android_classes) {
                for (SootMethod meth : clz.getMethods()) {
                    List<Tag> tlist = meth.getTags();
                    for (Tag tag : tlist) {
                        if (!(tag instanceof VisibilityAnnotationTag))
                            continue;
                        VisibilityAnnotationTag vtag = (VisibilityAnnotationTag) tag;
                        for (AnnotationTag a : vtag.getAnnotations())
                        logger.info ("tag for method {} = {}, {}", meth.getName(), a.getName(), a.getType());
                    }
                    logger.info("tags for method {} = {}", meth.getName(), tlist);
                }
            }
        }
        
        List<SootClass> app_classes = SootUtils.get_app_classes();
        
        // call the transformation on each method
        HoistAllocations transformer = new HoistAllocations();
        for (SootClass clz : Scene.v().getClasses()) {
            if (Project.v().isSrcClass(clz.toString())) {
                logger.info("processing class {}", clz);
                for (SootMethod meth : clz.getMethods()) {
                    if (meth.isConcrete()) {
                        List<Unit> orig_chain = null;
                        if (logger.isInfoEnabled()) {
                          Body b = meth.retrieveActiveBody();
                          orig_chain = new ArrayList<Unit>();
                          orig_chain.addAll (b.getUnits());
                        }
                        transformer.transform(meth.retrieveActiveBody());
                        log_diffs (logger, orig_chain, meth);
                    }
                }
            }
        }
    }

    /**
     * Logs any differences between the original instructions and the new instructions.
     * Does nothing if the instructions are the same.
     * 
     * @param log Logger to use
     * @param orig_chain A copy of the chain of jimple instructions of the method
     * @param meth The method after any transformation
     */
    public static void log_diffs (Logger log, List<Unit> orig_chain, SootMethod meth) {
        
      if (!log.isInfoEnabled()) return;
      
      Chain<Unit> new_chain = meth.getActiveBody().getUnits();
      boolean modified = new_chain.size() != orig_chain.size();
      if (!modified) {
          Iterator<Unit> newit = new_chain.iterator();
          for (Unit orig_u : orig_chain) {
              Unit new_u = newit.next();
              modified = orig_u != new_u;
              if (modified)
                  break;
          }
      }
      if (modified) {
          log.info("Modified method {}", meth.getName());
          log.info("Original Method:");
          for (Unit u : orig_chain)
              log.info ("  {}", u);
          log.info("New Method");
          for (Unit u : new_chain) {
              log.info("  {}", u);
          }
      }
    }
    

    /** 
     * Modifies the specified method body to replace all calls to Uri.parse(String)
     * with new Uri(String).  This ensures that the allocation of the Uri is
     * unique
     */
    protected void internalTransform(Body b, String phaseName, Map options) {
        StmtBody stmtBody = (StmtBody) b;
        Chain<Unit> units = stmtBody.getUnits();

        // need a snapshot iterator since we want to mutate while iterating
        Iterator<Unit> stmtIt = units.snapshotIterator();

        NormalUnitPrinter nup = new NormalUnitPrinter(b);

        while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt) stmtIt.next();

            // we only care about invoke expressions
            if (!stmt.containsInvokeExpr()) {
                continue;
            }

            InvokeExpr expr = (InvokeExpr) stmt.getInvokeExpr();

            // we're at jimple's level so everything should be an AssignStmt
            AssignStmt assignStmt = null;
            if (stmt instanceof AssignStmt) {
                assignStmt = (AssignStmt) stmt;
            } else {
                continue;
            }

            inspectAndReplaceCalls(units, assignStmt, expr);
        }
    }

    /**
     * Internal method that will inspect the invoke expression to see if it is
     * one of the calls we want to replace. If it is, then perform the
     * replacement.
     */
    protected boolean inspectAndReplaceCalls(Chain<Unit> units, AssignStmt stmt,
            InvokeExpr expr) {

        Jimple jv = Jimple.v();
        Scene sv = Scene.v();

        // Only process calls we want to replace (currently only Uri.parse)
        SootMethodRef smr = expr.getMethodRef();
        if (!smr.getSignature().equals(
                "<android.net.Uri: android.net.Uri parse(java.lang.String)>"))
            return (false);

        // Get the local variable where the result is stored
        Local var = (Local) stmt.getLeftOp();

        // allocate the Uri
        RefType type = RefType.v("android.net.Uri");
        Value alloc_expr = jv.newNewExpr(type);
        AssignStmt alloc_stmt = jv.newAssignStmt(var, alloc_expr);

        // Call the constructor with the string parameter to parse
        SootMethod uri_init_sm = sv
                .getMethod("<android.net.Uri: void <init>(java.lang.String)>");
        Value uri_str_arg = expr.getArgs().get(0);
        SpecialInvokeExpr uri_init_sie = jv.newSpecialInvokeExpr(var,
                uri_init_sm.makeRef(), uri_str_arg);
        InvokeStmt uri_init_stmt = jv.newInvokeStmt(uri_init_sie);
        // logger.info("invoke stmt = {}", uri_init_stmt);

        // Add in the new allocation and call to the constructor and remove the
        // old parse call
        units.insertBefore(alloc_stmt, stmt);
        units.insertBefore(uri_init_stmt, stmt);
        units.remove(stmt);

        return (true);
    }

}
