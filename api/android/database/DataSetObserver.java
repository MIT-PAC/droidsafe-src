package android.database;

// Droidsafe Imports
import droidsafe.annotations.*;




public abstract class DataSetObserver {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.191 -0400", hash_original_method = "3A00F9B2327C1F717FCC616343B02C33", hash_generated_method = "3A00F9B2327C1F717FCC616343B02C33")
    public DataSetObserver ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
	public void onChanged() {
        // Do nothing
    }

    
    @DSModeled(DSC.SAFE)
	public void onInvalidated() {
        // Do nothing
    }

    
}

