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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A {@link java.io.FileFilter} providing conditional OR logic across a list of
 * file filters. This filter returns {@code true} if any filters in the
 * list return {@code true}. Otherwise, it returns {@code false}.
 * Checking of the file filter list stops when the first filter returns
 * {@code true}.
 *
 * @since 1.0
 * @version $Id: OrFileFilter.java 1307462 2012-03-30 15:13:11Z ggregory $
 * @see FileFilterUtils#or(IOFileFilter...)
 */
public class OrFileFilter
        extends AbstractFileFilter
        implements ConditionalFileFilter, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.555 -0400", hash_original_field = "FB6BC58B079CB6060313253E29F6544E", hash_generated_field = "A093E0C3DE9323A661D0712F28EF5BF8")

    private  List<IOFileFilter> fileFilters;

    /**
     * Constructs a new instance of <code>OrFileFilter</code>.
     *
     * @since 1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.555 -0400", hash_original_method = "261B8A78A48F018A582463F22AA23698", hash_generated_method = "FB8C1CFC9EE357B44C33287CD64731D0")
    
public OrFileFilter() {
        this.fileFilters = new ArrayList<IOFileFilter>();
    }

    /**
     * Constructs a new instance of <code>OrFileFilter</code>
     * with the specified filters.
     *
     * @param fileFilters  the file filters for this filter, copied, null ignored
     * @since 1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.556 -0400", hash_original_method = "EF6E00E126C186B440F3A1423802E998", hash_generated_method = "F50A63B374EFBBE76B9662368892D6B8")
    
public OrFileFilter(final List<IOFileFilter> fileFilters) {
        if (fileFilters == null) {
            this.fileFilters = new ArrayList<IOFileFilter>();
        } else {
            this.fileFilters = new ArrayList<IOFileFilter>(fileFilters);
        }
    }

    /**
     * Constructs a new file filter that ORs the result of two other filters.
     * 
     * @param filter1  the first filter, must not be null
     * @param filter2  the second filter, must not be null
     * @throws IllegalArgumentException if either filter is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.556 -0400", hash_original_method = "B7ADCE9A3D3A09F26DDD24599D7121FB", hash_generated_method = "6B6A6D84DF362E5AC6B705BC3168F071")
    
public OrFileFilter(IOFileFilter filter1, IOFileFilter filter2) {
        if (filter1 == null || filter2 == null) {
            throw new IllegalArgumentException("The filters must not be null");
        }
        this.fileFilters = new ArrayList<IOFileFilter>(2);
        addFileFilter(filter1);
        addFileFilter(filter2);
    }

    /**
     * {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.557 -0400", hash_original_method = "82CBDB26DBAE7C3928EFB659443DD094", hash_generated_method = "CC471BC7923D5FC9EA03851326894D2B")
    
public void addFileFilter(final IOFileFilter ioFileFilter) {
        this.fileFilters.add(ioFileFilter);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.558 -0400", hash_original_method = "C6000DDE181BCE52214EEFCE5C901DFA", hash_generated_method = "CAF941C3518FEAF83EBEDF287523E8F9")
    
public List<IOFileFilter> getFileFilters() {
        return Collections.unmodifiableList(this.fileFilters);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.558 -0400", hash_original_method = "116FFFDA4CB65AECB7B5B648545FB2AD", hash_generated_method = "079EFC7DF82B8D0B3CD3F1EE7D540F73")
    
public boolean removeFileFilter(IOFileFilter ioFileFilter) {
        return this.fileFilters.remove(ioFileFilter);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.559 -0400", hash_original_method = "0158A95A6585441E62C5077FBAB9C8FC", hash_generated_method = "ECCA2697BA14A12C03983FD012B3BFC2")
    
public void setFileFilters(final List<IOFileFilter> fileFilters) {
        this.fileFilters.clear();
        this.fileFilters.addAll(fileFilters);
    }

    /**
     * {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.559 -0400", hash_original_method = "6C2FE5C9E9DD4CA7904EFF10D5A5AFDA", hash_generated_method = "54233D9382CC26F649E2389FDD862D2B")
    
@Override
    public boolean accept(final File file) {
        for (IOFileFilter fileFilter : fileFilters) {
            if (fileFilter.accept(file)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.560 -0400", hash_original_method = "FB679BDE148C743BEAFFC23053AC09E1", hash_generated_method = "9D8BFB717520401D0D9BCD8CFD859BBF")
    
@Override
    public boolean accept(final File file, final String name) {
        for (IOFileFilter fileFilter : fileFilters) {
            if (fileFilter.accept(file, name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Provide a String representaion of this file filter.
     *
     * @return a String representaion
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.560 -0400", hash_original_method = "1E761CCD4DDE3C2CB8242721D590B88B", hash_generated_method = "2F7B8A982A5FF60A8EC05A3E25C5A5B9")
    
@Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(super.toString());
        buffer.append("(");
        if (fileFilters != null) {
            for (int i = 0; i < fileFilters.size(); i++) {
                if (i > 0) {
                    buffer.append(",");
                }
                Object filter = fileFilters.get(i);
                buffer.append(filter == null ? "null" : filter.toString());
            }
        }
        buffer.append(")");
        return buffer.toString();
    }

}
