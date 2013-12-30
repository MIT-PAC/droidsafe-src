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






public class DdmHandleExit extends ChunkHandler {

    /**
     * Register for the messages we're interested in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.718 -0500", hash_original_method = "2C162FFAD344A5CDEA9F9F6270AC8B9D", hash_generated_method = "7008F5653BFCECB85C70EC2FACC5F89A")
    
public static void register() {
        DdmServer.registerHandler(CHUNK_EXIT, mInstance);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.711 -0500", hash_original_field = "8157E52A71C2E662BFD594C40F33A43C", hash_generated_field = "DAAD47F6FA6C4CC32717481A9CF9A22B")


    public static final int CHUNK_EXIT = type("EXIT");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.714 -0500", hash_original_field = "CFC7735AE34A95928FF1A286CB5255C0", hash_generated_field = "5929389BB4771070576D8746DF348AC9")


    private static DdmHandleExit mInstance = new DdmHandleExit();


    /* singleton, do not instantiate */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.716 -0500", hash_original_method = "4CE2D1F4C1C2D74BBC9BDD8F112E8266", hash_generated_method = "2DF6E57612A3447A887AE56C7D8A9376")
    
private DdmHandleExit() {}

    /**
     * Called when the DDM server connects.  The handler is allowed to
     * send messages to the server.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.721 -0500", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "B371B1A5EBF86980C6290FA035BAE684")
    
public void connected() {}

    /**
     * Called when the DDM server disconnects.  Can be used to disable
     * periodic transmissions or clean up saved state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.723 -0500", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "5061C51BA9AB55A45A330545ECB336D2")
    
public void disconnected() {}

    /**
     * Handle a chunk of data.  We're only registered for "EXIT".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.725 -0500", hash_original_method = "82AA707C3D594DFF9A299AE775B6B0C9", hash_generated_method = "98E6B087723D101A0E68731DFDBCE4D0")
    
public Chunk handleChunk(Chunk request) {
        if (false)
            Log.v("ddm-exit", "Handling " + name(request.type) + " chunk");

        /*
         * Process the request.
         */
        ByteBuffer in = wrapChunk(request);

        int statusCode = in.getInt();

        Runtime.getRuntime().halt(statusCode);

        // if that doesn't work, return an empty message
        return null;
    }
}

