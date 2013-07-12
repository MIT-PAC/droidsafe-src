package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.net.ssl.SSLSession;

public class ServerSessionContext extends AbstractSessionContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.516 -0400", hash_original_field = "AA2F0669D76C361D6298E17FC081F394", hash_generated_field = "03372E20A94CFEB28F0443462F1FB862")

    private SSLServerSessionCache persistentCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.517 -0400", hash_original_method = "9FA739694DBACEAA071D2AEDBA51A05E", hash_generated_method = "519FB45F9A385F0AC73A51E91875A433")
    public  ServerSessionContext() {
        super(100, 0);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.517 -0400", hash_original_method = "72569EA6711DBA1D81D9BBC862AD3D03", hash_generated_method = "98DC823E6DF5392957E496FAD00FA2DE")
    public void setPersistentCache(SSLServerSessionCache persistentCache) {
        this.persistentCache = persistentCache;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.517 -0400", hash_original_method = "D4D4D8A9ED5E99BC7DD197F41DEEDD43", hash_generated_method = "16DEE84B347D7E24654B9D4FF767833A")
    protected void sessionRemoved(SSLSession session) {
        addTaint(session.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.518 -0400", hash_original_method = "B67FD63429286D10E1FBB2A9ED634511", hash_generated_method = "EA282F8A039CBEC179AFFB3CEC566F5E")
    @Override
    public SSLSession getSession(byte[] sessionId) {
        addTaint(sessionId[0]);
        SSLSession session = super.getSession(sessionId);
    if(session != null)        
        {
SSLSession varD555E544A66E0F97DA6BCDE940E3E79C_1481517196 =             session;
            varD555E544A66E0F97DA6BCDE940E3E79C_1481517196.addTaint(taint);
            return varD555E544A66E0F97DA6BCDE940E3E79C_1481517196;
        } 
    if(persistentCache != null)        
        {
            byte[] data = persistentCache.getSessionData(sessionId);
    if(data != null)            
            {
                session = toSession(data, null, -1);
    if(session != null && session.isValid())                
                {
                    super.putSession(session);
SSLSession varD555E544A66E0F97DA6BCDE940E3E79C_1971995557 =                     session;
                    varD555E544A66E0F97DA6BCDE940E3E79C_1971995557.addTaint(taint);
                    return varD555E544A66E0F97DA6BCDE940E3E79C_1971995557;
                } 
            } 
        } 
SSLSession var540C13E9E156B687226421B24F2DF178_705588826 =         null;
        var540C13E9E156B687226421B24F2DF178_705588826.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_705588826;
        
        
        
            
        
        
            
            
                
                
                    
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.519 -0400", hash_original_method = "6A881248A35D6FEA85AFAE8D9374366B", hash_generated_method = "FD43A503784B654CF4F587FDFE3AFB6E")
    @Override
     void putSession(SSLSession session) {
        addTaint(session.getTaint());
        super.putSession(session);
    if(persistentCache != null)        
        {
            byte[] data = toBytes(session);
    if(data != null)            
            {
                persistentCache.putSessionData(session, data);
            } 
        } 
        
        
        
            
            
                
            
        
    }

    
}

