package dk.brics.string.intermediate;

/**
 * Describes the possible types of a variable. The types are named after their repsective Java-types, but
 * are defined independently of Java. The three string-types we operate with are:
 * <ul>
 * <li>Immutable strings, like the Java <tt>String</tt>-class,
 * <li>Mutable strings, like <tt>StringBuffer</tt> and <tt>StringBuilder</tt>; and
 * <li>Collections of strings, like the Java array <tt>String[]</tt>, or <tt>Collection&lt;String&gt;</tt>. 
 * </ul>
 * <p/>
 * The types are arranged into the following simple lattice:
 * <pre>
 *           OBJECT
 *          /   |  \        \
 *         /    |   \        \
 *        /     |    \        \
 *       /      |     \        \
 *      /       |      \        \
 *     /        |       \        \
 * STRING  STRINGBUFFER  ARRAY   PRIMITIVE
 *      \       |       /       /
 *       \      |      /       /
 *        \     |     /       /
 *         \    |    /       /
 *          \   |   /       /
 *            NONE
 *              |
 *            NULL 
 * </pre>
 * <p/>
 * The methods in the {@link dk.brics.string.java.Types Types} class are the preferred ways
 * to create a type from a Java type, since it is non-trivial to do so in a sound way. For example, a variable
 * of type {@link Cloneable} might be an array, and the non-public type <tt>AbstractStringBuilder</tt> is in
 * fact the superclass of {@link StringBuffer} and {@link StringBuilder}, and not {@link Object} like documented.
 * <p/>
 * Note that mutable strings ({@link #STRINGBUFFER}) cannot be members of a string collection ({@link #ARRAY}).
 * This means that Java array types like <tt>StringBuffer[]</tt> cannot be modelled precisely.
 */
public enum VariableType {
    /**
     * Any type we care about.
     */
    OBJECT(0),
    
    /**
     * An <i>immutable</i> string object.
     * <p/>
     * In Java, the variable might have type {@link String}, but definitely not <tt>StringBuffer</tt>,
     * <tt>StringBuilder</tt> or array.
     */
    STRING(1),

    /**
     * A <i>mutable</i> string object.
     * <p/>
     * In Java, the variable might have type {@link StringBuffer} or {@link StringBuilder},
     * but definitely not <tt>String</tt> or array.
     */
    STRINGBUFFER(2),

    /**
     * A <i>mutable</i> collection of <i>immutable</i> strings.
     * <p/>
     * The variable might have type array (of arbitrary dimension) of {@link String},
     * but is definitely not <tt>String</tt>, <tt>StringBuffer</tt>, or <tt>StringBuilder</tt>. 
     */
    ARRAY(3),
    
    /**
     * An irrelevant type, or the value <tt>null</tt>.
     */
    NONE(4),
    
    /**
     * The value <tt>null</tt> (and <i>not</i> the string-value <tt>"null"</tt>).
     */
    NULL(5),
    
    PRIMITIVE(6);

    private int index;
    
    private VariableType(int index) {
    	this.index = index;
    }

    /**
     * Returns whether a variable of this type might be an alias of a variable of the other type.
     * For example, a variable of type <tt>Cloneable</tt> might be an alias of <tt>String[]</tt>,
     * but definitely not an alias of <tt>String</tt>.
     * <p/>
     * Variables of type <tt>NONE</tt> are never considered useful aliases of anything, not even each other.
     * <p/>
     * Variables are not considered aliases if either has the type <tt>NULL</tt>.
     * @param other the other variable type
     * @return <tt>true</tt> if they might be aliases, <tt>false</tt> otherwise.
     */
    public boolean mightBeAliasOf(VariableType other) {
    	VariableType intersection = greatestLowerBound(other);
    	return intersection != NONE && intersection != NULL;
    }
    
    /**
     * Returns whether a variable of this type can never be an alias of a variable of the other type.
     * For example, a variable of type <tt>Cloneable</tt> might be an alias of <tt>String[]</tt>,
     * but definitely not an alias of <tt>String</tt>.
     * <p/>
     * Variables of type <tt>NONE</tt> are never considered useful aliases of anything, not even each other.
     * <p/>
     * Variables are not considered aliases if either has the type <tt>NULL</tt>.
     * @param other the other variable type
     * @return <tt>false</tt> if they might be aliases, <tt>true</tt> otherwise.
     */
    public boolean cannotBeAliasOf(VariableType other) {
    	return !mightBeAliasOf(other);
    }
    
    /**
     * Returns whether a variable of this type might be a <i>useful</i> alias of a variable of the other type.
     * For example, a variable of type <tt>Cloneable</tt> might be an alias of <tt>String[]</tt>,
     * but definitely not an alias of <tt>String</tt>.
     * <p/>
     * To variables are <i>useful aliases</i> if they refer to the same string buffer, or to the same string array
     * (ie. aliases and useful and mutable).
     * <p/>
     * Variables of type <tt>NONE</tt> are never considered useful aliases of anything, not even each other.
     * <p/>
     * Variables are not considered aliases if either has the type <tt>NULL</tt>.
     * @param other the other variable type
     * @return <tt>true</tt> if they might be aliases, <tt>false</tt> otherwise.
     */
    public boolean mightBeUsefulAliasOf(VariableType other) {
    	VariableType intersection = greatestLowerBound(other);
    	return intersection != NONE && intersection != NULL && intersection != STRING;
    }
    
    /**
     * Returns whether a variable of this type can never be a <i>useful</i> alias of a variable of the other type.
     * For example, a variable of type <tt>Cloneable</tt> might be an alias of <tt>String[]</tt>,
     * but definitely not an alias of <tt>String</tt>.
     * <p/>
     * To variables are <i>useful aliases</i> if they refer to the same string buffer, or to the same string array
     * (ie. aliases and useful and mutable).
     * <p/>
     * Variables of type <tt>NONE</tt> are never considered aliases of anything, not even each other.
     * <p/>
     * Variables are not considered aliases if either has the type <tt>NULL</tt>.
     * <p/>
     * This is method always returns the opposite of {@link #mightBeUsefulAliasOf(VariableType)}, and is
     * only here for convenience.
     * @param other the other variable type
     * @return <tt>false</tt> if they might be aliases, <tt>true</tt> otherwise.
     */
    public boolean cannotBeUsefulAliasOf(VariableType other) {
    	return !mightBeUsefulAliasOf(other);
    }
    
    /**
     * Returns the most specific variable type that might be alias of both this
     * type, and the specified type.
     * <p/>
     * Refer to the lattice in {@link VariableType}'s description to see how the greatest lower bound is defined.
     * @param other the other variable type
     * @return a variable type thay might be an alias with both variable types, or <tt>NONE</tt> if no such type exists.
     */
    public VariableType greatestLowerBound(VariableType other) {
    	return GREATEST_LOWER_BOUND[index][other.index];
    }
    
    /**
     * Returns the most specific variable type that might be alias of either this
     * type, or the specified type, but not necessarily both. For example,
     * <tt>STRING.leastUpperBound(STRINGBUFFER) = CHARSEQUENCE</tt>.
     * <p/>
     * Refer to the lattice in {@link VariableType}'s description to see how the least upper bound is defined.
     * @param other the other variable type
     * @return a variable type thay might be an alias with either variable type.
     */
    public VariableType leastUpperBound(VariableType other) {
    	return LEAST_UPPER_BOUND[index][other.index];
    }
    
    /**
     * Returns <tt>true</tt> if this is {@link #STRINGBUFFER}, {@link #ARRAY},
     * or {@link #OBJECT}.
     */
    public boolean mightBeUsefulMutable() {
    	return this == ARRAY || this == STRINGBUFFER || this == OBJECT;
    }
    
    
    /**
     * See {@link #greatestLowerBound(VariableType)}.
     */
    private static final VariableType[][] GREATEST_LOWER_BOUND = {
    	{OBJECT,		STRING,		STRINGBUFFER,	ARRAY,	NONE,	NULL, PRIMITIVE},	// Object
    	{STRING,		STRING,		NONE,			NONE,	NONE,	NULL, NULL},		// String
    	{STRINGBUFFER,	NONE,		STRINGBUFFER,	NONE,	NONE,	NULL, NULL},		// StringBuffer
    	{ARRAY,			NONE,		NONE,			ARRAY,	NONE,	NULL, NULL},		// Array
    	{NONE,			NONE,		NONE,			NONE,	NONE,	NULL, NULL},		// None
    	{NULL,			NULL,		NULL,			NULL,	NULL,	NULL, NULL},		// Null
        {PRIMITIVE,     NULL,       NULL,           NULL,   NULL,   NULL, PRIMITIVE}    // Primitive
    };
    /**
     * See {@link #leastUpperBound(VariableType)}.
     */
    private static final VariableType[][] LEAST_UPPER_BOUND = {
    	{OBJECT,	OBJECT,			OBJECT,			OBJECT,	OBJECT,			OBJECT,    OBJECT},		// Object
    	{OBJECT,	STRING,			OBJECT,	        OBJECT,	STRING,			STRING,    OBJECT},		// String
    	{OBJECT,	OBJECT,	        STRINGBUFFER,	OBJECT,	STRINGBUFFER,	STRINGBUFFER, OBJECT},	// StringBuffer
    	{OBJECT,	OBJECT,			OBJECT,			ARRAY,	ARRAY,			ARRAY,     OBJECT},		// Array
    	{OBJECT,	STRING,			STRINGBUFFER,	ARRAY,	NONE,			NONE,      OBJECT},		// None
    	{OBJECT,	STRING,			STRINGBUFFER,	ARRAY,	NONE,			NULL,      PRIMITIVE},	// Null
        {OBJECT,    OBJECT,         OBJECT,         OBJECT, OBJECT,         PRIMITIVE, PRIMITIVE}   // Primitive
    };
    

    
}