package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;




public class BasicExpiresHandler extends AbstractCookieAttributeHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.271 -0500", hash_original_field = "6ECCC683F151EE6CE57F2B5BB3F18FF6", hash_generated_field = "41DF6CEE83D74A6FDB1FAB0DD1A4D526")

    private  String[] datepatterns;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.274 -0500", hash_original_method = "E41CF253A9B9B5C6E744E06930B5B074", hash_generated_method = "EDA042B785A8AEB93E0BAB8B54D8755C")
    
public BasicExpiresHandler(final String[] datepatterns) {
        if (datepatterns == null) {
            throw new IllegalArgumentException("Array of date patterns may not be null");
        }
        this.datepatterns = datepatterns;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.276 -0500", hash_original_method = "E5515B48EDFE7B38CBDC32E74DAEC7F0", hash_generated_method = "38AA8BDA8DA76992E7E05D996072BEDE")
    
public void parse(final SetCookie cookie, final String value) 
            throws MalformedCookieException {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (value == null) {
            throw new MalformedCookieException("Missing value for expires attribute");
        }
        try {
            cookie.setExpiryDate(DateUtils.parseDate(value, this.datepatterns));
        } catch (DateParseException dpe) {
            throw new MalformedCookieException("Unable to parse expires attribute: " 
                + value);
        }
    }

    
}

