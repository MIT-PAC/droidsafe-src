package droidsafe.reports;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import soot.SootMethod;
import soot.jimple.InvokeStmt;
import soot.jimple.Stmt;
import droidsafe.android.app.Project;
import droidsafe.android.system.InfoKind;
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

        for (Map.Entry<Method, List<Method>> eventBlock : spec.getEventBlocks().entrySet()) {
            String entryPoint = String.format("Entry Point: %s (%s)\n\n", 
                eventBlock.getKey().getSignature(), eventBlock.getKey().getDeclSourceLocation());

            StringBuffer flows = new StringBuffer();
            boolean hasFlow = false;

         
            
            for (Method outputEvent : eventBlock.getValue()) {
                boolean isSink = false;
                boolean hasSources = false;

                isSink = outputEvent.getSinkInfoKinds().size() > 0;
                hasSources = outputEvent.getSourcesInfoKinds().size() > 0;
                
                // no report if there is no sink
                if (!isSink)
                    continue;

                StringBuilder flowBuilder = new StringBuilder();
                
                // format is: **|<entry-method>|<sink>/<cat>/line|rx-src|<source_rx/cat_list>|arg-src|<src_arg list
                flowBuilder.append("**").append(separator);
                flowBuilder.append(eventBlock.getKey().getSignature()).append(separator);

                flowBuilder.append("{");
                flowBuilder.append(outputEvent.getSignature()).append(slash);
                flowBuilder.append(outputEvent.getSinkInfoKinds().iterator().next())
                           .append(slash);
                
                boolean firstLine = true;
                for (SourceLocationTag tag : outputEvent.getLines()) {
                    if (!firstLine)
                        flowBuilder.append(",");
                    flowBuilder.append(tag);
                    firstLine = false;
                }
                flowBuilder.append("}");
                flowBuilder.append(separator);
                
                flowBuilder.append("sources").append(separator);
                
                
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

                    flowBuilder.append("receivers").append(separator);
                    StringBuilder tmpBuilder =  new StringBuilder();
                    
                    flows.append("Receiver Sources: \n");
                    for (Map.Entry<InfoKind, Set<Stmt>> source : outputEvent.getReceiverSourceInfoUnits().entrySet()) {
                        for (Stmt stmt : source.getValue()) {
                            flows.append(String.format("\t%s (%s)\n", stmt, source.getKey()));

                            if (tmpBuilder.length() > 0)
                                tmpBuilder.append(",");
                            
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
                            tmpBuilder.append(String.format("{%s%s%s%s%s}", 
                                    method, slash, source.getKey(), slash, lineNumber));
                                   
                        }
                    }

                    flowBuilder.append(tmpBuilder).append(separator);

                    flowBuilder.append("args").append(separator);
                    tmpBuilder =  new StringBuilder();
                    
                    for (int i = 0; i < outputEvent.getNumArgs(); i++) {
                        if (outputEvent.getArgInfoKinds(i).isEmpty())
                            continue;

                        flows.append(String.format("Arg %d Sources: \n", i));
                        for (Map.Entry<InfoKind, Set<Stmt>> source : outputEvent.getArgSourceInfoUnits(i).entrySet()) {
                            for (Stmt stmt : source.getValue()) {
                                flows.append(String.format("\t%s (%s)\n", stmt, source.getKey()));
                                if (tmpBuilder.length() > 0)
                                    tmpBuilder.append(",");
                                /*

                                tmpBuilder.append(String.format("{%s%s%s}", stmt, slash, source.getKey()));
                                */
                                SourceLocationTag locationTag = SootUtils.getSourceLocation(stmt);
                                String lineNumber = "";
                                if (locationTag != null)
                                        lineNumber = locationTag.toString();

                                SootMethod method = stmt.getInvokeExpr().getMethod();
                                tmpBuilder.append(String.format("{%s%s%s%s%s}", 
                                    method, slash, source.getKey(), slash, lineNumber));
                                /*
                                tmpBuilder.append(String.format("{%s%s%s%s%s}", 
                                    stmt, slash, source.getKey(), slash, lineNumber));
                                */
                            }
                        }
                    }

                    flowBuilder.append(tmpBuilder);

                    /*
                    flows.append("Method accesses: \n");
                    for (Map.Entry<InfoKind, Set<Stmt>> source : outputEvent.getMethodInfoKinds().entrySet()) {
                        for (Stmt stmt : source.getValue()) {
                            flows.append(String.format("\t%s (%s)\n", stmt, source.getKey()));
                        }
                    }
                     */
                }
                else {
                    flowBuilder.append("NONE");
                }

                sb.append(flowBuilder).append("\n\n");
            }

            if (hasFlow) {
                sb.append(entryPoint);
                sb.append(flows);
                sb.append("\n");
            }

        }

        try {
            FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + FILE_NAME);
            fw.write(sb.toString());
            fw.close();
        } catch(IOException e) {

        }
    }

}
