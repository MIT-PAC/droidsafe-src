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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.x501.Name;

/**
 * A CRL selector ({@code CRLSelector} for selecting {@code
 * X509CRL}s that match the specified criteria.
 * <p>
 * When constructed, all criteria are set to default values that will match any
 * {@code X509CRL}.
 */
public class X509CRLSelector implements CRLSelector {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.133 -0400", hash_original_field = "86222A3941103E1A4319DE0201441B86", hash_generated_field = "3CD647D4D08C12A313C34F6EBC7E0E92")

    // contains X.500 distinguished names in CANONICAL format
    private ArrayList<String> issuerNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.135 -0400", hash_original_field = "8452BE26DD14F2F106C99FFFEC85BB2C", hash_generated_field = "74FE2FC6DBBB293C9FBCB4F60CB4154A")

    // from issuerNames collection (above)
    private ArrayList<X500Principal> issuerPrincipals;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.136 -0400", hash_original_field = "BE6CFD104ADDCF4250C732095FDC7150", hash_generated_field = "E66B1A6ABD26E8122E717C928A58BA42")

    private BigInteger minCRL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.138 -0400", hash_original_field = "620D0ADC499DA267AECECAE8E462FB46", hash_generated_field = "EE50EECCF87772F71B688A1C61D74236")

    private BigInteger maxCRL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.139 -0400", hash_original_field = "1F68068A1519878CE488F6DB18CB6F3F", hash_generated_field = "03578CD194E80DCF9B5CCBEB58C36CFE")

    private long dateAndTime = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.140 -0400", hash_original_field = "8D993E45D8E349BE0BB57356DC28A0D3", hash_generated_field = "FF2014762902A15E218AA89F47791112")

    private X509Certificate certificateChecking;

    /**
     * Creates a new {@code X509CertSelector}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.141 -0400", hash_original_method = "E501D286FDBE92B9A176B639722F609E", hash_generated_method = "0F3CAC800E2A9A1D3489007CC9A85C03")
    
public X509CRLSelector() { }

    /**
     * Sets the criterion for the issuer distinguished names.
     * <p>
     * The CRL issuer must match at least one of the specified distinguished
     * names.
     *
     * @param issuers
     *            the list of issuer distinguished names to match, or {@code
     *            null} if any issuer distinguished name will do.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.143 -0400", hash_original_method = "3F3DFA50B67387F3A64AECCD734CDB8F", hash_generated_method = "B46F667773025643C60C74A2869131D4")
    
public void setIssuers(Collection<X500Principal> issuers) {
        if (issuers == null) {
            issuerNames = null;
            issuerPrincipals = null;
            return;
        }
        issuerNames = new ArrayList<String>(issuers.size());
        issuerPrincipals = new ArrayList<X500Principal>(issuers);
        for (X500Principal issuer: issuers) {
            issuerNames.add(issuer.getName(X500Principal.CANONICAL));
        }
    }

    /**
     * <b>Do not use:</b> use {@link #setIssuers(Collection)} or one of
     * {@link #addIssuerName} instead. Sets the criterion for the issuer
     * distinguished names.
     * <p>
     * The CRL issuer must match at least one of the specified distinguished
     * names.
     * <p>
     * The specified parameter {@code names} is a collection with an entry for
     * each name to be included in the criterion. The name is specified as a
     * {@code String} or a byte array specifying the name (in RFC 2253 or ASN.1
     * DER encoded form)
     *
     * @param names
     *            the list of issuer distinguished names to match, or {@code
     *            null} if any issuer distinguished name will do.
     * @throws IOException
     *             if parsing fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.154 -0400", hash_original_method = "28A8C6AAF6E756022903791484231F44", hash_generated_method = "BCA2906CB0FC3A1FBB0854E0B37D4EAF")
    
public void setIssuerNames(Collection<?> names) throws IOException {
        if (names == null) {
            issuerNames = null;
            issuerPrincipals = null;
            return;
        }
        if (names.size() == 0) {
            return;
        }
        issuerNames = new ArrayList<String>(names.size());
        for (Object name: names) {
            if (name instanceof String) {
                issuerNames.add(
                        new Name((String) name).getName(
                            X500Principal.CANONICAL));
            } else if (name instanceof byte[]) {
                issuerNames.add(
                        new Name((byte[]) name).getName(
                            X500Principal.CANONICAL));
            } else {
                throw new IOException("name neither a String nor a byte[]");
            }
        }
    }

    /**
     * Adds an issuer to the criterion for the issuer distinguished names.
     * <p>
     * The CRL issuer must match at least one of the specified distinguished
     * names.
     *
     * @param issuer
     *            the issuer to add to the criterion
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.156 -0400", hash_original_method = "C6DF9312E9CF5AE81F7583129B2BF607", hash_generated_method = "1BEFFDE500A83101243FAB0DA60594B3")
    
public void addIssuer(X500Principal issuer) {
        if (issuer == null) {
            throw new NullPointerException("issuer == null");
        }
        if (issuerNames == null) {
            issuerNames = new ArrayList<String>();
        }
        String name = issuer.getName(X500Principal.CANONICAL);
        if (!issuerNames.contains(name)) {
            issuerNames.add(name);
        }
        if (issuerPrincipals == null) {
            issuerPrincipals = new ArrayList<X500Principal>(issuerNames.size());
        }
        // extend the list of issuer Principals
        int size = issuerNames.size() - 1;
        for (int i=issuerPrincipals.size(); i<size; i++) {
            issuerPrincipals.add(new X500Principal(issuerNames.get(i)));
        }
        issuerPrincipals.add(issuer);
    }

    /**
     * <b>Do not use:</b>, use {@link #addIssuer(X500Principal)} or
     * {@link #addIssuerName(byte[])} instead. It can fail to match some CRLs
     * because of a loss of encoding information in a RFC 2253 string.
     * <p>
     * Adds an issuer to the criterion for the issuer distinguished names. The
     * CRK issuer must match at least one of the specified distinguished names.
     *
     * @param iss_name
     *            the RFC 2253 encoded name.
     * @throws IOException
     *             if parsing fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.157 -0400", hash_original_method = "C08BF2CFD0C5324C4AE20C7726C8BFE1", hash_generated_method = "0E91D0704275D30D558C9A1D13756A85")
    
public void addIssuerName(String iss_name) throws IOException {
        if (issuerNames == null) {
            issuerNames = new ArrayList<String>();
        }

        if (iss_name == null) {
            iss_name = "";
        }

        String name = new Name(iss_name).getName(X500Principal.CANONICAL);
        if (!issuerNames.contains(name)) {
            issuerNames.add(name);
        }
    }

    /**
     * Adds an issuer to the criterion for the issuer distinguished names.
     * <p>
     * The CRL issuer must match at least one of the specified distinguished
     * names.
     *
     * @param iss_name
     *            the issuer to add to the criterion in ASN.1 DER encoded form.
     * @throws IOException
     *             if parsing fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.159 -0400", hash_original_method = "261A2C4A28631122E0753A758E6A08A3", hash_generated_method = "882271BFDFD2A58428C2876130268B79")
    
public void addIssuerName(byte[] iss_name) throws IOException {
        if (iss_name == null) {
            throw new NullPointerException("iss_name == null");
        }
        if (issuerNames == null) {
            issuerNames = new ArrayList<String>();
        }
        String name = new Name(iss_name).getName(X500Principal.CANONICAL);
        if (!issuerNames.contains(name)) {
            issuerNames.add(name);
        }
    }

    /**
     * Sets the criterion for the minimum CRL number.
     * <p>
     * The CRL must have a number extension with a value greater than or equal
     * to the specified parameter.
     *
     * @param minCRL
     *            the minimum CRL number or null to not check the minimum CRL
     *            number
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.160 -0400", hash_original_method = "EBFB8AEBFA554E8D634414E29D045A56", hash_generated_method = "7F8833AFF7C3E7C1E26A1EEEBDEDC9AF")
    
public void setMinCRLNumber(BigInteger minCRL) {
        this.minCRL = minCRL;
    }

    /**
     * Sets the criterion for the maximum CRL number.
     * <p>
     * The CRL must have a number extension with a value less than or equal to
     * the specified parameter.
     *
     * @param maxCRL
     *            the maximum CRL number or null to not check the maximum CRL
     *            number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.161 -0400", hash_original_method = "7A407D6EBE2D48B6A581D7AA4E5DB749", hash_generated_method = "8B55B07D583CB0990926B4B81747C157")
    
public void setMaxCRLNumber(BigInteger maxCRL) {
        this.maxCRL = maxCRL;
    }

    /**
     * Sets the criterion for the CRL update period.
     * <p>
     * The CRL's {@code thisUpdate} value must be equal or before the specified
     * date and the {@code nextUpdate} value must be after the specified date.
     *
     * @param dateAndTime
     *            the date to search for valid CRL's or {@code null} to not
     *            check the date.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.163 -0400", hash_original_method = "A05A2B0EEA22AFACDA9F7415254E96FC", hash_generated_method = "1053DDE108F585915B411C5252DDA1FD")
    
public void setDateAndTime(Date dateAndTime) {
        if (dateAndTime == null) {
            this.dateAndTime = -1;
            return;
        }
        this.dateAndTime = dateAndTime.getTime();
    }

    /**
     * Sets a certificate hint to find CRLs. It's not a criterion but may help
     * finding relevant CRLs.
     *
     * @param cert
     *            the certificate hint or {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.164 -0400", hash_original_method = "FFE8C2A38B6C9DDDB77B79D30EF81424", hash_generated_method = "201A59CA954CFCFC1A0D5A4C317481F9")
    
public void setCertificateChecking(X509Certificate cert) {
        this.certificateChecking = cert;
    }

    /**
     * Returns the criterion for the issuer distinguished names.
     * <p>
     * The CRL issuer must match at least one of the distinguished names.
     *
     * @return the unmodifiable list of issuer distinguished names to match, or
     *         {@code null} if any issuer distinguished name will do.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.166 -0400", hash_original_method = "A26C5EA0415744D9333E804381F3A24D", hash_generated_method = "51EA19E9DAC4A008169F187687CBE604")
    
public Collection<X500Principal> getIssuers() {
        if (issuerNames == null) {
            return null;
        }
        if (issuerPrincipals == null) {
            issuerPrincipals = new ArrayList<X500Principal>(issuerNames.size());
        }
        int size = issuerNames.size();
        // extend the list of issuer Principals
        for (int i=issuerPrincipals.size(); i<size; i++) {
            issuerPrincipals.add(new X500Principal(issuerNames.get(i)));
        }
        return Collections.unmodifiableCollection(issuerPrincipals);
    }

    /**
     * Returns the criterion for the issuer distinguished names.
     * <p>
     * The CRL issuer must match at least one of the distinguished names.
     *
     * @return a copy of the list of issuer distinguished names to
     *         match, or {@code null} if any issuer distinguished name
     *         will do. The elements may be strings or ASN.1 DER
     *         encoded byte arrays.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.167 -0400", hash_original_method = "D73B2AFFED45A5A7539E66D268A2F6C5", hash_generated_method = "60E3FD44D59D98D603A0046D497DFB29")
    
public Collection<Object> getIssuerNames() {
        if (issuerNames == null) {
            return null;
        }
        return (Collection<Object>) issuerNames.clone();
    }

    /**
     * Returns the criterion for the minimum CRL number.
     * <p>
     * The CRL must have a number extension with a value greater than or equal
     * to the returned value.
     *
     * @return the minimum CRL number or {@code null} if the minimum CRL number
     *         is not to be checked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.168 -0400", hash_original_method = "5886363A7852DD2CB854081E1DCE11F3", hash_generated_method = "0345D2F0BD70F7BA006B4B28B8B62759")
    
public BigInteger getMinCRL() {
        return minCRL;
    }

    /**
     * Returns the criterion for the maximum CRL number.
     * <p>
     * The CRL must have a number extension with a value less than or equal to
     * the returned value.
     *
     * @return the maximum CRL number or null if the maximum CRL number is not
     *         checked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.170 -0400", hash_original_method = "C1523C5CB8DEC8637ABF7C7A86743E99", hash_generated_method = "115A92E9C16985313E4B7A564ED642B5")
    
public BigInteger getMaxCRL() {
        return maxCRL;
    }

    /**
     * Returns the criterion for the CRL update period.
     * <p>
     * The CRL's {@code thisUpdate} value must be equal or before the returned
     * date and the {@code nextUpdate} value must be after the returned date.
     *
     * @return the date to search for valid CRL's or {@code null} if the date is
     *         not checked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.171 -0400", hash_original_method = "52AD071D6260050753D68E61EA2610F8", hash_generated_method = "E1F765A8E13B0ACAD0AF6E489D784C7A")
    
public Date getDateAndTime() {
        if (dateAndTime == -1) {
            return null;
        }
        return new Date(dateAndTime);
    }

    /**
     * Returns the certificate hint to find CRLs. It's not a criterion but may
     * help finding relevant CRLs.
     *
     * @return the certificate hint or {@code null} if none set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.172 -0400", hash_original_method = "E858373AAFE0AA896871859CCF01F1A0", hash_generated_method = "3A12EC10F8AEF90275B2E04182141768")
    
public X509Certificate getCertificateChecking() {
        return certificateChecking;
    }

    /**
     * Returns a string representation of this {@code X509CRLSelector} instance.
     *
     * @return a string representation of this {@code X509CRLSelector} instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.174 -0400", hash_original_method = "14EDB7C389AFAE56AF92F1107F34B5E5", hash_generated_method = "6E77A180C1811F6BF58BE8540B8CF4A6")
    
public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("X509CRLSelector:\n[");
        if (issuerNames != null) {
            result.append("\n  IssuerNames:\n  [");
            int size = issuerNames.size();
            for (int i=0; i<size; i++) {
                result.append("\n    "
                    + issuerNames.get(i));
            }
            result.append("\n  ]");
        }
        if (minCRL != null) {
            result.append("\n  minCRL: " + minCRL);
        }
        if (maxCRL != null) {
            result.append("\n  maxCRL: " + maxCRL);
        }
        if (dateAndTime != -1) {
            result.append("\n  dateAndTime: " + (new Date(dateAndTime)));
        }
        if (certificateChecking != null) {
            result.append("\n  certificateChecking: " + certificateChecking);
        }
        result.append("\n]");
        return result.toString();
    }

    /**
     * Returns whether the specified CRL matches all the criteria collected in
     * this instance.
     *
     * @param crl
     *            the CRL to check.
     * @return {@code true} if the CRL matches all the criteria, otherwise
     *         {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.176 -0400", hash_original_method = "5F2B3EFC037F339DB05B9FCB9716EDC6", hash_generated_method = "B18C4A8E49ACEF0C4D036C298830168C")
    
public boolean match(CRL crl) {
        if (!(crl instanceof X509CRL)) {
            return false;
        }
        X509CRL crlist = (X509CRL) crl;
        if ((issuerNames != null) &&
                // the search speed depends on the class of issuerNames
                !(issuerNames.contains(
                        crlist.getIssuerX500Principal().getName(
                            X500Principal.CANONICAL)))) {
            return false;
        }
        if ((minCRL != null) || (maxCRL != null)) {
            try {
                // As specified in rfc 3280 (http://www.ietf.org/rfc/rfc3280.txt)
                // CRL Number Extension's OID is 2.5.29.20 .
                byte[] bytes = crlist.getExtensionValue("2.5.29.20");
                bytes = (byte[]) ASN1OctetString.getInstance().decode(bytes);
                BigInteger crlNumber = new BigInteger((byte[])
                        ASN1Integer.getInstance().decode(bytes));
                if ((minCRL != null) && (crlNumber.compareTo(minCRL) < 0)) {
                    return false;
                }
                if ((maxCRL != null) && (crlNumber.compareTo(maxCRL) > 0)) {
                    return false;
                }
            } catch (IOException e) {
                return false;
            }
        }
        if (dateAndTime != -1) {
            Date thisUp = crlist.getThisUpdate();
            Date nextUp = crlist.getNextUpdate();
            if ((thisUp == null) || (nextUp == null)) {
                return false;
            }
            if ((dateAndTime < thisUp.getTime())
                                || (dateAndTime > nextUp.getTime())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Clones this {@code X509CRL} instance.
     *
     * @return the cloned instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:16.178 -0400", hash_original_method = "24B0A90CEBB0E9C5967CF85BEA658F64", hash_generated_method = "E2C9D2CBBE0E1313C3B85C54356C24FA")
    
public Object clone() {
        X509CRLSelector result;

        try {
            result = (X509CRLSelector) super.clone();
            if (issuerNames != null) {
                result.issuerNames = new ArrayList<String>(issuerNames);
            }
        } catch (CloneNotSupportedException e) {
            result = null;
        }
        return result;
    }
}
