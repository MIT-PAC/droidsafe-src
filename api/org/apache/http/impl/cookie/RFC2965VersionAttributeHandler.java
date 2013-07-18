package org.apache.http.impl.cookie;

// Droidsafe Imports
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.cookie.SetCookie2;

import droidsafe.annotations.DSGenerator;

public class RFC2965VersionAttributeHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.269 -0400", hash_original_method = "02086819EBBDDEB16B7B0CCCD949EDD6", hash_generated_method = "F4CC2D5F1D77F371477AAE4AAEB51D1F")
    public  RFC2965VersionAttributeHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.270 -0400", hash_original_method = "0FDB9C61F8AE07052D8F8CD615F49E1D", hash_generated_method = "34B64C981FA7506560E6984607D08B04")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        addTaint(value.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1901878652 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1901878652.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1901878652;
        } //End block
        if(value == null)        
        {
            MalformedCookieException var34DCCD1FCF80B922AD071CE3DF09605E_1897426367 = new MalformedCookieException(
                    "Missing value for version attribute");
            var34DCCD1FCF80B922AD071CE3DF09605E_1897426367.addTaint(taint);
            throw var34DCCD1FCF80B922AD071CE3DF09605E_1897426367;
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
            MalformedCookieException var8F3155A5367AEFA185745CF64BE1DD7A_771079895 = new MalformedCookieException("Invalid cookie version.");
            var8F3155A5367AEFA185745CF64BE1DD7A_771079895.addTaint(taint);
            throw var8F3155A5367AEFA185745CF64BE1DD7A_771079895;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.271 -0400", hash_original_method = "918ECF249887C4F016B37391BBEA278F", hash_generated_method = "3D275840D874D549E736DCFB7786A888")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_545474787 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_545474787.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_545474787;
        } //End block
        if(cookie instanceof SetCookie2)        
        {
            if(cookie instanceof ClientCookie 
                    && !((ClientCookie) cookie).containsAttribute(ClientCookie.VERSION_ATTR))            
            {
                MalformedCookieException var9597818DB4D86BC41D6C007AF263A915_1346881404 = new MalformedCookieException(
                        "Violates RFC 2965. Version attribute is required.");
                var9597818DB4D86BC41D6C007AF263A915_1346881404.addTaint(taint);
                throw var9597818DB4D86BC41D6C007AF263A915_1346881404;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.271 -0400", hash_original_method = "768BC0018D608E66268B8C5C0AE76B3A", hash_generated_method = "C51314FA04635F566EA5C4A94D5E23CB")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_1575953224 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_950039078 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_950039078;
        // ---------- Original Method ----------
        //return true;
    }

    
}

