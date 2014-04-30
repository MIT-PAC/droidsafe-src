package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.params.CookieSpecPNames;
import org.apache.http.params.HttpParams;

public class RFC2109SpecFactory implements CookieSpecFactory {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.117 -0400", hash_original_method = "D388D125B30D289290BCCEEE1DC724F5", hash_generated_method = "D388D125B30D289290BCCEEE1DC724F5")
    public RFC2109SpecFactory ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.796 -0500", hash_original_method = "319F84F2475AFEEE24E68A878D2B0074", hash_generated_method = "70DCD4905B5FB795B8518E403DAA5BC0")
    
public CookieSpec newInstance(final HttpParams params) {
        if (params != null) {
            return new RFC2109Spec(
                    (String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS), 
                    params.getBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, false));
        } else {
            return new RFC2109Spec();
        }
    }
    
}

