package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.style.ParagraphStyle;
import android.util.FloatMath;

public class BoringLayout extends Layout implements TextUtils.EllipsizeCallback {
    private static final char FIRST_RIGHT_TO_LEFT = '\u0590';
    private String mDirect;
    private Paint mPaint;
    int mBottom, mDesc;
    private int mTopPadding, mBottomPadding;
    private float mMax;
    private int mEllipsizedWidth, mEllipsizedStart, mEllipsizedCount;
    private static final TextPaint sTemp =
                                new TextPaint();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.876 -0400", hash_original_method = "4AC8C9A33DE614873CD5C4119639BAC7", hash_generated_method = "1CE8892C722E7DE5C6C0210620BDC040")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BoringLayout(CharSequence source,
                        TextPaint paint, int outerwidth,
                        Alignment align,
                        float spacingmult, float spacingadd,
                        BoringLayout.Metrics metrics, boolean includepad) {
        super(source, paint, outerwidth, align, spacingmult, spacingadd);
        dsTaint.addTaint(includepad);
        dsTaint.addTaint(source);
        dsTaint.addTaint(outerwidth);
        dsTaint.addTaint(metrics.dsTaint);
        dsTaint.addTaint(align.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(spacingadd);
        dsTaint.addTaint(spacingmult);
        mEllipsizedStart = 0;
        mEllipsizedCount = 0;
        init(source, paint, outerwidth, align, spacingmult, spacingadd,
             metrics, includepad, true);
        // ---------- Original Method ----------
        //mEllipsizedWidth = outerwidth;
        //mEllipsizedStart = 0;
        //mEllipsizedCount = 0;
        //init(source, paint, outerwidth, align, spacingmult, spacingadd,
             //metrics, includepad, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.876 -0400", hash_original_method = "614BD9653B1F69671BF8486744526AD2", hash_generated_method = "BD59712824FE90F42134D06145145289")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BoringLayout(CharSequence source,
                        TextPaint paint, int outerwidth,
                        Alignment align,
                        float spacingmult, float spacingadd,
                        BoringLayout.Metrics metrics, boolean includepad,
                        TextUtils.TruncateAt ellipsize, int ellipsizedWidth) {
        super(source, paint, outerwidth, align, spacingmult, spacingadd);
        dsTaint.addTaint(includepad);
        dsTaint.addTaint(ellipsizedWidth);
        dsTaint.addTaint(source);
        dsTaint.addTaint(outerwidth);
        dsTaint.addTaint(metrics.dsTaint);
        dsTaint.addTaint(align.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(spacingadd);
        dsTaint.addTaint(spacingmult);
        dsTaint.addTaint(ellipsize.dsTaint);
        boolean trust;
        {
            mEllipsizedStart = 0;
            mEllipsizedCount = 0;
            trust = true;
        } //End block
        {
            replaceWith(TextUtils.ellipsize(source, paint, ellipsizedWidth,
                                           ellipsize, true, this),
                        paint, outerwidth, align, spacingmult,
                        spacingadd);
            trust = false;
        } //End block
        init(getText(), paint, outerwidth, align, spacingmult, spacingadd,
             metrics, includepad, trust);
        // ---------- Original Method ----------
        //boolean trust;
        //if (ellipsize == null || ellipsize == TextUtils.TruncateAt.MARQUEE) {
            //mEllipsizedWidth = outerwidth;
            //mEllipsizedStart = 0;
            //mEllipsizedCount = 0;
            //trust = true;
        //} else {
            //replaceWith(TextUtils.ellipsize(source, paint, ellipsizedWidth,
                                           //ellipsize, true, this),
                        //paint, outerwidth, align, spacingmult,
                        //spacingadd);
            //mEllipsizedWidth = ellipsizedWidth;
            //trust = false;
        //}
        //init(getText(), paint, outerwidth, align, spacingmult, spacingadd,
             //metrics, includepad, trust);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.876 -0400", hash_original_method = "45302125C5623367D121D61EE264BB3D", hash_generated_method = "B6F6733ADD16B96B785BE8B828E1CB18")
    public static BoringLayout make(CharSequence source,
                        TextPaint paint, int outerwidth,
                        Alignment align,
                        float spacingmult, float spacingadd,
                        BoringLayout.Metrics metrics, boolean includepad) {
        return new BoringLayout(source, paint, outerwidth, align,
                                spacingmult, spacingadd, metrics,
                                includepad);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.876 -0400", hash_original_method = "6E63C5CDA40BE5F908BE8F8A47E2CA22", hash_generated_method = "EAC7D9B3733B40AF40E6CEC4555A65F1")
    public static BoringLayout make(CharSequence source,
                        TextPaint paint, int outerwidth,
                        Alignment align,
                        float spacingmult, float spacingadd,
                        BoringLayout.Metrics metrics, boolean includepad,
                        TextUtils.TruncateAt ellipsize, int ellipsizedWidth) {
        return new BoringLayout(source, paint, outerwidth, align,
                                spacingmult, spacingadd, metrics,
                                includepad, ellipsize, ellipsizedWidth);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.876 -0400", hash_original_method = "CC7D93FCE240EB61BF168844CD074EBF", hash_generated_method = "D2DBE16C245D7EEFC3D53E152BA07A2F")
    @DSModeled(DSC.SAFE)
    public BoringLayout replaceOrMake(CharSequence source, TextPaint paint,
                                      int outerwidth, Alignment align,
                                      float spacingmult, float spacingadd,
                                      BoringLayout.Metrics metrics,
                                      boolean includepad) {
        dsTaint.addTaint(includepad);
        dsTaint.addTaint(source);
        dsTaint.addTaint(outerwidth);
        dsTaint.addTaint(metrics.dsTaint);
        dsTaint.addTaint(align.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(spacingadd);
        dsTaint.addTaint(spacingmult);
        replaceWith(source, paint, outerwidth, align, spacingmult,
                    spacingadd);
        mEllipsizedStart = 0;
        mEllipsizedCount = 0;
        init(source, paint, outerwidth, align, spacingmult, spacingadd,
             metrics, includepad, true);
        return (BoringLayout)dsTaint.getTaint();
        // ---------- Original Method ----------
        //replaceWith(source, paint, outerwidth, align, spacingmult,
                    //spacingadd);
        //mEllipsizedWidth = outerwidth;
        //mEllipsizedStart = 0;
        //mEllipsizedCount = 0;
        //init(source, paint, outerwidth, align, spacingmult, spacingadd,
             //metrics, includepad, true);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.877 -0400", hash_original_method = "4B78087A434BCC06D8E64A3B5F0E26A9", hash_generated_method = "2625914EB97F49CBEDB3E73D386AB210")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BoringLayout replaceOrMake(CharSequence source, TextPaint paint,
                                      int outerwidth, Alignment align,
                                      float spacingmult, float spacingadd,
                                      BoringLayout.Metrics metrics,
                                      boolean includepad,
                                      TextUtils.TruncateAt ellipsize,
                                      int ellipsizedWidth) {
        dsTaint.addTaint(includepad);
        dsTaint.addTaint(ellipsizedWidth);
        dsTaint.addTaint(source);
        dsTaint.addTaint(outerwidth);
        dsTaint.addTaint(metrics.dsTaint);
        dsTaint.addTaint(align.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(spacingadd);
        dsTaint.addTaint(spacingmult);
        dsTaint.addTaint(ellipsize.dsTaint);
        boolean trust;
        {
            replaceWith(source, paint, outerwidth, align, spacingmult,
                        spacingadd);
            mEllipsizedStart = 0;
            mEllipsizedCount = 0;
            trust = true;
        } //End block
        {
            replaceWith(TextUtils.ellipsize(source, paint, ellipsizedWidth,
                                           ellipsize, true, this),
                        paint, outerwidth, align, spacingmult,
                        spacingadd);
            trust = false;
        } //End block
        init(getText(), paint, outerwidth, align, spacingmult, spacingadd,
             metrics, includepad, trust);
        return (BoringLayout)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.877 -0400", hash_original_method = "72A5FE71A3D3A6FEDD367DD5E3D986F4", hash_generated_method = "995D3938BF923C3708B6147F02B0519C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void init(CharSequence source,
                            TextPaint paint, int outerwidth,
                            Alignment align,
                            float spacingmult, float spacingadd,
                            BoringLayout.Metrics metrics, boolean includepad,
                            boolean trustWidth) {
        dsTaint.addTaint(includepad);
        dsTaint.addTaint(source);
        dsTaint.addTaint(outerwidth);
        dsTaint.addTaint(metrics.dsTaint);
        dsTaint.addTaint(align.dsTaint);
        dsTaint.addTaint(trustWidth);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(spacingadd);
        dsTaint.addTaint(spacingmult);
        int spacing;
        {
            mDirect = source.toString();
        } //End block
        {
            mDirect = null;
        } //End block
        {
            spacing = metrics.bottom - metrics.top;
        } //End block
        {
            spacing = metrics.descent - metrics.ascent;
        } //End block
        {
            spacing = (int)(spacing * spacingmult + spacingadd + 0.5f);
        } //End block
        mBottom = spacing;
        {
            mDesc = spacing + metrics.top;
        } //End block
        {
            mDesc = spacing + metrics.ascent;
        } //End block
        {
            mMax = metrics.width;
        } //End block
        {
            TextLine line;
            line = TextLine.obtain();
            line.set(paint, source, 0, source.length(), Layout.DIR_LEFT_TO_RIGHT,
                    Layout.DIRS_ALL_LEFT_TO_RIGHT, false, null);
            mMax = (int) FloatMath.ceil(line.metrics(null));
            TextLine.recycle(line);
        } //End block
        {
            mTopPadding = metrics.top - metrics.ascent;
            mBottomPadding = metrics.bottom - metrics.descent;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.877 -0400", hash_original_method = "96B9D5C527FFE50D39D28C5BAE93E1F6", hash_generated_method = "7DDC272504240B7C0817A1EDA013058A")
    public static Metrics isBoring(CharSequence text,
                                   TextPaint paint) {
        return isBoring(text, paint, TextDirectionHeuristics.FIRSTSTRONG_LTR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.877 -0400", hash_original_method = "4C34347B458F16A46FBA6214D1ED5964", hash_generated_method = "A6CCBBAD1B4ECC995F624A6D656399FE")
    public static Metrics isBoring(CharSequence text,
                                   TextPaint paint,
                                   TextDirectionHeuristic textDir) {
        return isBoring(text, paint, textDir, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.877 -0400", hash_original_method = "94FF10F23CAC1DAA4FE15530650F9ABB", hash_generated_method = "6077B41364B1F42147C038DAED378094")
    public static Metrics isBoring(CharSequence text, TextPaint paint, Metrics metrics) {
        return isBoring(text, paint, TextDirectionHeuristics.FIRSTSTRONG_LTR, metrics);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.877 -0400", hash_original_method = "C478053468A8ECCA4C801EC7C4CA3211", hash_generated_method = "AC4E2B54F11003706D3423743D1E5DA8")
    public static Metrics isBoring(CharSequence text, TextPaint paint,
            TextDirectionHeuristic textDir, Metrics metrics) {
        char[] temp = TextUtils.obtain(500);
        int length = text.length();
        boolean boring = true;
        outer:
        for (int i = 0; i < length; i += 500) {
            int j = i + 500;
            if (j > length)
                j = length;
            TextUtils.getChars(text, i, j, temp, 0);
            int n = j - i;
            for (int a = 0; a < n; a++) {
                char c = temp[a];
                if (c == '\n' || c == '\t' || c >= FIRST_RIGHT_TO_LEFT) {
                    boring = false;
                    break outer;
                }
            }
            if (textDir != null && textDir.isRtl(temp, 0, n)) {
               boring = false;
               break outer;
            }
        }
        TextUtils.recycle(temp);
        if (boring && text instanceof Spanned) {
            Spanned sp = (Spanned) text;
            Object[] styles = sp.getSpans(0, length, ParagraphStyle.class);
            if (styles.length > 0) {
                boring = false;
            }
        }
        if (boring) {
            Metrics fm = metrics;
            if (fm == null) {
                fm = new Metrics();
            }
            TextLine line = TextLine.obtain();
            line.set(paint, text, 0, length, Layout.DIR_LEFT_TO_RIGHT,
                    Layout.DIRS_ALL_LEFT_TO_RIGHT, false, null);
            fm.width = (int) FloatMath.ceil(line.metrics(fm));
            TextLine.recycle(line);
            return fm;
        } else {
            return null;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.878 -0400", hash_original_method = "9C145AF64C7D263F1721F68F7FF83F17", hash_generated_method = "DC4623A636E54F3692C799452A5AEAB5")
    @DSModeled(DSC.SAFE)
    @Override
    public int getHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.878 -0400", hash_original_method = "2D16E05C4EC39BC67C8A172C64094881", hash_generated_method = "46CD6D34D14697DE744CBEE3D201893C")
    @DSModeled(DSC.SAFE)
    @Override
    public int getLineCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.878 -0400", hash_original_method = "FC2E2A347EB554C00B43E510002C6FE3", hash_generated_method = "EF674EE969B4D1D170E6698FA6D5BDDE")
    @DSModeled(DSC.SAFE)
    @Override
    public int getLineTop(int line) {
        dsTaint.addTaint(line);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (line == 0)
            //return 0;
        //else
            //return mBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.878 -0400", hash_original_method = "CEFD06A93AC917501D80ABE3ADC321FA", hash_generated_method = "F6B1C3C854566FDE082831778CE5DF21")
    @DSModeled(DSC.SAFE)
    @Override
    public int getLineDescent(int line) {
        dsTaint.addTaint(line);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDesc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.878 -0400", hash_original_method = "01507A0D62D72F853366982B51A08E39", hash_generated_method = "28C844E7709D114B70D7B5283269EC1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getLineStart(int line) {
        dsTaint.addTaint(line);
        int var2BC251CDB6A58C428C92AE4E96100B61_1159881309 = (getText().length());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (line == 0)
            //return 0;
        //else
            //return getText().length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.878 -0400", hash_original_method = "C13A8C90111FE51B6C5C9E4F734C2F1E", hash_generated_method = "F45F91FF0A0A3C37BC35B6542D7E205D")
    @DSModeled(DSC.SAFE)
    @Override
    public int getParagraphDirection(int line) {
        dsTaint.addTaint(line);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return DIR_LEFT_TO_RIGHT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.878 -0400", hash_original_method = "26D4049A2082A20A88CBFE67C9B7B59C", hash_generated_method = "81116B877BBB054F66D27F03DF6F0608")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean getLineContainsTab(int line) {
        dsTaint.addTaint(line);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.878 -0400", hash_original_method = "B75E83FBFEF77E240A9CDC2AC2A1C8A4", hash_generated_method = "2B40D077CD539293D1A54639F76C6C89")
    @DSModeled(DSC.SAFE)
    @Override
    public float getLineMax(int line) {
        dsTaint.addTaint(line);
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mMax;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.878 -0400", hash_original_method = "6C6069268CAFC6462BC63ED1C5A7526F", hash_generated_method = "7BCDD1932C5A7A50A7A612F4462EABAC")
    @DSModeled(DSC.SAFE)
    @Override
    public final Directions getLineDirections(int line) {
        dsTaint.addTaint(line);
        return (Directions)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Layout.DIRS_ALL_LEFT_TO_RIGHT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.878 -0400", hash_original_method = "0410F05B3F48387C42DB277B8067D4A9", hash_generated_method = "3206C3D5D64093B50F5E3C44B092BEB6")
    @DSModeled(DSC.SAFE)
    @Override
    public int getTopPadding() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTopPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.878 -0400", hash_original_method = "A7597317BC8A3102F80AD4E9AD038652", hash_generated_method = "4F019809A7F04C0B6EB7FDA42C7B930F")
    @DSModeled(DSC.SAFE)
    @Override
    public int getBottomPadding() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBottomPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.878 -0400", hash_original_method = "BD15B39FEBBFBBCAB07017E8474F5CA3", hash_generated_method = "073540EF376FFB67C6ADE14CAB0983FF")
    @DSModeled(DSC.SAFE)
    @Override
    public int getEllipsisCount(int line) {
        dsTaint.addTaint(line);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEllipsizedCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.878 -0400", hash_original_method = "414A86D89277DC065BB670E3078E25DD", hash_generated_method = "09D2DDD203C196A55FA4ACF4C2E9B9CC")
    @DSModeled(DSC.SAFE)
    @Override
    public int getEllipsisStart(int line) {
        dsTaint.addTaint(line);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEllipsizedStart;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.878 -0400", hash_original_method = "5CA9F8625BABB74DD57E485BAAAC3103", hash_generated_method = "9A9295147C4E56EF5CDEDCCF5DF22A7F")
    @DSModeled(DSC.SAFE)
    @Override
    public int getEllipsizedWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEllipsizedWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.879 -0400", hash_original_method = "5DBC6B0379E5085B5017E1E8304BC3E8", hash_generated_method = "F44DB8A03C56AFF8AE657513EF0E8B32")
    @DSModeled(DSC.SAFE)
    @Override
    public void draw(Canvas c, Path highlight, Paint highlightpaint,
                     int cursorOffset) {
        dsTaint.addTaint(highlightpaint.dsTaint);
        dsTaint.addTaint(cursorOffset);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(highlight.dsTaint);
        {
            c.drawText(mDirect, 0, mBottom - mDesc, mPaint);
        } //End block
        {
            super.draw(c, highlight, highlightpaint, cursorOffset);
        } //End block
        // ---------- Original Method ----------
        //if (mDirect != null && highlight == null) {
            //c.drawText(mDirect, 0, mBottom - mDesc, mPaint);
        //} else {
            //super.draw(c, highlight, highlightpaint, cursorOffset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.879 -0400", hash_original_method = "C8834FD4CE389B3AEF157EF49CB23721", hash_generated_method = "1F0A2F68073AD36AAF1CA569F09570C7")
    @DSModeled(DSC.SAFE)
    public void ellipsized(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        mEllipsizedCount = end - start;
        // ---------- Original Method ----------
        //mEllipsizedStart = start;
        //mEllipsizedCount = end - start;
    }

    
    public static class Metrics extends Paint.FontMetricsInt {
        public int width;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.879 -0400", hash_original_method = "12CBEFE116384BBA88EB750F89F5AC01", hash_generated_method = "FE297340CC44A9F486D0AB8C90ED658C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var8E2BD5BD84B181EEFFC2E1C84D8295B9_1605330896 = (super.toString() + " width=" + width);
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return super.toString() + " width=" + width;
        }

        
    }


    
}


