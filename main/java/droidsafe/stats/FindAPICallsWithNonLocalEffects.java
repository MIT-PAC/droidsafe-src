package droidsafe.stats;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.JimpleRelationships;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.Constant;
import soot.jimple.InvokeExpr;
import soot.jimple.NewExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.util.Chain;

public class FindAPICallsWithNonLocalEffects {
    private FileWriter fw;
    
    public FindAPICallsWithNonLocalEffects() {
        try {
            fw = new FileWriter(Project.v().getOutputDir() + File.separator +"non-local-api-methods.txt");
        } catch (IOException e) {
            
        }
    }
    
    public void run() {
        for (SootMethod method : PTABridge.v().getAllReachableMethods()) {
            if (API.v().isSystemMethod(method)) 
                continue;
            
            StmtBody stmtBody = (StmtBody)method.retrieveActiveBody();
            // get body's unit as a chain
            Chain<Unit> units = stmtBody.getUnits();
            // get a snapshot iterator of the unit since we are going to
            // mutate the chain when iterating over it.
            Iterator<Unit> stmtIt = units.snapshotIterator();

            while (stmtIt.hasNext()) {
                Stmt stmt = (Stmt)stmtIt.next();
                if (!stmt.containsInvokeExpr())
                    continue;
                
                InvokeExpr invoke = stmt.getInvokeExpr();
                
                try {
                    for (SootMethod target : PTABridge.v().resolveInvoke(invoke)) {
                        if (!API.v().isSystemMethod(target))
                            continue;
                        
                        SootClass targetClass = target.getDeclaringClass();
                        
                        if (stmt instanceof AssignStmt) {
                            nonLocalRef(targetClass, ((AssignStmt)stmt).getLeftOp(),
                                method, invoke, target);
                        }
                        
                        for (Value arg : invoke.getArgs()) {
                            nonLocalRef(targetClass, arg,
                                method, invoke, target);
                        }
                     
                    }
                } catch (Exception e) {
                    //ignore
                }
            }
            
        }
        try {
            fw.close();
        } catch (IOException e) {
         
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void nonLocalRef(SootClass targetClass, Value v, SootMethod caller, 
                             InvokeExpr invoke, SootMethod callee) throws Exception {
        if (!(v.getType() instanceof RefType) || v instanceof Constant)
            return;
        
        //check non local and not app
        for (IAllocNode an : PTABridge.v().getPTSet(v)) {
            if (!(an.getNewExpr() instanceof NewExpr))
                continue;
            
            SootMethod enclosingM =  
                    JimpleRelationships.v().getEnclosingMethod((NewExpr)an.getNewExpr());
            SootClass enclosingC = enclosingM.getDeclaringClass();
            
            if (!enclosingC.equals(targetClass) &&
                    !Scene.v().getActiveHierarchy().isClassSuperclassOf(enclosingC, targetClass) && 
                    API.v().isSystemMethod(enclosingM) &&
                    !PTABridge.v().shouldIgnoreForStats(enclosingC) &&
                    !PTABridge.v().shouldIgnoreForStats(targetClass)) {
                fw.write(String.format("%s calls %s with %s and returns / arg from %s\n\n", 
                    caller, callee, invoke, enclosingC));
            }
        }
    }
    
}
