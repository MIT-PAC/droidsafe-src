/*
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

package java.security.cert;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

/**
 * Abstract base class for entries in a certificate revocation list (CRL).
 *
 * @see X509CRL
 */
public abstract class X509CRLEntry implements X509Extension {

    /**
     * Creates a new {@code X509CRLEntry} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.034 -0400", hash_original_method = "A0B71E28762B6428D3E944EDB5F16B54", hash_generated_method = "69B6D96AE564E5BDA10683BABC6B83EB")
    
public X509CRLEntry() {}

    /**
     * Returns whether the specified object equals to this instance.
     *
     * @param other
     *            the object to compare.
     * @return {@code true} if the specified object equals to this instance,
     *         otherwise {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.036 -0400", hash_original_method = "0B3373746F630C1C5A30B3A669FD61CB", hash_generated_method = "24F907DF1493799F9532DB3221411F9B")
    
public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof X509CRLEntry)) {
            return false;
        }
        X509CRLEntry obj = (X509CRLEntry) other;
        try {
            return Arrays.equals(getEncoded(), obj.getEncoded());
        } catch (CRLException e) {
            return false;
        }
    }

    /**
     * Returns the hashcode of this instance.
     *
     * @return the hashcode of this instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.037 -0400", hash_original_method = "3F434D0C038C42D08B69CA2BE1345E37", hash_generated_method = "1BEABD95BAB5FDF6787F70CCAF09F7E3")
    
public int hashCode() {
        int res = 0;
        try {
            byte[] array = getEncoded();
            for (int i=0; i<array.length; i++) {
                res += array[i] & 0xFF;
            }
        } catch (CRLException e) {
        }
        return res;
    }

    /**
     * Returns this entry in ASN.1 DER encoded form.
     *
     * @return the encoded form of this entry.
     * @throws CRLException
     *             if encoding fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.039 -0400", hash_original_method = "FC55581283358EA6D0060240A5ACF549", hash_generated_method = "F231EC0E41468E770571456AAD350EA8")
    
public abstract byte[] getEncoded() throws CRLException;

    /**
     * Returns the serial number of the revoked certificate.
     *
     * @return the serial number of the revoked certificate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.040 -0400", hash_original_method = "2D5882042D282C86B57A0B6CD5FE19CE", hash_generated_method = "D29148C5FFC0F0105CF1B0377A4956B6")
    
public abstract BigInteger getSerialNumber();

    /**
     * Returns the issuer of the revoked certificate.
     *
     * @return the issuer of the revoked certificate, or {@code null} if the
     *         issuer is equal to the CRL issuer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.041 -0400", hash_original_method = "817A8A0BA70BA6E03B091011EF4F2F09", hash_generated_method = "39682CC0A82356625C6E691B2AF6D8EB")
    
public X500Principal getCertificateIssuer() {
        return null;
    }

    /**
     * Returns the date when the certificate is revoked.
     *
     * @return the date when the certificate is revoked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.043 -0400", hash_original_method = "508331D3230D5928675ACD458AB74168", hash_generated_method = "DDCF45D51BA60331A6751972846A98D0")
    
public abstract Date getRevocationDate();

    /**
     * Returns whether this CRL entry has extensions.
     *
     * @return {@code true} is this CRL entry has extensions, otherwise {@code
     *         false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.044 -0400", hash_original_method = "133BF7050D739D64B3C95C836DC73136", hash_generated_method = "B9C43F65D6A7DE187E72CDEE1F5AE012")
    
public abstract boolean hasExtensions();

    /**
     * Returns a string representation of this instance.
     *
     * @return a string representation of this instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.046 -0400", hash_original_method = "D4E4943029EE450E10D723A13B21ADBA", hash_generated_method = "7EA90E50E51652C3FF11C3BD32031D10")
    
public abstract String toString();
}

