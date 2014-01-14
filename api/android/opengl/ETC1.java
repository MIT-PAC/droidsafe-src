package android.opengl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.Buffer;

import droidsafe.helpers.DSUtils;

public class ETC1 {
    
    public static void encodeBlock(Buffer in, int validPixelMask, Buffer out) {
    }
    
    public static void decodeBlock(Buffer in, Buffer out) {
    }
    
    public static int getEncodedDataSize(int width, int height) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1668332068 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1668332068;
    }
    
    public static void encodeImage(Buffer in, int width, int height,
            int pixelSize, int stride, Buffer out) {
    }
    
    public static void decodeImage(Buffer in, Buffer out,
            int width, int height, int pixelSize, int stride) {
    }
    
    public static void formatHeader(Buffer header, int width, int height) {
    }
    
    public static boolean isValid(Buffer header) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1742416740 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1742416740;
    }
    
    public static int getWidth(Buffer header) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_382514895 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_382514895;
    }
    
    public static int getHeight(Buffer header) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_567929593 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_567929593;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.140 -0500", hash_original_field = "3FD41814A44CD87686FFB634677A1BB4", hash_generated_field = "3863B19F8A17DA2305AA0B46C80C0681")

    public static final int ENCODED_BLOCK_SIZE = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.142 -0500", hash_original_field = "868B2FAE7C9AACD98DB11CE9061A4C5D", hash_generated_field = "CD937CC0221DEB1D6DE4D19C9EDDAAB1")

    public static final int DECODED_BLOCK_SIZE = 48;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.145 -0500", hash_original_field = "4330A902963344A92CD80D34B202D4A7", hash_generated_field = "887BE6CF1F15429C9D844A213EBC78E4")

    public static final int ETC_PKM_HEADER_SIZE = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.147 -0500", hash_original_field = "8E26BB05348CD082DAF5BF6C8F86D198", hash_generated_field = "FFF4172237392812166125A04B3CE565")

    public static final int ETC1_RGB8_OES = 0x8D64;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.897 -0400", hash_original_method = "A91C782DE4E2E5AE629C67E54AACAB60", hash_generated_method = "A91C782DE4E2E5AE629C67E54AACAB60")
    public ETC1 ()
    {
        //Synthesized constructor
    }
}

