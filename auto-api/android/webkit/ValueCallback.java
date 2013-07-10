package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface ValueCallback<T> {
    
    public void onReceiveValue(T value);
}
