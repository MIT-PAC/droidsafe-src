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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/entity/InputStreamEntity.java $
 * $Revision: 617591 $
 * $Date: 2008-02-01 10:21:17 -0800 (Fri, 01 Feb 2008) $
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


package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamEntity extends AbstractHttpEntity {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.486 -0500", hash_original_field = "3FB102CF00D4B531C2E12F98A5BDDBFE", hash_generated_field = "6E2192BB486EB38AA227C1403F5C8AE0")

    private final static int BUFFER_SIZE = 2048;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.488 -0500", hash_original_field = "843941CC0104424A71E5291E659CC007", hash_generated_field = "E10265C22C3282384A3FF9B20A322BFE")

    private  InputStream content;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.491 -0500", hash_original_field = "D634AAE75ADF86F4EAAC1CC85A8379F4", hash_generated_field = "C62D106264E132930C7955708C9A9CDD")

    private  long length;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.493 -0500", hash_original_field = "66F53B84670B0CD1C8A9DA4B819094E4", hash_generated_field = "7CAB7C0CCDF9ABBB1D6144ACE3ECB9F8")

    private boolean consumed = false;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.495 -0500", hash_original_method = "9ECB63D0474F50482B9F88A6526A3761", hash_generated_method = "C42E460FAD8B2A761A1240B41FBA53CF")
    
public InputStreamEntity(final InputStream instream, long length) {
        super();        
        if (instream == null) {
            throw new IllegalArgumentException("Source input stream may not be null");
        }
        this.content = instream;
        this.length = length;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.497 -0500", hash_original_method = "731D88F5D8865617BA362DCED4C30896", hash_generated_method = "ED09A364E94A90F3E23A91DCC44E26ED")
    
public boolean isRepeatable() {
        return false;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.500 -0500", hash_original_method = "120309BFFDD6935F8B30886147626A04", hash_generated_method = "9233A3153FC331D80C5DADB9AF36C94A")
    
public long getContentLength() {
        return this.length;
    }

    @DSSafe(DSCat.NETWORK)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.502 -0500", hash_original_method = "ED2F9B5D6194544F22CDAF63FF5B39F6", hash_generated_method = "6B5E40E201EA1F5BBF016DD855C63153")
    
public InputStream getContent() throws IOException {
        return this.content;
    }
        
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.505 -0500", hash_original_method = "094DB6B8612142F129E3320AF13B6EB0", hash_generated_method = "F5ACA9FD9E8C6A255CD8C3D4824ED383")
    
public void writeTo(final OutputStream outstream) throws IOException {
        if (outstream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        InputStream instream = this.content;
        byte[] buffer = new byte[BUFFER_SIZE];
        int l;
        if (this.length < 0) {
            // consume until EOF
            while ((l = instream.read(buffer)) != -1) {
                outstream.write(buffer, 0, l);
            }
        } else {
            // consume no more than length
            long remaining = this.length;
            while (remaining > 0) {
                l = instream.read(buffer, 0, (int)Math.min(BUFFER_SIZE, remaining));
                if (l == -1) {
                    break;
                }
                outstream.write(buffer, 0, l);
                remaining -= l;
            }
        }
        this.consumed = true;
    }

    // non-javadoc, see interface HttpEntity
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.507 -0500", hash_original_method = "3E82383C0A86BE67DCD75D0F1508916B", hash_generated_method = "C33F405B683B30AE7D9BD5D0D49C9546")
    
public boolean isStreaming() {
        return !this.consumed;
    }

    // non-javadoc, see interface HttpEntity
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.509 -0500", hash_original_method = "1B9AD287611C066C29846341DA0AFC9D", hash_generated_method = "A02AB2021C900CDFBC16705EC14B3E2F")
    
public void consumeContent() throws IOException {
        this.consumed = true;
        // If the input stream is from a connection, closing it will read to
        // the end of the content. Otherwise, we don't care what it does.
        this.content.close();
    }
}

