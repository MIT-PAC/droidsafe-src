package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AndroidCharacter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.173 -0400", hash_original_method = "9F50F98AF92A1A34E78D985413026D5F", hash_generated_method = "9F50F98AF92A1A34E78D985413026D5F")
    public AndroidCharacter ()
    {
        //Synthesized constructor
    }


        public static void getDirectionalities(char[] src, byte[] dest,
                                                  int count) {
    }

    
        public static int getEastAsianWidth(char input) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static void getEastAsianWidths(char[] src, int start,
                                                 int count, byte[] dest) {
    }

    
        public static boolean mirror(char[] text, int start, int count) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static char getMirror(char ch) {
        return DSUtils.UNKNOWN_CHAR;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.183 -0400", hash_original_field = "A2CF2D7077272D0566A57DB668CE1D89", hash_generated_field = "98DECEB35F8226006D9E5F1A18C84ABF")

    public static final int EAST_ASIAN_WIDTH_NEUTRAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.183 -0400", hash_original_field = "C01281F37528E49AAF506E6918ED7D6D", hash_generated_field = "B788AEF90FD61851C3B407DF2E123649")

    public static final int EAST_ASIAN_WIDTH_AMBIGUOUS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.183 -0400", hash_original_field = "5145BEF587966B9166FA80A154367312", hash_generated_field = "D05E77E189C53407D5D0AA6A0DA0744F")

    public static final int EAST_ASIAN_WIDTH_HALF_WIDTH = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.183 -0400", hash_original_field = "B742EC476C8E52317090119E5B38B95A", hash_generated_field = "6C2E77B7FF4C3F7740D29FCA73C3E47D")

    public static final int EAST_ASIAN_WIDTH_FULL_WIDTH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.183 -0400", hash_original_field = "6811BE2E0720F5017BD601665FA29035", hash_generated_field = "7BC3398C60B13E1CAE358A0D2B17DAB4")

    public static final int EAST_ASIAN_WIDTH_NARROW = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.183 -0400", hash_original_field = "FC5A2F5E967F4B2938E4B63BC14722A0", hash_generated_field = "BF1AF0A4B120941E4601D2BB087123B2")

    public static final int EAST_ASIAN_WIDTH_WIDE = 5;
}

