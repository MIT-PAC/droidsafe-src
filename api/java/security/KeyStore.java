package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;

import javax.crypto.SecretKey;
import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;
import javax.security.auth.callback.CallbackHandler;

import libcore.io.IoUtils;

import org.apache.harmony.security.fortress.Engine;

public class KeyStore {

    /**
     * Throws the standard "keystore not initialized" exception.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.328 -0500", hash_original_method = "98CAAAA38AE0BD626D6C3D7BFF6CA72F", hash_generated_method = "08DAB19305810AB0AFBB3486F0040648")
    
private static void throwNotInitialized() throws KeyStoreException {
        throw new KeyStoreException("KeyStore was not initialized");
    }

    /**
     * Returns a new instance of {@code KeyStore} with the specified type.
     *
     * @param type
     *            the type of the returned {@code KeyStore}.
     * @return a new instance of {@code KeyStore} with the specified type.
     * @throws KeyStoreException
     *             if an error occurred during the creation of the new {@code
     *             KeyStore}.
     * @throws NullPointerException if {@code type == null}
     * @see #getDefaultType
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.331 -0500", hash_original_method = "8219108C73AF092A133C70DEA775DA97", hash_generated_method = "FEA2A071F474C729EB28D6AA867BFDC0")
    
public static KeyStore getInstance(String type) throws KeyStoreException {
        if (type == null) {
            throw new NullPointerException();
        }
        try {
            Engine.SpiAndProvider sap = ENGINE.getInstance(type, null);
            return new KeyStore((KeyStoreSpi) sap.spi, sap.provider, type);
        } catch (NoSuchAlgorithmException e) {
            throw new KeyStoreException(e);
        }
    }

    /**
     * Returns a new instance of {@code KeyStore} from the specified provider
     * with the given type.
     *
     * @param type
     *            the type of the returned {@code KeyStore}.
     * @param provider
     *            name of the provider of the {@code KeyStore}.
     * @return a new instance of {@code KeyStore} from the specified provider
     *         with the given type.
     * @throws KeyStoreException
     *             if an error occurred during the creation of the new {@code
     *             KeyStore}.
     * @throws NoSuchProviderException
     *             if the specified provider is not available.
     * @throws IllegalArgumentException if {@code provider == null || provider.isEmpty()}
     * @throws NullPointerException
     *             if {@code type} is {@code null} (instead of
     *             NoSuchAlgorithmException) as in 1.4 release
     * @see #getDefaultType
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.334 -0500", hash_original_method = "E79F87A65CC661E36FF41DA591B3A31D", hash_generated_method = "A2D39DFE38EA02CB2269278A461D92BA")
    
public static KeyStore getInstance(String type, String provider)
            throws KeyStoreException, NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider impProvider = Security.getProvider(provider);
        if (impProvider == null) {
            throw new NoSuchProviderException(provider);
        }
        try {
            return getInstance(type, impProvider);
        } catch (Exception e) {
            throw new KeyStoreException(e);
        }
    }

    /**
     * Returns a new instance of {@code KeyStore} from the specified provider
     * with the given type.
     *
     * @param type
     *            the type of the returned {@code KeyStore}.
     * @param provider
     *            the provider of the {@code KeyStore}.
     * @return a new instance of {@code KeyStore} from the specified provider
     *         with the given type.
     * @throws KeyStoreException
     *             if an error occurred during the creation of the new {@code
     *             KeyStore}.
     * @throws IllegalArgumentException
     *             if {@code provider} is {@code null} or the empty string.
     * @throws NullPointerException if {@code type == null} (instead of
     *             NoSuchAlgorithmException) as in 1.4 release
     * @see #getDefaultType
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.337 -0500", hash_original_method = "DAE2CFCBAFEE42DE8D4B61EE11C10C65", hash_generated_method = "7B37C796C47FC24BD1C683EC522000C7")
    
public static KeyStore getInstance(String type, Provider provider) throws KeyStoreException {
        // check parameters
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        if (type == null) {
            throw new NullPointerException();
        }
        // return KeyStore instance
        try {
            Object spi = ENGINE.getInstance(type, provider, null);
            return new KeyStore((KeyStoreSpi) spi, provider, type);
        } catch (Exception e) {
            // override exception
            throw new KeyStoreException(e);
        }
    }

    /**
     * Returns the default type for {@code KeyStore} instances.
     *
     * <p>The default is specified in the {@code 'keystore.type'} property in the
     * file named {@code java.security} properties file. If this property
     * is not set, {@code "jks"} will be used.
     *
     * @return the default type for {@code KeyStore} instances
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.340 -0500", hash_original_method = "57AAB0F03057AE1C147A6E60DF4FEF55", hash_generated_method = "C3FA8A029DE61ED9E58516EBD430AC26")
    
public static final String getDefaultType() {
        String dt = Security.getProperty(PROPERTYNAME);
        return (dt == null ? DEFAULT_KEYSTORE_TYPE : dt);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.303 -0500", hash_original_field = "B7D498329E8EE4DDD3FCD56001D9336C", hash_generated_field = "E9C51D7447E3CF538E5351AFCABA1B21")

    private static final String SERVICE = "KeyStore";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.306 -0500", hash_original_field = "17F86B5CB94419D7D346BC8D1B101EA5", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.309 -0500", hash_original_field = "2E9AFBE01E76CF4E629E50F85858529C", hash_generated_field = "F40EF245477C1F166A1B8FCA4EAD1609")

    private static final String PROPERTYNAME = "keystore.type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.313 -0500", hash_original_field = "2A27CDEB97B1B6BE3765934E168D2C9F", hash_generated_field = "E2A356F03BA9C258737A10C161C6A401")

    private static final String DEFAULT_KEYSTORE_TYPE = "jks";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.315 -0500", hash_original_field = "7CD73C25F734436DF9CA3EE278E9C46C", hash_generated_field = "61D6D6330C8232E1AA65EEA11EE82DF2")

    private boolean isInit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.318 -0500", hash_original_field = "F771CBA1DFDC446F91E226150338388C", hash_generated_field = "B9C88BCACA85DB9C0AB124AA62DE8CAD")

    private  KeyStoreSpi implSpi;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.320 -0500", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private  Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.323 -0500", hash_original_field = "1B03D0EF3E71EB350936336F82D5E0C5", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private  String type;

    /**
     * Constructs a new instance of {@code KeyStore} with the given arguments.
     *
     * @param keyStoreSpi
     *            the concrete key store.
     * @param provider
     *            the provider.
     * @param type
     *            the type of the {@code KeyStore} to be constructed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.325 -0500", hash_original_method = "108D8AEC9F3364E92BCBB521C1482782", hash_generated_method = "919C445453EB44BD29CD715EEEE030F2")
    
protected KeyStore(KeyStoreSpi keyStoreSpi, Provider provider, String type) {
        this.type = type;
        this.provider = provider;
        this.implSpi = keyStoreSpi;
        isInit = false;
    }

    /**
     * Returns the provider associated with this {@code KeyStore}.
     *
     * @return the provider associated with this {@code KeyStore}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.343 -0500", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
    
public final Provider getProvider() {
        return provider;
    }

    /**
     * Returns the type of this {@code KeyStore}.
     *
     * @return the type of this {@code KeyStore}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.345 -0500", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "B5025B3379E65F477B29B0C5C8B783DF")
    
public final String getType() {
        return type;
    }

    /**
     * Returns the key with the given alias, using the password to recover the
     * key from the store.
     *
     * @param alias
     *            the alias for the entry.
     * @param password
     *            the password used to recover the key.
     * @return the key with the specified alias, or {@code null} if the
     *         specified alias is not bound to an entry.
     * @throws KeyStoreException
     *             if this {@code KeyStore} is not initialized.
     * @throws NoSuchAlgorithmException
     *             if the algorithm for recovering the key is not available.
     * @throws UnrecoverableKeyException
     *             if the key can not be recovered.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.348 -0500", hash_original_method = "F59E459BECAEDEBCB13476A41CDEA779", hash_generated_method = "751C9CD1B810F6B88EF7F28DD38570E2")
    
public final Key getKey(String alias, char[] password)
            throws KeyStoreException, NoSuchAlgorithmException,
            UnrecoverableKeyException {
        if (!isInit) {
            throwNotInitialized();
        }
        return implSpi.engineGetKey(alias, password);
    }

    /**
     * Returns the certificate chain for the entry with the given alias.
     *
     * @param alias
     *            the alias for the entry.
     * @return the certificate chain for the entry with the given alias, or
     *         {@code null} if the specified alias is not bound to an entry.
     * @throws KeyStoreException
     *             if this {@code KeyStore} is not initialized.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.351 -0500", hash_original_method = "504D1BEC6FF8E94C83F90A431D916244", hash_generated_method = "A35955EFAE9E502B0335F28BADEE42C5")
    
public final Certificate[] getCertificateChain(String alias) throws KeyStoreException {
        if (!isInit) {
            throwNotInitialized();
        }
        return implSpi.engineGetCertificateChain(alias);
    }

    /**
     * Returns the trusted certificate for the entry with the given alias.
     *
     * @param alias
     *            the alias for the entry.
     * @return the trusted certificate for the entry with the given alias, or
     *         {@code null} if the specified alias is not bound to an entry.
     * @throws KeyStoreException
     *             if this {@code KeyStore} is not initialized.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.353 -0500", hash_original_method = "7FA5F9282816EB62AB780CC8E8ACBC45", hash_generated_method = "2083E645BA21ECB42FDDE2066CB98A7D")
    
public final Certificate getCertificate(String alias) throws KeyStoreException {
        if (!isInit) {
            throwNotInitialized();
        }
        return implSpi.engineGetCertificate(alias);
    }

    /**
     * Returns the creation date of the entry with the given alias.
     *
     * @param alias
     *            the alias for the entry.
     * @return the creation date, or {@code null} if the specified alias is not
     *         bound to an entry.
     * @throws KeyStoreException
     *             if this {@code KeyStore} is not initialized.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.356 -0500", hash_original_method = "0EAF8EB6AFEC620E9CCB79F4CF9FFE6B", hash_generated_method = "BB29742FB9710FA49E1661D262260608")
    
public final Date getCreationDate(String alias) throws KeyStoreException {
        if (!isInit) {
            throwNotInitialized();
        }
        return implSpi.engineGetCreationDate(alias);
    }

    /**
     * Associates the given alias with the key, password and certificate chain.
     * <p>
     * If the specified alias already exists, it will be reassigned.
     *
     * @param alias
     *            the alias for the key.
     * @param key
     *            the key.
     * @param password
     *            the password.
     * @param chain
     *            the certificate chain.
     * @throws KeyStoreException
     *             if this {@code KeyStore} is not initialized.
     * @throws IllegalArgumentException
     *             if {@code key} is a {@code PrivateKey} and {@code chain} does
     *             not contain any certificates.
     * @throws NullPointerException
     *             if {@code alias} is {@code null}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.359 -0500", hash_original_method = "7F7563B0251ACD30AE23F02FDE0285F3", hash_generated_method = "53825E022FE210A109204949934C0C15")
    
public final void setKeyEntry(String alias, Key key, char[] password,
            Certificate[] chain) throws KeyStoreException {
        if (!isInit) {
            throwNotInitialized();
        }

        // Certificate chain is required for PrivateKey
        if (key != null && key instanceof PrivateKey && (chain == null || chain.length == 0)) {
            throw new IllegalArgumentException("Certificate chain is not defined for Private key");
        }
        implSpi.engineSetKeyEntry(alias, key, password, chain);
    }

    /**
     * Associates the given alias with a key and a certificate chain.
     * <p>
     * If the specified alias already exists, it will be reassigned.
     * <p>
     * If this {@code KeyStore} is of type {@code "jks"}, {@code key} must be
     * encoded conform to the PKS#8 standard as an
     * {@link javax.crypto.EncryptedPrivateKeyInfo}.
     *
     * @param alias
     *            the alias for the key.
     * @param key
     *            the key in an encoded format.
     * @param chain
     *            the certificate chain.
     * @throws KeyStoreException
     *             if this {@code KeyStore} is not initialized or if {@code key}
     *             is null.
     * @throws IllegalArgumentException
     *             if {@code key} is a {@code PrivateKey} and {@code chain}
     *             does.
     * @throws NullPointerException
     *             if {@code alias} is {@code null}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.362 -0500", hash_original_method = "E913EA9574669F2A71A3CC096B53E0CC", hash_generated_method = "BD4405CB0CF9146652DBA2800A88FAD8")
    
public final void setKeyEntry(String alias, byte[] key, Certificate[] chain)
            throws KeyStoreException {
        if (!isInit) {
            throwNotInitialized();
        }
        implSpi.engineSetKeyEntry(alias, key, chain);
    }

    /**
     * Associates the given alias with a certificate.
     * <p>
     * If the specified alias already exists, it will be reassigned.
     *
     * @param alias
     *            the alias for the certificate.
     * @param cert
     *            the certificate.
     * @throws KeyStoreException
     *             if this {@code KeyStore} is not initialized, or an existing
     *             alias is not associated to an entry containing a trusted
     *             certificate, or this method fails for any other reason.
     * @throws NullPointerException
     *             if {@code alias} is {@code null}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.364 -0500", hash_original_method = "219C504E98378892F0A1CF69789298BA", hash_generated_method = "6CFC1B4D6B237639B2C802EB0DBEFCF1")
    
public final void setCertificateEntry(String alias, Certificate cert) throws KeyStoreException {
        if (!isInit) {
            throwNotInitialized();
        }
        implSpi.engineSetCertificateEntry(alias, cert);
    }

    /**
     * Deletes the entry identified with the given alias from this {@code
     * KeyStore}.
     *
     * @param alias
     *            the alias for the entry.
     * @throws KeyStoreException
     *             if this {@code KeyStore} is not initialized, or if the entry
     *             can not be deleted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.367 -0500", hash_original_method = "D120E113CB97F6A9A6BAA6717070A8E9", hash_generated_method = "E48E2460A1278FD8C40F2DA86946F3C1")
    
public final void deleteEntry(String alias) throws KeyStoreException {
        if (!isInit) {
            throwNotInitialized();
        }
        implSpi.engineDeleteEntry(alias);
    }

    /**
     * Returns an {@code Enumeration} over all alias names stored in this
     * {@code KeyStore}.
     *
     * @return an {@code Enumeration} over all alias names stored in this
     *         {@code KeyStore}.
     * @throws KeyStoreException
     *             if this {@code KeyStore} is not initialized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.369 -0500", hash_original_method = "E42AEF144F775210B33C3E2476EBCBA6", hash_generated_method = "56D616C33353FF79B4A3D6BA22C0BA23")
    
public final Enumeration<String> aliases() throws KeyStoreException {
        if (!isInit) {
            throwNotInitialized();
        }
        return implSpi.engineAliases();
    }

    /**
     * Indicates whether the given alias is present in this {@code KeyStore}.
     *
     * @param alias
     *            the alias of an entry.
     * @return {@code true} if the alias exists, {@code false} otherwise.
     * @throws KeyStoreException
     *             if this {@code KeyStore} is not initialized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.371 -0500", hash_original_method = "C6BE9F5B7D68857DC7838D988CC1BBA2", hash_generated_method = "3116756A6E715B8A3780FF431BCCA0A9")
    
public final boolean containsAlias(String alias) throws KeyStoreException {
        if (!isInit) {
            throwNotInitialized();
        }
        return implSpi.engineContainsAlias(alias);
    }

    /**
     * Returns the number of entries stored in this {@code KeyStore}.
     *
     * @return the number of entries stored in this {@code KeyStore}.
     * @throws KeyStoreException
     *             if this {@code KeyStore} is not initialized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.374 -0500", hash_original_method = "0C5DF7CD9C11C1EDF698C182DE8DC09F", hash_generated_method = "1D2EC9BFA696CD4ABFC9B6990C3EA76C")
    
public final int size() throws KeyStoreException {
        if (!isInit) {
            throwNotInitialized();
        }
        return implSpi.engineSize();
    }

    /**
     * Indicates whether the specified alias is associated with either a
     * {@link PrivateKeyEntry} or a {@link SecretKeyEntry}.
     *
     * @param alias
     *            the alias of an entry.
     * @return {@code true} if the given alias is associated with a key entry.
     * @throws KeyStoreException
     *             if this {@code KeyStore} is not initialized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.377 -0500", hash_original_method = "BA6657A192671EAB1AD9A79410689C41", hash_generated_method = "95F7DBBDDBBDA992105715A096C64DD6")
    
public final boolean isKeyEntry(String alias) throws KeyStoreException {
        if (!isInit) {
            throwNotInitialized();
        }
        return implSpi.engineIsKeyEntry(alias);
    }

    /**
     * Indicates whether the specified alias is associated with a
     * {@link TrustedCertificateEntry}.
     *
     * @param alias
     *            the alias of an entry.
     * @return {@code true} if the given alias is associated with a certificate
     *         entry.
     * @throws KeyStoreException
     *             if this {@code KeyStore} is not initialized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.380 -0500", hash_original_method = "1EB6026F3AFD92595C3B35AB93369F7A", hash_generated_method = "092C91F8F64C755F1577A0140CB04F1B")
    
public final boolean isCertificateEntry(String alias) throws KeyStoreException {
        if (!isInit) {
            throwNotInitialized();
        }
        return implSpi.engineIsCertificateEntry(alias);
    }

    /**
     * Returns the alias associated with the first entry whose certificate
     * matches the specified certificate.
     *
     * @param cert
     *            the certificate to find the associated entry's alias for.
     * @return the alias or {@code null} if no entry with the specified
     *         certificate can be found.
     * @throws KeyStoreException
     *             if this {@code KeyStore} is not initialized.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.382 -0500", hash_original_method = "2386A451870E6EF1C02A8B8C98B7CB68", hash_generated_method = "8801034168DC0BC1BC8F3AF03EA1E326")
    
public final String getCertificateAlias(Certificate cert) throws KeyStoreException {
        if (!isInit) {
            throwNotInitialized();
        }
        return implSpi.engineGetCertificateAlias(cert);
    }

    /**
     * Writes this {@code KeyStore} to the specified {@code OutputStream}. The
     * data written to the {@code OutputStream} is protected by the specified
     * password.
     *
     * @param stream
     *            the {@code OutputStream} to write the store's data to.
     * @param password
     *            the password to protect the data.
     * @throws KeyStoreException
     *             if this {@code KeyStore} is not initialized.
     * @throws IOException
     *             if a problem occurred while writing to the stream.
     * @throws NoSuchAlgorithmException
     *             if the required algorithm is not available.
     * @throws CertificateException
     *             if an exception occurred while storing the certificates of
     *             this {@code KeyStore}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.385 -0500", hash_original_method = "50BCB00A432CC31F15CE3B2C3DE7D43E", hash_generated_method = "9597F106D6D218BB9532058209CCB06D")
    
public final void store(OutputStream stream, char[] password)
            throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        if (!isInit) {
            throwNotInitialized();
        }

        //Just delegate stream and password to implSpi
        implSpi.engineStore(stream, password);
    }

    /**
     * Stores this {@code KeyStore} using the specified {@code
     * LoadStoreParameter}.
     *
     * @param param
     *            the {@code LoadStoreParameter} that specifies how to store
     *            this {@code KeyStore}, maybe {@code null}.
     * @throws KeyStoreException
     *             if this {@code KeyStore} is not initialized.
     * @throws IOException
     *             if a problem occurred while writing to the stream.
     * @throws NoSuchAlgorithmException
     *             if the required algorithm is not available.
     * @throws CertificateException
     *             if an exception occurred while storing the certificates of
     *             this {@code KeyStore}.
     * @throws IllegalArgumentException
     *             if the given {@link LoadStoreParameter} is not recognized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.388 -0500", hash_original_method = "C17746DBABB17F3EC34FB6DF10AE6233", hash_generated_method = "DE78FC405296D192C430789598E4FFEB")
    
public final void store(LoadStoreParameter param) throws KeyStoreException,
            IOException, NoSuchAlgorithmException, CertificateException {
        if (!isInit) {
            throwNotInitialized();
        }
        implSpi.engineStore(param);
    }

    /**
     * Initializes this {@code KeyStore} from the provided {@code InputStream}.
     * Pass {@code null} as the {@code stream} argument to initialize an empty
     * {@code KeyStore} or to initialize a {@code KeyStore} which does not rely
     * on an {@code InputStream}. This {@code KeyStore} utilizes the given
     * password to verify the stored data.
     *
     * @param stream
     *            the {@code InputStream} to load this {@code KeyStore}'s data
     *            from or {@code null}.
     * @param password
     *            the password to verify the stored data, maybe {@code null}.
     * @throws IOException
     *             if a problem occurred while reading from the stream.
     * @throws NoSuchAlgorithmException
     *             if the required algorithm is not available.
     * @throws CertificateException
     *             if an exception occurred while loading the certificates of
     *             this {@code KeyStore}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.391 -0500", hash_original_method = "E81C77E0001BACB83F4AF42B434C83C2", hash_generated_method = "6DC76D34DD4F91D7DF08A1B6AE70F584")
    
public final void load(InputStream stream, char[] password)
            throws IOException, NoSuchAlgorithmException, CertificateException {
        implSpi.engineLoad(stream, password);
        isInit = true;
    }
    
    public abstract static class Builder {

        /**
         * Returns a new {@code Builder} that holds the given {@code KeyStore}
         * and the given {@code ProtectionParameter}.
         *
         * @param keyStore
         *            the {@code KeyStore} to be held.
         * @param protectionParameter
         *            the {@code ProtectionParameter} to be held.
         * @return a new instance of {@code Builder} that holds the specified
         *         {@code KeyStore} and the specified {@code
         *         ProtectionParameter}.
         * @throws NullPointerException
         *             if {@code keyStore} or {@code protectionParameter} is
         *             {@code null}.
         * @throws IllegalArgumentException
         *             if the given {@code KeyStore} is not initialized.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.414 -0500", hash_original_method = "703780346CA44E93A9C7FCC54F14ACE1", hash_generated_method = "3271D0FC33A32E2C725DABBA2E916C4A")
        
public static Builder newInstance(KeyStore keyStore,
                ProtectionParameter protectionParameter) {
            if (keyStore == null) {
                throw new NullPointerException("keyStore == null");
            }
            if (protectionParameter == null) {
                throw new NullPointerException("protectionParameter == null");
            }
            if (!keyStore.isInit) {
                throw new IllegalArgumentException("KeyStore was not initialized");
            }
            return new BuilderImpl(keyStore, protectionParameter, null, null, null);
        }

        /**
         * Returns a new {@code Builder} that creates a new {@code KeyStore}
         * based on the provided arguments.
         * <p>
         * If {@code provider} is {@code null}, all installed providers are
         * searched, otherwise the key store from the specified provider is
         * used.
         *
         * @param type
         *            the type of the {@code KeyStore} to be constructed.
         * @param provider
         *            the provider of the {@code KeyStore} to be constructed,
         *            maybe {@code null}.
         * @param file
         *            the {@code File} that contains the data for the {@code
         *            KeyStore}.
         * @param protectionParameter
         *            the {@code ProtectionParameter} used to protect the stored
         *            keys.
         * @return a new {@code Builder} that creates a new {@code KeyStore}
         *         based on the provided arguments.
         * @throws NullPointerException
         *             if {@code type, protectionParameter} or {@code file} is
         *             {@code null}.
         * @throws IllegalArgumentException
         *             {@code protectionParameter} not an instance of either
         *             {@code PasswordProtection} or {@code
         *             CallbackHandlerProtection}, {@code file} is not a file or
         *             does not exist at all.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.417 -0500", hash_original_method = "B24FD3F204BF6F5210E95482A675EFF6", hash_generated_method = "13CA74068A0FFFED9CBAAA6C2E98EC5C")
        
public static Builder newInstance(String type, Provider provider,
                File file, ProtectionParameter protectionParameter) {
            // check null parameters
            if (type == null) {
                throw new NullPointerException("type == null");
            }
            if (protectionParameter == null) {
                throw new NullPointerException("protectionParameter == null");
            }
            if (file == null) {
                throw new NullPointerException("file == null");
            }
            // protection parameter should be PasswordProtection or
            // CallbackHandlerProtection
            if (!(protectionParameter instanceof PasswordProtection)
                    && !(protectionParameter instanceof CallbackHandlerProtection)) {
                throw new IllegalArgumentException("protectionParameter is neither "
                        + "PasswordProtection nor CallbackHandlerProtection instance");
            }
            // check file parameter
            if (!file.exists()) {
                throw new IllegalArgumentException("File does not exist: " + file.getName());
            }
            if (!file.isFile()) {
                throw new IllegalArgumentException("Not a regular file: " + file.getName());
            }
            // create new instance
            return new BuilderImpl(null, protectionParameter, file, type, provider);
        }

        /**
         * Returns a new {@code Builder} that creates a new {@code KeyStore}
         * based on the provided arguments.
         * <p>
         * If {@code provider} is {@code null}, all installed providers are
         * searched, otherwise the key store from the specified provider is
         * used.
         *
         * @param type
         *            the type of the {@code KeyStore} to be constructed.
         * @param provider
         *            the provider of the {@code KeyStore} to be constructed,
         *            maybe {@code null}.
         * @param protectionParameter
         *            the {@code ProtectionParameter} used to protect the stored
         *            keys.
         * @return a new {@code Builder} that creates a new {@code KeyStore}
         *         based on the provided arguments.
         * @throws NullPointerException
         *             if {@code type} or {@code protectionParameter} is {@code
         *             null}.
         * @throws IllegalArgumentException
         *             {@code protectionParameter} not an instance of either
         *             {@code PasswordProtection} or {@code
         *             CallbackHandlerProtection}, {@code file} is not a file or
         *             does not exist at all.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.420 -0500", hash_original_method = "9065E98407E4012A718BCCD9814CFD1A", hash_generated_method = "EF96054A427E2EF4B7211AA84AD51861")
        
public static Builder newInstance(String type, Provider provider,
                ProtectionParameter protectionParameter) {
            if (type == null) {
                throw new NullPointerException("type == null");
            }
            if (protectionParameter == null) {
                throw new NullPointerException("protectionParameter == null");
            }
            return new BuilderImpl(null, protectionParameter, null, type, provider);
        }
        /**
         * Constructs a new instance of {@code Builder}.
         */
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.406 -0500", hash_original_method = "7023F746232F077A36DCA003B1A512D2", hash_generated_method = "D72EC4D14B5F735B84D6DB27DA28A7C4")
        
protected Builder() {
        }

        /**
         * Returns the {@code KeyStore} created by this {@code Builder}.
         *
         * @return the {@code KeyStore} created by this {@code Builder}.
         * @throws KeyStoreException
         *             if an error occurred during construction.
         */
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.408 -0500", hash_original_method = "12C5317A3C346239CA56FE27936EEF14", hash_generated_method = "F6F3B96B5ACA3FA7BED29BE5A3EB2466")
        
public abstract KeyStore getKeyStore() throws KeyStoreException;

        /**
         * Returns the {@code ProtectionParameter} to be used when a {@code
         * Entry} with the specified alias is requested. Before this method is
         * invoked, {@link #getKeyStore()} must be called.
         *
         * @param alias
         *            the alias for the entry.
         * @return the {@code ProtectionParameter} to be used when a {@code
         *         Entry} with the specified alias is requested.
         * @throws KeyStoreException
         *             if an error occurred during the lookup for the protection
         *             parameter.
         * @throws IllegalStateException
         *             if {@link #getKeyStore()} is not called prior the
         *             invocation of this method.
         * @throws NullPointerException
         *             if {@code alias} is {@code null}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.411 -0500", hash_original_method = "EF7FCB92131CCE515920D4F9872D97D3", hash_generated_method = "7D0735A8C5C49CDEBB711756D26F3EDD")
        
public abstract ProtectionParameter getProtectionParameter(String alias)
                throws KeyStoreException;
        
        private static class BuilderImpl extends Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.423 -0500", hash_original_field = "4D31A7EB6B508C097C6B9FC4902A8B77", hash_generated_field = "A7031BA8689424ABC672EAE318A6BC51")

            private KeyStore keyStore;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.426 -0500", hash_original_field = "61788874BBA749B7BF3C47A0C8DA8009", hash_generated_field = "38E327C8AA851ED0B0D5FA2FC9B4AA0F")

            private ProtectionParameter protParameter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.429 -0500", hash_original_field = "E0BAA217A890DB23927E17EE4C6FD9BF", hash_generated_field = "8AC37504A350A98951D869F1BEF2A368")

            private  String typeForKeyStore;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.432 -0500", hash_original_field = "5047AAD0BF861482AD5B67294E5324C2", hash_generated_field = "23FFFF4ED679110911D207F6B64A4AC8")

            private  Provider providerForKeyStore;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.435 -0500", hash_original_field = "79294E254AD2C97C2B03D0578A793191", hash_generated_field = "31C223C537F5C996C5DC6F1AB08A4D66")

            private  File fileForLoad;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.438 -0500", hash_original_field = "FAA3BEDA7D524C98037004281CD5C2DF", hash_generated_field = "C3C0197C1266E33C5DA7A01BC63B802B")

            private boolean isGetKeyStore = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.440 -0500", hash_original_field = "61ADD9BE1826EE9107970E701163A04F", hash_generated_field = "891CCD6D1168D0C98F10193D87BD26F3")

            private KeyStoreException lastException;

            /**
             * Constructor BuilderImpl initializes private fields: keyStore,
             * protParameter, typeForKeyStore providerForKeyStore fileForLoad,
             * isGetKeyStore
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.443 -0500", hash_original_method = "3CD3C55013D5D374D36888ABFD4145EB", hash_generated_method = "3CD3C55013D5D374D36888ABFD4145EB")
            
BuilderImpl(KeyStore ks, ProtectionParameter pp, File file,
                        String type, Provider provider) {
                keyStore = ks;
                protParameter = pp;
                fileForLoad = file;
                typeForKeyStore = type;
                providerForKeyStore = provider;
                isGetKeyStore = false;
                lastException = null;
            }

            /**
             * Implementation of abstract getKeyStore() method If
             * KeyStoreBuilder encapsulates KeyStore object then this object is
             * returned
             *
             * If KeyStoreBuilder encapsulates KeyStore type and provider then
             * KeyStore is created using these parameters. If KeyStoreBuilder
             * encapsulates file and ProtectionParameter then KeyStore data are
             * loaded from FileInputStream that is created on file. If file is
             * not defined then KeyStore object is initialized with null
             * InputStream and null password.
             *
             * Result KeyStore object is returned.
             */
            @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.447 -0500", hash_original_method = "ACF5EEE61FC6C7F04EA4DB97E46396E0", hash_generated_method = "9847BB0654BF4D878FC757CE80868BE3")
            
@Override
            public synchronized KeyStore getKeyStore() throws KeyStoreException {
                // If KeyStore was created but in final block some exception was
                // thrown
                // then it was stored in lastException variable and will be
                // thrown
                // all subsequent calls of this method.
                if (lastException != null) {
                    throw lastException;
                }
                if (keyStore != null) {
                    isGetKeyStore = true;
                    return keyStore;
                }

                try {
                    // get KeyStore instance using type or type and provider
                    final KeyStore ks = (providerForKeyStore == null ? KeyStore
                            .getInstance(typeForKeyStore) : KeyStore
                            .getInstance(typeForKeyStore, providerForKeyStore));
                    // protection parameter should be PasswordProtection
                    // or CallbackHandlerProtection
                    final char[] passwd;
                    if (protParameter instanceof PasswordProtection) {
                        passwd = ((PasswordProtection) protParameter)
                                .getPassword();
                    } else if (protParameter instanceof CallbackHandlerProtection) {
                        passwd = KeyStoreSpi
                                .getPasswordFromCallBack(protParameter);
                    } else {
                        throw new KeyStoreException("protectionParameter is neither "
                                + "PasswordProtection nor CallbackHandlerProtection instance");
                    }

                    // load KeyStore from file
                    if (fileForLoad != null) {
                        FileInputStream fis = null;
                        try {
                            fis = new FileInputStream(fileForLoad);
                            ks.load(fis, passwd);
                        } finally {
                            IoUtils.closeQuietly(fis);
                        }
                    } else {
                        ks.load(new TmpLSParameter(protParameter));
                    }

                    isGetKeyStore = true;
                    return ks;
                } catch (KeyStoreException e) {
                    // Store exception
                    throw lastException = e;
                } catch (Exception e) {
                    // Override exception
                    throw lastException = new KeyStoreException(e);
                }
            }

            /**
             * This is implementation of abstract method
             * getProtectionParameter(String alias)
             *
             * Return: ProtectionParameter to get Entry which was saved in
             * KeyStore with defined alias
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.451 -0500", hash_original_method = "061E86DD88FD52DC90E5A1CECB03A11C", hash_generated_method = "99D283B3B2DAC35DA2BEDC1C2BB0B8A2")
            
@Override
            public synchronized ProtectionParameter getProtectionParameter(
                    String alias) throws KeyStoreException {
                if (alias == null) {
                    throw new NullPointerException("alias == null");
                }
                if (!isGetKeyStore) {
                    throw new IllegalStateException("getKeyStore() was not invoked");
                }
                return protParameter;
            }
            
        }
        
        private static class TmpLSParameter implements LoadStoreParameter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.457 -0500", hash_original_field = "3D0A85BC445BB33BD2E720ECDB112CD0", hash_generated_field = "1BB0FC91976F0354B54BD7DD6D315784")

            private  ProtectionParameter protPar;

            /**
             * Creates TmpLoadStoreParameter object
             * @param protPar protection parameter
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.460 -0500", hash_original_method = "418DF9EAB7B4417735B80C8244C9AAA5", hash_generated_method = "BFD674CAB6DE061205F9BCB08081AA0D")
            
public TmpLSParameter(ProtectionParameter protPar) {
                this.protPar = protPar;
            }

            /**
             * This method returns protection parameter
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.463 -0500", hash_original_method = "DB6A0984AE74C268B3C1D4EEBB473782", hash_generated_method = "CFA6CD4703EF198469E5FF26C280B08E")
            
public ProtectionParameter getProtectionParameter() {
                return protPar;
            }
            
        }
        
    }
    
    public static class CallbackHandlerProtection implements ProtectionParameter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.473 -0500", hash_original_field = "FE40C24C8725B2D4EE000B726D3ACB84", hash_generated_field = "30CF87E450CC91F7899E85CF6B0C3092")

        private  CallbackHandler callbackHandler;

        /**
         * Constructs a new instance of {@code CallbackHandlerProtection} with
         * the {@code CallbackHandler}.
         *
         * @param handler
         *            the {@code CallbackHandler}.
         * @throws NullPointerException
         *             if {@code handler} is {@code null}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.476 -0500", hash_original_method = "082187234AF211B1FD0C2CCB255E95A4", hash_generated_method = "2EC89F2BDACB24CBDCB74B6C842D923B")
        
public CallbackHandlerProtection(CallbackHandler handler) {
            if (handler == null) {
                throw new NullPointerException("handler == null");
            }
            this.callbackHandler = handler;
        }

        /**
         * Returns the {@code CallbackHandler}.
         *
         * @return the {@code CallbackHandler}.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.478 -0500", hash_original_method = "0C642C7CCF2E4FDE3C3DD3C1F1B0C85D", hash_generated_method = "19D205C1924C5B485C197F58998EC565")
        
public CallbackHandler getCallbackHandler() {
            return callbackHandler;
        }
        
    }
    
    public static class PasswordProtection implements ProtectionParameter, Destroyable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.488 -0500", hash_original_field = "21BCD293DE862031F898430214E88677", hash_generated_field = "E9D3F141738563A4D1D32A99D6434F98")

        private char[] password;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.491 -0500", hash_original_field = "4213EC5657A5F1A8B33184629C524032", hash_generated_field = "4E9B5F95BF3CB214CC7936EEE230143C")

        private boolean isDestroyed = false;

        /**
         * Constructs a new instance of {@code PasswordProtection} with a
         * password. A copy of the password is stored in the new {@code
         * PasswordProtection} object.
         *
         * @param password
         *            the password, maybe {@code null}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.494 -0500", hash_original_method = "C494DBA0C69BF408259455310AC039E3", hash_generated_method = "20A8B1BAD2E70EC58C296CEE7992A541")
        
public PasswordProtection(char[] password) {
            if (password != null) {
                this.password = password.clone();
            }
        }

        /**
         * Returns the password.
         *
         * @return the password.
         * @throws IllegalStateException
         *             if the password has been destroyed.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.497 -0500", hash_original_method = "6430A16E89645A8E6431B65352266760", hash_generated_method = "0010C94564C21D8A6F9E173A2A8E2796")
        
public synchronized char[] getPassword() {
            if (isDestroyed) {
                throw new IllegalStateException("Password was destroyed");
            }
            return password;
        }

        /**
         * Destroys / invalidates the password.
         *
         * @throws DestroyFailedException
         *             if the password could not be invalidated.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.499 -0500", hash_original_method = "F88C179D8B1E4290EAB43DF5D76D0F80", hash_generated_method = "B967AC2ED81E715F490EFC2FB529F87A")
        
public synchronized void destroy() throws DestroyFailedException {
            isDestroyed = true;
            if (password != null) {
                Arrays.fill(password, '\u0000');
                password = null;
            }
        }

        /**
         * Indicates whether the password is invalidated.
         *
         * @return {@code true} if the password is invalidated, {@code false}
         *         otherwise.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.502 -0500", hash_original_method = "B936E1D4B92F105E0DF31A4819E36563", hash_generated_method = "D9B00402E70972A372B16B54B1144946")
        
public synchronized boolean isDestroyed() {
            return isDestroyed;
        }
        
    }
    
    public static final class PrivateKeyEntry implements Entry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.510 -0500", hash_original_field = "182559F848516BAE32412B11539EE461", hash_generated_field = "FE25B04A839309E9F85BB11D3AB28CB0")

        private Certificate[] chain;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.513 -0500", hash_original_field = "E343478F4FCDDE86054B291B9794F31B", hash_generated_field = "0BDA09A35A184B3500330A0D915760C1")

        private PrivateKey privateKey;

        /**
         * Constructs a new instance of {@code PrivateKeyEntry} with the given
         * {@code PrivateKey} and the provided certificate chain.
         *
         * @param privateKey
         *            the private key.
         * @param chain
         *            the ordered certificate chain with the certificate
         *            corresponding to the private key at index 0.
         * @throws NullPointerException
         *             if {@code privateKey} or {@code chain} is {@code null}.
         * @throws IllegalArgumentException
         *             if {@code chain.length == 0}, the algorithm of the
         *             private key does not match the algorithm of the public
         *             key of the first certificate or the certificates are not
         *             all of the same type.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.517 -0500", hash_original_method = "AB76A830A9A2D95E963CA1BDB15D3DF1", hash_generated_method = "4A2AAB507D4E96ADFD410162554A211C")
        
public PrivateKeyEntry(PrivateKey privateKey, Certificate[] chain) {
            if (privateKey == null) {
                throw new NullPointerException("privateKey == null");
            }
            if (chain == null) {
                throw new NullPointerException("chain == null");
            }

            if (chain.length == 0) {
                throw new IllegalArgumentException("chain.length == 0");
            }
            // Match algorithm of private key and algorithm of public key from
            // the end certificate
            String s = chain[0].getType();
            if (!(chain[0].getPublicKey().getAlgorithm()).equals(privateKey.getAlgorithm())) {
                throw new IllegalArgumentException("Algorithm of private key does not match "
                        + "algorithm of public key in end certificate of entry "
                        + "(with index number: 0)");
            }
            // Match certificate types
            for (int i = 1; i < chain.length; i++) {
                if (!s.equals(chain[i].getType())) {
                    throw new IllegalArgumentException("Certificates from the given chain have "
                                                       + "different types");
                }
            }
            // clone chain - this.chain = (Certificate[])chain.clone();
            boolean isAllX509Certificates = true;
            // assert chain length > 0
            for (Certificate cert: chain) {
                if (!(cert instanceof X509Certificate)) {
                    isAllX509Certificates = false;
                    break;
                }
            }

            if(isAllX509Certificates){
                this.chain = new X509Certificate[chain.length];
            } else {
                this.chain = new Certificate[chain.length];
            }
            System.arraycopy(chain, 0, this.chain, 0, chain.length);
            this.privateKey = privateKey;
        }

        /**
         * Returns the private key.
         *
         * @return the private key.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.520 -0500", hash_original_method = "20D5E1BC38F4066008A03A45816FEC0F", hash_generated_method = "5B753A9A2F3D9D0C05D9306EEE56584A")
        
public PrivateKey getPrivateKey() {
            return privateKey;
        }

        /**
         * Returns the certificate chain.
         *
         * @return the certificate chain.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.523 -0500", hash_original_method = "51F3F412A111F70F6F64117AFABD929B", hash_generated_method = "5D73907C575CB9752ADAB42E06C60F4C")
        
public Certificate[] getCertificateChain() {
            return chain.clone();
        }

        /**
         * Returns the certificate corresponding to the private key.
         *
         * @return the certificate corresponding to the private key.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.525 -0500", hash_original_method = "547F6E4E355F50070DC97734154D15F8", hash_generated_method = "393C75C740F53BCDEF5E713784404FA9")
        
public Certificate getCertificate() {
            return chain[0];
        }

        /**
         * Returns a string containing a concise, human-readable description of
         * this {@code PrivateKeyEntry}.
         *
         * @return a printable representation for this {@code PrivateKeyEntry}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.528 -0500", hash_original_method = "D914F0EEEB01F1C9E1AEDB9A7E511AAE", hash_generated_method = "AB75A06FEE33076F0A54F8FF9A2E5754")
        
@Override
        public String toString() {
            StringBuilder sb = new StringBuilder(
                    "PrivateKeyEntry: number of elements in certificate chain is ");
            sb.append(Integer.toString(chain.length));
            sb.append("\n");
            for (int i = 0; i < chain.length; i++) {
                sb.append(chain[i].toString());
                sb.append("\n");
            }
            return sb.toString();
        }
        
    }
    
    public static final class SecretKeyEntry implements Entry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.534 -0500", hash_original_field = "29947246607A38D09D44A9B15E11C9E0", hash_generated_field = "A5F456CD49483E3B0CB368BDF388AD8F")

        private  SecretKey secretKey;

        /**
         * Constructs a new instance of {@code SecretKeyEntry} with the given
         * {@code SecretKey}.
         *
         * @param secretKey
         *            the secret key.
         * @throws NullPointerException
         *             if {@code secretKey} is {@code null}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.537 -0500", hash_original_method = "F9E1B0F4E30BBF70203478C91D1B2E03", hash_generated_method = "21CA2AC14A889A4050449F18871DEFB1")
        
public SecretKeyEntry(SecretKey secretKey) {
            if (secretKey == null) {
                throw new NullPointerException("secretKey == null");
            }
            this.secretKey = secretKey;
        }

        /**
         * Returns the secret key.
         *
         * @return the secret key.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.540 -0500", hash_original_method = "086B5E46810BA78C7777CDD972BB99BA", hash_generated_method = "669B0F72C4845C597C9D596CC83DD04D")
        
public SecretKey getSecretKey() {
            return secretKey;
        }

        /**
         * Returns a string containing a concise, human-readable description of
         * this {@code SecretKeyEntry}.
         *
         * @return a printable representation for this {@code
         *         SecretKeyEntry}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.543 -0500", hash_original_method = "55CC87C17B2642C3020CD374CFB01521", hash_generated_method = "226EE2A9DCD9214D922DF654ED8EBF4D")
        
@Override
        public String toString() {
            StringBuilder sb = new StringBuilder("SecretKeyEntry: algorithm - ");
            sb.append(secretKey.getAlgorithm());
            return sb.toString();
        }
        
    }
    
    public static final class TrustedCertificateEntry implements Entry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.548 -0500", hash_original_field = "455D0E3424E3FE17007671D2CCAF5B36", hash_generated_field = "39224D52D2F645BDA1C3AA5572035EB1")

        private  Certificate trustCertificate;

        /**
         * Constructs a new instance of {@code TrustedCertificateEntry} with the
         * given {@code Certificate}.
         *
         * @param trustCertificate
         *            the trusted certificate.
         * @throws NullPointerException
         *             if {@code trustCertificate} is {@code null}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.551 -0500", hash_original_method = "78C27D1B59CEF64A7070E3BE7884B747", hash_generated_method = "AD79A05E880E327781A48543983C227C")
        
public TrustedCertificateEntry(Certificate trustCertificate) {
            if (trustCertificate == null) {
                throw new NullPointerException("trustCertificate == null");
            }
            this.trustCertificate = trustCertificate;
        }

        /**
         * Returns the trusted certificate.
         *
         * @return the trusted certificate.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.553 -0500", hash_original_method = "4E60EB3F26EAC182CAA181F2D2BA1C01", hash_generated_method = "1AA610F133F8C6ACA25051097875BD31")
        
public Certificate getTrustedCertificate() {
            return trustCertificate;
        }

        /**
         * Returns a string containing a concise, human-readable description of
         * this {@code TrustedCertificateEntry}.
         *
         * @return a printable representation for this {@code
         *         TrustedCertificateEntry}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.556 -0500", hash_original_method = "706775B4BFB1342C7053CE6A0D4515B7", hash_generated_method = "824361BC2C1987F3B245C9D7C4AFE92C")
        
@Override
        public String toString() {
            return "Trusted certificate entry:\n" + trustCertificate;
        }
        
    }
    
    public static interface Entry {
    }
    
    public static interface LoadStoreParameter {
        
        public ProtectionParameter getProtectionParameter();
    }
    
    public static interface ProtectionParameter {
    }

    /**
     * Loads this {@code KeyStore} using the specified {@code
     * LoadStoreParameter}.
     *
     * @param param
     *            the {@code LoadStoreParameter} that specifies how to load this
     *            {@code KeyStore}, maybe {@code null}.
     * @throws IOException
     *             if a problem occurred while reading from the stream.
     * @throws NoSuchAlgorithmException
     *             if the required algorithm is not available.
     * @throws CertificateException
     *             if an exception occurred while loading the certificates of
     *             this {@code KeyStore}.
     * @throws IllegalArgumentException
     *             if the given {@link LoadStoreParameter} is not recognized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.393 -0500", hash_original_method = "C4F6682CFB8856C5C1A14F5939BD3C2A", hash_generated_method = "BDE33E87F5F2C8001C93D6D865B27DAF")
    
public final void load(LoadStoreParameter param) throws IOException,
            NoSuchAlgorithmException, CertificateException {
        implSpi.engineLoad(param);
        isInit = true;
    }

    /**
     * Returns the {@code Entry} with the given alias, using the specified
     * {@code ProtectionParameter}.
     *
     * @param alias
     *            the alias of the requested entry.
     * @param param
     *            the {@code ProtectionParameter} used to protect the requested
     *            entry, maybe {@code null}.
     * @return he {@code Entry} with the given alias, using the specified
     *         {@code ProtectionParameter}.
     * @throws NoSuchAlgorithmException
     *             if the required algorithm is not available.
     * @throws UnrecoverableEntryException
     *             if the entry can not be recovered.
     * @throws KeyStoreException
     *             if this {@code KeyStore} is not initialized.
     * @throws NullPointerException
     *             if {@code alias} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.396 -0500", hash_original_method = "545D5A95E5DE487291148190C6871E3B", hash_generated_method = "C0A8112F7EF91147DE44360F7D4E2CC1")
    
public final Entry getEntry(String alias, ProtectionParameter param)
            throws NoSuchAlgorithmException, UnrecoverableEntryException, KeyStoreException {
        if (alias == null) {
            throw new NullPointerException("alias == null");
        }
        if (!isInit) {
            throwNotInitialized();
        }
        return implSpi.engineGetEntry(alias, param);
    }

    /**
     * Stores the given {@code Entry} in this {@code KeyStore} and associates
     * the entry with the given {@code alias}. The entry is protected by the
     * specified {@code ProtectionParameter}.
     * <p>
     * If the specified alias already exists, it will be reassigned.
     *
     * @param alias
     *            the alias for the entry.
     * @param entry
     *            the entry to store.
     * @param param
     *            the {@code ProtectionParameter} to protect the entry.
     * @throws KeyStoreException
     *             if this {@code KeyStore} is not initialized.
     * @throws NullPointerException
     *             if {@code alias} is {@code null} or {@code entry} is {@code
     *             null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.399 -0500", hash_original_method = "1BFB042779188D83DA91333F58C1246D", hash_generated_method = "40EDE685C35640EB511C52BB097F9144")
    
public final void setEntry(String alias, Entry entry,
            ProtectionParameter param) throws KeyStoreException {
        if (!isInit) {
            throwNotInitialized();
        }
        if (alias == null) {
            throw new NullPointerException("alias == null");
        }
        if (entry == null) {
            throw new NullPointerException("entry == null");
        }
        implSpi.engineSetEntry(alias, entry, param);
    }

    /**
     * Indicates whether the entry for the given alias is assignable to the
     * provided {@code Class}.
     *
     * @param alias
     *            the alias for the entry.
     * @param entryClass
     *            the type of the entry.
     * @return {@code true} if the {@code Entry} for the alias is assignable to
     *         the specified {@code entryClass}.
     * @throws KeyStoreException
     *             if this {@code KeyStore} is not initialized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:56.402 -0500", hash_original_method = "F0D9850AE080958F26BEB4963CD5F0EF", hash_generated_method = "1036853A0729ED6EB0C3AED41E013A97")
    
public final boolean entryInstanceOf(String alias,
            Class<? extends KeyStore.Entry> entryClass)
            throws KeyStoreException {
        if (alias == null) {
            throw new NullPointerException("alias == null");
        }
        if (entryClass == null) {
            throw new NullPointerException("entryClass == null");
        }

        if (!isInit) {
            throwNotInitialized();
        }
        return implSpi.engineEntryInstanceOf(alias, entryClass);
    }
}

