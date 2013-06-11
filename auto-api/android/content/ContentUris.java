package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.net.Uri;

public class ContentUris {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.452 -0400", hash_original_method = "E7C08F28E029230A0C776D88B5A5BA54", hash_generated_method = "362181E19A81B88A5331260D007E8420")
    public static long parseId(Uri contentUri) {
        String last = contentUri.getLastPathSegment();
        return last == null ? -1 : Long.parseLong(last);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.452 -0400", hash_original_method = "EDED6DC16A68EB62093EC466820CBDE9", hash_generated_method = "E59BCA151CC71FC24239D72D6F7B5820")
    public static Uri.Builder appendId(Uri.Builder builder, long id) {
        return builder.appendEncodedPath(String.valueOf(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.452 -0400", hash_original_method = "C70CD309A79900820DE9DAE7972FEBC6", hash_generated_method = "89F7743D876391CFF6AA77061F69F3F3")
    public static Uri withAppendedId(Uri contentUri, long id) {
        return appendId(contentUri.buildUpon(), id).build();
    }

    
}


