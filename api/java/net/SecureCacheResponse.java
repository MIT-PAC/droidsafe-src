package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;

import javax.net.ssl.SSLPeerUnverifiedException;

public abstract class SecureCacheResponse extends CacheResponse {

    /**
     * Creates a new instance of this class.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.203 -0500", hash_original_method = "2B60842F322CE42A5832F1BBB0BB3BBC", hash_generated_method = "E876B20AB059AEB79D3226BCAAD496CE")
    
public SecureCacheResponse() {
    }

    /**
     * Gets the cipher suite string on the connection which is originally used
     * to retrieve the network resource.
     *
     * @return the cipher suite string.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.206 -0500", hash_original_method = "DC3C51A13960575CAB20927262CC1EAA", hash_generated_method = "50C779AE7D838B9AD10E9CAAE28CA039")
    
public abstract String getCipherSuite();

    /**
     * Gets the local certificate chain. When the original connection retrieved
     * the resource data, this certificate chain was sent to the server during
     * handshaking process. This method only takes effect when certificate-based
     * cipher suite is enabled.
     *
     * @return the certificate chain that was sent to the server. If no
     *         certificate chain was sent, the method returns {@code null}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.208 -0500", hash_original_method = "311741B527CA4F39B9234C34CC3B7AFA", hash_generated_method = "35CDD61FFEE644BD96FBAF38B7C31B43")
    
public abstract List<Certificate> getLocalCertificateChain();

    /**
     * Gets the cached server's certificate chain. As part of defining the
     * session, the certificate chain was established when the original
     * connection retrieved network resource. This method can only be invoked
     * when certificated-based cipher suite is enabled. Otherwise, it throws an
     * {@code SSLPeerUnverifiedException}.
     *
     * @return the server's certificate chain.
     * @throws SSLPeerUnverifiedException
     *             if the peer is unverified.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.211 -0500", hash_original_method = "2C182CC104B6AF3A29CD53DD7A3A838C", hash_generated_method = "7467D79C70A3C6272623BFA28341E174")
    
public abstract List<Certificate> getServerCertificateChain()
            throws SSLPeerUnverifiedException;

    /**
     * Gets the server's principle. When the original connection retrieved
     * network resource, the principle was established when defining the
     * session.
     *
     * @return a principal object representing the server's principal.
     * @throws SSLPeerUnverifiedException
     *             if the peer is unverified.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.213 -0500", hash_original_method = "39836869B57D2BC0F61D16AFD90892A8", hash_generated_method = "76C69168B4B18454351FC53F4D26CA31")
    
public abstract Principal getPeerPrincipal()
            throws SSLPeerUnverifiedException;

    /**
     * Gets the local principle that the original connection sent to the server.
     * When the original connection fetched the network resource, the principle
     * was sent to the server during handshaking process.
     *
     * @return the local principal object being sent to the server. Returns an
     *         {@code X500Principal} object for X509-based cipher suites. If no
     *         principal was sent, it returns {@code null}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.216 -0500", hash_original_method = "9FFB2B18A70F76C4BCA9E2857CB5AD56", hash_generated_method = "D713221E2623AC23872545FE17F85951")
    
public abstract Principal getLocalPrincipal();
    
}

