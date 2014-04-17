package droidsafe.reports;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.MethodOrMethodContext;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.android.system.API;

/**
 * Indicator to print a forest with a call tree rooted at each user entry point.
 * 
 * @author mgordon
 *
 */
public class ICCEntryPointCallTree {
    private final static Logger logger = LoggerFactory.getLogger(ICCEntryPointCallTree.class);
    
    private static final String FILE_NAME = "icc_entry_points.json";
    
    private static ICCEntryPointCallTree v;
    
    private ICCEntryPointCallTree() {
        forEntryPoints();
    }
    
    public static ICCEntryPointCallTree v() {
        if (v == null)
            v = new ICCEntryPointCallTree();
        
        return v;
    }
    
    private void forEntryPoints() {
        for (MethodOrMethodContext momc : PTABridge.v().getReachableMethodContexts()) {
            if (!API.v().isSystemMethod(momc.method()) && API.v().isIPCCallback(momc.method())) {
                //TODO: do something here for each momc
                System.out.println("Found ICC entry point: " + momc);
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
