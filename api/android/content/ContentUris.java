package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.net.Uri;




public class ContentUris {

    /**
     * Converts the last path segment to a long.
     *
     * <p>This supports a common convention for content URIs where an ID is
     * stored in the last segment.
     *
     * @throws UnsupportedOperationException if this isn't a hierarchical URI
     * @throws NumberFormatException if the last segment isn't a number
     *
     * @return the long conversion of the last segment or -1 if the path is
     *  empty
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.835 -0500", hash_original_method = "E7C08F28E029230A0C776D88B5A5BA54", hash_generated_method = "362181E19A81B88A5331260D007E8420")
    public static long parseId(Uri contentUri) {
        String last = contentUri.getLastPathSegment();
        return last == null ? -1 : Long.parseLong(last);
    }

    /**
     * Appends the given ID to the end of the path.
     *
     * @param builder to append the ID to
     * @param id to append
     *
     * @return the given builder
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.836 -0500", hash_original_method = "EDED6DC16A68EB62093EC466820CBDE9", hash_generated_method = "E59BCA151CC71FC24239D72D6F7B5820")
    public static Uri.Builder appendId(Uri.Builder builder, long id) {
        return builder.appendEncodedPath(String.valueOf(id));
    }

    /**
     * Appends the given ID to the end of the path.
     *
     * @param contentUri to start with
     * @param id to append
     *
     * @return a new URI with the given ID appended to the end of the path
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.837 -0500", hash_original_method = "C70CD309A79900820DE9DAE7972FEBC6", hash_generated_method = "89F7743D876391CFF6AA77061F69F3F3")
    public static Uri withAppendedId(Uri contentUri, long id) {
        return appendId(contentUri.buildUpon(), id).build();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.303 -0400", hash_original_method = "8AAA02C02EB3A227B34A166B78568DD1", hash_generated_method = "8AAA02C02EB3A227B34A166B78568DD1")
    public ContentUris ()
    {
        //Synthesized constructor
    }

    
}

