package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.params.CookieSpecPNames;
import org.apache.http.params.HttpParams;

public class RFC2109SpecFactory implements CookieSpecFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.403 -0400", hash_original_method = "D388D125B30D289290BCCEEE1DC724F5", hash_generated_method = "D388D125B30D289290BCCEEE1DC724F5")
    public RFC2109SpecFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.404 -0400", hash_original_method = "319F84F2475AFEEE24E68A878D2B0074", hash_generated_method = "D4B96FEC844C5ED19F6A574D6B1ECC9A")
    public CookieSpec newInstance(final HttpParams params) {
        CookieSpec varB4EAC82CA7396A68D541C85D26508E83_618880824 = null; //Variable for return #1
        CookieSpec varB4EAC82CA7396A68D541C85D26508E83_1730890637 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_618880824 = new RFC2109Spec(
                    (String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS), 
                    params.getBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, false));
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1730890637 = new RFC2109Spec();
        } //End block
        addTaint(params.getTaint());
        CookieSpec varA7E53CE21691AB073D9660D615818899_334549075; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_334549075 = varB4EAC82CA7396A68D541C85D26508E83_618880824;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_334549075 = varB4EAC82CA7396A68D541C85D26508E83_1730890637;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_334549075.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_334549075;
        // ---------- Original Method ----------
        //if (params != null) {
            //return new RFC2109Spec(
                    //(String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS), 
                    //params.getBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, false));
        //} else {
            //return new RFC2109Spec();
        //}
    }

    
}

