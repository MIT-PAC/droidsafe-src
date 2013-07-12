package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.params.CookieSpecPNames;
import org.apache.http.params.HttpParams;

public class BrowserCompatSpecFactory implements CookieSpecFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.459 -0400", hash_original_method = "F9F6A371DCC8057014285867BD71C0DB", hash_generated_method = "F9F6A371DCC8057014285867BD71C0DB")
    public BrowserCompatSpecFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.459 -0400", hash_original_method = "57B736694D04F685316FEE33170F38F5", hash_generated_method = "A6D1A0B9BD6EDD239AD07C088E2921F9")
    public CookieSpec newInstance(final HttpParams params) {
        addTaint(params.getTaint());
    if(params != null)        
        {
CookieSpec varA92262F24103FC4C591891F9D85E18F5_229897285 =             new BrowserCompatSpec(
                    (String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS));
            varA92262F24103FC4C591891F9D85E18F5_229897285.addTaint(taint);
            return varA92262F24103FC4C591891F9D85E18F5_229897285;
        } //End block
        else
        {
CookieSpec varAD59FB221DD4883BDB7567C50D9CE114_56775842 =             new BrowserCompatSpec();
            varAD59FB221DD4883BDB7567C50D9CE114_56775842.addTaint(taint);
            return varAD59FB221DD4883BDB7567C50D9CE114_56775842;
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

