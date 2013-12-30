package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;



public class BasicSecureHandler extends AbstractCookieAttributeHandler {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.527 -0500", hash_original_method = "8C195B0159F6CD3FDBCB025498841E70", hash_generated_method = "410FDC481EA317E71F8F0BFF49C1BD98")
    
public BasicSecureHandler() {
        super();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.529 -0500", hash_original_method = "A846E7ED9E66A102D9E806FA0D60C627", hash_generated_method = "6B5AD2FBA8C10B7042A825672DE203BD")
    
public void parse(final SetCookie cookie, final String value) 
            throws MalformedCookieException {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        cookie.setSecure(true);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.531 -0500", hash_original_method = "4FA33B6CF0EDC25DCB9ED37E197D753F", hash_generated_method = "BE5278EC66C288E5C6D7C2975A2E80AF")
    
@Override
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (origin == null) {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
        return !cookie.isSecure() || origin.isSecure();
    }

    
}

