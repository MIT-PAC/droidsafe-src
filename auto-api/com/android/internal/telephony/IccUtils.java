package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import com.android.internal.telephony.GsmAlphabet;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class IccUtils {
    static final String LOG_TAG="IccUtils";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.181 -0400", hash_original_method = "4C0E39B4D7F909F8A60D019D87E845EA", hash_generated_method = "DF251140601170111584DA1C893A0865")
    public static String bcdToString(byte[] data, int offset, int length) {
        StringBuilder ret = new StringBuilder(length*2);
        for (int i = offset ; i < offset + length ; i++) {
            byte b;
            int v;
            v = data[i] & 0xf;
            if (v > 9)  break;
            ret.append((char)('0' + v));
            v = (data[i] >> 4) & 0xf;
            if (v == 0xf) continue;
            if (v > 9)  break;
            ret.append((char)('0' + v));
        }
        return ret.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.181 -0400", hash_original_method = "BEE01A65F8C60BA60426262AE9228EF3", hash_generated_method = "62F162BDAC42E41A72B1AB1A48D56246")
    public static String cdmaBcdToString(byte[] data, int offset, int length) {
        StringBuilder ret = new StringBuilder(length);
        int count = 0;
        for (int i = offset; count < length; i++) {
            int v;
            v = data[i] & 0xf;
            if (v > 9)  v = 0;
            ret.append((char)('0' + v));
            if (++count == length) break;
            v = (data[i] >> 4) & 0xf;
            if (v > 9)  v = 0;
            ret.append((char)('0' + v));
            ++count;
        }
        return ret.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.181 -0400", hash_original_method = "DC790BB84150038067F2702354A483B9", hash_generated_method = "82DD4263102D88A5D64624FA604574C3")
    public static int gsmBcdByteToInt(byte b) {
        int ret = 0;
        if ((b & 0xf0) <= 0x90) {
            ret = (b >> 4) & 0xf;
        }
        if ((b & 0x0f) <= 0x09) {
            ret +=  (b & 0xf) * 10;
        }
        return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.181 -0400", hash_original_method = "585BFBEE26823BCE3868E89B57F43CD3", hash_generated_method = "57F454C4D366C442D792730E031B622F")
    public static int cdmaBcdByteToInt(byte b) {
        int ret = 0;
        if ((b & 0xf0) <= 0x90) {
            ret = ((b >> 4) & 0xf) * 10;
        }
        if ((b & 0x0f) <= 0x09) {
            ret +=  (b & 0xf);
        }
        return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.182 -0400", hash_original_method = "8530804EF89502A199885F8B13B3D156", hash_generated_method = "6AFBD1113D2E2C02B0873C705C03718D")
    public static String adnStringFieldToString(byte[] data, int offset, int length) {
        if (length == 0) {
            return "";
        }
        if (length >= 1) {
            if (data[offset] == (byte) 0x80) {
                int ucslen = (length - 1) / 2;
                String ret = null;
                try {
                    ret = new String(data, offset + 1, ucslen * 2, "utf-16be");
                } catch (UnsupportedEncodingException ex) {
                    Log.e(LOG_TAG, "implausible UnsupportedEncodingException",
                          ex);
                }
                if (ret != null) {
                    ucslen = ret.length();
                    while (ucslen > 0 && ret.charAt(ucslen - 1) == '\uFFFF')
                        ucslen--;
                    return ret.substring(0, ucslen);
                }
            }
        }
        boolean isucs2 = false;
        char base = '\0';
        int len = 0;
        if (length >= 3 && data[offset] == (byte) 0x81) {
            len = data[offset + 1] & 0xFF;
            if (len > length - 3)
                len = length - 3;
            base = (char) ((data[offset + 2] & 0xFF) << 7);
            offset += 3;
            isucs2 = true;
        } else if (length >= 4 && data[offset] == (byte) 0x82) {
            len = data[offset + 1] & 0xFF;
            if (len > length - 4)
                len = length - 4;
            base = (char) (((data[offset + 2] & 0xFF) << 8) |
                            (data[offset + 3] & 0xFF));
            offset += 4;
            isucs2 = true;
        }
        if (isucs2) {
            StringBuilder ret = new StringBuilder();
            while (len > 0) {
                if (data[offset] < 0) {
                    ret.append((char) (base + (data[offset] & 0x7F)));
                    offset++;
                    len--;
                }
                int count = 0;
                while (count < len && data[offset + count] >= 0)
                    count++;
                ret.append(GsmAlphabet.gsm8BitUnpackedToString(data,
                           offset, count));
                offset += count;
                len -= count;
            }
            return ret.toString();
        }
        Resources resource = Resources.getSystem();
        String defaultCharset = "";
        try {
            defaultCharset =
                    resource.getString(com.android.internal.R.string.gsm_alphabet_default_charset);
        } catch (NotFoundException e) {
        }
        return GsmAlphabet.gsm8BitUnpackedToString(data, offset, length, defaultCharset.trim());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.182 -0400", hash_original_method = "B5552B011965C0257468E60FC2B05CAC", hash_generated_method = "DEDDAD89FB6278CB2FFEABF65DB62C31")
    static int hexCharToInt(char c) {
        if (c >= '0' && c <= '9') return (c - '0');
        if (c >= 'A' && c <= 'F') return (c - 'A' + 10);
        if (c >= 'a' && c <= 'f') return (c - 'a' + 10);
        throw new RuntimeException ("invalid hex char '" + c + "'");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.182 -0400", hash_original_method = "5CA794846447D2C6B22D76C82E64F776", hash_generated_method = "38419854DDD9759FDC9FBB9E51521BEE")
    public static byte[] hexStringToBytes(String s) {
        byte[] ret;
        if (s == null) return null;
        int sz = s.length();
        ret = new byte[sz/2];
        for (int i=0 ; i <sz ; i+=2) {
            ret[i/2] = (byte) ((hexCharToInt(s.charAt(i)) << 4)
                                | hexCharToInt(s.charAt(i+1)));
        }
        return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.182 -0400", hash_original_method = "1739217E9A1947F1CFB7C279AA20D847", hash_generated_method = "370CDD77A726AB43F9E87328F1C24D07")
    public static String bytesToHexString(byte[] bytes) {
        if (bytes == null) return null;
        StringBuilder ret = new StringBuilder(2*bytes.length);
        for (int i = 0 ; i < bytes.length ; i++) {
            int b;
            b = 0x0f & (bytes[i] >> 4);
            ret.append("0123456789abcdef".charAt(b));
            b = 0x0f & bytes[i];
            ret.append("0123456789abcdef".charAt(b));
        }
        return ret.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.182 -0400", hash_original_method = "7187443C675B66DFB3EB6766D8B9C986", hash_generated_method = "A2EE1A680FD38F3CB19DFBA62F3D10B9")
    public static String networkNameToString(byte[] data, int offset, int length) {
        String ret;
        if ((data[offset] & 0x80) != 0x80 || length < 1) {
            return "";
        }
        switch ((data[offset] >>> 4) & 0x7) {
            case 0:
                int countSeptets;
                int unusedBits = data[offset] & 7;
                countSeptets = (((length - 1) * 8) - unusedBits) / 7 ;
                ret =  GsmAlphabet.gsm7BitPackedToString(data, offset + 1, countSeptets);
            break;
            case 1:
                try {
                    ret = new String(data,
                            offset + 1, length - 1, "utf-16");
                } catch (UnsupportedEncodingException ex) {
                    ret = "";
                    Log.e(LOG_TAG,"implausible UnsupportedEncodingException", ex);
                }
            break;
            default:
                ret = "";
            break;
        }
        if ((data[offset] & 0x40) != 0) {
        }
        return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.182 -0400", hash_original_method = "9890A8A6F25E4747FAE9BE4A49E40888", hash_generated_method = "D9411ABD40E31B04E64A4DD8804DC099")
    public static Bitmap parseToBnW(byte[] data, int length) {
        int valueIndex = 0;
        int width = data[valueIndex++] & 0xFF;
        int height = data[valueIndex++] & 0xFF;
        int numOfPixels = width*height;
        int[] pixels = new int[numOfPixels];
        int pixelIndex = 0;
        int bitIndex = 7;
        byte currentByte = 0x00;
        while (pixelIndex < numOfPixels) {
            if (pixelIndex % 8 == 0) {
                currentByte = data[valueIndex++];
                bitIndex = 7;
            }
            pixels[pixelIndex++] = bitToRGB((currentByte >> bitIndex-- ) & 0x01);
        }
        ;
        if (pixelIndex != numOfPixels) {
            Log.e(LOG_TAG, "parse end and size error");
        }
        return Bitmap.createBitmap(pixels, width, height, Bitmap.Config.ARGB_8888);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.182 -0400", hash_original_method = "3BFC17C9B856533CDDF27D55AA357ECD", hash_generated_method = "41AC174765BFEDEF03F426DE9B864C51")
    private static int bitToRGB(int bit) {
        if(bit == 1){
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.182 -0400", hash_original_method = "B2B9C2CAFA68DE31B1652169B991D7C7", hash_generated_method = "4DCCD9846A398E942F29E613D3E79B18")
    public static Bitmap parseToRGB(byte[] data, int length,
            boolean transparency) {
        int valueIndex = 0;
        int width = data[valueIndex++] & 0xFF;
        int height = data[valueIndex++] & 0xFF;
        int bits = data[valueIndex++] & 0xFF;
        int colorNumber = data[valueIndex++] & 0xFF;
        int clutOffset = ((data[valueIndex++] & 0xFF) << 8)
                | (data[valueIndex++] & 0xFF);
        int[] colorIndexArray = getCLUT(data, clutOffset, colorNumber);
        if (true == transparency) {
            colorIndexArray[colorNumber - 1] = Color.TRANSPARENT;
        }
        int[] resultArray = null;
        if (0 == (8 % bits)) {
            resultArray = mapTo2OrderBitColor(data, valueIndex,
                    (width * height), colorIndexArray, bits);
        } else {
            resultArray = mapToNon2OrderBitColor(data, valueIndex,
                    (width * height), colorIndexArray, bits);
        }
        return Bitmap.createBitmap(resultArray, width, height,
                Bitmap.Config.RGB_565);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.182 -0400", hash_original_method = "B75B5DFDBFDCB10E296435FA5AE5BFD1", hash_generated_method = "FA6F194F05B81D58D148884C611CA05B")
    private static int[] mapTo2OrderBitColor(byte[] data, int valueIndex,
            int length, int[] colorArray, int bits) {
        if (0 != (8 % bits)) {
            Log.e(LOG_TAG, "not event number of color");
            return mapToNon2OrderBitColor(data, valueIndex, length, colorArray,
                    bits);
        }
        int mask = 0x01;
        switch (bits) {
        case 1:
            mask = 0x01;
            break;
        case 2:
            mask = 0x03;
            break;
        case 4:
            mask = 0x0F;
            break;
        case 8:
            mask = 0xFF;
            break;
        }
        int[] resultArray = new int[length];
        int resultIndex = 0;
        int run = 8 / bits;
        while (resultIndex < length) {
            byte tempByte = data[valueIndex++];
            for (int runIndex = 0; runIndex < run; ++runIndex) {
                int offset = run - runIndex - 1;
                resultArray[resultIndex++] = colorArray[(tempByte >> (offset * bits))
                        & mask];
            }
        }
        return resultArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.182 -0400", hash_original_method = "73828A21F4726D6F4A0F2B43DF9C37BA", hash_generated_method = "6543C9577E5031A6BE2E0A79AD3401A5")
    private static int[] mapToNon2OrderBitColor(byte[] data, int valueIndex,
            int length, int[] colorArray, int bits) {
        if (0 == (8 % bits)) {
            Log.e(LOG_TAG, "not odd number of color");
            return mapTo2OrderBitColor(data, valueIndex, length, colorArray,
                    bits);
        }
        int[] resultArray = new int[length];
        return resultArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.182 -0400", hash_original_method = "958CF8860B17626CFA5A6D34DF0F7F83", hash_generated_method = "E048057E5954DEA6769FBA847A642ADF")
    private static int[] getCLUT(byte[] rawData, int offset, int number) {
        if (null == rawData) {
            return null;
        }
        int[] result = new int[number];
        int endIndex = offset + (number * 3);
        int valueIndex = offset;
        int colorIndex = 0;
        int alpha = 0xff << 24;
        do {
            result[colorIndex++] = alpha
                    | ((rawData[valueIndex++] & 0xFF) << 16)
                    | ((rawData[valueIndex++] & 0xFF) << 8)
                    | ((rawData[valueIndex++] & 0xFF));
        } while (valueIndex < endIndex);
        return result;
    }

    
}


