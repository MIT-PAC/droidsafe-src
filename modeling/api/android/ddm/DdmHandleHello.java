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

public class DdmHandleHello extends ChunkHandler {

    /**
     * Register for the messages we're interested in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.053 -0500", hash_original_method = "EEDFE0453AAAF2A630A301400F88A0DB", hash_generated_method = "E90D1453F700D1C14BCE902B1840D5A8")
    
public static void register() {
        DdmServer.registerHandler(CHUNK_HELO, mInstance);
        DdmServer.registerHandler(CHUNK_FEAT, mInstance);
    }

    /**
     * Send up a WAIT chunk.  The only currently defined value for "reason"
     * is zero, which means "waiting for a debugger".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.069 -0500", hash_original_method = "17D65811F27D632AD8074884F8FAAE6B", hash_generated_method = "1E8A2A076D95CC120933A0AE6B79F807")
    
public static void sendWAIT(int reason) {
        byte[] data = new byte[] { (byte) reason };
        Chunk waitChunk = new Chunk(CHUNK_WAIT, data, 0, 1);
        DdmServer.sendChunk(waitChunk);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.042 -0500", hash_original_field = "1EBF8B4B22AED3D975C24CCFA27E2A4D", hash_generated_field = "4B98D36A3B1780A91D979CD0DB32E544")

    public static final int CHUNK_HELO = type("HELO");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.044 -0500", hash_original_field = "767D8CE5ECB38211B564E8A2CE7EB526", hash_generated_field = "F10D1B8DFFE546DA4FB9F20A975811FA")

    public static final int CHUNK_WAIT = type("WAIT");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.046 -0500", hash_original_field = "3F902E9E9208ADF9D626DBBC15F461FC", hash_generated_field = "2322DA1CA72C278933263456F1066D5E")

    public static final int CHUNK_FEAT = type("FEAT");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.049 -0500", hash_original_field = "E94886C809C2BAF59E742434EFB48926", hash_generated_field = "195EB1E12A6D4D5D000F29C48DB2AFBC")

    private static DdmHandleHello mInstance = new DdmHandleHello();

    /* singleton, do not instantiate */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.051 -0500", hash_original_method = "7D5B1A101327E53BA05D666FE17BE587", hash_generated_method = "B3EF21D4A64016488B6E8E27F567318B")
    
private DdmHandleHello() {}

    /**
     * Called when the DDM server connects.  The handler is allowed to
     * send messages to the server.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.056 -0500", hash_original_method = "9DD1D58A13546676FF124C2FF2506A7B", hash_generated_method = "5620DF64F1CF72A5E175BFB54226E9BC")
    
public void connected() {
        if (false)
            Log.v("ddm-hello", "Connected!");

        if (false) {
            /* test spontaneous transmission */
            byte[] data = new byte[] { 0, 1, 2, 3, 4, -4, -3, -2, -1, 127 };
            Chunk testChunk =
                new Chunk(ChunkHandler.type("TEST"), data, 1, data.length-2);
            DdmServer.sendChunk(testChunk);
        }
    }

    /**
     * Called when the DDM server disconnects.  Can be used to disable
     * periodic transmissions or clean up saved state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.058 -0500", hash_original_method = "AD032216A82F0FAAB91D671673032B40", hash_generated_method = "E7C35CDB9FE2C7A1F6746493D30D3D59")
    
public void disconnected() {
        if (false)
            Log.v("ddm-hello", "Disconnected!");
    }

    /**
     * Handle a chunk of data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.061 -0500", hash_original_method = "D81BC51C8CC9A87BC96AD49CBC27557B", hash_generated_method = "DD5D39A92348980EE65B4CE380CBAF60")
    
public Chunk handleChunk(Chunk request) {
        if (false)
            Log.v("ddm-heap", "Handling " + name(request.type) + " chunk");
        int type = request.type;

        if (type == CHUNK_HELO) {
            return handleHELO(request);
        } else if (type == CHUNK_FEAT) {
            return handleFEAT(request);
        } else {
            throw new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
        }
    }

    /*
     * Handle introductory packet.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.064 -0500", hash_original_method = "DA2CEBE94E81B4AF53080A8A1470F538", hash_generated_method = "A09BE666595C5D3862F362E3768BB39C")
    
private Chunk handleHELO(Chunk request) {
        if (false)
            return createFailChunk(123, "This is a test");

        /*
         * Process the request.
         */
        ByteBuffer in = wrapChunk(request);

        int serverProtoVers = in.getInt();
        if (false)
            Log.v("ddm-hello", "Server version is " + serverProtoVers);

        /*
         * Create a response.
         */
        String vmName = System.getProperty("java.vm.name", "?");
        String vmVersion = System.getProperty("java.vm.version", "?");
        String vmIdent = vmName + " v" + vmVersion;

        //String appName = android.app.ActivityThread.currentPackageName();
        //if (appName == null)
        //    appName = "unknown";
        String appName = DdmHandleAppName.getAppName();

        ByteBuffer out = ByteBuffer.allocate(16
                            + vmIdent.length()*2 + appName.length()*2);
        out.order(ChunkHandler.CHUNK_ORDER);
        out.putInt(DdmServer.CLIENT_PROTOCOL_VERSION);
        out.putInt(android.os.Process.myPid());
        out.putInt(vmIdent.length());
        out.putInt(appName.length());
        putString(out, vmIdent);
        putString(out, appName);

        Chunk reply = new Chunk(CHUNK_HELO, out);

        /*
         * Take the opportunity to inform DDMS if we are waiting for a
         * debugger to attach.
         */
        if (Debug.waitingForDebugger())
            sendWAIT(0);

        return reply;
    }

    /*
     * Handle request for list of supported features.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.067 -0500", hash_original_method = "4DE14E90C721327585D89816C2D399A5", hash_generated_method = "F4629657738F4045746686EC80F76DEC")
    
private Chunk handleFEAT(Chunk request) {
        // TODO: query the VM to ensure that support for these features
        // is actually compiled in
        final String[] features = Debug.getVmFeatureList();

        if (false)
            Log.v("ddm-heap", "Got feature list request");

        int size = 4 + 4 * features.length;
        for (int i = features.length-1; i >= 0; i--)
            size += features[i].length() * 2;

        ByteBuffer out = ByteBuffer.allocate(size);
        out.order(ChunkHandler.CHUNK_ORDER);
        out.putInt(features.length);
        for (int i = features.length-1; i >= 0; i--) {
            out.putInt(features[i].length());
            putString(out, features[i]);
        }

        return new Chunk(CHUNK_FEAT, out);
    }
}

