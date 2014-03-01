package droidsafe.analyses.infoflow;

import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

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
import soot.jimple.AbstractStmtSwitch;
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
import soot.jimple.ReturnStmt;
import soot.jimple.ReturnVoidStmt;
import soot.jimple.StaticFieldRef;
import soot.jimple.Stmt;
import soot.jimple.UnopExpr;
import soot.jimple.VirtualInvokeExpr;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.callgraph.Targets;
import soot.jimple.toolkits.callgraph.TransitiveTargets;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.toolkits.graph.Block;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.system.API;
import droidsafe.main.Config;
import droidsafe.transforms.UnmodeledGeneratedClasses;
import droidsafe.utils.SootUtils;

/**
 * Information Flow Analysis
 */
public class InformationFlowAnalysis {
    private static InformationFlowAnalysis v;

    private State state = new State();
    
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
                ImmutableSet<InfoValue> vs = this.state.instances.get(allocNodeField);
                values.addAll(vs);
            }
        }

        Set<IAllocNode> allocNodes = AllocNodesReadAnalysis.v().getRecursively(methodContext);
        for (IAllocNode allocNode : allocNodes) {
            if (reachableAllocNodes.contains(allocNode)) {
                ImmutableSet<InfoValue> vs = this.state.arrays.get(allocNode);
                values.addAll(vs);
            }
        }

        return values;
    }

    public Set<InfoValue> getTaints(MethodOrMethodContext methodContext) {
        Set<InfoValue> values = new HashSet<InfoValue>();

        Set<AllocNodeField> allocNodeFields = AllocNodeFieldsReadAnalysis.v().getRecursively(methodContext);
        for (AllocNodeField allocNodeField : allocNodeFields) {
            ImmutableSet<InfoValue> vs = this.state.instances.get(allocNodeField);
            values.addAll(vs);
        }

        Set<IAllocNode> allocNodes = AllocNodesReadAnalysis.v().getRecursively(methodContext);
        for (IAllocNode allocNode : allocNodes) {
            ImmutableSet<InfoValue> vs = this.state.arrays.get(allocNode);
            values.addAll(vs);
        }

        Set<SootField> fields = FieldsReadAnalysis.v().getRecursively(methodContext);
        for (SootField field : fields) {
            ImmutableSet<InfoValue> vs = this.state.statics.get(field);
            values.addAll(vs);
        }

        ImmutableSet<InfoValue> vs = InjectedValuesAnalysis.v().getRecursively(methodContext);
        values.addAll(vs);

        return values;
    }

    public Set<InfoValue> getTaints(Stmt stmt, MethodOrMethodContext srcMethodContext, Local local) {
        assert srcMethodContext.method().getActiveBody().getUnits().contains(stmt);
        assert local.getType() instanceof PrimType;
        Context context = srcMethodContext.context();
        return this.state.locals.get(context, local);
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
                        ImmutableSet<InfoValue> vs = this.state.instances.get(reachableAllocNode, field);
                        values.addAll(vs);
                    }
                } else if (allocNode instanceof soot.jimple.paddle.AllocNode) {
                    Iterator allocDotFields = ((soot.jimple.paddle.AllocNode)allocNode).fields();
                    while (allocDotFields.hasNext()) {
                        soot.jimple.paddle.AllocDotField allocDotField = (soot.jimple.paddle.AllocDotField)allocDotFields.next();
                        SootField field = (SootField)allocDotField.field();
                        ImmutableSet<InfoValue> vs = this.state.instances.get(reachableAllocNode, field);
                        values.addAll(vs);
                    }
                }
            } else if (type instanceof ArrayType) {
                ImmutableSet<InfoValue> vs = this.state.arrays.get(reachableAllocNode);
                values.addAll(vs);
            }
        }
        return values;
    }

    private InformationFlowAnalysis() {
        doAnalysis();
    }

    private void doAnalysis() {
        boolean hasChanged;
        
        do {
            hasChanged = false;
            State state = new State(this.state);
            for (Block block : InterproceduralControlFlowGraph.v()) {
                execute(block, state);
            }
            if (!(this.state.equals(state))) {
                this.state = state;
                hasChanged = true;
            }
            G.v().out.println("locals.size() = " + this.state.locals.size());
           G.v().out.println("instances.size() = " + this.state.instances.size());
            G.v().out.println("arrays.size() = " + this.state.arrays.size());
           G.v().out.println("statics.size() = " + this.state.statics.size());
        } while (hasChanged);
    }

    private void execute(Block block, State state) {
        Iterator<Unit> units = block.iterator();
        while (units.hasNext()) {
            Unit unit = units.next();
            execute(unit, state);
        }
    }

    private void execute(final Unit unit, final State state) {
        AbstractStmtSwitch stmtSwitch = new AbstractStmtSwitch() {
            @Override
            public void caseAssignStmt(AssignStmt stmt) {
                execute(stmt, state);
            }

            @Override
            public void caseIdentityStmt(IdentityStmt stmt) {
                // Do nothing.
            }

            @Override
            public void caseInvokeStmt(InvokeStmt stmt) {
                // invoke_stmt = invoke_expr;
                execute(stmt, stmt.getInvokeExpr(), state);
            }

            @Override
            public void caseReturnStmt(ReturnStmt stmt) {
                execute(stmt, state);
            }

            @Override
            public void caseReturnVoidStmt(ReturnVoidStmt stmt) {
                // Do nothing.
            }

            @Override
            public void defaultCase(Object stmt) {
                // Do nothing.
            }
        };
        unit.apply(stmtSwitch);
    }

    // stmt = assign_stmt
    private void execute(final AssignStmt stmt, final State state) {
        // assign_stmt = variable "=" rvalue;
        Value lValue = stmt.getLeftOp();
        MyAbstractVariableSwitch lValueSwitch = new MyAbstractVariableSwitch() {
            @Override
            public void caseLocal(Local lLocal) {
                execute(stmt, lLocal, state);
            }

            @Override
            public void caseInstanceFieldRef(InstanceFieldRef instanceFieldRef) {
                Immediate rImmediate = (Immediate)stmt.getRightOp();
                execute(stmt, instanceFieldRef, rImmediate, state);
            }

            @Override
            public void caseStaticFieldRef(StaticFieldRef staticFieldRef) {
                Immediate rImmediate = (Immediate)stmt.getRightOp();
                execute(stmt, staticFieldRef, rImmediate, state);
            }

            @Override
            public void caseArrayRef(ArrayRef arrayRef) {
                Immediate rImmediate = (Immediate)stmt.getRightOp();
                execute(stmt, arrayRef, rImmediate, state);
            }
        };
        lValue.apply(lValueSwitch);
    }

    // assign_stmt = local "=" rvalue
    private void execute(final AssignStmt stmt, final Local lLocal, final State state) {
        // rvalue = array_ref | constant | expr | instance_field_ref | local | next_next_stmt_address | static_field_ref;
        MyAbstractRValueSwitch rValueSwitch = new MyAbstractRValueSwitch() {
            @Override
            public void caseConstant(Constant constant) {
                // local "=" constant
                // Do nothing.
            }

            @Override
            public void caseLocal(Local rLocal) {
                // local "=" local
                execute(stmt, lLocal, rLocal, state);
            }

            @Override
            public void caseInstanceFieldRef(InstanceFieldRef instanceFieldRef) {
                // local "=" instance_field_ref
                execute(stmt, lLocal, instanceFieldRef, state);
            }

            @Override
            public void caseStaticFieldRef (StaticFieldRef staticFieldRef) {
                // local "=" static_field_ref
                execute(stmt, lLocal, staticFieldRef, state);
            }

            @Override
            public void caseArrayRef(ArrayRef arrayRef) {
                // local "=" array_ref
                execute(stmt, lLocal, arrayRef, state);
            }

            @Override
            public void caseNewExpr(NewExpr newExpr) {
                // local "=" new_expr
                // Do nothing.
            }

            @Override
            public void caseNewArrayExpr(NewArrayExpr newArrayExpr) {
                // local "=" new_array_expr
                execute(stmt, lLocal, newArrayExpr, state);
            }

            @Override
            public void caseNewMultiArrayExpr(NewMultiArrayExpr newMultiArrayExpr) {
                // local "=" new_multi_array_expr
                execute(stmt, lLocal, newMultiArrayExpr, state);
            }

            @Override
            public void caseCastExpr(CastExpr castExpr) {
                // local "=" cast_expr
                execute(stmt, lLocal, castExpr, state);
            }

            @Override
            public void caseInstanceOfExpr(InstanceOfExpr instanceOfExpr) {
                // local "=" instance_of_expr
                execute(stmt, lLocal, instanceOfExpr, state);
            }

            @Override
            public void caseUnopExpr(UnopExpr unopExpr) {
                // local "=" unop_expr
                // unop_expr = length_expr | neg_expr
                execute(stmt, lLocal, unopExpr, state);
            }

            @Override
            public void caseBinopExpr(BinopExpr binopExpr) {
                // local "=" binop_expr
                execute(stmt, lLocal, binopExpr, state);
            }

            @Override
            public void caseInvokeExpr(InvokeExpr invokeExpr) {
                // local "=" invoke_expr
                // invoke_expr = interface_invoke_expr | special_invoke_expr | static_invoke_expr | virtual_invoke_expr;
                assert !(invokeExpr instanceof DynamicInvokeExpr);
                execute(stmt, invokeExpr, state);
            }
        };
        stmt.getRightOp().apply(rValueSwitch);
    }

    // assign_stmt = local "=" local
    private void execute(AssignStmt stmt, Local lLocal, Local rLocal, State state) {
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
                ImmutableSet<InfoValue> values = state.locals.get(context, rLocal);
                state.locals.putW(context, lLocal, values);
            }
        }
    }

    // assign_stmt = local "=" instance_field_ref
    private void execute(AssignStmt stmt, Local lLocal, InstanceFieldRef instanceFieldRef, State state) {
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
                Set<IAllocNode> allocNodes = (Set<IAllocNode>)PTABridge.v().getPTSet(baseLocal, context);
                for (IAllocNode allocNode : allocNodes) {
                    ImmutableSet<InfoValue> vs = state.instances.get(allocNode, field);
                    values.addAll(vs);
                    if (UnmodeledGeneratedClasses.v().isGeneratedNode((AllocNode)allocNode)) {
                        values.add(API.v().UNMODELED);
                    }
                }
                state.locals.putW(context, lLocal, values);
            }
        }
    }

    // assign_stmt = local "=" static_field_ref
    private void execute(AssignStmt stmt, Local lLocal, StaticFieldRef staticFieldRef, State state) {
        if (lLocal.getType() instanceof RefLikeType) {
            assert staticFieldRef.getType() instanceof RefLikeType;
        } else {
            assert !(staticFieldRef.getType() instanceof RefLikeType);
            Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
            Body body = block.getBody();
            SootMethod method = body.getMethod();
            // static_field_ref = "[" field_signature "]"
            SootField field = staticFieldRef.getField();
            ImmutableSet<InfoValue> values = state.statics.get(field);
            Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
            for (MethodOrMethodContext methodContext : methodContexts) {
                Context context = methodContext.context();
                state.locals.putW(context, lLocal, values);
            }
        }
    }

    // assign_stmt = local "=" array_ref
    private void execute(AssignStmt stmt, Local lLocal, ArrayRef arrayRef, State state) {
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
                Set<IAllocNode> allocNodes = (Set<IAllocNode>)PTABridge.v().getPTSet(baseLocal, context);
                for (IAllocNode allocNode : allocNodes) {
                    ImmutableSet<InfoValue> vs = state.arrays.get(allocNode);
                    values.addAll(vs);
                }
                state.locals.putW(context, lLocal, values);
            }
        }
    }

    // assign_stmt = local "=" new_array_expr
    private void execute(AssignStmt stmt, Local lLocal, NewArrayExpr newArrayExpr, State state) {
        assert lLocal.getType() instanceof RefLikeType;
        Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
        Body body = block.getBody();
        SootMethod method = body.getMethod();
        // new_array_expr = "new" type "[" immediate "]";
        Immediate sizeImmediate = (Immediate)newArrayExpr.getSize();
        Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
        for (MethodOrMethodContext methodContext : methodContexts) {
            Context context = methodContext.context();
            ImmutableSet<InfoValue> values = evaluate(context, sizeImmediate, state.locals);
            if (!(values.isEmpty())) {
                Set<IAllocNode> allocNodes = (Set<IAllocNode>)PTABridge.v().getPTSet(lLocal, context);
                for (IAllocNode allocNode : allocNodes) {
                    state.instances.putW(allocNode, ObjectUtils.v().taint, values);
                }
            }
        }
    }

    // assign_stmt = local "=" new_multi_array_expr
    private void execute(AssignStmt stmt, Local lLocal, NewMultiArrayExpr newMultiArrayExpr, State state) {
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
                ImmutableSet<InfoValue> sizeValues = evaluate(context, sizeImmediate, state.locals);
                values.addAll(sizeValues);
            }
            if (!(values.isEmpty())) {
                Set<IAllocNode> allocNodes = (Set<IAllocNode>)PTABridge.v().getPTSet(lLocal, context);
                for (IAllocNode allocNode : allocNodes) {
                    state.instances.putW(allocNode, ObjectUtils.v().taint, ImmutableSet.<InfoValue>copyOf(values));
                }
            }
        }
    }

    // assign_stmt = local "=" cast_expr
    private void execute(final AssignStmt stmt, final Local lLocal, final CastExpr castExpr, final State state) {
        MyAbstractImmediateSwitch immediateSwitch = new MyAbstractImmediateSwitch() {
            // immediate = local;
            @Override
            public void caseLocal(Local local) {
                execute(stmt, lLocal, castExpr, local, state);
            }

            // immediate = constant
            @Override
            public void caseConstant(Constant constant) {
                // Do nothing.
            }
        };
        // cast_expr = "(" type ")" immediate
        Immediate opImmediate = (Immediate)castExpr.getOp();
        opImmediate.apply(immediateSwitch);
    }

    // assign_stmt = local "=" "(" type ")" local
    private void execute(AssignStmt stmt, Local lLocal, CastExpr castExpr, Local rLocal, State state) {
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
                ImmutableSet<InfoValue> values = state.locals.get(context, rLocal);
                state.locals.putW(context, lLocal, values);
            }
        }
    }

    // assigin_stmt = local "=" instance_of_expr
    private void execute(AssignStmt stmt, Local lLocal, InstanceOfExpr instanceOfExpr, State state) {
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
            Set<IAllocNode> allocNodes = (Set<IAllocNode>)PTABridge.v().getPTSet(opLocal, context);
            for (IAllocNode allocNode : allocNodes) {
                ImmutableSet<InfoValue> vs = state.instances.get(allocNode, ObjectUtils.v().taint);
                values.addAll(vs);
            }
            state.locals.putW(context, lLocal, values);
        }
    }

    // assign_stmt = local "=" unop_expr
    private void execute(final AssignStmt stmt, final Local lLocal, UnopExpr unopExpr, final State state) {
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
                    ImmutableSet<InfoValue> values = evaluate(context, opImmediate, state.locals);
                    state.locals.putW(context, lLocal, values);
                }
            }

            @Override
            public void caseLengthExpr(LengthExpr lengthExpr) {
                assert opImmediate instanceof Local;
                Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
                for (MethodOrMethodContext methodContext : methodContexts) {
                    Context context = methodContext.context();
                    HashSet<InfoValue> values = new HashSet<InfoValue>();
                    Set<IAllocNode> allocNodes = (Set<IAllocNode>)PTABridge.v().getPTSet(opImmediate, context);
                    for (IAllocNode allocNode : allocNodes) {
                        ImmutableSet<InfoValue> vs = state.instances.get(allocNode, ObjectUtils.v().taint);
                        values.addAll(vs);
                    }
                    state.locals.putW(context, lLocal, values);
                }
            }
        };
        unopExpr.apply(unopExprSwitch);
    }

    // assign_stmt = local "=" binop_expr
    private void execute(AssignStmt stmt, Local lLocal, BinopExpr binopExpr, State state) {
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
                        Set<IAllocNode> allocNodes = (Set<IAllocNode>)PTABridge.v().getPTSet(immediates[i], context);
                        for (IAllocNode allocNode : allocNodes) {
                            ImmutableSet<InfoValue> vs = state.instances.get(allocNode, ObjectUtils.v().taint);
                            values.addAll(vs);
                        }
                    }
                }
                state.locals.putW(context, lLocal, values);
            }
        } else {
            assert immediates[0].getType() instanceof PrimType;
            assert immediates[1].getType() instanceof PrimType;
            Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
            for (MethodOrMethodContext methodContext : methodContexts) {
                Context context = methodContext.context();
                HashSet<InfoValue> values = new HashSet<InfoValue>();
                for (Immediate immediate : immediates) {
                    ImmutableSet<InfoValue> vs = evaluate(context, immediate, state.locals);
                    values.addAll(vs);
                }
                state.locals.putW(context, lLocal, values);
            }
        }
    }

    // assign_stmt = instance_field_ref "=" immediate
    private void execute(final AssignStmt stmt, final InstanceFieldRef instanceFieldRef, Immediate immediate, final State state) {
        MyAbstractImmediateSwitch immediateSwitch = new MyAbstractImmediateSwitch() {
            @Override
            public void caseLocal(Local rLocal) {
                // instance_field_ref "=" local
                execute(stmt, instanceFieldRef, rLocal, state);
            }

            @Override
            public void caseConstant(Constant constant) {
                // instance_field_ref "=" constant
                // Do nothing.
            }
        };
        immediate.apply(immediateSwitch);
    }

    // assign_stmt = instance_field_ref "=" local
    private void execute(AssignStmt stmt, InstanceFieldRef instanceFieldRef, Local rLocal, State state) {
        if (!(instanceFieldRef.getType() instanceof RefLikeType)) {
            Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
            Body body = block.getBody();
            SootMethod method = body.getMethod();
            Local baseLocal = (Local)instanceFieldRef.getBase();
            SootField field = instanceFieldRef.getField();
            Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
            for (MethodOrMethodContext methodContext : methodContexts) {
                Context context = methodContext.context();
                ImmutableSet<InfoValue> values = evaluate(context, rLocal, state.locals);
                if (!(values.isEmpty())) {
                    Set<IAllocNode> allocNodes = (Set<IAllocNode>)PTABridge.v().getPTSet(baseLocal, context);
                    for (IAllocNode allocNode : allocNodes) {
                        state.instances.putW(allocNode, field, values);
                    }
                }
            }
        }
    }

    // assign_stmt = static_field_ref "=" immediate
    private void execute(final AssignStmt stmt, final StaticFieldRef staticFieldRef, Immediate rImmediate, final State state) {
        MyAbstractImmediateSwitch immediateSwitch = new MyAbstractImmediateSwitch() {
            @Override
            public void caseLocal(Local rLocal) {
                // static_field_ref "=" local
                execute(stmt, staticFieldRef, rLocal, state);
            }

            @Override
            public void caseConstant(Constant constant) {
                // static_field_ref "=" constant
                assert !(constant instanceof ClassConstant);
                // DO nothing.
            }
        };
        rImmediate.apply(immediateSwitch);
    }

    // assign_stmt = static_field_ref "=" local
    private void execute(AssignStmt stmt, StaticFieldRef staticFieldRef, Local rLocal, State state) {
        if (!(staticFieldRef.getType() instanceof RefLikeType)) {
            Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
            Body body = block.getBody();
            SootMethod method = body.getMethod();
            SootField field = staticFieldRef.getField();
            Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
            for (MethodOrMethodContext methodContext : methodContexts) {
                Context context = methodContext.context();
                ImmutableSet<InfoValue> values = evaluate(context, rLocal, state.locals);
                state.statics.putW(field, values);
            }
        }
    }

    // assign_stmt = array_ref "=" immediate
    private void execute(final AssignStmt stmt, final ArrayRef arrayRef, Immediate immediate, final State state) {
        MyAbstractImmediateSwitch immediateSwitch = new MyAbstractImmediateSwitch() {
            @Override
            public void caseLocal(Local rLocal) {
                // array_ref "=" local
                execute(stmt, arrayRef, rLocal, state);
            }

            @Override
            public void caseConstant(Constant constant) {
                // array_ref "=" constant
                // Do nothing.
            }
        };
        immediate.apply(immediateSwitch);
    }

    // assign_stmt = array_ref "=" local
    private void execute(AssignStmt stmt, ArrayRef arrayRef, Local rLocal, State state) {
        if (!(arrayRef.getType() instanceof RefLikeType)) {
            Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
            Body body = block.getBody();
            SootMethod method = body.getMethod();
            Local baseLocal = (Local)arrayRef.getBase();
            Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
            for (MethodOrMethodContext methodContext : methodContexts) {
                Context context = methodContext.context();
                ImmutableSet<InfoValue> values = evaluate(context, rLocal, state.locals);
                if (!(values.isEmpty())) {
                    Set<IAllocNode> allocNodes = (Set<IAllocNode>)PTABridge.v().getPTSet(baseLocal, context);
                    for (IAllocNode allocNode : allocNodes) {
                        state.arrays.putW(allocNode, values);
                    }
                }
            }
        }
    }

    // stmt = assign_stmt | invoke_stmt
    // assign_stmt = local "=" invoke_expr
    // invoke_stmt = invoke_expr
    // invoke_expr = interface_invoke_expr | special _invoke_expr | static_invoke_expr | virtual_invoke_expr
    // interface_invoke_expr = "interfaceinvoke" immediate ".[" + method_signature "]" "(" immediate_list ")"
    // special_invoke_expr = "specialinvoke" immediate ".[" method_signature "]" "(" immediate_list ")"
    // static_invoke_expr = "staticinvoke" "[" method_signature "]" "(" immediate_list ")"
    // virtual_invoke_expr = "virtualinvoke" immediate ".[" method_signamter "]" "(" immediate_list ")"
    private void execute(Stmt stmt, InvokeExpr invokeExpr, State state) {
        SootMethod invokeMethod = invokeExpr.getMethod();
        if (ObjectUtils.v().isAddTaint(invokeMethod)) {
            executeAddTaint(stmt, invokeExpr, state);
        } else if (ObjectUtils.v().isGetTaint(invokeMethod)) {
            executeGetTaint(stmt, invokeExpr, state);
        }

        Block callerBlock = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
        Body callerBody = callerBlock.getBody();
        SootMethod callerMethod = callerBody.getMethod();
        HashMap<Context, HashSet<InfoValue>[]> contextToArguments = new HashMap<Context, HashSet<InfoValue>[]>();
        int argumentCount = invokeExpr.getArgCount();
        List<Value> argumentImmediates = invokeExpr.getArgs();
        Set<MethodOrMethodContext> callerMethodContexts = PTABridge.v().getMethodContexts(callerMethod);
        for (MethodOrMethodContext callerMethodContext : callerMethodContexts) {
            Context callerContext = callerMethodContext.context();
            List<Edge> callEdges = PTABridge.v().outgoingEdges(callerMethodContext, stmt);
            for (Edge callEdge : callEdges) {
                MethodOrMethodContext calleeMethodContext = callEdge.getTgt();
                SootMethod calleeMethod = calleeMethodContext.method();
                if (calleeMethod.hasActiveBody() && !(SootUtils.isRuntimeStubMethod(calleeMethod))) {
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
                            ImmutableSet<InfoValue> values = evaluate(callerContext, immediate, state.locals);
                            argumentValues[i].addAll(values);
                        }
                    }
                }
            }
        }
        for (MethodOrMethodContext callerMethodContext : callerMethodContexts) {
            List<Edge> callEdges = PTABridge.v().outgoingEdges(callerMethodContext, stmt);
            for (Edge callEdge : callEdges) {
                MethodOrMethodContext calleeMethodContext = callEdge.getTgt();
                SootMethod calleeMethod = calleeMethodContext.method();
                if (calleeMethod.hasActiveBody() && !(SootUtils.isRuntimeStubMethod(calleeMethod))) {
                    Context calleeContext = calleeMethodContext.context();
                    HashSet<InfoValue>[] argumentValues = contextToArguments.get(calleeContext);
                    Local[] parameterLocals = getParameterLocals(calleeMethod);
                    for (int i = 0; i < parameterLocals.length; i++) {
                        Local local = parameterLocals[i]; 
                        if (!(local.getType() instanceof RefLikeType)) {
                            state.locals.putW(calleeContext, parameterLocals[i], argumentValues[i]);
                        }
                    }
                }
            }
        }
    }

    private void executeGetTaint(Stmt stmt, InvokeExpr invokeExpr, State state) {
        Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
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
                Set<IAllocNode> allocNodes = (Set<IAllocNode>)PTABridge.v().getPTSet(baseLocal, context);
                for (IAllocNode allocNode : allocNodes) {
                    ImmutableSet<InfoValue> vs = state.instances.get(allocNode, ObjectUtils.v().taint);
                    values.addAll(vs);
                }
                state.locals.putW(context, lLocal, values);
            }
        }
    }

    private void executeAddTaint(Stmt stmt, InvokeExpr invokeExpr, State state) {
        Block block = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt);
        Body body = block.getBody();
        SootMethod method = body.getMethod();
        Local baseLocal = (Local)((VirtualInvokeExpr)invokeExpr).getBase();
        Immediate argImmediate = (Immediate)invokeExpr.getArg(0);
        if (argImmediate instanceof Local) {
            Set<MethodOrMethodContext> methodContexts = PTABridge.v().getMethodContexts(method);
            for (MethodOrMethodContext methodContext : methodContexts) {
                Context context = methodContext.context();
                ImmutableSet<InfoValue> values = state.locals.get(context, (Local)argImmediate);
                Set<IAllocNode> allocNodes = (Set<IAllocNode>)PTABridge.v().getPTSet(baseLocal, context);
                for (IAllocNode allocNode : allocNodes) {
                    state.instances.putW(allocNode, ObjectUtils.v().taint, values);
                }
            }
        }
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

    // stmt = return_stmt
    private void execute(ReturnStmt stmt, State state) {
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
                                    state.instances.putW(allocNode, ObjectUtils.v().taint, values);
                                }
                            }
                        }
                    } else {
                        HashSet<InfoValue> values = new HashSet<InfoValue>(evaluate(calleeContext, returnImmediate, state.locals));
                        if (!(API.v().isSystemMethod(callerMethod)) && API.v().isSystemMethod(calleeMethod)) {
                            if (API.v().hasSourceInfoKind(calleeMethod)
                                    || (Config.v().infoFlowTrackAll && !(calleeMethod.getDeclaringClass().getPackageName().equals("java.lang")))) {
                                values.add(InfoUnit.v(callStmt));
                            }
                        }
                        Local lLocal = (Local)((AssignStmt)callStmt).getLeftOp();
                        state.locals.putW(callerContext, lLocal, values);
                    }
                }
            }
        }
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
    
    public void printContextLocals(String value, Writer writer) throws IOException {
        this.state.locals.printContextLocals(value, writer);
    }
    
    public void printAllocNodeFields(String value, Writer writer) throws IOException {
        this.state.instances.printAllocNodeFields(value, writer);
    }

    public void printAllocNodes(String value, Writer writer) throws IOException {
        this.state.arrays.printAllocNodes(value, writer);
    }

    public void printFields(String value, Writer writer) throws IOException {
        this.state.statics.printFields(value, writer);
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
            Set<IAllocNode> allocNodes = (Set<IAllocNode>)PTABridge.v().getPTSet(local, context);
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