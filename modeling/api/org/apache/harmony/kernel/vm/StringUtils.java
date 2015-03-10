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
 * Copyright (C) 2008 The Android Open Source Project
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


package org.apache.harmony.kernel.vm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class StringUtils {

    /**
     * Combine a list of strings in an <code>Object[]</code> into a single
     * string.
     *
     * @param list non-null; the strings to combine
     * @return non-null; the combined form
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.365 -0500", hash_original_method = "888FC51886C6044A7D8C9FF6C24BD9F3", hash_generated_method = "2BD935C62418A5B02B2F993978154287")
    
public static String combineStrings(Object[] list) {
        int listLength = list.length;

        switch (listLength) {
            case 0: {
                return "";
            }
            case 1: {
                return (String) list[0];
            }
        }

        int strLength = 0;

        for (int i = 0; i < listLength; i++) {
            strLength += ((String) list[i]).length();
        }

        StringBuilder sb = new StringBuilder(strLength);

        for (int i = 0; i < listLength; i++) {
            sb.append(list[i]);
        }

        return sb.toString();
    }
    /**
     * This class is uninstantiable.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.362 -0500", hash_original_method = "9E881C2879A613DB548C02DA2AC20129", hash_generated_method = "445D9BE0B3E6A16F60D0C20F91B79742")
    
private StringUtils() {
        // This space intentionally left blank.
    }
    
}

