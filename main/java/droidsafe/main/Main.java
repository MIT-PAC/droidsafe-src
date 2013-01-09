package droidsafe.main;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.app.EntryPoints;
import droidsafe.android.app.Harness;
import droidsafe.android.app.TagImplementedSystemMethods;

import droidsafe.android.app.Project;
import droidsafe.android.system.API;


/**
 * Main entry class for DroidSafe analysis.
 * 
 * @author mgordon
 *
 */
public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	public static final String LOG_TXT_FILE = "droidsafe.log.txt";
	public static final String LOG_XML_FILE = "droidsafe.log.xml";
	
	/**
	 */
	public static void main(String[] args) {
		logger.info("Starting DroidSafe Run");
		Config.v().init(args);
		Project.v().init();
		SootConfig.init();
		API.v().init();
		//create tags for the implemented system methods
		TagImplementedSystemMethods.run();
		EntryPoints.v().calculate();
		Harness.create();
		logger.info("Ending DroidSafe Run");
	}
}
