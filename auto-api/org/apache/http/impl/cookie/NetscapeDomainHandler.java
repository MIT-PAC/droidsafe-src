package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;

public class NetscapeDomainHandler extends BasicDomainHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.583 -0400", hash_original_method = "F95FAB28024AE66FDF40AADA9827F511", hash_generated_method = "4DCA6C773F36EA8FC0B6A1623E43CC26")
    public  NetscapeDomainHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.583 -0400", hash_original_method = "3CF5B4A044491C3B0C4C51D389C840F0", hash_generated_method = "FE30CD0E77458EF9162F67B75282F6AE")
    @Override
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        super.validate(cookie, origin);
        String host;
        host = origin.getHost();
        String domain;
        domain = cookie.getDomain();
        {
            boolean var171183DA5AA2382CF21A6A1891EE0576_1973785552 = (host.contains("."));
            {
                int domainParts;
                domainParts = new StringTokenizer(domain, ".").countTokens();
                {
                    boolean var3BA2CD6858BE03684C31D6022DA56F9B_164022330 = (isSpecialDomain(domain));
                    {
                        {
                            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Domain attribute \""
                        + domain 
                        + "\" violates the Netscape cookie specification for "
                        + "special domains");
                        } //End block
                    } //End block
                    {
                        {
                            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Domain attribute \""
                        + domain 
                        + "\" violates the Netscape cookie specification");
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static boolean isSpecialDomain(final String domain) {
        final String ucDomain = domain.toUpperCase(Locale.ENGLISH);
        return ucDomain.endsWith(".COM")
               || ucDomain.endsWith(".EDU")
               || ucDomain.endsWith(".NET")
               || ucDomain.endsWith(".GOV")
               || ucDomain.endsWith(".MIL")
               || ucDomain.endsWith(".ORG")
               || ucDomain.endsWith(".INT");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.585 -0400", hash_original_method = "AC681E999DAFDF08D7E859E1898D2773", hash_generated_method = "10857EB3DA17EDC104713394725E07DD")
    @Override
    public boolean match(Cookie cookie, CookieOrigin origin) {
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
        boolean varDEFF378ED8032605782C13AA2BCFC61A_381474156 = (host.endsWith(domain));
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1817295153 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1817295153;
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
        //return host.endsWith(domain);
    }

    
}

