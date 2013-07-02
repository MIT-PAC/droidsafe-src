package android.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.837 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "B5BC396C7010734D6B4B6ED34A2846AE")

    private TextPaint mPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.837 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "E579ED9F2DADADEB46C981CAFDEE5BA5")

    private CharSequence mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.837 -0400", hash_original_field = "59B50EB80ABF1071654EE6DE5094E070", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")

    private int mStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.837 -0400", hash_original_field = "B74CDC798B150A72FBFBFAE7161611A0", hash_generated_field = "8D921BC08EBCA74A32B1247B1F91B368")

    private int mLen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.837 -0400", hash_original_field = "90B0D92F580EFEB979A78726B5A06046", hash_generated_field = "9463565EC19B0C28E47B4A05A883AACE")

    private int mDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.837 -0400", hash_original_field = "C5BE317E362FA3A0C2C3E5FEF24D93D8", hash_generated_field = "0120B57883F4A0FE4FFD7BC1C988B792")

    private Directions mDirections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.837 -0400", hash_original_field = "E7A53C004C81753F95BE5F68EF660B93", hash_generated_field = "D9EB8682A57605E85FDF7A8921E6278B")

    private boolean mHasTabs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.837 -0400", hash_original_field = "EED8301AA8AD4216C74243E84473677E", hash_generated_field = "D70B7E9717C627B10CB1103D367577AF")

    private TabStops mTabs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.837 -0400", hash_original_field = "7C3722E3CD3CCC07C587A93513F1BB79", hash_generated_field = "20B8558AB5FD0F0B5A30B95221D68246")

    private char[] mChars;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.837 -0400", hash_original_field = "4F9D254B1CD5044B69FC994E7FDA4BC0", hash_generated_field = "24C6EE5653AF991EF0187B60742148D2")

    private boolean mCharsValid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.837 -0400", hash_original_field = "2A174ADD3219E7DC0B72155FF67EC4B5", hash_generated_field = "69C78554F8ABB9B2C492FD314F3ED2EE")

    private Spanned mSpanned;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.837 -0400", hash_original_field = "5ECEFF774471811D388DC8B2E7A3678F", hash_generated_field = "9DF8DC076CC35FCF35EEB176300E0E8D")

    private final TextPaint mWorkPaint = new TextPaint();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.837 -0400", hash_original_field = "BA01C06D7D2C16D8DA15CBC211855B17", hash_generated_field = "D3CDAF00A4A19D3D5704E027A0A1B262")

    private final SpanSet<MetricAffectingSpan> mMetricAffectingSpanSpanSet = new SpanSet<MetricAffectingSpan>(MetricAffectingSpan.class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.838 -0400", hash_original_field = "AA4FF336748C12C296D546DCB9F5F762", hash_generated_field = "B4D32C7B68371DC6D1D4FF600C409891")

    private final SpanSet<CharacterStyle> mCharacterStyleSpanSet = new SpanSet<CharacterStyle>(CharacterStyle.class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.838 -0400", hash_original_field = "3DD162648ABDCE69032EE3F02E2B56F1", hash_generated_field = "5959D1EA746C40C99B9844CC88D0ADB0")

    private final SpanSet<ReplacementSpan> mReplacementSpanSpanSet = new SpanSet<ReplacementSpan>(ReplacementSpan.class);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.838 -0400", hash_original_method = "2FAB193CBF90842ECB23B93C34526440", hash_generated_method = "2FAB193CBF90842ECB23B93C34526440")
    public TextLine ()
    {
        
    }


    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.839 -0400", hash_original_method = "38DB7B0D381033DA01F9181167C14361", hash_generated_method = "48956714ECD1F5CB2025515C74B67C03")
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
        } 
        mHasTabs = hasTabs;
        mSpanned = null;
        boolean hasReplacement = false;
        {
            mSpanned = (Spanned) text;
            mReplacementSpanSpanSet.init(mSpanned, start, limit);
            hasReplacement = mReplacementSpanSpanSet.numberOfSpans > 0;
        } 
        mCharsValid = hasReplacement || hasTabs || directions != Layout.DIRS_ALL_LEFT_TO_RIGHT;
        {
            {
                mChars = new char[ArrayUtils.idealCharArraySize(mLen)];
            } 
            TextUtils.getChars(text, start, limit, mChars, 0);
            {
                char[] chars = mChars;
                {
                    int i = start;
                    int inext = i+1;
                    i = inext;
                    {
                        inext = mReplacementSpanSpanSet.getNextTransition(i, limit);
                        {
                            boolean var9A0647084190D1C8B24B12E654D855A5_1254357528 = (mReplacementSpanSpanSet.hasSpansIntersecting(i, inext));
                            {
                                chars[i - start] = '\ufffc';
                                {
                                    int j = i - start + 1;
                                    int e = inext - start;
                                    {
                                        chars[j] = '\ufeff';
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        mTabs = tabStops;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.841 -0400", hash_original_method = "20A60861C26C58A53A0282FABD9ED153", hash_generated_method = "4B574C7A601B84ED7F1DD92D499189C3")
     void draw(Canvas c, float x, int top, int y, int bottom) {
        {
            {
                drawRun(c, 0, mLen, false, x, top, y, bottom, false);
            } 
            {
                drawRun(c, 0, mLen, true, x, top, y, bottom, false);
            } 
        } 
        float h = 0;
        int[] runs = mDirections.mDirections;
        RectF emojiRect = null;
        int lastRunIndex = runs.length - 2;
        {
            int i = 0;
            i += 2;
            {
                int runStart = runs[i];
                int runLimit = runStart + (runs[i+1] & Layout.RUN_LENGTH_MASK);
                {
                    runLimit = mLen;
                } 
                boolean runIsRtl = (runs[i+1] & Layout.RUN_RTL_FLAG) != 0;
                int segstart = runStart;
                {
                    int j;
                    j = runStart;
                    j = runLimit;
                    {
                        int codept = 0;
                        Bitmap bm = null;
                        {
                            codept = mChars[j];
                            {
                                codept = Character.codePointAt(mChars, j);
                                {
                                    bm = Layout.EMOJI_FACTORY.getBitmapFromAndroidPua(codept);
                                } 
                            } 
                        } 
                        {
                            h += drawRun(c, segstart, j, runIsRtl, x+h, top, y, bottom,
                            i != lastRunIndex || j != mLen);
                            {
                                h = mDir * nextTab(h * mDir);
                            } 
                            {
                                float bmAscent = ascent(j);
                                float bitmapHeight = bm.getHeight();
                                float scale = -bmAscent / bitmapHeight;
                                float width = bm.getWidth() * scale;
                                {
                                    emojiRect = new RectF();
                                } 
                                emojiRect.set(x + h, y + bmAscent,
                                x + h + width, y);
                                c.drawBitmap(bm, null, emojiRect, mPaint);
                                h += width;
                            } 
                            segstart = j + 1;
                        } 
                    } 
                } 
            } 
        } 
        addTaint(c.getTaint());
        addTaint(x);
        addTaint(top);
        addTaint(y);
        addTaint(bottom);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.842 -0400", hash_original_method = "7F5367E991A6BC7E9EDD55CA9BF0FBE6", hash_generated_method = "9A5C8C00BEEE430B9767D0A18FA80F05")
     float metrics(FontMetricsInt fmi) {
        float var819434D16349BB2DC69F34C4834A5D61_757657379 = (measure(mLen, false, fmi));
        addTaint(fmi.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_796509249 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_796509249;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.843 -0400", hash_original_method = "5986320AFF9EF780E7B17B08599A90A9", hash_generated_method = "EC9921523D547F60290561BB771E29A4")
     float measure(int offset, boolean trailing, FontMetricsInt fmi) {
        int target;
        target = offset - 1;
        target = offset;
        float h = 0;
        {
            {
                float var6DBB5A12B291F41A1B8183C9E3967A7F_553726752 = (measureRun(0, offset, mLen, false, fmi));
            } 
            {
                float varAF7F0B660DD98ED2707F73909AA41E03_1282841561 = (measureRun(0, offset, mLen, true, fmi));
            } 
        } 
        char[] chars = mChars;
        int[] runs = mDirections.mDirections;
        {
            int i = 0;
            i += 2;
            {
                int runStart = runs[i];
                int runLimit = runStart + (runs[i+1] & Layout.RUN_LENGTH_MASK);
                {
                    runLimit = mLen;
                } 
                boolean runIsRtl = (runs[i+1] & Layout.RUN_RTL_FLAG) != 0;
                int segstart = runStart;
                {
                    int j;
                    j = runStart;
                    j = runLimit;
                    {
                        int codept = 0;
                        Bitmap bm = null;
                        {
                            codept = chars[j];
                            {
                                codept = Character.codePointAt(chars, j);
                                {
                                    bm = Layout.EMOJI_FACTORY.getBitmapFromAndroidPua(codept);
                                } 
                            } 
                        } 
                        {
                            boolean inSegment = target >= segstart && target < j;
                            boolean advance = (mDir == Layout.DIR_RIGHT_TO_LEFT) == runIsRtl;
                            {
                                float varEAD76BB4ECB5BC510C30780AC9415C1A_513588930 = (h += measureRun(segstart, offset, j, runIsRtl, fmi));
                            } 
                            float w = measureRun(segstart, j, j, runIsRtl, fmi);
                            h += advance ? w : -w;
                            {
                                float var156DB9BDC3E26545D8938CCB69603D57_2087140472 = (h += measureRun(segstart, offset, j, runIsRtl, null));
                            } 
                            {
                                h = mDir * nextTab(h * mDir);
                            } 
                            {
                                float bmAscent = ascent(j);
                                float wid = bm.getWidth() * -bmAscent / bm.getHeight();
                                h += mDir * wid;
                            } 
                            segstart = j + 1;
                        } 
                    } 
                } 
            } 
        } 
        addTaint(offset);
        addTaint(trailing);
        addTaint(fmi.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_1331495443 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1331495443;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.843 -0400", hash_original_method = "1E01EF0F20C48DC869D8591ACBCB40DD", hash_generated_method = "5EEDA106360F9CE26FC19B514F004563")
    private float drawRun(Canvas c, int start,
            int limit, boolean runIsRtl, float x, int top, int y, int bottom,
            boolean needWidth) {
        {
            float w = -measureRun(start, limit, limit, runIsRtl, null);
            handleRun(start, limit, limit, runIsRtl, c, x + w, top,
                    y, bottom, null, false);
        } 
        float var2B269E7D5B38EDA34EF7FCBB54724505_1253915791 = (handleRun(start, limit, limit, runIsRtl, c, x, top,
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
        float var546ADE640B6EDFBC8A086EF31347E768_1644952164 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1644952164;
        
        
            
            
                    
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.844 -0400", hash_original_method = "92FB3641FED625E21CE916EA375B8557", hash_generated_method = "C72095950C936E694F61253B501B0B86")
    private float measureRun(int start, int offset, int limit, boolean runIsRtl,
            FontMetricsInt fmi) {
        float var97D1A4BD409768E6336775867B4BED96_275400292 = (handleRun(start, offset, limit, runIsRtl, null, 0, 0, 0, 0, fmi, true));
        addTaint(start);
        addTaint(offset);
        addTaint(limit);
        addTaint(runIsRtl);
        addTaint(fmi.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_752276839 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_752276839;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.845 -0400", hash_original_method = "4BDB20A2184F91CDB9542314BD3E47CD", hash_generated_method = "354C99C832DEE67D84D75E02E7973D99")
     int getOffsetToLeftRightOf(int cursor, boolean toLeft) {
        int lineStart = 0;
        int lineEnd = mLen;
        boolean paraIsRtl = mDir == -1;
        int[] runs = mDirections.mDirections;
        int runIndex;
        int runLevel = 0;
        int runStart = lineStart;
        int runLimit = lineEnd;
        int newCaret = -1;
        boolean trailing = false;
        {
            runIndex = -2;
        } 
        {
            runIndex = runs.length;
        } 
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
                        } 
                        {
                            runLevel = (runs[runIndex+1] >>> Layout.RUN_LEVEL_SHIFT) &
                    Layout.RUN_LEVEL_MASK;
                            {
                                int prevRunIndex;
                                int prevRunLevel;
                                int prevRunStart;
                                int prevRunLimit;
                                int pos = cursor - 1;
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
                                            } 
                                            {
                                                prevRunLevel = (runs[prevRunIndex+1] >>> Layout.RUN_LEVEL_SHIFT)
                            & Layout.RUN_LEVEL_MASK;
                                                {
                                                    runIndex = prevRunIndex;
                                                    runLevel = prevRunLevel;
                                                    runStart = prevRunStart;
                                                    runLimit = prevRunLimit;
                                                    trailing = true;
                                                } 
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            {
                boolean runIsRtl = (runLevel & 0x1) != 0;
                boolean advance = toLeft == runIsRtl;
                {
                    newCaret = getOffsetBeforeAfter(runIndex, runStart, runLimit,
                          runIsRtl, cursor, advance);
                } 
            } 
        } 
        {
            boolean advance = toLeft == paraIsRtl;
            int otherRunIndex = runIndex + (advance ? 2 : -2);
            {
                int otherRunStart = lineStart + runs[otherRunIndex];
                int otherRunLimit = otherRunStart +
            (runs[otherRunIndex+1] & Layout.RUN_LENGTH_MASK);
                {
                    otherRunLimit = lineEnd;
                } 
                int otherRunLevel = (runs[otherRunIndex+1] >>> Layout.RUN_LEVEL_SHIFT) &
                Layout.RUN_LEVEL_MASK;
                boolean otherRunIsRtl = (otherRunLevel & 1) != 0;
                advance = toLeft == otherRunIsRtl;
                {
                    newCaret = getOffsetBeforeAfter(otherRunIndex, otherRunStart,
                        otherRunLimit, otherRunIsRtl,
                        advance ? otherRunStart : otherRunLimit, advance);
                    {
                        runIndex = otherRunIndex;
                        runLevel = otherRunLevel;
                    } 
                } 
                {
                    newCaret = advance ? otherRunStart : otherRunLimit;
                } 
            } 
            {
                newCaret = advance ? mLen + 1 : -1;
            } 
            {
                newCaret = advance ? lineEnd : lineStart;
            } 
        } 
        addTaint(cursor);
        addTaint(toLeft);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1820317468 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1820317468;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.846 -0400", hash_original_method = "31252F4808C2C77A1E467D2963FB3AD5", hash_generated_method = "68B5E2A7045019A0FFC687644E0350EB")
    private int getOffsetBeforeAfter(int runIndex, int runStart, int runLimit,
            boolean runIsRtl, int offset, boolean after) {
        {
            {
                int var23A42F19460B2B1B4F7650C079142539_2055799127 = (TextUtils.getOffsetAfter(mText, offset + mStart) - mStart);
            } 
            int var878CE411BC90821D83BAFC7D86E8759C_1203419865 = (TextUtils.getOffsetBefore(mText, offset + mStart) - mStart);
        } 
        TextPaint wp = mWorkPaint;
        wp.set(mPaint);
        int spanStart = runStart;
        int spanLimit;
        {
            spanLimit = runLimit;
        } 
        {
            int target;
            target = offset + 1;
            target = offset;
            int limit = mStart + runLimit;
            {
                spanLimit = mSpanned.nextSpanTransition(mStart + spanStart, limit,
                        MetricAffectingSpan.class) - mStart;
                spanStart = spanLimit;
            } 
            MetricAffectingSpan[] spans = mSpanned.getSpans(mStart + spanStart,
                    mStart + spanLimit, MetricAffectingSpan.class);
            spans = TextUtils.removeEmptySpans(spans, mSpanned, MetricAffectingSpan.class);
            {
                ReplacementSpan replacement = null;
                {
                    int j = 0;
                    {
                        MetricAffectingSpan span = spans[j];
                        {
                            replacement = (ReplacementSpan)span;
                        } 
                        {
                            span.updateMeasureState(wp);
                        } 
                    } 
                } 
            } 
        } 
        int flags;
        flags = Paint.DIRECTION_RTL;
        flags = Paint.DIRECTION_LTR;
        int cursorOpt;
        cursorOpt = Paint.CURSOR_AFTER;
        cursorOpt = Paint.CURSOR_BEFORE;
        {
            int var8A46B054A3BF4BE20F28D574CADE0515_1175661212 = (wp.getTextRunCursor(mChars, spanStart, spanLimit - spanStart,
                    flags, offset, cursorOpt));
        } 
        {
            int var2C1A4A7C8DBA63FC4B3CC76C9F155C03_469998583 = (wp.getTextRunCursor(mText, mStart + spanStart,
                    mStart + spanLimit, flags, mStart + offset, cursorOpt) - mStart);
        } 
        addTaint(runIndex);
        addTaint(runStart);
        addTaint(runLimit);
        addTaint(runIsRtl);
        addTaint(offset);
        addTaint(after);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1067591930 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1067591930;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    static void updateMetrics(FontMetricsInt fmi, int previousTop, int previousAscent,
            int previousDescent, int previousBottom, int previousLeading) {
        fmi.top     = Math.min(fmi.top,     previousTop);
        fmi.ascent  = Math.min(fmi.ascent,  previousAscent);
        fmi.descent = Math.max(fmi.descent, previousDescent);
        fmi.bottom  = Math.max(fmi.bottom,  previousBottom);
        fmi.leading = Math.max(fmi.leading, previousLeading);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.848 -0400", hash_original_method = "F8AC228F4E44CF9CD673B1404700AC77", hash_generated_method = "EC1C6F61A1409ADD7A398E965FE85DFD")
    private float handleText(TextPaint wp, int start, int end,
            int contextStart, int contextEnd, boolean runIsRtl,
            Canvas c, float x, int top, int y, int bottom,
            FontMetricsInt fmi, boolean needWidth) {
        {
            expandMetricsFromPaint(fmi, wp);
        } 
        int runLen = end - start;
        float ret = 0;
        int contextLen = contextEnd - contextStart;
        {
            int flags;
            flags = Paint.DIRECTION_RTL;
            flags = Paint.DIRECTION_LTR;
            {
                ret = wp.getTextRunAdvances(mChars, start, runLen,
                        contextStart, contextLen, flags, null, 0);
            } 
            {
                int delta = mStart;
                ret = wp.getTextRunAdvances(mText, delta + start,
                        delta + end, delta + contextStart, delta + contextEnd,
                        flags, null, 0);
            } 
        } 
        {
            {
                x -= ret;
            } 
            {
                int previousColor = wp.getColor();
                Paint.Style previousStyle = wp.getStyle();
                wp.setColor(wp.bgColor);
                wp.setStyle(Paint.Style.FILL);
                c.drawRect(x, top, x + ret, bottom, wp);
                wp.setStyle(previousStyle);
                wp.setColor(previousColor);
            } 
            {
                float underlineTop = y + wp.baselineShift + (1.0f / 9.0f) * wp.getTextSize();
                int previousColor = wp.getColor();
                Paint.Style previousStyle = wp.getStyle();
                boolean previousAntiAlias = wp.isAntiAlias();
                wp.setStyle(Paint.Style.FILL);
                wp.setAntiAlias(true);
                wp.setColor(wp.underlineColor);
                c.drawRect(x, underlineTop, x + ret, underlineTop + wp.underlineThickness, wp);
                wp.setStyle(previousStyle);
                wp.setColor(previousColor);
                wp.setAntiAlias(previousAntiAlias);
            } 
            drawTextRun(c, wp, start, end, contextStart, contextEnd, runIsRtl,
                    x, y + wp.baselineShift);
        } 
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
        float var546ADE640B6EDFBC8A086EF31347E768_839310869 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_839310869;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.848 -0400", hash_original_method = "5BB6CBCB4177EDC48B270A42A6989FB0", hash_generated_method = "5C3552CA2EE06D58611DD67C4566525E")
    private float handleReplacement(ReplacementSpan replacement, TextPaint wp,
            int start, int limit, boolean runIsRtl, Canvas c,
            float x, int top, int y, int bottom, FontMetricsInt fmi,
            boolean needWidth) {
        float ret = 0;
        int textStart = mStart + start;
        int textLimit = mStart + limit;
        {
            int previousTop = 0;
            int previousAscent = 0;
            int previousDescent = 0;
            int previousBottom = 0;
            int previousLeading = 0;
            boolean needUpdateMetrics = (fmi != null);
            {
                previousTop     = fmi.top;
                previousAscent  = fmi.ascent;
                previousDescent = fmi.descent;
                previousBottom  = fmi.bottom;
                previousLeading = fmi.leading;
            } 
            ret = replacement.getSize(wp, mText, textStart, textLimit, fmi);
            {
                updateMetrics(fmi, previousTop, previousAscent, previousDescent, previousBottom,
                        previousLeading);
            } 
        } 
        {
            {
                x -= ret;
            } 
            replacement.draw(c, mText, textStart, textLimit,
                    x, top, y, bottom, wp);
        } 
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
        float var546ADE640B6EDFBC8A086EF31347E768_2082939344 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2082939344;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.850 -0400", hash_original_method = "5FABB9B94E4E730AC35956B01320E35B", hash_generated_method = "15C0F45D120E3083B64B4FBD894A6414")
    private float handleRun(int start, int measureLimit,
            int limit, boolean runIsRtl, Canvas c, float x, int top, int y,
            int bottom, FontMetricsInt fmi, boolean needWidth) {
        {
            TextPaint wp = mWorkPaint;
            wp.set(mPaint);
            {
                expandMetricsFromPaint(fmi, wp);
            } 
        } 
        {
            TextPaint wp = mWorkPaint;
            wp.set(mPaint);
            final int mlimit = measureLimit;
            float var34AF167EDF1314E69A7451FFECC8AC0B_935884669 = (handleText(wp, start, mlimit, start, limit, runIsRtl, c, x, top,
                    y, bottom, fmi, needWidth || mlimit < measureLimit));
        } 
        mMetricAffectingSpanSpanSet.init(mSpanned, mStart + start, mStart + limit);
        mCharacterStyleSpanSet.init(mSpanned, mStart + start, mStart + limit);
        final float originalX = x;
        {
            int i = start;
            int inext = i;
            i = inext;
            {
                TextPaint wp = mWorkPaint;
                wp.set(mPaint);
                inext = mMetricAffectingSpanSpanSet.getNextTransition(mStart + i, mStart + limit) -
                    mStart;
                int mlimit = Math.min(inext, measureLimit);
                ReplacementSpan replacement = null;
                {
                    int j = 0;
                    {
                        MetricAffectingSpan span = mMetricAffectingSpanSpanSet.spans[j];
                        {
                            replacement = (ReplacementSpan)span;
                        } 
                        {
                            span.updateDrawState(wp);
                        } 
                    } 
                } 
                {
                    x += handleReplacement(replacement, wp, i, mlimit, runIsRtl, c, x, top, y,
                        bottom, fmi, needWidth || mlimit < measureLimit);
                } 
                {
                    x += handleText(wp, i, mlimit, i, inext, runIsRtl, c, x, top,
                        y, bottom, fmi, needWidth || mlimit < measureLimit);
                } 
                {
                    {
                        int j = i;
                        int jnext = j;
                        j = jnext;
                        {
                            jnext = mCharacterStyleSpanSet.getNextTransition(mStart + j, mStart + mlimit) -
                            mStart;
                            wp.set(mPaint);
                            {
                                int k = 0;
                                {
                                    CharacterStyle span = mCharacterStyleSpanSet.spans[k];
                                    span.updateDrawState(wp);
                                } 
                            } 
                            x += handleText(wp, j, jnext, i, inext, runIsRtl, c, x,
                            top, y, bottom, fmi, needWidth || jnext < measureLimit);
                        } 
                    } 
                } 
            } 
        } 
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
        float var546ADE640B6EDFBC8A086EF31347E768_1214693108 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1214693108;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.851 -0400", hash_original_method = "C8ABF2DC6B89611B840AEC4DBAADD344", hash_generated_method = "440DC7A004E12A421BAFD2D223A141EB")
    private void drawTextRun(Canvas c, TextPaint wp, int start, int end,
            int contextStart, int contextEnd, boolean runIsRtl, float x, int y) {
        int flags;
        flags = Canvas.DIRECTION_RTL;
        flags = Canvas.DIRECTION_LTR;
        {
            int count = end - start;
            int contextCount = contextEnd - contextStart;
            c.drawTextRun(mChars, start, count, contextStart, contextCount,
                    x, y, flags, wp);
        } 
        {
            int delta = mStart;
            c.drawTextRun(mText, delta + start, delta + end,
                    delta + contextStart, delta + contextEnd, x, y, flags, wp);
        } 
        addTaint(c.getTaint());
        addTaint(wp.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(contextStart);
        addTaint(contextEnd);
        addTaint(runIsRtl);
        addTaint(x);
        addTaint(y);
        
        
        
            
            
            
                    
        
            
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.859 -0400", hash_original_method = "AC74D3C7A92A1C0DA8A76C86F50D3219", hash_generated_method = "3317BBDDA4765C2BAC23C8BF79F8A6DC")
     float ascent(int pos) {
        {
            float var3BDF3A2D03302BACAD807FFE6B0D6A91_1596073944 = (mPaint.ascent());
        } 
        pos += mStart;
        MetricAffectingSpan[] spans = mSpanned.getSpans(pos, pos + 1, MetricAffectingSpan.class);
        {
            float var3BDF3A2D03302BACAD807FFE6B0D6A91_177650643 = (mPaint.ascent());
        } 
        TextPaint wp = mWorkPaint;
        wp.set(mPaint);
        {
            MetricAffectingSpan span = spans[0];
            {
                span.updateMeasureState(wp);
            } 
        } 
        float var5DC50654BD2E08B78A3F0BF6159A6A3E_282611776 = (wp.ascent());
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_118442814 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_118442814;
        
        
            
        
        
        
        
            
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.860 -0400", hash_original_method = "73134044CD530D6AE99976E01BA5E625", hash_generated_method = "06DD23335FD5B4DDC1CC2E947063567D")
     float nextTab(float h) {
        {
            float varBC64F150694F74B7C25309A0AEC4E154_1319830552 = (mTabs.nextTab(h));
        } 
        float varC96F42CCA3E3E5F25C19ACBABD69AED1_1662796382 = (TabStops.nextDefaultStop(h, TAB_INCREMENT));
        addTaint(h);
        float var546ADE640B6EDFBC8A086EF31347E768_819531144 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_819531144;
        
        
            
        
        
    }

    
    private static class SpanSet<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.860 -0400", hash_original_field = "D6B5FCDB35353F6A4017F11EBD647D09", hash_generated_field = "4D016F914E51DC9C3732F557E45EB452")

        int numberOfSpans;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.860 -0400", hash_original_field = "A46EFC2A2782C9238263F63F5CEA5D42", hash_generated_field = "32FCADE2328772A5D81411E0AA303B75")

        E[] spans;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.860 -0400", hash_original_field = "C24BD1BD2949B9599EEDD7F0387EE723", hash_generated_field = "1D3712C585C8808C22172D42F4D7BB90")

        int[] spanStarts;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.860 -0400", hash_original_field = "0502422B326B747A365D76C9CCE8E955", hash_generated_field = "8ED878CF75FF4569DFB3C4F0CC5B72F1")

        int[] spanEnds;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.860 -0400", hash_original_field = "6612E29FBDE8178CC4AD5176D3C8A9E6", hash_generated_field = "2E2862EF6D4B111BA84644CB0E9CD297")

        int[] spanFlags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.860 -0400", hash_original_field = "A69F0373B093A535ADB7C9273781CD43", hash_generated_field = "7DE61887E85E1CD432AAA8825CCFB81E")

        Class<? extends E> classType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.860 -0400", hash_original_method = "08793871E7FAA5C02A5C5115CBB016E1", hash_generated_method = "7A2C4BAA57A8D03BA9484E8C2D4BDD35")
          SpanSet(Class<? extends E> type) {
            classType = type;
            numberOfSpans = 0;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.861 -0400", hash_original_method = "DCBC67B7023E3760B724E28392339389", hash_generated_method = "B89F7ECACDCA3A5D6FBF7E1AEDE3730B")
        @SuppressWarnings("unchecked")
        public void init(Spanned spanned, int start, int limit) {
            final E[] allSpans = spanned.getSpans(start, limit, classType);
            final int length = allSpans.length;
            {
                spans = (E[]) Array.newInstance(classType, length);
                spanStarts = new int[length];
                spanEnds = new int[length];
                spanFlags = new int[length];
            } 
            numberOfSpans = 0;
            {
                int i = 0;
                {
                    final E span = allSpans[i];
                    final int spanStart = spanned.getSpanStart(span);
                    final int spanEnd = spanned.getSpanEnd(span);
                    final int spanFlag = spanned.getSpanFlags(span);
                    spans[numberOfSpans] = span;
                    spanStarts[numberOfSpans] = spanStart;
                    spanEnds[numberOfSpans] = spanEnd;
                    spanFlags[numberOfSpans] = spanFlag;
                } 
            } 
            addTaint(spanned.getTaint());
            addTaint(start);
            addTaint(limit);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.861 -0400", hash_original_method = "14C2C64E52F272A1D061AF5FA0B61C4E", hash_generated_method = "952EE89FCA66ABF79DB69DAE8C4F61E3")
        public boolean hasSpansIntersecting(int start, int end) {
            {
                int i = 0;
            } 
            addTaint(start);
            addTaint(end);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_559614488 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_559614488;
            
            
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.862 -0400", hash_original_method = "70A36A49F9CEFC761501124E36FC2A8C", hash_generated_method = "A4FADACB5CA9209C34545D8878EC378A")
         int getNextTransition(int start, int limit) {
            {
                int i = 0;
                {
                    final int spanStart = spanStarts[i];
                    final int spanEnd = spanEnds[i];
                    limit = spanStart;
                    limit = spanEnd;
                } 
            } 
            addTaint(start);
            addTaint(limit);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_762782443 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_762782443;
            
            
                
                
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.863 -0400", hash_original_method = "5E840A260140B15B0CFAF6F2BC649D6A", hash_generated_method = "77E40000D99CB01AC6A8E7A793D4F30B")
        public void recycle() {
            {
                int i = 0;
                {
                    spans[i] = null;
                } 
            } 
            
            
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.863 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.863 -0400", hash_original_field = "E871AFED5937EF2A18CE095CADBDB246", hash_generated_field = "B787628D86685B4DD27C326E2D91EEE2")

    private static final TextLine[] sCached = new TextLine[3];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.863 -0400", hash_original_field = "5857BDFF3BF33113730586AF5B28164F", hash_generated_field = "D5E340FF9F0E2C74F920DF02A6624213")

    private static final int TAB_INCREMENT = 20;
}

