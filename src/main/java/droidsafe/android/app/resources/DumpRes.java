package droidsafe.android.app.resources;

import java.util.*;
import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reads the resource definitions out of the compiled resource files.
 * These files are in the application subdirectory bin/classes/[appl]
 * The application must be built for these files to exist.  Dumps out
 * name value pairs for each resource id.
 *
 * Takes one argument - the name of the top level application directory
 */
public class DumpRes {
	private final static Logger logger = LoggerFactory.getLogger(DumpRes.class);	
	  
  static String blanks = "                                               ";

  public static void main (String[] args) throws Exception {


    if (args.length != 1) {
      logger.error ("One argument (application directory) is required\n" + 
    		  "usage: DumpRes <app-dir>\n" +
    		  "DumpRes dumps all of the resource ids for the app\n");
      droidsafe.main.Main.exit(1);
     
    }

    Resources app = new Resources (new File (args[0]));

    for (Integer res_val : app.resource_info.keySet()) {
    	logger.info ("{}  {}", String.format("%08X", res_val), 
                         app.resource_info.get (res_val));
    }
  }
}
