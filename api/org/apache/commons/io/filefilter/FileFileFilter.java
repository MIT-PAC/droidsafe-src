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
package org.apache.commons.io.filefilter;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.File;
import java.io.Serializable;

/**
 * This filter accepts <code>File</code>s that are files (not directories).
 * <p>
 * For example, here is how to print out a list of the real files
 * within the current directory:
 *
 * <pre>
 * File dir = new File(".");
 * String[] files = dir.list( FileFileFilter.FILE );
 * for ( int i = 0; i &lt; files.length; i++ ) {
 *     System.out.println(files[i]);
 * }
 * </pre>
 *
 * @since 1.3
 * @version $Id: FileFileFilter.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @see FileFilterUtils#fileFileFilter()
 */
public class FileFileFilter extends AbstractFileFilter implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.719 -0400", hash_original_field = "EA3563334B4E9AF908AE055361F63B1C", hash_generated_field = "92710DC7C7D00B54B62B3FA27DB38D86")

    public static final IOFileFilter FILE = new FileFileFilter();

    /**
     * Restrictive consructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.719 -0400", hash_original_method = "6C359A458FCB96D5F455747E20D28BA8", hash_generated_method = "FF5FBB3C9B25FA86DA298D4CA53E5A12")
    
protected FileFileFilter() {
    }

    /**
     * Checks to see if the file is a file.
     *
     * @param file  the File to check
     * @return true if the file is a file
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.720 -0400", hash_original_method = "981FD37767829C6F7D8558BD0416446C", hash_generated_method = "EF53AA7565D23EFB8E8E742395670F3B")
    
@Override
    public boolean accept(File file) {
        return file.isFile();
    }

}
