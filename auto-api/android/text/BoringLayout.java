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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.760 -0400", hash_original_field = "A1A8097250F33D60B681CE49F40DD5EF", hash_generated_field = "1B339E7F22FA229115A323159C174907")

    private String mDirect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.760 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

    private Paint mPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.760 -0400", hash_original_field = "2FFD20D7E48915664FDF7F12FC3889D8", hash_generated_field = "E3BE43E8597DE7EA48FEB065FD52A21A")

    int mBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.761 -0400", hash_original_field = "7CC9BE6231ADF86659204A1B34464053", hash_generated_field = "73810C960686DE7D2398567074C867B2")

    int mDesc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.761 -0400", hash_original_field = "A6796D45932911E4DA1D9D40D1BD23B8", hash_generated_field = "74C5EEEB9113B0F29D66E0A4983A6BC3")

    private int mTopPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.761 -0400", hash_original_field = "097A31AA17188409E251DABE4869FAFE", hash_generated_field = "8A7C981A0C6837E513C477AD1250B374")

    private int mBottomPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.761 -0400", hash_original_field = "C886C6FF92A43B3F6833B7BAFD354FBA", hash_generated_field = "61EBA81EE8DC22B1F5E764B863E5361B")

    private float mMax;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.761 -0400", hash_original_field = "5713AC9F49879DE1055FA780DFEFDF1C", hash_generated_field = "C354DF48C5764CCC7B8B820C49BF2BBD")

    private int mEllipsizedWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.761 -0400", hash_original_field = "2500F3F15EEAC3B4C3773F3A0481EE44", hash_generated_field = "B5CB4429DE9FEE6D7E71228CD62A452F")

    private int mEllipsizedStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.761 -0400", hash_original_field = "99B4B7415CCA47573BDE1AEF6AEEFAB0", hash_generated_field = "AB882CB344FFDF6F2159A6342489C1EA")

    private int mEllipsizedCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.773 -0400", hash_original_method = "4AC8C9A33DE614873CD5C4119639BAC7", hash_generated_method = "90F5A02B9B2F360A686872DEC4B3E887")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.777 -0400", hash_original_method = "614BD9653B1F69671BF8486744526AD2", hash_generated_method = "B626D874B34983AC090BF74B4AF114DF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.779 -0400", hash_original_method = "CC7D93FCE240EB61BF168844CD074EBF", hash_generated_method = "3006502C09FBFD5CC8F3A856790061B9")
    public BoringLayout replaceOrMake(CharSequence source, TextPaint paint,
                                      int outerwidth, Alignment align,
                                      float spacingmult, float spacingadd,
                                      BoringLayout.Metrics metrics,
                                      boolean includepad) {
        BoringLayout varB4EAC82CA7396A68D541C85D26508E83_216909229 = null; //Variable for return #1
        replaceWith(source, paint, outerwidth, align, spacingmult,
                    spacingadd);
        mEllipsizedWidth = outerwidth;
        mEllipsizedStart = 0;
        mEllipsizedCount = 0;
        init(source, paint, outerwidth, align, spacingmult, spacingadd,
             metrics, includepad, true);
        varB4EAC82CA7396A68D541C85D26508E83_216909229 = this;
        addTaint(source.getTaint());
        addTaint(paint.getTaint());
        addTaint(align.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(metrics.getTaint());
        addTaint(includepad);
        varB4EAC82CA7396A68D541C85D26508E83_216909229.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_216909229;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.793 -0400", hash_original_method = "4B78087A434BCC06D8E64A3B5F0E26A9", hash_generated_method = "6E2734025AC94236118BDBFDBF43082D")
    public BoringLayout replaceOrMake(CharSequence source, TextPaint paint,
                                      int outerwidth, Alignment align,
                                      float spacingmult, float spacingadd,
                                      BoringLayout.Metrics metrics,
                                      boolean includepad,
                                      TextUtils.TruncateAt ellipsize,
                                      int ellipsizedWidth) {
        BoringLayout varB4EAC82CA7396A68D541C85D26508E83_2017784898 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_2017784898 = this;
        addTaint(source.getTaint());
        addTaint(paint.getTaint());
        addTaint(align.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(metrics.getTaint());
        addTaint(includepad);
        addTaint(ellipsize.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2017784898.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2017784898;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.828 -0400", hash_original_method = "72A5FE71A3D3A6FEDD367DD5E3D986F4", hash_generated_method = "6AEBB961DDD9323038E605EB0B41C3AF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.840 -0400", hash_original_method = "9C145AF64C7D263F1721F68F7FF83F17", hash_generated_method = "4FF6387705239694BD496A381ECB0B4D")
    @Override
    public int getHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_442387159 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_442387159;
        // ---------- Original Method ----------
        //return mBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.841 -0400", hash_original_method = "2D16E05C4EC39BC67C8A172C64094881", hash_generated_method = "1C14E7F3B609C02F21D46832DB1C369A")
    @Override
    public int getLineCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792687328 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792687328;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.841 -0400", hash_original_method = "FC2E2A347EB554C00B43E510002C6FE3", hash_generated_method = "BE5A39D34B5A6480E0A6B9CAC8BF7D44")
    @Override
    public int getLineTop(int line) {
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_72763425 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_72763425;
        // ---------- Original Method ----------
        //if (line == 0)
            //return 0;
        //else
            //return mBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.842 -0400", hash_original_method = "CEFD06A93AC917501D80ABE3ADC321FA", hash_generated_method = "CB9567DC1B9274A9D9794B51687DF1B7")
    @Override
    public int getLineDescent(int line) {
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858658679 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858658679;
        // ---------- Original Method ----------
        //return mDesc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.843 -0400", hash_original_method = "01507A0D62D72F853366982B51A08E39", hash_generated_method = "0DB0B73AD8A71BA12D3F9250CB0288CE")
    @Override
    public int getLineStart(int line) {
        int var2BC251CDB6A58C428C92AE4E96100B61_1702445062 = (getText().length());
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_832264999 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_832264999;
        // ---------- Original Method ----------
        //if (line == 0)
            //return 0;
        //else
            //return getText().length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.843 -0400", hash_original_method = "C13A8C90111FE51B6C5C9E4F734C2F1E", hash_generated_method = "F3DCFF8444B970C71DC8B4CD2BA75917")
    @Override
    public int getParagraphDirection(int line) {
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1252205195 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1252205195;
        // ---------- Original Method ----------
        //return DIR_LEFT_TO_RIGHT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.858 -0400", hash_original_method = "26D4049A2082A20A88CBFE67C9B7B59C", hash_generated_method = "F07E4DD89D747D1F40F3D0CDAE45C6A3")
    @Override
    public boolean getLineContainsTab(int line) {
        addTaint(line);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1025025610 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1025025610;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.858 -0400", hash_original_method = "B75E83FBFEF77E240A9CDC2AC2A1C8A4", hash_generated_method = "8D53327A86C872598A3EC9B549E1FD53")
    @Override
    public float getLineMax(int line) {
        addTaint(line);
        float var546ADE640B6EDFBC8A086EF31347E768_1389426448 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1389426448;
        // ---------- Original Method ----------
        //return mMax;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.859 -0400", hash_original_method = "6C6069268CAFC6462BC63ED1C5A7526F", hash_generated_method = "E19B18BF80A5FCE161825C41700E7BB3")
    @Override
    public final Directions getLineDirections(int line) {
        Directions varB4EAC82CA7396A68D541C85D26508E83_1509014752 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1509014752 = Layout.DIRS_ALL_LEFT_TO_RIGHT;
        addTaint(line);
        varB4EAC82CA7396A68D541C85D26508E83_1509014752.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1509014752;
        // ---------- Original Method ----------
        //return Layout.DIRS_ALL_LEFT_TO_RIGHT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.863 -0400", hash_original_method = "0410F05B3F48387C42DB277B8067D4A9", hash_generated_method = "024D75E0648BB220842E9C459E3173EF")
    @Override
    public int getTopPadding() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1371872354 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1371872354;
        // ---------- Original Method ----------
        //return mTopPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.863 -0400", hash_original_method = "A7597317BC8A3102F80AD4E9AD038652", hash_generated_method = "D8D384B72F7831DEB110F1179D21E5EC")
    @Override
    public int getBottomPadding() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784458765 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784458765;
        // ---------- Original Method ----------
        //return mBottomPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.864 -0400", hash_original_method = "BD15B39FEBBFBBCAB07017E8474F5CA3", hash_generated_method = "812B7D85519B16636D1BB3799C9C6F5D")
    @Override
    public int getEllipsisCount(int line) {
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1673216337 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1673216337;
        // ---------- Original Method ----------
        //return mEllipsizedCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.864 -0400", hash_original_method = "414A86D89277DC065BB670E3078E25DD", hash_generated_method = "613780365AA8493E8FDABDE237DEF2E2")
    @Override
    public int getEllipsisStart(int line) {
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593705465 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593705465;
        // ---------- Original Method ----------
        //return mEllipsizedStart;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.885 -0400", hash_original_method = "5CA9F8625BABB74DD57E485BAAAC3103", hash_generated_method = "D3C57AD4E7FB80A190A7CC537BEEEE1B")
    @Override
    public int getEllipsizedWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_218861926 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_218861926;
        // ---------- Original Method ----------
        //return mEllipsizedWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.886 -0400", hash_original_method = "5DBC6B0379E5085B5017E1E8304BC3E8", hash_generated_method = "B33B46ED2203911B6BD4D350C47C8053")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.899 -0400", hash_original_method = "C8834FD4CE389B3AEF157EF49CB23721", hash_generated_method = "3908F2E0EC97B329D0B6E5A4EAB40C7A")
    public void ellipsized(int start, int end) {
        mEllipsizedStart = start;
        mEllipsizedCount = end - start;
        // ---------- Original Method ----------
        //mEllipsizedStart = start;
        //mEllipsizedCount = end - start;
    }

    
    public static class Metrics extends Paint.FontMetricsInt {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.900 -0400", hash_original_field = "EAAE26A6FB20ED3EF54FB23BFA0B1FCC", hash_generated_field = "6FAF64E7577371F06EC12EBE94C8466B")

        public int width;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.900 -0400", hash_original_method = "5093089FD85953828BC1A867B844524A", hash_generated_method = "5093089FD85953828BC1A867B844524A")
        public Metrics ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.901 -0400", hash_original_method = "12CBEFE116384BBA88EB750F89F5AC01", hash_generated_method = "2A26F7241187E8531613E6B639C6F645")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_694330504 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_694330504 = super.toString() + " width=" + width;
            varB4EAC82CA7396A68D541C85D26508E83_694330504.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_694330504;
            // ---------- Original Method ----------
            //return super.toString() + " width=" + width;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.901 -0400", hash_original_field = "E7073F236704D4E004CC35F088F3B8FE", hash_generated_field = "A45E2DDC3F4FE85D500535CE0E1421C6")

    private static char FIRST_RIGHT_TO_LEFT = '\u0590';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.901 -0400", hash_original_field = "8EBB63FE0098AB9E6EEA3F3E4D53E8B6", hash_generated_field = "965202088BA4AA3300BC6369DF44F816")

    private static TextPaint sTemp = new TextPaint();
}

