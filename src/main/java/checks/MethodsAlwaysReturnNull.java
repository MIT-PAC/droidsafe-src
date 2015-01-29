package checks;

import java.util.Iterator;

import soot.Body;
import soot.PrimType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.VoidType;
import soot.jimple.NullConstant;
import soot.jimple.ReturnStmt;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.util.Chain;

public class MethodsAlwaysReturnNull {

    public static void run() {
        for (SootClass clz : Scene.v().getClasses()) {
            for (SootMethod method : clz.getMethods()) {
                if (!method.isConcrete() || method.isAbstract()) 
                    continue;
                
                if (method.getReturnType() instanceof PrimType ||
                        method.getReturnType() instanceof VoidType)
                    continue;
                
                method.retrieveActiveBody();

                Body body = method.getActiveBody();
                StmtBody stmtBody = (StmtBody)body;
                Chain units = stmtBody.getUnits();
                Iterator stmtIt = units.iterator();

                int returns = 0;
                int returnNull = 0;
                
                while (stmtIt.hasNext()) {
                    Stmt stmt = (Stmt)stmtIt.next();

                    if (stmt instanceof ReturnStmt) {
                        returns++;
                        
                        if (((ReturnStmt)stmt).getOp() instanceof NullConstant)
                            returnNull++;
                    }
                }
                
                if (returns > 0 && returns == returnNull)
                    System.out.println("Only return null: " + method);
            }
        }
        
    }

}
