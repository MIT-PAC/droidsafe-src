package dk.brics.string.intermediate;

import dk.brics.string.intermediate.operations.ToStringVisitor;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * Superclass of all statements.
 * <p/>
 * A statements belongs to the body of some method.
 * It has control flow edges to and from other statements.
 */
public abstract class Statement implements Comparable<Statement> {

    private Collection<Statement> succs;
    private Collection<Statement> preds;
    private Method method;
    private int index;
    private int key;

    public Statement() {
        succs = new HashSet<Statement>();
        preds = new HashSet<Statement>();
        key = -1;
    }

    void setKey(int key) {
        this.key = key;
    }

    /**
     * Adds a control flow edge from this statement to the given.
     * The specified statement must not already be a successor.
     * If the statement might already be a successor, use {@link #addSuccIfAbsent(Statement)}
     * to add it only if it is not already there.
     *
     * @param s the target statement of the edge.
     */
    public void addSucc(Statement s) {
        if (method == null || s.method != method)
            throw new IllegalStateException("Statements must be in the same method before they can be attached with edges");
        assert !succs.contains(s) : "This statement is already a successor";
        succs.add(s);
        s.addPred(this);
    }

    /**
     * Adds a control flow edge from this statement to the given, if it was not
     * already there.
     *
     * @param s the target statement of the edge.
     * @return true if a control flow edge was created; false if it was already there.
     */
    public boolean addSuccIfAbsent(Statement s) {
    	if (method == null || s.method != method)
            throw new IllegalStateException("Statements must be in the same method before they can be attached with edges");
    	
    	if (succs.contains(s))
    		return false;
        
    	succs.add(s);
        s.addPred(this);
        
        return true;
    }

    void addPred(Statement s) {
        preds.add(s);
    }

    void removePred(Statement s) {
        preds.remove(s);
    }

    void removeSucc(Statement s) {
        succs.remove(s);
    }

    void addPreds(Collection<Statement> ss) {
        preds.addAll(ss);
    }

    void addSuccs(Collection<Statement> ss) {
        succs.addAll(ss);
    }

    /**
     * Returns (unmodifiable) collection of all targets of control flow edges originating from this node.
     *
     * @return a collection of {@link dk.brics.string.intermediate.Statement} objects.
     */
    public Collection<Statement> getSuccs() {
        return Collections.unmodifiableCollection(succs);
    }

    /**
     * Returns (unmodifiable) collection of all origins of control flow edges going to this node.
     *
     * @return a collection of {@link dk.brics.string.intermediate.Statement} objects.
     */
    public Collection<Statement> getPreds() {
        return Collections.unmodifiableCollection(preds);
    }
    
    /**
     * Sets a reference to the method containing this statement.
     * <p/>
     * This is package-private to enforce the integrity invariant on the intermediate representation.
     * @param m the method containing this statement
     */
    void setMethod(Method m) {
        method = m;
    }
    
    /**
     * Returns the method whose body contains this statement.
     *
     * @return the method.
     */
    public Method getMethod() {
        return method;
    }
    
    /**
     * Sets the statement's index.
     * <p/>
     * This is package-private to enforce the integrity invariant on the intermediate representation.
     * @param index integer unique for this statement within the body of its method.
     */
    void setIndex(int index) {
        this.index = index;
    }

    /**
     * Returns the index of this statement, indicating the sequence
     * number in which the statement was added to its method.
     *
     * @return the index.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Returns a string representation of this statement.
     * This is handled by a {@link dk.brics.string.intermediate.operations.ToStringVisitor}.
     *
     * @return the statement as a string.
     */
    @Override
    public String toString() {
        ToStringVisitor tsv = new ToStringVisitor();
        visitBy(tsv);
        return tsv.result;
    }

    /**
     * Visit this statement by the given statement visitor.
     * This will invoke the corresponding method in the visitor.
     *
     * @param v the visitor.
     */
    public abstract void visitBy(StatementVisitor v);

    public int compareTo(Statement v) {
        if (key == -1 || v.key == -1) {
            throw new IllegalStateException("statement key not set");
        }
        return key - v.key;
    }
}
