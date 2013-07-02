package android.support.v4.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public interface ParcelableCompatCreatorCallbacks<T> {

    
    public T createFromParcel(Parcel in, ClassLoader loader);

    
    public T[] newArray(int size);
}
