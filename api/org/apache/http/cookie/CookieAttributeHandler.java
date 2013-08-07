package org.apache.http.cookie;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface CookieAttributeHandler {

  
  void parse(SetCookie cookie, String value)
          throws MalformedCookieException;

  
  void validate(Cookie cookie, CookieOrigin origin)
          throws MalformedCookieException;

  
  boolean match(Cookie cookie, CookieOrigin origin);

}
