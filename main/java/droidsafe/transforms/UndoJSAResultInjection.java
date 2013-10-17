package droidsafe.transforms;

import java.util.Map;

import soot.jimple.InvokeExpr;

import soot.Value;

/* 
 * @author dpetters
 */
public class UndoJSAResultInjection {

    public static void run() {
        for(Map.Entry<InvokeExpr, Map<Integer, Value>> entry : JSAResultInjection.changesMade.entrySet()){
            InvokeExpr expr = entry.getKey();
            Map<Integer, Value> mod = entry.getValue();
            for(Map.Entry<Integer, Value> modEntry : mod.entrySet()) {
                expr.setArg(modEntry.getKey(), modEntry.getValue());
            }
        }
    }
}

