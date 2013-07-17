package org.apache.http.impl.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeFactory;
import org.apache.http.params.HttpParams;

public class BasicSchemeFactory implements AuthSchemeFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.384 -0400", hash_original_method = "49D9E4F630B22E0624E8213D1CA42372", hash_generated_method = "49D9E4F630B22E0624E8213D1CA42372")
    public BasicSchemeFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.384 -0400", hash_original_method = "4F0A9DA7F5CA512F8942F95AB4C9F660", hash_generated_method = "9B79CE66CBB51032568A5AAD64D36860")
    public AuthScheme newInstance(final HttpParams params) {
        addTaint(params.getTaint());
AuthScheme var88FC9205CAFBC04EC4A4B17896C743F7_835072976 =         new BasicScheme();
        var88FC9205CAFBC04EC4A4B17896C743F7_835072976.addTaint(taint);
        return var88FC9205CAFBC04EC4A4B17896C743F7_835072976;
        // ---------- Original Method ----------
        //return new BasicScheme();
    }

    
}

