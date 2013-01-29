package droidsafe.android.app.resources;

import java.util.*;
import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.*;

import soot.SootMethod;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import droidsafe.android.app.resources.AndroidManifest.Activity;
import droidsafe.android.app.resources.Layout.View;


/**
 * Resolves OnClick tags in XML files to their associated
 * class/routine.  The OnClick tag specifes only a method name.  The
 * class that should contains the method is the class that
 * instantiated the view (called setContentView()) that contains the
 * tag.
 */
public class ResolveOnClick {
	private final static Logger logger = LoggerFactory.getLogger(ResolveOnClick.class);	

  public static void main (String args[]) throws Exception {

   // System.out.printf ("in ResolveOnClick\n");

    if (args.length != 1) {
      logger.error ("One argument (application directory) is required\n" + 
    		  "usage: DumpRes <kapp-dir>\n" +
    		  "DumpRes dumps all of the resource ids for the app\n");
      System.exit(1);
     
    }

    // Initialize information about the application
    Resources app = new Resources (new File (args[0]));

    // Read the manifest and find all of the activities
    AndroidManifest am = app.manifest;
    logger.info ("Manifest = {}\n", am.manifest);
    logger.info ("appliction = {}\n", am.application);
    logger.info ("Activities: \n");
    for (Activity a : am.activities) {
      logger.info ("  {}\n", a);
    }

    // Process the activities of the application
    for (Activity a : app.manifest.activities)
      app.process_activity (a);

    // Process all of the layouts
    for (Layout l : app.layouts) {
      logger.info ("  Processing layout {}\n", l.name);
      app.process_view (l, l.view);
    } 

    // Printout all of the on-clicks
    logger.info ("\n%d Layout file with XML onClick handlers", 
                    app.handlers.size());
    for (Layout layout : app.handlers.keySet()) {
      HashMap<View, SootMethod> lmap = app.handlers.get (layout);
      logger.info ("layout {}", layout.name);
      for (View view : lmap.keySet()) {
        logger.info ("  view {} -> method {}", view, lmap.get(view));
      }
    }
  }
}

