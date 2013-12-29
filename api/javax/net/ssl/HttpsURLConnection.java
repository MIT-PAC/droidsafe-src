package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;






public abstract class HttpsURLConnection extends HttpURLConnection {

    /**
     * Sets the default hostname verifier to be used by new instances.
     *
     * @param v
     *            the new default hostname verifier
     * @throws IllegalArgumentException
     *             if the specified verifier is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.471 -0500", hash_original_method = "DEB2C9A710B956993610B73507EBE078", hash_generated_method = "AF1CEFF614018030A537BBB2129AB7EA")
    public static void setDefaultHostnameVerifier(HostnameVerifier v) {
        if (v == null) {
            throw new IllegalArgumentException("HostnameVerifier is null");
        }
        defaultHostnameVerifier = v;
    }

    /**
     * Returns the default hostname verifier.
     *
     * @return the default hostname verifier.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.472 -0500", hash_original_method = "9773880A22E0FF5FEB0CB3C2DD62EB7C", hash_generated_method = "EF086D70565AD9528DCD5271EDDF2CB1")
    public static HostnameVerifier getDefaultHostnameVerifier() {
        return defaultHostnameVerifier;
    }

    /**
     * Sets the default SSL socket factory to be used by new instances.
     *
     * @param sf
     *            the new default SSL socket factory.
     * @throws IllegalArgumentException
     *             if the specified socket factory is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.473 -0500", hash_original_method = "EFDB8266FB2814EDEF25ADC912C0CEEC", hash_generated_method = "C55CACD3EDCA97BB731F9A61C5F09D86")
    public static void setDefaultSSLSocketFactory(SSLSocketFactory sf) {
        if (sf == null) {
            throw new IllegalArgumentException("SSLSocketFactory is null");
        }
        defaultSSLSocketFactory = sf;
    }

    /**
     * Returns the default SSL socket factory for new instances.
     *
     * @return the default SSL socket factory for new instances.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.474 -0500", hash_original_method = "0C4AC921BD810A2538DD22B55DBA6FF8", hash_generated_method = "53164AF3D676979B296AA9010EFA1DCF")
    public static SSLSocketFactory getDefaultSSLSocketFactory() {
        return defaultSSLSocketFactory;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.469 -0500", hash_original_field = "0368DF931E21EFF8B8EA339956928A43", hash_generated_field = "7D4EC90B6C0CC97A49BDB74C867F8D18")


    private static HostnameVerifier defaultHostnameVerifier = new DefaultHostnameVerifier();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.471 -0500", hash_original_field = "50856B5A89398D7A4AAC40329DA7CE25", hash_generated_field = "E0EF4240F4797BAB1451A0AF02E6DCCF")


    private static SSLSocketFactory defaultSSLSocketFactory = (SSLSocketFactory) SSLSocketFactory
            .getDefault();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.474 -0500", hash_original_field = "8DBD41A9EFA261151C8C68B985638A9E", hash_generated_field = "936CC44C0D1FD42DECA40078C5783214")

    protected HostnameVerifier hostnameVerifier;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.475 -0500", hash_original_field = "873903B7FC49F40C02995A48B85609AA", hash_generated_field = "87C1504631DE52B6388145B4A5898443")


    private SSLSocketFactory sslSocketFactory;

    /**
     * Creates a new {@code HttpsURLConnection} with the specified {@code URL}.
     *
     * @param url
     *            the {@code URL} to connect to.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.476 -0500", hash_original_method = "3F2F2A4446750A53080925148675EF12", hash_generated_method = "478F557ABDAE482993592AB5A62D14F3")
    protected HttpsURLConnection(URL url) {
        super(url);
        hostnameVerifier = defaultHostnameVerifier;
        sslSocketFactory = defaultSSLSocketFactory;
    }

    /**
     * Returns the name of the cipher suite negotiated during the SSL handshake.
     *
     * @return the name of the cipher suite negotiated during the SSL handshake.
     * @throws IllegalStateException
     *             if no connection has been established yet.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.477 -0500", hash_original_method = "DC3C51A13960575CAB20927262CC1EAA", hash_generated_method = "50C779AE7D838B9AD10E9CAAE28CA039")
    public abstract String getCipherSuite();

    /**
     * Returns the list of local certificates used during the handshake. These
     * certificates were sent to the peer.
     *
     * @return Returns the list of certificates used during the handshake with
     *         the local identity certificate followed by CAs, or {@code null}
     *         if no certificates were used during the handshake.
     * @throws IllegalStateException
     *             if no connection has been established yet.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.478 -0500", hash_original_method = "44A6CFE353402A844F9D937F26ED2AEF", hash_generated_method = "8F9BF5AF8A973454C61F8FD9C2DAB4E8")
    public abstract Certificate[] getLocalCertificates();

    /**
     * Return the list of certificates identifying the peer during the
     * handshake.
     *
     * @return the list of certificates identifying the peer with the peer's
     *         identity certificate followed by CAs.
     * @throws SSLPeerUnverifiedException
     *             if the identity of the peer has not been verified..
     * @throws IllegalStateException
     *             if no connection has been established yet.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.478 -0500", hash_original_method = "5D32B7D80ABF052EA613BA06BE978B0C", hash_generated_method = "8094CF2CD1CE41340713B07DDF22450E")
    public abstract Certificate[] getServerCertificates() throws SSLPeerUnverifiedException;

    /**
     * Returns the {@code Principal} identifying the peer.
     *
     * @return the {@code Principal} identifying the peer.
     * @throws SSLPeerUnverifiedException
     *             if the identity of the peer has not been verified.
     * @throws IllegalStateException
     *             if no connection has been established yet.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.479 -0500", hash_original_method = "3002E4037B6FC8FCCD4931764B6D5235", hash_generated_method = "7BE5E2E075ECE16B006FC69EB7F43891")
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Certificate[] certs = getServerCertificates();
        if (certs == null || certs.length == 0 || (!(certs[0] instanceof X509Certificate))) {
            throw new SSLPeerUnverifiedException("No server's end-entity certificate");
        }
        return ((X509Certificate) certs[0]).getSubjectX500Principal();
    }

    /**
     * Returns the {@code Principal} used to identify the local host during the handshake.
     *
     * @return the {@code Principal} used to identify the local host during the handshake, or
     *         {@code null} if none was used.
     * @throws IllegalStateException
     *             if no connection has been established yet.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.480 -0500", hash_original_method = "F7626DF75E46EFB83E8F38373F84B563", hash_generated_method = "FE654D242EC3115C1E96C637F477F508")
    public Principal getLocalPrincipal() {
        Certificate[] certs = getLocalCertificates();
        if (certs == null || certs.length == 0 || (!(certs[0] instanceof X509Certificate))) {
            return null;
        }
        return ((X509Certificate) certs[0]).getSubjectX500Principal();
    }

    /**
     * Sets the hostname verifier for this instance.
     *
     * @param v
     *            the hostname verifier for this instance.
     * @throws IllegalArgumentException
     *             if the specified verifier is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.481 -0500", hash_original_method = "1F574C02EC6D9C57C280B3A1D2132BB4", hash_generated_method = "61018AD90FC1E46333991E1A32EC44E5")
    public void setHostnameVerifier(HostnameVerifier v) {
        if (v == null) {
            throw new IllegalArgumentException("HostnameVerifier is null");
        }
        hostnameVerifier = v;
    }

    /**
     * Returns the hostname verifier used by this instance.
     *
     * @return the hostname verifier used by this instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.481 -0500", hash_original_method = "ECCA6A5C3EF4993C1CFD64A0404A993B", hash_generated_method = "B8A5A4F3990265E819A337A7913404A0")
    public HostnameVerifier getHostnameVerifier() {
        return hostnameVerifier;
    }

    /**
     * Sets the SSL socket factory for this instance.
     *
     * @param sf
     *            the SSL socket factory to be used by this instance.
     * @throws IllegalArgumentException
     *             if the specified socket factory is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.482 -0500", hash_original_method = "C38E7A94B75C24B6865C99F80CA80171", hash_generated_method = "99EAC1F9578B8B4C14F2A6E108BD6E47")
    public void setSSLSocketFactory(SSLSocketFactory sf) {
        if (sf == null) {
            throw new IllegalArgumentException("SSLSocketFactory is null");
        }
        sslSocketFactory = sf;
    }

    /**
     * Returns the SSL socket factory used by this instance.
     *
     * @return the SSL socket factory used by this instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.483 -0500", hash_original_method = "9F872E117F4FD1E88D0B5BA15C4E96B2", hash_generated_method = "61398E1F9DEC81EB60CD942D4C5C21F7")
    public SSLSocketFactory getSSLSocketFactory() {
        return sslSocketFactory;
    }
}

