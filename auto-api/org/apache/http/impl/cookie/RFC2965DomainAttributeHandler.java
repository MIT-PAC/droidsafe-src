package org.apache.http.impl.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Locale;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class RFC2965DomainAttributeHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.455 -0400", hash_original_method = "5C926F9EE1EA6288872238281D019BE6", hash_generated_method = "BE8662EA5C80130298C7E15C8F61CFD7")
    public  RFC2965DomainAttributeHandler() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.455 -0400", hash_original_method = "CA7EEF802D39DD35821E8C5DF292BB9E", hash_generated_method = "C618BE5988AFEBD70E52A87FAA3A0CB9")
    public void parse(final SetCookie cookie, String domain) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException(
                    "Missing value for domain attribute");
        } 
        {
            boolean var716F38ECEF62E7BAB2B73D2E4CD7B698_315544628 = (domain.trim().length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException(
                    "Blank value for domain attribute");
            } 
        } 
        domain = domain.toLowerCase(Locale.ENGLISH);
        {
            boolean var873644D3707459650A4D7B88F1ECF236_1135607740 = (!domain.startsWith("."));
            {
                domain = '.' + domain;
            } 
        } 
        cookie.setDomain(domain);
        addTaint(cookie.getTaint());
        addTaint(domain.getTaint());
        
        
            
        
        
            
                    
        
        
            
                    
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.456 -0400", hash_original_method = "63286152494B19CF26590FA425B39B18", hash_generated_method = "6A6B3CCE1BCD1BC4F2856B64145D437C")
    public boolean domainMatch(String host, String domain) {
        boolean match = host.equals(domain)
                        || (domain.startsWith(".") && host.endsWith(domain));
        addTaint(host.getTaint());
        addTaint(domain.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_524194135 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_524194135;
        
        
                        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.457 -0400", hash_original_method = "CABE0CDEFEE66B5261D13BB72FC54CFF", hash_generated_method = "2E1CDA8CA1D97BEC4E2880C30686D06F")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } 
        String host = origin.getHost().toLowerCase(Locale.ENGLISH);
        {
            boolean varBAD20B9E7D3CE9F148081CA1109233D7_1199675774 = (cookie.getDomain() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Invalid cookie state: " +
                                               "domain not specified");
            } 
        } 
        String cookieDomain = cookie.getDomain().toLowerCase(Locale.ENGLISH);
        {
            boolean var867CD9B3DE8B418B60EB55E6CA4D8877_2113756453 = (cookie instanceof ClientCookie 
                && ((ClientCookie) cookie).containsAttribute(ClientCookie.DOMAIN_ATTR));
            {
                {
                    boolean var3B3E11465F66252D93E11D2F0FD9ED1D_556251636 = (!cookieDomain.startsWith("."));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Domain attribute \"" +
                    cookie.getDomain() + "\" violates RFC 2109: domain must start with a dot");
                    } 
                } 
                int dotIndex = cookieDomain.indexOf('.', 1);
                {
                    boolean varC4583855A969CE6A503E5B2E20470671_443585585 = (((dotIndex < 0) || (dotIndex == cookieDomain.length() - 1))
                && (!cookieDomain.equals(".local")));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException(
                        "Domain attribute \"" + cookie.getDomain()
                        + "\" violates RFC 2965: the value contains no embedded dots "
                        + "and the value is not .local");
                    } 
                } 
                {
                    boolean varDEEF451CFF30BC1AA701C0C7B90AF768_1787681096 = (!domainMatch(host, cookieDomain));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException(
                        "Domain attribute \"" + cookie.getDomain()
                        + "\" violates RFC 2965: effective host name does not "
                        + "domain-match domain attribute.");
                    } 
                } 
                String effectiveHostWithoutDomain = host.substring(
                    0, host.length() - cookieDomain.length());
                {
                    boolean var858D695EC475530943D31B961A06AAE5_512042096 = (effectiveHostWithoutDomain.indexOf('.') != -1);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Domain attribute \""
                                                   + cookie.getDomain() + "\" violates RFC 2965: "
                                                   + "effective host minus domain may not contain any dots");
                    } 
                } 
            } 
            {
                {
                    boolean var0B16B85F133858CFD6C67845CF201F1E_92910527 = (!cookie.getDomain().equals(host));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Illegal domain attribute: \""
                                                   + cookie.getDomain() + "\"."
                                                   + "Domain of origin: \""
                                                   + host + "\"");
                    } 
                } 
            } 
        } 
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.458 -0400", hash_original_method = "C7211512AD90131E871DA498CB7C5AD4", hash_generated_method = "55CDD04FBD6EC68ECBBCD779E3EB0ABE")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } 
        String host = origin.getHost().toLowerCase(Locale.ENGLISH);
        String cookieDomain = cookie.getDomain();
        {
            boolean var9E0D9986C5F07FFE35D6847CC9300062_781986660 = (!domainMatch(host, cookieDomain));
        } 
        String effectiveHostWithoutDomain = host.substring(
                0, host.length() - cookieDomain.length());
        boolean var47BEB1110B9D8D10A10721C1BA91AE2A_1911422710 = (effectiveHostWithoutDomain.indexOf('.') == -1);
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_74723590 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_74723590;
        
        
            
        
        
            
        
        
        
        
            
        
        
                
        
    }

    
}

