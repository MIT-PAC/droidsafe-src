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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A {@link java.io.FileFilter} providing conditional AND logic across a list of
 * file filters. This filter returns {@code true} if all filters in the
 * list return {@code true}. Otherwise, it returns {@code false}.
 * Checking of the file filter list stops when the first filter returns
 * {@code false}.
 *
 * @since 1.0
 * @version $Id: AndFileFilter.java 1307462 2012-03-30 15:13:11Z ggregory $
 *
 * @see FileFilterUtils#and(IOFileFilter...)
 */
public class AndFileFilter
        extends AbstractFileFilter
        implements ConditionalFileFilter, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.518 -0400", hash_original_field = "FB6BC58B079CB6060313253E29F6544E", hash_generated_field = "A093E0C3DE9323A661D0712F28EF5BF8")

    private  List<IOFileFilter> fileFilters;

    /**
     * Constructs a new instance of <code>AndFileFilter</code>.
     *
     * @since 1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.519 -0400", hash_original_method = "D69D2D85CE24AE2BFF71755854F84C3E", hash_generated_method = "83F1AA0554504DB97209E7C3EDDB1001")
    
public AndFileFilter() {
        this.fileFilters = new ArrayList<IOFileFilter>();
    }

    /**
     * Constructs a new instance of <code>AndFileFilter</code>
     * with the specified list of filters.
     *
     * @param fileFilters  a List of IOFileFilter instances, copied, null ignored
     * @since 1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.519 -0400", hash_original_method = "EACF8E2DE294FEF43D3A3F18958358BB", hash_generated_method = "E8700504289C56C16DB5F0E6411ECFFD")
    
public AndFileFilter(final List<IOFileFilter> fileFilters) {
        if (fileFilters == null) {
            this.fileFilters = new ArrayList<IOFileFilter>();
        } else {
            this.fileFilters = new ArrayList<IOFileFilter>(fileFilters);
        }
    }

    /**
     * Constructs a new file filter that ANDs the result of two other filters.
     *
     * @param filter1  the first filter, must not be null
     * @param filter2  the second filter, must not be null
     * @throws IllegalArgumentException if either filter is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.520 -0400", hash_original_method = "83B5DD90D38611D3F0D0ED1F1E9B5BE5", hash_generated_method = "05BD8B19BCDF6E165D420497223EF200")
    
public AndFileFilter(IOFileFilter filter1, IOFileFilter filter2) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.521 -0400", hash_original_method = "82CBDB26DBAE7C3928EFB659443DD094", hash_generated_method = "CC471BC7923D5FC9EA03851326894D2B")
    
public void addFileFilter(final IOFileFilter ioFileFilter) {
        this.fileFilters.add(ioFileFilter);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.521 -0400", hash_original_method = "C6000DDE181BCE52214EEFCE5C901DFA", hash_generated_method = "CAF941C3518FEAF83EBEDF287523E8F9")
    
public List<IOFileFilter> getFileFilters() {
        return Collections.unmodifiableList(this.fileFilters);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.522 -0400", hash_original_method = "4066AB1778964D409D441B7FA60F3C00", hash_generated_method = "6A4196024BA8DD83A9FC8A3E2E7ED3E3")
    
public boolean removeFileFilter(final IOFileFilter ioFileFilter) {
        return this.fileFilters.remove(ioFileFilter);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.522 -0400", hash_original_method = "0158A95A6585441E62C5077FBAB9C8FC", hash_generated_method = "ECCA2697BA14A12C03983FD012B3BFC2")
    
public void setFileFilters(final List<IOFileFilter> fileFilters) {
        this.fileFilters.clear();
        this.fileFilters.addAll(fileFilters);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.523 -0400", hash_original_method = "15185D73968973515F4C212ED777AF75", hash_generated_method = "3A21D591C6B2C3738307FE36902362AC")
    
@Override
    public boolean accept(final File file) {
        if (this.fileFilters.isEmpty()) {
            return false;
        }
        for (IOFileFilter fileFilter : fileFilters) {
            if (!fileFilter.accept(file)) {
                return false;
            }
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.523 -0400", hash_original_method = "A3F03C923F515CB961B8B37439B16718", hash_generated_method = "C8B3583BEEB87F414ADC6ED553CE7728")
    
@Override
    public boolean accept(final File file, final String name) {
        if (this.fileFilters.isEmpty()) {
            return false;
        }
        for (IOFileFilter fileFilter : fileFilters) {
            if (!fileFilter.accept(file, name)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Provide a String representaion of this file filter.
     *
     * @return a String representaion
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.524 -0400", hash_original_method = "1E761CCD4DDE3C2CB8242721D590B88B", hash_generated_method = "2F7B8A982A5FF60A8EC05A3E25C5A5B9")
    
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
