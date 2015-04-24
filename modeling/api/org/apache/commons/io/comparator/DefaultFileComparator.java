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
 * Compare two files using the <b>default</b> {@link File#compareTo(File)} method.
 * <p>
 * This comparator can be used to sort lists or arrays of files
 * by using the default file comparison.
 * <p>
 * Example of sorting a list of files using the
 * {@link #DEFAULT_COMPARATOR} singleton instance:
 * <pre>
 *       List&lt;File&gt; list = ...
 *       DefaultFileComparator.DEFAULT_COMPARATOR.sort(list);
 * </pre>
 * <p>
 * Example of doing a <i>reverse</i> sort of an array of files using the
 * {@link #DEFAULT_REVERSE} singleton instance:
 * <pre>
 *       File[] array = ...
 *       DefaultFileComparator.DEFAULT_REVERSE.sort(array);
 * </pre>
 * <p>
 *
 * @version $Id: DefaultFileComparator.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @since 1.4
 */
public class DefaultFileComparator extends AbstractFileComparator implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.613 -0400", hash_original_field = "D840692F190B6C4776AF5040340CB735", hash_generated_field = "BD08CF01AE944331506678C97C8F66A6")

    public static final Comparator<File> DEFAULT_COMPARATOR = new DefaultFileComparator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.614 -0400", hash_original_field = "93B9D998FC05A8C4AE3A4B61FE7ECE6D", hash_generated_field = "DB61B4883E186B99B29B96328A75930B")

    public static final Comparator<File> DEFAULT_REVERSE = new ReverseComparator(DEFAULT_COMPARATOR);

    /**
     * Compare the two files using the {@link File#compareTo(File)} method.
     * 
     * @param file1 The first file to compare
     * @param file2 The second file to compare
     * @return the result of calling file1's
     * {@link File#compareTo(File)} with file2 as the parameter.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.614 -0400", hash_original_method = "66E95E24BE0C08C51B59821FA4A7134C", hash_generated_method = "E7614E31C0996941EF37E3D9277E3BCD")
    
public int compare(File file1, File file2) {
        return file1.compareTo(file2);
    }
}
