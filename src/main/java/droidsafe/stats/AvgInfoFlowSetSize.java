package droidsafe.stats;


import soot.Context;
import soot.Local;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.toolkits.pta.IAllocNode;
import droidsafe.analyses.infoflow.InfoValue;
import droidsafe.analyses.infoflow.InformationFlowAnalysis;
import droidsafe.analyses.rcfg.OutputEvent;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.rcfg.RCFGNode;
import droidsafe.android.app.Project;
import droidsafe.utils.JimpleRelationships;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



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
                Context context = oe.getEdge().srcCtxt();
                InvokeExpr invoke = oe.getInvokeExpr();

                try {
                    Stmt enclosing = JimpleRelationships.v().getEnclosingStmt(invoke); 

                    if (invoke instanceof InstanceInvokeExpr) {
                        int thisSetSize = InformationFlowAnalysis.v().getTaints(oe.getEdge().getTgt()).size();
                        if (thisSetSize > 0) {
                            totalSetsSize += thisSetSize; 
                            totalSets++;
                        }
                    }

                    for (int i = 0; i < oe.getNumArgs(); i++) {

                        int thisSetSize = 0;
                        if (oe.isArgPointer(i)) {
                            for (IAllocNode an : oe.getArgPTSet(i)) {
                                thisSetSize += InformationFlowAnalysis.v().getTaints(an, oe.getEdge().getTgt()).size();
                            }
                        } else {
                            Set<InfoValue> taints = InformationFlowAnalysis.v().getTaints(oe.getEdge().getSrc(), 
                                (Local)oe.getArgValue(i));

                            thisSetSize += taints.size();
                            /*
                            if (thisSetSize > 0) {
                                System.out.println(oe.getEdge().getSrc());
                                System.out.println(enclosing);
                                System.out.println((Local)oe.getArgValue(i));
                                for (InfoValue iv : taints)
                                    System.out.println(iv);
                                System.out.println();
                            }
                             */
                        }
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
