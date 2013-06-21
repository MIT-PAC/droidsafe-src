package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.protocol.HTTP;

class CharArrayBuffers {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.718 -0400", hash_original_method = "778D6ECDCF59395EDEE32BBD87397379", hash_generated_method = "778D6ECDCF59395EDEE32BBD87397379")
        public CharArrayBuffers ()
    {
    }


        static boolean containsIgnoreCaseTrimmed(CharArrayBuffer buffer,
            int beginIndex, final String str) {
        int len = buffer.length();
        char[] chars = buffer.buffer();
        while (beginIndex < len && HTTP.isWhitespace(chars[beginIndex])) {
            beginIndex++;
        }
        int size = str.length();
        boolean ok = len >= beginIndex + size;
        for (int j=0; ok && (j<size); j++) {
            char a = chars[beginIndex+j];
            char b = str.charAt(j);
            if (a != b) {
                a = toLower(a);
                b = toLower(b);
                ok = a == b;
            }
        }
        return ok;
    }

    
        static int setLowercaseIndexOf(CharArrayBuffer buffer, final int ch) {
        int beginIndex = 0;
        int endIndex = buffer.length();
        char[] chars = buffer.buffer();
        for (int i = beginIndex; i < endIndex; i++) {
            char current = chars[i];
            if (current == ch) {
                return i;
            } else if (current >= 'A' && current <= 'Z'){
                current += uppercaseAddon;
                chars[i] = current;
            }
        }
        return -1;
    }

    
        private static char toLower(char c) {
        if (c >= 'A' && c <= 'Z'){
            c += uppercaseAddon;
        }
        return c;
    }

    
    static final char uppercaseAddon = 'a' - 'A';
}

