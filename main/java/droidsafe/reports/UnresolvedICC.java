package droidsafe.reports;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.SootClass;
import soot.jimple.Stmt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UnresolvedICC {
    private final static Logger logger = LoggerFactory.getLogger(UnresolvedICC.class);
    
    private static UnresolvedICC v;
   
    private Indicator<TopLevelContent> indicator;
    
    private Set<Stmt> added;
    
    private static final String FILE_NAME = "icc_calls_unresolved.json";
    
    public static UnresolvedICC v() {
        if (v == null)
            v = new UnresolvedICC();
        
        return v;
    }
    
    private UnresolvedICC() {
        indicator = new Indicator<TopLevelContent>("ICC: Unresolved Calls");
        added = new HashSet<Stmt>();
        indicator.addVisibility("icc_call");
    }
    
    private class TopLevelContent extends SourceContent {
        String type = "icc_call";
                     
        public TopLevelContent(Stmt stmt) {
            setSource(stmt);
        }
    }
  
    public void addInfo(Stmt genStmt) {
        //do not add something twice
        if (!added.add(genStmt))
            return;
        
        TopLevelContent newTL = new TopLevelContent(genStmt);
        indicator.addContents(newTL);
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
