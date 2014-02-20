package droidsafe.android.app.resources;

import java.io.*;
import java.util.List;

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
    Resources app = new Resources (new File (args[0]));
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
        }
    }
    
    out.println("\nServices: ");
    for (Service a : am.services) {
        out.printf("  Name: %s \n", a.name);
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
        out.printf("  receiver %s \n", a.toString());
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
            out.printf("    intentFilter %s - %s %s\n",
                    listToString(intentFilter.actions, "|"),
                    listToString(intentFilter.categories, "|"),
                    dataString);

        }
    }
  }
}

