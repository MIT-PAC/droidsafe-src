package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.regex.Pattern;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
import android.util.Printer;

import com.android.internal.R;
import com.android.internal.util.ArrayUtils;

public class TextUtils {
	static class MyCreator implements Parcelable.Creator<CharSequence> {
        
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        public MyCreator() {}
        
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_OTHERS)
        public CharSequence createFromParcel(Parcel p) {
            return new String();
        }
        
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        public CharSequence[] newArray(int size)
        {
            return new CharSequence[size];
        }

    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.817 -0500", hash_original_method = "B6CD7F3C8D4B193FE534D4C38B1CB19E", hash_generated_method = "6A754CE326C1F91DCD6362C912467103")
    
public static void getChars(CharSequence s, int start, int end,
                                char[] dest, int destoff) {
        Class<? extends CharSequence> c = s.getClass();

        if (c == String.class)
            ((String) s).getChars(start, end, dest, destoff);
        else if (c == StringBuffer.class)
            ((StringBuffer) s).getChars(start, end, dest, destoff);
        else if (c == StringBuilder.class)
            ((StringBuilder) s).getChars(start, end, dest, destoff);
        else if (s instanceof GetChars)
            ((GetChars) s).getChars(start, end, dest, destoff);
        else {
            for (int i = start; i < end; i++)
                dest[destoff++] = s.charAt(i);
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.820 -0500", hash_original_method = "2B288D1C7C5C63AB74BA28EFC2864361", hash_generated_method = "8DFE0A7282F6A63B6F7767B113B8F488")
    
public static int indexOf(CharSequence s, char ch) {
        return indexOf(s, ch, 0);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.822 -0500", hash_original_method = "6B7A92B1181B966A44F83BF97D86A71F", hash_generated_method = "D701A239AF1BE6077A8716C4E83171B7")
    
public static int indexOf(CharSequence s, char ch, int start) {
        Class<? extends CharSequence> c = s.getClass();

        if (c == String.class)
            return ((String) s).indexOf(ch, start);

        return indexOf(s, ch, start, s.length());
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.826 -0500", hash_original_method = "544FCBC88320BB8F6A1660211014CB9B", hash_generated_method = "351510B1C18807C0B37D7F9C4129E3C4")
    
public static int indexOf(CharSequence s, char ch, int start, int end) {
        Class<? extends CharSequence> c = s.getClass();

        if (s instanceof GetChars || c == StringBuffer.class ||
            c == StringBuilder.class || c == String.class) {
            final int INDEX_INCREMENT = 500;
            char[] temp = obtain(INDEX_INCREMENT);

            while (start < end) {
                int segend = start + INDEX_INCREMENT;
                if (segend > end)
                    segend = end;

                getChars(s, start, segend, temp, 0);

                int count = segend - start;
                for (int i = 0; i < count; i++) {
                    if (temp[i] == ch) {
                        recycle(temp);
                        return i + start;
                    }
                }

                start = segend;
            }

            recycle(temp);
            return -1;
        }

        for (int i = start; i < end; i++)
            if (s.charAt(i) == ch)
                return i;

        return -1;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.829 -0500", hash_original_method = "5BBDBA8EF1563B9DD5D1929C015065D1", hash_generated_method = "67AD6698E991A80A60281ADAC00BDF4A")
    
public static int lastIndexOf(CharSequence s, char ch) {
        return lastIndexOf(s, ch, s.length() - 1);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.831 -0500", hash_original_method = "4FA8A924B5587056C4ACB65EA303EF07", hash_generated_method = "4C637339EC9B0FD3CD103091B8C54618")
    
public static int lastIndexOf(CharSequence s, char ch, int last) {
        Class<? extends CharSequence> c = s.getClass();

        if (c == String.class)
            return ((String) s).lastIndexOf(ch, last);

        return lastIndexOf(s, ch, 0, last);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.834 -0500", hash_original_method = "1ABC9B5C8394779C90EF8CC1F1AE5E2C", hash_generated_method = "97400C84F2C886AC62F14B07D8F33F30")
    
public static int lastIndexOf(CharSequence s, char ch,
                                  int start, int last) {
        if (last < 0)
            return -1;
        if (last >= s.length())
            last = s.length() - 1;

        int end = last + 1;

        Class<? extends CharSequence> c = s.getClass();

        if (s instanceof GetChars || c == StringBuffer.class ||
            c == StringBuilder.class || c == String.class) {
            final int INDEX_INCREMENT = 500;
            char[] temp = obtain(INDEX_INCREMENT);

            while (start < end) {
                int segstart = end - INDEX_INCREMENT;
                if (segstart < start)
                    segstart = start;

                getChars(s, segstart, end, temp, 0);

                int count = end - segstart;
                for (int i = count - 1; i >= 0; i--) {
                    if (temp[i] == ch) {
                        recycle(temp);
                        return i + segstart;
                    }
                }

                end = segstart;
            }

            recycle(temp);
            return -1;
        }

        for (int i = end - 1; i >= start; i--)
            if (s.charAt(i) == ch)
                return i;

        return -1;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.837 -0500", hash_original_method = "552F02994CC4987C268BA730575E79CF", hash_generated_method = "E4083713F952915589A30CB5A8E482E2")
    
public static int indexOf(CharSequence s, CharSequence needle) {
        return indexOf(s, needle, 0, s.length());
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.840 -0500", hash_original_method = "9BACEDD2FEF7E129003580BFF523FE81", hash_generated_method = "6A64A926622D7920B3924F6E2148AA33")
    
public static int indexOf(CharSequence s, CharSequence needle, int start) {
        return indexOf(s, needle, start, s.length());
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.843 -0500", hash_original_method = "01F707FBADA596DCC00F547189098EC5", hash_generated_method = "C42C8263B6EC5846EAF86F575A406A90")
    
public static int indexOf(CharSequence s, CharSequence needle,
                              int start, int end) {
        int nlen = needle.length();
        if (nlen == 0)
            return start;

        char c = needle.charAt(0);

        for (;;) {
            start = indexOf(s, c, start);
            if (start > end - nlen) {
                break;
            }

            if (start < 0) {
                return -1;
            }

            if (regionMatches(s, start, needle, 0, nlen)) {
                return start;
            }

            start++;
        }
        return -1;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.846 -0500", hash_original_method = "89989795239EEDDAD38EDCA7AB441D22", hash_generated_method = "205353F2B8DAB161A5A2E93F18EE2F9F")
    
public static boolean regionMatches(CharSequence one, int toffset,
                                        CharSequence two, int ooffset,
                                        int len) {
        char[] temp = obtain(2 * len);

        getChars(one, toffset, toffset + len, temp, 0);
        getChars(two, ooffset, ooffset + len, temp, len);

        boolean match = true;
        for (int i = 0; i < len; i++) {
            if (temp[i] != temp[i + len]) {
                match = false;
                break;
            }
        }

        recycle(temp);
        return match;
    }

    /**
     * Create a new String object containing the given range of characters
     * from the source string.  This is different than simply calling
     * {@link CharSequence#subSequence(int, int) CharSequence.subSequence}
     * in that it does not preserve any style runs in the source sequence,
     * allowing a more efficient implementation.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.849 -0500", hash_original_method = "78DE9AEF4C2944726F3B95C9207900D6", hash_generated_method = "F8F3A460C76FF60A06B8FBCA096204C2")
    
public static String substring(CharSequence source, int start, int end) {
        if (source instanceof String)
            return ((String) source).substring(start, end);
        if (source instanceof StringBuilder)
            return ((StringBuilder) source).substring(start, end);
        if (source instanceof StringBuffer)
            return ((StringBuffer) source).substring(start, end);

        char[] temp = obtain(end - start);
        getChars(source, start, end, temp, 0);
        String ret = new String(temp, 0, end - start);
        recycle(temp);

        return ret;
    }

    /**
     * Returns list of multiple {@link CharSequence} joined into a single
     * {@link CharSequence} separated by localized delimiter such as ", ".
     *
     * @hide
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.852 -0500", hash_original_method = "8B31B2502E472EA787355492BFDF03AA", hash_generated_method = "5F9988717201F86C947DA332D70E1763")
    
public static CharSequence join(Iterable<CharSequence> list) {
        final CharSequence delimiter = Resources.getSystem().getText(R.string.list_delimeter);
        return join(delimiter, list);
    }

    /**
     * Returns a string containing the tokens joined by delimiters.
     * @param tokens an array objects to be joined. Strings will be formed from
     *     the objects by calling object.toString().
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.855 -0500", hash_original_method = "30F8C3035802E985549014BC8C1FC857", hash_generated_method = "BCBB36CA6A56C6DC3005FD0730023358")
    
public static String join(CharSequence delimiter, Object[] tokens) {
        StringBuilder sb = new StringBuilder();
        boolean firstTime = true;
        for (Object token: tokens) {
            if (firstTime) {
                firstTime = false;
            } else {
                sb.append(delimiter);
            }
            sb.append(token);
        }
        return sb.toString();
    }

    /**
     * Returns a string containing the tokens joined by delimiters.
     * @param tokens an array objects to be joined. Strings will be formed from
     *     the objects by calling object.toString().
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.858 -0500", hash_original_method = "DC7AF5364772F9FC890BC57B4AE1F82F", hash_generated_method = "7DEC1574CB917C477B50C58627F70E8E")
    
public static String join(CharSequence delimiter, Iterable tokens) {
        StringBuilder sb = new StringBuilder();
        boolean firstTime = true;
        for (Object token: tokens) {
            if (firstTime) {
                firstTime = false;
            } else {
                sb.append(delimiter);
            }
            sb.append(token);
        }
        return sb.toString();
    }

    /**
     * String.split() returns [''] when the string to be split is empty. This returns []. This does
     * not remove any empty strings from the result. For example split("a,", ","  ) returns {"a", ""}.
     *
     * @param text the string to split
     * @param expression the regular expression to match
     * @return an array of strings. The array will be empty if text is empty
     *
     * @throws NullPointerException if expression or text is null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.861 -0500", hash_original_method = "9706658E9A67690C95EF953ED2AFD2D4", hash_generated_method = "05FF8A488F3493254F9474270D9C6B5E")
    
public static String[] split(String text, String expression) {
        if (text.length() == 0) {
            return EMPTY_STRING_ARRAY;
        } else {
            return text.split(expression, -1);
        }
    }

    /**
     * Splits a string on a pattern. String.split() returns [''] when the string to be
     * split is empty. This returns []. This does not remove any empty strings from the result.
     * @param text the string to split
     * @param pattern the regular expression to match
     * @return an array of strings. The array will be empty if text is empty
     *
     * @throws NullPointerException if expression or text is null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.864 -0500", hash_original_method = "EB884963B35B912D5FE47DBF808C36A9", hash_generated_method = "9200C2AED7C2BA6B9C658DA4FEBE62DD")
    
public static String[] split(String text, Pattern pattern) {
        if (text.length() == 0) {
            return EMPTY_STRING_ARRAY;
        } else {
            return pattern.split(text, -1);
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.899 -0500", hash_original_method = "D7DA1CF6D85F29139017BBA0640DB133", hash_generated_method = "5743ECD91F334EFD1208F9CE9706C38D")
    
public static CharSequence stringOrSpannedString(CharSequence source) {
        if (source == null)
            return null;
        if (source instanceof SpannedString)
            return source;
        if (source instanceof Spanned)
            return new SpannedString(source);

        return source.toString();
    }

    /**
     * Returns true if the string is null or 0-length.
     * @param str the string to be examined
     * @return true if str is null or zero length
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.902 -0500", hash_original_method = "87E1A34C0995DE779A857B80EB9CE27A", hash_generated_method = "39933546042860768A7564846E63D2DC")
    
public static boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }

    /**
     * Returns the length that the specified CharSequence would have if
     * spaces and control characters were trimmed from the start and end,
     * as by {@link String#trim}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.904 -0500", hash_original_method = "D991523FF91558FCD5D3B3A348459B48", hash_generated_method = "2CD7D9E9B1F38D7B06B7FD27675F7363")
    
public static int getTrimmedLength(CharSequence s) {
        int len = s.length();

        int start = 0;
        while (start < len && s.charAt(start) <= ' ') {
            start++;
        }

        int end = len;
        while (end > start && s.charAt(end - 1) <= ' ') {
            end--;
        }

        return end - start;
    }

    /**
     * Returns true if a and b are equal, including if they are both null.
     * <p><i>Note: In platform versions 1.1 and earlier, this method only worked well if
     * both the arguments were instances of String.</i></p>
     * @param a first CharSequence to check
     * @param b second CharSequence to check
     * @return true if a and b are equal
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.908 -0500", hash_original_method = "67A0EA29212518310C8922834323A122", hash_generated_method = "B9067C793230A53D0E146B8780FE11D6")
    
public static boolean equals(CharSequence a, CharSequence b) {
        if (a == b) return true;
        int length;
        if (a != null && b != null && (length = a.length()) == b.length()) {
            if (a instanceof String && b instanceof String) {
                return a.equals(b);
            } else {
                for (int i = 0; i < length; i++) {
                    if (a.charAt(i) != b.charAt(i)) return false;
                }
                return true;
            }
        }
        return false;
    }

    // XXX currently this only reverses chars, not spans
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.911 -0500", hash_original_method = "98F930B270648698A021909A60BE17AD", hash_generated_method = "197399D3D66518E7F26D8A6C6C5A4650")
    
public static CharSequence getReverse(CharSequence source,
                                          int start, int end) {
        return new Reverser(source, start, end);
    }

    /**
     * Flatten a CharSequence and whatever styles can be copied across processes
     * into the parcel.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.005 -0500", hash_original_method = "3AB99D64EE2B077E31675DCB4E265A32", hash_generated_method = "42EA47F81EED8389C6DC4542452E1EDA")
    
public static void writeToParcel(CharSequence cs, Parcel p,
            int parcelableFlags) {
        if (cs instanceof Spanned) {
            p.writeInt(0);
            p.writeString(cs.toString());

            Spanned sp = (Spanned) cs;
            Object[] os = sp.getSpans(0, cs.length(), Object.class);

            // note to people adding to this: check more specific types
            // before more generic types.  also notice that it uses
            // "if" instead of "else if" where there are interfaces
            // so one object can be several.

            for (int i = 0; i < os.length; i++) {
                Object o = os[i];
                Object prop = os[i];

                if (prop instanceof CharacterStyle) {
                    prop = ((CharacterStyle) prop).getUnderlying();
                }

                if (prop instanceof ParcelableSpan) {
                    ParcelableSpan ps = (ParcelableSpan)prop;
                    p.writeInt(ps.getSpanTypeId());
                    ps.writeToParcel(p, parcelableFlags);
                    writeWhere(p, sp, o);
                }
            }

            p.writeInt(0);
        } else {
            p.writeInt(1);
            if (cs != null) {
                p.writeString(cs.toString());
            } else {
                p.writeString(null);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.008 -0500", hash_original_method = "9B5ED0499519A130DB4D8B61A9E846A6", hash_generated_method = "B9947CF52F3AFB4C45495453EDAD6B86")
    
private static void writeWhere(Parcel p, Spanned sp, Object o) {
        p.writeInt(sp.getSpanStart(o));
        p.writeInt(sp.getSpanEnd(o));
        p.writeInt(sp.getSpanFlags(o));
    }

    /**
     * Debugging tool to print the spans in a CharSequence.  The output will
     * be printed one span per line.  If the CharSequence is not a Spanned,
     * then the entire string will be printed on a single line.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.024 -0500", hash_original_method = "BE480EAEA78D9AC942A5A115EAA0FF97", hash_generated_method = "9366628B164F37B7BDE9EACCD00BDE22")
    
public static void dumpSpans(CharSequence cs, Printer printer, String prefix) {
        if (cs instanceof Spanned) {
            Spanned sp = (Spanned) cs;
            Object[] os = sp.getSpans(0, cs.length(), Object.class);

            for (int i = 0; i < os.length; i++) {
                Object o = os[i];
                printer.println(prefix + cs.subSequence(sp.getSpanStart(o),
                        sp.getSpanEnd(o)) + ": "
                        + Integer.toHexString(System.identityHashCode(o))
                        + " " + o.getClass().getCanonicalName()
                         + " (" + sp.getSpanStart(o) + "-" + sp.getSpanEnd(o)
                         + ") fl=#" + sp.getSpanFlags(o));
            }
        } else {
            printer.println(prefix + cs + ": (no spans)");
        }
    }

    /**
     * Return a new CharSequence in which each of the source strings is
     * replaced by the corresponding element of the destinations.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.027 -0500", hash_original_method = "7F42862E06E0A79232E639A8406A0D91", hash_generated_method = "0B16D69A787C82725742FAD6D22048F8")
    
public static CharSequence replace(CharSequence template,
                                       String[] sources,
                                       CharSequence[] destinations) {
        SpannableStringBuilder tb = new SpannableStringBuilder(template);

        for (int i = 0; i < sources.length; i++) {
            int where = indexOf(tb, sources[i]);

            if (where >= 0)
                tb.setSpan(sources[i], where, where + sources[i].length(),
                           Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        for (int i = 0; i < sources.length; i++) {
            int start = tb.getSpanStart(sources[i]);
            int end = tb.getSpanEnd(sources[i]);

            if (start >= 0) {
                tb.replace(start, end, destinations[i]);
            }
        }

        return tb;
    }

    /**
     * Replace instances of "^1", "^2", etc. in the
     * <code>template</code> CharSequence with the corresponding
     * <code>values</code>.  "^^" is used to produce a single caret in
     * the output.  Only up to 9 replacement values are supported,
     * "^10" will be produce the first replacement value followed by a
     * '0'.
     *
     * @param template the input text containing "^1"-style
     * placeholder values.  This object is not modified; a copy is
     * returned.
     *
     * @param values CharSequences substituted into the template.  The
     * first is substituted for "^1", the second for "^2", and so on.
     *
     * @return the new CharSequence produced by doing the replacement
     *
     * @throws IllegalArgumentException if the template requests a
     * value that was not provided, or if more than 9 values are
     * provided.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.030 -0500", hash_original_method = "1FFDFAC4EC60B3BFF5CF0C29A1CCA4F1", hash_generated_method = "385C2317CC363F6FCDE6DD1C5672DEF5")
    
public static CharSequence expandTemplate(CharSequence template,
                                              CharSequence... values) {
        if (values.length > 9) {
            throw new IllegalArgumentException("max of 9 values are supported");
        }

        SpannableStringBuilder ssb = new SpannableStringBuilder(template);

        try {
            int i = 0;
            while (i < ssb.length()) {
                if (ssb.charAt(i) == '^') {
                    char next = ssb.charAt(i+1);
                    if (next == '^') {
                        ssb.delete(i+1, i+2);
                        ++i;
                        continue;
                    } else if (Character.isDigit(next)) {
                        int which = Character.getNumericValue(next) - 1;
                        if (which < 0) {
                            throw new IllegalArgumentException(
                                "template requests value ^" + (which+1));
                        }
                        if (which >= values.length) {
                            throw new IllegalArgumentException(
                                "template requests value ^" + (which+1) +
                                "; only " + values.length + " provided");
                        }
                        ssb.replace(i, i+2, values[which]);
                        i += values[which].length();
                        continue;
                    }
                }
                ++i;
            }
        } catch (IndexOutOfBoundsException ignore) {
            // happens when ^ is the last character in the string.
        }
        return ssb;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.034 -0500", hash_original_method = "8161B498320C5E1EE65901C7324FD829", hash_generated_method = "F1C499A6FEA9F782BC1630BFA1CC4934")
    
public static int getOffsetBefore(CharSequence text, int offset) {
        if (offset == 0)
            return 0;
        if (offset == 1)
            return 0;

        char c = text.charAt(offset - 1);

        if (c >= '\uDC00' && c <= '\uDFFF') {
            char c1 = text.charAt(offset - 2);

            if (c1 >= '\uD800' && c1 <= '\uDBFF')
                offset -= 2;
            else
                offset -= 1;
        } else {
            offset -= 1;
        }

        if (text instanceof Spanned) {
            ReplacementSpan[] spans = ((Spanned) text).getSpans(offset, offset,
                                                       ReplacementSpan.class);

            for (int i = 0; i < spans.length; i++) {
                int start = ((Spanned) text).getSpanStart(spans[i]);
                int end = ((Spanned) text).getSpanEnd(spans[i]);

                if (start < offset && end > offset)
                    offset = start;
            }
        }

        return offset;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.037 -0500", hash_original_method = "26C887800914BB31A926D9FDB5C01860", hash_generated_method = "266FDB3740A1FA44CD245953DADFF893")
    
public static int getOffsetAfter(CharSequence text, int offset) {
        int len = text.length();

        if (offset == len)
            return len;
        if (offset == len - 1)
            return len;

        char c = text.charAt(offset);

        if (c >= '\uD800' && c <= '\uDBFF') {
            char c1 = text.charAt(offset + 1);

            if (c1 >= '\uDC00' && c1 <= '\uDFFF')
                offset += 2;
            else
                offset += 1;
        } else {
            offset += 1;
        }

        if (text instanceof Spanned) {
            ReplacementSpan[] spans = ((Spanned) text).getSpans(offset, offset,
                                                       ReplacementSpan.class);

            for (int i = 0; i < spans.length; i++) {
                int start = ((Spanned) text).getSpanStart(spans[i]);
                int end = ((Spanned) text).getSpanEnd(spans[i]);

                if (start < offset && end > offset)
                    offset = end;
            }
        }

        return offset;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.040 -0500", hash_original_method = "45D562325073C8296B6163D6C6A7113A", hash_generated_method = "98EC5C3C3BF97DA57F4A1992BAC0B17A")
    
private static void readSpan(Parcel p, Spannable sp, Object o) {
        sp.setSpan(o, p.readInt(), p.readInt(), p.readInt());
    }

    /**
     * Copies the spans from the region <code>start...end</code> in
     * <code>source</code> to the region
     * <code>destoff...destoff+end-start</code> in <code>dest</code>.
     * Spans in <code>source</code> that begin before <code>start</code>
     * or end after <code>end</code> but overlap this range are trimmed
     * as if they began at <code>start</code> or ended at <code>end</code>.
     *
     * @throws IndexOutOfBoundsException if any of the copied spans
     * are out of range in <code>dest</code>.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.043 -0500", hash_original_method = "8957741676B2512029B5EB0ADA41C6A3", hash_generated_method = "E2BCCB361B1569E7D40583CB780B992D")
    
public static void copySpansFrom(Spanned source, int start, int end,
                                     Class kind,
                                     Spannable dest, int destoff) {
        if (kind == null) {
            kind = Object.class;
        }

        Object[] spans = source.getSpans(start, end, kind);

        for (int i = 0; i < spans.length; i++) {
            int st = source.getSpanStart(spans[i]);
            int en = source.getSpanEnd(spans[i]);
            int fl = source.getSpanFlags(spans[i]);

            if (st < start)
                st = start;
            if (en > end)
                en = end;

            dest.setSpan(spans[i], st - start + destoff, en - start + destoff,
                         fl);
        }
    }

    /**
     * Returns the original text if it fits in the specified width
     * given the properties of the specified Paint,
     * or, if it does not fit, a truncated
     * copy with ellipsis character added at the specified edge or center.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.051 -0500", hash_original_method = "755117BF28A98A34E426C069131BF3F2", hash_generated_method = "5E1601C862F90FD428B4BEEFEB8E8261")
    
public static CharSequence ellipsize(CharSequence text,
                                         TextPaint p,
                                         float avail, TruncateAt where) {
        return ellipsize(text, p, avail, where, false, null);
    }

    /**
     * Returns the original text if it fits in the specified width
     * given the properties of the specified Paint,
     * or, if it does not fit, a copy with ellipsis character added
     * at the specified edge or center.
     * If <code>preserveLength</code> is specified, the returned copy
     * will be padded with zero-width spaces to preserve the original
     * length and offsets instead of truncating.
     * If <code>callback</code> is non-null, it will be called to
     * report the start and end of the ellipsized range.  TextDirection
     * is determined by the first strong directional character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.054 -0500", hash_original_method = "6B56F2B23D887DEA2B6EDA4226F2B3C1", hash_generated_method = "C929AC7580AA0B8AFE3ED74A46D9F5E0")
    
public static CharSequence ellipsize(CharSequence text,
                                         TextPaint paint,
                                         float avail, TruncateAt where,
                                         boolean preserveLength,
                                         EllipsizeCallback callback) {
        return ellipsize(text, paint, avail, where, preserveLength, callback,
                TextDirectionHeuristics.FIRSTSTRONG_LTR,
                (where == TruncateAt.END_SMALL) ? ELLIPSIS_TWO_DOTS : ELLIPSIS_NORMAL);
    }

    /**
     * Returns the original text if it fits in the specified width
     * given the properties of the specified Paint,
     * or, if it does not fit, a copy with ellipsis character added
     * at the specified edge or center.
     * If <code>preserveLength</code> is specified, the returned copy
     * will be padded with zero-width spaces to preserve the original
     * length and offsets instead of truncating.
     * If <code>callback</code> is non-null, it will be called to
     * report the start and end of the ellipsized range.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.058 -0500", hash_original_method = "EC6A2CB84C9440D856B93113234AABD2", hash_generated_method = "D92C52A5B35737F1390790630BE81A3E")
    
public static CharSequence ellipsize(CharSequence text,
            TextPaint paint,
            float avail, TruncateAt where,
            boolean preserveLength,
            EllipsizeCallback callback,
            TextDirectionHeuristic textDir, String ellipsis) {

        int len = text.length();

        MeasuredText mt = MeasuredText.obtain();
        try {
            float width = setPara(mt, paint, text, 0, text.length(), textDir);

            if (width <= avail) {
                if (callback != null) {
                    callback.ellipsized(0, 0);
                }

                return text;
            }

            // XXX assumes ellipsis string does not require shaping and
            // is unaffected by style
            float ellipsiswid = paint.measureText(ellipsis);
            avail -= ellipsiswid;

            int left = 0;
            int right = len;
            if (avail < 0) {
                // it all goes
            } else if (where == TruncateAt.START) {
                right = len - mt.breakText(0, len, false, avail);
            } else if (where == TruncateAt.END || where == TruncateAt.END_SMALL) {
                left = mt.breakText(0, len, true, avail);
            } else {
                right = len - mt.breakText(0, len, false, avail / 2);
                avail -= mt.measure(right, len);
                left = mt.breakText(0, right, true, avail);
            }

            if (callback != null) {
                callback.ellipsized(left, right);
            }

            char[] buf = mt.mChars;
            Spanned sp = text instanceof Spanned ? (Spanned) text : null;

            int remaining = len - (right - left);
            if (preserveLength) {
                if (remaining > 0) { // else eliminate the ellipsis too
                    buf[left++] = ellipsis.charAt(0);
                }
                for (int i = left; i < right; i++) {
                    buf[i] = ZWNBS_CHAR;
                }
                String s = new String(buf, 0, len);
                if (sp == null) {
                    return s;
                }
                SpannableString ss = new SpannableString(s);
                copySpansFrom(sp, 0, len, Object.class, ss, 0);
                return ss;
            }

            if (remaining == 0) {
                return "";
            }

            if (sp == null) {
                StringBuilder sb = new StringBuilder(remaining + ellipsis.length());
                sb.append(buf, 0, left);
                sb.append(ellipsis);
                sb.append(buf, right, len - right);
                return sb.toString();
            }

            SpannableStringBuilder ssb = new SpannableStringBuilder();
            ssb.append(text, 0, left);
            ssb.append(ellipsis);
            ssb.append(text, right, len);
            return ssb;
        } finally {
            MeasuredText.recycle(mt);
        }
    }

    /**
     * Converts a CharSequence of the comma-separated form "Andy, Bob,
     * Charles, David" that is too wide to fit into the specified width
     * into one like "Andy, Bob, 2 more".
     *
     * @param text the text to truncate
     * @param p the Paint with which to measure the text
     * @param avail the horizontal width available for the text
     * @param oneMore the string for "1 more" in the current locale
     * @param more the string for "%d more" in the current locale
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.061 -0500", hash_original_method = "F1EFDFAB351B67E053FAADF2166CDCC3", hash_generated_method = "6524A76625F825359D2A3A2B39201E31")
    
public static CharSequence commaEllipsize(CharSequence text,
                                              TextPaint p, float avail,
                                              String oneMore,
                                              String more) {
        return commaEllipsize(text, p, avail, oneMore, more,
                TextDirectionHeuristics.FIRSTSTRONG_LTR);
    }

    /**
     * @hide
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.064 -0500", hash_original_method = "0E3B019F0CF7F9AC0F531B04D4677D37", hash_generated_method = "CCF8FB93E2AF1E9E6C010C8AAF92FEB4")
    
public static CharSequence commaEllipsize(CharSequence text, TextPaint p,
         float avail, String oneMore, String more, TextDirectionHeuristic textDir) {

        MeasuredText mt = MeasuredText.obtain();
        try {
            int len = text.length();
            float width = setPara(mt, p, text, 0, len, textDir);
            if (width <= avail) {
                return text;
            }

            char[] buf = mt.mChars;

            int commaCount = 0;
            for (int i = 0; i < len; i++) {
                if (buf[i] == ',') {
                    commaCount++;
                }
            }

            int remaining = commaCount + 1;

            int ok = 0;
            String okFormat = "";

            int w = 0;
            int count = 0;
            float[] widths = mt.mWidths;

            MeasuredText tempMt = MeasuredText.obtain();
            for (int i = 0; i < len; i++) {
                w += widths[i];

                if (buf[i] == ',') {
                    count++;

                    String format;
                    // XXX should not insert spaces, should be part of string
                    // XXX should use plural rules and not assume English plurals
                    if (--remaining == 1) {
                        format = " " + oneMore;
                    } else {
                        format = " " + String.format(more, remaining);
                    }

                    // XXX this is probably ok, but need to look at it more
                    tempMt.setPara(format, 0, format.length(), textDir);
                    float moreWid = tempMt.addStyleRun(p, tempMt.mLen, null);

                    if (w + moreWid <= avail) {
                        ok = i + 1;
                        okFormat = format;
                    }
                }
            }
            MeasuredText.recycle(tempMt);

            SpannableStringBuilder out = new SpannableStringBuilder(okFormat);
            out.insert(0, text, 0, ok);
            return out;
        } finally {
            MeasuredText.recycle(mt);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.069 -0500", hash_original_method = "F470043619889DFEECBE932B4072D13A", hash_generated_method = "366D8FF7DE24403331AEBF36D1DAF5E3")
    
private static float setPara(MeasuredText mt, TextPaint paint,
            CharSequence text, int start, int end, TextDirectionHeuristic textDir) {

        mt.setPara(text, start, end, textDir);

        float width;
        Spanned sp = text instanceof Spanned ? (Spanned) text : null;
        int len = end - start;
        if (sp == null) {
            width = mt.addStyleRun(paint, len, null);
        } else {
            width = 0;
            int spanEnd;
            for (int spanStart = 0; spanStart < len; spanStart = spanEnd) {
                spanEnd = sp.nextSpanTransition(spanStart, len,
                        MetricAffectingSpan.class);
                MetricAffectingSpan[] spans = sp.getSpans(
                        spanStart, spanEnd, MetricAffectingSpan.class);
                spans = TextUtils.removeEmptySpans(spans, sp, MetricAffectingSpan.class);
                width += mt.addStyleRun(paint, spans, spanEnd - spanStart, null);
            }
        }

        return width;
    }

    /* package */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.074 -0500", hash_original_method = "3B0290B962B70D4426A36B25A2A84ADD", hash_generated_method = "37C3AEE0D1A41DC464712EFD7E57574D")
    
static boolean doesNotNeedBidi(CharSequence s, int start, int end) {
        for (int i = start; i < end; i++) {
            if (s.charAt(i) >= FIRST_RIGHT_TO_LEFT) {
                return false;
            }
        }
        return true;
    }

    /* package */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.077 -0500", hash_original_method = "057EA90B22F78FA618CCAE9B4CC3EB9F", hash_generated_method = "2B29807F77C2228AE7E287222667F3BB")
    
static boolean doesNotNeedBidi(char[] text, int start, int len) {
        for (int i = start, e = i + len; i < e; i++) {
            if (text[i] >= FIRST_RIGHT_TO_LEFT) {
                return false;
            }
        }
        return true;
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.079 -0500", hash_original_method = "724D3ECD749CFFB2830BA18321E72A55", hash_generated_method = "FEC8CC1820CE2BC46DD07421EAA048AC")
    
static char[] obtain(int len) {
        char[] buf;

        synchronized (sLock) {
            buf = sTemp;
            sTemp = null;
        }

        if (buf == null || buf.length < len)
            buf = new char[ArrayUtils.idealCharArraySize(len)];

        return buf;
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.082 -0500", hash_original_method = "35D8C7413AE72E3FBC6ED6BF63BDBAC7", hash_generated_method = "D870E1DCBA7DEFF27E1C10F2AD8B89B0")
    
static void recycle(char[] temp) {
        if (temp.length > 1000)
            return;

        synchronized (sLock) {
            sTemp = temp;
        }
    }

    /**
     * Html-encode the string.
     * @param s the string to be encoded
     * @return the encoded string
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.085 -0500", hash_original_method = "8B7144A918649FDB8BF62121E595E8DB", hash_generated_method = "754F2C23B97790CE62FD2FD0C262EC70")
    
public static String htmlEncode(String s) {
        StringBuilder sb = new StringBuilder();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            switch (c) {
            case '<':
                sb.append("&lt;"); //$NON-NLS-1$
                break;
            case '>':
                sb.append("&gt;"); //$NON-NLS-1$
                break;
            case '&':
                sb.append("&amp;"); //$NON-NLS-1$
                break;
            case '\'':
                sb.append("&apos;"); //$NON-NLS-1$
                break;
            case '"':
                sb.append("&quot;"); //$NON-NLS-1$
                break;
            default:
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Returns a CharSequence concatenating the specified CharSequences,
     * retaining their spans if any.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.088 -0500", hash_original_method = "3D20E7CFBF69AD3A80541C9D5FB744D6", hash_generated_method = "D63F0AE9ACC16DDD24B1151887DD460B")
    
public static CharSequence concat(CharSequence... text) {
        if (text.length == 0) {
            return "";
        }

        if (text.length == 1) {
            return text[0];
        }

        boolean spanned = false;
        for (int i = 0; i < text.length; i++) {
            if (text[i] instanceof Spanned) {
                spanned = true;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length; i++) {
            sb.append(text[i]);
        }

        if (!spanned) {
            return sb.toString();
        }

        SpannableString ss = new SpannableString(sb);
        int off = 0;
        for (int i = 0; i < text.length; i++) {
            int len = text[i].length();

            if (text[i] instanceof Spanned) {
                copySpansFrom((Spanned) text[i], 0, len, Object.class, ss, off);
            }

            off += len;
        }

        return new SpannedString(ss);
    }

    /**
     * Returns whether the given CharSequence contains any printable characters.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.091 -0500", hash_original_method = "ADA62A66172DE21069B5A4445E7922D9", hash_generated_method = "9CAED34042B302532BA487BEE4160699")
    
public static boolean isGraphic(CharSequence str) {
        final int len = str.length();
        for (int i=0; i<len; i++) {
            int gc = Character.getType(str.charAt(i));
            if (gc != Character.CONTROL
                    && gc != Character.FORMAT
                    && gc != Character.SURROGATE
                    && gc != Character.UNASSIGNED
                    && gc != Character.LINE_SEPARATOR
                    && gc != Character.PARAGRAPH_SEPARATOR
                    && gc != Character.SPACE_SEPARATOR) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns whether this character is a printable character.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.094 -0500", hash_original_method = "0CFF4A7A331DD9A6D6EBBEEED18C81AF", hash_generated_method = "CA262A3E83D9383D017F6AEF5D193A09")
    
public static boolean isGraphic(char c) {
        int gc = Character.getType(c);
        return     gc != Character.CONTROL
                && gc != Character.FORMAT
                && gc != Character.SURROGATE
                && gc != Character.UNASSIGNED
                && gc != Character.LINE_SEPARATOR
                && gc != Character.PARAGRAPH_SEPARATOR
                && gc != Character.SPACE_SEPARATOR;
    }

    /**
     * Returns whether the given CharSequence contains only digits.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.098 -0500", hash_original_method = "38604D56402004A8D37D280CF149D3A8", hash_generated_method = "16141365812CE98C9D78BECC3192FC5D")
    
public static boolean isDigitsOnly(CharSequence str) {
        final int len = str.length();
        for (int i = 0; i < len; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.101 -0500", hash_original_method = "464A3C1D84D523DE3DB48BA565E92C86", hash_generated_method = "FE683171E39ED2EA4DDF3185EAFF1EC5")
    
public static boolean isPrintableAscii(final char c) {
        final int asciiFirst = 0x20;
        final int asciiLast = 0x7E;  // included
        return (asciiFirst <= c && c <= asciiLast) || c == '\r' || c == '\n';
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.103 -0500", hash_original_method = "17A9C9BCBC86263A481E4580350BC4F1", hash_generated_method = "4BA15A26F2EFC4279B33EB51918CE521")
    
public static boolean isPrintableAsciiOnly(final CharSequence str) {
        final int len = str.length();
        for (int i = 0; i < len; i++) {
            if (!isPrintableAscii(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determine what caps mode should be in effect at the current offset in
     * the text.  Only the mode bits set in <var>reqModes</var> will be
     * checked.  Note that the caps mode flags here are explicitly defined
     * to match those in {@link InputType}.
     *
     * @param cs The text that should be checked for caps modes.
     * @param off Location in the text at which to check.
     * @param reqModes The modes to be checked: may be any combination of
     * {@link #CAP_MODE_CHARACTERS}, {@link #CAP_MODE_WORDS}, and
     * {@link #CAP_MODE_SENTENCES}.
     *
     * @return Returns the actual capitalization modes that can be in effect
     * at the current position, which is any combination of
     * {@link #CAP_MODE_CHARACTERS}, {@link #CAP_MODE_WORDS}, and
     * {@link #CAP_MODE_SENTENCES}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.115 -0500", hash_original_method = "C94484EC168BB2A014852EC30CF05C72", hash_generated_method = "DC3112F5D870C4D056CBEFCD7C221D12")
    
public static int getCapsMode(CharSequence cs, int off, int reqModes) {
        if (off < 0) {
            return 0;
        }

        int i;
        char c;
        int mode = 0;

        if ((reqModes&CAP_MODE_CHARACTERS) != 0) {
            mode |= CAP_MODE_CHARACTERS;
        }
        if ((reqModes&(CAP_MODE_WORDS|CAP_MODE_SENTENCES)) == 0) {
            return mode;
        }

        // Back over allowed opening punctuation.

        for (i = off; i > 0; i--) {
            c = cs.charAt(i - 1);

            if (c != '"' && c != '\'' &&
                Character.getType(c) != Character.START_PUNCTUATION) {
                break;
            }
        }

        // Start of paragraph, with optional whitespace.

        int j = i;
        while (j > 0 && ((c = cs.charAt(j - 1)) == ' ' || c == '\t')) {
            j--;
        }
        if (j == 0 || cs.charAt(j - 1) == '\n') {
            return mode | CAP_MODE_WORDS;
        }

        // Or start of word if we are that style.

        if ((reqModes&CAP_MODE_SENTENCES) == 0) {
            if (i != j) mode |= CAP_MODE_WORDS;
            return mode;
        }

        // There must be a space if not the start of paragraph.

        if (i == j) {
            return mode;
        }

        // Back over allowed closing punctuation.

        for (; j > 0; j--) {
            c = cs.charAt(j - 1);

            if (c != '"' && c != '\'' &&
                Character.getType(c) != Character.END_PUNCTUATION) {
                break;
            }
        }

        if (j > 0) {
            c = cs.charAt(j - 1);

            if (c == '.' || c == '?' || c == '!') {
                // Do not capitalize if the word ends with a period but
                // also contains a period, in which case it is an abbreviation.

                if (c == '.') {
                    for (int k = j - 2; k >= 0; k--) {
                        c = cs.charAt(k);

                        if (c == '.') {
                            return mode;
                        }

                        if (!Character.isLetter(c)) {
                            break;
                        }
                    }
                }

                return mode | CAP_MODE_SENTENCES;
            }
        }

        return mode;
    }

    /**
     * Does a comma-delimited list 'delimitedString' contain a certain item?
     * (without allocating memory)
     *
     * @hide
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.118 -0500", hash_original_method = "D4F4B6F2CF36AAFF165E53C1B7992C6B", hash_generated_method = "C07FE1AF9C1CFC270AB3A0317ED22A73")
    
public static boolean delimitedStringContains(
            String delimitedString, char delimiter, String item) {
        if (isEmpty(delimitedString) || isEmpty(item)) {
            return false;
        }
        int pos = -1;
        int length = delimitedString.length();
        while ((pos = delimitedString.indexOf(item, pos + 1)) != -1) {
            if (pos > 0 && delimitedString.charAt(pos - 1) != delimiter) {
                continue;
            }
            int expectedDelimiterPos = pos + item.length();
            if (expectedDelimiterPos == length) {
                // Match at end of string.
                return true;
            }
            if (delimitedString.charAt(expectedDelimiterPos) == delimiter) {
                return true;
            }
        }
        return false;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @SuppressWarnings("unchecked")
    public static <T> T[] removeEmptySpans(T[] spans, Spanned spanned, Class<T> klass) {
    	T[] retVal;
        T[] copy = null;
        int count = 0;
        for (int i = 0; i < spans.length; i++) {
            final T span = spans[i];
            final int start = spanned.getSpanStart(span);
            final int end = spanned.getSpanEnd(span);
            if (start == end) {
                if (copy == null) {
                    copy = (T[]) Array.newInstance(klass, spans.length - 1);
                    System.arraycopy(spans, 0, copy, 0, i);
                    count = i;
                }
            } else {
                if (copy != null) {
                    copy[count] = span;
                    count++;
                }
            }
        }
        if (copy != null) {
            T[] result = (T[]) Array.newInstance(klass, count);
            System.arraycopy(copy, 0, result, 0, count);
            retVal = result;
        } else {
            retVal = spans;
        }
        retVal.addTaint(spans[0].getTaint());
        retVal.addTaint(spanned.getTaint());
        retVal.addTaint(klass.getTaint());
        return retVal;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.941 -0500", hash_original_field = "AB939312FE1CD11FB90CA31AC93D8BE7", hash_generated_field = "BA8DFB6D0520256A7126F71E63EB2E8D")

    public static final int ALIGNMENT_SPAN = 1;
    
    public static class SimpleStringSplitter implements StringSplitter, Iterator<String> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.870 -0500", hash_original_field = "0DD8A30A5B66E3389BB7F1641026A732", hash_generated_field = "C0B8B41E10B6EC8767D645F51D421276")

        private String mString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.873 -0500", hash_original_field = "D44B90B20D3F53591F6F45FA4216701F", hash_generated_field = "0A6C459A64106B37BA6AD60C631D4A07")

        private char mDelimiter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.875 -0500", hash_original_field = "4EE731A4D843C99A130C2ED24E5FDDEA", hash_generated_field = "D614AE7D1AAE0276EA05A974DCBF0210")

        private int mPosition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.877 -0500", hash_original_field = "FC3D477E7B6A4ACE9A379E6E41129BD1", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

        private int mLength;

        /**
         * Initializes the splitter. setString may be called later.
         * @param delimiter the delimeter on which to split
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.880 -0500", hash_original_method = "6A654BA34A10AA2B42750EC65A3F679B", hash_generated_method = "16716B2C616858C4F227FCB64679DAF8")
        
public SimpleStringSplitter(char delimiter) {
            mDelimiter = delimiter;
        }

        /**
         * Sets the string to split
         * @param string the string to split
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.883 -0500", hash_original_method = "6D8C9957AC1A2476C265420CD8A2E354", hash_generated_method = "72D29C1590426FCCCF674EC48B89F5FB")
        
public void setString(String string) {
            mString = string;
            mPosition = 0;
            mLength = mString.length();
        }
        
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        public Iterator iterator() {
            return this;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.889 -0500", hash_original_method = "675B2012EE41806104DFB06FA586494D", hash_generated_method = "6754DEE2DF63C57E8C400DF64686FDA8")
        
public boolean hasNext() {
            return mPosition < mLength;
        }
        
        @DSComment("From safe class list")
        @DSSafe(DSCat.DATA_STRUCTURE)
        public String next() {
        //public Object next() {
        	/*
            int end = mString.indexOf(mDelimiter, mPosition);
            if (end == -1) {
                end = mLength;
            }
            String nextString = mString.substring(mPosition, end);
            mPosition = end + 1; // Skip the delimiter.
            return nextString;
            */
        	return new String();
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.894 -0500", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "5B2A4852FF2684177E07742561C615C2")
        
public void remove() {
            throw new UnsupportedOperationException();
        }
        
    }
    
    private static class Reverser implements CharSequence, GetChars {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.931 -0500", hash_original_field = "EBB181D64752DA6F9BB9A9E1DB00BBD4", hash_generated_field = "1DB65A9625E780B230F7C604C99C0F5D")

        private CharSequence mSource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.934 -0500", hash_original_field = "83A19D93B82C07A79F54E265C2077EC6", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")

        private int mStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.936 -0500", hash_original_field = "6FAA56F5628A0F1DAAFED98EBDB1C99E", hash_generated_field = "EA295975CAF8E42F4C28A87EADB358DF")

        private int mEnd;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.915 -0500", hash_original_method = "BFBBE5A2171EAA5D387A9688FF38614C", hash_generated_method = "FC706F5A16DB4E220F5153B3F6495095")
        
public Reverser(CharSequence source, int start, int end) {
            mSource = source;
            mStart = start;
            mEnd = end;
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.918 -0500", hash_original_method = "7B7C0865096082EBDC6C915DBB65AA78", hash_generated_method = "8732E4B13C6B0C6FFDA4771F0D455861")
        
public int length() {
            return mEnd - mStart;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.920 -0500", hash_original_method = "D736D7B90470DFC8C923D4B5D62B4D1D", hash_generated_method = "AD56006EF135C03737EF8A0AA3AFFC1A")
        
public CharSequence subSequence(int start, int end) {
            char[] buf = new char[end - start];

            getChars(start, end, buf, 0);
            return new String(buf);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.923 -0500", hash_original_method = "814020AAFF189164368E5EE6B0F105D9", hash_generated_method = "8CE6BEDEE3C1DB727D6F5B17B1D94141")
        
@Override
        public String toString() {
            return subSequence(0, length()).toString();
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.925 -0500", hash_original_method = "54C9409C1585BDAF025F1FDAAC236D34", hash_generated_method = "284F9981F88BADBF1662D463E6BBD107")
        
public char charAt(int off) {
            return AndroidCharacter.getMirror(mSource.charAt(mEnd - 1 - off));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.928 -0500", hash_original_method = "81F95A724AC4812824CCEB8249CFBC9B", hash_generated_method = "96040FE774F6311EB4EB2D6A26F2A89C")
        
public void getChars(int start, int end, char[] dest, int destoff) {
            TextUtils.getChars(mSource, start + mStart, end + mStart,
                               dest, destoff);
            AndroidCharacter.mirror(dest, 0, end - start);

            int len = end - start;
            int n = (end - start) / 2;
            for (int i = 0; i < n; i++) {
                char tmp = dest[destoff + i];

                dest[destoff + i] = dest[destoff + len - i - 1];
                dest[destoff + len - i - 1] = tmp;
            }
        }
        
    }
    
    public enum TruncateAt {
        START,
        MIDDLE,
        END,
        MARQUEE,
        END_SMALL
    }
    
    public interface StringSplitter extends Iterable<String> {
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void setString(String string);
    }
    
    public interface EllipsizeCallback {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void ellipsized(int start, int end);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.944 -0500", hash_original_field = "7F34253C37BD6C61CA0FC47C32EDBF19", hash_generated_field = "0F4922FC1D49AD6ED7458917DE77E255")

    public static final int FOREGROUND_COLOR_SPAN = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.947 -0500", hash_original_field = "40923154318D002505E8C0CA89EC3004", hash_generated_field = "E2E9301952149239B2DC5281FA21717D")

    public static final int RELATIVE_SIZE_SPAN = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.949 -0500", hash_original_field = "2ADC6322FD0EB4500CD656094674F26C", hash_generated_field = "2B30E4E74FC895531F41B0EF85A388F7")

    public static final int SCALE_X_SPAN = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.952 -0500", hash_original_field = "9519B7346C9550B166AFFDCDA326AAAF", hash_generated_field = "A49DA21AC6F8AB9FF9A517D9F24D8664")

    public static final int STRIKETHROUGH_SPAN = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.956 -0500", hash_original_field = "C31B4DDAC18947122E910B95AF9DD1E4", hash_generated_field = "D38434536F32934C4FB5BB2C6FDD7928")

    public static final int UNDERLINE_SPAN = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.958 -0500", hash_original_field = "7BB7D76CB65F720F87DBA8C8CB8AFD6C", hash_generated_field = "FEA29A898CBC7C17B539313BF3E30C8F")

    public static final int STYLE_SPAN = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.961 -0500", hash_original_field = "FE37A821EC15E018CA1BBA08D2773E9A", hash_generated_field = "0025AA2DFF9F01340C338C9AD4D72F93")

    public static final int BULLET_SPAN = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.964 -0500", hash_original_field = "FAA370424D0B6D42A169B4E8EA2ECDBB", hash_generated_field = "BD39B1A247090B0040F706F0CF28D27C")

    public static final int QUOTE_SPAN = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.967 -0500", hash_original_field = "05F21C2979125F3B870E95516313A0A8", hash_generated_field = "29861EC0EB4FFDF405A517046B4C8855")

    public static final int LEADING_MARGIN_SPAN = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.969 -0500", hash_original_field = "39EC823D552E5779EF7F718B117320AB", hash_generated_field = "16935960E48347AF333B245161548468")

    public static final int URL_SPAN = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.972 -0500", hash_original_field = "134C2E5FEBBD86F0A3AC8CD84B268E1D", hash_generated_field = "08AB7660C5D13F050ACF8BE7DFD24FB3")

    public static final int BACKGROUND_COLOR_SPAN = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.975 -0500", hash_original_field = "57366ECCC0BB3DEDE93C56C1D1A0B077", hash_generated_field = "9F8207D72EAFAC4535DA84C850CDC8E7")

    public static final int TYPEFACE_SPAN = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.978 -0500", hash_original_field = "3652922E2DB57816D012BAB1123B03C0", hash_generated_field = "F465E900AB4D623C81F192800BB4D253")

    public static final int SUPERSCRIPT_SPAN = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.981 -0500", hash_original_field = "8C0BF01AB71E751FDFC02E724B7F45BF", hash_generated_field = "34AC1E3567EA7B7B6E651F80AA99ADD9")

    public static final int SUBSCRIPT_SPAN = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.984 -0500", hash_original_field = "3A846A46D4640DE931BD17545C8B47FE", hash_generated_field = "0AB2A7C92C439178B06E42F89BA4817D")

    public static final int ABSOLUTE_SIZE_SPAN = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.987 -0500", hash_original_field = "BF668AFA2BDB851F4DA9C481FC4FDAD9", hash_generated_field = "16ECDB8594B04E583AE9422487437AE9")

    public static final int TEXT_APPEARANCE_SPAN = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.989 -0500", hash_original_field = "7B1EED310C269F494CE796481BA3F99D", hash_generated_field = "243B5C37B09807E83CFAF009267F0366")

    public static final int ANNOTATION = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.993 -0500", hash_original_field = "18A6AD57D18569ACB6BEC928574D3D83", hash_generated_field = "0F5BE651337F08236DAE4F4895763BD7")

    public static final int SUGGESTION_SPAN = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.996 -0500", hash_original_field = "61CE214A3D4D271F17EA562A8A4BA030", hash_generated_field = "D0D29EC5EA2F85D8A355410E3D815A3E")

    public static final int SPELL_CHECK_SPAN = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.998 -0500", hash_original_field = "00E39E9F26A900FF980EAE42ACB9B90C", hash_generated_field = "CE7A458F9FC2A075D48E520238AABCC3")

    public static final int SUGGESTION_RANGE_SPAN = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.001 -0500", hash_original_field = "12B974DBB0DBB6A8F99EC667F6215243", hash_generated_field = "DF0FC51B4556E2572818C89584203638")

    public static final int EASY_EDIT_SPAN = 22;
    public static Parcelable.Creator<CharSequence> CHAR_SEQUENCE_CREATOR  = new MyCreator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.071 -0500", hash_original_field = "C43C06106F60684BB16151D66140BBB2", hash_generated_field = "C2F2F45019948F5515A5534F9B80EBF4")

    private static final char FIRST_RIGHT_TO_LEFT = '\u0590';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.106 -0500", hash_original_field = "8EB22B2BE0E3BE6ABB5842AAD1EFFF76", hash_generated_field = "7B66F2E8EDC72D450BE916BD40FCB1B1")

    public static final int CAP_MODE_CHARACTERS
            = InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.108 -0500", hash_original_field = "6631E91E6A3E9B6BB15D169C1268401F", hash_generated_field = "0E58216E9C917055D43665384085B275")

    public static final int CAP_MODE_WORDS
            = InputType.TYPE_TEXT_FLAG_CAP_WORDS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.111 -0500", hash_original_field = "7F2506C12F28B76FB4CC63C125B9F2EE", hash_generated_field = "85E1B4A2EC9624366A32ED1343061EC0")

    public static final int CAP_MODE_SENTENCES
            = InputType.TYPE_TEXT_FLAG_CAP_SENTENCES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.124 -0500", hash_original_field = "3892ABA92B7F95295E8CFDAE8B79791E", hash_generated_field = "E209496F9F2C9103A6260BCF69D3191B")

    private static Object sLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.127 -0500", hash_original_field = "55DA4B3993779389A3DF2C10AD0407DA", hash_generated_field = "D5B55575C53803B48B8DF0B1F8C65A25")

    private static char[] sTemp = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.130 -0500", hash_original_field = "DDEEF9E63F57AEA5B651583DF53FC3D6", hash_generated_field = "028F00C02112EDD5FB92F4223ED16EEC")

    private static String[] EMPTY_STRING_ARRAY = new String[]{};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.133 -0500", hash_original_field = "5BCF32C74E7F6DD458104DDE6684ED29", hash_generated_field = "6EF5025B69B9D168A5631B2819D5C1D0")

    private static final char ZWNBS_CHAR = '\uFEFF';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.136 -0500", hash_original_field = "2B45BAC771D34F88FC297809DB08191C", hash_generated_field = "A9B2DE4DB6FBCCC1E9139098336CF406")

    private static final String ELLIPSIS_NORMAL = Resources.getSystem().getString(
            R.string.ellipsis);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:06.138 -0500", hash_original_field = "E1240E33A9FE2880CEDE28ECA79021F4", hash_generated_field = "6E8AB6D76733F340318805625C3D4EC8")

    private static final String ELLIPSIS_TWO_DOTS = Resources.getSystem().getString(
            R.string.ellipsis_two_dots);

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:05.814 -0500", hash_original_method = "B02737FE3AF0C7262E7E1815816AFA38", hash_generated_method = "334E17B5C4AA54901502DF0104365421")
    
private TextUtils() { /* cannot be instantiated */ }
}

