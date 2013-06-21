package android.ddm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;
import android.util.Log;
import java.nio.ByteBuffer;

public class DdmHandleAppName extends ChunkHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.923 -0400", hash_original_method = "D8F21F6A35B29C82CC84858F5D50C10E", hash_generated_method = "4AA0C4196E29438E7A86C54BEE924FD0")
    @DSModeled(DSC.SAFE)
    private DdmHandleAppName() {
        // ---------- Original Method ----------
    }

    
        public static void register() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.923 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    @DSModeled(DSC.SAFE)
    public void connected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.923 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    @DSModeled(DSC.SAFE)
    public void disconnected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.924 -0400", hash_original_method = "9322B8B253BE8A74DE6E5A2942EC5C84", hash_generated_method = "7458DEBFD63C607D44914CB6D33230B6")
    @DSModeled(DSC.SAFE)
    public Chunk handleChunk(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
        public static void setAppName(String name) {
        if (name == null || name.length() == 0)
            return;
        mAppName = name;
        sendAPNM(name);
    }

    
        public static String getAppName() {
        return mAppName;
    }

    
        private static void sendAPNM(String appName) {
        if (false)
            Log.v("ddm", "Sending app name");
        ByteBuffer out = ByteBuffer.allocate(4 + appName.length()*2);
        out.order(ChunkHandler.CHUNK_ORDER);
        out.putInt(appName.length());
        putString(out, appName);
        Chunk chunk = new Chunk(CHUNK_APNM, out);
        DdmServer.sendChunk(chunk);
    }

    
    public static final int CHUNK_APNM = type("APNM");
    private volatile static String mAppName = "";
    private static DdmHandleAppName mInstance = new DdmHandleAppName();
}

