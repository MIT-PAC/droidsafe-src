package javax.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public abstract class KeyGeneratorSpi {

    /**
     * Creates a new {@code KeyGeneratorSpi} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.115 -0500", hash_original_method = "A75599FEFECBB1DE286B9919E5114FFE", hash_generated_method = "8575C1F81F960CBF97E36CFAA017FE2F")
    
public KeyGeneratorSpi() {
    }

    /**
     * Generates a secret key.
     *
     * @return the generated secret key.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.117 -0500", hash_original_method = "68ECB24641996C94599FBD25DD668E73", hash_generated_method = "FFEB126BECE4358A1B7E9438CF71BA4A")
    
protected abstract SecretKey engineGenerateKey();

    /**
     * Initializes this {@code KeyGeneratorSpi} instance with the specified
     * algorithm parameters and randomness source.
     *
     * @param params
     *            the parameters for the key generation algorithm.
     * @param random
     *            the randomness source for any random bytes.
     * @throws InvalidAlgorithmParameterException
     *             if the parameters cannot be uses to initialize this key
     *             generator algorithm.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.120 -0500", hash_original_method = "1E8B80FE4B38D99EEFEA0413936393C4", hash_generated_method = "8A89AF7DFCFC698EFF7E92E164F66801")
    
protected abstract void engineInit(AlgorithmParameterSpec params,
            SecureRandom random) throws InvalidAlgorithmParameterException;

    /**
     * Initializes this {@code KeyGenerator} instance for the specified key
     * size (in bits) using the specified randomness source.
     *
     * @param keysize
     *            the size of the key (in bits).
     * @param random
     *            the randomness source for any random bytes.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.122 -0500", hash_original_method = "7F2C8AF1B28CA2BB540ECEE8C651C4D7", hash_generated_method = "6BEE8FCD01C2BA222877BFEDD0F7CFB8")
    
protected abstract void engineInit(int keysize, SecureRandom random);

    /**
     * Initializes this {@code KeyGenerator} with the specified randomness
     * source.
     *
     * @param random
     *            the randomness source for any random bytes.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.124 -0500", hash_original_method = "94BAA529D8EADD7261258DCF5C1FF668", hash_generated_method = "72914D70886628327444991D9E41ABF8")
    
protected abstract void engineInit(SecureRandom random);
    
}

