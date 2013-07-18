package android.support.v4.os;

// Droidsafe Imports
import android.os.Parcel;

public interface ParcelableCompatCreatorCallbacks<T> {

    
    public T createFromParcel(Parcel in, ClassLoader loader);

    
    public T[] newArray(int size);
}
