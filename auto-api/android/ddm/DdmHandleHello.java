package android.ddm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;
import android.util.Log;
import android.os.Debug;
import java.nio.ByteBuffer;

public class DdmHandleHello extends ChunkHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.989 -0400", hash_original_method = "7D5B1A101327E53BA05D666FE17BE587", hash_generated_method = "2E100489FD6DDE0FDD214C08AF626324")
    private  DdmHandleHello() {
        
    }

    
    @DSModeled(DSC.SAFE)
    public static void register() {
        DdmServer.registerHandler(CHUNK_HELO, mInstance);
        DdmServer.registerHandler(CHUNK_FEAT, mInstance);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.990 -0400", hash_original_method = "9DD1D58A13546676FF124C2FF2506A7B", hash_generated_method = "EC3A6E5AE4B600D0DD21C3E5AA4E4720")
    public void connected() {
        {
            byte[] data = new byte[] { 0, 1, 2, 3, 4, -4, -3, -2, -1, 127 };
            Chunk testChunk = new Chunk(ChunkHandler.type("TEST"), data, 1, data.length-2);
            DdmServer.sendChunk(testChunk);
        } 
        
        
            
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.991 -0400", hash_original_method = "AD032216A82F0FAAB91D671673032B40", hash_generated_method = "8D5A1BE7E46D89F62382E2475FB8C198")
    public void disconnected() {
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.992 -0400", hash_original_method = "D81BC51C8CC9A87BC96AD49CBC27557B", hash_generated_method = "17F2BB3A912179B1FD1B60F68B59CE9E")
    public Chunk handleChunk(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1562998762 = null; 
        Chunk varB4EAC82CA7396A68D541C85D26508E83_801993394 = null; 
        int type = request.type;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1562998762 = handleHELO(request);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_801993394 = handleFEAT(request);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
        } 
        addTaint(request.getTaint());
        Chunk varA7E53CE21691AB073D9660D615818899_1774895983; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1774895983 = varB4EAC82CA7396A68D541C85D26508E83_1562998762;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1774895983 = varB4EAC82CA7396A68D541C85D26508E83_801993394;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1774895983.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1774895983;
        
        
            
        
        
            
        
            
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.993 -0400", hash_original_method = "DA2CEBE94E81B4AF53080A8A1470F538", hash_generated_method = "662CF6526864CB3BDEDCC3E03CF5C0F2")
    private Chunk handleHELO(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_325357718 = null; 
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1363758461 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_325357718 = createFailChunk(123, "This is a test");
        ByteBuffer in = wrapChunk(request);
        int serverProtoVers = in.getInt();
        String vmName = System.getProperty("java.vm.name", "?");
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
        {
            boolean var75D5FC25CCF0C92CFFFDE18629718BBF_1087519106 = (Debug.waitingForDebugger());
            sendWAIT(0);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1363758461 = reply;
        addTaint(request.getTaint());
        Chunk varA7E53CE21691AB073D9660D615818899_1541835222; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1541835222 = varB4EAC82CA7396A68D541C85D26508E83_325357718;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1541835222 = varB4EAC82CA7396A68D541C85D26508E83_1363758461;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1541835222.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1541835222;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.994 -0400", hash_original_method = "4DE14E90C721327585D89816C2D399A5", hash_generated_method = "89064A2B2BF2DB9E51902CA06A83AEC7")
    private Chunk handleFEAT(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_438713761 = null; 
        final String[] features = Debug.getVmFeatureList();
        int size = 4 + 4 * features.length;
        {
            int i = features.length-1;
            size += features[i].length() * 2;
        } 
        ByteBuffer out = ByteBuffer.allocate(size);
        out.order(ChunkHandler.CHUNK_ORDER);
        out.putInt(features.length);
        {
            int i = features.length-1;
            {
                out.putInt(features[i].length());
                putString(out, features[i]);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_438713761 = new Chunk(CHUNK_FEAT, out);
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_438713761.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_438713761;
        
        
        
            
        
        
            
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static void sendWAIT(int reason) {
        byte[] data = new byte[] { (byte) reason };
        Chunk waitChunk = new Chunk(CHUNK_WAIT, data, 0, 1);
        DdmServer.sendChunk(waitChunk);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.994 -0400", hash_original_field = "9E73CF887D3BEE7D1EC552ABB1CEC88D", hash_generated_field = "4B98D36A3B1780A91D979CD0DB32E544")

    public static final int CHUNK_HELO = type("HELO");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.994 -0400", hash_original_field = "793576DB5C7985B2CF90EA800F003D17", hash_generated_field = "F10D1B8DFFE546DA4FB9F20A975811FA")

    public static final int CHUNK_WAIT = type("WAIT");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.995 -0400", hash_original_field = "4438E9F027258B7227178624C6715CE0", hash_generated_field = "2322DA1CA72C278933263456F1066D5E")

    public static final int CHUNK_FEAT = type("FEAT");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.995 -0400", hash_original_field = "8619BE9DDB4E279E9B5DF6F337B7EAFD", hash_generated_field = "195EB1E12A6D4D5D000F29C48DB2AFBC")

    private static DdmHandleHello mInstance = new DdmHandleHello();
}

