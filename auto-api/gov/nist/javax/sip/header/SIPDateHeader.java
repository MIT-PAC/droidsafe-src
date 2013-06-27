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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.444 -0400", hash_original_field = "5FC732311905CB27E82D67F4F6511F7F", hash_generated_field = "E6B895F7293606CA8C9A3D5102653BE1")

    protected SIPDate date;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.444 -0400", hash_original_method = "1EECE0587E859340DA3FB0354A4B8225", hash_generated_method = "82F22B1EC104F5553333AC52A87327F2")
    public  SIPDateHeader() {
        super(DATE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.445 -0400", hash_original_method = "C034912C24C8AA492A55E1DAB6749820", hash_generated_method = "870C02DC40F104753AB064AB5CAD5C64")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_2073618002 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2073618002 = date.encode();
        varB4EAC82CA7396A68D541C85D26508E83_2073618002.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2073618002;
        // ---------- Original Method ----------
        //return date.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.445 -0400", hash_original_method = "6C9EAA9AEBF2DE9AF857C9766729F95B", hash_generated_method = "79D01558A8C4EA0E589F8A4773D04A84")
    public void setDate(SIPDate d) {
        date = d;
        // ---------- Original Method ----------
        //date = d;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.446 -0400", hash_original_method = "593883A7F1E198F7FABAA636FE37D3D4", hash_generated_method = "E27CE2D49553237C3437214A4BA4B89B")
    public void setDate(Calendar dat) {
        date = new SIPDate(dat.getTime().getTime());
        // ---------- Original Method ----------
        //if (dat != null)
            //date = new SIPDate(dat.getTime().getTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.446 -0400", hash_original_method = "8348440FA7E2BF46CE5F14E959934430", hash_generated_method = "0AD7675132D3E6B71DB1440F7319D35D")
    public Calendar getDate() {
        Calendar varB4EAC82CA7396A68D541C85D26508E83_2047715319 = null; //Variable for return #1
        Calendar varB4EAC82CA7396A68D541C85D26508E83_379769177 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_2047715319 = null;
        varB4EAC82CA7396A68D541C85D26508E83_379769177 = date.getJavaCal();
        Calendar varA7E53CE21691AB073D9660D615818899_1709902833; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1709902833 = varB4EAC82CA7396A68D541C85D26508E83_2047715319;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1709902833 = varB4EAC82CA7396A68D541C85D26508E83_379769177;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1709902833.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1709902833;
        // ---------- Original Method ----------
        //if (date == null)
            //return null;
        //return date.getJavaCal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.447 -0400", hash_original_method = "D8FA67BA672B59A2560C827929374032", hash_generated_method = "86DED82D07D4F371C9F6CCF7747DF3B3")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_492608636 = null; //Variable for return #1
        SIPDateHeader retval;
        retval = (SIPDateHeader) super.clone();
        retval.date = (SIPDate) this.date.clone();
        varB4EAC82CA7396A68D541C85D26508E83_492608636 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_492608636.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_492608636;
        // ---------- Original Method ----------
        //SIPDateHeader retval = (SIPDateHeader) super.clone();
        //if (this.date != null)
            //retval.date = (SIPDate) this.date.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.447 -0400", hash_original_field = "1A67EF30C59B59085B13D3BAF5F6DFA1", hash_generated_field = "34C2D1480A26AEC64B07D7382CF8B91E")

    private static long serialVersionUID = 1734186339037274664L;
}

