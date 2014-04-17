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
public class IPCEntryPointCallTree {
    private final static Logger logger = LoggerFactory.getLogger(IPCEntryPointCallTree.class);
    
    private static final String FILE_NAME = "ipc_entry_points.json";
    
    private static IPCEntryPointCallTree v;
    
    private IPCEntryPointCallTree() {
        forEntryPoints();
    }
    
    public static IPCEntryPointCallTree v() {
        if (v == null)
            v = new IPCEntryPointCallTree();
        
        return v;
    }
    
    private void forEntryPoints() {
        for (MethodOrMethodContext momc : PTABridge.v().getReachableMethodContexts()) {
            if (!API.v().isSystemMethod(momc.method()) && API.v().isRemoteIPCCallback(momc.method())) {
                //TODO: do something here for each momc
                System.out.println("Found IPC entry point: " + momc);
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
