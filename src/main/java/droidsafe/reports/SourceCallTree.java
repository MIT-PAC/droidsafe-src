package droidsafe.reports;

import static droidsafe.reports.JSONUtils.json_call_graph_header;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.SootMethod;
import droidsafe.analyses.SourceCallChainBuilder;
import droidsafe.analyses.SourceCallChainInfo;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.rcfg.RCFG;

/**
 * Print a forest with a source call tree rooted at each user entry point.
 * Used for displaying the source call graph in the Droidsafe Eclipse plugin.  The source call
 * graph is context insensitive, it is computed using callapsed call graph.
 * 
 */
public class SourceCallTree {
    private final static Logger logger = LoggerFactory.getLogger(SourceCallTree.class);
 
    // The file extension is not .json, so it is not treated as an indicator by the Eclipse plugin.
    /**
     * The name of the output Json file.
     */
    public static final String FILE_NAME = "source_call_graph.txt";
    private static int timeout = 5 * 60 * 1000;

    /**
     * The singleton instance of SourceCallTree.
     */
    private static SourceCallTree v;

    /**
     * List of source call trees each rooted at a user entry point.
     */
    private List<SourceCallChainInfo> entry_points = new ArrayList<SourceCallChainInfo>();
    
    /**
     * Creates a SourceCallTree.  Computes the forest with a source call tree rooted at each
     * user entry point.
     */
    private SourceCallTree() {
        forEntryPoints();
    }
    
    /**
     * Returns the singleton instance of this class.
     * 
     * @return - the singletone instance
     */
    public static SourceCallTree v() {
        if (v == null)
            v = new SourceCallTree();
        
        return v;
    }
    
    /**
     * Loop through each entry point and calculate the source call graph from that entry
     * point.  The results are placed into entry_points.
     */
    private void forEntryPoints() {
        
        for (SootMethod method : PTABridge.v().getReachableMethods()) {
            if (RCFG.isUserEntryPoint(method)) {
                logger.info ("Found entry  point {}", method);
                SourceCallChainBuilder cb = new SourceCallChainBuilder (timeout, true);
                SourceCallChainInfo cci = cb.process_call_chain (null, method);
                if (cci != null) {
                	cci.type = "entry-point";
                	cci.link = "as_entry_point";
                	cci.calculate_scores();
                	entry_points.add (cci);
                }
            }            
        }
    }
    
    /**
     * Returns a set of source methods included in the source call tree.
     * 
     * @return - the set of source methods in the source call tree.
     */
    public Set<SootMethod> collectSourceMethods() {
    	Set<SootMethod> result = new HashSet<SootMethod>();
    	for (SourceCallChainInfo cci: entry_points) {
    		collectSourceMethods(cci, result);
    	}
    	return result;
    }

    /** Adds source methods contained in the given SourceCallChainInfo to the result set.
     * 
     * @param cci - the SourceCallChainInfo in which source methods are to be collected
     * @param result - the result set of source methods collected
     */
    private void collectSourceMethods(SourceCallChainInfo cci,
			Set<SootMethod> result) {
		result.add(cci.method);
		for (SourceCallChainInfo callee: cci.contents) {
			collectSourceMethods(callee, result);
		}
	}

	/**
	 * Output a Json representation of the source call tree in the given directory.
	 * @param parentDir - the parent directory for the output Json file
	 */
	public void toJson(String parentDir) {
        PrintStream fp;
        try {
            fp = new PrintStream(parentDir + File.separator + FILE_NAME);
            fp.print (json_call_graph_header ("Call Graphs from Entry Points", Collections.EMPTY_MAP));
            for (SourceCallChainInfo cci : entry_points) {
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
