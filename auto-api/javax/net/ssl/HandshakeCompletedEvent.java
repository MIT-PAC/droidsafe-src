package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.security.Principal;
import java.security.cert.Certificate;
import java.util.EventObject;
import javax.security.cert.X509Certificate;

public class HandshakeCompletedEvent extends EventObject {
    private transient SSLSession session;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.447 -0400", hash_original_method = "49E2221C7C9E09C593B53C8D7CC4ED30", hash_generated_method = "37DDD24807D2C02196F45241B5642086")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HandshakeCompletedEvent(SSLSocket sock, SSLSession s) {
        super(sock);
        dsTaint.addTaint(sock.dsTaint);
        dsTaint.addTaint(s.dsTaint);
        // ---------- Original Method ----------
        //session = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.447 -0400", hash_original_method = "2F35DBDDEE25D44180770FC68EA02FBF", hash_generated_method = "70B0887911CED83E9B34AFF5B5118F10")
    @DSModeled(DSC.SAFE)
    public SSLSession getSession() {
        return (SSLSession)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return session;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.447 -0400", hash_original_method = "AA50F870D8B0EDDAC30AA11C075FA460", hash_generated_method = "EBE37F6F4DF6342224C6A0B7F4DFD233")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCipherSuite() {
        String varF338FAA7022A1D3AB3C6AE90467F7E24_1861036701 = (session.getCipherSuite());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return session.getCipherSuite();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.447 -0400", hash_original_method = "12F750698B4C5596A2F6F73DC7614702", hash_generated_method = "C755C79F0AD37F7DC2759624AF6DF256")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Certificate[] getLocalCertificates() {
        Certificate[] varCBAE2C88308FD74335B62896AD254B3A_1779870289 = (session.getLocalCertificates());
        return (Certificate[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return session.getLocalCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.447 -0400", hash_original_method = "4973BE3A4ED587D46EBF93135059669C", hash_generated_method = "D0B7F08600AC2733937ADEA900FCD3DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        Certificate[] var0936BDA0AD038567AEE845D6C022EE54_938633091 = (session.getPeerCertificates());
        return (Certificate[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return session.getPeerCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.447 -0400", hash_original_method = "8A3AA58C9CA390E089E395D78527A15D", hash_generated_method = "D0726E6EAACE1DBAB08FAF90971BE12E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        X509Certificate[] var544BB8F20D0DFDFED136C89EDF2FA203_501262710 = (session.getPeerCertificateChain());
        return (X509Certificate[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return session.getPeerCertificateChain();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.447 -0400", hash_original_method = "E52328DA42ED4C7658029875D0FD2A85", hash_generated_method = "094459E50D24826801423352652EC07C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Principal varE5496BE9898F7CBD07C9335605431A2D_1354474424 = (session.getPeerPrincipal());
        return (Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return session.getPeerPrincipal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.447 -0400", hash_original_method = "9AEFAC82D29E63E6CA9E21A60A8B85D0", hash_generated_method = "54C1983ADFD647AD376ECF343D6DC639")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Principal getLocalPrincipal() {
        Principal var09956009F0409BA4BF20D114B56893DD_620069818 = (session.getLocalPrincipal());
        return (Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return session.getLocalPrincipal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.447 -0400", hash_original_method = "D59F011BF3B2DFBF72B84D897263E8E1", hash_generated_method = "4033439B395CB85A1C0D0911888C3BFA")
    @DSModeled(DSC.SAFE)
    public SSLSocket getSocket() {
        return (SSLSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SSLSocket) this.source;
    }

    
}


