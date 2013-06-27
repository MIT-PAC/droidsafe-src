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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.058 -0400", hash_original_method = "96D34D07BF3F94332DDA120DA0B662A4", hash_generated_method = "96D34D07BF3F94332DDA120DA0B662A4")
    public DigestSchemeFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.059 -0400", hash_original_method = "C297ADB7309AAFCCA05FBFAFBC517584", hash_generated_method = "FC40479384C19F5C8F00E296A1E5DD8C")
    public AuthScheme newInstance(final HttpParams params) {
        AuthScheme varB4EAC82CA7396A68D541C85D26508E83_310838781 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_310838781 = new DigestScheme();
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_310838781.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_310838781;
        // ---------- Original Method ----------
        //return new DigestScheme();
    }

    
}

