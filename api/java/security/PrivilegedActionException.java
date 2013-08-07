package java.security;

// Droidsafe Imports
import droidsafe.annotations.*;





public class PrivilegedActionException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.139 -0400", hash_original_method = "EDD6A4125897553733853A01EFA0A0B7", hash_generated_method = "AF1093C48D4324A2D9FF70091893DC5F")
    public  PrivilegedActionException(Exception ex) {
        super(ex);
        addTaint(ex.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.140 -0400", hash_original_method = "96C5131DB95D0ADB8B79CD396371D505", hash_generated_method = "9BCFC942A43F860FA667090529CCE511")
    public Exception getException() {
Exception var540C13E9E156B687226421B24F2DF178_1464731994 =         null;
        var540C13E9E156B687226421B24F2DF178_1464731994.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1464731994;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.140 -0400", hash_original_field = "C6EE766F2D182B1AF374A82150C8909C", hash_generated_field = "5A2756170436A968A38DABC1A0F1BBB0")

    private static final long serialVersionUID = 4724086851538908602l;
}

