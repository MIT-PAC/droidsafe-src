package android.ddm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;
import android.util.Log;
import java.nio.ByteBuffer;

public class DdmHandleNativeHeap extends ChunkHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.003 -0400", hash_original_method = "ACE04131AFA484CBFE62D5908678C3E3", hash_generated_method = "A38AD3DD2B6A1166A8F3D50A828FB6DB")
    private  DdmHandleNativeHeap() {
        
    }

    
    @DSModeled(DSC.SAFE)
    public static void register() {
        DdmServer.registerHandler(CHUNK_NHGT, mInstance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.004 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    public void connected() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.004 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    public void disconnected() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.005 -0400", hash_original_method = "D29D7720926B3EEAF9F111354569BA63", hash_generated_method = "D161C4C95D1D03BF6989D9D9F7AC4415")
    public Chunk handleChunk(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_459411109 = null; 
        int type = request.type;
        {
            varB4EAC82CA7396A68D541C85D26508E83_459411109 = handleNHGT(request);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
        } 
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_459411109.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_459411109;
        
        
        
        
            
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.006 -0400", hash_original_method = "14897B1C078BC71A7C6BA04BAB3CD153", hash_generated_method = "5FC47C0AA0166FFDC30279B85F4DC6EB")
    private Chunk handleNHGT(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_613975777 = null; 
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1355792715 = null; 
        byte[] data = getLeakInfo();
        {
            varB4EAC82CA7396A68D541C85D26508E83_613975777 = new Chunk(ChunkHandler.type("NHGT"), data, 0, data.length);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1355792715 = createFailChunk(1, "Something went wrong");
        } 
        addTaint(request.getTaint());
        Chunk varA7E53CE21691AB073D9660D615818899_1790275190; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1790275190 = varB4EAC82CA7396A68D541C85D26508E83_613975777;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1790275190 = varB4EAC82CA7396A68D541C85D26508E83_1355792715;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1790275190.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1790275190;
        
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.006 -0400", hash_original_method = "FB1B192E745D23B5AF3323CB7D32960E", hash_generated_method = "8D8D20E9DB9937A1918979869D1CDFA8")
    private byte[] getLeakInfo() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_559960831 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_559960831;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.007 -0400", hash_original_field = "23EABDC7C6F64CC46DA4755D2CBC58BA", hash_generated_field = "CEFB92C5F36D65DBFF534DFB7342F93F")

    public static final int CHUNK_NHGT = type("NHGT");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.007 -0400", hash_original_field = "CBD42FD72A2456E4661E159318FC1FD8", hash_generated_field = "B5F5FC246460885FEBFA550AE061E53E")

    private static DdmHandleNativeHeap mInstance = new DdmHandleNativeHeap();
}

