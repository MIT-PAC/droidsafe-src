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
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

public class CertificateMessage extends Message {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.563 -0500", hash_original_field = "9B4CC3CF13ACA419D4B9B38AD77D3648", hash_generated_field = "9B4CC3CF13ACA419D4B9B38AD77D3648")

    X509Certificate[] certs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.565 -0500", hash_original_field = "57935D50E807950C7290BDE1C251A925", hash_generated_field = "57935D50E807950C7290BDE1C251A925")

    byte[][] encoded_certs;

    /**
     * Creates inbound message
     *
     * @param in
     * @param length
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.568 -0500", hash_original_method = "3441A786FC97408CA6232DAAE3F595DF", hash_generated_method = "6B4053AF35C2C4F0866FEF5884A3DEDB")
    
public CertificateMessage(HandshakeIODataStream in, int length) throws IOException {
        int l = in.readUint24(); // total_length
        if (l == 0) {  // message contais no certificates
            if (length != 3) { // no more bytes after total_length
                fatalAlert(AlertProtocol.DECODE_ERROR,
                        "DECODE ERROR: incorrect CertificateMessage");
            }
            certs = new X509Certificate[0];
            encoded_certs = new byte[0][0];
            this.length = 3;
            return;
        }
        CertificateFactory cf;
        try {
            cf = CertificateFactory.getInstance("X509");
        } catch (CertificateException e) {
            fatalAlert(AlertProtocol.INTERNAL_ERROR, "INTERNAL ERROR", e);
            return;
        }
        ArrayList<X509Certificate> certsList = new ArrayList<X509Certificate>();
        int size = 0;
        int enc_size = 0;
        while (l > 0) {
            size = in.readUint24();
            l -= 3;
            try {
                certsList.add((X509Certificate) cf.generateCertificate(in));
            } catch (CertificateException e) {
                fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR", e);
            }
            l -= size;
            enc_size += size;
        }
        certs = certsList.toArray(new X509Certificate[certsList.size()]);
        this.length = 3 + 3 * certs.length + enc_size;
        if (this.length != length) {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect CertificateMessage");
        }
    }

    /**
     * Creates outbound message
     *
     * @param certs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.571 -0500", hash_original_method = "A869E13906426823448DC988F0CB5F8A", hash_generated_method = "9FF66943C1E5D28AD3C9FEE56CFCB6BF")
    
public CertificateMessage(X509Certificate[] certs) {
        if (certs == null) {
            this.certs = new X509Certificate[0];
            encoded_certs = new byte[0][0];
            length = 3;
            return;
        }
        this.certs = certs;
        if (encoded_certs == null) {
            encoded_certs = new byte[certs.length][];
            for (int i = 0; i < certs.length; i++) {
                try {
                    encoded_certs[i] = certs[i].getEncoded();
                } catch (CertificateEncodingException e) {
                    fatalAlert(AlertProtocol.INTERNAL_ERROR, "INTERNAL ERROR",
                            e);
                }
            }
        }
        length = 3 + 3 * encoded_certs.length;
        for (int i = 0; i < encoded_certs.length; i++) {
            length += encoded_certs[i].length;
        }
    }

    /**
     * Sends message
     *
     * @param out
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.574 -0500", hash_original_method = "345309F322E0CB3C0BD3B9A37C988F09", hash_generated_method = "C3E285EC69CC0008B4692DA77698D14C")
    
@Override
    public void send(HandshakeIODataStream out) {

        int total_length = 0;
        if (encoded_certs == null) {
            encoded_certs = new byte[certs.length][];
            for (int i = 0; i < certs.length; i++) {
                try {
                    encoded_certs[i] = certs[i].getEncoded();
                } catch (CertificateEncodingException e) {
                    fatalAlert(AlertProtocol.INTERNAL_ERROR, "INTERNAL ERROR",
                            e);
                }
            }
        }
        total_length = 3 * encoded_certs.length;
        for (int i = 0; i < encoded_certs.length; i++) {
            total_length += encoded_certs[i].length;
        }
        out.writeUint24(total_length);
        for (int i = 0; i < encoded_certs.length; i++) {
            out.writeUint24(encoded_certs[i].length);
            out.write(encoded_certs[i]);
        }

    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.577 -0500", hash_original_method = "B57A0154C34F76610C0A1E207F806B75", hash_generated_method = "5E393ACD79AED92735BEA12A2A1A9339")
    
public String getAuthType() {
        return certs[0].getPublicKey().getAlgorithm();
    }

    /**
     * Returns message type
     *
     * @return
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.579 -0500", hash_original_method = "F562E1306C68C131628B54BA54665996", hash_generated_method = "00D0AC9FD01A2006A2C6863DAEFF216F")
    
@Override
    public int getType() {
        return Handshake.CERTIFICATE;
    }
    
}

