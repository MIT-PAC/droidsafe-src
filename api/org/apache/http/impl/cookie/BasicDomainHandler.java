package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class BasicDomainHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.271 -0400", hash_original_method = "3582ADBB5BDD47EB6552162B7BD8CF14", hash_generated_method = "E0AB420DDF8D95126D472000ABC6448F")
    public  BasicDomainHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.271 -0400", hash_original_method = "A2A30C6200DB9994662FDA726DA35D9E", hash_generated_method = "BF0BF2DBD2D98046D8D10080D0C2C779")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        addTaint(value.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_2003117578 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_2003117578.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_2003117578;
        } //End block
    if(value == null)        
        {
            MalformedCookieException var0F112B9FC8E3827692FDE0884407A29E_1350321560 = new MalformedCookieException("Missing value for domain attribute");
            var0F112B9FC8E3827692FDE0884407A29E_1350321560.addTaint(taint);
            throw var0F112B9FC8E3827692FDE0884407A29E_1350321560;
        } //End block
    if(value.trim().length() == 0)        
        {
            MalformedCookieException var07BAB46695E7C8E84A0A4107E34A960E_1433636415 = new MalformedCookieException("Blank value for domain attribute");
            var07BAB46695E7C8E84A0A4107E34A960E_1433636415.addTaint(taint);
            throw var07BAB46695E7C8E84A0A4107E34A960E_1433636415;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.272 -0400", hash_original_method = "94AF8B07DB84B5B63244518D1FBDF7D4", hash_generated_method = "D8AB08DDE84B5D074C84D24C5F7AFB40")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_742469000 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_742469000.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_742469000;
        } //End block
    if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_91174002 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_91174002.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_91174002;
        } //End block
        String host = origin.getHost();
        String domain = cookie.getDomain();
    if(domain == null)        
        {
            MalformedCookieException varB79BAE8CA7273A58873D2185EA314BFC_1294704975 = new MalformedCookieException("Cookie domain may not be null");
            varB79BAE8CA7273A58873D2185EA314BFC_1294704975.addTaint(taint);
            throw varB79BAE8CA7273A58873D2185EA314BFC_1294704975;
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
                    MalformedCookieException var1FAEB6A838498A08609AB07AF40CFFB3_423559014 = new MalformedCookieException(
                        "Illegal domain attribute \"" + domain 
                        + "\". Domain of origin: \"" + host + "\"");
                    var1FAEB6A838498A08609AB07AF40CFFB3_423559014.addTaint(taint);
                    throw var1FAEB6A838498A08609AB07AF40CFFB3_423559014;
                } //End block
            } //End block
        } //End block
        else
        {
    if(!host.equals(domain))            
            {
                MalformedCookieException var1FAEB6A838498A08609AB07AF40CFFB3_2020329529 = new MalformedCookieException(
                    "Illegal domain attribute \"" + domain 
                    + "\". Domain of origin: \"" + host + "\"");
                var1FAEB6A838498A08609AB07AF40CFFB3_2020329529.addTaint(taint);
                throw var1FAEB6A838498A08609AB07AF40CFFB3_2020329529;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.273 -0400", hash_original_method = "35486252C095151EC7F82B814432B360", hash_generated_method = "A38C7175361522C09DD76A4708C1E863")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1777791793 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1777791793.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1777791793;
        } //End block
    if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_1787159523 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_1787159523.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_1787159523;
        } //End block
        String host = origin.getHost();
        String domain = cookie.getDomain();
    if(domain == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1781450706 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1573120848 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1573120848;
        } //End block
    if(host.equals(domain))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_859349803 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_143083074 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_143083074;
        } //End block
    if(!domain.startsWith("."))        
        {
            domain = '.' + domain;
        } //End block
        boolean varCF0A6EE333173A82BC6AB0183D01E0C9_355259498 = (host.endsWith(domain) || host.equals(domain.substring(1)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_939223532 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_939223532;
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

