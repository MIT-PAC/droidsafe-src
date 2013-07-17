package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class BasicSecureHandler extends AbstractCookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.659 -0400", hash_original_method = "8C195B0159F6CD3FDBCB025498841E70", hash_generated_method = "EB71FD8D5EA92F60B1D5F8D8C5352236")
    public  BasicSecureHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.659 -0400", hash_original_method = "A846E7ED9E66A102D9E806FA0D60C627", hash_generated_method = "C1CB85D4F733DAFAF6825324692F6AD3")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        addTaint(value.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_553441451 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_553441451.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_553441451;
        } //End block
        cookie.setSecure(true);
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //cookie.setSecure(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.660 -0400", hash_original_method = "4FA33B6CF0EDC25DCB9ED37E197D753F", hash_generated_method = "5AAC8B509B18743388AF472280CEF17D")
    @Override
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_675239992 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_675239992.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_675239992;
        } //End block
        if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_884917175 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_884917175.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_884917175;
        } //End block
        boolean var37CEBDF440AA6166303F9AF026F61E69_1148357152 = (!cookie.isSecure() || origin.isSecure());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2037833282 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2037833282;
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (origin == null) {
            //throw new IllegalArgumentException("Cookie origin may not be null");
        //}
        //return !cookie.isSecure() || origin.isSecure();
    }

    
}

