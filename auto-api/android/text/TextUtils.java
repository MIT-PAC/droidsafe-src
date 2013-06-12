package android.text;

// Droidsafe Imports
import java.lang.reflect.Array;
// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;
import java.util.regex.Pattern;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.CharacterStyle;
import android.text.style.EasyEditSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ReplacementSpan;
import android.text.style.ScaleXSpan;
import android.text.style.SpellCheckSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuggestionRangeSpan;
import android.text.style.SuggestionSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.Printer;

import com.android.internal.R;
import com.android.internal.util.ArrayUtils;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;

public class TextUtils {
    public static final int ALIGNMENT_SPAN = 1;
    public static final int FOREGROUND_COLOR_SPAN = 2;
    public static final int RELATIVE_SIZE_SPAN = 3;
    public static final int SCALE_X_SPAN = 4;
    public static final int STRIKETHROUGH_SPAN = 5;
    public static final int UNDERLINE_SPAN = 6;
    public static final int STYLE_SPAN = 7;
    public static final int BULLET_SPAN = 8;
    public static final int QUOTE_SPAN = 9;
    public static final int LEADING_MARGIN_SPAN = 10;
    public static final int URL_SPAN = 11;
    public static final int BACKGROUND_COLOR_SPAN = 12;
    public static final int TYPEFACE_SPAN = 13;
    public static final int SUPERSCRIPT_SPAN = 14;
    public static final int SUBSCRIPT_SPAN = 15;
    public static final int ABSOLUTE_SIZE_SPAN = 16;
    public static final int TEXT_APPEARANCE_SPAN = 17;
    public static final int ANNOTATION = 18;
    public static final int SUGGESTION_SPAN = 19;
    public static final int SPELL_CHECK_SPAN = 20;
    public static final int SUGGESTION_RANGE_SPAN = 21;
    public static final int EASY_EDIT_SPAN = 22;
    public static final Parcelable.Creator<CharSequence> CHAR_SEQUENCE_CREATOR = new Parcelable.Creator<CharSequence>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.511 -0400", hash_original_method = "9ACEE99AC88FDD394854F98E1EFE5030", hash_generated_method = "417B73B5609B31DB241BCEFE47BC51D1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CharSequence createFromParcel(Parcel p) {
            dsTaint.addTaint(p.dsTaint);
            int kind;
            kind = p.readInt();
            String string;
            string = p.readString();
            SpannableString sp;
            sp = new SpannableString(string);
            {
                kind = p.readInt();
                //Begin case ALIGNMENT_SPAN 
                readSpan(p, sp, new AlignmentSpan.Standard(p));
                //End case ALIGNMENT_SPAN 
                //Begin case FOREGROUND_COLOR_SPAN 
                readSpan(p, sp, new ForegroundColorSpan(p));
                //End case FOREGROUND_COLOR_SPAN 
                //Begin case RELATIVE_SIZE_SPAN 
                readSpan(p, sp, new RelativeSizeSpan(p));
                //End case RELATIVE_SIZE_SPAN 
                //Begin case SCALE_X_SPAN 
                readSpan(p, sp, new ScaleXSpan(p));
                //End case SCALE_X_SPAN 
                //Begin case STRIKETHROUGH_SPAN 
                readSpan(p, sp, new StrikethroughSpan(p));
                //End case STRIKETHROUGH_SPAN 
                //Begin case UNDERLINE_SPAN 
                readSpan(p, sp, new UnderlineSpan(p));
                //End case UNDERLINE_SPAN 
                //Begin case STYLE_SPAN 
                readSpan(p, sp, new StyleSpan(p));
                //End case STYLE_SPAN 
                //Begin case BULLET_SPAN 
                readSpan(p, sp, new BulletSpan(p));
                //End case BULLET_SPAN 
                //Begin case QUOTE_SPAN 
                readSpan(p, sp, new QuoteSpan(p));
                //End case QUOTE_SPAN 
                //Begin case LEADING_MARGIN_SPAN 
                readSpan(p, sp, new LeadingMarginSpan.Standard(p));
                //End case LEADING_MARGIN_SPAN 
                //Begin case URL_SPAN 
                readSpan(p, sp, new URLSpan(p));
                //End case URL_SPAN 
                //Begin case BACKGROUND_COLOR_SPAN 
                readSpan(p, sp, new BackgroundColorSpan(p));
                //End case BACKGROUND_COLOR_SPAN 
                //Begin case TYPEFACE_SPAN 
                readSpan(p, sp, new TypefaceSpan(p));
                //End case TYPEFACE_SPAN 
                //Begin case SUPERSCRIPT_SPAN 
                readSpan(p, sp, new SuperscriptSpan(p));
                //End case SUPERSCRIPT_SPAN 
                //Begin case SUBSCRIPT_SPAN 
                readSpan(p, sp, new SubscriptSpan(p));
                //End case SUBSCRIPT_SPAN 
                //Begin case ABSOLUTE_SIZE_SPAN 
                readSpan(p, sp, new AbsoluteSizeSpan(p));
                //End case ABSOLUTE_SIZE_SPAN 
                //Begin case TEXT_APPEARANCE_SPAN 
                readSpan(p, sp, new TextAppearanceSpan(p));
                //End case TEXT_APPEARANCE_SPAN 
                //Begin case ANNOTATION 
                readSpan(p, sp, new Annotation(p));
                //End case ANNOTATION 
                //Begin case SUGGESTION_SPAN 
                readSpan(p, sp, new SuggestionSpan(p));
                //End case SUGGESTION_SPAN 
                //Begin case SPELL_CHECK_SPAN 
                readSpan(p, sp, new SpellCheckSpan(p));
                //End case SPELL_CHECK_SPAN 
                //Begin case SUGGESTION_RANGE_SPAN 
                readSpan(p, sp, new SuggestionRangeSpan(p));
                //End case SUGGESTION_RANGE_SPAN 
                //Begin case EASY_EDIT_SPAN 
                readSpan(p, sp, new EasyEditSpan());
                //End case EASY_EDIT_SPAN 
                //Begin case default 
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("bogus span encoding " + kind);
                //End case default 
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.511 -0400", hash_original_method = "F283C0C9D7FBE7C977B3511A473800E3", hash_generated_method = "434C8051971BD734E76DE5C4D02C4226")
        @DSModeled(DSC.SAFE)
        public CharSequence[] newArray(int size) {
            dsTaint.addTaint(size);
            CharSequence[] retVal = new CharSequence[1];
            retVal[0] = dsTaint.getTaintString();
            return retVal;
            // ---------- Original Method ----------
            //return new CharSequence[size];
        }

        
}; //Transformed anonymous class
    private static final char FIRST_RIGHT_TO_LEFT = '\u0590';
    public static final int CAP_MODE_CHARACTERS
            = InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS;
    public static final int CAP_MODE_WORDS
            = InputType.TYPE_TEXT_FLAG_CAP_WORDS;
    public static final int CAP_MODE_SENTENCES
            = InputType.TYPE_TEXT_FLAG_CAP_SENTENCES;
    private static Object sLock = new Object();
    private static char[] sTemp = null;
    private static String[] EMPTY_STRING_ARRAY = new String[]{};
    private static final char ZWNBS_CHAR = '\uFEFF';
    private static final String ELLIPSIS_NORMAL = Resources.getSystem().getString(
            R.string.ellipsis);
    private static final String ELLIPSIS_TWO_DOTS = Resources.getSystem().getString(
            R.string.ellipsis_two_dots);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.512 -0400", hash_original_method = "B02737FE3AF0C7262E7E1815816AFA38", hash_generated_method = "1B2F9D77A95C9C18EE4B7DE9C3D1E42F")
    @DSModeled(DSC.SAFE)
    private TextUtils() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.512 -0400", hash_original_method = "B6CD7F3C8D4B193FE534D4C38B1CB19E", hash_generated_method = "6A754CE326C1F91DCD6362C912467103")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.512 -0400", hash_original_method = "2B288D1C7C5C63AB74BA28EFC2864361", hash_generated_method = "8DFE0A7282F6A63B6F7767B113B8F488")
    public static int indexOf(CharSequence s, char ch) {
        return indexOf(s, ch, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.512 -0400", hash_original_method = "6B7A92B1181B966A44F83BF97D86A71F", hash_generated_method = "D701A239AF1BE6077A8716C4E83171B7")
    public static int indexOf(CharSequence s, char ch, int start) {
        Class<? extends CharSequence> c = s.getClass();
        if (c == String.class)
            return ((String) s).indexOf(ch, start);
        return indexOf(s, ch, start, s.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.512 -0400", hash_original_method = "544FCBC88320BB8F6A1660211014CB9B", hash_generated_method = "351510B1C18807C0B37D7F9C4129E3C4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.512 -0400", hash_original_method = "5BBDBA8EF1563B9DD5D1929C015065D1", hash_generated_method = "67AD6698E991A80A60281ADAC00BDF4A")
    public static int lastIndexOf(CharSequence s, char ch) {
        return lastIndexOf(s, ch, s.length() - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.512 -0400", hash_original_method = "4FA8A924B5587056C4ACB65EA303EF07", hash_generated_method = "4C637339EC9B0FD3CD103091B8C54618")
    public static int lastIndexOf(CharSequence s, char ch, int last) {
        Class<? extends CharSequence> c = s.getClass();
        if (c == String.class)
            return ((String) s).lastIndexOf(ch, last);
        return lastIndexOf(s, ch, 0, last);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.512 -0400", hash_original_method = "1ABC9B5C8394779C90EF8CC1F1AE5E2C", hash_generated_method = "97400C84F2C886AC62F14B07D8F33F30")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.512 -0400", hash_original_method = "552F02994CC4987C268BA730575E79CF", hash_generated_method = "E4083713F952915589A30CB5A8E482E2")
    public static int indexOf(CharSequence s, CharSequence needle) {
        return indexOf(s, needle, 0, s.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.512 -0400", hash_original_method = "9BACEDD2FEF7E129003580BFF523FE81", hash_generated_method = "6A64A926622D7920B3924F6E2148AA33")
    public static int indexOf(CharSequence s, CharSequence needle, int start) {
        return indexOf(s, needle, start, s.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.512 -0400", hash_original_method = "01F707FBADA596DCC00F547189098EC5", hash_generated_method = "C42C8263B6EC5846EAF86F575A406A90")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.513 -0400", hash_original_method = "89989795239EEDDAD38EDCA7AB441D22", hash_generated_method = "8ECB5A4BC8E9A4340709F3E826ADE6EB")
    public static boolean regionMatches(CharSequence one, int toffset,
                                        CharSequence two, int ooffset,
                                        int len) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.513 -0400", hash_original_method = "78DE9AEF4C2944726F3B95C9207900D6", hash_generated_method = "F8F3A460C76FF60A06B8FBCA096204C2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.513 -0400", hash_original_method = "8B31B2502E472EA787355492BFDF03AA", hash_generated_method = "5F9988717201F86C947DA332D70E1763")
    public static CharSequence join(Iterable<CharSequence> list) {
        final CharSequence delimiter = Resources.getSystem().getText(R.string.list_delimeter);
        return join(delimiter, list);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.513 -0400", hash_original_method = "30F8C3035802E985549014BC8C1FC857", hash_generated_method = "BCBB36CA6A56C6DC3005FD0730023358")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.513 -0400", hash_original_method = "DC7AF5364772F9FC890BC57B4AE1F82F", hash_generated_method = "7DEC1574CB917C477B50C58627F70E8E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.513 -0400", hash_original_method = "9706658E9A67690C95EF953ED2AFD2D4", hash_generated_method = "05FF8A488F3493254F9474270D9C6B5E")
    public static String[] split(String text, String expression) {
        if (text.length() == 0) {
            return EMPTY_STRING_ARRAY;
        } else {
            return text.split(expression, -1);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.513 -0400", hash_original_method = "EB884963B35B912D5FE47DBF808C36A9", hash_generated_method = "9200C2AED7C2BA6B9C658DA4FEBE62DD")
    public static String[] split(String text, Pattern pattern) {
        if (text.length() == 0) {
            return EMPTY_STRING_ARRAY;
        } else {
            return pattern.split(text, -1);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.513 -0400", hash_original_method = "D7DA1CF6D85F29139017BBA0640DB133", hash_generated_method = "5743ECD91F334EFD1208F9CE9706C38D")
    public static CharSequence stringOrSpannedString(CharSequence source) {
        if (source == null)
            return null;
        if (source instanceof SpannedString)
            return source;
        if (source instanceof Spanned)
            return new SpannedString(source);
        return source.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.513 -0400", hash_original_method = "87E1A34C0995DE779A857B80EB9CE27A", hash_generated_method = "39933546042860768A7564846E63D2DC")
    public static boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.513 -0400", hash_original_method = "D991523FF91558FCD5D3B3A348459B48", hash_generated_method = "2CD7D9E9B1F38D7B06B7FD27675F7363")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.513 -0400", hash_original_method = "67A0EA29212518310C8922834323A122", hash_generated_method = "B9067C793230A53D0E146B8780FE11D6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.513 -0400", hash_original_method = "98F930B270648698A021909A60BE17AD", hash_generated_method = "197399D3D66518E7F26D8A6C6C5A4650")
    public static CharSequence getReverse(CharSequence source,
                                          int start, int end) {
        return new Reverser(source, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.513 -0400", hash_original_method = "3AB99D64EE2B077E31675DCB4E265A32", hash_generated_method = "E21DC82BFB774638168F9D73668C66DF")
    public static void writeToParcel(CharSequence cs, Parcel p,
            int parcelableFlags) {
        if (cs instanceof Spanned) {
            p.writeInt(0);
            p.writeString(cs.toString());
            Spanned sp = (Spanned) cs;
            Object[] os = sp.getSpans(0, cs.length(), Object.class);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.514 -0400", hash_original_method = "9B5ED0499519A130DB4D8B61A9E846A6", hash_generated_method = "B9947CF52F3AFB4C45495453EDAD6B86")
    private static void writeWhere(Parcel p, Spanned sp, Object o) {
        p.writeInt(sp.getSpanStart(o));
        p.writeInt(sp.getSpanEnd(o));
        p.writeInt(sp.getSpanFlags(o));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.514 -0400", hash_original_method = "BE480EAEA78D9AC942A5A115EAA0FF97", hash_generated_method = "9366628B164F37B7BDE9EACCD00BDE22")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.514 -0400", hash_original_method = "7F42862E06E0A79232E639A8406A0D91", hash_generated_method = "0B16D69A787C82725742FAD6D22048F8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.514 -0400", hash_original_method = "1FFDFAC4EC60B3BFF5CF0C29A1CCA4F1", hash_generated_method = "CA5A85C2D748B2616FF0E48EF38E4117")
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
        }
        return ssb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.514 -0400", hash_original_method = "8161B498320C5E1EE65901C7324FD829", hash_generated_method = "F1C499A6FEA9F782BC1630BFA1CC4934")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.514 -0400", hash_original_method = "26C887800914BB31A926D9FDB5C01860", hash_generated_method = "266FDB3740A1FA44CD245953DADFF893")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.514 -0400", hash_original_method = "45D562325073C8296B6163D6C6A7113A", hash_generated_method = "98EC5C3C3BF97DA57F4A1992BAC0B17A")
    private static void readSpan(Parcel p, Spannable sp, Object o) {
        sp.setSpan(o, p.readInt(), p.readInt(), p.readInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.514 -0400", hash_original_method = "8957741676B2512029B5EB0ADA41C6A3", hash_generated_method = "E2BCCB361B1569E7D40583CB780B992D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.514 -0400", hash_original_method = "755117BF28A98A34E426C069131BF3F2", hash_generated_method = "5E1601C862F90FD428B4BEEFEB8E8261")
    public static CharSequence ellipsize(CharSequence text,
                                         TextPaint p,
                                         float avail, TruncateAt where) {
        return ellipsize(text, p, avail, where, false, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.514 -0400", hash_original_method = "6B56F2B23D887DEA2B6EDA4226F2B3C1", hash_generated_method = "C929AC7580AA0B8AFE3ED74A46D9F5E0")
    public static CharSequence ellipsize(CharSequence text,
                                         TextPaint paint,
                                         float avail, TruncateAt where,
                                         boolean preserveLength,
                                         EllipsizeCallback callback) {
        return ellipsize(text, paint, avail, where, preserveLength, callback,
                TextDirectionHeuristics.FIRSTSTRONG_LTR,
                (where == TruncateAt.END_SMALL) ? ELLIPSIS_TWO_DOTS : ELLIPSIS_NORMAL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.515 -0400", hash_original_method = "EC6A2CB84C9440D856B93113234AABD2", hash_generated_method = "923577D4D59E815BBB9C9DBB317014BD")
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
            float ellipsiswid = paint.measureText(ellipsis);
            avail -= ellipsiswid;
            int left = 0;
            int right = len;
            if (avail < 0) {
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
                if (remaining > 0) { 
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.515 -0400", hash_original_method = "F1EFDFAB351B67E053FAADF2166CDCC3", hash_generated_method = "6524A76625F825359D2A3A2B39201E31")
    public static CharSequence commaEllipsize(CharSequence text,
                                              TextPaint p, float avail,
                                              String oneMore,
                                              String more) {
        return commaEllipsize(text, p, avail, oneMore, more,
                TextDirectionHeuristics.FIRSTSTRONG_LTR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.515 -0400", hash_original_method = "0E3B019F0CF7F9AC0F531B04D4677D37", hash_generated_method = "839966C62EE1612DB1B162E7C6BF6A90")
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
                    if (--remaining == 1) {
                        format = " " + oneMore;
                    } else {
                        format = " " + String.format(more, remaining);
                    }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.515 -0400", hash_original_method = "F470043619889DFEECBE932B4072D13A", hash_generated_method = "366D8FF7DE24403331AEBF36D1DAF5E3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.515 -0400", hash_original_method = "3B0290B962B70D4426A36B25A2A84ADD", hash_generated_method = "37C3AEE0D1A41DC464712EFD7E57574D")
    static boolean doesNotNeedBidi(CharSequence s, int start, int end) {
        for (int i = start; i < end; i++) {
            if (s.charAt(i) >= FIRST_RIGHT_TO_LEFT) {
                return false;
            }
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.515 -0400", hash_original_method = "057EA90B22F78FA618CCAE9B4CC3EB9F", hash_generated_method = "2B29807F77C2228AE7E287222667F3BB")
    static boolean doesNotNeedBidi(char[] text, int start, int len) {
        for (int i = start, e = i + len; i < e; i++) {
            if (text[i] >= FIRST_RIGHT_TO_LEFT) {
                return false;
            }
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.515 -0400", hash_original_method = "724D3ECD749CFFB2830BA18321E72A55", hash_generated_method = "FEC8CC1820CE2BC46DD07421EAA048AC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.515 -0400", hash_original_method = "35D8C7413AE72E3FBC6ED6BF63BDBAC7", hash_generated_method = "D870E1DCBA7DEFF27E1C10F2AD8B89B0")
    static void recycle(char[] temp) {
        if (temp.length > 1000)
            return;
        synchronized (sLock) {
            sTemp = temp;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.516 -0400", hash_original_method = "11748C20547E1BDC2B9C0BC890EBDA17", hash_generated_method = "892A36106B31FAA807E4AAA89BE11BBD")
    public static String htmlEncode(String s) {
        StringBuilder sb = new StringBuilder();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            switch (c) {
            case '<':
                sb.append("&lt;"); 
                break;
            case '>':
                sb.append("&gt;"); 
                break;
            case '&':
                sb.append("&amp;"); 
                break;
            case '\'':
                sb.append("&#39;"); 
                break;
            case '"':
                sb.append("&quot;"); 
                break;
            default:
                sb.append(c);
            }
        }
        return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.516 -0400", hash_original_method = "3D20E7CFBF69AD3A80541C9D5FB744D6", hash_generated_method = "D63F0AE9ACC16DDD24B1151887DD460B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.516 -0400", hash_original_method = "ADA62A66172DE21069B5A4445E7922D9", hash_generated_method = "9CAED34042B302532BA487BEE4160699")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.516 -0400", hash_original_method = "0CFF4A7A331DD9A6D6EBBEEED18C81AF", hash_generated_method = "CA262A3E83D9383D017F6AEF5D193A09")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.516 -0400", hash_original_method = "38604D56402004A8D37D280CF149D3A8", hash_generated_method = "16141365812CE98C9D78BECC3192FC5D")
    public static boolean isDigitsOnly(CharSequence str) {
        final int len = str.length();
        for (int i = 0; i < len; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.516 -0400", hash_original_method = "464A3C1D84D523DE3DB48BA565E92C86", hash_generated_method = "74B896D0CCA073E6071DFAEDD95E6ACD")
    public static boolean isPrintableAscii(final char c) {
        final int asciiFirst = 0x20;
        final int asciiLast = 0x7E;
        return (asciiFirst <= c && c <= asciiLast) || c == '\r' || c == '\n';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.516 -0400", hash_original_method = "17A9C9BCBC86263A481E4580350BC4F1", hash_generated_method = "4BA15A26F2EFC4279B33EB51918CE521")
    public static boolean isPrintableAsciiOnly(final CharSequence str) {
        final int len = str.length();
        for (int i = 0; i < len; i++) {
            if (!isPrintableAscii(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.516 -0400", hash_original_method = "C94484EC168BB2A014852EC30CF05C72", hash_generated_method = "ABF5E7781CAC704FD0D6092A569B850F")
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
        for (i = off; i > 0; i--) {
            c = cs.charAt(i - 1);
            if (c != '"' && c != '\'' &&
                Character.getType(c) != Character.START_PUNCTUATION) {
                break;
            }
        }
        int j = i;
        while (j > 0 && ((c = cs.charAt(j - 1)) == ' ' || c == '\t')) {
            j--;
        }
        if (j == 0 || cs.charAt(j - 1) == '\n') {
            return mode | CAP_MODE_WORDS;
        }
        if ((reqModes&CAP_MODE_SENTENCES) == 0) {
            if (i != j) mode |= CAP_MODE_WORDS;
            return mode;
        }
        if (i == j) {
            return mode;
        }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.516 -0400", hash_original_method = "D4F4B6F2CF36AAFF165E53C1B7992C6B", hash_generated_method = "46F8400A41F06149EC3DA91011FC858F")
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
                return true;
            }
            if (delimitedString.charAt(expectedDelimiterPos) == delimiter) {
                return true;
            }
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.517 -0400", hash_original_method = "7A7AE01D787877BE3C583A03BC9721F6", hash_generated_method = "F91F066F35DD3913675A1B0C0917AC71")
    @SuppressWarnings("unchecked")
    public static <T> T[] removeEmptySpans(T[] spans, Spanned spanned, Class<T> klass) {
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
            return result;
        } else {
            return spans;
        }
    }

    
    public static class SimpleStringSplitter implements StringSplitter, Iterator<String> {
        private String mString;
        private char mDelimiter;
        private int mPosition;
        private int mLength;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.517 -0400", hash_original_method = "6A654BA34A10AA2B42750EC65A3F679B", hash_generated_method = "A875D58460BEDA03E99AD08FBF0BECD1")
        @DSModeled(DSC.SAFE)
        public SimpleStringSplitter(char delimiter) {
            dsTaint.addTaint(delimiter);
            // ---------- Original Method ----------
            //mDelimiter = delimiter;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.517 -0400", hash_original_method = "6D8C9957AC1A2476C265420CD8A2E354", hash_generated_method = "91EEBCB9F81FCDD62C6CA252AAA45BE1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setString(String string) {
            dsTaint.addTaint(string);
            mPosition = 0;
            mLength = mString.length();
            // ---------- Original Method ----------
            //mString = string;
            //mPosition = 0;
            //mLength = mString.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.517 -0400", hash_original_method = "D653FD0D00864F21EDFF9CBFE1E1B8FB", hash_generated_method = "DD2CBAAA53CE1D71763867CFEF1FED45")
        @DSModeled(DSC.SAFE)
        public Iterator<String> iterator() {
            return (Iterator<String>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.517 -0400", hash_original_method = "675B2012EE41806104DFB06FA586494D", hash_generated_method = "FFCA6485F331E471EFA7106589272A33")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mPosition < mLength;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.517 -0400", hash_original_method = "FB7030CECFBAC326EB2083E83B14C66A", hash_generated_method = "981D8907372D283FA0BF2D0D7330FBCF")
        @DSModeled(DSC.SAFE)
        public String next() {
            int end;
            end = mString.indexOf(mDelimiter, mPosition);
            {
                end = mLength;
            } //End block
            String nextString;
            nextString = mString.substring(mPosition, end);
            mPosition = end + 1;
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //int end = mString.indexOf(mDelimiter, mPosition);
            //if (end == -1) {
                //end = mLength;
            //}
            //String nextString = mString.substring(mPosition, end);
            //mPosition = end + 1;
            //return nextString;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.517 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "70F9650B41A870182901E546A7AB0548")
        @DSModeled(DSC.SAFE)
        public void remove() {
            throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
    }


    
    private static class Reverser implements CharSequence, GetChars {
        private CharSequence mSource;
        private int mStart;
        private int mEnd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.517 -0400", hash_original_method = "BFBBE5A2171EAA5D387A9688FF38614C", hash_generated_method = "D5B3C5E0E19F12222865123378F6AA5E")
        @DSModeled(DSC.SAFE)
        public Reverser(CharSequence source, int start, int end) {
            dsTaint.addTaint(source);
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            // ---------- Original Method ----------
            //mSource = source;
            //mStart = start;
            //mEnd = end;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.517 -0400", hash_original_method = "7B7C0865096082EBDC6C915DBB65AA78", hash_generated_method = "C877366376327D049313AA0C03204BCB")
        @DSModeled(DSC.SAFE)
        public int length() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mEnd - mStart;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.517 -0400", hash_original_method = "D736D7B90470DFC8C923D4B5D62B4D1D", hash_generated_method = "162C046FE4C6BAE15AD02D3466D04192")
        @DSModeled(DSC.SAFE)
        public CharSequence subSequence(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            char[] buf;
            buf = new char[end - start];
            getChars(start, end, buf, 0);
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //char[] buf = new char[end - start];
            //getChars(start, end, buf, 0);
            //return new String(buf);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.518 -0400", hash_original_method = "814020AAFF189164368E5EE6B0F105D9", hash_generated_method = "4AFDDF814E80A7169FD8ED1CC829F0FA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var78AE35A7CE977CC9C9EE2DE46784539E_906975030 = (subSequence(0, length()).toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return subSequence(0, length()).toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.518 -0400", hash_original_method = "54C9409C1585BDAF025F1FDAAC236D34", hash_generated_method = "277E6A92CDA409B058ACD4629B186C77")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public char charAt(int off) {
            dsTaint.addTaint(off);
            char var88C961B2261A198171556BC339DBAF7B_586903066 = (AndroidCharacter.getMirror(mSource.charAt(mEnd - 1 - off)));
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //return AndroidCharacter.getMirror(mSource.charAt(mEnd - 1 - off));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.518 -0400", hash_original_method = "81F95A724AC4812824CCEB8249CFBC9B", hash_generated_method = "1F1CD6F27CFCC9681185244C01D22F7E")
        @DSModeled(DSC.SAFE)
        public void getChars(int start, int end, char[] dest, int destoff) {
            dsTaint.addTaint(dest);
            dsTaint.addTaint(start);
            dsTaint.addTaint(destoff);
            dsTaint.addTaint(end);
            TextUtils.getChars(mSource, start + mStart, end + mStart,
                               dest, destoff);
            AndroidCharacter.mirror(dest, 0, end - start);
            int len;
            len = end - start;
            int n;
            n = (end - start) / 2;
            {
                int i;
                i = 0;
                {
                    char tmp;
                    tmp = dest[destoff + i];
                    dest[destoff + i] = dest[destoff + len - i - 1];
                    dest[destoff + len - i - 1] = tmp;
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //TextUtils.getChars(mSource, start + mStart, end + mStart,
                               //dest, destoff);
            //AndroidCharacter.mirror(dest, 0, end - start);
            //int len = end - start;
            //int n = (end - start) / 2;
            //for (int i = 0; i < n; i++) {
                //char tmp = dest[destoff + i];
                //dest[destoff + i] = dest[destoff + len - i - 1];
                //dest[destoff + len - i - 1] = tmp;
            //}
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
        public void setString(String string);
    }
    
    public interface EllipsizeCallback {
        
        public void ellipsized(int start, int end);
    }
    
}


