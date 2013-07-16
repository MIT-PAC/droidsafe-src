package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.cookie.SetCookie2;

public class RFC2965DiscardAttributeHandler implements CookieAttributeHandler {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.815 -0400", hash_original_method = "40A04040358E10BE463BC9E2FF4354F7", hash_generated_method = "A8A4D4F0913E8CA95AF486E5DDC0A437")
    public  RFC2965DiscardAttributeHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.816 -0400", hash_original_method = "16D6C58BF1FAAA0E132C741E4AC6541B", hash_generated_method = "DE07457D3082534563935F907D32C8FB")
    public void parse(final SetCookie cookie, final String commenturl) throws MalformedCookieException {
        addTaint(commenturl.getTaint());
        addTaint(cookie.getTaint());
    if(cookie instanceof SetCookie2)        
        {
            SetCookie2 cookie2 = (SetCookie2) cookie;
            cookie2.setDiscard(true);
        } //End block
        // ---------- Original Method ----------
        //if (cookie instanceof SetCookie2) {
              //SetCookie2 cookie2 = (SetCookie2) cookie;
              //cookie2.setDiscard(true);
          //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.816 -0400", hash_original_method = "991845E9A77B56F0C05EBC8CED80518E", hash_generated_method = "8B6987ACBD2487D5D2EE39BB6FEC15C9")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.816 -0400", hash_original_method = "768BC0018D608E66268B8C5C0AE76B3A", hash_generated_method = "B7F808B7B36DE8505F58BEC4730A3F83")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_1598367600 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_953140326 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_953140326;
        // ---------- Original Method ----------
        //return true;
    }

    
}

