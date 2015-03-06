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
 * This filter accepts <code>File</code>s that can be written to.
 * <p>
 * Example, showing how to print out a list of the
 * current directory's <i>writable</i> files:
 *
 * <pre>
 * File dir = new File(".");
 * String[] files = dir.list( CanWriteFileFilter.CAN_WRITE );
 * for ( int i = 0; i &lt; files.length; i++ ) {
 *     System.out.println(files[i]);
 * }
 * </pre>
 *
 * <p>
 * Example, showing how to print out a list of the
 * current directory's <i>un-writable</i> files:
 *
 * <pre>
 * File dir = new File(".");
 * String[] files = dir.list( CanWriteFileFilter.CANNOT_WRITE );
 * for ( int i = 0; i &lt; files.length; i++ ) {
 *     System.out.println(files[i]);
 * }
 * </pre>
 *
 * <p>
 * <b>N.B.</b> For read-only files, use 
 *    <code>CanReadFileFilter.READ_ONLY</code>.
 *
 * @since 1.3
 * @version $Id: CanWriteFileFilter.java 1307462 2012-03-30 15:13:11Z ggregory $
 */
public class CanWriteFileFilter extends AbstractFileFilter implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.484 -0400", hash_original_field = "3191EE4F93E574A9E6A83640B199C50D", hash_generated_field = "A3964A58D6B3E2E13859E9158683D5C1")

    public static final IOFileFilter CAN_WRITE = new CanWriteFileFilter();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.484 -0400", hash_original_field = "28517283F3CAB0B16A1D131575A89C4F", hash_generated_field = "85C2AAC3B405DA292BEEC74A1FADE62C")

    public static final IOFileFilter CANNOT_WRITE = new NotFileFilter(CAN_WRITE);

    /**
     * Restrictive consructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.485 -0400", hash_original_method = "AE68C1645286560831358DD2BB3F1723", hash_generated_method = "91E429D82F8C1189894B356A843378F9")
    
protected CanWriteFileFilter() {
    }
    
    /**
     * Checks to see if the file can be written to.
     * 
     * @param file  the File to check
     * @return {@code true} if the file can be
     *  written to, otherwise {@code false}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.485 -0400", hash_original_method = "B6CCE4550C29DDD6A02AB62B3A5D936A", hash_generated_method = "979F94608D9916FD462CA7E4AAD1B55D")
    
@Override
    public boolean accept(File file) {
        return file.canWrite();
    }
    
}
