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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.security.auth.x500.X500Principal;

import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class Extensions {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.363 -0500", hash_original_field = "42FA37BFAF84C72CF9A38391C49666CB", hash_generated_field = "2D002C30AF2816E4CD220F420C40FBAD")

    private static List SUPPORTED_CRITICAL = Arrays.asList(
            "2.5.29.15", "2.5.29.19", "2.5.29.32", "2.5.29.17",
            "2.5.29.30", "2.5.29.36", "2.5.29.37", "2.5.29.54");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.224 -0400", hash_original_field = "9F138981CD4E842F83065885738EAA09", hash_generated_field = "325D4B839B8846AF06D5B6C75FEBE62A")

    public static final ASN1Type ASN1 = new ASN1SequenceOf(Extension.ASN1) {
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.423 -0500", hash_original_method = "399B7E2ADEDD12A1185F1F94F953221A", hash_generated_method = "8EBA7B1700E9CE82481AB4E2B800D147")
        
@Override public Object getDecodedObject(BerInputStream in) {
            return new Extensions((List<Extension>) in.content);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.426 -0500", hash_original_method = "29E9E68732A3D4A733046F4BF43E6588", hash_generated_method = "8F7256B1AB4AE15FFAE0D995FBABF310")
        
@Override public Collection getValues(Object object) {
            Extensions extensions = (Extensions) object;
            return (extensions.extensions == null) ? new ArrayList() : extensions.extensions;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.365 -0500", hash_original_field = "B51FC5B46C76A90B3145AC2796502191", hash_generated_field = "F93AA8349A2FA92AE6135244F491401E")

    private List<Extension> extensions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:59.584 -0400", hash_original_field = "AE3FFA204ACBD5822AEDD7ECEFE2C617", hash_generated_field = "8CC68CF570EB46026DADE729970001F7")

    // from the extensions field, initialized using the "single-check
    // idiom".

    private volatile Set<String> critical;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:59.585 -0400", hash_original_field = "28AB45C296623368EED00FE18BED7065", hash_generated_field = "CF9614A586D7678E7E6AB1AC482977DE")

    private volatile Set<String> noncritical;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.372 -0500", hash_original_field = "D57E5EBA9F24C62627B68CC3E1B75531", hash_generated_field = "0D8541320F975D3461EC52A0319B459E")

    // in the list of extensions or not.
    private boolean hasUnsupported;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.375 -0500", hash_original_field = "78DC224FB3912B2FA57C7437B2F8B95B", hash_generated_field = "0ED2D670841DD665E41E94FA17013C03")

    // Extension objects as values
    private HashMap<String, Extension> oidMap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.377 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    /**
     * Constructs an object representing the value of Extensions.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.380 -0500", hash_original_method = "4F6254C867328A153FDD5BD23453E816", hash_generated_method = "DA7F1F18A359C63EC62E782C4227E19E")
    
public Extensions() {}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.382 -0500", hash_original_method = "89146A86DD080B3422EC5033031F1DF4", hash_generated_method = "B2D1968B644A8A34AE1D5C2C18C0BF77")
    
public Extensions(List<Extension> extensions) {
        this.extensions = extensions;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.384 -0500", hash_original_method = "B4520EB3CA6AF47BBFFA43544D7C2D00", hash_generated_method = "056F2CA0B83280C1BD16F0917FB6A08A")
    
public int size() {
        return (extensions == null) ? 0 : extensions.size();
    }

    /**
     * Returns the list of critical extensions.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.387 -0500", hash_original_method = "6A8A6C791C17F1564EF710302C5F6E38", hash_generated_method = "2618D6CEEEEAB1746A31376F537663D4")
    
public Set<String> getCriticalExtensions() {
        if (critical == null) {
            makeOidsLists();
        }
        return critical;
    }

    /**
     * Returns the list of critical extensions.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.389 -0500", hash_original_method = "A9814A684588F34F98E6563F2443DAA6", hash_generated_method = "F280E54F7326C27F28047DE0D8A2A979")
    
public Set<String> getNonCriticalExtensions() {
        if (noncritical == null) {
            makeOidsLists();
        }
        return noncritical;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.391 -0500", hash_original_method = "CA1C7754653BDDEC58CFB11BB71C11DB", hash_generated_method = "9B6ACF4319C39E86FFB2517F0E7EFB39")
    
public boolean hasUnsupportedCritical() {
        if (critical == null) {
            makeOidsLists();
        }
        return hasUnsupported;
    }

    //
    // Makes the separated lists with oids of critical
    // and non-critical extensions
    //
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.393 -0500", hash_original_method = "F144B02FA833AD81E1DCC6E0D8E9952F", hash_generated_method = "9EF5BFE90F18388235246E981C980A7F")
    
private void makeOidsLists() {
        if (extensions == null) {
            return;
        }
        int size = extensions.size();
        critical = new HashSet<String>(size);
        noncritical = new HashSet<String>(size);
        for (Extension extension : extensions) {
            String oid = extension.getExtnID();
            if (extension.getCritical()) {
                if (!SUPPORTED_CRITICAL.contains(oid)) {
                    hasUnsupported = true;
                }
                critical.add(oid);
            } else {
                noncritical.add(oid);
            }
        }
    }

    /**
     * Returns the values of extensions.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.396 -0500", hash_original_method = "44703E9781E0014C266798D0DB277AFC", hash_generated_method = "3B94A6E4CD2397F51FCDBC63DC21E49A")
    
public Extension getExtensionByOID(String oid) {
        if (extensions == null) {
            return null;
        }
        if (oidMap == null) {
            oidMap = new HashMap<String, Extension>();
            for (Extension extension : extensions) {
                oidMap.put(extension.getExtnID(), extension);
            }
        }
        return oidMap.get(oid);
    }

    /**
     * Returns the value of Key Usage extension (OID == 2.5.29.15).
     * The ASN.1 definition of Key Usage Extension is:
     *
     * <pre>
     * id-ce-keyUsage OBJECT IDENTIFIER ::=  { id-ce 15 }
     *
     * KeyUsage ::= BIT STRING {
     *     digitalSignature        (0),
     *     nonRepudiation          (1),
     *     keyEncipherment         (2),
     *     dataEncipherment        (3),
     *     keyAgreement            (4),
     *     keyCertSign             (5),
     *     cRLSign                 (6),
     *     encipherOnly            (7),
     *     decipherOnly            (8)
     * }
     * </pre>
     * (as specified in RFC 3280)
     *
     * @return the value of Key Usage Extension if it is in the list,
     * and null if there is no such extension or its value can not be decoded
     * otherwise. Note, that the length of returned array can be greater
     * than 9.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.398 -0500", hash_original_method = "67C71F044BBB9B405BEFA4564A602892", hash_generated_method = "3516EA65A0D79D1A6A81BE0EFE52778A")
    
public boolean[] valueOfKeyUsage() {
        Extension extension = getExtensionByOID("2.5.29.15");
        KeyUsage kUsage;
        if ((extension == null) || ((kUsage = extension.getKeyUsageValue()) == null)) {
            return null;
        }
        return kUsage.getKeyUsage();
    }

    /**
     * Returns the value of Extended Key Usage extension (OID == 2.5.29.37).
     * The ASN.1 definition of Extended Key Usage Extension is:
     *
     * <pre>
     *  id-ce-extKeyUsage OBJECT IDENTIFIER ::= { id-ce 37 }
     *
     *  ExtKeyUsageSyntax ::= SEQUENCE SIZE (1..MAX) OF KeyPurposeId
     *
     *  KeyPurposeId ::= OBJECT IDENTIFIER
     * </pre>
     * (as specified in RFC 3280)
     *
     * @return the list with string representations of KeyPurposeId's OIDs
     * and null
     * @throws IOException if extension was incorrectly encoded.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.401 -0500", hash_original_method = "84A63CE35CC08D6818168132AFB51A65", hash_generated_method = "E615621ACA7E7447A6B2E270FF233B33")
    
public List<String> valueOfExtendedKeyUsage() throws IOException {
        Extension extension = getExtensionByOID("2.5.29.37");
        if (extension == null) {
            return null;
        }
        return ((ExtendedKeyUsage) extension.getDecodedExtensionValue()).getExtendedKeyUsage();
    }

    /**
     * Returns the value of Basic Constraints Extension (OID = 2.5.29.19).
     * The ASN.1 definition of Basic Constraints Extension is:
     *
     * <pre>
     *   id-ce-basicConstraints OBJECT IDENTIFIER ::=  { id-ce 19 }
     *
     *   BasicConstraints ::= SEQUENCE {
     *        cA                      BOOLEAN DEFAULT FALSE,
     *        pathLenConstraint       INTEGER (0..MAX) OPTIONAL
     *   }
     * </pre>
     * (as specified in RFC 3280)
     *
     * @return the value of pathLenConstraint field if extension presents,
     * and Integer.MAX_VALUE if does not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.403 -0500", hash_original_method = "CD9DAABD8089C73414664CD384AA791C", hash_generated_method = "57EC973D24DE4CACD8BEFDE21D2684CC")
    
public int valueOfBasicConstrains() {
        Extension extension = getExtensionByOID("2.5.29.19");
        BasicConstraints bc;
        if ((extension == null) || ((bc = extension.getBasicConstraintsValue()) == null)) {
            return Integer.MAX_VALUE;
        }
        return bc.getPathLenConstraint();
    }

    /**
     * Returns the value of Subject Alternative Name (OID = 2.5.29.17).
     * The ASN.1 definition for Subject Alternative Name is:
     *
     * <pre>
     *  id-ce-subjectAltName OBJECT IDENTIFIER ::=  { id-ce 17 }
     *
     *  SubjectAltName ::= GeneralNames
     * </pre>
     * (as specified in RFC 3280)
     *
     * @return Returns the collection of pairs:
     * (Integer (tag), Object (name value)) if extension presents, and
     * null if does not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.405 -0500", hash_original_method = "05742F8CFC468BD801B4E723F95A84AD", hash_generated_method = "6780C5AFB729747AAA0A81BC486BB41A")
    
public Collection<List<?>> valueOfSubjectAlternativeName() throws IOException {
        Extension extension = getExtensionByOID("2.5.29.17");
        if (extension == null) {
            return null;
        }
        return ((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList();
    }

    /**
     * Returns the value of Issuer Alternative Name Extension (OID = 2.5.29.18).
     * The ASN.1 definition for Issuer Alternative Name is:
     *
     * <pre>
     *   id-ce-issuerAltName OBJECT IDENTIFIER ::=  { id-ce 18 }
     *
     *   IssuerAltName ::= GeneralNames
     * </pre>
     * (as specified in RFC 3280)
     *
     * @return Returns the collection of pairs:
     * (Integer (tag), Object (name value)) if extension presents, and
     * null if does not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.408 -0500", hash_original_method = "03BB26B095671170BC4A5910FD38473D", hash_generated_method = "E3EB0B4C38D13C536DFF16705680F04B")
    
public Collection<List<?>> valueOfIssuerAlternativeName() throws IOException {
        Extension extension = getExtensionByOID("2.5.29.18");
        if (extension == null) {
            return null;
        }
        return ((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList();
    }

    /**
     * Returns the value of Certificate Issuer Extension (OID = 2.5.29.29).
     * It is a CRL entry extension and contains the GeneralNames describing
     * the issuer of revoked certificate. Its ASN.1 notation is as follows:
     * <pre>
     *   id-ce-certificateIssuer   OBJECT IDENTIFIER ::= { id-ce 29 }
     *
     *   certificateIssuer ::=     GeneralNames
     * </pre>
     * (as specified in RFC 3280)
     *
     * @return the value of Certificate Issuer Extension
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.410 -0500", hash_original_method = "7B080EDEBF008BF89BEA15CA32B37546", hash_generated_method = "E5E218BE8B9EC5B014A4380EC75889C4")
    
public X500Principal valueOfCertificateIssuerExtension() throws IOException {
        Extension extension = getExtensionByOID("2.5.29.29");
        if (extension == null) {
            return null;
        }
        return ((CertificateIssuer) extension.getDecodedExtensionValue()).getIssuer();
    }

    /**
     * Returns ASN.1 encoded form of this X.509 Extensions value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.412 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.415 -0500", hash_original_method = "C22B11DD1D34238E2A26C4258C487EE2", hash_generated_method = "0C2F0ABDF01B438AAF92A2C1495A31B9")
    
@Override public boolean equals(Object other) {
        if (!(other instanceof Extensions)) {
            return false;
        }
        Extensions that = (Extensions) other;
        return (this.extensions == null || this.extensions.isEmpty())
                    ? (that.extensions == null || that.extensions.isEmpty())
                    : (this.extensions.equals(that.extensions));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.417 -0500", hash_original_method = "4C94C64ABE7312C3D3BBBB76E6D36C32", hash_generated_method = "33AEAF576561AD2042B1BDAD86847353")
    
@Override public int hashCode() {
        int hashCode = 0;
        if (extensions != null) {
            hashCode = extensions.hashCode();
        }
        return hashCode;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.420 -0500", hash_original_method = "F4C0EB00BC61B6C3C716F9B41C861C66", hash_generated_method = "7B715A5ACF42267C6A1209C88309010A")
    
public void dumpValue(StringBuilder sb, String prefix) {
        if (extensions == null) {
            return;
        }
        int num = 1;
        for (Extension extension: extensions) {
            sb.append('\n').append(prefix).append('[').append(num++).append("]: ");
            extension.dumpValue(sb, prefix);
        }
    }
}

