package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Date;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class BasicMaxAgeHandler extends AbstractCookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.138 -0400", hash_original_method = "B0446CDE16622CCB68895B794F750D42", hash_generated_method = "DA4D840327CEBBF0C24EEEA6E9EA8A83")
    public  BasicMaxAgeHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.138 -0400", hash_original_method = "A8EE51F3135F41C00ED9344CF5263715", hash_generated_method = "CBDC93842CA7828D6280A659FE206BC7")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Missing value for max-age attribute");
        } //End block
        int age;
        try 
        {
            age = Integer.parseInt(value);
        } //End block
        catch (NumberFormatException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException ("Invalid max-age attribute: " 
                    + value);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException ("Negative max-age attribute: " 
                    + value);
        } //End block
        cookie.setExpiryDate(new Date(System.currentTimeMillis() + age * 1000L));
        addTaint(cookie.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (value == null) {
            //throw new MalformedCookieException("Missing value for max-age attribute");
        //}
        //int age;
        //try {
            //age = Integer.parseInt(value);
        //} catch (NumberFormatException e) {
            //throw new MalformedCookieException ("Invalid max-age attribute: " 
                    //+ value);
        //}
        //if (age < 0) {
            //throw new MalformedCookieException ("Negative max-age attribute: " 
                    //+ value);
        //}
        //cookie.setExpiryDate(new Date(System.currentTimeMillis() + age * 1000L));
    }

    
}

