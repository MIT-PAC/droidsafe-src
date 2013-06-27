package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.*;

public class Subject extends SIPHeader implements SubjectHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.713 -0400", hash_original_field = "B5E3374E43F6544852F7751DFC529100", hash_generated_field = "FCF19B41C65ED3C233A6175A0183A3FB")

    protected String subject;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.713 -0400", hash_original_method = "D63809B6DE8F5F47E85D84EB99E1AE5D", hash_generated_method = "FC1BF9AC217CC58F50D5E1F25B779F09")
    public  Subject() {
        super(SUBJECT);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.714 -0400", hash_original_method = "3C6B7893125DF6EE8816C7C8DB5CA48D", hash_generated_method = "D8515C717CCB5BB90A96DFAD573E8A2A")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1172151005 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_319327474 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1172151005 = subject;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_319327474 = "";
        } //End block
        String varA7E53CE21691AB073D9660D615818899_2049429222; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2049429222 = varB4EAC82CA7396A68D541C85D26508E83_1172151005;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2049429222 = varB4EAC82CA7396A68D541C85D26508E83_319327474;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2049429222.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2049429222;
        // ---------- Original Method ----------
        //if (subject != null) {
            //return subject;
        //} else {
            //return "";
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.715 -0400", hash_original_method = "6F21748266641C905516C66889D7570C", hash_generated_method = "996D6D4B047C37F0A9CC99E08C01B006")
    public void setSubject(String subject) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " Subject, setSubject(), the subject parameter is null");
        this.subject = subject;
        // ---------- Original Method ----------
        //if (subject == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ " Subject, setSubject(), the subject parameter is null");
        //this.subject = subject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.715 -0400", hash_original_method = "8EBD535E211A75BE78AF45361DF5913D", hash_generated_method = "2B41EFB222B8F0D4B4D0F03BA1DD93E6")
    public String getSubject() {
        String varB4EAC82CA7396A68D541C85D26508E83_1177636500 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1177636500 = subject;
        varB4EAC82CA7396A68D541C85D26508E83_1177636500.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1177636500;
        // ---------- Original Method ----------
        //return subject;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.715 -0400", hash_original_field = "3D06F226553D3F5C6F20075141F7D3D9", hash_generated_field = "6D011849EAD95AF50E1C2FFFCF7D3D06")

    private static long serialVersionUID = -6479220126758862528L;
}

