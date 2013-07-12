package android.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.style.ParagraphStyle;
import android.util.FloatMath;

public class BoringLayout extends Layout implements TextUtils.EllipsizeCallback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.785 -0400", hash_original_field = "A1A8097250F33D60B681CE49F40DD5EF", hash_generated_field = "1B339E7F22FA229115A323159C174907")

    private String mDirect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.786 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

    private Paint mPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.786 -0400", hash_original_field = "2FFD20D7E48915664FDF7F12FC3889D8", hash_generated_field = "E3BE43E8597DE7EA48FEB065FD52A21A")

    int mBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.786 -0400", hash_original_field = "7CC9BE6231ADF86659204A1B34464053", hash_generated_field = "73810C960686DE7D2398567074C867B2")

    int mDesc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.786 -0400", hash_original_field = "A6796D45932911E4DA1D9D40D1BD23B8", hash_generated_field = "74C5EEEB9113B0F29D66E0A4983A6BC3")

    private int mTopPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.786 -0400", hash_original_field = "097A31AA17188409E251DABE4869FAFE", hash_generated_field = "8A7C981A0C6837E513C477AD1250B374")

    private int mBottomPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.786 -0400", hash_original_field = "C886C6FF92A43B3F6833B7BAFD354FBA", hash_generated_field = "61EBA81EE8DC22B1F5E764B863E5361B")

    private float mMax;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.786 -0400", hash_original_field = "5713AC9F49879DE1055FA780DFEFDF1C", hash_generated_field = "C354DF48C5764CCC7B8B820C49BF2BBD")

    private int mEllipsizedWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.786 -0400", hash_original_field = "2500F3F15EEAC3B4C3773F3A0481EE44", hash_generated_field = "B5CB4429DE9FEE6D7E71228CD62A452F")

    private int mEllipsizedStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.786 -0400", hash_original_field = "99B4B7415CCA47573BDE1AEF6AEEFAB0", hash_generated_field = "AB882CB344FFDF6F2159A6342489C1EA")

    private int mEllipsizedCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.787 -0400", hash_original_method = "4AC8C9A33DE614873CD5C4119639BAC7", hash_generated_method = "8D2FEEB8D8E4FE0D7BC60530C30990FC")
    public  BoringLayout(CharSequence source,
                        TextPaint paint, int outerwidth,
                        Alignment align,
                        float spacingmult, float spacingadd,
                        BoringLayout.Metrics metrics, boolean includepad) {
        super(source, paint, outerwidth, align, spacingmult, spacingadd);
        addTaint(includepad);
        addTaint(metrics.getTaint());
        addTaint(spacingadd);
        addTaint(spacingmult);
        addTaint(align.getTaint());
        addTaint(paint.getTaint());
        addTaint(source.getTaint());
        mEllipsizedWidth = outerwidth;
        mEllipsizedStart = 0;
        mEllipsizedCount = 0;
        init(source, paint, outerwidth, align, spacingmult, spacingadd,
             metrics, includepad, true);
        
        
        
        
        
             
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.788 -0400", hash_original_method = "614BD9653B1F69671BF8486744526AD2", hash_generated_method = "39E62614F86006D0D161F6482294CE54")
    public  BoringLayout(CharSequence source,
                        TextPaint paint, int outerwidth,
                        Alignment align,
                        float spacingmult, float spacingadd,
                        BoringLayout.Metrics metrics, boolean includepad,
                        TextUtils.TruncateAt ellipsize, int ellipsizedWidth) {
        super(source, paint, outerwidth, align, spacingmult, spacingadd);
        addTaint(ellipsize.getTaint());
        addTaint(includepad);
        addTaint(metrics.getTaint());
        addTaint(spacingadd);
        addTaint(spacingmult);
        addTaint(align.getTaint());
        addTaint(paint.getTaint());
        addTaint(source.getTaint());
        boolean trust;
    if(ellipsize == null || ellipsize == TextUtils.TruncateAt.MARQUEE)        
        {
            mEllipsizedWidth = outerwidth;
            mEllipsizedStart = 0;
            mEllipsizedCount = 0;
            trust = true;
        } 
        else
        {
            replaceWith(TextUtils.ellipsize(source, paint, ellipsizedWidth,
                                           ellipsize, true, this),
                        paint, outerwidth, align, spacingmult,
                        spacingadd);
            mEllipsizedWidth = ellipsizedWidth;
            trust = false;
        } 
        init(getText(), paint, outerwidth, align, spacingmult, spacingadd,
             metrics, includepad, trust);
        
        
        
            
            
            
            
        
            
                                           
                        
                        
            
            
        
        
             
    }

    
        @DSModeled(DSC.SAFE)
    public static BoringLayout make(CharSequence source,
                        TextPaint paint, int outerwidth,
                        Alignment align,
                        float spacingmult, float spacingadd,
                        BoringLayout.Metrics metrics, boolean includepad) {
        return new BoringLayout(source, paint, outerwidth, align,
                                spacingmult, spacingadd, metrics,
                                includepad);
    }

    
        @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.790 -0400", hash_original_method = "CC7D93FCE240EB61BF168844CD074EBF", hash_generated_method = "853A916B14B7F48C47ADA005084DE4B6")
    public BoringLayout replaceOrMake(CharSequence source, TextPaint paint,
                                      int outerwidth, Alignment align,
                                      float spacingmult, float spacingadd,
                                      BoringLayout.Metrics metrics,
                                      boolean includepad) {
        addTaint(includepad);
        addTaint(metrics.getTaint());
        addTaint(spacingadd);
        addTaint(spacingmult);
        addTaint(align.getTaint());
        addTaint(paint.getTaint());
        addTaint(source.getTaint());
        replaceWith(source, paint, outerwidth, align, spacingmult,
                    spacingadd);
        mEllipsizedWidth = outerwidth;
        mEllipsizedStart = 0;
        mEllipsizedCount = 0;
        init(source, paint, outerwidth, align, spacingmult, spacingadd,
             metrics, includepad, true);
BoringLayout var72A74007B2BE62B849F475C7BDA4658B_251177696 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_251177696.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_251177696;
        
        
                    
        
        
        
        
             
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.791 -0400", hash_original_method = "4B78087A434BCC06D8E64A3B5F0E26A9", hash_generated_method = "1F10B5BC426D406510D39D4082351EAC")
    public BoringLayout replaceOrMake(CharSequence source, TextPaint paint,
                                      int outerwidth, Alignment align,
                                      float spacingmult, float spacingadd,
                                      BoringLayout.Metrics metrics,
                                      boolean includepad,
                                      TextUtils.TruncateAt ellipsize,
                                      int ellipsizedWidth) {
        addTaint(ellipsize.getTaint());
        addTaint(includepad);
        addTaint(metrics.getTaint());
        addTaint(spacingadd);
        addTaint(spacingmult);
        addTaint(align.getTaint());
        addTaint(paint.getTaint());
        addTaint(source.getTaint());
        boolean trust;
    if(ellipsize == null || ellipsize == TextUtils.TruncateAt.MARQUEE)        
        {
            replaceWith(source, paint, outerwidth, align, spacingmult,
                        spacingadd);
            mEllipsizedWidth = outerwidth;
            mEllipsizedStart = 0;
            mEllipsizedCount = 0;
            trust = true;
        } 
        else
        {
            replaceWith(TextUtils.ellipsize(source, paint, ellipsizedWidth,
                                           ellipsize, true, this),
                        paint, outerwidth, align, spacingmult,
                        spacingadd);
            mEllipsizedWidth = ellipsizedWidth;
            trust = false;
        } 
        init(getText(), paint, outerwidth, align, spacingmult, spacingadd,
             metrics, includepad, trust);
BoringLayout var72A74007B2BE62B849F475C7BDA4658B_1310294304 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1310294304.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1310294304;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.793 -0400", hash_original_method = "72A5FE71A3D3A6FEDD367DD5E3D986F4", hash_generated_method = "8D92F3E80D09FAB9D1848255EE22AD7D")
     void init(CharSequence source,
                            TextPaint paint, int outerwidth,
                            Alignment align,
                            float spacingmult, float spacingadd,
                            BoringLayout.Metrics metrics, boolean includepad,
                            boolean trustWidth) {
        addTaint(trustWidth);
        addTaint(includepad);
        addTaint(spacingadd);
        addTaint(spacingmult);
        addTaint(align.getTaint());
        addTaint(outerwidth);
        int spacing;
    if(source instanceof String && align == Layout.Alignment.ALIGN_NORMAL)        
        {
            mDirect = source.toString();
        } 
        else
        {
            mDirect = null;
        } 
        mPaint = paint;
    if(includepad)        
        {
            spacing = metrics.bottom - metrics.top;
        } 
        else
        {
            spacing = metrics.descent - metrics.ascent;
        } 
    if(spacingmult != 1 || spacingadd != 0)        
        {
            spacing = (int)(spacing * spacingmult + spacingadd + 0.5f);
        } 
        mBottom = spacing;
    if(includepad)        
        {
            mDesc = spacing + metrics.top;
        } 
        else
        {
            mDesc = spacing + metrics.ascent;
        } 
    if(trustWidth)        
        {
            mMax = metrics.width;
        } 
        else
        {
            TextLine line = TextLine.obtain();
            line.set(paint, source, 0, source.length(), Layout.DIR_LEFT_TO_RIGHT,
                    Layout.DIRS_ALL_LEFT_TO_RIGHT, false, null);
            mMax = (int) FloatMath.ceil(line.metrics(null));
            TextLine.recycle(line);
        } 
    if(includepad)        
        {
            mTopPadding = metrics.top - metrics.ascent;
            mBottomPadding = metrics.bottom - metrics.descent;
        } 
        
        
    }

    
        @DSModeled(DSC.SAFE)
    public static Metrics isBoring(CharSequence text,
                                   TextPaint paint) {
        return isBoring(text, paint, TextDirectionHeuristics.FIRSTSTRONG_LTR, null);
    }

    
        @DSModeled(DSC.SAFE)
    public static Metrics isBoring(CharSequence text,
                                   TextPaint paint,
                                   TextDirectionHeuristic textDir) {
        return isBoring(text, paint, textDir, null);
    }

    
        @DSModeled(DSC.SAFE)
    public static Metrics isBoring(CharSequence text, TextPaint paint, Metrics metrics) {
        return isBoring(text, paint, TextDirectionHeuristics.FIRSTSTRONG_LTR, metrics);
    }

    
        @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.794 -0400", hash_original_method = "9C145AF64C7D263F1721F68F7FF83F17", hash_generated_method = "68BE090A3F1BC905F3BACBE9CE7528C8")
    @Override
    public int getHeight() {
        int var2FFD20D7E48915664FDF7F12FC3889D8_1088727350 = (mBottom);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1568039373 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1568039373;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.795 -0400", hash_original_method = "2D16E05C4EC39BC67C8A172C64094881", hash_generated_method = "8D5A3F7039CD571179C4122ED76AA5DB")
    @Override
    public int getLineCount() {
        int varC4CA4238A0B923820DCC509A6F75849B_816997258 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_721405853 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_721405853;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.795 -0400", hash_original_method = "FC2E2A347EB554C00B43E510002C6FE3", hash_generated_method = "8819CF9198DE660F794A6B58C81215A0")
    @Override
    public int getLineTop(int line) {
        addTaint(line);
    if(line == 0)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_832595166 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2075460636 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2075460636;
        }
        else
        {
        int var2FFD20D7E48915664FDF7F12FC3889D8_1424768611 = (mBottom);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1790443223 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1790443223;
        }
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.795 -0400", hash_original_method = "CEFD06A93AC917501D80ABE3ADC321FA", hash_generated_method = "83FC06F2932580CE5D69124CF0AD39D9")
    @Override
    public int getLineDescent(int line) {
        addTaint(line);
        int var7CC9BE6231ADF86659204A1B34464053_746085590 = (mDesc);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_752375421 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_752375421;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.796 -0400", hash_original_method = "01507A0D62D72F853366982B51A08E39", hash_generated_method = "76485B401DA86BF4E0A8EF0F4C05F74E")
    @Override
    public int getLineStart(int line) {
        addTaint(line);
    if(line == 0)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_710798107 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1861061875 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1861061875;
        }
        else
        {
        int varEA3A6073ED6537ADE0FE819D1BEA414C_476376985 = (getText().length());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_76598082 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_76598082;
        }
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.796 -0400", hash_original_method = "C13A8C90111FE51B6C5C9E4F734C2F1E", hash_generated_method = "D3B511F5F415295C725446ECDE02872E")
    @Override
    public int getParagraphDirection(int line) {
        addTaint(line);
        int var43CB7D46F0E18F315D43B82024093B51_1408438821 = (DIR_LEFT_TO_RIGHT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1119212085 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1119212085;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.796 -0400", hash_original_method = "26D4049A2082A20A88CBFE67C9B7B59C", hash_generated_method = "FDE44573A427F6E7C2FD799E1B0A45B3")
    @Override
    public boolean getLineContainsTab(int line) {
        addTaint(line);
        boolean var68934A3E9455FA72420237EB05902327_1167291009 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1945497801 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1945497801;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.797 -0400", hash_original_method = "B75E83FBFEF77E240A9CDC2AC2A1C8A4", hash_generated_method = "5EEE49346A0F00A3FF0A16C8C7FA2E29")
    @Override
    public float getLineMax(int line) {
        addTaint(line);
        float varC886C6FF92A43B3F6833B7BAFD354FBA_1159998321 = (mMax);
                float var546ADE640B6EDFBC8A086EF31347E768_1940717709 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1940717709;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.797 -0400", hash_original_method = "6C6069268CAFC6462BC63ED1C5A7526F", hash_generated_method = "7025D5B77A4B1EE4D60CBA09FC2C98FA")
    @Override
    public final Directions getLineDirections(int line) {
        addTaint(line);
Directions var23DB167A4CD06697C566FA0F2EDA02AD_325199986 =         Layout.DIRS_ALL_LEFT_TO_RIGHT;
        var23DB167A4CD06697C566FA0F2EDA02AD_325199986.addTaint(taint);
        return var23DB167A4CD06697C566FA0F2EDA02AD_325199986;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.797 -0400", hash_original_method = "0410F05B3F48387C42DB277B8067D4A9", hash_generated_method = "5B687631A7DD90F82DC7B7BF3E57F360")
    @Override
    public int getTopPadding() {
        int varA6796D45932911E4DA1D9D40D1BD23B8_197646289 = (mTopPadding);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1979679193 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1979679193;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.798 -0400", hash_original_method = "A7597317BC8A3102F80AD4E9AD038652", hash_generated_method = "1FAC89B3440BAEC26321429BF16F5BB9")
    @Override
    public int getBottomPadding() {
        int var097A31AA17188409E251DABE4869FAFE_1190377268 = (mBottomPadding);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318032538 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318032538;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.798 -0400", hash_original_method = "BD15B39FEBBFBBCAB07017E8474F5CA3", hash_generated_method = "1B8CC654F81219D340FF2408B8CAABC1")
    @Override
    public int getEllipsisCount(int line) {
        addTaint(line);
        int var99B4B7415CCA47573BDE1AEF6AEEFAB0_1948269478 = (mEllipsizedCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1714003637 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1714003637;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.798 -0400", hash_original_method = "414A86D89277DC065BB670E3078E25DD", hash_generated_method = "83C0CD3E80D43BA536B627B3A5A23969")
    @Override
    public int getEllipsisStart(int line) {
        addTaint(line);
        int var2500F3F15EEAC3B4C3773F3A0481EE44_1771532747 = (mEllipsizedStart);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1589571484 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1589571484;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.799 -0400", hash_original_method = "5CA9F8625BABB74DD57E485BAAAC3103", hash_generated_method = "9412CEF5FDC1DCD959E1A804B44580A1")
    @Override
    public int getEllipsizedWidth() {
        int var5713AC9F49879DE1055FA780DFEFDF1C_1054643706 = (mEllipsizedWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1229904885 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1229904885;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.800 -0400", hash_original_method = "5DBC6B0379E5085B5017E1E8304BC3E8", hash_generated_method = "6F5C2BFC013386888C3EB997E08D5CF6")
    @Override
    public void draw(Canvas c, Path highlight, Paint highlightpaint,
                     int cursorOffset) {
        addTaint(cursorOffset);
        addTaint(highlightpaint.getTaint());
        addTaint(highlight.getTaint());
        addTaint(c.getTaint());
    if(mDirect != null && highlight == null)        
        {
            c.drawText(mDirect, 0, mBottom - mDesc, mPaint);
        } 
        else
        {
            super.draw(c, highlight, highlightpaint, cursorOffset);
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.800 -0400", hash_original_method = "C8834FD4CE389B3AEF157EF49CB23721", hash_generated_method = "3908F2E0EC97B329D0B6E5A4EAB40C7A")
    public void ellipsized(int start, int end) {
        mEllipsizedStart = start;
        mEllipsizedCount = end - start;
        
        
        
    }

    
    public static class Metrics extends Paint.FontMetricsInt {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.801 -0400", hash_original_field = "EAAE26A6FB20ED3EF54FB23BFA0B1FCC", hash_generated_field = "6FAF64E7577371F06EC12EBE94C8466B")

        public int width;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.801 -0400", hash_original_method = "5093089FD85953828BC1A867B844524A", hash_generated_method = "5093089FD85953828BC1A867B844524A")
        public Metrics ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.801 -0400", hash_original_method = "12CBEFE116384BBA88EB750F89F5AC01", hash_generated_method = "E4B07024AFFFB583A0126BA333E0A302")
        @Override
        public String toString() {
String varF4BEA69CAC1BC0FE4DC5F53DAD03EA66_351455653 =             super.toString() + " width=" + width;
            varF4BEA69CAC1BC0FE4DC5F53DAD03EA66_351455653.addTaint(taint);
            return varF4BEA69CAC1BC0FE4DC5F53DAD03EA66_351455653;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.801 -0400", hash_original_field = "E7073F236704D4E004CC35F088F3B8FE", hash_generated_field = "C2F2F45019948F5515A5534F9B80EBF4")

    private static final char FIRST_RIGHT_TO_LEFT = '\u0590';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.801 -0400", hash_original_field = "8EBB63FE0098AB9E6EEA3F3E4D53E8B6", hash_generated_field = "AEB4C46A4C665812604A1CC18568D7E1")

    private static final TextPaint sTemp = new TextPaint();
}

