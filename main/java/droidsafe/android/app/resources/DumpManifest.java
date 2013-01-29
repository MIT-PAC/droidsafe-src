package droidsafe.android.app.resources;

import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.app.resources.AndroidManifest.Activity;
import droidsafe.android.app.resources.AndroidManifest.Permission;
import droidsafe.android.app.resources.AndroidManifest.Provider;
import droidsafe.android.app.resources.AndroidManifest.Receiver;
import droidsafe.android.app.resources.AndroidManifest.Service;
import droidsafe.android.app.resources.AndroidManifest.UsesPermission;

/**
 * Dumps information from the manifest file
 */
public class DumpManifest {
	private final static Logger logger = LoggerFactory.getLogger(DumpManifest.class);	
  

  public static void main (String args[]) throws Exception {

    if (args.length != 1) {
      logger.error ("One argument (application directory) is required\n" + 
    		  "usage: DumpManifest <kapp-dir>\n" +
    		  "DumpManifest dumps information from the manifest file\n");
      System.exit(1);
    }

    // Initialize information about the application
    Application app = new Application (new File (args[0]));

    // Read the manifest and find all of the activities
    AndroidManifest am = app.manifest;
    logger.info ("Manifest      = {}", am.manifest);
    logger.info ("application   = {}", am.application);
    logger.info ("uses-sdk      : {}", am.uses_sdk);
    logger.info ("Activities: ");
    for (Activity a : am.activities) {
      logger.info ("  {}", a);
    }
    logger.info ("Services:");
    for (Service s : am.services) {
      logger.info ("  {}", s);
    }

    logger.info ("Receivers:");
    for (Receiver r : am.receivers) 
      logger.info ("  {}", r);

    logger.info ("Providers:");
    for (Provider p : am.providers)
      logger.info ("  {}", p);

    logger.info ("UsesPermissions");
    for (UsesPermission up : am.uses_permissions)
      logger.info ("  {}", up);

    logger.info ("Permissions");
    for (Permission p : am.permissions)
      logger.info ("  {}", p);
  }
}

