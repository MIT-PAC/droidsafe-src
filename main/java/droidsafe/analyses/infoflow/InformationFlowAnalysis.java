package droidsafe.analyses.infoflow;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
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
import soot.toolkits.graph.PseudoTopologicalOrderer;

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

    public States getFlowFromTo(Unit from, Unit to) {
        return fromToStates.get(from).get(to);
    }

    public static void exportDotGraph(Path path) throws IOException {
        exportDotGraph(InterproceduralControlFlowGraph.v().toJGraphT(), path);
    }

    public static void exportDotGraph(SootMethod method, Path path) throws IOException {
        exportDotGraph(InterproceduralControlFlowGraph.v().toJGraphT(method), path);
    }

    private static InformationFlowAnalysis v;

    private InterproceduralControlFlowGraph controlFlowGraph;
    private CallGraph callGraph;

    private Map<Unit, Map<Unit, States>> fromToStates;
    private Map<Unit, States> mergeStates;

    class Worklist {
        TreeSet<Unit> worklist;

        Worklist() {
            final Map<Unit, Integer> unitToRank = new HashMap<Unit, Integer>();
            int i = 1;
            Iterator<Unit> it = new PseudoTopologicalOrderer<Unit>().newList(controlFlowGraph, false).iterator();
            while (it.hasNext()) {
                unitToRank.put(it.next(), i);
                i++;
            }
            worklist = new TreeSet<Unit>(new Comparator<Unit>() {
                public int compare(Unit unit1, Unit unit2) {
                    return unitToRank.get(unit1) - unitToRank.get(unit2);
                }
            });
        }

        boolean add(Unit unit) {
            return worklist.add(unit);
        }

        boolean isEmpty() {
            return worklist.isEmpty();
        }

        Unit poll() {
            return worklist.pollFirst();
        }
    }

    private Worklist worklist;

    private final static Logger logger = LoggerFactory.getLogger(InformationFlowAnalysis.class);

    private InformationFlowAnalysis(InterproceduralControlFlowGraph controlFlowGraph) {
        this.controlFlowGraph = controlFlowGraph;
        callGraph = Scene.v().getCallGraph();

        fromToStates = new HashMap<Unit, Map<Unit, States>>();
        mergeStates = new HashMap<Unit, States>();
        fromToStates.put(null, new HashMap<Unit, States>());
        for (Unit curr : controlFlowGraph) {
            List<Unit> preds = controlFlowGraph.getPredsOf(curr);
            if (preds.size() > 1) {
                mergeStates.put(curr, new States());
            } else if (preds.size() == 0) {
                fromToStates.get(null).put(curr, new States());
            }
            fromToStates.put(curr, new HashMap<Unit, States>());
            List<Unit> succs = controlFlowGraph.getSuccsOf(curr);
            if (succs.size() > 0) {
                for (Unit succ : succs) {
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
            Unit curr = worklist.poll();
            States inStates = collectFlowBefore(curr);
            if (inStates != null) {
                States outStates = execute(curr, inStates);
                // fromToStates and worklist have been already updated if outStates == null.
                if (outStates != null) {
                    for (Unit succ : controlFlowGraph.getSuccsOf(curr)) {
                        // XXX: skip "$r0 := @caughtexception"
                        if (!InterproceduralControlFlowGraph.containsCaughtExceptionRef(succ)) {
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
        for (Unit head : controlFlowGraph.getHeads()) {
            SootMethod tgt = controlFlowGraph.unitToMethod.get(head);
            List<Unit> preds = controlFlowGraph.getPredsOf(head);
            if (preds.size() == 0) {
                States states = new States();
                states.put(new Edge(null, null, tgt, Kind.INVALID), new FrameHeapStatics());
                fromToStates.get(null).put(head,  states);
            } else {
                for (Unit pred : preds) {
                    States states = new States();
                    states.put(new Edge(controlFlowGraph.unitToMethod.get(pred), pred, tgt, Kind.INVALID), new FrameHeapStatics());
                    fromToStates.get(pred).put(head, states);
                }
            }
            worklist.add(head);
        }
    }

    private States collectFlowBefore(Unit curr) {
        States states;
        List<Unit> preds = controlFlowGraph.getPredsOf(curr);
        if (preds.size() == 1) {
            states = fromToStates.get(preds.get(0)).get(curr);
        } else if (preds.size() > 1) {
            Iterator<Unit> it = preds.iterator();
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
              // TODO
              throw new UnsupportedOperationException(stmt.toString());
          }

          // rvalue = ... | constant | ...
          // constant = double_constant | float_constant | int_constant | long_constant | string_constant | null_constant | class_constant;
          public void caseConstant(Constant constant) {
              // varaible "=" constant
              setResult(execute(stmt, variable, constant, inStates));
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
              // TODO
              throw new UnsupportedOperationException(stmt.toString());
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
              // TODO
              throw new UnsupportedOperationException(stmt.toString());
          }

          // rvalue = ... | expr | ...;
          // expr = ... | unop_expr;
          // unop_expr = length_expr | neg_expr;
          public void caseUnopExpr(UnopExpr unopExpr) {
              // TODO
              throw new UnsupportedOperationException(stmt.toString());
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
        final SootMethod callee = controlFlowGraph.unitToMethod.get(stmt);
        for (Unit fallThrough : controlFlowGraph.getSuccsOf(stmt)) {
            // XXX: skip "$r0 := @caughtexception"
            if (!InterproceduralControlFlowGraph.containsCaughtExceptionRef(fallThrough)) {
                final SootMethod caller = controlFlowGraph.unitToMethod.get(fallThrough);
                Unit callStmt = controlFlowGraph.getPrecedingCallStmt(fallThrough, caller);
                final FrameHeapStatics inFrameHeapStatics = inStates.get(callGraph.findEdge(callStmt, callee));
                FrameHeapStatics outFrameHeapStatics;
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
                            setResult(new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
                        }
                    };
                    variable.apply(variableSwitch);
                    outFrameHeapStatics = (FrameHeapStatics)variableSwitch.getResult();
                } else {
                    outFrameHeapStatics = new FrameHeapStatics(new Frame(), inFrameHeapStatics.heap, inFrameHeapStatics.statics);
                }
                States outStates = new States();
                for (Edge context : fromToStates.get(callStmt).get(fallThrough).keySet()) {
                    outStates.put(context, outFrameHeapStatics);
                }
                if (!outStates.equals(fromToStates.get(stmt).get(fallThrough))) {
                    fromToStates.get(stmt).put(fallThrough, outStates);
                    worklist.add(fallThrough);
                }
            }
        }
    }

    // stmt = ... | return_void_stmt | ...;
    private void execute(final ReturnVoidStmt stmt, final States inStates) {
        // return_void_stmt = "return";
        SootMethod callee = controlFlowGraph.unitToMethod.get(stmt);
        for (Unit fallThrough : controlFlowGraph.getSuccsOf(stmt)) {
            // XXX: skip "$r0 := @caughtexception"
            if (!InterproceduralControlFlowGraph.containsCaughtExceptionRef(fallThrough)) {
                SootMethod caller = controlFlowGraph.unitToMethod.get(fallThrough);
                Unit callStmt = controlFlowGraph.getPrecedingCallStmt(fallThrough, caller);
                FrameHeapStatics inFrameHeapStatics = inStates.get(callGraph.findEdge(callStmt, callee));
                FrameHeapStatics outFrameHeapStatics = new FrameHeapStatics(new Frame(), inFrameHeapStatics.heap, inFrameHeapStatics.statics);
                States outStates = new States();
                for (Edge context : fromToStates.get(callStmt).get(fallThrough).keySet()) {
                    outStates.put(context, outFrameHeapStatics);
                }
                if (!outStates.equals(fromToStates.get(stmt).get(fallThrough))) {
                    fromToStates.get(stmt).put(fallThrough, outStates);
                    worklist.add(fallThrough);
                }
            }
        }
    }

    // assign_stmt = variable "=" constant
    private States execute(final AssignStmt stmt, Value variable, Constant constant, final States inStates) {
        final States outStates = new States();
        final Set<MyValue> inValues = new HashSet<MyValue>();
        inValues.add(new MyConstant(constant));
        // variable = array_ref | instance_field_ref | static_field_ref | local;
        variable.apply(new MyAbstractVariableSwitch() {
            // variable = array_ref | ...;
            public void caseArrayRef(ArrayRef arrayRef) {
                Local local = (Local)arrayRef.getBase();
                for (Map.Entry<Edge, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
                    FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
                    Arrays arrays = new Arrays(inFrameHeapStatics.heap.arrays);
                    for (MyValue addr : inFrameHeapStatics.frame.get(local)) {
                        Address address = (Address)addr;
                        Set<MyValue> outValues = new HashSet<MyValue>(inFrameHeapStatics.heap.arrays.get(address));
                        outValues.addAll(inValues);
                        arrays.put(address, outValues);
                    }
                    outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(inFrameHeapStatics.frame, new Heap(inFrameHeapStatics.heap.instances, arrays), inFrameHeapStatics.statics));
                }
            }
            
            // variable = ... | instance_field_ref | ...;
            public void caseInstanceFieldRef(InstanceFieldRef instanceFieldRef) {
                Local local = (Local)instanceFieldRef.getBase();
                SootField field = instanceFieldRef.getField();
                for (Map.Entry<Edge, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
                    FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
                    Instances instances = new Instances(inFrameHeapStatics.heap.instances);
                    for (MyValue addr : inFrameHeapStatics.frame.get(local)) {
                        Address address = (Address)addr;
                        Set<MyValue> outValues = new HashSet<MyValue>(inFrameHeapStatics.heap.instances.get(address, field));
                        outValues.addAll(inValues);
                        instances.put(address, field, outValues);
                    }
                    outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(inFrameHeapStatics.frame, new Heap(instances, inFrameHeapStatics.heap.arrays), inFrameHeapStatics.statics));
                }
            }
            
            // variable = ... | static_field_ref | ...;
            public void caseStaticFieldRef(StaticFieldRef staticFieldRef) {
                // TODO
                throw new UnsupportedOperationException(stmt.toString());
            }

            // variable = ... | local;
            public void caseLocal(Local local) {
                for (Map.Entry<Edge, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
                    FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
                    Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.params);
                    frame.put(local, inValues);
                    outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
                }
            }
        });
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
        for (final Map.Entry<Edge, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
            final FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
            final Set<MyValue> values = evaluate(immediates, inFrameHeapStatics.frame);
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
                    Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.params);
                    frame.put(local, values);
                    outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
                }
            });
        }
        return outStates;
    }

    // assign_stmt = variable "=" cast_expr
    private States execute(final AssignStmt stmt, final Value variable, CastExpr castExpr, final States inStates) {
        // cast_expr = "(" type ")" immediate;
        final States outStates = new States();
        Value immediate = castExpr.getOp();
        // immediate = constant | local;
        immediate.apply(new MyAbstractImmediateSwitch() {
            // immediate = constant | ...;
            // constant = double_constant | float_constant | int_constant | long_constant | string_constant | null_constant | class_constant;
            public void caseConstant(Constant constant) {
                // TODO
                throw new UnsupportedOperationException(stmt.toString());
            }
            
            // immediate = ... | local;
            public void caseLocal(final Local rLocal) {
                // local "=" "(" type ")" local
                // TODO: we may be able to do better by considering "type".
                for (final Map.Entry<Edge, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
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
                        public void caseLocal(Local lLocal) {
                            FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
                            Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.params);
                            frame.put(lLocal, inFrameHeapStatics.frame.get(rLocal));
                            outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
                        }
                    });
                }
            }
        });
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
                SootMethod caller = controlFlowGraph.unitToMethod.get(stmt);
                for (Unit succ : controlFlowGraph.getSuccsOf(stmt)) {
                    // XXX: skip "$r0 := @caughtexception"
                    if (!InterproceduralControlFlowGraph.containsCaughtExceptionRef(succ)) {
                        SootMethod callee = controlFlowGraph.unitToMethod.get(succ);
                        States outStates;
                        if (!caller.equals(callee)) {
                            outStates = makeCalleeStates(stmt, callee, args, inStates);
                        } else {
                            if (controlFlowGraph.getPredsOf(succ).size() > 1) {
                                outStates = new States();
                                for (Map.Entry<Edge, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
                                    FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
                                    Statics statics = new Statics(inFrameHeapStatics.statics);
                                    statics.remove(klass, field);
                                    outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(inFrameHeapStatics.frame, inFrameHeapStatics.heap, statics));
                                }
                            } else {
                                outStates = inStates;
                            }
                        }
                        if (!outStates.equals(fromToStates.get(stmt).get(succ))) {
                            fromToStates.get(stmt).put(succ, outStates);
                            worklist.add(succ);
                        }
                    }
                }
            }
            
            // variable = ... | local;
            public void caseLocal(Local local) {
                // local "=" invoke_expr
                final List<Set<MyValue>> args = evaluateArgs(invokeExpr.getArgs(), inStates);
                SootMethod caller = controlFlowGraph.unitToMethod.get(stmt);
                for (Unit succ : controlFlowGraph.getSuccsOf(stmt)) {
                    // XXX: skip "$r0 := @caughtexception"
                    if (!InterproceduralControlFlowGraph.containsCaughtExceptionRef(succ)) {
                        SootMethod callee = controlFlowGraph.unitToMethod.get(succ);
                        States outStates;
                        if (!caller.equals(callee)) {
                            outStates = makeCalleeStates(stmt, callee, args, inStates);
                        } else {
                            if (controlFlowGraph.getPredsOf(succ).size() > 1) {
                                outStates = new States();
                                for (Map.Entry<Edge, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
                                    FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
                                    Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.params);
                                    frame.remove(local);
                                    outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
                                }
                            } else {
                                outStates = inStates;
                            }
                        }
                        if (!outStates.equals(fromToStates.get(stmt).get(succ))) {
                            fromToStates.get(stmt).put(succ, outStates);
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
            Address address = new Address(allocNode);
            values.add(address);
            for (final Map.Entry<Edge, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
                final FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
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
                        Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.params);
                        frame.put(local, values);
                        outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
                    }
                });
            }
        } else {
            assert controlFlowGraph.unitToMethod.get(stmt).getDeclaringClass().equals(Scene.v().getSootClass("edu.mit.csail.droidsafe.DroidSafeCalls"));
            outStates = inStates;
        }
        return outStates;
    }

    // assign_stmt = variable "=" new_expr
    private States execute(final AssignStmt stmt, Value variable, NewExpr newExpr, States inStates) {
        final States outStates;
        AllocNode allocNode = GeoPTA.v().getAllocNode(newExpr);
        if (allocNode != null) {
            outStates = new States();
            final Set<MyValue> values = new HashSet<MyValue>();
            Address address = new Address(allocNode);
            values.add(address);
            for (final Map.Entry<Edge, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
                final FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
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
                        Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.params);
                        frame.put(local, values);
                        outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(frame, new Heap(inFrameHeapStatics.heap.instances, inFrameHeapStatics.heap.arrays), inFrameHeapStatics.statics));
                    }
                });
            }
        } else {
            assert controlFlowGraph.unitToMethod.get(stmt).getDeclaringClass().equals(Scene.v().getSootClass("edu.mit.csail.droidsafe.DroidSafeCalls"));
            outStates = inStates;
        }
        return outStates;
    }

    // assign_stmt = variable "=" instance_field_ref
    private States execute(final AssignStmt stmt, Value variable, InstanceFieldRef instanceFieldRef, States inStates) {
        final States outStates = new States();
        Local base = (Local)instanceFieldRef.getBase();
        SootField field = instanceFieldRef.getField();
        for (final Map.Entry<Edge, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
            final FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
            final Set<MyValue> values = new HashSet<MyValue>();
            for (MyValue instance : inFrameHeapStatics.frame.get(base)) {
                values.addAll(inFrameHeapStatics.heap.instances.get((Address)instance, field));
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
                    Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.params);
                    frame.put(local, values);
                    outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
                }
            });
        }
        return outStates;
    }

    // assign_stmt = variable "=" local
    private States execute(final AssignStmt stmt, Value variable, final Local local, final States inStates) {
        final States outStates = new States();
        for (final Map.Entry<Edge, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
            final FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
            final Set<MyValue> inValues = inFrameHeapStatics.frame.get(local);
            // variable = array_ref | instance_field_ref | static_field_ref | local;
            variable.apply(new MyAbstractVariableSwitch() {
                // variable = array_ref | ...;
                public void caseArrayRef(ArrayRef arrayRef) {
                    Arrays arrays = new Arrays(inFrameHeapStatics.heap.arrays);
                    for (MyValue addr : inFrameHeapStatics.frame.get((Local)arrayRef.getBase())) {
                        Address address = (Address)addr;
                        Set<MyValue> outValues = new HashSet<MyValue>(inFrameHeapStatics.heap.arrays.get(address));
                        outValues.addAll(inValues);
                        arrays.put(address, outValues);
                    }
                    outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(inFrameHeapStatics.frame, new Heap(inFrameHeapStatics.heap.instances, arrays), inFrameHeapStatics.statics));
                }

                // variable = ... | instance_field_ref | ...;
                public void caseInstanceFieldRef(InstanceFieldRef instanceFieldRef) {
                    // instance_field_ref "=" local
                    SootField field = instanceFieldRef.getField();
                    Instances instances = new Instances(inFrameHeapStatics.heap.instances);
                    for (MyValue addr : inFrameHeapStatics.frame.get((Local)instanceFieldRef.getBase())) {
                        Address address = (Address)addr;
                        Set<MyValue> outValues = new HashSet<MyValue>(inFrameHeapStatics.heap.instances.get(address, field));
                        outValues.addAll(inValues);
                        instances.put(address, field, outValues);
                    }
                    outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(inFrameHeapStatics.frame, new Heap(instances, inFrameHeapStatics.heap.arrays), inFrameHeapStatics.statics));
                }

                // variable = ... | static_field_ref | ...;
                public void caseStaticFieldRef(StaticFieldRef staticFieldRef) {
                    SootField field = staticFieldRef.getField();
                    SootClass klass = field.getDeclaringClass();
                    for (Map.Entry<Edge, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
                        FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
                        Statics statics = new Statics(inFrameHeapStatics.statics);
                        statics.put(klass, field, inValues);
                        outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(inFrameHeapStatics.frame, inFrameHeapStatics.heap, statics));
                    }
                }
                
                // variable = ... | local;
                public void caseLocal(Local local) {
                    // local "=" local
                    for (Map.Entry<Edge, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
                        FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
                        Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.params);
                        frame.put(local, inValues);
                        outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
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
        for (Map.Entry<Edge, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
            final Edge context = contextFrameHeapStatic.getKey();
            final FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
            final Statics statics = inFrameHeapStatics.statics;
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
                    Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.params);
                    frame.put(local, values);
                    outStates.put(context, new FrameHeapStatics(frame, inFrameHeapStatics.heap, statics));
                }
            });
        }
        return outStates;
    }

    // identity_stmt = local ":=" parameter_ref
    private States execute(IdentityStmt stmt, Local local, ParameterRef parameterRef, States inStates) {
        States outStates = new States();
        for (Map.Entry<Edge, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
            FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
            Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.params);
            frame.put(local, inFrameHeapStatics.frame.get(parameterRef));
            outStates.put(contextFrameHeapStatic.getKey(), new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
        }
        return outStates;
    }

    // identity_stmt = local ":=" this_ref
    private States execute(IdentityStmt stmt, Local local, ThisRef thisRef, States inStates) {
        States outStates = new States();
        for (Map.Entry<Edge, FrameHeapStatics> contextFrameHeapStatic : inStates.entrySet()) {
            Edge context = contextFrameHeapStatic.getKey();
            FrameHeapStatics inFrameHeapStatics = contextFrameHeapStatic.getValue();
            Frame frame = new Frame(inFrameHeapStatics.frame, inFrameHeapStatics.frame.params);
            Set<MyValue> values = new HashSet<MyValue>();
            for (AllocNode allocNode : GeoPTA.v().getPTSet(local, context)) {
                values.add(new Address(allocNode));
            }
            frame.put(local, values);
            outStates.put(context, new FrameHeapStatics(frame, inFrameHeapStatics.heap, inFrameHeapStatics.statics));
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
        SootMethod caller = controlFlowGraph.unitToMethod.get(stmt);
        for (Unit succ : controlFlowGraph.getSuccsOf(stmt)) {
            // XXX: skip "$r0 := @caughtexception"
            if (!InterproceduralControlFlowGraph.containsCaughtExceptionRef(succ)) {
                SootMethod callee = controlFlowGraph.unitToMethod.get(succ);
                States outStates;
                if (!caller.equals(callee)) {
                    outStates = makeCalleeStates(stmt, callee, args, inStates);
                } else {
                    outStates = inStates;
                }
                if (!outStates.equals(fromToStates.get(stmt).get(succ))) {
                    fromToStates.get(stmt).put(succ, outStates);
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
                values.add(new MyConstant(constant));
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
                    values.add(new MyConstant(constant));
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
                    Set<MyValue> values = new HashSet<MyValue>();
                    values.add(new MyConstant(constant));
                    args.add(values);
                }
                
                // immediate = ... | local;
                public void caseLocal(Local local) {
                    Set<MyValue> values = new HashSet<MyValue>();
                    for (FrameHeapStatics frameHeapStatics : states.values()) {
                        values.addAll(frameHeapStatics.frame.get(local));
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
        Heap heap = new Heap();
        Statics statics = new Statics();
        for (FrameHeapStatics frameHeapStatics : srcStates.values()) {
            heap = heap.merge(frameHeapStatics.heap);
            statics = statics.merge(frameHeapStatics.statics);
        }
        States tgtStates = new States();
        tgtStates.put(callGraph.findEdge(srcStmt, tgtMethod), new FrameHeapStatics(frame, heap, statics));
        return tgtStates;
    }

    private static void exportDotGraph(final Graph<Unit, DefaultEdge> jGraphT, Path path) throws IOException {
        final InterproceduralControlFlowGraph controlFlowGraph = InterproceduralControlFlowGraph.v();
        final InformationFlowAnalysis infoflow = InformationFlowAnalysis.v();
        DOTExporter<Unit, DefaultEdge> dotExporter = new DOTExporter<Unit, DefaultEdge>(
                new IntegerNameProvider<Unit>(),
                new VertexNameProvider<Unit>() {
                    @Override
                    public String getVertexName(Unit vertex) {
                        StringBuilder str = new StringBuilder(controlFlowGraph.unitToMethod.get(vertex) + "\n" + vertex);
                        if (vertex instanceof AssignStmt) {
                            Value rValue = ((AssignStmt)vertex).getRightOp();
                            if (rValue instanceof NewExpr || rValue instanceof NewArrayExpr || rValue instanceof NewMultiArrayExpr) {
                                AllocNode allocNode = GeoPTA.v().getAllocNode(rValue);
                                str.append("\n" + "[" + allocNode + "]");
                            }
                        }
                        return StringEscapeUtils.escapeJava(str.toString());
                    }
                },
                new EdgeNameProvider<DefaultEdge>() {
                    @Override
                    public String getEdgeName(DefaultEdge edge) {
                        States states = infoflow.getFlowFromTo(jGraphT.getEdgeSource(edge), jGraphT.getEdgeTarget(edge));
                        states = states.subtract(new States()); // cut out empty mappings
                        return StringEscapeUtils.escapeJava(states.toString()).replaceAll("\\\\n", "\\\\l") + "\\l";
                    }
                });
        dotExporter.export(Files.newBufferedWriter(path, Charset.forName("UTF-8")), jGraphT);
    }
}
