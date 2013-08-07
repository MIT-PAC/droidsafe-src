package android.content;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.net.Uri;




public class ContentUris {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.303 -0400", hash_original_method = "8AAA02C02EB3A227B34A166B78568DD1", hash_generated_method = "8AAA02C02EB3A227B34A166B78568DD1")
    public ContentUris ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SPEC)
    public static long parseId(Uri contentUri) {
        String last = contentUri.getLastPathSegment();
        return last == null ? -1 : Long.parseLong(last);
    }

    
    public static Uri.Builder appendId(Uri.Builder builder, long id) {
        return builder.appendEncodedPath(String.valueOf(id));
    }

    
    @DSModeled(DSC.SPEC)
    public static Uri withAppendedId(Uri contentUri, long id) {
        return appendId(contentUri.buildUpon(), id).build();
    }

    
}

