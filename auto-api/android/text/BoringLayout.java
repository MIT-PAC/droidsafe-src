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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.123 -0400", hash_original_field = "A1A8097250F33D60B681CE49F40DD5EF", hash_generated_field = "1B339E7F22FA229115A323159C174907")

    private String mDirect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.123 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

    private Paint mPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.123 -0400", hash_original_field = "2FFD20D7E48915664FDF7F12FC3889D8", hash_generated_field = "E3BE43E8597DE7EA48FEB065FD52A21A")

    int mBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.123 -0400", hash_original_field = "7CC9BE6231ADF86659204A1B34464053", hash_generated_field = "73810C960686DE7D2398567074C867B2")

    int mDesc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.123 -0400", hash_original_field = "A6796D45932911E4DA1D9D40D1BD23B8", hash_generated_field = "74C5EEEB9113B0F29D66E0A4983A6BC3")

    private int mTopPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.123 -0400", hash_original_field = "097A31AA17188409E251DABE4869FAFE", hash_generated_field = "8A7C981A0C6837E513C477AD1250B374")

    private int mBottomPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.123 -0400", hash_original_field = "C886C6FF92A43B3F6833B7BAFD354FBA", hash_generated_field = "61EBA81EE8DC22B1F5E764B863E5361B")

    private float mMax;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.123 -0400", hash_original_field = "5713AC9F49879DE1055FA780DFEFDF1C", hash_generated_field = "C354DF48C5764CCC7B8B820C49BF2BBD")

    private int mEllipsizedWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.123 -0400", hash_original_field = "2500F3F15EEAC3B4C3773F3A0481EE44", hash_generated_field = "B5CB4429DE9FEE6D7E71228CD62A452F")

    private int mEllipsizedStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.123 -0400", hash_original_field = "99B4B7415CCA47573BDE1AEF6AEEFAB0", hash_generated_field = "AB882CB344FFDF6F2159A6342489C1EA")

    private int mEllipsizedCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.124 -0400", hash_original_method = "4AC8C9A33DE614873CD5C4119639BAC7", hash_generated_method = "90F5A02B9B2F360A686872DEC4B3E887")
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
        // ---------- Original Method ----------
        //mEllipsizedWidth = outerwidth;
        //mEllipsizedStart = 0;
        //mEllipsizedCount = 0;
        //init(source, paint, outerwidth, align, spacingmult, spacingadd,
             //metrics, includepad, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.125 -0400", hash_original_method = "614BD9653B1F69671BF8486744526AD2", hash_generated_method = "B626D874B34983AC090BF74B4AF114DF")
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
        } //End block
        {
            replaceWith(TextUtils.ellipsize(source, paint, ellipsizedWidth,
                                           ellipsize, true, this),
                        paint, outerwidth, align, spacingmult,
                        spacingadd);
            mEllipsizedWidth = ellipsizedWidth;
            trust = false;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.142 -0400", hash_original_method = "CC7D93FCE240EB61BF168844CD074EBF", hash_generated_method = "B3D96FFA1FAC406F8A82C774E005419D")
    public BoringLayout replaceOrMake(CharSequence source, TextPaint paint,
                                      int outerwidth, Alignment align,
                                      float spacingmult, float spacingadd,
                                      BoringLayout.Metrics metrics,
                                      boolean includepad) {
        BoringLayout varB4EAC82CA7396A68D541C85D26508E83_17988619 = null; //Variable for return #1
        replaceWith(source, paint, outerwidth, align, spacingmult,
                    spacingadd);
        mEllipsizedWidth = outerwidth;
        mEllipsizedStart = 0;
        mEllipsizedCount = 0;
        init(source, paint, outerwidth, align, spacingmult, spacingadd,
             metrics, includepad, true);
        varB4EAC82CA7396A68D541C85D26508E83_17988619 = this;
        addTaint(source.getTaint());
        addTaint(paint.getTaint());
        addTaint(align.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(metrics.getTaint());
        addTaint(includepad);
        varB4EAC82CA7396A68D541C85D26508E83_17988619.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_17988619;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.179 -0400", hash_original_method = "4B78087A434BCC06D8E64A3B5F0E26A9", hash_generated_method = "7B8698EED58941BE7883EE734346FC3F")
    public BoringLayout replaceOrMake(CharSequence source, TextPaint paint,
                                      int outerwidth, Alignment align,
                                      float spacingmult, float spacingadd,
                                      BoringLayout.Metrics metrics,
                                      boolean includepad,
                                      TextUtils.TruncateAt ellipsize,
                                      int ellipsizedWidth) {
        BoringLayout varB4EAC82CA7396A68D541C85D26508E83_234238725 = null; //Variable for return #1
        boolean trust;
        {
            replaceWith(source, paint, outerwidth, align, spacingmult,
                        spacingadd);
            mEllipsizedWidth = outerwidth;
            mEllipsizedStart = 0;
            mEllipsizedCount = 0;
            trust = true;
        } //End block
        {
            replaceWith(TextUtils.ellipsize(source, paint, ellipsizedWidth,
                                           ellipsize, true, this),
                        paint, outerwidth, align, spacingmult,
                        spacingadd);
            mEllipsizedWidth = ellipsizedWidth;
            trust = false;
        } //End block
        init(getText(), paint, outerwidth, align, spacingmult, spacingadd,
             metrics, includepad, trust);
        varB4EAC82CA7396A68D541C85D26508E83_234238725 = this;
        addTaint(source.getTaint());
        addTaint(paint.getTaint());
        addTaint(align.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(metrics.getTaint());
        addTaint(includepad);
        addTaint(ellipsize.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_234238725.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_234238725;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.181 -0400", hash_original_method = "72A5FE71A3D3A6FEDD367DD5E3D986F4", hash_generated_method = "6AEBB961DDD9323038E605EB0B41C3AF")
     void init(CharSequence source,
                            TextPaint paint, int outerwidth,
                            Alignment align,
                            float spacingmult, float spacingadd,
                            BoringLayout.Metrics metrics, boolean includepad,
                            boolean trustWidth) {
        int spacing;
        {
            mDirect = source.toString();
        } //End block
        {
            mDirect = null;
        } //End block
        mPaint = paint;
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
        addTaint(outerwidth);
        addTaint(align.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(includepad);
        addTaint(trustWidth);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.188 -0400", hash_original_method = "9C145AF64C7D263F1721F68F7FF83F17", hash_generated_method = "8C0F2E01110A916B7046FE213D377F85")
    @Override
    public int getHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1205699589 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1205699589;
        // ---------- Original Method ----------
        //return mBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.195 -0400", hash_original_method = "2D16E05C4EC39BC67C8A172C64094881", hash_generated_method = "1DD3BCB06B639C0C85FB1AD090D29F2F")
    @Override
    public int getLineCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1813814130 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1813814130;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.198 -0400", hash_original_method = "FC2E2A347EB554C00B43E510002C6FE3", hash_generated_method = "EF88B825CE7F91D92FB8F3817BD32257")
    @Override
    public int getLineTop(int line) {
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1993309065 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1993309065;
        // ---------- Original Method ----------
        //if (line == 0)
            //return 0;
        //else
            //return mBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.199 -0400", hash_original_method = "CEFD06A93AC917501D80ABE3ADC321FA", hash_generated_method = "1535AA74B776728A207C20024FB09496")
    @Override
    public int getLineDescent(int line) {
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_916684869 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_916684869;
        // ---------- Original Method ----------
        //return mDesc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.202 -0400", hash_original_method = "01507A0D62D72F853366982B51A08E39", hash_generated_method = "9443599AC22BC12BE6D961BC9CFDB293")
    @Override
    public int getLineStart(int line) {
        int var2BC251CDB6A58C428C92AE4E96100B61_276279761 = (getText().length());
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1811449556 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1811449556;
        // ---------- Original Method ----------
        //if (line == 0)
            //return 0;
        //else
            //return getText().length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.216 -0400", hash_original_method = "C13A8C90111FE51B6C5C9E4F734C2F1E", hash_generated_method = "8F3AE8AA02CAF721700F0E584409B8B3")
    @Override
    public int getParagraphDirection(int line) {
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1262122418 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1262122418;
        // ---------- Original Method ----------
        //return DIR_LEFT_TO_RIGHT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.216 -0400", hash_original_method = "26D4049A2082A20A88CBFE67C9B7B59C", hash_generated_method = "2C0EA3C105F178DB523998EE4F839127")
    @Override
    public boolean getLineContainsTab(int line) {
        addTaint(line);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1657775813 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1657775813;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.217 -0400", hash_original_method = "B75E83FBFEF77E240A9CDC2AC2A1C8A4", hash_generated_method = "515F24211393F1FFC72D412FCF35F46C")
    @Override
    public float getLineMax(int line) {
        addTaint(line);
        float var546ADE640B6EDFBC8A086EF31347E768_307861558 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_307861558;
        // ---------- Original Method ----------
        //return mMax;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.218 -0400", hash_original_method = "6C6069268CAFC6462BC63ED1C5A7526F", hash_generated_method = "0F9DE7BEAA7ADD09ACB9C5F02F0E75A9")
    @Override
    public final Directions getLineDirections(int line) {
        Directions varB4EAC82CA7396A68D541C85D26508E83_358283361 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_358283361 = Layout.DIRS_ALL_LEFT_TO_RIGHT;
        addTaint(line);
        varB4EAC82CA7396A68D541C85D26508E83_358283361.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_358283361;
        // ---------- Original Method ----------
        //return Layout.DIRS_ALL_LEFT_TO_RIGHT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.223 -0400", hash_original_method = "0410F05B3F48387C42DB277B8067D4A9", hash_generated_method = "CFB1BB79E9E4B4240C8FB8966E719ECE")
    @Override
    public int getTopPadding() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1918464042 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1918464042;
        // ---------- Original Method ----------
        //return mTopPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.237 -0400", hash_original_method = "A7597317BC8A3102F80AD4E9AD038652", hash_generated_method = "F0B957FD7F77168E351B7BDFC5710B04")
    @Override
    public int getBottomPadding() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1785637003 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1785637003;
        // ---------- Original Method ----------
        //return mBottomPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.238 -0400", hash_original_method = "BD15B39FEBBFBBCAB07017E8474F5CA3", hash_generated_method = "DA3158522EFC935C166F92A4216C1EE3")
    @Override
    public int getEllipsisCount(int line) {
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_940773489 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_940773489;
        // ---------- Original Method ----------
        //return mEllipsizedCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.238 -0400", hash_original_method = "414A86D89277DC065BB670E3078E25DD", hash_generated_method = "DCF4D1174E28A4B01A008DE1C076A707")
    @Override
    public int getEllipsisStart(int line) {
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_696324738 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_696324738;
        // ---------- Original Method ----------
        //return mEllipsizedStart;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.238 -0400", hash_original_method = "5CA9F8625BABB74DD57E485BAAAC3103", hash_generated_method = "5795EFD55FD797D07D38345BD9E1D626")
    @Override
    public int getEllipsizedWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_259928675 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_259928675;
        // ---------- Original Method ----------
        //return mEllipsizedWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.239 -0400", hash_original_method = "5DBC6B0379E5085B5017E1E8304BC3E8", hash_generated_method = "B33B46ED2203911B6BD4D350C47C8053")
    @Override
    public void draw(Canvas c, Path highlight, Paint highlightpaint,
                     int cursorOffset) {
        {
            c.drawText(mDirect, 0, mBottom - mDesc, mPaint);
        } //End block
        {
            super.draw(c, highlight, highlightpaint, cursorOffset);
        } //End block
        addTaint(c.getTaint());
        addTaint(highlight.getTaint());
        addTaint(highlightpaint.getTaint());
        addTaint(cursorOffset);
        // ---------- Original Method ----------
        //if (mDirect != null && highlight == null) {
            //c.drawText(mDirect, 0, mBottom - mDesc, mPaint);
        //} else {
            //super.draw(c, highlight, highlightpaint, cursorOffset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.239 -0400", hash_original_method = "C8834FD4CE389B3AEF157EF49CB23721", hash_generated_method = "3908F2E0EC97B329D0B6E5A4EAB40C7A")
    public void ellipsized(int start, int end) {
        mEllipsizedStart = start;
        mEllipsizedCount = end - start;
        // ---------- Original Method ----------
        //mEllipsizedStart = start;
        //mEllipsizedCount = end - start;
    }

    
    public static class Metrics extends Paint.FontMetricsInt {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.240 -0400", hash_original_field = "EAAE26A6FB20ED3EF54FB23BFA0B1FCC", hash_generated_field = "6FAF64E7577371F06EC12EBE94C8466B")

        public int width;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.240 -0400", hash_original_method = "5093089FD85953828BC1A867B844524A", hash_generated_method = "5093089FD85953828BC1A867B844524A")
        public Metrics ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.243 -0400", hash_original_method = "12CBEFE116384BBA88EB750F89F5AC01", hash_generated_method = "894880454EF7212EF5B477FAA8F4268D")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1231038323 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1231038323 = super.toString() + " width=" + width;
            varB4EAC82CA7396A68D541C85D26508E83_1231038323.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1231038323;
            // ---------- Original Method ----------
            //return super.toString() + " width=" + width;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.244 -0400", hash_original_field = "E7073F236704D4E004CC35F088F3B8FE", hash_generated_field = "A45E2DDC3F4FE85D500535CE0E1421C6")

    private static char FIRST_RIGHT_TO_LEFT = '\u0590';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.244 -0400", hash_original_field = "8EBB63FE0098AB9E6EEA3F3E4D53E8B6", hash_generated_field = "965202088BA4AA3300BC6369DF44F816")

    private static TextPaint sTemp = new TextPaint();
}

