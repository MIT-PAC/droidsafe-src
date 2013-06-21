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
    private int mode;
    private Provider provider;
    private CipherSpi spiImpl;
    private String transformation;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.942 -0400", hash_original_method = "169E8725E31AA026BEEB43CC41C0DB25", hash_generated_method = "3DB0A197D98E0FAB731EB422229CA467")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Cipher(CipherSpi cipherSpi, Provider provider,
            String transformation) {
        dsTaint.addTaint(cipherSpi.dsTaint);
        dsTaint.addTaint(provider.dsTaint);
        dsTaint.addTaint(transformation);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.943 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "828895F1878B3605546159F61AC099C2")
    @DSModeled(DSC.SAFE)
    public final Provider getProvider() {
        return (Provider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.944 -0400", hash_original_method = "8DF6BCF87B142C85CC5BB8E6263E3718", hash_generated_method = "E4A5632CFE60CF8927D7DFA425972AA8")
    @DSModeled(DSC.SAFE)
    public final String getAlgorithm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return transformation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.944 -0400", hash_original_method = "D9E2BEA1F59A5109A8382C65AF7F31D0", hash_generated_method = "7C6143AC102685A573BD390CFF775956")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getBlockSize() {
        int var7364A97EC441053FEC79B2C935557BB1_1664646057 = (spiImpl.engineGetBlockSize());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return spiImpl.engineGetBlockSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.944 -0400", hash_original_method = "AA8C5558649103E88A25D53E8218E1F5", hash_generated_method = "972DFB542D2E9854DB3A17A4C60A1289")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getOutputSize(int inputLen) {
        dsTaint.addTaint(inputLen);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cipher has not yet been initialized");
        } //End block
        int var179ED6F279F10B55227291448D76B240_2047846782 = (spiImpl.engineGetOutputSize(inputLen));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mode == 0) {
            //throw new IllegalStateException("Cipher has not yet been initialized");
        //}
        //return spiImpl.engineGetOutputSize(inputLen);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.944 -0400", hash_original_method = "99DAD5FABE956FC53B6CC59AB3BC8215", hash_generated_method = "3DFB5D2AFE2AB57906A397A9247F2080")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte[] getIV() {
        byte[] varF39A8F67ED88EFD7729A12FFE5019423_1767496743 = (spiImpl.engineGetIV());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return spiImpl.engineGetIV();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.944 -0400", hash_original_method = "1EF273790A635FFB8595723F2B2D47C7", hash_generated_method = "A8741C47D7BA11530F033275FE3EC001")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final AlgorithmParameters getParameters() {
        AlgorithmParameters var3AD6982DAD6BE5CBF210F7AFFB10E62F_1614611754 = (spiImpl.engineGetParameters());
        return (AlgorithmParameters)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGetParameters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.945 -0400", hash_original_method = "8BD6E3BF151C3D35A58DA717088B655C", hash_generated_method = "84C85386C8E369596F9DCAEE1DB78638")
    @DSModeled(DSC.SAFE)
    public final ExemptionMechanism getExemptionMechanism() {
        return (ExemptionMechanism)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.945 -0400", hash_original_method = "429E4D2BD5B61AF47430304468140423", hash_generated_method = "2A510A7B254C4FE7A43F617F0503523F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void init(int opmode, Key key) throws InvalidKeyException {
        dsTaint.addTaint(opmode);
        dsTaint.addTaint(key.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.945 -0400", hash_original_method = "0BCC9283EB770D83968E2D5392900813", hash_generated_method = "2404FCE621F70CDCF28110F6F142BFA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void init(int opmode, Key key, SecureRandom random) throws InvalidKeyException {
        dsTaint.addTaint(opmode);
        dsTaint.addTaint(random.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        checkMode(opmode);
        spiImpl.engineInit(opmode, key, random);
        // ---------- Original Method ----------
        //checkMode(opmode);
        //spiImpl.engineInit(opmode, key, random);
        //mode = opmode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.945 -0400", hash_original_method = "09F21B40649178B5CD7EDFF6A1F24869", hash_generated_method = "B75CD4C93590E096B27AA4207984A14F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkMode(int mode) {
        dsTaint.addTaint(mode);
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidParameterException("Invalid mode: " + mode);
        } //End block
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE
            //&& mode != UNWRAP_MODE && mode != WRAP_MODE) {
            //throw new InvalidParameterException("Invalid mode: " + mode);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.945 -0400", hash_original_method = "BBC8C1A41A2EA4CA6303B616FCC7D14B", hash_generated_method = "8FCE926F74773DD00A6ACF78EB1DB4AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void init(int opmode, Key key, AlgorithmParameterSpec params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        dsTaint.addTaint(opmode);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(key.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.946 -0400", hash_original_method = "8E7DC73E6E4E585B73E6EA7E879FC58B", hash_generated_method = "8EC26016B9B5D10A58DB0E46F9F106A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void init(int opmode, Key key, AlgorithmParameterSpec params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException {
        dsTaint.addTaint(opmode);
        dsTaint.addTaint(random.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        checkMode(opmode);
        spiImpl.engineInit(opmode, key, params, random);
        // ---------- Original Method ----------
        //checkMode(opmode);
        //spiImpl.engineInit(opmode, key, params, random);
        //mode = opmode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.946 -0400", hash_original_method = "BF9CD5FCB5A2729A943C192A3430B212", hash_generated_method = "E71F0F2E7B4BB74EA935415CBCB33D15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void init(int opmode, Key key, AlgorithmParameters params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        dsTaint.addTaint(opmode);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(key.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.946 -0400", hash_original_method = "807F390A384AF896657386359C87C81B", hash_generated_method = "43565064F99E614CA39E658E9EB12839")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void init(int opmode, Key key, AlgorithmParameters params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException {
        dsTaint.addTaint(opmode);
        dsTaint.addTaint(random.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        checkMode(opmode);
        spiImpl.engineInit(opmode, key, params, random);
        // ---------- Original Method ----------
        //checkMode(opmode);
        //spiImpl.engineInit(opmode, key, params, random);
        //mode = opmode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.946 -0400", hash_original_method = "D1B8B02AA4362AEA38C29780F594C5E0", hash_generated_method = "7E91DD934D3BA9227A987053F666DCF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void init(int opmode, Certificate certificate) throws InvalidKeyException {
        dsTaint.addTaint(certificate.dsTaint);
        dsTaint.addTaint(opmode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.953 -0400", hash_original_method = "CF5B7C36D9EDA90E4E4A39DDF2F721FD", hash_generated_method = "EFC58EA81D726233A4695F6CC63F663E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void init(int opmode, Certificate certificate,
            SecureRandom random) throws InvalidKeyException {
        dsTaint.addTaint(certificate.dsTaint);
        dsTaint.addTaint(opmode);
        dsTaint.addTaint(random.dsTaint);
        checkMode(opmode);
        {
            Set<String> ce;
            ce = ((X509Certificate) certificate).getCriticalExtensionOIDs();
            boolean critical;
            critical = false;
            {
                boolean varDDB63590F71C7F795B762D8E1B335B14_310084107 = (ce != null && !ce.isEmpty());
                {
                    {
                        Iterator<String> varC6C2BDA0B08F132339A9FC601896034F_1304707842 = (ce).iterator();
                        varC6C2BDA0B08F132339A9FC601896034F_1304707842.hasNext();
                        String oid = varC6C2BDA0B08F132339A9FC601896034F_1304707842.next();
                        {
                            {
                                boolean varF237574E9036314771607A16E87EB51E_1529380759 = (oid.equals("2.5.29.15"));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.953 -0400", hash_original_method = "D2539732F50CEA46903EFE3EE2FFBB7D", hash_generated_method = "E67E7B412222010E58CC63E8C227611D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte[] update(byte[] input) {
        dsTaint.addTaint(input[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("input == null");
        } //End block
        byte[] varBB9EEFA976093A356AD99D9F975AF898_1890697363 = (spiImpl.engineUpdate(input, 0, input.length));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.953 -0400", hash_original_method = "6B0ED73318E2DF96B368CBFEB9D8FD9F", hash_generated_method = "8A7AC08FE97A30EF97B921311A59F53E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte[] update(byte[] input, int inputOffset, int inputLen) {
        dsTaint.addTaint(input[0]);
        dsTaint.addTaint(inputOffset);
        dsTaint.addTaint(inputLen);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("input == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
        } //End block
        byte[] varE2D2921D02BFC84845A8291C070C3EF9_813023918 = (spiImpl.engineUpdate(input, inputOffset, inputLen));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.954 -0400", hash_original_method = "851A7508725C6167E01999D358074612", hash_generated_method = "F6A29158171A53CAD84A076E6F22FB10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int update(byte[] input, int inputOffset, int inputLen,
            byte[] output) throws ShortBufferException {
        dsTaint.addTaint(input[0]);
        dsTaint.addTaint(inputOffset);
        dsTaint.addTaint(inputLen);
        dsTaint.addTaint(output[0]);
        int var2E26131E6B86565462CBCCF91C86587D_1479704707 = (update(input, inputOffset, inputLen, output, 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return update(input, inputOffset, inputLen, output, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.954 -0400", hash_original_method = "43E41610DEFFC00737E44CA5E5476BCF", hash_generated_method = "AE3247030EE8FE125BFA4893568C83D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int update(byte[] input, int inputOffset, int inputLen,
            byte[] output, int outputOffset) throws ShortBufferException {
        dsTaint.addTaint(input[0]);
        dsTaint.addTaint(outputOffset);
        dsTaint.addTaint(inputOffset);
        dsTaint.addTaint(inputLen);
        dsTaint.addTaint(output[0]);
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
        int varF0FBC9F5208602AFDCA262C62CD07438_831755252 = (spiImpl.engineUpdate(input, inputOffset, inputLen, output,
                outputOffset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.954 -0400", hash_original_method = "3650ED22F64FB3DE8113B7C668BA6C70", hash_generated_method = "5D9B9652C3C90DCB9168A1AAB83030D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int update(ByteBuffer input, ByteBuffer output) throws ShortBufferException {
        dsTaint.addTaint(input.dsTaint);
        dsTaint.addTaint(output.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("input == output");
        } //End block
        int var08D6DCA405F0E2AFF23DAB431AE4D5FA_316082448 = (spiImpl.engineUpdate(input, output));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //if (input == output) {
            //throw new IllegalArgumentException("input == output");
        //}
        //return spiImpl.engineUpdate(input, output);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.954 -0400", hash_original_method = "F0FEA4F0F73707A698ECC32C0962F654", hash_generated_method = "C18A96577BD94979ED3F514B68959CB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte[] doFinal() throws IllegalBlockSizeException,
            BadPaddingException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        byte[] var1BC40C2B1F5E74FBA517B9B562AEB668_594548910 = (spiImpl.engineDoFinal(null, 0, 0));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //return spiImpl.engineDoFinal(null, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.954 -0400", hash_original_method = "93AA6B063068AA94349A945C7753479D", hash_generated_method = "AF32490E3D9AF345331045EED6DD7329")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int doFinal(byte[] output, int outputOffset) throws IllegalBlockSizeException, ShortBufferException,
            BadPaddingException {
        dsTaint.addTaint(outputOffset);
        dsTaint.addTaint(output[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("outputOffset < 0");
        } //End block
        int var40DF1829FABED58AAFBB5BB03C28C7DA_1614165875 = (spiImpl.engineDoFinal(null, 0, 0, output, outputOffset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //if (outputOffset < 0) {
            //throw new IllegalArgumentException("outputOffset < 0");
        //}
        //return spiImpl.engineDoFinal(null, 0, 0, output, outputOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.955 -0400", hash_original_method = "ED0F518E6798AF2EE42518F6A3E77904", hash_generated_method = "E9ECE21B14476464224ED568C1F06F29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte[] doFinal(byte[] input) throws IllegalBlockSizeException,
            BadPaddingException {
        dsTaint.addTaint(input[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        byte[] varFB0DA14B66B0D469CBEEC4EA577AD97A_652503932 = (spiImpl.engineDoFinal(input, 0, input.length));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //return spiImpl.engineDoFinal(input, 0, input.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.955 -0400", hash_original_method = "6B1737194DBFF54F3884AE72A596BA42", hash_generated_method = "221093DB7C5DC0429A3E09FA131C3561")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte[] doFinal(byte[] input, int inputOffset, int inputLen) throws IllegalBlockSizeException, BadPaddingException {
        dsTaint.addTaint(input[0]);
        dsTaint.addTaint(inputOffset);
        dsTaint.addTaint(inputLen);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
        } //End block
        byte[] var758EBECFA415D86DE74D50800380706C_1893455259 = (spiImpl.engineDoFinal(input, inputOffset, inputLen));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //if (inputOffset < 0 || inputLen < 0 || inputOffset + inputLen > input.length) {
            //throw new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
        //}
        //return spiImpl.engineDoFinal(input, inputOffset, inputLen);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.955 -0400", hash_original_method = "A6D208F07F7B0D8A8A4180809C2EF479", hash_generated_method = "9443E573AC5E596D20AF04F75BF3F926")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int doFinal(byte[] input, int inputOffset, int inputLen,
            byte[] output) throws ShortBufferException,
            IllegalBlockSizeException, BadPaddingException {
        dsTaint.addTaint(input[0]);
        dsTaint.addTaint(inputOffset);
        dsTaint.addTaint(inputLen);
        dsTaint.addTaint(output[0]);
        int var31ADE8267404DAD0B68134433BA06588_1460621522 = (doFinal(input, inputOffset, inputLen, output, 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return doFinal(input, inputOffset, inputLen, output, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.955 -0400", hash_original_method = "46F54FF2783CE552AE826C81B354A349", hash_generated_method = "AF15F3ABBF73C25D5C9AD1E3E59E6378")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int doFinal(byte[] input, int inputOffset, int inputLen,
            byte[] output, int outputOffset) throws ShortBufferException,
            IllegalBlockSizeException, BadPaddingException {
        dsTaint.addTaint(input[0]);
        dsTaint.addTaint(outputOffset);
        dsTaint.addTaint(inputOffset);
        dsTaint.addTaint(inputLen);
        dsTaint.addTaint(output[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
        } //End block
        int var7E4391C5895FEE22ABF165285F029094_101947952 = (spiImpl.engineDoFinal(input, inputOffset, inputLen, output,
                outputOffset));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.956 -0400", hash_original_method = "90770161074657C0B33458A086574F5B", hash_generated_method = "0EF10362E6F1C83CAE24CA0E14297E50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int doFinal(ByteBuffer input, ByteBuffer output) throws ShortBufferException, IllegalBlockSizeException,
            BadPaddingException {
        dsTaint.addTaint(input.dsTaint);
        dsTaint.addTaint(output.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("input == output");
        } //End block
        int varB435D60D692DCFF98C9D0347FB2085E3_1210774760 = (spiImpl.engineDoFinal(input, output));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            //throw new IllegalStateException();
        //}
        //if (input == output) {
            //throw new IllegalArgumentException("input == output");
        //}
        //return spiImpl.engineDoFinal(input, output);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.956 -0400", hash_original_method = "6E0DA752A02639D8B96D35F2A60D917D", hash_generated_method = "F7AEFA54E13FD16775AFE1847BBEBAB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte[] wrap(Key key) throws IllegalBlockSizeException,
            InvalidKeyException {
        dsTaint.addTaint(key.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        byte[] var8A1D9A52886535C3DCA3313F381A0875_589033581 = (spiImpl.engineWrap(key));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (mode != WRAP_MODE) {
            //throw new IllegalStateException();
        //}
        //return spiImpl.engineWrap(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.956 -0400", hash_original_method = "601EF7D9B28B5898301EBC35141803DA", hash_generated_method = "A45705B7B2939504F07F5429652163E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Key unwrap(byte[] wrappedKey, String wrappedKeyAlgorithm,
            int wrappedKeyType) throws InvalidKeyException,
            NoSuchAlgorithmException {
        dsTaint.addTaint(wrappedKeyAlgorithm);
        dsTaint.addTaint(wrappedKey[0]);
        dsTaint.addTaint(wrappedKeyType);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        Key var6FF96A64E59385860A56132BE8FC5314_53348213 = (spiImpl.engineUnwrap(wrappedKey, wrappedKeyAlgorithm,
                wrappedKeyType));
        return (Key)dsTaint.getTaint();
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

    
    public static final int DECRYPT_MODE = 2;
    public static final int ENCRYPT_MODE = 1;
    public static final int PRIVATE_KEY = 2;
    public static final int PUBLIC_KEY = 1;
    public static final int SECRET_KEY = 3;
    public static final int UNWRAP_MODE = 4;
    public static final int WRAP_MODE = 3;
    private static final String SERVICE = "Cipher";
    private static final Engine ENGINE = new Engine(SERVICE);
    private static SecureRandom secureRandom;
}

