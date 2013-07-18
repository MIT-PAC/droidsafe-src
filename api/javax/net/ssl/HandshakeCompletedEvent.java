package javax.net.ssl;

// Droidsafe Imports
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.EventObject;

import javax.security.cert.X509Certificate;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class HandshakeCompletedEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.593 -0400", hash_original_field = "21D6F40CFB511982E4424E0E250A9557", hash_generated_field = "263AF05607311316518E2566C59FC14C")

    private transient SSLSession session;
    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.593 -0400", hash_original_method = "49E2221C7C9E09C593B53C8D7CC4ED30", hash_generated_method = "7A8448F3800B0E2713B80E8EAA9DE7DE")
    public  HandshakeCompletedEvent(SSLSocket sock, SSLSession s) {
        super(sock);
        addTaint(sock.getTaint());
        session = s;
        // ---------- Original Method ----------
        //session = s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.594 -0400", hash_original_method = "2F35DBDDEE25D44180770FC68EA02FBF", hash_generated_method = "86753B685EFB8B04F1BAFAB440B29F4A")
    public SSLSession getSession() {
SSLSession varD555E544A66E0F97DA6BCDE940E3E79C_1380388782 =         session;
        varD555E544A66E0F97DA6BCDE940E3E79C_1380388782.addTaint(taint);
        return varD555E544A66E0F97DA6BCDE940E3E79C_1380388782;
        // ---------- Original Method ----------
        //return session;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.594 -0400", hash_original_method = "AA50F870D8B0EDDAC30AA11C075FA460", hash_generated_method = "918CF92591056CBB2A504EFE70C20355")
    public String getCipherSuite() {
String var17F7C6541C3AC9A1AB7A1A7947F67092_1298997231 =         session.getCipherSuite();
        var17F7C6541C3AC9A1AB7A1A7947F67092_1298997231.addTaint(taint);
        return var17F7C6541C3AC9A1AB7A1A7947F67092_1298997231;
        // ---------- Original Method ----------
        //return session.getCipherSuite();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.594 -0400", hash_original_method = "12F750698B4C5596A2F6F73DC7614702", hash_generated_method = "77E7109DC564CB29AB7A2DC22FC2B975")
    public Certificate[] getLocalCertificates() {
Certificate[] var814C5E0AD153A50BA7251795F2B21D70_1377716341 =         session.getLocalCertificates();
        var814C5E0AD153A50BA7251795F2B21D70_1377716341.addTaint(taint);
        return var814C5E0AD153A50BA7251795F2B21D70_1377716341;
        // ---------- Original Method ----------
        //return session.getLocalCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.595 -0400", hash_original_method = "4973BE3A4ED587D46EBF93135059669C", hash_generated_method = "649CFB66FF63743550215E390C8F7564")
    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
Certificate[] var95023AC60737474272021AD776AF6739_479019612 =         session.getPeerCertificates();
        var95023AC60737474272021AD776AF6739_479019612.addTaint(taint);
        return var95023AC60737474272021AD776AF6739_479019612;
        // ---------- Original Method ----------
        //return session.getPeerCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.595 -0400", hash_original_method = "8A3AA58C9CA390E089E395D78527A15D", hash_generated_method = "B10C2F91372D2E1F80C17537B0C08AE3")
    public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
X509Certificate[] varDD253E96FEFE5AFA9B8333B5E04E8D52_365562285 =         session.getPeerCertificateChain();
        varDD253E96FEFE5AFA9B8333B5E04E8D52_365562285.addTaint(taint);
        return varDD253E96FEFE5AFA9B8333B5E04E8D52_365562285;
        // ---------- Original Method ----------
        //return session.getPeerCertificateChain();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.595 -0400", hash_original_method = "E52328DA42ED4C7658029875D0FD2A85", hash_generated_method = "6B976C81D69CC3A8E4093C2A7DBA2183")
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
Principal varE32C5C017D2564D4CA9314996F3A7199_861515882 =         session.getPeerPrincipal();
        varE32C5C017D2564D4CA9314996F3A7199_861515882.addTaint(taint);
        return varE32C5C017D2564D4CA9314996F3A7199_861515882;
        // ---------- Original Method ----------
        //return session.getPeerPrincipal();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.596 -0400", hash_original_method = "9AEFAC82D29E63E6CA9E21A60A8B85D0", hash_generated_method = "B12AF50D5BB5450439C37439FC996167")
    public Principal getLocalPrincipal() {
Principal var1392FB01BD123E39BCC698D8FF713577_693718310 =         session.getLocalPrincipal();
        var1392FB01BD123E39BCC698D8FF713577_693718310.addTaint(taint);
        return var1392FB01BD123E39BCC698D8FF713577_693718310;
        // ---------- Original Method ----------
        //return session.getLocalPrincipal();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.596 -0400", hash_original_method = "D59F011BF3B2DFBF72B84D897263E8E1", hash_generated_method = "E11C0771D685130F29EC3E3606184920")
    public SSLSocket getSocket() {
SSLSocket varB4DBB6057745BC2AB2ECD0D5AFD60222_499342565 =         (SSLSocket) this.source;
        varB4DBB6057745BC2AB2ECD0D5AFD60222_499342565.addTaint(taint);
        return varB4DBB6057745BC2AB2ECD0D5AFD60222_499342565;
        // ---------- Original Method ----------
        //return (SSLSocket) this.source;
    }

    
}

