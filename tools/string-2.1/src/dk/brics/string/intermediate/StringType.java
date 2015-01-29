package dk.brics.string.intermediate;

/**
 * Denotes the type of a string-related object.
 *  
 * @author Asger
 *
 */
public enum StringType {
    /**
     * A single immutable string.
     * <p/>
     * In Java, this corresponds to the <tt>java.lang.String</tt> class.
     */
    IMMUTABLE(0x1),
    
    /**
     * A single mutable string.
     * <p/>
     * In Java, this corresponds to the <tt>java.lang.StringBuffer</tt> and <tt>java.lang.StringBuilder</tt>
     * classes.
     */
    MUTABLE(0x2),
    
    /**
     * A mutable collection of immutable strings.
     * <p/>
     * In Java, this corresponds to string-arrays and classes from the collections framework, such as <tt>ArrayList&lt;String&gt;</tt>.
     */
    COLLECTION(0x4),
    
    /**
     * An object not being modelled as a string.
     * <p/>
     * In Java, this is anything not treated as either of the other types.
     */
    USELESS(0x8),
    ;
    
    private int bitmask;
    
    private StringType(int index) {
        this.bitmask = index;
    }
    
    /**
     * Returns a bitmask unique for this string-type, with exactly one 1-bit.
     * @return a bitmask with a single 1-bit
     */
    public int getBitmask() {
        return bitmask;
    }
    
    /**
     * Returns <tt>true</tt> if this is {@link #MUTABLE} or {@link #COLLECTION}.
     */
    public boolean isModifiable() {
        return this == MUTABLE || this == COLLECTION;
    }
}
