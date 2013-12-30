package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.style.LeadingMarginSpan;
import android.text.style.LeadingMarginSpan.LeadingMarginSpan2;
import android.text.style.LineHeightSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.TabStopSpan;
import android.util.Log;

import com.android.internal.util.ArrayUtils;






public class StaticLayout extends Layout {

    /**
     * Returns true if the specified character is one of those specified
     * as being Ideographic (class ID) by the Unicode Line Breaking Algorithm
     * (http://www.unicode.org/unicode/reports/tr14/), and is therefore OK
     * to break between a pair of.
     *
     * @param includeNonStarters also return true for category NS
     *                           (non-starters), which can be broken
     *                           after but not before.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.919 -0500", hash_original_method = "D4C81D48070585F36B5352844546D049", hash_generated_method = "629B9A28DBC1AA3E670F6F3B511A78B5")
    
private static final boolean isIdeographic(char c, boolean includeNonStarters) {
        if (c >= '\u2E80' && c <= '\u2FFF') {
            return true; // CJK, KANGXI RADICALS, DESCRIPTION SYMBOLS
        }
        if (c == '\u3000') {
            return true; // IDEOGRAPHIC SPACE
        }
        if (c >= '\u3040' && c <= '\u309F') {
            if (!includeNonStarters) {
                switch (c) {
                case '\u3041': //  # HIRAGANA LETTER SMALL A
                case '\u3043': //  # HIRAGANA LETTER SMALL I
                case '\u3045': //  # HIRAGANA LETTER SMALL U
                case '\u3047': //  # HIRAGANA LETTER SMALL E
                case '\u3049': //  # HIRAGANA LETTER SMALL O
                case '\u3063': //  # HIRAGANA LETTER SMALL TU
                case '\u3083': //  # HIRAGANA LETTER SMALL YA
                case '\u3085': //  # HIRAGANA LETTER SMALL YU
                case '\u3087': //  # HIRAGANA LETTER SMALL YO
                case '\u308E': //  # HIRAGANA LETTER SMALL WA
                case '\u3095': //  # HIRAGANA LETTER SMALL KA
                case '\u3096': //  # HIRAGANA LETTER SMALL KE
                case '\u309B': //  # KATAKANA-HIRAGANA VOICED SOUND MARK
                case '\u309C': //  # KATAKANA-HIRAGANA SEMI-VOICED SOUND MARK
                case '\u309D': //  # HIRAGANA ITERATION MARK
                case '\u309E': //  # HIRAGANA VOICED ITERATION MARK
                    return false;
                }
            }
            return true; // Hiragana (except small characters)
        }
        if (c >= '\u30A0' && c <= '\u30FF') {
            if (!includeNonStarters) {
                switch (c) {
                case '\u30A0': //  # KATAKANA-HIRAGANA DOUBLE HYPHEN
                case '\u30A1': //  # KATAKANA LETTER SMALL A
                case '\u30A3': //  # KATAKANA LETTER SMALL I
                case '\u30A5': //  # KATAKANA LETTER SMALL U
                case '\u30A7': //  # KATAKANA LETTER SMALL E
                case '\u30A9': //  # KATAKANA LETTER SMALL O
                case '\u30C3': //  # KATAKANA LETTER SMALL TU
                case '\u30E3': //  # KATAKANA LETTER SMALL YA
                case '\u30E5': //  # KATAKANA LETTER SMALL YU
                case '\u30E7': //  # KATAKANA LETTER SMALL YO
                case '\u30EE': //  # KATAKANA LETTER SMALL WA
                case '\u30F5': //  # KATAKANA LETTER SMALL KA
                case '\u30F6': //  # KATAKANA LETTER SMALL KE
                case '\u30FB': //  # KATAKANA MIDDLE DOT
                case '\u30FC': //  # KATAKANA-HIRAGANA PROLONGED SOUND MARK
                case '\u30FD': //  # KATAKANA ITERATION MARK
                case '\u30FE': //  # KATAKANA VOICED ITERATION MARK
                    return false;
                }
            }
            return true; // Katakana (except small characters)
        }
        if (c >= '\u3400' && c <= '\u4DB5') {
            return true; // CJK UNIFIED IDEOGRAPHS EXTENSION A
        }
        if (c >= '\u4E00' && c <= '\u9FBB') {
            return true; // CJK UNIFIED IDEOGRAPHS
        }
        if (c >= '\uF900' && c <= '\uFAD9') {
            return true; // CJK COMPATIBILITY IDEOGRAPHS
        }
        if (c >= '\uA000' && c <= '\uA48F') {
            return true; // YI SYLLABLES
        }
        if (c >= '\uA490' && c <= '\uA4CF') {
            return true; // YI RADICALS
        }
        if (c >= '\uFE62' && c <= '\uFE66') {
            return true; // SMALL PLUS SIGN to SMALL EQUALS SIGN
        }
        if (c >= '\uFF10' && c <= '\uFF19') {
            return true; // WIDE DIGITS
        }

        return false;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.881 -0500", hash_original_field = "D6967B60E1FA58F44D82FDF9A2E48DFA", hash_generated_field = "6CFCC815EA0D3325CF63B4F6F365477B")


    static final String TAG = "StaticLayout";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.987 -0500", hash_original_field = "E6CE03C5744B90BA483BE6BF0E85AD41", hash_generated_field = "CD7507056B56DB550B1D813FB4B3D98B")


    private static final int COLUMNS_NORMAL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.990 -0500", hash_original_field = "4BC40476543CA50D93E7CE73D5E42064", hash_generated_field = "67237E10844A87633E2718F5190772DB")

    private static final int COLUMNS_ELLIPSIZE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.992 -0500", hash_original_field = "27A41ADDFF59BC8B58A601456818918E", hash_generated_field = "D858CF53160507E553F41D31EE5B91B4")

    private static final int START = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.995 -0500", hash_original_field = "A93E36DA171556A9DAC174A6CE0830C7", hash_generated_field = "00A39BB8E63058E1AB6D38D081403510")

    private static final int DIR = START;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.998 -0500", hash_original_field = "858D40657E9E9D49DB24D92DE4881B0D", hash_generated_field = "F85A3E18A8BF309A20F781E644D5A08F")

    private static final int TAB = START;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.038 -0500", hash_original_field = "A9E5EAD368A2540BAA81385F8F37A77E", hash_generated_field = "1A855B733EBA6E8672640513C3B16A39")

    private static final int TOP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.042 -0500", hash_original_field = "142D08D09F2ADDBEAFFE8AF39C3868BD", hash_generated_field = "A52FCC4891B5FC0ED83D62A588ACAE05")

    private static final int DESCENT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.046 -0500", hash_original_field = "DCAA152E596CCF7D943D5B21A68B86B4", hash_generated_field = "E2BDE677DE1C429BF2BE569E18329E43")

    private static final int ELLIPSIS_START = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.052 -0500", hash_original_field = "664582F8629EEEC6D6294BAB4BA1269C", hash_generated_field = "1B418124A7F291F864D2626D0BD306EC")

    private static final int ELLIPSIS_COUNT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.068 -0500", hash_original_field = "51ABBD2944D24467D63DD23BADE8CD8B", hash_generated_field = "E308275B4AE398B992072A6F7EA1A3C0")


    private static final int START_MASK = 0x1FFFFFFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.073 -0500", hash_original_field = "2174DD8845E3505750875CAA65AA1573", hash_generated_field = "B97E7A8E8F664E1C1793F75E8020C7A1")

    private static final int DIR_SHIFT  = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.077 -0500", hash_original_field = "D0EFD515F99E5C7C1D37F987D229A266", hash_generated_field = "8DE592C2FC67BEDD6F7461E40AD4FEE6")

    private static final int TAB_MASK   = 0x20000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.081 -0500", hash_original_field = "523B437B66E94D47C6D3407D5611D3C9", hash_generated_field = "D5E340FF9F0E2C74F920DF02A6624213")


    private static final int TAB_INCREMENT = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.085 -0500", hash_original_field = "7B7633C9DAA804E766870A7F68CC00F9", hash_generated_field = "7D1377BE9BFDAB86B8C4B5771EE6843C")


    private static final char CHAR_FIRST_CJK = '\u2E80';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.089 -0500", hash_original_field = "A14CDD9230DB60E88ABE4C9F804F5EE9", hash_generated_field = "487332DEC3D3C8842021C94862F5B4C7")


    private static final char CHAR_NEW_LINE = '\n';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.092 -0500", hash_original_field = "17C5CE82EBBF0C49BEADDDA71FDD500F", hash_generated_field = "6D0AB500D1767C0990B7C5EF6D2671B3")

    private static final char CHAR_TAB = '\t';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.097 -0500", hash_original_field = "54B79ED09BEAE2C75B8C255B000AE391", hash_generated_field = "5DF6F862727E58FBFF8DFD0D876D6C5A")

    private static final char CHAR_SPACE = ' ';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.102 -0500", hash_original_field = "E26983B007C5D85C6A86A83C02747BDE", hash_generated_field = "37626264B4B037B3F69AB09219E04D8F")

    private static final char CHAR_DOT = '.';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.105 -0500", hash_original_field = "DC37C53CBFCBC093F512FA0FB854A18A", hash_generated_field = "3FB66E66ECAA8ACAE358CE68734B3245")

    private static final char CHAR_COMMA = ',';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.108 -0500", hash_original_field = "F443D56C70EF4F0D6828EF8CCBAAF8A6", hash_generated_field = "C1B89DF36207A4C29A88D82C9BC1CBE5")

    private static final char CHAR_COLON = ':';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.111 -0500", hash_original_field = "DA77231584AD4EE4CAA34C60990142C2", hash_generated_field = "F9E773EC71F589DA0129DE9F3A6B78A1")

    private static final char CHAR_SEMICOLON = ';';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.113 -0500", hash_original_field = "A32F16598A839B77A33874EDB3F9722E", hash_generated_field = "A4DA5040848D5DBDB9F950FEB8F71CB7")

    private static final char CHAR_SLASH = '/';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.117 -0500", hash_original_field = "C3E27E84B741C01D37417DE3F8F002FF", hash_generated_field = "8F2658BD995F064C6D0D73A3CA872693")

    private static final char CHAR_HYPHEN = '-';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.119 -0500", hash_original_field = "D8513B6BE3009FCCA0FC34A40BACC2E9", hash_generated_field = "4115D5FCA00B16A69C97785E9691BDA9")


    private static final double EXTRA_ROUNDING = 0.5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.122 -0500", hash_original_field = "84F6B10B43B3117DC17BB1EB6470391C", hash_generated_field = "2BF933DA0C369B3A13C810DDA18B4DC4")


    private static final String ELLIPSIS_NORMAL = "\u2026";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.125 -0500", hash_original_field = "785487AD3A5C29FA7A7900F14305BC5F", hash_generated_field = "EF1EE2AD82D24DCEF53A3F77F1F7B2B5")

    private static final String ELLIPSIS_TWO_DOTS = "\u2025";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.128 -0500", hash_original_field = "1689EDD7BA3CB715680F4121375FF903", hash_generated_field = "033397B01596D864D5BF5FED2BB28EB2")


    private static final int CHAR_FIRST_HIGH_SURROGATE = 0xD800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.130 -0500", hash_original_field = "148A98E230AF67FB3A3DEC9631590F0A", hash_generated_field = "45D09AEF41710114C8A584328D3831D7")

    private static final int CHAR_LAST_LOW_SURROGATE = 0xDFFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.976 -0500", hash_original_field = "FB98162853E5BA899583BAB7C75D9CFE", hash_generated_field = "45537663750337309A584754E1437CDD")


    private int mLineCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.690 -0400", hash_original_field = "A6796D45932911E4DA1D9D40D1BD23B8", hash_generated_field = "74C5EEEB9113B0F29D66E0A4983A6BC3")

    private int mTopPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.691 -0400", hash_original_field = "097A31AA17188409E251DABE4869FAFE", hash_generated_field = "8A7C981A0C6837E513C477AD1250B374")

    private int mBottomPadding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.982 -0500", hash_original_field = "5D305AA3AFBCC646419732255616147E", hash_generated_field = "75F4039C98FB52077D38E34F530EB3FF")

    private int mColumns;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.984 -0500", hash_original_field = "E93A6A7C15DB787403A51782F6607C39", hash_generated_field = "C354DF48C5764CCC7B8B820C49BF2BBD")

    private int mEllipsizedWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.055 -0500", hash_original_field = "93B35D77625D289664F5134570D795DA", hash_generated_field = "26F954E05EF8E6C19C537B63E9266033")


    private int[] mLines;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.059 -0500", hash_original_field = "F0D18EECBAEED0ABEA4EDEFD4FF088CF", hash_generated_field = "7D53F177386EEFF604DBA9C007C99633")

    private Directions[] mLineDirections;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.063 -0500", hash_original_field = "4CBC52B3B784BC3B45E1BDB6737F92F4", hash_generated_field = "15DFAE1051C19AC15963DEF70B1F9BF5")

    private int mMaximumVisibleLineCount = Integer.MAX_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.132 -0500", hash_original_field = "7C7817FF833E02CE3337B024E628618D", hash_generated_field = "67359422AB8F87EBC819B683687CEFC5")

    private MeasuredText mMeasured;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.135 -0500", hash_original_field = "DAD3D7CEAAA5BB3F1657DB91FD569118", hash_generated_field = "9F4F72572DE50EBE55E7D6F43A8C24E4")

    private Paint.FontMetricsInt mFontMetricsInt = new Paint.FontMetricsInt();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.885 -0500", hash_original_method = "C77149727B404FEFD5CB3129B7BB45BF", hash_generated_method = "A290868F3E99EAF1AF2A3169C47ACB44")
    
public StaticLayout(CharSequence source, TextPaint paint,
                        int width,
                        Alignment align, float spacingmult, float spacingadd,
                        boolean includepad) {
        this(source, 0, source.length(), paint, width, align,
             spacingmult, spacingadd, includepad);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.889 -0500", hash_original_method = "81565FB766EC1D266415894033F3BC38", hash_generated_method = "A6F2A904A6E793230C3D3296199BB1A0")
    
public StaticLayout(CharSequence source, TextPaint paint,
            int width, Alignment align, TextDirectionHeuristic textDir,
            float spacingmult, float spacingadd,
            boolean includepad) {
        this(source, 0, source.length(), paint, width, align, textDir,
                spacingmult, spacingadd, includepad);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.892 -0500", hash_original_method = "BF066121E6D6D3B30CB2E4FB82D6E631", hash_generated_method = "54A265C3200604F0A1E8412D69D5143F")
    
public StaticLayout(CharSequence source, int bufstart, int bufend,
                        TextPaint paint, int outerwidth,
                        Alignment align,
                        float spacingmult, float spacingadd,
                        boolean includepad) {
        this(source, bufstart, bufend, paint, outerwidth, align,
             spacingmult, spacingadd, includepad, null, 0);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.895 -0500", hash_original_method = "683465774808809C7366667F354731A1", hash_generated_method = "C4BF3D0BF0BA9EF4B943C40BDD339394")
    
public StaticLayout(CharSequence source, int bufstart, int bufend,
            TextPaint paint, int outerwidth,
            Alignment align, TextDirectionHeuristic textDir,
            float spacingmult, float spacingadd,
            boolean includepad) {
        this(source, bufstart, bufend, paint, outerwidth, align, textDir,
                spacingmult, spacingadd, includepad, null, 0, Integer.MAX_VALUE);
}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.898 -0500", hash_original_method = "D92F1C5E6D18A86EA341983F1D2D5889", hash_generated_method = "1EA2B63F7B3C5F9A41E168991CD10705")
    
public StaticLayout(CharSequence source, int bufstart, int bufend,
            TextPaint paint, int outerwidth,
            Alignment align,
            float spacingmult, float spacingadd,
            boolean includepad,
            TextUtils.TruncateAt ellipsize, int ellipsizedWidth) {
        this(source, bufstart, bufend, paint, outerwidth, align,
                TextDirectionHeuristics.FIRSTSTRONG_LTR,
                spacingmult, spacingadd, includepad, ellipsize, ellipsizedWidth, Integer.MAX_VALUE);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.902 -0500", hash_original_method = "67715870CA89D1E43E3638ABED5B90D0", hash_generated_method = "58C4319CEBA084D5C0B5DE871EEC2D56")
    
public StaticLayout(CharSequence source, int bufstart, int bufend,
                        TextPaint paint, int outerwidth,
                        Alignment align, TextDirectionHeuristic textDir,
                        float spacingmult, float spacingadd,
                        boolean includepad,
                        TextUtils.TruncateAt ellipsize, int ellipsizedWidth, int maxLines) {
        super((ellipsize == null)
                ? source
                : (source instanceof Spanned)
                    ? new SpannedEllipsizer(source)
                    : new Ellipsizer(source),
              paint, outerwidth, align, textDir, spacingmult, spacingadd);

        /*
         * This is annoying, but we can't refer to the layout until
         * superclass construction is finished, and the superclass
         * constructor wants the reference to the display text.
         *
         * This will break if the superclass constructor ever actually
         * cares about the content instead of just holding the reference.
         */
        if (ellipsize != null) {
            Ellipsizer e = (Ellipsizer) getText();

            e.mLayout = this;
            e.mWidth = ellipsizedWidth;
            e.mMethod = ellipsize;
            mEllipsizedWidth = ellipsizedWidth;

            mColumns = COLUMNS_ELLIPSIZE;
        } else {
            mColumns = COLUMNS_NORMAL;
            mEllipsizedWidth = outerwidth;
        }

        mLines = new int[ArrayUtils.idealIntArraySize(2 * mColumns)];
        mLineDirections = new Directions[
                             ArrayUtils.idealIntArraySize(2 * mColumns)];
        mMaximumVisibleLineCount = maxLines;

        mMeasured = MeasuredText.obtain();

        generate(source, bufstart, bufend, paint, outerwidth, textDir, spacingmult,
                 spacingadd, includepad, includepad, ellipsizedWidth,
                 ellipsize);

        mMeasured = MeasuredText.recycle(mMeasured);
        mFontMetricsInt = null;
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.905 -0500", hash_original_method = "F6D0B9C991ED85508405BA894E3CF311", hash_generated_method = "F6D0B9C991ED85508405BA894E3CF311")
    
StaticLayout(CharSequence text) {
        super(text, null, 0, null, 0, 0);

        mColumns = COLUMNS_ELLIPSIZE;
        mLines = new int[ArrayUtils.idealIntArraySize(2 * mColumns)];
        mLineDirections = new Directions[
                             ArrayUtils.idealIntArraySize(2 * mColumns)];
        mMeasured = MeasuredText.obtain();
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.914 -0500", hash_original_method = "36200F938D6B110E70DA8FCD0A142EF7", hash_generated_method = "5CE7E1A826E6B136D44219A0DCB387EC")
    
void generate(CharSequence source, int bufStart, int bufEnd,
                        TextPaint paint, int outerWidth,
                        TextDirectionHeuristic textDir, float spacingmult,
                        float spacingadd, boolean includepad,
                        boolean trackpad, float ellipsizedWidth,
                        TextUtils.TruncateAt ellipsize) {
        mLineCount = 0;

        int v = 0;
        boolean needMultiply = (spacingmult != 1 || spacingadd != 0);

        Paint.FontMetricsInt fm = mFontMetricsInt;
        int[] chooseHtv = null;

        MeasuredText measured = mMeasured;

        Spanned spanned = null;
        if (source instanceof Spanned)
            spanned = (Spanned) source;

        int DEFAULT_DIR = DIR_LEFT_TO_RIGHT; // XXX

        int paraEnd;
        for (int paraStart = bufStart; paraStart <= bufEnd; paraStart = paraEnd) {
            paraEnd = TextUtils.indexOf(source, CHAR_NEW_LINE, paraStart, bufEnd);
            if (paraEnd < 0)
                paraEnd = bufEnd;
            else
                paraEnd++;

            int firstWidthLineLimit = mLineCount + 1;
            int firstWidth = outerWidth;
            int restWidth = outerWidth;

            LineHeightSpan[] chooseHt = null;

            if (spanned != null) {
                LeadingMarginSpan[] sp = getParagraphSpans(spanned, paraStart, paraEnd,
                        LeadingMarginSpan.class);
                for (int i = 0; i < sp.length; i++) {
                    LeadingMarginSpan lms = sp[i];
                    firstWidth -= sp[i].getLeadingMargin(true);
                    restWidth -= sp[i].getLeadingMargin(false);

                    // LeadingMarginSpan2 is odd.  The count affects all
                    // leading margin spans, not just this particular one,
                    // and start from the top of the span, not the top of the
                    // paragraph.
                    if (lms instanceof LeadingMarginSpan2) {
                        LeadingMarginSpan2 lms2 = (LeadingMarginSpan2) lms;
                        int lmsFirstLine = getLineForOffset(spanned.getSpanStart(lms2));
                        firstWidthLineLimit = lmsFirstLine + lms2.getLeadingMarginLineCount();
                    }
                }

                chooseHt = getParagraphSpans(spanned, paraStart, paraEnd, LineHeightSpan.class);

                if (chooseHt.length != 0) {
                    if (chooseHtv == null ||
                        chooseHtv.length < chooseHt.length) {
                        chooseHtv = new int[ArrayUtils.idealIntArraySize(
                                            chooseHt.length)];
                    }

                    for (int i = 0; i < chooseHt.length; i++) {
                        int o = spanned.getSpanStart(chooseHt[i]);

                        if (o < paraStart) {
                            // starts in this layout, before the
                            // current paragraph

                            chooseHtv[i] = getLineTop(getLineForOffset(o));
                        } else {
                            // starts in this paragraph

                            chooseHtv[i] = v;
                        }
                    }
                }
            }

            measured.setPara(source, paraStart, paraEnd, textDir);
            char[] chs = measured.mChars;
            float[] widths = measured.mWidths;
            byte[] chdirs = measured.mLevels;
            int dir = measured.mDir;
            boolean easy = measured.mEasy;

            int width = firstWidth;

            float w = 0;
            int here = paraStart;

            int ok = paraStart;
            float okWidth = w;
            int okAscent = 0, okDescent = 0, okTop = 0, okBottom = 0;

            int fit = paraStart;
            float fitWidth = w;
            int fitAscent = 0, fitDescent = 0, fitTop = 0, fitBottom = 0;

            boolean hasTabOrEmoji = false;
            boolean hasTab = false;
            TabStops tabStops = null;

            for (int spanStart = paraStart, spanEnd = spanStart, nextSpanStart;
                    spanStart < paraEnd; spanStart = nextSpanStart) {

                if (spanStart == spanEnd) {
                    if (spanned == null)
                        spanEnd = paraEnd;
                    else
                        spanEnd = spanned.nextSpanTransition(spanStart, paraEnd,
                                MetricAffectingSpan.class);

                    int spanLen = spanEnd - spanStart;
                    if (spanned == null) {
                        measured.addStyleRun(paint, spanLen, fm);
                    } else {
                        MetricAffectingSpan[] spans =
                            spanned.getSpans(spanStart, spanEnd, MetricAffectingSpan.class);
                        spans = TextUtils.removeEmptySpans(spans, spanned,
                                MetricAffectingSpan.class);
                        measured.addStyleRun(paint, spans, spanLen, fm);
                    }
                }

                nextSpanStart = spanEnd;

                int fmTop = fm.top;
                int fmBottom = fm.bottom;
                int fmAscent = fm.ascent;
                int fmDescent = fm.descent;

                for (int j = spanStart; j < spanEnd; j++) {
                    char c = chs[j - paraStart];

                    if (c == CHAR_NEW_LINE) {
                        // intentionally left empty
                    } else if (c == CHAR_TAB) {
                        if (hasTab == false) {
                            hasTab = true;
                            hasTabOrEmoji = true;
                            if (spanned != null) {
                                // First tab this para, check for tabstops
                                TabStopSpan[] spans = getParagraphSpans(spanned, paraStart,
                                        paraEnd, TabStopSpan.class);
                                if (spans.length > 0) {
                                    tabStops = new TabStops(TAB_INCREMENT, spans);
                                }
                            }
                        }
                        if (tabStops != null) {
                            w = tabStops.nextTab(w);
                        } else {
                            w = TabStops.nextDefaultStop(w, TAB_INCREMENT);
                        }
                    } else if (c >= CHAR_FIRST_HIGH_SURROGATE && c <= CHAR_LAST_LOW_SURROGATE
                            && j + 1 < spanEnd) {
                        int emoji = Character.codePointAt(chs, j - paraStart);

                        if (emoji >= MIN_EMOJI && emoji <= MAX_EMOJI) {
                            Bitmap bm = EMOJI_FACTORY.getBitmapFromAndroidPua(emoji);

                            if (bm != null) {
                                Paint whichPaint;

                                if (spanned == null) {
                                    whichPaint = paint;
                                } else {
                                    whichPaint = mWorkPaint;
                                }

                                float wid = bm.getWidth() * -whichPaint.ascent() / bm.getHeight();

                                w += wid;
                                hasTabOrEmoji = true;
                                j++;
                            } else {
                                w += widths[j - paraStart];
                            }
                        } else {
                            w += widths[j - paraStart];
                        }
                    } else {
                        w += widths[j - paraStart];
                    }

                    // Log.e("text", "was " + before + " now " + w + " after " + c + " within " + width);

                    if (w <= width) {
                        fitWidth = w;
                        fit = j + 1;

                        if (fmTop < fitTop)
                            fitTop = fmTop;
                        if (fmAscent < fitAscent)
                            fitAscent = fmAscent;
                        if (fmDescent > fitDescent)
                            fitDescent = fmDescent;
                        if (fmBottom > fitBottom)
                            fitBottom = fmBottom;

                        /*
                         * From the Unicode Line Breaking Algorithm:
                         * (at least approximately)
                         *
                         * .,:; are class IS: breakpoints
                         *      except when adjacent to digits
                         * /    is class SY: a breakpoint
                         *      except when followed by a digit.
                         * -    is class HY: a breakpoint
                         *      except when followed by a digit.
                         *
                         * Ideographs are class ID: breakpoints when adjacent,
                         * except for NS (non-starters), which can be broken
                         * after but not before.
                         */

                        if (c == CHAR_SPACE || c == CHAR_TAB ||
                            ((c == CHAR_DOT || c == CHAR_COMMA ||
                                    c == CHAR_COLON || c == CHAR_SEMICOLON) &&
                             (j - 1 < here || !Character.isDigit(chs[j - 1 - paraStart])) &&
                             (j + 1 >= spanEnd || !Character.isDigit(chs[j + 1 - paraStart]))) ||
                            ((c == CHAR_SLASH || c == CHAR_HYPHEN) &&
                             (j + 1 >= spanEnd || !Character.isDigit(chs[j + 1 - paraStart]))) ||
                            (c >= CHAR_FIRST_CJK && isIdeographic(c, true) &&
                             j + 1 < spanEnd && isIdeographic(chs[j + 1 - paraStart], false))) {
                            okWidth = w;
                            ok = j + 1;

                            if (fitTop < okTop)
                                okTop = fitTop;
                            if (fitAscent < okAscent)
                                okAscent = fitAscent;
                            if (fitDescent > okDescent)
                                okDescent = fitDescent;
                            if (fitBottom > okBottom)
                                okBottom = fitBottom;
                        }
                    } else {
                        final boolean moreChars = (j + 1 < spanEnd);
                        int endPos;
                        int above, below, top, bottom;
                        float currentTextWidth;

                        if (ok != here) {
                            // If it is a space that makes the length exceed width, cut here
                            if (c == CHAR_SPACE) ok = j + 1;

                            while (ok < spanEnd && chs[ok - paraStart] == CHAR_SPACE) {
                                ok++;
                            }

                            endPos = ok;
                            above = okAscent;
                            below = okDescent;
                            top = okTop;
                            bottom = okBottom;
                            currentTextWidth = okWidth;
                        } else if (fit != here) {
                            endPos = fit;
                            above = fitAscent;
                            below = fitDescent;
                            top = fitTop;
                            bottom = fitBottom;
                            currentTextWidth = fitWidth;
                        } else {
                            endPos = here + 1;
                            above = fm.ascent;
                            below = fm.descent;
                            top = fm.top;
                            bottom = fm.bottom;
                            currentTextWidth = widths[here - paraStart];
                        }

                        v = out(source, here, endPos,
                                above, below, top, bottom,
                                v, spacingmult, spacingadd, chooseHt,chooseHtv, fm, hasTabOrEmoji,
                                needMultiply, chdirs, dir, easy, bufEnd, includepad, trackpad,
                                chs, widths, paraStart, ellipsize, ellipsizedWidth,
                                currentTextWidth, paint, moreChars);
                        here = endPos;

                        if (here < spanStart) {
                            // didn't output all the text for this span
                            // we've measured the raw widths, though, so
                            // just reset the start point
                            j = nextSpanStart = here;
                        } else {
                            j = here - 1;    // continue looping
                        }

                        ok = fit = here;
                        w = 0;
                        fitAscent = fitDescent = fitTop = fitBottom = 0;
                        okAscent = okDescent = okTop = okBottom = 0;

                        if (--firstWidthLineLimit <= 0) {
                            width = restWidth;
                        }
                    }
                    if (mLineCount >= mMaximumVisibleLineCount) {
                        break;
                    }
                }
            }

            if (paraEnd != here && mLineCount < mMaximumVisibleLineCount) {
                if ((fitTop | fitBottom | fitDescent | fitAscent) == 0) {
                    paint.getFontMetricsInt(fm);

                    fitTop = fm.top;
                    fitBottom = fm.bottom;
                    fitAscent = fm.ascent;
                    fitDescent = fm.descent;
                }

                // Log.e("text", "output rest " + here + " to " + end);

                v = out(source,
                        here, paraEnd, fitAscent, fitDescent,
                        fitTop, fitBottom,
                        v,
                        spacingmult, spacingadd, chooseHt,
                        chooseHtv, fm, hasTabOrEmoji,
                        needMultiply, chdirs, dir, easy, bufEnd,
                        includepad, trackpad, chs,
                        widths, paraStart, ellipsize,
                        ellipsizedWidth, w, paint, paraEnd != bufEnd);
            }

            paraStart = paraEnd;

            if (paraEnd == bufEnd)
                break;
        }

        if ((bufEnd == bufStart || source.charAt(bufEnd - 1) == CHAR_NEW_LINE) &&
                mLineCount < mMaximumVisibleLineCount) {
            // Log.e("text", "output last " + bufEnd);

            paint.getFontMetricsInt(fm);

            v = out(source,
                    bufEnd, bufEnd, fm.ascent, fm.descent,
                    fm.top, fm.bottom,
                    v,
                    spacingmult, spacingadd, null,
                    null, fm, false,
                    needMultiply, null, DEFAULT_DIR, true, bufEnd,
                    includepad, trackpad, null,
                    null, bufStart, ellipsize,
                    ellipsizedWidth, 0, paint, false);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.924 -0500", hash_original_method = "478F3FA593939ABCBF542030DE605E96", hash_generated_method = "B4119DA4B551725EBFF9C5E7633AB0B0")
    
private int out(CharSequence text, int start, int end,
                      int above, int below, int top, int bottom, int v,
                      float spacingmult, float spacingadd,
                      LineHeightSpan[] chooseHt, int[] chooseHtv,
                      Paint.FontMetricsInt fm, boolean hasTabOrEmoji,
                      boolean needMultiply, byte[] chdirs, int dir,
                      boolean easy, int bufEnd, boolean includePad,
                      boolean trackPad, char[] chs,
                      float[] widths, int widthStart, TextUtils.TruncateAt ellipsize,
                      float ellipsisWidth, float textWidth,
                      TextPaint paint, boolean moreChars) {
        int j = mLineCount;
        int off = j * mColumns;
        int want = off + mColumns + TOP;
        int[] lines = mLines;

        if (want >= lines.length) {
            int nlen = ArrayUtils.idealIntArraySize(want + 1);
            int[] grow = new int[nlen];
            System.arraycopy(lines, 0, grow, 0, lines.length);
            mLines = grow;
            lines = grow;

            Directions[] grow2 = new Directions[nlen];
            System.arraycopy(mLineDirections, 0, grow2, 0,
                             mLineDirections.length);
            mLineDirections = grow2;
        }

        if (chooseHt != null) {
            fm.ascent = above;
            fm.descent = below;
            fm.top = top;
            fm.bottom = bottom;

            for (int i = 0; i < chooseHt.length; i++) {
                if (chooseHt[i] instanceof LineHeightSpan.WithDensity) {
                    ((LineHeightSpan.WithDensity) chooseHt[i]).
                        chooseHeight(text, start, end, chooseHtv[i], v, fm, paint);

                } else {
                    chooseHt[i].chooseHeight(text, start, end, chooseHtv[i], v, fm);
                }
            }

            above = fm.ascent;
            below = fm.descent;
            top = fm.top;
            bottom = fm.bottom;
        }

        if (j == 0) {
            if (trackPad) {
                mTopPadding = top - above;
            }

            if (includePad) {
                above = top;
            }
        }
        if (end == bufEnd) {
            if (trackPad) {
                mBottomPadding = bottom - below;
            }

            if (includePad) {
                below = bottom;
            }
        }

        int extra;

        if (needMultiply) {
            double ex = (below - above) * (spacingmult - 1) + spacingadd;
            if (ex >= 0) {
                extra = (int)(ex + EXTRA_ROUNDING);
            } else {
                extra = -(int)(-ex + EXTRA_ROUNDING);
            }
        } else {
            extra = 0;
        }

        lines[off + START] = start;
        lines[off + TOP] = v;
        lines[off + DESCENT] = below + extra;

        v += (below - above) + extra;
        lines[off + mColumns + START] = end;
        lines[off + mColumns + TOP] = v;

        if (hasTabOrEmoji)
            lines[off + TAB] |= TAB_MASK;

        lines[off + DIR] |= dir << DIR_SHIFT;
        Directions linedirs = DIRS_ALL_LEFT_TO_RIGHT;
        // easy means all chars < the first RTL, so no emoji, no nothing
        // XXX a run with no text or all spaces is easy but might be an empty
        // RTL paragraph.  Make sure easy is false if this is the case.
        if (easy) {
            mLineDirections[j] = linedirs;
        } else {
            mLineDirections[j] = AndroidBidi.directions(dir, chdirs, start - widthStart, chs,
                    start - widthStart, end - start);
        }

        if (ellipsize != null) {
            // If there is only one line, then do any type of ellipsis except when it is MARQUEE
            // if there are multiple lines, just allow END ellipsis on the last line
            boolean firstLine = (j == 0);
            boolean currentLineIsTheLastVisibleOne = (j + 1 == mMaximumVisibleLineCount);
            boolean forceEllipsis = moreChars && (mLineCount + 1 == mMaximumVisibleLineCount);

            boolean doEllipsis = (firstLine && !moreChars &&
                                ellipsize != TextUtils.TruncateAt.MARQUEE) ||
                        (!firstLine && (currentLineIsTheLastVisibleOne || !moreChars) &&
                                ellipsize == TextUtils.TruncateAt.END);
            if (doEllipsis) {
                calculateEllipsis(start, end, widths, widthStart,
                        ellipsisWidth, ellipsize, j,
                        textWidth, paint, forceEllipsis);
            }
        }

        mLineCount++;
        return v;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.929 -0500", hash_original_method = "12884526F2C70C1C98137C0940B4D04E", hash_generated_method = "594C1CA6F565EC5294E61320588CB5B5")
    
private void calculateEllipsis(int lineStart, int lineEnd,
                                   float[] widths, int widthStart,
                                   float avail, TextUtils.TruncateAt where,
                                   int line, float textWidth, TextPaint paint,
                                   boolean forceEllipsis) {
        if (textWidth <= avail && !forceEllipsis) {
            // Everything fits!
            mLines[mColumns * line + ELLIPSIS_START] = 0;
            mLines[mColumns * line + ELLIPSIS_COUNT] = 0;
            return;
        }

        float ellipsisWidth = paint.measureText(
                (where == TextUtils.TruncateAt.END_SMALL) ? ELLIPSIS_TWO_DOTS : ELLIPSIS_NORMAL);
        int ellipsisStart = 0;
        int ellipsisCount = 0;
        int len = lineEnd - lineStart;

        // We only support start ellipsis on a single line
        if (where == TextUtils.TruncateAt.START) {
            if (mMaximumVisibleLineCount == 1) {
                float sum = 0;
                int i;

                for (i = len; i >= 0; i--) {
                    float w = widths[i - 1 + lineStart - widthStart];

                    if (w + sum + ellipsisWidth > avail) {
                        break;
                    }

                    sum += w;
                }

                ellipsisStart = 0;
                ellipsisCount = i;
            } else {
                if (Log.isLoggable(TAG, Log.WARN)) {
                    Log.w(TAG, "Start Ellipsis only supported with one line");
                }
            }
        } else if (where == TextUtils.TruncateAt.END || where == TextUtils.TruncateAt.MARQUEE ||
                where == TextUtils.TruncateAt.END_SMALL) {
            float sum = 0;
            int i;

            for (i = 0; i < len; i++) {
                float w = widths[i + lineStart - widthStart];

                if (w + sum + ellipsisWidth > avail) {
                    break;
                }

                sum += w;
            }

            ellipsisStart = i;
            ellipsisCount = len - i;
            if (forceEllipsis && ellipsisCount == 0 && len > 0) {
                ellipsisStart = len - 1;
                ellipsisCount = 1;
            }
        } else {
            // where = TextUtils.TruncateAt.MIDDLE We only support middle ellipsis on a single line
            if (mMaximumVisibleLineCount == 1) {
                float lsum = 0, rsum = 0;
                int left = 0, right = len;

                float ravail = (avail - ellipsisWidth) / 2;
                for (right = len; right >= 0; right--) {
                    float w = widths[right - 1 + lineStart - widthStart];

                    if (w + rsum > ravail) {
                        break;
                    }

                    rsum += w;
                }

                float lavail = avail - ellipsisWidth - rsum;
                for (left = 0; left < right; left++) {
                    float w = widths[left + lineStart - widthStart];

                    if (w + lsum > lavail) {
                        break;
                    }

                    lsum += w;
                }

                ellipsisStart = left;
                ellipsisCount = right - left;
            } else {
                if (Log.isLoggable(TAG, Log.WARN)) {
                    Log.w(TAG, "Middle Ellipsis only supported with one line");
                }
            }
        }

        mLines[mColumns * line + ELLIPSIS_START] = ellipsisStart;
        mLines[mColumns * line + ELLIPSIS_COUNT] = ellipsisCount;
    }

    // Override the base class so we can directly access our members,
    // rather than relying on member functions.
    // The logic mirrors that of Layout.getLineForVertical
    // FIXME: It may be faster to do a linear search for layouts without many lines.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.932 -0500", hash_original_method = "98509D881029C8DC6B023EB0DACF92F5", hash_generated_method = "F53DBA913D61B49EA41F8004ED6B9F9E")
    
@Override
    public int getLineForVertical(int vertical) {
        int high = mLineCount;
        int low = -1;
        int guess;
        int[] lines = mLines;
        while (high - low > 1) {
            guess = (high + low) >> 1;
            if (lines[mColumns * guess + TOP] > vertical){
                high = guess;
            } else {
                low = guess;
            }
        }
        if (low < 0) {
            return 0;
        } else {
            return low;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.935 -0500", hash_original_method = "DCA25DE9CB635243C23A0D258AEAA6C9", hash_generated_method = "DBF99941AFD07ECE9EB20238F6647D01")
    
@Override
    public int getLineCount() {
        return mLineCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.938 -0500", hash_original_method = "79A8E86A0E5ABFEF4F09B2D188FA97FB", hash_generated_method = "DF1712773706137859E0420F519F2A9E")
    
@Override
    public int getLineTop(int line) {
        int top = mLines[mColumns * line + TOP];
        if (mMaximumVisibleLineCount > 0 && line >= mMaximumVisibleLineCount &&
                line != mLineCount) {
            top += getBottomPadding();
        }
        return top;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.941 -0500", hash_original_method = "24456204DB122ABBCF95E31F6A475D1C", hash_generated_method = "D2DE19322D73F71BFD300DDCAFD0E6A7")
    
@Override
    public int getLineDescent(int line) {
        int descent = mLines[mColumns * line + DESCENT];
        if (mMaximumVisibleLineCount > 0 && line >= mMaximumVisibleLineCount - 1 && // -1 intended
                line != mLineCount) {
            descent += getBottomPadding();
        }
        return descent;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.944 -0500", hash_original_method = "839417F6B69B5423927C3B8DBF7A6F42", hash_generated_method = "1C7DBDDD96CC77377476DDC277ED0356")
    
@Override
    public int getLineStart(int line) {
        return mLines[mColumns * line + START] & START_MASK;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.949 -0500", hash_original_method = "4D44D66A6DA9E0A8739F807A61ABAF65", hash_generated_method = "078A7B8655668116004C7595BE8496CA")
    
@Override
    public int getParagraphDirection(int line) {
        return mLines[mColumns * line + DIR] >> DIR_SHIFT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.952 -0500", hash_original_method = "F549BE615B108927B3399A138AFD2460", hash_generated_method = "70A5E4009C70DDE786164BB876ECE36B")
    
@Override
    public boolean getLineContainsTab(int line) {
        return (mLines[mColumns * line + TAB] & TAB_MASK) != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.955 -0500", hash_original_method = "E4C2D852DF30293005E76B99E82745CD", hash_generated_method = "2CC0F0ED1C506540B8529CB0F3D54823")
    
@Override
    public final Directions getLineDirections(int line) {
        return mLineDirections[line];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.957 -0500", hash_original_method = "0410F05B3F48387C42DB277B8067D4A9", hash_generated_method = "C9A37F9D7E53BC032BE1989D8B7F43F3")
    
@Override
    public int getTopPadding() {
        return mTopPadding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.960 -0500", hash_original_method = "A7597317BC8A3102F80AD4E9AD038652", hash_generated_method = "F0B9D53486F44C4D9B5E36E2D1B1C62A")
    
@Override
    public int getBottomPadding() {
        return mBottomPadding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.963 -0500", hash_original_method = "7EEFC0E209C4C423B00930C7C3F48104", hash_generated_method = "C1E3F9252BF0D28F0902B9B7D4DBD456")
    
@Override
    public int getEllipsisCount(int line) {
        if (mColumns < COLUMNS_ELLIPSIZE) {
            return 0;
        }

        return mLines[mColumns * line + ELLIPSIS_COUNT];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.966 -0500", hash_original_method = "3E84E442932041329DEDBD7573FAD5F7", hash_generated_method = "4D0CF81887F135F77C51603EC4C179F2")
    
@Override
    public int getEllipsisStart(int line) {
        if (mColumns < COLUMNS_ELLIPSIZE) {
            return 0;
        }

        return mLines[mColumns * line + ELLIPSIS_START];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.969 -0500", hash_original_method = "5CA9F8625BABB74DD57E485BAAAC3103", hash_generated_method = "466A36682DB1C1AD0B2234723777A380")
    
@Override
    public int getEllipsizedWidth() {
        return mEllipsizedWidth;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.971 -0500", hash_original_method = "B52C8C631677053C363ACE90856C8484", hash_generated_method = "B52C8C631677053C363ACE90856C8484")
    
void prepare() {
        mMeasured = MeasuredText.obtain();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:20.973 -0500", hash_original_method = "C0F6C3CAFEEBD4E75E81773515CBCC0B", hash_generated_method = "C0F6C3CAFEEBD4E75E81773515CBCC0B")
    
void finish() {
        mMeasured = MeasuredText.recycle(mMeasured);
    }
}

