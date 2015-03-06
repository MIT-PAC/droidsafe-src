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


package java.security.cert;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.security.PublicKey;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.utils.Array;
import org.apache.harmony.security.x509.NameConstraints;

/**
 * This class represents a trust anchor for validation of X.509 certification
 * path.
 * <p>
 * It is a <i>trusted</i> certificate authority (CA) and includes the public key
 * of the CA, the CA's name and the constraints for the validation of
 * certification paths. The constructor also allows to specify a binary
 * representation of a so called "Name Constraints" extension as a byte array.
 */
public class TrustAnchor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.968 -0400", hash_original_field = "234188FEFB38E1ADBBB917F8E64005AB", hash_generated_field = "9D6FAA468DB41C091CF16920AC1EB7EF")

    private  X500Principal caPrincipal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.970 -0400", hash_original_field = "02814CB6169BC6025A0BA0703B3FBEE0", hash_generated_field = "34D9736F48C51DB7B02196FF5B7816F0")

    private  String caName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.972 -0400", hash_original_field = "D58A152C859F398220C8C894156A4A43", hash_generated_field = "E37C42B61D3DFF4EC072402B672193B9")

    private  PublicKey caPublicKey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.974 -0400", hash_original_field = "58FCBB751C27687796BE809409A1DB67", hash_generated_field = "2BA5777C8FAC2077B2CFF6510B5896EB")

    private  X509Certificate trustedCert;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.975 -0400", hash_original_field = "AD436D30489E84941890DFE516D9AAC2", hash_generated_field = "8AFE2899208D7E8C59C6C0AB8ABFE9C4")

    private  byte[] nameConstraints;

    /**
     * Creates a new {@code TrustAnchor} with the specified certificate and name
     * constraints.
     * <p>
     * The name constraints will be used as additional constraints during the
     * validation of certification paths.
     *
     * @param trustedCert
     *            the trusted certificate
     * @param nameConstraints
     *            the ASN.1 DER encoded form of the name constraints or {@code
     *            null} if none.
     * @throws IllegalArgumentException
     *             if the decoding of the name constraints fail.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.977 -0400", hash_original_method = "0E8AA0ECEF4D1353D43350844259EF25", hash_generated_method = "113B6BCF462EB67C44BFBEE92BD08A25")
    
public TrustAnchor(X509Certificate trustedCert, byte[] nameConstraints) {
        if (trustedCert == null) {
            throw new NullPointerException("trustedCert == null");
        }
        this.trustedCert = trustedCert;
        // copy nameConstraints if not null
        if (nameConstraints != null) {
            this.nameConstraints = new byte[nameConstraints.length];
            System.arraycopy(nameConstraints, 0,
                    this.nameConstraints, 0, this.nameConstraints.length);
            processNameConstraints();
        } else {
            this.nameConstraints = null;
        }
        this.caName = null;
        this.caPrincipal = null;
        this.caPublicKey = null;
    }

    /**
     * Creates a new {@code TrustAnchor} with the specified certificate
     * authority name, its public key and the specified name constraints.
     * <p>
     * The name constraints will be used as additional constraints during the
     * validation of certification paths.
     *
     * @param caName
     *            the X.500 name of the certificate authority in RFC 2253
     *            {@code String} format.
     * @param caPublicKey
     *            the public key of the certificate authority
     * @param nameConstraints
     *            the ASN.1 DER encoded form of the name constraints or {@code
     *            null} if none.
     * @throws IllegalArgumentException
     *             if the {@code caName} is empty or if decoding of the name
     *             constraints fail.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.978 -0400", hash_original_method = "DDEC7D9DFB8D9A06A86681D1635AE835", hash_generated_method = "73BBAF6D08B6F9989FE63FEDB02E8047")
    
public TrustAnchor(String caName, PublicKey caPublicKey,
            byte[] nameConstraints) {
        if (caName == null) {
            throw new NullPointerException("caName == null");
        }
        this.caName = caName;
        if (caPublicKey == null) {
            throw new NullPointerException("caPublicKey == null");
        }
        this.caPublicKey = caPublicKey;
        // copy nameConstraints if not null
        if (nameConstraints != null) {
            this.nameConstraints = new byte[nameConstraints.length];
            System.arraycopy(nameConstraints, 0,
                    this.nameConstraints, 0, this.nameConstraints.length);
            processNameConstraints();
        } else {
            this.nameConstraints = null;
        }

        this.trustedCert = null;

        // X500Principal checks caName validity
        if (caName.isEmpty()) {
            throw new IllegalArgumentException("caName.isEmpty()");
        }
        this.caPrincipal = new X500Principal(this.caName);
    }

    /**
     * Creates a new {@code TrustAnchor} with the specified certificate
     * authority name as principal, its public key and the specified name
     * constraints.
     * <p>
     * The name constraints will be used as additional constraints during the
     * validation of certification paths.
     *
     * @param caPrincipal
     *            the name of the certificate authority as X500 principal.
     * @param caPublicKey
     *            the public key of the certificate authority.
     * @param nameConstraints
     *            the ASN.1 DER encoded form of the name constraints or {@code
     *            null} if none.
     * @throws IllegalArgumentException
     *             if decoding of the name constraints fail.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.980 -0400", hash_original_method = "800778F1C1C7962B91A85AB0FC4F5BD6", hash_generated_method = "9A1842F9D67DB1B689D7EAE5210BD837")
    
public TrustAnchor(X500Principal caPrincipal,
            PublicKey caPublicKey, byte[] nameConstraints) {
        if (caPrincipal == null) {
            throw new NullPointerException("caPrincipal == null");
        }
        this.caPrincipal = caPrincipal;
        if (caPublicKey == null) {
            throw new NullPointerException("caPublicKey == null");
        }
        this.caPublicKey = caPublicKey;
        // copy nameConstraints if not null
        if (nameConstraints != null) {
            this.nameConstraints = new byte[nameConstraints.length];
            System.arraycopy(nameConstraints, 0,
                    this.nameConstraints, 0, this.nameConstraints.length);
            processNameConstraints();
        } else {
            this.nameConstraints = null;
        }

        this.trustedCert = null;
        this.caName = caPrincipal.getName();
    }

    /**
     * Returns a copy of the name constraints in ASN.1 DER encoded form.
     *
     * @return a copy of the name constraints in ASN.1 DER encoded form.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.982 -0400", hash_original_method = "2AAE72529DE1C22AC7EC0FC7E0F9A4F9", hash_generated_method = "646D731B707B83203E27E4FF83A7E0E7")
    
public final byte[] getNameConstraints() {
        if (nameConstraints == null) {
            return null;
        }
        byte[] ret = new byte[nameConstraints.length];
            System.arraycopy(nameConstraints, 0,
                    ret, 0, nameConstraints.length);
        return ret;
    }

    /**
     * Returns the certificate of this <i>trusted</i> certificate authority.
     *
     * @return the certificate of this CA or {@code null}, if the trust anchor
     *         of this instance was not created with a certificate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.983 -0400", hash_original_method = "7B437C744AB4032F350463B59D5E444B", hash_generated_method = "2615917C57C854912F47CB98A1612645")
    
public final X509Certificate getTrustedCert() {
        return trustedCert;
    }

    /**
     * Returns the name of the certificate authority as {@code X500Principal}.
     *
     * @return the name of the certificate authority or {@code null} if the
     *         trust anchor of this instance was not created with a {@code
     *         X500Principal}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.985 -0400", hash_original_method = "DA62DD8DD0EC19D712317FEE93B4A51C", hash_generated_method = "7AEDC6D7CE6BE0379A2BC94FB54FBEA5")
    
public final X500Principal getCA() {
        return caPrincipal;
    }

    /**
     * Returns the name of the certificate authority as {@code String} in RFC
     * 2253 format.
     *
     * @return the name of the certificate authority as {@code String} in RFC
     *         2253 format or {@code null} if the trust anchor of this instance
     *         was not created with a CA name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.987 -0400", hash_original_method = "52E6CFE29E1F37AF17FFF7E28C6AD532", hash_generated_method = "D8C44A2D8D68AD9385A54DA4C584FCD0")
    
public final String getCAName() {
        return caName;
    }

    /**
     * Returns the public key of the certificate authority.
     *
     * @return the public key of the certificate authority or {@code null} if
     *         the trust anchor if this instance was not created with a public
     *         key.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.988 -0400", hash_original_method = "5F1921DF87FB3039EAB0FAC005E4A48C", hash_generated_method = "7F48808E3A8D588949298E33F24C980F")
    
public final PublicKey getCAPublicKey() {
        return caPublicKey;
    }

    /**
     * Returns a string representation of this {@code TrustAnchor} instance.
     *
     * @return a string representation of this {@code TrustAnchor} instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.990 -0400", hash_original_method = "343584D33601870512655CC46D6EE2A0", hash_generated_method = "BE1706A18A5646F9D9A9045F25291A91")
    
public String toString() {
        StringBuilder sb = new StringBuilder("TrustAnchor: [\n");
        if (trustedCert != null) {
            sb.append("Trusted CA certificate: ");
            sb.append(trustedCert);
            sb.append("\n");
        }
        if (caPrincipal != null) {
            sb.append("Trusted CA Name: ");
            sb.append(caPrincipal);
            sb.append("\n");
        }
        if (caPublicKey != null) {
            sb.append("Trusted CA Public Key: ");
            sb.append(caPublicKey);
            sb.append("\n");
        }
        // FIXME if needed:
        if (nameConstraints != null) {
            sb.append("Name Constraints:\n");
            sb.append(Array.toString(nameConstraints, "    "));
        }
        sb.append("\n]");
        return sb.toString();
    }

    //
    // Private stuff
    //

    // Decodes and checks NameConstraints structure.
    // Throws IllegalArgumentException if NameConstraints
    // encoding is invalid.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.991 -0400", hash_original_method = "B958C315AE6F112FB993B09CC142DF1C", hash_generated_method = "2019C89F79CDA74CF08440E04EEF2936")
    
private void processNameConstraints() {
        try {
            // decode and check nameConstraints
            NameConstraints.ASN1.decode(nameConstraints);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
