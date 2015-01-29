package android.ddm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.nio.ByteBuffer;

import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;

import android.os.Debug;

public class DdmHandleProfiling extends ChunkHandler {

    /**
     * Register for the messages we're interested in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.393 -0500", hash_original_method = "BE927C5E0164A4926B1CC9E55E38B569", hash_generated_method = "28D3E7ACDA13B58906E9D50827B96032")
    
public static void register() {
        DdmServer.registerHandler(CHUNK_MPRS, mInstance);
        DdmServer.registerHandler(CHUNK_MPRE, mInstance);
        DdmServer.registerHandler(CHUNK_MPSS, mInstance);
        DdmServer.registerHandler(CHUNK_MPSE, mInstance);
        DdmServer.registerHandler(CHUNK_MPRQ, mInstance);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.375 -0500", hash_original_field = "2AE0C7C48A9EDF98841D2C1D14B0DB61", hash_generated_field = "7FFFFE3EB65969A45E28C911251E127E")

    public static final int CHUNK_MPRS = type("MPRS");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.378 -0500", hash_original_field = "19DB389116C6BBEB980E58BC459FF104", hash_generated_field = "7F18F91381D75BE7FEA8B9EA463A84F4")

    public static final int CHUNK_MPRE = type("MPRE");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.381 -0500", hash_original_field = "00FCCA680D515386D0135E8950E5A6FC", hash_generated_field = "27590C354FA31B4C05A287778E41C9D8")

    public static final int CHUNK_MPSS = type("MPSS");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.383 -0500", hash_original_field = "BD3DE66CEF85661B114007DE695AD469", hash_generated_field = "A2188CC3E8488D7886638119E037639F")

    public static final int CHUNK_MPSE = type("MPSE");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.385 -0500", hash_original_field = "E9511EFAD17B871CE5D4CAF3A4FC2850", hash_generated_field = "1621D64DD5751DA51B57A9D956F98541")

    public static final int CHUNK_MPRQ = type("MPRQ");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.388 -0500", hash_original_field = "1E741689559E71BAF313CDE397355185", hash_generated_field = "518411F24B65007CDBF385DFFC68993E")

    private static DdmHandleProfiling mInstance = new DdmHandleProfiling();

    /* singleton, do not instantiate */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.390 -0500", hash_original_method = "7648F12CCEF030214D1E836EAA9C8F00", hash_generated_method = "6997A1F33235121B9BEC7596D788387A")
    
private DdmHandleProfiling() {}

    /**
     * Called when the DDM server connects.  The handler is allowed to
     * send messages to the server.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.395 -0500", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "B371B1A5EBF86980C6290FA035BAE684")
    
public void connected() {}

    /**
     * Called when the DDM server disconnects.  Can be used to disable
     * periodic transmissions or clean up saved state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.397 -0500", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "5061C51BA9AB55A45A330545ECB336D2")
    
public void disconnected() {}

    /**
     * Handle a chunk of data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.399 -0500", hash_original_method = "DB7D0E34713769F576AB6489AD8FC572", hash_generated_method = "3666D9FC7AFDAB95F34AC20D2B771CA7")
    
public Chunk handleChunk(Chunk request) {
        if (false)
            Log.v("ddm-heap", "Handling " + name(request.type) + " chunk");
        int type = request.type;

        if (type == CHUNK_MPRS) {
            return handleMPRS(request);
        } else if (type == CHUNK_MPRE) {
            return handleMPRE(request);
        } else if (type == CHUNK_MPSS) {
            return handleMPSS(request);
        } else if (type == CHUNK_MPSE) {
            return handleMPSE(request);
        } else if (type == CHUNK_MPRQ) {
            return handleMPRQ(request);
        } else {
            throw new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
        }
    }

    /*
     * Handle a "Method PRofiling Start" request.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.402 -0500", hash_original_method = "7940F56C64BA10714BAFA7B4E80C835C", hash_generated_method = "AC779C94A8D0E7F782DA31889E86BA71")
    
private Chunk handleMPRS(Chunk request) {
        ByteBuffer in = wrapChunk(request);

        int bufferSize = in.getInt();
        int flags = in.getInt();
        int len = in.getInt();
        String fileName = getString(in, len);
        if (false)
            Log.v("ddm-heap", "Method profiling start: filename='" + fileName
                + "', size=" + bufferSize + ", flags=" + flags);

        try {
            Debug.startMethodTracing(fileName, bufferSize, flags);
            return null;        // empty response
        } catch (RuntimeException re) {
            return createFailChunk(1, re.getMessage());
        }
    }

    /*
     * Handle a "Method PRofiling End" request.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.404 -0500", hash_original_method = "C47365EF242409DEE5C5F31B2C812A87", hash_generated_method = "F3FE257D6749BC2B18AA23E409A30F8B")
    
private Chunk handleMPRE(Chunk request) {
        byte result;

        try {
            Debug.stopMethodTracing();
            result = 0;
        } catch (RuntimeException re) {
            Log.w("ddm-heap", "Method profiling end failed: "
                + re.getMessage());
            result = 1;
        }

        /* create a non-empty reply so the handler fires on completion */
        byte[] reply = { result };
        return new Chunk(CHUNK_MPRE, reply, 0, reply.length);
    }

    /*
     * Handle a "Method Profiling w/Streaming Start" request.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.407 -0500", hash_original_method = "0C48BE140EF77A3564208CCA411868CA", hash_generated_method = "9A34EB9B0C34D5259DA601A6562259FC")
    
private Chunk handleMPSS(Chunk request) {
        ByteBuffer in = wrapChunk(request);

        int bufferSize = in.getInt();
        int flags = in.getInt();
        if (false) {
            Log.v("ddm-heap", "Method prof stream start: size=" + bufferSize
                + ", flags=" + flags);
        }

        try {
            Debug.startMethodTracingDdms(bufferSize, flags);
            return null;        // empty response
        } catch (RuntimeException re) {
            return createFailChunk(1, re.getMessage());
        }
    }

    /*
     * Handle a "Method Profiling w/Streaming End" request.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.409 -0500", hash_original_method = "47063ECEB662F521C374596F0F7AD1C6", hash_generated_method = "94FC02C188DF206BE6B22123F3938132")
    
private Chunk handleMPSE(Chunk request) {
        byte result;

        if (false) {
            Log.v("ddm-heap", "Method prof stream end");
        }

        try {
            Debug.stopMethodTracing();
            result = 0;
        } catch (RuntimeException re) {
            Log.w("ddm-heap", "Method prof stream end failed: "
                + re.getMessage());
            return createFailChunk(1, re.getMessage());
        }

        /* VM sent the (perhaps very large) response directly */
        return null;
    }

    /*
     * Handle a "Method PRofiling Query" request.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.412 -0500", hash_original_method = "0E3CEBD2C4AA1513EB9DBAF86A751F94", hash_generated_method = "B468434D751BECDD920F2149278B4FA2")
    
private Chunk handleMPRQ(Chunk request) {
        int result = Debug.isMethodTracingActive() ? 1 : 0;

        /* create a non-empty reply so the handler fires on completion */
        byte[] reply = { (byte) result };
        return new Chunk(CHUNK_MPRQ, reply, 0, reply.length);
    }
}

