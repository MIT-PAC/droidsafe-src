package dk.brics.string.intermediate.operations;

import java.util.Map;
import java.util.Set;

import dk.brics.string.flow.AssignmentNode;
import dk.brics.string.flow.BinaryNode;
import dk.brics.string.flow.ConcatenationNode;
import dk.brics.string.flow.Node;
import dk.brics.string.flow.UnaryNode;
import dk.brics.string.flow.Use;
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

/**
 * Creates all flow graph edges for a flow graph created
 * by a {@link dk.brics.string.intermediate.operations.FlowGraphNodeCreator}.
 *
 * @see FlowGraph2Grammar
 */
public class FlowGraphEdgeCreator implements StatementVisitor {

    private ReachingDefinitions rd;

    private AliasAnalysis aa;

    /**
     * All nodes (main+aliases) for each statement.
     */
    private Map<Statement, Map<Variable, Node>> map;
    
    private Map<Field, AssignmentNode> fieldNodes;

    /**
     * Current statement.
     */
    private Statement s;

    /**
     * Current variable.
     */
    private Variable v;

    /**
     * The flow graph node corresponding to the defined variable v in statement s.
     */
    private Node n;
    
    private OperationAssertionAnalysis ass;
    
    /**
     * Constructs a new flow graph connector.
     *
     * @param map after the call, this map contains all nodes (main+aliases) for each statement
     */
    public FlowGraphEdgeCreator(Application app, AliasAnalysis aa, ReachingDefinitions rd, Map<Statement, Map<Variable, Node>> map,
            Map<Field, AssignmentNode> fieldNodes, OperationAssertionAnalysis ass) {
        this.aa = aa;
        this.rd = rd;
        this.map = map;
        this.ass = ass;
        this.fieldNodes = fieldNodes;
        for (Method m : app.getMethods()) {
            for (Statement st : m.getStatements()) {
                s = st;
                for (Variable vt : map.get(s).keySet()) {
                    v = vt;
                    n = map.get(s).get(v);
                    
                    // add ingoing edges to the definition's node
                    s.visitBy(this); // visit each defined variable (including aliases) for each statement
                    
                    // if this statement defines a field, add an outgoing edge to the field's node
                    if (vt.getField() != null) {
                        fieldNodes.get(vt.getField()).getArg().addDefUse(n);
                    }
                }
            }
        }
    }

    /**
     * Add def-use edges pointing to the use node according to reaching defs for the given var.
     */
    private void link(Use use, Statement s, Variable var) {
        for (Statement ds : rd.getReachingDefs(s, var)) {
            use.addDefUse(map.get(ds).get(var));
        }
        // if this is a field variable, link from the field's node
        for (Variable alias : aa.getInfoBefore(s).getAliasesForInclusive(var, false)) {
            Field field = alias.getField();
            if (field == null)
                continue;
            
            use.addDefUse(fieldNodes.get(field));
        }
    }

    public void visitPrimitiveAssignment(PrimitiveAssignment s) {
        link(((AssignmentNode) n).getArg(), s, s.from);
    }
    public void visitPrimitiveInit(PrimitiveInit s) {
    }
    public void visitStringBufferAppendChar(StringBufferAppendChar s) {
        link(((ConcatenationNode) n).getArg1(), s, v);
        link(((ConcatenationNode) n).getArg2(), s, s.from);
    }
    public void visitBasicUnaryOp(BasicUnaryOp s) {
        link(((UnaryNode) n).getArg(), s, s.from);
    }
    public void visitBasicBinaryOp(BasicBinaryOp s) {
        link(((BinaryNode) n).getArg1(), s, s.first);
        link(((BinaryNode) n).getArg2(), s, s.second);
    }
    public void visitAssertBinaryOp(AssertBinaryOp s) {
        if (ass.isAssertionValid(s)) {
            link(((BinaryNode) n).getArg1(), s, v);
            link(((BinaryNode) n).getArg2(), s, s.from);
        } else {
            link(((AssignmentNode) n).getArg(), s, s.to);
        }
    }
    public void visitAssertUnaryOp(AssertUnaryOp s) {
        if (ass.isAssertionValid(s)) {
            link(((UnaryNode) n).getArg(), s, v);
        } else {
            link(((AssignmentNode) n).getArg(), s, s.to);
        }
    }
    public void visitAssertAliases(AssertAliases s) {
    }
    
    public void visitArrayAssignment(ArrayAssignment s) {
        link(((AssignmentNode) n).getArg(), s, s.from);
    }

    public void visitArrayCorrupt(ArrayCorrupt s) {
    }
    
    public void visitArrayAddAll(ArrayAddAll s) {
        link(((AssignmentNode) n).getArg(), s, v);
        link(((AssignmentNode) n).getArg(), s, s.from);
    }
    
    public void visitArrayFromArray(ArrayFromArray s) {
        link(((AssignmentNode) n).getArg(), s, s.from);
    }

    public void visitArrayNew(ArrayNew s) {
    }

    public void visitArrayWriteArray(ArrayWriteArray s) {
        link(((AssignmentNode) n).getArg(), s, v);
        link(((AssignmentNode) n).getArg(), s, s.from);
    }

    public void visitArrayWriteElement(ArrayWriteElement s) {
        link(((AssignmentNode) n).getArg(), s, v);
        link(((AssignmentNode) n).getArg(), s, s.from);
    }

    public void visitCall(Call s) {
        // Link returns to the defined vars
        if (v == s.retvar)
        // Link returns to the return variable
        {
            for (Return r : s.target.getReturns()) {
                link(((AssignmentNode) n).getArg(), r, r.retvar);
            }
        } else {
            // Link to other defined vars
            // so that changes in mutable parameters are propagated back to the caller
            Variable[] pa = s.target.getParamAlias();
            Set<Variable> va = aa.getInfoBefore(s).getAliasesForInclusive(v, false);
            for (int i = 0; i < s.args.length; i++) {
                if (va.contains(s.args[i])) {
                    // The variable corresponding to the
                    // current assignment node is the same as or aliased
                    // to the i'th argument. Add links from
                    // returned definitions of the i'th alias variable
                    for (Return r : s.target.getReturns()) {
                        link(((AssignmentNode) n).getArg(), r, pa[i]);
                    }
                }
            }
        }
    }
    
    public void visitMethodHead(MethodHead s) {
        // link arguments
    	Variable[] pa = s.getMethod().getParamAlias();
        for (int i = 0; i < pa.length; i++) {
            if (v == s.params[i]) // link actual to formal
            {
                for (Call c : s.getMethod().getCallSites()) {
                    link(((AssignmentNode) n).getArg(), c, c.args[i]);
                }
            }
            if (v == pa[i]) { // link formal to param alias
                Variable p = s.params[i];
                AssignmentNode an = (AssignmentNode) map.get(s).get(p);
                ((AssignmentNode) n).getArg().addDefUse(an);
            }
        }
    }
    
    public void visitNop(Nop s) {
        throw new RuntimeException("Nop node not expected here.");
    }

    public void visitReturn(Return s) {
        throw new RuntimeException("Return node not expected here.");
    }

    public void visitStringAssignment(StringAssignment s) {
        link(((AssignmentNode) n).getArg(), s, s.from);
    }

    public void visitStringBufferAppend(StringBufferAppend s) {
        link(((ConcatenationNode) n).getArg1(), s, v);
        link(((ConcatenationNode) n).getArg2(), s, s.from);
    }

    public void visitStringBufferAssignment(StringBufferAssignment s) {
        link(((AssignmentNode) n).getArg(), s, s.from);
    }

    public void visitStringBufferBinaryOp(StringBufferBinaryOp s) {
        link(((BinaryNode) n).getArg1(), s, v);
        link(((BinaryNode) n).getArg2(), s, s.from);
    }

    public void visitStringBufferCorrupt(StringBufferCorrupt s) {
    }

    public void visitStringBufferInit(StringBufferInit s) {
        link(((AssignmentNode) n).getArg(), s, s.from);
    }

    public void visitStringBufferPrepend(StringBufferPrepend s) {
        link(((ConcatenationNode) n).getArg1(), s, s.from);
        link(((ConcatenationNode) n).getArg2(), s, v);
    }

    public void visitStringBufferUnaryOp(StringBufferUnaryOp s) {
        link(((UnaryNode) n).getArg(), s, v);
    }

    public void visitStringConcat(StringConcat s) {
        link(((ConcatenationNode) n).getArg1(), s, s.left);
        link(((ConcatenationNode) n).getArg2(), s, s.right);
    }

    public void visitStringFromArray(StringFromArray s) {
        if (n instanceof AssignmentNode) {
            link(((AssignmentNode) n).getArg(), s, s.from);
        }
    }
    public void visitPrimitiveFromArray(PrimitiveFromArray s) {
        if (n instanceof AssignmentNode) {
            link(((AssignmentNode) n).getArg(), s, s.from);
        }
    }

    public void visitStringFromStringBuffer(StringFromStringBuffer s) {
        if (n instanceof AssignmentNode) {
            link(((AssignmentNode) n).getArg(), s, s.from);
        }
    }

    public void visitStringInit(StringInit s) {
    }
    
	public void visitObjectAssignment(ObjectAssignment s) {
        link(((AssignmentNode) n).getArg(), s, s.from);
	}
	
	public void visitObjectCorrupt(ObjectCorrupt s) {
	}

	public void visitHotspot(Hotspot s) {
		link(((AssignmentNode) n).getArg(), s, s.from);
	}
	
	public void visitFieldAssignment(FieldAssignment s) {
		link(((AssignmentNode) n).getArg(), s, s.getFrom());
	}
	
	public void visitFieldReference(FieldReference s) {
	    // add an edge from the field node
	    ((AssignmentNode) n).getArg().addDefUse(fieldNodes.get(s.getField()));
	}
	
	public void visitCatch(Catch s) {
		// only define variables that were not defined by the try block's normal flow
		// we only maybe define variables, so the normal definitions will still
		// reach the catch body.
		linkFromTryBlock(s);
	}
	
	public void visitExceptionalReturn(ExceptionalReturn s) {
		linkFromTryBlock(s);
		// exceptional return should also take from normal definitions
		link(((AssignmentNode) n).getArg(), s, v);
	}
	
	/**
	 * For every Call predecessor of the given statement, an edge is added
	 * from the called method's exceptional return node to the the 
	 * given statement's node.
	 * @param s statement to add edges to, caused by exceptional flow
	 */
	private void linkFromTryBlock(Statement s) {
		for (Statement pred : s.getPreds()) {
			if (!(pred instanceof Call))
				continue;
			
			Call call = (Call)pred;
			AliasInfo beforeCall = aa.getInfoBefore(call);
			ExceptionalReturn exReturn = call.target.getExceptionalReturn();
			for (int i=0; i<call.args.length; i++) {
				if (!beforeCall.mightBeAliases(v, call.args[i]))
					continue;
				
				Variable param = call.target.getEntry().params[i];
				((AssignmentNode) n).getArg().addDefUse(map.get(exReturn).get(param));
			}
		}
	}
	
}
