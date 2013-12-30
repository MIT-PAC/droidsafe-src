package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;



public class BasicPathHandler implements CookieAttributeHandler {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.857 -0500", hash_original_method = "D507B370C20AEA12D2B2206AC852AB3E", hash_generated_method = "67ED4D0442F1DBE4BB8514DF826F20D6")
    
public BasicPathHandler() {
        super();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.859 -0500", hash_original_method = "12481EFCA635CC4E9BAFE4DF6D2AACD1", hash_generated_method = "3BF6C6C971B01963D20B07AF04CDF274")
    
public void parse(final SetCookie cookie, String value) 
            throws MalformedCookieException {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (value == null || value.trim().length() == 0) {
            value = "/";
        }
        cookie.setPath(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.862 -0500", hash_original_method = "0E17290AD0357CAA03B07D7C65BD8191", hash_generated_method = "1BD3D837ED2E4782CC81A463058B085C")
    
public void validate(final Cookie cookie, final CookieOrigin origin) 
            throws MalformedCookieException {
        if (!match(cookie, origin)) {
            throw new MalformedCookieException(
                "Illegal path attribute \"" + cookie.getPath() 
                + "\". Path of origin: \"" + origin.getPath() + "\"");
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.864 -0500", hash_original_method = "59F4EE44791A28872894D32697E4B8A5", hash_generated_method = "EF8FF6C2F6492A283BFA5EE312C892A1")
    
public boolean match(final Cookie cookie, final CookieOrigin origin) {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (origin == null) {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
        String targetpath = origin.getPath();
        String topmostPath = cookie.getPath();
        if (topmostPath == null) {
            topmostPath = "/";
        }
        if (topmostPath.length() > 1 && topmostPath.endsWith("/")) {
            topmostPath = topmostPath.substring(0, topmostPath.length() - 1);
        }
        boolean match = targetpath.startsWith (topmostPath);
        // if there is a match and these values are not exactly the same we have
        // to make sure we're not matcing "/foobar" and "/foo"
        if (match && targetpath.length() != topmostPath.length()) {
            if (!topmostPath.endsWith("/")) {
                match = (targetpath.charAt(topmostPath.length()) == '/');
            }
        }
        return match;
    }

    
}

