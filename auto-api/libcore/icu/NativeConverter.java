package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

public final class NativeConverter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.687 -0400", hash_original_method = "B3DE170E5D5FA99ECB84F9E7CDF4AF7D", hash_generated_method = "B3DE170E5D5FA99ECB84F9E7CDF4AF7D")
    public NativeConverter ()
    {
        //Synthesized constructor
    }


        public static int decode(long converterHandle, byte[] input, int inEnd,
            char[] output, int outEnd, int[] data, boolean flush) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int encode(long converterHandle, char[] input, int inEnd,
            byte[] output, int outEnd, int[] data, boolean flush) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static long openConverter(String encoding) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static void closeConverter(long converterHandle) {
    }

    
        public static void resetByteToChar(long converterHandle) {
    }

    
        public static void resetCharToByte(long converterHandle) {
    }

    
        public static byte[] getSubstitutionBytes(long converterHandle) {
        return {DSUtils.UNKNOWN_BYTE};
    }

    
        public static int getMaxBytesPerChar(long converterHandle) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int getMinBytesPerChar(long converterHandle) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static float getAveBytesPerChar(long converterHandle) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
        public static float getAveCharsPerByte(long converterHandle) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
        public static boolean contains(String converterName1, String converterName2) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean canEncode(long converterHandle, int codeUnit) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static String[] getAvailableCharsetNames() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static Charset charsetForName(String charsetName) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static int translateCodingErrorAction(CodingErrorAction action) {
        if (action == CodingErrorAction.REPORT) {
            return 0;
        } else if (action == CodingErrorAction.IGNORE) {
            return 1;
        } else if (action == CodingErrorAction.REPLACE) {
            return 2;
        } else {
            throw new AssertionError(); 
        }
    }

    
        public static int setCallbackDecode(long converterHandle, CharsetDecoder decoder) {
        return setCallbackDecode(converterHandle,
                translateCodingErrorAction(decoder.malformedInputAction()),
                translateCodingErrorAction(decoder.unmappableCharacterAction()),
                decoder.replacement());
    }

    
        private static int setCallbackDecode(long converterHandle, int onMalformedInput, int onUnmappableInput, String subChars) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int setCallbackEncode(long converterHandle, CharsetEncoder encoder) {
        return setCallbackEncode(converterHandle,
                translateCodingErrorAction(encoder.malformedInputAction()),
                translateCodingErrorAction(encoder.unmappableCharacterAction()),
                encoder.replacement());
    }

    
        private static int setCallbackEncode(long converterHandle, int onMalformedInput, int onUnmappableInput, byte[] subBytes) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

