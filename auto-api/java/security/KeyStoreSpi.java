package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.377 -0400", hash_original_method = "B1B40C26BC4F072E721C19CFAF9DEE2E", hash_generated_method = "B1B40C26BC4F072E721C19CFAF9DEE2E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.379 -0400", hash_original_method = "2DD87D7240BCBB9F96BACA77A06CD528", hash_generated_method = "8922C4ED9D0FC3EE61ADF23D7799ED86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void engineStore(KeyStore.LoadStoreParameter param) throws IOException, NoSuchAlgorithmException, CertificateException {
        dsTaint.addTaint(param.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    public abstract void engineLoad(InputStream stream, char[] password)
            throws IOException, NoSuchAlgorithmException, CertificateException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.380 -0400", hash_original_method = "C2F8D415FB9276C7A503B37F207C6477", hash_generated_method = "76BD8847F068223B9A3EB7859C82BDD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void engineLoad(KeyStore.LoadStoreParameter param) throws IOException, NoSuchAlgorithmException, CertificateException {
        dsTaint.addTaint(param.dsTaint);
        {
            engineLoad(null, null);
        } //End block
        char[] pwd;
        KeyStore.ProtectionParameter pp;
        pp = param.getProtectionParameter();
        {
            try 
            {
                pwd = ((KeyStore.PasswordProtection) pp).getPassword();
                engineLoad(null, pwd);
            } //End block
            catch (IllegalStateException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(e);
            } //End block
        } //End block
        {
            try 
            {
                pwd = getPasswordFromCallBack(pp);
                engineLoad(null, pwd);
            } //End block
            catch (UnrecoverableEntryException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(e);
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("protectionParameter is neither PasswordProtection "
                                                + "nor CallbackHandlerProtection instance");
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.380 -0400", hash_original_method = "B68FB53D4042F1FDA8275FB481793ECB", hash_generated_method = "25C44BCF40CD671AAC459FC2B521D562")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public KeyStore.Entry engineGetEntry(String alias,
            KeyStore.ProtectionParameter protParam) throws KeyStoreException,
            NoSuchAlgorithmException, UnrecoverableEntryException {
        dsTaint.addTaint(alias);
        dsTaint.addTaint(protParam.dsTaint);
        {
            boolean var5CDA5E3738B95D49C978F3282219AB9E_640272417 = (!engineContainsAlias(alias));
        } //End collapsed parenthetic
        {
            boolean var3331921A37AE2FFC3485EFBB76E44677_1377035160 = (engineIsCertificateEntry(alias));
            {
                KeyStore.Entry var4C927AE8F5E279B9234331CCE06D2ABA_880867886 = (new KeyStore.TrustedCertificateEntry(
                    engineGetCertificate(alias)));
            } //End block
        } //End collapsed parenthetic
        char[] passW;
        passW = null;
        {
            {
                try 
                {
                    passW = ((KeyStore.PasswordProtection) protParam)
                            .getPassword();
                } //End block
                catch (IllegalStateException ee)
                {
                    if (DroidSafeAndroidRuntime.control) throw new KeyStoreException("Password was destroyed", ee);
                } //End block
            } //End block
            {
                passW = getPasswordFromCallBack(protParam);
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new UnrecoverableEntryException("ProtectionParameter object is not "
                                                      + "PasswordProtection: " + protParam);
            } //End block
        } //End block
        {
            boolean varC8D635291ED23140AD71444B2F09E907_1892412820 = (engineIsKeyEntry(alias));
            {
                Key key;
                key = engineGetKey(alias, passW);
                {
                    KeyStore.Entry var680C34AE821F17E315F12FBD2C38DDAA_1306800221 = (new KeyStore.PrivateKeyEntry((PrivateKey) key,
                                                    engineGetCertificateChain(alias)));
                } //End block
                {
                    KeyStore.Entry varB93F5EEEE71D38DCAA51BF9753C6740A_1648862308 = (new KeyStore.SecretKeyEntry((SecretKey) key));
                } //End block
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new NoSuchAlgorithmException("Unknown KeyStore.Entry object");
        return (KeyStore.Entry)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.381 -0400", hash_original_method = "3D4613712C6A1FF15305C05DDF5D1E0F", hash_generated_method = "A4A121684FC9AFD00DFAEA395B8C1339")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void engineSetEntry(String alias, KeyStore.Entry entry,
            KeyStore.ProtectionParameter protParam) throws KeyStoreException {
        dsTaint.addTaint(alias);
        dsTaint.addTaint(entry.dsTaint);
        dsTaint.addTaint(protParam.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new KeyStoreException("entry == null");
        } //End block
        {
            boolean var356966AF57386F220AA335774EF1D5B5_1286692065 = (engineContainsAlias(alias));
            {
                engineDeleteEntry(alias);
            } //End block
        } //End collapsed parenthetic
        {
            KeyStore.TrustedCertificateEntry trE;
            trE = (KeyStore.TrustedCertificateEntry) entry;
            engineSetCertificateEntry(alias, trE.getTrustedCertificate());
        } //End block
        char[] passW;
        passW = null;
        {
            try 
            {
                passW = ((KeyStore.PasswordProtection) protParam).getPassword();
            } //End block
            catch (IllegalStateException ee)
            {
                if (DroidSafeAndroidRuntime.control) throw new KeyStoreException("Password was destroyed", ee);
            } //End block
        } //End block
        {
            {
                try 
                {
                    passW = getPasswordFromCallBack(protParam);
                } //End block
                catch (Exception e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new KeyStoreException(e);
                } //End block
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new KeyStoreException("protParam should be PasswordProtection or "
                                            + "CallbackHandlerProtection");
            } //End block
        } //End block
        {
            KeyStore.PrivateKeyEntry prE;
            prE = (KeyStore.PrivateKeyEntry) entry;
            engineSetKeyEntry(alias, prE.getPrivateKey(), passW, prE
                    .getCertificateChain());
        } //End block
        {
            KeyStore.SecretKeyEntry skE;
            skE = (KeyStore.SecretKeyEntry) entry;
            engineSetKeyEntry(alias, skE.getSecretKey(), passW, null);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new KeyStoreException("Entry object is neither PrivateKeyObject nor SecretKeyEntry "
                                    + "nor TrustedCertificateEntry: " + entry);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.381 -0400", hash_original_method = "E646126BAF6D7B233BE960C73341BBD0", hash_generated_method = "0E5A5E0BEA0A6852F451101D124063AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean engineEntryInstanceOf(String alias,
            Class<? extends KeyStore.Entry> entryClass) {
        dsTaint.addTaint(alias);
        dsTaint.addTaint(entryClass.dsTaint);
        {
            boolean var5CDA5E3738B95D49C978F3282219AB9E_1108354000 = (!engineContainsAlias(alias));
        } //End collapsed parenthetic
        try 
        {
            {
                boolean var8FF0158E2A843FED52256D95A84AA871_64634962 = (engineIsCertificateEntry(alias));
                {
                    boolean varD6CC2852CBA1BA58ED0B285BA4B13848_1736915097 = (entryClass
                        .isAssignableFrom(Class
                                .forName("java.security.KeyStore$TrustedCertificateEntry")));
                } //End block
            } //End collapsed parenthetic
            {
                boolean var04F400450A38CB8A9AC0285F529D0D71_431032718 = (engineIsKeyEntry(alias));
                {
                    {
                        boolean var40AFCBC15E92F845EB44D55A7221C1FD_629864868 = (entryClass.isAssignableFrom(Class
                        .forName("java.security.KeyStore$PrivateKeyEntry")));
                        {
                            boolean var1D4CC438EDDF037AEC1A448A0CB5A59D_111554501 = (engineGetCertificate(alias) != null);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var4F6DF7ECC1F528257CAF7647CB20F355_985638919 = (entryClass.isAssignableFrom(Class
                        .forName("java.security.KeyStore$SecretKeyEntry")));
                        {
                            boolean varBBE742A5E059735C0A2505C4791C7481_137846024 = (engineGetCertificate(alias) == null);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (ClassNotFoundException ignore)
        { }
        return dsTaint.getTaintBoolean();
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

