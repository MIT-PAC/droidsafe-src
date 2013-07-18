package java.security;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.annotations.DSOverride;

public class KeyStore {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.001 -0400", hash_original_field = "C782C54895459C90E5EA4E7F2619D282", hash_generated_field = "61D6D6330C8232E1AA65EEA11EE82DF2")

    private boolean isInit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.001 -0400", hash_original_field = "C34C5EA6575353773895CC2DFADD01F2", hash_generated_field = "B9C88BCACA85DB9C0AB124AA62DE8CAD")

    private KeyStoreSpi implSpi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.001 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.001 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.002 -0400", hash_original_method = "108D8AEC9F3364E92BCBB521C1482782", hash_generated_method = "43EAB562F81BE84BE93B196DD6366E9C")
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.004 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "97D74B4D60932CF921E25EFA2B35AA7C")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_991343720 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_991343720.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_991343720;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.004 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "0CBFB7C45E9520E66AEDEC8F81E11631")
    public final String getType() {
String varC5B9F25B4EEAD3E8E2C33F9429204397_1270912175 =         type;
        varC5B9F25B4EEAD3E8E2C33F9429204397_1270912175.addTaint(taint);
        return varC5B9F25B4EEAD3E8E2C33F9429204397_1270912175;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.004 -0400", hash_original_method = "F59E459BECAEDEBCB13476A41CDEA779", hash_generated_method = "A8BA147375EA70A3D350760599881933")
    public final Key getKey(String alias, char[] password) throws KeyStoreException, NoSuchAlgorithmException,
            UnrecoverableKeyException {
        addTaint(password[0]);
        addTaint(alias.getTaint());
        if(!isInit)        
        {
            throwNotInitialized();
        } //End block
Key var22386E2414BBD1C9031BE4204BE576F1_664973306 =         implSpi.engineGetKey(alias, password);
        var22386E2414BBD1C9031BE4204BE576F1_664973306.addTaint(taint);
        return var22386E2414BBD1C9031BE4204BE576F1_664973306;
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineGetKey(alias, password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.005 -0400", hash_original_method = "504D1BEC6FF8E94C83F90A431D916244", hash_generated_method = "DC23365F80F60C9D0412A2ED228BC72F")
    public final Certificate[] getCertificateChain(String alias) throws KeyStoreException {
        addTaint(alias.getTaint());
        if(!isInit)        
        {
            throwNotInitialized();
        } //End block
Certificate[] varC7394969E6E4373B9A6832CF44A56F10_524198516 =         implSpi.engineGetCertificateChain(alias);
        varC7394969E6E4373B9A6832CF44A56F10_524198516.addTaint(taint);
        return varC7394969E6E4373B9A6832CF44A56F10_524198516;
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineGetCertificateChain(alias);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.005 -0400", hash_original_method = "7FA5F9282816EB62AB780CC8E8ACBC45", hash_generated_method = "9F9E75F2880A17FF456CF062E07F9C5B")
    public final Certificate getCertificate(String alias) throws KeyStoreException {
        addTaint(alias.getTaint());
        if(!isInit)        
        {
            throwNotInitialized();
        } //End block
Certificate var833CCAA86CBB384E871E474F89E2D680_1556446960 =         implSpi.engineGetCertificate(alias);
        var833CCAA86CBB384E871E474F89E2D680_1556446960.addTaint(taint);
        return var833CCAA86CBB384E871E474F89E2D680_1556446960;
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineGetCertificate(alias);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.005 -0400", hash_original_method = "0EAF8EB6AFEC620E9CCB79F4CF9FFE6B", hash_generated_method = "C2531AFBA84C79EBDCFD3E90F3988116")
    public final Date getCreationDate(String alias) throws KeyStoreException {
        addTaint(alias.getTaint());
        if(!isInit)        
        {
            throwNotInitialized();
        } //End block
Date var978EBB799D75BBFCEF16CE8A7B5F63A1_575797583 =         implSpi.engineGetCreationDate(alias);
        var978EBB799D75BBFCEF16CE8A7B5F63A1_575797583.addTaint(taint);
        return var978EBB799D75BBFCEF16CE8A7B5F63A1_575797583;
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineGetCreationDate(alias);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.006 -0400", hash_original_method = "7F7563B0251ACD30AE23F02FDE0285F3", hash_generated_method = "71CF6C6ECCC25685EA3B8C54E5433848")
    public final void setKeyEntry(String alias, Key key, char[] password,
            Certificate[] chain) throws KeyStoreException {
        addTaint(chain[0].getTaint());
        addTaint(password[0]);
        addTaint(key.getTaint());
        addTaint(alias.getTaint());
        if(!isInit)        
        {
            throwNotInitialized();
        } //End block
        if(key != null && key instanceof PrivateKey && (chain == null || chain.length == 0))        
        {
            IllegalArgumentException var73E899CD5FA102001EC69F37D46760E1_790249767 = new IllegalArgumentException("Certificate chain is not defined for Private key");
            var73E899CD5FA102001EC69F37D46760E1_790249767.addTaint(taint);
            throw var73E899CD5FA102001EC69F37D46760E1_790249767;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.007 -0400", hash_original_method = "E913EA9574669F2A71A3CC096B53E0CC", hash_generated_method = "1BF0D5A30336E7DF3867AA3CC801AFC9")
    public final void setKeyEntry(String alias, byte[] key, Certificate[] chain) throws KeyStoreException {
        addTaint(chain[0].getTaint());
        addTaint(key[0]);
        addTaint(alias.getTaint());
        if(!isInit)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.007 -0400", hash_original_method = "219C504E98378892F0A1CF69789298BA", hash_generated_method = "40A1CF7A595C345CD78B2A9636D9CE62")
    public final void setCertificateEntry(String alias, Certificate cert) throws KeyStoreException {
        addTaint(cert.getTaint());
        addTaint(alias.getTaint());
        if(!isInit)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.007 -0400", hash_original_method = "D120E113CB97F6A9A6BAA6717070A8E9", hash_generated_method = "C11E69B8678F6C6748AB3E61467BA3A6")
    public final void deleteEntry(String alias) throws KeyStoreException {
        addTaint(alias.getTaint());
        if(!isInit)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.008 -0400", hash_original_method = "E42AEF144F775210B33C3E2476EBCBA6", hash_generated_method = "5786F5F63399E0BEC3CE2BA1C9BF8E7B")
    public final Enumeration<String> aliases() throws KeyStoreException {
        if(!isInit)        
        {
            throwNotInitialized();
        } //End block
Enumeration<String> var85B6F664BD58B3CF4577E64A2AB90B50_1877496336 =         implSpi.engineAliases();
        var85B6F664BD58B3CF4577E64A2AB90B50_1877496336.addTaint(taint);
        return var85B6F664BD58B3CF4577E64A2AB90B50_1877496336;
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineAliases();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.008 -0400", hash_original_method = "C6BE9F5B7D68857DC7838D988CC1BBA2", hash_generated_method = "3F4D102D8891C41644D083AA519CC145")
    public final boolean containsAlias(String alias) throws KeyStoreException {
        addTaint(alias.getTaint());
        if(!isInit)        
        {
            throwNotInitialized();
        } //End block
        boolean varB46C777B08F224E16A7D856127FD564A_1598920355 = (implSpi.engineContainsAlias(alias));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_433570091 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_433570091;
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineContainsAlias(alias);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.008 -0400", hash_original_method = "0C5DF7CD9C11C1EDF698C182DE8DC09F", hash_generated_method = "2A3DB9CFA7C989880E1C49250B3C79C0")
    public final int size() throws KeyStoreException {
        if(!isInit)        
        {
            throwNotInitialized();
        } //End block
        int varE3BC275F4991B60CAD0D50FE94DFC047_534811800 = (implSpi.engineSize());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1510310417 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1510310417;
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.008 -0400", hash_original_method = "BA6657A192671EAB1AD9A79410689C41", hash_generated_method = "CD490002E4E5BF892BDFA6E5B7D7F728")
    public final boolean isKeyEntry(String alias) throws KeyStoreException {
        addTaint(alias.getTaint());
        if(!isInit)        
        {
            throwNotInitialized();
        } //End block
        boolean varE56149231F88A09AE157AA64C0ABBE65_504366231 = (implSpi.engineIsKeyEntry(alias));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_801484762 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_801484762;
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineIsKeyEntry(alias);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.008 -0400", hash_original_method = "1EB6026F3AFD92595C3B35AB93369F7A", hash_generated_method = "EE95A1B2F447C2CC3C76EDAA9119F46F")
    public final boolean isCertificateEntry(String alias) throws KeyStoreException {
        addTaint(alias.getTaint());
        if(!isInit)        
        {
            throwNotInitialized();
        } //End block
        boolean var4E95594686724AFB412B250F5330EEA2_858888952 = (implSpi.engineIsCertificateEntry(alias));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_349674799 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_349674799;
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineIsCertificateEntry(alias);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.009 -0400", hash_original_method = "2386A451870E6EF1C02A8B8C98B7CB68", hash_generated_method = "C54AFB4748DCFA60166EC3EE6D9B10D1")
    public final String getCertificateAlias(Certificate cert) throws KeyStoreException {
        addTaint(cert.getTaint());
        if(!isInit)        
        {
            throwNotInitialized();
        } //End block
String varE0168F4163D76C5D386E3314C17ABA86_787640960 =         implSpi.engineGetCertificateAlias(cert);
        varE0168F4163D76C5D386E3314C17ABA86_787640960.addTaint(taint);
        return varE0168F4163D76C5D386E3314C17ABA86_787640960;
        // ---------- Original Method ----------
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineGetCertificateAlias(cert);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.009 -0400", hash_original_method = "50BCB00A432CC31F15CE3B2C3DE7D43E", hash_generated_method = "5AE4CEA311AAA8EACDFBAFB770973281")
    public final void store(OutputStream stream, char[] password) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        addTaint(password[0]);
        addTaint(stream.getTaint());
        if(!isInit)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.009 -0400", hash_original_method = "C17746DBABB17F3EC34FB6DF10AE6233", hash_generated_method = "AFBE32289BBC498D00153EEAC0FB3DAD")
    public final void store(LoadStoreParameter param) throws KeyStoreException,
            IOException, NoSuchAlgorithmException, CertificateException {
        addTaint(param.getTaint());
        if(!isInit)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.009 -0400", hash_original_method = "E81C77E0001BACB83F4AF42B434C83C2", hash_generated_method = "978A59A0D58630ACCA9CB4045DF40E4B")
    public final void load(InputStream stream, char[] password) throws IOException, NoSuchAlgorithmException, CertificateException {
        addTaint(password[0]);
        addTaint(stream.getTaint());
        implSpi.engineLoad(stream, password);
        isInit = true;
        // ---------- Original Method ----------
        //implSpi.engineLoad(stream, password);
        //isInit = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.009 -0400", hash_original_method = "C4F6682CFB8856C5C1A14F5939BD3C2A", hash_generated_method = "390B826EC37D9C73290B63DADC1714BC")
    public final void load(LoadStoreParameter param) throws IOException,
            NoSuchAlgorithmException, CertificateException {
        addTaint(param.getTaint());
        implSpi.engineLoad(param);
        isInit = true;
        // ---------- Original Method ----------
        //implSpi.engineLoad(param);
        //isInit = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.009 -0400", hash_original_method = "545D5A95E5DE487291148190C6871E3B", hash_generated_method = "F2312424DDCAA4580D6D8B50D9439559")
    public final Entry getEntry(String alias, ProtectionParameter param) throws NoSuchAlgorithmException, UnrecoverableEntryException, KeyStoreException {
        addTaint(param.getTaint());
        addTaint(alias.getTaint());
        if(alias == null)        
        {
            NullPointerException varA41DA010B75092C1DC41FB26CB17ACAE_1558354293 = new NullPointerException("alias == null");
            varA41DA010B75092C1DC41FB26CB17ACAE_1558354293.addTaint(taint);
            throw varA41DA010B75092C1DC41FB26CB17ACAE_1558354293;
        } //End block
        if(!isInit)        
        {
            throwNotInitialized();
        } //End block
Entry var701895B2E8389D95272372ED4DA24D57_337376656 =         implSpi.engineGetEntry(alias, param);
        var701895B2E8389D95272372ED4DA24D57_337376656.addTaint(taint);
        return var701895B2E8389D95272372ED4DA24D57_337376656;
        // ---------- Original Method ----------
        //if (alias == null) {
            //throw new NullPointerException("alias == null");
        //}
        //if (!isInit) {
            //throwNotInitialized();
        //}
        //return implSpi.engineGetEntry(alias, param);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.010 -0400", hash_original_method = "1BFB042779188D83DA91333F58C1246D", hash_generated_method = "ECB81ED3217D632FDE24F9B2B4BF305C")
    public final void setEntry(String alias, Entry entry,
            ProtectionParameter param) throws KeyStoreException {
        addTaint(param.getTaint());
        addTaint(entry.getTaint());
        addTaint(alias.getTaint());
        if(!isInit)        
        {
            throwNotInitialized();
        } //End block
        if(alias == null)        
        {
            NullPointerException varA41DA010B75092C1DC41FB26CB17ACAE_1144161033 = new NullPointerException("alias == null");
            varA41DA010B75092C1DC41FB26CB17ACAE_1144161033.addTaint(taint);
            throw varA41DA010B75092C1DC41FB26CB17ACAE_1144161033;
        } //End block
        if(entry == null)        
        {
            NullPointerException varA1CA961276A9269464A9A0C7C21D8671_1935738228 = new NullPointerException("entry == null");
            varA1CA961276A9269464A9A0C7C21D8671_1935738228.addTaint(taint);
            throw varA1CA961276A9269464A9A0C7C21D8671_1935738228;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.010 -0400", hash_original_method = "F0D9850AE080958F26BEB4963CD5F0EF", hash_generated_method = "E1184717443DD5F46A860189CFDDCDD0")
    public final boolean entryInstanceOf(String alias,
            Class<? extends KeyStore.Entry> entryClass) throws KeyStoreException {
        addTaint(entryClass.getTaint());
        addTaint(alias.getTaint());
        if(alias == null)        
        {
            NullPointerException varA41DA010B75092C1DC41FB26CB17ACAE_1083856415 = new NullPointerException("alias == null");
            varA41DA010B75092C1DC41FB26CB17ACAE_1083856415.addTaint(taint);
            throw varA41DA010B75092C1DC41FB26CB17ACAE_1083856415;
        } //End block
        if(entryClass == null)        
        {
            NullPointerException var727F62F29CA470EB66CED6BA9E0BF92E_1813183193 = new NullPointerException("entryClass == null");
            var727F62F29CA470EB66CED6BA9E0BF92E_1813183193.addTaint(taint);
            throw var727F62F29CA470EB66CED6BA9E0BF92E_1813183193;
        } //End block
        if(!isInit)        
        {
            throwNotInitialized();
        } //End block
        boolean varA2C4D67D3CB30E4D68D58F7D632B334C_377006440 = (implSpi.engineEntryInstanceOf(alias, entryClass));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_367326436 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_367326436;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.010 -0400", hash_original_method = "7023F746232F077A36DCA003B1A512D2", hash_generated_method = "6A2D7D49B1C0B8CFA567F3789BFA22DC")
        protected  Builder() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        public abstract KeyStore getKeyStore() throws KeyStoreException;

        
        @DSModeled(DSC.SAFE)
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
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.011 -0400", hash_original_field = "03EBA84192C9C0FA9DF5906D3DD5C0CB", hash_generated_field = "A7031BA8689424ABC672EAE318A6BC51")

            private KeyStore keyStore;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.011 -0400", hash_original_field = "28B4FDFE0932787489F9A5CB1BD15FDF", hash_generated_field = "38E327C8AA851ED0B0D5FA2FC9B4AA0F")

            private ProtectionParameter protParameter;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.011 -0400", hash_original_field = "D92332C3B81ED8752C1925085D51225F", hash_generated_field = "8AC37504A350A98951D869F1BEF2A368")

            private String typeForKeyStore;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.012 -0400", hash_original_field = "537998E96AE46AE6310C968FBE1D2EB5", hash_generated_field = "23FFFF4ED679110911D207F6B64A4AC8")

            private Provider providerForKeyStore;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.012 -0400", hash_original_field = "CF68ED5A69C2A61B832D150E2CA75AB8", hash_generated_field = "31C223C537F5C996C5DC6F1AB08A4D66")

            private File fileForLoad;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.012 -0400", hash_original_field = "B23482B70B9CFEA04E1D7A7F05EC5F77", hash_generated_field = "C3C0197C1266E33C5DA7A01BC63B802B")

            private boolean isGetKeyStore = false;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.012 -0400", hash_original_field = "64EF5C8ABF24BAE3BFD5ECB2A397E40D", hash_generated_field = "891CCD6D1168D0C98F10193D87BD26F3")

            private KeyStoreException lastException;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.012 -0400", hash_original_method = "3CD3C55013D5D374D36888ABFD4145EB", hash_generated_method = "A33DE3B99A825C2C1ED4DAF99C6BF9F8")
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.040 -0400", hash_original_method = "ACF5EEE61FC6C7F04EA4DB97E46396E0", hash_generated_method = "1B08EB48D1014BB6066076FFB3F3D583")
            @DSOverride // easy throw pattern
            @Override
            public synchronized KeyStore getKeyStore() throws KeyStoreException {
    if(lastException != null)                
                {
                    lastException.addTaint(taint);
                    throw lastException;
                } //End block
    if(keyStore != null)                
                {
                    isGetKeyStore = true;
KeyStore varAE043FAC2ECABF7CB73EFBD5237554D7_1643818128 =                     keyStore;
                    varAE043FAC2ECABF7CB73EFBD5237554D7_1643818128.addTaint(taint);
                    return varAE043FAC2ECABF7CB73EFBD5237554D7_1643818128;
                } //End block
                try 
                {
                    final KeyStore ks = (providerForKeyStore == null ? KeyStore
                            .getInstance(typeForKeyStore) : KeyStore
                            .getInstance(typeForKeyStore, providerForKeyStore));
                    char[] passwd;
    if(protParameter instanceof PasswordProtection)                    
                    {
                        passwd = ((PasswordProtection) protParameter)
                                .getPassword();
                    } //End block
                    else
    if(protParameter instanceof CallbackHandlerProtection)                    
                    {
                        passwd = KeyStoreSpi
                                .getPasswordFromCallBack(protParameter);
                    } //End block
                    else
                    {
                        KeyStoreException varA7F1174C83806DE906A3FB4AABBE8047_711836833 = new KeyStoreException("protectionParameter is neither "
                                + "PasswordProtection nor CallbackHandlerProtection instance");
                        varA7F1174C83806DE906A3FB4AABBE8047_711836833.addTaint(taint);
                        throw varA7F1174C83806DE906A3FB4AABBE8047_711836833;
                    } //End block
    if(fileForLoad != null)                    
                    {
                        FileInputStream fis = null;
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
                    else
                    {
                        ks.load(new TmpLSParameter(protParameter));
                    } //End block
                    isGetKeyStore = true;
KeyStore var4EA107C714DD2FEC6BD5E5FECFE3866C_2057391778 =                     ks;
                    var4EA107C714DD2FEC6BD5E5FECFE3866C_2057391778.addTaint(taint);
                    return var4EA107C714DD2FEC6BD5E5FECFE3866C_2057391778;
                } //End block
                catch (KeyStoreException e)
                {
                	lastException = e;
                	e.addTaint(taint);
                    throw e;
                } //End block
                catch (Exception e)
                {
                    lastException = new KeyStoreException(e);
                    lastException.addTaint(taint);
                    throw lastException;
                } //End block
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.013 -0400", hash_original_method = "061E86DD88FD52DC90E5A1CECB03A11C", hash_generated_method = "C82F766DEEAF557DAAB1E74B2E8176C3")
            @Override
            public synchronized ProtectionParameter getProtectionParameter(
                    String alias) throws KeyStoreException {
                addTaint(alias.getTaint());
                if(alias == null)                
                {
                    NullPointerException varA41DA010B75092C1DC41FB26CB17ACAE_1074928221 = new NullPointerException("alias == null");
                    varA41DA010B75092C1DC41FB26CB17ACAE_1074928221.addTaint(taint);
                    throw varA41DA010B75092C1DC41FB26CB17ACAE_1074928221;
                } //End block
                if(!isGetKeyStore)                
                {
                    IllegalStateException var7F5978FFD43A929CE4A35794259530EC_332216197 = new IllegalStateException("getKeyStore() was not invoked");
                    var7F5978FFD43A929CE4A35794259530EC_332216197.addTaint(taint);
                    throw var7F5978FFD43A929CE4A35794259530EC_332216197;
                } //End block
ProtectionParameter var2316ED0B587143554FCBF2DD4DB7A565_678966893 =                 protParameter;
                var2316ED0B587143554FCBF2DD4DB7A565_678966893.addTaint(taint);
                return var2316ED0B587143554FCBF2DD4DB7A565_678966893;
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
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.013 -0400", hash_original_field = "C739078E771D861DBEF0EB493A5FE420", hash_generated_field = "1BB0FC91976F0354B54BD7DD6D315784")

            private ProtectionParameter protPar;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.013 -0400", hash_original_method = "418DF9EAB7B4417735B80C8244C9AAA5", hash_generated_method = "98B7F8D22C8521F8F173B8F76A0B9B73")
            public  TmpLSParameter(ProtectionParameter protPar) {
                this.protPar = protPar;
                // ---------- Original Method ----------
                //this.protPar = protPar;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.013 -0400", hash_original_method = "DB6A0984AE74C268B3C1D4EEBB473782", hash_generated_method = "AD7C8EE496857F3B158687E48F729E61")
            public ProtectionParameter getProtectionParameter() {
ProtectionParameter varB96525DB79F204E71157168F35C67FD8_1273559453 =                 protPar;
                varB96525DB79F204E71157168F35C67FD8_1273559453.addTaint(taint);
                return varB96525DB79F204E71157168F35C67FD8_1273559453;
                // ---------- Original Method ----------
                //return protPar;
            }

            
        }


        
    }


    
    public static class CallbackHandlerProtection implements ProtectionParameter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.013 -0400", hash_original_field = "D808088C31C730D5928506264C721705", hash_generated_field = "30CF87E450CC91F7899E85CF6B0C3092")

        private CallbackHandler callbackHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.013 -0400", hash_original_method = "082187234AF211B1FD0C2CCB255E95A4", hash_generated_method = "E167AAC35323F7C3F6A3BCC21CA72AD5")
        public  CallbackHandlerProtection(CallbackHandler handler) {
            if(handler == null)            
            {
                NullPointerException varD94467648DCE8F6C33B5B75FE7E11924_904487916 = new NullPointerException("handler == null");
                varD94467648DCE8F6C33B5B75FE7E11924_904487916.addTaint(taint);
                throw varD94467648DCE8F6C33B5B75FE7E11924_904487916;
            } //End block
            this.callbackHandler = handler;
            // ---------- Original Method ----------
            //if (handler == null) {
                //throw new NullPointerException("handler == null");
            //}
            //this.callbackHandler = handler;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.013 -0400", hash_original_method = "0C642C7CCF2E4FDE3C3DD3C1F1B0C85D", hash_generated_method = "350376EB663662A73B1007A7EEADDA2C")
        public CallbackHandler getCallbackHandler() {
CallbackHandler var227A5049B2A61D81DA13523544301401_882767775 =             callbackHandler;
            var227A5049B2A61D81DA13523544301401_882767775.addTaint(taint);
            return var227A5049B2A61D81DA13523544301401_882767775;
            // ---------- Original Method ----------
            //return callbackHandler;
        }

        
    }


    
    public static class PasswordProtection implements ProtectionParameter, Destroyable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.013 -0400", hash_original_field = "5F4DCC3B5AA765D61D8327DEB882CF99", hash_generated_field = "E9D3F141738563A4D1D32A99D6434F98")

        private char[] password;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.013 -0400", hash_original_field = "62C3ACC9F24922E928DD5D3C30174560", hash_generated_field = "4E9B5F95BF3CB214CC7936EEE230143C")

        private boolean isDestroyed = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.014 -0400", hash_original_method = "C494DBA0C69BF408259455310AC039E3", hash_generated_method = "7265AA72E53EB3EB870764FACBE6DCCD")
        public  PasswordProtection(char[] password) {
            if(password != null)            
            {
                this.password = password.clone();
            } //End block
            // ---------- Original Method ----------
            //if (password != null) {
                //this.password = password.clone();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.014 -0400", hash_original_method = "6430A16E89645A8E6431B65352266760", hash_generated_method = "A8FA6004F45973B4002C90C99DF9A74D")
        public synchronized char[] getPassword() {
            if(isDestroyed)            
            {
                IllegalStateException var677BDDDA023C08B39B835AB0EF4DDF05_739332307 = new IllegalStateException("Password was destroyed");
                var677BDDDA023C08B39B835AB0EF4DDF05_739332307.addTaint(taint);
                throw var677BDDDA023C08B39B835AB0EF4DDF05_739332307;
            } //End block
            char[] var5F4DCC3B5AA765D61D8327DEB882CF99_1679755400 = (password);
                        char[] var50607924ABD4C17119BAF3A1CE41C0EC_338767951 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_338767951;
            // ---------- Original Method ----------
            //if (isDestroyed) {
                //throw new IllegalStateException("Password was destroyed");
            //}
            //return password;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.014 -0400", hash_original_method = "F88C179D8B1E4290EAB43DF5D76D0F80", hash_generated_method = "901B91690F77F774A83DFBC50C5AA488")
        public synchronized void destroy() throws DestroyFailedException {
            isDestroyed = true;
            if(password != null)            
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.014 -0400", hash_original_method = "B936E1D4B92F105E0DF31A4819E36563", hash_generated_method = "4BF79E7525095984E98BC909BB524FF8")
        public synchronized boolean isDestroyed() {
            boolean var090F38A7DDDF192B3BA702F9AFFD747C_1304827632 = (isDestroyed);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1217058480 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1217058480;
            // ---------- Original Method ----------
            //return isDestroyed;
        }

        
    }


    
    public static final class PrivateKeyEntry implements Entry {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.014 -0400", hash_original_field = "9951112F8DD2B0E52597C27197F1121C", hash_generated_field = "FE25B04A839309E9F85BB11D3AB28CB0")

        private Certificate[] chain;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.014 -0400", hash_original_field = "BD0C8E3BD998A500B0984584A7245CA0", hash_generated_field = "0BDA09A35A184B3500330A0D915760C1")

        private PrivateKey privateKey;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.014 -0400", hash_original_method = "AB76A830A9A2D95E963CA1BDB15D3DF1", hash_generated_method = "A509C111BF55983BD44D12F332692924")
        public  PrivateKeyEntry(PrivateKey privateKey, Certificate[] chain) {
            if(privateKey == null)            
            {
                NullPointerException var27E1267D3AC66A31D766CED3F42F2404_1116380589 = new NullPointerException("privateKey == null");
                var27E1267D3AC66A31D766CED3F42F2404_1116380589.addTaint(taint);
                throw var27E1267D3AC66A31D766CED3F42F2404_1116380589;
            } //End block
            if(chain == null)            
            {
                NullPointerException var570EF4F5784BEEEBF1A7E8203D1902CF_1935645014 = new NullPointerException("chain == null");
                var570EF4F5784BEEEBF1A7E8203D1902CF_1935645014.addTaint(taint);
                throw var570EF4F5784BEEEBF1A7E8203D1902CF_1935645014;
            } //End block
            if(chain.length == 0)            
            {
                IllegalArgumentException varAC112B1AD00F20C60B703AACEBA6F5E7_1352403881 = new IllegalArgumentException("chain.length == 0");
                varAC112B1AD00F20C60B703AACEBA6F5E7_1352403881.addTaint(taint);
                throw varAC112B1AD00F20C60B703AACEBA6F5E7_1352403881;
            } //End block
            String s = chain[0].getType();
            if(!(chain[0].getPublicKey().getAlgorithm()).equals(privateKey.getAlgorithm()))            
            {
                IllegalArgumentException varA45E4E0F5F20C00E77222A9E4D749512_1105444780 = new IllegalArgumentException("Algorithm of private key does not match "
                        + "algorithm of public key in end certificate of entry "
                        + "(with index number: 0)");
                varA45E4E0F5F20C00E77222A9E4D749512_1105444780.addTaint(taint);
                throw varA45E4E0F5F20C00E77222A9E4D749512_1105444780;
            } //End block
for(int i = 1;i < chain.length;i++)
            {
                if(!s.equals(chain[i].getType()))                
                {
                    IllegalArgumentException varE90BA1D4A5233A00CECCC6769BF7EFC2_2025445621 = new IllegalArgumentException("Certificates from the given chain have "
                                                       + "different types");
                    varE90BA1D4A5233A00CECCC6769BF7EFC2_2025445621.addTaint(taint);
                    throw varE90BA1D4A5233A00CECCC6769BF7EFC2_2025445621;
                } //End block
            } //End block
            boolean isAllX509Certificates = true;
for(Certificate cert : chain)
            {
                if(!(cert instanceof X509Certificate))                
                {
                    isAllX509Certificates = false;
                    break;
                } //End block
            } //End block
            if(isAllX509Certificates)            
            {
                this.chain = new X509Certificate[chain.length];
            } //End block
            else
            {
                this.chain = new Certificate[chain.length];
            } //End block
            System.arraycopy(chain, 0, this.chain, 0, chain.length);
            this.privateKey = privateKey;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.015 -0400", hash_original_method = "20D5E1BC38F4066008A03A45816FEC0F", hash_generated_method = "46939A1C76D5431352EB21FA83296765")
        public PrivateKey getPrivateKey() {
PrivateKey varEAD85D869E43E7A2ADE031F4AAD29487_391004058 =             privateKey;
            varEAD85D869E43E7A2ADE031F4AAD29487_391004058.addTaint(taint);
            return varEAD85D869E43E7A2ADE031F4AAD29487_391004058;
            // ---------- Original Method ----------
            //return privateKey;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.015 -0400", hash_original_method = "51F3F412A111F70F6F64117AFABD929B", hash_generated_method = "2C2B036EE3BC228E22ED4C42C49ECBA5")
        public Certificate[] getCertificateChain() {
Certificate[] var1320DF02155D736EF045D6D8E640BC3B_1876335814 =             chain.clone();
            var1320DF02155D736EF045D6D8E640BC3B_1876335814.addTaint(taint);
            return var1320DF02155D736EF045D6D8E640BC3B_1876335814;
            // ---------- Original Method ----------
            //return chain.clone();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.015 -0400", hash_original_method = "547F6E4E355F50070DC97734154D15F8", hash_generated_method = "A5466A25A22295D565C1E96E0B8E6FC3")
        public Certificate getCertificate() {
Certificate var90F30F0A578C11244DA8D7946F97A693_794743009 =             chain[0];
            var90F30F0A578C11244DA8D7946F97A693_794743009.addTaint(taint);
            return var90F30F0A578C11244DA8D7946F97A693_794743009;
            // ---------- Original Method ----------
            //return chain[0];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.015 -0400", hash_original_method = "D914F0EEEB01F1C9E1AEDB9A7E511AAE", hash_generated_method = "A42A54B978ADAA9BF30DD0BE41C77E09")
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(
                    "PrivateKeyEntry: number of elements in certificate chain is ");
            sb.append(Integer.toString(chain.length));
            sb.append("\n");
for(int i = 0;i < chain.length;i++)
            {
                sb.append(chain[i].toString());
                sb.append("\n");
            } //End block
String var2460B846747F8B22185AD8BE722266A5_681339628 =             sb.toString();
            var2460B846747F8B22185AD8BE722266A5_681339628.addTaint(taint);
            return var2460B846747F8B22185AD8BE722266A5_681339628;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.015 -0400", hash_original_field = "CE656850400574E9F9CFFB285EE8ABC0", hash_generated_field = "A5F456CD49483E3B0CB368BDF388AD8F")

        private SecretKey secretKey;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.015 -0400", hash_original_method = "F9E1B0F4E30BBF70203478C91D1B2E03", hash_generated_method = "4AC5DC2CAB2AC6A8241AB1F300919972")
        public  SecretKeyEntry(SecretKey secretKey) {
            if(secretKey == null)            
            {
                NullPointerException varB8D39E9EC6643D0241032E0B0941D83C_451606455 = new NullPointerException("secretKey == null");
                varB8D39E9EC6643D0241032E0B0941D83C_451606455.addTaint(taint);
                throw varB8D39E9EC6643D0241032E0B0941D83C_451606455;
            } //End block
            this.secretKey = secretKey;
            // ---------- Original Method ----------
            //if (secretKey == null) {
                //throw new NullPointerException("secretKey == null");
            //}
            //this.secretKey = secretKey;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.015 -0400", hash_original_method = "086B5E46810BA78C7777CDD972BB99BA", hash_generated_method = "A961E1D5C671E15512BCF7364BFF2E7A")
        public SecretKey getSecretKey() {
SecretKey var120920E5150C15DE0AB193510B014067_585342303 =             secretKey;
            var120920E5150C15DE0AB193510B014067_585342303.addTaint(taint);
            return var120920E5150C15DE0AB193510B014067_585342303;
            // ---------- Original Method ----------
            //return secretKey;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.015 -0400", hash_original_method = "55CC87C17B2642C3020CD374CFB01521", hash_generated_method = "52C749783FB7AEF62320771090A1AD10")
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("SecretKeyEntry: algorithm - ");
            sb.append(secretKey.getAlgorithm());
String var2460B846747F8B22185AD8BE722266A5_1079878781 =             sb.toString();
            var2460B846747F8B22185AD8BE722266A5_1079878781.addTaint(taint);
            return var2460B846747F8B22185AD8BE722266A5_1079878781;
            // ---------- Original Method ----------
            //StringBuilder sb = new StringBuilder("SecretKeyEntry: algorithm - ");
            //sb.append(secretKey.getAlgorithm());
            //return sb.toString();
        }

        
    }


    
    public static final class TrustedCertificateEntry implements Entry {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.016 -0400", hash_original_field = "C3EC75C3A3A62518AF8A1F6DCC1605CA", hash_generated_field = "39224D52D2F645BDA1C3AA5572035EB1")

        private Certificate trustCertificate;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.016 -0400", hash_original_method = "78C27D1B59CEF64A7070E3BE7884B747", hash_generated_method = "37860EE72DCE3B3B23BDD21A31A3B604")
        public  TrustedCertificateEntry(Certificate trustCertificate) {
            if(trustCertificate == null)            
            {
                NullPointerException var30C801AE8E2B836B487877775BE4C7FD_1761729100 = new NullPointerException("trustCertificate == null");
                var30C801AE8E2B836B487877775BE4C7FD_1761729100.addTaint(taint);
                throw var30C801AE8E2B836B487877775BE4C7FD_1761729100;
            } //End block
            this.trustCertificate = trustCertificate;
            // ---------- Original Method ----------
            //if (trustCertificate == null) {
                //throw new NullPointerException("trustCertificate == null");
            //}
            //this.trustCertificate = trustCertificate;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.016 -0400", hash_original_method = "4E60EB3F26EAC182CAA181F2D2BA1C01", hash_generated_method = "B0363EF1FDAC2C35BA4B8F671FB34673")
        public Certificate getTrustedCertificate() {
Certificate var77F8F6B7E3870AD03BA1DE0AC584EB03_1522047028 =             trustCertificate;
            var77F8F6B7E3870AD03BA1DE0AC584EB03_1522047028.addTaint(taint);
            return var77F8F6B7E3870AD03BA1DE0AC584EB03_1522047028;
            // ---------- Original Method ----------
            //return trustCertificate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.016 -0400", hash_original_method = "706775B4BFB1342C7053CE6A0D4515B7", hash_generated_method = "5781D80658978D5BC08DA6F7FFDD8E8A")
        @Override
        public String toString() {
String var359A1FE7677830BCE57680B7AC142941_862025411 =             "Trusted certificate entry:\n" + trustCertificate;
            var359A1FE7677830BCE57680B7AC142941_862025411.addTaint(taint);
            return var359A1FE7677830BCE57680B7AC142941_862025411;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.016 -0400", hash_original_field = "0B7D70EEC6320362AC6F3C21A0B0029F", hash_generated_field = "E9C51D7447E3CF538E5351AFCABA1B21")

    private static final String SERVICE = "KeyStore";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.016 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.016 -0400", hash_original_field = "DA00329109F7E9BC47D1C18DB2692312", hash_generated_field = "F40EF245477C1F166A1B8FCA4EAD1609")

    private static final String PROPERTYNAME = "keystore.type";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.016 -0400", hash_original_field = "936F88288140F6BAC34E08DA9BCADA92", hash_generated_field = "E2A356F03BA9C258737A10C161C6A401")

    private static final String DEFAULT_KEYSTORE_TYPE = "jks";
}

