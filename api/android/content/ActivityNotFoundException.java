package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ActivityNotFoundException extends RuntimeException {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.013 -0500", hash_original_method = "56CBB1B0D6656A7AA127BFCDE1D30401", hash_generated_method = "721DDD8138BF6E1E9799435E0D2751E0")
    
public ActivityNotFoundException()
    {
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.016 -0500", hash_original_method = "8587D789BC6C40698A73B5C613EDE1A6", hash_generated_method = "9BFBA45CE2E8EE4E0C78E1AB193A4B54")
    
public ActivityNotFoundException(String name)
    {
        super(name);
    }
    
}

