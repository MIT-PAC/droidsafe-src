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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.940 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "E579ED9F2DADADEB46C981CAFDEE5BA5")

    private CharSequence mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.941 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "B5BC396C7010734D6B4B6ED34A2846AE")

    private TextPaint mPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.941 -0400", hash_original_field = "B3CE09DC80997D762CCFEE11916EE7B6", hash_generated_field = "B28AC88C47D899E85CEE0110DCCDCA16")

    TextPaint mWorkPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.941 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

    private int mWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.941 -0400", hash_original_field = "016218732B28025C6B752A3B2A457113", hash_generated_field = "A5FBEE576828FD767B418A1715D12197")

    private Alignment mAlignment = Alignment.ALIGN_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.941 -0400", hash_original_field = "DD430150592EA7FB656F57A5D9A5C479", hash_generated_field = "0C2C39C12F42C181B35D16CF7D81A703")

    private float mSpacingMult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.941 -0400", hash_original_field = "18DE4355EE7ABBEF3185EC1003DD341A", hash_generated_field = "733F92CD6EAB2F9CA67542D073A49D69")

    private float mSpacingAdd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.941 -0400", hash_original_field = "9AAB51E3E9F2DBF3923317511559B1D1", hash_generated_field = "9735AD2A3473CB2D7DEA16EAA46F6EFB")

    private boolean mSpannedText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.941 -0400", hash_original_field = "056B2B67A5D743296E35F6A88B022318", hash_generated_field = "720F1C3BB08BF46839EBBA716D35B07F")

    private TextDirectionHeuristic mTextDir;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.941 -0400", hash_original_method = "DA432A00E31F4EFC04FE32B9AEC1CEE4", hash_generated_method = "497D43F984F908C615AC7DDCD4AB47FF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.941 -0400", hash_original_method = "E08E539EEFF1AD274546B85662DC9DCC", hash_generated_method = "C73F246C622EAA9054FDA8F78297DAC1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.945 -0400", hash_original_method = "4BA809AE232557C36D4CE5AE6E36D4D2", hash_generated_method = "BBAF0084E8D40C760639B9BEAB427E56")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.946 -0400", hash_original_method = "21986991A7FC788A39082240DAE8B9C3", hash_generated_method = "A7DBF3BE15A320D6F69E02741972F077")
    public void draw(Canvas c) {
        draw(c, null, null, 0);
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //draw(c, null, null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.948 -0400", hash_original_method = "C63D8686FF6D60F338825542CA174C93", hash_generated_method = "B3F3D4326419E35B21A718ACB0B0DAA5")
    public void draw(Canvas c, Path highlight, Paint highlightPaint,
                     int cursorOffsetVertical) {
        int dtop;
        int dbottom;
        {
            {
                boolean varC42A531B776DA8F33EFB072E74A6FC1E_790243001 = (!c.getClipBounds(sTempRect));
            } //End collapsed parenthetic
            dtop = sTempRect.top;
            dbottom = sTempRect.bottom;
        } //End block
        int top = 0;
        int bottom = getLineTop(getLineCount());
        {
            top = dtop;
        } //End block
        {
            bottom = dbottom;
        } //End block
        int first = getLineForVertical(top);
        int last = getLineForVertical(bottom);
        int previousLineBottom = getLineTop(first);
        int previousLineEnd = getLineStart(first);
        TextPaint paint = mPaint;
        CharSequence buf = mText;
        int width = mWidth;
        boolean spannedText = mSpannedText;
        ParagraphStyle[] spans = NO_PARA_SPANS;
        int spanEnd = 0;
        int textLength = 0;
        {
            Spanned sp = (Spanned) buf;
            textLength = buf.length();
            {
                int i = first;
                {
                    int start = previousLineEnd;
                    int end = getLineStart(i+1);
                    previousLineEnd = end;
                    int ltop = previousLineBottom;
                    int lbottom = getLineTop(i+1);
                    previousLineBottom = lbottom;
                    int lbaseline = lbottom - getLineDescent(i);
                    {
                        spanEnd = sp.nextSpanTransition(start, textLength,
                            LineBackgroundSpan.class);
                        spans = getParagraphSpans(sp, start, end, LineBackgroundSpan.class);
                    } //End block
                    {
                        int n = 0;
                        {
                            LineBackgroundSpan back = (LineBackgroundSpan) spans[n];
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
        Alignment paraAlign = mAlignment;
        TabStops tabStops = null;
        boolean tabStopsIsInitialized = false;
        TextLine tl = TextLine.obtain();
        {
            int i = first;
            {
                int start = previousLineEnd;
                previousLineEnd = getLineStart(i+1);
                int end = getLineVisibleEnd(i, start, previousLineEnd);
                int ltop = previousLineBottom;
                int lbottom = getLineTop(i+1);
                previousLineBottom = lbottom;
                int lbaseline = lbottom - getLineDescent(i);
                int dir = getParagraphDirection(i);
                int left = 0;
                int right = mWidth;
                {
                    Spanned sp = (Spanned) buf;
                    boolean isFirstParaLine = (start == 0 ||
                        buf.charAt(start - 1) == '\n');
                    {
                        spanEnd = sp.nextSpanTransition(start, textLength,
                                                    ParagraphStyle.class);
                        spans = getParagraphSpans(sp, start, spanEnd, ParagraphStyle.class);
                        paraAlign = mAlignment;
                        {
                            int n = spans.length-1;
                            {
                                {
                                    paraAlign = ((AlignmentSpan) spans[n]).getAlignment();
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                        tabStopsIsInitialized = false;
                    } //End block
                    final int length = spans.length;
                    {
                        int n = 0;
                        {
                            {
                                LeadingMarginSpan margin = (LeadingMarginSpan) spans[n];
                                boolean useFirstLineMargin = isFirstParaLine;
                                {
                                    int count = ((LeadingMarginSpan2) margin).getLeadingMarginLineCount();
                                    int startLine = getLineForOffset(sp.getSpanStart(margin));
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
                boolean hasTabOrEmoji = getLineContainsTab(i);
                {
                    {
                        tabStops = new TabStops(TAB_INCREMENT, spans);
                    } //End block
                    {
                        tabStops.reset(TAB_INCREMENT, spans);
                    } //End block
                    tabStopsIsInitialized = true;
                } //End block
                Alignment align = paraAlign;
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
                    int max = (int)getLineExtent(i, tabStops, false);
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
                Directions directions = getLineDirections(i);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.948 -0400", hash_original_method = "94C8B0A33C8A9972488E17891E7B8BAC", hash_generated_method = "581EAD93136AF0ABFD92CEB118F52503")
    private int getLineStartPos(int line, int left, int right) {
        Alignment align = getParagraphAlignment(line);
        int dir = getParagraphDirection(line);
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
            TabStops tabStops = null;
            {
                boolean varEBDDE922AE0589A6CEAD24B0AC5E6B48_1686405580 = (mSpannedText && getLineContainsTab(line));
                {
                    Spanned spanned = (Spanned) mText;
                    int start = getLineStart(line);
                    int spanEnd = spanned.nextSpanTransition(start, spanned.length(),
                        TabStopSpan.class);
                    TabStopSpan[] tabSpans = getParagraphSpans(spanned, start, spanEnd, TabStopSpan.class);
                    {
                        tabStops = new TabStops(TAB_INCREMENT, tabSpans);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            int max = (int)getLineExtent(line, tabStops, false);
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1292166613 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1292166613;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.949 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "2E85A9E0AB5935BFE66D56DF43045435")
    public final CharSequence getText() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1454853862 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1454853862 = mText;
        varB4EAC82CA7396A68D541C85D26508E83_1454853862.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1454853862;
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.950 -0400", hash_original_method = "7064C5093467A23605D5C425E4D25B83", hash_generated_method = "5F654E77FB419D64150B93349CCBD130")
    public final TextPaint getPaint() {
        TextPaint varB4EAC82CA7396A68D541C85D26508E83_650910241 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_650910241 = mPaint;
        varB4EAC82CA7396A68D541C85D26508E83_650910241.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_650910241;
        // ---------- Original Method ----------
        //return mPaint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.950 -0400", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "04A98E252F72E73869AD9E1E793EAE03")
    public final int getWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_256263696 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_256263696;
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.950 -0400", hash_original_method = "90F96A059D406483E44444E82D555D1F", hash_generated_method = "782E3AA121973F6AE0E5AF0FF90B3D16")
    public int getEllipsizedWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_462555178 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_462555178;
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.950 -0400", hash_original_method = "461CE12B89AFCA61718D5C5F590357B0", hash_generated_method = "8CE222B19DC30D9434620F2E598C23A9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.951 -0400", hash_original_method = "5212B162F472F11B6A60B5BD891C860A", hash_generated_method = "F75E9467A7297A00A4323B11BBA4A765")
    public int getHeight() {
        int var7ED7F6E2EB0B1BC7A56013BEE63A9A35_1422186985 = (getLineTop(getLineCount()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33818243 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33818243;
        // ---------- Original Method ----------
        //return getLineTop(getLineCount());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.951 -0400", hash_original_method = "FB2D4D43E3EFDD971010AB3AFA49B442", hash_generated_method = "096A7FF0ECFA74F90C92AAE3353C88CD")
    public final Alignment getAlignment() {
        Alignment varB4EAC82CA7396A68D541C85D26508E83_1634605809 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1634605809 = mAlignment;
        varB4EAC82CA7396A68D541C85D26508E83_1634605809.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1634605809;
        // ---------- Original Method ----------
        //return mAlignment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.952 -0400", hash_original_method = "F861D6694D511E0A8AF4CE2A5552F333", hash_generated_method = "9386D2D9C5D705125686EA5EDBFC4E0A")
    public final float getSpacingMultiplier() {
        float var546ADE640B6EDFBC8A086EF31347E768_214512433 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_214512433;
        // ---------- Original Method ----------
        //return mSpacingMult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.952 -0400", hash_original_method = "E15AF37508F3C3C8F31DF2917343152C", hash_generated_method = "E4E9BA2573AA50912575AB9E9BECD10F")
    public final float getSpacingAdd() {
        float var546ADE640B6EDFBC8A086EF31347E768_2105679272 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2105679272;
        // ---------- Original Method ----------
        //return mSpacingAdd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.952 -0400", hash_original_method = "CEF29A1F61D81E3972548E19A0D7158C", hash_generated_method = "7F38C5D54F4F5F04174237C0C8B42B79")
    public final TextDirectionHeuristic getTextDirectionHeuristic() {
        TextDirectionHeuristic varB4EAC82CA7396A68D541C85D26508E83_1983998928 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1983998928 = mTextDir;
        varB4EAC82CA7396A68D541C85D26508E83_1983998928.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1983998928;
        // ---------- Original Method ----------
        //return mTextDir;
    }

    
    public abstract int getLineCount();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.953 -0400", hash_original_method = "6295516BE4612811C14BD1DCED80BAB8", hash_generated_method = "39F20FDBA3139B836560F7258074BCA6")
    public int getLineBounds(int line, Rect bounds) {
        {
            bounds.left = 0;
            bounds.top = getLineTop(line);
            bounds.right = mWidth;
            bounds.bottom = getLineTop(line + 1);
        } //End block
        int var29FD769CAB68A42F60CF514C827201BE_812406830 = (getLineBaseline(line));
        addTaint(line);
        addTaint(bounds.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_498446045 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_498446045;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.956 -0400", hash_original_method = "2C3949CE81E6BE871356E85B216A576F", hash_generated_method = "736ACD6118886C1D294F0C89DF385F26")
    public boolean isLevelBoundary(int offset) {
        int line = getLineForOffset(offset);
        Directions dirs = getLineDirections(line);
        int[] runs = dirs.mDirections;
        int lineStart = getLineStart(line);
        int lineEnd = getLineEnd(line);
        {
            int paraLevel;
            boolean varEEB6B6B705B0C78401688F613A79E083_635131892 = (getParagraphDirection(line) == 1);
            paraLevel = 0;
            paraLevel = 1;
            int runIndex;
            runIndex = 0;
            runIndex = runs.length - 2;
        } //End block
        offset -= lineStart;
        {
            int i = 0;
            i += 2;
        } //End collapsed parenthetic
        addTaint(offset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_789347183 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_789347183;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.957 -0400", hash_original_method = "AF5CCAD1718916CFF1EB4C8EF2E12FAE", hash_generated_method = "258F72FADF732A65D62A0470C45F420F")
    public boolean isRtlCharAt(int offset) {
        int line = getLineForOffset(offset);
        Directions dirs = getLineDirections(line);
        int[] runs = dirs.mDirections;
        int lineStart = getLineStart(line);
        {
            int i = 0;
            i += 2;
            {
                int start = lineStart + (runs[i] & RUN_LENGTH_MASK);
                {
                    int level = (runs[i+1] >>> RUN_LEVEL_SHIFT) & RUN_LEVEL_MASK;
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(offset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_554090503 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_554090503;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.958 -0400", hash_original_method = "2802B19F8A9E2D0D463FD305FA66136A", hash_generated_method = "4BE1174CB7C226ED00E2365A75B3AEE3")
    private boolean primaryIsTrailingPrevious(int offset) {
        int line = getLineForOffset(offset);
        int lineStart = getLineStart(line);
        int lineEnd = getLineEnd(line);
        int[] runs = getLineDirections(line).mDirections;
        int levelAt = -1;
        {
            int i = 0;
            i += 2;
            {
                int start = lineStart + runs[i];
                int limit = start + (runs[i+1] & RUN_LENGTH_MASK);
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
        int levelBefore = -1;
        {
            levelBefore = getParagraphDirection(line) == 1 ? 0 : 1;
        } //End block
        {
            offset -= 1;
            {
                int i = 0;
                i += 2;
                {
                    int start = lineStart + runs[i];
                    int limit = start + (runs[i+1] & RUN_LENGTH_MASK);
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1156533450 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1156533450;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.958 -0400", hash_original_method = "80ABC300097314837E01431F08FED39C", hash_generated_method = "8E388975B0B5DC033FED53653E1E82F0")
    public float getPrimaryHorizontal(int offset) {
        boolean trailing = primaryIsTrailingPrevious(offset);
        float var58B325E5B7FB5DC54EFDE69C8EB888FB_1642841843 = (getHorizontal(offset, trailing));
        addTaint(offset);
        float var546ADE640B6EDFBC8A086EF31347E768_417230061 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_417230061;
        // ---------- Original Method ----------
        //boolean trailing = primaryIsTrailingPrevious(offset);
        //return getHorizontal(offset, trailing);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.959 -0400", hash_original_method = "5EA78F3566FFC0563802F8455C66332C", hash_generated_method = "188E87A0C8B170FD36F307AFBCD499AB")
    public float getSecondaryHorizontal(int offset) {
        boolean trailing = primaryIsTrailingPrevious(offset);
        float var88A0B1B7EB4DA5EBC1FC42BFB863BDDB_928480254 = (getHorizontal(offset, !trailing));
        addTaint(offset);
        float var546ADE640B6EDFBC8A086EF31347E768_1357724643 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1357724643;
        // ---------- Original Method ----------
        //boolean trailing = primaryIsTrailingPrevious(offset);
        //return getHorizontal(offset, !trailing);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.959 -0400", hash_original_method = "A6F47D9472D86FF595A17085495F07A6", hash_generated_method = "D754D04C1174681098FBB858F60FB116")
    private float getHorizontal(int offset, boolean trailing) {
        int line = getLineForOffset(offset);
        float varE96D4127286387DC83C70FBC1CFA8E14_1313296707 = (getHorizontal(offset, trailing, line));
        addTaint(offset);
        addTaint(trailing);
        float var546ADE640B6EDFBC8A086EF31347E768_505983689 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_505983689;
        // ---------- Original Method ----------
        //int line = getLineForOffset(offset);
        //return getHorizontal(offset, trailing, line);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.960 -0400", hash_original_method = "B47A0ABADD57DE266AAF87A7E699E873", hash_generated_method = "110BA78F5644AD4568B4CB272208B433")
    private float getHorizontal(int offset, boolean trailing, int line) {
        int start = getLineStart(line);
        int end = getLineEnd(line);
        int dir = getParagraphDirection(line);
        boolean hasTabOrEmoji = getLineContainsTab(line);
        Directions directions = getLineDirections(line);
        TabStops tabStops = null;
        {
            TabStopSpan[] tabs = getParagraphSpans((Spanned) mText, start, end, TabStopSpan.class);
            {
                tabStops = new TabStops(TAB_INCREMENT, tabs);
            } //End block
        } //End block
        TextLine tl = TextLine.obtain();
        tl.set(mPaint, mText, start, end, dir, directions, hasTabOrEmoji, tabStops);
        float wid = tl.measure(offset - start, trailing, null);
        TextLine.recycle(tl);
        int left = getParagraphLeft(line);
        int right = getParagraphRight(line);
        float var4B4FA8270CE482A0F053465908FBE10D_728890426 = (getLineStartPos(line, left, right) + wid);
        addTaint(offset);
        addTaint(trailing);
        addTaint(line);
        float var546ADE640B6EDFBC8A086EF31347E768_1685300933 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1685300933;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.960 -0400", hash_original_method = "185391EA60FA7533A9126C3E791BF275", hash_generated_method = "CF7E8AF2053D426B66084447B273FF09")
    public float getLineLeft(int line) {
        int dir = getParagraphDirection(line);
        Alignment align = getParagraphAlignment(line);
        {
            float var98F794A324A0919CA2BAAE75E672BC61_1066681349 = (getParagraphRight(line) - getLineMax(line));
        } //End block
        {
            float varB6842D18BAF51681C1C350FBC007B514_598263152 = (mWidth - getLineMax(line));
        } //End block
        {
            float varB6842D18BAF51681C1C350FBC007B514_890745296 = (mWidth - getLineMax(line));
        } //End block
        {
            int left = getParagraphLeft(line);
            int right = getParagraphRight(line);
            int max = ((int) getLineMax(line)) & ~1;
        } //End block
        addTaint(line);
        float var546ADE640B6EDFBC8A086EF31347E768_86656803 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_86656803;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.961 -0400", hash_original_method = "D344E3703EA76C4344B547792AB00F8E", hash_generated_method = "1A2F15D066FCA1CB83CAA3D60580177A")
    public float getLineRight(int line) {
        int dir = getParagraphDirection(line);
        Alignment align = getParagraphAlignment(line);
        {
            float varC6136DD4ADABC05AB18240388355DC3F_1614603568 = (getParagraphLeft(line) + getLineMax(line));
        } //End block
        {
            float varC6136DD4ADABC05AB18240388355DC3F_992268429 = (getParagraphLeft(line) + getLineMax(line));
        } //End block
        {
            float varDA3557094C6D55255BC5DF32F9EC5DA6_1488119858 = (getLineMax(line));
        } //End block
        {
            int left = getParagraphLeft(line);
            int right = getParagraphRight(line);
            int max = ((int) getLineMax(line)) & ~1;
        } //End block
        addTaint(line);
        float var546ADE640B6EDFBC8A086EF31347E768_1830748679 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1830748679;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.961 -0400", hash_original_method = "F9A5FD2221E6CC8B07379CD2792C3C3D", hash_generated_method = "5B6DC36D8DDCE4B0D8139512EBB415E7")
    public float getLineMax(int line) {
        float margin = getParagraphLeadingMargin(line);
        float signedExtent = getLineExtent(line, false);
        addTaint(line);
        float var546ADE640B6EDFBC8A086EF31347E768_1760650428 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1760650428;
        // ---------- Original Method ----------
        //float margin = getParagraphLeadingMargin(line);
        //float signedExtent = getLineExtent(line, false);
        //return margin + signedExtent >= 0 ? signedExtent : -signedExtent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.961 -0400", hash_original_method = "71AEB5E1BA96E910342AC0DBF85E1ED1", hash_generated_method = "1F0A195B57E47A6BA1F80D83B5CB9D2C")
    public float getLineWidth(int line) {
        float margin = getParagraphLeadingMargin(line);
        float signedExtent = getLineExtent(line, true);
        addTaint(line);
        float var546ADE640B6EDFBC8A086EF31347E768_1223470768 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1223470768;
        // ---------- Original Method ----------
        //float margin = getParagraphLeadingMargin(line);
        //float signedExtent = getLineExtent(line, true);
        //return margin + signedExtent >= 0 ? signedExtent : -signedExtent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.962 -0400", hash_original_method = "22E5E0C81FE58627900045F7BF4DB10C", hash_generated_method = "E4F688D695617E9955A585161BE5A25B")
    private float getLineExtent(int line, boolean full) {
        int start = getLineStart(line);
        int end;
        end = getLineEnd(line);
        end = getLineVisibleEnd(line);
        boolean hasTabsOrEmoji = getLineContainsTab(line);
        TabStops tabStops = null;
        {
            TabStopSpan[] tabs = getParagraphSpans((Spanned) mText, start, end, TabStopSpan.class);
            {
                tabStops = new TabStops(TAB_INCREMENT, tabs);
            } //End block
        } //End block
        Directions directions = getLineDirections(line);
        int dir = getParagraphDirection(line);
        TextLine tl = TextLine.obtain();
        tl.set(mPaint, mText, start, end, dir, directions, hasTabsOrEmoji, tabStops);
        float width = tl.metrics(null);
        TextLine.recycle(tl);
        addTaint(line);
        addTaint(full);
        float var546ADE640B6EDFBC8A086EF31347E768_1351468937 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1351468937;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.962 -0400", hash_original_method = "8D693BD7DA670D75D51405BA4AD1D35A", hash_generated_method = "FCAA4A086F287B221588BE5112DF3384")
    private float getLineExtent(int line, TabStops tabStops, boolean full) {
        int start = getLineStart(line);
        int end;
        end = getLineEnd(line);
        end = getLineVisibleEnd(line);
        boolean hasTabsOrEmoji = getLineContainsTab(line);
        Directions directions = getLineDirections(line);
        int dir = getParagraphDirection(line);
        TextLine tl = TextLine.obtain();
        tl.set(mPaint, mText, start, end, dir, directions, hasTabsOrEmoji, tabStops);
        float width = tl.metrics(null);
        TextLine.recycle(tl);
        addTaint(line);
        addTaint(tabStops.getTaint());
        addTaint(full);
        float var546ADE640B6EDFBC8A086EF31347E768_933343127 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_933343127;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.963 -0400", hash_original_method = "10EB5BCC671C8F4E5C56CFC3872691D1", hash_generated_method = "746705ACEA9280382D61D2B906A729B2")
    public int getLineForVertical(int vertical) {
        int high = getLineCount();
        int low = -1;
        int guess;
        {
            guess = (high + low) / 2;
            {
                boolean var61BBF3CF1E0BB57196057707E3B4D6BF_1799429361 = (getLineTop(guess) > vertical);
                high = guess;
                low = guess;
            } //End collapsed parenthetic
        } //End block
        addTaint(vertical);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1053937083 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1053937083;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.963 -0400", hash_original_method = "42BF795D8C0B31EF6FC35C1F4CBE0EBA", hash_generated_method = "8DAD43988B44B81B583A70216693E79D")
    public int getLineForOffset(int offset) {
        int high = getLineCount();
        int low = -1;
        int guess;
        {
            guess = (high + low) / 2;
            {
                boolean var3154698616D95C0A37FAB8F8A883C99B_1661307547 = (getLineStart(guess) > offset);
                high = guess;
                low = guess;
            } //End collapsed parenthetic
        } //End block
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1106270017 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1106270017;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.964 -0400", hash_original_method = "C7C29A2E2D90FB22FF824A86EA8883C4", hash_generated_method = "9397E0ED5C18C34CE9815ADCF0DF6F8D")
    public int getOffsetForHorizontal(int line, float horiz) {
        int max = getLineEnd(line) - 1;
        int min = getLineStart(line);
        Directions dirs = getLineDirections(line);
        {
            boolean varE1129FD6E3F799951EC526B3F962E39B_1086714343 = (line == getLineCount() - 1);
        } //End collapsed parenthetic
        int best = min;
        float bestdist = Math.abs(getPrimaryHorizontal(best) - horiz);
        {
            int i = 0;
            i += 2;
            {
                int here = min + dirs.mDirections[i];
                int there = here + (dirs.mDirections[i+1] & RUN_LENGTH_MASK);
                int swap;
                swap = -1;
                swap = 1;
                there = max;
                int high = there - 1 + 1;
                int low = here + 1 - 1;
                int guess;
                {
                    guess = (high + low) / 2;
                    int adguess = getOffsetAtStartOf(guess);
                    {
                        boolean var598D8798A97CE595A660B245ECEF3FB1_2074297054 = (getPrimaryHorizontal(adguess) * swap >= horiz * swap);
                        high = guess;
                        low = guess;
                    } //End collapsed parenthetic
                } //End block
                low = here + 1;
                {
                    low = getOffsetAtStartOf(low);
                    float dist = Math.abs(getPrimaryHorizontal(low) - horiz);
                    int aft = TextUtils.getOffsetAfter(mText, low);
                    {
                        float other = Math.abs(getPrimaryHorizontal(aft) - horiz);
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
                float dist = Math.abs(getPrimaryHorizontal(here) - horiz);
                {
                    bestdist = dist;
                    best = here;
                } //End block
            } //End block
        } //End collapsed parenthetic
        float dist = Math.abs(getPrimaryHorizontal(max) - horiz);
        {
            bestdist = dist;
            best = max;
        } //End block
        addTaint(line);
        addTaint(horiz);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1634494089 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1634494089;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.965 -0400", hash_original_method = "AEF50F2FA9A7358F560FC7521C77962F", hash_generated_method = "AF43625BF304C910D481F3A56EDAD05C")
    public final int getLineEnd(int line) {
        int var8CC52E19BC990AEB0402BCF31B3C0E24_800663155 = (getLineStart(line + 1));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_908825269 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_908825269;
        // ---------- Original Method ----------
        //return getLineStart(line + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.966 -0400", hash_original_method = "A5D943CCC73667A904F00DFE82793835", hash_generated_method = "45077447CC3F16E294743D8FD2BE14A4")
    public int getLineVisibleEnd(int line) {
        int var62428E356DD4C198AB8841D5C8B61434_1458123216 = (getLineVisibleEnd(line, getLineStart(line), getLineStart(line+1)));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1145842102 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1145842102;
        // ---------- Original Method ----------
        //return getLineVisibleEnd(line, getLineStart(line), getLineStart(line+1));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.967 -0400", hash_original_method = "2B63DEF38DAE998AFE5301FAAC214E4B", hash_generated_method = "FBCE4AF0791E3A557CAEF4F34C147CE1")
    private int getLineVisibleEnd(int line, int start, int end) {
        CharSequence text = mText;
        char ch;
        {
            boolean varE1129FD6E3F799951EC526B3F962E39B_1035615374 = (line == getLineCount() - 1);
        } //End collapsed parenthetic
        {
            ch = text.charAt(end - 1);
        } //End block
        addTaint(line);
        addTaint(start);
        addTaint(end);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_369175019 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_369175019;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.968 -0400", hash_original_method = "230C56044F8D52E3D0BA17DE5C72A914", hash_generated_method = "B480CE8C4517F2C3487E5617B6414078")
    public final int getLineBottom(int line) {
        int var87591D8CFD866D80B89A94BD35FF5C53_2004665206 = (getLineTop(line + 1));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1242066727 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1242066727;
        // ---------- Original Method ----------
        //return getLineTop(line + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.968 -0400", hash_original_method = "BC6E93964E3CCD0D48881D9F9ABB9170", hash_generated_method = "9DE115631DC8BE1927331CF82E5D9328")
    public final int getLineBaseline(int line) {
        int varF759BC48D9E18C48A2D84A1D35A4C202_1100957016 = (getLineTop(line+1) - getLineDescent(line));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669522956 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669522956;
        // ---------- Original Method ----------
        //return getLineTop(line+1) - getLineDescent(line);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.968 -0400", hash_original_method = "577197C969745092B110831C30EF14E9", hash_generated_method = "532DE3970C2023A7302D567C53CFD91B")
    public final int getLineAscent(int line) {
        int var77CECF3AA081362BA73A6FE592826DBA_120936632 = (getLineTop(line) - (getLineTop(line+1) - getLineDescent(line)));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050394867 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050394867;
        // ---------- Original Method ----------
        //return getLineTop(line) - (getLineTop(line+1) - getLineDescent(line));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.969 -0400", hash_original_method = "AA9B5ECC044BD491182BF4F86B4B2DB2", hash_generated_method = "78C486A18E664A98D883BA1FB122F227")
    public int getOffsetToLeftOf(int offset) {
        int var277357E3410E8D01615B66CFEDE5D6BD_2139067146 = (getOffsetToLeftRightOf(offset, true));
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1869673828 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1869673828;
        // ---------- Original Method ----------
        //return getOffsetToLeftRightOf(offset, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.969 -0400", hash_original_method = "684E6D0185E1F1B7C4ABCAB8ADBE45B0", hash_generated_method = "CB0683D076F813B8D7B2E744E909A411")
    public int getOffsetToRightOf(int offset) {
        int var8F86D7AF4916F278DC98BA8E19B1D241_1704601115 = (getOffsetToLeftRightOf(offset, false));
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_103339212 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_103339212;
        // ---------- Original Method ----------
        //return getOffsetToLeftRightOf(offset, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.970 -0400", hash_original_method = "0024CF60F9AAE9E8C390E55EB92D8B7D", hash_generated_method = "65C0A5294FA274421D9177739570116E")
    private int getOffsetToLeftRightOf(int caret, boolean toLeft) {
        int line = getLineForOffset(caret);
        int lineStart = getLineStart(line);
        int lineEnd = getLineEnd(line);
        int lineDir = getParagraphDirection(line);
        boolean lineChanged = false;
        boolean advance = toLeft == (lineDir == DIR_RIGHT_TO_LEFT);
        {
            {
                {
                    boolean var355D79A48691714F7AD418B6FB65073C_1346218908 = (line < getLineCount() - 1);
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
            int newDir = getParagraphDirection(line);
            {
                toLeft = !toLeft;
                lineDir = newDir;
            } //End block
        } //End block
        Directions directions = getLineDirections(line);
        TextLine tl = TextLine.obtain();
        tl.set(mPaint, mText, lineStart, lineEnd, lineDir, directions, false, null);
        caret = lineStart + tl.getOffsetToLeftRightOf(caret - lineStart, toLeft);
        tl = TextLine.recycle(tl);
        addTaint(caret);
        addTaint(toLeft);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1837815184 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1837815184;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.970 -0400", hash_original_method = "F9D5E8173F5C3CA491A1C8A8AE760B93", hash_generated_method = "50DEBC1C3E2B2C8A5B8A75E6503A3CBE")
    private int getOffsetAtStartOf(int offset) {
        CharSequence text = mText;
        char c = text.charAt(offset);
        {
            char c1 = text.charAt(offset - 1);
            offset -= 1;
        } //End block
        {
            ReplacementSpan[] spans = ((Spanned) text).getSpans(offset, offset,
                                                       ReplacementSpan.class);
            {
                int i = 0;
                {
                    int start = ((Spanned) text).getSpanStart(spans[i]);
                    int end = ((Spanned) text).getSpanEnd(spans[i]);
                    offset = start;
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_794254810 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_794254810;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.971 -0400", hash_original_method = "B9C7ED4514D9377B34881167E2C24E2C", hash_generated_method = "A17630C3C618645960779AFA863AF82F")
    public void getCursorPath(int point, Path dest,
                              CharSequence editingBuffer) {
        dest.reset();
        int line = getLineForOffset(point);
        int top = getLineTop(line);
        int bottom = getLineTop(line+1);
        float h1 = getPrimaryHorizontal(point) - 0.5f;
        float h2;
        boolean var35ABFB89C4D7CB3AAB07DF4BC2B8B7DB_778927703 = (isLevelBoundary(point));
        h2 = getSecondaryHorizontal(point) - 0.5f;
        h2 = h1;
        int caps = TextKeyListener.getMetaState(editingBuffer, TextKeyListener.META_SHIFT_ON) |
                   TextKeyListener.getMetaState(editingBuffer, TextKeyListener.META_SELECTING);
        int fn = TextKeyListener.getMetaState(editingBuffer, TextKeyListener.META_ALT_ON);
        int dist = 0;
        {
            dist = (bottom - top) >> 2;
            top += dist;
            bottom -= dist;
        } //End block
        h1 = 0.5f;
        h2 = 0.5f;
        {
            boolean varB967F472C1B8F55EC25126285D862C13_2029523759 = (Float.compare(h1, h2) == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.972 -0400", hash_original_method = "12119B0793FEC64A3F791B69831CA1AC", hash_generated_method = "A96285DB3427FCE61C9D67C32D9FD269")
    private void addSelection(int line, int start, int end,
                              int top, int bottom, Path dest) {
        int linestart = getLineStart(line);
        int lineend = getLineEnd(line);
        Directions dirs = getLineDirections(line);
        {
            boolean varB43E309FBAB2B8F1A4B7179F5EBC83BF_953252256 = (lineend > linestart && mText.charAt(lineend - 1) == '\n');
        } //End collapsed parenthetic
        {
            int i = 0;
            i += 2;
            {
                int here = linestart + dirs.mDirections[i];
                int there = here + (dirs.mDirections[i+1] & RUN_LENGTH_MASK);
                there = lineend;
                {
                    int st = Math.max(start, here);
                    int en = Math.min(end, there);
                    {
                        float h1 = getHorizontal(st, false, line);
                        float h2 = getHorizontal(en, true, line);
                        float left = Math.min(h1, h2);
                        float right = Math.max(h1, h2);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.973 -0400", hash_original_method = "E504AED84523F80835FFB88244A923D5", hash_generated_method = "B5C05579F93011886032548E0F099F12")
    public void getSelectionPath(int start, int end, Path dest) {
        dest.reset();
        {
            int temp = end;
            end = start;
            start = temp;
        } //End block
        int startline = getLineForOffset(start);
        int endline = getLineForOffset(end);
        int top = getLineTop(startline);
        int bottom = getLineBottom(endline);
        {
            addSelection(startline, start, end, top, bottom, dest);
        } //End block
        {
            final float width = mWidth;
            addSelection(startline, start, getLineEnd(startline),
                         top, getLineBottom(startline), dest);
            {
                boolean var641B20D73ACAC5B224EFAB6A2D83DEC5_150210215 = (getParagraphDirection(startline) == DIR_RIGHT_TO_LEFT);
                dest.addRect(getLineLeft(startline), top,
                              0, getLineBottom(startline), Path.Direction.CW);
                dest.addRect(getLineRight(startline), top,
                              width, getLineBottom(startline), Path.Direction.CW);
            } //End collapsed parenthetic
            {
                int i = startline + 1;
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
                boolean var2D05D65F6C53E0529A94B0C267529750_40096483 = (getParagraphDirection(endline) == DIR_RIGHT_TO_LEFT);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.973 -0400", hash_original_method = "8E26BC9825AB85694FDEA00F755B3420", hash_generated_method = "24093663ED09D6C8732944772F3E7543")
    public final Alignment getParagraphAlignment(int line) {
        Alignment varB4EAC82CA7396A68D541C85D26508E83_904585073 = null; //Variable for return #1
        Alignment align = mAlignment;
        {
            Spanned sp = (Spanned) mText;
            AlignmentSpan[] spans = getParagraphSpans(sp, getLineStart(line),
                                                getLineEnd(line),
                                                AlignmentSpan.class);
            int spanLength = spans.length;
            {
                align = spans[spanLength-1].getAlignment();
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_904585073 = align;
        addTaint(line);
        varB4EAC82CA7396A68D541C85D26508E83_904585073.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_904585073;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.974 -0400", hash_original_method = "D8249C79FD486A8037899C5A02304321", hash_generated_method = "FF90E85F3B5CC77A6323D60322DECF00")
    public final int getParagraphLeft(int line) {
        int left = 0;
        int dir = getParagraphDirection(line);
        int var2A867EA544174101A4992A444C3E4549_1266840126 = (getParagraphLeadingMargin(line));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1132883362 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1132883362;
        // ---------- Original Method ----------
        //int left = 0;
        //int dir = getParagraphDirection(line);
        //if (dir == DIR_RIGHT_TO_LEFT || !mSpannedText) {
            //return left; 
        //}
        //return getParagraphLeadingMargin(line);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.974 -0400", hash_original_method = "4AFE65CA85EFF9BA5DD1726E8E021AC9", hash_generated_method = "0BA56B7A343ECC04430430D665BDD01C")
    public final int getParagraphRight(int line) {
        int right = mWidth;
        int dir = getParagraphDirection(line);
        int varFDCC0DBACB708D752171E60779D4D664_631189000 = (right - getParagraphLeadingMargin(line));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1882312581 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1882312581;
        // ---------- Original Method ----------
        //int right = mWidth;
        //int dir = getParagraphDirection(line);
        //if (dir == DIR_LEFT_TO_RIGHT || !mSpannedText) {
            //return right; 
        //}
        //return right - getParagraphLeadingMargin(line);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.975 -0400", hash_original_method = "E5BF73D13B43F74BA21E795D809567BE", hash_generated_method = "A3EF7C5EB0F713F12B1C7E39A3951A4F")
    private int getParagraphLeadingMargin(int line) {
        Spanned spanned = (Spanned) mText;
        int lineStart = getLineStart(line);
        int lineEnd = getLineEnd(line);
        int spanEnd = spanned.nextSpanTransition(lineStart, lineEnd,
                LeadingMarginSpan.class);
        LeadingMarginSpan[] spans = getParagraphSpans(spanned, lineStart, spanEnd,
                                                LeadingMarginSpan.class);
        int margin = 0;
        boolean isFirstParaLine = lineStart == 0 ||
            spanned.charAt(lineStart - 1) == '\n';
        {
            int i = 0;
            {
                LeadingMarginSpan span = spans[i];
                boolean useFirstLineMargin = isFirstParaLine;
                {
                    int spStart = spanned.getSpanStart(span);
                    int spanLine = getLineForOffset(spStart);
                    int count = ((LeadingMarginSpan2)span).getLeadingMarginLineCount();
                    useFirstLineMargin = line < spanLine + count;
                } //End block
                margin += span.getLeadingMargin(useFirstLineMargin);
            } //End block
        } //End collapsed parenthetic
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_364086494 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_364086494;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.977 -0400", hash_original_method = "CAFF1C73D2C9EA6C410B2B2D519C8AC7", hash_generated_method = "43946AD50C926AF0BA9988E306E9E0AE")
    protected final boolean isSpanned() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_44618011 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_44618011;
        // ---------- Original Method ----------
        //return mSpannedText;
    }

    
    static <T> T[] getParagraphSpans(Spanned text, int start, int end, Class<T> type) {
        if (start == end && start > 0) {
            return (T[]) ArrayUtils.emptyArray(type);
        }
        return text.getSpans(start, end, type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.978 -0400", hash_original_method = "0902B773EC3014719EA37A51347EC9C6", hash_generated_method = "5C3765CF852A71771876615F64BDB6FB")
    private void ellipsize(int start, int end, int line,
                           char[] dest, int destoff) {
        int ellipsisCount = getEllipsisCount(line);
        int ellipsisStart = getEllipsisStart(line);
        int linestart = getLineStart(line);
        {
            int i = ellipsisStart;
            {
                char c;
                {
                    c = '\u2026';
                } //End block
                {
                    c = '\uFEFF';
                } //End block
                int a = i + linestart;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.979 -0400", hash_original_field = "969B4F08C6A411180F291ECE7B5A3D28", hash_generated_field = "8DF1795EE4BFA46EFF29A588C85F9451")

        private int[] mStops;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.979 -0400", hash_original_field = "EAD340360070F0A190E57144293C5C2B", hash_generated_field = "2A878E7FB3BADF740089FE25D0D2CFB0")

        private int mNumStops;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.979 -0400", hash_original_field = "B954C9EDAC21852B96AD8DA47FB0BB4A", hash_generated_field = "1B34C3EF06331C9557133D8E11D29298")

        private int mIncrement;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.979 -0400", hash_original_method = "56D1FFBFF7D6B6649609A0E9FF6888AB", hash_generated_method = "DEEECE78FD66DADB3A00A557295014C2")
          TabStops(int increment, Object[] spans) {
            reset(increment, spans);
            addTaint(increment);
            addTaint(spans[0].getTaint());
            // ---------- Original Method ----------
            //reset(increment, spans);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.985 -0400", hash_original_method = "12BC3A9AA4E5F32DB7C736F6D72E4602", hash_generated_method = "D9B0FBA92B2B90229BC24F624DD14A40")
         void reset(int increment, Object[] spans) {
            this.mIncrement = increment;
            int ns = 0;
            {
                int[] stops = this.mStops;
                {
                    Object o = spans[0];
                    {
                        {
                            {
                                stops = new int[10];
                            } //End block
                            {
                                int[] nstops = new int[ns * 2];
                                {
                                    int i = 0;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.986 -0400", hash_original_method = "A46080BC8F3B4D3099E262DAA9B4728B", hash_generated_method = "56FD96CF47163F0E6EC71CEA5C35D85D")
         float nextTab(float h) {
            int ns = this.mNumStops;
            {
                int[] stops = this.mStops;
                {
                    int i = 0;
                    {
                        int stop = stops[i];
                    } //End block
                } //End collapsed parenthetic
            } //End block
            float varA772933572361B833B090C93A4B38B40_912119628 = (nextDefaultStop(h, mIncrement));
            addTaint(h);
            float var546ADE640B6EDFBC8A086EF31347E768_2288718 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_2288718;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.986 -0400", hash_original_field = "C5BE317E362FA3A0C2C3E5FEF24D93D8", hash_generated_field = "75E76BC0D205B7AB08D04B9BD6A8D5F6")

        int[] mDirections;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.987 -0400", hash_original_method = "DA94802578AA1A107A88665DAAC4811A", hash_generated_method = "C362AB05F4F382AB8B2A847D6ACC1E92")
          Directions(int[] dirs) {
            mDirections = dirs;
            // ---------- Original Method ----------
            //mDirections = dirs;
        }

        
    }


    
    static class Ellipsizer implements CharSequence, GetChars {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.987 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "A59BBC07E5E46996D793B2F37E80BD24")

        CharSequence mText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.987 -0400", hash_original_field = "AF58F50E47532278404C3D8470630FC4", hash_generated_field = "99107F82B615317EF9A2721652F6B828")

        Layout mLayout;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.987 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "AF6410B200BC05DCA2CF0BE65165448A")

        int mWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.987 -0400", hash_original_field = "411D2DFDB93368C46AFADBEC76A54162", hash_generated_field = "1AEFAC3E5E60C9DA6FF9B1E24BF26D63")

        TextUtils.TruncateAt mMethod;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.987 -0400", hash_original_method = "991CD3860414493D5159CDEA8946E94D", hash_generated_method = "D2DA4A1117D0439320B581750375AE47")
        public  Ellipsizer(CharSequence s) {
            mText = s;
            // ---------- Original Method ----------
            //mText = s;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.988 -0400", hash_original_method = "D253D2AD2D0DACD122596323ACBBAF25", hash_generated_method = "C871F6EC92D19C35814497A2A4891672")
        public char charAt(int off) {
            char[] buf = TextUtils.obtain(1);
            getChars(off, off + 1, buf, 0);
            char ret = buf[0];
            TextUtils.recycle(buf);
            addTaint(off);
            char varA87DEB01C5F539E6BDA34829C8EF2368_397874167 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_397874167;
            // ---------- Original Method ----------
            //char[] buf = TextUtils.obtain(1);
            //getChars(off, off + 1, buf, 0);
            //char ret = buf[0];
            //TextUtils.recycle(buf);
            //return ret;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.988 -0400", hash_original_method = "F2DBD2F3D78F3955B1714BB078A793F8", hash_generated_method = "5B785D88F04054B8D7C91D3F6C55C3E4")
        public void getChars(int start, int end, char[] dest, int destoff) {
            int line1 = mLayout.getLineForOffset(start);
            int line2 = mLayout.getLineForOffset(end);
            TextUtils.getChars(mText, start, end, dest, destoff);
            {
                int i = line1;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.989 -0400", hash_original_method = "9A68249D01A4FE1CBD4D535668FCEB6F", hash_generated_method = "E1273FCDA7DAB016A96BA03BB08ED998")
        public int length() {
            int varE8711A0ED7EDCE918346EA0F2DE620ED_482655808 = (mText.length());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1967139177 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1967139177;
            // ---------- Original Method ----------
            //return mText.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.990 -0400", hash_original_method = "019151395F1B77A008AA178A5A5CA402", hash_generated_method = "F360C679630C039F5B16856ABE8825BB")
        public CharSequence subSequence(int start, int end) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1563415398 = null; //Variable for return #1
            char[] s = new char[end - start];
            getChars(start, end, s, 0);
            varB4EAC82CA7396A68D541C85D26508E83_1563415398 = new String(s);
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_1563415398.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1563415398;
            // ---------- Original Method ----------
            //char[] s = new char[end - start];
            //getChars(start, end, s, 0);
            //return new String(s);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.991 -0400", hash_original_method = "8ED281151745D3FC40324C23FDF16D10", hash_generated_method = "8AB1E96C804862B8000039C8CD652909")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_2056425503 = null; //Variable for return #1
            char[] s = new char[length()];
            getChars(0, length(), s, 0);
            varB4EAC82CA7396A68D541C85D26508E83_2056425503 = new String(s);
            varB4EAC82CA7396A68D541C85D26508E83_2056425503.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2056425503;
            // ---------- Original Method ----------
            //char[] s = new char[length()];
            //getChars(0, length(), s, 0);
            //return new String(s);
        }

        
    }


    
    static class SpannedEllipsizer extends Ellipsizer implements Spanned {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.991 -0400", hash_original_field = "2A174ADD3219E7DC0B72155FF67EC4B5", hash_generated_field = "69C78554F8ABB9B2C492FD314F3ED2EE")

        private Spanned mSpanned;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.992 -0400", hash_original_method = "F42AC9AEDB79FF2719E5DE12CF0CD85E", hash_generated_method = "521E0E4859CABE811C363188B0E6F44F")
        public  SpannedEllipsizer(CharSequence display) {
            super(display);
            mSpanned = (Spanned) display;
            // ---------- Original Method ----------
            //mSpanned = (Spanned) display;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.992 -0400", hash_original_method = "E8AB479016A2E00AFF48AA43F345FA2A", hash_generated_method = "33E44CA204CE90B94C13F13C24892617")
        public <T> T[] getSpans(int start, int end, Class<T> type) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_818201155 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_818201155 = mSpanned.getSpans(start, end, type);
            addTaint(start);
            addTaint(end);
            addTaint(type.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_818201155.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_818201155;
            // ---------- Original Method ----------
            //return mSpanned.getSpans(start, end, type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.993 -0400", hash_original_method = "2071284CDE64572D4D3F80F80EB4C823", hash_generated_method = "C254BA5FB6D0E522B0206FD446C187E0")
        public int getSpanStart(Object tag) {
            int varD7924E7B7A12FA5A3B050A8325F5D9BE_791731363 = (mSpanned.getSpanStart(tag));
            addTaint(tag.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117242750 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117242750;
            // ---------- Original Method ----------
            //return mSpanned.getSpanStart(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.993 -0400", hash_original_method = "B1DC38D90632AE4EB220020E4C5B16DF", hash_generated_method = "CBE86CB4798E1295C640B52083AAFEC9")
        public int getSpanEnd(Object tag) {
            int varFDD9D023F9FB8A63C470934B7C2E8224_1151501297 = (mSpanned.getSpanEnd(tag));
            addTaint(tag.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_668220729 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_668220729;
            // ---------- Original Method ----------
            //return mSpanned.getSpanEnd(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.993 -0400", hash_original_method = "A386D5CC8A9C15386840381A75E4D6FD", hash_generated_method = "1F30FE3C3E35E9CBC5D66ED0F6A01DFE")
        public int getSpanFlags(Object tag) {
            int var689A4E26E56E6EC55263E3776149ED4A_1209801349 = (mSpanned.getSpanFlags(tag));
            addTaint(tag.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1603462340 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1603462340;
            // ---------- Original Method ----------
            //return mSpanned.getSpanFlags(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.994 -0400", hash_original_method = "AF35DA8DF947D9C1330368703ECE15BE", hash_generated_method = "819E1A4A1E68DD0D3CBAF61E76396ACC")
        public int nextSpanTransition(int start, int limit, Class type) {
            int varF2EB81A12DD76D71166CCB6A597BD229_116925188 = (mSpanned.nextSpanTransition(start, limit, type));
            addTaint(start);
            addTaint(limit);
            addTaint(type.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730120379 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730120379;
            // ---------- Original Method ----------
            //return mSpanned.nextSpanTransition(start, limit, type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.994 -0400", hash_original_method = "16B37527DFF576A9EB476E4EC2A69F5D", hash_generated_method = "68D50B58A70979B1EF0D39D849B3086C")
        @Override
        public CharSequence subSequence(int start, int end) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1653348581 = null; //Variable for return #1
            char[] s = new char[end - start];
            getChars(start, end, s, 0);
            SpannableString ss = new SpannableString(new String(s));
            TextUtils.copySpansFrom(mSpanned, start, end, Object.class, ss, 0);
            varB4EAC82CA7396A68D541C85D26508E83_1653348581 = ss;
            addTaint(start);
            addTaint(end);
            varB4EAC82CA7396A68D541C85D26508E83_1653348581.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1653348581;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.994 -0400", hash_original_field = "9588EEAF34B7EF093B8A162F81FAFD3E", hash_generated_field = "FE192F2602DC86D3649552171C1E7D82")

    private static final ParagraphStyle[] NO_PARA_SPANS = ArrayUtils.emptyArray(ParagraphStyle.class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.994 -0400", hash_original_field = "C98EF14E21465DCAA8481165D4FC8D06", hash_generated_field = "C5396A644D87D3ABF8FF4A210231B117")

    static final EmojiFactory EMOJI_FACTORY = EmojiFactory.newAvailableInstance();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.994 -0400", hash_original_field = "471F949A3986C3F4EDFE65343195112B", hash_generated_field = "50981D9CDB8FFE37DD0AD7398C887F29")

    static int MIN_EMOJI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.994 -0400", hash_original_field = "9BA5E1F2A793A8D05CB1371A5403608D", hash_generated_field = "2FF41CCD8E77FA54D79A8CE87AE76CE2")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.995 -0400", hash_original_field = "C4A38C1668AF8A793012B43F6161CD16", hash_generated_field = "AB6A5E15DD892E72F299B4D5FFE1ACBA")

    private static final Rect sTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.995 -0400", hash_original_field = "6FD91A9995B8B5FC3C8F7C455B83B35F", hash_generated_field = "52D12843713C54C6D6FE037A484C039E")

    public static final int DIR_LEFT_TO_RIGHT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.995 -0400", hash_original_field = "17318FEC2191C074ECAABD2C38659B46", hash_generated_field = "E624F93AD27646BB22CB05444CE41FB7")

    public static final int DIR_RIGHT_TO_LEFT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.995 -0400", hash_original_field = "137CDBC203F61667CC7E67D68F89D874", hash_generated_field = "A0CBE122653FD7E9E2403F87AECC077E")

    static final int DIR_REQUEST_LTR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.995 -0400", hash_original_field = "7BC355A5AAD6E5EADBC6B5C81FF9EFE0", hash_generated_field = "2F54902E23F337B8398BD9B8867448B7")

    static final int DIR_REQUEST_RTL = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.995 -0400", hash_original_field = "E08042CAD555C940FA4820833C645893", hash_generated_field = "6BC95B8DA1C0867C5BBC92C545EC37D0")

    static final int DIR_REQUEST_DEFAULT_LTR = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.995 -0400", hash_original_field = "2BC912CEB718B45E37D43B9DD28FCA06", hash_generated_field = "A3F4791226177B1A5BF0E7086C062229")

    static final int DIR_REQUEST_DEFAULT_RTL = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.995 -0400", hash_original_field = "39D3AAFD530E8474E92C1E2B18BF315E", hash_generated_field = "521C40F9C42E64AFA41DE5429A1FE88F")

    static final int RUN_LENGTH_MASK = 0x03ffffff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.995 -0400", hash_original_field = "039DB298A48FCCC6EC38DF1E608B281F", hash_generated_field = "FA295D4D1A0E6B715FE59ACD221F6ADA")

    static final int RUN_LEVEL_SHIFT = 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.995 -0400", hash_original_field = "75A423C35DF8A3E743B55A65B5C563B8", hash_generated_field = "94C9571A3583C54E6B7A075300DD0EE5")

    static final int RUN_LEVEL_MASK = 0x3f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.995 -0400", hash_original_field = "582E27236495D028F8DEF24E0A548B5E", hash_generated_field = "31D3CF26D80AD0E1199B880C73A98D4C")

    static final int RUN_RTL_FLAG = 1 << RUN_LEVEL_SHIFT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.995 -0400", hash_original_field = "5857BDFF3BF33113730586AF5B28164F", hash_generated_field = "D5E340FF9F0E2C74F920DF02A6624213")

    private static final int TAB_INCREMENT = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.995 -0400", hash_original_field = "016F06FA5D76A8D90674CD58FE50F840", hash_generated_field = "C8BA6950A23558C64F9FDDA3186A39D3")

    static final Directions DIRS_ALL_LEFT_TO_RIGHT = new Directions(new int[] { 0, RUN_LENGTH_MASK });
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.995 -0400", hash_original_field = "B75F87DE53400F9F37765D0FDC63007E", hash_generated_field = "F0C0143EECF2B25DCBC74C3BF9B92427")

    static final Directions DIRS_ALL_RIGHT_TO_LEFT = new Directions(new int[] { 0, RUN_LENGTH_MASK | RUN_RTL_FLAG });
}

