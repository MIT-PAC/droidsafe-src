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
import java.security.SecureRandom;
import java.util.Arrays;

import libcore.io.Streams;
import libcore.util.EmptyArray;

public class ClientHello extends Message {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.679 -0500", hash_original_field = "87AFE8194BC492AFC7167BB3A54122B9", hash_generated_field = "87AFE8194BC492AFC7167BB3A54122B9")

     byte[] client_version;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.681 -0500", hash_original_field = "99091ADCC73FE81C2F7FCEF8EA8CC707", hash_generated_field = "D668480B0E83A7483DCEBA9C8392548F")

    final byte[] random = new byte[32];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.683 -0500", hash_original_field = "464E487327E8A3D68CAEEB2871FE01AA", hash_generated_field = "464E487327E8A3D68CAEEB2871FE01AA")

     byte[] session_id;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.686 -0500", hash_original_field = "A0A44A96F6DB28A1A612B3ED93B5B66F", hash_generated_field = "A0A44A96F6DB28A1A612B3ED93B5B66F")

     CipherSuite[] cipher_suites;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.688 -0500", hash_original_field = "47F40258F3E60116F552FCA9A35A3742", hash_generated_field = "47F40258F3E60116F552FCA9A35A3742")

     byte[] compression_methods;

    /**
     * Creates outbound message
     * @param sr
     * @param version
     * @param ses_id
     * @param cipher_suite
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.691 -0500", hash_original_method = "B360A744DA2558AEF3A4AD32A9DD66E9", hash_generated_method = "44A00FDBD3345690E803FCDCD1070EBA")
    
public ClientHello(SecureRandom sr, byte[] version, byte[] ses_id,
            CipherSuite[] cipher_suite) {
        client_version = version;
        long gmt_unix_time = System.currentTimeMillis()/1000;
        sr.nextBytes(random);
        random[0] = (byte) (gmt_unix_time & 0xFF000000 >>> 24);
        random[1] = (byte) (gmt_unix_time & 0xFF0000 >>> 16);
        random[2] = (byte) (gmt_unix_time & 0xFF00 >>> 8);
        random[3] = (byte) (gmt_unix_time & 0xFF);
        session_id = ses_id;
        this.cipher_suites = cipher_suite;
        compression_methods = new byte[] { 0 }; // CompressionMethod.null
        length = 38 + session_id.length + (this.cipher_suites.length << 1)
                + compression_methods.length;
    }

    /**
     * Creates inbound message
     * @param in
     * @param length
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.695 -0500", hash_original_method = "9848891785B38B606D088EC36D49C2E1", hash_generated_method = "8B4BF0E099EE1300CAA8E1C5765A42E3")
    
public ClientHello(HandshakeIODataStream in, int length) throws IOException {
        client_version = new byte[2];
        client_version[0] = (byte) in.readUint8();
        client_version[1] = (byte) in.readUint8();
        Streams.readFully(in, random);
        int size = in.read();
        session_id = new byte[size];
        in.read(session_id, 0, size);
        int l = in.readUint16();
        if ((l & 0x01) == 0x01) { // cipher suites length must be an even number
            fatalAlert(AlertProtocol.DECODE_ERROR,
                    "DECODE ERROR: incorrect ClientHello");
        }
        size = l >> 1;
        cipher_suites = new CipherSuite[size];
        for (int i = 0; i < size; i++) {
            byte b0 = (byte) in.read();
            byte b1 = (byte) in.read();
            cipher_suites[i] = CipherSuite.getByCode(b0, b1);
        }
        size = in.read();
        compression_methods = new byte[size];
        in.read(compression_methods, 0, size);
        this.length = 38 + session_id.length + (cipher_suites.length << 1)
                + compression_methods.length;
        if (this.length > length) {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect ClientHello");
        }
        // for forward compatibility, extra data is permitted;
        // must be ignored
        if (this.length < length) {
            in.skip(length - this.length);
            this.length = length;
        }
    }
    /**
     * Parse V2ClientHello
     * @param in
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.699 -0500", hash_original_method = "092EDC6A6C17B41B7BF7C969F19C771C", hash_generated_method = "C8C109FB41D5F2E9226B52F3558A6543")
    
public ClientHello(HandshakeIODataStream in) throws IOException {
        if (in.readUint8() != 1) {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect V2ClientHello");
        }
        client_version = new byte[2];
        client_version[0] = (byte) in.readUint8();
        client_version[1] = (byte) in.readUint8();
        int cipher_spec_length = in.readUint16();
        if (in.readUint16() != 0) { // session_id_length
            // as client already knows the protocol known to a server it should
            // initiate the connection in that native protocol
            fatalAlert(AlertProtocol.DECODE_ERROR,
                    "DECODE ERROR: incorrect V2ClientHello, cannot be used for resuming");
        }
        int challenge_length = in.readUint16();
        if (challenge_length < 16) {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect V2ClientHello, short challenge data");
        }
        session_id = EmptyArray.BYTE;
        cipher_suites = new CipherSuite[cipher_spec_length/3];
        for (int i = 0; i < cipher_suites.length; i++) {
            byte b0 = (byte) in.read();
            byte b1 = (byte) in.read();
            byte b2 = (byte) in.read();
            cipher_suites[i] = CipherSuite.getByCode(b0, b1, b2);
        }
        compression_methods = new byte[] { 0 }; // CompressionMethod.null

        if (challenge_length < 32) {
            Arrays.fill(random, 0, 32 - challenge_length, (byte)0);
            System.arraycopy(in.read(challenge_length), 0, random, 32 - challenge_length, challenge_length);
        } else if (challenge_length == 32) {
            System.arraycopy(in.read(32), 0, random, 0, 32);
        } else {
            System.arraycopy(in.read(challenge_length), challenge_length - 32, random, 0, 32);
        }
        if (in.available() > 0) {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect V2ClientHello, extra data");
        }
        this.length = 38 + session_id.length + (cipher_suites.length << 1)
                + compression_methods.length;
    }

    /**
     * Sends message
     * @param out
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.701 -0500", hash_original_method = "89F344582D255D48D3BC56CB8686027C", hash_generated_method = "F559B8261FD2194AE0F350904CF8D9A2")
    
@Override
    public void send(HandshakeIODataStream out) {
        out.write(client_version);
        out.write(random);
        out.writeUint8(session_id.length);
        out.write(session_id);
        int size = cipher_suites.length << 1;
        out.writeUint16(size);
        for (int i = 0; i < cipher_suites.length; i++) {
            out.write(cipher_suites[i].toBytes());
        }
        out.writeUint8(compression_methods.length);
        for (int i = 0; i < compression_methods.length; i++) {
            out.write(compression_methods[i]);
        }
    }

    /**
     * Returns client random
     * @return client random
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.703 -0500", hash_original_method = "EDD7E5211887C4E217154E276BC2B61E", hash_generated_method = "AD106D7FEAE26F7078E90292C4E75999")
    
public byte[] getRandom() {
        return random;
    }

    /**
     * Returns message type
     * @return
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.706 -0500", hash_original_method = "CF19DA1ECE12A56ABD61504AAFBBFE23", hash_generated_method = "C44D983FE807C92DDF6B5DA9B9582AC6")
    
@Override
    public int getType() {
        return Handshake.CLIENT_HELLO;
    }
    
}

