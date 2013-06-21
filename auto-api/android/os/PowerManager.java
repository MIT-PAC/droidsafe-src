package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;

public class PowerManager {
    IPowerManager mService;
    Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.096 -0400", hash_original_method = "CC3F52E82947675044A40593774B54F6", hash_generated_method = "FBF57EA37BF41DE0AFD68D9E02F27504")
    @DSModeled(DSC.SAFE)
    private PowerManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.096 -0400", hash_original_method = "060274E80C670013EA8E2104C630EB40", hash_generated_method = "31950C0785BB80C04B6631E1E6FB1CDE")
    @DSModeled(DSC.SAFE)
    public PowerManager(IPowerManager service, Handler handler) {
        dsTaint.addTaint(service.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        // ---------- Original Method ----------
        //mService = service;
        //mHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.096 -0400", hash_original_method = "93AAF5370B6BA4BEAC029A2F72D16576", hash_generated_method = "900BDF1DD8FC66B2AD4B6EADE8ACAFAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WakeLock newWakeLock(int flags, String tag) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(tag);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("tag is null in PowerManager.newWakeLock");
        } //End block
        WakeLock var02A45F5503938CC9DAC40E58D0F2F3EB_1093109495 = (new WakeLock(flags, tag));
        return (WakeLock)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (tag == null) {
            //throw new NullPointerException("tag is null in PowerManager.newWakeLock");
        //}
        //return new WakeLock(flags, tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.096 -0400", hash_original_method = "C5F540EE3212366BBE1CC045B8933E13", hash_generated_method = "5F55E6AB5BB8CD0EAA924D17A6E9E3B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void userActivity(long when, boolean noChangeLights) {
        dsTaint.addTaint(noChangeLights);
        dsTaint.addTaint(when);
        try 
        {
            mService.userActivity(when, noChangeLights);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.userActivity(when, noChangeLights);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.097 -0400", hash_original_method = "CD7C7C85680B5F62F444A1BDA84407A2", hash_generated_method = "D89DB7CE43585A56AF894793F0B68F9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void goToSleep(long time) {
        dsTaint.addTaint(time);
        try 
        {
            mService.goToSleep(time);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.goToSleep(time);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.097 -0400", hash_original_method = "1657059AF219261DAAA3A6D217AB2CFE", hash_generated_method = "DACC89051CAAB40D9691AF989E6E9B5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBacklightBrightness(int brightness) {
        dsTaint.addTaint(brightness);
        try 
        {
            mService.setBacklightBrightness(brightness);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.setBacklightBrightness(brightness);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.097 -0400", hash_original_method = "3FEFDF5F90A1934664CD9ABDDAD0F802", hash_generated_method = "60861C4801F06C5491181C1EEB068930")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSupportedWakeLockFlags() {
        try 
        {
            int var523D03F3D92596C5D29B4B3F266A1185_1768598931 = (mService.getSupportedWakeLockFlags());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mService.getSupportedWakeLockFlags();
        //} catch (RemoteException e) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.098 -0400", hash_original_method = "50478742CDFBDF2C875183424E636D44", hash_generated_method = "E499F3F06D825191C923C1036FCEA410")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isScreenOn() {
        try 
        {
            boolean var3405A35E39FE7BA8C0D22FE35D82BDAA_1578377980 = (mService.isScreenOn());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.isScreenOn();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.098 -0400", hash_original_method = "35D8C90A4186EC12B6AC746434DE3AC6", hash_generated_method = "0AA874DAC9A8D9471039A2AE7F848313")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reboot(String reason) {
        dsTaint.addTaint(reason);
        try 
        {
            mService.reboot(reason);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.reboot(reason);
        //} catch (RemoteException e) {
        //}
    }

    
    public class WakeLock {
        Runnable mReleaser = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.098 -0400", hash_original_method = "EE8EB6B44C1ECA6F34C46D68F05D7353", hash_generated_method = "4FB3659F1E09722C30041C679A6091C0")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void run() {
                release();
                // ---------- Original Method ----------
                //release();
            }

            
}; //Transformed anonymous class
        int mFlags;
        String mTag;
        IBinder mToken;
        int mCount = 0;
        boolean mRefCounted = true;
        boolean mHeld = false;
        WorkSource mWorkSource;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.098 -0400", hash_original_method = "F8EACFB6990EF5D4887B3D97C67B44DC", hash_generated_method = "446425DCBC2377E7DC4EA2214AD0A143")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         WakeLock(int flags, String tag) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(tag);
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            //End case default 
            mToken = new Binder();
            // ---------- Original Method ----------
            //switch (flags & LOCK_MASK) {
            //case PARTIAL_WAKE_LOCK:
            //case SCREEN_DIM_WAKE_LOCK:
            //case SCREEN_BRIGHT_WAKE_LOCK:
            //case FULL_WAKE_LOCK:
            //case PROXIMITY_SCREEN_OFF_WAKE_LOCK:
                //break;
            //default:
                //throw new IllegalArgumentException();
            //}
            //mFlags = flags;
            //mTag = tag;
            //mToken = new Binder();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.099 -0400", hash_original_method = "C9C09C089F97F5128A15BBE86111A3BF", hash_generated_method = "AC8655E0E40A0B7837321ED6292FFDF9")
        @DSModeled(DSC.SAFE)
        public void setReferenceCounted(boolean value) {
            dsTaint.addTaint(value);
            // ---------- Original Method ----------
            //mRefCounted = value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.099 -0400", hash_original_method = "60F8C5E408EB104B9A6B83E1C96AB086", hash_generated_method = "F1BD6B79BF32AE89D304BF4F460F51E3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void acquire() {
            {
                acquireLocked();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mToken) {
                //acquireLocked();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.099 -0400", hash_original_method = "557ADDA01C2A32642A34A73D3A75D3D5", hash_generated_method = "31E619CF13E1CD3AC105D24EEC3B5FB4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void acquire(long timeout) {
            dsTaint.addTaint(timeout);
            {
                acquireLocked();
                mHandler.postDelayed(mReleaser, timeout);
            } //End block
            // ---------- Original Method ----------
            //synchronized (mToken) {
                //acquireLocked();
                //mHandler.postDelayed(mReleaser, timeout);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.100 -0400", hash_original_method = "E457E28DCC06A4C1478E4841AEE77235", hash_generated_method = "D816D9709B7EC26C97152400BA17AB13")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void acquireLocked() {
            {
                mHandler.removeCallbacks(mReleaser);
                try 
                {
                    mService.acquireWakeLock(mFlags, mToken, mTag, mWorkSource);
                } //End block
                catch (RemoteException e)
                { }
                mHeld = true;
            } //End block
            // ---------- Original Method ----------
            //if (!mRefCounted || mCount++ == 0) {
                //mHandler.removeCallbacks(mReleaser);
                //try {
                    //mService.acquireWakeLock(mFlags, mToken, mTag, mWorkSource);
                //} catch (RemoteException e) {
                //}
                //mHeld = true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.100 -0400", hash_original_method = "4304724C92023C406072B166ABF56DE4", hash_generated_method = "06536F16FDC471761CBE2359AB1C490E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void release() {
            release(0);
            // ---------- Original Method ----------
            //release(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.100 -0400", hash_original_method = "4CBF875B7FFD1CFD45FAA62AD6F1991F", hash_generated_method = "79B065537A47B4D520B9A89DEA2C97F6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void release(int flags) {
            dsTaint.addTaint(flags);
            {
                {
                    mHandler.removeCallbacks(mReleaser);
                    try 
                    {
                        mService.releaseWakeLock(mToken, flags);
                    } //End block
                    catch (RemoteException e)
                    { }
                    mHeld = false;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("WakeLock under-locked " + mTag);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (mToken) {
                //if (!mRefCounted || --mCount == 0) {
                    //mHandler.removeCallbacks(mReleaser);
                    //try {
                        //mService.releaseWakeLock(mToken, flags);
                    //} catch (RemoteException e) {
                    //}
                    //mHeld = false;
                //}
                //if (mCount < 0) {
                    //throw new RuntimeException("WakeLock under-locked " + mTag);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.103 -0400", hash_original_method = "B8CE240AF6103639736D7EE1F34595B3", hash_generated_method = "C0C7D2CC288042E6567DF43CFF4BA6E6")
        @DSModeled(DSC.SAFE)
        public boolean isHeld() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mToken) {
                //return mHeld;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.103 -0400", hash_original_method = "413F4C2C0B188BB0515F7A7D15C1E054", hash_generated_method = "FA274DF2B54FF0159A9D4499336260B7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setWorkSource(WorkSource ws) {
            dsTaint.addTaint(ws.dsTaint);
            {
                {
                    boolean varDCFAF0E9E34CB8562A3C2873888A5A3D_988778982 = (ws != null && ws.size() == 0);
                    {
                        ws = null;
                    } //End block
                } //End collapsed parenthetic
                boolean changed;
                changed = true;
                {
                    mWorkSource = null;
                } //End block
                {
                    changed = mWorkSource != null;
                    mWorkSource = new WorkSource(ws);
                } //End block
                {
                    changed = mWorkSource.diff(ws);
                    {
                        mWorkSource.set(ws);
                    } //End block
                } //End block
                {
                    try 
                    {
                        mService.updateWakeLockWorkSource(mToken, mWorkSource);
                    } //End block
                    catch (RemoteException e)
                    { }
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.104 -0400", hash_original_method = "8262D389F7698AE191F8346E629CED2D", hash_generated_method = "56B53DFEA5C0958390E5B6310D0E0DAA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            {
                String varDD476670C77D1A7F47ECBE1CBF46899B_1237321364 = ("WakeLock{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " held=" + mHeld + ", refCount=" + mCount + "}");
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //synchronized (mToken) {
                //return "WakeLock{"
                    //+ Integer.toHexString(System.identityHashCode(this))
                    //+ " held=" + mHeld + ", refCount=" + mCount + "}";
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.104 -0400", hash_original_method = "E802AB356FE449EE74DB3F74C7A8C8D4", hash_generated_method = "F83B158B2F7AD8C68820BAF5E7DDFAC3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void finalize() throws Throwable {
            {
                {
                    Log.wtf(TAG, "WakeLock finalized while still held: " + mTag);
                    try 
                    {
                        mService.releaseWakeLock(mToken, 0);
                    } //End block
                    catch (RemoteException e)
                    { }
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (mToken) {
                //if (mHeld) {
                    //Log.wtf(TAG, "WakeLock finalized while still held: " + mTag);
                    //try {
                        //mService.releaseWakeLock(mToken, 0);
                    //} catch (RemoteException e) {
                    //}
                //}
            //}
        }

        
        static final int RELEASE_WAKE_LOCK = 1;
    }


    
    private static final String TAG = "PowerManager";
    private static final int WAKE_BIT_CPU_STRONG = 1;
    private static final int WAKE_BIT_CPU_WEAK = 2;
    private static final int WAKE_BIT_SCREEN_DIM = 4;
    private static final int WAKE_BIT_SCREEN_BRIGHT = 8;
    private static final int WAKE_BIT_KEYBOARD_BRIGHT = 16;
    private static final int WAKE_BIT_PROXIMITY_SCREEN_OFF = 32;
    private static final int LOCK_MASK = WAKE_BIT_CPU_STRONG
                                        | WAKE_BIT_CPU_WEAK
                                        | WAKE_BIT_SCREEN_DIM
                                        | WAKE_BIT_SCREEN_BRIGHT
                                        | WAKE_BIT_KEYBOARD_BRIGHT
                                        | WAKE_BIT_PROXIMITY_SCREEN_OFF;
    public static final int PARTIAL_WAKE_LOCK = WAKE_BIT_CPU_STRONG;
    public static final int FULL_WAKE_LOCK = WAKE_BIT_CPU_WEAK | WAKE_BIT_SCREEN_BRIGHT 
                                            | WAKE_BIT_KEYBOARD_BRIGHT;
    @Deprecated public static final int SCREEN_BRIGHT_WAKE_LOCK = WAKE_BIT_CPU_WEAK | WAKE_BIT_SCREEN_BRIGHT;
    public static final int SCREEN_DIM_WAKE_LOCK = WAKE_BIT_CPU_WEAK | WAKE_BIT_SCREEN_DIM;
    public static final int PROXIMITY_SCREEN_OFF_WAKE_LOCK = WAKE_BIT_PROXIMITY_SCREEN_OFF;
    public static final int WAIT_FOR_PROXIMITY_NEGATIVE = 1;
    public static final int ACQUIRE_CAUSES_WAKEUP = 0x10000000;
    public static final int ON_AFTER_RELEASE = 0x20000000;
}

