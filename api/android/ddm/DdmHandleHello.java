package android.ddm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;
import android.util.Log;
import android.os.Debug;
import java.nio.ByteBuffer;

public class DdmHandleHello extends ChunkHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.395 -0400", hash_original_method = "7D5B1A101327E53BA05D666FE17BE587", hash_generated_method = "2E100489FD6DDE0FDD214C08AF626324")
    private  DdmHandleHello() {
        // ---------- Original Method ----------
    }

    
        public static void register() {
        DdmServer.registerHandler(CHUNK_HELO, mInstance);
        DdmServer.registerHandler(CHUNK_FEAT, mInstance);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.404 -0400", hash_original_method = "9DD1D58A13546676FF124C2FF2506A7B", hash_generated_method = "6CE37724AE0083884DDE3D0CBA98B41E")
    public void connected() {
    if(false){ }    if(false)        
        {
            byte[] data = new byte[] { 0, 1, 2, 3, 4, -4, -3, -2, -1, 127 };
            Chunk testChunk = new Chunk(ChunkHandler.type("TEST"), data, 1, data.length-2);
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.404 -0400", hash_original_method = "AD032216A82F0FAAB91D671673032B40", hash_generated_method = "724F573DE5EAD38B73223912FC0DFFE3")
    public void disconnected() {
    if(false){ }
        // ---------- Original Method ----------
        //if (false)
            //Log.v("ddm-hello", "Disconnected!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.405 -0400", hash_original_method = "D81BC51C8CC9A87BC96AD49CBC27557B", hash_generated_method = "3755B5E7F3485EA0D37743FA0A3A2601")
    public Chunk handleChunk(Chunk request) {
        addTaint(request.getTaint());
    if(false){ }        int type = request.type;
    if(type == CHUNK_HELO)        
        {
Chunk varC88444C3F621E1D7BACD0AF108076C6D_396328306 =             handleHELO(request);
            varC88444C3F621E1D7BACD0AF108076C6D_396328306.addTaint(taint);
            return varC88444C3F621E1D7BACD0AF108076C6D_396328306;
        } //End block
        else
    if(type == CHUNK_FEAT)        
        {
Chunk var94F94D2E0660C50518BB0127ED1E85C0_1714861225 =             handleFEAT(request);
            var94F94D2E0660C50518BB0127ED1E85C0_1714861225.addTaint(taint);
            return var94F94D2E0660C50518BB0127ED1E85C0_1714861225;
        } //End block
        else
        {
            RuntimeException var87CCC2E1E27D81731A9B6FB9950FC20F_1574541776 = new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
            var87CCC2E1E27D81731A9B6FB9950FC20F_1574541776.addTaint(taint);
            throw var87CCC2E1E27D81731A9B6FB9950FC20F_1574541776;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.406 -0400", hash_original_method = "DA2CEBE94E81B4AF53080A8A1470F538", hash_generated_method = "1B1B9DC0185DCB55A175523EF0C0B794")
    private Chunk handleHELO(Chunk request) {
        addTaint(request.getTaint());
    if(false)        
        {
Chunk varF39C305A35AE8FFAE7A86EF1281C4BC8_1344909944 =         createFailChunk(123, "This is a test");
        varF39C305A35AE8FFAE7A86EF1281C4BC8_1344909944.addTaint(taint);
        return varF39C305A35AE8FFAE7A86EF1281C4BC8_1344909944;
        }
        ByteBuffer in = wrapChunk(request);
        int serverProtoVers = in.getInt();
    if(false){ }        String vmName = System.getProperty("java.vm.name", "?");
        String vmVersion = System.getProperty("java.vm.version", "?");
        String vmIdent = vmName + " v" + vmVersion;
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
    if(Debug.waitingForDebugger())        
        sendWAIT(0);
Chunk var1BC29E376418A8DFBC75319DBDA8D7C9_489130082 =         reply;
        var1BC29E376418A8DFBC75319DBDA8D7C9_489130082.addTaint(taint);
        return var1BC29E376418A8DFBC75319DBDA8D7C9_489130082;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.407 -0400", hash_original_method = "4DE14E90C721327585D89816C2D399A5", hash_generated_method = "0F61B6117B1650A40DBC1E1981D67524")
    private Chunk handleFEAT(Chunk request) {
        addTaint(request.getTaint());
        final String[] features = Debug.getVmFeatureList();
    if(false){ }        int size = 4 + 4 * features.length;
for(int i = features.length-1;i >= 0;i--)
        size += features[i].length() * 2;
        ByteBuffer out = ByteBuffer.allocate(size);
        out.order(ChunkHandler.CHUNK_ORDER);
        out.putInt(features.length);
for(int i = features.length-1;i >= 0;i--)
        {
            out.putInt(features[i].length());
            putString(out, features[i]);
        } //End block
Chunk var8362A517DEE3C28BB05B9DD441885064_1366222868 =         new Chunk(CHUNK_FEAT, out);
        var8362A517DEE3C28BB05B9DD441885064_1366222868.addTaint(taint);
        return var8362A517DEE3C28BB05B9DD441885064_1366222868;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.408 -0400", hash_original_field = "9E73CF887D3BEE7D1EC552ABB1CEC88D", hash_generated_field = "4B98D36A3B1780A91D979CD0DB32E544")

    public static final int CHUNK_HELO = type("HELO");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.408 -0400", hash_original_field = "793576DB5C7985B2CF90EA800F003D17", hash_generated_field = "F10D1B8DFFE546DA4FB9F20A975811FA")

    public static final int CHUNK_WAIT = type("WAIT");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.408 -0400", hash_original_field = "4438E9F027258B7227178624C6715CE0", hash_generated_field = "2322DA1CA72C278933263456F1066D5E")

    public static final int CHUNK_FEAT = type("FEAT");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.408 -0400", hash_original_field = "8619BE9DDB4E279E9B5DF6F337B7EAFD", hash_generated_field = "195EB1E12A6D4D5D000F29C48DB2AFBC")

    private static DdmHandleHello mInstance = new DdmHandleHello();
}

