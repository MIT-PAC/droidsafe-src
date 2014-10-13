package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;

import org.apache.harmony.security.fortress.Engine;

public class SSLContext {

    /**
     * Returns the default SSLContext.
     *
     * The default SSL context can be set with {@link #setDefault}. If
     * not, one will be created with {@code
     * SSLContext.getInstance("Default")}, which will already be
     * initialized.
     *
     * @throws NoSuchAlgorithmException if there is a problem creating
     * the default instance.
     * @since 1.6
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.935 -0500", hash_original_method = "95B85BB32D8715FAB21A58C07C90C0CF", hash_generated_method = "AE9C5CE95C71C9318BAA63E07FB050DC")
    
public static SSLContext getDefault() throws NoSuchAlgorithmException {
        synchronized (ENGINE) {
            if (DEFAULT == null) {
                DEFAULT = SSLContext.getInstance("Default");
            }
            return DEFAULT;
        }
    }

    /**
     * Sets the default SSLContext instance as returned by {@link
     * #getDefault()} to a non-null initialized value.
     *
     * @throws NullPointerException on a null argument
     * @since 1.6
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.937 -0500", hash_original_method = "CD249DA83A6553D8042C3D056F14877E", hash_generated_method = "E1C154430A8D6939BA6AF42965804786")
    
public static void setDefault(SSLContext sslContext) {
        if (sslContext == null) {
            throw new NullPointerException("sslContext == null");
        }
        synchronized (ENGINE) {
            DEFAULT = sslContext;
        }
    }

    /**
     * Creates a new {@code SSLContext} instance for the specified protocol.
     *
     * @param protocol
     *            the requested protocol to create a context for.
     * @return the created {@code SSLContext} instance.
     * @throws NoSuchAlgorithmException
     *             if no installed provider can provide the requested protocol
     * @throws NullPointerException
     *             if {@code protocol} is {@code null} (instead of
     *             NoSuchAlgorithmException as in 1.4 release)
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.940 -0500", hash_original_method = "290AE10C7E5CA88B73DF82087A6F1FF6", hash_generated_method = "BF2C0057FB297CFA34EBDA8AFBA00B97")
    
public static SSLContext getInstance(String protocol) throws NoSuchAlgorithmException {
        if (protocol == null) {
            throw new NullPointerException("protocol is null");
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(protocol, null);
        return new SSLContext((SSLContextSpi) sap.spi, sap.provider, protocol);
    }

    /**
     * Creates a new {@code SSLContext} instance for the specified protocol from
     * the specified provider.
     *
     * @param protocol
     *            the requested protocol to create a context for.
     * @param provider
     *            the name of the provider that provides the requested protocol.
     * @return an {@code SSLContext} for the requested protocol.
     * @throws NoSuchAlgorithmException
     *             if the specified provider cannot provider the requested
     *             protocol.
     * @throws NoSuchProviderException
     *             if the specified provider does not exits.
     * @throws NullPointerException
     *             if {@code protocol} is {@code null} (instead of
     *             NoSuchAlgorithmException as in 1.4 release)
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.942 -0500", hash_original_method = "FB566E7CF465D4D2FD3830A55B204330", hash_generated_method = "7A73B622B29BDE0EDFDF42DADE3800F2")
    
public static SSLContext getInstance(String protocol, String provider)
            throws NoSuchAlgorithmException, NoSuchProviderException {
        if (provider == null) {
            throw new IllegalArgumentException("Provider is null");
        }
        if (provider.length() == 0) {
            throw new IllegalArgumentException("Provider is empty");
        }
        Provider impProvider = Security.getProvider(provider);
        if (impProvider == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(protocol, impProvider);
    }

    /**
     * Creates a new {@code SSLContext} instance for the specified protocol from
     * the specified provider.
     *
     * @param protocol
     *            the requested protocol to create a context for
     * @param provider
     *            the provider that provides the requested protocol.
     * @return an {@code SSLContext} for the requested protocol.
     * @throws NoSuchAlgorithmException
     *             if the specified provider cannot provide the requested
     *             protocol.
     * @throws NullPointerException
     *             if {@code protocol} is {@code null} (instead of
     *             NoSuchAlgorithmException as in 1.4 release)
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.945 -0500", hash_original_method = "391F8D562A0F9200AE7CEB2E407E9313", hash_generated_method = "AF9B106B072669656950AD6A135A0807")
    
public static SSLContext getInstance(String protocol, Provider provider)
            throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider is null");
        }
        if (protocol == null) {
            throw new NullPointerException("protocol is null");
        }
        Object spi = ENGINE.getInstance(protocol, provider, null);
        return new SSLContext((SSLContextSpi) spi, provider, protocol);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.927 -0500", hash_original_field = "2FA34E623E8D8C604B054B1C8CF4587A", hash_generated_field = "F9968588171E1F6215F8BDC43FEE8F36")

    private static final String SERVICE = "SSLContext";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.930 -0500", hash_original_field = "17F86B5CB94419D7D346BC8D1B101EA5", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.932 -0500", hash_original_field = "50CAFB43E1FA192D4A2E9F04A2DBB316", hash_generated_field = "2B7DA749EDE2455861561266A5813438")

    private static SSLContext DEFAULT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.947 -0500", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private  Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.950 -0500", hash_original_field = "CFEE11B24DA2F4BBB4EF246AF4DA8F53", hash_generated_field = "35670434E65BDBAFCC16200249E01B00")

    private  SSLContextSpi spiImpl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.952 -0500", hash_original_field = "DE3F28962485CE99CA97D0A480B93596", hash_generated_field = "512C13BA7A4120A610964F395EA31E91")

    private  String protocol;

    /**
     * Creates a new {@code SSLContext}.
     *
     * @param contextSpi
     *            the implementation delegate.
     * @param provider
     *            the provider.
     * @param protocol
     *            the protocol name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.955 -0500", hash_original_method = "C804D9011355FC1C1182E28B9F55F9CC", hash_generated_method = "51949A4394879F3440099AB86F04B2E6")
    
protected SSLContext(SSLContextSpi contextSpi, Provider provider, String protocol) {
        this.provider = provider;
        this.protocol = protocol;
        this.spiImpl = contextSpi;
    }

    /**
     * Returns the name of the secure socket protocol of this instance.
     *
     * @return the name of the secure socket protocol of this instance.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.957 -0500", hash_original_method = "A74773FBD6292704847794FB8A3C1AB0", hash_generated_method = "4DF996DD4ED6E38DFDC56EAB9AE5D939")
    
public final String getProtocol() {
        return protocol;
    }

    /**
     * Returns the provider of this {@code SSLContext} instance.
     *
     * @return the provider of this {@code SSLContext} instance.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.959 -0500", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
    
public final Provider getProvider() {
        return provider;
    }

    /**
     * Initializes this {@code SSLContext} instance. All of the arguments are
     * optional, and the security providers will be searched for the required
     * implementations of the needed algorithms.
     *
     * @param km
     *            the key sources or {@code null}.
     * @param tm
     *            the trust decision sources or {@code null}.
     * @param sr
     *            the randomness source or {@code null.}
     * @throws KeyManagementException
     *             if initializing this instance fails.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.961 -0500", hash_original_method = "862C6735087482F43EE162F8A0522BCE", hash_generated_method = "54937273F02B9EF1E587F83D41C29AEC")
    
public final void init(KeyManager[] km, TrustManager[] tm, SecureRandom sr)
            throws KeyManagementException {
        spiImpl.engineInit(km, tm, sr);
    }

    /**
     * Returns a socket factory for this instance.
     *
     * @return a socket factory for this instance.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.964 -0500", hash_original_method = "B0765B951456A1F8D049DA95DEF67C61", hash_generated_method = "AE7AC5E9642A89A29A96C5CF6A2BF2BD")
    
public final SSLSocketFactory getSocketFactory() {
        return spiImpl.engineGetSocketFactory();
    }

    /**
     * Returns a server socket factory for this instance.
     *
     * @return a server socket factory for this instance.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.967 -0500", hash_original_method = "6B854724B17F4BE278032C18BCD40494", hash_generated_method = "63ACCC172110C9DC2EB130015056916C")
    
public final SSLServerSocketFactory getServerSocketFactory() {
        return spiImpl.engineGetServerSocketFactory();
    }

    /**
     * Creates an {@code SSLEngine} instance from this context.
     *
     * @return an {@code SSLEngine} instance from this context.
     * @throws UnsupportedOperationException
     *             if the provider does not support the operation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.970 -0500", hash_original_method = "9326AAD5FC0B444F9C3CCC582EB8A84C", hash_generated_method = "B6B1C0F22D56A1CEE368F0B54F2991CB")
    
public final SSLEngine createSSLEngine() {
        return spiImpl.engineCreateSSLEngine();
    }

    /**
     * Creates an {@code SSLEngine} instance from this context with the
     * specified hostname and port.
     *
     * @param peerHost
     *            the name of the host
     * @param peerPort
     *            the port
     * @return an {@code SSLEngine} instance from this context.
     * @throws UnsupportedOperationException
     *             if the provider does not support the operation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.972 -0500", hash_original_method = "4AC4A8F933626C577BD77D72E35BEF87", hash_generated_method = "9C470B5BCE90188A0832C29487E33A80")
    
public final SSLEngine createSSLEngine(String peerHost, int peerPort) {
        return spiImpl.engineCreateSSLEngine(peerHost, peerPort);
    }

    /**
     * Returns the SSL session context that encapsulates the set of SSL sessions
     * that can be used for handshake of server-side SSL sockets.
     *
     * @return the SSL server session context for this context or {@code null}
     *         if the underlying provider does not provide an implementation of
     *         the {@code SSLSessionContext} interface.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.975 -0500", hash_original_method = "13CFBFF97EBEA17DB24F1E636C863192", hash_generated_method = "DE6B68E8F154C129FD28449F1FBE3003")
    
public final SSLSessionContext getServerSessionContext() {
        return spiImpl.engineGetServerSessionContext();
    }

    /**
     * Returns the SSL session context that encapsulates the set of SSL sessions
     * that can be used for handshake of client-side SSL sockets.
     *
     * @return the SSL client session context for this context or {@code null}
     *         if the underlying provider does not provide an implementation of
     *         the {@code SSLSessionContext} interface.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.977 -0500", hash_original_method = "ECC6F07A2C60018ED286E62595778908", hash_generated_method = "A186EB06C2FF4FC0DB898AE584F21371")
    
public final SSLSessionContext getClientSessionContext() {
        return spiImpl.engineGetClientSessionContext();
    }

    /**
     * Returns the default SSL handshake parameters for SSLSockets
     * created by this SSLContext.
     *
     * @throws UnsupportedOperationException
     * @since 1.6
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.979 -0500", hash_original_method = "EF50F11BBBC92F54F2BB8CD8681E5FD1", hash_generated_method = "B9973F15E21F332D6EF816356C41E08A")
    
public final SSLParameters getDefaultSSLParameters() {
        return spiImpl.engineGetDefaultSSLParameters();
    }

    /**
     * Returns SSL handshake parameters for SSLSockets that includes
     * all supported cipher suites and protocols.
     *
     * @throws UnsupportedOperationException
     * @since 1.6
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.981 -0500", hash_original_method = "B61455860318644024B430BCDF123BB8", hash_generated_method = "C36A8CD37168C1EB898C2E0B1717444A")
    
public final SSLParameters getSupportedSSLParameters() {
        return spiImpl.engineGetSupportedSSLParameters();
    }
}

