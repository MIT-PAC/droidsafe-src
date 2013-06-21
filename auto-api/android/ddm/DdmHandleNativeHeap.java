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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.957 -0400", hash_original_method = "ACE04131AFA484CBFE62D5908678C3E3", hash_generated_method = "A38AD3DD2B6A1166A8F3D50A828FB6DB")
    @DSModeled(DSC.SAFE)
    private DdmHandleNativeHeap() {
        // ---------- Original Method ----------
    }

    
        public static void register() {
        DdmServer.registerHandler(CHUNK_NHGT, mInstance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.957 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    @DSModeled(DSC.SAFE)
    public void connected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.957 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    @DSModeled(DSC.SAFE)
    public void disconnected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.958 -0400", hash_original_method = "D29D7720926B3EEAF9F111354569BA63", hash_generated_method = "1FA9667BC08857EE4AAC7F4A79080476")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Chunk handleChunk(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        int type;
        type = request.type;
        {
            Chunk var01D04727591BA2F2F7462DD1860747CE_608233812 = (handleNHGT(request));
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
        } //End block
        return (Chunk)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.958 -0400", hash_original_method = "14897B1C078BC71A7C6BA04BAB3CD153", hash_generated_method = "471F9BE12723053F9497A0FDAF1AAFA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk handleNHGT(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        byte[] data;
        data = getLeakInfo();
        {
            Chunk var2DD01749A32018260652B328728C3119_915487279 = (new Chunk(ChunkHandler.type("NHGT"), data, 0, data.length));
        } //End block
        {
            Chunk varD6EBC9048AED1CD0905C04B20E91D2F4_1767701629 = (createFailChunk(1, "Something went wrong"));
        } //End block
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byte[] data = getLeakInfo();
        //if (data != null) {
            //Log.i("ddm-nativeheap", "Sending " + data.length + " bytes");
            //return new Chunk(ChunkHandler.type("NHGT"), data, 0, data.length);
        //} else {
            //return createFailChunk(1, "Something went wrong");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.958 -0400", hash_original_method = "FB1B192E745D23B5AF3323CB7D32960E", hash_generated_method = "74872BDB2430657A246F473EDAD89E06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private byte[] getLeakInfo() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
    }

    
    public static final int CHUNK_NHGT = type("NHGT");
    private static DdmHandleNativeHeap mInstance = new DdmHandleNativeHeap();
}

