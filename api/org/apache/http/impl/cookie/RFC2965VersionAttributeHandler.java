package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.cookie.SetCookie2;



public class RFC2965VersionAttributeHandler implements CookieAttributeHandler {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.074 -0500", hash_original_method = "02086819EBBDDEB16B7B0CCCD949EDD6", hash_generated_method = "075DA2BCDF46547ECA372D2ADECFD138")
    
public RFC2965VersionAttributeHandler() {
        super();
    }
    
    /**
     * Parse cookie version attribute.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.076 -0500", hash_original_method = "0FDB9C61F8AE07052D8F8CD615F49E1D", hash_generated_method = "2493344E11F7398B57B9AAA7979140BA")
    
public void parse(final SetCookie cookie, final String value)
            throws MalformedCookieException {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (value == null) {
            throw new MalformedCookieException(
                    "Missing value for version attribute");
        }
        int version = -1;
        try {
            version = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            version = -1;
        }
        if (version < 0) {
            throw new MalformedCookieException("Invalid cookie version.");
        }
        cookie.setVersion(version);
    }

    /**
     * validate cookie version attribute. Version attribute is REQUIRED.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.079 -0500", hash_original_method = "918ECF249887C4F016B37391BBEA278F", hash_generated_method = "301F5C320490EF5686C8A09564CA9E06")
    
public void validate(final Cookie cookie, final CookieOrigin origin)
            throws MalformedCookieException {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (cookie instanceof SetCookie2) {
            if (cookie instanceof ClientCookie 
                    && !((ClientCookie) cookie).containsAttribute(ClientCookie.VERSION_ATTR)) {
                throw new MalformedCookieException(
                        "Violates RFC 2965. Version attribute is required.");
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.081 -0500", hash_original_method = "768BC0018D608E66268B8C5C0AE76B3A", hash_generated_method = "D83CEB3751B5960131E4566E29C7FC53")
    
public boolean match(final Cookie cookie, final CookieOrigin origin) {
        return true;
    }

    
}

