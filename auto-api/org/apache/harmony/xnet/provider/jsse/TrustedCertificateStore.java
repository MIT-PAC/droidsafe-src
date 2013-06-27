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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.353 -0400", hash_original_field = "EA6CB6E8AA3DB1078A9395155B71EEC3", hash_generated_field = "1804575DE1991A78118271CC161871B9")

    private File systemDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.364 -0400", hash_original_field = "062C48004FC89A0941A11FBAE71E79E9", hash_generated_field = "309006457656B9EBA077D0AA58889218")

    private File addedDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.364 -0400", hash_original_field = "3517A8EAE9B16FDE0EB073810E20AF88", hash_generated_field = "61E19E5C5CD4CDE0E056E3DFED6783DE")

    private File deletedDir;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.365 -0400", hash_original_method = "2FF99D64326A5347B39C240182ABD235", hash_generated_method = "D7D90E22E15F31DCC7BD51E02E748945")
    public  TrustedCertificateStore() {
        this(CA_CERTS_DIR_SYSTEM, CA_CERTS_DIR_ADDED, CA_CERTS_DIR_DELETED);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.380 -0400", hash_original_method = "34C96A42FAFED1EA32C1B0CA7CD8DDF0", hash_generated_method = "7823F831586257EAA00813168C541C4A")
    public  TrustedCertificateStore(File systemDir, File addedDir, File deletedDir) {
        this.systemDir = systemDir;
        this.addedDir = addedDir;
        this.deletedDir = deletedDir;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.381 -0400", hash_original_method = "DCFF226F6C2C4D0E26660E34EC9EC374", hash_generated_method = "45C1B6AB7E1C21D038D6D174E0E94CAB")
    public Certificate getCertificate(String alias) {
        Certificate varB4EAC82CA7396A68D541C85D26508E83_1695815278 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1695815278 = getCertificate(alias, false);
        addTaint(alias.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1695815278.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1695815278;
        // ---------- Original Method ----------
        //return getCertificate(alias, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.386 -0400", hash_original_method = "5E5623CDAE6C2674E4A1581BA2487353", hash_generated_method = "1ECD64658F51D1709889325EBC9A3CEF")
    public Certificate getCertificate(String alias, boolean includeDeletedSystem) {
        Certificate varB4EAC82CA7396A68D541C85D26508E83_2015443113 = null; //Variable for return #1
        Certificate varB4EAC82CA7396A68D541C85D26508E83_482120595 = null; //Variable for return #2
        Certificate varB4EAC82CA7396A68D541C85D26508E83_435102559 = null; //Variable for return #3
        File file;
        file = fileForAlias(alias);
        {
            boolean varE344C74735B7CC3DC71376D253A33A5F_891635183 = (file == null || (isUser(alias) && isTombstone(file)));
            {
                varB4EAC82CA7396A68D541C85D26508E83_2015443113 = null;
            } //End block
        } //End collapsed parenthetic
        X509Certificate cert;
        cert = readCertificate(file);
        {
            boolean varF2DC44D0887D5CC9BE357DDB61D1AB1B_265881897 = (cert == null || (isSystem(alias)
                             && !includeDeletedSystem
                             && isDeletedSystemCertificate(cert)));
            {
                varB4EAC82CA7396A68D541C85D26508E83_482120595 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_435102559 = cert;
        addTaint(alias.getTaint());
        addTaint(includeDeletedSystem);
        Certificate varA7E53CE21691AB073D9660D615818899_1277652393; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1277652393 = varB4EAC82CA7396A68D541C85D26508E83_2015443113;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1277652393 = varB4EAC82CA7396A68D541C85D26508E83_482120595;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1277652393 = varB4EAC82CA7396A68D541C85D26508E83_435102559;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1277652393.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1277652393;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.401 -0400", hash_original_method = "BD13BF64CDF62ABC225832ACDAE55EEB", hash_generated_method = "65111BC30DC8AC17E09D5B42CA78B1D7")
    private File fileForAlias(String alias) {
        File varB4EAC82CA7396A68D541C85D26508E83_1441193301 = null; //Variable for return #1
        File varB4EAC82CA7396A68D541C85D26508E83_897786493 = null; //Variable for return #2
        File varB4EAC82CA7396A68D541C85D26508E83_713538357 = null; //Variable for return #3
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("alias == null");
        } //End block
        File file;
        {
            boolean var53B4C983BD9390DF1FB50697984FC144_1805912622 = (isSystem(alias));
            {
                file = new File(systemDir, alias.substring(PREFIX_SYSTEM.length()));
            } //End block
            {
                boolean var36B4A78E71DAB1C2DA5FE33DEA8BE7A8_1498083566 = (isUser(alias));
                {
                    file = new File(addedDir, alias.substring(PREFIX_USER.length()));
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1441193301 = null;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean varE20C3232E101ED06745B5E2CA9261156_637263132 = (!file.exists() || isTombstone(file));
            {
                varB4EAC82CA7396A68D541C85D26508E83_897786493 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_713538357 = file;
        addTaint(alias.getTaint());
        File varA7E53CE21691AB073D9660D615818899_1438617089; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1438617089 = varB4EAC82CA7396A68D541C85D26508E83_1441193301;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1438617089 = varB4EAC82CA7396A68D541C85D26508E83_897786493;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1438617089 = varB4EAC82CA7396A68D541C85D26508E83_713538357;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1438617089.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1438617089;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.402 -0400", hash_original_method = "C0CC358A113978AA5962E41C2E3971C3", hash_generated_method = "AE2244757C2E812F7FE924203C885DDA")
    private boolean isTombstone(File file) {
        boolean var29DF545003AE6D867A95266D5E71AA15_1318866575 = (file.length() == 0);
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_872164838 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_872164838;
        // ---------- Original Method ----------
        //return file.length() == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.402 -0400", hash_original_method = "8510D8C420703F5BE76FCD04B0D510F3", hash_generated_method = "C12AF1684466D299BDEA799F0A5FB661")
    private X509Certificate readCertificate(File file) {
        X509Certificate varB4EAC82CA7396A68D541C85D26508E83_1566222541 = null; //Variable for return #1
        X509Certificate varB4EAC82CA7396A68D541C85D26508E83_399882447 = null; //Variable for return #2
        X509Certificate varB4EAC82CA7396A68D541C85D26508E83_1007759826 = null; //Variable for return #3
        X509Certificate varB4EAC82CA7396A68D541C85D26508E83_1378821501 = null; //Variable for return #4
        {
            boolean varCA1268C49E0B45CB9769ADFBFB3AB00B_1200947027 = (!file.isFile());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1566222541 = null;
            } //End block
        } //End collapsed parenthetic
        InputStream is;
        is = null;
        try 
        {
            is = new BufferedInputStream(new FileInputStream(file));
            varB4EAC82CA7396A68D541C85D26508E83_399882447 = (X509Certificate) CERT_FACTORY.generateCertificate(is);
        } //End block
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1007759826 = null;
        } //End block
        catch (CertificateException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1378821501 = null;
        } //End block
        finally 
        {
            IoUtils.closeQuietly(is);
        } //End block
        addTaint(file.getTaint());
        X509Certificate varA7E53CE21691AB073D9660D615818899_1697192170; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1697192170 = varB4EAC82CA7396A68D541C85D26508E83_1566222541;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1697192170 = varB4EAC82CA7396A68D541C85D26508E83_399882447;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1697192170 = varB4EAC82CA7396A68D541C85D26508E83_1007759826;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1697192170 = varB4EAC82CA7396A68D541C85D26508E83_1378821501;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1697192170.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1697192170;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.404 -0400", hash_original_method = "109D07F89CD9540F28E2544DA7036A76", hash_generated_method = "3DEE3FC2C1561BC9612972C92C44091C")
    private void writeCertificate(File file, X509Certificate cert) throws IOException, CertificateException {
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
        addTaint(file.getTaint());
        addTaint(cert.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.404 -0400", hash_original_method = "687C2EEF2D383D4BDFC0BC0824D70D25", hash_generated_method = "4383945C6A804F1669D498F6C63B088B")
    private boolean isDeletedSystemCertificate(X509Certificate x) {
        boolean var6AEE1EA832E3C3384F69B8A55E95DA2F_1400087427 = (getCertificateFile(deletedDir, x).exists());
        addTaint(x.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_339152781 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_339152781;
        // ---------- Original Method ----------
        //return getCertificateFile(deletedDir, x).exists();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.408 -0400", hash_original_method = "CCEB88AE1C59EF9C3585E776EAD03DC2", hash_generated_method = "B13BEC47877FE04063089366315694DE")
    public Date getCreationDate(String alias) {
        Date varB4EAC82CA7396A68D541C85D26508E83_1264119039 = null; //Variable for return #1
        Date varB4EAC82CA7396A68D541C85D26508E83_118017598 = null; //Variable for return #2
        Date varB4EAC82CA7396A68D541C85D26508E83_1420080543 = null; //Variable for return #3
        Date varB4EAC82CA7396A68D541C85D26508E83_1997694731 = null; //Variable for return #4
        {
            boolean varD7699316115EE37A278635B4FE2CBB22_865930393 = (!containsAlias(alias));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1264119039 = null;
            } //End block
        } //End collapsed parenthetic
        File file;
        file = fileForAlias(alias);
        {
            varB4EAC82CA7396A68D541C85D26508E83_118017598 = null;
        } //End block
        long time;
        time = file.lastModified();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1420080543 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1997694731 = new Date(time);
        addTaint(alias.getTaint());
        Date varA7E53CE21691AB073D9660D615818899_775684653; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_775684653 = varB4EAC82CA7396A68D541C85D26508E83_1264119039;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_775684653 = varB4EAC82CA7396A68D541C85D26508E83_118017598;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_775684653 = varB4EAC82CA7396A68D541C85D26508E83_1420080543;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_775684653 = varB4EAC82CA7396A68D541C85D26508E83_1997694731;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_775684653.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_775684653;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.416 -0400", hash_original_method = "08CEADDFFE08C3DC9E367E6EE1C8514A", hash_generated_method = "A4A0419E97B9838CC1221DE63D7DD49A")
    public Set<String> aliases() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1703662227 = null; //Variable for return #1
        Set<String> result;
        result = new HashSet<String>();
        addAliases(result, PREFIX_USER, addedDir);
        addAliases(result, PREFIX_SYSTEM, systemDir);
        varB4EAC82CA7396A68D541C85D26508E83_1703662227 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1703662227.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1703662227;
        // ---------- Original Method ----------
        //Set<String> result = new HashSet<String>();
        //addAliases(result, PREFIX_USER, addedDir);
        //addAliases(result, PREFIX_SYSTEM, systemDir);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.417 -0400", hash_original_method = "47F99465DCD8C3DA2109E78A8164CD01", hash_generated_method = "CCC4521E5E5FCB72F90AE1BA5AD9D7CD")
    public Set<String> userAliases() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1877558108 = null; //Variable for return #1
        Set<String> result;
        result = new HashSet<String>();
        addAliases(result, PREFIX_USER, addedDir);
        varB4EAC82CA7396A68D541C85D26508E83_1877558108 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1877558108.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1877558108;
        // ---------- Original Method ----------
        //Set<String> result = new HashSet<String>();
        //addAliases(result, PREFIX_USER, addedDir);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.450 -0400", hash_original_method = "BF0B38E159AD70D54A581822F625340B", hash_generated_method = "1E6BABAFF62A2F2666A051DF749D06B1")
    private void addAliases(Set<String> result, String prefix, File dir) {
        String[] files;
        files = dir.list();
        {
            Iterator<String> var6C704332F65E4272E03A632BAF044C7C_1885046179 = (files).iterator();
            var6C704332F65E4272E03A632BAF044C7C_1885046179.hasNext();
            String filename = var6C704332F65E4272E03A632BAF044C7C_1885046179.next();
            {
                String alias;
                alias = prefix + filename;
                {
                    boolean var18562CDE6243F73BC6E9E22B8903DE86_2044958653 = (containsAlias(alias));
                    {
                        result.add(alias);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(result.getTaint());
        addTaint(prefix.getTaint());
        addTaint(dir.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.453 -0400", hash_original_method = "43549AE16FD66ED845B02A525540D973", hash_generated_method = "76D5A8DF28F7FDA3B94A327462AD60FC")
    public Set<String> allSystemAliases() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1879296336 = null; //Variable for return #1
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1142143018 = null; //Variable for return #2
        Set<String> result;
        result = new HashSet<String>();
        String[] files;
        files = systemDir.list();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1879296336 = result;
        } //End block
        {
            Iterator<String> var6C704332F65E4272E03A632BAF044C7C_1672042289 = (files).iterator();
            var6C704332F65E4272E03A632BAF044C7C_1672042289.hasNext();
            String filename = var6C704332F65E4272E03A632BAF044C7C_1672042289.next();
            {
                String alias;
                alias = PREFIX_SYSTEM + filename;
                {
                    boolean varF370E75B74913398C2AE6F378513631E_2046032202 = (containsAlias(alias, true));
                    {
                        result.add(alias);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1142143018 = result;
        Set<String> varA7E53CE21691AB073D9660D615818899_1788946053; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1788946053 = varB4EAC82CA7396A68D541C85D26508E83_1879296336;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1788946053 = varB4EAC82CA7396A68D541C85D26508E83_1142143018;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1788946053.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1788946053;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.469 -0400", hash_original_method = "654AA0CAB25ECF1B8F909EEC1B58BB82", hash_generated_method = "AAC21B0C0C42A7502E5544997D5F4FCF")
    public boolean containsAlias(String alias) {
        boolean varC75D0DA51608F39800D08908F1DAAE8B_2055091200 = (containsAlias(alias, false));
        addTaint(alias.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_902401592 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_902401592;
        // ---------- Original Method ----------
        //return containsAlias(alias, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.469 -0400", hash_original_method = "63CEC7C48C1DF35A32FA8773B953555D", hash_generated_method = "D24392B159E05DB272692238A29B807F")
    private boolean containsAlias(String alias, boolean includeDeletedSystem) {
        boolean varC5B5B39B850EDCDB3B64E01437335F04_547025716 = (getCertificate(alias, includeDeletedSystem) != null);
        addTaint(alias.getTaint());
        addTaint(includeDeletedSystem);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_848854742 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_848854742;
        // ---------- Original Method ----------
        //return getCertificate(alias, includeDeletedSystem) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.470 -0400", hash_original_method = "2147628C71E1D1C09BD2609FCF8F152B", hash_generated_method = "B28A92419B838129BFE5A5E6C5DA8C5A")
    public String getCertificateAlias(Certificate c) {
        String varB4EAC82CA7396A68D541C85D26508E83_769313263 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1003764825 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_397782356 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_972484466 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_575459092 = null; //Variable for return #5
        {
            varB4EAC82CA7396A68D541C85D26508E83_769313263 = null;
        } //End block
        X509Certificate x;
        x = (X509Certificate) c;
        File user;
        user = getCertificateFile(addedDir, x);
        {
            boolean varE75B6A488F8E3E3F83A1FC6DB9D9A9B6_643528101 = (user.exists());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1003764825 = PREFIX_USER + user.getName();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varEFC5F72B4979AAAC5675B73115144394_576935772 = (isDeletedSystemCertificate(x));
            {
                varB4EAC82CA7396A68D541C85D26508E83_397782356 = null;
            } //End block
        } //End collapsed parenthetic
        File system;
        system = getCertificateFile(systemDir, x);
        {
            boolean varB8B8BC334D4A480600EAA0F38AED4F8E_288818210 = (system.exists());
            {
                varB4EAC82CA7396A68D541C85D26508E83_972484466 = PREFIX_SYSTEM + system.getName();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_575459092 = null;
        addTaint(c.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1013537427; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1013537427 = varB4EAC82CA7396A68D541C85D26508E83_769313263;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1013537427 = varB4EAC82CA7396A68D541C85D26508E83_1003764825;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1013537427 = varB4EAC82CA7396A68D541C85D26508E83_397782356;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1013537427 = varB4EAC82CA7396A68D541C85D26508E83_972484466;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1013537427 = varB4EAC82CA7396A68D541C85D26508E83_575459092;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1013537427.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1013537427;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.474 -0400", hash_original_method = "00D6A00D33EFE0DA025C348896CFB4AD", hash_generated_method = "3E9A9DA1BC206D691084A4B777FD4CEE")
    private File getCertificateFile(File dir, final X509Certificate x) {
        File varB4EAC82CA7396A68D541C85D26508E83_1451112204 = null; //Variable for return #1
        CertSelector selector;
        selector = new CertSelector() {
            @Override public boolean match(X509Certificate cert) {
                return cert.equals(x);
            }
        };
        varB4EAC82CA7396A68D541C85D26508E83_1451112204 = findCert(dir, x.getSubjectX500Principal(), selector, File.class);
        addTaint(dir.getTaint());
        addTaint(x.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1451112204.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1451112204;
        // ---------- Original Method ----------
        //CertSelector selector = new CertSelector() {
            //@Override public boolean match(X509Certificate cert) {
                //return cert.equals(x);
            //}
        //};
        //return findCert(dir, x.getSubjectX500Principal(), selector, File.class);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.476 -0400", hash_original_method = "48D05ED9669BF04FD3B698D9020EF167", hash_generated_method = "81AE688DF4FA1AC650917CF8322383C5")
    public boolean isTrustAnchor(final X509Certificate c) {
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
        boolean var9868A7B67BC17788CDCD940626CE6948_252301648 = (system != null && !isDeletedSystemCertificate(system));
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591736087 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591736087;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.488 -0400", hash_original_method = "A6B2832B57E732FF74F3B8B62A574310", hash_generated_method = "B400BEC14832C54C311C8482DD54DBA9")
    public X509Certificate findIssuer(final X509Certificate c) {
        X509Certificate varB4EAC82CA7396A68D541C85D26508E83_1310236035 = null; //Variable for return #1
        X509Certificate varB4EAC82CA7396A68D541C85D26508E83_597769992 = null; //Variable for return #2
        X509Certificate varB4EAC82CA7396A68D541C85D26508E83_1798127408 = null; //Variable for return #3
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
        {
            varB4EAC82CA7396A68D541C85D26508E83_1310236035 = user;
        } //End block
        X509Certificate system;
        system = findCert(systemDir, issuer, selector, X509Certificate.class);
        {
            boolean var4385465C532BEF048579840C6D64E763_197318291 = (system != null && !isDeletedSystemCertificate(system));
            {
                varB4EAC82CA7396A68D541C85D26508E83_597769992 = system;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1798127408 = null;
        addTaint(c.getTaint());
        X509Certificate varA7E53CE21691AB073D9660D615818899_753553711; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_753553711 = varB4EAC82CA7396A68D541C85D26508E83_1310236035;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_753553711 = varB4EAC82CA7396A68D541C85D26508E83_597769992;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_753553711 = varB4EAC82CA7396A68D541C85D26508E83_1798127408;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_753553711.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_753553711;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.492 -0400", hash_original_method = "3F71F2007BD6B23A9969AFA8B1C7C7C7", hash_generated_method = "EFCD865324AC06CF7819E55879C25F8F")
    private <T> T findCert(
            File dir, X500Principal subject, CertSelector selector, Class<T> desiredReturnType) {
        T varB4EAC82CA7396A68D541C85D26508E83_1077022203 = null; //Variable for return #1
        T varB4EAC82CA7396A68D541C85D26508E83_1190029532 = null; //Variable for return #2
        T varB4EAC82CA7396A68D541C85D26508E83_2121456459 = null; //Variable for return #3
        T varB4EAC82CA7396A68D541C85D26508E83_1496837217 = null; //Variable for return #4
        T varB4EAC82CA7396A68D541C85D26508E83_1217307426 = null; //Variable for return #5
        T varB4EAC82CA7396A68D541C85D26508E83_550441757 = null; //Variable for return #6
        String hash;
        hash = hash(subject);
        {
            int index;
            index = 0;
            {
                File file;
                file = file(dir, hash, index);
                {
                    boolean var8AC9B00B9B7DD7BFBB12D3F8559E7A47_705072895 = (!file.isFile());
                    {
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1077022203 = (T) Boolean.FALSE;
                        } //End block
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1190029532 = (T) file;
                        } //End block
                        varB4EAC82CA7396A68D541C85D26508E83_2121456459 = null;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varF67109CDB547B366F4DE9C3FF0772143_426769288 = (isTombstone(file));
                } //End collapsed parenthetic
                X509Certificate cert;
                cert = readCertificate(file);
                {
                    boolean var71B591D4067646AE567DD032AB8F9319_644484339 = (selector.match(cert));
                    {
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1496837217 = (T) cert;
                        } //End block
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1217307426 = (T) Boolean.TRUE;
                        } //End block
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_550441757 = (T) file;
                        } //End block
                        if (DroidSafeAndroidRuntime.control) throw new AssertionError();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(dir.getTaint());
        addTaint(subject.getTaint());
        addTaint(selector.getTaint());
        addTaint(desiredReturnType.getTaint());
        T varA7E53CE21691AB073D9660D615818899_991479364; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_991479364 = varB4EAC82CA7396A68D541C85D26508E83_1077022203;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_991479364 = varB4EAC82CA7396A68D541C85D26508E83_1190029532;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_991479364 = varB4EAC82CA7396A68D541C85D26508E83_2121456459;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_991479364 = varB4EAC82CA7396A68D541C85D26508E83_1496837217;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_991479364 = varB4EAC82CA7396A68D541C85D26508E83_1217307426;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_991479364 = varB4EAC82CA7396A68D541C85D26508E83_550441757;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_991479364.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_991479364;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.492 -0400", hash_original_method = "90B2D041BE6875A6E09EF80BBE557D3F", hash_generated_method = "081238F22122049B21F2868C1FB3218A")
    private String hash(X500Principal name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1318366579 = null; //Variable for return #1
        int hash;
        hash = NativeCrypto.X509_NAME_hash_old(name);
        varB4EAC82CA7396A68D541C85D26508E83_1318366579 = IntegralToString.intToHexString(hash, false, 8);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1318366579.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1318366579;
        // ---------- Original Method ----------
        //int hash = NativeCrypto.X509_NAME_hash_old(name);
        //return IntegralToString.intToHexString(hash, false, 8);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.493 -0400", hash_original_method = "0B663A316D5F1EC956CA42A84A17EC6A", hash_generated_method = "9B967E8117CBCF17C43461DE8FA82E4D")
    private File file(File dir, String hash, int index) {
        File varB4EAC82CA7396A68D541C85D26508E83_1721681255 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1721681255 = new File(dir, hash + '.' + index);
        addTaint(dir.getTaint());
        addTaint(hash.getTaint());
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1721681255.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1721681255;
        // ---------- Original Method ----------
        //return new File(dir, hash + '.' + index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.493 -0400", hash_original_method = "895D177FC3F042016815EFE0F89E89FF", hash_generated_method = "F5AA47E5990290AC952FFA4C3EDD5A0B")
    public void installCertificate(X509Certificate cert) throws IOException, CertificateException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("cert == null");
        } //End block
        File system;
        system = getCertificateFile(systemDir, cert);
        {
            boolean varB8B8BC334D4A480600EAA0F38AED4F8E_289248356 = (system.exists());
            {
                File deleted;
                deleted = getCertificateFile(deletedDir, cert);
                {
                    boolean var20CEF8B9D0B6E183B0ACAA82F50D7603_887359933 = (deleted.exists());
                    {
                        {
                            boolean varE9DD250BABCA095684540839448B2F22_1156813964 = (!deleted.delete());
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
            boolean varE75B6A488F8E3E3F83A1FC6DB9D9A9B6_1257015806 = (user.exists());
        } //End collapsed parenthetic
        writeCertificate(user, cert);
        addTaint(cert.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.494 -0400", hash_original_method = "7A4509C068B331E1E582C2216EB99D6E", hash_generated_method = "560A69FAE238D699E1BD735EFD598D42")
    public void deleteCertificateEntry(String alias) throws IOException, CertificateException {
        File file;
        file = fileForAlias(alias);
        {
            boolean var53B4C983BD9390DF1FB50697984FC144_1630505358 = (isSystem(alias));
            {
                X509Certificate cert;
                cert = readCertificate(file);
                File deleted;
                deleted = getCertificateFile(deletedDir, cert);
                {
                    boolean var20CEF8B9D0B6E183B0ACAA82F50D7603_1025851475 = (deleted.exists());
                } //End collapsed parenthetic
                writeCertificate(deleted, cert);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var2E9D572D71A3969EE690A96A595CB2AC_991652755 = (isUser(alias));
            {
                new FileOutputStream(file).close();
                removeUnnecessaryTombstones(alias);
            } //End block
        } //End collapsed parenthetic
        addTaint(alias.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.505 -0400", hash_original_method = "728256A42E564BAD8F0CB50A75981023", hash_generated_method = "B38B86424C350354694C41BEC6C9FA47")
    private void removeUnnecessaryTombstones(String alias) throws IOException {
        {
            boolean var96A7DA41EED586F0FEF8D46AE3E3C2F9_1643894126 = (!isUser(alias));
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
            boolean varF785876385AAADF9325BA4A1259E24B0_1066636960 = (file(addedDir, hash, lastTombstoneIndex + 1).exists());
        } //End collapsed parenthetic
        {
            File file;
            file = file(addedDir, hash, lastTombstoneIndex);
            {
                boolean var13673FEA2545D589986BFC9FE59C389E_374244534 = (!isTombstone(file));
            } //End collapsed parenthetic
            {
                boolean var8E645B401E2BCD688DAA316F70EFD21B_1933699686 = (!file.delete());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Could not remove " + file);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(alias.getTaint());
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.505 -0400", hash_original_field = "F3DA322195F74C599019702368619A37", hash_generated_field = "0FF4E420E441ED07C8ACFF117E514B5D")

    private static String PREFIX_SYSTEM = "system:";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.505 -0400", hash_original_field = "F37C1708F7515416271B9D08F734CB81", hash_generated_field = "A362F57320C07CE5AAC629204A43384D")

    private static String PREFIX_USER = "user:";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.505 -0400", hash_original_field = "D0F09AFF7CD6199AEC61BA10225D3883", hash_generated_field = "FC1AC5B6AA36D7E7E6ACAACF0F236293")

    private static File CA_CERTS_DIR_SYSTEM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.505 -0400", hash_original_field = "21FC5FD3F6816142A976DCC0421E09CF", hash_generated_field = "0B21C402CC49FA93FF2ACC6C155EF2F1")

    private static File CA_CERTS_DIR_ADDED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.505 -0400", hash_original_field = "5D694C3AEF4BA343CF62C23AFD1AE62D", hash_generated_field = "CD17C03FD55940BDD7E8C3B35E42402F")

    private static File CA_CERTS_DIR_DELETED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.505 -0400", hash_original_field = "77A1E099CD5A94A27C8AC19EC52F3D2B", hash_generated_field = "73AFD3573A389E9D3C4778BF352F4917")

    private static CertificateFactory CERT_FACTORY;
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

