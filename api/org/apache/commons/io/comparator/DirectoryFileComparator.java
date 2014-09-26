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

/**
 * Compare two files using the {@link File#isDirectory()} method.
 * <p>
 * This comparator can be used to sort lists or arrays by directories and files.
 * <p>
 * Example of sorting a list of files/directories using the
 * {@link #DIRECTORY_COMPARATOR} singleton instance:
 * <pre>
 *       List&lt;File&gt; list = ...
 *       DirectoryFileComparator.DIRECTORY_COMPARATOR.sort(list);
 * </pre>
 * <p>
 * Example of doing a <i>reverse</i> sort of an array of files/directories using the
 * {@link #DIRECTORY_REVERSE} singleton instance:
 * <pre>
 *       File[] array = ...
 *       DirectoryFileComparator.DIRECTORY_REVERSE.sort(array);
 * </pre>
 * <p>
 *
 * @version $Id: DirectoryFileComparator.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @since 2.0
 */
public class DirectoryFileComparator extends AbstractFileComparator implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.635 -0400", hash_original_field = "B15384F05B5A1AC8CCA8ACCAFCC70370", hash_generated_field = "E33E6F2595483C0E19B0D4E565CA491E")

    public static final Comparator<File> DIRECTORY_COMPARATOR = new DirectoryFileComparator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.635 -0400", hash_original_field = "98FC63E0EEB62B2DC60A5978AB2DDF38", hash_generated_field = "F126AF8DB82D3604CE3B04EBD827D7FD")

    public static final Comparator<File> DIRECTORY_REVERSE = new ReverseComparator(DIRECTORY_COMPARATOR);

    /**
     * Compare the two files using the {@link File#isDirectory()} method.
     * 
     * @param file1 The first file to compare
     * @param file2 The second file to compare
     * @return the result of calling file1's
     * {@link File#compareTo(File)} with file2 as the parameter.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.635 -0400", hash_original_method = "8FE74608AE6AFB279889AE18FF2B3850", hash_generated_method = "CF1D2D1AF7E795C9A65A8A64394474CE")
    
public int compare(File file1, File file2) {
        return getType(file1) - getType(file2);
    }

    /**
     * Convert type to numeric value.
     *
     * @param file The file
     * @return 1 for directories and 2 for files
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.636 -0400", hash_original_method = "F734E00AC7C86C91DF2349E696F92B1F", hash_generated_method = "B28C7C7B0E6CEFE543224F5C11580A1A")
    
private int getType(File file) {
        if (file.isDirectory()) {
            return 1;
        } else {
            return 2;
        }
    }
}
