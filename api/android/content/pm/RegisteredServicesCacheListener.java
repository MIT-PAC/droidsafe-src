package android.content.pm;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface RegisteredServicesCacheListener<V> {
    
    void onServiceChanged(V type, boolean removed);
}
