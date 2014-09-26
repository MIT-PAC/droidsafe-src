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
package org.apache.commons.io.comparator;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;

/**
 * Compare the file name <b>extensions</b> for order
 * (see {@link FilenameUtils#getExtension(String)}).
 * <p>
 * This comparator can be used to sort lists or arrays of files
 * by their file extension either in a case-sensitive, case-insensitive or
 * system dependant case sensitive way. A number of singleton instances
 * are provided for the various case sensitivity options (using {@link IOCase})
 * and the reverse of those options.
 * <p>
 * Example of a <i>case-sensitive</i> file extension sort using the
 * {@link #EXTENSION_COMPARATOR} singleton instance:
 * <pre>
 *       List&lt;File&gt; list = ...
 *       ExtensionFileComparator.EXTENSION_COMPARATOR.sort(list);
 * </pre>
 * <p>
 * Example of a <i>reverse case-insensitive</i> file extension sort using the
 * {@link #EXTENSION_INSENSITIVE_REVERSE} singleton instance:
 * <pre>
 *       File[] array = ...
 *       ExtensionFileComparator.EXTENSION_INSENSITIVE_REVERSE.sort(array);
 * </pre>
 * <p>
 *
 * @version $Id: ExtensionFileComparator.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @since 1.4
 */
public class ExtensionFileComparator extends AbstractFileComparator implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.495 -0400", hash_original_field = "ACCD37E1D9595F9381F8105649A1010A", hash_generated_field = "2EF321651233CD14147E1E4DA1BADAF9")

    public static final Comparator<File> EXTENSION_COMPARATOR = new ExtensionFileComparator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.496 -0400", hash_original_field = "F99A5629096EA1CD2B05472F9F803ABB", hash_generated_field = "C74952010ADAA08A7313781CC5A9B457")

    public static final Comparator<File> EXTENSION_REVERSE = new ReverseComparator(EXTENSION_COMPARATOR);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.497 -0400", hash_original_field = "73590B557DB8478457A74C240FEA506A", hash_generated_field = "47B18B94AA8A054C6FC3FA607B029D79")

    public static final Comparator<File> EXTENSION_INSENSITIVE_COMPARATOR
                                                = new ExtensionFileComparator(IOCase.INSENSITIVE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.497 -0400", hash_original_field = "CFEAB605186CB55F75F2362F60E9D59B", hash_generated_field = "B2E9034FF7DEF5FAC4733E8CCEE4013A")

    public static final Comparator<File> EXTENSION_INSENSITIVE_REVERSE
                                                = new ReverseComparator(EXTENSION_INSENSITIVE_COMPARATOR);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.498 -0400", hash_original_field = "002FFC1EADCD1F2AE3BEABFF715E8A71", hash_generated_field = "421A6F7E72C8807D87EF07590FFCF61C")

    public static final Comparator<File> EXTENSION_SYSTEM_COMPARATOR = new ExtensionFileComparator(IOCase.SYSTEM);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.498 -0400", hash_original_field = "5A6B7231830D175EA57E546152F0C94F", hash_generated_field = "A13CE54151A68982E1C070D10454926E")

    public static final Comparator<File> EXTENSION_SYSTEM_REVERSE = new ReverseComparator(EXTENSION_SYSTEM_COMPARATOR);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.499 -0400", hash_original_field = "8680B2A624039D0FA36FFAFA61AFD32B", hash_generated_field = "21450A3017D0D6122C0877D57300E67A")

    private  IOCase caseSensitivity;

    /**
     * Construct a case sensitive file extension comparator instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.499 -0400", hash_original_method = "3A8CFBD8D9978421723DC262FBD1326A", hash_generated_method = "1B349E16874A1A96863372225DF59D65")
    
public ExtensionFileComparator() {
        this.caseSensitivity = IOCase.SENSITIVE;
    }

    /**
     * Construct a file extension comparator instance with the specified case-sensitivity.
     *
     * @param caseSensitivity how to handle case sensitivity, null means case-sensitive
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.500 -0400", hash_original_method = "F5D6469F4576D324414C9087777D12E4", hash_generated_method = "8A113769AAE311B1AB073825E0B8D45F")
    
public ExtensionFileComparator(IOCase caseSensitivity) {
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    /**
     * Compare the extensions of two files the specified case sensitivity.
     * 
     * @param file1 The first file to compare
     * @param file2 The second file to compare
     * @return a negative value if the first file's extension
     * is less than the second, zero if the extensions are the
     * same and a positive value if the first files extension
     * is greater than the second file.
     * 
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.500 -0400", hash_original_method = "9212C488AEDF56E62CAE314A88D3084B", hash_generated_method = "6DEEF8A07D7BEB51320645C091091EC2")
    
public int compare(File file1, File file2) {
        String suffix1 = FilenameUtils.getExtension(file1.getName());
        String suffix2 = FilenameUtils.getExtension(file2.getName());
        return caseSensitivity.checkCompareTo(suffix1, suffix2);
    }

    /**
     * String representation of this file comparator.
     *
     * @return String representation of this file comparator
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.501 -0400", hash_original_method = "2C8858F1FEF258A79F4059C0A1CB8058", hash_generated_method = "73DBD95B0639383FC78436A99232C748")
    
@Override
    public String toString() {
        return super.toString() + "[caseSensitivity=" + caseSensitivity + "]";
    }
}
