package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.params.CookieSpecPNames;
import org.apache.http.params.HttpParams;

public class RFC2965SpecFactory implements CookieSpecFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.260 -0400", hash_original_method = "D18808A8475C9A632DDF495DEFF2DFBD", hash_generated_method = "D18808A8475C9A632DDF495DEFF2DFBD")
    public RFC2965SpecFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.261 -0400", hash_original_method = "9B95DA0587FBFA9E43990E1A6723C326", hash_generated_method = "DBFB3E1560248834F7EF18FE4B29BE14")
    public CookieSpec newInstance(final HttpParams params) {
        addTaint(params.getTaint());
        if(params != null)        
        {
CookieSpec var269994C17362685496F31DB81565F8D8_1781730171 =             new RFC2965Spec(
                    (String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS), 
                    params.getBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, false));
            var269994C17362685496F31DB81565F8D8_1781730171.addTaint(taint);
            return var269994C17362685496F31DB81565F8D8_1781730171;
        } //End block
        else
        {
CookieSpec var6F9F70C27FB73F5BA626E1660722EED9_144491849 =             new RFC2965Spec();
            var6F9F70C27FB73F5BA626E1660722EED9_144491849.addTaint(taint);
            return var6F9F70C27FB73F5BA626E1660722EED9_144491849;
        } //End block
        // ---------- Original Method ----------
        //if (params != null) {
            //return new RFC2965Spec(
                    //(String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS), 
                    //params.getBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, false));
        //} else {
            //return new RFC2965Spec();
        //}
    }

    
}

