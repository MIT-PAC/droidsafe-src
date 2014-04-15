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

import droidsafe.analyses.collapsedcg.CollaspedCallGraph;
import droidsafe.analyses.collapsedcg.StmtEdge;
import droidsafe.transforms.va.ServiceBindTransform;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;
import soot.SootClass;
import soot.SootMethod;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;

public class ICCMap {
    private final static Logger logger = LoggerFactory.getLogger(ICCMap.class);
    
    private static ICCMap v;
    
    private Map<String, TopLevelContent> topLevelMap = new HashMap<String, TopLevelContent>();
    
    private Map<Stmt, InnerContent> innerContentMap = new HashMap<Stmt, InnerContent>();
    
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
        
     }
    
    private class TopLevelContent {
        String type = "icc_source";
        String label;
        ArrayList<InnerContent> contents = new ArrayList<InnerContent>();        

        
        public TopLevelContent(String src) {
            this.label = src;
        }
    }
    
    private class InnerInnerContent extends SourceContent {
        String type = "icc_dest";
        String signature;
        String link = "as_entry_point";
        
        public InnerInnerContent(SootMethod method) {
            setSource(method);
            this.signature = method.getSignature();
        }
    }
    
    private class InnerContent extends SourceContent {
        String type = "icc_stmt";
        String signature;
        String link = "as_call";
        
        ArrayList<InnerInnerContent> contents = new ArrayList<InnerInnerContent>();
        
        public InnerContent(Stmt genStmt) {
            this.setSource(genStmt);
            
            if (genStmt.containsInvokeExpr()) {
                InvokeExpr ie = genStmt.getInvokeExpr();
                this.signature = ie.getMethodRef().getSignature();
            } else {
                this.signature = ""; 
            }
        }
        
        public void addTarget(SootMethod method) {
            contents.add(new InnerInnerContent(method));
        }
    }
    
    public void addInfo(SootClass src, SootClass dest, Stmt genStmt, SootMethod target) {
        String srcStr = src.getName();
        String destStr = dest.getName();
        
        if (!topLevelMap.containsKey(srcStr)) {
            TopLevelContent newTL = new TopLevelContent(srcStr);
            topLevelMap.put(srcStr, newTL);
            indicator.addContents(newTL);
        }
       
        TopLevelContent tlc = topLevelMap.get(srcStr);
        
        if (!innerContentMap.containsKey(genStmt)) {
            InnerContent ic = new InnerContent(genStmt);
            innerContentMap.put(genStmt, ic);
            tlc.contents.add(ic);
            ic.addTarget(target);
        }
    }
    
    //Add all edges that go through the api in the collasped call graph
    //these edges are only created for IPC calls 
    private void addAllIPC() {
        for (StmtEdge<SootMethod> edge : CollaspedCallGraph.v().getAllThroughAPIEdges()) {
            SootClass src = edge.getV1().getDeclaringClass();
            SootClass tgt = edge.getV2().getDeclaringClass();
            addInfo(src, tgt, edge.getStmt(), edge.getV2());
        }
    }
    
    public void toJSON(String parentDir) {
        addAllIPC();
        
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
