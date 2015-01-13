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

import droidsafe.analyses.cg.StmtEdge;
import droidsafe.analyses.cg.collapsedcg.CollaspedCallGraph;
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

    private Map<String, ClassContent> topLevelMap = new HashMap<String, ClassContent>();

    private Map<Stmt, ICCCallContent> innerContentMap = new HashMap<Stmt, ICCCallContent>();

    private Indicator<ClassContent> indicator;

    private static final String FILE_NAME = "iccmap.json";

    public static ICCMap v() {
        if (v == null)
            v = new ICCMap();

        return v;
    }

    private ICCMap() {
        indicator = new Indicator<ClassContent>("ICC: Resolved Map");
        indicator.addVisibility("icc_source");

    }

    private class ClassContent {
        String type = "icc_source";
        String label;
        ArrayList<ICCCallContent> contents = new ArrayList<ICCCallContent>();        


        public ClassContent(String src) {
            this.label = src;
        }
    }

    private class ICCUndefinedCallBack extends SourceContent {
        String type = "icc_dest";
        String label;

        public ICCUndefinedCallBack(SootClass clz, SootMethod method) {
            SourceLocationTag slt = new SourceLocationTag(clz.getName(), 1);
            setSource(slt);
            this.label = clz + " " + method.getSubSignature();
        }
    }

    private class ICCConcreteCallBack extends SourceContent {
        String type = "icc_dest";
        String signature;
        String link = "as_entry_point";

        public ICCConcreteCallBack(SootMethod method) {
            setSource(method);
            this.signature = method.getSignature();
        }
    }

    private class ICCCallContent extends SourceContent {
        String type = "icc_stmt";
        String signature;
        String link = "as_call";

        ArrayList<Object> contents = new ArrayList<Object>();

        public ICCCallContent(Stmt genStmt) {
            this.setSource(genStmt);

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
        }

        public void addTarget(SootMethod method) {
            contents.add(new ICCConcreteCallBack(method));
        }

        public void addUnResolvedTarget(SootClass dest, SootMethod method) {
            contents.add(new ICCUndefinedCallBack(dest, method));
        }
    }

    public void addInfo(SootClass src, SootClass dest, Stmt genStmt, SootMethod target) {
        String srcStr = src.getName();
        String destStr = dest.getName();

        if (!topLevelMap.containsKey(srcStr)) {
            ClassContent newTL = new ClassContent(srcStr);
            topLevelMap.put(srcStr, newTL);
            indicator.addContents(newTL);
        }

        ClassContent tlc = topLevelMap.get(srcStr);

        if (!innerContentMap.containsKey(genStmt)) {
            ICCCallContent ic = new ICCCallContent(genStmt);
            innerContentMap.put(genStmt, ic);
            tlc.contents.add(ic);
        }

        if (dest.declaresMethod(target.getSubSignature())) {
            innerContentMap.get(genStmt).addTarget(target);
        } else
            innerContentMap.get(genStmt).addUnResolvedTarget(dest, target);

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
