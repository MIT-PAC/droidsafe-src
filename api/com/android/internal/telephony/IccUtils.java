package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.UnsupportedEncodingException;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;





public class IccUtils {

    /**
     * Many fields in GSM SIM's are stored as nibble-swizzled BCD
     *
     * Assumes left-justified field that may be padded right with 0xf
     * values.
     *
     * Stops on invalid BCD value, returning string so far
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:40.019 -0500", hash_original_method = "4C0E39B4D7F909F8A60D019D87E845EA", hash_generated_method = "93AC6FE7BD345972FD5C90793A5EB9C7")
    
public static String
    bcdToString(byte[] data, int offset, int length) {
        StringBuilder ret = new StringBuilder(length*2);

        for (int i = offset ; i < offset + length ; i++) {
            byte b;
            int v;

            v = data[i] & 0xf;
            if (v > 9)  break;
            ret.append((char)('0' + v));

            v = (data[i] >> 4) & 0xf;
            // Some PLMNs have 'f' as high nibble, ignore it
            if (v == 0xf) continue;
            if (v > 9)  break;
            ret.append((char)('0' + v));
        }

        return ret.toString();
    }

    /**
     * Decode cdma byte into String.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:40.022 -0500", hash_original_method = "BEE01A65F8C60BA60426262AE9228EF3", hash_generated_method = "62F162BDAC42E41A72B1AB1A48D56246")
    
public static String
    cdmaBcdToString(byte[] data, int offset, int length) {
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

    /**
     * Decodes a GSM-style BCD byte, returning an int ranging from 0-99.
     *
     * In GSM land, the least significant BCD digit is stored in the most
     * significant nibble.
     *
     * Out-of-range digits are treated as 0 for the sake of the time stamp,
     * because of this:
     *
     * TS 23.040 section 9.2.3.11
     * "if the MS receives a non-integer value in the SCTS, it shall
     * assume the digit is set to 0 but shall store the entire field
     * exactly as received"
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:40.025 -0500", hash_original_method = "DC790BB84150038067F2702354A483B9", hash_generated_method = "A4E2E3C8ACAED1C4B3F2370CA6F94C70")
    
public static int
    gsmBcdByteToInt(byte b) {
        int ret = 0;

        // treat out-of-range BCD values as 0
        if ((b & 0xf0) <= 0x90) {
            ret = (b >> 4) & 0xf;
        }

        if ((b & 0x0f) <= 0x09) {
            ret +=  (b & 0xf) * 10;
        }

        return ret;
    }

    /**
     * Decodes a CDMA style BCD byte like {@link gsmBcdByteToInt}, but
     * opposite nibble format. The least significant BCD digit
     * is in the least significant nibble and the most significant
     * is in the most significant nibble.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:40.027 -0500", hash_original_method = "585BFBEE26823BCE3868E89B57F43CD3", hash_generated_method = "FCBEAA763275A9FB3CE6DCF3BB5E6945")
    
public static int
    cdmaBcdByteToInt(byte b) {
        int ret = 0;

        // treat out-of-range BCD values as 0
        if ((b & 0xf0) <= 0x90) {
            ret = ((b >> 4) & 0xf) * 10;
        }

        if ((b & 0x0f) <= 0x09) {
            ret +=  (b & 0xf);
        }

        return ret;
    }

    /**
     * Decodes a string field that's formatted like the EF[ADN] alpha
     * identifier
     *
     * From TS 51.011 10.5.1:
     *   Coding:
     *       this alpha tagging shall use either
     *      -    the SMS default 7 bit coded alphabet as defined in
     *          TS 23.038 [12] with bit 8 set to 0. The alpha identifier
     *          shall be left justified. Unused bytes shall be set to 'FF'; or
     *      -    one of the UCS2 coded options as defined in annex B.
     *
     * Annex B from TS 11.11 V8.13.0:
     *      1)  If the first octet in the alpha string is '80', then the
     *          remaining octets are 16 bit UCS2 characters ...
     *      2)  if the first octet in the alpha string is '81', then the
     *          second octet contains a value indicating the number of
     *          characters in the string, and the third octet contains an
     *          8 bit number which defines bits 15 to 8 of a 16 bit
     *          base pointer, where bit 16 is set to zero and bits 7 to 1
     *          are also set to zero.  These sixteen bits constitute a
     *          base pointer to a "half page" in the UCS2 code space, to be
     *          used with some or all of the remaining octets in the string.
     *          The fourth and subsequent octets contain codings as follows:
     *          If bit 8 of the octet is set to zero, the remaining 7 bits
     *          of the octet contain a GSM Default Alphabet character,
     *          whereas if bit 8 of the octet is set to one, then the
     *          remaining seven bits are an offset value added to the
     *          16 bit base pointer defined earlier...
     *      3)  If the first octet of the alpha string is set to '82', then
     *          the second octet contains a value indicating the number of
     *          characters in the string, and the third and fourth octets
     *          contain a 16 bit number which defines the complete 16 bit
     *          base pointer to a "half page" in the UCS2 code space...
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:40.031 -0500", hash_original_method = "8530804EF89502A199885F8B13B3D156", hash_generated_method = "D974982D59EF5C700DD07374998DAD9A")
    
public static String
    adnStringFieldToString(byte[] data, int offset, int length) {
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
                    // trim off trailing FFFF characters

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
                // UCS2 subset case

                if (data[offset] < 0) {
                    ret.append((char) (base + (data[offset] & 0x7F)));
                    offset++;
                    len--;
                }

                // GSM character set case

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
            // Ignore Exception and defaultCharset is set to a empty string.
        }
        return GsmAlphabet.gsm8BitUnpackedToString(data, offset, length, defaultCharset.trim());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:40.034 -0500", hash_original_method = "B5552B011965C0257468E60FC2B05CAC", hash_generated_method = "DEDDAD89FB6278CB2FFEABF65DB62C31")
    
static int
    hexCharToInt(char c) {
        if (c >= '0' && c <= '9') return (c - '0');
        if (c >= 'A' && c <= 'F') return (c - 'A' + 10);
        if (c >= 'a' && c <= 'f') return (c - 'a' + 10);

        throw new RuntimeException ("invalid hex char '" + c + "'");
    }

    /**
     * Converts a hex String to a byte array.
     *
     * @param s A string of hexadecimal characters, must be an even number of
     *          chars long
     *
     * @return byte array representation
     *
     * @throws RuntimeException on invalid format
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:40.036 -0500", hash_original_method = "5CA794846447D2C6B22D76C82E64F776", hash_generated_method = "38419854DDD9759FDC9FBB9E51521BEE")
    
public static byte[]
    hexStringToBytes(String s) {
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


    /**
     * Converts a byte array into a String of hexadecimal characters.
     *
     * @param bytes an array of bytes
     *
     * @return hex string representation of bytes array
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:40.039 -0500", hash_original_method = "1739217E9A1947F1CFB7C279AA20D847", hash_generated_method = "370CDD77A726AB43F9E87328F1C24D07")
    
public static String
    bytesToHexString(byte[] bytes) {
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


    /**
     * Convert a TS 24.008 Section 10.5.3.5a Network Name field to a string
     * "offset" points to "octet 3", the coding scheme byte
     * empty string returned on decode error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:40.043 -0500", hash_original_method = "7187443C675B66DFB3EB6766D8B9C986", hash_generated_method = "2D8D3DFF14460E3CCB73FB9EE0D4DACF")
    
public static String
    networkNameToString(byte[] data, int offset, int length) {
        String ret;

        if ((data[offset] & 0x80) != 0x80 || length < 1) {
            return "";
        }

        switch ((data[offset] >>> 4) & 0x7) {
            case 0:
                // SMS character set
                int countSeptets;
                int unusedBits = data[offset] & 7;
                countSeptets = (((length - 1) * 8) - unusedBits) / 7 ;
                ret =  GsmAlphabet.gsm7BitPackedToString(data, offset + 1, countSeptets);
            break;
            case 1:
                // UCS2
                try {
                    ret = new String(data,
                            offset + 1, length - 1, "utf-16");
                } catch (UnsupportedEncodingException ex) {
                    ret = "";
                    Log.e(LOG_TAG,"implausible UnsupportedEncodingException", ex);
                }
            break;

            // unsupported encoding
            default:
                ret = "";
            break;
        }

        // "Add CI"
        // "The MS should add the letters for the Country's Initials and
        //  a separator (e.g. a space) to the text string"

        if ((data[offset] & 0x40) != 0) {
            // FIXME(mkf) add country initials here

        }

        return ret;
    }

    /**
     * Convert a TS 131.102 image instance of code scheme '11' into Bitmap
     * @param data The raw data
     * @param length The length of image body
     * @return The bitmap
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:40.046 -0500", hash_original_method = "9890A8A6F25E4747FAE9BE4A49E40888", hash_generated_method = "967A2AA9C5B7A76C59928E83829106FB")
    
public static Bitmap parseToBnW(byte[] data, int length){
        int valueIndex = 0;
        int width = data[valueIndex++] & 0xFF;
        int height = data[valueIndex++] & 0xFF;
        int numOfPixels = width*height;

        int[] pixels = new int[numOfPixels];

        int pixelIndex = 0;
        int bitIndex = 7;
        byte currentByte = 0x00;
        while (pixelIndex < numOfPixels) {
            // reassign data and index for every byte (8 bits).
            if (pixelIndex % 8 == 0) {
                currentByte = data[valueIndex++];
                bitIndex = 7;
            }
            pixels[pixelIndex++] = bitToRGB((currentByte >> bitIndex-- ) & 0x01);
        };

        if (pixelIndex != numOfPixels) {
            Log.e(LOG_TAG, "parse end and size error");
        }
        return Bitmap.createBitmap(pixels, width, height, Bitmap.Config.ARGB_8888);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:40.049 -0500", hash_original_method = "3BFC17C9B856533CDDF27D55AA357ECD", hash_generated_method = "41AC174765BFEDEF03F426DE9B864C51")
    
private static int bitToRGB(int bit){
        if(bit == 1){
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }

    /**
     * a TS 131.102 image instance of code scheme '11' into color Bitmap
     *
     * @param data The raw data
     * @param length the length of image body
     * @param transparency with or without transparency
     * @return The color bitmap
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:40.052 -0500", hash_original_method = "B2B9C2CAFA68DE31B1652169B991D7C7", hash_generated_method = "4DCCD9846A398E942F29E613D3E79B18")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:40.055 -0500", hash_original_method = "B75B5DFDBFDCB10E296435FA5AE5BFD1", hash_generated_method = "FA6F194F05B81D58D148884C611CA05B")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:40.057 -0500", hash_original_method = "73828A21F4726D6F4A0F2B43DF9C37BA", hash_generated_method = "C04E7297289248979DC634FF62511B4B")
    
private static int[] mapToNon2OrderBitColor(byte[] data, int valueIndex,
            int length, int[] colorArray, int bits) {
        if (0 == (8 % bits)) {
            Log.e(LOG_TAG, "not odd number of color");
            return mapTo2OrderBitColor(data, valueIndex, length, colorArray,
                    bits);
        }

        int[] resultArray = new int[length];
        // TODO fix me:
        return resultArray;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:40.060 -0500", hash_original_method = "958CF8860B17626CFA5A6D34DF0F7F83", hash_generated_method = "2E6E44F1E2B239E952041B80F0AF8D3E")
    
private static int[] getCLUT(byte[] rawData, int offset, int number) {
        if (null == rawData) {
            return null;
        }

        int[] result = new int[number];
        int endIndex = offset + (number * 3); // 1 color use 3 bytes
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:40.016 -0500", hash_original_field = "215EDBB4F8FBB119E6C215EEBF8ACD69", hash_generated_field = "853E0573FD2EF23B87C9F780C40EC2A4")

    static final String LOG_TAG="IccUtils";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.409 -0400", hash_original_method = "7497E316CBF08BC6A4E1097E009E4B82", hash_generated_method = "7497E316CBF08BC6A4E1097E009E4B82")
    public IccUtils ()
    {
        //Synthesized constructor
    }
}

