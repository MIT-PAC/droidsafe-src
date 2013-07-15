package org.apache.http.impl.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.cookie.SetCookie2;

public class RFC2965VersionAttributeHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.516 -0400", hash_original_method = "02086819EBBDDEB16B7B0CCCD949EDD6", hash_generated_method = "F4CC2D5F1D77F371477AAE4AAEB51D1F")
    public  RFC2965VersionAttributeHandler() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.517 -0400", hash_original_method = "0FDB9C61F8AE07052D8F8CD615F49E1D", hash_generated_method = "63E60F2BD6534C6F1076C7965FAD64C8")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException(
                    "Missing value for version attribute");
        } 
        int version = -1;
        try 
        {
            version = Integer.parseInt(value);
        } 
        catch (NumberFormatException e)
        {
            version = -1;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Invalid cookie version.");
        } 
        cookie.setVersion(version);
        addTaint(cookie.getTaint());
        addTaint(value.getTaint());
        
        
            
        
        
            
                    
        
        
        
            
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.517 -0400", hash_original_method = "918ECF249887C4F016B37391BBEA278F", hash_generated_method = "6303FD2F53257A62918A41458BA32A84")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } 
        {
            {
                boolean var7781200FBFE0FCA6DB7BCAE7195F162A_2059922089 = (cookie instanceof ClientCookie 
                    && !((ClientCookie) cookie).containsAttribute(ClientCookie.VERSION_ATTR));
                {
                    if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException(
                        "Violates RFC 2965. Version attribute is required.");
                } 
            } 
        } 
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        
        
            
        
        
            
                    
                
                        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.518 -0400", hash_original_method = "768BC0018D608E66268B8C5C0AE76B3A", hash_generated_method = "C1EF3B8AEA87686C00A0DCD0AE14818A")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1879899061 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1879899061;
        
        
    }

    
}

