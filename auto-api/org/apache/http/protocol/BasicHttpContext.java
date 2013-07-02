package org.apache.http.protocol;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class BasicHttpContext implements HttpContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.490 -0400", hash_original_field = "7D67682364DBB9F3485BABE9AD33ACCD", hash_generated_field = "D1460501CCEE3C619EE4C99664E2DBB5")

    private HttpContext parentContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.490 -0400", hash_original_field = "39165B451A557CE4CA8964DFE5102735", hash_generated_field = "14270C32B91E233A04B6BA686361124C")

    private Map map = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.490 -0400", hash_original_method = "7A4905790D001081AE9E7E7092B16556", hash_generated_method = "B3C58EE05EB2DAD95672DF798CE06022")
    public  BasicHttpContext() {
        this(null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.491 -0400", hash_original_method = "A4B2F68240B72FA009235C6627ABF17D", hash_generated_method = "A47175A671B513D5930880862C333301")
    public  BasicHttpContext(final HttpContext parentContext) {
        super();
        this.parentContext = parentContext;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.492 -0400", hash_original_method = "5AF73FFF83A5EDE5922275A66AC65FB8", hash_generated_method = "636FB66B4F64028D6E6BE3054826954E")
    public Object getAttribute(final String id) {
        Object varB4EAC82CA7396A68D541C85D26508E83_757079613 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Id may not be null");
        } 
        Object obj = null;
        {
            obj = this.map.get(id);
        } 
        {
            obj = this.parentContext.getAttribute(id);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_757079613 = obj;
        addTaint(id.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_757079613.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_757079613;
        
        
            
        
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.492 -0400", hash_original_method = "7CCB44BFA094973C3F41CEC20132EE3C", hash_generated_method = "F40BC07141F8C50B47132E71A03ADD55")
    public void setAttribute(final String id, final Object obj) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Id may not be null");
        } 
        {
            this.map = new HashMap();
        } 
        this.map.put(id, obj);
        addTaint(id.getTaint());
        addTaint(obj.getTaint());
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.493 -0400", hash_original_method = "F81CB5E3AB9015A95E5E2B5DBCB1E2A6", hash_generated_method = "F6EE11C356272DBFCDD36B16BA376BC3")
    public Object removeAttribute(final String id) {
        Object varB4EAC82CA7396A68D541C85D26508E83_194270489 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1226270901 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Id may not be null");
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_194270489 = this.map.remove(id);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1226270901 = null;
        } 
        addTaint(id.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_702985034; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_702985034 = varB4EAC82CA7396A68D541C85D26508E83_194270489;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_702985034 = varB4EAC82CA7396A68D541C85D26508E83_1226270901;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_702985034.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_702985034;
        
        
            
        
        
            
        
            
        
    }

    
}

