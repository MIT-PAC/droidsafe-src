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


package org.apache.commons.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.Serializable;

/**
 * Enumeration of IO case sensitivity.
 * <p>
 * Different filing systems have different rules for case-sensitivity.
 * Windows is case-insensitive, Unix is case-sensitive.
 * <p>
 * This class captures that difference, providing an enumeration to
 * control how filename comparisons should be performed. It also provides
 * methods that use the enumeration to perform comparisons.
 * <p>
 * Wherever possible, you should use the <code>check</code> methods in this
 * class to compare filenames.
 *
 * @version $Id: IOCase.java 1307459 2012-03-30 15:11:44Z ggregory $
 * @since 1.3
 */
public final class IOCase implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.388 -0400", hash_original_field = "E50228AFDC64480CFAB84A66F5BC76A9", hash_generated_field = "330382E58EBF50A44FA8DEE9CA480DDC")

    public static final IOCase SENSITIVE = new IOCase("Sensitive", true);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.389 -0400", hash_original_field = "3FFE327FCE9BB43319AC4F6C1788BD68", hash_generated_field = "6C98626F646DC5FDB3D239DAA2B28981")

    public static final IOCase INSENSITIVE = new IOCase("Insensitive", false);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.389 -0400", hash_original_field = "33AAF8A11C9E32251483733E35D1B964", hash_generated_field = "5830A4A67AFD721DB0E9D0F8F7239E9D")

    public static final IOCase SYSTEM = new IOCase("System", !FilenameUtils.isSystemWindows());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.390 -0400", hash_original_field = "92647F0C9F7F97BAC046E3E6275A994F", hash_generated_field = "BE8DCAAE6B2CE5E933163A69B770E39B")

    private static final long serialVersionUID = -6343169151696340687L;

    //-----------------------------------------------------------------------
    /**
     * Factory method to create an IOCase from a name.
     * 
     * @param name  the name to find
     * @return the IOCase object
     * @throws IllegalArgumentException if the name is invalid
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.392 -0400", hash_original_method = "EA07F80B3356F4FE18699CEFE7BAB81E", hash_generated_method = "CDA7C3FD0BA191C4A0732E0F48959E12")
    
public static IOCase forName(String name) {
        if (IOCase.SENSITIVE.name.equals(name)){
            return IOCase.SENSITIVE;
        }
        if (IOCase.INSENSITIVE.name.equals(name)){
            return IOCase.INSENSITIVE;
        }
        if (IOCase.SYSTEM.name.equals(name)){
            return IOCase.SYSTEM;
        }
        throw new IllegalArgumentException("Invalid IOCase name: " + name);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.390 -0400", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private  String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.391 -0400", hash_original_field = "B223530071C99B68A1E5E7FA81B106B8", hash_generated_field = "8CB56C87B0269066CFF96D607DC1BAB7")

    private  transient boolean sensitive;

    //-----------------------------------------------------------------------
    /**
     * Private constructor.
     * 
     * @param name  the name
     * @param sensitive  the sensitivity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.392 -0400", hash_original_method = "923C527E378097C1219119EB83365F82", hash_generated_method = "E771CC526FCA1FEA3B16DAB819147907")
    
private IOCase(String name, boolean sensitive) {
        this.name = name;
        this.sensitive = sensitive;
    }

    /**
     * Replaces the enumeration from the stream with a real one.
     * This ensures that the correct flag is set for SYSTEM.
     * 
     * @return the resolved object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.393 -0400", hash_original_method = "75E6AD44795DF0269F8B428E9F990646", hash_generated_method = "2C0F48E3A9468FE98EC5BC606B4B65E2")
    
private Object readResolve() {
        return forName(name);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the name of the constant.
     * 
     * @return the name of the constant
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.393 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    
public String getName() {
        return name;
    }

    /**
     * Does the object represent case sensitive comparison.
     * 
     * @return true if case sensitive
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.394 -0400", hash_original_method = "D4D1A27073CB69531CAF258DC4B9AC95", hash_generated_method = "98754A432EB9D8F169AE9477EF7D9E8E")
    
public boolean isCaseSensitive() {
        return sensitive;
    }

    //-----------------------------------------------------------------------
    /**
     * Compares two strings using the case-sensitivity rule.
     * <p>
     * This method mimics {@link String#compareTo} but takes case-sensitivity
     * into account.
     * 
     * @param str1  the first string to compare, not null
     * @param str2  the second string to compare, not null
     * @return true if equal using the case rules
     * @throws NullPointerException if either string is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.394 -0400", hash_original_method = "FCED5C8D6D9F97DBA9E3BA0A98F2A945", hash_generated_method = "F40F77431574A3150FA17797E126FF2E")
    
public int checkCompareTo(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new NullPointerException("The strings must not be null");
        }
        return sensitive ? str1.compareTo(str2) : str1.compareToIgnoreCase(str2);
    }

    /**
     * Compares two strings using the case-sensitivity rule.
     * <p>
     * This method mimics {@link String#equals} but takes case-sensitivity
     * into account.
     * 
     * @param str1  the first string to compare, not null
     * @param str2  the second string to compare, not null
     * @return true if equal using the case rules
     * @throws NullPointerException if either string is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.395 -0400", hash_original_method = "A1834B40E07842ED206E79B7DD652E98", hash_generated_method = "F4C182AD20932A02BEEAB9FC3949970E")
    
public boolean checkEquals(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new NullPointerException("The strings must not be null");
        }
        return sensitive ? str1.equals(str2) : str1.equalsIgnoreCase(str2);
    }

    /**
     * Checks if one string starts with another using the case-sensitivity rule.
     * <p>
     * This method mimics {@link String#startsWith(String)} but takes case-sensitivity
     * into account.
     * 
     * @param str  the string to check, not null
     * @param start  the start to compare against, not null
     * @return true if equal using the case rules
     * @throws NullPointerException if either string is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.396 -0400", hash_original_method = "DE959B82FAE20A2C02C6F6668F717E02", hash_generated_method = "4CD90662B79A1C6D2C59A1B8CBE902EF")
    
public boolean checkStartsWith(String str, String start) {
        return str.regionMatches(!sensitive, 0, start, 0, start.length());
    }

    /**
     * Checks if one string ends with another using the case-sensitivity rule.
     * <p>
     * This method mimics {@link String#endsWith} but takes case-sensitivity
     * into account.
     * 
     * @param str  the string to check, not null
     * @param end  the end to compare against, not null
     * @return true if equal using the case rules
     * @throws NullPointerException if either string is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.396 -0400", hash_original_method = "5DEB3C8085F8F60F4136227F14208410", hash_generated_method = "41525E4DB689284CB3F608F32470E945")
    
public boolean checkEndsWith(String str, String end) {
        int endLen = end.length();
        return str.regionMatches(!sensitive, str.length() - endLen, end, 0, endLen);
    }

    /**
     * Checks if one string contains another starting at a specific index using the
     * case-sensitivity rule.
     * <p>
     * This method mimics parts of {@link String#indexOf(String, int)} 
     * but takes case-sensitivity into account.
     * 
     * @param str  the string to check, not null
     * @param strStartIndex  the index to start at in str
     * @param search  the start to search for, not null
     * @return the first index of the search String,
     *  -1 if no match or {@code null} string input
     * @throws NullPointerException if either string is null
     * @since 2.0
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.397 -0400", hash_original_method = "8D9B60D64D088F60BE3CDF32B6A1EFAB", hash_generated_method = "B4DA0EA953CB1CD697405E702D7BEEDE")
    
public int checkIndexOf(String str, int strStartIndex, String search) {
        int endIndex = str.length() - search.length();
        if (endIndex >= strStartIndex) {
            for (int i = strStartIndex; i <= endIndex; i++) {
                if (checkRegionMatches(str, i, search)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Checks if one string contains another at a specific index using the case-sensitivity rule.
     * <p>
     * This method mimics parts of {@link String#regionMatches(boolean, int, String, int, int)} 
     * but takes case-sensitivity into account.
     * 
     * @param str  the string to check, not null
     * @param strStartIndex  the index to start at in str
     * @param search  the start to search for, not null
     * @return true if equal using the case rules
     * @throws NullPointerException if either string is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.398 -0400", hash_original_method = "F30BBDDAAC2E6AD203135C0D7804F286", hash_generated_method = "9B5D5A10ED9024733C087E2E4573FF5D")
    
public boolean checkRegionMatches(String str, int strStartIndex, String search) {
        return str.regionMatches(!sensitive, strStartIndex, search, 0, search.length());
    }

    //-----------------------------------------------------------------------
    /**
     * Gets a string describing the sensitivity.
     * 
     * @return a string describing the sensitivity
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.398 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "0D841C721535905DD0E9F7FAE6757EB9")
    
@Override
    public String toString() {
        return name;
    }

}
