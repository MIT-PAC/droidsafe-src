package android.content.pm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcelable;

public interface RegisteredServicesCacheListener<V> {
    
    void onServiceChanged(V type, boolean removed);
}
