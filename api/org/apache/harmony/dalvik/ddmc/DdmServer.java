package org.apache.harmony.dalvik.ddmc;

// Droidsafe Imports
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DdmServer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.868 -0400", hash_original_method = "9245089A3DC1CB81EAEF9FD5F462A315", hash_generated_method = "285A1E98A8D6D11E80518C3C162413CF")
    private  DdmServer() {
        // ---------- Original Method ----------
    }

    
    public static void registerHandler(int type, ChunkHandler handler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        if (handler == null)
            throw new NullPointerException();
        synchronized (mHandlerMap) {
            if (mHandlerMap.get(type) != null)
                throw new RuntimeException("type " + Integer.toHexString(type)
                    + " already registered");
            mHandlerMap.put(type, handler);
        }
    }

    
    public static ChunkHandler unregisterHandler(int type) {
        synchronized (mHandlerMap) {
            return mHandlerMap.remove(type);
        }
    }

    
    public static void registrationComplete() {
        synchronized (mHandlerMap) {
            mRegistrationComplete = true;
            mHandlerMap.notifyAll();
        }
    }

    
    public static void sendChunk(Chunk chunk) {
        nativeSendChunk(chunk.type, chunk.data, chunk.offset, chunk.length);
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeSendChunk(int type, byte[] data,
        int offset, int length) {
    }

    
    private static void broadcast(int event) {
        synchronized (mHandlerMap) {
            Collection values = mHandlerMap.values();
            Iterator iter = values.iterator();
            while (iter.hasNext()) {
                ChunkHandler handler = (ChunkHandler) iter.next();
                switch (event) {
                    case CONNECTED:
                        handler.connected();
                        break;
                    case DISCONNECTED:
                        handler.disconnected();
                        break;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }
    }

    
    private static Chunk dispatch(int type, byte[] data, int offset, int length) {
        ChunkHandler handler;
        synchronized (mHandlerMap) {
            while (!mRegistrationComplete && !mRegistrationTimedOut) {
                try {
                    mHandlerMap.wait(1000);     
                } catch (InterruptedException ie) {
                    continue;
                }
                if (!mRegistrationComplete) {
                    mRegistrationTimedOut = true;
                }
            }
            handler = mHandlerMap.get(type);
        }
        if (handler == null) {
            return null;
        }
        Chunk chunk = new Chunk(type, data, offset, length);
        return handler.handleChunk(chunk);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.868 -0400", hash_original_field = "E9FF7152F6CB8776A9850B3D827C18F3", hash_generated_field = "5FAF1EABF3BF0FF4FAAA74FCD0900241")

    public static final int CLIENT_PROTOCOL_VERSION = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.868 -0400", hash_original_field = "DB495AAAFEF863DC084CF0532CBB0ACF", hash_generated_field = "0231B9C20A9E58F35AC886FF452B592A")

    private static HashMap<Integer,ChunkHandler> mHandlerMap = new HashMap<Integer,ChunkHandler>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.868 -0400", hash_original_field = "DBD9C35342D83985B0F7ABE1411252FB", hash_generated_field = "1C3D5BB045FFA99F2E9AAC7EB29859DC")

    private static final int CONNECTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.868 -0400", hash_original_field = "D465D1A9F5113A12ED0EEE14EA195161", hash_generated_field = "527138459F3479DCAFBE83E5908CEC25")

    private static final int DISCONNECTED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.869 -0400", hash_original_field = "15E45E5636417A0878F668156B04F07A", hash_generated_field = "86C698E9C872D3EDDE75CC0544089DAE")

    private static volatile boolean mRegistrationComplete = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.869 -0400", hash_original_field = "81B8BD460488DFE1C3FAB3BCAA5CA490", hash_generated_field = "FE0904AAA0780F2521F9B3FD6D86F581")

    private static boolean mRegistrationTimedOut = false;
}

