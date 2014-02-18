package droidsafe.stats;

import java.util.HashMap;
import java.util.Iterator;

import soot.Context;
import soot.Local;
import soot.SootMethod;
import soot.Unit;
import soot.ValueBox;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.toolkits.callgraph.Edge;
import soot.util.Chain;
import droidsafe.analyses.infoflow.InformationFlowAnalysis;
import droidsafe.analyses.rcfg.OutputEvent;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.rcfg.RCFGNode;
import droidsafe.android.system.API;
import droidsafe.utils.JimpleRelationships;

public class AvgInfoFlowSetSize {

    private long totalSets = 0;
    private long totalSetsSize = 0;

    public static void run() {
        new AvgInfoFlowSetSize();
    }

    private AvgInfoFlowSetSize() {
        
        
        for (RCFGNode inputNode : RCFG.v().getNodes()) {
            
            for (OutputEvent oe : inputNode.getOutputEvents()) {
                Context context = oe.getEdge().srcCtxt();
                InvokeExpr invoke = oe.getInvokeExpr();

                try {
                    Stmt enclosing = JimpleRelationships.v().getEnclosingStmt(invoke); 
                    
                    if (invoke instanceof InstanceInvokeExpr) {
                        int thisSetSize = InformationFlowAnalysis.v().getTaintsBeforeRecursively(context, 
                            enclosing, (Local)((InstanceInvokeExpr)invoke).getBase()).size();
                        if (thisSetSize > 0) {
                            totalSetsSize += thisSetSize; 
                            totalSets++;
                        }
                    }
                    
                    for (int i = 0; i < oe.getNumArgs(); i++) {
                        int thisSetSize = InformationFlowAnalysis.v().getTaintsBeforeRecursively(context, 
                            enclosing, (Local)invoke.getArg(i)).size();
                        if (thisSetSize > 0) {
                            totalSetsSize += thisSetSize; 
                            totalSets++;
                        }
                    }
                    
                    
                } catch (Exception e) {

                }
            }
        }
        
        System.out.println(":Total Info Sets:" + totalSets);
        System.out.println(":Total Sets Size:" + totalSetsSize);
    }


}
