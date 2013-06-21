package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLSession;

public class ClientSessionContext extends AbstractSessionContext {
    Map<HostAndPort, SSLSession> sessionsByHostAndPort
        = new HashMap<HostAndPort, SSLSession>();
    private SSLClientSessionCache persistentCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.665 -0400", hash_original_method = "6120BD96B39A4004425E377055807D67", hash_generated_method = "F659DA8BD462D7F6605B182211013349")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClientSessionContext() {
        super(10, 0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.665 -0400", hash_original_method = "6D75428DC9ADEDF784907D2671C869EF", hash_generated_method = "95349523639CCDCDCDE94FAF1BB310DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        int varB5AFB539594923F68E6D16A74F830496_1550749522 = (sessionsByHostAndPort.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sessionsByHostAndPort.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.666 -0400", hash_original_method = "FA4F1A172590244BE031F2E8797E17F3", hash_generated_method = "B99C304029FECABFFDEB77D913E1BE8E")
    @DSModeled(DSC.SAFE)
    public void setPersistentCache(SSLClientSessionCache persistentCache) {
        dsTaint.addTaint(persistentCache.dsTaint);
        // ---------- Original Method ----------
        //this.persistentCache = persistentCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.666 -0400", hash_original_method = "A3E2A8D686FD14337461D9600D56C1BC", hash_generated_method = "1EB3F04D2EC8DDA84AB71B0512F2DB58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void sessionRemoved(SSLSession session) {
        dsTaint.addTaint(session.dsTaint);
        String host;
        host = session.getPeerHost();
        int port;
        port = session.getPeerPort();
        HostAndPort hostAndPortKey;
        hostAndPortKey = new HostAndPort(host, port);
        {
            sessionsByHostAndPort.remove(hostAndPortKey);
        } //End block
        // ---------- Original Method ----------
        //String host = session.getPeerHost();
        //int port = session.getPeerPort();
        //if (host == null) {
            //return;
        //}
        //HostAndPort hostAndPortKey = new HostAndPort(host, port);
        //synchronized (sessionsByHostAndPort) {
            //sessionsByHostAndPort.remove(hostAndPortKey);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.666 -0400", hash_original_method = "B5A73604CB734A09BF7E857D2D91FD28", hash_generated_method = "804643B47178247A0C8CDDE2932B8F9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLSession getSession(String host, int port) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        SSLSession session;
        HostAndPort hostAndPortKey;
        hostAndPortKey = new HostAndPort(host, port);
        {
            session = sessionsByHostAndPort.get(hostAndPortKey);
        } //End block
        {
            boolean var784A1CDA62AB9B2C753832FCE828B745_2035192327 = (session != null && session.isValid());
        } //End collapsed parenthetic
        {
            byte[] data;
            data = persistentCache.getSessionData(host, port);
            {
                session = toSession(data, host, port);
                {
                    boolean varE0B94CD6DB7A63F5969E6C0C96C6CFF0_2051314460 = (session != null && session.isValid());
                    {
                        super.putSession(session);
                        {
                            sessionsByHostAndPort.put(hostAndPortKey, session);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        return (SSLSession)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.666 -0400", hash_original_method = "BD633AD4CEEF6AC5498C26DA8E919EC2", hash_generated_method = "F1CB6DAF6DDDA171547FB211E01A43C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void putSession(SSLSession session) {
        dsTaint.addTaint(session.dsTaint);
        super.putSession(session);
        String host;
        host = session.getPeerHost();
        int port;
        port = session.getPeerPort();
        HostAndPort hostAndPortKey;
        hostAndPortKey = new HostAndPort(host, port);
        {
            sessionsByHostAndPort.put(hostAndPortKey, session);
        } //End block
        {
            byte[] data;
            data = toBytes(session);
            {
                persistentCache.putSessionData(session, data);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //super.putSession(session);
        //String host = session.getPeerHost();
        //int port = session.getPeerPort();
        //if (host == null) {
            //return;
        //}
        //HostAndPort hostAndPortKey = new HostAndPort(host, port);
        //synchronized (sessionsByHostAndPort) {
            //sessionsByHostAndPort.put(hostAndPortKey, session);
        //}
        //if (persistentCache != null) {
            //byte[] data = toBytes(session);
            //if (data != null) {
                //persistentCache.putSessionData(session, data);
            //}
        //}
    }

    
    static class HostAndPort {
        String host;
        int port;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.667 -0400", hash_original_method = "EB165053DB1A3C349320DF850A0D5A85", hash_generated_method = "CD756DF45F2C703D0010A299D6F9FAE7")
        @DSModeled(DSC.SAFE)
         HostAndPort(String host, int port) {
            dsTaint.addTaint(port);
            dsTaint.addTaint(host);
            // ---------- Original Method ----------
            //this.host = host;
            //this.port = port;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.667 -0400", hash_original_method = "4275ECED88C546D6C48AA6C77D620659", hash_generated_method = "92682AE8B74C3C84A6C89E79D2603E88")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var7486CBF8614CDB9AEBCF903E96EF526C_105214997 = (host.hashCode() * 31 + port);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return host.hashCode() * 31 + port;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.667 -0400", hash_original_method = "B55E1F045FCFEF599209FA0277EB136A", hash_generated_method = "6F3F1D97BC7DD67D3A7DE1C125536115")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object o) {
            dsTaint.addTaint(o.dsTaint);
            HostAndPort lhs;
            lhs = (HostAndPort) o;
            boolean var5D96864B593BFC0377F29170A33FCDAC_182086423 = (host.equals(lhs.host) && port == lhs.port);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!(o instanceof HostAndPort)) {
                //return false;
            //}
            //HostAndPort lhs = (HostAndPort) o;
            //return host.equals(lhs.host) && port == lhs.port;
        }

        
    }


    
}

