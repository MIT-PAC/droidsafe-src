package org.apache.http.impl.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class BasicCommentHandler extends AbstractCookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.259 -0400", hash_original_method = "753BC5BDDB6B9E5E273FEAA2E3B0731A", hash_generated_method = "FE8BA2DCEA8CC629CBFD2093BB214103")
    public  BasicCommentHandler() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.259 -0400", hash_original_method = "99A929E9A1376512F0C10CD29D19768F", hash_generated_method = "54735C2D33C598AE2F742501BAE982C1")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        addTaint(value.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_59555416 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_59555416.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_59555416;
        } 
        cookie.setComment(value);
        
        
            
        
        
    }

    
}

