package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.nio.ByteBuffer;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Iterator;
import java.util.Set;
import org.apache.harmony.security.fortress.Engine;

public abstract class Signature extends SignatureSpi {
    private static final String SERVICE = "Signature";
    private static Engine ENGINE = new Engine(SERVICE);
    private Provider provider;
    private String algorithm;
    protected static final int UNINITIALIZED = 0;
    protected static final int SIGN = 2;
    protected static final int VERIFY = 3;
    protected int state = UNINITIALIZED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.732 -0400", hash_original_method = "007DE01FB6A8AC35B06025EDE803711E", hash_generated_method = "A7C7B2F449F2E6B898D7602DB2BD033E")
    @DSModeled(DSC.SAFE)
    protected Signature(String algorithm) {
        dsTaint.addTaint(algorithm);
        // ---------- Original Method ----------
        //this.algorithm = algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.732 -0400", hash_original_method = "4B1132236EA3658AFDF6AAF777F4DB3E", hash_generated_method = "0BC0646CA979D25936278C85621B3FDE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.732 -0400", hash_original_method = "38CF846AD141DABFC78B3F3A9BECF440", hash_generated_method = "84FE1D613CEABBA801933A3986010912")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.732 -0400", hash_original_method = "BCEC0D04DA2EAAA5A150C425DE98380C", hash_generated_method = "C0DADB9B24DDAB04166766EA961722A3")
    public static Signature getInstance(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        return getSignatureInstance(algorithm, provider);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.732 -0400", hash_original_method = "1D4C76885795B6AE74A499923A41E610", hash_generated_method = "409E8726C515B71C7C1FC023C7B197B5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.732 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "45F6335264F85F3B8D73CAC979348AC1")
    @DSModeled(DSC.SAFE)
    public final Provider getProvider() {
        return (Provider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.732 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "4A58ADD94C981C54C4328FD02BFEBA19")
    @DSModeled(DSC.SAFE)
    public final String getAlgorithm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.732 -0400", hash_original_method = "6F44917D7B2EA34B37DC316438211882", hash_generated_method = "9C6169282B49ABC9ED6DB5A22898EADD")
    @DSModeled(DSC.SAFE)
    public final void initVerify(PublicKey publicKey) throws InvalidKeyException {
        dsTaint.addTaint(publicKey.dsTaint);
        engineInitVerify(publicKey);
        state = VERIFY;
        // ---------- Original Method ----------
        //engineInitVerify(publicKey);
        //state = VERIFY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.733 -0400", hash_original_method = "D5B41FE621F8332C2172FC7A18EF69C6", hash_generated_method = "FD453D4AC5D2C172FE34027FE801B3AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void initVerify(Certificate certificate) throws InvalidKeyException {
        dsTaint.addTaint(certificate.dsTaint);
        {
            Set ce;
            ce = ((X509Certificate) certificate).getCriticalExtensionOIDs();
            boolean critical;
            critical = false;
            {
                boolean varDDB63590F71C7F795B762D8E1B335B14_613769716 = (ce != null && !ce.isEmpty());
                {
                    {
                        Iterator i;
                        i = ce.iterator();
                        boolean var5A904445088E8F340E730368D637913B_2112943781 = (i.hasNext());
                        {
                            {
                                boolean varB9F24731C04BED7035E9A2BB39B9E036_2018412876 = ("2.5.29.15".equals(i.next()));
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
                            throw new InvalidKeyException("The public key in the certificate cannot be used for digital signature purposes");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.733 -0400", hash_original_method = "B6C8D7AE33737E5AFF4E8BA0A220ACB3", hash_generated_method = "4BD138E1487D558520CCC54D27DD942F")
    @DSModeled(DSC.SAFE)
    public final void initSign(PrivateKey privateKey) throws InvalidKeyException {
        dsTaint.addTaint(privateKey.dsTaint);
        engineInitSign(privateKey);
        state = SIGN;
        // ---------- Original Method ----------
        //engineInitSign(privateKey);
        //state = SIGN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.733 -0400", hash_original_method = "94B0D7FD7FB8599FDCD6F4025918B2A9", hash_generated_method = "92BC338667370E0189CD47C988CC8D6F")
    @DSModeled(DSC.SAFE)
    public final void initSign(PrivateKey privateKey, SecureRandom random) throws InvalidKeyException {
        dsTaint.addTaint(privateKey.dsTaint);
        dsTaint.addTaint(random.dsTaint);
        engineInitSign(privateKey, random);
        state = SIGN;
        // ---------- Original Method ----------
        //engineInitSign(privateKey, random);
        //state = SIGN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.733 -0400", hash_original_method = "1CBD4CB00E49A2B9C590273D2FD8D112", hash_generated_method = "1288F83100946B23CCA93273D9447C2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte[] sign() throws SignatureException {
        {
            throw new SignatureException("Signature object is not initialized properly");
        } //End block
        byte[] var2BF540A96FDD13E31EC65A887FD9474C_1401790076 = (engineSign());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (state != SIGN) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //return engineSign();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.733 -0400", hash_original_method = "82A870C6C8965CC8E79085F7D8A960EB", hash_generated_method = "8A599CED17F86F5FA594D10E414B1BD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int sign(byte[] outbuf, int offset, int len) throws SignatureException {
        dsTaint.addTaint(outbuf);
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        {
            throw new IllegalArgumentException();
        } //End block
        {
            throw new SignatureException("Signature object is not initialized properly");
        } //End block
        int varAD8681934276A1CD16B838C3AB96F96D_1315849604 = (engineSign(outbuf, offset, len));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.733 -0400", hash_original_method = "C9B26283C94B06BB8BE60C57C40A18DF", hash_generated_method = "D888A1F4BE4FBA7CB15782F08DD8CE93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean verify(byte[] signature) throws SignatureException {
        dsTaint.addTaint(signature);
        {
            throw new SignatureException("Signature object is not initialized properly");
        } //End block
        boolean var94E832A3545B70CECCD924171C5ED0C7_1335790896 = (engineVerify(signature));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (state != VERIFY) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //return engineVerify(signature);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.733 -0400", hash_original_method = "59329C8B89ACE0AC6C4DAAF18DA3F3C5", hash_generated_method = "076193FD0DC1FDE81FB21910E30F6D59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean verify(byte[] signature, int offset, int length) throws SignatureException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(signature);
        {
            throw new SignatureException("Signature object is not initialized properly");
        } //End block
        {
            throw new IllegalArgumentException();
        } //End block
        boolean varFB0754D41DA9EDEE16772952DEAC8EBB_692475168 = (engineVerify(signature, offset, length));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.733 -0400", hash_original_method = "79EA6E53B3D29CDFCD3B6E1380EAFC50", hash_generated_method = "85457E25B277BD35D43DD92ADF22E1A6")
    @DSModeled(DSC.SAFE)
    public final void update(byte b) throws SignatureException {
        dsTaint.addTaint(b);
        {
            throw new SignatureException("Signature object is not initialized properly");
        } //End block
        engineUpdate(b);
        // ---------- Original Method ----------
        //if (state == UNINITIALIZED) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //engineUpdate(b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.733 -0400", hash_original_method = "7FDD4CB7D645E432F89E836C71DCF871", hash_generated_method = "5E57EA609584EBA326FE4A38A658C6C2")
    @DSModeled(DSC.SAFE)
    public final void update(byte[] data) throws SignatureException {
        dsTaint.addTaint(data);
        {
            throw new SignatureException("Signature object is not initialized properly");
        } //End block
        engineUpdate(data, 0, data.length);
        // ---------- Original Method ----------
        //if (state == UNINITIALIZED) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //engineUpdate(data, 0, data.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.733 -0400", hash_original_method = "935040FEA1E890342F7B1ED90DB7090F", hash_generated_method = "653707DEF56F08D9E49625C4FA47C642")
    @DSModeled(DSC.SAFE)
    public final void update(byte[] data, int off, int len) throws SignatureException {
        dsTaint.addTaint(data);
        dsTaint.addTaint(off);
        dsTaint.addTaint(len);
        {
            throw new SignatureException("Signature object is not initialized properly");
        } //End block
        {
            throw new IllegalArgumentException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.733 -0400", hash_original_method = "4D212376BB0D0E0EE1EF0BE20DC8A649", hash_generated_method = "ED21A33781BF8008D5B4937A99FBEE71")
    @DSModeled(DSC.SAFE)
    public final void update(ByteBuffer data) throws SignatureException {
        dsTaint.addTaint(data.dsTaint);
        {
            throw new SignatureException("Signature object is not initialized properly");
        } //End block
        engineUpdate(data);
        // ---------- Original Method ----------
        //if (state == UNINITIALIZED) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //engineUpdate(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.733 -0400", hash_original_method = "300ADD63628A84B0D8F725B1BA1E9A8E", hash_generated_method = "4E6542164285FF8695C523EADE7085AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varA3CB7FCFBB44906641DBAB78E7DF6CA9_1303908516 = ("SIGNATURE " + algorithm + " state: " + stateToString(state));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "SIGNATURE " + algorithm + " state: " + stateToString(state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.734 -0400", hash_original_method = "C1A460A3B710FBA1ED28C52AC5BBE911", hash_generated_method = "594FE17398DBC4C1A0A392EDB5CAEF5F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.734 -0400", hash_original_method = "D52E00AF44B32CEF42E7B7F3CD02413C", hash_generated_method = "4CF5C13384B5F9F2FF49B06FEDB3B425")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public final void setParameter(String param, Object value) throws InvalidParameterException {
        dsTaint.addTaint(param);
        dsTaint.addTaint(value.dsTaint);
        engineSetParameter(param, value);
        // ---------- Original Method ----------
        //engineSetParameter(param, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.734 -0400", hash_original_method = "723DAA3D9E86E61831D60007CF8F8BBA", hash_generated_method = "66C12724F5F77FDF5220DC2936A7F89F")
    @DSModeled(DSC.SAFE)
    public final void setParameter(AlgorithmParameterSpec params) throws InvalidAlgorithmParameterException {
        dsTaint.addTaint(params.dsTaint);
        engineSetParameter(params);
        // ---------- Original Method ----------
        //engineSetParameter(params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.734 -0400", hash_original_method = "8EDBC3AD900BE7B10A8F191CA049C5A8", hash_generated_method = "BFD62976F305D548EDB7AB0B082767C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final AlgorithmParameters getParameters() {
        AlgorithmParameters varC2D5BB8554B4912BBA6231BE4FF3F3DF_2132507716 = (engineGetParameters());
        return (AlgorithmParameters)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return engineGetParameters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.734 -0400", hash_original_method = "3218EA86DC018EF694546DAFA3BC417D", hash_generated_method = "91BAF5DCB1ACA4DD2288F022C2857A3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public final Object getParameter(String param) throws InvalidParameterException {
        dsTaint.addTaint(param);
        Object var195139C512D6E57D8CE877347FD7D7C7_1110745588 = (engineGetParameter(param));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return engineGetParameter(param);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.734 -0400", hash_original_method = "31D01322C9910F836DA03F7FCF4D6261", hash_generated_method = "E9C8FF4F2F2E59E8C66188EB5CA1EBAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() throws CloneNotSupportedException {
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_2007138521 = (super.clone());
        } //End block
        throw new CloneNotSupportedException();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (this instanceof Cloneable) {
            //return super.clone();
        //}
        //throw new CloneNotSupportedException();
    }

    
    private static class SignatureImpl extends Signature {
        private SignatureSpi spiImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.734 -0400", hash_original_method = "3E4D7926596EAD873E22E30BA201B1D4", hash_generated_method = "F24D805374F8645CF98F87E0A37824DC")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.734 -0400", hash_original_method = "FFC69249636133C4828AD78F0F12AF56", hash_generated_method = "6E4E81D3F9EA3E43AB76FE96CB6DA578")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected byte[] engineSign() throws SignatureException {
            byte[] var3C6A4D7933B903A8370E3026808FCCC3_1763313549 = (spiImpl.engineSign());
            byte[] retVal = new byte[1];
            retVal[0] = (byte)dsTaint.getTaintInt();
            return retVal;
            // ---------- Original Method ----------
            //return spiImpl.engineSign();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.734 -0400", hash_original_method = "5E472B7CE8DF4677B6CD62A0BE3E6E55", hash_generated_method = "C8AA74891A22AF49B79C37DE08DB1448")
        @DSModeled(DSC.SAFE)
        @Override
        protected void engineUpdate(byte arg0) throws SignatureException {
            dsTaint.addTaint(arg0);
            spiImpl.engineUpdate(arg0);
            // ---------- Original Method ----------
            //spiImpl.engineUpdate(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.734 -0400", hash_original_method = "5B50F80B75147450A8AE91D93998317F", hash_generated_method = "A4A3AD293E1D4FBB93330A6900D6B426")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected boolean engineVerify(byte[] arg0) throws SignatureException {
            dsTaint.addTaint(arg0);
            boolean var3D9968658679B18190A4A74E628A43C7_959103861 = (spiImpl.engineVerify(arg0));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return spiImpl.engineVerify(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.734 -0400", hash_original_method = "8E9D74168176A196545DE618D70F0045", hash_generated_method = "EEA12451579D2733EF15E3018AA16DDC")
        @DSModeled(DSC.SAFE)
        @Override
        protected void engineUpdate(byte[] arg0, int arg1, int arg2) throws SignatureException {
            dsTaint.addTaint(arg2);
            dsTaint.addTaint(arg1);
            dsTaint.addTaint(arg0);
            spiImpl.engineUpdate(arg0, arg1, arg2);
            // ---------- Original Method ----------
            //spiImpl.engineUpdate(arg0, arg1, arg2);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.734 -0400", hash_original_method = "8D0AD1B347F88E648DA57C6C188D8255", hash_generated_method = "8B585334D5E55A08EF6664B78538C623")
        @DSModeled(DSC.SAFE)
        @Override
        protected void engineInitSign(PrivateKey arg0) throws InvalidKeyException {
            dsTaint.addTaint(arg0.dsTaint);
            spiImpl.engineInitSign(arg0);
            // ---------- Original Method ----------
            //spiImpl.engineInitSign(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.734 -0400", hash_original_method = "C51005CD648E9A95CA7D0B48071C4D8E", hash_generated_method = "6121E9AD57723C8132F696682F0AEEB0")
        @DSModeled(DSC.SAFE)
        @Override
        protected void engineInitVerify(PublicKey arg0) throws InvalidKeyException {
            dsTaint.addTaint(arg0.dsTaint);
            spiImpl.engineInitVerify(arg0);
            // ---------- Original Method ----------
            //spiImpl.engineInitVerify(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.734 -0400", hash_original_method = "BC25730F2F2C84CFB445E50D8EAB3A12", hash_generated_method = "2F812DBF18887A308425E71FFF1CEF72")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object engineGetParameter(String arg0) throws InvalidParameterException {
            dsTaint.addTaint(arg0);
            Object var79674212CBAF34BC7E92A59C59745B02_523527677 = (spiImpl.engineGetParameter(arg0));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return spiImpl.engineGetParameter(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.734 -0400", hash_original_method = "2EB6574DEFEEC579E00AC6D7C846FB9A", hash_generated_method = "1BC035CF959334D2F01E999F4340E124")
        @DSModeled(DSC.SAFE)
        @Override
        protected void engineSetParameter(String arg0, Object arg1) throws InvalidParameterException {
            dsTaint.addTaint(arg1.dsTaint);
            dsTaint.addTaint(arg0);
            spiImpl.engineSetParameter(arg0, arg1);
            // ---------- Original Method ----------
            //spiImpl.engineSetParameter(arg0, arg1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.734 -0400", hash_original_method = "E18D3A064C93BFFE53C93A44BEF059CB", hash_generated_method = "8130C13C52206BDA1F650962DBE98ED3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object clone() throws CloneNotSupportedException {
            {
                SignatureSpi spi;
                spi = (SignatureSpi) spiImpl.clone();
                Object var745E9EC0AE0A3150444B71BAB91FF204_2105013823 = (new SignatureImpl(spi, getProvider(), getAlgorithm()));
            } //End block
            throw new CloneNotSupportedException();
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (spiImpl instanceof Cloneable) {
                //SignatureSpi spi = (SignatureSpi) spiImpl.clone();
                //return new SignatureImpl(spi, getProvider(), getAlgorithm());
            //}
            //throw new CloneNotSupportedException();
        }

        
    }


    
}


