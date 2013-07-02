package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.*;

public class Subject extends SIPHeader implements SubjectHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.693 -0400", hash_original_field = "B5E3374E43F6544852F7751DFC529100", hash_generated_field = "FCF19B41C65ED3C233A6175A0183A3FB")

    protected String subject;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.694 -0400", hash_original_method = "D63809B6DE8F5F47E85D84EB99E1AE5D", hash_generated_method = "FC1BF9AC217CC58F50D5E1F25B779F09")
    public  Subject() {
        super(SUBJECT);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.695 -0400", hash_original_method = "3C6B7893125DF6EE8816C7C8DB5CA48D", hash_generated_method = "60A22F4B5F65C05BF3C792CC0185BE37")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_86636924 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_148282141 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_86636924 = subject;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_148282141 = "";
        } 
        String varA7E53CE21691AB073D9660D615818899_107219482; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_107219482 = varB4EAC82CA7396A68D541C85D26508E83_86636924;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_107219482 = varB4EAC82CA7396A68D541C85D26508E83_148282141;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_107219482.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_107219482;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.696 -0400", hash_original_method = "6F21748266641C905516C66889D7570C", hash_generated_method = "996D6D4B047C37F0A9CC99E08C01B006")
    public void setSubject(String subject) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " Subject, setSubject(), the subject parameter is null");
        this.subject = subject;
        
        
            
                
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.696 -0400", hash_original_method = "8EBD535E211A75BE78AF45361DF5913D", hash_generated_method = "0B09EB72D8D7B2A1CAF6A4D45A78A97F")
    public String getSubject() {
        String varB4EAC82CA7396A68D541C85D26508E83_384927457 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_384927457 = subject;
        varB4EAC82CA7396A68D541C85D26508E83_384927457.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_384927457;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.696 -0400", hash_original_field = "3D06F226553D3F5C6F20075141F7D3D9", hash_generated_field = "5A108BF1E2A98855AB05AF0A50CEDCDE")

    private static final long serialVersionUID = -6479220126758862528L;
}

