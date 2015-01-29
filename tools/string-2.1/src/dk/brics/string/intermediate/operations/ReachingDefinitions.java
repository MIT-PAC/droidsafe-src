package dk.brics.string.intermediate.operations;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import dk.brics.string.Debug;
import dk.brics.string.intermediate.Application;
import dk.brics.string.intermediate.Method;
import dk.brics.string.intermediate.Statement;
import dk.brics.string.intermediate.Variable;

/**
 * Intra-procedural reaching definitions analysis performed on a set of methods.
 * <p/>
 * Reaching definitions are only made on local variables; not on fields.
 */
public class ReachingDefinitions {

    /**
     * For each statement and each used variable, which statements might have defined its value.
     */
    private Map<Statement, Map<Variable, Set<Statement>>> flow_info;
    
    /**
     * Definitely defined variables for each statement.
     */
    private DefinesVisitor dvs;
    
    /**
     * Maybe defined variables for each statement.
     */
    private DefinesVisitor dva;
    

	public ReachingDefinitions(Application app, LivenessAnalysis la, AliasAnalysis aa) {
        flow_info = new HashMap<Statement, Map<Variable, Set<Statement>>>();
        dvs = new DefinesVisitor(aa, true); // definitely defined variables for each statement
        dva = new DefinesVisitor(aa, false); // maybe defined variables for each statement
        
        for (Method m : app.getMethods()) {
            for (Statement s : m.getStatements()) {
                for (Variable v : dva.definedVars(s)) { // for each maybe defined variable v in each statement s...
                    // we don't want reaching definitions for fields
                    if (v.getField() != null)
                        continue;
                    
                    LinkedList<Statement> queue = new LinkedList<Statement>();
                    Set<Statement> seen = new HashSet<Statement>();
                    queue.addAll(s.getSuccs());
                    while (!queue.isEmpty()) { // look along successors ss...
                        Statement ss = queue.removeFirst();
                        if (!seen.contains(ss)) {
                            seen.add(ss);
                            putDef(ss, v, s); // if ss uses v then s might have defined it
                            if (!dvs.defines(ss, v) && la.getLiveAfter(ss).contains(v)) // continue along successors if v is live and not defined by ss
                            {
                                queue.addAll(ss.getSuccs());
                            }
                        }
                    }
                }
            }
        }
    }

    private void putDef(Statement s, Variable v, Statement def) {
        if (!flow_info.containsKey(s)) {
            flow_info.put(s, new HashMap<Variable, Set<Statement>>());
        }
        if (!flow_info.get(s).containsKey(v)) {
            flow_info.get(s).put(v, new HashSet<Statement>());
        }
        flow_info.get(s).get(v).add(def);
    }


    /**
     * Returns the (unmodifiable) set of definitions of the given variable reaching the given statement.
     * The result is sorted if in test mode.
     *
     * @param s the reached statement.
     * @param v the variable.
     * @return a set of {@link dk.brics.string.intermediate.Statement} objects.
     */
    public Set<Statement> getReachingDefs(Statement s, Variable v) {
        Set<Statement> t;
        if (flow_info.containsKey(s) && flow_info.get(s).containsKey(v)) {
            t = flow_info.get(s).get(v);
        } else {
            t = Collections.emptySet();
        }
        if (Debug.isTest()) {
            t = new TreeSet<Statement>(t);
        }
        return Collections.unmodifiableSet(t);
    }
    
}
