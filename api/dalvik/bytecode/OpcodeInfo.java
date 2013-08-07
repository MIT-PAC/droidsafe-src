package dalvik.bytecode;

// Droidsafe Imports
import droidsafe.annotations.*;




import droidsafe.helpers.DSUtils;

public final class OpcodeInfo {
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.678 -0400", hash_original_method = "A83DC80DE6B8698A045EDE141AC37084", hash_generated_method = "36AF5AEEB9531D085255128C80F8AD6C")
    private  OpcodeInfo() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    public static boolean isInvoke(int packedOpcode) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.678 -0400", hash_original_field = "1D51497A53C5FE1203A9F82796F82207", hash_generated_field = "697F114CED116BD02B0D95D24384F637")

    public static final int MAXIMUM_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.678 -0400", hash_original_field = "9E0A78BC94BB83ACF8B2D9E390A7C08D", hash_generated_field = "6D20753E77E309ACF9F90700BB324A44")

    public static final int MAXIMUM_PACKED_VALUE;
    static {
        MAXIMUM_VALUE = 65535;
        MAXIMUM_PACKED_VALUE = 511;
    }
    
}

