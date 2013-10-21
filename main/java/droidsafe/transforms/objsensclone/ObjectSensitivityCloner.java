package droidsafe.transforms.objsensclone;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.system.API;

import soot.Body;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.jimple.AssignStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.NewExpr;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.util.Chain;

public class ObjectSensitivityCloner {
    private static final Logger logger = LoggerFactory.getLogger(ObjectSensitivityCloner.class);
    
    public static final Set<String> NAMES_TO_CLONE = new HashSet<String>(java.util.Arrays.asList(
        "android.content.Intent", "android.net.Uri"
        ));
    
    private ObjectSensitivityCloner() {
    }

    public static void run() {
        int clonedClasses = 0;
        
        List<SootClass> classes = new LinkedList<SootClass>();
        for (SootClass clz : Scene.v().getClasses()) {
            classes.add(clz);
        }
        
        //loop through all non-system classes, clone classes and replace new exprs
        for (SootClass clz : classes) {
            if (API.v().isSystemClass(clz))
                continue;
            
            for (SootMethod method : clz.getMethods()) {
                if (method.isAbstract() || !method.isConcrete())
                    continue;
                
                Body body = method.getActiveBody();
                StmtBody stmtBody = (StmtBody)body;
                Chain units = stmtBody.getUnits();
                Iterator stmtIt = units.snapshotIterator();

                while (stmtIt.hasNext()) {
                    Stmt stmt = (Stmt)stmtIt.next();
                    
                    if (stmt instanceof AssignStmt) {
                        AssignStmt assign = (AssignStmt) stmt;
                        if (assign.getRightOp() instanceof NewExpr) {
                            NewExpr oldNewExpr = (NewExpr) assign.getRightOp();
                            if (NAMES_TO_CLONE.contains(oldNewExpr.getBaseType().getClassName())) {
                                System.out.printf("Found new expr to replace and clone class: %s %s %s\n",
                                    clz, method, assign);
                                //TODO:change 2nd argument
                                SootClass cloned = 
                                        ClassCloner.cloneClass(oldNewExpr.getBaseType().getSootClass(), false);
                                clonedClasses++;
                                NewExpr newNewExpr = Jimple.v().newNewExpr(RefType.v(cloned));
                                assign.setRightOp(newNewExpr);
                                
                                //now change the constructor call that is always the next statement
                                try {
                                    Stmt constructorCallStmt = (Stmt)stmtIt.next();
                                    InvokeExpr invoke = constructorCallStmt.getInvokeExpr();
                                    if (invoke instanceof SpecialInvokeExpr) {
                                        SpecialInvokeExpr special = (SpecialInvokeExpr)invoke;
                                        SootMethodRef origMethodRef = special.getMethodRef();
                                        
                                        special.setMethodRef(Scene.v().makeMethodRef(cloned, 
                                            origMethodRef.name(), 
                                            origMethodRef.parameterTypes(), 
                                            origMethodRef.returnType(), 
                                            origMethodRef.isStatic()));                                        
                                    } else {
                                        throw new Exception("Special Invoke Not Found!");
                                    }
                                } catch (Exception e) {
                                    logger.error("Error processing constructor call after modifying new expr: {}", 
                                        stmt, e);
                                }
                                
                            }
                        }
                    }
                }
            }
        }
        System.out.printf("Finished cloning.  Added %d classes\n", clonedClasses);
    }
}
