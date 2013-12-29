package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.cookie.SetCookie2;





public class RFC2965DiscardAttributeHandler implements CookieAttributeHandler {

      @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.633 -0500", hash_original_method = "40A04040358E10BE463BC9E2FF4354F7", hash_generated_method = "1A6125E1646FB264469B1BE642A8BAE0")
    public RFC2965DiscardAttributeHandler() {
          super();
      }
      
      @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.633 -0500", hash_original_method = "16D6C58BF1FAAA0E132C741E4AC6541B", hash_generated_method = "CC72106ADEADF20F99F58904F68C9F80")
    public void parse(final SetCookie cookie, final String commenturl)
              throws MalformedCookieException {
          if (cookie instanceof SetCookie2) {
              SetCookie2 cookie2 = (SetCookie2) cookie;
              cookie2.setDiscard(true);
          }
      }

      @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.634 -0500", hash_original_method = "991845E9A77B56F0C05EBC8CED80518E", hash_generated_method = "D423132887E3AEEA2C18EF664F0E34EE")
    public void validate(final Cookie cookie, final CookieOrigin origin)
              throws MalformedCookieException {
      }

      @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.636 -0500", hash_original_method = "768BC0018D608E66268B8C5C0AE76B3A", hash_generated_method = "D83CEB3751B5960131E4566E29C7FC53")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
          return true;
      }

    
}

