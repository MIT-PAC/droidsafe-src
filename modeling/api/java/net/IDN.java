/* Licensed to the Apache Software Foundation (ASF) under one or more
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
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.net;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import libcore.icu.NativeIDN;

/**
 * Converts internationalized domain names between Unicode and the ASCII Compatible Encoding
 * (ACE) representation.
 *
 * <p>See <a href="http://www.ietf.org/rfc/rfc3490.txt">RFC 3490</a> for full details.
 *
 * @since 1.6
 */
public final class IDN {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.269 -0400", hash_original_field = "07086B56D281219D23C496CBCC751C31", hash_generated_field = "E60E052DFB9D3FFAF8293CB383E635DE")

    public static final int ALLOW_UNASSIGNED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.271 -0400", hash_original_field = "C064F3DE12B50F2FA790B7C4541B4623", hash_generated_field = "4BACA4A46A9AB4B2E5ECB587B1FD0869")

    public static final int USE_STD3_ASCII_RULES = 2;

    /**
     * Transform a Unicode String to ASCII Compatible Encoding String according
     * to the algorithm defined in <a href="http://www.ietf.org/rfc/rfc3490.txt">RFC 3490</a>.
     *
     * <p>If the transformation fails (because the input is not a valid IDN), an
     * exception will be thrown.
     *
     * <p>This method can handle either an individual label or an entire domain name.
     * In the latter case, the separators are: U+002E (full stop), U+3002 (ideographic full stop),
     * U+FF0E (fullwidth full stop), and U+FF61 (halfwidth ideographic full stop).
     * All of these will become U+002E (full stop) in the result.
     *
     * @param input the Unicode name
     * @param flags 0, {@code ALLOW_UNASSIGNED}, {@code USE_STD3_ASCII_RULES},
     *         or {@code ALLOW_UNASSIGNED | USE_STD3_ASCII_RULES}
     * @return the ACE name
     * @throws IllegalArgumentException if {@code input} does not conform to <a href="http://www.ietf.org/rfc/rfc3490.txt">RFC 3490</a>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.274 -0400", hash_original_method = "4681265216BD04726C8DE86640D9EBFD", hash_generated_method = "96212B4C3BFA1663294F6F4C683E643F")
    
public static String toASCII(String input, int flags) {
        return NativeIDN.toASCII(input, flags);
    }

    /**
     * Equivalent to {@code toASCII(input, 0)}.
     *
     * @param input the Unicode name
     * @return the ACE name
     * @throws IllegalArgumentException if {@code input} does not conform to <a href="http://www.ietf.org/rfc/rfc3490.txt">RFC 3490</a>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.276 -0400", hash_original_method = "2757370B892085BA426C9AB77DB7F013", hash_generated_method = "228E8BAB69865B194FB4FFDB3DA62F79")
    
public static String toASCII(String input) {
        return toASCII(input, 0);
    }

    /**
     * Translates a string from ASCII Compatible Encoding (ACE) to Unicode
     * according to the algorithm defined in <a href="http://www.ietf.org/rfc/rfc3490.txt">RFC 3490</a>.
     *
     * <p>Unlike {@code toASCII}, this transformation cannot fail.
     *
     * <p>This method can handle either an individual label or an entire domain name.
     * In the latter case, the separators are: U+002E (full stop), U+3002 (ideographic full stop),
     * U+FF0E (fullwidth full stop), and U+FF61 (halfwidth ideographic full stop).
     *
     * @param input the ACE name
     * @return the Unicode name
     * @param flags 0, {@code ALLOW_UNASSIGNED}, {@code USE_STD3_ASCII_RULES},
     *         or {@code ALLOW_UNASSIGNED | USE_STD3_ASCII_RULES}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.277 -0400", hash_original_method = "EAFB4F2E5D0CAE88B21C9888C4D03063", hash_generated_method = "3FBD99303302DF1C752B56A752C7E980")
    
public static String toUnicode(String input, int flags) {
        return NativeIDN.toUnicode(input, flags);
    }

    /**
     * Equivalent to {@code toUnicode(input, 0)}.
     *
     * @param input the ACE name
     * @return the Unicode name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.279 -0400", hash_original_method = "302C0CAE2DEDB050D34D6EDD9C47AC0E", hash_generated_method = "B7E8302F8D28F73D50D53B16A4033FC6")
    
public static String toUnicode(String input) {
        return NativeIDN.toUnicode(input, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.272 -0400", hash_original_method = "41463D02EAAC185A540F90DAE21BB2CD", hash_generated_method = "F26365603347A03D22A318BF957BA53F")
    
private IDN() {
    }
}
