package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;





public abstract class TrustManagerFactorySpi {

    /**
     * Creates a new {@code TrustManagerFactorySpi} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:28.828 -0500", hash_original_method = "A9501ACA551B0C72B8BE137F9D419E50", hash_generated_method = "39185E31F9FDBB49C07C5ECBF777DFC1")
    public TrustManagerFactorySpi() {
    }

    /**
     * Initializes this factory instance with the specified keystore as source
     * of certificate authorities and trust material.
     *
     * @param ks
     *            the keystore or {@code null}.
     * @throws KeyStoreException
     *             if the initialization fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:28.829 -0500", hash_original_method = "A36FBD4F38FC74970786C4A1820E4581", hash_generated_method = "EE7303806E4C37482E7B9A89A4914786")
    protected abstract void engineInit(KeyStore ks) throws KeyStoreException;

    /**
     * Initializes this factory instance with the specified provider-specific
     * parameters for a source of trust material.
     *
     * @param spec
     *            the provider-specific parameters.
     * @throws InvalidAlgorithmParameterException
     *             if the initialization fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:28.829 -0500", hash_original_method = "E8464373E665456E480D3D33F7327997", hash_generated_method = "6C76039366DDF10BC7CEC02412F7F915")
    protected abstract void engineInit(ManagerFactoryParameters spec)
            throws InvalidAlgorithmParameterException;

    /**
     * Returns the list of {@code TrustManager}s with one entry for each type
     * of trust material.
     *
     * @return the list of {@code TrustManager}s
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:28.830 -0500", hash_original_method = "87C9EE09C143A95EAE6F2AA8C5201D60", hash_generated_method = "D66C2C8B45C4D1B239C7AF4B28248BEA")
    protected abstract TrustManager[] engineGetTrustManagers();

    
}

