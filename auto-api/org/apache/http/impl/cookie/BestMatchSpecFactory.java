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

public class BestMatchSpecFactory implements CookieSpecFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.190 -0400", hash_original_method = "17A5B3D05891EED9B20E49D2F5F89B97", hash_generated_method = "17A5B3D05891EED9B20E49D2F5F89B97")
    public BestMatchSpecFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.191 -0400", hash_original_method = "2201EB1DC86453D4D2DD6749773278D9", hash_generated_method = "341970E3CBE7C3C2AEE49706561F6172")
    public CookieSpec newInstance(final HttpParams params) {
        CookieSpec varB4EAC82CA7396A68D541C85D26508E83_656033976 = null; //Variable for return #1
        CookieSpec varB4EAC82CA7396A68D541C85D26508E83_462192248 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_656033976 = new BestMatchSpec(
                    (String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS), 
                    params.getBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, false));
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_462192248 = new BestMatchSpec();
        } //End block
        addTaint(params.getTaint());
        CookieSpec varA7E53CE21691AB073D9660D615818899_2006327386; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2006327386 = varB4EAC82CA7396A68D541C85D26508E83_656033976;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2006327386 = varB4EAC82CA7396A68D541C85D26508E83_462192248;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2006327386.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2006327386;
        // ---------- Original Method ----------
        //if (params != null) {
            //return new BestMatchSpec(
                    //(String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS), 
                    //params.getBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, false));
        //} else {
            //return new BestMatchSpec();
        //}
    }

    
}

