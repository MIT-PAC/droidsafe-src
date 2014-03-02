package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class Byte extends Number implements Comparable<Byte> {

    /**
     * Compares two {@code byte} values.
     * @return 0 if lhs = rhs, less than 0 if lhs &lt; rhs, and greater than 0 if lhs &gt; rhs.
     * @since 1.7
     * @hide 1.7
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.436 -0500", hash_original_method = "526CB67D9082E1052DF512ACF5AFED97", hash_generated_method = "AF1DFE575C4097C8712CFD7C9136BD0A")
    
public static int compare(byte lhs, byte rhs) {
        return lhs > rhs ? 1 : (lhs < rhs ? -1 : 0);
    }

    /**
     * Parses the specified string and returns a {@code Byte} instance if the
     * string can be decoded into a single byte value. The string may be an
     * optional minus sign "-" followed by a hexadecimal ("0x..." or "#..."),
     * octal ("0..."), or decimal ("...") representation of a byte.
     *
     * @param string
     *            a string representation of a single byte value.
     * @return a {@code Byte} containing the value represented by {@code string}.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as a byte value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.438 -0500", hash_original_method = "FFA7DA06804046B92F2D54F8D6E8206F", hash_generated_method = "2EB97CCF14C50762CE7A9B6EFF037343")
    
public static Byte decode(String string) throws NumberFormatException {
        int intValue = Integer.decode(string);
        byte result = (byte) intValue;
        if (result == intValue) {
            return valueOf(result);
        }
        throw new NumberFormatException("Value out of range for byte: \"" + string + "\"");
    }

    /**
     * Parses the specified string as a signed decimal byte value. The ASCII
     * character \u002d ('-') is recognized as the minus sign.
     *
     * @param string
     *            the string representation of a single byte value.
     * @return the primitive byte value represented by {@code string}.
     * @throws NumberFormatException
     *             if {@code string} can not be parsed as a byte value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.456 -0500", hash_original_method = "3E3DB9EACBAEC53C68BCBB24FE69AB14", hash_generated_method = "30051DC3AE22E7DDA2FF507800CF7FBE")
    
public static byte parseByte(String string) throws NumberFormatException {
        return parseByte(string, 10);
    }

    /**
     * Parses the specified string as a signed byte value using the specified
     * radix. The ASCII character \u002d ('-') is recognized as the minus sign.
     *
     * @param string
     *            the string representation of a single byte value.
     * @param radix
     *            the radix to use when parsing.
     * @return the primitive byte value represented by {@code string} using
     *         {@code radix}.
     * @throws NumberFormatException
     *             if {@code string} can not be parsed as a byte value, or
     *             {@code radix < Character.MIN_RADIX ||
     *             radix > Character.MAX_RADIX}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.459 -0500", hash_original_method = "BF3D50DD939D834A7DF75489B00C6690", hash_generated_method = "DCFACEE3BA254C7BC8C98F4F5AB6DDB7")
    
public static byte parseByte(String string, int radix) throws NumberFormatException {
        int intValue = Integer.parseInt(string, radix);
        byte result = (byte) intValue;
        if (result == intValue) {
            return result;
        }
        throw new NumberFormatException("Value out of range for byte: \"" + string + "\"");
    }

    /**
     * Returns a two-digit hex string. That is, -1 becomes "ff" or "FF" and 2 becomes "02".
     * @hide internal use only
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.467 -0500", hash_original_method = "178909B2C58CF7188A6A8BC8023FFA15", hash_generated_method = "BA098F90A3D5AA4F49CACD160D9F0877")
    
public static String toHexString(byte b, boolean upperCase) {
        return IntegralToString.byteToHexString(b, upperCase);
    }

    /**
     * Returns a string containing a concise, human-readable description of the
     * specified byte value.
     *
     * @param value
     *            the byte to convert to a string.
     * @return a printable representation of {@code value}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.470 -0500", hash_original_method = "A5C9B1F940A6E4E0B7C56A8CD89F3E5B", hash_generated_method = "CF35E1D7B63D21B25C3AC38B2AA64EC0")
    
public static String toString(byte value) {
        return Integer.toString(value);
    }

    /**
     * Parses the specified string as a signed decimal byte value.
     *
     * @param string
     *            the string representation of a single byte value.
     * @return a {@code Byte} instance containing the byte value represented by
     *         {@code string}.
     * @throws NumberFormatException
     *             if {@code string} can not be parsed as a byte value.
     * @see #parseByte(String)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.472 -0500", hash_original_method = "C35C42F07E6BEE21A855B7E6408FB8DD", hash_generated_method = "E186142D5A2A10E55B23D27838DD1C2D")
    
public static Byte valueOf(String string) throws NumberFormatException {
        return valueOf(parseByte(string));
    }

    /**
     * Parses the specified string as a signed byte value using the specified
     * radix.
     *
     * @param string
     *            the string representation of a single byte value.
     * @param radix
     *            the radix to use when parsing.
     * @return a {@code Byte} instance containing the byte value represented by
     *         {@code string} using {@code radix}.
     * @throws NumberFormatException
     *             if {@code string} can not be parsed as a byte value, or
     *             {@code radix < Character.MIN_RADIX ||
     *             radix > Character.MAX_RADIX}.
     * @see #parseByte(String, int)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.475 -0500", hash_original_method = "46925E95C7BFFD2FC27FB6165D068F93", hash_generated_method = "89D01FA737447FDF0216F6FA90FA37F9")
    
public static Byte valueOf(String string, int radix) throws NumberFormatException {
        return valueOf(parseByte(string, radix));
    }

    /**
     * Returns a {@code Byte} instance for the specified byte value.
     * <p>
     * If it is not necessary to get a new {@code Byte} instance, it is
     * recommended to use this method instead of the constructor, since it
     * maintains a cache of instances which may result in better performance.
     *
     * @param b
     *            the byte value to store in the instance.
     * @return a {@code Byte} instance containing {@code b}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.478 -0500", hash_original_method = "ED2DBBC22F9957F86BC9FC2AC655A3C8", hash_generated_method = "BF35DA0FF2C2C3C53A13663AA1B29BBE")
    
public static Byte valueOf(byte b) {
        return new Byte(b);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.408 -0500", hash_original_field = "A5E8E87A2BAF29AAB1D89B635C5626F8", hash_generated_field = "0B9495765198BD47B32DBC3AF8355DF1")

    private static final long serialVersionUID = -7183698231559129828L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.413 -0500", hash_original_field = "D286ABE0B8AC1631D46190A8813DFB99", hash_generated_field = "0BA33D8AB14923CFCC8563593CF17893")

    public static final byte MAX_VALUE = (byte) 0x7F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.417 -0500", hash_original_field = "FED1B991305E4E5DEC00E688AB2901EE", hash_generated_field = "7250F7F8A72BCB9BD36FFE6F7115CD32")

    public static final byte MIN_VALUE = (byte) 0x80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.419 -0500", hash_original_field = "5EB7E85E806CA2FC72DC067C1DCD743D", hash_generated_field = "F24EEB984834E57CF9AD1E8B082B7AF3")

    public static final int SIZE = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.422 -0500", hash_original_field = "59DA986EB17B56DA9098C325F89BBB2C", hash_generated_field = "339B0BC27B447AC9E571FEBE3354B6B1")

    @SuppressWarnings("unchecked")
    public static final Class<Byte> TYPE
            = (Class<Byte>) byte[].class.getComponentType();

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.411 -0500", hash_original_field = "6072D19D08473B81BB367C06EAF7BB24", hash_generated_field = "8CCAF7A9B8382D1617ADC5CB954C674D")

    private  byte value;
    // Note: Byte.TYPE can't be set to "byte.class", since *that* is
    // defined to be "java.lang.Byte.TYPE";

    /**
     * Constructs a new {@code Byte} with the specified primitive byte value.
     *
     * @param value
     *            the primitive byte value to store in the new instance.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.425 -0500", hash_original_method = "7E64D11F2C96BA434CA992EF3846EE45", hash_generated_method = "9B3A88DBDDE6C9EDA37DA0945AF75BBA")
    
public Byte(byte value) {
        this.value = value;
    }

    /**
     * Constructs a new {@code Byte} from the specified string.
     *
     * @param string
     *            the string representation of a single byte value.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as a byte value.
     * @see #parseByte(String)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.428 -0500", hash_original_method = "6A41489347990CAADB010180F3DA4F08", hash_generated_method = "66A20A3FACCD57C473E8A1F62EA3004B")
    
public Byte(String string) throws NumberFormatException {
        this(parseByte(string));
    }

    /**
     * Gets the primitive value of this byte.
     *
     * @return this object's primitive value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.431 -0500", hash_original_method = "A44A96B9BD8D4010644191EEAB137884", hash_generated_method = "3A43018D3145FE8B120819AE494DA742")
    
@Override
    public byte byteValue() {
        return value;
    }

    /**
     * Compares this object to the specified byte object to determine their
     * relative order.
     *
     * @param object
     *            the byte object to compare this object to.
     * @return a negative value if the value of this byte is less than the value
     *         of {@code object}; 0 if the value of this byte and the value of
     *         {@code object} are equal; a positive value if the value of this
     *         byte is greater than the value of {@code object}.
     * @see java.lang.Comparable
     * @since 1.2
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.433 -0500", hash_original_method = "BB597B75ED281325D8B4388243F4CDF9", hash_generated_method = "65023D74BB9B48940908617630FCB864")
    
public int compareTo(Byte object) {
        return compare(value, object.value);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.441 -0500", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "BF89BE4469CF5E691A2C43432BBB5D3E")
    
@Override
    public double doubleValue() {
        return value;
    }

    /**
     * Compares this object with the specified object and indicates if they are
     * equal. In order to be equal, {@code object} must be an instance of
     * {@code Byte} and have the same byte value as this object.
     *
     * @param object
     *            the object to compare this byte with.
     * @return {@code true} if the specified object is equal to this
     *         {@code Byte}; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.443 -0500", hash_original_method = "C5FA8B05FD4F870ED8BC1DBD5FAAA797", hash_generated_method = "BB9A7FF0B2609D96A2662AA6493D655D")
    
@Override
    @FindBugsSuppressWarnings("RC_REF_COMPARISON")
    public boolean equals(Object object) {
        return (object == this) || ((object instanceof Byte) && (((Byte) object).value == value));
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.446 -0500", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "0138C4AD160C9AAF1F0B41D5F85236C8")
    
@Override
    public float floatValue() {
        return value;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.448 -0500", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "C30218EC7C084095E716A93197D10945")
    
@Override
    public int hashCode() {
        return value;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.451 -0500", hash_original_method = "4668226786F0223B69B1E8157F3C469B", hash_generated_method = "CED71A70CDF5F216D39A3AE3E558B24B")
    
@Override
    public int intValue() {
        return value;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.454 -0500", hash_original_method = "ABF4FE035C950AC910A646D4B85E3F35", hash_generated_method = "1422248BBCC1B2BAF9351E8A3DC0A5BE")
    
@Override
    public long longValue() {
        return value;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.462 -0500", hash_original_method = "C4526A740A626A32E8FE5B0C1E7B83A6", hash_generated_method = "A82042D96E725949B732B712BE4A645E")
    
@Override
    public short shortValue() {
        return value;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.465 -0500", hash_original_method = "6B315C20A4D45816791A47779D79F014", hash_generated_method = "523848B88799F041621FC5C99AD5BFED")
    
@Override
    public String toString() {
        return Integer.toString(value);
    }
    
}

