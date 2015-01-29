package dk.brics.string.intermediate.operations;

import java.util.HashSet;
import java.util.Set;

import dk.brics.string.intermediate.Application;
import dk.brics.string.intermediate.ArrayAssignment;
import dk.brics.string.intermediate.AssertAliases;
import dk.brics.string.intermediate.Method;
import dk.brics.string.intermediate.Statement;
import dk.brics.string.intermediate.StringBufferAssignment;
import dk.brics.string.intermediate.Variable;

/**
 * Analyses {@link AssertAliases} statements to determine which are valid assertions.
 * The alias analysis uses the results from this analysis.
 * 
 * @author Asger
 *
 */
public class AliasAssertionAnalysis {
	
	private Set<AssertAliases> valid = new HashSet<AssertAliases>();
	
	public AliasAssertionAnalysis(Application app) {
		for (Method m : app.getMethods()) {
			for (Statement s : m.getStatements()) {
				if (s instanceof AssertAliases) {
					inspectAssertion((AssertAliases)s);
				}
			}
		}
	}
	
	private void inspectAssertion(AssertAliases s) {
		if (isVariableAssertable(s.a, s.targetStatement, s) && isVariableAssertable(s.b, s.targetStatement, s)) {
			valid.add(s);
		}
	}
	
	private boolean isVariableAssertable(Variable var, Statement target, Statement assertion) {
		Set<Statement> atTarget = new HashSet<Statement>();
		Set<Statement> atAssertion = new HashSet<Statement>();
		
		findAssignmentsOf(assertion, var, atAssertion, new HashSet<Statement>());
		findAssignmentsOf(target, var, atTarget, new HashSet<Statement>());
		
		return atTarget.containsAll(atAssertion);
	}
	
	private void findAssignmentsOf(Statement from, Variable var, Set<Statement> result, Set<Statement> active) {
		if (active.contains(from))
			return;
		active.add(from);
		boolean kill = false;
		if (from instanceof StringBufferAssignment) {
			if (((StringBufferAssignment)from).to == var) {
				kill = true;
				result.add(from);
			}
		}
		else if (from instanceof ArrayAssignment) {
			if (((ArrayAssignment)from).to == var) {
				kill = true;
				result.add(from);
			}
		}
		
		if (!kill) {
			for (Statement pred : from.getPreds()) {
				findAssignmentsOf(pred, var, result, active);
			}
		}
	}
	
	/**
	 * Returns whether the specified aliasing assertion is valid.
	 */
	public boolean isValid(AssertAliases s) {
		return valid.contains(s);
	}
}
