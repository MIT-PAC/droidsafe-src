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
* @author Boris Kuznetsov
* @version $Revision$
*/

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.security.pkcs7;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import javax.security.auth.x500.X500Principal;

import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1SetOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.AttributeTypeAndValue;
import org.apache.harmony.security.x501.Name;
import org.apache.harmony.security.x509.AlgorithmIdentifier;

public final class SignerInfo {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.119 -0400", hash_original_field = "DA5E4B91C5AEA4F649C1E27EF117007C", hash_generated_field = "D0EBCF2AEA22824AC0540C4946A3C7F3")

    public static final ASN1Sequence ISSUER_AND_SERIAL_NUMBER =
            new ASN1Sequence(new ASN1Type[] {
                Name.ASN1,                       
                ASN1Integer.getInstance(),       
            })
        {
            // method to encode
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.394 -0500", hash_original_method = "6CC9A4ABC185E3CC2B765CE7717989A1", hash_generated_method = "B4ED01E65623B76ACF697E9C5AE1BC0B")
        
@Override public void getValues(Object object, Object[] values) {
                Object [] issAndSerial = (Object[])object;
                values[0] = issAndSerial[0];
                values[1] = issAndSerial[1];
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.120 -0400", hash_original_field = "7485F6B30A4859C8C1B772C8B7318B22", hash_generated_field = "6A02E77CC9008CF0FE8E20EC83C59F4A")

    public static final ASN1Sequence ASN1 =
        new ASN1Sequence(new ASN1Type[] {
                ASN1Integer.getInstance(),         
                ISSUER_AND_SERIAL_NUMBER,
                AlgorithmIdentifier.ASN1,           
                new ASN1Implicit(0, AuthenticatedAttributes.ASN1),
                AlgorithmIdentifier.ASN1,            
                ASN1OctetString.getInstance(),       
                 new ASN1Implicit(1, new ASN1SetOf(
                         AttributeTypeAndValue.ASN1)),
                })  {
        {
            setOptional(3); 
            setOptional(6); 
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.400 -0500", hash_original_method = "13D15A258F917C8B4D03BB0946061652", hash_generated_method = "DCF621AF678D27A7E2958ABA6938E597")
        
@Override protected void getValues(Object object, Object[] values) {
            SignerInfo si = (SignerInfo) object;
            values[0] = new byte[] {(byte)si.version};
            try {
                values[1] = new Object[] { new Name(si.issuer.getName()),
                        si.serialNumber.toByteArray() };
            } catch (IOException e) {
                // The exception is never thrown, because si.issuer
                // is created using Name.getX500Principal().
                // Throw a RuntimeException just to be safe.
                throw new RuntimeException("Failed to encode issuer name", e);
            }
            values[2] = si.digestAlgorithm;
            values[3] = si.authenticatedAttributes;
            values[4] = si.digestEncryptionAlgorithm;
            values[5] = si.encryptedDigest;
            values[6] = si.unauthenticatedAttributes;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.403 -0500", hash_original_method = "2E0301E2837E45CD6DC61EE3304DFEA2", hash_generated_method = "CF948ABABDB64BFFA2F73C0BCF93487E")
        
@Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new SignerInfo(
                        ASN1Integer.toIntValue(values[0]),
                        (Object[]) values[1],
                        (AlgorithmIdentifier) values[2],
                        (AuthenticatedAttributes) values[3],
                        (AlgorithmIdentifier) values[4],
                        (byte[]) values[5],
                        (List) values[6]
                    );
        }
   };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.352 -0500", hash_original_field = "971D53A5DDB5A515B8A18CE48C276387", hash_generated_field = "605FE2D9A0C9E94D1E2D3DAEDB658980")

    private  int version;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.354 -0500", hash_original_field = "99BE4463DA67376AA94F7D97DDB8D7FF", hash_generated_field = "30FEA84FB35EF28DB029D29044BA91EC")

    private  X500Principal issuer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.357 -0500", hash_original_field = "357D34BE4D3F218CD8ADF717DBF7DD40", hash_generated_field = "8556E85255DE7EB3D2D59484E44C2BAC")

    private  BigInteger serialNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.359 -0500", hash_original_field = "CA29728B9069A9E1C4E28C8A9BC0FDFA", hash_generated_field = "7E7BB7D422AEEBD0CB49BF63A453A9D8")

    private  AlgorithmIdentifier digestAlgorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.362 -0500", hash_original_field = "F0960332DD664E25CCAAAA799C8E58E0", hash_generated_field = "14A332E210BB2E11D03DC17917756851")

    private  AuthenticatedAttributes authenticatedAttributes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.364 -0500", hash_original_field = "C0BEB8BA88EF4376E136A402C983520F", hash_generated_field = "3B7F1A7A1CCFBE00AA70C6D41E16628E")

    private  AlgorithmIdentifier digestEncryptionAlgorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.366 -0500", hash_original_field = "A5EC3769B546B7A26E9C2A015C5EAFA1", hash_generated_field = "D4C160625B06809796B7FC57003B2410")

    private  byte[] encryptedDigest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.368 -0500", hash_original_field = "74DFD68241CE8A359F68D5347384C92F", hash_generated_field = "2DCA3E33D424E6A8A6B614313B171ECE")

    private  List<?> unauthenticatedAttributes;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.372 -0500", hash_original_method = "27DB92A863E4BE605C04757E557D0CAB", hash_generated_method = "2F739C205EC44E4BCAFF22CEDE549E9A")
    
private SignerInfo(int version,
            Object[] issuerAndSerialNumber,
            AlgorithmIdentifier digestAlgorithm,
            AuthenticatedAttributes authenticatedAttributes,
            AlgorithmIdentifier digestEncryptionAlgorithm,
            byte[] encryptedDigest,
            List<?> unauthenticatedAttributes) {
        this.version = version;
        this.issuer = ((Name)issuerAndSerialNumber[0]).getX500Principal();
        this.serialNumber = ASN1Integer.toBigIntegerValue(issuerAndSerialNumber[1]);
        this.digestAlgorithm = digestAlgorithm;
        this.authenticatedAttributes = authenticatedAttributes;
        this.digestEncryptionAlgorithm = digestEncryptionAlgorithm;
        this.encryptedDigest = encryptedDigest;
        this.unauthenticatedAttributes = unauthenticatedAttributes;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.374 -0500", hash_original_method = "4521AB691538FE3E0581DA96E2D306DA", hash_generated_method = "8DC0C60625DB619C930479E0ADEFEA2A")
    
public X500Principal getIssuer() {
        return issuer;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.377 -0500", hash_original_method = "9420C2CEA2A6F47D515C0AB0605412CD", hash_generated_method = "207C06B8E3C7AEAA1442B3B5D400DFA7")
    
public BigInteger getSerialNumber() {
        return serialNumber;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.379 -0500", hash_original_method = "E49EED34625AA0C2EE5919DE429AB631", hash_generated_method = "6639FD67F1DAD8895548BF7235F9E2E4")
    
public String getDigestAlgorithm() {
        return digestAlgorithm.getAlgorithm();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.381 -0500", hash_original_method = "C6CE7835E1C3757C7439121AECC2E59C", hash_generated_method = "D2D4759956000418DD3F8B0E229B3885")
    
public String getDigestEncryptionAlgorithm() {
        return digestEncryptionAlgorithm.getAlgorithm();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.383 -0500", hash_original_method = "AEBE4A58A31E26ADF89831B320BDD2E7", hash_generated_method = "667AB86BDDD1CFF30E1D6A54AE9F2B14")
    
public List<AttributeTypeAndValue> getAuthenticatedAttributes() {
        if (authenticatedAttributes == null) {
            return null;
        }
        return authenticatedAttributes.getAttributes();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.385 -0500", hash_original_method = "807A0AFC068DD73DE0C4C3C2177CA7D2", hash_generated_method = "445451BD2553575C42B7FCB48C245298")
    
public byte[] getEncodedAuthenticatedAttributes() {
        if (authenticatedAttributes == null) {
            return null;
        }
        return authenticatedAttributes.getEncoded();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.388 -0500", hash_original_method = "14A08E1AF72E02B64CEDF5DA67544611", hash_generated_method = "D77B68ACF21F013DC8CD4939F1ACFEFE")
    
public byte[] getEncryptedDigest() {
        return encryptedDigest;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.390 -0500", hash_original_method = "1FB56313E7A9E641FD4CA0515EC1DCD9", hash_generated_method = "B96333FB62EA5E9B9A7FC18EAABD0052")
    
public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("-- SignerInfo:");
        res.append("\n version : ");
        res.append(version);
        res.append("\nissuerAndSerialNumber:  ");
        res.append(issuer);
        res.append("   ");
        res.append(serialNumber);
        res.append("\ndigestAlgorithm:  ");
        res.append(digestAlgorithm.toString());
        res.append("\nauthenticatedAttributes:  ");
        if (authenticatedAttributes != null) {
            res.append(authenticatedAttributes.toString());
        }
        res.append("\ndigestEncryptionAlgorithm: ");
        res.append(digestEncryptionAlgorithm.toString());
        res.append("\nunauthenticatedAttributes: ");
        if (unauthenticatedAttributes != null) {
            res.append(unauthenticatedAttributes.toString());
        }
        res.append("\n-- SignerInfo End\n");
        return res.toString();
    }
}

