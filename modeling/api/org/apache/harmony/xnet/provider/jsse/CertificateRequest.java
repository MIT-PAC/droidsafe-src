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
import java.security.cert.X509Certificate;
import java.util.ArrayList;

import javax.security.auth.x500.X500Principal;

import libcore.io.Streams;

public class CertificateRequest extends Message {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.030 -0500", hash_original_field = "052660BD096960D182ED14500388945C", hash_generated_field = "052660BD096960D182ED14500388945C")

     byte[] certificate_types;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.033 -0500", hash_original_field = "F3AC0C1FF54FCE6FAA264A8694502CB6", hash_generated_field = "F3AC0C1FF54FCE6FAA264A8694502CB6")

     X500Principal[] certificate_authorities;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.035 -0500", hash_original_field = "AD31D1EACC903A55746FD46BDB9A966C", hash_generated_field = "57B17EE84C64E0E68D855EB8B1E7E056")

    private String[] types;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.037 -0500", hash_original_field = "B0F4E299A9FBBADFC8DEDC8C55FC7CFC", hash_generated_field = "B2462DD7293A0BAC46631DF777D44309")

    private byte[][] encoded_principals;

    /**
     * Creates outbound message
     *
     * @param certificate_types
     * @param accepted - array of certificate authority certificates
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.040 -0500", hash_original_method = "CB3C7AA59A60FE20BA988C0CAC39DBAA", hash_generated_method = "8542731C5595BA0410D5197C4DB68A0C")
    
public CertificateRequest(byte[] certificate_types,
                              X509Certificate[] accepted) {

        if (accepted == null) {
            fatalAlert(AlertProtocol.INTERNAL_ERROR,
                    "CertificateRequest: array of certificate authority certificates is null");
        }
        this.certificate_types = certificate_types;

        int totalPrincipalsLength = 0;
        certificate_authorities = new X500Principal[accepted.length];
        encoded_principals = new byte[accepted.length][];
        for (int i = 0; i < accepted.length; i++) {
            certificate_authorities[i] = accepted[i].getIssuerX500Principal();
            encoded_principals[i] = certificate_authorities[i].getEncoded();
            totalPrincipalsLength += encoded_principals[i].length + 2;
        }

        length = 3 + certificate_types.length + totalPrincipalsLength;
    }

    /**
     * Creates inbound message
     *
     * @param in
     * @param length
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.044 -0500", hash_original_method = "D10E4DAB13CE1708B5021E84302588D4", hash_generated_method = "115C887B5807FAD50F3ABD8AE8A15D8C")
    
public CertificateRequest(HandshakeIODataStream in, int length) throws IOException {
        int size = in.readUint8();
        certificate_types = new byte[size];
        Streams.readFully(in, certificate_types);
        size = in.readUint16();
        int totalPrincipalsLength = 0;
        int principalLength = 0;
        ArrayList<X500Principal> principals = new ArrayList<X500Principal>();
        while (totalPrincipalsLength < size) {
            principalLength = in.readUint16(); // encoded X500Principal size
            principals.add(new X500Principal(in));
            totalPrincipalsLength += 2;
            totalPrincipalsLength += principalLength;
        }
        certificate_authorities = principals.toArray(new X500Principal[principals.size()]);
        this.length = 3 + certificate_types.length + totalPrincipalsLength;
        if (this.length != length) {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect CertificateRequest");
        }
    }

    /**
     * Sends message
     *
     * @param out
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.046 -0500", hash_original_method = "B75D6FC2C98C385FE0F3914F9044B1F0", hash_generated_method = "AFC1647D93FCCD35E1201C8E70FF4F45")
    
@Override
    public void send(HandshakeIODataStream out) {

        out.writeUint8(certificate_types.length);
        for (int i = 0; i < certificate_types.length; i++) {
            out.write(certificate_types[i]);
        }
        int authoritiesLength = 0;
        for (int i = 0; i < certificate_authorities.length; i++) {
            authoritiesLength += encoded_principals[i].length +2;
        }
        out.writeUint16(authoritiesLength);
        for (int i = 0; i < certificate_authorities.length; i++) {
            out.writeUint16(encoded_principals[i].length);
            out.write(encoded_principals[i]);
        }
    }

    /**
     * Returns message type
     *
     * @return
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.049 -0500", hash_original_method = "B8B86D3685160AFFAE5E6FB9770B1A60", hash_generated_method = "221471CAB0DE2EE19C5273E572DFDE8E")
    
@Override
    public int getType() {
        return Handshake.CERTIFICATE_REQUEST;
    }

    /**
     * Returns requested certificate types as array of strings
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.051 -0500", hash_original_method = "9259963BD630FBE5E6BDCDC2C1D8D491", hash_generated_method = "1393503D5ABC060257DCF4F37D4B18CB")
    
public String[] getTypesAsString() {
        if (types == null) {
            types = new String[certificate_types.length];
            for (int i = 0; i < types.length; i++) {
                String type = CipherSuite.getClientKeyType(certificate_types[i]);
                if (type == null) {
                    fatalAlert(AlertProtocol.DECODE_ERROR,
                            "DECODE ERROR: incorrect CertificateRequest");
                }
                types[i] = type;
            }
        }
        return types;
    }
    
}

