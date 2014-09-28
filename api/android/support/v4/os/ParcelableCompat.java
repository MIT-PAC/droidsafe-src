package android.support.v4.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableCompat {
    
    @DSSafe(DSCat.SAFE_LIST)
    public static <T> Parcelable.Creator<T> newCreator(
            ParcelableCompatCreatorCallbacks<T> callbacks) {
        return new CompatCreator<T>(callbacks);
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.015 -0400", hash_original_method = "072A1AE559281E061E9C91BC62D0E2B9", hash_generated_method = "072A1AE559281E061E9C91BC62D0E2B9")
    public ParcelableCompat ()
    {
        //Synthesized constructor
    }
    
    static class CompatCreator<T> implements Parcelable.Creator<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.615 -0500", hash_original_field = "BE8C2310A42C4AF4CAB9F639C1E3BDCF", hash_generated_field = "BE8C2310A42C4AF4CAB9F639C1E3BDCF")

         ParcelableCompatCreatorCallbacks<T> mCallbacks;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.617 -0500", hash_original_method = "89A37E66A919C0F4D6C87A6FE2ED98DC", hash_generated_method = "D88771461059AFB898DEF1ADA74E7B50")
        
public CompatCreator(ParcelableCompatCreatorCallbacks<T> callbacks) {
            mCallbacks = callbacks;
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.620 -0500", hash_original_method = "BC4263EA8B5E453C51CC1CF339ED2394", hash_generated_method = "4EA354AA332798A65F22A475A247ABD1")
        
@Override
        public T createFromParcel(Parcel source) {
            return mCallbacks.createFromParcel(source, null);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.623 -0500", hash_original_method = "5AB872DFD1AEB45ECC63ABABFF71FE11", hash_generated_method = "1B909DEC21427718B5B3E4E5F7397BE3")
        
@Override
        public T[] newArray(int size) {
            return mCallbacks.newArray(size);
        }
        
    }
    
}

