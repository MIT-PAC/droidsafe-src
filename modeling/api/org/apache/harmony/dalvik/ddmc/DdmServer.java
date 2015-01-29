package org.apache.harmony.dalvik.ddmc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class DdmServer {

    /**
     * Register an instance of the ChunkHandler class to handle a specific
     * chunk type.
     *
     * Throws an exception if the type already has a handler registered.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.276 -0500", hash_original_method = "5FE21C0D4C27ADA98D267B634214C4D7", hash_generated_method = "E65D98A0F413DD17CCBE36D5733E81B4")
    
public static void registerHandler(int type, ChunkHandler handler) {
        if (handler == null)
            throw new NullPointerException();

        synchronized (mHandlerMap) {
            if (mHandlerMap.get(type) != null)
                throw new RuntimeException("type " + Integer.toHexString(type)
                    + " already registered");

            mHandlerMap.put(type, handler);
        }
    }

    /**
     * Unregister the existing handler for the specified type.
     *
     * Returns the old handler.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.278 -0500", hash_original_method = "2B1F18D21EF22A7C16D1B3CB473E2A62", hash_generated_method = "F7188F538E7D69EC5F93943D80374E1C")
    
public static ChunkHandler unregisterHandler(int type) {
        synchronized (mHandlerMap) {
            return mHandlerMap.remove(type);
        }
    }

    /**
     * The application must call here after it finishes registering
     * handlers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.281 -0500", hash_original_method = "8F9A0D25038BAA53AA87BFFA0D47316A", hash_generated_method = "D647B858B68B1333AC193E85FEBDEE73")
    
public static void registrationComplete() {
        // sync on mHandlerMap because it's convenient and makes a kind of
        // sense
        synchronized (mHandlerMap) {
            mRegistrationComplete = true;
            mHandlerMap.notifyAll();
        }
    }

    /**
     * Send a chunk of data to the DDM server.  This takes the form of a
     * JDWP "event", which does not elicit a response from the server.
     *
     * Use this for "unsolicited" chunks.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.283 -0500", hash_original_method = "EBADA8E6A033ED1A993056B3CF09CD35", hash_generated_method = "E119E48E0BE158352AE1A5B952E1482D")
    
public static void sendChunk(Chunk chunk) {
        nativeSendChunk(chunk.type, chunk.data, chunk.offset, chunk.length);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeSendChunk(int type, byte[] data,
        int offset, int length) {
    }

    /*
     * Called by the VM when the DDM server connects or disconnects.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.289 -0500", hash_original_method = "1D9D6AE09D825D5EE0A0437033119805", hash_generated_method = "DB00933F8902351F6F93839272FEEA95")
    
private static void broadcast(int event)
    {
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

    /*
     * This is called by the VM when a chunk arrives.
     *
     * For a DDM-aware application, we want to wait until the app has had
     * a chance to register all of its chunk handlers.  Otherwise, we'll
     * end up dropping early-arriving packets on the floor.
     *
     * For a non-DDM-aware application, we'll end up waiting here forever
     * if DDMS happens to connect.  It's hard to know for sure that
     * registration isn't going to happen, so we settle for a timeout.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.292 -0500", hash_original_method = "BE94F4AC1571A07221102CE5852A3145", hash_generated_method = "15E80EC82FBDA1A11F6C8996BC93F269")
    
private static Chunk dispatch(int type, byte[] data, int offset, int length)
    {
        ChunkHandler handler;

        synchronized (mHandlerMap) {
            /*
             * If registration hasn't completed, and we haven't timed out
             * waiting for it, wait a bit.
             */
            while (!mRegistrationComplete && !mRegistrationTimedOut) {
                //System.out.println("dispatch() waiting for reg");
                try {
                    mHandlerMap.wait(1000);     // 1.0 sec
                } catch (InterruptedException ie) {
                    continue;
                }

                if (!mRegistrationComplete) {
                    /* timed out, don't wait again */
                    mRegistrationTimedOut = true;
                }
            }

            handler = mHandlerMap.get(type);
        }
        //System.out.println(" dispatch cont");

        if (handler == null) {
            return null;
        }

        Chunk chunk = new Chunk(type, data, offset, length);
        return handler.handleChunk(chunk);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.259 -0500", hash_original_field = "40220C5D99DC4A6E0BACC53D2F1E1AB5", hash_generated_field = "5FAF1EABF3BF0FF4FAAA74FCD0900241")

    public static final int CLIENT_PROTOCOL_VERSION = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.261 -0500", hash_original_field = "9F28FC2067283173910F01A08E5DC5C5", hash_generated_field = "0231B9C20A9E58F35AC886FF452B592A")

    private static HashMap<Integer,ChunkHandler> mHandlerMap =
        new HashMap<Integer,ChunkHandler>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.264 -0500", hash_original_field = "5D0F047B71C83FA29386D4B84FA544A5", hash_generated_field = "1C3D5BB045FFA99F2E9AAC7EB29859DC")

    private static final int CONNECTED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.266 -0500", hash_original_field = "703092D71BD019F11F5C57D647FF478A", hash_generated_field = "527138459F3479DCAFBE83E5908CEC25")

    private static final int DISCONNECTED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.269 -0500", hash_original_field = "15FBA5DEC4C83825460D5B43FD731DB0", hash_generated_field = "86C698E9C872D3EDDE75CC0544089DAE")

    private static volatile boolean mRegistrationComplete = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.271 -0500", hash_original_field = "FCE7BF3F1BF572ADA9E77D7C32E4AEB7", hash_generated_field = "FE0904AAA0780F2521F9B3FD6D86F581")

    private static boolean mRegistrationTimedOut = false;

    /**
     * Don't instantiate; all members and methods are static.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.274 -0500", hash_original_method = "9245089A3DC1CB81EAEF9FD5F462A315", hash_generated_method = "55622FB3A2216EBA0977FFD151FF7F19")
    
private DdmServer() {}
}

