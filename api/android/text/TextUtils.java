package android.text;

// Droidsafe Imports
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
        
        @DSModeled(DSC.SPEC)
        public MyCreator() {}
        
        @DSModeled(DSC.SPEC)
        public CharSequence createFromParcel(Parcel p) {
            return new String();
        }
     
        @DSModeled(DSC.SPEC)
        public CharSequence[] newArray(int size)
        {
            return new CharSequence[size];
        }

    }

    
    @DSModeled(DSC.BAN)
    private TextUtils() { /* cannot be instantiated */ }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static int indexOf(CharSequence s, char ch) {
        return indexOf(s, ch, 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static int indexOf(CharSequence s, char ch, int start) {
        Class<? extends CharSequence> c = s.getClass();
        if (c == String.class)
            return ((String) s).indexOf(ch, start);
        return indexOf(s, ch, start, s.length());
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static int lastIndexOf(CharSequence s, char ch) {
        return lastIndexOf(s, ch, s.length() - 1);
    }

    
    @DSModeled(DSC.SAFE)
    public static int lastIndexOf(CharSequence s, char ch, int last) {
        Class<? extends CharSequence> c = s.getClass();
        if (c == String.class)
            return ((String) s).lastIndexOf(ch, last);
        return lastIndexOf(s, ch, 0, last);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static int indexOf(CharSequence s, CharSequence needle) {
        return indexOf(s, needle, 0, s.length());
    }

    
    @DSModeled(DSC.SAFE)
    public static int indexOf(CharSequence s, CharSequence needle, int start) {
        return indexOf(s, needle, start, s.length());
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static CharSequence join(Iterable<CharSequence> list) {
        final CharSequence delimiter = Resources.getSystem().getText(R.string.list_delimeter);
        return join(delimiter, list);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static String[] split(String text, String expression) {
        if (text.length() == 0) {
            return EMPTY_STRING_ARRAY;
        } else {
            return text.split(expression, -1);
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static String[] split(String text, Pattern pattern) {
        if (text.length() == 0) {
            return EMPTY_STRING_ARRAY;
        } else {
            return pattern.split(text, -1);
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static CharSequence stringOrSpannedString(CharSequence source) {
        if (source == null)
            return null;
        if (source instanceof SpannedString)
            return source;
        if (source instanceof Spanned)
            return new SpannedString(source);
        return source.toString();
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static CharSequence getReverse(CharSequence source,
                                          int start, int end) {
        return new Reverser(source, start, end);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.BAN)
    private static void writeWhere(Parcel p, Spanned sp, Object o) {
        p.writeInt(sp.getSpanStart(o));
        p.writeInt(sp.getSpanEnd(o));
        p.writeInt(sp.getSpanFlags(o));
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.BAN)
    private static void readSpan(Parcel p, Spannable sp, Object o) {
        sp.setSpan(o, p.readInt(), p.readInt(), p.readInt());
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static CharSequence ellipsize(CharSequence text,
                                         TextPaint p,
                                         float avail, TruncateAt where) {
        return ellipsize(text, p, avail, where, false, null);
    }

    
    @DSModeled(DSC.SAFE)
    public static CharSequence ellipsize(CharSequence text,
                                         TextPaint paint,
                                         float avail, TruncateAt where,
                                         boolean preserveLength,
                                         EllipsizeCallback callback) {
        return ellipsize(text, paint, avail, where, preserveLength, callback,
                TextDirectionHeuristics.FIRSTSTRONG_LTR,
                (where == TruncateAt.END_SMALL) ? ELLIPSIS_TWO_DOTS : ELLIPSIS_NORMAL);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static CharSequence commaEllipsize(CharSequence text,
                                              TextPaint p, float avail,
                                              String oneMore,
                                              String more) {
        return commaEllipsize(text, p, avail, oneMore, more,
                TextDirectionHeuristics.FIRSTSTRONG_LTR);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.SAFE)
    static boolean doesNotNeedBidi(CharSequence s, int start, int end) {
        for (int i = start; i < end; i++) {
            if (s.charAt(i) >= FIRST_RIGHT_TO_LEFT) {
                return false;
            }
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    static boolean doesNotNeedBidi(char[] text, int start, int len) {
        for (int i = start, e = i + len; i < e; i++) {
            if (text[i] >= FIRST_RIGHT_TO_LEFT) {
                return false;
            }
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    static void recycle(char[] temp) {
        if (temp.length > 1000)
            return;
        synchronized (sLock) {
            sTemp = temp;
        }
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    public static class SimpleStringSplitter implements StringSplitter, Iterator<String> {
        private String mString;
        private char mDelimiter;
        private int mPosition;
        private int mLength;
        
        @DSModeled(DSC.SAFE)
        public SimpleStringSplitter(char delimiter) {
            mDelimiter = delimiter;
        }

        
        @DSModeled(DSC.SAFE)
        public void setString(String string) {
            mString = string;
            mPosition = 0;
            mLength = mString.length();
        }

        
        @DSModeled(DSC.SAFE)
        public Iterator iterator() {
            return this;
        }

        
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
        	// GITI DSModeled - the result of this method should have no impact
        	// on the PTA whether or not the result is TRUE or FALSE.
            return mPosition < mLength;
        }

        
        @DSModeled(DSC.SAFE)
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

        
        @DSModeled(DSC.SAFE)
        public void remove() {
            throw new UnsupportedOperationException();
        }

        
    }


    
    private static class Reverser implements CharSequence, GetChars {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.663 -0400", hash_original_field = "6917951DFB797D97827BAAA584F128DE", hash_generated_field = "1DB65A9625E780B230F7C604C99C0F5D")

        private CharSequence mSource;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.663 -0400", hash_original_field = "59B50EB80ABF1071654EE6DE5094E070", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")

        private int mStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.663 -0400", hash_original_field = "C3B248BAD041692A85BAABC024E9FDCE", hash_generated_field = "EA295975CAF8E42F4C28A87EADB358DF")

        private int mEnd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.664 -0400", hash_original_method = "BFBBE5A2171EAA5D387A9688FF38614C", hash_generated_method = "8066376B76A8E349A3B964287189E234")
        public  Reverser(CharSequence source, int start, int end) {
            mSource = source;
            mStart = start;
            mEnd = end;
            // ---------- Original Method ----------
            //mSource = source;
            //mStart = start;
            //mEnd = end;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.664 -0400", hash_original_method = "7B7C0865096082EBDC6C915DBB65AA78", hash_generated_method = "15D1F9E39AC80EBC0E1A89BB8C637332")
        public int length() {
            int varE12401DE7F163750A23A237001BAD0C5_1217656313 = (mEnd - mStart);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1301175235 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1301175235;
            // ---------- Original Method ----------
            //return mEnd - mStart;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.665 -0400", hash_original_method = "D736D7B90470DFC8C923D4B5D62B4D1D", hash_generated_method = "102344C1C0351E2AD4D79CCD803C39CE")
        public CharSequence subSequence(int start, int end) {
            addTaint(end);
            addTaint(start);
            char[] buf = new char[end - start];
            getChars(start, end, buf, 0);
CharSequence var5B166C4D1D866639CF85033C2F7318C9_571467782 =             new String(buf);
            var5B166C4D1D866639CF85033C2F7318C9_571467782.addTaint(taint);
            return var5B166C4D1D866639CF85033C2F7318C9_571467782;
            // ---------- Original Method ----------
            //char[] buf = new char[end - start];
            //getChars(start, end, buf, 0);
            //return new String(buf);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.665 -0400", hash_original_method = "814020AAFF189164368E5EE6B0F105D9", hash_generated_method = "1966D47A254BF368C79AE76825163E6F")
        @Override
        public String toString() {
String var2E22F76A1DF5431AD85BD69F1EB550BE_638501454 =             subSequence(0, length()).toString();
            var2E22F76A1DF5431AD85BD69F1EB550BE_638501454.addTaint(taint);
            return var2E22F76A1DF5431AD85BD69F1EB550BE_638501454;
            // ---------- Original Method ----------
            //return subSequence(0, length()).toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.665 -0400", hash_original_method = "54C9409C1585BDAF025F1FDAAC236D34", hash_generated_method = "A690DC7DC77FA6089B6DB53D093BE7E9")
        public char charAt(int off) {
            addTaint(off);
            char var2B052FC99472DB3889BD95EBD738C96A_531872505 = (AndroidCharacter.getMirror(mSource.charAt(mEnd - 1 - off)));
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1011740843 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1011740843;
            // ---------- Original Method ----------
            //return AndroidCharacter.getMirror(mSource.charAt(mEnd - 1 - off));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.666 -0400", hash_original_method = "81F95A724AC4812824CCEB8249CFBC9B", hash_generated_method = "31520A5D001EA5F191CCC36109D9AFA8")
        public void getChars(int start, int end, char[] dest, int destoff) {
            addTaint(destoff);
            addTaint(dest[0]);
            addTaint(end);
            addTaint(start);
            TextUtils.getChars(mSource, start + mStart, end + mStart,
                               dest, destoff);
            AndroidCharacter.mirror(dest, 0, end - start);
            int len = end - start;
            int n = (end - start) / 2;
for(int i = 0;i < n;i++)
            {
                char tmp = dest[destoff + i];
                dest[destoff + i] = dest[destoff + len - i - 1];
                dest[destoff + len - i - 1] = tmp;
            } //End block
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.666 -0400", hash_original_field = "A4E7A782AA30C623B9E944F657F05CAB", hash_generated_field = "BA8DFB6D0520256A7126F71E63EB2E8D")

    public static final int ALIGNMENT_SPAN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.666 -0400", hash_original_field = "3252A8A03D2F11CC9F5AF183919724F2", hash_generated_field = "0F4922FC1D49AD6ED7458917DE77E255")

    public static final int FOREGROUND_COLOR_SPAN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.666 -0400", hash_original_field = "1903BB9C05ED2308DF0049B3113969EA", hash_generated_field = "E2E9301952149239B2DC5281FA21717D")

    public static final int RELATIVE_SIZE_SPAN = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.666 -0400", hash_original_field = "CEF52104E1D370774F64BDCBAC637138", hash_generated_field = "2B30E4E74FC895531F41B0EF85A388F7")

    public static final int SCALE_X_SPAN = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.666 -0400", hash_original_field = "A00875E66A4BAFCBFF7DEFCCAF039A7F", hash_generated_field = "A49DA21AC6F8AB9FF9A517D9F24D8664")

    public static final int STRIKETHROUGH_SPAN = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.667 -0400", hash_original_field = "C2C753BFECA3449ECA4C145632C764F9", hash_generated_field = "D38434536F32934C4FB5BB2C6FDD7928")

    public static final int UNDERLINE_SPAN = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.667 -0400", hash_original_field = "CB1327BD1BA388800A3E0CE4DD7071E2", hash_generated_field = "FEA29A898CBC7C17B539313BF3E30C8F")

    public static final int STYLE_SPAN = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.667 -0400", hash_original_field = "84EFAE42F570AA5A329B400726F25B1F", hash_generated_field = "0025AA2DFF9F01340C338C9AD4D72F93")

    public static final int BULLET_SPAN = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.667 -0400", hash_original_field = "8F85C82E69CC22B500922E21B074FFAC", hash_generated_field = "BD39B1A247090B0040F706F0CF28D27C")

    public static final int QUOTE_SPAN = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.667 -0400", hash_original_field = "720DE229A5584F500DE1B99C535BD761", hash_generated_field = "29861EC0EB4FFDF405A517046B4C8855")

    public static final int LEADING_MARGIN_SPAN = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.667 -0400", hash_original_field = "CF1EBC8D770541ABEB346F7F892E27FE", hash_generated_field = "16935960E48347AF333B245161548468")

    public static final int URL_SPAN = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.667 -0400", hash_original_field = "A153948E64749C893C72107D5CA65915", hash_generated_field = "08AB7660C5D13F050ACF8BE7DFD24FB3")

    public static final int BACKGROUND_COLOR_SPAN = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.667 -0400", hash_original_field = "BDE4374D0A8497B0E25863F3022072E3", hash_generated_field = "9F8207D72EAFAC4535DA84C850CDC8E7")

    public static final int TYPEFACE_SPAN = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.667 -0400", hash_original_field = "AACB232E6B0C313C34426AD56BCE1946", hash_generated_field = "F465E900AB4D623C81F192800BB4D253")

    public static final int SUPERSCRIPT_SPAN = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.667 -0400", hash_original_field = "9CA28DF26DEF5DF3CEC5EF894A6700BB", hash_generated_field = "34AC1E3567EA7B7B6E651F80AA99ADD9")

    public static final int SUBSCRIPT_SPAN = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.667 -0400", hash_original_field = "2EF66260C90B3E9D236664C0DD72F911", hash_generated_field = "0AB2A7C92C439178B06E42F89BA4817D")

    public static final int ABSOLUTE_SIZE_SPAN = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.667 -0400", hash_original_field = "8A72513BB1E5D014ECA08B1E72A7CB21", hash_generated_field = "16ECDB8594B04E583AE9422487437AE9")

    public static final int TEXT_APPEARANCE_SPAN = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.667 -0400", hash_original_field = "4034F4ABC8C46DA1257B5844F45DF06A", hash_generated_field = "243B5C37B09807E83CFAF009267F0366")

    public static final int ANNOTATION = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.667 -0400", hash_original_field = "640879589CE7AE151A8E5BA82C564B0E", hash_generated_field = "0F5BE651337F08236DAE4F4895763BD7")

    public static final int SUGGESTION_SPAN = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.667 -0400", hash_original_field = "4151B7F5791802D6F57CBC7396F4F551", hash_generated_field = "D0D29EC5EA2F85D8A355410E3D815A3E")

    public static final int SPELL_CHECK_SPAN = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.668 -0400", hash_original_field = "3C37D5C18D8120720DD53136850A88CF", hash_generated_field = "CE7A458F9FC2A075D48E520238AABCC3")

    public static final int SUGGESTION_RANGE_SPAN = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.668 -0400", hash_original_field = "929F27A1CDFDFD64EF662ECC8CBB324A", hash_generated_field = "DF0FC51B4556E2572818C89584203638")

    public static final int EASY_EDIT_SPAN = 22;
    public static Parcelable.Creator<CharSequence> CHAR_SEQUENCE_CREATOR  = new MyCreator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.668 -0400", hash_original_field = "E7073F236704D4E004CC35F088F3B8FE", hash_generated_field = "C2F2F45019948F5515A5534F9B80EBF4")

    private static final char FIRST_RIGHT_TO_LEFT = '\u0590';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.668 -0400", hash_original_field = "7DC75D9A239A73309DC63B254CD5A430", hash_generated_field = "7B66F2E8EDC72D450BE916BD40FCB1B1")

    public static final int CAP_MODE_CHARACTERS
            = InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.668 -0400", hash_original_field = "1DA613E353DCCDE15DAF6AD60A5774DB", hash_generated_field = "0E58216E9C917055D43665384085B275")

    public static final int CAP_MODE_WORDS
            = InputType.TYPE_TEXT_FLAG_CAP_WORDS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.668 -0400", hash_original_field = "EEC4A70B30743395CCA7B3E476BFC4D8", hash_generated_field = "85E1B4A2EC9624366A32ED1343061EC0")

    public static final int CAP_MODE_SENTENCES
            = InputType.TYPE_TEXT_FLAG_CAP_SENTENCES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.668 -0400", hash_original_field = "6FBEC3E7BB69D1E09ECABF075E18871F", hash_generated_field = "E209496F9F2C9103A6260BCF69D3191B")

    private static Object sLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.668 -0400", hash_original_field = "C736DCF0716493E46DC696537C472B83", hash_generated_field = "D5B55575C53803B48B8DF0B1F8C65A25")

    private static char[] sTemp = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.668 -0400", hash_original_field = "62D924B8B762DC082523ECF61F022F3E", hash_generated_field = "028F00C02112EDD5FB92F4223ED16EEC")

    private static String[] EMPTY_STRING_ARRAY = new String[]{};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.669 -0400", hash_original_field = "B208893E3D1C6420C168A1CE47F9EA97", hash_generated_field = "6EF5025B69B9D168A5631B2819D5C1D0")

    private static final char ZWNBS_CHAR = '\uFEFF';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.669 -0400", hash_original_field = "0A5A7A34A84016C5D4AC7F3C22ED838F", hash_generated_field = "A9B2DE4DB6FBCCC1E9139098336CF406")

    private static final String ELLIPSIS_NORMAL = Resources.getSystem().getString(
            R.string.ellipsis);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.669 -0400", hash_original_field = "2F52ADD1701415FE320407B4DD27CE0C", hash_generated_field = "6E8AB6D76733F340318805625C3D4EC8")

    private static final String ELLIPSIS_TWO_DOTS = Resources.getSystem().getString(
            R.string.ellipsis_two_dots);
}

