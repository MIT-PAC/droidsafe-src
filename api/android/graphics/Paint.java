package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.text.GraphicsOperations;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;

import droidsafe.helpers.DSUtils;

public class Paint {
    
    private static int native_init() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_411903526 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_411903526;
    }
    
    private static int native_initWithPaint(int paint) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822342811 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822342811;
    }
    
    private static void native_reset(int native_object) {
    }
    
    private static void native_set(int native_dst, int native_src) {
    }
    
    private static int native_getStyle(int native_object) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_695600058 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_695600058;
    }
    
    private static void native_setStyle(int native_object, int style) {
    }
    
    private static int native_getStrokeCap(int native_object) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_72348221 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_72348221;
    }
    
    private static void native_setStrokeCap(int native_object, int cap) {
    }
    
    private static int native_getStrokeJoin(int native_object) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100687496 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100687496;
    }
    
    private static void native_setStrokeJoin(int native_object,
                                                    int join) {
    }
    
    private static boolean native_getFillPath(int native_object,
                                                     int src, int dst) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1554135697 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1554135697;
    }
    
    private static int native_setShader(int native_object, int shader) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_304132726 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_304132726;
    }
    
    private static int native_setColorFilter(int native_object,
                                                    int filter) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_660421621 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_660421621;
    }
    
    private static int native_setXfermode(int native_object,
                                                 int xfermode) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1010875162 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1010875162;
    }
    
    private static int native_setPathEffect(int native_object,
                                                   int effect) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132479319 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132479319;
    }
    
    private static int native_setMaskFilter(int native_object,
                                                   int maskfilter) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1946182993 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1946182993;
    }
    
    private static int native_setTypeface(int native_object,
                                                 int typeface) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_216630856 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_216630856;
    }
    
    private static int native_setRasterizer(int native_object,
                                                   int rasterizer) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1401536634 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1401536634;
    }
    
    private static int native_getTextAlign(int native_object) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_101495221 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_101495221;
    }
    
    private static void native_setTextAlign(int native_object,
                                                   int align) {
    }
    
    private static float native_getFontMetrics(int native_paint,
                                                      FontMetrics metrics) {
                float var546ADE640B6EDFBC8A086EF31347E768_1646011385 = DSUtils.UNKNOWN_FLOAT;
        return var546ADE640B6EDFBC8A086EF31347E768_1646011385;
    }
    
    private static int native_getTextWidths(int native_object,
                            char[] text, int index, int count, float[] widths) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1172843739 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1172843739;
    }
    
    private static int native_getTextWidths(int native_object,
                            String text, int start, int end, float[] widths) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1740280915 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1740280915;
    }
    
    private static int native_getTextGlyphs(int native_object,
            String text, int start, int end, int contextStart, int contextEnd,
            int flags, char[] glyphs) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960442695 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960442695;
    }
    
    private static float native_getTextRunAdvances(int native_object,
            char[] text, int index, int count, int contextIndex, int contextCount,
            int flags, float[] advances, int advancesIndex, int reserved) {
                float var546ADE640B6EDFBC8A086EF31347E768_2085706126 = DSUtils.UNKNOWN_FLOAT;
        return var546ADE640B6EDFBC8A086EF31347E768_2085706126;
    }
    
    private static float native_getTextRunAdvances(int native_object,
            String text, int start, int end, int contextStart, int contextEnd,
            int flags, float[] advances, int advancesIndex, int reserved) {
                float var546ADE640B6EDFBC8A086EF31347E768_1890811747 = DSUtils.UNKNOWN_FLOAT;
        return var546ADE640B6EDFBC8A086EF31347E768_1890811747;
    }
    
    private static void native_getTextPath(int native_object, int bidiFlags,
                char[] text, int index, int count, float x, float y, int path) {
    }
    
    private static void native_getTextPath(int native_object, int bidiFlags,
                String text, int start, int end, float x, float y, int path) {
    }
    
    private static void nativeGetStringBounds(int nativePaint,
                                String text, int start, int end, Rect bounds) {
    }
    
    private static void nativeGetCharArrayBounds(int nativePaint,
                                char[] text, int index, int count, Rect bounds) {
    }
    
    private static void finalizer(int nativePaint) {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.462 -0500", hash_original_field = "036DA9FBE137AFFEE83D62704F339225", hash_generated_field = "5C49143BE7FFA5D3F7B1962C98542BDE")
    
    static final Style[] sStyleArray = {
        Style.FILL, Style.STROKE, Style.FILL_AND_STROKE
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.464 -0500", hash_original_field = "54B585D342A85D038B0EC047C327E28D", hash_generated_field = "DC64E880474C9D8403AA868EB4AA3944")

    static final Cap[] sCapArray = {
        Cap.BUTT, Cap.ROUND, Cap.SQUARE
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.466 -0500", hash_original_field = "E068C6E40A3AEC50473447F8EDD7661B", hash_generated_field = "428598CDD6B0136C38E4F901486168AA")

    static final Join[] sJoinArray = {
        Join.MITER, Join.ROUND, Join.BEVEL
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.469 -0500", hash_original_field = "50D471343F957889D23EED53A2829A4D", hash_generated_field = "B768A63E818BB42B636833669C3022B6")

    static final Align[] sAlignArray = {
        Align.LEFT, Align.CENTER, Align.RIGHT
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.472 -0500", hash_original_field = "EAC70BEE9393DDD291056600D0918FD8", hash_generated_field = "45D0C54CC6E381296E91FEFD4D7E9F05")

    public static final int ANTI_ALIAS_FLAG     = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.474 -0500", hash_original_field = "49248DDEAB71C2A908539248DB47F53E", hash_generated_field = "3B37B87298EB8671D01D36A02B147DBD")

    public static final int FILTER_BITMAP_FLAG  = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.476 -0500", hash_original_field = "C99F1BD0D975D904492AD714AF887F6C", hash_generated_field = "16DC79CD5B30E8BBD4718C630596673F")

    public static final int DITHER_FLAG         = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.479 -0500", hash_original_field = "705A426BA3DC3A2AE6EBDCBCF67CE40A", hash_generated_field = "B76EE25AA2E9AE34D9CEE0AE93E3B0AF")

    public static final int UNDERLINE_TEXT_FLAG = 0x08;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.481 -0500", hash_original_field = "5CD5296C267C5A7F3951247178D52088", hash_generated_field = "2E3EA944809E9CBC9A119AA5696756EB")

    public static final int STRIKE_THRU_TEXT_FLAG = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.483 -0500", hash_original_field = "6098B3789CAD56337DD3623297D3A026", hash_generated_field = "DE9EF5A591F6D71DE416EE9B51EE6EB5")

    public static final int FAKE_BOLD_TEXT_FLAG = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.485 -0500", hash_original_field = "8D31D9CBFD5FD340BD04C0F2B2495AE7", hash_generated_field = "7F1BE56009FABC11D8C2A24734D2E78C")

    public static final int LINEAR_TEXT_FLAG    = 0x40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.488 -0500", hash_original_field = "811A1569C4DADA16A30C1C020D0B704D", hash_generated_field = "104067A48B49BC1C75654D92F259E44A")

    public static final int SUBPIXEL_TEXT_FLAG  = 0x80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.491 -0500", hash_original_field = "9972596ABD9C088C62C8C19F6F3AFCC0", hash_generated_field = "B7D127AFEC7155C6CDA53B6A46D2FB5C")

    public static final int DEV_KERN_TEXT_FLAG  = 0x100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.493 -0500", hash_original_field = "AF07DE5AB0C0C19105602B56F52C7E1F", hash_generated_field = "9CF58765CF27F6C03CE44F70BFCDB856")

    static final int DEFAULT_PAINT_FLAGS = DEV_KERN_TEXT_FLAG;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.495 -0500", hash_original_field = "FDAC3D2024922328E470697ED6F82C45", hash_generated_field = "7E20082E997CCF5AE3ADDE6EB55F4D14")

    public static final int HINTING_OFF = 0x0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.497 -0500", hash_original_field = "53DE59CEB0DD5B5867F247CA844BFB4F", hash_generated_field = "75F6A241333C1BDE4871EB2D5849C4B4")

    public static final int HINTING_ON = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.500 -0500", hash_original_field = "62D6862353E047FDF779B4232B802DD8", hash_generated_field = "6F9C6C8D6013846EA024C014B7506D51")

    public static final int BIDI_LTR = 0x0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.502 -0500", hash_original_field = "4B4B2C4BC88800F5EDAA3BFCEC4F6232", hash_generated_field = "5E8A80ABBBB4622F32D5ECA5E3A02CF1")

    public static final int BIDI_RTL = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.504 -0500", hash_original_field = "EF19C51F1F0587647A6520E122C9B298", hash_generated_field = "2F04CC5409C37696637070FBC2BCA711")

    public static final int BIDI_DEFAULT_LTR = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.507 -0500", hash_original_field = "2003C35BF9E7327207CCFC2995D69BB2", hash_generated_field = "91CE6515A1DC6EC518B6EF6F7044CC99")

    public static final int BIDI_DEFAULT_RTL = 0x3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.510 -0500", hash_original_field = "32E8C9E22767D0DBB5041CFFAF5B8DD3", hash_generated_field = "96707B9ED197F2C49CEF721789B1CC89")

    public static final int BIDI_FORCE_LTR = 0x4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.513 -0500", hash_original_field = "2D56A42B264CC69E51A522BFB9B363C8", hash_generated_field = "C8D922D49FF076A4FA47E7AC1C90E71C")

    public static final int BIDI_FORCE_RTL = 0x5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.515 -0500", hash_original_field = "C9394CB7D2360C724AD951F04E3E50E6", hash_generated_field = "80689923EFFED0DEFB8EBF590BABE137")

    private static final int BIDI_MAX_FLAG_VALUE = BIDI_FORCE_RTL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.518 -0500", hash_original_field = "ABB9339CEB4200EFF3043B7F9C8488FB", hash_generated_field = "F2C5ACAE49EA02FB996F32FA24F9DDEA")

    private static final int BIDI_FLAG_MASK = 0x7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.520 -0500", hash_original_field = "DE0993C64A5DCE6B04BA860BC13954B0", hash_generated_field = "560BA2CA377351903A6838650E1B66A9")

    public static final int DIRECTION_LTR = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.523 -0500", hash_original_field = "46B700B3B2E9E814F4C1E3FC3262AEB1", hash_generated_field = "FE6A83E9AB181642152249B0E98D001F")

    public static final int DIRECTION_RTL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.525 -0500", hash_original_field = "323E28A95D87EDD6EFAFE561FAC21CC0", hash_generated_field = "519D5E5540609C6F930879E787B9A0E3")

    public static final int CURSOR_AFTER = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.527 -0500", hash_original_field = "4807059BE4D03AA6A99AEF34DBF6F2E4", hash_generated_field = "87F0976C0F58B633C620CB23E58C9D06")

    public static final int CURSOR_AT_OR_AFTER = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.529 -0500", hash_original_field = "86B2CDC3BAB06A9A14067E5712048972", hash_generated_field = "E937AFFEBC810173CB0EDEB05B57742B")

    public static final int CURSOR_BEFORE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.531 -0500", hash_original_field = "D109B83A37197D3768B327C5F55B124B", hash_generated_field = "59875B95A53D3853447FD50EB38FE659")

    public static final int CURSOR_AT_OR_BEFORE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.533 -0500", hash_original_field = "FEDE6B4F58004E9DD02DC54D4E369087", hash_generated_field = "944FD8D9E2B6685D6BB0D020EFBD576C")

    public static final int CURSOR_AT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.536 -0500", hash_original_field = "87274743983EEA67B1606F2B8AB72468", hash_generated_field = "D6F9958F9851E03048ADF3A5AFE0078A")

    private static final int CURSOR_OPT_MAX_VALUE = CURSOR_AT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.427 -0500", hash_original_field = "7A06680BB090697C51CD6B1335275C0F", hash_generated_field = "F9F1B9FB44729EA466DD33DE16A3AB10")

    public int mNativePaint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.429 -0500", hash_original_field = "FDF54A2FE886548299B21698A652A06E", hash_generated_field = "5D6D299C9DDEDCCB11EFFA1C147C3DF6")

    private ColorFilter mColorFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.431 -0500", hash_original_field = "7AD633188967CFB9AABB54721839A490", hash_generated_field = "30CA93EA0A1FDD848EE36D39E7D9E77B")

    private MaskFilter  mMaskFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.433 -0500", hash_original_field = "98014F97E16F6A0BC771C63B7CB0C12B", hash_generated_field = "0970365855BAEB3B93B55E917D7BB807")

    private PathEffect  mPathEffect;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.435 -0500", hash_original_field = "BA4F62EBB9F54346726763E63E2EBB86", hash_generated_field = "E15971EFBFBD92787A66981AB256F5C2")

    private Rasterizer  mRasterizer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.437 -0500", hash_original_field = "615EDAEACEDD34F8AD08DED837E8FF84", hash_generated_field = "B1952C618C8BBD071ACDDBA82DB64026")

    private Shader      mShader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.439 -0500", hash_original_field = "B1D084403B11F9DFB2320D50CA5AB54E", hash_generated_field = "234D9F5A4F790A70ADC301ADC43BEEC1")

    private Typeface    mTypeface;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.441 -0500", hash_original_field = "75C5483D09C7F36D47B640F4111BA041", hash_generated_field = "E20BD0A091050F1F29128E6A824DE542")

    private Xfermode    mXfermode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.443 -0500", hash_original_field = "44262990EC796BEF4BE2D2CE08E33B53", hash_generated_field = "41C5D1021B750266A4ADC951970465D5")

    private boolean     mHasCompatScaling;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.445 -0500", hash_original_field = "FC81821365D0E19B8FB314D0C9592ECF", hash_generated_field = "B75D80F84935274D46B49A2A5EE4E0AB")

    private float       mCompatScaling;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.447 -0500", hash_original_field = "37EAEA93412C51F63743DFD37DA9B55D", hash_generated_field = "3B482C031B54D0585FB747229A42223A")

    private float       mInvCompatScaling;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.449 -0500", hash_original_field = "E45FB92BEAA5BDFA083EB61A4BE6BE25", hash_generated_field = "79432E7E02F51603141CA873F5DC70EF")

    public boolean hasShadow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.451 -0500", hash_original_field = "FF7DB3B284A5CCF35321A1258B4F1614", hash_generated_field = "5B09CAB9CB4DEB539F28464A0A9AF847")

    public float shadowDx;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.453 -0500", hash_original_field = "3277B421D6F6ACF0028DF5075C6B4E48", hash_generated_field = "E8741946672ABFDF9B3AFE7FAFACA993")

    public float shadowDy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.455 -0500", hash_original_field = "12FC47F0AFFC72B430B896F9E5BB6C53", hash_generated_field = "584D14064094F2C1B9BDB348A4C8065C")

    public float shadowRadius;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.457 -0500", hash_original_field = "D20E91923EF234313A98DB5BE2CEF6C5", hash_generated_field = "F7019584388E8E0B6A5FA29A5D1D5111")

    public int shadowColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.459 -0500", hash_original_field = "4A77047FC1590BC41F7E4843EF4CDC01", hash_generated_field = "EC215250783F837A7E2BDA6A9E3ACA2D")

    public  int         mBidiFlags = BIDI_DEFAULT_LTR;
    
    public Paint() {
        //this(0);  No real need to flow down into second constructor which would track taint, since it's a fixed value
    }
    
    public Paint(int flags) {
		setFlags(flags);
		/*
        mNativePaint = native_init();
        setFlags(flags | DEFAULT_PAINT_FLAGS);
        mCompatScaling = mInvCompatScaling = 1;
        */
    }

    /**
     * Create a new paint, initialized with the attributes in the specified
     * paint parameter.
     *
     * @param paint Existing paint used to initialized the attributes of the
     *              new paint.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.571 -0500", hash_original_method = "5333FFC8A800A9BDD5C93C0D81F44606", hash_generated_method = "8ABBA94AFCE96480E8CA6B2F52A5AE36")
    
public Paint(Paint paint) {
        mNativePaint = native_initWithPaint(paint.mNativePaint);
        setClassVariablesFrom(paint);
    }

    /** Restores the paint to its default settings. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.573 -0500", hash_original_method = "500B44D79F50634A486701EEF1530400", hash_generated_method = "7F0F8C120B3C0A8B607FBBD9A4DB1485")
    
public void reset() {
        native_reset(mNativePaint);
        setFlags(DEFAULT_PAINT_FLAGS);
        // TODO: Turning off hinting has undesirable side effects, we need to
        //       revisit hinting once we add support for subpixel positioning
        // setHinting(DisplayMetrics.DENSITY_DEVICE >= DisplayMetrics.DENSITY_TV
        //        ? HINTING_OFF : HINTING_ON);
        mHasCompatScaling = false;
        mCompatScaling = mInvCompatScaling = 1;
        mBidiFlags = BIDI_DEFAULT_LTR;
    }
    
    /**
     * Copy the fields from src into this paint. This is equivalent to calling
     * get() on all of the src fields, and calling the corresponding set()
     * methods on this.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.575 -0500", hash_original_method = "98AAB6FDA11AA2B9ABF20CA846521C6A", hash_generated_method = "04B32EB32FABCC179A3522FDD421F790")
    
public void set(Paint src) {
        if (this != src) {
            // copy over the native settings
            native_set(mNativePaint, src.mNativePaint);
            setClassVariablesFrom(src);
        }
    }

    /**
     * Set all class variables using current values from the given
     * {@link Paint}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.578 -0500", hash_original_method = "98AB66F312E073116B808F98CBEF958E", hash_generated_method = "9B7E1CED2394EADEB778BCE327E3871F")
    
private void setClassVariablesFrom(Paint paint) {
        mColorFilter = paint.mColorFilter;
        mMaskFilter = paint.mMaskFilter;
        mPathEffect = paint.mPathEffect;
        mRasterizer = paint.mRasterizer;
        mShader = paint.mShader;
        mTypeface = paint.mTypeface;
        mXfermode = paint.mXfermode;

        mHasCompatScaling = paint.mHasCompatScaling;
        mCompatScaling = paint.mCompatScaling;
        mInvCompatScaling = paint.mInvCompatScaling;

        hasShadow = paint.hasShadow;
        shadowDx = paint.shadowDx;
        shadowDy = paint.shadowDy;
        shadowRadius = paint.shadowRadius;
        shadowColor = paint.shadowColor;

        mBidiFlags = paint.mBidiFlags;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.581 -0500", hash_original_method = "163478F4D44D5ADDAB10921FE1B9406D", hash_generated_method = "88801E7C4729824E4E74BF44D585B3F1")
    
public void setCompatibilityScaling(float factor) {
        if (factor == 1.0) {
            mHasCompatScaling = false;
            mCompatScaling = mInvCompatScaling = 1.0f;
        } else {
            mHasCompatScaling = true;
            mCompatScaling = factor;
            mInvCompatScaling = 1.0f/factor;
        }
    }

    /**
     * Return the bidi flags on the paint.
     * 
     * @return the bidi flags on the paint
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.583 -0500", hash_original_method = "35E33B2836010FD893C5DC650465B2C6", hash_generated_method = "24ACE0E2E8F936C34622C6467C2500A2")
    
public int getBidiFlags() {
        return mBidiFlags;
    }

    /**
     * Set the bidi flags on the paint.
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.585 -0500", hash_original_method = "47898531701F33FAC5767BA6A377013D", hash_generated_method = "1E537FFFF4B07FD4DA695E233F8D2BF7")
    
public void setBidiFlags(int flags) {
        // only flag value is the 3-bit BIDI control setting
        flags &= BIDI_FLAG_MASK;
        if (flags > BIDI_MAX_FLAG_VALUE) {
            throw new IllegalArgumentException("unknown bidi flag: " + flags);
        }
        mBidiFlags = flags;
    }
    
	public int getFlags() {  //Originally a native method, converted over
		return getTaintInt();
	}
    
    public void setFlags(int flags) {  //Originally a native method, converted over
		addTaint(flags);
	}

    /**
     * Return the paint's hinting mode.  Returns either
     * {@link #HINTING_OFF} or {@link #HINTING_ON}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.596 -0500", hash_original_method = "7451F33B471F8FECF642BA91F121AF70", hash_generated_method = "E608FAFEC86034A8905EB77546464014")
    
    public int getHinting(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * Set the paint's hinting mode.  May be either
     * {@link #HINTING_OFF} or {@link #HINTING_ON}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.599 -0500", hash_original_method = "07C5EEBB2536BECA8E267FAA9B72B9E6", hash_generated_method = "012CA852257E58A63D252FB96ECD9CCD")
    
    public void setHinting(int mode){
    	//Formerly a native method
    	addTaint(mode);
    }

    /**
     * Helper for getFlags(), returning true if ANTI_ALIAS_FLAG bit is set
     * AntiAliasing smooths out the edges of what is being drawn, but is has
     * no impact on the interior of the shape. See setDither() and
     * setFilterBitmap() to affect how colors are treated.
     *
     * @return true if the antialias bit is set in the paint's flags.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.602 -0500", hash_original_method = "5965A0E7316AAA95881AE3D055547B57", hash_generated_method = "75CC9E4CFD4DB5920EF6129A9FB0C362")
    
public final boolean isAntiAlias() {
        return (getFlags() & ANTI_ALIAS_FLAG) != 0;
    }
    
	public void setAntiAlias(boolean aa) {
		//Helper for setFlags(), setting or clearing the ANTI_ALIAS_FLAG bit
		addTaint(aa);
	}
    
    /**
     * Helper for getFlags(), returning true if DITHER_FLAG bit is set
     * Dithering affects how colors that are higher precision than the device
     * are down-sampled. No dithering is generally faster, but higher precision
     * colors are just truncated down (e.g. 8888 -> 565). Dithering tries to
     * distribute the error inherent in this process, to reduce the visual
     * artifacts.
     *
     * @return true if the dithering bit is set in the paint's flags.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.607 -0500", hash_original_method = "365AF52E63589F5A5C820D079E688641", hash_generated_method = "527320AD9F0FCCD508946053C0EEB737")
    
public final boolean isDither() {
        return (getFlags() & DITHER_FLAG) != 0;
    }
    
    /**
     * Helper for setFlags(), setting or clearing the DITHER_FLAG bit
     * Dithering affects how colors that are higher precision than the device
     * are down-sampled. No dithering is generally faster, but higher precision
     * colors are just truncated down (e.g. 8888 -> 565). Dithering tries to
     * distribute the error inherent in this process, to reduce the visual
     * artifacts.
     *
     * @param dither true to set the dithering bit in flags, false to clear it
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.611 -0500", hash_original_method = "A1D5308EB6CBA9AF3933567292CFE65A", hash_generated_method = "F8B5DC34A0FAD8DADBFEEF9E9B5A5B10")
    
    public void setDither(boolean dither){
    	//Formerly a native method
    	addTaint(dither);
    }
    
    /**
     * Helper for getFlags(), returning true if LINEAR_TEXT_FLAG bit is set
     *
     * @return true if the lineartext bit is set in the paint's flags
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.613 -0500", hash_original_method = "9B687614DCB13072E0D397A968085B41", hash_generated_method = "E36F9309AB656F144D6146154772BFBD")
    
public final boolean isLinearText() {
        return (getFlags() & LINEAR_TEXT_FLAG) != 0;
    }

    /**
     * Helper for setFlags(), setting or clearing the LINEAR_TEXT_FLAG bit
     *
     * @param linearText true to set the linearText bit in the paint's flags,
     *                   false to clear it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.617 -0500", hash_original_method = "1D0DE5FFC588536775BF0537B97C257E", hash_generated_method = "C8C7B295A88EE6630BA24B97CC0B9FB1")
    
    public void setLinearText(boolean linearText){
    	//Formerly a native method
    	addTaint(linearText);
    }

    /**
     * Helper for getFlags(), returning true if SUBPIXEL_TEXT_FLAG bit is set
     *
     * @return true if the subpixel bit is set in the paint's flags
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.619 -0500", hash_original_method = "8BAC5D567D23AEF728D22298071CB50B", hash_generated_method = "7CC254380C7C581B743D681C114E17D6")
    
public final boolean isSubpixelText() {
        return (getFlags() & SUBPIXEL_TEXT_FLAG) != 0;
    }
    
    /**
     * Helper for setFlags(), setting or clearing the SUBPIXEL_TEXT_FLAG bit
     *
     * @param subpixelText true to set the subpixelText bit in the paint's
     *                     flags, false to clear it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.622 -0500", hash_original_method = "1B1E55650C7A249BE6F48A7FCCDE2B0E", hash_generated_method = "4E12BB33E56FADEA4617A30E5B4A83DE")
    
    public void setSubpixelText(boolean subpixelText){
    	//Formerly a native method
    	addTaint(subpixelText);
    }
    
    /**
     * Helper for getFlags(), returning true if UNDERLINE_TEXT_FLAG bit is set
     *
     * @return true if the underlineText bit is set in the paint's flags.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.624 -0500", hash_original_method = "540058EB824CF1779470649F70CA731D", hash_generated_method = "BFAAB3C0B70D2D919A809A18C1212413")
    
public final boolean isUnderlineText() {
        return (getFlags() & UNDERLINE_TEXT_FLAG) != 0;
    }

    /**
     * Helper for setFlags(), setting or clearing the UNDERLINE_TEXT_FLAG bit
     *
     * @param underlineText true to set the underlineText bit in the paint's
     *                      flags, false to clear it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.628 -0500", hash_original_method = "08639A75D204C407A568CB7739C3FAB4", hash_generated_method = "4229B4B2D9813B7187D8D5DE636EC17F")
    
    public void setUnderlineText(boolean underlineText){
    	//Formerly a native method
    	addTaint(underlineText);
    }

    /**
     * Helper for getFlags(), returning true if STRIKE_THRU_TEXT_FLAG bit is set
     *
     * @return true if the strikeThruText bit is set in the paint's flags.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.630 -0500", hash_original_method = "4D8DFD32FB0492CC10F2A4C48D6AABE0", hash_generated_method = "B71DB3D06622A0296C91FB46F93540CF")
    
public final boolean isStrikeThruText() {
        return (getFlags() & STRIKE_THRU_TEXT_FLAG) != 0;
    }

    /**
     * Helper for setFlags(), setting or clearing the STRIKE_THRU_TEXT_FLAG bit
     *
     * @param strikeThruText true to set the strikeThruText bit in the paint's
     *                       flags, false to clear it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.634 -0500", hash_original_method = "EE8879CC84B0101E64CC036D7E2B8F8D", hash_generated_method = "02EB93764AA2D04714B17F8DF7E2B133")
    
    public void setStrikeThruText(boolean strikeThruText){
    	//Formerly a native method
    	addTaint(strikeThruText);
    }

    /**
     * Helper for getFlags(), returning true if FAKE_BOLD_TEXT_FLAG bit is set
     *
     * @return true if the fakeBoldText bit is set in the paint's flags.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.636 -0500", hash_original_method = "64C8195C0C6E03DDD3FCE77D9F18F499", hash_generated_method = "7DB5F020C0D78329D215290C0CE9C2E6")
    
public final boolean isFakeBoldText() {
        return (getFlags() & FAKE_BOLD_TEXT_FLAG) != 0;
    }

    /**
     * Helper for setFlags(), setting or clearing the FAKE_BOLD_TEXT_FLAG bit
     *
     * @param fakeBoldText true to set the fakeBoldText bit in the paint's
     *                     flags, false to clear it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.640 -0500", hash_original_method = "6E7D99B95546D6ABB7274A6609FD0359", hash_generated_method = "6EA31BF0E7CC525CFBEE3BBC40D76929")
    
    public void setFakeBoldText(boolean fakeBoldText){
    	//Formerly a native method
    	addTaint(fakeBoldText);
    }
    
    /**
     * Whether or not the bitmap filter is activated.
     * Filtering affects the sampling of bitmaps when they are transformed.
     * Filtering does not affect how the colors in the bitmap are converted into
     * device pixels. That is dependent on dithering and xfermodes.
     *
     * @see #setFilterBitmap(boolean) setFilterBitmap()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.643 -0500", hash_original_method = "69EBEFD820D698F0EA00B7F4C8854ABB", hash_generated_method = "CB21E98A2D5462330CE1379FB39264CC")
    
public final boolean isFilterBitmap() {
        return (getFlags() & FILTER_BITMAP_FLAG) != 0;
    }
    
    public void setFilterBitmap(boolean filter) {
		//Don't think we need to perform any tainting
		//filter true to set the FILTER_BITMAP_FLAG bit in the paint's flags, false to clear it.
	}

    /**
     * Return the paint's style, used for controlling how primitives'
     * geometries are interpreted (except for drawBitmap, which always assumes
     * FILL_STYLE).
     *
     * @return the paint's style setting (Fill, Stroke, StrokeAndFill)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.648 -0500", hash_original_method = "7A3F88F43B6717422F7911C6C93794E0", hash_generated_method = "D8E46D5879D77ABC2D5362CBD1B177E1")
    
public Style getStyle() {
        return sStyleArray[native_getStyle(mNativePaint)];
    }

    /**
     * Set the paint's style, used for controlling how primitives'
     * geometries are interpreted (except for drawBitmap, which always assumes
     * Fill).
     *
     * @param style The new style to set in the paint
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.650 -0500", hash_original_method = "0C31442FDD5A78FAD136F991DDCEA542", hash_generated_method = "E884518AA9F94886D9AD0FA0C4C3470A")
    
public void setStyle(Style style) {
        native_setStyle(mNativePaint, style.nativeInt);
    }
    
	public int getColor() {  //Originally a native method, converted over
		return getTaintInt();
	}
    
	public void setColor(int color) { //Originally a native method, converted over
		addTaint(color);
	}
    
    /**
     * Helper to getColor() that just returns the color's alpha value. This is
     * the same as calling getColor() >>> 24. It always returns a value between
     * 0 (completely transparent) and 255 (completely opaque).
     *
     * @return the alpha component of the paint's color.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.661 -0500", hash_original_method = "D39ECC24DCC5EA2AD7BF99F063294ED7", hash_generated_method = "8D411FEDDF6E6858EC11D8104B750BAA")
    
    public int getAlpha(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * Helper to setColor(), that only assigns the color's alpha value,
     * leaving its r,g,b values unchanged. Results are undefined if the alpha
     * value is outside of the range [0..255]
     *
     * @param a set the alpha component [0..255] of the paint's color.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.664 -0500", hash_original_method = "2717A1058DFCA3888C2EAD1CA5D16AFD", hash_generated_method = "F752F252F3C52F6A2A3EC93C063285E2")
    
    public void setAlpha(int a){
    	//Formerly a native method
    	addTaint(a);
    }

    /**
     * Helper to setColor(), that takes a,r,g,b and constructs the color int
     *
     * @param a The new alpha component (0..255) of the paint's color.
     * @param r The new red component (0..255) of the paint's color.
     * @param g The new green component (0..255) of the paint's color.
     * @param b The new blue component (0..255) of the paint's color.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.666 -0500", hash_original_method = "61ED3E8FA79427F4AF66F905BEAE9870", hash_generated_method = "261B1F3BA320330F3FD63DDED79EF8EF")
    
public void setARGB(int a, int r, int g, int b) {
        setColor((a << 24) | (r << 16) | (g << 8) | b);
    }

    /**
     * Return the width for stroking.
     * <p />
     * A value of 0 strokes in hairline mode.
     * Hairlines always draws a single pixel independent of the canva's matrix.
     *
     * @return the paint's stroke width, used whenever the paint's style is
     *         Stroke or StrokeAndFill.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.669 -0500", hash_original_method = "6176D634A3133A706881E45A3F2EC84E", hash_generated_method = "AE3ABD3E65AC545424DFC66F8EB54DC6")
    
    public float getStrokeWidth(){
    	//Formerly a native method
    	return getTaintFloat();
    }

    /**
     * Set the width for stroking.
     * Pass 0 to stroke in hairline mode.
     * Hairlines always draws a single pixel independent of the canva's matrix.
     *
     * @param width set the paint's stroke width, used whenever the paint's
     *              style is Stroke or StrokeAndFill.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.673 -0500", hash_original_method = "75F355CF371141B3EA541D9CF06B77D7", hash_generated_method = "67D53A626B07F6BFB755140A1AB29569")
    
    public void setStrokeWidth(float width){
    	//Formerly a native method
    	addTaint(width);
    }

    /**
     * Return the paint's stroke miter value. Used to control the behavior
     * of miter joins when the joins angle is sharp.
     *
     * @return the paint's miter limit, used whenever the paint's style is
     *         Stroke or StrokeAndFill.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.677 -0500", hash_original_method = "4CDA12126AC6E812A74D0B2AB0DB6A34", hash_generated_method = "2F78FE28B8C89CE37301F4B6A06FDC4C")
    
    public float getStrokeMiter(){
    	//Formerly a native method
    	return getTaintFloat();
    }

    /**
     * Set the paint's stroke miter value. This is used to control the behavior
     * of miter joins when the joins angle is sharp. This value must be >= 0.
     *
     * @param miter set the miter limit on the paint, used whenever the paint's
     *              style is Stroke or StrokeAndFill.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.680 -0500", hash_original_method = "252E24C8C0C1E389692C4003A305EEC7", hash_generated_method = "4740D0B8E03CF68D0D6592AE7F448939")
    
    public void setStrokeMiter(float miter){
    	//Formerly a native method
    	addTaint(miter);
    }

    /**
     * Return the paint's Cap, controlling how the start and end of stroked
     * lines and paths are treated.
     *
     * @return the line cap style for the paint, used whenever the paint's
     *         style is Stroke or StrokeAndFill.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.683 -0500", hash_original_method = "5DCDC8444F177D5C991625E0155BCA4A", hash_generated_method = "6CA67A0B3E8FD2AECA35498A3BA84F38")
    
public Cap getStrokeCap() {
        return sCapArray[native_getStrokeCap(mNativePaint)];
    }

    /**
     * Set the paint's Cap.
     *
     * @param cap set the paint's line cap style, used whenever the paint's
     *            style is Stroke or StrokeAndFill.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.685 -0500", hash_original_method = "D26EF05E574A5A1AE605A2030639B3B0", hash_generated_method = "7627F41181F0CE5EFD6B0B6B4000C5D2")
    
public void setStrokeCap(Cap cap) {
        native_setStrokeCap(mNativePaint, cap.nativeInt);
    }

    /**
     * Return the paint's stroke join type.
     *
     * @return the paint's Join.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.687 -0500", hash_original_method = "EC697BED5392A0A7D9DB024F5A9BA066", hash_generated_method = "6DE2A5FD884C2CDA6AEAD1039E00F91D")
    
public Join getStrokeJoin() {
        return sJoinArray[native_getStrokeJoin(mNativePaint)];
    }

    /**
     * Set the paint's Join.
     *
     * @param join set the paint's Join, used whenever the paint's style is
     *             Stroke or StrokeAndFill.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.689 -0500", hash_original_method = "08533C600DCDC9F9AEA810B7ADA01DF0", hash_generated_method = "2AA8C9C43E339827F9CDEE71B30262F9")
    
public void setStrokeJoin(Join join) {
        native_setStrokeJoin(mNativePaint, join.nativeInt);
    }

    /**
     * Applies any/all effects (patheffect, stroking) to src, returning the
     * result in dst. The result is that drawing src with this paint will be
     * the same as drawing dst with a default paint (at least from the
     * geometric perspective).
     *
     * @param src input path
     * @param dst output path (may be the same as src)
     * @return    true if the path should be filled, or false if it should be
     *                 drawn with a hairline (width == 0)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.691 -0500", hash_original_method = "47F5CE3F8A2C9B64184DA3E7564A16E0", hash_generated_method = "9AA3C716C273CCE49736E910AA470DCB")
    
public boolean getFillPath(Path src, Path dst) {
        return native_getFillPath(mNativePaint, src.ni(), dst.ni());
    }

    /**
     * Get the paint's shader object.
     *
     * @return the paint's shader (or null)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.693 -0500", hash_original_method = "F14F830C87873216E173BB3B6F2D71DE", hash_generated_method = "8DBF73334FEE6AE360C318B464AF95B2")
    
public Shader getShader() {
        return mShader;
    }

    /**
     * Set or clear the shader object.
     * <p />
     * Pass null to clear any previous shader.
     * As a convenience, the parameter passed is also returned.
     *
     * @param shader May be null. the new shader to be installed in the paint
     * @return       shader
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.696 -0500", hash_original_method = "CB91A884CE132802683E082171CC1D6C", hash_generated_method = "880F654642DA2BF145471BD237AC89AB")
    
public Shader setShader(Shader shader) {
        int shaderNative = 0;
        if (shader != null)
            shaderNative = shader.native_instance;
        native_setShader(mNativePaint, shaderNative);
        mShader = shader;
        return shader;
    }

    /**
     * Get the paint's colorfilter (maybe be null).
     *
     * @return the paint's colorfilter (maybe be null)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.698 -0500", hash_original_method = "0F313F2FF8A981B6076CED0DBA25A8DB", hash_generated_method = "98CE345F8B786633A4EDF27D229B40E9")
    
public ColorFilter getColorFilter() {
        return mColorFilter;
    }

    /**
     * Set or clear the paint's colorfilter, returning the parameter.
     *
     * @param filter May be null. The new filter to be installed in the paint
     * @return       filter
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.700 -0500", hash_original_method = "C7126951024C02787596F4A62EFB1A3F", hash_generated_method = "57AFE104AED6D331402A3DF13C5DD917")
    
public ColorFilter setColorFilter(ColorFilter filter) {
        int filterNative = 0;
        if (filter != null)
            filterNative = filter.native_instance;
        native_setColorFilter(mNativePaint, filterNative);
        mColorFilter = filter;
        return filter;
    }

    /**
     * Get the paint's xfermode object.
     *
     * @return the paint's xfermode (or null)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.702 -0500", hash_original_method = "DC5D89A34795E2A5122BF3B6DBF85AE6", hash_generated_method = "898FFC2A2B526990BEACBF8A9EEE0A3E")
    
public Xfermode getXfermode() {
        return mXfermode;
    }

    /**
     * Set or clear the xfermode object.
     * <p />
     * Pass null to clear any previous xfermode.
     * As a convenience, the parameter passed is also returned.
     *
     * @param xfermode May be null. The xfermode to be installed in the paint
     * @return         xfermode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.704 -0500", hash_original_method = "42770A58843BCA14944D0826F7595F4B", hash_generated_method = "BA23FFFA70B29A022BAA1ABD97CA70EC")
    
public Xfermode setXfermode(Xfermode xfermode) {
        int xfermodeNative = 0;
        if (xfermode != null)
            xfermodeNative = xfermode.native_instance;
        native_setXfermode(mNativePaint, xfermodeNative);
        mXfermode = xfermode;
        return xfermode;
    }

    /**
     * Get the paint's patheffect object.
     *
     * @return the paint's patheffect (or null)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.706 -0500", hash_original_method = "D81D17C09FBA25719A586CCEA3F0BEFE", hash_generated_method = "2B2DC4C7D93AD4562516B56B7B85DC1C")
    
public PathEffect getPathEffect() {
        return mPathEffect;
    }

    /**
     * Set or clear the patheffect object.
     * <p />
     * Pass null to clear any previous patheffect.
     * As a convenience, the parameter passed is also returned.
     *
     * @param effect May be null. The patheffect to be installed in the paint
     * @return       effect
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.708 -0500", hash_original_method = "1FFAC2BED25128ED5407987A8834154C", hash_generated_method = "2030306479C2B86731DF82C2AF3886BD")
    
public PathEffect setPathEffect(PathEffect effect) {
        int effectNative = 0;
        if (effect != null) {
            effectNative = effect.native_instance;
        }
        native_setPathEffect(mNativePaint, effectNative);
        mPathEffect = effect;
        return effect;
    }

    /**
     * Get the paint's maskfilter object.
     *
     * @return the paint's maskfilter (or null)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.710 -0500", hash_original_method = "E1DE139FF20646B82CF42CE75E145566", hash_generated_method = "096E64BB945D1D21BA427E43A696EC12")
    
public MaskFilter getMaskFilter() {
        return mMaskFilter;
    }

    /**
     * Set or clear the maskfilter object.
     * <p />
     * Pass null to clear any previous maskfilter.
     * As a convenience, the parameter passed is also returned.
     *
     * @param maskfilter May be null. The maskfilter to be installed in the
     *                   paint
     * @return           maskfilter
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.712 -0500", hash_original_method = "12313867224D56BCBF8C1F85C229A2F0", hash_generated_method = "09B1ED5E8A91729B9E4F25442F0DA24F")
    
public MaskFilter setMaskFilter(MaskFilter maskfilter) {
        int maskfilterNative = 0;
        if (maskfilter != null) {
            maskfilterNative = maskfilter.native_instance;
        }
        native_setMaskFilter(mNativePaint, maskfilterNative);
        mMaskFilter = maskfilter;
        return maskfilter;
    }

    /**
     * Get the paint's typeface object.
     * <p />
     * The typeface object identifies which font to use when drawing or
     * measuring text.
     *
     * @return the paint's typeface (or null)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.715 -0500", hash_original_method = "E402FEB0FEC812E5128501C647697EA3", hash_generated_method = "A909A7BCB28345CA256D5D547C6649A7")
    
public Typeface getTypeface() {
        return mTypeface;
    }

    /**
     * Set or clear the typeface object.
     * <p />
     * Pass null to clear any previous typeface.
     * As a convenience, the parameter passed is also returned.
     *
     * @param typeface May be null. The typeface to be installed in the paint
     * @return         typeface
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.717 -0500", hash_original_method = "73CCDBF9DAC8A72983E784437C89D8D5", hash_generated_method = "72137867EE8532052E0607F4D1D79159")
    
public Typeface setTypeface(Typeface typeface) {
        int typefaceNative = 0;
        if (typeface != null) {
            typefaceNative = typeface.native_instance;
        }
        native_setTypeface(mNativePaint, typefaceNative);
        mTypeface = typeface;
        return typeface;
    }
    
    /**
     * Get the paint's rasterizer (or null).
     * <p />
     * The raster controls/modifies how paths/text are turned into alpha masks.
     *
     * @return         the paint's rasterizer (or null)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.719 -0500", hash_original_method = "7F563E2B82AAC612FD94925F2ADE0503", hash_generated_method = "49FE51D89199AC53E31BBEC2F8863CD7")
    
public Rasterizer getRasterizer() {
        return mRasterizer;
    }

    /**
     * Set or clear the rasterizer object.
     * <p />
     * Pass null to clear any previous rasterizer.
     * As a convenience, the parameter passed is also returned.
     *
     * @param rasterizer May be null. The new rasterizer to be installed in
     *                   the paint.
     * @return           rasterizer
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.721 -0500", hash_original_method = "C8A0400F51437E6D358556D513DD7EE5", hash_generated_method = "8082A6B1D25011DCA09A9D8E2E62C7FA")
    
public Rasterizer setRasterizer(Rasterizer rasterizer) {
        int rasterizerNative = 0;
        if (rasterizer != null) {
            rasterizerNative = rasterizer.native_instance;
        }
        native_setRasterizer(mNativePaint, rasterizerNative);
        mRasterizer = rasterizer;
        return rasterizer;
    }
    
    /**
     * This draws a shadow layer below the main layer, with the specified
     * offset and color, and blur radius. If radius is 0, then the shadow
     * layer is removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.724 -0500", hash_original_method = "30B7CF0D1828E00D1755D0EC1ABBE2FD", hash_generated_method = "BD8CFD4658EAAD98A6190601A807D1E8")
    
public void setShadowLayer(float radius, float dx, float dy, int color) {
        hasShadow = radius > 0.0f;
        shadowRadius = radius;
        shadowDx = dx;
        shadowDy = dy;
        shadowColor = color;
        nSetShadowLayer(radius, dx, dy, color);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.727 -0500", hash_original_method = "9A021015EB9699060DA93C776C6886F7", hash_generated_method = "725B5E92BDD389C56175CBB755A4E1BA")
    
    private void nSetShadowLayer(float radius, float dx, float dy, int color){
    	//Formerly a native method
    	addTaint(radius);
    	addTaint(dx);
    	addTaint(dy);
    	addTaint(color);
    }

    /**
     * Clear the shadow layer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.729 -0500", hash_original_method = "DB007ED9A7C8404ED556121239348407", hash_generated_method = "2A59D95977C369CBFD3E64CC09891369")
    
public void clearShadowLayer() {
        hasShadow = false;
        nSetShadowLayer(0, 0, 0, 0);
    }

    /**
     * Return the paint's Align value for drawing text. This controls how the
     * text is positioned relative to its origin. LEFT align means that all of
     * the text will be drawn to the right of its origin (i.e. the origin
     * specifieds the LEFT edge of the text) and so on.
     *
     * @return the paint's Align value for drawing text.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.731 -0500", hash_original_method = "5BB4256D6E91E955B4D3F4F49AADCB0E", hash_generated_method = "C35582FEC71C50BB2B1320C6DD67CF64")
    
public Align getTextAlign() {
        return sAlignArray[native_getTextAlign(mNativePaint)];
    }

    /**
     * Set the paint's text alignment. This controls how the
     * text is positioned relative to its origin. LEFT align means that all of
     * the text will be drawn to the right of its origin (i.e. the origin
     * specifieds the LEFT edge of the text) and so on.
     *
     * @param align set the paint's Align value for drawing text.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.734 -0500", hash_original_method = "9031C48C5C8C88E95D6A94DEBF9597C6", hash_generated_method = "01D15030FFE698C314850B5707B14980")
    
public void setTextAlign(Align align) {
        native_setTextAlign(mNativePaint, align.nativeInt);
    }

    /**
     * Return the paint's text size.
     *
     * @return the paint's text size.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.737 -0500", hash_original_method = "2A8BEEB1775704D2B3E07881AE922147", hash_generated_method = "091337FB8E5E9CB10599FCB60993420E")
    
    public float getTextSize(){
    	//Formerly a native method
    	return getTaintFloat();
    }

    /**
     * Set the paint's text size. This value must be > 0
     *
     * @param textSize set the paint's text size.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.741 -0500", hash_original_method = "D08AF5901B1A9C873DECCE4D2981E18B", hash_generated_method = "1D965C7404B4452C182D80132547D00F")
    
    public void setTextSize(float textSize){
    	//Formerly a native method
    	addTaint(textSize);
    }

    /**
     * Return the paint's horizontal scale factor for text. The default value
     * is 1.0.
     *
     * @return the paint's scale factor in X for drawing/measuring text
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.745 -0500", hash_original_method = "EEC42792D0F71421A678CE903B4FA263", hash_generated_method = "F3BAEBC74920CFBEE85320499877852A")
    
    public float getTextScaleX(){
    	//Formerly a native method
    	return getTaintFloat();
    }

    /**
     * Set the paint's horizontal scale factor for text. The default value
     * is 1.0. Values > 1.0 will stretch the text wider. Values < 1.0 will
     * stretch the text narrower.
     *
     * @param scaleX set the paint's scale in X for drawing/measuring text.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.748 -0500", hash_original_method = "87304E629EFE8B729DA5569E791B6279", hash_generated_method = "E010565F99FF26AEFB78164D1B6919D1")
    
    public void setTextScaleX(float scaleX){
    	//Formerly a native method
    	addTaint(scaleX);
    }

    /**
     * Return the paint's horizontal skew factor for text. The default value
     * is 0.
     *
     * @return         the paint's skew factor in X for drawing text.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.752 -0500", hash_original_method = "07133F92A91BAB9C1735E9B633DC996D", hash_generated_method = "E25952BB1B0AB3BC07E627BD4380B8E1")
    
    public float getTextSkewX(){
    	//Formerly a native method
    	return getTaintFloat();
    }

    /**
     * Set the paint's horizontal skew factor for text. The default value
     * is 0. For approximating oblique text, use values around -0.25.
     *
     * @param skewX set the paint's skew factor in X for drawing text.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.755 -0500", hash_original_method = "3930648222881DDA6B516B90E78C962C", hash_generated_method = "5D4FAD02E6C32975F26C95E92E3683C7")
    
    public void setTextSkewX(float skewX){
    	//Formerly a native method
    	addTaint(skewX);
    }

    /**
     * Return the distance above (negative) the baseline (ascent) based on the
     * current typeface and text size.
     *
     * @return the distance above (negative) the baseline (ascent) based on the
     *         current typeface and text size.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.758 -0500", hash_original_method = "BAAE43E1F09165366508512053D99CC4", hash_generated_method = "D8C670DCC19106F24A5FA937B386E7C2")
    
    public float ascent(){
    	//Formerly a native method
    	return getTaintFloat();
    }

    /**
     * Return the distance below (positive) the baseline (descent) based on the
     * current typeface and text size.
     *
     * @return the distance below (positive) the baseline (descent) based on
     *         the current typeface and text size.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.762 -0500", hash_original_method = "C74862F858F8C9C5BB339033A2D07A66", hash_generated_method = "ECFE1B63481F82251B331729028554D2")
    
    public float descent(){
    	//Formerly a native method
    	return getTaintFloat();
    }
    
    /**
     * Return the font's recommended interline spacing, given the Paint's
     * settings for typeface, textSize, etc. If metrics is not null, return the
     * fontmetric values in it.
     *
     * @param metrics If this object is not null, its fields are filled with
     *                the appropriate values given the paint's text attributes.
     * @return the font's recommended interline spacing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.780 -0500", hash_original_method = "E3F97BD47FCDD806F1495C59D5DC88F3", hash_generated_method = "3644B9AA0C2530EF6368CC74B36A9899")
    
    public float getFontMetrics(FontMetrics metrics){
    	//Formerly a native method
    	addTaint(metrics.getTaint());
    	return getTaintFloat();
    }
    
    /**
     * Allocates a new FontMetrics object, and then calls getFontMetrics(fm)
     * with it, returning the object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.782 -0500", hash_original_method = "413DCA25916B10D66C5EBCBD1F3E5F3E", hash_generated_method = "62E5857EAEDB96D2540E50B0BC88F933")
    
public FontMetrics getFontMetrics() {
        FontMetrics fm = new FontMetrics();
        getFontMetrics(fm);
        return fm;
    }

    /**
     * Return the font's interline spacing, given the Paint's settings for
     * typeface, textSize, etc. If metrics is not null, return the fontmetric
     * values in it. Note: all values have been converted to integers from
     * floats, in such a way has to make the answers useful for both spacing
     * and clipping. If you want more control over the rounding, call
     * getFontMetrics().
     *
     * @return the font's interline spacing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.800 -0500", hash_original_method = "22AF3BB1B7346662E340EB744DF0CCEE", hash_generated_method = "A9FA0B335F9ED368C81187D7BF877453")
    
    public int getFontMetricsInt(FontMetricsInt fmi){
    	//Formerly a native method
    	addTaint(fmi.getTaint());
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.803 -0500", hash_original_method = "B88208EBDD064B8ABC7A4B1B4C890CB3", hash_generated_method = "C1EBC8760EEF5FFFC18B09BFCB7CEEC4")
    
public FontMetricsInt getFontMetricsInt() {
        FontMetricsInt fm = new FontMetricsInt();
        getFontMetricsInt(fm);
        return fm;
    }
    
    /**
     * Return the recommend line spacing based on the current typeface and
     * text size.
     *
     * @return  recommend line spacing based on the current typeface and
     *          text size.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.805 -0500", hash_original_method = "EF0ED40E419F51E9B426A955B42CA854", hash_generated_method = "A211A2E60986B3B18A11FCCE8BD4B225")
    
public float getFontSpacing() {
        return getFontMetrics(null);
    }
    
	public float measureText(char[] text, int index, int count) {
		return 0;  //Is purely a computational function and doesn't appear to change any values/state
		/*
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if ((index | count) < 0 || index + count > text.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (text.length == 0 || count == 0) {
            return 0f;
        }
        if (!mHasCompatScaling) {
            return native_measureText(text, index, count);
        }
        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        float w = native_measureText(text, index, count);
        setTextSize(oldSize);
        return w*mInvCompatScaling;
        */
    }
    
    public enum Style {
        FILL            (0),
        STROKE          (1),
        FILL_AND_STROKE (2);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.540 -0500", hash_original_method = "A964F040AB33B77454578979DE481440", hash_generated_method = "A964F040AB33B77454578979DE481440")
            
Style(int nativeInt) {
            this.nativeInt = nativeInt;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.542 -0500", hash_original_field = "6B116C6445FBD920A2653C64D32C9FB3", hash_generated_field = "6B116C6445FBD920A2653C64D32C9FB3")

         int nativeInt;
    }
    
    public enum Cap {
        BUTT    (0),
        ROUND   (1),
        SQUARE  (2);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.547 -0500", hash_original_method = "170604C36BDD9454F30BA40CD4DC249C", hash_generated_method = "7C7EF031F39142CDB25FB2ECBFFDFF73")
            
private Cap(int nativeInt) {
            this.nativeInt = nativeInt;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.549 -0500", hash_original_field = "6B116C6445FBD920A2653C64D32C9FB3", hash_generated_field = "6B116C6445FBD920A2653C64D32C9FB3")

         int nativeInt;
    }
    
    public enum Join {
        MITER   (0),
        ROUND   (1),
        BEVEL   (2);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.554 -0500", hash_original_method = "C440FCD3AA6F55F2B5D0AF2CA971959E", hash_generated_method = "EEA685E31679A022B1A37ED900E2F7E8")
            
private Join(int nativeInt) {
            this.nativeInt = nativeInt;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.556 -0500", hash_original_field = "6B116C6445FBD920A2653C64D32C9FB3", hash_generated_field = "6B116C6445FBD920A2653C64D32C9FB3")

         int nativeInt;
    }
    
    public enum Align {
        LEFT    (0),
        CENTER  (1),
        RIGHT   (2);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.560 -0500", hash_original_method = "C26CD4BC72E67B2BC3D04F9788B7FAE5", hash_generated_method = "F74BA6A4BFB89409BBAE93481A3ED81D")
            
private Align(int nativeInt) {
            this.nativeInt = nativeInt;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.563 -0500", hash_original_field = "6B116C6445FBD920A2653C64D32C9FB3", hash_generated_field = "6B116C6445FBD920A2653C64D32C9FB3")

         int nativeInt;
    }
    
    public static class FontMetrics {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.765 -0500", hash_original_field = "5A30F5F1FC23335B87123877DB67623D", hash_generated_field = "F9D622C84E97B0C2CBDBCB618909D322")

        public float   top;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.767 -0500", hash_original_field = "F0657E0A26B24BABCE33715206D580AF", hash_generated_field = "A796C466A86DB299E2750CA9F2E8F71A")

        public float   ascent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.769 -0500", hash_original_field = "0972A276FDDE575B852A0785519F31EA", hash_generated_field = "A16D9583A878BCA686CD4BEDA3A7949E")

        public float   descent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.771 -0500", hash_original_field = "850F91B179F4198EC71F4EA92A267B16", hash_generated_field = "3601A2C074D2F75BE50976E0F9B684C6")

        public float   bottom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.774 -0500", hash_original_field = "F52149B56ED35B18316049DA3B8E54F2", hash_generated_field = "888796604577C49ABEC23552DFF6B4E6")

        public float   leading;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.976 -0400", hash_original_method = "9D0F6E676FD14A88D6B94EA1234A3DC2", hash_generated_method = "9D0F6E676FD14A88D6B94EA1234A3DC2")
        public FontMetrics ()
        {
            //Synthesized constructor
        }

    }
    
    public static class FontMetricsInt {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.784 -0500", hash_original_field = "9620536E5A5D6E12CC93092A5EBB857E", hash_generated_field = "4FB04C904AA02F82B407995BA570583C")

        public int   top;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.787 -0500", hash_original_field = "1CB9D1927B714B440EE93C047BC3A614", hash_generated_field = "FA14915E4ED5D34F11F90DF8ECCA8FF2")

        public int   ascent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.789 -0500", hash_original_field = "BAE6FF78D4986825E08BEF71303F2BC2", hash_generated_field = "28172A09342BA30A11EF1965F08565DD")

        public int   descent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.791 -0500", hash_original_field = "7F74B1869951CB3A6660AA746710A714", hash_generated_field = "F7035266BD2A20B12FE551C6FAE7D704")

        public int   bottom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.793 -0500", hash_original_field = "611032E388A652B6DBC809ED4A9B32CF", hash_generated_field = "EE2E8A507D7730016199EA97319493B2")

        public int   leading;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.977 -0400", hash_original_method = "8179D96EF0A0532FF84A77E27487BF14", hash_generated_method = "8179D96EF0A0532FF84A77E27487BF14")
        public FontMetricsInt ()
        {
            //Synthesized constructor
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.796 -0500", hash_original_method = "97A4B08E6C02C426AA89747CCB47B314", hash_generated_method = "6D6746A75B37F4ACA72AD377EF20D29B")
        
@Override public String toString() {
            return "FontMetricsInt: top=" + top + " ascent=" + ascent +
                    " descent=" + descent + " bottom=" + bottom +
                    " leading=" + leading;
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.816 -0500", hash_original_method = "1D29C18CB0DD7430F92F434F064552F2", hash_generated_method = "27B96CAB8E57DE732B067564755BC379")
    
    private float native_measureText(char[] text, int index, int count){
    	//Formerly a native method
    	addTaint(text[0]);
    	addTaint(index);
    	addTaint(count);
    	return getTaintFloat();
    }
    
    /**
     * Return the width of the text.
     *
     * @param text  The text to measure. Cannot be null.
     * @param start The index of the first character to start measuring
     * @param end   1 beyond the index of the last character to measure
     * @return      The width of the text
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.819 -0500", hash_original_method = "A455FCC07C61C67A7FE9747C69B01A43", hash_generated_method = "97E0A65B85BCC2FE20B9CD43D8DBD87A")
    
public float measureText(String text, int start, int end) {
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if ((start | end | (end - start) | (text.length() - end)) < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (text.length() == 0 || start == end) {
            return 0f;
        }
        if (!mHasCompatScaling) {
            return native_measureText(text, start, end);
        }

        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        float w = native_measureText(text, start, end);
        setTextSize(oldSize);
        return w*mInvCompatScaling;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.822 -0500", hash_original_method = "DFCEFEA707A99B30CBEB967F0B6D9176", hash_generated_method = "5E40979F12D05F71981BA49A6432349A")
    
    private float native_measureText(String text, int start, int end){
    	//Formerly a native method
    	addTaint(text.getTaint());
    	addTaint(start);
    	addTaint(end);
    	return getTaintFloat();
    }
    
	public float measureText(String text) {
		return 0;  //Is purely a computational function and doesn't appear to change any values/state
		/*
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if (text.length() == 0) {
            return 0f;
        }
        if (!mHasCompatScaling) return native_measureText(text);
        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        float w = native_measureText(text);
        setTextSize(oldSize);
        return w*mInvCompatScaling;
        */
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.828 -0500", hash_original_method = "91386AC41942864A83F6131CB196DED9", hash_generated_method = "05540B9D806F79FBC14DA146D7BEF3B9")
    
    private float native_measureText(String text){
    	//Formerly a native method
    	addTaint(text.getTaint());
    	return getTaintFloat();
    }
    
    /**
     * Return the width of the text.
     *
     * @param text  The text to measure
     * @param start The index of the first character to start measuring
     * @param end   1 beyond the index of the last character to measure
     * @return      The width of the text
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.831 -0500", hash_original_method = "6EB2D4EE24026300FF5D315D09C81847", hash_generated_method = "5533FCC8620CB46E9315ABC72134C4C9")
    
public float measureText(CharSequence text, int start, int end) {
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if ((start | end | (end - start) | (text.length() - end)) < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (text.length() == 0 || start == end) {
            return 0f;
        }
        if (text instanceof String) {
            return measureText((String)text, start, end);
        }
        if (text instanceof SpannedString ||
            text instanceof SpannableString) {
            return measureText(text.toString(), start, end);
        }
        if (text instanceof GraphicsOperations) {
            return ((GraphicsOperations)text).measureText(start, end, this);
        }

        char[] buf = TemporaryBuffer.obtain(end - start);
        TextUtils.getChars(text, start, end, buf, 0);
        float result = measureText(buf, 0, end - start);
        TemporaryBuffer.recycle(buf);
        return result;
    }
    
    /**
     * Measure the text, stopping early if the measured width exceeds maxWidth.
     * Return the number of chars that were measured, and if measuredWidth is
     * not null, return in it the actual width measured.
     *
     * @param text  The text to measure. Cannot be null.
     * @param index The offset into text to begin measuring at
     * @param count The number of maximum number of entries to measure. If count
     *              is negative, then the characters are measured in reverse order.
     * @param maxWidth The maximum width to accumulate.
     * @param measuredWidth Optional. If not null, returns the actual width
     *                     measured.
     * @return The number of chars that were measured. Will always be <=
     *         abs(count).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.833 -0500", hash_original_method = "D72C3AADC526484DACB4DD861B9B7C6F", hash_generated_method = "19D5B64634DDA8BB6E0D00E0EFD7FACF")
    
public int breakText(char[] text, int index, int count,
                                float maxWidth, float[] measuredWidth) {
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if (index < 0 || text.length - index < Math.abs(count)) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (text.length == 0 || count == 0) {
            return 0;
        }
        if (!mHasCompatScaling) {
            return native_breakText(text, index, count, maxWidth, measuredWidth);
        }

        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        int res = native_breakText(text, index, count, maxWidth*mCompatScaling,
                measuredWidth);
        setTextSize(oldSize);
        if (measuredWidth != null) measuredWidth[0] *= mInvCompatScaling;
        return res;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.837 -0500", hash_original_method = "3F5AF75ABD8DDB127E29E64DFBDBC4A3", hash_generated_method = "5215B06B96127E5A9E9C475C714CDDF3")
    
    private int native_breakText(char[] text, int index, int count,
                                            float maxWidth, float[] measuredWidth){
    	//Formerly a native method
    	addTaint(text[0]);
    	addTaint(index);
    	addTaint(count);
    	addTaint(maxWidth);
    	addTaint(measuredWidth[0]);
    	return getTaintInt();
    }

    /**
     * Measure the text, stopping early if the measured width exceeds maxWidth.
     * Return the number of chars that were measured, and if measuredWidth is
     * not null, return in it the actual width measured.
     *
     * @param text  The text to measure. Cannot be null.
     * @param start The offset into text to begin measuring at
     * @param end   The end of the text slice to measure.
     * @param measureForwards If true, measure forwards, starting at start.
     *                        Otherwise, measure backwards, starting with end.
     * @param maxWidth The maximum width to accumulate.
     * @param measuredWidth Optional. If not null, returns the actual width
     *                     measured.
     * @return The number of chars that were measured. Will always be <=
     *         abs(end - start).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.839 -0500", hash_original_method = "35BD856EF91F37D3D6F6474A08F13759", hash_generated_method = "D1CE500FA49646F60DD7AE01EAB08AEB")
    
public int breakText(CharSequence text, int start, int end,
                         boolean measureForwards,
                         float maxWidth, float[] measuredWidth) {
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if ((start | end | (end - start) | (text.length() - end)) < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (text.length() == 0 || start == end) {
            return 0;
        }
        if (start == 0 && text instanceof String && end == text.length()) {
            return breakText((String) text, measureForwards, maxWidth,
                             measuredWidth);
        }

        char[] buf = TemporaryBuffer.obtain(end - start);
        int result;

        TextUtils.getChars(text, start, end, buf, 0);

        if (measureForwards) {
            result = breakText(buf, 0, end - start, maxWidth, measuredWidth);
        } else {
            result = breakText(buf, 0, -(end - start), maxWidth, measuredWidth);
        }

        TemporaryBuffer.recycle(buf);
        return result;
    }

    /**
     * Measure the text, stopping early if the measured width exceeds maxWidth.
     * Return the number of chars that were measured, and if measuredWidth is
     * not null, return in it the actual width measured.
     *
     * @param text  The text to measure. Cannot be null.
     * @param measureForwards If true, measure forwards, starting with the
     *                        first character in the string. Otherwise,
     *                        measure backwards, starting with the
     *                        last character in the string.
     * @param maxWidth The maximum width to accumulate.
     * @param measuredWidth Optional. If not null, returns the actual width
     *                     measured.
     * @return The number of chars that were measured. Will always be <=
     *         abs(count).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.842 -0500", hash_original_method = "C05DD240630B83BC61ED5B6F9EF8E181", hash_generated_method = "7EAEBAF04A69E9DF7BA078C70CD23B54")
    
public int breakText(String text, boolean measureForwards,
                                float maxWidth, float[] measuredWidth) {
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }

        if (text.length() == 0) {
            return 0;
        }
        if (!mHasCompatScaling) {
            return native_breakText(text, measureForwards, maxWidth, measuredWidth);
        }

        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        int res = native_breakText(text, measureForwards, maxWidth*mCompatScaling,
                measuredWidth);
        setTextSize(oldSize);
        if (measuredWidth != null) measuredWidth[0] *= mInvCompatScaling;
        return res;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.846 -0500", hash_original_method = "26339CA739A6FAF1A2C001CF8203F02F", hash_generated_method = "FD6386685EFCDED7AB0C1BD2D0E2A303")
    
    private int native_breakText(String text, boolean measureForwards,
                                            float maxWidth, float[] measuredWidth){
    	//Formerly a native method
    	addTaint(text.getTaint());
    	addTaint(measureForwards);
    	addTaint(maxWidth);
    	addTaint(measuredWidth[0]);
    	return getTaintInt();
    }

    /**
     * Return the advance widths for the characters in the string.
     *
     * @param text     The text to measure. Cannot be null.
     * @param index    The index of the first char to to measure
     * @param count    The number of chars starting with index to measure
     * @param widths   array to receive the advance widths of the characters.
     *                 Must be at least a large as count.
     * @return         the actual number of widths returned.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.848 -0500", hash_original_method = "83C574DC73479463FE44C1F2988A5F29", hash_generated_method = "50516D8BBE96DB9F908C6DE143BC79A9")
    
public int getTextWidths(char[] text, int index, int count,
                             float[] widths) {
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if ((index | count) < 0 || index + count > text.length
                || count > widths.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (text.length == 0 || count == 0) {
            return 0;
        }
        if (!mHasCompatScaling) {
            return native_getTextWidths(mNativePaint, text, index, count, widths);
        }

        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        int res = native_getTextWidths(mNativePaint, text, index, count, widths);
        setTextSize(oldSize);
        for (int i=0; i<res; i++) {
            widths[i] *= mInvCompatScaling;
        }
        return res;
    }

    /**
     * Return the advance widths for the characters in the string.
     *
     * @param text     The text to measure. Cannot be null.
     * @param start    The index of the first char to to measure
     * @param end      The end of the text slice to measure
     * @param widths   array to receive the advance widths of the characters.
     *                 Must be at least a large as (end - start).
     * @return         the actual number of widths returned.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.851 -0500", hash_original_method = "F14F0812F33DADA5D35A1216285E517E", hash_generated_method = "246C897DE6D5D577D1D20E9AF6330553")
    
public int getTextWidths(CharSequence text, int start, int end,
                             float[] widths) {
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if ((start | end | (end - start) | (text.length() - end)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (end - start > widths.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (text.length() == 0 || start == end) {
            return 0;
        }
        if (text instanceof String) {
            return getTextWidths((String) text, start, end, widths);
        }
        if (text instanceof SpannedString ||
            text instanceof SpannableString) {
            return getTextWidths(text.toString(), start, end, widths);
        }
        if (text instanceof GraphicsOperations) {
            return ((GraphicsOperations) text).getTextWidths(start, end,
                                                                 widths, this);
        }

        char[] buf = TemporaryBuffer.obtain(end - start);
        TextUtils.getChars(text, start, end, buf, 0);
        int result = getTextWidths(buf, 0, end - start, widths);
        TemporaryBuffer.recycle(buf);
        return result;
    }

    /**
     * Return the advance widths for the characters in the string.
     *
     * @param text   The text to measure. Cannot be null.
     * @param start  The index of the first char to to measure
     * @param end    The end of the text slice to measure
     * @param widths array to receive the advance widths of the characters.
     *               Must be at least a large as the text.
     * @return       the number of unichars in the specified text.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.854 -0500", hash_original_method = "FC7E920984BEE100F69A523319264731", hash_generated_method = "1B49049F244B032D77853D87FA3EC6AF")
    
public int getTextWidths(String text, int start, int end, float[] widths) {
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if ((start | end | (end - start) | (text.length() - end)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (end - start > widths.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        
        if (text.length() == 0 || start == end) {
            return 0;
        }
        if (!mHasCompatScaling) {
            return native_getTextWidths(mNativePaint, text, start, end, widths);
        }

        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        int res = native_getTextWidths(mNativePaint, text, start, end, widths);
        setTextSize(oldSize);
        for (int i=0; i<res; i++) {
            widths[i] *= mInvCompatScaling;
        }
        return res;
    }
    
    /**
     * Return the advance widths for the characters in the string.
     *
     * @param text   The text to measure
     * @param widths array to receive the advance widths of the characters.
     *               Must be at least a large as the text.
     * @return       the number of unichars in the specified text.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.856 -0500", hash_original_method = "2A3DC3984F2D039C4252250086EEE48E", hash_generated_method = "794598FE398532B0C077C928931E3786")
    
public int getTextWidths(String text, float[] widths) {
        return getTextWidths(text, 0, text.length(), widths);
    }

    /**
     * Return the glyph Ids for the characters in the string.
     *
     * @param text   The text to measure
     * @param start  The index of the first char to to measure
     * @param end    The end of the text slice to measure
     * @param contextStart the index of the first character to use for shaping context,
     * must be <= start
     * @param contextEnd the index past the last character to use for shaping context,
     * must be >= end
     * @param flags the flags to control the advances, either {@link #DIRECTION_LTR}
     * or {@link #DIRECTION_RTL}
     * @param glyphs array to receive the glyph Ids of the characters.
     *               Must be at least a large as the text.
     * @return       the number of glyphs in the returned array
     *
     * @hide
     *
     * Used only for BiDi / RTL Tests
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.859 -0500", hash_original_method = "FA2DB9E943D72A496CC6A996B7086F15", hash_generated_method = "28EB7EDCECC8D8A088EF984C2DAAC8D2")
    
public int getTextGlyphs(String text, int start, int end, int contextStart, int contextEnd,
            int flags, char[] glyphs) {
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if (flags != DIRECTION_LTR && flags != DIRECTION_RTL) {
            throw new IllegalArgumentException("unknown flags value: " + flags);
        }
        if ((start | end | contextStart | contextEnd | (end - start)
                | (start - contextStart) | (contextEnd - end) | (text.length() - end)
                | (text.length() - contextEnd)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (end - start > glyphs.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return native_getTextGlyphs(mNativePaint, text, start, end, contextStart, contextEnd,
                flags, glyphs);
    }

    /**
     * Convenience overload that takes a char array instead of a
     * String.
     *
     * @see #getTextRunAdvances(String, int, int, int, int, int, float[], int)
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.861 -0500", hash_original_method = "CEF06EAF1F3995907C189C9C72603DEF", hash_generated_method = "2DB76DDEEBDD745C7F13A8FAF97AE832")
    
public float getTextRunAdvances(char[] chars, int index, int count,
            int contextIndex, int contextCount, int flags, float[] advances,
            int advancesIndex) {
        return getTextRunAdvances(chars, index, count, contextIndex, contextCount, flags,
                advances, advancesIndex, 0 /* use Harfbuzz*/);
    }

    /**
     * Convenience overload that takes a char array instead of a
     * String.
     *
     * @see #getTextRunAdvances(String, int, int, int, int, int, float[], int, int)
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.865 -0500", hash_original_method = "5F3C708402843653E3430F9E58C46380", hash_generated_method = "F20615AC409BA917F8152DD3F7DEA57A")
    
public float getTextRunAdvances(char[] chars, int index, int count,
            int contextIndex, int contextCount, int flags, float[] advances,
            int advancesIndex, int reserved) {

        if (chars == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if (flags != DIRECTION_LTR && flags != DIRECTION_RTL) {
            throw new IllegalArgumentException("unknown flags value: " + flags);
        }
        if ((index | count | contextIndex | contextCount | advancesIndex
                | (index - contextIndex) | (contextCount - count)
                | ((contextIndex + contextCount) - (index + count))
                | (chars.length - (contextIndex + contextCount))
                | (advances == null ? 0 :
                    (advances.length - (advancesIndex + count)))) < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (chars.length == 0 || count == 0){
            return 0f;
        }
        if (!mHasCompatScaling) {
            return native_getTextRunAdvances(mNativePaint, chars, index, count,
                    contextIndex, contextCount, flags, advances, advancesIndex, reserved);
        }

        final float oldSize = getTextSize();
        setTextSize(oldSize * mCompatScaling);
        float res = native_getTextRunAdvances(mNativePaint, chars, index, count,
                contextIndex, contextCount, flags, advances, advancesIndex, reserved);
        setTextSize(oldSize);

        if (advances != null) {
            for (int i = advancesIndex, e = i + count; i < e; i++) {
                advances[i] *= mInvCompatScaling;
            }
        }
        return res * mInvCompatScaling; // assume errors are not significant
    }

    /**
     * Convenience overload that takes a CharSequence instead of a
     * String.
     *
     * @see #getTextRunAdvances(String, int, int, int, int, int, float[], int)
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.867 -0500", hash_original_method = "2F009E21E693FAD74101A2B25EBDF10B", hash_generated_method = "798B1EEBF7E4C58936C41E161A769408")
    
public float getTextRunAdvances(CharSequence text, int start, int end,
            int contextStart, int contextEnd, int flags, float[] advances,
            int advancesIndex) {
        return getTextRunAdvances(text, start, end, contextStart, contextEnd, flags,
                advances, advancesIndex, 0 /* use Harfbuzz */);
    }

    /**
     * Convenience overload that takes a CharSequence instead of a
     * String.
     *
     * @see #getTextRunAdvances(String, int, int, int, int, int, float[], int)
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.870 -0500", hash_original_method = "4EFF4F6D396021295344678FBB8A998E", hash_generated_method = "71EE7B958B85EFD41CFB60F9C232922B")
    
public float getTextRunAdvances(CharSequence text, int start, int end,
            int contextStart, int contextEnd, int flags, float[] advances,
            int advancesIndex, int reserved) {

        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if ((start | end | contextStart | contextEnd | advancesIndex | (end - start)
                | (start - contextStart) | (contextEnd - end)
                | (text.length() - contextEnd)
                | (advances == null ? 0 :
                    (advances.length - advancesIndex - (end - start)))) < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (text instanceof String) {
            return getTextRunAdvances((String) text, start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, reserved);
        }
        if (text instanceof SpannedString ||
            text instanceof SpannableString) {
            return getTextRunAdvances(text.toString(), start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, reserved);
        }
        if (text instanceof GraphicsOperations) {
            return ((GraphicsOperations) text).getTextRunAdvances(start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, this);
        }
        if (text.length() == 0 || end == start) {
            return 0f;
        }

        int contextLen = contextEnd - contextStart;
        int len = end - start;
        char[] buf = TemporaryBuffer.obtain(contextLen);
        TextUtils.getChars(text, contextStart, contextEnd, buf, 0);
        float result = getTextRunAdvances(buf, start - contextStart, len,
                0, contextLen, flags, advances, advancesIndex, reserved);
        TemporaryBuffer.recycle(buf);
        return result;
    }

    /**
     * Returns the total advance width for the characters in the run
     * between start and end, and if advances is not null, the advance
     * assigned to each of these characters (java chars).
     *
     * <p>The trailing surrogate in a valid surrogate pair is assigned
     * an advance of 0.  Thus the number of returned advances is
     * always equal to count, not to the number of unicode codepoints
     * represented by the run.
     *
     * <p>In the case of conjuncts or combining marks, the total
     * advance is assigned to the first logical character, and the
     * following characters are assigned an advance of 0.
     *
     * <p>This generates the sum of the advances of glyphs for
     * characters in a reordered cluster as the width of the first
     * logical character in the cluster, and 0 for the widths of all
     * other characters in the cluster.  In effect, such clusters are
     * treated like conjuncts.
     *
     * <p>The shaping bounds limit the amount of context available
     * outside start and end that can be used for shaping analysis.
     * These bounds typically reflect changes in bidi level or font
     * metrics across which shaping does not occur.
     *
     * @param text the text to measure. Cannot be null.
     * @param start the index of the first character to measure
     * @param end the index past the last character to measure
     * @param contextStart the index of the first character to use for shaping context,
     * must be <= start
     * @param contextEnd the index past the last character to use for shaping context,
     * must be >= end
     * @param flags the flags to control the advances, either {@link #DIRECTION_LTR}
     * or {@link #DIRECTION_RTL}
     * @param advances array to receive the advances, must have room for all advances,
     * can be null if only total advance is needed
     * @param advancesIndex the position in advances at which to put the
     * advance corresponding to the character at start
     * @return the total advance
     *
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.872 -0500", hash_original_method = "1581EA555CC5336BCB2DDF38747B9672", hash_generated_method = "DF9DCFAFE6CC13EAB18DAFFF09AE7CD7")
    
public float getTextRunAdvances(String text, int start, int end, int contextStart,
            int contextEnd, int flags, float[] advances, int advancesIndex) {
        return getTextRunAdvances(text, start, end, contextStart, contextEnd, flags,
                advances, advancesIndex, 0 /* use Harfbuzz*/);
    }

    /**
     * Returns the total advance width for the characters in the run
     * between start and end, and if advances is not null, the advance
     * assigned to each of these characters (java chars).
     *
     * <p>The trailing surrogate in a valid surrogate pair is assigned
     * an advance of 0.  Thus the number of returned advances is
     * always equal to count, not to the number of unicode codepoints
     * represented by the run.
     *
     * <p>In the case of conjuncts or combining marks, the total
     * advance is assigned to the first logical character, and the
     * following characters are assigned an advance of 0.
     *
     * <p>This generates the sum of the advances of glyphs for
     * characters in a reordered cluster as the width of the first
     * logical character in the cluster, and 0 for the widths of all
     * other characters in the cluster.  In effect, such clusters are
     * treated like conjuncts.
     *
     * <p>The shaping bounds limit the amount of context available
     * outside start and end that can be used for shaping analysis.
     * These bounds typically reflect changes in bidi level or font
     * metrics across which shaping does not occur.
     *
     * @param text the text to measure. Cannot be null.
     * @param start the index of the first character to measure
     * @param end the index past the last character to measure
     * @param contextStart the index of the first character to use for shaping context,
     * must be <= start
     * @param contextEnd the index past the last character to use for shaping context,
     * must be >= end
     * @param flags the flags to control the advances, either {@link #DIRECTION_LTR}
     * or {@link #DIRECTION_RTL}
     * @param advances array to receive the advances, must have room for all advances,
     * can be null if only total advance is needed
     * @param advancesIndex the position in advances at which to put the
     * advance corresponding to the character at start
     * @param reserved int reserved value
     * @return the total advance
     *
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.875 -0500", hash_original_method = "1C46AF2D403F5DA84F25080DCEA69AA0", hash_generated_method = "0CA4AF8A04EC9FA24F298682F3160AB6")
    
public float getTextRunAdvances(String text, int start, int end, int contextStart,
            int contextEnd, int flags, float[] advances, int advancesIndex, int reserved) {

        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if (flags != DIRECTION_LTR && flags != DIRECTION_RTL) {
            throw new IllegalArgumentException("unknown flags value: " + flags);
        }
        if ((start | end | contextStart | contextEnd | advancesIndex | (end - start)
                | (start - contextStart) | (contextEnd - end)
                | (text.length() - contextEnd)
                | (advances == null ? 0 :
                    (advances.length - advancesIndex - (end - start)))) < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (text.length() == 0 || start == end) {
            return 0f;
        }

        if (!mHasCompatScaling) {
            return native_getTextRunAdvances(mNativePaint, text, start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, reserved);
        }

        final float oldSize = getTextSize();
        setTextSize(oldSize * mCompatScaling);
        float totalAdvance = native_getTextRunAdvances(mNativePaint, text, start, end,
                contextStart, contextEnd, flags, advances, advancesIndex, reserved);
        setTextSize(oldSize);

        if (advances != null) {
            for (int i = advancesIndex, e = i + (end - start); i < e; i++) {
                advances[i] *= mInvCompatScaling;
            }
        }
        return totalAdvance * mInvCompatScaling; // assume errors are insignificant
    }

    /**
     * Returns the next cursor position in the run.  This avoids placing the
     * cursor between surrogates, between characters that form conjuncts,
     * between base characters and combining marks, or within a reordering
     * cluster.
     *
     * <p>ContextStart and offset are relative to the start of text.
     * The context is the shaping context for cursor movement, generally
     * the bounds of the metric span enclosing the cursor in the direction of
     * movement.
     *
     * <p>If cursorOpt is {@link #CURSOR_AT} and the offset is not a valid
     * cursor position, this returns -1.  Otherwise this will never return a
     * value before contextStart or after contextStart + contextLength.
     *
     * @param text the text
     * @param contextStart the start of the context
     * @param contextLength the length of the context
     * @param flags either {@link #DIRECTION_RTL} or {@link #DIRECTION_LTR}
     * @param offset the cursor position to move from
     * @param cursorOpt how to move the cursor, one of {@link #CURSOR_AFTER},
     * {@link #CURSOR_AT_OR_AFTER}, {@link #CURSOR_BEFORE},
     * {@link #CURSOR_AT_OR_BEFORE}, or {@link #CURSOR_AT}
     * @return the offset of the next position, or -1
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.878 -0500", hash_original_method = "EB6D9B15E4067DFED9B2A74E5C744A1F", hash_generated_method = "E7164CE72F146396B722F3F4CFB90AF1")
    
public int getTextRunCursor(char[] text, int contextStart, int contextLength,
            int flags, int offset, int cursorOpt) {
        int contextEnd = contextStart + contextLength;
        if (((contextStart | contextEnd | offset | (contextEnd - contextStart)
                | (offset - contextStart) | (contextEnd - offset)
                | (text.length - contextEnd) | cursorOpt) < 0)
                || cursorOpt > CURSOR_OPT_MAX_VALUE) {
            throw new IndexOutOfBoundsException();
        }

        return native_getTextRunCursor(mNativePaint, text,
                contextStart, contextLength, flags, offset, cursorOpt);
    }

    /**
     * Returns the next cursor position in the run.  This avoids placing the
     * cursor between surrogates, between characters that form conjuncts,
     * between base characters and combining marks, or within a reordering
     * cluster.
     *
     * <p>ContextStart, contextEnd, and offset are relative to the start of
     * text.  The context is the shaping context for cursor movement, generally
     * the bounds of the metric span enclosing the cursor in the direction of
     * movement.
     *
     * <p>If cursorOpt is {@link #CURSOR_AT} and the offset is not a valid
     * cursor position, this returns -1.  Otherwise this will never return a
     * value before contextStart or after contextEnd.
     *
     * @param text the text
     * @param contextStart the start of the context
     * @param contextEnd the end of the context
     * @param flags either {@link #DIRECTION_RTL} or {@link #DIRECTION_LTR}
     * @param offset the cursor position to move from
     * @param cursorOpt how to move the cursor, one of {@link #CURSOR_AFTER},
     * {@link #CURSOR_AT_OR_AFTER}, {@link #CURSOR_BEFORE},
     * {@link #CURSOR_AT_OR_BEFORE}, or {@link #CURSOR_AT}
     * @return the offset of the next position, or -1
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.881 -0500", hash_original_method = "34AAA4A164F43F1E201745A1F65B4411", hash_generated_method = "BD4E80FC28625BAC35C44C40EC9A00DF")
    
public int getTextRunCursor(CharSequence text, int contextStart,
           int contextEnd, int flags, int offset, int cursorOpt) {

        if (text instanceof String || text instanceof SpannedString ||
                text instanceof SpannableString) {
            return getTextRunCursor(text.toString(), contextStart, contextEnd,
                    flags, offset, cursorOpt);
        }
        if (text instanceof GraphicsOperations) {
            return ((GraphicsOperations) text).getTextRunCursor(
                    contextStart, contextEnd, flags, offset, cursorOpt, this);
        }

        int contextLen = contextEnd - contextStart;
        char[] buf = TemporaryBuffer.obtain(contextLen);
        TextUtils.getChars(text, contextStart, contextEnd, buf, 0);
        int result = getTextRunCursor(buf, 0, contextLen, flags, offset - contextStart, cursorOpt);
        TemporaryBuffer.recycle(buf);
        return result;
    }

    /**
     * Returns the next cursor position in the run.  This avoids placing the
     * cursor between surrogates, between characters that form conjuncts,
     * between base characters and combining marks, or within a reordering
     * cluster.
     *
     * <p>ContextStart, contextEnd, and offset are relative to the start of
     * text.  The context is the shaping context for cursor movement, generally
     * the bounds of the metric span enclosing the cursor in the direction of
     * movement.
     *
     * <p>If cursorOpt is {@link #CURSOR_AT} and the offset is not a valid
     * cursor position, this returns -1.  Otherwise this will never return a
     * value before contextStart or after contextEnd.
     *
     * @param text the text
     * @param contextStart the start of the context
     * @param contextEnd the end of the context
     * @param flags either {@link #DIRECTION_RTL} or {@link #DIRECTION_LTR}
     * @param offset the cursor position to move from
     * @param cursorOpt how to move the cursor, one of {@link #CURSOR_AFTER},
     * {@link #CURSOR_AT_OR_AFTER}, {@link #CURSOR_BEFORE},
     * {@link #CURSOR_AT_OR_BEFORE}, or {@link #CURSOR_AT}
     * @return the offset of the next position, or -1
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.883 -0500", hash_original_method = "D546CDC2181E95744AE417A48EFCB65E", hash_generated_method = "3D450E6D0680EE513BA96C6E3160C2CC")
    
public int getTextRunCursor(String text, int contextStart, int contextEnd,
            int flags, int offset, int cursorOpt) {
        if (((contextStart | contextEnd | offset | (contextEnd - contextStart)
                | (offset - contextStart) | (contextEnd - offset)
                | (text.length() - contextEnd) | cursorOpt) < 0)
                || cursorOpt > CURSOR_OPT_MAX_VALUE) {
            throw new IndexOutOfBoundsException();
        }

        return native_getTextRunCursor(mNativePaint, text,
                contextStart, contextEnd, flags, offset, cursorOpt);
    }

    /**
     * Return the path (outline) for the specified text.
     * Note: just like Canvas.drawText, this will respect the Align setting in
     * the paint.
     *
     * @param text     The text to retrieve the path from
     * @param index    The index of the first character in text
     * @param count    The number of characterss starting with index
     * @param x        The x coordinate of the text's origin
     * @param y        The y coordinate of the text's origin
     * @param path     The path to receive the data describing the text. Must
     *                 be allocated by the caller.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.885 -0500", hash_original_method = "0E7040D8937128B20B9E7E7425C5D78D", hash_generated_method = "0810C2BBA5A53A3C9BBB985E1732AF8C")
    
public void getTextPath(char[] text, int index, int count,
                            float x, float y, Path path) {
        if ((index | count) < 0 || index + count > text.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        native_getTextPath(mNativePaint, mBidiFlags, text, index, count, x, y, 
                path.ni());
    }

    /**
     * Return the path (outline) for the specified text.
     * Note: just like Canvas.drawText, this will respect the Align setting
     * in the paint.
     *
     * @param text  The text to retrieve the path from
     * @param start The first character in the text
     * @param end   1 past the last charcter in the text
     * @param x     The x coordinate of the text's origin
     * @param y     The y coordinate of the text's origin
     * @param path  The path to receive the data describing the text. Must
     *              be allocated by the caller.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.887 -0500", hash_original_method = "F99FE41661C2E1CF4ABA5DAE3EEF7955", hash_generated_method = "957AF2587D059088B13D107D8B082BAC")
    
public void getTextPath(String text, int start, int end,
                            float x, float y, Path path) {
        if ((start | end | (end - start) | (text.length() - end)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        native_getTextPath(mNativePaint, mBidiFlags, text, start, end, x, y, 
                path.ni());
    }
    
    /**
     * Return in bounds (allocated by the caller) the smallest rectangle that
     * encloses all of the characters, with an implied origin at (0,0).
     *
     * @param text  String to measure and return its bounds
     * @param start Index of the first char in the string to measure
     * @param end   1 past the last char in the string measure
     * @param bounds Returns the unioned bounds of all the text. Must be
     *               allocated by the caller.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.889 -0500", hash_original_method = "FD83EA4D46005AE0FEF3AC534F19299F", hash_generated_method = "67A558C88EFC12C6B179C661C2B26242")
    
public void getTextBounds(String text, int start, int end, Rect bounds) {
        if ((start | end | (end - start) | (text.length() - end)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (bounds == null) {
            throw new NullPointerException("need bounds Rect");
        }
        nativeGetStringBounds(mNativePaint, text, start, end, bounds);
    }
    
    /**
     * Return in bounds (allocated by the caller) the smallest rectangle that
     * encloses all of the characters, with an implied origin at (0,0).
     *
     * @param text  Array of chars to measure and return their unioned bounds
     * @param index Index of the first char in the array to measure
     * @param count The number of chars, beginning at index, to measure
     * @param bounds Returns the unioned bounds of all the text. Must be
     *               allocated by the caller.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.892 -0500", hash_original_method = "989A6FF8CB429D5D016E1FAEDFB33A1F", hash_generated_method = "299179383EEDB6696FA9015227E77E45")
    
public void getTextBounds(char[] text, int index, int count, Rect bounds) {
        if ((index | count) < 0 || index + count > text.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (bounds == null) {
            throw new NullPointerException("need bounds Rect");
        }
        nativeGetCharArrayBounds(mNativePaint, text, index, count, bounds);
    }
    
	@Override
    protected void finalize() throws Throwable {
		super.finalize();
		/*
        try {
            finalizer(mNativePaint);
        } finally {
            super.finalize();
        }
        */
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.996 -0500", hash_original_method = "2766BE855FF2D72BD9BAD5CAFB40ABE8", hash_generated_method = "B07C69668F84001147F0A56686A800E4")
    
    private int native_getTextRunCursor(int native_object, char[] text,
                int contextStart, int contextLength, int flags, int offset, int cursorOpt){
    	//Formerly a native method
    	addTaint(native_object);
    	addTaint(text[0]);
    	addTaint(contextStart);
    	addTaint(contextLength);
    	addTaint(flags);
    	addTaint(offset);
    	addTaint(cursorOpt);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:08.000 -0500", hash_original_method = "EDBEC3DC0C784965FEB390C91BCB35F5", hash_generated_method = "D2C19FF52E140772B7D328C960F58DD9")
    
    private int native_getTextRunCursor(int native_object, String text,
                int contextStart, int contextEnd, int flags, int offset, int cursorOpt){
    	//Formerly a native method
    	addTaint(native_object);
    	addTaint(text.getTaint());
    	addTaint(contextStart);
    	addTaint(contextEnd);
    	addTaint(flags);
    	addTaint(offset);
    	addTaint(cursorOpt);
    	return getTaintInt();
    }

}

