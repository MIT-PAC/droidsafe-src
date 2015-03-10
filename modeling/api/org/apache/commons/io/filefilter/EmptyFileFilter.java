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


package org.apache.commons.io.filefilter;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.File;
import java.io.Serializable;

/**
 * This filter accepts files or directories that are empty.
 * <p>
 * If the <code>File</code> is a directory it checks that
 * it contains no files.
 * <p>
 * Example, showing how to print out a list of the 
 * current directory's empty files/directories:
 *
 * <pre>
 * File dir = new File(".");
 * String[] files = dir.list( EmptyFileFilter.EMPTY );
 * for ( int i = 0; i &lt; files.length; i++ ) {
 *     System.out.println(files[i]);
 * }
 * </pre>
 *
 * <p>
 * Example, showing how to print out a list of the 
 * current directory's non-empty files/directories:
 *
 * <pre>
 * File dir = new File(".");
 * String[] files = dir.list( EmptyFileFilter.NOT_EMPTY );
 * for ( int i = 0; i &lt; files.length; i++ ) {
 *     System.out.println(files[i]);
 * }
 * </pre>
 *
 * @since 1.3
 * @version $Id: EmptyFileFilter.java 1307462 2012-03-30 15:13:11Z ggregory $
 */
public class EmptyFileFilter extends AbstractFileFilter implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.729 -0400", hash_original_field = "725BA65AC687FF99DD3CE89B705FFF9F", hash_generated_field = "F29DC327EE24EE9447F5DFA9FF269BB1")

    public static final IOFileFilter EMPTY = new EmptyFileFilter();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.730 -0400", hash_original_field = "973C1B285F16AFBD6F724D546F3779F1", hash_generated_field = "2EEDE478EC7A9AD9630A131280F6556D")

    public static final IOFileFilter NOT_EMPTY = new NotFileFilter(EMPTY);
    
    /**
     * Restrictive consructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.730 -0400", hash_original_method = "9BC06F7377A0DB1FDB0822C77016180F", hash_generated_method = "FB48DC1C3391AF406BD5DE4EBC9D775D")
    
protected EmptyFileFilter() {
    }
    
    /**
     * Checks to see if the file is empty.
     * 
     * @param file  the file or directory to check
     * @return {@code true} if the file or directory
     *  is <i>empty</i>, otherwise {@code false}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.731 -0400", hash_original_method = "5C49B996D079DB6527DA00AF822DC40F", hash_generated_method = "5624A64A7FDD26CB713D3EDF643DAEE8")
    
@Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            return files == null || files.length == 0;
        } else {
            return file.length() == 0;
        }
    }
    
}
