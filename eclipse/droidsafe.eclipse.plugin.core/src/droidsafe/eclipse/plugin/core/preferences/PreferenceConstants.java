package droidsafe.eclipse.plugin.core.preferences;

/**
 * Constant definitions for plug-in preferences
 */
public class PreferenceConstants {

  /**
   * Target pass to run
   */
  public static final String P_TARGET_PASS = "targetPassPreference";

  /**
   * Security Specification for application (used with confcheck)
   */
  public static final String P_SSL_FILE = "sslFilePreference";

  /**
   * Do not print source information in spec
   */
  public static final String P_NOSOURCE_INFO = "noSourceInfoPreference";

  /**
   * Print debug log to current ./droidsafe/droidsafe.log
   */
  public static final String P_DEBUGLOG = "debugLogPreference";

  /**
   * Fully analyze API classes from android.jar.
   */
  public static final String P_ANALYZEAPI = "analyzeAPIPreference";

  /**
   * Dump readable jimple files for all app classes in /droidsafe.
   */
  public static final String P_JIMPLE = "jimplePreference";

  /**
   * Analyze information flows
   */
  public static final String P_INFOFLOW = "infoFlowPreference";

  /**
   * Export information flows to FILE in DOT
   */
  public static final String P_INFOFLOWDOTFILE = "infoFlowDotFile";

  /**
   * Export information flows specific to METHOD only: METHOD is specified by its signature (e.g.
   * \"<com.jpgextractor.PicViewerActivity: void sendExif(java.util.ArrayList)>\")
   */
  public static final String P_INFOFLOWMETHOD = "infoFlowMethod";

  /**
   * Dump pta to a file
   */
  public static final String P_DUMP_PTA = "dumpPTA";

  public static final String P_DUMP_CALL_GRAPH = "dumpCallGraph";

  /**
   * Run the JSA string analysis
   */
  public static final String P_RUN_STRING_ANALYSIS = "runStringAnalysis";

  /**
   * if true, string analysis is done for all soot application classes. Otherwise, it is only done
   * for the source classes of the project.
   */
  public static final String P_UNFILTERED_STRING_ANALYSIS = "unfilteredStringAnalysis";

}
