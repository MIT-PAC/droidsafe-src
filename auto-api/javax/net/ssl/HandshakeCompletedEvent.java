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
    private transient SSLSession session;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.049 -0400", hash_original_method = "49E2221C7C9E09C593B53C8D7CC4ED30", hash_generated_method = "B20A265C009B36690DCE94239148B344")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HandshakeCompletedEvent(SSLSocket sock, SSLSession s) {
        super(sock);
        dsTaint.addTaint(sock.dsTaint);
        dsTaint.addTaint(s.dsTaint);
        // ---------- Original Method ----------
        //session = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.049 -0400", hash_original_method = "2F35DBDDEE25D44180770FC68EA02FBF", hash_generated_method = "44E6A488B5671B7F4631B63AB907E843")
    @DSModeled(DSC.SAFE)
    public SSLSession getSession() {
        return (SSLSession)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return session;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.049 -0400", hash_original_method = "AA50F870D8B0EDDAC30AA11C075FA460", hash_generated_method = "FA7390551764F19AAA83546A83F1DB81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCipherSuite() {
        String varF338FAA7022A1D3AB3C6AE90467F7E24_1243460387 = (session.getCipherSuite());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return session.getCipherSuite();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.049 -0400", hash_original_method = "12F750698B4C5596A2F6F73DC7614702", hash_generated_method = "20689AA703690B0F80DC8E5F2538635D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Certificate[] getLocalCertificates() {
        Certificate[] varCBAE2C88308FD74335B62896AD254B3A_1815004259 = (session.getLocalCertificates());
        return (Certificate[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return session.getLocalCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.049 -0400", hash_original_method = "4973BE3A4ED587D46EBF93135059669C", hash_generated_method = "A9ACEF2B2E8D902B5081B79BD61EBBB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        Certificate[] var0936BDA0AD038567AEE845D6C022EE54_426136433 = (session.getPeerCertificates());
        return (Certificate[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return session.getPeerCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.050 -0400", hash_original_method = "8A3AA58C9CA390E089E395D78527A15D", hash_generated_method = "B7A430BA67082EAEC60A2CF55621F837")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        X509Certificate[] var544BB8F20D0DFDFED136C89EDF2FA203_1966455234 = (session.getPeerCertificateChain());
        return (X509Certificate[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return session.getPeerCertificateChain();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.050 -0400", hash_original_method = "E52328DA42ED4C7658029875D0FD2A85", hash_generated_method = "EEB5E7A1578F6F415E9709E35BDCC348")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Principal varE5496BE9898F7CBD07C9335605431A2D_49623705 = (session.getPeerPrincipal());
        return (Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return session.getPeerPrincipal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.050 -0400", hash_original_method = "9AEFAC82D29E63E6CA9E21A60A8B85D0", hash_generated_method = "AB7D5B0FC88C2E63F4C7902723EF3A38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Principal getLocalPrincipal() {
        Principal var09956009F0409BA4BF20D114B56893DD_334986429 = (session.getLocalPrincipal());
        return (Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return session.getLocalPrincipal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.050 -0400", hash_original_method = "D59F011BF3B2DFBF72B84D897263E8E1", hash_generated_method = "7F6BBEF501F10799EDEAA06AA10782D9")
    @DSModeled(DSC.SAFE)
    public SSLSocket getSocket() {
        return (SSLSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SSLSocket) this.source;
    }

    
}

