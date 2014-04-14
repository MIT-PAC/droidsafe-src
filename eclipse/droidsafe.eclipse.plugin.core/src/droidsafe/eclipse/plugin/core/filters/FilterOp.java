package droidsafe.eclipse.plugin.core.filters;

import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;

public enum FilterOp {
    EXCLUDE(0), INCLUDE(1), SHOW(2);

    public static final String[] strings = DroidsafePluginUtilities.enumStrings(FilterOp.class);;

    private int value;

    private FilterOp(int value) {
            this.value = value;
    }
    
    public int getValue() {
        return value;
    }

    public String toString() {
        switch (this) {
            case EXCLUDE: return "exclude";
            case INCLUDE: return "include";
            default: return "show";
        }
    }
    
    public static FilterOp parse(String str) throws FilterException {
        for (int i = 0; i < strings.length; i++) {
            if (str.equals(strings[i]))
                return values()[i];
        }
        throw new FilterException("Unrecognized filter type: " + str);
    }
}


