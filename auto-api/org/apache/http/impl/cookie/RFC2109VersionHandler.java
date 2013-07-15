package org.apache.http.impl.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class RFC2109VersionHandler extends AbstractCookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.410 -0400", hash_original_method = "A02637D5820C2A953A6FE290A5D120D8", hash_generated_method = "78C075841E7848E13CAEA65D188AF82D")
    public  RFC2109VersionHandler() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.411 -0400", hash_original_method = "5A56CF450872EBA5B862F4919DADFF98", hash_generated_method = "837A936F41693FC93E32DB1961980800")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Missing value for version attribute");
        } 
        {
            boolean var9FBE5B3A34BFAF0B0EC7E39F0CD9C0B6_362275042 = (value.trim().length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Blank value for version attribute");
            } 
        } 
        try 
        {
            cookie.setVersion(Integer.parseInt(value));
        } 
        catch (NumberFormatException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Invalid version: " 
                + e.getMessage());
        } 
        addTaint(cookie.getTaint());
        addTaint(value.getTaint());
        
        
            
        
        
            
        
        
            
        
        
           
        
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.411 -0400", hash_original_method = "6D2DDC2021E2B84F83821AD58F1A72CF", hash_generated_method = "035B93AA3ECAB832DC7D62399B38AAB5")
    @Override
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } 
        {
            boolean var6408CC71C4BEE66767A32FE945897E63_71913926 = (cookie.getVersion() < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Cookie version may not be negative");
            } 
        } 
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        
        
            
        
        
            
        
    }

    
}

