package dk.brics.string.intermediate;

/**
 * Superclass of all statements that manipulate a string buffer object.
 */
public abstract class StringBufferOperation extends StringBufferStatement {

    public StringBufferOperation(Variable to) {
        super(to);
    }
}

