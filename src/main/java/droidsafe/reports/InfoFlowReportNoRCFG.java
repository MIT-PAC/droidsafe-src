package droidsafe.reports;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Local;
import soot.MethodOrMethodContext;
import soot.PrimType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.jimple.Constant;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.pta.IAllocNode;
import droidsafe.analyses.infoflow.InfoUnit;
import droidsafe.analyses.infoflow.InfoValue;
import droidsafe.analyses.infoflow.InformationFlowAnalysis;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.android.system.InfoKind;
import droidsafe.speclang.Method;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;

/**
 * Generate information flow result with RCFG.  Only assume that PTA and information 
 * flow analysis has completed.
 * 
 * @author mgordon
 *
 */
public class InfoFlowReportNoRCFG {
    private static final boolean PRECISE = true;
    private static final Logger logger = LoggerFactory.getLogger(InfoFlowReportNoRCFG.class);
    private static final String FILE_NAME = "stmt-flows.txt";

    public InfoFlowReportNoRCFG() {
        // TODO Auto-generated constructor stub
    }
    
    public void printReachableMethods() {
        try (FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + "reachable-app-methods.txt")){
          for (SootMethod reachable : PTABridge.v().getReachableMethods()) {
              if (!API.v().isSystemMethod(reachable))
                  fw.write(reachable + "\n");
          }                   
        }  catch (Exception e) {

        }
    }

    public void printSensitiveSources() {
        try (FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + "all-sources.txt")){
            for (SootClass clz : Scene.v().getClasses()) {
                try {
                    for (SootMethod method : clz.getMethods()) {
                        if (API.v().isSystemMethod(method))
                            continue;
                        
                        boolean reachable = PTABridge.v().getReachableMethods().contains(method);
                        
                        for (Unit u : method.retrieveActiveBody().getUnits()) {
                            Stmt stmt = (Stmt)u;                            
                            if (stmt.containsInvokeExpr()) {
                                boolean possibleSource = false;
                                for (SootMethod target : SootUtils.getTargetsCHA(stmt.getInvokeExpr())) {
                                    if (API.v().hasSourceInfoKind(target)) {
                                        possibleSource = true;
                                        break;
                                    }
                                }
                                if (possibleSource) {
                                    
                                    fw.write(stmt + " in " + method + (reachable ? "" : "(not reachable)") + "\n") ;
                                }
                            }
                        }
                    }           
                } catch (Exception e) {
                    continue;
                }
            }
        } catch (Exception e) {

        }
    }

    public void run() {
        printSensitiveSources();
        printReachableMethods();
        
        try (FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + FILE_NAME)) {
            //loop through all reachable methods
            Set<InfoValue> recFlows = new HashSet<InfoValue>();
            Set<InfoValue> argFlows = new HashSet<InfoValue>();        

            for (SootMethod method : PTABridge.v().getReachableMethods()) {
                if (API.v().isSystemMethod(method)) 
                    continue;

                //before expensive context-sensitive search, see if there is a sink reachable from this method
                boolean hasSink = false;;
                for (SootMethod target: PTABridge.v().outgoingEdgesIns(method)) {
                    if (API.v().hasSinkInfoKind(target)) {
                        hasSink = true;
                        break;
                    }
                }

                if (!hasSink)
                    continue;

                for (Unit u : SootUtils.getStmtIterator(method)) {
                    Stmt stmt = (Stmt)u;
                    if (!stmt.containsInvokeExpr())
                        continue;

                    recFlows.clear();
                    argFlows.clear();

                    InvokeExpr ie = stmt.getInvokeExpr();
                    Set<InfoValue> methodFlows = null;
                    //has a sink, so loop through all context's and all statements
                    for (MethodOrMethodContext momc : PTABridge.v().getMethodContexts(method)) {
                        //check if a call can target a sink in this context
                        for (Edge edge : PTABridge.v().outgoingEdges(momc, stmt)) {
                            if (API.v().hasSinkInfoKind(edge.tgt())) {
                                //find all sources for receiver of sink
                                if (ie instanceof InstanceInvokeExpr) {
                                    //loop over all alloc nodes of receiver, must be a reference to have a receiver!
                                    for (IAllocNode node : PTABridge.v().getPTSet(((InstanceInvokeExpr)ie).getBase(), momc.context())) {
                                        //for each information flow result
                                        recFlows.addAll(InformationFlowAnalysis.v().getTaints(node, edge.getTgt()));
                                    }
                                }

                                //find sources for arg of sink
                                argFlows(edge, argFlows);

                                //find sources for code of sink?
                                methodFlows = InformationFlowAnalysis.v().getTaints(edge.getTgt());
                            }
                        }
                    }
                    for (InfoValue iv : recFlows) {
                        writeFlow(stmt, iv, "REC", fw);
                    }
                    for (InfoValue iv : argFlows) {
                        writeFlow(stmt, iv, "ARG", fw);
                    }
                    if (methodFlows != null) {
                        for (InfoValue iv : methodFlows) {
                            writeFlow(stmt, iv, "CODE", fw);
                        }
                    }

                }
            }
        } catch (IOException e) {

        }
    }

    private void writeFlow(Stmt stmt, InfoValue iv, String type, FileWriter fw) throws IOException {
        SourceLocationTag sl = SootUtils.getSourceLocation(stmt);
        fw.write(iv + " => " + stmt + "(" + type + ")");
        if (sl != null)
            fw.write(" at " + sl);
        fw.write("\n");               
    }

    private void argFlows(Edge edge, Set<InfoValue> argFlows) {
        for (int i = 0; i < edge.tgt().getParameterCount(); i++) {
            if (!edge.srcStmt().containsInvokeExpr())
                continue;

            Value argValue = edge.srcStmt().getInvokeExpr().getArg(i);

            if ( PTABridge.v().isPointer(argValue)) {
                for (IAllocNode node : PTABridge.v().getPTSet(argValue, edge.srcCtxt())) {
                    if (PRECISE)
                        argFlows.addAll(InformationFlowAnalysis.v().getTaints(node, edge.getTgt()));
                    else
                        argFlows.addAll(InformationFlowAnalysis.v().getTaints(node));
                }
            } else if (argValue instanceof Local && 
                    argValue.getType() instanceof PrimType){     
                argFlows.addAll( 
                    InformationFlowAnalysis.v().getTaints(edge.getSrc(), (Local)argValue));               
            } else if (argValue instanceof Constant) {
                //do nothing for constants
            } else {
                logger.error("Unknown value or type for argument when retreiveing infovalue: {} {} {}", 
                    edge.getTgt(), argValue, argValue.getType());
            }
        }
    }
}
