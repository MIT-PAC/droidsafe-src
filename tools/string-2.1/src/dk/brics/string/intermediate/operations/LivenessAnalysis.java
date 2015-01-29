package dk.brics.string.intermediate.operations;

import dk.brics.string.Debug;
import dk.brics.string.intermediate.Application;
import dk.brics.string.intermediate.Method;
import dk.brics.string.intermediate.Statement;
import dk.brics.string.intermediate.Variable;

import java.util.*;

/**
 * Intra-procedural liveness analysis performed on a set of methods.
 * <p/>
 * The formal parameters of a method are always considered live.
 */
public class LivenessAnalysis implements FlowAnalysis {

    /**
     * Live vars before each statement.
     */
    private Map<Statement, Set<Variable>> live_before;

    /**
     * Live vars after each statement.
     */
    private Map<Statement, Set<Variable>> live_after;

    private WorkList worklist;

    private UsesVisitor uv;

    private DefinesVisitor dv;

    /**
     * Performs liveness analysis.
     */
    public LivenessAnalysis(Application app) {
        live_before = new HashMap<Statement, Set<Variable>>();
        live_after = new HashMap<Statement, Set<Variable>>();
        uv = new UsesVisitor();
        dv = new DefinesVisitor();
        worklist = new WorkList(this);
        for (Method m : app.getMethods()) {
            worklist.addAll(m);
        }
        worklist.iterate();
    }

    public void transfer(Statement s) {
    	Method method = s.getMethod();
    	
        Set<Variable> after = getLiveAfter(s);
        Set<Variable> live = new HashSet<Variable>(after);
        live.removeAll(dv.definedVars(s));
        live.addAll(uv.usedVars(s));
        live.addAll(Arrays.asList(method.getEntry().params));
        live_before.put(s, live);
        for (Statement ps : s.getPreds()) {
            if (addLiveAfter(ps, live)) {
                worklist.add(ps);
            }
        }
    }

    /**
     * Returns the (unmodifiable) set of live variables as inferred just before the given statement.
     * The result is sorted if in test mode.
     *
     * @param s the statement.
     * @return a set of {@link dk.brics.string.intermediate.Variable} objects.
     */
    public Set<Variable> getLiveBefore(Statement s) {
        Set<Variable> t = live_before.get(s);
        if (Debug.isTest()) {
            t = new TreeSet<Variable>(t);
        }
        return Collections.unmodifiableSet(t);
    }

    /**
     * Returns the (unmodifiable) set of live variables as inferred just after the given statement.
     * The result is sorted if in test mode.
     *
     * @param s the statement.
     * @return a set of {@link dk.brics.string.intermediate.Variable} objects.
     */
    public Set<Variable> getLiveAfter(Statement s) {
        if (!live_after.containsKey(s)) {
            live_after.put(s, new HashSet<Variable>());
        }
        Set<Variable> t = live_after.get(s);
        if (Debug.isTest()) {
            t = new TreeSet<Variable>(t);
        }
        return Collections.unmodifiableSet(t);
    }

    /**
     * Adds live variables to he program point after the given statement.
     *
     * @param s    statement
     * @param live live variables to add
     * @return true if the set changed
     */
    public boolean addLiveAfter(Statement s, Set<Variable> live) {
        if (!live_after.containsKey(s)) {
            live_after.put(s, new HashSet<Variable>());
        }
        Set<Variable> set = live_after.get(s);
        return set.addAll(live);
    }
}
