package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.812 -0400", hash_original_method = "7497E316CBF08BC6A4E1097E009E4B82", hash_generated_method = "7497E316CBF08BC6A4E1097E009E4B82")
    public IccUtils ()
    {
        //Synthesized constructor
    }


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

    
        static int hexCharToInt(char c) {
        if (c >= '0' && c <= '9') return (c - '0');
        if (c >= 'A' && c <= 'F') return (c - 'A' + 10);
        if (c >= 'a' && c <= 'f') return (c - 'a' + 10);
        throw new RuntimeException ("invalid hex char '" + c + "'");
    }

    
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

    
        private static int bitToRGB(int bit) {
        if(bit == 1){
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }

    
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.817 -0400", hash_original_field = "657F5D0ADB30FEB439FAC6CC6AEF7E0C", hash_generated_field = "853E0573FD2EF23B87C9F780C40EC2A4")

    static final String LOG_TAG = "IccUtils";
}

