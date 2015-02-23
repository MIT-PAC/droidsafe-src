package droidsafe.analyses.infoflow;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.ArrayType;
import soot.Body;
import soot.Context;
import soot.G;
import soot.Immediate;
import soot.Local;
import soot.MethodContext;
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
import soot.jimple.IfStmt;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InstanceOfExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.LengthExpr;
import soot.jimple.LookupSwitchStmt;
import soot.jimple.NeExpr;
import soot.jimple.NegExpr;
import soot.jimple.NewArrayExpr;
import soot.jimple.NewExpr;
import soot.jimple.NewMultiArrayExpr;
import soot.jimple.ReturnStmt;
import soot.jimple.ReturnVoidStmt;
import soot.jimple.StaticFieldRef;
import soot.jimple.Stmt;
import soot.jimple.StringConstant;
import soot.jimple.TableSwitchStmt;
import soot.jimple.UnopExpr;
import soot.jimple.VirtualInvokeExpr;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.NoContext;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.callgraph.EdgePredicate;
import soot.jimple.toolkits.callgraph.Filter;
import soot.jimple.toolkits.callgraph.TransitiveTargets;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.toolkits.graph.Block;
import soot.toolkits.graph.DominatorNode;

import com.google.common.collect.ImmutableSet;

import droidsafe.analyses.errorhandling.ErrorHandlingAnalysis;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.system.API;
import droidsafe.android.system.InfoKind;
import droidsafe.main.Config;
import droidsafe.transforms.NativeMethodBuilder;
import droidsafe.transforms.UnmodeledGeneratedClasses;
import droidsafe.utils.SootUtils;

/**
 * Information Flow Analysis
 */
public class InformationFlowAnalysis {

	private static final Logger logger = LoggerFactory
			.getLogger(InformationFlowAnalysis.class);

	private static InformationFlowAnalysis v;

	/**
	 * Returns the singleton InformationFlowAnalysis object.
	 * 
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
	}

	final ObjectUtils objectUtils;
	final DSUtilsUtils dsUtilsUtils;
	final SuperControlFlowGraph superControlFlowGraph;

	private final AllocNodeFieldsReadAnalysis allocNodeFieldsReadAnalysis;
	private final AllocNodesReadAnalysis allocNodesReadAnalysis;
	private final FieldsReadAnalysis fieldsReadAnalysis;
	private final InjectedValuesAnalysis injectedValuesAnalysis;

	private final AllocNodeUtils allocNodeUtils;

	private InformationFlowAnalysis() {
		ContextLocal.invalidateCache();
		AllocNodeField.invalidateCache();

		this.objectUtils = new ObjectUtils();
		this.dsUtilsUtils = new DSUtilsUtils();
		this.superControlFlowGraph = new SuperControlFlowGraph(this.objectUtils);

		this.allocNodeFieldsReadAnalysis = new AllocNodeFieldsReadAnalysis(
				this.objectUtils, this.superControlFlowGraph);
		this.allocNodesReadAnalysis = new AllocNodesReadAnalysis(
				this.objectUtils, this.superControlFlowGraph);
		this.fieldsReadAnalysis = new FieldsReadAnalysis(this.objectUtils,
				this.superControlFlowGraph);
		this.injectedValuesAnalysis = new InjectedValuesAnalysis(
				this.objectUtils, this.superControlFlowGraph);

		doAnalysis();

		this.allocNodeUtils = new AllocNodeUtils();
	}

	/**
	 * Given an alloc node and a calling context, return the taint of the
	 * allocnode that is accessed in all code reachable from the method context.
	 */
	public Set<InfoValue> getTaints(IAllocNode rootAllocNode,
			MethodOrMethodContext methodContext) {
		Set<InfoValue> values = new HashSet<InfoValue>();

		Set<IAllocNode> reachableAllocNodes = this.allocNodeUtils
				.reachableAllocNodes(rootAllocNode);

		Set<AllocNodeField> allocNodeFields = this.allocNodeFieldsReadAnalysis
				.getRecursively(methodContext);
		for (AllocNodeField allocNodeField : allocNodeFields) {
			IAllocNode allocNode = allocNodeField.allocNode;
			if (reachableAllocNodes.contains(allocNode)) {
				ImmutableSet<InfoValue> vs = this.state.instances
						.get(allocNodeField);
				values.addAll(vs);
			}
		}

		Set<IAllocNode> allocNodes = this.allocNodesReadAnalysis
				.getRecursively(methodContext);
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

		Set<AllocNodeField> allocNodeFields = this.allocNodeFieldsReadAnalysis
				.getRecursively(methodContext);
		for (AllocNodeField allocNodeField : allocNodeFields) {
			ImmutableSet<InfoValue> vs = this.state.instances
					.get(allocNodeField);
			values.addAll(vs);
		}

		Set<IAllocNode> allocNodes = this.allocNodesReadAnalysis
				.getRecursively(methodContext);
		for (IAllocNode allocNode : allocNodes) {
			ImmutableSet<InfoValue> vs = this.state.arrays.get(allocNode);
			values.addAll(vs);
		}

		Set<SootField> fields = this.fieldsReadAnalysis
				.getRecursively(methodContext);
		for (SootField field : fields) {
			ImmutableSet<InfoValue> vs = this.state.statics.get(field);
			values.addAll(vs);
		}

		ImmutableSet<InfoValue> vs = this.injectedValuesAnalysis
				.getRecursively(methodContext);
		values.addAll(vs);

		return values;
	}

	public Set<InfoValue> getTaints(MethodOrMethodContext srcMethodContext,
			Local local) {
		assert local.getType() instanceof PrimType;
		Context context = srcMethodContext.context();
		return this.state.locals.get(context, local);
	}

	/**
	 * Given an alloc node return a set of all taint reachable from the node.
	 * Recursively search all reachable memory (through field references).
	 */
	public Set<InfoValue> getTaints(IAllocNode allocNode) {
		HashSet<InfoValue> values = new HashSet<InfoValue>();
		Set<IAllocNode> reachableAllocNodes = this.allocNodeUtils
				.reachableAllocNodes(allocNode);
		for (IAllocNode reachableAllocNode : reachableAllocNodes) {
			Type type = reachableAllocNode.getType();
			if (type instanceof RefType) {
				// account for the taint field, which may not be present in the
				// points to analysis if not
				// accessed in reachable code
				ImmutableSet<InfoValue> taintVs = this.state.instances.get(
						reachableAllocNode, this.objectUtils.taint);
				values.addAll(taintVs);
				Set<soot.jimple.spark.pag.AllocDotField> allocDotFields = ((soot.jimple.spark.pag.AllocNode) reachableAllocNode)
						.getFields();
				for (soot.jimple.spark.pag.AllocDotField allocDotField : allocDotFields) {
					SootField field = (SootField) allocDotField.getField();
					ImmutableSet<InfoValue> vs = this.state.instances.get(
							reachableAllocNode, field);
					values.addAll(vs);
				}
			} else if (type instanceof ArrayType) {
				ImmutableSet<InfoValue> vs = this.state.instances.get(
						reachableAllocNode, this.objectUtils.taint);
				values.addAll(vs);
				vs = this.state.arrays.get(reachableAllocNode);
				values.addAll(vs);
			}
		}
		return values;
	}

	private State state = new State();

	private void doAnalysis() {
		boolean hasChanged;

		do {
			hasChanged = false;
			State state = new State(this.state);
			for (Block block : this.superControlFlowGraph) {
				execute(block, state);
			}
			if (!(this.state.equals(state))) {
				this.state = state;
				hasChanged = true;
			}
			G.v().out.println("locals.size() = " + this.state.locals.size());
			G.v().out.println("instances.size() = "
					+ this.state.instances.size());
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
				execute(stmt, state);
			}

			@Override
			public void defaultCase(Object stmt) {
				// Do nothing.
			}

			@Override
			public void caseIfStmt(IfStmt stmt) {
				execute(stmt, stmt.getCondition(), state);
			}

			@Override
			public void caseLookupSwitchStmt(LookupSwitchStmt stmt) {
				execute(stmt, stmt.getKey(), state);
			}

			@Override
			public void caseTableSwitchStmt(TableSwitchStmt stmt) {
				execute(stmt, stmt.getKey(), state);
			}
		};
		unit.apply(stmtSwitch);
	}

	private void execute(Stmt stmt, Value condVal, State state) {
		Block block = this.superControlFlowGraph.unitToBlock.get(stmt);
		Body body = block.getBody();
		SootMethod method = body.getMethod();

		// Extract all of the immediates out of condVal expression.
		Stack<Value> valStack = new Stack<Value>();
		Set<Immediate> allImmediates = new HashSet<Immediate>();
		valStack.push(condVal);
		while (!valStack.isEmpty()) {
			Value topVal = valStack.pop();
			if (topVal instanceof Immediate) {
				allImmediates.add((Immediate) topVal);
			} else if (topVal instanceof BinopExpr) {
				valStack.push(((BinopExpr) condVal).getOp1());
				valStack.push(((BinopExpr) condVal).getOp2());
			} else if (topVal instanceof UnopExpr) {
				valStack.push(((UnopExpr) condVal).getOp());
			} else {
				logger.error("What type of condition are we? {}",
						topVal.getClass());
				/*
				 * TODO: Implement cases for other expression types, such as
				 * method invocations, field accesses, array accesses, etc...
				 * 
				 * I should ask Michael about how to acquire taint for the more
				 * complicated cases, since I am sure there are probably
				 * existing mechanisms for accomplishing this.
				 */
			}
		}

		// TODO: may want to consider caching allImmediates

		// Construct post-dominator tree from the subgraph reachable
		// from block. The siblings of block in this tree will be the
		// blocks where we will propagate taint.
		DirectedSubgraph subGraph = new DirectedSubgraph(block);
		PostDominatorTree pdomTree = new PostDominatorTree(subGraph);
		Set<DominatorNode> siblings = pdomTree.siblingsOf(pdomTree
				.getDode(block));

		// Acquire the taints for all extracted immediates and over all method
		// contexts.
		for (MethodOrMethodContext methodContext : PTABridge.v().getMethodContexts(method)) {
			Context context = methodContext.context();
			if (ignoreContext(context)) {
				continue;
			}

			// Evaluate all immediate values of the condition over the current context
			Set<InfoValue> contextValues = new HashSet<InfoValue>();
			for (Immediate immediate : allImmediates) {
				ImmutableSet<InfoValue> condValues = evaluate(context,
						(Immediate) immediate, state.locals);
				contextValues.addAll(condValues);
			}

			// TODO: cache siblings for block so we don't have to recompute this

			// Copy taint from the branching block to each sibling in the
			// post-dominator tree.
			Set<MethodOrMethodContext> contexts = new HashSet<MethodOrMethodContext>();
			for (DominatorNode node : siblings) {
				Block toBlock = (Block) node.getGode();
				Map<Context, Set<InfoValue>> ctiv = state.iflows.get(toBlock);
				if (ctiv == null) {
					ctiv = new HashMap<Context, Set<InfoValue>>();
					state.iflows.put(toBlock, ctiv);
				} else {
					Set<InfoValue> existingVals = ctiv.get(context);
					if (existingVals == null) {
						existingVals = new HashSet<InfoValue>();
						ctiv.put(context, existingVals);
					}
					existingVals.addAll(contextValues);
				}

				// Find all method invocations in the current block and construct
				// a set of method contexts that is reachable  from the current
				// context.
				for (Unit unit : toBlock) {
					Stmt stmt2 = (Stmt) unit;
					if (stmt2.containsInvokeExpr()) {
						for (Edge edge : PTABridge.v().outgoingEdges(methodContext, stmt2)) {
							MethodOrMethodContext target = edge.getTgt();
							contexts.add(target);
							TransitiveTargets tt = new TransitiveTargets(Scene.v().getCallGraph());
							Iterator<MethodOrMethodContext> iter = tt.iterator(target);
							while (iter.hasNext()) {
								MethodOrMethodContext mc = iter.next();
								contexts.add(mc);
							}
						}
					}
				}
			}

			// Iterate through all reachable method contexts from the current context
			// and propagate the taint of the current method context over all blocks
			// of each reachable method context.
			for (MethodOrMethodContext mc : contexts) {
				Context context2 = methodContext.context();
				if (ignoreContext(context2)) {
					continue;
				}
				
				Body body2 = mc.method().retrieveActiveBody();
				Iterator<Unit> iter = body2.getUnits().snapshotIterator();
				while (iter.hasNext()) {
					Stmt stmt2 = (Stmt) iter.next();
					Block block2 = this.superControlFlowGraph.unitToBlock.get(stmt2);
					Map<Context, Set<InfoValue>> ctiv = state.iflows.get(block2);
					if (ctiv == null) {
						ctiv = new HashMap<Context, Set<InfoValue>>();
						state.iflows.put(block2, ctiv);
					} else {
						Set<InfoValue> existingVals = ctiv.get(mc);
						if (existingVals == null) {
							existingVals = new HashSet<InfoValue>();
							ctiv.put(context2, existingVals);
						}
						existingVals.addAll(contextValues);
					}
				}
			}
		}

		// GENERATE ALL GRAPHVIZ FILES...
		if (Config.v().debug) {
			File destDir = new File("./graphs");

			try {
				InfoBriefBlockGraph origGraph = new InfoBriefBlockGraph(body);
				origGraph.toDotFile(method, destDir, "-orig", block);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				subGraph.toDotFile(body.getMethod(), destDir, "-sub", block);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				pdomTree.toDotFile(method, destDir, "-pdom", block, siblings);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
				Immediate rImmediate = (Immediate) stmt.getRightOp();
				execute(stmt, instanceFieldRef, rImmediate, state);
			}

			@Override
			public void caseStaticFieldRef(StaticFieldRef staticFieldRef) {
				Immediate rImmediate = (Immediate) stmt.getRightOp();
				execute(stmt, staticFieldRef, rImmediate, state);
			}

			@Override
			public void caseArrayRef(ArrayRef arrayRef) {
				Immediate rImmediate = (Immediate) stmt.getRightOp();
				execute(stmt, arrayRef, rImmediate, state);
			}
		};
		lValue.apply(lValueSwitch);
	}

	// assign_stmt = local "=" rvalue
	private void execute(final AssignStmt stmt, final Local lLocal,
			final State state) {
		// rvalue = array_ref | constant | expr | instance_field_ref | local |
		// next_next_stmt_address | static_field_ref;
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
			public void caseStaticFieldRef(StaticFieldRef staticFieldRef) {
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
			public void caseNewMultiArrayExpr(
					NewMultiArrayExpr newMultiArrayExpr) {
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
				// invoke_expr = interface_invoke_expr | special_invoke_expr |
				// static_invoke_expr | virtual_invoke_expr;
				assert !(invokeExpr instanceof DynamicInvokeExpr);
				execute(stmt, invokeExpr, state);
			}
		};
		stmt.getRightOp().apply(rValueSwitch);
	}

	public static boolean ignoreContext(Context context) {
		return Config.v().ignoreNoContextFlows && context instanceof NoContext;
	}

	// assign_stmt = local "=" local
	private void execute(AssignStmt stmt, Local lLocal, Local rLocal,
			State state) {
		if (lLocal.getType() instanceof RefLikeType) {
			assert rLocal.getType() instanceof RefLikeType;
		} else {
			assert !(rLocal.getType() instanceof RefLikeType);
			Block block = this.superControlFlowGraph.unitToBlock.get(stmt);
			Body body = block.getBody();
			SootMethod method = body.getMethod();
			Set<MethodOrMethodContext> methodContexts = PTABridge.v()
					.getMethodContexts(method);
			for (MethodOrMethodContext methodContext : methodContexts) {
				Context context = methodContext.context();
				if (ignoreContext(context)) {
					continue;
				}
				ImmutableSet<InfoValue> values = state.locals.get(context,
						rLocal);
				state.locals.putW(context, lLocal, values);
			}
		}
	}

	// assign_stmt = local "=" instance_field_ref
	private void execute(AssignStmt stmt, Local lLocal,
			InstanceFieldRef instanceFieldRef, State state) {
		if (lLocal.getType() instanceof RefLikeType) {
			assert instanceFieldRef.getType() instanceof RefLikeType;
		} else {
			assert !(instanceFieldRef.getType() instanceof RefLikeType);
			Block block = this.superControlFlowGraph.unitToBlock.get(stmt);
			Body body = block.getBody();
			SootMethod method = body.getMethod();
			// instance_field_ref = immediate ".[" field_signature "]"
			Local baseLocal = (Local) instanceFieldRef.getBase();
			SootField field = instanceFieldRef.getField();
			Set<MethodOrMethodContext> methodContexts = PTABridge.v()
					.getMethodContexts(method);
			for (MethodOrMethodContext methodContext : methodContexts) {
				Context context = methodContext.context();
				if (ignoreContext(context)) {
					continue;
				}
				HashSet<InfoValue> values = new HashSet<InfoValue>();
				Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v()
						.getPTSet(baseLocal, context);
				for (IAllocNode allocNode : allocNodes) {
					ImmutableSet<InfoValue> vs = state.instances.get(allocNode,
							field);
					values.addAll(vs);
					if (UnmodeledGeneratedClasses.v().isGeneratedNode(
							(AllocNode) allocNode)) {
						values.add(API.v().UNMODELED);
					}
				}
				state.locals.putW(context, lLocal, values);
			}
		}
	}

	// assign_stmt = local "=" static_field_ref
	private void execute(AssignStmt stmt, Local lLocal,
			StaticFieldRef staticFieldRef, State state) {
		if (lLocal.getType() instanceof RefLikeType) {
			assert staticFieldRef.getType() instanceof RefLikeType;
		} else {
			assert !(staticFieldRef.getType() instanceof RefLikeType);
			Block block = this.superControlFlowGraph.unitToBlock.get(stmt);
			Body body = block.getBody();
			SootMethod method = body.getMethod();
			// static_field_ref = "[" field_signature "]"
			SootField field = staticFieldRef.getField();
			ImmutableSet<InfoValue> values = state.statics.get(field);
			Set<MethodOrMethodContext> methodContexts = PTABridge.v()
					.getMethodContexts(method);
			for (MethodOrMethodContext methodContext : methodContexts) {
				Context context = methodContext.context();
				if (ignoreContext(context)) {
					continue;
				}
				state.locals.putW(context, lLocal, values);
			}
		}
	}

	// assign_stmt = local "=" array_ref
	private void execute(AssignStmt stmt, Local lLocal, ArrayRef arrayRef,
			State state) {
		Block block = this.superControlFlowGraph.unitToBlock.get(stmt);
		Body body = block.getBody();
		SootMethod method = body.getMethod();
		// array_ref = immediate "[" immediate "]";
		Local baseLocal = (Local) arrayRef.getBase();
		Immediate indexImmediate = (Immediate) arrayRef.getIndex();
		Set<MethodOrMethodContext> methodContexts = PTABridge.v()
				.getMethodContexts(method);
		for (MethodOrMethodContext methodContext : methodContexts) {
			Context context = methodContext.context();
			if (ignoreContext(context)) {
				continue;
			}

			HashSet<InfoValue> values = new HashSet<InfoValue>();

			Set<IAllocNode> baseAllocNodes = (Set<IAllocNode>) PTABridge.v()
					.getPTSet(baseLocal, context);
			for (IAllocNode allocNode : baseAllocNodes) {
				ImmutableSet<InfoValue> baseValues = state.instances.get(
						allocNode, this.objectUtils.taint);
				values.addAll(baseValues);
			}

			if (!(Config.v().infoFlowNoArrayIndex)) {
				ImmutableSet<InfoValue> indexValues = evaluate(context,
						indexImmediate, state.locals);
				values.addAll(indexValues);
			}

			if (!(lLocal.getType() instanceof RefLikeType)) {
				for (IAllocNode allocNode : baseAllocNodes) {
					ImmutableSet<InfoValue> baseValues = state.arrays
							.get(allocNode);
					values.addAll(baseValues);
				}
			}

			if (lLocal.getType() instanceof RefLikeType) {
				Set<IAllocNode> lLocalAllocNodes = (Set<IAllocNode>) PTABridge
						.v().getPTSet(lLocal, context);
				for (IAllocNode allocNode : lLocalAllocNodes) {
					state.instances.putW(allocNode, this.objectUtils.taint,
							ImmutableSet.<InfoValue> copyOf(values));
				}
			} else {
				state.locals.putW(context, lLocal, values);
			}
		}
	}

	// assign_stmt = local "=" new_array_expr
	private void execute(AssignStmt stmt, Local lLocal,
			NewArrayExpr newArrayExpr, State state) {
		assert lLocal.getType() instanceof RefLikeType;
		Block block = this.superControlFlowGraph.unitToBlock.get(stmt);
		Body body = block.getBody();
		SootMethod method = body.getMethod();
		// new_array_expr = "new" type "[" immediate "]";
		Immediate sizeImmediate = (Immediate) newArrayExpr.getSize();
		Set<MethodOrMethodContext> methodContexts = PTABridge.v()
				.getMethodContexts(method);
		for (MethodOrMethodContext methodContext : methodContexts) {
			Context context = methodContext.context();
			if (ignoreContext(context)) {
				continue;
			}
			ImmutableSet<InfoValue> values = evaluate(context, sizeImmediate,
					state.locals);
			if (!(values.isEmpty())) {
				Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v()
						.getPTSet(lLocal, context);
				for (IAllocNode allocNode : allocNodes) {
					state.instances.putW(allocNode, this.objectUtils.taint,
							values);
				}
			}
		}
	}

	// assign_stmt = local "=" new_multi_array_expr
	private void execute(AssignStmt stmt, Local lLocal,
			NewMultiArrayExpr newMultiArrayExpr, State state) {
		assert lLocal.getType() instanceof RefLikeType;
		Block block = this.superControlFlowGraph.unitToBlock.get(stmt);
		Body body = block.getBody();
		SootMethod method = body.getMethod();
		// new_multi_array_expr = "new multiarray " type sized_dims empty_dims;
		// sized_dims = "[" immediate "]" next_sized_dims;
		// next_sized_dims = "[" immediate "]" next_sized_dims | ;
		// empty_dims = "[]" empty_dims | ;
		List<Value> sizeImmediates = newMultiArrayExpr.getSizes();
		Set<MethodOrMethodContext> methodContexts = PTABridge.v()
				.getMethodContexts(method);
		for (MethodOrMethodContext methodContext : methodContexts) {
			Context context = methodContext.context();
			if (ignoreContext(context)) {
				continue;
			}
			HashSet<InfoValue> values = new HashSet<InfoValue>();
			for (Value sizeImmediate : sizeImmediates) {
				ImmutableSet<InfoValue> sizeValues = evaluate(context,
						(Immediate) sizeImmediate, state.locals);
				values.addAll(sizeValues);
			}
			if (!(values.isEmpty())) {
				Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v()
						.getPTSet(lLocal, context);
				for (IAllocNode allocNode : allocNodes) {
					state.instances.putW(allocNode, this.objectUtils.taint,
							ImmutableSet.<InfoValue> copyOf(values));
				}
			}
		}
	}

	// assign_stmt = local "=" cast_expr
	private void execute(final AssignStmt stmt, final Local lLocal,
			final CastExpr castExpr, final State state) {
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
		Immediate opImmediate = (Immediate) castExpr.getOp();
		opImmediate.apply(immediateSwitch);
	}

	// assign_stmt = local "=" "(" type ")" local
	private void execute(AssignStmt stmt, Local lLocal, CastExpr castExpr,
			Local rLocal, State state) {
		if (lLocal.getType() instanceof RefLikeType) {
			assert castExpr.getType() instanceof RefLikeType;
			assert rLocal.getType() instanceof RefLikeType;
		} else {
			assert !(castExpr.getType() instanceof RefLikeType);
			assert !(rLocal.getType() instanceof RefLikeType);
			Block block = this.superControlFlowGraph.unitToBlock.get(stmt);
			Body body = block.getBody();
			SootMethod method = body.getMethod();
			Set<MethodOrMethodContext> methodContexts = PTABridge.v()
					.getMethodContexts(method);
			for (MethodOrMethodContext methodContext : methodContexts) {
				Context context = methodContext.context();
				if (ignoreContext(context)) {
					continue;
				}
				ImmutableSet<InfoValue> values = state.locals.get(context,
						rLocal);
				state.locals.putW(context, lLocal, values);
			}
		}
	}

	// assigin_stmt = local "=" instance_of_expr
	private void execute(AssignStmt stmt, Local lLocal,
			InstanceOfExpr instanceOfExpr, State state) {
		assert !(lLocal.getType() instanceof RefLikeType);
		Block block = this.superControlFlowGraph.unitToBlock.get(stmt);
		Body body = block.getBody();
		SootMethod method = body.getMethod();
		// instance_of_expr = immediate "instanceof" ref_type
		Local opLocal = (Local) instanceOfExpr.getOp();
		Set<MethodOrMethodContext> methodContexts = PTABridge.v()
				.getMethodContexts(method);
		for (MethodOrMethodContext methodContext : methodContexts) {
			Context context = methodContext.context();
			if (ignoreContext(context)) {
				continue;
			}
			HashSet<InfoValue> values = new HashSet<InfoValue>();
			Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v()
					.getPTSet(opLocal, context);
			for (IAllocNode allocNode : allocNodes) {
				ImmutableSet<InfoValue> vs = state.instances.get(allocNode,
						this.objectUtils.taint);
				values.addAll(vs);
			}
			state.locals.putW(context, lLocal, values);
		}
	}

	// assign_stmt = local "=" unop_expr
	private void execute(final AssignStmt stmt, final Local lLocal,
			UnopExpr unopExpr, final State state) {
		assert !(lLocal.getType() instanceof RefLikeType);
		Block block = this.superControlFlowGraph.unitToBlock.get(stmt);
		Body body = block.getBody();
		final SootMethod method = body.getMethod();
		// unop_expr = length_expr | neg_expr;
		// length_expr = "length" immediate;
		// neg_expr = "-" immediate;
		final Immediate opImmediate = (Immediate) unopExpr.getOp();
		MyAbstractUnopExprSwitch unopExprSwitch = new MyAbstractUnopExprSwitch() {
			@Override
			public void caseNegExpr(NegExpr negExpr) {
				for (MethodOrMethodContext methodContext : PTABridge.v()
						.getMethodContexts(method)) {
					Context context = methodContext.context();
					if (ignoreContext(context)) {
						continue;
					}
					ImmutableSet<InfoValue> values = evaluate(context,
							opImmediate, state.locals);
					state.locals.putW(context, lLocal, values);
				}
			}

			@Override
			public void caseLengthExpr(LengthExpr lengthExpr) {
				assert opImmediate instanceof Local;
				Set<MethodOrMethodContext> methodContexts = PTABridge.v()
						.getMethodContexts(method);
				for (MethodOrMethodContext methodContext : methodContexts) {
					Context context = methodContext.context();
					if (ignoreContext(context)) {
						continue;
					}
					HashSet<InfoValue> values = new HashSet<InfoValue>();
					Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge
							.v().getPTSet(opImmediate, context);
					for (IAllocNode allocNode : allocNodes) {
						ImmutableSet<InfoValue> vs = state.instances.get(
								allocNode,
								InformationFlowAnalysis.this.objectUtils.taint);
						values.addAll(vs);
					}
					state.locals.putW(context, lLocal, values);
				}
			}
		};
		unopExpr.apply(unopExprSwitch);
	}

	// assign_stmt = local "=" binop_expr
	private void execute(AssignStmt stmt, Local lLocal, BinopExpr binopExpr,
			State state) {
		assert !(lLocal.getType() instanceof RefLikeType);
		SootMethod method = this.superControlFlowGraph.unitToBlock.get(stmt)
				.getBody().getMethod();
		// binop_expr = immediate binop immediate
		Immediate[] immediates = { (Immediate) binopExpr.getOp1(),
				(Immediate) binopExpr.getOp2() };
		if ((binopExpr instanceof EqExpr || binopExpr instanceof NeExpr)
				&& (immediates[0].getType() instanceof RefLikeType)) {
			boolean[] isOpLocal = { immediates[0] instanceof Local,
					immediates[1] instanceof Local };
			Set<MethodOrMethodContext> methodContexts = PTABridge.v()
					.getMethodContexts(method);
			for (MethodOrMethodContext methodContext : methodContexts) {
				Context context = methodContext.context();
				if (ignoreContext(context)) {
					continue;
				}
				HashSet<InfoValue> values = new HashSet<InfoValue>();
				for (int i = 0; i < immediates.length; i++) {
					if (isOpLocal[i]) {
						Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge
								.v().getPTSet(immediates[i], context);
						for (IAllocNode allocNode : allocNodes) {
							ImmutableSet<InfoValue> vs = state.instances.get(
									allocNode, this.objectUtils.taint);
							values.addAll(vs);
						}
					}
				}
				state.locals.putW(context, lLocal, values);
			}
		} else {
			assert immediates[0].getType() instanceof PrimType;
			assert immediates[1].getType() instanceof PrimType;
			Set<MethodOrMethodContext> methodContexts = PTABridge.v()
					.getMethodContexts(method);
			for (MethodOrMethodContext methodContext : methodContexts) {
				Context context = methodContext.context();
				if (ignoreContext(context)) {
					continue;
				}
				HashSet<InfoValue> values = new HashSet<InfoValue>();
				for (Immediate immediate : immediates) {
					ImmutableSet<InfoValue> vs = evaluate(context, immediate,
							state.locals);
					values.addAll(vs);
				}
				state.locals.putW(context, lLocal, values);
			}
		}
	}

	// assign_stmt = instance_field_ref "=" immediate
	private void execute(final AssignStmt stmt,
			final InstanceFieldRef instanceFieldRef, Immediate immediate,
			final State state) {
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
	private void execute(AssignStmt stmt, InstanceFieldRef instanceFieldRef,
			Local rLocal, State state) {
		if (!(instanceFieldRef.getType() instanceof RefLikeType)) {
			Block block = this.superControlFlowGraph.unitToBlock.get(stmt);
			Body body = block.getBody();
			SootMethod method = body.getMethod();
			Local baseLocal = (Local) instanceFieldRef.getBase();
			SootField field = instanceFieldRef.getField();
			Set<MethodOrMethodContext> methodContexts = PTABridge.v()
					.getMethodContexts(method);
			for (MethodOrMethodContext methodContext : methodContexts) {
				Context context = methodContext.context();
				if (ignoreContext(context)) {
					continue;
				}
				ImmutableSet<InfoValue> values = evaluate(context, rLocal,
						state.locals);
				if (!(values.isEmpty())) {
					Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge
							.v().getPTSet(baseLocal, context);
					for (IAllocNode allocNode : allocNodes) {

						boolean isThrowable = Scene
								.v()
								.getActiveHierarchy()
								.isClassSubclassOfIncluding(
										((RefType) allocNode.getType())
												.getSootClass(),
										Scene.v().getSootClass(
												"java.lang.Throwable"));

						if (!Config.v().ignoreThrowableFlows || !isThrowable) {
							state.instances.putW(allocNode, field, values);
						}
					}
				}
			}
		}
	}

	// assign_stmt = static_field_ref "=" immediate
	private void execute(final AssignStmt stmt,
			final StaticFieldRef staticFieldRef, Immediate rImmediate,
			final State state) {
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
	private void execute(AssignStmt stmt, StaticFieldRef staticFieldRef,
			Local rLocal, State state) {
		if (!(staticFieldRef.getType() instanceof RefLikeType)) {
			Block block = this.superControlFlowGraph.unitToBlock.get(stmt);
			Body body = block.getBody();
			SootMethod method = body.getMethod();
			SootField field = staticFieldRef.getField();
			Set<MethodOrMethodContext> methodContexts = PTABridge.v()
					.getMethodContexts(method);
			for (MethodOrMethodContext methodContext : methodContexts) {
				Context context = methodContext.context();
				if (ignoreContext(context)) {
					continue;
				}
				ImmutableSet<InfoValue> values = evaluate(context, rLocal,
						state.locals);
				state.statics.putW(field, values);
			}
		}
	}

	// assign_stmt = array_ref "=" immediate
	private void execute(final AssignStmt stmt, final ArrayRef arrayRef,
			Immediate immediate, final State state) {
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
	private void execute(AssignStmt stmt, ArrayRef arrayRef, Local rLocal,
			State state) {
		if (!(arrayRef.getType() instanceof RefLikeType)) {
			Block block = this.superControlFlowGraph.unitToBlock.get(stmt);
			Body body = block.getBody();
			SootMethod method = body.getMethod();
			Local baseLocal = (Local) arrayRef.getBase();
			Set<MethodOrMethodContext> methodContexts = PTABridge.v()
					.getMethodContexts(method);
			for (MethodOrMethodContext methodContext : methodContexts) {
				Context context = methodContext.context();
				if (ignoreContext(context)) {
					continue;
				}
				ImmutableSet<InfoValue> values = evaluate(context, rLocal,
						state.locals);
				if (!(values.isEmpty())) {
					Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge
							.v().getPTSet(baseLocal, context);
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
	// invoke_expr = interface_invoke_expr | special _invoke_expr |
	// static_invoke_expr | virtual_invoke_expr
	// interface_invoke_expr = "interfaceinvoke" immediate ".[" +
	// method_signature "]" "(" immediate_list ")"
	// special_invoke_expr = "specialinvoke" immediate ".[" method_signature "]"
	// "(" immediate_list ")"
	// static_invoke_expr = "staticinvoke" "[" method_signature "]" "("
	// immediate_list ")"
	// virtual_invoke_expr = "virtualinvoke" immediate ".[" method_signature "]"
	// "(" immediate_list ")"
	private void execute(Stmt stmt, InvokeExpr invokeExpr, State state) {
		Block callerBlock = this.superControlFlowGraph.unitToBlock.get(stmt);
		Body callerBody = callerBlock.getBody();
		SootMethod callerMethod = callerBody.getMethod();
		Set<MethodOrMethodContext> callerMethodContexts = PTABridge.v()
				.getMethodContexts(callerMethod);

		// Object.addTaint, Object.getTaint*, Object.toTaint*,
		// DSUtils.dsGenerateTaint*
		for (MethodOrMethodContext callerMethodContext : callerMethodContexts) {
			Context callerContext = callerMethodContext.context();
			if (ignoreContext(callerContext)) {
				continue;
			}
			List<Edge> callEdges = PTABridge.v().outgoingEdges(
					callerMethodContext, stmt);
			for (Edge callEdge : callEdges) {
				MethodOrMethodContext calleeMethodContext = callEdge.getTgt();
				Context calleeContext = calleeMethodContext.context();
				if (ignoreContext(calleeContext)) {
					continue;
				}
				SootMethod calleeMethod = calleeMethodContext.method();
				if (this.objectUtils.isAddTaint(calleeMethod)) {
					executeAddTaint(stmt, invokeExpr, state);
					return;
				} else if (this.objectUtils.isGetTaint(calleeMethod)) {
					executeGetTaint(stmt, invokeExpr, state);
					return;
				} else if (this.objectUtils.isToTaint(calleeMethod)) {
					executeToTaint(stmt, invokeExpr, state);
					return;
				} else if (this.dsUtilsUtils.isGenerateTaint(calleeMethod)) {
					executeGenerateTaint(stmt, invokeExpr, state);
					return;
				}
			}
		}

		HashMap<Context, HashSet<InfoValue>[]> contextToArguments = new HashMap<Context, HashSet<InfoValue>[]>();
		int argumentCount = invokeExpr.getArgCount();
		List<Value> argumentImmediates = invokeExpr.getArgs();
		for (MethodOrMethodContext callerMethodContext : callerMethodContexts) {
			Context callerContext = callerMethodContext.context();
			if (ignoreContext(callerContext)) {
				continue;
			}
			List<Edge> callEdges = PTABridge.v().outgoingEdges(
					callerMethodContext, stmt);
			for (Edge callEdge : callEdges) {
				MethodOrMethodContext calleeMethodContext = callEdge.getTgt();
				Context calleeContext = calleeMethodContext.context();
				if (ignoreContext(calleeContext)) {
					continue;
				}
				SootMethod calleeMethod = calleeMethodContext.method();
				if (calleeMethod.hasActiveBody()
						&& !(SootUtils.isRuntimeStubMethod(calleeMethod))) {
					HashSet<InfoValue>[] argumentValues = contextToArguments
							.get(calleeContext);
					if (argumentValues == null) {
						argumentValues = new HashSet[argumentCount];
						for (int i = 0; i < argumentCount; i++) {
							Immediate immediate = (Immediate) argumentImmediates
									.get(i);
							if (!(immediate.getType() instanceof RefLikeType)) {
								argumentValues[i] = new HashSet<InfoValue>();
							}
						}
						contextToArguments.put(calleeContext, argumentValues);
					}
					for (int i = 0; i < argumentCount; i++) {
						Immediate immediate = (Immediate) argumentImmediates
								.get(i);
						if (!(immediate.getType() instanceof RefLikeType)) {
							ImmutableSet<InfoValue> values = evaluate(
									callerContext, immediate, state.locals);
							argumentValues[i].addAll(values);
						}
					}
				}
			}
		}

		for (MethodOrMethodContext callerMethodContext : callerMethodContexts) {
			Context callerContext = callerMethodContext.context();
			if (ignoreContext(callerContext)) {
				continue;
			}
			List<Edge> callEdges = PTABridge.v().outgoingEdges(
					callerMethodContext, stmt);
			for (Edge callEdge : callEdges) {
				MethodOrMethodContext calleeMethodContext = callEdge.getTgt();
				Context calleeContext = calleeMethodContext.context();
				if (ignoreContext(calleeContext)) {
					continue;
				}
				SootMethod calleeMethod = calleeMethodContext.method();
				if (calleeMethod.hasActiveBody()
						&& !(SootUtils.isRuntimeStubMethod(calleeMethod))
						&& !(NativeMethodBuilder.v()
								.wasNativeAppMethod(calleeMethod))) {
					HashSet<InfoValue>[] argumentValues = contextToArguments
							.get(calleeContext);
					Local[] parameterLocals = getParameterLocals(calleeMethod);
					for (int i = 0; i < parameterLocals.length; i++) {
						Local local = parameterLocals[i];
						if (!(local.getType() instanceof RefLikeType)) {
							state.locals.putW(calleeContext,
									parameterLocals[i], argumentValues[i]);
						}
					}
				}
			}
		}

		if (stmt instanceof AssignStmt) {
			Local lLocal = (Local) ((AssignStmt) stmt).getLeftOp();
			Type lLocalType = lLocal.getType();
			if (lLocalType instanceof PrimType
					|| (lLocalType instanceof ArrayType && ((ArrayType) lLocalType)
							.getElementType() instanceof PrimType)) {
				for (MethodOrMethodContext callerMethodContext : callerMethodContexts) {
					Context callerContext = callerMethodContext.context();
					if (ignoreContext(callerContext)) {
						continue;
					}
					List<Edge> callEdges = PTABridge.v().outgoingEdges(
							callerMethodContext, stmt);
					for (Edge callEdge : callEdges) {
						MethodOrMethodContext calleeMethodContext = callEdge
								.getTgt();
						Context calleeContext = calleeMethodContext.context();
						if (ignoreContext(calleeContext)) {
							continue;
						}
						SootMethod calleeMethod = calleeMethodContext.method();
						if (NativeMethodBuilder.v().wasNativeAppMethod(
								calleeMethod)) {
							HashSet<InfoValue> values = new HashSet<InfoValue>();
							for (int i = 0; i < argumentCount; i++) {
								Immediate argImmediate = (Immediate) argumentImmediates
										.get(i);
								Type argType = argImmediate.getType();
								if (argType instanceof PrimType) {
									ImmutableSet<InfoValue> vs = evaluate(
											callerContext, argImmediate,
											state.locals);
									values.addAll(vs);
								} else if (argType instanceof ArrayType
										&& ((ArrayType) argType)
												.getElementType() instanceof PrimType) {
									Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge
											.v().getPTSet(argImmediate,
													callerContext);
									for (IAllocNode allocNode : allocNodes) {
										ImmutableSet<InfoValue> vs = state.instances
												.get(allocNode,
														this.objectUtils.taint);
										values.addAll(vs);
										vs = state.arrays.get(allocNode);
										values.addAll(vs);
									}
								}
							}
							if (lLocalType instanceof PrimType) {
								state.locals
										.putW(callerContext, lLocal, values);
							} else {
								ImmutableSet<InfoValue> vs = ImmutableSet
										.copyOf(values);
								Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge
										.v().getPTSet(lLocal, callerContext);
								for (IAllocNode allocNode : allocNodes) {
									state.instances.putW(allocNode,
											this.objectUtils.taint, vs);
									state.arrays.putW(allocNode, vs);
								}
							}
						}
					}
				}
			}
		}

		// lLocal = rLocal.M()
		//
		// for each callerMethodContext = (callerMethod, callerContext),
		// for each calleeMethod (the target method of rLocal.M()) under
		// callerMethodContext),
		// if callerMethod is not a system method and calleeMethod is a system
		// method,
		// let values be {state[(allocNode, "taint")] | allocNode in
		// points-to(rLocal, callerContext)}
		// if lLocal is of primitive type
		// state[(lLocal, callerContext)] += values
		// else
		// for each allocNode in points-to(lLocal, callerContext)
		// state[(allocNode, "taint")] += values
		if (Config.v().infoFlowTransferTaintField) {
			if (stmt instanceof AssignStmt
					&& invokeExpr instanceof InstanceInvokeExpr) {
				Local lLocal = (Local) ((AssignStmt) stmt).getLeftOp();
				Type lLocalType = lLocal.getType();
				Local rLocal = (Local) ((InstanceInvokeExpr) invokeExpr)
						.getBase();
				for (MethodOrMethodContext callerMethodContext : callerMethodContexts) {
					Context callerContext = callerMethodContext.context();
					if (ignoreContext(callerContext)) {
						continue;
					}
					List<Edge> callEdges = PTABridge.v().outgoingEdges(
							callerMethodContext, stmt);
					for (Edge callEdge : callEdges) {
						MethodOrMethodContext calleeMethodContext = callEdge
								.getTgt();
						Context calleeContext = calleeMethodContext.context();
						if (ignoreContext(calleeContext)) {
							continue;
						}
						SootMethod calleeMethod = calleeMethodContext.method();
						if (!(API.v().isSystemMethod(callerMethod))
								&& API.v().isSystemMethod(calleeMethod)) {
							HashSet<InfoValue> values = new HashSet<InfoValue>();
							Set<IAllocNode> rAllocNodes = (Set<IAllocNode>) PTABridge
									.v().getPTSet(rLocal, callerContext);
							for (IAllocNode allocNode : rAllocNodes) {
								ImmutableSet<InfoValue> vs = state.instances
										.get(allocNode, this.objectUtils.taint);
								values.addAll(vs);
							}
							if (lLocalType instanceof PrimType) {
								state.locals
										.putW(callerContext, lLocal, values);
							} else {
								ImmutableSet<InfoValue> vs = ImmutableSet
										.copyOf(values);
								Set<IAllocNode> lAllocNodes = (Set<IAllocNode>) PTABridge
										.v().getPTSet(lLocal, callerContext);
								for (IAllocNode allocNode : lAllocNodes) {
									state.instances.putW(allocNode,
											this.objectUtils.taint, vs);
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Transfers taint from the reciever to the return value, for all potential
	 * allocation nodes and method contexts.
	 * 
	 * @param stmt
	 * @param invokeExpr
	 * @param state
	 */
	private void executeGetTaint(Stmt stmt, InvokeExpr invokeExpr, State state) {
		Block block = this.superControlFlowGraph.unitToBlock.get(stmt);
		Body body = block.getBody();
		SootMethod method = body.getMethod();
		if (stmt instanceof AssignStmt) {
			// local "=" "virtualinvoke" immediate ".[" Object.getTaint* "]" "("
			// ")"
			Local lLocal = (Local) ((AssignStmt) stmt).getLeftOp();
			Local baseLocal = (Local) ((VirtualInvokeExpr) invokeExpr)
					.getBase();
			Set<MethodOrMethodContext> methodContexts = PTABridge.v()
					.getMethodContexts(method);
			for (MethodOrMethodContext methodContext : methodContexts) {
				Context context = methodContext.context();
				if (ignoreContext(context)) {
					continue;
				}
				HashSet<InfoValue> values = new HashSet<InfoValue>();
				Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v()
						.getPTSet(baseLocal, context);
				for (IAllocNode allocNode : allocNodes) {
					ImmutableSet<InfoValue> vs = state.instances.get(allocNode,
							this.objectUtils.taint);
					values.addAll(vs);
				}
				state.locals.putW(context, lLocal, values);
			}
		}
	}

	/**
	 * Transfers taint from the first argument to the receiver, for all
	 * potential allocation nodes and method contexts.
	 * 
	 * @param stmt
	 * @param invokeExpr
	 * @param state
	 */
	private void executeAddTaint(Stmt stmt, InvokeExpr invokeExpr, State state) {
		Block block = this.superControlFlowGraph.unitToBlock.get(stmt);
		Body body = block.getBody();
		SootMethod method = body.getMethod();
		Local baseLocal = (Local) ((InstanceInvokeExpr) invokeExpr).getBase();
		Immediate argImmediate = (Immediate) invokeExpr.getArg(0);
		if (argImmediate instanceof Local) {
			Local argLocal = (Local) argImmediate;
			Set<MethodOrMethodContext> methodContexts = PTABridge.v()
					.getMethodContexts(method);
			for (MethodOrMethodContext methodContext : methodContexts) {
				Context context = methodContext.context();
				if (ignoreContext(context)) {
					continue;
				}
				ImmutableSet<InfoValue> values = state.locals.get(context,
						argLocal);
				Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v()
						.getPTSet(baseLocal, context);
				for (IAllocNode allocNode : allocNodes) {
					state.instances.putW(allocNode, this.objectUtils.taint,
							values);
				}
			}
		}
	}

	/**
	 * Transfers taint from the first argument to the return value, for all
	 * potential allocation nodes and method contexts.
	 * 
	 * @param stmt
	 * @param invokeExpr
	 * @param state
	 */
	private void executeToTaint(Stmt stmt, InvokeExpr invokeExpr, State state) {
		Block block = this.superControlFlowGraph.unitToBlock.get(stmt);
		Body body = block.getBody();
		SootMethod method = body.getMethod();
		if (stmt instanceof AssignStmt) {
			// local "=" "staticinvoke" "[" Object.toTaint* "]" "(" immediate
			// ")"
			Immediate argImmediate = (Immediate) invokeExpr.getArg(0);
			if (argImmediate instanceof Local) {
				Local argLocal = (Local) argImmediate;
				Local lLocal = (Local) ((AssignStmt) stmt).getLeftOp();
				Set<MethodOrMethodContext> methodContexts = PTABridge.v()
						.getMethodContexts(method);
				for (MethodOrMethodContext methodContext : methodContexts) {
					Context context = methodContext.context();
					if (ignoreContext(context)) {
						continue;
					}
					ImmutableSet<InfoValue> values = state.locals.get(context,
							argLocal);
					state.locals.putW(context, lLocal, values);
				}
			}
		}
	}

	/**
	 * Generates taint for the return value on methods that take a string
	 * constant (over all method contexts).
	 * 
	 * @param stmt
	 * @param invokeExpr
	 * @param state
	 */
	private void executeGenerateTaint(Stmt stmt, InvokeExpr invokeExpr,
			State state) {
		Block block = this.superControlFlowGraph.unitToBlock.get(stmt);
		Body body = block.getBody();
		SootMethod method = body.getMethod();
		if (stmt instanceof AssignStmt) {
			// local "=" "staticinvoke" "[" DSUtils.dsGenerateTaint* "]" "("
			// string_constant ")"
			Local lLocal = (Local) ((AssignStmt) stmt).getLeftOp();
			Immediate argImmediate = (Immediate) invokeExpr.getArg(0);
			if (argImmediate instanceof StringConstant) {
				StringConstant argStringConstant = (StringConstant) argImmediate;
				Set<MethodOrMethodContext> methodContexts = PTABridge.v()
						.getMethodContexts(method);
				for (MethodOrMethodContext methodContext : methodContexts) {
					Context context = methodContext.context();
					if (ignoreContext(context)) {
						continue;
					}
					ImmutableSet<InfoValue> values = ImmutableSet
							.<InfoValue> of(InfoKind.getInfoKind(
									argStringConstant.value, true));
					state.locals.putW(context, lLocal, values);
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
		Block calleeBlock = this.superControlFlowGraph.unitToBlock.get(stmt);
		Body calleeBody = calleeBlock.getBody();
		SootMethod calleeMethod = calleeBody.getMethod();
		Immediate returnImmediate = (Immediate) stmt.getOp();
		Type returnType = calleeMethod.getReturnType();
		Set<MethodOrMethodContext> calleeMethodContexts = PTABridge.v()
				.getMethodContexts(calleeMethod);
		for (MethodOrMethodContext calleeMethodContext : calleeMethodContexts) {
			Context calleeContext = calleeMethodContext.context();
			if (ignoreContext(calleeContext)) {
				continue;
			}
			for (Edge callEdge : PTABridge.v().incomingEdges(
					calleeMethodContext)) {
				MethodOrMethodContext callerMethodContext = callEdge.getSrc();
				SootMethod callerMethod = callerMethodContext.method();
				Context callerContext = callerMethodContext.context();
				if (ignoreContext(callerContext)) {
					continue;
				}
				Stmt callStmt = callEdge.srcStmt();
				ImmutableSet<InfoValue> callValues = null;
				if (!(API.v().isSystemMethod(callerMethod))
						&& API.v().isSystemMethod(calleeMethod)) {
					if (API.v().hasSourceInfoKind(calleeMethod)) {
						callValues = ImmutableSet.<InfoValue> of(InfoUnit
								.v(callStmt));
						InvokeExpr invokeExpr = callStmt.getInvokeExpr();
						List<Value> argImmediates = invokeExpr.getArgs();
						for (Value argImmediate : argImmediates) {
							Type argType = argImmediate.getType();
							if (argType instanceof RefType) {
								if (API.v()
										.isSourceThatTaintsArgs(calleeMethod)) {
									Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge
											.v().getPTSet(argImmediate,
													callerContext);
									for (IAllocNode allocNode : allocNodes) {
										state.instances.putW(AllocNodeField.v(
												allocNode,
												this.objectUtils.taint),
												callValues);
									}
								}
							} else if (argType instanceof ArrayType) {
								ArrayType arrayType = (ArrayType) argImmediate
										.getType();
								Type elementType = arrayType.getElementType();
								if (API.v()
										.isSourceThatTaintsArgs(calleeMethod)) {
									if (elementType instanceof PrimType) {
										Set<IAllocNode> arrayAllocNodes = (Set<IAllocNode>) PTABridge
												.v().getPTSet(argImmediate,
														callerContext);
										for (IAllocNode arrayAllocNode : arrayAllocNodes) {
											state.instances
													.putW(AllocNodeField
															.v(arrayAllocNode,
																	this.objectUtils.taint),
															callValues);
											state.arrays.putW(arrayAllocNode,
													callValues);
										}
									} else {
										Set<IAllocNode> arrayAllocNodes = (Set<IAllocNode>) PTABridge
												.v().getPTSet(argImmediate,
														callerContext);
										for (IAllocNode arrayAllocNode : arrayAllocNodes) {
											state.instances
													.putW(AllocNodeField
															.v(arrayAllocNode,
																	this.objectUtils.taint),
															callValues);
											Set<IAllocNode> elementAllocNodes = (Set<IAllocNode>) PTABridge
													.v()
													.getPTSetOfArrayElement(
															arrayAllocNode);
											for (IAllocNode elementAllocNode : elementAllocNodes) {
												state.instances
														.putW(AllocNodeField
																.v(elementAllocNode,
																		this.objectUtils.taint),
																callValues);
											}
										}
									}
								} else {
									if (elementType instanceof PrimType) {
										Set<IAllocNode> arrayAllocNodes = (Set<IAllocNode>) PTABridge
												.v().getPTSet(argImmediate,
														callerContext);
										for (IAllocNode arrayAllocNode : arrayAllocNodes) {
											state.instances
													.putW(AllocNodeField
															.v(arrayAllocNode,
																	this.objectUtils.taint),
															callValues);
											state.arrays.putW(arrayAllocNode,
													callValues);
										}
									}
								}
							}
						}
					}
				}
				if (callStmt instanceof AssignStmt) {
					if (returnType instanceof RefLikeType) {
						if (!(API.v().isSystemMethod(callerMethod))
								&& API.v().isSystemMethod(calleeMethod)) {
							if (API.v().hasSourceInfoKind(calleeMethod)) {
								Local lLocal = (Local) ((AssignStmt) callStmt)
										.getLeftOp();
								Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge
										.v().getPTSet(lLocal, callerContext);
								for (IAllocNode allocNode : allocNodes) {
									state.instances.putW(allocNode,
											this.objectUtils.taint, callValues);
								}
							}
						}
					} else {
						HashSet<InfoValue> values = new HashSet<InfoValue>(
								evaluate(calleeContext, returnImmediate,
										state.locals));
						if (!(API.v().isSystemMethod(callerMethod))
								&& API.v().isSystemMethod(calleeMethod)) {
							if (API.v().hasSourceInfoKind(calleeMethod)) {
								values.addAll(callValues);
							}
						}
						Local lLocal = (Local) ((AssignStmt) callStmt)
								.getLeftOp();
						state.locals.putW(callerContext, lLocal, values);
					}
				}
			}
		}
	}

	// stmt = return_void_stmt
	private void execute(ReturnVoidStmt stmt, State state) {
		Block calleeBlock = this.superControlFlowGraph.unitToBlock.get(stmt);
		Body calleeBody = calleeBlock.getBody();
		SootMethod calleeMethod = calleeBody.getMethod();
		Set<MethodOrMethodContext> calleeMethodContexts = PTABridge.v()
				.getMethodContexts(calleeMethod);
		for (MethodOrMethodContext calleeMethodContext : calleeMethodContexts) {
			for (Edge callEdge : PTABridge.v().incomingEdges(
					calleeMethodContext)) {
				MethodOrMethodContext callerMethodContext = callEdge.getSrc();
				SootMethod callerMethod = callerMethodContext.method();
				Context callerContext = callerMethodContext.context();
				if (ignoreContext(callerContext)) {
					continue;
				}
				Stmt callStmt = callEdge.srcStmt();
				ImmutableSet<InfoValue> callValues = null;
				if (!(API.v().isSystemMethod(callerMethod))
						&& API.v().isSystemMethod(calleeMethod)) {
					if (API.v().hasSourceInfoKind(calleeMethod)) {
						callValues = ImmutableSet.<InfoValue> of(InfoUnit
								.v(callStmt));
						InvokeExpr invokeExpr = callStmt.getInvokeExpr();
						List<Value> argImmediates = invokeExpr.getArgs();
						for (Value argImmediate : argImmediates) {
							Type argType = argImmediate.getType();
							if (argType instanceof RefType) {
								if (API.v()
										.isSourceThatTaintsArgs(calleeMethod)) {
									Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge
											.v().getPTSet(argImmediate,
													callerContext);
									for (IAllocNode allocNode : allocNodes) {
										state.instances.putW(AllocNodeField.v(
												allocNode,
												this.objectUtils.taint),
												callValues);
									}
								}
							} else if (argType instanceof ArrayType) {
								ArrayType arrayType = (ArrayType) argImmediate
										.getType();
								Type elementType = arrayType.getElementType();
								if (API.v()
										.isSourceThatTaintsArgs(calleeMethod)) {
									if (elementType instanceof PrimType) {
										Set<IAllocNode> arrayAllocNodes = (Set<IAllocNode>) PTABridge
												.v().getPTSet(argImmediate,
														callerContext);
										for (IAllocNode arrayAllocNode : arrayAllocNodes) {
											state.instances
													.putW(AllocNodeField
															.v(arrayAllocNode,
																	this.objectUtils.taint),
															callValues);
											state.arrays.putW(arrayAllocNode,
													callValues);
										}
									} else {
										Set<IAllocNode> arrayAllocNodes = (Set<IAllocNode>) PTABridge
												.v().getPTSet(argImmediate,
														callerContext);
										for (IAllocNode arrayAllocNode : arrayAllocNodes) {
											state.instances
													.putW(AllocNodeField
															.v(arrayAllocNode,
																	this.objectUtils.taint),
															callValues);
											Set<IAllocNode> elementAllocNodes = (Set<IAllocNode>) PTABridge
													.v()
													.getPTSetOfArrayElement(
															arrayAllocNode);
											for (IAllocNode elementAllocNode : elementAllocNodes) {
												state.instances
														.putW(AllocNodeField
																.v(elementAllocNode,
																		this.objectUtils.taint),
																callValues);
											}
										}
									}
								} else {
									if (elementType instanceof PrimType) {
										Set<IAllocNode> arrayAllocNodes = (Set<IAllocNode>) PTABridge
												.v().getPTSet(argImmediate,
														callerContext);
										for (IAllocNode arrayAllocNode : arrayAllocNodes) {
											state.instances
													.putW(AllocNodeField
															.v(arrayAllocNode,
																	this.objectUtils.taint),
															callValues);
											state.arrays.putW(arrayAllocNode,
													callValues);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private ImmutableSet<InfoValue> evaluate(final Context context,
			Immediate immediate, final Locals locals) {
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
				setResult(ImmutableSet.<InfoValue> of());
			}
		};
		immediate.apply(immediateSwitch);
		return (ImmutableSet<InfoValue>) immediateSwitch.getResult();
	}

	public void printContextLocals(String value, Writer writer)
			throws IOException {
		this.state.locals.printContextLocals(value, writer);
	}

	public void printAllocNodeFields(String value, Writer writer)
			throws IOException {
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
	private ObjectUtils objectUtils;
	private SuperControlFlowGraph superControlFlowGraph;
	private Map<MethodOrMethodContext, Set<AllocNodeField>> methodContextToAllocNodeFields = new DefaultHashMap<MethodOrMethodContext, Set<AllocNodeField>>(
			Collections.<AllocNodeField> emptySet());

	AllocNodeFieldsReadAnalysis(ObjectUtils objectUtils,
			SuperControlFlowGraph superControlFlowGraph) {
		this.objectUtils = objectUtils;
		this.superControlFlowGraph = superControlFlowGraph;
		doAnalysis();
	}

	Set<AllocNodeField> getAllocNodeFieldsRead(AssignStmt stmt,
			final MethodOrMethodContext methodContext) {
		Value rValue = stmt.getRightOp();
		MyAbstractRValueSwitch rValueSwitch = new MyAbstractRValueSwitch() {
			@Override
			public void caseConstant(Constant constant) {
				setResult(null);
			}

			@Override
			public void caseLocal(Local local) {
				setResult(getAllocNodeFieldsRead(local, methodContext));
			}

			@Override
			public void caseInstanceFieldRef(InstanceFieldRef instanceFieldRef) {
				setResult(getAllocNodeFieldsRead(instanceFieldRef,
						methodContext));
			}

			@Override
			public void caseStaticFieldRef(StaticFieldRef staticFieldRef) {
				setResult(getAllocNodeFieldsRead(staticFieldRef, methodContext));
			}

			@Override
			public void caseArrayRef(ArrayRef arrayRef) {
				setResult(getAllocNodeFieldsRead(arrayRef, methodContext));
			}

			@Override
			public void caseNewExpr(NewExpr newExpr) {
				setResult(null);
			}

			@Override
			public void caseNewArrayExpr(NewArrayExpr newArrayExpr) {
				Immediate immediate = (Immediate) newArrayExpr.getSize();
				setResult(getAllocNodeFieldsRead(immediate, methodContext));
			}

			@Override
			public void caseNewMultiArrayExpr(
					NewMultiArrayExpr newMultiArrayExpr) {
				Set<AllocNodeField> allocNodeFields = new HashSet<AllocNodeField>();
				List<Value> sizes = newMultiArrayExpr.getSizes();
				for (Value size : sizes) {
					Set<AllocNodeField> afs = getAllocNodeFieldsRead(
							(Immediate) size, methodContext);
					if (afs != null) {
						allocNodeFields.addAll(afs);
					}
				}
				setResult(allocNodeFields);
			}

			@Override
			public void caseCastExpr(CastExpr castExpr) {
				Immediate immediate = (Immediate) castExpr.getOp();
				setResult(getAllocNodeFieldsRead(immediate, methodContext));
			}

			@Override
			public void caseInstanceOfExpr(InstanceOfExpr instanceOfExpr) {
				Immediate immediate = (Immediate) instanceOfExpr.getOp();
				setResult(getAllocNodeFieldsRead(immediate, methodContext));
			}

			@Override
			public void caseUnopExpr(UnopExpr unopExpr) {
				Immediate immediate = (Immediate) unopExpr.getOp();
				setResult(getAllocNodeFieldsRead(immediate, methodContext));
			}

			@Override
			public void caseBinopExpr(BinopExpr binopExpr) {
				Set<AllocNodeField> allocNodeFields = new HashSet<AllocNodeField>();
				Immediate[] immediates = { (Immediate) binopExpr.getOp1(),
						(Immediate) binopExpr.getOp2() };
				for (Immediate immediate : immediates) {
					Set<AllocNodeField> afs = getAllocNodeFieldsRead(immediate,
							methodContext);
					if (afs != null) {
						allocNodeFields.addAll(afs);
					}
				}
				setResult(allocNodeFields);
			}

			@Override
			public void caseInvokeExpr(InvokeExpr invokeExpr) {
				setResult(getAllocNodeFieldsRead(invokeExpr, methodContext));
			}
		};
		stmt.getRightOp().apply(rValueSwitch);
		return (Set<AllocNodeField>) rValueSwitch.getResult();
	}

	Set<AllocNodeField> getAllocNodeFieldsRead(InvokeStmt stmt,
			MethodOrMethodContext methodContext) {
		InvokeExpr invokeExpr = stmt.getInvokeExpr();
		return getAllocNodeFieldsRead(invokeExpr, methodContext);
	}

	Set<AllocNodeField> getAllocNodeFieldsRead(ReturnStmt stmt,
			MethodOrMethodContext methodContext) {
		Immediate immediate = (Immediate) stmt.getOp();
		return getAllocNodeFieldsRead(immediate, methodContext);
	}

	Set<AllocNodeField> getAllocNodeFieldsRead(InvokeExpr invokeExpr,
			MethodOrMethodContext methodContext) {
		assert !(invokeExpr instanceof DynamicInvokeExpr);
		Set<AllocNodeField> allocNodeFields = new HashSet<AllocNodeField>();
		if (invokeExpr instanceof InstanceInvokeExpr) {
			InstanceInvokeExpr instanceInvokeExpr = (InstanceInvokeExpr) invokeExpr;
			Local base = (Local) instanceInvokeExpr.getBase();
			Context context = methodContext.context();
			Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v()
					.getPTSet(base, context);
			for (IAllocNode allocNode : allocNodes) {
				allocNodeFields.add(AllocNodeField.v(allocNode,
						this.objectUtils.taint));
			}
		}
		List<Value> args = invokeExpr.getArgs();
		for (Value arg : args) {
			Set<AllocNodeField> afs = getAllocNodeFieldsRead((Immediate) arg,
					methodContext);
			if (afs != null) {
				allocNodeFields.addAll(afs);
			}
		}
		return allocNodeFields;
	}

	Set<AllocNodeField> getAllocNodeFieldsRead(Immediate immediate,
			final MethodOrMethodContext methodContext) {
		MyAbstractImmediateSwitch immediateSwitch = new MyAbstractImmediateSwitch() {
			@Override
			public void caseLocal(Local local) {
				setResult(getAllocNodeFieldsRead(local, methodContext));
			}

			@Override
			public void caseConstant(Constant constant) {
				setResult(null);
			}
		};
		immediate.apply(immediateSwitch);
		return (Set<AllocNodeField>) immediateSwitch.getResult();
	}

	Set<AllocNodeField> getAllocNodeFieldsRead(
			InstanceFieldRef instanceFieldRef,
			MethodOrMethodContext methodContext) {
		Set<AllocNodeField> allocNodeFields = new HashSet<AllocNodeField>();
		Local base = (Local) instanceFieldRef.getBase();
		Context context = methodContext.context();
		Set<IAllocNode> baseAllocNodes = (Set<IAllocNode>) PTABridge.v()
				.getPTSet(base, context);
		for (IAllocNode baseAllocNode : baseAllocNodes) {
			allocNodeFields.add(AllocNodeField.v(baseAllocNode,
					this.objectUtils.taint));
		}
		SootField field = instanceFieldRef.getField();
		if (field.getType() instanceof RefLikeType) {
			for (IAllocNode baseAllocNode : baseAllocNodes) {
				Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v()
						.getPTSet(baseAllocNode, field);
				for (IAllocNode allocNode : allocNodes) {
					allocNodeFields.add(AllocNodeField.v(allocNode,
							this.objectUtils.taint));
				}
			}
		} else {
			for (IAllocNode baseAllocNode : baseAllocNodes) {
				allocNodeFields.add(AllocNodeField.v(baseAllocNode, field));
			}
		}
		return allocNodeFields;
	}

	Set<AllocNodeField> getAllocNodeFieldsRead(ArrayRef arrayRef,
			MethodOrMethodContext methodContext) {
		Set<AllocNodeField> allocNodeFields = new HashSet<AllocNodeField>();
		Local base = (Local) arrayRef.getBase();
		Context context = methodContext.context();
		Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v().getPTSet(
				base, context);
		for (IAllocNode allocNode : allocNodes) {
			allocNodeFields.add(AllocNodeField.v(allocNode,
					this.objectUtils.taint));
		}
		if (arrayRef.getType() instanceof RefLikeType) {
			allocNodes = (Set<IAllocNode>) PTABridge.v().getPTSet(arrayRef,
					context);
			for (IAllocNode allocNode : allocNodes) {
				allocNodeFields.add(AllocNodeField.v(allocNode,
						this.objectUtils.taint));
			}
		}
		return allocNodeFields;
	}

	Set<AllocNodeField> getAllocNodeFieldsRead(StaticFieldRef staticFieldRef,
			MethodOrMethodContext methodContext) {
		Set<AllocNodeField> allocNodeFields = null;
		if (staticFieldRef.getType() instanceof RefLikeType) {
			allocNodeFields = new HashSet<AllocNodeField>();
			Context context = methodContext.context();
			Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v()
					.getPTSet(staticFieldRef, context);
			for (IAllocNode allocNode : allocNodes) {
				allocNodeFields.add(AllocNodeField.v(allocNode,
						this.objectUtils.taint));
			}
		}
		return allocNodeFields;
	}

	Set<AllocNodeField> getAllocNodeFieldsRead(Local local,
			MethodOrMethodContext methodContext) {
		Set<AllocNodeField> allocNodeFields = null;
		if (local.getType() instanceof RefLikeType) {
			allocNodeFields = new HashSet<AllocNodeField>();
			Context context = methodContext.context();
			Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v()
					.getPTSet(local, context);
			for (IAllocNode allocNode : allocNodes) {
				allocNodeFields.add(AllocNodeField.v(allocNode,
						this.objectUtils.taint));
			}
		}
		return allocNodeFields;
	}

	private void doAnalysis() {
		Set<SootMethod> methods = PTABridge.v().getReachableMethods();
		for (SootMethod method : methods) {
			if (method.hasActiveBody()
					&& !(SootUtils.isRuntimeStubMethod(method))
					&& !(this.objectUtils.isAddTaint(method))
					&& !(this.objectUtils.isGetTaint(method))) {
				List<Block> blocks = this.superControlFlowGraph.methodToBlocks
						.get(method);
				Set<MethodOrMethodContext> methodContexts = PTABridge.v()
						.getMethodContexts(method);
				for (final MethodOrMethodContext methodContext : methodContexts) {
					Context context = methodContext.context();
					if (InformationFlowAnalysis.ignoreContext(context)) {
						continue;
					}
					HashSet<AllocNodeField> allocNodeFields = new HashSet<AllocNodeField>();
					for (Block block : blocks) {
						Iterator<Unit> units = block.iterator();
						while (units.hasNext()) {
							Unit unit = units.next();
							AbstractStmtSwitch stmtSwitch = new AbstractStmtSwitch() {
								@Override
								public void caseAssignStmt(AssignStmt stmt) {
									setResult(getAllocNodeFieldsRead(stmt,
											methodContext));
								}

								@Override
								public void caseInvokeStmt(InvokeStmt stmt) {
									setResult(getAllocNodeFieldsRead(stmt,
											methodContext));
								}

								@Override
								public void caseReturnStmt(ReturnStmt stmt) {
									setResult(getAllocNodeFieldsRead(stmt,
											methodContext));
								}
							};
							unit.apply(stmtSwitch);
							Set<AllocNodeField> afs = (Set<AllocNodeField>) stmtSwitch
									.getResult();
							if (afs != null) {
								allocNodeFields.addAll(afs);
							}
						}
					}
					this.methodContextToAllocNodeFields.put(methodContext,
							allocNodeFields);
				}
			}
		}
	}

	private Map<MethodOrMethodContext, ImmutableSet<AllocNodeField>> methodContextToAllocNodeFieldsRecursively = new HashMap<MethodOrMethodContext, ImmutableSet<AllocNodeField>>();

	private EdgePredicate clinitFilter = new EdgePredicate() {
		@Override
		public boolean want(Edge e) {
			if (e.tgt().isStatic() && SootUtils.isStaticInit(e.tgt())) {
				return false;
			}

			if (e.src().isStatic() && SootUtils.isStaticInit(e.src())) {
				return false;
			}

			return true;
		}
	};

	private TransitiveTargets transitiveTargets = new TransitiveTargets(Scene
			.v().getCallGraph(), new Filter(clinitFilter));

	ImmutableSet<AllocNodeField> getRecursively(
			MethodOrMethodContext methodContext) {
		if (this.methodContextToAllocNodeFieldsRecursively
				.containsKey(methodContext)) {
			return this.methodContextToAllocNodeFieldsRecursively
					.get(methodContext);
		}

		Context context = methodContext.context();
		if (InformationFlowAnalysis.ignoreContext(context)) {
			return ImmutableSet.<AllocNodeField> of();
		}
		HashSet<AllocNodeField> allocNodeFields = new HashSet<AllocNodeField>(
				this.methodContextToAllocNodeFields.get(methodContext));
		Iterator<MethodOrMethodContext> tgtMethodContexts = this.transitiveTargets
				.iterator(methodContext);
		while (tgtMethodContexts.hasNext()) {
			MethodOrMethodContext tgtMethodContext = tgtMethodContexts.next();
			Context tgtContext = tgtMethodContext.context();
			if (InformationFlowAnalysis.ignoreContext(tgtContext)) {
				continue;
			}
			Set<AllocNodeField> afs = this.methodContextToAllocNodeFields
					.get(tgtMethodContext);
			allocNodeFields.addAll(afs);
		}
		ImmutableSet<AllocNodeField> afs = ImmutableSet.copyOf(allocNodeFields);
		this.methodContextToAllocNodeFieldsRecursively.put(methodContext, afs);
		return afs;
	}
}

class AllocNodesReadAnalysis {
	private ObjectUtils objectUtils;
	private SuperControlFlowGraph superControlFlowGraph;
	private Map<MethodOrMethodContext, Set<IAllocNode>> methodContextToAllocNodes = new DefaultHashMap<MethodOrMethodContext, Set<IAllocNode>>(
			Collections.<IAllocNode> emptySet());

	AllocNodesReadAnalysis(ObjectUtils objectUtils,
			SuperControlFlowGraph superControlFlowGraph) {
		this.objectUtils = objectUtils;
		this.superControlFlowGraph = superControlFlowGraph;
		doAnalysis();
	}

	static Set<IAllocNode> getAllocNodesRead(AssignStmt stmt,
			MethodOrMethodContext methodContext) {
		Set<IAllocNode> allocNodes = null;
		Value rValue = stmt.getRightOp();
		if (rValue instanceof ArrayRef) {
			allocNodes = getAllocNodesRead(stmt, (ArrayRef) rValue,
					methodContext);
		}
		return allocNodes;
	}

	static Set<IAllocNode> getAllocNodesRead(AssignStmt stmt,
			ArrayRef arrayRef, MethodOrMethodContext methodContext) {
		Set<IAllocNode> allocNodes = null;
		if (!(arrayRef.getType() instanceof RefLikeType)) {
			allocNodes = new HashSet<IAllocNode>();
			Value baseValue = arrayRef.getBase();
			Context context = methodContext.context();
			for (IAllocNode allocNode : PTABridge.v().getPTSet(baseValue,
					context)) {
				allocNodes.add(allocNode);
			}
		}
		return allocNodes;
	}

	private void doAnalysis() {
		Set<SootMethod> methods = PTABridge.v().getReachableMethods();
		for (SootMethod method : methods) {
			if (method.hasActiveBody()
					&& !(SootUtils.isRuntimeStubMethod(method))
					&& !(this.objectUtils.isAddTaint(method))
					&& !(this.objectUtils.isGetTaint(method))) {
				List<Block> blocks = this.superControlFlowGraph.methodToBlocks
						.get(method);
				Set<MethodOrMethodContext> methodContexts = PTABridge.v()
						.getMethodContexts(method);
				for (MethodOrMethodContext methodContext : methodContexts) {
					Context context = methodContext.context();
					if (InformationFlowAnalysis.ignoreContext(context)) {
						continue;
					}
					HashSet<IAllocNode> allocNodes = new HashSet<IAllocNode>();
					for (Block block : blocks) {
						Iterator<Unit> units = block.iterator();
						while (units.hasNext()) {
							Unit unit = units.next();
							Set<IAllocNode> as = null;
							if (unit instanceof AssignStmt) {
								as = getAllocNodesRead((AssignStmt) unit,
										methodContext);
							}
							if (as != null) {
								allocNodes.addAll(as);
							}
						}
					}
					this.methodContextToAllocNodes.put(methodContext,
							allocNodes);
				}
			}
		}
	}

	private Map<MethodOrMethodContext, ImmutableSet<IAllocNode>> methodContextToAllocNodesRecursively = new HashMap<MethodOrMethodContext, ImmutableSet<IAllocNode>>();

	private EdgePredicate clinitFilter = new EdgePredicate() {
		@Override
		public boolean want(Edge e) {
			if (e.tgt().isStatic() && SootUtils.isStaticInit(e.tgt())) {
				return false;
			}

			if (e.src().isStatic() && SootUtils.isStaticInit(e.src())) {
				return false;
			}

			return true;
		}
	};

	TransitiveTargets transitiveTargets = new TransitiveTargets(Scene.v()
			.getCallGraph(), new Filter(clinitFilter));

	ImmutableSet<IAllocNode> getRecursively(MethodOrMethodContext methodContext) {
		if (this.methodContextToAllocNodesRecursively
				.containsKey(methodContext)) {
			return this.methodContextToAllocNodesRecursively.get(methodContext);
		}

		Context context = methodContext.context();
		if (InformationFlowAnalysis.ignoreContext(context)) {
			return ImmutableSet.<IAllocNode> of();
		}
		HashSet<IAllocNode> allocNodes = new HashSet<IAllocNode>(
				this.methodContextToAllocNodes.get(methodContext));
		Iterator<MethodOrMethodContext> tgtMethodContexts = this.transitiveTargets
				.iterator(methodContext);
		while (tgtMethodContexts.hasNext()) {
			MethodOrMethodContext tgtMethodContext = tgtMethodContexts.next();
			Context tgtContext = tgtMethodContext.context();
			if (InformationFlowAnalysis.ignoreContext(tgtContext)) {
				continue;
			}
			Set<IAllocNode> as = this.methodContextToAllocNodes
					.get(tgtMethodContext);
			allocNodes.addAll(as);
		}
		ImmutableSet<IAllocNode> as = ImmutableSet.copyOf(allocNodes);
		this.methodContextToAllocNodesRecursively.put(methodContext, as);
		return as;
	}
}

class FieldsReadAnalysis {
	private ObjectUtils objectUtils;
	private SuperControlFlowGraph superControlFlowGraph;
	private Map<SootMethod, Set<SootField>> methodToFields = new DefaultHashMap<SootMethod, Set<SootField>>(
			Collections.<SootField> emptySet());

	FieldsReadAnalysis(ObjectUtils objectUtils,
			SuperControlFlowGraph superControlFlowGraph) {
		this.objectUtils = objectUtils;
		this.superControlFlowGraph = superControlFlowGraph;
		doAnalysis();
	}

	static Set<SootField> getFieldsRead(AssignStmt stmt) {
		Set<SootField> fields = null;
		Value rValue = stmt.getRightOp();
		if (rValue instanceof StaticFieldRef) {
			fields = getFieldsRead(stmt, (StaticFieldRef) rValue);
		}
		return fields;
	}

	static Set<SootField> getFieldsRead(AssignStmt stmt,
			StaticFieldRef staticFieldRef) {
		Set<SootField> fields = null;
		if (!(staticFieldRef.getType() instanceof RefLikeType)) {
			SootField field = staticFieldRef.getField();
			fields = Collections.<SootField> singleton(field);
		}
		return fields;
	}

	private void doAnalysis() {
		Set<SootMethod> methods = PTABridge.v().getReachableMethods();
		for (SootMethod method : methods) {
			if (method.hasActiveBody()
					&& !(SootUtils.isRuntimeStubMethod(method))
					&& !(this.objectUtils.isAddTaint(method))
					&& !(this.objectUtils.isGetTaint(method))) {
				List<Block> blocks = this.superControlFlowGraph.methodToBlocks
						.get(method);
				HashSet<SootField> fields = new HashSet<SootField>();
				for (Block block : blocks) {
					Iterator<Unit> units = block.iterator();
					while (units.hasNext()) {
						Unit unit = units.next();
						Set<SootField> fs = null;
						if (unit instanceof AssignStmt) {
							fs = getFieldsRead((AssignStmt) unit);
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

	private EdgePredicate clinitFilter = new EdgePredicate() {
		@Override
		public boolean want(Edge e) {
			if (e.tgt().isStatic() && SootUtils.isStaticInit(e.tgt())) {
				return false;
			}

			if (e.src().isStatic() && SootUtils.isStaticInit(e.src())) {
				return false;
			}

			return true;
		}
	};

	TransitiveTargets transitiveTargets = new TransitiveTargets(Scene.v()
			.getCallGraph(), new Filter(clinitFilter));

	ImmutableSet<SootField> getRecursively(MethodOrMethodContext methodContext) {
		if (this.methodContextToFieldsRecursively.containsKey(methodContext)) {
			return this.methodContextToFieldsRecursively.get(methodContext);
		}

		Context context = methodContext.context();
		if (InformationFlowAnalysis.ignoreContext(context)) {
			return ImmutableSet.<SootField> of();
		}
		HashSet<SootMethod> visitedMethods = new HashSet<SootMethod>();
		SootMethod method = methodContext.method();
		HashSet<SootField> fields = new HashSet<SootField>(
				this.methodToFields.get(method));
		visitedMethods.add(method);
		Iterator<MethodOrMethodContext> tgtMethodContexts = this.transitiveTargets
				.iterator(methodContext);
		while (tgtMethodContexts.hasNext()) {
			MethodOrMethodContext tgtMethodContext = tgtMethodContexts.next();
			Context tgtContext = tgtMethodContext.context();
			if (InformationFlowAnalysis.ignoreContext(tgtContext)) {
				continue;
			}
			SootMethod tgtMethod = tgtMethodContext.method();
			if (!(visitedMethods.contains(tgtMethod))) {
				Set<SootField> fs = this.methodToFields.get(tgtMethodContext
						.method());
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
	private ObjectUtils objectUtils;
	private SuperControlFlowGraph superControlFlowGraph;
	private Map<MethodOrMethodContext, Set<InfoValue>> methodContextToValues = new DefaultHashMap<MethodOrMethodContext, Set<InfoValue>>(
			Collections.<InfoValue> emptySet());

	InjectedValuesAnalysis(ObjectUtils objectUtils,
			SuperControlFlowGraph superControlFlowGraph) {
		this.objectUtils = objectUtils;
		this.superControlFlowGraph = superControlFlowGraph;
		doAnalysis();
	}

	Set<InfoValue> getInjectedValues(AssignStmt stmt,
			MethodOrMethodContext methodContext) {

		Set<InfoValue> values = null;
		Value rValue = stmt.getRightOp();
		if (rValue instanceof InvokeExpr) {
			values = getInjectedValues(stmt, (InvokeExpr) rValue, methodContext);
		}
		return values;
	}

	Set<InfoValue> getInjectedValues(AssignStmt stmt, InvokeExpr invokeExpr,
			MethodOrMethodContext callerMethodContext) {
		HashSet<InfoValue> values = new HashSet<InfoValue>();
		Block callerBlock = this.superControlFlowGraph.unitToBlock.get(stmt);
		Body callerBody = callerBlock.getBody();
		SootMethod callerMethod = callerBody.getMethod();
		for (Edge callEdge : PTABridge.v().outgoingEdges(callerMethodContext,
				stmt)) {
			MethodOrMethodContext calleeMethodContext = callEdge.getTgt();
			SootMethod calleeMethod = calleeMethodContext.method();
			if (!(API.v().isSystemMethod(callerMethod))
					&& API.v().isSystemMethod(calleeMethod)) {
				if (API.v().hasSourceInfoKind(calleeMethod)) {
					values.add(InfoUnit.v(stmt));
				}
			}
		}
		return values;
	}

	private void doAnalysis() {
		Set<SootMethod> methods = PTABridge.v().getReachableMethods();
		for (SootMethod method : methods) {
			if (method.hasActiveBody()
					&& !(SootUtils.isRuntimeStubMethod(method))
					&& !(this.objectUtils.isAddTaint(method))
					&& !(this.objectUtils.isGetTaint(method))) {
				List<Block> blocks = this.superControlFlowGraph.methodToBlocks
						.get(method);
				Set<MethodOrMethodContext> methodContexts = PTABridge.v()
						.getMethodContexts(method);
				for (MethodOrMethodContext methodContext : methodContexts) {
					Context context = methodContext.context();
					if (InformationFlowAnalysis.ignoreContext(context)) {
						continue;
					}
					HashSet<InfoValue> values = new HashSet<InfoValue>();
					for (Block block : blocks) {
						Iterator<Unit> units = block.iterator();
						while (units.hasNext()) {
							Unit unit = units.next();
							Set<InfoValue> vs = null;
							if (unit instanceof AssignStmt) {
								vs = getInjectedValues((AssignStmt) unit,
										methodContext);
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

	private EdgePredicate clinitFilter = new EdgePredicate() {
		@Override
		public boolean want(Edge e) {
			if (e.tgt().isStatic() && SootUtils.isStaticInit(e.tgt())) {
				return false;
			}

			if (e.src().isStatic() && SootUtils.isStaticInit(e.src())) {
				return false;
			}

			return true;
		}
	};

	private TransitiveTargets transitiveTargets = new TransitiveTargets(Scene
			.v().getCallGraph(), new Filter(clinitFilter));

	ImmutableSet<InfoValue> getRecursively(MethodOrMethodContext methodContext) {
		if (this.methodContextToValuesRecursively.containsKey(methodContext)) {
			return this.methodContextToValuesRecursively.get(methodContext);
		}

		Context context = methodContext.context();
		if (InformationFlowAnalysis.ignoreContext(context)) {
			return ImmutableSet.<InfoValue> of();
		}
		HashSet<InfoValue> values = new HashSet<InfoValue>(
				this.methodContextToValues.get(methodContext));
		Iterator<MethodOrMethodContext> tgtMethodContexts = this.transitiveTargets
				.iterator(methodContext);
		while (tgtMethodContexts.hasNext()) {
			MethodOrMethodContext tgtMethodContext = tgtMethodContexts.next();
			Context tgtContext = tgtMethodContext.context();
			if (InformationFlowAnalysis.ignoreContext(tgtContext)) {
				continue;
			}
			Set<InfoValue> vs = this.methodContextToValues
					.get(tgtMethodContext);
			values.addAll(vs);
		}
		ImmutableSet<InfoValue> vs = ImmutableSet.copyOf(values);
		this.methodContextToValuesRecursively.put(methodContext, vs);
		return vs;
	}
}
