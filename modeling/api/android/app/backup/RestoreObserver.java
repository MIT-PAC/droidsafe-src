package android.app.backup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class RestoreObserver {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.533 -0400", hash_original_method = "F9D1A298B1697AD74387E190133C441C", hash_generated_method = "F9D1A298B1697AD74387E190133C441C")
    public RestoreObserver ()
    {
        //Synthesized constructor
    }
    /**
     * Supply a list of the restore datasets available from the current transport.  This
     * method is invoked as a callback following the application's use of the
     * {@link android.app.backup.IRestoreSession.getAvailableRestoreSets} method.
     *
     * @param result An array of {@link android.app.backup.RestoreSet RestoreSet} objects
     *   describing all of the available datasets that are candidates for restoring to
     *   the current device.  If no applicable datasets exist, {@code result} will be
     *   {@code null}.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.789 -0500", hash_original_method = "668807DC740187B04A6B6A3F86625C1D", hash_generated_method = "50E8C0AE1BDE3A8B54D39CA390CC1EA2")
    
public void restoreSetsAvailable(RestoreSet[] result) {
    }

    /**
     * The restore operation has begun.
     *
     * @param numPackages The total number of packages being processed in
     *   this restore operation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.792 -0500", hash_original_method = "DBB8890F5DB9136F39685677B4F1E581", hash_generated_method = "8B2B1B699F3BC76DC163AE27183AC7E8")
    
public void restoreStarting(int numPackages) {
    }

    /**
     * An indication of which package is being restored currently, out of the
     * total number provided in the {@link #restoreStarting(int)} callback.  This method
     * is not guaranteed to be called: if the transport is unable to obtain
     * data for one or more of the requested packages, no onUpdate() call will
     * occur for those packages.
     *
     * @param nowBeingRestored The index, between 1 and the numPackages parameter
     *   to the {@link #restoreStarting(int)} callback, of the package now being
     *   restored.  This may be non-monotonic; it is intended purely as a rough
     *   indication of the backup manager's progress through the overall restore process.
     * @param currentPackage The name of the package now being restored.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.794 -0500", hash_original_method = "0D7718CD7EB4ACA6FF6B636456D0E82A", hash_generated_method = "5F1091FB9DD136AFA3C0542BB3A9646B")
    
public void onUpdate(int nowBeingRestored, String currentPackage) {
    }

    /**
     * The restore process has completed.  This method will always be called,
     * even if no individual package restore operations were attempted.
     *
     * @param error Zero on success; a nonzero error code if the restore operation
     *   as a whole failed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.796 -0500", hash_original_method = "0756746AA6CF68909818DDB3CD0E35A6", hash_generated_method = "012518DF28A847B89A0EC7757AC5802D")
    
public void restoreFinished(int error) {
    }
    
}

