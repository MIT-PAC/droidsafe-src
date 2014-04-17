package droidsafe.reports;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.MethodOrMethodContext;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.rcfg.RCFG;

/**
 * Indicator to print a forest with a call tree rooted at each user entry point.
 * 
 * @author mgordon
 *
 */
public class AllEntryPointCallTree {
    private final static Logger logger = LoggerFactory.getLogger(AllEntryPointCallTree.class);
    
    private static final String FILE_NAME = "user_call_graph.json";
    
    private static AllEntryPointCallTree v;
    
    private AllEntryPointCallTree() {
        forEntryPoints();
    }
    
    public static AllEntryPointCallTree v() {
        if (v == null)
            v = new AllEntryPointCallTree();
        
        return v;
    }
    
    private void forEntryPoints() {
        for (MethodOrMethodContext momc : PTABridge.v().getReachableMethodContexts()) {
            if (RCFG.isUserEntryPoint(momc)) {
                //TODO: do something here with the fact that we have an entry point
                System.out.println("Found entry point: " + momc);
            }            
        }
    }

    public void toJson(String parentDir) {
        FileWriter fw;
        try {
            fw = new FileWriter(parentDir + File.separator + FILE_NAME);
            //TODO: write json here!
            //fw.write(output);
            fw.close();
        } catch (IOException e) {
            logger.warn("Error writing json file.", e);
        }
    }
    
}
