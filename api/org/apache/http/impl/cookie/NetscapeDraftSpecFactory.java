package org.apache.http.impl.cookie;

// Droidsafe Imports
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.params.CookieSpecPNames;
import org.apache.http.params.HttpParams;

import droidsafe.annotations.DSGenerator;

public class NetscapeDraftSpecFactory implements CookieSpecFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.990 -0400", hash_original_method = "E0E1E20239023582A4617467D7E49523", hash_generated_method = "E0E1E20239023582A4617467D7E49523")
    public NetscapeDraftSpecFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.991 -0400", hash_original_method = "34FA08500657FDD515515AEEA52740F3", hash_generated_method = "0D8D4A5BE1B08BE1EABC45789148F989")
    public CookieSpec newInstance(final HttpParams params) {
        addTaint(params.getTaint());
        if(params != null)        
        {
CookieSpec var96CBEA9474E54B876F43D0D6639FD283_2071101261 =             new NetscapeDraftSpec(
                    (String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS));
            var96CBEA9474E54B876F43D0D6639FD283_2071101261.addTaint(taint);
            return var96CBEA9474E54B876F43D0D6639FD283_2071101261;
        } //End block
        else
        {
CookieSpec var453FBAFF3F71B66A1C01DE3710331CA9_262372115 =             new NetscapeDraftSpec();
            var453FBAFF3F71B66A1C01DE3710331CA9_262372115.addTaint(taint);
            return var453FBAFF3F71B66A1C01DE3710331CA9_262372115;
        } //End block
        // ---------- Original Method ----------
        //if (params != null) {
            //return new NetscapeDraftSpec(
                    //(String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS));
        //} else {
            //return new NetscapeDraftSpec();
        //}
    }

    
}

