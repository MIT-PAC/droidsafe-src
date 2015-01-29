package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.security.auth.x500.X500Principal;

import libcore.io.IoUtils;

public final class TrustedCertificateStore {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.099 -0500", hash_original_method = "DCFE2389161714EAAF8DB201DCF52E7A", hash_generated_method = "4C7F23B9176E1DC598B611118400DA46")
    
public static final boolean isSystem(String alias) {
        return alias.startsWith(PREFIX_SYSTEM);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.102 -0500", hash_original_method = "66DD5E082DA80BAFDBB321E3A5ECD314", hash_generated_method = "AAE3F6E60B7C36A82BDBE415CCA27702")
    
public static final boolean isUser(String alias) {
        return alias.startsWith(PREFIX_USER);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.094 -0500", hash_original_field = "F3E18CFBD6E10A11C58BAF834F98AC54", hash_generated_field = "98B968CCA96375701AE00045F4565AA4")

    private static final String PREFIX_SYSTEM = "system:";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.097 -0500", hash_original_field = "4ABBF2BD67F6106F67853F289ED5A5B1", hash_generated_field = "CC133772DAA5E2094775535E65584148")

    private static final String PREFIX_USER = "user:";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.104 -0500", hash_original_field = "283E40FD62CEAE6CD294616694784DBA", hash_generated_field = "FC1AC5B6AA36D7E7E6ACAACF0F236293")

    private static  File CA_CERTS_DIR_SYSTEM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.115 -0500", hash_original_field = "BF33E266D6D36F606699147B1B5D9E19", hash_generated_field = "0B21C402CC49FA93FF2ACC6C155EF2F1")

    private static  File CA_CERTS_DIR_ADDED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.118 -0500", hash_original_field = "BD0CBDB6771A9D5121C690233A7006E2", hash_generated_field = "CD17C03FD55940BDD7E8C3B35E42402F")

    private static  File CA_CERTS_DIR_DELETED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.120 -0500", hash_original_field = "E361AC23F639107077F868DDFDD301B7", hash_generated_field = "73AFD3573A389E9D3C4778BF352F4917")

    private static  CertificateFactory CERT_FACTORY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.123 -0500", hash_original_field = "34188D02504A9FC008F2E9AE5CDC85C4", hash_generated_field = "1804575DE1991A78118271CC161871B9")

    private  File systemDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.125 -0500", hash_original_field = "9E2FDF4E928303B14E3CF5401639ABCD", hash_generated_field = "309006457656B9EBA077D0AA58889218")

    private  File addedDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.127 -0500", hash_original_field = "2FDD757DB2D7FC2B5C50E22F53D6BB8D", hash_generated_field = "61E19E5C5CD4CDE0E056E3DFED6783DE")

    private  File deletedDir;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.130 -0500", hash_original_method = "2FF99D64326A5347B39C240182ABD235", hash_generated_method = "D1E157B1702BA3A6ECB5A3192553879A")
    
public TrustedCertificateStore() {
        this(CA_CERTS_DIR_SYSTEM, CA_CERTS_DIR_ADDED, CA_CERTS_DIR_DELETED);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.133 -0500", hash_original_method = "34C96A42FAFED1EA32C1B0CA7CD8DDF0", hash_generated_method = "973C790E151CA50B39C1262D298B8DAA")
    
public TrustedCertificateStore(File systemDir, File addedDir, File deletedDir) {
        this.systemDir = systemDir;
        this.addedDir = addedDir;
        this.deletedDir = deletedDir;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.135 -0500", hash_original_method = "DCFF226F6C2C4D0E26660E34EC9EC374", hash_generated_method = "80DAB13D18C0F0299AE527FFDDBCA6C8")
    
public Certificate getCertificate(String alias) {
        return getCertificate(alias, false);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.137 -0500", hash_original_method = "5E5623CDAE6C2674E4A1581BA2487353", hash_generated_method = "10372BE868B27952F552BCB0D85BE0FA")
    
public Certificate getCertificate(String alias, boolean includeDeletedSystem) {

        File file = fileForAlias(alias);
        if (file == null || (isUser(alias) && isTombstone(file))) {
            return null;
        }
        X509Certificate cert = readCertificate(file);
        if (cert == null || (isSystem(alias)
                             && !includeDeletedSystem
                             && isDeletedSystemCertificate(cert))) {
            // skip malformed certs as well as deleted system ones
            return null;
        }
        return cert;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.140 -0500", hash_original_method = "BD13BF64CDF62ABC225832ACDAE55EEB", hash_generated_method = "208A0432159597BBA51CA94E9F4F0291")
    
private File fileForAlias(String alias) {
        if (alias == null) {
            throw new NullPointerException("alias == null");
        }
        File file;
        if (isSystem(alias)) {
            file = new File(systemDir, alias.substring(PREFIX_SYSTEM.length()));
        } else if (isUser(alias)) {
            file = new File(addedDir, alias.substring(PREFIX_USER.length()));
        } else {
            return null;
        }
        if (!file.exists() || isTombstone(file)) {
            // silently elide tombstones
            return null;
        }
        return file;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.142 -0500", hash_original_method = "C0CC358A113978AA5962E41C2E3971C3", hash_generated_method = "9E8D43A857195E6988E08C4489BC37EA")
    
private boolean isTombstone(File file) {
        return file.length() == 0;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.145 -0500", hash_original_method = "8510D8C420703F5BE76FCD04B0D510F3", hash_generated_method = "DF6D9640B60109EAA7CE4FA2716B81B8")
    
private X509Certificate readCertificate(File file) {
        if (!file.isFile()) {
            return null;
        }
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(file));
            return (X509Certificate) CERT_FACTORY.generateCertificate(is);
        } catch (IOException e) {
            return null;
        } catch (CertificateException e) {
            // reading a cert while its being installed can lead to this.
            // just pretend like its not available yet.
            return null;
        } finally {
            IoUtils.closeQuietly(is);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.147 -0500", hash_original_method = "109D07F89CD9540F28E2544DA7036A76", hash_generated_method = "30F3FEC7F6299870448CCB5FEBE50A4E")
    
private void writeCertificate(File file, X509Certificate cert)
            throws IOException, CertificateException {
        File dir = file.getParentFile();
        dir.mkdirs();
        dir.setReadable(true, false);
        dir.setExecutable(true, false);
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            os.write(cert.getEncoded());
        } finally {
            IoUtils.closeQuietly(os);
        }
        file.setReadable(true, false);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.149 -0500", hash_original_method = "687C2EEF2D383D4BDFC0BC0824D70D25", hash_generated_method = "E360E08014674B6D13372821A7C6AB3D")
    
private boolean isDeletedSystemCertificate(X509Certificate x) {
        return getCertificateFile(deletedDir, x).exists();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.151 -0500", hash_original_method = "CCEB88AE1C59EF9C3585E776EAD03DC2", hash_generated_method = "BB1CD994B45F8387544C37547817291B")
    
public Date getCreationDate(String alias) {
        // containsAlias check ensures the later fileForAlias result
        // was not a deleted system cert.
        if (!containsAlias(alias)) {
            return null;
        }
        File file = fileForAlias(alias);
        if (file == null) {
            return null;
        }
        long time = file.lastModified();
        if (time == 0) {
            return null;
        }
        return new Date(time);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.153 -0500", hash_original_method = "08CEADDFFE08C3DC9E367E6EE1C8514A", hash_generated_method = "BCFEF7841170F08E0E70C9B5DB25EBFC")
    
public Set<String> aliases() {
        Set<String> result = new HashSet<String>();
        addAliases(result, PREFIX_USER, addedDir);
        addAliases(result, PREFIX_SYSTEM, systemDir);
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.156 -0500", hash_original_method = "47F99465DCD8C3DA2109E78A8164CD01", hash_generated_method = "1133EFE81EF874AB0BFA670BAD264C6F")
    
public Set<String> userAliases() {
        Set<String> result = new HashSet<String>();
        addAliases(result, PREFIX_USER, addedDir);
        return result;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.159 -0500", hash_original_method = "BF0B38E159AD70D54A581822F625340B", hash_generated_method = "F07FEA8D58A9E40665F86B1657A755FA")
    
private void addAliases(Set<String> result, String prefix, File dir) {
        String[] files = dir.list();
        if (files == null) {
            return;
        }
        for (String filename : files) {
            String alias = prefix + filename;
            if (containsAlias(alias)) {
                result.add(alias);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.161 -0500", hash_original_method = "43549AE16FD66ED845B02A525540D973", hash_generated_method = "6ABF41C6CB39676F72A418D88F18A097")
    
public Set<String> allSystemAliases() {
        Set<String> result = new HashSet<String>();
        String[] files = systemDir.list();
        if (files == null) {
            return result;
        }
        for (String filename : files) {
            String alias = PREFIX_SYSTEM + filename;
            if (containsAlias(alias, true)) {
                result.add(alias);
            }
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.163 -0500", hash_original_method = "654AA0CAB25ECF1B8F909EEC1B58BB82", hash_generated_method = "EA1E207751BF899BF9B9EE626B04B7F5")
    
public boolean containsAlias(String alias) {
        return containsAlias(alias, false);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.165 -0500", hash_original_method = "63CEC7C48C1DF35A32FA8773B953555D", hash_generated_method = "BB8FBCDDA68D6DEF9FC942D4D2F9C8FA")
    
private boolean containsAlias(String alias, boolean includeDeletedSystem) {
        return getCertificate(alias, includeDeletedSystem) != null;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.168 -0500", hash_original_method = "2147628C71E1D1C09BD2609FCF8F152B", hash_generated_method = "ED845C999F772E40D43E7C63FA21BA7E")
    
public String getCertificateAlias(Certificate c) {
        if (c == null || !(c instanceof X509Certificate)) {
            return null;
        }
        X509Certificate x = (X509Certificate) c;
        File user = getCertificateFile(addedDir, x);
        if (user.exists()) {
            return PREFIX_USER + user.getName();
        }
        if (isDeletedSystemCertificate(x)) {
            return null;
        }
        File system = getCertificateFile(systemDir, x);
        if (system.exists()) {
            return PREFIX_SYSTEM + system.getName();
        }
        return null;
    }

    /**
     * Returns a File for where the certificate is found if it exists
     * or where it should be installed if it does not exist. The
     * caller can disambiguate these cases by calling {@code
     * File.exists()} on the result.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.173 -0500", hash_original_method = "00D6A00D33EFE0DA025C348896CFB4AD", hash_generated_method = "41F92BDDD37956F7C135F791928A8C48")
    
private File getCertificateFile(File dir, final X509Certificate x) {
        // compare X509Certificate.getEncoded values
        CertSelector selector = new CertSelector() {
            @Override public boolean match(X509Certificate cert) {
                return cert.equals(x);
            }
        };
        return findCert(dir, x.getSubjectX500Principal(), selector, File.class);
    }

    /**
     * This non-{@code KeyStoreSpi} public interface is used by {@code
     * TrustManagerImpl} to locate a CA certificate with the same name
     * and public key as the provided {@code X509Certificate}. We
     * match on the name and public key and not the entire certificate
     * since a CA may be reissued with the same name and PublicKey but
     * with other differences (for example when switching signature
     * from md2WithRSAEncryption to SHA1withRSA)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.179 -0500", hash_original_method = "48D05ED9669BF04FD3B698D9020EF167", hash_generated_method = "03F6F88B46311673C6583F99EBFAF7AE")
    
public boolean isTrustAnchor(final X509Certificate c) {
        // compare X509Certificate.getPublicKey values
        CertSelector selector = new CertSelector() {
            @Override public boolean match(X509Certificate ca) {
                return ca.getPublicKey().equals(c.getPublicKey());
            }
        };
        boolean user = findCert(addedDir,
                                c.getSubjectX500Principal(),
                                selector,
                                Boolean.class);
        if (user) {
            return true;
        }
        X509Certificate system = findCert(systemDir,
                                          c.getSubjectX500Principal(),
                                          selector,
                                          X509Certificate.class);
        return system != null && !isDeletedSystemCertificate(system);
    }

    /**
     * This non-{@code KeyStoreSpi} public interface is used by {@code
     * TrustManagerImpl} to locate the CA certificate that signed the
     * provided {@code X509Certificate}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.185 -0500", hash_original_method = "A6B2832B57E732FF74F3B8B62A574310", hash_generated_method = "CB15FF5D2931D5BD7F79B3D99A3A9F5A")
    
public X509Certificate findIssuer(final X509Certificate c) {
        // match on verified issuer of Certificate
        CertSelector selector = new CertSelector() {
            @Override public boolean match(X509Certificate ca) {
                try {
                    c.verify(ca.getPublicKey());
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        };
        X500Principal issuer = c.getIssuerX500Principal();
        X509Certificate user = findCert(addedDir, issuer, selector, X509Certificate.class);
        if (user != null) {
            return user;
        }
        X509Certificate system = findCert(systemDir, issuer, selector, X509Certificate.class);
        if (system != null && !isDeletedSystemCertificate(system)) {
            return system;
        }
        return null;
    }
    
    private static interface CertSelector {
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public boolean match(X509Certificate cert);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.053 -0400", hash_original_method = "3F71F2007BD6B23A9969AFA8B1C7C7C7", hash_generated_method = "99D663D2CC257420CD184BE738D2B62A")
    private <T> T findCert(
            File dir, X500Principal subject, CertSelector selector, Class<T> desiredReturnType) {
        addTaint(desiredReturnType.getTaint());
        addTaint(selector.getTaint());
        addTaint(subject.getTaint());
        addTaint(dir.getTaint());
        String hash = hash(subject);
for(int index = 0;true;index++)
        {
            File file = file(dir, hash, index);
            if(!file.isFile())            
            {
                if(desiredReturnType == Boolean.class)                
                {
T varEEA82B1F5951E79A49A59D17E2B4064C_1145522171 =                     (T) Boolean.FALSE;
                    varEEA82B1F5951E79A49A59D17E2B4064C_1145522171.addTaint(getTaint());
                    return varEEA82B1F5951E79A49A59D17E2B4064C_1145522171;
                } //End block
                if(desiredReturnType == File.class)                
                {
T varF370AF19C57A14797EFDE924F649B8A2_1417298089 =                     (T) file;
                    varF370AF19C57A14797EFDE924F649B8A2_1417298089.addTaint(getTaint());
                    return varF370AF19C57A14797EFDE924F649B8A2_1417298089;
                } //End block
T var540C13E9E156B687226421B24F2DF178_442038581 =                 null;
                var540C13E9E156B687226421B24F2DF178_442038581.addTaint(getTaint());
                return var540C13E9E156B687226421B24F2DF178_442038581;
            } //End block
            if(isTombstone(file))            
            {
                continue;
            } //End block
            X509Certificate cert = readCertificate(file);
            if(cert == null)            
            {
                continue;
            } //End block
            if(selector.match(cert))            
            {
                if(desiredReturnType == X509Certificate.class)                
                {
T var317015959638CAF4FFAC3A88AE5CE017_819158653 =                     (T) cert;
                    var317015959638CAF4FFAC3A88AE5CE017_819158653.addTaint(getTaint());
                    return var317015959638CAF4FFAC3A88AE5CE017_819158653;
                } //End block
                if(desiredReturnType == Boolean.class)                
                {
T varE0E5C48B656ACCBA0CDB3CC6914BAD9C_41080555 =                     (T) Boolean.TRUE;
                    varE0E5C48B656ACCBA0CDB3CC6914BAD9C_41080555.addTaint(getTaint());
                    return varE0E5C48B656ACCBA0CDB3CC6914BAD9C_41080555;
                } //End block
                if(desiredReturnType == File.class)                
                {
T varF370AF19C57A14797EFDE924F649B8A2_1961021583 =                     (T) file;
                    varF370AF19C57A14797EFDE924F649B8A2_1961021583.addTaint(getTaint());
                    return varF370AF19C57A14797EFDE924F649B8A2_1961021583;
                } //End block
                AssertionError varA81442E36297E737EB908877E58260E8_1544935951 = new AssertionError();
                varA81442E36297E737EB908877E58260E8_1544935951.addTaint(getTaint());
                throw varA81442E36297E737EB908877E58260E8_1544935951;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.192 -0500", hash_original_method = "90B2D041BE6875A6E09EF80BBE557D3F", hash_generated_method = "9B6806023FC65309048F077142AA443D")
    
private String hash(X500Principal name) {
        int hash = NativeCrypto.X509_NAME_hash_old(name);
        return IntegralToString.intToHexString(hash, false, 8);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.194 -0500", hash_original_method = "0B663A316D5F1EC956CA42A84A17EC6A", hash_generated_method = "5C95134D32A0F373087356EE9B04039F")
    
private File file(File dir, String hash, int index) {
        return new File(dir, hash + '.' + index);
    }

    /**
     * This non-{@code KeyStoreSpi} public interface is used by the
     * {@code KeyChainService} to install new CA certificates. It
     * silently ignores the certificate if it already exists in the
     * store.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.197 -0500", hash_original_method = "895D177FC3F042016815EFE0F89E89FF", hash_generated_method = "BA65781A5D71CB269E48C49B20458D7A")
    
public void installCertificate(X509Certificate cert) throws IOException, CertificateException {
        if (cert == null) {
            throw new NullPointerException("cert == null");
        }
        File system = getCertificateFile(systemDir, cert);
        if (system.exists()) {
            File deleted = getCertificateFile(deletedDir, cert);
            if (deleted.exists()) {
                // we have a system cert that was marked deleted.
                // remove the deleted marker to expose the original
                if (!deleted.delete()) {
                    throw new IOException("Could not remove " + deleted);
                }
                return;
            }
            // otherwise we just have a dup of an existing system cert.
            // return taking no further action.
            return;
        }
        File user = getCertificateFile(addedDir, cert);
        if (user.exists()) {
            // we have an already installed user cert, bail.
            return;
        }
        // install the user cert
        writeCertificate(user, cert);
    }

    /**
     * This could be considered the implementation of {@code
     * TrustedCertificateKeyStoreSpi.engineDeleteEntry} but we
     * consider {@code TrustedCertificateKeyStoreSpi} to be read
     * only. Instead, this is used by the {@code KeyChainService} to
     * delete CA certificates.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.199 -0500", hash_original_method = "7A4509C068B331E1E582C2216EB99D6E", hash_generated_method = "5CA595F2F77A20B7DE2B92E6DD23CBAB")
    
public void deleteCertificateEntry(String alias) throws IOException, CertificateException {
        if (alias == null) {
            return;
        }
        File file = fileForAlias(alias);
        if (file == null) {
            return;
        }
        if (isSystem(alias)) {
            X509Certificate cert = readCertificate(file);
            if (cert == null) {
                // skip problem certificates
                return;
            }
            File deleted = getCertificateFile(deletedDir, cert);
            if (deleted.exists()) {
                // already deleted system certificate
                return;
            }
            // write copy of system cert to marked as deleted
            writeCertificate(deleted, cert);
            return;
        }
        if (isUser(alias)) {
            // truncate the file to make a tombstone by opening and closing.
            // we need ensure that we don't leave a gap before a valid cert.
            new FileOutputStream(file).close();
            removeUnnecessaryTombstones(alias);
            return;
        }
        // non-existant user cert, nothing to delete
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.202 -0500", hash_original_method = "728256A42E564BAD8F0CB50A75981023", hash_generated_method = "639537D40AB17CDF6D417500CE67D614")
    
private void removeUnnecessaryTombstones(String alias) throws IOException {
        if (!isUser(alias)) {
            throw new AssertionError(alias);
        }
        int dotIndex = alias.lastIndexOf('.');
        if (dotIndex == -1) {
            throw new AssertionError(alias);
        }

        String hash = alias.substring(PREFIX_USER.length(), dotIndex);
        int lastTombstoneIndex = Integer.parseInt(alias.substring(dotIndex + 1));

        if (file(addedDir, hash, lastTombstoneIndex + 1).exists()) {
            return;
        }
        while (lastTombstoneIndex >= 0) {
            File file = file(addedDir, hash, lastTombstoneIndex);
            if (!isTombstone(file)) {
                break;
            }
            if (!file.delete()) {
                throw new IOException("Could not remove " + file);
            }
            lastTombstoneIndex--;
        }
    }
    static {
        String ANDROID_ROOT = System.getenv("ANDROID_ROOT");
        String ANDROID_DATA = System.getenv("ANDROID_DATA");
        CA_CERTS_DIR_SYSTEM = new File(ANDROID_ROOT + "/etc/security/cacerts");
        CA_CERTS_DIR_ADDED = new File(ANDROID_DATA + "/misc/keychain/cacerts-added");
        CA_CERTS_DIR_DELETED = new File(ANDROID_DATA + "/misc/keychain/cacerts-removed");
        try {
            CERT_FACTORY = CertificateFactory.getInstance("X509");
        } catch (CertificateException e) {
            throw new AssertionError(e);
        }
    }
    
}

