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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Value;
import soot.ValueBox;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.pta.IAllocNode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.system.API;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;

public class UnresolvedICC {
    private final static Logger logger = LoggerFactory.getLogger(UnresolvedICC.class);

    private static UnresolvedICC v;

    private Indicator<TopLevelContent> indicator;

    private Map<SootClass, TopLevelContent> added;

    private static final String FILE_NAME = "ipc_calls_unresolved.json";

    private Set<Object> alreadyAdded = new HashSet<Object>();

    private Set<SootMethod> sendMessageMethods = new HashSet<SootMethod>();

    private Set<SootClass> addedClasses = new HashSet<SootClass>();

    public static UnresolvedICC v() {
        if (v == null)
            v = new UnresolvedICC();

        return v;
    }

    private UnresolvedICC() {
        indicator = new Indicator<TopLevelContent>("ICC: Unresolved Calls");
        added = new HashMap<SootClass, TopLevelContent>();
        indicator.addDisplay("desc");

        sendMessageMethods.add(Scene.v().getMethod("<android.os.Messenger: void send(android.os.Message)>"));
        sendMessageMethods.add(Scene.v().getMethod("<android.os.Handler: boolean sendMessage(android.os.Message)>"));

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

        public InnerLevelCallContent(Stmt genStmt, SootMethod target, String desc) {
            setSource(genStmt);
            this.signature = target.getSignature();
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

        if (alreadyAdded.contains(method)) 
            return;

        alreadyAdded.add(method);        

        addedClasses.add(clz);
        //needed because sometimes the binding is done in an inner class
        if (SootUtils.isInnerClass(clz)) {            
            addedClasses.add(SootUtils.getOuterClass(clz));
        }
        
        if (!added.containsKey(clz)) {
            TopLevelContent newTlc = new TopLevelContent(clz);
            indicator.addContents(newTlc);
            added.put(clz, newTlc);
        }

        InnerLevelContent newIL = new InnerLevelCallbackContent(method, desc);
        added.get(clz).contents.add(newIL);
    }

    public void addInfo(Stmt genStmt, SootMethod targetMethod, String desc) {
        if (alreadyAdded.contains(genStmt)) 
            return;

        alreadyAdded.add(genStmt);        

        SootClass clz = JimpleRelationships.v().getEnclosingMethod(genStmt).getDeclaringClass();
        addedClasses.add(clz);
        //needed because sometimes the binding is done in an inner class
        if (SootUtils.isInnerClass(clz)) {            
            addedClasses.add(SootUtils.getOuterClass(clz));
        }
        

        if (!added.containsKey(clz)) {
            TopLevelContent newTlc = new TopLevelContent(clz);
            indicator.addContents(newTlc);
            added.put(clz, newTlc);
        }

        InnerLevelContent newIL = new InnerLevelCallContent(genStmt, targetMethod, desc);
        added.get(clz).contents.add(newIL);

    }

    public void findUnboundMessageSends() {
        for (SootClass clz : addedClasses) {
            for (SootMethod method : clz.getMethods()) {
                if (!method.isConcrete())
                    continue;
                if (!method.hasActiveBody()) {
                	try {
                		method.retrieveActiveBody();
                	}
                	catch (Exception ex) {
                		logger.info("Exception retrieving method body {}", ex);
                		continue;
                	}

                }

                // find all calls to sendMessage / send
                for (Iterator stmts = method.getActiveBody().getUnits().iterator(); stmts.hasNext();) {
                    Stmt st = (Stmt) stmts.next();

                    if (st.containsInvokeExpr() && st.getInvokeExpr() instanceof InstanceInvokeExpr) {
                        InstanceInvokeExpr iie = (InstanceInvokeExpr)st.getInvokeExpr();
                        if ("send".equals(iie.getMethodRef().name()) ||
                                "sendMessage".equals(iie.getMethodRef().name())) {                           
                            for (SootMethod target : PTABridge.v().getTargetsInsNoContext(st)) {                                
                                if (sendMessageMethods.contains(target)) {
                                    addInfo(st, target, "Unbound Service");
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    public void toJSON(String parentDir) {
        findUnboundMessageSends();
        
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
