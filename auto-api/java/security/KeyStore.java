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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.066 -0400", hash_original_field = "C782C54895459C90E5EA4E7F2619D282", hash_generated_field = "61D6D6330C8232E1AA65EEA11EE82DF2")

    private boolean isInit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.066 -0400", hash_original_field = "C34C5EA6575353773895CC2DFADD01F2", hash_generated_field = "B9C88BCACA85DB9C0AB124AA62DE8CAD")

    private KeyStoreSpi implSpi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.066 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.067 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.085 -0400", hash_original_method = "108D8AEC9F3364E92BCBB521C1482782", hash_generated_method = "43EAB562F81BE84BE93B196DD6366E9C")
    protected  KeyStore(KeyStoreSpi keyStoreSpi, Provider provider, String type) {
        this.type = type;
        this.provider = provider;
        this.implSpi = keyStoreSpi;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.089 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "7668447F15BAC831C9A976E37527CEDC")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_188718853 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_188718853 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_188718853.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_188718853;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.089 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "6B79D79090FC45560775BE89F3F23CFA")
    public final String getType() {
        String varB4EAC82CA7396A68D541C85D26508E83_862334434 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_862334434 = type;
        varB4EAC82CA7396A68D541C85D26508E83_862334434.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_862334434;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.091 -0400", hash_original_method = "F59E459BECAEDEBCB13476A41CDEA779", hash_generated_method = "5962D26A997E268C070FA2E3AEAD3826")
    public final Key getKey(String alias, char[] password) throws KeyStoreException, NoSuchAlgorithmException,
            UnrecoverableKeyException {
        Key varB4EAC82CA7396A68D541C85D26508E83_104713645 = null; //Variable for return #1
        {
            throwNotInitialized();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_104713645 = implSpi.engineGetKey(alias, password);
        addTaint(alias.getTaint());
        addTaint(password[0]);
        varB4EAC82CA7396A68D541C85D26508E83_104713645.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_104713645;
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineGetKey(alias, password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.114 -0400", hash_original_method = "504D1BEC6FF8E94C83F90A431D916244", hash_generated_method = "1C8448F5369FA06BA4437454E7D4CE86")
    public final Certificate[] getCertificateChain(String alias) throws KeyStoreException {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1189116151 = null; //Variable for return #1
        {
            throwNotInitialized();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1189116151 = implSpi.engineGetCertificateChain(alias);
        addTaint(alias.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1189116151.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1189116151;
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineGetCertificateChain(alias);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.115 -0400", hash_original_method = "7FA5F9282816EB62AB780CC8E8ACBC45", hash_generated_method = "C31D2BBF2DB7067C802CA5F816C3172B")
    public final Certificate getCertificate(String alias) throws KeyStoreException {
        Certificate varB4EAC82CA7396A68D541C85D26508E83_1023650169 = null; //Variable for return #1
        {
            throwNotInitialized();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1023650169 = implSpi.engineGetCertificate(alias);
        addTaint(alias.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1023650169.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1023650169;
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineGetCertificate(alias);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.115 -0400", hash_original_method = "0EAF8EB6AFEC620E9CCB79F4CF9FFE6B", hash_generated_method = "8E506E3F26689072939AAD8832FB6BA2")
    public final Date getCreationDate(String alias) throws KeyStoreException {
        Date varB4EAC82CA7396A68D541C85D26508E83_911159657 = null; //Variable for return #1
        {
            throwNotInitialized();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_911159657 = implSpi.engineGetCreationDate(alias);
        addTaint(alias.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_911159657.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_911159657;
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineGetCreationDate(alias);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.116 -0400", hash_original_method = "7F7563B0251ACD30AE23F02FDE0285F3", hash_generated_method = "633FB960F89EDA35A91DF7F6BEF5A950")
    public final void setKeyEntry(String alias, Key key, char[] password,
            Certificate[] chain) throws KeyStoreException {
        {
            throwNotInitialized();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Certificate chain is not defined for Private key");
        } //End block
        implSpi.engineSetKeyEntry(alias, key, password, chain);
        addTaint(alias.getTaint());
        addTaint(key.getTaint());
        addTaint(password[0]);
        addTaint(chain[0].getTaint());
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //if (key != null && key instanceof PrivateKey && (chain == null || chain.length == 0)) {
            //throw new IllegalArgumentException("Certificate chain is not defined for Private key");
        //}
        //implSpi.engineSetKeyEntry(alias, key, password, chain);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.116 -0400", hash_original_method = "E913EA9574669F2A71A3CC096B53E0CC", hash_generated_method = "652973E1BCE7AF16835519990E7CA564")
    public final void setKeyEntry(String alias, byte[] key, Certificate[] chain) throws KeyStoreException {
        {
            throwNotInitialized();
        } //End block
        implSpi.engineSetKeyEntry(alias, key, chain);
        addTaint(alias.getTaint());
        addTaint(key[0]);
        addTaint(chain[0].getTaint());
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //implSpi.engineSetKeyEntry(alias, key, chain);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.116 -0400", hash_original_method = "219C504E98378892F0A1CF69789298BA", hash_generated_method = "DC91878F95E18F042C53DB2778351223")
    public final void setCertificateEntry(String alias, Certificate cert) throws KeyStoreException {
        {
            throwNotInitialized();
        } //End block
        implSpi.engineSetCertificateEntry(alias, cert);
        addTaint(alias.getTaint());
        addTaint(cert.getTaint());
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //implSpi.engineSetCertificateEntry(alias, cert);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.120 -0400", hash_original_method = "D120E113CB97F6A9A6BAA6717070A8E9", hash_generated_method = "A4BCCD4B15D8D946CA2A5103E42504C4")
    public final void deleteEntry(String alias) throws KeyStoreException {
        {
            throwNotInitialized();
        } //End block
        implSpi.engineDeleteEntry(alias);
        addTaint(alias.getTaint());
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //implSpi.engineDeleteEntry(alias);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.140 -0400", hash_original_method = "E42AEF144F775210B33C3E2476EBCBA6", hash_generated_method = "81F6BFC1F1992DF433C04AD452231249")
    public final Enumeration<String> aliases() throws KeyStoreException {
        Enumeration<String> varB4EAC82CA7396A68D541C85D26508E83_903539489 = null; //Variable for return #1
        {
            throwNotInitialized();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_903539489 = implSpi.engineAliases();
        varB4EAC82CA7396A68D541C85D26508E83_903539489.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_903539489;
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineAliases();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.141 -0400", hash_original_method = "C6BE9F5B7D68857DC7838D988CC1BBA2", hash_generated_method = "6DAF66097FA00B927976AD60F210D587")
    public final boolean containsAlias(String alias) throws KeyStoreException {
        {
            throwNotInitialized();
        } //End block
        boolean varC74CBEA33D917A72A543D0A2B74AA83F_1436006787 = (implSpi.engineContainsAlias(alias));
        addTaint(alias.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2147162338 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2147162338;
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineContainsAlias(alias);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.141 -0400", hash_original_method = "0C5DF7CD9C11C1EDF698C182DE8DC09F", hash_generated_method = "EB313D5ABC6CF4F9A80CB65D7DD459C3")
    public final int size() throws KeyStoreException {
        {
            throwNotInitialized();
        } //End block
        int var990E02F085B0E698494A9E5D76EBD4FE_176949157 = (implSpi.engineSize());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_22917712 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_22917712;
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.148 -0400", hash_original_method = "BA6657A192671EAB1AD9A79410689C41", hash_generated_method = "7524060EF9462290A07B7927B82D3A8C")
    public final boolean isKeyEntry(String alias) throws KeyStoreException {
        {
            throwNotInitialized();
        } //End block
        boolean varCF4E372910B3A4B047D7B0F4F7409967_199158134 = (implSpi.engineIsKeyEntry(alias));
        addTaint(alias.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1046032235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1046032235;
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineIsKeyEntry(alias);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.148 -0400", hash_original_method = "1EB6026F3AFD92595C3B35AB93369F7A", hash_generated_method = "BA9B5ABC2DF5859019690DA8321176F2")
    public final boolean isCertificateEntry(String alias) throws KeyStoreException {
        {
            throwNotInitialized();
        } //End block
        boolean var641C83C37ECCCB11EF20F817F7B95E37_1605432664 = (implSpi.engineIsCertificateEntry(alias));
        addTaint(alias.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_285343030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_285343030;
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineIsCertificateEntry(alias);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.149 -0400", hash_original_method = "2386A451870E6EF1C02A8B8C98B7CB68", hash_generated_method = "DFA2ADA3178813CE69050CD5F0E08F29")
    public final String getCertificateAlias(Certificate cert) throws KeyStoreException {
        String varB4EAC82CA7396A68D541C85D26508E83_375658634 = null; //Variable for return #1
        {
            throwNotInitialized();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_375658634 = implSpi.engineGetCertificateAlias(cert);
        addTaint(cert.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_375658634.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_375658634;
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineGetCertificateAlias(cert);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.149 -0400", hash_original_method = "50BCB00A432CC31F15CE3B2C3DE7D43E", hash_generated_method = "C00F103C63C54D9E5BE941F7654D70BB")
    public final void store(OutputStream stream, char[] password) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        {
            throwNotInitialized();
        } //End block
        implSpi.engineStore(stream, password);
        addTaint(stream.getTaint());
        addTaint(password[0]);
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //implSpi.engineStore(stream, password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.152 -0400", hash_original_method = "C17746DBABB17F3EC34FB6DF10AE6233", hash_generated_method = "1248B7AD7B310752C5B8830D7AB5A8EE")
    public final void store(LoadStoreParameter param) throws KeyStoreException,
            IOException, NoSuchAlgorithmException, CertificateException {
        {
            throwNotInitialized();
        } //End block
        implSpi.engineStore(param);
        addTaint(param.getTaint());
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //implSpi.engineStore(param);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.152 -0400", hash_original_method = "E81C77E0001BACB83F4AF42B434C83C2", hash_generated_method = "DE142F9516F07B27754704A7D80E0C55")
    public final void load(InputStream stream, char[] password) throws IOException, NoSuchAlgorithmException, CertificateException {
        implSpi.engineLoad(stream, password);
        isInit = true;
        addTaint(stream.getTaint());
        addTaint(password[0]);
        // ---------- Original Method ----------
        //implSpi.engineLoad(stream, password);
        //isInit = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.152 -0400", hash_original_method = "C4F6682CFB8856C5C1A14F5939BD3C2A", hash_generated_method = "F76C2FAA395EC438C5299A463A952DFA")
    public final void load(LoadStoreParameter param) throws IOException,
            NoSuchAlgorithmException, CertificateException {
        implSpi.engineLoad(param);
        isInit = true;
        addTaint(param.getTaint());
        // ---------- Original Method ----------
        //implSpi.engineLoad(param);
        //isInit = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.153 -0400", hash_original_method = "545D5A95E5DE487291148190C6871E3B", hash_generated_method = "34C70EC50302060365925632E59E0215")
    public final Entry getEntry(String alias, ProtectionParameter param) throws NoSuchAlgorithmException, UnrecoverableEntryException, KeyStoreException {
        Entry varB4EAC82CA7396A68D541C85D26508E83_395635549 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("alias == null");
        } //End block
        {
            throwNotInitialized();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_395635549 = implSpi.engineGetEntry(alias, param);
        addTaint(alias.getTaint());
        addTaint(param.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_395635549.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_395635549;
        // ---------- Original Method ----------
        //if (alias == null) {
            //throw new NullPointerException("alias == null");
        //}
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineGetEntry(alias, param);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.153 -0400", hash_original_method = "1BFB042779188D83DA91333F58C1246D", hash_generated_method = "2A247B412EFA95C40D75B8200C28A1DE")
    public final void setEntry(String alias, Entry entry,
            ProtectionParameter param) throws KeyStoreException {
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
        addTaint(alias.getTaint());
        addTaint(entry.getTaint());
        addTaint(param.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.163 -0400", hash_original_method = "F0D9850AE080958F26BEB4963CD5F0EF", hash_generated_method = "87A130D1EFD5BA268C2A39D9CB9E8F85")
    public final boolean entryInstanceOf(String alias,
            Class<? extends KeyStore.Entry> entryClass) throws KeyStoreException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("alias == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("entryClass == null");
        } //End block
        {
            throwNotInitialized();
        } //End block
        boolean var559B701D25A2C05BEC5A34404B551992_471026240 = (implSpi.engineEntryInstanceOf(alias, entryClass));
        addTaint(alias.getTaint());
        addTaint(entryClass.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1599027930 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1599027930;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.163 -0400", hash_original_method = "7023F746232F077A36DCA003B1A512D2", hash_generated_method = "6A2D7D49B1C0B8CFA567F3789BFA22DC")
        protected  Builder() {
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
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.177 -0400", hash_original_field = "03EBA84192C9C0FA9DF5906D3DD5C0CB", hash_generated_field = "A7031BA8689424ABC672EAE318A6BC51")

            private KeyStore keyStore;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.177 -0400", hash_original_field = "28B4FDFE0932787489F9A5CB1BD15FDF", hash_generated_field = "38E327C8AA851ED0B0D5FA2FC9B4AA0F")

            private ProtectionParameter protParameter;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.177 -0400", hash_original_field = "D92332C3B81ED8752C1925085D51225F", hash_generated_field = "8AC37504A350A98951D869F1BEF2A368")

            private String typeForKeyStore;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.177 -0400", hash_original_field = "537998E96AE46AE6310C968FBE1D2EB5", hash_generated_field = "23FFFF4ED679110911D207F6B64A4AC8")

            private Provider providerForKeyStore;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.177 -0400", hash_original_field = "CF68ED5A69C2A61B832D150E2CA75AB8", hash_generated_field = "31C223C537F5C996C5DC6F1AB08A4D66")

            private File fileForLoad;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.178 -0400", hash_original_field = "B23482B70B9CFEA04E1D7A7F05EC5F77", hash_generated_field = "C3C0197C1266E33C5DA7A01BC63B802B")

            private boolean isGetKeyStore = false;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.178 -0400", hash_original_field = "64EF5C8ABF24BAE3BFD5ECB2A397E40D", hash_generated_field = "891CCD6D1168D0C98F10193D87BD26F3")

            private KeyStoreException lastException;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.178 -0400", hash_original_method = "3CD3C55013D5D374D36888ABFD4145EB", hash_generated_method = "A33DE3B99A825C2C1ED4DAF99C6BF9F8")
              BuilderImpl(KeyStore ks, ProtectionParameter pp, File file,
                        String type, Provider provider) {
                keyStore = ks;
                protParameter = pp;
                fileForLoad = file;
                typeForKeyStore = type;
                providerForKeyStore = provider;
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.185 -0400", hash_original_method = "ACF5EEE61FC6C7F04EA4DB97E46396E0", hash_generated_method = "B8D1C3F3E9AF8DD17A6496A737D32071")
            @Override
            public synchronized KeyStore getKeyStore() throws KeyStoreException {
                KeyStore varB4EAC82CA7396A68D541C85D26508E83_379572670 = null; //Variable for return #1
                KeyStore varB4EAC82CA7396A68D541C85D26508E83_592283757 = null; //Variable for return #2
                {
                    if (DroidSafeAndroidRuntime.control) throw lastException;
                } //End block
                {
                    isGetKeyStore = true;
                    varB4EAC82CA7396A68D541C85D26508E83_379572670 = keyStore;
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
                    varB4EAC82CA7396A68D541C85D26508E83_592283757 = ks;
                } //End block
                catch (KeyStoreException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw lastException = e;
                } //End block
                catch (Exception e)
                {
                    if (DroidSafeAndroidRuntime.control) throw lastException = new KeyStoreException(e);
                } //End block
                KeyStore varA7E53CE21691AB073D9660D615818899_81555295; //Final return value
                switch (DroidSafeAndroidRuntime.switchControl) {
                    case 1: //Assign result for return ordinal #1
                        varA7E53CE21691AB073D9660D615818899_81555295 = varB4EAC82CA7396A68D541C85D26508E83_379572670;
                        break;
                    default:
                        varA7E53CE21691AB073D9660D615818899_81555295 = varB4EAC82CA7396A68D541C85D26508E83_592283757;
                        break;
                }
                varA7E53CE21691AB073D9660D615818899_81555295.addTaint(getTaint()); //Add taint from parent
                return varA7E53CE21691AB073D9660D615818899_81555295;
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.197 -0400", hash_original_method = "061E86DD88FD52DC90E5A1CECB03A11C", hash_generated_method = "B78B2F49C8C4170E6AA8C825CA7E666E")
            @Override
            public synchronized ProtectionParameter getProtectionParameter(
                    String alias) throws KeyStoreException {
                ProtectionParameter varB4EAC82CA7396A68D541C85D26508E83_1404919824 = null; //Variable for return #1
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException("alias == null");
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("getKeyStore() was not invoked");
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1404919824 = protParameter;
                addTaint(alias.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1404919824.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1404919824;
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
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.198 -0400", hash_original_field = "C739078E771D861DBEF0EB493A5FE420", hash_generated_field = "1BB0FC91976F0354B54BD7DD6D315784")

            private ProtectionParameter protPar;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.198 -0400", hash_original_method = "418DF9EAB7B4417735B80C8244C9AAA5", hash_generated_method = "98B7F8D22C8521F8F173B8F76A0B9B73")
            public  TmpLSParameter(ProtectionParameter protPar) {
                this.protPar = protPar;
                // ---------- Original Method ----------
                //this.protPar = protPar;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.199 -0400", hash_original_method = "DB6A0984AE74C268B3C1D4EEBB473782", hash_generated_method = "A080CEA3E49177534435C161F0A76506")
            public ProtectionParameter getProtectionParameter() {
                ProtectionParameter varB4EAC82CA7396A68D541C85D26508E83_297515429 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_297515429 = protPar;
                varB4EAC82CA7396A68D541C85D26508E83_297515429.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_297515429;
                // ---------- Original Method ----------
                //return protPar;
            }

            
        }


        
    }


    
    public static class CallbackHandlerProtection implements ProtectionParameter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.199 -0400", hash_original_field = "D808088C31C730D5928506264C721705", hash_generated_field = "30CF87E450CC91F7899E85CF6B0C3092")

        private CallbackHandler callbackHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.200 -0400", hash_original_method = "082187234AF211B1FD0C2CCB255E95A4", hash_generated_method = "0A01A8B3F6222BB8E9EA4A632DE73D99")
        public  CallbackHandlerProtection(CallbackHandler handler) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("handler == null");
            } //End block
            this.callbackHandler = handler;
            // ---------- Original Method ----------
            //if (handler == null) {
                //throw new NullPointerException("handler == null");
            //}
            //this.callbackHandler = handler;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.200 -0400", hash_original_method = "0C642C7CCF2E4FDE3C3DD3C1F1B0C85D", hash_generated_method = "2D1E2A45DBA1D19D547C77DB1E66E88D")
        public CallbackHandler getCallbackHandler() {
            CallbackHandler varB4EAC82CA7396A68D541C85D26508E83_548799656 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_548799656 = callbackHandler;
            varB4EAC82CA7396A68D541C85D26508E83_548799656.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_548799656;
            // ---------- Original Method ----------
            //return callbackHandler;
        }

        
    }


    
    public static class PasswordProtection implements ProtectionParameter, Destroyable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.200 -0400", hash_original_field = "5F4DCC3B5AA765D61D8327DEB882CF99", hash_generated_field = "E9D3F141738563A4D1D32A99D6434F98")

        private char[] password;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.200 -0400", hash_original_field = "62C3ACC9F24922E928DD5D3C30174560", hash_generated_field = "4E9B5F95BF3CB214CC7936EEE230143C")

        private boolean isDestroyed = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.201 -0400", hash_original_method = "C494DBA0C69BF408259455310AC039E3", hash_generated_method = "E707ADAD1BD0B71968448E2D39AA95B9")
        public  PasswordProtection(char[] password) {
            {
                this.password = password.clone();
            } //End block
            // ---------- Original Method ----------
            //if (password != null) {
                //this.password = password.clone();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.208 -0400", hash_original_method = "6430A16E89645A8E6431B65352266760", hash_generated_method = "E82D76F6211C4F69EF35336B5AA8CA54")
        public synchronized char[] getPassword() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Password was destroyed");
            } //End block
            char[] var50607924ABD4C17119BAF3A1CE41C0EC_205197112 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_205197112;
            // ---------- Original Method ----------
            //if (isDestroyed) {
                //throw new IllegalStateException("Password was destroyed");
            //}
            //return password;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.209 -0400", hash_original_method = "F88C179D8B1E4290EAB43DF5D76D0F80", hash_generated_method = "367F9C659CA46FABF10FBD8093F88219")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.209 -0400", hash_original_method = "B936E1D4B92F105E0DF31A4819E36563", hash_generated_method = "99FC8B4BC5AC77F41E5717823F11BC5A")
        public synchronized boolean isDestroyed() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_734800860 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_734800860;
            // ---------- Original Method ----------
            //return isDestroyed;
        }

        
    }


    
    public static final class PrivateKeyEntry implements Entry {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.209 -0400", hash_original_field = "9951112F8DD2B0E52597C27197F1121C", hash_generated_field = "FE25B04A839309E9F85BB11D3AB28CB0")

        private Certificate[] chain;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.212 -0400", hash_original_field = "BD0C8E3BD998A500B0984584A7245CA0", hash_generated_field = "0BDA09A35A184B3500330A0D915760C1")

        private PrivateKey privateKey;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.225 -0400", hash_original_method = "AB76A830A9A2D95E963CA1BDB15D3DF1", hash_generated_method = "525F647DFF7D8387E13D4FF193885387")
        public  PrivateKeyEntry(PrivateKey privateKey, Certificate[] chain) {
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
                boolean varD47D9BD48CBBEB1F61FAB029BE03498A_889279372 = (!(chain[0].getPublicKey().getAlgorithm()).equals(privateKey.getAlgorithm()));
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
                        boolean var0ADF04894BC22313123047D072BB0C31_504907656 = (!s.equals(chain[i].getType()));
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
                Iterator<Certificate> varB335C8C1C3504C9C715374E281DA5D4A_535716776 = (chain).iterator();
                varB335C8C1C3504C9C715374E281DA5D4A_535716776.hasNext();
                Certificate cert = varB335C8C1C3504C9C715374E281DA5D4A_535716776.next();
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
            this.privateKey = privateKey;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.226 -0400", hash_original_method = "20D5E1BC38F4066008A03A45816FEC0F", hash_generated_method = "840EA457F5D5C3A002C6881693F8E9F0")
        public PrivateKey getPrivateKey() {
            PrivateKey varB4EAC82CA7396A68D541C85D26508E83_1480630003 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1480630003 = privateKey;
            varB4EAC82CA7396A68D541C85D26508E83_1480630003.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1480630003;
            // ---------- Original Method ----------
            //return privateKey;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.227 -0400", hash_original_method = "51F3F412A111F70F6F64117AFABD929B", hash_generated_method = "94197C9D8C2688BCAFDC39B01BCA90B0")
        public Certificate[] getCertificateChain() {
            Certificate[] varB4EAC82CA7396A68D541C85D26508E83_332972687 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_332972687 = chain.clone();
            varB4EAC82CA7396A68D541C85D26508E83_332972687.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_332972687;
            // ---------- Original Method ----------
            //return chain.clone();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.227 -0400", hash_original_method = "547F6E4E355F50070DC97734154D15F8", hash_generated_method = "B236083F7A3E2D6183DCBED7DA1D34F4")
        public Certificate getCertificate() {
            Certificate varB4EAC82CA7396A68D541C85D26508E83_739012744 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_739012744 = chain[0];
            varB4EAC82CA7396A68D541C85D26508E83_739012744.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_739012744;
            // ---------- Original Method ----------
            //return chain[0];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.229 -0400", hash_original_method = "D914F0EEEB01F1C9E1AEDB9A7E511AAE", hash_generated_method = "AEAA7775852B0B792078831303D0DE02")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_693215453 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_693215453 = sb.toString();
            varB4EAC82CA7396A68D541C85D26508E83_693215453.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_693215453;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.241 -0400", hash_original_field = "CE656850400574E9F9CFFB285EE8ABC0", hash_generated_field = "A5F456CD49483E3B0CB368BDF388AD8F")

        private SecretKey secretKey;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.241 -0400", hash_original_method = "F9E1B0F4E30BBF70203478C91D1B2E03", hash_generated_method = "0DD2D996AE565C6491934EF84D8C71D6")
        public  SecretKeyEntry(SecretKey secretKey) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("secretKey == null");
            } //End block
            this.secretKey = secretKey;
            // ---------- Original Method ----------
            //if (secretKey == null) {
                //throw new NullPointerException("secretKey == null");
            //}
            //this.secretKey = secretKey;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.242 -0400", hash_original_method = "086B5E46810BA78C7777CDD972BB99BA", hash_generated_method = "CC73B392B52040991AC462BD003662D6")
        public SecretKey getSecretKey() {
            SecretKey varB4EAC82CA7396A68D541C85D26508E83_1135198338 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1135198338 = secretKey;
            varB4EAC82CA7396A68D541C85D26508E83_1135198338.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1135198338;
            // ---------- Original Method ----------
            //return secretKey;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.242 -0400", hash_original_method = "55CC87C17B2642C3020CD374CFB01521", hash_generated_method = "5C46F0788274DBA3FB7909E71507DD72")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_2132539707 = null; //Variable for return #1
            StringBuilder sb;
            sb = new StringBuilder("SecretKeyEntry: algorithm - ");
            sb.append(secretKey.getAlgorithm());
            varB4EAC82CA7396A68D541C85D26508E83_2132539707 = sb.toString();
            varB4EAC82CA7396A68D541C85D26508E83_2132539707.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2132539707;
            // ---------- Original Method ----------
            //StringBuilder sb = new StringBuilder("SecretKeyEntry: algorithm - ");
            //sb.append(secretKey.getAlgorithm());
            //return sb.toString();
        }

        
    }


    
    public static final class TrustedCertificateEntry implements Entry {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.242 -0400", hash_original_field = "C3EC75C3A3A62518AF8A1F6DCC1605CA", hash_generated_field = "39224D52D2F645BDA1C3AA5572035EB1")

        private Certificate trustCertificate;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.246 -0400", hash_original_method = "78C27D1B59CEF64A7070E3BE7884B747", hash_generated_method = "8355D9AD10A9CF952526DB3DA9E1EDAB")
        public  TrustedCertificateEntry(Certificate trustCertificate) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("trustCertificate == null");
            } //End block
            this.trustCertificate = trustCertificate;
            // ---------- Original Method ----------
            //if (trustCertificate == null) {
                //throw new NullPointerException("trustCertificate == null");
            //}
            //this.trustCertificate = trustCertificate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.247 -0400", hash_original_method = "4E60EB3F26EAC182CAA181F2D2BA1C01", hash_generated_method = "7E175D37D5749F74010F35DD8548AAC8")
        public Certificate getTrustedCertificate() {
            Certificate varB4EAC82CA7396A68D541C85D26508E83_190070706 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_190070706 = trustCertificate;
            varB4EAC82CA7396A68D541C85D26508E83_190070706.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_190070706;
            // ---------- Original Method ----------
            //return trustCertificate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.254 -0400", hash_original_method = "706775B4BFB1342C7053CE6A0D4515B7", hash_generated_method = "7907DC53E4A7003C4DE36FB822EE3CAC")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_708519668 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_708519668 = "Trusted certificate entry:\n" + trustCertificate;
            varB4EAC82CA7396A68D541C85D26508E83_708519668.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_708519668;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.254 -0400", hash_original_field = "0B7D70EEC6320362AC6F3C21A0B0029F", hash_generated_field = "D836318422D3ACDBEA4FFF8FFAA388E2")

    private static String SERVICE = "KeyStore";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.254 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "82D6520D3C45D5046B0A4FDCEDAFF880")

    private static Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.254 -0400", hash_original_field = "DA00329109F7E9BC47D1C18DB2692312", hash_generated_field = "2C6A54B3911BECB16C41929819F7992E")

    private static String PROPERTYNAME = "keystore.type";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.254 -0400", hash_original_field = "936F88288140F6BAC34E08DA9BCADA92", hash_generated_field = "484521508AE39F2FDAF44FBD8C4A4D5F")

    private static String DEFAULT_KEYSTORE_TYPE = "jks";
}

