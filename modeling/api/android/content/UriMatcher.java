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


package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import android.net.Uri;

public class UriMatcher {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.363 -0500", hash_original_field = "0CD2043130D9B745DF163CF91A6417B5", hash_generated_field = "EC83DD3596C16D8C7F528F9C8BD122E7")

    public static final int NO_MATCH = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.373 -0500", hash_original_field = "0218AA22E7302220E9E4D01109DA344B", hash_generated_field = "74E03DBA734BDB2408CC928ABAC31EB9")

    static final Pattern PATH_SPLIT_PATTERN = Pattern.compile("/");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.378 -0500", hash_original_field = "0203DA6F49D4E349D41CD1166EA19E90", hash_generated_field = "B743019AE27D261938D2BCF0DA9454CE")

    private static final int EXACT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.381 -0500", hash_original_field = "FDCF7DABCA0423FE97E346C00BD48BDF", hash_generated_field = "4679523F8C31D64A95ADAB50A513AABD")

    private static final int NUMBER = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.384 -0500", hash_original_field = "9986713ACB183EAA9B4ECBE5438C2BD1", hash_generated_field = "D2B29393494C9914D5426F6550D374DF")

    private static final int TEXT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.386 -0500", hash_original_field = "72DDC44E3DCFD57F1A99143C6BCFD37C", hash_generated_field = "814428A5309A583B3B018643DB7956B1")

    private int mCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.388 -0500", hash_original_field = "536F29789198CD68E543D8DC79CDC71E", hash_generated_field = "D99A25611C9835F538CE42B4D7286035")

    private int mWhich;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.390 -0500", hash_original_field = "5C1E1D7AA24FFCA320ADE83B66FB0AC4", hash_generated_field = "2EBA23F479A3FA4159B4CC40D57E4F25")

    private String mText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.392 -0500", hash_original_field = "BCAB3CA08CCFB9D9938405B929B273AB", hash_generated_field = "EB732DCEC890E5DB40D18C782CD31559")

    private ArrayList<UriMatcher> mChildren;
    /**
     * Creates the root node of the URI tree.
     *
     * @param code the code to match for the root URI
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.366 -0500", hash_original_method = "3A2C7DFB4FC2B15E53BF2781D24B3722", hash_generated_method = "12BE94862BAC62C1414B67DFAD761ECF")
    
public UriMatcher(int code)
    {
        mCode = code;
        mWhich = -1;
        mChildren = new ArrayList<UriMatcher>();
        mText = null;
    }

    @DSComment("constructor")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.368 -0500", hash_original_method = "02B7CF0C93AE1B23BA80DE9D9DFF6FFA", hash_generated_method = "90645CB24FE85FAD3970D879680827F5")
    
private UriMatcher()
    {
        mCode = NO_MATCH;
        mWhich = -1;
        mChildren = new ArrayList<UriMatcher>();
        mText = null;
    }

    /**
     * Add a URI to match, and the code to return when this URI is
     * matched. URI nodes may be exact match string, the token "*"
     * that matches any text, or the token "#" that matches only
     * numbers.
     *
     * @param authority the authority to match
     * @param path the path to match. * may be used as a wild card for
     * any text, and # may be used as a wild card for numbers.
     * @param code the code that is returned when a URI is matched
     * against the given components. Must be positive.
     */
    @DSComment("URL matching utility")
    @DSSafe(DSCat.UTIL_FUNCTION)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.371 -0500", hash_original_method = "2E3898492678127443A40FFAA44913F1", hash_generated_method = "A56B1FF934AE2286266D1A896140FC75")
    
public void addURI(String authority, String path, int code)
    {
        if (code < 0) {
            throw new IllegalArgumentException("code " + code + " is invalid: it must be positive");
        }
        String[] tokens = path != null ? PATH_SPLIT_PATTERN.split(path) : null;
        int numTokens = tokens != null ? tokens.length : 0;
        UriMatcher node = this;
        for (int i = -1; i < numTokens; i++) {
            String token = i < 0 ? authority : tokens[i];
            ArrayList<UriMatcher> children = node.mChildren;
            int numChildren = children.size();
            UriMatcher child;
            int j;
            for (j = 0; j < numChildren; j++) {
                child = children.get(j);
                if (token.equals(child.mText)) {
                    node = child;
                    break;
                }
            }
            if (j == numChildren) {
                // Child not found, create it
                child = new UriMatcher();
                if (token.equals("#")) {
                    child.mWhich = NUMBER;
                } else if (token.equals("*")) {
                    child.mWhich = TEXT;
                } else {
                    child.mWhich = EXACT;
                }
                child.mText = token;
                node.mChildren.add(child);
                node = child;
            }
        }
        node.mCode = code;
    }

    /**
     * Try to match against the path in a url.
     *
     * @param uri       The url whose path we will match against.
     *
     * @return  The code for the matched node (added using addURI), 
     * or -1 if there is no matched node.
     */
    @DSComment("URL matching utility")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.376 -0500", hash_original_method = "4993091A11603906CAD34405800B45EB", hash_generated_method = "8CB2911C750473F32C631C38B9D04CC5")
    
public int match(Uri uri)
    {
        final List<String> pathSegments = uri.getPathSegments();
        final int li = pathSegments.size();

        UriMatcher node = this;

        if (li == 0 && uri.getAuthority() == null) {
            return this.mCode;
        }

        for (int i=-1; i<li; i++) {
            String u = i < 0 ? uri.getAuthority() : pathSegments.get(i);
            ArrayList<UriMatcher> list = node.mChildren;
            if (list == null) {
                break;
            }
            node = null;
            int lj = list.size();
            for (int j=0; j<lj; j++) {
                UriMatcher n = list.get(j);
          which_switch:
                switch (n.mWhich) {
                    case EXACT:
                        if (n.mText.equals(u)) {
                            node = n;
                        }
                        break;
                    case NUMBER:
                        int lk = u.length();
                        for (int k=0; k<lk; k++) {
                            char c = u.charAt(k);
                            if (c < '0' || c > '9') {
                                break which_switch;
                            }
                        }
                        node = n;
                        break;
                    case TEXT:
                        node = n;
                        break;
                }
                if (node != null) {
                    break;
                }
            }
            if (node == null) {
                return NO_MATCH;
            }
        }

        return node.mCode;
    }
}

