package android.content.pm;

// Droidsafe Imports

public interface RegisteredServicesCacheListener<V> {
    
    void onServiceChanged(V type, boolean removed);
}
