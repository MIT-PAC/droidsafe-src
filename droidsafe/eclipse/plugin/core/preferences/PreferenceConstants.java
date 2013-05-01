package droidsafe.eclipse.plugin.core.preferences;

/**
 * Constant definitions for plug-in preferences
 */
public class PreferenceConstants {

	//public static final String P_PATH = "pathPreference";

	//public static final String P_BOOLEAN = "booleanPreference";

	//public static final String P_CHOICE = "choicePreference";

	//public static final String P_STRING = "stringPreference";

	// Target pass to run
	public static final String P_TARGET_PASS = "targetPassPreference";
	
	// Security Specification for application (used with confcheck)
	public static final String P_SSL_FILE = "sslFilePreference";
	
	// Do not print source information in spec
	public static final String P_NOSOURCE_INFO = "noSourceInfoPreference";
	
	// Print debug log to current ./droidsafe/droidsafe.log
	public static final String P_DEBUGLOG = "debugLogPreference";

	// Fully analyze API classes from android.jar.
	public static final String P_ANALYZEAPI = "analyzeAPIPreference";

	// Dump readable jimple files for all app classes in /droidsafe.
	public static final String P_JIMPLE = "jimplePreference";

	// Analyze information flows
	public static final String P_INFOFLOW = "infoFlowPreference";

	// Export information flows to FILE in DOT
	public static final String P_INFOFLOWDOTFILE = "infoFlowDotFile";

	// Export information flows specific to METHOD only: METHOD is specified by
	// its signature (e.g. \"<com.jpgextractor.PicViewerActivity: void
	// sendExif(java.util.ArrayList)>\")
	public static final String P_INFOFLOWMETHOD = "infoFlowMethod";

}
