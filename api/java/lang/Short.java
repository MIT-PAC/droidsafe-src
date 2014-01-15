package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class Short extends Number implements Comparable<Short> {

    /**
     * Compares two {@code short} values.
     * @return 0 if lhs = rhs, less than 0 if lhs &lt; rhs, and greater than 0 if lhs &gt; rhs.
     * @since 1.7
     * @hide 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.119 -0500", hash_original_method = "EC012F50DB4364A9230CE07FC3FDA08E", hash_generated_method = "04F0AD5B79EFA19C0773385F336B3C1E")
    
public static int compare(long lhs, long rhs) {
        return lhs > rhs ? 1 : (lhs < rhs ? -1 : 0);
    }

    /**
     * Parses the specified string and returns a {@code Short} instance if the
     * string can be decoded into a short value. The string may be an optional
     * minus sign "-" followed by a hexadecimal ("0x..." or "#..."), octal
     * ("0..."), or decimal ("...") representation of a short.
     *
     * @param string
     *            a string representation of a short value.
     * @return a {@code Short} containing the value represented by
     *         {@code string}.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as a short value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.121 -0500", hash_original_method = "C8348377762FB6D849A417692AC54E63", hash_generated_method = "B8C5243258AE9062078ECD2BB875B16A")
    
public static Short decode(String string) throws NumberFormatException {
        int intValue = Integer.decode(string).intValue();
        short result = (short) intValue;
        if (result == intValue) {
            return valueOf(result);
        }
        throw new NumberFormatException("Value out of range for short: \"" + string + "\"");
    }

    /**
     * Parses the specified string as a signed decimal short value. The ASCII
     * character \u002d ('-') is recognized as the minus sign.
     *
     * @param string
     *            the string representation of a short value.
     * @return the primitive short value represented by {@code string}.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as a short value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.139 -0500", hash_original_method = "1786D2BB317EEE60820821018E6A39A2", hash_generated_method = "092E6E17D3E94A3774E469ED31E8F789")
    
public static short parseShort(String string) throws NumberFormatException {
        return parseShort(string, 10);
    }

    /**
     * Parses the specified string as a signed short value using the specified
     * radix. The ASCII character \u002d ('-') is recognized as the minus sign.
     *
     * @param string
     *            the string representation of a short value.
     * @param radix
     *            the radix to use when parsing.
     * @return the primitive short value represented by {@code string} using
     *         {@code radix}.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as a short value, or
     *             {@code radix < Character.MIN_RADIX ||
     *             radix > Character.MAX_RADIX}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.141 -0500", hash_original_method = "B0692BE3743D11D4DF4B4F46D87A99FC", hash_generated_method = "624DC3F714BEB21647873A3742666600")
    
public static short parseShort(String string, int radix) throws NumberFormatException {
        int intValue = Integer.parseInt(string, radix);
        short result = (short) intValue;
        if (result == intValue) {
            return result;
        }
        throw new NumberFormatException("Value out of range for short: \"" + string + "\"");
    }

    /**
     * Returns a string containing a concise, human-readable description of the
     * specified short value with radix 10.
     *
     * @param value
     *             the short to convert to a string.
     * @return a printable representation of {@code value}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.148 -0500", hash_original_method = "1EF8D36085FFBEBAD22C5568ED91BFE4", hash_generated_method = "DD1619FF77139A2F0480F37302994966")
    
public static String toString(short value) {
        return Integer.toString(value);
    }

    /**
     * Parses the specified string as a signed decimal short value.
     *
     * @param string
     *            the string representation of a short value.
     * @return a {@code Short} instance containing the short value represented
     *         by {@code string}.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as a short value.
     * @see #parseShort(String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.151 -0500", hash_original_method = "BC53579CE1693F911190DD8E21DD944D", hash_generated_method = "C77C28BAB6A5AD0C9182A3450A1404EA")
    
public static Short valueOf(String string) throws NumberFormatException {
        return valueOf(parseShort(string));
    }

    /**
     * Parses the specified string as a signed short value using the specified
     * radix.
     *
     * @param string
     *            the string representation of a short value.
     * @param radix
     *            the radix to use when parsing.
     * @return a {@code Short} instance containing the short value represented
     *         by {@code string} using {@code radix}.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as a short value, or
     *             {@code radix < Character.MIN_RADIX ||
     *             radix > Character.MAX_RADIX}.
     * @see #parseShort(String, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.153 -0500", hash_original_method = "46C74393C5C072B65EB7EF3C911B0780", hash_generated_method = "35EB6A5FDB629A957EC21221B837098B")
    
public static Short valueOf(String string, int radix) throws NumberFormatException {
        return valueOf(parseShort(string, radix));
    }

    /**
     * Reverses the bytes of the specified short.
     *
     * @param s
     *            the short value for which to reverse bytes.
     * @return the reversed value.
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.157 -0500", hash_original_method = "CAF92C1590742750040007716FD6D4B6", hash_generated_method = "B1071BF34EE08892A09AC1DB1A0B09B2")
    
public static short reverseBytes(short s) {
        return (short) ((s << 8) | ((s >>> 8) & 0xFF));
    }

    /**
     * Returns a {@code Short} instance for the specified short value.
     * <p>
     * If it is not necessary to get a new {@code Short} instance, it is
     * recommended to use this method instead of the constructor, since it
     * maintains a cache of instances which may result in better performance.
     *
     * @param s
     *            the short value to store in the instance.
     * @return a {@code Short} instance containing {@code s}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.159 -0500", hash_original_method = "35082CB91401B94EAC986E5B2FF0266B", hash_generated_method = "7296C5697BB66FEC2AC94F5102A69D0E")
    
public static Short valueOf(short s) {
        return s < -128 || s >= 128 ? new Short(s) : SMALL_VALUES[s + 128];
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.093 -0500", hash_original_field = "A8778D06FF83BAF5C55E40DEE84ED89F", hash_generated_field = "AC22C2D7B4371C5B3354C8DF803452A1")

    private static final long serialVersionUID = 7515723908773894738L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.098 -0500", hash_original_field = "972AAA33FA1E17367038C7B11B4CE501", hash_generated_field = "2E8990EE4BCAF51ABAF9910FEA47E327")

    public static final short MAX_VALUE = (short) 0x7FFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.101 -0500", hash_original_field = "469EA43C1CB55B7B645A9CEB9739633E", hash_generated_field = "8248891CDA13195DEFED2D9240C645FE")

    public static final short MIN_VALUE = (short) 0x8000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.104 -0500", hash_original_field = "483DD33A2F1D80B313CD1100ACB2057F", hash_generated_field = "35BBD8D16D40CCFD2558C6BE179C9BD7")

    public static final int SIZE = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.106 -0500", hash_original_field = "2696FE5DF5C7055C26CD7D5F9F8F0D8F", hash_generated_field = "E28BA0FAE7ADC3DBF11B80B560194555")

    @SuppressWarnings("unchecked")
    public static final Class<Short> TYPE
            = (Class<Short>) short[].class.getComponentType();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.162 -0500", hash_original_field = "97B531C87F4FB80CFD372E04927CE7B6", hash_generated_field = "5EDCE38E3A4104420004ABECDB3724B1")

    private static final Short[] SMALL_VALUES = new Short[256];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.095 -0500", hash_original_field = "BB4D74E719D7C3FD900295EFF5775244", hash_generated_field = "6B20F172DB6AEA88BC2254D4F28BB29D")

    private  short value;
    // Note: Short.TYPE can't be set to "short.class", since *that* is
    // defined to be "java.lang.Short.TYPE";

    /**
     * Constructs a new {@code Short} from the specified string.
     *
     * @param string
     *            the string representation of a short value.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as a short value.
     * @see #parseShort(String)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.109 -0500", hash_original_method = "929EA7C7B9F688B1FB918E42E094A176", hash_generated_method = "E48305ACBB0A4408E27E3B9E599A8961")
    
public Short(String string) throws NumberFormatException {
        this(parseShort(string));
    }

    /**
     * Constructs a new {@code Short} with the specified primitive short value.
     *
     * @param value
     *            the primitive short value to store in the new instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.112 -0500", hash_original_method = "943F3BD92535719838B11732349A25CE", hash_generated_method = "A0DAB957B86749FB655AF96F446D992A")
    
public Short(short value) {
        this.value = value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.114 -0500", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "4C2FE469A77605BE0BF5A0C525E46699")
    
@Override
    public byte byteValue() {
        return (byte) value;
    }

    /**
     * Compares this object to the specified short object to determine their
     * relative order.
     *
     * @param object
     *            the short object to compare this object to.
     * @return a negative value if the value of this short is less than the
     *         value of {@code object}; 0 if the value of this short and the
     *         value of {@code object} are equal; a positive value if the value
     *         of this short is greater than the value of {@code object}.
     * @throws NullPointerException
     *             if {@code object} is null.
     * @see java.lang.Comparable
     * @since 1.2
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.117 -0500", hash_original_method = "9451F44BD5942680EA0D419B40FE27E5", hash_generated_method = "9BC6DB09097B8FF862117A789E30ABF0")
    
public int compareTo(Short object) {
        return compare(value, object.value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.124 -0500", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "BF89BE4469CF5E691A2C43432BBB5D3E")
    
@Override
    public double doubleValue() {
        return value;
    }

    /**
     * Compares this instance with the specified object and indicates if they
     * are equal. In order to be equal, {@code object} must be an instance of
     * {@code Short} and have the same short value as this object.
     *
     * @param object
     *            the object to compare this short with.
     * @return {@code true} if the specified object is equal to this
     *         {@code Short}; {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.126 -0500", hash_original_method = "0E7C562AADA4AAAABF3DA1440DB603BB", hash_generated_method = "0A8AF6AC553F87DAF0564A149EF4F5AC")
    
@Override
    public boolean equals(Object object) {
        return (object instanceof Short) && (((Short) object).value == value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.128 -0500", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "0138C4AD160C9AAF1F0B41D5F85236C8")
    
@Override
    public float floatValue() {
        return value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.131 -0500", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "C30218EC7C084095E716A93197D10945")
    
@Override
    public int hashCode() {
        return value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.134 -0500", hash_original_method = "4668226786F0223B69B1E8157F3C469B", hash_generated_method = "CED71A70CDF5F216D39A3AE3E558B24B")
    
@Override
    public int intValue() {
        return value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.136 -0500", hash_original_method = "ABF4FE035C950AC910A646D4B85E3F35", hash_generated_method = "1422248BBCC1B2BAF9351E8A3DC0A5BE")
    
@Override
    public long longValue() {
        return value;
    }

    /**
     * Gets the primitive value of this short.
     *
     * @return this object's primitive value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.144 -0500", hash_original_method = "C4526A740A626A32E8FE5B0C1E7B83A6", hash_generated_method = "A82042D96E725949B732B712BE4A645E")
    
@Override
    public short shortValue() {
        return value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.146 -0500", hash_original_method = "6B315C20A4D45816791A47779D79F014", hash_generated_method = "523848B88799F041621FC5C99AD5BFED")
    
@Override
    public String toString() {
        return Integer.toString(value);
    }
    static {
        for (int i = -128; i < 128; i++) {
            SMALL_VALUES[i + 128] = new Short((short) i);
        }
    }
    
}

