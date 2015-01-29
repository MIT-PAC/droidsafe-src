package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

class FilePathToURI {

    // To escape a file path to a URI, by using %HH to represent
    // special ASCII characters: 0x00~0x1F, 0x7F, ' ', '<', '>', '#', '%'
    // and '"' and non-ASCII characters (whose value >= 128).
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.394 -0500", hash_original_method = "A5495EB34350F814D7FCFEF639616645", hash_generated_method = "A292B3CCC33BB6128F8FBDD8BD747DEA")
    
public static String filepath2URI(String path){
        // return null if path is null.
        if (path == null)
            return null;

        char separator = java.io.File.separatorChar;
        path = path.replace(separator, '/');

        int len = path.length(), ch;
        StringBuilder buffer = new StringBuilder(len*3);
        buffer.append("file://");
        // change C:/blah to /C:/blah
        if (len >= 2 && path.charAt(1) == ':') {
            ch = Character.toUpperCase(path.charAt(0));
            if (ch >= 'A' && ch <= 'Z') {
                buffer.append('/');
            }
        }

        // for each character in the path
        int i = 0;
        for (; i < len; i++) {
            ch = path.charAt(i);
            // if it's not an ASCII character, break here, and use UTF-8 encoding
            if (ch >= 128)
                break;
            if (gNeedEscaping[ch]) {
                buffer.append('%');
                buffer.append(gAfterEscaping1[ch]);
                buffer.append(gAfterEscaping2[ch]);
                // record the fact that it's escaped
            }
            else {
                buffer.append((char)ch);
            }
        }

        // we saw some non-ascii character
        if (i < len) {
            // get UTF-8 bytes for the remaining sub-string
            byte[] bytes = null;
            byte b;
            try {
                bytes = path.substring(i).getBytes("UTF-8");
            } catch (java.io.UnsupportedEncodingException e) {
                // should never happen
                return path;
            }
            len = bytes.length;

            // for each byte
            for (i = 0; i < len; i++) {
                b = bytes[i];
                // for non-ascii character: make it positive, then escape
                if (b < 0) {
                    ch = b + 256;
                    buffer.append('%');
                    buffer.append(gHexChs[ch >> 4]);
                    buffer.append(gHexChs[ch & 0xf]);
                }
                else if (gNeedEscaping[b]) {
                    buffer.append('%');
                    buffer.append(gAfterEscaping1[b]);
                    buffer.append(gAfterEscaping2[b]);
                }
                else {
                    buffer.append((char)b);
                }
            }
        }

        return buffer.toString();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.383 -0500", hash_original_field = "0D7CC4D6DA022971DD5F553D15224EF6", hash_generated_field = "C3055AA40E79A60B3F36012420DA13AE")

    private static boolean gNeedEscaping[] = new boolean[128];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.386 -0500", hash_original_field = "7ADD991EDE44B80B470D50ED0CB09125", hash_generated_field = "7379EBF750E11CD2741D418B75C71A4E")

    private static char[] gAfterEscaping1 = new char[128];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.388 -0500", hash_original_field = "D8B43F9A5ABE9094D87CDA6561809C87", hash_generated_field = "51C8C6ABABDB970B5C1CDF7641D930E8")

    private static char[] gAfterEscaping2 = new char[128];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.390 -0500", hash_original_field = "9BF0D1F05EDB9DE813F3D15C18C626D8", hash_generated_field = "561EB9873723994E4756634B4B25A3E8")

    private static char[] gHexChs = {'0', '1', '2', '3', '4', '5', '6', '7',
                                     '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.811 -0400", hash_original_method = "B4CB27912F49612C4343E9F9CCDC4431", hash_generated_method = "B4CB27912F49612C4343E9F9CCDC4431")
    public FilePathToURI ()
    {
        //Synthesized constructor
    }
    static {
        for (int i = 0; i <= 0x1f; i++) {
            gNeedEscaping[i] = true;
            gAfterEscaping1[i] = gHexChs[i >> 4];
            gAfterEscaping2[i] = gHexChs[i & 0xf];
        }
        gNeedEscaping[0x7f] = true;
        gAfterEscaping1[0x7f] = '7';
        gAfterEscaping2[0x7f] = 'F';
        char[] escChs = {' ', '<', '>', '#', '%', '"', '{', '}',
                         '|', '\\', '^', '~', '[', ']', '`'};
        int len = escChs.length;
        char ch;
        for (int i = 0; i < len; i++) {
            ch = escChs[i];
            gNeedEscaping[ch] = true;
            gAfterEscaping1[ch] = gHexChs[ch >> 4];
            gAfterEscaping2[ch] = gHexChs[ch & 0xf];
        }
    }
    
}

