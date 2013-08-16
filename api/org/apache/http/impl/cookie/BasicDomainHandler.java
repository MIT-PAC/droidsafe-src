package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;



public class BasicDomainHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.600 -0400", hash_original_method = "3582ADBB5BDD47EB6552162B7BD8CF14", hash_generated_method = "E0AB420DDF8D95126D472000ABC6448F")
    public  BasicDomainHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.601 -0400", hash_original_method = "A2A30C6200DB9994662FDA726DA35D9E", hash_generated_method = "13A5E9E7F28458CD1AD439F307927CFC")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        addTaint(value.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_797859122 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_797859122.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_797859122;
        } //End block
        if(value == null)        
        {
            MalformedCookieException var0F112B9FC8E3827692FDE0884407A29E_404327420 = new MalformedCookieException("Missing value for domain attribute");
            var0F112B9FC8E3827692FDE0884407A29E_404327420.addTaint(taint);
            throw var0F112B9FC8E3827692FDE0884407A29E_404327420;
        } //End block
        if(value.trim().length() == 0)        
        {
            MalformedCookieException var07BAB46695E7C8E84A0A4107E34A960E_1431608558 = new MalformedCookieException("Blank value for domain attribute");
            var07BAB46695E7C8E84A0A4107E34A960E_1431608558.addTaint(taint);
            throw var07BAB46695E7C8E84A0A4107E34A960E_1431608558;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.603 -0400", hash_original_method = "94AF8B07DB84B5B63244518D1FBDF7D4", hash_generated_method = "4375D379A0F4513FB97611722630FE92")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_971051479 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_971051479.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_971051479;
        } //End block
        if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_166088837 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_166088837.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_166088837;
        } //End block
        String host = origin.getHost();
        String domain = cookie.getDomain();
        if(domain == null)        
        {
            MalformedCookieException varB79BAE8CA7273A58873D2185EA314BFC_1216458818 = new MalformedCookieException("Cookie domain may not be null");
            varB79BAE8CA7273A58873D2185EA314BFC_1216458818.addTaint(taint);
            throw varB79BAE8CA7273A58873D2185EA314BFC_1216458818;
        } //End block
        if(host.contains("."))        
        {
            if(!host.endsWith(domain))            
            {
                if(domain.startsWith("."))                
                {
                    domain = domain.substring(1, domain.length());
                } //End block
                if(!host.equals(domain))                
                {
                    MalformedCookieException var1FAEB6A838498A08609AB07AF40CFFB3_842739131 = new MalformedCookieException(
                        "Illegal domain attribute \"" + domain 
                        + "\". Domain of origin: \"" + host + "\"");
                    var1FAEB6A838498A08609AB07AF40CFFB3_842739131.addTaint(taint);
                    throw var1FAEB6A838498A08609AB07AF40CFFB3_842739131;
                } //End block
            } //End block
        } //End block
        else
        {
            if(!host.equals(domain))            
            {
                MalformedCookieException var1FAEB6A838498A08609AB07AF40CFFB3_331699193 = new MalformedCookieException(
                    "Illegal domain attribute \"" + domain 
                    + "\". Domain of origin: \"" + host + "\"");
                var1FAEB6A838498A08609AB07AF40CFFB3_331699193.addTaint(taint);
                throw var1FAEB6A838498A08609AB07AF40CFFB3_331699193;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.606 -0400", hash_original_method = "35486252C095151EC7F82B814432B360", hash_generated_method = "4BBA05223E139417D5EFF1713B6C76CF")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1018935378 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1018935378.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1018935378;
        } //End block
        if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_1055153933 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_1055153933.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_1055153933;
        } //End block
        String host = origin.getHost();
        String domain = cookie.getDomain();
        if(domain == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_329624238 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1656298245 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1656298245;
        } //End block
        if(host.equals(domain))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_479963415 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_273899996 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_273899996;
        } //End block
        if(!domain.startsWith("."))        
        {
            domain = '.' + domain;
        } //End block
        boolean varCF0A6EE333173A82BC6AB0183D01E0C9_1706897304 = (host.endsWith(domain) || host.equals(domain.substring(1)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_822495063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_822495063;
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
        //if (host.equals(domain)) {
            //return true;
        //}
        //if (!domain.startsWith(".")) {
            //domain = '.' + domain;
        //}
        //return host.endsWith(domain) || host.equals(domain.substring(1));
    }

    
}

