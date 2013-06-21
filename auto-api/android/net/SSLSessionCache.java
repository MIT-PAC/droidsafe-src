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
    SSLClientSessionCache mSessionCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.475 -0400", hash_original_method = "6BE9C825DC583F0CB57790078D9D850C", hash_generated_method = "03D79807F2733FDDC4A35171A22B8285")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLSessionCache(File dir) throws IOException {
        dsTaint.addTaint(dir.dsTaint);
        mSessionCache = FileClientSessionCache.usingDirectory(dir);
        // ---------- Original Method ----------
        //mSessionCache = FileClientSessionCache.usingDirectory(dir);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.475 -0400", hash_original_method = "5579597B1129E64225215E4123F94CC0", hash_generated_method = "4BF9BD63A2FA3316141EDFFBFDA779C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLSessionCache(Context context) {
        dsTaint.addTaint(context.dsTaint);
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

    
    private static final String TAG = "SSLSessionCache";
}

