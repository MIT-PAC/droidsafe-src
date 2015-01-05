package droidsafe.eclipse.plugin.core.filters;

/**
 * An enum type for the boolean operators used to construct a filter.
 * 
 * @author gilham
 *
 */
public enum BoolOp {
    AND(0),
    OR(1);
        
    /**
     * The int value for this boolean operator.
     */
    private int value;

    /**
     * Constructs a BoolOp with the given int value.
     * 
     * @param value - the int value
     */
    private BoolOp(int value) {
            this.value = value;
    }
    
    /**
     * Returns the int value of this boolean operator.
     * 
     * @return the int value
     */
    public int getValue() {
        return value;
    }

    /**
     * The string representation of this BooleanOp.
     */
    @Override
    public String toString() {
        switch (this) {
            case AND: return "and";
            default: return "or";
        }
    }

}
