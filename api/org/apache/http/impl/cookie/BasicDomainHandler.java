package org.apache.http.impl.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class BasicDomainHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.922 -0400", hash_original_method = "3582ADBB5BDD47EB6552162B7BD8CF14", hash_generated_method = "E0AB420DDF8D95126D472000ABC6448F")
    public  BasicDomainHandler() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.924 -0400", hash_original_method = "A2A30C6200DB9994662FDA726DA35D9E", hash_generated_method = "9E84FC47AEF17FA5A17FEC0B285B9C37")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Missing value for domain attribute");
        } 
        {
            boolean var9FBE5B3A34BFAF0B0EC7E39F0CD9C0B6_1486742526 = (value.trim().length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Blank value for domain attribute");
            } 
        } 
        cookie.setDomain(value);
        addTaint(cookie.getTaint());
        addTaint(value.getTaint());
        
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.926 -0400", hash_original_method = "94AF8B07DB84B5B63244518D1FBDF7D4", hash_generated_method = "46B88E92B87EA0E0C70557194EF4ACA1")
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
            boolean var171183DA5AA2382CF21A6A1891EE0576_1000558965 = (host.contains("."));
            {
                {
                    boolean var4CC5C42A13FF000FBBF07CCD71946771_231310442 = (!host.endsWith(domain));
                    {
                        {
                            boolean var80DD089BFC1D9C93D4EB3245C4C27985_1368776472 = (domain.startsWith("."));
                            {
                                domain = domain.substring(1, domain.length());
                            } 
                        } 
                        {
                            boolean var9E684283EE757368104D81D9AC5B910E_1542443314 = (!host.equals(domain));
                            {
                                if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException(
                        "Illegal domain attribute \"" + domain 
                        + "\". Domain of origin: \"" + host + "\"");
                            } 
                        } 
                    } 
                } 
            } 
            {
                {
                    boolean var8CFA4509AEB36FF7ADB8D9954872A6F6_179792026 = (!host.equals(domain));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException(
                    "Illegal domain attribute \"" + domain 
                    + "\". Domain of origin: \"" + host + "\"");
                    } 
                } 
            } 
        } 
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.927 -0400", hash_original_method = "35486252C095151EC7F82B814432B360", hash_generated_method = "40C85F437D090DCEA36CE69789A9D9DB")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } 
        String host = origin.getHost();
        String domain = cookie.getDomain();
        {
            boolean var1BAAB2486D5D69C6AC61591700322645_124037961 = (host.equals(domain));
        } 
        {
            boolean var873644D3707459650A4D7B88F1ECF236_119501326 = (!domain.startsWith("."));
            {
                domain = '.' + domain;
            } 
        } 
        boolean varC66CB6B4B06A0AB637F599C5BE2D9FB4_987209754 = (host.endsWith(domain) || host.equals(domain.substring(1)));
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1472250740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1472250740;
        
        
            
        
        
            
        
        
        
        
            
        
        
            
        
        
            
        
        
    }

    
}

