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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/impl/conn/LoggingSessionOutputBuffer.java $
 * $Revision: 674186 $
 * $Date: 2008-07-05 05:18:54 -0700 (Sat, 05 Jul 2008) $
 *
 * ====================================================================
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.CharArrayBuffer;

public class LoggingSessionOutputBuffer implements SessionOutputBuffer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.304 -0500", hash_original_field = "862CD4E306AB155A980F18A7EE0A0BF8", hash_generated_field = "77BC14A656F9BA385AF4199F8E7C3C1D")

    private  SessionOutputBuffer out;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.307 -0500", hash_original_field = "D2667BBCCA848CAF9353759FA5A43764", hash_generated_field = "A0AADC773030E94A93C2CDBDBF09ABFD")

    private  Wire wire;

    /**
     * Create an instance that wraps the specified session output buffer.
     * @param out The session output buffer.
     * @param wire The Wire log to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.310 -0500", hash_original_method = "9B52F273E26CB5D7F7BAD01E854C0200", hash_generated_method = "DECDE14E4906689CFF1BE774E7750073")
    
public LoggingSessionOutputBuffer(final SessionOutputBuffer out, final Wire wire) {
        super();
        this.out = out;
        this.wire = wire;
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.312 -0500", hash_original_method = "E8AA091506E0C7EDCD0C7636A9C3BA76", hash_generated_method = "685CEA91AE2D7C9D55774E87F0B4E30E")
    
public void write(byte[] b, int off, int len) throws IOException {
        this.out.write(b,  off,  len);
        if (this.wire.enabled()) {
            this.wire.output(b, off, len);
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.314 -0500", hash_original_method = "5AAEA6F1D5C12B4807525C7221D2D4F0", hash_generated_method = "0DAECBF183D91D68466895A42D30F395")
    
public void write(int b) throws IOException {
        this.out.write(b);
        if (this.wire.enabled()) {
            this.wire.output(b);
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.317 -0500", hash_original_method = "398DA088D4360963F630B5E740A28F5B", hash_generated_method = "EC4BFA0F2A516CD031BE559FFCC0AE53")
    
public void write(byte[] b) throws IOException {
        this.out.write(b);
        if (this.wire.enabled()) {
            this.wire.output(b);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.319 -0500", hash_original_method = "A5A452E28D931563D6707491621FFBE7", hash_generated_method = "69E9959092BAC6291CF23078F47E18CD")
    
public void flush() throws IOException {
        this.out.flush();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.321 -0500", hash_original_method = "E49BA3BA8C77B9A3148B4EE9C17D24AC", hash_generated_method = "DA585FA1DDFFDF7BB6E4CAFD5A39E643")
    
public void writeLine(final CharArrayBuffer buffer) throws IOException {
        this.out.writeLine(buffer);
        if (this.wire.enabled()) {
            String s = new String(buffer.buffer(), 0, buffer.length());
            this.wire.output(s + "[EOL]");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.324 -0500", hash_original_method = "D3F9E08E28E99649C1B0B0BE6F42B853", hash_generated_method = "6DDB8FC467042C1E727C368A95953BD3")
    
public void writeLine(final String s) throws IOException {
        this.out.writeLine(s);
        if (this.wire.enabled()) {
            this.wire.output(s + "[EOL]");
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.326 -0500", hash_original_method = "1A01B276520F9BEAE357611B160DD712", hash_generated_method = "BCB4EB370DA947F14A04A6E26D17DDAD")
    
public HttpTransportMetrics getMetrics() {
        return this.out.getMetrics();
    }
    
}

