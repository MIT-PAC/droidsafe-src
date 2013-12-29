package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.net.ssl.SSLSession;






public class ServerSessionContext extends AbstractSessionContext {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.870 -0500", hash_original_field = "E7EEAAE01EABB89BC3E379487CEBB368", hash_generated_field = "03372E20A94CFEB28F0443462F1FB862")


    private SSLServerSessionCache persistentCache;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.871 -0500", hash_original_method = "9FA739694DBACEAA071D2AEDBA51A05E", hash_generated_method = "9294AAB5FDC3944344DC26B8620D5739")
    public ServerSessionContext() {
        super(100, 0);

        // TODO make sure SSL_CTX does not automaticaly clear sessions we want it to cache
        // SSL_CTX_set_session_cache_mode(sslCtxNativePointer, SSL_SESS_CACHE_NO_AUTO_CLEAR);

        // TODO remove SSL_CTX session cache limit so we can manage it
        // SSL_CTX_sess_set_cache_size(sslCtxNativePointer, 0);

        // TODO override trimToSize and removeEldestEntry to use
        // SSL_CTX_sessions to remove from native cache
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.872 -0500", hash_original_method = "72569EA6711DBA1D81D9BBC862AD3D03", hash_generated_method = "0CE628A3442C9B41FB1AD0CD0840A6BD")
    public void setPersistentCache(SSLServerSessionCache persistentCache) {
        this.persistentCache = persistentCache;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.873 -0500", hash_original_method = "D4D4D8A9ED5E99BC7DD197F41DEEDD43", hash_generated_method = "5E399269F22ECC6C6D361AA835F3E0CE")
    protected void sessionRemoved(SSLSession session) {}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.874 -0500", hash_original_method = "B67FD63429286D10E1FBB2A9ED634511", hash_generated_method = "686501806461EE8B4EC98F9B766B54DC")
    @Override
public SSLSession getSession(byte[] sessionId) {
        SSLSession session = super.getSession(sessionId);
        if (session != null) {
            return session;
        }

        // Check persistent cache.
        if (persistentCache != null) {
            byte[] data = persistentCache.getSessionData(sessionId);
            if (data != null) {
                session = toSession(data, null, -1);
                if (session != null && session.isValid()) {
                    super.putSession(session);
                    return session;
                }
            }
        }

        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.874 -0500", hash_original_method = "6A881248A35D6FEA85AFAE8D9374366B", hash_generated_method = "FC7A1CB319997E6C38E03AB1A8EC0177")
    @Override
void putSession(SSLSession session) {
        super.putSession(session);

        // TODO: In background thread.
        if (persistentCache != null) {
            byte[] data = toBytes(session);
            if (data != null) {
                persistentCache.putSessionData(session, data);
            }
        }
    }

    
}

