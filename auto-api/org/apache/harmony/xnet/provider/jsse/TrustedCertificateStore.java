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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.310 -0400", hash_original_field = "EA6CB6E8AA3DB1078A9395155B71EEC3", hash_generated_field = "1804575DE1991A78118271CC161871B9")

    private File systemDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.310 -0400", hash_original_field = "062C48004FC89A0941A11FBAE71E79E9", hash_generated_field = "309006457656B9EBA077D0AA58889218")

    private File addedDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.311 -0400", hash_original_field = "3517A8EAE9B16FDE0EB073810E20AF88", hash_generated_field = "61E19E5C5CD4CDE0E056E3DFED6783DE")

    private File deletedDir;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.323 -0400", hash_original_method = "2FF99D64326A5347B39C240182ABD235", hash_generated_method = "D7D90E22E15F31DCC7BD51E02E748945")
    public  TrustedCertificateStore() {
        this(CA_CERTS_DIR_SYSTEM, CA_CERTS_DIR_ADDED, CA_CERTS_DIR_DELETED);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.324 -0400", hash_original_method = "34C96A42FAFED1EA32C1B0CA7CD8DDF0", hash_generated_method = "7823F831586257EAA00813168C541C4A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.325 -0400", hash_original_method = "DCFF226F6C2C4D0E26660E34EC9EC374", hash_generated_method = "0DF5C66B652E7DDEB85E765DCE5741E6")
    public Certificate getCertificate(String alias) {
        Certificate varB4EAC82CA7396A68D541C85D26508E83_1024503578 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1024503578 = getCertificate(alias, false);
        addTaint(alias.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1024503578.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1024503578;
        // ---------- Original Method ----------
        //return getCertificate(alias, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.326 -0400", hash_original_method = "5E5623CDAE6C2674E4A1581BA2487353", hash_generated_method = "D374499FCA57901812836BFC2C379D5D")
    public Certificate getCertificate(String alias, boolean includeDeletedSystem) {
        Certificate varB4EAC82CA7396A68D541C85D26508E83_830456126 = null; //Variable for return #1
        Certificate varB4EAC82CA7396A68D541C85D26508E83_338539269 = null; //Variable for return #2
        Certificate varB4EAC82CA7396A68D541C85D26508E83_796373195 = null; //Variable for return #3
        File file;
        file = fileForAlias(alias);
        {
            boolean varE344C74735B7CC3DC71376D253A33A5F_772948844 = (file == null || (isUser(alias) && isTombstone(file)));
            {
                varB4EAC82CA7396A68D541C85D26508E83_830456126 = null;
            } //End block
        } //End collapsed parenthetic
        X509Certificate cert;
        cert = readCertificate(file);
        {
            boolean varF2DC44D0887D5CC9BE357DDB61D1AB1B_1362129544 = (cert == null || (isSystem(alias)
                             && !includeDeletedSystem
                             && isDeletedSystemCertificate(cert)));
            {
                varB4EAC82CA7396A68D541C85D26508E83_338539269 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_796373195 = cert;
        addTaint(alias.getTaint());
        addTaint(includeDeletedSystem);
        Certificate varA7E53CE21691AB073D9660D615818899_507629472; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_507629472 = varB4EAC82CA7396A68D541C85D26508E83_830456126;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_507629472 = varB4EAC82CA7396A68D541C85D26508E83_338539269;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_507629472 = varB4EAC82CA7396A68D541C85D26508E83_796373195;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_507629472.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_507629472;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.327 -0400", hash_original_method = "BD13BF64CDF62ABC225832ACDAE55EEB", hash_generated_method = "BDF9818CC8A36A21FC313905F0CE2E09")
    private File fileForAlias(String alias) {
        File varB4EAC82CA7396A68D541C85D26508E83_895734767 = null; //Variable for return #1
        File varB4EAC82CA7396A68D541C85D26508E83_1861387030 = null; //Variable for return #2
        File varB4EAC82CA7396A68D541C85D26508E83_739834614 = null; //Variable for return #3
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("alias == null");
        } //End block
        File file;
        {
            boolean var53B4C983BD9390DF1FB50697984FC144_138612349 = (isSystem(alias));
            {
                file = new File(systemDir, alias.substring(PREFIX_SYSTEM.length()));
            } //End block
            {
                boolean var36B4A78E71DAB1C2DA5FE33DEA8BE7A8_1150391018 = (isUser(alias));
                {
                    file = new File(addedDir, alias.substring(PREFIX_USER.length()));
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_895734767 = null;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean varE20C3232E101ED06745B5E2CA9261156_498306311 = (!file.exists() || isTombstone(file));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1861387030 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_739834614 = file;
        addTaint(alias.getTaint());
        File varA7E53CE21691AB073D9660D615818899_37210775; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_37210775 = varB4EAC82CA7396A68D541C85D26508E83_895734767;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_37210775 = varB4EAC82CA7396A68D541C85D26508E83_1861387030;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_37210775 = varB4EAC82CA7396A68D541C85D26508E83_739834614;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_37210775.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_37210775;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.327 -0400", hash_original_method = "C0CC358A113978AA5962E41C2E3971C3", hash_generated_method = "048EC297C0A3797AF7689510184BB7B1")
    private boolean isTombstone(File file) {
        boolean var29DF545003AE6D867A95266D5E71AA15_2142899995 = (file.length() == 0);
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1191387506 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1191387506;
        // ---------- Original Method ----------
        //return file.length() == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.338 -0400", hash_original_method = "8510D8C420703F5BE76FCD04B0D510F3", hash_generated_method = "005BD134E8F600075B6DF68D98E50C66")
    private X509Certificate readCertificate(File file) {
        X509Certificate varB4EAC82CA7396A68D541C85D26508E83_917313048 = null; //Variable for return #1
        X509Certificate varB4EAC82CA7396A68D541C85D26508E83_1361642086 = null; //Variable for return #2
        X509Certificate varB4EAC82CA7396A68D541C85D26508E83_1650916340 = null; //Variable for return #3
        X509Certificate varB4EAC82CA7396A68D541C85D26508E83_1182514687 = null; //Variable for return #4
        {
            boolean varCA1268C49E0B45CB9769ADFBFB3AB00B_592488710 = (!file.isFile());
            {
                varB4EAC82CA7396A68D541C85D26508E83_917313048 = null;
            } //End block
        } //End collapsed parenthetic
        InputStream is;
        is = null;
        try 
        {
            is = new BufferedInputStream(new FileInputStream(file));
            varB4EAC82CA7396A68D541C85D26508E83_1361642086 = (X509Certificate) CERT_FACTORY.generateCertificate(is);
        } //End block
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1650916340 = null;
        } //End block
        catch (CertificateException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1182514687 = null;
        } //End block
        finally 
        {
            IoUtils.closeQuietly(is);
        } //End block
        addTaint(file.getTaint());
        X509Certificate varA7E53CE21691AB073D9660D615818899_1903034180; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1903034180 = varB4EAC82CA7396A68D541C85D26508E83_917313048;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1903034180 = varB4EAC82CA7396A68D541C85D26508E83_1361642086;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1903034180 = varB4EAC82CA7396A68D541C85D26508E83_1650916340;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1903034180 = varB4EAC82CA7396A68D541C85D26508E83_1182514687;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1903034180.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1903034180;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.339 -0400", hash_original_method = "109D07F89CD9540F28E2544DA7036A76", hash_generated_method = "3DEE3FC2C1561BC9612972C92C44091C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.343 -0400", hash_original_method = "687C2EEF2D383D4BDFC0BC0824D70D25", hash_generated_method = "3C8FE7D16CF66E383E357650CD4A74B8")
    private boolean isDeletedSystemCertificate(X509Certificate x) {
        boolean var6AEE1EA832E3C3384F69B8A55E95DA2F_845140847 = (getCertificateFile(deletedDir, x).exists());
        addTaint(x.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1316400964 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1316400964;
        // ---------- Original Method ----------
        //return getCertificateFile(deletedDir, x).exists();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.351 -0400", hash_original_method = "CCEB88AE1C59EF9C3585E776EAD03DC2", hash_generated_method = "C27EA4B1C7E54AC3E8C3BC55C350660F")
    public Date getCreationDate(String alias) {
        Date varB4EAC82CA7396A68D541C85D26508E83_970074012 = null; //Variable for return #1
        Date varB4EAC82CA7396A68D541C85D26508E83_1676601161 = null; //Variable for return #2
        Date varB4EAC82CA7396A68D541C85D26508E83_122280626 = null; //Variable for return #3
        Date varB4EAC82CA7396A68D541C85D26508E83_2047634317 = null; //Variable for return #4
        {
            boolean varD7699316115EE37A278635B4FE2CBB22_109037612 = (!containsAlias(alias));
            {
                varB4EAC82CA7396A68D541C85D26508E83_970074012 = null;
            } //End block
        } //End collapsed parenthetic
        File file;
        file = fileForAlias(alias);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1676601161 = null;
        } //End block
        long time;
        time = file.lastModified();
        {
            varB4EAC82CA7396A68D541C85D26508E83_122280626 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2047634317 = new Date(time);
        addTaint(alias.getTaint());
        Date varA7E53CE21691AB073D9660D615818899_983371620; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_983371620 = varB4EAC82CA7396A68D541C85D26508E83_970074012;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_983371620 = varB4EAC82CA7396A68D541C85D26508E83_1676601161;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_983371620 = varB4EAC82CA7396A68D541C85D26508E83_122280626;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_983371620 = varB4EAC82CA7396A68D541C85D26508E83_2047634317;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_983371620.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_983371620;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.351 -0400", hash_original_method = "08CEADDFFE08C3DC9E367E6EE1C8514A", hash_generated_method = "99524D65DA98B9EF310B6DDA2F418F8E")
    public Set<String> aliases() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1041887777 = null; //Variable for return #1
        Set<String> result;
        result = new HashSet<String>();
        addAliases(result, PREFIX_USER, addedDir);
        addAliases(result, PREFIX_SYSTEM, systemDir);
        varB4EAC82CA7396A68D541C85D26508E83_1041887777 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1041887777.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1041887777;
        // ---------- Original Method ----------
        //Set<String> result = new HashSet<String>();
        //addAliases(result, PREFIX_USER, addedDir);
        //addAliases(result, PREFIX_SYSTEM, systemDir);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.362 -0400", hash_original_method = "47F99465DCD8C3DA2109E78A8164CD01", hash_generated_method = "164CE4FE18124198AD5DE897C89042F9")
    public Set<String> userAliases() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1147115451 = null; //Variable for return #1
        Set<String> result;
        result = new HashSet<String>();
        addAliases(result, PREFIX_USER, addedDir);
        varB4EAC82CA7396A68D541C85D26508E83_1147115451 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1147115451.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1147115451;
        // ---------- Original Method ----------
        //Set<String> result = new HashSet<String>();
        //addAliases(result, PREFIX_USER, addedDir);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.392 -0400", hash_original_method = "BF0B38E159AD70D54A581822F625340B", hash_generated_method = "BA951F7E4BA0A63F24386AEA6AD10A60")
    private void addAliases(Set<String> result, String prefix, File dir) {
        String[] files;
        files = dir.list();
        {
            Iterator<String> var6C704332F65E4272E03A632BAF044C7C_843360716 = (files).iterator();
            var6C704332F65E4272E03A632BAF044C7C_843360716.hasNext();
            String filename = var6C704332F65E4272E03A632BAF044C7C_843360716.next();
            {
                String alias;
                alias = prefix + filename;
                {
                    boolean var18562CDE6243F73BC6E9E22B8903DE86_1808311967 = (containsAlias(alias));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.396 -0400", hash_original_method = "43549AE16FD66ED845B02A525540D973", hash_generated_method = "33A7E3F9C01CBD17125ACBE97F787868")
    public Set<String> allSystemAliases() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_2008597067 = null; //Variable for return #1
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1420229428 = null; //Variable for return #2
        Set<String> result;
        result = new HashSet<String>();
        String[] files;
        files = systemDir.list();
        {
            varB4EAC82CA7396A68D541C85D26508E83_2008597067 = result;
        } //End block
        {
            Iterator<String> var6C704332F65E4272E03A632BAF044C7C_1421784244 = (files).iterator();
            var6C704332F65E4272E03A632BAF044C7C_1421784244.hasNext();
            String filename = var6C704332F65E4272E03A632BAF044C7C_1421784244.next();
            {
                String alias;
                alias = PREFIX_SYSTEM + filename;
                {
                    boolean varF370E75B74913398C2AE6F378513631E_179625674 = (containsAlias(alias, true));
                    {
                        result.add(alias);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1420229428 = result;
        Set<String> varA7E53CE21691AB073D9660D615818899_737676955; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_737676955 = varB4EAC82CA7396A68D541C85D26508E83_2008597067;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_737676955 = varB4EAC82CA7396A68D541C85D26508E83_1420229428;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_737676955.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_737676955;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.414 -0400", hash_original_method = "654AA0CAB25ECF1B8F909EEC1B58BB82", hash_generated_method = "97ED2ADDC189B599C80C6F552E23235C")
    public boolean containsAlias(String alias) {
        boolean varC75D0DA51608F39800D08908F1DAAE8B_263602439 = (containsAlias(alias, false));
        addTaint(alias.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1457573982 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1457573982;
        // ---------- Original Method ----------
        //return containsAlias(alias, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.415 -0400", hash_original_method = "63CEC7C48C1DF35A32FA8773B953555D", hash_generated_method = "BD6056E678B665F0DCF560710B776EA8")
    private boolean containsAlias(String alias, boolean includeDeletedSystem) {
        boolean varC5B5B39B850EDCDB3B64E01437335F04_673032243 = (getCertificate(alias, includeDeletedSystem) != null);
        addTaint(alias.getTaint());
        addTaint(includeDeletedSystem);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2120654763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2120654763;
        // ---------- Original Method ----------
        //return getCertificate(alias, includeDeletedSystem) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.416 -0400", hash_original_method = "2147628C71E1D1C09BD2609FCF8F152B", hash_generated_method = "84BE4EFE8613B28DCFA1469C7C92896D")
    public String getCertificateAlias(Certificate c) {
        String varB4EAC82CA7396A68D541C85D26508E83_501765605 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1440230692 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1591906172 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_833670099 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_814056962 = null; //Variable for return #5
        {
            varB4EAC82CA7396A68D541C85D26508E83_501765605 = null;
        } //End block
        X509Certificate x;
        x = (X509Certificate) c;
        File user;
        user = getCertificateFile(addedDir, x);
        {
            boolean varE75B6A488F8E3E3F83A1FC6DB9D9A9B6_801958375 = (user.exists());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1440230692 = PREFIX_USER + user.getName();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varEFC5F72B4979AAAC5675B73115144394_1943104774 = (isDeletedSystemCertificate(x));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1591906172 = null;
            } //End block
        } //End collapsed parenthetic
        File system;
        system = getCertificateFile(systemDir, x);
        {
            boolean varB8B8BC334D4A480600EAA0F38AED4F8E_2125163397 = (system.exists());
            {
                varB4EAC82CA7396A68D541C85D26508E83_833670099 = PREFIX_SYSTEM + system.getName();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_814056962 = null;
        addTaint(c.getTaint());
        String varA7E53CE21691AB073D9660D615818899_2020030635; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2020030635 = varB4EAC82CA7396A68D541C85D26508E83_501765605;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2020030635 = varB4EAC82CA7396A68D541C85D26508E83_1440230692;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2020030635 = varB4EAC82CA7396A68D541C85D26508E83_1591906172;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_2020030635 = varB4EAC82CA7396A68D541C85D26508E83_833670099;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2020030635 = varB4EAC82CA7396A68D541C85D26508E83_814056962;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2020030635.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2020030635;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.416 -0400", hash_original_method = "00D6A00D33EFE0DA025C348896CFB4AD", hash_generated_method = "A8D80678F23D0A8C5F0A68662E8CA618")
    private File getCertificateFile(File dir, final X509Certificate x) {
        File varB4EAC82CA7396A68D541C85D26508E83_1984233831 = null; //Variable for return #1
        CertSelector selector;
        selector = new CertSelector() {
            @Override public boolean match(X509Certificate cert) {
                return cert.equals(x);
            }
        };
        varB4EAC82CA7396A68D541C85D26508E83_1984233831 = findCert(dir, x.getSubjectX500Principal(), selector, File.class);
        addTaint(dir.getTaint());
        addTaint(x.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1984233831.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1984233831;
        // ---------- Original Method ----------
        //CertSelector selector = new CertSelector() {
            //@Override public boolean match(X509Certificate cert) {
                //return cert.equals(x);
            //}
        //};
        //return findCert(dir, x.getSubjectX500Principal(), selector, File.class);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.417 -0400", hash_original_method = "48D05ED9669BF04FD3B698D9020EF167", hash_generated_method = "578536DE53E669CA7A6038B59B57A346")
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
        boolean var9868A7B67BC17788CDCD940626CE6948_1586498012 = (system != null && !isDeletedSystemCertificate(system));
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_853002723 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_853002723;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.417 -0400", hash_original_method = "A6B2832B57E732FF74F3B8B62A574310", hash_generated_method = "DF3145384F75EBAFB51FA5CE5E0E871F")
    public X509Certificate findIssuer(final X509Certificate c) {
        X509Certificate varB4EAC82CA7396A68D541C85D26508E83_1450102015 = null; //Variable for return #1
        X509Certificate varB4EAC82CA7396A68D541C85D26508E83_673254185 = null; //Variable for return #2
        X509Certificate varB4EAC82CA7396A68D541C85D26508E83_1801002141 = null; //Variable for return #3
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
            varB4EAC82CA7396A68D541C85D26508E83_1450102015 = user;
        } //End block
        X509Certificate system;
        system = findCert(systemDir, issuer, selector, X509Certificate.class);
        {
            boolean var4385465C532BEF048579840C6D64E763_1669811853 = (system != null && !isDeletedSystemCertificate(system));
            {
                varB4EAC82CA7396A68D541C85D26508E83_673254185 = system;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1801002141 = null;
        addTaint(c.getTaint());
        X509Certificate varA7E53CE21691AB073D9660D615818899_1227691820; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1227691820 = varB4EAC82CA7396A68D541C85D26508E83_1450102015;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1227691820 = varB4EAC82CA7396A68D541C85D26508E83_673254185;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1227691820 = varB4EAC82CA7396A68D541C85D26508E83_1801002141;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1227691820.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1227691820;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.437 -0400", hash_original_method = "3F71F2007BD6B23A9969AFA8B1C7C7C7", hash_generated_method = "F313F83AAF3906D9717A845608AC06C7")
    private <T> T findCert(
            File dir, X500Principal subject, CertSelector selector, Class<T> desiredReturnType) {
        T varB4EAC82CA7396A68D541C85D26508E83_458704566 = null; //Variable for return #1
        T varB4EAC82CA7396A68D541C85D26508E83_2114919189 = null; //Variable for return #2
        T varB4EAC82CA7396A68D541C85D26508E83_1918725363 = null; //Variable for return #3
        T varB4EAC82CA7396A68D541C85D26508E83_304171005 = null; //Variable for return #4
        T varB4EAC82CA7396A68D541C85D26508E83_934570543 = null; //Variable for return #5
        T varB4EAC82CA7396A68D541C85D26508E83_1773385627 = null; //Variable for return #6
        String hash;
        hash = hash(subject);
        {
            int index;
            index = 0;
            {
                File file;
                file = file(dir, hash, index);
                {
                    boolean var8AC9B00B9B7DD7BFBB12D3F8559E7A47_194564649 = (!file.isFile());
                    {
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_458704566 = (T) Boolean.FALSE;
                        } //End block
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_2114919189 = (T) file;
                        } //End block
                        varB4EAC82CA7396A68D541C85D26508E83_1918725363 = null;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varF67109CDB547B366F4DE9C3FF0772143_1565844678 = (isTombstone(file));
                } //End collapsed parenthetic
                X509Certificate cert;
                cert = readCertificate(file);
                {
                    boolean var71B591D4067646AE567DD032AB8F9319_1790783948 = (selector.match(cert));
                    {
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_304171005 = (T) cert;
                        } //End block
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_934570543 = (T) Boolean.TRUE;
                        } //End block
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1773385627 = (T) file;
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
        T varA7E53CE21691AB073D9660D615818899_1430652790; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1430652790 = varB4EAC82CA7396A68D541C85D26508E83_458704566;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1430652790 = varB4EAC82CA7396A68D541C85D26508E83_2114919189;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1430652790 = varB4EAC82CA7396A68D541C85D26508E83_1918725363;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1430652790 = varB4EAC82CA7396A68D541C85D26508E83_304171005;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1430652790 = varB4EAC82CA7396A68D541C85D26508E83_934570543;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1430652790 = varB4EAC82CA7396A68D541C85D26508E83_1773385627;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1430652790.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1430652790;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.438 -0400", hash_original_method = "90B2D041BE6875A6E09EF80BBE557D3F", hash_generated_method = "386B634CA3CD6B25FB91F68C085733F4")
    private String hash(X500Principal name) {
        String varB4EAC82CA7396A68D541C85D26508E83_265741270 = null; //Variable for return #1
        int hash;
        hash = NativeCrypto.X509_NAME_hash_old(name);
        varB4EAC82CA7396A68D541C85D26508E83_265741270 = IntegralToString.intToHexString(hash, false, 8);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_265741270.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_265741270;
        // ---------- Original Method ----------
        //int hash = NativeCrypto.X509_NAME_hash_old(name);
        //return IntegralToString.intToHexString(hash, false, 8);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.439 -0400", hash_original_method = "0B663A316D5F1EC956CA42A84A17EC6A", hash_generated_method = "C677781B292486830F538DB6C6E02CBE")
    private File file(File dir, String hash, int index) {
        File varB4EAC82CA7396A68D541C85D26508E83_897628696 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_897628696 = new File(dir, hash + '.' + index);
        addTaint(dir.getTaint());
        addTaint(hash.getTaint());
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_897628696.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_897628696;
        // ---------- Original Method ----------
        //return new File(dir, hash + '.' + index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.443 -0400", hash_original_method = "895D177FC3F042016815EFE0F89E89FF", hash_generated_method = "30A38E13CC52A0B2173332FEF64F1B32")
    public void installCertificate(X509Certificate cert) throws IOException, CertificateException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("cert == null");
        } //End block
        File system;
        system = getCertificateFile(systemDir, cert);
        {
            boolean varB8B8BC334D4A480600EAA0F38AED4F8E_1986712472 = (system.exists());
            {
                File deleted;
                deleted = getCertificateFile(deletedDir, cert);
                {
                    boolean var20CEF8B9D0B6E183B0ACAA82F50D7603_1853651288 = (deleted.exists());
                    {
                        {
                            boolean varE9DD250BABCA095684540839448B2F22_917291098 = (!deleted.delete());
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
            boolean varE75B6A488F8E3E3F83A1FC6DB9D9A9B6_1466420399 = (user.exists());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.444 -0400", hash_original_method = "7A4509C068B331E1E582C2216EB99D6E", hash_generated_method = "4DB751089350EAC9F7771AA360D87609")
    public void deleteCertificateEntry(String alias) throws IOException, CertificateException {
        File file;
        file = fileForAlias(alias);
        {
            boolean var53B4C983BD9390DF1FB50697984FC144_528667315 = (isSystem(alias));
            {
                X509Certificate cert;
                cert = readCertificate(file);
                File deleted;
                deleted = getCertificateFile(deletedDir, cert);
                {
                    boolean var20CEF8B9D0B6E183B0ACAA82F50D7603_1352648319 = (deleted.exists());
                } //End collapsed parenthetic
                writeCertificate(deleted, cert);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var2E9D572D71A3969EE690A96A595CB2AC_476637329 = (isUser(alias));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.445 -0400", hash_original_method = "728256A42E564BAD8F0CB50A75981023", hash_generated_method = "798539CD411D4D09BA4188A8BE5237ED")
    private void removeUnnecessaryTombstones(String alias) throws IOException {
        {
            boolean var96A7DA41EED586F0FEF8D46AE3E3C2F9_1429208591 = (!isUser(alias));
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
            boolean varF785876385AAADF9325BA4A1259E24B0_346792321 = (file(addedDir, hash, lastTombstoneIndex + 1).exists());
        } //End collapsed parenthetic
        {
            File file;
            file = file(addedDir, hash, lastTombstoneIndex);
            {
                boolean var13673FEA2545D589986BFC9FE59C389E_325490665 = (!isTombstone(file));
            } //End collapsed parenthetic
            {
                boolean var8E645B401E2BCD688DAA316F70EFD21B_271331137 = (!file.delete());
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.445 -0400", hash_original_field = "F3DA322195F74C599019702368619A37", hash_generated_field = "0FF4E420E441ED07C8ACFF117E514B5D")

    private static String PREFIX_SYSTEM = "system:";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.445 -0400", hash_original_field = "F37C1708F7515416271B9D08F734CB81", hash_generated_field = "A362F57320C07CE5AAC629204A43384D")

    private static String PREFIX_USER = "user:";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.445 -0400", hash_original_field = "D0F09AFF7CD6199AEC61BA10225D3883", hash_generated_field = "FC1AC5B6AA36D7E7E6ACAACF0F236293")

    private static File CA_CERTS_DIR_SYSTEM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.445 -0400", hash_original_field = "21FC5FD3F6816142A976DCC0421E09CF", hash_generated_field = "0B21C402CC49FA93FF2ACC6C155EF2F1")

    private static File CA_CERTS_DIR_ADDED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.445 -0400", hash_original_field = "5D694C3AEF4BA343CF62C23AFD1AE62D", hash_generated_field = "CD17C03FD55940BDD7E8C3B35E42402F")

    private static File CA_CERTS_DIR_DELETED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.445 -0400", hash_original_field = "77A1E099CD5A94A27C8AC19EC52F3D2B", hash_generated_field = "73AFD3573A389E9D3C4778BF352F4917")

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

