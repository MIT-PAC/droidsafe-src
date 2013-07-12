package org.apache.http.impl.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;

public abstract class AbstractCookieAttributeHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.196 -0400", hash_original_method = "ACDC61E94AD035B91D0DD3AC627F0897", hash_generated_method = "ACDC61E94AD035B91D0DD3AC627F0897")
    public AbstractCookieAttributeHandler ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.196 -0400", hash_original_method = "991845E9A77B56F0C05EBC8CED80518E", hash_generated_method = "8B6987ACBD2487D5D2EE39BB6FEC15C9")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.197 -0400", hash_original_method = "768BC0018D608E66268B8C5C0AE76B3A", hash_generated_method = "6CF32D7BE9E4821CE8D1C73C93BA1A06")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_2145534966 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1999392541 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1999392541;
        
        
    }

    
}

