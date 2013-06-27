package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.EventObject;

public class SSLSessionBindingEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.707 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.707 -0400", hash_original_method = "794652F3E2A819204DF4691F4DF3911D", hash_generated_method = "A00609DB5E54F2EE6D3FEE3AC0AEE649")
    public  SSLSessionBindingEvent(SSLSession session, String name) {
        super(session);
        this.name = name;
        addTaint(session.getTaint());
        // ---------- Original Method ----------
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.708 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "D74A87C4F3CEFB4D09FCA3625AF74DAF")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1018450273 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1018450273 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1018450273.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1018450273;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.708 -0400", hash_original_method = "C5768F99D51ECCDFF4B75CB996C2544E", hash_generated_method = "A2C92AFEB91CEE0BBDCDA1796866D578")
    public SSLSession getSession() {
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_1773055286 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1773055286 = (SSLSession) this.source;
        varB4EAC82CA7396A68D541C85D26508E83_1773055286.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1773055286;
        // ---------- Original Method ----------
        //return (SSLSession) this.source;
    }

    
}

