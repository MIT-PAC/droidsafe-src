package droidsafe.eclipse.plugin.core.filters;

public enum BoolOp {
    AND(0),
    OR(1);
        
    private int value;

    private BoolOp(int value) {
            this.value = value;
    }
    
    public int getValue() {
        return value;
    }

    public String toString() {
        switch (this) {
            case AND: return "and";
            default: return "or";
        }
    }

}
