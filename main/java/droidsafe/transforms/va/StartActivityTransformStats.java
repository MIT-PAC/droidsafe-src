package droidsafe.transforms.va;

import au.com.bytecode.opencsv.CSVWriter;
import droidsafe.analyses.value.IntentType;
import droidsafe.analyses.value.IntentUtils;
import droidsafe.analyses.value.RefVAModel;
import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.analyses.value.VAModel;
import droidsafe.android.app.Project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.toolkits.pta.IAllocNode;
import soot.SootField;
import soot.Type;

/**
 * @author dpetters
 */

public class StartActivityTransformStats {

    private static final Logger logger = LoggerFactory.getLogger(StartActivityTransformStats.class);

    // field for allocNodes of intents used to start activities in the last run of the StartActivityTransform  
    private static Set<IAllocNode> intentAllocNodes;

    // singleton
    private static StartActivityTransformStats v;

    // private constructor to enforce singleton pattern
    private StartActivityTransformStats() {}

    public static void run() {

        if (true) {
            logger.warn("StartActivityTransformStats is not working and is disabled. Do not run, exiting...");
           return;
        }
        
        // create singleton
        if(v==null) {
            v = new StartActivityTransformStats();
        }

        // get allocNodes of Intents used to start activities in the last run of the startActivityTransform
        intentAllocNodes = IntentUtils.v().getAllQueriedIntents();
        
        if(intentAllocNodes==null) {
            logger.error("StartActivityTranform must always run before StartActivityTransformStats");
            System.exit(1);
        }

        CSVWriter writer = null; 
        try {
            writer = new CSVWriter(new FileWriter(Project.v().getOutputDir() + File.separator + "icc-stats.csv"));
        } catch(Exception e) {
            logger.warn("Unable to open icc-stats.csv: {}", e);
            System.exit(1);
        }

        // write out headers for columns
        writer.writeNext(new String[] {"AllocNode", "Type", "# of targets", "# of targets (without data)", "# targets in-app"});

        List<String> rowEntries = null;
        for(IAllocNode intentAllocNode : intentAllocNodes) {
            if(rowEntries != null && rowEntries.size() > 0) {
                // write out all columns
                writer.writeNext(rowEntries.toArray(new String[] {}));
            }
            rowEntries = new ArrayList<String>();

            // column #1 - allocNode
            rowEntries.add(intentAllocNode.toString());

            if(ValueAnalysis.v().hasResult(intentAllocNode)) {
                VAModel vaModel = ValueAnalysis.v().getResult(intentAllocNode);
                if(vaModel != null && vaModel instanceof RefVAModel) {
                    RefVAModel intentRefVAModel = (RefVAModel)vaModel;
                    IntentType intentType = IntentUtils.v().getIntentType(intentRefVAModel);
                    Set<String> targetClsStrings = null;
                    switch(intentType) {
                        case IMPLICIT:
                            // column #2 - type
                            rowEntries.add("IMPLICIT");
                            // column #3 - # of possible targets
                            if(IntentUtils.v().isImplicitIntentTargettingAmbiguous(intentRefVAModel, true)) {
                                rowEntries.add("UNKNOWN");
                            } else {
                                rowEntries.add("n/a");
                            }
                            // column #4 - # of possible targets (without data)
                            if(IntentUtils.v().isImplicitIntentTargettingAmbiguous(intentRefVAModel, false)) {
                                rowEntries.add("UNKNOWN");
                            } else {
                                rowEntries.add("n/a");
                            }
                            break;
                        case EXPLICIT:
                            // column #2 - type
                            rowEntries.add("EXPLICIT");
                            // column #3 - # of possible targets
                            targetClsStrings = IntentUtils.v().getExplicitIntentTargetClsStrings(null, intentRefVAModel);
                            if(targetClsStrings == null) {
                                rowEntries.add("UNKNOWN");
                                // the without data column is identical for explicit intents
                                rowEntries.add("UNKNOWN");
                            } else {
                                String targetClsStringsCount = Integer.toString(targetClsStrings.size());
                                rowEntries.add(targetClsStringsCount);
                                // the without data column is identical for explicit intents
                                rowEntries.add(targetClsStringsCount);
                            }
                            break;
                        default:
                            // column #2 - type
                            rowEntries.add("UNKNOWN");
                            // column #3 - # of targets
                            rowEntries.add("UNKNOWN");
                            // column #4 - # of targets (without data)
                            rowEntries.add("UNKNOWN");
                            break;
                    }
                    // column #5 - # of possible targets in-app
                    if(intentType == IntentType.IMPLICIT) {
                         targetClsStrings = IntentUtils.v().getImplicitIntentInAppTargetClsStrings(null, intentRefVAModel);
                    }
                    Set<SootField> targetHarnessFlds = IntentUtils.v().getHarnessFldsForClsStrings(targetClsStrings);
                    if(targetHarnessFlds == null) {
                        rowEntries.add("UNKNOWN");
                    } else {
                        rowEntries.add(Integer.toString(targetHarnessFlds.size()));
                    }
                    continue;
                }
            }

            // column #2 - type
            rowEntries.add("UNKNOWN");
            // column #3 - # of targets
            rowEntries.add("UNKNOWN");
            // column #4 - # of targets (without data)
            rowEntries.add("UNKNOWN");
            // column #5 - # of targets in-app
            rowEntries.add("UNKNOWN");
        }
     
        if(rowEntries != null && rowEntries.size() > 0) {
                // write out all columns
                writer.writeNext(rowEntries.toArray(new String[] {}));
            }

        try {
            writer.close();
        } catch(IOException ie) {
            logger.warn("Unable to close icc-stats.log: {}", ie);
        }
    }
}
