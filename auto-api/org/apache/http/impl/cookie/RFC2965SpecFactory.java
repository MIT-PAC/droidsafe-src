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

public class RFC2965SpecFactory implements CookieSpecFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.508 -0400", hash_original_method = "D18808A8475C9A632DDF495DEFF2DFBD", hash_generated_method = "D18808A8475C9A632DDF495DEFF2DFBD")
    public RFC2965SpecFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.510 -0400", hash_original_method = "9B95DA0587FBFA9E43990E1A6723C326", hash_generated_method = "7D46ADF7FE8E52FD95B729664CD01336")
    public CookieSpec newInstance(final HttpParams params) {
        CookieSpec varB4EAC82CA7396A68D541C85D26508E83_999801473 = null; //Variable for return #1
        CookieSpec varB4EAC82CA7396A68D541C85D26508E83_747088446 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_999801473 = new RFC2965Spec(
                    (String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS), 
                    params.getBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, false));
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_747088446 = new RFC2965Spec();
        } //End block
        addTaint(params.getTaint());
        CookieSpec varA7E53CE21691AB073D9660D615818899_1100639574; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1100639574 = varB4EAC82CA7396A68D541C85D26508E83_999801473;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1100639574 = varB4EAC82CA7396A68D541C85D26508E83_747088446;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1100639574.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1100639574;
        // ---------- Original Method ----------
        //if (params != null) {
            //return new RFC2965Spec(
                    //(String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS), 
                    //params.getBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, false));
        //} else {
            //return new RFC2965Spec();
        //}
    }

    
}

