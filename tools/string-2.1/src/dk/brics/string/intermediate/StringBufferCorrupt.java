package dk.brics.string.intermediate;

/**
 * Corruption of a string buffer variable.
 * <p/>
 * From this point, the string buffer object pointed to by the
 * {@link dk.brics.string.intermediate.StringBufferStatement#to to}
 * variable can contain any value, and it can spontaneously
 * change its value to anything at any time.
 */
public class StringBufferCorrupt extends StringBufferStatement {

    public StringBufferCorrupt(Variable to) {
        super(to);
    }

    @Override
    public void visitBy(StatementVisitor v) {
        v.visitStringBufferCorrupt(this);
    }
}

