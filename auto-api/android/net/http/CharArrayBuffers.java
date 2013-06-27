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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.919 -0400", hash_original_method = "757048C9429CD89F62E53746321F0081", hash_generated_method = "757048C9429CD89F62E53746321F0081")
    public CharArrayBuffers ()
    {
        //Synthesized constructor
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.921 -0400", hash_original_field = "A72A9F2075F99CA53C967159767FC043", hash_generated_field = "2DD3A4AC05FA27E996922F2474ACEEA3")

    static char uppercaseAddon = 'a' - 'A';
}

