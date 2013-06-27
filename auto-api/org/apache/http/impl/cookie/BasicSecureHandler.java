package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class BasicSecureHandler extends AbstractCookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.377 -0400", hash_original_method = "8C195B0159F6CD3FDBCB025498841E70", hash_generated_method = "EB71FD8D5EA92F60B1D5F8D8C5352236")
    public  BasicSecureHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.377 -0400", hash_original_method = "A846E7ED9E66A102D9E806FA0D60C627", hash_generated_method = "CE372C31271D0AAF85446924D9D960B1")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        cookie.setSecure(true);
        addTaint(cookie.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //cookie.setSecure(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.378 -0400", hash_original_method = "4FA33B6CF0EDC25DCB9ED37E197D753F", hash_generated_method = "766FCB8B0302FF06FC5FE3C56F5F2553")
    @Override
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } //End block
        boolean varBBD3ED614F66BBCEE4139937A8358360_724765365 = (!cookie.isSecure() || origin.isSecure());
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1413634148 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1413634148;
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (origin == null) {
            //throw new IllegalArgumentException("Cookie origin may not be null");
        //}
        //return !cookie.isSecure() || origin.isSecure();
    }

    
}

