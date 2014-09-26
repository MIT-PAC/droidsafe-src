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
 * Filters filenames for a certain name.
 * <p>
 * For example, to print all files and directories in the 
 * current directory whose name is <code>Test</code>:
 *
 * <pre>
 * File dir = new File(".");
 * String[] files = dir.list( new NameFileFilter("Test") );
 * for ( int i = 0; i &lt; files.length; i++ ) {
 *     System.out.println(files[i]);
 * }
 * </pre>
 *
 * @since 1.0
 * @version $Id: NameFileFilter.java 1304058 2012-03-22 21:02:43Z sebb $
 * @see FileFilterUtils#nameFileFilter(String)
 * @see FileFilterUtils#nameFileFilter(String, IOCase)
 */
public class NameFileFilter extends AbstractFileFilter implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.599 -0400", hash_original_field = "111AE7964AF24B253E7924F33761BE69", hash_generated_field = "E3509315482C60EE65D446B55C371238")

    private  String[] names;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.600 -0400", hash_original_field = "8680B2A624039D0FA36FFAFA61AFD32B", hash_generated_field = "21450A3017D0D6122C0877D57300E67A")

    private  IOCase caseSensitivity;

    /**
     * Constructs a new case-sensitive name file filter for a single name.
     * 
     * @param name  the name to allow, must not be null
     * @throws IllegalArgumentException if the name is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.601 -0400", hash_original_method = "EB84086797A3D4C584C92992867C0467", hash_generated_method = "A00872A77BF0CE570657E256AC0B443A")
    
public NameFileFilter(String name) {
        this(name, null);
    }

    /**
     * Construct a new name file filter specifying case-sensitivity.
     *
     * @param name  the name to allow, must not be null
     * @param caseSensitivity  how to handle case sensitivity, null means case-sensitive
     * @throws IllegalArgumentException if the name is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.602 -0400", hash_original_method = "82856C516978904D9C3EC48D06DD6903", hash_generated_method = "FF2BB6AE0551643335B3AE99C0DA3A53")
    
public NameFileFilter(String name, IOCase caseSensitivity) {
        if (name == null) {
            throw new IllegalArgumentException("The wildcard must not be null");
        }
        this.names = new String[] {name};
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    /**
     * Constructs a new case-sensitive name file filter for an array of names.
     * <p>
     * The array is not cloned, so could be changed after constructing the
     * instance. This would be inadvisable however.
     * 
     * @param names  the names to allow, must not be null
     * @throws IllegalArgumentException if the names array is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.602 -0400", hash_original_method = "A9F98BACB414F0E2CFCA50969D92D7AA", hash_generated_method = "4CE986A26E8ABEC6065A5FB1030C34CD")
    
public NameFileFilter(String[] names) {
        this(names, null);
    }

    /**
     * Constructs a new name file filter for an array of names specifying case-sensitivity.
     * <p>
     * The array is not cloned, so could be changed after constructing the
     * instance. This would be inadvisable however.
     * 
     * @param names  the names to allow, must not be null
     * @param caseSensitivity  how to handle case sensitivity, null means case-sensitive
     * @throws IllegalArgumentException if the names array is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.603 -0400", hash_original_method = "B607BACF1FB1DD166EC9657B6585798A", hash_generated_method = "26D7DDB04E4069EB5D60053F63421958")
    
public NameFileFilter(String[] names, IOCase caseSensitivity) {
        if (names == null) {
            throw new IllegalArgumentException("The array of names must not be null");
        }
        this.names = new String[names.length];
        System.arraycopy(names, 0, this.names, 0, names.length);
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    /**
     * Constructs a new case-sensitive name file filter for a list of names.
     * 
     * @param names  the names to allow, must not be null
     * @throws IllegalArgumentException if the name list is null
     * @throws ClassCastException if the list does not contain Strings
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.603 -0400", hash_original_method = "5611293ED2F0C7E4748ECD14A3071E4F", hash_generated_method = "1084A81DC82EBF452F22A0571B4E410E")
    
public NameFileFilter(List<String> names) {
        this(names, null);
    }

    /**
     * Constructs a new name file filter for a list of names specifying case-sensitivity.
     * 
     * @param names  the names to allow, must not be null
     * @param caseSensitivity  how to handle case sensitivity, null means case-sensitive
     * @throws IllegalArgumentException if the name list is null
     * @throws ClassCastException if the list does not contain Strings
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.604 -0400", hash_original_method = "B917B9DB396BA061BB753C77FE6102E8", hash_generated_method = "0433934F6E6E38AFB49A416A5F621EC5")
    
public NameFileFilter(List<String> names, IOCase caseSensitivity) {
        if (names == null) {
            throw new IllegalArgumentException("The list of names must not be null");
        }
        this.names = names.toArray(new String[names.size()]);
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    //-----------------------------------------------------------------------
    /**
     * Checks to see if the filename matches.
     * 
     * @param file  the File to check
     * @return true if the filename matches
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.605 -0400", hash_original_method = "8143C5E13483113836748794199B1228", hash_generated_method = "6AAA4680CC97F82DBA859191A7830431")
    
@Override
    public boolean accept(File file) {
        String name = file.getName();
        for (String name2 : this.names) {
            if (caseSensitivity.checkEquals(name, name2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks to see if the filename matches.
     * 
     * @param dir  the File directory (ignored)
     * @param name  the filename
     * @return true if the filename matches
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.605 -0400", hash_original_method = "F0ECCB0CC9BF3CE73728CA922CC18037", hash_generated_method = "A7E4CE96CF292916155BCD2729422107")
    
@Override
    public boolean accept(File dir, String name) {
        for (String name2 : names) {
            if (caseSensitivity.checkEquals(name, name2)) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.606 -0400", hash_original_method = "2C08B488ADA93371BD5A437FB37025E7", hash_generated_method = "001056193AB0073F4DF26C03227633D7")
    
@Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(super.toString());
        buffer.append("(");
        if (names != null) {
            for (int i = 0; i < names.length; i++) {
                if (i > 0) {
                    buffer.append(",");
                }
                buffer.append(names[i]);
            }
        }
        buffer.append(")");
        return buffer.toString();
    }

}
