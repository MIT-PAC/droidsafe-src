package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.HashMap;

public class L10nUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.080 -0400", hash_original_method = "E0BD4E5359B29F1B1ED75AB21E0F35C1", hash_generated_method = "E0BD4E5359B29F1B1ED75AB21E0F35C1")
    public L10nUtils ()
    {
        //Synthesized constructor
    }


        public static void setApplicationContext(Context applicationContext) {
        mApplicationContext = applicationContext.getApplicationContext();
    }

    
        private static String loadString(int id) {
        if (mStrings == null) {
            mStrings = new HashMap<Integer, SoftReference<String> >(mIdsArray.length);
        }
        String localisedString = mApplicationContext.getResources().getString(mIdsArray[id]);
        mStrings.put(id, new SoftReference<String>(localisedString));
        return localisedString;
    }

    
        public static String getLocalisedString(int id) {
        if (mStrings == null) {
            return loadString(id);
        }
        SoftReference<String> ref = mStrings.get(id);
        boolean needToLoad = ref == null || ref.get() == null;
        return needToLoad ? loadString(id) : ref.get();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.081 -0400", hash_original_field = "B4DBCA199BDC3444A5F5A15518240E71", hash_generated_field = "DF377258D4EF63AF085439171219FB65")

    private static int[] mIdsArray = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.082 -0400", hash_original_field = "BCB208A03C79579955DC455811823AC0", hash_generated_field = "5F3084FB57196F92DB8F6420AA6F05A0")

    private static Context mApplicationContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.082 -0400", hash_original_field = "DCFA8FC1CFB8B5A5290D25EC1EA3C56B", hash_generated_field = "03A40345C7339DC0F9BFF7212E392A68")

    private static Map<Integer, SoftReference<String> > mStrings;
}

