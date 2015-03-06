/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2006 The Android Open Source Project
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.text.method;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.text.InputType;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

public class DigitsKeyListener extends NumberKeyListener {

    /**
     * Returns a DigitsKeyListener that accepts the digits 0 through 9.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.064 -0500", hash_original_method = "196C44AF0E4E6E9F7A5ABEBEF1B89855", hash_generated_method = "9C92B0FB155A6AF9255A3D0C67209ECD")
    
public static DigitsKeyListener getInstance() {
        return getInstance(false, false);
    }

    /**
     * Returns a DigitsKeyListener that accepts the digits 0 through 9,
     * plus the minus sign (only at the beginning) and/or decimal point
     * (only one per field) if specified.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.067 -0500", hash_original_method = "0786C44C9A5E0C02A12CFA1A471595DB", hash_generated_method = "6FCA8A80FB5020CEFEDD5BE1AA9953D2")
    
public static DigitsKeyListener getInstance(boolean sign, boolean decimal) {
        int kind = (sign ? SIGN : 0) | (decimal ? DECIMAL : 0);

        if (sInstance[kind] != null)
            return sInstance[kind];

        sInstance[kind] = new DigitsKeyListener(sign, decimal);
        return sInstance[kind];
    }

    /**
     * Returns a DigitsKeyListener that accepts only the characters
     * that appear in the specified String.  Note that not all characters
     * may be available on every keyboard.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.069 -0500", hash_original_method = "D4B3324806FC820344ACA4BE2085B64A", hash_generated_method = "CB6490F312BEAB801C2FE7B3717C0434")
    
public static DigitsKeyListener getInstance(String accepted) {
        // TODO: do we need a cache of these to avoid allocating?

        DigitsKeyListener dim = new DigitsKeyListener();

        dim.mAccepted = new char[accepted.length()];
        accepted.getChars(0, accepted.length(), dim.mAccepted, 0);

        return dim;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.045 -0500", hash_original_field = "26C819AD0AC0298FBBAF22CC065792D1", hash_generated_field = "27720FB293DC4FF4123D0C85E570BCB6")

    private static final int SIGN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.047 -0500", hash_original_field = "5B4C9F8D8182368E2B1C92E75CCDD2AD", hash_generated_field = "8E68DEC11AA5EEACCC41D4855066C73A")

    private static final int DECIMAL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.054 -0500", hash_original_field = "65AE49EFFA1AE485E43DF4AEB8BD68B0", hash_generated_field = "3BEE3624FE24902AB30D89EA40FAD665")

    private static final char[][] CHARACTERS = new char[][] {
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' },
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-' },
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.' },
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '.' },
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.079 -0500", hash_original_field = "2517427D5C179918BF3F7BDE6AE51CA4", hash_generated_field = "B8F590F34DFCDBF52CF3AEE279594740")

    private static DigitsKeyListener[] sInstance = new DigitsKeyListener[4];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.037 -0500", hash_original_field = "5949F186B38D5E325C001127867D6388", hash_generated_field = "FBD332757CDFEDE23B2BA55765028B23")

    private char[] mAccepted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.039 -0500", hash_original_field = "33DE8D655EC1903DB6F0415B9536C31D", hash_generated_field = "DF79E0DF89ACDF64D761C1782A7E912A")

    private boolean mSign;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.042 -0500", hash_original_field = "13C92E59E57A5F86D6C7653E52F112D7", hash_generated_field = "7A06359B1E28700086DF0A30BF482E7C")

    private boolean mDecimal;

    /**
     * Allocates a DigitsKeyListener that accepts the digits 0 through 9.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.057 -0500", hash_original_method = "6BE6AAF45437494799568EB9C567DA33", hash_generated_method = "DD6B2992DC02957B30A273B9FA89021E")
    
public DigitsKeyListener() {
        this(false, false);
    }

    /**
     * Allocates a DigitsKeyListener that accepts the digits 0 through 9,
     * plus the minus sign (only at the beginning) and/or decimal point
     * (only one per field) if specified.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.061 -0500", hash_original_method = "FA23D3FC8F275B4F859DA176A5851F12", hash_generated_method = "F764592FAC79A9F63D039B536E6828F9")
    
public DigitsKeyListener(boolean sign, boolean decimal) {
        mSign = sign;
        mDecimal = decimal;

        int kind = (sign ? SIGN : 0) | (decimal ? DECIMAL : 0);
        mAccepted = CHARACTERS[kind];
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.050 -0500", hash_original_method = "699568E4919BD4E82DA190E9B839182F", hash_generated_method = "BB10730938C682CF3230557C3C82F212")
    
@Override
    protected char[] getAcceptedChars() {
        return mAccepted;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.072 -0500", hash_original_method = "C58B63A603B7A45CFB1185F323DD143F", hash_generated_method = "239130D815D3C5858622EA90F9E5EE4E")
    
public int getInputType() {
        int contentType = InputType.TYPE_CLASS_NUMBER;
        if (mSign) {
            contentType |= InputType.TYPE_NUMBER_FLAG_SIGNED;
        }
        if (mDecimal) {
            contentType |= InputType.TYPE_NUMBER_FLAG_DECIMAL;
        }
        return contentType;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.076 -0500", hash_original_method = "A15A4B8B8366C48B770873BA3926F314", hash_generated_method = "D0ED06DC3DAB77C3A5A62BB90509257F")
    
@Override
    public CharSequence filter(CharSequence source, int start, int end,
                               Spanned dest, int dstart, int dend) {
        CharSequence out = super.filter(source, start, end, dest, dstart, dend);

        if (mSign == false && mDecimal == false) {
            return out;
        }

        if (out != null) {
            source = out;
            start = 0;
            end = out.length();
        }

        int sign = -1;
        int decimal = -1;
        int dlen = dest.length();

        /*
         * Find out if the existing text has '-' or '.' characters.
         */

        for (int i = 0; i < dstart; i++) {
            char c = dest.charAt(i);

            if (c == '-') {
                sign = i;
            } else if (c == '.') {
                decimal = i;
            }
        }
        for (int i = dend; i < dlen; i++) {
            char c = dest.charAt(i);

            if (c == '-') {
                return "";    // Nothing can be inserted in front of a '-'.
            } else if (c == '.') {
                decimal = i;
            }
        }

        /*
         * If it does, we must strip them out from the source.
         * In addition, '-' must be the very first character,
         * and nothing can be inserted before an existing '-'.
         * Go in reverse order so the offsets are stable.
         */

        SpannableStringBuilder stripped = null;

        for (int i = end - 1; i >= start; i--) {
            char c = source.charAt(i);
            boolean strip = false;

            if (c == '-') {
                if (i != start || dstart != 0) {
                    strip = true;
                } else if (sign >= 0) {
                    strip = true;
                } else {
                    sign = i;
                }
            } else if (c == '.') {
                if (decimal >= 0) {
                    strip = true;
                } else {
                    decimal = i;
                }
            }

            if (strip) {
                if (end == start + 1) {
                    return "";  // Only one character, and it was stripped.
                }

                if (stripped == null) {
                    stripped = new SpannableStringBuilder(source, start, end);
                }

                stripped.delete(i - start, i + 1 - start);
            }
        }

        if (stripped != null) {
            return stripped;
        } else if (out != null) {
            return out;
        } else {
            return null;
        }
    }
}

