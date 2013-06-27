package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;
import javax.sip.header.*;

public class SIPDateHeader extends SIPHeader implements DateHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.466 -0400", hash_original_field = "5FC732311905CB27E82D67F4F6511F7F", hash_generated_field = "E6B895F7293606CA8C9A3D5102653BE1")

    protected SIPDate date;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.466 -0400", hash_original_method = "1EECE0587E859340DA3FB0354A4B8225", hash_generated_method = "82F22B1EC104F5553333AC52A87327F2")
    public  SIPDateHeader() {
        super(DATE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.467 -0400", hash_original_method = "C034912C24C8AA492A55E1DAB6749820", hash_generated_method = "21B50FEBC51B38341939C7BDCEA8761A")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1551123143 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1551123143 = date.encode();
        varB4EAC82CA7396A68D541C85D26508E83_1551123143.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1551123143;
        // ---------- Original Method ----------
        //return date.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.468 -0400", hash_original_method = "6C9EAA9AEBF2DE9AF857C9766729F95B", hash_generated_method = "79D01558A8C4EA0E589F8A4773D04A84")
    public void setDate(SIPDate d) {
        date = d;
        // ---------- Original Method ----------
        //date = d;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.480 -0400", hash_original_method = "593883A7F1E198F7FABAA636FE37D3D4", hash_generated_method = "E27CE2D49553237C3437214A4BA4B89B")
    public void setDate(Calendar dat) {
        date = new SIPDate(dat.getTime().getTime());
        // ---------- Original Method ----------
        //if (dat != null)
            //date = new SIPDate(dat.getTime().getTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.481 -0400", hash_original_method = "8348440FA7E2BF46CE5F14E959934430", hash_generated_method = "9FA87B24AD13A1EE50D7265EF3DC5A8A")
    public Calendar getDate() {
        Calendar varB4EAC82CA7396A68D541C85D26508E83_1832514672 = null; //Variable for return #1
        Calendar varB4EAC82CA7396A68D541C85D26508E83_747779284 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1832514672 = null;
        varB4EAC82CA7396A68D541C85D26508E83_747779284 = date.getJavaCal();
        Calendar varA7E53CE21691AB073D9660D615818899_1888309913; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1888309913 = varB4EAC82CA7396A68D541C85D26508E83_1832514672;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1888309913 = varB4EAC82CA7396A68D541C85D26508E83_747779284;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1888309913.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1888309913;
        // ---------- Original Method ----------
        //if (date == null)
            //return null;
        //return date.getJavaCal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.485 -0400", hash_original_method = "D8FA67BA672B59A2560C827929374032", hash_generated_method = "000C041B2990928354867F98C826B457")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_805055297 = null; //Variable for return #1
        SIPDateHeader retval;
        retval = (SIPDateHeader) super.clone();
        retval.date = (SIPDate) this.date.clone();
        varB4EAC82CA7396A68D541C85D26508E83_805055297 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_805055297.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_805055297;
        // ---------- Original Method ----------
        //SIPDateHeader retval = (SIPDateHeader) super.clone();
        //if (this.date != null)
            //retval.date = (SIPDate) this.date.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.485 -0400", hash_original_field = "1A67EF30C59B59085B13D3BAF5F6DFA1", hash_generated_field = "34C2D1480A26AEC64B07D7382CF8B91E")

    private static long serialVersionUID = 1734186339037274664L;
}

