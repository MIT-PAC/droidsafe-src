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

public class RFC2109VersionHandler extends AbstractCookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.415 -0400", hash_original_method = "A02637D5820C2A953A6FE290A5D120D8", hash_generated_method = "78C075841E7848E13CAEA65D188AF82D")
    public  RFC2109VersionHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.416 -0400", hash_original_method = "5A56CF450872EBA5B862F4919DADFF98", hash_generated_method = "B35359CEBA747AA75272A3D6CF0031F1")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Missing value for version attribute");
        } //End block
        {
            boolean var9FBE5B3A34BFAF0B0EC7E39F0CD9C0B6_2070143472 = (value.trim().length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Blank value for version attribute");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            cookie.setVersion(Integer.parseInt(value));
        } //End block
        catch (NumberFormatException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Invalid version: " 
                + e.getMessage());
        } //End block
        addTaint(cookie.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (value == null) {
            //throw new MalformedCookieException("Missing value for version attribute");
        //}
        //if (value.trim().length() == 0) {
            //throw new MalformedCookieException("Blank value for version attribute");
        //}
        //try {
           //cookie.setVersion(Integer.parseInt(value));
        //} catch (NumberFormatException e) {
            //throw new MalformedCookieException("Invalid version: " 
                //+ e.getMessage());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.416 -0400", hash_original_method = "6D2DDC2021E2B84F83821AD58F1A72CF", hash_generated_method = "228C55E913981D462D0DC91F8C2CE48A")
    @Override
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            boolean var6408CC71C4BEE66767A32FE945897E63_1557213851 = (cookie.getVersion() < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Cookie version may not be negative");
            } //End block
        } //End collapsed parenthetic
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (cookie.getVersion() < 0) {
            //throw new MalformedCookieException("Cookie version may not be negative");
        //}
    }

    
}

