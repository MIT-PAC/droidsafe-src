package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.emoji.EmojiFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.method.TextKeyListener;
import android.text.style.AlignmentSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LeadingMarginSpan.LeadingMarginSpan2;
import android.text.style.LineBackgroundSpan;
import android.text.style.ParagraphStyle;
import android.text.style.ReplacementSpan;
import android.text.style.TabStopSpan;
import com.android.internal.util.ArrayUtils;
import java.util.Arrays;

public abstract class Layout {
    private CharSequence mText;
    private TextPaint mPaint;
    TextPaint mWorkPaint;
    private int mWidth;
    private Alignment mAlignment = Alignment.ALIGN_NORMAL;
    private float mSpacingMult;
    private float mSpacingAdd;
    private boolean mSpannedText;
    private TextDirectionHeuristic mTextDir;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.102 -0400", hash_original_method = "DA432A00E31F4EFC04FE32B9AEC1CEE4", hash_generated_method = "DC4D1694C5AA1B90D4820FBBFB5A7E58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Layout(CharSequence text, TextPaint paint,
                     int width, Alignment align,
                     float spacingMult, float spacingAdd) {
        this(text, paint, width, align, TextDirectionHeuristics.FIRSTSTRONG_LTR,
                spacingMult, spacingAdd);
        dsTaint.addTaint(spacingAdd);
        dsTaint.addTaint(text);
        dsTaint.addTaint(align.dsTaint);
        dsTaint.addTaint(width);
        dsTaint.addTaint(spacingMult);
        dsTaint.addTaint(paint.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.102 -0400", hash_original_method = "E08E539EEFF1AD274546B85662DC9DCC", hash_generated_method = "27411CFAB4ECC20C6D112C7F7FB36679")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Layout(CharSequence text, TextPaint paint,
                     int width, Alignment align, TextDirectionHeuristic textDir,
                     float spacingMult, float spacingAdd) {
        dsTaint.addTaint(spacingAdd);
        dsTaint.addTaint(textDir.dsTaint);
        dsTaint.addTaint(text);
        dsTaint.addTaint(align.dsTaint);
        dsTaint.addTaint(width);
        dsTaint.addTaint(spacingMult);
        dsTaint.addTaint(paint.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Layout: " + width + " < 0");
        {
            paint.bgColor = 0;
            paint.baselineShift = 0;
        } //End block
        mWorkPaint = new TextPaint();
        mSpannedText = text instanceof Spanned;
        // ---------- Original Method ----------
        //if (width < 0)
            //throw new IllegalArgumentException("Layout: " + width + " < 0");
        //if (paint != null) {
            //paint.bgColor = 0;
            //paint.baselineShift = 0;
        //}
        //mText = text;
        //mPaint = paint;
        //mWorkPaint = new TextPaint();
        //mWidth = width;
        //mAlignment = align;
        //mSpacingMult = spacingMult;
        //mSpacingAdd = spacingAdd;
        //mSpannedText = text instanceof Spanned;
        //mTextDir = textDir;
    }

    
        public static float getDesiredWidth(CharSequence source,
                                        TextPaint paint) {
        return getDesiredWidth(source, 0, source.length(), paint);
    }

    
        public static float getDesiredWidth(CharSequence source,
                                        int start, int end,
                                        TextPaint paint) {
        float need = 0;
        TextPaint workPaint = new TextPaint();
        int next;
        for (int i = start; i <= end; i = next) {
            next = TextUtils.indexOf(source, '\n', i, end);
            if (next < 0)
                next = end;
            float w = measurePara(paint, workPaint, source, i, next);
            if (w > need)
                need = w;
            next++;
        }
        return need;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.103 -0400", hash_original_method = "4BA809AE232557C36D4CE5AE6E36D4D2", hash_generated_method = "565D021D127A659F64D3D7460CDF5841")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void replaceWith(CharSequence text, TextPaint paint,
                              int width, Alignment align,
                              float spacingmult, float spacingadd) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(align.dsTaint);
        dsTaint.addTaint(width);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(spacingadd);
        dsTaint.addTaint(spacingmult);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Layout: " + width + " < 0");
        } //End block
        mSpannedText = text instanceof Spanned;
        // ---------- Original Method ----------
        //if (width < 0) {
            //throw new IllegalArgumentException("Layout: " + width + " < 0");
        //}
        //mText = text;
        //mPaint = paint;
        //mWidth = width;
        //mAlignment = align;
        //mSpacingMult = spacingmult;
        //mSpacingAdd = spacingadd;
        //mSpannedText = text instanceof Spanned;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.103 -0400", hash_original_method = "21986991A7FC788A39082240DAE8B9C3", hash_generated_method = "8C8FFA4CB27BDE4519409628F812E868")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void draw(Canvas c) {
        dsTaint.addTaint(c.dsTaint);
        draw(c, null, null, 0);
        // ---------- Original Method ----------
        //draw(c, null, null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.105 -0400", hash_original_method = "C63D8686FF6D60F338825542CA174C93", hash_generated_method = "43B599C6A9DAF626930C9EDA2ADE9CF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void draw(Canvas c, Path highlight, Paint highlightPaint,
                     int cursorOffsetVertical) {
        dsTaint.addTaint(highlightPaint.dsTaint);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(cursorOffsetVertical);
        dsTaint.addTaint(highlight.dsTaint);
        int dtop, dbottom;
        {
            {
                boolean varC42A531B776DA8F33EFB072E74A6FC1E_1709382169 = (!c.getClipBounds(sTempRect));
            } //End collapsed parenthetic
            dtop = sTempRect.top;
            dbottom = sTempRect.bottom;
        } //End block
        int top;
        top = 0;
        int bottom;
        bottom = getLineTop(getLineCount());
        {
            top = dtop;
        } //End block
        {
            bottom = dbottom;
        } //End block
        int first;
        first = getLineForVertical(top);
        int last;
        last = getLineForVertical(bottom);
        int previousLineBottom;
        previousLineBottom = getLineTop(first);
        int previousLineEnd;
        previousLineEnd = getLineStart(first);
        TextPaint paint;
        paint = mPaint;
        CharSequence buf;
        buf = mText;
        int width;
        width = mWidth;
        boolean spannedText;
        spannedText = mSpannedText;
        ParagraphStyle[] spans;
        spans = NO_PARA_SPANS;
        int spanEnd;
        spanEnd = 0;
        int textLength;
        textLength = 0;
        {
            Spanned sp;
            sp = (Spanned) buf;
            textLength = buf.length();
            {
                int i;
                i = first;
                {
                    int start;
                    start = previousLineEnd;
                    int end;
                    end = getLineStart(i+1);
                    previousLineEnd = end;
                    int ltop;
                    ltop = previousLineBottom;
                    int lbottom;
                    lbottom = getLineTop(i+1);
                    previousLineBottom = lbottom;
                    int lbaseline;
                    lbaseline = lbottom - getLineDescent(i);
                    {
                        spanEnd = sp.nextSpanTransition(start, textLength,
                            LineBackgroundSpan.class);
                        spans = getParagraphSpans(sp, start, end, LineBackgroundSpan.class);
                    } //End block
                    {
                        int n;
                        n = 0;
                        {
                            LineBackgroundSpan back;
                            back = (LineBackgroundSpan) spans[n];
                            back.drawBackground(c, paint, 0, width,
                                       ltop, lbaseline, lbottom,
                                       buf, start, end,
                                       i);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            spanEnd = 0;
            previousLineBottom = getLineTop(first);
            previousLineEnd = getLineStart(first);
            spans = NO_PARA_SPANS;
        } //End block
        {
            {
                c.translate(0, cursorOffsetVertical);
            } //End block
            c.drawPath(highlight, highlightPaint);
            {
                c.translate(0, -cursorOffsetVertical);
            } //End block
        } //End block
        Alignment paraAlign;
        paraAlign = mAlignment;
        TabStops tabStops;
        tabStops = null;
        boolean tabStopsIsInitialized;
        tabStopsIsInitialized = false;
        TextLine tl;
        tl = TextLine.obtain();
        {
            int i;
            i = first;
            {
                int start;
                start = previousLineEnd;
                previousLineEnd = getLineStart(i+1);
                int end;
                end = getLineVisibleEnd(i, start, previousLineEnd);
                int ltop;
                ltop = previousLineBottom;
                int lbottom;
                lbottom = getLineTop(i+1);
                previousLineBottom = lbottom;
                int lbaseline;
                lbaseline = lbottom - getLineDescent(i);
                int dir;
                dir = getParagraphDirection(i);
                int left;
                left = 0;
                int right;
                right = mWidth;
                {
                    Spanned sp;
                    sp = (Spanned) buf;
                    boolean isFirstParaLine;
                    isFirstParaLine = (start == 0 ||
                        buf.charAt(start - 1) == '\n');
                    {
                        spanEnd = sp.nextSpanTransition(start, textLength,
                                                    ParagraphStyle.class);
                        spans = getParagraphSpans(sp, start, spanEnd, ParagraphStyle.class);
                        paraAlign = mAlignment;
                        {
                            int n;
                            n = spans.length-1;
                            {
                                {
                                    paraAlign = ((AlignmentSpan) spans[n]).getAlignment();
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                        tabStopsIsInitialized = false;
                    } //End block
                    int length;
                    length = spans.length;
                    {
                        int n;
                        n = 0;
                        {
                            {
                                LeadingMarginSpan margin;
                                margin = (LeadingMarginSpan) spans[n];
                                boolean useFirstLineMargin;
                                useFirstLineMargin = isFirstParaLine;
                                {
                                    int count;
                                    count = ((LeadingMarginSpan2) margin).getLeadingMarginLineCount();
                                    int startLine;
                                    startLine = getLineForOffset(sp.getSpanStart(margin));
                                    useFirstLineMargin = i < startLine + count;
                                } //End block
                                {
                                    margin.drawLeadingMargin(c, paint, right, dir, ltop,
                                                     lbaseline, lbottom, buf,
                                                     start, end, isFirstParaLine, this);
                                    right -= margin.getLeadingMargin(useFirstLineMargin);
                                } //End block
                                {
                                    margin.drawLeadingMargin(c, paint, left, dir, ltop,
                                                     lbaseline, lbottom, buf,
                                                     start, end, isFirstParaLine, this);
                                    left += margin.getLeadingMargin(useFirstLineMargin);
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                boolean hasTabOrEmoji;
                hasTabOrEmoji = getLineContainsTab(i);
                {
                    {
                        tabStops = new TabStops(TAB_INCREMENT, spans);
                    } //End block
                    {
                        tabStops.reset(TAB_INCREMENT, spans);
                    } //End block
                    tabStopsIsInitialized = true;
                } //End block
                Alignment align;
                align = paraAlign;
                {
                    align = (dir == DIR_LEFT_TO_RIGHT) ?
                    Alignment.ALIGN_NORMAL : Alignment.ALIGN_OPPOSITE;
                } //End block
                {
                    align = (dir == DIR_LEFT_TO_RIGHT) ?
                    Alignment.ALIGN_OPPOSITE : Alignment.ALIGN_NORMAL;
                } //End block
                int x;
                {
                    {
                        x = left;
                    } //End block
                    {
                        x = right;
                    } //End block
                } //End block
                {
                    int max;
                    max = (int)getLineExtent(i, tabStops, false);
                    {
                        {
                            x = right - max;
                        } //End block
                        {
                            x = left - max;
                        } //End block
                    } //End block
                    {
                        max = max & ~1;
                        x = (right + left - max) >> 1;
                    } //End block
                } //End block
                Directions directions;
                directions = getLineDirections(i);
                {
                    c.drawText(buf, start, end, x, lbaseline, paint);
                } //End block
                {
                    tl.set(paint, buf, start, end, dir, directions, hasTabOrEmoji, tabStops);
                    tl.draw(c, x, ltop, lbaseline, lbottom);
                } //End block
            } //End block
        } //End collapsed parenthetic
        TextLine.recycle(tl);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.106 -0400", hash_original_method = "94C8B0A33C8A9972488E17891E7B8BAC", hash_generated_method = "264CA77DEFD101FBA00BFE55A41B7718")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getLineStartPos(int line, int left, int right) {
        dsTaint.addTaint(line);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        Alignment align;
        align = getParagraphAlignment(line);
        int dir;
        dir = getParagraphDirection(line);
        int x;
        {
            x = left;
        } //End block
        {
            {
                x = left;
            } //End block
            {
                x = right;
            } //End block
        } //End block
        {
            TabStops tabStops;
            tabStops = null;
            {
                boolean varEBDDE922AE0589A6CEAD24B0AC5E6B48_1094094256 = (mSpannedText && getLineContainsTab(line));
                {
                    Spanned spanned;
                    spanned = (Spanned) mText;
                    int start;
                    start = getLineStart(line);
                    int spanEnd;
                    spanEnd = spanned.nextSpanTransition(start, spanned.length(),
                        TabStopSpan.class);
                    TabStopSpan[] tabSpans;
                    tabSpans = getParagraphSpans(spanned, start, spanEnd, TabStopSpan.class);
                    {
                        tabStops = new TabStops(TAB_INCREMENT, tabSpans);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            int max;
            max = (int)getLineExtent(line, tabStops, false);
            {
                x = right - max;
            } //End block
            {
                {
                    x = right - max;
                } //End block
                {
                    x = left - max;
                } //End block
            } //End block
            {
                max = max & ~1;
                x = (left + right - max) >> 1;
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.106 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "ACFAACEEAFC35ED18A33AE824F74CEA6")
    @DSModeled(DSC.SAFE)
    public final CharSequence getText() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.107 -0400", hash_original_method = "7064C5093467A23605D5C425E4D25B83", hash_generated_method = "AB12CFA3AB0E4E96BEACABB6E94663D2")
    @DSModeled(DSC.SAFE)
    public final TextPaint getPaint() {
        return (TextPaint)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mPaint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.107 -0400", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "B7093611B93F43844E581B058C2FA6F0")
    @DSModeled(DSC.SAFE)
    public final int getWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.107 -0400", hash_original_method = "90F96A059D406483E44444E82D555D1F", hash_generated_method = "974A0014D2435573605189970634E3F4")
    @DSModeled(DSC.SAFE)
    public int getEllipsizedWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.107 -0400", hash_original_method = "461CE12B89AFCA61718D5C5F590357B0", hash_generated_method = "78ECBA37B8AD928B98310F4CB548A81E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void increaseWidthTo(int wid) {
        dsTaint.addTaint(wid);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("attempted to reduce Layout width");
        } //End block
        // ---------- Original Method ----------
        //if (wid < mWidth) {
            //throw new RuntimeException("attempted to reduce Layout width");
        //}
        //mWidth = wid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.107 -0400", hash_original_method = "5212B162F472F11B6A60B5BD891C860A", hash_generated_method = "4D9B9415D224F664A7725030CE8F77A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getHeight() {
        int var7ED7F6E2EB0B1BC7A56013BEE63A9A35_1447391176 = (getLineTop(getLineCount()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getLineTop(getLineCount());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.108 -0400", hash_original_method = "FB2D4D43E3EFDD971010AB3AFA49B442", hash_generated_method = "A0FC633010451F8DE5C6DCACFDEFC145")
    @DSModeled(DSC.SAFE)
    public final Alignment getAlignment() {
        return (Alignment)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAlignment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.108 -0400", hash_original_method = "F861D6694D511E0A8AF4CE2A5552F333", hash_generated_method = "E5EC466AF05CB62F06D0A3843F1EA1B0")
    @DSModeled(DSC.SAFE)
    public final float getSpacingMultiplier() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mSpacingMult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.108 -0400", hash_original_method = "E15AF37508F3C3C8F31DF2917343152C", hash_generated_method = "D749B67207C856EA2395D28B7863DA82")
    @DSModeled(DSC.SAFE)
    public final float getSpacingAdd() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mSpacingAdd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.108 -0400", hash_original_method = "CEF29A1F61D81E3972548E19A0D7158C", hash_generated_method = "4E3BCCD33446F29451F508BEA32963A9")
    @DSModeled(DSC.SAFE)
    public final TextDirectionHeuristic getTextDirectionHeuristic() {
        return (TextDirectionHeuristic)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTextDir;
    }

    
    public abstract int getLineCount();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.109 -0400", hash_original_method = "6295516BE4612811C14BD1DCED80BAB8", hash_generated_method = "93D159687F8DA7ED8327F0C55B86C688")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLineBounds(int line, Rect bounds) {
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(line);
        {
            bounds.left = 0;
            bounds.top = getLineTop(line);
            bounds.right = mWidth;
            bounds.bottom = getLineTop(line + 1);
        } //End block
        int var29FD769CAB68A42F60CF514C827201BE_555821563 = (getLineBaseline(line));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (bounds != null) {
            //bounds.left = 0;     
            //bounds.top = getLineTop(line);
            //bounds.right = mWidth;   
            //bounds.bottom = getLineTop(line + 1);
        //}
        //return getLineBaseline(line);
    }

    
    public abstract int getLineTop(int line);

    
    public abstract int getLineDescent(int line);

    
    public abstract int getLineStart(int line);

    
    public abstract int getParagraphDirection(int line);

    
    public abstract boolean getLineContainsTab(int line);

    
    public abstract Directions getLineDirections(int line);

    
    public abstract int getTopPadding();

    
    public abstract int getBottomPadding();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.110 -0400", hash_original_method = "2C3949CE81E6BE871356E85B216A576F", hash_generated_method = "425BDACC21E5BF0D651531BB58707FD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isLevelBoundary(int offset) {
        dsTaint.addTaint(offset);
        int line;
        line = getLineForOffset(offset);
        Directions dirs;
        dirs = getLineDirections(line);
        int[] runs;
        runs = dirs.mDirections;
        int lineStart;
        lineStart = getLineStart(line);
        int lineEnd;
        lineEnd = getLineEnd(line);
        {
            int paraLevel;
            boolean varEEB6B6B705B0C78401688F613A79E083_1946026408 = (getParagraphDirection(line) == 1);
            paraLevel = 0;
            paraLevel = 1;
            int runIndex;
            runIndex = 0;
            runIndex = runs.length - 2;
        } //End block
        offset -= lineStart;
        {
            int i;
            i = 0;
            i += 2;
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int line = getLineForOffset(offset);
        //Directions dirs = getLineDirections(line);
        //if (dirs == DIRS_ALL_LEFT_TO_RIGHT || dirs == DIRS_ALL_RIGHT_TO_LEFT) {
            //return false;
        //}
        //int[] runs = dirs.mDirections;
        //int lineStart = getLineStart(line);
        //int lineEnd = getLineEnd(line);
        //if (offset == lineStart || offset == lineEnd) {
            //int paraLevel = getParagraphDirection(line) == 1 ? 0 : 1;
            //int runIndex = offset == lineStart ? 0 : runs.length - 2;
            //return ((runs[runIndex + 1] >>> RUN_LEVEL_SHIFT) & RUN_LEVEL_MASK) != paraLevel;
        //}
        //offset -= lineStart;
        //for (int i = 0; i < runs.length; i += 2) {
            //if (offset == runs[i]) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.110 -0400", hash_original_method = "AF5CCAD1718916CFF1EB4C8EF2E12FAE", hash_generated_method = "7622942D51D34B45F531CFBDD51BE695")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isRtlCharAt(int offset) {
        dsTaint.addTaint(offset);
        int line;
        line = getLineForOffset(offset);
        Directions dirs;
        dirs = getLineDirections(line);
        int[] runs;
        runs = dirs.mDirections;
        int lineStart;
        lineStart = getLineStart(line);
        {
            int i;
            i = 0;
            i += 2;
            {
                int start;
                start = lineStart + (runs[i] & RUN_LENGTH_MASK);
                {
                    int level;
                    level = (runs[i+1] >>> RUN_LEVEL_SHIFT) & RUN_LEVEL_MASK;
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int line = getLineForOffset(offset);
        //Directions dirs = getLineDirections(line);
        //if (dirs == DIRS_ALL_LEFT_TO_RIGHT) {
            //return false;
        //}
        //if (dirs == DIRS_ALL_RIGHT_TO_LEFT) {
            //return  true;
        //}
        //int[] runs = dirs.mDirections;
        //int lineStart = getLineStart(line);
        //for (int i = 0; i < runs.length; i += 2) {
            //int start = lineStart + (runs[i] & RUN_LENGTH_MASK);
            //if (offset >= start) {
                //int level = (runs[i+1] >>> RUN_LEVEL_SHIFT) & RUN_LEVEL_MASK;
                //return ((level & 1) != 0);
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.111 -0400", hash_original_method = "2802B19F8A9E2D0D463FD305FA66136A", hash_generated_method = "EBAEDAA6EA4B5A1AD1EA6D4558DCB93E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean primaryIsTrailingPrevious(int offset) {
        dsTaint.addTaint(offset);
        int line;
        line = getLineForOffset(offset);
        int lineStart;
        lineStart = getLineStart(line);
        int lineEnd;
        lineEnd = getLineEnd(line);
        int[] runs;
        runs = getLineDirections(line).mDirections;
        int levelAt;
        levelAt = -1;
        {
            int i;
            i = 0;
            i += 2;
            {
                int start;
                start = lineStart + runs[i];
                int limit;
                limit = start + (runs[i+1] & RUN_LENGTH_MASK);
                {
                    limit = lineEnd;
                } //End block
                {
                    levelAt = (runs[i+1] >>> RUN_LEVEL_SHIFT) & RUN_LEVEL_MASK;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            levelAt = getParagraphDirection(line) == 1 ? 0 : 1;
        } //End block
        int levelBefore;
        levelBefore = -1;
        {
            levelBefore = getParagraphDirection(line) == 1 ? 0 : 1;
        } //End block
        {
            offset -= 1;
            {
                int i;
                i = 0;
                i += 2;
                {
                    int start;
                    start = lineStart + runs[i];
                    int limit;
                    limit = start + (runs[i+1] & RUN_LENGTH_MASK);
                    {
                        limit = lineEnd;
                    } //End block
                    {
                        levelBefore = (runs[i+1] >>> RUN_LEVEL_SHIFT) & RUN_LEVEL_MASK;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.112 -0400", hash_original_method = "80ABC300097314837E01431F08FED39C", hash_generated_method = "5F9E09F298522B9186BF3E931691EA7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getPrimaryHorizontal(int offset) {
        dsTaint.addTaint(offset);
        boolean trailing;
        trailing = primaryIsTrailingPrevious(offset);
        float var58B325E5B7FB5DC54EFDE69C8EB888FB_175896672 = (getHorizontal(offset, trailing));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //boolean trailing = primaryIsTrailingPrevious(offset);
        //return getHorizontal(offset, trailing);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.112 -0400", hash_original_method = "5EA78F3566FFC0563802F8455C66332C", hash_generated_method = "9CD927AA26840862DAAB189ACBE45714")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getSecondaryHorizontal(int offset) {
        dsTaint.addTaint(offset);
        boolean trailing;
        trailing = primaryIsTrailingPrevious(offset);
        float var88A0B1B7EB4DA5EBC1FC42BFB863BDDB_562332782 = (getHorizontal(offset, !trailing));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //boolean trailing = primaryIsTrailingPrevious(offset);
        //return getHorizontal(offset, !trailing);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.112 -0400", hash_original_method = "A6F47D9472D86FF595A17085495F07A6", hash_generated_method = "BE6640B68CD0C64E1EBFEAC0B8FDC9A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float getHorizontal(int offset, boolean trailing) {
        dsTaint.addTaint(trailing);
        dsTaint.addTaint(offset);
        int line;
        line = getLineForOffset(offset);
        float varE96D4127286387DC83C70FBC1CFA8E14_638809842 = (getHorizontal(offset, trailing, line));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //int line = getLineForOffset(offset);
        //return getHorizontal(offset, trailing, line);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.113 -0400", hash_original_method = "B47A0ABADD57DE266AAF87A7E699E873", hash_generated_method = "DDFEF9E5FD2CDA0AA0E864C9534213F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float getHorizontal(int offset, boolean trailing, int line) {
        dsTaint.addTaint(trailing);
        dsTaint.addTaint(line);
        dsTaint.addTaint(offset);
        int start;
        start = getLineStart(line);
        int end;
        end = getLineEnd(line);
        int dir;
        dir = getParagraphDirection(line);
        boolean hasTabOrEmoji;
        hasTabOrEmoji = getLineContainsTab(line);
        Directions directions;
        directions = getLineDirections(line);
        TabStops tabStops;
        tabStops = null;
        {
            TabStopSpan[] tabs;
            tabs = getParagraphSpans((Spanned) mText, start, end, TabStopSpan.class);
            {
                tabStops = new TabStops(TAB_INCREMENT, tabs);
            } //End block
        } //End block
        TextLine tl;
        tl = TextLine.obtain();
        tl.set(mPaint, mText, start, end, dir, directions, hasTabOrEmoji, tabStops);
        float wid;
        wid = tl.measure(offset - start, trailing, null);
        TextLine.recycle(tl);
        int left;
        left = getParagraphLeft(line);
        int right;
        right = getParagraphRight(line);
        float var4B4FA8270CE482A0F053465908FBE10D_49404180 = (getLineStartPos(line, left, right) + wid);
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.114 -0400", hash_original_method = "185391EA60FA7533A9126C3E791BF275", hash_generated_method = "8E7D534CD7FBF9D13CB8EC11792E5842")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getLineLeft(int line) {
        dsTaint.addTaint(line);
        int dir;
        dir = getParagraphDirection(line);
        Alignment align;
        align = getParagraphAlignment(line);
        {
            float var98F794A324A0919CA2BAAE75E672BC61_1041039846 = (getParagraphRight(line) - getLineMax(line));
        } //End block
        {
            float varB6842D18BAF51681C1C350FBC007B514_763358498 = (mWidth - getLineMax(line));
        } //End block
        {
            float varB6842D18BAF51681C1C350FBC007B514_1262773489 = (mWidth - getLineMax(line));
        } //End block
        {
            int left;
            left = getParagraphLeft(line);
            int right;
            right = getParagraphRight(line);
            int max;
            max = ((int) getLineMax(line)) & ~1;
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.114 -0400", hash_original_method = "D344E3703EA76C4344B547792AB00F8E", hash_generated_method = "4B3349C547497FBA3A251D029ADF7964")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getLineRight(int line) {
        dsTaint.addTaint(line);
        int dir;
        dir = getParagraphDirection(line);
        Alignment align;
        align = getParagraphAlignment(line);
        {
            float varC6136DD4ADABC05AB18240388355DC3F_2030433907 = (getParagraphLeft(line) + getLineMax(line));
        } //End block
        {
            float varC6136DD4ADABC05AB18240388355DC3F_505169160 = (getParagraphLeft(line) + getLineMax(line));
        } //End block
        {
            float varDA3557094C6D55255BC5DF32F9EC5DA6_1597886578 = (getLineMax(line));
        } //End block
        {
            int left;
            left = getParagraphLeft(line);
            int right;
            right = getParagraphRight(line);
            int max;
            max = ((int) getLineMax(line)) & ~1;
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.115 -0400", hash_original_method = "F9A5FD2221E6CC8B07379CD2792C3C3D", hash_generated_method = "01A471290E47FD84A990F63D67A04752")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getLineMax(int line) {
        dsTaint.addTaint(line);
        float margin;
        margin = getParagraphLeadingMargin(line);
        float signedExtent;
        signedExtent = getLineExtent(line, false);
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //float margin = getParagraphLeadingMargin(line);
        //float signedExtent = getLineExtent(line, false);
        //return margin + signedExtent >= 0 ? signedExtent : -signedExtent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.115 -0400", hash_original_method = "71AEB5E1BA96E910342AC0DBF85E1ED1", hash_generated_method = "7E2DF932BEC7AA965BD9D32D3E81E11D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getLineWidth(int line) {
        dsTaint.addTaint(line);
        float margin;
        margin = getParagraphLeadingMargin(line);
        float signedExtent;
        signedExtent = getLineExtent(line, true);
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //float margin = getParagraphLeadingMargin(line);
        //float signedExtent = getLineExtent(line, true);
        //return margin + signedExtent >= 0 ? signedExtent : -signedExtent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.116 -0400", hash_original_method = "22E5E0C81FE58627900045F7BF4DB10C", hash_generated_method = "1BFE77F2BC97FECBE7D0B8EB34CB0B48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float getLineExtent(int line, boolean full) {
        dsTaint.addTaint(full);
        dsTaint.addTaint(line);
        int start;
        start = getLineStart(line);
        int end;
        end = getLineEnd(line);
        end = getLineVisibleEnd(line);
        boolean hasTabsOrEmoji;
        hasTabsOrEmoji = getLineContainsTab(line);
        TabStops tabStops;
        tabStops = null;
        {
            TabStopSpan[] tabs;
            tabs = getParagraphSpans((Spanned) mText, start, end, TabStopSpan.class);
            {
                tabStops = new TabStops(TAB_INCREMENT, tabs);
            } //End block
        } //End block
        Directions directions;
        directions = getLineDirections(line);
        int dir;
        dir = getParagraphDirection(line);
        TextLine tl;
        tl = TextLine.obtain();
        tl.set(mPaint, mText, start, end, dir, directions, hasTabsOrEmoji, tabStops);
        float width;
        width = tl.metrics(null);
        TextLine.recycle(tl);
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.117 -0400", hash_original_method = "8D693BD7DA670D75D51405BA4AD1D35A", hash_generated_method = "1FA49699D2DAB1927403748488682994")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float getLineExtent(int line, TabStops tabStops, boolean full) {
        dsTaint.addTaint(tabStops.dsTaint);
        dsTaint.addTaint(full);
        dsTaint.addTaint(line);
        int start;
        start = getLineStart(line);
        int end;
        end = getLineEnd(line);
        end = getLineVisibleEnd(line);
        boolean hasTabsOrEmoji;
        hasTabsOrEmoji = getLineContainsTab(line);
        Directions directions;
        directions = getLineDirections(line);
        int dir;
        dir = getParagraphDirection(line);
        TextLine tl;
        tl = TextLine.obtain();
        tl.set(mPaint, mText, start, end, dir, directions, hasTabsOrEmoji, tabStops);
        float width;
        width = tl.metrics(null);
        TextLine.recycle(tl);
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //int start = getLineStart(line);
        //int end = full ? getLineEnd(line) : getLineVisibleEnd(line);
        //boolean hasTabsOrEmoji = getLineContainsTab(line);
        //Directions directions = getLineDirections(line);
        //int dir = getParagraphDirection(line);
        //TextLine tl = TextLine.obtain();
        //tl.set(mPaint, mText, start, end, dir, directions, hasTabsOrEmoji, tabStops);
        //float width = tl.metrics(null);
        //TextLine.recycle(tl);
        //return width;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.117 -0400", hash_original_method = "10EB5BCC671C8F4E5C56CFC3872691D1", hash_generated_method = "1E070EDE00C9DA928A0E5C30D9EDC63C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLineForVertical(int vertical) {
        dsTaint.addTaint(vertical);
        int high, low, guess;
        high = getLineCount();
        low = -1;
        {
            guess = (high + low) / 2;
            {
                boolean var61BBF3CF1E0BB57196057707E3B4D6BF_1429465487 = (getLineTop(guess) > vertical);
                high = guess;
                low = guess;
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int high = getLineCount(), low = -1, guess;
        //while (high - low > 1) {
            //guess = (high + low) / 2;
            //if (getLineTop(guess) > vertical)
                //high = guess;
            //else
                //low = guess;
        //}
        //if (low < 0)
            //return 0;
        //else
            //return low;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.118 -0400", hash_original_method = "42BF795D8C0B31EF6FC35C1F4CBE0EBA", hash_generated_method = "9B8ED02243D875B147E64DBAF0BF4FCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLineForOffset(int offset) {
        dsTaint.addTaint(offset);
        int high, low, guess;
        high = getLineCount();
        low = -1;
        {
            guess = (high + low) / 2;
            {
                boolean var3154698616D95C0A37FAB8F8A883C99B_587203653 = (getLineStart(guess) > offset);
                high = guess;
                low = guess;
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int high = getLineCount(), low = -1, guess;
        //while (high - low > 1) {
            //guess = (high + low) / 2;
            //if (getLineStart(guess) > offset)
                //high = guess;
            //else
                //low = guess;
        //}
        //if (low < 0)
            //return 0;
        //else
            //return low;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.119 -0400", hash_original_method = "C7C29A2E2D90FB22FF824A86EA8883C4", hash_generated_method = "191FAFDB043455649863716926474D31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getOffsetForHorizontal(int line, float horiz) {
        dsTaint.addTaint(horiz);
        dsTaint.addTaint(line);
        int max;
        max = getLineEnd(line) - 1;
        int min;
        min = getLineStart(line);
        Directions dirs;
        dirs = getLineDirections(line);
        {
            boolean varE1129FD6E3F799951EC526B3F962E39B_738150134 = (line == getLineCount() - 1);
        } //End collapsed parenthetic
        int best;
        best = min;
        float bestdist;
        bestdist = Math.abs(getPrimaryHorizontal(best) - horiz);
        {
            int i;
            i = 0;
            i += 2;
            {
                int here;
                here = min + dirs.mDirections[i];
                int there;
                there = here + (dirs.mDirections[i+1] & RUN_LENGTH_MASK);
                int swap;
                swap = -1;
                swap = 1;
                there = max;
                int high, low, guess;
                high = there - 1 + 1;
                low = here + 1 - 1;
                {
                    guess = (high + low) / 2;
                    int adguess;
                    adguess = getOffsetAtStartOf(guess);
                    {
                        boolean var598D8798A97CE595A660B245ECEF3FB1_2125380575 = (getPrimaryHorizontal(adguess) * swap >= horiz * swap);
                        high = guess;
                        low = guess;
                    } //End collapsed parenthetic
                } //End block
                low = here + 1;
                {
                    low = getOffsetAtStartOf(low);
                    float dist;
                    dist = Math.abs(getPrimaryHorizontal(low) - horiz);
                    int aft;
                    aft = TextUtils.getOffsetAfter(mText, low);
                    {
                        float other;
                        other = Math.abs(getPrimaryHorizontal(aft) - horiz);
                        {
                            dist = other;
                            low = aft;
                        } //End block
                    } //End block
                    {
                        bestdist = dist;
                        best = low;
                    } //End block
                } //End block
                float dist;
                dist = Math.abs(getPrimaryHorizontal(here) - horiz);
                {
                    bestdist = dist;
                    best = here;
                } //End block
            } //End block
        } //End collapsed parenthetic
        float dist;
        dist = Math.abs(getPrimaryHorizontal(max) - horiz);
        {
            bestdist = dist;
            best = max;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.120 -0400", hash_original_method = "AEF50F2FA9A7358F560FC7521C77962F", hash_generated_method = "0EF68F7D5B3EF24009A7D2F2D415AC36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getLineEnd(int line) {
        dsTaint.addTaint(line);
        int var8CC52E19BC990AEB0402BCF31B3C0E24_653378785 = (getLineStart(line + 1));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getLineStart(line + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.120 -0400", hash_original_method = "A5D943CCC73667A904F00DFE82793835", hash_generated_method = "BC304AAF16FEC6B275F71A72F7C8D871")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLineVisibleEnd(int line) {
        dsTaint.addTaint(line);
        int var62428E356DD4C198AB8841D5C8B61434_1543041869 = (getLineVisibleEnd(line, getLineStart(line), getLineStart(line+1)));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getLineVisibleEnd(line, getLineStart(line), getLineStart(line+1));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.121 -0400", hash_original_method = "2B63DEF38DAE998AFE5301FAAC214E4B", hash_generated_method = "1605C4E7A4C9F9015D5F679A9D890B01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getLineVisibleEnd(int line, int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(line);
        dsTaint.addTaint(end);
        CharSequence text;
        text = mText;
        char ch;
        {
            boolean varE1129FD6E3F799951EC526B3F962E39B_1082345830 = (line == getLineCount() - 1);
        } //End collapsed parenthetic
        {
            ch = text.charAt(end - 1);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //CharSequence text = mText;
        //char ch;
        //if (line == getLineCount() - 1) {
            //return end;
        //}
        //for (; end > start; end--) {
            //ch = text.charAt(end - 1);
            //if (ch == '\n') {
                //return end - 1;
            //}
            //if (ch != ' ' && ch != '\t') {
                //break;
            //}
        //}
        //return end;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.121 -0400", hash_original_method = "230C56044F8D52E3D0BA17DE5C72A914", hash_generated_method = "3F2CD7E4D4FF6F05D3554C43EB5D81B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getLineBottom(int line) {
        dsTaint.addTaint(line);
        int var87591D8CFD866D80B89A94BD35FF5C53_1338884961 = (getLineTop(line + 1));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getLineTop(line + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.121 -0400", hash_original_method = "BC6E93964E3CCD0D48881D9F9ABB9170", hash_generated_method = "89579A72359C6566E202C36E3E5392B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getLineBaseline(int line) {
        dsTaint.addTaint(line);
        int varF759BC48D9E18C48A2D84A1D35A4C202_2081851815 = (getLineTop(line+1) - getLineDescent(line));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getLineTop(line+1) - getLineDescent(line);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.121 -0400", hash_original_method = "577197C969745092B110831C30EF14E9", hash_generated_method = "FE210EF452C536C4A18FEE6CF263C578")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getLineAscent(int line) {
        dsTaint.addTaint(line);
        int var77CECF3AA081362BA73A6FE592826DBA_1827187317 = (getLineTop(line) - (getLineTop(line+1) - getLineDescent(line)));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getLineTop(line) - (getLineTop(line+1) - getLineDescent(line));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.122 -0400", hash_original_method = "AA9B5ECC044BD491182BF4F86B4B2DB2", hash_generated_method = "7319052CCBDBF984328D212132FD0565")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getOffsetToLeftOf(int offset) {
        dsTaint.addTaint(offset);
        int var277357E3410E8D01615B66CFEDE5D6BD_660239155 = (getOffsetToLeftRightOf(offset, true));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getOffsetToLeftRightOf(offset, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.122 -0400", hash_original_method = "684E6D0185E1F1B7C4ABCAB8ADBE45B0", hash_generated_method = "07CA1E13F617B735129C2D3DA5EA5239")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getOffsetToRightOf(int offset) {
        dsTaint.addTaint(offset);
        int var8F86D7AF4916F278DC98BA8E19B1D241_2003792298 = (getOffsetToLeftRightOf(offset, false));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getOffsetToLeftRightOf(offset, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.122 -0400", hash_original_method = "0024CF60F9AAE9E8C390E55EB92D8B7D", hash_generated_method = "58E6F77D068FF463C1B6E880C6FA1E77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getOffsetToLeftRightOf(int caret, boolean toLeft) {
        dsTaint.addTaint(caret);
        dsTaint.addTaint(toLeft);
        int line;
        line = getLineForOffset(caret);
        int lineStart;
        lineStart = getLineStart(line);
        int lineEnd;
        lineEnd = getLineEnd(line);
        int lineDir;
        lineDir = getParagraphDirection(line);
        boolean lineChanged;
        lineChanged = false;
        boolean advance;
        advance = toLeft == (lineDir == DIR_RIGHT_TO_LEFT);
        {
            {
                {
                    boolean var355D79A48691714F7AD418B6FB65073C_1787132474 = (line < getLineCount() - 1);
                    {
                        lineChanged = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    lineChanged = true;
                } //End block
            } //End block
        } //End block
        {
            lineStart = getLineStart(line);
            lineEnd = getLineEnd(line);
            int newDir;
            newDir = getParagraphDirection(line);
            {
                toLeft = !toLeft;
                lineDir = newDir;
            } //End block
        } //End block
        Directions directions;
        directions = getLineDirections(line);
        TextLine tl;
        tl = TextLine.obtain();
        tl.set(mPaint, mText, lineStart, lineEnd, lineDir, directions, false, null);
        caret = lineStart + tl.getOffsetToLeftRightOf(caret - lineStart, toLeft);
        tl = TextLine.recycle(tl);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.123 -0400", hash_original_method = "F9D5E8173F5C3CA491A1C8A8AE760B93", hash_generated_method = "A16E2CA5AD935011FDAFE3BF4E6AD902")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getOffsetAtStartOf(int offset) {
        dsTaint.addTaint(offset);
        CharSequence text;
        text = mText;
        char c;
        c = text.charAt(offset);
        {
            char c1;
            c1 = text.charAt(offset - 1);
            offset -= 1;
        } //End block
        {
            ReplacementSpan[] spans;
            spans = ((Spanned) text).getSpans(offset, offset,
                                                       ReplacementSpan.class);
            {
                int i;
                i = 0;
                {
                    int start;
                    start = ((Spanned) text).getSpanStart(spans[i]);
                    int end;
                    end = ((Spanned) text).getSpanEnd(spans[i]);
                    offset = start;
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (offset == 0)
            //return 0;
        //CharSequence text = mText;
        //char c = text.charAt(offset);
        //if (c >= '\uDC00' && c <= '\uDFFF') {
            //char c1 = text.charAt(offset - 1);
            //if (c1 >= '\uD800' && c1 <= '\uDBFF')
                //offset -= 1;
        //}
        //if (mSpannedText) {
            //ReplacementSpan[] spans = ((Spanned) text).getSpans(offset, offset,
                                                       //ReplacementSpan.class);
            //for (int i = 0; i < spans.length; i++) {
                //int start = ((Spanned) text).getSpanStart(spans[i]);
                //int end = ((Spanned) text).getSpanEnd(spans[i]);
                //if (start < offset && end > offset)
                    //offset = start;
            //}
        //}
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.124 -0400", hash_original_method = "B9C7ED4514D9377B34881167E2C24E2C", hash_generated_method = "B7789143B90E7F2B66F231F13FF0C4AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getCursorPath(int point, Path dest,
                              CharSequence editingBuffer) {
        dsTaint.addTaint(point);
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(editingBuffer);
        dest.reset();
        int line;
        line = getLineForOffset(point);
        int top;
        top = getLineTop(line);
        int bottom;
        bottom = getLineTop(line+1);
        float h1;
        h1 = getPrimaryHorizontal(point) - 0.5f;
        float h2;
        boolean var35ABFB89C4D7CB3AAB07DF4BC2B8B7DB_1031263352 = (isLevelBoundary(point));
        h2 = getSecondaryHorizontal(point) - 0.5f;
        h2 = h1;
        int caps;
        caps = TextKeyListener.getMetaState(editingBuffer, TextKeyListener.META_SHIFT_ON) |
                   TextKeyListener.getMetaState(editingBuffer, TextKeyListener.META_SELECTING);
        int fn;
        fn = TextKeyListener.getMetaState(editingBuffer, TextKeyListener.META_ALT_ON);
        int dist;
        dist = 0;
        {
            dist = (bottom - top) >> 2;
            top += dist;
            bottom -= dist;
        } //End block
        h1 = 0.5f;
        h2 = 0.5f;
        {
            boolean varB967F472C1B8F55EC25126285D862C13_1411797861 = (Float.compare(h1, h2) == 0);
            {
                dest.moveTo(h1, top);
                dest.lineTo(h1, bottom);
            } //End block
            {
                dest.moveTo(h1, top);
                dest.lineTo(h1, (top + bottom) >> 1);
                dest.moveTo(h2, (top + bottom) >> 1);
                dest.lineTo(h2, bottom);
            } //End block
        } //End collapsed parenthetic
        {
            dest.moveTo(h2, bottom);
            dest.lineTo(h2 - dist, bottom + dist);
            dest.lineTo(h2, bottom);
            dest.lineTo(h2 + dist, bottom + dist);
        } //End block
        {
            dest.moveTo(h2, bottom);
            dest.lineTo(h2 - dist, bottom + dist);
            dest.moveTo(h2 - dist, bottom + dist - 0.5f);
            dest.lineTo(h2 + dist, bottom + dist - 0.5f);
            dest.moveTo(h2 + dist, bottom + dist);
            dest.lineTo(h2, bottom);
        } //End block
        {
            dest.moveTo(h1, top);
            dest.lineTo(h1 - dist, top - dist);
            dest.lineTo(h1, top);
            dest.lineTo(h1 + dist, top - dist);
        } //End block
        {
            dest.moveTo(h1, top);
            dest.lineTo(h1 - dist, top - dist);
            dest.moveTo(h1 - dist, top - dist + 0.5f);
            dest.lineTo(h1 + dist, top - dist + 0.5f);
            dest.moveTo(h1 + dist, top - dist);
            dest.lineTo(h1, top);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.131 -0400", hash_original_method = "12119B0793FEC64A3F791B69831CA1AC", hash_generated_method = "0747DEE1D7B6DCADA8955E1E5CDA6E7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addSelection(int line, int start, int end,
                              int top, int bottom, Path dest) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(line);
        dsTaint.addTaint(end);
        dsTaint.addTaint(top);
        int linestart;
        linestart = getLineStart(line);
        int lineend;
        lineend = getLineEnd(line);
        Directions dirs;
        dirs = getLineDirections(line);
        {
            boolean varB43E309FBAB2B8F1A4B7179F5EBC83BF_1378547223 = (lineend > linestart && mText.charAt(lineend - 1) == '\n');
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
            i += 2;
            {
                int here;
                here = linestart + dirs.mDirections[i];
                int there;
                there = here + (dirs.mDirections[i+1] & RUN_LENGTH_MASK);
                there = lineend;
                {
                    int st;
                    st = Math.max(start, here);
                    int en;
                    en = Math.min(end, there);
                    {
                        float h1;
                        h1 = getHorizontal(st, false, line);
                        float h2;
                        h2 = getHorizontal(en, true, line);
                        float left;
                        left = Math.min(h1, h2);
                        float right;
                        right = Math.max(h1, h2);
                        dest.addRect(left, top, right, bottom, Path.Direction.CW);
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.132 -0400", hash_original_method = "E504AED84523F80835FFB88244A923D5", hash_generated_method = "C150BC2CD73565A855B2D0DEEDB16BA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getSelectionPath(int start, int end, Path dest) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        dest.reset();
        {
            int temp;
            temp = end;
            end = start;
            start = temp;
        } //End block
        int startline;
        startline = getLineForOffset(start);
        int endline;
        endline = getLineForOffset(end);
        int top;
        top = getLineTop(startline);
        int bottom;
        bottom = getLineBottom(endline);
        {
            addSelection(startline, start, end, top, bottom, dest);
        } //End block
        {
            float width;
            width = mWidth;
            addSelection(startline, start, getLineEnd(startline),
                         top, getLineBottom(startline), dest);
            {
                boolean var641B20D73ACAC5B224EFAB6A2D83DEC5_1322458664 = (getParagraphDirection(startline) == DIR_RIGHT_TO_LEFT);
                dest.addRect(getLineLeft(startline), top,
                              0, getLineBottom(startline), Path.Direction.CW);
                dest.addRect(getLineRight(startline), top,
                              width, getLineBottom(startline), Path.Direction.CW);
            } //End collapsed parenthetic
            {
                int i;
                i = startline + 1;
                {
                    top = getLineTop(i);
                    bottom = getLineBottom(i);
                    dest.addRect(0, top, width, bottom, Path.Direction.CW);
                } //End block
            } //End collapsed parenthetic
            top = getLineTop(endline);
            bottom = getLineBottom(endline);
            addSelection(endline, getLineStart(endline), end,
                         top, bottom, dest);
            {
                boolean var2D05D65F6C53E0529A94B0C267529750_1380262190 = (getParagraphDirection(endline) == DIR_RIGHT_TO_LEFT);
                dest.addRect(width, top, getLineRight(endline), bottom, Path.Direction.CW);
                dest.addRect(0, top, getLineLeft(endline), bottom, Path.Direction.CW);
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.133 -0400", hash_original_method = "8E26BC9825AB85694FDEA00F755B3420", hash_generated_method = "8EA145FBB7B8DA95E8FC4168DF91CB75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Alignment getParagraphAlignment(int line) {
        dsTaint.addTaint(line);
        Alignment align;
        align = mAlignment;
        {
            Spanned sp;
            sp = (Spanned) mText;
            AlignmentSpan[] spans;
            spans = getParagraphSpans(sp, getLineStart(line),
                                                getLineEnd(line),
                                                AlignmentSpan.class);
            int spanLength;
            spanLength = spans.length;
            {
                align = spans[spanLength-1].getAlignment();
            } //End block
        } //End block
        return (Alignment)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Alignment align = mAlignment;
        //if (mSpannedText) {
            //Spanned sp = (Spanned) mText;
            //AlignmentSpan[] spans = getParagraphSpans(sp, getLineStart(line),
                                                //getLineEnd(line),
                                                //AlignmentSpan.class);
            //int spanLength = spans.length;
            //if (spanLength > 0) {
                //align = spans[spanLength-1].getAlignment();
            //}
        //}
        //return align;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.133 -0400", hash_original_method = "D8249C79FD486A8037899C5A02304321", hash_generated_method = "47E94BC343B888E832A7E1E8188841DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getParagraphLeft(int line) {
        dsTaint.addTaint(line);
        int left;
        left = 0;
        int dir;
        dir = getParagraphDirection(line);
        int var2A867EA544174101A4992A444C3E4549_101726180 = (getParagraphLeadingMargin(line));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int left = 0;
        //int dir = getParagraphDirection(line);
        //if (dir == DIR_RIGHT_TO_LEFT || !mSpannedText) {
            //return left; 
        //}
        //return getParagraphLeadingMargin(line);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.134 -0400", hash_original_method = "4AFE65CA85EFF9BA5DD1726E8E021AC9", hash_generated_method = "5974CB44C1183174ADEEE207B3D7C1B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getParagraphRight(int line) {
        dsTaint.addTaint(line);
        int right;
        right = mWidth;
        int dir;
        dir = getParagraphDirection(line);
        int varFDCC0DBACB708D752171E60779D4D664_1406073893 = (right - getParagraphLeadingMargin(line));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int right = mWidth;
        //int dir = getParagraphDirection(line);
        //if (dir == DIR_LEFT_TO_RIGHT || !mSpannedText) {
            //return right; 
        //}
        //return right - getParagraphLeadingMargin(line);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.134 -0400", hash_original_method = "E5BF73D13B43F74BA21E795D809567BE", hash_generated_method = "0D81A6930EF66D288E67AE761F260DA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getParagraphLeadingMargin(int line) {
        dsTaint.addTaint(line);
        Spanned spanned;
        spanned = (Spanned) mText;
        int lineStart;
        lineStart = getLineStart(line);
        int lineEnd;
        lineEnd = getLineEnd(line);
        int spanEnd;
        spanEnd = spanned.nextSpanTransition(lineStart, lineEnd,
                LeadingMarginSpan.class);
        LeadingMarginSpan[] spans;
        spans = getParagraphSpans(spanned, lineStart, spanEnd,
                                                LeadingMarginSpan.class);
        int margin;
        margin = 0;
        boolean isFirstParaLine;
        isFirstParaLine = lineStart == 0 ||
            spanned.charAt(lineStart - 1) == '\n';
        {
            int i;
            i = 0;
            {
                LeadingMarginSpan span;
                span = spans[i];
                boolean useFirstLineMargin;
                useFirstLineMargin = isFirstParaLine;
                {
                    int spStart;
                    spStart = spanned.getSpanStart(span);
                    int spanLine;
                    spanLine = getLineForOffset(spStart);
                    int count;
                    count = ((LeadingMarginSpan2)span).getLeadingMarginLineCount();
                    useFirstLineMargin = line < spanLine + count;
                } //End block
                margin += span.getLeadingMargin(useFirstLineMargin);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        static float measurePara(TextPaint paint, TextPaint workPaint,
            CharSequence text, int start, int end) {
        MeasuredText mt = MeasuredText.obtain();
        TextLine tl = TextLine.obtain();
        try {
            mt.setPara(text, start, end, TextDirectionHeuristics.LTR);
            Directions directions;
            int dir;
            if (mt.mEasy) {
                directions = DIRS_ALL_LEFT_TO_RIGHT;
                dir = Layout.DIR_LEFT_TO_RIGHT;
            } else {
                directions = AndroidBidi.directions(mt.mDir, mt.mLevels,
                    0, mt.mChars, 0, mt.mLen);
                dir = mt.mDir;
            }
            char[] chars = mt.mChars;
            int len = mt.mLen;
            boolean hasTabs = false;
            TabStops tabStops = null;
            for (int i = 0; i < len; ++i) {
                if (chars[i] == '\t') {
                    hasTabs = true;
                    if (text instanceof Spanned) {
                        Spanned spanned = (Spanned) text;
                        int spanEnd = spanned.nextSpanTransition(start, end,
                                TabStopSpan.class);
                        TabStopSpan[] spans = getParagraphSpans(spanned, start, spanEnd,
                                TabStopSpan.class);
                        if (spans.length > 0) {
                            tabStops = new TabStops(TAB_INCREMENT, spans);
                        }
                    }
                    break;
                }
            }
            tl.set(paint, text, start, end, dir, directions, hasTabs, tabStops);
            return tl.metrics(null);
        } finally {
            TextLine.recycle(tl);
            MeasuredText.recycle(mt);
        }
    }

    
        static float nextTab(CharSequence text, int start, int end,
                                       float h, Object[] tabs) {
        float nh = Float.MAX_VALUE;
        boolean alltabs = false;
        if (text instanceof Spanned) {
            if (tabs == null) {
                tabs = getParagraphSpans((Spanned) text, start, end, TabStopSpan.class);
                alltabs = true;
            }
            for (int i = 0; i < tabs.length; i++) {
                if (!alltabs) {
                    if (!(tabs[i] instanceof TabStopSpan))
                        continue;
                }
                int where = ((TabStopSpan) tabs[i]).getTabStop();
                if (where < nh && where > h)
                    nh = where;
            }
            if (nh != Float.MAX_VALUE)
                return nh;
        }
        return ((int) ((h + TAB_INCREMENT) / TAB_INCREMENT)) * TAB_INCREMENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.135 -0400", hash_original_method = "CAFF1C73D2C9EA6C410B2B2D519C8AC7", hash_generated_method = "212C676547C367A991F8474C00BBAF37")
    @DSModeled(DSC.SAFE)
    protected final boolean isSpanned() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSpannedText;
    }

    
        static <T> T[] getParagraphSpans(Spanned text, int start, int end, Class<T> type) {
        if (start == end && start > 0) {
            return (T[]) ArrayUtils.emptyArray(type);
        }
        return text.getSpans(start, end, type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.136 -0400", hash_original_method = "0902B773EC3014719EA37A51347EC9C6", hash_generated_method = "0E02E1F813D0646F77119D94B8A0F1DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void ellipsize(int start, int end, int line,
                           char[] dest, int destoff) {
        dsTaint.addTaint(dest[0]);
        dsTaint.addTaint(start);
        dsTaint.addTaint(destoff);
        dsTaint.addTaint(line);
        dsTaint.addTaint(end);
        int ellipsisCount;
        ellipsisCount = getEllipsisCount(line);
        int ellipsisStart;
        ellipsisStart = getEllipsisStart(line);
        int linestart;
        linestart = getLineStart(line);
        {
            int i;
            i = ellipsisStart;
            {
                char c;
                {
                    c = '\u2026';
                } //End block
                {
                    c = '\uFEFF';
                } //End block
                int a;
                a = i + linestart;
                {
                    dest[destoff + a - start] = c;
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int ellipsisCount = getEllipsisCount(line);
        //if (ellipsisCount == 0) {
            //return;
        //}
        //int ellipsisStart = getEllipsisStart(line);
        //int linestart = getLineStart(line);
        //for (int i = ellipsisStart; i < ellipsisStart + ellipsisCount; i++) {
            //char c;
            //if (i == ellipsisStart) {
                //c = '\u2026'; 
            //} else {
                //c = '\uFEFF'; 
            //}
            //int a = i + linestart;
            //if (a >= start && a < end) {
                //dest[destoff + a - start] = c;
            //}
        //}
    }

    
    public abstract int getEllipsisStart(int line);

    
    public abstract int getEllipsisCount(int line);

    
    static class TabStops {
        private int[] mStops;
        private int mNumStops;
        private int mIncrement;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.137 -0400", hash_original_method = "56D1FFBFF7D6B6649609A0E9FF6888AB", hash_generated_method = "C9FD9F9513E218A163D979D0B5936DBE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         TabStops(int increment, Object[] spans) {
            dsTaint.addTaint(increment);
            dsTaint.addTaint(spans[0].dsTaint);
            reset(increment, spans);
            // ---------- Original Method ----------
            //reset(increment, spans);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.145 -0400", hash_original_method = "12BC3A9AA4E5F32DB7C736F6D72E4602", hash_generated_method = "3CDD47F2F15EA9C9B97270E4C64A7718")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void reset(int increment, Object[] spans) {
            dsTaint.addTaint(increment);
            dsTaint.addTaint(spans[0].dsTaint);
            int ns;
            ns = 0;
            {
                int[] stops;
                stops = this.mStops;
                {
                    Object o = spans[0];
                    {
                        {
                            {
                                stops = new int[10];
                            } //End block
                            {
                                int[] nstops;
                                nstops = new int[ns * 2];
                                {
                                    int i;
                                    i = 0;
                                    {
                                        nstops[i] = stops[i];
                                    } //End block
                                } //End collapsed parenthetic
                                stops = nstops;
                            } //End block
                            stops[ns++] = ((TabStopSpan) o).getTabStop();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                {
                    Arrays.sort(stops, 0, ns);
                } //End block
                {
                    this.mStops = stops;
                } //End block
            } //End block
            this.mNumStops = ns;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.146 -0400", hash_original_method = "A46080BC8F3B4D3099E262DAA9B4728B", hash_generated_method = "D0D4598FEAFD92BE1BF0E5FBA486A14E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         float nextTab(float h) {
            dsTaint.addTaint(h);
            int ns;
            ns = this.mNumStops;
            {
                int[] stops;
                stops = this.mStops;
                {
                    int i;
                    i = 0;
                    {
                        int stop;
                        stop = stops[i];
                    } //End block
                } //End collapsed parenthetic
            } //End block
            float varA772933572361B833B090C93A4B38B40_1966483032 = (nextDefaultStop(h, mIncrement));
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //int ns = this.mNumStops;
            //if (ns > 0) {
                //int[] stops = this.mStops;
                //for (int i = 0; i < ns; ++i) {
                    //int stop = stops[i];
                    //if (stop > h) {
                        //return stop;
                    //}
                //}
            //}
            //return nextDefaultStop(h, mIncrement);
        }

        
                public static float nextDefaultStop(float h, int inc) {
            return ((int) ((h + inc) / inc)) * inc;
        }

        
    }


    
    public static class Directions {
        int[] mDirections;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.146 -0400", hash_original_method = "DA94802578AA1A107A88665DAAC4811A", hash_generated_method = "0B77294812F3426DFE2E220A0DAE838E")
        @DSModeled(DSC.SAFE)
         Directions(int[] dirs) {
            dsTaint.addTaint(dirs[0]);
            // ---------- Original Method ----------
            //mDirections = dirs;
        }

        
    }


    
    static class Ellipsizer implements CharSequence, GetChars {
        CharSequence mText;
        Layout mLayout;
        int mWidth;
        TextUtils.TruncateAt mMethod;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.147 -0400", hash_original_method = "991CD3860414493D5159CDEA8946E94D", hash_generated_method = "6A6D1284088C04BEB33D11E0E28BD26C")
        @DSModeled(DSC.SAFE)
        public Ellipsizer(CharSequence s) {
            dsTaint.addTaint(s);
            // ---------- Original Method ----------
            //mText = s;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.147 -0400", hash_original_method = "D253D2AD2D0DACD122596323ACBBAF25", hash_generated_method = "105BFFDF9E7A0EDE223A6ED138782272")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public char charAt(int off) {
            dsTaint.addTaint(off);
            char[] buf;
            buf = TextUtils.obtain(1);
            getChars(off, off + 1, buf, 0);
            char ret;
            ret = buf[0];
            TextUtils.recycle(buf);
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //char[] buf = TextUtils.obtain(1);
            //getChars(off, off + 1, buf, 0);
            //char ret = buf[0];
            //TextUtils.recycle(buf);
            //return ret;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.147 -0400", hash_original_method = "F2DBD2F3D78F3955B1714BB078A793F8", hash_generated_method = "8C744695643D7ED53FB7E0598FE14D5A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void getChars(int start, int end, char[] dest, int destoff) {
            dsTaint.addTaint(dest[0]);
            dsTaint.addTaint(start);
            dsTaint.addTaint(destoff);
            dsTaint.addTaint(end);
            int line1;
            line1 = mLayout.getLineForOffset(start);
            int line2;
            line2 = mLayout.getLineForOffset(end);
            TextUtils.getChars(mText, start, end, dest, destoff);
            {
                int i;
                i = line1;
                {
                    mLayout.ellipsize(start, end, i, dest, destoff);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //int line1 = mLayout.getLineForOffset(start);
            //int line2 = mLayout.getLineForOffset(end);
            //TextUtils.getChars(mText, start, end, dest, destoff);
            //for (int i = line1; i <= line2; i++) {
                //mLayout.ellipsize(start, end, i, dest, destoff);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.148 -0400", hash_original_method = "9A68249D01A4FE1CBD4D535668FCEB6F", hash_generated_method = "960C05FC371EB3AF46CE7AF73B5F3F11")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int length() {
            int varE8711A0ED7EDCE918346EA0F2DE620ED_19776007 = (mText.length());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mText.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.148 -0400", hash_original_method = "019151395F1B77A008AA178A5A5CA402", hash_generated_method = "EF286EC54101F3FA7ABE8401039D5B82")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CharSequence subSequence(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            char[] s;
            s = new char[end - start];
            getChars(start, end, s, 0);
            CharSequence var76BF35DD9309BFD9AD6D4B6E43C697C9_838651778 = (new String(s));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //char[] s = new char[end - start];
            //getChars(start, end, s, 0);
            //return new String(s);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.148 -0400", hash_original_method = "8ED281151745D3FC40324C23FDF16D10", hash_generated_method = "D8D6B9F9E22624AD9DD5AD34B3BF7017")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            char[] s;
            s = new char[length()];
            getChars(0, length(), s, 0);
            String var76BF35DD9309BFD9AD6D4B6E43C697C9_1375205854 = (new String(s));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //char[] s = new char[length()];
            //getChars(0, length(), s, 0);
            //return new String(s);
        }

        
    }


    
    static class SpannedEllipsizer extends Ellipsizer implements Spanned {
        private Spanned mSpanned;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.148 -0400", hash_original_method = "F42AC9AEDB79FF2719E5DE12CF0CD85E", hash_generated_method = "03502F04DDBBB029D2322D8B001598F6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SpannedEllipsizer(CharSequence display) {
            super(display);
            dsTaint.addTaint(display);
            mSpanned = (Spanned) display;
            // ---------- Original Method ----------
            //mSpanned = (Spanned) display;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.149 -0400", hash_original_method = "E8AB479016A2E00AFF48AA43F345FA2A", hash_generated_method = "78DE24120B2D6EC8C4099E4620310744")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> T[] getSpans(int start, int end, Class<T> type) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(type.dsTaint);
            dsTaint.addTaint(end);
            T[] varD7D8544F4A8114420D7401F18A483DF9_993551756 = (mSpanned.getSpans(start, end, type));
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mSpanned.getSpans(start, end, type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.149 -0400", hash_original_method = "2071284CDE64572D4D3F80F80EB4C823", hash_generated_method = "052867C35D1E5949A841CF20C4D43A5F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getSpanStart(Object tag) {
            dsTaint.addTaint(tag.dsTaint);
            int varD7924E7B7A12FA5A3B050A8325F5D9BE_1299943844 = (mSpanned.getSpanStart(tag));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mSpanned.getSpanStart(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.149 -0400", hash_original_method = "B1DC38D90632AE4EB220020E4C5B16DF", hash_generated_method = "40AC9920A6C0163FB7D5A89A02FC3C45")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getSpanEnd(Object tag) {
            dsTaint.addTaint(tag.dsTaint);
            int varFDD9D023F9FB8A63C470934B7C2E8224_1380094625 = (mSpanned.getSpanEnd(tag));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mSpanned.getSpanEnd(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.149 -0400", hash_original_method = "A386D5CC8A9C15386840381A75E4D6FD", hash_generated_method = "3258B97B7010A241BB2F47A9485D8787")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getSpanFlags(Object tag) {
            dsTaint.addTaint(tag.dsTaint);
            int var689A4E26E56E6EC55263E3776149ED4A_1610956583 = (mSpanned.getSpanFlags(tag));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mSpanned.getSpanFlags(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.150 -0400", hash_original_method = "AF35DA8DF947D9C1330368703ECE15BE", hash_generated_method = "6E97ABF794009E559255735CFE588F61")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int nextSpanTransition(int start, int limit, Class type) {
            dsTaint.addTaint(limit);
            dsTaint.addTaint(start);
            dsTaint.addTaint(type.dsTaint);
            int varF2EB81A12DD76D71166CCB6A597BD229_1441504649 = (mSpanned.nextSpanTransition(start, limit, type));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mSpanned.nextSpanTransition(start, limit, type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.150 -0400", hash_original_method = "16B37527DFF576A9EB476E4EC2A69F5D", hash_generated_method = "D63646593A1663041A2CF69721674A0D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public CharSequence subSequence(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            char[] s;
            s = new char[end - start];
            getChars(start, end, s, 0);
            SpannableString ss;
            ss = new SpannableString(new String(s));
            TextUtils.copySpansFrom(mSpanned, start, end, Object.class, ss, 0);
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //char[] s = new char[end - start];
            //getChars(start, end, s, 0);
            //SpannableString ss = new SpannableString(new String(s));
            //TextUtils.copySpansFrom(mSpanned, start, end, Object.class, ss, 0);
            //return ss;
        }

        
    }


    
    public enum Alignment {
        ALIGN_NORMAL,
        ALIGN_OPPOSITE,
        ALIGN_CENTER,
        ALIGN_LEFT,
        ALIGN_RIGHT,
    }

    
    private static final ParagraphStyle[] NO_PARA_SPANS =
        ArrayUtils.emptyArray(ParagraphStyle.class);
    static final EmojiFactory EMOJI_FACTORY =
        EmojiFactory.newAvailableInstance();
    static final int MIN_EMOJI, MAX_EMOJI;
    static {
        if (EMOJI_FACTORY != null) {
            MIN_EMOJI = EMOJI_FACTORY.getMinimumAndroidPua();
            MAX_EMOJI = EMOJI_FACTORY.getMaximumAndroidPua();
        } else {
            MIN_EMOJI = -1;
            MAX_EMOJI = -1;
        }
    }
    
    private static final Rect sTempRect = new Rect();
    public static final int DIR_LEFT_TO_RIGHT = 1;
    public static final int DIR_RIGHT_TO_LEFT = -1;
    static final int DIR_REQUEST_LTR = 1;
    static final int DIR_REQUEST_RTL = -1;
    static final int DIR_REQUEST_DEFAULT_LTR = 2;
    static final int DIR_REQUEST_DEFAULT_RTL = -2;
    static final int RUN_LENGTH_MASK = 0x03ffffff;
    static final int RUN_LEVEL_SHIFT = 26;
    static final int RUN_LEVEL_MASK = 0x3f;
    static final int RUN_RTL_FLAG = 1 << RUN_LEVEL_SHIFT;
    private static final int TAB_INCREMENT = 20;
    static final Directions DIRS_ALL_LEFT_TO_RIGHT =
        new Directions(new int[] { 0, RUN_LENGTH_MASK });
    static final Directions DIRS_ALL_RIGHT_TO_LEFT =
        new Directions(new int[] { 0, RUN_LENGTH_MASK | RUN_RTL_FLAG });
}

