package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public abstract class ContentHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.036 -0400", hash_original_method = "34235149EC6F1F14A33FF6A78502D340", hash_generated_method = "34235149EC6F1F14A33FF6A78502D340")
    public ContentHandler ()
    {
        
    }


    public abstract Object getContent(URLConnection uConn) throws IOException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.037 -0400", hash_original_method = "8659195BC6B56411F2DC6C9C918B5FC3", hash_generated_method = "F7975C7F0AE06F57450FB4F045866B5A")
    @SuppressWarnings("unchecked")
    public Object getContent(URLConnection uConn, Class[] types) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1783059528 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1333230609 = null; 
        Object content = getContent(uConn);
        {
            int i = 0;
            {
                {
                    boolean varD335B318B75970DDE3AA8452F6D1E99A_895064457 = (types[i].isInstance(content));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1783059528 = content;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1333230609 = null;
        addTaint(uConn.getTaint());
        addTaint(types[0].getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1772363300; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1772363300 = varB4EAC82CA7396A68D541C85D26508E83_1783059528;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1772363300 = varB4EAC82CA7396A68D541C85D26508E83_1333230609;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1772363300.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1772363300;
        
        
        
            
                
            
        
        
    }

    
}

