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

package droidsafe.stats;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import soot.Body;
import soot.Hierarchy;
import soot.Local;
import soot.MethodContext;
import soot.MethodOrMethodContext;
import soot.PrimType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.IfStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.OrExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.spark.SparkEvaluator;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.ObjectSensitiveConfig;
import soot.jimple.toolkits.pta.IAllocNode;
import droidsafe.analyses.RCFGToSSL;
import droidsafe.analyses.cg.collapsedcg.CollaspedCallGraph;
import droidsafe.analyses.cg.collapsedcg.CollaspedCallGraph.CallToTarget;
import droidsafe.analyses.infoflow.InfoValue;
import droidsafe.analyses.infoflow.InformationFlowAnalysis;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.pta.SparkPTA;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.android.system.InfoKind;
import droidsafe.main.Config;
import droidsafe.speclang.Method;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;

public class PTAPaper {

    public static StringBuffer refinementStats = new StringBuffer(); 
    public static double infoFlowTimeSec;


    public static void writeReport() {
        //make sure collapsed call graph has been run       
        CollaspedCallGraph.v();

        FileWriter fw;
        try {
            String name = "";
            if ("".equals(Config.v().appName)) {
                name += "android-app";
            } else {
                name += Config.v().appName;
            }

            String additionalInfo = Config.v().additionalInfo;
            if (!"".equals(additionalInfo)) {
                additionalInfo = "_" + additionalInfo.replaceAll(" ", "_"); 
            }

            String fileName = name + "_" + getConfiguration().replaceAll(" ", "_") + 
                    additionalInfo + "_pta-report.txt";

            fw = new FileWriter(Project.v().getOutputDir() + File.separator + fileName);

            //write configuration details
            fw.write("App Name: " + name + "\n");
            fw.write("Config: " + getConfiguration() + "\n");
            fw.write("Cmdline supplied extra info: " + Config.v().additionalInfo + "\n");

            fw.write(refinementStats.toString());

            fw.write("Total complexity: " + ((SparkPTA)SparkPTA.v()).getAllocationGraph().getTotalComplexity() + "\n");
            
            //write final run of pta
            fw.write(SparkEvaluator.v().toString());

            //write total lines of code 
            fw.write("\nTotal Reachable LOC: " + getReachableLines() + "\n\n");

            //write information flow
            fw.write(infoFlowResults());
            
            //fw.write(finegrainedFlowResults());

            fw.close();
        } catch (IOException e) {

        }
    }

    public static void appendPTATimeToRefinement() {
        String ptastats = SparkEvaluator.v().toString();

        Pattern ptaTimeRegEx = Pattern.compile("Time \\(sec\\): ([0-9.]+)");
        Matcher m = ptaTimeRegEx.matcher(ptastats);
        if (m.find()) {
            refinementStats.append("Refinement Stage PTA Time (sec): " + m.group(1) + "\n");
        }

        refinementStats.append("Refinement Stage K: " + ObjectSensitiveConfig.v().k() + "\n");
    }

    private static String infoFlowResults() {
        Hierarchy hierarchy = Scene.v().getActiveHierarchy();
        SootClass throwable = Scene.v().getSootClass("java.lang.Throwable");

        StringBuffer buf = new StringBuffer();

        //count number of flows
        //have to map it down to invoke statement because of context

        //key is invoke of sink -> sources
        Map<InvokeExpr, Set<Stmt>> invokeToSourcesMem = new HashMap<InvokeExpr, Set<Stmt>>();
        //key is invoke of sink -> sources
        Map<InvokeExpr, Set<Stmt>> invokeToSourcesRec= new HashMap<InvokeExpr, Set<Stmt>>();
        //key is invoke of sink -> sources
        Map<InvokeExpr, Set<Stmt>> invokeToSourcesArgs = new HashMap<InvokeExpr, Set<Stmt>>();
        //key is invoke of sink -> sources
        Map<InvokeExpr, Set<Stmt>> invokeToSourcesArgsPrecise = new HashMap<InvokeExpr, Set<Stmt>>();

        for (Map.Entry<Method, List<Method>> block : RCFGToSSL.v().getSpec().getEventBlocks().entrySet()) {
            //only count events in src classes, not in libraries
            boolean inSrc = false;
            for (IAllocNode recNode : block.getKey().getReceiverAllocNodes()) {
                if (recNode.getType() instanceof RefType) {
                    SootClass clz = ((RefType)recNode.getType()).getSootClass();
                    if (Project.v().isSrcClass(clz)) {
                        inSrc = true;
                        break;
                    }                        
                }
            }

            if (!inSrc)
                continue;

            for (Method oe : block.getValue()) {
                if (oe.getSinkInfoKinds().size() > 0 &&
                        oe.getSourcesInfoKinds().size() > 0) {

                    //only count sensitive sinks
                    Stmt sinkInvoke = JimpleRelationships.v().getEnclosingStmt(oe.getInvokeExpr());
                    if (!InfoKind.callsSensitiveSink(sinkInvoke))
                        continue;

                    //we have a sink with connected sources
                    InvokeExpr ie = oe.getInvokeExpr();

                    //get args
                    for (int i = 0; i < oe.getNumArgs(); i++) {

                        Type formalArgType = oe.getActualArgType(i);
                        //ignore method arguments that have a declared type of throwable or a subclass of throwable
                        if (formalArgType instanceof RefType &&
                                !((RefType)formalArgType).getSootClass().isInterface() &&
                                hierarchy.isClassSubclassOfIncluding(((RefType)formalArgType).getSootClass(), throwable))
                            continue;

                        for (Map.Entry<InfoKind, Set<Stmt>> flows : oe.getArgSourceInfoUnitsConservative(i).entrySet()) {
                            for (Stmt source : flows.getValue()) {
                                if (InfoKind.callsSensitiveSource(source)) {
                                    if (!invokeToSourcesArgs.containsKey(ie)) {
                                        invokeToSourcesArgs.put(ie, new HashSet<Stmt>());
                                    }
                                    invokeToSourcesArgs.get(ie).add(source);                                    
                                }
                            }
                        }

                        for (Map.Entry<InfoKind, Set<Stmt>> flows : oe.getArgSourceInfoUnitsPrecise(i).entrySet()) {
                            for (Stmt source : flows.getValue()) {
                                if (InfoKind.callsSensitiveSource(source)) {
                                    if (!invokeToSourcesArgsPrecise.containsKey(ie)) {
                                        invokeToSourcesArgsPrecise.put(ie, new HashSet<Stmt>());
                                    }
                                    invokeToSourcesArgsPrecise.get(ie).add(source);                                    
                                }
                            }
                        }
                    }
                    //get receiver
                    for (Map.Entry<InfoKind, Set<Stmt>> flows : oe.getReceiverSourceInfoUnits().entrySet()) {
                        //ignore all non-critical flows 
                        for (Stmt source : flows.getValue()) {
                            if (InfoKind.callsSensitiveSource(source)) {
                                if (!invokeToSourcesRec.containsKey(ie)) {
                                    invokeToSourcesRec.put(ie, new HashSet<Stmt>());
                                }
                                invokeToSourcesRec.get(ie).add(source);
                            }
                        }

                    }
                    //get method accesses
                    for (Map.Entry<InfoKind, Set<Stmt>> flows : oe.getMethodInfoUnits().entrySet()) {
                        //ignore all non-critical flows
                        for (Stmt source : flows.getValue()) {
                            if (InfoKind.callsSensitiveSource(source)) {
                                if (!invokeToSourcesMem.containsKey(ie)) {
                                    invokeToSourcesMem.put(ie, new HashSet<Stmt>());
                                }

                                invokeToSourcesMem.get(ie).add(source);
                            }
                        }
                    }
                }
            }
        }

        //count number of flows
        int flowsIntoSinksArgs = 0;
        int flowsIntoSinksArgsPrecise = 0;
        int flowsIntoSinksMem = 0;
        int flowsIntoSinksRec = 0;

        try {           
            for (Map.Entry<InvokeExpr, Set<Stmt>> sink : invokeToSourcesArgs.entrySet()) {
                flowsIntoSinksArgs += sink.getValue().size();
            }      

            for (Map.Entry<InvokeExpr, Set<Stmt>> sink : invokeToSourcesArgsPrecise.entrySet()) {
                flowsIntoSinksArgsPrecise += sink.getValue().size();
            }                    

            for (Map.Entry<InvokeExpr, Set<Stmt>> sink : invokeToSourcesMem.entrySet()) {
                flowsIntoSinksMem += sink.getValue().size();
            }        

            for (Map.Entry<InvokeExpr, Set<Stmt>> sink : invokeToSourcesRec.entrySet()) {
                flowsIntoSinksRec += sink.getValue().size();
            }        

        } catch (Exception e) {

        }

        buf.append("Info Flow Time Sec: " + infoFlowTimeSec + "\n");

        buf.append("Flows into sinks (Args): " + flowsIntoSinksArgs + "\n");
        buf.append("Flows into sinks (Args, Precise): " + flowsIntoSinksArgsPrecise + "\n");
        buf.append("Flows into sinks (Mem): " + flowsIntoSinksMem + "\n");
        buf.append("Flows into sinks (Rec): " + flowsIntoSinksRec + "\n");

        buf.append(reachableSinksSources());

        return buf.toString();
    }

    private static String finegrainedFlowResults() {
        int totalReachableIfs = 0;
        int taintedReachableIfs = 0;
        
        int totalCountOfTaintSets = 0;
        int totalSizeOfTaintSets = 0;        
        
        long totalValues = 0;
        
        Set<InfoValue> allSrcs = new HashSet<InfoValue>();
        Set<Set<InfoValue>> allSrcSets = new HashSet<Set<InfoValue>>();
        
        StringBuffer buf = new StringBuffer();
        
        for (MethodOrMethodContext momc : PTABridge.v().getReachableMethodContexts()) {
            //reset counted locals for each method            
            Set<Value> countedLocals = new HashSet<Value>();
            
            SootMethod method = momc.method();
            
            if (!method.isConcrete()) 
                continue;
            try {
                Body body = method.retrieveActiveBody(); 

                Iterator<Unit> unitIt = body.getUnits().snapshotIterator();
                
                while (unitIt.hasNext()) {
                    Stmt stmt = (Stmt)unitIt.next();
                    
                    for (ValueBox vb : stmt.getUseAndDefBoxes()) {
                        Value v = vb.getValue();
                        
                        if (countedLocals.contains(v))
                            continue;
                        
                        countedLocals.add(v);
                                                   
                        Set<InfoValue> taints = getTaintSet(v, momc);
                        
                        if (taints != null)
                            totalValues++;
                        
                        if (taints != null && !taints.isEmpty()) {
                            allSrcs.addAll(taints);
                            
                            totalCountOfTaintSets++;
                            totalSizeOfTaintSets += taints.size();
                            
                            if (!allSrcSets.contains(taints))
                                allSrcSets.add(taints);
                            
                            countedLocals.add(v);                           
                        }
                    }
                    
                    if (stmt instanceof IfStmt) {
                        totalReachableIfs++;
                        boolean hasTainted = false;
                        
                        for (ValueBox vb : stmt.getUseBoxes()) {
                            Value v = vb.getValue();
                            
                            Set<InfoValue> taints = getTaintSet(v, momc);
                                                        
                            if (taints != null && !taints.isEmpty()) {
                                hasTainted = true;
                                break;
                            }
                        }
                        
                        totalReachableIfs++;
                                                
                        if (hasTainted) {
                            taintedReachableIfs++;
                        }
                           
                    }                      
                }
                
            } catch (Exception e){
                //ignore and continue
            }


        }

        buf.append("Tainted Reachable if statements: " + taintedReachableIfs + "\n");
        buf.append("Total Reachable if Statements: " + totalReachableIfs + "\n");
        buf.append("Count of non-zero taint sets for primitives and strings: " + totalCountOfTaintSets + "\n");
        buf.append("Total distinct reachable primitives or string values in code: " + totalValues + "\n");
        buf.append("Total size of non-zero taint sets for primitives and strings: " + totalSizeOfTaintSets + "\n");
        buf.append("Count of distinct sources: " + allSrcs.size() + "\n");
        buf.append("Total distinct source sets: " + allSrcSets.size() + "\n");
                
        return buf.toString();
        
    }   
    
    /** Count taint on prims or strings */
    private static Set<InfoValue> getTaintSet(Value v, MethodOrMethodContext momc) {
        Set<InfoValue> taints = null;
        
        if (v instanceof Local && v.getType() instanceof PrimType) {
            taints = InformationFlowAnalysis.v().getTaints(momc, (Local)v);
        } else if (PTABridge.v().isPointer(v) && SootUtils.isStringOrSimilarType(v.getType())) {
            taints = new HashSet<InfoValue>(); 
            for (IAllocNode node : PTABridge.v().getPTSet(v, momc.context())) {
                taints.addAll(InformationFlowAnalysis.v().getTaints(node, momc));
            }
        }
               
        return taints;
    }

    private static String reachableSinksSources() {
        StringBuffer buf = new StringBuffer();
        Set<Stmt> sinks = new HashSet<Stmt>();
        Set<Stmt> sources = new HashSet<Stmt>();

        for (SootMethod method : CollaspedCallGraph.v().getAllMethods()) {
            for (CallToTarget apiCall : CollaspedCallGraph.v().getAPICallTargets(method)) {
                if (API.v().hasSourceInfoKind(apiCall.getTarget()) &&
                        InfoKind.callsSensitiveSource(apiCall.getStmt())) {
                    sources.add(apiCall.getStmt());
                }

                if (API.v().hasSinkInfoKind(apiCall.getTarget()) &&
                        InfoKind.callsSensitiveSink(apiCall.getStmt())) {
                    sinks.add(apiCall.getStmt());
                }
            }
        }

        buf.append("Total reachable sink call statments: " + sinks.size() + "\n");
        buf.append("Total reachable source call statements: " + sources.size() + "\n");

        return buf.toString();
    }

    private static String getReachableLines() {
        int totalReachableLines = 0;

        for (SootMethod sm : PTABridge.v().getReachableMethods()) {
            totalReachableLines += SootUtils.getNumLines(sm);
        }

        return Integer.toString(totalReachableLines);
    }

    private static String getConfiguration() {
        StringBuffer buf = new StringBuffer();


        buf.append(Config.v().kobjsens + "-");

        if (Config.v().ignoreNoContextFlows)
            buf.append("ignore-no-context-flows ");

        if (Config.v().fullContextForStrings)
            buf.append("full-context-for-strings ");

        if (Config.v().fullContextForGUI)
            buf.append("full-context-for-gui ");

        if (Config.v().staticinitcontext)
            buf.append("static-init-context ");

        if (!Config.v().cloneStaticCalls) {
            buf.append("noclonestatics ");
        }

        if (!Config.v().addFallbackModeling) {
            buf.append("nofallback ");
        }    

        return buf.toString();
    }

}
