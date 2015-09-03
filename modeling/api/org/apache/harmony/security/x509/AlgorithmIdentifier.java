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
import java.util.Arrays;

import org.apache.harmony.security.asn1.ASN1Any;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;
import org.apache.harmony.security.utils.AlgNameMapper;

public final class AlgorithmIdentifier {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.792 -0400", hash_original_field = "0379B40A69260257BE6FAF87FE8921A2", hash_generated_field = "D57B6C9D256FA01BB83ACCC1550296AC")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Oid.getInstance(), ASN1Any.getInstance() }) {
        {
            setOptional(1); 
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.343 -0500", hash_original_method = "E5864BBB3AEA6202E3F7EB2686660296", hash_generated_method = "F48BB096D750A26B83F1E3FF6E75F89A")
        
@Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new AlgorithmIdentifier(ObjectIdentifier
                    .toString((int[]) values[0]), (byte[]) values[1]);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.346 -0500", hash_original_method = "EDE1554E6577A894B2989F0DB9001552", hash_generated_method = "7F5D1B87D7DA488E31F7FAA696074235")
        
@Override protected void getValues(Object object, Object[] values) {

            AlgorithmIdentifier aID = (AlgorithmIdentifier) object;

            values[0] = ObjectIdentifier.toIntArray(aID.getAlgorithm());
            values[1] = aID.getParameters();
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.308 -0500", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.310 -0500", hash_original_field = "59661F2A89A32CB5CC4FFC351D8D7CFF", hash_generated_field = "4A61F6719BEAA78381132679E3C29E60")

    private String algorithmName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.312 -0500", hash_original_field = "4939A11DCC484FD402D6F14863D1736C", hash_generated_field = "BDB7CE72F1F070C790060F407EE69616")

    private byte[] parameters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.314 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.317 -0500", hash_original_method = "2A12FAF842ACAA2DBD4904F8F0273D03", hash_generated_method = "46693DB9F8F2B846E1553756FA35F2A0")
    
public AlgorithmIdentifier(String algorithm) {
        this(algorithm, null, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.319 -0500", hash_original_method = "3A9ADFAB73D31AB7E50DF2B242FDEB53", hash_generated_method = "5673A8139D0F1BB223046E8203D33049")
    
public AlgorithmIdentifier(String algorithm, byte[] parameters) {
        this(algorithm, parameters, null);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.322 -0500", hash_original_method = "D2431539DF2ECCEF9FBA946BEDC34F61", hash_generated_method = "D8B071983057F5FC10BD2CF045C30092")
    
private AlgorithmIdentifier(String algorithm, byte[] parameters, byte[] encoding) {
        this.algorithm = algorithm;
        this.parameters = parameters;
        this.encoding = encoding;
    }

    /**
     * Returns the value of algorithm field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.324 -0500", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "09B8CB0F05513E7BA5A386900D5BF6E6")
    
public String getAlgorithm() {
        return algorithm;
    }

    /**
     * Returns the name of the algorithm corresponding to
     * its OID. If there is no the such correspondence,
     * algorithm OID is returned.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.327 -0500", hash_original_method = "EFA02412B3D98573C0B83612EF561CD2", hash_generated_method = "AE7B7B5C4A50959248A1EE3D48EE12E6")
    
public String getAlgorithmName() {
        if (algorithmName == null) {
            algorithmName = AlgNameMapper.map2AlgName(algorithm);
            if (algorithmName == null) {
                algorithmName = algorithm;
            }
        }
        return algorithmName;
    }

    /**
     * Returns the value of parameters field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.329 -0500", hash_original_method = "360B58AAED509D402161560B83FBF1AD", hash_generated_method = "6CE288EFDC710AAF8CD7886B917F1DAC")
    
public byte[] getParameters() {
        return parameters;
    }

    /**
     * Returns ASN.1 encoded form of this X.509 AlgorithmIdentifier value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.331 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.334 -0500", hash_original_method = "CF4BFB68A01F84A2E157841F7FC296C6", hash_generated_method = "972723D20C45183383335D563C2CCACD")
    
@Override public boolean equals(Object ai) {
        if (!(ai instanceof AlgorithmIdentifier)) {
            return false;
        }
        AlgorithmIdentifier algid = (AlgorithmIdentifier) ai;
        return (algorithm.equals(algid.algorithm))
            && ((parameters == null)
                    ? algid.parameters == null
                    : Arrays.equals(parameters, algid.parameters));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.336 -0500", hash_original_method = "E65C54FCC20A7D2FAC5D39EC6758FF2C", hash_generated_method = "D538904D2381C811FF6D8A3B40578794")
    
@Override public int hashCode() {
        return algorithm.hashCode() * 37 + (parameters != null ? Arrays.hashCode(parameters) : 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.338 -0500", hash_original_method = "BB3CE84D97D9ED23CA58D78F5AD0AB33", hash_generated_method = "55C790F3066060267E3509748C12E017")
    
public void dumpValue(StringBuilder sb) {
        sb.append(getAlgorithmName());
        if (parameters == null) {
            sb.append(", no params, ");
        } else {
            sb.append(", params unparsed, ");
        }
        sb.append("OID = ");
        sb.append(getAlgorithm());
    }
}

