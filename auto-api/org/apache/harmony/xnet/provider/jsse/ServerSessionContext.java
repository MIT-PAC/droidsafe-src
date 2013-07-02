package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.net.ssl.SSLSession;

public class ServerSessionContext extends AbstractSessionContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.302 -0400", hash_original_field = "AA2F0669D76C361D6298E17FC081F394", hash_generated_field = "03372E20A94CFEB28F0443462F1FB862")

    private SSLServerSessionCache persistentCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.302 -0400", hash_original_method = "9FA739694DBACEAA071D2AEDBA51A05E", hash_generated_method = "519FB45F9A385F0AC73A51E91875A433")
    public  ServerSessionContext() {
        super(100, 0);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.303 -0400", hash_original_method = "72569EA6711DBA1D81D9BBC862AD3D03", hash_generated_method = "98DC823E6DF5392957E496FAD00FA2DE")
    public void setPersistentCache(SSLServerSessionCache persistentCache) {
        this.persistentCache = persistentCache;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.303 -0400", hash_original_method = "D4D4D8A9ED5E99BC7DD197F41DEEDD43", hash_generated_method = "16DEE84B347D7E24654B9D4FF767833A")
    protected void sessionRemoved(SSLSession session) {
        addTaint(session.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.304 -0400", hash_original_method = "B67FD63429286D10E1FBB2A9ED634511", hash_generated_method = "C98EF8731D2A286D633F7064649BBD36")
    @Override
    public SSLSession getSession(byte[] sessionId) {
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_1228860890 = null; 
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_1847490628 = null; 
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_1160805242 = null; 
        SSLSession session = super.getSession(sessionId);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1228860890 = session;
        } 
        {
            byte[] data = persistentCache.getSessionData(sessionId);
            {
                session = toSession(data, null, -1);
                {
                    boolean varE0B94CD6DB7A63F5969E6C0C96C6CFF0_1223100173 = (session != null && session.isValid());
                    {
                        super.putSession(session);
                        varB4EAC82CA7396A68D541C85D26508E83_1847490628 = session;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1160805242 = null;
        addTaint(sessionId[0]);
        SSLSession varA7E53CE21691AB073D9660D615818899_176990289; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_176990289 = varB4EAC82CA7396A68D541C85D26508E83_1228860890;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_176990289 = varB4EAC82CA7396A68D541C85D26508E83_1847490628;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_176990289 = varB4EAC82CA7396A68D541C85D26508E83_1160805242;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_176990289.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_176990289;
        
        
        
            
        
        
            
            
                
                
                    
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.305 -0400", hash_original_method = "6A881248A35D6FEA85AFAE8D9374366B", hash_generated_method = "38873BD7789D7E9443FF689769FC3B95")
    @Override
     void putSession(SSLSession session) {
        super.putSession(session);
        {
            byte[] data = toBytes(session);
            {
                persistentCache.putSessionData(session, data);
            } 
        } 
        addTaint(session.getTaint());
        
        
        
            
            
                
            
        
    }

    
}

