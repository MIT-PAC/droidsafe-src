package org.apache.http.impl.cookie;

// Droidsafe Imports
import java.util.Locale;

import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

import droidsafe.annotations.DSGenerator;

public class RFC2965DomainAttributeHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.174 -0400", hash_original_method = "5C926F9EE1EA6288872238281D019BE6", hash_generated_method = "BE8662EA5C80130298C7E15C8F61CFD7")
    public  RFC2965DomainAttributeHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.175 -0400", hash_original_method = "CA7EEF802D39DD35821E8C5DF292BB9E", hash_generated_method = "4A5417982C6B6B7D5DDBEBD20BED8A34")
    public void parse(final SetCookie cookie, String domain) throws MalformedCookieException {
        addTaint(domain.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_625447556 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_625447556.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_625447556;
        } //End block
        if(domain == null)        
        {
            MalformedCookieException var0F112B9FC8E3827692FDE0884407A29E_1798673473 = new MalformedCookieException(
                    "Missing value for domain attribute");
            var0F112B9FC8E3827692FDE0884407A29E_1798673473.addTaint(taint);
            throw var0F112B9FC8E3827692FDE0884407A29E_1798673473;
        } //End block
        if(domain.trim().length() == 0)        
        {
            MalformedCookieException var07BAB46695E7C8E84A0A4107E34A960E_1574688689 = new MalformedCookieException(
                    "Blank value for domain attribute");
            var07BAB46695E7C8E84A0A4107E34A960E_1574688689.addTaint(taint);
            throw var07BAB46695E7C8E84A0A4107E34A960E_1574688689;
        } //End block
        domain = domain.toLowerCase(Locale.ENGLISH);
        if(!domain.startsWith("."))        
        {
            domain = '.' + domain;
        } //End block
        cookie.setDomain(domain);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.176 -0400", hash_original_method = "63286152494B19CF26590FA425B39B18", hash_generated_method = "9AA48875946B4335B858092FD57F7EE3")
    public boolean domainMatch(String host, String domain) {
        addTaint(domain.getTaint());
        addTaint(host.getTaint());
        boolean match = host.equals(domain)
                        || (domain.startsWith(".") && host.endsWith(domain));
        boolean varE3CC92C14A5E6DD1A7D94B6FF634D7FC_1856940659 = (match);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1962972394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1962972394;
        // ---------- Original Method ----------
        //boolean match = host.equals(domain)
                        //|| (domain.startsWith(".") && host.endsWith(domain));
        //return match;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.177 -0400", hash_original_method = "CABE0CDEFEE66B5261D13BB72FC54CFF", hash_generated_method = "400A1F52C6F0E7C2D532744D28F4FABF")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_670463209 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_670463209.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_670463209;
        } //End block
        if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_1793528905 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_1793528905.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_1793528905;
        } //End block
        String host = origin.getHost().toLowerCase(Locale.ENGLISH);
        if(cookie.getDomain() == null)        
        {
            MalformedCookieException varE7A1CE881B90FFD10CF86403BFBEA1D1_1184915618 = new MalformedCookieException("Invalid cookie state: " +
                                               "domain not specified");
            varE7A1CE881B90FFD10CF86403BFBEA1D1_1184915618.addTaint(taint);
            throw varE7A1CE881B90FFD10CF86403BFBEA1D1_1184915618;
        } //End block
        String cookieDomain = cookie.getDomain().toLowerCase(Locale.ENGLISH);
        if(cookie instanceof ClientCookie 
                && ((ClientCookie) cookie).containsAttribute(ClientCookie.DOMAIN_ATTR))        
        {
            if(!cookieDomain.startsWith("."))            
            {
                MalformedCookieException var158124422C5B21946CBA28C46427092A_381340864 = new MalformedCookieException("Domain attribute \"" +
                    cookie.getDomain() + "\" violates RFC 2109: domain must start with a dot");
                var158124422C5B21946CBA28C46427092A_381340864.addTaint(taint);
                throw var158124422C5B21946CBA28C46427092A_381340864;
            } //End block
            int dotIndex = cookieDomain.indexOf('.', 1);
            if(((dotIndex < 0) || (dotIndex == cookieDomain.length() - 1))
                && (!cookieDomain.equals(".local")))            
            {
                MalformedCookieException var2F0E525CDE9A036E2CE5A450F3D2E59A_895365053 = new MalformedCookieException(
                        "Domain attribute \"" + cookie.getDomain()
                        + "\" violates RFC 2965: the value contains no embedded dots "
                        + "and the value is not .local");
                var2F0E525CDE9A036E2CE5A450F3D2E59A_895365053.addTaint(taint);
                throw var2F0E525CDE9A036E2CE5A450F3D2E59A_895365053;
            } //End block
            if(!domainMatch(host, cookieDomain))            
            {
                MalformedCookieException var936265A4A6E9BD5921537B50F5A27FB3_449302500 = new MalformedCookieException(
                        "Domain attribute \"" + cookie.getDomain()
                        + "\" violates RFC 2965: effective host name does not "
                        + "domain-match domain attribute.");
                var936265A4A6E9BD5921537B50F5A27FB3_449302500.addTaint(taint);
                throw var936265A4A6E9BD5921537B50F5A27FB3_449302500;
            } //End block
            String effectiveHostWithoutDomain = host.substring(
                    0, host.length() - cookieDomain.length());
            if(effectiveHostWithoutDomain.indexOf('.') != -1)            
            {
                MalformedCookieException var7D3A4E534B922D4C19B2A641DFCF74CD_1328792067 = new MalformedCookieException("Domain attribute \""
                                                   + cookie.getDomain() + "\" violates RFC 2965: "
                                                   + "effective host minus domain may not contain any dots");
                var7D3A4E534B922D4C19B2A641DFCF74CD_1328792067.addTaint(taint);
                throw var7D3A4E534B922D4C19B2A641DFCF74CD_1328792067;
            } //End block
        } //End block
        else
        {
            if(!cookie.getDomain().equals(host))            
            {
                MalformedCookieException var3CCBF05B26D87EAF3DBA7BB5F48C1078_253857548 = new MalformedCookieException("Illegal domain attribute: \""
                                                   + cookie.getDomain() + "\"."
                                                   + "Domain of origin: \""
                                                   + host + "\"");
                var3CCBF05B26D87EAF3DBA7BB5F48C1078_253857548.addTaint(taint);
                throw var3CCBF05B26D87EAF3DBA7BB5F48C1078_253857548;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.178 -0400", hash_original_method = "C7211512AD90131E871DA498CB7C5AD4", hash_generated_method = "D073FDDFD7FBF12C555FC951ED779510")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1819792702 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1819792702.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1819792702;
        } //End block
        if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_1965718708 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_1965718708.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_1965718708;
        } //End block
        String host = origin.getHost().toLowerCase(Locale.ENGLISH);
        String cookieDomain = cookie.getDomain();
        if(!domainMatch(host, cookieDomain))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1448799962 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_345073018 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_345073018;
        } //End block
        String effectiveHostWithoutDomain = host.substring(
                0, host.length() - cookieDomain.length());
        boolean var5FF3295C6ADEE0E2D54C2A459817174D_1745292865 = (effectiveHostWithoutDomain.indexOf('.') == -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1652992215 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1652992215;
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

