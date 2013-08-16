package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.params.CookieSpecPNames;
import org.apache.http.params.HttpParams;



public class BestMatchSpecFactory implements CookieSpecFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.716 -0400", hash_original_method = "17A5B3D05891EED9B20E49D2F5F89B97", hash_generated_method = "17A5B3D05891EED9B20E49D2F5F89B97")
    public BestMatchSpecFactory ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.717 -0400", hash_original_method = "2201EB1DC86453D4D2DD6749773278D9", hash_generated_method = "F87EDE2C44AAF4E370FE9E7CD2F51D76")
    public CookieSpec newInstance(final HttpParams params) {
        addTaint(params.getTaint());
        if(params != null)        
        {
CookieSpec var5B07D68F628145C3DC72BF29838F2869_1155813725 =             new BestMatchSpec(
                    (String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS), 
                    params.getBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, false));
            var5B07D68F628145C3DC72BF29838F2869_1155813725.addTaint(taint);
            return var5B07D68F628145C3DC72BF29838F2869_1155813725;
        } //End block
        else
        {
CookieSpec varB4F8B0D3D7831180BAA25A2DA9B70B16_2013470475 =             new BestMatchSpec();
            varB4F8B0D3D7831180BAA25A2DA9B70B16_2013470475.addTaint(taint);
            return varB4F8B0D3D7831180BAA25A2DA9B70B16_2013470475;
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

