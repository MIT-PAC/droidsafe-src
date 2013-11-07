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
import droidsafe.utils.SootUtils;

/**
 * Load and serve the mapping of API methods to high level information kinds.
 * The mapping were taken from the SuSi paper for Android 4.2 and we define a mapping
 * from SootMethod -> Set<InfoKind> for both source and sink methods.
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
    public static final Pattern sigRE = Pattern.compile("(<[^<>]*>) (\\S+ )?\\((\\S+)\\)");
    /** Static singleton */
    private static APIInfoKindMapping v;
    /** map of sources from soot method to info kinds */
    private Map<SootMethod,Set<InfoKind>> srcsMapping;
    /** map of sinks from soot method to info kinds */
    private Map<SootMethod,Set<InfoKind>> sinksMapping;
    /** default info kind for a spec or ban method that is not labeled */
    public InfoKind SENSITIVE_NOCATEGORY;
    
    /** ignore kinds with these names */
    private static Set<String> IGNORE_INFOKINDS = new HashSet<String>(java.util.Arrays.asList(
        "NO_CATEGORY"
        ));
    
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
        srcsMapping = new HashMap<SootMethod,Set<InfoKind>>();
        sinksMapping = new HashMap<SootMethod,Set<InfoKind>>();
        SENSITIVE_NOCATEGORY = InfoKind.getInfoKind("SENSITIVE_NOCATEGORY");
    }

    /**
     * Return turn if the method is a source method that has a high level information kind defined.
     */
    public boolean hasSourceInfoKind(SootMethod method) {
        if (srcsMapping.containsKey(method)) 
            return true;
        
        //check for all overriden methods because of possible cloning
        if (API.v().isSystemMethod(method)) {
            for (SootMethod parent : 
                SootUtils.getOverriddenMethodsFromParents(method.getDeclaringClass(), method.getSubSignature())) {
                if (srcsMapping.containsKey(parent))
                    return true;
            }
        }
        
        return false;
    }
    
    /**
     * Return the high level information kinds defined for this source method.  Search all parent overriden methods
     * as well for info kind.
     */
    public Set<InfoKind> getSourceInfoKinds(SootMethod method) {
        if (srcsMapping.containsKey(method))
            return srcsMapping.get(method);
        
        Set<InfoKind> kinds = new HashSet<InfoKind>();
        
        if (API.v().isSystemMethod(method)) {
            for (SootMethod parent : 
                SootUtils.getOverriddenMethodsFromParents(method.getDeclaringClass(), method.getSubSignature())) {
                kinds.addAll(srcsMapping.get(parent));
            }
        }
        
        return kinds;
    }
    
    /**
     * Return turn if the method is a sink method that has a high level information kind defined.
     * Search all parent overriden methods as well for info kind.
     */
    public boolean hasSinkInfoKind(SootMethod method) {
        if (sinksMapping.containsKey(method)) 
            return true;
        
        //check for all overriden methods because of possible cloning
        if (API.v().isSystemMethod(method)) {
            for (SootMethod parent : 
                SootUtils.getOverriddenMethodsFromParents(method.getDeclaringClass(), method.getSubSignature())) {
                if (sinksMapping.containsKey(parent))
                    return true;
            }
        }
        
        return false;
    }
    
    /**
     * Return the high level information kinds defined for this sink method. Search all parent overriden methods
     * as well for info kind.
     */
    public Set<InfoKind> getSinkInfoKinds(SootMethod method) {
        if (sinksMapping.containsKey(method))
            return sinksMapping.get(method);
        
        Set<InfoKind> kinds = new HashSet<InfoKind>();
        
        if (API.v().isSystemMethod(method)) {
            for (SootMethod parent : 
                SootUtils.getOverriddenMethodsFromParents(method.getDeclaringClass(), method.getSubSignature())) {
                kinds.addAll(sinksMapping.get(parent));
            }
        }
        
        return kinds;
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
     * Read the sink or source mapping file and add the mappings to the map argument.
     */
    private void readMappingFile(File file, Map<SootMethod, Set<InfoKind>> mapping) {
        try {
            LineNumberReader br = new LineNumberReader (new FileReader (file));
            String line = null;
            int lineNum = 0;
            int notFound = 0;
            int found = 0;
            while ((line = br.readLine()) != null) {
                lineNum = br.getLineNumber();
                line = line.trim();
                
                Matcher matcher = sigRE.matcher(line);
                boolean b = matcher.matches();
                
                if (b) {
                    String methodSig = matcher.group(1);
                    String permission = matcher.group(2);
                    String infoKind = matcher.group(3);

                    //ignore NO_CATEGORY because it tells us nothing really
                    if (IGNORE_INFOKINDS.contains(infoKind))
                        continue;
                    
                    try {
                        SootMethod sootMethod = Scene.v().getMethod(methodSig);
                        
                        if (!mapping.containsKey(sootMethod)) {
                            mapping.put(sootMethod, new HashSet<InfoKind>());
                        }
                        mapping.get(sootMethod).add(InfoKind.getInfoKind(infoKind));
                        //System.out.println("Adding to mapping " + methodSig + " -> " + infoKind);
                        found++;
                    } catch (Exception e) {
                        notFound ++;
                    }
                }
            }
            logger.info("Number of methods for info kind mapping from " + file + ": "+ found);
            logger.info("Number of methods not in scene for info kind mapping from " + file + ": "+ notFound);
        } catch (IOException e) {
            logger.error("Error reading information king mapping file.", e);
            droidsafe.main.Main.exit(1);
        }
    }
}