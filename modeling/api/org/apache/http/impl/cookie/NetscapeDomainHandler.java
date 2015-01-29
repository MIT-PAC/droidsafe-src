package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;
import java.util.StringTokenizer;

import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;

public class NetscapeDomainHandler extends BasicDomainHandler {

   /**
    * Checks if the given domain is in one of the seven special
    * top level domains defined by the Netscape cookie specification.
    * @param domain The domain.
    * @return True if the specified domain is "special"
    */
   @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.464 -0500", hash_original_method = "A08FDF345D6DF4C8E7F68B5A61C56D39", hash_generated_method = "FF43837979E318AAAF2EA6D300F148F5")
    
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

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.458 -0500", hash_original_method = "F95FAB28024AE66FDF40AADA9827F511", hash_generated_method = "E7D994F1C98A89A459D370F62F5D2494")
    
public NetscapeDomainHandler() {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.461 -0500", hash_original_method = "3CF5B4A044491C3B0C4C51D389C840F0", hash_generated_method = "EF1C6F22B19A5619E9CA9FB2D567110B")
    
@Override
    public void validate(final Cookie cookie, final CookieOrigin origin) 
            throws MalformedCookieException {
        super.validate(cookie, origin);
        // Perform Netscape Cookie draft specific validation
        String host = origin.getHost();
        String domain = cookie.getDomain();
        if (host.contains(".")) {
            int domainParts = new StringTokenizer(domain, ".").countTokens();

            if (isSpecialDomain(domain)) {
                if (domainParts < 2) {
                    throw new MalformedCookieException("Domain attribute \""
                        + domain 
                        + "\" violates the Netscape cookie specification for "
                        + "special domains");
                }
            } else {
                if (domainParts < 3) {
                    throw new MalformedCookieException("Domain attribute \""
                        + domain 
                        + "\" violates the Netscape cookie specification");
                }            
            }
        }
    }

   @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.466 -0500", hash_original_method = "AC681E999DAFDF08D7E859E1898D2773", hash_generated_method = "D7DE162440ED9EA7D40C1AD16FBAC07B")
    
@Override
public boolean match(Cookie cookie, CookieOrigin origin) {
       if (cookie == null) {
           throw new IllegalArgumentException("Cookie may not be null");
       }
       if (origin == null) {
           throw new IllegalArgumentException("Cookie origin may not be null");
       }
       String host = origin.getHost();
       String domain = cookie.getDomain();
       if (domain == null) {
           return false;
       }
       return host.endsWith(domain);
   }
    
}

