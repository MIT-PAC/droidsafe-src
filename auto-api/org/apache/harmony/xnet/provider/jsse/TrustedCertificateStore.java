package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStoreSpi;
import java.security.PublicKey;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import libcore.io.IoUtils;

public final class TrustedCertificateStore {
    private File systemDir;
    private File addedDir;
    private File deletedDir;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.428 -0400", hash_original_method = "2FF99D64326A5347B39C240182ABD235", hash_generated_method = "D7D90E22E15F31DCC7BD51E02E748945")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TrustedCertificateStore() {
        this(CA_CERTS_DIR_SYSTEM, CA_CERTS_DIR_ADDED, CA_CERTS_DIR_DELETED);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.428 -0400", hash_original_method = "34C96A42FAFED1EA32C1B0CA7CD8DDF0", hash_generated_method = "0207104C378DB5E6881B267AAB08B606")
    @DSModeled(DSC.SAFE)
    public TrustedCertificateStore(File systemDir, File addedDir, File deletedDir) {
        dsTaint.addTaint(addedDir.dsTaint);
        dsTaint.addTaint(deletedDir.dsTaint);
        dsTaint.addTaint(systemDir.dsTaint);
        // ---------- Original Method ----------
        //this.systemDir = systemDir;
        //this.addedDir = addedDir;
        //this.deletedDir = deletedDir;
    }

    
        public static final boolean isSystem(String alias) {
        return alias.startsWith(PREFIX_SYSTEM);
    }

    
        public static final boolean isUser(String alias) {
        return alias.startsWith(PREFIX_USER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.428 -0400", hash_original_method = "DCFF226F6C2C4D0E26660E34EC9EC374", hash_generated_method = "AB96CF08FA5A4191A69A6F4BB521D351")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Certificate getCertificate(String alias) {
        dsTaint.addTaint(alias);
        Certificate var822E8662CF8D6B764032630E1510FF28_366084315 = (getCertificate(alias, false));
        return (Certificate)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getCertificate(alias, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.429 -0400", hash_original_method = "5E5623CDAE6C2674E4A1581BA2487353", hash_generated_method = "8042A96C4ED9C43BD4712E58AE4F8EAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Certificate getCertificate(String alias, boolean includeDeletedSystem) {
        dsTaint.addTaint(alias);
        dsTaint.addTaint(includeDeletedSystem);
        File file;
        file = fileForAlias(alias);
        {
            boolean varE344C74735B7CC3DC71376D253A33A5F_732938276 = (file == null || (isUser(alias) && isTombstone(file)));
        } //End collapsed parenthetic
        X509Certificate cert;
        cert = readCertificate(file);
        {
            boolean varF2DC44D0887D5CC9BE357DDB61D1AB1B_1040518132 = (cert == null || (isSystem(alias)
                             && !includeDeletedSystem
                             && isDeletedSystemCertificate(cert)));
        } //End collapsed parenthetic
        return (Certificate)dsTaint.getTaint();
        // ---------- Original Method ----------
        //File file = fileForAlias(alias);
        //if (file == null || (isUser(alias) && isTombstone(file))) {
            //return null;
        //}
        //X509Certificate cert = readCertificate(file);
        //if (cert == null || (isSystem(alias)
                             //&& !includeDeletedSystem
                             //&& isDeletedSystemCertificate(cert))) {
            //return null;
        //}
        //return cert;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.429 -0400", hash_original_method = "BD13BF64CDF62ABC225832ACDAE55EEB", hash_generated_method = "7D427EED164A992A5EB78661F75DCB2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private File fileForAlias(String alias) {
        dsTaint.addTaint(alias);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("alias == null");
        } //End block
        File file;
        {
            boolean var53B4C983BD9390DF1FB50697984FC144_869060513 = (isSystem(alias));
            {
                file = new File(systemDir, alias.substring(PREFIX_SYSTEM.length()));
            } //End block
            {
                boolean var36B4A78E71DAB1C2DA5FE33DEA8BE7A8_1259505506 = (isUser(alias));
                {
                    file = new File(addedDir, alias.substring(PREFIX_USER.length()));
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean varE20C3232E101ED06745B5E2CA9261156_1416820714 = (!file.exists() || isTombstone(file));
        } //End collapsed parenthetic
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (alias == null) {
            //throw new NullPointerException("alias == null");
        //}
        //File file;
        //if (isSystem(alias)) {
            //file = new File(systemDir, alias.substring(PREFIX_SYSTEM.length()));
        //} else if (isUser(alias)) {
            //file = new File(addedDir, alias.substring(PREFIX_USER.length()));
        //} else {
            //return null;
        //}
        //if (!file.exists() || isTombstone(file)) {
            //return null;
        //}
        //return file;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.429 -0400", hash_original_method = "C0CC358A113978AA5962E41C2E3971C3", hash_generated_method = "C6B41CE4F9EEC06AB219066305CDE2DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isTombstone(File file) {
        dsTaint.addTaint(file.dsTaint);
        boolean var29DF545003AE6D867A95266D5E71AA15_813640213 = (file.length() == 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return file.length() == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.430 -0400", hash_original_method = "8510D8C420703F5BE76FCD04B0D510F3", hash_generated_method = "1A2436616EECE1A9BE67759A418468A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private X509Certificate readCertificate(File file) {
        dsTaint.addTaint(file.dsTaint);
        {
            boolean varCA1268C49E0B45CB9769ADFBFB3AB00B_677731088 = (!file.isFile());
        } //End collapsed parenthetic
        InputStream is;
        is = null;
        try 
        {
            is = new BufferedInputStream(new FileInputStream(file));
            X509Certificate varAA1C0A5EE7A66185F1D1A7A4218296DE_417515837 = ((X509Certificate) CERT_FACTORY.generateCertificate(is));
        } //End block
        catch (IOException e)
        { }
        catch (CertificateException e)
        { }
        finally 
        {
            IoUtils.closeQuietly(is);
        } //End block
        return (X509Certificate)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!file.isFile()) {
            //return null;
        //}
        //InputStream is = null;
        //try {
            //is = new BufferedInputStream(new FileInputStream(file));
            //return (X509Certificate) CERT_FACTORY.generateCertificate(is);
        //} catch (IOException e) {
            //return null;
        //} catch (CertificateException e) {
            //return null;
        //} finally {
            //IoUtils.closeQuietly(is);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.430 -0400", hash_original_method = "109D07F89CD9540F28E2544DA7036A76", hash_generated_method = "2324304C7E913F4980E874B788EFEC60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeCertificate(File file, X509Certificate cert) throws IOException, CertificateException {
        dsTaint.addTaint(cert.dsTaint);
        dsTaint.addTaint(file.dsTaint);
        File dir;
        dir = file.getParentFile();
        dir.mkdirs();
        dir.setReadable(true, false);
        dir.setExecutable(true, false);
        OutputStream os;
        os = null;
        try 
        {
            os = new FileOutputStream(file);
            os.write(cert.getEncoded());
        } //End block
        finally 
        {
            IoUtils.closeQuietly(os);
        } //End block
        file.setReadable(true, false);
        // ---------- Original Method ----------
        //File dir = file.getParentFile();
        //dir.mkdirs();
        //dir.setReadable(true, false);
        //dir.setExecutable(true, false);
        //OutputStream os = null;
        //try {
            //os = new FileOutputStream(file);
            //os.write(cert.getEncoded());
        //} finally {
            //IoUtils.closeQuietly(os);
        //}
        //file.setReadable(true, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.430 -0400", hash_original_method = "687C2EEF2D383D4BDFC0BC0824D70D25", hash_generated_method = "CA042EE6A40BF3FF48924F64F2B8FE19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isDeletedSystemCertificate(X509Certificate x) {
        dsTaint.addTaint(x.dsTaint);
        boolean var6AEE1EA832E3C3384F69B8A55E95DA2F_911143260 = (getCertificateFile(deletedDir, x).exists());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getCertificateFile(deletedDir, x).exists();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.431 -0400", hash_original_method = "CCEB88AE1C59EF9C3585E776EAD03DC2", hash_generated_method = "1C861313B27CD09915FB96C3BAE165D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Date getCreationDate(String alias) {
        dsTaint.addTaint(alias);
        {
            boolean varD7699316115EE37A278635B4FE2CBB22_1463332017 = (!containsAlias(alias));
        } //End collapsed parenthetic
        File file;
        file = fileForAlias(alias);
        long time;
        time = file.lastModified();
        Date varD2C39160CBFBACBD75BCB77EAC712309_456094068 = (new Date(time));
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!containsAlias(alias)) {
            //return null;
        //}
        //File file = fileForAlias(alias);
        //if (file == null) {
            //return null;
        //}
        //long time = file.lastModified();
        //if (time == 0) {
            //return null;
        //}
        //return new Date(time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.431 -0400", hash_original_method = "08CEADDFFE08C3DC9E367E6EE1C8514A", hash_generated_method = "C5A10135D6D7521B32797EBCF83A04B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<String> aliases() {
        Set<String> result;
        result = new HashSet<String>();
        addAliases(result, PREFIX_USER, addedDir);
        addAliases(result, PREFIX_SYSTEM, systemDir);
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Set<String> result = new HashSet<String>();
        //addAliases(result, PREFIX_USER, addedDir);
        //addAliases(result, PREFIX_SYSTEM, systemDir);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.431 -0400", hash_original_method = "47F99465DCD8C3DA2109E78A8164CD01", hash_generated_method = "85599F5E68324A79A98D921D2D0D02DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<String> userAliases() {
        Set<String> result;
        result = new HashSet<String>();
        addAliases(result, PREFIX_USER, addedDir);
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Set<String> result = new HashSet<String>();
        //addAliases(result, PREFIX_USER, addedDir);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.434 -0400", hash_original_method = "BF0B38E159AD70D54A581822F625340B", hash_generated_method = "219DC37379ADC2720F40EF5907AC41DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addAliases(Set<String> result, String prefix, File dir) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(dir.dsTaint);
        dsTaint.addTaint(prefix);
        String[] files;
        files = dir.list();
        {
            String filename = files[0];
            {
                String alias;
                alias = prefix + filename;
                {
                    boolean var18562CDE6243F73BC6E9E22B8903DE86_1543913922 = (containsAlias(alias));
                    {
                        result.add(alias);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //String[] files = dir.list();
        //if (files == null) {
            //return;
        //}
        //for (String filename : files) {
            //String alias = prefix + filename;
            //if (containsAlias(alias)) {
                //result.add(alias);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.438 -0400", hash_original_method = "43549AE16FD66ED845B02A525540D973", hash_generated_method = "0579D61AC1D754E5451F8BDF60769591")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<String> allSystemAliases() {
        Set<String> result;
        result = new HashSet<String>();
        String[] files;
        files = systemDir.list();
        {
            Iterator<String> var6C704332F65E4272E03A632BAF044C7C_2147462462 = (files).iterator();
            var6C704332F65E4272E03A632BAF044C7C_2147462462.hasNext();
            String filename = var6C704332F65E4272E03A632BAF044C7C_2147462462.next();
            {
                String alias;
                alias = PREFIX_SYSTEM + filename;
                {
                    boolean varF370E75B74913398C2AE6F378513631E_600387413 = (containsAlias(alias, true));
                    {
                        result.add(alias);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Set<String> result = new HashSet<String>();
        //String[] files = systemDir.list();
        //if (files == null) {
            //return result;
        //}
        //for (String filename : files) {
            //String alias = PREFIX_SYSTEM + filename;
            //if (containsAlias(alias, true)) {
                //result.add(alias);
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.438 -0400", hash_original_method = "654AA0CAB25ECF1B8F909EEC1B58BB82", hash_generated_method = "E5571875D3E5473EE21633B8DE9A51EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsAlias(String alias) {
        dsTaint.addTaint(alias);
        boolean varC75D0DA51608F39800D08908F1DAAE8B_1829513286 = (containsAlias(alias, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return containsAlias(alias, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.438 -0400", hash_original_method = "63CEC7C48C1DF35A32FA8773B953555D", hash_generated_method = "9600B493492F56B9632C5720A5F983D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean containsAlias(String alias, boolean includeDeletedSystem) {
        dsTaint.addTaint(alias);
        dsTaint.addTaint(includeDeletedSystem);
        boolean varC5B5B39B850EDCDB3B64E01437335F04_2010506284 = (getCertificate(alias, includeDeletedSystem) != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getCertificate(alias, includeDeletedSystem) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.439 -0400", hash_original_method = "2147628C71E1D1C09BD2609FCF8F152B", hash_generated_method = "8616108D28E42645F665677A52F5A419")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCertificateAlias(Certificate c) {
        dsTaint.addTaint(c.dsTaint);
        X509Certificate x;
        x = (X509Certificate) c;
        File user;
        user = getCertificateFile(addedDir, x);
        {
            boolean varE75B6A488F8E3E3F83A1FC6DB9D9A9B6_1292903998 = (user.exists());
            {
                String varC647681A8B82A2F76E8F0C150D249645_1121958760 = (PREFIX_USER + user.getName());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varEFC5F72B4979AAAC5675B73115144394_63240175 = (isDeletedSystemCertificate(x));
        } //End collapsed parenthetic
        File system;
        system = getCertificateFile(systemDir, x);
        {
            boolean varB8B8BC334D4A480600EAA0F38AED4F8E_1195487036 = (system.exists());
            {
                String varD12EDE3776D8050BA2AED8867735209E_1650359865 = (PREFIX_SYSTEM + system.getName());
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (c == null || !(c instanceof X509Certificate)) {
            //return null;
        //}
        //X509Certificate x = (X509Certificate) c;
        //File user = getCertificateFile(addedDir, x);
        //if (user.exists()) {
            //return PREFIX_USER + user.getName();
        //}
        //if (isDeletedSystemCertificate(x)) {
            //return null;
        //}
        //File system = getCertificateFile(systemDir, x);
        //if (system.exists()) {
            //return PREFIX_SYSTEM + system.getName();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.439 -0400", hash_original_method = "00D6A00D33EFE0DA025C348896CFB4AD", hash_generated_method = "B70DAC36F38A8CDD5565F8BCEA00FBFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private File getCertificateFile(File dir, final X509Certificate x) {
        dsTaint.addTaint(dir.dsTaint);
        dsTaint.addTaint(x.dsTaint);
        CertSelector selector;
        selector = new CertSelector() {
            @Override public boolean match(X509Certificate cert) {
                return cert.equals(x);
            }
        };
        File var2BC55F994E72E6DAD9BB0F0DCD27BE43_518788409 = (findCert(dir, x.getSubjectX500Principal(), selector, File.class));
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //CertSelector selector = new CertSelector() {
            //@Override public boolean match(X509Certificate cert) {
                //return cert.equals(x);
            //}
        //};
        //return findCert(dir, x.getSubjectX500Principal(), selector, File.class);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.439 -0400", hash_original_method = "48D05ED9669BF04FD3B698D9020EF167", hash_generated_method = "66830A4DAA47E87B588D089FA051674E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isTrustAnchor(final X509Certificate c) {
        dsTaint.addTaint(c.dsTaint);
        CertSelector selector;
        selector = new CertSelector() {
            @Override public boolean match(X509Certificate ca) {
                return ca.getPublicKey().equals(c.getPublicKey());
            }
        };
        boolean user;
        user = findCert(addedDir,
                                c.getSubjectX500Principal(),
                                selector,
                                Boolean.class);
        X509Certificate system;
        system = findCert(systemDir,
                                          c.getSubjectX500Principal(),
                                          selector,
                                          X509Certificate.class);
        boolean var9868A7B67BC17788CDCD940626CE6948_934225500 = (system != null && !isDeletedSystemCertificate(system));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //CertSelector selector = new CertSelector() {
            //@Override public boolean match(X509Certificate ca) {
                //return ca.getPublicKey().equals(c.getPublicKey());
            //}
        //};
        //boolean user = findCert(addedDir,
                                //c.getSubjectX500Principal(),
                                //selector,
                                //Boolean.class);
        //if (user) {
            //return true;
        //}
        //X509Certificate system = findCert(systemDir,
                                          //c.getSubjectX500Principal(),
                                          //selector,
                                          //X509Certificate.class);
        //return system != null && !isDeletedSystemCertificate(system);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.439 -0400", hash_original_method = "A6B2832B57E732FF74F3B8B62A574310", hash_generated_method = "BDFA5B859DCBB9065F2DD8CD3E191471")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X509Certificate findIssuer(final X509Certificate c) {
        dsTaint.addTaint(c.dsTaint);
        CertSelector selector;
        selector = new CertSelector() {
            @Override public boolean match(X509Certificate ca) {
                try {
                    c.verify(ca.getPublicKey());
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        };
        X500Principal issuer;
        issuer = c.getIssuerX500Principal();
        X509Certificate user;
        user = findCert(addedDir, issuer, selector, X509Certificate.class);
        X509Certificate system;
        system = findCert(systemDir, issuer, selector, X509Certificate.class);
        {
            boolean var4385465C532BEF048579840C6D64E763_1628255061 = (system != null && !isDeletedSystemCertificate(system));
        } //End collapsed parenthetic
        return (X509Certificate)dsTaint.getTaint();
        // ---------- Original Method ----------
        //CertSelector selector = new CertSelector() {
            //@Override public boolean match(X509Certificate ca) {
                //try {
                    //c.verify(ca.getPublicKey());
                    //return true;
                //} catch (Exception e) {
                    //return false;
                //}
            //}
        //};
        //X500Principal issuer = c.getIssuerX500Principal();
        //X509Certificate user = findCert(addedDir, issuer, selector, X509Certificate.class);
        //if (user != null) {
            //return user;
        //}
        //X509Certificate system = findCert(systemDir, issuer, selector, X509Certificate.class);
        //if (system != null && !isDeletedSystemCertificate(system)) {
            //return system;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.440 -0400", hash_original_method = "3F71F2007BD6B23A9969AFA8B1C7C7C7", hash_generated_method = "9DFCF6EDAC787EB7D544DE1B445E69F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private <T> T findCert(
            File dir, X500Principal subject, CertSelector selector, Class<T> desiredReturnType) {
        dsTaint.addTaint(selector.dsTaint);
        dsTaint.addTaint(dir.dsTaint);
        dsTaint.addTaint(desiredReturnType.dsTaint);
        dsTaint.addTaint(subject.dsTaint);
        String hash;
        hash = hash(subject);
        {
            int index;
            index = 0;
            {
                File file;
                file = file(dir, hash, index);
                {
                    boolean var8AC9B00B9B7DD7BFBB12D3F8559E7A47_1891577278 = (!file.isFile());
                } //End collapsed parenthetic
                {
                    boolean varF67109CDB547B366F4DE9C3FF0772143_1644553702 = (isTombstone(file));
                } //End collapsed parenthetic
                X509Certificate cert;
                cert = readCertificate(file);
                {
                    boolean var71B591D4067646AE567DD032AB8F9319_1451711469 = (selector.match(cert));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new AssertionError();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.440 -0400", hash_original_method = "90B2D041BE6875A6E09EF80BBE557D3F", hash_generated_method = "9A6DB7F807D508FD5D70E6EB75E84A5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String hash(X500Principal name) {
        dsTaint.addTaint(name.dsTaint);
        int hash;
        hash = NativeCrypto.X509_NAME_hash_old(name);
        String var952AD8E630E89B8ABE672DFC413F023F_1234937265 = (IntegralToString.intToHexString(hash, false, 8));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int hash = NativeCrypto.X509_NAME_hash_old(name);
        //return IntegralToString.intToHexString(hash, false, 8);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.440 -0400", hash_original_method = "0B663A316D5F1EC956CA42A84A17EC6A", hash_generated_method = "F33E4BC635E90533FBF5B217869EF36E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private File file(File dir, String hash, int index) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(hash);
        dsTaint.addTaint(dir.dsTaint);
        File var34DF93280B768562B1FB6022A8C16105_1153097790 = (new File(dir, hash + '.' + index));
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new File(dir, hash + '.' + index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.440 -0400", hash_original_method = "895D177FC3F042016815EFE0F89E89FF", hash_generated_method = "ED8AC7440FE546D8B890773767982F40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void installCertificate(X509Certificate cert) throws IOException, CertificateException {
        dsTaint.addTaint(cert.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("cert == null");
        } //End block
        File system;
        system = getCertificateFile(systemDir, cert);
        {
            boolean varB8B8BC334D4A480600EAA0F38AED4F8E_355550324 = (system.exists());
            {
                File deleted;
                deleted = getCertificateFile(deletedDir, cert);
                {
                    boolean var20CEF8B9D0B6E183B0ACAA82F50D7603_1277295010 = (deleted.exists());
                    {
                        {
                            boolean varE9DD250BABCA095684540839448B2F22_1340483522 = (!deleted.delete());
                            {
                                if (DroidSafeAndroidRuntime.control) throw new IOException("Could not remove " + deleted);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        File user;
        user = getCertificateFile(addedDir, cert);
        {
            boolean varE75B6A488F8E3E3F83A1FC6DB9D9A9B6_2091718081 = (user.exists());
        } //End collapsed parenthetic
        writeCertificate(user, cert);
        // ---------- Original Method ----------
        //if (cert == null) {
            //throw new NullPointerException("cert == null");
        //}
        //File system = getCertificateFile(systemDir, cert);
        //if (system.exists()) {
            //File deleted = getCertificateFile(deletedDir, cert);
            //if (deleted.exists()) {
                //if (!deleted.delete()) {
                    //throw new IOException("Could not remove " + deleted);
                //}
                //return;
            //}
            //return;
        //}
        //File user = getCertificateFile(addedDir, cert);
        //if (user.exists()) {
            //return;
        //}
        //writeCertificate(user, cert);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.441 -0400", hash_original_method = "7A4509C068B331E1E582C2216EB99D6E", hash_generated_method = "CB64E1C3E407489087B4267837B5E33D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void deleteCertificateEntry(String alias) throws IOException, CertificateException {
        dsTaint.addTaint(alias);
        File file;
        file = fileForAlias(alias);
        {
            boolean var53B4C983BD9390DF1FB50697984FC144_1943107306 = (isSystem(alias));
            {
                X509Certificate cert;
                cert = readCertificate(file);
                File deleted;
                deleted = getCertificateFile(deletedDir, cert);
                {
                    boolean var20CEF8B9D0B6E183B0ACAA82F50D7603_1112059751 = (deleted.exists());
                } //End collapsed parenthetic
                writeCertificate(deleted, cert);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var2E9D572D71A3969EE690A96A595CB2AC_431552795 = (isUser(alias));
            {
                new FileOutputStream(file).close();
                removeUnnecessaryTombstones(alias);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (alias == null) {
            //return;
        //}
        //File file = fileForAlias(alias);
        //if (file == null) {
            //return;
        //}
        //if (isSystem(alias)) {
            //X509Certificate cert = readCertificate(file);
            //if (cert == null) {
                //return;
            //}
            //File deleted = getCertificateFile(deletedDir, cert);
            //if (deleted.exists()) {
                //return;
            //}
            //writeCertificate(deleted, cert);
            //return;
        //}
        //if (isUser(alias)) {
            //new FileOutputStream(file).close();
            //removeUnnecessaryTombstones(alias);
            //return;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.441 -0400", hash_original_method = "728256A42E564BAD8F0CB50A75981023", hash_generated_method = "47B7BA3099A5B46BB214D36578CAC880")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeUnnecessaryTombstones(String alias) throws IOException {
        dsTaint.addTaint(alias);
        {
            boolean var96A7DA41EED586F0FEF8D46AE3E3C2F9_2120479649 = (!isUser(alias));
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError(alias);
            } //End block
        } //End collapsed parenthetic
        int dotIndex;
        dotIndex = alias.lastIndexOf('.');
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(alias);
        } //End block
        String hash;
        hash = alias.substring(PREFIX_USER.length(), dotIndex);
        int lastTombstoneIndex;
        lastTombstoneIndex = Integer.parseInt(alias.substring(dotIndex + 1));
        {
            boolean varF785876385AAADF9325BA4A1259E24B0_1512211287 = (file(addedDir, hash, lastTombstoneIndex + 1).exists());
        } //End collapsed parenthetic
        {
            File file;
            file = file(addedDir, hash, lastTombstoneIndex);
            {
                boolean var13673FEA2545D589986BFC9FE59C389E_805840206 = (!isTombstone(file));
            } //End collapsed parenthetic
            {
                boolean var8E645B401E2BCD688DAA316F70EFD21B_737293336 = (!file.delete());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Could not remove " + file);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (!isUser(alias)) {
            //throw new AssertionError(alias);
        //}
        //int dotIndex = alias.lastIndexOf('.');
        //if (dotIndex == -1) {
            //throw new AssertionError(alias);
        //}
        //String hash = alias.substring(PREFIX_USER.length(), dotIndex);
        //int lastTombstoneIndex = Integer.parseInt(alias.substring(dotIndex + 1));
        //if (file(addedDir, hash, lastTombstoneIndex + 1).exists()) {
            //return;
        //}
        //while (lastTombstoneIndex >= 0) {
            //File file = file(addedDir, hash, lastTombstoneIndex);
            //if (!isTombstone(file)) {
                //break;
            //}
            //if (!file.delete()) {
                //throw new IOException("Could not remove " + file);
            //}
            //lastTombstoneIndex--;
        //}
    }

    
    private static interface CertSelector {
        public boolean match(X509Certificate cert);
    }
    
    private static final String PREFIX_SYSTEM = "system:";
    private static final String PREFIX_USER = "user:";
    private static final File CA_CERTS_DIR_SYSTEM;
    private static final File CA_CERTS_DIR_ADDED;
    private static final File CA_CERTS_DIR_DELETED;
    private static final CertificateFactory CERT_FACTORY;
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

