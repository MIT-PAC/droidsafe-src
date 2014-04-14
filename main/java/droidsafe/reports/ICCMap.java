package droidsafe.reports;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import droidsafe.transforms.va.ServiceBindTransform;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;
import soot.SootClass;
import soot.SootMethod;
import soot.jimple.Stmt;

public class ICCMap {
    private final static Logger logger = LoggerFactory.getLogger(ICCMap.class);
    
    private static ICCMap v;
    
    private Map<String, TopLevelContent> topLevelMap = new HashMap<String, TopLevelContent>();
    
    private Indicator<TopLevelContent> indicator;
    
    private static final String FILE_NAME = "iccmap.json";
    
    public static ICCMap v() {
        if (v == null)
            v = new ICCMap();
        
        return v;
    }
  
    private ICCMap() {
        indicator = new Indicator<TopLevelContent>("ICC: Resolved Map");
        indicator.addVisibility("icc_source");
        
        indicator.addDisplay("dest");
        indicator.addDisplay("src");
     }
    
    private class TopLevelContent {
        String type = "icc_source";
        String src;
        ArrayList<InnerContent> contents = new ArrayList<InnerContent>();        

        
        public TopLevelContent(String src) {
            this.src = src;
        }
    }
    
    private class InnerContent extends SourceContent {
        String type = "icc_dest";
        String dest;
        
        public InnerContent(String dest, Stmt genStmt) {
            this.dest = dest;
            this.setSource(genStmt);
        }
    }
    
    public void addInfo(SootClass src, SootClass dest, Stmt genStmt) {
        String srcStr = src.getName();
        String destStr = dest.getName();
        
        if (!topLevelMap.containsKey(srcStr)) {
            TopLevelContent newTL = new TopLevelContent(srcStr);
            topLevelMap.put(srcStr, newTL);
            indicator.addContents(newTL);
        }
       
        TopLevelContent tlc = topLevelMap.get(srcStr);
        tlc.contents.add(new InnerContent(destStr, genStmt));
    }
    
    public void toJSON(String parentDir) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
        String output = gson.toJson(indicator);
        FileWriter fw;
        try {
            fw = new FileWriter(parentDir + File.separator + FILE_NAME);
            fw.write(output);
            fw.close();
        } catch (IOException e) {
            logger.warn("Error writing json file.", e);
        }
    
    }
    
}
