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

public class DdmHandleExit extends ChunkHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.926 -0400", hash_original_method = "4CE2D1F4C1C2D74BBC9BDD8F112E8266", hash_generated_method = "E1D802991165E9F58003EAF806F78F0E")
    @DSModeled(DSC.SAFE)
    private DdmHandleExit() {
        // ---------- Original Method ----------
    }

    
        public static void register() {
        DdmServer.registerHandler(CHUNK_EXIT, mInstance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.926 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    @DSModeled(DSC.SAFE)
    public void connected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.926 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    @DSModeled(DSC.SAFE)
    public void disconnected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.926 -0400", hash_original_method = "82AA707C3D594DFF9A299AE775B6B0C9", hash_generated_method = "2E886785F33F797187B226096FA2B0CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Chunk handleChunk(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        ByteBuffer in;
        in = wrapChunk(request);
        int statusCode;
        statusCode = in.getInt();
        Runtime.getRuntime().halt(statusCode);
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (false)
            //Log.v("ddm-exit", "Handling " + name(request.type) + " chunk");
        //ByteBuffer in = wrapChunk(request);
        //int statusCode = in.getInt();
        //Runtime.getRuntime().halt(statusCode);
        //return null;
    }

    
    public static final int CHUNK_EXIT = type("EXIT");
    private static DdmHandleExit mInstance = new DdmHandleExit();
}

