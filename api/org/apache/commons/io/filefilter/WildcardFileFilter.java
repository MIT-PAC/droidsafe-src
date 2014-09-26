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

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;

/**
 * Filters files using the supplied wildcards.
 * <p>
 * This filter selects files and directories based on one or more wildcards.
 * Testing is case-sensitive by default, but this can be configured.
 * <p>
 * The wildcard matcher uses the characters '?' and '*' to represent a
 * single or multiple wildcard characters.
 * This is the same as often found on Dos/Unix command lines.
 * The extension check is case-sensitive by .
 * See {@link FilenameUtils#wildcardMatchOnSystem} for more information.
 * <p>
 * For example:
 * <pre>
 * File dir = new File(".");
 * FileFilter fileFilter = new WildcardFileFilter("*test*.java~*~");
 * File[] files = dir.listFiles(fileFilter);
 * for (int i = 0; i < files.length; i++) {
 *   System.out.println(files[i]);
 * }
 * </pre>
 *
 * @version $Id: WildcardFileFilter.java 1304058 2012-03-22 21:02:43Z sebb $
 * @since 1.3
 */
public class WildcardFileFilter extends AbstractFileFilter implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.446 -0400", hash_original_field = "C190B6BB28A4140D7E8BF9A6EC3E8C98", hash_generated_field = "6C7DD8A76D73FE93C97BF4100E50ABE2")

    private  String[] wildcards;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.446 -0400", hash_original_field = "8680B2A624039D0FA36FFAFA61AFD32B", hash_generated_field = "21450A3017D0D6122C0877D57300E67A")

    private  IOCase caseSensitivity;

    /**
     * Construct a new case-sensitive wildcard filter for a single wildcard.
     *
     * @param wildcard  the wildcard to match
     * @throws IllegalArgumentException if the pattern is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.447 -0400", hash_original_method = "0DC8B11301EF3C498C2ABB05D6DC182D", hash_generated_method = "6D79DE1DED9ECA9FA53F93B787A0A9DB")
    
public WildcardFileFilter(String wildcard) {
        this(wildcard, null);
    }

    /**
     * Construct a new wildcard filter for a single wildcard specifying case-sensitivity.
     *
     * @param wildcard  the wildcard to match, not null
     * @param caseSensitivity  how to handle case sensitivity, null means case-sensitive
     * @throws IllegalArgumentException if the pattern is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.447 -0400", hash_original_method = "48E5C7007F85482990B2FBCD68749192", hash_generated_method = "BD8C4D81D953918B2390F0D334A38078")
    
public WildcardFileFilter(String wildcard, IOCase caseSensitivity) {
        if (wildcard == null) {
            throw new IllegalArgumentException("The wildcard must not be null");
        }
        this.wildcards = new String[] { wildcard };
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    /**
     * Construct a new case-sensitive wildcard filter for an array of wildcards.
     * <p>
     * The array is not cloned, so could be changed after constructing the
     * instance. This would be inadvisable however.
     *
     * @param wildcards  the array of wildcards to match
     * @throws IllegalArgumentException if the pattern array is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.448 -0400", hash_original_method = "B6C58B18880B584ACFA73AD5A7B51AB0", hash_generated_method = "0CA92696B38F6B92D4F5EC3E0BD8986B")
    
public WildcardFileFilter(String[] wildcards) {
        this(wildcards, null);
    }

    /**
     * Construct a new wildcard filter for an array of wildcards specifying case-sensitivity.
     * <p>
     * The array is not cloned, so could be changed after constructing the
     * instance. This would be inadvisable however.
     *
     * @param wildcards  the array of wildcards to match, not null
     * @param caseSensitivity  how to handle case sensitivity, null means case-sensitive
     * @throws IllegalArgumentException if the pattern array is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.448 -0400", hash_original_method = "B52C3DB451FF68ED0A74295B989A7EE9", hash_generated_method = "C2319A717544B6B47E7E409882EE4494")
    
public WildcardFileFilter(String[] wildcards, IOCase caseSensitivity) {
        if (wildcards == null) {
            throw new IllegalArgumentException("The wildcard array must not be null");
        }
        this.wildcards = new String[wildcards.length];
        System.arraycopy(wildcards, 0, this.wildcards, 0, wildcards.length);
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    /**
     * Construct a new case-sensitive wildcard filter for a list of wildcards.
     *
     * @param wildcards  the list of wildcards to match, not null
     * @throws IllegalArgumentException if the pattern list is null
     * @throws ClassCastException if the list does not contain Strings
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.449 -0400", hash_original_method = "074E489B2A417933ABDEFACED52DF48F", hash_generated_method = "6960C760423E0F71D5FE511DC9E279C9")
    
public WildcardFileFilter(List<String> wildcards) {
        this(wildcards, null);
    }

    /**
     * Construct a new wildcard filter for a list of wildcards specifying case-sensitivity.
     *
     * @param wildcards  the list of wildcards to match, not null
     * @param caseSensitivity  how to handle case sensitivity, null means case-sensitive
     * @throws IllegalArgumentException if the pattern list is null
     * @throws ClassCastException if the list does not contain Strings
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.450 -0400", hash_original_method = "20DEFBD5799CE860E02C4A46D8229CF6", hash_generated_method = "4563B9EF51ED2CB596901FE12F4F0D2E")
    
public WildcardFileFilter(List<String> wildcards, IOCase caseSensitivity) {
        if (wildcards == null) {
            throw new IllegalArgumentException("The wildcard list must not be null");
        }
        this.wildcards = wildcards.toArray(new String[wildcards.size()]);
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    //-----------------------------------------------------------------------
    /**
     * Checks to see if the filename matches one of the wildcards.
     *
     * @param dir  the file directory (ignored)
     * @param name  the filename
     * @return true if the filename matches one of the wildcards
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.450 -0400", hash_original_method = "0D7E6F981525F2AA16F60F5ED0631F0E", hash_generated_method = "0EFF912A30B012B49096373770DFC277")
    
@Override
    public boolean accept(File dir, String name) {
        for (String wildcard : wildcards) {
            if (FilenameUtils.wildcardMatch(name, wildcard, caseSensitivity)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks to see if the filename matches one of the wildcards.
     *
     * @param file  the file to check
     * @return true if the filename matches one of the wildcards
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.451 -0400", hash_original_method = "C244C034F5D60E2DBFF912D07EE9EFE9", hash_generated_method = "DED07B33CEBD3C0F8835ED2ECA4DED35")
    
@Override
    public boolean accept(File file) {
        String name = file.getName();
        for (String wildcard : wildcards) {
            if (FilenameUtils.wildcardMatch(name, wildcard, caseSensitivity)) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.452 -0400", hash_original_method = "54924678DCA60F174F0C38EC41ACEED7", hash_generated_method = "52A5FA9A3306C4FBBAFEAED1F34859F7")
    
@Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(super.toString());
        buffer.append("(");
        if (wildcards != null) {
            for (int i = 0; i < wildcards.length; i++) {
                if (i > 0) {
                    buffer.append(",");
                }
                buffer.append(wildcards[i]);
            }
        }
        buffer.append(")");
        return buffer.toString();
    }

}
