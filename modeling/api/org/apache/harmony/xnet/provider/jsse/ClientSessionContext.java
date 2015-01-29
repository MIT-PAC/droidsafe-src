package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLSession;

public class ClientSessionContext extends AbstractSessionContext {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.895 -0500", hash_original_field = "8D4650520519101820222604BE50C58C", hash_generated_field = "6BBAB5CB7036A257BD0B8ECD839C9B02")

    final Map<HostAndPort, SSLSession> sessionsByHostAndPort
        = new HashMap<HostAndPort, SSLSession>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.897 -0500", hash_original_field = "68E3E9AE9EB24664C445AE1E81C958CE", hash_generated_field = "312837744C3EC509F2C946202771C82A")

    private SSLClientSessionCache persistentCache;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.899 -0500", hash_original_method = "6120BD96B39A4004425E377055807D67", hash_generated_method = "A4419D13A15EE70099AD7FEA18D3AF8C")
    
public ClientSessionContext() {
        super(10, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.901 -0500", hash_original_method = "6D75428DC9ADEDF784907D2671C869EF", hash_generated_method = "1A9A19F34ABBF910AF69BD205477F1D0")
    
public int size() {
        return sessionsByHostAndPort.size();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.904 -0500", hash_original_method = "FA4F1A172590244BE031F2E8797E17F3", hash_generated_method = "9743A63B835F93BCF3CF6564C22012A7")
    
public void setPersistentCache(SSLClientSessionCache persistentCache) {
        this.persistentCache = persistentCache;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.906 -0500", hash_original_method = "A3E2A8D686FD14337461D9600D56C1BC", hash_generated_method = "B606F646B83D7D8DFACAF32402E552FD")
    
protected void sessionRemoved(SSLSession session) {
        String host = session.getPeerHost();
        int port = session.getPeerPort();
        if (host == null) {
            return;
        }
        HostAndPort hostAndPortKey = new HostAndPort(host, port);
        synchronized (sessionsByHostAndPort) {
            sessionsByHostAndPort.remove(hostAndPortKey);
        }
    }

    /**
     * Finds a cached session for the given host name and port.
     *
     * @param host of server
     * @param port of server
     * @return cached session or null if none found
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.909 -0500", hash_original_method = "B5A73604CB734A09BF7E857D2D91FD28", hash_generated_method = "4CDF88E1D034D8E1D3F30AD404190826")
    
public SSLSession getSession(String host, int port) {
        if (host == null) {
            return null;
        }
        SSLSession session;
        HostAndPort hostAndPortKey = new HostAndPort(host, port);
        synchronized (sessionsByHostAndPort) {
            session = sessionsByHostAndPort.get(hostAndPortKey);
        }
        if (session != null && session.isValid()) {
            return session;
        }

        // Look in persistent cache.
        if (persistentCache != null) {
            byte[] data = persistentCache.getSessionData(host, port);
            if (data != null) {
                session = toSession(data, host, port);
                if (session != null && session.isValid()) {
                    super.putSession(session);
                    synchronized (sessionsByHostAndPort) {
                        sessionsByHostAndPort.put(hostAndPortKey, session);
                    }
                    return session;
                }
            }
        }

        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.912 -0500", hash_original_method = "BD633AD4CEEF6AC5498C26DA8E919EC2", hash_generated_method = "297360B0BA5CA4EC6DD447115972D149")
    
@Override
    public void putSession(SSLSession session) {
        super.putSession(session);

        String host = session.getPeerHost();
        int port = session.getPeerPort();
        if (host == null) {
            return;
        }

        HostAndPort hostAndPortKey = new HostAndPort(host, port);
        synchronized (sessionsByHostAndPort) {
            sessionsByHostAndPort.put(hostAndPortKey, session);
        }

        // TODO: This in a background thread.
        if (persistentCache != null) {
            byte[] data = toBytes(session);
            if (data != null) {
                persistentCache.putSessionData(session, data);
            }
        }
    }
    
    static class HostAndPort {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.915 -0500", hash_original_field = "3EBF9FC23C14AE1E55EAA4D77C46C987", hash_generated_field = "3EBF9FC23C14AE1E55EAA4D77C46C987")

         String host;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.917 -0500", hash_original_field = "5A948EF636511EF149269A68FE278AED", hash_generated_field = "5A948EF636511EF149269A68FE278AED")

         int port;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.920 -0500", hash_original_method = "EB165053DB1A3C349320DF850A0D5A85", hash_generated_method = "EB165053DB1A3C349320DF850A0D5A85")
        
HostAndPort(String host, int port) {
            this.host = host;
            this.port = port;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.922 -0500", hash_original_method = "4275ECED88C546D6C48AA6C77D620659", hash_generated_method = "0DE2937B74880CD8CD342299D9F829D5")
        
@Override public int hashCode() {
            return host.hashCode() * 31 + port;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.924 -0500", hash_original_method = "B55E1F045FCFEF599209FA0277EB136A", hash_generated_method = "BB250A2B7C9061ECB6E1D7745A7FEABC")
        
@Override public boolean equals(Object o) {
            if (!(o instanceof HostAndPort)) {
                return false;
            }
            HostAndPort lhs = (HostAndPort) o;
            return host.equals(lhs.host) && port == lhs.port;
        }
        
    }
    
}

