package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionBindingEvent;
import javax.net.ssl.SSLSessionBindingListener;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.CertificateException;

public class OpenSSLSessionImpl implements SSLSession {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.097 -0500", hash_original_field = "A41A922D630409E60FE006B46592FFB7", hash_generated_field = "269D1908AAA6996EA79A385B96B8D46B")

    private long creationTime = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.099 -0500", hash_original_field = "CA76B0FD881476C838923B95EAFEFA21", hash_generated_field = "CA76B0FD881476C838923B95EAFEFA21")

    long lastAccessedTime = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.101 -0500", hash_original_field = "32A66D390E195F822A847B8B4CE21F22", hash_generated_field = "32A66D390E195F822A847B8B4CE21F22")

     X509Certificate[] localCertificates;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.103 -0500", hash_original_field = "C26B9ED4C7D0355EF58C50C7FCD5DD79", hash_generated_field = "C26B9ED4C7D0355EF58C50C7FCD5DD79")

     X509Certificate[] peerCertificates;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.106 -0500", hash_original_field = "FFFCC50D3A278EF95DEB022E99DE2B21", hash_generated_field = "5738630542C71F34716CA340A1982FCB")

    private boolean isValid = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.109 -0500", hash_original_field = "5572873E708318B5BCB1211CAFB42224", hash_generated_field = "9D0FE98D3FB5DD14BD6D5D1B013768C8")

    private final Map<String, Object> values = new HashMap<String, Object>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.111 -0500", hash_original_field = "72F58174D07CA827E673CCF7A48A456F", hash_generated_field = "CA10727E3B6C4E28BA2DC6C0BB046AB5")

    private volatile javax.security.cert.X509Certificate[] peerCertificateChain;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.113 -0500", hash_original_field = "AFBA487E3552449FC6E9C6F16D545534", hash_generated_field = "B359FFDC454F9BD60DB6759BAEDB0FBE")

    protected int sslSessionNativePointer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.115 -0500", hash_original_field = "C33A347C63CF676DBDFD0CCC029E433E", hash_generated_field = "871B4093DF845204CC93E22B63A3EB07")

    private String peerHost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.117 -0500", hash_original_field = "B3622AB429836A8D09D8B344FA643F7F", hash_generated_field = "95590212F4127D0DA83F9732C159832A")

    private int peerPort = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.119 -0500", hash_original_field = "29E2AAA661609AB9806905F1C2C48A95", hash_generated_field = "2B93F4D04C330EE5C6289BC73BF497CE")

    private String cipherSuite;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.121 -0500", hash_original_field = "DE3F28962485CE99CA97D0A480B93596", hash_generated_field = "512C13BA7A4120A610964F395EA31E91")

    private String protocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.123 -0500", hash_original_field = "E9BC9787BE0291444EC41657CFEA571C", hash_generated_field = "60FA26833155E846A9CFC6F83676739D")

    private String compressionMethod;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.126 -0500", hash_original_field = "16B65D9ABEC541D9357431299FAA3C81", hash_generated_field = "4CFE5CBF57F2F36BBD15DF349B9E7672")

    private AbstractSessionContext sessionContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.128 -0500", hash_original_field = "90A5D328FD00C6FE5EBB6109B912317E", hash_generated_field = "8E7258E790097F4AD5ED2D02B17E7B9A")

    private byte[] id;

    /**
     * Class constructor creates an SSL session context given the appropriate
     * SSL parameters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.131 -0500", hash_original_method = "1D97F06EBCB0CC7BB7E5B60E8D275DC2", hash_generated_method = "349E4F539865688355EE47EBC2447E65")
    
protected OpenSSLSessionImpl(int sslSessionNativePointer, X509Certificate[] localCertificates,
            X509Certificate[] peerCertificates, String peerHost, int peerPort,
            AbstractSessionContext sessionContext) {
        this.sslSessionNativePointer = sslSessionNativePointer;
        this.localCertificates = localCertificates;
        this.peerCertificates = peerCertificates;
        this.peerHost = peerHost;
        this.peerPort = peerPort;
        this.sessionContext = sessionContext;
    }

    /**
     * Constructs a session from a byte[] containing DER data. This
     * allows loading the saved session.
     * @throws IOException
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.133 -0500", hash_original_method = "ECC374A16FFF293E37020E85B391DB03", hash_generated_method = "780E8B5B055F68B079A55AA39CDAE638")
    
OpenSSLSessionImpl(byte[] derData,
            String peerHost, int peerPort,
            X509Certificate[] peerCertificates,
            AbstractSessionContext sessionContext)
            throws IOException {
        this(NativeCrypto.d2i_SSL_SESSION(derData),
             null,
             peerCertificates,
             peerHost,
             peerPort,
             sessionContext);
        // TODO move this check into native code so we can throw an error with more information
        if (this.sslSessionNativePointer == 0) {
            throw new IOException("Invalid session data");
        }
    }

    /**
     * Gets the identifier of the actual SSL session
     * @return array of sessions' identifiers.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.136 -0500", hash_original_method = "566A3E7ED91C5CA2BC21AC127756388D", hash_generated_method = "26B0B0EF0B597894436E2479D0935A94")
    
public byte[] getId() {
        if (id == null) {
            resetId();
        }
        return id;
    }

    /**
     * Reset the id field to the current value found in the native
     * SSL_SESSION. It can change during the lifetime of the session
     * because while a session is created during initial handshake,
     * with handshake_cutthrough, the SSL_do_handshake may return
     * before we have read the session ticket from the server side and
     * therefore have computed no id based on the SHA of the ticket.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.138 -0500", hash_original_method = "57B02BE93AE841112E3F3B64D0EF8580", hash_generated_method = "57B02BE93AE841112E3F3B64D0EF8580")
    
void resetId() {
        id = NativeCrypto.SSL_SESSION_session_id(sslSessionNativePointer);
    }

    /**
     * Get the session object in DER format. This allows saving the session
     * data or sharing it with other processes.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.140 -0500", hash_original_method = "6E61934F3054764656AF5E19BA5296B9", hash_generated_method = "6E61934F3054764656AF5E19BA5296B9")
    
byte[] getEncoded() {
        return NativeCrypto.i2d_SSL_SESSION(sslSessionNativePointer);
    }

    /**
     * Gets the creation time of the SSL session.
     * @return the session's creation time in milliseconds since the epoch
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.142 -0500", hash_original_method = "A19FB54083053630467ACC70727A9F00", hash_generated_method = "2E7F9619FB87FAC8711C48EA1DB83A85")
    
public long getCreationTime() {
        if (creationTime == 0) {
            creationTime = NativeCrypto.SSL_SESSION_get_time(sslSessionNativePointer);
        }
        return creationTime;
    }

    /**
     * Returns the last time this concrete SSL session was accessed. Accessing
     * here is to mean that a new connection with the same SSL context data was
     * established.
     *
     * @return the session's last access time in milliseconds since the epoch
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.144 -0500", hash_original_method = "D25DBFE273F16B7B3F4524AEB4575158", hash_generated_method = "886740B010A1EA526B6065DA8F34EB19")
    
public long getLastAccessedTime() {
        return (lastAccessedTime == 0) ? getCreationTime() : lastAccessedTime;
    }

    /**
     * Returns the largest buffer size for the application's data bound to this
     * concrete SSL session.
     * @return the largest buffer size
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.146 -0500", hash_original_method = "A8B8393BBD8B21276043F8F436BCE41F", hash_generated_method = "E81B1F1B3E4F15AAEFD04FB4DC689CD7")
    
public int getApplicationBufferSize() {
        return SSLRecordProtocol.MAX_DATA_LENGTH;
    }

    /**
     * Returns the largest SSL/TLS packet size one can expect for this concrete
     * SSL session.
     * @return the largest packet size
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.148 -0500", hash_original_method = "D48FD6D531D6586277314A5CB11C610B", hash_generated_method = "49066EE1ED41F2667BDAEB4A3668CF26")
    
public int getPacketBufferSize() {
        return SSLRecordProtocol.MAX_SSL_PACKET_SIZE;
    }

    /**
     * Returns the principal (subject) of this concrete SSL session used in the
     * handshaking phase of the connection.
     * @return a X509 certificate or null if no principal was defined
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.152 -0500", hash_original_method = "FC218F5482EE1068025787BA631F1A11", hash_generated_method = "4E55611D3B687672122D9CE0CB3A3B55")
    
public Principal getLocalPrincipal() {
        if (localCertificates != null && localCertificates.length > 0) {
            return localCertificates[0].getSubjectX500Principal();
        } else {
            return null;
        }
    }

    /**
     * Returns the certificate(s) of the principal (subject) of this concrete SSL
     * session used in the handshaking phase of the connection. The OpenSSL
     * native method supports only RSA certificates.
     * @return an array of certificates (the local one first and then eventually
     *         that of the certification authority) or null if no certificate
     *         were used during the handshaking phase.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.154 -0500", hash_original_method = "00176E7E524F828990985588910F48EC", hash_generated_method = "DCB7B96357BAC93BE08BBFECA9CC1109")
    
public Certificate[] getLocalCertificates() {
        return localCertificates;
    }

    /**
     * Returns the certificate(s) of the peer in this SSL session
     * used in the handshaking phase of the connection.
     * Please notice hat this method is superseded by
     * <code>getPeerCertificates()</code>.
     * @return an array of X509 certificates (the peer's one first and then
     *         eventually that of the certification authority) or null if no
     *         certificate were used during the SSL connection.
     * @throws <code>SSLPeerUnverifiedCertificateException</code> if either a
     *         not X509 certificate was used (i.e. Kerberos certificates) or the
     *         peer could not be verified.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.156 -0500", hash_original_method = "74B59F5E567633033E420B2FD20F7EA9", hash_generated_method = "6D4DE2EB8A7302922C9FB831C62D1F5D")
    
public javax.security.cert.X509Certificate[] getPeerCertificateChain()
            throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
        javax.security.cert.X509Certificate[] result = peerCertificateChain;
        if (result == null) {
            // single-check idiom
            peerCertificateChain = result = createPeerCertificateChain();
        }
        return result;
    }

    /**
     * Provide a value to initialize the volatile peerCertificateChain
     * field based on the native SSL_SESSION
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.158 -0500", hash_original_method = "95455CDE829A27B48DAF238C4403FA5A", hash_generated_method = "A8390121371D7D9D59758E1993A98F69")
    
private javax.security.cert.X509Certificate[] createPeerCertificateChain()
            throws SSLPeerUnverifiedException {
        try {
            javax.security.cert.X509Certificate[] chain
                    = new javax.security.cert.X509Certificate[peerCertificates.length];

            for (int i = 0; i < peerCertificates.length; i++) {
                byte[] encoded = peerCertificates[i].getEncoded();
                chain[i] = javax.security.cert.X509Certificate.getInstance(encoded);
            }
            return chain;
        } catch (CertificateEncodingException e) {
            SSLPeerUnverifiedException exception = new SSLPeerUnverifiedException(e.getMessage());
            exception.initCause(exception);
            throw exception;
        } catch (CertificateException e) {
            SSLPeerUnverifiedException exception = new SSLPeerUnverifiedException(e.getMessage());
            exception.initCause(exception);
            throw exception;
        }
    }

    /**
     * Return the identity of the peer in this SSL session
     * determined via certificate(s).
     * @return an array of X509 certificates (the peer's one first and then
     *         eventually that of the certification authority) or null if no
     *         certificate were used during the SSL connection.
     * @throws <code>SSLPeerUnverifiedException</code> if either a not X509
     *         certificate was used (i.e. Kerberos certificates) or the peer
     *         could not be verified.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.160 -0500", hash_original_method = "6F2F2196C2B5F66BDE334D0180ADBF68", hash_generated_method = "21E343A0D6E32590DDC3668CEB850696")
    
public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
        return peerCertificates;
    }

    /**
     * Throw SSLPeerUnverifiedException on null or empty peerCertificates array
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.162 -0500", hash_original_method = "4A7519F376EC7B19E89A23705C5BAAD6", hash_generated_method = "709FF115FFE9F07757B4CC928089959E")
    
private void checkPeerCertificatesPresent() throws SSLPeerUnverifiedException {
        if (peerCertificates == null || peerCertificates.length == 0) {
            throw new SSLPeerUnverifiedException("No peer certificates");
        }
    }

    /**
     * The identity of the principal that was used by the peer during the SSL
     * handshake phase is returned by this method.
     * @return a X500Principal of the last certificate for X509-based
     *         cipher suites.
     * @throws <code>SSLPeerUnverifiedException</code> if either a not X509
     *         certificate was used (i.e. Kerberos certificates) or the
     *         peer does not exist.
     *
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.164 -0500", hash_original_method = "14CCB3DBB8312C280BE97228D3117477", hash_generated_method = "91DA70C589B456D7FC949C206DA98454")
    
public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
        return peerCertificates[0].getSubjectX500Principal();
    }

    /**
     * The peer's host name used in this SSL session is returned. It is the host
     * name of the client for the server; and that of the server for the client.
     * It is not a reliable way to get a fully qualified host name: it is mainly
     * used internally to implement links for a temporary cache of SSL sessions.
     *
     * @return the host name of the peer, or null if no information is
     *         available.
     *
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.167 -0500", hash_original_method = "686621F471AF14AF505B60419214318E", hash_generated_method = "B884ECED502456841527EC5FB85A2015")
    
public String getPeerHost() {
        return peerHost;
    }

    /**
     * Returns the peer's port number for the actual SSL session. It is the port
     * number of the client for the server; and that of the server for the
     * client. It is not a reliable way to get a peer's port number: it is
     * mainly used internally to implement links for a temporary cache of SSL
     * sessions.
     * @return the peer's port number, or -1 if no one is available.
     *
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.169 -0500", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "0A13911FE5FD34A377B4DEB23C492969")
    
public int getPeerPort() {
        return peerPort;
    }

    /**
     * Returns a string identifier of the crypto tools used in the actual SSL
     * session. For example AES_256_WITH_MD5.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.172 -0500", hash_original_method = "232543257EF0615A8C98189B2944DDF8", hash_generated_method = "83D45C5CF4C5B2FEFCEDBA393368F36A")
    
public String getCipherSuite() {
        if (cipherSuite == null) {
            String name = NativeCrypto.SSL_SESSION_cipher(sslSessionNativePointer);
            cipherSuite = NativeCrypto.OPENSSL_TO_STANDARD_CIPHER_SUITES.get(name);
            if (cipherSuite == null) {
                cipherSuite = name;
            }
        }
        return cipherSuite;
    }

    /**
     * Returns the standard version name of the SSL protocol used in all
     * connections pertaining to this SSL session.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.174 -0500", hash_original_method = "DC690D466354C337179157E9ED46DB27", hash_generated_method = "5A8F6C2178CF578AFF458D8EE38B254A")
    
public String getProtocol() {
        if (protocol == null) {
            protocol = NativeCrypto.SSL_SESSION_get_version(sslSessionNativePointer);
        }
        return protocol;
    }

    /**
     * Returns the compression method name used in all connections
     * pertaining to this SSL session.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.176 -0500", hash_original_method = "968671DF82E2AA12BC31F552097867FE", hash_generated_method = "8BF24F4111408B0E6581E2664F47A96B")
    
public String getCompressionMethod() {
        if (compressionMethod == null) {
            compressionMethod
                    = NativeCrypto.SSL_SESSION_compress_meth(sessionContext.sslCtxNativePointer,
                                                             sslSessionNativePointer);
        }
        return compressionMethod;
    }

    /**
     * Returns the context to which the actual SSL session is bound. A SSL
     * context consists of (1) a possible delegate, (2) a provider and (3) a
     * protocol.
     * @return the SSL context used for this session, or null if it is
     * unavailable.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.178 -0500", hash_original_method = "6C1FB28F6F59303D04A80E546963567A", hash_generated_method = "DD74B7C633C3A408143E85D4C6827B68")
    
public SSLSessionContext getSessionContext() {
        return sessionContext;
    }

    /**
     * Returns a boolean flag signaling whether a SSL session is valid
     * and available for resuming or joining or not.
     *
     * @return true if this session may be resumed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.180 -0500", hash_original_method = "8D23F85B43098BFBC0CC2E7E59C1A10A", hash_generated_method = "8AE753C071FF8E0D201DD8A4B290FA3D")
    
public boolean isValid() {
        SSLSessionContext context = sessionContext;
        if (isValid
                && context != null
                && context.getSessionTimeout() != 0
                && getCreationTime() + (context.getSessionTimeout() * 1000)
                    < System.currentTimeMillis()) {
            isValid = false;
        }
        return isValid;
    }

    /**
     * It invalidates a SSL session forbidding any resumption.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.183 -0500", hash_original_method = "9CCB74C876B98AB8C259B415A5496084", hash_generated_method = "C9DBF3B4EDCAC34471E10F51BA381E6E")
    
public void invalidate() {
        isValid = false;
        sessionContext = null;
    }

    /**
     * Returns the object which is bound to the the input parameter name.
     * This name is a sort of link to the data of the SSL session's application
     * layer, if any exists. The search for this link is monitored, as a matter
     * of security, by the full machinery of the <code>AccessController</code>
     * class.
     *
     * @param name the name of the binding to find.
     * @return the value bound to that name, or null if the binding does not
     *         exist.
     * @throws <code>IllegalArgumentException</code> if the argument is null.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.185 -0500", hash_original_method = "AC1FF55FABC34CC9974A294171A954DF", hash_generated_method = "482A1EBBD4ADC2D29BC2576BF219C8BF")
    
public Object getValue(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name == null");
        }
        return values.get(name);
    }

    /**
     * Returns an array with the names (sort of links) of all the data
     * objects of the application layer bound into the SSL session. The search
     * for this link is monitored, as a matter of security, by the full
     * machinery of the <code>AccessController</code> class.
     *
     * @return a non-null (possibly empty) array of names of the data objects
     *         bound to this SSL session.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.188 -0500", hash_original_method = "94A4765ACA5D7A784EB5749EBA86107C", hash_generated_method = "212BEDE870CA0A8C4B9BA72912F392CA")
    
public String[] getValueNames() {
        return values.keySet().toArray(new String[values.size()]);
    }

    /**
     * A link (name) with the specified value object of the SSL session's
     * application layer data is created or replaced. If the new (or existing)
     * value object implements the <code>SSLSessionBindingListener</code>
     * interface, that object will be notified in due course. These links-to
     * -data bounds are monitored, as a matter of security, by the full
     * machinery of the <code>AccessController</code> class.
     *
     * @param name the name of the link (no null are
     *            accepted!)
     * @param value data object that shall be bound to
     *            name.
     * @throws <code>IllegalArgumentException</code> if one or both
     *             argument(s) is null.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.190 -0500", hash_original_method = "306FE04DD14403034511108312788846", hash_generated_method = "3D28D4DAA15DA59E1E198C43B216F883")
    
public void putValue(String name, Object value) {
        if (name == null || value == null) {
            throw new IllegalArgumentException("name == null || value == null");
        }
        Object old = values.put(name, value);
        if (value instanceof SSLSessionBindingListener) {
            ((SSLSessionBindingListener) value)
                    .valueBound(new SSLSessionBindingEvent(this, name));
        }
        if (old instanceof SSLSessionBindingListener) {
            ((SSLSessionBindingListener) old)
                    .valueUnbound(new SSLSessionBindingEvent(this, name));
        }
    }

    /**
     * Removes a link (name) with the specified value object of the SSL
     * session's application layer data.
     *
     * <p>If the value object implements the <code>SSLSessionBindingListener</code>
     * interface, the object will receive a <code>valueUnbound</code> notification.
     *
     * <p>These links-to -data bounds are
     * monitored, as a matter of security, by the full machinery of the
     * <code>AccessController</code> class.
     *
     * @param name the name of the link (no null are
     *            accepted!)
     * @throws <code>IllegalArgumentException</code> if the argument is null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.193 -0500", hash_original_method = "EC2DC464BD3BB987F4ACA997202AA983", hash_generated_method = "C1F063A87C38C41A8C0646FAC8DC1A82")
    
public void removeValue(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name == null");
        }
        Object old = values.remove(name);
        if (old instanceof SSLSessionBindingListener) {
            SSLSessionBindingListener listener = (SSLSessionBindingListener) old;
            listener.valueUnbound(new SSLSessionBindingEvent(this, name));
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.195 -0500", hash_original_method = "1A939A31B27FEC68DC8C26996575F0FB", hash_generated_method = "FFE7A66666FEE0B5D7AE4F33A403162C")
    
@Override protected void finalize() throws Throwable {
        try {
            NativeCrypto.SSL_SESSION_free(sslSessionNativePointer);
        } finally {
            super.finalize();
        }
    }
    
}

