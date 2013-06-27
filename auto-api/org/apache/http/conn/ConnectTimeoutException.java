package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.InterruptedIOException;

public class ConnectTimeoutException extends InterruptedIOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.163 -0400", hash_original_method = "F05E8C7090F12D1341BCD22C7103FC0B", hash_generated_method = "40986EE17DC87DB632A880FBACB481A9")
    public  ConnectTimeoutException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.164 -0400", hash_original_method = "253E079134F8C2683EC310BD65E6492A", hash_generated_method = "8FCE924413115A5E8265B73232B002B9")
    public  ConnectTimeoutException(final String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.164 -0400", hash_original_field = "A8E9ADC0BBAD1CEB25A06496F9D009EA", hash_generated_field = "CC967C249BA60E5DF7ED8351DD351A95")

    private static long serialVersionUID = -4816682903149535989L;
}

