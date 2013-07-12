package org.apache.http.impl.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeFactory;
import org.apache.http.params.HttpParams;

public class DigestSchemeFactory implements AuthSchemeFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.199 -0400", hash_original_method = "96D34D07BF3F94332DDA120DA0B662A4", hash_generated_method = "96D34D07BF3F94332DDA120DA0B662A4")
    public DigestSchemeFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.199 -0400", hash_original_method = "C297ADB7309AAFCCA05FBFAFBC517584", hash_generated_method = "1EE79DFA7051B6D7D7255BE90AD50FDE")
    public AuthScheme newInstance(final HttpParams params) {
        addTaint(params.getTaint());
AuthScheme varD05AC4C156D1C08710E6AEE7CC042B98_1473580408 =         new DigestScheme();
        varD05AC4C156D1C08710E6AEE7CC042B98_1473580408.addTaint(taint);
        return varD05AC4C156D1C08710E6AEE7CC042B98_1473580408;
        // ---------- Original Method ----------
        //return new DigestScheme();
    }

    
}

