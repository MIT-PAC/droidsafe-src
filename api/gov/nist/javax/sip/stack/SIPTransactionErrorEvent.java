package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.EventObject;






public class SIPTransactionErrorEvent extends EventObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:00.762 -0500", hash_original_field = "FD1319701F9D8B3BF382F89AD1C3FFBE", hash_generated_field = "B2919CC93A0DDB9603DD498A1339A398")

    private static final long serialVersionUID = -2713188471978065031L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:00.763 -0500", hash_original_field = "3B246B0FE69C1F9FF7A41D322CD83D0D", hash_generated_field = "2268C740E02F829208E590448FE29A7C")

    public static final int TIMEOUT_ERROR = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:00.764 -0500", hash_original_field = "B4E0B56673B5399AA84687A35593A1A5", hash_generated_field = "4EC86D2082266147845EB0873FB756F7")

    public static final int TRANSPORT_ERROR = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:00.765 -0500", hash_original_field = "61523AD84289E6AB4C5E64C9CC913BF6", hash_generated_field = "50927BA19A1A6CDE61F8F90E1139E7C4")

    public static final int TIMEOUT_RETRANSMIT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:00.766 -0500", hash_original_field = "81675DDDE65D7DC6276492A670BE8C2A", hash_generated_field = "CA6E243727AC764060BF1536B58E325A")

    private int errorID;

    /**
     * Creates a transaction error event.
     *
     * @param sourceTransaction Transaction which is raising the error.
     * @param transactionErrorID ID of the error that has ocurred.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:00.767 -0500", hash_original_method = "09AF95BC0271C57553075E85B6A27865", hash_generated_method = "09AF95BC0271C57553075E85B6A27865")
    SIPTransactionErrorEvent(
        SIPTransaction sourceTransaction,
        int transactionErrorID) {

        super(sourceTransaction);
        errorID = transactionErrorID;

    }

    /**
     * Returns the ID of the error.
     *
     * @return Error ID.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:00.768 -0500", hash_original_method = "0519EBFB6DA70B425C38921D23DA7A64", hash_generated_method = "0BB790A9247F5D0375A01CAD9294AADA")
    public int getErrorID() {
        return errorID;
    }
}

