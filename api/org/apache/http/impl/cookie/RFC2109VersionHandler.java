package org.apache.http.impl.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class RFC2109VersionHandler extends AbstractCookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.804 -0400", hash_original_method = "A02637D5820C2A953A6FE290A5D120D8", hash_generated_method = "78C075841E7848E13CAEA65D188AF82D")
    public  RFC2109VersionHandler() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.804 -0400", hash_original_method = "5A56CF450872EBA5B862F4919DADFF98", hash_generated_method = "B9F3D8B1EEEA691E8D38503F43789A6D")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        addTaint(value.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1834422305 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1834422305.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1834422305;
        } 
    if(value == null)        
        {
            MalformedCookieException var34DCCD1FCF80B922AD071CE3DF09605E_295107088 = new MalformedCookieException("Missing value for version attribute");
            var34DCCD1FCF80B922AD071CE3DF09605E_295107088.addTaint(taint);
            throw var34DCCD1FCF80B922AD071CE3DF09605E_295107088;
        } 
    if(value.trim().length() == 0)        
        {
            MalformedCookieException var9E0821B05EC087926FE26754E9A6E8A9_113896390 = new MalformedCookieException("Blank value for version attribute");
            var9E0821B05EC087926FE26754E9A6E8A9_113896390.addTaint(taint);
            throw var9E0821B05EC087926FE26754E9A6E8A9_113896390;
        } 
        try 
        {
            cookie.setVersion(Integer.parseInt(value));
        } 
        catch (NumberFormatException e)
        {
            MalformedCookieException varD51889F56C9974850BF557D7DEBC7B9B_1010459551 = new MalformedCookieException("Invalid version: " 
                + e.getMessage());
            varD51889F56C9974850BF557D7DEBC7B9B_1010459551.addTaint(taint);
            throw varD51889F56C9974850BF557D7DEBC7B9B_1010459551;
        } 
        
        
            
        
        
            
        
        
            
        
        
           
        
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.805 -0400", hash_original_method = "6D2DDC2021E2B84F83821AD58F1A72CF", hash_generated_method = "BE47C4213AC6A6F1EE46148AEE0FE332")
    @Override
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_672339690 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_672339690.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_672339690;
        } 
    if(cookie.getVersion() < 0)        
        {
            MalformedCookieException var7050461944FAC111CDEC8166970ACF79_1160388803 = new MalformedCookieException("Cookie version may not be negative");
            var7050461944FAC111CDEC8166970ACF79_1160388803.addTaint(taint);
            throw var7050461944FAC111CDEC8166970ACF79_1160388803;
        } 
        
        
            
        
        
            
        
    }

    
}

