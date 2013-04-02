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


	private List<ValueBox> hotspots;

	private Map<ValueBox,Automaton> automata;

	/** Singleton for analysis */
	private static JSAStrings jsa;

	public static JSAStrings v() {
		if (jsa != null) {
			return jsa;
		} else {
			jsa = new JSAStrings();
			return jsa;
		}
	}

	private JSAStrings() {
		hotspots = new LinkedList<ValueBox>();
		automata = new HashMap<ValueBox,Automaton>();
	}

	public List<ValueBox> getHotspots() {
		// FIXME: Should this return a clone?
		return hotspots;
	}

	public static void run(Config config) {
		// Well this seems a little dumb to simply wrap analyze...
		v().analyze(config);
	}

	private void analyze(Config config) {
		// Logger.getRootLogger().setLevel(Level.OFF);		

		// Initialize the 
		soot.options.Options.v().set_allow_phantom_refs(true);

		try {

			StringAnalysis.loadDirectory("bin/classes/");
			StringAnalysis.addJarsToClassPath("libs/");

		} catch (IOException e) {
			logger.debug("JSA got an exception.");
			return;
		}

		SootClass clazz = StringAnalysis.loadClass(Harness.HARNESS_CLASS_NAME);

		loadHotspotsFromFile("hotspots.txt");

		StringAnalysis sa = new StringAnalysis(hotspots); // Run the analysis.

		for (ValueBox h : hotspots) {
			automata.put(h,sa.getAutomaton(h));
		}		
		return;
	}

	public void addHotspots(String signature) {
		// TODO: Iterate through the argument types, adding the argument if 
		// it is a string.
		for (int i = 0; i < 0; i++) {
			hotspots.addAll(StringAnalysis.getArgumentExpressions(signature,i));
		}
		// TODO: Add the return type if it is a string.
	}

	public void addArgumentHotspots(String signature, int arg) {
      hotspots.addAll(StringAnalysis.getArgumentExpressions(signature,arg));

	}

	public void loadHotspotsFromFile(String fname) {
		// TODO: Read in the hotspots from the named file, rather than the static methods listed here.
		  v().addArgumentHotspots("<android.content.Intent: void <init>(java.lang.String)>", 0);
		  v().addArgumentHotspots("<android.content.Intent: android.content.Intent addCategory(java.lang.String)>", 0);	
		  v().addArgumentHotspots("<java.net.URI: void <init>(java.lang.String)>", 0);
	}


	public String getRegex(ValueBox v) {
		Automaton a = automata.get(v);
		if (a != null) {
			return AutomataUtil.convertAutomata(a).toString();
		}
		return null;
	}


	public void log() {
	  JSAStrings jsa = JSAStrings.v();
	  for (ValueBox v : jsa.getHotspots()) {
	  	logger.debug("Hotspot REGEX: " + jsa.getRegex(v));
	  }
	}
	
	private void convertHotspots(StringAnalysis sa, List<ValueBox> hotspots) {
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