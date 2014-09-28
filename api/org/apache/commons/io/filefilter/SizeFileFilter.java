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
 * Filters files based on size, can filter either smaller files or
 * files equal to or larger than a given threshold.
 * <p>
 * For example, to print all files and directories in the
 * current directory whose size is greater than 1 MB:
 *
 * <pre>
 * File dir = new File(".");
 * String[] files = dir.list( new SizeFileFilter(1024 * 1024) );
 * for ( int i = 0; i &lt; files.length; i++ ) {
 *     System.out.println(files[i]);
 * }
 * </pre>
 *
 * @version $Id: SizeFileFilter.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @since 1.2
 * @see FileFilterUtils#sizeFileFilter(long)
 * @see FileFilterUtils#sizeFileFilter(long, boolean)
 * @see FileFilterUtils#sizeRangeFileFilter(long, long)
 */
public class SizeFileFilter extends AbstractFileFilter implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.820 -0400", hash_original_field = "298A39EB1E059FD1DCE8DF5205BAB3E6", hash_generated_field = "CB917F06730B11F4BAAAFECA2C1D90A2")

    private  long size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.820 -0400", hash_original_field = "8CCD75AD7DD594FCC495CE870A3C2C1B", hash_generated_field = "A18E88D88160DB836B3E001438D9A208")

    private  boolean acceptLarger;

    /**
     * Constructs a new size file filter for files equal to or 
     * larger than a certain size.
     *
     * @param size  the threshold size of the files
     * @throws IllegalArgumentException if the size is negative
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.821 -0400", hash_original_method = "4719DD4974D08080A970216FF9540658", hash_generated_method = "7D94F55CE412414050F7792B57136DF3")
    
public SizeFileFilter(long size) {
        this(size, true);
    }

    /**
     * Constructs a new size file filter for files based on a certain size
     * threshold.
     *
     * @param size  the threshold size of the files
     * @param acceptLarger  if true, files equal to or larger are accepted,
     * otherwise smaller ones (but not equal to)
     * @throws IllegalArgumentException if the size is negative
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.822 -0400", hash_original_method = "6B587AAF95AB16F29075A6F84F0CB503", hash_generated_method = "2AA0CBCCEA11688643A1435A2354678F")
    
public SizeFileFilter(long size, boolean acceptLarger) {
        if (size < 0) {
            throw new IllegalArgumentException("The size must be non-negative");
        }
        this.size = size;
        this.acceptLarger = acceptLarger;
    }

    //-----------------------------------------------------------------------
    /**
     * Checks to see if the size of the file is favorable.
     * <p>
     * If size equals threshold and smaller files are required,
     * file <b>IS NOT</b> selected.
     * If size equals threshold and larger files are required,
     * file <b>IS</b> selected.
     *
     * @param file  the File to check
     * @return true if the filename matches
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.823 -0400", hash_original_method = "13EB4F7103C9E58EC2AD605053CF5788", hash_generated_method = "04EAA1D3BAE93CD85D2EFFC337CD1254")
    
@Override
    public boolean accept(File file) {
        boolean smaller = file.length() < size;
        return acceptLarger ? !smaller : smaller;
    }

    /**
     * Provide a String representaion of this file filter.
     *
     * @return a String representaion
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.823 -0400", hash_original_method = "9CC552A05DC39BBA2C336B2A0E87E39E", hash_generated_method = "4429D936EF256217F3103D9C077ECE75")
    
@Override
    public String toString() {
        String condition = acceptLarger ? ">=" : "<";
        return super.toString() + "(" + condition + size + ")";
    }

}
