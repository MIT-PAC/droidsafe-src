package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.style.ParagraphStyle;
import android.util.FloatMath;

public class BoringLayout extends Layout implements TextUtils.EllipsizeCallback {
    private String mDirect;
    private Paint mPaint;
    int mBottom, mDesc;
    private int mTopPadding, mBottomPadding;
    private float mMax;
    private int mEllipsizedWidth, mEllipsizedStart, mEllipsizedCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.992 -0400", hash_original_method = "4AC8C9A33DE614873CD5C4119639BAC7", hash_generated_method = "0E45A2119CEB9BA46908D8CB04D5B88F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BoringLayout(CharSequence source,
                        TextPaint paint, int outerwidth,
                        Alignment align,
                        float spacingmult, float spacingadd,
                        BoringLayout.Metrics metrics, boolean includepad) {
        super(source, paint, outerwidth, align, spacingmult, spacingadd);
        dsTaint.addTaint(includepad);
        dsTaint.addTaint(outerwidth);
        dsTaint.addTaint(source);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.992 -0400", hash_original_method = "614BD9653B1F69671BF8486744526AD2", hash_generated_method = "548586D97FB46F047ADEA306BB832558")
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
        dsTaint.addTaint(outerwidth);
        dsTaint.addTaint(source);
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

    
        public static BoringLayout make(CharSequence source,
                        TextPaint paint, int outerwidth,
                        Alignment align,
                        float spacingmult, float spacingadd,
                        BoringLayout.Metrics metrics, boolean includepad) {
        return new BoringLayout(source, paint, outerwidth, align,
                                spacingmult, spacingadd, metrics,
                                includepad);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.993 -0400", hash_original_method = "CC7D93FCE240EB61BF168844CD074EBF", hash_generated_method = "FCC5FA38BEFCBC294FD29E0BDE2A3D2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BoringLayout replaceOrMake(CharSequence source, TextPaint paint,
                                      int outerwidth, Alignment align,
                                      float spacingmult, float spacingadd,
                                      BoringLayout.Metrics metrics,
                                      boolean includepad) {
        dsTaint.addTaint(includepad);
        dsTaint.addTaint(outerwidth);
        dsTaint.addTaint(source);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.993 -0400", hash_original_method = "4B78087A434BCC06D8E64A3B5F0E26A9", hash_generated_method = "5D619B0C5EE02A881ECB947CAB9EBFF5")
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
        dsTaint.addTaint(outerwidth);
        dsTaint.addTaint(source);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.994 -0400", hash_original_method = "72A5FE71A3D3A6FEDD367DD5E3D986F4", hash_generated_method = "0034946177FDE9F4FAC6F921CDF97BF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void init(CharSequence source,
                            TextPaint paint, int outerwidth,
                            Alignment align,
                            float spacingmult, float spacingadd,
                            BoringLayout.Metrics metrics, boolean includepad,
                            boolean trustWidth) {
        dsTaint.addTaint(includepad);
        dsTaint.addTaint(outerwidth);
        dsTaint.addTaint(source);
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

    
        public static Metrics isBoring(CharSequence text,
                                   TextPaint paint) {
        return isBoring(text, paint, TextDirectionHeuristics.FIRSTSTRONG_LTR, null);
    }

    
        public static Metrics isBoring(CharSequence text,
                                   TextPaint paint,
                                   TextDirectionHeuristic textDir) {
        return isBoring(text, paint, textDir, null);
    }

    
        public static Metrics isBoring(CharSequence text, TextPaint paint, Metrics metrics) {
        return isBoring(text, paint, TextDirectionHeuristics.FIRSTSTRONG_LTR, metrics);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.995 -0400", hash_original_method = "9C145AF64C7D263F1721F68F7FF83F17", hash_generated_method = "4F927A66F384A09993A51B123408C67C")
    @DSModeled(DSC.SAFE)
    @Override
    public int getHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.995 -0400", hash_original_method = "2D16E05C4EC39BC67C8A172C64094881", hash_generated_method = "6234B1A9685F916D8DE2BA463EB9746C")
    @DSModeled(DSC.SAFE)
    @Override
    public int getLineCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.996 -0400", hash_original_method = "FC2E2A347EB554C00B43E510002C6FE3", hash_generated_method = "387746E8B27AAF7067D5B6DF3A8D3FFE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.996 -0400", hash_original_method = "CEFD06A93AC917501D80ABE3ADC321FA", hash_generated_method = "781C354E0BAB554382AF75B90E5B45B1")
    @DSModeled(DSC.SAFE)
    @Override
    public int getLineDescent(int line) {
        dsTaint.addTaint(line);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDesc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.996 -0400", hash_original_method = "01507A0D62D72F853366982B51A08E39", hash_generated_method = "92DE044184C14E9DA89D436BB32FE5E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getLineStart(int line) {
        dsTaint.addTaint(line);
        int var2BC251CDB6A58C428C92AE4E96100B61_1814887083 = (getText().length());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (line == 0)
            //return 0;
        //else
            //return getText().length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.996 -0400", hash_original_method = "C13A8C90111FE51B6C5C9E4F734C2F1E", hash_generated_method = "30504F37CAB0874D322B89F06C465A1C")
    @DSModeled(DSC.SAFE)
    @Override
    public int getParagraphDirection(int line) {
        dsTaint.addTaint(line);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return DIR_LEFT_TO_RIGHT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.996 -0400", hash_original_method = "26D4049A2082A20A88CBFE67C9B7B59C", hash_generated_method = "C63C0885A5DD95D2CE1F3462414693A2")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean getLineContainsTab(int line) {
        dsTaint.addTaint(line);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.997 -0400", hash_original_method = "B75E83FBFEF77E240A9CDC2AC2A1C8A4", hash_generated_method = "A214BF71E5CEC90161BF8B900DD55F54")
    @DSModeled(DSC.SAFE)
    @Override
    public float getLineMax(int line) {
        dsTaint.addTaint(line);
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mMax;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.997 -0400", hash_original_method = "6C6069268CAFC6462BC63ED1C5A7526F", hash_generated_method = "9962281338D239DDD82672B8D4208766")
    @DSModeled(DSC.SAFE)
    @Override
    public final Directions getLineDirections(int line) {
        dsTaint.addTaint(line);
        return (Directions)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Layout.DIRS_ALL_LEFT_TO_RIGHT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.997 -0400", hash_original_method = "0410F05B3F48387C42DB277B8067D4A9", hash_generated_method = "FA47B026F2C44A937D9C405114C71495")
    @DSModeled(DSC.SAFE)
    @Override
    public int getTopPadding() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTopPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.997 -0400", hash_original_method = "A7597317BC8A3102F80AD4E9AD038652", hash_generated_method = "6889C8E9FBF2C0906C69CE0D62BF8388")
    @DSModeled(DSC.SAFE)
    @Override
    public int getBottomPadding() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBottomPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.997 -0400", hash_original_method = "BD15B39FEBBFBBCAB07017E8474F5CA3", hash_generated_method = "2D7669F355B85DCF9413BFBB7B721BA9")
    @DSModeled(DSC.SAFE)
    @Override
    public int getEllipsisCount(int line) {
        dsTaint.addTaint(line);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEllipsizedCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.998 -0400", hash_original_method = "414A86D89277DC065BB670E3078E25DD", hash_generated_method = "88D81F06125E56F7183C8F8674205783")
    @DSModeled(DSC.SAFE)
    @Override
    public int getEllipsisStart(int line) {
        dsTaint.addTaint(line);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEllipsizedStart;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.998 -0400", hash_original_method = "5CA9F8625BABB74DD57E485BAAAC3103", hash_generated_method = "1883110F0CECE5EEE366F4E7139C3405")
    @DSModeled(DSC.SAFE)
    @Override
    public int getEllipsizedWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEllipsizedWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.998 -0400", hash_original_method = "5DBC6B0379E5085B5017E1E8304BC3E8", hash_generated_method = "7F7F2337BB6C3E49A98AB12C9E9EE7AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.998 -0400", hash_original_method = "C8834FD4CE389B3AEF157EF49CB23721", hash_generated_method = "74C7B7413EA89743986D92F2E1674D02")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.999 -0400", hash_original_method = "8A6FFC0242914A0A4F28CF813F26452E", hash_generated_method = "8A6FFC0242914A0A4F28CF813F26452E")
                public Metrics ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.999 -0400", hash_original_method = "12CBEFE116384BBA88EB750F89F5AC01", hash_generated_method = "31464A9C3920D86E4C083062C06C376E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var8E2BD5BD84B181EEFFC2E1C84D8295B9_719989289 = (super.toString() + " width=" + width);
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return super.toString() + " width=" + width;
        }

        
    }


    
    private static final char FIRST_RIGHT_TO_LEFT = '\u0590';
    private static final TextPaint sTemp =
                                new TextPaint();
}

