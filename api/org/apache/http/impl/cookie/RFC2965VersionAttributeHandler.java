package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.cookie.SetCookie2;

public class RFC2965VersionAttributeHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.926 -0400", hash_original_method = "02086819EBBDDEB16B7B0CCCD949EDD6", hash_generated_method = "F4CC2D5F1D77F371477AAE4AAEB51D1F")
    public  RFC2965VersionAttributeHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.927 -0400", hash_original_method = "0FDB9C61F8AE07052D8F8CD615F49E1D", hash_generated_method = "120125934504F5213459FA2A4AB343EE")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        addTaint(value.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_866631410 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_866631410.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_866631410;
        } //End block
    if(value == null)        
        {
            MalformedCookieException var34DCCD1FCF80B922AD071CE3DF09605E_1355943271 = new MalformedCookieException(
                    "Missing value for version attribute");
            var34DCCD1FCF80B922AD071CE3DF09605E_1355943271.addTaint(taint);
            throw var34DCCD1FCF80B922AD071CE3DF09605E_1355943271;
        } //End block
        int version = -1;
        try 
        {
            version = Integer.parseInt(value);
        } //End block
        catch (NumberFormatException e)
        {
            version = -1;
        } //End block
    if(version < 0)        
        {
            MalformedCookieException var8F3155A5367AEFA185745CF64BE1DD7A_1317879734 = new MalformedCookieException("Invalid cookie version.");
            var8F3155A5367AEFA185745CF64BE1DD7A_1317879734.addTaint(taint);
            throw var8F3155A5367AEFA185745CF64BE1DD7A_1317879734;
        } //End block
        cookie.setVersion(version);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.927 -0400", hash_original_method = "918ECF249887C4F016B37391BBEA278F", hash_generated_method = "C10AD0EF43520B0A78BA4BC963944211")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1345495827 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1345495827.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1345495827;
        } //End block
    if(cookie instanceof SetCookie2)        
        {
    if(cookie instanceof ClientCookie 
                    && !((ClientCookie) cookie).containsAttribute(ClientCookie.VERSION_ATTR))            
            {
                MalformedCookieException var9597818DB4D86BC41D6C007AF263A915_889369329 = new MalformedCookieException(
                        "Violates RFC 2965. Version attribute is required.");
                var9597818DB4D86BC41D6C007AF263A915_889369329.addTaint(taint);
                throw var9597818DB4D86BC41D6C007AF263A915_889369329;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.928 -0400", hash_original_method = "768BC0018D608E66268B8C5C0AE76B3A", hash_generated_method = "6AFB4E75C197E64E0A6E3E243B8C33AE")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_576816859 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_799316830 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_799316830;
        // ---------- Original Method ----------
        //return true;
    }

    
}

