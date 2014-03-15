package checks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import soot.Body;
import soot.G;
import soot.Immediate;
import soot.Local;
import soot.MethodOrMethodContext;
import soot.PatchingChain;
import soot.PrimType;
import soot.RefLikeType;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.VoidType;
import soot.jimple.AssignStmt;
import soot.jimple.Constant;
import soot.jimple.InvokeExpr;
import soot.jimple.ReturnStmt;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.callgraph.Targets;
import soot.jimple.toolkits.pta.IAllocNode;
import droidsafe.analyses.infoflow.InfoValue;
import droidsafe.analyses.infoflow.InformationFlowAnalysis;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.main.Config;

public class CloggedNativeMethods {
    private static CloggedNativeMethods v;

    public static void run() throws IOException {
        v = new CloggedNativeMethods();
    }

    static CloggedNativeMethods v() {
        return v;
    }

    private CloggedNativeMethods() throws IOException {
        doAnalysis();
    }

    static void printCloggingNativeMethods(AssignStmt stmt, MethodOrMethodContext methodContext) {
        Value rValue = stmt.getRightOp();
        if (rValue instanceof InvokeExpr) {
            printCloggingNativeMethods(stmt, (InvokeExpr)rValue, methodContext);
        }
    }

    static void printCloggingNativeMethods(AssignStmt stmt, InvokeExpr invokeExpr, MethodOrMethodContext methodContext) {
        boolean isNative = false;
        List<Edge> callEdges = PTABridge.v().outgoingEdges(methodContext, stmt);
        Iterator<MethodOrMethodContext> tgtMethodContexts = new Targets(callEdges.iterator());
        while (tgtMethodContexts.hasNext()) {
            MethodOrMethodContext tgtMethodContext = tgtMethodContexts.next();
            SootMethod method = tgtMethodContext.method();
            if (method.isNative()) {
                isNative = true;
                break;
            }
        }
        if (isNative) {
        }
    }

    private void doAnalysis() throws IOException {
        Set<String> nativeMethods = new HashSet<String>();
        String pathname = Config.v().getApacHome() + File.separator + "config-files" + File.separator + "native.txt";
        BufferedReader reader = new BufferedReader(new FileReader(pathname));
        String line;
        while ((line = reader.readLine()) != null) {
            nativeMethods.add(line);
        }
        reader.close();

        Set<SootMethod> methods = PTABridge.v().getReachableMethods();
    for_method:
        for (SootMethod method : methods) {
            if (!(nativeMethods.contains(method.toString()))) {
                continue;
            }
            Type returnType = method.getReturnType();
            if (returnType instanceof VoidType) {
                continue;
            }
            int parameterCount = method.getParameterCount();
            if (parameterCount == 0) {
                continue;
            }
            if (!(method.hasActiveBody())) {
                continue;
            }
            Body body = method.getActiveBody();
            Local[] parameterLocals = new Local[parameterCount];
            for (int i = 0; i < parameterCount; i++) {
                parameterLocals[i] = body.getParameterLocal(i);
            }
            Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
            for (MethodOrMethodContext methodContext : methodContexts) {
                HashSet<InfoValue> argumentValues = new HashSet<InfoValue>();
                for (Local parameterLocal : parameterLocals) {
                    Type parameterType = parameterLocal.getType();
                    if (parameterType instanceof PrimType) {
                        Set<InfoValue> values = InformationFlowAnalysis.v().getTaints(methodContext, parameterLocal); 
                        argumentValues.addAll(values);
                    } else {
                        assert parameterType instanceof RefLikeType;
                        Set<IAllocNode> allocNodes = (Set<IAllocNode>)PTABridge.v().getPTSet(parameterLocal, methodContext.context());
                        for (IAllocNode allocNode : allocNodes) {
                            Set<InfoValue> values = InformationFlowAnalysis.v().getTaints(allocNode, methodContext); 
                            argumentValues.addAll(values);
                        }
                    }
                }
                if (argumentValues.isEmpty()) {
                    continue;
                }
                PatchingChain<Unit> units = body.getUnits();
                for (Unit unit : units) {
                    if (unit instanceof ReturnStmt) {
                        ReturnStmt returnStmt = (ReturnStmt)unit;
                        Immediate opImmediate = (Immediate)returnStmt.getOp();
                        if (opImmediate instanceof Local) {
                            Local opLocal = (Local)opImmediate;
                            Type opType = opLocal.getType();
                            Set<InfoValue> returnValues;
                            if (opType instanceof PrimType) {
                                returnValues = InformationFlowAnalysis.v().getTaints(methodContext, opLocal);
                            } else {
                                assert opType instanceof RefLikeType;
                                returnValues = new HashSet<InfoValue>();
                                Set<IAllocNode> allocNodes = (Set<IAllocNode>)PTABridge.v().getPTSet(opLocal, methodContext.context());
                                for (IAllocNode allocNode : allocNodes) {
                                    Set<InfoValue> values = InformationFlowAnalysis.v().getTaints(allocNode, methodContext); 
                                    returnValues.addAll(values);
                                }
                            }
                            if (!(returnValues.containsAll(argumentValues))) {
                                G.v().out.println(method);
                                continue for_method;
                            }
                        } else {
                            assert opImmediate instanceof Constant;
                            G.v().out.println(method);
                            continue for_method;
                        }
                    }
                }
            }
        }
    }
}
