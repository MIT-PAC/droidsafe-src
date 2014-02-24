package droidsafe.stats;

import droidsafe.analyses.infoflow.InformationFlowAnalysis;
import droidsafe.analyses.pta.ContextType;
import droidsafe.analyses.pta.PTAContext;
import droidsafe.analyses.rcfg.OutputEvent;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.rcfg.RCFGNode;
import droidsafe.android.app.Project;
import droidsafe.utils.JimpleRelationships;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.Local;


public class AvgInfoFlowSetSize {

    /** Logger class */
    private static final Logger logger = LoggerFactory.getLogger(AvgInfoFlowSetSize.class);


    private long totalSets = 0;
    private long totalSetsSize = 0;

    public static void run() {
        new AvgInfoFlowSetSize();
    }

    private AvgInfoFlowSetSize() {
        
        
        for (RCFGNode inputNode : RCFG.v().getNodes()) {
            
            for (OutputEvent oe : inputNode.getOutputEvents()) {
                PTAContext context = oe.getContext(ContextType.EVENT_CONTEXT);
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
        PrintWriter out = null;
        try {
            out = new PrintWriter(Project.v().getOutputDir() + File.separator + "info-set-size.txt");
            out.println(totalSets + " " + totalSetsSize);
        } catch (IOException e) {
            logger.warn("Couldn't write out high level flows num to high-level.txt: "+ e);
        } finally {
            out.close();
        }

   
        System.out.println(":Total Info Sets:" + totalSets);
        System.out.println(":Total Sets Size:" + totalSetsSize);
    }


}
