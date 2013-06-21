package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import org.apache.harmony.security.provider.cert.X509CertImpl;

abstract class AbstractSessionContext implements SSLSessionContext {
    volatile int maximumSize;
    volatile int timeout;
    int sslCtxNativePointer = NativeCrypto.SSL_CTX_new();
    private final Map<ByteArray, SSLSession> sessions = new LinkedHashMap<ByteArray, SSLSession>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.501 -0400", hash_original_method = "50C1CC90C9158408C79488CFE262DC7E", hash_generated_method = "47B6D0A82DC527A9B03D642B90566F82")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected boolean removeEldestEntry(
                Map.Entry<ByteArray, SSLSession> eldest) {
            dsTaint.addTaint(eldest.dsTaint);
            boolean var952E6B41D9F0F5AC085097F04FB5925E_1702068880 = (maximumSize > 0 && size() > maximumSize);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return maximumSize > 0 && size() > maximumSize;
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.501 -0400", hash_original_method = "B86A9D4A1D1D4BFB528024933586DA07", hash_generated_method = "7981A5C50331C5DFA34FD1486833F284")
    @DSModeled(DSC.SAFE)
     AbstractSessionContext(int maximumSize, int timeout) {
        dsTaint.addTaint(maximumSize);
        dsTaint.addTaint(timeout);
        // ---------- Original Method ----------
        //this.maximumSize = maximumSize;
        //this.timeout = timeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.501 -0400", hash_original_method = "A58241B75AD2B44C3E74E917DCCEF491", hash_generated_method = "6E1756263440F487A4FA217AA5357398")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Iterator<SSLSession> sessionIterator() {
        {
            SSLSession[] array;
            array = sessions.values().toArray(
                    new SSLSession[sessions.size()]);
            Iterator<SSLSession> var2E66FA9E73FA2B463C2B80E8D72ABC4B_992622414 = (Arrays.asList(array).iterator());
        } //End block
        return (Iterator<SSLSession>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (sessions) {
            //SSLSession[] array = sessions.values().toArray(
                    //new SSLSession[sessions.size()]);
            //return Arrays.asList(array).iterator();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.502 -0400", hash_original_method = "106825D731C9327C3D7A99A6486CA67E", hash_generated_method = "5DB89E0DADF85C68954CA181CF7B23EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Enumeration getIds() {
        Iterator<SSLSession> i;
        i = sessionIterator();
        Enumeration varC5463834F3C7B736327AF53268BB1EC7_968391507 = (new Enumeration<byte[]>() {            private SSLSession next;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.502 -0400", hash_original_method = "ECED6E9B0C3B7E941FD6E8C079DAFC6A", hash_generated_method = "5FBA6B17F0BA11F0CD06F882928FDBEA")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public boolean hasMoreElements() {
                {
                    boolean var048C390D087BEDAABDA4F669A9DA628E_2045245918 = (i.hasNext());
                    {
                        SSLSession session;
                        session = i.next();
                        {
                            boolean varEFB0840CD68F8F4EB963A9BA30FD34F3_1850772546 = (session.isValid());
                            {
                                next = session;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                next = null;
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //if (next != null) {
                    //return true;
                //}
                //while (i.hasNext()) {
                    //SSLSession session = i.next();
                    //if (session.isValid()) {
                        //next = session;
                        //return true;
                    //}
                //}
                //next = null;
                //return false;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.502 -0400", hash_original_method = "7968D7DCCB027A5D41A2AFCAEBC6C83D", hash_generated_method = "24E9D1E9DAED82867B01B4C150635C85")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public byte[] nextElement() {
                {
                    boolean var25E4318238BC5B33DF1CE79130F3CB3B_1325975458 = (hasMoreElements());
                    {
                        byte[] id;
                        id = next.getId();
                        next = null;
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                byte[] retVal = new byte[1];
                retVal[0] = (byte)dsTaint.getTaintInt();
                return retVal;
                // ---------- Original Method ----------
                //if (hasMoreElements()) {
                    //byte[] id = next.getId();
                    //next = null;
                    //return id;
                //}
                //throw new NoSuchElementException();
            }
});
        return (Enumeration)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.502 -0400", hash_original_method = "D0015EDFECCAD43C3752A19176DA2F6D", hash_generated_method = "A4BA0DA4AF511753BA39D54BCE27C3D1")
    @DSModeled(DSC.SAFE)
    public final int getSessionCacheSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return maximumSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.502 -0400", hash_original_method = "4FB73E0AB538272543472A54EAEE75CD", hash_generated_method = "50EEBE48615A07AE5C1F252F1B92B3EF")
    @DSModeled(DSC.SAFE)
    public final int getSessionTimeout() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return timeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.503 -0400", hash_original_method = "8615761B2210F074D79DA775AC19AA71", hash_generated_method = "8C4BCF3C8C09FA87E9E768219DF9DBD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void trimToSize() {
        {
            int size;
            size = sessions.size();
            {
                int removals;
                removals = size - maximumSize;
                Iterator<SSLSession> i;
                i = sessions.values().iterator();
                {
                    SSLSession session;
                    session = i.next();
                    i.remove();
                    sessionRemoved(session);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (sessions) {
            //int size = sessions.size();
            //if (size > maximumSize) {
                //int removals = size - maximumSize;
                //Iterator<SSLSession> i = sessions.values().iterator();
                //do {
                    //SSLSession session = i.next();
                    //i.remove();
                    //sessionRemoved(session);
                //} while (--removals > 0);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.503 -0400", hash_original_method = "39A7527C252FC67E9B785D11757CBC70", hash_generated_method = "F50108836BC30CA3EC654F41AF358E8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSessionTimeout(int seconds) throws IllegalArgumentException {
        dsTaint.addTaint(seconds);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("seconds < 0");
        } //End block
        {
            Iterator<SSLSession> i;
            i = sessions.values().iterator();
            {
                boolean varD8B5E52A597500CBD863E52A46B42708_1252139941 = (i.hasNext());
                {
                    SSLSession session;
                    session = i.next();
                    {
                        boolean var5781757318888F5EAFBBB43D777C1BE7_991021962 = (!session.isValid());
                        {
                            i.remove();
                            sessionRemoved(session);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (seconds < 0) {
            //throw new IllegalArgumentException("seconds < 0");
        //}
        //timeout = seconds;
        //synchronized (sessions) {
            //Iterator<SSLSession> i = sessions.values().iterator();
            //while (i.hasNext()) {
                //SSLSession session = i.next();
                //if (!session.isValid()) {
                    //i.remove();
                    //sessionRemoved(session);
                //}
            //}
        //}
    }

    
    protected abstract void sessionRemoved(SSLSession session);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.503 -0400", hash_original_method = "ACCBBC1F3ACDB7C97A3E02614B766E1C", hash_generated_method = "EB111729AEA4B37B699E33ED48AE31BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setSessionCacheSize(int size) throws IllegalArgumentException {
        dsTaint.addTaint(size);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size < 0");
        } //End block
        int oldMaximum;
        oldMaximum = maximumSize;
        {
            trimToSize();
        } //End block
        // ---------- Original Method ----------
        //if (size < 0) {
            //throw new IllegalArgumentException("size < 0");
        //}
        //int oldMaximum = maximumSize;
        //maximumSize = size;
        //if (size < oldMaximum) {
            //trimToSize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.510 -0400", hash_original_method = "B42ED13DCD08C26044D05FD9CDF469CF", hash_generated_method = "559E91057830760FFF50F420B5459BF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     byte[] toBytes(SSLSession session) {
        dsTaint.addTaint(session.dsTaint);
        OpenSSLSessionImpl sslSession;
        sslSession = (OpenSSLSessionImpl) session;
        try 
        {
            ByteArrayOutputStream baos;
            baos = new ByteArrayOutputStream();
            DataOutputStream daos;
            daos = new DataOutputStream(baos);
            daos.writeInt(OPEN_SSL);
            byte[] data;
            data = sslSession.getEncoded();
            daos.writeInt(data.length);
            daos.write(data);
            Certificate[] certs;
            certs = session.getPeerCertificates();
            daos.writeInt(certs.length);
            {
                Certificate cert = certs[0];
                {
                    data = cert.getEncoded();
                    daos.writeInt(data.length);
                    daos.write(data);
                } //End block
            } //End collapsed parenthetic
            byte[] var99E4F7F59DC442B21AA2E171B7120389_1299719223 = (baos.toByteArray());
        } //End block
        catch (IOException e)
        {
            log(e);
        } //End block
        catch (CertificateEncodingException e)
        {
            log(e);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.511 -0400", hash_original_method = "1F6A50EAF05C581243DFC8EDF15FF940", hash_generated_method = "6D972CCBA2903B1017005628B0BBDABC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SSLSession toSession(byte[] data, String host, int port) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(data[0]);
        ByteArrayInputStream bais;
        bais = new ByteArrayInputStream(data);
        DataInputStream dais;
        dais = new DataInputStream(bais);
        try 
        {
            int type;
            type = dais.readInt();
            {
                log(new AssertionError("Unexpected type ID: " + type));
            } //End block
            int length;
            length = dais.readInt();
            byte[] sessionData;
            sessionData = new byte[length];
            dais.readFully(sessionData);
            int count;
            count = dais.readInt();
            X509CertImpl[] certs;
            certs = new X509CertImpl[count];
            {
                int i;
                i = 0;
                {
                    length = dais.readInt();
                    byte[] certData;
                    certData = new byte[length];
                    dais.readFully(certData);
                    certs[i] = new X509CertImpl(certData);
                } //End block
            } //End collapsed parenthetic
            SSLSession var570B57E20998A17EF3F16A17E636F3C9_2049119059 = (new OpenSSLSessionImpl(sessionData, host, port, certs, this));
        } //End block
        catch (IOException e)
        {
            log(e);
        } //End block
        return (SSLSession)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.512 -0400", hash_original_method = "C269704A4F254C894FBE48E4ADC3F7DA", hash_generated_method = "3833F43F5841A5E6AA7AA7E65A01520D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLSession getSession(byte[] sessionId) {
        dsTaint.addTaint(sessionId[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("sessionId == null");
        } //End block
        ByteArray key;
        key = new ByteArray(sessionId);
        SSLSession session;
        {
            session = sessions.get(key);
        } //End block
        {
            boolean var784A1CDA62AB9B2C753832FCE828B745_1384421428 = (session != null && session.isValid());
        } //End collapsed parenthetic
        return (SSLSession)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (sessionId == null) {
            //throw new NullPointerException("sessionId == null");
        //}
        //ByteArray key = new ByteArray(sessionId);
        //SSLSession session;
        //synchronized (sessions) {
            //session = sessions.get(key);
        //}
        //if (session != null && session.isValid()) {
            //return session;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.512 -0400", hash_original_method = "01E7B06223DFEA7D5DECA9A679FEAED7", hash_generated_method = "933FAEA751A47B598B1D6917166397DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void putSession(SSLSession session) {
        dsTaint.addTaint(session.dsTaint);
        byte[] id;
        id = session.getId();
        ByteArray key;
        key = new ByteArray(id);
        {
            sessions.put(key, session);
        } //End block
        // ---------- Original Method ----------
        //byte[] id = session.getId();
        //if (id.length == 0) {
            //return;
        //}
        //ByteArray key = new ByteArray(id);
        //synchronized (sessions) {
            //sessions.put(key, session);
        //}
    }

    
        static void log(Throwable t) {
        System.logW("Error converting session.", t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.512 -0400", hash_original_method = "F38656E203DF2568CDB8FB5A6C876744", hash_generated_method = "415C95D5B1D7C63D7DD32000B7CCE6AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            NativeCrypto.SSL_CTX_free(sslCtxNativePointer);
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //NativeCrypto.SSL_CTX_free(sslCtxNativePointer);
        //} finally {
            //super.finalize();
        //}
    }

    
    static final int OPEN_SSL = 1;
}

