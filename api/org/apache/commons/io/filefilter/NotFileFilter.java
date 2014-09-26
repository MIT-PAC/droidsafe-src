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
 * This filter produces a logical NOT of the filters specified.
 *
 * @since 1.0
 * @version $Id: NotFileFilter.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @see FileFilterUtils#notFileFilter(IOFileFilter)
 */
public class NotFileFilter extends AbstractFileFilter implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.656 -0400", hash_original_field = "428FD765403EA95E7B0CA86956C65A96", hash_generated_field = "52033831AA90808CFA0612D7E68F3072")

    private  IOFileFilter filter;

    /**
     * Constructs a new file filter that NOTs the result of another filter.
     * 
     * @param filter  the filter, must not be null
     * @throws IllegalArgumentException if the filter is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.656 -0400", hash_original_method = "04147093F1D1C98977C291FCABD47396", hash_generated_method = "9B99B116A9728DAD06DCE6A26F06ADFF")
    
public NotFileFilter(IOFileFilter filter) {
        if (filter == null) {
            throw new IllegalArgumentException("The filter must not be null");
        }
        this.filter = filter;
    }

    /**
     * Returns the logical NOT of the underlying filter's return value for the same File.
     * 
     * @param file  the File to check
     * @return true if the filter returns false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.657 -0400", hash_original_method = "B4759F01CF5E4CDF4AA4061B5D979652", hash_generated_method = "C02ACDC6ABE91F179513EE3945969CFE")
    
@Override
    public boolean accept(File file) {
        return ! filter.accept(file);
    }
    
    /**
     * Returns the logical NOT of the underlying filter's return value for the same arguments.
     * 
     * @param file  the File directory
     * @param name  the filename
     * @return true if the filter returns false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.657 -0400", hash_original_method = "B0A127C96A64726487AA51E16A0E3CC5", hash_generated_method = "FF66116A90D47F0E1CA729B601FC7903")
    
@Override
    public boolean accept(File file, String name) {
        return ! filter.accept(file, name);
    }

    /**
     * Provide a String representaion of this file filter.
     *
     * @return a String representaion
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.658 -0400", hash_original_method = "0F98CEE5769F2D254ED7C2ED79018DD6", hash_generated_method = "2BE1FE74C79C5C68C6CD84831DB7FE3F")
    
@Override
    public String toString() {
        return super.toString() + "(" + filter.toString()  + ")";
    }
    
}
