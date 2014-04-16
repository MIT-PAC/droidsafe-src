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
        
        public InnerLevelCallContent(Stmt genStmt) {
            setSource(genStmt);
            if (genStmt.containsInvokeExpr()) {
                InvokeExpr ie = genStmt.getInvokeExpr();
                this.signature = ie.getMethodRef().getSignature();
            } else {
                this.signature = ""; 
            }
        }
    }
  
    private class InnerLevelCallbackContent extends InnerLevelContent {
        String type = "icc_callback";
        String signature;  
        String link = "as_entry_point";
        
        public InnerLevelCallbackContent(SootMethod method) {
            setSource(method);
            signature = method.getSignature();
        }
    }
    
    public void addInfo(SootMethod method) {
        SootClass clz = method.getDeclaringClass();
       
        if (!added.containsKey(clz)) {
            TopLevelContent newTlc = new TopLevelContent(clz);
            indicator.addContents(newTlc);
            added.put(clz, newTlc);
        }
        
        InnerLevelContent newIL = new InnerLevelCallbackContent(method);
        added.get(clz).contents.add(newIL);
    }
    
    public void addInfo(Stmt genStmt) {
        SootClass clz = JimpleRelationships.v().getEnclosingMethod(genStmt).getDeclaringClass();
       
        if (!added.containsKey(clz)) {
            TopLevelContent newTlc = new TopLevelContent(clz);
            indicator.addContents(newTlc);
            added.put(clz, newTlc);
        }
        
        InnerLevelContent newIL = new InnerLevelCallContent(genStmt);
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
