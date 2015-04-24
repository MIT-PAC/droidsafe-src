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


package libcore.internal;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class StringPool {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.270 -0500", hash_original_method = "9B32FE5AB257BF8F1743169E9DF2009F", hash_generated_method = "A73EDA67461E9FEFF0B0297D0C357EB1")
    
private static boolean contentEquals(String s, char[] chars, int start, int length) {
        if (s.length() != length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (chars[start + i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.267 -0500", hash_original_field = "19CD99003600D8062ED032E27D493928", hash_generated_field = "2E2D169FE900F8A4284E9ADB2D6BFB44")

    private final String[] pool = new String[512];
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.919 -0400", hash_original_method = "47E61A2F931E9ECD5F1435DEB562B68F", hash_generated_method = "47E61A2F931E9ECD5F1435DEB562B68F")
    public StringPool ()
    {
        //Synthesized constructor
    }

    /**
     * Returns a string equal to {@code new String(array, start, length)}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.272 -0500", hash_original_method = "84455256120C340B9F8A0E1FDB3B796B", hash_generated_method = "79EBDAE15DAB1D9423B1E42C336AFBD1")
    
public String get(char[] array, int start, int length) {
        // Compute an arbitrary hash of the content
        int hashCode = 0;
        for (int i = start; i < start + length; i++) {
            hashCode = (hashCode * 31) + array[i];
        }

        // Pick a bucket using Doug Lea's supplemental secondaryHash function (from HashMap)
        hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
        hashCode ^= (hashCode >>> 7) ^ (hashCode >>> 4);
        int index = hashCode & (pool.length - 1);

        String pooled = pool[index];
        if (pooled != null && contentEquals(pooled, array, start, length)) {
            return pooled;
        }

        String result = new String(array, start, length);
        pool[index] = result;
        return result;
    }
    
}

