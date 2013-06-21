package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.security.Principal;
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
import javax.security.cert.CertificateException;

public class OpenSSLSessionImpl implements SSLSession {
    private long creationTime = 0;
    long lastAccessedTime = 0;
    X509Certificate[] localCertificates;
    X509Certificate[] peerCertificates;
    private boolean isValid = true;
    private Map<String, Object> values = new HashMap<String, Object>();
    private volatile javax.security.cert.X509Certificate[] peerCertificateChain;
    protected int sslSessionNativePointer;
    private String peerHost;
    private int peerPort = -1;
    private String cipherSuite;
    private String protocol;
    private String compressionMethod;
    private AbstractSessionContext sessionContext;
    private byte[] id;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.878 -0400", hash_original_method = "1D97F06EBCB0CC7BB7E5B60E8D275DC2", hash_generated_method = "10FF41C505D9637A8AA0DB829B2F19F5")
    @DSModeled(DSC.SAFE)
    protected OpenSSLSessionImpl(int sslSessionNativePointer, X509Certificate[] localCertificates,
            X509Certificate[] peerCertificates, String peerHost, int peerPort,
            AbstractSessionContext sessionContext) {
        dsTaint.addTaint(sessionContext.dsTaint);
        dsTaint.addTaint(peerHost);
        dsTaint.addTaint(sslSessionNativePointer);
        dsTaint.addTaint(localCertificates[0].dsTaint);
        dsTaint.addTaint(peerCertificates[0].dsTaint);
        dsTaint.addTaint(peerPort);
        // ---------- Original Method ----------
        //this.sslSessionNativePointer = sslSessionNativePointer;
        //this.localCertificates = localCertificates;
        //this.peerCertificates = peerCertificates;
        //this.peerHost = peerHost;
        //this.peerPort = peerPort;
        //this.sessionContext = sessionContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.879 -0400", hash_original_method = "ECC374A16FFF293E37020E85B391DB03", hash_generated_method = "1E9C2ADA4D9A17234C038C9AA218C217")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     OpenSSLSessionImpl(byte[] derData,
            String peerHost, int peerPort,
            X509Certificate[] peerCertificates,
            AbstractSessionContext sessionContext) throws IOException {
        this(NativeCrypto.d2i_SSL_SESSION(derData),
             null,
             peerCertificates,
             peerHost,
             peerPort,
             sessionContext);
        dsTaint.addTaint(derData[0]);
        dsTaint.addTaint(sessionContext.dsTaint);
        dsTaint.addTaint(peerHost);
        dsTaint.addTaint(peerCertificates[0].dsTaint);
        dsTaint.addTaint(peerPort);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid session data");
        } //End block
        // ---------- Original Method ----------
        //if (this.sslSessionNativePointer == 0) {
            //throw new IOException("Invalid session data");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.879 -0400", hash_original_method = "566A3E7ED91C5CA2BC21AC127756388D", hash_generated_method = "65B0413630997DEFB8E7CA7C9190729E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getId() {
        {
            resetId();
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (id == null) {
            //resetId();
        //}
        //return id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.879 -0400", hash_original_method = "57B02BE93AE841112E3F3B64D0EF8580", hash_generated_method = "3A40234A24A17A498837F8630547C44C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void resetId() {
        id = NativeCrypto.SSL_SESSION_session_id(sslSessionNativePointer);
        // ---------- Original Method ----------
        //id = NativeCrypto.SSL_SESSION_session_id(sslSessionNativePointer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.879 -0400", hash_original_method = "6E61934F3054764656AF5E19BA5296B9", hash_generated_method = "738C89DF842E962F8B45D9FD845A8E22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     byte[] getEncoded() {
        byte[] var1B32E27C6AA38E481DE7B683DE0C78A0_1541578070 = (NativeCrypto.i2d_SSL_SESSION(sslSessionNativePointer));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return NativeCrypto.i2d_SSL_SESSION(sslSessionNativePointer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.880 -0400", hash_original_method = "A19FB54083053630467ACC70727A9F00", hash_generated_method = "FBF150F0E600BB9F58AC346CABAB04AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getCreationTime() {
        {
            creationTime = NativeCrypto.SSL_SESSION_get_time(sslSessionNativePointer);
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (creationTime == 0) {
            //creationTime = NativeCrypto.SSL_SESSION_get_time(sslSessionNativePointer);
        //}
        //return creationTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.880 -0400", hash_original_method = "D25DBFE273F16B7B3F4524AEB4575158", hash_generated_method = "D1D45B796F1DE1AD8462B162A51705B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLastAccessedTime() {
        {
            Object var1E00950F601E34E55AF1F5E53EA61CA5_869820873 = (getCreationTime());
        } //End flattened ternary
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return (lastAccessedTime == 0) ? getCreationTime() : lastAccessedTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.880 -0400", hash_original_method = "A8B8393BBD8B21276043F8F436BCE41F", hash_generated_method = "0C8B5FE6B83B084D64BC6564CDD48BC0")
    @DSModeled(DSC.SAFE)
    public int getApplicationBufferSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return SSLRecordProtocol.MAX_DATA_LENGTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.881 -0400", hash_original_method = "D48FD6D531D6586277314A5CB11C610B", hash_generated_method = "5A14FBFE0DED98C2FF66C0A5928D95FF")
    @DSModeled(DSC.SAFE)
    public int getPacketBufferSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return SSLRecordProtocol.MAX_SSL_PACKET_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.881 -0400", hash_original_method = "FC218F5482EE1068025787BA631F1A11", hash_generated_method = "7E277D77DA253133477F0406C0F20EF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Principal getLocalPrincipal() {
        {
            Principal varF14F68E63E348DA4F62DF4F67B33B28C_1771513561 = (localCertificates[0].getSubjectX500Principal());
        } //End block
        return (Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (localCertificates != null && localCertificates.length > 0) {
            //return localCertificates[0].getSubjectX500Principal();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.881 -0400", hash_original_method = "00176E7E524F828990985588910F48EC", hash_generated_method = "A8A56D8D8B810C8964055B6917DBA1D9")
    @DSModeled(DSC.SAFE)
    public Certificate[] getLocalCertificates() {
        return (Certificate[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return localCertificates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.881 -0400", hash_original_method = "74B59F5E567633033E420B2FD20F7EA9", hash_generated_method = "F027C71D0278DC526B6FE14D23BB17DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.security.cert.X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
        javax.security.cert.X509Certificate[] result;
        result = peerCertificateChain;
        {
            peerCertificateChain = result = createPeerCertificateChain();
        } //End block
        return (javax.security.cert.X509Certificate[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkPeerCertificatesPresent();
        //javax.security.cert.X509Certificate[] result = peerCertificateChain;
        //if (result == null) {
            //peerCertificateChain = result = createPeerCertificateChain();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.882 -0400", hash_original_method = "95455CDE829A27B48DAF238C4403FA5A", hash_generated_method = "C76ECDC53684B501210AF9E9B528061A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private javax.security.cert.X509Certificate[] createPeerCertificateChain() throws SSLPeerUnverifiedException {
        try 
        {
            javax.security.cert.X509Certificate[] chain;
            chain = new javax.security.cert.X509Certificate[peerCertificates.length];
            {
                int i;
                i = 0;
                {
                    byte[] encoded;
                    encoded = peerCertificates[i].getEncoded();
                    chain[i] = javax.security.cert.X509Certificate.getInstance(encoded);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (CertificateEncodingException e)
        {
            SSLPeerUnverifiedException exception;
            exception = new SSLPeerUnverifiedException(e.getMessage());
            exception.initCause(exception);
            if (DroidSafeAndroidRuntime.control) throw exception;
        } //End block
        catch (CertificateException e)
        {
            SSLPeerUnverifiedException exception;
            exception = new SSLPeerUnverifiedException(e.getMessage());
            exception.initCause(exception);
            if (DroidSafeAndroidRuntime.control) throw exception;
        } //End block
        return (javax.security.cert.X509Certificate[])dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.882 -0400", hash_original_method = "6F2F2196C2B5F66BDE334D0180ADBF68", hash_generated_method = "FF62CCCA47817B4FAEE4516EA617512E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
        return (Certificate[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkPeerCertificatesPresent();
        //return peerCertificates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.882 -0400", hash_original_method = "4A7519F376EC7B19E89A23705C5BAAD6", hash_generated_method = "0ECA2302D909DF168B9F353DDB7E1C7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkPeerCertificatesPresent() throws SSLPeerUnverifiedException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SSLPeerUnverifiedException("No peer certificates");
        } //End block
        // ---------- Original Method ----------
        //if (peerCertificates == null || peerCertificates.length == 0) {
            //throw new SSLPeerUnverifiedException("No peer certificates");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.882 -0400", hash_original_method = "14CCB3DBB8312C280BE97228D3117477", hash_generated_method = "6521C95A252CD3A72CDBA956C9E855A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
        Principal varBF39C2B2035074557D5018FC4BBE559D_1106348512 = (peerCertificates[0].getSubjectX500Principal());
        return (Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkPeerCertificatesPresent();
        //return peerCertificates[0].getSubjectX500Principal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.883 -0400", hash_original_method = "686621F471AF14AF505B60419214318E", hash_generated_method = "3BF3C4086F7B3CF4925E10D1813275BA")
    @DSModeled(DSC.SAFE)
    public String getPeerHost() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return peerHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.883 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "AEBA702D6111FFED2D7D8A1EFD0D8FC1")
    @DSModeled(DSC.SAFE)
    public int getPeerPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.883 -0400", hash_original_method = "232543257EF0615A8C98189B2944DDF8", hash_generated_method = "4A45DF0231BA131A6338D0095B0AD079")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCipherSuite() {
        {
            String name;
            name = NativeCrypto.SSL_SESSION_cipher(sslSessionNativePointer);
            cipherSuite = NativeCrypto.OPENSSL_TO_STANDARD_CIPHER_SUITES.get(name);
            {
                cipherSuite = name;
            } //End block
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (cipherSuite == null) {
            //String name = NativeCrypto.SSL_SESSION_cipher(sslSessionNativePointer);
            //cipherSuite = NativeCrypto.OPENSSL_TO_STANDARD_CIPHER_SUITES.get(name);
            //if (cipherSuite == null) {
                //cipherSuite = name;
            //}
        //}
        //return cipherSuite;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.883 -0400", hash_original_method = "DC690D466354C337179157E9ED46DB27", hash_generated_method = "AE64BBF87A4AFCB01F9783833F4574D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getProtocol() {
        {
            protocol = NativeCrypto.SSL_SESSION_get_version(sslSessionNativePointer);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (protocol == null) {
            //protocol = NativeCrypto.SSL_SESSION_get_version(sslSessionNativePointer);
        //}
        //return protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.884 -0400", hash_original_method = "968671DF82E2AA12BC31F552097867FE", hash_generated_method = "A37342B8643954C0FD772FED99665E8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCompressionMethod() {
        {
            compressionMethod
                    = NativeCrypto.SSL_SESSION_compress_meth(sessionContext.sslCtxNativePointer,
                                                             sslSessionNativePointer);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (compressionMethod == null) {
            //compressionMethod
                    //= NativeCrypto.SSL_SESSION_compress_meth(sessionContext.sslCtxNativePointer,
                                                             //sslSessionNativePointer);
        //}
        //return compressionMethod;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.884 -0400", hash_original_method = "6C1FB28F6F59303D04A80E546963567A", hash_generated_method = "B91F35F9A016C682D119D2B16E70550F")
    @DSModeled(DSC.SAFE)
    public SSLSessionContext getSessionContext() {
        return (SSLSessionContext)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sessionContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.884 -0400", hash_original_method = "8D23F85B43098BFBC0CC2E7E59C1A10A", hash_generated_method = "ABA73AEA25DD1198D137D3F55F4A372B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isValid() {
        SSLSessionContext context;
        context = sessionContext;
        {
            boolean var014183AFC31920D3752F2F3A5699E2A8_451606556 = (isValid
                && context != null
                && context.getSessionTimeout() != 0
                && getCreationTime() + (context.getSessionTimeout() * 1000)
                    < System.currentTimeMillis());
            {
                isValid = false;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //SSLSessionContext context = sessionContext;
        //if (isValid
                //&& context != null
                //&& context.getSessionTimeout() != 0
                //&& getCreationTime() + (context.getSessionTimeout() * 1000)
                    //< System.currentTimeMillis()) {
            //isValid = false;
        //}
        //return isValid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.884 -0400", hash_original_method = "9CCB74C876B98AB8C259B415A5496084", hash_generated_method = "D973F2208FD25A513B4A2BF5A3AECE34")
    @DSModeled(DSC.SAFE)
    public void invalidate() {
        isValid = false;
        sessionContext = null;
        // ---------- Original Method ----------
        //isValid = false;
        //sessionContext = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.885 -0400", hash_original_method = "AC1FF55FABC34CC9974A294171A954DF", hash_generated_method = "D8C2653048DEDEAD00884D451E826565")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getValue(String name) {
        dsTaint.addTaint(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("name == null");
        } //End block
        Object var41AA620BD29427E41AA3D821E629D8D0_470261942 = (values.get(name));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("name == null");
        //}
        //return values.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.885 -0400", hash_original_method = "94A4765ACA5D7A784EB5749EBA86107C", hash_generated_method = "5247493FB20A12333AD0B8937B36DB44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getValueNames() {
        String[] var3F2E6D4A8D6E00A7687368EA768C8C76_2056635313 = (values.keySet().toArray(new String[values.size()]));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return values.keySet().toArray(new String[values.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.885 -0400", hash_original_method = "306FE04DD14403034511108312788846", hash_generated_method = "3C8EB05C230A2A970FAE3C17B314B9D6")
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
            ((SSLSessionBindingListener) value)
                    .valueBound(new SSLSessionBindingEvent(this, name));
        } //End block
        {
            ((SSLSessionBindingListener) old)
                    .valueUnbound(new SSLSessionBindingEvent(this, name));
        } //End block
        // ---------- Original Method ----------
        //if (name == null || value == null) {
            //throw new IllegalArgumentException("name == null || value == null");
        //}
        //Object old = values.put(name, value);
        //if (value instanceof SSLSessionBindingListener) {
            //((SSLSessionBindingListener) value)
                    //.valueBound(new SSLSessionBindingEvent(this, name));
        //}
        //if (old instanceof SSLSessionBindingListener) {
            //((SSLSessionBindingListener) old)
                    //.valueUnbound(new SSLSessionBindingEvent(this, name));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.885 -0400", hash_original_method = "EC2DC464BD3BB987F4ACA997202AA983", hash_generated_method = "7F81B654EB364CA761E4A93A8BD0FA8D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.886 -0400", hash_original_method = "1A939A31B27FEC68DC8C26996575F0FB", hash_generated_method = "A8CE8D6C0FF6144187B973F048710022")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            NativeCrypto.SSL_SESSION_free(sslSessionNativePointer);
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //NativeCrypto.SSL_SESSION_free(sslSessionNativePointer);
        //} finally {
            //super.finalize();
        //}
    }

    
}

