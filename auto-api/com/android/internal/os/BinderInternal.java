package com.android.internal.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.468 -0400", hash_original_method = "574B8095C5FEB674167544EA24FDCEF4", hash_generated_method = "574B8095C5FEB674167544EA24FDCEF4")
    public BinderInternal ()
    {
        
    }


    public static final void joinThreadPool() {
    }

    
    @DSModeled(DSC.SAFE)
    public static long getLastGcTime() {
        return mLastGcTime;
    }

    
    public static final IBinder getContextObject() {
    	return new Binder();
    }

    
    public static final void disableBackgroundScheduling(boolean disable) {
    }

    
    static final void handleGc() {
    }

    
    @DSModeled(DSC.SAFE)
    public static void forceGc(String reason) {
        EventLog.writeEvent(2741, reason);
        Runtime.getRuntime().gc();
    }

    
    @DSModeled(DSC.SAFE)
    static void forceBinderGc() {
        forceGc("Binder");
    }

    
    static final class GcWatcher {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.470 -0400", hash_original_method = "23BF1C701EF3B7F131F4805BD4892CC0", hash_generated_method = "23BF1C701EF3B7F131F4805BD4892CC0")
        public GcWatcher ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.470 -0400", hash_original_method = "D42E2C52A602997A5DDE899C13954EBC", hash_generated_method = "B4840BBAE77128E6C2E9444A36D72BDC")
        @Override
        protected void finalize() throws Throwable {
            handleGc();
            mLastGcTime = SystemClock.uptimeMillis();
            mGcWatcher = new WeakReference<GcWatcher>(new GcWatcher());
            
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.470 -0400", hash_original_field = "48E7343D1D845514D6E442A88C67AA87", hash_generated_field = "4909DFFCC1B301559EF73389910CBE90")

    static WeakReference<GcWatcher> mGcWatcher = new WeakReference<GcWatcher>(new GcWatcher());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.470 -0400", hash_original_field = "83E72B9F639340BDD052AB753A2F3F1B", hash_generated_field = "D78279B3A9A95C1743A81AEED357F5B0")

    static long mLastGcTime;
}

