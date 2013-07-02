package org.apache.http.protocol;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public final class DefaultedHttpContext implements HttpContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.561 -0400", hash_original_field = "F5DDAF0CA7929578B408C909429F68F2", hash_generated_field = "E015EF617CD4ED004D5007AC30C609BC")

    private HttpContext local;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.561 -0400", hash_original_field = "A4A918A45181164207929D52AEC36AEC", hash_generated_field = "7ADABA5216B59FD658450669A2A3CCAA")

    private HttpContext defaults;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.561 -0400", hash_original_method = "A0575674BF73385D2F6A60AE80137BEF", hash_generated_method = "FED509538BE6B1021605219EBCAA345E")
    public  DefaultedHttpContext(final HttpContext local, final HttpContext defaults) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP context may not be null");
        } 
        this.local = local;
        this.defaults = defaults;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.562 -0400", hash_original_method = "E6F5162D8C28E0713279EA6EC6682784", hash_generated_method = "71B40EE98CFE5AFFE1B75B8D00A9256A")
    public Object getAttribute(final String id) {
        Object varB4EAC82CA7396A68D541C85D26508E83_815767170 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1301471585 = null; 
        Object obj = this.local.getAttribute(id);
        {
            varB4EAC82CA7396A68D541C85D26508E83_815767170 = this.defaults.getAttribute(id);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1301471585 = obj;
        } 
        addTaint(id.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_427052976; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_427052976 = varB4EAC82CA7396A68D541C85D26508E83_815767170;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_427052976 = varB4EAC82CA7396A68D541C85D26508E83_1301471585;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_427052976.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_427052976;
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.563 -0400", hash_original_method = "0AEE49A004EDC83FD5C79915CB13681F", hash_generated_method = "446F2FFB71EBEFFB21E038DD3C3B19AA")
    public Object removeAttribute(final String id) {
        Object varB4EAC82CA7396A68D541C85D26508E83_354927859 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_354927859 = this.local.removeAttribute(id);
        addTaint(id.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_354927859.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_354927859;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.563 -0400", hash_original_method = "EE2D3704A963700B0310D3F12DCBDD4D", hash_generated_method = "991E683E87425CB8B8ABDD6BD9C7AE12")
    public void setAttribute(final String id, final Object obj) {
        this.local.setAttribute(id, obj);
        addTaint(id.getTaint());
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.564 -0400", hash_original_method = "FA59965C12DF7B81C110308001A0693E", hash_generated_method = "101EAF0F9FFA7C9AE8FF3898FC88381F")
    public HttpContext getDefaults() {
        HttpContext varB4EAC82CA7396A68D541C85D26508E83_2049784751 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2049784751 = this.defaults;
        varB4EAC82CA7396A68D541C85D26508E83_2049784751.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2049784751;
        
        
    }

    
}

