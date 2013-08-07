package android.webkit;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface ValueCallback<T> {
    
    public void onReceiveValue(T value);
}
