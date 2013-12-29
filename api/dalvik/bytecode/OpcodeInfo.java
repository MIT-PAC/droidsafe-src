package dalvik.bytecode;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




import droidsafe.helpers.DSUtils;

public final class OpcodeInfo {

    
    @DSModeled(DSC.BAN)
    public static boolean isInvoke(int packedOpcode) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.789 -0500", hash_original_field = "4FC28CE92B75E1906A0B6484F1AD5778", hash_generated_field = "4094A39D9EE5963244CA34FCE55F822C")

    public static  int MAXIMUM_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.790 -0500", hash_original_field = "C878DED83194C46A2FDB8D89A4AAA89A", hash_generated_field = "801BD17557F2324CC59725673F2F2334")

    public static  int MAXIMUM_PACKED_VALUE;

    /**
     * This class is not instantiable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.791 -0500", hash_original_method = "A83DC80DE6B8698A045EDE141AC37084", hash_generated_method = "A0816D2AFEC14D094AF4E3ECDC02456C")
    private OpcodeInfo() {
        // This space intentionally left blank.
    }
    static {
        MAXIMUM_VALUE = 65535;
        MAXIMUM_PACKED_VALUE = 511;
    }
    
}

