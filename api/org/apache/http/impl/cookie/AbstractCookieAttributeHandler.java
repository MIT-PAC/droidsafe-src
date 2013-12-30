package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.652 -0500", hash_original_method = "991845E9A77B56F0C05EBC8CED80518E", hash_generated_method = "F5F718185A8E0FD50A5A93C111F26BF0")
    
public void validate(final Cookie cookie, final CookieOrigin origin) 
            throws MalformedCookieException {
        // Do nothing
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.655 -0500", hash_original_method = "768BC0018D608E66268B8C5C0AE76B3A", hash_generated_method = "05FE84FAC9EAB94CC6D4B35D828E3EDB")
    
public boolean match(final Cookie cookie, final CookieOrigin origin) {
        // Always match
        return true;
    }

    
}

