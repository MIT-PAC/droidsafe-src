package droidsafe.eclipse.plugin.core.filters;

import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;

public enum CompareOp {
    EQ(0),
    NEQ(1),
    LE(2),
    LT(3),
    GE(4),
    GT(5),
    CONTAINS(6),
    STARTS_WITH(7),
    ENDS_WITH(8);

    public static final String[] strings = DroidsafePluginUtilities.enumStrings(CompareOp.class);

    private int value;

    private CompareOp(int value) {
            this.value = value;
    }
    
    public int getValue() {
        return value;
    }

    public String toString() {
        switch (this) {
            case EQ: return "=";
            case NEQ: return "!=";
            case LE: return "<=";
            case LT: return "<";
            case GE: return ">=";
            case GT: return ">";
            case CONTAINS: return "contains";
            case STARTS_WITH: return "startsWith";
            default: return "endsWith";
        }
    }
    
    public boolean apply(boolean value1, boolean value2) {
        switch (this) {
            case EQ: return value1 == value2;
            case NEQ: return value1 != value2;
            default: return false;
        }
    }

    public boolean apply(int value1, int value2) {
        switch (this) {
            case EQ: return value1 == value2;
            case NEQ: return value1 != value2;
            case LE: return value1 <= value2;
            case LT: return value1 < value2;
            case GE: return value1 >= value2;
            case GT: return value1 > value2;
            default: return false;
        }
    }

    public boolean apply(String value1, String value2) {
        switch (this) {
            case EQ: return value1.equals(value2);
            case NEQ: return !value1.equals(value2);
            case CONTAINS: return value1.contains(value2);
            case STARTS_WITH: return value1.startsWith(value2);
            case ENDS_WITH: return value1.endsWith(value2);
            default: return false;
        }
    }
}
