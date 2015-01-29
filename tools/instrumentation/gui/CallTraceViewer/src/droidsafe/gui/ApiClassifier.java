/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package droidsafe.gui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Nguyen Nguyen
 */
public class ApiClassifier {
    
    private static Logger logger = LoggerFactory.getLogger(ApiClassifier.class);
    private static ApiClassifier instance = new ApiClassifier();
    
    private static final String CLASSIFCATION_SAFE = "@DSSafe";
    private static final String CLASSIFCATION_SPEC = "@DSSpec";
    private static final String CLASSIFCATION_BAN =  "@DSBan";
    private static final String CLASSIFCATION_UNK =  "UNCLASSIFED";
    
    private static final String INFO_SINK   = "@DSSink";
    private static final String INFO_SOURCE = "@DSSource";
    private static final String INFO_UNK = "NO_INFO";
    
    
    private static class InfoClassification {
        public String classification;
        public String info;
        public InfoClassification() {
            classification = CLASSIFCATION_UNK;
            info = INFO_UNK;
        }
        
        @Override
        public String toString() {
            return classification + " - " + info;
        }
    }
    
    
    private Map<String, InfoClassification> classificationMap;
    
    private Random rand;
    
    private ApiClassifier() {
        rand = new Random();
        
        classificationMap = new HashMap<String, InfoClassification>();
        
    }
    
    
    //////////////////////Public interface //////////////////////////
    public static ApiClassifier v() { return instance; }
    
    public void load(String file) {
        
    }
    
    public void loadLines(List<String> lines) {
        for (String line: lines) {
             //logger.info("=> {}", line);
            if (line.contains("#"))
                continue;

            if (!line.contains(":") && !line.contains("-"))
                continue;

            String[] tokens = line.split("\\-");
            if (tokens.length < 2)
                continue;

            int methodStartInd = line.indexOf("<");
            int methodEndInd = line.indexOf(")>");
            
            if (methodStartInd == -1 || methodStartInd == -1)
                continue;
            
            String method = line.substring(methodStartInd, methodEndInd + 2);
            //logger.info("{}", method);    
            
            InfoClassification infoClass = new InfoClassification();
            
            if (line.contains(CLASSIFCATION_SAFE))
                infoClass.classification = CLASSIFCATION_SAFE;
            if (line.contains(CLASSIFCATION_SPEC))
                infoClass.classification = CLASSIFCATION_SPEC;
            if (line.contains(CLASSIFCATION_BAN))
                infoClass.classification = CLASSIFCATION_BAN;    
            
            
             if (line.contains(INFO_SINK))
                infoClass.info = INFO_SINK;
             if (line.contains(INFO_SOURCE))
                infoClass.info = INFO_SOURCE;
                       
             //logger.info("{} => {} ", method, infoClass);
             classificationMap.put(method, infoClass);
        }
    }
    public boolean isSpec(String api) {
        logger.info("Checking spec for {}", api);
        if (classificationMap.containsKey(api)) {
        
            InfoClassification infoClass = classificationMap.get(api);
            logger.info("api has entry, value {} ", infoClass.classification);
            
            return infoClass.classification.equals(CLASSIFCATION_SPEC);
        }        
        return false;                
    }
    
     public boolean isBan(String api) {
        if (classificationMap.containsKey(api)) {                
            InfoClassification infoClass = classificationMap.get(api);
            return infoClass.classification.equals(CLASSIFCATION_BAN);
        }        
        return false;                
    }
     
    public boolean isSafe(String api) {
         if (classificationMap.containsKey(api)) {                
            InfoClassification infoClass = classificationMap.get(api);
            return infoClass.classification.equals(CLASSIFCATION_SAFE);
        }        
        return false;         
    }
    
    public boolean isSink(String api) {
        if (classificationMap.containsKey(api)) {                
            InfoClassification infoClass = classificationMap.get(api);
            return infoClass.info.equals(INFO_SINK);
        }        
        return false;         
    }
    
    public boolean isSource(String api) {
        if (classificationMap.containsKey(api)) {                
            InfoClassification infoClass = classificationMap.get(api);
            return infoClass.info.equals(INFO_SOURCE);
        }        
        return false;     
    }
    
}
