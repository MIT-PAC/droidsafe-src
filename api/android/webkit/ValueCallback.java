package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface ValueCallback<T> {
    
    public void onReceiveValue(T value);
}
