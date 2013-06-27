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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.103 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "B5BC396C7010734D6B4B6ED34A2846AE")

    private TextPaint mPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.103 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "E579ED9F2DADADEB46C981CAFDEE5BA5")

    private CharSequence mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.103 -0400", hash_original_field = "59B50EB80ABF1071654EE6DE5094E070", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")

    private int mStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.103 -0400", hash_original_field = "B74CDC798B150A72FBFBFAE7161611A0", hash_generated_field = "8D921BC08EBCA74A32B1247B1F91B368")

    private int mLen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.103 -0400", hash_original_field = "90B0D92F580EFEB979A78726B5A06046", hash_generated_field = "9463565EC19B0C28E47B4A05A883AACE")

    private int mDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.103 -0400", hash_original_field = "C5BE317E362FA3A0C2C3E5FEF24D93D8", hash_generated_field = "0120B57883F4A0FE4FFD7BC1C988B792")

    private Directions mDirections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.103 -0400", hash_original_field = "E7A53C004C81753F95BE5F68EF660B93", hash_generated_field = "D9EB8682A57605E85FDF7A8921E6278B")

    private boolean mHasTabs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.103 -0400", hash_original_field = "EED8301AA8AD4216C74243E84473677E", hash_generated_field = "D70B7E9717C627B10CB1103D367577AF")

    private TabStops mTabs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.103 -0400", hash_original_field = "7C3722E3CD3CCC07C587A93513F1BB79", hash_generated_field = "20B8558AB5FD0F0B5A30B95221D68246")

    private char[] mChars;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.103 -0400", hash_original_field = "4F9D254B1CD5044B69FC994E7FDA4BC0", hash_generated_field = "24C6EE5653AF991EF0187B60742148D2")

    private boolean mCharsValid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.103 -0400", hash_original_field = "2A174ADD3219E7DC0B72155FF67EC4B5", hash_generated_field = "69C78554F8ABB9B2C492FD314F3ED2EE")

    private Spanned mSpanned;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.103 -0400", hash_original_field = "5ECEFF774471811D388DC8B2E7A3678F", hash_generated_field = "4B5596A3EF77CDA86765E17E911585F5")

    private TextPaint mWorkPaint = new TextPaint();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.104 -0400", hash_original_field = "BA01C06D7D2C16D8DA15CBC211855B17", hash_generated_field = "BBB2B37BC9E6289A31F99A0503F2307C")

    private SpanSet<MetricAffectingSpan> mMetricAffectingSpanSpanSet = new SpanSet<MetricAffectingSpan>(MetricAffectingSpan.class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.104 -0400", hash_original_field = "AA4FF336748C12C296D546DCB9F5F762", hash_generated_field = "B824A8ABA253383A1245B9FA673A18BA")

    private SpanSet<CharacterStyle> mCharacterStyleSpanSet = new SpanSet<CharacterStyle>(CharacterStyle.class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.104 -0400", hash_original_field = "3DD162648ABDCE69032EE3F02E2B56F1", hash_generated_field = "38B746E7D301B51A499147E84BB205A8")

    private SpanSet<ReplacementSpan> mReplacementSpanSpanSet = new SpanSet<ReplacementSpan>(ReplacementSpan.class);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.104 -0400", hash_original_method = "2FAB193CBF90842ECB23B93C34526440", hash_generated_method = "2FAB193CBF90842ECB23B93C34526440")
    public TextLine ()
    {
        //Synthesized constructor
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.123 -0400", hash_original_method = "38DB7B0D381033DA01F9181167C14361", hash_generated_method = "9B2FFA272DC758AA9D66A313D7188389")
     void set(TextPaint paint, CharSequence text, int start, int limit, int dir,
            Directions directions, boolean hasTabs, TabStops tabStops) {
        mPaint = paint;
        mText = text;
        mStart = start;
        mLen = limit - start;
        mDir = dir;
        mDirections = directions;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Directions cannot be null");
        } //End block
        mHasTabs = hasTabs;
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
                            boolean var9A0647084190D1C8B24B12E654D855A5_1840794551 = (mReplacementSpanSpanSet.hasSpansIntersecting(i, inext));
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
        mTabs = tabStops;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.134 -0400", hash_original_method = "20A60861C26C58A53A0282FABD9ED153", hash_generated_method = "8D6991A0B624BB5961E93B3F5BB89976")
     void draw(Canvas c, float x, int top, int y, int bottom) {
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
        addTaint(c.getTaint());
        addTaint(x);
        addTaint(top);
        addTaint(y);
        addTaint(bottom);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.142 -0400", hash_original_method = "7F5367E991A6BC7E9EDD55CA9BF0FBE6", hash_generated_method = "12A25E17E453F1D65F3229B617890584")
     float metrics(FontMetricsInt fmi) {
        float var819434D16349BB2DC69F34C4834A5D61_631463456 = (measure(mLen, false, fmi));
        addTaint(fmi.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_974986159 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_974986159;
        // ---------- Original Method ----------
        //return measure(mLen, false, fmi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.147 -0400", hash_original_method = "5986320AFF9EF780E7B17B08599A90A9", hash_generated_method = "B5DF791C01D97F890B500C79325383E5")
     float measure(int offset, boolean trailing, FontMetricsInt fmi) {
        int target;
        target = offset - 1;
        target = offset;
        float h;
        h = 0;
        {
            {
                float var6DBB5A12B291F41A1B8183C9E3967A7F_1046370921 = (measureRun(0, offset, mLen, false, fmi));
            } //End block
            {
                float varAF7F0B660DD98ED2707F73909AA41E03_1345584013 = (measureRun(0, offset, mLen, true, fmi));
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
                                float varEAD76BB4ECB5BC510C30780AC9415C1A_1994521832 = (h += measureRun(segstart, offset, j, runIsRtl, fmi));
                            } //End block
                            float w;
                            w = measureRun(segstart, j, j, runIsRtl, fmi);
                            h += advance ? w : -w;
                            {
                                float var156DB9BDC3E26545D8938CCB69603D57_88415356 = (h += measureRun(segstart, offset, j, runIsRtl, null));
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
        addTaint(offset);
        addTaint(trailing);
        addTaint(fmi.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_60628712 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_60628712;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.148 -0400", hash_original_method = "1E01EF0F20C48DC869D8591ACBCB40DD", hash_generated_method = "0955EA5BFE793A3593478C7EBC41EF70")
    private float drawRun(Canvas c, int start,
            int limit, boolean runIsRtl, float x, int top, int y, int bottom,
            boolean needWidth) {
        {
            float w;
            w = -measureRun(start, limit, limit, runIsRtl, null);
            handleRun(start, limit, limit, runIsRtl, c, x + w, top,
                    y, bottom, null, false);
        } //End block
        float var2B269E7D5B38EDA34EF7FCBB54724505_2034062124 = (handleRun(start, limit, limit, runIsRtl, c, x, top,
                y, bottom, null, needWidth));
        addTaint(c.getTaint());
        addTaint(start);
        addTaint(limit);
        addTaint(runIsRtl);
        addTaint(x);
        addTaint(top);
        addTaint(y);
        addTaint(bottom);
        addTaint(needWidth);
        float var546ADE640B6EDFBC8A086EF31347E768_2102933021 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2102933021;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.170 -0400", hash_original_method = "92FB3641FED625E21CE916EA375B8557", hash_generated_method = "E0EB44C87DB2C500E70F30BE8CDE6AE9")
    private float measureRun(int start, int offset, int limit, boolean runIsRtl,
            FontMetricsInt fmi) {
        float var97D1A4BD409768E6336775867B4BED96_1777692118 = (handleRun(start, offset, limit, runIsRtl, null, 0, 0, 0, 0, fmi, true));
        addTaint(start);
        addTaint(offset);
        addTaint(limit);
        addTaint(runIsRtl);
        addTaint(fmi.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_358989648 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_358989648;
        // ---------- Original Method ----------
        //return handleRun(start, offset, limit, runIsRtl, null, 0, 0, 0, 0, fmi, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.173 -0400", hash_original_method = "4BDB20A2184F91CDB9542314BD3E47CD", hash_generated_method = "6442FC0928B9A5BC1EB92BEA8C2D487E")
     int getOffsetToLeftRightOf(int cursor, boolean toLeft) {
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
        addTaint(cursor);
        addTaint(toLeft);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1376263720 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1376263720;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.188 -0400", hash_original_method = "31252F4808C2C77A1E467D2963FB3AD5", hash_generated_method = "46E03E1A319AD9823BBCAD87C4D8D855")
    private int getOffsetBeforeAfter(int runIndex, int runStart, int runLimit,
            boolean runIsRtl, int offset, boolean after) {
        {
            {
                int var23A42F19460B2B1B4F7650C079142539_108186153 = (TextUtils.getOffsetAfter(mText, offset + mStart) - mStart);
            } //End block
            int var878CE411BC90821D83BAFC7D86E8759C_1365769182 = (TextUtils.getOffsetBefore(mText, offset + mStart) - mStart);
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
            int var8A46B054A3BF4BE20F28D574CADE0515_556663416 = (wp.getTextRunCursor(mChars, spanStart, spanLimit - spanStart,
                    flags, offset, cursorOpt));
        } //End block
        {
            int var2C1A4A7C8DBA63FC4B3CC76C9F155C03_131259541 = (wp.getTextRunCursor(mText, mStart + spanStart,
                    mStart + spanLimit, flags, mStart + offset, cursorOpt) - mStart);
        } //End block
        addTaint(runIndex);
        addTaint(runStart);
        addTaint(runLimit);
        addTaint(runIsRtl);
        addTaint(offset);
        addTaint(after);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1819041126 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1819041126;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.203 -0400", hash_original_method = "F8AC228F4E44CF9CD673B1404700AC77", hash_generated_method = "4F72555C485E0581E2FB653E8752E93C")
    private float handleText(TextPaint wp, int start, int end,
            int contextStart, int contextEnd, boolean runIsRtl,
            Canvas c, float x, int top, int y, int bottom,
            FontMetricsInt fmi, boolean needWidth) {
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
        addTaint(wp.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(contextStart);
        addTaint(contextEnd);
        addTaint(runIsRtl);
        addTaint(c.getTaint());
        addTaint(x);
        addTaint(top);
        addTaint(y);
        addTaint(bottom);
        addTaint(fmi.getTaint());
        addTaint(needWidth);
        float var546ADE640B6EDFBC8A086EF31347E768_730746212 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_730746212;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.211 -0400", hash_original_method = "5BB6CBCB4177EDC48B270A42A6989FB0", hash_generated_method = "C2B87D83799777BE39F3FEA539F0068A")
    private float handleReplacement(ReplacementSpan replacement, TextPaint wp,
            int start, int limit, boolean runIsRtl, Canvas c,
            float x, int top, int y, int bottom, FontMetricsInt fmi,
            boolean needWidth) {
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
        addTaint(replacement.getTaint());
        addTaint(wp.getTaint());
        addTaint(start);
        addTaint(limit);
        addTaint(runIsRtl);
        addTaint(c.getTaint());
        addTaint(x);
        addTaint(top);
        addTaint(y);
        addTaint(bottom);
        addTaint(fmi.getTaint());
        addTaint(needWidth);
        float var546ADE640B6EDFBC8A086EF31347E768_835782184 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_835782184;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.227 -0400", hash_original_method = "5FABB9B94E4E730AC35956B01320E35B", hash_generated_method = "5B8DD03D48E35B6A00142443316B80C6")
    private float handleRun(int start, int measureLimit,
            int limit, boolean runIsRtl, Canvas c, float x, int top, int y,
            int bottom, FontMetricsInt fmi, boolean needWidth) {
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
            float var34AF167EDF1314E69A7451FFECC8AC0B_2069269057 = (handleText(wp, start, mlimit, start, limit, runIsRtl, c, x, top,
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
        addTaint(start);
        addTaint(measureLimit);
        addTaint(limit);
        addTaint(runIsRtl);
        addTaint(c.getTaint());
        addTaint(x);
        addTaint(top);
        addTaint(y);
        addTaint(bottom);
        addTaint(fmi.getTaint());
        addTaint(needWidth);
        float var546ADE640B6EDFBC8A086EF31347E768_2043169637 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2043169637;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.243 -0400", hash_original_method = "C8ABF2DC6B89611B840AEC4DBAADD344", hash_generated_method = "86478A549C8A74AA9738F73284BD27C8")
    private void drawTextRun(Canvas c, TextPaint wp, int start, int end,
            int contextStart, int contextEnd, boolean runIsRtl, float x, int y) {
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
        addTaint(c.getTaint());
        addTaint(wp.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(contextStart);
        addTaint(contextEnd);
        addTaint(runIsRtl);
        addTaint(x);
        addTaint(y);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.375 -0400", hash_original_method = "AC74D3C7A92A1C0DA8A76C86F50D3219", hash_generated_method = "832BA933BC2C342DD648912ED30D82CB")
     float ascent(int pos) {
        {
            float var3BDF3A2D03302BACAD807FFE6B0D6A91_695950593 = (mPaint.ascent());
        } //End block
        pos += mStart;
        MetricAffectingSpan[] spans;
        spans = mSpanned.getSpans(pos, pos + 1, MetricAffectingSpan.class);
        {
            float var3BDF3A2D03302BACAD807FFE6B0D6A91_1025279718 = (mPaint.ascent());
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
        float var5DC50654BD2E08B78A3F0BF6159A6A3E_1619354170 = (wp.ascent());
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_423890233 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_423890233;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.376 -0400", hash_original_method = "73134044CD530D6AE99976E01BA5E625", hash_generated_method = "0A55A699A1AE3BC741E96ACA6A0FD395")
     float nextTab(float h) {
        {
            float varBC64F150694F74B7C25309A0AEC4E154_909692959 = (mTabs.nextTab(h));
        } //End block
        float varC96F42CCA3E3E5F25C19ACBABD69AED1_1149353361 = (TabStops.nextDefaultStop(h, TAB_INCREMENT));
        addTaint(h);
        float var546ADE640B6EDFBC8A086EF31347E768_981983632 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_981983632;
        // ---------- Original Method ----------
        //if (mTabs != null) {
            //return mTabs.nextTab(h);
        //}
        //return TabStops.nextDefaultStop(h, TAB_INCREMENT);
    }

    
    private static class SpanSet<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.376 -0400", hash_original_field = "D6B5FCDB35353F6A4017F11EBD647D09", hash_generated_field = "4D016F914E51DC9C3732F557E45EB452")

        int numberOfSpans;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.377 -0400", hash_original_field = "A46EFC2A2782C9238263F63F5CEA5D42", hash_generated_field = "32FCADE2328772A5D81411E0AA303B75")

        E[] spans;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.377 -0400", hash_original_field = "C24BD1BD2949B9599EEDD7F0387EE723", hash_generated_field = "1D3712C585C8808C22172D42F4D7BB90")

        int[] spanStarts;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.377 -0400", hash_original_field = "0502422B326B747A365D76C9CCE8E955", hash_generated_field = "8ED878CF75FF4569DFB3C4F0CC5B72F1")

        int[] spanEnds;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.377 -0400", hash_original_field = "6612E29FBDE8178CC4AD5176D3C8A9E6", hash_generated_field = "2E2862EF6D4B111BA84644CB0E9CD297")

        int[] spanFlags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.377 -0400", hash_original_field = "A69F0373B093A535ADB7C9273781CD43", hash_generated_field = "7DE61887E85E1CD432AAA8825CCFB81E")

        Class<? extends E> classType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.389 -0400", hash_original_method = "08793871E7FAA5C02A5C5115CBB016E1", hash_generated_method = "7A2C4BAA57A8D03BA9484E8C2D4BDD35")
          SpanSet(Class<? extends E> type) {
            classType = type;
            numberOfSpans = 0;
            // ---------- Original Method ----------
            //classType = type;
            //numberOfSpans = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.391 -0400", hash_original_method = "DCBC67B7023E3760B724E28392339389", hash_generated_method = "DCD7EEA6BDB7B36B921C6B961A48FBB9")
        @SuppressWarnings("unchecked")
        public void init(Spanned spanned, int start, int limit) {
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
            addTaint(spanned.getTaint());
            addTaint(start);
            addTaint(limit);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.392 -0400", hash_original_method = "14C2C64E52F272A1D061AF5FA0B61C4E", hash_generated_method = "DEF28136AEC3475BD93D421BFB909A2F")
        public boolean hasSpansIntersecting(int start, int end) {
            {
                int i;
                i = 0;
            } //End collapsed parenthetic
            addTaint(start);
            addTaint(end);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1315945513 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1315945513;
            // ---------- Original Method ----------
            //for (int i = 0; i < numberOfSpans; i++) {
                //if (spanStarts[i] >= end || spanEnds[i] <= start) continue;
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.392 -0400", hash_original_method = "70A36A49F9CEFC761501124E36FC2A8C", hash_generated_method = "82EB325A093FDE085E6352D52EB12756")
         int getNextTransition(int start, int limit) {
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
            addTaint(start);
            addTaint(limit);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1435107703 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1435107703;
            // ---------- Original Method ----------
            //for (int i = 0; i < numberOfSpans; i++) {
                //final int spanStart = spanStarts[i];
                //final int spanEnd = spanEnds[i];
                //if (spanStart > start && spanStart < limit) limit = spanStart;
                //if (spanEnd > start && spanEnd < limit) limit = spanEnd;
            //}
            //return limit;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.404 -0400", hash_original_method = "5E840A260140B15B0CFAF6F2BC649D6A", hash_generated_method = "82ECDD7493004F7E502A43C80ABA9546")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.404 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.404 -0400", hash_original_field = "E871AFED5937EF2A18CE095CADBDB246", hash_generated_field = "75121A76AE83D1347D4F6B7622872157")

    private static TextLine[] sCached = new TextLine[3];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:42.404 -0400", hash_original_field = "5857BDFF3BF33113730586AF5B28164F", hash_generated_field = "BD4519227226DE6CF8B5B95534D34642")

    private static int TAB_INCREMENT = 20;
}

