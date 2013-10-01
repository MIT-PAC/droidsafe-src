package droidsafe.analyses.infoflow;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Scene;
import soot.SootMethod;

import droidsafe.android.system.API;
import droidsafe.main.Config;

/**
 * Load and server the mapping of API methods to high level information kinds.
 * The mapping were taken from the SuSi paper for Android 4.2 and we define a mapping
 * from SootMethod -> InfoKind for both source and sink methods.
 * 
 * @author mgordon
 *
 */
public class APIInfoKindMapping {
    /** Logger object */
    private final static Logger logger = LoggerFactory.getLogger(APIInfoKindMapping.class);
    /** relative file name for mapping file for sources */
    private static String SRC_MAPPING_FILENAME = "sources-4.2.txt";
    /** relative file name for mapping file for sinks */
    private static String SINK_MAPPING_FILENAME = "sinks-4.2.txt";
    /** regular expression for entries in the mapping files */
    public static final Pattern sigRE = Pattern.compile("(<[^<>]*>) \\((\\S+)\\)");
    /** Static singleton */
    private static APIInfoKindMapping v;
    /** map of sources from soot method to info kind */
    private HashMap<SootMethod,InfoKind> srcsMapping;
    /** map of sinks from soot method to info kind */
    private HashMap<SootMethod,InfoKind> sinksMapping;
    /** map of strings to the info kind that represents them */
    private HashMap<String,InfoKind> infoKinds;
    
    /**
     * Return the static singleton.
     */
    public static APIInfoKindMapping v() {
        return v;
    }
    
    /**
     * Init maps...
     */
    private APIInfoKindMapping() {
        srcsMapping = new HashMap<SootMethod,InfoKind>();
        sinksMapping = new HashMap<SootMethod,InfoKind>();
        infoKinds = new HashMap<String,InfoKind>();
    }

    /**
     * Return turn if the method is a source method that has a high level information kind defined.
     */
    public boolean hasSourceInfoKind(SootMethod method) {
        return srcsMapping.containsKey(method);
    }
    
    /**
     * Return the high level information kind defined for this source method.
     */
    public InfoKind getSourceInfoKind(SootMethod method) {
        return srcsMapping.get(method);
    }
    
    /**
     * Return turn if the method is a sink method that has a high level information kind defined.
     */
    public boolean hasSinkInfoKind(SootMethod method) {
        return sinksMapping.containsKey(method);
    }
    
    /**
     * Return the high level information kind defined for this sink method.
     */
    public InfoKind getSinkInfoKind(SootMethod method) {
        return sinksMapping.get(method);
    }
    
    /** 
     * Load the mappings from the files.
     */
    public static void initMapping() {
        v = new APIInfoKindMapping();
                
        String parentDir = Config.v().getApacHome() + File.separator + "tools" + File.separator + "susi" +
                File.separator;
        
        File srcsFile = new File(parentDir, SRC_MAPPING_FILENAME);
        v.readMappingFile(srcsFile,v.srcsMapping);
        
        File sinksFile = new File(parentDir, SINK_MAPPING_FILENAME);
        v.readMappingFile(sinksFile, v.sinksMapping);
    }
    
    /** 
     * Given a string return (or create and return) the InfoKind object that
     * represents it.
     */
    public InfoKind getInfoKind(String str) {
        if (!infoKinds.containsKey(str)) {
            infoKinds.put(str, new InfoKind(str));
        }
        
        return infoKinds.get(str);
    }
   
    /**
     * Read the sink or source mapping file and add the mappings to the map argument.
     */
    private void readMappingFile(File file, Map<SootMethod, InfoKind> mapping) {
        try {
            LineNumberReader br = new LineNumberReader (new FileReader (file));
            String line = null;
            int lineNum = 0;
            int notFound = 0;
            while ((line = br.readLine()) != null) {
                lineNum = br.getLineNumber();
                line = line.trim();
                
                Matcher matcher = sigRE.matcher(line);
                boolean b = matcher.matches();
                
                if (b) {
                    String methodSig = matcher.group(1);
                    String infoKind = matcher.group(2);
                    
                    try {
                        SootMethod sootMethod = Scene.v().getMethod(methodSig);
                        mapping.put(sootMethod, getInfoKind(infoKind));
                    } catch (Exception e) {
                        notFound ++;
                    }
                }
            }
            logger.info("Number of methods not in scene for info kind mapping from " + file + ": "+ notFound);
        } catch (IOException e) {
            logger.error("Error reading information king mapping file.", e);
            droidsafe.main.Main.exit(1);
        }
    }
}

/**
 * High Level information kind identified by a string type (name).
 * 
 * @author mgordon
 *
 */
class InfoKind implements MyValue {
    /** name of this information kind */
    private String name;
   
    /**
     * Create a new information kind named str.
     */
    InfoKind(String str) {
        this.name = str;
    }
    
    /**
     * Return the string name of this information kind.
     */
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        InfoKind other = (InfoKind) obj;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) return false;
        return true;
    }
    
    
}