package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.EventObject;
import javax.security.cert.X509Certificate;

public class HandshakeCompletedEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.756 -0400", hash_original_field = "21D6F40CFB511982E4424E0E250A9557", hash_generated_field = "263AF05607311316518E2566C59FC14C")

    private transient SSLSession session;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.757 -0400", hash_original_method = "49E2221C7C9E09C593B53C8D7CC4ED30", hash_generated_method = "7A8448F3800B0E2713B80E8EAA9DE7DE")
    public  HandshakeCompletedEvent(SSLSocket sock, SSLSession s) {
        super(sock);
        addTaint(sock.getTaint());
        session = s;
        // ---------- Original Method ----------
        //session = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.757 -0400", hash_original_method = "2F35DBDDEE25D44180770FC68EA02FBF", hash_generated_method = "FF033B955DCDAE8E871B63CB46295FC3")
    public SSLSession getSession() {
SSLSession varD555E544A66E0F97DA6BCDE940E3E79C_1036168708 =         session;
        varD555E544A66E0F97DA6BCDE940E3E79C_1036168708.addTaint(taint);
        return varD555E544A66E0F97DA6BCDE940E3E79C_1036168708;
        // ---------- Original Method ----------
        //return session;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.758 -0400", hash_original_method = "AA50F870D8B0EDDAC30AA11C075FA460", hash_generated_method = "5F07734C7E8A74BD33E9D19D04AA9A1A")
    public String getCipherSuite() {
String var17F7C6541C3AC9A1AB7A1A7947F67092_255456102 =         session.getCipherSuite();
        var17F7C6541C3AC9A1AB7A1A7947F67092_255456102.addTaint(taint);
        return var17F7C6541C3AC9A1AB7A1A7947F67092_255456102;
        // ---------- Original Method ----------
        //return session.getCipherSuite();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.758 -0400", hash_original_method = "12F750698B4C5596A2F6F73DC7614702", hash_generated_method = "C6B8CABD4F73FF8216CD4FCC4CEC3A01")
    public Certificate[] getLocalCertificates() {
Certificate[] var814C5E0AD153A50BA7251795F2B21D70_1497831764 =         session.getLocalCertificates();
        var814C5E0AD153A50BA7251795F2B21D70_1497831764.addTaint(taint);
        return var814C5E0AD153A50BA7251795F2B21D70_1497831764;
        // ---------- Original Method ----------
        //return session.getLocalCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.758 -0400", hash_original_method = "4973BE3A4ED587D46EBF93135059669C", hash_generated_method = "A5727BEA6127806C6CC9C09750900EB5")
    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
Certificate[] var95023AC60737474272021AD776AF6739_448635937 =         session.getPeerCertificates();
        var95023AC60737474272021AD776AF6739_448635937.addTaint(taint);
        return var95023AC60737474272021AD776AF6739_448635937;
        // ---------- Original Method ----------
        //return session.getPeerCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.759 -0400", hash_original_method = "8A3AA58C9CA390E089E395D78527A15D", hash_generated_method = "5DB94FC08138D07C2D2AD1D7F19B6761")
    public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
X509Certificate[] varDD253E96FEFE5AFA9B8333B5E04E8D52_210821848 =         session.getPeerCertificateChain();
        varDD253E96FEFE5AFA9B8333B5E04E8D52_210821848.addTaint(taint);
        return varDD253E96FEFE5AFA9B8333B5E04E8D52_210821848;
        // ---------- Original Method ----------
        //return session.getPeerCertificateChain();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.759 -0400", hash_original_method = "E52328DA42ED4C7658029875D0FD2A85", hash_generated_method = "C45AC8F9BF802BD5F501B2B7D4854DB5")
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
Principal varE32C5C017D2564D4CA9314996F3A7199_1125130394 =         session.getPeerPrincipal();
        varE32C5C017D2564D4CA9314996F3A7199_1125130394.addTaint(taint);
        return varE32C5C017D2564D4CA9314996F3A7199_1125130394;
        // ---------- Original Method ----------
        //return session.getPeerPrincipal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.760 -0400", hash_original_method = "9AEFAC82D29E63E6CA9E21A60A8B85D0", hash_generated_method = "36732E1DC64FA9F1AB14B6984012BD16")
    public Principal getLocalPrincipal() {
Principal var1392FB01BD123E39BCC698D8FF713577_1920073809 =         session.getLocalPrincipal();
        var1392FB01BD123E39BCC698D8FF713577_1920073809.addTaint(taint);
        return var1392FB01BD123E39BCC698D8FF713577_1920073809;
        // ---------- Original Method ----------
        //return session.getLocalPrincipal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.760 -0400", hash_original_method = "D59F011BF3B2DFBF72B84D897263E8E1", hash_generated_method = "67A68340575EFF8D23F588214518F365")
    public SSLSocket getSocket() {
SSLSocket varB4DBB6057745BC2AB2ECD0D5AFD60222_1760842237 =         (SSLSocket) this.source;
        varB4DBB6057745BC2AB2ECD0D5AFD60222_1760842237.addTaint(taint);
        return varB4DBB6057745BC2AB2ECD0D5AFD60222_1760842237;
        // ---------- Original Method ----------
        //return (SSLSocket) this.source;
    }

    
}

