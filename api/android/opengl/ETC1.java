package android.opengl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.Buffer;

public class ETC1 {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.155 -0400", hash_original_method = "A91C782DE4E2E5AE629C67E54AACAB60", hash_generated_method = "A91C782DE4E2E5AE629C67E54AACAB60")
    public ETC1 ()
    {
        //Synthesized constructor
    }


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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.157 -0400", hash_original_field = "DF49E876F0672A6CAC2FFCCD29DF036A", hash_generated_field = "3863B19F8A17DA2305AA0B46C80C0681")

    public static final int ENCODED_BLOCK_SIZE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.157 -0400", hash_original_field = "27C65A8CCD0606A6FBF4109647C25654", hash_generated_field = "CD937CC0221DEB1D6DE4D19C9EDDAAB1")

    public static final int DECODED_BLOCK_SIZE = 48;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.158 -0400", hash_original_field = "F3B9484B936D8882576EE79ED95237B8", hash_generated_field = "887BE6CF1F15429C9D844A213EBC78E4")

    public static final int ETC_PKM_HEADER_SIZE = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.158 -0400", hash_original_field = "92D7101A9976DC9433063DE3CBFFE272", hash_generated_field = "FFF4172237392812166125A04B3CE565")

    public static final int ETC1_RGB8_OES = 0x8D64;
}

