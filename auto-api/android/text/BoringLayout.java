package android.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.style.ParagraphStyle;
import android.util.FloatMath;

public class BoringLayout extends Layout implements TextUtils.EllipsizeCallback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.547 -0400", hash_original_field = "A1A8097250F33D60B681CE49F40DD5EF", hash_generated_field = "1B339E7F22FA229115A323159C174907")

    private String mDirect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.547 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

    private Paint mPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.547 -0400", hash_original_field = "2FFD20D7E48915664FDF7F12FC3889D8", hash_generated_field = "E3BE43E8597DE7EA48FEB065FD52A21A")

    int mBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.547 -0400", hash_original_field = "7CC9BE6231ADF86659204A1B34464053", hash_generated_field = "73810C960686DE7D2398567074C867B2")

    int mDesc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.547 -0400", hash_original_field = "A6796D45932911E4DA1D9D40D1BD23B8", hash_generated_field = "74C5EEEB9113B0F29D66E0A4983A6BC3")

    private int mTopPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.547 -0400", hash_original_field = "097A31AA17188409E251DABE4869FAFE", hash_generated_field = "8A7C981A0C6837E513C477AD1250B374")

    private int mBottomPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.547 -0400", hash_original_field = "C886C6FF92A43B3F6833B7BAFD354FBA", hash_generated_field = "61EBA81EE8DC22B1F5E764B863E5361B")

    private float mMax;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.547 -0400", hash_original_field = "5713AC9F49879DE1055FA780DFEFDF1C", hash_generated_field = "C354DF48C5764CCC7B8B820C49BF2BBD")

    private int mEllipsizedWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.547 -0400", hash_original_field = "2500F3F15EEAC3B4C3773F3A0481EE44", hash_generated_field = "B5CB4429DE9FEE6D7E71228CD62A452F")

    private int mEllipsizedStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.547 -0400", hash_original_field = "99B4B7415CCA47573BDE1AEF6AEEFAB0", hash_generated_field = "AB882CB344FFDF6F2159A6342489C1EA")

    private int mEllipsizedCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.547 -0400", hash_original_method = "4AC8C9A33DE614873CD5C4119639BAC7", hash_generated_method = "90F5A02B9B2F360A686872DEC4B3E887")
    public  BoringLayout(CharSequence source,
                        TextPaint paint, int outerwidth,
                        Alignment align,
                        float spacingmult, float spacingadd,
                        BoringLayout.Metrics metrics, boolean includepad) {
        super(source, paint, outerwidth, align, spacingmult, spacingadd);
        mEllipsizedWidth = outerwidth;
        mEllipsizedStart = 0;
        mEllipsizedCount = 0;
        init(source, paint, outerwidth, align, spacingmult, spacingadd,
             metrics, includepad, true);
        addTaint(source.getTaint());
        addTaint(paint.getTaint());
        addTaint(align.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(metrics.getTaint());
        addTaint(includepad);
        
        
        
        
        
             
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.548 -0400", hash_original_method = "614BD9653B1F69671BF8486744526AD2", hash_generated_method = "B626D874B34983AC090BF74B4AF114DF")
    public  BoringLayout(CharSequence source,
                        TextPaint paint, int outerwidth,
                        Alignment align,
                        float spacingmult, float spacingadd,
                        BoringLayout.Metrics metrics, boolean includepad,
                        TextUtils.TruncateAt ellipsize, int ellipsizedWidth) {
        super(source, paint, outerwidth, align, spacingmult, spacingadd);
        boolean trust;
        {
            mEllipsizedWidth = outerwidth;
            mEllipsizedStart = 0;
            mEllipsizedCount = 0;
            trust = true;
        } 
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
        addTaint(source.getTaint());
        addTaint(paint.getTaint());
        addTaint(align.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(metrics.getTaint());
        addTaint(includepad);
        addTaint(ellipsize.getTaint());
        
        
        
            
            
            
            
        
            
                                           
                        
                        
            
            
        
        
             
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.550 -0400", hash_original_method = "CC7D93FCE240EB61BF168844CD074EBF", hash_generated_method = "66FFE27CFB1DA1D8FC2F04DB2543C296")
    public BoringLayout replaceOrMake(CharSequence source, TextPaint paint,
                                      int outerwidth, Alignment align,
                                      float spacingmult, float spacingadd,
                                      BoringLayout.Metrics metrics,
                                      boolean includepad) {
        BoringLayout varB4EAC82CA7396A68D541C85D26508E83_1896463367 = null; 
        replaceWith(source, paint, outerwidth, align, spacingmult,
                    spacingadd);
        mEllipsizedWidth = outerwidth;
        mEllipsizedStart = 0;
        mEllipsizedCount = 0;
        init(source, paint, outerwidth, align, spacingmult, spacingadd,
             metrics, includepad, true);
        varB4EAC82CA7396A68D541C85D26508E83_1896463367 = this;
        addTaint(source.getTaint());
        addTaint(paint.getTaint());
        addTaint(align.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(metrics.getTaint());
        addTaint(includepad);
        varB4EAC82CA7396A68D541C85D26508E83_1896463367.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1896463367;
        
        
                    
        
        
        
        
             
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.551 -0400", hash_original_method = "4B78087A434BCC06D8E64A3B5F0E26A9", hash_generated_method = "AFE74D3935128F6BDD519371FC55AE70")
    public BoringLayout replaceOrMake(CharSequence source, TextPaint paint,
                                      int outerwidth, Alignment align,
                                      float spacingmult, float spacingadd,
                                      BoringLayout.Metrics metrics,
                                      boolean includepad,
                                      TextUtils.TruncateAt ellipsize,
                                      int ellipsizedWidth) {
        BoringLayout varB4EAC82CA7396A68D541C85D26508E83_2085516092 = null; 
        boolean trust;
        {
            replaceWith(source, paint, outerwidth, align, spacingmult,
                        spacingadd);
            mEllipsizedWidth = outerwidth;
            mEllipsizedStart = 0;
            mEllipsizedCount = 0;
            trust = true;
        } 
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
        varB4EAC82CA7396A68D541C85D26508E83_2085516092 = this;
        addTaint(source.getTaint());
        addTaint(paint.getTaint());
        addTaint(align.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(metrics.getTaint());
        addTaint(includepad);
        addTaint(ellipsize.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2085516092.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2085516092;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.552 -0400", hash_original_method = "72A5FE71A3D3A6FEDD367DD5E3D986F4", hash_generated_method = "EB8F642D1F218DE905053BBF2F00E315")
     void init(CharSequence source,
                            TextPaint paint, int outerwidth,
                            Alignment align,
                            float spacingmult, float spacingadd,
                            BoringLayout.Metrics metrics, boolean includepad,
                            boolean trustWidth) {
        int spacing;
        {
            mDirect = source.toString();
        } 
        {
            mDirect = null;
        } 
        mPaint = paint;
        {
            spacing = metrics.bottom - metrics.top;
        } 
        {
            spacing = metrics.descent - metrics.ascent;
        } 
        {
            spacing = (int)(spacing * spacingmult + spacingadd + 0.5f);
        } 
        mBottom = spacing;
        {
            mDesc = spacing + metrics.top;
        } 
        {
            mDesc = spacing + metrics.ascent;
        } 
        {
            mMax = metrics.width;
        } 
        {
            TextLine line = TextLine.obtain();
            line.set(paint, source, 0, source.length(), Layout.DIR_LEFT_TO_RIGHT,
                    Layout.DIRS_ALL_LEFT_TO_RIGHT, false, null);
            mMax = (int) FloatMath.ceil(line.metrics(null));
            TextLine.recycle(line);
        } 
        {
            mTopPadding = metrics.top - metrics.ascent;
            mBottomPadding = metrics.bottom - metrics.descent;
        } 
        addTaint(outerwidth);
        addTaint(align.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(includepad);
        addTaint(trustWidth);
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.553 -0400", hash_original_method = "9C145AF64C7D263F1721F68F7FF83F17", hash_generated_method = "1F6335FA9ECA714BF6E4A712A48239C3")
    @Override
    public int getHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1459388223 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1459388223;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.554 -0400", hash_original_method = "2D16E05C4EC39BC67C8A172C64094881", hash_generated_method = "30FC50ABA81BA38F8B343CD4C255C799")
    @Override
    public int getLineCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1099782886 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1099782886;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.554 -0400", hash_original_method = "FC2E2A347EB554C00B43E510002C6FE3", hash_generated_method = "CD9C5FAEA8764D32ACEA329CCD9AAEEF")
    @Override
    public int getLineTop(int line) {
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_837759980 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_837759980;
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.554 -0400", hash_original_method = "CEFD06A93AC917501D80ABE3ADC321FA", hash_generated_method = "26452164A85A59A1D83AEFDC95C3FE52")
    @Override
    public int getLineDescent(int line) {
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1935646112 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1935646112;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.555 -0400", hash_original_method = "01507A0D62D72F853366982B51A08E39", hash_generated_method = "56761B0313E18D2B82FD81C3BC375577")
    @Override
    public int getLineStart(int line) {
        int var2BC251CDB6A58C428C92AE4E96100B61_1051314471 = (getText().length());
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1016108073 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1016108073;
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.555 -0400", hash_original_method = "C13A8C90111FE51B6C5C9E4F734C2F1E", hash_generated_method = "227A40786FB559A9C9D6A50E011A0526")
    @Override
    public int getParagraphDirection(int line) {
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202513581 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202513581;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.556 -0400", hash_original_method = "26D4049A2082A20A88CBFE67C9B7B59C", hash_generated_method = "7A6345E4E3E14F66B6C87609272D52F5")
    @Override
    public boolean getLineContainsTab(int line) {
        addTaint(line);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_983098829 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_983098829;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.556 -0400", hash_original_method = "B75E83FBFEF77E240A9CDC2AC2A1C8A4", hash_generated_method = "356AB4CD2E89487E962D112E943B341A")
    @Override
    public float getLineMax(int line) {
        addTaint(line);
        float var546ADE640B6EDFBC8A086EF31347E768_1772137455 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1772137455;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.556 -0400", hash_original_method = "6C6069268CAFC6462BC63ED1C5A7526F", hash_generated_method = "87F2F3ED25996BF38CBB7E1F89C698D4")
    @Override
    public final Directions getLineDirections(int line) {
        Directions varB4EAC82CA7396A68D541C85D26508E83_1983222828 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1983222828 = Layout.DIRS_ALL_LEFT_TO_RIGHT;
        addTaint(line);
        varB4EAC82CA7396A68D541C85D26508E83_1983222828.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1983222828;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.557 -0400", hash_original_method = "0410F05B3F48387C42DB277B8067D4A9", hash_generated_method = "1E8483C7B57D7727C4E8AD717F0A4E9D")
    @Override
    public int getTopPadding() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1569718648 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1569718648;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.557 -0400", hash_original_method = "A7597317BC8A3102F80AD4E9AD038652", hash_generated_method = "D75E3BCC167DCCF58E67E0A421700F66")
    @Override
    public int getBottomPadding() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1526124707 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1526124707;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.557 -0400", hash_original_method = "BD15B39FEBBFBBCAB07017E8474F5CA3", hash_generated_method = "866E61DAEA81C26224F4D366D6B9D91E")
    @Override
    public int getEllipsisCount(int line) {
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_144434182 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_144434182;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.558 -0400", hash_original_method = "414A86D89277DC065BB670E3078E25DD", hash_generated_method = "F0B97E822656AC441F0F34E0512724B6")
    @Override
    public int getEllipsisStart(int line) {
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_5698581 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_5698581;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.558 -0400", hash_original_method = "5CA9F8625BABB74DD57E485BAAAC3103", hash_generated_method = "E1BFEAE49CBACB11B37DF2923BD8C03D")
    @Override
    public int getEllipsizedWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_131855403 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_131855403;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.558 -0400", hash_original_method = "5DBC6B0379E5085B5017E1E8304BC3E8", hash_generated_method = "B33B46ED2203911B6BD4D350C47C8053")
    @Override
    public void draw(Canvas c, Path highlight, Paint highlightpaint,
                     int cursorOffset) {
        {
            c.drawText(mDirect, 0, mBottom - mDesc, mPaint);
        } 
        {
            super.draw(c, highlight, highlightpaint, cursorOffset);
        } 
        addTaint(c.getTaint());
        addTaint(highlight.getTaint());
        addTaint(highlightpaint.getTaint());
        addTaint(cursorOffset);
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.558 -0400", hash_original_method = "C8834FD4CE389B3AEF157EF49CB23721", hash_generated_method = "3908F2E0EC97B329D0B6E5A4EAB40C7A")
    public void ellipsized(int start, int end) {
        mEllipsizedStart = start;
        mEllipsizedCount = end - start;
        
        
        
    }

    
    public static class Metrics extends Paint.FontMetricsInt {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.559 -0400", hash_original_field = "EAAE26A6FB20ED3EF54FB23BFA0B1FCC", hash_generated_field = "6FAF64E7577371F06EC12EBE94C8466B")

        public int width;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.559 -0400", hash_original_method = "5093089FD85953828BC1A867B844524A", hash_generated_method = "5093089FD85953828BC1A867B844524A")
        public Metrics ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.559 -0400", hash_original_method = "12CBEFE116384BBA88EB750F89F5AC01", hash_generated_method = "594BA3D38C7851541E33652BCD8C5E15")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_998647371 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_998647371 = super.toString() + " width=" + width;
            varB4EAC82CA7396A68D541C85D26508E83_998647371.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_998647371;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.560 -0400", hash_original_field = "E7073F236704D4E004CC35F088F3B8FE", hash_generated_field = "C2F2F45019948F5515A5534F9B80EBF4")

    private static final char FIRST_RIGHT_TO_LEFT = '\u0590';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.560 -0400", hash_original_field = "8EBB63FE0098AB9E6EEA3F3E4D53E8B6", hash_generated_field = "AEB4C46A4C665812604A1CC18568D7E1")

    private static final TextPaint sTemp = new TextPaint();
}

