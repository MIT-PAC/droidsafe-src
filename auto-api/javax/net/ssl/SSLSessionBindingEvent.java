package javax.net.ssl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.EventObject;

public class SSLSessionBindingEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.698 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.698 -0400", hash_original_method = "794652F3E2A819204DF4691F4DF3911D", hash_generated_method = "A00609DB5E54F2EE6D3FEE3AC0AEE649")
    public  SSLSessionBindingEvent(SSLSession session, String name) {
        super(session);
        this.name = name;
        addTaint(session.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.699 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "1454BCD15C32DC0C3B23AC503BC194F5")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1363530859 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1363530859 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1363530859.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1363530859;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.699 -0400", hash_original_method = "C5768F99D51ECCDFF4B75CB996C2544E", hash_generated_method = "2468DEF27CF7689803893F4C4ABD1653")
    public SSLSession getSession() {
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_1433650999 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1433650999 = (SSLSession) this.source;
        varB4EAC82CA7396A68D541C85D26508E83_1433650999.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1433650999;
        
        
    }

    
}

