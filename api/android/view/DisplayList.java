package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class DisplayList {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.539 -0400", hash_original_method = "D56C6AFD01D3460D9F9028A561421FB3", hash_generated_method = "D56C6AFD01D3460D9F9028A561421FB3")
    public DisplayList ()
    {
        //Synthesized constructor
    }
    /**
     * Starts recording the display list. All operations performed on the
     * returned canvas are recorded and stored in this display list.
     * 
     * @return A canvas to record drawing operations.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.559 -0500", hash_original_method = "D526BF69CCF530275DBEC9F2A0A3F377", hash_generated_method = "760872A4A8B75E1DC86DCDD2DC7B47DF")
    
abstract HardwareCanvas start();

    /**
     * Ends the recording for this display list. A display list cannot be
     * replayed if recording is not finished. 
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.561 -0500", hash_original_method = "583631727C11157A7FEE45984D266C4A", hash_generated_method = "C342A22E5938FE2C44103609AB1EFE6A")
    
abstract void end();

    /**
     * Invalidates the display list, indicating that it should be repopulated
     * with new drawing commands prior to being used again. Calling this method
     * causes calls to {@link #isValid()} to return <code>false</code>.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.564 -0500", hash_original_method = "70F593FC630C0533FD7D3758F8C5CFA1", hash_generated_method = "A2AB601B5E113183610364E6AD62E17E")
    
abstract void invalidate();

    /**
     * Returns whether the display list is currently usable. If this returns false,
     * the display list should be re-recorded prior to replaying it.
     *
     * @return boolean true if the display list is able to be replayed, false otherwise.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.566 -0500", hash_original_method = "F1240C06AF1BA9E648B2E780B8155F1C", hash_generated_method = "DAA5FB924C73E71617DA3BC7565C7DD2")
    
abstract boolean isValid();

    /**
     * Return the amount of memory used by this display list.
     * 
     * @return The size of this display list in bytes
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.569 -0500", hash_original_method = "3BD1DDA083E1834B11B53D240ECE8ED6", hash_generated_method = "4D630537E9E41BBAB1F1D3F8C6B53DAD")
    
abstract int getSize();
    
}

