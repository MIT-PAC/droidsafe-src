package org.apache.http.impl.cookie;

// Droidsafe Imports
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.011 -0400", hash_original_method = "BA3C0693A4254304D076B6F4F238BB9F", hash_generated_method = "792C59D9D2B3A1BF306F01640B547EEC")
    public  RFC2109DomainHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.011 -0400", hash_original_method = "A2A30C6200DB9994662FDA726DA35D9E", hash_generated_method = "252C7D50D463100C8ED6934A20C575ED")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        addTaint(value.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_826365799 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_826365799.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_826365799;
        } //End block
        if(value == null)        
        {
            MalformedCookieException var0F112B9FC8E3827692FDE0884407A29E_1163271010 = new MalformedCookieException("Missing value for domain attribute");
            var0F112B9FC8E3827692FDE0884407A29E_1163271010.addTaint(taint);
            throw var0F112B9FC8E3827692FDE0884407A29E_1163271010;
        } //End block
        if(value.trim().length() == 0)        
        {
            MalformedCookieException var07BAB46695E7C8E84A0A4107E34A960E_1636552630 = new MalformedCookieException("Blank value for domain attribute");
            var07BAB46695E7C8E84A0A4107E34A960E_1636552630.addTaint(taint);
            throw var07BAB46695E7C8E84A0A4107E34A960E_1636552630;
        } //End block
        cookie.setDomain(value);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.012 -0400", hash_original_method = "B2BF5046DB79177D44AB1563AAF5AFFB", hash_generated_method = "676ADD73CCF709D96B8517C5CCD6B407")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1212610682 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1212610682.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1212610682;
        } //End block
        if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_1937362114 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_1937362114.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_1937362114;
        } //End block
        String host = origin.getHost();
        String domain = cookie.getDomain();
        if(domain == null)        
        {
            MalformedCookieException varB79BAE8CA7273A58873D2185EA314BFC_851929765 = new MalformedCookieException("Cookie domain may not be null");
            varB79BAE8CA7273A58873D2185EA314BFC_851929765.addTaint(taint);
            throw varB79BAE8CA7273A58873D2185EA314BFC_851929765;
        } //End block
        if(!domain.equals(host))        
        {
            int dotIndex = domain.indexOf('.');
            if(dotIndex == -1)            
            {
                MalformedCookieException var5487B9380B0162AA1731440DD7D7F72B_1953385264 = new MalformedCookieException("Domain attribute \"" 
                        + domain 
                        + "\" does not match the host \"" 
                        + host + "\"");
                var5487B9380B0162AA1731440DD7D7F72B_1953385264.addTaint(taint);
                throw var5487B9380B0162AA1731440DD7D7F72B_1953385264;
            } //End block
            if(!domain.startsWith("."))            
            {
                MalformedCookieException varD428D8CA28CF5E845B8B1F2D64794B22_1055510731 = new MalformedCookieException("Domain attribute \"" 
                    + domain 
                    + "\" violates RFC 2109: domain must start with a dot");
                varD428D8CA28CF5E845B8B1F2D64794B22_1055510731.addTaint(taint);
                throw varD428D8CA28CF5E845B8B1F2D64794B22_1055510731;
            } //End block
            dotIndex = domain.indexOf('.', 1);
            if(dotIndex < 0 || dotIndex == domain.length() - 1)            
            {
                MalformedCookieException var9E36F9F251E2C732FCF402CB91D56DF0_1207968207 = new MalformedCookieException("Domain attribute \"" 
                    + domain 
                    + "\" violates RFC 2109: domain must contain an embedded dot");
                var9E36F9F251E2C732FCF402CB91D56DF0_1207968207.addTaint(taint);
                throw var9E36F9F251E2C732FCF402CB91D56DF0_1207968207;
            } //End block
            host = host.toLowerCase(Locale.ENGLISH);
            if(!host.endsWith(domain))            
            {
                MalformedCookieException var1FAEB6A838498A08609AB07AF40CFFB3_1221620654 = new MalformedCookieException(
                    "Illegal domain attribute \"" + domain 
                    + "\". Domain of origin: \"" + host + "\"");
                var1FAEB6A838498A08609AB07AF40CFFB3_1221620654.addTaint(taint);
                throw var1FAEB6A838498A08609AB07AF40CFFB3_1221620654;
            } //End block
            String hostWithoutDomain = host.substring(0, host.length() - domain.length());
            if(hostWithoutDomain.indexOf('.') != -1)            
            {
                MalformedCookieException var36C877C5664221807621883D47CF8378_1864249929 = new MalformedCookieException("Domain attribute \"" 
                    + domain 
                    + "\" violates RFC 2109: host minus domain may not contain any dots");
                var36C877C5664221807621883D47CF8378_1864249929.addTaint(taint);
                throw var36C877C5664221807621883D47CF8378_1864249929;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.013 -0400", hash_original_method = "366C15EED829D9311CF9BF5EB777430B", hash_generated_method = "30806F75BB4AB60E884855AFD8E489D0")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1864114163 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1864114163.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1864114163;
        } //End block
        if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_49512750 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_49512750.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_49512750;
        } //End block
        String host = origin.getHost();
        String domain = cookie.getDomain();
        if(domain == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_350363599 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1784173856 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1784173856;
        } //End block
        boolean var6FCDBCB2A83BA8F68B4434B5341CE458_1414999450 = (host.equals(domain) || (domain.startsWith(".") && host.endsWith(domain)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2035236103 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2035236103;
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

