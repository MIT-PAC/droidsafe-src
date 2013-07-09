package droidsafe.transforms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.ArrayType;
import soot.Body;
import soot.BodyTransformer;
import soot.Hierarchy;
import soot.Local;
import soot.Modifier;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootFieldRef;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.Type;
import soot.ValueBox;
import soot.jimple.AssignStmt;
import soot.jimple.CastExpr;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.NewExpr;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.StringConstant;
import soot.jimple.internal.JAssignStmt;
import soot.jimple.internal.JNewExpr;
import soot.util.Chain;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.main.Config;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;

/**
 * 
 * 
 * @author mgordon
 *
 */
public class InsertDSTaintAllocs extends BodyTransformer {
    /** Logger field */
    private final static Logger logger = LoggerFactory.getLogger(InsertDSTaintAllocs.class);
    /** Set of generated new expressions */
    private Set<NewExpr> generatedExpr;
    private Set<Stmt> generatedStmts;
    /** singleton object for this transformation */
    private static InsertDSTaintAllocs v;
    
    private RefType dsTaintClassRef;
    private static int localID = 0;

    /**
     * Call this pass on all application classes in the project.
     */
    public static void run() {

        v = new InsertDSTaintAllocs();


        for (SootClass clz : Scene.v().getClasses()) {
            //do nothing for Object or the taint object itself
            if ("droidsafe.helpers.DSTaintObject".equals(clz.getName()) ||
                    "java.lang.Object".equals(clz.getName()))
                continue;
            
            for (SootMethod meth : clz.getMethods()) {
                if (meth.isConcrete())
                    v.transform(meth.retrieveActiveBody());
            }
        }

    }

    public static InsertDSTaintAllocs v() {
        return v;
    }

    public boolean isGeneratedExpr(Object expr) {
        return generatedExpr.contains(expr);
    }

    private InsertDSTaintAllocs() {
        this.generatedExpr = new LinkedHashSet<NewExpr>();
        this.generatedStmts = new LinkedHashSet<Stmt>();
        SootClass objClass = Scene.v().getSootClass("java.lang.Object");
        SootClass dsTaintClass = Scene.v().getSootClass("droidsafe.helpers.DSTaintObject");
        dsTaintClassRef = RefType.v(dsTaintClass);
    }


    protected void internalTransform(Body b, String phaseName, Map options)  {
        StmtBody stmtBody = (StmtBody)b;

        // get body's unit as a chain
        Chain<Unit> units = stmtBody.getUnits();

        // get a snapshot iterator of the unit since we are going to
        // mutate the chain when iterating over it.
        Iterator<Unit> stmtIt = units.snapshotIterator();

        while (stmtIt.hasNext()) {

            Stmt stmt = (Stmt)stmtIt.next();

            if (stmt instanceof AssignStmt &&
                    ((AssignStmt)stmt).getRightOp() instanceof NewExpr) {
                AssignStmt origAssign = (AssignStmt)stmt;
                //TODO: Might want to limit this transformation to only new expressions of API classes.
                NewExpr origNewExpr = (NewExpr)origAssign.getRightOp();
                
                Local local = Jimple.v().newLocal("_dstaint_" + localID++, dsTaintClassRef);
                stmtBody.getLocals().add(local);
              
                NewExpr newExpr = Jimple.v().newNewExpr(dsTaintClassRef);  
                generatedExpr.add(newExpr);
              
                AssignStmt assignStmt = Jimple.v().newAssignStmt(local, newExpr);
                units.insertAfter(assignStmt, stmt);
                generatedStmts.add(assignStmt);
                
                RefType type = origNewExpr.getBaseType();
                SootFieldRef dsTaintFieldRef = Scene.v().makeFieldRef(type.getSootClass(), "taint", 
                    dsTaintClassRef, false);
                
                InstanceFieldRef taintFieldAccess = 
                        Jimple.v().newInstanceFieldRef(origAssign.getLeftOp(), dsTaintFieldRef);
                
                AssignStmt getTaintField = Jimple.v().newAssignStmt(taintFieldAccess, local);
                generatedStmts.add(getTaintField);
                units.insertAfter(getTaintField, assignStmt);
            } else {
                //warn if we find a new expression not in an assignment expression
                for (Object box : stmt.getUseAndDefBoxes()) {
                    if (box instanceof ValueBox &&
                            ((ValueBox)box).getValue() instanceof JNewExpr) {
                        logger.warn("Found a new expression outside of an assignment expression. " +
                        		"Adding DSTaint object is confused: {}", stmt);
                    }
                }
            }
        }
    }

}

