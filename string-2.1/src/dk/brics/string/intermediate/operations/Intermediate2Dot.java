package dk.brics.string.intermediate.operations;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import dk.brics.string.Misc;
import dk.brics.string.intermediate.Application;
import dk.brics.string.intermediate.ExceptionalReturn;
import dk.brics.string.intermediate.Method;
import dk.brics.string.intermediate.Statement;
import dk.brics.string.intermediate.Variable;

/**
 * Constructs Graphviz dot representation of intermediate representation.
 */
public class Intermediate2Dot {

    private Intermediate2Dot() {
    }
    
    public static String convert(Collection<? extends Method> methods, ReachingDefinitions rd, AliasAnalysis aa, OperationAssertionAnalysis ass, Set<Statement> hotspots) {
    	StringBuilder s = new StringBuilder();
        s.append("digraph IntermediateRepresentation {\n");
        for (Method method : methods) {
            convertMethod(method, s, rd, aa, ass, hotspots);
        }
        s.append("}\n");
        return s.toString();
    }
    
    /**
     * Converts the given application.
     */
    public static String convert(Application app, ReachingDefinitions rd, AliasAnalysis aa, OperationAssertionAnalysis ass, Set<Statement> hotspots) {
        return convert(app.getMethods(), rd, aa, ass, hotspots);
    }
    
    /**
     * Converts the given application.
     */
    public static String convert(Application app, ReachingDefinitions rd, AliasAnalysis aa, Set<Statement> hotspots) {
        return convert(app.getMethods(), rd, aa, null, hotspots);
    }

    private static void convertMethod(Method m, StringBuilder s, ReachingDefinitions rd, AliasAnalysis aa, OperationAssertionAnalysis ass, Set<Statement> hotspots) {
        s.append("  subgraph cluster" + m.toString() + " {\n");
        ToStringVisitor tsv = new ToStringVisitor(ass);
        for (Statement t : m.getStatements()) {
            t.visitBy(tsv);
            s.append("    " + m.toString() + 'S' + t.getIndex());
            s.append(" [label=\"" + Misc.escape(aa.getInfoBefore(t).toString()) + "\\n" + Misc.escape(tsv.result) + "\"");
            if (hotspots.contains(t)) {
                s.append(",style=bold");
            }
            s.append("]\n");
            for (Statement u : t.getSuccs()) {
                if (u instanceof ExceptionalReturn)
                    continue; // exceptional edges will flood the diagram
                s.append("    " + m.toString() + 'S' + t.getIndex() +
                        " -> " + m.toString() + 'S' + u.getIndex() + '\n');
            }
            UsesVisitor uv = new UsesVisitor();
            for (Variable v : uv.usedVars(t)) {
                for (Statement r : rd.getReachingDefs(t, v)) {
                    s.append("    " + r.getMethod() + 'S' + r.getIndex() +
                            " -> " + m.toString() + 'S' + t.getIndex() +
                            " [style=dashed,label=\"" + v + "\"]\n");
                }
            }
        }
        s.append("    label=\"" + Misc.escape(m.getName() + Arrays.toString(m.getParamAlias())));//
        s.append("\"\n  }\n");
    }
}
