package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Locale;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class RFC2109DomainHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.388 -0400", hash_original_method = "BA3C0693A4254304D076B6F4F238BB9F", hash_generated_method = "792C59D9D2B3A1BF306F01640B547EEC")
    public  RFC2109DomainHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.388 -0400", hash_original_method = "A2A30C6200DB9994662FDA726DA35D9E", hash_generated_method = "3BC903801D643FAE9DD5214B64CF20D7")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Missing value for domain attribute");
        } //End block
        {
            boolean var9FBE5B3A34BFAF0B0EC7E39F0CD9C0B6_1318061272 = (value.trim().length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Blank value for domain attribute");
            } //End block
        } //End collapsed parenthetic
        cookie.setDomain(value);
        addTaint(cookie.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (value == null) {
            //throw new MalformedCookieException("Missing value for domain attribute");
        //}
        //if (value.trim().length() == 0) {
            //throw new MalformedCookieException("Blank value for domain attribute");
        //}
        //cookie.setDomain(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.390 -0400", hash_original_method = "B2BF5046DB79177D44AB1563AAF5AFFB", hash_generated_method = "45649EDEA53B7FA09E481C0AD4C7E33E")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } //End block
        String host;
        host = origin.getHost();
        String domain;
        domain = cookie.getDomain();
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Cookie domain may not be null");
        } //End block
        {
            boolean varDF00A4A746D4F13DFC9772ADDA702974_200216608 = (!domain.equals(host));
            {
                int dotIndex;
                dotIndex = domain.indexOf('.');
                {
                    if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Domain attribute \"" 
                        + domain 
                        + "\" does not match the host \"" 
                        + host + "\"");
                } //End block
                {
                    boolean varDD0C5D77A22559311347468CC8DBDB32_1333709764 = (!domain.startsWith("."));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Domain attribute \"" 
                    + domain 
                    + "\" violates RFC 2109: domain must start with a dot");
                    } //End block
                } //End collapsed parenthetic
                dotIndex = domain.indexOf('.', 1);
                {
                    boolean var799E18FB6D5BD5416B7EBCBE80C32465_779201538 = (dotIndex < 0 || dotIndex == domain.length() - 1);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Domain attribute \"" 
                    + domain 
                    + "\" violates RFC 2109: domain must contain an embedded dot");
                    } //End block
                } //End collapsed parenthetic
                host = host.toLowerCase(Locale.ENGLISH);
                {
                    boolean var4CC5C42A13FF000FBBF07CCD71946771_1495058901 = (!host.endsWith(domain));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException(
                    "Illegal domain attribute \"" + domain 
                    + "\". Domain of origin: \"" + host + "\"");
                    } //End block
                } //End collapsed parenthetic
                String hostWithoutDomain;
                hostWithoutDomain = host.substring(0, host.length() - domain.length());
                {
                    boolean varDE5B1218E068294DF30CA1D70588DEFD_2107314049 = (hostWithoutDomain.indexOf('.') != -1);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Domain attribute \"" 
                    + domain 
                    + "\" violates RFC 2109: host minus domain may not contain any dots");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.391 -0400", hash_original_method = "366C15EED829D9311CF9BF5EB777430B", hash_generated_method = "0B7A305AF064192E08D772C2433ABC67")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } //End block
        String host;
        host = origin.getHost();
        String domain;
        domain = cookie.getDomain();
        boolean varD3BEE7717F5C53B8019886A641FD7C0D_1559261673 = (host.equals(domain) || (domain.startsWith(".") && host.endsWith(domain)));
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1111850009 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1111850009;
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (origin == null) {
            //throw new IllegalArgumentException("Cookie origin may not be null");
        //}
        //String host = origin.getHost();
        //String domain = cookie.getDomain();
        //if (domain == null) {
            //return false;
        //}
        //return host.equals(domain) || (domain.startsWith(".") && host.endsWith(domain));
    }

    
}

