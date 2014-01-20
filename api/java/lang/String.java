package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.Charsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Formatter;
import java.util.Locale;
import java.util.regex.Pattern;

import libcore.util.EmptyArray;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class String implements Serializable, Comparable<String>, CharSequence {

    /**
     * Creates a new string containing the characters in the specified character
     * array. Modifying the character array after creating the string has no
     * effect on the string.
     *
     * @param data
     *            the array of characters.
     * @return the new string.
     * @throws NullPointerException
     *             if {@code data} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.866 -0500", hash_original_method = "5D1D071EC3D763C118809FF93B3AD7D2", hash_generated_method = "54629D8B18A57A2E1721D58027EED67E")
    
public static String copyValueOf(char[] data) {
        return new String(data, 0, data.length);
    }

    /**
     * Creates a new string containing the specified characters in the character
     * array. Modifying the character array after creating the string has no
     * effect on the string.
     *
     * @param data
     *            the array of characters.
     * @param start
     *            the starting offset in the character array.
     * @param length
     *            the number of characters to use.
     * @return the new string.
     * @throws NullPointerException
     *             if {@code data} is {@code null}.
     * @throws IndexOutOfBoundsException
     *             if {@code length < 0, start < 0} or {@code start + length >
     *             data.length}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.868 -0500", hash_original_method = "3093818BF79083B0FD2B917354862E11", hash_generated_method = "1C060EFB703FE482F85284AE10D6F2E9")
    
public static String copyValueOf(char[] data, int start, int length) {
        return new String(data, start, length);
    }

    /**
     * Creates a new string containing the characters in the specified character
     * array. Modifying the character array after creating the string has no
     * effect on the string.
     *
     * @param data
     *            the array of characters.
     * @return the new string.
     * @throws NullPointerException
     *             if {@code data} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.979 -0500", hash_original_method = "2AD282CF508D37D852086ADCE714282E", hash_generated_method = "776F4278129F815F7D3D233435C9582D")
    
public static String valueOf(char[] data) {
        return new String(data, 0, data.length);
    }

    /**
     * Creates a new string containing the specified characters in the character
     * array. Modifying the character array after creating the string has no
     * effect on the string.
     *
     * @param data
     *            the array of characters.
     * @param start
     *            the starting offset in the character array.
     * @param length
     *            the number of characters to use.
     * @return the new string.
     * @throws IndexOutOfBoundsException
     *             if {@code length < 0}, {@code start < 0} or {@code start +
     *             length > data.length}
     * @throws NullPointerException
     *             if {@code data} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.981 -0500", hash_original_method = "1671E7A24B213A5C550B79186B0002D8", hash_generated_method = "D8D832B7B9642A12311BA120932EEB0C")
    
public static String valueOf(char[] data, int start, int length) {
        return new String(data, start, length);
    }

    /**
     * Converts the specified character to its string representation.
     *
     * @param value
     *            the character.
     * @return the character converted to a string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.984 -0500", hash_original_method = "E7EDEB2BF9CD79B50B8CB74658BC8C20", hash_generated_method = "839E58FC55C9841E5D7E21929ABC3E81")
    
public static String valueOf(char value) {
        String s;
        if (value < 128) {
            s = new String(value, 1, ASCII);
        } else {
            s = new String(0, 1, new char[] { value });
        }
        s.hashCode = value;
        return s;
    }

    /**
     * Converts the specified double to its string representation.
     *
     * @param value
     *            the double.
     * @return the double converted to a string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.986 -0500", hash_original_method = "4A643EE28A4F78CB638222A80F5F07F5", hash_generated_method = "C8C2AA6B7D7DE849B5B81FEC769496B0")
    
public static String valueOf(double value) {
        return Double.toString(value);
    }

    /**
     * Converts the specified float to its string representation.
     *
     * @param value
     *            the float.
     * @return the float converted to a string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.989 -0500", hash_original_method = "A7339CF0A1845E47429F861771033D8B", hash_generated_method = "CF7DB5FFCBA3D0CB08B7AE31583B8A92")
    
public static String valueOf(float value) {
        return Float.toString(value);
    }

    /**
     * Converts the specified integer to its string representation.
     *
     * @param value
     *            the integer.
     * @return the integer converted to a string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.991 -0500", hash_original_method = "7472D0A01C250CDB4203128D331B50ED", hash_generated_method = "AE763BADC02EAD29BBA2436A031207CD")
    
public static String valueOf(int value) {
        return Integer.toString(value);
    }

    /**
     * Converts the specified long to its string representation.
     *
     * @param value
     *            the long.
     * @return the long converted to a string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.993 -0500", hash_original_method = "D1AF4635F236F26EDAA4AC997AD8C09A", hash_generated_method = "2288A665FEBE4EF35DE6B0C0BF9BCD7C")
    
public static String valueOf(long value) {
        return Long.toString(value);
    }

    /**
     * Converts the specified object to its string representation. If the object
     * is null return the string {@code "null"}, otherwise use {@code
     * toString()} to get the string representation.
     *
     * @param value
     *            the object.
     * @return the object converted to a string, or the string {@code "null"}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.996 -0500", hash_original_method = "29C79BCB300036CC1B9D463111BC50FD", hash_generated_method = "8DAED21ABAC747A4DC39D23D809B5F9B")
    
public static String valueOf(Object value) {
        return value != null ? value.toString() : "null";
    }

    /**
     * Converts the specified boolean to its string representation. When the
     * boolean is {@code true} return {@code "true"}, otherwise return {@code
     * "false"}.
     *
     * @param value
     *            the boolean.
     * @return the boolean converted to a string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.998 -0500", hash_original_method = "B6848F35FD27983F085C8CD99AB771A5", hash_generated_method = "1CFE3D87A36EDF4565701FA2D6B59E4A")
    
public static String valueOf(boolean value) {
        return value ? "true" : "false";
    }

    /**
     * Returns a localized formatted string, using the supplied format and arguments,
     * using the user's default locale.
     *
     * <p>If you're formatting a string other than for human
     * consumption, you should use the {@code format(Locale, String, Object...)}
     * overload and supply {@code Locale.US}. See
     * "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args
     *            the list of arguments passed to the formatter. If there are
     *            more arguments than required by {@code format},
     *            additional arguments are ignored.
     * @return the formatted string.
     * @throws NullPointerException if {@code format == null}
     * @throws java.util.IllegalFormatException
     *             if the format is invalid.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.033 -0500", hash_original_method = "4C2FD221C22BC395CCF88A6A55BE98AD", hash_generated_method = "E5991F4FE9E9869A1E27A9D3B810AA76")
    
public static String format(String format, Object... args) {
        return format(Locale.getDefault(), format, args);
    }

    /**
     * Returns a formatted string, using the supplied format and arguments,
     * localized to the given locale.
     *
     * @param locale
     *            the locale to apply; {@code null} value means no localization.
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args
     *            the list of arguments passed to the formatter. If there are
     *            more arguments than required by {@code format},
     *            additional arguments are ignored.
     * @return the formatted string.
     * @throws NullPointerException if {@code format == null}
     * @throws java.util.IllegalFormatException
     *             if the format is invalid.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.036 -0500", hash_original_method = "E957BA4807F1E0C30CA952954DA50144", hash_generated_method = "28E9802C1EC3687D9B95807B64B944A8")
    
public static String format(Locale locale, String format, Object... args) {
        if (format == null) {
            throw new NullPointerException("null format argument");
        }
        int bufferSize = format.length() + (args == null ? 0 : args.length * 10);
        Formatter f = new Formatter(new StringBuilder(bufferSize), locale);
        return f.format(format, args).toString();
    }

    /*
     * An implementation of a String.indexOf that is supposed to perform
     * substantially better than the default algorithm if the "needle" (the
     * subString being searched for) is a constant string.
     *
     * For example, a JIT, upon encountering a call to String.indexOf(String),
     * where the needle is a constant string, may compute the values cache, md2
     * and lastChar, and change the call to the following method.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.039 -0500", hash_original_method = "22B32FEEB55C55BB6E6C36B65473E566", hash_generated_method = "D7CB1AC8FEA0128C6B82B8491B1759C5")
    
@FindBugsSuppressWarnings("UPM_UNCALLED_PRIVATE_METHOD")
    @SuppressWarnings("unused")
    private static int indexOf(String haystackString, String needleString,
            int cache, int md2, char lastChar) {
        char[] haystack = haystackString.value;
        int haystackOffset = haystackString.offset;
        int haystackLength = haystackString.count;
        char[] needle = needleString.value;
        int needleOffset = needleString.offset;
        int needleLength = needleString.count;
        int needleLengthMinus1 = needleLength - 1;
        int haystackEnd = haystackOffset + haystackLength;
        outer_loop: for (int i = haystackOffset + needleLengthMinus1; i < haystackEnd;) {
            if (lastChar == haystack[i]) {
                for (int j = 0; j < needleLengthMinus1; ++j) {
                    if (needle[j + needleOffset] != haystack[i + j
                            - needleLengthMinus1]) {
                        int skip = 1;
                        if ((cache & (1 << haystack[i])) == 0) {
                            skip += j;
                        }
                        i += Math.max(md2, skip);
                        continue outer_loop;
                    }
                }
                return i - needleLengthMinus1 - haystackOffset;
            }

            if ((cache & (1 << haystack[i])) == 0) {
                i += needleLengthMinus1;
            }
            i++;
        }
        return -1;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.754 -0500", hash_original_field = "FD3FEDA6C0FA798616493B49961CBA92", hash_generated_field = "94C8E35BF1C6D0DCD0C640C5B7214BD5")

    private static final long serialVersionUID = -6849794470754667710L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.757 -0500", hash_original_field = "6043FA7459F5A202FA1BB308F3CA1020", hash_generated_field = "44CEA20EA4711232CF026CC7232D685C")

    private static final char REPLACEMENT_CHAR = (char) 0xfffd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.767 -0500", hash_original_field = "4A935136612EAA09E31702F46C8876CF", hash_generated_field = "A2069D0DAA8806E284E1501E715FFAC8")

    public static final Comparator<String> CASE_INSENSITIVE_ORDER = new CaseInsensitiveComparator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.770 -0500", hash_original_field = "C14595FF670F012A0483206D218F5442", hash_generated_field = "6699F3B26E20D4AC1415724EB8FB9705")

    private static  char[] ASCII;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.772 -0500", hash_original_field = "CA3CEF12FBB39E8368D4DC357E1B2764", hash_generated_field = "C068225E28B5BE74066BE5338158F76B")

    private  char[] value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.774 -0500", hash_original_field = "B7E810BF01B52122CB927525A0CA4721", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

    private  int offset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.777 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private  int count;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.780 -0500", hash_original_field = "5A19588B577A4926772CAE314F19FADE", hash_generated_field = "38607001336EF9DE010EF92F750652A2")

    private int hashCode;

    /**
     * Creates an empty string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.783 -0500", hash_original_method = "F65E96A775698E2C256BB1E903F5D8A6", hash_generated_method = "2D4827908F7D1AE19B6B75D4111BE4B4")
    
public String() {
        value = EmptyArray.CHAR;
        offset = 0;
        count = 0;
    }

    /*
     * Private constructor used for JIT optimization.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.785 -0500", hash_original_method = "8A258D0AF74DE6E118252D0EA5531366", hash_generated_method = "992FEE8CDB9ADFFB8D24FE457F6620ED")
    
@SuppressWarnings("unused")
    private String(String s, char c) {
        offset = 0;
        value = new char[s.count + 1];
        count = s.count + 1;
        System.arraycopy(s.value, s.offset, value, 0, s.count);
        value[s.count] = c;
    }

    /**
     * Converts the byte array to a string using the system's
     * {@link java.nio.charset.Charset#defaultCharset default charset}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.788 -0500", hash_original_method = "3CF6472F1EAFF36B200903831BC9D282", hash_generated_method = "03F81E410607AF83FE1129895E924F03")
    
@FindBugsSuppressWarnings("DM_DEFAULT_ENCODING")
    public String(byte[] data) {
        this(data, 0, data.length);
    }

    /**
     * Converts the byte array to a string, setting the high byte of every
     * character to the specified value.
     *
     * @param data
     *            the byte array to convert to a string.
     * @param high
     *            the high byte to use.
     * @throws NullPointerException
     *             if {@code data == null}.
     * @deprecated Use {@link #String(byte[])} or {@link #String(byte[], String)} instead.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.791 -0500", hash_original_method = "94FE9BFA8A903BE49DF8F4E82A84C713", hash_generated_method = "870FACBA9900B05E8ED3F9B0D2FDFB44")
    
@Deprecated
    public String(byte[] data, int high) {
        this(data, high, 0, data.length);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.652 -0400", hash_original_method = "9C5B9D3903B08C7F386C9C307D28A8D8", hash_generated_method = "D6439CB90D6545AC7AC3C86073E9F0E9")
    public  String(byte[] data, int offset, int byteCount) {
        addTaint(byteCount);
        addTaint(data[0]);
    if((offset | byteCount) < 0 || byteCount > data.length - offset)        
        {
            StringIndexOutOfBoundsException var418E2BA1E64B83D51B250BCD9933A252_948252395 = failedBoundsCheck(data.length, offset, byteCount);
            var418E2BA1E64B83D51B250BCD9933A252_948252395.addTaint(taint);
            throw var418E2BA1E64B83D51B250BCD9933A252_948252395;
        } //End block
        CharBuffer cb = Charset.defaultCharset().decode(ByteBuffer.wrap(data, offset, byteCount));
        this.count = cb.length();
        this.offset = 0;
    if(count > 0)        
        {
            value = cb.array();
        } //End block
        else
        {
            value = EmptyArray.CHAR;
        } //End block
        // ---------- Original Method ----------
        //if ((offset | byteCount) < 0 || byteCount > data.length - offset) {
            //throw failedBoundsCheck(data.length, offset, byteCount);
        //}
        //CharBuffer cb = Charset.defaultCharset().decode(ByteBuffer.wrap(data, offset, byteCount));
        //this.count = cb.length();
        //this.offset = 0;
        //if (count > 0) {
            //value = cb.array();
        //} else {
            //value = EmptyArray.CHAR;
        //}
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.695 -0400", hash_original_method = "22A6AFB2E643FB23D243CAF5D019E325", hash_generated_method = "79A975FB90AD0ECD193D044E40A8EEB8")
    @Deprecated
    public  String(byte[] data, int high, int offset, int byteCount) {
    if((offset | byteCount) < 0 || byteCount > data.length - offset)        
        {
    		StringIndexOutOfBoundsException var418E2BA1E64B83D51B250BCD9933A252_1421954499 = failedBoundsCheck(data.length, offset, byteCount);
            var418E2BA1E64B83D51B250BCD9933A252_1421954499.addTaint(taint);
            throw var418E2BA1E64B83D51B250BCD9933A252_1421954499;
        } //End block
        this.offset = 0;
        this.value = new char[byteCount];
        this.count = byteCount;
        high <<= 8;
for(int i = 0;i < count;i++)
        {
            value[i] = (char) (high + (data[offset++] & 0xff));
        } //End block
        // ---------- Original Method ----------
        //if ((offset | byteCount) < 0 || byteCount > data.length - offset) {
            //throw failedBoundsCheck(data.length, offset, byteCount);
        //}
        //this.offset = 0;
        //this.value = new char[byteCount];
        //this.count = byteCount;
        //high <<= 8;
        //for (int i = 0; i < count; i++) {
            //value[i] = (char) (high + (data[offset++] & 0xff));
        //}
    }

    /**
     * Converts the byte array to a string using the named charset.
     *
     * <p>The behavior when the bytes cannot be decoded by the named charset
     * is unspecified. Use {@link java.nio.charset.CharsetDecoder} for more control.
     *
     * @throws NullPointerException
     *             if {@code data == null}.
     * @throws IndexOutOfBoundsException
     *             if {@code byteCount < 0 || offset < 0 || offset + byteCount > data.length}.
     * @throws UnsupportedEncodingException
     *             if the named charset is not supported.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.800 -0500", hash_original_method = "D35F458D65648B05442A41C1A12F30CA", hash_generated_method = "4A2E2E5B578D26BC53ADEAE92430F57A")
    
public String(byte[] data, int offset, int byteCount, String charsetName) throws UnsupportedEncodingException {
        this(data, offset, byteCount, Charset.forNameUEE(charsetName));
    }

    /**
     * Converts the byte array to a string using the named charset.
     *
     * <p>The behavior when the bytes cannot be decoded by the named charset
     * is unspecified. Use {@link java.nio.charset.CharsetDecoder} for more control.
     *
     * @throws NullPointerException
     *             if {@code data == null}.
     * @throws UnsupportedEncodingException
     *             if {@code charsetName} is not supported.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.803 -0500", hash_original_method = "11FE032D0B0EBCDEFC4E4C2065489303", hash_generated_method = "0F260EFB114087F1784BF1AB863C49ED")
    
public String(byte[] data, String charsetName) throws UnsupportedEncodingException {
        this(data, 0, data.length, Charset.forNameUEE(charsetName));
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.813 -0400", hash_original_method = "230168F72CB2A0A48AA9F4A7AFCECA03", hash_generated_method = "5CF85473A930BD9609F6F58C62C97D46")
    public  String(byte[] data, int offset, int byteCount, Charset charset) {
        addTaint(charset.getTaint());
        addTaint(data[0]);
    if((offset | byteCount) < 0 || byteCount > data.length - offset)        
        {
    		StringIndexOutOfBoundsException var418E2BA1E64B83D51B250BCD9933A252_1070100322 = failedBoundsCheck(data.length, offset, byteCount);
            var418E2BA1E64B83D51B250BCD9933A252_1070100322.addTaint(taint);
            throw var418E2BA1E64B83D51B250BCD9933A252_1070100322;
        } //End block
        String canonicalCharsetName = charset.name();
    if(canonicalCharsetName.equals("UTF-8"))        
        {
            byte[] d = data;
            char[] v = new char[byteCount];
            int idx = offset;
            int last = offset + byteCount;
            int s = 0;
    outer            :
            while
(idx < last)            
            {
                byte b0 = d[idx++];
    if((b0 & 0x80) == 0)                
                {
                    int val = b0 & 0xff;
                    v[s++] = (char) val;
                } //End block
                else
    if(((b0 & 0xe0) == 0xc0) || ((b0 & 0xf0) == 0xe0) ||
                        ((b0 & 0xf8) == 0xf0) || ((b0 & 0xfc) == 0xf8) || ((b0 & 0xfe) == 0xfc))                
                {
                    int utfCount = 1;
    if((b0 & 0xf0) == 0xe0)                    
                    utfCount = 2;
                    else
    if((b0 & 0xf8) == 0xf0)                    
                    utfCount = 3;
                    else
    if((b0 & 0xfc) == 0xf8)                    
                    utfCount = 4;
                    else
    if((b0 & 0xfe) == 0xfc)                    
                    utfCount = 5;
    if(idx + utfCount > last)                    
                    {
                        v[s++] = REPLACEMENT_CHAR;
                        break;
                    } //End block
                    int val = b0 & (0x1f >> (utfCount - 1));
for(int i = 0;i < utfCount;i++)
                    {
                        byte b = d[idx++];
    if((b & 0xC0) != 0x80)                        
                        {
                            v[s++] = REPLACEMENT_CHAR;
                            idx--;
                            continue outer;
                        } //End block
                        val <<= 6;
                        val |= b & 0x3f;
                    } //End block
    if((utfCount != 2) && (val >= 0xD800) && (val <= 0xDFFF))                    
                    {
                        v[s++] = REPLACEMENT_CHAR;
                        continue;
                    } //End block
    if(val > 0x10FFFF)                    
                    {
                        v[s++] = REPLACEMENT_CHAR;
                        continue;
                    } //End block
    if(val < 0x10000)                    
                    {
                        v[s++] = (char) val;
                    } //End block
                    else
                    {
                        int x = val & 0xffff;
                        int u = (val >> 16) & 0x1f;
                        int w = (u - 1) & 0xffff;
                        int hi = 0xd800 | (w << 6) | (x >> 10);
                        int lo = 0xdc00 | (x & 0x3ff);
                        v[s++] = (char) hi;
                        v[s++] = (char) lo;
                    } //End block
                } //End block
                else
                {
                    v[s++] = REPLACEMENT_CHAR;
                } //End block
            } //End block
    if(s == byteCount)            
            {
                this.offset = 0;
                this.value = v;
                this.count = s;
            } //End block
            else
            {
                this.offset = 0;
                this.value = new char[s];
                this.count = s;
                System.arraycopy(v, 0, value, 0, s);
            } //End block
        } //End block
        else
    if(canonicalCharsetName.equals("ISO-8859-1"))        
        {
            this.offset = 0;
            this.value = new char[byteCount];
            this.count = byteCount;
            Charsets.isoLatin1BytesToChars(data, offset, byteCount, value);
        } //End block
        else
    if(canonicalCharsetName.equals("US-ASCII"))        
        {
            this.offset = 0;
            this.value = new char[byteCount];
            this.count = byteCount;
            Charsets.asciiBytesToChars(data, offset, byteCount, value);
        } //End block
        else
        {
            CharBuffer cb = charset.decode(ByteBuffer.wrap(data, offset, byteCount));
            this.offset = 0;
            this.count = cb.length();
    if(count > 0)            
            {
                this.value = new char[count];
                System.arraycopy(cb.array(), 0, value, 0, count);
            } //End block
            else
            {
                this.value = EmptyArray.CHAR;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    /**
     * Converts the byte array to a String using the given charset.
     *
     * @throws NullPointerException if {@code data == null}
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.811 -0500", hash_original_method = "9D77FFE69AA84BF1048ED5CBD8EE386C", hash_generated_method = "14BE1B47B3BDFB19FC4452BDB9ABB0DE")
    
public String(byte[] data, Charset charset) {
        this(data, 0, data.length, charset);
    }

    /**
     * Initializes this string to contain the characters in the specified
     * character array. Modifying the character array after creating the string
     * has no effect on the string.
     *
     * @throws NullPointerException if {@code data == null}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.814 -0500", hash_original_method = "84FF2A14EA759DC7C1F299809C55E832", hash_generated_method = "F6B2AA4C452966F0A0FC1D5FF2BE0A93")
    
public String(char[] data) {
        this(data, 0, data.length);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.828 -0400", hash_original_method = "14BFB40845511D49F067DB0E6AC711FE", hash_generated_method = "971E3234E4344BD64B6C546645470DD3")
    public  String(char[] data, int offset, int charCount) {
        addTaint(data[0]);
    if((offset | charCount) < 0 || charCount > data.length - offset)        
        {
    		StringIndexOutOfBoundsException var2D5E1C324B1811ED1BEE61F6C6CD87C2_678970883 = failedBoundsCheck(data.length, offset, charCount);
            var2D5E1C324B1811ED1BEE61F6C6CD87C2_678970883.addTaint(taint);
            throw var2D5E1C324B1811ED1BEE61F6C6CD87C2_678970883;
        } //End block
        this.offset = 0;
        this.value = new char[charCount];
        this.count = charCount;
        System.arraycopy(data, offset, value, 0, count);
        // ---------- Original Method ----------
        //if ((offset | charCount) < 0 || charCount > data.length - offset) {
            //throw failedBoundsCheck(data.length, offset, charCount);
        //}
        //this.offset = 0;
        //this.value = new char[charCount];
        //this.count = charCount;
        //System.arraycopy(data, offset, value, 0, count);
    }

    /*
     * Internal version of the String(char[], int, int) constructor.
     * Does not range check, null check, or copy the character array.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.819 -0500", hash_original_method = "6AA52B72AD5521C733ED3E9463435DD5", hash_generated_method = "6AA52B72AD5521C733ED3E9463435DD5")
    
String(int offset, int charCount, char[] chars) {
        this.value = chars;
        this.offset = offset;
        this.count = charCount;
    }

    /**
     * Constructs a new string with the same sequence of characters as {@code
     * toCopy}. The returned string's <a href="#backing_array">backing array</a>
     * is no larger than necessary.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.822 -0500", hash_original_method = "7D7AE898849737A5DE2F771028ADD293", hash_generated_method = "1067742A918A0414BA56DD0E157F3286")
    
public String(String toCopy) {
        value = (toCopy.value.length == toCopy.count)
                ? toCopy.value
                : Arrays.copyOfRange(toCopy.value, toCopy.offset, toCopy.offset + toCopy.length());
        offset = 0;
        count = value.length;
    }

    /*
     * Private constructor useful for JIT optimization.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.825 -0500", hash_original_method = "8B59C74FD130D5556CE63A5F3CE74139", hash_generated_method = "9EFDB51BAE8337F1F69E4DE1C793F289")
    
@SuppressWarnings( { "unused", "nls" })
    private String(String s1, String s2) {
        if (s1 == null) {
            s1 = "null";
        }
        if (s2 == null) {
            s2 = "null";
        }
        count = s1.count + s2.count;
        value = new char[count];
        offset = 0;
        System.arraycopy(s1.value, s1.offset, value, 0, s1.count);
        System.arraycopy(s2.value, s2.offset, value, s1.count, s2.count);
    }

    /*
     * Private constructor useful for JIT optimization.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.829 -0500", hash_original_method = "E07460C3146BC4727C3E888CAC21772A", hash_generated_method = "AB6303DBA3D4B890C7485A0A9A814A89")
    
@SuppressWarnings( { "unused", "nls" })
    private String(String s1, String s2, String s3) {
        if (s1 == null) {
            s1 = "null";
        }
        if (s2 == null) {
            s2 = "null";
        }
        if (s3 == null) {
            s3 = "null";
        }
        count = s1.count + s2.count + s3.count;
        value = new char[count];
        offset = 0;
        System.arraycopy(s1.value, s1.offset, value, 0, s1.count);
        System.arraycopy(s2.value, s2.offset, value, s1.count, s2.count);
        System.arraycopy(s3.value, s3.offset, value, s1.count + s2.count, s3.count);
    }

    /**
     * Creates a {@code String} from the contents of the specified
     * {@code StringBuffer}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.831 -0500", hash_original_method = "C3DEF5F256BD0FFA01404830FE1A0B0E", hash_generated_method = "3229E36585BD2E2901FD01AB77B2E7F3")
    
public String(StringBuffer stringBuffer) {
        offset = 0;
        synchronized (stringBuffer) {
            value = stringBuffer.shareValue();
            count = stringBuffer.length();
        }
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.865 -0400", hash_original_method = "DE744DAB842D7A0BE4BC8C7648E27967", hash_generated_method = "A4716F806D0CB47D314F039D1EE5E331")
    public  String(int[] codePoints, int offset, int count) {
        addTaint(codePoints[0]);
    if(codePoints == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1224186338 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1224186338.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1224186338;
        } //End block
    if((offset | count) < 0 || count > codePoints.length - offset)        
        {
    		StringIndexOutOfBoundsException varA2C80B735EE8B9656E28477449237B7F_176723695 = failedBoundsCheck(codePoints.length, offset, count);
            varA2C80B735EE8B9656E28477449237B7F_176723695.addTaint(taint);
            throw varA2C80B735EE8B9656E28477449237B7F_176723695;
        } //End block
        this.offset = 0;
        this.value = new char[count * 2];
        int end = offset + count;
        int c = 0;
for(int i = offset;i < end;i++)
        {
            c += Character.toChars(codePoints[i], this.value, c);
        } //End block
        this.count = c;
        // ---------- Original Method ----------
        //if (codePoints == null) {
            //throw new NullPointerException();
        //}
        //if ((offset | count) < 0 || count > codePoints.length - offset) {
            //throw failedBoundsCheck(codePoints.length, offset, count);
        //}
        //this.offset = 0;
        //this.value = new char[count * 2];
        //int end = offset + count;
        //int c = 0;
        //for (int i = offset; i < end; i++) {
            //c += Character.toChars(codePoints[i], this.value, c);
        //}
        //this.count = c;
    }

    /**
     * Creates a {@code String} from the contents of the specified {@code
     * StringBuilder}.
     *
     * @throws NullPointerException
     *             if {@code stringBuilder == null}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.837 -0500", hash_original_method = "1A43E0983F964C9F4090DA81181B802F", hash_generated_method = "1EFA5C7DF66501B4E9300FC7A3F11922")
    
public String(StringBuilder stringBuilder) {
        if (stringBuilder == null) {
            throw new NullPointerException("stringBuilder == null");
        }
        this.offset = 0;
        this.count = stringBuilder.length();
        this.value = new char[this.count];
        stringBuilder.getChars(0, this.count, this.value, 0);
    }

    /*
     * Creates a {@code String} that is s1 + v1. May be used by JIT code.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.840 -0500", hash_original_method = "8767608BAC25DDC267BEC70B13CF72A3", hash_generated_method = "72074810184A2393C111BF6D8ED3EA45")
    
@SuppressWarnings("unused")
    private String(String s1, int v1) {
        if (s1 == null) {
            s1 = "null";
        }
        String s2 = String.valueOf(v1);
        int len = s1.count + s2.count;
        value = new char[len];
        offset = 0;
        System.arraycopy(s1.value, s1.offset, value, 0, s1.count);
        System.arraycopy(s2.value, s2.offset, value, s1.count, s2.count);
        count = len;
    }

    /**
     * Returns the character at the specified offset in this string.
     *
     * @param index
     *            the zero-based index in this string.
     * @return the character at the index.
     * @throws IndexOutOfBoundsException
     *             if {@code index < 0} or {@code index >= length()}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.844 -0500", hash_original_method = "87185450AF15BAF9DFFE5741D5928D9B", hash_generated_method = "272AD850E35F32A66C440BDE6E73AF76")
    
    public char charAt(int index){
    	//Formerly a native method
    	addTaint(index);
    	return getTaintChar();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.847 -0500", hash_original_method = "00E4125D0AA58BE2E1232BB5FC2C4846", hash_generated_method = "B1159EE4C7B906D7F8C1FC8C15EB0D6B")
    
private StringIndexOutOfBoundsException indexAndLength(int index) {
        throw new StringIndexOutOfBoundsException(this, index);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.849 -0500", hash_original_method = "C5BE1ED07127E02665146DD0ACED99A5", hash_generated_method = "FB9D4ABD48FCEC7C8540B108B1A60F24")
    
private StringIndexOutOfBoundsException startEndAndLength(int start, int end) {
        throw new StringIndexOutOfBoundsException(this, start, end - start);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.852 -0500", hash_original_method = "FABF855F22C4847A4FF9FC56E0D56C67", hash_generated_method = "2123D70BF7727C5EDBF7D1832FE04260")
    
private StringIndexOutOfBoundsException failedBoundsCheck(int arrayLength, int offset, int count) {
        throw new StringIndexOutOfBoundsException(arrayLength, offset, count);
    }

    /**
     * This isn't equivalent to either of ICU's u_foldCase case folds, and thus any of the Unicode
     * case folds, but it's what the RI uses.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.855 -0500", hash_original_method = "1D42C2C4BD065BE4935C25058CB25A0E", hash_generated_method = "1FA0F03FEC4C1822C6D78194D6620044")
    
private char foldCase(char ch) {
        if (ch < 128) {
            if ('A' <= ch && ch <= 'Z') {
                return (char) (ch + ('a' - 'A'));
            }
            return ch;
        }
        return Character.toLowerCase(Character.toUpperCase(ch));
    }

    /**
     * Compares the specified string to this string using the Unicode values of
     * the characters. Returns 0 if the strings contain the same characters in
     * the same order. Returns a negative integer if the first non-equal
     * character in this string has a Unicode value which is less than the
     * Unicode value of the character at the same position in the specified
     * string, or if this string is a prefix of the specified string. Returns a
     * positive integer if the first non-equal character in this string has a
     * Unicode value which is greater than the Unicode value of the character at
     * the same position in the specified string, or if the specified string is
     * a prefix of this string.
     *
     * @param string
     *            the string to compare.
     * @return 0 if the strings are equal, a negative integer if this string is
     *         before the specified string, or a positive integer if this string
     *         is after the specified string.
     * @throws NullPointerException
     *             if {@code string} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.858 -0500", hash_original_method = "E601A465E2566ECC4B972E253D5CFD79", hash_generated_method = "57FA755FC26750AD99632FC2AFFBA3C3")
    
    public int compareTo(String string){
    	//Formerly a native method
    	addTaint(string.getTaint());
    	return getTaintInt();
    }

    /**
     * Compares the specified string to this string using the Unicode values of
     * the characters, ignoring case differences. Returns 0 if the strings
     * contain the same characters in the same order. Returns a negative integer
     * if the first non-equal character in this string has a Unicode value which
     * is less than the Unicode value of the character at the same position in
     * the specified string, or if this string is a prefix of the specified
     * string. Returns a positive integer if the first non-equal character in
     * this string has a Unicode value which is greater than the Unicode value
     * of the character at the same position in the specified string, or if the
     * specified string is a prefix of this string.
     *
     * @param string
     *            the string to compare.
     * @return 0 if the strings are equal, a negative integer if this string is
     *         before the specified string, or a positive integer if this string
     *         is after the specified string.
     * @throws NullPointerException
     *             if {@code string} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.860 -0500", hash_original_method = "1A9A71EFE325E55C19A2B451F1A9B9E2", hash_generated_method = "F7E005DD24A38F96E3E071826A6E3889")
    
public int compareToIgnoreCase(String string) {
        int o1 = offset, o2 = string.offset, result;
        int end = offset + (count < string.count ? count : string.count);
        char c1, c2;
        char[] target = string.value;
        while (o1 < end) {
            if ((c1 = value[o1++]) == (c2 = target[o2++])) {
                continue;
            }
            c1 = foldCase(c1);
            c2 = foldCase(c2);
            if ((result = c1 - c2) != 0) {
                return result;
            }
        }
        return count - string.count;
    }

    /**
     * Concatenates this string and the specified string.
     *
     * @param string
     *            the string to concatenate
     * @return a new string which is the concatenation of this string and the
     *         specified string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.863 -0500", hash_original_method = "F488471D994E6AC017026A4A172508CF", hash_generated_method = "21A9CBF4CE60BC5F74030C540EEF2812")
    
public String concat(String string) {
        if (string.count > 0 && count > 0) {
            char[] buffer = new char[count + string.count];
            System.arraycopy(value, offset, buffer, 0, count);
            System.arraycopy(string.value, string.offset, buffer, count, string.count);
            return new String(0, buffer.length, buffer);
        }
        return count == 0 ? string : this;
    }

    /**
     * Compares the specified string to this string to determine if the
     * specified string is a suffix.
     *
     * @param suffix
     *            the suffix to look for.
     * @return {@code true} if the specified string is a suffix of this string,
     *         {@code false} otherwise.
     * @throws NullPointerException
     *             if {@code suffix} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.871 -0500", hash_original_method = "3B37EFF40C149A7A244BFEF0002B2C93", hash_generated_method = "2C24111E3C33F98C179B82A67E3EFE53")
    
public boolean endsWith(String suffix) {
        return regionMatches(count - suffix.count, suffix, 0, suffix.count);
    }

    /**
     * Compares the specified object to this string and returns true if they are
     * equal. The object must be an instance of string with the same characters
     * in the same order.
     *
     * @param object
     *            the object to compare.
     * @return {@code true} if the specified object is equal to this string,
     *         {@code false} otherwise.
     * @see #hashCode
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.875 -0500", hash_original_method = "84733F87EF08EE029ED9292B40928CC1", hash_generated_method = "F0F3281614602C65EE2A4BACD0B9E7C9")
    
    @Override
    public boolean equals(Object object){
    	//Formerly a native method
    	addTaint(object.getTaint());
    	return getTaintBoolean();
    }

    /**
     * Compares the specified string to this string ignoring the case of the
     * characters and returns true if they are equal.
     *
     * @param string
     *            the string to compare.
     * @return {@code true} if the specified string is equal to this string,
     *         {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.877 -0500", hash_original_method = "2D6A09B1457D58571ED784483A3E54F2", hash_generated_method = "8B92707DD4A71374670A5694D30393A6")
    
@FindBugsSuppressWarnings("ES_COMPARING_PARAMETER_STRING_WITH_EQ")
    public boolean equalsIgnoreCase(String string) {
        if (string == this) {
            return true;
        }
        if (string == null || count != string.count) {
            return false;
        }
        int o1 = offset, o2 = string.offset;
        int end = offset + count;
        char[] target = string.value;
        while (o1 < end) {
            char c1 = value[o1++];
            char c2 = target[o2++];
            if (c1 != c2 && foldCase(c1) != foldCase(c2)) {
                return false;
            }
        }
        return true;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.952 -0400", hash_original_method = "628C355D58441C62D711BC1C2A898A67", hash_generated_method = "96F0117EE797C83FEB58E8D326BFF607")
    @Deprecated
    public void getBytes(int start, int end, byte[] data, int index) {
        addTaint(index);
        addTaint(data[0]);
        addTaint(end);
        addTaint(start);
    if(start >= 0 && start <= end && end <= count)        
        {
            end += offset;
            try 
            {
for(int i = offset + start;i < end;i++)
                {
                    data[index++] = (byte) value[i];
                } //End block
            } //End block
            catch (ArrayIndexOutOfBoundsException ignored)
            {
            	StringIndexOutOfBoundsException varD87E3E0DEDBE23D233BE92E396080AE4_1181737688 = failedBoundsCheck(data.length, index, end - start);
                varD87E3E0DEDBE23D233BE92E396080AE4_1181737688.addTaint(taint);
                throw varD87E3E0DEDBE23D233BE92E396080AE4_1181737688;
            } //End block
        } //End block
        else
        {
        	StringIndexOutOfBoundsException varD4320BED3007B31B0BCB1B90CDC7325C_794172148 = startEndAndLength(start, end);
            varD4320BED3007B31B0BCB1B90CDC7325C_794172148.addTaint(taint);
            throw varD4320BED3007B31B0BCB1B90CDC7325C_794172148;
        } //End block
        // ---------- Original Method ----------
        //if (start >= 0 && start <= end && end <= count) {
            //end += offset;
            //try {
                //for (int i = offset + start; i < end; i++) {
                    //data[index++] = (byte) value[i];
                //}
            //} catch (ArrayIndexOutOfBoundsException ignored) {
                //throw failedBoundsCheck(data.length, index, end - start);
            //}
        //} else {
            //throw startEndAndLength(start, end);
        //}
    }

    /**
     * Returns a new byte array containing the characters of this string encoded using the
     * system's {@link java.nio.charset.Charset#defaultCharset default charset}.
     *
     * <p>The behavior when this string cannot be represented in the system's default charset
     * is unspecified. In practice, when the default charset is UTF-8 (as it is on Android),
     * all strings can be encoded.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.883 -0500", hash_original_method = "2E4CA200D3933E45C3FC02936B120C89", hash_generated_method = "0A6A6039C4B3B9F2FADF6ED1F57152BB")
    
public byte[] getBytes() {
        return getBytes(Charset.defaultCharset());
    }

    /**
     * Returns a new byte array containing the characters of this string encoded using the
     * named charset.
     *
     * <p>The behavior when this string cannot be represented in the named charset
     * is unspecified. Use {@link java.nio.charset.CharsetEncoder} for more control.
     *
     * @throws UnsupportedEncodingException if the charset is not supported
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.886 -0500", hash_original_method = "D1476A765D84241818C22751CEBD7DE3", hash_generated_method = "DC158139A24E25D529425729D16D0CBF")
    
public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
        return getBytes(Charset.forNameUEE(charsetName));
    }

    /**
     * Returns a new byte array containing the characters of this string encoded using the
     * given charset.
     *
     * <p>The behavior when this string cannot be represented in the given charset
     * is to replace malformed input and unmappable characters with the charset's default
     * replacement byte array. Use {@link java.nio.charset.CharsetEncoder} for more control.
     *
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.888 -0500", hash_original_method = "56FDAE3B6641018546E6C6674268142D", hash_generated_method = "B122503E334C5D64C92FAC8F5D7C7C64")
    
public byte[] getBytes(Charset charset) {
        String canonicalCharsetName = charset.name();
        if (canonicalCharsetName.equals("UTF-8")) {
            return Charsets.toUtf8Bytes(value, offset, count);
        } else if (canonicalCharsetName.equals("ISO-8859-1")) {
            return Charsets.toIsoLatin1Bytes(value, offset, count);
        } else if (canonicalCharsetName.equals("US-ASCII")) {
            return Charsets.toAsciiBytes(value, offset, count);
        } else if (canonicalCharsetName.equals("UTF-16BE")) {
            return Charsets.toBigEndianUtf16Bytes(value, offset, count);
        } else {
            CharBuffer chars = CharBuffer.wrap(this.value, this.offset, this.count);
            ByteBuffer buffer = charset.encode(chars.asReadOnlyBuffer());
            byte[] bytes = new byte[buffer.limit()];
            buffer.get(bytes);
            return bytes;
        }
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.989 -0400", hash_original_method = "D443F19C798F5645F696FD1973BB47C6", hash_generated_method = "168F6E3DA50E280535B3342B42AF704F")
    public void getChars(int start, int end, char[] buffer, int index) {
        addTaint(index);
        addTaint(buffer[0]);
        addTaint(end);
        addTaint(start);
    if(start >= 0 && start <= end && end <= count)        
        {
            System.arraycopy(value, start + offset, buffer, index, end - start);
        } //End block
        else
        {
        	StringIndexOutOfBoundsException varD4320BED3007B31B0BCB1B90CDC7325C_1302296784 = startEndAndLength(start, end);
            varD4320BED3007B31B0BCB1B90CDC7325C_1302296784.addTaint(taint);
            throw varD4320BED3007B31B0BCB1B90CDC7325C_1302296784;
        } //End block
        // ---------- Original Method ----------
        //if (start >= 0 && start <= end && end <= count) {
            //System.arraycopy(value, start + offset, buffer, index, end - start);
        //} else {
            //throw startEndAndLength(start, end);
        //}
    }

    /**
     * Version of getChars without bounds checks, for use by other classes
     * within the java.lang package only.  The caller is responsible for
     * ensuring that start >= 0 && start <= end && end <= count.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.893 -0500", hash_original_method = "25FFBBE7056EE87BB826458DBC43764C", hash_generated_method = "238DD3FC86386D3311138731220E8FD2")
    
void _getChars(int start, int end, char[] buffer, int index) {
        // NOTE last character not copied!
        System.arraycopy(value, start + offset, buffer, index, end - start);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.896 -0500", hash_original_method = "19D1106FC463FB90112A6C6293D6F5CF", hash_generated_method = "AB31E2FB551110250A6FEC92F9C5DCA2")
    
@Override public int hashCode() {
        int hash = hashCode;
        if (hash == 0) {
            if (count == 0) {
                return 0;
            }
            final int end = count + offset;
            final char[] chars = value;
            for (int i = offset; i < end; ++i) {
                hash = 31*hash + chars[i];
            }
            hashCode = hash;
        }
        return hash;
    }

    /**
     * Searches in this string for the first index of the specified character.
     * The search for the character starts at the beginning and moves towards
     * the end of this string.
     *
     * @param c
     *            the character to find.
     * @return the index in this string of the specified character, -1 if the
     *         character isn't found.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.898 -0500", hash_original_method = "C183CC13D668537DB52873A8A3264758", hash_generated_method = "EF3ED02C218F9DCEE08DD51AAB959F02")
    
public int indexOf(int c) {
        // TODO: just "return indexOf(c, 0);" when the JIT can inline that deep.
        if (c > 0xffff) {
            return indexOfSupplementary(c, 0);
        }
        return fastIndexOf(c, 0);
    }

    /**
     * Searches in this string for the index of the specified character. The
     * search for the character starts at the specified offset and moves towards
     * the end of this string.
     *
     * @param c
     *            the character to find.
     * @param start
     *            the starting offset.
     * @return the index in this string of the specified character, -1 if the
     *         character isn't found.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.900 -0500", hash_original_method = "A9B16E70D2A4A056B33DA4268AACFBA9", hash_generated_method = "F50F2C459FB5069F52492E2F1C167523")
    
public int indexOf(int c, int start) {
        if (c > 0xffff) {
            return indexOfSupplementary(c, start);
        }
        return fastIndexOf(c, start);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.904 -0500", hash_original_method = "158E0BDE7178D291CA067E7481407A6C", hash_generated_method = "50A62FB275EDAD928891334122C78843")
    
    private int fastIndexOf(int c, int start){
    	//Formerly a native method
    	addTaint(c);
    	addTaint(start);
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.906 -0500", hash_original_method = "9DA1418F8A10F302F688A26755CAB088", hash_generated_method = "6D78EED33ED21368534C2D933E989ED8")
    
private int indexOfSupplementary(int c, int start) {
        if (!Character.isSupplementaryCodePoint(c)) {
            return -1;
        }
        char[] chars = Character.toChars(c);
        String needle = new String(0, chars.length, chars);
        return indexOf(needle, start);
    }

    /**
     * Searches in this string for the first index of the specified string. The
     * search for the string starts at the beginning and moves towards the end
     * of this string.
     *
     * @param string
     *            the string to find.
     * @return the index of the first character of the specified string in this
     *         string, -1 if the specified string is not a substring.
     * @throws NullPointerException
     *             if {@code string} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.909 -0500", hash_original_method = "AC187DA6A9C2600FBA62EFD5097D8F4D", hash_generated_method = "0D57523B1B110B3F4F960ABB598D0797")
    
public int indexOf(String string) {
        int start = 0;
        int subCount = string.count;
        int _count = count;
        if (subCount > 0) {
            if (subCount > _count) {
                return -1;
            }
            char[] target = string.value;
            int subOffset = string.offset;
            char firstChar = target[subOffset];
            int end = subOffset + subCount;
            while (true) {
                int i = indexOf(firstChar, start);
                if (i == -1 || subCount + i > _count) {
                    return -1; // handles subCount > count || start >= count
                }
                int o1 = offset + i, o2 = subOffset;
                char[] _value = value;
                while (++o2 < end && _value[++o1] == target[o2]) {
                    // Intentionally empty
                }
                if (o2 == end) {
                    return i;
                }
                start = i + 1;
            }
        }
        return start < _count ? start : _count;
    }

    /**
     * Searches in this string for the index of the specified string. The search
     * for the string starts at the specified offset and moves towards the end
     * of this string.
     *
     * @param subString
     *            the string to find.
     * @param start
     *            the starting offset.
     * @return the index of the first character of the specified string in this
     *         string, -1 if the specified string is not a substring.
     * @throws NullPointerException
     *             if {@code subString} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.912 -0500", hash_original_method = "30C77F2F1070D21229A0301D2E3C23FC", hash_generated_method = "7B5C852FA9A1DF46DDC4AC013C96E720")
    
public int indexOf(String subString, int start) {
        if (start < 0) {
            start = 0;
        }
        int subCount = subString.count;
        int _count = count;
        if (subCount > 0) {
            if (subCount + start > _count) {
                return -1;
            }
            char[] target = subString.value;
            int subOffset = subString.offset;
            char firstChar = target[subOffset];
            int end = subOffset + subCount;
            while (true) {
                int i = indexOf(firstChar, start);
                if (i == -1 || subCount + i > _count) {
                    return -1; // handles subCount > count || start >= count
                }
                int o1 = offset + i, o2 = subOffset;
                char[] _value = value;
                while (++o2 < end && _value[++o1] == target[o2]) {
                    // Intentionally empty
                }
                if (o2 == end) {
                    return i;
                }
                start = i + 1;
            }
        }
        return start < _count ? start : _count;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.870 -0400", hash_original_method = "8D834ED1699A050AD62397187973DE2A", hash_generated_method = "D27768EE08A87AC5AC201AAF7BA53F8D")
    public String intern() {
    	return new String();
    }

    /**
     * Returns true if the length of this string is 0.
     *
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.921 -0500", hash_original_method = "9B1CCC3AB82A9C7B7A46C788921405FB", hash_generated_method = "9EFBA24431943EE0CA752566A6372B65")
    
    public boolean isEmpty(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    /**
     * Returns the last index of the code point {@code c}, or -1.
     * The search for the character starts at the end and moves towards the
     * beginning of this string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.923 -0500", hash_original_method = "B7458CFA700437DC398BF47C5A311056", hash_generated_method = "4ABC1CA75C51E38C8A7EC35525D60FD3")
    
public int lastIndexOf(int c) {
        if (c > 0xffff) {
            return lastIndexOfSupplementary(c, Integer.MAX_VALUE);
        }
        int _count = count;
        int _offset = offset;
        char[] _value = value;
        for (int i = _offset + _count - 1; i >= _offset; --i) {
            if (_value[i] == c) {
                return i - _offset;
            }
        }
        return -1;
    }

    /**
     * Returns the last index of the code point {@code c}, or -1.
     * The search for the character starts at offset {@code start} and moves towards
     * the beginning of this string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.926 -0500", hash_original_method = "438C7E0E01B0881067FA33086AF4D678", hash_generated_method = "8DBC195876C77C52FE93414465403496")
    
public int lastIndexOf(int c, int start) {
        if (c > 0xffff) {
            return lastIndexOfSupplementary(c, start);
        }
        int _count = count;
        int _offset = offset;
        char[] _value = value;
        if (start >= 0) {
            if (start >= _count) {
                start = _count - 1;
            }
            for (int i = _offset + start; i >= _offset; --i) {
                if (_value[i] == c) {
                    return i - _offset;
                }
            }
        }
        return -1;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.928 -0500", hash_original_method = "ECC6B0EDCC4F01358439BB31BFF21134", hash_generated_method = "EB35337649F216A80A16127A0A991E05")
    
private int lastIndexOfSupplementary(int c, int start) {
        if (!Character.isSupplementaryCodePoint(c)) {
            return -1;
        }
        char[] chars = Character.toChars(c);
        String needle = new String(0, chars.length, chars);
        return lastIndexOf(needle, start);
    }

    /**
     * Searches in this string for the last index of the specified string. The
     * search for the string starts at the end and moves towards the beginning
     * of this string.
     *
     * @param string
     *            the string to find.
     * @return the index of the first character of the specified string in this
     *         string, -1 if the specified string is not a substring.
     * @throws NullPointerException
     *             if {@code string} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.931 -0500", hash_original_method = "692347B4AF93950259A2DA740A39B258", hash_generated_method = "FEF0BFF9BA9E8F1DA2DE7F055FC99EC3")
    
public int lastIndexOf(String string) {
        // Use count instead of count - 1 so lastIndexOf("") returns count
        return lastIndexOf(string, count);
    }

    /**
     * Searches in this string for the index of the specified string. The search
     * for the string starts at the specified offset and moves towards the
     * beginning of this string.
     *
     * @param subString
     *            the string to find.
     * @param start
     *            the starting offset.
     * @return the index of the first character of the specified string in this
     *         string , -1 if the specified string is not a substring.
     * @throws NullPointerException
     *             if {@code subString} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.934 -0500", hash_original_method = "08D5FBAA11FAAE0244D1BD87258C05E0", hash_generated_method = "EEF14964EDF3E0241435E51BAF061B2D")
    
public int lastIndexOf(String subString, int start) {
        int subCount = subString.count;
        if (subCount <= count && start >= 0) {
            if (subCount > 0) {
                if (start > count - subCount) {
                    start = count - subCount;
                }
                // count and subCount are both >= 1
                char[] target = subString.value;
                int subOffset = subString.offset;
                char firstChar = target[subOffset];
                int end = subOffset + subCount;
                while (true) {
                    int i = lastIndexOf(firstChar, start);
                    if (i == -1) {
                        return -1;
                    }
                    int o1 = offset + i, o2 = subOffset;
                    while (++o2 < end && value[++o1] == target[o2]) {
                        // Intentionally empty
                    }
                    if (o2 == end) {
                        return i;
                    }
                    start = i - 1;
                }
            }
            return start < count ? start : count;
        }
        return -1;
    }

    /**
     * Returns the size of this string.
     *
     * @return the number of characters in this string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.937 -0500", hash_original_method = "026D3AE6EA7284BA85CF864429138595", hash_generated_method = "41F61E755A7C3306650DE1A02239C8F3")
    
    public int length(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * Compares the specified string to this string and compares the specified
     * range of characters to determine if they are the same.
     *
     * @param thisStart
     *            the starting offset in this string.
     * @param string
     *            the string to compare.
     * @param start
     *            the starting offset in the specified string.
     * @param length
     *            the number of characters to compare.
     * @return {@code true} if the ranges of characters are equal, {@code false}
     *         otherwise
     * @throws NullPointerException
     *             if {@code string} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.940 -0500", hash_original_method = "8EA3BFAB97A4D4877FC2554FB493C6C0", hash_generated_method = "91E7B8B05EA1C3F175A3139FD889C65C")
    
public boolean regionMatches(int thisStart, String string, int start, int length) {
        if (string == null) {
            throw new NullPointerException();
        }
        if (start < 0 || string.count - start < length) {
            return false;
        }
        if (thisStart < 0 || count - thisStart < length) {
            return false;
        }
        if (length <= 0) {
            return true;
        }
        int o1 = offset + thisStart, o2 = string.offset + start;
        char[] value1 = value;
        char[] value2 = string.value;
        for (int i = 0; i < length; ++i) {
            if (value1[o1 + i] != value2[o2 + i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compares the specified string to this string and compares the specified
     * range of characters to determine if they are the same. When ignoreCase is
     * true, the case of the characters is ignored during the comparison.
     *
     * @param ignoreCase
     *            specifies if case should be ignored.
     * @param thisStart
     *            the starting offset in this string.
     * @param string
     *            the string to compare.
     * @param start
     *            the starting offset in the specified string.
     * @param length
     *            the number of characters to compare.
     * @return {@code true} if the ranges of characters are equal, {@code false}
     *         otherwise.
     * @throws NullPointerException
     *             if {@code string} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.943 -0500", hash_original_method = "5098FC46543D7D1A735E08AA962F8003", hash_generated_method = "88F17216AA2E98FA881DE372CE6364E6")
    
public boolean regionMatches(boolean ignoreCase, int thisStart, String string, int start, int length) {
        if (!ignoreCase) {
            return regionMatches(thisStart, string, start, length);
        }
        if (string == null) {
            throw new NullPointerException("string == null");
        }
        if (thisStart < 0 || length > count - thisStart) {
            return false;
        }
        if (start < 0 || length > string.count - start) {
            return false;
        }
        thisStart += offset;
        start += string.offset;
        int end = thisStart + length;
        char[] target = string.value;
        while (thisStart < end) {
            char c1 = value[thisStart++];
            char c2 = target[start++];
            if (c1 != c2 && foldCase(c1) != foldCase(c2)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Copies this string replacing occurrences of the specified character with
     * another character.
     *
     * @param oldChar
     *            the character to replace.
     * @param newChar
     *            the replacement character.
     * @return a new string with occurrences of oldChar replaced by newChar.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.946 -0500", hash_original_method = "52751D07523F52C15F0E15149B768BF7", hash_generated_method = "6DD64A04FC7BC7DC0050E5B221454760")
    
public String replace(char oldChar, char newChar) {
        char[] buffer = value;
        int _offset = offset;
        int _count = count;

        int idx = _offset;
        int last = _offset + _count;
        boolean copied = false;
        while (idx < last) {
            if (buffer[idx] == oldChar) {
                if (!copied) {
                    char[] newBuffer = new char[_count];
                    System.arraycopy(buffer, _offset, newBuffer, 0, _count);
                    buffer = newBuffer;
                    idx -= _offset;
                    last -= _offset;
                    copied = true;
                }
                buffer[idx] = newChar;
            }
            idx++;
        }

        return copied ? new String(0, count, buffer) : this;
    }

    /**
     * Copies this string replacing occurrences of the specified target sequence
     * with another sequence. The string is processed from the beginning to the
     * end.
     *
     * @param target
     *            the sequence to replace.
     * @param replacement
     *            the replacement sequence.
     * @return the resulting string.
     * @throws NullPointerException
     *             if {@code target} or {@code replacement} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.949 -0500", hash_original_method = "226EAAC156D556D42E48670E64FEC4E8", hash_generated_method = "BAA289D8CF1FC3382A99E9306635F827")
    
public String replace(CharSequence target, CharSequence replacement) {
        if (target == null) {
            throw new NullPointerException("target == null");
        }
        if (replacement == null) {
            throw new NullPointerException("replacement == null");
        }

        String targetString = target.toString();
        int matchStart = indexOf(targetString, 0);
        if (matchStart == -1) {
            // If there's nothing to replace, return the original string untouched.
            return this;
        }

        String replacementString = replacement.toString();

        // The empty target matches at the start and end and between each character.
        int targetLength = targetString.length();
        if (targetLength == 0) {
            int resultLength = (count + 2) * replacementString.length();
            StringBuilder result = new StringBuilder(resultLength);
            result.append(replacementString);
            for (int i = offset; i < count; ++i) {
                result.append(value[i]);
                result.append(replacementString);
            }
            return result.toString();
        }

        StringBuilder result = new StringBuilder(count);
        int searchStart = 0;
        do {
            // Copy characters before the match...
            result.append(value, offset + searchStart, matchStart - searchStart);
            // Insert the replacement...
            result.append(replacementString);
            // And skip over the match...
            searchStart = matchStart + targetLength;
        } while ((matchStart = indexOf(targetString, searchStart)) != -1);
        // Copy any trailing chars...
        result.append(value, offset + searchStart, count - searchStart);
        return result.toString();
    }

    /**
     * Compares the specified string to this string to determine if the
     * specified string is a prefix.
     *
     * @param prefix
     *            the string to look for.
     * @return {@code true} if the specified string is a prefix of this string,
     *         {@code false} otherwise
     * @throws NullPointerException
     *             if {@code prefix} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.951 -0500", hash_original_method = "8508513C5D9E5D7A42B020CFB91803A3", hash_generated_method = "CE66BF7B4E46285328F82EC9849A383E")
    
public boolean startsWith(String prefix) {
        return startsWith(prefix, 0);
    }

    /**
     * Compares the specified string to this string, starting at the specified
     * offset, to determine if the specified string is a prefix.
     *
     * @param prefix
     *            the string to look for.
     * @param start
     *            the starting offset.
     * @return {@code true} if the specified string occurs in this string at the
     *         specified offset, {@code false} otherwise.
     * @throws NullPointerException
     *             if {@code prefix} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.953 -0500", hash_original_method = "DCA59D254EE64B3144EDF9B3ACB43A45", hash_generated_method = "3003C39C59D3032711D80AD8F78AAB14")
    
public boolean startsWith(String prefix, int start) {
        return regionMatches(start, prefix, 0, prefix.count);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.029 -0400", hash_original_method = "CB27750752A8934950488E0046CA5119", hash_generated_method = "33066E8AA094172FFF0CEC5E486EDCD6")
    public String substring(int start) {
        addTaint(start);
    if(start == 0)        
        {
String var72A74007B2BE62B849F475C7BDA4658B_2102003325 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2102003325.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2102003325;
        } //End block
    if(start >= 0 && start <= count)        
        {
String var2B0D1736DD1B19490531C381A1416ABB_1242432222 =             new String(offset + start, count - start, value);
            var2B0D1736DD1B19490531C381A1416ABB_1242432222.addTaint(taint);
            return var2B0D1736DD1B19490531C381A1416ABB_1242432222;
        } //End block
    	StringIndexOutOfBoundsException varC9C52284361B891C0CBD2284A6FE0828_1101455365 = indexAndLength(start);
        varC9C52284361B891C0CBD2284A6FE0828_1101455365.addTaint(taint);
        throw varC9C52284361B891C0CBD2284A6FE0828_1101455365;
        // ---------- Original Method ----------
        //if (start == 0) {
            //return this;
        //}
        //if (start >= 0 && start <= count) {
            //return new String(offset + start, count - start, value);
        //}
        //throw indexAndLength(start);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.049 -0400", hash_original_method = "FA273138383309E9BFDA8AAE2A7C6025", hash_generated_method = "0A4B172CD2951ABC21C7191BBBED5414")
    public String substring(int start, int end) {
        addTaint(end);
        addTaint(start);
    if(start == 0 && end == count)        
        {
String var72A74007B2BE62B849F475C7BDA4658B_93020799 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_93020799.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_93020799;
        } //End block
    if(start >= 0 && start <= end && end <= count)        
        {
String var2511EA3E5FEAAD0D48B436EB1999CC85_1798446020 =             new String(offset + start, end - start, value);
            var2511EA3E5FEAAD0D48B436EB1999CC85_1798446020.addTaint(taint);
            return var2511EA3E5FEAAD0D48B436EB1999CC85_1798446020;
        } //End block
    	StringIndexOutOfBoundsException varD4320BED3007B31B0BCB1B90CDC7325C_134150222 = startEndAndLength(start, end);
        varD4320BED3007B31B0BCB1B90CDC7325C_134150222.addTaint(taint);
        throw varD4320BED3007B31B0BCB1B90CDC7325C_134150222;
        // ---------- Original Method ----------
        //if (start == 0 && end == count) {
            //return this;
        //}
        //if (start >= 0 && start <= end && end <= count) {
            //return new String(offset + start, end - start, value);
        //}
        //throw startEndAndLength(start, end);
    }

    /**
     * Copies the characters in this string to a character array.
     *
     * @return a character array containing the characters of this string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.961 -0500", hash_original_method = "66BAEF040BB5FDC80731F9B16CD33C32", hash_generated_method = "F8512EE67F64CE701F309692817A9311")
    
public char[] toCharArray() {
        char[] buffer = new char[count];
        System.arraycopy(value, offset, buffer, 0, count);
        return buffer;
    }

    /**
     * Converts this string to lower case, using the rules of the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @return a new lower case string, or {@code this} if it's already all lower case.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.964 -0500", hash_original_method = "1FBB4BF6938E55C9E24FEC1EE0A95252", hash_generated_method = "E97C0644499688529C3BF08E85BC65DF")
    
public String toLowerCase() {
        return CaseMapper.toLowerCase(Locale.getDefault(), this, value, offset, count);
    }

    /**
     * Converts this string to lower case, using the rules of {@code locale}.
     *
     * <p>Most case mappings are unaffected by the language of a {@code Locale}. Exceptions include
     * dotted and dotless I in Azeri and Turkish locales, and dotted and dotless I and J in
     * Lithuanian locales. On the other hand, it isn't necessary to provide a Greek locale to get
     * correct case mapping of Greek characters: any locale will do.
     *
     * <p>See <a href="http://www.unicode.org/Public/UNIDATA/SpecialCasing.txt">http://www.unicode.org/Public/UNIDATA/SpecialCasing.txt</a>
     * for full details of context- and language-specific special cases.
     *
     * @return a new lower case string, or {@code this} if it's already all lower case.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.967 -0500", hash_original_method = "3BCA227A64DF8F05552679E5E357BCF1", hash_generated_method = "5FD4747EA9A442FB66B7E27AF997C7EF")
    
public String toLowerCase(Locale locale) {
        return CaseMapper.toLowerCase(locale, this, value, offset, count);
    }

    /**
     * Returns this string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.969 -0500", hash_original_method = "068E2EE4236B85776135405F1B66AD49", hash_generated_method = "28DD1B4FF5D0D981D70F8CACE98B810E")
    
@Override
    public String toString() {
        return this;
    }

    /**
     * Converts this this string to upper case, using the rules of the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @return a new upper case string, or {@code this} if it's already all upper case.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.971 -0500", hash_original_method = "8DEC33A26AFC2829CCCCE108ECEB9551", hash_generated_method = "CD069DB34D6C0A6A177A7F24AFE5CA91")
    
public String toUpperCase() {
        return CaseMapper.toUpperCase(Locale.getDefault(), this, value, offset, count);
    }

    /**
     * Converts this this string to upper case, using the rules of {@code locale}.
     *
     * <p>Most case mappings are unaffected by the language of a {@code Locale}. Exceptions include
     * dotted and dotless I in Azeri and Turkish locales, and dotted and dotless I and J in
     * Lithuanian locales. On the other hand, it isn't necessary to provide a Greek locale to get
     * correct case mapping of Greek characters: any locale will do.
     *
     * <p>See <a href="http://www.unicode.org/Public/UNIDATA/SpecialCasing.txt">http://www.unicode.org/Public/UNIDATA/SpecialCasing.txt</a>
     * for full details of context- and language-specific special cases.
     *
     * @return a new upper case string, or {@code this} if it's already all upper case.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.973 -0500", hash_original_method = "11C711663B7D81E6BD865533BF51B442", hash_generated_method = "4E7E51E15F7C29846F15EFA5377AAAED")
    
public String toUpperCase(Locale locale) {
        return CaseMapper.toUpperCase(locale, this, value, offset, count);
    }

    /**
     * Copies this string removing white space characters from the beginning and
     * end of the string.
     *
     * @return a new string with characters <code><= \\u0020</code> removed from
     *         the beginning and the end.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.976 -0500", hash_original_method = "5AB01C88F799E5B54FF71EE82B91E811", hash_generated_method = "EC72A69BD5DAA2B233102023BAFFC2D1")
    
public String trim() {
        int start = offset, last = offset + count - 1;
        int end = last;
        while ((start <= end) && (value[start] <= ' ')) {
            start++;
        }
        while ((end >= start) && (value[end] <= ' ')) {
            end--;
        }
        if (start == offset && end == last) {
            return this;
        }
        return new String(start, end - start + 1, value);
    }

    /**
     * Returns whether the characters in the StringBuffer {@code strbuf} are the
     * same as those in this string.
     *
     * @param strbuf
     *            the StringBuffer to compare this string to.
     * @return {@code true} if the characters in {@code strbuf} are identical to
     *         those in this string. If they are not, {@code false} will be
     *         returned.
     * @throws NullPointerException
     *             if {@code strbuf} is {@code null}.
     * @since 1.4
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.001 -0500", hash_original_method = "233CB676C051D9EE76740A9343D1B467", hash_generated_method = "4B95AEE813CA7CAF74C1B96B4257E04D")
    
public boolean contentEquals(StringBuffer strbuf) {
        synchronized (strbuf) {
            int size = strbuf.length();
            if (count != size) {
                return false;
            }
            return regionMatches(0, new String(0, size, strbuf.getValue()), 0,
                    size);
        }
    }

    /**
     * Compares a {@code CharSequence} to this {@code String} to determine if
     * their contents are equal.
     *
     * @param cs
     *            the character sequence to compare to.
     * @return {@code true} if equal, otherwise {@code false}
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.004 -0500", hash_original_method = "733340B51AD84F3351AE4177729AE631", hash_generated_method = "002CA0AA9437153C4069C729DA94CA0D")
    
public boolean contentEquals(CharSequence cs) {
        if (cs == null) {
            throw new NullPointerException();
        }

        int len = cs.length();

        if (len != count) {
            return false;
        }

        if (len == 0 && count == 0) {
            return true; // since both are empty strings
        }

        return regionMatches(0, cs.toString(), 0, len);
    }

    /**
     * Tests whether this string matches the given {@code regularExpression}. This method returns
     * true only if the regular expression matches the <i>entire</i> input string. A common mistake is
     * to assume that this method behaves like {@link #contains}; if you want to match anywhere
     * within the input string, you need to add {@code .*} to the beginning and end of your
     * regular expression. See {@link Pattern#matches}.
     *
     * <p>If the same regular expression is to be used for multiple operations, it may be more
     * efficient to reuse a compiled {@code Pattern}.
     *
     * @throws PatternSyntaxException
     *             if the syntax of the supplied regular expression is not
     *             valid.
     * @throws NullPointerException if {@code regularExpression == null}
     * @since 1.4
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.007 -0500", hash_original_method = "54546B1154273B2EF815CC4641C4AF95", hash_generated_method = "31150CC120132529E2C554553C68A957")
    
public boolean matches(String regularExpression) {
        return Pattern.matches(regularExpression, this);
    }

    /**
     * Replaces all matches for {@code regularExpression} within this string with the given
     * {@code replacement}.
     * See {@link Pattern} for regular expression syntax.
     *
     * <p>If the same regular expression is to be used for multiple operations, it may be more
     * efficient to reuse a compiled {@code Pattern}.
     *
     * @throws PatternSyntaxException
     *             if the syntax of the supplied regular expression is not
     *             valid.
     * @throws NullPointerException if {@code regularExpression == null}
     * @see Pattern
     * @since 1.4
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.009 -0500", hash_original_method = "85FB9291CC087326BB42DD27D5FF2770", hash_generated_method = "39E48D55E8E4F9E59F58690640BB29E5")
    
public String replaceAll(String regularExpression, String replacement) {
        return Pattern.compile(regularExpression).matcher(this).replaceAll(replacement);
    }

    /**
     * Replaces the first match for {@code regularExpression} within this string with the given
     * {@code replacement}.
     * See {@link Pattern} for regular expression syntax.
     *
     * <p>If the same regular expression is to be used for multiple operations, it may be more
     * efficient to reuse a compiled {@code Pattern}.
     *
     * @throws PatternSyntaxException
     *             if the syntax of the supplied regular expression is not
     *             valid.
     * @throws NullPointerException if {@code regularExpression == null}
     * @see Pattern
     * @since 1.4
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.012 -0500", hash_original_method = "B1F6469D7EA429A7B60DE2A4BC9D1B18", hash_generated_method = "E6B964A174237D2BB7F3EA8A25C91AB3")
    
public String replaceFirst(String regularExpression, String replacement) {
        return Pattern.compile(regularExpression).matcher(this).replaceFirst(replacement);
    }

    /**
     * Splits this string using the supplied {@code regularExpression}.
     * Equivalent to {@code split(regularExpression, 0)}.
     * See {@link Pattern#split(CharSequence, int)} for an explanation of {@code limit}.
     * See {@link Pattern} for regular expression syntax.
     *
     * <p>If the same regular expression is to be used for multiple operations, it may be more
     * efficient to reuse a compiled {@code Pattern}.
     *
     * @throws NullPointerException if {@code regularExpression ==  null}
     * @throws PatternSyntaxException
     *             if the syntax of the supplied regular expression is not
     *             valid.
     * @see Pattern
     * @since 1.4
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.014 -0500", hash_original_method = "0ADD043F2AA11242F9B6645F9D3630BF", hash_generated_method = "E1341A3A010CA709FCD2C88E1FF85169")
    
public String[] split(String regularExpression) {
        return split(regularExpression, 0);
    }

    /**
     * Splits this string using the supplied {@code regularExpression}.
     * See {@link Pattern#split(CharSequence, int)} for an explanation of {@code limit}.
     * See {@link Pattern} for regular expression syntax.
     *
     * <p>If the same regular expression is to be used for multiple operations, it may be more
     * efficient to reuse a compiled {@code Pattern}.
     *
     * @throws NullPointerException if {@code regularExpression ==  null}
     * @throws PatternSyntaxException
     *             if the syntax of the supplied regular expression is not
     *             valid.
     * @since 1.4
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.016 -0500", hash_original_method = "4FB3AE192250E9EE292BE09F829C7FA4", hash_generated_method = "C2609287AD57B7D934CE6820CFD38AD3")
    
public String[] split(String regularExpression, int limit) {
        String[] result = java.util.regex.Splitter.fastSplit(regularExpression, this, limit);
        return result != null ? result : Pattern.compile(regularExpression).split(this, limit);
    }

    /**
     * Has the same result as the substring function, but is present so that
     * string may implement the CharSequence interface.
     *
     * @param start
     *            the offset the first character.
     * @param end
     *            the offset of one past the last character to include.
     * @return the subsequence requested.
     * @throws IndexOutOfBoundsException
     *             if {@code start < 0}, {@code end < 0}, {@code start > end} or
     *             {@code end > length()}.
     * @see java.lang.CharSequence#subSequence(int, int)
     * @since 1.4
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.019 -0500", hash_original_method = "30B2B5AAE6BF00B7B5DE2415CD1C93C0", hash_generated_method = "31F89698891865DDF37976A5038C7055")
    
public CharSequence subSequence(int start, int end) {
        return substring(start, end);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.090 -0400", hash_original_method = "C7D49B0E887DD351A54FAD0BD917A973", hash_generated_method = "4AA0D970F53A5437960DBB5362FF8172")
    public int codePointAt(int index) {
        addTaint(index);
    if(index < 0 || index >= count)        
        {
    	StringIndexOutOfBoundsException var31A81F65A9D9C0D123C8BD6CC0A6023B_617343388 = indexAndLength(index);
            var31A81F65A9D9C0D123C8BD6CC0A6023B_617343388.addTaint(taint);
            throw var31A81F65A9D9C0D123C8BD6CC0A6023B_617343388;
        } //End block
        int varEE8BC5793D2C542E0A836DB30841DA8A_1658467558 = (Character.codePointAt(value, offset + index, offset + count));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_148219104 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_148219104;
        // ---------- Original Method ----------
        //if (index < 0 || index >= count) {
            //throw indexAndLength(index);
        //}
        //return Character.codePointAt(value, offset + index, offset + count);
    }
    
    private static final class CaseInsensitiveComparator implements Comparator<String>, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.761 -0500", hash_original_field = "B7203C3971CD9B594DE7FEBB21441635", hash_generated_field = "094B85F4F683BB296AFE95E1161C88EE")

        private static final long serialVersionUID = 8575799808933029326L;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.207 -0400", hash_original_method = "4085F5B81BF948B4B3F485D1409A9E33", hash_generated_method = "4085F5B81BF948B4B3F485D1409A9E33")
        public CaseInsensitiveComparator ()
        {
            //Synthesized constructor
        }

        /**
         * Compare the two objects to determine the relative ordering.
         *
         * @param o1
         *            an Object to compare
         * @param o2
         *            an Object to compare
         * @return an int < 0 if object1 is less than object2, 0 if they are
         *         equal, and > 0 if object1 is greater
         *
         * @exception ClassCastException
         *                if objects are not the correct type
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.763 -0500", hash_original_method = "10AFFFE45F62C15CA0052EB0BB14A8D3", hash_generated_method = "3D313DA5441FEBF36B8C87503DF1A73A")
        
public int compare(String o1, String o2) {
            return o1.compareToIgnoreCase(o2);
        }
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.114 -0400", hash_original_method = "45488902F6B74F4C7EAF8C828C18FB65", hash_generated_method = "E474A1580CC8AB31224E1CF48558880A")
    public int codePointBefore(int index) {
        addTaint(index);
    if(index < 1 || index > count)        
        {
    	StringIndexOutOfBoundsException var31A81F65A9D9C0D123C8BD6CC0A6023B_1409268217 = indexAndLength(index);
            var31A81F65A9D9C0D123C8BD6CC0A6023B_1409268217.addTaint(taint);
            throw var31A81F65A9D9C0D123C8BD6CC0A6023B_1409268217;
        } //End block
        int var4AB76CEFEA1FB0DE48F3964B1821A4C6_1597611864 = (Character.codePointBefore(value, offset + index, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674809760 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674809760;
        // ---------- Original Method ----------
        //if (index < 1 || index > count) {
            //throw indexAndLength(index);
        //}
        //return Character.codePointBefore(value, offset + index, offset);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.142 -0400", hash_original_method = "B50CCA2DE0C54B693E25540AFEB12014", hash_generated_method = "641A2FDB54DC47F97CC5C57D56F8065A")
    public int codePointCount(int start, int end) {
        addTaint(end);
        addTaint(start);
    if(start < 0 || end > count || start > end)        
        {
    	StringIndexOutOfBoundsException varD4320BED3007B31B0BCB1B90CDC7325C_1760037970 = startEndAndLength(start, end);
            varD4320BED3007B31B0BCB1B90CDC7325C_1760037970.addTaint(taint);
            throw varD4320BED3007B31B0BCB1B90CDC7325C_1760037970;
        } //End block
        int varC15299B150726000BD0A690208962788_992060442 = (Character.codePointCount(value, offset + start, end - start));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1762269847 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1762269847;
        // ---------- Original Method ----------
        //if (start < 0 || end > count || start > end) {
            //throw startEndAndLength(start, end);
        //}
        //return Character.codePointCount(value, offset + start, end - start);
    }

    /**
     * Determines if this {@code String} contains the sequence of characters in
     * the {@code CharSequence} passed.
     *
     * @param cs
     *            the character sequence to search for.
     * @return {@code true} if the sequence of characters are contained in this
     *         string, otherwise {@code false}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.028 -0500", hash_original_method = "994533EB4329C14FF0C3B68A297AD053", hash_generated_method = "B306D1B94E8E09DC82F103510417208B")
    
public boolean contains(CharSequence cs) {
        if (cs == null) {
            throw new NullPointerException();
        }
        return indexOf(cs.toString()) >= 0;
    }

    /**
     * Returns the index within this object that is offset from {@code index} by
     * {@code codePointOffset} code points.
     *
     * @param index
     *            the index within this object to calculate the offset from.
     * @param codePointOffset
     *            the number of code points to count.
     * @return the index within this object that is the offset.
     * @throws IndexOutOfBoundsException
     *             if {@code index} is negative or greater than {@code length()}
     *             or if there aren't enough code points before or after {@code
     *             index} to match {@code codePointOffset}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.031 -0500", hash_original_method = "3AF353F7691F77FE6437135BD27DAE4A", hash_generated_method = "BC45D9282C0FD11E84D0B3CB63D25ECA")
    
public int offsetByCodePoints(int index, int codePointOffset) {
        int s = index + offset;
        int r = Character.offsetByCodePoints(value, offset, count, s, codePointOffset);
        return r - offset;
    }
    static {
        ASCII = new char[128];
        for (int i = 0; i < ASCII.length; ++i) {
            ASCII[i] = (char) i;
        }
    }
}

