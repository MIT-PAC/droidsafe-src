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
 * Copyright (C) 2011 The Android Open Source Project
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


package libcore.net.url;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

public final class UrlUtils {

    /**
     * Returns the path will relative path segments like ".." and "." resolved.
     * The returned path will not necessarily start with a "/" character. This
     * handles ".." and "." segments at both the beginning and end of the path.
     *
     * @param discardRelativePrefix true to remove leading ".." segments from
     *     the path. This is appropriate for paths that are known to be
     *     absolute.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.922 -0500", hash_original_method = "9846573335398B4F61F3531E4C57F2B5", hash_generated_method = "80D0985321ECA2E6F1ECECF536BFEBFB")
    
    public static String canonicalizePath(String path, boolean discardRelativePrefix) {
        return path;
    }

    /**
     * Returns a path that can be safely concatenated with {@code authority}. If
     * the authority is null or empty, this can be any path. Otherwise the paths
     * run together like {@code http://android.comindex.html}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.925 -0500", hash_original_method = "8B63B6606F2CF427FC7B99898B25B215", hash_generated_method = "EC1965268AD0D881798AD2CB98574BF6")
    
public static String authoritySafePath(String authority, String path) {
        if (authority != null && !authority.isEmpty() && !path.isEmpty() && !path.startsWith("/")) {
            return "/" + path;
        }
        return path;
    }

    /**
     * Returns the scheme prefix like "http" from the URL spec, or null if the
     * spec doesn't start with a scheme. Scheme prefixes match this pattern:
     * {@code alpha ( alpha | digit | '+' | '-' | '.' )* ':'}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.927 -0500", hash_original_method = "E2E22956A4F207916457EDE07112F88D", hash_generated_method = "419F2EEDA0825E754A3521196C5AFD60")
    
public static String getSchemePrefix(String spec) {
        int colon = spec.indexOf(':');

        if (colon < 1) {
            return null;
        }

        for (int i = 0; i < colon; i++) {
            char c = spec.charAt(i);
            if (!isValidSchemeChar(i, c)) {
                return null;
            }
        }

        return spec.substring(0, colon).toLowerCase(Locale.US);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.930 -0500", hash_original_method = "4943CCAF6D78FBC7B907B31B28241551", hash_generated_method = "79F2BE0BD08A9658B85E5E0865FFDF63")
    
public static boolean isValidSchemeChar(int index, char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        if (index > 0 && ((c >= '0' && c <= '9') || c == '+' || c == '-' || c == '.')) {
            return true;
        }
        return false;
    }

    /**
     * Returns the index of the first char of {@code chars} in {@code string}
     * bounded between {@code start} and {@code end}. This returns {@code end}
     * if none of the characters exist in the requested range.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.933 -0500", hash_original_method = "5B71B161212244EE7AB917C7C7C70B93", hash_generated_method = "437128F81BE6DA9B43CEC59DB6054742")
    
public static int findFirstOf(String string, String chars, int start, int end) {
        for (int i = start; i < end; i++) {
            char c = string.charAt(i);
            if (chars.indexOf(c) != -1) {
                return i;
            }
        }
        return end;
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.919 -0500", hash_original_method = "F053AECC4082C3B5C824758EB45DBA0C", hash_generated_method = "7FCF6717728C584D442F19497B41ABF1")
    
private UrlUtils() {
    }
    
}

