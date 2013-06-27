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

public class BasicSchemeFactory implements AuthSchemeFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.049 -0400", hash_original_method = "49D9E4F630B22E0624E8213D1CA42372", hash_generated_method = "49D9E4F630B22E0624E8213D1CA42372")
    public BasicSchemeFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.050 -0400", hash_original_method = "4F0A9DA7F5CA512F8942F95AB4C9F660", hash_generated_method = "5B64355E7DC7C77FB9FE60A4A60B9775")
    public AuthScheme newInstance(final HttpParams params) {
        AuthScheme varB4EAC82CA7396A68D541C85D26508E83_2057963778 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2057963778 = new BasicScheme();
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2057963778.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2057963778;
        // ---------- Original Method ----------
        //return new BasicScheme();
    }

    
}

