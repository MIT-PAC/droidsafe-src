package javax.net.ssl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

public abstract class HttpsURLConnection extends HttpURLConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.532 -0400", hash_original_field = "1DE571710ADB23614453BCCE654FE27E", hash_generated_field = "936CC44C0D1FD42DECA40078C5783214")

    protected HostnameVerifier hostnameVerifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.532 -0400", hash_original_field = "6B7BCFA2A69C0983F4EE1C29CDD1407B", hash_generated_field = "87C1504631DE52B6388145B4A5898443")

    private SSLSocketFactory sslSocketFactory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.532 -0400", hash_original_method = "3F2F2A4446750A53080925148675EF12", hash_generated_method = "888A703F743EBAC937D79B25BEC148E2")
    protected  HttpsURLConnection(URL url) {
        super(url);
        hostnameVerifier = defaultHostnameVerifier;
        sslSocketFactory = defaultSSLSocketFactory;
        addTaint(url.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static void setDefaultHostnameVerifier(HostnameVerifier v) {
        if (v == null) {
            throw new IllegalArgumentException("HostnameVerifier is null");
        }
        defaultHostnameVerifier = v;
    }

    
    public static HostnameVerifier getDefaultHostnameVerifier() {
        return defaultHostnameVerifier;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.537 -0400", hash_original_method = "3002E4037B6FC8FCCD4931764B6D5235", hash_generated_method = "1780CD2005C46F8912CB08E106A9E073")
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Principal varB4EAC82CA7396A68D541C85D26508E83_783678134 = null; 
        Certificate[] certs = getServerCertificates();
        {
            if (DroidSafeAndroidRuntime.control) throw new SSLPeerUnverifiedException("No server's end-entity certificate");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_783678134 = ((X509Certificate) certs[0]).getSubjectX500Principal();
        varB4EAC82CA7396A68D541C85D26508E83_783678134.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_783678134;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.538 -0400", hash_original_method = "F7626DF75E46EFB83E8F38373F84B563", hash_generated_method = "C2E186B6D63E86F7BB7C5DE661301B32")
    public Principal getLocalPrincipal() {
        Principal varB4EAC82CA7396A68D541C85D26508E83_78379854 = null; 
        Principal varB4EAC82CA7396A68D541C85D26508E83_425947337 = null; 
        Certificate[] certs = getLocalCertificates();
        {
            varB4EAC82CA7396A68D541C85D26508E83_78379854 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_425947337 = ((X509Certificate) certs[0]).getSubjectX500Principal();
        Principal varA7E53CE21691AB073D9660D615818899_722924027; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_722924027 = varB4EAC82CA7396A68D541C85D26508E83_78379854;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_722924027 = varB4EAC82CA7396A68D541C85D26508E83_425947337;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_722924027.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_722924027;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.539 -0400", hash_original_method = "1F574C02EC6D9C57C280B3A1D2132BB4", hash_generated_method = "AFAAF09D886207DB34F1171074A47881")
    public void setHostnameVerifier(HostnameVerifier v) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HostnameVerifier is null");
        } 
        hostnameVerifier = v;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.540 -0400", hash_original_method = "ECCA6A5C3EF4993C1CFD64A0404A993B", hash_generated_method = "1E0D307AE2890B8A54FA554EA82B9F28")
    public HostnameVerifier getHostnameVerifier() {
        HostnameVerifier varB4EAC82CA7396A68D541C85D26508E83_769862155 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_769862155 = hostnameVerifier;
        varB4EAC82CA7396A68D541C85D26508E83_769862155.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_769862155;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.541 -0400", hash_original_method = "C38E7A94B75C24B6865C99F80CA80171", hash_generated_method = "11E17E5F52B0EC573A60C7E8547EB9A9")
    public void setSSLSocketFactory(SSLSocketFactory sf) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("SSLSocketFactory is null");
        } 
        sslSocketFactory = sf;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.541 -0400", hash_original_method = "9F872E117F4FD1E88D0B5BA15C4E96B2", hash_generated_method = "927200D7F1C8244041F59318B8ABB241")
    public SSLSocketFactory getSSLSocketFactory() {
        SSLSocketFactory varB4EAC82CA7396A68D541C85D26508E83_1832565985 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1832565985 = sslSocketFactory;
        varB4EAC82CA7396A68D541C85D26508E83_1832565985.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1832565985;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.542 -0400", hash_original_field = "02AD6FD1A94FACFD37F7188B722CB35F", hash_generated_field = "7D4EC90B6C0CC97A49BDB74C867F8D18")

    private static HostnameVerifier defaultHostnameVerifier = new DefaultHostnameVerifier();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.542 -0400", hash_original_field = "4DFFD38378016A688A004EB3D96069F1", hash_generated_field = "E0EF4240F4797BAB1451A0AF02E6DCCF")

    private static SSLSocketFactory defaultSSLSocketFactory = (SSLSocketFactory) SSLSocketFactory
            .getDefault();
}

