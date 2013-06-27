package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;

public final class AllowEvents extends SIPHeader implements javax.sip.header.AllowEventsHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.254 -0400", hash_original_field = "2F264034C73ACBD6BAAE70DD7EDB3D3F", hash_generated_field = "8B4AE3944FE26E1E3D2F161694AF8E90")

    protected String eventType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.256 -0400", hash_original_method = "B300CC10915D88E488A895EA20EE2A09", hash_generated_method = "60A08C0FBE41C8160995AE7F013B9128")
    public  AllowEvents() {
        super(ALLOW_EVENTS);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.256 -0400", hash_original_method = "5D2656FB66C7C3040E5BEE12ACA7E341", hash_generated_method = "614CF3514F02380A9D78B1E9692E01B2")
    public  AllowEvents(String m) {
        super(ALLOW_EVENTS);
        eventType = m;
        // ---------- Original Method ----------
        //eventType = m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.256 -0400", hash_original_method = "A10AD710FF1C0BA35C48E4F204BD5CD1", hash_generated_method = "3718623EBCAF4982DC07A5C12B677F8B")
    public void setEventType(String eventType) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception,"
                    + "AllowEvents, setEventType(), the eventType parameter is null");
        this.eventType = eventType;
        // ---------- Original Method ----------
        //if (eventType == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception,"
                    //+ "AllowEvents, setEventType(), the eventType parameter is null");
        //this.eventType = eventType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.257 -0400", hash_original_method = "801AF3F6658A2A453A4D4DA9830DAF46", hash_generated_method = "36D349855FA425D64F9F3CB6BCBBD7B5")
    public String getEventType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1133685451 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1133685451 = eventType;
        varB4EAC82CA7396A68D541C85D26508E83_1133685451.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1133685451;
        // ---------- Original Method ----------
        //return eventType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.257 -0400", hash_original_method = "895FBB9B6BA00626F6F635DDC47F48B7", hash_generated_method = "B6C2609A689015A03D94092DC9E3B27A")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1966360722 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1966360722 = eventType;
        varB4EAC82CA7396A68D541C85D26508E83_1966360722.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1966360722;
        // ---------- Original Method ----------
        //return eventType;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.257 -0400", hash_original_field = "D26554E56E6998210017FC87B96E228A", hash_generated_field = "EB9A29BDC49ED5A6522BAE1787587472")

    private static long serialVersionUID = 617962431813193114L;
}

