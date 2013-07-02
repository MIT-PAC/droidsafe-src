package org.apache.http.impl.auth;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeFactory;
import org.apache.http.params.HttpParams;

public class BasicSchemeFactory implements AuthSchemeFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.783 -0400", hash_original_method = "49D9E4F630B22E0624E8213D1CA42372", hash_generated_method = "49D9E4F630B22E0624E8213D1CA42372")
    public BasicSchemeFactory ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.784 -0400", hash_original_method = "4F0A9DA7F5CA512F8942F95AB4C9F660", hash_generated_method = "900A0E2E95FF8656AE68170CD51D3C5B")
    public AuthScheme newInstance(final HttpParams params) {
        AuthScheme varB4EAC82CA7396A68D541C85D26508E83_1613043312 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1613043312 = new BasicScheme();
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1613043312.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1613043312;
        
        
    }

    
}

