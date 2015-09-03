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


package org.apache.commons.io.output;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.OutputStream;

/**
 * A decorating output stream that counts the number of bytes that have passed
 * through the stream so far.
 * <p>
 * A typical use case would be during debugging, to ensure that data is being
 * written as expected.
 *
 * @version $Id: CountingOutputStream.java 1304052 2012-03-22 20:55:29Z ggregory $
 */
public class CountingOutputStream extends ProxyOutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.691 -0400", hash_original_field = "26F4B1DCB1A00DCCDC852349C8E6E495", hash_generated_field = "F29FC271FD334863B167C81AE0015DDD")

    private long count = 0;

    /**
     * Constructs a new CountingOutputStream.
     * 
     * @param out  the OutputStream to write to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.692 -0400", hash_original_method = "1D97F6B1ACCFDEF880E62EA3C5F540FF", hash_generated_method = "3A0DEAC646F2AAD0946D9AAA7DF97B17")
    
public CountingOutputStream( OutputStream out ) {
        super(out);
    }

    //-----------------------------------------------------------------------

    /**
     * Updates the count with the number of bytes that are being written.
     *
     * @param n number of bytes to be written to the stream
     * @since 2.0
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.692 -0400", hash_original_method = "06A3A1AA076BADB04E4D922D26953A96", hash_generated_method = "F3F51984BE10A496D3376E237FC9D1AB")
    
@Override
    protected synchronized void beforeWrite(int n) {
        count += n;
    }

    //-----------------------------------------------------------------------
    /**
     * The number of bytes that have passed through this stream.
     * <p>
     * NOTE: From v1.3 this method throws an ArithmeticException if the
     * count is greater than can be expressed by an <code>int</code>.
     * See {@link #getByteCount()} for a method using a <code>long</code>.
     *
     * @return the number of bytes accumulated
     * @throws ArithmeticException if the byte count is too large
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.693 -0400", hash_original_method = "C00FD02DE13770738E0B8BA4159C30F2", hash_generated_method = "430987FA62A0966875A62EFB32902E5F")
    
public int getCount() {
        long result = getByteCount();
        if (result > Integer.MAX_VALUE) {
            throw new ArithmeticException("The byte count " + result + " is too large to be converted to an int");
        }
        return (int) result;
    }

    /** 
     * Set the byte count back to 0. 
     * <p>
     * NOTE: From v1.3 this method throws an ArithmeticException if the
     * count is greater than can be expressed by an <code>int</code>.
     * See {@link #resetByteCount()} for a method using a <code>long</code>.
     *
     * @return the count previous to resetting
     * @throws ArithmeticException if the byte count is too large
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.694 -0400", hash_original_method = "F5B53F118A4CD127E2B80EC107F6232B", hash_generated_method = "0A6F5852DC9260AFE190B76FC54E6E94")
    
public int resetCount() {
        long result = resetByteCount();
        if (result > Integer.MAX_VALUE) {
            throw new ArithmeticException("The byte count " + result + " is too large to be converted to an int");
        }
        return (int) result;
    }

    /**
     * The number of bytes that have passed through this stream.
     * <p>
     * NOTE: This method is an alternative for <code>getCount()</code>.
     * It was added because that method returns an integer which will
     * result in incorrect count for files over 2GB.
     *
     * @return the number of bytes accumulated
     * @since 1.3
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.694 -0400", hash_original_method = "D4B641936093CD491A905A89AC9170C1", hash_generated_method = "0B2C938D13BA6DA3FD429D302C917749")
    
public synchronized long getByteCount() {
        return this.count;
    }

    /** 
     * Set the byte count back to 0. 
     * <p>
     * NOTE: This method is an alternative for <code>resetCount()</code>.
     * It was added because that method returns an integer which will
     * result in incorrect count for files over 2GB.
     *
     * @return the count previous to resetting
     * @since 1.3
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.695 -0400", hash_original_method = "B4FA3AE06204AB7289DB84225F541AF1", hash_generated_method = "ADC309CA8828389521AD207F87DEF6F3")
    
public synchronized long resetByteCount() {
        long tmp = this.count;
        this.count = 0;
        return tmp;
    }

}
