package libcore.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.nio.charset.Charsets;
import libcore.util.EmptyArray;

public final class Base64 {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.807 -0400", hash_original_method = "B12DC6BE1A1E2EB3A4F484EDEACB8E03", hash_generated_method = "96F9E0BDD170E9FC5C3951236F2EB54E")
    private  Base64() {
        
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] decode(byte[] in) {
        return decode(in, in.length);
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] decode(byte[] in, int len) {
        int length = len / 4 * 3;
        if (length == 0) {
            return EmptyArray.BYTE;
        }
        byte[] out = new byte[length];
        int pad = 0;
        byte chr;
        for (;;len--) {
            chr = in[len-1];
            if ((chr == '\n') || (chr == '\r') ||
                    (chr == ' ') || (chr == '\t')) {
                continue;
            }
            if (chr == '=') {
                pad++;
            } else {
                break;
            }
        }
        int outIndex = 0;
        int inIndex = 0;
        int bits = 0;
        int quantum = 0;
        for (int i=0; i<len; i++) {
            chr = in[i];
            if ((chr == '\n') || (chr == '\r') ||
                    (chr == ' ') || (chr == '\t')) {
                continue;
            }
            if ((chr >= 'A') && (chr <= 'Z')) {
                bits = chr - 65;
            } else if ((chr >= 'a') && (chr <= 'z')) {
                bits = chr - 71;
            } else if ((chr >= '0') && (chr <= '9')) {
                bits = chr + 4;
            } else if (chr == '+') {
                bits = 62;
            } else if (chr == '/') {
                bits = 63;
            } else {
                return null;
            }
            quantum = (quantum << 6) | (byte) bits;
            if (inIndex%4 == 3) {
                out[outIndex++] = (byte) (quantum >> 16);
                out[outIndex++] = (byte) (quantum >> 8);
                out[outIndex++] = (byte) quantum;
            }
            inIndex++;
        }
        if (pad > 0) {
            quantum = quantum << (6*pad);
            out[outIndex++] = (byte) (quantum >> 16);
            if (pad == 1) {
                out[outIndex++] = (byte) (quantum >> 8);
            }
        }
        byte[] result = new byte[outIndex];
        System.arraycopy(out, 0, result, 0, outIndex);
        return result;
    }

    
    @DSModeled(DSC.SAFE)
    public static String encode(byte[] in) {
        int length = (in.length + 2) * 4 / 3;
        byte[] out = new byte[length];
        int index = 0, end = in.length - in.length % 3;
        for (int i = 0; i < end; i += 3) {
            out[index++] = map[(in[i] & 0xff) >> 2];
            out[index++] = map[((in[i] & 0x03) << 4) | ((in[i+1] & 0xff) >> 4)];
            out[index++] = map[((in[i+1] & 0x0f) << 2) | ((in[i+2] & 0xff) >> 6)];
            out[index++] = map[(in[i+2] & 0x3f)];
        }
        switch (in.length % 3) {
            case 1:
                out[index++] = map[(in[end] & 0xff) >> 2];
                out[index++] = map[(in[end] & 0x03) << 4];
                out[index++] = '=';
                out[index++] = '=';
                break;
            case 2:
                out[index++] = map[(in[end] & 0xff) >> 2];
                out[index++] = map[((in[end] & 0x03) << 4) | ((in[end+1] & 0xff) >> 4)];
                out[index++] = map[((in[end+1] & 0x0f) << 2)];
                out[index++] = '=';
                break;
        }
        return new String(out, 0, index, Charsets.US_ASCII);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.808 -0400", hash_original_field = "A5BA4FA48DF3D1EE63BD76EA10F554A0", hash_generated_field = "82F1210628F15E92912F89A88C162707")

    private static final byte[] map = new byte[]
        {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
         'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b',
         'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
         'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
         '4', '5', '6', '7', '8', '9', '+', '/'};
}

