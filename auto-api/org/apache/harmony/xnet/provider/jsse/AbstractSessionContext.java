package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.583 -0400", hash_original_field = "F7558008F30251ED687039538F2EE14F", hash_generated_field = "7A30EE95E508037D9FEE1354CEFAC193")

    volatile int maximumSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.583 -0400", hash_original_field = "90272DDA245AE1FB3CF197E91A8689DC", hash_generated_field = "66A9610107B22FE560E0442C7F3278C6")

    volatile int timeout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.584 -0400", hash_original_field = "D010BAA5FA490CA90193AD7819E7A15C", hash_generated_field = "ECA4AAD8222BFFC05678F5BBEB12C033")

    final int sslCtxNativePointer = NativeCrypto.SSL_CTX_new();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.584 -0400", hash_original_field = "BA23DE027615123BDB3690D617C0A3EB", hash_generated_field = "5BF57BED3AD0AD3FD0B289A8ACE951DB")

    private final Map<ByteArray, SSLSession> sessions = new LinkedHashMap<ByteArray, SSLSession>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.584 -0400", hash_original_method = "50C1CC90C9158408C79488CFE262DC7E", hash_generated_method = "BAE616B55944ED5CF16B043FC04F885E")
        @Override
        protected boolean removeEldestEntry(
                Map.Entry<ByteArray, SSLSession> eldest) {
            boolean var952E6B41D9F0F5AC085097F04FB5925E_687209161 = (maximumSize > 0 && size() > maximumSize);
            addTaint(eldest.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_116793199 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_116793199;
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.584 -0400", hash_original_method = "B86A9D4A1D1D4BFB528024933586DA07", hash_generated_method = "2BA638231C8AD53D155EB67E486801A1")
      AbstractSessionContext(int maximumSize, int timeout) {
        this.maximumSize = maximumSize;
        this.timeout = timeout;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.585 -0400", hash_original_method = "A58241B75AD2B44C3E74E917DCCEF491", hash_generated_method = "084FA848A9C06FEE45B3A9D37D5C3F4B")
    private Iterator<SSLSession> sessionIterator() {
        Iterator<SSLSession> varB4EAC82CA7396A68D541C85D26508E83_1520124794 = null; 
        {
            SSLSession[] array = sessions.values().toArray(
                    new SSLSession[sessions.size()]);
            varB4EAC82CA7396A68D541C85D26508E83_1520124794 = Arrays.asList(array).iterator();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1520124794.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1520124794;
        
        
            
                    
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.585 -0400", hash_original_method = "106825D731C9327C3D7A99A6486CA67E", hash_generated_method = "F78F5354953ACC6AA4458996FCC9996A")
    public final Enumeration getIds() {
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_987793268 = null; 
        final Iterator<SSLSession> i = sessionIterator();
        varB4EAC82CA7396A68D541C85D26508E83_987793268 = new Enumeration<byte[]>() {
            private SSLSession next;
            public boolean hasMoreElements() {
                if (next != null) {
                    return true;
                }
                while (i.hasNext()) {
                    SSLSession session = i.next();
                    if (session.isValid()) {
                        next = session;
                        return true;
                    }
                }
                next = null;
                return false;
            }
            public byte[] nextElement() {
                if (hasMoreElements()) {
                    byte[] id = next.getId();
                    next = null;
                    return id;
                }
                throw new NoSuchElementException();
            }
        };
        varB4EAC82CA7396A68D541C85D26508E83_987793268.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_987793268;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.585 -0400", hash_original_method = "D0015EDFECCAD43C3752A19176DA2F6D", hash_generated_method = "51A180BAA33E56BC47B97F819E662973")
    public final int getSessionCacheSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2121808335 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2121808335;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.586 -0400", hash_original_method = "4FB73E0AB538272543472A54EAEE75CD", hash_generated_method = "41A6BEC0E4F767737F0D69BC48EE33D1")
    public final int getSessionTimeout() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_688356875 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_688356875;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.586 -0400", hash_original_method = "8615761B2210F074D79DA775AC19AA71", hash_generated_method = "F1DB472A8899F68E4BB4A56ABEDEF605")
    protected void trimToSize() {
        {
            int size = sessions.size();
            {
                int removals = size - maximumSize;
                Iterator<SSLSession> i = sessions.values().iterator();
                {
                    SSLSession session = i.next();
                    i.remove();
                    sessionRemoved(session);
                } 
            } 
        } 
        
        
            
            
                
                
                
                    
                    
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.587 -0400", hash_original_method = "39A7527C252FC67E9B785D11757CBC70", hash_generated_method = "E68DBEDD4623689071FB9D0B225B9107")
    public void setSessionTimeout(int seconds) throws IllegalArgumentException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("seconds < 0");
        } 
        timeout = seconds;
        {
            Iterator<SSLSession> i = sessions.values().iterator();
            {
                boolean varD8B5E52A597500CBD863E52A46B42708_1164717136 = (i.hasNext());
                {
                    SSLSession session = i.next();
                    {
                        boolean var5781757318888F5EAFBBB43D777C1BE7_2035692966 = (!session.isValid());
                        {
                            i.remove();
                            sessionRemoved(session);
                        } 
                    } 
                } 
            } 
        } 
        
        
            
        
        
        
            
            
                
                
                    
                    
                
            
        
    }

    
    protected abstract void sessionRemoved(SSLSession session);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.589 -0400", hash_original_method = "ACCBBC1F3ACDB7C97A3E02614B766E1C", hash_generated_method = "6DD2841AA6902A616CB36B9F133595BD")
    public final void setSessionCacheSize(int size) throws IllegalArgumentException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size < 0");
        } 
        int oldMaximum = maximumSize;
        maximumSize = size;
        {
            trimToSize();
        } 
        
        
            
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.596 -0400", hash_original_method = "B42ED13DCD08C26044D05FD9CDF469CF", hash_generated_method = "C51ECEB4454979280A42DA7EBFC50B28")
     byte[] toBytes(SSLSession session) {
        OpenSSLSessionImpl sslSession = (OpenSSLSessionImpl) session;
        try 
        {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream daos = new DataOutputStream(baos);
            daos.writeInt(OPEN_SSL);
            byte[] data = sslSession.getEncoded();
            daos.writeInt(data.length);
            daos.write(data);
            Certificate[] certs = session.getPeerCertificates();
            daos.writeInt(certs.length);
            {
                Certificate cert = certs[0];
                {
                    data = cert.getEncoded();
                    daos.writeInt(data.length);
                    daos.write(data);
                } 
            } 
            byte[] var99E4F7F59DC442B21AA2E171B7120389_1879956373 = (baos.toByteArray());
        } 
        catch (IOException e)
        {
            log(e);
        } 
        catch (CertificateEncodingException e)
        {
            log(e);
        } 
        addTaint(session.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1250908904 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1250908904;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.597 -0400", hash_original_method = "1F6A50EAF05C581243DFC8EDF15FF940", hash_generated_method = "57A656108E2E6A605B0594F033BC11A1")
     SSLSession toSession(byte[] data, String host, int port) {
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_444377047 = null; 
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_967356401 = null; 
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_558889416 = null; 
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        DataInputStream dais = new DataInputStream(bais);
        try 
        {
            int type = dais.readInt();
            {
                log(new AssertionError("Unexpected type ID: " + type));
                varB4EAC82CA7396A68D541C85D26508E83_444377047 = null;
            } 
            int length = dais.readInt();
            byte[] sessionData = new byte[length];
            dais.readFully(sessionData);
            int count = dais.readInt();
            X509CertImpl[] certs = new X509CertImpl[count];
            {
                int i = 0;
                {
                    length = dais.readInt();
                    byte[] certData = new byte[length];
                    dais.readFully(certData);
                    certs[i] = new X509CertImpl(certData);
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_967356401 = new OpenSSLSessionImpl(sessionData, host, port, certs, this);
        } 
        catch (IOException e)
        {
            log(e);
            varB4EAC82CA7396A68D541C85D26508E83_558889416 = null;
        } 
        addTaint(data[0]);
        addTaint(host.getTaint());
        addTaint(port);
        SSLSession varA7E53CE21691AB073D9660D615818899_493689515; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_493689515 = varB4EAC82CA7396A68D541C85D26508E83_444377047;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_493689515 = varB4EAC82CA7396A68D541C85D26508E83_967356401;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_493689515 = varB4EAC82CA7396A68D541C85D26508E83_558889416;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_493689515.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_493689515;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.598 -0400", hash_original_method = "C269704A4F254C894FBE48E4ADC3F7DA", hash_generated_method = "373F04E9DD211B779CAEA5B358D747B4")
    public SSLSession getSession(byte[] sessionId) {
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_251088820 = null; 
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_2110233882 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("sessionId == null");
        } 
        ByteArray key = new ByteArray(sessionId);
        SSLSession session;
        {
            session = sessions.get(key);
        } 
        {
            boolean var784A1CDA62AB9B2C753832FCE828B745_2063265566 = (session != null && session.isValid());
            {
                varB4EAC82CA7396A68D541C85D26508E83_251088820 = session;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2110233882 = null;
        addTaint(sessionId[0]);
        SSLSession varA7E53CE21691AB073D9660D615818899_1474675394; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1474675394 = varB4EAC82CA7396A68D541C85D26508E83_251088820;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1474675394 = varB4EAC82CA7396A68D541C85D26508E83_2110233882;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1474675394.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1474675394;
        
        
            
        
        
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.599 -0400", hash_original_method = "01E7B06223DFEA7D5DECA9A679FEAED7", hash_generated_method = "89C45D5BB447414713850C3E48C17315")
     void putSession(SSLSession session) {
        byte[] id = session.getId();
        ByteArray key = new ByteArray(id);
        {
            sessions.put(key, session);
        } 
        addTaint(session.getTaint());
        
        
        
            
        
        
        
            
        
    }

    
        @DSModeled(DSC.SAFE)
    static void log(Throwable t) {
        System.logW("Error converting session.", t);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.600 -0400", hash_original_method = "F38656E203DF2568CDB8FB5A6C876744", hash_generated_method = "415C95D5B1D7C63D7DD32000B7CCE6AC")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            NativeCrypto.SSL_CTX_free(sslCtxNativePointer);
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.600 -0400", hash_original_field = "926D9B14F0F0E3D940ACF8FD74B8BEC9", hash_generated_field = "53E86EE3900A5BFC3BD52A7722DFD982")

    static final int OPEN_SSL = 1;
}

