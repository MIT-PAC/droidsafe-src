package org.apache.http.impl.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.params.CookieSpecPNames;
import org.apache.http.params.HttpParams;

public class NetscapeDraftSpecFactory implements CookieSpecFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.658 -0400", hash_original_method = "E0E1E20239023582A4617467D7E49523", hash_generated_method = "E0E1E20239023582A4617467D7E49523")
    public NetscapeDraftSpecFactory ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.658 -0400", hash_original_method = "34FA08500657FDD515515AEEA52740F3", hash_generated_method = "756BEC8021C73DEC33DFFCC911F3E23D")
    public CookieSpec newInstance(final HttpParams params) {
        addTaint(params.getTaint());
    if(params != null)        
        {
CookieSpec var96CBEA9474E54B876F43D0D6639FD283_238549182 =             new NetscapeDraftSpec(
                    (String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS));
            var96CBEA9474E54B876F43D0D6639FD283_238549182.addTaint(taint);
            return var96CBEA9474E54B876F43D0D6639FD283_238549182;
        } 
        else
        {
CookieSpec var453FBAFF3F71B66A1C01DE3710331CA9_1232223221 =             new NetscapeDraftSpec();
            var453FBAFF3F71B66A1C01DE3710331CA9_1232223221.addTaint(taint);
            return var453FBAFF3F71B66A1C01DE3710331CA9_1232223221;
        } 
        
        
            
                    
        
            
        
    }

    
}

