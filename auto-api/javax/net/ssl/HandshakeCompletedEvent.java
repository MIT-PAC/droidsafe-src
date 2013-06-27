package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.EventObject;
import javax.security.cert.X509Certificate;

public class HandshakeCompletedEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.109 -0400", hash_original_field = "21D6F40CFB511982E4424E0E250A9557", hash_generated_field = "263AF05607311316518E2566C59FC14C")

    private transient SSLSession session;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.109 -0400", hash_original_method = "49E2221C7C9E09C593B53C8D7CC4ED30", hash_generated_method = "15F7EB68362F22D12E07836184961298")
    public  HandshakeCompletedEvent(SSLSocket sock, SSLSession s) {
        super(sock);
        session = s;
        addTaint(sock.getTaint());
        // ---------- Original Method ----------
        //session = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.110 -0400", hash_original_method = "2F35DBDDEE25D44180770FC68EA02FBF", hash_generated_method = "09CD74D06F8C293AF68DE3B131922104")
    public SSLSession getSession() {
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_113965210 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_113965210 = session;
        varB4EAC82CA7396A68D541C85D26508E83_113965210.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_113965210;
        // ---------- Original Method ----------
        //return session;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.117 -0400", hash_original_method = "AA50F870D8B0EDDAC30AA11C075FA460", hash_generated_method = "59B7DD5599D882F2DA167C9F7B8834ED")
    public String getCipherSuite() {
        String varB4EAC82CA7396A68D541C85D26508E83_358601105 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_358601105 = session.getCipherSuite();
        varB4EAC82CA7396A68D541C85D26508E83_358601105.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_358601105;
        // ---------- Original Method ----------
        //return session.getCipherSuite();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.118 -0400", hash_original_method = "12F750698B4C5596A2F6F73DC7614702", hash_generated_method = "38E9632B733369B1B607DDD70AAB48DE")
    public Certificate[] getLocalCertificates() {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_2068116378 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2068116378 = session.getLocalCertificates();
        varB4EAC82CA7396A68D541C85D26508E83_2068116378.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2068116378;
        // ---------- Original Method ----------
        //return session.getLocalCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.118 -0400", hash_original_method = "4973BE3A4ED587D46EBF93135059669C", hash_generated_method = "EF39E53E5E30F3FEE200A3F91B1353CB")
    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1115534661 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1115534661 = session.getPeerCertificates();
        varB4EAC82CA7396A68D541C85D26508E83_1115534661.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1115534661;
        // ---------- Original Method ----------
        //return session.getPeerCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.129 -0400", hash_original_method = "8A3AA58C9CA390E089E395D78527A15D", hash_generated_method = "2143F87191141D29834F8959BF814B07")
    public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        X509Certificate[] varB4EAC82CA7396A68D541C85D26508E83_389308401 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_389308401 = session.getPeerCertificateChain();
        varB4EAC82CA7396A68D541C85D26508E83_389308401.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_389308401;
        // ---------- Original Method ----------
        //return session.getPeerCertificateChain();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.130 -0400", hash_original_method = "E52328DA42ED4C7658029875D0FD2A85", hash_generated_method = "8DB3140A8444ECD50C92C3C0071AC0E7")
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Principal varB4EAC82CA7396A68D541C85D26508E83_1222226173 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1222226173 = session.getPeerPrincipal();
        varB4EAC82CA7396A68D541C85D26508E83_1222226173.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1222226173;
        // ---------- Original Method ----------
        //return session.getPeerPrincipal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.130 -0400", hash_original_method = "9AEFAC82D29E63E6CA9E21A60A8B85D0", hash_generated_method = "A9A19F207C51600225DBF7FCEC6356DF")
    public Principal getLocalPrincipal() {
        Principal varB4EAC82CA7396A68D541C85D26508E83_2044173988 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2044173988 = session.getLocalPrincipal();
        varB4EAC82CA7396A68D541C85D26508E83_2044173988.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2044173988;
        // ---------- Original Method ----------
        //return session.getLocalPrincipal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.132 -0400", hash_original_method = "D59F011BF3B2DFBF72B84D897263E8E1", hash_generated_method = "549B971DE26215246C3CA940BD533CBC")
    public SSLSocket getSocket() {
        SSLSocket varB4EAC82CA7396A68D541C85D26508E83_1260597608 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1260597608 = (SSLSocket) this.source;
        varB4EAC82CA7396A68D541C85D26508E83_1260597608.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1260597608;
        // ---------- Original Method ----------
        //return (SSLSocket) this.source;
    }

    
}

