package android.os;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Parcelable {
    
    public static final int PARCELABLE_WRITE_RETURN_VALUE = 0x0001;
    
    
    public static final int CONTENTS_FILE_DESCRIPTOR = 0x0001;
    
    
    public int describeContents();
    
    
    public void writeToParcel(Parcel dest, int flags);

    
    public interface Creator<T> {
        
        public T createFromParcel(Parcel source);
        
        
        public T[] newArray(int size);
    }

    
    public interface ClassLoaderCreator<T> extends Creator<T> {
        
        public T createFromParcel(Parcel source, ClassLoader loader);
    }
}
