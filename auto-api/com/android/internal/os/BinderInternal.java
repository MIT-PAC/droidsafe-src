package com.android.internal.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.EventLog;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Modifier;

public class BinderInternal {
    static WeakReference<GcWatcher> mGcWatcher
            = new WeakReference<GcWatcher>(new GcWatcher());
    static long mLastGcTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.485 -0400", hash_original_method = "EFAEF866E392CFE9D06D530B612DCBC0", hash_generated_method = "00D2F864834569F64735BEABC1AFC69A")
    public static final void joinThreadPool() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.485 -0400", hash_original_method = "97EE1367F7D21A2061B5C261F1E7F987", hash_generated_method = "93E1464CFF71D32450A26A70F1E8933A")
    public static long getLastGcTime() {
        return mLastGcTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.485 -0400", hash_original_method = "4B0286DE783A8C941CE660682856A17F", hash_generated_method = "80AD47B1C831C5A6063448868817EC32")
    public static final IBinder getContextObject() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.485 -0400", hash_original_method = "D389C5CBCDBF2FA610DEE16A3525E61B", hash_generated_method = "DBAAC9A28FCBA314A07035053DACB98B")
    public static final void disableBackgroundScheduling(boolean disable) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.485 -0400", hash_original_method = "46F5A407810399C49FB84B04D36ABEA9", hash_generated_method = "185A87EA7B6F4D462158BC08069D9382")
    static final void handleGc() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.485 -0400", hash_original_method = "C06A63825025685CD72A0C7EB0DA954F", hash_generated_method = "2A120C37FE09D2BBCA349EC198BD8790")
    public static void forceGc(String reason) {
        EventLog.writeEvent(2741, reason);
        Runtime.getRuntime().gc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.485 -0400", hash_original_method = "C8BAA80AD02F89B5235BAA5DBC498303", hash_generated_method = "9FA534FAAC552D584AAD550252C07FB9")
    static void forceBinderGc() {
        forceGc("Binder");
    }

    
    static final class GcWatcher {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.485 -0400", hash_original_method = "D42E2C52A602997A5DDE899C13954EBC", hash_generated_method = "A3EE5086FF64DAF000F6C0A8BA96F088")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void finalize() throws Throwable {
            handleGc();
            mLastGcTime = SystemClock.uptimeMillis();
            mGcWatcher = new WeakReference<GcWatcher>(new GcWatcher());
            // ---------- Original Method ----------
            //handleGc();
            //mLastGcTime = SystemClock.uptimeMillis();
            //mGcWatcher = new WeakReference<GcWatcher>(new GcWatcher());
        }

        
    }


    
}


