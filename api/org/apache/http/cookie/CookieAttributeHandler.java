package org.apache.http.cookie;

// Droidsafe Imports

public interface CookieAttributeHandler {

  
  void parse(SetCookie cookie, String value)
          throws MalformedCookieException;

  
  void validate(Cookie cookie, CookieOrigin origin)
          throws MalformedCookieException;

  
  boolean match(Cookie cookie, CookieOrigin origin);

}
