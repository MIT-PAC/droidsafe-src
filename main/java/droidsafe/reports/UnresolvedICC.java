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

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.system.API;
import droidsafe.utils.JimpleRelationships;

public class UnresolvedICC {
    private final static Logger logger = LoggerFactory.getLogger(UnresolvedICC.class);
    
    private static UnresolvedICC v;
   
    private Indicator<TopLevelContent> indicator;
    
    private Map<SootClass, TopLevelContent> added;
    
    private static final String FILE_NAME = "icc_calls_unresolved.json";
    
    public static UnresolvedICC v() {
        if (v == null)
            v = new UnresolvedICC();
        
        return v;
    }
    
    private UnresolvedICC() {
        indicator = new Indicator<TopLevelContent>("ICC: Unresolved Calls");
        added = new HashMap<SootClass, TopLevelContent>();
        indicator.addDisplay("desc");
    }
    
    private class TopLevelContent {
        String label;
        ArrayList<InnerLevelContent> contents = new ArrayList<InnerLevelContent>();
        
        public TopLevelContent(SootClass clz) {
            label = clz.getName();
        }    
    }
    
    private class InnerLevelContent extends SourceContent {
        
    }
    
    private class InnerLevelCallContent extends InnerLevelContent {
        String type = "icc_call";
        String signature;  
        String link = "as_call";
        String desc;
        
        public InnerLevelCallContent(Stmt genStmt, String desc) {
            setSource(genStmt);
            try {
                if (genStmt.containsInvokeExpr()) {
                    InvokeExpr ie = genStmt.getInvokeExpr();
                    this.signature = ie.getMethodRef().resolve().getSignature();
                } else {
                    this.signature = ""; 
                }
            } catch (Exception e) {
                this.signature = "";
            }
            
            this.desc = desc;
        }
    }
  
    private class InnerLevelCallbackContent extends InnerLevelContent {
        String type = "icc_callback";
        String signature;  
        String link = "as_entry_point";
        String desc;
        
        public InnerLevelCallbackContent(SootMethod method, String desc) {
            setSource(method);
            signature = method.getSignature();
            this.desc = desc;
        }
        
    }
    
    public void addInfo(SootMethod method, String desc) {
        SootClass clz = method.getDeclaringClass();
       
        if (!added.containsKey(clz)) {
            TopLevelContent newTlc = new TopLevelContent(clz);
            indicator.addContents(newTlc);
            added.put(clz, newTlc);
        }
        
        InnerLevelContent newIL = new InnerLevelCallbackContent(method, desc);
        added.get(clz).contents.add(newIL);
    }
    
    public void addInfo(Stmt genStmt, String desc) {
        SootClass clz = JimpleRelationships.v().getEnclosingMethod(genStmt).getDeclaringClass();
       
        if (!added.containsKey(clz)) {
            TopLevelContent newTlc = new TopLevelContent(clz);
            indicator.addContents(newTlc);
            added.put(clz, newTlc);
        }
        
        InnerLevelContent newIL = new InnerLevelCallContent(genStmt, desc);
        added.get(clz).contents.add(newIL);
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
