package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteBuffer;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Iterator;
import java.util.Set;
import org.apache.harmony.security.fortress.Engine;

public abstract class Signature extends SignatureSpi {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.294 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.294 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.295 -0400", hash_original_field = "9C233C6B104734A34A36247701B5D158", hash_generated_field = "CDF6660334629CDE27FDB0FE309B0222")

    protected int state = UNINITIALIZED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.295 -0400", hash_original_method = "007DE01FB6A8AC35B06025EDE803711E", hash_generated_method = "64FBEE7041AF14FFB5E58DA4CDF89A1A")
    protected  Signature(String algorithm) {
        this.algorithm = algorithm;
        // ---------- Original Method ----------
        //this.algorithm = algorithm;
    }

    
        public static Signature getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        Object spi = sap.spi;
        Provider provider = sap.provider;
        if (spi instanceof Signature) {
            Signature result = (Signature) spi;
            result.algorithm = algorithm;
            result.provider = provider;
            return result;
        }
        return new SignatureImpl((SignatureSpi) spi, provider, algorithm);
    }

    
        public static Signature getInstance(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider p = Security.getProvider(provider);
        if (p == null) {
            throw new NoSuchProviderException(provider);
        }
        return getSignatureInstance(algorithm, p);
    }

    
        public static Signature getInstance(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        return getSignatureInstance(algorithm, provider);
    }

    
        private static Signature getSignatureInstance(String algorithm,
            Provider provider) throws NoSuchAlgorithmException {
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        if (spi instanceof Signature) {
            Signature result = (Signature) spi;
            result.algorithm = algorithm;
            result.provider = provider;
            return result;
        }
        return new SignatureImpl((SignatureSpi) spi, provider, algorithm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.296 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "C775E7A436495E0A83D65053DD58FED2")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_1996643224 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1996643224 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_1996643224.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1996643224;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.301 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "326A05C392E27E68F2EC6A7816246404")
    public final String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1976554430 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1976554430 = algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_1976554430.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1976554430;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.301 -0400", hash_original_method = "6F44917D7B2EA34B37DC316438211882", hash_generated_method = "7DF991F7DE5015496E9EFF5C7695840B")
    public final void initVerify(PublicKey publicKey) throws InvalidKeyException {
        engineInitVerify(publicKey);
        state = VERIFY;
        addTaint(publicKey.getTaint());
        // ---------- Original Method ----------
        //engineInitVerify(publicKey);
        //state = VERIFY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.312 -0400", hash_original_method = "D5B41FE621F8332C2172FC7A18EF69C6", hash_generated_method = "BB9621B2BDBAB13CD48DD809FB342709")
    public final void initVerify(Certificate certificate) throws InvalidKeyException {
        {
            Set ce;
            ce = ((X509Certificate) certificate).getCriticalExtensionOIDs();
            boolean critical;
            critical = false;
            {
                boolean varDDB63590F71C7F795B762D8E1B335B14_266377103 = (ce != null && !ce.isEmpty());
                {
                    {
                        Iterator i;
                        i = ce.iterator();
                        boolean var5A904445088E8F340E730368D637913B_124007156 = (i.hasNext());
                        {
                            {
                                boolean varB9F24731C04BED7035E9A2BB39B9E036_808882663 = ("2.5.29.15".equals(i.next()));
                                {
                                    critical = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean[] keyUsage;
                        keyUsage = ((X509Certificate) certificate)
                            .getKeyUsage();
                        {
                            if (DroidSafeAndroidRuntime.control) throw new InvalidKeyException("The public key in the certificate cannot be used for digital signature purposes");
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        engineInitVerify(certificate.getPublicKey());
        state = VERIFY;
        addTaint(certificate.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.314 -0400", hash_original_method = "B6C8D7AE33737E5AFF4E8BA0A220ACB3", hash_generated_method = "AED77E522704C4BF9B51D3D4F1BCB580")
    public final void initSign(PrivateKey privateKey) throws InvalidKeyException {
        engineInitSign(privateKey);
        state = SIGN;
        addTaint(privateKey.getTaint());
        // ---------- Original Method ----------
        //engineInitSign(privateKey);
        //state = SIGN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.315 -0400", hash_original_method = "94B0D7FD7FB8599FDCD6F4025918B2A9", hash_generated_method = "B3B9A957894924BFCD67186F7FEAFEAA")
    public final void initSign(PrivateKey privateKey, SecureRandom random) throws InvalidKeyException {
        engineInitSign(privateKey, random);
        state = SIGN;
        addTaint(privateKey.getTaint());
        addTaint(random.getTaint());
        // ---------- Original Method ----------
        //engineInitSign(privateKey, random);
        //state = SIGN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.315 -0400", hash_original_method = "1CBD4CB00E49A2B9C590273D2FD8D112", hash_generated_method = "196E10B436CDB98A02FC55FF521CDCC5")
    public final byte[] sign() throws SignatureException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature object is not initialized properly");
        } //End block
        byte[] var2BF540A96FDD13E31EC65A887FD9474C_259824402 = (engineSign());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1226383646 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1226383646;
        // ---------- Original Method ----------
        //if (state != SIGN) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //return engineSign();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.315 -0400", hash_original_method = "82A870C6C8965CC8E79085F7D8A960EB", hash_generated_method = "F6F1976B566B6E275B9172F50993DC27")
    public final int sign(byte[] outbuf, int offset, int len) throws SignatureException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature object is not initialized properly");
        } //End block
        int varAD8681934276A1CD16B838C3AB96F96D_209926486 = (engineSign(outbuf, offset, len));
        addTaint(outbuf[0]);
        addTaint(offset);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_140686494 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_140686494;
        // ---------- Original Method ----------
        //if (outbuf == null || offset < 0 || len < 0 ||
                //offset + len > outbuf.length) {
            //throw new IllegalArgumentException();
        //}
        //if (state != SIGN) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //return engineSign(outbuf, offset, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.316 -0400", hash_original_method = "C9B26283C94B06BB8BE60C57C40A18DF", hash_generated_method = "B6D87884373FF64DC20C4608DD8A22B5")
    public final boolean verify(byte[] signature) throws SignatureException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature object is not initialized properly");
        } //End block
        boolean var94E832A3545B70CECCD924171C5ED0C7_1424395761 = (engineVerify(signature));
        addTaint(signature[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1984050850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1984050850;
        // ---------- Original Method ----------
        //if (state != VERIFY) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //return engineVerify(signature);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.317 -0400", hash_original_method = "59329C8B89ACE0AC6C4DAAF18DA3F3C5", hash_generated_method = "DBF6DCFF54A17CCD93AFFEF9068E1B7F")
    public final boolean verify(byte[] signature, int offset, int length) throws SignatureException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature object is not initialized properly");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        boolean varFB0754D41DA9EDEE16772952DEAC8EBB_386919055 = (engineVerify(signature, offset, length));
        addTaint(signature[0]);
        addTaint(offset);
        addTaint(length);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_329500620 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_329500620;
        // ---------- Original Method ----------
        //if (state != VERIFY) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //if (signature == null || offset < 0 || length < 0 ||
                //offset + length > signature.length) {
            //throw new IllegalArgumentException();
        //}
        //return engineVerify(signature, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.318 -0400", hash_original_method = "79EA6E53B3D29CDFCD3B6E1380EAFC50", hash_generated_method = "B3DFE1574350334CC05E87600930B0FC")
    public final void update(byte b) throws SignatureException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature object is not initialized properly");
        } //End block
        engineUpdate(b);
        addTaint(b);
        // ---------- Original Method ----------
        //if (state == UNINITIALIZED) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //engineUpdate(b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.318 -0400", hash_original_method = "7FDD4CB7D645E432F89E836C71DCF871", hash_generated_method = "123CE938E31CDA7EA722E1E2A2BE0836")
    public final void update(byte[] data) throws SignatureException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature object is not initialized properly");
        } //End block
        engineUpdate(data, 0, data.length);
        addTaint(data[0]);
        // ---------- Original Method ----------
        //if (state == UNINITIALIZED) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //engineUpdate(data, 0, data.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.324 -0400", hash_original_method = "935040FEA1E890342F7B1ED90DB7090F", hash_generated_method = "078C123E3D92F10DCC2037A5146A0BA5")
    public final void update(byte[] data, int off, int len) throws SignatureException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature object is not initialized properly");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        engineUpdate(data, off, len);
        addTaint(data[0]);
        addTaint(off);
        addTaint(len);
        // ---------- Original Method ----------
        //if (state == UNINITIALIZED) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //if (data == null || off < 0 || len < 0 ||
                //off + len > data.length) {
            //throw new IllegalArgumentException();
        //}
        //engineUpdate(data, off, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.335 -0400", hash_original_method = "4D212376BB0D0E0EE1EF0BE20DC8A649", hash_generated_method = "C0D2524110FE4B07310722D3F3E952CB")
    public final void update(ByteBuffer data) throws SignatureException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature object is not initialized properly");
        } //End block
        engineUpdate(data);
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        //if (state == UNINITIALIZED) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //engineUpdate(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.336 -0400", hash_original_method = "300ADD63628A84B0D8F725B1BA1E9A8E", hash_generated_method = "94463985C6503F3A916CF7700644AAE0")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1314606019 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1314606019 = "SIGNATURE " + algorithm + " state: " + stateToString(state);
        varB4EAC82CA7396A68D541C85D26508E83_1314606019.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1314606019;
        // ---------- Original Method ----------
        //return "SIGNATURE " + algorithm + " state: " + stateToString(state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.389 -0400", hash_original_method = "C1A460A3B710FBA1ED28C52AC5BBE911", hash_generated_method = "4535D3F218BD158A42670265CB39246D")
    private String stateToString(int state) {
        String varB4EAC82CA7396A68D541C85D26508E83_25612742 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_863629221 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1810817493 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_529661210 = null; //Variable for return #4
        //Begin case UNINITIALIZED 
        varB4EAC82CA7396A68D541C85D26508E83_25612742 = "UNINITIALIZED";
        //End case UNINITIALIZED 
        //Begin case SIGN 
        varB4EAC82CA7396A68D541C85D26508E83_863629221 = "SIGN";
        //End case SIGN 
        //Begin case VERIFY 
        varB4EAC82CA7396A68D541C85D26508E83_1810817493 = "VERIFY";
        //End case VERIFY 
        //Begin case default 
        varB4EAC82CA7396A68D541C85D26508E83_529661210 = "";
        //End case default 
        addTaint(state);
        String varA7E53CE21691AB073D9660D615818899_1672206382; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1672206382 = varB4EAC82CA7396A68D541C85D26508E83_25612742;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1672206382 = varB4EAC82CA7396A68D541C85D26508E83_863629221;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1672206382 = varB4EAC82CA7396A68D541C85D26508E83_1810817493;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1672206382 = varB4EAC82CA7396A68D541C85D26508E83_529661210;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1672206382.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1672206382;
        // ---------- Original Method ----------
        //switch (state) {
        //case UNINITIALIZED:
            //return "UNINITIALIZED";
        //case SIGN:
            //return "SIGN";
        //case VERIFY:
            //return "VERIFY";
        //default:
            //return "";
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.389 -0400", hash_original_method = "D52E00AF44B32CEF42E7B7F3CD02413C", hash_generated_method = "EE8ED28BB8FD864F4F3BB7628DDA17DA")
    @Deprecated
    public final void setParameter(String param, Object value) throws InvalidParameterException {
        engineSetParameter(param, value);
        addTaint(param.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //engineSetParameter(param, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.389 -0400", hash_original_method = "723DAA3D9E86E61831D60007CF8F8BBA", hash_generated_method = "E94277CAD3F337D2E713337B3753A3E1")
    public final void setParameter(AlgorithmParameterSpec params) throws InvalidAlgorithmParameterException {
        engineSetParameter(params);
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //engineSetParameter(params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.391 -0400", hash_original_method = "8EDBC3AD900BE7B10A8F191CA049C5A8", hash_generated_method = "D2C8BE2D2A9DDC69956D014DCBE5734E")
    public final AlgorithmParameters getParameters() {
        AlgorithmParameters varB4EAC82CA7396A68D541C85D26508E83_1268834131 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1268834131 = engineGetParameters();
        varB4EAC82CA7396A68D541C85D26508E83_1268834131.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1268834131;
        // ---------- Original Method ----------
        //return engineGetParameters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.392 -0400", hash_original_method = "3218EA86DC018EF694546DAFA3BC417D", hash_generated_method = "E17B42870AAF799EE11DA4440BACC8DE")
    @Deprecated
    public final Object getParameter(String param) throws InvalidParameterException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2035643894 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2035643894 = engineGetParameter(param);
        addTaint(param.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2035643894.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2035643894;
        // ---------- Original Method ----------
        //return engineGetParameter(param);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.392 -0400", hash_original_method = "31D01322C9910F836DA03F7FCF4D6261", hash_generated_method = "2D64DCB29B09EFE00ED5C0BE3180E8FF")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_460781254 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_460781254 = super.clone();
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new CloneNotSupportedException();
        varB4EAC82CA7396A68D541C85D26508E83_460781254.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_460781254;
        // ---------- Original Method ----------
        //if (this instanceof Cloneable) {
            //return super.clone();
        //}
        //throw new CloneNotSupportedException();
    }

    
    private static class SignatureImpl extends Signature {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.392 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "B117D5F80D09F234127E3A3393EBC255")

        private SignatureSpi spiImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.393 -0400", hash_original_method = "3E4D7926596EAD873E22E30BA201B1D4", hash_generated_method = "4055D650899BEE3D4C0362B2C3CB0C1D")
        public  SignatureImpl(SignatureSpi signatureSpi, Provider provider,
                String algorithm) {
            super(algorithm);
            super.provider = provider;
            spiImpl = signatureSpi;
            addTaint(provider.getTaint());
            addTaint(algorithm.getTaint());
            // ---------- Original Method ----------
            //super.provider = provider;
            //spiImpl = signatureSpi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.397 -0400", hash_original_method = "FFC69249636133C4828AD78F0F12AF56", hash_generated_method = "75FFFAFC385848546C5476AAA8486FBA")
        @Override
        protected byte[] engineSign() throws SignatureException {
            byte[] var3C6A4D7933B903A8370E3026808FCCC3_1142068615 = (spiImpl.engineSign());
            byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_568305828 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_568305828;
            // ---------- Original Method ----------
            //return spiImpl.engineSign();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.398 -0400", hash_original_method = "5E472B7CE8DF4677B6CD62A0BE3E6E55", hash_generated_method = "F7EB7DF7DF9A873B6FC16CB63EBF710A")
        @Override
        protected void engineUpdate(byte arg0) throws SignatureException {
            spiImpl.engineUpdate(arg0);
            addTaint(arg0);
            // ---------- Original Method ----------
            //spiImpl.engineUpdate(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.398 -0400", hash_original_method = "5B50F80B75147450A8AE91D93998317F", hash_generated_method = "6C94234815E337DD4AFECEDC1284EB22")
        @Override
        protected boolean engineVerify(byte[] arg0) throws SignatureException {
            boolean var3D9968658679B18190A4A74E628A43C7_1319624191 = (spiImpl.engineVerify(arg0));
            addTaint(arg0[0]);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_590774950 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_590774950;
            // ---------- Original Method ----------
            //return spiImpl.engineVerify(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.398 -0400", hash_original_method = "8E9D74168176A196545DE618D70F0045", hash_generated_method = "279361F6097A58D6CD6D18347E63CA8E")
        @Override
        protected void engineUpdate(byte[] arg0, int arg1, int arg2) throws SignatureException {
            spiImpl.engineUpdate(arg0, arg1, arg2);
            addTaint(arg0[0]);
            addTaint(arg1);
            addTaint(arg2);
            // ---------- Original Method ----------
            //spiImpl.engineUpdate(arg0, arg1, arg2);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.399 -0400", hash_original_method = "8D0AD1B347F88E648DA57C6C188D8255", hash_generated_method = "7FAC5478537D5C82A1AB678274B82BF3")
        @Override
        protected void engineInitSign(PrivateKey arg0) throws InvalidKeyException {
            spiImpl.engineInitSign(arg0);
            addTaint(arg0.getTaint());
            // ---------- Original Method ----------
            //spiImpl.engineInitSign(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.399 -0400", hash_original_method = "C51005CD648E9A95CA7D0B48071C4D8E", hash_generated_method = "8ED9B851FA478C09728EB7EF5132E07C")
        @Override
        protected void engineInitVerify(PublicKey arg0) throws InvalidKeyException {
            spiImpl.engineInitVerify(arg0);
            addTaint(arg0.getTaint());
            // ---------- Original Method ----------
            //spiImpl.engineInitVerify(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.399 -0400", hash_original_method = "BC25730F2F2C84CFB445E50D8EAB3A12", hash_generated_method = "E0662266486B9BD62FDE0D3369A9057E")
        @Override
        protected Object engineGetParameter(String arg0) throws InvalidParameterException {
            Object varB4EAC82CA7396A68D541C85D26508E83_79396144 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_79396144 = spiImpl.engineGetParameter(arg0);
            addTaint(arg0.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_79396144.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_79396144;
            // ---------- Original Method ----------
            //return spiImpl.engineGetParameter(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.400 -0400", hash_original_method = "2EB6574DEFEEC579E00AC6D7C846FB9A", hash_generated_method = "F741EFB2B1AB869B044163F8F920209A")
        @Override
        protected void engineSetParameter(String arg0, Object arg1) throws InvalidParameterException {
            spiImpl.engineSetParameter(arg0, arg1);
            addTaint(arg0.getTaint());
            addTaint(arg1.getTaint());
            // ---------- Original Method ----------
            //spiImpl.engineSetParameter(arg0, arg1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.400 -0400", hash_original_method = "E18D3A064C93BFFE53C93A44BEF059CB", hash_generated_method = "9A25D8072439EE2BA94D72A1A39F70B3")
        @Override
        public Object clone() throws CloneNotSupportedException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1259097751 = null; //Variable for return #1
            {
                SignatureSpi spi;
                spi = (SignatureSpi) spiImpl.clone();
                varB4EAC82CA7396A68D541C85D26508E83_1259097751 = new SignatureImpl(spi, getProvider(), getAlgorithm());
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new CloneNotSupportedException();
            varB4EAC82CA7396A68D541C85D26508E83_1259097751.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1259097751;
            // ---------- Original Method ----------
            //if (spiImpl instanceof Cloneable) {
                //SignatureSpi spi = (SignatureSpi) spiImpl.clone();
                //return new SignatureImpl(spi, getProvider(), getAlgorithm());
            //}
            //throw new CloneNotSupportedException();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.400 -0400", hash_original_field = "A295D45862B91D430A865A6C93B9F575", hash_generated_field = "0111001A28228123EC60B050C0EF78F0")

    private static String SERVICE = "Signature";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.400 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "82D6520D3C45D5046B0A4FDCEDAFF880")

    private static Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.400 -0400", hash_original_field = "7829D7E12A8615805E93FA4D71B48E33", hash_generated_field = "A1E0C36ADEBBD25D50AF7AF13BBE1FC5")

    protected static int UNINITIALIZED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.400 -0400", hash_original_field = "AD0C3134958983CF0EFFDE205ED3D704", hash_generated_field = "5958804B8E67A2204CD414FEB5A5F022")

    protected static int SIGN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.400 -0400", hash_original_field = "871D2CAC53DED1F4A79E8557E740F34B", hash_generated_field = "8F1B3AB10F32AA2567B0FCD8355CB2B4")

    protected static int VERIFY = 3;
}

