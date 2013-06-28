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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.190 -0400", hash_original_method = "F95FAB28024AE66FDF40AADA9827F511", hash_generated_method = "4DCA6C773F36EA8FC0B6A1623E43CC26")
    public  NetscapeDomainHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.190 -0400", hash_original_method = "3CF5B4A044491C3B0C4C51D389C840F0", hash_generated_method = "4554CA0DEE76693A4410F756C7FA6798")
    @Override
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        super.validate(cookie, origin);
        String host = origin.getHost();
        String domain = cookie.getDomain();
        {
            boolean var171183DA5AA2382CF21A6A1891EE0576_1048925630 = (host.contains("."));
            {
                int domainParts = new StringTokenizer(domain, ".").countTokens();
                {
                    boolean var3BA2CD6858BE03684C31D6022DA56F9B_622405905 = (isSpecialDomain(domain));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.191 -0400", hash_original_method = "AC681E999DAFDF08D7E859E1898D2773", hash_generated_method = "A2A27FE02DE8131C7CABF74CC562FE04")
    @Override
    public boolean match(Cookie cookie, CookieOrigin origin) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } //End block
        String host = origin.getHost();
        String domain = cookie.getDomain();
        boolean varDEFF378ED8032605782C13AA2BCFC61A_1051894320 = (host.endsWith(domain));
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1211957108 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1211957108;
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

