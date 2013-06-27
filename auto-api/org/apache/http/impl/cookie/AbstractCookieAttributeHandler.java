package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;

public abstract class AbstractCookieAttributeHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.142 -0400", hash_original_method = "ACDC61E94AD035B91D0DD3AC627F0897", hash_generated_method = "ACDC61E94AD035B91D0DD3AC627F0897")
    public AbstractCookieAttributeHandler ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.142 -0400", hash_original_method = "991845E9A77B56F0C05EBC8CED80518E", hash_generated_method = "896AC0A8A922EA5D73734B2C4AE621C8")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.143 -0400", hash_original_method = "768BC0018D608E66268B8C5C0AE76B3A", hash_generated_method = "45CAB7FBE6E659091B70A7DCC0BDD059")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1981885728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1981885728;
        // ---------- Original Method ----------
        //return true;
    }

    
}

