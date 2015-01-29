package dk.brics.string.intermediate.operations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import dk.brics.string.intermediate.Application;
import dk.brics.string.intermediate.ArrayAddAll;
import dk.brics.string.intermediate.ArrayAssignment;
import dk.brics.string.intermediate.ArrayCorrupt;
import dk.brics.string.intermediate.ArrayFromArray;
import dk.brics.string.intermediate.ArrayNew;
import dk.brics.string.intermediate.ArrayWriteArray;
import dk.brics.string.intermediate.ArrayWriteElement;
import dk.brics.string.intermediate.AssertAliases;
import dk.brics.string.intermediate.AssertBinaryOp;
import dk.brics.string.intermediate.AssertUnaryOp;
import dk.brics.string.intermediate.BasicBinaryOp;
import dk.brics.string.intermediate.BasicUnaryOp;
import dk.brics.string.intermediate.Call;
import dk.brics.string.intermediate.Catch;
import dk.brics.string.intermediate.ExceptionalReturn;
import dk.brics.string.intermediate.Field;
import dk.brics.string.intermediate.FieldAssignment;
import dk.brics.string.intermediate.FieldReference;
import dk.brics.string.intermediate.Hotspot;
import dk.brics.string.intermediate.Method;
import dk.brics.string.intermediate.MethodHead;
import dk.brics.string.intermediate.Nop;
import dk.brics.string.intermediate.ObjectAssignment;
import dk.brics.string.intermediate.ObjectCorrupt;
import dk.brics.string.intermediate.PrimitiveAssignment;
import dk.brics.string.intermediate.PrimitiveFromArray;
import dk.brics.string.intermediate.PrimitiveInit;
import dk.brics.string.intermediate.Return;
import dk.brics.string.intermediate.Statement;
import dk.brics.string.intermediate.StatementVisitor;
import dk.brics.string.intermediate.StringAssignment;
import dk.brics.string.intermediate.StringBufferAppend;
import dk.brics.string.intermediate.StringBufferAppendChar;
import dk.brics.string.intermediate.StringBufferAssignment;
import dk.brics.string.intermediate.StringBufferBinaryOp;
import dk.brics.string.intermediate.StringBufferCorrupt;
import dk.brics.string.intermediate.StringBufferInit;
import dk.brics.string.intermediate.StringBufferPrepend;
import dk.brics.string.intermediate.StringBufferUnaryOp;
import dk.brics.string.intermediate.StringConcat;
import dk.brics.string.intermediate.StringFromArray;
import dk.brics.string.intermediate.StringFromStringBuffer;
import dk.brics.string.intermediate.StringInit;
import dk.brics.string.intermediate.Variable;

/**
 * Alias analysis performed on a set of methods. This analysis also determines
 * which variables might have been corrupted.
 * <p/>
 * This is a variable-pair-based may/must context-insensitive alias analysis.
 * Only live variables are considered.
 */
public class AliasAnalysis implements FlowAnalysis, StatementVisitor {

	private LivenessAnalysis la;
	private FieldUsageAnalysis fieldUsage;
	private AliasAssertionAnalysis assertions;

	/**
	 * Alias info for program point before each statement.
	 */
	private Map<Statement, AliasInfo> flow_info;

	/**
	 * Alias info for program point before current statement.
	 */
	private AliasInfo before;

	/**
	 * Alias info for program point after current statement.
	 */
	private AliasInfo after;

	private boolean changed;

	private WorkList worklist;

	/**
	 * Performs alias analysis.
	 *
	 * @param app the application to analyze
	 * @param la  result from liveness analysis
	 * @param fieldUsage result from field usage analysis
	 */
	public AliasAnalysis(Application app, LivenessAnalysis la, FieldUsageAnalysis fieldUsage, AliasAssertionAnalysis assertions) {
		this.la = la;
		this.fieldUsage = fieldUsage;
		this.assertions = assertions;
		flow_info = new HashMap<Statement, AliasInfo>();
		worklist = new WorkList(this);
		for (Method m : app.getMethods()) {
			worklist.addAll(m);
		}
		worklist.iterate();
	}

	public void transfer(Statement s) {
		before = getInfoBefore(s);
		for (Statement ss : s.getSuccs()) {
			after = getInfoBefore(ss);
			changed = false;
			s.visitBy(this);
			if (changed) {
				worklist.add(ss);
			}
		}

		// visit interprocedural successors
		if (s instanceof Return) {
			Return returnStm = (Return)s;
			Method method = s.getMethod();
			for (Call call : method.getCallSites()) {
				for (Statement afterCall : call.getSuccs()) {
					after = getInfoBefore(afterCall);
					changed = false;
					transferReturn(returnStm, call, afterCall);
					if (changed) {
						worklist.add(afterCall);
					}
				}
			}
		}
		if (s instanceof Call) {
			Call call = (Call)s;
			after = getInfoBefore(call.target.getEntry());
			changed = false;
			transferCall(call, call.target.getEntry());
			if (changed) {
				worklist.add(call.target.getEntry());
			}
		}
	}

	/**
	 * Transfers alias information from a {@link Return} statement to the statements
	 * following a corresponding {@link Call} statement. Information being transferred:
	 * <ul>
	 * <li>If parameter <i>i</i> is corrupt, then caller's actual argument <i>i</i> is corrupted.
	 * <li>If the returned value might be an alias for parameter <i>i</i>, then caller's actual argument <i>i</i> becomes a possible alias
	 * 		for the caller's result variable.
	 * <li>If the returned value is corrupt, then caller's result variable is corrupted.
	 * </ul>
	 * @param returnStm the return statement.
	 * @param call a call to the method containing the return statement.
	 * @param to the statement receiving the alias information. This is a successor of <tt>call</tt>, and corresponds to the {@link #after} field.
	 */
	private void transferReturn(Return returnStm, Call call, Statement to) {
		Method method = returnStm.getMethod();
		MethodHead head = method.getEntry();
		AliasInfo beforeCall = getInfoBefore(call);
		AliasStatus status;
		// add aliasing between arguments and return value
		// and corruption of parameters to corruption of arguments
		for (int i=0; i<head.params.length; i++) {
			status = before.getAliasStatus(returnStm.retvar, head.params[i]);
			changed |= after.mergeStatus(beforeCall, call.retvar, call.args[i], status);

			if (before.isCorrupt(head.params[i])) {
				changed |= after.mergeCorrupt(beforeCall, call.args[i]);
			}
		}

		// add aliasing between fields pairs, and between fields and return value
		for (Field field1 : fieldUsage.getUsedFields(method)) {
			for (Field field2 : fieldUsage.getUsedFields(method)) {
				if (field1 == field2)
					continue;

				status = before.getAliasStatus(field1.getVariable(), field2.getVariable());
				changed |= after.mergeStatus(beforeCall, field1.getVariable(), field2.getVariable(), status);
				changed |= after.mergeStatus(beforeCall, field2.getVariable(), field1.getVariable(), status);
			}
			// if a field was assigned to one of the parameters, tell the caller that his arguments are now
			// aliases for the field
			for (int i=0; i<head.params.length; i++) {
				status = before.getAliasStatus(field1.getVariable(), head.params[i]);
				changed |= after.mergeStatus(beforeCall, call.args[i], field1.getVariable(), status);
				// no need to merge for field1 as left-hand side. A local that was aliased with field1
				// can still not become aliased with an argument, just because field1 changed value.
			}

			// set aliasing with field and return value
			status = before.getAliasStatus(returnStm.retvar, field1.getVariable());
			changed |= after.mergeStatus(beforeCall, call.retvar, field1.getVariable(), status);

			// if the field was corrupted, transfer this to the caller
			if (before.isCorrupt(field1.getVariable())) {
				changed |= after.mergeCorrupt(beforeCall, field1.getVariable());
			}
		}

		// if the return value might be corrupt
		if (before.isCorrupt(returnStm.retvar)) {
			changed |= after.setCorrupt(call.retvar);
		}
	}

	/**
	 * Transfers alias information from a {@link Call} statement to the {@link MethodHead} of
	 * the called method. Information being transferred:
	 * <ul>
	 * <li>If actual argument <i>i</i> might be an alias for actual argument <i>j</i>, then
	 * 		parameter <i>i</i> becomes a possible alias for parameter <i>j</i>.
	 * <li>If actual argument <i>i</i> is corrupt, then parameter <i>i</i> is corrupted.
	 * </ul>
	 * @param callStm the call statement.
	 * @param head method head of the call's target method.
	 */
	private void transferCall(Call callStm, MethodHead head) {
		// add aliasing between arguments to aliasing between parameters
		// and corruption of arguments to corruption of parameters
		for	(int i=0; i<head.params.length; i++) {
			for (int j=i+1; j<head.params.length; j++) {
				AliasStatus status = before.getAliasStatus(callStm.args[i], callStm.args[j]);
				changed |= after.mergeStatus(after, head.params[i], head.params[j], status);
				changed |= after.mergeStatus(after, head.params[j], head.params[i], status);
			}
			if (before.isCorrupt(callStm.args[i])) {
				changed |= after.setCorrupt(head.params[i]);
			}
		}
		// add aliasing status between fields pairs and between fields and arguments
		for (Field field1 : fieldUsage.getUsedFields(callStm.target)) {
			for (Field field2 : fieldUsage.getUsedFields(callStm.target)) {
				if (field1 == field2)
					continue;

				AliasStatus status = before.getAliasStatus(field1.getVariable(), field2.getVariable());
				changed |= after.mergeStatus(after, field1.getVariable(), field2.getVariable(), status);
				changed |= after.mergeStatus(after, field2.getVariable(), field1.getVariable(), status);
			}

			for (int i=0; i<head.params.length; i++) {
				AliasStatus status = before.getAliasStatus(field1.getVariable(), callStm.args[i]);
				changed |= after.mergeStatus(after, field1.getVariable(), head.params[i], status);
				changed |= after.mergeStatus(after, head.params[i], field1.getVariable(), status);
			}

			if (before.isCorrupt(field1.getVariable())) {
				changed |= after.setCorrupt(field1.getVariable());
			}
		}
	}

	/**
	 * Returns the alias information as inferred just before the given statement.
	 */
	public AliasInfo getInfoBefore(Statement s) {
		if (!flow_info.containsKey(s)) {
			Set<Variable> live = new HashSet<Variable>(la.getLiveBefore(s));
			/* for (Field field : app.getFields()) {
                live.add(field.getVariable());
            }*/
			for (Field field : fieldUsage.getUsedFields(s.getMethod())) {
				live.add(field.getVariable());
			}
			flow_info.put(s, new AliasInfo(live));
		}
		return flow_info.get(s);
	}

	public void visitPrimitiveAssignment(PrimitiveAssignment s) {
		transferIdentity();
	}
	public void visitPrimitiveInit(PrimitiveInit s) {
		transferIdentity();
	}
	public void visitStringBufferAppendChar(StringBufferAppendChar s) {
		transferIdentity();
	}
	public void visitBasicUnaryOp(BasicUnaryOp s) {
		transferIdentity();
	}
	public void visitBasicBinaryOp(BasicBinaryOp s) {
		transferIdentity();
	}
	public void visitAssertBinaryOp(AssertBinaryOp s) {
		transferIdentity();
	}
	public void visitAssertUnaryOp(AssertUnaryOp s) {
		transferIdentity();
	}
	public void visitAssertAliases(AssertAliases s) {
		if (assertions.isValid(s)) {
			if (s.alias) {
				changed |= after.mergeAssertAliases(before, s.a, s.b);
			} else {
				changed |= after.mergeAssertNotAliases(before, s.a, s.b);
			}
		} else {
			// invalid assertion. just pretend it wasn't here
			transferIdentity();
		}
	}
	
	public void visitArrayAssignment(ArrayAssignment s) {
		transferFilter(s.to);
		transferAssign(s.to, s.from);
	}

	public void visitArrayCorrupt(ArrayCorrupt s) {
		transferIdentity();
		transferCorrupt(s.to);
	}

	public void visitArrayAddAll(ArrayAddAll s) {
		transferIdentity();
	}

	public void visitArrayFromArray(ArrayFromArray s) {
		transferFilter(s.to);
		transferAssign(s.to, s.from);
	}

	public void visitArrayNew(ArrayNew s) {
		transferFilter(s.to);
		transferNew(s.to);
	}

	public void visitArrayWriteArray(ArrayWriteArray s) {
		transferIdentity();
		transferAssign(s.to, s.from);
	}

	public void visitArrayWriteElement(ArrayWriteElement s) {
		transferIdentity();
		transferAssign(s.to, s.from);
	}

	public void visitCall(Call s) {
		transferFilter(s.retvar);
		// this only handles flow from call to its successors in the method
		// see transferCall for the interprocedural flow
	}

	public void visitMethodHead(MethodHead s) {
		transferIdentity();

		// parameter aliases are definitely aliases of the formal parameters
		Variable[] pa = s.getMethod().getParamAlias();
		for (int i = 0; i < s.params.length; i++) {
			if (pa[i] != null) {
				changed |= after.mergeStatus(after, pa[i], s.params[i], AliasStatus.DEFINITELY);
			}
		}
	}

	public void visitNop(Nop s) {
		transferIdentity();
	}

	public void visitReturn(Return s) {
		// see transferReturn for the interprocedural flow
	}

	public void visitStringAssignment(StringAssignment s) {
		transferIdentity();
	}

	public void visitStringBufferAppend(StringBufferAppend s) {
		transferIdentity();
	}

	public void visitStringBufferAssignment(StringBufferAssignment s) {
		transferFilter(s.to);
		transferAssign(s.to, s.from);
	}

	public void visitStringBufferBinaryOp(StringBufferBinaryOp s) {
		transferIdentity();
	}

	public void visitStringBufferCorrupt(StringBufferCorrupt s) {
		transferIdentity();
		transferCorrupt(s.to);
	}

	public void visitStringBufferInit(StringBufferInit s) {
		transferFilter(s.to);
		transferNew(s.to);
	}

	public void visitStringBufferPrepend(StringBufferPrepend s) {
		transferIdentity();
	}

	public void visitStringBufferUnaryOp(StringBufferUnaryOp s) {
		transferIdentity();
	}

	public void visitStringConcat(StringConcat s) {
		transferIdentity();
	}

	public void visitStringFromArray(StringFromArray s) {
		transferIdentity();
	}
	public void visitPrimitiveFromArray(PrimitiveFromArray s) {
		transferIdentity();
	}

	public void visitStringFromStringBuffer(StringFromStringBuffer s) {
		transferIdentity();
	}

	public void visitStringInit(StringInit s) {
		transferIdentity();
	}

	public void visitObjectAssignment(ObjectAssignment s) {
		transferFilter(s.to);
		transferAssign(s.to, s.from);
	}

	public void visitObjectCorrupt(ObjectCorrupt s) {
		transferIdentity();
		transferCorrupt(s.to);
	}

	public void visitHotspot(Hotspot s) {
		transferIdentity();
	}

	public void visitFieldAssignment(FieldAssignment s) {
		transferIdentity(); // we use identity instead of filter to perform weak update
		transferAssign(s.getTo(), s.getFrom());
	}

	public void visitFieldReference(FieldReference s) {
		transferFilter(s.getTo());
		transferAssign(s.getTo(), s.getFrom());
	}

	public void visitCatch(Catch s) {
		transferIdentity();
		// exceptional flow cannot change aliasing
	}
	public void visitExceptionalReturn(ExceptionalReturn s) {
		// interprocedural flow handled elsewhere
	}

	private void transferIdentity() {
		changed |= after.mergeIdentity(before);
	}

	private void transferFilter(Variable a) {
		changed |= after.mergeFilter(before, a);
	}

	private void transferAssign(Variable a, Variable b) {
		changed |= after.mergeAssign(before, a, b);
	}

	private void transferCorrupt(Variable a) {
		changed |= after.mergeCorrupt(before, a);
	}

	private void transferNew(Variable a) {
		changed |= after.mergeNew(a);
	}

}
