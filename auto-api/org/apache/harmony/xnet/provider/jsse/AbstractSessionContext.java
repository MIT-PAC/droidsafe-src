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
    static int OPEN_SSL = 1;
    private final Map<ByteArray, SSLSession> sessions = new LinkedHashMap<ByteArray, SSLSession>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:53:03.867 -0400", hash_original_method = "50C1CC90C9158408C79488CFE262DC7E", hash_generated_method = "AE989CD3BF8C1510878E5A915A826631")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected boolean removeEldestEntry(
                Map.Entry<ByteArray, SSLSession> eldest) {
            dsTaint.addTaint(eldest.dsTaint);
            boolean var952E6B41D9F0F5AC085097F04FB5925E_352195860 = (maximumSize > 0 && size() > maximumSize);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return maximumSize > 0 && size() > maximumSize;
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:53:03.881 -0400", hash_original_method = "B86A9D4A1D1D4BFB528024933586DA07", hash_generated_method = "4E0E6113E04F800C1404B5C4B6C5570F")
    @DSModeled(DSC.SAFE)
     AbstractSessionContext(int maximumSize, int timeout) {
        dsTaint.addTaint(maximumSize);
        dsTaint.addTaint(timeout);
        // ---------- Original Method ----------
        //this.maximumSize = maximumSize;
        //this.timeout = timeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:53:03.900 -0400", hash_original_method = "A58241B75AD2B44C3E74E917DCCEF491", hash_generated_method = "B3C8B08A3DDAC36BDDE7ACC61E204EB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Iterator<SSLSession> sessionIterator() {
        {
            SSLSession[] array;
            array = sessions.values().toArray(
                    new SSLSession[sessions.size()]);
            Iterator<SSLSession> var2E66FA9E73FA2B463C2B80E8D72ABC4B_832346222 = (Arrays.asList(array).iterator());
        } //End block
        return (Iterator<SSLSession>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (sessions) {
            //SSLSession[] array = sessions.values().toArray(
                    //new SSLSession[sessions.size()]);
            //return Arrays.asList(array).iterator();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:53:03.917 -0400", hash_original_method = "106825D731C9327C3D7A99A6486CA67E", hash_generated_method = "24EE8BB4E4976F0EBCA2B3CEC9C10698")
    @DSModeled(DSC.SAFE)
    public final Enumeration getIds() {
        Iterator<SSLSession> i;
        i = sessionIterator();
        return (Enumeration)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:53:03.927 -0400", hash_original_method = "D0015EDFECCAD43C3752A19176DA2F6D", hash_generated_method = "149B124983BA226B77B0FD780FFB558D")
    @DSModeled(DSC.SAFE)
    public final int getSessionCacheSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return maximumSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:53:03.940 -0400", hash_original_method = "4FB73E0AB538272543472A54EAEE75CD", hash_generated_method = "648BE71EA4F0E18F88ED80881C9A0653")
    @DSModeled(DSC.SAFE)
    public final int getSessionTimeout() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return timeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:53:03.961 -0400", hash_original_method = "8615761B2210F074D79DA775AC19AA71", hash_generated_method = "A28E0F192E33E63A59CA8A593B0B9676")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:53:04.008 -0400", hash_original_method = "39A7527C252FC67E9B785D11757CBC70", hash_generated_method = "89EDDE97115954D2F1879F8FF024B17B")
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
                boolean varD8B5E52A597500CBD863E52A46B42708_2060224095 = (i.hasNext());
                {
                    SSLSession session;
                    session = i.next();
                    {
                        boolean var5781757318888F5EAFBBB43D777C1BE7_1947264607 = (!session.isValid());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:53:04.035 -0400", hash_original_method = "ACCBBC1F3ACDB7C97A3E02614B766E1C", hash_generated_method = "276EFF65C56B651B8B0DC5F99E60E3AF")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:53:04.070 -0400", hash_original_method = "B42ED13DCD08C26044D05FD9CDF469CF", hash_generated_method = "C34168734A5EE240E01197576692E5DD")
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
            byte[] var99E4F7F59DC442B21AA2E171B7120389_776037577 = (baos.toByteArray());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:53:04.099 -0400", hash_original_method = "1F6A50EAF05C581243DFC8EDF15FF940", hash_generated_method = "1541FE7306546CCD285AEF72C7902596")
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
        } //End block
        catch (IOException e)
        {
            log(e);
        } //End block
        return (SSLSession)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:53:04.116 -0400", hash_original_method = "C269704A4F254C894FBE48E4ADC3F7DA", hash_generated_method = "F98D62C964C804D2535091C478114790")
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
            boolean var784A1CDA62AB9B2C753832FCE828B745_450735673 = (session != null && session.isValid());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:53:04.144 -0400", hash_original_method = "01E7B06223DFEA7D5DECA9A679FEAED7", hash_generated_method = "B77D3D9F5CEA658D3685731B45F61FEF")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:53:04.156 -0400", hash_original_method = "3A6F397C175F2D6C1475AA31D913F50C", hash_generated_method = "C4AF5DE8488C50BF001E56A5628D4AAD")
    static void log(Throwable t) {
        System.logW("Error converting session.", t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:53:04.164 -0400", hash_original_method = "F38656E203DF2568CDB8FB5A6C876744", hash_generated_method = "9874B9F3B2F7E2D9D53ED9CD9339E158")
    @DSModeled(DSC.SAFE)
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

    
}


