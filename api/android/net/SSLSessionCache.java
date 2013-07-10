package android.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.harmony.xnet.provider.jsse.FileClientSessionCache;
import org.apache.harmony.xnet.provider.jsse.SSLClientSessionCache;
import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public final class SSLSessionCache {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.025 -0400", hash_original_field = "8713673389F715AC61146DC2ACD6B364", hash_generated_field = "D03E46EDECBAA58DC5BFAFCFA4D7C707")

    SSLClientSessionCache mSessionCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.025 -0400", hash_original_method = "6BE9C825DC583F0CB57790078D9D850C", hash_generated_method = "BFF2023672F9B3C3573F503758C24A48")
    public  SSLSessionCache(File dir) throws IOException {
        mSessionCache = FileClientSessionCache.usingDirectory(dir);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.026 -0400", hash_original_method = "5579597B1129E64225215E4123F94CC0", hash_generated_method = "BBCC35CF66ABEE603C111760F8B1A6BF")
    public  SSLSessionCache(Context context) {
        File dir = context.getDir("sslcache", Context.MODE_PRIVATE);
        SSLClientSessionCache cache = null;
        try 
        {
            cache = FileClientSessionCache.usingDirectory(dir);
        } 
        catch (IOException e)
        { }
        mSessionCache = cache;
        addTaint(context.getTaint());
        
        
        
        
            
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.026 -0400", hash_original_field = "F49A29534D2CB7814A731E7945B4ECD0", hash_generated_field = "AD0B528015E7884FCFBB50D4A7FE6352")

    private static final String TAG = "SSLSessionCache";
}

