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
        String str = new String("<String.valueOf()>");
        str.addTaint(value);
        return str;
        /*
          String s;
        if (value < 128) {
            s = new String(value, 1, ASCII);
        } else {
            s = new String(0, 1, new char[] { value });
        }
        s.hashCode = value;
        return s;
        */
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
        String str = new String("<String.valueOf()>");
        str.addTaint(value);
        return str;

        //return Double.toString(value);
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
        String str = new String("<String.valueOf()>");
        str.addTaint(value);
        return str;

        //return Float.toString(value);
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
        String str = new String("<String.valueOf()>");
        str.addTaint(value);
        return str;

        //return Integer.toString(value);
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
        String str = new String("<String.valueOf()>");
        str.addTaint(value);
        return str;

        //return Long.toString(value);
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
        if (value == null)
            return "null";
        String str = new String();
        str.addTaint(value.getTaint());
        return str;
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
        String str = new String("<Formated String>");
        str.addTaint(format.getTaint());
        for (Object arg : args) 
            str.addTaint(arg.toString().getTaint());
        return str;
        /*
        if (format == null) {
            throw new NullPointerException("null format argument");
        }
        int bufferSize = format.length() + (args == null ? 0 : args.length * 10);
        Formatter f = new Formatter(new StringBuilder(bufferSize), locale);
        return f.format(format, args).toString();
        */
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
        int ret = haystackString.getTaintInt() + needleString.getTaintInt() + cache + md2 + (int)lastChar;
        return ret;
    }
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.754 -0500", hash_original_field = "FD3FEDA6C0FA798616493B49961CBA92", hash_generated_field = "94C8E35BF1C6D0DCD0C640C5B7214BD5")

        private static final long serialVersionUID = -6849794470754667710L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.757 -0500", hash_original_field = "6043FA7459F5A202FA1BB308F3CA1020", hash_generated_field = "44CEA20EA4711232CF026CC7232D685C")

        private static final char REPLACEMENT_CHAR = (char) 0xfffd;

        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.767 -0500", hash_original_field = "4A935136612EAA09E31702F46C8876CF", hash_generated_field = "A2069D0DAA8806E284E1501E715FFAC8")

    public static final Comparator<String> CASE_INSENSITIVE_ORDER = new CaseInsensitiveComparator();

    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.770 -0500", hash_original_field = "C14595FF670F012A0483206D218F5442", hash_generated_field = "6699F3B26E20D4AC1415724EB8FB9705")

        private static  char[] ASCII;

    //@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.772 -0500", hash_original_field = "CA3CEF12FBB39E8368D4DC357E1B2764", hash_generated_field = "C068225E28B5BE74066BE5338158F76B")
        //        private  char[] value;

    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.774 -0500", hash_original_field = "B7E810BF01B52122CB927525A0CA4721", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

        private  int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.777 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

        private  int count;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.780 -0500", hash_original_field = "5A19588B577A4926772CAE314F19FADE", hash_generated_field = "38607001336EF9DE010EF92F750652A2")

        private int hashCode;

    /**
     * Creates an empty string.
     */
    @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.783 -0500", hash_original_method = "F65E96A775698E2C256BB1E903F5D8A6", hash_generated_method = "2D4827908F7D1AE19B6B75D4111BE4B4")
    
        public String() {
        //        value = EmptyArray.CHAR;
        offset = 0;
        count = 0;
    }
    
    
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public String(DSTaintObject t) {
        this();
        addTaint(t);
    }
    

    /*
     * Private constructor used for JIT optimization.
     */
    @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.785 -0500", hash_original_method = "8A258D0AF74DE6E118252D0EA5531366", hash_generated_method = "992FEE8CDB9ADFFB8D24FE457F6620ED")
    
        @SuppressWarnings("unused")
        private String(String s, char c) {
        offset = 0;
        //        value = new char[s.count + 1];
        count = s.count + 1;
        //System.arraycopy(s.value, s.offset, value, 0, s.count);
        //value[s.count] = c;
        this.addTaint(s.getTaint());
        this.addTaint(c);
    }

    /**
     * Converts the byte array to a string using the system's
     * {@link java.nio.charset.Charset#defaultCharset default charset}.
     */
    @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
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
    @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.791 -0500", hash_original_method = "94FE9BFA8A903BE49DF8F4E82A84C713", hash_generated_method = "870FACBA9900B05E8ED3F9B0D2FDFB44")
    
        @Deprecated
        public String(byte[] data, int high) {
        this(data, high, 0, data.length);
    }
    
    @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.652 -0400", hash_original_method = "9C5B9D3903B08C7F386C9C307D28A8D8", hash_generated_method = "D6439CB90D6545AC7AC3C86073E9F0E9")
        public  String(byte[] data, int offset, int byteCount) {
        this.addTaint(data[0]);
        this.addTaint(offset);
        this.addTaint(byteCount);

        //End block
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
    
    @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.695 -0400", hash_original_method = "22A6AFB2E643FB23D243CAF5D019E325", hash_generated_method = "79A975FB90AD0ECD193D044E40A8EEB8")
        @Deprecated
    public  String(byte[] data, int high, int offset, int byteCount) {
        if (DroidSafeAndroidRuntime.control)
            throw failedBoundsCheck(data.length, offset, byteCount);
        this.addTaint(data[0]);
        this.addTaint(high);
        this.addTaint(offset);
        this.addTaint(byteCount);
        

        //End block
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
    @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
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
    @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.803 -0500", hash_original_method = "11FE032D0B0EBCDEFC4E4C2065489303", hash_generated_method = "0F260EFB114087F1784BF1AB863C49ED")
    
        public String(byte[] data, String charsetName) throws UnsupportedEncodingException {
        this(data, 0, data.length, Charset.forNameUEE(charsetName));
    }
    
    @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.813 -0400", hash_original_method = "230168F72CB2A0A48AA9F4A7AFCECA03", hash_generated_method = "5CF85473A930BD9609F6F58C62C97D46")
        public  String(byte[] data, int offset, int byteCount, Charset charset) {
        addTaint(charset.getTaint());
        addTaint(data[0]);
    }

    /**
     * Converts the byte array to a String using the given charset.
     *
     * @throws NullPointerException if {@code data == null}
     * @since 1.6
     */
    @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
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
    @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.814 -0500", hash_original_method = "84FF2A14EA759DC7C1F299809C55E832", hash_generated_method = "F6B2AA4C452966F0A0FC1D5FF2BE0A93")
    
        public String(char[] data) {
        this(data, 0, data.length);
    }
    
    @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.828 -0400", hash_original_method = "14BFB40845511D49F067DB0E6AC711FE", hash_generated_method = "971E3234E4344BD64B6C546645470DD3")
        public  String(char[] data, int offset, int charCount) {
        addTaint(data[0]);
    }

    /*
     * Internal version of the String(char[], int, int) constructor.
     * Does not range check, null check, or copy the character array.
     */
    @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.819 -0500", hash_original_method = "6AA52B72AD5521C733ED3E9463435DD5", hash_generated_method = "6AA52B72AD5521C733ED3E9463435DD5")
    
        String(int offset, int charCount, char[] chars) {
        //this.value = chars;
        this.addTaint(chars[0]);
        this.offset = offset;
        this.count = charCount;
    }

    /**
     * Constructs a new string with the same sequence of characters as {@code
     * toCopy}. The returned string's <a href="#backing_array">backing array</a>
     * is no larger than necessary.
     */
    @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.822 -0500", hash_original_method = "7D7AE898849737A5DE2F771028ADD293", hash_generated_method = "1067742A918A0414BA56DD0E157F3286")
    
        public String(String toCopy) {
        addTaint(toCopy.getTaint());
    }

    /*
     * Private constructor useful for JIT optimization.
     */
    @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.825 -0500", hash_original_method = "8B59C74FD130D5556CE63A5F3CE74139", hash_generated_method = "9EFDB51BAE8337F1F69E4DE1C793F289")
    
        @SuppressWarnings( { "unused", "nls" })
        private String(String s1, String s2) {
        addTaint(s1.getTaint());addTaint(s2.getTaint());
    }

    /*
     * Private constructor useful for JIT optimization.
     */
    @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.829 -0500", hash_original_method = "E07460C3146BC4727C3E888CAC21772A", hash_generated_method = "AB6303DBA3D4B890C7485A0A9A814A89")
    
        @SuppressWarnings( { "unused", "nls" })
        private String(String s1, String s2, String s3) {
        addTaint(s1.getTaint());addTaint(s2.getTaint());addTaint(s3.getTaint());
    }

    /**
     * Creates a {@code String} from the contents of the specified
     * {@code StringBuffer}.
     */
    @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.831 -0500", hash_original_method = "C3DEF5F256BD0FFA01404830FE1A0B0E", hash_generated_method = "3229E36585BD2E2901FD01AB77B2E7F3")
    
        public String(StringBuffer stringBuffer) {
        addTaint(stringBuffer.getTaint());
    }
    
    /** used by droidsafe to model strings in the information flow */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
        public String(AbstractStringBuilder sb) {
        addTaint(sb.getTaint());
    }
    
    @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.865 -0400", hash_original_method = "DE744DAB842D7A0BE4BC8C7648E27967", hash_generated_method = "A4716F806D0CB47D314F039D1EE5E331")
        public  String(int[] codePoints, int offset, int count) {
        addTaint(codePoints[0]);
    }

    /**
     * Creates a {@code String} from the contents of the specified {@code
     * StringBuilder}.
     *
     * @throws NullPointerException
     *             if {@code stringBuilder == null}.
     * @since 1.5
     */
    @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.837 -0500", hash_original_method = "1A43E0983F964C9F4090DA81181B802F", hash_generated_method = "1EFA5C7DF66501B4E9300FC7A3F11922")
    
        public String(StringBuilder stringBuilder) {
        addTaint(stringBuilder.getTaint());
    }

    /*
     * Creates a {@code String} that is s1 + v1. May be used by JIT code.
     */
    @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.840 -0500", hash_original_method = "8767608BAC25DDC267BEC70B13CF72A3", hash_generated_method = "72074810184A2393C111BF6D8ED3EA45")
    
        @SuppressWarnings("unused")
        private String(String s1, int v1) {
        addTaint(s1.getTaint());addTaint(v1);
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
        addTaint(ch);
        return getTaintChar();
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
        return getTaintInt();
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
        addTaint(string.getTaint());
        return this;
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
        return getTaintBoolean();
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
        return super.equals(object);
    	//addTaint(object.getTaint());
    	//return getTaintBoolean();
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
        return getTaintBoolean();
    }
    
    @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.952 -0400", hash_original_method = "628C355D58441C62D711BC1C2A898A67", hash_generated_method = "96F0117EE797C83FEB58E8D326BFF607")
        @Deprecated
        public void getBytes(int start, int end, byte[] data, int index) {
        data.addTaint(getTaint());
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
        byte[] bytes = new byte[1];
        
        bytes.addTaint(getTaint());
        bytes[0] = getTaintByte();
        return bytes;

        //return getBytes(Charset.forNameUEE(charsetName));
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
        byte[] bytes = new byte[1];
        
        bytes.addTaint(getTaint());
        bytes[0] = getTaintByte();
        return bytes;
    }
    
    @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.989 -0400", hash_original_method = "D443F19C798F5645F696FD1973BB47C6", hash_generated_method = "168F6E3DA50E280535B3342B42AF704F")
        public void getChars(int start, int end, char[] buffer, int index) {
        addTaint(index);
        addTaint(end);
        addTaint(start);
        buffer.addTaint(getTaint());
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
        buffer.addTaint(this.getTaint());
    }

    @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.896 -0500", hash_original_method = "19D1106FC463FB90112A6C6293D6F5CF", hash_generated_method = "AB31E2FB551110250A6FEC92F9C5DCA2")
    
        @Override public int hashCode() {
        return getTaintInt();
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
        return getTaintInt();
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
        addTaint(c);
    	addTaint(start);
        return getTaintInt();
    
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
        return indexOf(c, start);
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
        return getTaintInt();
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
        addTaint(subString.getTaint());
        return getTaintInt();
    }
    
    @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.870 -0400", hash_original_method = "8D834ED1699A050AD62397187973DE2A", hash_generated_method = "D27768EE08A87AC5AC201AAF7BA53F8D")
        public String intern() {
    	return this;
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
        return getTaintInt();
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
        return getTaintInt();
    }

    @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.928 -0500", hash_original_method = "ECC6B0EDCC4F01358439BB31BFF21134", hash_generated_method = "EB35337649F216A80A16127A0A991E05")
    
        private int lastIndexOfSupplementary(int c, int start) {
        return getTaintInt();
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
        addTaint(string.getTaint());
        return getTaintInt();
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
        addTaint(subString.getTaint());
        return getTaintInt();
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
        this.addTaint(string.getTaint());
        return getTaintBoolean();
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
        this.addTaint(string.getTaint());
        return getTaintBoolean();
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
        this.addTaint(oldChar);
        addTaint(newChar);
        return this;
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
        addTaint(target.getTaint());
        addTaint(replacement.getTaint());
        return this;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.951 -0500", hash_original_method = "8508513C5D9E5D7A42B020CFB91803A3", hash_generated_method = "CE66BF7B4E46285328F82EC9849A383E")
    
        public boolean startsWith(String prefix) {
        return getTaintBoolean();
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
        return getTaintBoolean();
    }
    
    @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.029 -0400", hash_original_method = "CB27750752A8934950488E0046CA5119", hash_generated_method = "33066E8AA094172FFF0CEC5E486EDCD6")
        public String substring(int start) {
        addTaint(start);
        return this;
    }

    @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.049 -0400", hash_original_method = "FA273138383309E9BFDA8AAE2A7C6025", hash_generated_method = "0A4B172CD2951ABC21C7191BBBED5414")
        public String substring(int start, int end) {
        addTaint(start);
        return this;
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
        buffer.addTaint(this.getTaint());
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
        return this;
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
        return this;
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
        return this;
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
        return this;
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
        return this;
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
        addTaint(strbuf.getTaint());
        return getTaintBoolean();
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
        addTaint(cs.getTaint());
        return getTaintBoolean();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean contains(CharSequence cs) {
        this.addTaint(cs.getTaint());
        return getTaintBoolean();
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
        addTaint(regularExpression.getTaint());
        return getTaintBoolean();
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
        addTaint(regularExpression.getTaint());
        addTaint(replacement.getTaint());
        return this;

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
        addTaint(regularExpression.getTaint());
        addTaint(replacement.getTaint());
        return this;

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
        String[] result = new String[1];
        result.addTaint(this.getTaint());
        return result;

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
        return getTaintInt();
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
        return getTaintInt();
 }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.142 -0400", hash_original_method = "B50CCA2DE0C54B693E25540AFEB12014", hash_generated_method = "641A2FDB54DC47F97CC5C57D56F8065A")
    public int codePointCount(int start, int end) {
        addTaint(end);
        addTaint(start);
        return getTaintInt();
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
        addTaint(index);
        addTaint(codePointOffset);
        return getTaintInt();
    }

    @DSBan(DSCat.DROIDSAFE_INTERNAL)
@Override public void addTaint(DSTaintObject t) {
        super.addTaint(t);
        ASCII[0] = getTaintChar();
        offset = getTaintInt();
        hashCode = getTaintInt();
        count = getTaintInt();
    }

    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    @Override public void addTaint(double t) {
        super.addTaint(t);
        ASCII[0] = getTaintChar();
        offset = getTaintInt();
        hashCode = getTaintInt();
        count = getTaintInt();
    }
    
}

