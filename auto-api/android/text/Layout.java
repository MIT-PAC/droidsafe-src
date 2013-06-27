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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.576 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "E579ED9F2DADADEB46C981CAFDEE5BA5")

    private CharSequence mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.576 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "B5BC396C7010734D6B4B6ED34A2846AE")

    private TextPaint mPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.576 -0400", hash_original_field = "B3CE09DC80997D762CCFEE11916EE7B6", hash_generated_field = "B28AC88C47D899E85CEE0110DCCDCA16")

    TextPaint mWorkPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.576 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

    private int mWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.576 -0400", hash_original_field = "016218732B28025C6B752A3B2A457113", hash_generated_field = "A5FBEE576828FD767B418A1715D12197")

    private Alignment mAlignment = Alignment.ALIGN_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.576 -0400", hash_original_field = "DD430150592EA7FB656F57A5D9A5C479", hash_generated_field = "0C2C39C12F42C181B35D16CF7D81A703")

    private float mSpacingMult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.576 -0400", hash_original_field = "18DE4355EE7ABBEF3185EC1003DD341A", hash_generated_field = "733F92CD6EAB2F9CA67542D073A49D69")

    private float mSpacingAdd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.577 -0400", hash_original_field = "9AAB51E3E9F2DBF3923317511559B1D1", hash_generated_field = "9735AD2A3473CB2D7DEA16EAA46F6EFB")

    private boolean mSpannedText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.577 -0400", hash_original_field = "056B2B67A5D743296E35F6A88B022318", hash_generated_field = "720F1C3BB08BF46839EBBA716D35B07F")

    private TextDirectionHeuristic mTextDir;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.577 -0400", hash_original_method = "DA432A00E31F4EFC04FE32B9AEC1CEE4", hash_generated_method = "497D43F984F908C615AC7DDCD4AB47FF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.593 -0400", hash_original_method = "E08E539EEFF1AD274546B85662DC9DCC", hash_generated_method = "C73F246C622EAA9054FDA8F78297DAC1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.595 -0400", hash_original_method = "4BA809AE232557C36D4CE5AE6E36D4D2", hash_generated_method = "BBAF0084E8D40C760639B9BEAB427E56")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.596 -0400", hash_original_method = "21986991A7FC788A39082240DAE8B9C3", hash_generated_method = "A7DBF3BE15A320D6F69E02741972F077")
    public void draw(Canvas c) {
        draw(c, null, null, 0);
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //draw(c, null, null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.650 -0400", hash_original_method = "C63D8686FF6D60F338825542CA174C93", hash_generated_method = "E54D8E5CF869B708E7E6F7B2C38E243B")
    public void draw(Canvas c, Path highlight, Paint highlightPaint,
                     int cursorOffsetVertical) {
        int dtop, dbottom;
        {
            {
                boolean varC42A531B776DA8F33EFB072E74A6FC1E_2091661212 = (!c.getClipBounds(sTempRect));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.654 -0400", hash_original_method = "94C8B0A33C8A9972488E17891E7B8BAC", hash_generated_method = "E5487631D4EBD4D52C1F588844602446")
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
                boolean varEBDDE922AE0589A6CEAD24B0AC5E6B48_583836445 = (mSpannedText && getLineContainsTab(line));
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1734817975 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1734817975;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.673 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "C2CEE657E836E66EE8D9803C9EE24131")
    public final CharSequence getText() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1174071424 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1174071424 = mText;
        varB4EAC82CA7396A68D541C85D26508E83_1174071424.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1174071424;
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.675 -0400", hash_original_method = "7064C5093467A23605D5C425E4D25B83", hash_generated_method = "14E53F2BBDA88AF455C747D697E3FDB4")
    public final TextPaint getPaint() {
        TextPaint varB4EAC82CA7396A68D541C85D26508E83_1233989580 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1233989580 = mPaint;
        varB4EAC82CA7396A68D541C85D26508E83_1233989580.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1233989580;
        // ---------- Original Method ----------
        //return mPaint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.676 -0400", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "11E19399BBC0C8264DE4E5E70A5E3157")
    public final int getWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1373334273 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1373334273;
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.676 -0400", hash_original_method = "90F96A059D406483E44444E82D555D1F", hash_generated_method = "1826B12765ABC72C3F98563D156F6C65")
    public int getEllipsizedWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293162767 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293162767;
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.677 -0400", hash_original_method = "461CE12B89AFCA61718D5C5F590357B0", hash_generated_method = "8CE222B19DC30D9434620F2E598C23A9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.700 -0400", hash_original_method = "5212B162F472F11B6A60B5BD891C860A", hash_generated_method = "9C6A50B00DEBDB083F82212BA72A6885")
    public int getHeight() {
        int var7ED7F6E2EB0B1BC7A56013BEE63A9A35_1111529775 = (getLineTop(getLineCount()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_343287857 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_343287857;
        // ---------- Original Method ----------
        //return getLineTop(getLineCount());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.702 -0400", hash_original_method = "FB2D4D43E3EFDD971010AB3AFA49B442", hash_generated_method = "13CE4B40A08BB756025F75E359AB9C1D")
    public final Alignment getAlignment() {
        Alignment varB4EAC82CA7396A68D541C85D26508E83_1304073276 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1304073276 = mAlignment;
        varB4EAC82CA7396A68D541C85D26508E83_1304073276.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1304073276;
        // ---------- Original Method ----------
        //return mAlignment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.702 -0400", hash_original_method = "F861D6694D511E0A8AF4CE2A5552F333", hash_generated_method = "33E2DCD8F440A1AA7818A118A697DDF0")
    public final float getSpacingMultiplier() {
        float var546ADE640B6EDFBC8A086EF31347E768_776139186 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_776139186;
        // ---------- Original Method ----------
        //return mSpacingMult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.702 -0400", hash_original_method = "E15AF37508F3C3C8F31DF2917343152C", hash_generated_method = "75F372A281F36799F361FFA00B7267A8")
    public final float getSpacingAdd() {
        float var546ADE640B6EDFBC8A086EF31347E768_516826339 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_516826339;
        // ---------- Original Method ----------
        //return mSpacingAdd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.703 -0400", hash_original_method = "CEF29A1F61D81E3972548E19A0D7158C", hash_generated_method = "821A3FD6F5D096905D12E357A80EC2E1")
    public final TextDirectionHeuristic getTextDirectionHeuristic() {
        TextDirectionHeuristic varB4EAC82CA7396A68D541C85D26508E83_1212191547 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1212191547 = mTextDir;
        varB4EAC82CA7396A68D541C85D26508E83_1212191547.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1212191547;
        // ---------- Original Method ----------
        //return mTextDir;
    }

    
    public abstract int getLineCount();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.721 -0400", hash_original_method = "6295516BE4612811C14BD1DCED80BAB8", hash_generated_method = "CAB6794936907EE6FA85064E88F2C4A4")
    public int getLineBounds(int line, Rect bounds) {
        {
            bounds.left = 0;
            bounds.top = getLineTop(line);
            bounds.right = mWidth;
            bounds.bottom = getLineTop(line + 1);
        } //End block
        int var29FD769CAB68A42F60CF514C827201BE_742400346 = (getLineBaseline(line));
        addTaint(line);
        addTaint(bounds.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994554098 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994554098;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.725 -0400", hash_original_method = "2C3949CE81E6BE871356E85B216A576F", hash_generated_method = "B4B1EC4D073F93656F408C8577C3FBC8")
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
            boolean varEEB6B6B705B0C78401688F613A79E083_1202268214 = (getParagraphDirection(line) == 1);
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1199986139 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1199986139;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.734 -0400", hash_original_method = "AF5CCAD1718916CFF1EB4C8EF2E12FAE", hash_generated_method = "4FDB3E9669AD309F9C41889BBF7E1F99")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1645331897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1645331897;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.753 -0400", hash_original_method = "2802B19F8A9E2D0D463FD305FA66136A", hash_generated_method = "57124D69B38C5F9E8D8D40620B84E2C3")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1420048760 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1420048760;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.754 -0400", hash_original_method = "80ABC300097314837E01431F08FED39C", hash_generated_method = "56CCBE847356AFB6623BBF32CD8A38C2")
    public float getPrimaryHorizontal(int offset) {
        boolean trailing;
        trailing = primaryIsTrailingPrevious(offset);
        float var58B325E5B7FB5DC54EFDE69C8EB888FB_1028704515 = (getHorizontal(offset, trailing));
        addTaint(offset);
        float var546ADE640B6EDFBC8A086EF31347E768_1901070562 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1901070562;
        // ---------- Original Method ----------
        //boolean trailing = primaryIsTrailingPrevious(offset);
        //return getHorizontal(offset, trailing);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.754 -0400", hash_original_method = "5EA78F3566FFC0563802F8455C66332C", hash_generated_method = "699CBFBDA0C691224E28DDF61A2EE449")
    public float getSecondaryHorizontal(int offset) {
        boolean trailing;
        trailing = primaryIsTrailingPrevious(offset);
        float var88A0B1B7EB4DA5EBC1FC42BFB863BDDB_500428526 = (getHorizontal(offset, !trailing));
        addTaint(offset);
        float var546ADE640B6EDFBC8A086EF31347E768_1375000526 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1375000526;
        // ---------- Original Method ----------
        //boolean trailing = primaryIsTrailingPrevious(offset);
        //return getHorizontal(offset, !trailing);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.777 -0400", hash_original_method = "A6F47D9472D86FF595A17085495F07A6", hash_generated_method = "CDA9AF867C3FF2181C773A1BC40E0132")
    private float getHorizontal(int offset, boolean trailing) {
        int line;
        line = getLineForOffset(offset);
        float varE96D4127286387DC83C70FBC1CFA8E14_791384189 = (getHorizontal(offset, trailing, line));
        addTaint(offset);
        addTaint(trailing);
        float var546ADE640B6EDFBC8A086EF31347E768_2077116259 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2077116259;
        // ---------- Original Method ----------
        //int line = getLineForOffset(offset);
        //return getHorizontal(offset, trailing, line);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.778 -0400", hash_original_method = "B47A0ABADD57DE266AAF87A7E699E873", hash_generated_method = "10BB594A7743C5D0A404DBF4555624BE")
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
        float var4B4FA8270CE482A0F053465908FBE10D_103097617 = (getLineStartPos(line, left, right) + wid);
        addTaint(offset);
        addTaint(trailing);
        addTaint(line);
        float var546ADE640B6EDFBC8A086EF31347E768_1654223477 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1654223477;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.779 -0400", hash_original_method = "185391EA60FA7533A9126C3E791BF275", hash_generated_method = "D4DD8A5F69647B8D015584F2AC4C82C7")
    public float getLineLeft(int line) {
        int dir;
        dir = getParagraphDirection(line);
        Alignment align;
        align = getParagraphAlignment(line);
        {
            float var98F794A324A0919CA2BAAE75E672BC61_421125828 = (getParagraphRight(line) - getLineMax(line));
        } //End block
        {
            float varB6842D18BAF51681C1C350FBC007B514_559376138 = (mWidth - getLineMax(line));
        } //End block
        {
            float varB6842D18BAF51681C1C350FBC007B514_1419641449 = (mWidth - getLineMax(line));
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
        float var546ADE640B6EDFBC8A086EF31347E768_2121764899 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2121764899;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.794 -0400", hash_original_method = "D344E3703EA76C4344B547792AB00F8E", hash_generated_method = "43E44511DB3B492348D5C515A989E974")
    public float getLineRight(int line) {
        int dir;
        dir = getParagraphDirection(line);
        Alignment align;
        align = getParagraphAlignment(line);
        {
            float varC6136DD4ADABC05AB18240388355DC3F_1102438523 = (getParagraphLeft(line) + getLineMax(line));
        } //End block
        {
            float varC6136DD4ADABC05AB18240388355DC3F_2036242131 = (getParagraphLeft(line) + getLineMax(line));
        } //End block
        {
            float varDA3557094C6D55255BC5DF32F9EC5DA6_252181134 = (getLineMax(line));
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
        float var546ADE640B6EDFBC8A086EF31347E768_1089839837 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1089839837;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.795 -0400", hash_original_method = "F9A5FD2221E6CC8B07379CD2792C3C3D", hash_generated_method = "1F4BB3B1A8728A1C7156A0B61B12213B")
    public float getLineMax(int line) {
        float margin;
        margin = getParagraphLeadingMargin(line);
        float signedExtent;
        signedExtent = getLineExtent(line, false);
        addTaint(line);
        float var546ADE640B6EDFBC8A086EF31347E768_960764817 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_960764817;
        // ---------- Original Method ----------
        //float margin = getParagraphLeadingMargin(line);
        //float signedExtent = getLineExtent(line, false);
        //return margin + signedExtent >= 0 ? signedExtent : -signedExtent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.796 -0400", hash_original_method = "71AEB5E1BA96E910342AC0DBF85E1ED1", hash_generated_method = "2547C30C9006EA52D7591F4DF51E936C")
    public float getLineWidth(int line) {
        float margin;
        margin = getParagraphLeadingMargin(line);
        float signedExtent;
        signedExtent = getLineExtent(line, true);
        addTaint(line);
        float var546ADE640B6EDFBC8A086EF31347E768_70591319 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_70591319;
        // ---------- Original Method ----------
        //float margin = getParagraphLeadingMargin(line);
        //float signedExtent = getLineExtent(line, true);
        //return margin + signedExtent >= 0 ? signedExtent : -signedExtent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.812 -0400", hash_original_method = "22E5E0C81FE58627900045F7BF4DB10C", hash_generated_method = "0E908652469DCDF52D0052A08476E9CE")
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
        float var546ADE640B6EDFBC8A086EF31347E768_551485070 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_551485070;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.813 -0400", hash_original_method = "8D693BD7DA670D75D51405BA4AD1D35A", hash_generated_method = "C1A90A5BF3E1F76F31435FA9E65485E7")
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
        float var546ADE640B6EDFBC8A086EF31347E768_451574259 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_451574259;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.814 -0400", hash_original_method = "10EB5BCC671C8F4E5C56CFC3872691D1", hash_generated_method = "5B066B7FB2FAC064DD97284F443FE85E")
    public int getLineForVertical(int vertical) {
        int high, low, guess;
        high = getLineCount();
        low = -1;
        {
            guess = (high + low) / 2;
            {
                boolean var61BBF3CF1E0BB57196057707E3B4D6BF_861912395 = (getLineTop(guess) > vertical);
                high = guess;
                low = guess;
            } //End collapsed parenthetic
        } //End block
        addTaint(vertical);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1587786414 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1587786414;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.820 -0400", hash_original_method = "42BF795D8C0B31EF6FC35C1F4CBE0EBA", hash_generated_method = "C5E5D73CC08397C370DD8F98082C5CD1")
    public int getLineForOffset(int offset) {
        int high, low, guess;
        high = getLineCount();
        low = -1;
        {
            guess = (high + low) / 2;
            {
                boolean var3154698616D95C0A37FAB8F8A883C99B_2142650961 = (getLineStart(guess) > offset);
                high = guess;
                low = guess;
            } //End collapsed parenthetic
        } //End block
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_91622314 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_91622314;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.841 -0400", hash_original_method = "C7C29A2E2D90FB22FF824A86EA8883C4", hash_generated_method = "62FC0E94D16AAA0169E964503D13D9D3")
    public int getOffsetForHorizontal(int line, float horiz) {
        int max;
        max = getLineEnd(line) - 1;
        int min;
        min = getLineStart(line);
        Directions dirs;
        dirs = getLineDirections(line);
        {
            boolean varE1129FD6E3F799951EC526B3F962E39B_1075816407 = (line == getLineCount() - 1);
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
                        boolean var598D8798A97CE595A660B245ECEF3FB1_714327287 = (getPrimaryHorizontal(adguess) * swap >= horiz * swap);
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1633494884 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1633494884;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.842 -0400", hash_original_method = "AEF50F2FA9A7358F560FC7521C77962F", hash_generated_method = "4433377A1BFF6980C27EAA59DD6CE131")
    public final int getLineEnd(int line) {
        int var8CC52E19BC990AEB0402BCF31B3C0E24_1978273304 = (getLineStart(line + 1));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_96543078 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_96543078;
        // ---------- Original Method ----------
        //return getLineStart(line + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.854 -0400", hash_original_method = "A5D943CCC73667A904F00DFE82793835", hash_generated_method = "48CCA1D4AB22AD0B6A148191683A248C")
    public int getLineVisibleEnd(int line) {
        int var62428E356DD4C198AB8841D5C8B61434_346653687 = (getLineVisibleEnd(line, getLineStart(line), getLineStart(line+1)));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1988833897 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1988833897;
        // ---------- Original Method ----------
        //return getLineVisibleEnd(line, getLineStart(line), getLineStart(line+1));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.855 -0400", hash_original_method = "2B63DEF38DAE998AFE5301FAAC214E4B", hash_generated_method = "BED02FEDDB0DBD30DDAC6E23DB73EE20")
    private int getLineVisibleEnd(int line, int start, int end) {
        CharSequence text;
        text = mText;
        char ch;
        {
            boolean varE1129FD6E3F799951EC526B3F962E39B_387660993 = (line == getLineCount() - 1);
        } //End collapsed parenthetic
        {
            ch = text.charAt(end - 1);
        } //End block
        addTaint(line);
        addTaint(start);
        addTaint(end);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1455344076 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1455344076;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.856 -0400", hash_original_method = "230C56044F8D52E3D0BA17DE5C72A914", hash_generated_method = "C2FEBFEFBBB631552F5D2E3EC90F4EA5")
    public final int getLineBottom(int line) {
        int var87591D8CFD866D80B89A94BD35FF5C53_1592314543 = (getLineTop(line + 1));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1048778349 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1048778349;
        // ---------- Original Method ----------
        //return getLineTop(line + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.866 -0400", hash_original_method = "BC6E93964E3CCD0D48881D9F9ABB9170", hash_generated_method = "D65AE9CA2A1A9037DFDA8CCD737DC79D")
    public final int getLineBaseline(int line) {
        int varF759BC48D9E18C48A2D84A1D35A4C202_423461158 = (getLineTop(line+1) - getLineDescent(line));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309635722 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309635722;
        // ---------- Original Method ----------
        //return getLineTop(line+1) - getLineDescent(line);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.867 -0400", hash_original_method = "577197C969745092B110831C30EF14E9", hash_generated_method = "1193CDF867D6437AFC4C5AD9E8C15156")
    public final int getLineAscent(int line) {
        int var77CECF3AA081362BA73A6FE592826DBA_1600617203 = (getLineTop(line) - (getLineTop(line+1) - getLineDescent(line)));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_227047990 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_227047990;
        // ---------- Original Method ----------
        //return getLineTop(line) - (getLineTop(line+1) - getLineDescent(line));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.885 -0400", hash_original_method = "AA9B5ECC044BD491182BF4F86B4B2DB2", hash_generated_method = "59554467C9516B4DC4B49F393D88E4BD")
    public int getOffsetToLeftOf(int offset) {
        int var277357E3410E8D01615B66CFEDE5D6BD_1007872205 = (getOffsetToLeftRightOf(offset, true));
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1866720874 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1866720874;
        // ---------- Original Method ----------
        //return getOffsetToLeftRightOf(offset, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.887 -0400", hash_original_method = "684E6D0185E1F1B7C4ABCAB8ADBE45B0", hash_generated_method = "5D84534A8FC756C7B72B1FB6E5D32DD0")
    public int getOffsetToRightOf(int offset) {
        int var8F86D7AF4916F278DC98BA8E19B1D241_104229643 = (getOffsetToLeftRightOf(offset, false));
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_370930666 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_370930666;
        // ---------- Original Method ----------
        //return getOffsetToLeftRightOf(offset, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.894 -0400", hash_original_method = "0024CF60F9AAE9E8C390E55EB92D8B7D", hash_generated_method = "712CD2FF3F99B6C442C972288EC873D4")
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
                    boolean var355D79A48691714F7AD418B6FB65073C_1201674633 = (line < getLineCount() - 1);
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_876455432 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_876455432;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.895 -0400", hash_original_method = "F9D5E8173F5C3CA491A1C8A8AE760B93", hash_generated_method = "0E136F476B803EE125589C55254C27E1")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_135684232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_135684232;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.918 -0400", hash_original_method = "B9C7ED4514D9377B34881167E2C24E2C", hash_generated_method = "49F7EF1BEB23ED88933E15A4B882D48A")
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
        boolean var35ABFB89C4D7CB3AAB07DF4BC2B8B7DB_1028800366 = (isLevelBoundary(point));
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
            boolean varB967F472C1B8F55EC25126285D862C13_1707701902 = (Float.compare(h1, h2) == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.936 -0400", hash_original_method = "12119B0793FEC64A3F791B69831CA1AC", hash_generated_method = "A8E5CAC8D83A2A6C0E37B4A91EB89F4E")
    private void addSelection(int line, int start, int end,
                              int top, int bottom, Path dest) {
        int linestart;
        linestart = getLineStart(line);
        int lineend;
        lineend = getLineEnd(line);
        Directions dirs;
        dirs = getLineDirections(line);
        {
            boolean varB43E309FBAB2B8F1A4B7179F5EBC83BF_34838636 = (lineend > linestart && mText.charAt(lineend - 1) == '\n');
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.939 -0400", hash_original_method = "E504AED84523F80835FFB88244A923D5", hash_generated_method = "AA96B8678707474E93B9DE12D5380CF5")
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
                boolean var641B20D73ACAC5B224EFAB6A2D83DEC5_1920995392 = (getParagraphDirection(startline) == DIR_RIGHT_TO_LEFT);
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
                boolean var2D05D65F6C53E0529A94B0C267529750_621930342 = (getParagraphDirection(endline) == DIR_RIGHT_TO_LEFT);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.960 -0400", hash_original_method = "8E26BC9825AB85694FDEA00F755B3420", hash_generated_method = "47D1B9A2E0003B384EC18A572E39243F")
    public final Alignment getParagraphAlignment(int line) {
        Alignment varB4EAC82CA7396A68D541C85D26508E83_1865019423 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1865019423 = align;
        addTaint(line);
        varB4EAC82CA7396A68D541C85D26508E83_1865019423.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1865019423;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.961 -0400", hash_original_method = "D8249C79FD486A8037899C5A02304321", hash_generated_method = "90984C17308276D1F5D72375200892FB")
    public final int getParagraphLeft(int line) {
        int left;
        left = 0;
        int dir;
        dir = getParagraphDirection(line);
        int var2A867EA544174101A4992A444C3E4549_1275525302 = (getParagraphLeadingMargin(line));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349223709 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349223709;
        // ---------- Original Method ----------
        //int left = 0;
        //int dir = getParagraphDirection(line);
        //if (dir == DIR_RIGHT_TO_LEFT || !mSpannedText) {
            //return left; 
        //}
        //return getParagraphLeadingMargin(line);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.962 -0400", hash_original_method = "4AFE65CA85EFF9BA5DD1726E8E021AC9", hash_generated_method = "CE55AE2689630ADF65A57928A97AFE12")
    public final int getParagraphRight(int line) {
        int right;
        right = mWidth;
        int dir;
        dir = getParagraphDirection(line);
        int varFDCC0DBACB708D752171E60779D4D664_270207105 = (right - getParagraphLeadingMargin(line));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_112431477 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_112431477;
        // ---------- Original Method ----------
        //int right = mWidth;
        //int dir = getParagraphDirection(line);
        //if (dir == DIR_LEFT_TO_RIGHT || !mSpannedText) {
            //return right; 
        //}
        //return right - getParagraphLeadingMargin(line);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.963 -0400", hash_original_method = "E5BF73D13B43F74BA21E795D809567BE", hash_generated_method = "B5DC81886C8A1226721B27E190A2E37C")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1844667647 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1844667647;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.978 -0400", hash_original_method = "CAFF1C73D2C9EA6C410B2B2D519C8AC7", hash_generated_method = "77D08689A4B20FEF5AF931A89E42D029")
    protected final boolean isSpanned() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_308810333 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_308810333;
        // ---------- Original Method ----------
        //return mSpannedText;
    }

    
        static <T> T[] getParagraphSpans(Spanned text, int start, int end, Class<T> type) {
        if (start == end && start > 0) {
            return (T[]) ArrayUtils.emptyArray(type);
        }
        return text.getSpans(start, end, type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.985 -0400", hash_original_method = "0902B773EC3014719EA37A51347EC9C6", hash_generated_method = "E76FF6587C872387FBBF08A2BB21D569")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.001 -0400", hash_original_field = "969B4F08C6A411180F291ECE7B5A3D28", hash_generated_field = "8DF1795EE4BFA46EFF29A588C85F9451")

        private int[] mStops;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.001 -0400", hash_original_field = "EAD340360070F0A190E57144293C5C2B", hash_generated_field = "2A878E7FB3BADF740089FE25D0D2CFB0")

        private int mNumStops;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.001 -0400", hash_original_field = "B954C9EDAC21852B96AD8DA47FB0BB4A", hash_generated_field = "1B34C3EF06331C9557133D8E11D29298")

        private int mIncrement;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.002 -0400", hash_original_method = "56D1FFBFF7D6B6649609A0E9FF6888AB", hash_generated_method = "DEEECE78FD66DADB3A00A557295014C2")
          TabStops(int increment, Object[] spans) {
            reset(increment, spans);
            addTaint(increment);
            addTaint(spans[0].getTaint());
            // ---------- Original Method ----------
            //reset(increment, spans);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.278 -0400", hash_original_method = "12BC3A9AA4E5F32DB7C736F6D72E4602", hash_generated_method = "C8D6425D9382ADEBA285A00F8EE3E8A1")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.287 -0400", hash_original_method = "A46080BC8F3B4D3099E262DAA9B4728B", hash_generated_method = "02CB73028E9F67E5040BB591CBAFB121")
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
            float varA772933572361B833B090C93A4B38B40_207522801 = (nextDefaultStop(h, mIncrement));
            addTaint(h);
            float var546ADE640B6EDFBC8A086EF31347E768_232548382 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_232548382;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.293 -0400", hash_original_field = "C5BE317E362FA3A0C2C3E5FEF24D93D8", hash_generated_field = "75E76BC0D205B7AB08D04B9BD6A8D5F6")

        int[] mDirections;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.293 -0400", hash_original_method = "DA94802578AA1A107A88665DAAC4811A", hash_generated_method = "C362AB05F4F382AB8B2A847D6ACC1E92")
          Directions(int[] dirs) {
            mDirections = dirs;
            // ---------- Original Method ----------
            //mDirections = dirs;
        }

        
    }


    
    static class Ellipsizer implements CharSequence, GetChars {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.293 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "A59BBC07E5E46996D793B2F37E80BD24")

        CharSequence mText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.294 -0400", hash_original_field = "AF58F50E47532278404C3D8470630FC4", hash_generated_field = "99107F82B615317EF9A2721652F6B828")

        Layout mLayout;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.294 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "AF6410B200BC05DCA2CF0BE65165448A")

        int mWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.303 -0400", hash_original_field = "411D2DFDB93368C46AFADBEC76A54162", hash_generated_field = "1AEFAC3E5E60C9DA6FF9B1E24BF26D63")

        TextUtils.TruncateAt mMethod;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.304 -0400", hash_original_method = "991CD3860414493D5159CDEA8946E94D", hash_generated_method = "D2DA4A1117D0439320B581750375AE47")
        public  Ellipsizer(CharSequence s) {
            mText = s;
            // ---------- Original Method ----------
            //mText = s;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.305 -0400", hash_original_method = "D253D2AD2D0DACD122596323ACBBAF25", hash_generated_method = "C0D819F7DBA65A674A263D132814CE7C")
        public char charAt(int off) {
            char[] buf;
            buf = TextUtils.obtain(1);
            getChars(off, off + 1, buf, 0);
            char ret;
            ret = buf[0];
            TextUtils.recycle(buf);
            addTaint(off);
            char varA87DEB01C5F539E6BDA34829C8EF2368_994741103 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_994741103;
            // ---------- Original Method ----------
            //char[] buf = TextUtils.obtain(1);
            //getChars(off, off + 1, buf, 0);
            //char ret = buf[0];
            //TextUtils.recycle(buf);
            //return ret;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.329 -0400", hash_original_method = "F2DBD2F3D78F3955B1714BB078A793F8", hash_generated_method = "FE24C4C12EDC7A6AB235259065548642")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.330 -0400", hash_original_method = "9A68249D01A4FE1CBD4D535668FCEB6F", hash_generated_method = "C2F1DC38D38849E98B6B69AD1C7E4180")
        public int length() {
            int varE8711A0ED7EDCE918346EA0F2DE620ED_1787288455 = (mText.length());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_729147971 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_729147971;
            // ---------- Original Method ----------
            //return mText.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.349 -0400", hash_original_method = "019151395F1B77A008AA178A5A5CA402", hash_generated_method = "9EC426181EB302C0C7798DC95CFB57D3")
        public CharSequence subSequence(int start, int end) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_457652094 = null; //Variable for return #1
            char[] s;
            s = new char[end - start];
            getChars(start, end, s, 0);
            varB4EAC82CA7396A68D541C85D26508E83_457652094 = new String(s);
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_457652094.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_457652094;
            // ---------- Original Method ----------
            //char[] s = new char[end - start];
            //getChars(start, end, s, 0);
            //return new String(s);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.351 -0400", hash_original_method = "8ED281151745D3FC40324C23FDF16D10", hash_generated_method = "891DCB160E23256E3903EC06606B2DA4")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1946934201 = null; //Variable for return #1
            char[] s;
            s = new char[length()];
            getChars(0, length(), s, 0);
            varB4EAC82CA7396A68D541C85D26508E83_1946934201 = new String(s);
            varB4EAC82CA7396A68D541C85D26508E83_1946934201.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1946934201;
            // ---------- Original Method ----------
            //char[] s = new char[length()];
            //getChars(0, length(), s, 0);
            //return new String(s);
        }

        
    }


    
    static class SpannedEllipsizer extends Ellipsizer implements Spanned {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.351 -0400", hash_original_field = "2A174ADD3219E7DC0B72155FF67EC4B5", hash_generated_field = "69C78554F8ABB9B2C492FD314F3ED2EE")

        private Spanned mSpanned;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.353 -0400", hash_original_method = "F42AC9AEDB79FF2719E5DE12CF0CD85E", hash_generated_method = "521E0E4859CABE811C363188B0E6F44F")
        public  SpannedEllipsizer(CharSequence display) {
            super(display);
            mSpanned = (Spanned) display;
            // ---------- Original Method ----------
            //mSpanned = (Spanned) display;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.365 -0400", hash_original_method = "E8AB479016A2E00AFF48AA43F345FA2A", hash_generated_method = "BAB29F2F6EB446C39108730481622669")
        public <T> T[] getSpans(int start, int end, Class<T> type) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_973339395 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_973339395 = mSpanned.getSpans(start, end, type);
            addTaint(start);
            addTaint(end);
            addTaint(type.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_973339395.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_973339395;
            // ---------- Original Method ----------
            //return mSpanned.getSpans(start, end, type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.366 -0400", hash_original_method = "2071284CDE64572D4D3F80F80EB4C823", hash_generated_method = "000DE2A9B6554D363C75675D4574826F")
        public int getSpanStart(Object tag) {
            int varD7924E7B7A12FA5A3B050A8325F5D9BE_1683538172 = (mSpanned.getSpanStart(tag));
            addTaint(tag.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1708669563 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1708669563;
            // ---------- Original Method ----------
            //return mSpanned.getSpanStart(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.366 -0400", hash_original_method = "B1DC38D90632AE4EB220020E4C5B16DF", hash_generated_method = "8A18E5B2AAFC49B6682BA35E2ECD2B08")
        public int getSpanEnd(Object tag) {
            int varFDD9D023F9FB8A63C470934B7C2E8224_1724812917 = (mSpanned.getSpanEnd(tag));
            addTaint(tag.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_384636255 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_384636255;
            // ---------- Original Method ----------
            //return mSpanned.getSpanEnd(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.366 -0400", hash_original_method = "A386D5CC8A9C15386840381A75E4D6FD", hash_generated_method = "44879F0CB5EB38062F4D918730069D1A")
        public int getSpanFlags(Object tag) {
            int var689A4E26E56E6EC55263E3776149ED4A_784530127 = (mSpanned.getSpanFlags(tag));
            addTaint(tag.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_808930501 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_808930501;
            // ---------- Original Method ----------
            //return mSpanned.getSpanFlags(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.368 -0400", hash_original_method = "AF35DA8DF947D9C1330368703ECE15BE", hash_generated_method = "8201990A1BEC633055D3084564F0F842")
        public int nextSpanTransition(int start, int limit, Class type) {
            int varF2EB81A12DD76D71166CCB6A597BD229_657115272 = (mSpanned.nextSpanTransition(start, limit, type));
            addTaint(start);
            addTaint(limit);
            addTaint(type.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1283227079 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1283227079;
            // ---------- Original Method ----------
            //return mSpanned.nextSpanTransition(start, limit, type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.383 -0400", hash_original_method = "16B37527DFF576A9EB476E4EC2A69F5D", hash_generated_method = "F31A6D06BE4E908A11ED74A55A534716")
        @Override
        public CharSequence subSequence(int start, int end) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1192466471 = null; //Variable for return #1
            char[] s;
            s = new char[end - start];
            getChars(start, end, s, 0);
            SpannableString ss;
            ss = new SpannableString(new String(s));
            TextUtils.copySpansFrom(mSpanned, start, end, Object.class, ss, 0);
            varB4EAC82CA7396A68D541C85D26508E83_1192466471 = ss;
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_1192466471.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1192466471;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.383 -0400", hash_original_field = "9588EEAF34B7EF093B8A162F81FAFD3E", hash_generated_field = "69FD02F698813F89D672E026360CF250")

    private static ParagraphStyle[] NO_PARA_SPANS = ArrayUtils.emptyArray(ParagraphStyle.class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.383 -0400", hash_original_field = "C98EF14E21465DCAA8481165D4FC8D06", hash_generated_field = "F90D3079BBC6277ED835E213A47BCB3B")

    static EmojiFactory EMOJI_FACTORY = EmojiFactory.newAvailableInstance();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.383 -0400", hash_original_field = "471F949A3986C3F4EDFE65343195112B", hash_generated_field = "50981D9CDB8FFE37DD0AD7398C887F29")

    static int MIN_EMOJI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.383 -0400", hash_original_field = "9BA5E1F2A793A8D05CB1371A5403608D", hash_generated_field = "2FF41CCD8E77FA54D79A8CE87AE76CE2")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.384 -0400", hash_original_field = "C4A38C1668AF8A793012B43F6161CD16", hash_generated_field = "514D1A6C1A71333DF75A0E24E315F81B")

    private static Rect sTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.384 -0400", hash_original_field = "6FD91A9995B8B5FC3C8F7C455B83B35F", hash_generated_field = "52D12843713C54C6D6FE037A484C039E")

    public static final int DIR_LEFT_TO_RIGHT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.384 -0400", hash_original_field = "17318FEC2191C074ECAABD2C38659B46", hash_generated_field = "E624F93AD27646BB22CB05444CE41FB7")

    public static final int DIR_RIGHT_TO_LEFT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.384 -0400", hash_original_field = "137CDBC203F61667CC7E67D68F89D874", hash_generated_field = "04B58C4AD9C676FB649C271AB0BBD08B")

    static int DIR_REQUEST_LTR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.384 -0400", hash_original_field = "7BC355A5AAD6E5EADBC6B5C81FF9EFE0", hash_generated_field = "CEC985F3F0542051E78EF4035E8CF8FB")

    static int DIR_REQUEST_RTL = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.384 -0400", hash_original_field = "E08042CAD555C940FA4820833C645893", hash_generated_field = "C8869540BB823E962D2E476A9DF83246")

    static int DIR_REQUEST_DEFAULT_LTR = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.384 -0400", hash_original_field = "2BC912CEB718B45E37D43B9DD28FCA06", hash_generated_field = "40886990965E0E17283430757C23B125")

    static int DIR_REQUEST_DEFAULT_RTL = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.384 -0400", hash_original_field = "39D3AAFD530E8474E92C1E2B18BF315E", hash_generated_field = "F0384740E00EB75C684162162E40B7FF")

    static int RUN_LENGTH_MASK = 0x03ffffff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.384 -0400", hash_original_field = "039DB298A48FCCC6EC38DF1E608B281F", hash_generated_field = "A8027E62CEAF54311606759B2C7DA149")

    static int RUN_LEVEL_SHIFT = 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.384 -0400", hash_original_field = "75A423C35DF8A3E743B55A65B5C563B8", hash_generated_field = "78AD13AD300C52CA3BBB49A91D9298E0")

    static int RUN_LEVEL_MASK = 0x3f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.384 -0400", hash_original_field = "582E27236495D028F8DEF24E0A548B5E", hash_generated_field = "81D5396BD7EABD64A973642EEDAC362B")

    static int RUN_RTL_FLAG = 1 << RUN_LEVEL_SHIFT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.384 -0400", hash_original_field = "5857BDFF3BF33113730586AF5B28164F", hash_generated_field = "BD4519227226DE6CF8B5B95534D34642")

    private static int TAB_INCREMENT = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.385 -0400", hash_original_field = "016F06FA5D76A8D90674CD58FE50F840", hash_generated_field = "3AD3B5A918E4FC41B99EDADED565DFB3")

    static Directions DIRS_ALL_LEFT_TO_RIGHT = new Directions(new int[] { 0, RUN_LENGTH_MASK });
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:41.385 -0400", hash_original_field = "B75F87DE53400F9F37765D0FDC63007E", hash_generated_field = "46ABB9D648D50C05DDF53405C76D742E")

    static Directions DIRS_ALL_RIGHT_TO_LEFT = new Directions(new int[] { 0, RUN_LENGTH_MASK | RUN_RTL_FLAG });
}

