package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.*;

public class Organization extends SIPHeader implements OrganizationHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.834 -0400", hash_original_field = "B4C1948C087FAFC89A88450FCBB64C77", hash_generated_field = "7B6519A46F5BF8862075151D042F1E20")

    protected String organization;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.835 -0400", hash_original_method = "A22A45BA0A2B2678454705CA5BB968BD", hash_generated_method = "77544CC18B49DD4CBC9F054FA924E69C")
    public  Organization() {
        super(ORGANIZATION);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.836 -0400", hash_original_method = "64094CFB244C647C5657F3E488B1D7D6", hash_generated_method = "2B299968478F773C3EF62E8733F39E09")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1576517766 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1576517766 = organization;
        varB4EAC82CA7396A68D541C85D26508E83_1576517766.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1576517766;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.836 -0400", hash_original_method = "9435FCCFD7C054307D934681F7070D26", hash_generated_method = "3C5EABF98938D5E70DF585E578BAD45E")
    public String getOrganization() {
        String varB4EAC82CA7396A68D541C85D26508E83_394691253 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_394691253 = organization;
        varB4EAC82CA7396A68D541C85D26508E83_394691253.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_394691253;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.837 -0400", hash_original_method = "525AB078049049253D355424AD5A3E65", hash_generated_method = "745D4B183738B4A222409D3D22C2DDEB")
    public void setOrganization(String o) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception,"
                    + " Organization, setOrganization(), the organization parameter is null");
        organization = o;
        
        
            
                
                    
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.837 -0400", hash_original_field = "4141766911F0F3B58A3082026A876C2C", hash_generated_field = "BF1069295545422BFA1A0647DDAC00E1")

    private static final long serialVersionUID = -2775003113740192712L;
}

