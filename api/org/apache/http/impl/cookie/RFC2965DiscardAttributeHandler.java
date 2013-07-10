package org.apache.http.impl.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.cookie.SetCookie2;

public class RFC2965DiscardAttributeHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.421 -0400", hash_original_method = "40A04040358E10BE463BC9E2FF4354F7", hash_generated_method = "A8A4D4F0913E8CA95AF486E5DDC0A437")
    public  RFC2965DiscardAttributeHandler() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.422 -0400", hash_original_method = "16D6C58BF1FAAA0E132C741E4AC6541B", hash_generated_method = "426F133F173C1E58FA5D8CB423577ACC")
    public void parse(final SetCookie cookie, final String commenturl) throws MalformedCookieException {
        {
            SetCookie2 cookie2 = (SetCookie2) cookie;
            cookie2.setDiscard(true);
        } 
        addTaint(cookie.getTaint());
        addTaint(commenturl.getTaint());
        
        
              
              
          
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.422 -0400", hash_original_method = "991845E9A77B56F0C05EBC8CED80518E", hash_generated_method = "896AC0A8A922EA5D73734B2C4AE621C8")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.423 -0400", hash_original_method = "768BC0018D608E66268B8C5C0AE76B3A", hash_generated_method = "877805E31A3092B7224B7633CC126428")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_86868130 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_86868130;
        
        
    }

    
}

