package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class BasicPathHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.308 -0400", hash_original_method = "D507B370C20AEA12D2B2206AC852AB3E", hash_generated_method = "44D4B69B86148693F02C8C98C15CB121")
    public  BasicPathHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.309 -0400", hash_original_method = "12481EFCA635CC4E9BAFE4DF6D2AACD1", hash_generated_method = "B265234F72D9917BD9FBC37CF7EB3E92")
    public void parse(final SetCookie cookie, String value) throws MalformedCookieException {
        addTaint(value.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1888759349 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1888759349.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1888759349;
        } //End block
    if(value == null || value.trim().length() == 0)        
        {
            value = "/";
        } //End block
        cookie.setPath(value);
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (value == null || value.trim().length() == 0) {
            //value = "/";
        //}
        //cookie.setPath(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.309 -0400", hash_original_method = "0E17290AD0357CAA03B07D7C65BD8191", hash_generated_method = "438EA894D0DDBF4DB5F8A958EAF11494")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
    if(!match(cookie, origin))        
        {
            MalformedCookieException var2D07A53716A7572BCCE4D1E6032C6331_1541601506 = new MalformedCookieException(
                "Illegal path attribute \"" + cookie.getPath() 
                + "\". Path of origin: \"" + origin.getPath() + "\"");
            var2D07A53716A7572BCCE4D1E6032C6331_1541601506.addTaint(taint);
            throw var2D07A53716A7572BCCE4D1E6032C6331_1541601506;
        } //End block
        // ---------- Original Method ----------
        //if (!match(cookie, origin)) {
            //throw new MalformedCookieException(
                //"Illegal path attribute \"" + cookie.getPath() 
                //+ "\". Path of origin: \"" + origin.getPath() + "\"");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.311 -0400", hash_original_method = "59F4EE44791A28872894D32697E4B8A5", hash_generated_method = "81AEC3BF1087DA3390C096D63C268C76")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_944940128 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_944940128.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_944940128;
        } //End block
    if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_358196727 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_358196727.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_358196727;
        } //End block
        String targetpath = origin.getPath();
        String topmostPath = cookie.getPath();
    if(topmostPath == null)        
        {
            topmostPath = "/";
        } //End block
    if(topmostPath.length() > 1 && topmostPath.endsWith("/"))        
        {
            topmostPath = topmostPath.substring(0, topmostPath.length() - 1);
        } //End block
        boolean match = targetpath.startsWith (topmostPath);
    if(match && targetpath.length() != topmostPath.length())        
        {
    if(!topmostPath.endsWith("/"))            
            {
                match = (targetpath.charAt(topmostPath.length()) == '/');
            } //End block
        } //End block
        boolean varE3CC92C14A5E6DD1A7D94B6FF634D7FC_720172449 = (match);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1282442974 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1282442974;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

