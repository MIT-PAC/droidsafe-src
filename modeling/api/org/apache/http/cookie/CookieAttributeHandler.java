package org.apache.http.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface CookieAttributeHandler {
  
  @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void parse(SetCookie cookie, String value)
          throws MalformedCookieException;
  
  @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void validate(Cookie cookie, CookieOrigin origin)
          throws MalformedCookieException;
  
  @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean match(Cookie cookie, CookieOrigin origin);

}
