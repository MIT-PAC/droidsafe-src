package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Set;
import org.apache.harmony.crypto.internal.NullCipherSpi;
import org.apache.harmony.security.fortress.Engine;

public class Cipher {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.989 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "D6093ADED541044A414FEED81979F5E2")

    private int mode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.989 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.989 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "609F6DC57B3704B1B8111A24F710F199")

    private CipherSpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.989 -0400", hash_original_field = "3935F8FEEE087B4547DE27296EC777B9", hash_generated_field = "2B831647F5B0DC5F72250AEA4C817CDC")

    private String transformation;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.990 -0400", hash_original_method = "169E8725E31AA026BEEB43CC41C0DB25", hash_generated_method = "B05BA09447ED428EFE97C4A24173D5B2")
    protected  Cipher(CipherSpi cipherSpi, Provider provider,
            String transformation) {
        if(cipherSpi == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_777501281 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_777501281.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_777501281;
        } //End block
        if(!(cipherSpi instanceof NullCipherSpi) && provider == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1712512736 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1712512736.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1712512736;
        } //End block
        this.provider = provider;
        this.transformation = transformation;
        this.spiImpl = cipherSpi;
        // ---------- Original Method ----------
        //if (cipherSpi == null) {
            //throw new NullPointerException();
        //}
        //if (!(cipherSpi instanceof NullCipherSpi) && provider == null) {
            //throw new NullPointerException();
        //}
        //this.provider = provider;
        //this.transformation = transformation;
        //this.spiImpl = cipherSpi;
    }

    
    public static final Cipher getInstance(String transformation) throws NoSuchAlgorithmException, NoSuchPaddingException {
        return getCipher(transformation, null);
    }

    
    public static final Cipher getInstance(String transformation,
            String provider) throws NoSuchAlgorithmException,
            NoSuchProviderException, NoSuchPaddingException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        Provider p = Security.getProvider(provider);
        if (p == null) {
            throw new NoSuchProviderException("Provider not available: " + provider);
        }
        return getInstance(transformation, p);
    }

    
    public static final Cipher getInstance(String transformation,
            Provider provider) throws NoSuchAlgorithmException,
            NoSuchPaddingException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        Cipher c = getCipher(transformation, provider);
        return c;
    }

    
    private static NoSuchAlgorithmException invalidTransformation(String transformation) throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException("Invalid transformation: " + transformation);
    }

    
    private static synchronized Cipher getCipher(String transformation, Provider provider) throws NoSuchAlgorithmException, NoSuchPaddingException {
        if (transformation == null || transformation.isEmpty()) {
            throw invalidTransformation(transformation);
        }
        String[] transf = checkTransformation(transformation);
        boolean needSetPadding = false;
        boolean needSetMode = false;
        Object engineSpi = null;
        Provider engineProvider = provider;
        if (transf[1] == null && transf[2] == null) { 
            if (provider == null) {
                Engine.SpiAndProvider sap = ENGINE.getInstance(transf[0], null);
                engineSpi = sap.spi;
                engineProvider = sap.provider;
            } else {
                engineSpi = ENGINE.getInstance(transf[0], provider, null);
            }
        } else {
            String[] searchOrder = {
                transf[0] + "/" + transf[1] + "/" + transf[2], 
                transf[0] + "/" + transf[1], 
                transf[0] + "//" + transf[2], 
                transf[0] 
            };
            int i;
            for (i = 0; i < searchOrder.length; i++) {
                try {
                    if (provider == null) {
                        Engine.SpiAndProvider sap = ENGINE.getInstance(searchOrder[i], null);
                        engineSpi = sap.spi;
                        engineProvider = sap.provider;
                    } else {
                        engineSpi = ENGINE.getInstance(searchOrder[i], provider, null);
                    }
                    break;
                } catch (NoSuchAlgorithmException e) {
                    if (i == searchOrder.length-1) {
                        throw new NoSuchAlgorithmException(transformation, e);
                    }
                }
            }
            switch (i) {
                case 1: 
                    needSetPadding = true;
                    break;
                case 2: 
                    needSetMode = true;
                    break;
                case 3: 
                    needSetPadding = true;
                    needSetMode = true;
            }
        }
        if (engineSpi == null || engineProvider == null) {
            throw new NoSuchAlgorithmException(transformation);
        }
        if (!(engineSpi instanceof CipherSpi)) {
            throw new NoSuchAlgorithmException(engineSpi.getClass().getName());
        }
        CipherSpi cspi = (CipherSpi) engineSpi;
        Cipher c = new Cipher(cspi, engineProvider, transformation);
        if (needSetMode) {
            c.spiImpl.engineSetMode(transf[1]);
        }
        if (needSetPadding) {
            c.spiImpl.engineSetPadding(transf[2]);
        }
        return c;
    }

    
    private static String[] checkTransformation(String transformation) throws NoSuchAlgorithmException {
        if (transformation.startsWith("/")) {
            transformation = transformation.substring(1);
        }
        String[] pieces = transformation.split("/");
        if (pieces.length > 3) {
            throw invalidTransformation(transformation);
        }
        String[] result = new String[3];
        for (int i = 0; i < pieces.length; ++i) {
            String piece = pieces[i].trim();
            if (!piece.isEmpty()) {
                result[i] = piece;
            }
        }
        if (result[0] == null) {
            throw invalidTransformation(transformation);
        }
        if (!(result[1] == null && result[2] == null) && (result[1] == null || result[2] == null)) {
            throw invalidTransformation(transformation);
        }
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.992 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "96792F8E1B67739CF403DFCF1ADB46B7")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_177358375 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_177358375.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_177358375;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.992 -0400", hash_original_method = "8DF6BCF87B142C85CC5BB8E6263E3718", hash_generated_method = "D7AB71403B9C23A122B56659FBC90817")
    public final String getAlgorithm() {
String var6472AF3EC4810156446ED9616CC1EE8E_1198396030 =         transformation;
        var6472AF3EC4810156446ED9616CC1EE8E_1198396030.addTaint(taint);
        return var6472AF3EC4810156446ED9616CC1EE8E_1198396030;
        // ---------- Original Method ----------
        //return transformation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.992 -0400", hash_original_method = "D9E2BEA1F59A5109A8382C65AF7F31D0", hash_generated_method = "131488281E08FD856FED0DFB75646BEB")
    public final int getBlockSize() {
        int var45465D5DC9BEC9FECC52A032FA1F16D6_1556458036 = (spiImpl.engineGetBlockSize());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1604988978 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1604988978;
        // ---------- Original Method ----------
        //return spiImpl.engineGetBlockSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.993 -0400", hash_original_method = "AA8C5558649103E88A25D53E8218E1F5", hash_generated_method = "F58DF4198942097B10E31CE7DF93200C")
    public final int getOutputSize(int inputLen) {
        addTaint(inputLen);
        if(mode == 0)        
        {
            IllegalStateException var63B7668973C20A74990D779B455ADF9E_1065195444 = new IllegalStateException("Cipher has not yet been initialized");
            var63B7668973C20A74990D779B455ADF9E_1065195444.addTaint(taint);
            throw var63B7668973C20A74990D779B455ADF9E_1065195444;
        } //End block
        int var32BCD9DDCCA7AD94E055443B55C28727_93761027 = (spiImpl.engineGetOutputSize(inputLen));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1679140305 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1679140305;
        // ---------- Original Method ----------
        //if (mode == 0) {
            //throw new IllegalStateException("Cipher has not yet been initialized");
        //}
        //return spiImpl.engineGetOutputSize(inputLen);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.993 -0400", hash_original_method = "99DAD5FABE956FC53B6CC59AB3BC8215", hash_generated_method = "95E139449A166E27E9A9054D9AA7C0B0")
    public final byte[] getIV() {
        byte[] varE5F6887C529E3E0CA3FBCCADA885FC6B_271257408 = (spiImpl.engineGetIV());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1869372439 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1869372439;
        // ---------- Original Method ----------
        //return spiImpl.engineGetIV();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.993 -0400", hash_original_method = "1EF273790A635FFB8595723F2B2D47C7", hash_generated_method = "781D465EA74F05C8AC1037EFF38FD35A")
    public final AlgorithmParameters getParameters() {
AlgorithmParameters varDDF010DE7E5B16986942A6D470695726_1572153909 =         spiImpl.engineGetParameters();
        varDDF010DE7E5B16986942A6D470695726_1572153909.addTaint(taint);
        return varDDF010DE7E5B16986942A6D470695726_1572153909;
        // ---------- Original Method ----------
        //return spiImpl.engineGetParameters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.993 -0400", hash_original_method = "8BD6E3BF151C3D35A58DA717088B655C", hash_generated_method = "FEF079763938CCDFDB34B983A966A20A")
    public final ExemptionMechanism getExemptionMechanism() {
ExemptionMechanism var540C13E9E156B687226421B24F2DF178_540801893 =         null;
        var540C13E9E156B687226421B24F2DF178_540801893.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_540801893;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.993 -0400", hash_original_method = "429E4D2BD5B61AF47430304468140423", hash_generated_method = "A53648B1A5A6390529F392A2C6D436BB")
    public final void init(int opmode, Key key) throws InvalidKeyException {
        addTaint(key.getTaint());
        addTaint(opmode);
        if(secureRandom == null)        
        {
            secureRandom = new SecureRandom();
        } //End block
        init(opmode, key, secureRandom);
        // ---------- Original Method ----------
        //if (secureRandom == null) {
            //secureRandom = new SecureRandom();
        //}
        //init(opmode, key, secureRandom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.993 -0400", hash_original_method = "0BCC9283EB770D83968E2D5392900813", hash_generated_method = "FE70452A34DB88E3DA3903253EE198C4")
    public final void init(int opmode, Key key, SecureRandom random) throws InvalidKeyException {
        addTaint(random.getTaint());
        addTaint(key.getTaint());
        checkMode(opmode);
        spiImpl.engineInit(opmode, key, random);
        mode = opmode;
        // ---------- Original Method ----------
        //checkMode(opmode);
        //spiImpl.engineInit(opmode, key, random);
        //mode = opmode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.994 -0400", hash_original_method = "09F21B40649178B5CD7EDFF6A1F24869", hash_generated_method = "CE46253524713CFAF3D98EB67FB2FD7F")
    private void checkMode(int mode) {
        addTaint(mode);
        if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE
            && mode != UNWRAP_MODE && mode != WRAP_MODE)        
        {
            InvalidParameterException varDEB5BE7797F8E1BF880BE2B8FD8FE549_1712590488 = new InvalidParameterException("Invalid mode: " + mode);
            varDEB5BE7797F8E1BF880BE2B8FD8FE549_1712590488.addTaint(taint);
            throw varDEB5BE7797F8E1BF880BE2B8FD8FE549_1712590488;
        } //End block
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE
            //&& mode != UNWRAP_MODE && mode != WRAP_MODE) {
            //throw new InvalidParameterException("Invalid mode: " + mode);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.994 -0400", hash_original_method = "BBC8C1A41A2EA4CA6303B616FCC7D14B", hash_generated_method = "AF7D35ADF82EA5CCADDAD7ABA4A8462F")
    public final void init(int opmode, Key key, AlgorithmParameterSpec params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        addTaint(params.getTaint());
        addTaint(key.getTaint());
        addTaint(opmode);
        if(secureRandom == null)        
        {
            secureRandom = new SecureRandom();
        } //End block
        init(opmode, key, params, secureRandom);
        // ---------- Original Method ----------
        //if (secureRandom == null) {
            //secureRandom = new SecureRandom();
        //}
        //init(opmode, key, params, secureRandom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.994 -0400", hash_original_method = "8E7DC73E6E4E585B73E6EA7E879FC58B", hash_generated_method = "4BE0E12A2EC974CD397827A7111246A7")
    public final void init(int opmode, Key key, AlgorithmParameterSpec params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException {
        addTaint(random.getTaint());
        addTaint(params.getTaint());
        addTaint(key.getTaint());
        checkMode(opmode);
        spiImpl.engineInit(opmode, key, params, random);
        mode = opmode;
        // ---------- Original Method ----------
        //checkMode(opmode);
        //spiImpl.engineInit(opmode, key, params, random);
        //mode = opmode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.994 -0400", hash_original_method = "BF9CD5FCB5A2729A943C192A3430B212", hash_generated_method = "BC06FBEE8CFBD0D350DE8E18059BB017")
    public final void init(int opmode, Key key, AlgorithmParameters params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        addTaint(params.getTaint());
        addTaint(key.getTaint());
        addTaint(opmode);
        if(secureRandom == null)        
        {
            secureRandom = new SecureRandom();
        } //End block
        init(opmode, key, params, secureRandom);
        // ---------- Original Method ----------
        //if (secureRandom == null) {
            //secureRandom = new SecureRandom();
        //}
        //init(opmode, key, params, secureRandom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.994 -0400", hash_original_method = "807F390A384AF896657386359C87C81B", hash_generated_method = "075A71815B69189F4E3CC85430E667B0")
    public final void init(int opmode, Key key, AlgorithmParameters params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException {
        addTaint(random.getTaint());
        addTaint(params.getTaint());
        addTaint(key.getTaint());
        checkMode(opmode);
        spiImpl.engineInit(opmode, key, params, random);
        mode = opmode;
        // ---------- Original Method ----------
        //checkMode(opmode);
        //spiImpl.engineInit(opmode, key, params, random);
        //mode = opmode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.994 -0400", hash_original_method = "D1B8B02AA4362AEA38C29780F594C5E0", hash_generated_method = "1692D003B87308C28B20BE9EEC5A6B0E")
    public final void init(int opmode, Certificate certificate) throws InvalidKeyException {
        addTaint(certificate.getTaint());
        addTaint(opmode);
        if(secureRandom == null)        
        {
            secureRandom = new SecureRandom();
        } //End block
        init(opmode, certificate, secureRandom);
        // ---------- Original Method ----------
        //if (secureRandom == null) {
            //secureRandom = new SecureRandom();
        //}
        //init(opmode, certificate, secureRandom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.995 -0400", hash_original_method = "CF5B7C36D9EDA90E4E4A39DDF2F721FD", hash_generated_method = "917D67F6B411DA95328CA1EB72B0B994")
    public final void init(int opmode, Certificate certificate,
            SecureRandom random) throws InvalidKeyException {
        addTaint(random.getTaint());
        addTaint(certificate.getTaint());
        checkMode(opmode);
        if(certificate instanceof X509Certificate)        
        {
            Set<String> ce = ((X509Certificate) certificate).getCriticalExtensionOIDs();
            boolean critical = false;
            if(ce != null && !ce.isEmpty())            
            {
for(String oid : ce)
                {
                    if(oid.equals("2.5.29.15"))                    
                    {
                        critical = true;
                        break;
                    } //End block
                } //End block
                if(critical)                
                {
                    boolean[] keyUsage = ((X509Certificate) certificate).getKeyUsage();
                    if(keyUsage != null)                    
                    {
                        if(opmode == ENCRYPT_MODE && !keyUsage[3])                        
                        {
                            InvalidKeyException var040E9AA63F9F9A7EEA10CEA0460B066B_2137798711 = new InvalidKeyException("The public key in the certificate "
                                                          + "cannot be used for ENCRYPT_MODE");
                            var040E9AA63F9F9A7EEA10CEA0460B066B_2137798711.addTaint(taint);
                            throw var040E9AA63F9F9A7EEA10CEA0460B066B_2137798711;
                        } //End block
                        else
                        if(opmode == WRAP_MODE && !keyUsage[2])                        
                        {
                            InvalidKeyException varEB0A13E1EB418B6FEABA11D803D913CE_1192238755 = new InvalidKeyException("The public key in the certificate "
                                                          + "cannot be used for WRAP_MODE");
                            varEB0A13E1EB418B6FEABA11D803D913CE_1192238755.addTaint(taint);
                            throw varEB0A13E1EB418B6FEABA11D803D913CE_1192238755;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        spiImpl.engineInit(opmode, certificate.getPublicKey(), random);
        mode = opmode;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.995 -0400", hash_original_method = "D2539732F50CEA46903EFE3EE2FFBB7D", hash_generated_method = "13A8727D3173075C0011E33FDE6EE684")
    public final byte[] update(byte[] input) {
        addTaint(input[0]);
        if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_157426430 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_157426430.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_157426430;
        } //End block
        if(input == null)        
        {
            IllegalArgumentException var6A6A965F33A186280ACCE222064E6554_2141093041 = new IllegalArgumentException("input == null");
            var6A6A965F33A186280ACCE222064E6554_2141093041.addTaint(taint);
            throw var6A6A965F33A186280ACCE222064E6554_2141093041;
        } //End block
        if(input.length == 0)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_2067463371 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2041532478 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_2041532478;
        } //End block
        byte[] varDA67C3FAA98CA9A45AAA97F8952BE025_1546466476 = (spiImpl.engineUpdate(input, 0, input.length));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_742653425 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_742653425;
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //if (input == null) {
            //throw new IllegalArgumentException("input == null");
        //}
        //if (input.length == 0) {
            //return null;
        //}
        //return spiImpl.engineUpdate(input, 0, input.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.996 -0400", hash_original_method = "6B0ED73318E2DF96B368CBFEB9D8FD9F", hash_generated_method = "62A02067778C87601C2B055C03124A75")
    public final byte[] update(byte[] input, int inputOffset, int inputLen) {
        addTaint(inputLen);
        addTaint(inputOffset);
        addTaint(input[0]);
        if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1715125132 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1715125132.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1715125132;
        } //End block
        if(input == null)        
        {
            IllegalArgumentException var6A6A965F33A186280ACCE222064E6554_1113748840 = new IllegalArgumentException("input == null");
            var6A6A965F33A186280ACCE222064E6554_1113748840.addTaint(taint);
            throw var6A6A965F33A186280ACCE222064E6554_1113748840;
        } //End block
        if(inputOffset < 0 || inputLen < 0
                || inputLen > input.length
                || inputOffset > input.length - inputLen)        
        {
            IllegalArgumentException var8D88AA69DB0B0050C18F770ADD29E39C_1700734578 = new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
            var8D88AA69DB0B0050C18F770ADD29E39C_1700734578.addTaint(taint);
            throw var8D88AA69DB0B0050C18F770ADD29E39C_1700734578;
        } //End block
        if(input.length == 0)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1070127077 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1158069707 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1158069707;
        } //End block
        byte[] var637ED6DD448CEA157C3754C258BF9614_2112750665 = (spiImpl.engineUpdate(input, inputOffset, inputLen));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2000691138 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2000691138;
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //if (input == null) {
            //throw new IllegalArgumentException("input == null");
        //}
        //if (inputOffset < 0 || inputLen < 0
                //|| inputLen > input.length
                //|| inputOffset > input.length - inputLen) {
            //throw new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
        //}
        //if (input.length == 0) {
            //return null;
        //}
        //return spiImpl.engineUpdate(input, inputOffset, inputLen);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.996 -0400", hash_original_method = "851A7508725C6167E01999D358074612", hash_generated_method = "CFB28CBEB2FF7793CF59B60116161AF0")
    public final int update(byte[] input, int inputOffset, int inputLen,
            byte[] output) throws ShortBufferException {
        addTaint(output[0]);
        addTaint(inputLen);
        addTaint(inputOffset);
        addTaint(input[0]);
        int varCB57096FBEC0B5F352A49F77111BD15F_1762941130 = (update(input, inputOffset, inputLen, output, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621753318 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621753318;
        // ---------- Original Method ----------
        //return update(input, inputOffset, inputLen, output, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.997 -0400", hash_original_method = "43E41610DEFFC00737E44CA5E5476BCF", hash_generated_method = "937C13B673A51DE4E96E7892C3A8A59A")
    public final int update(byte[] input, int inputOffset, int inputLen,
            byte[] output, int outputOffset) throws ShortBufferException {
        addTaint(outputOffset);
        addTaint(output[0]);
        addTaint(inputLen);
        addTaint(inputOffset);
        addTaint(input[0]);
        if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1321398860 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1321398860.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1321398860;
        } //End block
        if(input == null)        
        {
            IllegalArgumentException var6A6A965F33A186280ACCE222064E6554_703137785 = new IllegalArgumentException("input == null");
            var6A6A965F33A186280ACCE222064E6554_703137785.addTaint(taint);
            throw var6A6A965F33A186280ACCE222064E6554_703137785;
        } //End block
        if(output == null)        
        {
            IllegalArgumentException varE2E2E512F186311F8B8ACD08AE4ED992_961312113 = new IllegalArgumentException("output == null");
            varE2E2E512F186311F8B8ACD08AE4ED992_961312113.addTaint(taint);
            throw varE2E2E512F186311F8B8ACD08AE4ED992_961312113;
        } //End block
        if(outputOffset < 0)        
        {
            IllegalArgumentException var21183C0BDC0AF003F4254A7DAD271601_249863625 = new IllegalArgumentException("outputOffset < 0");
            var21183C0BDC0AF003F4254A7DAD271601_249863625.addTaint(taint);
            throw var21183C0BDC0AF003F4254A7DAD271601_249863625;
        } //End block
        if(inputOffset < 0 || inputLen < 0 || inputLen > input.length
                || inputOffset > input.length - inputLen)        
        {
            IllegalArgumentException var8D88AA69DB0B0050C18F770ADD29E39C_1334591979 = new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
            var8D88AA69DB0B0050C18F770ADD29E39C_1334591979.addTaint(taint);
            throw var8D88AA69DB0B0050C18F770ADD29E39C_1334591979;
        } //End block
        if(input.length == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_188848582 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1808839041 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1808839041;
        } //End block
        int varD49C6E8598952D969CED8A4EE6F031C5_136038767 = (spiImpl.engineUpdate(input, inputOffset, inputLen, output,
                outputOffset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1078693611 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1078693611;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.997 -0400", hash_original_method = "3650ED22F64FB3DE8113B7C668BA6C70", hash_generated_method = "0E334FA8D2E17366FF418CF75C9B1F34")
    public final int update(ByteBuffer input, ByteBuffer output) throws ShortBufferException {
        addTaint(output.getTaint());
        addTaint(input.getTaint());
        if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_438014080 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_438014080.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_438014080;
        } //End block
        if(input == output)        
        {
            IllegalArgumentException varA372822B3F25D725E890875C1B7E8BFD_364227605 = new IllegalArgumentException("input == output");
            varA372822B3F25D725E890875C1B7E8BFD_364227605.addTaint(taint);
            throw varA372822B3F25D725E890875C1B7E8BFD_364227605;
        } //End block
        int var97C267E877EC34DE88324DEA51029B0C_702655485 = (spiImpl.engineUpdate(input, output));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_834596267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_834596267;
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //if (input == output) {
            //throw new IllegalArgumentException("input == output");
        //}
        //return spiImpl.engineUpdate(input, output);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.997 -0400", hash_original_method = "F0FEA4F0F73707A698ECC32C0962F654", hash_generated_method = "0407B1F7E4E57DC3E034A139D8C81669")
    public final byte[] doFinal() throws IllegalBlockSizeException,
            BadPaddingException {
        if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_932788213 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_932788213.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_932788213;
        } //End block
        byte[] var37526BA79DFA833A8CB3F446DDFFED36_1480618462 = (spiImpl.engineDoFinal(null, 0, 0));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_302515394 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_302515394;
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //return spiImpl.engineDoFinal(null, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.998 -0400", hash_original_method = "93AA6B063068AA94349A945C7753479D", hash_generated_method = "E3D7C7AB098A12E4B4E04BB3CF81D4A3")
    public final int doFinal(byte[] output, int outputOffset) throws IllegalBlockSizeException, ShortBufferException,
            BadPaddingException {
        addTaint(outputOffset);
        addTaint(output[0]);
        if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_510415922 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_510415922.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_510415922;
        } //End block
        if(outputOffset < 0)        
        {
            IllegalArgumentException var21183C0BDC0AF003F4254A7DAD271601_859825795 = new IllegalArgumentException("outputOffset < 0");
            var21183C0BDC0AF003F4254A7DAD271601_859825795.addTaint(taint);
            throw var21183C0BDC0AF003F4254A7DAD271601_859825795;
        } //End block
        int varCCF29067D03302088FD8BBB1A4F77C11_942213837 = (spiImpl.engineDoFinal(null, 0, 0, output, outputOffset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1832642902 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1832642902;
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //if (outputOffset < 0) {
            //throw new IllegalArgumentException("outputOffset < 0");
        //}
        //return spiImpl.engineDoFinal(null, 0, 0, output, outputOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.998 -0400", hash_original_method = "ED0F518E6798AF2EE42518F6A3E77904", hash_generated_method = "C0BE9466DB661A94431272C280FB4199")
    public final byte[] doFinal(byte[] input) throws IllegalBlockSizeException,
            BadPaddingException {
        addTaint(input[0]);
        if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1346706137 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1346706137.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1346706137;
        } //End block
        byte[] var4BE13A72907243DA5D8667F49DD22F06_434913707 = (spiImpl.engineDoFinal(input, 0, input.length));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2137038288 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2137038288;
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //return spiImpl.engineDoFinal(input, 0, input.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.998 -0400", hash_original_method = "6B1737194DBFF54F3884AE72A596BA42", hash_generated_method = "97FC1C5335FE1BBB65D6DE5B28210D56")
    public final byte[] doFinal(byte[] input, int inputOffset, int inputLen) throws IllegalBlockSizeException, BadPaddingException {
        addTaint(inputLen);
        addTaint(inputOffset);
        addTaint(input[0]);
        if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1370953359 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1370953359.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1370953359;
        } //End block
        if(inputOffset < 0 || inputLen < 0 || inputOffset + inputLen > input.length)        
        {
            IllegalArgumentException var8D88AA69DB0B0050C18F770ADD29E39C_553947129 = new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
            var8D88AA69DB0B0050C18F770ADD29E39C_553947129.addTaint(taint);
            throw var8D88AA69DB0B0050C18F770ADD29E39C_553947129;
        } //End block
        byte[] varE827FDEF2F46F6B70D7BD27A6AD2B8CE_557065878 = (spiImpl.engineDoFinal(input, inputOffset, inputLen));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_644485589 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_644485589;
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //if (inputOffset < 0 || inputLen < 0 || inputOffset + inputLen > input.length) {
            //throw new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
        //}
        //return spiImpl.engineDoFinal(input, inputOffset, inputLen);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.998 -0400", hash_original_method = "A6D208F07F7B0D8A8A4180809C2EF479", hash_generated_method = "76EE2C7F5795724E0A79AC803F7F3BE6")
    public final int doFinal(byte[] input, int inputOffset, int inputLen,
            byte[] output) throws ShortBufferException,
            IllegalBlockSizeException, BadPaddingException {
        addTaint(output[0]);
        addTaint(inputLen);
        addTaint(inputOffset);
        addTaint(input[0]);
        int var9A0BAA71182E0DEE846F1118D09157AA_1960227400 = (doFinal(input, inputOffset, inputLen, output, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139611374 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139611374;
        // ---------- Original Method ----------
        //return doFinal(input, inputOffset, inputLen, output, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.998 -0400", hash_original_method = "46F54FF2783CE552AE826C81B354A349", hash_generated_method = "DD2D76BCA6E0323083E3888DA06FF98F")
    public final int doFinal(byte[] input, int inputOffset, int inputLen,
            byte[] output, int outputOffset) throws ShortBufferException,
            IllegalBlockSizeException, BadPaddingException {
        addTaint(outputOffset);
        addTaint(output[0]);
        addTaint(inputLen);
        addTaint(inputOffset);
        addTaint(input[0]);
        if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_327617687 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_327617687.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_327617687;
        } //End block
        if(inputOffset < 0 || inputLen < 0 || inputOffset + inputLen > input.length)        
        {
            IllegalArgumentException var8D88AA69DB0B0050C18F770ADD29E39C_1917854708 = new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
            var8D88AA69DB0B0050C18F770ADD29E39C_1917854708.addTaint(taint);
            throw var8D88AA69DB0B0050C18F770ADD29E39C_1917854708;
        } //End block
        int varCF0102AC5B34095775BBAB7062A69632_1150164864 = (spiImpl.engineDoFinal(input, inputOffset, inputLen, output,
                outputOffset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_274824415 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_274824415;
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //if (inputOffset < 0 || inputLen < 0 || inputOffset + inputLen > input.length) {
            //throw new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
        //}
        //return spiImpl.engineDoFinal(input, inputOffset, inputLen, output,
                //outputOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.999 -0400", hash_original_method = "90770161074657C0B33458A086574F5B", hash_generated_method = "ACC293779D446055019A134C9F03E350")
    public final int doFinal(ByteBuffer input, ByteBuffer output) throws ShortBufferException, IllegalBlockSizeException,
            BadPaddingException {
        addTaint(output.getTaint());
        addTaint(input.getTaint());
        if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1832611363 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1832611363.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1832611363;
        } //End block
        if(input == output)        
        {
            IllegalArgumentException varA372822B3F25D725E890875C1B7E8BFD_562673258 = new IllegalArgumentException("input == output");
            varA372822B3F25D725E890875C1B7E8BFD_562673258.addTaint(taint);
            throw varA372822B3F25D725E890875C1B7E8BFD_562673258;
        } //End block
        int var422C9A7C90052BEBB58E92C22B3137E8_1312565724 = (spiImpl.engineDoFinal(input, output));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1095485101 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1095485101;
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //if (input == output) {
            //throw new IllegalArgumentException("input == output");
        //}
        //return spiImpl.engineDoFinal(input, output);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.999 -0400", hash_original_method = "6E0DA752A02639D8B96D35F2A60D917D", hash_generated_method = "1ABECF8B5D548E291D948EDDC133D3B9")
    public final byte[] wrap(Key key) throws IllegalBlockSizeException,
            InvalidKeyException {
        addTaint(key.getTaint());
        if(mode != WRAP_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1496049907 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1496049907.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1496049907;
        } //End block
        byte[] var74535699818625C1CFD1ABCF21043391_1043428729 = (spiImpl.engineWrap(key));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2050460952 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2050460952;
        // ---------- Original Method ----------
        //if (mode != WRAP_MODE) {
            //throw new IllegalStateException();
        //}
        //return spiImpl.engineWrap(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.999 -0400", hash_original_method = "601EF7D9B28B5898301EBC35141803DA", hash_generated_method = "A789E14AC34CE1CF820A24B732FD065F")
    public final Key unwrap(byte[] wrappedKey, String wrappedKeyAlgorithm,
            int wrappedKeyType) throws InvalidKeyException,
            NoSuchAlgorithmException {
        addTaint(wrappedKeyType);
        addTaint(wrappedKeyAlgorithm.getTaint());
        addTaint(wrappedKey[0]);
        if(mode != UNWRAP_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_2094554950 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_2094554950.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_2094554950;
        } //End block
Key var3B6EEF5A41015CBF2E819B3EDDAF7B55_1249112942 =         spiImpl.engineUnwrap(wrappedKey, wrappedKeyAlgorithm,
                wrappedKeyType);
        var3B6EEF5A41015CBF2E819B3EDDAF7B55_1249112942.addTaint(taint);
        return var3B6EEF5A41015CBF2E819B3EDDAF7B55_1249112942;
        // ---------- Original Method ----------
        //if (mode != UNWRAP_MODE) {
            //throw new IllegalStateException();
        //}
        //return spiImpl.engineUnwrap(wrappedKey, wrappedKeyAlgorithm,
                //wrappedKeyType);
    }

    
    public static final int getMaxAllowedKeyLength(String transformation) throws NoSuchAlgorithmException {
        if (transformation == null) {
            throw new NullPointerException();
        }
        checkTransformation(transformation);
        return Integer.MAX_VALUE;
    }

    
    public static final AlgorithmParameterSpec getMaxAllowedParameterSpec(
            String transformation) throws NoSuchAlgorithmException {
        if (transformation == null) {
            throw new NullPointerException();
        }
        checkTransformation(transformation);
        return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.999 -0400", hash_original_field = "1644C81AE07E27E1FEC30500618DF91F", hash_generated_field = "2F15DC862DF8E709496A189635636236")

    public static final int DECRYPT_MODE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.999 -0400", hash_original_field = "32A5049D4D8BC622488ED3614A6C1936", hash_generated_field = "A83EC5987C5AA77E22791E25CFA393A2")

    public static final int ENCRYPT_MODE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.999 -0400", hash_original_field = "B6ADE1667AFE4B2AF1DE033A9EA82DE6", hash_generated_field = "0081C7108661D39138574156E05B2FCD")

    public static final int PRIVATE_KEY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.999 -0400", hash_original_field = "43A68F7DB1FE90EB93C24BB3173E6A98", hash_generated_field = "295FEA31A43E6359048D4E46607B1E49")

    public static final int PUBLIC_KEY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.999 -0400", hash_original_field = "50B9F5A3CE3751C169AD269B650AC0DF", hash_generated_field = "677CDE87FE6610FD7AB080651DB96E2F")

    public static final int SECRET_KEY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.999 -0400", hash_original_field = "7D2FB99606ED2EBA904633463A636E9E", hash_generated_field = "9CA0A457708663E8B7EA225ECB1B0CA6")

    public static final int UNWRAP_MODE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.000 -0400", hash_original_field = "0A500DC619F8995886543B5C47BACF9D", hash_generated_field = "04C8E84D8FBFED46FA7E0F269D64C2EB")

    public static final int WRAP_MODE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.000 -0400", hash_original_field = "DCAB4B1B48F0891C8AE16EB231D23614", hash_generated_field = "A6EBFC9B978978AEFD771859660D05E3")

    private static final String SERVICE = "Cipher";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.000 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.000 -0400", hash_original_field = "7A369DC18E63D8C3EA510B9B660A072D", hash_generated_field = "09B90F530A62DA10A38CA3C1F3C2FAB8")

    private static SecureRandom secureRandom;
}

