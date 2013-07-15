package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.159 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "E579ED9F2DADADEB46C981CAFDEE5BA5")

    private CharSequence mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.159 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "B5BC396C7010734D6B4B6ED34A2846AE")

    private TextPaint mPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.159 -0400", hash_original_field = "B3CE09DC80997D762CCFEE11916EE7B6", hash_generated_field = "B28AC88C47D899E85CEE0110DCCDCA16")

    TextPaint mWorkPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.159 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

    private int mWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.160 -0400", hash_original_field = "016218732B28025C6B752A3B2A457113", hash_generated_field = "A5FBEE576828FD767B418A1715D12197")

    private Alignment mAlignment = Alignment.ALIGN_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.160 -0400", hash_original_field = "DD430150592EA7FB656F57A5D9A5C479", hash_generated_field = "0C2C39C12F42C181B35D16CF7D81A703")

    private float mSpacingMult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.160 -0400", hash_original_field = "18DE4355EE7ABBEF3185EC1003DD341A", hash_generated_field = "733F92CD6EAB2F9CA67542D073A49D69")

    private float mSpacingAdd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.160 -0400", hash_original_field = "9AAB51E3E9F2DBF3923317511559B1D1", hash_generated_field = "9735AD2A3473CB2D7DEA16EAA46F6EFB")

    private boolean mSpannedText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.160 -0400", hash_original_field = "056B2B67A5D743296E35F6A88B022318", hash_generated_field = "720F1C3BB08BF46839EBBA716D35B07F")

    private TextDirectionHeuristic mTextDir;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.160 -0400", hash_original_method = "DA432A00E31F4EFC04FE32B9AEC1CEE4", hash_generated_method = "5C9EE1B990D1CB576C2D75FA059ACD66")
    protected  Layout(CharSequence text, TextPaint paint,
                     int width, Alignment align,
                     float spacingMult, float spacingAdd) {
        this(text, paint, width, align, TextDirectionHeuristics.FIRSTSTRONG_LTR,
                spacingMult, spacingAdd);
        addTaint(spacingAdd);
        addTaint(spacingMult);
        addTaint(align.getTaint());
        addTaint(width);
        addTaint(paint.getTaint());
        addTaint(text.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.162 -0400", hash_original_method = "E08E539EEFF1AD274546B85662DC9DCC", hash_generated_method = "E0B77E806AE56A5A83F441DC526E4367")
    protected  Layout(CharSequence text, TextPaint paint,
                     int width, Alignment align, TextDirectionHeuristic textDir,
                     float spacingMult, float spacingAdd) {
    if(width < 0)        
        {
        IllegalArgumentException var2AB10EE6109DB64C09D46C5396660658_1424549103 = new IllegalArgumentException("Layout: " + width + " < 0");
        var2AB10EE6109DB64C09D46C5396660658_1424549103.addTaint(taint);
        throw var2AB10EE6109DB64C09D46C5396660658_1424549103;
        }
    if(paint != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.164 -0400", hash_original_method = "4BA809AE232557C36D4CE5AE6E36D4D2", hash_generated_method = "85421590E570A3B7856D8019A4F13AA7")
     void replaceWith(CharSequence text, TextPaint paint,
                              int width, Alignment align,
                              float spacingmult, float spacingadd) {
    if(width < 0)        
        {
            IllegalArgumentException var2AB10EE6109DB64C09D46C5396660658_1088830054 = new IllegalArgumentException("Layout: " + width + " < 0");
            var2AB10EE6109DB64C09D46C5396660658_1088830054.addTaint(taint);
            throw var2AB10EE6109DB64C09D46C5396660658_1088830054;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.164 -0400", hash_original_method = "21986991A7FC788A39082240DAE8B9C3", hash_generated_method = "18BC581076394A2B96FC6A3B052E6C09")
    public void draw(Canvas c) {
        addTaint(c.getTaint());
        draw(c, null, null, 0);
        // ---------- Original Method ----------
        //draw(c, null, null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.168 -0400", hash_original_method = "C63D8686FF6D60F338825542CA174C93", hash_generated_method = "8BB226C1E7A31F2957E2A6CF78AF9865")
    public void draw(Canvas c, Path highlight, Paint highlightPaint,
                     int cursorOffsetVertical) {
        addTaint(cursorOffsetVertical);
        addTaint(highlightPaint.getTaint());
        addTaint(highlight.getTaint());
        addTaint(c.getTaint());
        int dtop;
        int dbottom;
        synchronized
(sTempRect)        {
    if(!c.getClipBounds(sTempRect))            
            {
                return;
            } //End block
            dtop = sTempRect.top;
            dbottom = sTempRect.bottom;
        } //End block
        int top = 0;
        int bottom = getLineTop(getLineCount());
    if(dtop > top)        
        {
            top = dtop;
        } //End block
    if(dbottom < bottom)        
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
    if(spannedText)        
        {
            Spanned sp = (Spanned) buf;
            textLength = buf.length();
for(int i = first;i <= last;i++)
            {
                int start = previousLineEnd;
                int end = getLineStart(i+1);
                previousLineEnd = end;
                int ltop = previousLineBottom;
                int lbottom = getLineTop(i+1);
                previousLineBottom = lbottom;
                int lbaseline = lbottom - getLineDescent(i);
    if(start >= spanEnd)                
                {
                    spanEnd = sp.nextSpanTransition(start, textLength,
                            LineBackgroundSpan.class);
                    spans = getParagraphSpans(sp, start, end, LineBackgroundSpan.class);
                } //End block
for(int n = 0;n < spans.length;n++)
                {
                    LineBackgroundSpan back = (LineBackgroundSpan) spans[n];
                    back.drawBackground(c, paint, 0, width,
                                       ltop, lbaseline, lbottom,
                                       buf, start, end,
                                       i);
                } //End block
            } //End block
            spanEnd = 0;
            previousLineBottom = getLineTop(first);
            previousLineEnd = getLineStart(first);
            spans = NO_PARA_SPANS;
        } //End block
    if(highlight != null)        
        {
    if(cursorOffsetVertical != 0)            
            {
                c.translate(0, cursorOffsetVertical);
            } //End block
            c.drawPath(highlight, highlightPaint);
    if(cursorOffsetVertical != 0)            
            {
                c.translate(0, -cursorOffsetVertical);
            } //End block
        } //End block
        Alignment paraAlign = mAlignment;
        TabStops tabStops = null;
        boolean tabStopsIsInitialized = false;
        TextLine tl = TextLine.obtain();
for(int i = first;i <= last;i++)
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
    if(spannedText)            
            {
                Spanned sp = (Spanned) buf;
                boolean isFirstParaLine = (start == 0 ||
                        buf.charAt(start - 1) == '\n');
    if(start >= spanEnd && (i == first || isFirstParaLine))                
                {
                    spanEnd = sp.nextSpanTransition(start, textLength,
                                                    ParagraphStyle.class);
                    spans = getParagraphSpans(sp, start, spanEnd, ParagraphStyle.class);
                    paraAlign = mAlignment;
for(int n = spans.length-1;n >= 0;n--)
                    {
    if(spans[n] instanceof AlignmentSpan)                        
                        {
                            paraAlign = ((AlignmentSpan) spans[n]).getAlignment();
                            break;
                        } //End block
                    } //End block
                    tabStopsIsInitialized = false;
                } //End block
                final int length = spans.length;
for(int n = 0;n < length;n++)
                {
    if(spans[n] instanceof LeadingMarginSpan)                    
                    {
                        LeadingMarginSpan margin = (LeadingMarginSpan) spans[n];
                        boolean useFirstLineMargin = isFirstParaLine;
    if(margin instanceof LeadingMarginSpan2)                        
                        {
                            int count = ((LeadingMarginSpan2) margin).getLeadingMarginLineCount();
                            int startLine = getLineForOffset(sp.getSpanStart(margin));
                            useFirstLineMargin = i < startLine + count;
                        } //End block
    if(dir == DIR_RIGHT_TO_LEFT)                        
                        {
                            margin.drawLeadingMargin(c, paint, right, dir, ltop,
                                                     lbaseline, lbottom, buf,
                                                     start, end, isFirstParaLine, this);
                            right -= margin.getLeadingMargin(useFirstLineMargin);
                        } //End block
                        else
                        {
                            margin.drawLeadingMargin(c, paint, left, dir, ltop,
                                                     lbaseline, lbottom, buf,
                                                     start, end, isFirstParaLine, this);
                            left += margin.getLeadingMargin(useFirstLineMargin);
                        } //End block
                    } //End block
                } //End block
            } //End block
            boolean hasTabOrEmoji = getLineContainsTab(i);
    if(hasTabOrEmoji && !tabStopsIsInitialized)            
            {
    if(tabStops == null)                
                {
                    tabStops = new TabStops(TAB_INCREMENT, spans);
                } //End block
                else
                {
                    tabStops.reset(TAB_INCREMENT, spans);
                } //End block
                tabStopsIsInitialized = true;
            } //End block
            Alignment align = paraAlign;
    if(align == Alignment.ALIGN_LEFT)            
            {
                align = (dir == DIR_LEFT_TO_RIGHT) ?
                    Alignment.ALIGN_NORMAL : Alignment.ALIGN_OPPOSITE;
            } //End block
            else
    if(align == Alignment.ALIGN_RIGHT)            
            {
                align = (dir == DIR_LEFT_TO_RIGHT) ?
                    Alignment.ALIGN_OPPOSITE : Alignment.ALIGN_NORMAL;
            } //End block
            int x;
    if(align == Alignment.ALIGN_NORMAL)            
            {
    if(dir == DIR_LEFT_TO_RIGHT)                
                {
                    x = left;
                } //End block
                else
                {
                    x = right;
                } //End block
            } //End block
            else
            {
                int max = (int)getLineExtent(i, tabStops, false);
    if(align == Alignment.ALIGN_OPPOSITE)                
                {
    if(dir == DIR_LEFT_TO_RIGHT)                    
                    {
                        x = right - max;
                    } //End block
                    else
                    {
                        x = left - max;
                    } //End block
                } //End block
                else
                {
                    max = max & ~1;
                    x = (right + left - max) >> 1;
                } //End block
            } //End block
            Directions directions = getLineDirections(i);
    if(directions == DIRS_ALL_LEFT_TO_RIGHT &&
                    !spannedText && !hasTabOrEmoji)            
            {
                c.drawText(buf, start, end, x, lbaseline, paint);
            } //End block
            else
            {
                tl.set(paint, buf, start, end, dir, directions, hasTabOrEmoji, tabStops);
                tl.draw(c, x, ltop, lbaseline, lbottom);
            } //End block
        } //End block
        TextLine.recycle(tl);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.179 -0400", hash_original_method = "94C8B0A33C8A9972488E17891E7B8BAC", hash_generated_method = "A81A8899EBF9CDF4DE5A57624194B0AC")
    private int getLineStartPos(int line, int left, int right) {
        addTaint(right);
        addTaint(left);
        addTaint(line);
        Alignment align = getParagraphAlignment(line);
        int dir = getParagraphDirection(line);
        int x;
    if(align == Alignment.ALIGN_LEFT)        
        {
            x = left;
        } //End block
        else
    if(align == Alignment.ALIGN_NORMAL)        
        {
    if(dir == DIR_LEFT_TO_RIGHT)            
            {
                x = left;
            } //End block
            else
            {
                x = right;
            } //End block
        } //End block
        else
        {
            TabStops tabStops = null;
    if(mSpannedText && getLineContainsTab(line))            
            {
                Spanned spanned = (Spanned) mText;
                int start = getLineStart(line);
                int spanEnd = spanned.nextSpanTransition(start, spanned.length(),
                        TabStopSpan.class);
                TabStopSpan[] tabSpans = getParagraphSpans(spanned, start, spanEnd, TabStopSpan.class);
    if(tabSpans.length > 0)                
                {
                    tabStops = new TabStops(TAB_INCREMENT, tabSpans);
                } //End block
            } //End block
            int max = (int)getLineExtent(line, tabStops, false);
    if(align == Alignment.ALIGN_RIGHT)            
            {
                x = right - max;
            } //End block
            else
    if(align == Alignment.ALIGN_OPPOSITE)            
            {
    if(dir == DIR_LEFT_TO_RIGHT)                
                {
                    x = right - max;
                } //End block
                else
                {
                    x = left - max;
                } //End block
            } //End block
            else
            {
                max = max & ~1;
                x = (left + right - max) >> 1;
            } //End block
        } //End block
        int var9DD4E461268C8034F5C8564E155C67A6_1658431863 = (x);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_677090179 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_677090179;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.179 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "5ECC6F1C09D0A63F7C0F1938140A45B8")
    public final CharSequence getText() {
CharSequence var7F7ECB4B14362FFBA020956966B29A66_832232297 =         mText;
        var7F7ECB4B14362FFBA020956966B29A66_832232297.addTaint(taint);
        return var7F7ECB4B14362FFBA020956966B29A66_832232297;
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.179 -0400", hash_original_method = "7064C5093467A23605D5C425E4D25B83", hash_generated_method = "881C2D44694C8F6A401FD19B69584731")
    public final TextPaint getPaint() {
TextPaint var942A2EBC27CD21C7FBC19AB14FC6E1BE_2147416680 =         mPaint;
        var942A2EBC27CD21C7FBC19AB14FC6E1BE_2147416680.addTaint(taint);
        return var942A2EBC27CD21C7FBC19AB14FC6E1BE_2147416680;
        // ---------- Original Method ----------
        //return mPaint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.179 -0400", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "FD8B5F3F746E2F18837655EA412D9BD2")
    public final int getWidth() {
        int varA3DB1626A190732E588FD0D14FC8FB31_770121867 = (mWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1564873931 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1564873931;
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.179 -0400", hash_original_method = "90F96A059D406483E44444E82D555D1F", hash_generated_method = "6C7CC6587888BA33A0C3E096937F8EED")
    public int getEllipsizedWidth() {
        int varA3DB1626A190732E588FD0D14FC8FB31_2067710874 = (mWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_165885239 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_165885239;
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.180 -0400", hash_original_method = "461CE12B89AFCA61718D5C5F590357B0", hash_generated_method = "F8E801E4EAA5463EDD832BBDE8281CD4")
    public final void increaseWidthTo(int wid) {
    if(wid < mWidth)        
        {
            RuntimeException var458344B9D964DC6CC20CC70B757261C2_110676411 = new RuntimeException("attempted to reduce Layout width");
            var458344B9D964DC6CC20CC70B757261C2_110676411.addTaint(taint);
            throw var458344B9D964DC6CC20CC70B757261C2_110676411;
        } //End block
        mWidth = wid;
        // ---------- Original Method ----------
        //if (wid < mWidth) {
            //throw new RuntimeException("attempted to reduce Layout width");
        //}
        //mWidth = wid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.180 -0400", hash_original_method = "5212B162F472F11B6A60B5BD891C860A", hash_generated_method = "D44D7C51F4A18A1EE25EFAD55527B5C3")
    public int getHeight() {
        int varB8201E4020A9D9D2A5133AFEF050A33E_349404004 = (getLineTop(getLineCount()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1019443038 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1019443038;
        // ---------- Original Method ----------
        //return getLineTop(getLineCount());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.180 -0400", hash_original_method = "FB2D4D43E3EFDD971010AB3AFA49B442", hash_generated_method = "BEFEC8DDF045F7F2C74C34CFED44E883")
    public final Alignment getAlignment() {
Alignment varC04E5C57D472FBB575D9430F22E2842D_130060649 =         mAlignment;
        varC04E5C57D472FBB575D9430F22E2842D_130060649.addTaint(taint);
        return varC04E5C57D472FBB575D9430F22E2842D_130060649;
        // ---------- Original Method ----------
        //return mAlignment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.180 -0400", hash_original_method = "F861D6694D511E0A8AF4CE2A5552F333", hash_generated_method = "119F3F9570DCEF308C58ADFBAFE1D287")
    public final float getSpacingMultiplier() {
        float varDD430150592EA7FB656F57A5D9A5C479_1473948231 = (mSpacingMult);
                float var546ADE640B6EDFBC8A086EF31347E768_991366589 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_991366589;
        // ---------- Original Method ----------
        //return mSpacingMult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.180 -0400", hash_original_method = "E15AF37508F3C3C8F31DF2917343152C", hash_generated_method = "ADBA82C730D283B34117D9A01C0AF73A")
    public final float getSpacingAdd() {
        float var18DE4355EE7ABBEF3185EC1003DD341A_583882744 = (mSpacingAdd);
                float var546ADE640B6EDFBC8A086EF31347E768_949132334 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_949132334;
        // ---------- Original Method ----------
        //return mSpacingAdd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.180 -0400", hash_original_method = "CEF29A1F61D81E3972548E19A0D7158C", hash_generated_method = "79863D8E5E1DA247D333648DC073470B")
    public final TextDirectionHeuristic getTextDirectionHeuristic() {
TextDirectionHeuristic var3A0D72519E0B51077F9922AC60B8A2A3_610248953 =         mTextDir;
        var3A0D72519E0B51077F9922AC60B8A2A3_610248953.addTaint(taint);
        return var3A0D72519E0B51077F9922AC60B8A2A3_610248953;
        // ---------- Original Method ----------
        //return mTextDir;
    }

    
    public abstract int getLineCount();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.180 -0400", hash_original_method = "6295516BE4612811C14BD1DCED80BAB8", hash_generated_method = "167ABC09D450107DCB8F3FAC8B9109B2")
    public int getLineBounds(int line, Rect bounds) {
        addTaint(bounds.getTaint());
        addTaint(line);
    if(bounds != null)        
        {
            bounds.left = 0;
            bounds.top = getLineTop(line);
            bounds.right = mWidth;
            bounds.bottom = getLineTop(line + 1);
        } //End block
        int var49666B474C8956F694F06DCA1D492DE9_1155643061 = (getLineBaseline(line));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1542606940 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1542606940;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.181 -0400", hash_original_method = "2C3949CE81E6BE871356E85B216A576F", hash_generated_method = "43EFE06AB7D7021C403908D5092F23CA")
    public boolean isLevelBoundary(int offset) {
        addTaint(offset);
        int line = getLineForOffset(offset);
        Directions dirs = getLineDirections(line);
    if(dirs == DIRS_ALL_LEFT_TO_RIGHT || dirs == DIRS_ALL_RIGHT_TO_LEFT)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1878416028 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1905911107 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1905911107;
        } //End block
        int[] runs = dirs.mDirections;
        int lineStart = getLineStart(line);
        int lineEnd = getLineEnd(line);
    if(offset == lineStart || offset == lineEnd)        
        {
            int paraLevel = getParagraphDirection(line) == 1 ? 0 : 1;
            int runIndex = offset == lineStart ? 0 : runs.length - 2;
            boolean var1D77822BB232F3D94BF42FDFB13C644F_1776737951 = (((runs[runIndex + 1] >>> RUN_LEVEL_SHIFT) & RUN_LEVEL_MASK) != paraLevel);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2083011164 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2083011164;
        } //End block
        offset -= lineStart;
for(int i = 0;i < runs.length;i += 2)
        {
    if(offset == runs[i])            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1149657239 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_162448606 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_162448606;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1312278729 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1573281252 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1573281252;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.181 -0400", hash_original_method = "AF5CCAD1718916CFF1EB4C8EF2E12FAE", hash_generated_method = "2589DF1C6E0C38E8D3DE5F5A3344FB09")
    public boolean isRtlCharAt(int offset) {
        addTaint(offset);
        int line = getLineForOffset(offset);
        Directions dirs = getLineDirections(line);
    if(dirs == DIRS_ALL_LEFT_TO_RIGHT)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1686256839 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1123960788 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1123960788;
        } //End block
    if(dirs == DIRS_ALL_RIGHT_TO_LEFT)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1323250089 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_699785337 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_699785337;
        } //End block
        int[] runs = dirs.mDirections;
        int lineStart = getLineStart(line);
for(int i = 0;i < runs.length;i += 2)
        {
            int start = lineStart + (runs[i] & RUN_LENGTH_MASK);
    if(offset >= start)            
            {
                int level = (runs[i+1] >>> RUN_LEVEL_SHIFT) & RUN_LEVEL_MASK;
                boolean var0B8B58AE0ADDE1E44951522B029ECDED_661000475 = (((level & 1) != 0));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_470498759 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_470498759;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1979585367 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_534168882 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_534168882;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.182 -0400", hash_original_method = "2802B19F8A9E2D0D463FD305FA66136A", hash_generated_method = "DB9F66B13310DC3DFBB6A396118BDE19")
    private boolean primaryIsTrailingPrevious(int offset) {
        addTaint(offset);
        int line = getLineForOffset(offset);
        int lineStart = getLineStart(line);
        int lineEnd = getLineEnd(line);
        int[] runs = getLineDirections(line).mDirections;
        int levelAt = -1;
for(int i = 0;i < runs.length;i += 2)
        {
            int start = lineStart + runs[i];
            int limit = start + (runs[i+1] & RUN_LENGTH_MASK);
    if(limit > lineEnd)            
            {
                limit = lineEnd;
            } //End block
    if(offset >= start && offset < limit)            
            {
    if(offset > start)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_235189604 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1582382417 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1582382417;
                } //End block
                levelAt = (runs[i+1] >>> RUN_LEVEL_SHIFT) & RUN_LEVEL_MASK;
                break;
            } //End block
        } //End block
    if(levelAt == -1)        
        {
            levelAt = getParagraphDirection(line) == 1 ? 0 : 1;
        } //End block
        int levelBefore = -1;
    if(offset == lineStart)        
        {
            levelBefore = getParagraphDirection(line) == 1 ? 0 : 1;
        } //End block
        else
        {
            offset -= 1;
for(int i = 0;i < runs.length;i += 2)
            {
                int start = lineStart + runs[i];
                int limit = start + (runs[i+1] & RUN_LENGTH_MASK);
    if(limit > lineEnd)                
                {
                    limit = lineEnd;
                } //End block
    if(offset >= start && offset < limit)                
                {
                    levelBefore = (runs[i+1] >>> RUN_LEVEL_SHIFT) & RUN_LEVEL_MASK;
                    break;
                } //End block
            } //End block
        } //End block
        boolean varCD59ED15A1CB715C856055026A0F9215_1843413963 = (levelBefore < levelAt);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1117778776 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1117778776;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.182 -0400", hash_original_method = "80ABC300097314837E01431F08FED39C", hash_generated_method = "CF479582E371DEE7BB400B49C7898C72")
    public float getPrimaryHorizontal(int offset) {
        addTaint(offset);
        boolean trailing = primaryIsTrailingPrevious(offset);
        float var79889E599F7F459F95E42E3A4B217D59_1025260686 = (getHorizontal(offset, trailing));
                float var546ADE640B6EDFBC8A086EF31347E768_2127217800 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2127217800;
        // ---------- Original Method ----------
        //boolean trailing = primaryIsTrailingPrevious(offset);
        //return getHorizontal(offset, trailing);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.182 -0400", hash_original_method = "5EA78F3566FFC0563802F8455C66332C", hash_generated_method = "2B9FFC7BC0079E5D76693FD02E0290D5")
    public float getSecondaryHorizontal(int offset) {
        addTaint(offset);
        boolean trailing = primaryIsTrailingPrevious(offset);
        float var2FFFA8E629590BBAEB0FE340F414FE16_317588886 = (getHorizontal(offset, !trailing));
                float var546ADE640B6EDFBC8A086EF31347E768_1599493219 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1599493219;
        // ---------- Original Method ----------
        //boolean trailing = primaryIsTrailingPrevious(offset);
        //return getHorizontal(offset, !trailing);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.183 -0400", hash_original_method = "A6F47D9472D86FF595A17085495F07A6", hash_generated_method = "7D21892B3C210F0AD6124311786C1336")
    private float getHorizontal(int offset, boolean trailing) {
        addTaint(trailing);
        addTaint(offset);
        int line = getLineForOffset(offset);
        float var21B051897D55C4BE103AA602C88CB8DB_1264280564 = (getHorizontal(offset, trailing, line));
                float var546ADE640B6EDFBC8A086EF31347E768_600813509 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_600813509;
        // ---------- Original Method ----------
        //int line = getLineForOffset(offset);
        //return getHorizontal(offset, trailing, line);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.183 -0400", hash_original_method = "B47A0ABADD57DE266AAF87A7E699E873", hash_generated_method = "9FD326E7207F6C0ABC5294DE04631FB3")
    private float getHorizontal(int offset, boolean trailing, int line) {
        addTaint(line);
        addTaint(trailing);
        addTaint(offset);
        int start = getLineStart(line);
        int end = getLineEnd(line);
        int dir = getParagraphDirection(line);
        boolean hasTabOrEmoji = getLineContainsTab(line);
        Directions directions = getLineDirections(line);
        TabStops tabStops = null;
    if(hasTabOrEmoji && mText instanceof Spanned)        
        {
            TabStopSpan[] tabs = getParagraphSpans((Spanned) mText, start, end, TabStopSpan.class);
    if(tabs.length > 0)            
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
        float var9B6298D601500E72A6EF0A9D83340A25_1367369459 = (getLineStartPos(line, left, right) + wid);
                float var546ADE640B6EDFBC8A086EF31347E768_1837046252 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1837046252;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.183 -0400", hash_original_method = "185391EA60FA7533A9126C3E791BF275", hash_generated_method = "817A61187F5AE6D5886BACF1032E8178")
    public float getLineLeft(int line) {
        addTaint(line);
        int dir = getParagraphDirection(line);
        Alignment align = getParagraphAlignment(line);
    if(align == Alignment.ALIGN_LEFT)        
        {
            float varCFCD208495D565EF66E7DFF9F98764DA_1460608028 = (0);
                        float var546ADE640B6EDFBC8A086EF31347E768_428137606 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_428137606;
        } //End block
        else
    if(align == Alignment.ALIGN_NORMAL)        
        {
    if(dir == DIR_RIGHT_TO_LEFT)            
            {
            float var59E40ED3AEA73D6CF27326556D645E19_796699838 = (getParagraphRight(line) - getLineMax(line));
                        float var546ADE640B6EDFBC8A086EF31347E768_1136421033 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1136421033;
            }
            else
            {
            float varCFCD208495D565EF66E7DFF9F98764DA_1830445883 = (0);
                        float var546ADE640B6EDFBC8A086EF31347E768_313621669 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_313621669;
            }
        } //End block
        else
    if(align == Alignment.ALIGN_RIGHT)        
        {
            float var3991501850D48ACDDA317D8AABA00A3A_1917126804 = (mWidth - getLineMax(line));
                        float var546ADE640B6EDFBC8A086EF31347E768_2135720271 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_2135720271;
        } //End block
        else
    if(align == Alignment.ALIGN_OPPOSITE)        
        {
    if(dir == DIR_RIGHT_TO_LEFT)            
            {
            float varCFCD208495D565EF66E7DFF9F98764DA_1246344276 = (0);
                        float var546ADE640B6EDFBC8A086EF31347E768_1137863419 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1137863419;
            }
            else
            {
            float var3991501850D48ACDDA317D8AABA00A3A_652990965 = (mWidth - getLineMax(line));
                        float var546ADE640B6EDFBC8A086EF31347E768_35115283 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_35115283;
            }
        } //End block
        else
        {
            int left = getParagraphLeft(line);
            int right = getParagraphRight(line);
            int max = ((int) getLineMax(line)) & ~1;
            float var1299E66B75CA8494C9F4F0D3C2078297_1038216346 = (left + ((right - left) - max) / 2);
                        float var546ADE640B6EDFBC8A086EF31347E768_1749615677 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1749615677;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.184 -0400", hash_original_method = "D344E3703EA76C4344B547792AB00F8E", hash_generated_method = "0E17150ED7BB5D9C85F1439168156202")
    public float getLineRight(int line) {
        addTaint(line);
        int dir = getParagraphDirection(line);
        Alignment align = getParagraphAlignment(line);
    if(align == Alignment.ALIGN_LEFT)        
        {
            float var61E8203D6947C0F724644C562AD277BD_1383221884 = (getParagraphLeft(line) + getLineMax(line));
                        float var546ADE640B6EDFBC8A086EF31347E768_168580917 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_168580917;
        } //End block
        else
    if(align == Alignment.ALIGN_NORMAL)        
        {
    if(dir == DIR_RIGHT_TO_LEFT)            
            {
            float varA3DB1626A190732E588FD0D14FC8FB31_997600400 = (mWidth);
                        float var546ADE640B6EDFBC8A086EF31347E768_423088660 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_423088660;
            }
            else
            {
            float var61E8203D6947C0F724644C562AD277BD_1518226707 = (getParagraphLeft(line) + getLineMax(line));
                        float var546ADE640B6EDFBC8A086EF31347E768_1906087735 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1906087735;
            }
        } //End block
        else
    if(align == Alignment.ALIGN_RIGHT)        
        {
            float varA3DB1626A190732E588FD0D14FC8FB31_521192060 = (mWidth);
                        float var546ADE640B6EDFBC8A086EF31347E768_1324188996 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1324188996;
        } //End block
        else
    if(align == Alignment.ALIGN_OPPOSITE)        
        {
    if(dir == DIR_RIGHT_TO_LEFT)            
            {
            float varFA6F146E75FA3D136388147E2A193FDA_1117178617 = (getLineMax(line));
                        float var546ADE640B6EDFBC8A086EF31347E768_1596405090 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1596405090;
            }
            else
            {
            float varA3DB1626A190732E588FD0D14FC8FB31_324684755 = (mWidth);
                        float var546ADE640B6EDFBC8A086EF31347E768_269889999 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_269889999;
            }
        } //End block
        else
        {
            int left = getParagraphLeft(line);
            int right = getParagraphRight(line);
            int max = ((int) getLineMax(line)) & ~1;
            float var793C2451D69F4582D6105E3AB2FDD27E_132471986 = (right - ((right - left) - max) / 2);
                        float var546ADE640B6EDFBC8A086EF31347E768_1116132686 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1116132686;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.184 -0400", hash_original_method = "F9A5FD2221E6CC8B07379CD2792C3C3D", hash_generated_method = "67930C0F6F0E6604BEE6B496F8E4D5E6")
    public float getLineMax(int line) {
        addTaint(line);
        float margin = getParagraphLeadingMargin(line);
        float signedExtent = getLineExtent(line, false);
        float var0F910F9F8A5E4D02F849ED064E1F93DA_768999069 = (margin + signedExtent >= 0 ? signedExtent : -signedExtent);
                float var546ADE640B6EDFBC8A086EF31347E768_1760241398 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1760241398;
        // ---------- Original Method ----------
        //float margin = getParagraphLeadingMargin(line);
        //float signedExtent = getLineExtent(line, false);
        //return margin + signedExtent >= 0 ? signedExtent : -signedExtent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.185 -0400", hash_original_method = "71AEB5E1BA96E910342AC0DBF85E1ED1", hash_generated_method = "806FD6545C86ED3C737DF0B53764E996")
    public float getLineWidth(int line) {
        addTaint(line);
        float margin = getParagraphLeadingMargin(line);
        float signedExtent = getLineExtent(line, true);
        float var0F910F9F8A5E4D02F849ED064E1F93DA_615611547 = (margin + signedExtent >= 0 ? signedExtent : -signedExtent);
                float var546ADE640B6EDFBC8A086EF31347E768_1552025905 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1552025905;
        // ---------- Original Method ----------
        //float margin = getParagraphLeadingMargin(line);
        //float signedExtent = getLineExtent(line, true);
        //return margin + signedExtent >= 0 ? signedExtent : -signedExtent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.185 -0400", hash_original_method = "22E5E0C81FE58627900045F7BF4DB10C", hash_generated_method = "18D48CF011158E06AAD38FC1169BB047")
    private float getLineExtent(int line, boolean full) {
        addTaint(full);
        addTaint(line);
        int start = getLineStart(line);
        int end = full ? getLineEnd(line) : getLineVisibleEnd(line);
        boolean hasTabsOrEmoji = getLineContainsTab(line);
        TabStops tabStops = null;
    if(hasTabsOrEmoji && mText instanceof Spanned)        
        {
            TabStopSpan[] tabs = getParagraphSpans((Spanned) mText, start, end, TabStopSpan.class);
    if(tabs.length > 0)            
            {
                tabStops = new TabStops(TAB_INCREMENT, tabs);
            } //End block
        } //End block
        Directions directions = getLineDirections(line);
    if(directions == null)        
        {
            float var7DFF51CA8EB990122513F24FFDAA4D9A_99555906 = (0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_700720843 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_700720843;
        } //End block
        int dir = getParagraphDirection(line);
        TextLine tl = TextLine.obtain();
        tl.set(mPaint, mText, start, end, dir, directions, hasTabsOrEmoji, tabStops);
        float width = tl.metrics(null);
        TextLine.recycle(tl);
        float varEAAE26A6FB20ED3EF54FB23BFA0B1FCC_354071588 = (width);
                float var546ADE640B6EDFBC8A086EF31347E768_1697031863 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1697031863;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.186 -0400", hash_original_method = "8D693BD7DA670D75D51405BA4AD1D35A", hash_generated_method = "E2345D718D799D67787CD2FB77554ED6")
    private float getLineExtent(int line, TabStops tabStops, boolean full) {
        addTaint(full);
        addTaint(tabStops.getTaint());
        addTaint(line);
        int start = getLineStart(line);
        int end = full ? getLineEnd(line) : getLineVisibleEnd(line);
        boolean hasTabsOrEmoji = getLineContainsTab(line);
        Directions directions = getLineDirections(line);
        int dir = getParagraphDirection(line);
        TextLine tl = TextLine.obtain();
        tl.set(mPaint, mText, start, end, dir, directions, hasTabsOrEmoji, tabStops);
        float width = tl.metrics(null);
        TextLine.recycle(tl);
        float varEAAE26A6FB20ED3EF54FB23BFA0B1FCC_1846152838 = (width);
                float var546ADE640B6EDFBC8A086EF31347E768_157861812 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_157861812;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.186 -0400", hash_original_method = "10EB5BCC671C8F4E5C56CFC3872691D1", hash_generated_method = "A6CCA874E659378FE3A9B4CDCF8CF766")
    public int getLineForVertical(int vertical) {
        addTaint(vertical);
        int high = getLineCount();
        int low = -1;
        int guess;
        while
(high - low > 1)        
        {
            guess = (high + low) / 2;
    if(getLineTop(guess) > vertical)            
            high = guess;
            else
            low = guess;
        } //End block
    if(low < 0)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_1150912722 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1199516723 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1199516723;
        }
        else
        {
        int var53CCED8D281A1A0ACE3CB6594DAAA4F7_1972001393 = (low);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2143652765 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2143652765;
        }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.187 -0400", hash_original_method = "42BF795D8C0B31EF6FC35C1F4CBE0EBA", hash_generated_method = "8DEE05B2BAF291BD6255FDB48CB2311A")
    public int getLineForOffset(int offset) {
        addTaint(offset);
        int high = getLineCount();
        int low = -1;
        int guess;
        while
(high - low > 1)        
        {
            guess = (high + low) / 2;
    if(getLineStart(guess) > offset)            
            high = guess;
            else
            low = guess;
        } //End block
    if(low < 0)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_1118373213 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_11949964 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_11949964;
        }
        else
        {
        int var53CCED8D281A1A0ACE3CB6594DAAA4F7_1428377626 = (low);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_422175389 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_422175389;
        }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.187 -0400", hash_original_method = "C7C29A2E2D90FB22FF824A86EA8883C4", hash_generated_method = "AC7E0F9DEE2369EF7C8A6B855DD272F5")
    public int getOffsetForHorizontal(int line, float horiz) {
        addTaint(horiz);
        addTaint(line);
        int max = getLineEnd(line) - 1;
        int min = getLineStart(line);
        Directions dirs = getLineDirections(line);
    if(line == getLineCount() - 1)        
        max++;
        int best = min;
        float bestdist = Math.abs(getPrimaryHorizontal(best) - horiz);
for(int i = 0;i < dirs.mDirections.length;i += 2)
        {
            int here = min + dirs.mDirections[i];
            int there = here + (dirs.mDirections[i+1] & RUN_LENGTH_MASK);
            int swap = (dirs.mDirections[i+1] & RUN_RTL_FLAG) != 0 ? -1 : 1;
    if(there > max)            
            there = max;
            int high = there - 1 + 1;
            int low = here + 1 - 1;
            int guess;
            while
(high - low > 1)            
            {
                guess = (high + low) / 2;
                int adguess = getOffsetAtStartOf(guess);
    if(getPrimaryHorizontal(adguess) * swap >= horiz * swap)                
                high = guess;
                else
                low = guess;
            } //End block
    if(low < here + 1)            
            low = here + 1;
    if(low < there)            
            {
                low = getOffsetAtStartOf(low);
                float dist = Math.abs(getPrimaryHorizontal(low) - horiz);
                int aft = TextUtils.getOffsetAfter(mText, low);
    if(aft < there)                
                {
                    float other = Math.abs(getPrimaryHorizontal(aft) - horiz);
    if(other < dist)                    
                    {
                        dist = other;
                        low = aft;
                    } //End block
                } //End block
    if(dist < bestdist)                
                {
                    bestdist = dist;
                    best = low;
                } //End block
            } //End block
            float dist = Math.abs(getPrimaryHorizontal(here) - horiz);
    if(dist < bestdist)            
            {
                bestdist = dist;
                best = here;
            } //End block
        } //End block
        float dist = Math.abs(getPrimaryHorizontal(max) - horiz);
    if(dist < bestdist)        
        {
            bestdist = dist;
            best = max;
        } //End block
        int varDB82206B1D49042D1A710E9C88C21D36_1489157699 = (best);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1951632529 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1951632529;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.188 -0400", hash_original_method = "AEF50F2FA9A7358F560FC7521C77962F", hash_generated_method = "46FF7BF6F22B1D1F221F95DB5F271E34")
    public final int getLineEnd(int line) {
        addTaint(line);
        int var5B1D680435C8AC73F463D67A2DEA5FFA_1541073630 = (getLineStart(line + 1));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288695890 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288695890;
        // ---------- Original Method ----------
        //return getLineStart(line + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.188 -0400", hash_original_method = "A5D943CCC73667A904F00DFE82793835", hash_generated_method = "325AFDC3A6DA06E828D839E10BE2197A")
    public int getLineVisibleEnd(int line) {
        addTaint(line);
        int var257E6E632EC383123CF6900A74EB1C8A_152291472 = (getLineVisibleEnd(line, getLineStart(line), getLineStart(line+1)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1474033237 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1474033237;
        // ---------- Original Method ----------
        //return getLineVisibleEnd(line, getLineStart(line), getLineStart(line+1));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.188 -0400", hash_original_method = "2B63DEF38DAE998AFE5301FAAC214E4B", hash_generated_method = "EDC187726379434223B4D0CE74B5A7FA")
    private int getLineVisibleEnd(int line, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(line);
        CharSequence text = mText;
        char ch;
    if(line == getLineCount() - 1)        
        {
            int var7F021A1415B86F2D013B2618FB31AE53_1321711288 = (end);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_590957461 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_590957461;
        } //End block
for(;end > start;end--)
        {
            ch = text.charAt(end - 1);
    if(ch == '\n')            
            {
                int var03EBDC14A1448E64CA81BF2D53CC0BCE_253367765 = (end - 1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_983638191 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_983638191;
            } //End block
    if(ch != ' ' && ch != '\t')            
            {
                break;
            } //End block
        } //End block
        int var7F021A1415B86F2D013B2618FB31AE53_713021298 = (end);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1053826038 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1053826038;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.189 -0400", hash_original_method = "230C56044F8D52E3D0BA17DE5C72A914", hash_generated_method = "1FA91A163FA0004DDB3A5DBEEB1A9FDD")
    public final int getLineBottom(int line) {
        addTaint(line);
        int var05531C9A0CF239E55C507F853E542E2B_2087848093 = (getLineTop(line + 1));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_988074970 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_988074970;
        // ---------- Original Method ----------
        //return getLineTop(line + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.190 -0400", hash_original_method = "BC6E93964E3CCD0D48881D9F9ABB9170", hash_generated_method = "1C271CA20B8109F8CCBC7DC680EB1105")
    public final int getLineBaseline(int line) {
        addTaint(line);
        int var1DCD8BFC6B27228C7C3DC7832E5880FD_1444487475 = (getLineTop(line+1) - getLineDescent(line));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2118779841 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2118779841;
        // ---------- Original Method ----------
        //return getLineTop(line+1) - getLineDescent(line);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.190 -0400", hash_original_method = "577197C969745092B110831C30EF14E9", hash_generated_method = "D0562D3369163C3A1FBB093AD8ABF557")
    public final int getLineAscent(int line) {
        addTaint(line);
        int varC3DC84DB58978E4D4ACCA089F23C983D_1746219251 = (getLineTop(line) - (getLineTop(line+1) - getLineDescent(line)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1186716479 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1186716479;
        // ---------- Original Method ----------
        //return getLineTop(line) - (getLineTop(line+1) - getLineDescent(line));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.190 -0400", hash_original_method = "AA9B5ECC044BD491182BF4F86B4B2DB2", hash_generated_method = "D9829EFF558674A0762B15A4905EE6BD")
    public int getOffsetToLeftOf(int offset) {
        addTaint(offset);
        int varD5131EB1BF1C649BF706CB17C14B2BBB_1713366267 = (getOffsetToLeftRightOf(offset, true));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_380392464 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_380392464;
        // ---------- Original Method ----------
        //return getOffsetToLeftRightOf(offset, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.190 -0400", hash_original_method = "684E6D0185E1F1B7C4ABCAB8ADBE45B0", hash_generated_method = "00A1F8356216CA78EDC579B82CEB5969")
    public int getOffsetToRightOf(int offset) {
        addTaint(offset);
        int var5F019C62AEF4193EFFB16306E35C9E8F_280037169 = (getOffsetToLeftRightOf(offset, false));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202626260 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202626260;
        // ---------- Original Method ----------
        //return getOffsetToLeftRightOf(offset, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.192 -0400", hash_original_method = "0024CF60F9AAE9E8C390E55EB92D8B7D", hash_generated_method = "C387E7D0EF4490EE6711910BA7E525F3")
    private int getOffsetToLeftRightOf(int caret, boolean toLeft) {
        addTaint(toLeft);
        addTaint(caret);
        int line = getLineForOffset(caret);
        int lineStart = getLineStart(line);
        int lineEnd = getLineEnd(line);
        int lineDir = getParagraphDirection(line);
        boolean lineChanged = false;
        boolean advance = toLeft == (lineDir == DIR_RIGHT_TO_LEFT);
    if(advance)        
        {
    if(caret == lineEnd)            
            {
    if(line < getLineCount() - 1)                
                {
                    lineChanged = true;
                    ++line;
                } //End block
                else
                {
                    int var1E4D1D8E9A5C4437184EEFBF8885A3FD_1658155592 = (caret);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_55697905 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_55697905;
                } //End block
            } //End block
        } //End block
        else
        {
    if(caret == lineStart)            
            {
    if(line > 0)                
                {
                    lineChanged = true;
                    --line;
                } //End block
                else
                {
                    int var1E4D1D8E9A5C4437184EEFBF8885A3FD_20750471 = (caret);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_857099919 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_857099919;
                } //End block
            } //End block
        } //End block
    if(lineChanged)        
        {
            lineStart = getLineStart(line);
            lineEnd = getLineEnd(line);
            int newDir = getParagraphDirection(line);
    if(newDir != lineDir)            
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
        int var1E4D1D8E9A5C4437184EEFBF8885A3FD_878112551 = (caret);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1074252834 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1074252834;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.193 -0400", hash_original_method = "F9D5E8173F5C3CA491A1C8A8AE760B93", hash_generated_method = "DB7D37347F1133E470FEE5ECB1BBB10A")
    private int getOffsetAtStartOf(int offset) {
        addTaint(offset);
    if(offset == 0)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_1071630920 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1646652486 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1646652486;
        }
        CharSequence text = mText;
        char c = text.charAt(offset);
    if(c >= '\uDC00' && c <= '\uDFFF')        
        {
            char c1 = text.charAt(offset - 1);
    if(c1 >= '\uD800' && c1 <= '\uDBFF')            
            offset -= 1;
        } //End block
    if(mSpannedText)        
        {
            ReplacementSpan[] spans = ((Spanned) text).getSpans(offset, offset,
                                                       ReplacementSpan.class);
for(int i = 0;i < spans.length;i++)
            {
                int start = ((Spanned) text).getSpanStart(spans[i]);
                int end = ((Spanned) text).getSpanEnd(spans[i]);
    if(start < offset && end > offset)                
                offset = start;
            } //End block
        } //End block
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_1042956320 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2039853996 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2039853996;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.195 -0400", hash_original_method = "B9C7ED4514D9377B34881167E2C24E2C", hash_generated_method = "F25B0E491114613BBC5E35E3F52AFEDC")
    public void getCursorPath(int point, Path dest,
                              CharSequence editingBuffer) {
        addTaint(editingBuffer.getTaint());
        addTaint(dest.getTaint());
        addTaint(point);
        dest.reset();
        int line = getLineForOffset(point);
        int top = getLineTop(line);
        int bottom = getLineTop(line+1);
        float h1 = getPrimaryHorizontal(point) - 0.5f;
        float h2 = isLevelBoundary(point) ? getSecondaryHorizontal(point) - 0.5f : h1;
        int caps = TextKeyListener.getMetaState(editingBuffer, TextKeyListener.META_SHIFT_ON) |
                   TextKeyListener.getMetaState(editingBuffer, TextKeyListener.META_SELECTING);
        int fn = TextKeyListener.getMetaState(editingBuffer, TextKeyListener.META_ALT_ON);
        int dist = 0;
    if(caps != 0 || fn != 0)        
        {
            dist = (bottom - top) >> 2;
    if(fn != 0)            
            top += dist;
    if(caps != 0)            
            bottom -= dist;
        } //End block
    if(h1 < 0.5f)        
        h1 = 0.5f;
    if(h2 < 0.5f)        
        h2 = 0.5f;
    if(Float.compare(h1, h2) == 0)        
        {
            dest.moveTo(h1, top);
            dest.lineTo(h1, bottom);
        } //End block
        else
        {
            dest.moveTo(h1, top);
            dest.lineTo(h1, (top + bottom) >> 1);
            dest.moveTo(h2, (top + bottom) >> 1);
            dest.lineTo(h2, bottom);
        } //End block
    if(caps == 2)        
        {
            dest.moveTo(h2, bottom);
            dest.lineTo(h2 - dist, bottom + dist);
            dest.lineTo(h2, bottom);
            dest.lineTo(h2 + dist, bottom + dist);
        } //End block
        else
    if(caps == 1)        
        {
            dest.moveTo(h2, bottom);
            dest.lineTo(h2 - dist, bottom + dist);
            dest.moveTo(h2 - dist, bottom + dist - 0.5f);
            dest.lineTo(h2 + dist, bottom + dist - 0.5f);
            dest.moveTo(h2 + dist, bottom + dist);
            dest.lineTo(h2, bottom);
        } //End block
    if(fn == 2)        
        {
            dest.moveTo(h1, top);
            dest.lineTo(h1 - dist, top - dist);
            dest.lineTo(h1, top);
            dest.lineTo(h1 + dist, top - dist);
        } //End block
        else
    if(fn == 1)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.196 -0400", hash_original_method = "12119B0793FEC64A3F791B69831CA1AC", hash_generated_method = "DA23D10776D5FD0596D33C0A852A8FFA")
    private void addSelection(int line, int start, int end,
                              int top, int bottom, Path dest) {
        addTaint(dest.getTaint());
        addTaint(bottom);
        addTaint(top);
        addTaint(end);
        addTaint(start);
        addTaint(line);
        int linestart = getLineStart(line);
        int lineend = getLineEnd(line);
        Directions dirs = getLineDirections(line);
    if(lineend > linestart && mText.charAt(lineend - 1) == '\n')        
        lineend--;
for(int i = 0;i < dirs.mDirections.length;i += 2)
        {
            int here = linestart + dirs.mDirections[i];
            int there = here + (dirs.mDirections[i+1] & RUN_LENGTH_MASK);
    if(there > lineend)            
            there = lineend;
    if(start <= there && end >= here)            
            {
                int st = Math.max(start, here);
                int en = Math.min(end, there);
    if(st != en)                
                {
                    float h1 = getHorizontal(st, false, line);
                    float h2 = getHorizontal(en, true, line);
                    float left = Math.min(h1, h2);
                    float right = Math.max(h1, h2);
                    dest.addRect(left, top, right, bottom, Path.Direction.CW);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.196 -0400", hash_original_method = "E504AED84523F80835FFB88244A923D5", hash_generated_method = "AA5A7DA8F2E856C3B64313E390E237F3")
    public void getSelectionPath(int start, int end, Path dest) {
        addTaint(dest.getTaint());
        addTaint(end);
        addTaint(start);
        dest.reset();
    if(start == end)        
        return;
    if(end < start)        
        {
            int temp = end;
            end = start;
            start = temp;
        } //End block
        int startline = getLineForOffset(start);
        int endline = getLineForOffset(end);
        int top = getLineTop(startline);
        int bottom = getLineBottom(endline);
    if(startline == endline)        
        {
            addSelection(startline, start, end, top, bottom, dest);
        } //End block
        else
        {
            final float width = mWidth;
            addSelection(startline, start, getLineEnd(startline),
                         top, getLineBottom(startline), dest);
    if(getParagraphDirection(startline) == DIR_RIGHT_TO_LEFT)            
            dest.addRect(getLineLeft(startline), top,
                              0, getLineBottom(startline), Path.Direction.CW);
            else
            dest.addRect(getLineRight(startline), top,
                              width, getLineBottom(startline), Path.Direction.CW);
for(int i = startline + 1;i < endline;i++)
            {
                top = getLineTop(i);
                bottom = getLineBottom(i);
                dest.addRect(0, top, width, bottom, Path.Direction.CW);
            } //End block
            top = getLineTop(endline);
            bottom = getLineBottom(endline);
            addSelection(endline, getLineStart(endline), end,
                         top, bottom, dest);
    if(getParagraphDirection(endline) == DIR_RIGHT_TO_LEFT)            
            dest.addRect(width, top, getLineRight(endline), bottom, Path.Direction.CW);
            else
            dest.addRect(0, top, getLineLeft(endline), bottom, Path.Direction.CW);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.197 -0400", hash_original_method = "8E26BC9825AB85694FDEA00F755B3420", hash_generated_method = "058C223409569A900B979A1E0360A95F")
    public final Alignment getParagraphAlignment(int line) {
        addTaint(line);
        Alignment align = mAlignment;
    if(mSpannedText)        
        {
            Spanned sp = (Spanned) mText;
            AlignmentSpan[] spans = getParagraphSpans(sp, getLineStart(line),
                                                getLineEnd(line),
                                                AlignmentSpan.class);
            int spanLength = spans.length;
    if(spanLength > 0)            
            {
                align = spans[spanLength-1].getAlignment();
            } //End block
        } //End block
Alignment varCEAE2685351A3CF46F157F15BE8AD2B6_197327476 =         align;
        varCEAE2685351A3CF46F157F15BE8AD2B6_197327476.addTaint(taint);
        return varCEAE2685351A3CF46F157F15BE8AD2B6_197327476;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.197 -0400", hash_original_method = "D8249C79FD486A8037899C5A02304321", hash_generated_method = "78857939A03AAFD2D37D09F827EFD796")
    public final int getParagraphLeft(int line) {
        addTaint(line);
        int left = 0;
        int dir = getParagraphDirection(line);
    if(dir == DIR_RIGHT_TO_LEFT || !mSpannedText)        
        {
            int var811882FECD5C7618D7099EBBD39EA254_1900574640 = (left);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_756651548 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_756651548;
        } //End block
        int var10AA4DB15CA7DAA0A20A336B29934A00_1218520277 = (getParagraphLeadingMargin(line));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_632366684 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_632366684;
        // ---------- Original Method ----------
        //int left = 0;
        //int dir = getParagraphDirection(line);
        //if (dir == DIR_RIGHT_TO_LEFT || !mSpannedText) {
            //return left; 
        //}
        //return getParagraphLeadingMargin(line);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.197 -0400", hash_original_method = "4AFE65CA85EFF9BA5DD1726E8E021AC9", hash_generated_method = "A453D23B41E7D0B81242DFE03B8005F1")
    public final int getParagraphRight(int line) {
        addTaint(line);
        int right = mWidth;
        int dir = getParagraphDirection(line);
    if(dir == DIR_LEFT_TO_RIGHT || !mSpannedText)        
        {
            int var7C4F29407893C334A6CB7A87BF045C0D_2015899854 = (right);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_200547679 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_200547679;
        } //End block
        int var18E1163BC323F845366EBFD8339ED58D_24647541 = (right - getParagraphLeadingMargin(line));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530552433 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530552433;
        // ---------- Original Method ----------
        //int right = mWidth;
        //int dir = getParagraphDirection(line);
        //if (dir == DIR_LEFT_TO_RIGHT || !mSpannedText) {
            //return right; 
        //}
        //return right - getParagraphLeadingMargin(line);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.199 -0400", hash_original_method = "E5BF73D13B43F74BA21E795D809567BE", hash_generated_method = "0B0FE4D00FA0A5D14843A36E6C79CC18")
    private int getParagraphLeadingMargin(int line) {
        addTaint(line);
    if(!mSpannedText)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1772687357 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1543513239 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1543513239;
        } //End block
        Spanned spanned = (Spanned) mText;
        int lineStart = getLineStart(line);
        int lineEnd = getLineEnd(line);
        int spanEnd = spanned.nextSpanTransition(lineStart, lineEnd,
                LeadingMarginSpan.class);
        LeadingMarginSpan[] spans = getParagraphSpans(spanned, lineStart, spanEnd,
                                                LeadingMarginSpan.class);
    if(spans.length == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_582444327 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_187028391 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_187028391;
        } //End block
        int margin = 0;
        boolean isFirstParaLine = lineStart == 0 ||
            spanned.charAt(lineStart - 1) == '\n';
for(int i = 0;i < spans.length;i++)
        {
            LeadingMarginSpan span = spans[i];
            boolean useFirstLineMargin = isFirstParaLine;
    if(span instanceof LeadingMarginSpan2)            
            {
                int spStart = spanned.getSpanStart(span);
                int spanLine = getLineForOffset(spStart);
                int count = ((LeadingMarginSpan2)span).getLeadingMarginLineCount();
                useFirstLineMargin = line < spanLine + count;
            } //End block
            margin += span.getLeadingMargin(useFirstLineMargin);
        } //End block
        int varD42F4851E770AA0F758B01388874F67B_1178808052 = (margin);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137565717 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137565717;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.200 -0400", hash_original_method = "CAFF1C73D2C9EA6C410B2B2D519C8AC7", hash_generated_method = "45DA496944F812CEAC518BA8A2C7791C")
    protected final boolean isSpanned() {
        boolean var9AAB51E3E9F2DBF3923317511559B1D1_397934619 = (mSpannedText);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2049698463 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2049698463;
        // ---------- Original Method ----------
        //return mSpannedText;
    }

    
        static <T> T[] getParagraphSpans(Spanned text, int start, int end, Class<T> type) {
        if (start == end && start > 0) {
            return (T[]) ArrayUtils.emptyArray(type);
        }
        return text.getSpans(start, end, type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.202 -0400", hash_original_method = "0902B773EC3014719EA37A51347EC9C6", hash_generated_method = "FD0C7C3C4BA2DFBFA9DC944C78A59D3F")
    private void ellipsize(int start, int end, int line,
                           char[] dest, int destoff) {
        addTaint(destoff);
        addTaint(dest[0]);
        addTaint(line);
        addTaint(end);
        addTaint(start);
        int ellipsisCount = getEllipsisCount(line);
    if(ellipsisCount == 0)        
        {
            return;
        } //End block
        int ellipsisStart = getEllipsisStart(line);
        int linestart = getLineStart(line);
for(int i = ellipsisStart;i < ellipsisStart + ellipsisCount;i++)
        {
            char c;
    if(i == ellipsisStart)            
            {
                c = '\u2026';
            } //End block
            else
            {
                c = '\uFEFF';
            } //End block
            int a = i + linestart;
    if(a >= start && a < end)            
            {
                dest[destoff + a - start] = c;
            } //End block
        } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.203 -0400", hash_original_field = "969B4F08C6A411180F291ECE7B5A3D28", hash_generated_field = "8DF1795EE4BFA46EFF29A588C85F9451")

        private int[] mStops;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.203 -0400", hash_original_field = "EAD340360070F0A190E57144293C5C2B", hash_generated_field = "2A878E7FB3BADF740089FE25D0D2CFB0")

        private int mNumStops;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.203 -0400", hash_original_field = "B954C9EDAC21852B96AD8DA47FB0BB4A", hash_generated_field = "1B34C3EF06331C9557133D8E11D29298")

        private int mIncrement;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.204 -0400", hash_original_method = "56D1FFBFF7D6B6649609A0E9FF6888AB", hash_generated_method = "AFA44880A555125C3DC767FF87A30CDD")
          TabStops(int increment, Object[] spans) {
            addTaint(spans[0].getTaint());
            addTaint(increment);
            reset(increment, spans);
            // ---------- Original Method ----------
            //reset(increment, spans);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.205 -0400", hash_original_method = "12BC3A9AA4E5F32DB7C736F6D72E4602", hash_generated_method = "0C7C8FBF62661C7CC37ACE1B7BA57AF6")
         void reset(int increment, Object[] spans) {
            addTaint(spans[0].getTaint());
            this.mIncrement = increment;
            int ns = 0;
    if(spans != null)            
            {
                int[] stops = this.mStops;
for(Object o : spans)
                {
    if(o instanceof TabStopSpan)                    
                    {
    if(stops == null)                        
                        {
                            stops = new int[10];
                        } //End block
                        else
    if(ns == stops.length)                        
                        {
                            int[] nstops = new int[ns * 2];
for(int i = 0;i < ns;++i)
                            {
                                nstops[i] = stops[i];
                            } //End block
                            stops = nstops;
                        } //End block
                        stops[ns++] = ((TabStopSpan) o).getTabStop();
                    } //End block
                } //End block
    if(ns > 1)                
                {
                    Arrays.sort(stops, 0, ns);
                } //End block
    if(stops != this.mStops)                
                {
                    this.mStops = stops;
                } //End block
            } //End block
            this.mNumStops = ns;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.205 -0400", hash_original_method = "A46080BC8F3B4D3099E262DAA9B4728B", hash_generated_method = "92FEF60F037C8D749FEC20715B0B988B")
         float nextTab(float h) {
            addTaint(h);
            int ns = this.mNumStops;
    if(ns > 0)            
            {
                int[] stops = this.mStops;
for(int i = 0;i < ns;++i)
                {
                    int stop = stops[i];
    if(stop > h)                    
                    {
                        float varEF399B2D446BB37B7C32AD2CC1B6045B_1741528689 = (stop);
                                                float var546ADE640B6EDFBC8A086EF31347E768_938482107 = getTaintFloat();
                        return var546ADE640B6EDFBC8A086EF31347E768_938482107;
                    } //End block
                } //End block
            } //End block
            float var7ECDA7F17BABD2324488F64BC057D3AF_1439628939 = (nextDefaultStop(h, mIncrement));
                        float var546ADE640B6EDFBC8A086EF31347E768_1584612931 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1584612931;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.205 -0400", hash_original_field = "C5BE317E362FA3A0C2C3E5FEF24D93D8", hash_generated_field = "75E76BC0D205B7AB08D04B9BD6A8D5F6")

        int[] mDirections;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.205 -0400", hash_original_method = "DA94802578AA1A107A88665DAAC4811A", hash_generated_method = "C362AB05F4F382AB8B2A847D6ACC1E92")
          Directions(int[] dirs) {
            mDirections = dirs;
            // ---------- Original Method ----------
            //mDirections = dirs;
        }

        
    }


    
    static class Ellipsizer implements CharSequence, GetChars {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.205 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "A59BBC07E5E46996D793B2F37E80BD24")

        CharSequence mText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.205 -0400", hash_original_field = "AF58F50E47532278404C3D8470630FC4", hash_generated_field = "99107F82B615317EF9A2721652F6B828")

        Layout mLayout;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.205 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "AF6410B200BC05DCA2CF0BE65165448A")

        int mWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.205 -0400", hash_original_field = "411D2DFDB93368C46AFADBEC76A54162", hash_generated_field = "1AEFAC3E5E60C9DA6FF9B1E24BF26D63")

        TextUtils.TruncateAt mMethod;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.207 -0400", hash_original_method = "991CD3860414493D5159CDEA8946E94D", hash_generated_method = "D2DA4A1117D0439320B581750375AE47")
        public  Ellipsizer(CharSequence s) {
            mText = s;
            // ---------- Original Method ----------
            //mText = s;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.207 -0400", hash_original_method = "D253D2AD2D0DACD122596323ACBBAF25", hash_generated_method = "0037F6BDD6915D74410674EE49A70B1E")
        public char charAt(int off) {
            addTaint(off);
            char[] buf = TextUtils.obtain(1);
            getChars(off, off + 1, buf, 0);
            char ret = buf[0];
            TextUtils.recycle(buf);
            char var2CB9DF9898E55FD0AD829DC202DDBD1C_449151496 = (ret);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_2031279730 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_2031279730;
            // ---------- Original Method ----------
            //char[] buf = TextUtils.obtain(1);
            //getChars(off, off + 1, buf, 0);
            //char ret = buf[0];
            //TextUtils.recycle(buf);
            //return ret;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.207 -0400", hash_original_method = "F2DBD2F3D78F3955B1714BB078A793F8", hash_generated_method = "1C6299C8B1A9CCCBDBCA294EAC792B93")
        public void getChars(int start, int end, char[] dest, int destoff) {
            addTaint(destoff);
            addTaint(dest[0]);
            addTaint(end);
            addTaint(start);
            int line1 = mLayout.getLineForOffset(start);
            int line2 = mLayout.getLineForOffset(end);
            TextUtils.getChars(mText, start, end, dest, destoff);
for(int i = line1;i <= line2;i++)
            {
                mLayout.ellipsize(start, end, i, dest, destoff);
            } //End block
            // ---------- Original Method ----------
            //int line1 = mLayout.getLineForOffset(start);
            //int line2 = mLayout.getLineForOffset(end);
            //TextUtils.getChars(mText, start, end, dest, destoff);
            //for (int i = line1; i <= line2; i++) {
                //mLayout.ellipsize(start, end, i, dest, destoff);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.207 -0400", hash_original_method = "9A68249D01A4FE1CBD4D535668FCEB6F", hash_generated_method = "8EE4A913B43342BBA9D018ABABD90198")
        public int length() {
            int varDC3F5DE2558DF3D25118F6362DE3EB1B_1721270451 = (mText.length());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1684323336 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1684323336;
            // ---------- Original Method ----------
            //return mText.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.207 -0400", hash_original_method = "019151395F1B77A008AA178A5A5CA402", hash_generated_method = "CE1E9144EE8501A2C4EAAA78F6C4AA02")
        public CharSequence subSequence(int start, int end) {
            addTaint(end);
            addTaint(start);
            char[] s = new char[end - start];
            getChars(start, end, s, 0);
CharSequence var36EEEB02F8950D6778907441639F547C_371171348 =             new String(s);
            var36EEEB02F8950D6778907441639F547C_371171348.addTaint(taint);
            return var36EEEB02F8950D6778907441639F547C_371171348;
            // ---------- Original Method ----------
            //char[] s = new char[end - start];
            //getChars(start, end, s, 0);
            //return new String(s);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.207 -0400", hash_original_method = "8ED281151745D3FC40324C23FDF16D10", hash_generated_method = "B0C9444CA6507428590FB68FAEF61574")
        @Override
        public String toString() {
            char[] s = new char[length()];
            getChars(0, length(), s, 0);
String var36EEEB02F8950D6778907441639F547C_955826852 =             new String(s);
            var36EEEB02F8950D6778907441639F547C_955826852.addTaint(taint);
            return var36EEEB02F8950D6778907441639F547C_955826852;
            // ---------- Original Method ----------
            //char[] s = new char[length()];
            //getChars(0, length(), s, 0);
            //return new String(s);
        }

        
    }


    
    static class SpannedEllipsizer extends Ellipsizer implements Spanned {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.210 -0400", hash_original_field = "2A174ADD3219E7DC0B72155FF67EC4B5", hash_generated_field = "69C78554F8ABB9B2C492FD314F3ED2EE")

        private Spanned mSpanned;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.210 -0400", hash_original_method = "F42AC9AEDB79FF2719E5DE12CF0CD85E", hash_generated_method = "521E0E4859CABE811C363188B0E6F44F")
        public  SpannedEllipsizer(CharSequence display) {
            super(display);
            mSpanned = (Spanned) display;
            // ---------- Original Method ----------
            //mSpanned = (Spanned) display;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.210 -0400", hash_original_method = "E8AB479016A2E00AFF48AA43F345FA2A", hash_generated_method = "DDCA2EAA862577467E30ECFF6D6ACC71")
        public <T> T[] getSpans(int start, int end, Class<T> type) {
            addTaint(type.getTaint());
            addTaint(end);
            addTaint(start);
T[] varF03F51B4D510CEB709FCAEAB771CF011_1516634164 =             mSpanned.getSpans(start, end, type);
            varF03F51B4D510CEB709FCAEAB771CF011_1516634164.addTaint(taint);
            return varF03F51B4D510CEB709FCAEAB771CF011_1516634164;
            // ---------- Original Method ----------
            //return mSpanned.getSpans(start, end, type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.211 -0400", hash_original_method = "2071284CDE64572D4D3F80F80EB4C823", hash_generated_method = "F061D192BC71C827F4CBED1D3E3BB7EA")
        public int getSpanStart(Object tag) {
            addTaint(tag.getTaint());
            int var800F360D0EFE39368ED5E50C7D513A55_1388414348 = (mSpanned.getSpanStart(tag));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1323432815 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1323432815;
            // ---------- Original Method ----------
            //return mSpanned.getSpanStart(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.211 -0400", hash_original_method = "B1DC38D90632AE4EB220020E4C5B16DF", hash_generated_method = "36DE4D7F1F2F071FD0E2483143799694")
        public int getSpanEnd(Object tag) {
            addTaint(tag.getTaint());
            int var7238B1DBF5539E6FFFB0C5533E719DCF_1965506428 = (mSpanned.getSpanEnd(tag));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_292656586 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_292656586;
            // ---------- Original Method ----------
            //return mSpanned.getSpanEnd(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.211 -0400", hash_original_method = "A386D5CC8A9C15386840381A75E4D6FD", hash_generated_method = "4CEB85E782EFA346A96D04BC9AE130BF")
        public int getSpanFlags(Object tag) {
            addTaint(tag.getTaint());
            int var55E53B9FA7449A4A00466336ED252163_1512126728 = (mSpanned.getSpanFlags(tag));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_509444973 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_509444973;
            // ---------- Original Method ----------
            //return mSpanned.getSpanFlags(tag);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.211 -0400", hash_original_method = "AF35DA8DF947D9C1330368703ECE15BE", hash_generated_method = "6BEE027DC8EA6F83E7A3DBADAE55E175")
        public int nextSpanTransition(int start, int limit, Class type) {
            addTaint(type.getTaint());
            addTaint(limit);
            addTaint(start);
            int var638B91704525B7BD09FA8A90BD064719_2007079837 = (mSpanned.nextSpanTransition(start, limit, type));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_364803881 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_364803881;
            // ---------- Original Method ----------
            //return mSpanned.nextSpanTransition(start, limit, type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.211 -0400", hash_original_method = "16B37527DFF576A9EB476E4EC2A69F5D", hash_generated_method = "E77EAC612C304B77B94B4B139AC29622")
        @Override
        public CharSequence subSequence(int start, int end) {
            addTaint(end);
            addTaint(start);
            char[] s = new char[end - start];
            getChars(start, end, s, 0);
            SpannableString ss = new SpannableString(new String(s));
            TextUtils.copySpansFrom(mSpanned, start, end, Object.class, ss, 0);
CharSequence var182E37827114C3F455816E0E29D81D76_999382999 =             ss;
            var182E37827114C3F455816E0E29D81D76_999382999.addTaint(taint);
            return var182E37827114C3F455816E0E29D81D76_999382999;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.211 -0400", hash_original_field = "9588EEAF34B7EF093B8A162F81FAFD3E", hash_generated_field = "FE192F2602DC86D3649552171C1E7D82")

    private static final ParagraphStyle[] NO_PARA_SPANS = ArrayUtils.emptyArray(ParagraphStyle.class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.211 -0400", hash_original_field = "C98EF14E21465DCAA8481165D4FC8D06", hash_generated_field = "C5396A644D87D3ABF8FF4A210231B117")

    static final EmojiFactory EMOJI_FACTORY = EmojiFactory.newAvailableInstance();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.211 -0400", hash_original_field = "471F949A3986C3F4EDFE65343195112B", hash_generated_field = "50981D9CDB8FFE37DD0AD7398C887F29")

    static int MIN_EMOJI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.212 -0400", hash_original_field = "9BA5E1F2A793A8D05CB1371A5403608D", hash_generated_field = "2FF41CCD8E77FA54D79A8CE87AE76CE2")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.212 -0400", hash_original_field = "C4A38C1668AF8A793012B43F6161CD16", hash_generated_field = "AB6A5E15DD892E72F299B4D5FFE1ACBA")

    private static final Rect sTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.212 -0400", hash_original_field = "6FD91A9995B8B5FC3C8F7C455B83B35F", hash_generated_field = "52D12843713C54C6D6FE037A484C039E")

    public static final int DIR_LEFT_TO_RIGHT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.212 -0400", hash_original_field = "17318FEC2191C074ECAABD2C38659B46", hash_generated_field = "E624F93AD27646BB22CB05444CE41FB7")

    public static final int DIR_RIGHT_TO_LEFT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.212 -0400", hash_original_field = "137CDBC203F61667CC7E67D68F89D874", hash_generated_field = "A0CBE122653FD7E9E2403F87AECC077E")

    static final int DIR_REQUEST_LTR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.212 -0400", hash_original_field = "7BC355A5AAD6E5EADBC6B5C81FF9EFE0", hash_generated_field = "2F54902E23F337B8398BD9B8867448B7")

    static final int DIR_REQUEST_RTL = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.212 -0400", hash_original_field = "E08042CAD555C940FA4820833C645893", hash_generated_field = "6BC95B8DA1C0867C5BBC92C545EC37D0")

    static final int DIR_REQUEST_DEFAULT_LTR = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.212 -0400", hash_original_field = "2BC912CEB718B45E37D43B9DD28FCA06", hash_generated_field = "A3F4791226177B1A5BF0E7086C062229")

    static final int DIR_REQUEST_DEFAULT_RTL = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.212 -0400", hash_original_field = "39D3AAFD530E8474E92C1E2B18BF315E", hash_generated_field = "521C40F9C42E64AFA41DE5429A1FE88F")

    static final int RUN_LENGTH_MASK = 0x03ffffff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.212 -0400", hash_original_field = "039DB298A48FCCC6EC38DF1E608B281F", hash_generated_field = "FA295D4D1A0E6B715FE59ACD221F6ADA")

    static final int RUN_LEVEL_SHIFT = 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.212 -0400", hash_original_field = "75A423C35DF8A3E743B55A65B5C563B8", hash_generated_field = "94C9571A3583C54E6B7A075300DD0EE5")

    static final int RUN_LEVEL_MASK = 0x3f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.212 -0400", hash_original_field = "582E27236495D028F8DEF24E0A548B5E", hash_generated_field = "31D3CF26D80AD0E1199B880C73A98D4C")

    static final int RUN_RTL_FLAG = 1 << RUN_LEVEL_SHIFT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.212 -0400", hash_original_field = "5857BDFF3BF33113730586AF5B28164F", hash_generated_field = "D5E340FF9F0E2C74F920DF02A6624213")

    private static final int TAB_INCREMENT = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.212 -0400", hash_original_field = "016F06FA5D76A8D90674CD58FE50F840", hash_generated_field = "C8BA6950A23558C64F9FDDA3186A39D3")

    static final Directions DIRS_ALL_LEFT_TO_RIGHT = new Directions(new int[] { 0, RUN_LENGTH_MASK });
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.212 -0400", hash_original_field = "B75F87DE53400F9F37765D0FDC63007E", hash_generated_field = "F0C0143EECF2B25DCBC74C3BF9B92427")

    static final Directions DIRS_ALL_RIGHT_TO_LEFT = new Directions(new int[] { 0, RUN_LENGTH_MASK | RUN_RTL_FLAG });
}

