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
* @author Alexander Y. Kleymenov
* @version $Revision$
*/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BitString;
import org.apache.harmony.security.utils.Array;

public final class CertificateList {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.934 -0400", hash_original_field = "736366582672C5EC0590C01C14D1FD1B", hash_generated_field = "CEEF377160D4527069F2AE9EE6F61908")

    public static final ASN1Sequence ASN1 =
        new ASN1Sequence(new ASN1Type[]
                {TBSCertList.ASN1, AlgorithmIdentifier.ASN1,
                    ASN1BitString.getInstance()}) {

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.105 -0500", hash_original_method = "AC0862005B3ED7BF3B72B40A50B20B3D", hash_generated_method = "C342C60F682D5F653B2D4FBE56952277")
        
@Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new CertificateList(
                    (TBSCertList) values[0],
                    (AlgorithmIdentifier) values[1],
                    ((BitString) values[2]).bytes, // FIXME keep as BitString object
                    in.getEncoded()
                    );
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.108 -0500", hash_original_method = "A02258897C0BA2BA079F5C92BD0C8E9B", hash_generated_method = "FD4581F8839BEC11F1B7FE4034EE647E")
        
@Override protected void getValues(Object object, Object[] values) {
            CertificateList certificateList = (CertificateList) object;
            values[0] = certificateList.tbsCertList;
            values[1] = certificateList.signatureAlgorithm;
            values[2] = new BitString(certificateList.signatureValue, 0);
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.080 -0500", hash_original_field = "894D071EFC59C716ABB532FBFE5DB823", hash_generated_field = "77B3A284D6DF0EF4A47E1206333ED0FE")

    private  TBSCertList tbsCertList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.082 -0500", hash_original_field = "2F7BE616514E885F71195FC5A07117B0", hash_generated_field = "4CC78CEDF5C854EC0CED71E47BBFC813")

    private  AlgorithmIdentifier signatureAlgorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.084 -0500", hash_original_field = "9521EB9F2B8E8BECDD1F8EF0CD48C6D0", hash_generated_field = "9AB01BF01A2AD28FB638C6788268D049")

    private  byte[] signatureValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.087 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.089 -0500", hash_original_method = "08126E4FD8546D7C66517E47FC438E4A", hash_generated_method = "0A90F36126D368E7D8B8F45D6AD707CB")
    
public CertificateList(TBSCertList tbsCertList,
                       AlgorithmIdentifier signatureAlgorithm,
                       byte[] signatureValue) {
        this.tbsCertList = tbsCertList;
        this.signatureAlgorithm = signatureAlgorithm;
        this.signatureValue = new byte[signatureValue.length];
        System.arraycopy(signatureValue, 0, this.signatureValue, 0,
                                                    signatureValue.length);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.092 -0500", hash_original_method = "296A8B306ED3B280093A8F830EEE1E41", hash_generated_method = "1F895138C5CB067D58F8B2825ECBCED2")
    
private CertificateList(TBSCertList tbsCertList,
                       AlgorithmIdentifier signatureAlgorithm,
                       byte[] signatureValue, byte[] encoding) {
        this(tbsCertList, signatureAlgorithm, signatureValue);
        this.encoding = encoding;
    }

    /**
     * Returns the value of tbsCertList field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.094 -0500", hash_original_method = "C6096C9759CF7088E874A2A2D3801E56", hash_generated_method = "1CEA433A40B3D8623CD847992ADF5C8F")
    
public TBSCertList getTbsCertList() {
        return tbsCertList;
    }

    /**
     * Returns the value of signatureValue field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.096 -0500", hash_original_method = "FD6792B7396143D84E51253527677292", hash_generated_method = "9BB6F5653A95BBE1BAA5CA0C7E370DD2")
    
public byte[] getSignatureValue() {
        byte[] result = new byte[signatureValue.length];
        System.arraycopy(signatureValue, 0, result, 0, signatureValue.length);
        return result;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.098 -0500", hash_original_method = "80C69E334C5CE31111385C23EECA9331", hash_generated_method = "10A5518EE6A67B7F5FAD0C31338B4C27")
    
@Override public String toString() {
        StringBuilder result = new StringBuilder();
        tbsCertList.dumpValue(result);
        result.append("\nSignature Value:\n");
        result.append(Array.toString(signatureValue, ""));
        return result.toString();
    }

    /**
     * Returns ASN.1 encoded form of this X.509 TBSCertList value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.101 -0500", hash_original_method = "32DCE62651649D85CD3AB4D018999455", hash_generated_method = "B8502A287DD409B99C7907A12406E14B")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = CertificateList.ASN1.encode(this);
        }
        return encoding;
    }
}

