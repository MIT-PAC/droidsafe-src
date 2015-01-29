package dk.brics.string.intermediate.operations;

import dk.brics.string.intermediate.*;
import dk.brics.string.stringoperations.Basic;

/**
 * Visitor for producing string representations of statements.
 * Used by the {@link dk.brics.string.intermediate.Statement#toString toString}
 * method of {@link dk.brics.string.intermediate.Statement}.
 */
public class ToStringVisitor implements StatementVisitor {
    
    private OperationAssertionAnalysis ass;
    
    public ToStringVisitor(OperationAssertionAnalysis ass) {
        this.ass = ass;
    }
    public ToStringVisitor() {
    }
    

    /**
     * The string representaion, set by the visit methods.
     */
    public String result;

    public void visitPrimitiveAssignment(PrimitiveAssignment s) {
        result = s.to + " = " + s.from + ";";
    }
    public void visitPrimitiveInit(PrimitiveInit s) {
        result = s.to + " = " + Basic.getName(s.regexp);
    }
    public void visitStringBufferAppendChar(StringBufferAppendChar s) {
        result = s.to + ".append(" + s.from + ");";
    }
    public void visitBasicUnaryOp(BasicUnaryOp s) {
        result = s.to + " = " + s.from + "." + s.op + "();";
    }
    public void visitBasicBinaryOp(BasicBinaryOp s) {
        result = s.to + " = " + s.first + "." + s.op + "(" + s.second + ");";
    }
    public void visitAssertBinaryOp(AssertBinaryOp s) {
        result = "assert " + s.op + "(" + s.to + ","+s.from+");";
        if (ass != null && !ass.isAssertionValid(s)) {
            result = "invalid " + result;
        }
    }
    public void visitAssertUnaryOp(AssertUnaryOp s) {
        result = "assert " + s.op + "(" + s.to + ");";
        if (ass != null && !ass.isAssertionValid(s)) {
            result = "invalid " + result;
        }
    }
    public void visitAssertAliases(AssertAliases s) {
    	if (s.alias) {
    		result = "assert " + s.a + " == " + s.b;
    	} else {
    		result = "assert " + s.a + " != " + s.b;
    	}
    }
    
    public void visitArrayAssignment(ArrayAssignment s) {
        result = s.to + " = " + s.from + ";";
    }

    public void visitArrayCorrupt(ArrayCorrupt s) {
        result = "corrupt " + s.to + ";";
    }
    
    public void visitArrayAddAll(ArrayAddAll s) {
        result = s.to + " += " + s.from + "[]";
    }

    public void visitArrayFromArray(ArrayFromArray s) {
        result = s.to + " = " + s.from + "[];";
    }

    public void visitArrayNew(ArrayNew s) {
        result = s.to + " = new [];";
    }

    public void visitArrayWriteArray(ArrayWriteArray s) {
        result = s.to + "[] = " + s.from;
    }

    public void visitArrayWriteElement(ArrayWriteElement s) {
        result = s.to + "[] = " + s.from;
    }

    public void visitCall(Call s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.retvar);
        sb.append(" = ");
        sb.append(s.target.getName());
        sb.append("(");
        for (int i = 0; i < s.args.length; i++) {
            sb.append(s.args[i]);
            if (i < s.args.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(");");
        result = sb.toString();
    }

    public void visitMethodHead(MethodHead s) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < s.params.length; i++) {
            sb.append(s.params[i]);
            if (i < s.params.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        result = sb.toString();
    }

    public void visitNop(Nop s) {
        result = "nop;";
    }

    public void visitReturn(Return s) {
        result = "return " + s.retvar + ";";
    }

    public void visitStringAssignment(StringAssignment s) {
        result = s.to + " = " + s.from + ";";
    }

    public void visitStringBufferAppend(StringBufferAppend s) {
        result = s.to + ".append(" + s.from + ");";
    }

    public void visitStringBufferAssignment(StringBufferAssignment s) {
        result = s.to + " = " + s.from + ";";
    }

    public void visitStringBufferBinaryOp(StringBufferBinaryOp s) {
        result = s.to + "." + s.op + "(" + s.from + ");";
    }

    public void visitStringBufferCorrupt(StringBufferCorrupt s) {
        result = "corrupt " + s.to + ";";
    }

    public void visitStringBufferInit(StringBufferInit s) {
        result = s.to + " = new(" + s.from + ");";
    }

    public void visitStringBufferPrepend(StringBufferPrepend s) {
        result = s.to + ".prepend(" + s.from + ");";
    }

    public void visitStringBufferUnaryOp(StringBufferUnaryOp s) {
        result = s.to + "." + s.op + "();";
    }

    public void visitStringConcat(StringConcat s) {
        result = s.to + " = " + s.left + " + " + s.right + ";";
    }

    public void visitStringFromArray(StringFromArray s) {
        result = s.to + " = " + s.from + "[];";
    }
    public void visitPrimitiveFromArray(PrimitiveFromArray s) {
        result = s.to + " = " + s.from + "[];";
    }

    public void visitStringFromStringBuffer(StringFromStringBuffer s) {
        result = s.to + " = " + s.from + ".s.toString();";
    }

    public void visitStringInit(StringInit s) {
        result = s.to + " = " + Basic.getName(s.regexp) + ";";
    }

	public void visitObjectAssignment(ObjectAssignment s) {
		result = s.to + " ~= " + s.from;
	}

	public void visitObjectCorrupt(ObjectCorrupt s) {
		result = "corrupt obj " + s.to;
	}
	
	public void visitHotspot(Hotspot s) {
		result = "hotspot(" + s.to + ") = " + s.from;
	}
	
	public void visitFieldAssignment(FieldAssignment s) {
		result = s.getField() + " = " + s.getFrom();
	}
	
	public void visitFieldReference(FieldReference s) {
		result = s.getTo() + " = " + s.getField();
	}
	
	public void visitCatch(Catch s) {
		result = "catch";
	}
	public void visitExceptionalReturn(ExceptionalReturn s) {
		result = "except return";
	}
}
