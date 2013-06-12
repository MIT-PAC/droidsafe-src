package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

public final class NativeConverter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.093 -0400", hash_original_method = "D1CB3D96189F7D0F2EAAF2A979DEB3BE", hash_generated_method = "ACB556EE967452A7F5AB6BC6B3602780")
    public static int decode(long converterHandle, byte[] input, int inEnd,
            char[] output, int outEnd, int[] data, boolean flush) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.093 -0400", hash_original_method = "6C12B2159806F485AD72A12DD23F195F", hash_generated_method = "459550623DB6BCEADBC656AA044478D1")
    public static int encode(long converterHandle, char[] input, int inEnd,
            byte[] output, int outEnd, int[] data, boolean flush) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.093 -0400", hash_original_method = "181B24141CB07B58C2EE78F837DF2F87", hash_generated_method = "5E3D429BDAF7FEBE3E43D1FD719C34B8")
    public static long openConverter(String encoding) {
    	return DSUtils.UNKNOWN_LONG;
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.093 -0400", hash_original_method = "A6654D1637D1A31122ADD77AC15CDF6E", hash_generated_method = "74ABCE9A1D438E92678DC0DE47FC693D")
    public static void closeConverter(long converterHandle) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.093 -0400", hash_original_method = "0B9FDB9B30DD4A341265A6A87B27D589", hash_generated_method = "915F0B0F65D31914B4495A3D1F2D36C3")
    public static void resetByteToChar(long converterHandle) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.093 -0400", hash_original_method = "AC7B4147F9B07A135192AF9518B2E033", hash_generated_method = "9BD5F7ACEB3C09A4AB3A4AD46682B014")
    public static void resetCharToByte(long converterHandle) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.093 -0400", hash_original_method = "94E43D27011603CD1A8C59F81EE741A4", hash_generated_method = "37A4FD553D3BF5C15B9901105C4D2747")
    public static byte[] getSubstitutionBytes(long converterHandle) {
    	byte[] retVal = {DSUtils.UNKNOWN_BYTE};
    	return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.093 -0400", hash_original_method = "C701D4000571CA055B9561754FEB4994", hash_generated_method = "026A48947477B4E595EB22CA913F8933")
    public static int getMaxBytesPerChar(long converterHandle) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.093 -0400", hash_original_method = "9EF773DBA0FC9288592BEF5BD2217F0F", hash_generated_method = "A8E9DF78675CA63B501A42D3D0162B49")
    public static int getMinBytesPerChar(long converterHandle) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.093 -0400", hash_original_method = "4E866ED9B81A4F8DEAD51AED5CD4A2DF", hash_generated_method = "B83FBBEA785F5B566A19F98134DE79AD")
    public static float getAveBytesPerChar(long converterHandle) {
    	return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.093 -0400", hash_original_method = "5304A2EB7484111B04C75D96DFFE591D", hash_generated_method = "0B3D783209286CCB679ECE967F272E43")
    public static float getAveCharsPerByte(long converterHandle) {
    	return DSUtils.UNKNOWN_FLOAT;
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.093 -0400", hash_original_method = "A517A50D3C0A9B1E11CD37C66754F7F8", hash_generated_method = "7FF39BA79EB685593EDD4E8B5B8CC886")
    public static boolean contains(String converterName1, String converterName2) {
    	return DSUtils.UNKNOWN_BOOLEAN;
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.093 -0400", hash_original_method = "9C078EDAE1E209A512E593DD57643AA1", hash_generated_method = "88BB8832CC47BB1923A2FD18D155D484")
    public static boolean canEncode(long converterHandle, int codeUnit) {
    	return DSUtils.UNKNOWN_BOOLEAN;
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.093 -0400", hash_original_method = "1D305DB31C228F7B2D34CC86D5CE63A8", hash_generated_method = "114EFDC601139CC38D2A27AFF5ACE6EE")
    public static String[] getAvailableCharsetNames() {
    	String[] retVal = {DSUtils.UNKNOWN_STRING};
    	return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.093 -0400", hash_original_method = "BA31824ED4CC04936E987AEF123C88CF", hash_generated_method = "6DDE65513A59B86DBA72ED94F296FCBB")
    public static Charset charsetForName(String charsetName) {
    	return Charset.forName(charsetName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.093 -0400", hash_original_method = "E4DEB0C107DDB25A537EF0E89F1C04F8", hash_generated_method = "841C7B7FA2A5DE34A541859CFA4BF74B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.094 -0400", hash_original_method = "1ECDF97E0F5711F64AED893C5903CD77", hash_generated_method = "6AD673FE560AB907D663F74DF6336835")
    public static int setCallbackDecode(long converterHandle, CharsetDecoder decoder) {
        return setCallbackDecode(converterHandle,
                translateCodingErrorAction(decoder.malformedInputAction()),
                translateCodingErrorAction(decoder.unmappableCharacterAction()),
                decoder.replacement());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.094 -0400", hash_original_method = "373396C2657CFBC05A6DEFD8E3BBD5CA", hash_generated_method = "BA257AA03570E4C971FA572506005AC0")
    private static int setCallbackDecode(long converterHandle, int onMalformedInput, int onUnmappableInput, String subChars) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.094 -0400", hash_original_method = "C9EC92733E72FDFF26006CD6BB2B521C", hash_generated_method = "E0EEB07D09DCA82B0AC3252F2CCCFCC5")
    public static int setCallbackEncode(long converterHandle, CharsetEncoder encoder) {
        return setCallbackEncode(converterHandle,
                translateCodingErrorAction(encoder.malformedInputAction()),
                translateCodingErrorAction(encoder.unmappableCharacterAction()),
                encoder.replacement());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.094 -0400", hash_original_method = "033841FF1A95A766F11F98B309160850", hash_generated_method = "9512F93D6AFD3C336D1956A5BD3BE66C")
    private static int setCallbackEncode(long converterHandle, int onMalformedInput, int onUnmappableInput, byte[] subBytes) {
    	return DSUtils.UNKNOWN_INT;
    }

    
}


