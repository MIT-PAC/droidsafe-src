package java.security;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Enumeration;

import javax.crypto.SecretKey;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.PasswordCallback;





public abstract class KeyStoreSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.039 -0400", hash_original_method = "0F44DABB4B3060793D573A941E7E27B4", hash_generated_method = "0F44DABB4B3060793D573A941E7E27B4")
    public KeyStoreSpi ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public abstract Key engineGetKey(String alias, char[] password)
            throws NoSuchAlgorithmException, UnrecoverableKeyException;

    
    @DSModeled(DSC.SAFE)
    public abstract Certificate[] engineGetCertificateChain(String alias);

    
    @DSModeled(DSC.SAFE)
    public abstract Certificate engineGetCertificate(String alias);

    
    @DSModeled(DSC.SAFE)
    public abstract Date engineGetCreationDate(String alias);

    
    @DSModeled(DSC.SAFE)
    public abstract void engineSetKeyEntry(String alias, Key key,
            char[] password, Certificate[] chain) throws KeyStoreException;

    
    @DSModeled(DSC.SAFE)
    public abstract void engineSetKeyEntry(String alias, byte[] key,
            Certificate[] chain) throws KeyStoreException;

    
    @DSModeled(DSC.SAFE)
    public abstract void engineSetCertificateEntry(String alias,
            Certificate cert) throws KeyStoreException;

    
    @DSModeled(DSC.SAFE)
    public abstract void engineDeleteEntry(String alias)
            throws KeyStoreException;

    
    @DSModeled(DSC.SAFE)
    public abstract Enumeration<String> engineAliases();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean engineContainsAlias(String alias);

    
    @DSModeled(DSC.SAFE)
    public abstract int engineSize();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean engineIsKeyEntry(String alias);

    
    @DSModeled(DSC.SAFE)
    public abstract boolean engineIsCertificateEntry(String alias);

    
    @DSModeled(DSC.SAFE)
    public abstract String engineGetCertificateAlias(Certificate cert);

    
    @DSModeled(DSC.SAFE)
    public abstract void engineStore(OutputStream stream, char[] password)
            throws IOException, NoSuchAlgorithmException, CertificateException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.043 -0400", hash_original_method = "2DD87D7240BCBB9F96BACA77A06CD528", hash_generated_method = "4C56B3F97861EC65BFE63E0D46A6D870")
    public void engineStore(KeyStore.LoadStoreParameter param) throws IOException, NoSuchAlgorithmException, CertificateException {
        addTaint(param.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1443864684 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1443864684.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1443864684;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void engineLoad(InputStream stream, char[] password)
            throws IOException, NoSuchAlgorithmException, CertificateException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.044 -0400", hash_original_method = "C2F8D415FB9276C7A503B37F207C6477", hash_generated_method = "B63DBEC1874B136FA66C8E8BDD65E7B1")
    public void engineLoad(KeyStore.LoadStoreParameter param) throws IOException, NoSuchAlgorithmException, CertificateException {
        addTaint(param.getTaint());
        if(param == null)        
        {
            engineLoad(null, null);
            return;
        } //End block
        char[] pwd;
        KeyStore.ProtectionParameter pp = param.getProtectionParameter();
        if(pp instanceof KeyStore.PasswordProtection)        
        {
            try 
            {
                pwd = ((KeyStore.PasswordProtection) pp).getPassword();
                engineLoad(null, pwd);
                return;
            } //End block
            catch (IllegalStateException e)
            {
                IllegalArgumentException varB5003C51895A632D49EB91E1ECEE1438_199766510 = new IllegalArgumentException(e);
                varB5003C51895A632D49EB91E1ECEE1438_199766510.addTaint(taint);
                throw varB5003C51895A632D49EB91E1ECEE1438_199766510;
            } //End block
        } //End block
        if(pp instanceof KeyStore.CallbackHandlerProtection)        
        {
            try 
            {
                pwd = getPasswordFromCallBack(pp);
                engineLoad(null, pwd);
                return;
            } //End block
            catch (UnrecoverableEntryException e)
            {
                IllegalArgumentException varB5003C51895A632D49EB91E1ECEE1438_2116742 = new IllegalArgumentException(e);
                varB5003C51895A632D49EB91E1ECEE1438_2116742.addTaint(taint);
                throw varB5003C51895A632D49EB91E1ECEE1438_2116742;
            } //End block
        } //End block
        UnsupportedOperationException var512AC5F29E79BF38AAF79998E614D9BB_1190909615 = new UnsupportedOperationException("protectionParameter is neither PasswordProtection "
                                                + "nor CallbackHandlerProtection instance");
        var512AC5F29E79BF38AAF79998E614D9BB_1190909615.addTaint(taint);
        throw var512AC5F29E79BF38AAF79998E614D9BB_1190909615;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.046 -0400", hash_original_method = "B68FB53D4042F1FDA8275FB481793ECB", hash_generated_method = "CA60EFFCCA993F7244FF292C057101B9")
    public KeyStore.Entry engineGetEntry(String alias,
            KeyStore.ProtectionParameter protParam) throws KeyStoreException,
            NoSuchAlgorithmException, UnrecoverableEntryException {
        addTaint(protParam.getTaint());
        addTaint(alias.getTaint());
        if(!engineContainsAlias(alias))        
        {
KeyStore.Entry var540C13E9E156B687226421B24F2DF178_222167658 =             null;
            var540C13E9E156B687226421B24F2DF178_222167658.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_222167658;
        } //End block
        if(engineIsCertificateEntry(alias))        
        {
KeyStore.Entry varFA8BB8BF63DFDCDE2AC1F37FA493C5A6_1255634172 =             new KeyStore.TrustedCertificateEntry(
                    engineGetCertificate(alias));
            varFA8BB8BF63DFDCDE2AC1F37FA493C5A6_1255634172.addTaint(taint);
            return varFA8BB8BF63DFDCDE2AC1F37FA493C5A6_1255634172;
        } //End block
        char[] passW = null;
        if(protParam != null)        
        {
            if(protParam instanceof KeyStore.PasswordProtection)            
            {
                try 
                {
                    passW = ((KeyStore.PasswordProtection) protParam)
                            .getPassword();
                } //End block
                catch (IllegalStateException ee)
                {
                    KeyStoreException var173E0EA18B216CA1F3470CACBC03B9C2_548938445 = new KeyStoreException("Password was destroyed", ee);
                    var173E0EA18B216CA1F3470CACBC03B9C2_548938445.addTaint(taint);
                    throw var173E0EA18B216CA1F3470CACBC03B9C2_548938445;
                } //End block
            } //End block
            else
            if(protParam instanceof KeyStore.CallbackHandlerProtection)            
            {
                passW = getPasswordFromCallBack(protParam);
            } //End block
            else
            {
                UnrecoverableEntryException varBDCA280E2ADDBE63E73F1C1F739B22A2_1496781214 = new UnrecoverableEntryException("ProtectionParameter object is not "
                                                      + "PasswordProtection: " + protParam);
                varBDCA280E2ADDBE63E73F1C1F739B22A2_1496781214.addTaint(taint);
                throw varBDCA280E2ADDBE63E73F1C1F739B22A2_1496781214;
            } //End block
        } //End block
        if(engineIsKeyEntry(alias))        
        {
            Key key = engineGetKey(alias, passW);
            if(key instanceof PrivateKey)            
            {
KeyStore.Entry varA29A3E037505354C38B79FE2CCF25E01_1570640072 =                 new KeyStore.PrivateKeyEntry((PrivateKey) key,
                                                    engineGetCertificateChain(alias));
                varA29A3E037505354C38B79FE2CCF25E01_1570640072.addTaint(taint);
                return varA29A3E037505354C38B79FE2CCF25E01_1570640072;
            } //End block
            if(key instanceof SecretKey)            
            {
KeyStore.Entry varF6CA60BE43493BB9E1AF2A8B4D10A17E_600898535 =                 new KeyStore.SecretKeyEntry((SecretKey) key);
                varF6CA60BE43493BB9E1AF2A8B4D10A17E_600898535.addTaint(taint);
                return varF6CA60BE43493BB9E1AF2A8B4D10A17E_600898535;
            } //End block
        } //End block
        NoSuchAlgorithmException varF484C7331F04107001121C1ED67E4532_702355499 = new NoSuchAlgorithmException("Unknown KeyStore.Entry object");
        varF484C7331F04107001121C1ED67E4532_702355499.addTaint(taint);
        throw varF484C7331F04107001121C1ED67E4532_702355499;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.047 -0400", hash_original_method = "3D4613712C6A1FF15305C05DDF5D1E0F", hash_generated_method = "6B89AE5F38D76F0B17FB409A95B415F9")
    public void engineSetEntry(String alias, KeyStore.Entry entry,
            KeyStore.ProtectionParameter protParam) throws KeyStoreException {
        addTaint(protParam.getTaint());
        addTaint(entry.getTaint());
        addTaint(alias.getTaint());
        if(entry == null)        
        {
            KeyStoreException varE92AAD21409D60072D72DD35DFD12641_1604381729 = new KeyStoreException("entry == null");
            varE92AAD21409D60072D72DD35DFD12641_1604381729.addTaint(taint);
            throw varE92AAD21409D60072D72DD35DFD12641_1604381729;
        } //End block
        if(engineContainsAlias(alias))        
        {
            engineDeleteEntry(alias);
        } //End block
        if(entry instanceof KeyStore.TrustedCertificateEntry)        
        {
            KeyStore.TrustedCertificateEntry trE = (KeyStore.TrustedCertificateEntry) entry;
            engineSetCertificateEntry(alias, trE.getTrustedCertificate());
            return;
        } //End block
        char[] passW = null;
        if(protParam instanceof KeyStore.PasswordProtection)        
        {
            try 
            {
                passW = ((KeyStore.PasswordProtection) protParam).getPassword();
            } //End block
            catch (IllegalStateException ee)
            {
                KeyStoreException var173E0EA18B216CA1F3470CACBC03B9C2_1167746043 = new KeyStoreException("Password was destroyed", ee);
                var173E0EA18B216CA1F3470CACBC03B9C2_1167746043.addTaint(taint);
                throw var173E0EA18B216CA1F3470CACBC03B9C2_1167746043;
            } //End block
        } //End block
        else
        {
            if(protParam instanceof KeyStore.CallbackHandlerProtection)            
            {
                try 
                {
                    passW = getPasswordFromCallBack(protParam);
                } //End block
                catch (Exception e)
                {
                    KeyStoreException varC175B833FB13811057889966C2C78A66_1747687655 = new KeyStoreException(e);
                    varC175B833FB13811057889966C2C78A66_1747687655.addTaint(taint);
                    throw varC175B833FB13811057889966C2C78A66_1747687655;
                } //End block
            } //End block
            else
            {
                KeyStoreException var304020BB170CEDA770D5AB0AB4202E66_1726952378 = new KeyStoreException("protParam should be PasswordProtection or "
                                            + "CallbackHandlerProtection");
                var304020BB170CEDA770D5AB0AB4202E66_1726952378.addTaint(taint);
                throw var304020BB170CEDA770D5AB0AB4202E66_1726952378;
            } //End block
        } //End block
        if(entry instanceof KeyStore.PrivateKeyEntry)        
        {
            KeyStore.PrivateKeyEntry prE = (KeyStore.PrivateKeyEntry) entry;
            engineSetKeyEntry(alias, prE.getPrivateKey(), passW, prE
                    .getCertificateChain());
            return;
        } //End block
        if(entry instanceof KeyStore.SecretKeyEntry)        
        {
            KeyStore.SecretKeyEntry skE = (KeyStore.SecretKeyEntry) entry;
            engineSetKeyEntry(alias, skE.getSecretKey(), passW, null);
            return;
        } //End block
        KeyStoreException var21E6B874E04A2F6D10C5FD3CACF0E075_1006833976 = new KeyStoreException("Entry object is neither PrivateKeyObject nor SecretKeyEntry "
                                    + "nor TrustedCertificateEntry: " + entry);
        var21E6B874E04A2F6D10C5FD3CACF0E075_1006833976.addTaint(taint);
        throw var21E6B874E04A2F6D10C5FD3CACF0E075_1006833976;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.048 -0400", hash_original_method = "E646126BAF6D7B233BE960C73341BBD0", hash_generated_method = "72543B1C26477AF4FDAE093D024333BE")
    public boolean engineEntryInstanceOf(String alias,
            Class<? extends KeyStore.Entry> entryClass) {
        addTaint(entryClass.getTaint());
        addTaint(alias.getTaint());
        if(!engineContainsAlias(alias))        
        {
            boolean var68934A3E9455FA72420237EB05902327_877369049 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_628772272 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_628772272;
        } //End block
        try 
        {
            if(engineIsCertificateEntry(alias))            
            {
                boolean varA13E19827071CE87C14AD06E7F905001_1245460225 = (entryClass
                        .isAssignableFrom(Class
                                .forName("java.security.KeyStore$TrustedCertificateEntry")));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_683189755 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_683189755;
            } //End block
            if(engineIsKeyEntry(alias))            
            {
                if(entryClass.isAssignableFrom(Class
                        .forName("java.security.KeyStore$PrivateKeyEntry")))                
                {
                    boolean varFD7A0BF7E224744E06A6F39A8EFAB35E_113136126 = (engineGetCertificate(alias) != null);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_631213698 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_631213698;
                } //End block
                if(entryClass.isAssignableFrom(Class
                        .forName("java.security.KeyStore$SecretKeyEntry")))                
                {
                    boolean var00949CCCA50644B14627A52DB7FA0B55_2028243655 = (engineGetCertificate(alias) == null);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2082323372 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2082323372;
                } //End block
            } //End block
        } //End block
        catch (ClassNotFoundException ignore)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_48725913 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1341773329 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1341773329;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    static char[] getPasswordFromCallBack(KeyStore.ProtectionParameter protParam) throws UnrecoverableEntryException {
        if (protParam == null) {
            return null;
        }
        if (!(protParam instanceof KeyStore.CallbackHandlerProtection)) {
            throw new UnrecoverableEntryException("Incorrect ProtectionParameter");
        }
        String clName = Security.getProperty("auth.login.defaultCallbackHandler");
        if (clName == null) {
            throw new UnrecoverableEntryException("Default CallbackHandler was not defined");
        }
        try {
            Class<?> cl = Class.forName(clName);
            CallbackHandler cbHand = (CallbackHandler) cl.newInstance();
            PasswordCallback[] pwCb = { new PasswordCallback("password: ", true) };
            cbHand.handle(pwCb);
            return pwCb[0].getPassword();
        } catch (Exception e) {
            throw new UnrecoverableEntryException(e.toString());
        }
    }

    
}

