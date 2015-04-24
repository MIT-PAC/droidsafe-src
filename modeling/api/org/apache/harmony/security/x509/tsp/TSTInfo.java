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
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.security.x509.tsp;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.math.BigInteger;
import java.util.Date;
import org.apache.harmony.security.asn1.ASN1Boolean;
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1GeneralizedTime;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;
import org.apache.harmony.security.x509.Extensions;
import org.apache.harmony.security.x509.GeneralName;

/**
 * As defined in Time-Stamp Protocol (TSP)
 * (http://www.ietf.org/rfc/rfc3161.txt)
 *
 * TSTInfo ::= SEQUENCE  {
 *    version                      INTEGER  { v1(1) },
 *    policy                       TSAPolicyId,
 *    messageImprint               MessageImprint,
 *      -- MUST have the same value as the similar field in
 *      -- TimeStampReq
 *    serialNumber                 INTEGER,
 *     -- Time-Stamping users MUST be ready to accommodate integers
 *     -- up to 160 bits.
 *    genTime                      GeneralizedTime,
 *    accuracy                     Accuracy                 OPTIONAL,
 *    ordering                     BOOLEAN             DEFAULT FALSE,
 *    nonce                        INTEGER                  OPTIONAL,
 *      -- MUST be present if the similar field was present
 *      -- in TimeStampReq.  In that case it MUST have the same value.
 *    tsa                          [0] GeneralName          OPTIONAL,
 *    extensions                   [1] IMPLICIT Extensions   OPTIONAL
 * }
 *
 * TSAPolicyId ::= OBJECT IDENTIFIER
 *
 * "tsa [0] GeneralName OPTIONAL" is EXPLICIT and the word EXPLICIT is omitted.
 */
public class TSTInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.350 -0400", hash_original_field = "F265C70FE7D73356EB6935D6A089165A", hash_generated_field = "C4A299813A572B6A57E1C17FBBC7C226")

    public static final ASN1Sequence ACCURACY
            = new ASN1Sequence(new ASN1Type[] {
                    ASN1Integer.getInstance(),
                    ASN1Integer.getInstance(),
                    ASN1Integer.getInstance()
            }) {
        {
            setOptional(0);
            setOptional(1);
            setOptional(2);
        }

        protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;

            int [] accuracy = new int [3];
            for (int i = 0; i < 3; i++) {
                if (values[i] != null) {
                    accuracy[i] = ASN1Integer.toIntValue(values[i]);
                    if (i > 0 && (accuracy[i] < 0 || accuracy[i] > 999)) {
                        throw new RuntimeException("Time-stamp accuracy value is incorrect: " + accuracy[i]);
                    }
                }
            }
            return accuracy;
        }

        protected void getValues(Object object, Object[] values) {
            int [] accuracy = (int []) object;
            for (int i = 0; i < 3; i++) {
                if (i > 0 && (accuracy[i] < 0 || accuracy[i] > 999)) {
                    throw new RuntimeException("Time-stamp accuracy value is incorrect: " + accuracy[i]);
                }
                values[i] = BigInteger.valueOf(accuracy[i]).toByteArray();
            }
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.354 -0400", hash_original_field = "31EA7F0E03A7795B758D9C13E0904283", hash_generated_field = "4D3134E1BA71B6EF55EA8A4DA3769FB3")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Integer.getInstance(),              // version
            ASN1Oid.getInstance(),                  // policy
            MessageImprint.ASN1,                    // messageImprint
            ASN1Integer.getInstance(),              // serialNumber
            ASN1GeneralizedTime.getInstance(),      // genTime
            ACCURACY,                               // accuracy
            ASN1Boolean.getInstance(),              // ordering
            ASN1Integer.getInstance(),              // nonce
            new ASN1Explicit(0, GeneralName.ASN1),  // tsa
            new ASN1Implicit(1, Extensions.ASN1) }) {// extensions
        {
            setOptional(5);
            setDefault(Boolean.FALSE, 6);
            setOptional(7);
            setOptional(8);
            setOptional(9);
        }

        protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;

            BigInteger nonce = (values[7] == null) ? null : new BigInteger(
                    (byte[]) values[7]);

            return new TSTInfo(
                    ASN1Integer.toIntValue(values[0]),
                    ObjectIdentifier.toString((int[]) values[1]),
                    (MessageImprint) values[2],
                    new BigInteger((byte[]) values[3]),
                    (Date) values[4],
                    (int []) values[5],
                    (Boolean) values[6],
                    nonce,
                    (GeneralName) values[8],
                    (Extensions) values[9]);
        }

        protected void getValues(Object object, Object[] values) {
            TSTInfo info = (TSTInfo) object;

            values[0] = ASN1Integer.fromIntValue(info.version);
            values[1] = ObjectIdentifier.toIntArray(info.policy);
            values[2] = info.messageImprint;
            values[3] = info.serialNumber.toByteArray();
            values[4] = info.genTime;
            values[5] = info.accuracy;
            values[6] = info.ordering;
            values[7] = (info.nonce == null) ? null : info.nonce.toByteArray();
            values[8] = info.tsa;
            values[9] = info.extensions;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.337 -0400", hash_original_field = "971D53A5DDB5A515B8A18CE48C276387", hash_generated_field = "605FE2D9A0C9E94D1E2D3DAEDB658980")

    private  int version;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.338 -0400", hash_original_field = "1B09A70F5EC2CFD723BCA4AF6E3A1649", hash_generated_field = "A10D4BBCA0F477D86E7B537B46FFE89E")

    private  String policy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.338 -0400", hash_original_field = "F31921A0A5D0631E718887C96E89AF46", hash_generated_field = "49C20C38279D6EB96121ADC1E18E3831")

    private  MessageImprint messageImprint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.339 -0400", hash_original_field = "357D34BE4D3F218CD8ADF717DBF7DD40", hash_generated_field = "8556E85255DE7EB3D2D59484E44C2BAC")

    private  BigInteger serialNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.339 -0400", hash_original_field = "71261B185663E6FC694A0BFC717A7102", hash_generated_field = "A61C407C6F176EF92539CC88912D121F")

    private  Date genTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.339 -0400", hash_original_field = "5AC8FA15D9784805B8FF0C4AA2E3D558", hash_generated_field = "7F620060B53AB5F6E4FEDF4018644187")

    private  int [] accuracy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.340 -0400", hash_original_field = "A2AAF9DB8B239EBAA5E91AD1EDD1AEA7", hash_generated_field = "371F78781F3851FBAA3C212A1E817B48")

    private  Boolean ordering;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.340 -0400", hash_original_field = "13ECC8C436811ED0415BD7546AA2A777", hash_generated_field = "757A20AA999EACA0F78635F2872B1EB4")

    private  BigInteger nonce;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.341 -0400", hash_original_field = "23C9AB2F073E847B29BCA507797E7F55", hash_generated_field = "3AA19A75430F93B1C147E93D480AD7C9")

    private  GeneralName tsa;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.341 -0400", hash_original_field = "11D23A9D67ECEDEBAFCBDADBAE6E0FA1", hash_generated_field = "85FCB044EB3BC544E06DEC3DDF20CB7B")

    private  Extensions extensions;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.342 -0400", hash_original_method = "EBE62E1003ABE85506BEFDCD06621859", hash_generated_method = "C9DD90DAFE0BEB249AE4819DA46FC01D")
    
public TSTInfo(int version, String policy, MessageImprint messageImprint,
            BigInteger serialNumber, Date genTime, int[] accuracy,
            Boolean ordering, BigInteger nonce, GeneralName tsa,
            Extensions extensions) {
        this.version = version;
        this.policy = policy;
        this.messageImprint = messageImprint;
        this.serialNumber = serialNumber;
        this.genTime = genTime;
        this.accuracy = accuracy;
        this.ordering = ordering;
        this.nonce = nonce;
        this.tsa = tsa;
        this.extensions = extensions;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.343 -0400", hash_original_method = "49C94B13780CC851759F211DAA34706C", hash_generated_method = "043F3AC2389E30D3C1693AA50B4F96C2")
    
public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("-- TSTInfo:");
        res.append("\nversion:  ");
        res.append(version);
        res.append("\npolicy:  ");
        res.append(policy);
        res.append("\nmessageImprint:  ");
        res.append(messageImprint);
        res.append("\nserialNumber:  ");
        res.append(serialNumber);
        res.append("\ngenTime:  ");
        res.append(genTime);
        res.append("\naccuracy:  ");
        if (accuracy != null) {
            res.append(accuracy[0] + " sec, " + accuracy[1] + " millis, "
                    + accuracy[2] + " micros");
        }
        res.append("\nordering:  ");
        res.append(ordering);
        res.append("\nnonce:  ");
        res.append(nonce);
        res.append("\ntsa:  ");
        res.append(tsa);
        res.append("\nextensions:  ");
        res.append(extensions);
        res.append("\n-- TSTInfo End\n");
        return res.toString();
    }

    /**
     * @return Returns the accuracy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.343 -0400", hash_original_method = "F4F2E76E23CF172F44A64FB15F38D57F", hash_generated_method = "603287291546662233F891C8CD009786")
    
public int[] getAccuracy() {
        return accuracy;
    }

    /**
     * @return Returns the extensions.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.344 -0400", hash_original_method = "160E3DAB15A775FB370B26EA87125324", hash_generated_method = "AC0E4A307C58CB40EC876A42E8BF125F")
    
public Extensions getExtensions() {
        return extensions;
    }

    /**
     * @return Returns the genTime.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.344 -0400", hash_original_method = "59BC61D205AF6B7E9539E5DF7995D523", hash_generated_method = "CE0CB6C2858C93B550B0EEEB28BD52C2")
    
public Date getGenTime() {
        return genTime;
    }

    /**
     * @return Returns the messageImprint.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.345 -0400", hash_original_method = "F754893873D8ACD1B56A74C8D3BBC8F6", hash_generated_method = "B9FFFB28BC46A6694919DCECDB8919E3")
    
public MessageImprint getMessageImprint() {
        return messageImprint;
    }

    /**
     * @return Returns the nonce.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.345 -0400", hash_original_method = "5A0715EC9581419A677BD58A410EA977", hash_generated_method = "3F7E3B2E81F4D05FC8F1AEDD8D7730C4")
    
public BigInteger getNonce() {
        return nonce;
    }

    /**
     * @return Returns the ordering.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.346 -0400", hash_original_method = "E4188279B1F26F54BC3F249A6624F8E2", hash_generated_method = "B41258D3BB13B8596EDDA7BD450F8191")
    
public Boolean getOrdering() {
        return ordering;
    }

    /**
     * @return Returns the policy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.346 -0400", hash_original_method = "C642E404998EE9DFB2E1748D50CC78D7", hash_generated_method = "02616806D9065BF450E92A24B9536396")
    
public String getPolicy() {
        return policy;
    }

    /**
     * @return Returns the serialNumber.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.346 -0400", hash_original_method = "9420C2CEA2A6F47D515C0AB0605412CD", hash_generated_method = "207C06B8E3C7AEAA1442B3B5D400DFA7")
    
public BigInteger getSerialNumber() {
        return serialNumber;
    }

    /**
     * @return Returns the tsa.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.347 -0400", hash_original_method = "6F2917A7CF8594B6DDA433BEFA9F33CE", hash_generated_method = "E773160DBFBF3EA944E7DBDE7A234381")
    
public GeneralName getTsa() {
        return tsa;
    }

    /**
     * @return Returns the version.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.347 -0400", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "0A6C4E4591BB9051C220BECC5445085D")
    
public int getVersion() {
        return version;
    }
}
