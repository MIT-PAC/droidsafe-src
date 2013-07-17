package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.884 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "B5BC396C7010734D6B4B6ED34A2846AE")

    private TextPaint mPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.884 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "E579ED9F2DADADEB46C981CAFDEE5BA5")

    private CharSequence mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.884 -0400", hash_original_field = "59B50EB80ABF1071654EE6DE5094E070", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")

    private int mStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.884 -0400", hash_original_field = "B74CDC798B150A72FBFBFAE7161611A0", hash_generated_field = "8D921BC08EBCA74A32B1247B1F91B368")

    private int mLen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.884 -0400", hash_original_field = "90B0D92F580EFEB979A78726B5A06046", hash_generated_field = "9463565EC19B0C28E47B4A05A883AACE")

    private int mDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.884 -0400", hash_original_field = "C5BE317E362FA3A0C2C3E5FEF24D93D8", hash_generated_field = "0120B57883F4A0FE4FFD7BC1C988B792")

    private Directions mDirections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.884 -0400", hash_original_field = "E7A53C004C81753F95BE5F68EF660B93", hash_generated_field = "D9EB8682A57605E85FDF7A8921E6278B")

    private boolean mHasTabs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.884 -0400", hash_original_field = "EED8301AA8AD4216C74243E84473677E", hash_generated_field = "D70B7E9717C627B10CB1103D367577AF")

    private TabStops mTabs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.884 -0400", hash_original_field = "7C3722E3CD3CCC07C587A93513F1BB79", hash_generated_field = "20B8558AB5FD0F0B5A30B95221D68246")

    private char[] mChars;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.885 -0400", hash_original_field = "4F9D254B1CD5044B69FC994E7FDA4BC0", hash_generated_field = "24C6EE5653AF991EF0187B60742148D2")

    private boolean mCharsValid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.885 -0400", hash_original_field = "2A174ADD3219E7DC0B72155FF67EC4B5", hash_generated_field = "69C78554F8ABB9B2C492FD314F3ED2EE")

    private Spanned mSpanned;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.885 -0400", hash_original_field = "5ECEFF774471811D388DC8B2E7A3678F", hash_generated_field = "9DF8DC076CC35FCF35EEB176300E0E8D")

    private final TextPaint mWorkPaint = new TextPaint();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.885 -0400", hash_original_field = "BA01C06D7D2C16D8DA15CBC211855B17", hash_generated_field = "D3CDAF00A4A19D3D5704E027A0A1B262")

    private final SpanSet<MetricAffectingSpan> mMetricAffectingSpanSpanSet = new SpanSet<MetricAffectingSpan>(MetricAffectingSpan.class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.885 -0400", hash_original_field = "AA4FF336748C12C296D546DCB9F5F762", hash_generated_field = "B4D32C7B68371DC6D1D4FF600C409891")

    private final SpanSet<CharacterStyle> mCharacterStyleSpanSet = new SpanSet<CharacterStyle>(CharacterStyle.class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.885 -0400", hash_original_field = "3DD162648ABDCE69032EE3F02E2B56F1", hash_generated_field = "5959D1EA746C40C99B9844CC88D0ADB0")

    private final SpanSet<ReplacementSpan> mReplacementSpanSpanSet = new SpanSet<ReplacementSpan>(ReplacementSpan.class);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.885 -0400", hash_original_method = "2FAB193CBF90842ECB23B93C34526440", hash_generated_method = "2FAB193CBF90842ECB23B93C34526440")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.889 -0400", hash_original_method = "38DB7B0D381033DA01F9181167C14361", hash_generated_method = "F5073AB15A598E3CB888AECDBD17F421")
     void set(TextPaint paint, CharSequence text, int start, int limit, int dir,
            Directions directions, boolean hasTabs, TabStops tabStops) {
        mPaint = paint;
        mText = text;
        mStart = start;
        mLen = limit - start;
        mDir = dir;
        mDirections = directions;
        if(mDirections == null)        
        {
            IllegalArgumentException var8EF2EA489585A5793B8925C4F03F0829_494850263 = new IllegalArgumentException("Directions cannot be null");
            var8EF2EA489585A5793B8925C4F03F0829_494850263.addTaint(taint);
            throw var8EF2EA489585A5793B8925C4F03F0829_494850263;
        } //End block
        mHasTabs = hasTabs;
        mSpanned = null;
        boolean hasReplacement = false;
        if(text instanceof Spanned)        
        {
            mSpanned = (Spanned) text;
            mReplacementSpanSpanSet.init(mSpanned, start, limit);
            hasReplacement = mReplacementSpanSpanSet.numberOfSpans > 0;
        } //End block
        mCharsValid = hasReplacement || hasTabs || directions != Layout.DIRS_ALL_LEFT_TO_RIGHT;
        if(mCharsValid)        
        {
            if(mChars == null || mChars.length < mLen)            
            {
                mChars = new char[ArrayUtils.idealCharArraySize(mLen)];
            } //End block
            TextUtils.getChars(text, start, limit, mChars, 0);
            if(hasReplacement)            
            {
                char[] chars = mChars;
for(int i = start, inext;i < limit;i = inext)
                {
                    inext = mReplacementSpanSpanSet.getNextTransition(i, limit);
                    if(mReplacementSpanSpanSet.hasSpansIntersecting(i, inext))                    
                    {
                        chars[i - start] = '\ufffc';
for(int j = i - start + 1, e = inext - start;j < e;++j)
                        {
                            chars[j] = '\ufeff';
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        mTabs = tabStops;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.892 -0400", hash_original_method = "20A60861C26C58A53A0282FABD9ED153", hash_generated_method = "5A4A461B5A73E637F80ED8E2B627765F")
     void draw(Canvas c, float x, int top, int y, int bottom) {
        addTaint(bottom);
        addTaint(y);
        addTaint(top);
        addTaint(x);
        addTaint(c.getTaint());
        if(!mHasTabs)        
        {
            if(mDirections == Layout.DIRS_ALL_LEFT_TO_RIGHT)            
            {
                drawRun(c, 0, mLen, false, x, top, y, bottom, false);
                return;
            } //End block
            if(mDirections == Layout.DIRS_ALL_RIGHT_TO_LEFT)            
            {
                drawRun(c, 0, mLen, true, x, top, y, bottom, false);
                return;
            } //End block
        } //End block
        float h = 0;
        int[] runs = mDirections.mDirections;
        RectF emojiRect = null;
        int lastRunIndex = runs.length - 2;
for(int i = 0;i < runs.length;i += 2)
        {
            int runStart = runs[i];
            int runLimit = runStart + (runs[i+1] & Layout.RUN_LENGTH_MASK);
            if(runLimit > mLen)            
            {
                runLimit = mLen;
            } //End block
            boolean runIsRtl = (runs[i+1] & Layout.RUN_RTL_FLAG) != 0;
            int segstart = runStart;
for(int j = mHasTabs ? runStart : runLimit;j <= runLimit;j++)
            {
                int codept = 0;
                Bitmap bm = null;
                if(mHasTabs && j < runLimit)                
                {
                    codept = mChars[j];
                    if(codept >= 0xd800 && codept < 0xdc00 && j + 1 < runLimit)                    
                    {
                        codept = Character.codePointAt(mChars, j);
                        if(codept >= Layout.MIN_EMOJI && codept <= Layout.MAX_EMOJI)                        
                        {
                            bm = Layout.EMOJI_FACTORY.getBitmapFromAndroidPua(codept);
                        } //End block
                        else
                        if(codept > 0xffff)                        
                        {
                            ++j;
                            continue;
                        } //End block
                    } //End block
                } //End block
                if(j == runLimit || codept == '\t' || bm != null)                
                {
                    h += drawRun(c, segstart, j, runIsRtl, x+h, top, y, bottom,
                            i != lastRunIndex || j != mLen);
                    if(codept == '\t')                    
                    {
                        h = mDir * nextTab(h * mDir);
                    } //End block
                    else
                    if(bm != null)                    
                    {
                        float bmAscent = ascent(j);
                        float bitmapHeight = bm.getHeight();
                        float scale = -bmAscent / bitmapHeight;
                        float width = bm.getWidth() * scale;
                        if(emojiRect == null)                        
                        {
                            emojiRect = new RectF();
                        } //End block
                        emojiRect.set(x + h, y + bmAscent,
                                x + h + width, y);
                        c.drawBitmap(bm, null, emojiRect, mPaint);
                        h += width;
                        j++;
                    } //End block
                    segstart = j + 1;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.893 -0400", hash_original_method = "7F5367E991A6BC7E9EDD55CA9BF0FBE6", hash_generated_method = "EE99070E0B9C735F356F6EC7C9BA7395")
     float metrics(FontMetricsInt fmi) {
        addTaint(fmi.getTaint());
        float varCA3676A736B9AEF236D373DAF5F8A8BD_2136360680 = (measure(mLen, false, fmi));
                float var546ADE640B6EDFBC8A086EF31347E768_1279280870 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1279280870;
        // ---------- Original Method ----------
        //return measure(mLen, false, fmi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.895 -0400", hash_original_method = "5986320AFF9EF780E7B17B08599A90A9", hash_generated_method = "E7F60D08824FA2DB27A269296A6CE719")
     float measure(int offset, boolean trailing, FontMetricsInt fmi) {
        addTaint(fmi.getTaint());
        addTaint(trailing);
        addTaint(offset);
        int target = trailing ? offset - 1 : offset;
        if(target < 0)        
        {
            float varCFCD208495D565EF66E7DFF9F98764DA_1518439014 = (0);
                        float var546ADE640B6EDFBC8A086EF31347E768_486195268 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_486195268;
        } //End block
        float h = 0;
        if(!mHasTabs)        
        {
            if(mDirections == Layout.DIRS_ALL_LEFT_TO_RIGHT)            
            {
                float varD8C26A00544BF185216AE9587E201F4B_1303183755 = (measureRun(0, offset, mLen, false, fmi));
                                float var546ADE640B6EDFBC8A086EF31347E768_139255091 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_139255091;
            } //End block
            if(mDirections == Layout.DIRS_ALL_RIGHT_TO_LEFT)            
            {
                float varAFC11B24CA9B0417E04E74CB8335A043_271801824 = (measureRun(0, offset, mLen, true, fmi));
                                float var546ADE640B6EDFBC8A086EF31347E768_660414821 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_660414821;
            } //End block
        } //End block
        char[] chars = mChars;
        int[] runs = mDirections.mDirections;
for(int i = 0;i < runs.length;i += 2)
        {
            int runStart = runs[i];
            int runLimit = runStart + (runs[i+1] & Layout.RUN_LENGTH_MASK);
            if(runLimit > mLen)            
            {
                runLimit = mLen;
            } //End block
            boolean runIsRtl = (runs[i+1] & Layout.RUN_RTL_FLAG) != 0;
            int segstart = runStart;
for(int j = mHasTabs ? runStart : runLimit;j <= runLimit;j++)
            {
                int codept = 0;
                Bitmap bm = null;
                if(mHasTabs && j < runLimit)                
                {
                    codept = chars[j];
                    if(codept >= 0xd800 && codept < 0xdc00 && j + 1 < runLimit)                    
                    {
                        codept = Character.codePointAt(chars, j);
                        if(codept >= Layout.MIN_EMOJI && codept <= Layout.MAX_EMOJI)                        
                        {
                            bm = Layout.EMOJI_FACTORY.getBitmapFromAndroidPua(codept);
                        } //End block
                        else
                        if(codept > 0xffff)                        
                        {
                            ++j;
                            continue;
                        } //End block
                    } //End block
                } //End block
                if(j == runLimit || codept == '\t' || bm != null)                
                {
                    boolean inSegment = target >= segstart && target < j;
                    boolean advance = (mDir == Layout.DIR_RIGHT_TO_LEFT) == runIsRtl;
                    if(inSegment && advance)                    
                    {
                        float varFA5C38CF86CB7664782CEB7AB6041127_1936267218 = (h += measureRun(segstart, offset, j, runIsRtl, fmi));
                                                float var546ADE640B6EDFBC8A086EF31347E768_1264050611 = getTaintFloat();
                        return var546ADE640B6EDFBC8A086EF31347E768_1264050611;
                    } //End block
                    float w = measureRun(segstart, j, j, runIsRtl, fmi);
                    h += advance ? w : -w;
                    if(inSegment)                    
                    {
                        float varE0FB591AA13046F431755A91C042765A_1151131579 = (h += measureRun(segstart, offset, j, runIsRtl, null));
                                                float var546ADE640B6EDFBC8A086EF31347E768_565493687 = getTaintFloat();
                        return var546ADE640B6EDFBC8A086EF31347E768_565493687;
                    } //End block
                    if(codept == '\t')                    
                    {
                        if(offset == j)                        
                        {
                            float var2510C39011C5BE704182423E3A695E91_216988063 = (h);
                                                        float var546ADE640B6EDFBC8A086EF31347E768_1927864513 = getTaintFloat();
                            return var546ADE640B6EDFBC8A086EF31347E768_1927864513;
                        } //End block
                        h = mDir * nextTab(h * mDir);
                        if(target == j)                        
                        {
                            float var2510C39011C5BE704182423E3A695E91_332721883 = (h);
                                                        float var546ADE640B6EDFBC8A086EF31347E768_596587385 = getTaintFloat();
                            return var546ADE640B6EDFBC8A086EF31347E768_596587385;
                        } //End block
                    } //End block
                    if(bm != null)                    
                    {
                        float bmAscent = ascent(j);
                        float wid = bm.getWidth() * -bmAscent / bm.getHeight();
                        h += mDir * wid;
                        j++;
                    } //End block
                    segstart = j + 1;
                } //End block
            } //End block
        } //End block
        float var2510C39011C5BE704182423E3A695E91_1782747607 = (h);
                float var546ADE640B6EDFBC8A086EF31347E768_1518634912 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1518634912;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.897 -0400", hash_original_method = "1E01EF0F20C48DC869D8591ACBCB40DD", hash_generated_method = "F6306DADDDAC62BE4C50F6383EDECF37")
    private float drawRun(Canvas c, int start,
            int limit, boolean runIsRtl, float x, int top, int y, int bottom,
            boolean needWidth) {
        addTaint(needWidth);
        addTaint(bottom);
        addTaint(y);
        addTaint(top);
        addTaint(x);
        addTaint(runIsRtl);
        addTaint(limit);
        addTaint(start);
        addTaint(c.getTaint());
        if((mDir == Layout.DIR_LEFT_TO_RIGHT) == runIsRtl)        
        {
            float w = -measureRun(start, limit, limit, runIsRtl, null);
            handleRun(start, limit, limit, runIsRtl, c, x + w, top,
                    y, bottom, null, false);
            float varF1290186A5D0B1CEAB27F4E77C0C5D68_1211213409 = (w);
                        float var546ADE640B6EDFBC8A086EF31347E768_576951074 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_576951074;
        } //End block
        float var5B806A8FD0815835AF834A951658C654_1123579234 = (handleRun(start, limit, limit, runIsRtl, c, x, top,
                y, bottom, null, needWidth));
                float var546ADE640B6EDFBC8A086EF31347E768_468516119 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_468516119;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.897 -0400", hash_original_method = "92FB3641FED625E21CE916EA375B8557", hash_generated_method = "DC181BC408A67A148853E90C0F2D1B1A")
    private float measureRun(int start, int offset, int limit, boolean runIsRtl,
            FontMetricsInt fmi) {
        addTaint(fmi.getTaint());
        addTaint(runIsRtl);
        addTaint(limit);
        addTaint(offset);
        addTaint(start);
        float var1B298E88DAA78E81443AFF35B67538B1_1381804415 = (handleRun(start, offset, limit, runIsRtl, null, 0, 0, 0, 0, fmi, true));
                float var546ADE640B6EDFBC8A086EF31347E768_1655746915 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1655746915;
        // ---------- Original Method ----------
        //return handleRun(start, offset, limit, runIsRtl, null, 0, 0, 0, 0, fmi, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.904 -0400", hash_original_method = "4BDB20A2184F91CDB9542314BD3E47CD", hash_generated_method = "CBAAB2560A2736347C99411B4017AB26")
     int getOffsetToLeftRightOf(int cursor, boolean toLeft) {
        addTaint(toLeft);
        addTaint(cursor);
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
        if(cursor == lineStart)        
        {
            runIndex = -2;
        } //End block
        else
        if(cursor == lineEnd)        
        {
            runIndex = runs.length;
        } //End block
        else
        {
for(runIndex = 0;runIndex < runs.length;runIndex += 2)
            {
                runStart = lineStart + runs[runIndex];
                if(cursor >= runStart)                
                {
                    runLimit = runStart + (runs[runIndex+1] & Layout.RUN_LENGTH_MASK);
                    if(runLimit > lineEnd)                    
                    {
                        runLimit = lineEnd;
                    } //End block
                    if(cursor < runLimit)                    
                    {
                        runLevel = (runs[runIndex+1] >>> Layout.RUN_LEVEL_SHIFT) &
                    Layout.RUN_LEVEL_MASK;
                        if(cursor == runStart)                        
                        {
                            int prevRunIndex;
                            int prevRunLevel;
                            int prevRunStart;
                            int prevRunLimit;
                            int pos = cursor - 1;
for(prevRunIndex = 0;prevRunIndex < runs.length;prevRunIndex += 2)
                            {
                                prevRunStart = lineStart + runs[prevRunIndex];
                                if(pos >= prevRunStart)                                
                                {
                                    prevRunLimit = prevRunStart +
                          (runs[prevRunIndex+1] & Layout.RUN_LENGTH_MASK);
                                    if(prevRunLimit > lineEnd)                                    
                                    {
                                        prevRunLimit = lineEnd;
                                    } //End block
                                    if(pos < prevRunLimit)                                    
                                    {
                                        prevRunLevel = (runs[prevRunIndex+1] >>> Layout.RUN_LEVEL_SHIFT)
                            & Layout.RUN_LEVEL_MASK;
                                        if(prevRunLevel < runLevel)                                        
                                        {
                                            runIndex = prevRunIndex;
                                            runLevel = prevRunLevel;
                                            runStart = prevRunStart;
                                            runLimit = prevRunLimit;
                                            trailing = true;
                                            break;
                                        } //End block
                                    } //End block
                                } //End block
                            } //End block
                        } //End block
                        break;
                    } //End block
                } //End block
            } //End block
            if(runIndex != runs.length)            
            {
                boolean runIsRtl = (runLevel & 0x1) != 0;
                boolean advance = toLeft == runIsRtl;
                if(cursor != (advance ? runLimit : runStart) || advance != trailing)                
                {
                    newCaret = getOffsetBeforeAfter(runIndex, runStart, runLimit,
                          runIsRtl, cursor, advance);
                    if(newCaret != (advance ? runLimit : runStart))                    
                    {
                        int varA44B1DB7E51DCB32F152F35D1542F927_1964983225 = (newCaret);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496389127 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496389127;
                    } //End block
                } //End block
            } //End block
        } //End block
        while
(true)        
        {
            boolean advance = toLeft == paraIsRtl;
            int otherRunIndex = runIndex + (advance ? 2 : -2);
            if(otherRunIndex >= 0 && otherRunIndex < runs.length)            
            {
                int otherRunStart = lineStart + runs[otherRunIndex];
                int otherRunLimit = otherRunStart +
            (runs[otherRunIndex+1] & Layout.RUN_LENGTH_MASK);
                if(otherRunLimit > lineEnd)                
                {
                    otherRunLimit = lineEnd;
                } //End block
                int otherRunLevel = (runs[otherRunIndex+1] >>> Layout.RUN_LEVEL_SHIFT) &
                Layout.RUN_LEVEL_MASK;
                boolean otherRunIsRtl = (otherRunLevel & 1) != 0;
                advance = toLeft == otherRunIsRtl;
                if(newCaret == -1)                
                {
                    newCaret = getOffsetBeforeAfter(otherRunIndex, otherRunStart,
                        otherRunLimit, otherRunIsRtl,
                        advance ? otherRunStart : otherRunLimit, advance);
                    if(newCaret == (advance ? otherRunLimit : otherRunStart))                    
                    {
                        runIndex = otherRunIndex;
                        runLevel = otherRunLevel;
                        continue;
                    } //End block
                    break;
                } //End block
                if(otherRunLevel < runLevel)                
                {
                    newCaret = advance ? otherRunStart : otherRunLimit;
                } //End block
                break;
            } //End block
            if(newCaret == -1)            
            {
                newCaret = advance ? mLen + 1 : -1;
                break;
            } //End block
            if(newCaret <= lineEnd)            
            {
                newCaret = advance ? lineEnd : lineStart;
            } //End block
            break;
        } //End block
        int varA44B1DB7E51DCB32F152F35D1542F927_1290627675 = (newCaret);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1582670555 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1582670555;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.908 -0400", hash_original_method = "31252F4808C2C77A1E467D2963FB3AD5", hash_generated_method = "F603C3CABEA38AAFFDFEB56390DC4B05")
    private int getOffsetBeforeAfter(int runIndex, int runStart, int runLimit,
            boolean runIsRtl, int offset, boolean after) {
        addTaint(after);
        addTaint(offset);
        addTaint(runIsRtl);
        addTaint(runLimit);
        addTaint(runStart);
        addTaint(runIndex);
        if(runIndex < 0 || offset == (after ? mLen : 0))        
        {
            if(after)            
            {
                int var6B52596A9B4175F4D7F1FABD51E2E7FC_1067278740 = (TextUtils.getOffsetAfter(mText, offset + mStart) - mStart);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1533181053 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1533181053;
            } //End block
            int var2F0C4267C87745D020BF5404EE5190A4_1524204744 = (TextUtils.getOffsetBefore(mText, offset + mStart) - mStart);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_159130567 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_159130567;
        } //End block
        TextPaint wp = mWorkPaint;
        wp.set(mPaint);
        int spanStart = runStart;
        int spanLimit;
        if(mSpanned == null)        
        {
            spanLimit = runLimit;
        } //End block
        else
        {
            int target = after ? offset + 1 : offset;
            int limit = mStart + runLimit;
            while
(true)            
            {
                spanLimit = mSpanned.nextSpanTransition(mStart + spanStart, limit,
                        MetricAffectingSpan.class) - mStart;
                if(spanLimit >= target)                
                {
                    break;
                } //End block
                spanStart = spanLimit;
            } //End block
            MetricAffectingSpan[] spans = mSpanned.getSpans(mStart + spanStart,
                    mStart + spanLimit, MetricAffectingSpan.class);
            spans = TextUtils.removeEmptySpans(spans, mSpanned, MetricAffectingSpan.class);
            if(spans.length > 0)            
            {
                ReplacementSpan replacement = null;
for(int j = 0;j < spans.length;j++)
                {
                    MetricAffectingSpan span = spans[j];
                    if(span instanceof ReplacementSpan)                    
                    {
                        replacement = (ReplacementSpan)span;
                    } //End block
                    else
                    {
                        span.updateMeasureState(wp);
                    } //End block
                } //End block
                if(replacement != null)                
                {
                    int var0A648F3009EE37B492262A02201E0599_487346881 = (after ? spanLimit : spanStart);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1062401889 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1062401889;
                } //End block
            } //End block
        } //End block
        int flags = runIsRtl ? Paint.DIRECTION_RTL : Paint.DIRECTION_LTR;
        int cursorOpt = after ? Paint.CURSOR_AFTER : Paint.CURSOR_BEFORE;
        if(mCharsValid)        
        {
            int varDC09048C1871221F8481B7D8BBDF4D39_1054100951 = (wp.getTextRunCursor(mChars, spanStart, spanLimit - spanStart,
                    flags, offset, cursorOpt));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1200116501 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1200116501;
        } //End block
        else
        {
            int var1A92DB2830D2A0432E634183CF42DD43_1231807483 = (wp.getTextRunCursor(mText, mStart + spanStart,
                    mStart + spanLimit, flags, mStart + offset, cursorOpt) - mStart);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1083076093 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1083076093;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.911 -0400", hash_original_method = "F8AC228F4E44CF9CD673B1404700AC77", hash_generated_method = "6DB6297BECC29C4D5353A1B3EF890FC4")
    private float handleText(TextPaint wp, int start, int end,
            int contextStart, int contextEnd, boolean runIsRtl,
            Canvas c, float x, int top, int y, int bottom,
            FontMetricsInt fmi, boolean needWidth) {
        addTaint(needWidth);
        addTaint(fmi.getTaint());
        addTaint(bottom);
        addTaint(y);
        addTaint(top);
        addTaint(x);
        addTaint(c.getTaint());
        addTaint(runIsRtl);
        addTaint(contextEnd);
        addTaint(contextStart);
        addTaint(end);
        addTaint(start);
        addTaint(wp.getTaint());
        if(fmi != null)        
        {
            expandMetricsFromPaint(fmi, wp);
        } //End block
        int runLen = end - start;
        if(runLen == 0)        
        {
            float var7DFF51CA8EB990122513F24FFDAA4D9A_531757797 = (0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_249620509 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_249620509;
        } //End block
        float ret = 0;
        int contextLen = contextEnd - contextStart;
        if(needWidth || (c != null && (wp.bgColor != 0 || wp.underlineColor != 0 || runIsRtl)))        
        {
            int flags = runIsRtl ? Paint.DIRECTION_RTL : Paint.DIRECTION_LTR;
            if(mCharsValid)            
            {
                ret = wp.getTextRunAdvances(mChars, start, runLen,
                        contextStart, contextLen, flags, null, 0);
            } //End block
            else
            {
                int delta = mStart;
                ret = wp.getTextRunAdvances(mText, delta + start,
                        delta + end, delta + contextStart, delta + contextEnd,
                        flags, null, 0);
            } //End block
        } //End block
        if(c != null)        
        {
            if(runIsRtl)            
            {
                x -= ret;
            } //End block
            if(wp.bgColor != 0)            
            {
                int previousColor = wp.getColor();
                Paint.Style previousStyle = wp.getStyle();
                wp.setColor(wp.bgColor);
                wp.setStyle(Paint.Style.FILL);
                c.drawRect(x, top, x + ret, bottom, wp);
                wp.setStyle(previousStyle);
                wp.setColor(previousColor);
            } //End block
            if(wp.underlineColor != 0)            
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
            } //End block
            drawTextRun(c, wp, start, end, contextStart, contextEnd, runIsRtl,
                    x, y + wp.baselineShift);
        } //End block
        float varC9DB84E689736EF40376FD0AD37C61A1_324299751 = (runIsRtl ? -ret : ret);
                float var546ADE640B6EDFBC8A086EF31347E768_1508880504 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1508880504;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.912 -0400", hash_original_method = "5BB6CBCB4177EDC48B270A42A6989FB0", hash_generated_method = "991DA5B80489FFF308CE14BF24AAAE50")
    private float handleReplacement(ReplacementSpan replacement, TextPaint wp,
            int start, int limit, boolean runIsRtl, Canvas c,
            float x, int top, int y, int bottom, FontMetricsInt fmi,
            boolean needWidth) {
        addTaint(needWidth);
        addTaint(fmi.getTaint());
        addTaint(bottom);
        addTaint(y);
        addTaint(top);
        addTaint(x);
        addTaint(c.getTaint());
        addTaint(runIsRtl);
        addTaint(limit);
        addTaint(start);
        addTaint(wp.getTaint());
        addTaint(replacement.getTaint());
        float ret = 0;
        int textStart = mStart + start;
        int textLimit = mStart + limit;
        if(needWidth || (c != null && runIsRtl))        
        {
            int previousTop = 0;
            int previousAscent = 0;
            int previousDescent = 0;
            int previousBottom = 0;
            int previousLeading = 0;
            boolean needUpdateMetrics = (fmi != null);
            if(needUpdateMetrics)            
            {
                previousTop     = fmi.top;
                previousAscent  = fmi.ascent;
                previousDescent = fmi.descent;
                previousBottom  = fmi.bottom;
                previousLeading = fmi.leading;
            } //End block
            ret = replacement.getSize(wp, mText, textStart, textLimit, fmi);
            if(needUpdateMetrics)            
            {
                updateMetrics(fmi, previousTop, previousAscent, previousDescent, previousBottom,
                        previousLeading);
            } //End block
        } //End block
        if(c != null)        
        {
            if(runIsRtl)            
            {
                x -= ret;
            } //End block
            replacement.draw(c, mText, textStart, textLimit,
                    x, top, y, bottom, wp);
        } //End block
        float varC9DB84E689736EF40376FD0AD37C61A1_260096789 = (runIsRtl ? -ret : ret);
                float var546ADE640B6EDFBC8A086EF31347E768_1316576161 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1316576161;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.913 -0400", hash_original_method = "5FABB9B94E4E730AC35956B01320E35B", hash_generated_method = "DC3F0E3C39D6ACED2FE4469F77213FF4")
    private float handleRun(int start, int measureLimit,
            int limit, boolean runIsRtl, Canvas c, float x, int top, int y,
            int bottom, FontMetricsInt fmi, boolean needWidth) {
        addTaint(needWidth);
        addTaint(fmi.getTaint());
        addTaint(bottom);
        addTaint(y);
        addTaint(top);
        addTaint(x);
        addTaint(c.getTaint());
        addTaint(runIsRtl);
        addTaint(limit);
        addTaint(measureLimit);
        addTaint(start);
        if(start == measureLimit)        
        {
            TextPaint wp = mWorkPaint;
            wp.set(mPaint);
            if(fmi != null)            
            {
                expandMetricsFromPaint(fmi, wp);
            } //End block
            float var7DFF51CA8EB990122513F24FFDAA4D9A_1483104022 = (0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_528995895 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_528995895;
        } //End block
        if(mSpanned == null)        
        {
            TextPaint wp = mWorkPaint;
            wp.set(mPaint);
            final int mlimit = measureLimit;
            float varC1E1ED0007493405A7393E079FB9D898_233565275 = (handleText(wp, start, mlimit, start, limit, runIsRtl, c, x, top,
                    y, bottom, fmi, needWidth || mlimit < measureLimit));
                        float var546ADE640B6EDFBC8A086EF31347E768_1049528528 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1049528528;
        } //End block
        mMetricAffectingSpanSpanSet.init(mSpanned, mStart + start, mStart + limit);
        mCharacterStyleSpanSet.init(mSpanned, mStart + start, mStart + limit);
        final float originalX = x;
for(int i = start, inext;i < measureLimit;i = inext)
        {
            TextPaint wp = mWorkPaint;
            wp.set(mPaint);
            inext = mMetricAffectingSpanSpanSet.getNextTransition(mStart + i, mStart + limit) -
                    mStart;
            int mlimit = Math.min(inext, measureLimit);
            ReplacementSpan replacement = null;
for(int j = 0;j < mMetricAffectingSpanSpanSet.numberOfSpans;j++)
            {
                if((mMetricAffectingSpanSpanSet.spanStarts[j] >= mStart + mlimit) ||
                        (mMetricAffectingSpanSpanSet.spanEnds[j] <= mStart + i))                
                continue;
                MetricAffectingSpan span = mMetricAffectingSpanSpanSet.spans[j];
                if(span instanceof ReplacementSpan)                
                {
                    replacement = (ReplacementSpan)span;
                } //End block
                else
                {
                    span.updateDrawState(wp);
                } //End block
            } //End block
            if(replacement != null)            
            {
                x += handleReplacement(replacement, wp, i, mlimit, runIsRtl, c, x, top, y,
                        bottom, fmi, needWidth || mlimit < measureLimit);
                continue;
            } //End block
            if(c == null)            
            {
                x += handleText(wp, i, mlimit, i, inext, runIsRtl, c, x, top,
                        y, bottom, fmi, needWidth || mlimit < measureLimit);
            } //End block
            else
            {
for(int j = i, jnext;j < mlimit;j = jnext)
                {
                    jnext = mCharacterStyleSpanSet.getNextTransition(mStart + j, mStart + mlimit) -
                            mStart;
                    wp.set(mPaint);
for(int k = 0;k < mCharacterStyleSpanSet.numberOfSpans;k++)
                    {
                        if((mCharacterStyleSpanSet.spanStarts[k] >= mStart + jnext) ||
                                (mCharacterStyleSpanSet.spanEnds[k] <= mStart + j))                        
                        continue;
                        CharacterStyle span = mCharacterStyleSpanSet.spans[k];
                        span.updateDrawState(wp);
                    } //End block
                    x += handleText(wp, j, jnext, i, inext, runIsRtl, c, x,
                            top, y, bottom, fmi, needWidth || jnext < measureLimit);
                } //End block
            } //End block
        } //End block
        float var31624121923BF38606FE3CEF1FCF0D33_1348282182 = (x - originalX);
                float var546ADE640B6EDFBC8A086EF31347E768_1426441048 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1426441048;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.915 -0400", hash_original_method = "C8ABF2DC6B89611B840AEC4DBAADD344", hash_generated_method = "5A31470D12DCEAE542D801F2AEA87AE9")
    private void drawTextRun(Canvas c, TextPaint wp, int start, int end,
            int contextStart, int contextEnd, boolean runIsRtl, float x, int y) {
        addTaint(y);
        addTaint(x);
        addTaint(runIsRtl);
        addTaint(contextEnd);
        addTaint(contextStart);
        addTaint(end);
        addTaint(start);
        addTaint(wp.getTaint());
        addTaint(c.getTaint());
        int flags = runIsRtl ? Canvas.DIRECTION_RTL : Canvas.DIRECTION_LTR;
        if(mCharsValid)        
        {
            int count = end - start;
            int contextCount = contextEnd - contextStart;
            c.drawTextRun(mChars, start, count, contextStart, contextCount,
                    x, y, flags, wp);
        } //End block
        else
        {
            int delta = mStart;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.915 -0400", hash_original_method = "AC74D3C7A92A1C0DA8A76C86F50D3219", hash_generated_method = "CF1F627898C22299F79B913D4FA554C0")
     float ascent(int pos) {
        addTaint(pos);
        if(mSpanned == null)        
        {
            float var7898FDD4C57CA196F4A9E38681132907_554550797 = (mPaint.ascent());
                        float var546ADE640B6EDFBC8A086EF31347E768_644849438 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_644849438;
        } //End block
        pos += mStart;
        MetricAffectingSpan[] spans = mSpanned.getSpans(pos, pos + 1, MetricAffectingSpan.class);
        if(spans.length == 0)        
        {
            float var7898FDD4C57CA196F4A9E38681132907_377572770 = (mPaint.ascent());
                        float var546ADE640B6EDFBC8A086EF31347E768_106577031 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_106577031;
        } //End block
        TextPaint wp = mWorkPaint;
        wp.set(mPaint);
for(MetricAffectingSpan span : spans)
        {
            span.updateMeasureState(wp);
        } //End block
        float var5C9EBDA144BF3D2209A03E490A1D8FCF_1216133845 = (wp.ascent());
                float var546ADE640B6EDFBC8A086EF31347E768_686029728 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_686029728;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.916 -0400", hash_original_method = "73134044CD530D6AE99976E01BA5E625", hash_generated_method = "1F0738C2E0C75BCB8096AC0541913907")
     float nextTab(float h) {
        addTaint(h);
        if(mTabs != null)        
        {
            float varD60E858AEC91970560957EBE8A5A4BFA_157512999 = (mTabs.nextTab(h));
                        float var546ADE640B6EDFBC8A086EF31347E768_833419511 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_833419511;
        } //End block
        float var8B6EF79F5A67BF3F92C4BE109AF2E02D_1078624923 = (TabStops.nextDefaultStop(h, TAB_INCREMENT));
                float var546ADE640B6EDFBC8A086EF31347E768_1695797726 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1695797726;
        // ---------- Original Method ----------
        //if (mTabs != null) {
            //return mTabs.nextTab(h);
        //}
        //return TabStops.nextDefaultStop(h, TAB_INCREMENT);
    }

    
    private static class SpanSet<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.916 -0400", hash_original_field = "D6B5FCDB35353F6A4017F11EBD647D09", hash_generated_field = "4D016F914E51DC9C3732F557E45EB452")

        int numberOfSpans;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.917 -0400", hash_original_field = "A46EFC2A2782C9238263F63F5CEA5D42", hash_generated_field = "32FCADE2328772A5D81411E0AA303B75")

        E[] spans;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.917 -0400", hash_original_field = "C24BD1BD2949B9599EEDD7F0387EE723", hash_generated_field = "1D3712C585C8808C22172D42F4D7BB90")

        int[] spanStarts;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.917 -0400", hash_original_field = "0502422B326B747A365D76C9CCE8E955", hash_generated_field = "8ED878CF75FF4569DFB3C4F0CC5B72F1")

        int[] spanEnds;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.917 -0400", hash_original_field = "6612E29FBDE8178CC4AD5176D3C8A9E6", hash_generated_field = "2E2862EF6D4B111BA84644CB0E9CD297")

        int[] spanFlags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.917 -0400", hash_original_field = "A69F0373B093A535ADB7C9273781CD43", hash_generated_field = "7DE61887E85E1CD432AAA8825CCFB81E")

        Class<? extends E> classType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.917 -0400", hash_original_method = "08793871E7FAA5C02A5C5115CBB016E1", hash_generated_method = "7A2C4BAA57A8D03BA9484E8C2D4BDD35")
          SpanSet(Class<? extends E> type) {
            classType = type;
            numberOfSpans = 0;
            // ---------- Original Method ----------
            //classType = type;
            //numberOfSpans = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.918 -0400", hash_original_method = "DCBC67B7023E3760B724E28392339389", hash_generated_method = "F5FB0B202E38A739397227BE6DA6ABEB")
        @SuppressWarnings("unchecked")
        public void init(Spanned spanned, int start, int limit) {
            addTaint(limit);
            addTaint(start);
            addTaint(spanned.getTaint());
            final E[] allSpans = spanned.getSpans(start, limit, classType);
            final int length = allSpans.length;
            if(length > 0 && (spans == null || spans.length < length))            
            {
                spans = (E[]) Array.newInstance(classType, length);
                spanStarts = new int[length];
                spanEnds = new int[length];
                spanFlags = new int[length];
            } //End block
            numberOfSpans = 0;
for(int i = 0;i < length;i++)
            {
                final E span = allSpans[i];
                final int spanStart = spanned.getSpanStart(span);
                final int spanEnd = spanned.getSpanEnd(span);
                if(spanStart == spanEnd)                
                continue;
                final int spanFlag = spanned.getSpanFlags(span);
                spans[numberOfSpans] = span;
                spanStarts[numberOfSpans] = spanStart;
                spanEnds[numberOfSpans] = spanEnd;
                spanFlags[numberOfSpans] = spanFlag;
                numberOfSpans++;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.919 -0400", hash_original_method = "14C2C64E52F272A1D061AF5FA0B61C4E", hash_generated_method = "BD41BBC68AEAC619AA4AB37ECF5DB841")
        public boolean hasSpansIntersecting(int start, int end) {
            addTaint(end);
            addTaint(start);
for(int i = 0;i < numberOfSpans;i++)
            {
                if(spanStarts[i] >= end || spanEnds[i] <= start)                
                continue;
                boolean varB326B5062B2F0E69046810717534CB09_275620405 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1664418922 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1664418922;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1173139579 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1247856544 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1247856544;
            // ---------- Original Method ----------
            //for (int i = 0; i < numberOfSpans; i++) {
                //if (spanStarts[i] >= end || spanEnds[i] <= start) continue;
                //return true;
            //}
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.920 -0400", hash_original_method = "70A36A49F9CEFC761501124E36FC2A8C", hash_generated_method = "BB5254AF9AA6C3C042F7B0FCFB2014CB")
         int getNextTransition(int start, int limit) {
            addTaint(limit);
            addTaint(start);
for(int i = 0;i < numberOfSpans;i++)
            {
                final int spanStart = spanStarts[i];
                final int spanEnd = spanEnds[i];
                if(spanStart > start && spanStart < limit)                
                limit = spanStart;
                if(spanEnd > start && spanEnd < limit)                
                limit = spanEnd;
            } //End block
            int varAA9F73EEA60A006820D0F8768BC8A3FC_232263152 = (limit);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971637121 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971637121;
            // ---------- Original Method ----------
            //for (int i = 0; i < numberOfSpans; i++) {
                //final int spanStart = spanStarts[i];
                //final int spanEnd = spanEnds[i];
                //if (spanStart > start && spanStart < limit) limit = spanStart;
                //if (spanEnd > start && spanEnd < limit) limit = spanEnd;
            //}
            //return limit;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.920 -0400", hash_original_method = "5E840A260140B15B0CFAF6F2BC649D6A", hash_generated_method = "45D6B23027A8EAF82BF142D1CA4A1B6A")
        public void recycle() {
for(int i = 0;i < numberOfSpans;i++)
            {
                spans[i] = null;
            } //End block
            // ---------- Original Method ----------
            //for (int i = 0; i < numberOfSpans; i++) {
                //spans[i] = null; 
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.920 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.920 -0400", hash_original_field = "E871AFED5937EF2A18CE095CADBDB246", hash_generated_field = "B787628D86685B4DD27C326E2D91EEE2")

    private static final TextLine[] sCached = new TextLine[3];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.920 -0400", hash_original_field = "5857BDFF3BF33113730586AF5B28164F", hash_generated_field = "D5E340FF9F0E2C74F920DF02A6624213")

    private static final int TAB_INCREMENT = 20;
}

