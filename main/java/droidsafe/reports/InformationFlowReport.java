package droidsafe.reports;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import soot.jimple.Stmt;
import droidsafe.android.app.Project;
import droidsafe.android.system.InfoKind;
import droidsafe.speclang.Method;
import droidsafe.speclang.SecuritySpecification;
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

                if (isSink && hasSources) {
                    hasFlow = true;

                    flows.append(String.format("Sink: %s\n", outputEvent.getSignature()));
                    flows.append("Lines: \n");

                    for (SourceLocationTag tag : outputEvent.getLines()) {
                        flows.append("\t" + tag + "\n");
                    }

                    flows.append("Receiver Sources: \n");
                    for (Map.Entry<InfoKind, Set<Stmt>> source : outputEvent.getReceiverSourceInfoUnits().entrySet()) {
                        for (Stmt stmt : source.getValue()) {
                            flows.append(String.format("\t%s (%s)\n", stmt, source.getKey()));
                        }
                    }

                    for (int i = 0; i < outputEvent.getNumArgs(); i++) {
                        if (outputEvent.getArgInfoKinds(i).isEmpty())
                            continue;

                        flows.append(String.format("Arg %d Sources: \n", i));
                        for (Map.Entry<InfoKind, Set<Stmt>> source : outputEvent.getArgSourceInfoUnits(i).entrySet()) {
                            for (Stmt stmt : source.getValue()) {
                                flows.append(String.format("\t%s (%s)\n", stmt, source.getKey()));
                            }
                        }
                    }

                    /*
                    flows.append("Method accesses: \n");
                    for (Map.Entry<InfoKind, Set<Stmt>> source : outputEvent.getMethodInfoKinds().entrySet()) {
                        for (Stmt stmt : source.getValue()) {
                            flows.append(String.format("\t%s (%s)\n", stmt, source.getKey()));
                        }
                    }
                     */
                }

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
