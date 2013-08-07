package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;





public class IllegalFormatPrecisionException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.509 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "ABEFDFA766F5A06D36323240A3BFC77D")

    private int p;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.510 -0400", hash_original_method = "1F9B0D4B155F0DC19F08720A34E7C4BD", hash_generated_method = "13646296FDF6AF63AF33B67CE5FD65FA")
    public  IllegalFormatPrecisionException(int p) {
        this.p = p;
        // ---------- Original Method ----------
        //this.p = p;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.510 -0400", hash_original_method = "B9EA1DC143DCBA676654F6DE1FED4BDB", hash_generated_method = "A3ECF6D8D53AF58F21651AF340FDF2FC")
    public int getPrecision() {
        int var83878C91171338902E0FE0FB97A8C47A_1547391624 = (p);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_36568856 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_36568856;
        // ---------- Original Method ----------
        //return p;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.510 -0400", hash_original_method = "5619344DED486463EA63A3A2966EBEEE", hash_generated_method = "20D760D342EE390B5B1508A8D54BC129")
    @Override
    public String getMessage() {
String var2DD27A8B880F1C661A65FBEF0C4C193D_1984243399 =         Integer.toString(p);
        var2DD27A8B880F1C661A65FBEF0C4C193D_1984243399.addTaint(taint);
        return var2DD27A8B880F1C661A65FBEF0C4C193D_1984243399;
        // ---------- Original Method ----------
        //return Integer.toString(p);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.511 -0400", hash_original_field = "0F91C51332FA8F91A58DAD1F2729090F", hash_generated_field = "0F3B243090780E8B67BC9E9961E78D1C")

    private static final long serialVersionUID = 18711008L;
}

