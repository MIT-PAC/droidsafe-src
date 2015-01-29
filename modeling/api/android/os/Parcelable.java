package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Parcelable {
    
    public static final int PARCELABLE_WRITE_RETURN_VALUE = 0x0001;
    
    public static final int CONTENTS_FILE_DESCRIPTOR = 0x0001;
    
    public int describeContents();

    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void writeToParcel(Parcel dest, int flags);
    
    public interface Creator<T> {
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
        public T createFromParcel(Parcel source);
        
        @DSVerified
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public T[] newArray(int size);
    }
    
    public interface ClassLoaderCreator<T> extends Creator<T> {
        @DSVerified
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public T createFromParcel(Parcel source, ClassLoader loader);
    }
}
