package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import javax.crypto.SecretKey;
import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;
import javax.security.auth.callback.CallbackHandler;
import libcore.io.IoUtils;
import org.apache.harmony.security.fortress.Engine;

public class KeyStore {
    private boolean isInit;
    private KeyStoreSpi implSpi;
    private Provider provider;
    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.351 -0400", hash_original_method = "108D8AEC9F3364E92BCBB521C1482782", hash_generated_method = "1A2D8FC054235C19C8992E450835B13B")
    @DSModeled(DSC.SAFE)
    protected KeyStore(KeyStoreSpi keyStoreSpi, Provider provider, String type) {
        dsTaint.addTaint(keyStoreSpi.dsTaint);
        dsTaint.addTaint(provider.dsTaint);
        dsTaint.addTaint(type);
        isInit = false;
        // ---------- Original Method ----------
        //this.type = type;
        //this.provider = provider;
        //this.implSpi = keyStoreSpi;
        //isInit = false;
    }

    
        private static void throwNotInitialized() throws KeyStoreException {
        throw new KeyStoreException("KeyStore was not initialized");
    }

    
        public static KeyStore getInstance(String type) throws KeyStoreException {
        if (type == null) {
            throw new NullPointerException();
        }
        try {
            Engine.SpiAndProvider sap = ENGINE.getInstance(type, null);
            return new KeyStore((KeyStoreSpi) sap.spi, sap.provider, type);
        } catch (NoSuchAlgorithmException e) {
            throw new KeyStoreException(e);
        }
    }

    
        public static KeyStore getInstance(String type, String provider) throws KeyStoreException, NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider impProvider = Security.getProvider(provider);
        if (impProvider == null) {
            throw new NoSuchProviderException(provider);
        }
        try {
            return getInstance(type, impProvider);
        } catch (Exception e) {
            throw new KeyStoreException(e);
        }
    }

    
        public static KeyStore getInstance(String type, Provider provider) throws KeyStoreException {
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        if (type == null) {
            throw new NullPointerException();
        }
        try {
            Object spi = ENGINE.getInstance(type, provider, null);
            return new KeyStore((KeyStoreSpi) spi, provider, type);
        } catch (Exception e) {
            throw new KeyStoreException(e);
        }
    }

    
        public static final String getDefaultType() {
        String dt = Security.getProperty(PROPERTYNAME);
        return (dt == null ? DEFAULT_KEYSTORE_TYPE : dt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.352 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "828895F1878B3605546159F61AC099C2")
    @DSModeled(DSC.SAFE)
    public final Provider getProvider() {
        return (Provider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.352 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "2AE4CD67D4DDBE32BC864794C06C4464")
    @DSModeled(DSC.SAFE)
    public final String getType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.352 -0400", hash_original_method = "F59E459BECAEDEBCB13476A41CDEA779", hash_generated_method = "9BB204F956C4138F7D81C2CF3F9DDCBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Key getKey(String alias, char[] password) throws KeyStoreException, NoSuchAlgorithmException,
            UnrecoverableKeyException {
        dsTaint.addTaint(alias);
        dsTaint.addTaint(password[0]);
        {
            throwNotInitialized();
        } //End block
        Key varE29E832ABD0ADE00EB7E2BC02914B121_1067641068 = (implSpi.engineGetKey(alias, password));
        return (Key)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineGetKey(alias, password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.353 -0400", hash_original_method = "504D1BEC6FF8E94C83F90A431D916244", hash_generated_method = "3BF7D339BC1FE35FBA4F9591D2355231")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Certificate[] getCertificateChain(String alias) throws KeyStoreException {
        dsTaint.addTaint(alias);
        {
            throwNotInitialized();
        } //End block
        Certificate[] varB25BDDC17F20564FE6F794A1A9BCA7E2_711212529 = (implSpi.engineGetCertificateChain(alias));
        return (Certificate[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineGetCertificateChain(alias);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.353 -0400", hash_original_method = "7FA5F9282816EB62AB780CC8E8ACBC45", hash_generated_method = "98BBF2D566C72421086D1F73EE59E57A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Certificate getCertificate(String alias) throws KeyStoreException {
        dsTaint.addTaint(alias);
        {
            throwNotInitialized();
        } //End block
        Certificate varCCA765C8E02A2238DBA33D155D7EC64D_2118184435 = (implSpi.engineGetCertificate(alias));
        return (Certificate)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineGetCertificate(alias);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.353 -0400", hash_original_method = "0EAF8EB6AFEC620E9CCB79F4CF9FFE6B", hash_generated_method = "ED141B9C569BAB2332B09E505BF0230A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Date getCreationDate(String alias) throws KeyStoreException {
        dsTaint.addTaint(alias);
        {
            throwNotInitialized();
        } //End block
        Date var9645C1AEE2886AB6CD26E4077241C17E_1563823189 = (implSpi.engineGetCreationDate(alias));
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineGetCreationDate(alias);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.353 -0400", hash_original_method = "7F7563B0251ACD30AE23F02FDE0285F3", hash_generated_method = "6C571CED13334E9CAFA7391FB382257D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setKeyEntry(String alias, Key key, char[] password,
            Certificate[] chain) throws KeyStoreException {
        dsTaint.addTaint(chain[0].dsTaint);
        dsTaint.addTaint(alias);
        dsTaint.addTaint(password[0]);
        dsTaint.addTaint(key.dsTaint);
        {
            throwNotInitialized();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Certificate chain is not defined for Private key");
        } //End block
        implSpi.engineSetKeyEntry(alias, key, password, chain);
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //if (key != null && key instanceof PrivateKey && (chain == null || chain.length == 0)) {
            //throw new IllegalArgumentException("Certificate chain is not defined for Private key");
        //}
        //implSpi.engineSetKeyEntry(alias, key, password, chain);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.353 -0400", hash_original_method = "E913EA9574669F2A71A3CC096B53E0CC", hash_generated_method = "C4837BD53B78578B2748E87C30F2F94C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setKeyEntry(String alias, byte[] key, Certificate[] chain) throws KeyStoreException {
        dsTaint.addTaint(chain[0].dsTaint);
        dsTaint.addTaint(alias);
        dsTaint.addTaint(key[0]);
        {
            throwNotInitialized();
        } //End block
        implSpi.engineSetKeyEntry(alias, key, chain);
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //implSpi.engineSetKeyEntry(alias, key, chain);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.354 -0400", hash_original_method = "219C504E98378892F0A1CF69789298BA", hash_generated_method = "E634C139E0FA1BABBE761E02D55D06CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setCertificateEntry(String alias, Certificate cert) throws KeyStoreException {
        dsTaint.addTaint(cert.dsTaint);
        dsTaint.addTaint(alias);
        {
            throwNotInitialized();
        } //End block
        implSpi.engineSetCertificateEntry(alias, cert);
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //implSpi.engineSetCertificateEntry(alias, cert);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.354 -0400", hash_original_method = "D120E113CB97F6A9A6BAA6717070A8E9", hash_generated_method = "C0C55D98C5E0CD9CAE6844976F6BB4DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void deleteEntry(String alias) throws KeyStoreException {
        dsTaint.addTaint(alias);
        {
            throwNotInitialized();
        } //End block
        implSpi.engineDeleteEntry(alias);
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //implSpi.engineDeleteEntry(alias);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.354 -0400", hash_original_method = "E42AEF144F775210B33C3E2476EBCBA6", hash_generated_method = "A3174E5712BFF16270C19F76976A202E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Enumeration<String> aliases() throws KeyStoreException {
        {
            throwNotInitialized();
        } //End block
        Enumeration<String> varB9A45B4A153B796ABDCACC361F328A40_1701051367 = (implSpi.engineAliases());
        return (Enumeration<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineAliases();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.354 -0400", hash_original_method = "C6BE9F5B7D68857DC7838D988CC1BBA2", hash_generated_method = "3FBA19F26B0B7DD78685BF7A011FB1A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean containsAlias(String alias) throws KeyStoreException {
        dsTaint.addTaint(alias);
        {
            throwNotInitialized();
        } //End block
        boolean varC74CBEA33D917A72A543D0A2B74AA83F_1316836570 = (implSpi.engineContainsAlias(alias));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineContainsAlias(alias);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.354 -0400", hash_original_method = "0C5DF7CD9C11C1EDF698C182DE8DC09F", hash_generated_method = "B957A6AA626D168997DFC64A6BE932C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int size() throws KeyStoreException {
        {
            throwNotInitialized();
        } //End block
        int var990E02F085B0E698494A9E5D76EBD4FE_1750117476 = (implSpi.engineSize());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.354 -0400", hash_original_method = "BA6657A192671EAB1AD9A79410689C41", hash_generated_method = "E4CB70FF909DCBDFBB9FF12BDB4D6A9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isKeyEntry(String alias) throws KeyStoreException {
        dsTaint.addTaint(alias);
        {
            throwNotInitialized();
        } //End block
        boolean varCF4E372910B3A4B047D7B0F4F7409967_1725507262 = (implSpi.engineIsKeyEntry(alias));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineIsKeyEntry(alias);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.355 -0400", hash_original_method = "1EB6026F3AFD92595C3B35AB93369F7A", hash_generated_method = "6A370BA04819FFAD8BAD41E43C204651")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isCertificateEntry(String alias) throws KeyStoreException {
        dsTaint.addTaint(alias);
        {
            throwNotInitialized();
        } //End block
        boolean var641C83C37ECCCB11EF20F817F7B95E37_1952708019 = (implSpi.engineIsCertificateEntry(alias));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineIsCertificateEntry(alias);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.355 -0400", hash_original_method = "2386A451870E6EF1C02A8B8C98B7CB68", hash_generated_method = "A3731A9AC80C0C13F933B335CF545B9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getCertificateAlias(Certificate cert) throws KeyStoreException {
        dsTaint.addTaint(cert.dsTaint);
        {
            throwNotInitialized();
        } //End block
        String var6E481B71E16467DC9C2F545C1CE067CA_1532325042 = (implSpi.engineGetCertificateAlias(cert));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineGetCertificateAlias(cert);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.355 -0400", hash_original_method = "50BCB00A432CC31F15CE3B2C3DE7D43E", hash_generated_method = "20A11630809360D67BE305AD329927A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void store(OutputStream stream, char[] password) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        dsTaint.addTaint(stream.dsTaint);
        dsTaint.addTaint(password[0]);
        {
            throwNotInitialized();
        } //End block
        implSpi.engineStore(stream, password);
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //implSpi.engineStore(stream, password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.355 -0400", hash_original_method = "C17746DBABB17F3EC34FB6DF10AE6233", hash_generated_method = "13E8C51E99F4B1CE494379160C2288D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void store(LoadStoreParameter param) throws KeyStoreException,
            IOException, NoSuchAlgorithmException, CertificateException {
        dsTaint.addTaint(param.dsTaint);
        {
            throwNotInitialized();
        } //End block
        implSpi.engineStore(param);
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //implSpi.engineStore(param);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.355 -0400", hash_original_method = "E81C77E0001BACB83F4AF42B434C83C2", hash_generated_method = "F22C768518D5336A7664027ED1EC36E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void load(InputStream stream, char[] password) throws IOException, NoSuchAlgorithmException, CertificateException {
        dsTaint.addTaint(stream.dsTaint);
        dsTaint.addTaint(password[0]);
        implSpi.engineLoad(stream, password);
        isInit = true;
        // ---------- Original Method ----------
        //implSpi.engineLoad(stream, password);
        //isInit = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.355 -0400", hash_original_method = "C4F6682CFB8856C5C1A14F5939BD3C2A", hash_generated_method = "14DE1DCAEC110037693961FB4AB4A041")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void load(LoadStoreParameter param) throws IOException,
            NoSuchAlgorithmException, CertificateException {
        dsTaint.addTaint(param.dsTaint);
        implSpi.engineLoad(param);
        isInit = true;
        // ---------- Original Method ----------
        //implSpi.engineLoad(param);
        //isInit = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.356 -0400", hash_original_method = "545D5A95E5DE487291148190C6871E3B", hash_generated_method = "E35A67BF83619028A971E90C7D5435F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Entry getEntry(String alias, ProtectionParameter param) throws NoSuchAlgorithmException, UnrecoverableEntryException, KeyStoreException {
        dsTaint.addTaint(param.dsTaint);
        dsTaint.addTaint(alias);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("alias == null");
        } //End block
        {
            throwNotInitialized();
        } //End block
        Entry varAF35503C3C2600D6C295966C45301CDF_558901263 = (implSpi.engineGetEntry(alias, param));
        return (Entry)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (alias == null) {
            //throw new NullPointerException("alias == null");
        //}
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineGetEntry(alias, param);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.356 -0400", hash_original_method = "1BFB042779188D83DA91333F58C1246D", hash_generated_method = "774B8AE2F6BFBC6D75BFDE5015BA2B6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setEntry(String alias, Entry entry,
            ProtectionParameter param) throws KeyStoreException {
        dsTaint.addTaint(param.dsTaint);
        dsTaint.addTaint(alias);
        dsTaint.addTaint(entry.dsTaint);
        {
            throwNotInitialized();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("alias == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("entry == null");
        } //End block
        implSpi.engineSetEntry(alias, entry, param);
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //if (alias == null) {
            //throw new NullPointerException("alias == null");
        //}
        //if (entry == null) {
            //throw new NullPointerException("entry == null");
        //}
        //implSpi.engineSetEntry(alias, entry, param);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.356 -0400", hash_original_method = "F0D9850AE080958F26BEB4963CD5F0EF", hash_generated_method = "C7303568036E6F89911B8B99360ABBC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean entryInstanceOf(String alias,
            Class<? extends KeyStore.Entry> entryClass) throws KeyStoreException {
        dsTaint.addTaint(alias);
        dsTaint.addTaint(entryClass.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("alias == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("entryClass == null");
        } //End block
        {
            throwNotInitialized();
        } //End block
        boolean var559B701D25A2C05BEC5A34404B551992_503334887 = (implSpi.engineEntryInstanceOf(alias, entryClass));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (alias == null) {
            //throw new NullPointerException("alias == null");
        //}
        //if (entryClass == null) {
            //throw new NullPointerException("entryClass == null");
        //}
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineEntryInstanceOf(alias, entryClass);
    }

    
    public abstract static class Builder {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.356 -0400", hash_original_method = "7023F746232F077A36DCA003B1A512D2", hash_generated_method = "6A2D7D49B1C0B8CFA567F3789BFA22DC")
        @DSModeled(DSC.SAFE)
        protected Builder() {
            // ---------- Original Method ----------
        }

        
        public abstract KeyStore getKeyStore() throws KeyStoreException;

        
        public abstract ProtectionParameter getProtectionParameter(String alias)
                throws KeyStoreException;

        
                public static Builder newInstance(KeyStore keyStore,
                ProtectionParameter protectionParameter) {
            if (keyStore == null) {
                throw new NullPointerException("keyStore == null");
            }
            if (protectionParameter == null) {
                throw new NullPointerException("protectionParameter == null");
            }
            if (!keyStore.isInit) {
                throw new IllegalArgumentException("KeyStore was not initialized");
            }
            return new BuilderImpl(keyStore, protectionParameter, null, null, null);
        }

        
                public static Builder newInstance(String type, Provider provider,
                File file, ProtectionParameter protectionParameter) {
            if (type == null) {
                throw new NullPointerException("type == null");
            }
            if (protectionParameter == null) {
                throw new NullPointerException("protectionParameter == null");
            }
            if (file == null) {
                throw new NullPointerException("file == null");
            }
            if (!(protectionParameter instanceof PasswordProtection)
                    && !(protectionParameter instanceof CallbackHandlerProtection)) {
                throw new IllegalArgumentException("protectionParameter is neither "
                        + "PasswordProtection nor CallbackHandlerProtection instance");
            }
            if (!file.exists()) {
                throw new IllegalArgumentException("File does not exist: " + file.getName());
            }
            if (!file.isFile()) {
                throw new IllegalArgumentException("Not a regular file: " + file.getName());
            }
            return new BuilderImpl(null, protectionParameter, file, type, provider);
        }

        
                public static Builder newInstance(String type, Provider provider,
                ProtectionParameter protectionParameter) {
            if (type == null) {
                throw new NullPointerException("type == null");
            }
            if (protectionParameter == null) {
                throw new NullPointerException("protectionParameter == null");
            }
            return new BuilderImpl(null, protectionParameter, null, type, provider);
        }

        
        private static class BuilderImpl extends Builder {
            private KeyStore keyStore;
            private ProtectionParameter protParameter;
            private String typeForKeyStore;
            private Provider providerForKeyStore;
            private File fileForLoad;
            private boolean isGetKeyStore = false;
            private KeyStoreException lastException;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.357 -0400", hash_original_method = "3CD3C55013D5D374D36888ABFD4145EB", hash_generated_method = "0E87C477B250C34942DE1DE973CB8B0A")
            @DSModeled(DSC.SAFE)
             BuilderImpl(KeyStore ks, ProtectionParameter pp, File file,
                        String type, Provider provider) {
                dsTaint.addTaint(ks.dsTaint);
                dsTaint.addTaint(file.dsTaint);
                dsTaint.addTaint(provider.dsTaint);
                dsTaint.addTaint(type);
                dsTaint.addTaint(pp.dsTaint);
                isGetKeyStore = false;
                lastException = null;
                // ---------- Original Method ----------
                //keyStore = ks;
                //protParameter = pp;
                //fileForLoad = file;
                //typeForKeyStore = type;
                //providerForKeyStore = provider;
                //isGetKeyStore = false;
                //lastException = null;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.358 -0400", hash_original_method = "ACF5EEE61FC6C7F04EA4DB97E46396E0", hash_generated_method = "2DFFC04C273E2113F1B5959DB9EFCF29")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public synchronized KeyStore getKeyStore() throws KeyStoreException {
                {
                    if (DroidSafeAndroidRuntime.control) throw lastException;
                } //End block
                {
                    isGetKeyStore = true;
                } //End block
                try 
                {
                    KeyStore ks;
                    ks = (providerForKeyStore == null ? KeyStore
                            .getInstance(typeForKeyStore) : KeyStore
                            .getInstance(typeForKeyStore, providerForKeyStore));//DSFIXME:  CODE0008: Nested ternary operator in expression
                    char[] passwd;
                    {
                        passwd = ((PasswordProtection) protParameter)
                                .getPassword();
                    } //End block
                    {
                        passwd = KeyStoreSpi
                                .getPasswordFromCallBack(protParameter);
                    } //End block
                    {
                        if (DroidSafeAndroidRuntime.control) throw new KeyStoreException("protectionParameter is neither "
                                + "PasswordProtection nor CallbackHandlerProtection instance");
                    } //End block
                    {
                        FileInputStream fis;
                        fis = null;
                        try 
                        {
                            fis = new FileInputStream(fileForLoad);
                            ks.load(fis, passwd);
                        } //End block
                        finally 
                        {
                            IoUtils.closeQuietly(fis);
                        } //End block
                    } //End block
                    {
                        ks.load(new TmpLSParameter(protParameter));
                    } //End block
                    isGetKeyStore = true;
                } //End block
                catch (KeyStoreException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw lastException = e;
                } //End block
                catch (Exception e)
                {
                    if (DroidSafeAndroidRuntime.control) throw lastException = new KeyStoreException(e);
                } //End block
                return (KeyStore)dsTaint.getTaint();
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.358 -0400", hash_original_method = "061E86DD88FD52DC90E5A1CECB03A11C", hash_generated_method = "5B29D58EEFE86B3740D331E700AD9305")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public synchronized ProtectionParameter getProtectionParameter(
                    String alias) throws KeyStoreException {
                dsTaint.addTaint(alias);
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException("alias == null");
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("getKeyStore() was not invoked");
                } //End block
                return (ProtectionParameter)dsTaint.getTaint();
                // ---------- Original Method ----------
                //if (alias == null) {
                    //throw new NullPointerException("alias == null");
                //}
                //if (!isGetKeyStore) {
                    //throw new IllegalStateException("getKeyStore() was not invoked");
                //}
                //return protParameter;
            }

            
        }


        
        private static class TmpLSParameter implements LoadStoreParameter {
            private ProtectionParameter protPar;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.358 -0400", hash_original_method = "418DF9EAB7B4417735B80C8244C9AAA5", hash_generated_method = "51DFDB2138C4C66F893756B732246F94")
            @DSModeled(DSC.SAFE)
            public TmpLSParameter(ProtectionParameter protPar) {
                dsTaint.addTaint(protPar.dsTaint);
                // ---------- Original Method ----------
                //this.protPar = protPar;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.358 -0400", hash_original_method = "DB6A0984AE74C268B3C1D4EEBB473782", hash_generated_method = "9B5DF58DF5DB4A6903A1AD27F80FB742")
            @DSModeled(DSC.SAFE)
            public ProtectionParameter getProtectionParameter() {
                return (ProtectionParameter)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return protPar;
            }

            
        }


        
    }


    
    public static class CallbackHandlerProtection implements ProtectionParameter {
        private CallbackHandler callbackHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.358 -0400", hash_original_method = "082187234AF211B1FD0C2CCB255E95A4", hash_generated_method = "7FD3BBD38E23DD5FC87CBD8D960DC89B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CallbackHandlerProtection(CallbackHandler handler) {
            dsTaint.addTaint(handler.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("handler == null");
            } //End block
            // ---------- Original Method ----------
            //if (handler == null) {
                //throw new NullPointerException("handler == null");
            //}
            //this.callbackHandler = handler;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.359 -0400", hash_original_method = "0C642C7CCF2E4FDE3C3DD3C1F1B0C85D", hash_generated_method = "977CCC8ACAF786E6F9B438F3FF2B45DF")
        @DSModeled(DSC.SAFE)
        public CallbackHandler getCallbackHandler() {
            return (CallbackHandler)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return callbackHandler;
        }

        
    }


    
    public static class PasswordProtection implements ProtectionParameter, Destroyable {
        private char[] password;
        private boolean isDestroyed = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.359 -0400", hash_original_method = "C494DBA0C69BF408259455310AC039E3", hash_generated_method = "D202D683DE2DE8D76AF43A7BA120E225")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PasswordProtection(char[] password) {
            dsTaint.addTaint(password[0]);
            {
                this.password = password.clone();
            } //End block
            // ---------- Original Method ----------
            //if (password != null) {
                //this.password = password.clone();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.359 -0400", hash_original_method = "6430A16E89645A8E6431B65352266760", hash_generated_method = "3F0E2A43ED5F44E483485DD0D97F7A7C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized char[] getPassword() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Password was destroyed");
            } //End block
            char[] retVal = new char[1];
            retVal[0] = dsTaint.getTaintString().charAt(0);
            return retVal;
            // ---------- Original Method ----------
            //if (isDestroyed) {
                //throw new IllegalStateException("Password was destroyed");
            //}
            //return password;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.359 -0400", hash_original_method = "F88C179D8B1E4290EAB43DF5D76D0F80", hash_generated_method = "367F9C659CA46FABF10FBD8093F88219")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized void destroy() throws DestroyFailedException {
            isDestroyed = true;
            {
                Arrays.fill(password, '\u0000');
                password = null;
            } //End block
            // ---------- Original Method ----------
            //isDestroyed = true;
            //if (password != null) {
                //Arrays.fill(password, '\u0000');
                //password = null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.359 -0400", hash_original_method = "B936E1D4B92F105E0DF31A4819E36563", hash_generated_method = "D61920C29AE0CE08010C1AE8617CBB1F")
        @DSModeled(DSC.SAFE)
        public synchronized boolean isDestroyed() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return isDestroyed;
        }

        
    }


    
    public static final class PrivateKeyEntry implements Entry {
        private Certificate[] chain;
        private PrivateKey privateKey;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.360 -0400", hash_original_method = "AB76A830A9A2D95E963CA1BDB15D3DF1", hash_generated_method = "E90A57FC8FBC4A6214EEE76A1B6F3414")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PrivateKeyEntry(PrivateKey privateKey, Certificate[] chain) {
            dsTaint.addTaint(privateKey.dsTaint);
            dsTaint.addTaint(chain[0].dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("privateKey == null");
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("chain == null");
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("chain.length == 0");
            } //End block
            String s;
            s = chain[0].getType();
            {
                boolean varD47D9BD48CBBEB1F61FAB029BE03498A_1529726573 = (!(chain[0].getPublicKey().getAlgorithm()).equals(privateKey.getAlgorithm()));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Algorithm of private key does not match "
                        + "algorithm of public key in end certificate of entry "
                        + "(with index number: 0)");
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = 1;
                {
                    {
                        boolean var0ADF04894BC22313123047D072BB0C31_509826697 = (!s.equals(chain[i].getType()));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Certificates from the given chain have "
                                                       + "different types");
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            boolean isAllX509Certificates;
            isAllX509Certificates = true;
            {
                Iterator<Certificate> varB335C8C1C3504C9C715374E281DA5D4A_706271640 = (chain).iterator();
                varB335C8C1C3504C9C715374E281DA5D4A_706271640.hasNext();
                Certificate cert = varB335C8C1C3504C9C715374E281DA5D4A_706271640.next();
                {
                    {
                        isAllX509Certificates = false;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                this.chain = new X509Certificate[chain.length];
            } //End block
            {
                this.chain = new Certificate[chain.length];
            } //End block
            System.arraycopy(chain, 0, this.chain, 0, chain.length);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.361 -0400", hash_original_method = "20D5E1BC38F4066008A03A45816FEC0F", hash_generated_method = "6B1D3EF2480330998383E5B8CAA0B67C")
        @DSModeled(DSC.SAFE)
        public PrivateKey getPrivateKey() {
            return (PrivateKey)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return privateKey;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.361 -0400", hash_original_method = "51F3F412A111F70F6F64117AFABD929B", hash_generated_method = "97FB260FB4CEB2D946CBD416DE957A20")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Certificate[] getCertificateChain() {
            Certificate[] varE9073F5247C6AF16B18270B0E43D0546_1972818202 = (chain.clone());
            return (Certificate[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return chain.clone();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.361 -0400", hash_original_method = "547F6E4E355F50070DC97734154D15F8", hash_generated_method = "C61364B3D3EEAF79252CFAD3BAB53E93")
        @DSModeled(DSC.SAFE)
        public Certificate getCertificate() {
            return (Certificate)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return chain[0];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.361 -0400", hash_original_method = "D914F0EEEB01F1C9E1AEDB9A7E511AAE", hash_generated_method = "DF63CD9EC5C90FD6BF67B9A6D3D9EC12")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            StringBuilder sb;
            sb = new StringBuilder(
                    "PrivateKeyEntry: number of elements in certificate chain is ");
            sb.append(Integer.toString(chain.length));
            sb.append("\n");
            {
                int i;
                i = 0;
                {
                    sb.append(chain[i].toString());
                    sb.append("\n");
                } //End block
            } //End collapsed parenthetic
            String var01ED4A9DFA1C94365291AB096B854A7B_531963035 = (sb.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //StringBuilder sb = new StringBuilder(
                    //"PrivateKeyEntry: number of elements in certificate chain is ");
            //sb.append(Integer.toString(chain.length));
            //sb.append("\n");
            //for (int i = 0; i < chain.length; i++) {
                //sb.append(chain[i].toString());
                //sb.append("\n");
            //}
            //return sb.toString();
        }

        
    }


    
    public static final class SecretKeyEntry implements Entry {
        private SecretKey secretKey;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.361 -0400", hash_original_method = "F9E1B0F4E30BBF70203478C91D1B2E03", hash_generated_method = "972EA3C60A56DB8B2A56920DE46EDC5E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SecretKeyEntry(SecretKey secretKey) {
            dsTaint.addTaint(secretKey.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("secretKey == null");
            } //End block
            // ---------- Original Method ----------
            //if (secretKey == null) {
                //throw new NullPointerException("secretKey == null");
            //}
            //this.secretKey = secretKey;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.362 -0400", hash_original_method = "086B5E46810BA78C7777CDD972BB99BA", hash_generated_method = "AFB86ED7215B2A07628D8F696FFF97E5")
        @DSModeled(DSC.SAFE)
        public SecretKey getSecretKey() {
            return (SecretKey)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return secretKey;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.362 -0400", hash_original_method = "55CC87C17B2642C3020CD374CFB01521", hash_generated_method = "1532B2E7E1F7B9CDE17CFBE463041CD5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            StringBuilder sb;
            sb = new StringBuilder("SecretKeyEntry: algorithm - ");
            sb.append(secretKey.getAlgorithm());
            String var01ED4A9DFA1C94365291AB096B854A7B_432694475 = (sb.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //StringBuilder sb = new StringBuilder("SecretKeyEntry: algorithm - ");
            //sb.append(secretKey.getAlgorithm());
            //return sb.toString();
        }

        
    }


    
    public static final class TrustedCertificateEntry implements Entry {
        private Certificate trustCertificate;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.362 -0400", hash_original_method = "78C27D1B59CEF64A7070E3BE7884B747", hash_generated_method = "6E16DA1E0E122B71C7FFC0E796DE0BE3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public TrustedCertificateEntry(Certificate trustCertificate) {
            dsTaint.addTaint(trustCertificate.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("trustCertificate == null");
            } //End block
            // ---------- Original Method ----------
            //if (trustCertificate == null) {
                //throw new NullPointerException("trustCertificate == null");
            //}
            //this.trustCertificate = trustCertificate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.362 -0400", hash_original_method = "4E60EB3F26EAC182CAA181F2D2BA1C01", hash_generated_method = "FDA0FD88200BB5F8AC511AB205E5289B")
        @DSModeled(DSC.SAFE)
        public Certificate getTrustedCertificate() {
            return (Certificate)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return trustCertificate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.362 -0400", hash_original_method = "706775B4BFB1342C7053CE6A0D4515B7", hash_generated_method = "EB0B1D0A8444CAF8C27FB6083039A86E")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "Trusted certificate entry:\n" + trustCertificate;
        }

        
    }


    
    public static interface Entry {
    }
    
    public static interface LoadStoreParameter {
        
        public ProtectionParameter getProtectionParameter();
    }
    
    public static interface ProtectionParameter {
    }
    
    private static final String SERVICE = "KeyStore";
    private static final Engine ENGINE = new Engine(SERVICE);
    private static final String PROPERTYNAME = "keystore.type";
    private static final String DEFAULT_KEYSTORE_TYPE = "jks";
}

