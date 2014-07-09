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

import soot.SootMethod;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.spark.SparkEvaluator;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.ObjectSensitiveConfig;
import soot.jimple.toolkits.pta.IAllocNode;
import droidsafe.analyses.RCFGToSSL;
import droidsafe.analyses.infoflow.InfoValue;
import droidsafe.analyses.infoflow.InformationFlowAnalysis;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Project;
import droidsafe.android.system.InfoKind;
import droidsafe.main.Config;
import droidsafe.speclang.Method;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;

public class PTAPaper {

    public static StringBuffer refinementStats = new StringBuffer(); 
    public static double infoFlowTimeSec;
    
    
    public static void writeReport() {
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
        StringBuffer buf = new StringBuffer();

        //count number of flows
        //have to map it down to invoke statement because of context

        //key is invoke of sink -> sources
        Map<InvokeExpr, Set<Stmt>> invokeToSources = new HashMap<InvokeExpr, Set<Stmt>>();

        for (Map.Entry<Method, List<Method>> block : RCFGToSSL.v().getSpec().getEventBlocks().entrySet()) {
            for (Method oe : block.getValue()) {
                if (oe.getSinkInfoKinds().size() > 0 &&
                        oe.getSourcesInfoKinds().size() > 0) {
                    //we have a sink with connected sources
                    InvokeExpr ie = oe.getInvokeExpr();
                    if (!invokeToSources.containsKey(ie)) {
                        invokeToSources.put(ie, new HashSet<Stmt>());
                    }

                    //get args
                    for (int i = 0; i < oe.getNumArgs(); i++) {
                        for (Map.Entry<InfoKind, Set<Stmt>> flows : oe.getArgSourceInfoUnits(i).entrySet()) {
                            invokeToSources.get(ie).addAll(flows.getValue());
                        }
                    }
                    //get receiver
                    for (Map.Entry<InfoKind, Set<Stmt>> flows : oe.getReceiverSourceInfoUnits().entrySet()) {
                        invokeToSources.get(ie).addAll(flows.getValue());
                    }
                    //get method accesses
                    for (Map.Entry<InfoKind, Set<Stmt>> flows : oe.getMethodInfoUnits().entrySet()) {
                        invokeToSources.get(ie).addAll(flows.getValue());
                    }
                }
            }
        }

        //count number of flows
        int flowsIntoSinks = 0;

        try {
            //FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + "flows-for-pta-paper.log");
            for (Map.Entry<InvokeExpr, Set<Stmt>> sink : invokeToSources.entrySet()) {
                flowsIntoSinks += sink.getValue().size();
                /*
                fw.write(sink.getKey() + " in " + JimpleRelationships.v().getEnclosingMethod(sink.getKey()) + "\n");
                for (Stmt source : sink.getValue()) {
                    fw.write("\t" + source + " in " + JimpleRelationships.v().getEnclosingMethod(source) + "\n");
                }
                fw.write("\n");
                */
            }
            //fw.close();
        } catch (Exception e) {
            
        }


        buf.append("Info Flow Time Sec: " + infoFlowTimeSec + "\n");

        buf.append("Flows into sinks: " + flowsIntoSinks + "\n");

        //total infoflow sets for args?

        //total infoflow set size for args?

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
        
        if (Config.v().ptaInfoFlowRefinement) {
            buf.append("refinement ");
        }

        return buf.toString();
    }

}
