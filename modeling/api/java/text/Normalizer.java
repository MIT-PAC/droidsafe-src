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
 * Copyright (C) 2010 The Android Open Source Project
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


package java.text;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import libcore.icu.NativeNormalizer;

/**
 * Provides normalization functions according to
 * <a href="http://www.unicode.org/unicode/reports/tr15/tr15-23.html">Unicode Standard Annex #15:
 * Unicode Normalization Forms</a>. Normalization can decompose and compose
 * characters for equivalency checking.
 *
 * @since 1.6
 */
public final class Normalizer {
    /**
     * The normalization forms supported by the Normalizer. These are specified in
     * <a href="http://www.unicode.org/unicode/reports/tr15/tr15-23.html">Unicode Standard
     * Annex #15</a>.
     */
    public static enum Form {
        /**
         * Normalization Form D - Canonical Decomposition.
         */
        NFD,

        /**
         * Normalization Form C - Canonical Decomposition, followed by Canonical Composition.
         */
        NFC,

        /**
         * Normalization Form KD - Compatibility Decomposition.
         */
        NFKD,

        /**
         * Normalization Form KC - Compatibility Decomposition, followed by Canonical Composition.
         */
        NFKC;
    }

    /**
     * Check whether the given character sequence <code>src</code> is normalized
     * according to the normalization method <code>form</code>.
     *
     * @param src character sequence to check
     * @param form normalization form to check against
     * @return true if normalized according to <code>form</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.399 -0400", hash_original_method = "199BE124B4DF8BF7F646F8BC8E1CBEDF", hash_generated_method = "3DC067AF5761518CF36DBCCC93012154")
    
public static boolean isNormalized(CharSequence src, Form form) {
        return NativeNormalizer.isNormalized(src, form);
    }

    /**
     * Normalize the character sequence <code>src</code> according to the
     * normalization method <code>form</code>.
     *
     * @param src character sequence to read for normalization
     * @param form normalization form
     * @return string normalized according to <code>form</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.401 -0400", hash_original_method = "D5FF661797DACE8313953DC48C3DA11C", hash_generated_method = "513C39CF8F7C91159F6C1EAE6C70C89C")
    
public static String normalize(CharSequence src, Form form) {
        return NativeNormalizer.normalize(src, form);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:19.403 -0400", hash_original_method = "3EA5CF73E36B8D37D8CD03FB747AAC72", hash_generated_method = "F24339EF8F2A1BE580FA745B2C727900")
    
private Normalizer() {}
}
