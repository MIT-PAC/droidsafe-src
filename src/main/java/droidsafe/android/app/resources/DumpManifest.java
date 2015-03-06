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

package droidsafe.android.app.resources;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.app.resources.AndroidManifest.Activity;
import droidsafe.android.app.resources.AndroidManifest.IntentFilter;
import droidsafe.android.app.resources.AndroidManifest.Permission;
import droidsafe.android.app.resources.AndroidManifest.Provider;
import droidsafe.android.app.resources.AndroidManifest.Receiver;
import droidsafe.android.app.resources.AndroidManifest.Service;
import droidsafe.android.app.resources.AndroidManifest.UsesPermission;
import droidsafe.main.Config;

/**
 * Dumps information from the manifest file
 */
public class DumpManifest {
	private final static Logger logger = LoggerFactory.getLogger(DumpManifest.class);	
  

	private static String listToString(List<String> list, String separator) {
	    StringBuilder builder = new StringBuilder();
	    
	    for (Object item: list) {
	        if (builder.length() != 0)
	            builder.append(separator);

	        builder.append(item.toString());
	    }
	    return builder.toString();
	}
	
  public static void main (String args[]) throws Exception {

    if (args.length < 1) {
      logger.error ("One argument (application directory) is required\n" + 
    		  "usage: DumpManifest <kapp-dir> [<outfile>]\n" +
    		  "DumpManifest dumps information from the manifest file\n");
      droidsafe.main.Main.exit(1);
    }

    Config.v().setApacHome(Config.v().getApacHome());
    // Initialize information about the application
    String appDir = args[0];
    if (appDir.endsWith("AndroidManifest.xml"))
        appDir = appDir.replace("AndroidManifest.xml", "");

    Resources app = new Resources (new File (appDir));
    AndroidManifest am = app.manifest;
    
    PrintStream out = System.out;
    if (args.length == 2) {
        out = new PrintStream(args[1]);
    }

    // Read the manifest and find all of the activities
    out.println("====================== Manifest Summary ====================== ");
    if (am.manifest.package_name != null)
    out.printf("Package:  %s \n", am.manifest.package_name);
    
    if (am.uses_sdk != null)
        out.printf("UsesSDK:   %s \n", am.uses_sdk.toString());
   
    out.println("UsesPermissions:   ");
    for (UsesPermission perm:   am.uses_permissions) {
        out.printf("    %s\n", perm.name);
        
    }

    out.println("Permissions:   ");
    for (Permission perm:   am.permissions) {
        out.printf("    %s\n", perm.name);
        
    }

    Set<String> activityStartSet = new HashSet<String>();
    
    out.println("\nActivities: ");
    for (Activity a : am.activities) {
        out.printf("    Name: %s \n", a.name);
        for (IntentFilter intentFilter: a.intent_filters) {
            String dataString = "";
            if (intentFilter.dataUri != null)
                dataString = " - " + intentFilter.dataUri;
            
            out.printf("        intentFilter %s - %s %s\n",
                    listToString(intentFilter.actions, "|"),
                    listToString(intentFilter.categories, "|"),
                    dataString);
            
            if (listToString(intentFilter.actions, "|").contains("MAIN") ||
                listToString(intentFilter.categories, "|").contains("LAUNCHER")) {
                String startCmd = String.format("adb shell am start -n %s/%s", am.manifest.package_name,
                        a.name);
                activityStartSet.add(startCmd);
            }
        }
    }
    
    out.println("\nServices: ");
    for (Service a : am.services) {
        out.printf("    Name: %s \n", a.name);
        for (IntentFilter intentFilter: a.intent_filters) {
            String dataString = "";
            if (intentFilter.dataUri != null)
                dataString = " - " + intentFilter.dataUri;
            
            out.printf("        intentFilter %s - %s %s\n",
                    listToString(intentFilter.actions, "|"),
                    listToString(intentFilter.categories, "|"),
                    dataString);
            
        }
    }
    
    out.println("\nReceivers: ");
    for (Receiver a : am.receivers) {
        out.printf("    receiver %s \n", a.name);
        for (IntentFilter intentFilter: a.intent_filters) {
            String dataString = "";
            if (intentFilter.dataUri != null)
                dataString = " - " + intentFilter.dataUri;
            out.printf("        intentFilter %s - %s %s\n",
                    listToString(intentFilter.actions, "|"),
                    listToString(intentFilter.categories, "|"),
                    dataString);
             
        }
    }

    out.println("\nProviders: ");
    for (Provider a : am.providers) {
        out.printf("    %s\n", a.name);
        for (IntentFilter intentFilter: a.intent_filters) {
            String dataString = "";
            if (intentFilter.dataUri != null)
                dataString = " - " + intentFilter.dataUri;
            out.printf("        intentFilter %s - %s %s\n",
                    listToString(intentFilter.actions, "|"),
                    listToString(intentFilter.categories, "|"),
                    dataString);

        }
    }
    
    
    if (activityStartSet.size()> 0)
        out.println("\nActivity Starting Commands: \n");

    for (String startCmd: activityStartSet) {
        out.printf("   %s \n", startCmd);
    }
  }
}

