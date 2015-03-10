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

package droidsafe.stats;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.app.Project;

public class IntentResolutionStats {
    private static final Logger logger = LoggerFactory.getLogger(IntentResolutionStats.class);

    public int intentObjects = 0;
    public int intentCalls = 0;
    public int callsWithResolvedIntents = 0;
    public int callsWithUnresolvedIntent = 0;
    public int callsTargetNotInApp = 0;
    public int inAppComponentsTotalTargets = 0;
    public int resolvedImplictIntents = 0;
    public int resolvedExplicitIntents = 0;
    
    public int contentProviderOps = 0;
    public int contentProviderOpsResolvedUri = 0;
    public int contentProviderOpsUnresolvedUri = 0;    
    public int contentProviderOpsInAppTotalTargets = 0;
    public int contentProviderOpsInterAppTarget = 0;
    
    private static IntentResolutionStats v;
    
    public static IntentResolutionStats v() {
        if (v == null) 
            v = new IntentResolutionStats();
        
        return v;
    }
    
    private IntentResolutionStats() {
        
    }
    
    public void writeStats() {
        PrintWriter out = null;
        try {
            out = new PrintWriter(Project.v().getOutputDir() + File.separator + "icc-resolution-stats.txt");
            out.println("");

            out.println("intentObjects,intentCalls,callsWithResolvedIntents,callsWithUnresolvedIntent,callsTargetNotInApp,"
                    + "inAppComponentsTotalTargets,resolvedImplictIntents,resolvedExplicitIntents,"                     
                    + "contentProviderOps,contentProviderOpsResolvedUri,"
                    + "contentProviderOpsUnresolvedUri,contentProviderOpsInAppTotalTargets,contentProviderOpsInterAppTarget");
            
            out.print(intentObjects + ",");
            out.print(intentCalls + ",");
            out.print(callsWithResolvedIntents + ",");
            out.print(callsWithUnresolvedIntent + ",");
            out.print(callsTargetNotInApp + ",");
            out.print(inAppComponentsTotalTargets + ",");
            out.print(resolvedImplictIntents + ",");
            out.print(resolvedExplicitIntents + ",");
                
            out.print(contentProviderOps + ",");
            out.print(contentProviderOpsResolvedUri + ",");
            out.print(contentProviderOpsUnresolvedUri + ",");
            out.print(contentProviderOpsInAppTotalTargets + ",");
            out.print(contentProviderOpsInterAppTarget);
            
            out.println();

        } catch (IOException e) {
            logger.warn("Problem writing Intent resolution stats", e);
        } finally {
            out.close();
        }
    }

}
