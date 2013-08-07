package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.params.CookieSpecPNames;
import org.apache.http.params.HttpParams;



public class BrowserCompatSpecFactory implements CookieSpecFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.785 -0400", hash_original_method = "F9F6A371DCC8057014285867BD71C0DB", hash_generated_method = "F9F6A371DCC8057014285867BD71C0DB")
    public BrowserCompatSpecFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.786 -0400", hash_original_method = "57B736694D04F685316FEE33170F38F5", hash_generated_method = "74BC54B47A46E8ABA6EEAA64BBD5B14F")
    public CookieSpec newInstance(final HttpParams params) {
        addTaint(params.getTaint());
        if(params != null)        
        {
CookieSpec varA92262F24103FC4C591891F9D85E18F5_554708820 =             new BrowserCompatSpec(
                    (String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS));
            varA92262F24103FC4C591891F9D85E18F5_554708820.addTaint(taint);
            return varA92262F24103FC4C591891F9D85E18F5_554708820;
        } //End block
        else
        {
CookieSpec varAD59FB221DD4883BDB7567C50D9CE114_1529421919 =             new BrowserCompatSpec();
            varAD59FB221DD4883BDB7567C50D9CE114_1529421919.addTaint(taint);
            return varAD59FB221DD4883BDB7567C50D9CE114_1529421919;
        } //End block
        // ---------- Original Method ----------
        //if (params != null) {
            //return new BrowserCompatSpec(
                    //(String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS));
        //} else {
            //return new BrowserCompatSpec();
        //}
    }

    
}

