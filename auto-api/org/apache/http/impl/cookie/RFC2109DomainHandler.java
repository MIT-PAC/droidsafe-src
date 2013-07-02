package org.apache.http.impl.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Locale;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class RFC2109DomainHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.293 -0400", hash_original_method = "BA3C0693A4254304D076B6F4F238BB9F", hash_generated_method = "792C59D9D2B3A1BF306F01640B547EEC")
    public  RFC2109DomainHandler() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.293 -0400", hash_original_method = "A2A30C6200DB9994662FDA726DA35D9E", hash_generated_method = "F951FCC21BAACB024B5B5A26FAD41938")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Missing value for domain attribute");
        } 
        {
            boolean var9FBE5B3A34BFAF0B0EC7E39F0CD9C0B6_958206716 = (value.trim().length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Blank value for domain attribute");
            } 
        } 
        cookie.setDomain(value);
        addTaint(cookie.getTaint());
        addTaint(value.getTaint());
        
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.294 -0400", hash_original_method = "B2BF5046DB79177D44AB1563AAF5AFFB", hash_generated_method = "76CFC357CDBE9F67AF3306BE1D1B8823")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } 
        String host = origin.getHost();
        String domain = cookie.getDomain();
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Cookie domain may not be null");
        } 
        {
            boolean varDF00A4A746D4F13DFC9772ADDA702974_833017160 = (!domain.equals(host));
            {
                int dotIndex = domain.indexOf('.');
                {
                    if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Domain attribute \"" 
                        + domain 
                        + "\" does not match the host \"" 
                        + host + "\"");
                } 
                {
                    boolean varDD0C5D77A22559311347468CC8DBDB32_706629111 = (!domain.startsWith("."));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Domain attribute \"" 
                    + domain 
                    + "\" violates RFC 2109: domain must start with a dot");
                    } 
                } 
                dotIndex = domain.indexOf('.', 1);
                {
                    boolean var799E18FB6D5BD5416B7EBCBE80C32465_265365279 = (dotIndex < 0 || dotIndex == domain.length() - 1);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Domain attribute \"" 
                    + domain 
                    + "\" violates RFC 2109: domain must contain an embedded dot");
                    } 
                } 
                host = host.toLowerCase(Locale.ENGLISH);
                {
                    boolean var4CC5C42A13FF000FBBF07CCD71946771_1981229148 = (!host.endsWith(domain));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException(
                    "Illegal domain attribute \"" + domain 
                    + "\". Domain of origin: \"" + host + "\"");
                    } 
                } 
                String hostWithoutDomain = host.substring(0, host.length() - domain.length());
                {
                    boolean varDE5B1218E068294DF30CA1D70588DEFD_337203437 = (hostWithoutDomain.indexOf('.') != -1);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Domain attribute \"" 
                    + domain 
                    + "\" violates RFC 2109: host minus domain may not contain any dots");
                    } 
                } 
            } 
        } 
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.294 -0400", hash_original_method = "366C15EED829D9311CF9BF5EB777430B", hash_generated_method = "39E4B954706000AFFD7B3CBBC7154119")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } 
        String host = origin.getHost();
        String domain = cookie.getDomain();
        boolean varD3BEE7717F5C53B8019886A641FD7C0D_1648555869 = (host.equals(domain) || (domain.startsWith(".") && host.endsWith(domain)));
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1629419331 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1629419331;
        
        
            
        
        
            
        
        
        
        
            
        
        
    }

    
}

