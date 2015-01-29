package dk.brics.string.intermediate.operations;

import dk.brics.string.flow.FlowGraph;
import dk.brics.string.flow.Node;
import dk.brics.string.intermediate.Application;
import dk.brics.string.intermediate.Statement;

import java.util.Map;

/**
 * Converter from intermediate representation to flow graphs.
 *
 * @see dk.brics.string.StringAnalysis
 */
public class Intermediate2FlowGraph {

    private Application app;

    private FlowGraphNodeCreator nc;

    /**
     * Constructs a new converter for the given application.
     */
    public Intermediate2FlowGraph(Application app) {
        this.app = app;
    }

    /**
     * Converts the application.
     */
    public FlowGraph convert(AliasAnalysis aa, ReachingDefinitions rd, OperationAssertionAnalysis ass) {
        nc = new FlowGraphNodeCreator(app, aa, ass);
        new FlowGraphEdgeCreator(app, aa, rd, nc.getMap(), nc.getFieldNodes(), ass);
        return nc.getGraph();
    }

    /**
     * Returns map containing main node for each statement.
     * {@link #convert(AliasAnalysis, ReachingDefinitions, OperationAssertionAnalysis)} must be called first.
     */
    public Map<Statement, Node> getTranslationMap() {
        return nc.getTranslationMap();
    }
}
