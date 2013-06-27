package org.apache.http.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface CookieAttributeHandler {

  
  void parse(SetCookie cookie, String value)
          throws MalformedCookieException;

  
  void validate(Cookie cookie, CookieOrigin origin)
          throws MalformedCookieException;

  
  boolean match(Cookie cookie, CookieOrigin origin);

}
