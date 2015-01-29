package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class BasicCommentHandler extends AbstractCookieAttributeHandler {

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.587 -0500", hash_original_method = "753BC5BDDB6B9E5E273FEAA2E3B0731A", hash_generated_method = "DFFB02DE86EF5BEBC9E2E866FCA59431")
    
public BasicCommentHandler() {
        super();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.589 -0500", hash_original_method = "99A929E9A1376512F0C10CD29D19768F", hash_generated_method = "D817CABE1EE56A97C3DCB5CB4370A2C6")
    
public void parse(final SetCookie cookie, final String value) 
            throws MalformedCookieException {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        cookie.setComment(value);
    }
    
}

