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
import soot.Value;

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

	private Map<Value,Automaton> automata;

 private StringAnalysis sa;
    
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
		automata = new HashMap<Value,Automaton>();
    
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
		sa = new StringAnalysis(hotspots); // Run the analysis.

		for (ValueBox h : hotspots) {
        automata.put(h.getValue(),sa.getAutomaton(h));
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
      List<ValueBox> sigSpots = StringAnalysis.getArgumentExpressions(signature,arg);
      logger.debug("For signature " + signature + " got " + sigSpots.size() + "hotspots.");
      hotspots.addAll(sigSpots);
	}


	public String getRegex(Value v) {
		Automaton a = automata.get(v);
		if (a != null) {
			return AutomataUtil.convertAutomata(a).toString();
		}
		return null;
	}


	public void log() {
		logger.debug("Done with String analysis");
	  JSAStrings jsa = JSAStrings.v();

	  int i = 0;
	  for (ValueBox v : jsa.getHotspots()) {
        logger.debug("Hotspot: " + sa.getSourceFile(v) + ":::" + sa.getLineNumber(v) + ":::" + jsa.getRegex(v.getValue()));
        // logger.debug("Hotspot REGEX: " + jsa.getRegex(v.getValue()));
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
