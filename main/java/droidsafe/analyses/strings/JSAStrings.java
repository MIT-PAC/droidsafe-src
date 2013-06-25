package droidsafe.analyses.strings;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Scene;
import soot.SootClass;
import soot.Value;
import soot.ValueBox;
import dk.brics.string.StringAnalysis;
import dk.brics.string.grammar.Nonterminal;
import droidsafe.analyses.strings.AutomataUtil.RE;
import droidsafe.android.app.Project;
import droidsafe.main.Config;

/**
 * Wrapper for the Java String Analyzer.
 * 
 * Allows hotspots to be identified, and (after executing analysis) to be queried to get a regular
 * expression representation.
 * 
 * @author garrinkimmell
 * 
 */
public class JSAStrings {
  /** Standard Logging output **/
  private static final Logger logger = LoggerFactory.getLogger(JSAStrings.class);

  /** The set of hotspots **/
  private List<ValueBox> hotspots;

  /** The main JSA object. **/
  private StringAnalysis sa;

  /** A converter from Grammar to regular expressions **/
  private GrammarVisitor gv;

  /** A mapping from Value (associated with a hotspot) to nonterminal. **/
  private HashMap<Value, Nonterminal> nonterminals;

  /** Singleton for analysis */
  private static JSAStrings jsa;

  /** boolean that determines whether the analysis has run */
  private boolean hasRun = false;


  /**
   * Map to keep track of defined hotspots. Maps the method signature used to create the hotspot to
   * an object containing more details about the hotSspot.
   */
  Map<String, List<Hotspot>> signatureToHotspotMap;


  /**
   * Singleton accessor.
   * 
   * @return The singleton JSAStrings object.
   */
  public static JSAStrings v() {
    if (jsa != null) {
      return jsa;
    } else {
      jsa = new JSAStrings();
      return jsa;
    }
  }

  /**
   * Constructor.
   */
  private JSAStrings() {
    hotspots = new LinkedList<ValueBox>();
    nonterminals = new HashMap<Value, Nonterminal>();
    gv = null;
    signatureToHotspotMap = new HashMap<String, List<Hotspot>>();
  }

  /**
   * @return boolean of whether the JSA has run or not
   */
  public boolean hasRun() {
    return this.hasRun;
  }

  /**
   * Get the hotspots that have been added.
   * 
   * @return
   */
  public List<ValueBox> getHotspots() {
    return hotspots;
  }


  public Map<String, List<Hotspot>> getSignatureToHotspotMap() {
    return this.signatureToHotspotMap;
  }

  /**
   * Initialize and configure.
   * 
   * @param config
   */
  public static void init(Config config) {
    jsa = new JSAStrings();
    soot.options.Options.v().set_allow_phantom_refs(true);

    try {
      StringAnalysis.loadDirectory(config.APP_ROOT_DIR + "/bin/classes/");
      String libDir = config.APP_ROOT_DIR + "/libs/";
      File lib = new File(libDir);
      if (lib.exists()) {
        StringAnalysis.addJarsToClassPath(libDir);
      }
    } catch (IOException e) {
      logger.debug("JSA got an exception.");
      return;
    }

    // SootClass clazz =
    // StringAnalysis.loadClass(Harness.HARNESS_CLASS_NAME);
    setApplicationClasses(config);
  }

  /**
   * Run the analysis, after init.
   */
  public static void run() {
    // Well this seems a little dumb to simply wrap analyze...
    v().hasRun = true;
    v().analyze();
  }

  /**
   * Run the analysis.
   */
  private void analyze() {
    sa = new StringAnalysis(hotspots); // Run the analysis.

    for (ValueBox h : hotspots) {
      // automata.put(h.getValue(),sa.getAutomaton(h));
      nonterminals.put(h.getValue(), sa.getNonterminal(h));
    }

    gv = new GrammarVisitor(sa.getGrammar());
    return;
  }

  /**
   * Auxiliar method to add an element to the hotspot map.
   * 
   * @param signature The soot signature if the method.
   * @param hotspot The hot
   */
  private void addSignatureToHotspotMap(String signature, Hotspot hotspot){
    List<Hotspot> hotspots = this.signatureToHotspotMap.get(signature);
    if (hotspots == null){
      hotspots = new ArrayList<Hotspot>();
      this.signatureToHotspotMap.put(signature, hotspots);      
    }
    hotspots.add(hotspot);
  }
  
  /**
   * Add a hotspot for matching calls.
   * 
   * @param signature The signature of the method.
   * @param arg The argument index of the hotspot.
   */
  public void addArgumentHotspots(String signature, int arg) {
    List<ValueBox> sigSpots = StringAnalysis.getArgumentExpressions(signature, arg);
    logger.debug("For signature " + signature + " got " + sigSpots.size() + " hotspots.");

    if (!sigSpots.isEmpty()) {
      addSignatureToHotspotMap(signature, new Hotspot(signature, arg, sigSpots));
      hotspots.addAll(sigSpots);
    }
  }

  /**
   * Add a hotspot for methods that return a sting.
   * 
   * @param signature The signature of the method.
   */
  public void addReturnHotspot(String signature) {
    List<ValueBox> sigSpots = StringAnalysis.getReturnExpressions(signature);
    logger.debug("For signature " + signature + " got " + sigSpots.size() + " hotspots.");
    
    if (!sigSpots.isEmpty()) {
      addSignatureToHotspotMap(signature, new Hotspot(signature, sigSpots));
      hotspots.addAll(sigSpots);
    }
  }

  /**
   * Get the regular expression inferred for the given Value.
   * 
   * @param v The Soot Value associated with the hotspot.
   * @return
   */
  public String getRegex(Value v) {
    try {
      RE res = gv.getRE(nonterminals.get(v));
      res = res.simplifyOps();
      return res.toString();
    } catch (NullPointerException e) {
      return "";
    }
  }

  /**
   * Get the source file associated with the parameter hotspot.
   * 
   * @param v The hotspot.
   * @return
   */
  public String getSourceFile(ValueBox v) {
    return sa.getSourceFile(v);
  }

  /**
   * Get the class name associated with the parameter hotspot.
   * 
   * @param v The hotspot.
   * @return
   */
  public String getClassName(ValueBox v) {
    return sa.getClassName(v);
  }

  /**
   * Get the method name associated with the parameter hotspot.
   * 
   * @param v The hotspot.
   * @return
   */
  public String getMetodName(ValueBox v) {
    return sa.getMethodName(v);
  }


  /**
   * Get the source line associated with the parameter hotspot.
   * 
   * @param v The hotspot.
   * @return
   */
  public String getSourceLine(ValueBox v) {
    return Integer.toString(sa.getLineNumber(v));
  }

  // public void logGrammar() {
  // logger.debug("Done with String analysis");
  // JSAStrings jsa = JSAStrings.v();
  // GrammarVisitor visitor = new GrammarVisitor(sa.getGrammar());
  //
  // for (ValueBox v : jsa.getHotspots()) {
  // System.out.println("Hotspot: " + sa.getSourceFile(v) + ":::" +
  // sa.getLineNumber(v)
  // + ":::");
  // AutomataUtil.RE res = visitor.getRE(sa.getNonterminal(v));
  // res = res.simplifyOps();
  // System.out.println(res.toString(true));
  // }
  // }

  /**
   * Dump a summary of analysis.
   */
  public void log() {
    logger.debug("Done with String analysis");
    JSAStrings singleton = JSAStrings.v();

    for (ValueBox v : singleton.getHotspots()) {
      // exploreRegex(automata.get(v.getValue()));
      logger.debug("Hotspot: " + sa.getSourceFile(v) + ":::" + sa.getLineNumber(v) + ":::"
          + singleton.getRegex(v.getValue()));
    }
  }

  /**
   * LWG: Allow application classes to be filtered from soot.Scene
   * 
   * @param config
   */
  private static void setApplicationClasses(Config config) {
    Collection<SootClass> appClasses = Scene.v().getApplicationClasses();
    if (config.unfilteredStringAnalysis) {
      StringAnalysis.setApplicationClasses(appClasses);
    } else {
      Collection<SootClass> srcClasses = new ArrayList<SootClass>();
      for (SootClass cls : appClasses)
        if (Project.v().isSrcClass(cls)) srcClasses.add(cls);
      StringAnalysis.setApplicationClasses(srcClasses);
    }
  }

  /*
   * Example of getting the results of JSA.
   */
  /*
   * private void example() { List<ValueBox> hs = getHotspots(); for(ValueBox vb : hs) {
   * getSourceFile(vb); getSourceLine(vb); getRegex(vb.getValue()); } }
   */


  /**
   * Auxiliary class to help keep track of hotspots.
   * 
   */
  public class Hotspot {
    /**
     * The signature of the method added as a hotspot.
     */
    String methodSignature;

    /**
     * The position of the argument added as a hotspot. 0 is the first method argument. -1 is a
     * method return value added as a hotspot.
     */
    int argumentPosition = -1;

    /**
     * The list of hotspots identified for the method signature.
     */
    List<ValueBox> hotspots;

    public Hotspot(String signature, int position, List<ValueBox> values) {
      this.methodSignature = signature;
      this.argumentPosition = position;
      this.hotspots = values;
    }

    public Hotspot(String signature, List<ValueBox> values) {
      this.methodSignature = signature;
      this.hotspots = values;
    }

    /**
     * @return the methodSignature
     */
    public String getMethodSignature() {
      return methodSignature;
    }

    /**
     * @return the argumentPosition
     */
    public int getArgumentPosition() {
      return argumentPosition;
    }

    /**
     * @return the hotspots
     */
    public List<ValueBox> getHotspots() {
      return hotspots;
    }
  }
}
