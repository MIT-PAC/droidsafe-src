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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.497 -0400", hash_original_field = "21D6F40CFB511982E4424E0E250A9557", hash_generated_field = "263AF05607311316518E2566C59FC14C")

    private transient SSLSession session;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.497 -0400", hash_original_method = "49E2221C7C9E09C593B53C8D7CC4ED30", hash_generated_method = "15F7EB68362F22D12E07836184961298")
    public  HandshakeCompletedEvent(SSLSocket sock, SSLSession s) {
        super(sock);
        session = s;
        addTaint(sock.getTaint());
        // ---------- Original Method ----------
        //session = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.498 -0400", hash_original_method = "2F35DBDDEE25D44180770FC68EA02FBF", hash_generated_method = "053A4AB844173EBF48C5ACADF09295EF")
    public SSLSession getSession() {
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_897109622 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_897109622 = session;
        varB4EAC82CA7396A68D541C85D26508E83_897109622.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_897109622;
        // ---------- Original Method ----------
        //return session;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.505 -0400", hash_original_method = "AA50F870D8B0EDDAC30AA11C075FA460", hash_generated_method = "BB84B7E44D8324DDEACE5C071CA72A81")
    public String getCipherSuite() {
        String varB4EAC82CA7396A68D541C85D26508E83_1457824619 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1457824619 = session.getCipherSuite();
        varB4EAC82CA7396A68D541C85D26508E83_1457824619.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1457824619;
        // ---------- Original Method ----------
        //return session.getCipherSuite();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.508 -0400", hash_original_method = "12F750698B4C5596A2F6F73DC7614702", hash_generated_method = "755D6C987EC4B4117F79DCD558ED37D5")
    public Certificate[] getLocalCertificates() {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1489827639 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1489827639 = session.getLocalCertificates();
        varB4EAC82CA7396A68D541C85D26508E83_1489827639.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1489827639;
        // ---------- Original Method ----------
        //return session.getLocalCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.514 -0400", hash_original_method = "4973BE3A4ED587D46EBF93135059669C", hash_generated_method = "9D22B387E23B13530D4C50916E654BF6")
    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_852372936 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_852372936 = session.getPeerCertificates();
        varB4EAC82CA7396A68D541C85D26508E83_852372936.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_852372936;
        // ---------- Original Method ----------
        //return session.getPeerCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.515 -0400", hash_original_method = "8A3AA58C9CA390E089E395D78527A15D", hash_generated_method = "BA52455889F520508495AF41BF9EF4BB")
    public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        X509Certificate[] varB4EAC82CA7396A68D541C85D26508E83_300546955 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_300546955 = session.getPeerCertificateChain();
        varB4EAC82CA7396A68D541C85D26508E83_300546955.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_300546955;
        // ---------- Original Method ----------
        //return session.getPeerCertificateChain();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.519 -0400", hash_original_method = "E52328DA42ED4C7658029875D0FD2A85", hash_generated_method = "AF70DF5F603DA41E7148B5DD03E3AF1B")
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Principal varB4EAC82CA7396A68D541C85D26508E83_1324985066 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1324985066 = session.getPeerPrincipal();
        varB4EAC82CA7396A68D541C85D26508E83_1324985066.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1324985066;
        // ---------- Original Method ----------
        //return session.getPeerPrincipal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.519 -0400", hash_original_method = "9AEFAC82D29E63E6CA9E21A60A8B85D0", hash_generated_method = "B8D195C4004556BE0C7B839D1728F523")
    public Principal getLocalPrincipal() {
        Principal varB4EAC82CA7396A68D541C85D26508E83_268559500 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_268559500 = session.getLocalPrincipal();
        varB4EAC82CA7396A68D541C85D26508E83_268559500.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_268559500;
        // ---------- Original Method ----------
        //return session.getLocalPrincipal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.519 -0400", hash_original_method = "D59F011BF3B2DFBF72B84D897263E8E1", hash_generated_method = "39CBA78A607B99ACE58DDA76E137302F")
    public SSLSocket getSocket() {
        SSLSocket varB4EAC82CA7396A68D541C85D26508E83_58080202 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_58080202 = (SSLSocket) this.source;
        varB4EAC82CA7396A68D541C85D26508E83_58080202.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_58080202;
        // ---------- Original Method ----------
        //return (SSLSocket) this.source;
    }

    
}

