package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.RectF;
import android.text.Layout.Directions;
import android.text.Layout.TabStops;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
import android.util.Log;
import com.android.internal.util.ArrayUtils;
import java.lang.reflect.Array;

class TextLine {
    private TextPaint mPaint;
    private CharSequence mText;
    private int mStart;
    private int mLen;
    private int mDir;
    private Directions mDirections;
    private boolean mHasTabs;
    private TabStops mTabs;
    private char[] mChars;
    private boolean mCharsValid;
    private Spanned mSpanned;
    private TextPaint mWorkPaint = new TextPaint();
    private SpanSet<MetricAffectingSpan> mMetricAffectingSpanSpanSet =
            new SpanSet<MetricAffectingSpan>(MetricAffectingSpan.class);
    private SpanSet<CharacterStyle> mCharacterStyleSpanSet =
            new SpanSet<CharacterStyle>(CharacterStyle.class);
    private SpanSet<ReplacementSpan> mReplacementSpanSpanSet =
            new SpanSet<ReplacementSpan>(ReplacementSpan.class);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.685 -0400", hash_original_method = "39A3636FA4EF93C30E3E661E38CC395E", hash_generated_method = "39A3636FA4EF93C30E3E661E38CC395E")
        public TextLine ()
    {
    }


        static TextLine obtain() {
        TextLine tl;
        synchronized (sCached) {
            for (int i = sCached.length; --i >= 0;) {
                if (sCached[i] != null) {
                    tl = sCached[i];
                    sCached[i] = null;
                    return tl;
                }
            }
        }
        tl = new TextLine();
        if (DEBUG) {
            Log.v("TLINE", "new: " + tl);
        }
        return tl;
    }

    
        static TextLine recycle(TextLine tl) {
        tl.mText = null;
        tl.mPaint = null;
        tl.mDirections = null;
        tl.mMetricAffectingSpanSpanSet.recycle();
        tl.mCharacterStyleSpanSet.recycle();
        tl.mReplacementSpanSpanSet.recycle();
        synchronized(sCached) {
            for (int i = 0; i < sCached.length; ++i) {
                if (sCached[i] == null) {
                    sCached[i] = tl;
                    break;
                }
            }
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.686 -0400", hash_original_method = "38DB7B0D381033DA01F9181167C14361", hash_generated_method = "EE6FF4B896CA3FC7D29579E6DD1C7047")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void set(TextPaint paint, CharSequence text, int start, int limit, int dir,
            Directions directions, boolean hasTabs, TabStops tabStops) {
        dsTaint.addTaint(directions.dsTaint);
        dsTaint.addTaint(limit);
        dsTaint.addTaint(tabStops.dsTaint);
        dsTaint.addTaint(text);
        dsTaint.addTaint(dir);
        dsTaint.addTaint(start);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(hasTabs);
        mLen = limit - start;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Directions cannot be null");
        } //End block
        mSpanned = null;
        boolean hasReplacement;
        hasReplacement = false;
        {
            mSpanned = (Spanned) text;
            mReplacementSpanSpanSet.init(mSpanned, start, limit);
            hasReplacement = mReplacementSpanSpanSet.numberOfSpans > 0;
        } //End block
        mCharsValid = hasReplacement || hasTabs || directions != Layout.DIRS_ALL_LEFT_TO_RIGHT;
        {
            {
                mChars = new char[ArrayUtils.idealCharArraySize(mLen)];
            } //End block
            TextUtils.getChars(text, start, limit, mChars, 0);
            {
                char[] chars;
                chars = mChars;
                {
                    int i, inext;
                    i = start;
                    i = inext;
                    {
                        inext = mReplacementSpanSpanSet.getNextTransition(i, limit);
                        {
                            boolean var9A0647084190D1C8B24B12E654D855A5_496285876 = (mReplacementSpanSpanSet.hasSpansIntersecting(i, inext));
                            {
                                chars[i - start] = '\ufffc';
                                {
                                    int j, e;
                                    j = i - start + 1;
                                    e = inext - start;
                                    {
                                        chars[j] = '\ufeff';
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.687 -0400", hash_original_method = "20A60861C26C58A53A0282FABD9ED153", hash_generated_method = "F7AAA7932EBB111D84CFE48354FC7F26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void draw(Canvas c, float x, int top, int y, int bottom) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(y);
        dsTaint.addTaint(top);
        dsTaint.addTaint(x);
        {
            {
                drawRun(c, 0, mLen, false, x, top, y, bottom, false);
            } //End block
            {
                drawRun(c, 0, mLen, true, x, top, y, bottom, false);
            } //End block
        } //End block
        float h;
        h = 0;
        int[] runs;
        runs = mDirections.mDirections;
        RectF emojiRect;
        emojiRect = null;
        int lastRunIndex;
        lastRunIndex = runs.length - 2;
        {
            int i;
            i = 0;
            i += 2;
            {
                int runStart;
                runStart = runs[i];
                int runLimit;
                runLimit = runStart + (runs[i+1] & Layout.RUN_LENGTH_MASK);
                {
                    runLimit = mLen;
                } //End block
                boolean runIsRtl;
                runIsRtl = (runs[i+1] & Layout.RUN_RTL_FLAG) != 0;
                int segstart;
                segstart = runStart;
                {
                    int j;
                    j = runStart;
                    j = runLimit;
                    {
                        int codept;
                        codept = 0;
                        Bitmap bm;
                        bm = null;
                        {
                            codept = mChars[j];
                            {
                                codept = Character.codePointAt(mChars, j);
                                {
                                    bm = Layout.EMOJI_FACTORY.getBitmapFromAndroidPua(codept);
                                } //End block
                            } //End block
                        } //End block
                        {
                            h += drawRun(c, segstart, j, runIsRtl, x+h, top, y, bottom,
                            i != lastRunIndex || j != mLen);
                            {
                                h = mDir * nextTab(h * mDir);
                            } //End block
                            {
                                float bmAscent;
                                bmAscent = ascent(j);
                                float bitmapHeight;
                                bitmapHeight = bm.getHeight();
                                float scale;
                                scale = -bmAscent / bitmapHeight;
                                float width;
                                width = bm.getWidth() * scale;
                                {
                                    emojiRect = new RectF();
                                } //End block
                                emojiRect.set(x + h, y + bmAscent,
                                x + h + width, y);
                                c.drawBitmap(bm, null, emojiRect, mPaint);
                                h += width;
                            } //End block
                            segstart = j + 1;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.688 -0400", hash_original_method = "7F5367E991A6BC7E9EDD55CA9BF0FBE6", hash_generated_method = "B7B06045AF92E6C5D959BFE1EFEDAAB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     float metrics(FontMetricsInt fmi) {
        dsTaint.addTaint(fmi.dsTaint);
        float var819434D16349BB2DC69F34C4834A5D61_999288858 = (measure(mLen, false, fmi));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return measure(mLen, false, fmi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.688 -0400", hash_original_method = "5986320AFF9EF780E7B17B08599A90A9", hash_generated_method = "A4FA82484DFD9DB8E74423D70E60FE5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     float measure(int offset, boolean trailing, FontMetricsInt fmi) {
        dsTaint.addTaint(trailing);
        dsTaint.addTaint(fmi.dsTaint);
        dsTaint.addTaint(offset);
        int target;
        target = offset - 1;
        target = offset;
        float h;
        h = 0;
        {
            {
                float var6DBB5A12B291F41A1B8183C9E3967A7F_998762296 = (measureRun(0, offset, mLen, false, fmi));
            } //End block
            {
                float varAF7F0B660DD98ED2707F73909AA41E03_155544335 = (measureRun(0, offset, mLen, true, fmi));
            } //End block
        } //End block
        char[] chars;
        chars = mChars;
        int[] runs;
        runs = mDirections.mDirections;
        {
            int i;
            i = 0;
            i += 2;
            {
                int runStart;
                runStart = runs[i];
                int runLimit;
                runLimit = runStart + (runs[i+1] & Layout.RUN_LENGTH_MASK);
                {
                    runLimit = mLen;
                } //End block
                boolean runIsRtl;
                runIsRtl = (runs[i+1] & Layout.RUN_RTL_FLAG) != 0;
                int segstart;
                segstart = runStart;
                {
                    int j;
                    j = runStart;
                    j = runLimit;
                    {
                        int codept;
                        codept = 0;
                        Bitmap bm;
                        bm = null;
                        {
                            codept = chars[j];
                            {
                                codept = Character.codePointAt(chars, j);
                                {
                                    bm = Layout.EMOJI_FACTORY.getBitmapFromAndroidPua(codept);
                                } //End block
                            } //End block
                        } //End block
                        {
                            boolean inSegment;
                            inSegment = target >= segstart && target < j;
                            boolean advance;
                            advance = (mDir == Layout.DIR_RIGHT_TO_LEFT) == runIsRtl;
                            {
                                float varEAD76BB4ECB5BC510C30780AC9415C1A_1743844016 = (h += measureRun(segstart, offset, j, runIsRtl, fmi));
                            } //End block
                            float w;
                            w = measureRun(segstart, j, j, runIsRtl, fmi);
                            h += advance ? w : -w;
                            {
                                float var156DB9BDC3E26545D8938CCB69603D57_474472664 = (h += measureRun(segstart, offset, j, runIsRtl, null));
                            } //End block
                            {
                                h = mDir * nextTab(h * mDir);
                            } //End block
                            {
                                float bmAscent;
                                bmAscent = ascent(j);
                                float wid;
                                wid = bm.getWidth() * -bmAscent / bm.getHeight();
                                h += mDir * wid;
                            } //End block
                            segstart = j + 1;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.689 -0400", hash_original_method = "1E01EF0F20C48DC869D8591ACBCB40DD", hash_generated_method = "1905391ABA31405FF6479CE56EAEC5DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float drawRun(Canvas c, int start,
            int limit, boolean runIsRtl, float x, int top, int y, int bottom,
            boolean needWidth) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(needWidth);
        dsTaint.addTaint(start);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(y);
        dsTaint.addTaint(top);
        dsTaint.addTaint(x);
        dsTaint.addTaint(runIsRtl);
        {
            float w;
            w = -measureRun(start, limit, limit, runIsRtl, null);
            handleRun(start, limit, limit, runIsRtl, c, x + w, top,
                    y, bottom, null, false);
        } //End block
        float var2B269E7D5B38EDA34EF7FCBB54724505_662682338 = (handleRun(start, limit, limit, runIsRtl, c, x, top,
                y, bottom, null, needWidth));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //if ((mDir == Layout.DIR_LEFT_TO_RIGHT) == runIsRtl) {
            //float w = -measureRun(start, limit, limit, runIsRtl, null);
            //handleRun(start, limit, limit, runIsRtl, c, x + w, top,
                    //y, bottom, null, false);
            //return w;
        //}
        //return handleRun(start, limit, limit, runIsRtl, c, x, top,
                //y, bottom, null, needWidth);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.689 -0400", hash_original_method = "92FB3641FED625E21CE916EA375B8557", hash_generated_method = "5ECD9C68DFE4A8AA45E5EC5820FDA16A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float measureRun(int start, int offset, int limit, boolean runIsRtl,
            FontMetricsInt fmi) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(start);
        dsTaint.addTaint(fmi.dsTaint);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(runIsRtl);
        float var97D1A4BD409768E6336775867B4BED96_1231126464 = (handleRun(start, offset, limit, runIsRtl, null, 0, 0, 0, 0, fmi, true));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return handleRun(start, offset, limit, runIsRtl, null, 0, 0, 0, 0, fmi, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.691 -0400", hash_original_method = "4BDB20A2184F91CDB9542314BD3E47CD", hash_generated_method = "19EA5B70C4DFFBE166CBEF493B69A073")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getOffsetToLeftRightOf(int cursor, boolean toLeft) {
        dsTaint.addTaint(cursor);
        dsTaint.addTaint(toLeft);
        int lineStart;
        lineStart = 0;
        int lineEnd;
        lineEnd = mLen;
        boolean paraIsRtl;
        paraIsRtl = mDir == -1;
        int[] runs;
        runs = mDirections.mDirections;
        int runIndex, runLevel, runStart, runLimit, newCaret;
        runLevel = 0;
        runStart = lineStart;
        runLimit = lineEnd;
        newCaret = -1;
        boolean trailing;
        trailing = false;
        {
            runIndex = -2;
        } //End block
        {
            runIndex = runs.length;
        } //End block
        {
            {
                runIndex = 0;
                runIndex += 2;
                {
                    runStart = lineStart + runs[runIndex];
                    {
                        runLimit = runStart + (runs[runIndex+1] & Layout.RUN_LENGTH_MASK);
                        {
                            runLimit = lineEnd;
                        } //End block
                        {
                            runLevel = (runs[runIndex+1] >>> Layout.RUN_LEVEL_SHIFT) &
                    Layout.RUN_LEVEL_MASK;
                            {
                                int prevRunIndex, prevRunLevel, prevRunStart, prevRunLimit;
                                int pos;
                                pos = cursor - 1;
                                {
                                    prevRunIndex = 0;
                                    prevRunIndex += 2;
                                    {
                                        prevRunStart = lineStart + runs[prevRunIndex];
                                        {
                                            prevRunLimit = prevRunStart +
                          (runs[prevRunIndex+1] & Layout.RUN_LENGTH_MASK);
                                            {
                                                prevRunLimit = lineEnd;
                                            } //End block
                                            {
                                                prevRunLevel = (runs[prevRunIndex+1] >>> Layout.RUN_LEVEL_SHIFT)
                            & Layout.RUN_LEVEL_MASK;
                                                {
                                                    runIndex = prevRunIndex;
                                                    runLevel = prevRunLevel;
                                                    runStart = prevRunStart;
                                                    runLimit = prevRunLimit;
                                                    trailing = true;
                                                } //End block
                                            } //End block
                                        } //End block
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                boolean runIsRtl;
                runIsRtl = (runLevel & 0x1) != 0;
                boolean advance;
                advance = toLeft == runIsRtl;
                {
                    newCaret = getOffsetBeforeAfter(runIndex, runStart, runLimit,
                          runIsRtl, cursor, advance);
                } //End block
            } //End block
        } //End block
        {
            boolean advance;
            advance = toLeft == paraIsRtl;
            int otherRunIndex;
            otherRunIndex = runIndex + (advance ? 2 : -2);//DSFIXME:  CODE0008: Nested ternary operator in expression
            {
                int otherRunStart;
                otherRunStart = lineStart + runs[otherRunIndex];
                int otherRunLimit;
                otherRunLimit = otherRunStart +
            (runs[otherRunIndex+1] & Layout.RUN_LENGTH_MASK);
                {
                    otherRunLimit = lineEnd;
                } //End block
                int otherRunLevel;
                otherRunLevel = (runs[otherRunIndex+1] >>> Layout.RUN_LEVEL_SHIFT) &
                Layout.RUN_LEVEL_MASK;
                boolean otherRunIsRtl;
                otherRunIsRtl = (otherRunLevel & 1) != 0;
                advance = toLeft == otherRunIsRtl;
                {
                    newCaret = getOffsetBeforeAfter(otherRunIndex, otherRunStart,
                        otherRunLimit, otherRunIsRtl,
                        advance ? otherRunStart : otherRunLimit, advance);
                    {
                        runIndex = otherRunIndex;
                        runLevel = otherRunLevel;
                    } //End block
                } //End block
                {
                    newCaret = advance ? otherRunStart : otherRunLimit;
                } //End block
            } //End block
            {
                newCaret = advance ? mLen + 1 : -1;
            } //End block
            {
                newCaret = advance ? lineEnd : lineStart;
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.692 -0400", hash_original_method = "31252F4808C2C77A1E467D2963FB3AD5", hash_generated_method = "D6F62A56885E8EFF1FA180486DDB3B8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getOffsetBeforeAfter(int runIndex, int runStart, int runLimit,
            boolean runIsRtl, int offset, boolean after) {
        dsTaint.addTaint(after);
        dsTaint.addTaint(runStart);
        dsTaint.addTaint(runLimit);
        dsTaint.addTaint(runIndex);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(runIsRtl);
        {
            {
                int var23A42F19460B2B1B4F7650C079142539_1703584668 = (TextUtils.getOffsetAfter(mText, offset + mStart) - mStart);
            } //End block
            int var878CE411BC90821D83BAFC7D86E8759C_1020479375 = (TextUtils.getOffsetBefore(mText, offset + mStart) - mStart);
        } //End block
        TextPaint wp;
        wp = mWorkPaint;
        wp.set(mPaint);
        int spanStart;
        spanStart = runStart;
        int spanLimit;
        {
            spanLimit = runLimit;
        } //End block
        {
            int target;
            target = offset + 1;
            target = offset;
            int limit;
            limit = mStart + runLimit;
            {
                spanLimit = mSpanned.nextSpanTransition(mStart + spanStart, limit,
                        MetricAffectingSpan.class) - mStart;
                spanStart = spanLimit;
            } //End block
            MetricAffectingSpan[] spans;
            spans = mSpanned.getSpans(mStart + spanStart,
                    mStart + spanLimit, MetricAffectingSpan.class);
            spans = TextUtils.removeEmptySpans(spans, mSpanned, MetricAffectingSpan.class);
            {
                ReplacementSpan replacement;
                replacement = null;
                {
                    int j;
                    j = 0;
                    {
                        MetricAffectingSpan span;
                        span = spans[j];
                        {
                            replacement = (ReplacementSpan)span;
                        } //End block
                        {
                            span.updateMeasureState(wp);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        int flags;
        flags = Paint.DIRECTION_RTL;
        flags = Paint.DIRECTION_LTR;
        int cursorOpt;
        cursorOpt = Paint.CURSOR_AFTER;
        cursorOpt = Paint.CURSOR_BEFORE;
        {
            int var8A46B054A3BF4BE20F28D574CADE0515_1926822767 = (wp.getTextRunCursor(mChars, spanStart, spanLimit - spanStart,
                    flags, offset, cursorOpt));
        } //End block
        {
            int var2C1A4A7C8DBA63FC4B3CC76C9F155C03_435454101 = (wp.getTextRunCursor(mText, mStart + spanStart,
                    mStart + spanLimit, flags, mStart + offset, cursorOpt) - mStart);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void expandMetricsFromPaint(FontMetricsInt fmi, TextPaint wp) {
        final int previousTop     = fmi.top;
        final int previousAscent  = fmi.ascent;
        final int previousDescent = fmi.descent;
        final int previousBottom  = fmi.bottom;
        final int previousLeading = fmi.leading;
        wp.getFontMetricsInt(fmi);
        updateMetrics(fmi, previousTop, previousAscent, previousDescent, previousBottom,
                previousLeading);
    }

    
        static void updateMetrics(FontMetricsInt fmi, int previousTop, int previousAscent,
            int previousDescent, int previousBottom, int previousLeading) {
        fmi.top     = Math.min(fmi.top,     previousTop);
        fmi.ascent  = Math.min(fmi.ascent,  previousAscent);
        fmi.descent = Math.max(fmi.descent, previousDescent);
        fmi.bottom  = Math.max(fmi.bottom,  previousBottom);
        fmi.leading = Math.max(fmi.leading, previousLeading);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.694 -0400", hash_original_method = "F8AC228F4E44CF9CD673B1404700AC77", hash_generated_method = "9B98ECED3219AFCB600B88C4BC9AA2F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float handleText(TextPaint wp, int start, int end,
            int contextStart, int contextEnd, boolean runIsRtl,
            Canvas c, float x, int top, int y, int bottom,
            FontMetricsInt fmi, boolean needWidth) {
        dsTaint.addTaint(needWidth);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(start);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(wp.dsTaint);
        dsTaint.addTaint(fmi.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(end);
        dsTaint.addTaint(top);
        dsTaint.addTaint(x);
        dsTaint.addTaint(runIsRtl);
        dsTaint.addTaint(contextEnd);
        {
            expandMetricsFromPaint(fmi, wp);
        } //End block
        int runLen;
        runLen = end - start;
        float ret;
        ret = 0;
        int contextLen;
        contextLen = contextEnd - contextStart;
        {
            int flags;
            flags = Paint.DIRECTION_RTL;
            flags = Paint.DIRECTION_LTR;
            {
                ret = wp.getTextRunAdvances(mChars, start, runLen,
                        contextStart, contextLen, flags, null, 0);
            } //End block
            {
                int delta;
                delta = mStart;
                ret = wp.getTextRunAdvances(mText, delta + start,
                        delta + end, delta + contextStart, delta + contextEnd,
                        flags, null, 0);
            } //End block
        } //End block
        {
            {
                x -= ret;
            } //End block
            {
                int previousColor;
                previousColor = wp.getColor();
                Paint.Style previousStyle;
                previousStyle = wp.getStyle();
                wp.setColor(wp.bgColor);
                wp.setStyle(Paint.Style.FILL);
                c.drawRect(x, top, x + ret, bottom, wp);
                wp.setStyle(previousStyle);
                wp.setColor(previousColor);
            } //End block
            {
                float underlineTop;
                underlineTop = y + wp.baselineShift + (1.0f / 9.0f) * wp.getTextSize();
                int previousColor;
                previousColor = wp.getColor();
                Paint.Style previousStyle;
                previousStyle = wp.getStyle();
                boolean previousAntiAlias;
                previousAntiAlias = wp.isAntiAlias();
                wp.setStyle(Paint.Style.FILL);
                wp.setAntiAlias(true);
                wp.setColor(wp.underlineColor);
                c.drawRect(x, underlineTop, x + ret, underlineTop + wp.underlineThickness, wp);
                wp.setStyle(previousStyle);
                wp.setColor(previousColor);
                wp.setAntiAlias(previousAntiAlias);
            } //End block
            drawTextRun(c, wp, start, end, contextStart, contextEnd, runIsRtl,
                    x, y + wp.baselineShift);
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.695 -0400", hash_original_method = "5BB6CBCB4177EDC48B270A42A6989FB0", hash_generated_method = "C20C6B600F700D010065303A94FABE08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float handleReplacement(ReplacementSpan replacement, TextPaint wp,
            int start, int limit, boolean runIsRtl, Canvas c,
            float x, int top, int y, int bottom, FontMetricsInt fmi,
            boolean needWidth) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(replacement.dsTaint);
        dsTaint.addTaint(needWidth);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(wp.dsTaint);
        dsTaint.addTaint(fmi.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(top);
        dsTaint.addTaint(x);
        dsTaint.addTaint(runIsRtl);
        float ret;
        ret = 0;
        int textStart;
        textStart = mStart + start;
        int textLimit;
        textLimit = mStart + limit;
        {
            int previousTop;
            previousTop = 0;
            int previousAscent;
            previousAscent = 0;
            int previousDescent;
            previousDescent = 0;
            int previousBottom;
            previousBottom = 0;
            int previousLeading;
            previousLeading = 0;
            boolean needUpdateMetrics;
            needUpdateMetrics = (fmi != null);
            {
                previousTop     = fmi.top;
                previousAscent  = fmi.ascent;
                previousDescent = fmi.descent;
                previousBottom  = fmi.bottom;
                previousLeading = fmi.leading;
            } //End block
            ret = replacement.getSize(wp, mText, textStart, textLimit, fmi);
            {
                updateMetrics(fmi, previousTop, previousAscent, previousDescent, previousBottom,
                        previousLeading);
            } //End block
        } //End block
        {
            {
                x -= ret;
            } //End block
            replacement.draw(c, mText, textStart, textLimit,
                    x, top, y, bottom, wp);
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.696 -0400", hash_original_method = "5FABB9B94E4E730AC35956B01320E35B", hash_generated_method = "37896DF4A45BE87F1B0E4E5F4009CDD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float handleRun(int start, int measureLimit,
            int limit, boolean runIsRtl, Canvas c, float x, int top, int y,
            int bottom, FontMetricsInt fmi, boolean needWidth) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(measureLimit);
        dsTaint.addTaint(needWidth);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(fmi.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(top);
        dsTaint.addTaint(x);
        dsTaint.addTaint(runIsRtl);
        {
            TextPaint wp;
            wp = mWorkPaint;
            wp.set(mPaint);
            {
                expandMetricsFromPaint(fmi, wp);
            } //End block
        } //End block
        {
            TextPaint wp;
            wp = mWorkPaint;
            wp.set(mPaint);
            int mlimit;
            mlimit = measureLimit;
            float var34AF167EDF1314E69A7451FFECC8AC0B_1514040082 = (handleText(wp, start, mlimit, start, limit, runIsRtl, c, x, top,
                    y, bottom, fmi, needWidth || mlimit < measureLimit));
        } //End block
        mMetricAffectingSpanSpanSet.init(mSpanned, mStart + start, mStart + limit);
        mCharacterStyleSpanSet.init(mSpanned, mStart + start, mStart + limit);
        float originalX;
        originalX = x;
        {
            int i, inext;
            i = start;
            i = inext;
            {
                TextPaint wp;
                wp = mWorkPaint;
                wp.set(mPaint);
                inext = mMetricAffectingSpanSpanSet.getNextTransition(mStart + i, mStart + limit) -
                    mStart;
                int mlimit;
                mlimit = Math.min(inext, measureLimit);
                ReplacementSpan replacement;
                replacement = null;
                {
                    int j;
                    j = 0;
                    {
                        MetricAffectingSpan span;
                        span = mMetricAffectingSpanSpanSet.spans[j];
                        {
                            replacement = (ReplacementSpan)span;
                        } //End block
                        {
                            span.updateDrawState(wp);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                {
                    x += handleReplacement(replacement, wp, i, mlimit, runIsRtl, c, x, top, y,
                        bottom, fmi, needWidth || mlimit < measureLimit);
                } //End block
                {
                    x += handleText(wp, i, mlimit, i, inext, runIsRtl, c, x, top,
                        y, bottom, fmi, needWidth || mlimit < measureLimit);
                } //End block
                {
                    {
                        int j, jnext;
                        j = i;
                        j = jnext;
                        {
                            jnext = mCharacterStyleSpanSet.getNextTransition(mStart + j, mStart + mlimit) -
                            mStart;
                            wp.set(mPaint);
                            {
                                int k;
                                k = 0;
                                {
                                    CharacterStyle span;
                                    span = mCharacterStyleSpanSet.spans[k];
                                    span.updateDrawState(wp);
                                } //End block
                            } //End collapsed parenthetic
                            x += handleText(wp, j, jnext, i, inext, runIsRtl, c, x,
                            top, y, bottom, fmi, needWidth || jnext < measureLimit);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.696 -0400", hash_original_method = "C8ABF2DC6B89611B840AEC4DBAADD344", hash_generated_method = "1F47C897C4D4A6C31EA5AA56BFD96213")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void drawTextRun(Canvas c, TextPaint wp, int start, int end,
            int contextStart, int contextEnd, boolean runIsRtl, float x, int y) {
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(start);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(wp.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(end);
        dsTaint.addTaint(x);
        dsTaint.addTaint(runIsRtl);
        dsTaint.addTaint(contextEnd);
        int flags;
        flags = Canvas.DIRECTION_RTL;
        flags = Canvas.DIRECTION_LTR;
        {
            int count;
            count = end - start;
            int contextCount;
            contextCount = contextEnd - contextStart;
            c.drawTextRun(mChars, start, count, contextStart, contextCount,
                    x, y, flags, wp);
        } //End block
        {
            int delta;
            delta = mStart;
            c.drawTextRun(mText, delta + start, delta + end,
                    delta + contextStart, delta + contextEnd, x, y, flags, wp);
        } //End block
        // ---------- Original Method ----------
        //int flags = runIsRtl ? Canvas.DIRECTION_RTL : Canvas.DIRECTION_LTR;
        //if (mCharsValid) {
            //int count = end - start;
            //int contextCount = contextEnd - contextStart;
            //c.drawTextRun(mChars, start, count, contextStart, contextCount,
                    //x, y, flags, wp);
        //} else {
            //int delta = mStart;
            //c.drawTextRun(mText, delta + start, delta + end,
                    //delta + contextStart, delta + contextEnd, x, y, flags, wp);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.702 -0400", hash_original_method = "AC74D3C7A92A1C0DA8A76C86F50D3219", hash_generated_method = "77EE181701E1F06FA4C6AC8E3BBD41F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     float ascent(int pos) {
        dsTaint.addTaint(pos);
        {
            float var3BDF3A2D03302BACAD807FFE6B0D6A91_1378011253 = (mPaint.ascent());
        } //End block
        pos += mStart;
        MetricAffectingSpan[] spans;
        spans = mSpanned.getSpans(pos, pos + 1, MetricAffectingSpan.class);
        {
            float var3BDF3A2D03302BACAD807FFE6B0D6A91_241803501 = (mPaint.ascent());
        } //End block
        TextPaint wp;
        wp = mWorkPaint;
        wp.set(mPaint);
        {
            MetricAffectingSpan span = spans[0];
            {
                span.updateMeasureState(wp);
            } //End block
        } //End collapsed parenthetic
        float var5DC50654BD2E08B78A3F0BF6159A6A3E_1204485502 = (wp.ascent());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //if (mSpanned == null) {
            //return mPaint.ascent();
        //}
        //pos += mStart;
        //MetricAffectingSpan[] spans = mSpanned.getSpans(pos, pos + 1, MetricAffectingSpan.class);
        //if (spans.length == 0) {
            //return mPaint.ascent();
        //}
        //TextPaint wp = mWorkPaint;
        //wp.set(mPaint);
        //for (MetricAffectingSpan span : spans) {
            //span.updateMeasureState(wp);
        //}
        //return wp.ascent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.702 -0400", hash_original_method = "73134044CD530D6AE99976E01BA5E625", hash_generated_method = "6C2833A915EB8F277B1613FDDDE027F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     float nextTab(float h) {
        dsTaint.addTaint(h);
        {
            float varBC64F150694F74B7C25309A0AEC4E154_684718852 = (mTabs.nextTab(h));
        } //End block
        float varC96F42CCA3E3E5F25C19ACBABD69AED1_232185226 = (TabStops.nextDefaultStop(h, TAB_INCREMENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //if (mTabs != null) {
            //return mTabs.nextTab(h);
        //}
        //return TabStops.nextDefaultStop(h, TAB_INCREMENT);
    }

    
    private static class SpanSet<E> {
        int numberOfSpans;
        E[] spans;
        int[] spanStarts;
        int[] spanEnds;
        int[] spanFlags;
        Class<? extends E> classType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.703 -0400", hash_original_method = "08793871E7FAA5C02A5C5115CBB016E1", hash_generated_method = "24A1274092E4AC2262B30B7620253A84")
        @DSModeled(DSC.SAFE)
         SpanSet(Class<? extends E> type) {
            dsTaint.addTaint(type.dsTaint);
            numberOfSpans = 0;
            // ---------- Original Method ----------
            //classType = type;
            //numberOfSpans = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.704 -0400", hash_original_method = "DCBC67B7023E3760B724E28392339389", hash_generated_method = "667F34C74D31AF9449978AC5A2C39CE8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        public void init(Spanned spanned, int start, int limit) {
            dsTaint.addTaint(limit);
            dsTaint.addTaint(start);
            dsTaint.addTaint(spanned.dsTaint);
            E[] allSpans;
            allSpans = spanned.getSpans(start, limit, classType);
            int length;
            length = allSpans.length;
            {
                spans = (E[]) Array.newInstance(classType, length);
                spanStarts = new int[length];
                spanEnds = new int[length];
                spanFlags = new int[length];
            } //End block
            numberOfSpans = 0;
            {
                int i;
                i = 0;
                {
                    E span;
                    span = allSpans[i];
                    int spanStart;
                    spanStart = spanned.getSpanStart(span);
                    int spanEnd;
                    spanEnd = spanned.getSpanEnd(span);
                    int spanFlag;
                    spanFlag = spanned.getSpanFlags(span);
                    spans[numberOfSpans] = span;
                    spanStarts[numberOfSpans] = spanStart;
                    spanEnds[numberOfSpans] = spanEnd;
                    spanFlags[numberOfSpans] = spanFlag;
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.704 -0400", hash_original_method = "14C2C64E52F272A1D061AF5FA0B61C4E", hash_generated_method = "7C0349A7928E0919AA92BBCEAE960352")
        @DSModeled(DSC.SAFE)
        public boolean hasSpansIntersecting(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            {
                int i;
                i = 0;
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //for (int i = 0; i < numberOfSpans; i++) {
                //if (spanStarts[i] >= end || spanEnds[i] <= start) continue;
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.704 -0400", hash_original_method = "70A36A49F9CEFC761501124E36FC2A8C", hash_generated_method = "E9AAA4CEEA550A72F64F33872DE19DC3")
        @DSModeled(DSC.SAFE)
         int getNextTransition(int start, int limit) {
            dsTaint.addTaint(limit);
            dsTaint.addTaint(start);
            {
                int i;
                i = 0;
                {
                    int spanStart;
                    spanStart = spanStarts[i];
                    int spanEnd;
                    spanEnd = spanEnds[i];
                    limit = spanStart;
                    limit = spanEnd;
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //for (int i = 0; i < numberOfSpans; i++) {
                //final int spanStart = spanStarts[i];
                //final int spanEnd = spanEnds[i];
                //if (spanStart > start && spanStart < limit) limit = spanStart;
                //if (spanEnd > start && spanEnd < limit) limit = spanEnd;
            //}
            //return limit;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.705 -0400", hash_original_method = "5E840A260140B15B0CFAF6F2BC649D6A", hash_generated_method = "82ECDD7493004F7E502A43C80ABA9546")
        @DSModeled(DSC.SAFE)
        public void recycle() {
            {
                int i;
                i = 0;
                {
                    spans[i] = null;
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //for (int i = 0; i < numberOfSpans; i++) {
                //spans[i] = null; 
            //}
        }

        
    }


    
    private static final boolean DEBUG = false;
    private static final TextLine[] sCached = new TextLine[3];
    private static final int TAB_INCREMENT = 20;
}

