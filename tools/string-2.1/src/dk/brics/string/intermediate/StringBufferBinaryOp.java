package dk.brics.string.intermediate;

import dk.brics.string.stringoperations.BinaryOperation;

/**
 * Performing a binary operation between a string buffer and a string.
 * The result is put into the string buffer.
 */
public class StringBufferBinaryOp extends StringBufferOperation {

    /**
     * The operation to perform.
     */
    public BinaryOperation op;

    /**
     * The string argument to the operation.
     */
    public Variable from;

    public StringBufferBinaryOp(Variable to, BinaryOperation op, Variable from) {
        super(to);
        this.op = op;
        this.from = from;
        
        assert from.getType().mightBeAliasOf(VariableType.STRING);  
        assert from.isLocal();
    }

    @Override
    public void visitBy(StatementVisitor v) {
        v.visitStringBufferBinaryOp(this);
    }
}

