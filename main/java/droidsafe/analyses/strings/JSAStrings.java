package droidsafe.analyses.strings;


import java.util.LinkedList;
import java.util.Vector;
import java.util.HashMap;
import java.util.Map;

import java.util.List;
import java.io.IOException;
import java.io.File;
import java.io.FileFilter;
import java.util.jar.JarFile;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import soot.SootClass;
import soot.ValueBox;

import droidsafe.android.app.Harness;
import droidsafe.utils.SootUtils;
import droidsafe.main.Config;



import dk.brics.string.StringAnalysis;
import dk.brics.automaton.Automaton;
import dk.brics.automaton.State;
import dk.brics.automaton.Transition;
import dk.brics.automaton.RegExp;


// import droidsafe.analyses.strings.AutomataUtils;

public class JSAStrings {

	private final static Logger logger = LoggerFactory.getLogger(JSAStrings.class);

	public static void run(Config config) {

		// Logger.getRootLogger().setLevel(Level.OFF);		
		soot.options.Options.v().set_allow_phantom_refs(true);

		try {

			StringAnalysis.loadDirectory("bin/classes/");
			StringAnalysis.addJarsToClassPath("libs/");




			/*
						String APAC_HOME = config.APAC_HOME();
			String droidsafeLib = APAC_HOME + "lib"; 
			logger.debug("Adding libraries from " + droidsafeLib);



			// Modify the Classpath
			boolean loaded = StringAnalysis.addJarsToClassPath(droidsafeLib);

			// Load the jars. Is it really necessary to do this, given that the
			// jars are already added to the classpath?
			File[] jars = new File(droidsafeLib).listFiles(new FileFilter() {
				public boolean accept(File pathname) {
					return pathname.isFile() && pathname.getName().endsWith(".jar");
				}
			});

			for (File jar : jars) {
				SootUtils.loadClassesFromJar(new JarFile(jar), false);
			}

    	*/
		} catch (IOException e) {
			logger.debug("JSA got an exception.");
			return;
		}




		SootClass clazz = StringAnalysis.loadClass(Harness.HARNESS_CLASS_NAME);
		// logger.info("Running the  JSA Analysis");
		// logger.debug(clazz.toString());
		
		List<ValueBox> hotspots = new LinkedList<ValueBox>();
		hotspots.addAll(StringAnalysis.getArgumentExpressions("<android.content.Intent: void <init>(java.lang.String)>", 0));
		hotspots.addAll(StringAnalysis.getArgumentExpressions("<android.content.Intent: android.content.Intent addCategory(java.lang.String)>", 0));	
		// hotspots.addAll(StringAnalysis.getArgumentExpressions("<java.lang.String: java.lang.String concat(java.lang.String)>", 0));	


		logger.debug("Got " + hotspots.size() + " Expressions");
		StringAnalysis sa = new StringAnalysis(hotspots); // Run the analysis???
		convertHotspots(sa,hotspots);
		

		/*

		// Just some testing
		Automaton uriauto = new RegExp(
			"(([a-zA-Z][0-9a-zA-Z+\\-\\.]*:)?/{0,2}[0-9a-zA-Z;/?:@&=+$\\.\\"
				+ "-_!~*'()%]+)?("
				+ "#[0-9a-zA-Z;/?:@&=+$\\.\\-_!~*'()%]+)?").toAutomaton();

		uriauto = new RegExp("(a*|b)(c|d)*yz").toAutomaton();

		
		uriauto.determinize();
		AutomataUtil.RE uri = AutomataUtil.convertAutomata(uriauto);
		if (uriauto.isEmpty()) {
			logger.debug("URL Automata is empty!");
		} else {
			logger.debug(uriauto.toString());
			logger.debug("URL Automata: " + uri.toString());
		}
	*/
		// End testing

		return;
	}


	private static void convertHotspots(StringAnalysis sa, List<ValueBox> hotspots) {

		logger.debug("Converting Automata");
		for (ValueBox h : hotspots) {
			logger.debug("----------------------------");
			logger.debug(sa.getSourceFile(h) + ":" + sa.getLineNumber(h));
			AutomataUtil.RE res = AutomataUtil.convertAutomata(sa.getAutomaton(h));
			logger.debug("REGEX: " + res.toString());
			logger.debug("----------------------------");

		}
	}

}