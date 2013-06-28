package org.apache.http.impl.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeFactory;
import org.apache.http.params.HttpParams;

public class DigestSchemeFactory implements AuthSchemeFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.856 -0400", hash_original_method = "96D34D07BF3F94332DDA120DA0B662A4", hash_generated_method = "96D34D07BF3F94332DDA120DA0B662A4")
    public DigestSchemeFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.857 -0400", hash_original_method = "C297ADB7309AAFCCA05FBFAFBC517584", hash_generated_method = "6422B3C46B5865FEA9E5F12978ADB530")
    public AuthScheme newInstance(final HttpParams params) {
        AuthScheme varB4EAC82CA7396A68D541C85D26508E83_1147878569 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1147878569 = new DigestScheme();
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1147878569.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1147878569;
        // ---------- Original Method ----------
        //return new DigestScheme();
    }

    
}

