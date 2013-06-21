package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.UnknownHostException;
import libcore.io.OsConstants;

public final class GaiException extends RuntimeException {
    private String functionName;
    public int error;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.892 -0400", hash_original_method = "BA53EB307FD31FC241DD4C6044D04AD1", hash_generated_method = "D7173393D71287646BA029CD05625098")
    @DSModeled(DSC.SAFE)
    public GaiException(String functionName, int error) {
        dsTaint.addTaint(error);
        dsTaint.addTaint(functionName);
        // ---------- Original Method ----------
        //this.functionName = functionName;
        //this.error = error;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.892 -0400", hash_original_method = "845DC588FB53DD48B2B7818DC3F43C36", hash_generated_method = "90C8F7C26AB464E2604BBA7AB707271D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.892 -0400", hash_original_method = "6B923BF9D17AE00E606BE15037C1D30D", hash_generated_method = "ABC8852FAB2352FFCA7067BED48E864E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.892 -0400", hash_original_method = "5B589888D552552C8BEA12CEE384825F", hash_generated_method = "DD6A68BC5711A0752025BF60BB7692E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnknownHostException rethrowAsUnknownHostException(String detailMessage) throws UnknownHostException {
        dsTaint.addTaint(detailMessage);
        UnknownHostException newException;
        newException = new UnknownHostException(detailMessage);
        newException.initCause(this);
        if (DroidSafeAndroidRuntime.control) throw newException;
        return (UnknownHostException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //UnknownHostException newException = new UnknownHostException(detailMessage);
        //newException.initCause(this);
        //throw newException;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.893 -0400", hash_original_method = "81B83C8D72DB912D679B4B84F9977C22", hash_generated_method = "694902AA8702CBE50EA8C44CCC1E533A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnknownHostException rethrowAsUnknownHostException() throws UnknownHostException {
        if (DroidSafeAndroidRuntime.control) throw rethrowAsUnknownHostException(getMessage());
        return (UnknownHostException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw rethrowAsUnknownHostException(getMessage());
    }

    
}

