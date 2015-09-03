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
import java.io.IOException;

public class CertificateVerify extends Message {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.798 -0500", hash_original_field = "01A16F1FF859CB019178D18F23D7E606", hash_generated_field = "01A16F1FF859CB019178D18F23D7E606")

    byte[] signedHash;

    /**
     * Creates outbound message
     *
     * @param hash
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.801 -0500", hash_original_method = "F3A93A83C93F754D4846FCC8297217FD", hash_generated_method = "59A4FA9E9403F85D85E0377B015C2830")
    
public CertificateVerify(byte[] hash) {
        if (hash == null || hash.length == 0) {
            fatalAlert(AlertProtocol.INTERNAL_ERROR,
                    "INTERNAL ERROR: incorrect certificate verify hash");
        }
        this.signedHash = hash;
        length = hash.length + 2;
    }

    /**
     * Creates inbound message
     *
     * @param in
     * @param length
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.804 -0500", hash_original_method = "C08A411708B1C45834DF498B4B831402", hash_generated_method = "8348D54380A8F9D9486E166033DC9D2B")
    
public CertificateVerify(HandshakeIODataStream in, int length)
            throws IOException {
        if (length == 0) {
            fatalAlert(AlertProtocol.DECODE_ERROR,
                    "DECODE ERROR: incorrect CertificateVerify");
        } else {
            if (in.readUint16() != length - 2) {
                fatalAlert(AlertProtocol.DECODE_ERROR,
                        "DECODE ERROR: incorrect CertificateVerify");
            }
            signedHash = in.read(length -2);
        }
        this.length = length;
    }

    /**
     * Sends message
     *
     * @param out
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.806 -0500", hash_original_method = "8645B529D351D3837595463E8D8CA061", hash_generated_method = "36B01B2A1409B1CA07BD439ECEEB1973")
    
@Override
    public void send(HandshakeIODataStream out) {
        if (signedHash.length != 0) {
            out.writeUint16(signedHash.length);
            out.write(signedHash);
        }
    }

    /**
     * Returns message type
     *
     * @return
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.808 -0500", hash_original_method = "78FC60AEF6831C8195D1932C8B8AE728", hash_generated_method = "E04DFD4841F171C32FE7096C4AA21589")
    
@Override
    public int getType() {
        return Handshake.CERTIFICATE_VERIFY;
    }
    
}

