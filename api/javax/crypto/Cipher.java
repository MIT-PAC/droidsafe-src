package javax.crypto;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.617 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "D6093ADED541044A414FEED81979F5E2")

    private int mode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.617 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.617 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "609F6DC57B3704B1B8111A24F710F199")

    private CipherSpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.617 -0400", hash_original_field = "3935F8FEEE087B4547DE27296EC777B9", hash_generated_field = "2B831647F5B0DC5F72250AEA4C817CDC")

    private String transformation;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.618 -0400", hash_original_method = "169E8725E31AA026BEEB43CC41C0DB25", hash_generated_method = "839C6BFC9996626BBA32A3330D997E79")
    protected  Cipher(CipherSpi cipherSpi, Provider provider,
            String transformation) {
    if(cipherSpi == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1208034160 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1208034160.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1208034160;
        } 
    if(!(cipherSpi instanceof NullCipherSpi) && provider == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1752296705 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1752296705.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1752296705;
        } 
        this.provider = provider;
        this.transformation = transformation;
        this.spiImpl = cipherSpi;
        
        
            
        
        
            
        
        
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.620 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "6E809DE43CF69EF66915F168D8384272")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_870250706 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_870250706.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_870250706;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.620 -0400", hash_original_method = "8DF6BCF87B142C85CC5BB8E6263E3718", hash_generated_method = "243AC0D8393D17E4820988580D0925F5")
    public final String getAlgorithm() {
String var6472AF3EC4810156446ED9616CC1EE8E_1430654408 =         transformation;
        var6472AF3EC4810156446ED9616CC1EE8E_1430654408.addTaint(taint);
        return var6472AF3EC4810156446ED9616CC1EE8E_1430654408;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.621 -0400", hash_original_method = "D9E2BEA1F59A5109A8382C65AF7F31D0", hash_generated_method = "73B7500F53BAA81593B990C073D712BC")
    public final int getBlockSize() {
        int var45465D5DC9BEC9FECC52A032FA1F16D6_1953227954 = (spiImpl.engineGetBlockSize());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_290150075 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_290150075;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.621 -0400", hash_original_method = "AA8C5558649103E88A25D53E8218E1F5", hash_generated_method = "9C0334771ADCD1F882F793E8F3A501BC")
    public final int getOutputSize(int inputLen) {
        addTaint(inputLen);
    if(mode == 0)        
        {
            IllegalStateException var63B7668973C20A74990D779B455ADF9E_1056819155 = new IllegalStateException("Cipher has not yet been initialized");
            var63B7668973C20A74990D779B455ADF9E_1056819155.addTaint(taint);
            throw var63B7668973C20A74990D779B455ADF9E_1056819155;
        } 
        int var32BCD9DDCCA7AD94E055443B55C28727_383822703 = (spiImpl.engineGetOutputSize(inputLen));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1402630537 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1402630537;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.622 -0400", hash_original_method = "99DAD5FABE956FC53B6CC59AB3BC8215", hash_generated_method = "B4AFC17A898A8FAC34AF86EAD47E3D56")
    public final byte[] getIV() {
        byte[] varE5F6887C529E3E0CA3FBCCADA885FC6B_2082425022 = (spiImpl.engineGetIV());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_977775641 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_977775641;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.622 -0400", hash_original_method = "1EF273790A635FFB8595723F2B2D47C7", hash_generated_method = "B9A23C5B2F06DFEE64FF1BA5D2867AD3")
    public final AlgorithmParameters getParameters() {
AlgorithmParameters varDDF010DE7E5B16986942A6D470695726_1937417346 =         spiImpl.engineGetParameters();
        varDDF010DE7E5B16986942A6D470695726_1937417346.addTaint(taint);
        return varDDF010DE7E5B16986942A6D470695726_1937417346;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.622 -0400", hash_original_method = "8BD6E3BF151C3D35A58DA717088B655C", hash_generated_method = "7F69596EDAA2EA7FDC6531130CB3B33F")
    public final ExemptionMechanism getExemptionMechanism() {
ExemptionMechanism var540C13E9E156B687226421B24F2DF178_683962539 =         null;
        var540C13E9E156B687226421B24F2DF178_683962539.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_683962539;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.623 -0400", hash_original_method = "429E4D2BD5B61AF47430304468140423", hash_generated_method = "A53648B1A5A6390529F392A2C6D436BB")
    public final void init(int opmode, Key key) throws InvalidKeyException {
        addTaint(key.getTaint());
        addTaint(opmode);
    if(secureRandom == null)        
        {
            secureRandom = new SecureRandom();
        } 
        init(opmode, key, secureRandom);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.623 -0400", hash_original_method = "0BCC9283EB770D83968E2D5392900813", hash_generated_method = "FE70452A34DB88E3DA3903253EE198C4")
    public final void init(int opmode, Key key, SecureRandom random) throws InvalidKeyException {
        addTaint(random.getTaint());
        addTaint(key.getTaint());
        checkMode(opmode);
        spiImpl.engineInit(opmode, key, random);
        mode = opmode;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.624 -0400", hash_original_method = "09F21B40649178B5CD7EDFF6A1F24869", hash_generated_method = "EF7E2928E4CE1C1693C6A1A7380548E9")
    private void checkMode(int mode) {
        addTaint(mode);
    if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE
            && mode != UNWRAP_MODE && mode != WRAP_MODE)        
        {
            InvalidParameterException varDEB5BE7797F8E1BF880BE2B8FD8FE549_286682554 = new InvalidParameterException("Invalid mode: " + mode);
            varDEB5BE7797F8E1BF880BE2B8FD8FE549_286682554.addTaint(taint);
            throw varDEB5BE7797F8E1BF880BE2B8FD8FE549_286682554;
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.624 -0400", hash_original_method = "BBC8C1A41A2EA4CA6303B616FCC7D14B", hash_generated_method = "AF7D35ADF82EA5CCADDAD7ABA4A8462F")
    public final void init(int opmode, Key key, AlgorithmParameterSpec params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        addTaint(params.getTaint());
        addTaint(key.getTaint());
        addTaint(opmode);
    if(secureRandom == null)        
        {
            secureRandom = new SecureRandom();
        } 
        init(opmode, key, params, secureRandom);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.625 -0400", hash_original_method = "8E7DC73E6E4E585B73E6EA7E879FC58B", hash_generated_method = "4BE0E12A2EC974CD397827A7111246A7")
    public final void init(int opmode, Key key, AlgorithmParameterSpec params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException {
        addTaint(random.getTaint());
        addTaint(params.getTaint());
        addTaint(key.getTaint());
        checkMode(opmode);
        spiImpl.engineInit(opmode, key, params, random);
        mode = opmode;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.626 -0400", hash_original_method = "BF9CD5FCB5A2729A943C192A3430B212", hash_generated_method = "BC06FBEE8CFBD0D350DE8E18059BB017")
    public final void init(int opmode, Key key, AlgorithmParameters params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        addTaint(params.getTaint());
        addTaint(key.getTaint());
        addTaint(opmode);
    if(secureRandom == null)        
        {
            secureRandom = new SecureRandom();
        } 
        init(opmode, key, params, secureRandom);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.626 -0400", hash_original_method = "807F390A384AF896657386359C87C81B", hash_generated_method = "075A71815B69189F4E3CC85430E667B0")
    public final void init(int opmode, Key key, AlgorithmParameters params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException {
        addTaint(random.getTaint());
        addTaint(params.getTaint());
        addTaint(key.getTaint());
        checkMode(opmode);
        spiImpl.engineInit(opmode, key, params, random);
        mode = opmode;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.627 -0400", hash_original_method = "D1B8B02AA4362AEA38C29780F594C5E0", hash_generated_method = "1692D003B87308C28B20BE9EEC5A6B0E")
    public final void init(int opmode, Certificate certificate) throws InvalidKeyException {
        addTaint(certificate.getTaint());
        addTaint(opmode);
    if(secureRandom == null)        
        {
            secureRandom = new SecureRandom();
        } 
        init(opmode, certificate, secureRandom);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.628 -0400", hash_original_method = "CF5B7C36D9EDA90E4E4A39DDF2F721FD", hash_generated_method = "3A343C275CCEBDB2C2EE24910605E0CB")
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
                    } 
                } 
    if(critical)                
                {
                    boolean[] keyUsage = ((X509Certificate) certificate).getKeyUsage();
    if(keyUsage != null)                    
                    {
    if(opmode == ENCRYPT_MODE && !keyUsage[3])                        
                        {
                            InvalidKeyException var040E9AA63F9F9A7EEA10CEA0460B066B_1826856115 = new InvalidKeyException("The public key in the certificate "
                                                          + "cannot be used for ENCRYPT_MODE");
                            var040E9AA63F9F9A7EEA10CEA0460B066B_1826856115.addTaint(taint);
                            throw var040E9AA63F9F9A7EEA10CEA0460B066B_1826856115;
                        } 
                        else
    if(opmode == WRAP_MODE && !keyUsage[2])                        
                        {
                            InvalidKeyException varEB0A13E1EB418B6FEABA11D803D913CE_548478605 = new InvalidKeyException("The public key in the certificate "
                                                          + "cannot be used for WRAP_MODE");
                            varEB0A13E1EB418B6FEABA11D803D913CE_548478605.addTaint(taint);
                            throw varEB0A13E1EB418B6FEABA11D803D913CE_548478605;
                        } 
                    } 
                } 
            } 
        } 
        spiImpl.engineInit(opmode, certificate.getPublicKey(), random);
        mode = opmode;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.628 -0400", hash_original_method = "D2539732F50CEA46903EFE3EE2FFBB7D", hash_generated_method = "D89F1D3CD5C20B586446692F018BB8FD")
    public final byte[] update(byte[] input) {
        addTaint(input[0]);
    if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1250790638 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1250790638.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1250790638;
        } 
    if(input == null)        
        {
            IllegalArgumentException var6A6A965F33A186280ACCE222064E6554_2147409131 = new IllegalArgumentException("input == null");
            var6A6A965F33A186280ACCE222064E6554_2147409131.addTaint(taint);
            throw var6A6A965F33A186280ACCE222064E6554_2147409131;
        } 
    if(input.length == 0)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1647050273 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1856053938 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1856053938;
        } 
        byte[] varDA67C3FAA98CA9A45AAA97F8952BE025_1252999215 = (spiImpl.engineUpdate(input, 0, input.length));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_106575668 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_106575668;
        
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.629 -0400", hash_original_method = "6B0ED73318E2DF96B368CBFEB9D8FD9F", hash_generated_method = "E7BB77CB910CBF8E4F47CC4942873305")
    public final byte[] update(byte[] input, int inputOffset, int inputLen) {
        addTaint(inputLen);
        addTaint(inputOffset);
        addTaint(input[0]);
    if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1575793870 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1575793870.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1575793870;
        } 
    if(input == null)        
        {
            IllegalArgumentException var6A6A965F33A186280ACCE222064E6554_1798689155 = new IllegalArgumentException("input == null");
            var6A6A965F33A186280ACCE222064E6554_1798689155.addTaint(taint);
            throw var6A6A965F33A186280ACCE222064E6554_1798689155;
        } 
    if(inputOffset < 0 || inputLen < 0
                || inputLen > input.length
                || inputOffset > input.length - inputLen)        
        {
            IllegalArgumentException var8D88AA69DB0B0050C18F770ADD29E39C_921184750 = new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
            var8D88AA69DB0B0050C18F770ADD29E39C_921184750.addTaint(taint);
            throw var8D88AA69DB0B0050C18F770ADD29E39C_921184750;
        } 
    if(input.length == 0)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1364754644 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_875205047 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_875205047;
        } 
        byte[] var637ED6DD448CEA157C3754C258BF9614_1590526228 = (spiImpl.engineUpdate(input, inputOffset, inputLen));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_464706450 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_464706450;
        
        
            
        
        
            
        
        
                
                
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.630 -0400", hash_original_method = "851A7508725C6167E01999D358074612", hash_generated_method = "0F451D7EF662F3999B249F1CA6266A88")
    public final int update(byte[] input, int inputOffset, int inputLen,
            byte[] output) throws ShortBufferException {
        addTaint(output[0]);
        addTaint(inputLen);
        addTaint(inputOffset);
        addTaint(input[0]);
        int varCB57096FBEC0B5F352A49F77111BD15F_842195711 = (update(input, inputOffset, inputLen, output, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_761046438 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_761046438;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.631 -0400", hash_original_method = "43E41610DEFFC00737E44CA5E5476BCF", hash_generated_method = "691F870CFF047082E0E44EA720DC0FBE")
    public final int update(byte[] input, int inputOffset, int inputLen,
            byte[] output, int outputOffset) throws ShortBufferException {
        addTaint(outputOffset);
        addTaint(output[0]);
        addTaint(inputLen);
        addTaint(inputOffset);
        addTaint(input[0]);
    if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1808314691 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1808314691.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1808314691;
        } 
    if(input == null)        
        {
            IllegalArgumentException var6A6A965F33A186280ACCE222064E6554_28238467 = new IllegalArgumentException("input == null");
            var6A6A965F33A186280ACCE222064E6554_28238467.addTaint(taint);
            throw var6A6A965F33A186280ACCE222064E6554_28238467;
        } 
    if(output == null)        
        {
            IllegalArgumentException varE2E2E512F186311F8B8ACD08AE4ED992_1817312350 = new IllegalArgumentException("output == null");
            varE2E2E512F186311F8B8ACD08AE4ED992_1817312350.addTaint(taint);
            throw varE2E2E512F186311F8B8ACD08AE4ED992_1817312350;
        } 
    if(outputOffset < 0)        
        {
            IllegalArgumentException var21183C0BDC0AF003F4254A7DAD271601_968204678 = new IllegalArgumentException("outputOffset < 0");
            var21183C0BDC0AF003F4254A7DAD271601_968204678.addTaint(taint);
            throw var21183C0BDC0AF003F4254A7DAD271601_968204678;
        } 
    if(inputOffset < 0 || inputLen < 0 || inputLen > input.length
                || inputOffset > input.length - inputLen)        
        {
            IllegalArgumentException var8D88AA69DB0B0050C18F770ADD29E39C_956782233 = new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
            var8D88AA69DB0B0050C18F770ADD29E39C_956782233.addTaint(taint);
            throw var8D88AA69DB0B0050C18F770ADD29E39C_956782233;
        } 
    if(input.length == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1022808022 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309200367 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309200367;
        } 
        int varD49C6E8598952D969CED8A4EE6F031C5_1705370130 = (spiImpl.engineUpdate(input, inputOffset, inputLen, output,
                outputOffset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1853324115 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1853324115;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.632 -0400", hash_original_method = "3650ED22F64FB3DE8113B7C668BA6C70", hash_generated_method = "EEAE4F330B6B875010F1B37CD1DDEE3E")
    public final int update(ByteBuffer input, ByteBuffer output) throws ShortBufferException {
        addTaint(output.getTaint());
        addTaint(input.getTaint());
    if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1717694951 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1717694951.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1717694951;
        } 
    if(input == output)        
        {
            IllegalArgumentException varA372822B3F25D725E890875C1B7E8BFD_2057735864 = new IllegalArgumentException("input == output");
            varA372822B3F25D725E890875C1B7E8BFD_2057735864.addTaint(taint);
            throw varA372822B3F25D725E890875C1B7E8BFD_2057735864;
        } 
        int var97C267E877EC34DE88324DEA51029B0C_430153619 = (spiImpl.engineUpdate(input, output));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_323660296 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_323660296;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.633 -0400", hash_original_method = "F0FEA4F0F73707A698ECC32C0962F654", hash_generated_method = "96A0C84BC7E26D0191BEB88C05F09B43")
    public final byte[] doFinal() throws IllegalBlockSizeException,
            BadPaddingException {
    if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_113852814 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_113852814.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_113852814;
        } 
        byte[] var37526BA79DFA833A8CB3F446DDFFED36_1982001340 = (spiImpl.engineDoFinal(null, 0, 0));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_408993542 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_408993542;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.633 -0400", hash_original_method = "93AA6B063068AA94349A945C7753479D", hash_generated_method = "15865E356A6F97DD9B4574FF5C050091")
    public final int doFinal(byte[] output, int outputOffset) throws IllegalBlockSizeException, ShortBufferException,
            BadPaddingException {
        addTaint(outputOffset);
        addTaint(output[0]);
    if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_745389131 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_745389131.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_745389131;
        } 
    if(outputOffset < 0)        
        {
            IllegalArgumentException var21183C0BDC0AF003F4254A7DAD271601_445814938 = new IllegalArgumentException("outputOffset < 0");
            var21183C0BDC0AF003F4254A7DAD271601_445814938.addTaint(taint);
            throw var21183C0BDC0AF003F4254A7DAD271601_445814938;
        } 
        int varCCF29067D03302088FD8BBB1A4F77C11_1042014590 = (spiImpl.engineDoFinal(null, 0, 0, output, outputOffset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1486601024 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1486601024;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.634 -0400", hash_original_method = "ED0F518E6798AF2EE42518F6A3E77904", hash_generated_method = "A4541A7098F3AFF3360A5B2633F0C6D9")
    public final byte[] doFinal(byte[] input) throws IllegalBlockSizeException,
            BadPaddingException {
        addTaint(input[0]);
    if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1525328484 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1525328484.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1525328484;
        } 
        byte[] var4BE13A72907243DA5D8667F49DD22F06_2114199805 = (spiImpl.engineDoFinal(input, 0, input.length));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1690474960 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1690474960;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.635 -0400", hash_original_method = "6B1737194DBFF54F3884AE72A596BA42", hash_generated_method = "13B14D3C43467768D2DE5D0B88457729")
    public final byte[] doFinal(byte[] input, int inputOffset, int inputLen) throws IllegalBlockSizeException, BadPaddingException {
        addTaint(inputLen);
        addTaint(inputOffset);
        addTaint(input[0]);
    if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1723704450 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1723704450.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1723704450;
        } 
    if(inputOffset < 0 || inputLen < 0 || inputOffset + inputLen > input.length)        
        {
            IllegalArgumentException var8D88AA69DB0B0050C18F770ADD29E39C_1294999130 = new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
            var8D88AA69DB0B0050C18F770ADD29E39C_1294999130.addTaint(taint);
            throw var8D88AA69DB0B0050C18F770ADD29E39C_1294999130;
        } 
        byte[] varE827FDEF2F46F6B70D7BD27A6AD2B8CE_1778239953 = (spiImpl.engineDoFinal(input, inputOffset, inputLen));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2141353561 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2141353561;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.636 -0400", hash_original_method = "A6D208F07F7B0D8A8A4180809C2EF479", hash_generated_method = "C7291396BD06D182D402CF3EF5DBB5F8")
    public final int doFinal(byte[] input, int inputOffset, int inputLen,
            byte[] output) throws ShortBufferException,
            IllegalBlockSizeException, BadPaddingException {
        addTaint(output[0]);
        addTaint(inputLen);
        addTaint(inputOffset);
        addTaint(input[0]);
        int var9A0BAA71182E0DEE846F1118D09157AA_1963454389 = (doFinal(input, inputOffset, inputLen, output, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_307564781 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_307564781;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.638 -0400", hash_original_method = "46F54FF2783CE552AE826C81B354A349", hash_generated_method = "31741A7C40E87946F229DBE8E701114E")
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
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_930608830 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_930608830.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_930608830;
        } 
    if(inputOffset < 0 || inputLen < 0 || inputOffset + inputLen > input.length)        
        {
            IllegalArgumentException var8D88AA69DB0B0050C18F770ADD29E39C_387916018 = new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
            var8D88AA69DB0B0050C18F770ADD29E39C_387916018.addTaint(taint);
            throw var8D88AA69DB0B0050C18F770ADD29E39C_387916018;
        } 
        int varCF0102AC5B34095775BBAB7062A69632_328342233 = (spiImpl.engineDoFinal(input, inputOffset, inputLen, output,
                outputOffset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1115486270 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1115486270;
        
        
            
        
        
            
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.639 -0400", hash_original_method = "90770161074657C0B33458A086574F5B", hash_generated_method = "C8B181165B1BE3B25BAB08CCD9397A19")
    public final int doFinal(ByteBuffer input, ByteBuffer output) throws ShortBufferException, IllegalBlockSizeException,
            BadPaddingException {
        addTaint(output.getTaint());
        addTaint(input.getTaint());
    if(mode != ENCRYPT_MODE && mode != DECRYPT_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_148790770 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_148790770.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_148790770;
        } 
    if(input == output)        
        {
            IllegalArgumentException varA372822B3F25D725E890875C1B7E8BFD_2028730276 = new IllegalArgumentException("input == output");
            varA372822B3F25D725E890875C1B7E8BFD_2028730276.addTaint(taint);
            throw varA372822B3F25D725E890875C1B7E8BFD_2028730276;
        } 
        int var422C9A7C90052BEBB58E92C22B3137E8_1920452786 = (spiImpl.engineDoFinal(input, output));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1004983130 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1004983130;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.640 -0400", hash_original_method = "6E0DA752A02639D8B96D35F2A60D917D", hash_generated_method = "C9C7BD6A651FCD599BC3BA326EADC37E")
    public final byte[] wrap(Key key) throws IllegalBlockSizeException,
            InvalidKeyException {
        addTaint(key.getTaint());
    if(mode != WRAP_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_528663739 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_528663739.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_528663739;
        } 
        byte[] var74535699818625C1CFD1ABCF21043391_240166313 = (spiImpl.engineWrap(key));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_997056540 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_997056540;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.641 -0400", hash_original_method = "601EF7D9B28B5898301EBC35141803DA", hash_generated_method = "D676733418556F55F82331EF208704B6")
    public final Key unwrap(byte[] wrappedKey, String wrappedKeyAlgorithm,
            int wrappedKeyType) throws InvalidKeyException,
            NoSuchAlgorithmException {
        addTaint(wrappedKeyType);
        addTaint(wrappedKeyAlgorithm.getTaint());
        addTaint(wrappedKey[0]);
    if(mode != UNWRAP_MODE)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_2011788968 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_2011788968.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_2011788968;
        } 
Key var3B6EEF5A41015CBF2E819B3EDDAF7B55_540510363 =         spiImpl.engineUnwrap(wrappedKey, wrappedKeyAlgorithm,
                wrappedKeyType);
        var3B6EEF5A41015CBF2E819B3EDDAF7B55_540510363.addTaint(taint);
        return var3B6EEF5A41015CBF2E819B3EDDAF7B55_540510363;
        
        
            
        
        
                
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.642 -0400", hash_original_field = "1644C81AE07E27E1FEC30500618DF91F", hash_generated_field = "2F15DC862DF8E709496A189635636236")

    public static final int DECRYPT_MODE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.643 -0400", hash_original_field = "32A5049D4D8BC622488ED3614A6C1936", hash_generated_field = "A83EC5987C5AA77E22791E25CFA393A2")

    public static final int ENCRYPT_MODE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.643 -0400", hash_original_field = "B6ADE1667AFE4B2AF1DE033A9EA82DE6", hash_generated_field = "0081C7108661D39138574156E05B2FCD")

    public static final int PRIVATE_KEY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.643 -0400", hash_original_field = "43A68F7DB1FE90EB93C24BB3173E6A98", hash_generated_field = "295FEA31A43E6359048D4E46607B1E49")

    public static final int PUBLIC_KEY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.643 -0400", hash_original_field = "50B9F5A3CE3751C169AD269B650AC0DF", hash_generated_field = "677CDE87FE6610FD7AB080651DB96E2F")

    public static final int SECRET_KEY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.643 -0400", hash_original_field = "7D2FB99606ED2EBA904633463A636E9E", hash_generated_field = "9CA0A457708663E8B7EA225ECB1B0CA6")

    public static final int UNWRAP_MODE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.643 -0400", hash_original_field = "0A500DC619F8995886543B5C47BACF9D", hash_generated_field = "04C8E84D8FBFED46FA7E0F269D64C2EB")

    public static final int WRAP_MODE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.643 -0400", hash_original_field = "DCAB4B1B48F0891C8AE16EB231D23614", hash_generated_field = "A6EBFC9B978978AEFD771859660D05E3")

    private static final String SERVICE = "Cipher";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.644 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.644 -0400", hash_original_field = "7A369DC18E63D8C3EA510B9B660A072D", hash_generated_field = "09B90F530A62DA10A38CA3C1F3C2FAB8")

    private static SecureRandom secureRandom;
}

