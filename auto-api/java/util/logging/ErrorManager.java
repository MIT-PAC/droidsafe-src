package java.util.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ErrorManager {
    private boolean called;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.405 -0400", hash_original_method = "F8543B5AF6CB4B42529104ECFDE08620", hash_generated_method = "4CBB7C3EF85E54BBF4EC847A9E1DDCAF")
    @DSModeled(DSC.SAFE)
    public ErrorManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.405 -0400", hash_original_method = "88D78C1D6CF19D14D0670D7F86679469", hash_generated_method = "B31A4833D9C65C3DCB2A98396E2198B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void error(String message, Exception exception, int errorCode) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(exception.dsTaint);
        dsTaint.addTaint(errorCode);
        {
            called = true;
        } //End block
        System.err.println(this.getClass().getName() + ": " + FAILURES[errorCode]);
        {
            System.err.println("Error message - " + message);
        } //End block
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

    
    public static final int GENERIC_FAILURE = 0;
    public static final int WRITE_FAILURE = 1;
    public static final int FLUSH_FAILURE = 2;
    public static final int CLOSE_FAILURE = 3;
    public static final int OPEN_FAILURE = 4;
    public static final int FORMAT_FAILURE = 5;
    private static final String[] FAILURES = new String[] { "GENERIC_FAILURE",
            "WRITE_FAILURE", "FLUSH_FAILURE", "CLOSE_FAILURE", "OPEN_FAILURE",
            "FORMAT_FAILURE" };
}

