package droidsafe.stats;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import soot.Hierarchy;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.jimple.InvokeExpr;
import soot.jimple.OrExpr;
import soot.jimple.Stmt;
import soot.jimple.spark.SparkEvaluator;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.ObjectSensitiveConfig;
import soot.jimple.toolkits.pta.IAllocNode;
import droidsafe.analyses.RCFGToSSL;
import droidsafe.analyses.collapsedcg.CollaspedCallGraph;
import droidsafe.analyses.collapsedcg.CollaspedCallGraph.CallToTarget;
import droidsafe.analyses.infoflow.InfoValue;
import droidsafe.analyses.infoflow.InformationFlowAnalysis;
import droidsafe.analyses.pta.PTABridge;
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

            //write final run of pta
            fw.write(SparkEvaluator.v().toString());

            //write total lines of code 
            fw.write("\nTotal Reachable LOC: " + getReachableLines() + "\n\n");

            //write information flow
            fw.write(infoFlowResults());

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

                        for (Map.Entry<InfoKind, Set<Stmt>> flows : oe.getArgSourceInfoUnits(i).entrySet()) {
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

        if (Config.v().ptaInfoFlowRefinement) {
            buf.append("refinement ");
        }

     
        return buf.toString();
    }

}
