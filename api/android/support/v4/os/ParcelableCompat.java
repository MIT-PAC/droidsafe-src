package android.support.v4.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.475 -0400", hash_original_method = "072A1AE559281E061E9C91BC62D0E2B9", hash_generated_method = "072A1AE559281E061E9C91BC62D0E2B9")
    public ParcelableCompat ()
    {
        //Synthesized constructor
    }


        public static <T> Parcelable.Creator<T> newCreator(
            ParcelableCompatCreatorCallbacks<T> callbacks) {
        return new CompatCreator<T>(callbacks);
    }

    
    static class CompatCreator<T> implements Parcelable.Creator<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.476 -0400", hash_original_field = "8DA114DA2B33B0EF1622BD0EE0F06E2B", hash_generated_field = "BE8C2310A42C4AF4CAB9F639C1E3BDCF")

        ParcelableCompatCreatorCallbacks<T> mCallbacks;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.476 -0400", hash_original_method = "89A37E66A919C0F4D6C87A6FE2ED98DC", hash_generated_method = "80CA192AA1E9F07F13E9C5A1CFD882FF")
        public  CompatCreator(ParcelableCompatCreatorCallbacks<T> callbacks) {
            mCallbacks = callbacks;
            // ---------- Original Method ----------
            //mCallbacks = callbacks;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.476 -0400", hash_original_method = "BC4263EA8B5E453C51CC1CF339ED2394", hash_generated_method = "882E72DD926F7EF2EC01D84D830943C6")
        @Override
        public T createFromParcel(Parcel source) {
            addTaint(source.getTaint());
T var25D98B315EBA03ECC7F6F53097856CE3_285144324 =             mCallbacks.createFromParcel(source, null);
            var25D98B315EBA03ECC7F6F53097856CE3_285144324.addTaint(taint);
            return var25D98B315EBA03ECC7F6F53097856CE3_285144324;
            // ---------- Original Method ----------
            //return mCallbacks.createFromParcel(source, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.476 -0400", hash_original_method = "5AB872DFD1AEB45ECC63ABABFF71FE11", hash_generated_method = "888C38BEBAFB415004BF877377958C5F")
        @Override
        public T[] newArray(int size) {
            addTaint(size);
T[] var656003BC8B102ED1F977FF7902F94727_1455050949 =             mCallbacks.newArray(size);
            var656003BC8B102ED1F977FF7902F94727_1455050949.addTaint(taint);
            return var656003BC8B102ED1F977FF7902F94727_1455050949;
            // ---------- Original Method ----------
            //return mCallbacks.newArray(size);
        }

        
    }


    
}

