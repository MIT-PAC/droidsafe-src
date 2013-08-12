package android.ddm;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;






public class DdmHandleNativeHeap extends ChunkHandler {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.235 -0400", hash_original_method = "ACE04131AFA484CBFE62D5908678C3E3", hash_generated_method = "A38AD3DD2B6A1166A8F3D50A828FB6DB")
    private  DdmHandleNativeHeap() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static void register() {
        DdmServer.registerHandler(CHUNK_NHGT, mInstance);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.236 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    public void connected() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.238 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    public void disconnected() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.241 -0400", hash_original_method = "D29D7720926B3EEAF9F111354569BA63", hash_generated_method = "0B13C1180C89CA3AF2B2D60532C05497")
    public Chunk handleChunk(Chunk request) {
        addTaint(request.getTaint());
        int type = request.type;
        if(type == CHUNK_NHGT)        
        {
Chunk var86A46C1BD48740636DD323FF61292445_600296553 =             handleNHGT(request);
            var86A46C1BD48740636DD323FF61292445_600296553.addTaint(taint);
            return var86A46C1BD48740636DD323FF61292445_600296553;
        } //End block
        else
        {
            RuntimeException var87CCC2E1E27D81731A9B6FB9950FC20F_1940336258 = new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
            var87CCC2E1E27D81731A9B6FB9950FC20F_1940336258.addTaint(taint);
            throw var87CCC2E1E27D81731A9B6FB9950FC20F_1940336258;
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.243 -0400", hash_original_method = "14897B1C078BC71A7C6BA04BAB3CD153", hash_generated_method = "9E873703B302194B204BBA63478049A0")
    private Chunk handleNHGT(Chunk request) {
        addTaint(request.getTaint());
        byte[] data = getLeakInfo();
        if(data != null)        
        {
Chunk var722D7C958AF6C536A3DFA4C2B744B12C_1922311010 =             new Chunk(ChunkHandler.type("NHGT"), data, 0, data.length);
            var722D7C958AF6C536A3DFA4C2B744B12C_1922311010.addTaint(taint);
            return var722D7C958AF6C536A3DFA4C2B744B12C_1922311010;
        } //End block
        else
        {
Chunk var31AF8528E5341C3C90ADCF4B619E8D29_467586127 =             createFailChunk(1, "Something went wrong");
            var31AF8528E5341C3C90ADCF4B619E8D29_467586127.addTaint(taint);
            return var31AF8528E5341C3C90ADCF4B619E8D29_467586127;
        } //End block
        // ---------- Original Method ----------
        //byte[] data = getLeakInfo();
        //if (data != null) {
            //Log.i("ddm-nativeheap", "Sending " + data.length + " bytes");
            //return new Chunk(ChunkHandler.type("NHGT"), data, 0, data.length);
        //} else {
            //return createFailChunk(1, "Something went wrong");
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.244 -0400", hash_original_method = "FB1B192E745D23B5AF3323CB7D32960E", hash_generated_method = "0E45E9786A581DDF89F047E1BAD2BB5B")
    private byte[] getLeakInfo() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_714902497 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_714902497;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.244 -0400", hash_original_field = "23EABDC7C6F64CC46DA4755D2CBC58BA", hash_generated_field = "CEFB92C5F36D65DBFF534DFB7342F93F")

    public static final int CHUNK_NHGT = type("NHGT");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.245 -0400", hash_original_field = "CBD42FD72A2456E4661E159318FC1FD8", hash_generated_field = "B5F5FC246460885FEBFA550AE061E53E")

    private static DdmHandleNativeHeap mInstance = new DdmHandleNativeHeap();
}

