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

import org.apache.commons.io.IOCase;

/**
 * Compare the <b>path</b> of two files for order (see {@link File#getPath()}).
 * <p>
 * This comparator can be used to sort lists or arrays of files
 * by their path either in a case-sensitive, case-insensitive or
 * system dependant case sensitive way. A number of singleton instances
 * are provided for the various case sensitivity options (using {@link IOCase})
 * and the reverse of those options.
 * <p>
 * Example of a <i>case-sensitive</i> file path sort using the
 * {@link #PATH_COMPARATOR} singleton instance:
 * <pre>
 *       List&lt;File&gt; list = ...
 *       PathFileComparator.PATH_COMPARATOR.sort(list);
 * </pre>
 * <p>
 * Example of a <i>reverse case-insensitive</i> file path sort using the
 * {@link #PATH_INSENSITIVE_REVERSE} singleton instance:
 * <pre>
 *       File[] array = ...
 *       PathFileComparator.PATH_INSENSITIVE_REVERSE.sort(array);
 * </pre>
 * <p>
 *
 * @version $Id: PathFileComparator.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @since 1.4
 */
public class PathFileComparator extends AbstractFileComparator implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.594 -0400", hash_original_field = "A842CE2F7087A4383C8ED0C61838C20E", hash_generated_field = "B08964A0E7C27188446ECA398E4B4E07")

    public static final Comparator<File> PATH_COMPARATOR = new PathFileComparator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.595 -0400", hash_original_field = "47C7751875CC065746E02032960B6214", hash_generated_field = "296D118EC0C72351357689CC8C91D1EA")

    public static final Comparator<File> PATH_REVERSE = new ReverseComparator(PATH_COMPARATOR);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.596 -0400", hash_original_field = "819D351EBBA603DF125FCD85D3A7F455", hash_generated_field = "F9249BFC7862694A7572BD0C9A5485F9")

    public static final Comparator<File> PATH_INSENSITIVE_COMPARATOR = new PathFileComparator(IOCase.INSENSITIVE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.596 -0400", hash_original_field = "1BD74C4D86457CBD87E3AB0F0C8B6F5E", hash_generated_field = "17C9DBD5661F5BA923DD880B8BDB755B")

    public static final Comparator<File> PATH_INSENSITIVE_REVERSE = new ReverseComparator(PATH_INSENSITIVE_COMPARATOR);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.597 -0400", hash_original_field = "EA1D6AC05280EF59C7F16C5D91FAA17E", hash_generated_field = "2641D8A71F0F7328A2831980F21996D9")

    public static final Comparator<File> PATH_SYSTEM_COMPARATOR = new PathFileComparator(IOCase.SYSTEM);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.597 -0400", hash_original_field = "A95882CCD2014E2973DB22C0CF60CCBC", hash_generated_field = "D4D5E171519FE601C443348BB4E5B546")

    public static final Comparator<File> PATH_SYSTEM_REVERSE = new ReverseComparator(PATH_SYSTEM_COMPARATOR);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.598 -0400", hash_original_field = "8680B2A624039D0FA36FFAFA61AFD32B", hash_generated_field = "21450A3017D0D6122C0877D57300E67A")

    private  IOCase caseSensitivity;

    /**
     * Construct a case sensitive file path comparator instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.598 -0400", hash_original_method = "22C4074A2C3937C6AB79C8A7BBF86F43", hash_generated_method = "2C4E56E5F39512C22C2A813013459B98")
    
public PathFileComparator() {
        this.caseSensitivity = IOCase.SENSITIVE;
    }

    /**
     * Construct a file path comparator instance with the specified case-sensitivity.
     *
     * @param caseSensitivity  how to handle case sensitivity, null means case-sensitive
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.599 -0400", hash_original_method = "F159246393BC6BD0D887FFAE2708CE6F", hash_generated_method = "8F62B2E5E762EB87C0EF7226A31B324A")
    
public PathFileComparator(IOCase caseSensitivity) {
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    /**
     * Compare the paths of two files the specified case sensitivity.
     * 
     * @param file1 The first file to compare
     * @param file2 The second file to compare
     * @return a negative value if the first file's path
     * is less than the second, zero if the paths are the
     * same and a positive value if the first files path
     * is greater than the second file.
     * 
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.599 -0400", hash_original_method = "E52DB31DD4CEA24D40EB558E5E7FE49E", hash_generated_method = "805BE676780F942EC24517F079CC8FC8")
    
public int compare(File file1, File file2) {
        return caseSensitivity.checkCompareTo(file1.getPath(), file2.getPath());
    }

    /**
     * String representation of this file comparator.
     *
     * @return String representation of this file comparator
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.600 -0400", hash_original_method = "2C8858F1FEF258A79F4059C0A1CB8058", hash_generated_method = "73DBD95B0639383FC78436A99232C748")
    
@Override
    public String toString() {
        return super.toString() + "[caseSensitivity=" + caseSensitivity + "]";
    }
}
