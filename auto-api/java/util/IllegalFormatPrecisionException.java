package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class IllegalFormatPrecisionException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.519 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "ABEFDFA766F5A06D36323240A3BFC77D")

    private int p;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.520 -0400", hash_original_method = "1F9B0D4B155F0DC19F08720A34E7C4BD", hash_generated_method = "13646296FDF6AF63AF33B67CE5FD65FA")
    public  IllegalFormatPrecisionException(int p) {
        this.p = p;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.521 -0400", hash_original_method = "B9EA1DC143DCBA676654F6DE1FED4BDB", hash_generated_method = "2F8A150B19B7AC9B264ACED44018F162")
    public int getPrecision() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1129345460 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1129345460;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.523 -0400", hash_original_method = "5619344DED486463EA63A3A2966EBEEE", hash_generated_method = "A723EC285A79B132A2976DAD66EA4830")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1426836696 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1426836696 = Integer.toString(p);
        varB4EAC82CA7396A68D541C85D26508E83_1426836696.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1426836696;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.523 -0400", hash_original_field = "0F91C51332FA8F91A58DAD1F2729090F", hash_generated_field = "0F3B243090780E8B67BC9E9961E78D1C")

    private static final long serialVersionUID = 18711008L;
}

