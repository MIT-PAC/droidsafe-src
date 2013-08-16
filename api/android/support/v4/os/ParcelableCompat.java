package android.support.v4.os;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;





public class ParcelableCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.015 -0400", hash_original_method = "072A1AE559281E061E9C91BC62D0E2B9", hash_generated_method = "072A1AE559281E061E9C91BC62D0E2B9")
    public ParcelableCompat ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public static <T> Parcelable.Creator<T> newCreator(
            ParcelableCompatCreatorCallbacks<T> callbacks) {
        return new CompatCreator<T>(callbacks);
    }

    
    static class CompatCreator<T> implements Parcelable.Creator<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.016 -0400", hash_original_field = "8DA114DA2B33B0EF1622BD0EE0F06E2B", hash_generated_field = "BE8C2310A42C4AF4CAB9F639C1E3BDCF")

        ParcelableCompatCreatorCallbacks<T> mCallbacks;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.016 -0400", hash_original_method = "89A37E66A919C0F4D6C87A6FE2ED98DC", hash_generated_method = "80CA192AA1E9F07F13E9C5A1CFD882FF")
        public  CompatCreator(ParcelableCompatCreatorCallbacks<T> callbacks) {
            mCallbacks = callbacks;
            // ---------- Original Method ----------
            //mCallbacks = callbacks;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.017 -0400", hash_original_method = "BC4263EA8B5E453C51CC1CF339ED2394", hash_generated_method = "E8FFB7789BFE4DDB9F7520E0C3FC4DAD")
        @Override
        public T createFromParcel(Parcel source) {
            addTaint(source.getTaint());
T var25D98B315EBA03ECC7F6F53097856CE3_1337786186 =             mCallbacks.createFromParcel(source, null);
            var25D98B315EBA03ECC7F6F53097856CE3_1337786186.addTaint(taint);
            return var25D98B315EBA03ECC7F6F53097856CE3_1337786186;
            // ---------- Original Method ----------
            //return mCallbacks.createFromParcel(source, null);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.017 -0400", hash_original_method = "5AB872DFD1AEB45ECC63ABABFF71FE11", hash_generated_method = "9BBB780EE7158E72AE5D48429012389B")
        @Override
        public T[] newArray(int size) {
            addTaint(size);
T[] var656003BC8B102ED1F977FF7902F94727_335534174 =             mCallbacks.newArray(size);
            var656003BC8B102ED1F977FF7902F94727_335534174.addTaint(taint);
            return var656003BC8B102ED1F977FF7902F94727_335534174;
            // ---------- Original Method ----------
            //return mCallbacks.newArray(size);
        }

        
    }


    
}

