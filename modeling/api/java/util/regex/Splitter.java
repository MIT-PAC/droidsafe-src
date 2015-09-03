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


package java.util.regex;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

public class Splitter {

    /**
     * Returns a result equivalent to {@code s.split(separator, limit)} if it's able
     * to compute it more cheaply than ICU, or null if the caller should fall back to
     * using ICU.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.080 -0500", hash_original_method = "1414AE5E68DF81B22597337750C2038E", hash_generated_method = "C8809045AB28522F725F461B542E354B")
    
public static String[] fastSplit(String re, String input, int limit) {
        // Can we do it cheaply?
        int len = re.length();
        if (len == 0) {
            return null;
        }
        char ch = re.charAt(0);
        if (len == 1 && METACHARACTERS.indexOf(ch) == -1) {
            // We're looking for a single non-metacharacter. Easy.
        } else if (len == 2 && ch == '\\') {
            // We're looking for a quoted character.
            // Quoted metacharacters are effectively single non-metacharacters.
            ch = re.charAt(1);
            if (METACHARACTERS.indexOf(ch) == -1) {
                return null;
            }
        } else {
            return null;
        }

        // We can do this cheaply...

        // Unlike Perl, which considers the result of splitting the empty string to be the empty
        // array, Java returns an array containing the empty string.
        if (input.isEmpty()) {
            return new String[] { "" };
        }

        // Collect text preceding each occurrence of the separator, while there's enough space.
        ArrayList<String> list = new ArrayList<String>();
        int maxSize = limit <= 0 ? Integer.MAX_VALUE : limit;
        int begin = 0;
        int end;
        while ((end = input.indexOf(ch, begin)) != -1 && list.size() + 1 < maxSize) {
            list.add(input.substring(begin, end));
            begin = end + 1;
        }
        return finishSplit(list, input, begin, maxSize, limit);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.083 -0500", hash_original_method = "C41E1C0F8C7FD3DEF4FA010275C2B48C", hash_generated_method = "8892BE56ACE36C10CCB09117F16561A0")
    
public static String[] split(Pattern pattern, String re, String input, int limit) {
        String[] fastResult = fastSplit(re, input, limit);
        if (fastResult != null) {
            return fastResult;
        }

        // Unlike Perl, which considers the result of splitting the empty string to be the empty
        // array, Java returns an array containing the empty string.
        if (input.isEmpty()) {
            return new String[] { "" };
        }

        // Collect text preceding each occurrence of the separator, while there's enough space.
        ArrayList<String> list = new ArrayList<String>();
        int maxSize = limit <= 0 ? Integer.MAX_VALUE : limit;
        Matcher matcher = new Matcher(pattern, input);
        int begin = 0;
        while (matcher.find() && list.size() + 1 < maxSize) {
            list.add(input.substring(begin, matcher.start()));
            begin = matcher.end();
        }
        return finishSplit(list, input, begin, maxSize, limit);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.087 -0500", hash_original_method = "0050259AEB9A6D717FF62E48E0DE4FA1", hash_generated_method = "F1D5F2B00DA03DDDF2D392B40A3BE3B8")
    
private static String[] finishSplit(List<String> list, String input, int begin, int maxSize, int limit) {
        // Add trailing text.
        if (begin < input.length()) {
            list.add(input.substring(begin));
        } else if (limit != 0) { // No point adding the empty string if limit == 0, just to remove it below.
            list.add("");
        }
        // Remove all trailing empty matches in the limit == 0 case.
        if (limit == 0) {
            int i = list.size() - 1;
            while (i >= 0 && list.get(i).isEmpty()) {
                list.remove(i);
                i--;
            }
        }
        // Convert to an array.
        return list.toArray(new String[list.size()]);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.074 -0500", hash_original_field = "38A4CF599FC923449DE87F7C0BDA1FC2", hash_generated_field = "B2FC8B6E50D0FCFCC52E2829DE0BADB1")

    private static final String METACHARACTERS = "\\?*+[](){}^$.|";

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.077 -0500", hash_original_method = "B7F2802825C1EAFD928ACADA9E8D9911", hash_generated_method = "BB29E622CEF7B73828D657A8CD746D77")
    
private Splitter() {
    }
}

