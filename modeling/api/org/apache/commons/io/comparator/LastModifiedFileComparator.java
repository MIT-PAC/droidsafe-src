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

/**
 * Compare the <b>last modified date/time</b> of two files for order 
 * (see {@link File#lastModified()}).
 * <p>
 * This comparator can be used to sort lists or arrays of files
 * by their last modified date/time.
 * <p>
 * Example of sorting a list of files using the
 * {@link #LASTMODIFIED_COMPARATOR} singleton instance:
 * <pre>
 *       List&lt;File&gt; list = ...
 *       LastModifiedFileComparator.LASTMODIFIED_COMPARATOR.sort(list);
 * </pre>
 * <p>
 * Example of doing a <i>reverse</i> sort of an array of files using the
 * {@link #LASTMODIFIED_REVERSE} singleton instance:
 * <pre>
 *       File[] array = ...
 *       LastModifiedFileComparator.LASTMODIFIED_REVERSE.sort(array);
 * </pre>
 * <p>
 *
 * @version $Id: LastModifiedFileComparator.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @since 1.4
 */
public class LastModifiedFileComparator extends AbstractFileComparator implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.625 -0400", hash_original_field = "F17EE750F0117437F77CC8C48D19B840", hash_generated_field = "94023D28CB355D93C34C3C54C9AD3C6F")

    public static final Comparator<File> LASTMODIFIED_COMPARATOR = new LastModifiedFileComparator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.625 -0400", hash_original_field = "04153C5CCDD9B909A7791CADC4ED2CB4", hash_generated_field = "C065146AFEFC52527628CE9F33D912DD")

    public static final Comparator<File> LASTMODIFIED_REVERSE = new ReverseComparator(LASTMODIFIED_COMPARATOR);

    /**
     * Compare the last the last modified date/time of two files.
     * 
     * @param file1 The first file to compare
     * @param file2 The second file to compare
     * @return a negative value if the first file's lastmodified date/time
     * is less than the second, zero if the lastmodified date/time are the
     * same and a positive value if the first files lastmodified date/time
     * is greater than the second file.
     * 
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.626 -0400", hash_original_method = "2A7F9A9DA1FD0DBF21511D990BEE362C", hash_generated_method = "FE1132ACCFCDFD691364FDB357310B1A")
    
public int compare(File file1, File file2) {
        long result = file1.lastModified() - file2.lastModified();
        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
