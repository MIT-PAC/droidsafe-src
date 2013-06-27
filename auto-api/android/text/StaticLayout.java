package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.562 -0400", hash_original_field = "6CD75FA86B8D1E573AF761513C2464BF", hash_generated_field = "45537663750337309A584754E1437CDD")

    private int mLineCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.562 -0400", hash_original_field = "A6796D45932911E4DA1D9D40D1BD23B8", hash_generated_field = "74C5EEEB9113B0F29D66E0A4983A6BC3")

    private int mTopPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.562 -0400", hash_original_field = "097A31AA17188409E251DABE4869FAFE", hash_generated_field = "8A7C981A0C6837E513C477AD1250B374")

    private int mBottomPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.562 -0400", hash_original_field = "11C985F30142FD30ACDDFE7CD3BD4A9B", hash_generated_field = "75F4039C98FB52077D38E34F530EB3FF")

    private int mColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.562 -0400", hash_original_field = "5713AC9F49879DE1055FA780DFEFDF1C", hash_generated_field = "C354DF48C5764CCC7B8B820C49BF2BBD")

    private int mEllipsizedWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.562 -0400", hash_original_field = "1BB5D78D3AAC39AEAEB752C0B85D10E9", hash_generated_field = "26F954E05EF8E6C19C537B63E9266033")

    private int[] mLines;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.562 -0400", hash_original_field = "2801B37F60217970AB463F0E5596FCCD", hash_generated_field = "7D53F177386EEFF604DBA9C007C99633")

    private Directions[] mLineDirections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.562 -0400", hash_original_field = "1DE64451AE73776A90C4D2C1EEF5D2F6", hash_generated_field = "15DFAE1051C19AC15963DEF70B1F9BF5")

    private int mMaximumVisibleLineCount = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.562 -0400", hash_original_field = "6D906AC98A7DED22536ECD22D9912986", hash_generated_field = "67359422AB8F87EBC819B683687CEFC5")

    private MeasuredText mMeasured;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.563 -0400", hash_original_field = "FAD3F9B7F49B89883B041D2654B13B33", hash_generated_field = "9F4F72572DE50EBE55E7D6F43A8C24E4")

    private Paint.FontMetricsInt mFontMetricsInt = new Paint.FontMetricsInt();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.563 -0400", hash_original_method = "C77149727B404FEFD5CB3129B7BB45BF", hash_generated_method = "7368E6ED45BB500C1FF8138150A7D8F3")
    public  StaticLayout(CharSequence source, TextPaint paint,
                        int width,
                        Alignment align, float spacingmult, float spacingadd,
                        boolean includepad) {
        this(source, 0, source.length(), paint, width, align,
             spacingmult, spacingadd, includepad);
        addTaint(source.getTaint());
        addTaint(paint.getTaint());
        addTaint(width);
        addTaint(align.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(includepad);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.563 -0400", hash_original_method = "81565FB766EC1D266415894033F3BC38", hash_generated_method = "4D9B96BC6B24AB802A50FB1CD9E72E38")
    public  StaticLayout(CharSequence source, TextPaint paint,
            int width, Alignment align, TextDirectionHeuristic textDir,
            float spacingmult, float spacingadd,
            boolean includepad) {
        this(source, 0, source.length(), paint, width, align, textDir,
                spacingmult, spacingadd, includepad);
        addTaint(source.getTaint());
        addTaint(paint.getTaint());
        addTaint(width);
        addTaint(align.getTaint());
        addTaint(textDir.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(includepad);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.571 -0400", hash_original_method = "BF066121E6D6D3B30CB2E4FB82D6E631", hash_generated_method = "FF7F8DC917D679F88213B8F004AF8CF5")
    public  StaticLayout(CharSequence source, int bufstart, int bufend,
                        TextPaint paint, int outerwidth,
                        Alignment align,
                        float spacingmult, float spacingadd,
                        boolean includepad) {
        this(source, bufstart, bufend, paint, outerwidth, align,
             spacingmult, spacingadd, includepad, null, 0);
        addTaint(source.getTaint());
        addTaint(bufstart);
        addTaint(bufend);
        addTaint(paint.getTaint());
        addTaint(outerwidth);
        addTaint(align.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(includepad);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.572 -0400", hash_original_method = "683465774808809C7366667F354731A1", hash_generated_method = "19B4B471754B627437A4C81963BB3F79")
    public  StaticLayout(CharSequence source, int bufstart, int bufend,
            TextPaint paint, int outerwidth,
            Alignment align, TextDirectionHeuristic textDir,
            float spacingmult, float spacingadd,
            boolean includepad) {
        this(source, bufstart, bufend, paint, outerwidth, align, textDir,
                spacingmult, spacingadd, includepad, null, 0, Integer.MAX_VALUE);
        addTaint(source.getTaint());
        addTaint(bufstart);
        addTaint(bufend);
        addTaint(paint.getTaint());
        addTaint(outerwidth);
        addTaint(align.getTaint());
        addTaint(textDir.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(includepad);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.572 -0400", hash_original_method = "D92F1C5E6D18A86EA341983F1D2D5889", hash_generated_method = "F01BB85D687C6991BC631AEDF5931A97")
    public  StaticLayout(CharSequence source, int bufstart, int bufend,
            TextPaint paint, int outerwidth,
            Alignment align,
            float spacingmult, float spacingadd,
            boolean includepad,
            TextUtils.TruncateAt ellipsize, int ellipsizedWidth) {
        this(source, bufstart, bufend, paint, outerwidth, align,
                TextDirectionHeuristics.FIRSTSTRONG_LTR,
                spacingmult, spacingadd, includepad, ellipsize, ellipsizedWidth, Integer.MAX_VALUE);
        addTaint(source.getTaint());
        addTaint(bufstart);
        addTaint(bufend);
        addTaint(paint.getTaint());
        addTaint(outerwidth);
        addTaint(align.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(includepad);
        addTaint(ellipsize.getTaint());
        addTaint(ellipsizedWidth);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.577 -0400", hash_original_method = "67715870CA89D1E43E3638ABED5B90D0", hash_generated_method = "C26C37D8EF9ABA46D8F78DA1E4C90577")
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
        {
            Ellipsizer e;
            e = (Ellipsizer) getText();
            e.mLayout = this;
            e.mWidth = ellipsizedWidth;
            e.mMethod = ellipsize;
            mEllipsizedWidth = ellipsizedWidth;
            mColumns = COLUMNS_ELLIPSIZE;
        } //End block
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
        addTaint(source.getTaint());
        addTaint(bufstart);
        addTaint(bufend);
        addTaint(paint.getTaint());
        addTaint(align.getTaint());
        addTaint(textDir.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(includepad);
        addTaint(ellipsize.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.586 -0400", hash_original_method = "F6D0B9C991ED85508405BA894E3CF311", hash_generated_method = "16EB017909B4433064E0DE9E65642147")
      StaticLayout(CharSequence text) {
        super(text, null, 0, null, 0, 0);
        mColumns = COLUMNS_ELLIPSIZE;
        mLines = new int[ArrayUtils.idealIntArraySize(2 * mColumns)];
        mLineDirections = new Directions[
                             ArrayUtils.idealIntArraySize(2 * mColumns)];
        mMeasured = MeasuredText.obtain();
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //mColumns = COLUMNS_ELLIPSIZE;
        //mLines = new int[ArrayUtils.idealIntArraySize(2 * mColumns)];
        //mLineDirections = new Directions[
                             //ArrayUtils.idealIntArraySize(2 * mColumns)];
        //mMeasured = MeasuredText.obtain();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.620 -0400", hash_original_method = "36200F938D6B110E70DA8FCD0A142EF7", hash_generated_method = "01A7452FC7791B7288C3ABE72DF36ADA")
     void generate(CharSequence source, int bufStart, int bufEnd,
                        TextPaint paint, int outerWidth,
                        TextDirectionHeuristic textDir, float spacingmult,
                        float spacingadd, boolean includepad,
                        boolean trackpad, float ellipsizedWidth,
                        TextUtils.TruncateAt ellipsize) {
        mLineCount = 0;
        int v;
        v = 0;
        boolean needMultiply;
        needMultiply = (spacingmult != 1 || spacingadd != 0);
        Paint.FontMetricsInt fm;
        fm = mFontMetricsInt;
        int[] chooseHtv;
        chooseHtv = null;
        MeasuredText measured;
        measured = mMeasured;
        Spanned spanned;
        spanned = null;
        spanned = (Spanned) source;
        int DEFAULT_DIR;
        DEFAULT_DIR = DIR_LEFT_TO_RIGHT;
        int paraEnd;
        {
            int paraStart;
            paraStart = bufStart;
            paraStart = paraEnd;
            {
                paraEnd = TextUtils.indexOf(source, CHAR_NEW_LINE, paraStart, bufEnd);
                paraEnd = bufEnd;
                int firstWidthLineLimit;
                firstWidthLineLimit = mLineCount + 1;
                int firstWidth;
                firstWidth = outerWidth;
                int restWidth;
                restWidth = outerWidth;
                LineHeightSpan[] chooseHt;
                chooseHt = null;
                {
                    LeadingMarginSpan[] sp;
                    sp = getParagraphSpans(spanned, paraStart, paraEnd,
                        LeadingMarginSpan.class);
                    {
                        int i;
                        i = 0;
                        {
                            LeadingMarginSpan lms;
                            lms = sp[i];
                            firstWidth -= sp[i].getLeadingMargin(true);
                            restWidth -= sp[i].getLeadingMargin(false);
                            {
                                LeadingMarginSpan2 lms2;
                                lms2 = (LeadingMarginSpan2) lms;
                                int lmsFirstLine;
                                lmsFirstLine = getLineForOffset(spanned.getSpanStart(lms2));
                                firstWidthLineLimit = lmsFirstLine + lms2.getLeadingMarginLineCount();
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    chooseHt = getParagraphSpans(spanned, paraStart, paraEnd, LineHeightSpan.class);
                    {
                        {
                            chooseHtv = new int[ArrayUtils.idealIntArraySize(
                                            chooseHt.length)];
                        } //End block
                        {
                            int i;
                            i = 0;
                            {
                                int o;
                                o = spanned.getSpanStart(chooseHt[i]);
                                {
                                    chooseHtv[i] = getLineTop(getLineForOffset(o));
                                } //End block
                                {
                                    chooseHtv[i] = v;
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                measured.setPara(source, paraStart, paraEnd, textDir);
                char[] chs;
                chs = measured.mChars;
                float[] widths;
                widths = measured.mWidths;
                byte[] chdirs;
                chdirs = measured.mLevels;
                int dir;
                dir = measured.mDir;
                boolean easy;
                easy = measured.mEasy;
                int width;
                width = firstWidth;
                float w;
                w = 0;
                int here;
                here = paraStart;
                int ok;
                ok = paraStart;
                float okWidth;
                okWidth = w;
                int okAscent, okDescent, okTop, okBottom;
                okAscent = 0;
                okDescent = 0;
                okTop = 0;
                okBottom = 0;
                int fit;
                fit = paraStart;
                float fitWidth;
                fitWidth = w;
                int fitAscent, fitDescent, fitTop, fitBottom;
                fitAscent = 0;
                fitDescent = 0;
                fitTop = 0;
                fitBottom = 0;
                boolean hasTabOrEmoji;
                hasTabOrEmoji = false;
                boolean hasTab;
                hasTab = false;
                TabStops tabStops;
                tabStops = null;
                {
                    int spanStart, spanEnd, nextSpanStart;
                    spanStart = paraStart;
                    spanEnd = spanStart;
                    spanStart = nextSpanStart;
                    {
                        {
                            spanEnd = paraEnd;
                            spanEnd = spanned.nextSpanTransition(spanStart, paraEnd,
                                MetricAffectingSpan.class);
                            int spanLen;
                            spanLen = spanEnd - spanStart;
                            {
                                measured.addStyleRun(paint, spanLen, fm);
                            } //End block
                            {
                                MetricAffectingSpan[] spans;
                                spans = spanned.getSpans(spanStart, spanEnd, MetricAffectingSpan.class);
                                spans = TextUtils.removeEmptySpans(spans, spanned,
                                MetricAffectingSpan.class);
                                measured.addStyleRun(paint, spans, spanLen, fm);
                            } //End block
                        } //End block
                        nextSpanStart = spanEnd;
                        int fmTop;
                        fmTop = fm.top;
                        int fmBottom;
                        fmBottom = fm.bottom;
                        int fmAscent;
                        fmAscent = fm.ascent;
                        int fmDescent;
                        fmDescent = fm.descent;
                        {
                            int j;
                            j = spanStart;
                            {
                                char c;
                                c = chs[j - paraStart];
                                {
                                    {
                                        hasTab = true;
                                        hasTabOrEmoji = true;
                                        {
                                            TabStopSpan[] spans;
                                            spans = getParagraphSpans(spanned, paraStart,
                                        paraEnd, TabStopSpan.class);
                                            {
                                                tabStops = new TabStops(TAB_INCREMENT, spans);
                                            } //End block
                                        } //End block
                                    } //End block
                                    {
                                        w = tabStops.nextTab(w);
                                    } //End block
                                    {
                                        w = TabStops.nextDefaultStop(w, TAB_INCREMENT);
                                    } //End block
                                } //End block
                                {
                                    int emoji;
                                    emoji = Character.codePointAt(chs, j - paraStart);
                                    {
                                        Bitmap bm;
                                        bm = EMOJI_FACTORY.getBitmapFromAndroidPua(emoji);
                                        {
                                            Paint whichPaint;
                                            {
                                                whichPaint = paint;
                                            } //End block
                                            {
                                                whichPaint = mWorkPaint;
                                            } //End block
                                            float wid;
                                            wid = bm.getWidth() * -whichPaint.ascent() / bm.getHeight();
                                            w += wid;
                                            hasTabOrEmoji = true;
                                        } //End block
                                        {
                                            w += widths[j - paraStart];
                                        } //End block
                                    } //End block
                                    {
                                        w += widths[j - paraStart];
                                    } //End block
                                } //End block
                                {
                                    w += widths[j - paraStart];
                                } //End block
                                {
                                    fitWidth = w;
                                    fit = j + 1;
                                    fitTop = fmTop;
                                    fitAscent = fmAscent;
                                    fitDescent = fmDescent;
                                    fitBottom = fmBottom;
                                    {
                                        boolean varB520B0E4FB3D6569062BDD8343CF19D9_2079691864 = (c == CHAR_SPACE || c == CHAR_TAB ||
                            ((c == CHAR_DOT || c == CHAR_COMMA ||
                                    c == CHAR_COLON || c == CHAR_SEMICOLON) &&
                             (j - 1 < here || !Character.isDigit(chs[j - 1 - paraStart])) &&
                             (j + 1 >= spanEnd || !Character.isDigit(chs[j + 1 - paraStart]))) ||
                            ((c == CHAR_SLASH || c == CHAR_HYPHEN) &&
                             (j + 1 >= spanEnd || !Character.isDigit(chs[j + 1 - paraStart]))) ||
                            (c >= CHAR_FIRST_CJK && isIdeographic(c, true) &&
                             j + 1 < spanEnd && isIdeographic(chs[j + 1 - paraStart], false)));
                                        {
                                            okWidth = w;
                                            ok = j + 1;
                                            okTop = fitTop;
                                            okAscent = fitAscent;
                                            okDescent = fitDescent;
                                            okBottom = fitBottom;
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    boolean moreChars;
                                    moreChars = (j + 1 < spanEnd);
                                    int endPos;
                                    int above, below, top, bottom;
                                    float currentTextWidth;
                                    {
                                        ok = j + 1;
                                        endPos = ok;
                                        above = okAscent;
                                        below = okDescent;
                                        top = okTop;
                                        bottom = okBottom;
                                        currentTextWidth = okWidth;
                                    } //End block
                                    {
                                        endPos = fit;
                                        above = fitAscent;
                                        below = fitDescent;
                                        top = fitTop;
                                        bottom = fitBottom;
                                        currentTextWidth = fitWidth;
                                    } //End block
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
                                    {
                                        j = nextSpanStart = here;
                                    } //End block
                                    {
                                        j = here - 1;
                                    } //End block
                                    ok = fit = here;
                                    w = 0;
                                    fitAscent = fitDescent = fitTop = fitBottom = 0;
                                    okAscent = okDescent = okTop = okBottom = 0;
                                    {
                                        width = restWidth;
                                    } //End block
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
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
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD6A6A425370B61445227FF156BD0D4E6_972043928 = ((bufEnd == bufStart || source.charAt(bufEnd - 1) == CHAR_NEW_LINE) &&
                mLineCount < mMaximumVisibleLineCount);
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
        } //End collapsed parenthetic
        addTaint(source.getTaint());
        addTaint(bufStart);
        addTaint(bufEnd);
        addTaint(paint.getTaint());
        addTaint(outerWidth);
        addTaint(textDir.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(includepad);
        addTaint(trackpad);
        addTaint(ellipsizedWidth);
        addTaint(ellipsize.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.630 -0400", hash_original_method = "478F3FA593939ABCBF542030DE605E96", hash_generated_method = "FED00B528C50CB9A0DAA9B54702675B1")
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
        int j;
        j = mLineCount;
        int off;
        off = j * mColumns;
        int want;
        want = off + mColumns + TOP;
        int[] lines;
        lines = mLines;
        {
            int nlen;
            nlen = ArrayUtils.idealIntArraySize(want + 1);
            int[] grow;
            grow = new int[nlen];
            System.arraycopy(lines, 0, grow, 0, lines.length);
            mLines = grow;
            lines = grow;
            Directions[] grow2;
            grow2 = new Directions[nlen];
            System.arraycopy(mLineDirections, 0, grow2, 0,
                             mLineDirections.length);
            mLineDirections = grow2;
        } //End block
        {
            fm.ascent = above;
            fm.descent = below;
            fm.top = top;
            fm.bottom = bottom;
            {
                int i;
                i = 0;
                {
                    {
                        ((LineHeightSpan.WithDensity) chooseHt[i]).
                        chooseHeight(text, start, end, chooseHtv[i], v, fm, paint);
                    } //End block
                    {
                        chooseHt[i].chooseHeight(text, start, end, chooseHtv[i], v, fm);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            above = fm.ascent;
            below = fm.descent;
            top = fm.top;
            bottom = fm.bottom;
        } //End block
        {
            {
                mTopPadding = top - above;
            } //End block
            {
                above = top;
            } //End block
        } //End block
        {
            {
                mBottomPadding = bottom - below;
            } //End block
            {
                below = bottom;
            } //End block
        } //End block
        int extra;
        {
            double ex;
            ex = (below - above) * (spacingmult - 1) + spacingadd;
            {
                extra = (int)(ex + EXTRA_ROUNDING);
            } //End block
            {
                extra = -(int)(-ex + EXTRA_ROUNDING);
            } //End block
        } //End block
        {
            extra = 0;
        } //End block
        lines[off + START] = start;
        lines[off + TOP] = v;
        lines[off + DESCENT] = below + extra;
        v += (below - above) + extra;
        lines[off + mColumns + START] = end;
        lines[off + mColumns + TOP] = v;
        lines[off + TAB] |= TAB_MASK;
        lines[off + DIR] |= dir << DIR_SHIFT;
        Directions linedirs;
        linedirs = DIRS_ALL_LEFT_TO_RIGHT;
        {
            mLineDirections[j] = linedirs;
        } //End block
        {
            mLineDirections[j] = AndroidBidi.directions(dir, chdirs, start - widthStart, chs,
                    start - widthStart, end - start);
        } //End block
        {
            boolean firstLine;
            firstLine = (j == 0);
            boolean currentLineIsTheLastVisibleOne;
            currentLineIsTheLastVisibleOne = (j + 1 == mMaximumVisibleLineCount);
            boolean forceEllipsis;
            forceEllipsis = moreChars && (mLineCount + 1 == mMaximumVisibleLineCount);
            boolean doEllipsis;
            doEllipsis = (firstLine && !moreChars &&
                                ellipsize != TextUtils.TruncateAt.MARQUEE) ||
                        (!firstLine && (currentLineIsTheLastVisibleOne || !moreChars) &&
                                ellipsize == TextUtils.TruncateAt.END);
            {
                calculateEllipsis(start, end, widths, widthStart,
                        ellipsisWidth, ellipsize, j,
                        textWidth, paint, forceEllipsis);
            } //End block
        } //End block
        addTaint(text.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(chooseHt[0].getTaint());
        addTaint(chooseHtv[0]);
        addTaint(fm.getTaint());
        addTaint(hasTabOrEmoji);
        addTaint(needMultiply);
        addTaint(easy);
        addTaint(bufEnd);
        addTaint(includePad);
        addTaint(trackPad);
        addTaint(widths[0]);
        addTaint(ellipsize.getTaint());
        addTaint(ellipsisWidth);
        addTaint(textWidth);
        addTaint(paint.getTaint());
        addTaint(moreChars);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1299553175 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1299553175;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.644 -0400", hash_original_method = "12884526F2C70C1C98137C0940B4D04E", hash_generated_method = "FB3B1601F4FD5AB64169639C53D221B5")
    private void calculateEllipsis(int lineStart, int lineEnd,
                                   float[] widths, int widthStart,
                                   float avail, TextUtils.TruncateAt where,
                                   int line, float textWidth, TextPaint paint,
                                   boolean forceEllipsis) {
        {
            mLines[mColumns * line + ELLIPSIS_START] = 0;
            mLines[mColumns * line + ELLIPSIS_COUNT] = 0;
        } //End block
        float ellipsisWidth;
        ellipsisWidth = paint.measureText(
                (where == TextUtils.TruncateAt.END_SMALL) ? ELLIPSIS_TWO_DOTS : ELLIPSIS_NORMAL);//DSFIXME:  CODE0008: Nested ternary operator in expression
        int ellipsisStart;
        ellipsisStart = 0;
        int ellipsisCount;
        ellipsisCount = 0;
        int len;
        len = lineEnd - lineStart;
        {
            {
                float sum;
                sum = 0;
                int i;
                {
                    i = len;
                    {
                        float w;
                        w = widths[i - 1 + lineStart - widthStart];
                        sum += w;
                    } //End block
                } //End collapsed parenthetic
                ellipsisStart = 0;
                ellipsisCount = i;
            } //End block
            {
                {
                    boolean varDB9C000D9EED0EBC5F67F0C4656298B5_1408794257 = (Log.isLoggable(TAG, Log.WARN));
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            float sum;
            sum = 0;
            int i;
            {
                i = 0;
                {
                    float w;
                    w = widths[i + lineStart - widthStart];
                    sum += w;
                } //End block
            } //End collapsed parenthetic
            ellipsisStart = i;
            ellipsisCount = len - i;
            {
                ellipsisStart = len - 1;
                ellipsisCount = 1;
            } //End block
        } //End block
        {
            {
                float lsum, rsum;
                lsum = 0;
                rsum = 0;
                int left, right;
                left = 0;
                right = len;
                float ravail;
                ravail = (avail - ellipsisWidth) / 2;
                {
                    right = len;
                    {
                        float w;
                        w = widths[right - 1 + lineStart - widthStart];
                        rsum += w;
                    } //End block
                } //End collapsed parenthetic
                float lavail;
                lavail = avail - ellipsisWidth - rsum;
                {
                    left = 0;
                    {
                        float w;
                        w = widths[left + lineStart - widthStart];
                        lsum += w;
                    } //End block
                } //End collapsed parenthetic
                ellipsisStart = left;
                ellipsisCount = right - left;
            } //End block
            {
                {
                    boolean varDB9C000D9EED0EBC5F67F0C4656298B5_1685516640 = (Log.isLoggable(TAG, Log.WARN));
                } //End collapsed parenthetic
            } //End block
        } //End block
        mLines[mColumns * line + ELLIPSIS_START] = ellipsisStart;
        mLines[mColumns * line + ELLIPSIS_COUNT] = ellipsisCount;
        addTaint(lineStart);
        addTaint(lineEnd);
        addTaint(widths[0]);
        addTaint(widthStart);
        addTaint(avail);
        addTaint(where.getTaint());
        addTaint(textWidth);
        addTaint(paint.getTaint());
        addTaint(forceEllipsis);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.646 -0400", hash_original_method = "98509D881029C8DC6B023EB0DACF92F5", hash_generated_method = "7C054043D3E0757739E8DD0A77CB3A31")
    @Override
    public int getLineForVertical(int vertical) {
        int high;
        high = mLineCount;
        int low;
        low = -1;
        int guess;
        int[] lines;
        lines = mLines;
        {
            guess = (high + low) >> 1;
            {
                high = guess;
            } //End block
            {
                low = guess;
            } //End block
        } //End block
        addTaint(vertical);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1580056518 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1580056518;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.668 -0400", hash_original_method = "DCA25DE9CB635243C23A0D258AEAA6C9", hash_generated_method = "26D6A817F45D11FDA1FE56AFBEB2577F")
    @Override
    public int getLineCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990267489 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990267489;
        // ---------- Original Method ----------
        //return mLineCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.668 -0400", hash_original_method = "79A8E86A0E5ABFEF4F09B2D188FA97FB", hash_generated_method = "47CD0A6B3C6E1F3AD5FFB0715EC4AB12")
    @Override
    public int getLineTop(int line) {
        int top;
        top = mLines[mColumns * line + TOP];
        {
            top += getBottomPadding();
        } //End block
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1865310559 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1865310559;
        // ---------- Original Method ----------
        //int top = mLines[mColumns * line + TOP];
        //if (mMaximumVisibleLineCount > 0 && line >= mMaximumVisibleLineCount &&
                //line != mLineCount) {
            //top += getBottomPadding();
        //}
        //return top;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.669 -0400", hash_original_method = "24456204DB122ABBCF95E31F6A475D1C", hash_generated_method = "FCC634A6D721EA6EF9E85E841A5EA5F3")
    @Override
    public int getLineDescent(int line) {
        int descent;
        descent = mLines[mColumns * line + DESCENT];
        {
            descent += getBottomPadding();
        } //End block
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1456318406 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1456318406;
        // ---------- Original Method ----------
        //int descent = mLines[mColumns * line + DESCENT];
        //if (mMaximumVisibleLineCount > 0 && line >= mMaximumVisibleLineCount - 1 && 
                //line != mLineCount) {
            //descent += getBottomPadding();
        //}
        //return descent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.669 -0400", hash_original_method = "839417F6B69B5423927C3B8DBF7A6F42", hash_generated_method = "F606182BA82ED09EF6AB538D96361439")
    @Override
    public int getLineStart(int line) {
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1103605411 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1103605411;
        // ---------- Original Method ----------
        //return mLines[mColumns * line + START] & START_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.670 -0400", hash_original_method = "4D44D66A6DA9E0A8739F807A61ABAF65", hash_generated_method = "A7DC083AC21CE01793BCC0C637F03E98")
    @Override
    public int getParagraphDirection(int line) {
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1306196463 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1306196463;
        // ---------- Original Method ----------
        //return mLines[mColumns * line + DIR] >> DIR_SHIFT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.671 -0400", hash_original_method = "F549BE615B108927B3399A138AFD2460", hash_generated_method = "3EB5FD0D6751982A3C811C6290040D72")
    @Override
    public boolean getLineContainsTab(int line) {
        addTaint(line);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_963148601 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_963148601;
        // ---------- Original Method ----------
        //return (mLines[mColumns * line + TAB] & TAB_MASK) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.671 -0400", hash_original_method = "E4C2D852DF30293005E76B99E82745CD", hash_generated_method = "97B6720E97DF732A5BCC5AC798D1DB04")
    @Override
    public final Directions getLineDirections(int line) {
        Directions varB4EAC82CA7396A68D541C85D26508E83_88212422 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_88212422 = mLineDirections[line];
        addTaint(line);
        varB4EAC82CA7396A68D541C85D26508E83_88212422.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_88212422;
        // ---------- Original Method ----------
        //return mLineDirections[line];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.672 -0400", hash_original_method = "0410F05B3F48387C42DB277B8067D4A9", hash_generated_method = "174D5F5AF12BE769DC83D0C34E3E5FC6")
    @Override
    public int getTopPadding() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716175184 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716175184;
        // ---------- Original Method ----------
        //return mTopPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.676 -0400", hash_original_method = "A7597317BC8A3102F80AD4E9AD038652", hash_generated_method = "2269C166D1CCEE0AE1EAC1AEB3D11A0C")
    @Override
    public int getBottomPadding() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166933205 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166933205;
        // ---------- Original Method ----------
        //return mBottomPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.676 -0400", hash_original_method = "7EEFC0E209C4C423B00930C7C3F48104", hash_generated_method = "D7C7A3DF14493FD6457A65D18ECD8858")
    @Override
    public int getEllipsisCount(int line) {
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_563175878 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_563175878;
        // ---------- Original Method ----------
        //if (mColumns < COLUMNS_ELLIPSIZE) {
            //return 0;
        //}
        //return mLines[mColumns * line + ELLIPSIS_COUNT];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.690 -0400", hash_original_method = "3E84E442932041329DEDBD7573FAD5F7", hash_generated_method = "1EBDF888FA9BC9235A007B658F3D47F4")
    @Override
    public int getEllipsisStart(int line) {
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_240778111 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_240778111;
        // ---------- Original Method ----------
        //if (mColumns < COLUMNS_ELLIPSIZE) {
            //return 0;
        //}
        //return mLines[mColumns * line + ELLIPSIS_START];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.690 -0400", hash_original_method = "5CA9F8625BABB74DD57E485BAAAC3103", hash_generated_method = "A8356AE6B6D12190D29A013045F7306E")
    @Override
    public int getEllipsizedWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2004201475 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2004201475;
        // ---------- Original Method ----------
        //return mEllipsizedWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.695 -0400", hash_original_method = "B52C8C631677053C363ACE90856C8484", hash_generated_method = "95EDBE59F598FE401B87F39CB299AF78")
     void prepare() {
        mMeasured = MeasuredText.obtain();
        // ---------- Original Method ----------
        //mMeasured = MeasuredText.obtain();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.695 -0400", hash_original_method = "C0F6C3CAFEEBD4E75E81773515CBCC0B", hash_generated_method = "25F76FF05D99A4E8F3EC719ABEED0A6E")
     void finish() {
        mMeasured = MeasuredText.recycle(mMeasured);
        // ---------- Original Method ----------
        //mMeasured = MeasuredText.recycle(mMeasured);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.696 -0400", hash_original_field = "95872B125F7B7861D9E38E9C7DDA5DE8", hash_generated_field = "F48F8FBE2510F4B9C03F8FA200CC70CD")

    static String TAG = "StaticLayout";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.699 -0400", hash_original_field = "3AE51DFCA721DA74B9FE7AE826399C5B", hash_generated_field = "82B151F86E6336E7EBABD8B0D2554020")

    private static int COLUMNS_NORMAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.699 -0400", hash_original_field = "55DF56DF384DF5793030D40F84610E92", hash_generated_field = "A3A118F5E931345ED3AA870AD0322498")

    private static int COLUMNS_ELLIPSIZE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "28651E175A74BF99AEB0613FFD9E4311", hash_generated_field = "AE5FE26EA7B9C33A397985D690BEF58C")

    private static int START = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "96C94187E98129DC7ED52B022D56B56E", hash_generated_field = "6D6C23CE3BFB22BC047670327434A860")

    private static int DIR = START;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "03E7882B92ED9688C792A4DF3CCA212F", hash_generated_field = "05A11F5EBF953A33392F393CCDD725E2")

    private static int TAB = START;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "571D16AE4FA766DA4380F84D324027BE", hash_generated_field = "84E5B0980A9DB65D83B460DD28EC105D")

    private static int TOP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "4DF1087155B53EE865ED8DEFEF0D2F7E", hash_generated_field = "BCA811FF720210FC7C8CADA392DE1774")

    private static int DESCENT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "11658650D3EBC5004F1DE2593A19D91C", hash_generated_field = "EB2805516F22F0D795546FE4326DA5A9")

    private static int ELLIPSIS_START = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "9DEA8A3EF4097355E23BEB471268468C", hash_generated_field = "542C907F634133B97C93B9DB7D8B9BDC")

    private static int ELLIPSIS_COUNT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "479F76462347F1E81B6EC92F50573413", hash_generated_field = "F4AF13B0F41E7915D7A01D78326744F8")

    private static int START_MASK = 0x1FFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "3CE9D0897644F1685651D602FF457A11", hash_generated_field = "26F6116498B4B99F247AFFED1D2ADAC3")

    private static int DIR_SHIFT = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "C52FA1DB43D0A9E4AB2D27DC3ED50BD6", hash_generated_field = "CE6C698FB46054E82230E9F62AB1B199")

    private static int TAB_MASK = 0x20000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "5857BDFF3BF33113730586AF5B28164F", hash_generated_field = "BD4519227226DE6CF8B5B95534D34642")

    private static int TAB_INCREMENT = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "D12D3634E072793BACFCFCC6DF78CE4B", hash_generated_field = "4E18843AD894A4267568DC256C011F91")

    private static char CHAR_FIRST_CJK = '\u2E80';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "00A52FFD05B158140F163AE416840413", hash_generated_field = "0B77DBA4E0C6B36781C3B7DE2C6FB535")

    private static char CHAR_NEW_LINE = '\n';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "7CEA2D58CE9FE60FCE1405E11A2F16B5", hash_generated_field = "15EB73CED57EFD17B8C1A6248C79E57B")

    private static char CHAR_TAB = '\t';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "AB5806A9D7897E1EED82CC37BF968FE0", hash_generated_field = "823544151C490B192913ACAD2113E34B")

    private static char CHAR_SPACE = ' ';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "6C7F27ADADD73E9D7E1011C0EFF91FA1", hash_generated_field = "909E911C213A98DD0E9D573EDBE52F93")

    private static char CHAR_DOT = '.';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "22BFFF2E9C98A18E97B84C2EEB94338F", hash_generated_field = "4A3E1C0BB8AFA7D2368D19A96D21E73E")

    private static char CHAR_COMMA = ',';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "FE1A9DABDFCB157F2908BF6CD35FCE5B", hash_generated_field = "6DAA962E0902E40132B49B521E96C740")

    private static char CHAR_COLON = ':';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "C92AA43D6022E95DCA4F5B63ED80FF2C", hash_generated_field = "7D5F3D193137D0073543933A065A3007")

    private static char CHAR_SEMICOLON = ';';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "F45EF65010D62FA697204F2D5213C54D", hash_generated_field = "1FE4765CE14944D95D22C65E46B93B2A")

    private static char CHAR_SLASH = '/';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "72DEAD401756357C1B8CD8F98362FA8C", hash_generated_field = "D62ECB061E281319A2EFF9859FC7C315")

    private static char CHAR_HYPHEN = '-';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "5C6729C339E50626FF445F7364D13172", hash_generated_field = "CEA3C82A2220956F0B6154B391C006DC")

    private static double EXTRA_ROUNDING = 0.5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.700 -0400", hash_original_field = "1DBD92DD1658F4ADDF0F957D8B97982A", hash_generated_field = "EDB2B32174F77409D911A1005BDFB5F2")

    private static String ELLIPSIS_NORMAL = "\u2026";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.701 -0400", hash_original_field = "B63101E3F6BAA0CA142477AA62972904", hash_generated_field = "2788DC557F23C2DF62458573830335F0")

    private static String ELLIPSIS_TWO_DOTS = "\u2025";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.701 -0400", hash_original_field = "41CF096C0A9F72FA9AE4C83AF587A230", hash_generated_field = "6E56BFF8029B531FC63BB3EC570502D1")

    private static int CHAR_FIRST_HIGH_SURROGATE = 0xD800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:40.701 -0400", hash_original_field = "485B1B5DF5DC77A82D51FABFA3C0D8D8", hash_generated_field = "BFE70AC4C1ED3124F6991BAC601B5ED2")

    private static int CHAR_LAST_LOW_SURROGATE = 0xDFFF;
}

