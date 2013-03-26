package dk.brics.string.intermediate.operations;

import dk.brics.string.Debug;
import dk.brics.string.intermediate.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * A statement visitor for querying the set of variables read by a statement.
 */
public class UsesVisitor implements StatementVisitor {

    /**
     * Set by visit methods.
     */
    private Set<Variable> vars;
    
    /**
     * Creates a new visitor.
     */
    public UsesVisitor() {
    }
    
    /**
     * Checks whether the given variable is used by the statement.
     */
    public boolean uses(Statement s, Variable var) {
        return usedVars(s).contains(var);
    }

    /**
     * Returns the (unmodifiable) set of variables used by the statement.
     * The result is sorted if in test mode.
     */
    public Set<Variable> usedVars(Statement s) {
        s.visitBy(this);
        Set<Variable> t = vars;
        vars = null;
        if (Debug.isTest()) {
            t = new TreeSet<Variable>(t);
        }
        return Collections.unmodifiableSet(t);
    }

    private void emptyOp() {
        vars = Collections.emptySet();
    }

    private void singletonOp(Variable v) {
        vars = Collections.singleton(v);
    }

    private void doubleOp(Variable v1, Variable v2) {
        vars = new HashSet<Variable>();
        vars.add(v1);
        vars.add(v2);
    }
    
    public void visitPrimitiveAssignment(PrimitiveAssignment s) {
        singletonOp(s.from);
    }
    public void visitPrimitiveInit(PrimitiveInit s) {
        emptyOp();
    }
    public void visitStringBufferAppendChar(StringBufferAppendChar s) {
        doubleOp(s.to, s.from);
    }
    public void visitBasicUnaryOp(BasicUnaryOp s) {
        singletonOp(s.from);
    }
    public void visitBasicBinaryOp(BasicBinaryOp s) {
        doubleOp(s.first, s.second);
    }
    public void visitAssertBinaryOp(AssertBinaryOp s) {
        doubleOp(s.to, s.from);
    }
    public void visitAssertUnaryOp(AssertUnaryOp s) {
        singletonOp(s.to);
    }
    public void visitAssertAliases(AssertAliases s) {
    	doubleOp(s.a, s.b);
    }
    
    public void visitArrayAssignment(ArrayAssignment s) {
        singletonOp(s.from);
    }

    public void visitArrayCorrupt(ArrayCorrupt s) {
        //emptyOp();
    	singletonOp(s.to);
    }
    
    public void visitArrayAddAll(ArrayAddAll s) {
        doubleOp(s.to, s.from);
    }

    public void visitArrayFromArray(ArrayFromArray s) {
        singletonOp(s.from);
    }

    public void visitArrayNew(ArrayNew s) {
        emptyOp();
    }

    public void visitArrayWriteArray(ArrayWriteArray s) {
        doubleOp(s.to, s.from);
    }

    public void visitArrayWriteElement(ArrayWriteElement s) {
        doubleOp(s.to, s.from);
    }
    
    public void visitCall(Call s) {
        vars = new HashSet<Variable>();
        for (int i = 0; i < s.args.length; i++) {
            vars.add(s.args[i]);
        }
    }
    
    public void visitMethodHead(MethodHead s) {
        emptyOp();
    }

    public void visitNop(Nop s) {
        emptyOp(); // unreachable because nops don't exist after intermediate is complete
    }

    public void visitReturn(Return s) {
        vars = new HashSet<Variable>();
        vars.add(s.retvar);
        Variable[] pa = s.getMethod().getParamAlias();
        for (int i = 0; i < pa.length; i++) {
            if (pa[i] != null) {
            	// XXX why does return USE param aliasaes?
                vars.add(pa[i]);
            }
        }
    }
    
    public void visitStringAssignment(StringAssignment s) {
        singletonOp(s.from);
    }

    public void visitStringBufferAppend(StringBufferAppend s) {
        doubleOp(s.to, s.from);
    }

    public void visitStringBufferAssignment(StringBufferAssignment s) {
        singletonOp(s.from);
    }

    public void visitStringBufferBinaryOp(StringBufferBinaryOp s) {
        doubleOp(s.to, s.from);
    }

    public void visitStringBufferCorrupt(StringBufferCorrupt s) {
        //emptyOp();
    	singletonOp(s.to);
    }

    public void visitStringBufferInit(StringBufferInit s) {
        singletonOp(s.from);
    }

    public void visitStringBufferPrepend(StringBufferPrepend s) {
        doubleOp(s.to, s.from);
    }

    public void visitStringBufferUnaryOp(StringBufferUnaryOp s) {
        singletonOp(s.to);
    }

    public void visitStringConcat(StringConcat s) {
        doubleOp(s.left, s.right);
    }

    public void visitStringFromArray(StringFromArray s) {
        singletonOp(s.from);
    }
    public void visitPrimitiveFromArray(PrimitiveFromArray s) {
        singletonOp(s.from);
    }

    public void visitStringFromStringBuffer(StringFromStringBuffer s) {
        singletonOp(s.from);
    }

    public void visitStringInit(StringInit s) {
        emptyOp();
    }

	public void visitObjectAssignment(ObjectAssignment s) {
		singletonOp(s.from);
	}

	public void visitObjectCorrupt(ObjectCorrupt s) {
		singletonOp(s.to);
	}

	public void visitHotspot(Hotspot s) {
		singletonOp(s.from);
	}
	
	public void visitFieldAssignment(FieldAssignment s) {
		singletonOp(s.getFrom());
	}
	
	public void visitFieldReference(FieldReference s) {
	    singletonOp(s.getFrom());
	}
	
	
	public void visitCatch(Catch s) {
		emptyOp();
	}
	public void visitExceptionalReturn(ExceptionalReturn s) {
		// exceptional return uses parameters
		vars = new HashSet<Variable>();
		vars.addAll(Arrays.asList(s.getMethod().getEntry().params));
	}
}
