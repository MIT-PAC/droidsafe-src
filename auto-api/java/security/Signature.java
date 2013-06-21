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
    private Provider provider;
    private String algorithm;
    protected int state = UNINITIALIZED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.589 -0400", hash_original_method = "007DE01FB6A8AC35B06025EDE803711E", hash_generated_method = "7684C0F857F2E36E09EEADC1ECB289F7")
    @DSModeled(DSC.SAFE)
    protected Signature(String algorithm) {
        dsTaint.addTaint(algorithm);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.591 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "828895F1878B3605546159F61AC099C2")
    @DSModeled(DSC.SAFE)
    public final Provider getProvider() {
        return (Provider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.591 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "D8B68EE02F71705BA62E93B42B805D25")
    @DSModeled(DSC.SAFE)
    public final String getAlgorithm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.591 -0400", hash_original_method = "6F44917D7B2EA34B37DC316438211882", hash_generated_method = "B9F18515FE04FC222195E3F375CD41EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void initVerify(PublicKey publicKey) throws InvalidKeyException {
        dsTaint.addTaint(publicKey.dsTaint);
        engineInitVerify(publicKey);
        state = VERIFY;
        // ---------- Original Method ----------
        //engineInitVerify(publicKey);
        //state = VERIFY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.592 -0400", hash_original_method = "D5B41FE621F8332C2172FC7A18EF69C6", hash_generated_method = "A1DE7F0778F50F8BC6D521F736EC0EB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void initVerify(Certificate certificate) throws InvalidKeyException {
        dsTaint.addTaint(certificate.dsTaint);
        {
            Set ce;
            ce = ((X509Certificate) certificate).getCriticalExtensionOIDs();
            boolean critical;
            critical = false;
            {
                boolean varDDB63590F71C7F795B762D8E1B335B14_1325670437 = (ce != null && !ce.isEmpty());
                {
                    {
                        Iterator i;
                        i = ce.iterator();
                        boolean var5A904445088E8F340E730368D637913B_231887342 = (i.hasNext());
                        {
                            {
                                boolean varB9F24731C04BED7035E9A2BB39B9E036_109494501 = ("2.5.29.15".equals(i.next()));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.592 -0400", hash_original_method = "B6C8D7AE33737E5AFF4E8BA0A220ACB3", hash_generated_method = "7F408B84EE2A3816FD440C7C3E2F9213")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void initSign(PrivateKey privateKey) throws InvalidKeyException {
        dsTaint.addTaint(privateKey.dsTaint);
        engineInitSign(privateKey);
        state = SIGN;
        // ---------- Original Method ----------
        //engineInitSign(privateKey);
        //state = SIGN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.592 -0400", hash_original_method = "94B0D7FD7FB8599FDCD6F4025918B2A9", hash_generated_method = "92AF3E89F1F36EDE0B2CA24FA1999809")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void initSign(PrivateKey privateKey, SecureRandom random) throws InvalidKeyException {
        dsTaint.addTaint(privateKey.dsTaint);
        dsTaint.addTaint(random.dsTaint);
        engineInitSign(privateKey, random);
        state = SIGN;
        // ---------- Original Method ----------
        //engineInitSign(privateKey, random);
        //state = SIGN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.592 -0400", hash_original_method = "1CBD4CB00E49A2B9C590273D2FD8D112", hash_generated_method = "505EAC70C1A16D7E5329310B8F8763BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte[] sign() throws SignatureException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature object is not initialized properly");
        } //End block
        byte[] var2BF540A96FDD13E31EC65A887FD9474C_1035146764 = (engineSign());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (state != SIGN) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //return engineSign();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.592 -0400", hash_original_method = "82A870C6C8965CC8E79085F7D8A960EB", hash_generated_method = "E3051C195BC42DB05BD72A31095F5737")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int sign(byte[] outbuf, int offset, int len) throws SignatureException {
        dsTaint.addTaint(outbuf[0]);
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature object is not initialized properly");
        } //End block
        int varAD8681934276A1CD16B838C3AB96F96D_817853930 = (engineSign(outbuf, offset, len));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.593 -0400", hash_original_method = "C9B26283C94B06BB8BE60C57C40A18DF", hash_generated_method = "6E79552F47DC4F161D2B71385B8365A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean verify(byte[] signature) throws SignatureException {
        dsTaint.addTaint(signature[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature object is not initialized properly");
        } //End block
        boolean var94E832A3545B70CECCD924171C5ED0C7_838378449 = (engineVerify(signature));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (state != VERIFY) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //return engineVerify(signature);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.593 -0400", hash_original_method = "59329C8B89ACE0AC6C4DAAF18DA3F3C5", hash_generated_method = "23D5651A9573566D62C04754B6BC346B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean verify(byte[] signature, int offset, int length) throws SignatureException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(signature[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature object is not initialized properly");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        boolean varFB0754D41DA9EDEE16772952DEAC8EBB_1760523424 = (engineVerify(signature, offset, length));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.593 -0400", hash_original_method = "79EA6E53B3D29CDFCD3B6E1380EAFC50", hash_generated_method = "A3F091EB3C501878350D5F2E86427150")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void update(byte b) throws SignatureException {
        dsTaint.addTaint(b);
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature object is not initialized properly");
        } //End block
        engineUpdate(b);
        // ---------- Original Method ----------
        //if (state == UNINITIALIZED) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //engineUpdate(b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.593 -0400", hash_original_method = "7FDD4CB7D645E432F89E836C71DCF871", hash_generated_method = "E9F02CF1D9BBBBD06F002209965F0EF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void update(byte[] data) throws SignatureException {
        dsTaint.addTaint(data[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature object is not initialized properly");
        } //End block
        engineUpdate(data, 0, data.length);
        // ---------- Original Method ----------
        //if (state == UNINITIALIZED) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //engineUpdate(data, 0, data.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.594 -0400", hash_original_method = "935040FEA1E890342F7B1ED90DB7090F", hash_generated_method = "9AA65B5864A79445CE4E63BC3D02DEDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void update(byte[] data, int off, int len) throws SignatureException {
        dsTaint.addTaint(off);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(len);
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature object is not initialized properly");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        engineUpdate(data, off, len);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.594 -0400", hash_original_method = "4D212376BB0D0E0EE1EF0BE20DC8A649", hash_generated_method = "84137127F54F3AE93801A8B2425C21C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void update(ByteBuffer data) throws SignatureException {
        dsTaint.addTaint(data.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature object is not initialized properly");
        } //End block
        engineUpdate(data);
        // ---------- Original Method ----------
        //if (state == UNINITIALIZED) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //engineUpdate(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.594 -0400", hash_original_method = "300ADD63628A84B0D8F725B1BA1E9A8E", hash_generated_method = "085EADF8241BDB3B708B15FD4FDAB4B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varA3CB7FCFBB44906641DBAB78E7DF6CA9_685346424 = ("SIGNATURE " + algorithm + " state: " + stateToString(state));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "SIGNATURE " + algorithm + " state: " + stateToString(state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.594 -0400", hash_original_method = "C1A460A3B710FBA1ED28C52AC5BBE911", hash_generated_method = "265C05B6699405CB5F19AFEAFCC58534")
    @DSModeled(DSC.SAFE)
    private String stateToString(int state) {
        dsTaint.addTaint(state);
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.594 -0400", hash_original_method = "D52E00AF44B32CEF42E7B7F3CD02413C", hash_generated_method = "D3013277C9D9B4AD34CF2FE78B9B3DEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public final void setParameter(String param, Object value) throws InvalidParameterException {
        dsTaint.addTaint(param);
        dsTaint.addTaint(value.dsTaint);
        engineSetParameter(param, value);
        // ---------- Original Method ----------
        //engineSetParameter(param, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.594 -0400", hash_original_method = "723DAA3D9E86E61831D60007CF8F8BBA", hash_generated_method = "5C095560A2F47C63132CF5751EE5BB19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setParameter(AlgorithmParameterSpec params) throws InvalidAlgorithmParameterException {
        dsTaint.addTaint(params.dsTaint);
        engineSetParameter(params);
        // ---------- Original Method ----------
        //engineSetParameter(params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.595 -0400", hash_original_method = "8EDBC3AD900BE7B10A8F191CA049C5A8", hash_generated_method = "3DFB003EC6C705F1B6177C1D9418DBCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final AlgorithmParameters getParameters() {
        AlgorithmParameters varC2D5BB8554B4912BBA6231BE4FF3F3DF_640360132 = (engineGetParameters());
        return (AlgorithmParameters)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return engineGetParameters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.595 -0400", hash_original_method = "3218EA86DC018EF694546DAFA3BC417D", hash_generated_method = "A246543B0990970C1B1C690A8880C714")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public final Object getParameter(String param) throws InvalidParameterException {
        dsTaint.addTaint(param);
        Object var195139C512D6E57D8CE877347FD7D7C7_191761427 = (engineGetParameter(param));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return engineGetParameter(param);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.595 -0400", hash_original_method = "31D01322C9910F836DA03F7FCF4D6261", hash_generated_method = "9E214AE8EDE1530345D006D2695D3A34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() throws CloneNotSupportedException {
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_1653270198 = (super.clone());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new CloneNotSupportedException();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (this instanceof Cloneable) {
            //return super.clone();
        //}
        //throw new CloneNotSupportedException();
    }

    
    private static class SignatureImpl extends Signature {
        private SignatureSpi spiImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.595 -0400", hash_original_method = "3E4D7926596EAD873E22E30BA201B1D4", hash_generated_method = "B0B96A648C6698717AFA1767B9480BCA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SignatureImpl(SignatureSpi signatureSpi, Provider provider,
                String algorithm) {
            super(algorithm);
            dsTaint.addTaint(provider.dsTaint);
            dsTaint.addTaint(signatureSpi.dsTaint);
            dsTaint.addTaint(algorithm);
            super.provider = provider;
            // ---------- Original Method ----------
            //super.provider = provider;
            //spiImpl = signatureSpi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.595 -0400", hash_original_method = "FFC69249636133C4828AD78F0F12AF56", hash_generated_method = "46D196FB4429150EEBD1E5AD951EC0C1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected byte[] engineSign() throws SignatureException {
            byte[] var3C6A4D7933B903A8370E3026808FCCC3_2110056097 = (spiImpl.engineSign());
            byte[] retVal = new byte[1];
            retVal[0] = (byte)dsTaint.getTaintInt();
            return retVal;
            // ---------- Original Method ----------
            //return spiImpl.engineSign();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.595 -0400", hash_original_method = "5E472B7CE8DF4677B6CD62A0BE3E6E55", hash_generated_method = "9C3BB16F8F4E8D887B84184BB720889F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void engineUpdate(byte arg0) throws SignatureException {
            dsTaint.addTaint(arg0);
            spiImpl.engineUpdate(arg0);
            // ---------- Original Method ----------
            //spiImpl.engineUpdate(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.596 -0400", hash_original_method = "5B50F80B75147450A8AE91D93998317F", hash_generated_method = "C044B814507335CA5F31991CCFBB499B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected boolean engineVerify(byte[] arg0) throws SignatureException {
            dsTaint.addTaint(arg0[0]);
            boolean var3D9968658679B18190A4A74E628A43C7_1869810913 = (spiImpl.engineVerify(arg0));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return spiImpl.engineVerify(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.596 -0400", hash_original_method = "8E9D74168176A196545DE618D70F0045", hash_generated_method = "CBDFA20A7DFDDC4D03EC3797863E51B2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void engineUpdate(byte[] arg0, int arg1, int arg2) throws SignatureException {
            dsTaint.addTaint(arg2);
            dsTaint.addTaint(arg1);
            dsTaint.addTaint(arg0[0]);
            spiImpl.engineUpdate(arg0, arg1, arg2);
            // ---------- Original Method ----------
            //spiImpl.engineUpdate(arg0, arg1, arg2);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.596 -0400", hash_original_method = "8D0AD1B347F88E648DA57C6C188D8255", hash_generated_method = "2ED910593DFC01265003F241BF6722F0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void engineInitSign(PrivateKey arg0) throws InvalidKeyException {
            dsTaint.addTaint(arg0.dsTaint);
            spiImpl.engineInitSign(arg0);
            // ---------- Original Method ----------
            //spiImpl.engineInitSign(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.596 -0400", hash_original_method = "C51005CD648E9A95CA7D0B48071C4D8E", hash_generated_method = "A61247D1058FA6FED008A8A20B861F77")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void engineInitVerify(PublicKey arg0) throws InvalidKeyException {
            dsTaint.addTaint(arg0.dsTaint);
            spiImpl.engineInitVerify(arg0);
            // ---------- Original Method ----------
            //spiImpl.engineInitVerify(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.596 -0400", hash_original_method = "BC25730F2F2C84CFB445E50D8EAB3A12", hash_generated_method = "F08EB562361D2D619395C5A7BA47929C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object engineGetParameter(String arg0) throws InvalidParameterException {
            dsTaint.addTaint(arg0);
            Object var79674212CBAF34BC7E92A59C59745B02_1280663406 = (spiImpl.engineGetParameter(arg0));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return spiImpl.engineGetParameter(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.596 -0400", hash_original_method = "2EB6574DEFEEC579E00AC6D7C846FB9A", hash_generated_method = "F0801814CDB305FC8910318F8B4F7D58")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void engineSetParameter(String arg0, Object arg1) throws InvalidParameterException {
            dsTaint.addTaint(arg1.dsTaint);
            dsTaint.addTaint(arg0);
            spiImpl.engineSetParameter(arg0, arg1);
            // ---------- Original Method ----------
            //spiImpl.engineSetParameter(arg0, arg1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.597 -0400", hash_original_method = "E18D3A064C93BFFE53C93A44BEF059CB", hash_generated_method = "E98294D89993FE74A5116D27312C7744")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object clone() throws CloneNotSupportedException {
            {
                SignatureSpi spi;
                spi = (SignatureSpi) spiImpl.clone();
                Object var745E9EC0AE0A3150444B71BAB91FF204_2001311454 = (new SignatureImpl(spi, getProvider(), getAlgorithm()));
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new CloneNotSupportedException();
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (spiImpl instanceof Cloneable) {
                //SignatureSpi spi = (SignatureSpi) spiImpl.clone();
                //return new SignatureImpl(spi, getProvider(), getAlgorithm());
            //}
            //throw new CloneNotSupportedException();
        }

        
    }


    
    private static final String SERVICE = "Signature";
    private static Engine ENGINE = new Engine(SERVICE);
    protected static final int UNINITIALIZED = 0;
    protected static final int SIGN = 2;
    protected static final int VERIFY = 3;
}

