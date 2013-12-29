package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




import droidsafe.helpers.DSUtils;

public class AndroidCharacter {


    @DSModeled(DSC.SAFE)
    public static void getDirectionalities(char[] src, byte[] dest,
                                                  int count) {
    }

    
    @DSModeled(DSC.SAFE)
    public static int getEastAsianWidth(char input) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1166295311 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1166295311;
    }

    
    @DSModeled(DSC.SAFE)
    public static void getEastAsianWidths(char[] src, int start,
                                                 int count, byte[] dest) {
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean mirror(char[] text, int start, int count) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_456670344 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_456670344;
    }

    
    @DSModeled(DSC.SAFE)
    public static char getMirror(char ch) {
                char varA87DEB01C5F539E6BDA34829C8EF2368_2008958859 = DSUtils.UNKNOWN_CHAR;
        return varA87DEB01C5F539E6BDA34829C8EF2368_2008958859;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:53.428 -0500", hash_original_field = "2BEB84B214627D9549964994B4BB5258", hash_generated_field = "98DECEB35F8226006D9E5F1A18C84ABF")

    public static final int EAST_ASIAN_WIDTH_NEUTRAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:53.429 -0500", hash_original_field = "1466459EB4A130BA8D7791282F0C2CD2", hash_generated_field = "B788AEF90FD61851C3B407DF2E123649")

    public static final int EAST_ASIAN_WIDTH_AMBIGUOUS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:53.430 -0500", hash_original_field = "4F36059EF4CBDCEA11570E65471E1678", hash_generated_field = "D05E77E189C53407D5D0AA6A0DA0744F")

    public static final int EAST_ASIAN_WIDTH_HALF_WIDTH = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:53.431 -0500", hash_original_field = "1EAFBE3E4A5CB19EA1B2CBCCCB422D7B", hash_generated_field = "6C2E77B7FF4C3F7740D29FCA73C3E47D")

    public static final int EAST_ASIAN_WIDTH_FULL_WIDTH = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:53.432 -0500", hash_original_field = "561DAE2829B7383E2338F2820D56D801", hash_generated_field = "7BC3398C60B13E1CAE358A0D2B17DAB4")

    public static final int EAST_ASIAN_WIDTH_NARROW = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:53.432 -0500", hash_original_field = "C06928A2D2A6B08B2D4FCF2ACAABF949", hash_generated_field = "BF1AF0A4B120941E4601D2BB087123B2")

    public static final int EAST_ASIAN_WIDTH_WIDE = 5;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.365 -0400", hash_original_method = "9F50F98AF92A1A34E78D985413026D5F", hash_generated_method = "9F50F98AF92A1A34E78D985413026D5F")
    public AndroidCharacter ()
    {
        //Synthesized constructor
    }
}

