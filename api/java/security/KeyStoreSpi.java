package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.350 -0400", hash_original_method = "0F44DABB4B3060793D573A941E7E27B4", hash_generated_method = "0F44DABB4B3060793D573A941E7E27B4")
    public KeyStoreSpi ()
    {
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.352 -0400", hash_original_method = "2DD87D7240BCBB9F96BACA77A06CD528", hash_generated_method = "39FF2BFC10C6E11D55D19E6B4006D8BB")
    public void engineStore(KeyStore.LoadStoreParameter param) throws IOException, NoSuchAlgorithmException, CertificateException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(param.getTaint());
        
        
    }

    
    public abstract void engineLoad(InputStream stream, char[] password)
            throws IOException, NoSuchAlgorithmException, CertificateException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.353 -0400", hash_original_method = "C2F8D415FB9276C7A503B37F207C6477", hash_generated_method = "0E3F13FDA73B3FAD365023F02F2D7806")
    public void engineLoad(KeyStore.LoadStoreParameter param) throws IOException, NoSuchAlgorithmException, CertificateException {
        {
            engineLoad(null, null);
        } 
        char[] pwd;
        KeyStore.ProtectionParameter pp = param.getProtectionParameter();
        {
            try 
            {
                pwd = ((KeyStore.PasswordProtection) pp).getPassword();
                engineLoad(null, pwd);
            } 
            catch (IllegalStateException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(e);
            } 
        } 
        {
            try 
            {
                pwd = getPasswordFromCallBack(pp);
                engineLoad(null, pwd);
            } 
            catch (UnrecoverableEntryException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(e);
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("protectionParameter is neither PasswordProtection "
                                                + "nor CallbackHandlerProtection instance");
        addTaint(param.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.356 -0400", hash_original_method = "B68FB53D4042F1FDA8275FB481793ECB", hash_generated_method = "611DD89098A95280BF51EEAE19565F9F")
    public KeyStore.Entry engineGetEntry(String alias,
            KeyStore.ProtectionParameter protParam) throws KeyStoreException,
            NoSuchAlgorithmException, UnrecoverableEntryException {
        KeyStore.Entry varB4EAC82CA7396A68D541C85D26508E83_2088822935 = null; 
        KeyStore.Entry varB4EAC82CA7396A68D541C85D26508E83_37559937 = null; 
        KeyStore.Entry varB4EAC82CA7396A68D541C85D26508E83_1510855945 = null; 
        KeyStore.Entry varB4EAC82CA7396A68D541C85D26508E83_1549697905 = null; 
        {
            boolean var5CDA5E3738B95D49C978F3282219AB9E_1025416541 = (!engineContainsAlias(alias));
            {
                varB4EAC82CA7396A68D541C85D26508E83_2088822935 = null;
            } 
        } 
        {
            boolean var3331921A37AE2FFC3485EFBB76E44677_1030033822 = (engineIsCertificateEntry(alias));
            {
                varB4EAC82CA7396A68D541C85D26508E83_37559937 = new KeyStore.TrustedCertificateEntry(
                    engineGetCertificate(alias));
            } 
        } 
        char[] passW = null;
        {
            {
                try 
                {
                    passW = ((KeyStore.PasswordProtection) protParam)
                            .getPassword();
                } 
                catch (IllegalStateException ee)
                {
                    if (DroidSafeAndroidRuntime.control) throw new KeyStoreException("Password was destroyed", ee);
                } 
            } 
            {
                passW = getPasswordFromCallBack(protParam);
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new UnrecoverableEntryException("ProtectionParameter object is not "
                                                      + "PasswordProtection: " + protParam);
            } 
        } 
        {
            boolean varC8D635291ED23140AD71444B2F09E907_1714745289 = (engineIsKeyEntry(alias));
            {
                Key key = engineGetKey(alias, passW);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1510855945 = new KeyStore.PrivateKeyEntry((PrivateKey) key,
                                                    engineGetCertificateChain(alias));
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1549697905 = new KeyStore.SecretKeyEntry((SecretKey) key);
                } 
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw new NoSuchAlgorithmException("Unknown KeyStore.Entry object");
        addTaint(alias.getTaint());
        addTaint(protParam.getTaint());
        KeyStore.Entry varA7E53CE21691AB073D9660D615818899_370529618; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_370529618 = varB4EAC82CA7396A68D541C85D26508E83_2088822935;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_370529618 = varB4EAC82CA7396A68D541C85D26508E83_37559937;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_370529618 = varB4EAC82CA7396A68D541C85D26508E83_1510855945;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_370529618 = varB4EAC82CA7396A68D541C85D26508E83_1549697905;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_370529618.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_370529618;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.357 -0400", hash_original_method = "3D4613712C6A1FF15305C05DDF5D1E0F", hash_generated_method = "80019630C852C9AEA951686BFC0A294F")
    public void engineSetEntry(String alias, KeyStore.Entry entry,
            KeyStore.ProtectionParameter protParam) throws KeyStoreException {
        {
            if (DroidSafeAndroidRuntime.control) throw new KeyStoreException("entry == null");
        } 
        {
            boolean var356966AF57386F220AA335774EF1D5B5_521367700 = (engineContainsAlias(alias));
            {
                engineDeleteEntry(alias);
            } 
        } 
        {
            KeyStore.TrustedCertificateEntry trE = (KeyStore.TrustedCertificateEntry) entry;
            engineSetCertificateEntry(alias, trE.getTrustedCertificate());
        } 
        char[] passW = null;
        {
            try 
            {
                passW = ((KeyStore.PasswordProtection) protParam).getPassword();
            } 
            catch (IllegalStateException ee)
            {
                if (DroidSafeAndroidRuntime.control) throw new KeyStoreException("Password was destroyed", ee);
            } 
        } 
        {
            {
                try 
                {
                    passW = getPasswordFromCallBack(protParam);
                } 
                catch (Exception e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new KeyStoreException(e);
                } 
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new KeyStoreException("protParam should be PasswordProtection or "
                                            + "CallbackHandlerProtection");
            } 
        } 
        {
            KeyStore.PrivateKeyEntry prE = (KeyStore.PrivateKeyEntry) entry;
            engineSetKeyEntry(alias, prE.getPrivateKey(), passW, prE
                    .getCertificateChain());
        } 
        {
            KeyStore.SecretKeyEntry skE = (KeyStore.SecretKeyEntry) entry;
            engineSetKeyEntry(alias, skE.getSecretKey(), passW, null);
        } 
        if (DroidSafeAndroidRuntime.control) throw new KeyStoreException("Entry object is neither PrivateKeyObject nor SecretKeyEntry "
                                    + "nor TrustedCertificateEntry: " + entry);
        addTaint(alias.getTaint());
        addTaint(entry.getTaint());
        addTaint(protParam.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.357 -0400", hash_original_method = "E646126BAF6D7B233BE960C73341BBD0", hash_generated_method = "FC8661237C3656EBCB1234414C927FA2")
    public boolean engineEntryInstanceOf(String alias,
            Class<? extends KeyStore.Entry> entryClass) {
        {
            boolean var5CDA5E3738B95D49C978F3282219AB9E_1103922550 = (!engineContainsAlias(alias));
        } 
        try 
        {
            {
                boolean var8FF0158E2A843FED52256D95A84AA871_923063044 = (engineIsCertificateEntry(alias));
                {
                    boolean varD6CC2852CBA1BA58ED0B285BA4B13848_1532356258 = (entryClass
                        .isAssignableFrom(Class
                                .forName("java.security.KeyStore$TrustedCertificateEntry")));
                } 
            } 
            {
                boolean var04F400450A38CB8A9AC0285F529D0D71_547518394 = (engineIsKeyEntry(alias));
                {
                    {
                        boolean var40AFCBC15E92F845EB44D55A7221C1FD_876589810 = (entryClass.isAssignableFrom(Class
                        .forName("java.security.KeyStore$PrivateKeyEntry")));
                        {
                            boolean var1D4CC438EDDF037AEC1A448A0CB5A59D_1161902013 = (engineGetCertificate(alias) != null);
                        } 
                    } 
                    {
                        boolean var4F6DF7ECC1F528257CAF7647CB20F355_74865305 = (entryClass.isAssignableFrom(Class
                        .forName("java.security.KeyStore$SecretKeyEntry")));
                        {
                            boolean varBBE742A5E059735C0A2505C4791C7481_201545849 = (engineGetCertificate(alias) == null);
                        } 
                    } 
                } 
            } 
        } 
        catch (ClassNotFoundException ignore)
        { }
        addTaint(alias.getTaint());
        addTaint(entryClass.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_114405827 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_114405827;
        
        
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

