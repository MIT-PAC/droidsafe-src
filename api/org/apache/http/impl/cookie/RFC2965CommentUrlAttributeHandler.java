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



public class RFC2965CommentUrlAttributeHandler implements CookieAttributeHandler {

      @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.924 -0500", hash_original_method = "099D2A6A922F722517A29E0583320390", hash_generated_method = "F34BA6D6F101B42AA87F8CB18B7723D7")
    public RFC2965CommentUrlAttributeHandler() {
          super();
      }
      
      @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.925 -0500", hash_original_method = "7C96283B530725C6069CC0E44B32CD2E", hash_generated_method = "4869F60EC3F31F416F6B26CCD9CF1182")
    public void parse(final SetCookie cookie, final String commenturl)
              throws MalformedCookieException {
          if (cookie instanceof SetCookie2) {
              SetCookie2 cookie2 = (SetCookie2) cookie;
              cookie2.setCommentURL(commenturl);
          }
      }

      @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.926 -0500", hash_original_method = "991845E9A77B56F0C05EBC8CED80518E", hash_generated_method = "D423132887E3AEEA2C18EF664F0E34EE")
    public void validate(final Cookie cookie, final CookieOrigin origin)
              throws MalformedCookieException {
      }

      @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.927 -0500", hash_original_method = "768BC0018D608E66268B8C5C0AE76B3A", hash_generated_method = "D83CEB3751B5960131E4566E29C7FC53")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
          return true;
      }

    
}

