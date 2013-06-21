package com.android.internal.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.197 -0400", hash_original_method = "3A09952A57DC82982F9A784901083676", hash_generated_method = "3A09952A57DC82982F9A784901083676")
        public BinderInternal ()
    {
    }


        public static final void joinThreadPool() {
    }

    
        public static long getLastGcTime() {
        return mLastGcTime;
    }

    
        public static final IBinder getContextObject() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static final void disableBackgroundScheduling(boolean disable) {
    }

    
        static final void handleGc() {
    }

    
        public static void forceGc(String reason) {
        EventLog.writeEvent(2741, reason);
        Runtime.getRuntime().gc();
    }

    
        static void forceBinderGc() {
        forceGc("Binder");
    }

    
    static final class GcWatcher {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.198 -0400", hash_original_method = "96560BBD16021BC74A0381A53C5F8BB4", hash_generated_method = "96560BBD16021BC74A0381A53C5F8BB4")
                public GcWatcher ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.198 -0400", hash_original_method = "D42E2C52A602997A5DDE899C13954EBC", hash_generated_method = "B4840BBAE77128E6C2E9444A36D72BDC")
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


    
    static WeakReference<GcWatcher> mGcWatcher
            = new WeakReference<GcWatcher>(new GcWatcher());
    static long mLastGcTime;
}

