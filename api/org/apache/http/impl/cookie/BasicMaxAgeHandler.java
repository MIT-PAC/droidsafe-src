package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Date;

import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;



public class BasicMaxAgeHandler extends AbstractCookieAttributeHandler {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.785 -0500", hash_original_method = "B0446CDE16622CCB68895B794F750D42", hash_generated_method = "BDB4B85EF80A1DE400C1497516204821")
    
public BasicMaxAgeHandler() {
        super();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.788 -0500", hash_original_method = "A8EE51F3135F41C00ED9344CF5263715", hash_generated_method = "E84E2FA541FD4BED72AA2680AE46012F")
    
public void parse(final SetCookie cookie, final String value) 
            throws MalformedCookieException {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (value == null) {
            throw new MalformedCookieException("Missing value for max-age attribute");
        }
        int age;
        try {
            age = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new MalformedCookieException ("Invalid max-age attribute: " 
                    + value);
        }
        if (age < 0) {
            throw new MalformedCookieException ("Negative max-age attribute: " 
                    + value);
        }
        cookie.setExpiryDate(new Date(System.currentTimeMillis() + age * 1000L));
    }

    
}

