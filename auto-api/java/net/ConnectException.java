package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class ConnectException extends SocketException {
    private static final long serialVersionUID = 3831404271622369215L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.174 -0400", hash_original_method = "E8FAEAA07CFA8C05C275809EB6A40178", hash_generated_method = "019DB1800DD11817B059B5BD2A8C3BDD")
    @DSModeled(DSC.SAFE)
    public ConnectException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.174 -0400", hash_original_method = "49125F9CA125EC7F4D4C7EADF3FA5E9C", hash_generated_method = "9BFDDB4F0F96FE5A8B2C4D8B713E707D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ConnectException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.174 -0400", hash_original_method = "4C12D3BC3A1875DEC95F9E2E6B90AD5C", hash_generated_method = "87939A6FFD684666A8FEF5526FC92FB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ConnectException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


