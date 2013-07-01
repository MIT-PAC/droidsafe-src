package android.support.v4.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

class ParcelableCompatCreatorHoneycombMR2Stub {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:27:15.797 -0400", hash_original_method = "B51620A94A4A980AB423894C07F5AA97", hash_generated_method = "B51620A94A4A980AB423894C07F5AA97")
    public ParcelableCompatCreatorHoneycombMR2Stub ()
    {
        //Synthesized constructor
    }


        static <T> Parcelable.Creator<T> instantiate(ParcelableCompatCreatorCallbacks<T> callbacks) {
        return new ParcelableCompatCreatorHoneycombMR2<T>(callbacks);
    }

    
}

class ParcelableCompatCreatorHoneycombMR2<T> implements Parcelable.ClassLoaderCreator<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:27:15.802 -0400", hash_original_field = "8DA114DA2B33B0EF1622BD0EE0F06E2B", hash_generated_field = "9BB02B023178A1524000C6B48D874A89")

    private ParcelableCompatCreatorCallbacks<T> mCallbacks;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:27:15.805 -0400", hash_original_method = "6B4EA7F5329B9AD7AB24C24081C5781B", hash_generated_method = "C73750FC153F6F4BF29BACCBB4819451")
    public  ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> callbacks) {
        mCallbacks = callbacks;
        // ---------- Original Method ----------
        //mCallbacks = callbacks;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:27:15.811 -0400", hash_original_method = "52A728D45CED91BA6B017F7FCEEE53FB", hash_generated_method = "32B6C161566D31337E14E419687A7F60")
    public T createFromParcel(Parcel in) {
        T varB4EAC82CA7396A68D541C85D26508E83_1941574311 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1941574311 = mCallbacks.createFromParcel(in, null);
        addTaint(in.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1941574311.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1941574311;
        // ---------- Original Method ----------
        //return mCallbacks.createFromParcel(in, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:27:15.815 -0400", hash_original_method = "A7CE79B4A20BAA4EA8FDFB810F2AE2AD", hash_generated_method = "A305EEE9FFA2290DD292C33050FB94E2")
    public T createFromParcel(Parcel in, ClassLoader loader) {
        T varB4EAC82CA7396A68D541C85D26508E83_487592611 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_487592611 = mCallbacks.createFromParcel(in, loader);
        addTaint(in.getTaint());
        addTaint(loader.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_487592611.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_487592611;
        // ---------- Original Method ----------
        //return mCallbacks.createFromParcel(in, loader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:27:15.820 -0400", hash_original_method = "5AB872DFD1AEB45ECC63ABABFF71FE11", hash_generated_method = "11149432A5EE4BE503397B13BEA0715E")
    public T[] newArray(int size) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1214041683 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1214041683 = mCallbacks.newArray(size);
        addTaint(size);
        varB4EAC82CA7396A68D541C85D26508E83_1214041683.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1214041683;
        // ---------- Original Method ----------
        //return mCallbacks.newArray(size);
    }

    
}

