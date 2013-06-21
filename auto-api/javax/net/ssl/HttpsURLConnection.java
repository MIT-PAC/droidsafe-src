package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

public abstract class HttpsURLConnection extends HttpURLConnection {
    protected HostnameVerifier hostnameVerifier;
    private SSLSocketFactory sslSocketFactory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.056 -0400", hash_original_method = "3F2F2A4446750A53080925148675EF12", hash_generated_method = "C43666F24CDF3F67895D5D444AEB0B92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected HttpsURLConnection(URL url) {
        super(url);
        dsTaint.addTaint(url.dsTaint);
        hostnameVerifier = defaultHostnameVerifier;
        sslSocketFactory = defaultSSLSocketFactory;
        // ---------- Original Method ----------
        //hostnameVerifier = defaultHostnameVerifier;
        //sslSocketFactory = defaultSSLSocketFactory;
    }

    
        public static void setDefaultHostnameVerifier(HostnameVerifier v) {
        if (v == null) {
            throw new IllegalArgumentException("HostnameVerifier is null");
        }
        defaultHostnameVerifier = v;
    }

    
        public static HostnameVerifier getDefaultHostnameVerifier() {
        return defaultHostnameVerifier;
    }

    
        public static void setDefaultSSLSocketFactory(SSLSocketFactory sf) {
        if (sf == null) {
            throw new IllegalArgumentException("SSLSocketFactory is null");
        }
        defaultSSLSocketFactory = sf;
    }

    
        public static SSLSocketFactory getDefaultSSLSocketFactory() {
        return defaultSSLSocketFactory;
    }

    
    public abstract String getCipherSuite();

    
    public abstract Certificate[] getLocalCertificates();

    
    public abstract Certificate[] getServerCertificates() throws SSLPeerUnverifiedException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.057 -0400", hash_original_method = "3002E4037B6FC8FCCD4931764B6D5235", hash_generated_method = "AC9A17D5F0CF901ADF8A4261C17F605F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Certificate[] certs;
        certs = getServerCertificates();
        {
            if (DroidSafeAndroidRuntime.control) throw new SSLPeerUnverifiedException("No server's end-entity certificate");
        } //End block
        Principal var67F0402E96F39EA91AC695B84BDB56FE_450746102 = (((X509Certificate) certs[0]).getSubjectX500Principal());
        return (Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Certificate[] certs = getServerCertificates();
        //if (certs == null || certs.length == 0 || (!(certs[0] instanceof X509Certificate))) {
            //throw new SSLPeerUnverifiedException("No server's end-entity certificate");
        //}
        //return ((X509Certificate) certs[0]).getSubjectX500Principal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.057 -0400", hash_original_method = "F7626DF75E46EFB83E8F38373F84B563", hash_generated_method = "08FF514B87290EAAD2454257BB16EFF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Principal getLocalPrincipal() {
        Certificate[] certs;
        certs = getLocalCertificates();
        Principal var67F0402E96F39EA91AC695B84BDB56FE_1700699016 = (((X509Certificate) certs[0]).getSubjectX500Principal());
        return (Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Certificate[] certs = getLocalCertificates();
        //if (certs == null || certs.length == 0 || (!(certs[0] instanceof X509Certificate))) {
            //return null;
        //}
        //return ((X509Certificate) certs[0]).getSubjectX500Principal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.058 -0400", hash_original_method = "1F574C02EC6D9C57C280B3A1D2132BB4", hash_generated_method = "7D864229961F33386D5D9F5BC3E9D99D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHostnameVerifier(HostnameVerifier v) {
        dsTaint.addTaint(v.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HostnameVerifier is null");
        } //End block
        // ---------- Original Method ----------
        //if (v == null) {
            //throw new IllegalArgumentException("HostnameVerifier is null");
        //}
        //hostnameVerifier = v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.058 -0400", hash_original_method = "ECCA6A5C3EF4993C1CFD64A0404A993B", hash_generated_method = "4CEB07A14DE9CB3A49A19367BAA76E06")
    @DSModeled(DSC.SAFE)
    public HostnameVerifier getHostnameVerifier() {
        return (HostnameVerifier)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return hostnameVerifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.058 -0400", hash_original_method = "C38E7A94B75C24B6865C99F80CA80171", hash_generated_method = "2802B6B732C15CF027E0C3C99AFB8369")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSSLSocketFactory(SSLSocketFactory sf) {
        dsTaint.addTaint(sf.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("SSLSocketFactory is null");
        } //End block
        // ---------- Original Method ----------
        //if (sf == null) {
            //throw new IllegalArgumentException("SSLSocketFactory is null");
        //}
        //sslSocketFactory = sf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.058 -0400", hash_original_method = "9F872E117F4FD1E88D0B5BA15C4E96B2", hash_generated_method = "1936A060975984BC0034CAA0B3AC9E99")
    @DSModeled(DSC.SAFE)
    public SSLSocketFactory getSSLSocketFactory() {
        return (SSLSocketFactory)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sslSocketFactory;
    }

    
    private static HostnameVerifier defaultHostnameVerifier = new DefaultHostnameVerifier();
    private static SSLSocketFactory defaultSSLSocketFactory = (SSLSocketFactory) SSLSocketFactory
            .getDefault();
}

