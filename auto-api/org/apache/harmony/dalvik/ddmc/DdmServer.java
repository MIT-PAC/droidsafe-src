package org.apache.harmony.dalvik.ddmc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class DdmServer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.788 -0400", hash_original_method = "9245089A3DC1CB81EAEF9FD5F462A315", hash_generated_method = "285A1E98A8D6D11E80518C3C162413CF")
    @DSModeled(DSC.SAFE)
    private DdmServer() {
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

    
    public static final int CLIENT_PROTOCOL_VERSION = 1;
    private static HashMap<Integer,ChunkHandler> mHandlerMap =
        new HashMap<Integer,ChunkHandler>();
    private static final int CONNECTED = 1;
    private static final int DISCONNECTED = 2;
    private static volatile boolean mRegistrationComplete = false;
    private static boolean mRegistrationTimedOut = false;
}

