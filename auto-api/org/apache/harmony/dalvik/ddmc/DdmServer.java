package org.apache.harmony.dalvik.ddmc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class DdmServer {
    public static final int CLIENT_PROTOCOL_VERSION = 1;
    private static HashMap<Integer,ChunkHandler> mHandlerMap =
        new HashMap<Integer,ChunkHandler>();
    private static final int CONNECTED = 1;
    private static final int DISCONNECTED = 2;
    private static volatile boolean mRegistrationComplete = false;
    private static boolean mRegistrationTimedOut = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.561 -0400", hash_original_method = "9245089A3DC1CB81EAEF9FD5F462A315", hash_generated_method = "DB1D6E471923CC3416014239229DBBA7")
    @DSModeled(DSC.SAFE)
    private DdmServer() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.561 -0400", hash_original_method = "5FE21C0D4C27ADA98D267B634214C4D7", hash_generated_method = "D7765D4AB1F86F79DB78E81AA5AC0AD5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.561 -0400", hash_original_method = "2B1F18D21EF22A7C16D1B3CB473E2A62", hash_generated_method = "E9775B9142699ADED141FD0ADC50842F")
    public static ChunkHandler unregisterHandler(int type) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        synchronized (mHandlerMap) {
            return mHandlerMap.remove(type);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.561 -0400", hash_original_method = "8F9A0D25038BAA53AA87BFFA0D47316A", hash_generated_method = "A481F4C304C28EED19A4A6AF01A12D40")
    public static void registrationComplete() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        synchronized (mHandlerMap) {
            mRegistrationComplete = true;
            mHandlerMap.notifyAll();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.561 -0400", hash_original_method = "EBADA8E6A033ED1A993056B3CF09CD35", hash_generated_method = "E119E48E0BE158352AE1A5B952E1482D")
    public static void sendChunk(Chunk chunk) {
        nativeSendChunk(chunk.type, chunk.data, chunk.offset, chunk.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.561 -0400", hash_original_method = "ACBA0D9D0B703A98482A3E6A2B9C384F", hash_generated_method = "39A1EBD2FF0786ED59D948DA2693D6AE")
    private static void nativeSendChunk(int type, byte[] data,
        int offset, int length) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.561 -0400", hash_original_method = "1D9D6AE09D825D5EE0A0437033119805", hash_generated_method = "DB00933F8902351F6F93839272FEEA95")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.561 -0400", hash_original_method = "BE94F4AC1571A07221102CE5852A3145", hash_generated_method = "CC580B8B6AF97BCF93FA4AF5178FE052")
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

    
}


