package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class DataSetObserver {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.191 -0400", hash_original_method = "3A00F9B2327C1F717FCC616343B02C33", hash_generated_method = "3A00F9B2327C1F717FCC616343B02C33")
    public DataSetObserver ()
    {
        //Synthesized constructor
    }
    /**
     * This method is called when the entire data set has changed,
     * most likely through a call to {@link Cursor#requery()} on a {@link Cursor}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.903 -0500", hash_original_method = "A2F6F8AC5E54A056ACCE252299447DF2", hash_generated_method = "B68AE7AC1051AD1BE35E2B91A6681200")
    
public void onChanged() {
        // Do nothing
    }

    /**
     * This method is called when the entire data becomes invalid,
     * most likely through a call to {@link Cursor#deactivate()} or {@link Cursor#close()} on a
     * {@link Cursor}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.905 -0500", hash_original_method = "721348118ADDD0A94842A07CCDAC8B4F", hash_generated_method = "B02317692B5E574F06A3B0D11A4B3739")
    
public void onInvalidated() {
        // Do nothing
    }
    
}

