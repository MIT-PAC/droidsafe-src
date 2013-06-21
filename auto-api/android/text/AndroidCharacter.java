package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AndroidCharacter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.954 -0400", hash_original_method = "A0E129B66E8AD67DBB09A03D0E7D5445", hash_generated_method = "A0E129B66E8AD67DBB09A03D0E7D5445")
        public AndroidCharacter ()
    {
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

    
    public static final int EAST_ASIAN_WIDTH_NEUTRAL = 0;
    public static final int EAST_ASIAN_WIDTH_AMBIGUOUS = 1;
    public static final int EAST_ASIAN_WIDTH_HALF_WIDTH = 2;
    public static final int EAST_ASIAN_WIDTH_FULL_WIDTH = 3;
    public static final int EAST_ASIAN_WIDTH_NARROW = 4;
    public static final int EAST_ASIAN_WIDTH_WIDE = 5;
}

