package dk.brics.string.intermediate;

import dk.brics.string.stringoperations.BinaryOperation;

/**
 * Performs a binary operation <tt>op(a,b)</tt> and puts the result into <tt>a</tt>.
 * 
 * @author Asger
 */
public class AssertBinaryOp extends AssertStatement {
    
    public Variable to;
    public Variable from;
    public BinaryOperation op;
    
    public AssertBinaryOp(Statement targetStatement, Variable to, Variable from, BinaryOperation op) {
        super(targetStatement);
        this.to = to;
        this.from = from;
        this.op = op;
        
        assert to.isLocal();
        assert from.isLocal();
    }
    
    @Override
    public void visitBy(StatementVisitor v) {
        v.visitAssertBinaryOp(this);
    }
    
}
