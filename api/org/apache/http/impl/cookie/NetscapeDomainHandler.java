package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;

public class NetscapeDomainHandler extends BasicDomainHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.567 -0400", hash_original_method = "F95FAB28024AE66FDF40AADA9827F511", hash_generated_method = "4DCA6C773F36EA8FC0B6A1623E43CC26")
    public  NetscapeDomainHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.568 -0400", hash_original_method = "3CF5B4A044491C3B0C4C51D389C840F0", hash_generated_method = "B72C6314E577A297E186D68F85E6BDCD")
    @Override
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        super.validate(cookie, origin);
        String host = origin.getHost();
        String domain = cookie.getDomain();
    if(host.contains("."))        
        {
            int domainParts = new StringTokenizer(domain, ".").countTokens();
    if(isSpecialDomain(domain))            
            {
    if(domainParts < 2)                
                {
                    MalformedCookieException var3DB6640826D10C6574D0817D011D0490_1533863347 = new MalformedCookieException("Domain attribute \""
                        + domain 
                        + "\" violates the Netscape cookie specification for "
                        + "special domains");
                    var3DB6640826D10C6574D0817D011D0490_1533863347.addTaint(taint);
                    throw var3DB6640826D10C6574D0817D011D0490_1533863347;
                } //End block
            } //End block
            else
            {
    if(domainParts < 3)                
                {
                    MalformedCookieException var939C26DC878B6508D4A9471872C9F14E_1622054723 = new MalformedCookieException("Domain attribute \""
                        + domain 
                        + "\" violates the Netscape cookie specification");
                    var939C26DC878B6508D4A9471872C9F14E_1622054723.addTaint(taint);
                    throw var939C26DC878B6508D4A9471872C9F14E_1622054723;
                } //End block
            } //End block
        } //End block
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.569 -0400", hash_original_method = "AC681E999DAFDF08D7E859E1898D2773", hash_generated_method = "403B02BDEE346B669C1B33996C0EFBB2")
    @Override
    public boolean match(Cookie cookie, CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1366844759 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1366844759.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1366844759;
        } //End block
    if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_1848900427 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_1848900427.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_1848900427;
        } //End block
        String host = origin.getHost();
        String domain = cookie.getDomain();
    if(domain == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_353151267 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_321380124 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_321380124;
        } //End block
        boolean varD5638ED266D9523B0FDD6B6E7C62BCAF_1108551558 = (host.endsWith(domain));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_988663631 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_988663631;
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

