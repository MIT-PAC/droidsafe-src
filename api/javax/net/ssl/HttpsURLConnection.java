package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

public abstract class HttpsURLConnection extends HttpURLConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.780 -0400", hash_original_field = "1DE571710ADB23614453BCCE654FE27E", hash_generated_field = "936CC44C0D1FD42DECA40078C5783214")

    protected HostnameVerifier hostnameVerifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.780 -0400", hash_original_field = "6B7BCFA2A69C0983F4EE1C29CDD1407B", hash_generated_field = "87C1504631DE52B6388145B4A5898443")

    private SSLSocketFactory sslSocketFactory;
    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.781 -0400", hash_original_method = "3F2F2A4446750A53080925148675EF12", hash_generated_method = "21E52D30BDA62739F7F2DD6E81A4893B")
    protected  HttpsURLConnection(URL url) {
        super(url);
        addTaint(url.getTaint());
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

    
        @DSModeled(DSC.SAFE)
    public static HostnameVerifier getDefaultHostnameVerifier() {
        return defaultHostnameVerifier;
    }

    
        public static void setDefaultSSLSocketFactory(SSLSocketFactory sf) {
        if (sf == null) {
            throw new IllegalArgumentException("SSLSocketFactory is null");
        }
        defaultSSLSocketFactory = sf;
    }

    
        @DSModeled(DSC.SAFE)
    public static SSLSocketFactory getDefaultSSLSocketFactory() {
        return defaultSSLSocketFactory;
    }

    
    public abstract String getCipherSuite();

    
    public abstract Certificate[] getLocalCertificates();

    
    public abstract Certificate[] getServerCertificates() throws SSLPeerUnverifiedException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.784 -0400", hash_original_method = "3002E4037B6FC8FCCD4931764B6D5235", hash_generated_method = "CEE58151E9F950377F2E27E62A295760")
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Certificate[] certs = getServerCertificates();
    if(certs == null || certs.length == 0 || (!(certs[0] instanceof X509Certificate)))        
        {
            SSLPeerUnverifiedException varD3195D7F54F11045BC8391D91CCFE912_32335119 = new SSLPeerUnverifiedException("No server's end-entity certificate");
            varD3195D7F54F11045BC8391D91CCFE912_32335119.addTaint(taint);
            throw varD3195D7F54F11045BC8391D91CCFE912_32335119;
        } //End block
Principal var9CF5ED47C051D95405EF759AB6EBE375_2098885524 =         ((X509Certificate) certs[0]).getSubjectX500Principal();
        var9CF5ED47C051D95405EF759AB6EBE375_2098885524.addTaint(taint);
        return var9CF5ED47C051D95405EF759AB6EBE375_2098885524;
        // ---------- Original Method ----------
        //Certificate[] certs = getServerCertificates();
        //if (certs == null || certs.length == 0 || (!(certs[0] instanceof X509Certificate))) {
            //throw new SSLPeerUnverifiedException("No server's end-entity certificate");
        //}
        //return ((X509Certificate) certs[0]).getSubjectX500Principal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.784 -0400", hash_original_method = "F7626DF75E46EFB83E8F38373F84B563", hash_generated_method = "121F278AF51592D3546F71132267C6B1")
    public Principal getLocalPrincipal() {
        Certificate[] certs = getLocalCertificates();
    if(certs == null || certs.length == 0 || (!(certs[0] instanceof X509Certificate)))        
        {
Principal var540C13E9E156B687226421B24F2DF178_1709199498 =             null;
            var540C13E9E156B687226421B24F2DF178_1709199498.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1709199498;
        } //End block
Principal var9CF5ED47C051D95405EF759AB6EBE375_1359374409 =         ((X509Certificate) certs[0]).getSubjectX500Principal();
        var9CF5ED47C051D95405EF759AB6EBE375_1359374409.addTaint(taint);
        return var9CF5ED47C051D95405EF759AB6EBE375_1359374409;
        // ---------- Original Method ----------
        //Certificate[] certs = getLocalCertificates();
        //if (certs == null || certs.length == 0 || (!(certs[0] instanceof X509Certificate))) {
            //return null;
        //}
        //return ((X509Certificate) certs[0]).getSubjectX500Principal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.785 -0400", hash_original_method = "1F574C02EC6D9C57C280B3A1D2132BB4", hash_generated_method = "E0A5B8E1D2C449F7E3C6BBF1F8BFF4A6")
    public void setHostnameVerifier(HostnameVerifier v) {
    if(v == null)        
        {
            IllegalArgumentException varB2B1BB748022FB44C905B3AD1B84212E_405118117 = new IllegalArgumentException("HostnameVerifier is null");
            varB2B1BB748022FB44C905B3AD1B84212E_405118117.addTaint(taint);
            throw varB2B1BB748022FB44C905B3AD1B84212E_405118117;
        } //End block
        hostnameVerifier = v;
        // ---------- Original Method ----------
        //if (v == null) {
            //throw new IllegalArgumentException("HostnameVerifier is null");
        //}
        //hostnameVerifier = v;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.786 -0400", hash_original_method = "ECCA6A5C3EF4993C1CFD64A0404A993B", hash_generated_method = "777BC6091A75C87F7325FB35A3A9F88C")
    public HostnameVerifier getHostnameVerifier() {
HostnameVerifier var9306CAE4DB3D2F94D65947C804026160_700840714 =         hostnameVerifier;
        var9306CAE4DB3D2F94D65947C804026160_700840714.addTaint(taint);
        return var9306CAE4DB3D2F94D65947C804026160_700840714;
        // ---------- Original Method ----------
        //return hostnameVerifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.786 -0400", hash_original_method = "C38E7A94B75C24B6865C99F80CA80171", hash_generated_method = "0308E6FE01A1CC6D8ECEF649600F8EF7")
    public void setSSLSocketFactory(SSLSocketFactory sf) {
    if(sf == null)        
        {
            IllegalArgumentException varE71C9EEA9830D2C5E1284881E071F435_809948363 = new IllegalArgumentException("SSLSocketFactory is null");
            varE71C9EEA9830D2C5E1284881E071F435_809948363.addTaint(taint);
            throw varE71C9EEA9830D2C5E1284881E071F435_809948363;
        } //End block
        sslSocketFactory = sf;
        // ---------- Original Method ----------
        //if (sf == null) {
            //throw new IllegalArgumentException("SSLSocketFactory is null");
        //}
        //sslSocketFactory = sf;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.787 -0400", hash_original_method = "9F872E117F4FD1E88D0B5BA15C4E96B2", hash_generated_method = "3AEE1079478014C9722553C6952CD92E")
    public SSLSocketFactory getSSLSocketFactory() {
SSLSocketFactory varFD641254E64F4CA7544D2CDD90C74007_326297233 =         sslSocketFactory;
        varFD641254E64F4CA7544D2CDD90C74007_326297233.addTaint(taint);
        return varFD641254E64F4CA7544D2CDD90C74007_326297233;
        // ---------- Original Method ----------
        //return sslSocketFactory;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.787 -0400", hash_original_field = "02AD6FD1A94FACFD37F7188B722CB35F", hash_generated_field = "7D4EC90B6C0CC97A49BDB74C867F8D18")

    private static HostnameVerifier defaultHostnameVerifier = new DefaultHostnameVerifier();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.787 -0400", hash_original_field = "4DFFD38378016A688A004EB3D96069F1", hash_generated_field = "E0EF4240F4797BAB1451A0AF02E6DCCF")

    private static SSLSocketFactory defaultSSLSocketFactory = (SSLSocketFactory) SSLSocketFactory
            .getDefault();
}

