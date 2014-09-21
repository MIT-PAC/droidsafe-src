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
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.utils.AlgNameMapper;
import org.apache.harmony.security.x509.CertificateList;
import org.apache.harmony.security.x509.Extension;
import org.apache.harmony.security.x509.Extensions;
import org.apache.harmony.security.x509.TBSCertList;

/**
 * This class is an implementation of X509CRL. It wraps
 * the instance of org.apache.harmony.security.x509.CertificateList
 * built on the base of provided ASN.1 DER encoded form of
 * CertificateList structure (as specified in RFC 3280
 * http://www.ietf.org/rfc/rfc3280.txt).
 * Implementation supports work with indirect CRLs.
 * @see org.apache.harmony.security.x509.CertificateList
 * @see java.security.cert.X509CRL
 */
public class X509CRLImpl extends X509CRL {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.095 -0400", hash_original_field = "A4C34E903E3C87B8F646CCAEB30DBBC6", hash_generated_field = "E888D7F8C03281DCBB1F4BABD3DA775A")

    private  CertificateList crl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.096 -0400", hash_original_field = "894D071EFC59C716ABB532FBFE5DB823", hash_generated_field = "D607423928EC031A1254DB667D90F1C7")

    // cache values retrieved from the CertificateList object
    private  TBSCertList tbsCertList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.096 -0400", hash_original_field = "DBCB3E7B0BCAC29A79EFF6DFB69EA770", hash_generated_field = "5BD292B05FE0565666DA8B29164D2903")

    private byte[] tbsCertListEncoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.097 -0400", hash_original_field = "11D23A9D67ECEDEBAFCBDADBAE6E0FA1", hash_generated_field = "85FCB044EB3BC544E06DEC3DDF20CB7B")

    private  Extensions extensions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.098 -0400", hash_original_field = "99BE4463DA67376AA94F7D97DDB8D7FF", hash_generated_field = "30FEA84FB35EF28DB029D29044BA91EC")

    private X500Principal issuer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.098 -0400", hash_original_field = "0F3626F94DCC8B678D39EB821938478D", hash_generated_field = "C53AC1F28D2AA1B42A58113F18C1A145")

    private ArrayList entries;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.098 -0400", hash_original_field = "57589D8AF583C923F139C54CE265E9E8", hash_generated_field = "B36549B1FC5EF00C9949CF549125AE65")

    private int entriesSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.099 -0400", hash_original_field = "89CE5EB976882E5EBBD495E98D430D47", hash_generated_field = "0DB6F7EB15A1BDD9737913A895BFEA57")

    private byte[] signature;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.099 -0400", hash_original_field = "8E10B0B5A62ABD64FA9CA5CFA3002BB8", hash_generated_field = "BDDA01FE78085EBD61788DA3C2998FAB")

    private String sigAlgOID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.100 -0400", hash_original_field = "26DABF5BD766951ADC08DC97E66ADD9E", hash_generated_field = "E1A67E322DB41B42A458130BFEF1767A")

    private String sigAlgName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.100 -0400", hash_original_field = "7D8C90E870C41938AFC08C3BE4E5FAFE", hash_generated_field = "6960B76E616D0830F58F627B5FCDD6BE")

    private byte[] sigAlgParams;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.100 -0400", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.101 -0400", hash_original_field = "647BF73090D203056F6FE9A73A500D11", hash_generated_field = "7BE40F7630EBFACF550EF7C2E363D67B")

    private boolean nullSigAlgParams;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.101 -0400", hash_original_field = "BAFEA30F40F51E244B14BC710F4686E3", hash_generated_field = "6F056D83894C0FE49FAD619EE64CE194")

    // from CertificateList object (crl)
    private boolean entriesRetrieved;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.102 -0400", hash_original_field = "2BE585555CDEDB2ACD1708FD5FD5CDD3", hash_generated_field = "EB83205DD87645ABE086370AB4E99177")

    // (see rfc 3280 http://www.ietf.org/rfc/rfc3280.txt, p 5.)
    private boolean isIndirectCRL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.102 -0400", hash_original_field = "031E394BE6E037EB64CB7E4CD72D548D", hash_generated_field = "D3C24C3B2CB4ED10D5E51832DA80F55B")

    // many of the leading certificates in the list are issued
    // by the same issuer as CRL.
    private int nonIndirectEntriesSize;

    /**
     * Creates X.509 CRL by wrapping of the specified CertificateList object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.104 -0400", hash_original_method = "469B53AEEEAB044B53B373E873C95965", hash_generated_method = "4B609E9BBBF2C69210C7BA3781ECD267")
    
public X509CRLImpl(CertificateList crl) {
        this.crl = crl;
        this.tbsCertList = crl.getTbsCertList();
        this.extensions = tbsCertList.getCrlExtensions();
    }

    /**
     * Creates X.509 CRL on the base of ASN.1 DER encoded form of
     * the CRL (CertificateList structure described in RFC 3280)
     * provided via input stream.
     * @throws CRLException if decoding errors occur.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.104 -0400", hash_original_method = "DBE76AEE6D27754CBCA47C1DCF78FE89", hash_generated_method = "D9830D20A928D29CB3CC7A695D5CCCC2")
    
public X509CRLImpl(InputStream in) throws CRLException {
        try {
            // decode CertificateList structure
            this.crl = (CertificateList) CertificateList.ASN1.decode(in);
            this.tbsCertList = crl.getTbsCertList();
            this.extensions = tbsCertList.getCrlExtensions();
        } catch (IOException e) {
            throw new CRLException(e);
        }
    }

    /**
     * Creates X.509 CRL on the base of ASN.1 DER encoded form of
     * the CRL (CertificateList structure described in RFC 3280)
     * provided via array of bytes.
     * @throws IOException if decoding errors occur.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.105 -0400", hash_original_method = "6D0558ABAF46F03E8D1BCE08013CEDF0", hash_generated_method = "E03DB9F442D2B1551D11089662D93F5B")
    
public X509CRLImpl(byte[] encoding) throws IOException {
        this((CertificateList) CertificateList.ASN1.decode(encoding));
    }

    // ---------------------------------------------------------------------
    // ----- java.security.cert.X509CRL abstract method implementations ----
    // ---------------------------------------------------------------------

    /**
     * @see java.security.cert.X509CRL#getEncoded()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.106 -0400", hash_original_method = "47465A7C9C7C1A963980357D2F19CC24", hash_generated_method = "E7BDA9F41FECDCD9B2C88B7EDCF8509F")
    
public byte[] getEncoded() throws CRLException {
        if (encoding == null) {
            encoding = crl.getEncoded();
        }
        byte[] result = new byte[encoding.length];
        System.arraycopy(encoding, 0, result, 0, encoding.length);
        return result;
    }

    /**
     * @see java.security.cert.X509CRL#getVersion()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.106 -0400", hash_original_method = "6BD34D6EBA186C550EB73B633E8F4FDD", hash_generated_method = "9435E220F58B8022B997EC1CF6553FD2")
    
public int getVersion() {
        return tbsCertList.getVersion();
    }

    /**
     * @see java.security.cert.X509CRL#getIssuerDN()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.107 -0400", hash_original_method = "6C0181854CA27C8B35F42E7DE8BA539D", hash_generated_method = "7FE9EE7AB19DED12694A062610854A80")
    
public Principal getIssuerDN() {
        if (issuer == null) {
            issuer = tbsCertList.getIssuer().getX500Principal();
        }
        return issuer;
    }

    /**
     * @see java.security.cert.X509CRL#getIssuerX500Principal()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.107 -0400", hash_original_method = "A3D00C2B8FF8A061907C2D2A93051D41", hash_generated_method = "FE5916AF5923C6BF13024203ECF1CEB3")
    
public X500Principal getIssuerX500Principal() {
        if (issuer == null) {
            issuer = tbsCertList.getIssuer().getX500Principal();
        }
        return issuer;
    }

    /**
     * @see java.security.cert.X509CRL#getThisUpdate()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.108 -0400", hash_original_method = "5E5132C0EEFEA379E6C69CCDC98F41B7", hash_generated_method = "C73CC99E3AE81551A9474E9554D04499")
    
public Date getThisUpdate() {
        return tbsCertList.getThisUpdate();
    }

    /**
     * @see java.security.cert.X509CRL#getNextUpdate()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.108 -0400", hash_original_method = "03C8E5E67640D87AE710040660CADACF", hash_generated_method = "0990A55610FE9FD0CDCBC6ED3E9FA5E0")
    
public Date getNextUpdate() {
        return tbsCertList.getNextUpdate();
    }

    /*
     * Retrieves the crl entries (TBSCertList.RevokedCertificate objects)
     * from the TBSCertList structure and converts them to the
     * X509CRLEntryImpl objects
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.109 -0400", hash_original_method = "6E5D62E531C291AE20152E721ADB097D", hash_generated_method = "B0B742BB2D6478EE427786385721228F")
    
private void retrieveEntries() {
        entriesRetrieved = true;
        List rcerts = tbsCertList.getRevokedCertificates();
        if (rcerts == null) {
            return;
        }
        entriesSize = rcerts.size();
        entries = new ArrayList(entriesSize);
        // null means that revoked certificate issuer is the same as CRL issuer
        X500Principal rcertIssuer = null;
        for (int i=0; i<entriesSize; i++) {
            TBSCertList.RevokedCertificate rcert =
                (TBSCertList.RevokedCertificate) rcerts.get(i);
            X500Principal iss = rcert.getIssuer();
            if (iss != null) {
                // certificate issuer differs from CRL issuer
                // and CRL is indirect.
                rcertIssuer = iss;
                isIndirectCRL = true;
                // remember how many leading revoked certificates in the
                // list are issued by the same issuer as issuer of CRL
                // (these certificates are first in the list)
                nonIndirectEntriesSize = i;
            }
            entries.add(new X509CRLEntryImpl(rcert, rcertIssuer));
        }
    }

    /**
     * Searches for certificate in CRL.
     * This method supports indirect CRLs: if CRL is indirect method takes
     * into account serial number and issuer of the certificate,
     * if CRL issued by CA (i.e. it is not indirect) search is done only
     * by serial number of the specified certificate.
     * @see java.security.cert.X509CRL#getRevokedCertificate(X509Certificate)
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.110 -0400", hash_original_method = "64BB39FF7174FAAD962D215CEAE037B3", hash_generated_method = "3F0625F3368156DF29C197A36AE0BCC5")
    
public X509CRLEntry getRevokedCertificate(X509Certificate certificate) {
        if (certificate == null) {
            throw new NullPointerException("certificate == null");
        }
        if (!entriesRetrieved) {
            retrieveEntries();
        }
        if (entries == null) {
            return null;
        }
        BigInteger serialN = certificate.getSerialNumber();
        if (isIndirectCRL) {
            // search in indirect crl
            X500Principal certIssuer = certificate.getIssuerX500Principal();
            if (certIssuer.equals(getIssuerX500Principal())) {
                // certificate issuer is CRL issuer
                certIssuer = null;
            }
            for (int i=0; i<entriesSize; i++) {
                X509CRLEntry entry = (X509CRLEntry) entries.get(i);
                // check the serial number of revoked certificate
                if (serialN.equals(entry.getSerialNumber())) {
                    // revoked certificate issuer
                    X500Principal iss = entry.getCertificateIssuer();
                    // check the issuer of revoked certificate
                    if (certIssuer != null) {
                        // certificate issuer is not a CRL issuer, so
                        // check issuers for equality
                        if (certIssuer.equals(iss)) {
                            return entry;
                        }
                    } else if (iss == null) {
                        // both certificates was issued by CRL issuer
                        return entry;
                    }
                }
            }
        } else {
            // search in CA's (non indirect) crl: just look up the serial number
            for (int i=0; i<entriesSize; i++) {
                X509CRLEntry entry = (X509CRLEntry) entries.get(i);
                if (serialN.equals(entry.getSerialNumber())) {
                    return entry;
                }
            }
        }
        return null;
    }

    /**
     * Method searches for CRL entry with specified serial number.
     * The method will search only certificate issued by CRL's issuer.
     * @see java.security.cert.X509CRL#getRevokedCertificate(BigInteger)
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.111 -0400", hash_original_method = "963B7212897919E2C68F52BAC2CEB0EB", hash_generated_method = "1003E409DAA6D5C5DC02B7E4D5BB8FE6")
    
public X509CRLEntry getRevokedCertificate(BigInteger serialNumber) {
        if (!entriesRetrieved) {
            retrieveEntries();
        }
        if (entries == null) {
            return null;
        }
        for (int i=0; i<nonIndirectEntriesSize; i++) {
            X509CRLEntry entry = (X509CRLEntry) entries.get(i);
            if (serialNumber.equals(entry.getSerialNumber())) {
                return entry;
            }
        }
        return null;
    }

    /**
     * @see java.security.cert.X509CRL#getRevokedCertificates()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.112 -0400", hash_original_method = "245E0793331B40206AC829F444582112", hash_generated_method = "CA12F99251E0FD73AC66805BDFB31489")
    
public Set<? extends X509CRLEntry> getRevokedCertificates() {
        if (!entriesRetrieved) {
            retrieveEntries();
        }
        if (entries == null) {
            return null;
        }
        return new HashSet(entries);
    }

    /**
     * @see java.security.cert.X509CRL#getTBSCertList()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.112 -0400", hash_original_method = "80951CA78806BF3D88D5D0E5D2A63D34", hash_generated_method = "D0BBF48A240C49823F4D146BD537CB22")
    
public byte[] getTBSCertList() throws CRLException {
        if (tbsCertListEncoding == null) {
            tbsCertListEncoding = tbsCertList.getEncoded();
        }
        byte[] result = new byte[tbsCertListEncoding.length];
        System.arraycopy(tbsCertListEncoding, 0,
                result, 0, tbsCertListEncoding.length);
        return result;
    }

    /**
     * @see java.security.cert.X509CRL#getSignature()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.113 -0400", hash_original_method = "6E23A8767B40A927681CAB3D31223CDE", hash_generated_method = "02CAEAC9B265D27D7DAA4D0E35C54546")
    
public byte[] getSignature() {
        if (signature == null) {
            signature = crl.getSignatureValue();
        }
        byte[] result = new byte[signature.length];
        System.arraycopy(signature, 0, result, 0, signature.length);
        return result;
    }

    /**
     * @see java.security.cert.X509CRL#getSigAlgName()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.114 -0400", hash_original_method = "38C3BFD89D83692B4FB6147227BDA387", hash_generated_method = "A3E1787E35227A75D7129EEAE743B20B")
    
public String getSigAlgName() {
        if (sigAlgOID == null) {
            sigAlgOID = tbsCertList.getSignature().getAlgorithm();
            sigAlgName = AlgNameMapper.map2AlgName(sigAlgOID);
            if (sigAlgName == null) {
                sigAlgName = sigAlgOID;
            }
        }
        return sigAlgName;
    }

    /**
     * @see java.security.cert.X509CRL#getSigAlgOID()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.114 -0400", hash_original_method = "35A647C1F20F01D3AEDE7DCD2DBBCE19", hash_generated_method = "0E1BEF2A5045F1AEFA0180C9EC171E1D")
    
public String getSigAlgOID() {
        if (sigAlgOID == null) {
            sigAlgOID = tbsCertList.getSignature().getAlgorithm();
            sigAlgName = AlgNameMapper.map2AlgName(sigAlgOID);
            if (sigAlgName == null) {
                sigAlgName = sigAlgOID;
            }
        }
        return sigAlgOID;
    }

    /**
     * @see java.security.cert.X509CRL#getSigAlgParams()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.115 -0400", hash_original_method = "9367982CD5C83CFB0CC138F217A68A95", hash_generated_method = "ABBAB46DE4FF16BD5E1D88CA90A88981")
    
public byte[] getSigAlgParams() {
        if (nullSigAlgParams) {
            return null;
        }
        if (sigAlgParams == null) {
            sigAlgParams = tbsCertList.getSignature().getParameters();
            if (sigAlgParams == null) {
                nullSigAlgParams = true;
                return null;
            }
        }
        return sigAlgParams;
    }

    /**
     * @see java.security.cert.X509CRL#verify(PublicKey key)
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.115 -0400", hash_original_method = "7486451B31F3C9519D29FDAB59B85A3A", hash_generated_method = "8CBAC802891633A41AF78D9B9BD35A4F")
    
public void verify(PublicKey key)
                     throws CRLException, NoSuchAlgorithmException,
                            InvalidKeyException, NoSuchProviderException,
                            SignatureException {
        Signature signature = Signature.getInstance(getSigAlgName());
        signature.initVerify(key);
        byte[] tbsEncoding = tbsCertList.getEncoded();
        signature.update(tbsEncoding, 0, tbsEncoding.length);
        if (!signature.verify(crl.getSignatureValue())) {
            throw new SignatureException("Signature was not verified");
        }
    }

    /**
     * @see java.security.cert.X509CRL#verify(PublicKey key, String sigProvider)
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.116 -0400", hash_original_method = "86860D5F51833422A7C7714AEFB25CAD", hash_generated_method = "F49D1DAC8C59436C9CCD7258FF864C0F")
    
public void verify(PublicKey key, String sigProvider)
                     throws CRLException, NoSuchAlgorithmException,
                            InvalidKeyException, NoSuchProviderException,
                            SignatureException {
        Signature signature = Signature.getInstance(
                                            getSigAlgName(), sigProvider);
        signature.initVerify(key);
        byte[] tbsEncoding = tbsCertList.getEncoded();
        signature.update(tbsEncoding, 0, tbsEncoding.length);
        if (!signature.verify(crl.getSignatureValue())) {
            throw new SignatureException("Signature was not verified");
        }
    }

    // ---------------------------------------------------------------------
    // ------ java.security.cert.CRL abstract method implementations -------
    // ---------------------------------------------------------------------

    /**
     * @see java.security.cert.CRL#isRevoked(Certificate)
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.117 -0400", hash_original_method = "838F1F6FC09EC2187ACC31060F53682A", hash_generated_method = "0A5FF2DD99B2A361FED5AB316767E85C")
    
public boolean isRevoked(Certificate cert) {
        if (!(cert instanceof X509Certificate)) {
            return false;
        }
        return getRevokedCertificate((X509Certificate) cert) != null;
    }

    /**
     * @see java.security.cert.CRL#toString()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.117 -0400", hash_original_method = "2CB91A9E1696B88F4EC13EF2C323F12E", hash_generated_method = "C4E08F59AA994F3DA262336A4F913D4D")
    
public String toString() {
        return crl.toString();
    }

    // ---------------------------------------------------------------------
    // ------ java.security.cert.X509Extension method implementations ------
    // ---------------------------------------------------------------------

    /**
     * @see java.security.cert.X509Extension#getNonCriticalExtensionOIDs()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.118 -0400", hash_original_method = "D4D5C9AC69DCBDFBA272C75E3E279C10", hash_generated_method = "DECB935D334A01930DC9BFB11F619EE3")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.118 -0400", hash_original_method = "356F6253943D47D7B8C3AC0E227CFED7", hash_generated_method = "414EE93E3AC7CFBC7E2BDA4F25E13A11")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.119 -0400", hash_original_method = "46B3B0A81D238D78F58FF04050F493C3", hash_generated_method = "E8C81FF47A9BB78775EA85D53051AB41")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.119 -0400", hash_original_method = "CB7B238BECDE285B4B368E69C74FBD34", hash_generated_method = "C3454B954195A9906295E5AC12ECB3A6")
    
public boolean hasUnsupportedCriticalExtension() {
        if (extensions == null) {
            return false;
        }
        return extensions.hasUnsupportedCritical();
    }
}
