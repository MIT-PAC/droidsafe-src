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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/impl/io/SocketInputBuffer.java $
 * $Revision: 560358 $
 * $Date: 2007-07-27 12:30:42 -0700 (Fri, 27 Jul 2007) $
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketTimeoutException;

import org.apache.http.params.HttpParams;




public class SocketInputBuffer extends AbstractSessionInputBuffer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.146 -0500", hash_original_field = "5019B3EE05D6098E4ECE32F00F7F88CA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")


    private  Socket socket;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.149 -0500", hash_original_method = "7283DB9E346A36B4239C51041B32EE66", hash_generated_method = "589AA70F20F0C29C0CEDB39CA43959BC")
    
public SocketInputBuffer(
            final Socket socket,
            int buffersize,
            final HttpParams params) throws IOException {
        super();
        if (socket == null) {
            throw new IllegalArgumentException("Socket may not be null");
        }
        this.socket = socket;
        // BEGIN android-changed
        // Workaround for http://b/3514259. We take 'buffersize' as a hint in
        // the weakest sense, and always use an 8KiB heap buffer and leave the
        // kernel buffer size alone, trusting the system to have set a
        // network-appropriate default.
        init(socket.getInputStream(), 8192, params);
        // END android-changed
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.151 -0500", hash_original_method = "311ACBA3C6B98FE9C535127054B24088", hash_generated_method = "A078C5AF499E827D5762FC0B5E1D7F31")
    
public boolean isDataAvailable(int timeout) throws IOException {
        boolean result = hasBufferedData();
        if (!result) {
            int oldtimeout = this.socket.getSoTimeout();
            try {
                this.socket.setSoTimeout(timeout);
                fillBuffer();
                result = hasBufferedData();
            } catch (InterruptedIOException e) {
                if (!(e instanceof SocketTimeoutException)) {
                    throw e;
                }
            } finally {
                socket.setSoTimeout(oldtimeout);
            }
        }
        return result;
    }    
        
    // BEGIN android-added
    /**
     * Returns true if the connection is probably functional. It's insufficient
     * to rely on isDataAvailable() returning normally; that approach cannot
     * distinguish between an exhausted stream and a stream with zero bytes
     * buffered.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.154 -0500", hash_original_method = "60456E7A862D179906482739ACBD4572", hash_generated_method = "1FED05F39E3BB61C72DF3B048AB4D949")
    
public boolean isStale() throws IOException {
        if (hasBufferedData()) {
            return false;
        }
        int oldTimeout = this.socket.getSoTimeout();
        try {
            this.socket.setSoTimeout(1);
            return fillBuffer() == -1;
        } catch (SocketTimeoutException e) {
            return false; // the connection is not stale; hooray
        } catch (IOException e) {
            return true; // the connection is stale, the read or soTimeout failed.
        } finally {
            this.socket.setSoTimeout(oldTimeout);
        }
    }

    
}

