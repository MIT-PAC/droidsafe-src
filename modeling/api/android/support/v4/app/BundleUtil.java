package android.support.v4.app;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.Arrays;
/**
 * @hide
 */
class BundleUtil {
    /**
     * Get an array of Bundle objects from a parcelable array field in a bundle.
     * Update the bundle to have a typed array so fetches in the future don't need
     * to do an array copy.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:05:54.840 -0400", hash_original_method = "210112D6E0E4A93CB185EB72C4B028F4", hash_generated_method = "25344A9795870C3FAE73DF1FE099853D")
    
public static Bundle[] getBundleArrayFromBundle(Bundle bundle, String key) {
        Parcelable[] array = bundle.getParcelableArray(key);
        if (array instanceof Bundle[] || array == null) {
            return (Bundle[]) array;
        }
        Bundle[] typedArray = Arrays.copyOf(array, array.length,
                Bundle[].class);
        bundle.putParcelableArray(key, typedArray);
        return typedArray;
    }
}

