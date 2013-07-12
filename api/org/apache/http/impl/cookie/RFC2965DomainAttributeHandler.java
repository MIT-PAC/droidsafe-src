package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Locale;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class RFC2965DomainAttributeHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.844 -0400", hash_original_method = "5C926F9EE1EA6288872238281D019BE6", hash_generated_method = "BE8662EA5C80130298C7E15C8F61CFD7")
    public  RFC2965DomainAttributeHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.845 -0400", hash_original_method = "CA7EEF802D39DD35821E8C5DF292BB9E", hash_generated_method = "D7AFC5717DEDFFE56AE593A1B137A66D")
    public void parse(final SetCookie cookie, String domain) throws MalformedCookieException {
        addTaint(domain.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1065424555 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1065424555.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1065424555;
        } //End block
    if(domain == null)        
        {
            MalformedCookieException var0F112B9FC8E3827692FDE0884407A29E_208987229 = new MalformedCookieException(
                    "Missing value for domain attribute");
            var0F112B9FC8E3827692FDE0884407A29E_208987229.addTaint(taint);
            throw var0F112B9FC8E3827692FDE0884407A29E_208987229;
        } //End block
    if(domain.trim().length() == 0)        
        {
            MalformedCookieException var07BAB46695E7C8E84A0A4107E34A960E_1570136976 = new MalformedCookieException(
                    "Blank value for domain attribute");
            var07BAB46695E7C8E84A0A4107E34A960E_1570136976.addTaint(taint);
            throw var07BAB46695E7C8E84A0A4107E34A960E_1570136976;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.846 -0400", hash_original_method = "63286152494B19CF26590FA425B39B18", hash_generated_method = "3FAA16E1B4221E29590D1D8D92A1E0C5")
    public boolean domainMatch(String host, String domain) {
        addTaint(domain.getTaint());
        addTaint(host.getTaint());
        boolean match = host.equals(domain)
                        || (domain.startsWith(".") && host.endsWith(domain));
        boolean varE3CC92C14A5E6DD1A7D94B6FF634D7FC_224049377 = (match);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1654887693 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1654887693;
        // ---------- Original Method ----------
        //boolean match = host.equals(domain)
                        //|| (domain.startsWith(".") && host.endsWith(domain));
        //return match;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.849 -0400", hash_original_method = "CABE0CDEFEE66B5261D13BB72FC54CFF", hash_generated_method = "3A6B24D05A7772EEC2B70FE64F25D1BA")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1793560798 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1793560798.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1793560798;
        } //End block
    if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_121178926 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_121178926.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_121178926;
        } //End block
        String host = origin.getHost().toLowerCase(Locale.ENGLISH);
    if(cookie.getDomain() == null)        
        {
            MalformedCookieException varE7A1CE881B90FFD10CF86403BFBEA1D1_2034599982 = new MalformedCookieException("Invalid cookie state: " +
                                               "domain not specified");
            varE7A1CE881B90FFD10CF86403BFBEA1D1_2034599982.addTaint(taint);
            throw varE7A1CE881B90FFD10CF86403BFBEA1D1_2034599982;
        } //End block
        String cookieDomain = cookie.getDomain().toLowerCase(Locale.ENGLISH);
    if(cookie instanceof ClientCookie 
                && ((ClientCookie) cookie).containsAttribute(ClientCookie.DOMAIN_ATTR))        
        {
    if(!cookieDomain.startsWith("."))            
            {
                MalformedCookieException var158124422C5B21946CBA28C46427092A_68306373 = new MalformedCookieException("Domain attribute \"" +
                    cookie.getDomain() + "\" violates RFC 2109: domain must start with a dot");
                var158124422C5B21946CBA28C46427092A_68306373.addTaint(taint);
                throw var158124422C5B21946CBA28C46427092A_68306373;
            } //End block
            int dotIndex = cookieDomain.indexOf('.', 1);
    if(((dotIndex < 0) || (dotIndex == cookieDomain.length() - 1))
                && (!cookieDomain.equals(".local")))            
            {
                MalformedCookieException var2F0E525CDE9A036E2CE5A450F3D2E59A_1472362953 = new MalformedCookieException(
                        "Domain attribute \"" + cookie.getDomain()
                        + "\" violates RFC 2965: the value contains no embedded dots "
                        + "and the value is not .local");
                var2F0E525CDE9A036E2CE5A450F3D2E59A_1472362953.addTaint(taint);
                throw var2F0E525CDE9A036E2CE5A450F3D2E59A_1472362953;
            } //End block
    if(!domainMatch(host, cookieDomain))            
            {
                MalformedCookieException var936265A4A6E9BD5921537B50F5A27FB3_841617048 = new MalformedCookieException(
                        "Domain attribute \"" + cookie.getDomain()
                        + "\" violates RFC 2965: effective host name does not "
                        + "domain-match domain attribute.");
                var936265A4A6E9BD5921537B50F5A27FB3_841617048.addTaint(taint);
                throw var936265A4A6E9BD5921537B50F5A27FB3_841617048;
            } //End block
            String effectiveHostWithoutDomain = host.substring(
                    0, host.length() - cookieDomain.length());
    if(effectiveHostWithoutDomain.indexOf('.') != -1)            
            {
                MalformedCookieException var7D3A4E534B922D4C19B2A641DFCF74CD_1322280138 = new MalformedCookieException("Domain attribute \""
                                                   + cookie.getDomain() + "\" violates RFC 2965: "
                                                   + "effective host minus domain may not contain any dots");
                var7D3A4E534B922D4C19B2A641DFCF74CD_1322280138.addTaint(taint);
                throw var7D3A4E534B922D4C19B2A641DFCF74CD_1322280138;
            } //End block
        } //End block
        else
        {
    if(!cookie.getDomain().equals(host))            
            {
                MalformedCookieException var3CCBF05B26D87EAF3DBA7BB5F48C1078_877287031 = new MalformedCookieException("Illegal domain attribute: \""
                                                   + cookie.getDomain() + "\"."
                                                   + "Domain of origin: \""
                                                   + host + "\"");
                var3CCBF05B26D87EAF3DBA7BB5F48C1078_877287031.addTaint(taint);
                throw var3CCBF05B26D87EAF3DBA7BB5F48C1078_877287031;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.850 -0400", hash_original_method = "C7211512AD90131E871DA498CB7C5AD4", hash_generated_method = "699378461AA5F749EEC72F64419A13AB")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1128470314 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1128470314.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1128470314;
        } //End block
    if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_342113378 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_342113378.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_342113378;
        } //End block
        String host = origin.getHost().toLowerCase(Locale.ENGLISH);
        String cookieDomain = cookie.getDomain();
    if(!domainMatch(host, cookieDomain))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1325598609 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1087530849 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1087530849;
        } //End block
        String effectiveHostWithoutDomain = host.substring(
                0, host.length() - cookieDomain.length());
        boolean var5FF3295C6ADEE0E2D54C2A459817174D_729696412 = (effectiveHostWithoutDomain.indexOf('.') == -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1184885250 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1184885250;
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

