package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.regex.Pattern;

public class TextUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.876 -0400", hash_original_method = "B02737FE3AF0C7262E7E1815816AFA38", hash_generated_method = "853174FD0AC9B98EEFD3B7193A02A48C")
    @DSModeled(DSC.SAFE)
    private TextUtils() {
        // ---------- Original Method ----------
    }

    
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

    
        public static int indexOf(CharSequence s, char ch) {
        return indexOf(s, ch, 0);
    }

    
        public static int indexOf(CharSequence s, char ch, int start) {
        Class<? extends CharSequence> c = s.getClass();
        if (c == String.class)
            return ((String) s).indexOf(ch, start);
        return indexOf(s, ch, start, s.length());
    }

    
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

    
        public static int lastIndexOf(CharSequence s, char ch) {
        return lastIndexOf(s, ch, s.length() - 1);
    }

    
        public static int lastIndexOf(CharSequence s, char ch, int last) {
        Class<? extends CharSequence> c = s.getClass();
        if (c == String.class)
            return ((String) s).lastIndexOf(ch, last);
        return lastIndexOf(s, ch, 0, last);
    }

    
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

    
        public static int indexOf(CharSequence s, CharSequence needle) {
        return indexOf(s, needle, 0, s.length());
    }

    
        public static int indexOf(CharSequence s, CharSequence needle, int start) {
        return indexOf(s, needle, start, s.length());
    }

    
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

    
        public static CharSequence join(Iterable<CharSequence> list) {
        final CharSequence delimiter = Resources.getSystem().getText(R.string.list_delimeter);
        return join(delimiter, list);
    }

    
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

    
        public static String[] split(String text, String expression) {
        if (text.length() == 0) {
            return EMPTY_STRING_ARRAY;
        } else {
            return text.split(expression, -1);
        }
    }

    
        public static String[] split(String text, Pattern pattern) {
        if (text.length() == 0) {
            return EMPTY_STRING_ARRAY;
        } else {
            return pattern.split(text, -1);
        }
    }

    
        public static CharSequence stringOrSpannedString(CharSequence source) {
        if (source == null)
            return null;
        if (source instanceof SpannedString)
            return source;
        if (source instanceof Spanned)
            return new SpannedString(source);
        return source.toString();
    }

    
        public static boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }

    
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

    
        public static CharSequence getReverse(CharSequence source,
                                          int start, int end) {
        return new Reverser(source, start, end);
    }

    
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

    
        private static void writeWhere(Parcel p, Spanned sp, Object o) {
        p.writeInt(sp.getSpanStart(o));
        p.writeInt(sp.getSpanEnd(o));
        p.writeInt(sp.getSpanFlags(o));
    }

    
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

    
        private static void readSpan(Parcel p, Spannable sp, Object o) {
        sp.setSpan(o, p.readInt(), p.readInt(), p.readInt());
    }

    
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

    
        public static CharSequence ellipsize(CharSequence text,
                                         TextPaint p,
                                         float avail, TruncateAt where) {
        return ellipsize(text, p, avail, where, false, null);
    }

    
        public static CharSequence ellipsize(CharSequence text,
                                         TextPaint paint,
                                         float avail, TruncateAt where,
                                         boolean preserveLength,
                                         EllipsizeCallback callback) {
        return ellipsize(text, paint, avail, where, preserveLength, callback,
                TextDirectionHeuristics.FIRSTSTRONG_LTR,
                (where == TruncateAt.END_SMALL) ? ELLIPSIS_TWO_DOTS : ELLIPSIS_NORMAL);
    }

    
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

    
        public static CharSequence commaEllipsize(CharSequence text,
                                              TextPaint p, float avail,
                                              String oneMore,
                                              String more) {
        return commaEllipsize(text, p, avail, oneMore, more,
                TextDirectionHeuristics.FIRSTSTRONG_LTR);
    }

    
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

    
        static boolean doesNotNeedBidi(CharSequence s, int start, int end) {
        for (int i = start; i < end; i++) {
            if (s.charAt(i) >= FIRST_RIGHT_TO_LEFT) {
                return false;
            }
        }
        return true;
    }

    
        static boolean doesNotNeedBidi(char[] text, int start, int len) {
        for (int i = start, e = i + len; i < e; i++) {
            if (text[i] >= FIRST_RIGHT_TO_LEFT) {
                return false;
            }
        }
        return true;
    }

    
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

    
        static void recycle(char[] temp) {
        if (temp.length > 1000)
            return;
        synchronized (sLock) {
            sTemp = temp;
        }
    }

    
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

    
        public static boolean isDigitsOnly(CharSequence str) {
        final int len = str.length();
        for (int i = 0; i < len; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    
        public static boolean isPrintableAscii(final char c) {
        final int asciiFirst = 0x20;
        final int asciiLast = 0x7E;
        return (asciiFirst <= c && c <= asciiLast) || c == '\r' || c == '\n';
    }

    
        public static boolean isPrintableAsciiOnly(final CharSequence str) {
        final int len = str.length();
        for (int i = 0; i < len; i++) {
            if (!isPrintableAscii(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.885 -0400", hash_original_method = "6A654BA34A10AA2B42750EC65A3F679B", hash_generated_method = "7AE12EA28B25F32ABB46BA7AD29706B5")
        @DSModeled(DSC.SAFE)
        public SimpleStringSplitter(char delimiter) {
            dsTaint.addTaint(delimiter);
            // ---------- Original Method ----------
            //mDelimiter = delimiter;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.885 -0400", hash_original_method = "6D8C9957AC1A2476C265420CD8A2E354", hash_generated_method = "2D26D132064C805BEBBFF8BD9788CFED")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.886 -0400", hash_original_method = "D653FD0D00864F21EDFF9CBFE1E1B8FB", hash_generated_method = "1F81FCBBCBF166F3612EBB676D36DD17")
        @DSModeled(DSC.SAFE)
        public Iterator<String> iterator() {
            return (Iterator<String>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.886 -0400", hash_original_method = "675B2012EE41806104DFB06FA586494D", hash_generated_method = "4CC083ECF8FF98540923F77A53200D1A")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mPosition < mLength;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.886 -0400", hash_original_method = "FB7030CECFBAC326EB2083E83B14C66A", hash_generated_method = "B27641EE84A2BBB1B58EAAE0C29264A6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.886 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "BD0416D7797F4CCA5C01710103DCE99D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
    }


    
    private static class Reverser implements CharSequence, GetChars {
        private CharSequence mSource;
        private int mStart;
        private int mEnd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.887 -0400", hash_original_method = "BFBBE5A2171EAA5D387A9688FF38614C", hash_generated_method = "67E66BFCD14123AC1818B18674614D0D")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.887 -0400", hash_original_method = "7B7C0865096082EBDC6C915DBB65AA78", hash_generated_method = "481BA88D1F55BC217631A473BC4264A6")
        @DSModeled(DSC.SAFE)
        public int length() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mEnd - mStart;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.887 -0400", hash_original_method = "D736D7B90470DFC8C923D4B5D62B4D1D", hash_generated_method = "1755B3F024357608A109DD60D371924F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CharSequence subSequence(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            char[] buf;
            buf = new char[end - start];
            getChars(start, end, buf, 0);
            CharSequence varD058E064058731988E6FE4650A392B5A_912955385 = (new String(buf));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //char[] buf = new char[end - start];
            //getChars(start, end, buf, 0);
            //return new String(buf);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.887 -0400", hash_original_method = "814020AAFF189164368E5EE6B0F105D9", hash_generated_method = "0E314E77789BC6100B44FF721423B983")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var78AE35A7CE977CC9C9EE2DE46784539E_1838014077 = (subSequence(0, length()).toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return subSequence(0, length()).toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.887 -0400", hash_original_method = "54C9409C1585BDAF025F1FDAAC236D34", hash_generated_method = "00B055F4C0FCCE4DC41F953F14D1436D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public char charAt(int off) {
            dsTaint.addTaint(off);
            char var88C961B2261A198171556BC339DBAF7B_1713437215 = (AndroidCharacter.getMirror(mSource.charAt(mEnd - 1 - off)));
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //return AndroidCharacter.getMirror(mSource.charAt(mEnd - 1 - off));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.888 -0400", hash_original_method = "81F95A724AC4812824CCEB8249CFBC9B", hash_generated_method = "0A2BC22DF94595206B766974288A12BC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void getChars(int start, int end, char[] dest, int destoff) {
            dsTaint.addTaint(dest[0]);
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.927 -0400", hash_original_method = "9ACEE99AC88FDD394854F98E1EFE5030", hash_generated_method = "AF9887758FFB0CA522BAE9D092C8DB25")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.927 -0400", hash_original_method = "F283C0C9D7FBE7C977B3511A473800E3", hash_generated_method = "5752562C0F21392D0418E57B010ACD42")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CharSequence[] newArray(int size) {
            dsTaint.addTaint(size);
            CharSequence[] varB1145307A84F98ECB8F29ACF488343F8_28234643 = (new CharSequence[size]);
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
}

