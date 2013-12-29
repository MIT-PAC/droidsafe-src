package android.ddm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.harmony.dalvik.ddmc.DdmServer;

import android.util.Log;


public class DdmRegister {

    /**
     * Register handlers for all known chunk types.
     *
     * If you write a handler, add a registration call here.
     *
     * Note that this is invoked by the application (usually through a
     * static initializer in the main class), not the VM.  It's done this
     * way so that the handlers can use Android classes with native calls
     * that aren't registered until after the VM is initialized (e.g.
     * logging).  It also allows debugging of DDM handler initialization.
     *
     * The chunk dispatcher will pause until we call registrationComplete(),
     * so that we don't have a race that causes us to drop packets before
     * we finish here.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.081 -0500", hash_original_method = "0DBD2DB13D23998CD61361463D21566E", hash_generated_method = "E33EB1237E6138E6794C576FE6A01A09")
    public static void registerHandlers() {
        if (false)
            Log.v("ddm", "Registering DDM message handlers");
        DdmHandleHello.register();
        DdmHandleThread.register();
        DdmHandleHeap.register();
        DdmHandleNativeHeap.register();
        DdmHandleProfiling.register();
        DdmHandleExit.register();

        DdmServer.registrationComplete();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.080 -0500", hash_original_method = "7B8C628EED4FBAEB3F2321039DB7D59A", hash_generated_method = "BD6F90C15B5A507D2DACDA65C5C77EF3")
    private DdmRegister() {}

    
}

