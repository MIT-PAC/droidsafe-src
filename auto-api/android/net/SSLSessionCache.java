package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.harmony.xnet.provider.jsse.FileClientSessionCache;
import org.apache.harmony.xnet.provider.jsse.SSLClientSessionCache;
import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public final class SSLSessionCache {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.150 -0400", hash_original_field = "8713673389F715AC61146DC2ACD6B364", hash_generated_field = "D03E46EDECBAA58DC5BFAFCFA4D7C707")

    SSLClientSessionCache mSessionCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.151 -0400", hash_original_method = "6BE9C825DC583F0CB57790078D9D850C", hash_generated_method = "BFF2023672F9B3C3573F503758C24A48")
    public  SSLSessionCache(File dir) throws IOException {
        mSessionCache = FileClientSessionCache.usingDirectory(dir);
        // ---------- Original Method ----------
        //mSessionCache = FileClientSessionCache.usingDirectory(dir);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.152 -0400", hash_original_method = "5579597B1129E64225215E4123F94CC0", hash_generated_method = "93090276E48B88AE332147DAA139A9FC")
    public  SSLSessionCache(Context context) {
        File dir;
        dir = context.getDir("sslcache", Context.MODE_PRIVATE);
        SSLClientSessionCache cache;
        cache = null;
        try 
        {
            cache = FileClientSessionCache.usingDirectory(dir);
        } //End block
        catch (IOException e)
        { }
        mSessionCache = cache;
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //File dir = context.getDir("sslcache", Context.MODE_PRIVATE);
        //SSLClientSessionCache cache = null;
        //try {
            //cache = FileClientSessionCache.usingDirectory(dir);
        //} catch (IOException e) {
            //Log.w(TAG, "Unable to create SSL session cache in " + dir, e);
        //}
        //mSessionCache = cache;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.152 -0400", hash_original_field = "F49A29534D2CB7814A731E7945B4ECD0", hash_generated_field = "FC99E8B7A9D6AE716487BD48DB64632C")

    private static String TAG = "SSLSessionCache";
}

