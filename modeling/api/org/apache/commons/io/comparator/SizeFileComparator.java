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


package org.apache.commons.io.comparator;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

import org.apache.commons.io.FileUtils;

/**
 * Compare the <b>length/size</b> of two files for order (see
 * {@link File#length()} and {@link FileUtils#sizeOfDirectory(File)}).
 * <p>
 * This comparator can be used to sort lists or arrays of files
 * by their length/size.
 * <p>
 * Example of sorting a list of files using the
 * {@link #SIZE_COMPARATOR} singleton instance:
 * <pre>
 *       List&lt;File&gt; list = ...
 *       SizeFileComparator.SIZE_COMPARATOR.sort(list);
 * </pre>
 * <p>
 * Example of doing a <i>reverse</i> sort of an array of files using the
 * {@link #SIZE_REVERSE} singleton instance:
 * <pre>
 *       File[] array = ...
 *       SizeFileComparator.SIZE_REVERSE.sort(array);
 * </pre>
 * <p>
 * <strong>N.B.</strong> Directories are treated as <b>zero size</b> unless
 * <code>sumDirectoryContents</code> is {@code true}.
 *
 * @version $Id: SizeFileComparator.java 1307462 2012-03-30 15:13:11Z ggregory $
 * @since 1.4
 */
public class SizeFileComparator extends AbstractFileComparator implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.546 -0400", hash_original_field = "B557AE9661E379B7F73A14FE567C9E05", hash_generated_field = "403A8E24B6733033181D121C8D9B72E9")

    public static final Comparator<File> SIZE_COMPARATOR = new SizeFileComparator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.546 -0400", hash_original_field = "3FABB970B99DC0B3CD347B997E628894", hash_generated_field = "9D943F43D397E911FF77080FE25827A5")

    public static final Comparator<File> SIZE_REVERSE = new ReverseComparator(SIZE_COMPARATOR);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.547 -0400", hash_original_field = "B9B4087406F1F64C1EA6E57D36AE6A0A", hash_generated_field = "D80363E469D7433F42AB38B2A5DAE57F")

    public static final Comparator<File> SIZE_SUMDIR_COMPARATOR = new SizeFileComparator(true);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.547 -0400", hash_original_field = "E70CD6D13D1C85C45C05E3CF407C1722", hash_generated_field = "F596E17DA167E1E022FC6B7769071293")

    public static final Comparator<File> SIZE_SUMDIR_REVERSE = new ReverseComparator(SIZE_SUMDIR_COMPARATOR);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.548 -0400", hash_original_field = "1C520889F1CA396E62F7384ED29ABBC7", hash_generated_field = "845FBEEDDFB3BA53245879B7EF870E22")

    private  boolean sumDirectoryContents;

    /**
     * Construct a file size comparator instance (directories treated as zero size).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.548 -0400", hash_original_method = "31F2290758882FE23943782B8BDBF92D", hash_generated_method = "45021EC3D26CE7662296424C7BD5E1FD")
    
public SizeFileComparator() {
        this.sumDirectoryContents = false;
    }

    /**
     * Construct a file size comparator instance specifying whether the size of
     * the directory contents should be aggregated.
     * <p>
     * If the <code>sumDirectoryContents</code> is {@code true} The size of
     * directories is calculated using  {@link FileUtils#sizeOfDirectory(File)}.
     *
     * @param sumDirectoryContents {@code true} if the sum of the directoryies contents
     *  should be calculated, otherwise {@code false} if directories should be treated
     *  as size zero (see {@link FileUtils#sizeOfDirectory(File)}).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.549 -0400", hash_original_method = "49C48E0E4A3E598D19395DF4B3B95A72", hash_generated_method = "3810A038CC04030C6D42804020561BED")
    
public SizeFileComparator(boolean sumDirectoryContents) {
        this.sumDirectoryContents = sumDirectoryContents;
    }

    /**
     * Compare the length of two files.
     * 
     * @param file1 The first file to compare
     * @param file2 The second file to compare
     * @return a negative value if the first file's length
     * is less than the second, zero if the lengths are the
     * same and a positive value if the first files length
     * is greater than the second file.
     * 
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.550 -0400", hash_original_method = "ABA0E5A2C93CAE7FB231C0521EE3670F", hash_generated_method = "BA0BC47B135E42DFD56AF5B19141022D")
    
public int compare(File file1, File file2) {
        long size1 = 0;
        if (file1.isDirectory()) {
            size1 = sumDirectoryContents && file1.exists() ? FileUtils.sizeOfDirectory(file1) : 0;
        } else {
            size1 = file1.length();
        }
        long size2 = 0;
        if (file2.isDirectory()) {
            size2 = sumDirectoryContents && file2.exists() ? FileUtils.sizeOfDirectory(file2) : 0;
        } else {
            size2 = file2.length();
        }
        long result = size1 - size2;
        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * String representation of this file comparator.
     *
     * @return String representation of this file comparator
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.551 -0400", hash_original_method = "0C8A6A12A09534244BFD4B982DA5238A", hash_generated_method = "55385276BD3EFAA7B4E98CCBFBB71931")
    
@Override
    public String toString() {
        return super.toString() + "[sumDirectoryContents=" + sumDirectoryContents + "]";
    }
}
