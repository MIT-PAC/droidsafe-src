package android.os.storage;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




public abstract class StorageEventListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.025 -0400", hash_original_method = "61076BC963620255AB850D9EEFFDEDA8", hash_generated_method = "61076BC963620255AB850D9EEFFDEDA8")
    public StorageEventListener ()
    {
        //Synthesized constructor
    }
    /**
     * Called when the detection state of a USB Mass Storage host has changed.
     * @param connected true if the USB mass storage is connected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:39.195 -0500", hash_original_method = "08B6588D85EC619CC2E0611C0812F3DA", hash_generated_method = "C90550FE6E97011D369405A6A248602A")
    public void onUsbMassStorageConnectionChanged(boolean connected) {
    }

    /**
     * Called when storage has changed state
     * @param path the filesystem path for the storage
     * @param oldState the old state as returned by {@link android.os.Environment#getExternalStorageState()}.
     * @param newState the old state as returned by {@link android.os.Environment#getExternalStorageState()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:39.196 -0500", hash_original_method = "B80645FD27258B59A3B650E166B00E17", hash_generated_method = "A5B61089733833334EA5476745C29883")
    public void onStorageStateChanged(String path, String oldState, String newState) {
    }

    
}

