package org.apache.http.impl.cookie;

// Droidsafe Imports
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

import droidsafe.annotations.DSGenerator;

public class BasicPathHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.648 -0400", hash_original_method = "D507B370C20AEA12D2B2206AC852AB3E", hash_generated_method = "44D4B69B86148693F02C8C98C15CB121")
    public  BasicPathHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.649 -0400", hash_original_method = "12481EFCA635CC4E9BAFE4DF6D2AACD1", hash_generated_method = "7F8ACBF6B8898BD19B9E36449E156F23")
    public void parse(final SetCookie cookie, String value) throws MalformedCookieException {
        addTaint(value.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_676152100 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_676152100.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_676152100;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.649 -0400", hash_original_method = "0E17290AD0357CAA03B07D7C65BD8191", hash_generated_method = "0888D140378C24F9E59C5F02F916E98C")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        if(!match(cookie, origin))        
        {
            MalformedCookieException var2D07A53716A7572BCCE4D1E6032C6331_1855192473 = new MalformedCookieException(
                "Illegal path attribute \"" + cookie.getPath() 
                + "\". Path of origin: \"" + origin.getPath() + "\"");
            var2D07A53716A7572BCCE4D1E6032C6331_1855192473.addTaint(taint);
            throw var2D07A53716A7572BCCE4D1E6032C6331_1855192473;
        } //End block
        // ---------- Original Method ----------
        //if (!match(cookie, origin)) {
            //throw new MalformedCookieException(
                //"Illegal path attribute \"" + cookie.getPath() 
                //+ "\". Path of origin: \"" + origin.getPath() + "\"");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.650 -0400", hash_original_method = "59F4EE44791A28872894D32697E4B8A5", hash_generated_method = "8B1077FED8B36279A161BB31182AFC7D")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_380325606 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_380325606.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_380325606;
        } //End block
        if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_1300151795 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_1300151795.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_1300151795;
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
        boolean varE3CC92C14A5E6DD1A7D94B6FF634D7FC_688025175 = (match);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1424636610 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1424636610;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

