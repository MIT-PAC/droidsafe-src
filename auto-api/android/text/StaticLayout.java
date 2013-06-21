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
    private int mLineCount;
    private int mTopPadding, mBottomPadding;
    private int mColumns;
    private int mEllipsizedWidth;
    private int[] mLines;
    private Directions[] mLineDirections;
    private int mMaximumVisibleLineCount = Integer.MAX_VALUE;
    private MeasuredText mMeasured;
    private Paint.FontMetricsInt mFontMetricsInt = new Paint.FontMetricsInt();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.588 -0400", hash_original_method = "C77149727B404FEFD5CB3129B7BB45BF", hash_generated_method = "9013D52857101A1735BF9C5B735B67E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StaticLayout(CharSequence source, TextPaint paint,
                        int width,
                        Alignment align, float spacingmult, float spacingadd,
                        boolean includepad) {
        this(source, 0, source.length(), paint, width, align,
             spacingmult, spacingadd, includepad);
        dsTaint.addTaint(includepad);
        dsTaint.addTaint(source);
        dsTaint.addTaint(align.dsTaint);
        dsTaint.addTaint(width);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(spacingadd);
        dsTaint.addTaint(spacingmult);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.588 -0400", hash_original_method = "81565FB766EC1D266415894033F3BC38", hash_generated_method = "CE8FF33AE05DB3C6A9D3C28B6511CFAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StaticLayout(CharSequence source, TextPaint paint,
            int width, Alignment align, TextDirectionHeuristic textDir,
            float spacingmult, float spacingadd,
            boolean includepad) {
        this(source, 0, source.length(), paint, width, align, textDir,
                spacingmult, spacingadd, includepad);
        dsTaint.addTaint(includepad);
        dsTaint.addTaint(textDir.dsTaint);
        dsTaint.addTaint(source);
        dsTaint.addTaint(align.dsTaint);
        dsTaint.addTaint(width);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(spacingadd);
        dsTaint.addTaint(spacingmult);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.588 -0400", hash_original_method = "BF066121E6D6D3B30CB2E4FB82D6E631", hash_generated_method = "33F7ADD7A31168F5E32AB99DF7084617")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StaticLayout(CharSequence source, int bufstart, int bufend,
                        TextPaint paint, int outerwidth,
                        Alignment align,
                        float spacingmult, float spacingadd,
                        boolean includepad) {
        this(source, bufstart, bufend, paint, outerwidth, align,
             spacingmult, spacingadd, includepad, null, 0);
        dsTaint.addTaint(includepad);
        dsTaint.addTaint(outerwidth);
        dsTaint.addTaint(source);
        dsTaint.addTaint(align.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(bufstart);
        dsTaint.addTaint(spacingadd);
        dsTaint.addTaint(spacingmult);
        dsTaint.addTaint(bufend);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.588 -0400", hash_original_method = "683465774808809C7366667F354731A1", hash_generated_method = "3D18D7CE38C8BAB79BFC25B9C6C9E03D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StaticLayout(CharSequence source, int bufstart, int bufend,
            TextPaint paint, int outerwidth,
            Alignment align, TextDirectionHeuristic textDir,
            float spacingmult, float spacingadd,
            boolean includepad) {
        this(source, bufstart, bufend, paint, outerwidth, align, textDir,
                spacingmult, spacingadd, includepad, null, 0, Integer.MAX_VALUE);
        dsTaint.addTaint(includepad);
        dsTaint.addTaint(textDir.dsTaint);
        dsTaint.addTaint(outerwidth);
        dsTaint.addTaint(source);
        dsTaint.addTaint(align.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(bufstart);
        dsTaint.addTaint(spacingadd);
        dsTaint.addTaint(spacingmult);
        dsTaint.addTaint(bufend);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.589 -0400", hash_original_method = "D92F1C5E6D18A86EA341983F1D2D5889", hash_generated_method = "8E9FFCAEBC0ED7FBA8D6D614FC1A4700")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StaticLayout(CharSequence source, int bufstart, int bufend,
            TextPaint paint, int outerwidth,
            Alignment align,
            float spacingmult, float spacingadd,
            boolean includepad,
            TextUtils.TruncateAt ellipsize, int ellipsizedWidth) {
        this(source, bufstart, bufend, paint, outerwidth, align,
                TextDirectionHeuristics.FIRSTSTRONG_LTR,
                spacingmult, spacingadd, includepad, ellipsize, ellipsizedWidth, Integer.MAX_VALUE);
        dsTaint.addTaint(includepad);
        dsTaint.addTaint(ellipsizedWidth);
        dsTaint.addTaint(outerwidth);
        dsTaint.addTaint(source);
        dsTaint.addTaint(align.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(bufstart);
        dsTaint.addTaint(spacingadd);
        dsTaint.addTaint(spacingmult);
        dsTaint.addTaint(ellipsize.dsTaint);
        dsTaint.addTaint(bufend);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.589 -0400", hash_original_method = "67715870CA89D1E43E3638ABED5B90D0", hash_generated_method = "3D4453AD44B9C312045E29EF3E9F4113")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StaticLayout(CharSequence source, int bufstart, int bufend,
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
        dsTaint.addTaint(outerwidth);
        dsTaint.addTaint(maxLines);
        dsTaint.addTaint(align.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(spacingadd);
        dsTaint.addTaint(spacingmult);
        dsTaint.addTaint(bufend);
        dsTaint.addTaint(textDir.dsTaint);
        dsTaint.addTaint(includepad);
        dsTaint.addTaint(ellipsizedWidth);
        dsTaint.addTaint(source);
        dsTaint.addTaint(bufstart);
        dsTaint.addTaint(ellipsize.dsTaint);
        {
            Ellipsizer e;
            e = (Ellipsizer) getText();
            e.mLayout = this;
            e.mWidth = ellipsizedWidth;
            e.mMethod = ellipsize;
            mColumns = COLUMNS_ELLIPSIZE;
        } //End block
        {
            mColumns = COLUMNS_NORMAL;
        } //End block
        mLines = new int[ArrayUtils.idealIntArraySize(2 * mColumns)];
        mLineDirections = new Directions[
                             ArrayUtils.idealIntArraySize(2 * mColumns)];
        mMeasured = MeasuredText.obtain();
        generate(source, bufstart, bufend, paint, outerwidth, textDir, spacingmult,
                 spacingadd, includepad, includepad, ellipsizedWidth,
                 ellipsize);
        mMeasured = MeasuredText.recycle(mMeasured);
        mFontMetricsInt = null;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.589 -0400", hash_original_method = "F6D0B9C991ED85508405BA894E3CF311", hash_generated_method = "A4718F43F8A33BCAD2F26F604E94A7C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     StaticLayout(CharSequence text) {
        super(text, null, 0, null, 0, 0);
        dsTaint.addTaint(text);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.593 -0400", hash_original_method = "36200F938D6B110E70DA8FCD0A142EF7", hash_generated_method = "1A354DF24E67B46B5CC0EF3AC991E65A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void generate(CharSequence source, int bufStart, int bufEnd,
                        TextPaint paint, int outerWidth,
                        TextDirectionHeuristic textDir, float spacingmult,
                        float spacingadd, boolean includepad,
                        boolean trackpad, float ellipsizedWidth,
                        TextUtils.TruncateAt ellipsize) {
        dsTaint.addTaint(includepad);
        dsTaint.addTaint(textDir.dsTaint);
        dsTaint.addTaint(ellipsizedWidth);
        dsTaint.addTaint(source);
        dsTaint.addTaint(bufStart);
        dsTaint.addTaint(trackpad);
        dsTaint.addTaint(bufEnd);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(spacingadd);
        dsTaint.addTaint(spacingmult);
        dsTaint.addTaint(ellipsize.dsTaint);
        dsTaint.addTaint(outerWidth);
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
                                        boolean varB520B0E4FB3D6569062BDD8343CF19D9_906318993 = (c == CHAR_SPACE || c == CHAR_TAB ||
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
            boolean varD6A6A425370B61445227FF156BD0D4E6_14320594 = ((bufEnd == bufStart || source.charAt(bufEnd - 1) == CHAR_NEW_LINE) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.595 -0400", hash_original_method = "478F3FA593939ABCBF542030DE605E96", hash_generated_method = "4D4A79FABBBF3A8ED97688E993F9D5A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        dsTaint.addTaint(needMultiply);
        dsTaint.addTaint(widths[0]);
        dsTaint.addTaint(hasTabOrEmoji);
        dsTaint.addTaint(spacingadd);
        dsTaint.addTaint(chooseHtv[0]);
        dsTaint.addTaint(fm.dsTaint);
        dsTaint.addTaint(easy);
        dsTaint.addTaint(dir);
        dsTaint.addTaint(below);
        dsTaint.addTaint(above);
        dsTaint.addTaint(includePad);
        dsTaint.addTaint(moreChars);
        dsTaint.addTaint(end);
        dsTaint.addTaint(top);
        dsTaint.addTaint(text);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(spacingmult);
        dsTaint.addTaint(textWidth);
        dsTaint.addTaint(trackPad);
        dsTaint.addTaint(v);
        dsTaint.addTaint(chooseHt[0].dsTaint);
        dsTaint.addTaint(chdirs[0]);
        dsTaint.addTaint(start);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(bufEnd);
        dsTaint.addTaint(widthStart);
        dsTaint.addTaint(chs[0]);
        dsTaint.addTaint(ellipsisWidth);
        dsTaint.addTaint(ellipsize.dsTaint);
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.596 -0400", hash_original_method = "12884526F2C70C1C98137C0940B4D04E", hash_generated_method = "CE1481225FDC832811305AD420FC72D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void calculateEllipsis(int lineStart, int lineEnd,
                                   float[] widths, int widthStart,
                                   float avail, TextUtils.TruncateAt where,
                                   int line, float textWidth, TextPaint paint,
                                   boolean forceEllipsis) {
        dsTaint.addTaint(forceEllipsis);
        dsTaint.addTaint(lineStart);
        dsTaint.addTaint(line);
        dsTaint.addTaint(widths[0]);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(avail);
        dsTaint.addTaint(widthStart);
        dsTaint.addTaint(where.dsTaint);
        dsTaint.addTaint(textWidth);
        dsTaint.addTaint(lineEnd);
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
                    boolean varDB9C000D9EED0EBC5F67F0C4656298B5_1030081387 = (Log.isLoggable(TAG, Log.WARN));
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
                    boolean varDB9C000D9EED0EBC5F67F0C4656298B5_732735056 = (Log.isLoggable(TAG, Log.WARN));
                } //End collapsed parenthetic
            } //End block
        } //End block
        mLines[mColumns * line + ELLIPSIS_START] = ellipsisStart;
        mLines[mColumns * line + ELLIPSIS_COUNT] = ellipsisCount;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.597 -0400", hash_original_method = "98509D881029C8DC6B023EB0DACF92F5", hash_generated_method = "301EFD089F32DB50496671004A13734F")
    @DSModeled(DSC.SAFE)
    @Override
    public int getLineForVertical(int vertical) {
        dsTaint.addTaint(vertical);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.597 -0400", hash_original_method = "DCA25DE9CB635243C23A0D258AEAA6C9", hash_generated_method = "CB9409C68204607BE138705FC9041DCB")
    @DSModeled(DSC.SAFE)
    @Override
    public int getLineCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLineCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.597 -0400", hash_original_method = "79A8E86A0E5ABFEF4F09B2D188FA97FB", hash_generated_method = "7902ED830C5D2AC52382B276CC11FB58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getLineTop(int line) {
        dsTaint.addTaint(line);
        int top;
        top = mLines[mColumns * line + TOP];
        {
            top += getBottomPadding();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int top = mLines[mColumns * line + TOP];
        //if (mMaximumVisibleLineCount > 0 && line >= mMaximumVisibleLineCount &&
                //line != mLineCount) {
            //top += getBottomPadding();
        //}
        //return top;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.597 -0400", hash_original_method = "24456204DB122ABBCF95E31F6A475D1C", hash_generated_method = "8CC395E91B5E075308A81711B4674C42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getLineDescent(int line) {
        dsTaint.addTaint(line);
        int descent;
        descent = mLines[mColumns * line + DESCENT];
        {
            descent += getBottomPadding();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int descent = mLines[mColumns * line + DESCENT];
        //if (mMaximumVisibleLineCount > 0 && line >= mMaximumVisibleLineCount - 1 && 
                //line != mLineCount) {
            //descent += getBottomPadding();
        //}
        //return descent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.598 -0400", hash_original_method = "839417F6B69B5423927C3B8DBF7A6F42", hash_generated_method = "5FE20E49237D5F124734BF20C9EDA5E1")
    @DSModeled(DSC.SAFE)
    @Override
    public int getLineStart(int line) {
        dsTaint.addTaint(line);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLines[mColumns * line + START] & START_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.598 -0400", hash_original_method = "4D44D66A6DA9E0A8739F807A61ABAF65", hash_generated_method = "59AA1D523F64E93C48A7006236A3851A")
    @DSModeled(DSC.SAFE)
    @Override
    public int getParagraphDirection(int line) {
        dsTaint.addTaint(line);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLines[mColumns * line + DIR] >> DIR_SHIFT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.598 -0400", hash_original_method = "F549BE615B108927B3399A138AFD2460", hash_generated_method = "C0011C9BD8B3423E3A9DD8D147ADBC40")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean getLineContainsTab(int line) {
        dsTaint.addTaint(line);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mLines[mColumns * line + TAB] & TAB_MASK) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.598 -0400", hash_original_method = "E4C2D852DF30293005E76B99E82745CD", hash_generated_method = "1AC26AB6514246841B657C22B953EA7C")
    @DSModeled(DSC.SAFE)
    @Override
    public final Directions getLineDirections(int line) {
        dsTaint.addTaint(line);
        return (Directions)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLineDirections[line];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.598 -0400", hash_original_method = "0410F05B3F48387C42DB277B8067D4A9", hash_generated_method = "FA47B026F2C44A937D9C405114C71495")
    @DSModeled(DSC.SAFE)
    @Override
    public int getTopPadding() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTopPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.599 -0400", hash_original_method = "A7597317BC8A3102F80AD4E9AD038652", hash_generated_method = "6889C8E9FBF2C0906C69CE0D62BF8388")
    @DSModeled(DSC.SAFE)
    @Override
    public int getBottomPadding() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBottomPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.599 -0400", hash_original_method = "7EEFC0E209C4C423B00930C7C3F48104", hash_generated_method = "3C2F5785755A843F8229FFC7E9080B8A")
    @DSModeled(DSC.SAFE)
    @Override
    public int getEllipsisCount(int line) {
        dsTaint.addTaint(line);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mColumns < COLUMNS_ELLIPSIZE) {
            //return 0;
        //}
        //return mLines[mColumns * line + ELLIPSIS_COUNT];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.599 -0400", hash_original_method = "3E84E442932041329DEDBD7573FAD5F7", hash_generated_method = "F4EB801C398DB67A1495737169B2083F")
    @DSModeled(DSC.SAFE)
    @Override
    public int getEllipsisStart(int line) {
        dsTaint.addTaint(line);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mColumns < COLUMNS_ELLIPSIZE) {
            //return 0;
        //}
        //return mLines[mColumns * line + ELLIPSIS_START];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.599 -0400", hash_original_method = "5CA9F8625BABB74DD57E485BAAAC3103", hash_generated_method = "1883110F0CECE5EEE366F4E7139C3405")
    @DSModeled(DSC.SAFE)
    @Override
    public int getEllipsizedWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEllipsizedWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.599 -0400", hash_original_method = "B52C8C631677053C363ACE90856C8484", hash_generated_method = "95EDBE59F598FE401B87F39CB299AF78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void prepare() {
        mMeasured = MeasuredText.obtain();
        // ---------- Original Method ----------
        //mMeasured = MeasuredText.obtain();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.600 -0400", hash_original_method = "C0F6C3CAFEEBD4E75E81773515CBCC0B", hash_generated_method = "25F76FF05D99A4E8F3EC719ABEED0A6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void finish() {
        mMeasured = MeasuredText.recycle(mMeasured);
        // ---------- Original Method ----------
        //mMeasured = MeasuredText.recycle(mMeasured);
    }

    
    static final String TAG = "StaticLayout";
    private static final int COLUMNS_NORMAL = 3;
    private static final int COLUMNS_ELLIPSIZE = 5;
    private static final int START = 0;
    private static final int DIR = START;
    private static final int TAB = START;
    private static final int TOP = 1;
    private static final int DESCENT = 2;
    private static final int ELLIPSIS_START = 3;
    private static final int ELLIPSIS_COUNT = 4;
    private static final int START_MASK = 0x1FFFFFFF;
    private static final int DIR_SHIFT  = 30;
    private static final int TAB_MASK   = 0x20000000;
    private static final int TAB_INCREMENT = 20;
    private static final char CHAR_FIRST_CJK = '\u2E80';
    private static final char CHAR_NEW_LINE = '\n';
    private static final char CHAR_TAB = '\t';
    private static final char CHAR_SPACE = ' ';
    private static final char CHAR_DOT = '.';
    private static final char CHAR_COMMA = ',';
    private static final char CHAR_COLON = ':';
    private static final char CHAR_SEMICOLON = ';';
    private static final char CHAR_SLASH = '/';
    private static final char CHAR_HYPHEN = '-';
    private static final double EXTRA_ROUNDING = 0.5;
    private static final String ELLIPSIS_NORMAL = "\u2026";
    private static final String ELLIPSIS_TWO_DOTS = "\u2025";
    private static final int CHAR_FIRST_HIGH_SURROGATE = 0xD800;
    private static final int CHAR_LAST_LOW_SURROGATE = 0xDFFF;
}

