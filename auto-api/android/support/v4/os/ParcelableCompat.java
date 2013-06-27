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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.306 -0400", hash_original_method = "072A1AE559281E061E9C91BC62D0E2B9", hash_generated_method = "072A1AE559281E061E9C91BC62D0E2B9")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.307 -0400", hash_original_field = "8DA114DA2B33B0EF1622BD0EE0F06E2B", hash_generated_field = "BE8C2310A42C4AF4CAB9F639C1E3BDCF")

        ParcelableCompatCreatorCallbacks<T> mCallbacks;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.308 -0400", hash_original_method = "89A37E66A919C0F4D6C87A6FE2ED98DC", hash_generated_method = "80CA192AA1E9F07F13E9C5A1CFD882FF")
        public  CompatCreator(ParcelableCompatCreatorCallbacks<T> callbacks) {
            mCallbacks = callbacks;
            // ---------- Original Method ----------
            //mCallbacks = callbacks;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.312 -0400", hash_original_method = "BC4263EA8B5E453C51CC1CF339ED2394", hash_generated_method = "53BDDF0F409DEF919F7E0C1BF1DE4DC2")
        @Override
        public T createFromParcel(Parcel source) {
            T varB4EAC82CA7396A68D541C85D26508E83_1493547708 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1493547708 = mCallbacks.createFromParcel(source, null);
            addTaint(source.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1493547708.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1493547708;
            // ---------- Original Method ----------
            //return mCallbacks.createFromParcel(source, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.318 -0400", hash_original_method = "5AB872DFD1AEB45ECC63ABABFF71FE11", hash_generated_method = "30960A37E3FC5D0FEF6DDBF9CE13747D")
        @Override
        public T[] newArray(int size) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_1934029519 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1934029519 = mCallbacks.newArray(size);
            addTaint(size);
            varB4EAC82CA7396A68D541C85D26508E83_1934029519.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1934029519;
            // ---------- Original Method ----------
            //return mCallbacks.newArray(size);
        }

        
    }


    
}

