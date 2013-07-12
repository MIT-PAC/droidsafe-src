package android.ddm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;
import android.util.Log;
import java.nio.ByteBuffer;

public class DdmHandleNativeHeap extends ChunkHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.416 -0400", hash_original_method = "ACE04131AFA484CBFE62D5908678C3E3", hash_generated_method = "A38AD3DD2B6A1166A8F3D50A828FB6DB")
    private  DdmHandleNativeHeap() {
        
    }

    
        public static void register() {
        DdmServer.registerHandler(CHUNK_NHGT, mInstance);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.417 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    public void connected() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.418 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    public void disconnected() {
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.418 -0400", hash_original_method = "D29D7720926B3EEAF9F111354569BA63", hash_generated_method = "8023B5B0D5C0D87F23885F32F73CCFEB")
    public Chunk handleChunk(Chunk request) {
        addTaint(request.getTaint());
        int type = request.type;
    if(type == CHUNK_NHGT)        
        {
Chunk var86A46C1BD48740636DD323FF61292445_1957495165 =             handleNHGT(request);
            var86A46C1BD48740636DD323FF61292445_1957495165.addTaint(taint);
            return var86A46C1BD48740636DD323FF61292445_1957495165;
        } 
        else
        {
            RuntimeException var87CCC2E1E27D81731A9B6FB9950FC20F_1927207629 = new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
            var87CCC2E1E27D81731A9B6FB9950FC20F_1927207629.addTaint(taint);
            throw var87CCC2E1E27D81731A9B6FB9950FC20F_1927207629;
        } 
        
        
        
        
            
        
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.420 -0400", hash_original_method = "14897B1C078BC71A7C6BA04BAB3CD153", hash_generated_method = "E7AA3ED0A6B588F231D1C9346A150FC4")
    private Chunk handleNHGT(Chunk request) {
        addTaint(request.getTaint());
        byte[] data = getLeakInfo();
    if(data != null)        
        {
Chunk var722D7C958AF6C536A3DFA4C2B744B12C_301614201 =             new Chunk(ChunkHandler.type("NHGT"), data, 0, data.length);
            var722D7C958AF6C536A3DFA4C2B744B12C_301614201.addTaint(taint);
            return var722D7C958AF6C536A3DFA4C2B744B12C_301614201;
        } 
        else
        {
Chunk var31AF8528E5341C3C90ADCF4B619E8D29_1697954443 =             createFailChunk(1, "Something went wrong");
            var31AF8528E5341C3C90ADCF4B619E8D29_1697954443.addTaint(taint);
            return var31AF8528E5341C3C90ADCF4B619E8D29_1697954443;
        } 
        
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.421 -0400", hash_original_method = "FB1B192E745D23B5AF3323CB7D32960E", hash_generated_method = "D814A292B4FE0EAA46C0FBC95E9286B9")
    private byte[] getLeakInfo() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1567462929 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1567462929;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.422 -0400", hash_original_field = "23EABDC7C6F64CC46DA4755D2CBC58BA", hash_generated_field = "CEFB92C5F36D65DBFF534DFB7342F93F")

    public static final int CHUNK_NHGT = type("NHGT");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.422 -0400", hash_original_field = "CBD42FD72A2456E4661E159318FC1FD8", hash_generated_field = "B5F5FC246460885FEBFA550AE061E53E")

    private static DdmHandleNativeHeap mInstance = new DdmHandleNativeHeap();
}

