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
import org.apache.harmony.dalvik.ddmc.DdmVmInternal;






public class DdmHandleThread extends ChunkHandler {

    /**
     * Register for the messages we're interested in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.597 -0500", hash_original_method = "4B1A4D6D481D9FF5D2C57EDD95992F00", hash_generated_method = "95095623A75345DB4F55E4CEEFBC0F93")
    
public static void register() {
        DdmServer.registerHandler(CHUNK_THEN, mInstance);
        DdmServer.registerHandler(CHUNK_THST, mInstance);
        DdmServer.registerHandler(CHUNK_STKL, mInstance);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.580 -0500", hash_original_field = "F2C5A2B19E9E75DECB332FBBD8AB7502", hash_generated_field = "6FD8B0A025617CAABDC74F5512BD1925")


    public static final int CHUNK_THEN = type("THEN");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.582 -0500", hash_original_field = "9BA8FCA0F8FBB1120A5AB372DBDD382B", hash_generated_field = "76B61FBE133D3C178633BE3ED16C7D88")

    public static final int CHUNK_THCR = type("THCR");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.585 -0500", hash_original_field = "AD6C4EB50FBB86E35830E46D6BE27264", hash_generated_field = "6C54A1712C9684C82DFE10C559A7239B")

    public static final int CHUNK_THDE = type("THDE");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.588 -0500", hash_original_field = "24EC663498D2DA4610F095B3C2978542", hash_generated_field = "0037B4EAFA33D36A94E59F46954153B0")

    public static final int CHUNK_THST = type("THST");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.590 -0500", hash_original_field = "AA40356B4682CC72D564F57F0E0ADCC0", hash_generated_field = "05661DA41737F5FE00F60ABE023BA158")

    public static final int CHUNK_STKL = type("STKL");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.593 -0500", hash_original_field = "52AEE05E56FE6F184510FC40EF4AB619", hash_generated_field = "80D0E25C8F1F0092137DF49E7789674E")


    private static DdmHandleThread mInstance = new DdmHandleThread();


    /* singleton, do not instantiate */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.595 -0500", hash_original_method = "9014293089915C4268DF07C71EC6FF27", hash_generated_method = "7B16A2D832C1C51ED12E9EDF69EDAE4C")
    
private DdmHandleThread() {}

    /**
     * Called when the DDM server connects.  The handler is allowed to
     * send messages to the server.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.599 -0500", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "B371B1A5EBF86980C6290FA035BAE684")
    
public void connected() {}

    /**
     * Called when the DDM server disconnects.  Can be used to disable
     * periodic transmissions or clean up saved state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.601 -0500", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "5061C51BA9AB55A45A330545ECB336D2")
    
public void disconnected() {}

    /**
     * Handle a chunk of data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.603 -0500", hash_original_method = "A7F2A84C27DF1EE7C10C6ACC7D9300BF", hash_generated_method = "EF86E0A5518881FF07C9FC3B533D6929")
    
public Chunk handleChunk(Chunk request) {
        if (false)
            Log.v("ddm-thread", "Handling " + name(request.type) + " chunk");
        int type = request.type;

        if (type == CHUNK_THEN) {
            return handleTHEN(request);
        } else if (type == CHUNK_THST) {
            return handleTHST(request);
        } else if (type == CHUNK_STKL) {
            return handleSTKL(request);
        } else {
            throw new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
        }
    }

    /*
     * Handle a "THread notification ENable" request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.607 -0500", hash_original_method = "BC156E08FEFB0A0F13BF2C52AB62FDFE", hash_generated_method = "9DA478953B4FDD1477742BA31813917F")
    
private Chunk handleTHEN(Chunk request) {
        ByteBuffer in = wrapChunk(request);

        boolean enable = (in.get() != 0);
        //Log.i("ddm-thread", "Thread notify enable: " + enable);

        DdmVmInternal.threadNotify(enable);
        return null;        // empty response
    }

    /*
     * Handle a "THread STatus" request.  This is constructed by the VM.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.609 -0500", hash_original_method = "2695125C08C32728E983ED92A17A93FC", hash_generated_method = "1618901B5EBE9270EED4F346F1946A79")
    
private Chunk handleTHST(Chunk request) {
        ByteBuffer in = wrapChunk(request);
        // currently nothing to read from "in"

        //Log.d("ddm-thread", "Thread status request");

        byte[] status = DdmVmInternal.getThreadStats();
        if (status != null)
            return new Chunk(CHUNK_THST, status, 0, status.length);
        else
            return createFailChunk(1, "Can't build THST chunk");
    }

    /*
     * Handle a STacK List request.
     *
     * This is done by threadId, which isn't great since those are
     * recycled.  We need a thread serial ID.  The Linux tid is an okay
     * answer as it's unlikely to recycle at the exact wrong moment.
     * However, we're using the short threadId in THST messages, so we
     * use them here for consistency.  (One thought is to keep the current
     * thread ID in the low 16 bits and somehow serialize the top 16 bits.)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.611 -0500", hash_original_method = "D658C618BB2C2BBDA71F6A2C6E25EF76", hash_generated_method = "B6333C1C2AAA48281287DB81C489DECB")
    
private Chunk handleSTKL(Chunk request) {
        ByteBuffer in = wrapChunk(request);
        int threadId;

        threadId = in.getInt();

        //Log.d("ddm-thread", "Stack list request " + threadId);

        StackTraceElement[] trace = DdmVmInternal.getStackTraceById(threadId);
        if (trace == null) {
            return createFailChunk(1, "Stack trace unavailable");
        } else {
            return createStackChunk(trace, threadId);
        }
    }

    /*
     * Serialize a StackTraceElement[] into an STKL chunk.
     *
     * We include the threadId in the response so the other side doesn't have
     * to match up requests and responses as carefully.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.614 -0500", hash_original_method = "B0772B34720138634AE49D68BC346BA3", hash_generated_method = "A50D916FC1F138DEBA562069C2D7EB90")
    
private Chunk createStackChunk(StackTraceElement[] trace, int threadId) {
        int bufferSize = 0;

        bufferSize += 4;            // version, flags, whatever
        bufferSize += 4;            // thread ID
        bufferSize += 4;            // frame count
        for (StackTraceElement elem : trace) {
            bufferSize += 4 + elem.getClassName().length() * 2;
            bufferSize += 4 + elem.getMethodName().length() * 2;
            bufferSize += 4;
            if (elem.getFileName() != null)
                bufferSize += elem.getFileName().length() * 2;
            bufferSize += 4;        // line number
        }

        ByteBuffer out = ByteBuffer.allocate(bufferSize);
        out.putInt(0);
        out.putInt(threadId);
        out.putInt(trace.length);
        for (StackTraceElement elem : trace) {
            out.putInt(elem.getClassName().length());
            putString(out, elem.getClassName());
            out.putInt(elem.getMethodName().length());
            putString(out, elem.getMethodName());
            if (elem.getFileName() != null) {
                out.putInt(elem.getFileName().length());
                putString(out, elem.getFileName());
            } else {
                out.putInt(0);
            }
            out.putInt(elem.getLineNumber());
        }

        return new Chunk(CHUNK_STKL, out);
    }
}

