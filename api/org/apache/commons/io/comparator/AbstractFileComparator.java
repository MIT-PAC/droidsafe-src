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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Abstract file {@link Comparator} which provides sorting for file arrays and lists.
 *
 * @version $Id: AbstractFileComparator.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @since 2.0
 */
abstract class AbstractFileComparator implements Comparator<File> {

    /**
     * Sort an array of files.
     * <p>
     * This method uses {@link Arrays#sort(Object[], Comparator)}
     * and returns the original array.
     *
     * @param files The files to sort, may be null
     * @return The sorted array
     * @since 2.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.645 -0400", hash_original_method = "8CDF48221E968696B6D0A82E43FAB730", hash_generated_method = "69B313C2510158007FAA0150D612CEBB")
    
public File[] sort(File... files) {
        if (files != null) {
            Arrays.sort(files, this);
        }
        return files;
    }

    /**
     * Sort a List of files.
     * <p>
     * This method uses {@link Collections#sort(List, Comparator)}
     * and returns the original list.
     *
     * @param files The files to sort, may be null
     * @return The sorted list
     * @since 2.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.646 -0400", hash_original_method = "905EE6016178F91F1EDE19136C3B52C8", hash_generated_method = "938CED60CBAEE13E2DAA331DCC5A31EE")
    
public List<File> sort(List<File> files) {
        if (files != null) {
            Collections.sort(files, this);
        }
        return files;
    }

    /**
     * String representation of this file comparator.
     *
     * @return String representation of this file comparator
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.646 -0400", hash_original_method = "CC6A2D61A01777F134B61F210B4582B4", hash_generated_method = "DC4F53437482264D89559E059DC0E69A")
    
@Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
