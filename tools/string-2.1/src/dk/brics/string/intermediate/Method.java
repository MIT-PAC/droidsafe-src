package dk.brics.string.intermediate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * A Java method.
 * <p/>
 * A method has a body consisting of a list of statements, the first of which
 * is called the entry statement. The statements are connected by
 * control flow edges, forming a directed graph.
 * <p/>
 * The method's parameters are each represented by two variables: One referred to as the <i>parameter</i>, and one
 * referred to as the <i>parameter alias</i>. When the body of a method assigns a new value to a parameter, it is
 * the <i>alias</i> whose value is changed, such that the <i>parameter</i> variables always remember the original arguments to the method.
 * The idea behind this is best illustrated with an example. Consider this small program:
 * <pre>
 * void foo(StringBuffer a) {
 *     a = new StringBuffer;
 *     corrupt a;
 *     return;
 * }
 * ..
 * StringBuffer b = new StringBuffer;
 * foo(b);
 * // is b now corrupt??
 * </pre>
 * As the comment at the end suggests, we want to know which arguments might be corrupted by a method call.
 * Therefore, at the pseudo-statement "<tt>corrupt a</tt>", we want to know whether or not "<tt>a</tt>" refers to one of the original
 * arguments. In this case, the <i>parameter alias</i> "<tt>a</tt>" was reassigned and is no longer an alias for the <i>parameter</i>, so "<tt>b</tt>" was
 * not corrupted.
 */
public class Method {
    
    private Application application;

    private List<Statement> sl = new ArrayList<Statement>(); // statements in the method
    private List<Return> rs = new ArrayList<Return>(); // return statements in this method
    private List<Call> sites = new LinkedList<Call>(); // call sites calling this method

    private String name; // the name of the method
    private MethodHead entry; // the method head for the method
    private Variable[] param_alias; // variables for mutables, nulls for immutable and irrelevant params
    
    private ExceptionalReturn exceptionalReturn;


	private int key;
    
    /**
     * Creates a new method with the given name and parameters.
     * Only parameters of relevant types are represented.
     * A {@link dk.brics.string.intermediate.MethodHead} object is created
     * as the entry point for the method, inheriting the parameters.
     */
    public Method(Application application, String name, Variable[] params) {
        this.application = application;
        this.key = application.addMethod(this);
        this.name = name;
        this.entry = new MethodHead(params);
        this.param_alias = new Variable[params.length];
        this.exceptionalReturn = new ExceptionalReturn();
        for (int i = 0; i < params.length; i++) {
            if (params[i].isMutable()) {
                param_alias[i] = application.createVariable(params[i].getType());
            }
        }
        addStatement(entry);
        addStatement(exceptionalReturn);
    }
    
    /**
     * Returns the application containing this method.
     * @return application reference
     */
    public Application getApplication() {
        return application;
    }
    
    /**
     * Adds the given statement to the list of statements for this method.
     * @exception IllegalStateException if the statement is already added to a method
     */
    public void addStatement(Statement s) {
        if (s.getMethod() != null) {
            throw new IllegalStateException("Statement is already added to a method");
        }
        s.setIndex(sl.size());
        sl.add(s);
        s.setMethod(this);
        if (s instanceof Return) {
            rs.add((Return) s);
        }
        if (s instanceof Call) {
            ((Call) s).target.sites.add((Call) s);
        }
        
        // notify application
        application.addStatement(s);
    }
    
    /**
     * Removes the given {@link dk.brics.string.intermediate.Nop}
     * statement from the body of this method. All control flow
     * edges are updated accordingly.
     */
    public void removeNop(Nop s) {
        Collection<Statement> preds = s.getPreds();
        Collection<Statement> succs = s.getSuccs();
        for (Statement succ : succs) {
            if (s != succ) {
                succ.addPreds(preds);
                succ.removePred(s);
            }
        }
        for (Statement pred : preds) {
            if (s != pred) {
                pred.addSuccs(succs);
                pred.removeSucc(s);
            }
        }
        sl.remove(s);
    }

    /**
     * Returns an (unmodifiable) list of all call sites calling this method.
     */
    public List<Call> getCallSites() {
        return Collections.unmodifiableList(sites);
    }

    /**
     * Returns the entry point of this method.
     */
    public MethodHead getEntry() {
        return entry;
    }

    /**
     * Returns the name of this method.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the (unmodifiable) list of statements for this method.
     */
    public List<Statement> getStatements() {
        return Collections.unmodifiableList(sl);
    }

    /**
     * Returns the (unmodifiable) list of return points for this method.
     */
    public List<Return> getReturns() {
        return Collections.unmodifiableList(rs);
    }

    /**
     * Returns the list of alias variables for the method parameters,
     * with non-null entries for mutables.
     */
    public Variable[] getParamAlias() {
        return param_alias;
    }
    
    public int getKey() {
        return key;
    }
    
    /**
     * Gets the exceptional exit from this method.
     * @return a statement in this method
     */
    public ExceptionalReturn getExceptionalReturn() {
		return exceptionalReturn;
	}

    /**
     * Returns identifier of this method object.
     */
    @Override
    public String toString() {
        return "M" + key;
	}
}
