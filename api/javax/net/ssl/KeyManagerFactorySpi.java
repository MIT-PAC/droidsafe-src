package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

public abstract class KeyManagerFactorySpi {

    /**
     * Creates a new {@code KeyManagerFactorySpi} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.279 -0500", hash_original_method = "6A7E81CC9CE1799ACFD008A7DC048460", hash_generated_method = "F5CC1388BD4584472660C93AE5203C58")
    
public KeyManagerFactorySpi() {
    }

    /**
     * Initializes this instance with the specified key store and password.
     *
     * @param ks
     *            the key store or {@code null} to use the default key store.
     * @param password
     *            the key store password.
     * @throws KeyStoreException
     *             if initializing this instance fails.
     * @throws NoSuchAlgorithmException
     *             if a required algorithm is not available.
     * @throws UnrecoverableKeyException
     *             if a key cannot be recovered.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.282 -0500", hash_original_method = "0D3635A5835C673EAD5B27BBB788074D", hash_generated_method = "C0D480B7C5034ED1B3D23C67E786E8C8")
    
protected abstract void engineInit(KeyStore ks, char[] password) throws KeyStoreException,
            NoSuchAlgorithmException, UnrecoverableKeyException;

    /**
     * Initializes this instance with the specified factory parameters.
     *
     * @param spec
     *            the factory parameters.
     * @throws InvalidAlgorithmParameterException
     *             if an error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.284 -0500", hash_original_method = "E8464373E665456E480D3D33F7327997", hash_generated_method = "6C76039366DDF10BC7CEC02412F7F915")
    
protected abstract void engineInit(ManagerFactoryParameters spec)
            throws InvalidAlgorithmParameterException;

    /**
     * Returns a list of key managers, one instance for each type of key in the
     * key store.
     *
     * @return a list of key managers.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.286 -0500", hash_original_method = "8AA3A930AA2BEA7107EAE536F3FF6F57", hash_generated_method = "5859AFE7FD8C07975D107F33B4FBBAFE")
    
protected abstract KeyManager[] engineGetKeyManagers();
    
}

