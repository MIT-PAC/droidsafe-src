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
import java.io.IOException;
import java.math.BigInteger;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import libcore.util.EmptyArray;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.utils.Array;
import org.apache.harmony.security.x509.AlgorithmIdentifier;
import org.apache.harmony.security.x509.CertificatePolicies;
import org.apache.harmony.security.x509.GeneralName;
import org.apache.harmony.security.x509.GeneralNames;
import org.apache.harmony.security.x509.NameConstraints;
import org.apache.harmony.security.x509.PolicyInformation;
import org.apache.harmony.security.x509.PrivateKeyUsagePeriod;
import org.apache.harmony.security.x509.SubjectPublicKeyInfo;

/**
 * A certificate selector ({@code CertSelector} for selecting {@code
 * X509Certificate}s that match the specified criteria.
 */
public class X509CertSelector implements CertSelector {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.545 -0400", hash_original_field = "28F31B82C7530FBA8153FD4AAFC2BF70", hash_generated_field = "1CC436616CE70A7C50F861DEB36A24B0")

    private X509Certificate certificateEquals;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.546 -0400", hash_original_field = "357D34BE4D3F218CD8ADF717DBF7DD40", hash_generated_field = "8556E85255DE7EB3D2D59484E44C2BAC")

    private BigInteger serialNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.548 -0400", hash_original_field = "99BE4463DA67376AA94F7D97DDB8D7FF", hash_generated_field = "30FEA84FB35EF28DB029D29044BA91EC")

    private X500Principal issuer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.549 -0400", hash_original_field = "26CC832F307ECF2BD351D71B87043988", hash_generated_field = "8CF0747DE4D6C16C4D3247696805E314")

    private X500Principal subject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.550 -0400", hash_original_field = "EE2D907EA92BBD8D93DDB2DBF36A3B42", hash_generated_field = "B3AE5B8B5AACE22F5B989D01DF60B8D8")

    private byte[] subjectKeyIdentifier;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.551 -0400", hash_original_field = "98F15D2DE47BD270A4F82535AB7B1125", hash_generated_field = "ADE821477A7FCE748DE0196E61DC3922")

    private byte[] authorityKeyIdentifier;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.552 -0400", hash_original_field = "240FA96B0EE445964AC6D319349CB711", hash_generated_field = "853528459BD97DA133301F93ACC080B5")

    private Date certificateValid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.553 -0400", hash_original_field = "7C9B58A85C472C6976F5C6DF6CCDCFB2", hash_generated_field = "2F167CAFE469571C8D5410E03E6C4F35")

    private String subjectPublicKeyAlgID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.555 -0400", hash_original_field = "DEC3B2ECC9BFCBF945802931BD12B470", hash_generated_field = "1792D2B667C7A7BA5AB021EB1C04E57D")

    private Date privateKeyValid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.557 -0400", hash_original_field = "289FEAC5B4C17545B61B3DF43A1221AB", hash_generated_field = "741B868AD923CC223249852F373451D2")

    private byte[] subjectPublicKey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.558 -0400", hash_original_field = "897E439B15C131A3FA7BEC4524A38C16", hash_generated_field = "C6468962076BC1172F0F351DE545D4EE")

    private boolean[] keyUsage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.559 -0400", hash_original_field = "D536D1B5B62EFAF79073DCB5C35CA774", hash_generated_field = "3DC5D521A9C8F20501296960AA87644F")

    private Set<String> extendedKeyUsage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.561 -0400", hash_original_field = "C827C798C89B5D0E861AFB1DD4A19909", hash_generated_field = "07034503EB1F8ABBA17B30E5BB7F4AD1")

    private boolean matchAllNames = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.562 -0400", hash_original_field = "16AAED112955967E7F84981EF4DE2926", hash_generated_field = "F4F5E2533D7C38D8F1C1B6DE34BBF62A")

    private int pathLen = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.563 -0400", hash_original_field = "EA32BB013D81C771D9DC410D2B194170", hash_generated_field = "4640DCBC2DA55A469D482BF3400E236E")

    private List<GeneralName>[] subjectAltNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.564 -0400", hash_original_field = "4C6B05E8420A11D256598C71201BB5A2", hash_generated_field = "AE85738F15624863E5AD53ADF714CB8C")

    private NameConstraints nameConstraints;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.566 -0400", hash_original_field = "9B1219CDD361068BEC8D590CFDDB3A60", hash_generated_field = "CC19EEEEF0A487FE6D51DEA83B2CE15C")

    private Set<String> policies;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.567 -0400", hash_original_field = "92955A514EE7089EF771A43FBFD341BF", hash_generated_field = "D02AB3F63CCD07B1569D51A8AB892B66")

    private ArrayList<GeneralName> pathToNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.574 -0400", hash_original_field = "8CDCF7A483C3714013D6CCE288F6962E", hash_generated_field = "82FBA186211EFDCFFB14919ED41C463B")

    private PublicKey subjectPublicKeyImpl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.575 -0400", hash_original_field = "89F50C7E7A4F7F43C4F31B0F62F5969D", hash_generated_field = "1B7C9143DE6CB6A90C02235C8F4DF224")

    private String issuerName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.577 -0400", hash_original_field = "533B78F9D24B241F214CCE3ACCD56155", hash_generated_field = "C93A9E221D8E1D96577B4BD9D7373F8B")

    private byte[] issuerBytes;

    /**
     * Creates a new {@code X509CertSelector}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.579 -0400", hash_original_method = "1736CD41546250DF4BB6D27E0993F826", hash_generated_method = "272A5BC1255C4A0DA2FDB78EE0DA7DE3")
    
public X509CertSelector() {}

    /**
     * Sets the certificate that a matching certificate must be equal to.
     *
     * @param certificate
     *            the certificate to match, or null to not check this criteria.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.580 -0400", hash_original_method = "5105DE3F5563E703DF2EDFDA387863E5", hash_generated_method = "4CA643E756A862C0ABB9DA0228B27FCB")
    
public void setCertificate(X509Certificate certificate) {
        certificateEquals = certificate;
    }

    /**
     * Returns the certificate that a matching certificate must be equal to.
     *
     * @return the certificate to match, or null if this criteria is not
     *         checked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.581 -0400", hash_original_method = "98D898EA1B90E610D5DADA2599C25521", hash_generated_method = "405FA5C48738598444C8B342610ABA86")
    
public X509Certificate getCertificate() {
        return certificateEquals;
    }

    /**
     * Sets the serial number that a certificate must match.
     *
     * @param serialNumber
     *            the serial number to match, or {@code null} to not check the
     *            serial number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.582 -0400", hash_original_method = "ED2B8B5CC459C2F15C0A2173F4D67F20", hash_generated_method = "F960AE178C7B04E158B5080E9B083F85")
    
public void setSerialNumber(BigInteger serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * Returns the serial number that a certificate must match.
     *
     * @return the serial number to match, or {@code null} if the serial number
     *         is not to be checked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.584 -0400", hash_original_method = "9420C2CEA2A6F47D515C0AB0605412CD", hash_generated_method = "207C06B8E3C7AEAA1442B3B5D400DFA7")
    
public BigInteger getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the issuer that a certificate must match.
     *
     * @param issuer
     *            the issuer to match, or {@code null} if the issuer is not to
     *            be checked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.586 -0400", hash_original_method = "E3559C46752811FFCBE84F691D86684A", hash_generated_method = "CB914FC2CA2D61E18E413DE06B613D23")
    
public void setIssuer(X500Principal issuer) {
        this.issuer = issuer;
        this.issuerName = null;
        this.issuerBytes = null;
    }

    /**
     * Returns the issuer that a certificate must match.
     *
     * @return the issuer that a certificate must match, or {@code null} if the
     *         issuer is not to be checked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.589 -0400", hash_original_method = "4521AB691538FE3E0581DA96E2D306DA", hash_generated_method = "8DC0C60625DB619C930479E0ADEFEA2A")
    
public X500Principal getIssuer() {
        return issuer;
    }

    /**
     * <b>Do not use</b>, use {@link #getIssuer()} or
     * {@link #getIssuerAsBytes()} instead. Sets the issuer that a certificate
     * must match.
     *
     * @param issuerName
     *            the issuer in a RFC 2253 format string, or {@code null} to not
     *            check the issuer.
     * @throws IOException
     *             if parsing the issuer fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.591 -0400", hash_original_method = "6C8B8983C85EFCA147D810782021C87F", hash_generated_method = "EDF28DE7827B21ED2132EABBEB904348")
    
public void setIssuer(String issuerName) throws IOException {
        if (issuerName == null) {
            this.issuer = null;
            this.issuerName = null;
            this.issuerBytes = null;
            return;
        }
        try {
            this.issuer = new X500Principal(issuerName);
            this.issuerName = issuerName;
            this.issuerBytes = null;
        } catch (IllegalArgumentException e) {
            throw new IOException(e.getMessage());
        }
    }

    /**
     * <b>Do not use</b>, use {@link #getIssuer()} or
     * {@link #getIssuerAsBytes()} instead. Returns the issuer that a
     * certificate must match in a RFC 2253 format string.
     *
     * @return the issuer in a RFC 2253 format string, or {@code null} if the
     *         issuer is not to be checked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.592 -0400", hash_original_method = "45D4315E7D5CF9B35E9717CA1D38EE0F", hash_generated_method = "DE782980E63CD714EED6518191348F41")
    
public String getIssuerAsString() {
        if (issuer == null) {
            return null;
        }
        if (issuerName == null) {
            issuerName = issuer.getName();
        }
        return issuerName;
    }

    /**
     * Sets the issuer that a certificate must match.
     *
     * @param issuerDN
     *            the distinguished issuer name in ASN.1 DER encoded format, or
     *            {@code null} to not check the issuer.
     * @throws IOException
     *             if decoding the issuer fail.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.594 -0400", hash_original_method = "214BDFD2452FAED91E2AEB36CFBDE764", hash_generated_method = "F30DF6CB404AB4CDB775371AD0CCC468")
    
public void setIssuer(byte[] issuerDN) throws IOException {
        if (issuerDN == null) {
            issuer = null;
            return;
        }
        try {
            issuer = new X500Principal(issuerDN);
            this.issuerName = null;
            this.issuerBytes = new byte[issuerDN.length];
            System.arraycopy(issuerDN, 0, this.issuerBytes, 0, issuerDN.length);
        } catch (IllegalArgumentException e) {
            throw new IOException(e.getMessage());
        }
    }

    /**
     * Returns the issuer that a certificate must match.
     *
     * @return the distinguished issuer name in ASN.1 DER encoded format, or
     *         {@code null} if the issuer is not to be checked.
     * @throws IOException
     *             if encoding the issuer fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.595 -0400", hash_original_method = "88F402286D2A30FED0D7EC2CB911C0E7", hash_generated_method = "E76357B36E9FD820BD1EB12DF3A01EBA")
    
public byte[] getIssuerAsBytes() throws IOException {
        if (issuer == null) {
            return null;
        }
        if (issuerBytes == null) {
            issuerBytes = issuer.getEncoded();
        }
        byte[] result = new byte[issuerBytes.length];
        System.arraycopy(issuerBytes, 0, result, 0, issuerBytes.length);
        return result;
    }

    /**
     * Set the subject that a certificate must match.
     *
     * @param subject
     *            the subject distinguished name or {@code null} to not check
     *            the subject.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.597 -0400", hash_original_method = "1EB4B28F28FAB57D48B5B7BB113A9B89", hash_generated_method = "0FDEAADA0D8433C1DE59C5912DE84693")
    
public void setSubject(X500Principal subject) {
        this.subject = subject;
    }

    /**
     * Returns the subject that a certificate must match.
     *
     * @return the subject distinguished name, or null if the subject is not to
     *         be checked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.598 -0400", hash_original_method = "C40B8EB7DCF7E1B87063059C5A2695CF", hash_generated_method = "972D7858365C10143CBC179A8F9A308A")
    
public X500Principal getSubject() {
        return subject;
    }

    /**
     * <b>Do not use</b>, use {@link #setSubject(byte[])} or
     * {@link #setSubject(X500Principal)} instead. Returns the subject that a
     * certificate must match.
     *
     * @param subjectDN
     *            the subject distinguished name in RFC 2253 format or {@code
     *            null} to not check the subject.
     * @throws IOException
     *             if decoding the subject fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.599 -0400", hash_original_method = "62941CA4D80585B9715D074161A8E8D9", hash_generated_method = "7DD1BB907FB8D780CB015C75E4610DCE")
    
public void setSubject(String subjectDN) throws IOException {
        if (subjectDN == null) {
            subject = null;
            return;
        }
        try {
            subject = new X500Principal(subjectDN);
        } catch (IllegalArgumentException e) {
            throw new IOException(e.getMessage());
        }
    }

    /**
     * <b>Do not use</b>, use {@link #getSubject()} or
     * {@link #getSubjectAsBytes()} instead. Returns the subject that a
     * certificate must match.
     *
     * @return the subject distinguished name in RFC 2253 format, or {@code
     *         null} if the subject is not to be checked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.601 -0400", hash_original_method = "B501A40640A14E379E98BA62E917FC43", hash_generated_method = "955293B1FE51C07CD9022B1427CDCC17")
    
public String getSubjectAsString() {
        if (subject == null) {
            return null;
        }
        return subject.getName();
    }

    /**
     * Sets the subject that a certificate must match.
     *
     * @param subjectDN
     *            the subject distinguished name in ASN.1 DER format, or {@code
     *            null} to not check the subject.
     * @throws IOException
     *             if decoding the subject fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.602 -0400", hash_original_method = "7AC79A132AFC7EA44122D1905F110D8E", hash_generated_method = "CD6D146240F68D095BE93FF0430E898F")
    
public void setSubject(byte[] subjectDN) throws IOException {
        if (subjectDN == null) {
            subject = null;
            return;
        }
        try {
            subject = new X500Principal(subjectDN);
        } catch (IllegalArgumentException e) {
            throw new IOException(e.getMessage());
        }
    }

    /**
     * Returns the subject that a certificate must match.
     *
     * @return the subject distinguished name in ASN.1 DER format, or {@code
     *         null} if the subject is not to be checked.
     * @throws IOException
     *             if encoding the subject fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.604 -0400", hash_original_method = "0F89E1CA065C6D6A1DD33AF6CAE61A23", hash_generated_method = "D9D5FACB061A0409D8CBA96C359C8397")
    
public byte[] getSubjectAsBytes() throws IOException {
        if (subject == null) {
            return null;
        }
        return subject.getEncoded();
    }

    /**
     * Sets the criterion for the {@literal SubjectKeyIdentifier} extension.
     * <p>
     * The {@code subjectKeyIdentifier} should be a single DER encoded value.
     *
     * @param subjectKeyIdentifier
     *            the subject key identifier or {@code null} to disable this
     *            check.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.605 -0400", hash_original_method = "EE1FC62198F2CD55D614C3FE334360B4", hash_generated_method = "FA12FF9F4255B79FDC62E711791BE8CD")
    
public void setSubjectKeyIdentifier(byte[] subjectKeyIdentifier) {
        if (subjectKeyIdentifier == null) {
            this.subjectKeyIdentifier = null;
            return;
        }
        this.subjectKeyIdentifier = new byte[subjectKeyIdentifier.length];
        System.arraycopy(subjectKeyIdentifier, 0, this.subjectKeyIdentifier, 0,
                         subjectKeyIdentifier.length);
    }

    /**
     * Returns the criterion for the {@literal SubjectKeyIdentifier} extension.
     *
     * @return the subject key identifier or {@code null} if it is not to be
     *         checked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.606 -0400", hash_original_method = "41897B57691020031CAECEABDE655ABB", hash_generated_method = "84B208858D7B58B4BC06F872EB43A001")
    
public byte[] getSubjectKeyIdentifier() {
        if (subjectKeyIdentifier == null) {
            return null;
        }
        byte[] res = new byte[subjectKeyIdentifier.length];
        System.arraycopy(subjectKeyIdentifier, 0, res, 0, res.length);
        return res;
    }

    /**
     * Sets the criterion for the {@literal AuthorityKeyIdentifier} extension.
     *
     * @param authorityKeyIdentifier
     *            the authority key identifier, or {@code null} to disable this
     *            check.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.608 -0400", hash_original_method = "F4D1FF02135539C43ACBCB880EF4E67F", hash_generated_method = "BF731DDCD182C4498547659AC2832674")
    
public void setAuthorityKeyIdentifier(byte[] authorityKeyIdentifier) {
        if (authorityKeyIdentifier == null) {
            this.authorityKeyIdentifier = null;
            return;
        }
        this.authorityKeyIdentifier = new byte[authorityKeyIdentifier.length];
        System.arraycopy(authorityKeyIdentifier, 0,
                         this.authorityKeyIdentifier, 0,
                         authorityKeyIdentifier.length);
    }

    /**
     * Returns the criterion for the {@literal AuthorityKeyIdentifier}
     * extension.
     *
     * @return the authority key identifier, or {@code null} if it is not to be
     *         checked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.611 -0400", hash_original_method = "604FE3F5DE7A91FC083E26F31CCF673C", hash_generated_method = "E1FCD89DEABB9922CFAFEEBF1C8B3A6A")
    
public byte[] getAuthorityKeyIdentifier() {
        if (authorityKeyIdentifier == null) {
            return null;
        }
        byte[] res = new byte[authorityKeyIdentifier.length];
        System.arraycopy(authorityKeyIdentifier, 0, res, 0, res.length);
        return res;
    }

    /**
     * Sets the criterion for the validity date of the certificate.
     * <p>
     * The certificate must be valid at the specified date.
     * @param certificateValid
     *            the validity date or {@code null} to not check the date.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.612 -0400", hash_original_method = "3542D19C29BF1FE4A383160993E8847E", hash_generated_method = "A8448717F4BEDE3394A460DF7EBFEA2E")
    
public void setCertificateValid(Date certificateValid) {
        this.certificateValid = (certificateValid == null)
                                ? null
                                : (Date) certificateValid.clone();
    }

    /**
     * Returns the criterion for the validity date of the certificate.
     *
     * @return the validity date or {@code null} if the date is not to be
     *         checked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.613 -0400", hash_original_method = "93E59B5AB2A311C6284AE58921AE9BE2", hash_generated_method = "D4AB8FA9CB0A8DD13D9D831CE80A5E22")
    
public Date getCertificateValid() {
        return (certificateValid == null)
                                ? null
                                : (Date) certificateValid.clone();
    }

    /**
     * Sets the criterion for the validity date of the private key.
     * <p>
     * The private key must be valid at the specified date.
     *
     * @param privateKeyValid
     *            the validity date or {@code null} to not check the date.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.615 -0400", hash_original_method = "668000379A3471630721F371816F56C0", hash_generated_method = "BBFF30628A2E5AC94CFC0DBF1A6D0E22")
    
public void setPrivateKeyValid(Date privateKeyValid) {
        if (privateKeyValid == null) {
            this.privateKeyValid = null;
            return;
        }
        this.privateKeyValid = (Date) privateKeyValid.clone();
    }

    /**
     * Returns the criterion for the validity date of the private key.
     * <p>
     * The private key must be valid at the specified date.
     *
     * @return the validity date or {@code null} if the date is not to be
     *         checked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.616 -0400", hash_original_method = "95B2E32A6D2C1A897A141EAC93B1E8D9", hash_generated_method = "F91DBB053A37179F5DEB6B0BBB711BF5")
    
public Date getPrivateKeyValid() {
        if (privateKeyValid != null) {
            return (Date) privateKeyValid.clone();
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.618 -0400", hash_original_method = "4FE3B82D3166E5C21738E37609E4F536", hash_generated_method = "53C2A4CFF55C10D1633A91148D1CE8CE")
    
private void checkOID(String oid) throws IOException {
        int beg = 0;
        int end = oid.indexOf('.', beg);
        try {
            int comp = Integer.parseInt(oid.substring(beg, end));
            beg = end + 1;
            if ((comp < 0) || (comp > 2)) {
                throw new IOException("Bad OID: " + oid);
            }
            end = oid.indexOf('.', beg);
            comp = Integer.parseInt(oid.substring(beg, end));
            if ((comp < 0) || (comp > 39)) {
                throw new IOException("Bad OID: " + oid);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IOException("Bad OID: " + oid);
        } catch (NumberFormatException e) {
            throw new IOException("Bad OID: " + oid);
        }
    }

    /**
     * Sets the criterion for the subject public key signature algorithm.
     * <p>
     * The certificate must contain a subject public key with the algorithm
     * specified.
     *
     * @param oid
     *            the OID (object identifier) of the signature algorithm or
     *            {@code null} to not check the OID.
     * @throws IOException
     *             if the specified object identifier is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.620 -0400", hash_original_method = "AAF12FC84CFA61A6184AAE7A41A13304", hash_generated_method = "3E48001272830C592AF07ACABD629715")
    
public void setSubjectPublicKeyAlgID(String oid) throws IOException {
        if (oid == null) {
            subjectPublicKeyAlgID = null;
            return;
        }
        checkOID(oid);
        subjectPublicKeyAlgID = oid;
    }

    /**
     * Returns the criterion for the subject public key signature algorithm.
     *
     * @return the OID (object identifier) or the signature algorithm or {@code
     *         null} if it's not to be checked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.621 -0400", hash_original_method = "2D28B6EA9E553AA2DFEE41EEF86BC16F", hash_generated_method = "C5531759C8AF02BDFA6F62101F8E03B4")
    
public String getSubjectPublicKeyAlgID() {
        return subjectPublicKeyAlgID;
    }

    /**
     * Sets the criterion for the subject public key.
     *
     * @param key
     *            the subject public key or {@code null} to not check the key.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.623 -0400", hash_original_method = "8E82F3431A27B71CF2D12BE293D7E4AE", hash_generated_method = "8B0F6A1B71ADCF8ED4C4450DD8A9926A")
    
public void setSubjectPublicKey(PublicKey key) {
        subjectPublicKey = (key == null) ? null : key.getEncoded();
        subjectPublicKeyImpl = key;
    }

    /**
     * Sets the criterion for the subject public key.
     *
     * @param key
     *            the subject public key in ASN.1 DER encoded format or {@code null} to
     *            not check the key.
     * @throws IOException
     *             if decoding the the public key fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.624 -0400", hash_original_method = "AAAB949656D94AA34D25CD96B64E5CB1", hash_generated_method = "37FAB86C3018C6D5E08DB552B9AEDE7B")
    
public void setSubjectPublicKey(byte[] key) throws IOException {
        if (key == null) {
            subjectPublicKey = null;
            subjectPublicKeyImpl = null;
            return;
        }
        subjectPublicKey = new byte[key.length];
        System.arraycopy(key, 0, subjectPublicKey, 0, key.length);
        subjectPublicKeyImpl =
            ((SubjectPublicKeyInfo) SubjectPublicKeyInfo.ASN1.decode(key))
            .getPublicKey();
    }

    /**
     * Returns the criterion for the subject public key.
     *
     * @return the subject public key or {@code null} if the key is not to be
     *         checked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.625 -0400", hash_original_method = "45DDD3E3B6C7E171D869385C52AD751E", hash_generated_method = "5630865116A1FD716D483C96F3AB5604")
    
public PublicKey getSubjectPublicKey() {
        return subjectPublicKeyImpl;
    }

    /**
     * Sets the criterion for the {@literal KeyUsage} extension.
     *
     * @param keyUsage
     *            the boolean array in the format as returned by
     *            {@link X509Certificate#getKeyUsage()}, or {@code null} to not
     *            check the key usage.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.627 -0400", hash_original_method = "A6F5AAB7170443C3DA324490B0C8EFA4", hash_generated_method = "52A77E59CAB44978135C1876E530FD08")
    
public void setKeyUsage(boolean[] keyUsage) {
        if (keyUsage == null) {
            this.keyUsage = null;
            return;
        }
        this.keyUsage = new boolean[keyUsage.length];
        System.arraycopy(keyUsage, 0, this.keyUsage, 0, keyUsage.length);
    }

    /**
     * Returns the criterion for the {@literal KeyUsage} extension.
     *
     * @return the boolean array in the format as returned by
     *         {@link X509Certificate#getKeyUsage()}, or {@code null} if the key
     *         usage is not to be checked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.628 -0400", hash_original_method = "3E81DF542CAAA163F5578A2275996283", hash_generated_method = "EEA7062812EBC31DEEC6A6792D4B8A24")
    
public boolean[] getKeyUsage() {
        if (keyUsage == null) {
            return null;
        }
        boolean[] result = new boolean[keyUsage.length];
        System.arraycopy(keyUsage, 0, result, 0, keyUsage.length);
        return result;
    }

    /**
     * Sets the criterion for the {@literal ExtendedKeyUsage} extension.
     *
     * @param keyUsage
     *            the set of key usage OIDs, or {@code null} to not check it.
     * @throws IOException
     *             if one of the OIDs is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.630 -0400", hash_original_method = "479B86289434C363B5926E795440A594", hash_generated_method = "CCDBB5D39FFBEAACABC0012436C6C126")
    
public void setExtendedKeyUsage(Set<String> keyUsage)
                             throws IOException {
        extendedKeyUsage = null;
        if ((keyUsage == null) || (keyUsage.size() == 0)) {
            return;
        }
        HashSet<String> key_u = new HashSet<String>();
        for (String usage : keyUsage) {
            checkOID(usage);
            key_u.add(usage);
        }
        extendedKeyUsage = Collections.unmodifiableSet(key_u);
    }

    /**
     * Returns the criterion for the {@literal ExtendedKeyUsage} extension.
     *
     * @return the set of key usage OIDs, or {@code null} if it's not to be
     *         checked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.632 -0400", hash_original_method = "DCF6DA32102E64B583106FEF9440DD1B", hash_generated_method = "A92394B62F6A4D9CA117D3295170E1E7")
    
public Set<String> getExtendedKeyUsage() {
        return extendedKeyUsage;
    }

    /**
     * Sets the flag for the matching behavior for subject alternative names.
     * <p>
     * The flag indicates whether a certificate must contain all or at least one
     * of the subject alternative names specified by {@link
     * #setSubjectAlternativeNames} or {@link #addSubjectAlternativeName}.
     *
     * @param matchAllNames
     *            {@code true} if a certificate must contain all of the
     *            specified subject alternative names, otherwise {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.633 -0400", hash_original_method = "9F86B927A2BF9A4C2E2F9DB77F1F3A74", hash_generated_method = "E9B74DA75C32EE52D17E4126772B7546")
    
public void setMatchAllSubjectAltNames(boolean matchAllNames) {
        this.matchAllNames = matchAllNames;
    }

    /**
     * Returns the flag for the matching behavior for subject alternative names.
     * <p>
     * The flag indicates whether a certificate must contain all or at least one
     * of the subject alternative names specified by {@link
     * #setSubjectAlternativeNames} or {@link #addSubjectAlternativeName}.
     *
     * @return {@code true} if a certificate must contain all of the specified
     *         subject alternative names, otherwise {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.634 -0400", hash_original_method = "E8846B4BBEB8A00C84E80CFD6A905E71", hash_generated_method = "6B3556B7027E4338CE31811E59109BFE")
    
public boolean getMatchAllSubjectAltNames() {
        return matchAllNames;
    }

    /**
     * Sets the criterion for subject alternative names.
     * <p>
     * the certificate must contain all or at least one of the specified subject
     * alternative names. The behavior is specified by
     * {@link #getMatchAllSubjectAltNames}.
     * <p>
     * The specified parameter {@code names} is a collection with an entry for
     * each name to be included in the criterion. The name is specified as a
     * {@code List}, the first entry must be an {@code Integer} specifying the
     * name type (0-8), the second entry must be a {@code String} or a byte
     * array specifying the name (in string or ASN.1 DER encoded form)
     *
     * @param names
     *            the names collection or {@code null} to not perform this check.
     * @throws IOException
     *             if the decoding of a name fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.636 -0400", hash_original_method = "8BCD6D14CAA0D53BC04E1935EFCE2DD9", hash_generated_method = "2D9131902292A0B00A80DA6D1A700F66")
    
public void setSubjectAlternativeNames(Collection<List<?>> names) throws IOException {
        subjectAltNames = null;
        if ((names == null) || (names.size() == 0)) {
            return;
        }
        for (List<?> name : names) {
            int tag = (Integer) name.get(0);
            Object value = name.get(1);
            if (value instanceof String) {
                addSubjectAlternativeName(tag, (String) value);
            } else if (value instanceof byte[]) {
                addSubjectAlternativeName(tag, (byte[]) value);
            } else {
                throw new IOException("name neither a String nor a byte[]");
            }
        }
    }

    /**
     * Adds a subject alternative name to the respective criterion.
     *
     * @param tag
     *            the type of the name
     * @param name
     *            the name in string format.
     * @throws IOException
     *             if parsing the name fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.637 -0400", hash_original_method = "CEB9AD97B508C9F5B760A0174B8C8DDA", hash_generated_method = "E6616CEBD1A9EB9F862C3D87E621DB87")
    
public void addSubjectAlternativeName(int tag, String name)
                                                       throws IOException {
        GeneralName alt_name = new GeneralName(tag, name);
        // create only if there was not any errors
        if (subjectAltNames == null) {
            subjectAltNames = new ArrayList[9];
        }
        if (subjectAltNames[tag] == null) {
            subjectAltNames[tag] = new ArrayList<GeneralName>();
        }
        subjectAltNames[tag].add(alt_name);
    }

    /**
     * Adds a subject alternative name to the respective criterion.
     *
     * @param tag
     *            the type of the name.
     * @param name
     *            the name in ASN.1 DER encoded form.
     * @throws IOException
     *             if the decoding of the name fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.639 -0400", hash_original_method = "A615451C1EE7AA4EA688C4592F92E595", hash_generated_method = "D16B2A7B7A668BE0DFD90FBBC3CACBF7")
    
public void addSubjectAlternativeName(int tag, byte[] name)
                                            throws IOException {
        GeneralName alt_name = new GeneralName(tag, name);
        // create only if there was not any errors
        if (subjectAltNames == null) {
            subjectAltNames = new ArrayList[9];
        }
        if (subjectAltNames[tag] == null) {
            subjectAltNames[tag] = new ArrayList<GeneralName>();
        }
        subjectAltNames[tag].add(alt_name);
    }

    /**
     * Returns the criterion for subject alternative names.
     * <p>
     * the certificate must contain all or at least one of the specified subject
     * alternative names. The behavior is specified by
     * {@link #getMatchAllSubjectAltNames}.
     * <p>
     * The subject alternative names is a collection with an entry for each name
     * included in the criterion. The name is specified as a {@code List}, the
     * first entry is an {@code Integer} specifying the name type (0-8), the
     * second entry is byte array specifying the name in ASN.1 DER encoded form)
     *
     * @return the names collection or {@code null} if none specified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.641 -0400", hash_original_method = "8C12B5EEB3E8C9ED9604AB23B3A04ABE", hash_generated_method = "9A3547A9D9527ACC2841E62A081C4615")
    
public Collection<List<?>> getSubjectAlternativeNames() {
        if (subjectAltNames == null) {
            return null;
        }
        ArrayList<List<?>> result = new ArrayList<List<?>>();
        for (int tag=0; tag<9; tag++) {
            if (subjectAltNames[tag] != null) {
                for (int name=0; name<subjectAltNames[tag].size(); name++) {
                    List<Object> list = new ArrayList<Object>(2);
                    list.add(tag);
                    list.add(subjectAltNames[tag].get(name));
                    result.add(list);
                }
            }
        }
        return result;
    }

    /**
     * Sets the criterion for the name constraints.
     * <p>
     * The certificate must constraint subject and subject alternative names
     * that match the specified name constraints.
     * <p>
     * The name constraints in ASN.1:
     *
     * <pre>
     * NameConstraints ::= SEQUENCE {
     *        permittedSubtrees       [0]     GeneralSubtrees OPTIONAL,
     *        excludedSubtrees        [1]     GeneralSubtrees OPTIONAL }
     *
     * GeneralSubtrees ::= SEQUENCE SIZE (1..MAX) OF GeneralSubtree
     *
     * GeneralSubtree ::= SEQUENCE {
     *        base                    GeneralName,
     *        minimum         [0]     BaseDistance DEFAULT 0,
     *        maximum         [1]     BaseDistance OPTIONAL }
     *
     * BaseDistance ::= INTEGER (0..MAX)
     *
     * GeneralName ::= CHOICE {
     *        otherName                       [0]     OtherName,
     *        rfc822Name                      [1]     IA5String,
     *        dNSName                         [2]     IA5String,
     *        x400Address                     [3]     ORAddress,
     *        directoryName                   [4]     Name,
     *        ediPartyName                    [5]     EDIPartyName,
     *        uniformResourceIdentifier       [6]     IA5String,
     *        iPAddress                       [7]     OCTET STRING,
     *        registeredID                    [8]     OBJECT IDENTIFIER}
     *
     * </pre>
     *
     * @param bytes
     *            the name constraints in ASN.1 DER encoded format, or null to
     *            not check any constraints.
     * @throws IOException
     *             if decoding the name constraints fail.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.642 -0400", hash_original_method = "B140EEA676D2FB1F7FF7DE362CE302CD", hash_generated_method = "8391AFC1A466B3B44BBDBBA12FA933A3")
    
public void setNameConstraints(byte[] bytes) throws IOException {
        this.nameConstraints = (bytes == null)
            ? null
            : (NameConstraints) NameConstraints.ASN1.decode(bytes);
    }

    /**
     * Returns the criterion for the name constraints.
     *
     * @return the name constraints or {@code null} if none specified.
     * @see #setNameConstraints
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.644 -0400", hash_original_method = "9E3406A2B12C0C36A8C307F69A827B59", hash_generated_method = "3E0476ABC8A672A1EA62C0204FA8C22D")
    
public byte[] getNameConstraints() {
        return (nameConstraints == null)
            ? null
            : nameConstraints.getEncoded();
    }

    /**
     * Sets the criterion for the basic constraints extension.
     * <p>
     * A value greater than or equal to zero indicates that a certificate must
     * include a basic constraints extension with a path length of a least that
     * value. A value of {@code -2} indicates that only end-entity certificates
     * are accepted. A value of {@code -1} indicates that no check is done.
     *
     * @param pathLen
     *            the value specifying the criterion.
     * @throws IllegalArgumentException
     *             if {@code pathLen} is less than {@code -2}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.661 -0400", hash_original_method = "E2A6C47DA9DBA6B2835B3793789AE1D4", hash_generated_method = "76A81999C990F5FC0B1A326D04D80277")
    
public void setBasicConstraints(int pathLen) {
        if (pathLen < -2) {
            throw new IllegalArgumentException("pathLen < -2");
        }
        this.pathLen = pathLen;
    }

    /**
     * Returns the criterion for the basic constraints extension.
     * <p>
     * A value greater than or equal to zero indicates that a certificate must
     * include a basic constraints extension with a path length of a least that
     * value. A value of {@code -2} indicates that only end-entity certificates
     * are accepted. A value of {@code -1} indicates that no check is done.
     *
     * @return the value of the criterion.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.663 -0400", hash_original_method = "25F36A2AB09C8313EBB1EE2ADD293A90", hash_generated_method = "2E023C67BEAACF69EECA3DDDA409AB74")
    
public int getBasicConstraints() {
        return pathLen;
    }

    /**
     * Sets the criterion for the policy constraint.
     * <p>
     * The certificate must have at least one of the specified certificate
     * policy extensions. For an empty set the certificate must have at least
     * some policies in its policy extension.
     *
     * @param policies
     *            the certificate policy OIDs, an empty set, or {@code null} to
     *            not perform this check.
     * @throws IOException
     *             if parsing the specified OIDs fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.665 -0400", hash_original_method = "20EC48F469F4D628E0E6D9D012447F7A", hash_generated_method = "D939C76B91539EDC81915E1B7A12FFBA")
    
public void setPolicy(Set<String> policies) throws IOException {
        if (policies == null) {
            this.policies = null;
            return;
        }
        HashSet<String> pols = new HashSet<String>(policies.size());
        for (String certPolicyId : policies) {
            checkOID(certPolicyId);
            pols.add(certPolicyId);
        }
        this.policies = Collections.unmodifiableSet(pols);
    }

    /**
     * Returns the criterion for the policy constraint.
     * <p>
     * The certificate must have at least one of the certificate policy
     * extensions. For an empty set the certificate must have at least some
     * policies in its policy extension.
     *
     * @return the certificate policy OIDs, an empty set, or {@code null} if not
     *         to be checked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.667 -0400", hash_original_method = "2AA1D364CB0BD443A8FF8006989047AC", hash_generated_method = "079729F20D9D46280B0DFEB73A3E9DCB")
    
public Set<String> getPolicy() {
        return policies;
    }

    /**
     * Adds a {@literal "pathToName"} to the respective criterion.
     *
     * @param type
     *            the type of the name.
     * @param name
     *            the name in string format.
     * @throws IOException
     *             if parsing fails.
     * @see #setPathToNames
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.669 -0400", hash_original_method = "EFF1BB23472B91BBBC0BA26D4E47F317", hash_generated_method = "3DDF2E6D88732884A7D181960DF3E2D8")
    
public void addPathToName(int type, String name) throws IOException {
        GeneralName path_name = new GeneralName(type, name);
        // create only if there was not any errors
        if (pathToNames == null) {
            pathToNames = new ArrayList<GeneralName>();
        }
        pathToNames.add(path_name);
    }

    /**
     * Sets the criterion for the pathToNames constraint.
     * <p>
     * This allows to specify the complete set of names, a certificate's name
     * constraints must permit.
     * <p>
     * The specified parameter {@code names} is a collection with an entry for
     * each name to be included in the criterion. The name is specified as a
     * {@code List}, the first entry must be an {@code Integer} specifying the
     * name type (0-8), the second entry must be a {@code String} or a byte
     * array specifying the name (in string or ASN.1 DER encoded form)
     *
     * @param names
     *            the names collection or {@code null} to not perform this
     *            check.
     * @throws IOException
     *             if decoding fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.672 -0400", hash_original_method = "B4E716F7A38ABCCDBEDF350AA3DA6EDE", hash_generated_method = "69A635902AF59452E7BCF7F92889CB52")
    
public void setPathToNames(Collection<List<?>> names) throws IOException {
        pathToNames = null;
        if ((names == null) || (names.size() == 0)) {
            return;
        }
        for (List<?> name : names) {
            int tag = (Integer) name.get(0);
            Object value = name.get(1);
            if (value instanceof String) {
                addPathToName(tag, (String) value);
            } else if (value instanceof byte[]) {
                addPathToName(tag, (byte[]) value);
            } else {
                throw new IOException("name neither a String nor a byte[]");
            }
        }
    }

    /**
     * Adds a {@literal "pathToName"} to the respective criterion.
     *
     * @param type
     *            the type of the name
     * @param name
     *            the name in ASN.1 DER encoded form.
     * @throws IOException
     *             if decoding fails.
     * @see #setPathToNames
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.674 -0400", hash_original_method = "D25ECB2C19D6C2DD40E21275F931D57C", hash_generated_method = "02016EA200D17800D0D29C1FC85BDBAB")
    
public void addPathToName(int type, byte[] name) throws IOException {
        GeneralName path_name= new GeneralName(type, name);
        // create only if there was not any errors
        if (pathToNames == null) {
            pathToNames = new ArrayList<GeneralName>();
        }
        pathToNames.add(path_name);
    }

    /**
     * Returns the criterion for the pathToNames constraint.
     * <p>
     * The constraint is a collection with an entry for each name to be included
     * in the criterion. The name is specified as a {@code List}, the first
     * entry is an {@code Integer} specifying the name type (0-8), the second
     * entry is a byte array specifying the name in ASN.1 DER encoded form.
     *
     * @return the pathToNames constraint or {@code null} if none specified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.678 -0400", hash_original_method = "50F3E0A9925639CEF17D6D233B2B2E21", hash_generated_method = "EBD27AAA0B3922C1AF45E7BACA7036C9")
    
public Collection<List<?>> getPathToNames() {
        if (pathToNames == null) {
            return null;
        }
        Collection<List<?>> result = new ArrayList<List<?>>();
        for (GeneralName name : pathToNames) {
            result.add(name.getAsList());
        }
        return result;
    }

    /**
     * Returns a string representation of this {@code X509CertSelector}
     * instance.
     *
     * @return a string representation of this {@code X509CertSelector}
     *         instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.681 -0400", hash_original_method = "41DE0776B6BB494AF0EA496108712ABC", hash_generated_method = "D705FDCE6EE4FDFC46EAC2F1848FA6F5")
    
public String toString() {
        // For convenient reading of the string representation
        // all of the fields named according to the rfc 3280
        // (http://www.ietf.org/rfc/rfc3280.txt).

        StringBuilder result = new StringBuilder();
        result.append("X509CertSelector: \n[");
        if (this.certificateEquals != null) {
            result.append("\n  certificateEquals: ").append(certificateEquals);
        }
        if (this.serialNumber != null) {
            result.append("\n  serialNumber: ").append(serialNumber);
        }
        if (this.issuer != null) {
            result.append("\n  issuer: ").append(issuer);
        }
        if (this.subject != null) {
            result.append("\n  subject: ").append(subject);
        }
        if (this.subjectKeyIdentifier != null) {
            result.append("\n  subjectKeyIdentifier: ")
                    .append(Array.getBytesAsString(subjectKeyIdentifier));
        }
        if (this.authorityKeyIdentifier != null) {
            result.append("\n  authorityKeyIdentifier: ")
                    .append(Array.getBytesAsString(authorityKeyIdentifier));
        }
        if (this.certificateValid != null) {
            result.append("\n  certificateValid: ").append(certificateValid);
        }
        if (this.subjectPublicKeyAlgID != null) {
            result.append("\n  subjectPublicKeyAlgID: ").append(subjectPublicKeyAlgID);
        }
        if (this.privateKeyValid != null) {
            result.append("\n  privateKeyValid: ").append(privateKeyValid);
        }
        if (this.subjectPublicKey != null) {
            result.append("\n  subjectPublicKey: ")
                    .append(Array.getBytesAsString(subjectPublicKey));
        }
        if (this.keyUsage != null) {
            result.append("\n  keyUsage: \n  [");
            String[] kuNames = new String[] {
                "digitalSignature", "nonRepudiation", "keyEncipherment",
                "dataEncipherment", "keyAgreement", "keyCertSign", "cRLSign",
                "encipherOnly", "decipherOnly"
            };
            for (int i=0; i<9; i++) {
                if (keyUsage[i]) {
                    result.append("\n    ").append(kuNames[i]);
                }
            }
            result.append("\n  ]");
        }
        if (this.extendedKeyUsage != null) {
            result.append("\n  extendedKeyUsage: ").append(extendedKeyUsage.toString());
        }
        result.append("\n  matchAllNames: ").append(matchAllNames);
        result.append("\n  pathLen: ").append(pathLen);
        if (this.subjectAltNames != null) {
            result.append("\n  subjectAltNames:  \n  [");
            for (int i=0; i<9; i++) {
                List<GeneralName> names = subjectAltNames[i];
                if (names != null) {
                    int size = names.size();
                    for (GeneralName generalName : names) {
                        result.append("\n    ").append(generalName.toString());
                    }
                }
            }
            result.append("\n  ]");
        }
        if (this.nameConstraints != null) {
        }
        if (this.policies != null) {
            result.append("\n  policies: ").append(policies.toString());
        }
        if (this.pathToNames != null) {
            result.append("\n  pathToNames:  \n  [");
            for (GeneralName generalName : pathToNames) {
                result.append("\n    ").append(generalName.toString());
            }
        }
        result.append("\n]");
        return result.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.683 -0400", hash_original_method = "EDDB639D0AE474E661AEDDBCCA817CB8", hash_generated_method = "E01AB9C41831B67A0259FB156ED1CC9B")
    
private byte[] getExtensionValue(X509Certificate cert, String oid) {
        try {
            byte[] bytes = cert.getExtensionValue(oid);
            if (bytes == null) {
                return null;
            }
            return (byte[]) ASN1OctetString.getInstance().decode(bytes);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Returns whether the specified certificate matches all the criteria
     * collected in this instance.
     *
     * @param certificate
     *            the certificate to check.
     * @return {@code true} if the certificate matches all the criteria,
     *         otherwise {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.689 -0400", hash_original_method = "50333EAEF25ABACD223EFF4E6540624C", hash_generated_method = "A7CC44F3CCCA58ECDD2A49DEA1ADD697")
    
public boolean match(Certificate certificate) {
        if (! (certificate instanceof X509Certificate)) {
            return false;
        }

        X509Certificate cert = (X509Certificate) certificate;
        if ((certificateEquals != null) &&
            !certificateEquals.equals(cert)) {
            return false;
        }
        if ((serialNumber != null) &&
            !serialNumber.equals(cert.getSerialNumber())) {
            return false;
        }
        if ((issuer != null) &&
            !issuer.equals(cert.getIssuerX500Principal())) {
            return false;
        }
        if ((subject != null) &&
            !subject.equals(cert.getSubjectX500Principal())) {
            return false;
        }
        if ((subjectKeyIdentifier != null) &&
            !Arrays.equals(subjectKeyIdentifier,
            // Here and later all of the extension OIDs
            // are taken from rfc 3280 (http://www.ietf.org/rfc/rfc3280.txt)
                           getExtensionValue(cert, "2.5.29.14"))) {
            return false;
        }
        if ((authorityKeyIdentifier != null) &&
            !Arrays.equals(authorityKeyIdentifier,
                           getExtensionValue(cert, "2.5.29.35"))) {
            return false;
        }
        if (certificateValid != null) {
            try {
                cert.checkValidity(certificateValid);
            } catch(CertificateExpiredException e) {
                return false;
            } catch(CertificateNotYetValidException e) {
                return false;
            }
        }
        if (privateKeyValid != null) {
            try {
                byte[] bytes = getExtensionValue(cert, "2.5.29.16");
                if (bytes == null) {
                    return false;
                }
                PrivateKeyUsagePeriod pkup = (PrivateKeyUsagePeriod)
                                    PrivateKeyUsagePeriod.ASN1.decode(bytes);
                Date notBefore = pkup.getNotBefore();
                Date notAfter = pkup.getNotAfter();
                if ((notBefore == null) && (notAfter == null)) {
                    return false;
                }
                if ((notBefore != null)
                    && notBefore.compareTo(privateKeyValid) > 0) {
                    return false;
                }
                if ((notAfter != null)
                    && notAfter.compareTo(privateKeyValid) < 0) {
                    return false;
                }
            } catch (IOException e) {
                return false;
            }
        }
        if (subjectPublicKeyAlgID  != null) {
            try {
                byte[] encoding = cert.getPublicKey().getEncoded();
                AlgorithmIdentifier ai = ((SubjectPublicKeyInfo)
                        SubjectPublicKeyInfo.ASN1.decode(encoding))
                        .getAlgorithmIdentifier();
                if (!subjectPublicKeyAlgID.equals(ai.getAlgorithm())) {
                    return false;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        if (subjectPublicKey != null) {
            if (!Arrays.equals(subjectPublicKey,
                               cert.getPublicKey().getEncoded())) {
                return false;
            }
        }
        if (keyUsage != null) {
            boolean[] ku = cert.getKeyUsage();
            if (ku != null) {
                int i = 0;
                int min_length = (ku.length < keyUsage.length) ? ku.length
                        : keyUsage.length;
                for (; i < min_length; i++) {
                    if (keyUsage[i] && !ku[i]) {
                        // the specified keyUsage allows,
                        // but certificate does not.
                        return false;
                    }
                }
                for (; i<keyUsage.length; i++) {
                    if (keyUsage[i]) {
                        return false;
                    }
                }
            }
        }
        if (extendedKeyUsage != null) {
            try {
                List keyUsage = cert.getExtendedKeyUsage();
                if (keyUsage != null) {
                    if (!keyUsage.containsAll(extendedKeyUsage)) {
                        return false;
                    }
                }
            } catch (CertificateParsingException e) {
                return false;
            }
        }
        if (pathLen != -1) {
            int p_len = cert.getBasicConstraints();
            if ((pathLen < 0) && (p_len >= 0)) {
                // need end-entity but got CA
                return false;
            }
            if ((pathLen > 0) && (pathLen > p_len)) {
                // allowed _pathLen is small
                return false;
            }
        }
        if (subjectAltNames != null) {
            PASSED:
            try {
                byte[] bytes = getExtensionValue(cert, "2.5.29.17");
                if (bytes == null) {
                    return false;
                }
                List<GeneralName> sans = ((GeneralNames) GeneralNames.ASN1.decode(bytes))
                            .getNames();
                if ((sans == null) || (sans.size() == 0)) {
                    return false;
                }
                boolean[][] map = new boolean[9][];
                // initialize the check map
                for (int i=0; i<9; i++) {
                    map[i] = (subjectAltNames[i] == null)
                            ? EmptyArray.BOOLEAN : new boolean[subjectAltNames[i].size()];
                }
                for (GeneralName name : sans) {
                    int tag = name.getTag();
                    for (int i = 0; i < map[tag].length; i++) {
                        if (subjectAltNames[tag].get(i).equals(name)) {
                            if (!matchAllNames) {
                                break PASSED;
                            }
                            map[tag][i] = true;
                        }
                    }
                }
                if (!matchAllNames) {
                    // there was not any match
                    return false;
                }
                // else check the map
                for (int tag=0; tag<9; tag++) {
                    for (int name=0; name<map[tag].length; name++) {
                        if (!map[tag][name]) {
                            return false;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        if (nameConstraints != null) {
            if (!nameConstraints.isAcceptable(cert)) {
                return false;
            }
        }
        if (policies != null) {
            byte[] bytes = getExtensionValue(cert, "2.5.29.32");
            if (bytes == null) {
                return false;
            }
            if (policies.size() == 0) {
                // if certificate has such extension than it has at least
                // one policy in it.
                return true;
            }
            PASSED:
            try {
                List<PolicyInformation> policyInformations
                        = ((CertificatePolicies) CertificatePolicies.ASN1.decode(bytes))
                        .getPolicyInformations();
                for (PolicyInformation policyInformation : policyInformations) {
                    if (policies.contains(policyInformation.getPolicyIdentifier())) {
                        break PASSED;
                    }
                }
                return false;
            } catch (IOException e) {
                // the extension is invalid
                return false;
            }
        }
        if (pathToNames != null) {
            byte[] bytes = getExtensionValue(cert, "2.5.29.30");
            if (bytes != null) {
                NameConstraints nameConstraints;
                try {
                    nameConstraints =
                        (NameConstraints) NameConstraints.ASN1.decode(bytes);
                } catch (IOException e) {
                    // the extension is invalid;
                    return false;
                }
                if (!nameConstraints.isAcceptable(pathToNames)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Clones this {@code X509CertSelector} instance.
     *
     * @return the cloned instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.692 -0400", hash_original_method = "B0D99509D385623E172CAB9B08956BC2", hash_generated_method = "DF2FB1CD94DA891A138C379B2DFAD93A")
    
public Object clone() {
        X509CertSelector result;

        try {
            result = (X509CertSelector) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }

        if (this.subjectKeyIdentifier != null) {
            result.subjectKeyIdentifier =
                new byte[this.subjectKeyIdentifier.length];
            System.arraycopy(this.subjectKeyIdentifier, 0,
                    result.subjectKeyIdentifier, 0,
                    this.subjectKeyIdentifier.length);
        }
        if (this.authorityKeyIdentifier != null) {
            result.authorityKeyIdentifier =
                new byte[this.authorityKeyIdentifier.length];
            System.arraycopy(this.authorityKeyIdentifier, 0,
                    result.authorityKeyIdentifier, 0,
                    this.authorityKeyIdentifier.length);
        }
        if (this.subjectPublicKey != null) {
            result.subjectPublicKey = new byte[this.subjectPublicKey.length];
            System.arraycopy(this.subjectPublicKey, 0, result.subjectPublicKey,
                    0, this.subjectPublicKey.length);
        }
        if (this.keyUsage != null) {
            result.keyUsage = new boolean[this.keyUsage.length];
            System.arraycopy(this.keyUsage, 0, result.keyUsage, 0,
                    this.keyUsage.length);
        }
        result.extendedKeyUsage = (this.extendedKeyUsage == null)
            ? null
            : new HashSet<String>(this.extendedKeyUsage);
        if (this.subjectAltNames != null) {
            result.subjectAltNames = new ArrayList[9];
            for (int i=0; i<9; i++) {
                if (this.subjectAltNames[i] != null) {
                    result.subjectAltNames[i] =
                        new ArrayList<GeneralName>(this.subjectAltNames[i]);
                }
            }
        }
        result.policies = (this.policies == null) ? null : new HashSet<String>(this.policies);
        result.pathToNames = (this.pathToNames == null)
            ? null
            : new ArrayList<GeneralName>(this.pathToNames);
        return result;
    }
}
