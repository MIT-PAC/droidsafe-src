package android.support.v4.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;

public interface ParcelableCompatCreatorCallbacks<T> {

    
    public T createFromParcel(Parcel in, ClassLoader loader);

    
    public T[] newArray(int size);
}
