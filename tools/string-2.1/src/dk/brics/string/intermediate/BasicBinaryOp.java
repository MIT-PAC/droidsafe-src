package dk.brics.string.intermediate;

import dk.brics.string.stringoperations.BinaryOperation;

/**
 * Applies a binary operation to the <tt>first</tt> and <tt>second</tt> variables (without modifying them)
 * and puts the result into the <tt>to</tt> variable.
 * <p/>
 * There are no restrictions on the types of the input and output variables.
 * 
 * @author Asger
 */
public class BasicBinaryOp extends Statement {
    
    public Variable to;
    public Variable first;
    public Variable second;
    public BinaryOperation op;
    
    public BasicBinaryOp(Variable to, Variable first, Variable second,
            BinaryOperation op) {
        this.to = to;
        this.first = first;
        this.second = second;
        this.op = op;
    }

    @Override
    public void visitBy(StatementVisitor v) {
        v.visitBasicBinaryOp(this);
    }
}
