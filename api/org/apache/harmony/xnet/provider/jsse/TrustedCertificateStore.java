package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.041 -0400", hash_original_field = "EA6CB6E8AA3DB1078A9395155B71EEC3", hash_generated_field = "1804575DE1991A78118271CC161871B9")

    private File systemDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.041 -0400", hash_original_field = "062C48004FC89A0941A11FBAE71E79E9", hash_generated_field = "309006457656B9EBA077D0AA58889218")

    private File addedDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.041 -0400", hash_original_field = "3517A8EAE9B16FDE0EB073810E20AF88", hash_generated_field = "61E19E5C5CD4CDE0E056E3DFED6783DE")

    private File deletedDir;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.041 -0400", hash_original_method = "2FF99D64326A5347B39C240182ABD235", hash_generated_method = "D7D90E22E15F31DCC7BD51E02E748945")
    public  TrustedCertificateStore() {
        this(CA_CERTS_DIR_SYSTEM, CA_CERTS_DIR_ADDED, CA_CERTS_DIR_DELETED);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.042 -0400", hash_original_method = "34C96A42FAFED1EA32C1B0CA7CD8DDF0", hash_generated_method = "7823F831586257EAA00813168C541C4A")
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

    
    @DSModeled(DSC.SAFE)
    public static final boolean isUser(String alias) {
        return alias.startsWith(PREFIX_USER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.043 -0400", hash_original_method = "DCFF226F6C2C4D0E26660E34EC9EC374", hash_generated_method = "428C112AF6D5043F92FA6297862C695E")
    public Certificate getCertificate(String alias) {
        addTaint(alias.getTaint());
Certificate var34CF93B0721C7E0C6C2DF014388C5C0F_1301204817 =         getCertificate(alias, false);
        var34CF93B0721C7E0C6C2DF014388C5C0F_1301204817.addTaint(taint);
        return var34CF93B0721C7E0C6C2DF014388C5C0F_1301204817;
        // ---------- Original Method ----------
        //return getCertificate(alias, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.044 -0400", hash_original_method = "5E5623CDAE6C2674E4A1581BA2487353", hash_generated_method = "A494B041B8713592E807B69AC845A822")
    public Certificate getCertificate(String alias, boolean includeDeletedSystem) {
        addTaint(includeDeletedSystem);
        addTaint(alias.getTaint());
        File file = fileForAlias(alias);
        if(file == null || (isUser(alias) && isTombstone(file)))        
        {
Certificate var540C13E9E156B687226421B24F2DF178_1601882129 =             null;
            var540C13E9E156B687226421B24F2DF178_1601882129.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1601882129;
        } //End block
        X509Certificate cert = readCertificate(file);
        if(cert == null || (isSystem(alias)
                             && !includeDeletedSystem
                             && isDeletedSystemCertificate(cert)))        
        {
Certificate var540C13E9E156B687226421B24F2DF178_1115248807 =             null;
            var540C13E9E156B687226421B24F2DF178_1115248807.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1115248807;
        } //End block
Certificate var0676091B2EE61AF2C17793D245ACD3DD_589615453 =         cert;
        var0676091B2EE61AF2C17793D245ACD3DD_589615453.addTaint(taint);
        return var0676091B2EE61AF2C17793D245ACD3DD_589615453;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.045 -0400", hash_original_method = "BD13BF64CDF62ABC225832ACDAE55EEB", hash_generated_method = "42C7D9D652B50AD32EC162BA1852FF35")
    private File fileForAlias(String alias) {
        addTaint(alias.getTaint());
        if(alias == null)        
        {
            NullPointerException varA41DA010B75092C1DC41FB26CB17ACAE_483315002 = new NullPointerException("alias == null");
            varA41DA010B75092C1DC41FB26CB17ACAE_483315002.addTaint(taint);
            throw varA41DA010B75092C1DC41FB26CB17ACAE_483315002;
        } //End block
        File file;
        if(isSystem(alias))        
        {
            file = new File(systemDir, alias.substring(PREFIX_SYSTEM.length()));
        } //End block
        else
        if(isUser(alias))        
        {
            file = new File(addedDir, alias.substring(PREFIX_USER.length()));
        } //End block
        else
        {
File var540C13E9E156B687226421B24F2DF178_1650240452 =             null;
            var540C13E9E156B687226421B24F2DF178_1650240452.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1650240452;
        } //End block
        if(!file.exists() || isTombstone(file))        
        {
File var540C13E9E156B687226421B24F2DF178_2110162477 =             null;
            var540C13E9E156B687226421B24F2DF178_2110162477.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2110162477;
        } //End block
File varADCB75793FA1DABACC5DEBFFAE466050_1875326832 =         file;
        varADCB75793FA1DABACC5DEBFFAE466050_1875326832.addTaint(taint);
        return varADCB75793FA1DABACC5DEBFFAE466050_1875326832;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.046 -0400", hash_original_method = "C0CC358A113978AA5962E41C2E3971C3", hash_generated_method = "796A879268E4FECFEA2BA6EF31409067")
    private boolean isTombstone(File file) {
        addTaint(file.getTaint());
        boolean var1B093743044925EF47B4A58AB54ED1F4_1718735954 = (file.length() == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1950516125 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1950516125;
        // ---------- Original Method ----------
        //return file.length() == 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.046 -0400", hash_original_method = "8510D8C420703F5BE76FCD04B0D510F3", hash_generated_method = "16A286ACF91C598EFE3D5EE1A270F2DA")
    private X509Certificate readCertificate(File file) {
        addTaint(file.getTaint());
        if(!file.isFile())        
        {
X509Certificate var540C13E9E156B687226421B24F2DF178_414545859 =             null;
            var540C13E9E156B687226421B24F2DF178_414545859.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_414545859;
        } //End block
        InputStream is = null;
        try 
        {
            is = new BufferedInputStream(new FileInputStream(file));
X509Certificate var9BCAF5C8FABC3B464F8FED85E7673E82_1853279357 =             (X509Certificate) CERT_FACTORY.generateCertificate(is);
            var9BCAF5C8FABC3B464F8FED85E7673E82_1853279357.addTaint(taint);
            return var9BCAF5C8FABC3B464F8FED85E7673E82_1853279357;
        } //End block
        catch (IOException e)
        {
X509Certificate var540C13E9E156B687226421B24F2DF178_939151788 =             null;
            var540C13E9E156B687226421B24F2DF178_939151788.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_939151788;
        } //End block
        catch (CertificateException e)
        {
X509Certificate var540C13E9E156B687226421B24F2DF178_1620562573 =             null;
            var540C13E9E156B687226421B24F2DF178_1620562573.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1620562573;
        } //End block
        finally 
        {
            IoUtils.closeQuietly(is);
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.047 -0400", hash_original_method = "109D07F89CD9540F28E2544DA7036A76", hash_generated_method = "96AEE19DCB9D1C59BA50477BC52A675A")
    private void writeCertificate(File file, X509Certificate cert) throws IOException, CertificateException {
        addTaint(cert.getTaint());
        addTaint(file.getTaint());
        File dir = file.getParentFile();
        dir.mkdirs();
        dir.setReadable(true, false);
        dir.setExecutable(true, false);
        OutputStream os = null;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.048 -0400", hash_original_method = "687C2EEF2D383D4BDFC0BC0824D70D25", hash_generated_method = "BE7BF97E15C820C780CE72C21EDEF3A4")
    private boolean isDeletedSystemCertificate(X509Certificate x) {
        addTaint(x.getTaint());
        boolean var1CD6EA7BB8481483763D77050B420765_1286344035 = (getCertificateFile(deletedDir, x).exists());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1493192685 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1493192685;
        // ---------- Original Method ----------
        //return getCertificateFile(deletedDir, x).exists();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.048 -0400", hash_original_method = "CCEB88AE1C59EF9C3585E776EAD03DC2", hash_generated_method = "BC5D048C97255D4A5081738ADEBDBD9F")
    public Date getCreationDate(String alias) {
        addTaint(alias.getTaint());
        if(!containsAlias(alias))        
        {
Date var540C13E9E156B687226421B24F2DF178_1824807865 =             null;
            var540C13E9E156B687226421B24F2DF178_1824807865.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1824807865;
        } //End block
        File file = fileForAlias(alias);
        if(file == null)        
        {
Date var540C13E9E156B687226421B24F2DF178_740754669 =             null;
            var540C13E9E156B687226421B24F2DF178_740754669.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_740754669;
        } //End block
        long time = file.lastModified();
        if(time == 0)        
        {
Date var540C13E9E156B687226421B24F2DF178_770310122 =             null;
            var540C13E9E156B687226421B24F2DF178_770310122.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_770310122;
        } //End block
Date var896776638DD62A3893EDE2E435DD8281_1177199992 =         new Date(time);
        var896776638DD62A3893EDE2E435DD8281_1177199992.addTaint(taint);
        return var896776638DD62A3893EDE2E435DD8281_1177199992;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.048 -0400", hash_original_method = "08CEADDFFE08C3DC9E367E6EE1C8514A", hash_generated_method = "F6AD6F2815027C27F285DB7D9C6B7525")
    public Set<String> aliases() {
        Set<String> result = new HashSet<String>();
        addAliases(result, PREFIX_USER, addedDir);
        addAliases(result, PREFIX_SYSTEM, systemDir);
Set<String> varDC838461EE2FA0CA4C9BBB70A15456B0_2005405861 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_2005405861.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_2005405861;
        // ---------- Original Method ----------
        //Set<String> result = new HashSet<String>();
        //addAliases(result, PREFIX_USER, addedDir);
        //addAliases(result, PREFIX_SYSTEM, systemDir);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.049 -0400", hash_original_method = "47F99465DCD8C3DA2109E78A8164CD01", hash_generated_method = "C6CD8338ED85DAD1EA89FA74C1C95979")
    public Set<String> userAliases() {
        Set<String> result = new HashSet<String>();
        addAliases(result, PREFIX_USER, addedDir);
Set<String> varDC838461EE2FA0CA4C9BBB70A15456B0_1864919368 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1864919368.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1864919368;
        // ---------- Original Method ----------
        //Set<String> result = new HashSet<String>();
        //addAliases(result, PREFIX_USER, addedDir);
        //return result;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.049 -0400", hash_original_method = "BF0B38E159AD70D54A581822F625340B", hash_generated_method = "9BB79BDCF6D7342E994F2D43F813EF7B")
    private void addAliases(Set<String> result, String prefix, File dir) {
        addTaint(dir.getTaint());
        addTaint(prefix.getTaint());
        addTaint(result.getTaint());
        String[] files = dir.list();
        if(files == null)        
        {
            return;
        } //End block
for(String filename : files)
        {
            String alias = prefix + filename;
            if(containsAlias(alias))            
            {
                result.add(alias);
            } //End block
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.049 -0400", hash_original_method = "43549AE16FD66ED845B02A525540D973", hash_generated_method = "82B9DCD276E074C06D36637DC46CE1C7")
    public Set<String> allSystemAliases() {
        Set<String> result = new HashSet<String>();
        String[] files = systemDir.list();
        if(files == null)        
        {
Set<String> varDC838461EE2FA0CA4C9BBB70A15456B0_973491066 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_973491066.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_973491066;
        } //End block
for(String filename : files)
        {
            String alias = PREFIX_SYSTEM + filename;
            if(containsAlias(alias, true))            
            {
                result.add(alias);
            } //End block
        } //End block
Set<String> varDC838461EE2FA0CA4C9BBB70A15456B0_1662316321 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1662316321.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1662316321;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.050 -0400", hash_original_method = "654AA0CAB25ECF1B8F909EEC1B58BB82", hash_generated_method = "FFC1FF3BDABAC39565BAEB88AA2CE807")
    public boolean containsAlias(String alias) {
        addTaint(alias.getTaint());
        boolean var06E3CB8F0C80A8165722275EEE68A85C_275860324 = (containsAlias(alias, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1554918246 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1554918246;
        // ---------- Original Method ----------
        //return containsAlias(alias, false);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.050 -0400", hash_original_method = "63CEC7C48C1DF35A32FA8773B953555D", hash_generated_method = "233DC43EF2B1D4FE0858A0EBD3FF669D")
    private boolean containsAlias(String alias, boolean includeDeletedSystem) {
        addTaint(includeDeletedSystem);
        addTaint(alias.getTaint());
        boolean var3449F19C692B39D6ED693477F288EFDB_362312423 = (getCertificate(alias, includeDeletedSystem) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_114612127 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_114612127;
        // ---------- Original Method ----------
        //return getCertificate(alias, includeDeletedSystem) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.051 -0400", hash_original_method = "2147628C71E1D1C09BD2609FCF8F152B", hash_generated_method = "FD0FEB4EE26798834294ECBF05AE8604")
    public String getCertificateAlias(Certificate c) {
        addTaint(c.getTaint());
        if(c == null || !(c instanceof X509Certificate))        
        {
String var540C13E9E156B687226421B24F2DF178_1829632046 =             null;
            var540C13E9E156B687226421B24F2DF178_1829632046.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1829632046;
        } //End block
        X509Certificate x = (X509Certificate) c;
        File user = getCertificateFile(addedDir, x);
        if(user.exists())        
        {
String var79C1D66B74638932E1A2EB20AD554BDF_2051025478 =             PREFIX_USER + user.getName();
            var79C1D66B74638932E1A2EB20AD554BDF_2051025478.addTaint(taint);
            return var79C1D66B74638932E1A2EB20AD554BDF_2051025478;
        } //End block
        if(isDeletedSystemCertificate(x))        
        {
String var540C13E9E156B687226421B24F2DF178_1774014320 =             null;
            var540C13E9E156B687226421B24F2DF178_1774014320.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1774014320;
        } //End block
        File system = getCertificateFile(systemDir, x);
        if(system.exists())        
        {
String var7496BDA00E051F88FD6DD694E3969BA4_1274115916 =             PREFIX_SYSTEM + system.getName();
            var7496BDA00E051F88FD6DD694E3969BA4_1274115916.addTaint(taint);
            return var7496BDA00E051F88FD6DD694E3969BA4_1274115916;
        } //End block
String var540C13E9E156B687226421B24F2DF178_995288269 =         null;
        var540C13E9E156B687226421B24F2DF178_995288269.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_995288269;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.051 -0400", hash_original_method = "00D6A00D33EFE0DA025C348896CFB4AD", hash_generated_method = "08B18AF12E9A8A8EA1FDB914F2E0F27D")
    private File getCertificateFile(File dir, final X509Certificate x) {
        addTaint(x.getTaint());
        addTaint(dir.getTaint());
        CertSelector selector = new CertSelector() {
            @Override public boolean match(X509Certificate cert) {
                return cert.equals(x);
            }
        };
File var908387D27739B0137405CF0F79F5D3A2_444978157 =         findCert(dir, x.getSubjectX500Principal(), selector, File.class);
        var908387D27739B0137405CF0F79F5D3A2_444978157.addTaint(taint);
        return var908387D27739B0137405CF0F79F5D3A2_444978157;
        // ---------- Original Method ----------
        //CertSelector selector = new CertSelector() {
            //@Override public boolean match(X509Certificate cert) {
                //return cert.equals(x);
            //}
        //};
        //return findCert(dir, x.getSubjectX500Principal(), selector, File.class);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.052 -0400", hash_original_method = "48D05ED9669BF04FD3B698D9020EF167", hash_generated_method = "BC9F078A2B874FF0C5B8FD3AEB80B0CF")
    public boolean isTrustAnchor(final X509Certificate c) {
        addTaint(c.getTaint());
        CertSelector selector = new CertSelector() {
            @Override public boolean match(X509Certificate ca) {
                return ca.getPublicKey().equals(c.getPublicKey());
            }
        };
        boolean user = findCert(addedDir,
                                c.getSubjectX500Principal(),
                                selector,
                                Boolean.class);
        if(user)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_967719180 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_807848490 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_807848490;
        } //End block
        X509Certificate system = findCert(systemDir,
                                          c.getSubjectX500Principal(),
                                          selector,
                                          X509Certificate.class);
        boolean var197FF1C305F491512393422FC0EA510B_596505252 = (system != null && !isDeletedSystemCertificate(system));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1791199846 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1791199846;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.053 -0400", hash_original_method = "A6B2832B57E732FF74F3B8B62A574310", hash_generated_method = "F2F9C44B02BD0572F6980DE0EDC470C2")
    public X509Certificate findIssuer(final X509Certificate c) {
        addTaint(c.getTaint());
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
        if(user != null)        
        {
X509Certificate var1ABA5703084F105A1CF02655AEDE82C9_1496744962 =             user;
            var1ABA5703084F105A1CF02655AEDE82C9_1496744962.addTaint(taint);
            return var1ABA5703084F105A1CF02655AEDE82C9_1496744962;
        } //End block
        X509Certificate system = findCert(systemDir, issuer, selector, X509Certificate.class);
        if(system != null && !isDeletedSystemCertificate(system))        
        {
X509Certificate varAAC0E5809FFEDD1FFBA9E1AB58112E83_693294548 =             system;
            varAAC0E5809FFEDD1FFBA9E1AB58112E83_693294548.addTaint(taint);
            return varAAC0E5809FFEDD1FFBA9E1AB58112E83_693294548;
        } //End block
X509Certificate var540C13E9E156B687226421B24F2DF178_1763265003 =         null;
        var540C13E9E156B687226421B24F2DF178_1763265003.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1763265003;
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
                    varEEA82B1F5951E79A49A59D17E2B4064C_1145522171.addTaint(taint);
                    return varEEA82B1F5951E79A49A59D17E2B4064C_1145522171;
                } //End block
                if(desiredReturnType == File.class)                
                {
T varF370AF19C57A14797EFDE924F649B8A2_1417298089 =                     (T) file;
                    varF370AF19C57A14797EFDE924F649B8A2_1417298089.addTaint(taint);
                    return varF370AF19C57A14797EFDE924F649B8A2_1417298089;
                } //End block
T var540C13E9E156B687226421B24F2DF178_442038581 =                 null;
                var540C13E9E156B687226421B24F2DF178_442038581.addTaint(taint);
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
                    var317015959638CAF4FFAC3A88AE5CE017_819158653.addTaint(taint);
                    return var317015959638CAF4FFAC3A88AE5CE017_819158653;
                } //End block
                if(desiredReturnType == Boolean.class)                
                {
T varE0E5C48B656ACCBA0CDB3CC6914BAD9C_41080555 =                     (T) Boolean.TRUE;
                    varE0E5C48B656ACCBA0CDB3CC6914BAD9C_41080555.addTaint(taint);
                    return varE0E5C48B656ACCBA0CDB3CC6914BAD9C_41080555;
                } //End block
                if(desiredReturnType == File.class)                
                {
T varF370AF19C57A14797EFDE924F649B8A2_1961021583 =                     (T) file;
                    varF370AF19C57A14797EFDE924F649B8A2_1961021583.addTaint(taint);
                    return varF370AF19C57A14797EFDE924F649B8A2_1961021583;
                } //End block
                AssertionError varA81442E36297E737EB908877E58260E8_1544935951 = new AssertionError();
                varA81442E36297E737EB908877E58260E8_1544935951.addTaint(taint);
                throw varA81442E36297E737EB908877E58260E8_1544935951;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.055 -0400", hash_original_method = "90B2D041BE6875A6E09EF80BBE557D3F", hash_generated_method = "F4CC3DB0F1AC761B7AB7A54106109C3E")
    private String hash(X500Principal name) {
        addTaint(name.getTaint());
        int hash = NativeCrypto.X509_NAME_hash_old(name);
String var8E81D6965289FBD7A7179D30AB2A8DC2_778014896 =         IntegralToString.intToHexString(hash, false, 8);
        var8E81D6965289FBD7A7179D30AB2A8DC2_778014896.addTaint(taint);
        return var8E81D6965289FBD7A7179D30AB2A8DC2_778014896;
        // ---------- Original Method ----------
        //int hash = NativeCrypto.X509_NAME_hash_old(name);
        //return IntegralToString.intToHexString(hash, false, 8);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.055 -0400", hash_original_method = "0B663A316D5F1EC956CA42A84A17EC6A", hash_generated_method = "DC15CA1208160858CBCD141BD681EB3A")
    private File file(File dir, String hash, int index) {
        addTaint(index);
        addTaint(hash.getTaint());
        addTaint(dir.getTaint());
File var7052B15222CCC1779653D77CA0B77A2A_372106584 =         new File(dir, hash + '.' + index);
        var7052B15222CCC1779653D77CA0B77A2A_372106584.addTaint(taint);
        return var7052B15222CCC1779653D77CA0B77A2A_372106584;
        // ---------- Original Method ----------
        //return new File(dir, hash + '.' + index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.056 -0400", hash_original_method = "895D177FC3F042016815EFE0F89E89FF", hash_generated_method = "44A7D2499B0486EAF4A27AD38CAEEBD5")
    public void installCertificate(X509Certificate cert) throws IOException, CertificateException {
        addTaint(cert.getTaint());
        if(cert == null)        
        {
            NullPointerException var525F7DA6B6A738254A551583BF1EC23F_1746110572 = new NullPointerException("cert == null");
            var525F7DA6B6A738254A551583BF1EC23F_1746110572.addTaint(taint);
            throw var525F7DA6B6A738254A551583BF1EC23F_1746110572;
        } //End block
        File system = getCertificateFile(systemDir, cert);
        if(system.exists())        
        {
            File deleted = getCertificateFile(deletedDir, cert);
            if(deleted.exists())            
            {
                if(!deleted.delete())                
                {
                    IOException var5A30D546C7E155FB9F49096879543BC5_1094935305 = new IOException("Could not remove " + deleted);
                    var5A30D546C7E155FB9F49096879543BC5_1094935305.addTaint(taint);
                    throw var5A30D546C7E155FB9F49096879543BC5_1094935305;
                } //End block
                return;
            } //End block
            return;
        } //End block
        File user = getCertificateFile(addedDir, cert);
        if(user.exists())        
        {
            return;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.057 -0400", hash_original_method = "7A4509C068B331E1E582C2216EB99D6E", hash_generated_method = "168D3E076A219DA4895E48E372332F87")
    public void deleteCertificateEntry(String alias) throws IOException, CertificateException {
        addTaint(alias.getTaint());
        if(alias == null)        
        {
            return;
        } //End block
        File file = fileForAlias(alias);
        if(file == null)        
        {
            return;
        } //End block
        if(isSystem(alias))        
        {
            X509Certificate cert = readCertificate(file);
            if(cert == null)            
            {
                return;
            } //End block
            File deleted = getCertificateFile(deletedDir, cert);
            if(deleted.exists())            
            {
                return;
            } //End block
            writeCertificate(deleted, cert);
            return;
        } //End block
        if(isUser(alias))        
        {
            new FileOutputStream(file).close();
            removeUnnecessaryTombstones(alias);
            return;
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.058 -0400", hash_original_method = "728256A42E564BAD8F0CB50A75981023", hash_generated_method = "439692E091AFF088A74475887DECF2FF")
    private void removeUnnecessaryTombstones(String alias) throws IOException {
        addTaint(alias.getTaint());
        if(!isUser(alias))        
        {
            AssertionError var72D8AB7BCDD494F890D03A431A840183_1197871478 = new AssertionError(alias);
            var72D8AB7BCDD494F890D03A431A840183_1197871478.addTaint(taint);
            throw var72D8AB7BCDD494F890D03A431A840183_1197871478;
        } //End block
        int dotIndex = alias.lastIndexOf('.');
        if(dotIndex == -1)        
        {
            AssertionError var72D8AB7BCDD494F890D03A431A840183_1752453811 = new AssertionError(alias);
            var72D8AB7BCDD494F890D03A431A840183_1752453811.addTaint(taint);
            throw var72D8AB7BCDD494F890D03A431A840183_1752453811;
        } //End block
        String hash = alias.substring(PREFIX_USER.length(), dotIndex);
        int lastTombstoneIndex = Integer.parseInt(alias.substring(dotIndex + 1));
        if(file(addedDir, hash, lastTombstoneIndex + 1).exists())        
        {
            return;
        } //End block
        while
(lastTombstoneIndex >= 0)        
        {
            File file = file(addedDir, hash, lastTombstoneIndex);
            if(!isTombstone(file))            
            {
                break;
            } //End block
            if(!file.delete())            
            {
                IOException var44ECDF313521F25CE095DEA823617EAC_1564742437 = new IOException("Could not remove " + file);
                var44ECDF313521F25CE095DEA823617EAC_1564742437.addTaint(taint);
                throw var44ECDF313521F25CE095DEA823617EAC_1564742437;
            } //End block
            lastTombstoneIndex--;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.059 -0400", hash_original_field = "F3DA322195F74C599019702368619A37", hash_generated_field = "98B968CCA96375701AE00045F4565AA4")

    private static final String PREFIX_SYSTEM = "system:";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.059 -0400", hash_original_field = "F37C1708F7515416271B9D08F734CB81", hash_generated_field = "CC133772DAA5E2094775535E65584148")

    private static final String PREFIX_USER = "user:";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.059 -0400", hash_original_field = "D0F09AFF7CD6199AEC61BA10225D3883", hash_generated_field = "FC1AC5B6AA36D7E7E6ACAACF0F236293")

    private static File CA_CERTS_DIR_SYSTEM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.059 -0400", hash_original_field = "21FC5FD3F6816142A976DCC0421E09CF", hash_generated_field = "0B21C402CC49FA93FF2ACC6C155EF2F1")

    private static File CA_CERTS_DIR_ADDED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.060 -0400", hash_original_field = "5D694C3AEF4BA343CF62C23AFD1AE62D", hash_generated_field = "CD17C03FD55940BDD7E8C3B35E42402F")

    private static File CA_CERTS_DIR_DELETED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.060 -0400", hash_original_field = "77A1E099CD5A94A27C8AC19EC52F3D2B", hash_generated_field = "73AFD3573A389E9D3C4778BF352F4917")

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

