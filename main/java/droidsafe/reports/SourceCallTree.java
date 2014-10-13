package droidsafe.reports;

import static droidsafe.reports.JSONUtils.json_call_graph_header;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.MethodOrMethodContext;
import soot.SootMethod;
import droidsafe.analyses.CallChainInfo;
import droidsafe.analyses.SourceCallChainBuilder;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.rcfg.RCFG;

/**
 * Indicator to print a forest with a call tree rooted at each user entry point.
 * 
 * @author mgordon
 *
 */
public class SourceCallTree {
    private final static Logger logger = LoggerFactory.getLogger(SourceCallTree.class);
    
    public static final String FILE_NAME = "source_call_graph.txt";
    private static int timeout = 5 * 60 * 1000;

    private static SourceCallTree v;
    private List<CallChainInfo> entry_points = new ArrayList<CallChainInfo>();
    
    private SourceCallTree() {
        forEntryPoints();
    }
    
    public static SourceCallTree v() {
        if (v == null)
            v = new SourceCallTree();
        
        return v;
    }
    
    /**
     * Loop through each entry point and calculate the call graph from that entry
     * point.  The results are placed into entry_points.
     */
    private void forEntryPoints() {
        
        for (SootMethod method : PTABridge.v().getReachableMethods()) {
            if (RCFG.isUserEntryPoint(method)) {
                logger.info ("Found entry  point {}", method);
                SourceCallChainBuilder cb = new SourceCallChainBuilder (timeout, true);
                CallChainInfo cci = cb.process_call_chain (null, method);
                if (cci != null) {
                	cci.type = "entry-point";
                	cci.link = "as_entry_point";
                	cci.calculate_scores();
                	entry_points.add (cci);
                }
            }            
        }
    }

    public void toJson(String parentDir) {
        PrintStream fp;
        try {
            fp = new PrintStream(parentDir + File.separator + FILE_NAME);
            fp.print (json_call_graph_header ("Entry Points", Collections.EMPTY_MAP));
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
