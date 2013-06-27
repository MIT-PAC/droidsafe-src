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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.636 -0400", hash_original_method = "4CE2D1F4C1C2D74BBC9BDD8F112E8266", hash_generated_method = "E1D802991165E9F58003EAF806F78F0E")
    private  DdmHandleExit() {
        // ---------- Original Method ----------
    }

    
        public static void register() {
        DdmServer.registerHandler(CHUNK_EXIT, mInstance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.637 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    public void connected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.641 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    public void disconnected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.656 -0400", hash_original_method = "82AA707C3D594DFF9A299AE775B6B0C9", hash_generated_method = "ECA1CE2C31F7FAC0C1967FC154D7FDF5")
    public Chunk handleChunk(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_874477542 = null; //Variable for return #1
        ByteBuffer in;
        in = wrapChunk(request);
        int statusCode;
        statusCode = in.getInt();
        Runtime.getRuntime().halt(statusCode);
        varB4EAC82CA7396A68D541C85D26508E83_874477542 = null;
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_874477542.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_874477542;
        // ---------- Original Method ----------
        //if (false)
            //Log.v("ddm-exit", "Handling " + name(request.type) + " chunk");
        //ByteBuffer in = wrapChunk(request);
        //int statusCode = in.getInt();
        //Runtime.getRuntime().halt(statusCode);
        //return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.657 -0400", hash_original_field = "9C2D1D219ADFA92F41C9C1232643CA15", hash_generated_field = "DAAD47F6FA6C4CC32717481A9CF9A22B")

    public static final int CHUNK_EXIT = type("EXIT");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.657 -0400", hash_original_field = "1E74222B4CCB7C07805D4174191619EA", hash_generated_field = "5929389BB4771070576D8746DF348AC9")

    private static DdmHandleExit mInstance = new DdmHandleExit();
}

