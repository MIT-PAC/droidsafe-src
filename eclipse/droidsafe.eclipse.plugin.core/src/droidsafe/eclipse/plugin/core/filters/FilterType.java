package droidsafe.eclipse.plugin.core.filters;

import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;

/**
 * An enum type representing the three different types of filter: 'exclude' filter,
 * 'include' filter, and 'show' filter.
 * 
 * @author gilham
 *
 */
public enum FilterType {
    EXCLUDE(0), INCLUDE(1), SHOW(2);

    /**
     * The string representations of the FilterType constants.
     */
    public static final String[] strings = DroidsafePluginUtilities.enumStrings(FilterType.class);
    
    /**
     * The labels (more detailed descriptions) for the FilterType constants.
     */
    public static final String[] labels = getLabels();

    /**
     * The int value for this filter type.
     */
    int value;

    /**
     * Constructs a FilterType with the given int value
     * 
     * @param value - the int value
     */
    private FilterType(int value) {
            this.value = value;
    }
    
    /**
     * Returns the int value of this filter type.
     * 
     * @return the int value
     */
    public int getValue() {
        return value;
    }

    /**
     * The string representation of this FilterType.
     */
    @Override
    public String toString() {
        switch (this) {
            case EXCLUDE: return "exclude";
            case INCLUDE: return "include";
            default: return "show";
        }
    }
    
    /**
     * Returns the label (more detailed description) of this filter type.
     * 
     * @return the label
     */
    public String toLabel() {
        switch (this) {
            case EXCLUDE: return "exclude";
            case INCLUDE: return "include (if true for node and all parents)";
            default: return "include (if true for any children)";
        }
    }
    
    /**
     * Returns the labels (more detailed descriptions) for the FilterType constants.
     * 
     * @return the labels
     */
    public static String[] getLabels() {
        FilterType[] values = values();
        String[] labels = new String[values.length];
        for (int i = 0; i < values.length; i++)
            labels[i] = values[i].toLabel();
        return labels;
    }
    
    /**
     * Parses the string representation of a FilterType and returns the FilterType.
     * 
     * @param str - the string
     * @return the FilterType corresponds to the string
     * @throws FilterParseException
     */
    public static FilterType parse(String str) throws FilterParseException {
        for (int i = 0; i < strings.length; i++) {
            if (str.equals(strings[i]))
                return values()[i];
        }
        throw new FilterParseException("Unrecognized filter type: " + str);
    }
}


