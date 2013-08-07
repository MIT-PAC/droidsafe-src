package android.content;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface SyncStatusObserver {
    void onStatusChanged(int which);
}
