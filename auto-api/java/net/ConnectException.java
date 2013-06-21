package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ConnectException extends SocketException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.747 -0400", hash_original_method = "E8FAEAA07CFA8C05C275809EB6A40178", hash_generated_method = "7F69AFAC4E3662D5B99297EBEC8BAE4F")
    @DSModeled(DSC.SAFE)
    public ConnectException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.747 -0400", hash_original_method = "49125F9CA125EC7F4D4C7EADF3FA5E9C", hash_generated_method = "4D0C9BC4C562335A63E5057BCEDB0778")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ConnectException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.747 -0400", hash_original_method = "4C12D3BC3A1875DEC95F9E2E6B90AD5C", hash_generated_method = "0C37A06ED58A868F8DFD8CF4A6259311")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ConnectException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 3831404271622369215L;
}

