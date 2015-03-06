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
import org.apache.harmony.security.asn1.ASN1Boolean;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;
import org.apache.harmony.security.x509.Extensions;

/**
 * As defined in Time-Stamp Protocol (TSP)
 * (http://www.ietf.org/rfc/rfc3161.txt)
 *
 * TimeStampReq ::= SEQUENCE  {
 *    version                      INTEGER  { v1(1) },
 *    messageImprint               MessageImprint,
 *      --a hash algorithm OID and the hash value of the data to be
 *      --time-stamped
 *    reqPolicy             TSAPolicyId              OPTIONAL,
 *    nonce                 INTEGER                  OPTIONAL,
 *    certReq               BOOLEAN                  DEFAULT FALSE,
 *    extensions            [0] IMPLICIT Extensions  OPTIONAL
 *  }
 *
 *  TSAPolicyId ::= OBJECT IDENTIFIER
 */
public class TimeStampReq {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.538 -0400", hash_original_field = "195DEF8DA0DC357B52D9A81D10B469DB", hash_generated_field = "240CDB1590A86ADEE0AB913FBB2E0B5D")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Integer.getInstance(),              // version
            MessageImprint.ASN1,                    // messageImprint
            ASN1Oid.getInstance(),                  // reqPolicy
            ASN1Integer.getInstance(),              // nonce
            ASN1Boolean.getInstance(),              // certReq
            new ASN1Implicit(0, Extensions.ASN1)}) {// extensions

        {
            setDefault(Boolean.FALSE, 4);
            setOptional(2);
            setOptional(3);
            setOptional(5);
        }

        protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;

            String objID = (values[2] == null) ? null : ObjectIdentifier
                    .toString((int[]) values[2]);
            BigInteger nonce = (values[3] == null) ? null : new BigInteger(
                    (byte[]) values[3]);

            if (values[5] == null) {
                return new TimeStampReq(
                        ASN1Integer.toIntValue(values[0]),
                        (MessageImprint) values[1],
                        objID,
                        nonce,
                        (Boolean) values[4],
                        null,
                        in.getEncoded()
                   );
            } else {
                return new TimeStampReq(
                        ASN1Integer.toIntValue(values[0]),
                        (MessageImprint) values[1],
                        objID,
                        nonce,
                        (Boolean) values[4],
                        (Extensions) values[5],
                        in.getEncoded()
                   );
            }
        }

        protected void getValues(Object object, Object[] values) {
            TimeStampReq req = (TimeStampReq) object;
            values[0] = ASN1Integer.fromIntValue(req.version);
            values[1] = req.messageImprint;
            values[2] = (req.reqPolicy == null) ? null : ObjectIdentifier
                    .toIntArray(req.reqPolicy);
            values[3] = (req.nonce == null) ? null : req.nonce.toByteArray();
            values[4] = (req.certReq == null) ? Boolean.FALSE : req.certReq;
            values[5] = req.extensions;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.526 -0400", hash_original_field = "971D53A5DDB5A515B8A18CE48C276387", hash_generated_field = "605FE2D9A0C9E94D1E2D3DAEDB658980")

    private  int version;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.527 -0400", hash_original_field = "F31921A0A5D0631E718887C96E89AF46", hash_generated_field = "49C20C38279D6EB96121ADC1E18E3831")

    private  MessageImprint messageImprint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.527 -0400", hash_original_field = "0B83796B0F4DFFA0B602C1048E189731", hash_generated_field = "EB9ADD321BC84A5A297B60CB461D5D7A")

    private  String reqPolicy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.528 -0400", hash_original_field = "13ECC8C436811ED0415BD7546AA2A777", hash_generated_field = "757A20AA999EACA0F78635F2872B1EB4")

    private  BigInteger nonce;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.528 -0400", hash_original_field = "118DBFBD42D14D580C68A8D47031BFBA", hash_generated_field = "980FD6DB708CE6AD9B7F35081A20BEE3")

    private  Boolean certReq;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.529 -0400", hash_original_field = "11D23A9D67ECEDEBAFCBDADBAE6E0FA1", hash_generated_field = "85FCB044EB3BC544E06DEC3DDF20CB7B")

    private  Extensions extensions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.529 -0400", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte [] encoding;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.530 -0400", hash_original_method = "EA86B6226482E0914C83FEE08F261E7D", hash_generated_method = "3FF6AD5E37FD5D59741CC1CD331CD76C")
    
public TimeStampReq(int version, MessageImprint messageImprint,
            String reqPolicy, BigInteger nonce, Boolean certReq,
            Extensions extensions) {
        this.version = version;
        this.messageImprint = messageImprint;
        this.reqPolicy = reqPolicy;
        this.nonce = nonce;
        this.certReq = certReq;
        this.extensions = extensions;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.530 -0400", hash_original_method = "83B3DB15E2DAC304630913DA6C73D13E", hash_generated_method = "AEE75C2966F19285FE289FD82EE611A7")
    
private TimeStampReq(int version, MessageImprint messageImprint,
            String reqPolicy, BigInteger nonce, Boolean certReq,
            Extensions extensions, byte [] encoding) {
        this (version, messageImprint, reqPolicy, nonce, certReq, extensions);
        this.encoding = encoding;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.531 -0400", hash_original_method = "C990FF7DCD43A163EFDB707B017F87DB", hash_generated_method = "C0447E21CCCE90BF049F547722F3988B")
    
public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("-- TimeStampReq:");
        res.append("\nversion : ");
        res.append(version);
        res.append("\nmessageImprint:  ");
        res.append(messageImprint);
        res.append("\nreqPolicy:  ");
        res.append(reqPolicy);
        res.append("\nnonce:  ");
        res.append(nonce);
        res.append("\ncertReq:  ");
        res.append(certReq);
        res.append("\nextensions:  ");
        res.append(extensions);
        res.append("\n-- TimeStampReq End\n");
        return res.toString();
    }

    /**
     * Returns ASN.1 encoded form of this TimeStampReq.
     * @return a byte array containing ASN.1 encoded form.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.532 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    
public byte [] getEncoded(){
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }

    /**
     * @return Returns the certReq.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.532 -0400", hash_original_method = "673E14F00397DEB9EFC20A6F8DA57173", hash_generated_method = "CB9380B420320ED744AD5BF140279273")
    
public Boolean getCertReq() {
        return certReq;
    }

    /**
     * @return Returns the extensions.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.533 -0400", hash_original_method = "160E3DAB15A775FB370B26EA87125324", hash_generated_method = "AC0E4A307C58CB40EC876A42E8BF125F")
    
public Extensions getExtensions() {
        return extensions;
    }

    /**
     * @return Returns the messageImprint.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.533 -0400", hash_original_method = "F754893873D8ACD1B56A74C8D3BBC8F6", hash_generated_method = "B9FFFB28BC46A6694919DCECDB8919E3")
    
public MessageImprint getMessageImprint() {
        return messageImprint;
    }

    /**
     * @return Returns the nonce.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.534 -0400", hash_original_method = "5A0715EC9581419A677BD58A410EA977", hash_generated_method = "3F7E3B2E81F4D05FC8F1AEDD8D7730C4")
    
public BigInteger getNonce() {
        return nonce;
    }

    /**
     * @return Returns the reqPolicy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.534 -0400", hash_original_method = "E8FA4C09C004315818D0E5B97A24D825", hash_generated_method = "C18041CFE7DFDE634B3CA9DE1F60C34C")
    
public String getReqPolicy() {
        return reqPolicy;
    }

    /**
     * @return Returns the version.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.534 -0400", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "0A6C4E4591BB9051C220BECC5445085D")
    
public int getVersion() {
        return version;
    }

}

