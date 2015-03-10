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
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
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


package org.apache.commons.io.filefilter;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.File;
import java.io.Serializable;
import java.util.List;

import org.apache.commons.io.IOCase;

/**
 * Filters filenames for a certain prefix.
 * <p>
 * For example, to print all files and directories in the 
 * current directory whose name starts with <code>Test</code>:
 *
 * <pre>
 * File dir = new File(".");
 * String[] files = dir.list( new PrefixFileFilter("Test") );
 * for ( int i = 0; i &lt; files.length; i++ ) {
 *     System.out.println(files[i]);
 * }
 * </pre>
 *
 * @since 1.0
 * @version $Id: PrefixFileFilter.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @see FileFilterUtils#prefixFileFilter(String)
 * @see FileFilterUtils#prefixFileFilter(String, IOCase)
 */
public class PrefixFileFilter extends AbstractFileFilter implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.762 -0400", hash_original_field = "9FA4FB885570D8A01C68EDC71289A6B8", hash_generated_field = "9B3455D756A1FBC6C82117FF303199E2")

    private  String[] prefixes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.762 -0400", hash_original_field = "8680B2A624039D0FA36FFAFA61AFD32B", hash_generated_field = "21450A3017D0D6122C0877D57300E67A")

    private  IOCase caseSensitivity;

    /**
     * Constructs a new Prefix file filter for a single prefix.
     * 
     * @param prefix  the prefix to allow, must not be null
     * @throws IllegalArgumentException if the prefix is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.763 -0400", hash_original_method = "0F22F1E3EA36EA07744483A876CD465E", hash_generated_method = "308E2A99589706B1259CF191D413D0EA")
    
public PrefixFileFilter(String prefix) {
        this(prefix, IOCase.SENSITIVE);
    }

    /**
     * Constructs a new Prefix file filter for a single prefix 
     * specifying case-sensitivity.
     * 
     * @param prefix  the prefix to allow, must not be null
     * @param caseSensitivity  how to handle case sensitivity, null means case-sensitive
     * @throws IllegalArgumentException if the prefix is null
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.764 -0400", hash_original_method = "9637A33C3A7BEA20E1ACB7D7F032CE22", hash_generated_method = "127DA13A1025AB82345E9940FF0E625C")
    
public PrefixFileFilter(String prefix, IOCase caseSensitivity) {
        if (prefix == null) {
            throw new IllegalArgumentException("The prefix must not be null");
        }
        this.prefixes = new String[] {prefix};
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    /**
     * Constructs a new Prefix file filter for any of an array of prefixes.
     * <p>
     * The array is not cloned, so could be changed after constructing the
     * instance. This would be inadvisable however.
     * 
     * @param prefixes  the prefixes to allow, must not be null
     * @throws IllegalArgumentException if the prefix array is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.764 -0400", hash_original_method = "CAEC80FD980017DE24EC23E6474A88F7", hash_generated_method = "6BC2F450418327A275035F64F14A8775")
    
public PrefixFileFilter(String[] prefixes) {
        this(prefixes, IOCase.SENSITIVE);
    }

    /**
     * Constructs a new Prefix file filter for any of an array of prefixes
     * specifying case-sensitivity.
     * <p>
     * The array is not cloned, so could be changed after constructing the
     * instance. This would be inadvisable however.
     * 
     * @param prefixes  the prefixes to allow, must not be null
     * @param caseSensitivity  how to handle case sensitivity, null means case-sensitive
     * @throws IllegalArgumentException if the prefix is null
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.765 -0400", hash_original_method = "5F192DCF259BEB4C8D9ED2CF41E6957A", hash_generated_method = "E5B0F7A0DBFAB9F5E2564264E3CCCB83")
    
public PrefixFileFilter(String[] prefixes, IOCase caseSensitivity) {
        if (prefixes == null) {
            throw new IllegalArgumentException("The array of prefixes must not be null");
        }
        this.prefixes = new String[prefixes.length];
        System.arraycopy(prefixes, 0, this.prefixes, 0, prefixes.length);
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    /**
     * Constructs a new Prefix file filter for a list of prefixes.
     * 
     * @param prefixes  the prefixes to allow, must not be null
     * @throws IllegalArgumentException if the prefix list is null
     * @throws ClassCastException if the list does not contain Strings
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.765 -0400", hash_original_method = "2B4329C45C54F0B405A84480F694219F", hash_generated_method = "83C30DB3C8AD6B3625E3936644787731")
    
public PrefixFileFilter(List<String> prefixes) {
        this(prefixes, IOCase.SENSITIVE);
    }

    /**
     * Constructs a new Prefix file filter for a list of prefixes
     * specifying case-sensitivity.
     * 
     * @param prefixes  the prefixes to allow, must not be null
     * @param caseSensitivity  how to handle case sensitivity, null means case-sensitive
     * @throws IllegalArgumentException if the prefix list is null
     * @throws ClassCastException if the list does not contain Strings
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.766 -0400", hash_original_method = "ACDB1E0F1106ED25DED903F3FAD064F0", hash_generated_method = "37718B6F2173319DE5385DB52AC5C5D2")
    
public PrefixFileFilter(List<String> prefixes, IOCase caseSensitivity) {
        if (prefixes == null) {
            throw new IllegalArgumentException("The list of prefixes must not be null");
        }
        this.prefixes = prefixes.toArray(new String[prefixes.size()]);
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    /**
     * Checks to see if the filename starts with the prefix.
     * 
     * @param file  the File to check
     * @return true if the filename starts with one of our prefixes
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.767 -0400", hash_original_method = "78167C09373DD6928792D289D7DC6BD6", hash_generated_method = "6A8AAA15A216A30859ED1E5340541FA8")
    
@Override
    public boolean accept(File file) {
        String name = file.getName();
        for (String prefix : this.prefixes) {
            if (caseSensitivity.checkStartsWith(name, prefix)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks to see if the filename starts with the prefix.
     * 
     * @param file  the File directory
     * @param name  the filename
     * @return true if the filename starts with one of our prefixes
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.767 -0400", hash_original_method = "45A7DB6D0E51F61500372E7D66178EF3", hash_generated_method = "CC299A24F1B408C9BA22030D92327A98")
    
@Override
    public boolean accept(File file, String name) {
        for (String prefix : prefixes) {
            if (caseSensitivity.checkStartsWith(name, prefix)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Provide a String representaion of this file filter.
     *
     * @return a String representaion
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.768 -0400", hash_original_method = "93C8E32B6EE68EAE0C3BFC84A4183EBE", hash_generated_method = "5502648BD3DA58FEBB997504A380D974")
    
@Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(super.toString());
        buffer.append("(");
        if (prefixes != null) {
            for (int i = 0; i < prefixes.length; i++) {
                if (i > 0) {
                    buffer.append(",");
                }
                buffer.append(prefixes[i]);
            }
        }
        buffer.append(")");
        return buffer.toString();
    }
    
}
