package droidsafe.analyses.infoflow;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

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

import soot.Body;
import soot.G;
import soot.Immediate;
import soot.Local;
import soot.MethodOrMethodContext;
import soot.PrimType;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.jimple.AbstractConstantSwitch;
import soot.jimple.AbstractStmtSwitch;
import soot.jimple.AnyNewExpr;
import soot.jimple.ArrayRef;
import soot.jimple.AssignStmt;
import soot.jimple.BinopExpr;
import soot.jimple.CastExpr;
import soot.jimple.ClassConstant;
import soot.jimple.Constant;
import soot.jimple.DynamicInvokeExpr;
import soot.jimple.EqExpr;
import soot.jimple.IdentityStmt;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceOfExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.LengthExpr;
import soot.jimple.NeExpr;
import soot.jimple.NegExpr;
import soot.jimple.NewArrayExpr;
import soot.jimple.NewExpr;
import soot.jimple.NewMultiArrayExpr;
import soot.jimple.NullConstant;
import soot.jimple.NumericConstant;
import soot.jimple.ReturnStmt;
import soot.jimple.ReturnVoidStmt;
import soot.jimple.StaticFieldRef;
import soot.jimple.Stmt;
import soot.jimple.StringConstant;
import soot.jimple.UnopExpr;
import soot.jimple.VirtualInvokeExpr;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.callgraph.Targets;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.toolkits.graph.Block;
import droidsafe.analyses.pta.ContextType;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.pta.PTAContext;
import droidsafe.android.app.Harness;
import droidsafe.android.system.API;
import droidsafe.main.Config;

/**
 * Information Flow Analysis
 */
public class InformationFlowAnalysis {
    public static final ContextType contextType = ContextType.NONE;     // should be either NONE or ONE_CFA

    private static InformationFlowAnalysis v;

    private Map<Block, Map<Block, Locals>> localsFromTo = new HashMap<Block, Map<Block, Locals>>();
    private Instances instances;
    private Arrays arrays;
    private Statics statics;

    private final static Logger logger = LoggerFactory.getLogger(InformationFlowAnalysis.class);

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
        logger.info("Starting Information Flow Analysis...");
        v = new InformationFlowAnalysis();
        logger.info("Finished Information Flow Analysis...");
    }

    // public Set<InfoValue> getTaintsBefore(PTAContext context, Unit unit, Local local) {
    //     HashSet<InfoValue> values = new HashSet<InfoValue>();
    //     State state = getStateBefore(unit);
    //     if (local.getType() instanceof RefLikeType) {
    //         for (IAllocNode allocNode : PTABridge.v().getPTSet(local, context)) {
    //             values.addAll(state.instances.get(context, Address.v(allocNode), ObjectUtils.v().taint));
    //         }
    //     } else {
    //         values.addAll(evaluate(context, local, state.locals));
    //     }
    //     return values;
    // }

    public Set<InfoValue> getTaintsBeforeRecursively(PTAContext context, Unit unit, Local local) {
        HashSet<InfoValue> values = new HashSet<InfoValue>();
        State state = getStateBefore(unit);
        Type type = local.getType();
        if (type instanceof RefLikeType) {
            Set<IAllocNode> reachableAllocNodes = AllocNodeUtils.v().reachable((Set<IAllocNode>)PTABridge.v().getPTSet(local, context));
	    if (Config.v().memoryReadAnalysis) {
		Iterator<MethodOrMethodContext> targets = new Targets(Scene.v().getCallGraph().edgesOutOf(unit));
		while (targets.hasNext()) {
		    SootMethod tgtMethod = (SootMethod)targets.next();
		    ImmutableList<AddressField> addressFields = MemoryReadAnalysis.v().addressFieldsReadRecursively(tgtMethod);
		    for (AddressField addressField : addressFields) {
			Address address = addressField.address;
			if (reachableAllocNodes.contains(address.allocNode)) {
			    values.addAll(state.instances.get(context, address, addressField.field));
			}
		    }
		    ImmutableList<Address> addresses = MemoryReadAnalysis.v().arraysReadRecursively(tgtMethod);
		    for (Address address : addresses) {
			if (reachableAllocNodes.contains(address.allocNode)) {
			    values.addAll(state.arrays.get(context, address));
			}
		    }
		}
	    } else {
		for (IAllocNode allocNode : reachableAllocNodes) {
		    Address address = Address.v(allocNode);
		    values.addAll(state.instances.get(context, address, ObjectUtils.v().taint));
		    values.addAll(state.arrays.get(context, address));
		}
            }
        } else {
            if (Config.v().strict) {
                assert !(type instanceof RefLikeType);
            }
            values.addAll(evaluate(context, local, state.locals));
        }
        return values;
    }

    private State getStateBefore(Unit unit) {
        Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(unit);
        State state = getStateBefore(block);
        Unit precedingUnit = block.getHead();
        while (!precedingUnit.equals(unit)) {
            state = execute(precedingUnit, state);
            precedingUnit = block.getSuccOf(precedingUnit);
        }
        return state;
    }

    private State getStateBefore(Block block) {
        return new State(getLocalsBefore(block), this.instances, this.arrays, this.statics);
    }

    private Locals getLocalsFromTo(Block from, Block to) {
        return localsFromTo.get(from).get(to);
    }

    private Locals getLocalsBefore(Block block) {
        Locals locals;
        List<Block> precedingBlocks = InterproceduralControlFlowGraph.v().getPredsOf(block);
        if (precedingBlocks.size() > 0) {
            locals = Locals.EMPTY;
            for (Block precedingBlock : precedingBlocks) {
                locals = locals.merge(localsFromTo.get(precedingBlock).get(block));
            }
        } else {
            if (Config.v().strict) {
                assert precedingBlocks.size() == 0;
            }
            locals = new Locals(localsFromTo.get(null).get(block));
        }
        return locals;
    }

    private InformationFlowAnalysis() {
        localsFromTo.put(null, new HashMap<Block, Locals>());
        for (Block block : InterproceduralControlFlowGraph.v()) {
            if (InterproceduralControlFlowGraph.v().getPredsOf(block).size() == 0) {
                localsFromTo.get(null).put(block, Locals.EMPTY);
            }
            localsFromTo.put(block, new HashMap<Block, Locals>());
            List<Block> followingBlocks = InterproceduralControlFlowGraph.v().getSuccsOf(block);
            if (followingBlocks.size() > 0) {
                for (Block followingBlock : followingBlocks) {
                    localsFromTo.get(block).put(followingBlock, Locals.EMPTY);
                }
            } else {
                localsFromTo.get(block).put(null, Locals.EMPTY);
            }
        }

        doAnalysis();
    }

    private boolean hasChanged;

    private void doAnalysis() {
        initialize();
        do {
            hasChanged = false;
            Instances instances = new Instances(this.instances);
            Arrays arrays = new Arrays(this.arrays);
            Statics statics = new Statics(this.statics);
            for (Block block : InterproceduralControlFlowGraph.v()) {
                State inState = new State(getLocalsBefore(block), instances, arrays, statics);
                State outState = execute(block, inState);
                if (outState != null) {
                    for (Block followingBlock : InterproceduralControlFlowGraph.v().getSuccsOf(block)) {
                        if (Config.v().strict) {
                            assert !InterproceduralControlFlowGraph.containsCaughtExceptionRef(followingBlock.getHead());
                        }
                        if (hasChanged || !localsFromTo.get(block).get(followingBlock).equals(outState.locals)) {
                            localsFromTo.get(block).put(followingBlock, outState.locals);
                            hasChanged = true;
                        }
                    }
                }
            }
            if (hasChanged || !this.instances.equals(instances) || !this.arrays.equals(arrays) || !this.statics.equals(statics)) {
                this.instances = instances;
                this.arrays = arrays;
                this.statics = statics;
                hasChanged = true;
            }
        } while (hasChanged);
    }

    private void initialize() {
        SootMethod method = Harness.v().getMain();
        Block block = InterproceduralControlFlowGraph.v().methodToHeadBlocks.get(method).get(0);
        if (Config.v().strict) {
            assert block.getHead() instanceof IdentityStmt;
        }
        if (Config.v().strict) {
            assert InterproceduralControlFlowGraph.v().getHeads().contains(block);
        }

        this.localsFromTo.get(null).put(block, Locals.EMPTY);
        this.instances = new Instances();
        this.arrays = new Arrays();
        this.statics = new Statics();
    }

    private State execute(Block block, State inState) {
        State outState = inState;
        Iterator<Unit> units = block.iterator();
        while (units.hasNext()) {
            outState = execute(units.next(), outState);
        }
        return outState;
    }

    private State execute(final Unit unit, final State inState) {
        AbstractStmtSwitch stmtSwitch = new AbstractStmtSwitch() {
            @Override
            public void caseAssignStmt(AssignStmt stmt) {
                setResult(execute(stmt, inState));
            }

            @Override
            public void caseIdentityStmt(IdentityStmt stmt) {
                setResult(inState);
            }

            @Override
            public void caseInvokeStmt(InvokeStmt stmt) {
                // invoke_stmt = invoke_expr;
                setResult(execute(stmt, stmt.getInvokeExpr(), inState));
            }

            @Override
            public void caseReturnStmt(ReturnStmt stmt) {
                setResult(executeReturn(stmt, inState));
            }

            @Override
            public void caseReturnVoidStmt(ReturnVoidStmt stmt) {
                setResult(executeReturn(stmt, inState));
            }

            @Override
            public void defaultCase(Object stmt) {
                setResult(inState);
            }
        };
        unit.apply(stmtSwitch);
        return (State)stmtSwitch.getResult();
    }

    // stmt = assign_stmt
    private State execute(final AssignStmt stmt, final State inState) {
        // assign_stmt = variable "=" rvalue;
        Value lValue = stmt.getLeftOp();
        MyAbstractVariableSwitch lValueSwitch = new MyAbstractVariableSwitch() {
            @Override
            public void caseLocal(Local lLocal) {
                setResult(execute(stmt, lLocal, inState));
            }

            @Override
            public void caseInstanceFieldRef(InstanceFieldRef instanceFieldRef) {
                setResult(execute(stmt, instanceFieldRef, (Immediate)stmt.getRightOp(), inState));
            }

            @Override
            public void caseStaticFieldRef(StaticFieldRef staticFieldRef) {
                setResult(execute(stmt, staticFieldRef, (Immediate)stmt.getRightOp(), inState));
            }

            @Override
            public void caseArrayRef(ArrayRef arrayRef) {
                setResult(execute(stmt, arrayRef, (Immediate)stmt.getRightOp(), inState));
            }
        };
        lValue.apply(lValueSwitch);
        return (State)lValueSwitch.getResult();
    }

    // assign_stmt = local "=" rvalue
    private State execute(final AssignStmt stmt, final Local lLocal, final State inState) {
        // rvalue = array_ref | constant | expr | instance_field_ref | local | next_next_stmt_address | static_field_ref;
        MyAbstractRValueSwitch rValueSwitch = new MyAbstractRValueSwitch() {
            @Override
            public void caseConstant(Constant constant) {
                // local "=" constant
                setResult(execute(stmt, lLocal, constant, inState));
            }

            @Override
            public void caseLocal(Local rLocal) {
                // local "=" local
                setResult(execute(stmt, lLocal, rLocal, inState));
            }

            @Override
            public void caseInstanceFieldRef(InstanceFieldRef instanceFieldRef) {
                // local "=" instance_field_ref
                setResult(execute(stmt, lLocal, instanceFieldRef, inState));
            }

            @Override
            public void caseStaticFieldRef (StaticFieldRef staticFieldRef) {
                // local "=" static_field_ref
                setResult(execute(stmt, lLocal, staticFieldRef, inState));
            }

            @Override
            public void caseArrayRef(ArrayRef arrayRef) {
                // local "=" array_ref
                setResult(execute(stmt, lLocal, arrayRef, inState));
            }

            @Override
            public void caseNewExpr(NewExpr newExpr) {
                // local "=" new_expr
                setResult(execute(stmt, lLocal, newExpr, inState));
            }

            @Override
            public void caseNewArrayExpr(NewArrayExpr newArrayExpr) {
                // local "=" new_array_expr
                setResult(execute(stmt, lLocal, newArrayExpr, inState));
            }

            @Override
            public void caseNewMultiArrayExpr(NewMultiArrayExpr newMultiArrayExpr) {
                // local "=" new_multi_array_expr
                setResult(execute(stmt, lLocal, newMultiArrayExpr, inState));
            }

            @Override
            public void caseCastExpr(CastExpr castExpr) {
                // local "=" cast_expr
                setResult(execute(stmt, lLocal, castExpr, inState));
            }

            @Override
            public void caseInstanceOfExpr(InstanceOfExpr instanceOfExpr) {
                // local "=" instance_of_expr
                setResult(execute(stmt, lLocal, instanceOfExpr, inState));
            }

            @Override
            public void caseUnopExpr(UnopExpr unopExpr) {
                // local "=" unop_expr
                // unop_expr = length_expr | neg_expr
                setResult(execute(stmt, lLocal, unopExpr, inState));
            }

            @Override
            public void caseBinopExpr(BinopExpr binopExpr) {
                // local "=" binop_expr
                setResult(execute(stmt, lLocal, binopExpr, inState));
            }

            @Override
            public void caseInvokeExpr(InvokeExpr invokeExpr) {
                // local "=" invoke_expr
                // invoke_expr = interface_invoke_expr | special_invoke_expr | static_invoke_expr | virtual_invoke_expr;
                if (Config.v().strict) {
                    assert !(invokeExpr instanceof DynamicInvokeExpr);
                }
                setResult(execute(stmt, invokeExpr, inState));
            }
        };
        stmt.getRightOp().apply(rValueSwitch);
        return (State)rValueSwitch.getResult();
    }

    // assign_stmt = local "=" constant
    private State execute(final AssignStmt stmt, final Local lLocal, Constant constant, final State inState) {
        AbstractConstantSwitch constantSwitch = new AbstractConstantSwitch() {
            @Override
            public void caseClassConstant(ClassConstant constant) {
                if (Config.v().strict) {
                    assert lLocal.getType() instanceof RefType;
                }
                if (Config.v().strict) {
                    assert PTABridge.v().getAllocNode(constant) != null :
                            InterproceduralControlFlowGraph.v().unitToBlock.get(stmt).getBody().getMethod() + ": " + stmt + ":\n" +
                            "\tPTABridge.v().getAllocNode(" + constant + ") is null";
                }
                setResult(inState);
            }

            @Override
            public void caseNullConstant(NullConstant constant) {
                if (Config.v().strict) {
                    assert lLocal.getType() instanceof RefLikeType;
                }
                setResult(inState);
            }

            @Override
            public void caseStringConstant(StringConstant constant) {
                if (Config.v().strict) {
                    assert lLocal.getType() instanceof RefType;
                }
                if (Config.v().strict) {
                    assert PTABridge.v().getAllocNode(constant) != null :
                            InterproceduralControlFlowGraph.v().unitToBlock.get(stmt).getBody().getMethod() + ": " + stmt + ":\n" +
                            "\tPTABridge.v().getAllocNode(" + constant + ") is null";
                }
                setResult(inState);
            }

            @Override
            public void defaultCase(Object constant) {
                if (Config.v().strict) {
                    assert constant instanceof NumericConstant;
                }
                setResult(inState);
            }
        };
        constant.apply(constantSwitch);
        return (State)constantSwitch.getResult();
    }

    // assign_stmt = local "=" local
    private State execute(AssignStmt stmt, Local lLocal, Local rLocal, State inState) {
        State outState = inState;
        if (lLocal.getType() instanceof RefLikeType) {
            if (Config.v().strict) {
                assert rLocal.getType() instanceof RefLikeType;
            }
        } else {
            if (Config.v().strict) {
                assert !(rLocal.getType() instanceof RefLikeType);
            }
            SootMethod method = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt).getBody().getMethod();
            for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(method)) {
                outState.locals.putS(context, lLocal, inState.locals.get(context, rLocal));
            }
        }
        return outState;
    }

    // assign_stmt = local "=" instance_field_ref
    private State execute(AssignStmt stmt, Local lLocal, InstanceFieldRef instanceFieldRef, State inState) {
        State outState = inState;
        if (lLocal.getType() instanceof RefLikeType) {
            if (Config.v().strict) {
                assert instanceFieldRef.getType() instanceof RefLikeType;
            }
        } else {
            if (Config.v().strict) {
                assert !(instanceFieldRef.getType() instanceof RefLikeType);
            }
            SootMethod method = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt).getBody().getMethod();
            // instance_field_ref = immediate ".[" field_signature "]"
            Local baseLocal = (Local)instanceFieldRef.getBase();
            SootField field = instanceFieldRef.getField();
            for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(method)) {
                HashSet<InfoValue> values = new HashSet<InfoValue>();
                for (IAllocNode allocNode : PTABridge.v().getPTSet(baseLocal, context)) {
                    values.addAll(inState.instances.get(context, Address.v(allocNode), field));
                }
                outState.locals.putS(context, lLocal, values);
            }
        }
        return outState;
    }

    // assign_stmt = local "=" static_field_ref
    private State execute(AssignStmt stmt, Local lLocal, StaticFieldRef staticFieldRef, State inState) {
        State outState = inState;
        if (lLocal.getType() instanceof RefLikeType) {
            if (Config.v().strict) {
                assert staticFieldRef.getType() instanceof RefLikeType;
            }
        } else {
            if (Config.v().strict) {
                assert !(staticFieldRef.getType() instanceof RefLikeType);
            }
            SootMethod method = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt).getBody().getMethod();
            // static_field_ref = "[" field_signature "]"
            SootField field = staticFieldRef.getField();
            for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(method)) {
                outState.locals.putS(context, lLocal, inState.statics.get(context, field));
            }
        }
        return outState;
    }

    // assign_stmt = local "=" array_ref
    private State execute(AssignStmt stmt, Local lLocal, ArrayRef arrayRef, State inState) {
        State outState = inState;
        if (lLocal.getType() instanceof RefLikeType) {
            if (Config.v().strict) {
                assert arrayRef.getType() instanceof RefLikeType;
            }
        } else {
            if (Config.v().strict) {
                assert !(arrayRef.getType() instanceof RefLikeType);
            }
            SootMethod method = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt).getBody().getMethod();
            // array_ref = immediate "[" immediate "]";
            Local baseLocal = (Local)arrayRef.getBase();
            for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(method)) {
                HashSet<InfoValue> values = new HashSet<InfoValue>();
                for (IAllocNode allocNode : PTABridge.v().getPTSet(baseLocal, context)) {
                    values.addAll(inState.arrays.get(context, Address.v(allocNode)));
                }
                outState.locals.putS(context, lLocal, values);
            }
        }
        return outState;
    }

    // assign_stmt = local "=" new_expr
    // assign_stmt = local "=" new_array_expr
    // assign_stmt = local "=" new_multi_array_expr
    private State execute(AssignStmt stmt, Local lLocal, AnyNewExpr anyNewExpr, State inState) {
        if (Config.v().strict) {
            assert lLocal.getType() instanceof RefLikeType;
        }
        State outState = inState;
        SootMethod method = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt).getBody().getMethod();
        IAllocNode allocNode = PTABridge.v().getAllocNode(anyNewExpr);
        if (allocNode != null) {
            Address address = Address.v(allocNode);
            ImmutableSet<InfoValue> taints = ImmutableSet.<InfoValue>copyOf(InjectedSourceFlows.v().getInjectedFlows(allocNode));
            for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(method)) {
                if (Config.v().strict) {
                    assert PTABridge.v().getPTSet(lLocal, context).contains(PTABridge.v().getAllocNode(anyNewExpr)) :
                            method + ": " + stmt + ":\n" +
                            "\tPTABridge.v().getPTSet(" + lLocal + ", " + context + ") does not contain PTABridge.v().getAllocNode(" + anyNewExpr + ")\n" +
                            "\tPTABridge.v().getPTSet(" + lLocal + ", " + context + ") = " + PTABridge.v().getPTSet(lLocal, context) + "\n" +
                            "\tPTABridge.v().getAllocNode(" + anyNewExpr + ") = " + PTABridge.v().getAllocNode(anyNewExpr);
                }
                outState.instances.putW(context, address, ObjectUtils.v().taint, taints);
            }
        }
        return outState;
    }

    // assign_stmt = local "=" cast_expr
    private State execute(final AssignStmt stmt, final Local lLocal, final CastExpr castExpr, final State inState) {
        MyAbstractImmediateSwitch immediateSwitch = new MyAbstractImmediateSwitch() {
            // immediate = local;
            @Override
            public void caseLocal(Local local) {
                setResult(execute(stmt, lLocal, castExpr, local, inState));
            }

            // immediate = constant
            @Override
            public void caseConstant(Constant constant) {
                setResult(execute(stmt, lLocal, castExpr, constant, inState));
            }
        };
        // cast_expr = "(" type ")" immediate
        ((Immediate)castExpr.getOp()).apply(immediateSwitch);
        return (State)immediateSwitch.getResult();
    }

    // assign_stmt = local "=" "(" type ")" local
    private State execute(AssignStmt stmt, Local lLocal, CastExpr castExpr, Local local, State inState) {
        State outState = inState;
        if (lLocal.getType() instanceof RefLikeType) {
            if (Config.v().strict) {
                assert castExpr.getType() instanceof RefLikeType;
            }
            if (Config.v().strict) {
                assert local.getType() instanceof RefLikeType;
            }
        } else {
            if (Config.v().strict) {
                assert !(castExpr.getType() instanceof RefLikeType);
            }
            if (Config.v().strict) {
                assert !(local.getType() instanceof RefLikeType);
            }
            SootMethod method = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt).getBody().getMethod();
            for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(method)) {
                outState.locals.putS(context, lLocal, inState.locals.get(context, local));
            }
        }
        return outState;
    }

    // assign_stmt = local "=" "(" type ")" constant
    private State execute(final AssignStmt stmt, final Local lLocal, CastExpr castExpr, Constant constant, final State inState) {
        AbstractConstantSwitch constantSwitch = new AbstractConstantSwitch() {
            @Override
            public void caseClassConstant(ClassConstant constant) {
                if (Config.v().strict) {
                    assert lLocal.getType() instanceof RefType;
                }
                if (Config.v().strict) {
                    assert PTABridge.v().getAllocNode(constant) != null :
                            InterproceduralControlFlowGraph.v().unitToBlock.get(stmt).getBody().getMethod() + ": " + stmt + ":\n" +
                            "\tPTABridge.v().getAllocNode(" + constant + ") is null";
                }
                setResult(inState);
            }

            @Override
            public void caseNullConstant(NullConstant constant) {
                setResult(inState);
            }

            @Override
            public void caseStringConstant(StringConstant constant) {
                if (Config.v().strict) {
                    assert lLocal.getType() instanceof RefType;
                }
                if (Config.v().strict) {
                    assert PTABridge.v().getAllocNode(constant) != null :
                            InterproceduralControlFlowGraph.v().unitToBlock.get(stmt).getBody().getMethod() + ": " + stmt + ":\n" +
                            "\tPTABridge.v().getAllocNode(" + constant + ") is null";
                }
                setResult(inState);
            }

            @Override
            public void defaultCase(Object constant) {
                if (Config.v().strict) {
                    assert lLocal.getType() instanceof PrimType;
                }
                if (Config.v().strict) {
                    assert constant instanceof NumericConstant;
                }
                setResult(inState);
            }
        };
        constant.apply(constantSwitch);
        return (State)constantSwitch.getResult();
    }

    // assigin_stmt = local "=" instance_of_expr
    private State execute(AssignStmt stmt, Local lLocal, InstanceOfExpr instanceOfExpr, State inState) {
        if (Config.v().strict) {
            assert !(lLocal.getType() instanceof RefLikeType);
        }
        State outState = inState;
        SootMethod method = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt).getBody().getMethod();
        // instance_of_expr = immediate "instanceof" ref_type
        Local opLocal = (Local)instanceOfExpr.getOp();
        for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(method)) {
            HashSet<InfoValue> values = new HashSet<InfoValue>();
            for (IAllocNode allocNode : PTABridge.v().getPTSet(opLocal, context)) {
                values.addAll(inState.instances.get(context, Address.v(allocNode), ObjectUtils.v().taint));
            }
            outState.locals.putS(context, lLocal, values);
        }
        return outState;
    }

    // assign_stmt = local "=" unop_expr
    private State execute(final AssignStmt stmt, final Local lLocal, UnopExpr unopExpr, final State inState) {
        if (Config.v().strict) {
            assert !(lLocal.getType() instanceof RefLikeType);
        }
        final State outState = inState;
        final SootMethod method = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt).getBody().getMethod();
        // unop_expr = length_expr | neg_expr;
        // length_expr = "length" immediate;
        // neg_expr = "-" immediate;
        final Immediate immediate = (Immediate)unopExpr.getOp();
        MyAbstractUnopExprSwitch unopExprSwitch = new MyAbstractUnopExprSwitch() {
            @Override
            public void caseNegExpr(NegExpr negExpr) {
                for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(method)) {
                    outState.locals.putS(context, lLocal, evaluate(context, immediate, inState.locals));
                }
            }

            @Override
            public void caseLengthExpr(LengthExpr lengthExpr) {
                if (Config.v().strict) {
                    assert immediate instanceof Local;
                }
                for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(method)) {
                    HashSet<InfoValue> values = new HashSet<InfoValue>();
                    for (IAllocNode allocNode : PTABridge.v().getPTSet(immediate, context)) {
                        values.addAll(inState.instances.get(context, Address.v(allocNode), ObjectUtils.v().taint));
                    }
                    outState.locals.putS(context, lLocal, values);
                }
            }
        };
        unopExpr.apply(unopExprSwitch);
        return outState;
    }

    // assign_stmt = local "=" binop_expr
    private State execute(AssignStmt stmt, Local lLocal, BinopExpr binopExpr, State inState) {
        if (Config.v().strict) {
            assert !(lLocal.getType() instanceof RefLikeType);
        }
        State outState = inState;
        SootMethod method = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt).getBody().getMethod();
        // binop_expr = immediate binop immediate
        Immediate[] immediates = {(Immediate)binopExpr.getOp1(), (Immediate)binopExpr.getOp2()};
        if ((binopExpr instanceof EqExpr || binopExpr instanceof NeExpr) && (immediates[0].getType() instanceof RefLikeType)) {
            boolean[] isOpLocal = {immediates[0] instanceof Local, immediates[1] instanceof Local};
            for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(method)) {
                HashSet<InfoValue> values = new HashSet<InfoValue>();
                for (int i = 0; i < immediates.length; i++) {
                    if (isOpLocal[i]) {
                        for (IAllocNode allocNode : PTABridge.v().getPTSet(immediates[i], context)) {
                            values.addAll(inState.instances.get(context, Address.v(allocNode), ObjectUtils.v().taint));
                        }
                    }
                }
                outState.locals.putS(context, lLocal, values);
            }
        } else {
            if (Config.v().strict) {
                assert immediates[0].getType() instanceof PrimType;
                assert immediates[1].getType() instanceof PrimType;
            }
            for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(method)) {
                HashSet<InfoValue> values = new HashSet<InfoValue>();
                for (Immediate immediate : immediates) {
                    values.addAll(evaluate(context, immediate, inState.locals));
                }
                outState.locals.putS(context, lLocal, values);
            }
        }
        return outState;
    }

    // assign_stmt = instance_field_ref "=" immediate
    private State execute(final AssignStmt stmt, final InstanceFieldRef instanceFieldRef, Immediate immediate, final State inState) {
        MyAbstractImmediateSwitch immediateSwitch = new MyAbstractImmediateSwitch() {
            @Override
            public void caseLocal(Local rLocal) {
                // instance_field_ref "=" local
                setResult(execute(stmt, instanceFieldRef, rLocal, inState));
            }

            @Override
            public void caseConstant(Constant constant) {
                // instance_field_ref "=" constant
                setResult(inState);
            }
        };
        immediate.apply(immediateSwitch);
        return (State)immediateSwitch.getResult();
    }

    // assign_stmt = instance_field_ref "=" local
    private State execute(AssignStmt stmt, InstanceFieldRef instanceFieldRef, Local rLocal, State inState) {
        State outState = inState;
        if (!(instanceFieldRef.getType() instanceof RefLikeType)) {
            SootMethod method = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt).getBody().getMethod();
            Local baseLocal = (Local)instanceFieldRef.getBase();
            SootField field = instanceFieldRef.getField();
            for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(method)) {
                ImmutableSet<InfoValue> values = evaluate(context, rLocal, inState.locals);
                if (!values.isEmpty()) {
                    for (IAllocNode allocNode : PTABridge.v().getPTSet(baseLocal, context)) {
                        outState.instances.putW(context, Address.v(allocNode), field, values);
                    }
                }
            }
        }
        return outState;
    }

    // assign_stmt = static_field_ref "=" immediate
    private State execute(final AssignStmt stmt, final StaticFieldRef staticFieldRef, Immediate immediate, final State inState) {
        MyAbstractImmediateSwitch immediateSwitch = new MyAbstractImmediateSwitch() {
            @Override
            public void caseLocal(Local rLocal) {
                // static_field_ref "=" local
                setResult(execute(stmt, staticFieldRef, rLocal, inState));
            }

            @Override
            public void caseConstant(Constant constant) {
                // static_field_ref "=" constant
                if (Config.v().strict) {
                    assert !(constant instanceof ClassConstant);
                }
                setResult(inState);
            }
        };
        immediate.apply(immediateSwitch);
        return (State)immediateSwitch.getResult();

    }

    // assign_stmt = static_field_ref "=" local
    private State execute(AssignStmt stmt, StaticFieldRef staticFieldRef, Local rLocal, State inState) {
        State outState = inState;
        if (!(staticFieldRef.getType() instanceof RefLikeType)) {
            SootMethod method = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt).getBody().getMethod();
            SootField field = staticFieldRef.getField();
            for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(method)) {
                outState.statics.putW(context, field, evaluate(context, rLocal, inState.locals));
            }
        }
        return outState;
    }

    // assign_stmt = array_ref "=" immediate
    private State execute(final AssignStmt stmt, final ArrayRef arrayRef, Immediate immediate, final State inState) {
        MyAbstractImmediateSwitch immediateSwitch = new MyAbstractImmediateSwitch() {
            @Override
            public void caseLocal(Local rLocal) {
                // array_ref "=" local
                setResult(execute(stmt, arrayRef, rLocal, inState));
            }

            @Override
            public void caseConstant(Constant constant) {
                // array_ref "=" constant
                setResult(inState);
            }
        };
        immediate.apply(immediateSwitch);
        return (State)immediateSwitch.getResult();
    }

    // assign_stmt = array_ref "=" local
    private State execute(AssignStmt stmt, ArrayRef arrayRef, Local rLocal, State inState) {
        State outState = inState;
        if (!(arrayRef.getType() instanceof RefLikeType)) {
            SootMethod method = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt).getBody().getMethod();
            Local baseLocal = (Local)arrayRef.getBase();
            for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(method)) {
                ImmutableSet<InfoValue> values = evaluate(context, rLocal, inState.locals);
                if (!values.isEmpty()) {
                    for (IAllocNode allocNode : PTABridge.v().getPTSet(baseLocal, context)) {
                        outState.arrays.putW(context, Address.v(allocNode), values);
                    }
                }
            }
        }
        return outState;
    }

    // stmt = assign_stmt | invoke_stmt
    // assign_stmt = local "=" invoke_expr
    // invoke_stmt = invoke_expr
    // invoke_expr = interface_invoke_expr | special _invoke_expr | static_invoke_expr | virtual_invoke_expr
    // interface_invoke_expr = "interfaceinvoke" immediate ".[" + method_signature "]" "(" immediate_list ")"
    // special_invoke_expr = "specialinvoke" immediate ".[" method_signature "]" "(" immediate_list ")"
    // static_invoke_expr = "staticinvoke" "[" method_signature "]" "(" immediate_list ")"
    // virtual_invoke_expr = "virtualinvoke" immediate ".[" method_signamter "]" "(" immediate_list ")"
    private State execute(Stmt stmt, InvokeExpr invokeExpr, State inState) {
        Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
        if (Config.v().strict) {
            assert block.getTail().equals(stmt);
        }
        List<Block> followingBlocks = InterproceduralControlFlowGraph.v().getSuccsOf(block);
        if (Config.v().strict) {
            assert followingBlocks.size() > 0;
        }

        if (followingBlocks.size() == 1) {
            if (Config.v().strict) {
                assert block.getBody().getMethod().equals(followingBlocks.get(0).getBody().getMethod());
            }
            if (Config.v().strict) {
                assert !InterproceduralControlFlowGraph.containsCaughtExceptionRef(followingBlocks.get(0).getHead());
            }
            SootMethod calleeMethod = invokeExpr.getMethod();
            if (ObjectUtils.v().isAddTaint(calleeMethod)) {
                return executeAddTaint(stmt, invokeExpr, inState);
            } else if (ObjectUtils.v().isGetTaint(calleeMethod)) {
                return executeGetTaint(stmt, invokeExpr, inState);
            } else {
                return inState;
            }
        }

        Local lLocal = (stmt instanceof AssignStmt) ? (Local)((AssignStmt)stmt).getLeftOp() : null;
        SootMethod callerMethod = block.getBody().getMethod();
        HashSet<InfoValue>[] arguments = null;
        AddressFieldToValues addressFieldToValues = null;
        AddressToValues addressToValues = null;
        FieldToValues fieldToValues = null;
        for (Block followingBlock : followingBlocks) {
            if (Config.v().strict) {
                assert !InterproceduralControlFlowGraph.containsCaughtExceptionRef(followingBlock.getHead());
            }
            State outState;
            Body calleeBody = followingBlock.getBody();
            SootMethod calleeMethod = calleeBody.getMethod();
            if (InterproceduralControlFlowGraph.v().methodToHeadBlocks.get(calleeMethod).contains(followingBlock)) {
                outState = new State(new Locals(), inState.instances, inState.arrays, inState.statics);
                Local[] parameterLocals = getParameterLocals(calleeBody);
                if (contextType == ContextType.NONE) {
                    for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(callerMethod)) {
                        for (int i = 0; i < invokeExpr.getArgCount(); i++) {
                            if (!(parameterLocals[i].getType() instanceof RefLikeType)) {
                                Immediate immediate = (Immediate)invokeExpr.getArg(i);
                                outState.locals.putS(context, parameterLocals[i], evaluate(context, immediate, inState.locals));
                            }
                        }
                    }
                } else if (contextType == ContextType.ONE_CFA) {
                    if (arguments == null) {
                        arguments = new HashSet[invokeExpr.getArgCount()];
                        for (int i = 0; i < arguments.length; i++) {
                            Immediate immediate = (Immediate)invokeExpr.getArg(i);
                            if (!(immediate.getType() instanceof RefLikeType)) {
                                arguments[i] = new HashSet<InfoValue>();
                                for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(callerMethod)) {
                                    arguments[i].addAll(evaluate(context, immediate, inState.locals));
                                }
                            }
                        }

                        addressFieldToValues = AddressFieldToValues.EMPTY;
                        for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(callerMethod)) {
                            addressFieldToValues = addressFieldToValues.merge(inState.instances.get(context));
                        }

                        addressToValues = AddressToValues.EMPTY;
                        for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(callerMethod)) {
                            addressToValues = addressToValues.merge(inState.arrays.get(context));
                        }

                        fieldToValues = FieldToValues.EMPTY;
                        for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(callerMethod)) {
                            fieldToValues = fieldToValues.merge(inState.statics.get(context));
                        }
                    }

                    Edge callEdge = Scene.v().getCallGraph().findEdge(stmt, calleeMethod);
                    if (Config.v().strict) {
                        assert callEdge != null;
                    }
                    PTAContext callContext = new PTAContext(contextType, callEdge);
                    for (int i = 0; i < calleeMethod.getParameterCount(); i++) {
                        if (!(parameterLocals[i].getType() instanceof RefLikeType)) {
                            outState.locals.putS(callContext, parameterLocals[i], arguments[i]);
                        }
                    }
                    for (Map.Entry<AddressField, ImmutableSet<InfoValue>> addressFieldValues : addressFieldToValues.entrySet()) {
                        AddressField addressField = addressFieldValues.getKey();
                        ImmutableSet<InfoValue> values = addressFieldValues.getValue();
                        outState.instances.putW(callContext, addressField, values);
                    }
                    for (Map.Entry<Address, ImmutableSet<InfoValue>> addressValues : addressToValues.entrySet()) {
                        Address address = addressValues.getKey();
                        ImmutableSet<InfoValue> values = addressValues.getValue();
                        outState.arrays.putW(callContext, address, values);
                    }
                    for (Map.Entry<SootField, ImmutableSet<InfoValue>> fieldValues : fieldToValues.entrySet()) {
                        SootField field = fieldValues.getKey();
                        ImmutableSet<InfoValue> values = fieldValues.getValue();
                        outState.statics.putW(callContext, field, values);
                    }
                }
            } else {
                outState = inState;
                if (lLocal != null) {
                    for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(callerMethod)) {
                        outState.locals.remove(context, lLocal);
                    }
                }
            }

            if (hasChanged || !localsFromTo.get(block).get(followingBlock).equals(outState.locals)) {
                localsFromTo.get(block).put(followingBlock, outState.locals);
                hasChanged = true;
            }
        }

        return null;
    }

    private State executeGetTaint(Stmt stmt, InvokeExpr invokeExpr, State inState) {
        Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
        if (Config.v().strict) {
            assert InterproceduralControlFlowGraph.v().getSuccsOf(block).size() == 1;
        }
        SootMethod callerMethod = block.getBody().getMethod();

        State outState = inState;
        if (stmt instanceof AssignStmt) {
            // local "=" "virtualinvoke" immediate ".[" Object.getTaint* "]" "(" ")"
            Local lLocal = (Local)((AssignStmt)stmt).getLeftOp();
            Local baseLocal = (Local)((VirtualInvokeExpr)invokeExpr).getBase();
            for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(callerMethod)) {
                HashSet<InfoValue> values = new HashSet<InfoValue>();
                for (IAllocNode allocNode : PTABridge.v().getPTSet(baseLocal, context)) {
                    values.addAll(inState.instances.get(context, Address.v(allocNode), ObjectUtils.v().taint));
                }
                outState.locals.putS(context, lLocal, values);
            }
        } else {
            // "virtualinvoke" immediate ".[" Object.getTaint* "]" "(" ")"
            if (Config.v().strict) {
                assert stmt instanceof InvokeStmt;
            }
        }
       return outState;
    }

    private State executeAddTaint(Stmt stmt, InvokeExpr invokeExpr, State inState) {
        Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
        if (Config.v().strict) {
            assert InterproceduralControlFlowGraph.v().getSuccsOf(block).size() == 1;
        }
        SootMethod callerMethod = block.getBody().getMethod();

        State outState = inState;
        Local baseLocal = (Local)((VirtualInvokeExpr)invokeExpr).getBase();
        Immediate argImmediate = (Immediate)invokeExpr.getArg(0);
        if (argImmediate instanceof Local) {
            for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(callerMethod)) {
                ImmutableSet<InfoValue> values = ImmutableSet.<InfoValue>copyOf(inState.locals.get(context, (Local)argImmediate));
                for (IAllocNode allocNode : PTABridge.v().getPTSet(baseLocal, context)) {
                    outState.instances.putW(context, Address.v(allocNode), ObjectUtils.v().taint, values);
                }
            }
        } else {
            if (Config.v().strict) {
                assert argImmediate instanceof Constant;
            }
        }
        return outState;
    }

    private Local[] getParameterLocals(Body body) {
        SootMethod method = body.getMethod();
        Local[] parameterLocals = new Local[method.getParameterCount()];
        int i = 0;
        while (i < method.getParameterCount()) {
            parameterLocals[i] = body.getParameterLocal(i);
            i++;
        }
        return parameterLocals;
    }

    // stmt = return_stmt | return_void_stmt
    private State executeReturn(Stmt stmt, State inState) {
        if (Config.v().strict) {
            assert stmt instanceof ReturnStmt || stmt instanceof ReturnVoidStmt;
        }
        Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
        SootMethod calleeMethod = block.getBody().getMethod();
        Immediate opImmediate = (stmt instanceof ReturnStmt) ? (Immediate)((ReturnStmt)stmt).getOp() : null;
        for (Block followingBlock : InterproceduralControlFlowGraph.v().getSuccsOf(block)) {
            if (Config.v().strict) {
                assert !InterproceduralControlFlowGraph.containsCaughtExceptionRef(followingBlock.getHead());
            }
            State outState = new State(opImmediate != null ? new Locals() : Locals.EMPTY, inState.instances, inState.arrays, inState.statics);
            SootMethod callerMethod = followingBlock.getBody().getMethod();
            Block callBlock = InterproceduralControlFlowGraph.v().getPrecedingCallBlock(followingBlock, callerMethod);
            Unit callStmt = callBlock.getTail();
            if (contextType == ContextType.NONE) {
                if (opImmediate != null && callStmt instanceof AssignStmt) {
                    Local lLocal = (Local)((AssignStmt)callStmt).getLeftOp();
                    if (lLocal.getType() instanceof RefLikeType) {
                        if (!API.v().isSystemMethod(callerMethod) && API.v().isSystemMethod(calleeMethod)) {
                            if (API.v().hasSourceInfoKind(calleeMethod)
                                    || (Config.v().infoFlowTrackAll && !calleeMethod.getDeclaringClass().getPackageName().equals("java.lang"))) {
                                ImmutableSet<InfoValue> values = ImmutableSet.<InfoValue>of(InfoUnit.v(callStmt));
                                for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(callerMethod)) {
                                    for (IAllocNode allocNode : PTABridge.v().getPTSet(lLocal, context)) {
                                        outState.instances.putW(context, Address.v(allocNode), ObjectUtils.v().taint, values);
                                    }
                                }
                            }
                        }
                    } else {
                        for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(callerMethod)) {
                            outState.locals.putS(context, lLocal, evaluate(context, opImmediate, inState.locals));
                        }
                        if (!API.v().isSystemMethod(callerMethod) && API.v().isSystemMethod(calleeMethod)) {
                            if (API.v().hasSourceInfoKind(calleeMethod)
                                    || (Config.v().infoFlowTrackAll && !calleeMethod.getDeclaringClass().getPackageName().equals("java.lang"))) {
                                ImmutableSet<InfoValue> values = ImmutableSet.<InfoValue>of(InfoUnit.v(callStmt));
                                for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(callerMethod)) {
                                    outState.locals.putW(context, lLocal, values);
                                }
                            }
                        }
                    }
                }
            } else if (contextType == ContextType.ONE_CFA) {
                if (Config.v().strict) {
                    assert !(!API.v().isSystemMethod(callerMethod) && API.v().isSystemMethod(calleeMethod));
                }

                Edge callEdge = Scene.v().getCallGraph().findEdge(callStmt, calleeMethod);
                if (Config.v().strict) {
                    assert callEdge != null;
                }
                PTAContext callContext = new PTAContext(contextType, callEdge);
                if (opImmediate != null && callStmt instanceof AssignStmt) {
                    Local lLocal = (Local)((AssignStmt)callStmt).getLeftOp();
                    if (!(lLocal.getType() instanceof RefLikeType)) {
                        ImmutableSet<InfoValue> values = evaluate(callContext, opImmediate, inState.locals);
                        for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(callerMethod)) {
                            outState.locals.putS(context, lLocal, values);
                        }
                    }
                }
                for(PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(callerMethod)) {
                    outState.instances.putWAll(context, inState.instances.get(callContext));
                    outState.arrays.putWAll(context, inState.arrays.get(callContext));
                    outState.statics.putWAll(context, inState.statics.get(callContext));
                }
            }

            if (hasChanged || !localsFromTo.get(block).get(followingBlock).equals(outState.locals)) {
                localsFromTo.get(block).put(followingBlock, outState.locals);
                hasChanged = true;
            }
        }
        return null;
    }

    private ImmutableSet<InfoValue> evaluate(final PTAContext context, Immediate immediate, final Locals locals) {
        if (Config.v().strict) {
            assert !(immediate.getType() instanceof RefLikeType);
        }

        // immediate = constant | local;
        MyAbstractImmediateSwitch immediateSwitch = new MyAbstractImmediateSwitch() {
            // immediate = local
            @Override
            public void caseLocal(Local local) {
                setResult(locals.get(context, local));
            }

            // immediate = constant
            @Override
            public void caseConstant(Constant constant) {
                setResult(ImmutableSet.<InfoValue>of());
            }
        };
        immediate.apply(immediateSwitch);
        return (ImmutableSet<InfoValue>)immediateSwitch.getResult();
    }

    public static void exportDotGraph(SootMethod method, String fileName) throws IOException {
        exportDotGraph(InterproceduralControlFlowGraph.v().toJGraphT(method), fileName);
    }

    private static void exportDotGraph(final Graph<Block, DefaultEdge> jGraphT, String fileName) throws IOException {
        DOTExporter<Block, DefaultEdge> dotExporter = new DOTExporter<Block, DefaultEdge>(
                new IntegerNameProvider<Block>(),
                new VertexNameProvider<Block>() {
                    @Override
                    public String getVertexName(Block block) {
                        String str = block.getBody().getMethod() + "\n" + block;
                        return StringEscapeUtils.escapeJava(str.toString());
                    }
                },
                new EdgeNameProvider<DefaultEdge>() {
                    @Override
                    public String getEdgeName(DefaultEdge edge) {
                        Block fromBlock = jGraphT.getEdgeSource(edge);
                        Block toBlock = jGraphT.getEdgeTarget(edge);
                        Locals locals = new Locals(InformationFlowAnalysis.v().getLocalsFromTo(fromBlock, toBlock));
                        SootMethod toMethod = toBlock.getBody().getMethod();
                        for (Local local : toMethod.getActiveBody().getLocals()) {
                            if (local.getType() instanceof RefLikeType) {
                                for (PTAContext context : InterproceduralControlFlowGraph.v().methodToContexts.get(toMethod)) {
                                    Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v().getPTSet(local, context);
                                    if (allocNodes != null && !allocNodes.isEmpty()) {
                                        Set<Address> addresses = new HashSet<Address>();
                                        for (IAllocNode allocNode : allocNodes) {
                                            addresses.add(Address.v(allocNode));
                                        }
                                        locals.putW(context, local, ImmutableSet.<InfoValue>copyOf(addresses));
                                    }
                                }
                            }
                        }
                        CharSequenceTranslator translator = new LookupTranslator(new String[][] {{"\\l", "\\l"}}).with(StringEscapeUtils.ESCAPE_JAVA);
                        return translator.translate(locals.toString()) + "\\l";
                    }
                });
        dotExporter.export(new BufferedWriter(new FileWriter(fileName)), jGraphT);
    }
}
