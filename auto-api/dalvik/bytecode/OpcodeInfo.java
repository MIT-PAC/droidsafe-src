package dalvik.bytecode;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class OpcodeInfo {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.203 -0400", hash_original_method = "A83DC80DE6B8698A045EDE141AC37084", hash_generated_method = "36AF5AEEB9531D085255128C80F8AD6C")
    @DSModeled(DSC.SAFE)
    private OpcodeInfo() {
        // ---------- Original Method ----------
    }

    
        public static boolean isInvoke(int packedOpcode) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    public static final int MAXIMUM_VALUE;
    public static final int MAXIMUM_PACKED_VALUE;
    static {
        MAXIMUM_VALUE = 65535;
        MAXIMUM_PACKED_VALUE = 511;
    }
    
}

