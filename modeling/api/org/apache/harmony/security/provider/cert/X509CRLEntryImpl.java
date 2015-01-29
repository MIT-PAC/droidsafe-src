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

/**
* @author Alexander Y. Kleymenov
* @version $Revision$
*/

package org.apache.harmony.security.provider.cert;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.math.BigInteger;
import java.security.cert.CRLException;
import java.security.cert.X509CRLEntry;
import java.util.Date;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.x509.Extension;
import org.apache.harmony.security.x509.Extensions;
import org.apache.harmony.security.x509.TBSCertList;

/**
 * Implementation of X509CRLEntry. It wraps the instance
 * of org.apache.harmony.security.x509.TBSCertList.RevokedCertificate
 * obtained during the decoding of TBSCertList substructure
 * of the CertificateList structure which is an X.509 form of CRL.
 * (see RFC 3280 at http://www.ietf.org/rfc/rfc3280.txt)
 * Normally the instances of this class are constructed by involving
 * X509CRLImpl object.
 * @see org.apache.harmony.security.x509.TBSCertList
 * @see org.apache.harmony.security.provider.cert.X509CRLImpl
 * @see java.security.cert.X509CRLEntry
 */
public class X509CRLEntryImpl extends X509CRLEntry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:02.833 -0400", hash_original_field = "959617196A82551235CFEAD08E0DBB2A", hash_generated_field = "36D2DDB4D24C303CA6AA2DCFD0A74C59")

    private  TBSCertList.RevokedCertificate rcert;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:02.834 -0400", hash_original_field = "11D23A9D67ECEDEBAFCBDADBAE6E0FA1", hash_generated_field = "85FCB044EB3BC544E06DEC3DDF20CB7B")

    private  Extensions extensions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:02.834 -0400", hash_original_field = "99BE4463DA67376AA94F7D97DDB8D7FF", hash_generated_field = "30FEA84FB35EF28DB029D29044BA91EC")

    private  X500Principal issuer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:02.835 -0400", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    /**
     * Creates an instance on the base of existing
     * <code>TBSCertList.RevokedCertificate</code> object and
     * information about the issuer of revoked certificate.
     * If specified issuer is null, it is supposed that issuer
     * of the revoked certificate is the same as for involving CRL.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:02.835 -0400", hash_original_method = "CE7037EC5C32EFF20AA636D36C55F6B2", hash_generated_method = "4A0FBB80B109B632ACDCF50033F2E742")
    
public X509CRLEntryImpl(TBSCertList.RevokedCertificate rcert,
            X500Principal issuer) {
        this.rcert = rcert;
        this.extensions = rcert.getCrlEntryExtensions();
        this.issuer = issuer;
    }

    // ---------------------------------------------------------------------
    // ------ java.security.cert.X509CRLEntry method implementations -------
    // ---------------------------------------------------------------------

    /**
     * @see java.security.cert.X509CRLEntry#getEncoded()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:02.836 -0400", hash_original_method = "0B005D27EBAB1AE18B22B43C4480C672", hash_generated_method = "C143B1AD589FE9FCBF19171184370AD5")
    
public byte[] getEncoded() throws CRLException {
        if (encoding == null) {
            encoding = rcert.getEncoded();
        }
        byte[] result = new byte[encoding.length];
        System.arraycopy(encoding, 0, result, 0, encoding.length);
        return result;
    }

    /**
     * @see java.security.cert.X509CRLEntry#getSerialNumber()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:02.837 -0400", hash_original_method = "DC4E611BB7DBA806E5B0D73D7D1F33AE", hash_generated_method = "BDA181DA530A7CED57B1048554F8E0C2")
    
public BigInteger getSerialNumber() {
        return rcert.getUserCertificate();
    }

    /**
     * @see java.security.cert.X509CRLEntry#getCertificateIssuer()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:02.837 -0400", hash_original_method = "55A47A62A98FACA3A792EB3209D49A85", hash_generated_method = "DF1CE3310A34D75BCCFB79420236E39F")
    
public X500Principal getCertificateIssuer() {
        return issuer;
    }

    /**
     * @see java.security.cert.X509CRLEntry#getRevocationDate()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:02.838 -0400", hash_original_method = "D58C9C9C5C828651E91C604A72D538BA", hash_generated_method = "2F38F97F053445FE1B582E3DF4B1E0B6")
    
public Date getRevocationDate() {
        return rcert.getRevocationDate();
    }

    /**
     * @see java.security.cert.X509CRLEntry#hasExtensions()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:02.838 -0400", hash_original_method = "A0DD492AF82B95A8C038C99BA203FD2D", hash_generated_method = "1E6DEB8AB0F0343410302384C2A89AE7")
    
public boolean hasExtensions() {
        return (extensions != null) && (extensions.size() != 0);
    }

    /**
     * @see java.security.cert.X509CRLEntry#toString()
     * method documentation for more info
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:02.839 -0400", hash_original_method = "D3FD067573A7F3A676156DBC33431C92", hash_generated_method = "1F7595A73EBAD505ECD6745950B7BD44")
    
public String toString() {
        return "X509CRLEntryImpl: "+rcert.toString();
    }

    // ---------------------------------------------------------------------
    // ------ java.security.cert.X509Extension method implementations ------
    // ---------------------------------------------------------------------

    /**
     * @see java.security.cert.X509Extension#getNonCriticalExtensionOIDs()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:02.839 -0400", hash_original_method = "D4D5C9AC69DCBDFBA272C75E3E279C10", hash_generated_method = "DECB935D334A01930DC9BFB11F619EE3")
    
public Set getNonCriticalExtensionOIDs() {
        if (extensions == null) {
            return null;
        }
        return extensions.getNonCriticalExtensions();
    }

    /**
     * @see java.security.cert.X509Extension#getCriticalExtensionOIDs()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:02.840 -0400", hash_original_method = "356F6253943D47D7B8C3AC0E227CFED7", hash_generated_method = "414EE93E3AC7CFBC7E2BDA4F25E13A11")
    
public Set getCriticalExtensionOIDs() {
        if (extensions == null) {
            return null;
        }
        return extensions.getCriticalExtensions();
    }

    /**
     * @see java.security.cert.X509Extension#getExtensionValue(String)
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:02.840 -0400", hash_original_method = "46B3B0A81D238D78F58FF04050F493C3", hash_generated_method = "E8C81FF47A9BB78775EA85D53051AB41")
    
public byte[] getExtensionValue(String oid) {
        if (extensions == null) {
            return null;
        }
        Extension ext = extensions.getExtensionByOID(oid);
        return (ext == null) ? null : ext.getRawExtnValue();
    }

    /**
     * @see java.security.cert.X509Extension#hasUnsupportedCriticalExtension()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:02.841 -0400", hash_original_method = "CB7B238BECDE285B4B368E69C74FBD34", hash_generated_method = "C3454B954195A9906295E5AC12ECB3A6")
    
public boolean hasUnsupportedCriticalExtension() {
        if (extensions == null) {
            return false;
        }
        return extensions.hasUnsupportedCritical();
    }
}

