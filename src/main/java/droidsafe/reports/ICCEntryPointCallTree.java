/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

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
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.android.system.API;
import droidsafe.analyses.CallChainBuilder;
import droidsafe.analyses.CallChainInfo;
import static droidsafe.reports.JSONUtils.*;


/**
 * Indicator to print a forest with a call tree rooted at each user entry point.
 * 
 * @author mgordon
 *
 */
public class ICCEntryPointCallTree {
    private final static Logger logger = LoggerFactory.getLogger(ICCEntryPointCallTree.class);
    
    private static final String FILE_NAME = "icc_entry_points.json";
    private static int timeout = 5 * 60 * 1000;

    private static ICCEntryPointCallTree v;
   private List<CallChainInfo> icc_entry_points = new ArrayList<CallChainInfo>();
    
    // types of calls
    private static Map<String,Boolean> visibility_map = new LinkedHashMap<String,Boolean>();
    static {
        visibility_map.put ("call-chain", true);
        visibility_map.put ("syscall", true);
    }   
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
                logger.info ("Found ICC entry point {}", momc);
                CallChainBuilder cb = new CallChainBuilder (timeout, true);
                CallChainInfo cci = cb.process_call_chain (null, momc);
                cci.type = "entry-point";
                cci.link = "as_entry_point";
                cci.calculate_scores();
                icc_entry_points.add (cci);
            }
        }
    }

    public void toJson(String parentDir) {
        PrintStream fp;
        try {
            fp = new PrintStream(parentDir + File.separator + FILE_NAME);
            fp.print (json_call_graph_header ("ICC Entry Points", visibility_map));
            for (CallChainInfo cci : icc_entry_points) {
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
