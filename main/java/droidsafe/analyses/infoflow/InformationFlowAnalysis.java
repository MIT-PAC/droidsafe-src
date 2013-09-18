package droidsafe.analyses.infoflow;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.text.translate.CharSequenceTranslator;
import org.apache.commons.lang3.text.translate.LookupTranslator;
import org.jgrapht.Graph;
import org.jgrapht.ext.DOTExporter;
import org.jgrapht.ext.EdgeNameProvider;
import org.jgrapht.ext.IntegerNameProvider;
import org.jgrapht.ext.VertexNameProvider;
import org.jgrapht.graph.DefaultEdge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import soot.Body;
import soot.Immediate;
import soot.Kind;
import soot.Local;
import soot.MethodOrMethodContext;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.jimple.AbstractStmtSwitch;
import soot.jimple.ArrayRef;
import soot.jimple.AssignStmt;
import soot.jimple.BinopExpr;
import soot.jimple.CastExpr;
import soot.jimple.CaughtExceptionRef;
import soot.jimple.Constant;
import soot.jimple.DynamicInvokeExpr;
import soot.jimple.IdentityRef;
import soot.jimple.IdentityStmt;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceOfExpr;
import soot.jimple.InterfaceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.NewArrayExpr;
import soot.jimple.NewExpr;
import soot.jimple.NewMultiArrayExpr;
import soot.jimple.ParameterRef;
import soot.jimple.ReturnStmt;
import soot.jimple.ReturnVoidStmt;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.StaticFieldRef;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.ThisRef;
import soot.jimple.UnopExpr;
import soot.jimple.VirtualInvokeExpr;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.callgraph.Targets;
import soot.jimple.toolkits.callgraph.TransitiveTargets;
import soot.toolkits.graph.Block;
import soot.toolkits.graph.PseudoTopologicalOrderer;

import droidsafe.analyses.EntryPointCGEdges;
import droidsafe.analyses.GeoPTA;

/**
 * Information Flow Analysis
 */

public class InformationFlowAnalysis {
    /**
     * Returns the singleton InformationFlowAnalysis object.
     * @return the singleton InformationFlowAnalysis object
     */
    public static InformationFlowAnalysis v() {
        return v;
    }

    /**
     * Creates a singleton InformationFlowAnalysis object.
     */
    public static void run() {
        ObjectUtil.run();
        logger.info("Starting Memory Access Analysis...");
        MemoryAccessAnalysis.run();
        logger.info("Finished Memory Access Analysis...");
        v = new InformationFlowAnalysis(InterproceduralControlFlowGraph.v());
    }

    private States getFlowFromTo(Block from, Block to) {
        return fromToStates.get(from).get(to);
    }

    public States getFlowBefore(Unit unit) {
        Block block = controlFlowGraph.unitToBlock.get(unit);
        States inStates = getFlowBefore(block);
        Unit pred = block.getHead();
        while (!pred.equals(unit)) {
            inStates = execute(pred, inStates);
            pred = block.getSuccOf(pred);
        }
        return inStates;
    }

    private States getFlowBefore(Block block) {
        States inStates;
        List<Block> preds = controlFlowGraph.getPredsOf(block);
        int nPreds = preds.size();
        if (nPreds == 1) {
            inStates = fromToStates.get(preds.get(0)).get(block);
        } else if (nPreds > 1) {
            inStates = mergeStates.get(block);
        } else {        // nPreds == 0
            assert(nPreds == 0);
            inStates = fromToStates.get(null).get(block);
        }
        return inStates;
    }

    public static void exportDotGraph(String fileName) throws IOException {
        exportDotGraph(InterproceduralControlFlowGraph.v().toJGraphT(), fileName);
    }

    public static void exportDotGraph(SootMethod method, String fileName) throws IOException {
        exportDotGraph(InterproceduralControlFlowGraph.v().toJGraphT(method), fileName);
    }

    private static InformationFlowAnalysis v;

    private final InterproceduralControlFlowGraph controlFlowGraph;
    private final CallGraph callGraph;

    private final Map<Block, Map<Block, States>> fromToStates;
    private final Map<Block, States> mergeStates;
    private final DefaultHashMap<Context, ImmutableList<Address>> rootsFromFrames;

    class Worklist {
        TreeSet<Block> worklist;

        Worklist() {
            final Map<Block, Integer> blockToRank = new HashMap<Block, Integer>();
            int i = 1;
            Iterator<Block> it = new PseudoTopologicalOrderer<Block>().newList(controlFlowGraph, false).iterator();
            while (it.hasNext()) {
                blockToRank.put(it.next(), i);
                i++;
            }
            worklist = new TreeSet<Block>(new Comparator<Block>() {
                @Override
                public int compare(Block block1, Block block2) {
                    return blockToRank.get(block1) - blockToRank.get(block2);
                }
            });
        }

        boolean add(Block block) {
            return worklist.add(block);
        }

        boolean isEmpty() {
            return worklist.isEmpty();
        }

        Block poll() {
            return worklist.pollFirst();
        }
    }

    private Worklist worklist;

    private final static Logger logger = LoggerFactory.getLogger(InformationFlowAnalysis.class);

    private InformationFlowAnalysis(InterproceduralControlFlowGraph controlFlowGraph) {
        this.controlFlowGraph = controlFlowGraph;
        callGraph = Scene.v().getCallGraph();

        fromToStates = new HashMap<Block, Map<Block, States>>();
        mergeStates = new HashMap<Block, States>();
        rootsFromFrames = new DefaultHashMap<Context, ImmutableList<Address>>(ImmutableList.<Address>of());
        fromToStates.put(null, new HashMap<Block, States>());
        for (Block curr : controlFlowGraph) {
            List<Block> preds = controlFlowGraph.getPredsOf(curr);
            if (preds.size() > 1) {
                mergeStates.put(curr, new States());
            } else if (preds.size() == 0) {
                fromToStates.get(null).put(curr, new States());
            }
            fromToStates.put(curr, new HashMap<Block, States>());
            List<Block> succs = controlFlowGraph.getSuccsOf(curr);
            if (succs.size() > 0) {
                for (Block succ : succs) {
                    fromToStates.get(curr).put(succ, new States());
                }
            } else {
                fromToStates.get(curr).put(null, new States());
            }
        }

        doAnalysis();
    }

    private void doAnalysis() {
        initialize();
        while (!worklist.isEmpty()) {
            Block curr = worklist.poll();
            States inStates = collectFlowBefore(curr);
            if (inStates != null) {
                States outStates = execute(curr, inStates);
                // fromToStates and worklist have been already updated if outStates == null.
                if (outStates != null) {
                    for (Block succ : controlFlowGraph.getSuccsOf(curr)) {
                        // XXX: skip "$r0 := @caughtexception"
                        if (!InterproceduralControlFlowGraph.containsCaughtExceptionRef(succ.getHead())) {
                            if (!outStates.equals(fromToStates.get(curr).get(succ))) {
                                fromToStates.get(curr).put(succ, outStates);
                                worklist.add(succ);
                            }
                        }
                    }
                }
            }
        }
    }

    private void initialize() {
        SootMethod method = Scene.v().getMethod("<DroidSafeMain: void main(java.lang.String[])>");
        Local local = method.getActiveBody().getParameterLocal(0);
        Set<MyValue> values = new HashSet<MyValue>();
        for (AllocNode allocNode : GeoPTA.v().getPTSetContextIns(local)) {
            values.add(Address.v(allocNode));
        }
        FrameHeapStatics frameHeapStatics = new FrameHeapStatics();
        frameHeapStatics.frame.putS(MethodMyParameterRef.v(method, new ParameterRef(local.getType(), 0)), ImmutableList.<MyValue>copyOf(values));
        States states = new States();
        states.put(Context.v(new Edge(null, null, method, Kind.INVALID), new Edge(null, null, method, Kind.INVALID)), frameHeapStatics);
        Block block = controlFlowGraph.methodToHeads.get(method).get(0);
        assert controlFlowGraph.getHeads().contains(block);
        fromToStates.get(null).put(block, states);
        worklist = new Worklist();
        worklist.add(block);
    }

    private States collectFlowBefore(Block curr) {
        States states;
        List<Block> preds = controlFlowGraph.getPredsOf(curr);
        if (preds.size() == 1) {
            states = fromToStates.get(preds.get(0)).get(curr);
        } else if (preds.size() > 1) {
            Iterator<Block> it = preds.iterator();
            states = fromToStates.get(it.next()).get(curr);
            while (it.hasNext()) {
                states = states.merge(fromToStates.get(it.next()).get(curr));
            }
            if (!states.equals(mergeStates.get(curr))) {
                mergeStates.put(curr, states);
            } else {
                return null;
            }
        } else {    // preds.size() == 0
            assert preds.size() == 0;
            states = fromToStates.get(null).get(curr);
        }
        return states;
    }

    private States execute(Block block, States inStates) {
        States outStates = inStates;
        Iterator<Unit> it = block.iterator();
        while (it.hasNext()) {
            outStates = execute(it.next(), outStates);
        }
        return outStates;
    }

    private States execute(final Unit curr, final States inStates) {
        AbstractStmtSwitch stmtSwitch = new AbstractStmtSwitch() {
            @Override
            public void caseAssignStmt(final AssignStmt stmt) {
                setResult(execute(stmt, inStates));
            }

            @Override
            public void caseIdentityStmt(IdentityStmt stmt) {
                setResult(execute(stmt, inStates));
            }

            @Override
            public void caseInvokeStmt(InvokeStmt stmt) {
                // invoke_stmt = invoke_expr;
                execute(stmt, stmt.getInvokeExpr(), inStates);
            }

            @Override
            public void caseReturnStmt(ReturnStmt stmt) {
                execute(stmt, inStates);
            }

            @Override
            public void caseReturnVoidStmt(ReturnVoidStmt stmt) {
                execute(stmt, inStates);
            }

            @Override
            public void defaultCase(Object stmt) {
                setResult(inStates);
            }
        };
        curr.apply(stmtSwitch);
        return (States)stmtSwitch.getResult();
    }

    // stmt = ... | assign_stmt | ...;
    private States execute(final AssignStmt stmt, final States inStates) {
        // assign_stmt = variable "=" rvalue;
        final Value variable = stmt.getLeftOp();
        Value rValue = stmt.getRightOp();
        // rvalue = array_ref | constant | expr | instance_field_ref | local | next_next_stmt_address | static_field_ref;
        MyAbstractRValueSwitch rValueSwitch = new MyAbstractRValueSwitch() {
            // rvalue = array_ref | ...;
            @Override
            public void caseArrayRef(ArrayRef arrayRef) {
                // variable "=" array_ref
                setResult(execute(stmt, variable, arrayRef, inStates));
            }

            // rvalue = ... | constant | ...
            // constant = double_constant | float_constant | int_constant | long_constant | string_constant | null_constant | class_constant;
            @Override
            public void caseConstant(Constant constant) {
                // varaible "=" constant
                setResult(inStates);
            }

            // rvalue = ... | expr | ...;
            // expr = binop_expr | ...;
            // binop_expr = add_expr | and_expr | cmp_expr | cmpg_expr | cmpl_expr | div_expr | eq_expr | ge_expr | gt_expr | le_expr | lt_expr | mul_expr | ne_expr | or_expr | rem_expr | shl_expr | shr_expr | sub_expr | ushr_expr | xor_expr;
            @Override
            public void caseBinopExpr(BinopExpr binopExpr) {
                // variable "=" binop_expr
                setResult(execute(stmt, variable, binopExpr, inStates));
            }

            // rvalue = ... | expr | ...;
            // expr = ... | cast_expr | ...;
            @Override
            public void caseCastExpr(CastExpr castExpr) {
                // variable "=" cast_expr
                setResult(execute(stmt, variable, castExpr, inStates));
            }

            // rvalue = ... | expr | ...;
            // expr = ... | instance_of_expr | ...;
            @Override
            public void caseInstanceOfExpr(InstanceOfExpr instanceOfExpr) {
                // variable "=" instance_of_expr
                setResult(execute(stmt, variable, instanceOfExpr, inStates));
            }

            // rvalue = ... | expr | ...;
            // expr = ... | invoke_expr | ...;
            // invoke_expr = interface_invoke_expr | special_invoke_expr | static_invoke_expr | virtual_invoke_expr;
            @Override
            public void caseInvokeExpr(InvokeExpr invokeExpr) {
                // variable "=" invoke_expr
                execute(stmt, variable, invokeExpr, inStates);
            }

            // rvalue = ... | expr | ...;
            // expr = ... | new_array_expr | ...;
            @Override
            public void caseNewArrayExpr(NewArrayExpr newArrayExpr) {
                // variable "=" new_array_expr
                setResult(execute(stmt, variable, newArrayExpr, inStates));
            }

            // rvalue = ... | expr | ...;
            // expr = ... | new_expr | ...;
            @Override
            public void caseNewExpr(NewExpr newExpr) {
                // variable "=" new_expr
                setResult(execute(stmt, variable, newExpr, inStates));
            }

            // rvalue = ... | expr | ...;
            // expr = ... | new_multi_array_expr | ...;
            @Override
            public void caseNewMultiArrayExpr(NewMultiArrayExpr newMultiArrayExpr) {
                setResult(execute(stmt, variable, newMultiArrayExpr, inStates));
            }

            // rvalue = ... | expr | ...;
            // expr = ... | unop_expr;
            // unop_expr = length_expr | neg_expr;
            @Override
            public void caseUnopExpr(UnopExpr unopExpr) {
                setResult(execute(stmt, variable, unopExpr, inStates));
            }

            // rvalue = ... | instance_field_ref | ...;
            @Override
            public void caseInstanceFieldRef(InstanceFieldRef instanceFieldRef) {
                // variable "=" instance_field_ref
                setResult(execute(stmt, variable, instanceFieldRef, inStates));
            }

            // rvalue = ... | local | ...;
            @Override
            public void caseLocal(Local local) {
                // variable "=" local
                setResult(execute(stmt, variable, local, inStates));
            }

            // rvalue = ... | static_field_ref;
            @Override
            public void caseStaticFieldRef (StaticFieldRef staticFieldRef) {
                // variable "=" static_field_ref
                setResult(execute(stmt, variable, staticFieldRef, inStates));
            }
        };
        rValue.apply(rValueSwitch);
        return (States)rValueSwitch.getResult();
    }

    // assign_stmt = variable "=" array_ref
    private States execute(final AssignStmt stmt, Value variable, ArrayRef arrayRef, final States inStates) {
        final SootMethod method = controlFlowGraph.unitToBlock.get(stmt).getBody().getMethod();
        final States outStates = new States();
        // array_ref = immediate "[" immediate "]";
        Immediate immediate = (Immediate)arrayRef.getBase();
        for (final Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatics : inStates.entrySet()) {
            final FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatics.getValue();
            ImmutableList<MyValue> addresses = evaluate(method, immediate, inFrameHeapStatics.frame);
            final Set<MyValue> values = new HashSet<MyValue>();
            for (MyValue address : addresses) {
                if (address instanceof Address) {
                    values.addAll(inFrameHeapStatics.heap.arrays.get((Address)address));
                }
            }
            // variable = array_ref | instance_field_ref | static_field_ref | local;
            variable.apply(new MyAbstractVariableSwitch() {
                // variable = array_ref | ...;
                @Override
                public void caseArrayRef(ArrayRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | instance_field_ref | ...;
                @Override
                public void caseInstanceFieldRef(InstanceFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | static_field_ref | ...;
                @Override
                public void caseStaticFieldRef(StaticFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | local;
                @Override
                public void caseLocal(Local local) {
                    Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.thiz, inFrameHeapStatics.frame.params);
                    frame.putS(MethodLocal.v(method, local), values);
                    outStates.put(contextFrameHeapStatics.getKey(), new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
                }
            });
        }
        return outStates;
    }

    // assign_stmt = variable "=" binop_expr
    private States execute(final AssignStmt stmt, Value variable, BinopExpr binopExpr, States inStates) {
        final SootMethod method = controlFlowGraph.unitToBlock.get(stmt).getBody().getMethod();
        final States outStates = new States();
        // binop_expr = add_expr | and_expr | cmp_expr | cmpg_expr | cmpl_expr | div_expr | eq_expr | ge_expr | gt_expr | le_expr | lt_expr | mul_expr | ne_expr | or_expr | rem_expr | shl_expr | shr_expr | sub_expr | ushr_expr | xor_expr;
        // add_expr = immediate "+" immediate;
        // and_expr = immediate "&" immediate;
        // cmp_expr = immediate "cmp" immediate;
        // cmpg_expr = immediate "cmpg" immediate;
        // cmpl_expr = immediate "cmpl" immediate;
        // div_expr = immediate "/" immediate;
        // eq_expr = immediate "==" immediate;
        // ge_expr = immediate ">=" immediate;
        // gt_expr = immediate ">" immediate;
        // le_expr = immediate "<=" immediate;
        // lt_expr = immediate "<" immediate;
        // mul_expr = immediate "*" immediate;
        // ne_expr = immediate "!=" immediate;
        // or_expr = immediate "|" immediate;
        // rem_expr = immediate "%" immediate;
        // shl_expr = immediate "<<" immediate;
        // shr_expr = immediate ">>" immediate;
        // sub_expr = immediate "-" immediate;
        // ushr_expr = immediate "ushr" immediate;
        // xor_expr = immediate "xor" immediate;
        ArrayList<Value> immediates = new ArrayList<Value>(2);
        immediates.add(binopExpr.getOp1());
        immediates.add(binopExpr.getOp2());
        for (final Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
            final FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
            final Set<MyValue> values = new HashSet<MyValue>();
            for (ImmutableList<MyValue> vs : evaluate(method, immediates, inFrameHeapStatics.frame)) {
                values.addAll(vs);
            }
            // variable = array_ref | instance_field_ref | static_field_ref | local;
            variable.apply(new MyAbstractVariableSwitch() {
                // variable = array_ref | ...;
                @Override
                public void caseArrayRef(ArrayRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | instance_field_ref | ...;
                @Override
                public void caseInstanceFieldRef(InstanceFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | static_field_ref | ...;
                @Override
                public void caseStaticFieldRef(StaticFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | local;
                @Override
                public void caseLocal(Local local) {
                    Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.thiz, inFrameHeapStatics.frame.params);
                    frame.putS(MethodLocal.v(method, local), values);
                    outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
                }
            });
        }
        return outStates;
    }

    // assign_stmt = variable "=" cast_expr
    private States execute(final AssignStmt stmt, final Value variable, CastExpr castExpr, final States inStates) {
        // cast_expr = "(" type ")" immediate;
        Value immediate = castExpr.getOp();
        // immediate = constant | local;
        MyAbstractImmediateSwitch immediateSwitch = new MyAbstractImmediateSwitch() {
            // immediate = constant | ...;
            // constant = double_constant | float_constant | int_constant | long_constant | string_constant | null_constant | class_constant;
            @Override
            public void caseConstant(Constant constant) {
                // local "=" "(" type ")" constant
                // TODO: we may be able to do better by considering "type".
                setResult(inStates);
            }

            // immediate = ... | local;
            @Override
            public void caseLocal(final Local local) {
                // local "=" "(" type ")" local
                setResult(execute(stmt, variable, local, inStates));
            }
        };
        immediate.apply(immediateSwitch);
        return (States)immediateSwitch.getResult();
    }

    // assigin_stmt = variable "=" instance_of_expr
    private States execute(final AssignStmt stmt, final Value variable, InstanceOfExpr instanceOfExpr, final States inStates) {
        final SootMethod method = controlFlowGraph.unitToBlock.get(stmt).getBody().getMethod();
        final States outStates = new States();
        // instance_of_expr = immediate "instanceof" ref_type;
        Immediate immediate = (Immediate)instanceOfExpr.getOp();
        for (final Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
            final FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
            final ImmutableList<MyValue> values = evaluate(method, immediate, inFrameHeapStatics.frame);
            // variable = array_ref | instance_field_ref | static_field_ref | local;
            variable.apply(new MyAbstractVariableSwitch() {
                // variable = array_ref | ...;
                @Override
                public void caseArrayRef(ArrayRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | instance_field_ref | ...;
                @Override
                public void caseInstanceFieldRef(InstanceFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | static_field_ref | ...;
                @Override
                public void caseStaticFieldRef(StaticFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | local;
                @Override
                public void caseLocal(Local local) {
                    Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.thiz, inFrameHeapStatics.frame.params);
                    frame.putS(MethodLocal.v(method, local), values);
                    outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
                }
            });
        }
        return outStates;
    }

    // assign_stmt = variable "=" invoke_expr
    // variable = array_ref | instance_field_ref | static_field_ref | local;
    private void execute(final AssignStmt stmt, Value variable, final InvokeExpr invokeExpr, final States inStates) {
        // invoke_expr = interface_invoke_expr | special _invoke_expr | static_invoke_expr | virtual_invoke_expr;
        // interface_invoke_expr = "interfaceinvoke" immediate ".[" + method_signature "]" "(" immediate_list ")"
        // special_invoke_expr = "specialinvoke" immediate ".[" method_signature "]" "(" immediate_list ")";
        // static_invoke_expr = "staticinvoke" "[" method_signature "]" "(" immediate_list ")";
        // virtual_invoke_expr = "virtualinvoke" immediate ".[" method_signamter "]" "(" immediate_list ")";

        // variable = array_ref | instance_field_ref | static_field_ref | local;
        variable.apply(new MyAbstractVariableSwitch() {
            // variable = array_ref | ...;
            @Override
            public void caseArrayRef(ArrayRef v) {
                execute(stmt, invokeExpr, inStates);
            }

            // variable = ... | instance_field_ref | ...;
            @Override
            public void caseInstanceFieldRef(InstanceFieldRef v) {
                execute(stmt, invokeExpr, inStates);
            }

            // variable = ... | static_field_ref | ...;
            @Override
            public void caseStaticFieldRef(StaticFieldRef staticFieldRef) {
                execute(stmt, invokeExpr, inStates);
            }

            // variable = ... | local;
            @Override
            public void caseLocal(Local local) {
                // local "=" invoke_expr
                Block curr = controlFlowGraph.unitToBlock.get(stmt);
                List<Block> succs = controlFlowGraph.getSuccsOf(curr);
                assert succs.size() > 0;

                if (succs.size() == 1) {
                    Block succ = succs.get(0);
                    assert curr.getBody().getMethod().equals(succ.getBody().getMethod());
                    assert !InterproceduralControlFlowGraph.containsCaughtExceptionRef(succ.getHead());
                    States outStates = inStates;
                    if (!outStates.equals(fromToStates.get(curr).get(succ))) {
                        fromToStates.get(curr).put(succ, outStates);
                        worklist.add(succ);
                    }
                    return;
                }

                boolean isGetTaint = false;
                for (Block succ : succs) {
                    if (ObjectUtil.v().isGetTaint(succ.getBody().getMethod())) {
                        isGetTaint = true;
                        break;
                    }
                }
                if (isGetTaint) {
                    assert succs.size() == 2;
                    States outStates = new States();
                    SootMethod caller = curr.getBody().getMethod();
                    for (Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatics : inStates.entrySet()) {
                        Context context = contextFrameHeapStatics.getKey();
                        FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatics.getValue();
                        ImmutableList<MyValue> receivers = receiver(caller, stmt, invokeExpr, inFrameHeapStatics.frame);
                        Set<MyValue> values = new HashSet<MyValue>();
                        for (MyValue receiver : receivers) {
                            values.addAll(inFrameHeapStatics.heap.instances.get((Address)receiver, ObjectUtil.v().taint));
                        }
                        Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.thiz, inFrameHeapStatics.frame.params);
                        frame.putS(MethodLocal.v(caller, local), values);
                        outStates.put(context, new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
                    }
                    Block fallThrough = controlFlowGraph.getFallThrough(curr);
                    if (!outStates.equals(fromToStates.get(curr).get(fallThrough))) {
                        fromToStates.get(curr).put(fallThrough, outStates);
                        worklist.add(fallThrough);
                    }
                    return;
                }

                final SootMethod caller = curr.getBody().getMethod();

                Map<Edge, FrameHeapStatics> frameHeapStaticsForCallEdge = null;
                Map<Edge, Set<Address>> rootsFromFramesForCallEdge = null;
                Map<Edge, ImmutableList<MyValue>> thisForCallEdge = null;
                Map<Edge, List<ImmutableList<MyValue>>> argsForCallEdge = null;
                Map<Edge, Set<Address>> rootsFromThisArgsStaticsForCallEdge = null;

                FrameHeapStatics frameHeapStaticsForEntryEdge = null;
                Set<Address> rootsFromFramesForEntryEdge = null;
                ImmutableList<MyValue> thisForEntryEdge = null;
                List<ImmutableList<MyValue>> argsForEntryEdge = null;
                Set<Address> rootsFromThisArgsStaticsForEntryEdge = null;

                for (Block succ : succs) {
                    // XXX: skip "$r0 := @caughtexception"
                    if (InterproceduralControlFlowGraph.containsCaughtExceptionRef(succ.getHead())) {
                        continue;
                    }
                    States outStates = new States();
                    SootMethod callee = succ.getBody().getMethod();
                    if (!caller.equals(callee)) {
                        Edge callEdge = callGraph.findEdge(stmt, callee);
                        assert callEdge != null;
                        if (!EntryPointCGEdges.v().isEntryPoint(callEdge)) {
                            if (frameHeapStaticsForCallEdge == null) {
                                assert rootsFromFramesForCallEdge == null && thisForCallEdge == null && argsForCallEdge == null && rootsFromThisArgsStaticsForCallEdge == null;
                                frameHeapStaticsForCallEdge = new DefaultHashMap<Edge, FrameHeapStatics>(FrameHeapStatics.EMPTY);
                                rootsFromFramesForCallEdge = new DefaultHashMap<Edge, Set<Address>>(Collections.<Address>emptySet());
                                for (Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatics : inStates.entrySet()) {
                                    Context context = contextFrameHeapStatics.getKey();
                                    frameHeapStaticsForCallEdge.put(context.entryEdge, frameHeapStaticsForCallEdge.get(context.entryEdge).merge(contextFrameHeapStatics.getValue()));
                                    Set<Address> rootsFromFrames = new HashSet<Address>(rootsFromFramesForCallEdge.get(context.entryEdge));
                                    rootsFromFrames.addAll(InformationFlowAnalysis.this.rootsFromFrames.get(context));
                                    rootsFromFramesForCallEdge.put(context.entryEdge, rootsFromFrames);
                                }
                                thisForCallEdge = new HashMap<Edge, ImmutableList<MyValue>>();
                                argsForCallEdge = new HashMap<Edge, List<ImmutableList<MyValue>>>();
                                rootsFromThisArgsStaticsForCallEdge = new HashMap<Edge, Set<Address>>();
                                for (Map.Entry<Edge, FrameHeapStatics> entryEdgeFrameHeapStatics : frameHeapStaticsForCallEdge.entrySet()) {
                                    Edge entryEdge = entryEdgeFrameHeapStatics.getKey();
                                    FrameHeapStatics frameHeapStatics = entryEdgeFrameHeapStatics.getValue();
                                    rootsFromFramesForCallEdge.get(entryEdge).addAll(frameHeapStatics.frame.roots());
                                    thisForCallEdge.put(entryEdge, receiver(caller, stmt, invokeExpr, frameHeapStatics.frame));
                                    List<ImmutableList<MyValue>> args = evaluate(caller, invokeExpr.getArgs(), frameHeapStatics.frame);
                                    argsForCallEdge.put(entryEdge, args);
                                    Set<Address> rootsFromThisArgsStatics = new HashSet<Address>();
                                    rootsFromThisArgsStatics.addAll(rootsFromThis(caller, stmt, invokeExpr, frameHeapStatics.frame));
                                    rootsFromThisArgsStatics.addAll(rootsFromArgs(args));
                                    rootsFromThisArgsStatics.addAll(frameHeapStatics.statics.roots());
                                    rootsFromThisArgsStaticsForCallEdge.put(entryEdge, rootsFromThisArgsStatics);
                                }
                            }
                            for (Map.Entry<Edge, Set<Address>> entryEdgeRootsFromFrames : rootsFromFramesForCallEdge.entrySet()) {
                                Edge entryEdge = entryEdgeRootsFromFrames.getKey();
                                Set<Address> rootsFromFrames = entryEdgeRootsFromFrames.getValue();
                                if (!rootsFromFrames.isEmpty()) {
                                    InformationFlowAnalysis.this.rootsFromFrames.put(Context.v(entryEdge, callEdge), ImmutableList.copyOf(rootsFromFrames));
                                }
                            }
                            for (Map.Entry<Edge, FrameHeapStatics> entryEdgeFrameHeapStatics : frameHeapStaticsForCallEdge.entrySet()) {
                                Edge entryEdge = entryEdgeFrameHeapStatics.getKey();
                                FrameHeapStatics frameHeapStatics = entryEdgeFrameHeapStatics.getValue();
                                Frame frame = new Frame();
                                frame.putS(callee, thisForCallEdge.get(entryEdge));
                                int i = 0;
                                for (Object type : callee.getParameterTypes()) {
                                    frame.putS(MethodMyParameterRef.v(callee,  new ParameterRef((Type)type, i)), argsForCallEdge.get(entryEdge).get(i));
                                    i++;
                                }
                                Heap heap = frameHeapStatics.heap.localize(rootsFromThisArgsStaticsForCallEdge.get(entryEdge), MemoryAccessAnalysis.v().instances.get(callee), MemoryAccessAnalysis.v().arrays.get(callee));
                                Statics statics = frameHeapStatics.statics.localize(MemoryAccessAnalysis.v().statics.get(callee));
                                outStates.put(Context.v(entryEdge, callEdge), new FrameHeapStatics(frame, heap, statics));
                            }
                        } else {
                            if (frameHeapStaticsForEntryEdge == null) {
                                assert rootsFromFramesForEntryEdge == null && thisForEntryEdge == null && argsForEntryEdge == null && rootsFromThisArgsStaticsForEntryEdge == null;
                                frameHeapStaticsForEntryEdge = new FrameHeapStatics();
                                rootsFromFramesForEntryEdge = new HashSet<Address>();
                                for (Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatics : inStates.entrySet()) {
                                    frameHeapStaticsForEntryEdge = frameHeapStaticsForEntryEdge.merge(contextFrameHeapStatics.getValue());
                                    rootsFromFramesForEntryEdge.addAll(rootsFromFrames.get(contextFrameHeapStatics.getKey()));
                                }
                                rootsFromFramesForEntryEdge.addAll(frameHeapStaticsForEntryEdge.frame.roots());
                                thisForEntryEdge = receiver(caller, stmt, invokeExpr, frameHeapStaticsForEntryEdge.frame);
                                argsForEntryEdge = evaluate(caller, invokeExpr.getArgs(), frameHeapStaticsForEntryEdge.frame);
                                rootsFromThisArgsStaticsForEntryEdge = new HashSet<Address>();
                                rootsFromThisArgsStaticsForEntryEdge.addAll(rootsFromThis(caller, stmt, invokeExpr, frameHeapStaticsForEntryEdge.frame));
                                rootsFromThisArgsStaticsForEntryEdge.addAll(rootsFromArgs(argsForEntryEdge));
                                rootsFromThisArgsStaticsForEntryEdge.addAll(frameHeapStaticsForEntryEdge.statics.roots());
                            }
                            if (!rootsFromFramesForEntryEdge.isEmpty()) {
                                rootsFromFrames.put(Context.v(callEdge, callEdge), ImmutableList.copyOf(rootsFromFramesForEntryEdge));
                            }
                            Frame frame = new Frame();
                            frame.putS(callee, thisForEntryEdge);
                            int i = 0;
                            for (Object type : callee.getParameterTypes()) {
                                frame.putS(MethodMyParameterRef.v(callee, new ParameterRef((Type)type, i)), argsForEntryEdge.get(i));
                                i++;
                            }
                            Heap heap = frameHeapStaticsForEntryEdge.heap.localize(rootsFromThisArgsStaticsForEntryEdge, MemoryAccessAnalysis.v().instances.get(callee), MemoryAccessAnalysis.v().arrays.get(callee));
                            Statics statics = frameHeapStaticsForEntryEdge.statics.localize(MemoryAccessAnalysis.v().statics.get(callee));
                            outStates.put(Context.v(callEdge, callEdge), new FrameHeapStatics(frame, heap, statics));
                        }
                    } else {
                        for (Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatics : inStates.entrySet()) {
                            Context context = contextFrameHeapStatics.getKey();
                            FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatics.getValue();
                            Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.thiz, inFrameHeapStatics.frame.params);
                            frame.remove(MethodLocal.v(caller, local));
                            outStates.put(context, new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
                        }
                    }
                    if (!outStates.equals(fromToStates.get(curr).get(succ))) {
                        fromToStates.get(curr).put(succ, outStates);
                        worklist.add(succ);
                    }
                }
            }
        });
    }

    // assign_stmt = variable "=" new_expr
    private States execute(final AssignStmt stmt, Value variable, NewExpr newExpr, States inStates) {
        final States outStates;
        final AllocNode allocNode = GeoPTA.v().getAllocNode(newExpr);
        if (allocNode != null) {
            final SootMethod method = controlFlowGraph.unitToBlock.get(stmt).getBody().getMethod();
            outStates = new States();
            final Address address = Address.v(allocNode);
            final ImmutableList<MyValue> values = ImmutableList.<MyValue>of(address);
            for (final Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
                final Context context = contextFrameHeapStatic.getKey();
                final FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
                // TODO: Do I need to initialize the object's fields with their default values according to their types?

                // variable = array_ref | instance_field_ref | static_field_ref | local;
                variable.apply(new MyAbstractVariableSwitch() {
                    // variable = array_ref | ...;
                    @Override
                    public void caseArrayRef(ArrayRef v) {
                        // TODO
                        throw new UnsupportedOperationException(stmt.toString());
                    }

                    // variable = ... | instance_field_ref | ...;
                    @Override
                    public void caseInstanceFieldRef(InstanceFieldRef v) {
                        // TODO
                        throw new UnsupportedOperationException(stmt.toString());
                    }

                    // variable = ... | static_field_ref | ...;
                    @Override
                    public void caseStaticFieldRef(StaticFieldRef v) {
                        // TODO
                        throw new UnsupportedOperationException(stmt.toString());
                    }

                    // variable = ... | local;
                    @Override
                    public void caseLocal(Local local) {
                        Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.thiz, inFrameHeapStatics.frame.params);
                        frame.putS(MethodLocal.v(method, local), values);
                        Heap heap = new Heap(inFrameHeapStatics.heap, inFrameHeapStatics.heap.arrays);
                        heap.instances.putW(address, ObjectUtil.v().taint, ImmutableList.<MyValue>copyOf(InjectedSourceFlows.v().getInjectedFlows(allocNode)));
                        outStates.put(context, new FrameHeapStatics(frame, heap, inFrameHeapStatics.statics));
                    }
                });
            }
        } else {
            assert controlFlowGraph.unitToBlock.get(stmt).getBody().getMethod().getDeclaringClass().equals(Scene.v().getSootClass("edu.mit.csail.droidsafe.DroidSafeCalls"));
            outStates = inStates;
        }
        return outStates;
    }

    // assign_stmt = variable "=" new_array_expr
    private States execute(final AssignStmt stmt, Value variable, NewArrayExpr newArrayExpr, States inStates) {
        final States outStates;
        AllocNode allocNode = GeoPTA.v().getAllocNode(newArrayExpr);
        if (allocNode != null) {
            final SootMethod method = controlFlowGraph.unitToBlock.get(stmt).getBody().getMethod();
            outStates = new States();
            final ImmutableList<MyValue> values = ImmutableList.<MyValue>of(Address.v(allocNode));
            for (final Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
                final FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
                // variable = array_ref | instance_field_ref | static_field_ref | local;
                variable.apply(new MyAbstractVariableSwitch() {
                    // variable = array_ref | ...;
                    @Override
                    public void caseArrayRef(ArrayRef v) {
                        // TODO
                        throw new UnsupportedOperationException(stmt.toString());
                    }

                    // variable = ... | instance_field_ref | ...;
                    @Override
                    public void caseInstanceFieldRef(InstanceFieldRef v) {
                        // TODO
                        throw new UnsupportedOperationException(stmt.toString());
                    }

                    // variable = ... | static_field_ref | ...;
                    @Override
                    public void caseStaticFieldRef(StaticFieldRef v) {
                        // TODO
                        throw new UnsupportedOperationException(stmt.toString());
                    }

                    // variable = ... | local;
                    @Override
                    public void caseLocal(Local local) {
                        Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.thiz, inFrameHeapStatics.frame.params);
                        frame.putS(MethodLocal.v(method, local), values);
                        outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
                    }
                });
            }
        } else {
            assert controlFlowGraph.unitToBlock.get(stmt).getBody().getMethod().getDeclaringClass().equals(Scene.v().getSootClass("edu.mit.csail.droidsafe.DroidSafeCalls"));
            outStates = inStates;
        }
        return outStates;
    }

    // assign_stmt = variable "=" new_multi_array_expr
    private States execute(final AssignStmt stmt, Value variable, NewMultiArrayExpr newMultiArrayExpr, States inStates) {
        final States outStates;
        AllocNode allocNode = GeoPTA.v().getAllocNode(newMultiArrayExpr);
        if (allocNode != null) {
            final SootMethod method = controlFlowGraph.unitToBlock.get(stmt).getBody().getMethod();
            outStates = new States();
            final ImmutableList<MyValue> values = ImmutableList.<MyValue>of(Address.v(allocNode));
            for (final Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
                final FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
                // TODO: Do I need to initialize the array with its default value according to its type?

                // variable = array_ref | instance_field_ref | static_field_ref | local;
                variable.apply(new MyAbstractVariableSwitch() {
                    // variable = array_ref | ...;
                    @Override
                    public void caseArrayRef(ArrayRef v) {
                        // TODO
                        throw new UnsupportedOperationException(stmt.toString());
                    }

                    // variable = ... | instance_field_ref | ...;
                    @Override
                    public void caseInstanceFieldRef(InstanceFieldRef v) {
                        // TODO
                        throw new UnsupportedOperationException(stmt.toString());
                    }

                    // variable = ... | static_field_ref | ...;
                    @Override
                    public void caseStaticFieldRef(StaticFieldRef v) {
                        // TODO
                        throw new UnsupportedOperationException(stmt.toString());
                    }

                    // variable = ... | local;
                    @Override
                    public void caseLocal(Local local) {
                        Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.thiz, inFrameHeapStatics.frame.params);
                        frame.putS(MethodLocal.v(method, local), values);
                        outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
                    }
                });
            }
        } else {
            assert controlFlowGraph.unitToBlock.get(stmt).getBody().getMethod().getDeclaringClass().equals(Scene.v().getSootClass("edu.mit.csail.droidsafe.DroidSafeCalls"));
            outStates = inStates;
        }
        return outStates;
    }

    // assign_stmt = variable "=" unop_expr
    private States execute(final AssignStmt stmt, Value variable, UnopExpr unopExpr, States inStates) {
        final SootMethod method = controlFlowGraph.unitToBlock.get(stmt).getBody().getMethod();
        final States outStates = new States();
        // unop_expr = length_expr | neg_expr;
        // length_expr = "length" immediate;
        // neg_expr = "-" immediate;
        Immediate immediate = (Immediate)unopExpr.getOp();
        for (final Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
            final FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
            final ImmutableList<MyValue> values = evaluate(method, immediate, inFrameHeapStatics.frame);
            // variable = array_ref | instance_field_ref | static_field_ref | local;
            variable.apply(new MyAbstractVariableSwitch() {
                // variable = array_ref | ...;
                @Override
                public void caseArrayRef(ArrayRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | instance_field_ref | ...;
                @Override
                public void caseInstanceFieldRef(InstanceFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | static_field_ref | ...;
                @Override
                public void caseStaticFieldRef(StaticFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | local;
                @Override
                public void caseLocal(Local local) {
                    Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.thiz, inFrameHeapStatics.frame.params);
                    frame.putS(MethodLocal.v(method, local), values);
                    outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
                }
            });
        }
        return outStates;
    }

    // assign_stmt = variable "=" instance_field_ref
    private States execute(final AssignStmt stmt, Value variable, InstanceFieldRef instanceFieldRef, States inStates) {
        final SootMethod method = controlFlowGraph.unitToBlock.get(stmt).getBody().getMethod();
        final States outStates = new States();
        Local base = (Local)instanceFieldRef.getBase();
        SootField field = instanceFieldRef.getField();
        for (final Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
            final FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
            final Set<MyValue> values = new HashSet<MyValue>();
            for (MyValue instance : inFrameHeapStatics.frame.get(MethodLocal.v(method, base))) {
                if (instance instanceof Address) {
                    values.addAll(inFrameHeapStatics.heap.instances.get((Address)instance, field));
                } else {
                    assert instance instanceof droidsafe.analyses.infoflow.MyKind;
                    values.add(instance);
                }
            }
            // variable = array_ref | instance_field_ref | static_field_ref | local;
            variable.apply(new MyAbstractVariableSwitch() {
                // variable = array_ref | ...;
                @Override
                public void caseArrayRef(ArrayRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | instance_field_ref | ...;
                @Override
                public void caseInstanceFieldRef(InstanceFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | static_field_ref | ...;
                @Override
                public void caseStaticFieldRef(StaticFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | local;
                @Override
                public void caseLocal(Local local) {
                    Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.thiz, inFrameHeapStatics.frame.params);
                    frame.putS(MethodLocal.v(method, local), values);
                    outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
                }
            });
        }
        return outStates;
    }

    // assign_stmt = variable "=" local
    private States execute(final AssignStmt stmt, Value variable, final Local local, final States inStates) {
        final SootMethod method = controlFlowGraph.unitToBlock.get(stmt).getBody().getMethod();
        final States outStates = new States();
        for (final Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
            final Context context = contextFrameHeapStatic.getKey();
            final FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
            final ImmutableList<MyValue> inValues = inFrameHeapStatics.frame.get(MethodLocal.v(method, local));
            // variable = array_ref | instance_field_ref | static_field_ref | local;
            variable.apply(new MyAbstractVariableSwitch() {
                // variable = array_ref | ...;
                @Override
                public void caseArrayRef(ArrayRef arrayRef) {
                    Arrays arrays = new Arrays(inFrameHeapStatics.heap.arrays);
                    for (MyValue value : inFrameHeapStatics.frame.get(MethodLocal.v(method, (Local)arrayRef.getBase()))) {
                        if (value instanceof Address) {
                            arrays.putW((Address)value, inValues);
                        }
                    }
                    outStates.put(context, new FrameHeapStatics(inFrameHeapStatics.frame, new Heap(inFrameHeapStatics.heap.instances, arrays), inFrameHeapStatics.statics));
                }

                // variable = ... | instance_field_ref | ...;
                @Override
                public void caseInstanceFieldRef(InstanceFieldRef instanceFieldRef) {
                    // instance_field_ref "=" local
                    SootField field = instanceFieldRef.getField();
                    Instances instances = new Instances(inFrameHeapStatics.heap.instances);
                    for (MyValue value : inFrameHeapStatics.frame.get(MethodLocal.v(method, (Local)instanceFieldRef.getBase()))) {
                        if (value instanceof Address) {
                            instances.putW((Address)value, field, inValues);
                        }
                    }
                    outStates.put(context, new FrameHeapStatics(inFrameHeapStatics.frame, new Heap(instances, inFrameHeapStatics.heap.arrays), inFrameHeapStatics.statics));
                }

                // variable = ... | static_field_ref | ...;
                @Override
                public void caseStaticFieldRef(StaticFieldRef staticFieldRef) {
                    // static_field_ref "=" local
                    SootField field = staticFieldRef.getField();
                    for (Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
                        FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
                        Statics statics = new Statics(inFrameHeapStatics.statics);
                        statics.putW(field, inValues);
                        outStates.put(context, new FrameHeapStatics(inFrameHeapStatics.frame, inFrameHeapStatics.heap, statics));
                    }
                }

                // variable = ... | local;
                @Override
                public void caseLocal(Local local) {
                    // local "=" local
                    Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.thiz, inFrameHeapStatics.frame.params);
                    frame.putS(MethodLocal.v(method, local), inValues);
                    outStates.put(context, new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
                }
            });
        }
        return outStates;
    }

    // assign_stmt = variable "=" static_field_ref
    private States execute(final AssignStmt stmt, Value variable, StaticFieldRef staticFieldRef, States inStates) {
        final SootMethod method = controlFlowGraph.unitToBlock.get(stmt).getBody().getMethod();
        final States outStates = new States();
        SootField field = staticFieldRef.getField();
        for (Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
            final Context context = contextFrameHeapStatic.getKey();
            final FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
            final ImmutableList<MyValue> values = inFrameHeapStatics.statics.get(field);
            // variable = array_ref | instance_field_ref | static_field_ref | local;
            variable.apply(new MyAbstractVariableSwitch() {
                // variable = array_ref | ...;
                @Override
                public void caseArrayRef(ArrayRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | instance_field_ref | ...;
                @Override
                public void caseInstanceFieldRef(InstanceFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | static_field_ref | ...;
                @Override
                public void caseStaticFieldRef(StaticFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | local;
                @Override
                public void caseLocal(Local local) {
                    Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.thiz, inFrameHeapStatics.frame.params);
                    frame.putS(MethodLocal.v(method, local), values);
                    outStates.put(context, new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
                }
            });
        }
        return outStates;
    }

    // identity_stmt
    private States execute(final IdentityStmt stmt, final States inStates) {
        // identity_stmt = local ":=" identity_value;
        final Local local = (Local)stmt.getLeftOp();
        IdentityRef identityValue = (IdentityRef)stmt.getRightOp();
        // identity_value = caught_exception_ref | parameter_ref | this_ref;
        MyAbstractIdentityValueSwitch identityValueSwitch = new MyAbstractIdentityValueSwitch() {
            // identity_value = caught_exception_ref | ...;
            @Override
            public void caseCaughtExceptionRef(CaughtExceptionRef caughtExceptionRef) {
                // XXX
                // do nothing
            }

            // identity_value = ... | parameter_ref | ...;
            @Override
            public void caseParameterRef(ParameterRef parameterRef) {
                setResult(execute(stmt, local, parameterRef, inStates));
            }

            // identity_value = ... | this_ref;
            @Override
            public void caseThisRef(ThisRef thisRef) {
                setResult(execute(stmt, local, thisRef, inStates));
            }
        };
        identityValue.apply(identityValueSwitch);
        return (States)identityValueSwitch.getResult();
    }

    // identity_stmt = local ":=" parameter_ref
    private States execute(IdentityStmt stmt, Local local, ParameterRef parameterRef, States inStates) {
        SootMethod method = controlFlowGraph.unitToBlock.get(stmt).getBody().getMethod();
        States outStates = new States();
        for (Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
            FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
            Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.thiz, inFrameHeapStatics.frame.params);
            frame.putS(MethodLocal.v(method, local), inFrameHeapStatics.frame.get(MethodMyParameterRef.v(method, parameterRef)));
            outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
        }
        return outStates;
    }

    // identity_stmt = local ":=" this_ref
    private States execute(IdentityStmt stmt, Local local, ThisRef thisRef, States inStates) {
        SootMethod method = controlFlowGraph.unitToBlock.get(stmt).getBody().getMethod();
        States outStates = new States();
        for (Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
            Context context = contextFrameHeapStatic.getKey();
            FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
            Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.thiz, inFrameHeapStatics.frame.params);
            frame.putS(MethodLocal.v(method, local), inFrameHeapStatics.frame.thiz.get(method));
            outStates.put(context, new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
        }
        return outStates;
    }

    // stmt = ... | return_stmt | ...;
    private void execute(final ReturnStmt stmt, final States inStates) {
        // return_stmt = "return" immediate;
        Block block = controlFlowGraph.unitToBlock.get(stmt);
        final SootMethod callee = block.getBody().getMethod();
        for (Block fallThrough : controlFlowGraph.getSuccsOf(block)) {
            // XXX: skip "$r0 := @caughtexception"
            if (InterproceduralControlFlowGraph.containsCaughtExceptionRef(fallThrough.getHead())) {
                continue;
            }
            final SootMethod caller = fallThrough.getBody().getMethod();
            Block callBlock = controlFlowGraph.getPrecedingCallBlock(fallThrough, caller);
            final Unit callStmt = callBlock.getTail();
            final Edge callEdge = callGraph.findEdge(callStmt, callee);
            boolean isEntryEdge = EntryPointCGEdges.v().isEntryPoint(callEdge);
            States outStates = new States();
            for (Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatics : inStates.entrySet()) {
                final Context context = contextFrameHeapStatics.getKey();
                if (!context.callEdge.equals(callEdge)) {
                    continue;
                }
                final FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatics.getValue();
                FrameHeapStatics outFrameHeapStatics;
                if (callStmt instanceof AssignStmt) {
                    final AssignStmt assignStmt = (AssignStmt)callStmt;
                    final ImmutableList<MyValue> returnValues = evaluate(callee, (Immediate)stmt.getOp(), inFrameHeapStatics.frame);
                    // variable = array_ref | instance_field_ref | static_field_ref | local;
                    Value variable = assignStmt.getLeftOp();
                    MyAbstractVariableSwitch variableSwitch = new MyAbstractVariableSwitch() {
                        // variable = array_ref | ...;
                        @Override
                        public void caseArrayRef(ArrayRef arrayRef) {
                            // TODO
                            throw new UnsupportedOperationException(stmt.toString());
                        }

                        // variable = ... | instance_field_ref | ...;
                        @Override
                        public void caseInstanceFieldRef(InstanceFieldRef lInstanceFieldRef) {
                            // TODO
                            throw new UnsupportedOperationException(stmt.toString());
                        }

                        // variable = ... | static_field_ref | ...;
                        @Override
                        public void caseStaticFieldRef(StaticFieldRef lStaticFieldRef) {
                            // TODO
                            throw new UnsupportedOperationException(stmt.toString());
                        }

                        // variable = ... | local;
                        @Override
                        public void caseLocal(final Local local) {
                            Frame frame = new Frame();
                            frame.putS(MethodLocal.v(caller, local), returnValues);
                            Set<Address> roots = new HashSet<Address>(rootsFromFrames.get(Context.v(context.entryEdge, callEdge)));
                            for (MyValue value : returnValues) {
                                if (value instanceof Address) {
                                    roots.add((Address)value);
                                }
                            }
                            roots.addAll(inFrameHeapStatics.statics.roots());
                            setResult(new FrameHeapStatics(frame, inFrameHeapStatics.heap.gc(roots), inFrameHeapStatics.statics));
                        }
                    };
                    variable.apply(variableSwitch);
                    outFrameHeapStatics = (FrameHeapStatics)variableSwitch.getResult();
                } else {
                    Set<Address> roots = new HashSet<Address>(rootsFromFrames.get(context));
                    roots.addAll(inFrameHeapStatics.statics.roots());
                    outFrameHeapStatics = new FrameHeapStatics(Frame.EMPTY, inFrameHeapStatics.heap.gc(roots), inFrameHeapStatics.statics);
                }
                if (!isEntryEdge) {
                    for (Context ctx : fromToStates.get(callBlock).get(fallThrough).keySet()) {
                        assert ctx != null;
                        if (ctx.entryEdge.equals(context.entryEdge)) {
                            outStates.put(ctx, outFrameHeapStatics);
                        }
                    }
                } else {
                    for (Context ctx : fromToStates.get(callBlock).get(fallThrough).keySet()) {
                        assert ctx != null;
                        outStates.put(ctx, outFrameHeapStatics);
                    }
                }
            }
            if (!outStates.equals(fromToStates.get(block).get(fallThrough))) {
                fromToStates.get(block).put(fallThrough, outStates);
                worklist.add(fallThrough);
            }
        }
    }

    // stmt = ... | return_void_stmt | ...;
    private void execute(final ReturnVoidStmt stmt, final States inStates) {
        // return_void_stmt = "return";
        Block block = controlFlowGraph.unitToBlock.get(stmt);
        SootMethod callee = block.getBody().getMethod();
        for (Block fallThrough : controlFlowGraph.getSuccsOf(block)) {
            // XXX: skip "$r0 := @caughtexception"
            if (InterproceduralControlFlowGraph.containsCaughtExceptionRef(fallThrough.getHead())) {
                continue;
            }
            SootMethod caller = fallThrough.getBody().getMethod();
            Block callBlock = controlFlowGraph.getPrecedingCallBlock(fallThrough, caller);
            Unit callStmt = callBlock.getTail();
            Edge callEdge = callGraph.findEdge(callStmt, callee);
            boolean isEntryEdge = EntryPointCGEdges.v().isEntryPoint(callEdge);
            States outStates = new States();
            for (Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatics : inStates.entrySet()) {
                Context context = contextFrameHeapStatics.getKey();
                if (!context.callEdge.equals(callEdge)) {
                    continue;
                }
                FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatics.getValue();
                Set<Address> roots = new HashSet<Address>(rootsFromFrames.get(context));
                roots.addAll(inFrameHeapStatics.statics.roots());
                FrameHeapStatics outFrameHeapStatics = new FrameHeapStatics(Frame.EMPTY, inFrameHeapStatics.heap.gc(roots), inFrameHeapStatics.statics);
                if (!isEntryEdge) {
                    for (Context ctx : fromToStates.get(callBlock).get(fallThrough).keySet()) {
                        assert ctx != null;
                        if (ctx.entryEdge.equals(context.entryEdge)) {
                            outStates.put(ctx, outFrameHeapStatics);
                        }
                    }
                } else {
                    for (Context ctx : fromToStates.get(callBlock).get(fallThrough).keySet()) {
                        assert ctx != null;
                        outStates.put(ctx, outFrameHeapStatics);
                    }
                }
            }
            if (!outStates.equals(fromToStates.get(block).get(fallThrough))) {
                fromToStates.get(block).put(fallThrough, outStates);
                worklist.add(fallThrough);
            }
        }
    }

    // stmt = ... | assign_stmt | ... ;
    // assign_stmt = variable "=" rvalue;
    // variable = array_ref | instance_field_ref | static_field_ref;
    // rvalue = ... | expr | ...;
    // expr = ... | invoke_expr | ...;

    // stmt = ... | invoke_stmt | ...;
    // invoke_stmt = invoke_expr;

    // invoke_expr = interface_invoke_expr | special _invoke_expr | static_invoke_expr | virtual_invoke_expr;
    // interface_invoke_expr = "interfaceinvoke" immediate ".[" + method_signature "]" "(" immediate_list ")"
    // special_invoke_expr = "specialinvoke" immediate ".[" method_signature "]" "(" immediate_list ")";
    // static_invoke_expr = "staticinvoke" "[" method_signature "]" "(" immediate_list ")";
    // virtual_invoke_expr = "virtualinvoke" immediate ".[" method_signamter "]" "(" immediate_list ")";
    private void execute(Stmt stmt, InvokeExpr invokeExpr, final States inStates) {
        assert(stmt.containsInvokeExpr());
        Block curr = controlFlowGraph.unitToBlock.get(stmt);
        List<Block> succs = controlFlowGraph.getSuccsOf(curr);
        assert succs.size() > 0;

        if (succs.size() == 1) {
            Block succ = succs.get(0);
            assert curr.getBody().getMethod().equals(succ.getBody().getMethod());
            assert !InterproceduralControlFlowGraph.containsCaughtExceptionRef(succ.getHead());
            States outStates = inStates;
            if (!outStates.equals(fromToStates.get(curr).get(succ))) {
                fromToStates.get(curr).put(succ, outStates);
                worklist.add(succ);
            }
            return;
        }

        boolean isAddTaint = false;
        boolean isGetTaint = false;
        for (Block succ : succs) {
            SootMethod method = succ.getBody().getMethod();
            if (ObjectUtil.v().isAddTaint(method)) {
                isAddTaint = true;
                break;
            }
            else if (ObjectUtil.v().isGetTaint(method)) {
                isGetTaint = true;
                break;
            }
        }
        if (isAddTaint) {
            assert succs.size() == 2;
            States outStates = new States();
            SootMethod caller = curr.getBody().getMethod();
            for (Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatics : inStates.entrySet()) {
                Context context = contextFrameHeapStatics.getKey();
                FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatics.getValue();
                ImmutableList<MyValue> receivers = receiver(caller, stmt, invokeExpr, inFrameHeapStatics.frame);
                ImmutableList<MyValue> arg = evaluate(caller, invokeExpr.getArgs(), inFrameHeapStatics.frame).get(0);
                Instances instances = new Instances(inFrameHeapStatics.heap.instances);
                for (MyValue receiver : receivers) {
                    instances.putW((Address)receiver, ObjectUtil.v().taint, arg);
                }
                outStates.put(context, new FrameHeapStatics(inFrameHeapStatics.frame, new Heap(instances, inFrameHeapStatics.heap.arrays), inFrameHeapStatics.statics));
            }
            Block fallThrough = controlFlowGraph.getFallThrough(curr);
            if (!outStates.equals(fromToStates.get(curr).get(fallThrough))) {
                fromToStates.get(curr).put(fallThrough, outStates);
                worklist.add(fallThrough);
            }
            return;
        } else if (isGetTaint) {
            assert succs.size() == 2;
            States outStates = inStates;
            Block fallThrough = controlFlowGraph.getFallThrough(curr);
            if (!outStates.equals(fromToStates.get(curr).get(fallThrough))) {
                fromToStates.get(curr).put(fallThrough, outStates);
                worklist.add(fallThrough);
            }
            return;
        }

        SootMethod caller = curr.getBody().getMethod();

        Map<Edge, FrameHeapStatics> frameHeapStaticsForCallEdge = null;
        Map<Edge, Set<Address>> rootsFromFramesForCallEdge = null;
        Map<Edge, ImmutableList<MyValue>> thisForCallEdge = null;
        Map<Edge, List<ImmutableList<MyValue>>> argsForCallEdge = null;
        Map<Edge, Set<Address>> rootsFromThisArgsStaticsForCallEdge = null;

        FrameHeapStatics frameHeapStaticsForEntryEdge = null;
        Set<Address> rootsFromFramesForEntryEdge = null;
        ImmutableList<MyValue> thisForEntryEdge = null;
        List<ImmutableList<MyValue>> argsForEntryEdge = null;
        Set<Address> rootsFromThisArgsStaticsForEntryEdge = null;

        for (Block succ : controlFlowGraph.getSuccsOf(curr)) {
            // XXX: skip "$r0 := @caughtexception"
            if (InterproceduralControlFlowGraph.containsCaughtExceptionRef(succ.getHead())) {
                continue;
            }
            States outStates;
            SootMethod callee = succ.getBody().getMethod();
            if (!caller.equals(callee)) {
                outStates = new States();
                Edge callEdge = callGraph.findEdge(stmt, callee);
                assert callEdge != null;
                if (!EntryPointCGEdges.v().isEntryPoint(callEdge)) {
                    if (frameHeapStaticsForCallEdge == null) {
                        assert rootsFromFramesForCallEdge == null && thisForCallEdge == null && argsForCallEdge == null && rootsFromThisArgsStaticsForCallEdge == null;
                        frameHeapStaticsForCallEdge = new DefaultHashMap<Edge, FrameHeapStatics>(FrameHeapStatics.EMPTY);
                        rootsFromFramesForCallEdge = new DefaultHashMap<Edge, Set<Address>>(Collections.<Address>emptySet());
                        for (Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatics : inStates.entrySet()) {
                            Context context = contextFrameHeapStatics.getKey();
                            frameHeapStaticsForCallEdge.put(context.entryEdge, frameHeapStaticsForCallEdge.get(context.entryEdge).merge(contextFrameHeapStatics.getValue()));
                            Set<Address> rootsFromFrames = new HashSet<Address>(rootsFromFramesForCallEdge.get(context.entryEdge));
                            rootsFromFrames.addAll(InformationFlowAnalysis.this.rootsFromFrames.get(context));
                            rootsFromFramesForCallEdge.put(context.entryEdge, rootsFromFrames);
                        }
                        thisForCallEdge = new HashMap<Edge, ImmutableList<MyValue>>();
                        argsForCallEdge = new HashMap<Edge, List<ImmutableList<MyValue>>>();
                        rootsFromThisArgsStaticsForCallEdge = new HashMap<Edge, Set<Address>>();
                        for (Map.Entry<Edge, FrameHeapStatics> entryEdgeFrameHeapStatics : frameHeapStaticsForCallEdge.entrySet()) {
                            Edge entryEdge = entryEdgeFrameHeapStatics.getKey();
                            FrameHeapStatics frameHeapStatics = entryEdgeFrameHeapStatics.getValue();
                            rootsFromFramesForCallEdge.get(entryEdge).addAll(frameHeapStatics.frame.roots());
                            thisForCallEdge.put(entryEdge, receiver(caller, stmt, invokeExpr, frameHeapStatics.frame));
                            List<ImmutableList<MyValue>> args = evaluate(caller, invokeExpr.getArgs(), frameHeapStatics.frame);
                            argsForCallEdge.put(entryEdge, args);
                            Set<Address> rootsFromThisArgsStatics = new HashSet<Address>();
                            rootsFromThisArgsStatics.addAll(rootsFromThis(caller, stmt, invokeExpr, frameHeapStatics.frame));
                            rootsFromThisArgsStatics.addAll(rootsFromArgs(args));
                            rootsFromThisArgsStatics.addAll(frameHeapStatics.statics.roots());
                            rootsFromThisArgsStaticsForCallEdge.put(entryEdge, rootsFromThisArgsStatics);
                        }
                    }
                    for (Map.Entry<Edge, Set<Address>> entryEdgeRootsFromFrames : rootsFromFramesForCallEdge.entrySet()) {
                        Edge entryEdge = entryEdgeRootsFromFrames.getKey();
                        Set<Address> rootsFromFrames = entryEdgeRootsFromFrames.getValue();
                        if (!rootsFromFrames.isEmpty()) {
                            InformationFlowAnalysis.this.rootsFromFrames.put(Context.v(entryEdge, callEdge), ImmutableList.copyOf(rootsFromFrames));
                        }
                    }
                    for (Map.Entry<Edge, FrameHeapStatics> entryEdgeFrameHeapStatics : frameHeapStaticsForCallEdge.entrySet()) {
                        Edge entryEdge = entryEdgeFrameHeapStatics.getKey();
                        FrameHeapStatics frameHeapStatics = entryEdgeFrameHeapStatics.getValue();
                        Frame frame = new Frame();
                        frame.putS(callee, thisForCallEdge.get(entryEdge));
                        int i = 0;
                        for (Object type : callee.getParameterTypes()) {
                            frame.putS(MethodMyParameterRef.v(callee,  new ParameterRef((Type)type, i)), argsForCallEdge.get(entryEdge).get(i));
                            i++;
                        }
                        Heap heap = frameHeapStatics.heap.localize(rootsFromThisArgsStaticsForCallEdge.get(entryEdge), MemoryAccessAnalysis.v().instances.get(callee), MemoryAccessAnalysis.v().arrays.get(callee));
                        Statics statics = frameHeapStatics.statics.localize(MemoryAccessAnalysis.v().statics.get(callee));
                        outStates.put(Context.v(entryEdge, callEdge), new FrameHeapStatics(frame, heap, statics));
                    }
                } else {
                    if (frameHeapStaticsForEntryEdge == null) {
                        assert rootsFromFramesForEntryEdge == null && thisForEntryEdge == null && argsForEntryEdge == null && rootsFromThisArgsStaticsForEntryEdge == null;
                        frameHeapStaticsForEntryEdge = new FrameHeapStatics();
                        rootsFromFramesForEntryEdge = new HashSet<Address>();
                        for (Map.Entry<Context, FrameHeapStatics> contextFrameHeapStatics : inStates.entrySet()) {
                            frameHeapStaticsForEntryEdge = frameHeapStaticsForEntryEdge.merge(contextFrameHeapStatics.getValue());
                            rootsFromFramesForEntryEdge.addAll(rootsFromFrames.get(contextFrameHeapStatics.getKey()));
                        }
                        rootsFromFramesForEntryEdge.addAll(frameHeapStaticsForEntryEdge.frame.roots());
                        thisForEntryEdge = receiver(caller, stmt, invokeExpr, frameHeapStaticsForEntryEdge.frame);
                        argsForEntryEdge = evaluate(caller, invokeExpr.getArgs(), frameHeapStaticsForEntryEdge.frame);
                        rootsFromThisArgsStaticsForEntryEdge = new HashSet<Address>();
                        rootsFromThisArgsStaticsForEntryEdge.addAll(rootsFromThis(caller, stmt, invokeExpr, frameHeapStaticsForEntryEdge.frame));
                        rootsFromThisArgsStaticsForEntryEdge.addAll(rootsFromArgs(argsForEntryEdge));
                        rootsFromThisArgsStaticsForEntryEdge.addAll(frameHeapStaticsForEntryEdge.statics.roots());
                    }
                    if (!rootsFromFramesForEntryEdge.isEmpty()) {
                        rootsFromFrames.put(Context.v(callEdge, callEdge), ImmutableList.copyOf(rootsFromFramesForEntryEdge));
                    }
                    Frame frame = new Frame();
                    frame.putS(callee, thisForEntryEdge);
                    int i = 0;
                    for (Object type : callee.getParameterTypes()) {
                        frame.putS(MethodMyParameterRef.v(callee, new ParameterRef((Type)type, i)), argsForEntryEdge.get(i));
                        i++;
                    }
                    Heap heap = frameHeapStaticsForEntryEdge.heap.localize(rootsFromThisArgsStaticsForEntryEdge, MemoryAccessAnalysis.v().instances.get(callee), MemoryAccessAnalysis.v().arrays.get(callee));
                    Statics statics = frameHeapStaticsForEntryEdge.statics.localize(MemoryAccessAnalysis.v().statics.get(callee));
                    outStates.put(Context.v(callEdge, callEdge), new FrameHeapStatics(frame, heap, statics));
                }
            } else {
                outStates = inStates;
            }
            if (!outStates.equals(fromToStates.get(curr).get(succ))) {
                fromToStates.get(curr).put(succ, outStates);
                worklist.add(succ);
            }
        }
    }

    private ImmutableList<MyValue> evaluate(final SootMethod method, Immediate immediate, final Frame frame) {
        // immediate = constant | local;
        MyAbstractImmediateSwitch immediateSwitch = new MyAbstractImmediateSwitch() {
            // immediate = constant | ...;
            // constant = double_constant | float_constant | int_constant | long_constant | string_constant | null_constant | class_constant;
            @Override
            public void caseConstant(Constant constant) {
                setResult(ImmutableList.<MyValue>of());
            }

            // immediate = ... | local;
            @Override
            public void caseLocal(Local rLocal) {
                setResult(frame.get(MethodLocal.v(method, rLocal)));
            }
        };
        immediate.apply(immediateSwitch);
        return (ImmutableList<MyValue>)immediateSwitch.getResult();
    }

    private List<ImmutableList<MyValue>> evaluate(final SootMethod method, List<Value> immediates, final Frame frame) {
        final List<ImmutableList<MyValue>> values = new ArrayList<ImmutableList<MyValue>>();
        for (Value immediate : immediates) {
            assert immediate instanceof Immediate;
            // immediate = constant | local;
            immediate.apply(new MyAbstractImmediateSwitch() {
                // immediate = constant | ...;
                // constant = double_constant | float_constant | int_constant | long_constant | string_constant | null_constant | class_constant;
                @Override
                public void caseConstant(Constant constant) {
                    values.add(ImmutableList.<MyValue>of());
                }

                // immediate = ... | local;
                @Override
                public void caseLocal(Local rLocal) {
                    values.add(frame.get(MethodLocal.v(method, rLocal)));
                }
            });
        }
        return values;
    }

    private ImmutableList<MyValue> receiver(final SootMethod caller, final Stmt stmt, InvokeExpr invokeExpr, final Frame frame) {
        MyAbstractInvokeExprSwitch invokeExprSwitch = new MyAbstractInvokeExprSwitch() {
            @Override
            public void caseInterfaceInvokeExpr(InterfaceInvokeExpr invokeExpr) {
                // interface_invoke_expr = "interfaceinvoke" immediate ".[" + method_signature "]" "(" immediate_list ")"
                Immediate immediate = (Immediate)invokeExpr.getBase();
                setResult(evaluate(caller, immediate, frame));
            }

            @Override
            public void caseSpecialInvokeExpr(SpecialInvokeExpr invokeExpr) {
                // special_invoke_expr = "specialinvoke" immediate ".[" method_signature "]" "(" immediate_list ")";
                Immediate immediate = (Immediate)invokeExpr.getBase();
                setResult(evaluate(caller, immediate, frame));
            }

            @Override
            public void caseStaticInvokeExpr(StaticInvokeExpr invokeEpxr) {
                // static_invoke_expr = "staticinvoke" "[" method_signature "]" "(" immediate_list ")";
                // do nothing
            }

            @Override
            public void caseVirtualInvokeExpr(VirtualInvokeExpr invokeExpr) {
                // virtual_invoke_expr = "virtualinvoke" immediate ".[" method_signamter "]" "(" immediate_list ")";
                Immediate immediate = (Immediate)invokeExpr.getBase();
                setResult(evaluate(caller, immediate, frame));
            }

            @Override
            public void caseDynamicInvokeExpr(DynamicInvokeExpr invokeExpr) {
                // TODO
                throw new UnsupportedOperationException(stmt.toString());
            }
        };
        invokeExpr.apply(invokeExprSwitch);
        return (ImmutableList<MyValue>)invokeExprSwitch.getResult();
    }

    private Set<Address> rootsFromThis(final SootMethod caller, final Stmt stmt, final InvokeExpr invokeExpr, final Frame frame) {
        assert(stmt.containsInvokeExpr());
        final Set<Address> roots = new HashSet<Address>();
        invokeExpr.apply(new MyAbstractInvokeExprSwitch() {
            @Override
            public void caseInterfaceInvokeExpr(InterfaceInvokeExpr invokeExpr) {
                // interface_invoke_expr = "interfaceinvoke" immediate ".[" + method_signature "]" "(" immediate_list ")"
                Immediate immediate = (Immediate)invokeExpr.getBase();
                for (MyValue value : evaluate(caller, immediate, frame)) {
                    if (value instanceof Address) {
                        roots.add((Address)value);
                    }
                }
            }

            @Override
            public void caseSpecialInvokeExpr(SpecialInvokeExpr e) {
                // special_invoke_expr = "specialinvoke" immediate ".[" method_signature "]" "(" immediate_list ")";
                Immediate immediate = (Immediate)e.getBase();
                for (MyValue value : evaluate(caller, immediate, frame)) {
                    if (value instanceof Address) {
                        roots.add((Address)value);
                    }
                }
            }

            @Override
            public void caseStaticInvokeExpr(StaticInvokeExpr e) {
                // static_invoke_expr = "staticinvoke" "[" method_signature "]" "(" immediate_list ")";
                // do nothing
            }

            @Override
            public void caseVirtualInvokeExpr(VirtualInvokeExpr e) {
                // virtual_invoke_expr = "virtualinvoke" immediate ".[" method_signamter "]" "(" immediate_list ")";
                Immediate immediate = (Immediate)e.getBase();
                for (MyValue value : evaluate(caller, immediate, frame)) {
                    if (value instanceof Address) {
                        roots.add((Address)value);
                    }
                }
            }

            @Override
            public void caseDynamicInvokeExpr(DynamicInvokeExpr e) {
                // TODO
                throw new UnsupportedOperationException(stmt.toString());
            }
        });
        return roots;
    }

    private Set<Address> rootsFromArgs(List<ImmutableList<MyValue>> args) {
        Set<Address> roots = new HashSet<Address>();
        for (ImmutableList<MyValue> values : args) {
            for (MyValue value : values) {
                if (value instanceof Address) {
                    roots.add((Address)value);
                }
            }
        }
        return roots;
    }

    private static void exportDotGraph(final Graph<Block, DefaultEdge> jGraphT, String fileName) throws IOException {
        final InformationFlowAnalysis infoflow = InformationFlowAnalysis.v();
        DOTExporter<Block, DefaultEdge> dotExporter = new DOTExporter<Block, DefaultEdge>(
                new IntegerNameProvider<Block>(),
                new VertexNameProvider<Block>() {
                    @Override
                    public String getVertexName(Block vertex) {
                        StringBuilder str = new StringBuilder(vertex.getBody().getMethod() + "\n" + vertex);
                        return StringEscapeUtils.escapeJava(str.toString());
                    }
                },
                new EdgeNameProvider<DefaultEdge>() {
                    @Override
                    public String getEdgeName(DefaultEdge edge) {
                        States states = infoflow.getFlowFromTo(jGraphT.getEdgeSource(edge), jGraphT.getEdgeTarget(edge));
                        CharSequenceTranslator translator = new LookupTranslator(new String[][] {{"\\l", "\\l"}}).with(StringEscapeUtils.ESCAPE_JAVA);
                        return translator.translate(states.toString()) + "\\l";
                    }
                });
        dotExporter.export(new BufferedWriter(new FileWriter(fileName)), jGraphT);
    }

}

class ObjectUtil {
    private static ObjectUtil v;

    public static void run() {
        v = new ObjectUtil();
    }

    public static ObjectUtil v() {
        return v;
    }

    SootField taint;
    Set<SootMethod> addTaints;
    Set<SootMethod> getTaints;

    private ObjectUtil() {
        SootClass klass = Scene.v().getSootClass("java.lang.Object");
        assert klass != null;
        taint = klass.getFieldByName("taint");
        assert taint != null;
        addTaints = new HashSet<SootMethod>();
        getTaints = new HashSet<SootMethod>();
        for (SootMethod method : klass.getMethods()) {
            if (method.getName().startsWith("addTaint")) {
                addTaints.add(method);
            } else if (method.getName().startsWith("getTaint")) {
                getTaints.add(method);
            }
        }
    }

    boolean isAddTaint(SootMethod method) {
        return addTaints.contains(method);
    }

    boolean isGetTaint(SootMethod method) {
        return getTaints.contains(method);
    }
}

/**
 * Memory Access Analysis
 */

class MemoryAccessAnalysis {
    public static MemoryAccessAnalysis v() {
        return v;
    }

    public static void run() {
        v = new MemoryAccessAnalysis(InterproceduralControlFlowGraph.v());
    }

    private static MemoryAccessAnalysis v;

    private final InterproceduralControlFlowGraph controlFlowGraph;
    private final CallGraph callGraph;

    public Map<SootMethod, ImmutableList<AddressField>> instances;
    public Map<SootMethod, ImmutableList<SootField>> statics;
    public Map<SootMethod, ImmutableList<Address>> arrays;

    private final static Logger logger = LoggerFactory.getLogger(MemoryAccessAnalysis.class);

    private MemoryAccessAnalysis(InterproceduralControlFlowGraph controlFlowGraph) {
        this.controlFlowGraph = controlFlowGraph;
        callGraph = Scene.v().getCallGraph();

        instances = new DefaultHashMap<SootMethod, ImmutableList<AddressField>>(ImmutableList.<AddressField>of());
        statics = new DefaultHashMap<SootMethod, ImmutableList<SootField>>(ImmutableList.<SootField>of());
        arrays = new DefaultHashMap<SootMethod, ImmutableList<Address>>(ImmutableList.<Address>of());

        doAnalysis();
    }

    private void doAnalysis() {
        Map<SootMethod, Set<AddressField>> mtoaf = new DefaultHashMap<SootMethod, Set<AddressField>>(Collections.<AddressField>emptySet());
        Map<SootMethod, Set<SootField>> mtof = new DefaultHashMap<SootMethod, Set<SootField>>(Collections.<SootField>emptySet());
        Map<SootMethod, Set<Address>> mtoa = new DefaultHashMap<SootMethod, Set<Address>>(Collections.<Address>emptySet());
        for (Map.Entry<SootMethod, List<Block>> methodBlocks : controlFlowGraph.methodToBlocks.entrySet()) {
            SootMethod method = methodBlocks.getKey();
            List<Block> blocks = methodBlocks.getValue();
            mtoaf.put(method, accessi(blocks));
            mtof.put(method, accesss(blocks));
            mtoa.put(method, accessa(blocks));
        }

        TransitiveTargets transitiveTargets = new TransitiveTargets(callGraph);
        for (SootMethod srcMethod : controlFlowGraph.methodToBlocks.keySet()) {
            HashSet<AddressField> addressFields = new HashSet<AddressField>(mtoaf.get(srcMethod));
            HashSet<SootField> fields = new HashSet<SootField>(mtof.get(srcMethod));
            HashSet<Address> addresses = new HashSet<Address>(mtoa.get(srcMethod));
            Iterator<MethodOrMethodContext> it = transitiveTargets.iterator(srcMethod);
            while (it.hasNext()) {
                SootMethod tgtMethod = (SootMethod)it.next();
                addressFields.addAll(mtoaf.get(tgtMethod));
                fields.addAll(mtof.get(tgtMethod));
                addresses.addAll(mtoa.get(tgtMethod));
            }
            instances.put(srcMethod, ImmutableList.copyOf(addressFields));
            statics.put(srcMethod, ImmutableList.copyOf(fields));
            arrays.put(srcMethod, ImmutableList.copyOf(addresses));
        }

        return;
    }

    private Set<AddressField> accessi(List<Block> blocks) {
        Set<AddressField> addressFields = new HashSet<AddressField>();
        for (Block block : blocks) {
            Iterator<Unit> it = block.iterator();
            while (it.hasNext()) {
                Set<AddressField> addrflds = null;
                Unit unit = it.next();
                if (unit instanceof AssignStmt) {
                    addrflds = accessi((AssignStmt)unit);
                } else if (unit instanceof InvokeStmt) {
                    addrflds = accessi((InvokeStmt)unit);
                }
                if (addrflds != null) {
                    addressFields.addAll(addrflds);
                }
            }
        }
        return addressFields;
    }

    private Set<AddressField> accessi(AssignStmt stmt) {
        Set<AddressField> addressFields = null;
        Value rValue = stmt.getRightOp();
        if (rValue instanceof InstanceFieldRef) {
            addressFields = new HashSet<AddressField>();
            addressFields.addAll(accessi(stmt, (InstanceFieldRef)rValue));
        } else if (rValue instanceof NewExpr) {
            AllocNode allocNode = GeoPTA.v().getAllocNode(rValue);
            if (allocNode != null) {
                if (!InjectedSourceFlows.v().getInjectedFlows(allocNode).isEmpty()) {
                    addressFields = new HashSet<AddressField>();
                    addressFields.add(AddressField.v(Address.v(allocNode), ObjectUtil.v().taint));
                }
            }
        } else if (rValue instanceof InvokeExpr) {
            boolean isGetTaint = false;
            @SuppressWarnings("rawtypes")
            Iterator targets = new Targets(callGraph.edgesOutOf(stmt));
            while (targets.hasNext()) {
                if (ObjectUtil.v().isGetTaint((SootMethod)targets.next())) {
                    isGetTaint = true;
                    break;
                }
            }
            if (isGetTaint) {
                addressFields = new HashSet<AddressField>();
                for (MyValue value : receiver(stmt, (InvokeExpr)rValue)) {
                    addressFields.add(AddressField.v((Address)value, ObjectUtil.v().taint));
                }
            }
        }
        Value variable = stmt.getLeftOp();
        if (variable instanceof InstanceFieldRef) {
            if (addressFields == null) {
                addressFields = new HashSet<AddressField>();
            }
            addressFields.addAll(accessi(stmt, (InstanceFieldRef)variable));
        }
        return addressFields;
    }

    private Set<AddressField> accessi(final AssignStmt stmt, InstanceFieldRef instanceFieldRef) {
        SootField field = instanceFieldRef.getField();
        final Set<AddressField> addressFields = new HashSet<AddressField>();
        for (AllocNode allocNode : GeoPTA.v().getPTSetContextIns(instanceFieldRef.getBase())) {
            addressFields.add(AddressField.v(Address.v(allocNode), field));
        }
        return addressFields;
    }

    private Set<AddressField> accessi(InvokeStmt stmt) {
        Set<AddressField> addressFields = null;
        boolean isAddTaint = false;
        @SuppressWarnings("rawtypes")
        Iterator targets = new Targets(callGraph.edgesOutOf(stmt));
        while (targets.hasNext()) {
            if (ObjectUtil.v().isAddTaint((SootMethod)targets.next())) {
                isAddTaint = true;
                break;
            }
        }
        if (isAddTaint) {
            addressFields = new HashSet<AddressField>();
            for (MyValue value : receiver(stmt, stmt.getInvokeExpr())) {
                addressFields.add(AddressField.v((Address)value, ObjectUtil.v().taint));
            }
        }
        return addressFields;
    }

    private Set<SootField> accesss(List<Block> blocks) {
        Set<SootField> fields = new HashSet<SootField>();
        for (Block block : blocks) {
            Iterator<Unit> it = block.iterator();
            while (it.hasNext()) {
                Unit unit = it.next();
                if (unit instanceof AssignStmt) {
                    Set<SootField> flds = accesss((AssignStmt)unit);
                    if (flds != null) {
                        fields.addAll(flds);
                    }
                }
            }
        }
        return fields;
    }

    private Set<SootField> accesss(AssignStmt stmt) {
        Set<SootField> fields = null;
        Value rValue = stmt.getRightOp();
        if (rValue instanceof StaticFieldRef) {
            fields = new HashSet<SootField>();
            fields.addAll(accesss(stmt, (StaticFieldRef)rValue));
        }
        Value variable = stmt.getLeftOp();
        if (variable instanceof StaticFieldRef) {
            if (fields == null) {
                fields = new HashSet<SootField>();
            }
            fields.addAll(accesss(stmt, (StaticFieldRef)variable));
        }
        return fields;
    }

    private Set<SootField> accesss(final AssignStmt stmt, StaticFieldRef staticFieldRef) {
        return ImmutableSet.of(staticFieldRef.getField());
    }

    private Set<Address> accessa(List<Block> blocks) {
        Set<Address> addresses = new HashSet<Address>();
        for (Block block : blocks) {
            Iterator<Unit> it = block.iterator();
            while (it.hasNext()) {
                Unit unit = it.next();
                if (unit instanceof AssignStmt) {
                    Set<Address> addrs = accessa((AssignStmt)unit);
                    if (addrs != null) {
                        addresses.addAll(addrs);
                    }
                }
            }
        }
        return addresses;
    }

    private Set<Address> accessa(AssignStmt stmt) {
        Set<Address> addresses = null;
        Value rValue = stmt.getRightOp();
        if (rValue instanceof ArrayRef) {
            addresses = new HashSet<Address>();
            addresses.addAll(accessa(stmt, (ArrayRef)rValue));
        }
        Value variable = stmt.getLeftOp();
        if (variable instanceof ArrayRef) {
            if (addresses == null) {
                addresses = new HashSet<Address>();
            }
            addresses.addAll(accessa(stmt, (ArrayRef)variable));
        }
        return addresses;
    }

    private Set<Address> accessa(final AssignStmt stmt, ArrayRef arrayRef) {
        final Set<Address> addresses = new HashSet<Address>();
        for (AllocNode allocNode : GeoPTA.v().getPTSetContextIns(arrayRef.getBase())) {
            addresses.add(Address.v(allocNode));
        }
        return addresses;
    }

    private Set<MyValue> evaluate(final Stmt stmt, Immediate immediate) {
        // immediate = constant | local;
        MyAbstractImmediateSwitch immediateSwitch = new MyAbstractImmediateSwitch() {
            // immediate = constant | ...;
            // constant = double_constant | float_constant | int_constant | long_constant | string_constant | null_constant | class_constant;
            @Override
            public void caseConstant(Constant constant) {
                setResult(Collections.<MyValue>emptySet());
            }

            // immediate = ... | local;
            @Override
            public void caseLocal(Local local) {
                HashSet<MyValue> values = new HashSet<MyValue>();
                for (AllocNode allocNode : GeoPTA.v().getPTSetContextIns(local)) {
                    values.add(Address.v(allocNode));
                }
                setResult(values);
            }
        };
        immediate.apply(immediateSwitch);
        return (Set<MyValue>)immediateSwitch.getResult();
    }

    private Set<MyValue> receiver(final Stmt stmt, InvokeExpr invokeExpr) {
        MyAbstractInvokeExprSwitch invokeExprSwitch = new MyAbstractInvokeExprSwitch() {
            @Override
            public void caseInterfaceInvokeExpr(InterfaceInvokeExpr invokeExpr) {
                // interface_invoke_expr = "interfaceinvoke" immediate ".[" + method_signature "]" "(" immediate_list ")"
                Immediate immediate = (Immediate)invokeExpr.getBase();
                setResult(evaluate(stmt, immediate));
            }

            @Override
            public void caseSpecialInvokeExpr(SpecialInvokeExpr invokeExpr) {
                // special_invoke_expr = "specialinvoke" immediate ".[" method_signature "]" "(" immediate_list ")";
                Immediate immediate = (Immediate)invokeExpr.getBase();
                setResult(evaluate(stmt, immediate));
            }

            @Override
            public void caseStaticInvokeExpr(StaticInvokeExpr invokeEpxr) {
                // static_invoke_expr = "staticinvoke" "[" method_signature "]" "(" immediate_list ")";
                setResult(Collections.<MyValue>emptySet());
            }

            @Override
            public void caseVirtualInvokeExpr(VirtualInvokeExpr invokeExpr) {
                // virtual_invoke_expr = "virtualinvoke" immediate ".[" method_signamter "]" "(" immediate_list ")";
                Immediate immediate = (Immediate)invokeExpr.getBase();
                setResult(evaluate(stmt, immediate));
            }

            @Override
            public void caseDynamicInvokeExpr(DynamicInvokeExpr invokeExpr) {
                // TODO
                throw new UnsupportedOperationException(stmt.toString());
            }
        };
        invokeExpr.apply(invokeExprSwitch);
        return (Set<MyValue>)invokeExprSwitch.getResult();
    }
}
