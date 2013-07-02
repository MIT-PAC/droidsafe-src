package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;

public final class AllowEvents extends SIPHeader implements javax.sip.header.AllowEventsHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.889 -0400", hash_original_field = "2F264034C73ACBD6BAAE70DD7EDB3D3F", hash_generated_field = "8B4AE3944FE26E1E3D2F161694AF8E90")

    protected String eventType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.889 -0400", hash_original_method = "B300CC10915D88E488A895EA20EE2A09", hash_generated_method = "60A08C0FBE41C8160995AE7F013B9128")
    public  AllowEvents() {
        super(ALLOW_EVENTS);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.890 -0400", hash_original_method = "5D2656FB66C7C3040E5BEE12ACA7E341", hash_generated_method = "614CF3514F02380A9D78B1E9692E01B2")
    public  AllowEvents(String m) {
        super(ALLOW_EVENTS);
        eventType = m;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.890 -0400", hash_original_method = "A10AD710FF1C0BA35C48E4F204BD5CD1", hash_generated_method = "3718623EBCAF4982DC07A5C12B677F8B")
    public void setEventType(String eventType) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception,"
                    + "AllowEvents, setEventType(), the eventType parameter is null");
        this.eventType = eventType;
        
        
            
                
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.890 -0400", hash_original_method = "801AF3F6658A2A453A4D4DA9830DAF46", hash_generated_method = "80248ED60542FB5C591727E195A35816")
    public String getEventType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1892036202 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1892036202 = eventType;
        varB4EAC82CA7396A68D541C85D26508E83_1892036202.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1892036202;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.891 -0400", hash_original_method = "895FBB9B6BA00626F6F635DDC47F48B7", hash_generated_method = "7C3FFE51A1DFA27E15CD3DAC3F865D7F")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1314610713 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1314610713 = eventType;
        varB4EAC82CA7396A68D541C85D26508E83_1314610713.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1314610713;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.891 -0400", hash_original_field = "D26554E56E6998210017FC87B96E228A", hash_generated_field = "AC25BA32AE0E1E6630D2239F784D525D")

    private static final long serialVersionUID = 617962431813193114L;
}

