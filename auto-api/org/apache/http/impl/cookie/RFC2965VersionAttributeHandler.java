package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.cookie.SetCookie2;

public class RFC2965VersionAttributeHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.768 -0400", hash_original_method = "02086819EBBDDEB16B7B0CCCD949EDD6", hash_generated_method = "F4CC2D5F1D77F371477AAE4AAEB51D1F")
    public  RFC2965VersionAttributeHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.768 -0400", hash_original_method = "0FDB9C61F8AE07052D8F8CD615F49E1D", hash_generated_method = "9E0ADCD83BE08CE057D13A7FE90D752C")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException(
                    "Missing value for version attribute");
        } //End block
        int version;
        version = -1;
        try 
        {
            version = Integer.parseInt(value);
        } //End block
        catch (NumberFormatException e)
        {
            version = -1;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Invalid cookie version.");
        } //End block
        cookie.setVersion(version);
        addTaint(cookie.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (value == null) {
            //throw new MalformedCookieException(
                    //"Missing value for version attribute");
        //}
        //int version = -1;
        //try {
            //version = Integer.parseInt(value);
        //} catch (NumberFormatException e) {
            //version = -1;
        //}
        //if (version < 0) {
            //throw new MalformedCookieException("Invalid cookie version.");
        //}
        //cookie.setVersion(version);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.785 -0400", hash_original_method = "918ECF249887C4F016B37391BBEA278F", hash_generated_method = "A35C9E33135E1B66D22DB20BCC8A829B")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            {
                boolean var7781200FBFE0FCA6DB7BCAE7195F162A_1589583429 = (cookie instanceof ClientCookie 
                    && !((ClientCookie) cookie).containsAttribute(ClientCookie.VERSION_ATTR));
                {
                    if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException(
                        "Violates RFC 2965. Version attribute is required.");
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (cookie instanceof SetCookie2) {
            //if (cookie instanceof ClientCookie 
                    //&& !((ClientCookie) cookie).containsAttribute(ClientCookie.VERSION_ATTR)) {
                //throw new MalformedCookieException(
                        //"Violates RFC 2965. Version attribute is required.");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.786 -0400", hash_original_method = "768BC0018D608E66268B8C5C0AE76B3A", hash_generated_method = "8A2650EA757621D363DFE9E5E52EF422")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1019966183 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1019966183;
        // ---------- Original Method ----------
        //return true;
    }

    
}

