package android.support.v4.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.392 -0400", hash_original_method = "072A1AE559281E061E9C91BC62D0E2B9", hash_generated_method = "072A1AE559281E061E9C91BC62D0E2B9")
    public ParcelableCompat ()
    {
        
    }


        public static <T> Parcelable.Creator<T> newCreator(
            ParcelableCompatCreatorCallbacks<T> callbacks) {
        if (android.os.Build.VERSION.SDK_INT >= 13) {
            ParcelableCompatCreatorHoneycombMR2Stub.instantiate(callbacks);
        }
        return new CompatCreator<T>(callbacks);
    }

    
    static class CompatCreator<T> implements Parcelable.Creator<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.392 -0400", hash_original_field = "8DA114DA2B33B0EF1622BD0EE0F06E2B", hash_generated_field = "BE8C2310A42C4AF4CAB9F639C1E3BDCF")

        ParcelableCompatCreatorCallbacks<T> mCallbacks;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.393 -0400", hash_original_method = "89A37E66A919C0F4D6C87A6FE2ED98DC", hash_generated_method = "80CA192AA1E9F07F13E9C5A1CFD882FF")
        public  CompatCreator(ParcelableCompatCreatorCallbacks<T> callbacks) {
            mCallbacks = callbacks;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.393 -0400", hash_original_method = "BC4263EA8B5E453C51CC1CF339ED2394", hash_generated_method = "905F74B5A9B0F11CB887DB666A810C2B")
        @Override
        public T createFromParcel(Parcel source) {
            T varB4EAC82CA7396A68D541C85D26508E83_1508600748 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1508600748 = mCallbacks.createFromParcel(source, null);
            addTaint(source.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1508600748.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1508600748;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.394 -0400", hash_original_method = "5AB872DFD1AEB45ECC63ABABFF71FE11", hash_generated_method = "BA8E18F8AAD4D35FFFC5B8B2F3329495")
        @Override
        public T[] newArray(int size) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_494777887 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_494777887 = mCallbacks.newArray(size);
            addTaint(size);
            varB4EAC82CA7396A68D541C85D26508E83_494777887.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_494777887;
            
            
        }

        
    }


    
}

