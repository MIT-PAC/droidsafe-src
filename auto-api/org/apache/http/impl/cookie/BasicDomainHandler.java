package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class BasicDomainHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.162 -0400", hash_original_method = "3582ADBB5BDD47EB6552162B7BD8CF14", hash_generated_method = "E0AB420DDF8D95126D472000ABC6448F")
    public  BasicDomainHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.163 -0400", hash_original_method = "A2A30C6200DB9994662FDA726DA35D9E", hash_generated_method = "F03D2B58205525D68C0C3E9271F44448")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Missing value for domain attribute");
        } //End block
        {
            boolean var9FBE5B3A34BFAF0B0EC7E39F0CD9C0B6_1542617196 = (value.trim().length() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.163 -0400", hash_original_method = "94AF8B07DB84B5B63244518D1FBDF7D4", hash_generated_method = "C71E08D45C4270163B4A5CA960F1F352")
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
            boolean var171183DA5AA2382CF21A6A1891EE0576_724354195 = (host.contains("."));
            {
                {
                    boolean var4CC5C42A13FF000FBBF07CCD71946771_116303230 = (!host.endsWith(domain));
                    {
                        {
                            boolean var80DD089BFC1D9C93D4EB3245C4C27985_1597119119 = (domain.startsWith("."));
                            {
                                domain = domain.substring(1, domain.length());
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean var9E684283EE757368104D81D9AC5B910E_592098582 = (!host.equals(domain));
                            {
                                if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException(
                        "Illegal domain attribute \"" + domain 
                        + "\". Domain of origin: \"" + host + "\"");
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var8CFA4509AEB36FF7ADB8D9954872A6F6_1787530227 = (!host.equals(domain));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException(
                    "Illegal domain attribute \"" + domain 
                    + "\". Domain of origin: \"" + host + "\"");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.168 -0400", hash_original_method = "35486252C095151EC7F82B814432B360", hash_generated_method = "87E9B340E9592AD800E254CD8E79A322")
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
        {
            boolean var1BAAB2486D5D69C6AC61591700322645_1674565262 = (host.equals(domain));
        } //End collapsed parenthetic
        {
            boolean var873644D3707459650A4D7B88F1ECF236_2002197701 = (!domain.startsWith("."));
            {
                domain = '.' + domain;
            } //End block
        } //End collapsed parenthetic
        boolean varC66CB6B4B06A0AB637F599C5BE2D9FB4_135372418 = (host.endsWith(domain) || host.equals(domain.substring(1)));
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2055551096 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2055551096;
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

