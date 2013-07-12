package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.params.CookieSpecPNames;
import org.apache.http.params.HttpParams;

public class RFC2109SpecFactory implements CookieSpecFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.797 -0400", hash_original_method = "D388D125B30D289290BCCEEE1DC724F5", hash_generated_method = "D388D125B30D289290BCCEEE1DC724F5")
    public RFC2109SpecFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.797 -0400", hash_original_method = "319F84F2475AFEEE24E68A878D2B0074", hash_generated_method = "57B1C80ADC1BCD243E979E51FDED93F8")
    public CookieSpec newInstance(final HttpParams params) {
        addTaint(params.getTaint());
    if(params != null)        
        {
CookieSpec var536902E205C4FCF251216F065D8F7073_473345303 =             new RFC2109Spec(
                    (String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS), 
                    params.getBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, false));
            var536902E205C4FCF251216F065D8F7073_473345303.addTaint(taint);
            return var536902E205C4FCF251216F065D8F7073_473345303;
        } //End block
        else
        {
CookieSpec varDC84E44E1005E8102B12913F71F9EE55_632752643 =             new RFC2109Spec();
            varDC84E44E1005E8102B12913F71F9EE55_632752643.addTaint(taint);
            return varDC84E44E1005E8102B12913F71F9EE55_632752643;
        } //End block
        // ---------- Original Method ----------
        //if (params != null) {
            //return new RFC2109Spec(
                    //(String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS), 
                    //params.getBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, false));
        //} else {
            //return new RFC2109Spec();
        //}
    }

    
}

