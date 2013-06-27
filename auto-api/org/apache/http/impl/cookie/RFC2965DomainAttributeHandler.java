package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Locale;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class RFC2965DomainAttributeHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.510 -0400", hash_original_method = "5C926F9EE1EA6288872238281D019BE6", hash_generated_method = "BE8662EA5C80130298C7E15C8F61CFD7")
    public  RFC2965DomainAttributeHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.513 -0400", hash_original_method = "CA7EEF802D39DD35821E8C5DF292BB9E", hash_generated_method = "6E94AD2E58E29D7EBDFDDCF6606D498E")
    public void parse(final SetCookie cookie, String domain) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException(
                    "Missing value for domain attribute");
        } //End block
        {
            boolean var716F38ECEF62E7BAB2B73D2E4CD7B698_580305889 = (domain.trim().length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException(
                    "Blank value for domain attribute");
            } //End block
        } //End collapsed parenthetic
        domain = domain.toLowerCase(Locale.ENGLISH);
        {
            boolean var873644D3707459650A4D7B88F1ECF236_1242289077 = (!domain.startsWith("."));
            {
                domain = '.' + domain;
            } //End block
        } //End collapsed parenthetic
        cookie.setDomain(domain);
        addTaint(cookie.getTaint());
        addTaint(domain.getTaint());
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (domain == null) {
            //throw new MalformedCookieException(
                    //"Missing value for domain attribute");
        //}
        //if (domain.trim().length() == 0) {
            //throw new MalformedCookieException(
                    //"Blank value for domain attribute");
        //}
        //domain = domain.toLowerCase(Locale.ENGLISH);
        //if (!domain.startsWith(".")) {
            //domain = '.' + domain;
        //}
        //cookie.setDomain(domain);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.514 -0400", hash_original_method = "63286152494B19CF26590FA425B39B18", hash_generated_method = "BD95BB946E2EDB4B6761AB358039C191")
    public boolean domainMatch(String host, String domain) {
        boolean match;
        match = host.equals(domain)
                        || (domain.startsWith(".") && host.endsWith(domain));
        addTaint(host.getTaint());
        addTaint(domain.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1268581330 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1268581330;
        // ---------- Original Method ----------
        //boolean match = host.equals(domain)
                        //|| (domain.startsWith(".") && host.endsWith(domain));
        //return match;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.525 -0400", hash_original_method = "CABE0CDEFEE66B5261D13BB72FC54CFF", hash_generated_method = "F7033302343EF39974C1E25C09BF5C83")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } //End block
        String host;
        host = origin.getHost().toLowerCase(Locale.ENGLISH);
        {
            boolean varBAD20B9E7D3CE9F148081CA1109233D7_1608792448 = (cookie.getDomain() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Invalid cookie state: " +
                                               "domain not specified");
            } //End block
        } //End collapsed parenthetic
        String cookieDomain;
        cookieDomain = cookie.getDomain().toLowerCase(Locale.ENGLISH);
        {
            boolean var867CD9B3DE8B418B60EB55E6CA4D8877_1346779258 = (cookie instanceof ClientCookie 
                && ((ClientCookie) cookie).containsAttribute(ClientCookie.DOMAIN_ATTR));
            {
                {
                    boolean var3B3E11465F66252D93E11D2F0FD9ED1D_1535739494 = (!cookieDomain.startsWith("."));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Domain attribute \"" +
                    cookie.getDomain() + "\" violates RFC 2109: domain must start with a dot");
                    } //End block
                } //End collapsed parenthetic
                int dotIndex;
                dotIndex = cookieDomain.indexOf('.', 1);
                {
                    boolean varC4583855A969CE6A503E5B2E20470671_1324035511 = (((dotIndex < 0) || (dotIndex == cookieDomain.length() - 1))
                && (!cookieDomain.equals(".local")));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException(
                        "Domain attribute \"" + cookie.getDomain()
                        + "\" violates RFC 2965: the value contains no embedded dots "
                        + "and the value is not .local");
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varDEEF451CFF30BC1AA701C0C7B90AF768_1467370492 = (!domainMatch(host, cookieDomain));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException(
                        "Domain attribute \"" + cookie.getDomain()
                        + "\" violates RFC 2965: effective host name does not "
                        + "domain-match domain attribute.");
                    } //End block
                } //End collapsed parenthetic
                String effectiveHostWithoutDomain;
                effectiveHostWithoutDomain = host.substring(
                    0, host.length() - cookieDomain.length());
                {
                    boolean var858D695EC475530943D31B961A06AAE5_1371803350 = (effectiveHostWithoutDomain.indexOf('.') != -1);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Domain attribute \""
                                                   + cookie.getDomain() + "\" violates RFC 2965: "
                                                   + "effective host minus domain may not contain any dots");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var0B16B85F133858CFD6C67845CF201F1E_625600402 = (!cookie.getDomain().equals(host));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Illegal domain attribute: \""
                                                   + cookie.getDomain() + "\"."
                                                   + "Domain of origin: \""
                                                   + host + "\"");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.530 -0400", hash_original_method = "C7211512AD90131E871DA498CB7C5AD4", hash_generated_method = "145DABCCF06B4DC0B633AFF07E0729AB")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } //End block
        String host;
        host = origin.getHost().toLowerCase(Locale.ENGLISH);
        String cookieDomain;
        cookieDomain = cookie.getDomain();
        {
            boolean var9E0D9986C5F07FFE35D6847CC9300062_734110316 = (!domainMatch(host, cookieDomain));
        } //End collapsed parenthetic
        String effectiveHostWithoutDomain;
        effectiveHostWithoutDomain = host.substring(
                0, host.length() - cookieDomain.length());
        boolean var47BEB1110B9D8D10A10721C1BA91AE2A_1712409802 = (effectiveHostWithoutDomain.indexOf('.') == -1);
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1877210416 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1877210416;
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (origin == null) {
            //throw new IllegalArgumentException("Cookie origin may not be null");
        //}
        //String host = origin.getHost().toLowerCase(Locale.ENGLISH);
        //String cookieDomain = cookie.getDomain();
        //if (!domainMatch(host, cookieDomain)) {
            //return false;
        //}
        //String effectiveHostWithoutDomain = host.substring(
                //0, host.length() - cookieDomain.length());
        //return effectiveHostWithoutDomain.indexOf('.') == -1;
    }

    
}

