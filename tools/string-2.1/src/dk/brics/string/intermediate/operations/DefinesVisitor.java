package dk.brics.string.intermediate.operations;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import dk.brics.string.Debug;
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
import dk.brics.string.intermediate.FieldAssignment;
import dk.brics.string.intermediate.FieldReference;
import dk.brics.string.intermediate.Hotspot;
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
 * A statement visitor for querying the set of local variables and fields
 * written to by a statement, including aliases if provided.
 * <p/>
 * Call statements do not define fields, but they do define mutable arguments.
 */
public class DefinesVisitor implements StatementVisitor {

    /**
     * Optional alias analysis.
     */
    private AliasAnalysis aa;

    /**
     * If true, only include variables that are definitely written to.
     */
    private boolean strict;

    /**
     * Current statement.
     */
    private Statement s;

    /**
     * Set by visit methods.
     */
    private Set<Variable> vars;
    
    /**
     * Creates a new visitor that does not consider aliasing.
     */
    public DefinesVisitor() {
        this(null, false);
    }

    /**
     * Creates a new visitor that considers the given aliasing information.
     */
    public DefinesVisitor(AliasAnalysis aa) {
        this(aa, false);
    }

    /**
     * Creates a new visitor that considers the given aliasing information,
     * optionally only considering variables that are <em>definitely</em> written to.
     */
    public DefinesVisitor(AliasAnalysis aa, boolean strict) {
        this.aa = aa;
        this.strict = strict;
    }

    /**
     * Checks whether the given variable is defined by the statement.
     */
    public boolean defines(Statement s, Variable var) {
        return definedVars(s).contains(var);
    }

    /**
     * Returns the (unmodifiable) set of variables defined by the statement.
     * The result is sorted if in test mode.
     */
    public Set<Variable> definedVars(Statement s) {
        this.s = s;
        s.visitBy(this);
        Set<Variable> t = vars;
        vars = null;
        if (Debug.isTest()) {
            t = new TreeSet<Variable>(t);
        }
        return Collections.unmodifiableSet(t);
    }

    /**
     * Adds the given variable and its aliases.
     */
    private void aliasOp(Variable to) {
        vars = new HashSet<Variable>();
        vars.add(to);
        if (aa != null) {
            vars.addAll(aa.getInfoBefore(s).getAliasesForExclusive(to, strict));
        }
    }
    
    private void singletonOp(Variable to) {
        vars = Collections.singleton(to);
    }
    private void emptyOp() {
        vars = Collections.emptySet();
    }
    
    public void visitPrimitiveAssignment(PrimitiveAssignment s) {
        singletonOp(s.to);
    }
    public void visitPrimitiveInit(PrimitiveInit s) {
        singletonOp(s.to);
    }
    public void visitStringBufferAppendChar(StringBufferAppendChar s) {
        singletonOp(s.to);
    }
    public void visitBasicUnaryOp(BasicUnaryOp s) {
        singletonOp(s.to);
    }
    public void visitBasicBinaryOp(BasicBinaryOp s) {
        singletonOp(s.to);
    }
    public void visitAssertBinaryOp(AssertBinaryOp s) {
        aliasOp(s.to);
    }
    public void visitAssertUnaryOp(AssertUnaryOp s) {
        aliasOp(s.to);
    }
    public void visitAssertAliases(AssertAliases s) {
    	emptyOp();
    }
    
    public void visitArrayAssignment(ArrayAssignment s) {
        singletonOp(s.to);
    }

    public void visitArrayCorrupt(ArrayCorrupt s) {
        aliasOp(s.to);
    }
    
    public void visitArrayAddAll(ArrayAddAll s) {
        aliasOp(s.to);
    }

    public void visitArrayFromArray(ArrayFromArray s) {
        singletonOp(s.to);
    }

    public void visitArrayNew(ArrayNew s) {
        singletonOp(s.to);
    }

    public void visitArrayWriteArray(ArrayWriteArray s) {
        if (strict) {
            emptyOp();
        } else {
            aliasOp(s.to);
        }
    }

    public void visitArrayWriteElement(ArrayWriteElement s) {
        if (strict) {
            emptyOp();
        } else {
            aliasOp(s.to);
        }
    }

    public void visitCall(Call s) { // add retvar and all (aliases to) mutable parameters
        vars = new HashSet<Variable>();
        vars.add(s.retvar);
        for (int i = 0; i < s.args.length; i++) {
        	if (!s.args[i].isMutable())
        		continue;
        	vars.add(s.args[i]);
            if (aa != null) {
                vars.addAll(aa.getInfoBefore(s).getAliasesForExclusive(s.args[i], strict));
            }
        }
    }
    
    public void visitMethodHead(MethodHead s) { // add all formal parameters and their alias variables
        vars = new HashSet<Variable>();
        Variable[] pa = s.getMethod().getParamAlias();
        for (int i = 0; i < s.params.length; i++) {
            vars.add(s.params[i]);
            if (aa != null && pa[i] != null) {
                vars.add(pa[i]);
            }
        }
    }
    
    public void visitNop(Nop s) {
        emptyOp();
    }

    public void visitReturn(Return s) {
        emptyOp();
    }

    public void visitStringAssignment(StringAssignment s) {
        singletonOp(s.to);
    }

    public void visitStringBufferAppend(StringBufferAppend s) {
        aliasOp(s.to);
    }

    public void visitStringBufferAssignment(StringBufferAssignment s) {
        singletonOp(s.to);
    }

    public void visitStringBufferBinaryOp(StringBufferBinaryOp s) {
        aliasOp(s.to);
    }

    public void visitStringBufferCorrupt(StringBufferCorrupt s) {
        aliasOp(s.to);
    }

    public void visitStringBufferInit(StringBufferInit s) {
        singletonOp(s.to);
    }

    public void visitStringBufferPrepend(StringBufferPrepend s) {
        aliasOp(s.to);
    }

    public void visitStringBufferUnaryOp(StringBufferUnaryOp s) {
        aliasOp(s.to);
    }

    public void visitStringConcat(StringConcat s) {
        singletonOp(s.to);
    }

    public void visitStringFromArray(StringFromArray s) {
        singletonOp(s.to);
    }
    public void visitPrimitiveFromArray(PrimitiveFromArray s) {
        singletonOp(s.to);
    }

    public void visitStringFromStringBuffer(StringFromStringBuffer s) {
        singletonOp(s.to);
    }

    public void visitStringInit(StringInit s) {
        singletonOp(s.to);
    }

	public void visitObjectAssignment(ObjectAssignment s) {
		singletonOp(s.to);
	}

	public void visitObjectCorrupt(ObjectCorrupt s) {
		aliasOp(s.to);
	}

	public void visitHotspot(Hotspot s) {
		singletonOp(s.to);
	}
	
	public void visitFieldAssignment(FieldAssignment s) {
		vars = new HashSet<Variable>();
		if (strict && !s.getField().isStatic()) {
			// instance fields are only weakly defined
		} else {
			aliasOp(s.getTo());
		}
	}
	
	public void visitFieldReference(FieldReference s) {
		singletonOp(s.getTo());
	}
	
	public void visitCatch(Catch s) {
		// Catch weakly defines all mutable arguments passed to calls in its
		// try block, to accommodate for their exceptional returns.
		// Non-call statement cannot define variables if they throw an exception,
		// so they need not be handled by Catch.
		vars = new HashSet<Variable>();
		
		// the variables are weakly defined.
		if (strict)
			return;
		
		for (Statement pred : s.getPreds()) {
			if (!(pred instanceof Call))
				continue;
			
			Call call = (Call)pred;
			
			for (Variable arg : call.args){
				if (arg.isMutable() && !arg.isField()) {
					vars.add(arg);
					
					// also define aliases
					if (aa != null) {
						vars.addAll(aa.getInfoBefore(call).getAliasesForExclusive(arg, false));
					}
				}
			}
		}
	}
	
	public void visitExceptionalReturn(ExceptionalReturn s) {
		vars = new HashSet<Variable>();
		if (strict)
			return;
		
		vars.addAll(Arrays.asList(s.getMethod().getEntry().params));
	}
}
