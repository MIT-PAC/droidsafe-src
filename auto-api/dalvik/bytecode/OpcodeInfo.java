package dalvik.bytecode;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class OpcodeInfo {
    public static final int MAXIMUM_VALUE;
    public static final int MAXIMUM_PACKED_VALUE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.317 -0400", hash_original_method = "A83DC80DE6B8698A045EDE141AC37084", hash_generated_method = "94D7AFC251129D25EBE634B95F08FDAE")
    @DSModeled(DSC.SAFE)
    private OpcodeInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.317 -0400", hash_original_method = "CC27A78086A4454B067DC102AC631D4B", hash_generated_method = "62B4EA631E8F600149CD08173508D62B")
    public static boolean isInvoke(int packedOpcode) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    static {
        MAXIMUM_VALUE = 65535;
        MAXIMUM_PACKED_VALUE = 511;
    }
    
}


