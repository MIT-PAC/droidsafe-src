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

public class NetscapeDraftSpecFactory implements CookieSpecFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.611 -0400", hash_original_method = "E0E1E20239023582A4617467D7E49523", hash_generated_method = "E0E1E20239023582A4617467D7E49523")
    public NetscapeDraftSpecFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.611 -0400", hash_original_method = "34FA08500657FDD515515AEEA52740F3", hash_generated_method = "27DB9305F28214DB0B6B5C5E7E156AE8")
    public CookieSpec newInstance(final HttpParams params) {
        CookieSpec varB4EAC82CA7396A68D541C85D26508E83_1368430461 = null; //Variable for return #1
        CookieSpec varB4EAC82CA7396A68D541C85D26508E83_1056466968 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1368430461 = new NetscapeDraftSpec(
                    (String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS));
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1056466968 = new NetscapeDraftSpec();
        } //End block
        addTaint(params.getTaint());
        CookieSpec varA7E53CE21691AB073D9660D615818899_924054627; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_924054627 = varB4EAC82CA7396A68D541C85D26508E83_1368430461;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_924054627 = varB4EAC82CA7396A68D541C85D26508E83_1056466968;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_924054627.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_924054627;
        // ---------- Original Method ----------
        //if (params != null) {
            //return new NetscapeDraftSpec(
                    //(String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS));
        //} else {
            //return new NetscapeDraftSpec();
        //}
    }

    
}

