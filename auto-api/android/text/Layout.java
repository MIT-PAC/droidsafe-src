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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.045 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "E579ED9F2DADADEB46C981CAFDEE5BA5")

    private CharSequence mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.045 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "B5BC396C7010734D6B4B6ED34A2846AE")

    private TextPaint mPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.046 -0400", hash_original_field = "B3CE09DC80997D762CCFEE11916EE7B6", hash_generated_field = "B28AC88C47D899E85CEE0110DCCDCA16")

    TextPaint mWorkPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.046 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

    private int mWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.046 -0400", hash_original_field = "016218732B28025C6B752A3B2A457113", hash_generated_field = "A5FBEE576828FD767B418A1715D12197")

    private Alignment mAlignment = Alignment.ALIGN_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.046 -0400", hash_original_field = "DD430150592EA7FB656F57A5D9A5C479", hash_generated_field = "0C2C39C12F42C181B35D16CF7D81A703")

    private float mSpacingMult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.046 -0400", hash_original_field = "18DE4355EE7ABBEF3185EC1003DD341A", hash_generated_field = "733F92CD6EAB2F9CA67542D073A49D69")

    private float mSpacingAdd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.046 -0400", hash_original_field = "9AAB51E3E9F2DBF3923317511559B1D1", hash_generated_field = "9735AD2A3473CB2D7DEA16EAA46F6EFB")

    private boolean mSpannedText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.046 -0400", hash_original_field = "056B2B67A5D743296E35F6A88B022318", hash_generated_field = "720F1C3BB08BF46839EBBA716D35B07F")

    private TextDirectionHeuristic mTextDir;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.052 -0400", hash_original_method = "DA432A00E31F4EFC04FE32B9AEC1CEE4", hash_generated_method = "497D43F984F908C615AC7DDCD4AB47FF")
    protected  Layout(CharSequence text, TextPaint paint,
                     int width, Alignment align,
                     float spacingMult, float spacingAdd) {
        this(text, paint, width, align, TextDirectionHeuristics.FIRSTSTRONG_LTR,
                spacingMult, spacingAdd);
        addTaint(text.getTaint());
        addTaint(paint.getTaint());
        addTaint(width);
        addTaint(align.getTaint());
        addTaint(spacingMult);
        addTaint(spacingAdd);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.053 -0400", hash_original_method = "E08E539EEFF1AD274546B85662DC9DCC", hash_generated_method = "C73F246C622EAA9054FDA8F78297DAC1")
    protected  Layout(CharSequence text, TextPaint paint,
                     int width, Alignment align, TextDirectionHeuristic textDir,
                     float spacingMult, float spacingAdd) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Layout: " + width + " < 0");
        {
            paint.bgColor = 0;
            paint.baselineShift = 0;
        } //End block
        mText = text;
        mPaint = paint;
        mWorkPaint = new TextPaint();
        mWidth = width;
        mAlignment = align;
        mSpacingMult = spacingMult;
        mSpacingAdd = spacingAdd;
        mSpannedText = text instanceof Spanned;
        mTextDir = textDir;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.065 -0400", hash_original_method = "4BA809AE232557C36D4CE5AE6E36D4D2", hash_generated_method = "BBAF0084E8D40C760639B9BEAB427E56")
     void replaceWith(CharSequence text, TextPaint paint,
                              int width, Alignment align,
                              float spacingmult, float spacingadd) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Layout: " + width + " < 0");
        } //End block
        mText = text;
        mPaint = paint;
        mWidth = width;
        mAlignment = align;
        mSpacingMult = spacingmult;
        mSpacingAdd = spacingadd;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.079 -0400", hash_original_method = "21986991A7FC788A39082240DAE8B9C3", hash_generated_method = "A7DBF3BE15A320D6F69E02741972F077")
    public void draw(Canvas c) {
        draw(c, null, null, 0);
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //draw(c, null, null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.091 -0400", hash_original_method = "C63D8686FF6D60F338825542CA174C93", hash_generated_method = "77D1F7EC2FBE449CB1CC57A772E2262B")
    public void draw(Canvas c, Path highlight, Paint highlightPaint,
                     int cursorOffsetVertical) {
        int dtop, dbottom;
        {
            {
                boolean varC42A531B776DA8F33EFB072E74A6FC1E_708105544 = (!c.getClipBounds(sTempRect));
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
        addTaint(c.getTaint());
        addTaint(highlight.getTaint());
        addTaint(highlightPaint.getTaint());
        addTaint(cursorOffsetVertical);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.113 -0400", hash_original_method = "94C8B0A33C8A9972488E17891E7B8BAC", hash_generated_method = "8A6CB6887E2E43BC23CA05F2976ACF35")
    private int getLineStartPos(int line, int left, int right) {
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
                boolean varEBDDE922AE0589A6CEAD24B0AC5E6B48_1015277283 = (mSpannedText && getLineContainsTab(line));
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
        addTaint(line);
        addTaint(left);
        addTaint(right);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1696033964 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1696033964;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.114 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "FA49174AB863C4A7EC96564B2331E0AB")
    public final CharSequence getText() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1670858727 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1670858727 = mText;
        varB4EAC82CA7396A68D541C85D26508E83_1670858727.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1670858727;
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.115 -0400", hash_original_method = "7064C5093467A23605D5C425E4D25B83", hash_generated_method = "F424C742C0831659C47D4B582DC9CDB6")
    public final TextPaint getPaint() {
        TextPaint varB4EAC82CA7396A68D541C85D26508E83_153858853 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_153858853 = mPaint;
        varB4EAC82CA7396A68D541C85D26508E83_153858853.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_153858853;
        // ---------- Original Method ----------
        //return mPaint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.115 -0400", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "1D91A647FE2B3D447B0838F204FB604A")
    public final int getWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_333308209 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_333308209;
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.115 -0400", hash_original_method = "90F96A059D406483E44444E82D555D1F", hash_generated_method = "F7569E9289F8A6A10FAEA70E33BE0DAF")
    public int getEllipsizedWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2076436371 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2076436371;
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.120 -0400", hash_original_method = "461CE12B89AFCA61718D5C5F590357B0", hash_generated_method = "8CE222B19DC30D9434620F2E598C23A9")
    public final void increaseWidthTo(int wid) {
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("attempted to reduce Layout width");
        } //End block
        mWidth = wid;
        // ---------- Original Method ----------
        //if (wid < mWidth) {
            //throw new RuntimeException("attempted to reduce Layout width");
        //}
        //mWidth = wid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.120 -0400", hash_original_method = "5212B162F472F11B6A60B5BD891C860A", hash_generated_method = "051943CC483FEC3F42CEE4C454D76B0A")
    public int getHeight() {
        int var7ED7F6E2EB0B1BC7A56013BEE63A9A35_1292409702 = (getLineTop(getLineCount()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1649057957 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1649057957;
        // ---------- Original Method ----------
        //return getLineTop(getLineCount());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.138 -0400", hash_original_method = "FB2D4D43E3EFDD971010AB3AFA49B442", hash_generated_method = "C5797C89A4BC062F1ED2AF0F588BE548")
    public final Alignment getAlignment() {
        Alignment varB4EAC82CA7396A68D541C85D26508E83_1723759983 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1723759983 = mAlignment;
        varB4EAC82CA7396A68D541C85D26508E83_1723759983.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1723759983;
        // ---------- Original Method ----------
        //return mAlignment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.138 -0400", hash_original_method = "F861D6694D511E0A8AF4CE2A5552F333", hash_generated_method = "60C39C02EB05C8AAFDD26FFACC62F876")
    public final float getSpacingMultiplier() {
        float var546ADE640B6EDFBC8A086EF31347E768_894006154 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_894006154;
        // ---------- Original Method ----------
        //return mSpacingMult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.141 -0400", hash_original_method = "E15AF37508F3C3C8F31DF2917343152C", hash_generated_method = "34F5EB58E883C6565CD46976D6815001")
    public final float getSpacingAdd() {
        float var546ADE640B6EDFBC8A086EF31347E768_1951284776 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1951284776;
        // ---------- Original Method ----------
        //return mSpacingAdd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.143 -0400", hash_original_method = "CEF29A1F61D81E3972548E19A0D7158C", hash_generated_method = "080F43AC50B7A229B14B7037C4CDD444")
    public final TextDirectionHeuristic getTextDirectionHeuristic() {
        TextDirectionHeuristic varB4EAC82CA7396A68D541C85D26508E83_2036518321 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2036518321 = mTextDir;
        varB4EAC82CA7396A68D541C85D26508E83_2036518321.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2036518321;
        // ---------- Original Method ----------
        //return mTextDir;
    }

    
    public abstract int getLineCount();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.144 -0400", hash_original_method = "6295516BE4612811C14BD1DCED80BAB8", hash_generated_method = "BB4A344868FA3F6673842E38EB4DFC64")
    public int getLineBounds(int line, Rect bounds) {
        {
            bounds.left = 0;
            bounds.top = getLineTop(line);
            bounds.right = mWidth;
            bounds.bottom = getLineTop(line + 1);
        } //End block
        int var29FD769CAB68A42F60CF514C827201BE_948982357 = (getLineBaseline(line));
        addTaint(line);
        addTaint(bounds.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1385573005 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1385573005;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.160 -0400", hash_original_method = "2C3949CE81E6BE871356E85B216A576F", hash_generated_method = "ACE52BC018CAF4A7863171268F178A03")
    public boolean isLevelBoundary(int offset) {
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
            boolean varEEB6B6B705B0C78401688F613A79E083_795383976 = (getParagraphDirection(line) == 1);
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
        addTaint(offset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_426785361 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_426785361;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.176 -0400", hash_original_method = "AF5CCAD1718916CFF1EB4C8EF2E12FAE", hash_generated_method = "820C954EDEC2EFBD4F7C6552BC1484C4")
    public boolean isRtlCharAt(int offset) {
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
        addTaint(offset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2091224310 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2091224310;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.178 -0400", hash_original_method = "2802B19F8A9E2D0D463FD305FA66136A", hash_generated_method = "DC5679607D2E10953FD810D561906C55")
    private boolean primaryIsTrailingPrevious(int offset) {
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
        addTaint(offset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1215230376 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1215230376;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.185 -0400", hash_original_method = "80ABC300097314837E01431F08FED39C", hash_generated_method = "DF20A51A65E1A0879BF08CD91E7A8810")
    public float getPrimaryHorizontal(int offset) {
        boolean trailing;
        trailing = primaryIsTrailingPrevious(offset);
        float var58B325E5B7FB5DC54EFDE69C8EB888FB_1418454873 = (getHorizontal(offset, trailing));
        addTaint(offset);
        float var546ADE640B6EDFBC8A086EF31347E768_1242999558 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1242999558;
        // ---------- Original Method ----------
        //boolean trailing = primaryIsTrailingPrevious(offset);
        //return getHorizontal(offset, trailing);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.193 -0400", hash_original_method = "5EA78F3566FFC0563802F8455C66332C", hash_generated_method = "D4A6320BF65ABBCC7ADA7457FD63ACFF")
    public float getSecondaryHorizontal(int offset) {
        boolean trailing;
        trailing = primaryIsTrailingPrevious(offset);
        float var88A0B1B7EB4DA5EBC1FC42BFB863BDDB_1799609499 = (getHorizontal(offset, !trailing));
        addTaint(offset);
        float var546ADE640B6EDFBC8A086EF31347E768_1435050105 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1435050105;
        // ---------- Original Method ----------
        //boolean trailing = primaryIsTrailingPrevious(offset);
        //return getHorizontal(offset, !trailing);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.194 -0400", hash_original_method = "A6F47D9472D86FF595A17085495F07A6", hash_generated_method = "91BB7CD0A08A1A9DF638186AC3E7848E")
    private float getHorizontal(int offset, boolean trailing) {
        int line;
        line = getLineForOffset(offset);
        float varE96D4127286387DC83C70FBC1CFA8E14_1102741285 = (getHorizontal(offset, trailing, line));
        addTaint(offset);
        addTaint(trailing);
        float var546ADE640B6EDFBC8A086EF31347E768_669462039 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_669462039;
        // ---------- Original Method ----------
        //int line = getLineForOffset(offset);
        //return getHorizontal(offset, trailing, line);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.244 -0400", hash_original_method = "B47A0ABADD57DE266AAF87A7E699E873", hash_generated_method = "46CC64650FE3971DECAAF4E81D1439E0")
    private float getHorizontal(int offset, boolean trailing, int line) {
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
        float var4B4FA8270CE482A0F053465908FBE10D_1032134165 = (getLineStartPos(line, left, right) + wid);
        addTaint(offset);
        addTaint(trailing);
        addTaint(line);
        float var546ADE640B6EDFBC8A086EF31347E768_359608624 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_359608624;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.245 -0400", hash_original_method = "185391EA60FA7533A9126C3E791BF275", hash_generated_method = "74E20C64DE3760ED2523298568D383FA")
    public float getLineLeft(int line) {
        int dir;
        dir = getParagraphDirection(line);
        Alignment align;
        align = getParagraphAlignment(line);
        {
            float var98F794A324A0919CA2BAAE75E672BC61_264275657 = (getParagraphRight(line) - getLineMax(line));
        } //End block
        {
            float varB6842D18BAF51681C1C350FBC007B514_1807115795 = (mWidth - getLineMax(line));
        } //End block
        {
            float varB6842D18BAF51681C1C350FBC007B514_1170317156 = (mWidth - getLineMax(line));
        } //End block
        {
            int left;
            left = getParagraphLeft(line);
            int right;
            right = getParagraphRight(line);
            int max;
            max = ((int) getLineMax(line)) & ~1;
        } //End block
        addTaint(line);
        float var546ADE640B6EDFBC8A086EF31347E768_1477866381 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1477866381;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.246 -0400", hash_original_method = "D344E3703EA76C4344B547792AB00F8E", hash_generated_method = "B1C22265E94817850999ACACCA51BC3E")
    public float getLineRight(int line) {
        int dir;
        dir = getParagraphDirection(line);
        Alignment align;
        align = getParagraphAlignment(line);
        {
            float varC6136DD4ADABC05AB18240388355DC3F_77661971 = (getParagraphLeft(line) + getLineMax(line));
        } //End block
        {
            float varC6136DD4ADABC05AB18240388355DC3F_1892273471 = (getParagraphLeft(line) + getLineMax(line));
        } //End block
        {
            float varDA3557094C6D55255BC5DF32F9EC5DA6_619064317 = (getLineMax(line));
        } //End block
        {
            int left;
            left = getParagraphLeft(line);
            int right;
            right = getParagraphRight(line);
            int max;
            max = ((int) getLineMax(line)) & ~1;
        } //End block
        addTaint(line);
        float var546ADE640B6EDFBC8A086EF31347E768_407317138 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_407317138;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.247 -0400", hash_original_method = "F9A5FD2221E6CC8B07379CD2792C3C3D", hash_generated_method = "743D56C338E356EBF6D72956148A8FA7")
    public float getLineMax(int line) {
        float margin;
        margin = getParagraphLeadingMargin(line);
        float signedExtent;
        signedExtent = getLineExtent(line, false);
        addTaint(line);
        float var546ADE640B6EDFBC8A086EF31347E768_1140376952 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1140376952;
        // ---------- Original Method ----------
        //float margin = getParagraphLeadingMargin(line);
        //float signedExtent = getLineExtent(line, false);
        //return margin + signedExtent >= 0 ? signedExtent : -signedExtent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.247 -0400", hash_original_method = "71AEB5E1BA96E910342AC0DBF85E1ED1", hash_generated_method = "828D70C6991AF8448D5D502F3F7C8490")
    public float getLineWidth(int line) {
        float margin;
        margin = getParagraphLeadingMargin(line);
        float signedExtent;
        signedExtent = getLineExtent(line, true);
        addTaint(line);
        float var546ADE640B6EDFBC8A086EF31347E768_421250130 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_421250130;
        // ---------- Original Method ----------
        //float margin = getParagraphLeadingMargin(line);
        //float signedExtent = getLineExtent(line, true);
        //return margin + signedExtent >= 0 ? signedExtent : -signedExtent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.248 -0400", hash_original_method = "22E5E0C81FE58627900045F7BF4DB10C", hash_generated_method = "F3A4474CAAAC06E4611297EFEEEAD2EF")
    private float getLineExtent(int line, boolean full) {
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
        addTaint(line);
        addTaint(full);
        float var546ADE640B6EDFBC8A086EF31347E768_882428735 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_882428735;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.250 -0400", hash_original_method = "8D693BD7DA670D75D51405BA4AD1D35A", hash_generated_method = "D2E596E62DA88CE5AAFAD6F6BAF236AE")
    private float getLineExtent(int line, TabStops tabStops, boolean full) {
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
        addTaint(line);
        addTaint(tabStops.getTaint());
        addTaint(full);
        float var546ADE640B6EDFBC8A086EF31347E768_1925198395 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1925198395;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.259 -0400", hash_original_method = "10EB5BCC671C8F4E5C56CFC3872691D1", hash_generated_method = "5CE599497EF9C79F5CFB59F92A653C9B")
    public int getLineForVertical(int vertical) {
        int high, low, guess;
        high = getLineCount();
        low = -1;
        {
            guess = (high + low) / 2;
            {
                boolean var61BBF3CF1E0BB57196057707E3B4D6BF_1719380379 = (getLineTop(guess) > vertical);
                high = guess;
                low = guess;
            } //End collapsed parenthetic
        } //End block
        addTaint(vertical);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1232616074 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1232616074;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.260 -0400", hash_original_method = "42BF795D8C0B31EF6FC35C1F4CBE0EBA", hash_generated_method = "8953E7351B65CFD6D2F8FF7329519267")
    public int getLineForOffset(int offset) {
        int high, low, guess;
        high = getLineCount();
        low = -1;
        {
            guess = (high + low) / 2;
            {
                boolean var3154698616D95C0A37FAB8F8A883C99B_1636542958 = (getLineStart(guess) > offset);
                high = guess;
                low = guess;
            } //End collapsed parenthetic
        } //End block
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110737500 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110737500;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.262 -0400", hash_original_method = "C7C29A2E2D90FB22FF824A86EA8883C4", hash_generated_method = "4FABA3090121C57D9443CE9A69701FD2")
    public int getOffsetForHorizontal(int line, float horiz) {
        int max;
        max = getLineEnd(line) - 1;
        int min;
        min = getLineStart(line);
        Directions dirs;
        dirs = getLineDirections(line);
        {
            boolean varE1129FD6E3F799951EC526B3F962E39B_99405232 = (line == getLineCount() - 1);
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
                        boolean var598D8798A97CE595A660B245ECEF3FB1_946946317 = (getPrimaryHorizontal(adguess) * swap >= horiz * swap);
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
        addTaint(line);
        addTaint(horiz);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_313975555 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_313975555;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.277 -0400", hash_original_method = "AEF50F2FA9A7358F560FC7521C77962F", hash_generated_method = "B6AB70E1D10D86BA0090160320BFB57F")
    public final int getLineEnd(int line) {
        int var8CC52E19BC990AEB0402BCF31B3C0E24_43878833 = (getLineStart(line + 1));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1353689447 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1353689447;
        // ---------- Original Method ----------
        //return getLineStart(line + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.278 -0400", hash_original_method = "A5D943CCC73667A904F00DFE82793835", hash_generated_method = "A253C9692769F863220DBD523072F7FA")
    public int getLineVisibleEnd(int line) {
        int var62428E356DD4C198AB8841D5C8B61434_1813104238 = (getLineVisibleEnd(line, getLineStart(line), getLineStart(line+1)));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460717835 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460717835;
        // ---------- Original Method ----------
        //return getLineVisibleEnd(line, getLineStart(line), getLineStart(line+1));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.283 -0400", hash_original_method = "2B63DEF38DAE998AFE5301FAAC214E4B", hash_generated_method = "71E3794AF8F2A415DB16DD56F7764339")
    private int getLineVisibleEnd(int line, int start, int end) {
        CharSequence text;
        text = mText;
        char ch;
        {
            boolean varE1129FD6E3F799951EC526B3F962E39B_1817324483 = (line == getLineCount() - 1);
        } //End collapsed parenthetic
        {
            ch = text.charAt(end - 1);
        } //End block
        addTaint(line);
        addTaint(start);
        addTaint(end);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1288549097 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1288549097;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.284 -0400", hash_original_method = "230C56044F8D52E3D0BA17DE5C72A914", hash_generated_method = "E0D7F26544711E1BAE4005DCA7B25BB7")
    public final int getLineBottom(int line) {
        int var87591D8CFD866D80B89A94BD35FF5C53_1780574961 = (getLineTop(line + 1));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_937655386 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_937655386;
        // ---------- Original Method ----------
        //return getLineTop(line + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.299 -0400", hash_original_method = "BC6E93964E3CCD0D48881D9F9ABB9170", hash_generated_method = "68071052A39F754E67AFDFC8398D4559")
    public final int getLineBaseline(int line) {
        int varF759BC48D9E18C48A2D84A1D35A4C202_830264218 = (getLineTop(line+1) - getLineDescent(line));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1069094096 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1069094096;
        // ---------- Original Method ----------
        //return getLineTop(line+1) - getLineDescent(line);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.300 -0400", hash_original_method = "577197C969745092B110831C30EF14E9", hash_generated_method = "FE94A8AC95F8D9B2A9F0D2A09C79466A")
    public final int getLineAscent(int line) {
        int var77CECF3AA081362BA73A6FE592826DBA_356120608 = (getLineTop(line) - (getLineTop(line+1) - getLineDescent(line)));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_305592021 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_305592021;
        // ---------- Original Method ----------
        //return getLineTop(line) - (getLineTop(line+1) - getLineDescent(line));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.300 -0400", hash_original_method = "AA9B5ECC044BD491182BF4F86B4B2DB2", hash_generated_method = "D0B0197A2BBE2FC041B45BFB463465A8")
    public int getOffsetToLeftOf(int offset) {
        int var277357E3410E8D01615B66CFEDE5D6BD_742476436 = (getOffsetToLeftRightOf(offset, true));
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_38438581 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_38438581;
        // ---------- Original Method ----------
        //return getOffsetToLeftRightOf(offset, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.301 -0400", hash_original_method = "684E6D0185E1F1B7C4ABCAB8ADBE45B0", hash_generated_method = "DED025FCD6F978A517FE097BBF77530D")
    public int getOffsetToRightOf(int offset) {
        int var8F86D7AF4916F278DC98BA8E19B1D241_449176999 = (getOffsetToLeftRightOf(offset, false));
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_432653514 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_432653514;
        // ---------- Original Method ----------
        //return getOffsetToLeftRightOf(offset, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.311 -0400", hash_original_method = "0024CF60F9AAE9E8C390E55EB92D8B7D", hash_generated_method = "45B041A5DC4CC233C365BC918F895E96")
    private int getOffsetToLeftRightOf(int caret, boolean toLeft) {
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
                    boolean var355D79A48691714F7AD418B6FB65073C_1093180987 = (line < getLineCount() - 1);
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
        addTaint(caret);
        addTaint(toLeft);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1724429441 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1724429441;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.319 -0400", hash_original_method = "F9D5E8173F5C3CA491A1C8A8AE760B93", hash_generated_method = "8F0C71248FF12B274531F4594C062FA8")
    private int getOffsetAtStartOf(int offset) {
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
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1851951019 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1851951019;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.334 -0400", hash_original_method = "B9C7ED4514D9377B34881167E2C24E2C", hash_generated_method = "4151A3F0A05E94B4ECB54ACE65200717")
    public void getCursorPath(int point, Path dest,
                              CharSequence editingBuffer) {
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
        boolean var35ABFB89C4D7CB3AAB07DF4BC2B8B7DB_1135857509 = (isLevelBoundary(point));
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
            boolean varB967F472C1B8F55EC25126285D862C13_639254165 = (Float.compare(h1, h2) == 0);
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
        addTaint(point);
        addTaint(dest.getTaint());
        addTaint(editingBuffer.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.347 -0400", hash_original_method = "12119B0793FEC64A3F791B69831CA1AC", hash_generated_method = "17807306D56EDCC2024B2A858FCAE2D6")
    private void addSelection(int line, int start, int end,
                              int top, int bottom, Path dest) {
        int linestart;
        linestart = getLineStart(line);
        int lineend;
        lineend = getLineEnd(line);
        Directions dirs;
        dirs = getLineDirections(line);
        {
            boolean varB43E309FBAB2B8F1A4B7179F5EBC83BF_1039247137 = (lineend > linestart && mText.charAt(lineend - 1) == '\n');
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
        addTaint(line);
        addTaint(start);
        addTaint(end);
        addTaint(top);
        addTaint(bottom);
        addTaint(dest.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.357 -0400", hash_original_method = "E504AED84523F80835FFB88244A923D5", hash_generated_method = "8D29239CFF0658D054ECCA37F09407E3")
    public void getSelectionPath(int start, int end, Path dest) {
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
                boolean var641B20D73ACAC5B224EFAB6A2D83DEC5_1987252866 = (getParagraphDirection(startline) == DIR_RIGHT_TO_LEFT);
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
                boolean var2D05D65F6C53E0529A94B0C267529750_1358341503 = (getParagraphDirection(endline) == DIR_RIGHT_TO_LEFT);
                dest.addRect(width, top, getLineRight(endline), bottom, Path.Direction.CW);
                dest.addRect(0, top, getLineLeft(endline), bottom, Path.Direction.CW);
            } //End collapsed parenthetic
        } //End block
        addTaint(start);
        addTaint(end);
        addTaint(dest.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.358 -0400", hash_original_method = "8E26BC9825AB85694FDEA00F755B3420", hash_generated_method = "E704C09D1C5DD779681DC29B44E02062")
    public final Alignment getParagraphAlignment(int line) {
        Alignment varB4EAC82CA7396A68D541C85D26508E83_646680615 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_646680615 = align;
        addTaint(line);
        varB4EAC82CA7396A68D541C85D26508E83_646680615.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_646680615;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.369 -0400", hash_original_method = "D8249C79FD486A8037899C5A02304321", hash_generated_method = "D4F4AA81528A91C9281333758ECD25F9")
    public final int getParagraphLeft(int line) {
        int left;
        left = 0;
        int dir;
        dir = getParagraphDirection(line);
        int var2A867EA544174101A4992A444C3E4549_944636769 = (getParagraphLeadingMargin(line));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1444493494 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1444493494;
        // ---------- Original Method ----------
        //int left = 0;
        //int dir = getParagraphDirection(line);
        //if (dir == DIR_RIGHT_TO_LEFT || !mSpannedText) {
            //return left; 
        //}
        //return getParagraphLeadingMargin(line);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.370 -0400", hash_original_method = "4AFE65CA85EFF9BA5DD1726E8E021AC9", hash_generated_method = "3ADC5432D31079E9A23375483CC213F3")
    public final int getParagraphRight(int line) {
        int right;
        right = mWidth;
        int dir;
        dir = getParagraphDirection(line);
        int varFDCC0DBACB708D752171E60779D4D664_1427524117 = (right - getParagraphLeadingMargin(line));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_732976120 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_732976120;
        // ---------- Original Method ----------
        //int right = mWidth;
        //int dir = getParagraphDirection(line);
        //if (dir == DIR_LEFT_TO_RIGHT || !mSpannedText) {
            //return right; 
        //}
        //return right - getParagraphLeadingMargin(line);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.371 -0400", hash_original_method = "E5BF73D13B43F74BA21E795D809567BE", hash_generated_method = "36CDBE91F9B1632766C89C73C3F964E7")
    private int getParagraphLeadingMargin(int line) {
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
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1561456317 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1561456317;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.380 -0400", hash_original_method = "CAFF1C73D2C9EA6C410B2B2D519C8AC7", hash_generated_method = "8A19A95E5E45A2550E6415DC6651EA1C")
    protected final boolean isSpanned() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_905441405 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_905441405;
        // ---------- Original Method ----------
        //return mSpannedText;
    }

    
        static <T> T[] getParagraphSpans(Spanned text, int start, int end, Class<T> type) {
        if (start == end && start > 0) {
            return (T[]) ArrayUtils.emptyArray(type);
        }
        return text.getSpans(start, end, type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.384 -0400", hash_original_method = "0902B773EC3014719EA37A51347EC9C6", hash_generated_method = "E76FF6587C872387FBBF08A2BB21D569")
    private void ellipsize(int start, int end, int line,
                           char[] dest, int destoff) {
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
        addTaint(start);
        addTaint(end);
        addTaint(line);
        addTaint(dest[0]);
        addTaint(destoff);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.385 -0400", hash_original_field = "969B4F08C6A411180F291ECE7B5A3D28", hash_generated_field = "8DF1795EE4BFA46EFF29A588C85F9451")

        private int[] mStops;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.385 -0400", hash_original_field = "EAD340360070F0A190E57144293C5C2B", hash_generated_field = "2A878E7FB3BADF740089FE25D0D2CFB0")

        private int mNumStops;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.399 -0400", hash_original_field = "B954C9EDAC21852B96AD8DA47FB0BB4A", hash_generated_field = "1B34C3EF06331C9557133D8E11D29298")

        private int mIncrement;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.400 -0400", hash_original_method = "56D1FFBFF7D6B6649609A0E9FF6888AB", hash_generated_method = "DEEECE78FD66DADB3A00A557295014C2")
          TabStops(int increment, Object[] spans) {
            reset(increment, spans);
            addTaint(increment);
            addTaint(spans[0].getTaint());
            // ---------- Original Method ----------
            //reset(increment, spans);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.514 -0400", hash_original_method = "12BC3A9AA4E5F32DB7C736F6D72E4602", hash_generated_method = "C8D6425D9382ADEBA285A00F8EE3E8A1")
         void reset(int increment, Object[] spans) {
            this.mIncrement = increment;
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
            addTaint(spans[0].getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.526 -0400", hash_original_method = "A46080BC8F3B4D3099E262DAA9B4728B", hash_generated_method = "9A4B196C65EC26572F1A50FBD76B9C74")
         float nextTab(float h) {
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
            float varA772933572361B833B090C93A4B38B40_778811093 = (nextDefaultStop(h, mIncrement));
            addTaint(h);
            float var546ADE640B6EDFBC8A086EF31347E768_1668942640 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1668942640;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.527 -0400", hash_original_field = "C5BE317E362FA3A0C2C3E5FEF24D93D8", hash_generated_field = "75E76BC0D205B7AB08D04B9BD6A8D5F6")

        int[] mDirections;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.527 -0400", hash_original_method = "DA94802578AA1A107A88665DAAC4811A", hash_generated_method = "C362AB05F4F382AB8B2A847D6ACC1E92")
          Directions(int[] dirs) {
            mDirections = dirs;
            // ---------- Original Method ----------
            //mDirections = dirs;
        }

        
    }


    
    static class Ellipsizer implements CharSequence, GetChars {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.528 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "A59BBC07E5E46996D793B2F37E80BD24")

        CharSequence mText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.528 -0400", hash_original_field = "AF58F50E47532278404C3D8470630FC4", hash_generated_field = "99107F82B615317EF9A2721652F6B828")

        Layout mLayout;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.528 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "AF6410B200BC05DCA2CF0BE65165448A")

        int mWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.528 -0400", hash_original_field = "411D2DFDB93368C46AFADBEC76A54162", hash_generated_field = "1AEFAC3E5E60C9DA6FF9B1E24BF26D63")

        TextUtils.TruncateAt mMethod;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.529 -0400", hash_original_method = "991CD3860414493D5159CDEA8946E94D", hash_generated_method = "D2DA4A1117D0439320B581750375AE47")
        public  Ellipsizer(CharSequence s) {
            mText = s;
            // ---------- Original Method ----------
            //mText = s;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.530 -0400", hash_original_method = "D253D2AD2D0DACD122596323ACBBAF25", hash_generated_method = "06AC1E050BA8DA0F4CC94B7B542F9043")
        public char charAt(int off) {
            char[] buf;
            buf = TextUtils.obtain(1);
            getChars(off, off + 1, buf, 0);
            char ret;
            ret = buf[0];
            TextUtils.recycle(buf);
            addTaint(off);
            char varA87DEB01C5F539E6BDA34829C8EF2368_1377955473 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1377955473;
            // ---------- Original Method ----------
            //char[] buf = TextUtils.obtain(1);
            //getChars(off, off + 1, buf, 0);
            //char ret = buf[0];
            //TextUtils.recycle(buf);
            //return ret;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.530 -0400", hash_original_method = "F2DBD2F3D78F3955B1714BB078A793F8", hash_generated_method = "FE24C4C12EDC7A6AB235259065548642")
        public void getChars(int start, int end, char[] dest, int destoff) {
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
            addTaint(start);
            addTaint(end);
            addTaint(dest[0]);
            addTaint(destoff);
            // ---------- Original Method ----------
            //int line1 = mLayout.getLineForOffset(start);
            //int line2 = mLayout.getLineForOffset(end);
            //TextUtils.getChars(mText, start, end, dest, destoff);
            //for (int i = line1; i <= line2; i++) {
                //mLayout.ellipsize(start, end, i, dest, destoff);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.543 -0400", hash_original_method = "9A68249D01A4FE1CBD4D535668FCEB6F", hash_generated_method = "89323E04FFC96A8D7EF581F8061273D6")
        public int length() {
            int varE8711A0ED7EDCE918346EA0F2DE620ED_1667995617 = (mText.length());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_622428387 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_622428387;
            // ---------- Original Method ----------
            //return mText.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.544 -0400", hash_original_method = "019151395F1B77A008AA178A5A5CA402", hash_generated_method = "4B7947442977F9CED5C2E784E9CCA2E9")
        public CharSequence subSequence(int start, int end) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1680033703 = null; //Variable for return #1
            char[] s;
            s = new char[end - start];
            getChars(start, end, s, 0);
            varB4EAC82CA7396A68D541C85D26508E83_1680033703 = new String(s);
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_1680033703.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1680033703;
            // ---------- Original Method ----------
            //char[] s = new char[end - start];
            //getChars(start, end, s, 0);
            //return new String(s);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.545 -0400", hash_original_method = "8ED281151745D3FC40324C23FDF16D10", hash_generated_method = "D6042F89E3C62234935579E132F97B0A")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1857318018 = null; //Variable for return #1
            char[] s;
            s = new char[length()];
            getChars(0, length(), s, 0);
            varB4EAC82CA7396A68D541C85D26508E83_1857318018 = new String(s);
            varB4EAC82CA7396A68D541C85D26508E83_1857318018.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1857318018;
            // ---------- Original Method ----------
            //char[] s = new char[length()];
            //getChars(0, length(), s, 0);
            //return new String(s);
        }

        
    }


    
    static class SpannedEllipsizer extends Ellipsizer implements Spanned {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.545 -0400", hash_original_field = "2A174ADD3219E7DC0B72155FF67EC4B5", hash_generated_field = "69C78554F8ABB9B2C492FD314F3ED2EE")

        private Spanned mSpanned;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.554 -0400", hash_original_method = "F42AC9AEDB79FF2719E5DE12CF0CD85E", hash_generated_method = "521E0E4859CABE811C363188B0E6F44F")
        public  SpannedEllipsizer(CharSequence display) {
            super(display);
            mSpanned = (Spanned) display;
            // ---------- Original Method ----------
            //mSpanned = (Spanned) display;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.558 -0400", hash_original_method = "E8AB479016A2E00AFF48AA43F345FA2A", hash_generated_method = "47A4DF5A6D0B632CAE9205E894BA6475")
        public <T> T[] getSpans(int start, int end, Class<T> type) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_458773518 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_458773518 = mSpanned.getSpans(start, end, type);
            addTaint(start);
            addTaint(end);
            addTaint(type.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_458773518.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_458773518;
            // ---------- Original Method ----------
            //return mSpanned.getSpans(start, end, type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.562 -0400", hash_original_method = "2071284CDE64572D4D3F80F80EB4C823", hash_generated_method = "9DBEEC0E08DBCCA95E1AE84BF62298C2")
        public int getSpanStart(Object tag) {
            int varD7924E7B7A12FA5A3B050A8325F5D9BE_366300267 = (mSpanned.getSpanStart(tag));
            addTaint(tag.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1396601688 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1396601688;
            // ---------- Original Method ----------
            //return mSpanned.getSpanStart(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.562 -0400", hash_original_method = "B1DC38D90632AE4EB220020E4C5B16DF", hash_generated_method = "755BD89F14ADB94A27FD3DC6940CF91C")
        public int getSpanEnd(Object tag) {
            int varFDD9D023F9FB8A63C470934B7C2E8224_1955748202 = (mSpanned.getSpanEnd(tag));
            addTaint(tag.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_547239533 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_547239533;
            // ---------- Original Method ----------
            //return mSpanned.getSpanEnd(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.563 -0400", hash_original_method = "A386D5CC8A9C15386840381A75E4D6FD", hash_generated_method = "A987432FB95E61CFB287D1DAC52772AA")
        public int getSpanFlags(Object tag) {
            int var689A4E26E56E6EC55263E3776149ED4A_1420447569 = (mSpanned.getSpanFlags(tag));
            addTaint(tag.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_828703917 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_828703917;
            // ---------- Original Method ----------
            //return mSpanned.getSpanFlags(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.568 -0400", hash_original_method = "AF35DA8DF947D9C1330368703ECE15BE", hash_generated_method = "B1204474B04E7A4F76CADE54ACA26AB5")
        public int nextSpanTransition(int start, int limit, Class type) {
            int varF2EB81A12DD76D71166CCB6A597BD229_616385450 = (mSpanned.nextSpanTransition(start, limit, type));
            addTaint(start);
            addTaint(limit);
            addTaint(type.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_886748323 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_886748323;
            // ---------- Original Method ----------
            //return mSpanned.nextSpanTransition(start, limit, type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.572 -0400", hash_original_method = "16B37527DFF576A9EB476E4EC2A69F5D", hash_generated_method = "ADDD6ED70ECB0D039C1A4F6B4B42F4C0")
        @Override
        public CharSequence subSequence(int start, int end) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_174021006 = null; //Variable for return #1
            char[] s;
            s = new char[end - start];
            getChars(start, end, s, 0);
            SpannableString ss;
            ss = new SpannableString(new String(s));
            TextUtils.copySpansFrom(mSpanned, start, end, Object.class, ss, 0);
            varB4EAC82CA7396A68D541C85D26508E83_174021006 = ss;
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_174021006.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_174021006;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.572 -0400", hash_original_field = "9588EEAF34B7EF093B8A162F81FAFD3E", hash_generated_field = "69FD02F698813F89D672E026360CF250")

    private static ParagraphStyle[] NO_PARA_SPANS = ArrayUtils.emptyArray(ParagraphStyle.class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.573 -0400", hash_original_field = "C98EF14E21465DCAA8481165D4FC8D06", hash_generated_field = "F90D3079BBC6277ED835E213A47BCB3B")

    static EmojiFactory EMOJI_FACTORY = EmojiFactory.newAvailableInstance();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.573 -0400", hash_original_field = "471F949A3986C3F4EDFE65343195112B", hash_generated_field = "50981D9CDB8FFE37DD0AD7398C887F29")

    static int MIN_EMOJI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.573 -0400", hash_original_field = "9BA5E1F2A793A8D05CB1371A5403608D", hash_generated_field = "2FF41CCD8E77FA54D79A8CE87AE76CE2")

    static int MAX_EMOJI;
    static {
        if (EMOJI_FACTORY != null) {
            MIN_EMOJI = EMOJI_FACTORY.getMinimumAndroidPua();
            MAX_EMOJI = EMOJI_FACTORY.getMaximumAndroidPua();
        } else {
            MIN_EMOJI = -1;
            MAX_EMOJI = -1;
        }
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.573 -0400", hash_original_field = "C4A38C1668AF8A793012B43F6161CD16", hash_generated_field = "514D1A6C1A71333DF75A0E24E315F81B")

    private static Rect sTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.573 -0400", hash_original_field = "6FD91A9995B8B5FC3C8F7C455B83B35F", hash_generated_field = "52D12843713C54C6D6FE037A484C039E")

    public static final int DIR_LEFT_TO_RIGHT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.573 -0400", hash_original_field = "17318FEC2191C074ECAABD2C38659B46", hash_generated_field = "E624F93AD27646BB22CB05444CE41FB7")

    public static final int DIR_RIGHT_TO_LEFT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.573 -0400", hash_original_field = "137CDBC203F61667CC7E67D68F89D874", hash_generated_field = "04B58C4AD9C676FB649C271AB0BBD08B")

    static int DIR_REQUEST_LTR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.573 -0400", hash_original_field = "7BC355A5AAD6E5EADBC6B5C81FF9EFE0", hash_generated_field = "CEC985F3F0542051E78EF4035E8CF8FB")

    static int DIR_REQUEST_RTL = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.580 -0400", hash_original_field = "E08042CAD555C940FA4820833C645893", hash_generated_field = "C8869540BB823E962D2E476A9DF83246")

    static int DIR_REQUEST_DEFAULT_LTR = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.580 -0400", hash_original_field = "2BC912CEB718B45E37D43B9DD28FCA06", hash_generated_field = "40886990965E0E17283430757C23B125")

    static int DIR_REQUEST_DEFAULT_RTL = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.580 -0400", hash_original_field = "39D3AAFD530E8474E92C1E2B18BF315E", hash_generated_field = "F0384740E00EB75C684162162E40B7FF")

    static int RUN_LENGTH_MASK = 0x03ffffff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.580 -0400", hash_original_field = "039DB298A48FCCC6EC38DF1E608B281F", hash_generated_field = "A8027E62CEAF54311606759B2C7DA149")

    static int RUN_LEVEL_SHIFT = 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.581 -0400", hash_original_field = "75A423C35DF8A3E743B55A65B5C563B8", hash_generated_field = "78AD13AD300C52CA3BBB49A91D9298E0")

    static int RUN_LEVEL_MASK = 0x3f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.581 -0400", hash_original_field = "582E27236495D028F8DEF24E0A548B5E", hash_generated_field = "81D5396BD7EABD64A973642EEDAC362B")

    static int RUN_RTL_FLAG = 1 << RUN_LEVEL_SHIFT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.581 -0400", hash_original_field = "5857BDFF3BF33113730586AF5B28164F", hash_generated_field = "BD4519227226DE6CF8B5B95534D34642")

    private static int TAB_INCREMENT = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.581 -0400", hash_original_field = "016F06FA5D76A8D90674CD58FE50F840", hash_generated_field = "3AD3B5A918E4FC41B99EDADED565DFB3")

    static Directions DIRS_ALL_LEFT_TO_RIGHT = new Directions(new int[] { 0, RUN_LENGTH_MASK });
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:39.581 -0400", hash_original_field = "B75F87DE53400F9F37765D0FDC63007E", hash_generated_field = "46ABB9D648D50C05DDF53405C76D742E")

    static Directions DIRS_ALL_RIGHT_TO_LEFT = new Directions(new int[] { 0, RUN_LENGTH_MASK | RUN_RTL_FLAG });
}

