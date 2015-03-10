/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package droidsafe.reports;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.SootClass;
import soot.SootMethod;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import droidsafe.analyses.cg.collapsedcg.CollaspedCallGraph;
import droidsafe.analyses.cg.collapsedcg.CollaspedCallGraph.CallToTarget;
import droidsafe.android.system.API;
import droidsafe.android.system.InfoKind;

public class SensitiveSources  {
    private final static Logger logger = LoggerFactory.getLogger(ICCMap.class);

    private static SensitiveSources v;

    private Indicator<ClassTopLevel> indicator;
    
    private static final String FILE_NAME = "sensitive_sources.json";

    private Map<SootClass, ClassTopLevel> classToContent;
    private Map<SootMethod, MethodLevel> methodToContent;
    
    private SensitiveSources() {
        indicator = new Indicator<ClassTopLevel>("Sensitive Sources");
        classToContent = new HashMap<SootClass, ClassTopLevel>();
        methodToContent = new HashMap<SootMethod, MethodLevel>();
        
        indicator.addDisplay("info_kinds");
        
        findSources();
    }

    public static SensitiveSources v() {
        if (v == null) 
            v = new SensitiveSources();
        
        return v;
    }

    private void findSources() {
        //use collapsed callgraph to find all calls
        
        for (SootMethod method : CollaspedCallGraph.v().getAllMethods()) {
            for (CallToTarget apiCall : CollaspedCallGraph.v().getAPICallTargets(method)) {
                if (API.v().hasSourceInfoKind(apiCall.getTarget())) {
                    if (!classToContent.containsKey(method.getDeclaringClass())) {
                        ClassTopLevel newctl = new ClassTopLevel(method.getDeclaringClass());
                        classToContent.put(method.getDeclaringClass(), newctl);
                        indicator.addContents(newctl);
                    }
                    
                    ClassTopLevel ctl = classToContent.get(method.getDeclaringClass());
                    
                    ctl.addStmt(method, apiCall.getStmt(), apiCall.getTarget());
                }
            }
        }
    }
    
    private class ClassTopLevel {
        String label;
        ArrayList<MethodLevel> contents = new ArrayList<MethodLevel>();
        
        public ClassTopLevel(SootClass clz) {
            this.label = clz.getName();
        }
        
        public void addStmt(SootMethod source, Stmt stmt, SootMethod target) {
            if (!methodToContent.containsKey(source)) {
                MethodLevel ml = new MethodLevel(source);
                methodToContent.put(source, ml);
                contents.add(ml);
            }
            
            methodToContent.get(source).addStmt(stmt, target);
        }
    }
    
    private class MethodLevel {
        String signature;
        ArrayList<StmtLevel> contents = new ArrayList<StmtLevel>();
        String link = "as_entry_point";
        
        public MethodLevel(SootMethod method) {
            this.signature = method.getSignature();
        }
        
        public void addStmt(Stmt stmt, SootMethod target) {
            contents.add(new StmtLevel(stmt, target));
        }
    }
    
    private class StmtLevel extends SourceContent {
        String signature;
        String link = "as_call";
        String info_kinds;
        
        public StmtLevel(Stmt genStmt, SootMethod target) {
            setSource(genStmt);
            
           signature = target.getSignature();
           
           Set<InfoKind> infoKinds = API.v().getSourceInfoKinds(target);
           StringBuffer kinds = new StringBuffer();
           for (InfoKind kind : infoKinds) 
               kinds.append(kind.toString() + " ");
           info_kinds = kinds.toString();
        }
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
