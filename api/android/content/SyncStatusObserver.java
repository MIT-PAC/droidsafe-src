package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface SyncStatusObserver {
    void onStatusChanged(int which);
}
