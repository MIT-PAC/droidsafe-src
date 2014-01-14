package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public abstract class ContentHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.311 -0400", hash_original_method = "34235149EC6F1F14A33FF6A78502D340", hash_generated_method = "34235149EC6F1F14A33FF6A78502D340")
    public ContentHandler ()
    {
        //Synthesized constructor
    }
    /**
     * Returns the object pointed by the specified URL connection {@code uConn}.
     *
     * @param uConn
     *            URL connection that points to the desired object.
     * @return object referred by {@code uConn}.
     * @throws IOException
     *             if an IO error occurs during the retrieval of the object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.861 -0500", hash_original_method = "0A0DE36248DED56E2DC9A3C213E73F00", hash_generated_method = "C085E82305BE92773C89ADB444EB7B2D")
    
public abstract Object getContent(URLConnection uConn) throws IOException;

    /**
     * Returns the object pointed by the specified URL connection {@code uConn}.
     *
     * @param uConn
     *            URL connection that points to the desired object.
     * @param types
     *            list of acceptable content types.
     * @return resource object pointed by this URL or {@code null} if the
     *         content doesn't match one of the specified content types.
     * @throws IOException
     *             if an error occurred while obtaining the content.
     */
    // Class arg not generified in the spec.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.864 -0500", hash_original_method = "8659195BC6B56411F2DC6C9C918B5FC3", hash_generated_method = "1AD0408A977EABBE121234307AE2FBAD")
    
@SuppressWarnings("unchecked")
    public Object getContent(URLConnection uConn, Class[] types)
            throws IOException {
        Object content = getContent(uConn);
        for (int i = 0; i < types.length; i++) {
            if (types[i].isInstance(content)) {
                return content;
            }
        }
        return null;
    }
    
}

