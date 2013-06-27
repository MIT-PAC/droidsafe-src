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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.778 -0400", hash_original_method = "B02737FE3AF0C7262E7E1815816AFA38", hash_generated_method = "853174FD0AC9B98EEFD3B7193A02A48C")
    private  TextUtils() {
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
                sb.append("&apos;"); 
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.007 -0400", hash_original_field = "18E347BCBCDD07E01563671B6BDE7905", hash_generated_field = "C0B8B41E10B6EC8767D645F51D421276")

        private String mString;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.007 -0400", hash_original_field = "0F68E7FE563F289C34B41B2C951DC7E5", hash_generated_field = "0A6C459A64106B37BA6AD60C631D4A07")

        private char mDelimiter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.007 -0400", hash_original_field = "2A02BDE12D932CD9DCA97106D487F8F5", hash_generated_field = "D614AE7D1AAE0276EA05A974DCBF0210")

        private int mPosition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.007 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

        private int mLength;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.008 -0400", hash_original_method = "6A654BA34A10AA2B42750EC65A3F679B", hash_generated_method = "BEDF5C296E1AC394E7130E39CA8E7B49")
        public  SimpleStringSplitter(char delimiter) {
            mDelimiter = delimiter;
            // ---------- Original Method ----------
            //mDelimiter = delimiter;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.021 -0400", hash_original_method = "6D8C9957AC1A2476C265420CD8A2E354", hash_generated_method = "33A8FDEC591C75E7F0457D4CF5F15253")
        public void setString(String string) {
            mString = string;
            mPosition = 0;
            mLength = mString.length();
            // ---------- Original Method ----------
            //mString = string;
            //mPosition = 0;
            //mLength = mString.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.025 -0400", hash_original_method = "D653FD0D00864F21EDFF9CBFE1E1B8FB", hash_generated_method = "359615A09FE5E5B9F2691B91D23202EA")
        public Iterator<String> iterator() {
            Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_1413494326 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1413494326 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1413494326.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1413494326;
            // ---------- Original Method ----------
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.029 -0400", hash_original_method = "675B2012EE41806104DFB06FA586494D", hash_generated_method = "FF552A23D5621466D3052AE7674659D3")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_851708790 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_851708790;
            // ---------- Original Method ----------
            //return mPosition < mLength;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.055 -0400", hash_original_method = "FB7030CECFBAC326EB2083E83B14C66A", hash_generated_method = "9ACF025BD1A14A19CC9A82B0A12DAC7F")
        public String next() {
            String varB4EAC82CA7396A68D541C85D26508E83_1737741017 = null; //Variable for return #1
            int end;
            end = mString.indexOf(mDelimiter, mPosition);
            {
                end = mLength;
            } //End block
            String nextString;
            nextString = mString.substring(mPosition, end);
            mPosition = end + 1;
            varB4EAC82CA7396A68D541C85D26508E83_1737741017 = nextString;
            varB4EAC82CA7396A68D541C85D26508E83_1737741017.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1737741017;
            // ---------- Original Method ----------
            //int end = mString.indexOf(mDelimiter, mPosition);
            //if (end == -1) {
                //end = mLength;
            //}
            //String nextString = mString.substring(mPosition, end);
            //mPosition = end + 1;
            //return nextString;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.056 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "BD0416D7797F4CCA5C01710103DCE99D")
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
    }


    
    private static class Reverser implements CharSequence, GetChars {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.056 -0400", hash_original_field = "6917951DFB797D97827BAAA584F128DE", hash_generated_field = "1DB65A9625E780B230F7C604C99C0F5D")

        private CharSequence mSource;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.056 -0400", hash_original_field = "59B50EB80ABF1071654EE6DE5094E070", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")

        private int mStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.056 -0400", hash_original_field = "C3B248BAD041692A85BAABC024E9FDCE", hash_generated_field = "EA295975CAF8E42F4C28A87EADB358DF")

        private int mEnd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.057 -0400", hash_original_method = "BFBBE5A2171EAA5D387A9688FF38614C", hash_generated_method = "8066376B76A8E349A3B964287189E234")
        public  Reverser(CharSequence source, int start, int end) {
            mSource = source;
            mStart = start;
            mEnd = end;
            // ---------- Original Method ----------
            //mSource = source;
            //mStart = start;
            //mEnd = end;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.057 -0400", hash_original_method = "7B7C0865096082EBDC6C915DBB65AA78", hash_generated_method = "B244F18F8842B40CC7F50E218F0C5C81")
        public int length() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1152054292 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1152054292;
            // ---------- Original Method ----------
            //return mEnd - mStart;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.057 -0400", hash_original_method = "D736D7B90470DFC8C923D4B5D62B4D1D", hash_generated_method = "F1F65ABF07B0ED6E7484A491038DC683")
        public CharSequence subSequence(int start, int end) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1050073982 = null; //Variable for return #1
            char[] buf;
            buf = new char[end - start];
            getChars(start, end, buf, 0);
            varB4EAC82CA7396A68D541C85D26508E83_1050073982 = new String(buf);
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_1050073982.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1050073982;
            // ---------- Original Method ----------
            //char[] buf = new char[end - start];
            //getChars(start, end, buf, 0);
            //return new String(buf);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.058 -0400", hash_original_method = "814020AAFF189164368E5EE6B0F105D9", hash_generated_method = "E7F90CBD74E907AC5EB97068DEBAEA6A")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1848120106 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1848120106 = subSequence(0, length()).toString();
            varB4EAC82CA7396A68D541C85D26508E83_1848120106.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1848120106;
            // ---------- Original Method ----------
            //return subSequence(0, length()).toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.059 -0400", hash_original_method = "54C9409C1585BDAF025F1FDAAC236D34", hash_generated_method = "2A856C2BB55ADE9AF08CB6FEA285E8DC")
        public char charAt(int off) {
            char var88C961B2261A198171556BC339DBAF7B_1377671667 = (AndroidCharacter.getMirror(mSource.charAt(mEnd - 1 - off)));
            addTaint(off);
            char varA87DEB01C5F539E6BDA34829C8EF2368_1635344061 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1635344061;
            // ---------- Original Method ----------
            //return AndroidCharacter.getMirror(mSource.charAt(mEnd - 1 - off));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.065 -0400", hash_original_method = "81F95A724AC4812824CCEB8249CFBC9B", hash_generated_method = "0F4D4EEAC5308394DE68DCCEBBB42AFD")
        public void getChars(int start, int end, char[] dest, int destoff) {
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
            addTaint(start);
            addTaint(end);
            addTaint(dest[0]);
            addTaint(destoff);
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.065 -0400", hash_original_field = "A4E7A782AA30C623B9E944F657F05CAB", hash_generated_field = "BA8DFB6D0520256A7126F71E63EB2E8D")

    public static final int ALIGNMENT_SPAN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.065 -0400", hash_original_field = "3252A8A03D2F11CC9F5AF183919724F2", hash_generated_field = "0F4922FC1D49AD6ED7458917DE77E255")

    public static final int FOREGROUND_COLOR_SPAN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.065 -0400", hash_original_field = "1903BB9C05ED2308DF0049B3113969EA", hash_generated_field = "E2E9301952149239B2DC5281FA21717D")

    public static final int RELATIVE_SIZE_SPAN = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.065 -0400", hash_original_field = "CEF52104E1D370774F64BDCBAC637138", hash_generated_field = "2B30E4E74FC895531F41B0EF85A388F7")

    public static final int SCALE_X_SPAN = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.065 -0400", hash_original_field = "A00875E66A4BAFCBFF7DEFCCAF039A7F", hash_generated_field = "A49DA21AC6F8AB9FF9A517D9F24D8664")

    public static final int STRIKETHROUGH_SPAN = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.065 -0400", hash_original_field = "C2C753BFECA3449ECA4C145632C764F9", hash_generated_field = "D38434536F32934C4FB5BB2C6FDD7928")

    public static final int UNDERLINE_SPAN = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.065 -0400", hash_original_field = "CB1327BD1BA388800A3E0CE4DD7071E2", hash_generated_field = "FEA29A898CBC7C17B539313BF3E30C8F")

    public static final int STYLE_SPAN = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.065 -0400", hash_original_field = "84EFAE42F570AA5A329B400726F25B1F", hash_generated_field = "0025AA2DFF9F01340C338C9AD4D72F93")

    public static final int BULLET_SPAN = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.066 -0400", hash_original_field = "8F85C82E69CC22B500922E21B074FFAC", hash_generated_field = "BD39B1A247090B0040F706F0CF28D27C")

    public static final int QUOTE_SPAN = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.066 -0400", hash_original_field = "720DE229A5584F500DE1B99C535BD761", hash_generated_field = "29861EC0EB4FFDF405A517046B4C8855")

    public static final int LEADING_MARGIN_SPAN = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.066 -0400", hash_original_field = "CF1EBC8D770541ABEB346F7F892E27FE", hash_generated_field = "16935960E48347AF333B245161548468")

    public static final int URL_SPAN = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.066 -0400", hash_original_field = "A153948E64749C893C72107D5CA65915", hash_generated_field = "08AB7660C5D13F050ACF8BE7DFD24FB3")

    public static final int BACKGROUND_COLOR_SPAN = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.066 -0400", hash_original_field = "BDE4374D0A8497B0E25863F3022072E3", hash_generated_field = "9F8207D72EAFAC4535DA84C850CDC8E7")

    public static final int TYPEFACE_SPAN = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.066 -0400", hash_original_field = "AACB232E6B0C313C34426AD56BCE1946", hash_generated_field = "F465E900AB4D623C81F192800BB4D253")

    public static final int SUPERSCRIPT_SPAN = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.066 -0400", hash_original_field = "9CA28DF26DEF5DF3CEC5EF894A6700BB", hash_generated_field = "34AC1E3567EA7B7B6E651F80AA99ADD9")

    public static final int SUBSCRIPT_SPAN = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.066 -0400", hash_original_field = "2EF66260C90B3E9D236664C0DD72F911", hash_generated_field = "0AB2A7C92C439178B06E42F89BA4817D")

    public static final int ABSOLUTE_SIZE_SPAN = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.066 -0400", hash_original_field = "8A72513BB1E5D014ECA08B1E72A7CB21", hash_generated_field = "16ECDB8594B04E583AE9422487437AE9")

    public static final int TEXT_APPEARANCE_SPAN = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.066 -0400", hash_original_field = "4034F4ABC8C46DA1257B5844F45DF06A", hash_generated_field = "243B5C37B09807E83CFAF009267F0366")

    public static final int ANNOTATION = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.066 -0400", hash_original_field = "640879589CE7AE151A8E5BA82C564B0E", hash_generated_field = "0F5BE651337F08236DAE4F4895763BD7")

    public static final int SUGGESTION_SPAN = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.066 -0400", hash_original_field = "4151B7F5791802D6F57CBC7396F4F551", hash_generated_field = "D0D29EC5EA2F85D8A355410E3D815A3E")

    public static final int SPELL_CHECK_SPAN = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.066 -0400", hash_original_field = "3C37D5C18D8120720DD53136850A88CF", hash_generated_field = "CE7A458F9FC2A075D48E520238AABCC3")

    public static final int SUGGESTION_RANGE_SPAN = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.066 -0400", hash_original_field = "929F27A1CDFDFD64EF662ECC8CBB324A", hash_generated_field = "DF0FC51B4556E2572818C89584203638")

    public static final int EASY_EDIT_SPAN = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.066 -0400", hash_original_field = "51AF482B1F3E2850F1FD58179C1F4847", hash_generated_field = "4A662910797D2551743C470CA3EDAFC9")

    public static final Parcelable.Creator<CharSequence> CHAR_SEQUENCE_CREATOR
            = new Parcelable.Creator<CharSequence>() {
        
        public CharSequence createFromParcel(Parcel p) {
            int kind = p.readInt();

            String string = p.readString();
            if (string == null) {
                return null;
            }

            if (kind == 1) {
                return string;
            }

            SpannableString sp = new SpannableString(string);

            while (true) {
                kind = p.readInt();

                if (kind == 0)
                    break;

                switch (kind) {
                case ALIGNMENT_SPAN:
                    readSpan(p, sp, new AlignmentSpan.Standard(p));
                    break;

                case FOREGROUND_COLOR_SPAN:
                    readSpan(p, sp, new ForegroundColorSpan(p));
                    break;

                case RELATIVE_SIZE_SPAN:
                    readSpan(p, sp, new RelativeSizeSpan(p));
                    break;

                case SCALE_X_SPAN:
                    readSpan(p, sp, new ScaleXSpan(p));
                    break;

                case STRIKETHROUGH_SPAN:
                    readSpan(p, sp, new StrikethroughSpan(p));
                    break;

                case UNDERLINE_SPAN:
                    readSpan(p, sp, new UnderlineSpan(p));
                    break;

                case STYLE_SPAN:
                    readSpan(p, sp, new StyleSpan(p));
                    break;

                case BULLET_SPAN:
                    readSpan(p, sp, new BulletSpan(p));
                    break;

                case QUOTE_SPAN:
                    readSpan(p, sp, new QuoteSpan(p));
                    break;

                case LEADING_MARGIN_SPAN:
                    readSpan(p, sp, new LeadingMarginSpan.Standard(p));
                break;

                case URL_SPAN:
                    readSpan(p, sp, new URLSpan(p));
                    break;

                case BACKGROUND_COLOR_SPAN:
                    readSpan(p, sp, new BackgroundColorSpan(p));
                    break;

                case TYPEFACE_SPAN:
                    readSpan(p, sp, new TypefaceSpan(p));
                    break;

                case SUPERSCRIPT_SPAN:
                    readSpan(p, sp, new SuperscriptSpan(p));
                    break;

                case SUBSCRIPT_SPAN:
                    readSpan(p, sp, new SubscriptSpan(p));
                    break;

                case ABSOLUTE_SIZE_SPAN:
                    readSpan(p, sp, new AbsoluteSizeSpan(p));
                    break;

                case TEXT_APPEARANCE_SPAN:
                    readSpan(p, sp, new TextAppearanceSpan(p));
                    break;

                case ANNOTATION:
                    readSpan(p, sp, new Annotation(p));
                    break;

                case SUGGESTION_SPAN:
                    readSpan(p, sp, new SuggestionSpan(p));
                    break;

                case SPELL_CHECK_SPAN:
                    readSpan(p, sp, new SpellCheckSpan(p));
                    break;

                case SUGGESTION_RANGE_SPAN:
                    readSpan(p, sp, new SuggestionRangeSpan(p));
                    break;

                case EASY_EDIT_SPAN:
                    readSpan(p, sp, new EasyEditSpan());
                    break;

                default:
                    throw new RuntimeException("bogus span encoding " + kind);
                }
            }

            return sp;
        }

        public CharSequence[] newArray(int size)
        {
            return new CharSequence[size];
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.066 -0400", hash_original_field = "E7073F236704D4E004CC35F088F3B8FE", hash_generated_field = "A45E2DDC3F4FE85D500535CE0E1421C6")

    private static char FIRST_RIGHT_TO_LEFT = '\u0590';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.066 -0400", hash_original_field = "7DC75D9A239A73309DC63B254CD5A430", hash_generated_field = "7B66F2E8EDC72D450BE916BD40FCB1B1")

    public static final int CAP_MODE_CHARACTERS
            = InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.066 -0400", hash_original_field = "1DA613E353DCCDE15DAF6AD60A5774DB", hash_generated_field = "0E58216E9C917055D43665384085B275")

    public static final int CAP_MODE_WORDS
            = InputType.TYPE_TEXT_FLAG_CAP_WORDS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.067 -0400", hash_original_field = "EEC4A70B30743395CCA7B3E476BFC4D8", hash_generated_field = "85E1B4A2EC9624366A32ED1343061EC0")

    public static final int CAP_MODE_SENTENCES
            = InputType.TYPE_TEXT_FLAG_CAP_SENTENCES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.067 -0400", hash_original_field = "6FBEC3E7BB69D1E09ECABF075E18871F", hash_generated_field = "E209496F9F2C9103A6260BCF69D3191B")

    private static Object sLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.067 -0400", hash_original_field = "C736DCF0716493E46DC696537C472B83", hash_generated_field = "D5B55575C53803B48B8DF0B1F8C65A25")

    private static char[] sTemp = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.067 -0400", hash_original_field = "62D924B8B762DC082523ECF61F022F3E", hash_generated_field = "028F00C02112EDD5FB92F4223ED16EEC")

    private static String[] EMPTY_STRING_ARRAY = new String[]{};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.067 -0400", hash_original_field = "B208893E3D1C6420C168A1CE47F9EA97", hash_generated_field = "26778FE107A712143CD489E0A47EBF39")

    private static char ZWNBS_CHAR = '\uFEFF';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.067 -0400", hash_original_field = "0A5A7A34A84016C5D4AC7F3C22ED838F", hash_generated_field = "C5051CFE6CDA1C61AF5D3D07A09F2CA5")

    private static String ELLIPSIS_NORMAL = Resources.getSystem().getString(
            R.string.ellipsis);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.067 -0400", hash_original_field = "2F52ADD1701415FE320407B4DD27CE0C", hash_generated_field = "2CCA969A2E9D7DFA276DC512D8DB70EB")

    private static String ELLIPSIS_TWO_DOTS = Resources.getSystem().getString(
            R.string.ellipsis_two_dots);
}

