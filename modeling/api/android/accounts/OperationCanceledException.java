package android.accounts;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class OperationCanceledException extends AccountsException {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.290 -0500", hash_original_method = "6A2CA580ECAC1CA80E08E40CC1DE7A0D", hash_generated_method = "A40F15B3B7DFA9AB54B260A15C95FE76")
    
public OperationCanceledException() {
        super();
    }
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.293 -0500", hash_original_method = "30D3CCD84D44CE1156B1C66BFE82B5A0", hash_generated_method = "2C389CB60F9CDF5F4F318A704601F482")
    
public OperationCanceledException(String message) {
        super(message);
    }
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.295 -0500", hash_original_method = "35A2345D71CE64B12E61247F60F6496F", hash_generated_method = "D8A15397BE92D27F2F065626B272E2FE")
    
public OperationCanceledException(String message, Throwable cause) {
        super(message, cause);
    }
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:47.298 -0500", hash_original_method = "3CAB85560A3DC981F8F8AE7B1C1F36EB", hash_generated_method = "2DB0ABFAB328BBBBBD4039132513E61F")
    
public OperationCanceledException(Throwable cause) {
        super(cause);
    }
    
}

