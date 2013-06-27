package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.191 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "D6093ADED541044A414FEED81979F5E2")

    private int mode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.191 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.191 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "609F6DC57B3704B1B8111A24F710F199")

    private CipherSpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.191 -0400", hash_original_field = "3935F8FEEE087B4547DE27296EC777B9", hash_generated_field = "2B831647F5B0DC5F72250AEA4C817CDC")

    private String transformation;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.192 -0400", hash_original_method = "169E8725E31AA026BEEB43CC41C0DB25", hash_generated_method = "CEC53FFBC2C49B796339413F7F597EE5")
    protected  Cipher(CipherSpi cipherSpi, Provider provider,
            String transformation) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.198 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "3E33B0DC055139B235BCEC7B567C1097")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_11439742 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_11439742 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_11439742.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_11439742;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.203 -0400", hash_original_method = "8DF6BCF87B142C85CC5BB8E6263E3718", hash_generated_method = "EE0E1EA71F2A74AAB4B049D6A96D02F7")
    public final String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_145950342 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_145950342 = transformation;
        varB4EAC82CA7396A68D541C85D26508E83_145950342.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_145950342;
        // ---------- Original Method ----------
        //return transformation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.204 -0400", hash_original_method = "D9E2BEA1F59A5109A8382C65AF7F31D0", hash_generated_method = "B6EC118972BB2B874A8637F4E2AC4518")
    public final int getBlockSize() {
        int var7364A97EC441053FEC79B2C935557BB1_2094757110 = (spiImpl.engineGetBlockSize());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1429598706 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1429598706;
        // ---------- Original Method ----------
        //return spiImpl.engineGetBlockSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.205 -0400", hash_original_method = "AA8C5558649103E88A25D53E8218E1F5", hash_generated_method = "5C44D592EA019288C37D2B519951F5E5")
    public final int getOutputSize(int inputLen) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cipher has not yet been initialized");
        } //End block
        int var179ED6F279F10B55227291448D76B240_269845948 = (spiImpl.engineGetOutputSize(inputLen));
        addTaint(inputLen);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_462530435 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_462530435;
        // ---------- Original Method ----------
        //if (mode == 0) {
            //throw new IllegalStateException("Cipher has not yet been initialized");
        //}
        //return spiImpl.engineGetOutputSize(inputLen);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.205 -0400", hash_original_method = "99DAD5FABE956FC53B6CC59AB3BC8215", hash_generated_method = "B2BF909D6F3CADC77A5848452226FCA9")
    public final byte[] getIV() {
        byte[] varF39A8F67ED88EFD7729A12FFE5019423_1109295392 = (spiImpl.engineGetIV());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1852100057 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1852100057;
        // ---------- Original Method ----------
        //return spiImpl.engineGetIV();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.206 -0400", hash_original_method = "1EF273790A635FFB8595723F2B2D47C7", hash_generated_method = "EB3DF2C7231AA010AAAD212189D02650")
    public final AlgorithmParameters getParameters() {
        AlgorithmParameters varB4EAC82CA7396A68D541C85D26508E83_1609128090 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1609128090 = spiImpl.engineGetParameters();
        varB4EAC82CA7396A68D541C85D26508E83_1609128090.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1609128090;
        // ---------- Original Method ----------
        //return spiImpl.engineGetParameters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.206 -0400", hash_original_method = "8BD6E3BF151C3D35A58DA717088B655C", hash_generated_method = "B81A10F447D5F317964467C19CF79B67")
    public final ExemptionMechanism getExemptionMechanism() {
        ExemptionMechanism varB4EAC82CA7396A68D541C85D26508E83_1350837438 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1350837438 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1350837438.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1350837438;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.207 -0400", hash_original_method = "429E4D2BD5B61AF47430304468140423", hash_generated_method = "C2A3AB159EF15D957C2D478C7A7CE842")
    public final void init(int opmode, Key key) throws InvalidKeyException {
        {
            secureRandom = new SecureRandom();
        } //End block
        init(opmode, key, secureRandom);
        addTaint(opmode);
        addTaint(key.getTaint());
        // ---------- Original Method ----------
        //if (secureRandom == null) {
            //secureRandom = new SecureRandom();
        //}
        //init(opmode, key, secureRandom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.207 -0400", hash_original_method = "0BCC9283EB770D83968E2D5392900813", hash_generated_method = "FF21989E4EEF2657E3799ADBE6C70007")
    public final void init(int opmode, Key key, SecureRandom random) throws InvalidKeyException {
        checkMode(opmode);
        spiImpl.engineInit(opmode, key, random);
        mode = opmode;
        addTaint(key.getTaint());
        addTaint(random.getTaint());
        // ---------- Original Method ----------
        //checkMode(opmode);
        //spiImpl.engineInit(opmode, key, random);
        //mode = opmode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.208 -0400", hash_original_method = "09F21B40649178B5CD7EDFF6A1F24869", hash_generated_method = "A0C5FF0AFE61DA0FD37EB83FC981A6E3")
    private void checkMode(int mode) {
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidParameterException("Invalid mode: " + mode);
        } //End block
        addTaint(mode);
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE
            //&& mode != UNWRAP_MODE && mode != WRAP_MODE) {
            //throw new InvalidParameterException("Invalid mode: " + mode);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.208 -0400", hash_original_method = "BBC8C1A41A2EA4CA6303B616FCC7D14B", hash_generated_method = "27B4B517EEA41705009C3EB80D85D380")
    public final void init(int opmode, Key key, AlgorithmParameterSpec params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        {
            secureRandom = new SecureRandom();
        } //End block
        init(opmode, key, params, secureRandom);
        addTaint(opmode);
        addTaint(key.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //if (secureRandom == null) {
            //secureRandom = new SecureRandom();
        //}
        //init(opmode, key, params, secureRandom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.209 -0400", hash_original_method = "8E7DC73E6E4E585B73E6EA7E879FC58B", hash_generated_method = "E9473106233C570C09553E4D007FDD02")
    public final void init(int opmode, Key key, AlgorithmParameterSpec params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException {
        checkMode(opmode);
        spiImpl.engineInit(opmode, key, params, random);
        mode = opmode;
        addTaint(key.getTaint());
        addTaint(params.getTaint());
        addTaint(random.getTaint());
        // ---------- Original Method ----------
        //checkMode(opmode);
        //spiImpl.engineInit(opmode, key, params, random);
        //mode = opmode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.217 -0400", hash_original_method = "BF9CD5FCB5A2729A943C192A3430B212", hash_generated_method = "2997AC0870B8C2964EA78FD41A07B520")
    public final void init(int opmode, Key key, AlgorithmParameters params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        {
            secureRandom = new SecureRandom();
        } //End block
        init(opmode, key, params, secureRandom);
        addTaint(opmode);
        addTaint(key.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //if (secureRandom == null) {
            //secureRandom = new SecureRandom();
        //}
        //init(opmode, key, params, secureRandom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.218 -0400", hash_original_method = "807F390A384AF896657386359C87C81B", hash_generated_method = "78A589ADBC90B751FFCA7A813DFE8E2A")
    public final void init(int opmode, Key key, AlgorithmParameters params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException {
        checkMode(opmode);
        spiImpl.engineInit(opmode, key, params, random);
        mode = opmode;
        addTaint(key.getTaint());
        addTaint(params.getTaint());
        addTaint(random.getTaint());
        // ---------- Original Method ----------
        //checkMode(opmode);
        //spiImpl.engineInit(opmode, key, params, random);
        //mode = opmode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.219 -0400", hash_original_method = "D1B8B02AA4362AEA38C29780F594C5E0", hash_generated_method = "E3C3C668D4F8CF78C498ABEC5DBCCFCB")
    public final void init(int opmode, Certificate certificate) throws InvalidKeyException {
        {
            secureRandom = new SecureRandom();
        } //End block
        init(opmode, certificate, secureRandom);
        addTaint(opmode);
        addTaint(certificate.getTaint());
        // ---------- Original Method ----------
        //if (secureRandom == null) {
            //secureRandom = new SecureRandom();
        //}
        //init(opmode, certificate, secureRandom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.298 -0400", hash_original_method = "CF5B7C36D9EDA90E4E4A39DDF2F721FD", hash_generated_method = "79CCF43753EA41634C380AE569775B2C")
    public final void init(int opmode, Certificate certificate,
            SecureRandom random) throws InvalidKeyException {
        checkMode(opmode);
        {
            Set<String> ce;
            ce = ((X509Certificate) certificate).getCriticalExtensionOIDs();
            boolean critical;
            critical = false;
            {
                boolean varDDB63590F71C7F795B762D8E1B335B14_2031038115 = (ce != null && !ce.isEmpty());
                {
                    {
                        Iterator<String> varC6C2BDA0B08F132339A9FC601896034F_1025177625 = (ce).iterator();
                        varC6C2BDA0B08F132339A9FC601896034F_1025177625.hasNext();
                        String oid = varC6C2BDA0B08F132339A9FC601896034F_1025177625.next();
                        {
                            {
                                boolean varF237574E9036314771607A16E87EB51E_392857707 = (oid.equals("2.5.29.15"));
                                {
                                    critical = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean[] keyUsage;
                        keyUsage = ((X509Certificate) certificate).getKeyUsage();
                        {
                            {
                                if (DroidSafeAndroidRuntime.control) throw new InvalidKeyException("The public key in the certificate "
                                                          + "cannot be used for ENCRYPT_MODE");
                            } //End block
                            {
                                if (DroidSafeAndroidRuntime.control) throw new InvalidKeyException("The public key in the certificate "
                                                          + "cannot be used for WRAP_MODE");
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        spiImpl.engineInit(opmode, certificate.getPublicKey(), random);
        mode = opmode;
        addTaint(certificate.getTaint());
        addTaint(random.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.298 -0400", hash_original_method = "D2539732F50CEA46903EFE3EE2FFBB7D", hash_generated_method = "849031B1DD723D9980282B8B363396DA")
    public final byte[] update(byte[] input) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("input == null");
        } //End block
        byte[] varBB9EEFA976093A356AD99D9F975AF898_39035194 = (spiImpl.engineUpdate(input, 0, input.length));
        addTaint(input[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2090960312 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2090960312;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.302 -0400", hash_original_method = "6B0ED73318E2DF96B368CBFEB9D8FD9F", hash_generated_method = "E3BF6D1A36D13AE39443900BE16F31CF")
    public final byte[] update(byte[] input, int inputOffset, int inputLen) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("input == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
        } //End block
        byte[] varE2D2921D02BFC84845A8291C070C3EF9_355061789 = (spiImpl.engineUpdate(input, inputOffset, inputLen));
        addTaint(input[0]);
        addTaint(inputOffset);
        addTaint(inputLen);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_448655458 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_448655458;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.307 -0400", hash_original_method = "851A7508725C6167E01999D358074612", hash_generated_method = "CFFD8B8E73811DAE523901DF97934CFE")
    public final int update(byte[] input, int inputOffset, int inputLen,
            byte[] output) throws ShortBufferException {
        int var2E26131E6B86565462CBCCF91C86587D_2089799238 = (update(input, inputOffset, inputLen, output, 0));
        addTaint(input[0]);
        addTaint(inputOffset);
        addTaint(inputLen);
        addTaint(output[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627626056 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627626056;
        // ---------- Original Method ----------
        //return update(input, inputOffset, inputLen, output, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.315 -0400", hash_original_method = "43E41610DEFFC00737E44CA5E5476BCF", hash_generated_method = "7FF9DD6C3E30FA051F6A1715CAC15973")
    public final int update(byte[] input, int inputOffset, int inputLen,
            byte[] output, int outputOffset) throws ShortBufferException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("input == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("output == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("outputOffset < 0");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
        } //End block
        int varF0FBC9F5208602AFDCA262C62CD07438_1924417575 = (spiImpl.engineUpdate(input, inputOffset, inputLen, output,
                outputOffset));
        addTaint(input[0]);
        addTaint(inputOffset);
        addTaint(inputLen);
        addTaint(output[0]);
        addTaint(outputOffset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1595135558 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1595135558;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.316 -0400", hash_original_method = "3650ED22F64FB3DE8113B7C668BA6C70", hash_generated_method = "B7C27B0C8151E7E4CD30DA3B4911DA87")
    public final int update(ByteBuffer input, ByteBuffer output) throws ShortBufferException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("input == output");
        } //End block
        int var08D6DCA405F0E2AFF23DAB431AE4D5FA_980352206 = (spiImpl.engineUpdate(input, output));
        addTaint(input.getTaint());
        addTaint(output.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_280229568 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_280229568;
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //if (input == output) {
            //throw new IllegalArgumentException("input == output");
        //}
        //return spiImpl.engineUpdate(input, output);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.316 -0400", hash_original_method = "F0FEA4F0F73707A698ECC32C0962F654", hash_generated_method = "299A777BBBC718ECC263BACD0077424A")
    public final byte[] doFinal() throws IllegalBlockSizeException,
            BadPaddingException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        byte[] var1BC40C2B1F5E74FBA517B9B562AEB668_1956367907 = (spiImpl.engineDoFinal(null, 0, 0));
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_440605662 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_440605662;
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //return spiImpl.engineDoFinal(null, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.317 -0400", hash_original_method = "93AA6B063068AA94349A945C7753479D", hash_generated_method = "5A43BFA2D07BB0BA0248D5F85106C550")
    public final int doFinal(byte[] output, int outputOffset) throws IllegalBlockSizeException, ShortBufferException,
            BadPaddingException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("outputOffset < 0");
        } //End block
        int var40DF1829FABED58AAFBB5BB03C28C7DA_400175515 = (spiImpl.engineDoFinal(null, 0, 0, output, outputOffset));
        addTaint(output[0]);
        addTaint(outputOffset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_293835414 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_293835414;
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //if (outputOffset < 0) {
            //throw new IllegalArgumentException("outputOffset < 0");
        //}
        //return spiImpl.engineDoFinal(null, 0, 0, output, outputOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.321 -0400", hash_original_method = "ED0F518E6798AF2EE42518F6A3E77904", hash_generated_method = "984EC563B4125F15D91011773AE9D3FC")
    public final byte[] doFinal(byte[] input) throws IllegalBlockSizeException,
            BadPaddingException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        byte[] varFB0DA14B66B0D469CBEEC4EA577AD97A_788682659 = (spiImpl.engineDoFinal(input, 0, input.length));
        addTaint(input[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_313407095 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_313407095;
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //return spiImpl.engineDoFinal(input, 0, input.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.332 -0400", hash_original_method = "6B1737194DBFF54F3884AE72A596BA42", hash_generated_method = "416B5302DB5AC27AD577F734B54CC6E6")
    public final byte[] doFinal(byte[] input, int inputOffset, int inputLen) throws IllegalBlockSizeException, BadPaddingException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
        } //End block
        byte[] var758EBECFA415D86DE74D50800380706C_375374566 = (spiImpl.engineDoFinal(input, inputOffset, inputLen));
        addTaint(input[0]);
        addTaint(inputOffset);
        addTaint(inputLen);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1451069470 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1451069470;
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //if (inputOffset < 0 || inputLen < 0 || inputOffset + inputLen > input.length) {
            //throw new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
        //}
        //return spiImpl.engineDoFinal(input, inputOffset, inputLen);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.332 -0400", hash_original_method = "A6D208F07F7B0D8A8A4180809C2EF479", hash_generated_method = "9DCAE2C4CBBEE37B53051098F2FC9152")
    public final int doFinal(byte[] input, int inputOffset, int inputLen,
            byte[] output) throws ShortBufferException,
            IllegalBlockSizeException, BadPaddingException {
        int var31ADE8267404DAD0B68134433BA06588_1814477890 = (doFinal(input, inputOffset, inputLen, output, 0));
        addTaint(input[0]);
        addTaint(inputOffset);
        addTaint(inputLen);
        addTaint(output[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180071615 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180071615;
        // ---------- Original Method ----------
        //return doFinal(input, inputOffset, inputLen, output, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.333 -0400", hash_original_method = "46F54FF2783CE552AE826C81B354A349", hash_generated_method = "4B6AD7A4CC2E33E6521BEF8322E6E395")
    public final int doFinal(byte[] input, int inputOffset, int inputLen,
            byte[] output, int outputOffset) throws ShortBufferException,
            IllegalBlockSizeException, BadPaddingException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
        } //End block
        int var7E4391C5895FEE22ABF165285F029094_2137422212 = (spiImpl.engineDoFinal(input, inputOffset, inputLen, output,
                outputOffset));
        addTaint(input[0]);
        addTaint(inputOffset);
        addTaint(inputLen);
        addTaint(output[0]);
        addTaint(outputOffset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1611525580 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1611525580;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.334 -0400", hash_original_method = "90770161074657C0B33458A086574F5B", hash_generated_method = "D6ACE0854B9C290C7E4DC5B2149F1589")
    public final int doFinal(ByteBuffer input, ByteBuffer output) throws ShortBufferException, IllegalBlockSizeException,
            BadPaddingException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("input == output");
        } //End block
        int varB435D60D692DCFF98C9D0347FB2085E3_1572166489 = (spiImpl.engineDoFinal(input, output));
        addTaint(input.getTaint());
        addTaint(output.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1477870629 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1477870629;
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //if (input == output) {
            //throw new IllegalArgumentException("input == output");
        //}
        //return spiImpl.engineDoFinal(input, output);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.335 -0400", hash_original_method = "6E0DA752A02639D8B96D35F2A60D917D", hash_generated_method = "97AB57179A46224B680D824186D64E26")
    public final byte[] wrap(Key key) throws IllegalBlockSizeException,
            InvalidKeyException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        byte[] var8A1D9A52886535C3DCA3313F381A0875_1105951170 = (spiImpl.engineWrap(key));
        addTaint(key.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1060725156 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1060725156;
        // ---------- Original Method ----------
        //if (mode != WRAP_MODE) {
            //throw new IllegalStateException();
        //}
        //return spiImpl.engineWrap(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.335 -0400", hash_original_method = "601EF7D9B28B5898301EBC35141803DA", hash_generated_method = "8B0EAE94EFFEBD3DBFF1CDCE3C0012A4")
    public final Key unwrap(byte[] wrappedKey, String wrappedKeyAlgorithm,
            int wrappedKeyType) throws InvalidKeyException,
            NoSuchAlgorithmException {
        Key varB4EAC82CA7396A68D541C85D26508E83_1131181813 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1131181813 = spiImpl.engineUnwrap(wrappedKey, wrappedKeyAlgorithm,
                wrappedKeyType);
        addTaint(wrappedKey[0]);
        addTaint(wrappedKeyAlgorithm.getTaint());
        addTaint(wrappedKeyType);
        varB4EAC82CA7396A68D541C85D26508E83_1131181813.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1131181813;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.345 -0400", hash_original_field = "1644C81AE07E27E1FEC30500618DF91F", hash_generated_field = "2F15DC862DF8E709496A189635636236")

    public static final int DECRYPT_MODE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.345 -0400", hash_original_field = "32A5049D4D8BC622488ED3614A6C1936", hash_generated_field = "A83EC5987C5AA77E22791E25CFA393A2")

    public static final int ENCRYPT_MODE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.345 -0400", hash_original_field = "B6ADE1667AFE4B2AF1DE033A9EA82DE6", hash_generated_field = "0081C7108661D39138574156E05B2FCD")

    public static final int PRIVATE_KEY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.345 -0400", hash_original_field = "43A68F7DB1FE90EB93C24BB3173E6A98", hash_generated_field = "295FEA31A43E6359048D4E46607B1E49")

    public static final int PUBLIC_KEY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.345 -0400", hash_original_field = "50B9F5A3CE3751C169AD269B650AC0DF", hash_generated_field = "677CDE87FE6610FD7AB080651DB96E2F")

    public static final int SECRET_KEY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.345 -0400", hash_original_field = "7D2FB99606ED2EBA904633463A636E9E", hash_generated_field = "9CA0A457708663E8B7EA225ECB1B0CA6")

    public static final int UNWRAP_MODE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.345 -0400", hash_original_field = "0A500DC619F8995886543B5C47BACF9D", hash_generated_field = "04C8E84D8FBFED46FA7E0F269D64C2EB")

    public static final int WRAP_MODE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.345 -0400", hash_original_field = "DCAB4B1B48F0891C8AE16EB231D23614", hash_generated_field = "05B557B789EC1A98D11CED1DECCCD754")

    private static String SERVICE = "Cipher";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.345 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "82D6520D3C45D5046B0A4FDCEDAFF880")

    private static Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.345 -0400", hash_original_field = "7A369DC18E63D8C3EA510B9B660A072D", hash_generated_field = "09B90F530A62DA10A38CA3C1F3C2FAB8")

    private static SecureRandom secureRandom;
}

