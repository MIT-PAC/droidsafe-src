package dk.brics.string.intermediate;

import dk.brics.string.stringoperations.UnaryOperation;

/**
 * Performing a unary operation on a string buffer.
 * The result is put into the string buffer.
 */
public class StringBufferUnaryOp extends StringBufferOperation {

    /**
     * The operation to perform.
     */
    public UnaryOperation op;

    public StringBufferUnaryOp(Variable to, UnaryOperation op) {
        super(to);
        this.op = op;
    }
    
    @Override
    public void visitBy(StatementVisitor v) {
        v.visitStringBufferUnaryOp(this);
    }
}

