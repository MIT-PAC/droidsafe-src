package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.Principal;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionBindingEvent;
import javax.net.ssl.SSLSessionBindingListener;
import javax.net.ssl.SSLSessionContext;
import libcore.util.EmptyArray;

public final class SSLSessionImpl implements SSLSession, Cloneable {
    private long creationTime;
    private boolean isValid = true;
    private Map<String, Object> values = new HashMap<String, Object>();
    byte[] id;
    long lastAccessedTime;
    ProtocolVersion protocol;
    CipherSuite cipherSuite;
    SSLSessionContext context;
    X509Certificate[] localCertificates;
    X509Certificate[] peerCertificates;
    private String peerHost;
    private int peerPort = -1;
    byte[] master_secret;
    byte[] clientRandom;
    byte[] serverRandom;
    boolean isServer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.218 -0400", hash_original_method = "8B77818B34D277F665DFA23ABC8DBC5D", hash_generated_method = "DD2ACFB86E61FA035D216752557E9A92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLSessionImpl(CipherSuite cipher_suite, SecureRandom secureRandom) {
        dsTaint.addTaint(secureRandom.dsTaint);
        dsTaint.addTaint(cipher_suite.dsTaint);
        creationTime = System.currentTimeMillis();
        lastAccessedTime = creationTime;
        {
            this.cipherSuite = CipherSuite.SSL_NULL_WITH_NULL_NULL;
            id = EmptyArray.BYTE;
            isServer = false;
            isValid = false;
        } //End block
        {
            id = new byte[32];
            secureRandom.nextBytes(id);
            long time;
            time = creationTime / 1000;
            id[28] = (byte) ((time & 0xFF000000) >>> 24);
            id[29] = (byte) ((time & 0x00FF0000) >>> 16);
            id[30] = (byte) ((time & 0x0000FF00) >>> 8);
            id[31] = (byte) ((time & 0x000000FF));
            isServer = true;
        } //End block
        // ---------- Original Method ----------
        //creationTime = System.currentTimeMillis();
        //lastAccessedTime = creationTime;
        //if (cipher_suite == null) {
            //this.cipherSuite = CipherSuite.SSL_NULL_WITH_NULL_NULL;
            //id = EmptyArray.BYTE;
            //isServer = false;
            //isValid = false;
        //} else {
            //this.cipherSuite = cipher_suite;
            //id = new byte[32];
            //secureRandom.nextBytes(id);
            //long time = creationTime / 1000;
            //id[28] = (byte) ((time & 0xFF000000) >>> 24);
            //id[29] = (byte) ((time & 0x00FF0000) >>> 16);
            //id[30] = (byte) ((time & 0x0000FF00) >>> 8);
            //id[31] = (byte) ((time & 0x000000FF));
            //isServer = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.218 -0400", hash_original_method = "6D9F19E2EE775580BB96A397C59A5AA5", hash_generated_method = "55D3944EB22FD5145CCD5E47FC3E89DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLSessionImpl(SecureRandom secureRandom) {
        this(null, secureRandom);
        dsTaint.addTaint(secureRandom.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.218 -0400", hash_original_method = "A8B8393BBD8B21276043F8F436BCE41F", hash_generated_method = "0C8B5FE6B83B084D64BC6564CDD48BC0")
    @DSModeled(DSC.SAFE)
    public int getApplicationBufferSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return SSLRecordProtocol.MAX_DATA_LENGTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.218 -0400", hash_original_method = "745D2790D3F85591FE85537A877B7167", hash_generated_method = "B211D0AA63CD6F7F814B963B8091EE5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCipherSuite() {
        String varF75CA63BDD9434A4B434ED5B7B295FB1_1420108509 = (cipherSuite.getName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return cipherSuite.getName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.219 -0400", hash_original_method = "09A0842085DDEEEFFBE4843237FA7655", hash_generated_method = "A460A65C5E0B42DFEC6497C730D1F9D9")
    @DSModeled(DSC.SAFE)
    public long getCreationTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return creationTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.219 -0400", hash_original_method = "6FF1AD4C2D68C6B37F5B643FEDAC8BE4", hash_generated_method = "1EBE6F0A711068F169DF3DFEDD4DC4CD")
    @DSModeled(DSC.SAFE)
    public byte[] getId() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.219 -0400", hash_original_method = "79FEA1654BACC0D1C8F52D94037731AA", hash_generated_method = "ECC97DCD1362C9B08EAB67C1710942F0")
    @DSModeled(DSC.SAFE)
    public long getLastAccessedTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return lastAccessedTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.219 -0400", hash_original_method = "00176E7E524F828990985588910F48EC", hash_generated_method = "A8A56D8D8B810C8964055B6917DBA1D9")
    @DSModeled(DSC.SAFE)
    public Certificate[] getLocalCertificates() {
        return (Certificate[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return localCertificates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.219 -0400", hash_original_method = "458F509C66510A71C33EE842436FD9CE", hash_generated_method = "95A9C090E91A8AABB6A609B1092A8A1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Principal getLocalPrincipal() {
        {
            Principal varF14F68E63E348DA4F62DF4F67B33B28C_1546981050 = (localCertificates[0].getSubjectX500Principal());
        } //End block
        return (Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (localCertificates != null && localCertificates.length > 0) {
            //return localCertificates[0].getSubjectX500Principal();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.220 -0400", hash_original_method = "D48FD6D531D6586277314A5CB11C610B", hash_generated_method = "5A14FBFE0DED98C2FF66C0A5928D95FF")
    @DSModeled(DSC.SAFE)
    public int getPacketBufferSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return SSLRecordProtocol.MAX_SSL_PACKET_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.220 -0400", hash_original_method = "671707B73FC0A29660C8CE2F332B40EC", hash_generated_method = "B92EA4DB3ABC2BEDAF966AB284593501")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.security.cert.X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SSLPeerUnverifiedException("No peer certificate");
        } //End block
        javax.security.cert.X509Certificate[] certs;
        certs = new javax.security.cert.X509Certificate[peerCertificates.length];
        {
            int i;
            i = 0;
            {
                try 
                {
                    certs[i] = javax.security.cert.X509Certificate.getInstance(peerCertificates[i]
                        .getEncoded());
                } //End block
                catch (javax.security.cert.CertificateException ignored)
                { }
                catch (CertificateEncodingException ignored)
                { }
            } //End block
        } //End collapsed parenthetic
        return (javax.security.cert.X509Certificate[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (peerCertificates == null) {
            //throw new SSLPeerUnverifiedException("No peer certificate");
        //}
        //javax.security.cert.X509Certificate[] certs = new javax.security.cert.X509Certificate[peerCertificates.length];
        //for (int i = 0; i < certs.length; i++) {
            //try {
                //certs[i] = javax.security.cert.X509Certificate.getInstance(peerCertificates[i]
                        //.getEncoded());
            //} catch (javax.security.cert.CertificateException ignored) {
            //} catch (CertificateEncodingException ignored) {
            //}
        //}
        //return certs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.220 -0400", hash_original_method = "3CCB3131DE484F2F007F820172400088", hash_generated_method = "52B0A6C833DAFA66FCCA23689E053F13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SSLPeerUnverifiedException("No peer certificate");
        } //End block
        return (Certificate[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (peerCertificates == null) {
            //throw new SSLPeerUnverifiedException("No peer certificate");
        //}
        //return peerCertificates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.220 -0400", hash_original_method = "686621F471AF14AF505B60419214318E", hash_generated_method = "3BF3C4086F7B3CF4925E10D1813275BA")
    @DSModeled(DSC.SAFE)
    public String getPeerHost() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return peerHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.220 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "AEBA702D6111FFED2D7D8A1EFD0D8FC1")
    @DSModeled(DSC.SAFE)
    public int getPeerPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.221 -0400", hash_original_method = "B290FEA54ECCBD8C8D1AB720544591AB", hash_generated_method = "D6EA604428E7509BB64F4BDE1B629C6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SSLPeerUnverifiedException("No peer certificate");
        } //End block
        Principal varBF39C2B2035074557D5018FC4BBE559D_350007198 = (peerCertificates[0].getSubjectX500Principal());
        return (Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (peerCertificates == null) {
            //throw new SSLPeerUnverifiedException("No peer certificate");
        //}
        //return peerCertificates[0].getSubjectX500Principal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.221 -0400", hash_original_method = "70FFC4864CFD3FC7BC69978E71944D24", hash_generated_method = "AD17075023ED0A271350A1FD8E5B72E8")
    @DSModeled(DSC.SAFE)
    public String getProtocol() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (protocol == null) ? "NONE" : protocol.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.221 -0400", hash_original_method = "E54F5411F9B3E4DD60F47670618D45C7", hash_generated_method = "B5F732337322BFD22148B2157189601D")
    @DSModeled(DSC.SAFE)
    public SSLSessionContext getSessionContext() {
        return (SSLSessionContext)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.221 -0400", hash_original_method = "AC1FF55FABC34CC9974A294171A954DF", hash_generated_method = "8CFB21BC7465B38F2713BABD6D9AE5A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getValue(String name) {
        dsTaint.addTaint(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("name == null");
        } //End block
        Object var41AA620BD29427E41AA3D821E629D8D0_574658850 = (values.get(name));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("name == null");
        //}
        //return values.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.221 -0400", hash_original_method = "94A4765ACA5D7A784EB5749EBA86107C", hash_generated_method = "935F7564BFEA901410F1361470193362")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getValueNames() {
        String[] var3F2E6D4A8D6E00A7687368EA768C8C76_1531273015 = (values.keySet().toArray(new String[values.size()]));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return values.keySet().toArray(new String[values.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.222 -0400", hash_original_method = "81658CAC0BD01D20DC226803375A1EFC", hash_generated_method = "1607D36240D420C7B62C0493DECE3B97")
    @DSModeled(DSC.SAFE)
    public void invalidate() {
        isValid = false;
        context = null;
        // ---------- Original Method ----------
        //isValid = false;
        //context = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.222 -0400", hash_original_method = "901AA8BB3AAD61331954CF916345412F", hash_generated_method = "BF674A79E297676D006BD41F429AF554")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isValid() {
        {
            boolean varC83BECAF1EA0D7531D2106FB65F27935_2030006340 = (isValid && context != null && context.getSessionTimeout() != 0
                && lastAccessedTime + context.getSessionTimeout() > System.currentTimeMillis());
            {
                isValid = false;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (isValid && context != null && context.getSessionTimeout() != 0
                //&& lastAccessedTime + context.getSessionTimeout() > System.currentTimeMillis()) {
            //isValid = false;
        //}
        //return isValid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.222 -0400", hash_original_method = "306FE04DD14403034511108312788846", hash_generated_method = "C097D4F71A0C811BA254F67A9BC08FC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putValue(String name, Object value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("name == null || value == null");
        } //End block
        Object old;
        old = values.put(name, value);
        {
            ((SSLSessionBindingListener) value).valueBound(new SSLSessionBindingEvent(this, name));
        } //End block
        {
            ((SSLSessionBindingListener) old).valueUnbound(new SSLSessionBindingEvent(this, name));
        } //End block
        // ---------- Original Method ----------
        //if (name == null || value == null) {
            //throw new IllegalArgumentException("name == null || value == null");
        //}
        //Object old = values.put(name, value);
        //if (value instanceof SSLSessionBindingListener) {
            //((SSLSessionBindingListener) value).valueBound(new SSLSessionBindingEvent(this, name));
        //}
        //if (old instanceof SSLSessionBindingListener) {
            //((SSLSessionBindingListener) old).valueUnbound(new SSLSessionBindingEvent(this, name));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.222 -0400", hash_original_method = "EC2DC464BD3BB987F4ACA997202AA983", hash_generated_method = "7F81B654EB364CA761E4A93A8BD0FA8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeValue(String name) {
        dsTaint.addTaint(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("name == null");
        } //End block
        Object old;
        old = values.remove(name);
        {
            SSLSessionBindingListener listener;
            listener = (SSLSessionBindingListener) old;
            listener.valueUnbound(new SSLSessionBindingEvent(this, name));
        } //End block
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("name == null");
        //}
        //Object old = values.remove(name);
        //if (old instanceof SSLSessionBindingListener) {
            //SSLSessionBindingListener listener = (SSLSessionBindingListener) old;
            //listener.valueUnbound(new SSLSessionBindingEvent(this, name));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.223 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "08BA5B56506B993A3368317337D67D99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_808121042 = (super.clone());
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.223 -0400", hash_original_method = "1B64858E0F9CF91B520A55B4E94E3F8D", hash_generated_method = "6187A37DF5C94B848BA5925B402EA40A")
    @DSModeled(DSC.SAFE)
     void setPeer(String peerHost, int peerPort) {
        dsTaint.addTaint(peerHost);
        dsTaint.addTaint(peerPort);
        // ---------- Original Method ----------
        //this.peerHost = peerHost;
        //this.peerPort = peerPort;
    }

    
    public static final SSLSessionImpl NULL_SESSION = new SSLSessionImpl(null);
}

