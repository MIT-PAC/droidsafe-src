package droidsafe.analyses.strings;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.Scene;
import soot.SootClass;
import soot.Value;
import soot.ValueBox;
import soot.jimple.Expr;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import dk.brics.string.StringAnalysis;
import dk.brics.string.grammar.Nonterminal;
import droidsafe.analyses.strings.AutomataUtil.RE;
import droidsafe.android.app.Project;
import droidsafe.main.Config;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;

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

  /** The number of regular expressions generated for hotspots. */
  private Map<Value, String> regexMap = new HashMap<Value, String>();

  /** timeout value (in minutes) for running the string analysis. */
  private static long timeout;
  
  private enum Status {
    TIMEDOUT_ANALYSIS, TIMEDOUT_REGEN, OK
  }

  private Status status;
  
  private int reGenTimoutCount = 0;


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
    signatureToHotspotMap = new TreeMap<String, List<Hotspot>>();
    status = Status.OK;
  }
  
  /**
   * For each value in original body that is hotspots for JSA, add the corresponding cloned
   * value in the clone body to the JSA results with the same result.
   */
  public void updateJSAResults(Body originalBody, Body cloneBody) {
      if (!Config.v().runStringAnalysis || !JSAStrings.v().hasRun())
          return;

      assert originalBody.getUnits().size() == cloneBody.getUnits().size();

      //loop over all methods of both clone and originals
      Iterator originalIt = originalBody.getUnits().iterator();
      Iterator cloneIt = cloneBody.getUnits().iterator();

      while (originalIt.hasNext()) {
          Stmt origStmt = (Stmt)originalIt.next();
          Stmt cloneStmt = (Stmt)cloneIt.next();

          if (!origStmt.containsInvokeExpr()) {
              continue;
          }

          InvokeExpr origInvokeExpr = (InvokeExpr)origStmt.getInvokeExpr();
          InvokeExpr cloneInvokeExpr = (InvokeExpr)cloneStmt.getInvokeExpr();

          //iterate over the args and see if any arg from orig is tracked by jsa
          //if so, add the clone to jsa results
          for (int i = 0; i < origInvokeExpr.getArgCount(); i++) {
              ValueBox origVB = origInvokeExpr.getArgBox(i);

              if (JSAStrings.v().isHotspotValue(origVB.getValue())) {
                  ValueBox cloneVB = cloneInvokeExpr.getArgBox(i);
                  JSAStrings.v().copyResult(origVB.getValue(), 
                      cloneInvokeExpr.getMethodRef().getSignature(), 
                      i, 
                      cloneVB);
              }
          }
      }   
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


  /**
   * Return true if this value is a hotspot that was resolved by JSA.
   */
  public boolean isHotspotValue(Value v) {
      return this.hasRun && status != Status.TIMEDOUT_ANALYSIS && nonterminals.containsKey(v);
  }
  
  /**
   * Get the mapping from signature to hotspots.
   * @return
   */
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
    timeout = config.stringAnalysisTimeout;
  }

  /**
   * Run the analysis, after init.
   * @throws Throwable 
   */
  public static void run() {
    Callable<Object> callAnalyze = new Callable<Object>() {
      @Override
      public String call() throws Exception {
        v().hasRun = true;
        v().analyze();
        return null;
      }
    };
    try {
      // logger.info("Running JSA with timeout " + timeout);
      runWithTimeout(callAnalyze, timeout, TimeUnit.MINUTES);
    } catch (TimeoutException e) {
      v().status = Status.TIMEDOUT_ANALYSIS;
      logger.warn("Timed out when running JSA");
    } catch (Exception e) {
      logger.error("Exception when running JSA: {}", e.getCause());
      droidsafe.main.Main.exit(1);
    }
  }

  /**
   * Run the analysis.
   */
  private void analyze() {
    logger.info("Action hotspots: " + hotspots.size());
    StopWatch timer = new StopWatch();
    timer.start();

    sa = new StringAnalysis(hotspots); // Run the analysis.

    timer.stop();
    logger.info("[Strig Analysis] Multi-level automaton: " + timer);
    
    timeout -= timer.getTime() / 1000 / 60; // in minutes

    for (ValueBox h : hotspots) {
      // automata.put(h.getValue(),sa.getAutomaton(h));
      nonterminals.put(h.getValue(), sa.getNonterminal(h));
    }

    gv = new GrammarVisitor(sa.getGrammar());
    return;
  }
  
  /**
   * Another pass might need to add to the results for JSAStrings.  This method will
   * clone an existing result to a new value box + hotspot.
   */
  public void copyResult(Value toCopy, String calleeSig, int newArgNum, 
                               ValueBox newVB) {
      hotspots.add(newVB);
      regexMap.put(newVB.getValue(), regexMap.get(toCopy));
      nonterminals.put(newVB.getValue(), nonterminals.get(toCopy));
      
      List<ValueBox> vbs = new LinkedList<ValueBox>();
      vbs.add(newVB);
      addSignatureToHotspotMap(calleeSig, new Hotspot(calleeSig, newArgNum, hotspots));
  }

  /**
   * Auxiliary method to add an element to the hotspot map.
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
   * @return 
   */
  public List<ValueBox> addArgumentHotspots(String signature, int arg) {
    List<ValueBox> sigSpots = StringAnalysis.getArgumentExpressions(signature, arg);
    return addArgumentHotspots(signature, arg, sigSpots);
  }

  /**
   * Add a hotspot for matching calls.
   * 
   * @param signature The signature of the method.
   * @param arg The argument index of the hotspot.
   * @param sigSpots the hotspot instances for the method and the argument index.
   * @return 
   */
  public List<ValueBox> addArgumentHotspots(String signature, int arg, List<ValueBox> sigSpots) {
    // List<ValueBox> sigSpots = StringAnalysis.getArgumentExpressions(signature, arg);
    logger.debug("For signature " + signature + " and arg " + arg  + " got " + sigSpots.size() + " hotspots.");

    if (!sigSpots.isEmpty()) {
      addSignatureToHotspotMap(signature, new Hotspot(signature, arg, sigSpots));
      hotspots.addAll(sigSpots);
    }
    return sigSpots;
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
    String res = regexMap.get(v);
    return (res == null) ? "<any string>" : res;
  }
  
  /**
   * Generate the regular expression for the given Value.
   * 
   * @param v The Soot Value associated with the hotspot.
   * @return
   */
  public String generateRegex(Value v) {
    try {
      RE regex = gv.getRE(nonterminals.get(v));
      String res = regex.simplifyOps().toString();
      regexMap.put(v, res);
      return res;
    } catch (NullPointerException e) {
      return "";
    }
  }

  /**
   * Generate the regular expression for the given Value.
   * 
   * @param v The Soot Value associated with the hotspot.
   * @return
   */
  public String generateRegex(final Value v, long timeout, TimeUnit timeUnit) {
    Callable<String> callable = new Callable<String>() {
      @Override
      public String call() throws Exception {
        return generateRegex(v);
      }
    };
    try {
      return runWithTimeout(callable, timeout, timeUnit);
    } catch (TimeoutException e) {
      logger.info("Timed out when generating regex for " + v);
      reGenTimoutCount++;
    } catch (Exception e) {
      logger.info("Exception when generating regex for " + v + ": " + e.getCause());
    }
    return "<any string>";
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
  @Deprecated
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
    if (status == Status.TIMEDOUT_ANALYSIS) {
      logger.warn("String analysis timed out.");
    } else {
      logger.debug("Done with String analysis");
      Callable<Object> callGenerateREs = new Callable<Object>() {
        @Override
        public String call() throws Exception {
          generateRegexs();
          return null;
        }
      };
      try {
        // logger.info("Generating regular expressions with timeout " + timeout);
        runWithTimeout(callGenerateREs, timeout, TimeUnit.MINUTES);
      } catch (TimeoutException e) {
        v().status = Status.TIMEDOUT_REGEN;
        logger.warn("Timed out when running regex generatation");
      } catch (Exception e) {
        logger.info("Exception when running regex generatation: " + e.getCause());
      }
      if (reGenTimoutCount > 0) {
        logger.warn("Regular expression generatation timed out on " + reGenTimoutCount + " of " + hotspots.size() + " hotspots.");
      }
    }
  }

  private void generateRegexs() {
    JSAStrings singleton = JSAStrings.v();

    // LWG
    // for (ValueBox v : singleton.getHotspots()) {
    //   // exploreRegex(automata.get(v.getValue()));
    //   logger.debug("Hotspot: " + sa.getSourceFile(v) + ":::" + sa.getLineNumber(v) + ":::"
    //       + singleton.getRegex(v.getValue()));
    // }

    int i = 1;
    for (String sig: signatureToHotspotMap.keySet()) {
      for (Hotspot hotspot: signatureToHotspotMap.get(sig)) {
        int arg = hotspot.getArgumentPosition();
        logger.info("");
        logger.info(sig + ","+arg);
        for (ValueBox v: hotspot.getHotspots()) {
          // exploreRegex(automata.get(v.getValue()));
          logger.info("  "+ i++ +": " + sa.getClassName(v) + ": line " + sa.getLineNumber(v) + " : " + v.getValue());
          logger.info("     regular expression: \"" + singleton.generateRegex(v.getValue(), 30, TimeUnit.SECONDS) + "\"");
        }
      }
    }
  }

  // LWG: Allow application classes to be filtered from soot.Scene
  /**
   * Set the application classes that JSA will analyze.
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
        if (Project.v().isSrcClass(cls) || Project.v().isDroidSafeGeneratedClass(cls)) {
            srcClasses.add(cls);
        }   
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

    /** 
     * Constructor
     * @param signature
     * @param position
     * @param values
     */
    public Hotspot(String signature, int position, List<ValueBox> values) {
      this.methodSignature = signature;
      this.argumentPosition = position;
      this.hotspots = values;
    }

    /**
     * Constructor
     * @param signature
     * @param values
     */
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
  
  // ***********************************************************************************************
  // LWG
  
  public static <T> T runWithTimeout(Callable<T> callable, long timeout, TimeUnit timeUnit) 
      throws Exception {
    if (timeout == 0) {
      return callable.call();
    } else {
      final ExecutorService executor = Executors.newSingleThreadExecutor();
      final Future<T> future = executor.submit(callable);
      executor.shutdown(); // This does not cancel the already-scheduled task.
      return future.get(timeout, timeUnit);
    }
  }

}
