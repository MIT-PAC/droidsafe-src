package dk.brics.string.intermediate;

import dk.brics.string.stringoperations.UnaryOperation;

/**
 * Applies a unary operation to the <tt>from</tt> variable (without modifying it)
 * and puts the result into the <tt>to</tt> variable.
 * <p/>
 * There are no restrictions on the types of the input and output variables.
 * 
 * @author Asger
 */
public class BasicUnaryOp extends Statement {
    
    public Variable to;
    public Variable from;
    public UnaryOperation op;
    
    public BasicUnaryOp(Variable to, Variable from, UnaryOperation op) {
        this.to = to;
        this.from = from;
        this.op = op;
    }

    @Override
    public void visitBy(StatementVisitor v) {
        v.visitBasicUnaryOp(this);
    }
}
