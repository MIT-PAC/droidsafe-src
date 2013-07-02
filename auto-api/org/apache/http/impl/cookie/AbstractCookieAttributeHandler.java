package org.apache.http.impl.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;

public abstract class AbstractCookieAttributeHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.850 -0400", hash_original_method = "ACDC61E94AD035B91D0DD3AC627F0897", hash_generated_method = "ACDC61E94AD035B91D0DD3AC627F0897")
    public AbstractCookieAttributeHandler ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.851 -0400", hash_original_method = "991845E9A77B56F0C05EBC8CED80518E", hash_generated_method = "896AC0A8A922EA5D73734B2C4AE621C8")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.851 -0400", hash_original_method = "768BC0018D608E66268B8C5C0AE76B3A", hash_generated_method = "3756D417A28999E004F03CE32FB9BDA4")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_702729829 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_702729829;
        
        
    }

    
}

