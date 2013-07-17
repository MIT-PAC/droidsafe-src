package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.style.LeadingMarginSpan;
import android.text.style.LeadingMarginSpan.LeadingMarginSpan2;
import android.text.style.LineHeightSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.TabStopSpan;
import android.util.Log;
import com.android.internal.util.ArrayUtils;

public class StaticLayout extends Layout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.690 -0400", hash_original_field = "6CD75FA86B8D1E573AF761513C2464BF", hash_generated_field = "45537663750337309A584754E1437CDD")

    private int mLineCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.690 -0400", hash_original_field = "A6796D45932911E4DA1D9D40D1BD23B8", hash_generated_field = "74C5EEEB9113B0F29D66E0A4983A6BC3")

    private int mTopPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.691 -0400", hash_original_field = "097A31AA17188409E251DABE4869FAFE", hash_generated_field = "8A7C981A0C6837E513C477AD1250B374")

    private int mBottomPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.691 -0400", hash_original_field = "11C985F30142FD30ACDDFE7CD3BD4A9B", hash_generated_field = "75F4039C98FB52077D38E34F530EB3FF")

    private int mColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.691 -0400", hash_original_field = "5713AC9F49879DE1055FA780DFEFDF1C", hash_generated_field = "C354DF48C5764CCC7B8B820C49BF2BBD")

    private int mEllipsizedWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.691 -0400", hash_original_field = "1BB5D78D3AAC39AEAEB752C0B85D10E9", hash_generated_field = "26F954E05EF8E6C19C537B63E9266033")

    private int[] mLines;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.691 -0400", hash_original_field = "2801B37F60217970AB463F0E5596FCCD", hash_generated_field = "7D53F177386EEFF604DBA9C007C99633")

    private Directions[] mLineDirections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.691 -0400", hash_original_field = "1DE64451AE73776A90C4D2C1EEF5D2F6", hash_generated_field = "15DFAE1051C19AC15963DEF70B1F9BF5")

    private int mMaximumVisibleLineCount = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.691 -0400", hash_original_field = "6D906AC98A7DED22536ECD22D9912986", hash_generated_field = "67359422AB8F87EBC819B683687CEFC5")

    private MeasuredText mMeasured;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.691 -0400", hash_original_field = "FAD3F9B7F49B89883B041D2654B13B33", hash_generated_field = "9F4F72572DE50EBE55E7D6F43A8C24E4")

    private Paint.FontMetricsInt mFontMetricsInt = new Paint.FontMetricsInt();
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.691 -0400", hash_original_method = "C77149727B404FEFD5CB3129B7BB45BF", hash_generated_method = "A2C7FD3BDCFF5AE3C68F7EA7EEA215C3")
    public  StaticLayout(CharSequence source, TextPaint paint,
                        int width,
                        Alignment align, float spacingmult, float spacingadd,
                        boolean includepad) {
        this(source, 0, source.length(), paint, width, align,
             spacingmult, spacingadd, includepad);
        addTaint(includepad);
        addTaint(spacingadd);
        addTaint(spacingmult);
        addTaint(align.getTaint());
        addTaint(width);
        addTaint(paint.getTaint());
        addTaint(source.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.692 -0400", hash_original_method = "81565FB766EC1D266415894033F3BC38", hash_generated_method = "1BDEA4DDCB95B2D4AE1B3855FDF537E6")
    public  StaticLayout(CharSequence source, TextPaint paint,
            int width, Alignment align, TextDirectionHeuristic textDir,
            float spacingmult, float spacingadd,
            boolean includepad) {
        this(source, 0, source.length(), paint, width, align, textDir,
                spacingmult, spacingadd, includepad);
        addTaint(includepad);
        addTaint(spacingadd);
        addTaint(spacingmult);
        addTaint(textDir.getTaint());
        addTaint(align.getTaint());
        addTaint(width);
        addTaint(paint.getTaint());
        addTaint(source.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.692 -0400", hash_original_method = "BF066121E6D6D3B30CB2E4FB82D6E631", hash_generated_method = "09C0F14EBB940ED04BE0CFE26AF7FE94")
    public  StaticLayout(CharSequence source, int bufstart, int bufend,
                        TextPaint paint, int outerwidth,
                        Alignment align,
                        float spacingmult, float spacingadd,
                        boolean includepad) {
        this(source, bufstart, bufend, paint, outerwidth, align,
             spacingmult, spacingadd, includepad, null, 0);
        addTaint(includepad);
        addTaint(spacingadd);
        addTaint(spacingmult);
        addTaint(align.getTaint());
        addTaint(outerwidth);
        addTaint(paint.getTaint());
        addTaint(bufend);
        addTaint(bufstart);
        addTaint(source.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.693 -0400", hash_original_method = "683465774808809C7366667F354731A1", hash_generated_method = "186A22AC5077869045034CC835F739C5")
    public  StaticLayout(CharSequence source, int bufstart, int bufend,
            TextPaint paint, int outerwidth,
            Alignment align, TextDirectionHeuristic textDir,
            float spacingmult, float spacingadd,
            boolean includepad) {
        this(source, bufstart, bufend, paint, outerwidth, align, textDir,
                spacingmult, spacingadd, includepad, null, 0, Integer.MAX_VALUE);
        addTaint(includepad);
        addTaint(spacingadd);
        addTaint(spacingmult);
        addTaint(textDir.getTaint());
        addTaint(align.getTaint());
        addTaint(outerwidth);
        addTaint(paint.getTaint());
        addTaint(bufend);
        addTaint(bufstart);
        addTaint(source.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.694 -0400", hash_original_method = "D92F1C5E6D18A86EA341983F1D2D5889", hash_generated_method = "376E1BA0E40B0B0D45744B8AA2B98A9C")
    public  StaticLayout(CharSequence source, int bufstart, int bufend,
            TextPaint paint, int outerwidth,
            Alignment align,
            float spacingmult, float spacingadd,
            boolean includepad,
            TextUtils.TruncateAt ellipsize, int ellipsizedWidth) {
        this(source, bufstart, bufend, paint, outerwidth, align,
                TextDirectionHeuristics.FIRSTSTRONG_LTR,
                spacingmult, spacingadd, includepad, ellipsize, ellipsizedWidth, Integer.MAX_VALUE);
        addTaint(ellipsizedWidth);
        addTaint(ellipsize.getTaint());
        addTaint(includepad);
        addTaint(spacingadd);
        addTaint(spacingmult);
        addTaint(align.getTaint());
        addTaint(outerwidth);
        addTaint(paint.getTaint());
        addTaint(bufend);
        addTaint(bufstart);
        addTaint(source.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.696 -0400", hash_original_method = "67715870CA89D1E43E3638ABED5B90D0", hash_generated_method = "1C4DC0C3B0F775E883C7672994F557B4")
    public  StaticLayout(CharSequence source, int bufstart, int bufend,
                        TextPaint paint, int outerwidth,
                        Alignment align, TextDirectionHeuristic textDir,
                        float spacingmult, float spacingadd,
                        boolean includepad,
                        TextUtils.TruncateAt ellipsize, int ellipsizedWidth, int maxLines) {
        super((ellipsize == null)
                ? source
                : (source instanceof Spanned)
                    ? new SpannedEllipsizer(source)
                    : new Ellipsizer(source),
              paint, outerwidth, align, textDir, spacingmult, spacingadd);
        addTaint(ellipsize.getTaint());
        addTaint(includepad);
        addTaint(spacingadd);
        addTaint(spacingmult);
        addTaint(textDir.getTaint());
        addTaint(align.getTaint());
        addTaint(paint.getTaint());
        addTaint(bufend);
        addTaint(bufstart);
        addTaint(source.getTaint());
        if(ellipsize != null)        
        {
            Ellipsizer e = (Ellipsizer) getText();
            e.mLayout = this;
            e.mWidth = ellipsizedWidth;
            e.mMethod = ellipsize;
            mEllipsizedWidth = ellipsizedWidth;
            mColumns = COLUMNS_ELLIPSIZE;
        } //End block
        else
        {
            mColumns = COLUMNS_NORMAL;
            mEllipsizedWidth = outerwidth;
        } //End block
        mLines = new int[ArrayUtils.idealIntArraySize(2 * mColumns)];
        mLineDirections = new Directions[
                             ArrayUtils.idealIntArraySize(2 * mColumns)];
        mMaximumVisibleLineCount = maxLines;
        mMeasured = MeasuredText.obtain();
        generate(source, bufstart, bufend, paint, outerwidth, textDir, spacingmult,
                 spacingadd, includepad, includepad, ellipsizedWidth,
                 ellipsize);
        mMeasured = MeasuredText.recycle(mMeasured);
        mFontMetricsInt = null;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.697 -0400", hash_original_method = "F6D0B9C991ED85508405BA894E3CF311", hash_generated_method = "929A49CB2EA338727AF65A2DC3C24AB9")
      StaticLayout(CharSequence text) {
        super(text, null, 0, null, 0, 0);
        addTaint(text.getTaint());
        mColumns = COLUMNS_ELLIPSIZE;
        mLines = new int[ArrayUtils.idealIntArraySize(2 * mColumns)];
        mLineDirections = new Directions[
                             ArrayUtils.idealIntArraySize(2 * mColumns)];
        mMeasured = MeasuredText.obtain();
        // ---------- Original Method ----------
        //mColumns = COLUMNS_ELLIPSIZE;
        //mLines = new int[ArrayUtils.idealIntArraySize(2 * mColumns)];
        //mLineDirections = new Directions[
                             //ArrayUtils.idealIntArraySize(2 * mColumns)];
        //mMeasured = MeasuredText.obtain();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.704 -0400", hash_original_method = "36200F938D6B110E70DA8FCD0A142EF7", hash_generated_method = "0E8F9F13FCDBB03D7B2BA016C7665249")
     void generate(CharSequence source, int bufStart, int bufEnd,
                        TextPaint paint, int outerWidth,
                        TextDirectionHeuristic textDir, float spacingmult,
                        float spacingadd, boolean includepad,
                        boolean trackpad, float ellipsizedWidth,
                        TextUtils.TruncateAt ellipsize) {
        addTaint(ellipsize.getTaint());
        addTaint(ellipsizedWidth);
        addTaint(trackpad);
        addTaint(includepad);
        addTaint(spacingadd);
        addTaint(spacingmult);
        addTaint(textDir.getTaint());
        addTaint(outerWidth);
        addTaint(paint.getTaint());
        addTaint(bufEnd);
        addTaint(bufStart);
        addTaint(source.getTaint());
        mLineCount = 0;
        int v = 0;
        boolean needMultiply = (spacingmult != 1 || spacingadd != 0);
        Paint.FontMetricsInt fm = mFontMetricsInt;
        int[] chooseHtv = null;
        MeasuredText measured = mMeasured;
        Spanned spanned = null;
        if(source instanceof Spanned)        
        spanned = (Spanned) source;
        int DEFAULT_DIR = DIR_LEFT_TO_RIGHT;
        int paraEnd;
for(int paraStart = bufStart;paraStart <= bufEnd;paraStart = paraEnd)
        {
            paraEnd = TextUtils.indexOf(source, CHAR_NEW_LINE, paraStart, bufEnd);
            if(paraEnd < 0)            
            paraEnd = bufEnd;
            else
            paraEnd++;
            int firstWidthLineLimit = mLineCount + 1;
            int firstWidth = outerWidth;
            int restWidth = outerWidth;
            LineHeightSpan[] chooseHt = null;
            if(spanned != null)            
            {
                LeadingMarginSpan[] sp = getParagraphSpans(spanned, paraStart, paraEnd,
                        LeadingMarginSpan.class);
for(int i = 0;i < sp.length;i++)
                {
                    LeadingMarginSpan lms = sp[i];
                    firstWidth -= sp[i].getLeadingMargin(true);
                    restWidth -= sp[i].getLeadingMargin(false);
                    if(lms instanceof LeadingMarginSpan2)                    
                    {
                        LeadingMarginSpan2 lms2 = (LeadingMarginSpan2) lms;
                        int lmsFirstLine = getLineForOffset(spanned.getSpanStart(lms2));
                        firstWidthLineLimit = lmsFirstLine + lms2.getLeadingMarginLineCount();
                    } //End block
                } //End block
                chooseHt = getParagraphSpans(spanned, paraStart, paraEnd, LineHeightSpan.class);
                if(chooseHt.length != 0)                
                {
                    if(chooseHtv == null ||
                        chooseHtv.length < chooseHt.length)                    
                    {
                        chooseHtv = new int[ArrayUtils.idealIntArraySize(
                                            chooseHt.length)];
                    } //End block
for(int i = 0;i < chooseHt.length;i++)
                    {
                        int o = spanned.getSpanStart(chooseHt[i]);
                        if(o < paraStart)                        
                        {
                            chooseHtv[i] = getLineTop(getLineForOffset(o));
                        } //End block
                        else
                        {
                            chooseHtv[i] = v;
                        } //End block
                    } //End block
                } //End block
            } //End block
            measured.setPara(source, paraStart, paraEnd, textDir);
            char[] chs = measured.mChars;
            float[] widths = measured.mWidths;
            byte[] chdirs = measured.mLevels;
            int dir = measured.mDir;
            boolean easy = measured.mEasy;
            int width = firstWidth;
            float w = 0;
            int here = paraStart;
            int ok = paraStart;
            float okWidth = w;
            int okAscent = 0;
            int okDescent = 0;
            int okTop = 0;
            int okBottom = 0;
            int fit = paraStart;
            float fitWidth = w;
            int fitAscent = 0;
            int fitDescent = 0;
            int fitTop = 0;
            int fitBottom = 0;
            boolean hasTabOrEmoji = false;
            boolean hasTab = false;
            TabStops tabStops = null;
for(int spanStart = paraStart, spanEnd = spanStart, nextSpanStart;spanStart < paraEnd;spanStart = nextSpanStart)
            {
                if(spanStart == spanEnd)                
                {
                    if(spanned == null)                    
                    spanEnd = paraEnd;
                    else
                    spanEnd = spanned.nextSpanTransition(spanStart, paraEnd,
                                MetricAffectingSpan.class);
                    int spanLen = spanEnd - spanStart;
                    if(spanned == null)                    
                    {
                        measured.addStyleRun(paint, spanLen, fm);
                    } //End block
                    else
                    {
                        MetricAffectingSpan[] spans = spanned.getSpans(spanStart, spanEnd, MetricAffectingSpan.class);
                        spans = TextUtils.removeEmptySpans(spans, spanned,
                                MetricAffectingSpan.class);
                        measured.addStyleRun(paint, spans, spanLen, fm);
                    } //End block
                } //End block
                nextSpanStart = spanEnd;
                int fmTop = fm.top;
                int fmBottom = fm.bottom;
                int fmAscent = fm.ascent;
                int fmDescent = fm.descent;
for(int j = spanStart;j < spanEnd;j++)
                {
                    char c = chs[j - paraStart];
                    if(c == CHAR_NEW_LINE)                    
                    {
                    } //End block
                    else
                    if(c == CHAR_TAB)                    
                    {
                        if(hasTab == false)                        
                        {
                            hasTab = true;
                            hasTabOrEmoji = true;
                            if(spanned != null)                            
                            {
                                TabStopSpan[] spans = getParagraphSpans(spanned, paraStart,
                                        paraEnd, TabStopSpan.class);
                                if(spans.length > 0)                                
                                {
                                    tabStops = new TabStops(TAB_INCREMENT, spans);
                                } //End block
                            } //End block
                        } //End block
                        if(tabStops != null)                        
                        {
                            w = tabStops.nextTab(w);
                        } //End block
                        else
                        {
                            w = TabStops.nextDefaultStop(w, TAB_INCREMENT);
                        } //End block
                    } //End block
                    else
                    if(c >= CHAR_FIRST_HIGH_SURROGATE && c <= CHAR_LAST_LOW_SURROGATE
                            && j + 1 < spanEnd)                    
                    {
                        int emoji = Character.codePointAt(chs, j - paraStart);
                        if(emoji >= MIN_EMOJI && emoji <= MAX_EMOJI)                        
                        {
                            Bitmap bm = EMOJI_FACTORY.getBitmapFromAndroidPua(emoji);
                            if(bm != null)                            
                            {
                                Paint whichPaint;
                                if(spanned == null)                                
                                {
                                    whichPaint = paint;
                                } //End block
                                else
                                {
                                    whichPaint = mWorkPaint;
                                } //End block
                                float wid = bm.getWidth() * -whichPaint.ascent() / bm.getHeight();
                                w += wid;
                                hasTabOrEmoji = true;
                                j++;
                            } //End block
                            else
                            {
                                w += widths[j - paraStart];
                            } //End block
                        } //End block
                        else
                        {
                            w += widths[j - paraStart];
                        } //End block
                    } //End block
                    else
                    {
                        w += widths[j - paraStart];
                    } //End block
                    if(w <= width)                    
                    {
                        fitWidth = w;
                        fit = j + 1;
                        if(fmTop < fitTop)                        
                        fitTop = fmTop;
                        if(fmAscent < fitAscent)                        
                        fitAscent = fmAscent;
                        if(fmDescent > fitDescent)                        
                        fitDescent = fmDescent;
                        if(fmBottom > fitBottom)                        
                        fitBottom = fmBottom;
                        if(c == CHAR_SPACE || c == CHAR_TAB ||
                            ((c == CHAR_DOT || c == CHAR_COMMA ||
                                    c == CHAR_COLON || c == CHAR_SEMICOLON) &&
                             (j - 1 < here || !Character.isDigit(chs[j - 1 - paraStart])) &&
                             (j + 1 >= spanEnd || !Character.isDigit(chs[j + 1 - paraStart]))) ||
                            ((c == CHAR_SLASH || c == CHAR_HYPHEN) &&
                             (j + 1 >= spanEnd || !Character.isDigit(chs[j + 1 - paraStart]))) ||
                            (c >= CHAR_FIRST_CJK && isIdeographic(c, true) &&
                             j + 1 < spanEnd && isIdeographic(chs[j + 1 - paraStart], false)))                        
                        {
                            okWidth = w;
                            ok = j + 1;
                            if(fitTop < okTop)                            
                            okTop = fitTop;
                            if(fitAscent < okAscent)                            
                            okAscent = fitAscent;
                            if(fitDescent > okDescent)                            
                            okDescent = fitDescent;
                            if(fitBottom > okBottom)                            
                            okBottom = fitBottom;
                        } //End block
                    } //End block
                    else
                    {
                        final boolean moreChars = (j + 1 < spanEnd);
                        int endPos;
                        int above;
                        int below;
                        int top;
                        int bottom;
                        float currentTextWidth;
                        if(ok != here)                        
                        {
                            if(c == CHAR_SPACE)                            
                            ok = j + 1;
                            while
(ok < spanEnd && chs[ok - paraStart] == CHAR_SPACE)                            
                            {
                                ok++;
                            } //End block
                            endPos = ok;
                            above = okAscent;
                            below = okDescent;
                            top = okTop;
                            bottom = okBottom;
                            currentTextWidth = okWidth;
                        } //End block
                        else
                        if(fit != here)                        
                        {
                            endPos = fit;
                            above = fitAscent;
                            below = fitDescent;
                            top = fitTop;
                            bottom = fitBottom;
                            currentTextWidth = fitWidth;
                        } //End block
                        else
                        {
                            endPos = here + 1;
                            above = fm.ascent;
                            below = fm.descent;
                            top = fm.top;
                            bottom = fm.bottom;
                            currentTextWidth = widths[here - paraStart];
                        } //End block
                        v = out(source, here, endPos,
                                above, below, top, bottom,
                                v, spacingmult, spacingadd, chooseHt,chooseHtv, fm, hasTabOrEmoji,
                                needMultiply, chdirs, dir, easy, bufEnd, includepad, trackpad,
                                chs, widths, paraStart, ellipsize, ellipsizedWidth,
                                currentTextWidth, paint, moreChars);
                        here = endPos;
                        if(here < spanStart)                        
                        {
                            j = nextSpanStart = here;
                        } //End block
                        else
                        {
                            j = here - 1;
                        } //End block
                        ok = fit = here;
                        w = 0;
                        fitAscent = fitDescent = fitTop = fitBottom = 0;
                        okAscent = okDescent = okTop = okBottom = 0;
                        if(--firstWidthLineLimit <= 0)                        
                        {
                            width = restWidth;
                        } //End block
                    } //End block
                    if(mLineCount >= mMaximumVisibleLineCount)                    
                    {
                        break;
                    } //End block
                } //End block
            } //End block
            if(paraEnd != here && mLineCount < mMaximumVisibleLineCount)            
            {
                if((fitTop | fitBottom | fitDescent | fitAscent) == 0)                
                {
                    paint.getFontMetricsInt(fm);
                    fitTop = fm.top;
                    fitBottom = fm.bottom;
                    fitAscent = fm.ascent;
                    fitDescent = fm.descent;
                } //End block
                v = out(source,
                        here, paraEnd, fitAscent, fitDescent,
                        fitTop, fitBottom,
                        v,
                        spacingmult, spacingadd, chooseHt,
                        chooseHtv, fm, hasTabOrEmoji,
                        needMultiply, chdirs, dir, easy, bufEnd,
                        includepad, trackpad, chs,
                        widths, paraStart, ellipsize,
                        ellipsizedWidth, w, paint, paraEnd != bufEnd);
            } //End block
            paraStart = paraEnd;
            if(paraEnd == bufEnd)            
            break;
        } //End block
        if((bufEnd == bufStart || source.charAt(bufEnd - 1) == CHAR_NEW_LINE) &&
                mLineCount < mMaximumVisibleLineCount)        
        {
            paint.getFontMetricsInt(fm);
            v = out(source,
                    bufEnd, bufEnd, fm.ascent, fm.descent,
                    fm.top, fm.bottom,
                    v,
                    spacingmult, spacingadd, null,
                    null, fm, false,
                    needMultiply, null, DEFAULT_DIR, true, bufEnd,
                    includepad, trackpad, null,
                    null, bufStart, ellipsize,
                    ellipsizedWidth, 0, paint, false);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    private static final boolean isIdeographic(char c, boolean includeNonStarters) {
        if (c >= '\u2E80' && c <= '\u2FFF') {
            return true; 
        }
        if (c == '\u3000') {
            return true; 
        }
        if (c >= '\u3040' && c <= '\u309F') {
            if (!includeNonStarters) {
                switch (c) {
                case '\u3041': 
                case '\u3043': 
                case '\u3045': 
                case '\u3047': 
                case '\u3049': 
                case '\u3063': 
                case '\u3083': 
                case '\u3085': 
                case '\u3087': 
                case '\u308E': 
                case '\u3095': 
                case '\u3096': 
                case '\u309B': 
                case '\u309C': 
                case '\u309D': 
                case '\u309E': 
                    return false;
                }
            }
            return true; 
        }
        if (c >= '\u30A0' && c <= '\u30FF') {
            if (!includeNonStarters) {
                switch (c) {
                case '\u30A0': 
                case '\u30A1': 
                case '\u30A3': 
                case '\u30A5': 
                case '\u30A7': 
                case '\u30A9': 
                case '\u30C3': 
                case '\u30E3': 
                case '\u30E5': 
                case '\u30E7': 
                case '\u30EE': 
                case '\u30F5': 
                case '\u30F6': 
                case '\u30FB': 
                case '\u30FC': 
                case '\u30FD': 
                case '\u30FE': 
                    return false;
                }
            }
            return true; 
        }
        if (c >= '\u3400' && c <= '\u4DB5') {
            return true; 
        }
        if (c >= '\u4E00' && c <= '\u9FBB') {
            return true; 
        }
        if (c >= '\uF900' && c <= '\uFAD9') {
            return true; 
        }
        if (c >= '\uA000' && c <= '\uA48F') {
            return true; 
        }
        if (c >= '\uA490' && c <= '\uA4CF') {
            return true; 
        }
        if (c >= '\uFE62' && c <= '\uFE66') {
            return true; 
        }
        if (c >= '\uFF10' && c <= '\uFF19') {
            return true; 
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.707 -0400", hash_original_method = "478F3FA593939ABCBF542030DE605E96", hash_generated_method = "89CEF3576D47C9CD0D28C5165F6D1E4A")
    private int out(CharSequence text, int start, int end,
                      int above, int below, int top, int bottom, int v,
                      float spacingmult, float spacingadd,
                      LineHeightSpan[] chooseHt, int[] chooseHtv,
                      Paint.FontMetricsInt fm, boolean hasTabOrEmoji,
                      boolean needMultiply, byte[] chdirs, int dir,
                      boolean easy, int bufEnd, boolean includePad,
                      boolean trackPad, char[] chs,
                      float[] widths, int widthStart, TextUtils.TruncateAt ellipsize,
                      float ellipsisWidth, float textWidth,
                      TextPaint paint, boolean moreChars) {
        addTaint(moreChars);
        addTaint(paint.getTaint());
        addTaint(textWidth);
        addTaint(ellipsisWidth);
        addTaint(ellipsize.getTaint());
        addTaint(widths[0]);
        addTaint(trackPad);
        addTaint(includePad);
        addTaint(bufEnd);
        addTaint(easy);
        addTaint(needMultiply);
        addTaint(hasTabOrEmoji);
        addTaint(fm.getTaint());
        addTaint(chooseHtv[0]);
        addTaint(chooseHt[0].getTaint());
        addTaint(spacingadd);
        addTaint(spacingmult);
        addTaint(text.getTaint());
        int j = mLineCount;
        int off = j * mColumns;
        int want = off + mColumns + TOP;
        int[] lines = mLines;
        if(want >= lines.length)        
        {
            int nlen = ArrayUtils.idealIntArraySize(want + 1);
            int[] grow = new int[nlen];
            System.arraycopy(lines, 0, grow, 0, lines.length);
            mLines = grow;
            lines = grow;
            Directions[] grow2 = new Directions[nlen];
            System.arraycopy(mLineDirections, 0, grow2, 0,
                             mLineDirections.length);
            mLineDirections = grow2;
        } //End block
        if(chooseHt != null)        
        {
            fm.ascent = above;
            fm.descent = below;
            fm.top = top;
            fm.bottom = bottom;
for(int i = 0;i < chooseHt.length;i++)
            {
                if(chooseHt[i] instanceof LineHeightSpan.WithDensity)                
                {
                    ((LineHeightSpan.WithDensity) chooseHt[i]).
                        chooseHeight(text, start, end, chooseHtv[i], v, fm, paint);
                } //End block
                else
                {
                    chooseHt[i].chooseHeight(text, start, end, chooseHtv[i], v, fm);
                } //End block
            } //End block
            above = fm.ascent;
            below = fm.descent;
            top = fm.top;
            bottom = fm.bottom;
        } //End block
        if(j == 0)        
        {
            if(trackPad)            
            {
                mTopPadding = top - above;
            } //End block
            if(includePad)            
            {
                above = top;
            } //End block
        } //End block
        if(end == bufEnd)        
        {
            if(trackPad)            
            {
                mBottomPadding = bottom - below;
            } //End block
            if(includePad)            
            {
                below = bottom;
            } //End block
        } //End block
        int extra;
        if(needMultiply)        
        {
            double ex = (below - above) * (spacingmult - 1) + spacingadd;
            if(ex >= 0)            
            {
                extra = (int)(ex + EXTRA_ROUNDING);
            } //End block
            else
            {
                extra = -(int)(-ex + EXTRA_ROUNDING);
            } //End block
        } //End block
        else
        {
            extra = 0;
        } //End block
        lines[off + START] = start;
        lines[off + TOP] = v;
        lines[off + DESCENT] = below + extra;
        v += (below - above) + extra;
        lines[off + mColumns + START] = end;
        lines[off + mColumns + TOP] = v;
        if(hasTabOrEmoji)        
        lines[off + TAB] |= TAB_MASK;
        lines[off + DIR] |= dir << DIR_SHIFT;
        Directions linedirs = DIRS_ALL_LEFT_TO_RIGHT;
        if(easy)        
        {
            mLineDirections[j] = linedirs;
        } //End block
        else
        {
            mLineDirections[j] = AndroidBidi.directions(dir, chdirs, start - widthStart, chs,
                    start - widthStart, end - start);
        } //End block
        if(ellipsize != null)        
        {
            boolean firstLine = (j == 0);
            boolean currentLineIsTheLastVisibleOne = (j + 1 == mMaximumVisibleLineCount);
            boolean forceEllipsis = moreChars && (mLineCount + 1 == mMaximumVisibleLineCount);
            boolean doEllipsis = (firstLine && !moreChars &&
                                ellipsize != TextUtils.TruncateAt.MARQUEE) ||
                        (!firstLine && (currentLineIsTheLastVisibleOne || !moreChars) &&
                                ellipsize == TextUtils.TruncateAt.END);
            if(doEllipsis)            
            {
                calculateEllipsis(start, end, widths, widthStart,
                        ellipsisWidth, ellipsize, j,
                        textWidth, paint, forceEllipsis);
            } //End block
        } //End block
        mLineCount++;
        int var9E3669D19B675BD57058FD4664205D2A_1409943678 = (v);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1010214547 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1010214547;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.709 -0400", hash_original_method = "12884526F2C70C1C98137C0940B4D04E", hash_generated_method = "CEA2B4A8C3EE1C16FB28783952E70CB8")
    private void calculateEllipsis(int lineStart, int lineEnd,
                                   float[] widths, int widthStart,
                                   float avail, TextUtils.TruncateAt where,
                                   int line, float textWidth, TextPaint paint,
                                   boolean forceEllipsis) {
        addTaint(forceEllipsis);
        addTaint(paint.getTaint());
        addTaint(textWidth);
        addTaint(where.getTaint());
        addTaint(avail);
        addTaint(widthStart);
        addTaint(widths[0]);
        addTaint(lineEnd);
        addTaint(lineStart);
        if(textWidth <= avail && !forceEllipsis)        
        {
            mLines[mColumns * line + ELLIPSIS_START] = 0;
            mLines[mColumns * line + ELLIPSIS_COUNT] = 0;
            return;
        } //End block
        float ellipsisWidth = paint.measureText(
                (where == TextUtils.TruncateAt.END_SMALL) ? ELLIPSIS_TWO_DOTS : ELLIPSIS_NORMAL);
        int ellipsisStart = 0;
        int ellipsisCount = 0;
        int len = lineEnd - lineStart;
        if(where == TextUtils.TruncateAt.START)        
        {
            if(mMaximumVisibleLineCount == 1)            
            {
                float sum = 0;
                int i;
for(i = len;i >= 0;i--)
                {
                    float w = widths[i - 1 + lineStart - widthStart];
                    if(w + sum + ellipsisWidth > avail)                    
                    {
                        break;
                    } //End block
                    sum += w;
                } //End block
                ellipsisStart = 0;
                ellipsisCount = i;
            } //End block
            else
            {
                if(Log.isLoggable(TAG, Log.WARN))                
                {
                } //End block
            } //End block
        } //End block
        else
        if(where == TextUtils.TruncateAt.END || where == TextUtils.TruncateAt.MARQUEE ||
                where == TextUtils.TruncateAt.END_SMALL)        
        {
            float sum = 0;
            int i;
for(i = 0;i < len;i++)
            {
                float w = widths[i + lineStart - widthStart];
                if(w + sum + ellipsisWidth > avail)                
                {
                    break;
                } //End block
                sum += w;
            } //End block
            ellipsisStart = i;
            ellipsisCount = len - i;
            if(forceEllipsis && ellipsisCount == 0 && len > 0)            
            {
                ellipsisStart = len - 1;
                ellipsisCount = 1;
            } //End block
        } //End block
        else
        {
            if(mMaximumVisibleLineCount == 1)            
            {
                float lsum = 0;
                float rsum = 0;
                int left = 0;
                int right = len;
                float ravail = (avail - ellipsisWidth) / 2;
for(right = len;right >= 0;right--)
                {
                    float w = widths[right - 1 + lineStart - widthStart];
                    if(w + rsum > ravail)                    
                    {
                        break;
                    } //End block
                    rsum += w;
                } //End block
                float lavail = avail - ellipsisWidth - rsum;
for(left = 0;left < right;left++)
                {
                    float w = widths[left + lineStart - widthStart];
                    if(w + lsum > lavail)                    
                    {
                        break;
                    } //End block
                    lsum += w;
                } //End block
                ellipsisStart = left;
                ellipsisCount = right - left;
            } //End block
            else
            {
                if(Log.isLoggable(TAG, Log.WARN))                
                {
                } //End block
            } //End block
        } //End block
        mLines[mColumns * line + ELLIPSIS_START] = ellipsisStart;
        mLines[mColumns * line + ELLIPSIS_COUNT] = ellipsisCount;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.709 -0400", hash_original_method = "98509D881029C8DC6B023EB0DACF92F5", hash_generated_method = "E1ADD480F4D0CB27A7A2A9C4C974BC55")
    @Override
    public int getLineForVertical(int vertical) {
        addTaint(vertical);
        int high = mLineCount;
        int low = -1;
        int guess;
        int[] lines = mLines;
        while
(high - low > 1)        
        {
            guess = (high + low) >> 1;
            if(lines[mColumns * guess + TOP] > vertical)            
            {
                high = guess;
            } //End block
            else
            {
                low = guess;
            } //End block
        } //End block
        if(low < 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_464284207 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_287559333 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_287559333;
        } //End block
        else
        {
            int var53CCED8D281A1A0ACE3CB6594DAAA4F7_54584014 = (low);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1230877567 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1230877567;
        } //End block
        // ---------- Original Method ----------
        //int high = mLineCount;
        //int low = -1;
        //int guess;
        //int[] lines = mLines;
        //while (high - low > 1) {
            //guess = (high + low) >> 1;
            //if (lines[mColumns * guess + TOP] > vertical){
                //high = guess;
            //} else {
                //low = guess;
            //}
        //}
        //if (low < 0) {
            //return 0;
        //} else {
            //return low;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.709 -0400", hash_original_method = "DCA25DE9CB635243C23A0D258AEAA6C9", hash_generated_method = "787AF0E4982D9A884B79DC4DFE055010")
    @Override
    public int getLineCount() {
        int var6CD75FA86B8D1E573AF761513C2464BF_2075951226 = (mLineCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_244941509 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_244941509;
        // ---------- Original Method ----------
        //return mLineCount;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.709 -0400", hash_original_method = "79A8E86A0E5ABFEF4F09B2D188FA97FB", hash_generated_method = "4B273011D2B78C03918658FC8E21AE31")
    @Override
    public int getLineTop(int line) {
        addTaint(line);
        int top = mLines[mColumns * line + TOP];
        if(mMaximumVisibleLineCount > 0 && line >= mMaximumVisibleLineCount &&
                line != mLineCount)        
        {
            top += getBottomPadding();
        } //End block
        int varB28354B543375BFA94DABAEDA722927F_1155830903 = (top);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1244081202 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1244081202;
        // ---------- Original Method ----------
        //int top = mLines[mColumns * line + TOP];
        //if (mMaximumVisibleLineCount > 0 && line >= mMaximumVisibleLineCount &&
                //line != mLineCount) {
            //top += getBottomPadding();
        //}
        //return top;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.710 -0400", hash_original_method = "24456204DB122ABBCF95E31F6A475D1C", hash_generated_method = "83097AE82FC110DEE1799F85264FC1DB")
    @Override
    public int getLineDescent(int line) {
        addTaint(line);
        int descent = mLines[mColumns * line + DESCENT];
        if(mMaximumVisibleLineCount > 0 && line >= mMaximumVisibleLineCount - 1 && 
                line != mLineCount)        
        {
            descent += getBottomPadding();
        } //End block
        int var02E251094E7D27130BE25530E2AE708F_323883149 = (descent);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1095534842 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1095534842;
        // ---------- Original Method ----------
        //int descent = mLines[mColumns * line + DESCENT];
        //if (mMaximumVisibleLineCount > 0 && line >= mMaximumVisibleLineCount - 1 && 
                //line != mLineCount) {
            //descent += getBottomPadding();
        //}
        //return descent;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.710 -0400", hash_original_method = "839417F6B69B5423927C3B8DBF7A6F42", hash_generated_method = "E047EB650A1964B669BCEA0796682109")
    @Override
    public int getLineStart(int line) {
        addTaint(line);
        int varA236F9AAFD383F910E16D130FD4460AA_482377579 = (mLines[mColumns * line + START] & START_MASK);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_254385139 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_254385139;
        // ---------- Original Method ----------
        //return mLines[mColumns * line + START] & START_MASK;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.710 -0400", hash_original_method = "4D44D66A6DA9E0A8739F807A61ABAF65", hash_generated_method = "4FA980124B8258C670E6D7D6E3B755B1")
    @Override
    public int getParagraphDirection(int line) {
        addTaint(line);
        int varD206AA20A02B3C3423F47B565283AEB2_1478337273 = (mLines[mColumns * line + DIR] >> DIR_SHIFT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1852605221 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1852605221;
        // ---------- Original Method ----------
        //return mLines[mColumns * line + DIR] >> DIR_SHIFT;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.710 -0400", hash_original_method = "F549BE615B108927B3399A138AFD2460", hash_generated_method = "86CB35EB85E2C7584733A8B18249F76D")
    @Override
    public boolean getLineContainsTab(int line) {
        addTaint(line);
        boolean varEAA7A5E9F6A1747F15652A220F84C985_1536842418 = ((mLines[mColumns * line + TAB] & TAB_MASK) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2121301167 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2121301167;
        // ---------- Original Method ----------
        //return (mLines[mColumns * line + TAB] & TAB_MASK) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.710 -0400", hash_original_method = "E4C2D852DF30293005E76B99E82745CD", hash_generated_method = "34F91CDA86BA91A2DB21445DD0EED3BE")
    @Override
    public final Directions getLineDirections(int line) {
        addTaint(line);
Directions var2C5AC76C50C05D38FDB9FE7FB8F55AEC_1045376557 =         mLineDirections[line];
        var2C5AC76C50C05D38FDB9FE7FB8F55AEC_1045376557.addTaint(taint);
        return var2C5AC76C50C05D38FDB9FE7FB8F55AEC_1045376557;
        // ---------- Original Method ----------
        //return mLineDirections[line];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.710 -0400", hash_original_method = "0410F05B3F48387C42DB277B8067D4A9", hash_generated_method = "284CF1B09F4C101232A63C9E9C62AD4C")
    @Override
    public int getTopPadding() {
        int varA6796D45932911E4DA1D9D40D1BD23B8_2014254633 = (mTopPadding);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557327261 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557327261;
        // ---------- Original Method ----------
        //return mTopPadding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.710 -0400", hash_original_method = "A7597317BC8A3102F80AD4E9AD038652", hash_generated_method = "CD643B7B41088B2118F12A6822A360B3")
    @Override
    public int getBottomPadding() {
        int var097A31AA17188409E251DABE4869FAFE_1198094041 = (mBottomPadding);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1058740019 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1058740019;
        // ---------- Original Method ----------
        //return mBottomPadding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.710 -0400", hash_original_method = "7EEFC0E209C4C423B00930C7C3F48104", hash_generated_method = "90FDDACAB0F152A8BF61300512D7603C")
    @Override
    public int getEllipsisCount(int line) {
        addTaint(line);
        if(mColumns < COLUMNS_ELLIPSIZE)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_2109495891 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372895510 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372895510;
        } //End block
        int var164F2D90430640C214700DE2F8701F43_425930627 = (mLines[mColumns * line + ELLIPSIS_COUNT]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_422339783 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_422339783;
        // ---------- Original Method ----------
        //if (mColumns < COLUMNS_ELLIPSIZE) {
            //return 0;
        //}
        //return mLines[mColumns * line + ELLIPSIS_COUNT];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.711 -0400", hash_original_method = "3E84E442932041329DEDBD7573FAD5F7", hash_generated_method = "C6EA3DEEBED819C5DCBB38F704B9BE99")
    @Override
    public int getEllipsisStart(int line) {
        addTaint(line);
        if(mColumns < COLUMNS_ELLIPSIZE)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1518477791 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1597727063 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1597727063;
        } //End block
        int var960908427674FD2D3D677D9555CC8698_846704730 = (mLines[mColumns * line + ELLIPSIS_START]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674967223 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674967223;
        // ---------- Original Method ----------
        //if (mColumns < COLUMNS_ELLIPSIZE) {
            //return 0;
        //}
        //return mLines[mColumns * line + ELLIPSIS_START];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.711 -0400", hash_original_method = "5CA9F8625BABB74DD57E485BAAAC3103", hash_generated_method = "B33FC89D31BD2341BCF9C3169CBB732C")
    @Override
    public int getEllipsizedWidth() {
        int var5713AC9F49879DE1055FA780DFEFDF1C_539832852 = (mEllipsizedWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1747682107 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1747682107;
        // ---------- Original Method ----------
        //return mEllipsizedWidth;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.711 -0400", hash_original_method = "B52C8C631677053C363ACE90856C8484", hash_generated_method = "95EDBE59F598FE401B87F39CB299AF78")
     void prepare() {
        mMeasured = MeasuredText.obtain();
        // ---------- Original Method ----------
        //mMeasured = MeasuredText.obtain();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.711 -0400", hash_original_method = "C0F6C3CAFEEBD4E75E81773515CBCC0B", hash_generated_method = "25F76FF05D99A4E8F3EC719ABEED0A6E")
     void finish() {
        mMeasured = MeasuredText.recycle(mMeasured);
        // ---------- Original Method ----------
        //mMeasured = MeasuredText.recycle(mMeasured);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.711 -0400", hash_original_field = "95872B125F7B7861D9E38E9C7DDA5DE8", hash_generated_field = "6CFCC815EA0D3325CF63B4F6F365477B")

    static final String TAG = "StaticLayout";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.711 -0400", hash_original_field = "3AE51DFCA721DA74B9FE7AE826399C5B", hash_generated_field = "CD7507056B56DB550B1D813FB4B3D98B")

    private static final int COLUMNS_NORMAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.711 -0400", hash_original_field = "55DF56DF384DF5793030D40F84610E92", hash_generated_field = "67237E10844A87633E2718F5190772DB")

    private static final int COLUMNS_ELLIPSIZE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.711 -0400", hash_original_field = "28651E175A74BF99AEB0613FFD9E4311", hash_generated_field = "D858CF53160507E553F41D31EE5B91B4")

    private static final int START = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.711 -0400", hash_original_field = "96C94187E98129DC7ED52B022D56B56E", hash_generated_field = "00A39BB8E63058E1AB6D38D081403510")

    private static final int DIR = START;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.711 -0400", hash_original_field = "03E7882B92ED9688C792A4DF3CCA212F", hash_generated_field = "F85A3E18A8BF309A20F781E644D5A08F")

    private static final int TAB = START;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.711 -0400", hash_original_field = "571D16AE4FA766DA4380F84D324027BE", hash_generated_field = "1A855B733EBA6E8672640513C3B16A39")

    private static final int TOP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.711 -0400", hash_original_field = "4DF1087155B53EE865ED8DEFEF0D2F7E", hash_generated_field = "A52FCC4891B5FC0ED83D62A588ACAE05")

    private static final int DESCENT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.711 -0400", hash_original_field = "11658650D3EBC5004F1DE2593A19D91C", hash_generated_field = "E2BDE677DE1C429BF2BE569E18329E43")

    private static final int ELLIPSIS_START = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.711 -0400", hash_original_field = "9DEA8A3EF4097355E23BEB471268468C", hash_generated_field = "1B418124A7F291F864D2626D0BD306EC")

    private static final int ELLIPSIS_COUNT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.711 -0400", hash_original_field = "479F76462347F1E81B6EC92F50573413", hash_generated_field = "E308275B4AE398B992072A6F7EA1A3C0")

    private static final int START_MASK = 0x1FFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.711 -0400", hash_original_field = "3CE9D0897644F1685651D602FF457A11", hash_generated_field = "B97E7A8E8F664E1C1793F75E8020C7A1")

    private static final int DIR_SHIFT = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.711 -0400", hash_original_field = "C52FA1DB43D0A9E4AB2D27DC3ED50BD6", hash_generated_field = "8DE592C2FC67BEDD6F7461E40AD4FEE6")

    private static final int TAB_MASK = 0x20000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.711 -0400", hash_original_field = "5857BDFF3BF33113730586AF5B28164F", hash_generated_field = "D5E340FF9F0E2C74F920DF02A6624213")

    private static final int TAB_INCREMENT = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.711 -0400", hash_original_field = "D12D3634E072793BACFCFCC6DF78CE4B", hash_generated_field = "7D1377BE9BFDAB86B8C4B5771EE6843C")

    private static final char CHAR_FIRST_CJK = '\u2E80';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.711 -0400", hash_original_field = "00A52FFD05B158140F163AE416840413", hash_generated_field = "487332DEC3D3C8842021C94862F5B4C7")

    private static final char CHAR_NEW_LINE = '\n';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.712 -0400", hash_original_field = "7CEA2D58CE9FE60FCE1405E11A2F16B5", hash_generated_field = "6D0AB500D1767C0990B7C5EF6D2671B3")

    private static final char CHAR_TAB = '\t';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.712 -0400", hash_original_field = "AB5806A9D7897E1EED82CC37BF968FE0", hash_generated_field = "5DF6F862727E58FBFF8DFD0D876D6C5A")

    private static final char CHAR_SPACE = ' ';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.712 -0400", hash_original_field = "6C7F27ADADD73E9D7E1011C0EFF91FA1", hash_generated_field = "37626264B4B037B3F69AB09219E04D8F")

    private static final char CHAR_DOT = '.';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.712 -0400", hash_original_field = "22BFFF2E9C98A18E97B84C2EEB94338F", hash_generated_field = "3FB66E66ECAA8ACAE358CE68734B3245")

    private static final char CHAR_COMMA = ',';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.712 -0400", hash_original_field = "FE1A9DABDFCB157F2908BF6CD35FCE5B", hash_generated_field = "C1B89DF36207A4C29A88D82C9BC1CBE5")

    private static final char CHAR_COLON = ':';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.712 -0400", hash_original_field = "C92AA43D6022E95DCA4F5B63ED80FF2C", hash_generated_field = "F9E773EC71F589DA0129DE9F3A6B78A1")

    private static final char CHAR_SEMICOLON = ';';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.712 -0400", hash_original_field = "F45EF65010D62FA697204F2D5213C54D", hash_generated_field = "A4DA5040848D5DBDB9F950FEB8F71CB7")

    private static final char CHAR_SLASH = '/';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.712 -0400", hash_original_field = "72DEAD401756357C1B8CD8F98362FA8C", hash_generated_field = "8F2658BD995F064C6D0D73A3CA872693")

    private static final char CHAR_HYPHEN = '-';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.712 -0400", hash_original_field = "5C6729C339E50626FF445F7364D13172", hash_generated_field = "4115D5FCA00B16A69C97785E9691BDA9")

    private static final double EXTRA_ROUNDING = 0.5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.712 -0400", hash_original_field = "1DBD92DD1658F4ADDF0F957D8B97982A", hash_generated_field = "2BF933DA0C369B3A13C810DDA18B4DC4")

    private static final String ELLIPSIS_NORMAL = "\u2026";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.712 -0400", hash_original_field = "B63101E3F6BAA0CA142477AA62972904", hash_generated_field = "EF1EE2AD82D24DCEF53A3F77F1F7B2B5")

    private static final String ELLIPSIS_TWO_DOTS = "\u2025";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.712 -0400", hash_original_field = "41CF096C0A9F72FA9AE4C83AF587A230", hash_generated_field = "033397B01596D864D5BF5FED2BB28EB2")

    private static final int CHAR_FIRST_HIGH_SURROGATE = 0xD800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.712 -0400", hash_original_field = "485B1B5DF5DC77A82D51FABFA3C0D8D8", hash_generated_field = "45D09AEF41710114C8A584328D3831D7")

    private static final int CHAR_LAST_LOW_SURROGATE = 0xDFFF;
}

