package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.UnsupportedEncodingException;

public class RFC2396UrlDecoder {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.421 -0400", hash_original_method = "93468419C32DA90A0160CEA52FA291B9", hash_generated_method = "93468419C32DA90A0160CEA52FA291B9")
        public RFC2396UrlDecoder ()
    {
    }


        public static String decode(String uri) {
        StringBuffer translatedUri = new StringBuffer(uri.length());
        byte[] encodedchars = new byte[uri.length() / 3];
        int i = 0;
        int length = uri.length();
        int encodedcharsLength = 0;
        while (i < length) {
            if (uri.charAt(i) == '%') {
                while (i < length && uri.charAt(i) == '%') {
                    if (i + 2 < length) {
                        try {
                            byte x = (byte)Integer.parseInt(uri.substring(i + 1, i + 3), 16);
                            encodedchars[encodedcharsLength] = x;
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("Illegal hex characters in pattern %" + uri.substring(i + 1, i + 3));
                        }
                        encodedcharsLength++;
                        i += 3;
                    } else {
                        throw new IllegalArgumentException("% character should be followed by 2 hexadecimal characters.");
                    }
                }
                try {
                    String translatedPart = new String(encodedchars, 0, encodedcharsLength, "UTF-8");
                    translatedUri.append(translatedPart);
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException("Problem in decodePath: UTF-8 encoding not supported.");
                }
                encodedcharsLength = 0;
            } else {
                translatedUri.append(uri.charAt(i));
                i++;
            }
        }
        return translatedUri.toString();
    }

    
}

