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

public class BrowserCompatSpecFactory implements CookieSpecFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.210 -0400", hash_original_method = "F9F6A371DCC8057014285867BD71C0DB", hash_generated_method = "F9F6A371DCC8057014285867BD71C0DB")
    public BrowserCompatSpecFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.213 -0400", hash_original_method = "57B736694D04F685316FEE33170F38F5", hash_generated_method = "1C5573D4A7183C6EE564E57F12B160E4")
    public CookieSpec newInstance(final HttpParams params) {
        CookieSpec varB4EAC82CA7396A68D541C85D26508E83_1966656918 = null; //Variable for return #1
        CookieSpec varB4EAC82CA7396A68D541C85D26508E83_686217840 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1966656918 = new BrowserCompatSpec(
                    (String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS));
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_686217840 = new BrowserCompatSpec();
        } //End block
        addTaint(params.getTaint());
        CookieSpec varA7E53CE21691AB073D9660D615818899_1035198362; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1035198362 = varB4EAC82CA7396A68D541C85D26508E83_1966656918;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1035198362 = varB4EAC82CA7396A68D541C85D26508E83_686217840;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1035198362.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1035198362;
        // ---------- Original Method ----------
        //if (params != null) {
            //return new BrowserCompatSpec(
                    //(String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS));
        //} else {
            //return new BrowserCompatSpec();
        //}
    }

    
}

