package android.support.v4.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.681 -0400", hash_original_method = "072A1AE559281E061E9C91BC62D0E2B9", hash_generated_method = "072A1AE559281E061E9C91BC62D0E2B9")
    public ParcelableCompat ()
    {
        //Synthesized constructor
    }


        public static <T> Parcelable.Creator<T> newCreator(
            ParcelableCompatCreatorCallbacks<T> callbacks) {
        if (android.os.Build.VERSION.SDK_INT >= 13) {
            ParcelableCompatCreatorHoneycombMR2Stub.instantiate(callbacks);
        }
        return new CompatCreator<T>(callbacks);
    }

    
    static class CompatCreator<T> implements Parcelable.Creator<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.682 -0400", hash_original_field = "8DA114DA2B33B0EF1622BD0EE0F06E2B", hash_generated_field = "BE8C2310A42C4AF4CAB9F639C1E3BDCF")

        ParcelableCompatCreatorCallbacks<T> mCallbacks;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.682 -0400", hash_original_method = "89A37E66A919C0F4D6C87A6FE2ED98DC", hash_generated_method = "80CA192AA1E9F07F13E9C5A1CFD882FF")
        public  CompatCreator(ParcelableCompatCreatorCallbacks<T> callbacks) {
            mCallbacks = callbacks;
            // ---------- Original Method ----------
            //mCallbacks = callbacks;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.683 -0400", hash_original_method = "BC4263EA8B5E453C51CC1CF339ED2394", hash_generated_method = "4BDE8403198757C1EFBEA03D0A81258B")
        @Override
        public T createFromParcel(Parcel source) {
            T varB4EAC82CA7396A68D541C85D26508E83_537112385 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_537112385 = mCallbacks.createFromParcel(source, null);
            addTaint(source.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_537112385.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_537112385;
            // ---------- Original Method ----------
            //return mCallbacks.createFromParcel(source, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.693 -0400", hash_original_method = "5AB872DFD1AEB45ECC63ABABFF71FE11", hash_generated_method = "D11D28A93093FFDFBF4720DB20565BF9")
        @Override
        public T[] newArray(int size) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_1045671395 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1045671395 = mCallbacks.newArray(size);
            addTaint(size);
            varB4EAC82CA7396A68D541C85D26508E83_1045671395.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1045671395;
            // ---------- Original Method ----------
            //return mCallbacks.newArray(size);
        }

        
    }


    
}

