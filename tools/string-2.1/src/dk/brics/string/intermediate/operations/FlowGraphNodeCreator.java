package dk.brics.string.intermediate.operations;

import java.util.HashMap;
import java.util.Map;

import dk.brics.automaton.Automaton;
import dk.brics.string.flow.AssignmentNode;
import dk.brics.string.flow.FlowGraph;
import dk.brics.string.flow.Node;
import dk.brics.string.flow.operations.FlowGraph2Grammar;
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
import dk.brics.string.stringoperations.Basic;

/**
 * Translates a set of methods into a flow graph with no edges.
 * For every statement, a node is created for each potentially defined variable.
 * Edges are added by a {@link dk.brics.string.intermediate.operations.FlowGraphEdgeCreator}.
 *
 * @see FlowGraph2Grammar
 */
public class FlowGraphNodeCreator implements StatementVisitor {

    private FlowGraph g;

    /**
     * All nodes for each statement.
     */
    private Map<Statement, Map<Variable, Node>> map;
    
    private Map<Field, AssignmentNode> fieldNodes;

    /**
     * Main node for each statement.
     */
    private Map<Statement, Node> trans_map;

    private AliasAnalysis aa;

    private DefinesVisitor dv;

    private DefinesVisitor dva;

    private Automaton empty = Basic.makeNoString();

    /**
     * Language for variables that are considered corrupt. By default this
     * will be the language containing all strings.
     */
    private Automaton corruptAutomaton = Basic.makeAnyString();

    /**
     * Current statement.
     */
    private Statement s;

    /**
     * Current defined variable.
     */
    private Variable v;
    
    private OperationAssertionAnalysis ass;
    
    /**
     * Creates nodes in the flow graph, using the set of all strings as the value for
     * all corrupt values.
     * @param app the intermediate representation
     * @param aa alias analysis of the intermediate representation
     */
    public FlowGraphNodeCreator(Application app, AliasAnalysis aa, OperationAssertionAnalysis ass) {
    	this(app, aa, Basic.makeAnyString(), ass);
    }
    
    /**
     * Creates nodes in the flow graph, using a specified language as the value for
     * all corrupt values.
     * @param app the intermediate representation
     * @param aa alias analysis of the intermediate representation
     * @param corruptAutomaton language to use for all corrupt variables
     */
    public FlowGraphNodeCreator(Application app, AliasAnalysis aa, Automaton corruptAutomaton, OperationAssertionAnalysis ass) {
        this.aa = aa;
        this.ass = ass;
        this.corruptAutomaton = corruptAutomaton;
        dv = new DefinesVisitor();
        dva = new DefinesVisitor(aa);
        g = new FlowGraph();
        map = new HashMap<Statement, Map<Variable, Node>>();
        fieldNodes = new HashMap<Field, AssignmentNode>();
        trans_map = new HashMap<Statement, Node>();

        for (Method m : app.getMethods()) {
            for (Statement st : m.getStatements()) {
                s = st;
                map.put(s, new HashMap<Variable, Node>());
                for (Variable vi : dva.definedVars(s)) {
                    v = vi;
                    s.visitBy(this); // visit each defined variable (including aliases) for each statement
                    if (dv.defines(s, v)) {
                        trans_map.put(s, map.get(s).get(v));
                    }
                    if (vi.isTaint()) {
                        Node n = map.get(s).get(v);
                        if (n != null) {
                            n.setTaint(true);
                        }
                    }
                }
            }
        }

        for (Map<Variable, Node> vmap : map.values()) {
            for (Variable v : vmap.keySet()) { // TODO: inefficient, use entrySet iterator instead
                Node n = vmap.get(v);
                n.setTaint(v.isTaint());
            }
        }
        
        // create field nodes
        for (Field field : app.getFields()) {
            fieldNodes.put(field, g.addAssignmentNode());
        }
    }

    public Map<Field, AssignmentNode> getFieldNodes() {
        return fieldNodes;
    }

    /**
     * Returns the graph being constructed.
     */
    public FlowGraph getGraph() {
        return g;
    }

    /**
     * Returns map containing all nodes for each statement.
     */
    public Map<Statement, Map<Variable, Node>> getMap() {
        return map;
    }

    /**
     * Returns map containing main node for each statement.
     */
    public Map<Statement, Node> getTranslationMap() {
        return trans_map;
    }

    private void addNode(Node n) {
        map.get(s).put(v, n);
    }
    
    public void visitPrimitiveAssignment(PrimitiveAssignment s) {
        addNode(g.addAssignmentNode());
    }
    public void visitPrimitiveInit(PrimitiveInit s) {
        addNode(g.addInitializationNode(s.regexp));
    }
    public void visitStringBufferAppendChar(StringBufferAppendChar s) {
        addNode(g.addConcatenationNode());
    }
    public void visitBasicUnaryOp(BasicUnaryOp s) {
        addNode(g.addUnaryNode(s.op));
    }
    public void visitBasicBinaryOp(BasicBinaryOp s) {
        addNode(g.addBinaryNode(s.op));
    }
    public void visitAssertBinaryOp(AssertBinaryOp s) {
        if (ass.isAssertionValid(s)) {
            addNode(g.addBinaryNode(s.op));
        } else {
            addNode(g.addAssignmentNode());
        }
    }
    public void visitAssertUnaryOp(AssertUnaryOp s) {
        if (ass.isAssertionValid(s)) {
            addNode(g.addUnaryNode(s.op));
        } else {
            addNode(g.addAssignmentNode());
        }
    }
    public void visitAssertAliases(AssertAliases s) {
    }
    
    public void visitArrayAssignment(ArrayAssignment s) {
        addNode(g.addAssignmentNode());
    }

    public void visitArrayCorrupt(ArrayCorrupt s) {
        addNode(g.addInitializationNode(corruptAutomaton));
    }
    
    public void visitArrayAddAll(ArrayAddAll s) {
        addNode(g.addAssignmentNode());
    }

    public void visitArrayFromArray(ArrayFromArray s) {
        addNode(g.addAssignmentNode());
    }

    public void visitArrayNew(ArrayNew s) {
        addNode(g.addInitializationNode(empty));
    }

    public void visitArrayWriteArray(ArrayWriteArray s) {
        addNode(g.addAssignmentNode());
    }

    public void visitArrayWriteElement(ArrayWriteElement s) {
        addNode(g.addAssignmentNode());
    }

    public void visitCall(Call s) {
        addNode(g.addAssignmentNode());
    }

    public void visitMethodHead(MethodHead s) {
        addNode(g.addAssignmentNode());
    }

    public void visitNop(Nop s) {
    }

    public void visitReturn(Return s) {
    }

    public void visitStringAssignment(StringAssignment s) {
        addNode(g.addAssignmentNode());
    }

    public void visitStringBufferAppend(StringBufferAppend s) {
        addNode(g.addConcatenationNode());
    }

    public void visitStringBufferAssignment(StringBufferAssignment s) {
        addNode(g.addAssignmentNode());
    }

    public void visitStringBufferBinaryOp(StringBufferBinaryOp s) {
        addNode(g.addBinaryNode(s.op));
    }

    public void visitStringBufferCorrupt(StringBufferCorrupt s) {
        addNode(g.addInitializationNode(corruptAutomaton));
    }

    public void visitStringBufferInit(StringBufferInit s) {
        addNode(g.addAssignmentNode());
    }

    public void visitStringBufferPrepend(StringBufferPrepend s) {
        addNode(g.addConcatenationNode());
    }

    public void visitStringBufferUnaryOp(StringBufferUnaryOp s) {
        addNode(g.addUnaryNode(s.op));
    }

    public void visitStringConcat(StringConcat s) {
        addNode(g.addConcatenationNode());
    }

    public void visitStringFromArray(StringFromArray s) {
        if (aa.getInfoBefore(s).isCorrupt(s.from)) {
            addNode(g.addInitializationNode(corruptAutomaton));
        } else {
            addNode(g.addAssignmentNode());
        }
    }
    public void visitPrimitiveFromArray(PrimitiveFromArray s) {
        if (aa.getInfoBefore(s).isCorrupt(s.from)) {
            addNode(g.addInitializationNode(Automaton.makeAnyChar()));
        } else {
            addNode(g.addAssignmentNode());
        }
    }

    public void visitStringFromStringBuffer(StringFromStringBuffer s) {
        if (aa.getInfoBefore(s).isCorrupt(s.from)) {
            addNode(g.addInitializationNode(corruptAutomaton));
        } else {
            addNode(g.addAssignmentNode());
        }
    }

    public void visitStringInit(StringInit s) {
        addNode(g.addInitializationNode(s.regexp));
    }
    
	public void visitObjectAssignment(ObjectAssignment s) {
		addNode(g.addAssignmentNode());
	}
	
	public void visitObjectCorrupt(ObjectCorrupt s) {
		addNode(g.addInitializationNode(corruptAutomaton));
	}
	
	public void visitHotspot(Hotspot s) {
		addNode(g.addAssignmentNode());
	}
	
	public void visitFieldAssignment(FieldAssignment s) {
		addNode(g.addAssignmentNode());
	}
	
	public void visitFieldReference(FieldReference s) {
		addNode(g.addAssignmentNode());
	}
	
	public void visitCatch(Catch s) {
		addNode(g.addAssignmentNode());
	}
	public void visitExceptionalReturn(ExceptionalReturn s) {
		addNode(g.addAssignmentNode());
	}
}
