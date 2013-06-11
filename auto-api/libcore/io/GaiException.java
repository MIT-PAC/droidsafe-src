package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.net.UnknownHostException;
import libcore.io.OsConstants;

public final class GaiException extends RuntimeException {
    private final String functionName;
    public final int error;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.433 -0400", hash_original_method = "BA53EB307FD31FC241DD4C6044D04AD1", hash_generated_method = "5CACD82D341729C649E693D283B29D57")
    @DSModeled(DSC.SAFE)
    public GaiException(String functionName, int error) {
        dsTaint.addTaint(error);
        dsTaint.addTaint(functionName);
        // ---------- Original Method ----------
        //this.functionName = functionName;
        //this.error = error;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.433 -0400", hash_original_method = "845DC588FB53DD48B2B7818DC3F43C36", hash_generated_method = "BA93C2853E95FE3256F39E5BA2F6F31D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GaiException(String functionName, int error, Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(error);
        dsTaint.addTaint(functionName);
        // ---------- Original Method ----------
        //this.functionName = functionName;
        //this.error = error;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.433 -0400", hash_original_method = "6B923BF9D17AE00E606BE15037C1D30D", hash_generated_method = "625164E37139736D38C4A92215D8AC3D")
    @DSModeled(DSC.SAFE)
    @Override
    public String getMessage() {
        String gaiName;
        gaiName = OsConstants.gaiName(error);
        {
            gaiName = "GAI_ error " + error;
        } //End block
        String description;
        description = Libcore.os.gai_strerror(error);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String gaiName = OsConstants.gaiName(error);
        //if (gaiName == null) {
            //gaiName = "GAI_ error " + error;
        //}
        //String description = Libcore.os.gai_strerror(error);
        //return functionName + " failed: " + gaiName + " (" + description + ")";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.433 -0400", hash_original_method = "5B589888D552552C8BEA12CEE384825F", hash_generated_method = "3E85D8CEBBA7B754FCDD2EF8A55062E3")
    @DSModeled(DSC.SAFE)
    public UnknownHostException rethrowAsUnknownHostException(String detailMessage) throws UnknownHostException {
        dsTaint.addTaint(detailMessage);
        UnknownHostException newException;
        newException = new UnknownHostException(detailMessage);
        newException.initCause(this);
        throw newException;
        return (UnknownHostException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //UnknownHostException newException = new UnknownHostException(detailMessage);
        //newException.initCause(this);
        //throw newException;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.433 -0400", hash_original_method = "81B83C8D72DB912D679B4B84F9977C22", hash_generated_method = "3FD36E1132B94743087BD7512E8854E1")
    @DSModeled(DSC.SAFE)
    public UnknownHostException rethrowAsUnknownHostException() throws UnknownHostException {
        throw rethrowAsUnknownHostException(getMessage());
        return (UnknownHostException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw rethrowAsUnknownHostException(getMessage());
    }

    
}


