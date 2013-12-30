package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.File;
import java.io.IOException;

import org.apache.harmony.xnet.provider.jsse.FileClientSessionCache;
import org.apache.harmony.xnet.provider.jsse.SSLClientSessionCache;

import android.content.Context;



public final class SSLSessionCache {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.759 -0500", hash_original_field = "A5740984D5A883313C3C3CD53D225302", hash_generated_field = "AD0B528015E7884FCFBB50D4A7FE6352")

    private static final String TAG = "SSLSessionCache";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.761 -0500", hash_original_field = "D03E46EDECBAA58DC5BFAFCFA4D7C707", hash_generated_field = "D03E46EDECBAA58DC5BFAFCFA4D7C707")
  SSLClientSessionCache mSessionCache;

    /**
     * Create a session cache using the specified directory.
     * Individual session entries will be files within the directory.
     * Multiple instances for the same directory share data internally.
     *
     * @param dir to store session files in (created if necessary)
     * @throws IOException if the cache can't be opened
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.763 -0500", hash_original_method = "6BE9C825DC583F0CB57790078D9D850C", hash_generated_method = "A56A9EB534D0001D160743C198ECB5AA")
    
public SSLSessionCache(File dir) throws IOException {
        mSessionCache = FileClientSessionCache.usingDirectory(dir);
    }

    /**
     * Create a session cache at the default location for this app.
     * Multiple instances share data internally.
     *
     * @param context for the application
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.767 -0500", hash_original_method = "5579597B1129E64225215E4123F94CC0", hash_generated_method = "C5447136828C243E028DB5BE4DE9556C")
    
public SSLSessionCache(Context context) {
        File dir = context.getDir("sslcache", Context.MODE_PRIVATE);
        SSLClientSessionCache cache = null;
        try {
            cache = FileClientSessionCache.usingDirectory(dir);
        } catch (IOException e) {
            Log.w(TAG, "Unable to create SSL session cache in " + dir, e);
        }
        mSessionCache = cache;
    }
}

