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

public class DdmHandleNativeHeap extends ChunkHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.267 -0400", hash_original_method = "ACE04131AFA484CBFE62D5908678C3E3", hash_generated_method = "A38AD3DD2B6A1166A8F3D50A828FB6DB")
    private  DdmHandleNativeHeap() {
        // ---------- Original Method ----------
    }

    
        public static void register() {
        DdmServer.registerHandler(CHUNK_NHGT, mInstance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.268 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    public void connected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.268 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    public void disconnected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.269 -0400", hash_original_method = "D29D7720926B3EEAF9F111354569BA63", hash_generated_method = "AD663B9D6FE8746367B0C68355D21A81")
    public Chunk handleChunk(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1481756456 = null; //Variable for return #1
        int type;
        type = request.type;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1481756456 = handleNHGT(request);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
        } //End block
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1481756456.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1481756456;
        // ---------- Original Method ----------
        //Log.i("ddm-nativeheap", "Handling " + name(request.type) + " chunk");
        //int type = request.type;
        //if (type == CHUNK_NHGT) {
            //return handleNHGT(request);
        //} else {
            //throw new RuntimeException("Unknown packet "
                //+ ChunkHandler.name(type));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.271 -0400", hash_original_method = "14897B1C078BC71A7C6BA04BAB3CD153", hash_generated_method = "35394CA93AEDB72BCD0313E32D479644")
    private Chunk handleNHGT(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1878444334 = null; //Variable for return #1
        Chunk varB4EAC82CA7396A68D541C85D26508E83_481659848 = null; //Variable for return #2
        byte[] data;
        data = getLeakInfo();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1878444334 = new Chunk(ChunkHandler.type("NHGT"), data, 0, data.length);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_481659848 = createFailChunk(1, "Something went wrong");
        } //End block
        addTaint(request.getTaint());
        Chunk varA7E53CE21691AB073D9660D615818899_833819303; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_833819303 = varB4EAC82CA7396A68D541C85D26508E83_1878444334;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_833819303 = varB4EAC82CA7396A68D541C85D26508E83_481659848;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_833819303.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_833819303;
        // ---------- Original Method ----------
        //byte[] data = getLeakInfo();
        //if (data != null) {
            //Log.i("ddm-nativeheap", "Sending " + data.length + " bytes");
            //return new Chunk(ChunkHandler.type("NHGT"), data, 0, data.length);
        //} else {
            //return createFailChunk(1, "Something went wrong");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.283 -0400", hash_original_method = "FB1B192E745D23B5AF3323CB7D32960E", hash_generated_method = "6128F585DDD9AD257FD510407782F16C")
    private byte[] getLeakInfo() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1037856309 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1037856309;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.283 -0400", hash_original_field = "23EABDC7C6F64CC46DA4755D2CBC58BA", hash_generated_field = "CEFB92C5F36D65DBFF534DFB7342F93F")

    public static final int CHUNK_NHGT = type("NHGT");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.283 -0400", hash_original_field = "CBD42FD72A2456E4661E159318FC1FD8", hash_generated_field = "B5F5FC246460885FEBFA550AE061E53E")

    private static DdmHandleNativeHeap mInstance = new DdmHandleNativeHeap();
}

