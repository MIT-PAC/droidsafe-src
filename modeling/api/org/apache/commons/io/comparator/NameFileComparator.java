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

import org.apache.commons.io.IOCase;

/**
 * Compare the <b>names</b> of two files for order (see {@link File#getName()}).
 * <p>
 * This comparator can be used to sort lists or arrays of files
 * by their name either in a case-sensitive, case-insensitive or
 * system dependant case sensitive way. A number of singleton instances
 * are provided for the various case sensitivity options (using {@link IOCase})
 * and the reverse of those options.
 * <p>
 * Example of a <i>case-sensitive</i> file name sort using the
 * {@link #NAME_COMPARATOR} singleton instance:
 * <pre>
 *       List&lt;File&gt; list = ...
 *       NameFileComparator.NAME_COMPARATOR.sort(list);
 * </pre>
 * <p>
 * Example of a <i>reverse case-insensitive</i> file name sort using the
 * {@link #NAME_INSENSITIVE_REVERSE} singleton instance:
 * <pre>
 *       File[] array = ...
 *       NameFileComparator.NAME_INSENSITIVE_REVERSE.sort(array);
 * </pre>
 * <p>
 *
 * @version $Id: NameFileComparator.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @since 1.4
 */
public class NameFileComparator extends AbstractFileComparator implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.675 -0400", hash_original_field = "0D8E16C80DAA60817F782F23BFD56BED", hash_generated_field = "D2692FCB5F0CC8A92B340B3B44820BBB")

    public static final Comparator<File> NAME_COMPARATOR = new NameFileComparator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.675 -0400", hash_original_field = "515BF92E908438B42A4D46D4AAAA3C8F", hash_generated_field = "A63D6B9684C1E8A5C3D2C0577CEE5178")

    public static final Comparator<File> NAME_REVERSE = new ReverseComparator(NAME_COMPARATOR);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.676 -0400", hash_original_field = "EF5002FF044CAA84A5AE18C2E68D30BE", hash_generated_field = "3922B859CAAA71B818757F740907C8BD")

    public static final Comparator<File> NAME_INSENSITIVE_COMPARATOR = new NameFileComparator(IOCase.INSENSITIVE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.676 -0400", hash_original_field = "4852139C93F750FD8E68229B45AB2CA5", hash_generated_field = "F544E67851C2065C11339C7370E3595A")

    public static final Comparator<File> NAME_INSENSITIVE_REVERSE = new ReverseComparator(NAME_INSENSITIVE_COMPARATOR);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.677 -0400", hash_original_field = "FB6E82EBB1B5F50095A6F904D2C58409", hash_generated_field = "1AC1C6FF1EEC32745ACBC75B14EE7156")

    public static final Comparator<File> NAME_SYSTEM_COMPARATOR = new NameFileComparator(IOCase.SYSTEM);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.678 -0400", hash_original_field = "5AA9AA78D90F6943EC5980C59BEC692B", hash_generated_field = "8F91729C6A2D6523D60FCE78EA7688DB")

    public static final Comparator<File> NAME_SYSTEM_REVERSE = new ReverseComparator(NAME_SYSTEM_COMPARATOR);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.678 -0400", hash_original_field = "8680B2A624039D0FA36FFAFA61AFD32B", hash_generated_field = "21450A3017D0D6122C0877D57300E67A")

    private  IOCase caseSensitivity;

    /**
     * Construct a case sensitive file name comparator instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.679 -0400", hash_original_method = "73B7A0C9686C873C380A7B8BF0105C29", hash_generated_method = "5225E4D3BFB94944585957469C7462FF")
    
public NameFileComparator() {
        this.caseSensitivity = IOCase.SENSITIVE;
    }

    /**
     * Construct a file name comparator instance with the specified case-sensitivity.
     *
     * @param caseSensitivity  how to handle case sensitivity, null means case-sensitive
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.679 -0400", hash_original_method = "D665A56B967657697241157E26C6DEC4", hash_generated_method = "7B982F46665AEB02475C933C743369B0")
    
public NameFileComparator(IOCase caseSensitivity) {
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    /**
     * Compare the names of two files with the specified case sensitivity.
     * 
     * @param file1 The first file to compare
     * @param file2 The second file to compare
     * @return a negative value if the first file's name
     * is less than the second, zero if the names are the
     * same and a positive value if the first files name
     * is greater than the second file.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.680 -0400", hash_original_method = "63DEB46C163A106B104143300A10799E", hash_generated_method = "367148E440281F644754D7BE5E4FB411")
    
public int compare(File file1, File file2) {
        return caseSensitivity.checkCompareTo(file1.getName(), file2.getName());
    }

    /**
     * String representation of this file comparator.
     *
     * @return String representation of this file comparator
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.680 -0400", hash_original_method = "2C8858F1FEF258A79F4059C0A1CB8058", hash_generated_method = "73DBD95B0639383FC78436A99232C748")
    
@Override
    public String toString() {
        return super.toString() + "[caseSensitivity=" + caseSensitivity + "]";
    }
}
