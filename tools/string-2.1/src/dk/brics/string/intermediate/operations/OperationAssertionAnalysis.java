package dk.brics.string.intermediate.operations;

import java.util.HashSet;
import java.util.Set;

import dk.brics.string.intermediate.Application;
import dk.brics.string.intermediate.AssertAliases;
import dk.brics.string.intermediate.AssertBinaryOp;
import dk.brics.string.intermediate.AssertStatement;
import dk.brics.string.intermediate.AssertUnaryOp;
import dk.brics.string.intermediate.Method;
import dk.brics.string.intermediate.Statement;
import dk.brics.string.intermediate.Variable;

/**
 * Determines which assertions are "safe". An assertion statement asserts that some condition was true
 * the last time a target statement was executed. An assertion is safe if that condition is guaranteed
 * to also hold at the location of the assertion, assuming it was true when the target statement was executed.
 * 
 * @author Asger
 *
 */
public class OperationAssertionAnalysis {
    
    private Set<AssertStatement> validAssertions = new HashSet<AssertStatement>();
    private ReachingDefinitions definitions;
    
    public OperationAssertionAnalysis(Application app, ReachingDefinitions definitions) {
        this.definitions = definitions;
        for (Method method : app.getMethods()) {
            for (Statement statement : method.getStatements()) {
                if (statement instanceof AssertStatement) {
                    inspectAssertion((AssertStatement)statement);
                }
            }
        }
    }
    
    private void inspectAssertion(AssertStatement statement) {
        if (statement instanceof AssertBinaryOp) {
            AssertBinaryOp a = (AssertBinaryOp)statement;
            if (isVariableAssertable(a.from, a.targetStatement, a) && isVariableAssertable(a.to, a.targetStatement, a)) {
                validAssertions.add(a);
            }
        }
        else if (statement instanceof AssertUnaryOp) {
            AssertUnaryOp a = (AssertUnaryOp)statement;
            if (isVariableAssertable(a.to, a.targetStatement, a)) {
                validAssertions.add(a);
            }
        }
    }
    private boolean isVariableAssertable(Variable var, Statement target, Statement assertion) {
        Set<Statement> reachTarget = definitions.getReachingDefs(target, var);
        Set<Statement> reachAssertion = definitions.getReachingDefs(assertion, var);
        for (Statement s : reachAssertion) {
            if (s instanceof AssertStatement)
                continue;
            if (!reachTarget.contains(s))
                return false;
        }
        return true;
    }
    
    public boolean isAssertionValid(AssertStatement statement) {
    	if (statement instanceof AssertAliases)
    		throw new IllegalArgumentException("Aliasing assertions must be queried with the early assertion analysis");
        return validAssertions.contains(statement);
    }
    
}
