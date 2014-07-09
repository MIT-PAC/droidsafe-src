package droidsafe.reports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.SootMethod;
import soot.jimple.InvokeStmt;
import soot.jimple.Stmt;
import droidsafe.android.app.Project;
import droidsafe.android.system.InfoKind;
import droidsafe.main.Config;
import droidsafe.main.Main;
import droidsafe.speclang.Method;
import droidsafe.speclang.SecuritySpecification;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;

/**
 * Create an information flow report that lists sensitive sinks if a sensitive source
 * flows into a receiver or argument.
 * 
 * @author mgordon
 *
 */
public class InformationFlowReport {
    private static final String FILE_NAME = "info-flow-results.txt";
    private static final Logger logger = LoggerFactory.getLogger(InformationFlowReport.class);
    /**
     * Create an information flow report that lists sensitive sinks if a sensitive source
     * flows into a receiver or argument.
     *
     */
    public static void create(SecuritySpecification spec) {
        String separator = "|";
        String slash = "/";
        
        StringBuffer sb = new StringBuffer();
        //loop through all output events
        //for each output event that is a sensitive sink
        //list the sensitive sources on its receiver and each arg
        Set<String> formattedFlowSet = new HashSet<String>();

        for (Map.Entry<Method, List<Method>> eventBlock : spec.getEventBlocks().entrySet()) {
            String entryPoint = String.format("Entry Point: %s (%s)\n\n", 
                eventBlock.getKey().getSignature(), eventBlock.getKey().getDeclSourceLocation());

            StringBuffer flows = new StringBuffer();  //original report
            
            boolean hasFlow = false;

            for (Method outputEvent : eventBlock.getValue()) {
                boolean isSink = false;
                boolean hasSources = false;

                isSink = outputEvent.getSinkInfoKinds().size() > 0;
                hasSources = outputEvent.getSourcesInfoKinds().size() > 0;
                
                // no report if there is no sink
                if (!isSink)
                    continue;

                StringBuilder tmpBuilder = new StringBuilder();
                
                // format is: **|<entry-method>|<sink>/<cat>/line|rx-src|<source_rx/cat_list>|arg-src|<src_arg list
                tmpBuilder.append(eventBlock.getKey().getSignature()).append(separator);

                tmpBuilder.append("{");
                tmpBuilder.append(outputEvent.getSignature()).append(slash);
                tmpBuilder.append(outputEvent.getSinkInfoKinds().iterator().next())
                           .append(slash);
                
                boolean firstLine = true;
                for (SourceLocationTag tag : outputEvent.getLines()) {
                    if (!firstLine)
                        tmpBuilder.append(",");
                    tmpBuilder.append(tag);
                    firstLine = false;
                }
                tmpBuilder.append("}");
                tmpBuilder.append("<=");
                
                String flowPrefix = tmpBuilder.toString().replaceAll("_ds_method_clone_\\d+", "");
                
                if (hasSources) {
                    hasFlow = true;

                    flows.append(String.format("Sink: %s\n", outputEvent.getSignature()));
                    flows.append("Lines: \n");

                    /*
                    StringBuilder tmpBuilder = new StringBuilder();
                    for (SourceLocationTag tag : outputEvent.getLines()) {
                        flows.append("\t" + tag + "\n");
                        
                        if (tmpBuilder.length() > 0)
                            tmpBuilder.append(",");
                        
                        tmpBuilder.append(tag);
                    }

                    flowBuilder.append(tmpBuilder).append(separator);
                    */

                    
                    flows.append("Receiver Sources: \n");
                    for (Map.Entry<InfoKind, Set<Stmt>> source : outputEvent.getReceiverSourceInfoUnits().entrySet()) {
                        for (Stmt stmt : source.getValue()) {
                            flows.append(String.format("\t%s (%s)\n", stmt, source.getKey()));

                            /*
                            if (tmpBuilder.length() > 0)
                                tmpBuilder.append(",");
                            */
                            
                            //tmpBuilder.append(String.format("{%s%s%s}", stmt, slash, source.getKey()));
                            /*
                            for (SourceLocationTag tag : outputEvent.getLines()) {
                                if (!firstLine)
                                    flowBuilder.append(",");
                                flowBuilder.append(tag);
                                firstLine = false;
                            }
                            */
                            SourceLocationTag locationTag = SootUtils.getSourceLocation(stmt);
                            String lineNumber = "";
                            if (locationTag != null)
                                lineNumber = locationTag.toString();

                            SootMethod method = stmt.getInvokeExpr().getMethod();
                            tmpBuilder =  new StringBuilder();
                            tmpBuilder.append(String.format("{%s%s%s%s%s/%s}", 
                                    method, slash, source.getKey(), slash, lineNumber, "RECEIVER"));
                            
                            String flowLine = flowPrefix + tmpBuilder;
                            formattedFlowSet.add(flowLine);
                        }
                    }

                    for (int i = 0; i < outputEvent.getNumArgs(); i++) {
                        if (outputEvent.getArgInfoKinds(i).isEmpty())
                            continue;

                        flows.append(String.format("Arg %d Sources: \n", i));
                        for (Map.Entry<InfoKind, Set<Stmt>> source : outputEvent.getArgSourceInfoUnits(i).entrySet()) {
                            for (Stmt stmt : source.getValue()) {
                                flows.append(String.format("\t%s (%s)\n", stmt, source.getKey()));

                                SourceLocationTag locationTag = SootUtils.getSourceLocation(stmt);
                                String lineNumber = "";
                                if (locationTag != null)
                                        lineNumber = locationTag.toString();

                                SootMethod method = stmt.getInvokeExpr().getMethod();

                                tmpBuilder =  new StringBuilder();
                                tmpBuilder.append(String.format("{%s%s%s%s%s/%s}", 
                                    method, slash, source.getKey(), slash, lineNumber, "ARG"));

                                String flowLine = flowPrefix + tmpBuilder;
                                flowLine = flowLine.replaceAll("_ds_method_clone_\\d+", "");
                                formattedFlowSet.add(flowLine);
                            }
                        }
                    }
                }

            
            }

        
            if (hasFlow) {
                sb.append(entryPoint);
                sb.append(flows);
                sb.append("\n");
            }
        }

        sb.append("\n");
        for (String flow: formattedFlowSet) {
            sb.append("FLOW:").append(flow).append("\n\n");
        }
        sb.append("\n");

        boolean infoflowOK = true;
        File expectedInfoFile  = new File(Config.v().EXPECT_INFO_FLOW_FILE);
        if (Config.v().checkInfoFlow && expectedInfoFile.exists()) {
            List<String> expectedFlows = null;
            StringBuilder checkerResult = new StringBuilder();
            try {
                InputStream  expectedFile = null;
                expectedFile  = new FileInputStream(expectedInfoFile);
                expectedFlows = IOUtils.readLines(expectedFile); 
            }
            catch (Exception ex) {
                System.exit(-1);
            }
            // Now we are building set for comparision
            Set<String> expectedFlowSet = new HashSet<String>();
            Set<String> resultFlowSet = new HashSet<String>();

            checkerResult.append("\n\n========================================\n");
            checkerResult.append("Checking infoflow result against expected flows \n");
            for (String flow: expectedFlows) {
                flow = flow.replaceAll("\\s", "");
                flow = flow.replace("FLOW:", ""); 
                flow = flow.replaceAll("#.*", "");
                if (flow.length() > 0)
                    expectedFlowSet.add(flow);

            }

            for (String flow: formattedFlowSet){
                resultFlowSet.add(flow.replaceAll("\\s",  ""));
            }

            int missing = 0;
            int found = 0;
            for (String flow: expectedFlowSet) {
                if (resultFlowSet.contains(flow))
                    found++;
                else {
                    checkerResult.append("MISSING: ").append(flow).append("\n");
                    missing++;
                    infoflowOK = false;
                }
            }

            int extra = 0;
            for (String flow: resultFlowSet) {
                if (!expectedFlowSet.contains(flow)) {
                    extra++;
                    checkerResult.append("EXTRA: ").append(flow).append("\n");
                }
            }                
            sb.append(checkerResult);
            String status = "PASSED";
            if (missing > 0)
                status = "FAILED";
            
            sb.append(String.format("STATUS: %s, MATCHED: %d, MISSING: %d, EXTRA: %d \n", 
                    status, found, missing, extra));
        }

        try {
            FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + FILE_NAME);
            fw.write(sb.toString());
            fw.close();
        } catch(IOException e) {

        }
        
        if (!infoflowOK)
            System.exit(-1);
    }

}
