package android.ddm;

// Droidsafe Imports
import java.nio.ByteBuffer;

import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DdmHandleExit extends ChunkHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.131 -0400", hash_original_method = "4CE2D1F4C1C2D74BBC9BDD8F112E8266", hash_generated_method = "E1D802991165E9F58003EAF806F78F0E")
    private  DdmHandleExit() {
        // ---------- Original Method ----------
    }

    
    public static void register() {
        DdmServer.registerHandler(CHUNK_EXIT, mInstance);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.132 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    public void connected() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.132 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    public void disconnected() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.133 -0400", hash_original_method = "82AA707C3D594DFF9A299AE775B6B0C9", hash_generated_method = "14AAB2C807D9412B359CEFBDFE74B6A6")
    public Chunk handleChunk(Chunk request) {
        addTaint(request.getTaint());
        if(false){ }        ByteBuffer in = wrapChunk(request);
        int statusCode = in.getInt();
        Runtime.getRuntime().halt(statusCode);
Chunk var540C13E9E156B687226421B24F2DF178_178119972 =         null;
        var540C13E9E156B687226421B24F2DF178_178119972.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_178119972;
        // ---------- Original Method ----------
        //if (false)
            //Log.v("ddm-exit", "Handling " + name(request.type) + " chunk");
        //ByteBuffer in = wrapChunk(request);
        //int statusCode = in.getInt();
        //Runtime.getRuntime().halt(statusCode);
        //return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.133 -0400", hash_original_field = "9C2D1D219ADFA92F41C9C1232643CA15", hash_generated_field = "DAAD47F6FA6C4CC32717481A9CF9A22B")

    public static final int CHUNK_EXIT = type("EXIT");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.133 -0400", hash_original_field = "1E74222B4CCB7C07805D4174191619EA", hash_generated_field = "5929389BB4771070576D8746DF348AC9")

    private static DdmHandleExit mInstance = new DdmHandleExit();
}

