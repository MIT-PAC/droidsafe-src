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
import android.os.Debug;
import java.nio.ByteBuffer;

public class DdmHandleHello extends ChunkHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.948 -0400", hash_original_method = "7D5B1A101327E53BA05D666FE17BE587", hash_generated_method = "2E100489FD6DDE0FDD214C08AF626324")
    @DSModeled(DSC.SAFE)
    private DdmHandleHello() {
        // ---------- Original Method ----------
    }

    
        public static void register() {
        DdmServer.registerHandler(CHUNK_HELO, mInstance);
        DdmServer.registerHandler(CHUNK_FEAT, mInstance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.949 -0400", hash_original_method = "9DD1D58A13546676FF124C2FF2506A7B", hash_generated_method = "63DD3D4F35DF35C6F01DF099283CBE6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void connected() {
        {
            byte[] data;
            data = new byte[] { 0, 1, 2, 3, 4, -4, -3, -2, -1, 127 };
            Chunk testChunk;
            testChunk = new Chunk(ChunkHandler.type("TEST"), data, 1, data.length-2);
            DdmServer.sendChunk(testChunk);
        } //End block
        // ---------- Original Method ----------
        //if (false)
            //Log.v("ddm-hello", "Connected!");
        //if (false) {
            //byte[] data = new byte[] { 0, 1, 2, 3, 4, -4, -3, -2, -1, 127 };
            //Chunk testChunk =
                //new Chunk(ChunkHandler.type("TEST"), data, 1, data.length-2);
            //DdmServer.sendChunk(testChunk);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.949 -0400", hash_original_method = "AD032216A82F0FAAB91D671673032B40", hash_generated_method = "8D5A1BE7E46D89F62382E2475FB8C198")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void disconnected() {
        // ---------- Original Method ----------
        //if (false)
            //Log.v("ddm-hello", "Disconnected!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.949 -0400", hash_original_method = "D81BC51C8CC9A87BC96AD49CBC27557B", hash_generated_method = "352F3087737F620006DDEC36F7EB2EB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Chunk handleChunk(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        int type;
        type = request.type;
        {
            Chunk var273586091861607A8CBD181D160EE7BB_225582962 = (handleHELO(request));
        } //End block
        {
            Chunk var5EFFB46FE4DCB595224EB3C9BB8C6394_94789012 = (handleFEAT(request));
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
        } //End block
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (false)
            //Log.v("ddm-heap", "Handling " + name(request.type) + " chunk");
        //int type = request.type;
        //if (type == CHUNK_HELO) {
            //return handleHELO(request);
        //} else if (type == CHUNK_FEAT) {
            //return handleFEAT(request);
        //} else {
            //throw new RuntimeException("Unknown packet "
                //+ ChunkHandler.name(type));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.950 -0400", hash_original_method = "DA2CEBE94E81B4AF53080A8A1470F538", hash_generated_method = "A88496AE998032651752038B3A3AF3DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk handleHELO(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        Chunk var6584F7DD2BCAAC0F42D65D53067388EE_1810248853 = (createFailChunk(123, "This is a test"));
        ByteBuffer in;
        in = wrapChunk(request);
        int serverProtoVers;
        serverProtoVers = in.getInt();
        String vmName;
        vmName = System.getProperty("java.vm.name", "?");
        String vmVersion;
        vmVersion = System.getProperty("java.vm.version", "?");
        String vmIdent;
        vmIdent = vmName + " v" + vmVersion;
        String appName;
        appName = DdmHandleAppName.getAppName();
        ByteBuffer out;
        out = ByteBuffer.allocate(16
                            + vmIdent.length()*2 + appName.length()*2);
        out.order(ChunkHandler.CHUNK_ORDER);
        out.putInt(DdmServer.CLIENT_PROTOCOL_VERSION);
        out.putInt(android.os.Process.myPid());
        out.putInt(vmIdent.length());
        out.putInt(appName.length());
        putString(out, vmIdent);
        putString(out, appName);
        Chunk reply;
        reply = new Chunk(CHUNK_HELO, out);
        {
            boolean var75D5FC25CCF0C92CFFFDE18629718BBF_947743241 = (Debug.waitingForDebugger());
            sendWAIT(0);
        } //End collapsed parenthetic
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.953 -0400", hash_original_method = "4DE14E90C721327585D89816C2D399A5", hash_generated_method = "DD57B574BFF7533B2E0FE97A3A41F604")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk handleFEAT(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        String[] features;
        features = Debug.getVmFeatureList();
        int size;
        size = 4 + 4 * features.length;
        {
            int i;
            i = features.length-1;
            size += features[i].length() * 2;
        } //End collapsed parenthetic
        ByteBuffer out;
        out = ByteBuffer.allocate(size);
        out.order(ChunkHandler.CHUNK_ORDER);
        out.putInt(features.length);
        {
            int i;
            i = features.length-1;
            {
                out.putInt(features[i].length());
                putString(out, features[i]);
            } //End block
        } //End collapsed parenthetic
        Chunk var82D6074A720CB2B61CF4F7681B0790C3_1879364525 = (new Chunk(CHUNK_FEAT, out));
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final String[] features = Debug.getVmFeatureList();
        //if (false)
            //Log.v("ddm-heap", "Got feature list request");
        //int size = 4 + 4 * features.length;
        //for (int i = features.length-1; i >= 0; i--)
            //size += features[i].length() * 2;
        //ByteBuffer out = ByteBuffer.allocate(size);
        //out.order(ChunkHandler.CHUNK_ORDER);
        //out.putInt(features.length);
        //for (int i = features.length-1; i >= 0; i--) {
            //out.putInt(features[i].length());
            //putString(out, features[i]);
        //}
        //return new Chunk(CHUNK_FEAT, out);
    }

    
        public static void sendWAIT(int reason) {
        byte[] data = new byte[] { (byte) reason };
        Chunk waitChunk = new Chunk(CHUNK_WAIT, data, 0, 1);
        DdmServer.sendChunk(waitChunk);
    }

    
    public static final int CHUNK_HELO = type("HELO");
    public static final int CHUNK_WAIT = type("WAIT");
    public static final int CHUNK_FEAT = type("FEAT");
    private static DdmHandleHello mInstance = new DdmHandleHello();
}

