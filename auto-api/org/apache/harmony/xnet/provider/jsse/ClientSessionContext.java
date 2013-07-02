package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLSession;

public class ClientSessionContext extends AbstractSessionContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.913 -0400", hash_original_field = "3FF53BDDBB229917E2937614A224DF58", hash_generated_field = "6BBAB5CB7036A257BD0B8ECD839C9B02")

    final Map<HostAndPort, SSLSession> sessionsByHostAndPort = new HashMap<HostAndPort, SSLSession>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.913 -0400", hash_original_field = "AA2F0669D76C361D6298E17FC081F394", hash_generated_field = "312837744C3EC509F2C946202771C82A")

    private SSLClientSessionCache persistentCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.916 -0400", hash_original_method = "6120BD96B39A4004425E377055807D67", hash_generated_method = "F659DA8BD462D7F6605B182211013349")
    public  ClientSessionContext() {
        super(10, 0);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.917 -0400", hash_original_method = "6D75428DC9ADEDF784907D2671C869EF", hash_generated_method = "54D0FC0BDE58867DFB4F081AD0E5D65A")
    public int size() {
        int varB5AFB539594923F68E6D16A74F830496_386863283 = (sessionsByHostAndPort.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_938965673 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_938965673;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.917 -0400", hash_original_method = "FA4F1A172590244BE031F2E8797E17F3", hash_generated_method = "A79C5685284AC076EFF257C20CDA7F14")
    public void setPersistentCache(SSLClientSessionCache persistentCache) {
        this.persistentCache = persistentCache;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.918 -0400", hash_original_method = "A3E2A8D686FD14337461D9600D56C1BC", hash_generated_method = "E39F4C90C207E33B44EB1EC4CE51B264")
    protected void sessionRemoved(SSLSession session) {
        String host = session.getPeerHost();
        int port = session.getPeerPort();
        HostAndPort hostAndPortKey = new HostAndPort(host, port);
        {
            sessionsByHostAndPort.remove(hostAndPortKey);
        } 
        addTaint(session.getTaint());
        
        
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.919 -0400", hash_original_method = "B5A73604CB734A09BF7E857D2D91FD28", hash_generated_method = "4E8F68D1DBC8CE35CC1255F2918CE6FB")
    public SSLSession getSession(String host, int port) {
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_190038835 = null; 
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_44130288 = null; 
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_330765520 = null; 
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_1434688365 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_190038835 = null;
        } 
        SSLSession session;
        HostAndPort hostAndPortKey = new HostAndPort(host, port);
        {
            session = sessionsByHostAndPort.get(hostAndPortKey);
        } 
        {
            boolean var784A1CDA62AB9B2C753832FCE828B745_988335410 = (session != null && session.isValid());
            {
                varB4EAC82CA7396A68D541C85D26508E83_44130288 = session;
            } 
        } 
        {
            byte[] data = persistentCache.getSessionData(host, port);
            {
                session = toSession(data, host, port);
                {
                    boolean varE0B94CD6DB7A63F5969E6C0C96C6CFF0_300063943 = (session != null && session.isValid());
                    {
                        super.putSession(session);
                        {
                            sessionsByHostAndPort.put(hostAndPortKey, session);
                        } 
                        varB4EAC82CA7396A68D541C85D26508E83_330765520 = session;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1434688365 = null;
        addTaint(host.getTaint());
        addTaint(port);
        SSLSession varA7E53CE21691AB073D9660D615818899_871992998; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_871992998 = varB4EAC82CA7396A68D541C85D26508E83_190038835;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_871992998 = varB4EAC82CA7396A68D541C85D26508E83_44130288;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_871992998 = varB4EAC82CA7396A68D541C85D26508E83_330765520;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_871992998 = varB4EAC82CA7396A68D541C85D26508E83_1434688365;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_871992998.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_871992998;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.920 -0400", hash_original_method = "BD633AD4CEEF6AC5498C26DA8E919EC2", hash_generated_method = "034DEEDCD4B614B52C7FCDC3C0770E81")
    @Override
    public void putSession(SSLSession session) {
        super.putSession(session);
        String host = session.getPeerHost();
        int port = session.getPeerPort();
        HostAndPort hostAndPortKey = new HostAndPort(host, port);
        {
            sessionsByHostAndPort.put(hostAndPortKey, session);
        } 
        {
            byte[] data = toBytes(session);
            {
                persistentCache.putSessionData(session, data);
            } 
        } 
        addTaint(session.getTaint());
        
        
        
        
        
            
        
        
        
            
        
        
            
            
                
            
        
    }

    
    static class HostAndPort {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.920 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "3EBF9FC23C14AE1E55EAA4D77C46C987")

        String host;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.920 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "5A948EF636511EF149269A68FE278AED")

        int port;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.921 -0400", hash_original_method = "EB165053DB1A3C349320DF850A0D5A85", hash_generated_method = "84EF2DBC1C64C3B8AF7BCB08B75838B4")
          HostAndPort(String host, int port) {
            this.host = host;
            this.port = port;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.921 -0400", hash_original_method = "4275ECED88C546D6C48AA6C77D620659", hash_generated_method = "F76AB8D169A7C8DB410B878E800CD94B")
        @Override
        public int hashCode() {
            int var7486CBF8614CDB9AEBCF903E96EF526C_1639447443 = (host.hashCode() * 31 + port);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_61446825 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_61446825;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.921 -0400", hash_original_method = "B55E1F045FCFEF599209FA0277EB136A", hash_generated_method = "F39B447F125AA3EB290AD56FC8EE7A7D")
        @Override
        public boolean equals(Object o) {
            HostAndPort lhs = (HostAndPort) o;
            boolean var5D96864B593BFC0377F29170A33FCDAC_944513987 = (host.equals(lhs.host) && port == lhs.port);
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_202432056 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_202432056;
            
            
                
            
            
            
        }

        
    }


    
}

