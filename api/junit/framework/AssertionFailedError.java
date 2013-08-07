package junit.framework;

// Droidsafe Imports
import droidsafe.annotations.*;




public class AssertionFailedError extends Error {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.212 -0400", hash_original_method = "71F257E86E7BC4683CC6DEDD211B2B80", hash_generated_method = "CA362C55EDDF9D2AF60C14AF4873ACCA")
    public  AssertionFailedError() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.212 -0400", hash_original_method = "B8BE23DBCDF9422A0C250D37CF195D42", hash_generated_method = "A461FAA9C54EAE2F63E70B22E161CFD8")
    public  AssertionFailedError(String message) {
        super (message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
}

