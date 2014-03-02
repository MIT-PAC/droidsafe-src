package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;

public final class Boolean implements Serializable, Comparable<Boolean> {

    /**
     * Compares two {@code boolean} values.
     * @return 0 if lhs = rhs, less than 0 if lhs &lt; rhs, and greater than 0 if lhs &gt; rhs.
     *         (Where true &gt; false.)
     * @since 1.7
     * @hide 1.7
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.843 -0500", hash_original_method = "B3A70AF2DF8E93CED801D9C24A07FA78", hash_generated_method = "52DBC9C2C80935547BDAD01A5C55773E")
    
public static int compare(boolean lhs, boolean rhs) {
        return lhs == rhs ? 0 : lhs ? 1 : -1;
    }

    /**
     * Returns the {@code boolean} value of the system property identified by
     * {@code string}.
     *
     * @param string
     *            the name of the requested system property.
     * @return {@code true} if the system property named by {@code string}
     *         exists and it is equal to "true" using case insensitive
     *         comparison, {@code false} otherwise.
     * @see System#getProperty(String)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.850 -0500", hash_original_method = "E88CDE1BFD10E217DE82EEF79E0E2CED", hash_generated_method = "ADCC75F930DEC79F7EEB42F15EEABB2B")
    
public static boolean getBoolean(String string) {
        if (string == null || string.length() == 0) {
            return false;
        }
        return (parseBoolean(System.getProperty(string)));
    }

    /**
     * Parses the specified string as a {@code boolean}.
     *
     * @param s
     *            the string representation of a boolean value.
     * @return {@code true} if {@code s} is not {@code null} and is equal to
     *         {@code "true"} using case insensitive comparison, {@code false}
     *         otherwise.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.853 -0500", hash_original_method = "BD83C9A3C7856D0FAE5D6BC0CCD859FA", hash_generated_method = "35EF410EA41D39A8C101C5B251B58242")
    
public static boolean parseBoolean(String s) {
        return new Boolean("true".equals(s));
    }

    /**
     * Converts the specified boolean to its string representation.
     *
     * @param value
     *            the boolean to convert.
     * @return "true" if {@code value} is {@code true}, "false" otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.855 -0500", hash_original_method = "D9199A85D0846E817E80F47C2D9F0FC6", hash_generated_method = "922BC111CD5564A1BFC8994725FA9DD1")
    
public static String toString(boolean value) {
        return String.valueOf(value);
    }

    /**
     * Parses the specified string as a boolean value.
     *
     * @param string
     *            the string representation of a boolean value.
     * @return {@code Boolean.TRUE} if {@code string} is equal to "true" using
     *         case insensitive comparison, {@code Boolean.FALSE} otherwise.
     * @see #parseBoolean(String)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.857 -0500", hash_original_method = "D7304055711653AFAB319201D507D88D", hash_generated_method = "5D2F5BB17E0BBABB512766F7522CD9F0")
    
public static Boolean valueOf(String string) {
        return new Boolean("true".equals(string));
    }

    /**
     * Returns a {@code Boolean} instance for the specified boolean value.
     * <p>
     * If it is not necessary to get a new {@code Boolean} instance, it is
     * recommended to use this method instead of the constructor, since it
     * returns its static instances, which results in better performance.
     *
     * @param b
     *            the boolean to convert to a {@code Boolean}.
     * @return {@code Boolean.TRUE} if {@code b} is equal to {@code true},
     *         {@code Boolean.FALSE} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.860 -0500", hash_original_method = "1F020F11EF22A99E6E7AE33CA4E6AFB6", hash_generated_method = "E53A913A6561FDE56D487E4A382C5544")
    
public static Boolean valueOf(boolean b) {
        return new Boolean(b);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.816 -0500", hash_original_field = "E0E21F09D385039080D9D1CB5BA45688", hash_generated_field = "CFFD6448D529B230EC4B399C365C3ED6")

    private static final long serialVersionUID = -3665804199014368530L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.821 -0500", hash_original_field = "137FF7BD4CE7985F11E3F85CDA816C03", hash_generated_field = "E6915B30788347C5E17C14AFE97099AA")

    @SuppressWarnings("unchecked")
    public static final Class<Boolean> TYPE
             = (Class<Boolean>) boolean[].class.getComponentType();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.824 -0500", hash_original_field = "FE3135AB46013BC593AB713B6667F067", hash_generated_field = "A404072AB8C61983C822CB3050E3ADC9")

    // defined to be "java.lang.Boolean.TYPE";

    /**
     * The {@code Boolean} object that represents the primitive value
     * {@code true}.
     */
    public static final Boolean TRUE = new Boolean(true);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.826 -0500", hash_original_field = "7AC7B2D12A617605A54F213704AADF01", hash_generated_field = "76A59335A5CE94CD1B1D73C9A4052176")

    public static final Boolean FALSE = new Boolean(false);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.819 -0500", hash_original_field = "EF98710EB6D48DB36CD3E17E0CB16F67", hash_generated_field = "B3AA526F1538BC4E4F647F454F4A2696")

    private  boolean value;

    /**
     * Constructs a new {@code Boolean} with its boolean value specified by
     * {@code string}. If {@code string} is not {@code null} and is equal to
     * "true" using a non-case sensitive comparison, the result will be a
     * Boolean representing the primitive value {@code true}, otherwise it will
     * be a Boolean representing the primitive value {@code false}.
     *
     * @param string
     *            the string representing a boolean value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.829 -0500", hash_original_method = "16D96B4E7F901C7B1D5828A237ACCAC7", hash_generated_method = "BC59887BA943C2D4D49A4AD30A7E111C")
    
public Boolean(String string) {
        this(parseBoolean(string));
    }

    /**
     * Constructs a new {@code Boolean} with the specified primitive boolean
     * value.
     *
     * @param value
     *            the primitive boolean value, {@code true} or {@code false}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.832 -0500", hash_original_method = "AAA63288DF04453D39E07EAA91131D42", hash_generated_method = "669A5BDD5BB8E366DE809427DDF7AE4F")
    
public Boolean(boolean value) {
        this.value = value;
    }

    /**
     * Gets the primitive value of this boolean, either {@code true} or
     * {@code false}.
     *
     * @return this object's primitive value, {@code true} or {@code false}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.835 -0500", hash_original_method = "F26012F420AB2CB381204FD30DBE0B24", hash_generated_method = "89E01E07EC4424A2F876DAADA0AD3F09")
    
public boolean booleanValue() {
        return value;
    }

    /**
     * Compares this instance with the specified object and indicates if they
     * are equal. In order to be equal, {@code o} must be an instance of
     * {@code Boolean} and have the same boolean value as this object.
     *
     * @param o
     *            the object to compare this boolean with.
     * @return {@code true} if the specified object is equal to this
     *         {@code Boolean}; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.838 -0500", hash_original_method = "28AC409B4210D4AB015BA8660C651D82", hash_generated_method = "89EA9C4EA99CF6FB717538A2DF9F7563")
    
@Override
    @FindBugsSuppressWarnings("RC_REF_COMPARISON_BAD_PRACTICE_BOOLEAN")
    public boolean equals(Object o) {
        return (o == this) || ((o instanceof Boolean) && (((Boolean) o).value == value));
    }

    /**
     * Compares this object to the specified boolean object to determine their
     * relative order.
     *
     * @param that
     *            the boolean object to compare this object to.
     * @return 0 if the value of this boolean and the value of {@code that} are
     *         equal; a positive value if the value of this boolean is
     *         {@code true} and the value of {@code that} is {@code false}; a
     *         negative value if the value if this boolean is {@code false} and
     *         the value of {@code that} is {@code true}.
     * @see java.lang.Comparable
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.840 -0500", hash_original_method = "5D5C1978E7EFC6390B8F7A214888BA1C", hash_generated_method = "9A67C0D07D345C241847770D5D85B358")
    
public int compareTo(Boolean that) {
        return compare(value, that.value);
    }

    /**
     * Returns an integer hash code for this boolean.
     *
     * @return this boolean's hash code, which is {@code 1231} for {@code true}
     *         values and {@code 1237} for {@code false} values.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.845 -0500", hash_original_method = "EE015B9251F7CEAD272805E74A0AD6CD", hash_generated_method = "D9559B8E91E481A1A462492D1F3B9A90")
    
@Override
    public int hashCode() {
        return value ? 1231 : 1237;
    }

    /**
     * Returns a string containing a concise, human-readable description of this
     * boolean.
     *
     * @return "true" if the value of this boolean is {@code true}, "false"
     *         otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.848 -0500", hash_original_method = "27F3E47E60B1213ECE72A0C1452319D1", hash_generated_method = "B864B858E73245729E2A2FF424814054")
    
@Override
    public String toString() {
        return String.valueOf(value);
    }
}

