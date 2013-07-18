package android.net.http;

// Droidsafe Imports
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

class CharArrayBuffers {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.864 -0400", hash_original_method = "757048C9429CD89F62E53746321F0081", hash_generated_method = "757048C9429CD89F62E53746321F0081")
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

    
    @DSModeled(DSC.SAFE)
    private static char toLower(char c) {
        if (c >= 'A' && c <= 'Z'){
            c += uppercaseAddon;
        }
        return c;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.864 -0400", hash_original_field = "A72A9F2075F99CA53C967159767FC043", hash_generated_field = "B3E115C5CFE77FCACE5B31A27B8BA562")

    static final char uppercaseAddon = 'a' - 'A';
}

