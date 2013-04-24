package droidsafe.analyses.infoflow;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
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

import soot.Immediate;
import soot.Kind;
import soot.Local;
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
import soot.jimple.IdentityRef;
import soot.jimple.IdentityStmt;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceOfExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.NewArrayExpr;
import soot.jimple.NewExpr;
import soot.jimple.NewMultiArrayExpr;
import soot.jimple.ParameterRef;
import soot.jimple.ReturnStmt;
import soot.jimple.ReturnVoidStmt;
import soot.jimple.StaticFieldRef;
import soot.jimple.Stmt;
import soot.jimple.ThisRef;
import soot.jimple.UnopExpr;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.toolkits.graph.Block;
import soot.toolkits.graph.PseudoTopologicalOrderer;
import soot.util.Chain;

import droidsafe.analyses.GeoPTA;

/**
 * Information Flow Analysis
 */

public class InformationFlowAnalysis {
    public static InformationFlowAnalysis v() {
        return v;
    }

    public static void run() {
        v = new InformationFlowAnalysis(InterproceduralControlFlowGraph.v());
    }

    public States getFlowFromTo(Block from, Block to) {
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

    private InterproceduralControlFlowGraph controlFlowGraph;
    private CallGraph callGraph;

    private Map<Block, Map<Block, States>> fromToStates;
    private Map<Block, States> mergeStates;

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
        worklist = new Worklist();
        for (Block head : controlFlowGraph.getHeads()) {
            SootMethod tgt = head.getBody().getMethod();
            List<Block> preds = controlFlowGraph.getPredsOf(head);
            if (preds.size() == 0) {
                States states = new States();
                states.put(new Edge(null, null, tgt, Kind.INVALID), new FrameRootsHeapStatics());
                fromToStates.get(null).put(head,  states);
            } else {
                for (Block pred : preds) {
                    States states = new States();
                    states.put(new Edge(pred.getBody().getMethod(), pred.getTail(), tgt, Kind.INVALID), new FrameRootsHeapStatics());
                    fromToStates.get(pred).put(head, states);
                }
            }
            worklist.add(head);
        }
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
            public void caseAssignStmt(final AssignStmt stmt) {
                setResult(execute(stmt, inStates));
            }

            public void caseIdentityStmt(IdentityStmt stmt) {
                setResult(execute(stmt, inStates));
            }

            public void caseInvokeStmt(InvokeStmt stmt) {
                // invoke_stmt = invoke_expr;
                execute(stmt, stmt.getInvokeExpr(), inStates);
            }

            public void caseReturnStmt(ReturnStmt stmt) {
                execute(stmt, inStates);
            }

            public void caseReturnVoidStmt(ReturnVoidStmt stmt) {
                execute(stmt, inStates);
            }

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
          public void caseArrayRef(ArrayRef arrayRef) {
              // variable "=" array_ref
              setResult(execute(stmt, variable, arrayRef, inStates));
          }

          // rvalue = ... | constant | ...
          // constant = double_constant | float_constant | int_constant | long_constant | string_constant | null_constant | class_constant;
          public void caseConstant(Constant constant) {
              // varaible "=" constant
              setResult(inStates);
          }

          // rvalue = ... | expr | ...;
          // expr = binop_expr | ...;
          // binop_expr = add_expr | and_expr | cmp_expr | cmpg_expr | cmpl_expr | div_expr | eq_expr | ge_expr | gt_expr | le_expr | lt_expr | mul_expr | ne_expr | or_expr | rem_expr | shl_expr | shr_expr | sub_expr | ushr_expr | xor_expr;
          public void caseBinopExpr(BinopExpr binopExpr) {
              // variable "=" binop_expr
              setResult(execute(stmt, variable, binopExpr, inStates));
          }

          // rvalue = ... | expr | ...;
          // expr = ... | cast_expr | ...;
          public void caseCastExpr(CastExpr castExpr) {
              // variable "=" cast_expr
              setResult(execute(stmt, variable, castExpr, inStates));
          }

          // rvalue = ... | expr | ...;
          // expr = ... | instance_of_expr | ...;
          public void caseInstanceOfExpr(InstanceOfExpr instanceOfExpr) {
              // variable "=" instance_of_expr
              setResult(execute(stmt, variable, instanceOfExpr, inStates));
          }

          // rvalue = ... | expr | ...;
          // expr = ... | invoke_expr | ...;
          // invoke_expr = interface_invoke_expr | special_invoke_expr | static_invoke_expr | virtual_invoke_expr;
          public void caseInvokeExpr(InvokeExpr invokeExpr) {
              // variable "=" invoke_expr
              execute(stmt, variable, invokeExpr, inStates);
          }

          // rvalue = ... | expr | ...;
          // expr = ... | new_array_expr | ...;
          public void caseNewArrayExpr(NewArrayExpr newArrayExpr) {
              // variable "=" new_array_expr
              setResult(execute(stmt, variable, newArrayExpr, inStates));
          }

          // rvalue = ... | expr | ...;
          // expr = ... | new_expr | ...;
          public void caseNewExpr(NewExpr newExpr) {
              // variable "=" new_expr
              setResult(execute(stmt, variable, newExpr, inStates));
          }

          // rvalue = ... | expr | ...;
          // expr = ... | new_multi_array_expr | ...;
          public void caseNewMultiArrayExpr(NewMultiArrayExpr newMultiArrayExpr) {
              setResult(execute(stmt, variable, newMultiArrayExpr, inStates));
          }

          // rvalue = ... | expr | ...;
          // expr = ... | unop_expr;
          // unop_expr = length_expr | neg_expr;
          public void caseUnopExpr(UnopExpr unopExpr) {
              setResult(execute(stmt, variable, unopExpr, inStates));
          }

          // rvalue = ... | instance_field_ref | ...;
          public void caseInstanceFieldRef(InstanceFieldRef instanceFieldRef) {
              // variable "=" instance_field_ref
              setResult(execute(stmt, variable, instanceFieldRef, inStates));
          }

          // rvalue = ... | local | ...;
          public void caseLocal(Local local) {
              // variable "=" local
              setResult(execute(stmt, variable, local, inStates));
          }

          // rvalue = ... | static_field_ref;
          public void caseStaticFieldRef (StaticFieldRef staticFieldRef) {
              // variable "=" static_field_ref
              setResult(execute(stmt, variable, staticFieldRef, inStates));
          }
      };
      rValue.apply(rValueSwitch);
      return (States)rValueSwitch.getResult();
  }

    // identity_stmt
    private States execute(final IdentityStmt stmt, final States inStates) {
        // identity_stmt = local ":=" identity_value;
        final Local local = (Local)stmt.getLeftOp();
        IdentityRef identityValue = (IdentityRef)stmt.getRightOp();
        // identity_value = caught_exception_ref | parameter_ref | this_ref;
        MyAbstractIdentityValueSwitch identityValueSwitch = new MyAbstractIdentityValueSwitch() {
            // identity_value = caught_exception_ref | ...;
            public void caseCaughtExceptionRef(CaughtExceptionRef caughtExceptionRef) {
                // XXX
                /* do nothing */
            }

            // identity_value = ... | parameter_ref | ...;
            public void caseParameterRef(ParameterRef parameterRef) {
                setResult(execute(stmt, local, parameterRef, inStates));
            }

            // identity_value = ... | this_ref;
            public void caseThisRef(ThisRef thisRef) {
                setResult(execute(stmt, local, thisRef, inStates));
            }
        };
        identityValue.apply(identityValueSwitch);
        return (States)identityValueSwitch.getResult();
    }

    // stmt = ... | return_stmt | ...;
    private void execute(final ReturnStmt stmt, final States inStates) {
        // return_stmt = "return" immediate;
        Block block = controlFlowGraph.unitToBlock.get(stmt);
        final SootMethod callee = block.getBody().getMethod();
        for (Block fallThrough : controlFlowGraph.getSuccsOf(block)) {
            // XXX: skip "$r0 := @caughtexception"
            if (!InterproceduralControlFlowGraph.containsCaughtExceptionRef(fallThrough.getHead())) {
                final SootMethod caller = fallThrough.getBody().getMethod();
                Block callBlock = controlFlowGraph.getPrecedingCallBlock(fallThrough, caller);
                Unit callStmt = callBlock.getTail();
                final FrameRootsHeapStatics inFrameRootsHeapStatics = inStates.get(callGraph.findEdge(callStmt, callee));
                FrameRootsHeapStatics outFrameRootsHeapStatics;
                if (callStmt instanceof AssignStmt) {
                    final AssignStmt assignStmt = (AssignStmt)callStmt;
                    final Set<MyValue> values = evaluate((Immediate)stmt.getOp(), inStates.get(new Edge(caller, assignStmt, callee)).frame);
                    // variable = array_ref | instance_field_ref | static_field_ref | local;
                    Value variable = assignStmt.getLeftOp();
                    MyAbstractVariableSwitch variableSwitch = new MyAbstractVariableSwitch() {
                        // variable = array_ref | ...;
                        public void caseArrayRef(ArrayRef arrayRef) {
                            // TODO
                            throw new UnsupportedOperationException(stmt.toString());
                        }

                        // variable = ... | instance_field_ref | ...;
                        public void caseInstanceFieldRef(InstanceFieldRef lInstanceFieldRef) {
                            // TODO
                            throw new UnsupportedOperationException(stmt.toString());
                        }

                        // variable = ... | static_field_ref | ...;
                        public void caseStaticFieldRef(StaticFieldRef lStaticFieldRef) {
                            // TODO
                            throw new UnsupportedOperationException(stmt.toString());
                        }

                        // variable = ... | local;
                        public void caseLocal(final Local local) {
                            Frame frame = new Frame();
                            frame.put(local, values);
                            Set<Address> roots = new HashSet<Address>(inFrameRootsHeapStatics.roots);
                            roots.addAll(inFrameRootsHeapStatics.statics.roots());
                            setResult(new FrameRootsHeapStatics(frame, new HashSet<Address>(), inFrameRootsHeapStatics.heap.gc(roots), inFrameRootsHeapStatics.statics));
                        }
                    };
                    variable.apply(variableSwitch);
                    outFrameRootsHeapStatics = (FrameRootsHeapStatics)variableSwitch.getResult();
                } else {
                    Set<Address> roots = new HashSet<Address>(inFrameRootsHeapStatics.roots);
                    roots.addAll(inFrameRootsHeapStatics.statics.roots());
                    outFrameRootsHeapStatics = new FrameRootsHeapStatics(new Frame(), new HashSet<Address>(), inFrameRootsHeapStatics.heap.gc(roots), inFrameRootsHeapStatics.statics);
                }
                States outStates = new States();
                for (Edge context : fromToStates.get(callBlock).get(fallThrough).keySet()) {
                    outStates.put(context, outFrameRootsHeapStatics);
                }
                if (!outStates.equals(fromToStates.get(block).get(fallThrough))) {
                    fromToStates.get(block).put(fallThrough, outStates);
                    worklist.add(fallThrough);
                }
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
            if (!InterproceduralControlFlowGraph.containsCaughtExceptionRef(fallThrough.getHead())) {
                SootMethod caller = fallThrough.getBody().getMethod();
                Block callBlock = controlFlowGraph.getPrecedingCallBlock(fallThrough, caller);
                Unit callStmt = callBlock.getTail();
                FrameRootsHeapStatics inFrameRootsHeapStatics = inStates.get(callGraph.findEdge(callStmt, callee));
                Set<Address> roots = new HashSet<Address>(inFrameRootsHeapStatics.roots);
                roots.addAll(inFrameRootsHeapStatics.statics.roots());
                FrameRootsHeapStatics outFrameRootsHeapStatics = new FrameRootsHeapStatics(new Frame(), new HashSet<Address>(), inFrameRootsHeapStatics.heap.gc(roots), inFrameRootsHeapStatics.statics);
                States outStates = new States();
                for (Edge context : fromToStates.get(callBlock).get(fallThrough).keySet()) {
                    outStates.put(context, outFrameRootsHeapStatics);
                }
                if (!outStates.equals(fromToStates.get(block).get(fallThrough))) {
                    fromToStates.get(block).put(fallThrough, outStates);
                    worklist.add(fallThrough);
                }
            }
        }
    }

    // assign_stmt = variable "=" array_ref
    private States execute(final AssignStmt stmt, Value variable, ArrayRef arrayRef, final States inStates) {
        // array_ref = immediate "[" immediate "]";
        final States outStates = new States();
        Immediate immediate = (Immediate)arrayRef.getBase();
        for (final Map.Entry<Edge, FrameRootsHeapStatics> contextFrameRootsHeapStatics : inStates.entrySet()) {
            final FrameRootsHeapStatics inFrameRootsHeapStatics = contextFrameRootsHeapStatics.getValue();
            Set<MyValue> addresses = evaluate(immediate, inFrameRootsHeapStatics.frame);
            final Set<MyValue> values = new HashSet<MyValue>();
            for (MyValue address : addresses) {
                if (address instanceof Address) {
                    values.addAll(inFrameRootsHeapStatics.heap.arrays.get((Address)address));
                }
            }
            // variable = array_ref | instance_field_ref | static_field_ref | local;
            variable.apply(new MyAbstractVariableSwitch() {
                // variable = array_ref | ...;
                public void caseArrayRef(ArrayRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | instance_field_ref | ...;
                public void caseInstanceFieldRef(InstanceFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | static_field_ref | ...;
                public void caseStaticFieldRef(StaticFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | local;
                public void caseLocal(Local local) {
                    Frame frame = new Frame(inFrameRootsHeapStatics.frame, inFrameRootsHeapStatics.frame.params);
                    frame.put(local, values);
                    outStates.put(contextFrameRootsHeapStatics.getKey(), new FrameRootsHeapStatics(frame, inFrameRootsHeapStatics.roots, inFrameRootsHeapStatics.heap, inFrameRootsHeapStatics.statics));
                }
            });
        }
        return outStates;
    }

    // assign_stmt = variable "=" binop_expr
    private States execute(final AssignStmt stmt, Value variable, BinopExpr binopExpr, States inStates) {
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
        final States outStates = new States();
        Immediate[] immediates = {(Immediate)binopExpr.getOp1(), (Immediate)binopExpr.getOp2()};
        for (final Map.Entry<Edge, FrameRootsHeapStatics> contextFrameRootsHeapStatic : inStates.entrySet()) {
            final FrameRootsHeapStatics inFrameRootsHeapStatics = contextFrameRootsHeapStatic.getValue();
            final Set<MyValue> values = evaluate(immediates, inFrameRootsHeapStatics.frame);
            // variable = array_ref | instance_field_ref | static_field_ref | local;
            variable.apply(new MyAbstractVariableSwitch() {
                // variable = array_ref | ...;
                public void caseArrayRef(ArrayRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }
                
                // variable = ... | instance_field_ref | ...;
                public void caseInstanceFieldRef(InstanceFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | static_field_ref | ...;
                public void caseStaticFieldRef(StaticFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }
                
                // variable = ... | local;
                public void caseLocal(Local local) {
                    Frame frame = new Frame(inFrameRootsHeapStatics.frame, inFrameRootsHeapStatics.frame.params);
                    frame.put(local, values);
                    outStates.put(contextFrameRootsHeapStatic.getKey(), new FrameRootsHeapStatics(frame, inFrameRootsHeapStatics.roots, inFrameRootsHeapStatics.heap, inFrameRootsHeapStatics.statics));
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
            public void caseConstant(Constant constant) {
                // local "=" "(" type ")" constant
                // TODO: we may be able to do better by considering "type".
                setResult(inStates);
            }
            
            // immediate = ... | local;
            public void caseLocal(final Local rLocal) {
                // local "=" "(" type ")" local
                // TODO: we may be able to do better by considering "type".
                setResult(execute(stmt, variable, rLocal, inStates));
            }
        };
        immediate.apply(immediateSwitch);
        return (States)immediateSwitch.getResult();
    }

    // assigin_stmt = variable "=" instance_of_expr
    private States execute(final AssignStmt stmt, final Value variable, InstanceOfExpr instanceOfExpr, final States inStates) {
        // instance_of_expr = immediate "instanceof" ref_type;
        final States outStates = new States();
        Immediate immediate = (Immediate)instanceOfExpr.getOp();
        for (final Map.Entry<Edge, FrameRootsHeapStatics> contextFrameRootsHeapStatic : inStates.entrySet()) {
            final FrameRootsHeapStatics inFrameRootsHeapStatics = contextFrameRootsHeapStatic.getValue();
            final Set<MyValue> values = evaluate(immediate, inFrameRootsHeapStatics.frame);
            // variable = array_ref | instance_field_ref | static_field_ref | local;
            variable.apply(new MyAbstractVariableSwitch() {
                // variable = array_ref | ...;
                public void caseArrayRef(ArrayRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | instance_field_ref | ...;
                public void caseInstanceFieldRef(InstanceFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | static_field_ref | ...;
                public void caseStaticFieldRef(StaticFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | local;
                public void caseLocal(Local local) {
                    Frame frame = new Frame(inFrameRootsHeapStatics.frame, inFrameRootsHeapStatics.frame.params);
                    frame.put(local, values);
                    outStates.put(contextFrameRootsHeapStatic.getKey(), new FrameRootsHeapStatics(frame, inFrameRootsHeapStatics.roots, inFrameRootsHeapStatics.heap, inFrameRootsHeapStatics.statics));
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
            public void caseArrayRef(ArrayRef v) {
                execute(stmt, invokeExpr, inStates);
            }
            
            // variable = ... | instance_field_ref | ...;
            public void caseInstanceFieldRef(InstanceFieldRef v) {
                execute(stmt, invokeExpr, inStates);
            }
            
            // variable = ... | static_field_ref | ...;
            public void caseStaticFieldRef(StaticFieldRef staticFieldRef) {
                // static_field_ref "=" invoke_expr
                final List<Set<MyValue>> args = evaluateArgs(invokeExpr.getArgs(), inStates);
                SootField field = staticFieldRef.getField();
                SootClass klass = field.getDeclaringClass();
                Block block = controlFlowGraph.unitToBlock.get(stmt);
                SootMethod caller = block.getBody().getMethod();
                for (Block succ : controlFlowGraph.getSuccsOf(block)) {
                    // XXX: skip "$r0 := @caughtexception"
                    if (!InterproceduralControlFlowGraph.containsCaughtExceptionRef(succ.getHead())) {
                        SootMethod callee = succ.getBody().getMethod();
                        States outStates;
                        if (!caller.equals(callee)) {
                            outStates = makeCalleeStates(stmt, callee, args, inStates);
                        } else {
                            if (controlFlowGraph.getPredsOf(succ).size() > 1) {
                                outStates = new States();
                                for (Map.Entry<Edge, FrameRootsHeapStatics> contextFrameRootsHeapStatic : inStates.entrySet()) {
                                    FrameRootsHeapStatics inFrameRootsHeapStatics = contextFrameRootsHeapStatic.getValue();
                                    Statics statics = new Statics(inFrameRootsHeapStatics.statics);
                                    statics.remove(klass, field);
                                    outStates.put(contextFrameRootsHeapStatic.getKey(), new FrameRootsHeapStatics(inFrameRootsHeapStatics.frame, inFrameRootsHeapStatics.roots, inFrameRootsHeapStatics.heap, statics));
                                }
                            } else {
                                outStates = inStates;
                            }
                        }
                        if (!outStates.equals(fromToStates.get(block).get(succ))) {
                            fromToStates.get(block).put(succ, outStates);
                            worklist.add(succ);
                        }
                    }
                }
            }
            
            // variable = ... | local;
            public void caseLocal(Local local) {
                // local "=" invoke_expr
                final List<Set<MyValue>> args = evaluateArgs(invokeExpr.getArgs(), inStates);
                Block block = controlFlowGraph.unitToBlock.get(stmt);
                SootMethod caller = block.getBody().getMethod();
                for (Block succ : controlFlowGraph.getSuccsOf(block)) {
                    // XXX: skip "$r0 := @caughtexception"
                    if (!InterproceduralControlFlowGraph.containsCaughtExceptionRef(succ.getHead())) {
                        SootMethod callee = succ.getBody().getMethod();
                        States outStates;
                        if (!caller.equals(callee)) {
                            outStates = makeCalleeStates(stmt, callee, args, inStates);
                        } else {
                            if (controlFlowGraph.getPredsOf(succ).size() > 1) {
                                outStates = new States();
                                for (Map.Entry<Edge, FrameRootsHeapStatics> contextFrameRootsHeapStatic : inStates.entrySet()) {
                                    FrameRootsHeapStatics inFrameRootsHeapStatics = contextFrameRootsHeapStatic.getValue();
                                    Frame frame = new Frame(inFrameRootsHeapStatics.frame, inFrameRootsHeapStatics.frame.params);
                                    frame.remove(local);
                                    outStates.put(contextFrameRootsHeapStatic.getKey(), new FrameRootsHeapStatics(frame, inFrameRootsHeapStatics.roots, inFrameRootsHeapStatics.heap, inFrameRootsHeapStatics.statics));
                                }
                            } else {
                                outStates = inStates;
                            }
                        }
                        if (!outStates.equals(fromToStates.get(block).get(succ))) {
                            fromToStates.get(block).put(succ, outStates);
                            worklist.add(succ);
                        }
                    }
                }
            }
        });
    }

    // assign_stmt = variable "=" new_array_expr
    private States execute(final AssignStmt stmt, Value variable, NewArrayExpr newArrayExpr, States inStates) {
        final States outStates;
        AllocNode allocNode = GeoPTA.v().getAllocNode(newArrayExpr);
        if (allocNode != null) {
            outStates = new States();
            final Set<MyValue> values = new HashSet<MyValue>();
            Address address = Address.v(allocNode);
            values.add(address);
            for (final Map.Entry<Edge, FrameRootsHeapStatics> contextFrameRootsHeapStatic : inStates.entrySet()) {
                final FrameRootsHeapStatics inFrameRootsHeapStatics = contextFrameRootsHeapStatic.getValue();
                // TODO: Do I need to initialize the array with its default value according to its type?

                // variable = array_ref | instance_field_ref | static_field_ref | local;
                variable.apply(new MyAbstractVariableSwitch() {
                    // variable = array_ref | ...;
                    public void caseArrayRef(ArrayRef v) {
                        // TODO
                        throw new UnsupportedOperationException(stmt.toString());
                    }
                    
                    // variable = ... | instance_field_ref | ...;
                    public void caseInstanceFieldRef(InstanceFieldRef v) {
                        // TODO
                        throw new UnsupportedOperationException(stmt.toString());
                    }

                    // variable = ... | static_field_ref | ...;
                    public void caseStaticFieldRef(StaticFieldRef v) {
                        // TODO
                        throw new UnsupportedOperationException(stmt.toString());
                    }
                    
                    // variable = ... | local;
                    public void caseLocal(Local local) {
                        Frame frame = new Frame(inFrameRootsHeapStatics.frame, inFrameRootsHeapStatics.frame.params);
                        frame.put(local, values);
                        outStates.put(contextFrameRootsHeapStatic.getKey(), new FrameRootsHeapStatics(frame, inFrameRootsHeapStatics.roots, inFrameRootsHeapStatics.heap, inFrameRootsHeapStatics.statics));
                    }
                });
            }
        } else {
            assert controlFlowGraph.unitToBlock.get(stmt).getBody().getMethod().getDeclaringClass().equals(Scene.v().getSootClass("edu.mit.csail.droidsafe.DroidSafeCalls"));
            outStates = inStates;
        }
        return outStates;
    }

    // assign_stmt = variable "=" new_expr
    private States execute(final AssignStmt stmt, Value variable, NewExpr newExpr, States inStates) {
        final States outStates;
        final AllocNode allocNode = GeoPTA.v().getAllocNode(newExpr);
        if (allocNode != null) {
            outStates = new States();
            final Set<MyValue> values = new HashSet<MyValue>();
            final Address address = Address.v(allocNode);
            values.add(address);
            final Chain<SootField> fields = newExpr.getBaseType().getSootClass().getFields();
            for (final Map.Entry<Edge, FrameRootsHeapStatics> contextFrameRootsHeapStatic : inStates.entrySet()) {
                final Edge context = contextFrameRootsHeapStatic.getKey();
                final FrameRootsHeapStatics inFrameRootsHeapStatics = contextFrameRootsHeapStatic.getValue();
                // TODO: Do I need to initialize the object's fields with their default values according to their types?
                // variable = array_ref | instance_field_ref | static_field_ref | local;
                variable.apply(new MyAbstractVariableSwitch() {
                    // variable = array_ref | ...;
                    public void caseArrayRef(ArrayRef v) {
                        // TODO
                        throw new UnsupportedOperationException(stmt.toString());
                    }
                    
                    // variable = ... | instance_field_ref | ...;
                    public void caseInstanceFieldRef(InstanceFieldRef v) {
                        // TODO
                        throw new UnsupportedOperationException(stmt.toString());
                    }

                    // variable = ... | static_field_ref | ...;
                    public void caseStaticFieldRef(StaticFieldRef v) {
                        // TODO
                        throw new UnsupportedOperationException(stmt.toString());
                    }
                    
                    // variable = ... | local;
                    public void caseLocal(Local local) {
                        Frame frame = new Frame(inFrameRootsHeapStatics.frame, inFrameRootsHeapStatics.frame.params);
                        frame.put(local, values);
                        Heap heap = new Heap(inFrameRootsHeapStatics.heap, inFrameRootsHeapStatics.heap.arrays);
                        for (SootField field : fields) {
                            heap.instances.put(address, field, InjectedSourceFlows.v().getInjectedFlows(allocNode, field, context));
                        }
                        outStates.put(contextFrameRootsHeapStatic.getKey(), new FrameRootsHeapStatics(frame, inFrameRootsHeapStatics.roots, heap, inFrameRootsHeapStatics.statics));
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
            outStates = new States();
            final Set<MyValue> values = new HashSet<MyValue>();
            Address address = Address.v(allocNode);
            values.add(address);
            for (final Map.Entry<Edge, FrameRootsHeapStatics> contextFrameRootsHeapStatic : inStates.entrySet()) {
                final FrameRootsHeapStatics inFrameRootsHeapStatics = contextFrameRootsHeapStatic.getValue();
                // TODO: Do I need to initialize the array with its default value according to its type?

                // variable = array_ref | instance_field_ref | static_field_ref | local;
                variable.apply(new MyAbstractVariableSwitch() {
                    // variable = array_ref | ...;
                    public void caseArrayRef(ArrayRef v) {
                        // TODO
                        throw new UnsupportedOperationException(stmt.toString());
                    }

                    // variable = ... | instance_field_ref | ...;
                    public void caseInstanceFieldRef(InstanceFieldRef v) {
                        // TODO
                        throw new UnsupportedOperationException(stmt.toString());
                    }

                    // variable = ... | static_field_ref | ...;
                    public void caseStaticFieldRef(StaticFieldRef v) {
                        // TODO
                        throw new UnsupportedOperationException(stmt.toString());
                    }

                    // variable = ... | local;
                    public void caseLocal(Local local) {
                        Frame frame = new Frame(inFrameRootsHeapStatics.frame, inFrameRootsHeapStatics.frame.params);
                        frame.put(local, values);
                        outStates.put(contextFrameRootsHeapStatic.getKey(), new FrameRootsHeapStatics(frame, inFrameRootsHeapStatics.roots, inFrameRootsHeapStatics.heap, inFrameRootsHeapStatics.statics));
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
        // unop_expr = length_expr | neg_expr;
        // length_expr = "length" immediate;
        // neg_expr = "-" immediate;
        final States outStates = new States();
        Immediate immediate = (Immediate)unopExpr.getOp();
        for (final Map.Entry<Edge, FrameRootsHeapStatics> contextFrameRootsHeapStatic : inStates.entrySet()) {
            final FrameRootsHeapStatics inFrameRootsHeapStatics = contextFrameRootsHeapStatic.getValue();
            final Set<MyValue> values = evaluate(immediate, inFrameRootsHeapStatics.frame);
            // variable = array_ref | instance_field_ref | static_field_ref | local;
            variable.apply(new MyAbstractVariableSwitch() {
                // variable = array_ref | ...;
                public void caseArrayRef(ArrayRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | instance_field_ref | ...;
                public void caseInstanceFieldRef(InstanceFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | static_field_ref | ...;
                public void caseStaticFieldRef(StaticFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | local;
                public void caseLocal(Local local) {
                    Frame frame = new Frame(inFrameRootsHeapStatics.frame, inFrameRootsHeapStatics.frame.params);
                    frame.put(local, values);
                    outStates.put(contextFrameRootsHeapStatic.getKey(), new FrameRootsHeapStatics(frame, inFrameRootsHeapStatics.roots, inFrameRootsHeapStatics.heap, inFrameRootsHeapStatics.statics));
                }
            });
        }
        return outStates;
    }

    // assign_stmt = variable "=" instance_field_ref
    private States execute(final AssignStmt stmt, Value variable, InstanceFieldRef instanceFieldRef, States inStates) {
        final States outStates = new States();
        Local base = (Local)instanceFieldRef.getBase();
        SootField field = instanceFieldRef.getField();
        for (final Map.Entry<Edge, FrameRootsHeapStatics> contextFrameRootsHeapStatic : inStates.entrySet()) {
            final FrameRootsHeapStatics inFrameRootsHeapStatics = contextFrameRootsHeapStatic.getValue();
            final Set<MyValue> values = new HashSet<MyValue>();
            for (MyValue instance : inFrameRootsHeapStatics.frame.get(base)) {
                if (instance instanceof Address) {
                    values.addAll(inFrameRootsHeapStatics.heap.instances.get((Address)instance, field));
                }
            }
            // variable = array_ref | instance_field_ref | static_field_ref | local;
            variable.apply(new MyAbstractVariableSwitch() {
                // variable = array_ref | ...;
                public void caseArrayRef(ArrayRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }
                
                // variable = ... | instance_field_ref | ...;
                public void caseInstanceFieldRef(InstanceFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | static_field_ref | ...;
                public void caseStaticFieldRef(StaticFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }
                
                // variable = ... | local;
                public void caseLocal(Local local) {
                    Frame frame = new Frame(inFrameRootsHeapStatics.frame, inFrameRootsHeapStatics.frame.params);
                    frame.put(local, values);
                    outStates.put(contextFrameRootsHeapStatic.getKey(), new FrameRootsHeapStatics(frame, inFrameRootsHeapStatics.roots, inFrameRootsHeapStatics.heap, inFrameRootsHeapStatics.statics));
                }
            });
        }
        return outStates;
    }

    // assign_stmt = variable "=" local
    private States execute(final AssignStmt stmt, Value variable, final Local local, final States inStates) {
        final States outStates = new States();
        for (final Map.Entry<Edge, FrameRootsHeapStatics> contextFrameRootsHeapStatic : inStates.entrySet()) {
            final FrameRootsHeapStatics inFrameRootsHeapStatics = contextFrameRootsHeapStatic.getValue();
            final Set<MyValue> inValues = inFrameRootsHeapStatics.frame.get(local);
            // variable = array_ref | instance_field_ref | static_field_ref | local;
            variable.apply(new MyAbstractVariableSwitch() {
                // variable = array_ref | ...;
                public void caseArrayRef(ArrayRef arrayRef) {
                    Arrays arrays = new Arrays(inFrameRootsHeapStatics.heap.arrays);
                    for (MyValue addr : inFrameRootsHeapStatics.frame.get((Local)arrayRef.getBase())) {
                        if (addr instanceof Address) {
                            Address address = (Address)addr;
                            Set<MyValue> outValues = new HashSet<MyValue>(inFrameRootsHeapStatics.heap.arrays.get(address));
                            outValues.addAll(inValues);
                            arrays.put(address, outValues);
                        }
                    }
                    outStates.put(contextFrameRootsHeapStatic.getKey(), new FrameRootsHeapStatics(inFrameRootsHeapStatics.frame, inFrameRootsHeapStatics.roots, new Heap(inFrameRootsHeapStatics.heap.instances, arrays), inFrameRootsHeapStatics.statics));
                }

                // variable = ... | instance_field_ref | ...;
                public void caseInstanceFieldRef(InstanceFieldRef instanceFieldRef) {
                    // instance_field_ref "=" local
                    SootField field = instanceFieldRef.getField();
                    Instances instances = new Instances(inFrameRootsHeapStatics.heap.instances);
                    for (MyValue addr : inFrameRootsHeapStatics.frame.get((Local)instanceFieldRef.getBase())) {
                        if (addr instanceof Address) {
                            Address address = (Address)addr;
                            Set<MyValue> outValues = new HashSet<MyValue>(inFrameRootsHeapStatics.heap.instances.get(address, field));
                            outValues.addAll(inValues);
                            instances.put(address, field, outValues);
                        }
                    }
                    outStates.put(contextFrameRootsHeapStatic.getKey(), new FrameRootsHeapStatics(inFrameRootsHeapStatics.frame, inFrameRootsHeapStatics.roots, new Heap(instances, inFrameRootsHeapStatics.heap.arrays), inFrameRootsHeapStatics.statics));
                }

                // variable = ... | static_field_ref | ...;
                public void caseStaticFieldRef(StaticFieldRef staticFieldRef) {
                    SootField field = staticFieldRef.getField();
                    SootClass klass = field.getDeclaringClass();
                    for (Map.Entry<Edge, FrameRootsHeapStatics> contextFrameRootsHeapStatic : inStates.entrySet()) {
                        FrameRootsHeapStatics inFrameRootsHeapStatics = contextFrameRootsHeapStatic.getValue();
                        Statics statics = new Statics(inFrameRootsHeapStatics.statics);
                        statics.put(klass, field, inValues);
                        outStates.put(contextFrameRootsHeapStatic.getKey(), new FrameRootsHeapStatics(inFrameRootsHeapStatics.frame, inFrameRootsHeapStatics.roots, inFrameRootsHeapStatics.heap, statics));
                    }
                }
                
                // variable = ... | local;
                public void caseLocal(Local local) {
                    // local "=" local
                    for (Map.Entry<Edge, FrameRootsHeapStatics> contextFrameRootsHeapStatic : inStates.entrySet()) {
                        FrameRootsHeapStatics inFrameRootsHeapStatics = contextFrameRootsHeapStatic.getValue();
                        Frame frame = new Frame(inFrameRootsHeapStatics.frame, inFrameRootsHeapStatics.frame.params);
                        frame.put(local, inValues);
                        outStates.put(contextFrameRootsHeapStatic.getKey(), new FrameRootsHeapStatics(frame, inFrameRootsHeapStatics.roots, inFrameRootsHeapStatics.heap, inFrameRootsHeapStatics.statics));
                    }
                }
            });
        }
        return outStates;
    }

    // assign_stmt = variable "=" static_field_ref
    private States execute(final AssignStmt stmt, Value variable, StaticFieldRef staticFieldRef, States inStates) {
        final States outStates = new States();
        SootField field = staticFieldRef.getField();
        SootClass klass = field.getDeclaringClass();
        for (Map.Entry<Edge, FrameRootsHeapStatics> contextFrameRootsHeapStatic : inStates.entrySet()) {
            final Edge context = contextFrameRootsHeapStatic.getKey();
            final FrameRootsHeapStatics inFrameRootsHeapStatics = contextFrameRootsHeapStatic.getValue();
            final Statics statics = inFrameRootsHeapStatics.statics;
            final Set<MyValue> values = statics.get(klass, field);
            // variable = array_ref | instance_field_ref | static_field_ref | local;
            variable.apply(new MyAbstractVariableSwitch() {
                // variable = array_ref | ...;
                public void caseArrayRef(ArrayRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }
                
                // variable = ... | instance_field_ref | ...;
                public void caseInstanceFieldRef(InstanceFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }

                // variable = ... | static_field_ref | ...;
                public void caseStaticFieldRef(StaticFieldRef v) {
                    // TODO
                    throw new UnsupportedOperationException(stmt.toString());
                }
                
                // variable = ... | local;
                public void caseLocal(Local local) {
                    Frame frame = new Frame(inFrameRootsHeapStatics.frame, inFrameRootsHeapStatics.frame.params);
                    frame.put(local, values);
                    outStates.put(context, new FrameRootsHeapStatics(frame, inFrameRootsHeapStatics.roots, inFrameRootsHeapStatics.heap, statics));
                }
            });
        }
        return outStates;
    }

    // identity_stmt = local ":=" parameter_ref
    private States execute(IdentityStmt stmt, Local local, ParameterRef parameterRef, States inStates) {
        States outStates = new States();
        for (Map.Entry<Edge, FrameRootsHeapStatics> contextFrameRootsHeapStatic : inStates.entrySet()) {
            FrameRootsHeapStatics inFrameRootsHeapStatics = contextFrameRootsHeapStatic.getValue();
            Frame frame = new Frame(inFrameRootsHeapStatics.frame, inFrameRootsHeapStatics.frame.params);
            frame.put(local, inFrameRootsHeapStatics.frame.get(parameterRef));
            outStates.put(contextFrameRootsHeapStatic.getKey(), new FrameRootsHeapStatics(frame, inFrameRootsHeapStatics.roots, inFrameRootsHeapStatics.heap, inFrameRootsHeapStatics.statics));
        }
        return outStates;
    }

    // identity_stmt = local ":=" this_ref
    private States execute(IdentityStmt stmt, Local local, ThisRef thisRef, States inStates) {
        States outStates = new States();
        for (Map.Entry<Edge, FrameRootsHeapStatics> contextFrameRootsHeapStatic : inStates.entrySet()) {
            Edge context = contextFrameRootsHeapStatic.getKey();
            FrameRootsHeapStatics inFrameRootsHeapStatics = contextFrameRootsHeapStatic.getValue();
            Frame frame = new Frame(inFrameRootsHeapStatics.frame, inFrameRootsHeapStatics.frame.params);
            Set<MyValue> values = new HashSet<MyValue>();
            for (AllocNode allocNode : GeoPTA.v().getPTSet(local, context)) {
                values.add(Address.v(allocNode));
            }
            frame.put(local, values);
            outStates.put(context, new FrameRootsHeapStatics(frame, inFrameRootsHeapStatics.roots, inFrameRootsHeapStatics.heap, inFrameRootsHeapStatics.statics));
        }
        return outStates;
    }

    // stmt = ... | assign_stmt | ... ;
    // assign_stmt = variable "=" rvalue;
    // variable = array_ref | instance_field_ref;
    // rvalue = ... | expr | ...;
    // expr = ... | invoke_expr | ...;

    // stmt = ... | invoke_stmt | ...;
    // invoke_stmt = invoke_expr;
    private void execute(Stmt stmt, InvokeExpr invokeExpr, final States inStates) {
        assert(stmt.containsInvokeExpr());
        // invoke_expr = interface_invoke_expr | special _invoke_expr | static_invoke_expr | virtual_invoke_expr;
        // interface_invoke_expr = "interfaceinvoke" immediate ".[" + method_signature "]" "(" immediate_list ")"
        // special_invoke_expr = "specialinvoke" immediate ".[" method_signature "]" "(" immediate_list ")";
        // static_invoke_expr = "staticinvoke" "[" method_signature "]" "(" immediate_list ")";
        // virtual_invoke_expr = "virtualinvoke" immediate ".[" method_signamter "]" "(" immediate_list ")";
        final List<Set<MyValue>> args = evaluateArgs(invokeExpr.getArgs(), inStates);
        Block block = controlFlowGraph.unitToBlock.get(stmt);
        SootMethod caller = block.getBody().getMethod();
        for (Block succ : controlFlowGraph.getSuccsOf(block)) {
            // XXX: skip "$r0 := @caughtexception"
            if (!InterproceduralControlFlowGraph.containsCaughtExceptionRef(succ.getHead())) {
                SootMethod callee = succ.getBody().getMethod();
                States outStates;
                if (!caller.equals(callee)) {
                    outStates = makeCalleeStates(stmt, callee, args, inStates);
                } else {
                    outStates = inStates;
                }
                if (!outStates.equals(fromToStates.get(block).get(succ))) {
                    fromToStates.get(block).put(succ, outStates);
                    worklist.add(succ);
                }
            }
        }
    }

    private Set<MyValue> evaluate(Immediate immediate, final Frame frame) {
        final Set<MyValue> values = new HashSet<MyValue>();
        // immediate = constant | local;
        immediate.apply(new MyAbstractImmediateSwitch() {
            // immediate = constant | ...;
            // constant = double_constant | float_constant | int_constant | long_constant | string_constant | null_constant | class_constant;
            public void caseConstant(Constant constant) {
                // do nothing
            }
    
            // immediate = ... | local;
            public void caseLocal(Local rLocal) {
                values.addAll(frame.get(rLocal));
            }
        });
        return values;
    }

    private Set<MyValue> evaluate(Immediate[] immediates, final Frame frame) {
        final Set<MyValue> values = new HashSet<MyValue>();
        for (Value immediate : immediates) {
            // immediate = constant | local;
            immediate.apply(new MyAbstractImmediateSwitch() {
                // immediate = constant | ...;
                // constant = double_constant | float_constant | int_constant | long_constant | string_constant | null_constant | class_constant;
                public void caseConstant(Constant constant) {
                    // do nothing
                }
    
                // immediate = ... | local;
                public void caseLocal(Local rLocal) {
                    values.addAll(frame.get(rLocal));
                }
            });
        }
        return values;
    }

    private List<Set<MyValue>> evaluateArgs(List<Value> immediates, final States states) {
        final List<Set<MyValue>> args = new ArrayList<Set<MyValue>>();
        for (Value immediate : immediates) {
            // immediate = constant | local;
            immediate.apply(new MyAbstractImmediateSwitch() {
                // immediate = constant | ...;
                // constant = double_constant | float_constant | int_constant | long_constant | string_constant | null_constant | class_constant;
                public void caseConstant(Constant constant) {
                    args.add(new HashSet<MyValue>());
                }
                
                // immediate = ... | local;
                public void caseLocal(Local local) {
                    Set<MyValue> values = new HashSet<MyValue>();
                    for (FrameRootsHeapStatics frameRootsHeapStatics : states.values()) {
                        values.addAll(frameRootsHeapStatics.frame.get(local));
                    }
                    args.add(values);
                }
            });
        }
        return args;
    }
    
    private States makeCalleeStates(Unit srcStmt, SootMethod tgtMethod, List<Set<MyValue>> args, States srcStates) {
        Frame frame = new Frame();
        int i = 0;
        for (Object type : tgtMethod.getParameterTypes()) {
            frame.put(new ParameterRef((Type)type, i), args.get(i));
            i++;
        }
        Set<Address> roots = new HashSet<Address>();
        Heap heap = new Heap();
        Statics statics = new Statics();
        for (FrameRootsHeapStatics frameRootsHeapStatics : srcStates.values()) {
            roots.addAll(frameRootsHeapStatics.roots);
            roots.addAll(frameRootsHeapStatics.frame.roots());
            heap = heap.merge(frameRootsHeapStatics.heap);
            statics = statics.merge(frameRootsHeapStatics.statics);
        }
        States tgtStates = new States();
        tgtStates.put(callGraph.findEdge(srcStmt, tgtMethod), new FrameRootsHeapStatics(frame, roots, heap, statics));
        return tgtStates;
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
                        states = states.subtract(new States()); // cut out empty mappings
                        CharSequenceTranslator translator = new LookupTranslator(new String[][] {{"\\l", "\\l"}}).with(StringEscapeUtils.ESCAPE_JAVA);
                        return translator.translate(states.toString()) + "\\l";
                    }
                });
        dotExporter.export(new BufferedWriter(new FileWriter(fileName)), jGraphT);
    }
}
