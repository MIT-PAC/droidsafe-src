package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class BasicExpiresHandler extends AbstractCookieAttributeHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.237 -0400", hash_original_field = "60E59FA1D4034653FC981EEB8C0CE3F3", hash_generated_field = "41DF6CEE83D74A6FDB1FAB0DD1A4D526")

    private String[] datepatterns;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.238 -0400", hash_original_method = "E41CF253A9B9B5C6E744E06930B5B074", hash_generated_method = "F6464FC3D65820166B5D27E63DB1D757")
    public  BasicExpiresHandler(final String[] datepatterns) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Array of date patterns may not be null");
        } //End block
        this.datepatterns = datepatterns;
        // ---------- Original Method ----------
        //if (datepatterns == null) {
            //throw new IllegalArgumentException("Array of date patterns may not be null");
        //}
        //this.datepatterns = datepatterns;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.238 -0400", hash_original_method = "E5515B48EDFE7B38CBDC32E74DAEC7F0", hash_generated_method = "9FBAA14BD4F81C680EC8206ED06D10D5")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Missing value for expires attribute");
        } //End block
        try 
        {
            cookie.setExpiryDate(DateUtils.parseDate(value, this.datepatterns));
        } //End block
        catch (DateParseException dpe)
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Unable to parse expires attribute: " 
                + value);
        } //End block
        addTaint(cookie.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (value == null) {
            //throw new MalformedCookieException("Missing value for expires attribute");
        //}
        //try {
            //cookie.setExpiryDate(DateUtils.parseDate(value, this.datepatterns));
        //} catch (DateParseException dpe) {
            //throw new MalformedCookieException("Unable to parse expires attribute: " 
                //+ value);
        //}
    }

    
}

