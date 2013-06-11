package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.util.Log;

public class PowerManager {
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
    @Deprecated
    public static final int SCREEN_BRIGHT_WAKE_LOCK = WAKE_BIT_CPU_WEAK | WAKE_BIT_SCREEN_BRIGHT;
    public static final int SCREEN_DIM_WAKE_LOCK = WAKE_BIT_CPU_WEAK | WAKE_BIT_SCREEN_DIM;
    public static final int PROXIMITY_SCREEN_OFF_WAKE_LOCK = WAKE_BIT_PROXIMITY_SCREEN_OFF;
    public static final int WAIT_FOR_PROXIMITY_NEGATIVE = 1;
    public static final int ACQUIRE_CAUSES_WAKEUP = 0x10000000;
    public static final int ON_AFTER_RELEASE = 0x20000000;
    IPowerManager mService;
    Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.842 -0400", hash_original_method = "CC3F52E82947675044A40593774B54F6", hash_generated_method = "1D61D581CD28DF2AB1B364D0A671E85C")
    @DSModeled(DSC.SAFE)
    private PowerManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.842 -0400", hash_original_method = "060274E80C670013EA8E2104C630EB40", hash_generated_method = "DFADDE37F3C47E39B4140CAFB535F9D3")
    @DSModeled(DSC.SAFE)
    public PowerManager(IPowerManager service, Handler handler) {
        dsTaint.addTaint(service.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        // ---------- Original Method ----------
        //mService = service;
        //mHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.842 -0400", hash_original_method = "93AAF5370B6BA4BEAC029A2F72D16576", hash_generated_method = "4A7A626ADD5A31DAAF583CAB657AF04D")
    @DSModeled(DSC.SAFE)
    public WakeLock newWakeLock(int flags, String tag) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(tag);
        {
            throw new NullPointerException("tag is null in PowerManager.newWakeLock");
        } //End block
        return (WakeLock)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (tag == null) {
            //throw new NullPointerException("tag is null in PowerManager.newWakeLock");
        //}
        //return new WakeLock(flags, tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.842 -0400", hash_original_method = "C5F540EE3212366BBE1CC045B8933E13", hash_generated_method = "1D680B019B620E79D2094351A3896005")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.843 -0400", hash_original_method = "CD7C7C85680B5F62F444A1BDA84407A2", hash_generated_method = "155543C6A47A226D43C11125D09EE8A6")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.843 -0400", hash_original_method = "1657059AF219261DAAA3A6D217AB2CFE", hash_generated_method = "7106333A5E928E9374CA3E971350D213")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.843 -0400", hash_original_method = "3FEFDF5F90A1934664CD9ABDDAD0F802", hash_generated_method = "C0B4A70CBF83D1ABE2431B1BDD10D208")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSupportedWakeLockFlags() {
        try 
        {
            int var523D03F3D92596C5D29B4B3F266A1185_430836573 = (mService.getSupportedWakeLockFlags());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.843 -0400", hash_original_method = "50478742CDFBDF2C875183424E636D44", hash_generated_method = "5698A51192B8BAF7DA246914F2413701")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isScreenOn() {
        try 
        {
            boolean var3405A35E39FE7BA8C0D22FE35D82BDAA_1042545189 = (mService.isScreenOn());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.843 -0400", hash_original_method = "35D8C90A4186EC12B6AC746434DE3AC6", hash_generated_method = "C8F9D5FB3488B3E5A61B1B9AFE78819D")
    @DSModeled(DSC.SAFE)
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
        static final int RELEASE_WAKE_LOCK = 1;
        Runnable mReleaser = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.843 -0400", hash_original_method = "EE8EB6B44C1ECA6F34C46D68F05D7353", hash_generated_method = "21BA078F493C463B12AA5FF0C21AD0CF")
            @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.843 -0400", hash_original_method = "F8EACFB6990EF5D4887B3D97C67B44DC", hash_generated_method = "45F5B915711E213E4E5F003B3614CB62")
        @DSModeled(DSC.SAFE)
         WakeLock(int flags, String tag) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(tag);
            //Begin case default 
            throw new IllegalArgumentException();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.843 -0400", hash_original_method = "C9C09C089F97F5128A15BBE86111A3BF", hash_generated_method = "8F80CFA4431BD1B05DEDE998ACB94937")
        @DSModeled(DSC.SAFE)
        public void setReferenceCounted(boolean value) {
            dsTaint.addTaint(value);
            // ---------- Original Method ----------
            //mRefCounted = value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.844 -0400", hash_original_method = "60F8C5E408EB104B9A6B83E1C96AB086", hash_generated_method = "895CBFAA45EDDA2E97E61833B3E7082C")
        @DSModeled(DSC.SAFE)
        public void acquire() {
            {
                acquireLocked();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mToken) {
                //acquireLocked();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.844 -0400", hash_original_method = "557ADDA01C2A32642A34A73D3A75D3D5", hash_generated_method = "1C8F26AB57D9A95198D36420AE56C4FA")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.844 -0400", hash_original_method = "E457E28DCC06A4C1478E4841AEE77235", hash_generated_method = "D7D4CF2BC4FF59DAA11797B0654BD5FE")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.844 -0400", hash_original_method = "4304724C92023C406072B166ABF56DE4", hash_generated_method = "8C54506C1917EF01310FC32132724F18")
        @DSModeled(DSC.SAFE)
        public void release() {
            release(0);
            // ---------- Original Method ----------
            //release(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.844 -0400", hash_original_method = "4CBF875B7FFD1CFD45FAA62AD6F1991F", hash_generated_method = "6BBC6261C467C104D75CB99375B0CD9F")
        @DSModeled(DSC.SAFE)
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
                    throw new RuntimeException("WakeLock under-locked " + mTag);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.844 -0400", hash_original_method = "B8CE240AF6103639736D7EE1F34595B3", hash_generated_method = "2248EFC0C3414F92D88E17F8FBE1F036")
        @DSModeled(DSC.SAFE)
        public boolean isHeld() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (mToken) {
                //return mHeld;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.845 -0400", hash_original_method = "413F4C2C0B188BB0515F7A7D15C1E054", hash_generated_method = "48AFC018624E3FE0DFFDD1CB4DD0544E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setWorkSource(WorkSource ws) {
            dsTaint.addTaint(ws.dsTaint);
            {
                {
                    boolean varDCFAF0E9E34CB8562A3C2873888A5A3D_1464417002 = (ws != null && ws.size() == 0);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.845 -0400", hash_original_method = "8262D389F7698AE191F8346E629CED2D", hash_generated_method = "C51AEEF33E5E7F410360E434A7114829")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            {
                String varDD476670C77D1A7F47ECBE1CBF46899B_1035080356 = ("WakeLock{"
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.845 -0400", hash_original_method = "E802AB356FE449EE74DB3F74C7A8C8D4", hash_generated_method = "9A0F672EB08EB67F862070E567B6B7E4")
        @DSModeled(DSC.SAFE)
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

        
    }


    
}


