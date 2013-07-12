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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.919 -0400", hash_original_method = "D18808A8475C9A632DDF495DEFF2DFBD", hash_generated_method = "D18808A8475C9A632DDF495DEFF2DFBD")
    public RFC2965SpecFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.920 -0400", hash_original_method = "9B95DA0587FBFA9E43990E1A6723C326", hash_generated_method = "06DE73A798E5674C7B8A1B3411F48140")
    public CookieSpec newInstance(final HttpParams params) {
        addTaint(params.getTaint());
    if(params != null)        
        {
CookieSpec var269994C17362685496F31DB81565F8D8_934774287 =             new RFC2965Spec(
                    (String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS), 
                    params.getBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, false));
            var269994C17362685496F31DB81565F8D8_934774287.addTaint(taint);
            return var269994C17362685496F31DB81565F8D8_934774287;
        } //End block
        else
        {
CookieSpec var6F9F70C27FB73F5BA626E1660722EED9_1774334019 =             new RFC2965Spec();
            var6F9F70C27FB73F5BA626E1660722EED9_1774334019.addTaint(taint);
            return var6F9F70C27FB73F5BA626E1660722EED9_1774334019;
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

