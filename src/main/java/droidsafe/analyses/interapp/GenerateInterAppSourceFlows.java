package droidsafe.analyses.interapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import soot.jimple.Stmt;
import soot.jimple.toolkits.pta.IAllocNode;
import droidsafe.analyses.value.IntentModel;
import droidsafe.analyses.value.IntentUtils;
import droidsafe.android.app.Project;
import droidsafe.android.system.InfoKind;
import droidsafe.speclang.Method;
import droidsafe.speclang.SecuritySpecification;
import droidsafe.utils.GsonExclude;

public class GenerateInterAppSourceFlows {
    private final static Logger logger = LoggerFactory.getLogger(GenerateInterAppSourceFlows.class);
    
    private static GenerateInterAppSourceFlows v;
    private SecuritySpecification spec;
    private List<SourceFlow> flows;
    private static final String FILE_NAME = "InterAppSourceFlows.gson";
    
    private GenerateInterAppSourceFlows() {   
        flows = new ArrayList<SourceFlow>();
    }

    public static GenerateInterAppSourceFlows v() {
        if (v == null) 
            v = new GenerateInterAppSourceFlows();

        return v;
    }

    public static void reset() {
        v = null;
    }

    public void run(SecuritySpecification spec) {
        this.spec = spec;
        createSourceFlows();
        produceJSONFile();
    }

    private void createSourceFlows() {
        for (Map.Entry<Method, List<Method>> entry: spec.getEventBlocks().entrySet()) {
            for (Method oe : entry.getValue()) {
                System.out.println(oe.getSignature());
                if (SourceFlow.isSourceFlowMethodSig(oe.getSignature())) {
                    InterAppApiCall type = SourceFlow.getInterAppApiCallForSig(oe.getSignature());

                    for (int i = 0; i < oe.getNumArgs(); i++) {
                        for (Entry<InfoKind, Set<Stmt>> flow : oe.getArgSourceInfoUnitsConservative(i).entrySet()) {
                            for (IAllocNode node : oe.getArgAllocNodes(i)) {
                                IntentModel im = IntentUtils.v().getIntentModel(node);
                                List<String> srcStmts = new ArrayList<String>();
                                for (Stmt stmt : flow.getValue()) {
                                    srcStmts.add(stmt.toString());
                                }

                                SourceFlow interAppFlow = new SourceFlow(type, flow.getKey(), srcStmts, im);
                                flows.add(interAppFlow);
                                System.out.printf("Found InterApp: %s\n", interAppFlow);
                            }
                        } 
                    }                    
                }
            }
        }
    }

    private void produceJSONFile() {
        Gson gson = new GsonBuilder()
            .disableHtmlEscaping()
            .setPrettyPrinting()
            .setExclusionStrategies(new IntentModelExclusionStrategy())
            .create();
       
        String output = gson.toJson(flows);
        FileWriter fw;
        try {
            fw = new FileWriter(Project.v().getOutputDir() + File.separator + FILE_NAME);
            fw.write(output);
            fw.close();
        } catch (IOException e) {
            logger.warn("Error writing json file.", e);
        }

    }
    
    public class IntentModelExclusionStrategy implements ExclusionStrategy {

        @Override
        public boolean shouldSkipField(FieldAttributes f) {
            return f.getAnnotation(GsonExclude.class) != null;
        }

        @Override
        public boolean shouldSkipClass(Class<?> arg0) {            
            return false;
        }
      }
}
