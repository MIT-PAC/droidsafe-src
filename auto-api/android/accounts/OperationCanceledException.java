package android.accounts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class OperationCanceledException extends AccountsException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.806 -0400", hash_original_method = "6A2CA580ECAC1CA80E08E40CC1DE7A0D", hash_generated_method = "5FBC7ED054974008E3508D207C4F8A0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OperationCanceledException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.807 -0400", hash_original_method = "30D3CCD84D44CE1156B1C66BFE82B5A0", hash_generated_method = "0997D46565BA9954E19960A864B5538D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OperationCanceledException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.808 -0400", hash_original_method = "35A2345D71CE64B12E61247F60F6496F", hash_generated_method = "3488A56CEAE54EE5D32F6881152BE78F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OperationCanceledException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.809 -0400", hash_original_method = "3CAB85560A3DC981F8F8AE7B1C1F36EB", hash_generated_method = "782370C18C675E809BEB2956F53A0CA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OperationCanceledException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}

