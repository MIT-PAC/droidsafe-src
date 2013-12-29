package javax.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;





public abstract class SecretKeyFactorySpi {

    /**
     * Creates a new {@code SecretKeyFactorySpi} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:27.351 -0500", hash_original_method = "37AA0CEAD968FA5AED19221177267C4C", hash_generated_method = "45D9986BE3FF03E6B58BB0BC2D3DAD9B")
    public SecretKeyFactorySpi() {
    }

    /**
     * Generate a secret key from the specified key specification.
     *
     * @param keySpec
     *            the key specification.
     * @return a secret key.
     * @throws InvalidKeySpecException
     *             if the specified key specification cannot be used to generate
     *             a secret key.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:27.352 -0500", hash_original_method = "AF68CD0CA77D7F636E0A4995A1F72B0F", hash_generated_method = "8CC28459B9390463B7AB4F267782111C")
    protected abstract SecretKey engineGenerateSecret(KeySpec keySpec)
            throws InvalidKeySpecException;

    /**
     * Returns the key specification of the specified secret key.
     *
     * @param key
     *            the secret key to get the specification from.
     * @param keySpec
     *            the target key specification class.
     * @return an instance of the specified key specification class.
     * @throws InvalidKeySpecException
     *             if the specified secret key cannot be transformed into the
     *             requested key specification.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:27.353 -0500", hash_original_method = "D6F8AD1DDD97E9CFA8FE854EA3F170C2", hash_generated_method = "13C83817EC1ADE4A8347EA4685336C60")
    @SuppressWarnings("unchecked")
protected abstract KeySpec engineGetKeySpec(SecretKey key, Class keySpec)
            throws InvalidKeySpecException;

    /**
     * Translates the specified secret key into an instance of the corresponding
     * key from the provider of this key factory.
     *
     * @param key
     *            the secret key to translate.
     * @return the corresponding translated key.
     * @throws InvalidKeyException
     *             if the specified key cannot be translated using this key
     *             factory.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:27.354 -0500", hash_original_method = "D8939E80868756AF07DC1B6350589F5C", hash_generated_method = "D93027D8D9217F741510084EB1711D17")
    protected abstract SecretKey engineTranslateKey(SecretKey key)
            throws InvalidKeyException;

    
}

