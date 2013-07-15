package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.params.CookieSpecPNames;
import org.apache.http.params.HttpParams;

public class BestMatchSpecFactory implements CookieSpecFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.382 -0400", hash_original_method = "17A5B3D05891EED9B20E49D2F5F89B97", hash_generated_method = "17A5B3D05891EED9B20E49D2F5F89B97")
    public BestMatchSpecFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.382 -0400", hash_original_method = "2201EB1DC86453D4D2DD6749773278D9", hash_generated_method = "AA90101BCD6D66F37859D0269AD4350F")
    public CookieSpec newInstance(final HttpParams params) {
        addTaint(params.getTaint());
    if(params != null)        
        {
CookieSpec var5B07D68F628145C3DC72BF29838F2869_821275480 =             new BestMatchSpec(
                    (String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS), 
                    params.getBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, false));
            var5B07D68F628145C3DC72BF29838F2869_821275480.addTaint(taint);
            return var5B07D68F628145C3DC72BF29838F2869_821275480;
        } //End block
        else
        {
CookieSpec varB4F8B0D3D7831180BAA25A2DA9B70B16_159027641 =             new BestMatchSpec();
            varB4F8B0D3D7831180BAA25A2DA9B70B16_159027641.addTaint(taint);
            return varB4F8B0D3D7831180BAA25A2DA9B70B16_159027641;
        } //End block
        // ---------- Original Method ----------
        //if (params != null) {
            //return new BestMatchSpec(
                    //(String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS), 
                    //params.getBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, false));
        //} else {
            //return new BestMatchSpec();
        //}
    }

    
}

