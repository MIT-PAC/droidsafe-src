package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class BasicPathHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.399 -0400", hash_original_method = "D507B370C20AEA12D2B2206AC852AB3E", hash_generated_method = "44D4B69B86148693F02C8C98C15CB121")
    public  BasicPathHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.400 -0400", hash_original_method = "12481EFCA635CC4E9BAFE4DF6D2AACD1", hash_generated_method = "3839F4536C9265422A69CB630AB83056")
    public void parse(final SetCookie cookie, String value) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            boolean varB0FB804512D41BBC09207BBEA20F1D18_1451204098 = (value == null || value.trim().length() == 0);
            {
                value = "/";
            } //End block
        } //End collapsed parenthetic
        cookie.setPath(value);
        addTaint(cookie.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (value == null || value.trim().length() == 0) {
            //value = "/";
        //}
        //cookie.setPath(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.400 -0400", hash_original_method = "0E17290AD0357CAA03B07D7C65BD8191", hash_generated_method = "9717D5EB0C7A3C82027505952639569A")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        {
            boolean var22B9778726E5AED0D091E4ACCB990391_1161520246 = (!match(cookie, origin));
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException(
                "Illegal path attribute \"" + cookie.getPath() 
                + "\". Path of origin: \"" + origin.getPath() + "\"");
            } //End block
        } //End collapsed parenthetic
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        // ---------- Original Method ----------
        //if (!match(cookie, origin)) {
            //throw new MalformedCookieException(
                //"Illegal path attribute \"" + cookie.getPath() 
                //+ "\". Path of origin: \"" + origin.getPath() + "\"");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.401 -0400", hash_original_method = "59F4EE44791A28872894D32697E4B8A5", hash_generated_method = "68C06FC3BDDAAA4108FF8FC9634B20B2")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } //End block
        String targetpath;
        targetpath = origin.getPath();
        String topmostPath;
        topmostPath = cookie.getPath();
        {
            topmostPath = "/";
        } //End block
        {
            boolean varD0DCCFA85A06A52225986A2E5479BCE0_1419936051 = (topmostPath.length() > 1 && topmostPath.endsWith("/"));
            {
                topmostPath = topmostPath.substring(0, topmostPath.length() - 1);
            } //End block
        } //End collapsed parenthetic
        boolean match;
        match = targetpath.startsWith (topmostPath);
        {
            boolean var3F006F7454D83BE96E99B33C9094EDD2_1937912884 = (match && targetpath.length() != topmostPath.length());
            {
                {
                    boolean var0EB4D4F54A0DC3EB5ED399DE2AC1F7DC_1496623172 = (!topmostPath.endsWith("/"));
                    {
                        match = (targetpath.charAt(topmostPath.length()) == '/');
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2120253134 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2120253134;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

