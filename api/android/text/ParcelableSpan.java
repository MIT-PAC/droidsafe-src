package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcelable;

public interface ParcelableSpan extends Parcelable {
    
    public abstract int getSpanTypeId();
}
