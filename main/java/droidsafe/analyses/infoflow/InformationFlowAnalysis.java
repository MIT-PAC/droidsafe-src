package droidsafe.analyses.infoflow;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.ArrayType;
import soot.Body;
import soot.Context;
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
import soot.jimple.toolkits.callgraph.TransitiveTargets;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.toolkits.graph.Block;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Harness;
import droidsafe.android.system.API;
import droidsafe.android.system.InfoKind;
import droidsafe.main.Config;
import droidsafe.utils.SootUtils;

/**
 * Information Flow Analysis
 */
public class InformationFlowAnalysis {
    private static InformationFlowAnalysis v;

    private Map<Block, Map<Block, Locals>> stackArea = new HashMap<Block, Map<Block, Locals>>();
    private NonStackArea nonStackArea = new NonStackArea();

    private final static Logger logger = LoggerFactory.getLogger(InformationFlowAnalysis.class);

    /**
     * Returns the singleton InformationFlowAnalysis object.
     * @return the singleton InformationFlowAnalysis object
     */
    public static InformationFlowAnalysis v() {
        return InformationFlowAnalysis.v;
    }

    /**
     * Creates a singleton InformationFlowAnalysis object.
     */
    public static void run() {
        InformationFlowAnalysis.v = new InformationFlowAnalysis();
        AllocNodeFieldsReadAnalysis.run();
        AllocNodesReadAnalysis.run();
        FieldsReadAnalysis.run();
        InjectedValuesAnalysis.run();
    }

    public Set<InfoValue> getTaints(IAllocNode rootAllocNode, MethodOrMethodContext methodContext) {
        Set<InfoValue> values = new HashSet<InfoValue>();
        Set<IAllocNode> reachableAllocNodes = AllocNodeUtils.v().reachableAllocNodes(rootAllocNode);

        Set<AllocNodeField> allocNodeFields = AllocNodeFieldsReadAnalysis.v().getRecursively(methodContext);
        for (AllocNodeField allocNodeField : allocNodeFields) {
            IAllocNode allocNode = allocNodeField.allocNode;
            if (reachableAllocNodes.contains(allocNode)) {
                ImmutableSet<InfoValue> vs = this.nonStackArea.instances.get(allocNodeField);
                values.addAll(vs);
            }
        }

        Set<IAllocNode> allocNodes = AllocNodesReadAnalysis.v().getRecursively(methodContext);
        for (IAllocNode allocNode : allocNodes) {
            if (reachableAllocNodes.contains(allocNode)) {
                ImmutableSet<InfoValue> vs = this.nonStackArea.arrays.get(allocNode);
                values.addAll(vs);
            }
        }

        return values;
    }

    public Set<InfoValue> getTaints(MethodOrMethodContext methodContext) {
        Set<InfoValue> values = new HashSet<InfoValue>();

        Set<AllocNodeField> allocNodeFields = AllocNodeFieldsReadAnalysis.v().getRecursively(methodContext);
        for (AllocNodeField allocNodeField : allocNodeFields) {
            ImmutableSet<InfoValue> vs = this.nonStackArea.instances.get(allocNodeField);
            values.addAll(vs);
        }

        Set<IAllocNode> allocNodes = AllocNodesReadAnalysis.v().getRecursively(methodContext);
        for (IAllocNode allocNode : allocNodes) {
            ImmutableSet<InfoValue> vs = this.nonStackArea.arrays.get(allocNode);
            values.addAll(vs);
        }

        Set<SootField> fields = FieldsReadAnalysis.v().getRecursively(methodContext);
        for (SootField field : fields) {
            ImmutableSet<InfoValue> vs = this.nonStackArea.statics.get(field);
            values.addAll(vs);
        }

        ImmutableSet<InfoValue> vs = InjectedValuesAnalysis.v().getRecursively(methodContext);
        values.addAll(vs);

        return values;
    }

    public Set<InfoValue> getTaints(Stmt stmt, MethodOrMethodContext srcMethodContext, Local local) {
        assert srcMethodContext.method().getActiveBody().getUnits().contains(stmt);
        assert local.getType() instanceof PrimType;
        Locals locals = getLocalsBefore(stmt);
        Context context = srcMethodContext.context();
        return locals.get(context, local);
    }

    public Set<InfoValue> getTaints(IAllocNode allocNode) {
        HashSet<InfoValue> values = new HashSet<InfoValue>();
        Set<IAllocNode> reachableAllocNodes = AllocNodeUtils.v().reachableAllocNodes(allocNode);
        for (IAllocNode reachableAllocNode : reachableAllocNodes) {
            Type type = reachableAllocNode.getType();
            if (type instanceof RefType) {
                if (reachableAllocNode instanceof soot.jimple.spark.pag.AllocNode) {
                    Set<soot.jimple.spark.pag.AllocDotField> allocDotFields = ((soot.jimple.spark.pag.AllocNode)reachableAllocNode).getFields();
                    for (soot.jimple.spark.pag.AllocDotField allocDotField : allocDotFields) {
                        SootField field = (SootField)allocDotField.getField();
                        ImmutableSet<InfoValue> vs = this.nonStackArea.instances.get(reachableAllocNode, field);
                        values.addAll(vs);
                    }
                } else if (allocNode instanceof soot.jimple.paddle.AllocNode) {
                    Iterator allocDotFields = ((soot.jimple.paddle.AllocNode)allocNode).fields();
                    while (allocDotFields.hasNext()) {
                        soot.jimple.paddle.AllocDotField allocDotField = (soot.jimple.paddle.AllocDotField)allocDotFields.next();
                        SootField field = (SootField)allocDotField.field();
                        ImmutableSet<InfoValue> vs = this.nonStackArea.instances.get(reachableAllocNode, field);
                        values.addAll(vs);
                    }
                }
            } else if (type instanceof ArrayType) {
                ImmutableSet<InfoValue> vs = this.nonStackArea.arrays.get(reachableAllocNode);
                values.addAll(vs);
            }
        }
        return values;
    }

    private Locals getLocalsBefore(Unit unit) {
        Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(unit);
        Locals locals = getLocalsBefore(block);
        Unit precedingUnit = block.getHead();
        while (!(precedingUnit.equals(unit))) {
            locals = execute(unit, locals, this.nonStackArea);
            precedingUnit = block.getSuccOf(precedingUnit);
        }
        return locals;
    }

    private Locals getLocalsBefore(Block block) {
        Locals locals;
        List<Block> precedingBlocks = InterproceduralControlFlowGraph.v().getPredsOf(block);
        if (precedingBlocks.size() > 0) {
            locals = new Locals();
            for (Block precedingBlock : precedingBlocks) {
                Locals ls = this.stackArea.get(precedingBlock).get(block);
                locals.merge(ls);
            }
        } else {
            assert precedingBlocks.size() == 0;
            Locals ls = this.stackArea.get(null).get(block);
            locals = new Locals(ls);
        }
        return locals;
    }

    private InformationFlowAnalysis() {
        stackArea.put(null, new HashMap<Block, Locals>());
        for (Block block : InterproceduralControlFlowGraph.v()) {
            if (InterproceduralControlFlowGraph.v().getPredsOf(block).size() == 0) {
                stackArea.get(null).put(block, Locals.EMPTY);
            }
            stackArea.put(block, new HashMap<Block, Locals>());
            List<Block> followingBlocks = InterproceduralControlFlowGraph.v().getSuccsOf(block);
            if (followingBlocks.size() > 0) {
                for (Block followingBlock : followingBlocks) {
                    stackArea.get(block).put(followingBlock, Locals.EMPTY);
                }
            } else {
                stackArea.get(block).put(null, Locals.EMPTY);
            }
        }

        doAnalysis();
    }

    private boolean hasChanged;

    private void doAnalysis() {
        initialize();
        do {
            this.hasChanged = false;
            NonStackArea nonStackArea = new NonStackArea(this.nonStackArea);
            for (Block block : InterproceduralControlFlowGraph.v()) {
                Locals inLocals = getLocalsBefore(block);
                Locals outLocals = execute(block, inLocals, nonStackArea);
                if (outLocals != null) {
                    for (Block followingBlock : InterproceduralControlFlowGraph.v().getSuccsOf(block)) {
                        assert !(InterproceduralControlFlowGraph.containsCaughtExceptionRef(followingBlock.getHead()));
                        if (this.hasChanged || !(this.stackArea.get(block).get(followingBlock).equals(outLocals))) {
                            this.stackArea.get(block).put(followingBlock, outLocals);
                            this.hasChanged = true;
                        }
                    }
                }
            }
            if (this.hasChanged || !(this.nonStackArea.equals(nonStackArea))) {
                this.nonStackArea = nonStackArea;
                this.hasChanged = true;
            }
        } while (this.hasChanged);
    }

    private void initialize() {
        SootMethod method = Harness.v().getMain();
        List<Block> blocks = InterproceduralControlFlowGraph.v().methodToHeadBlocks.get(method);
        assert blocks.size() == 1;
        Block block = blocks.get(0);
        assert block.getHead() instanceof IdentityStmt;
        assert InterproceduralControlFlowGraph.v().getHeads().contains(block);

        this.stackArea.get(null).put(block, Locals.EMPTY);
    }

    private Locals execute(Block block, Locals locals, NonStackArea nonStackArea) {
        Iterator<Unit> units = block.iterator();
        while (units.hasNext()) {
            locals = execute(units.next(), locals, nonStackArea);
        }
        return locals;
    }

    private Locals execute(final Unit unit, final Locals locals, final NonStackArea nonStackArea) {
        AbstractStmtSwitch stmtSwitch = new AbstractStmtSwitch() {
            @Override
            public void caseAssignStmt(AssignStmt stmt) {
                setResult(execute(stmt, locals, nonStackArea));
            }

            @Override
            public void caseIdentityStmt(IdentityStmt stmt) {
                setResult(locals);
            }

            @Override
            public void caseInvokeStmt(InvokeStmt stmt) {
                // invoke_stmt = invoke_expr;
                setResult(execute(stmt, stmt.getInvokeExpr(), locals, nonStackArea));
            }

            @Override
            public void caseReturnStmt(ReturnStmt stmt) {
                setResult(execute(stmt, locals, nonStackArea));
            }

            @Override
            public void caseReturnVoidStmt(ReturnVoidStmt stmt) {
                setResult(execute(stmt, locals, nonStackArea));
            }

            @Override
            public void defaultCase(Object stmt) {
                setResult(locals);
            }
        };
        unit.apply(stmtSwitch);
        return (Locals)stmtSwitch.getResult();
    }

    // stmt = assign_stmt
    private Locals execute(final AssignStmt stmt, final Locals locals, final NonStackArea nonStackArea) {
        // assign_stmt = variable "=" rvalue;
        Value lValue = stmt.getLeftOp();
        MyAbstractVariableSwitch lValueSwitch = new MyAbstractVariableSwitch() {
            @Override
            public void caseLocal(Local lLocal) {
                setResult(execute(stmt, lLocal, locals, nonStackArea));
            }

            @Override
            public void caseInstanceFieldRef(InstanceFieldRef instanceFieldRef) {
                Immediate rImmediate = (Immediate)stmt.getRightOp();
                setResult(execute(stmt, instanceFieldRef, rImmediate, locals, nonStackArea));
            }

            @Override
            public void caseStaticFieldRef(StaticFieldRef staticFieldRef) {
                Immediate rImmediate = (Immediate)stmt.getRightOp();
                setResult(execute(stmt, staticFieldRef, rImmediate, locals, nonStackArea));
            }

            @Override
            public void caseArrayRef(ArrayRef arrayRef) {
                Immediate rImmediate = (Immediate)stmt.getRightOp();
                setResult(execute(stmt, arrayRef, rImmediate, locals, nonStackArea));
            }
        };
        lValue.apply(lValueSwitch);
        return (Locals)lValueSwitch.getResult();
    }

    // assign_stmt = local "=" rvalue
    private Locals execute(final AssignStmt stmt, final Local lLocal, final Locals locals, final NonStackArea nonStackArea) {
        // rvalue = array_ref | constant | expr | instance_field_ref | local | next_next_stmt_address | static_field_ref;
        MyAbstractRValueSwitch rValueSwitch = new MyAbstractRValueSwitch() {
            @Override
            public void caseConstant(Constant constant) {
                // local "=" constant
                setResult(execute(stmt, lLocal, constant, locals, nonStackArea));
            }

            @Override
            public void caseLocal(Local rLocal) {
                // local "=" local
                setResult(execute(stmt, lLocal, rLocal, locals, nonStackArea));
            }

            @Override
            public void caseInstanceFieldRef(InstanceFieldRef instanceFieldRef) {
                // local "=" instance_field_ref
                setResult(execute(stmt, lLocal, instanceFieldRef, locals, nonStackArea));
            }

            @Override
            public void caseStaticFieldRef (StaticFieldRef staticFieldRef) {
                // local "=" static_field_ref
                setResult(execute(stmt, lLocal, staticFieldRef, locals, nonStackArea));
            }

            @Override
            public void caseArrayRef(ArrayRef arrayRef) {
                // local "=" array_ref
                setResult(execute(stmt, lLocal, arrayRef, locals, nonStackArea));
            }

            @Override
            public void caseNewExpr(NewExpr newExpr) {
                // local "=" new_expr
                setResult(execute(stmt, lLocal, newExpr, locals, nonStackArea));
            }

            @Override
            public void caseNewArrayExpr(NewArrayExpr newArrayExpr) {
                // local "=" new_array_expr
                setResult(execute(stmt, lLocal, newArrayExpr, locals, nonStackArea));
            }

            @Override
            public void caseNewMultiArrayExpr(NewMultiArrayExpr newMultiArrayExpr) {
                // local "=" new_multi_array_expr
                setResult(execute(stmt, lLocal, newMultiArrayExpr, locals, nonStackArea));
            }

            @Override
            public void caseCastExpr(CastExpr castExpr) {
                // local "=" cast_expr
                setResult(execute(stmt, lLocal, castExpr, locals, nonStackArea));
            }

            @Override
            public void caseInstanceOfExpr(InstanceOfExpr instanceOfExpr) {
                // local "=" instance_of_expr
                setResult(execute(stmt, lLocal, instanceOfExpr, locals, nonStackArea));
            }

            @Override
            public void caseUnopExpr(UnopExpr unopExpr) {
                // local "=" unop_expr
                // unop_expr = length_expr | neg_expr
                setResult(execute(stmt, lLocal, unopExpr, locals, nonStackArea));
            }

            @Override
            public void caseBinopExpr(BinopExpr binopExpr) {
                // local "=" binop_expr
                setResult(execute(stmt, lLocal, binopExpr, locals, nonStackArea));
            }

            @Override
            public void caseInvokeExpr(InvokeExpr invokeExpr) {
                // local "=" invoke_expr
                // invoke_expr = interface_invoke_expr | special_invoke_expr | static_invoke_expr | virtual_invoke_expr;
                assert !(invokeExpr instanceof DynamicInvokeExpr);
                setResult(execute(stmt, invokeExpr, locals, nonStackArea));
            }
        };
        stmt.getRightOp().apply(rValueSwitch);
        return (Locals)rValueSwitch.getResult();
    }

    // assign_stmt = local "=" constant
    private Locals execute(final AssignStmt stmt, final Local lLocal, Constant constant, final Locals locals, final NonStackArea nonStackArea) {
        AbstractConstantSwitch constantSwitch = new AbstractConstantSwitch() {
            @Override
            public void caseClassConstant(ClassConstant constant) {
                assert lLocal.getType() instanceof RefType;
                setResult(locals);
            }

            @Override
            public void caseNullConstant(NullConstant constant) {
                assert lLocal.getType() instanceof RefLikeType;
                setResult(locals);
            }

            @Override
            public void caseStringConstant(StringConstant constant) {
                assert lLocal.getType() instanceof RefType;
                setResult(locals);
            }

            @Override
            public void defaultCase(Object constant) {
                assert constant instanceof NumericConstant;
                setResult(locals);
            }
        };
        constant.apply(constantSwitch);
        return (Locals)constantSwitch.getResult();
    }

    // assign_stmt = local "=" local
    private Locals execute(AssignStmt stmt, Local lLocal, Local rLocal, Locals locals, NonStackArea nonStackArea) {
        if (lLocal.getType() instanceof RefLikeType) {
                assert rLocal.getType() instanceof RefLikeType;
        } else {
                assert !(rLocal.getType() instanceof RefLikeType);
            Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
            Body body = block.getBody();
            SootMethod method = body.getMethod();
            Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
            for (MethodOrMethodContext methodContext : methodContexts) {
                Context context = methodContext.context();
                ImmutableSet<InfoValue> values = locals.get(context, rLocal);
                locals.putS(context, lLocal, values);
            }
        }
        return locals;
    }

    // assign_stmt = local "=" instance_field_ref
    private Locals execute(AssignStmt stmt, Local lLocal, InstanceFieldRef instanceFieldRef, Locals locals, NonStackArea nonStackArea) {
        if (lLocal.getType() instanceof RefLikeType) {
            assert instanceFieldRef.getType() instanceof RefLikeType;
        } else {
            assert !(instanceFieldRef.getType() instanceof RefLikeType);
            Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
            Body body = block.getBody();
            SootMethod method = body.getMethod();
            // instance_field_ref = immediate ".[" field_signature "]"
            Local baseLocal = (Local)instanceFieldRef.getBase();
            SootField field = instanceFieldRef.getField();
            Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
            for (MethodOrMethodContext methodContext : methodContexts) {
                Context context = methodContext.context();
                HashSet<InfoValue> values = new HashSet<InfoValue>();
                Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v().getPTSet(baseLocal, context);
                for (IAllocNode allocNode : allocNodes) {
                    ImmutableSet<InfoValue> vs = nonStackArea.instances.get(allocNode, field);
                    values.addAll(vs);
                }
                locals.putS(context, lLocal, values);
            }
        }
        return locals;
    }

    // assign_stmt = local "=" static_field_ref
    private Locals execute(AssignStmt stmt, Local lLocal, StaticFieldRef staticFieldRef, Locals locals, NonStackArea nonStackArea) {
        if (lLocal.getType() instanceof RefLikeType) {
            assert staticFieldRef.getType() instanceof RefLikeType;
        } else {
            assert !(staticFieldRef.getType() instanceof RefLikeType);
            Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
            Body body = block.getBody();
            SootMethod method = body.getMethod();
            // static_field_ref = "[" field_signature "]"
            SootField field = staticFieldRef.getField();
            ImmutableSet<InfoValue> values = nonStackArea.statics.get(field);
            Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
            for (MethodOrMethodContext methodContext : methodContexts) {
                Context context = methodContext.context();
                locals.putS(context, lLocal, values);
            }
        }
        return locals;
    }

    // assign_stmt = local "=" array_ref
    private Locals execute(AssignStmt stmt, Local lLocal, ArrayRef arrayRef, Locals locals, NonStackArea nonStackArea) {
        if (lLocal.getType() instanceof RefLikeType) {
            assert arrayRef.getType() instanceof RefLikeType;
        } else {
            assert !(arrayRef.getType() instanceof RefLikeType);
            Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
            Body body = block.getBody();
            SootMethod method = body.getMethod();
            // array_ref = immediate "[" immediate "]";
            Local baseLocal = (Local)arrayRef.getBase();
            Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
            for (MethodOrMethodContext methodContext : methodContexts) {
                Context context = methodContext.context();
                HashSet<InfoValue> values = new HashSet<InfoValue>();
                Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v().getPTSet(baseLocal, context);
                for (IAllocNode allocNode : allocNodes) {
                    ImmutableSet<InfoValue> vs = nonStackArea.arrays.get(allocNode);
                    values.addAll(vs);
                }
                locals.putS(context, lLocal, values);
            }
        }
        return locals;
    }

    // assign_stmt = local "=" new_expr
    private Locals execute(AssignStmt stmt, Local lLocal, NewExpr newExpr, Locals locals, NonStackArea nonStackArea) {
        assert lLocal.getType() instanceof RefLikeType;
//        Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
//        Body body = block.getBody();
//        SootMethod method = body.getMethod();
//        Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
//        for (MethodOrMethodContext methodContext : methodContexts) {
//            Context context = methodContext.context();
//            IAllocNode allocNode = PTABridge.v().getAllocNode(newExpr, context);
//            if (allocNode != null) {
//                if (Config.v().strict) {
//                    assert PTABridge.v().getPTSet(lLocal, context).contains(PTABridge.v().getAllocNode(newExpr, context)) :
//                            method + ": " + stmt + ":\n" +
//                            "\tPTABridge.v().getPTSet(" + lLocal + ", " + context + ") does not contain PTABridge.v().getAllocNode(" + newExpr + ", " + context + ")\n" +
//                            "\tPTABridge.v().getPTSet(" + lLocal + ", " + context + ") = " + PTABridge.v().getPTSet(lLocal, context) + "\n" +
//                            "\tPTABridge.v().getAllocNode(" + newExpr + ", " + context + ") = " + PTABridge.v().getAllocNode(newExpr, context);
//                }
//                Set<InfoKind> values = InjectedSourceFlows.v().getInjectedFlows(allocNode);
//                nonStackArea.instances.putW(allocNode, ObjectUtils.v().taint, ImmutableSet.<InfoValue>copyOf(values));
//            }
//        }
        return locals;
    }

    // assign_stmt = local "=" new_array_expr
    private Locals execute(AssignStmt stmt, Local lLocal, NewArrayExpr newArrayExpr, Locals locals, NonStackArea nonStackArea) {
        assert lLocal.getType() instanceof RefLikeType;
        Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
        Body body = block.getBody();
        SootMethod method = body.getMethod();
        // new_array_expr = "new" type "[" immediate "]";
        Immediate sizeImmediate = (Immediate)newArrayExpr.getSize();
        Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
        for (MethodOrMethodContext methodContext : methodContexts) {
            Context context = methodContext.context();
            ImmutableSet<InfoValue> values = evaluate(context, sizeImmediate, locals);
            Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v().getPTSet(lLocal, context);
            for (IAllocNode allocNode : allocNodes) {
                nonStackArea.instances.putW(allocNode, ObjectUtils.v().taint,values);
            }
        }
        return locals;
    }

    // assign_stmt = local "=" new_multi_array_expr
    private Locals execute(AssignStmt stmt, Local lLocal, NewMultiArrayExpr newMultiArrayExpr, Locals locals, NonStackArea nonStackArea) {
        assert lLocal.getType() instanceof RefLikeType;
        Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
        Body body = block.getBody();
        SootMethod method = body.getMethod();
        // new_multi_array_expr = "new multiarray " type sized_dims empty_dims;
        // sized_dims = "[" immediate "]" next_sized_dims;
        // next_sized_dims = "[" immediate "]" next_sized_dims | ;
        // empty_dims = "[]" empty_dims | ;
        List<Immediate> sizeImmediates = newMultiArrayExpr.getSizes();
        Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
        for (MethodOrMethodContext methodContext : methodContexts) {
            Context context = methodContext.context();
            HashSet<InfoValue> values = new HashSet<InfoValue>();
            for (Immediate sizeImmediate : sizeImmediates) {
                ImmutableSet<InfoValue> sizeValues = evaluate(context, sizeImmediate, locals);
                values.addAll(sizeValues);
            }
            Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v().getPTSet(lLocal, context);
            for (IAllocNode allocNode : allocNodes) {
                nonStackArea.instances.putW(allocNode, ObjectUtils.v().taint, ImmutableSet.<InfoValue>copyOf(values));
            }
        }
        return locals;
    }

    // assign_stmt = local "=" cast_expr
    private Locals execute(final AssignStmt stmt, final Local lLocal, final CastExpr castExpr, final Locals locals, final NonStackArea nonStackArea) {
        MyAbstractImmediateSwitch immediateSwitch = new MyAbstractImmediateSwitch() {
            // immediate = local;
            @Override
            public void caseLocal(Local local) {
                setResult(execute(stmt, lLocal, castExpr, local, locals, nonStackArea));
            }

            // immediate = constant
            @Override
            public void caseConstant(Constant constant) {
                setResult(execute(stmt, lLocal, castExpr, constant, locals, nonStackArea));
            }
        };
        // cast_expr = "(" type ")" immediate
        Immediate opImmediate = (Immediate)castExpr.getOp();
        opImmediate.apply(immediateSwitch);
        return (Locals)immediateSwitch.getResult();
    }

    // assign_stmt = local "=" "(" type ")" local
    private Locals execute(AssignStmt stmt, Local lLocal, CastExpr castExpr, Local rLocal, Locals locals, NonStackArea nonStackArea) {
        if (lLocal.getType() instanceof RefLikeType) {
            assert castExpr.getType() instanceof RefLikeType;
            assert rLocal.getType() instanceof RefLikeType;
        } else {
            assert !(castExpr.getType() instanceof RefLikeType);
            assert !(rLocal.getType() instanceof RefLikeType);
            Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
            Body body = block.getBody();
            SootMethod method = body.getMethod();
            Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
            for (MethodOrMethodContext methodContext : methodContexts) {
                Context context = methodContext.context();
                ImmutableSet<InfoValue> values = locals.get(context, rLocal);
                locals.putS(context, lLocal, values);
            }
        }
        return locals;
    }

    // assign_stmt = local "=" "(" type ")" constant
    private Locals execute(final AssignStmt stmt, final Local lLocal, CastExpr castExpr, Constant constant, final Locals locals, final NonStackArea nonStackArea) {
        AbstractConstantSwitch constantSwitch = new AbstractConstantSwitch() {
            @Override
            public void caseClassConstant(ClassConstant constant) {
                assert lLocal.getType() instanceof RefType;
                setResult(locals);
            }

            @Override
            public void caseNullConstant(NullConstant constant) {
                setResult(locals);
            }

            @Override
            public void caseStringConstant(StringConstant constant) {
                assert lLocal.getType() instanceof RefType;
                setResult(locals);
            }

            @Override
            public void defaultCase(Object constant) {
                assert lLocal.getType() instanceof PrimType;
                assert constant instanceof NumericConstant;
                setResult(locals);
            }
        };
        constant.apply(constantSwitch);
        return (Locals)constantSwitch.getResult();
    }

    // assigin_stmt = local "=" instance_of_expr
    private Locals execute(AssignStmt stmt, Local lLocal, InstanceOfExpr instanceOfExpr, Locals locals, NonStackArea nonStackArea) {
        assert !(lLocal.getType() instanceof RefLikeType);
        Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
        Body body = block.getBody();
        SootMethod method = body.getMethod();
        // instance_of_expr = immediate "instanceof" ref_type
        Local opLocal = (Local)instanceOfExpr.getOp();
        Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
        for (MethodOrMethodContext methodContext : methodContexts) {
            Context context = methodContext.context();
            HashSet<InfoValue> values = new HashSet<InfoValue>();
            Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v().getPTSet(opLocal, context);
            for (IAllocNode allocNode : allocNodes) {
                ImmutableSet<InfoValue> vs = nonStackArea.instances.get(allocNode, ObjectUtils.v().taint);
                values.addAll(vs);
            }
            locals.putS(context, lLocal, values);
        }
        return locals;
    }

    // assign_stmt = local "=" unop_expr
    private Locals execute(final AssignStmt stmt, final Local lLocal, UnopExpr unopExpr, final Locals locals, final NonStackArea nonStackArea) {
        assert !(lLocal.getType() instanceof RefLikeType);
        Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
        Body body = block.getBody();
        final SootMethod method = body.getMethod();
        // unop_expr = length_expr | neg_expr;
        // length_expr = "length" immediate;
        // neg_expr = "-" immediate;
        final Immediate opImmediate = (Immediate)unopExpr.getOp();
        MyAbstractUnopExprSwitch unopExprSwitch = new MyAbstractUnopExprSwitch() {
            @Override
            public void caseNegExpr(NegExpr negExpr) {
                for (MethodOrMethodContext methodContext : PTABridge.v().getMethodContexts(method)) {
                    Context context = methodContext.context();
                    ImmutableSet<InfoValue> values = evaluate(context, opImmediate, locals);
                    locals.putS(context, lLocal, values);
                }
            }

            @Override
            public void caseLengthExpr(LengthExpr lengthExpr) {
                assert opImmediate instanceof Local;
                Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
                for (MethodOrMethodContext methodContext : methodContexts) {
                    Context context = methodContext.context();
                    HashSet<InfoValue> values = new HashSet<InfoValue>();
                    Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v().getPTSet(opImmediate, context);
                    for (IAllocNode allocNode : allocNodes) {
                        ImmutableSet<InfoValue> vs = nonStackArea.instances.get(allocNode, ObjectUtils.v().taint);
                        values.addAll(vs);
                    }
                    locals.putS(context, lLocal, values);
                }
            }
        };
        unopExpr.apply(unopExprSwitch);
        return locals;
    }

    // assign_stmt = local "=" binop_expr
    private Locals execute(AssignStmt stmt, Local lLocal, BinopExpr binopExpr, Locals locals, NonStackArea nonStackArea) {
        assert !(lLocal.getType() instanceof RefLikeType);
        SootMethod method = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt).getBody().getMethod();
        // binop_expr = immediate binop immediate
        Immediate[] immediates = {(Immediate)binopExpr.getOp1(), (Immediate)binopExpr.getOp2()};
        if ((binopExpr instanceof EqExpr || binopExpr instanceof NeExpr) && (immediates[0].getType() instanceof RefLikeType)) {
            boolean[] isOpLocal = {immediates[0] instanceof Local, immediates[1] instanceof Local};
            Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
            for (MethodOrMethodContext methodContext : methodContexts) {
                Context context = methodContext.context();
                HashSet<InfoValue> values = new HashSet<InfoValue>();
                for (int i = 0; i < immediates.length; i++) {
                    if (isOpLocal[i]) {
                        Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v().getPTSet(immediates[i], context);
                        for (IAllocNode allocNode : allocNodes) {
                            ImmutableSet<InfoValue> vs = nonStackArea.instances.get(allocNode, ObjectUtils.v().taint);
                            values.addAll(vs);
                        }
                    }
                }
                locals.putS(context, lLocal, values);
            }
        } else {
            assert immediates[0].getType() instanceof PrimType;
            assert immediates[1].getType() instanceof PrimType;
            Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
            for (MethodOrMethodContext methodContext : methodContexts) {
                Context context = methodContext.context();
                HashSet<InfoValue> values = new HashSet<InfoValue>();
                for (Immediate immediate : immediates) {
                    ImmutableSet<InfoValue> vs = evaluate(context, immediate, locals);
                    values.addAll(vs);
                }
                locals.putS(context, lLocal, values);
            }
        }
        return locals;
    }

    // assign_stmt = instance_field_ref "=" immediate
    private Locals execute(final AssignStmt stmt, final InstanceFieldRef instanceFieldRef, Immediate immediate, final Locals locals, final NonStackArea nonStackArea) {
        MyAbstractImmediateSwitch immediateSwitch = new MyAbstractImmediateSwitch() {
            @Override
            public void caseLocal(Local rLocal) {
                // instance_field_ref "=" local
                setResult(execute(stmt, instanceFieldRef, rLocal, locals, nonStackArea));
            }

            @Override
            public void caseConstant(Constant constant) {
                // instance_field_ref "=" constant
                setResult(locals);
            }
        };
        immediate.apply(immediateSwitch);
        return (Locals)immediateSwitch.getResult();
    }

    // assign_stmt = instance_field_ref "=" local
    private Locals execute(AssignStmt stmt, InstanceFieldRef instanceFieldRef, Local rLocal, Locals locals, NonStackArea nonStackArea) {
        if (!(instanceFieldRef.getType() instanceof RefLikeType)) {
            Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
            Body body = block.getBody();
            SootMethod method = body.getMethod();
            Local baseLocal = (Local)instanceFieldRef.getBase();
            SootField field = instanceFieldRef.getField();
            Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
            for (MethodOrMethodContext methodContext : methodContexts) {
                Context context = methodContext.context();
                ImmutableSet<InfoValue> values = evaluate(context, rLocal, locals);
                if (!(values.isEmpty())) {
                    Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v().getPTSet(baseLocal, context);
                    for (IAllocNode allocNode : allocNodes) {
                        nonStackArea.instances.putW(allocNode, field, values);
                    }
                }
            }
        }
        return locals;
    }

    // assign_stmt = static_field_ref "=" immediate
    private Locals execute(final AssignStmt stmt, final StaticFieldRef staticFieldRef, Immediate rImmediate, final Locals locals, final NonStackArea nonStackArea) {
        MyAbstractImmediateSwitch immediateSwitch = new MyAbstractImmediateSwitch() {
            @Override
            public void caseLocal(Local rLocal) {
                // static_field_ref "=" local
                setResult(execute(stmt, staticFieldRef, rLocal, locals, nonStackArea));
            }

            @Override
            public void caseConstant(Constant constant) {
                // static_field_ref "=" constant
                assert !(constant instanceof ClassConstant);
                setResult(locals);
            }
        };
        rImmediate.apply(immediateSwitch);
        return (Locals)immediateSwitch.getResult();

    }

    // assign_stmt = static_field_ref "=" local
    private Locals execute(AssignStmt stmt, StaticFieldRef staticFieldRef, Local rLocal, Locals locals, NonStackArea nonStackArea) {
        if (!(staticFieldRef.getType() instanceof RefLikeType)) {
            Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
            Body body = block.getBody();
            SootMethod method = body.getMethod();
            SootField field = staticFieldRef.getField();
            Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
            for (MethodOrMethodContext methodContext : methodContexts) {
                Context context = methodContext.context();
                ImmutableSet<InfoValue> values = evaluate(context, rLocal, locals);
                nonStackArea.statics.putW(field, values);
            }
        }
        return locals;
    }

    // assign_stmt = array_ref "=" immediate
    private Locals execute(final AssignStmt stmt, final ArrayRef arrayRef, Immediate immediate, final Locals locals, final NonStackArea nonStackArea) {
        MyAbstractImmediateSwitch immediateSwitch = new MyAbstractImmediateSwitch() {
            @Override
            public void caseLocal(Local rLocal) {
                // array_ref "=" local
                setResult(execute(stmt, arrayRef, rLocal, locals, nonStackArea));
            }

            @Override
            public void caseConstant(Constant constant) {
                // array_ref "=" constant
                setResult(locals);
            }
        };
        immediate.apply(immediateSwitch);
        return (Locals)immediateSwitch.getResult();
    }

    // assign_stmt = array_ref "=" local
    private Locals execute(AssignStmt stmt, ArrayRef arrayRef, Local rLocal, Locals locals, NonStackArea nonStackArea) {
        if (!(arrayRef.getType() instanceof RefLikeType)) {
            Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
            Body body = block.getBody();
            SootMethod method = body.getMethod();
            Local baseLocal = (Local)arrayRef.getBase();
            Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
            for (MethodOrMethodContext methodContext : methodContexts) {
                Context context = methodContext.context();
                ImmutableSet<InfoValue> values = evaluate(context, rLocal, locals);
                if (!(values.isEmpty())) {
                    Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v().getPTSet(baseLocal, context);
                    for (IAllocNode allocNode : allocNodes) {
                        nonStackArea.arrays.putW(allocNode, values);
                    }
                }
            }
        }
        return locals;
    }

    // stmt = assign_stmt | invoke_stmt
    // assign_stmt = local "=" invoke_expr
    // invoke_stmt = invoke_expr
    // invoke_expr = interface_invoke_expr | special _invoke_expr | static_invoke_expr | virtual_invoke_expr
    // interface_invoke_expr = "interfaceinvoke" immediate ".[" + method_signature "]" "(" immediate_list ")"
    // special_invoke_expr = "specialinvoke" immediate ".[" method_signature "]" "(" immediate_list ")"
    // static_invoke_expr = "staticinvoke" "[" method_signature "]" "(" immediate_list ")"
    // virtual_invoke_expr = "virtualinvoke" immediate ".[" method_signamter "]" "(" immediate_list ")"
    private Locals execute(Stmt stmt, InvokeExpr invokeExpr, Locals locals, NonStackArea nonStackArea) {
        SootMethod invokeMethod = invokeExpr.getMethod();
        if (ObjectUtils.v().isAddTaint(invokeMethod)) {
            return executeAddTaint(stmt, invokeExpr, locals, nonStackArea);
        } else if (ObjectUtils.v().isGetTaint(invokeMethod)) {
            return executeGetTaint(stmt, invokeExpr, locals, nonStackArea);
        }

        Block callerBlock = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
        Body callerBody = callerBlock.getBody();
        SootMethod callerMethod = callerBody.getMethod();
        HashSet<SootMethod> calleeMethods = new HashSet<SootMethod>();
        HashMap<Context, HashSet<InfoValue>[]> contextToArguments = new HashMap<Context, HashSet<InfoValue>[]>();
        int argumentCount = invokeExpr.getArgCount();
        List<Value> argumentImmediates = invokeExpr.getArgs();
//        Immediate[] argumentImmediates = new Immediate[argumentCount];
        Set<MethodOrMethodContext> callerMethodContexts = PTABridge.v().getMethodContexts(callerMethod);
        for (MethodOrMethodContext callerMethodContext : callerMethodContexts) {
            Context callerContext = callerMethodContext.context();
            List<Edge> callEdges = PTABridge.v().outgoingEdges(callerMethodContext, stmt);
            for (Edge callEdge : callEdges) {
                MethodOrMethodContext calleeMethodContext = callEdge.getTgt();
                SootMethod calleeMethod = calleeMethodContext.method();
                if (calleeMethod.hasActiveBody()) {
                    calleeMethods.add(calleeMethod);

                    Context calleeContext = calleeMethodContext.context();
                    HashSet<InfoValue>[] argumentValues = contextToArguments.get(calleeContext);
                    if (argumentValues == null) {
                        argumentValues = new HashSet[argumentCount];
                        for (int i = 0; i < argumentCount; i++) {
                            Immediate immediate = (Immediate)argumentImmediates.get(i); 
                            if (!(immediate.getType() instanceof RefLikeType)) {
                                argumentValues[i] = new HashSet<InfoValue>();
                            }
                        }
                        contextToArguments.put(calleeContext, argumentValues);
                    }
                    for (int i = 0; i < argumentCount; i++) {
                        Immediate immediate = (Immediate)argumentImmediates.get(i); 
                        if (!(immediate.getType() instanceof RefLikeType)) {
                            ImmutableSet<InfoValue> values = evaluate(callerContext, immediate, locals);
                            argumentValues[i].addAll(values);
                        }
                    }
                }
            }
        }
        for (MethodOrMethodContext callerMethodContext : callerMethodContexts) {
            Context callerContext = callerMethodContext.context();
            List<Edge> callEdges = PTABridge.v().outgoingEdges(callerMethodContext, stmt);
            for (Edge callEdge : callEdges) {
                MethodOrMethodContext calleeMethodContext = callEdge.getTgt();
                SootMethod calleeMethod = calleeMethodContext.method();
                if (calleeMethod.hasActiveBody()) {
                    Context calleeContext = calleeMethodContext.context();
                    Local[] parameterLocals = getParameterLocals(calleeMethod);
                    List<Block> calleeHeadBlocks = InterproceduralControlFlowGraph.v().methodToHeadBlocks.get(calleeMethod);
                    for (Block calleeHeadBlock : calleeHeadBlocks) {
                        Locals calleeLocals = new Locals();
                        HashSet<InfoValue>[] argumentValues = contextToArguments.get(calleeContext);
                        for (int i = 0; i < parameterLocals.length; i++) {
                            Local local = parameterLocals[i]; 
                            if (!(local.getType() instanceof RefLikeType)) {
                                calleeLocals.putS(calleeContext, parameterLocals[i], argumentValues[i]);
                            }
                        }
                        Locals previousCalleeLocals = this.stackArea.get(callerBlock).get(calleeHeadBlock);
                        if (this.hasChanged || !(calleeLocals.equals(previousCalleeLocals))) {
                            this.stackArea.get(callerBlock).put(calleeHeadBlock, calleeLocals);
                            this.hasChanged = true;
                        }
                    }
                }
            }
        }
        
        if (stmt instanceof AssignStmt) {
            Local lLocal = (Local)((AssignStmt)stmt).getLeftOp();
            for (MethodOrMethodContext callerMethodContext : callerMethodContexts) {
                Context callerContext = callerMethodContext.context();
                boolean hasActiveBody = true;
                List<Edge> callEdges = PTABridge.v().outgoingEdges(callerMethodContext, stmt);
                for (Edge callEdge : callEdges) {
                    MethodOrMethodContext calleeMethodContext = callEdge.getTgt();
                    SootMethod calleeMethod = calleeMethodContext.method();
                    if (!(calleeMethod.hasActiveBody())) {
                        hasActiveBody = false;
                        break;
                    }
                }
                if (hasActiveBody) {
                    locals.remove(callerContext, lLocal);
                }
            }
            Block fallThroughBlock = InterproceduralControlFlowGraph.v().getFallThroughBlock(callerBlock);
            Locals previousCallerLocals = this.stackArea.get(callerBlock).get(fallThroughBlock);
            if (this.hasChanged || !(locals.equals(previousCallerLocals))) {
                this.stackArea.get(callerBlock).put(fallThroughBlock, locals);
                this.hasChanged = true;
            }
        }

        return null;
    }

    private Locals executeGetTaint(Stmt stmt, InvokeExpr invokeExpr, Locals locals, NonStackArea nonStackArea) {
        Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
        assert InterproceduralControlFlowGraph.v().getSuccsOf(block).size() == 1;
        Body body = block.getBody();
        SootMethod method = body.getMethod();
        if (stmt instanceof AssignStmt) {
            // local "=" "virtualinvoke" immediate ".[" Object.getTaint* "]" "(" ")"
            Local lLocal = (Local)((AssignStmt)stmt).getLeftOp();
            Local baseLocal = (Local)((VirtualInvokeExpr)invokeExpr).getBase();
            Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
            for (MethodOrMethodContext methodContext : methodContexts) {
                Context context = methodContext.context();
                HashSet<InfoValue> values = new HashSet<InfoValue>();
                Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v().getPTSet(baseLocal, context);
                for (IAllocNode allocNode : allocNodes) {
                    ImmutableSet<InfoValue> vs = nonStackArea.instances.get(allocNode, ObjectUtils.v().taint);
                    values.addAll(vs);
                }
                locals.putS(context, lLocal, values);
            }
        } else {
            // "virtualinvoke" immediate ".[" Object.getTaint* "]" "(" ")"
            assert stmt instanceof InvokeStmt;
        }
       return locals;
    }

    private Locals executeAddTaint(Stmt stmt, InvokeExpr invokeExpr, Locals locals, NonStackArea nonStackArea) {
        Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
        assert InterproceduralControlFlowGraph.v().getSuccsOf(block).size() == 1;
        Body body = block.getBody();
        SootMethod method = body.getMethod();
        Local baseLocal = (Local)((VirtualInvokeExpr)invokeExpr).getBase();
        Immediate argImmediate = (Immediate)invokeExpr.getArg(0);
        if (argImmediate instanceof Local) {
            Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
            for (MethodOrMethodContext methodContext : methodContexts) {
                Context context = methodContext.context();
                ImmutableSet<InfoValue> values = ImmutableSet.<InfoValue>copyOf(locals.get(context, (Local)argImmediate));
                Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v().getPTSet(baseLocal, context);
                for (IAllocNode allocNode : allocNodes) {
                    nonStackArea.instances.putW(allocNode, ObjectUtils.v().taint, values);
                }
            }
        } else {
            assert argImmediate instanceof Constant;
        }
        return locals;
    }

    private Local[] getParameterLocals(SootMethod method) {
        Body body = method.getActiveBody();
        Local[] parameterLocals = new Local[method.getParameterCount()];
        int i = 0;
        while (i < method.getParameterCount()) {
            parameterLocals[i] = body.getParameterLocal(i);
            i++;
        }
        return parameterLocals;
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

    // stmt = return_void_stmt
    private Locals execute(ReturnVoidStmt stmt, Locals locals, NonStackArea nonStackArea) {
        return null;
    }

    // stmt = return_stmt
    private Locals execute(ReturnStmt stmt, Locals locals, NonStackArea nonStackArea) {
        Block calleeBlock = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
        Body calleeBody = calleeBlock.getBody();
        SootMethod calleeMethod = calleeBody.getMethod();
        Immediate returnImmediate = (Immediate)stmt.getOp();
        Type returnType = calleeMethod.getReturnType();
        Set<MethodOrMethodContext> calleeMethodContexts = PTABridge.v().getMethodContexts(calleeMethod);
        for (MethodOrMethodContext calleeMethodContext : calleeMethodContexts) {
            Context calleeContext = calleeMethodContext.context();
            for (Edge callEdge : PTABridge.v().incomingEdges(calleeMethodContext)) {
                MethodOrMethodContext callerMethodContext = callEdge.getSrc();
                SootMethod callerMethod = callerMethodContext.method();
                Context callerContext = callerMethodContext.context();
                Stmt callStmt = callEdge.srcStmt();
                if (callStmt instanceof AssignStmt) {
                    if (returnType instanceof RefLikeType) {
                        if (!(API.v().isSystemMethod(callerMethod)) && API.v().isSystemMethod(calleeMethod)) {
                            if (API.v().hasSourceInfoKind(calleeMethod)
                                    || (Config.v().infoFlowTrackAll && !(calleeMethod.getDeclaringClass().getPackageName().equals("java.lang")))) {
                                ImmutableSet<InfoValue> values = ImmutableSet.<InfoValue>of(InfoUnit.v(callStmt));
                                Local lLocal = (Local)((AssignStmt)callStmt).getLeftOp();
                                Set<IAllocNode> allocNodes = (Set<IAllocNode>)PTABridge.v().getPTSet(lLocal, callerContext);
                                for (IAllocNode allocNode : allocNodes) {
                                    nonStackArea.instances.putW(allocNode, ObjectUtils.v().taint, values);
                                }
                            }
                        }
                    } else {
                        HashSet<InfoValue> values = new HashSet<InfoValue>(evaluate(calleeContext, returnImmediate, locals));
                        if (!(API.v().isSystemMethod(callerMethod)) && API.v().isSystemMethod(calleeMethod)) {
                            if (API.v().hasSourceInfoKind(calleeMethod)
                                    || (Config.v().infoFlowTrackAll && !(calleeMethod.getDeclaringClass().getPackageName().equals("java.lang")))) {
                                values.add(InfoUnit.v(callStmt));
                            }
                        }
                        Block callerBlock = InterproceduralControlFlowGraph.v().unitToBlock.get(callStmt);
                        Block fallThroughBlock = InterproceduralControlFlowGraph.v().getFallThroughBlock(callerBlock);
                        Locals callerLocals = this.stackArea.get(calleeBlock).get(fallThroughBlock);
                        Local lLocal = (Local)((AssignStmt)callStmt).getLeftOp();
                        ImmutableSet<InfoValue> previousValues = callerLocals.get(callerContext, lLocal);
                        if (this.hasChanged || !(values.equals(previousValues))) {
                            callerLocals.putS(callerContext, lLocal, values);
                            this.hasChanged = true;
                        }
                    }
                }
            }
        }

        return null;
    }

    private ImmutableSet<InfoValue> evaluate(final Context context, Immediate immediate, final Locals locals) {
        assert !(immediate.getType() instanceof RefLikeType);

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
}

class AllocNodeFieldsReadAnalysis {
    private static AllocNodeFieldsReadAnalysis v;

    public static void run() {
        v = new AllocNodeFieldsReadAnalysis();
    }

    static AllocNodeFieldsReadAnalysis v() {
        return v;
    }

    private Map<MethodOrMethodContext, Set<AllocNodeField>> methodContextToAllocNodeFields = new DefaultHashMap<MethodOrMethodContext, Set<AllocNodeField>>(Collections.<AllocNodeField>emptySet());

    private AllocNodeFieldsReadAnalysis() {
        doAnalysis();
    }

    static Set<AllocNodeField> getAllocNodeFieldsRead(AssignStmt stmt, MethodOrMethodContext methodContext) {
        Set<AllocNodeField> allocNodeFields = null;
        Value rValue = stmt.getRightOp();
        if (rValue instanceof InstanceFieldRef) {
            allocNodeFields = getAllocNodeFieldsRead(stmt, (InstanceFieldRef)rValue, methodContext);
        } else if (rValue instanceof InvokeExpr) {
            allocNodeFields = getAllocNodeFieldsRead(stmt, (InvokeExpr)rValue, methodContext);
        }
        return allocNodeFields;
    }

    static Set<AllocNodeField> getAllocNodeFieldsRead(AssignStmt stmt, InstanceFieldRef instanceFieldRef, MethodOrMethodContext methodContext) {
        Set<AllocNodeField> allocNodeFields = null;
        SootField field = instanceFieldRef.getField();
        if (!(field.getType() instanceof RefLikeType)) {
            allocNodeFields = new HashSet<AllocNodeField>();
            Value baseValue = instanceFieldRef.getBase();
            Context context = methodContext.context();
            for (IAllocNode allocNode : PTABridge.v().getPTSet(baseValue, context)) {
                allocNodeFields.add((AllocNodeField.v(allocNode, field)));
            }
        }
        return allocNodeFields;
    }

    static Set<AllocNodeField> getAllocNodeFieldsRead(AssignStmt stmt, InvokeExpr invokeExpr, MethodOrMethodContext methodContext) {
        Set<AllocNodeField> allocNodeFields = null;
        boolean isGetTaint = false;
        List<Edge> callEdges = PTABridge.v().outgoingEdges(methodContext, stmt);
        Iterator<MethodOrMethodContext> tgtMethodContexts = new Targets(callEdges.iterator());
        while (tgtMethodContexts.hasNext()) {
            MethodOrMethodContext tgtMethodContext = tgtMethodContexts.next();
            SootMethod method = tgtMethodContext.method();
            if (ObjectUtils.v().isGetTaint(method)) {
                isGetTaint = true;
                break;
            }
        }
        if (isGetTaint) {
            allocNodeFields = new HashSet<AllocNodeField>();
            Local local = (Local)((VirtualInvokeExpr)invokeExpr).getBase();
            Context context = methodContext.context();
            Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v().getPTSet(local, context);
            for (IAllocNode allocNode : allocNodes) {
                allocNodeFields.add(AllocNodeField.v(allocNode, ObjectUtils.v().taint));
            }
        }
        return allocNodeFields;
    }

    private void doAnalysis() {
        Set<SootMethod> methods = PTABridge.v().getReachableMethods();
        for (SootMethod method : methods) {
            if (method.hasActiveBody() && !(SootUtils.isRuntimeStubMethod(method)) && !(ObjectUtils.v().isAddTaint(method)) && !(ObjectUtils.v().isGetTaint(method))) {
                List<Block> blocks = InterproceduralControlFlowGraph.v().methodToBlocks.get(method);
                Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
                for (MethodOrMethodContext methodContext : methodContexts) {
                    HashSet<AllocNodeField> allocNodeFields = new HashSet<AllocNodeField>();
                    for (Block block : blocks) {
                        Iterator<Unit> units = block.iterator();
                        while (units.hasNext()) {
                            Unit unit = units.next();
                            Set<AllocNodeField> afs = null;
                            if (unit instanceof AssignStmt) {
                                afs = getAllocNodeFieldsRead((AssignStmt)unit, methodContext);
                            }
                            if (afs != null) {
                                allocNodeFields.addAll(afs);
                            }
                        }
                    }
                    this.methodContextToAllocNodeFields.put(methodContext, allocNodeFields);
                }
            }
        }
    }

    private Map<MethodOrMethodContext, ImmutableSet<AllocNodeField>> methodContextToAllocNodeFieldsRecursively = new HashMap<MethodOrMethodContext, ImmutableSet<AllocNodeField>>();
    private TransitiveTargets transitiveTargets = new TransitiveTargets(Scene.v().getCallGraph());

    ImmutableSet<AllocNodeField> getRecursively(MethodOrMethodContext methodContext) {
        if (this.methodContextToAllocNodeFieldsRecursively.containsKey(methodContext)) {
            return this.methodContextToAllocNodeFieldsRecursively.get(methodContext);
        }

        HashSet<AllocNodeField> allocNodeFields = new HashSet<AllocNodeField>(this.methodContextToAllocNodeFields.get(methodContext));
        Iterator<MethodOrMethodContext> tgtMethodContexts = this.transitiveTargets.iterator(methodContext);
        while (tgtMethodContexts.hasNext()) {
            MethodOrMethodContext tgtMethodContext = tgtMethodContexts.next();
            Set<AllocNodeField> afs = this.methodContextToAllocNodeFields.get(tgtMethodContext);
            allocNodeFields.addAll(afs);
        }
        ImmutableSet<AllocNodeField> afs = ImmutableSet.copyOf(allocNodeFields);
        this.methodContextToAllocNodeFieldsRecursively.put(methodContext, afs);
        return afs;
    }
}

class AllocNodesReadAnalysis {
    private static AllocNodesReadAnalysis v;

    public static void run() {
        v = new AllocNodesReadAnalysis();
    }

    static AllocNodesReadAnalysis v() {
        return v;
    }

    private Map<MethodOrMethodContext, Set<IAllocNode>> methodContextToAllocNodes = new DefaultHashMap<MethodOrMethodContext, Set<IAllocNode>>(Collections.<IAllocNode>emptySet());

    private AllocNodesReadAnalysis() {
        doAnalysis();
    }

    static Set<IAllocNode> getAllocNodesRead(AssignStmt stmt, MethodOrMethodContext methodContext) {
        Set<IAllocNode> allocNodes = null;
        Value rValue = stmt.getRightOp();
        if (rValue instanceof ArrayRef) {
            allocNodes = getAllocNodesRead(stmt, (ArrayRef)rValue, methodContext);
        }
        return allocNodes;
    }

    static Set<IAllocNode> getAllocNodesRead(AssignStmt stmt, ArrayRef arrayRef, MethodOrMethodContext methodContext) {
        Set<IAllocNode> allocNodes = null;
        if (!(arrayRef.getType() instanceof RefLikeType)) {
            allocNodes = new HashSet<IAllocNode>();
            Value baseValue = arrayRef.getBase();
            Context context = methodContext.context();
            for (IAllocNode allocNode : PTABridge.v().getPTSet(baseValue, context)) {
                allocNodes.add(allocNode);
            }
        }
        return allocNodes;
    }

    private void doAnalysis() {
        Set<SootMethod> methods = PTABridge.v().getReachableMethods();
        for (SootMethod method : methods) {
            if (method.hasActiveBody() && !(SootUtils.isRuntimeStubMethod(method)) && !(ObjectUtils.v().isAddTaint(method)) && !(ObjectUtils.v().isGetTaint(method))) {
                List<Block> blocks = InterproceduralControlFlowGraph.v().methodToBlocks.get(method);
                Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
                for (MethodOrMethodContext methodContext : methodContexts) {
                    HashSet<IAllocNode> allocNodes = new HashSet<IAllocNode>();
                    for (Block block : blocks) {
                        Iterator<Unit> units = block.iterator();
                        while (units.hasNext()) {
                            Unit unit = units.next();
                            Set<IAllocNode> as = null;
                            if (unit instanceof AssignStmt) {
                                as = getAllocNodesRead((AssignStmt)unit, methodContext);
                            }
                            if (as != null) {
                                allocNodes.addAll(as);
                            }
                        }
                    }
                    this.methodContextToAllocNodes.put(methodContext, allocNodes);
                }
            }
        }
    }

    private Map<MethodOrMethodContext, ImmutableSet<IAllocNode>> methodContextToAllocNodesRecursively = new HashMap<MethodOrMethodContext, ImmutableSet<IAllocNode>>();
    TransitiveTargets transitiveTargets = new TransitiveTargets(Scene.v().getCallGraph());

    ImmutableSet<IAllocNode> getRecursively(MethodOrMethodContext methodContext) {
        if (this.methodContextToAllocNodesRecursively.containsKey(methodContext)) {
            return this.methodContextToAllocNodesRecursively.get(methodContext);
        }

        HashSet<IAllocNode> allocNodes = new HashSet<IAllocNode>(this.methodContextToAllocNodes.get(methodContext));
        Iterator<MethodOrMethodContext> tgtMethodContexts = this.transitiveTargets.iterator(methodContext);
        while (tgtMethodContexts.hasNext()) {
            MethodOrMethodContext tgtMethodContext = tgtMethodContexts.next();
            Set<IAllocNode> as = this.methodContextToAllocNodes.get(tgtMethodContext);
            allocNodes.addAll(as);
        }
        ImmutableSet<IAllocNode> as = ImmutableSet.copyOf(allocNodes);
        this.methodContextToAllocNodesRecursively.put(methodContext, as);
        return as;
    }
}

class FieldsReadAnalysis {
    private static FieldsReadAnalysis v;

    public static void run() {
        v = new FieldsReadAnalysis();
    }

    static FieldsReadAnalysis v() {
        return v;
    }

    private Map<SootMethod, Set<SootField>> methodToFields = new DefaultHashMap<SootMethod, Set<SootField>>(Collections.<SootField>emptySet());

    private FieldsReadAnalysis() {
        doAnalysis();
    }

    static Set<SootField> getFieldsRead(AssignStmt stmt) {
        Set<SootField> fields = null;
        Value rValue = stmt.getRightOp();
        if (rValue instanceof StaticFieldRef) {
            fields = getFieldsRead(stmt, (StaticFieldRef)rValue);
        }
        return fields;
    }

    static Set<SootField> getFieldsRead(AssignStmt stmt, StaticFieldRef staticFieldRef) {
        Set<SootField> fields = null;
        if (!(staticFieldRef.getType() instanceof RefLikeType)) {
            SootField field = staticFieldRef.getField();
            fields = Collections.<SootField>singleton(field);
        }
        return fields;
    }

    private void doAnalysis() {
        Set<SootMethod> methods = PTABridge.v().getReachableMethods();
        for (SootMethod method : methods) {
            if (method.hasActiveBody() && !(SootUtils.isRuntimeStubMethod(method)) && !(ObjectUtils.v().isAddTaint(method)) && !(ObjectUtils.v().isGetTaint(method))) {
                List<Block> blocks = InterproceduralControlFlowGraph.v().methodToBlocks.get(method);
                HashSet<SootField> fields = new HashSet<SootField>();
                for (Block block : blocks) {
                    Iterator<Unit> units = block.iterator();
                    while (units.hasNext()) {
                        Unit unit = units.next();
                        Set<SootField> fs = null;
                        if (unit instanceof AssignStmt) {
                            fs = getFieldsRead((AssignStmt)unit);
                        }
                        if (fs != null) {
                            fields.addAll(fs);
                        }
                    }
                }
                this.methodToFields.put(method, fields);
            }
        }
    }

    private Map<MethodOrMethodContext, ImmutableSet<SootField>> methodContextToFieldsRecursively = new HashMap<MethodOrMethodContext, ImmutableSet<SootField>>();
    TransitiveTargets transitiveTargets = new TransitiveTargets(Scene.v().getCallGraph());

    ImmutableSet<SootField> getRecursively(MethodOrMethodContext methodContext) {
        if (this.methodContextToFieldsRecursively.containsKey(methodContext)) {
            return this.methodContextToFieldsRecursively.get(methodContext);
        }

        HashSet<SootMethod> visitedMethods = new HashSet<SootMethod>();
        SootMethod method = methodContext.method();
        HashSet<SootField> fields = new HashSet<SootField>(this.methodToFields.get(method));
        visitedMethods.add(method);
        Iterator<MethodOrMethodContext> tgtMethodContexts = this.transitiveTargets.iterator(methodContext);
        while (tgtMethodContexts.hasNext()) {
            MethodOrMethodContext tgtMethodContext = tgtMethodContexts.next();
            SootMethod tgtMethod = tgtMethodContext.method();
            if (!(visitedMethods.contains(tgtMethod))) {
                Set<SootField> fs = this.methodToFields.get(tgtMethodContext.method());
                fields.addAll(fs);
                visitedMethods.add(tgtMethod);
            }
        }
        ImmutableSet<SootField> fs = ImmutableSet.copyOf(fields);
        this.methodContextToFieldsRecursively.put(methodContext, fs);
        return fs;
    }
}

class InjectedValuesAnalysis {
    private static InjectedValuesAnalysis v;

    public static void run() {
        v = new InjectedValuesAnalysis();
    }

    static InjectedValuesAnalysis v() {
        return v;
    }

    private Map<MethodOrMethodContext, Set<InfoValue>> methodContextToValues = new DefaultHashMap<MethodOrMethodContext, Set<InfoValue>>(Collections.<InfoValue>emptySet());

    private InjectedValuesAnalysis() {
        doAnalysis();
    }

    static Set<InfoValue> getInjectedValues(AssignStmt stmt, MethodOrMethodContext methodContext) {
        Set<InfoValue> values = null;
        Value rValue = stmt.getRightOp();
        if (rValue instanceof InvokeExpr) {
            values = getInjectedValues(stmt, (InvokeExpr)rValue, methodContext);
        }
        return values;
    }

//    static Set<InfoValue> getInjectedValues(AssignStmt stmt, AnyNewExpr anyNewExpr, MethodOrMethodContext methodContext) {
//        Set<InfoValue> values = null;
//        Context context = methodContext.context();
//        IAllocNode allocNode = PTABridge.v().getAllocNode(anyNewExpr, context);
//        if (allocNode != null) {
//            Set<InfoKind> vs = InjectedSourceFlows.v().getInjectedFlows(allocNode);
//            if (vs != null && !(vs.isEmpty())) {
//                values = new HashSet<InfoValue>();
//                values.addAll(vs);
//            }
//        }
//        return values;
//    }

    static Set<InfoValue> getInjectedValues(AssignStmt stmt, InvokeExpr invokeExpr, MethodOrMethodContext callerMethodContext) {
        HashSet<InfoValue> values = new HashSet<InfoValue>();
        Block callerBlock = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
        Body callerBody = callerBlock.getBody();
        SootMethod callerMethod = callerBody.getMethod();
        for (Edge callEdge : PTABridge.v().outgoingEdges(callerMethodContext, stmt)) {
            MethodOrMethodContext calleeMethodContext = callEdge.getTgt();
            SootMethod calleeMethod = calleeMethodContext.method();
            if (!(API.v().isSystemMethod(callerMethod)) && API.v().isSystemMethod(calleeMethod)) {
                if (API.v().hasSourceInfoKind(calleeMethod)
                        || (Config.v().infoFlowTrackAll && !(calleeMethod.getDeclaringClass().getPackageName().equals("java.lang")))) {
                    values.add(InfoUnit.v(stmt));
                }
            }
        }
        return values;
    }

    private void doAnalysis() {
        Set<SootMethod> methods = PTABridge.v().getReachableMethods();
        for (SootMethod method : methods) {
            if (method.hasActiveBody() && !(SootUtils.isRuntimeStubMethod(method)) && !(ObjectUtils.v().isAddTaint(method)) && !(ObjectUtils.v().isGetTaint(method))) {
                List<Block> blocks = InterproceduralControlFlowGraph.v().methodToBlocks.get(method);
                Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
                for (MethodOrMethodContext methodContext : methodContexts) {
                    HashSet<InfoValue> values = new HashSet<InfoValue>();
                    for (Block block : blocks) {
                        Iterator<Unit> units = block.iterator();
                        while (units.hasNext()) {
                            Unit unit = units.next();
                            Set<InfoValue> vs = null;
                            if (unit instanceof AssignStmt) {
                                vs = getInjectedValues((AssignStmt)unit, methodContext);
                            }
                            if (vs != null) {
                                values.addAll(vs);
                            }
                        }
                    }
                    this.methodContextToValues.put(methodContext, values);
                }
            }
        }
    }

    private Map<MethodOrMethodContext, ImmutableSet<InfoValue>> methodContextToValuesRecursively = new HashMap<MethodOrMethodContext, ImmutableSet<InfoValue>>();
    private TransitiveTargets transitiveTargets = new TransitiveTargets(Scene.v().getCallGraph());

    ImmutableSet<InfoValue> getRecursively(MethodOrMethodContext methodContext) {
        if (this.methodContextToValuesRecursively.containsKey(methodContext)) {
            return this.methodContextToValuesRecursively.get(methodContext);
        }

        HashSet<InfoValue> values = new HashSet<InfoValue>(this.methodContextToValues.get(methodContext));
        Iterator<MethodOrMethodContext> tgtMethodContexts = this.transitiveTargets.iterator(methodContext);
        while (tgtMethodContexts.hasNext()) {
            MethodOrMethodContext tgtMethodContext = tgtMethodContexts.next();
            Set<InfoValue> vs = this.methodContextToValues.get(tgtMethodContext);
            values.addAll(vs);
        }
        ImmutableSet<InfoValue> vs = ImmutableSet.copyOf(values);
        this.methodContextToValuesRecursively.put(methodContext, vs);
        return vs;
    }
}