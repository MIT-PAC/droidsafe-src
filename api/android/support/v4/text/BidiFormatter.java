/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.support.v4.text;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.support.v4.view.ViewCompat;

import java.util.Locale;

import static android.support.v4.text.TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;

/**
 * Utility class for formatting text for display in a potentially opposite-directionality context
 * without garbling. The directionality of the context is set at formatter creation and the
 * directionality of the text can be either estimated or passed in when known. Provides the
 * following functionality:
 * <p>
 * 1. Bidi Wrapping
 * When text in one language is mixed into a document in another, opposite-directionality language,
 * e.g. when an English business name is embedded in a Hebrew web page, both the inserted string
 * and the text surrounding it may be displayed incorrectly unless the inserted string is explicitly
 * separated from the surrounding text in a "wrapper" that:
 * <p>
 * - Declares its directionality so that the string is displayed correctly. This can be done in
 *   Unicode bidi formatting codes by {@link #unicodeWrap} and similar methods.
 * <p>
 * - Isolates the string's directionality, so it does not unduly affect the surrounding content.
 *   Currently, this can only be done using invisible Unicode characters of the same direction as
 *   the context (LRM or RLM) in addition to the directionality declaration above, thus "resetting"
 *   the directionality to that of the context. The "reset" may need to be done at both ends of the
 *   string. Without "reset" after the string, the string will "stick" to a number or logically
 *   separate opposite-direction text that happens to follow it in-line (even if separated by
 *   neutral content like spaces and punctuation). Without "reset" before the string, the same can
 *   happen there, but only with more opposite-direction text, not a number. One approach is to
 *   "reset" the direction only after each string, on the theory that if the preceding opposite-
 *   direction text is itself bidi-wrapped, the "reset" after it will prevent the sticking. (Doing
 *   the "reset" only before each string definitely does not work because we do not want to require
 *   bidi-wrapping numbers, and a bidi-wrapped opposite-direction string could be followed by a
 *   number.) Still, the safest policy is to do the "reset" on both ends of each string, since RTL
 *   message translations often contain untranslated Latin-script brand names and technical terms,
 *   and one of these can be followed by a bidi-wrapped inserted value. On the other hand, when one
 *   has such a message, it is best to do the "reset" manually in the message translation itself,
 *   since the message's opposite-direction text could be followed by an inserted number, which we
 *   would not bidi-wrap anyway. Thus, "reset" only after the string is the current default. In an
 *   alternative to "reset", recent additions to the HTML, CSS, and Unicode standards allow the
 *   isolation to be part of the directionality declaration. This form of isolation is better than
 *   "reset" because it takes less space, does not require knowing the context directionality, has a
 *   gentler effect than "reset", and protects both ends of the string. However, we do not yet allow
 *   using it because required platforms do not yet support it.
 * <p>
 * Providing these wrapping services is the basic purpose of the bidi formatter.
 * <p>
 * 2. Directionality estimation
 * How does one know whether a string about to be inserted into surrounding text has the same
 * directionality? Well, in many cases, one knows that this must be the case when writing the code
 * doing the insertion, e.g. when a localized message is inserted into a localized page. In such
 * cases there is no need to involve the bidi formatter at all. In some other cases, it need not be
 * the same as the context, but is either constant (e.g. urls are always LTR) or otherwise known.
 * In the remaining cases, e.g. when the string is user-entered or comes from a database, the
 * language of the string (and thus its directionality) is not known a priori, and must be
 * estimated at run-time. The bidi formatter can do this automatically using the default
 * first-strong estimation algorithm. It can also be configured to use a custom directionality
 * estimation object.
 */
public final class BidiFormatter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.544 -0400", hash_original_field = "66D386185A8400F2A6BF7A21C7F3AA03", hash_generated_field = "DD1B5F12936F8BEA0A28039CD235AC10")

    private static TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = FIRSTSTRONG_LTR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.554 -0400", hash_original_field = "AB06D16D6D40E37830F139C3660AE7DA", hash_generated_field = "36CDFA318E6865D6874E95A8A41B37B4")

    private static final char LRE = '\u202A';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.563 -0400", hash_original_field = "C8E62D3F97A56CBA151F43EBF71B296E", hash_generated_field = "BC23DAF1747446DD63C1CF457D12ABDE")

    private static final char RLE = '\u202B';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.569 -0400", hash_original_field = "21FBF449D9C1502318EABFC5043CBEC8", hash_generated_field = "890094753720AD702225AE9F56BC5A47")

    private static final char PDF = '\u202C';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.575 -0400", hash_original_field = "EA8D08139A7119D2B2D08AF695BC323D", hash_generated_field = "E6C060B63BE48432047162B841C09471")

    private static final char LRM = '\u200E';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.580 -0400", hash_original_field = "8130A3F0319529ECD4A86FF2AC7C7C0B", hash_generated_field = "52F3D8AEEA8A0C083DBFA37397E9D056")

    private static final char RLM = '\u200F';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.589 -0400", hash_original_field = "449C80081CB9044DE1DF1C6D1F32BE78", hash_generated_field = "8FA0022EACB143CE58A256B961D46E98")

    private static final String LRM_STRING = Character.toString(LRM);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.595 -0400", hash_original_field = "CC9824B75BCD1FA0013649B2E0D468E2", hash_generated_field = "2726033F3FDA1B6783DF738FD003F6EE")

    private static final String RLM_STRING = Character.toString(RLM);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.600 -0400", hash_original_field = "7CB8BFC01FCDF4A2C23FAAA68C344752", hash_generated_field = "D14895E2C9628BA7CEA3A352030E9445")

    private static final String EMPTY_STRING = "";

    /**
     * A class for building a BidiFormatter with non-default options.
     */
    public static final class Builder {
        private boolean mIsRtlContext;
        private int mFlags;
        private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

        /**
         * Constructor.
         *
         */
        public Builder() {
            initialize(isRtlLocale(Locale.getDefault()));
        }

        /**
         * Constructor.
         *
         * @param rtlContext Whether the context directionality is RTL.
         */
        public Builder(boolean rtlContext) {
            initialize(rtlContext);
        }

        /**
         * Constructor.
         *
         * @param locale The context locale.
         */
        public Builder(Locale locale) {
            initialize(isRtlLocale(locale));
        }

        /**
         * Initializes the builder with the given context directionality and default options.
         *
         * @param isRtlContext Whether the context is RTL or not.
         */
        private void initialize(boolean isRtlContext) {
            mIsRtlContext = isRtlContext;
            mTextDirectionHeuristicCompat = DEFAULT_TEXT_DIRECTION_HEURISTIC;
            mFlags = DEFAULT_FLAGS;
        }

        /**
         * Specifies whether the BidiFormatter to be built should also "reset" directionality before
         * a string being bidi-wrapped, not just after it. The default is false.
         */
        public Builder stereoReset(boolean stereoReset) {
            if (stereoReset) {
                mFlags |= FLAG_STEREO_RESET;
            } else {
                mFlags &= ~FLAG_STEREO_RESET;
            }
            return this;
        }

        /**
         * Specifies the default directionality estimation algorithm to be used by the BidiFormatter.
         * By default, uses the first-strong heuristic.
         *
         * @param heuristic the {@code TextDirectionHeuristic} to use.
         * @return the builder itself.
         */
        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat heuristic) {
            mTextDirectionHeuristicCompat = heuristic;
            return this;
        }

        private static BidiFormatter getDefaultInstanceFromContext(boolean isRtlContext) {
            return isRtlContext ? DEFAULT_RTL_INSTANCE : DEFAULT_LTR_INSTANCE;
        }

        /**
         * @return A BidiFormatter with the specified options.
         */
        public BidiFormatter build() {
            if (mFlags == DEFAULT_FLAGS &&
                    mTextDirectionHeuristicCompat == DEFAULT_TEXT_DIRECTION_HEURISTIC) {
                return getDefaultInstanceFromContext(mIsRtlContext);
            }
            return new BidiFormatter(mIsRtlContext, mFlags, mTextDirectionHeuristicCompat);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.705 -0400", hash_original_field = "BA611C4976BFC98E34DC7F1690E0FE19", hash_generated_field = "DAA8A5FB98324B4C69FA9D5D93F8A87C")

    private static final int FLAG_STEREO_RESET = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.711 -0400", hash_original_field = "9D81E47D508FBF125AF7C17F237F8988", hash_generated_field = "7C3D6327E8408BE5EFF5702B17147594")

    private static final int DEFAULT_FLAGS = FLAG_STEREO_RESET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.719 -0400", hash_original_field = "FCFD4CC022F8E3CAE7AC3DC68498E017", hash_generated_field = "D30340A8A031620D564093518B63E5AB")


    private static final BidiFormatter DEFAULT_LTR_INSTANCE = new BidiFormatter(
            false /* LTR context */,
            DEFAULT_FLAGS,
            DEFAULT_TEXT_DIRECTION_HEURISTIC);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.724 -0400", hash_original_field = "19DA72F0C33FFB18F4E4AD086EC4805C", hash_generated_field = "F1E17A539E4188A7D07BB498523389B3")


    private static final BidiFormatter DEFAULT_RTL_INSTANCE = new BidiFormatter(
            true /* RTL context */,
            DEFAULT_FLAGS,
            DEFAULT_TEXT_DIRECTION_HEURISTIC);

    /**
     * Factory for creating an instance of BidiFormatter for the default locale directionality.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.747 -0400", hash_original_method = "5461AFFD150815AF728DED094D78E2B6", hash_generated_method = "1C02B533B28411C185E1196B2D2838E2")
    
public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    /**
     * Factory for creating an instance of BidiFormatter given the context directionality.
     *
     * @param rtlContext Whether the context directionality is RTL.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.753 -0400", hash_original_method = "F84EBB1261A2D8142C4EB811B45DF9C0", hash_generated_method = "A9B3B08ECA708B133C37011F5EA4012F")
    
public static BidiFormatter getInstance(boolean rtlContext) {
        return new Builder(rtlContext).build();
    }

    /**
     * Factory for creating an instance of BidiFormatter given the context locale.
     *
     * @param locale The context locale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.759 -0400", hash_original_method = "B17E679214707129F3BDDF83B974E579", hash_generated_method = "502A522A6A6405E93F55A17D5956B366")
    
public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    /**
     * Helper method to return true if the Locale directionality is RTL.
     *
     * @param locale The Locale whose directionality will be checked to be RTL or LTR
     * @return true if the {@code locale} directionality is RTL. False otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.816 -0400", hash_original_method = "84A0E8AB3674727DEC6722E50692F22C", hash_generated_method = "EFF2B3198CFE3536C07C2D7B7E8EDFD5")
    
private static boolean isRtlLocale(Locale locale) {
        return (TextUtilsCompat.getLayoutDirectionFromLocale(locale) == ViewCompat.LAYOUT_DIRECTION_RTL);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.822 -0400", hash_original_field = "3C63499DFDB0E8CD890169F25B14C483", hash_generated_field = "C011717E777B148102221A7BA8E7067F")

    private static final int DIR_LTR = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.826 -0400", hash_original_field = "08B1386EACE7BD278797D2E4CD326A15", hash_generated_field = "ABF83A89F43BB1678982439B0D407B5A")

    private static final int DIR_UNKNOWN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.830 -0400", hash_original_field = "E5BC16DB20403D12F965FDE8AA90975E", hash_generated_field = "515C07931DBB53D891524481E0DC61FF")

    private static final int DIR_RTL = +1;

    /**
     * Returns the directionality of the last character with strong directionality in the string, or
     * DIR_UNKNOWN if none was encountered. For efficiency, actually scans backwards from the end of
     * the string. Treats a non-BN character between an LRE/RLE/LRO/RLO and its matching PDF as a
     * strong character, LTR after LRE/LRO, and RTL after RLE/RLO. The results are undefined for a
     * string containing unbalanced LRE/RLE/LRO/RLO/PDF characters. The intended use is to check
     * whether a logically separate item that starts with a number or a character of the string's
     * exit directionality and follows this string inline (not counting any neutral characters in
     * between) would "stick" to it in an opposite-directionality context, thus being displayed in
     * an incorrect position. An LRM or RLM character (the one of the context's directionality)
     * between the two will prevent such sticking.
     *
     * @param str the string to check.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.836 -0400", hash_original_method = "A9C3B64055F6D9EFCDEFD371E36895B0", hash_generated_method = "1B8D6D53CCC6A81208F2BC69C34A1DEF")
    
private static int getExitDir(String str) {
        return new DirectionalityEstimator(str, false /* isHtml */).getExitDir();
    }

    /**
     * Returns the directionality of the first character with strong directionality in the string,
     * or DIR_UNKNOWN if none was encountered. Treats a non-BN character between an
     * LRE/RLE/LRO/RLO and its matching PDF as a strong character, LTR after LRE/LRO, and RTL after
     * RLE/RLO. The results are undefined for a string containing unbalanced LRE/RLE/LRO/RLO/PDF
     * characters. The intended use is to check whether a logically separate item that ends with a
     * character of the string's entry directionality and precedes the string inline (not counting
     * any neutral characters in between) would "stick" to it in an opposite-directionality context,
     * thus being displayed in an incorrect position. An LRM or RLM character (the one of the
     * context's directionality) between the two will prevent such sticking.
     *
     * @param str the string to check.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.843 -0400", hash_original_method = "95BF2F917E94A75622C973BCABDC8C56", hash_generated_method = "EB4F55D4EE67352A94733A92409CAD2B")
    
private static int getEntryDir(String str) {
        return new DirectionalityEstimator(str, false /* isHtml */).getEntryDir();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.730 -0400", hash_original_field = "28E7D87CD78F7C7EE1DDBC0E147804F0", hash_generated_field = "FFEA939CBF0300165F45E2F2E3486F15")


    private  boolean mIsRtlContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.736 -0400", hash_original_field = "4E5A87EA4636A8ACF68875B877F3A7B8", hash_generated_field = "43F71E9173849705E01112D0229448B4")

    private  int mFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.742 -0400", hash_original_field = "2F8EE79CB3CFEE52EB256426B17F19B8", hash_generated_field = "6E07BB109DA82B02318F7FC24BDE652B")

    private  TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;

    /**
     * @param isRtlContext Whether the context directionality is RTL or not.
     * @param flags The option flags.
     * @param heuristic The default text direction heuristic.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.765 -0400", hash_original_method = "868DCAF59EB55E5A7A4F9EA179831D93", hash_generated_method = "E030A778F40E0C2BE5B0F14E67B6A703")
    
private BidiFormatter(boolean isRtlContext, int flags, TextDirectionHeuristicCompat heuristic) {
        mIsRtlContext = isRtlContext;
        mFlags = flags;
        mDefaultTextDirectionHeuristicCompat = heuristic;
    }

    /**
     * @return Whether the context directionality is RTL
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.769 -0400", hash_original_method = "844C96DC9F3CF8880700404BFC0CA496", hash_generated_method = "CA3F0C9B97128845FC0B55E2F7571061")
    
public boolean isRtlContext() {
        return mIsRtlContext;
    }

    /**
     * @return Whether directionality "reset" should also be done before a string being
     * bidi-wrapped, not just after it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.774 -0400", hash_original_method = "C5444ED64A05E137B698AF6900A68A98", hash_generated_method = "21256D4514D07CC6FF3986BA09F027AF")
    
public boolean getStereoReset() {
        return (mFlags & FLAG_STEREO_RESET) != 0;
    }

    /**
     * Returns a Unicode bidi mark matching the context directionality (LRM or RLM) if either the
     * overall or the exit directionality of a given string is opposite to the context directionality.
     * Putting this after the string (including its directionality declaration wrapping) prevents it
     * from "sticking" to other opposite-directionality text or a number appearing after it inline
     * with only neutral content in between. Otherwise returns the empty string. While the exit
     * directionality is determined by scanning the end of the string, the overall directionality is
     * given explicitly by a heuristic to estimate the {@code str}'s directionality.
     *
     * @param str String after which the mark may need to appear.
     * @param heuristic The text direction heuristic that will be used to estimate the {@code str}'s
     *                  directionality.
     * @return LRM for RTL text in LTR context; RLM for LTR text in RTL context;
     *     else, the empty string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.780 -0400", hash_original_method = "A2D29B57AFD0F164958373A3CCDE2D3C", hash_generated_method = "4B6B6F52052AE32415C317D8BDA4E100")
    
private String markAfter(String str, TextDirectionHeuristicCompat heuristic) {
        final boolean isRtl = heuristic.isRtl(str, 0, str.length());
        // getExitDir() is called only if needed (short-circuit).
        if (!mIsRtlContext && (isRtl || getExitDir(str) == DIR_RTL)) {
            return LRM_STRING;
        }
        if (mIsRtlContext && (!isRtl || getExitDir(str) == DIR_LTR)) {
            return RLM_STRING;
        }
        return EMPTY_STRING;
    }

    /**
     * Returns a Unicode bidi mark matching the context directionality (LRM or RLM) if either the
     * overall or the entry directionality of a given string is opposite to the context
     * directionality. Putting this before the string (including its directionality declaration
     * wrapping) prevents it from "sticking" to other opposite-directionality text appearing before
     * it inline with only neutral content in between. Otherwise returns the empty string. While the
     * entry directionality is determined by scanning the beginning of the string, the overall
     * directionality is given explicitly by a heuristic to estimate the {@code str}'s directionality.
     *
     * @param str String before which the mark may need to appear.
     * @param heuristic The text direction heuristic that will be used to estimate the {@code str}'s
     *                  directionality.
     * @return LRM for RTL text in LTR context; RLM for LTR text in RTL context;
     *     else, the empty string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.785 -0400", hash_original_method = "E5011B08C4331FE64294B99E10137DB5", hash_generated_method = "7E68449E17C2BF1C1F9157DEB69B681E")
    
private String markBefore(String str, TextDirectionHeuristicCompat heuristic) {
        final boolean isRtl = heuristic.isRtl(str, 0, str.length());
        // getEntryDir() is called only if needed (short-circuit).
        if (!mIsRtlContext && (isRtl || getEntryDir(str) == DIR_RTL)) {
            return LRM_STRING;
        }
        if (mIsRtlContext && (!isRtl || getEntryDir(str) == DIR_LTR)) {
            return RLM_STRING;
        }
        return EMPTY_STRING;
    }

    /**
     * Estimates the directionality of a string using the default text direction heuristic.
     *
     * @param str String whose directionality is to be estimated.
     * @return true if {@code str}'s estimated overall directionality is RTL. Otherwise returns
     *          false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.790 -0400", hash_original_method = "08262397EECB793443234B722C227E60", hash_generated_method = "632B5CFBF061DCF547D23A601C200768")
    
public boolean isRtl(String str) {
        return mDefaultTextDirectionHeuristicCompat.isRtl(str, 0, str.length());
    }

    /**
     * Formats a string of given directionality for use in plain-text output of the context
     * directionality, so an opposite-directionality string is neither garbled nor garbles its
     * surroundings. This makes use of Unicode bidi formatting characters.
     * <p>
     * The algorithm: In case the given directionality doesn't match the context directionality, wraps
     * the string with Unicode bidi formatting characters: RLE+{@code str}+PDF for RTL text, or
     * LRE+{@code str}+PDF for LTR text.
     * <p>
     * If {@code isolate}, directionally isolates the string so that it does not garble its
     * surroundings. Currently, this is done by "resetting" the directionality after the string by
     * appending a trailing Unicode bidi mark matching the context directionality (LRM or RLM) when
     * either the overall directionality or the exit directionality of the string is opposite to that
     * of the context. If the formatter was built using {@link Builder#stereoReset(boolean)} and
     * passing "true" as an argument, also prepends a Unicode bidi mark matching the context
     * directionality when either the overall directionality or the entry directionality of the
     * string is opposite to that of the context. Note that as opposed to the overall
     * directionality, the entry and exit directionalities are determined from the string itself.
     * <p>
     * Does *not* do HTML-escaping.
     *
     * @param str The input string.
     * @param heuristic The algorithm to be used to estimate the string's overall direction.
     * @param isolate Whether to directionally isolate the string to prevent it from garbling the
     *     content around it
     * @return Input string after applying the above processing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.797 -0400", hash_original_method = "C0B1E1B530FD4993A85CD928BA0D6C34", hash_generated_method = "D4A6D89F19E35EC268C6156A40689FA5")
    
public String unicodeWrap(String str, TextDirectionHeuristicCompat heuristic, boolean isolate) {
        final boolean isRtl = heuristic.isRtl(str, 0, str.length());
        StringBuilder result = new StringBuilder();
        if (getStereoReset() && isolate) {
            result.append(markBefore(str,
                    isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != mIsRtlContext) {
            result.append(isRtl ? RLE : LRE);
            result.append(str);
            result.append(PDF);
        } else {
            result.append(str);
        }
        if (isolate) {
            result.append(markAfter(str,
                    isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return result.toString();
    }

    /**
     * Operates like {@link #unicodeWrap(String, android.support.v4.text.TextDirectionHeuristicCompat, boolean)}, but assumes
     * {@code isolate} is true.
     *
     * @param str The input string.
     * @param heuristic The algorithm to be used to estimate the string's overall direction.
     * @return Input string after applying the above processing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.802 -0400", hash_original_method = "9F55B9949C814EBEE6C7401DF013ABFD", hash_generated_method = "EFB5398C23FF6FB78CBAE550F52BDF8D")
    
public String unicodeWrap(String str, TextDirectionHeuristicCompat heuristic) {
        return unicodeWrap(str, heuristic, true /* isolate */);
    }

    /**
     * Operates like {@link #unicodeWrap(String, android.support.v4.text.TextDirectionHeuristicCompat, boolean)}, but uses the
     * formatter's default direction estimation algorithm.
     *
     * @param str The input string.
     * @param isolate Whether to directionally isolate the string to prevent it from garbling the
     *     content around it
     * @return Input string after applying the above processing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.807 -0400", hash_original_method = "2DDFDCA58A0B9F3ADB8FAF8AB51F14F5", hash_generated_method = "E7B380B6A56D8E7070409A1733350D37")
    
public String unicodeWrap(String str, boolean isolate) {
        return unicodeWrap(str, mDefaultTextDirectionHeuristicCompat, isolate);
    }

    /**
     * Operates like {@link #unicodeWrap(String, android.support.v4.text.TextDirectionHeuristicCompat, boolean)}, but uses the
     * formatter's default direction estimation algorithm and assumes {@code isolate} is true.
     *
     * @param str The input string.
     * @return Input string after applying the above processing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:19.812 -0400", hash_original_method = "04D26B1058FAD618EFDDF549D9F0D914", hash_generated_method = "7B511CC305053ED89AB6B2E9DAF3309A")
    
public String unicodeWrap(String str) {
        return unicodeWrap(str, mDefaultTextDirectionHeuristicCompat, true /* isolate */);
    }

    /**
     * An object that estimates the directionality of a given string by various methods.
     *
     */
    private static class DirectionalityEstimator {

        // Internal static variables and constants.

        /**
         * Size of the bidi character class cache. The results of the Character.getDirectionality()
         * calls on the lowest DIR_TYPE_CACHE_SIZE codepoints are kept in an array for speed.
         * The 0x700 value is designed to leave all the European and Near Eastern languages in the
         * cache. It can be reduced to 0x180, restricting the cache to the Western European
         * languages.
         */
        private static final int DIR_TYPE_CACHE_SIZE = 0x700;

        /**
         * The bidi character class cache.
         */
        private static final byte DIR_TYPE_CACHE[];

        static {
            DIR_TYPE_CACHE = new byte[DIR_TYPE_CACHE_SIZE];
            for (int i = 0; i < DIR_TYPE_CACHE_SIZE; i++) {
                DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
            }
        }

        // Internal instance variables.

        /**
         * The text to be scanned.
         */
        private final String text;

        /**
         * Whether the text to be scanned is to be treated as HTML, i.e. skipping over tags and
         * entities when looking for the next / preceding dir type.
         */
        private final boolean isHtml;

        /**
         * The length of the text in chars.
         */
        private final int length;

        /**
         * The current position in the text.
         */
        private int charIndex;

        /**
         * The char encountered by the last dirTypeForward or dirTypeBackward call. If it
         * encountered a supplementary codepoint, this contains a char that is not a valid
         * codepoint. This is ok, because this member is only used to detect some well-known ASCII
         * syntax, e.g. "http://" and the beginning of an HTML tag or entity.
         */
        private char lastChar;

        /**
         * Constructor.
         *
         * @param text The string to scan.
         * @param isHtml Whether the text to be scanned is to be treated as HTML, i.e. skipping over
         *     tags and entities.
         */
        DirectionalityEstimator(String text, boolean isHtml) {
            this.text = text;
            this.isHtml = isHtml;
            length = text.length();
        }

        /**
         * Returns the directionality of the first character with strong directionality in the
         * string, or DIR_UNKNOWN if none was encountered. Treats a non-BN character between an
         * LRE/RLE/LRO/RLO and its matching PDF as a strong character, LTR after LRE/LRO, and RTL
         * after RLE/RLO. The results are undefined for a string containing unbalanced
         * LRE/RLE/LRO/RLO/PDF characters.
         */
        int getEntryDir() {
            // The reason for this method name, as opposed to getFirstStrongDir(), is that
            // "first strong" is a commonly used description of Unicode's estimation algorithm,
            // but the two must treat formatting characters quite differently. Thus, we are staying
            // away from both "first" and "last" in these method names to avoid confusion.
            charIndex = 0;
            int embeddingLevel = 0;
            int embeddingLevelDir = DIR_UNKNOWN;
            int firstNonEmptyEmbeddingLevel = 0;
            while (charIndex < length && firstNonEmptyEmbeddingLevel == 0) {
                switch (dirTypeForward()) {
                    case Character.DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING:
                    case Character.DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE:
                        ++embeddingLevel;
                        embeddingLevelDir = DIR_LTR;
                        break;
                    case Character.DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING:
                    case Character.DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE:
                        ++embeddingLevel;
                        embeddingLevelDir = DIR_RTL;
                        break;
                    case Character.DIRECTIONALITY_POP_DIRECTIONAL_FORMAT:
                        --embeddingLevel;
                        // To restore embeddingLevelDir to its previous value, we would need a
                        // stack, which we want to avoid. Thus, at this point we do not know the
                        // current embedding's directionality.
                        embeddingLevelDir = DIR_UNKNOWN;
                        break;
                    case Character.DIRECTIONALITY_BOUNDARY_NEUTRAL:
                        break;
                    case Character.DIRECTIONALITY_LEFT_TO_RIGHT:
                        if (embeddingLevel == 0) {
                            return DIR_LTR;
                        }
                        firstNonEmptyEmbeddingLevel = embeddingLevel;
                        break;
                    case Character.DIRECTIONALITY_RIGHT_TO_LEFT:
                    case Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC:
                        if (embeddingLevel == 0) {
                            return DIR_RTL;
                        }
                        firstNonEmptyEmbeddingLevel = embeddingLevel;
                        break;
                    default:
                        firstNonEmptyEmbeddingLevel = embeddingLevel;
                        break;
                }
            }

            // We have either found a non-empty embedding or scanned the entire string finding
            // neither a non-empty embedding nor a strong character outside of an embedding.
            if (firstNonEmptyEmbeddingLevel == 0) {
                // We have not found a non-empty embedding. Thus, the string contains neither a
                // non-empty embedding nor a strong character outside of an embedding.
                return DIR_UNKNOWN;
            }

            // We have found a non-empty embedding.
            if (embeddingLevelDir != DIR_UNKNOWN) {
                // We know the directionality of the non-empty embedding.
                return embeddingLevelDir;
            }

            // We do not remember the directionality of the non-empty embedding we found. So, we go
            // backwards to find the start of the non-empty embedding and get its directionality.
            while (charIndex > 0) {
                switch (dirTypeBackward()) {
                    case Character.DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING:
                    case Character.DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE:
                        if (firstNonEmptyEmbeddingLevel == embeddingLevel) {
                            return DIR_LTR;
                        }
                        --embeddingLevel;
                        break;
                    case Character.DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING:
                    case Character.DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE:
                        if (firstNonEmptyEmbeddingLevel == embeddingLevel) {
                            return DIR_RTL;
                        }
                        --embeddingLevel;
                        break;
                    case Character.DIRECTIONALITY_POP_DIRECTIONAL_FORMAT:
                        ++embeddingLevel;
                        break;
                }
            }
            // We should never get here.
            return DIR_UNKNOWN;
        }

        /**
         * Returns the directionality of the last character with strong directionality in the
         * string, or DIR_UNKNOWN if none was encountered. For efficiency, actually scans backwards
         * from the end of the string. Treats a non-BN character between an LRE/RLE/LRO/RLO and its
         * matching PDF as a strong character, LTR after LRE/LRO, and RTL after RLE/RLO. The results
         * are undefined for a string containing unbalanced LRE/RLE/LRO/RLO/PDF characters.
         */
        int getExitDir() {
            // The reason for this method name, as opposed to getLastStrongDir(), is that "last
            // strong" sounds like the exact opposite of "first strong", which is a commonly used
            // description of Unicode's estimation algorithm (getUnicodeDir() above), but the two
            // must treat formatting characters quite differently. Thus, we are staying away from
            // both "first" and "last" in these method names to avoid confusion.
            charIndex = length;
            int embeddingLevel = 0;
            int lastNonEmptyEmbeddingLevel = 0;
            while (charIndex > 0) {
                switch (dirTypeBackward()) {
                    case Character.DIRECTIONALITY_LEFT_TO_RIGHT:
                        if (embeddingLevel == 0) {
                            return DIR_LTR;
                        }
                        if (lastNonEmptyEmbeddingLevel == 0) {
                            lastNonEmptyEmbeddingLevel = embeddingLevel;
                        }
                        break;
                    case Character.DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING:
                    case Character.DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE:
                        if (lastNonEmptyEmbeddingLevel == embeddingLevel) {
                            return DIR_LTR;
                        }
                        --embeddingLevel;
                        break;
                    case Character.DIRECTIONALITY_RIGHT_TO_LEFT:
                    case Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC:
                        if (embeddingLevel == 0) {
                            return DIR_RTL;
                        }
                        if (lastNonEmptyEmbeddingLevel == 0) {
                            lastNonEmptyEmbeddingLevel = embeddingLevel;
                        }
                        break;
                    case Character.DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING:
                    case Character.DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE:
                        if (lastNonEmptyEmbeddingLevel == embeddingLevel) {
                            return DIR_RTL;
                        }
                        --embeddingLevel;
                        break;
                    case Character.DIRECTIONALITY_POP_DIRECTIONAL_FORMAT:
                        ++embeddingLevel;
                        break;
                    case Character.DIRECTIONALITY_BOUNDARY_NEUTRAL:
                        break;
                    default:
                        if (lastNonEmptyEmbeddingLevel == 0) {
                            lastNonEmptyEmbeddingLevel = embeddingLevel;
                        }
                        break;
                }
            }
            return DIR_UNKNOWN;
        }

        // Internal methods

        /**
         * Gets the bidi character class, i.e. Character.getDirectionality(), of a given char, using
         * a cache for speed. Not designed for supplementary codepoints, whose results we do not
         * cache.
         */
        private static byte getCachedDirectionality(char c) {
            return c < DIR_TYPE_CACHE_SIZE ? DIR_TYPE_CACHE[c] : Character.getDirectionality(c);
        }

        /**
         * Returns the Character.DIRECTIONALITY_... value of the next codepoint and advances
         * charIndex. If isHtml, and the codepoint is '<' or '&', advances through the tag/entity,
         * and returns Character.DIRECTIONALITY_WHITESPACE. For an entity, it would be best to
         * figure out the actual character, and return its dirtype, but treating it as whitespace is
         * good enough for our purposes.
         *
         * @throws java.lang.IndexOutOfBoundsException if called when charIndex >= length or < 0.
         */
        byte dirTypeForward() {
            lastChar = text.charAt(charIndex);
            if (Character.isHighSurrogate(lastChar)) {
                int codePoint = Character.codePointAt(text, charIndex);
                charIndex += Character.charCount(codePoint);
                return Character.getDirectionality(codePoint);
            }
            charIndex++;
            byte dirType = getCachedDirectionality(lastChar);
            if (isHtml) {
                // Process tags and entities.
                if (lastChar == '<') {
                    dirType = skipTagForward();
                } else if (lastChar == '&') {
                    dirType = skipEntityForward();
                }
            }
            return dirType;
        }

        /**
         * Returns the Character.DIRECTIONALITY_... value of the preceding codepoint and advances
         * charIndex backwards. If isHtml, and the codepoint is the end of a complete HTML tag or
         * entity, advances over the whole tag/entity and returns
         * Character.DIRECTIONALITY_WHITESPACE. For an entity, it would be best to figure out the
         * actual character, and return its dirtype, but treating it as whitespace is good enough
         * for our purposes.
         *
         * @throws java.lang.IndexOutOfBoundsException if called when charIndex > length or <= 0.
         */
        byte dirTypeBackward() {
            lastChar = text.charAt(charIndex - 1);
            if (Character.isLowSurrogate(lastChar)) {
                int codePoint = Character.codePointBefore(text, charIndex);
                charIndex -= Character.charCount(codePoint);
                return Character.getDirectionality(codePoint);
            }
            charIndex--;
            byte dirType = getCachedDirectionality(lastChar);
            if (isHtml) {
                // Process tags and entities.
                if (lastChar == '>') {
                    dirType = skipTagBackward();
                } else if (lastChar == ';') {
                    dirType = skipEntityBackward();
                }
            }
            return dirType;
        }

        /**
         * Advances charIndex forward through an HTML tag (after the opening &lt; has already been
         * read) and returns Character.DIRECTIONALITY_WHITESPACE. If there is no matching &gt;,
         * does not change charIndex and returns Character.DIRECTIONALITY_OTHER_NEUTRALS (for the
         * &lt; that hadn't been part of a tag after all).
         */
        private byte skipTagForward() {
            int initialCharIndex = charIndex;
            while (charIndex < length) {
                lastChar = text.charAt(charIndex++);
                if (lastChar == '>') {
                    // The end of the tag.
                    return Character.DIRECTIONALITY_WHITESPACE;
                }
                if (lastChar == '"' || lastChar == '\'') {
                    // Skip over a quoted attribute value inside the tag.
                    char quote = lastChar;
                    while (charIndex < length && (lastChar = text.charAt(charIndex++)) != quote) {}
                }
            }
            // The original '<' wasn't the start of a tag after all.
            charIndex = initialCharIndex;
            lastChar = '<';
            return Character.DIRECTIONALITY_OTHER_NEUTRALS;
        }

        /**
         * Advances charIndex backward through an HTML tag (after the closing &gt; has already been
         * read) and returns Character.DIRECTIONALITY_WHITESPACE. If there is no matching &lt;, does
         * not change charIndex and returns Character.DIRECTIONALITY_OTHER_NEUTRALS (for the &gt;
         * that hadn't been part of a tag after all). Nevertheless, the running time for calling
         * skipTagBackward() in a loop remains linear in the size of the text, even for a text like
         * "&gt;&gt;&gt;&gt;", because skipTagBackward() also stops looking for a matching &lt;
         * when it encounters another &gt;.
         */
        private byte skipTagBackward() {
            int initialCharIndex = charIndex;
            while (charIndex > 0) {
                lastChar = text.charAt(--charIndex);
                if (lastChar == '<') {
                    // The start of the tag.
                    return Character.DIRECTIONALITY_WHITESPACE;
                }
                if (lastChar == '>') {
                    break;
                }
                if (lastChar == '"' || lastChar == '\'') {
                    // Skip over a quoted attribute value inside the tag.
                    char quote = lastChar;
                    while (charIndex > 0 && (lastChar = text.charAt(--charIndex)) != quote) {}
                }
            }
            // The original '>' wasn't the end of a tag after all.
            charIndex = initialCharIndex;
            lastChar = '>';
            return Character.DIRECTIONALITY_OTHER_NEUTRALS;
        }

        /**
         * Advances charIndex forward through an HTML character entity tag (after the opening
         * &amp; has already been read) and returns Character.DIRECTIONALITY_WHITESPACE. It would be
         * best to figure out the actual character and return its dirtype, but this is good enough.
         */
        private byte skipEntityForward() {
            while (charIndex < length && (lastChar = text.charAt(charIndex++)) != ';') {}
            return Character.DIRECTIONALITY_WHITESPACE;
        }

        /**
         * Advances charIndex backward through an HTML character entity tag (after the closing ;
         * has already been read) and returns Character.DIRECTIONALITY_WHITESPACE. It would be best
         * to figure out the actual character and return its dirtype, but this is good enough.
         * If there is no matching &amp;, does not change charIndex and returns
         * Character.DIRECTIONALITY_OTHER_NEUTRALS (for the ';' that did not start an entity after
         * all). Nevertheless, the running time for calling skipEntityBackward() in a loop remains
         * linear in the size of the text, even for a text like ";;;;;;;", because skipTagBackward()
         * also stops looking for a matching &amp; when it encounters another ;.
         */
        private byte skipEntityBackward() {
            int initialCharIndex = charIndex;
            while (charIndex > 0) {
                lastChar = text.charAt(--charIndex);
                if (lastChar == '&') {
                    return Character.DIRECTIONALITY_WHITESPACE;
                }
                if (lastChar == ';') {
                    break;
                }
            }
            charIndex = initialCharIndex;
            lastChar = ';';
            return Character.DIRECTIONALITY_OTHER_NEUTRALS;
        }
    }
}