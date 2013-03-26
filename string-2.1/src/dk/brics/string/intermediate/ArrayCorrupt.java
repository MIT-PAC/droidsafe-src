package dk.brics.string.intermediate;

/**
 * Corruption of an array variable.
 * <p/>
 * From this point, the array pointed to by the
 * {@link dk.brics.string.intermediate.ArrayStatement#to to}
 * variable can contain any value, and it can spontaneously
 * change its value to anything at any time.
 */
public class ArrayCorrupt extends ArrayStatement {

    public ArrayCorrupt(Variable to) {
        super(to);
    }

    @Override
    public void visitBy(StatementVisitor v) {
        v.visitArrayCorrupt(this);
    }
}

