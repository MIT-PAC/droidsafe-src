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

import java.nio.CharBuffer;

/**
 * Some objects that implement TextDirectionHeuristic.
 *
 */
public class TextDirectionHeuristicsCompat {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:20.521 -0400", hash_original_field = "86CAF222AB5446FF80862765CEFAC2A6", hash_generated_field = "4FB91D46939AF295891229ADA3A5EA16")

    public static final android.support.v4.text.TextDirectionHeuristicCompat LTR =
            new TextDirectionHeuristicInternal(null /* no algorithm */, false);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:20.527 -0400", hash_original_field = "C33BDADAB1FD075364C77BDF83E2556E", hash_generated_field = "4A00DF9256D90890F55B09BD8F37D751")

    public static final android.support.v4.text.TextDirectionHeuristicCompat RTL =
            new TextDirectionHeuristicInternal(null /* no algorithm */, true);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:20.532 -0400", hash_original_field = "F097E02214C48A924F9D6FB1A2479995", hash_generated_field = "EF612461D50BD0BF9A005947AA468464")

    public static final android.support.v4.text.TextDirectionHeuristicCompat FIRSTSTRONG_LTR =
            new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, false);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:20.537 -0400", hash_original_field = "31829F2D5DA21A62F2360A8465ABBA7B", hash_generated_field = "CA781BEEFE462336CDD2E6D70C2CB1EC")

    public static final android.support.v4.text.TextDirectionHeuristicCompat FIRSTSTRONG_RTL =
            new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, true);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:20.542 -0400", hash_original_field = "E8A5D810EDD727F2D8CAF613F58E8112", hash_generated_field = "3432687F14926BC57593E5EDABE111B6")

    public static final android.support.v4.text.TextDirectionHeuristicCompat ANYRTL_LTR =
            new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:20.546 -0400", hash_original_field = "134D50B39CE306808584E8D2C32EBD13", hash_generated_field = "F25FF74634D1BDAC51ADB6C782BD593C")

    public static final android.support.v4.text.TextDirectionHeuristicCompat LOCALE =
            TextDirectionHeuristicLocale.INSTANCE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:20.550 -0400", hash_original_field = "BF6180B8A86DF334FE2A933BF76A54E3", hash_generated_field = "E31D3F69289BFF51A2503C2DA8A0C7C7")

    private static final int STATE_TRUE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:20.555 -0400", hash_original_field = "0F35957DB4DCF1CAF4D2C8D707A4E66C", hash_generated_field = "AB4D64FC0990DEAF81093633F7772443")

    private static final int STATE_FALSE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:20.559 -0400", hash_original_field = "EDE2C6E5A9A059F95BE8BA0C8E35274E", hash_generated_field = "F2BD34F1C2C4208626C554E240ECAA6C")

    private static final int STATE_UNKNOWN = 2;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:20.563 -0400", hash_original_method = "821E392DB1CF71B190514BB1D9F6B09D", hash_generated_method = "EF0ADF1CABEC1B95BE9EC94A6E546B68")
    
private static int isRtlText(int directionality) {
        switch (directionality) {
            case Character.DIRECTIONALITY_LEFT_TO_RIGHT:
                return STATE_FALSE;
            case Character.DIRECTIONALITY_RIGHT_TO_LEFT:
            case Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC:
                return STATE_TRUE;
            default:
                return STATE_UNKNOWN;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:20.568 -0400", hash_original_method = "5160D465A86981EEFCC72C5BA2038EBF", hash_generated_method = "A51FDB60044231B5C1D95A580B93872F")
    
private static int isRtlTextOrFormat(int directionality) {
        switch (directionality) {
            case Character.DIRECTIONALITY_LEFT_TO_RIGHT:
            case Character.DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING:
            case Character.DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE:
                return STATE_FALSE;
            case Character.DIRECTIONALITY_RIGHT_TO_LEFT:
            case Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC:
            case Character.DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING:
            case Character.DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE:
                return STATE_TRUE;
            default:
                return STATE_UNKNOWN;
        }
    }

    /**
     * Computes the text direction based on an algorithm.  Subclasses implement
     * {@link #defaultIsRtl} to handle cases where the algorithm cannot determine the
     * direction from the text alone.
     */
    private static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
        private final TextDirectionAlgorithm mAlgorithm;

        public TextDirectionHeuristicImpl(TextDirectionAlgorithm algorithm) {
            mAlgorithm = algorithm;
        }

        /**
         * Return true if the default text direction is rtl.
         */
        abstract protected boolean defaultIsRtl();

        @Override
        public boolean isRtl(char[] array, int start, int count) {
            return isRtl(CharBuffer.wrap(array), start, count);
        }

        @Override
        public boolean isRtl(CharSequence cs, int start, int count) {
            if (cs == null || start < 0 || count < 0 || cs.length() - count < start) {
                throw new IllegalArgumentException();
            }
            if (mAlgorithm == null) {
                return defaultIsRtl();
            }
            return doCheck(cs, start, count);
        }

        private boolean doCheck(CharSequence cs, int start, int count) {
            switch(mAlgorithm.checkRtl(cs, start, count)) {
                case STATE_TRUE:
                    return true;
                case STATE_FALSE:
                    return false;
                default:
                    return defaultIsRtl();
            }
        }
    }

    private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
        private final boolean mDefaultIsRtl;

        private TextDirectionHeuristicInternal(TextDirectionAlgorithm algorithm,
                                               boolean defaultIsRtl) {
            super(algorithm);
            mDefaultIsRtl = defaultIsRtl;
        }

        @Override
        protected boolean defaultIsRtl() {
            return mDefaultIsRtl;
        }
    }

    /**
     * Interface for an algorithm to guess the direction of a paragraph of text.
     */
    private static interface TextDirectionAlgorithm {
        /**
         * Returns whether the range of text is RTL according to the algorithm.
         */
        int checkRtl(CharSequence cs, int start, int count);
    }

    /**
     * Algorithm that uses the first strong directional character to determine the paragraph
     * direction. This is the standard Unicode Bidirectional algorithm.
     */
    private static class FirstStrong implements TextDirectionAlgorithm {
        @Override
        public int checkRtl(CharSequence cs, int start, int count) {
            int result = STATE_UNKNOWN;
            for (int i = start, e = start + count; i < e && result == STATE_UNKNOWN; ++i) {
                result = isRtlTextOrFormat(Character.getDirectionality(cs.charAt(i)));
            }
            return result;
        }

        private FirstStrong() {
        }

        public static final FirstStrong INSTANCE = new FirstStrong();
    }

    /**
     * Algorithm that uses the presence of any strong directional non-format
     * character (e.g. excludes LRE, LRO, RLE, RLO) to determine the
     * direction of text.
     */
    private static class AnyStrong implements TextDirectionAlgorithm {
        private final boolean mLookForRtl;

        @Override
        public int checkRtl(CharSequence cs, int start, int count) {
            boolean haveUnlookedFor = false;
            for (int i = start, e = start + count; i < e; ++i) {
                switch (isRtlText(Character.getDirectionality(cs.charAt(i)))) {
                    case STATE_TRUE:
                        if (mLookForRtl) {
                            return STATE_TRUE;
                        }
                        haveUnlookedFor = true;
                        break;
                    case STATE_FALSE:
                        if (!mLookForRtl) {
                            return STATE_FALSE;
                        }
                        haveUnlookedFor = true;
                        break;
                    default:
                        break;
                }
            }
            if (haveUnlookedFor) {
                return mLookForRtl ? STATE_FALSE : STATE_TRUE;
            }
            return STATE_UNKNOWN;
        }

        private AnyStrong(boolean lookForRtl) {
            this.mLookForRtl = lookForRtl;
        }

        public static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
        public static final AnyStrong INSTANCE_LTR = new AnyStrong(false);
    }

    /**
     * Algorithm that uses the Locale direction to force the direction of a paragraph.
     */
    private static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {

        public TextDirectionHeuristicLocale() {
            super(null);
        }

        @Override
        protected boolean defaultIsRtl() {
            final int dir = TextUtilsCompat.getLayoutDirectionFromLocale(java.util.Locale.getDefault());
            return (dir == ViewCompat.LAYOUT_DIRECTION_RTL);
        }

        public static final TextDirectionHeuristicLocale INSTANCE =
                new TextDirectionHeuristicLocale();
    }
}
