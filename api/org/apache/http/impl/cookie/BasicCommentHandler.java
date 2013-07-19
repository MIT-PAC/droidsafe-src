package org.apache.http.impl.cookie;

// Droidsafe Imports
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

import droidsafe.annotations.DSGenerator;

public class BasicCommentHandler extends AbstractCookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.582 -0400", hash_original_method = "753BC5BDDB6B9E5E273FEAA2E3B0731A", hash_generated_method = "FE8BA2DCEA8CC629CBFD2093BB214103")
    public  BasicCommentHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.583 -0400", hash_original_method = "99A929E9A1376512F0C10CD29D19768F", hash_generated_method = "C1AEBF38AE40ADB17323AF44FC857632")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        addTaint(value.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1974142657 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1974142657.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1974142657;
        } //End block
        cookie.setComment(value);
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //cookie.setComment(value);
    }

    
}

