/*
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
package org.apache.commons.io.filefilter;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.File;
import java.io.Serializable;
import java.util.List;

import org.apache.commons.io.IOCase;

/**
 * Filters files based on the suffix (what the filename ends with).
 * This is used in retrieving all the files of a particular type.
 * <p>
 * For example, to retrieve and print all <code>*.java</code> files 
 * in the current directory:
 *
 * <pre>
 * File dir = new File(".");
 * String[] files = dir.list( new SuffixFileFilter(".java") );
 * for (int i = 0; i &lt; files.length; i++) {
 *     System.out.println(files[i]);
 * }
 * </pre>
 *
 * @since 1.0
 * @version $Id: SuffixFileFilter.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @see FileFilterUtils#suffixFileFilter(String)
 * @see FileFilterUtils#suffixFileFilter(String, IOCase)
 */
public class SuffixFileFilter extends AbstractFileFilter implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.692 -0400", hash_original_field = "BA0AB381AF966FF1F80048B23AEAF5A8", hash_generated_field = "2F80320574B22A6AB3C8EF150A4751E0")

    private  String[] suffixes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.692 -0400", hash_original_field = "8680B2A624039D0FA36FFAFA61AFD32B", hash_generated_field = "21450A3017D0D6122C0877D57300E67A")

    private  IOCase caseSensitivity;

    /**
     * Constructs a new Suffix file filter for a single extension.
     * 
     * @param suffix  the suffix to allow, must not be null
     * @throws IllegalArgumentException if the suffix is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.693 -0400", hash_original_method = "26ECE614E5AA8C4631792CFFDE54B2CE", hash_generated_method = "81BCD34C5C31D20605995E3F5153B845")
    
public SuffixFileFilter(String suffix) {
        this(suffix, IOCase.SENSITIVE);
    }

    /**
     * Constructs a new Suffix file filter for a single extension
     * specifying case-sensitivity.
     *
     * @param suffix  the suffix to allow, must not be null
     * @param caseSensitivity  how to handle case sensitivity, null means case-sensitive
     * @throws IllegalArgumentException if the suffix is null
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.694 -0400", hash_original_method = "18E79F17CEA62402EC9F3F15F922D012", hash_generated_method = "2110618DC289DF015C8D619F05079A61")
    
public SuffixFileFilter(String suffix, IOCase caseSensitivity) {
        if (suffix == null) {
            throw new IllegalArgumentException("The suffix must not be null");
        }
        this.suffixes = new String[] {suffix};
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    /**
     * Constructs a new Suffix file filter for an array of suffixs.
     * <p>
     * The array is not cloned, so could be changed after constructing the
     * instance. This would be inadvisable however.
     * 
     * @param suffixes  the suffixes to allow, must not be null
     * @throws IllegalArgumentException if the suffix array is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.694 -0400", hash_original_method = "27ADFB4EAA62C71913507B549D4CAC10", hash_generated_method = "3F5433AC1499670A4A969374E3259C3D")
    
public SuffixFileFilter(String[] suffixes) {
        this(suffixes, IOCase.SENSITIVE);
    }

    /**
     * Constructs a new Suffix file filter for an array of suffixs
     * specifying case-sensitivity.
     * <p>
     * The array is not cloned, so could be changed after constructing the
     * instance. This would be inadvisable however.
     * 
     * @param suffixes  the suffixes to allow, must not be null
     * @param caseSensitivity  how to handle case sensitivity, null means case-sensitive
     * @throws IllegalArgumentException if the suffix array is null
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.695 -0400", hash_original_method = "9EF81A5837AC6374818AE9B0FFBE4DBD", hash_generated_method = "8418DF9A0B6FBA3ECC06BA0A07F498F5")
    
public SuffixFileFilter(String[] suffixes, IOCase caseSensitivity) {
        if (suffixes == null) {
            throw new IllegalArgumentException("The array of suffixes must not be null");
        }
        this.suffixes = new String[suffixes.length];
        System.arraycopy(suffixes, 0, this.suffixes, 0, suffixes.length);
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    /**
     * Constructs a new Suffix file filter for a list of suffixes.
     * 
     * @param suffixes  the suffixes to allow, must not be null
     * @throws IllegalArgumentException if the suffix list is null
     * @throws ClassCastException if the list does not contain Strings
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.695 -0400", hash_original_method = "B0EA15F3C965ED431DBF52EB2A883915", hash_generated_method = "151E73FAD20C64CC13421985E0F5E921")
    
public SuffixFileFilter(List<String> suffixes) {
        this(suffixes, IOCase.SENSITIVE);
    }

    /**
     * Constructs a new Suffix file filter for a list of suffixes
     * specifying case-sensitivity.
     * 
     * @param suffixes  the suffixes to allow, must not be null
     * @param caseSensitivity  how to handle case sensitivity, null means case-sensitive
     * @throws IllegalArgumentException if the suffix list is null
     * @throws ClassCastException if the list does not contain Strings
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.696 -0400", hash_original_method = "CEC383E8BE8AD02DFB1E0F8E166802C6", hash_generated_method = "A1354CACA253C1ABA13FFB05377E0442")
    
public SuffixFileFilter(List<String> suffixes, IOCase caseSensitivity) {
        if (suffixes == null) {
            throw new IllegalArgumentException("The list of suffixes must not be null");
        }
        this.suffixes = suffixes.toArray(new String[suffixes.size()]);
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    /**
     * Checks to see if the filename ends with the suffix.
     * 
     * @param file  the File to check
     * @return true if the filename ends with one of our suffixes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.697 -0400", hash_original_method = "5E16E41D2D30710800B0664BA6AD31F5", hash_generated_method = "114EC3F5851B2323B437569B8F4A3B29")
    
@Override
    public boolean accept(File file) {
        String name = file.getName();
        for (String suffix : this.suffixes) {
            if (caseSensitivity.checkEndsWith(name, suffix)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks to see if the filename ends with the suffix.
     * 
     * @param file  the File directory
     * @param name  the filename
     * @return true if the filename ends with one of our suffixes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.697 -0400", hash_original_method = "850FABEC2D0BD7FBD751AF5978866C44", hash_generated_method = "E7D3766D57DB6BD7F507FD5D6C091065")
    
@Override
    public boolean accept(File file, String name) {
        for (String suffix : this.suffixes) {
            if (caseSensitivity.checkEndsWith(name, suffix)) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.698 -0400", hash_original_method = "A7E4D946C38615EB73B14A44B4632E34", hash_generated_method = "23DE0A2C3212613CB254CB3434C23358")
    
@Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(super.toString());
        buffer.append("(");
        if (suffixes != null) {
            for (int i = 0; i < suffixes.length; i++) {
                if (i > 0) {
                    buffer.append(",");
                }
                buffer.append(suffixes[i]);
            }
        }
        buffer.append(")");
        return buffer.toString();
    }
    
}
