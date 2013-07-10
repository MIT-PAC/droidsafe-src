package javax.xml.parsers;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

class FilePathToURI {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.705 -0400", hash_original_method = "B4CB27912F49612C4343E9F9CCDC4431", hash_generated_method = "B4CB27912F49612C4343E9F9CCDC4431")
    public FilePathToURI ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static String filepath2URI(String path) {
        if (path == null)
            return null;
        char separator = java.io.File.separatorChar;
        path = path.replace(separator, '/');
        int len = path.length(), ch;
        StringBuilder buffer = new StringBuilder(len*3);
        buffer.append("file://");
        if (len >= 2 && path.charAt(1) == ':') {
            ch = Character.toUpperCase(path.charAt(0));
            if (ch >= 'A' && ch <= 'Z') {
                buffer.append('/');
            }
        }
        int i = 0;
        for (; i < len; i++) {
            ch = path.charAt(i);
            if (ch >= 128)
                break;
            if (gNeedEscaping[ch]) {
                buffer.append('%');
                buffer.append(gAfterEscaping1[ch]);
                buffer.append(gAfterEscaping2[ch]);
            }
            else {
                buffer.append((char)ch);
            }
        }
        if (i < len) {
            byte[] bytes = null;
            byte b;
            try {
                bytes = path.substring(i).getBytes("UTF-8");
            } catch (java.io.UnsupportedEncodingException e) {
                return path;
            }
            len = bytes.length;
            for (i = 0; i < len; i++) {
                b = bytes[i];
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.706 -0400", hash_original_field = "EC27C865565761B258910863AEBE6454", hash_generated_field = "C3055AA40E79A60B3F36012420DA13AE")

    private static boolean gNeedEscaping[] = new boolean[128];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.706 -0400", hash_original_field = "801A04480E7C8A9F6D66781A50FAA4D8", hash_generated_field = "7379EBF750E11CD2741D418B75C71A4E")

    private static char[] gAfterEscaping1 = new char[128];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.706 -0400", hash_original_field = "2786D9DD9846BD1FEA660D58D7C7F7DD", hash_generated_field = "51C8C6ABABDB970B5C1CDF7641D930E8")

    private static char[] gAfterEscaping2 = new char[128];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.706 -0400", hash_original_field = "2A1B0B5BE6EA5931E26A3F1B94F7C043", hash_generated_field = "561EB9873723994E4756634B4B25A3E8")

    private static char[] gHexChs = {'0', '1', '2', '3', '4', '5', '6', '7',
                                     '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
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

