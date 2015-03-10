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

/**
* @author Stepan M. Mishura
* @version $Revision$
*/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;






public final class DerInputStream extends BerInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.293 -0500", hash_original_field = "CE0B10D4C628FA79F55B96B8A8D98A79", hash_generated_field = "08355CA64E34182C7E05F703D55502C7")

    private static final byte[] UNUSED_BITS_MASK = new byte[] { 0x01, 0x03,
            0x07, 0x0F, 0x1F, 0x3F, 0x7F };

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.296 -0500", hash_original_method = "0C4A7C9E977F3C6859980EACEBE18672", hash_generated_method = "387B918EDC12C7E18FAE10C7AEA1E991")
    
public DerInputStream(byte[] encoded) throws IOException {
        super(encoded, 0, encoded.length);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.299 -0500", hash_original_method = "28091E4E014A0D7A42E8F791C3C64E87", hash_generated_method = "2A77DE6735EE049639B2FEB41A49DD5E")
    
public DerInputStream(byte[] encoded, int offset, int encodingLen) throws IOException {
        super(encoded, offset, encodingLen);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.301 -0500", hash_original_method = "BE2CCC0A8AA1ECB77ECF4313FFFD9645", hash_generated_method = "74481692F6BA507ADD0621C1DDB517E8")
    
public DerInputStream(InputStream in) throws IOException {
        super(in);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.304 -0500", hash_original_method = "ACFD8393341C557A4C5CB85B57910849", hash_generated_method = "E494C9514CF19CB0E1BB967DE8BF0C9A")
    
public int next() throws IOException {
        int tag = super.next();

        if (length == INDEFINIT_LENGTH) {
            throw new ASN1Exception("DER: only definite length encoding MUST be used");
        }

        // FIXME add check: length encoding uses minimum number of octets

        return tag;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.306 -0500", hash_original_method = "7A0EADAA1891B960439C6C2BFD607720", hash_generated_method = "1E8E3C7BFACE66F4F619A4CF479D02A1")
    
public void readBitString() throws IOException {
        if (tag == ASN1Constants.TAG_C_BITSTRING) {
            throw new ASN1Exception("ASN.1 bitstring: constructed identifier at [" + tagOffset
                    + "]. Not valid for DER.");
        }

        super.readBitString();

        //check: unused bits values - MUST be 0
        if (length > 1
                && buffer[contentOffset] != 0
                && (buffer[offset - 1] & UNUSED_BITS_MASK[buffer[contentOffset] - 1]) != 0) {
            throw new ASN1Exception("ASN.1 bitstring: wrong content at [" + contentOffset
                    + "]. DER requires zero unused bits in final octet.");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.308 -0500", hash_original_method = "10108ACDBF74B8DE65083A6BBAC4052F", hash_generated_method = "86AF2C60D1908425D5A50469FB3BDD86")
    
public void readBoolean() throws IOException {
        super.readBoolean();

        // check encoded content
        if (buffer[contentOffset] != 0 && buffer[contentOffset] != (byte) 0xFF) {
            throw new ASN1Exception("ASN.1 boolean: wrong content at [" + contentOffset
                    + "]. DER allows only 0x00 or 0xFF values");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.311 -0500", hash_original_method = "71C8318A9CAF457AECB9A25AEA0B0620", hash_generated_method = "1EBBFD2CEC68A36F1D344F50744AB0BF")
    
public void readOctetString() throws IOException {
        if (tag == ASN1Constants.TAG_C_OCTETSTRING) {
            throw new ASN1Exception("ASN.1 octetstring: constructed identifier at [" + tagOffset
                    + "]. Not valid for DER.");
        }
        super.readOctetString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.313 -0500", hash_original_method = "D6D26712C70093C458D89C6D3972D749", hash_generated_method = "45C49BF16276AC671240D35359145F39")
    
public void readSequence(ASN1Sequence sequence) throws IOException {
        //
        // According to ASN.1 DER spec. sequence MUST not include
        // any encoding which value is equal to its default value
        //
        // Verification of this assertion is not implemented
        //
        super.readSequence(sequence);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.316 -0500", hash_original_method = "77F51C9B8D3AA50862AF88F76C08878B", hash_generated_method = "92717D997283D2EBA2679CCAEF34A45C")
    
public void readSetOf(ASN1SetOf setOf) throws IOException {
        //
        // According to ASN.1 DER spec. set of MUST appear in
        // ascending order (short component are padded for comparison)
        //
        // Verification of this assertion is not implemented
        //
        super.readSetOf(setOf);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.318 -0500", hash_original_method = "E88A2C471E1F01453D6E283D611B31B1", hash_generated_method = "647CB3EFF9885D62AE5BDA62F22029D0")
    
public void readString(ASN1StringType type) throws IOException {
        if (tag == type.constrId) {
            throw new ASN1Exception("ASN.1 string: constructed identifier at [" + tagOffset
                    + "]. Not valid for DER.");
        }
        super.readString(type);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.320 -0500", hash_original_method = "DDB0D038D9FFD20754D2BFE5BE49D19D", hash_generated_method = "4C05BB2D0530F450C4C25DB23861D341")
    
public void readUTCTime() throws IOException {
        if (tag == ASN1Constants.TAG_C_UTCTIME) {
            // It is a string type and it can be encoded as primitive or constructed.
            throw new ASN1Exception("ASN.1 UTCTime: constructed identifier at [" + tagOffset
                    + "]. Not valid for DER.");
        }

        // check format: DER uses YYMMDDHHMMSS'Z' only
        if (length != ASN1UTCTime.UTC_HMS) {
            throw new ASN1Exception("ASN.1 UTCTime: wrong format for DER, identifier at ["
                    + tagOffset + "]");
        }

        super.readUTCTime();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.322 -0500", hash_original_method = "EBDF2A88B7EE1193AEF8967AC2F99528", hash_generated_method = "744D8DC54E4BC72B7DF6BD44945B6EC9")
    
public void readGeneralizedTime() throws IOException {
        if (tag == ASN1Constants.TAG_C_GENERALIZEDTIME) {
            // It is a string type and it can be encoded as primitive or constructed.
            throw new ASN1Exception("ASN.1 GeneralizedTime: constructed identifier at ["
                    + tagOffset + "]. Not valid for DER.");
        }

        super.readGeneralizedTime();
    }
}

