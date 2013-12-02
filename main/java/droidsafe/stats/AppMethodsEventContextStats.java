package droidsafe.stats;

import java.util.HashMap;
import java.util.Map;

import soot.SootMethod;
import soot.jimple.toolkits.callgraph.Edge;
import droidsafe.analyses.pta.ContextType;
import droidsafe.analyses.pta.PTAContext;
import droidsafe.analyses.pta.cg.CGContextVisitor;
import droidsafe.analyses.pta.cg.CallGraphTraversal;
import droidsafe.android.system.API;

public class AppMethodsEventContextStats implements CGContextVisitor {

    private HashMap<SootMethod,Integer> methodToContexts;
    
    public static void run() {
        new AppMethodsEventContextStats();
    }
    
    private AppMethodsEventContextStats() {
        // TODO Auto-generated constructor stub
        methodToContexts = new HashMap<SootMethod,Integer>();
        
        CallGraphTraversal.acceptContext(this, ContextType.EVENT_CONTEXT);

        createHistogramOutput();
        
    }
    
    private void createHistogramOutput() {
        int N = 21;
        int[] bins = new int[N];
        
        for (Integer value : methodToContexts.values()) {
            int v = value.intValue();
            if (v >= N)
                v = N - 1;
            bins[v]++;
        }
        
        System.out.println();
        
        for (int i = 1; i < bins.length; i++) 
            System.out.println("m-to-c-bin:" + i + ":" + bins[i]);
    }

    public void visit(SootMethod method, PTAContext eventContext) {
        if (API.v().isSystemMethod(method))
            return;
        
        if (!methodToContexts.containsKey(method)) {
            methodToContexts.put(method, 0);
        }
        
        methodToContexts.put(method, methodToContexts.get(method).intValue() + 1);
    }
}
