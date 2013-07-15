package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class IllegalFormatPrecisionException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.635 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "ABEFDFA766F5A06D36323240A3BFC77D")

    private int p;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.635 -0400", hash_original_method = "1F9B0D4B155F0DC19F08720A34E7C4BD", hash_generated_method = "13646296FDF6AF63AF33B67CE5FD65FA")
    public  IllegalFormatPrecisionException(int p) {
        this.p = p;
        // ---------- Original Method ----------
        //this.p = p;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.636 -0400", hash_original_method = "B9EA1DC143DCBA676654F6DE1FED4BDB", hash_generated_method = "B554FA6AF0C84B400F0C93E23A2E6223")
    public int getPrecision() {
        int var83878C91171338902E0FE0FB97A8C47A_523758658 = (p);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_644475548 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_644475548;
        // ---------- Original Method ----------
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.636 -0400", hash_original_method = "5619344DED486463EA63A3A2966EBEEE", hash_generated_method = "DDA1D0B43BD92513702BBE76FF97DEE4")
    @Override
    public String getMessage() {
String var2DD27A8B880F1C661A65FBEF0C4C193D_394157996 =         Integer.toString(p);
        var2DD27A8B880F1C661A65FBEF0C4C193D_394157996.addTaint(taint);
        return var2DD27A8B880F1C661A65FBEF0C4C193D_394157996;
        // ---------- Original Method ----------
        //return Integer.toString(p);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.636 -0400", hash_original_field = "0F91C51332FA8F91A58DAD1F2729090F", hash_generated_field = "0F3B243090780E8B67BC9E9961E78D1C")

    private static final long serialVersionUID = 18711008L;
}

