package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.739 -0500", hash_original_method = "3A6F397C175F2D6C1475AA31D913F50C", hash_generated_method = "C4AF5DE8488C50BF001E56A5628D4AAD")
    
static void log(Throwable t) {
        System.logW("Error converting session.", t);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.691 -0500", hash_original_field = "C9F10DBB8FC258C75032872F0523BC2D", hash_generated_field = "53E86EE3900A5BFC3BD52A7722DFD982")

    static final int OPEN_SSL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.684 -0500", hash_original_field = "3B2E03B648ADD645927E4F8A923F302D", hash_generated_field = "7A30EE95E508037D9FEE1354CEFAC193")

    volatile int maximumSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.686 -0500", hash_original_field = "884A23FAAA5E3251B7E5FE4A3FE97CA1", hash_generated_field = "66A9610107B22FE560E0442C7F3278C6")

    volatile int timeout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.688 -0500", hash_original_field = "252155234ECFEA9B5523A07896E7063B", hash_generated_field = "ECA4AAD8222BFFC05678F5BBEB12C033")

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

    /**
     * Constructs a new session context.
     *
     * @param maximumSize of cache
     * @param timeout for cache entries
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.699 -0500", hash_original_method = "B86A9D4A1D1D4BFB528024933586DA07", hash_generated_method = "B86A9D4A1D1D4BFB528024933586DA07")
    
AbstractSessionContext(int maximumSize, int timeout) {
        this.maximumSize = maximumSize;
        this.timeout = timeout;
    }

    /**
     * Returns the collection of sessions ordered from oldest to newest
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.701 -0500", hash_original_method = "A58241B75AD2B44C3E74E917DCCEF491", hash_generated_method = "215F523582B3EE7C120B8C74154E005E")
    
private Iterator<SSLSession> sessionIterator() {
        synchronized (sessions) {
            SSLSession[] array = sessions.values().toArray(
                    new SSLSession[sessions.size()]);
            return Arrays.asList(array).iterator();
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.712 -0500", hash_original_method = "106825D731C9327C3D7A99A6486CA67E", hash_generated_method = "CC9DF34A26927DEAD2570F68D3C37643")
    
public final Enumeration getIds() {
        final Iterator<SSLSession> i = sessionIterator();
        return new Enumeration<byte[]>() {
            private SSLSession next;
            @DSSafe(DSCat.SAFE_OTHERS)
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
            @DSSafe(DSCat.SAFE_OTHERS)
        public byte[] nextElement() {
                if (hasMoreElements()) {
                    byte[] id = next.getId();
                    next = null;
                    return id;
                }
                throw new NoSuchElementException();
            }
        };
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.714 -0500", hash_original_method = "D0015EDFECCAD43C3752A19176DA2F6D", hash_generated_method = "F0EBFE5E7F902D90C766F622695BC03B")
    
public final int getSessionCacheSize() {
        return maximumSize;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.717 -0500", hash_original_method = "4FB73E0AB538272543472A54EAEE75CD", hash_generated_method = "C50CE6E687111402FF4DE12D51A55364")
    
public final int getSessionTimeout() {
        return timeout;
    }

    /**
     * Makes sure cache size is < maximumSize.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.719 -0500", hash_original_method = "8615761B2210F074D79DA775AC19AA71", hash_generated_method = "40A9876A6B3EAF3C82AAFB29DE7EA0E5")
    
protected void trimToSize() {
        synchronized (sessions) {
            int size = sessions.size();
            if (size > maximumSize) {
                int removals = size - maximumSize;
                Iterator<SSLSession> i = sessions.values().iterator();
                do {
                    SSLSession session = i.next();
                    i.remove();
                    sessionRemoved(session);
                } while (--removals > 0);
            }
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.722 -0500", hash_original_method = "39A7527C252FC67E9B785D11757CBC70", hash_generated_method = "9D88FD2BEFA99FD748CE0F874EC83014")
    
public void setSessionTimeout(int seconds)
            throws IllegalArgumentException {
        if (seconds < 0) {
            throw new IllegalArgumentException("seconds < 0");
        }
        timeout = seconds;

        synchronized (sessions) {
            Iterator<SSLSession> i = sessions.values().iterator();
            while (i.hasNext()) {
                SSLSession session = i.next();
                // SSLSession's know their context and consult the
                // timeout as part of their validity condition.
                if (!session.isValid()) {
                    i.remove();
                    sessionRemoved(session);
                }
            }
        }
    }

    /**
     * Called when a session is removed. Used by ClientSessionContext
     * to update its host-and-port based cache.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.724 -0500", hash_original_method = "8412ECD60BBEE2A0ADC657B1AA8071DE", hash_generated_method = "FE93B555E00C0291AAAED04329503CCC")
    
protected abstract void sessionRemoved(SSLSession session);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.726 -0500", hash_original_method = "ACCBBC1F3ACDB7C97A3E02614B766E1C", hash_generated_method = "98CDFCE0326B4E35895BD084229DFB7C")
    
public final void setSessionCacheSize(int size)
            throws IllegalArgumentException {
        if (size < 0) {
            throw new IllegalArgumentException("size < 0");
        }

        int oldMaximum = maximumSize;
        maximumSize = size;

        // Trim cache to size if necessary.
        if (size < oldMaximum) {
            trimToSize();
        }
    }

    /**
     * Converts the given session to bytes.
     *
     * @return session data as bytes or null if the session can't be converted
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.729 -0500", hash_original_method = "B42ED13DCD08C26044D05FD9CDF469CF", hash_generated_method = "352FEDC8FDC2993B8AFE5D3AE0423841")
    
byte[] toBytes(SSLSession session) {
        // TODO: Support SSLSessionImpl, too.
        if (!(session instanceof OpenSSLSessionImpl)) {
            return null;
        }

        OpenSSLSessionImpl sslSession = (OpenSSLSessionImpl) session;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream daos = new DataOutputStream(baos);

            daos.writeInt(OPEN_SSL); // session type ID

            // Session data.
            byte[] data = sslSession.getEncoded();
            daos.writeInt(data.length);
            daos.write(data);

            // Certificates.
            Certificate[] certs = session.getPeerCertificates();
            daos.writeInt(certs.length);

            for (Certificate cert : certs) {
                data = cert.getEncoded();
                daos.writeInt(data.length);
                daos.write(data);
            }
            // TODO: local certificates?

            return baos.toByteArray();
        } catch (IOException e) {
            log(e);
            return null;
        } catch (CertificateEncodingException e) {
            log(e);
            return null;
        }
    }

    /**
     * Creates a session from the given bytes.
     *
     * @return a session or null if the session can't be converted
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.732 -0500", hash_original_method = "1F6A50EAF05C581243DFC8EDF15FF940", hash_generated_method = "1F6A50EAF05C581243DFC8EDF15FF940")
    
SSLSession toSession(byte[] data, String host, int port) {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        DataInputStream dais = new DataInputStream(bais);
        try {
            int type = dais.readInt();
            if (type != OPEN_SSL) {
                log(new AssertionError("Unexpected type ID: " + type));
                return null;
            }

            int length = dais.readInt();
            byte[] sessionData = new byte[length];
            dais.readFully(sessionData);

            int count = dais.readInt();
            X509CertImpl[] certs = new X509CertImpl[count];
            for (int i = 0; i < count; i++) {
                length = dais.readInt();
                byte[] certData = new byte[length];
                dais.readFully(certData);
                certs[i] = new X509CertImpl(certData);
            }

            return new OpenSSLSessionImpl(sessionData, host, port, certs, this);
        } catch (IOException e) {
            log(e);
            return null;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.735 -0500", hash_original_method = "C269704A4F254C894FBE48E4ADC3F7DA", hash_generated_method = "D03819EE9B926AF234C3C351F04BB654")
    
public SSLSession getSession(byte[] sessionId) {
        if (sessionId == null) {
            throw new NullPointerException("sessionId == null");
        }
        ByteArray key = new ByteArray(sessionId);
        SSLSession session;
        synchronized (sessions) {
            session = sessions.get(key);
        }
        if (session != null && session.isValid()) {
            return session;
        }
        return null;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.737 -0500", hash_original_method = "01E7B06223DFEA7D5DECA9A679FEAED7", hash_generated_method = "01E7B06223DFEA7D5DECA9A679FEAED7")
    
void putSession(SSLSession session) {
        byte[] id = session.getId();
        if (id.length == 0) {
            return;
        }
        ByteArray key = new ByteArray(id);
        synchronized (sessions) {
            sessions.put(key, session);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:11.742 -0500", hash_original_method = "F38656E203DF2568CDB8FB5A6C876744", hash_generated_method = "B21566E80A2D5EBF94270E3732AA186A")
    
@Override protected void finalize() throws Throwable {
        try {
            NativeCrypto.SSL_CTX_free(sslCtxNativePointer);
        } finally {
            super.finalize();
        }
    }
}

