package droidsafe.main;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;

import droidsafe.analyses.CallGraphFromEntryPoints;
import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.RCFGToSSL;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.android.app.EntryPoints;
import droidsafe.android.app.Harness;
import droidsafe.android.app.TagImplementedSystemMethods;

import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.transforms.AddAllocsForAPICalls;
import droidsafe.transforms.LocalForStringConstantArguments;
import droidsafe.transforms.ScalarAppOptimizations;
import droidsafe.utils.SootUtils;


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
	
	public static final Set<String> TARGETS = new LinkedHashSet<String>(Arrays.asList(
			"specdump", "confcheck"
			));
	
	/**
	 */
	public static void main(String[] args) {
		logger.info("Starting DroidSafe Run");
		Config.v().init(args);
		Project.v().init();
		SootConfig.init();
		API.v().init();
		logger.info("Creating locals for all string constant arguments.");
		LocalForStringConstantArguments.run();
		logger.info("Calling scalar optimizations.");
		ScalarAppOptimizations.run();		
		logger.info("Create tags for the overriden system methods in user code.");
		TagImplementedSystemMethods.run();
		logger.info("Finding entry points in user code.");
		EntryPoints.v().calculate();
		logger.info("Creating Harness.");
		Harness.create();
		logger.info("Setting Harness Main as entry point.");
		setHarnessMainAsEntryPoint();
	
		writeAllAppClasses();
		
		AddAllocsForAPICalls.run();
		
		logger.info("Starting PTA...");
		GeoPTA.run();
		
		RCFG.generate();
		logger.info("Ending DroidSafe Run");
		
		writeAllAppClasses();
		
		if (Config.v().target.equals("specdump")) {
			RCFGToSSL.run();
		} else if (Config.v().target.equals("confcheck")) {
			
		}
		
	}
	
	private static void setHarnessMainAsEntryPoint() {
		List<SootMethod> entryPoints = new LinkedList<SootMethod>();
		entryPoints.add(Harness.v().getMain());
		Scene.v().setEntryPoints(entryPoints);
		//Scene.v().setMainClass(Harness.v().getHarnessClass());
	}
	
	private static void writeAllAppClasses() {
		for (SootClass clz : Scene.v().getClasses()) {
			if (clz.isApplicationClass() && Project.v().isAppClass(clz.toString())) {
				SootUtils.writeByteCodeAndJimple(Project.v().getOutputDir() + File.separator + clz.toString(), clz);
			}
		}
	}
}
