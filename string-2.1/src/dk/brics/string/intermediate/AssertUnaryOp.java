package dk.brics.string.intermediate;

import dk.brics.string.stringoperations.UnaryOperation;

/**
 * Performs two binary operation <tt>opA(a,b)</tt>,<tt>opB(b,a)</tt>.
 * The result of <tt>opA</tt> is then put in <tt>a</tt>, and the result of <tt>opB</tt> into <tt>b</tt>.
 * The output from either operation does not directly affect the input to the other.
 * 
 * @author Asger
 */
public class AssertUnaryOp extends AssertStatement {
    
    public Variable to;
    public UnaryOperation op;
    
    public AssertUnaryOp(Statement targetStatement, Variable to, UnaryOperation op) {
        super(targetStatement);
        this.to = to;
        this.op = op;
        
        assert to.isLocal();
    }
    
    @Override
    public void visitBy(StatementVisitor v) {
        v.visitAssertUnaryOp(this);
    }
    
}
