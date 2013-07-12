package org.apache.http.impl.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Locale;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class RFC2109DomainHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.674 -0400", hash_original_method = "BA3C0693A4254304D076B6F4F238BB9F", hash_generated_method = "792C59D9D2B3A1BF306F01640B547EEC")
    public  RFC2109DomainHandler() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.674 -0400", hash_original_method = "A2A30C6200DB9994662FDA726DA35D9E", hash_generated_method = "FAB27AAE49183D1D4AA298CEA1A3903A")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        addTaint(value.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_898470496 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_898470496.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_898470496;
        } 
    if(value == null)        
        {
            MalformedCookieException var0F112B9FC8E3827692FDE0884407A29E_1155738371 = new MalformedCookieException("Missing value for domain attribute");
            var0F112B9FC8E3827692FDE0884407A29E_1155738371.addTaint(taint);
            throw var0F112B9FC8E3827692FDE0884407A29E_1155738371;
        } 
    if(value.trim().length() == 0)        
        {
            MalformedCookieException var07BAB46695E7C8E84A0A4107E34A960E_693297498 = new MalformedCookieException("Blank value for domain attribute");
            var07BAB46695E7C8E84A0A4107E34A960E_693297498.addTaint(taint);
            throw var07BAB46695E7C8E84A0A4107E34A960E_693297498;
        } 
        cookie.setDomain(value);
        
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.675 -0400", hash_original_method = "B2BF5046DB79177D44AB1563AAF5AFFB", hash_generated_method = "FF5D1A5DAC0186DBF87E2EC6F89FB0E9")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1313586556 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1313586556.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1313586556;
        } 
    if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_1868421910 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_1868421910.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_1868421910;
        } 
        String host = origin.getHost();
        String domain = cookie.getDomain();
    if(domain == null)        
        {
            MalformedCookieException varB79BAE8CA7273A58873D2185EA314BFC_1143123475 = new MalformedCookieException("Cookie domain may not be null");
            varB79BAE8CA7273A58873D2185EA314BFC_1143123475.addTaint(taint);
            throw varB79BAE8CA7273A58873D2185EA314BFC_1143123475;
        } 
    if(!domain.equals(host))        
        {
            int dotIndex = domain.indexOf('.');
    if(dotIndex == -1)            
            {
                MalformedCookieException var5487B9380B0162AA1731440DD7D7F72B_849767486 = new MalformedCookieException("Domain attribute \"" 
                        + domain 
                        + "\" does not match the host \"" 
                        + host + "\"");
                var5487B9380B0162AA1731440DD7D7F72B_849767486.addTaint(taint);
                throw var5487B9380B0162AA1731440DD7D7F72B_849767486;
            } 
    if(!domain.startsWith("."))            
            {
                MalformedCookieException varD428D8CA28CF5E845B8B1F2D64794B22_1741013666 = new MalformedCookieException("Domain attribute \"" 
                    + domain 
                    + "\" violates RFC 2109: domain must start with a dot");
                varD428D8CA28CF5E845B8B1F2D64794B22_1741013666.addTaint(taint);
                throw varD428D8CA28CF5E845B8B1F2D64794B22_1741013666;
            } 
            dotIndex = domain.indexOf('.', 1);
    if(dotIndex < 0 || dotIndex == domain.length() - 1)            
            {
                MalformedCookieException var9E36F9F251E2C732FCF402CB91D56DF0_1276667888 = new MalformedCookieException("Domain attribute \"" 
                    + domain 
                    + "\" violates RFC 2109: domain must contain an embedded dot");
                var9E36F9F251E2C732FCF402CB91D56DF0_1276667888.addTaint(taint);
                throw var9E36F9F251E2C732FCF402CB91D56DF0_1276667888;
            } 
            host = host.toLowerCase(Locale.ENGLISH);
    if(!host.endsWith(domain))            
            {
                MalformedCookieException var1FAEB6A838498A08609AB07AF40CFFB3_216325164 = new MalformedCookieException(
                    "Illegal domain attribute \"" + domain 
                    + "\". Domain of origin: \"" + host + "\"");
                var1FAEB6A838498A08609AB07AF40CFFB3_216325164.addTaint(taint);
                throw var1FAEB6A838498A08609AB07AF40CFFB3_216325164;
            } 
            String hostWithoutDomain = host.substring(0, host.length() - domain.length());
    if(hostWithoutDomain.indexOf('.') != -1)            
            {
                MalformedCookieException var36C877C5664221807621883D47CF8378_1424547470 = new MalformedCookieException("Domain attribute \"" 
                    + domain 
                    + "\" violates RFC 2109: host minus domain may not contain any dots");
                var36C877C5664221807621883D47CF8378_1424547470.addTaint(taint);
                throw var36C877C5664221807621883D47CF8378_1424547470;
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.676 -0400", hash_original_method = "366C15EED829D9311CF9BF5EB777430B", hash_generated_method = "5D90B0A2233DBC33CF0BA9CCB408EE98")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1008002227 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1008002227.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1008002227;
        } 
    if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_1698418837 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_1698418837.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_1698418837;
        } 
        String host = origin.getHost();
        String domain = cookie.getDomain();
    if(domain == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_81307792 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_721715947 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_721715947;
        } 
        boolean var6FCDBCB2A83BA8F68B4434B5341CE458_1296282902 = (host.equals(domain) || (domain.startsWith(".") && host.endsWith(domain)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1183108892 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1183108892;
        
        
            
        
        
            
        
        
        
        
            
        
        
    }

    
}

