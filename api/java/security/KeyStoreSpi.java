package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.084 -0400", hash_original_method = "0F44DABB4B3060793D573A941E7E27B4", hash_generated_method = "0F44DABB4B3060793D573A941E7E27B4")
    public KeyStoreSpi ()
    {
        //Synthesized constructor
    }


    public abstract Key engineGetKey(String alias, char[] password)
            throws NoSuchAlgorithmException, UnrecoverableKeyException;

    
    public abstract Certificate[] engineGetCertificateChain(String alias);

    
    public abstract Certificate engineGetCertificate(String alias);

    
    public abstract Date engineGetCreationDate(String alias);

    
    public abstract void engineSetKeyEntry(String alias, Key key,
            char[] password, Certificate[] chain) throws KeyStoreException;

    
    public abstract void engineSetKeyEntry(String alias, byte[] key,
            Certificate[] chain) throws KeyStoreException;

    
    public abstract void engineSetCertificateEntry(String alias,
            Certificate cert) throws KeyStoreException;

    
    public abstract void engineDeleteEntry(String alias)
            throws KeyStoreException;

    
    public abstract Enumeration<String> engineAliases();

    
    public abstract boolean engineContainsAlias(String alias);

    
    public abstract int engineSize();

    
    public abstract boolean engineIsKeyEntry(String alias);

    
    public abstract boolean engineIsCertificateEntry(String alias);

    
    public abstract String engineGetCertificateAlias(Certificate cert);

    
    public abstract void engineStore(OutputStream stream, char[] password)
            throws IOException, NoSuchAlgorithmException, CertificateException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.087 -0400", hash_original_method = "2DD87D7240BCBB9F96BACA77A06CD528", hash_generated_method = "A86A80AADB8AE890277C20828B1C55A6")
    public void engineStore(KeyStore.LoadStoreParameter param) throws IOException, NoSuchAlgorithmException, CertificateException {
        addTaint(param.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1591888211 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1591888211.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1591888211;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    public abstract void engineLoad(InputStream stream, char[] password)
            throws IOException, NoSuchAlgorithmException, CertificateException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.088 -0400", hash_original_method = "C2F8D415FB9276C7A503B37F207C6477", hash_generated_method = "F2FCD594E536B8ADD8D55ED48F1F6251")
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
                IllegalArgumentException varB5003C51895A632D49EB91E1ECEE1438_8650145 = new IllegalArgumentException(e);
                varB5003C51895A632D49EB91E1ECEE1438_8650145.addTaint(taint);
                throw varB5003C51895A632D49EB91E1ECEE1438_8650145;
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
                IllegalArgumentException varB5003C51895A632D49EB91E1ECEE1438_645431264 = new IllegalArgumentException(e);
                varB5003C51895A632D49EB91E1ECEE1438_645431264.addTaint(taint);
                throw varB5003C51895A632D49EB91E1ECEE1438_645431264;
            } //End block
        } //End block
        UnsupportedOperationException var512AC5F29E79BF38AAF79998E614D9BB_343526259 = new UnsupportedOperationException("protectionParameter is neither PasswordProtection "
                                                + "nor CallbackHandlerProtection instance");
        var512AC5F29E79BF38AAF79998E614D9BB_343526259.addTaint(taint);
        throw var512AC5F29E79BF38AAF79998E614D9BB_343526259;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.089 -0400", hash_original_method = "B68FB53D4042F1FDA8275FB481793ECB", hash_generated_method = "E7CD98163530AD2790EA18B3E08639BE")
    public KeyStore.Entry engineGetEntry(String alias,
            KeyStore.ProtectionParameter protParam) throws KeyStoreException,
            NoSuchAlgorithmException, UnrecoverableEntryException {
        addTaint(protParam.getTaint());
        addTaint(alias.getTaint());
    if(!engineContainsAlias(alias))        
        {
KeyStore.Entry var540C13E9E156B687226421B24F2DF178_539534961 =             null;
            var540C13E9E156B687226421B24F2DF178_539534961.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_539534961;
        } //End block
    if(engineIsCertificateEntry(alias))        
        {
KeyStore.Entry varFA8BB8BF63DFDCDE2AC1F37FA493C5A6_1800130756 =             new KeyStore.TrustedCertificateEntry(
                    engineGetCertificate(alias));
            varFA8BB8BF63DFDCDE2AC1F37FA493C5A6_1800130756.addTaint(taint);
            return varFA8BB8BF63DFDCDE2AC1F37FA493C5A6_1800130756;
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
                    KeyStoreException var173E0EA18B216CA1F3470CACBC03B9C2_27610623 = new KeyStoreException("Password was destroyed", ee);
                    var173E0EA18B216CA1F3470CACBC03B9C2_27610623.addTaint(taint);
                    throw var173E0EA18B216CA1F3470CACBC03B9C2_27610623;
                } //End block
            } //End block
            else
    if(protParam instanceof KeyStore.CallbackHandlerProtection)            
            {
                passW = getPasswordFromCallBack(protParam);
            } //End block
            else
            {
                UnrecoverableEntryException varBDCA280E2ADDBE63E73F1C1F739B22A2_486010408 = new UnrecoverableEntryException("ProtectionParameter object is not "
                                                      + "PasswordProtection: " + protParam);
                varBDCA280E2ADDBE63E73F1C1F739B22A2_486010408.addTaint(taint);
                throw varBDCA280E2ADDBE63E73F1C1F739B22A2_486010408;
            } //End block
        } //End block
    if(engineIsKeyEntry(alias))        
        {
            Key key = engineGetKey(alias, passW);
    if(key instanceof PrivateKey)            
            {
KeyStore.Entry varA29A3E037505354C38B79FE2CCF25E01_653931941 =                 new KeyStore.PrivateKeyEntry((PrivateKey) key,
                                                    engineGetCertificateChain(alias));
                varA29A3E037505354C38B79FE2CCF25E01_653931941.addTaint(taint);
                return varA29A3E037505354C38B79FE2CCF25E01_653931941;
            } //End block
    if(key instanceof SecretKey)            
            {
KeyStore.Entry varF6CA60BE43493BB9E1AF2A8B4D10A17E_1807190992 =                 new KeyStore.SecretKeyEntry((SecretKey) key);
                varF6CA60BE43493BB9E1AF2A8B4D10A17E_1807190992.addTaint(taint);
                return varF6CA60BE43493BB9E1AF2A8B4D10A17E_1807190992;
            } //End block
        } //End block
        NoSuchAlgorithmException varF484C7331F04107001121C1ED67E4532_1432009089 = new NoSuchAlgorithmException("Unknown KeyStore.Entry object");
        varF484C7331F04107001121C1ED67E4532_1432009089.addTaint(taint);
        throw varF484C7331F04107001121C1ED67E4532_1432009089;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.090 -0400", hash_original_method = "3D4613712C6A1FF15305C05DDF5D1E0F", hash_generated_method = "A0F9BED3F6DDA4E15E0294EA86A40665")
    public void engineSetEntry(String alias, KeyStore.Entry entry,
            KeyStore.ProtectionParameter protParam) throws KeyStoreException {
        addTaint(protParam.getTaint());
        addTaint(entry.getTaint());
        addTaint(alias.getTaint());
    if(entry == null)        
        {
            KeyStoreException varE92AAD21409D60072D72DD35DFD12641_1518373007 = new KeyStoreException("entry == null");
            varE92AAD21409D60072D72DD35DFD12641_1518373007.addTaint(taint);
            throw varE92AAD21409D60072D72DD35DFD12641_1518373007;
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
                KeyStoreException var173E0EA18B216CA1F3470CACBC03B9C2_864029553 = new KeyStoreException("Password was destroyed", ee);
                var173E0EA18B216CA1F3470CACBC03B9C2_864029553.addTaint(taint);
                throw var173E0EA18B216CA1F3470CACBC03B9C2_864029553;
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
                    KeyStoreException varC175B833FB13811057889966C2C78A66_1867449474 = new KeyStoreException(e);
                    varC175B833FB13811057889966C2C78A66_1867449474.addTaint(taint);
                    throw varC175B833FB13811057889966C2C78A66_1867449474;
                } //End block
            } //End block
            else
            {
                KeyStoreException var304020BB170CEDA770D5AB0AB4202E66_1127303124 = new KeyStoreException("protParam should be PasswordProtection or "
                                            + "CallbackHandlerProtection");
                var304020BB170CEDA770D5AB0AB4202E66_1127303124.addTaint(taint);
                throw var304020BB170CEDA770D5AB0AB4202E66_1127303124;
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
        KeyStoreException var21E6B874E04A2F6D10C5FD3CACF0E075_1138593107 = new KeyStoreException("Entry object is neither PrivateKeyObject nor SecretKeyEntry "
                                    + "nor TrustedCertificateEntry: " + entry);
        var21E6B874E04A2F6D10C5FD3CACF0E075_1138593107.addTaint(taint);
        throw var21E6B874E04A2F6D10C5FD3CACF0E075_1138593107;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.091 -0400", hash_original_method = "E646126BAF6D7B233BE960C73341BBD0", hash_generated_method = "554E4A1BB64BC3B60FC6348B3A64910D")
    public boolean engineEntryInstanceOf(String alias,
            Class<? extends KeyStore.Entry> entryClass) {
        addTaint(entryClass.getTaint());
        addTaint(alias.getTaint());
    if(!engineContainsAlias(alias))        
        {
            boolean var68934A3E9455FA72420237EB05902327_286276151 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1895805937 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1895805937;
        } //End block
        try 
        {
    if(engineIsCertificateEntry(alias))            
            {
                boolean varA13E19827071CE87C14AD06E7F905001_1166320039 = (entryClass
                        .isAssignableFrom(Class
                                .forName("java.security.KeyStore$TrustedCertificateEntry")));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_872960870 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_872960870;
            } //End block
    if(engineIsKeyEntry(alias))            
            {
    if(entryClass.isAssignableFrom(Class
                        .forName("java.security.KeyStore$PrivateKeyEntry")))                
                {
                    boolean varFD7A0BF7E224744E06A6F39A8EFAB35E_154297480 = (engineGetCertificate(alias) != null);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_796507603 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_796507603;
                } //End block
    if(entryClass.isAssignableFrom(Class
                        .forName("java.security.KeyStore$SecretKeyEntry")))                
                {
                    boolean var00949CCCA50644B14627A52DB7FA0B55_2003617722 = (engineGetCertificate(alias) == null);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1788645689 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1788645689;
                } //End block
            } //End block
        } //End block
        catch (ClassNotFoundException ignore)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1440107590 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1094394494 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1094394494;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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

