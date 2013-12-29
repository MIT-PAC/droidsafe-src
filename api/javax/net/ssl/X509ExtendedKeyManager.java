package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.Principal;





public abstract class X509ExtendedKeyManager implements X509KeyManager {

    /**
     * To be used by subclasses only.
     * <p>
     * Creates a new {@code X509ExtendedKeyManager} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.445 -0500", hash_original_method = "F0C30C87B7D84E85B2225C595BCE43AB", hash_generated_method = "A93D721B75516A1B09A7C59D7033A769")
    protected X509ExtendedKeyManager() {
    }

    /**
     * Chooses an alias for the client side of an SSL connection to authenticate
     * it with the specified public key type and certificate issuers.
     *
     * @param keyType
     *            the list of public key algorithm names.
     * @param issuers
     *            the list of certificate issuers, or {@code null} if any issuer
     *            will do.
     * @param engine
     *            the {@code SSLEngine} for the connection, or {@code null} if
     *            no engine is predefined.
     * @return the alias name of a matching key or {@code null} if there are no
     *         matches.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.446 -0500", hash_original_method = "EA8A569E03B996F70B23469E519E27CE", hash_generated_method = "B221261CB6FC6B0F4A910B3CB2F86672")
    public String chooseEngineClientAlias(String[] keyType,
            Principal[] issuers, SSLEngine engine) {
        return null;
    }

    /**
     * Chooses an alias for the server side of an SSL connection to authenticate
     * it with the specified public key type and certificate issuers.
     *
     * @param keyType
     *            the list of public key algorithm names.
     * @param issuers
     *            the list of certificate issuers, or {@code null} if any issuer
     *            will do.
     * @param engine
     *            the {@code SSLEngine} for the connection, or {@code null} if
     *            no engine is predefined.
     * @return the alias name of a matching key or {@code null} if there are no
     *         matches.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.447 -0500", hash_original_method = "3FE28D69AE0A8005556F51C699865935", hash_generated_method = "55E4F634A2EDA6DFDC26144D997CFC2C")
    public String chooseEngineServerAlias(String keyType, Principal[] issuers,
            SSLEngine engine) {
        return null;
    }

    
}

