package droidsafe.reports;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.MethodOrMethodContext;
import droidsafe.analyses.CallChainBuilder;
import droidsafe.analyses.CallChainInfo;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.rcfg.RCFG;
import static droidsafe.reports.JSONUtils.*;

/**
 * Indicator to print a forest with a call tree rooted at each user entry point.
 * 
 * @author mgordon
 *
 */
public class AllEntryPointCallTree {
    private final static Logger logger = LoggerFactory.getLogger(AllEntryPointCallTree.class);
    
    private static final String FILE_NAME = "user_call_graph.json";
    private static int timeout = 5 * 60 * 1000;

    private static AllEntryPointCallTree v;
    private List<CallChainInfo> entry_points = new ArrayList<CallChainInfo>();
    
    // types of calls
    private static Map<String,Boolean> visibility_map = new LinkedHashMap<String,Boolean>();
    static {
        visibility_map.put ("call-chain", true);
        visibility_map.put ("syscall", true);
    }
    
    private AllEntryPointCallTree() {
        forEntryPoints();
    }
    
    public static AllEntryPointCallTree v() {
        if (v == null)
            v = new AllEntryPointCallTree();
        
        return v;
    }
    
    /**
     * Loop through each entry point and calculate the call graph from that entry
     * point.  The results are placed into entry_points.
     */
    private void forEntryPoints() {
        
        for (MethodOrMethodContext momc : PTABridge.v().getReachableMethodContexts()) {
            if (RCFG.isUserEntryPoint(momc)) {
                logger.info ("Found entry  point {}", momc);
                CallChainBuilder cb = new CallChainBuilder (timeout, true);
                CallChainInfo cci = cb.process_call_chain (null, momc);
                cci.type = "entry-point";
                cci.link = "as_entry_point";
                cci.calculate_scores();
                entry_points.add (cci);
            }            
        }
    }

    public void toJson(String parentDir) {
        PrintStream fp;
        try {
            fp = new PrintStream(parentDir + File.separator + FILE_NAME);
            fp.print (json_call_graph_header ("Entry Points", visibility_map));
            for (CallChainInfo cci : entry_points) {
                cci.dump_json (fp, "  ");
                fp.print(",");
            }
            fp.println ("  {}\n]}");
            fp.close();
        } catch (IOException e) {
            logger.warn("Error writing json file.", e);
        }
    }
    
}
