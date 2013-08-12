package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.annotations.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.863 -0400", hash_original_field = "F7558008F30251ED687039538F2EE14F", hash_generated_field = "7A30EE95E508037D9FEE1354CEFAC193")

    volatile int maximumSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.863 -0400", hash_original_field = "90272DDA245AE1FB3CF197E91A8689DC", hash_generated_field = "66A9610107B22FE560E0442C7F3278C6")

    volatile int timeout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.863 -0400", hash_original_field = "D010BAA5FA490CA90193AD7819E7A15C", hash_generated_field = "ECA4AAD8222BFFC05678F5BBEB12C033")

    final int sslCtxNativePointer = NativeCrypto.SSL_CTX_new();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.584 -0400", hash_original_field = "BA23DE027615123BDB3690D617C0A3EB", hash_generated_field = "5BF57BED3AD0AD3FD0B289A8ACE951DB")

    private final Map<ByteArray, SSLSession> sessions = new LinkedHashMap<ByteArray, SSLSession>() {        
        @DSModeled(DSC.SAFE)
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
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.863 -0400", hash_original_method = "B86A9D4A1D1D4BFB528024933586DA07", hash_generated_method = "2BA638231C8AD53D155EB67E486801A1")
      AbstractSessionContext(int maximumSize, int timeout) {
        this.maximumSize = maximumSize;
        this.timeout = timeout;
        // ---------- Original Method ----------
        //this.maximumSize = maximumSize;
        //this.timeout = timeout;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.864 -0400", hash_original_method = "A58241B75AD2B44C3E74E917DCCEF491", hash_generated_method = "FF1873F15E796F1752209DFF882F3FA7")
    private Iterator<SSLSession> sessionIterator() {
        synchronized
(sessions)        {
            SSLSession[] array = sessions.values().toArray(
                    new SSLSession[sessions.size()]);
Iterator<SSLSession> varE7DE1FD668E3CBBA265EA6B0639F2D9B_413036224 =             Arrays.asList(array).iterator();
            varE7DE1FD668E3CBBA265EA6B0639F2D9B_413036224.addTaint(taint);
            return varE7DE1FD668E3CBBA265EA6B0639F2D9B_413036224;
        } //End block
        // ---------- Original Method ----------
        //synchronized (sessions) {
            //SSLSession[] array = sessions.values().toArray(
                    //new SSLSession[sessions.size()]);
            //return Arrays.asList(array).iterator();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.867 -0400", hash_original_method = "106825D731C9327C3D7A99A6486CA67E", hash_generated_method = "B96C8C2AC40960BB4C3ECC38AF01B30E")
    public final Enumeration getIds() {
        final Iterator<SSLSession> i = sessionIterator();
Enumeration varF6BBB41F8B560415F4CBC1CD8616FD15_54913296 =         new Enumeration<byte[]>() {        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.865 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "CDB303F1DF3E89A69F752AB14511AB93")
        private SSLSession next;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.866 -0400", hash_original_method = "ECED6E9B0C3B7E941FD6E8C079DAFC6A", hash_generated_method = "BC58D80EAC5CFA1CBD1C72F905F30403")
        public boolean hasMoreElements() {
            if(next != null)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1554723885 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_175280307 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_175280307;
            } //End block
            while
(i.hasNext())            
            {
                SSLSession session = i.next();
                if(session.isValid())                
                {
                    next = session;
                    boolean varB326B5062B2F0E69046810717534CB09_983116522 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_361987457 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_361987457;
                } //End block
            } //End block
            next = null;
            boolean var68934A3E9455FA72420237EB05902327_1010110135 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1956648207 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1956648207;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.866 -0400", hash_original_method = "7968D7DCCB027A5D41A2AFCAEBC6C83D", hash_generated_method = "7E54B5C5EDC9D98B6A52753D65E6CF97")
        public byte[] nextElement() {
            if(hasMoreElements())            
            {
                byte[] id = next.getId();
                next = null;
                byte[] varB80BB7740288FDA1F201890375A60C8F_2066350781 = (id);
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_885371449 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_885371449;
            } //End block
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_1141696600 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_1141696600.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_1141696600;
            // ---------- Original Method ----------
            //if (hasMoreElements()) {
                    //byte[] id = next.getId();
                    //next = null;
                    //return id;
                //}
            //throw new NoSuchElementException();
        }
};
        varF6BBB41F8B560415F4CBC1CD8616FD15_54913296.addTaint(taint);
        return varF6BBB41F8B560415F4CBC1CD8616FD15_54913296;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.867 -0400", hash_original_method = "D0015EDFECCAD43C3752A19176DA2F6D", hash_generated_method = "2CE21228527FC30659ABFE29C0FE9312")
    public final int getSessionCacheSize() {
        int varF7558008F30251ED687039538F2EE14F_1080619653 = (maximumSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464209143 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464209143;
        // ---------- Original Method ----------
        //return maximumSize;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.868 -0400", hash_original_method = "4FB73E0AB538272543472A54EAEE75CD", hash_generated_method = "119D9FE432EDD91C0573B29749845996")
    public final int getSessionTimeout() {
        int var90272DDA245AE1FB3CF197E91A8689DC_488385831 = (timeout);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2058426109 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2058426109;
        // ---------- Original Method ----------
        //return timeout;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.868 -0400", hash_original_method = "8615761B2210F074D79DA775AC19AA71", hash_generated_method = "B65EE0CB0AAF519D51F592B9833FAAA0")
    protected void trimToSize() {
        synchronized
(sessions)        {
            int size = sessions.size();
            if(size > maximumSize)            
            {
                int removals = size - maximumSize;
                Iterator<SSLSession> i = sessions.values().iterator();
                do {
                    {
                        SSLSession session = i.next();
                        i.remove();
                        sessionRemoved(session);
                    } //End block
} while (--removals > 0);
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.869 -0400", hash_original_method = "39A7527C252FC67E9B785D11757CBC70", hash_generated_method = "017C63B855A79C87A9D2174419D03758")
    public void setSessionTimeout(int seconds) throws IllegalArgumentException {
        if(seconds < 0)        
        {
            IllegalArgumentException varDD2C31E3868F1B0ECB3F0404533DD6FF_974767402 = new IllegalArgumentException("seconds < 0");
            varDD2C31E3868F1B0ECB3F0404533DD6FF_974767402.addTaint(taint);
            throw varDD2C31E3868F1B0ECB3F0404533DD6FF_974767402;
        } //End block
        timeout = seconds;
        synchronized
(sessions)        {
            Iterator<SSLSession> i = sessions.values().iterator();
            while
(i.hasNext())            
            {
                SSLSession session = i.next();
                if(!session.isValid())                
                {
                    i.remove();
                    sessionRemoved(session);
                } //End block
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    protected abstract void sessionRemoved(SSLSession session);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.870 -0400", hash_original_method = "ACCBBC1F3ACDB7C97A3E02614B766E1C", hash_generated_method = "E32BDC099E178DAC2DECF9DB58D45C36")
    public final void setSessionCacheSize(int size) throws IllegalArgumentException {
        if(size < 0)        
        {
            IllegalArgumentException var2382BBC2482763F398967EC587DEA9AE_774542038 = new IllegalArgumentException("size < 0");
            var2382BBC2482763F398967EC587DEA9AE_774542038.addTaint(taint);
            throw var2382BBC2482763F398967EC587DEA9AE_774542038;
        } //End block
        int oldMaximum = maximumSize;
        maximumSize = size;
        if(size < oldMaximum)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.871 -0400", hash_original_method = "B42ED13DCD08C26044D05FD9CDF469CF", hash_generated_method = "C2C2AE06FE512DF2A97A977CE047B42B")
     byte[] toBytes(SSLSession session) {
        addTaint(session.getTaint());
        if(!(session instanceof OpenSSLSessionImpl))        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_2133764456 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1308605735 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1308605735;
        } //End block
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
for(Certificate cert : certs)
            {
                data = cert.getEncoded();
                daos.writeInt(data.length);
                daos.write(data);
            } //End block
            byte[] varC8074949A93D391136C4F0EAA54243E5_1725595814 = (baos.toByteArray());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2127445990 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_2127445990;
        } //End block
        catch (IOException e)
        {
            log(e);
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_504865977 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_15138120 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_15138120;
        } //End block
        catch (CertificateEncodingException e)
        {
            log(e);
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1960314772 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_415222857 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_415222857;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.873 -0400", hash_original_method = "1F6A50EAF05C581243DFC8EDF15FF940", hash_generated_method = "B550CA0925FE4C4192AD7AE619DE4FFB")
     SSLSession toSession(byte[] data, String host, int port) {
        addTaint(port);
        addTaint(host.getTaint());
        addTaint(data[0]);
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        DataInputStream dais = new DataInputStream(bais);
        try 
        {
            int type = dais.readInt();
            if(type != OPEN_SSL)            
            {
                log(new AssertionError("Unexpected type ID: " + type));
SSLSession var540C13E9E156B687226421B24F2DF178_630952063 =                 null;
                var540C13E9E156B687226421B24F2DF178_630952063.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_630952063;
            } //End block
            int length = dais.readInt();
            byte[] sessionData = new byte[length];
            dais.readFully(sessionData);
            int count = dais.readInt();
            X509CertImpl[] certs = new X509CertImpl[count];
for(int i = 0;i < count;i++)
            {
                length = dais.readInt();
                byte[] certData = new byte[length];
                dais.readFully(certData);
                certs[i] = new X509CertImpl(certData);
            } //End block
SSLSession var84AB2E1B3000FC8F6DE25653ECE56C54_1518644862 =             new OpenSSLSessionImpl(sessionData, host, port, certs, this);
            var84AB2E1B3000FC8F6DE25653ECE56C54_1518644862.addTaint(taint);
            return var84AB2E1B3000FC8F6DE25653ECE56C54_1518644862;
        } //End block
        catch (IOException e)
        {
            log(e);
SSLSession var540C13E9E156B687226421B24F2DF178_736592433 =             null;
            var540C13E9E156B687226421B24F2DF178_736592433.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_736592433;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.876 -0400", hash_original_method = "C269704A4F254C894FBE48E4ADC3F7DA", hash_generated_method = "E2162FC62B3D01A26585EE79E85AD654")
    public SSLSession getSession(byte[] sessionId) {
        addTaint(sessionId[0]);
        if(sessionId == null)        
        {
            NullPointerException var6FE05A4D95E15DCE22A2066FE5B04F68_1168187567 = new NullPointerException("sessionId == null");
            var6FE05A4D95E15DCE22A2066FE5B04F68_1168187567.addTaint(taint);
            throw var6FE05A4D95E15DCE22A2066FE5B04F68_1168187567;
        } //End block
        ByteArray key = new ByteArray(sessionId);
        SSLSession session;
        synchronized
(sessions)        {
            session = sessions.get(key);
        } //End block
        if(session != null && session.isValid())        
        {
SSLSession varD555E544A66E0F97DA6BCDE940E3E79C_1103520051 =             session;
            varD555E544A66E0F97DA6BCDE940E3E79C_1103520051.addTaint(taint);
            return varD555E544A66E0F97DA6BCDE940E3E79C_1103520051;
        } //End block
SSLSession var540C13E9E156B687226421B24F2DF178_2008277455 =         null;
        var540C13E9E156B687226421B24F2DF178_2008277455.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2008277455;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.877 -0400", hash_original_method = "01E7B06223DFEA7D5DECA9A679FEAED7", hash_generated_method = "56E46675B2DACAAFBD15DCD7A9590ED2")
     void putSession(SSLSession session) {
        addTaint(session.getTaint());
        byte[] id = session.getId();
        if(id.length == 0)        
        {
            return;
        } //End block
        ByteArray key = new ByteArray(id);
        synchronized
(sessions)        {
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

    
    @DSModeled(DSC.SPEC)
    static void log(Throwable t) {
        System.logW("Error converting session.", t);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.878 -0400", hash_original_method = "F38656E203DF2568CDB8FB5A6C876744", hash_generated_method = "415C95D5B1D7C63D7DD32000B7CCE6AC")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.878 -0400", hash_original_field = "926D9B14F0F0E3D940ACF8FD74B8BEC9", hash_generated_field = "53E86EE3900A5BFC3BD52A7722DFD982")

    static final int OPEN_SSL = 1;
}

