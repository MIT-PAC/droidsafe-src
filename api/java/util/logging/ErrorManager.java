package java.util.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ErrorManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.047 -0400", hash_original_field = "4F33252742282F871B0617168156FD55", hash_generated_field = "73DCA3E62AD96D31516E07B7942B98AB")

    private boolean called;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.047 -0400", hash_original_method = "F8543B5AF6CB4B42529104ECFDE08620", hash_generated_method = "4CBB7C3EF85E54BBF4EC847A9E1DDCAF")
    public  ErrorManager() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.047 -0400", hash_original_method = "88D78C1D6CF19D14D0670D7F86679469", hash_generated_method = "CAF7317F7B9A37C7951787C25FA8FEFB")
    public void error(String message, Exception exception, int errorCode) {
        addTaint(errorCode);
        addTaint(exception.getTaint());
        addTaint(message.getTaint());
        synchronized
(this)        {
    if(called)            
            {
                return;
            } //End block
            called = true;
        } //End block
        System.err.println(this.getClass().getName() + ": " + FAILURES[errorCode]);
    if(message != null)        
        {
            System.err.println("Error message - " + message);
        } //End block
    if(exception != null)        
        {
            System.err.println("Exception - " + exception);
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (called) {
                //return;
            //}
            //called = true;
        //}
        //System.err.println(this.getClass().getName() + ": " + FAILURES[errorCode]);
        //if (message != null) {
            //System.err.println("Error message - " + message);
        //}
        //if (exception != null) {
            //System.err.println("Exception - " + exception);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.048 -0400", hash_original_field = "AABC5E795A58B02CDB88E81E97CF9D6A", hash_generated_field = "464AF05E9A04A362279DE255D6605961")

    public static final int GENERIC_FAILURE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.048 -0400", hash_original_field = "D5A5C7342634D91FAA2D477C7B633AD9", hash_generated_field = "F22CE731DA3FD6989075E327EBB7330E")

    public static final int WRITE_FAILURE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.048 -0400", hash_original_field = "DB8CBFEBD68B9A82832E3C143A7F70E9", hash_generated_field = "EF0BDEF760F9D938BB7D5F653F1FE2A6")

    public static final int FLUSH_FAILURE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.048 -0400", hash_original_field = "2DFEA8E6BA2039DFB34B71EDC485933C", hash_generated_field = "4215BE491DE9753FD343B62B11D1C557")

    public static final int CLOSE_FAILURE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.048 -0400", hash_original_field = "BFF3FEF76B208B623D8DB42688AA11A0", hash_generated_field = "04A4D244CC1991C29A7BD7797236C553")

    public static final int OPEN_FAILURE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.048 -0400", hash_original_field = "F7D5A310AD9E6AA9808B8901EFC7D7DB", hash_generated_field = "D833583B3DBBAB508B3949722BE36E0B")

    public static final int FORMAT_FAILURE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.048 -0400", hash_original_field = "D7DE785FBB1FE1687F2FF2ACEB6674A3", hash_generated_field = "BD39D7396A9D2741C80F65787B65559D")

    private static final String[] FAILURES = new String[] { "GENERIC_FAILURE",
            "WRITE_FAILURE", "FLUSH_FAILURE", "CLOSE_FAILURE", "OPEN_FAILURE",
            "FORMAT_FAILURE" };
}

