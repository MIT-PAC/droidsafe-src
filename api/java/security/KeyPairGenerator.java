package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.spec.AlgorithmParameterSpec;

import org.apache.harmony.security.fortress.Engine;

public abstract class KeyPairGenerator extends KeyPairGeneratorSpi {

    /**
     * Returns a new instance of {@code KeyPairGenerator} that utilizes the
     * specified algorithm.
     *
     * @param algorithm
     *            the name of the algorithm to use
     * @return a new instance of {@code KeyPairGenerator} that utilizes the
     *         specified algorithm
     * @throws NoSuchAlgorithmException if the specified algorithm is not available
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null}
     */
    @DSComment("no suspicious activity, just creates object")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.212 -0500", hash_original_method = "F934B6F8A166E3E18108E810D9639C1F", hash_generated_method = "498C56FA6C5428A7F1E055D14BB2280F")
    
public static KeyPairGenerator getInstance(String algorithm)
            throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        Object spi = sap.spi;
        Provider provider = sap.provider;
        if (spi instanceof KeyPairGenerator) {
            KeyPairGenerator result = (KeyPairGenerator) spi;
            result.algorithm = algorithm;
            result.provider = provider;
            return result;
        }
        return new KeyPairGeneratorImpl((KeyPairGeneratorSpi) spi, provider, algorithm);
    }

    /**
     * Returns a new instance of {@code KeyPairGenerator} that utilizes the
     * specified algorithm from the specified provider.
     *
     * @param algorithm
     *            the name of the algorithm to use
     * @param provider
     *            the name of the provider
     * @return a new instance of {@code KeyPairGenerator} that utilizes the
     *         specified algorithm from the specified provider
     * @throws NoSuchAlgorithmException if the specified algorithm is not available
     * @throws NoSuchProviderException if the specified provider is not available
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null}
     * @throws IllegalArgumentException if {@code provider == null || provider.isEmpty()}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.215 -0500", hash_original_method = "216E11C78E57429304B7E0E6BDC67FF2", hash_generated_method = "25BFC7B93A0B1851F0DD18EA5DAC63C5")
    
public static KeyPairGenerator getInstance(String algorithm, String provider)
            throws NoSuchAlgorithmException, NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider impProvider = Security.getProvider(provider);
        if (impProvider == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, impProvider);
    }

    /**
     * Returns a new instance of {@code KeyPairGenerator} that utilizes the
     * specified algorithm from the specified provider.
     *
     * @param algorithm
     *            the name of the algorithm to use
     * @param provider
     *            the provider
     * @return a new instance of {@code KeyPairGenerator} that utilizes the
     *         specified algorithm from the specified provider
     * @throws NoSuchAlgorithmException if the specified algorithm is not available
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null}
     * @throws IllegalArgumentException if {@code provider == null}
     */
    @DSComment("no suspicious activity, just creates object")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.217 -0500", hash_original_method = "D13E283A2C81D5C7579E7D4A3F04358E", hash_generated_method = "D8C2120FBD120C937F1BFCC4CC52137B")
    
public static KeyPairGenerator getInstance(String algorithm,
            Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        if (spi instanceof KeyPairGenerator) {
            KeyPairGenerator result = (KeyPairGenerator) spi;
            result.algorithm = algorithm;
            result.provider = provider;
            return result;
        }
        return new KeyPairGeneratorImpl((KeyPairGeneratorSpi) spi, provider, algorithm);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.193 -0500", hash_original_field = "AFA93416687679F64D160734FC2F0A7F", hash_generated_field = "F51DFBA48E1CBE1BD95133B2C4AEE495")

    private static final String SERVICE = "KeyPairGenerator";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.196 -0500", hash_original_field = "17F86B5CB94419D7D346BC8D1B101EA5", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.199 -0500", hash_original_field = "FDD9E227182999EA06EE5AF5CE50D8B1", hash_generated_field = "971A4862B04E3FBF4A69F43F59DCA289")

    private static final SecureRandom RANDOM = new SecureRandom();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.201 -0500", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.204 -0500", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;

    /**
     * Constructs a new instance of {@code KeyPairGenerator} with the name of
     * the algorithm to use.
     *
     * @param algorithm
     *            the name of algorithm to use
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.207 -0500", hash_original_method = "5546FFAC9B42B6F49AEA710C665EF80A", hash_generated_method = "7A030EE57B6B907D0855B29DF803CFA4")
    
protected KeyPairGenerator(String algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * Returns the name of the algorithm of this {@code KeyPairGenerator}.
     *
     * @return the name of the algorithm of this {@code KeyPairGenerator}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.209 -0500", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "09B8CB0F05513E7BA5A386900D5BF6E6")
    
public String getAlgorithm() {
        return algorithm;
    }

    /**
     * Returns the provider associated with this {@code KeyPairGenerator}.
     *
     * @return the provider associated with this {@code KeyPairGenerator}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.221 -0500", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
    
public final Provider getProvider() {
        return provider;
    }

    /**
     * Initializes this {@code KeyPairGenerator} with the given key size. The
     * default parameter set and a default {@code SecureRandom} instance will be
     * used.
     *
     * @param keysize
     *            the size of the key (number of bits)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.223 -0500", hash_original_method = "63D58B7A783E5CA62351478BDCD64960", hash_generated_method = "AC76CB67133D52124306953043C875A6")
    
public void initialize(int keysize) {
        initialize(keysize, RANDOM);
    }

    /**
     * Initializes this {@code KeyPairGenerator} with the given {@code
     * AlgorithmParameterSpec}. A default {@code SecureRandom} instance will be
     * used.
     *
     * @param param
     *            the parameters to use
     * @throws InvalidAlgorithmParameterException
     *             if the specified parameters are not supported
     */
    @DSComment("no suspicious activity")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.226 -0500", hash_original_method = "505B12303F8A8E9420867471775AD0AC", hash_generated_method = "CDF5470CDAAD2CE83A02437AA9DE14B7")
    
public void initialize(AlgorithmParameterSpec param)
            throws InvalidAlgorithmParameterException {
        initialize(param, RANDOM);
    }

    /**
     * Computes and returns a new unique {@code KeyPair} each time this method
     * is called.
     * <p>
     * This does exactly the same as {@link #generateKeyPair()}.
     *
     * @return a new unique {@code KeyPair} each time this method is called
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.228 -0500", hash_original_method = "0A0D3545CE028F03545250CE4A841A43", hash_generated_method = "2A27819E6CAA20B6BC98198F1A7390ED")
    
public final KeyPair genKeyPair() {
        return generateKeyPair();
    }
    
    private static class KeyPairGeneratorImpl extends KeyPairGenerator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.240 -0500", hash_original_field = "3D7BD47EB27FD2510EA202B46FEDBCEC", hash_generated_field = "5688209BF362571C922D334A44DFEAF3")

        private KeyPairGeneratorSpi spiImpl;

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.243 -0500", hash_original_method = "31255CF8BFD3D1E3DCC08215387BB12A", hash_generated_method = "6BE9020CAD8EE9935E358E33389AB01D")
        
private KeyPairGeneratorImpl(KeyPairGeneratorSpi keyPairGeneratorSpi,
                Provider provider, String algorithm) {
            super(algorithm);
            super.provider = provider;
            spiImpl = keyPairGeneratorSpi;
        }

        // implementation of initialize(int keysize, SecureRandom random)
        // using corresponding spi initialize() method
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.246 -0500", hash_original_method = "A4E5201D8A18A75F2C72ED6B7363B7D6", hash_generated_method = "B2BEA56E4CBD31A9C2749DE8EC9ACE0B")
        
@Override
        public void initialize(int keysize, SecureRandom random) {
            spiImpl.initialize(keysize, random);
        }

        // implementation of generateKeyPair()
        // using corresponding spi generateKeyPair() method
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.248 -0500", hash_original_method = "44E6103A9DEB6D889A2EDBD2D91F5661", hash_generated_method = "A179096361BD5055034EFECA1C99B936")
        
@Override
        public KeyPair generateKeyPair() {
            return spiImpl.generateKeyPair();
        }

        // implementation of initialize(int keysize, SecureRandom random)
        // using corresponding spi initialize() method
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.252 -0500", hash_original_method = "4494520DAC0042C0E4EFE59D1D9956AB", hash_generated_method = "67D0A506541857695F898F446AA4E109")
        
@Override
        public void initialize(AlgorithmParameterSpec param, SecureRandom random)
                throws InvalidAlgorithmParameterException {
            spiImpl.initialize(param, random);
        }
        
    }

    /**
     * Computes and returns a new unique {@code KeyPair} each time this method
     * is called.
     * <p>
     * This does exactly the same as {@link #genKeyPair()}.
     *
     * @return a new unique {@code KeyPair} each time this method is called
     */
    @DSComment("no suspicious activity, just creates object")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.232 -0500", hash_original_method = "7972015D8BC3BAE6F8655706849D6EC4", hash_generated_method = "7416D4BAC31589F8D2E2893407C58F0D")
    
@Override
    public KeyPair generateKeyPair() {
        return null;
    }

    /**
     * Initializes this {@code KeyPairGenerator} with the given key size and the
     * given {@code SecureRandom}. The default parameter set will be used.
     *
     * @param keysize
     *            the key size
     * @param random
     *            the source of randomness
     */
    @DSComment("no suspicious activity")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.234 -0500", hash_original_method = "C1E2700C4D7C78BCD077B4B9FB70A89A", hash_generated_method = "78ADD1A0E8B1B61D568978291F6AA8B3")
    
@Override
    public void initialize(int keysize, SecureRandom random) {
    }

    /**
     * Initializes this {@code KeyPairGenerator} with the given {@code
     * AlgorithmParameterSpec} and the given {@code SecureRandom}.
     *
     * @param param
     *            the parameters to use
     * @param random
     *            the source of randomness
     * @throws InvalidAlgorithmParameterException
     *             if the specified parameters are not supported
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.237 -0500", hash_original_method = "3E787A500B01324B444CF13BE7390B3D", hash_generated_method = "356944E189CAD04874CFD2A9CF49F633")
    
@Override
    public void initialize(AlgorithmParameterSpec param, SecureRandom random)
            throws InvalidAlgorithmParameterException {
    }
}

