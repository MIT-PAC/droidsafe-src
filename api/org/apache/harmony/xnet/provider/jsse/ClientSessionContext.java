package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLSession;

public class ClientSessionContext extends AbstractSessionContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.159 -0400", hash_original_field = "3FF53BDDBB229917E2937614A224DF58", hash_generated_field = "6BBAB5CB7036A257BD0B8ECD839C9B02")

    final Map<HostAndPort, SSLSession> sessionsByHostAndPort = new HashMap<HostAndPort, SSLSession>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.159 -0400", hash_original_field = "AA2F0669D76C361D6298E17FC081F394", hash_generated_field = "312837744C3EC509F2C946202771C82A")

    private SSLClientSessionCache persistentCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.159 -0400", hash_original_method = "6120BD96B39A4004425E377055807D67", hash_generated_method = "F659DA8BD462D7F6605B182211013349")
    public  ClientSessionContext() {
        super(10, 0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.159 -0400", hash_original_method = "6D75428DC9ADEDF784907D2671C869EF", hash_generated_method = "58C86601756FA83AC2F38E76A85EF87B")
    public int size() {
        int varA6F0EF27A4AA4518AF01C97064847341_245826431 = (sessionsByHostAndPort.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_890164112 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_890164112;
        // ---------- Original Method ----------
        //return sessionsByHostAndPort.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.160 -0400", hash_original_method = "FA4F1A172590244BE031F2E8797E17F3", hash_generated_method = "A79C5685284AC076EFF257C20CDA7F14")
    public void setPersistentCache(SSLClientSessionCache persistentCache) {
        this.persistentCache = persistentCache;
        // ---------- Original Method ----------
        //this.persistentCache = persistentCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.160 -0400", hash_original_method = "A3E2A8D686FD14337461D9600D56C1BC", hash_generated_method = "03817F8578F5112C2CA89E23CB9DF1C2")
    protected void sessionRemoved(SSLSession session) {
        addTaint(session.getTaint());
        String host = session.getPeerHost();
        int port = session.getPeerPort();
    if(host == null)        
        {
            return;
        } //End block
        HostAndPort hostAndPortKey = new HostAndPort(host, port);
        synchronized
(sessionsByHostAndPort)        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.161 -0400", hash_original_method = "B5A73604CB734A09BF7E857D2D91FD28", hash_generated_method = "74A8373E826BB8232C3A945BF0B13349")
    public SSLSession getSession(String host, int port) {
        addTaint(port);
        addTaint(host.getTaint());
    if(host == null)        
        {
SSLSession var540C13E9E156B687226421B24F2DF178_1465100384 =             null;
            var540C13E9E156B687226421B24F2DF178_1465100384.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1465100384;
        } //End block
        SSLSession session;
        HostAndPort hostAndPortKey = new HostAndPort(host, port);
        synchronized
(sessionsByHostAndPort)        {
            session = sessionsByHostAndPort.get(hostAndPortKey);
        } //End block
    if(session != null && session.isValid())        
        {
SSLSession varD555E544A66E0F97DA6BCDE940E3E79C_1209328730 =             session;
            varD555E544A66E0F97DA6BCDE940E3E79C_1209328730.addTaint(taint);
            return varD555E544A66E0F97DA6BCDE940E3E79C_1209328730;
        } //End block
    if(persistentCache != null)        
        {
            byte[] data = persistentCache.getSessionData(host, port);
    if(data != null)            
            {
                session = toSession(data, host, port);
    if(session != null && session.isValid())                
                {
                    super.putSession(session);
                    synchronized
(sessionsByHostAndPort)                    {
                        sessionsByHostAndPort.put(hostAndPortKey, session);
                    } //End block
SSLSession varD555E544A66E0F97DA6BCDE940E3E79C_632871615 =                     session;
                    varD555E544A66E0F97DA6BCDE940E3E79C_632871615.addTaint(taint);
                    return varD555E544A66E0F97DA6BCDE940E3E79C_632871615;
                } //End block
            } //End block
        } //End block
SSLSession var540C13E9E156B687226421B24F2DF178_104733301 =         null;
        var540C13E9E156B687226421B24F2DF178_104733301.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_104733301;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.161 -0400", hash_original_method = "BD633AD4CEEF6AC5498C26DA8E919EC2", hash_generated_method = "1ADC71ABEDFB96A3CD199D50F6278EB9")
    @Override
    public void putSession(SSLSession session) {
        addTaint(session.getTaint());
        super.putSession(session);
        String host = session.getPeerHost();
        int port = session.getPeerPort();
    if(host == null)        
        {
            return;
        } //End block
        HostAndPort hostAndPortKey = new HostAndPort(host, port);
        synchronized
(sessionsByHostAndPort)        {
            sessionsByHostAndPort.put(hostAndPortKey, session);
        } //End block
    if(persistentCache != null)        
        {
            byte[] data = toBytes(session);
    if(data != null)            
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.162 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "3EBF9FC23C14AE1E55EAA4D77C46C987")

        String host;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.162 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "5A948EF636511EF149269A68FE278AED")

        int port;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.162 -0400", hash_original_method = "EB165053DB1A3C349320DF850A0D5A85", hash_generated_method = "84EF2DBC1C64C3B8AF7BCB08B75838B4")
          HostAndPort(String host, int port) {
            this.host = host;
            this.port = port;
            // ---------- Original Method ----------
            //this.host = host;
            //this.port = port;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.163 -0400", hash_original_method = "4275ECED88C546D6C48AA6C77D620659", hash_generated_method = "2A62E42071A90061F880338D0AA449D6")
        @Override
        public int hashCode() {
            int var0E647E455323522CA08273F434480BED_266711972 = (host.hashCode() * 31 + port);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1313785164 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1313785164;
            // ---------- Original Method ----------
            //return host.hashCode() * 31 + port;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.163 -0400", hash_original_method = "B55E1F045FCFEF599209FA0277EB136A", hash_generated_method = "236F30496B206FDC62096E12415A7FA5")
        @Override
        public boolean equals(Object o) {
            addTaint(o.getTaint());
    if(!(o instanceof HostAndPort))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1915239876 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_586086148 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_586086148;
            } //End block
            HostAndPort lhs = (HostAndPort) o;
            boolean var45784A7547F187311A8A553C07904FBF_2108498369 = (host.equals(lhs.host) && port == lhs.port);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2142070385 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2142070385;
            // ---------- Original Method ----------
            //if (!(o instanceof HostAndPort)) {
                //return false;
            //}
            //HostAndPort lhs = (HostAndPort) o;
            //return host.equals(lhs.host) && port == lhs.port;
        }

        
    }


    
}

