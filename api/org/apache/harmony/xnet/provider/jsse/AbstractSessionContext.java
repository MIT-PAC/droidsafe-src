package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.039 -0400", hash_original_field = "F7558008F30251ED687039538F2EE14F", hash_generated_field = "7A30EE95E508037D9FEE1354CEFAC193")

    volatile int maximumSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.039 -0400", hash_original_field = "90272DDA245AE1FB3CF197E91A8689DC", hash_generated_field = "66A9610107B22FE560E0442C7F3278C6")

    volatile int timeout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.039 -0400", hash_original_field = "D010BAA5FA490CA90193AD7819E7A15C", hash_generated_field = "ECA4AAD8222BFFC05678F5BBEB12C033")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.040 -0400", hash_original_method = "B86A9D4A1D1D4BFB528024933586DA07", hash_generated_method = "2BA638231C8AD53D155EB67E486801A1")
      AbstractSessionContext(int maximumSize, int timeout) {
        this.maximumSize = maximumSize;
        this.timeout = timeout;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.040 -0400", hash_original_method = "A58241B75AD2B44C3E74E917DCCEF491", hash_generated_method = "4014AB4A863F4C6018FD24153209E657")
    private Iterator<SSLSession> sessionIterator() {
        synchronized
(sessions)        {
            SSLSession[] array = sessions.values().toArray(
                    new SSLSession[sessions.size()]);
Iterator<SSLSession> varE7DE1FD668E3CBBA265EA6B0639F2D9B_1369547459 =             Arrays.asList(array).iterator();
            varE7DE1FD668E3CBBA265EA6B0639F2D9B_1369547459.addTaint(taint);
            return varE7DE1FD668E3CBBA265EA6B0639F2D9B_1369547459;
        } 
        
        
            
                    
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.042 -0400", hash_original_method = "106825D731C9327C3D7A99A6486CA67E", hash_generated_method = "E571A4D1D2B19D58753D7FE9B2699924")
    public final Enumeration getIds() {
        final Iterator<SSLSession> i = sessionIterator();
Enumeration varF6BBB41F8B560415F4CBC1CD8616FD15_1936634124 =         new Enumeration<byte[]>() {        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.041 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "CDB303F1DF3E89A69F752AB14511AB93")
        private SSLSession next;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.041 -0400", hash_original_method = "ECED6E9B0C3B7E941FD6E8C079DAFC6A", hash_generated_method = "F6B67B2352F3224AB4C07A1D79D2A1D8")
        public boolean hasMoreElements() {
    if(next != null)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1709095165 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_77740010 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_77740010;
            } 
            while
(i.hasNext())            
            {
                SSLSession session = i.next();
    if(session.isValid())                
                {
                    next = session;
                    boolean varB326B5062B2F0E69046810717534CB09_1256456301 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1341508858 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1341508858;
                } 
            } 
            next = null;
            boolean var68934A3E9455FA72420237EB05902327_537362430 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_608615161 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_608615161;
            
            
                    
                
            
                    
                    
                        
                        
                    
                
            
            
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.042 -0400", hash_original_method = "7968D7DCCB027A5D41A2AFCAEBC6C83D", hash_generated_method = "35260ABD89C978E2AA67AA2B16D895D0")
        public byte[] nextElement() {
    if(hasMoreElements())            
            {
                byte[] id = next.getId();
                next = null;
                byte[] varB80BB7740288FDA1F201890375A60C8F_607021926 = (id);
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_782932616 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_782932616;
            } 
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_1380366072 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_1380366072.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_1380366072;
            
            
                    
                    
                    
                
            
        }
};
        varF6BBB41F8B560415F4CBC1CD8616FD15_1936634124.addTaint(taint);
        return varF6BBB41F8B560415F4CBC1CD8616FD15_1936634124;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.043 -0400", hash_original_method = "D0015EDFECCAD43C3752A19176DA2F6D", hash_generated_method = "92630B822084A4BACFF457A759DE7294")
    public final int getSessionCacheSize() {
        int varF7558008F30251ED687039538F2EE14F_345498646 = (maximumSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1202802453 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1202802453;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.043 -0400", hash_original_method = "4FB73E0AB538272543472A54EAEE75CD", hash_generated_method = "FDFC178A517A7D5ECFE92639E34058B7")
    public final int getSessionTimeout() {
        int var90272DDA245AE1FB3CF197E91A8689DC_1337382572 = (timeout);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_805804812 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_805804812;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.044 -0400", hash_original_method = "8615761B2210F074D79DA775AC19AA71", hash_generated_method = "B65EE0CB0AAF519D51F592B9833FAAA0")
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
                    } 
} while (--removals > 0);
            } 
        } 
        
        
            
            
                
                
                
                    
                    
                    
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.044 -0400", hash_original_method = "39A7527C252FC67E9B785D11757CBC70", hash_generated_method = "6B2C4FCB1980CB329906ADFE1CEFC25C")
    public void setSessionTimeout(int seconds) throws IllegalArgumentException {
    if(seconds < 0)        
        {
            IllegalArgumentException varDD2C31E3868F1B0ECB3F0404533DD6FF_684996077 = new IllegalArgumentException("seconds < 0");
            varDD2C31E3868F1B0ECB3F0404533DD6FF_684996077.addTaint(taint);
            throw varDD2C31E3868F1B0ECB3F0404533DD6FF_684996077;
        } 
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
                } 
            } 
        } 
        
        
            
        
        
        
            
            
                
                
                    
                    
                
            
        
    }

    
    protected abstract void sessionRemoved(SSLSession session);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.045 -0400", hash_original_method = "ACCBBC1F3ACDB7C97A3E02614B766E1C", hash_generated_method = "31D4FC663A87FC85BAAB7B38A2564A29")
    public final void setSessionCacheSize(int size) throws IllegalArgumentException {
    if(size < 0)        
        {
            IllegalArgumentException var2382BBC2482763F398967EC587DEA9AE_1184405721 = new IllegalArgumentException("size < 0");
            var2382BBC2482763F398967EC587DEA9AE_1184405721.addTaint(taint);
            throw var2382BBC2482763F398967EC587DEA9AE_1184405721;
        } 
        int oldMaximum = maximumSize;
        maximumSize = size;
    if(size < oldMaximum)        
        {
            trimToSize();
        } 
        
        
            
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.046 -0400", hash_original_method = "B42ED13DCD08C26044D05FD9CDF469CF", hash_generated_method = "746EF51B7C30B1ECCC52F22FA9FB9D32")
     byte[] toBytes(SSLSession session) {
        addTaint(session.getTaint());
    if(!(session instanceof OpenSSLSessionImpl))        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_269514593 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1837111401 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1837111401;
        } 
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
            } 
            byte[] varC8074949A93D391136C4F0EAA54243E5_56823673 = (baos.toByteArray());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_181133463 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_181133463;
        } 
        catch (IOException e)
        {
            log(e);
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_2025111207 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_816652178 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_816652178;
        } 
        catch (CertificateEncodingException e)
        {
            log(e);
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_640407480 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_276820385 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_276820385;
        } 
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.047 -0400", hash_original_method = "1F6A50EAF05C581243DFC8EDF15FF940", hash_generated_method = "22D36EF54D25F609FB4DEF5FCCBDEDCE")
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
SSLSession var540C13E9E156B687226421B24F2DF178_1861975189 =                 null;
                var540C13E9E156B687226421B24F2DF178_1861975189.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1861975189;
            } 
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
            } 
SSLSession var84AB2E1B3000FC8F6DE25653ECE56C54_527478291 =             new OpenSSLSessionImpl(sessionData, host, port, certs, this);
            var84AB2E1B3000FC8F6DE25653ECE56C54_527478291.addTaint(taint);
            return var84AB2E1B3000FC8F6DE25653ECE56C54_527478291;
        } 
        catch (IOException e)
        {
            log(e);
SSLSession var540C13E9E156B687226421B24F2DF178_1877852270 =             null;
            var540C13E9E156B687226421B24F2DF178_1877852270.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1877852270;
        } 
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.048 -0400", hash_original_method = "C269704A4F254C894FBE48E4ADC3F7DA", hash_generated_method = "037C39F8F1A0533A5728C40FC355E7C8")
    public SSLSession getSession(byte[] sessionId) {
        addTaint(sessionId[0]);
    if(sessionId == null)        
        {
            NullPointerException var6FE05A4D95E15DCE22A2066FE5B04F68_246296059 = new NullPointerException("sessionId == null");
            var6FE05A4D95E15DCE22A2066FE5B04F68_246296059.addTaint(taint);
            throw var6FE05A4D95E15DCE22A2066FE5B04F68_246296059;
        } 
        ByteArray key = new ByteArray(sessionId);
        SSLSession session;
        synchronized
(sessions)        {
            session = sessions.get(key);
        } 
    if(session != null && session.isValid())        
        {
SSLSession varD555E544A66E0F97DA6BCDE940E3E79C_1115430951 =             session;
            varD555E544A66E0F97DA6BCDE940E3E79C_1115430951.addTaint(taint);
            return varD555E544A66E0F97DA6BCDE940E3E79C_1115430951;
        } 
SSLSession var540C13E9E156B687226421B24F2DF178_454155010 =         null;
        var540C13E9E156B687226421B24F2DF178_454155010.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_454155010;
        
        
            
        
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.048 -0400", hash_original_method = "01E7B06223DFEA7D5DECA9A679FEAED7", hash_generated_method = "56E46675B2DACAAFBD15DCD7A9590ED2")
     void putSession(SSLSession session) {
        addTaint(session.getTaint());
        byte[] id = session.getId();
    if(id.length == 0)        
        {
            return;
        } 
        ByteArray key = new ByteArray(id);
        synchronized
(sessions)        {
            sessions.put(key, session);
        } 
        
        
        
            
        
        
        
            
        
    }

    
        @DSModeled(DSC.SPEC)
    static void log(Throwable t) {
        System.logW("Error converting session.", t);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.049 -0400", hash_original_method = "F38656E203DF2568CDB8FB5A6C876744", hash_generated_method = "415C95D5B1D7C63D7DD32000B7CCE6AC")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.049 -0400", hash_original_field = "926D9B14F0F0E3D940ACF8FD74B8BEC9", hash_generated_field = "53E86EE3900A5BFC3BD52A7722DFD982")

    static final int OPEN_SSL = 1;
}

