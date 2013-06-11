package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class SQLiteDiskIOException extends SQLiteException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.818 -0400", hash_original_method = "79812D0F211F1884E30281CBD1527413", hash_generated_method = "0D206B4CCD27E36AB65FC1F20871891B")
    @DSModeled(DSC.SAFE)
    public SQLiteDiskIOException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.818 -0400", hash_original_method = "AEB9A3DB63CF2E99DCD9A5A0555BEBB3", hash_generated_method = "3DD4DAF288C9E10CD483922D3C2C4472")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SQLiteDiskIOException(String error) {
        super(error);
        dsTaint.addTaint(error);
        // ---------- Original Method ----------
    }

    
}


