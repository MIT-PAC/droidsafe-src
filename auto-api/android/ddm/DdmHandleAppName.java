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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.922 -0400", hash_original_method = "D8F21F6A35B29C82CC84858F5D50C10E", hash_generated_method = "4AA0C4196E29438E7A86C54BEE924FD0")
    private  DdmHandleAppName() {
        // ---------- Original Method ----------
    }

    
    public static void register() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.923 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    public void connected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.923 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    public void disconnected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.924 -0400", hash_original_method = "9322B8B253BE8A74DE6E5A2942EC5C84", hash_generated_method = "C3A2C55BF215A183BAA6EFDE93A78993")
    public Chunk handleChunk(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1104552883 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1104552883 = null;
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1104552883.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1104552883;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.925 -0400", hash_original_field = "C0EC2ED0C0CF89300CB83DEFFF3FBA06", hash_generated_field = "A00FA52EEEF4E9D0FDBABD362F30DDE4")

    public static final int CHUNK_APNM = type("APNM");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.925 -0400", hash_original_field = "E59EB9719FA44D601D4143CDA4B04189", hash_generated_field = "13D874CFFECF1B13A69B63BC4FD01026")

    private volatile static String mAppName = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.925 -0400", hash_original_field = "6D0F3A12D1E77DB82707A844A474112E", hash_generated_field = "CB6FB73A6BC364A591CA00981BD0CE53")

    private static DdmHandleAppName mInstance = new DdmHandleAppName();
}

