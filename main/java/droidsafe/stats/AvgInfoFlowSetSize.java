package droidsafe.stats;

import java.util.HashMap;
import java.util.Iterator;

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
import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.helper.CGVisitorEntryContext;
import droidsafe.analyses.helper.CallGraphTraversal;
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
                Edge context = oe.getContextEdge();
                InvokeExpr invoke = oe.getInvokeExpr();

                try {
                    Stmt enclosing = JimpleRelationships.v().getEnclosingStmt(invoke); 
                    
                    if (invoke instanceof InstanceInvokeExpr) {
                        totalSetsSize += InformationFlowAnalysis.v().getTaintsBeforeRecursively(context, 
                            enclosing, (Local)((InstanceInvokeExpr)invoke).getBase()).size();
                        totalSets++;
                    }
                    
                    for (int i = 0; i < oe.getNumArgs(); i++) {
                        totalSetsSize += InformationFlowAnalysis.v().getTaintsBeforeRecursively(context, 
                            enclosing, (Local)invoke.getArg(i)).size();
                        totalSets++;
                    }
                    
                    
                } catch (Exception e) {

                }
            }
        }
        
        System.out.println(":Total Info Sets:" + totalSets);
        System.out.println(":Total Sets Size:" + totalSetsSize);
    }


}
