package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.database.SQLException;

public class SQLiteException extends SQLException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.819 -0400", hash_original_method = "C0EDC6814EAFE55CC8FBE8FC40236BE6", hash_generated_method = "4C2209A85D5CC7A5579506631F241F73")
    @DSModeled(DSC.SAFE)
    public SQLiteException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.819 -0400", hash_original_method = "0C0BEBB87E389634BC41A00A87165715", hash_generated_method = "84A3F5FD20B4E7E6B3EF69387ED1CCF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SQLiteException(String error) {
        super(error);
        dsTaint.addTaint(error);
        // ---------- Original Method ----------
    }

    
}


