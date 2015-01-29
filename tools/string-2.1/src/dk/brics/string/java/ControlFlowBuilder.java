package dk.brics.string.java;

import java.util.Stack;

import dk.brics.string.intermediate.Method;
import dk.brics.string.intermediate.Nop;
import dk.brics.string.intermediate.Statement;
import dk.brics.string.util.Pair;

/**
 * Utility class assisting in the construction of method bodies.
 * <p/>
 * The control-flow builder acts as a <i>cursor</i> in the control-flow graph.
 * When a new statement is added, it becomes the successor of the statement under the cursor,
 * and the cursor then moves to the new statement. As a result, successive calls to {@link #addStatement}
 * creates a chain of statement nodes.
 * <p/>
 * The control-flow graph can be split with {@link #startBranch()}. After calling, one or more calls
 * to {@link #useBranch()} must be made at points where the branches should join. Finally {@link #endBranch()}
 * should be called after the last {@link #useBranch()}. For example, to create the following control-flow,
 * <pre>
 *     A
 *   / | \
 *  B  C  D
 *  |  |  |
 *  E  |  |
 *   \ | /
 *     F
 * </pre>
 * one could add the statements in this fashion:
 * <pre>
 * A
 * startBranch()
 * B
 * E
 * useBranch()
 * C
 * useBranch()
 * D
 * useBranch()
 * endBranch()
 * F
 * </pre>
 */
public class ControlFlowBuilder {
    private Method method;
    private boolean branchWasUsed = false;
    private Stack<Branching> branches = new Stack<Branching>();
    
    /**
     * Entry point for the graph being created for the current jimple statement.
     */
    private Statement firstStatement;
    
    /**
     * The most recently added statement. When all statement are created, this will
     * be the exit point for the statement's graph, because they can only be
     * created in topological order.
     */
    private Statement lastStatement;
    
    private static final class Branching {
        public Statement start;
        public Statement end;
        public Branching(Statement start, Statement end) {
            this.start = start;
            this.end = end;
        }
    }
    
    /**
     * Creates a builder for inserting statements in the specified method's body.
     * The builder's cursor will initially be in isolation, so added statements will not
     * be reachable.
     * @param method an intermediate method to add statements to.
     */
    public ControlFlowBuilder(Method method) {
        this.method = method;
    }
    
    /**
     * Moves the cursor to the specified statement, so new statements will
     * be successors of the specified statement.
     * @param to statement to add from.
     * @exception IllegalStateException if a branch is currently unclosed.
     * @exception IllegalArgumentException if the specified statement belongs to a different method than the builder 
     */
    public void moveToStatement(Statement to) {
        if (branches.size() > 0)
            throw new IllegalStateException("Unclosed branch");
        if (to.getMethod() != method)
            throw new IllegalArgumentException("Statement belongs to a different method");
        firstStatement = to;
        lastStatement = to;
    }
    
    /**
     * Removes the cursor from the control-flow graph, so statements will be placed in
     * an isolated subgraph of their own. The statements can later be connected with
     * the of the graph.
     */
    public void moveToIsolation() {
        if (branches.size() > 0)
            throw new IllegalStateException("Unclosed branch");
        firstStatement = null;
        lastStatement = null;
    }
    
    /**
     * Finishes the subgraph created by the builder, and returns the first and last statement in the subgraph.
     * The first statement will be either:
     * <ul>
     * <li>the statement set with {@link #moveToStatement},
     * <li>the first statement added with {@link #addStatement}, or
     * <li>a {@link Nop} statement preceeding all statements added with {@link #addStatement}.
     * </ul>
     * The last statement will either be the last statement added with {@link #addStatement}, or a {@link Nop}
     * succeeding it.
     */
    public Pair<Statement, Statement> finish() {
        if (branches.size() > 0) {
            throw new IllegalStateException("A local branch was not closed. Each startBranch must have a corresponding call to endBranch");
        }
        if (firstStatement == null) {
            addStatement(new Nop());
        }
        Pair<Statement, Statement> pair = new Pair<Statement, Statement>(firstStatement, lastStatement);
        firstStatement = null;
        lastStatement = null;
        return pair;
    }
    
    /**
     * Starts a new branching and opens one branch in it.
     * Multiple levels of branching can open at once.
     * See {@link ControlFlowBuilder} for a description of the branching methods.
     */
    public void startBranch() {
        // if no statement has been created, add a Nop as the start of the branch
        if (firstStatement == null) {
            addStatement(new Nop());
        }
        Statement start = lastStatement;
        Statement end = new Nop();
        branchWasUsed = false;
        branches.add(new Branching(start, end));
        method.addStatement(end);
    }

    /**
     * Ends the current branch and starts a new one.
     * See {@link ControlFlowBuilder} for a description of the branching methods.
     */
    public void useBranch() {
        if (branches.empty()) {
            throw new IllegalStateException("No open branch. Call startBranch first");
        }
        // if more than one empty branch is used, we could get double edges,
        // so we use the -IfAbsent variant to avoid those.
        lastStatement.addSuccIfAbsent(branches.peek().end);
        lastStatement = branches.peek().start;
        branchWasUsed = true;
    }

    /**
     * Ends the current branching. Must be called directly after {@link #useBranch()}.
     * See {@link ControlFlowBuilder} for a description of the branching methods.
     */
    public void endBranch() {
        if (branches.empty() || lastStatement != branches.lastElement().start) {
            throw new IllegalStateException("endBranch must be immediately preceeded by useBranch or startBranch");
        }
        if (!branchWasUsed) {
            throw new IllegalStateException("A branch must have at least one possible path");
        }
        Branching branch = branches.pop();
        lastStatement = branch.end;
    }
    
    /**
     * Adds a statement at the current position in the control flow graph
     * being built. The statement will be added to the method, set as successor
     * to the previous "cursor" statement, and then made the "cursor" statement itself.
     * @param s a statement to add.
     */
    public void addStatement(Statement s) {
        method.addStatement(s);
        if (firstStatement == null) {
            firstStatement = s;
        } else {
            lastStatement.addSucc(s);
        }
        lastStatement = s;
    }
}
