package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class StaleDataException extends java.lang.RuntimeException {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.021 -0500", hash_original_method = "0B77138B0532969AEB67E7DB9731EFEE", hash_generated_method = "EF2055586C9BDE6B788A17B51CBB63F4")
    
public StaleDataException()
    {
        super();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.024 -0500", hash_original_method = "4D539F55BE24816442AFE115AFCF4654", hash_generated_method = "D0AB282F5D79A15199031E488EC273ED")
    
public StaleDataException(String description)
    {
        super(description);
    }
    
}

