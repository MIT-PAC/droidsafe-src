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
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.Serializable;

/**
 * This class turns a Java FileFilter or FilenameFilter into an IO FileFilter.
 * 
 * @since 1.0
 * @version $Id: DelegateFileFilter.java 1304052 2012-03-22 20:55:29Z ggregory $
 * 
 * @see FileFilterUtils#asFileFilter(FileFilter)
 * @see FileFilterUtils#asFileFilter(FilenameFilter)
 */
public class DelegateFileFilter extends AbstractFileFilter implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.939 -0400", hash_original_field = "A6194BA6C7EAAB10B3BC796FE3B18284", hash_generated_field = "3508DB9A679B391304D72C5E2F8C7ED4")

    private  FilenameFilter filenameFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.940 -0400", hash_original_field = "E261F1A7BA60970EC32C0101727C4798", hash_generated_field = "C458D0AE68C90865AFA5E634223F0231")

    private  FileFilter fileFilter;

    /**
     * Constructs a delegate file filter around an existing FilenameFilter.
     * 
     * @param filter  the filter to decorate
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.940 -0400", hash_original_method = "06A6660F6D4FB6BA3833CB3AAC8DFB22", hash_generated_method = "049BA740F9079675A50AF06E16F6B47E")
    
public DelegateFileFilter(FilenameFilter filter) {
        if (filter == null) {
            throw new IllegalArgumentException("The FilenameFilter must not be null");
        }
        this.filenameFilter = filter;
        this.fileFilter = null;
    }

    /**
     * Constructs a delegate file filter around an existing FileFilter.
     * 
     * @param filter  the filter to decorate
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.941 -0400", hash_original_method = "D78E0EE5BCA43F28DAC7F37C22E8C1C2", hash_generated_method = "D0F51912C2E997A113B2FFAC46ED94F4")
    
public DelegateFileFilter(FileFilter filter) {
        if (filter == null) {
            throw new IllegalArgumentException("The FileFilter must not be null");
        }
        this.fileFilter = filter;
        this.filenameFilter = null;
    }

    /**
     * Checks the filter.
     * 
     * @param file  the file to check
     * @return true if the filter matches
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.942 -0400", hash_original_method = "66B0B66E42A219E5BE68409D81797981", hash_generated_method = "6BD1834286C3D9588B2C22BBE55956C1")
    
@Override
    public boolean accept(File file) {
        if (fileFilter != null) {
            return fileFilter.accept(file);
        } else {
            return super.accept(file);
        }
    }

    /**
     * Checks the filter.
     * 
     * @param dir  the directory
     * @param name  the filename in the directory
     * @return true if the filter matches
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.942 -0400", hash_original_method = "49013355B881E412B579D906E9AC6664", hash_generated_method = "74332A0658EDB6DE54B62DC0D060A9D4")
    
@Override
    public boolean accept(File dir, String name) {
        if (filenameFilter != null) {
            return filenameFilter.accept(dir, name);
        } else {
            return super.accept(dir, name);
        }
    }

    /**
     * Provide a String representaion of this file filter.
     *
     * @return a String representaion
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.943 -0400", hash_original_method = "91D8A9301108FBA1FFC97CB499D3FAE9", hash_generated_method = "4D57C0D45B1B57478E35779613AE539B")
    
@Override
    public String toString() {
        String delegate = fileFilter != null ? fileFilter.toString() : filenameFilter.toString(); 
        return super.toString() + "(" + delegate + ")";
    }
    
}
