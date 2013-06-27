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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.530 -0400", hash_original_field = "1DE571710ADB23614453BCCE654FE27E", hash_generated_field = "936CC44C0D1FD42DECA40078C5783214")

    protected HostnameVerifier hostnameVerifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.530 -0400", hash_original_field = "6B7BCFA2A69C0983F4EE1C29CDD1407B", hash_generated_field = "87C1504631DE52B6388145B4A5898443")

    private SSLSocketFactory sslSocketFactory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.531 -0400", hash_original_method = "3F2F2A4446750A53080925148675EF12", hash_generated_method = "888A703F743EBAC937D79B25BEC148E2")
    protected  HttpsURLConnection(URL url) {
        super(url);
        hostnameVerifier = defaultHostnameVerifier;
        sslSocketFactory = defaultSSLSocketFactory;
        addTaint(url.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.549 -0400", hash_original_method = "3002E4037B6FC8FCCD4931764B6D5235", hash_generated_method = "F79B1D7AD4D4B008E24A4472A3C5253E")
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Principal varB4EAC82CA7396A68D541C85D26508E83_1232020953 = null; //Variable for return #1
        Certificate[] certs;
        certs = getServerCertificates();
        {
            if (DroidSafeAndroidRuntime.control) throw new SSLPeerUnverifiedException("No server's end-entity certificate");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1232020953 = ((X509Certificate) certs[0]).getSubjectX500Principal();
        varB4EAC82CA7396A68D541C85D26508E83_1232020953.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1232020953;
        // ---------- Original Method ----------
        //Certificate[] certs = getServerCertificates();
        //if (certs == null || certs.length == 0 || (!(certs[0] instanceof X509Certificate))) {
            //throw new SSLPeerUnverifiedException("No server's end-entity certificate");
        //}
        //return ((X509Certificate) certs[0]).getSubjectX500Principal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.564 -0400", hash_original_method = "F7626DF75E46EFB83E8F38373F84B563", hash_generated_method = "0876910F4DF530280F6812873E5C3CA5")
    public Principal getLocalPrincipal() {
        Principal varB4EAC82CA7396A68D541C85D26508E83_132459085 = null; //Variable for return #1
        Principal varB4EAC82CA7396A68D541C85D26508E83_1096769216 = null; //Variable for return #2
        Certificate[] certs;
        certs = getLocalCertificates();
        {
            varB4EAC82CA7396A68D541C85D26508E83_132459085 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1096769216 = ((X509Certificate) certs[0]).getSubjectX500Principal();
        Principal varA7E53CE21691AB073D9660D615818899_1193368290; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1193368290 = varB4EAC82CA7396A68D541C85D26508E83_132459085;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1193368290 = varB4EAC82CA7396A68D541C85D26508E83_1096769216;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1193368290.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1193368290;
        // ---------- Original Method ----------
        //Certificate[] certs = getLocalCertificates();
        //if (certs == null || certs.length == 0 || (!(certs[0] instanceof X509Certificate))) {
            //return null;
        //}
        //return ((X509Certificate) certs[0]).getSubjectX500Principal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.565 -0400", hash_original_method = "1F574C02EC6D9C57C280B3A1D2132BB4", hash_generated_method = "AFAAF09D886207DB34F1171074A47881")
    public void setHostnameVerifier(HostnameVerifier v) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HostnameVerifier is null");
        } //End block
        hostnameVerifier = v;
        // ---------- Original Method ----------
        //if (v == null) {
            //throw new IllegalArgumentException("HostnameVerifier is null");
        //}
        //hostnameVerifier = v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.565 -0400", hash_original_method = "ECCA6A5C3EF4993C1CFD64A0404A993B", hash_generated_method = "C22F3CF759A7F36BD35B083F99758E2C")
    public HostnameVerifier getHostnameVerifier() {
        HostnameVerifier varB4EAC82CA7396A68D541C85D26508E83_606567310 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_606567310 = hostnameVerifier;
        varB4EAC82CA7396A68D541C85D26508E83_606567310.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_606567310;
        // ---------- Original Method ----------
        //return hostnameVerifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.565 -0400", hash_original_method = "C38E7A94B75C24B6865C99F80CA80171", hash_generated_method = "11E17E5F52B0EC573A60C7E8547EB9A9")
    public void setSSLSocketFactory(SSLSocketFactory sf) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("SSLSocketFactory is null");
        } //End block
        sslSocketFactory = sf;
        // ---------- Original Method ----------
        //if (sf == null) {
            //throw new IllegalArgumentException("SSLSocketFactory is null");
        //}
        //sslSocketFactory = sf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.597 -0400", hash_original_method = "9F872E117F4FD1E88D0B5BA15C4E96B2", hash_generated_method = "03200891B8F999DA2EC375686AFE6A6C")
    public SSLSocketFactory getSSLSocketFactory() {
        SSLSocketFactory varB4EAC82CA7396A68D541C85D26508E83_2137261556 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2137261556 = sslSocketFactory;
        varB4EAC82CA7396A68D541C85D26508E83_2137261556.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2137261556;
        // ---------- Original Method ----------
        //return sslSocketFactory;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.597 -0400", hash_original_field = "02AD6FD1A94FACFD37F7188B722CB35F", hash_generated_field = "7D4EC90B6C0CC97A49BDB74C867F8D18")

    private static HostnameVerifier defaultHostnameVerifier = new DefaultHostnameVerifier();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.597 -0400", hash_original_field = "4DFFD38378016A688A004EB3D96069F1", hash_generated_field = "E0EF4240F4797BAB1451A0AF02E6DCCF")

    private static SSLSocketFactory defaultSSLSocketFactory = (SSLSocketFactory) SSLSocketFactory
            .getDefault();
}

