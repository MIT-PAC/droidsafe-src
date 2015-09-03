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
 * This filter accepts <code>File</code>s that are directories.
 * <p>
 * For example, here is how to print out a list of the 
 * current directory's subdirectories:
 *
 * <pre>
 * File dir = new File(".");
 * String[] files = dir.list( DirectoryFileFilter.INSTANCE );
 * for ( int i = 0; i &lt; files.length; i++ ) {
 *     System.out.println(files[i]);
 * }
 * </pre>
 *
 * @since 1.0
 * @version $Id: DirectoryFileFilter.java 1304052 2012-03-22 20:55:29Z ggregory $
 *
 * @see FileFilterUtils#directoryFileFilter()
 */
public class DirectoryFileFilter extends AbstractFileFilter implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.956 -0400", hash_original_field = "8D941F51726D67CC0AA177B14155E0DA", hash_generated_field = "FFBDC809D4125F87CAD18CEFA7FC4B5F")

    public static final IOFileFilter DIRECTORY = new DirectoryFileFilter();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.957 -0400", hash_original_field = "C3F5A0911387378F9A9EDF3AD0A804FD", hash_generated_field = "459FDE62E0410679E44CF019FA244A16")

    public static final IOFileFilter INSTANCE = DIRECTORY;

    /**
     * Restrictive consructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.957 -0400", hash_original_method = "271A2DD2196E2818F8A34D7CEDB3A1A7", hash_generated_method = "1AEBBEF9238E835B53A42A5BB484E020")
    
protected DirectoryFileFilter() {
    }

    /**
     * Checks to see if the file is a directory.
     *
     * @param file  the File to check
     * @return true if the file is a directory
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.958 -0400", hash_original_method = "39BD0BE636DBD4121253CD6DED7A982C", hash_generated_method = "38E65DCA80F99797FB8222FC438693DD")
    
@Override
    public boolean accept(File file) {
        return file.isDirectory();
    }

}
