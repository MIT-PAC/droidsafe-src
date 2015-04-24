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
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteBuffer;

import javax.net.ssl.SSLException;

public class SSLEngineAppData implements org.apache.harmony.xnet.provider.jsse.Appendable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.803 -0500", hash_original_field = "3923F3F9F9ECABE8D28493E863FC2CD8", hash_generated_field = "3923F3F9F9ECABE8D28493E863FC2CD8")

    byte[] buffer;

    /**
     * Constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.806 -0500", hash_original_method = "06EACE6E653645104AEC16265D727782", hash_generated_method = "1BA161F1DDD021955650564C16242D36")
    
protected SSLEngineAppData() {}

    /**
     * Stores received data. The source data is not cloned,
     * just the array reference is remembered into the buffer field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.808 -0500", hash_original_method = "452DC75F155E1CC98FB8D0CBD4BB0B6D", hash_generated_method = "4E7BB90CD6FCB70AE2C45964E3FC6C49")
    
public void append(byte[] src) {
        if (buffer != null) {
            throw new AlertException(
                AlertProtocol.INTERNAL_ERROR,
                new SSLException("Attempt to override the data"));
        }
        buffer = src;
    }

    /**
     * Places the data from the buffer into the array of destination
     * ByteBuffer objects.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.810 -0500", hash_original_method = "26A62B68A47AD8599D541EA0EB845FD0", hash_generated_method = "4002D46B7AD683EE775D89C25FEC1BD4")
    
protected int placeTo(ByteBuffer[] dsts, int offset, int length) {
        if (buffer == null) {
            return 0;
        }
        int pos = 0;
        int len = buffer.length;
        int rem;
        // write data to the buffers
        for (int i=offset; i<offset+length; i++) {
            rem = dsts[i].remaining();
            // TODO: optimization work - use hasArray, array(), arraycopy
            if (len - pos < rem) {
                // can fully write remaining data into buffer
                dsts[i].put(buffer, pos, len - pos);
                pos = len;
                // data was written, exit
                break;
            }
            // write chunk of data
            dsts[i].put(buffer, pos, rem);
            pos += rem;
        }
        if (pos != len) {
            // The data did not feet into the buffers,
            // it should not happen, because the destination buffers
            // had been checked for the space before record unwrapping.
            // But if it so, we should allert about internal error.
            throw new AlertException(
                AlertProtocol.INTERNAL_ERROR,
                new SSLException(
                    "The received application data could not be fully written"
                    + "into the destination buffers"));
        }
        buffer = null;
        return len;
    }
    
}

