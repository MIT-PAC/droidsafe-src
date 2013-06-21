package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcelable;

public interface RegisteredServicesCacheListener<V> {
    
    void onServiceChanged(V type, boolean removed);
}
