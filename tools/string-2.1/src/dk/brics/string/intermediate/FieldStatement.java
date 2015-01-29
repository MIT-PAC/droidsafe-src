package dk.brics.string.intermediate;

/**
 * Interface implemented by statements that operate with fields,
 * which is currently {@link FieldReference} and {@link FieldAssignment}.
 */
public interface FieldStatement {
    /**
     * Returns the field being read and/or modified by this statement.
     * @return a field
     */
    Field getField();
}
