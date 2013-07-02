package javax.net.ssl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.EventObject;
import javax.security.cert.X509Certificate;

public class HandshakeCompletedEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.511 -0400", hash_original_field = "21D6F40CFB511982E4424E0E250A9557", hash_generated_field = "263AF05607311316518E2566C59FC14C")

    private transient SSLSession session;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.513 -0400", hash_original_method = "49E2221C7C9E09C593B53C8D7CC4ED30", hash_generated_method = "15F7EB68362F22D12E07836184961298")
    public  HandshakeCompletedEvent(SSLSocket sock, SSLSession s) {
        super(sock);
        session = s;
        addTaint(sock.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.513 -0400", hash_original_method = "2F35DBDDEE25D44180770FC68EA02FBF", hash_generated_method = "3F637C019E322463294623E66CF3A2FA")
    public SSLSession getSession() {
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_1017571735 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1017571735 = session;
        varB4EAC82CA7396A68D541C85D26508E83_1017571735.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1017571735;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.514 -0400", hash_original_method = "AA50F870D8B0EDDAC30AA11C075FA460", hash_generated_method = "2F94A6FAA5DD20EE8546202DD4D0CA37")
    public String getCipherSuite() {
        String varB4EAC82CA7396A68D541C85D26508E83_237804217 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_237804217 = session.getCipherSuite();
        varB4EAC82CA7396A68D541C85D26508E83_237804217.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_237804217;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.515 -0400", hash_original_method = "12F750698B4C5596A2F6F73DC7614702", hash_generated_method = "59E957A47AF16588C8D74B0612F7F077")
    public Certificate[] getLocalCertificates() {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1876624450 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1876624450 = session.getLocalCertificates();
        varB4EAC82CA7396A68D541C85D26508E83_1876624450.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1876624450;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.516 -0400", hash_original_method = "4973BE3A4ED587D46EBF93135059669C", hash_generated_method = "594B1C5FC2471A04E606E8F54AFC950A")
    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1070288223 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1070288223 = session.getPeerCertificates();
        varB4EAC82CA7396A68D541C85D26508E83_1070288223.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1070288223;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.516 -0400", hash_original_method = "8A3AA58C9CA390E089E395D78527A15D", hash_generated_method = "C7FAF5D12F2414B5965D3D262ACD207A")
    public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        X509Certificate[] varB4EAC82CA7396A68D541C85D26508E83_2112852278 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2112852278 = session.getPeerCertificateChain();
        varB4EAC82CA7396A68D541C85D26508E83_2112852278.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2112852278;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.517 -0400", hash_original_method = "E52328DA42ED4C7658029875D0FD2A85", hash_generated_method = "B30DC13742EDCD57C0F42F57167E33A6")
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Principal varB4EAC82CA7396A68D541C85D26508E83_453518030 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_453518030 = session.getPeerPrincipal();
        varB4EAC82CA7396A68D541C85D26508E83_453518030.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_453518030;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.517 -0400", hash_original_method = "9AEFAC82D29E63E6CA9E21A60A8B85D0", hash_generated_method = "8B60913B8A83C416D923EB11FCAF808E")
    public Principal getLocalPrincipal() {
        Principal varB4EAC82CA7396A68D541C85D26508E83_21569090 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_21569090 = session.getLocalPrincipal();
        varB4EAC82CA7396A68D541C85D26508E83_21569090.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_21569090;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.518 -0400", hash_original_method = "D59F011BF3B2DFBF72B84D897263E8E1", hash_generated_method = "670A2D73913A02E08740FED46D27EAE5")
    public SSLSocket getSocket() {
        SSLSocket varB4EAC82CA7396A68D541C85D26508E83_1383165719 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1383165719 = (SSLSocket) this.source;
        varB4EAC82CA7396A68D541C85D26508E83_1383165719.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1383165719;
        
        
    }

    
}

