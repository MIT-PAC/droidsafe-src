package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.EventObject;

import javax.security.cert.X509Certificate;






public class HandshakeCompletedEvent extends EventObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.691 -0500", hash_original_field = "F313759BDBF4B9277516E56C5D7DFEA3", hash_generated_field = "263AF05607311316518E2566C59FC14C")


    private transient SSLSession session;

    /**
     * Creates a new {@code HandshakeCompletedEvent} with the specified SSL
     * socket and SSL session.
     *
     * @param sock
     *            the SSL socket.
     * @param s
     *            the SSL session.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.694 -0500", hash_original_method = "49E2221C7C9E09C593B53C8D7CC4ED30", hash_generated_method = "3E009F112554F672821987086E176639")
    
public HandshakeCompletedEvent(SSLSocket sock, SSLSession s) {
        super(sock);
        session = s;
    }

    /**
     * Returns the SSL session associated with this event.
     *
     * @return the SSL session associated with this event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.696 -0500", hash_original_method = "2F35DBDDEE25D44180770FC68EA02FBF", hash_generated_method = "BD23FC6460B0B92CC62DD72D6181F539")
    
public SSLSession getSession() {
        return session;
    }

    /**
     * Returns the name of the cipher suite negotiated during this handshake.
     *
     * @return the name of the cipher suite negotiated during this handshake.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.698 -0500", hash_original_method = "AA50F870D8B0EDDAC30AA11C075FA460", hash_generated_method = "1E2316B36D9A675C7A1758C2B77C8D60")
    
public String getCipherSuite() {
        return session.getCipherSuite();
    }

    /**
     * Returns the list of local certificates used during the handshake. These
     * certificates were sent to the peer.
     *
     * @return Returns the list of certificates used during the handshake with
     *         the local identity certificate followed by CAs, or {@code null}
     *         if no certificates were used during the handshake.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.701 -0500", hash_original_method = "12F750698B4C5596A2F6F73DC7614702", hash_generated_method = "FEA58E2B2F18281695F91F43418F913F")
    
public Certificate[] getLocalCertificates() {
        return session.getLocalCertificates();
    }

    /**
     * Return the list of certificates identifying the peer during the
     * handshake.
     *
     * @return the list of certificates identifying the peer with the peer's
     *         identity certificate followed by CAs.
     * @throws SSLPeerUnverifiedException
     *             if the identity of the peer has not been verified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.703 -0500", hash_original_method = "4973BE3A4ED587D46EBF93135059669C", hash_generated_method = "97670E79A63F3CAA72BC4440460312FF")
    
public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        return session.getPeerCertificates();
    }

    /**
     * Returns the list of certificates identifying the peer. The peer's
     * identity certificate is followed by the validated certificate authority
     * certificates.
     * <p>
     * <b>Replaced by:</b> {@link #getPeerCertificates()}
     *
     * @return the list of certificates identifying the peer
     * @throws SSLPeerUnverifiedException
     *             if the identity of the peer has not been verified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.706 -0500", hash_original_method = "8A3AA58C9CA390E089E395D78527A15D", hash_generated_method = "A00D8369328A7F94E77615415D402AB0")
    
public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        return session.getPeerCertificateChain();
    }

    /**
     * Returns the {@code Principal} identifying the peer.
     *
     * @return the {@code Principal} identifying the peer.
     * @throws SSLPeerUnverifiedException
     *             if the identity of the peer has not been verified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.708 -0500", hash_original_method = "E52328DA42ED4C7658029875D0FD2A85", hash_generated_method = "E324F5EECAE3FF37E04A099278BAB1CF")
    
public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return session.getPeerPrincipal();
    }

    /**
     * Returns the {@code Principal} used to identify during the handshake.
     *
     * @return the {@code Principal} used to identify during the handshake.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.710 -0500", hash_original_method = "9AEFAC82D29E63E6CA9E21A60A8B85D0", hash_generated_method = "C8B4F8151B42CE0791579ACAFA97691F")
    
public Principal getLocalPrincipal() {
        return session.getLocalPrincipal();
    }

    /**
     * Returns the SSL socket that produced this event.
     *
     * @return the SSL socket that produced this event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.712 -0500", hash_original_method = "D59F011BF3B2DFBF72B84D897263E8E1", hash_generated_method = "BB47FC9AF47A846EBF1058E99ECDE85D")
    
public SSLSocket getSocket() {
        return (SSLSocket) this.source;
    }

    
}

