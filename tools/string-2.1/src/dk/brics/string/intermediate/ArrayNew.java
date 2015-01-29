package dk.brics.string.intermediate;

/**
 * Creation of a new array.
 * The new array is assigned to the
 * {@link dk.brics.string.intermediate.ArrayStatement#to to} variable.
 */
public class ArrayNew extends ArrayStatement {

    public ArrayNew(Variable to) {
        super(to);
    }

    @Override
    public void visitBy(StatementVisitor v) {
        v.visitArrayNew(this);
    }
}
