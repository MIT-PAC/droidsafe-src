package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ValueCallback<T> {
    
    public void onReceiveValue(T value);
}
