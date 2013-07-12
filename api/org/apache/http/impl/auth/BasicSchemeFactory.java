package org.apache.http.impl.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeFactory;
import org.apache.http.params.HttpParams;

public class BasicSchemeFactory implements AuthSchemeFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.127 -0400", hash_original_method = "49D9E4F630B22E0624E8213D1CA42372", hash_generated_method = "49D9E4F630B22E0624E8213D1CA42372")
    public BasicSchemeFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.127 -0400", hash_original_method = "4F0A9DA7F5CA512F8942F95AB4C9F660", hash_generated_method = "3AA8E1049FE1E5CD2E2CE06AA558A5B1")
    public AuthScheme newInstance(final HttpParams params) {
        addTaint(params.getTaint());
AuthScheme var88FC9205CAFBC04EC4A4B17896C743F7_344510135 =         new BasicScheme();
        var88FC9205CAFBC04EC4A4B17896C743F7_344510135.addTaint(taint);
        return var88FC9205CAFBC04EC4A4B17896C743F7_344510135;
        // ---------- Original Method ----------
        //return new BasicScheme();
    }

    
}

