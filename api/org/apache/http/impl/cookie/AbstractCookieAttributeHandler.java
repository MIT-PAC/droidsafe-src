package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;

public abstract class AbstractCookieAttributeHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.516 -0400", hash_original_method = "ACDC61E94AD035B91D0DD3AC627F0897", hash_generated_method = "ACDC61E94AD035B91D0DD3AC627F0897")
    public AbstractCookieAttributeHandler ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.516 -0400", hash_original_method = "991845E9A77B56F0C05EBC8CED80518E", hash_generated_method = "8B6987ACBD2487D5D2EE39BB6FEC15C9")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.517 -0400", hash_original_method = "768BC0018D608E66268B8C5C0AE76B3A", hash_generated_method = "3E9FC91A3B05DCD6BF4C13DDD917D5CD")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_246815110 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_150490594 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_150490594;
        // ---------- Original Method ----------
        //return true;
    }

    
}

