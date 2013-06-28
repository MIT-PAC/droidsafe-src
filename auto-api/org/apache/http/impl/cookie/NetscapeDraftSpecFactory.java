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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.258 -0400", hash_original_method = "E0E1E20239023582A4617467D7E49523", hash_generated_method = "E0E1E20239023582A4617467D7E49523")
    public NetscapeDraftSpecFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.258 -0400", hash_original_method = "34FA08500657FDD515515AEEA52740F3", hash_generated_method = "DC4E2F6E381806BD7E652320B51ED6F8")
    public CookieSpec newInstance(final HttpParams params) {
        CookieSpec varB4EAC82CA7396A68D541C85D26508E83_852002679 = null; //Variable for return #1
        CookieSpec varB4EAC82CA7396A68D541C85D26508E83_422121362 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_852002679 = new NetscapeDraftSpec(
                    (String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS));
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_422121362 = new NetscapeDraftSpec();
        } //End block
        addTaint(params.getTaint());
        CookieSpec varA7E53CE21691AB073D9660D615818899_528014940; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_528014940 = varB4EAC82CA7396A68D541C85D26508E83_852002679;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_528014940 = varB4EAC82CA7396A68D541C85D26508E83_422121362;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_528014940.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_528014940;
        // ---------- Original Method ----------
        //if (params != null) {
            //return new NetscapeDraftSpec(
                    //(String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS));
        //} else {
            //return new NetscapeDraftSpec();
        //}
    }

    
}

