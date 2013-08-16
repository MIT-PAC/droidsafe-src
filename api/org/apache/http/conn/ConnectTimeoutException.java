package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.InterruptedIOException;




public class ConnectTimeoutException extends InterruptedIOException {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.652 -0400", hash_original_method = "F05E8C7090F12D1341BCD22C7103FC0B", hash_generated_method = "40986EE17DC87DB632A880FBACB481A9")
    public  ConnectTimeoutException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.652 -0400", hash_original_method = "253E079134F8C2683EC310BD65E6492A", hash_generated_method = "8FCE924413115A5E8265B73232B002B9")
    public  ConnectTimeoutException(final String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.652 -0400", hash_original_field = "A8E9ADC0BBAD1CEB25A06496F9D009EA", hash_generated_field = "FFCC9C888252528507A7324B2271C230")

    private static final long serialVersionUID = -4816682903149535989L;
}

