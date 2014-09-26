package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.util.Log;

public class PowerManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.589 -0500", hash_original_field = "3B4330FED75BB90B0CE9F985761989D9", hash_generated_field = "C992E04E6F98294D18127FB43220B098")

    private static final String TAG = "PowerManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.591 -0500", hash_original_field = "5C330DB8F71E4CBABBE16B1FEC56A08D", hash_generated_field = "DA1AF79F5AEB746223D5A080BA0D7B80")

    private static final int WAKE_BIT_CPU_STRONG = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.593 -0500", hash_original_field = "E5361B7E1C1FAFB049BC825DB5153C42", hash_generated_field = "3FFD0B58107F7172B7334E4832AAEDDA")

    private static final int WAKE_BIT_CPU_WEAK = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.596 -0500", hash_original_field = "A29D57CEBA2CC30B3A8F0A959870638D", hash_generated_field = "A8F004FD62F88DD5D68A7238392A7C3E")

    private static final int WAKE_BIT_SCREEN_DIM = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.599 -0500", hash_original_field = "A2C72A807F10CF4CD4B7BD069E8FA71D", hash_generated_field = "C8310B7C352FD2CA790D67F8B6F6AD22")

    private static final int WAKE_BIT_SCREEN_BRIGHT = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.601 -0500", hash_original_field = "12FC4092ECB1C9DBAA7D56F8F97DA723", hash_generated_field = "32E86E15E42DBF8C4A4AAAB26B8E9179")

    private static final int WAKE_BIT_KEYBOARD_BRIGHT = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.603 -0500", hash_original_field = "1CE23A4823D82EAA1E19EE61A672A04A", hash_generated_field = "07D11D2026C96F73E351464C060F0A3D")

    private static final int WAKE_BIT_PROXIMITY_SCREEN_OFF = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.606 -0500", hash_original_field = "74306E3D80B861ADC2651DCA065DB8DA", hash_generated_field = "508DC0C6CE30C8ED2A556800FDE5D29E")
    
    private static final int LOCK_MASK = WAKE_BIT_CPU_STRONG
                                        | WAKE_BIT_CPU_WEAK
                                        | WAKE_BIT_SCREEN_DIM
                                        | WAKE_BIT_SCREEN_BRIGHT
                                        | WAKE_BIT_KEYBOARD_BRIGHT
                                        | WAKE_BIT_PROXIMITY_SCREEN_OFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.612 -0500", hash_original_field = "9955EAE363F552104344AC23B4EC1792", hash_generated_field = "AC9BD5A790B134008196B44EB5DB0805")

    public static final int PARTIAL_WAKE_LOCK = WAKE_BIT_CPU_STRONG;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.615 -0500", hash_original_field = "06146DC5E8E2EA5DC57C5F9D4E336C10", hash_generated_field = "2A57113D9BD852DA3FF027A568ECABBA")

    public static final int FULL_WAKE_LOCK = WAKE_BIT_CPU_WEAK | WAKE_BIT_SCREEN_BRIGHT 
                                            | WAKE_BIT_KEYBOARD_BRIGHT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.617 -0500", hash_original_field = "81D8A95BDB2EB947D378B8CF152D5102", hash_generated_field = "F717F611D328BBB864613E8871029C25")

    @Deprecated
    public static final int SCREEN_BRIGHT_WAKE_LOCK = WAKE_BIT_CPU_WEAK | WAKE_BIT_SCREEN_BRIGHT;
    
    public class WakeLock {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.633 -0500", hash_original_field = "AB493A44689C365DB0C15627FDC5B5BB", hash_generated_field = "E9017053B54EAB7FB5FC1DB7E6284D86")

        static final int RELEASE_WAKE_LOCK = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.988 -0400", hash_original_field = "8C000F972038F01199BE709ADEA69D32", hash_generated_field = "F7462AACBEE42AD8546E251CB93CC06F")

        Runnable mReleaser = new Runnable() {            
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.988 -0400", hash_original_method = "EE8EB6B44C1ECA6F34C46D68F05D7353", hash_generated_method = "4FB3659F1E09722C30041C679A6091C0")
            public void run() {
                release();
                
            }
            
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.640 -0500", hash_original_field = "4E5A87EA4636A8ACF68875B877F3A7B8", hash_generated_field = "4E5A87EA4636A8ACF68875B877F3A7B8")
	
        int mFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.642 -0500", hash_original_field = "05B32B05746742D3A5261C827E7D8852", hash_generated_field = "05B32B05746742D3A5261C827E7D8852")

        String mTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.644 -0500", hash_original_field = "DD6EB7EC256F1225D4C6DC1A42FB765B", hash_generated_field = "DD6EB7EC256F1225D4C6DC1A42FB765B")

        IBinder mToken;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.646 -0500", hash_original_field = "D01C96038701D525501067476D6E20FD", hash_generated_field = "D01C96038701D525501067476D6E20FD")

        int mCount = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.648 -0500", hash_original_field = "31018A422B139F36328AD43A1CE83154", hash_generated_field = "31018A422B139F36328AD43A1CE83154")

        boolean mRefCounted = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.650 -0500", hash_original_field = "1D98D769EB12EDC0237EF4FD267495CF", hash_generated_field = "1D98D769EB12EDC0237EF4FD267495CF")

        boolean mHeld = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.652 -0500", hash_original_field = "842B61DB21B58291FC09444F5B6363D6", hash_generated_field = "842B61DB21B58291FC09444F5B6363D6")

        WorkSource mWorkSource;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.655 -0500", hash_original_method = "F8EACFB6990EF5D4887B3D97C67B44DC", hash_generated_method = "F8EACFB6990EF5D4887B3D97C67B44DC")
        
WakeLock(int flags, String tag)
        {
            switch (flags & LOCK_MASK) {
            case PARTIAL_WAKE_LOCK:
            case SCREEN_DIM_WAKE_LOCK:
            case SCREEN_BRIGHT_WAKE_LOCK:
            case FULL_WAKE_LOCK:
            case PROXIMITY_SCREEN_OFF_WAKE_LOCK:
                break;
            default:
                throw new IllegalArgumentException();
            }

            mFlags = flags;
            mTag = tag;
            mToken = new Binder();
        }

        /**
         * Sets whether this WakeLock is ref counted.
         *
         * <p>Wake locks are reference counted by default.
         *
         * @param value true for ref counted, false for not ref counted.
         */
        @DSComment("Power management")
        @DSSpec(DSCat.DEVICE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.657 -0500", hash_original_method = "C9C09C089F97F5128A15BBE86111A3BF", hash_generated_method = "6748BB7750DA0EB9305F3FBD73636CFB")
        
public void setReferenceCounted(boolean value)
        {
            mRefCounted = value;
        }

        /**
         * Makes sure the device is on at the level you asked when you created
         * the wake lock.
         */
        @DSComment("Power management")
        @DSSpec(DSCat.DEVICE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.660 -0500", hash_original_method = "60F8C5E408EB104B9A6B83E1C96AB086", hash_generated_method = "6CBB7F30A9B24D66F901470838801880")
        
public void acquire()
        {
            synchronized (mToken) {
                acquireLocked();
            }
        }

        /**
         * Makes sure the device is on at the level you asked when you created
         * the wake lock. The lock will be released after the given timeout.
         * 
         * @param timeout Release the lock after the give timeout in milliseconds.
         */
        @DSComment("Power management")
        @DSSpec(DSCat.DEVICE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.662 -0500", hash_original_method = "557ADDA01C2A32642A34A73D3A75D3D5", hash_generated_method = "82D4DE857663CEA5A041286E314C40BF")
        
public void acquire(long timeout) {
            synchronized (mToken) {
                acquireLocked();
                mHandler.postDelayed(mReleaser, timeout);
            }
        }
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.665 -0500", hash_original_method = "E457E28DCC06A4C1478E4841AEE77235", hash_generated_method = "73EFF3123AC02CDE0D16563CB98526D8")
        
private void acquireLocked() {
            if (!mRefCounted || mCount++ == 0) {
                mHandler.removeCallbacks(mReleaser);
                try {
                    mService.acquireWakeLock(mFlags, mToken, mTag, mWorkSource);
                } catch (RemoteException e) {
                }
                mHeld = true;
            }
        }

        /**
         * Release your claim to the CPU or screen being on.
         *
         * <p>
         * It may turn off shortly after you release it, or it may not if there
         * are other wake locks held.
         */
        @DSComment("Power management")
        @DSSpec(DSCat.DEVICE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.667 -0500", hash_original_method = "4304724C92023C406072B166ABF56DE4", hash_generated_method = "6AA21D14C5EDE1271ACE8C5C9841CF80")
        
public void release() {
            release(0);
        }

        /**
         * Release your claim to the CPU or screen being on.
         * @param flags Combination of flag values to modify the release behavior.
         *              Currently only {@link #WAIT_FOR_PROXIMITY_NEGATIVE} is supported.
         *
         * <p>
         * It may turn off shortly after you release it, or it may not if there
         * are other wake locks held.
         *
         * {@hide}
         */
        @DSComment("Power management")
        @DSSpec(DSCat.DEVICE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.669 -0500", hash_original_method = "4CBF875B7FFD1CFD45FAA62AD6F1991F", hash_generated_method = "F0AC080B112EF81290E9E9D504FF0117")
        
public void release(int flags) {
            synchronized (mToken) {
                if (!mRefCounted || --mCount == 0) {
                    mHandler.removeCallbacks(mReleaser);
                    try {
                        mService.releaseWakeLock(mToken, flags);
                    } catch (RemoteException e) {
                    }
                    mHeld = false;
                }
                if (mCount < 0) {
                    throw new RuntimeException("WakeLock under-locked " + mTag);
                }
            }
        }

        @DSComment("Power management")
        @DSSpec(DSCat.DEVICE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.672 -0500", hash_original_method = "B8CE240AF6103639736D7EE1F34595B3", hash_generated_method = "58A0667DBE8EA8514F1D4E4A3BE4A4DD")
        
public boolean isHeld()
        {
            synchronized (mToken) {
                return mHeld;
            }
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.674 -0500", hash_original_method = "413F4C2C0B188BB0515F7A7D15C1E054", hash_generated_method = "AF637D4A4057E12E7AE0BBDDB3080BBD")
        
public void setWorkSource(WorkSource ws) {
            synchronized (mToken) {
                if (ws != null && ws.size() == 0) {
                    ws = null;
                }
                boolean changed = true;
                if (ws == null) {
                    mWorkSource = null;
                } else if (mWorkSource == null) {
                    changed = mWorkSource != null;
                    mWorkSource = new WorkSource(ws);
                } else {
                    changed = mWorkSource.diff(ws);
                    if (changed) {
                        mWorkSource.set(ws);
                    }
                }
                if (changed && mHeld) {
                    try {
                        mService.updateWakeLockWorkSource(mToken, mWorkSource);
                    } catch (RemoteException e) {
                    }
                }
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.676 -0500", hash_original_method = "8262D389F7698AE191F8346E629CED2D", hash_generated_method = "A029D042C19F838242CE64C4864BD49C")
        
public String toString() {
            synchronized (mToken) {
                return "WakeLock{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " held=" + mHeld + ", refCount=" + mCount + "}";
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.679 -0500", hash_original_method = "E802AB356FE449EE74DB3F74C7A8C8D4", hash_generated_method = "87D42B07DBF344965AC5D533CF781837")
        
@Override
        protected void finalize() throws Throwable
        {
            synchronized (mToken) {
                if (mHeld) {
                    Log.wtf(TAG, "WakeLock finalized while still held: " + mTag);
                    try {
                        mService.releaseWakeLock(mToken, 0);
                    } catch (RemoteException e) {
                    }
                }
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.619 -0500", hash_original_field = "2FF0E5B11B11847A08BC7E9A532AD34E", hash_generated_field = "F623936918E89354B54D6D1D9B39860E")

    public static final int SCREEN_DIM_WAKE_LOCK = WAKE_BIT_CPU_WEAK | WAKE_BIT_SCREEN_DIM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.622 -0500", hash_original_field = "3C96CA243712D6CD148339855E0DF11D", hash_generated_field = "0708AE34D53A282071D7648E3913507C")

    public static final int PROXIMITY_SCREEN_OFF_WAKE_LOCK = WAKE_BIT_PROXIMITY_SCREEN_OFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.624 -0500", hash_original_field = "B20C0227FCC40BFCEEC06A2A911BA357", hash_generated_field = "1296A95FBE3E2E8B9781F7FA52FCB683")

    public static final int WAIT_FOR_PROXIMITY_NEGATIVE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.628 -0500", hash_original_field = "67E324929E0E12F9B1B78D24C12C3C23", hash_generated_field = "121F7BB5CBB7C0F7BA1F50E37F255D93")

    public static final int ACQUIRE_CAUSES_WAKEUP = 0x10000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.630 -0500", hash_original_field = "B6D2B0907B6D6DF3D87A481F2F04A67F", hash_generated_field = "9E3A5D66F162F0360DDC8F4B1969F42B")

    public static final int ON_AFTER_RELEASE = 0x20000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.704 -0500", hash_original_field = "5A93C277105259AF4C607FFD616B68DC", hash_generated_field = "5A93C277105259AF4C607FFD616B68DC")
    
    IPowerManager mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.706 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    
    @DSComment("Private Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.325 -0400", hash_original_method = "CC3F52E82947675044A40593774B54F6", hash_generated_method = "FBF57EA37BF41DE0AFD68D9E02F27504")
    public PowerManager() {
        // ---------- Original Method ----------
    }

    /**
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.702 -0500", hash_original_method = "060274E80C670013EA8E2104C630EB40", hash_generated_method = "CE3FDDABBA2BEAF1E91BAC8B52FAF9E7")
    
public PowerManager(IPowerManager service, Handler handler)
    {
        mService = service;
        mHandler = handler;
    }

    /**
     * Get a wake lock at the level of the flags parameter.  Call
     * {@link WakeLock#acquire() acquire()} on the object to acquire the
     * wake lock, and {@link WakeLock#release release()} when you are done.
     *
     * {@samplecode
     *PowerManager pm = (PowerManager)mContext.getSystemService(
     *                                          Context.POWER_SERVICE);
     *PowerManager.WakeLock wl = pm.newWakeLock(
     *                                      PowerManager.SCREEN_DIM_WAKE_LOCK
     *                                      | PowerManager.ON_AFTER_RELEASE,
     *                                      TAG);
     *wl.acquire();
     * // ...
     *wl.release();
     * }
     *
     * <p class="note">If using this to keep the screen on, you should strongly consider using
     * {@link android.view.WindowManager.LayoutParams#FLAG_KEEP_SCREEN_ON} instead.
     * This window flag will be correctly managed by the platform
     * as the user moves between applications and doesn't require a special permission.</p>
     *
     * @param flags Combination of flag values defining the requested behavior of the WakeLock.
     * @param tag Your class name (or other tag) for debugging purposes.
     *
     * @see WakeLock#acquire()
     * @see WakeLock#release()
     */
    @DSSpec(DSCat.POWER_MANAGER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.683 -0500", hash_original_method = "93AAF5370B6BA4BEAC029A2F72D16576", hash_generated_method = "1CDA668250E23B518D981E8780517EAE")
    
public WakeLock newWakeLock(int flags, String tag)
    {
        if (tag == null) {
            throw new NullPointerException("tag is null in PowerManager.newWakeLock");
        }
        return new WakeLock(flags, tag);
    }

    /**
     * User activity happened.
     * <p>
     * Turns the device from whatever state it's in to full on, and resets
     * the auto-off timer.
     *
     * @param when is used to order this correctly with the wake lock calls.
     *          This time should be in the {@link SystemClock#uptimeMillis
     *          SystemClock.uptimeMillis()} time base.
     * @param noChangeLights should be true if you don't want the lights to
     *          turn on because of this event.  This is set when the power
     *          key goes down.  We want the device to stay on while the button
     *          is down, but we're about to turn off.  Otherwise the lights
     *          flash on and then off and it looks weird.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.686 -0500", hash_original_method = "C5F540EE3212366BBE1CC045B8933E13", hash_generated_method = "262E961EDDD689037F17F32869A44BE3")
    
public void userActivity(long when, boolean noChangeLights)
    {
        try {
            mService.userActivity(when, noChangeLights);
        } catch (RemoteException e) {
        }
    }

   /**
     * Force the device to go to sleep. Overrides all the wake locks that are
     * held.
     * 
     * @param time is used to order this correctly with the wake lock calls. 
     *          The time  should be in the {@link SystemClock#uptimeMillis 
     *          SystemClock.uptimeMillis()} time base.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.688 -0500", hash_original_method = "CD7C7C85680B5F62F444A1BDA84407A2", hash_generated_method = "20FB5050F314D3DB2DCD5DD6E514AACF")
    
public void goToSleep(long time) 
    {
        try {
            mService.goToSleep(time);
        } catch (RemoteException e) {
        }
    }

    /**
     * sets the brightness of the backlights (screen, keyboard, button).
     *
     * @param brightness value from 0 to 255
     *
     * {@hide}
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.691 -0500", hash_original_method = "1657059AF219261DAAA3A6D217AB2CFE", hash_generated_method = "E9D76F6E04F1B6EDEA6885C3A8F0A9D0")
    
public void setBacklightBrightness(int brightness)
    {
        try {
            mService.setBacklightBrightness(brightness);
        } catch (RemoteException e) {
        }
    }

   /**
     * Returns the set of flags for {@link #newWakeLock(int, String) newWakeLock()}
     * that are supported on the device.
     * For example, to test to see if the {@link #PROXIMITY_SCREEN_OFF_WAKE_LOCK}
     * is supported:
     *
     * {@samplecode
     * PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
     * int supportedFlags = pm.getSupportedWakeLockFlags();
     *  boolean proximitySupported = ((supportedFlags & PowerManager.PROXIMITY_SCREEN_OFF_WAKE_LOCK)
     *                                  == PowerManager.PROXIMITY_SCREEN_OFF_WAKE_LOCK);
     * }
     *
     * @return the set of supported WakeLock flags.
     *
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.693 -0500", hash_original_method = "3FEFDF5F90A1934664CD9ABDDAD0F802", hash_generated_method = "FA3B71FA65EA77B4A196282FBB8C3C47")
    
public int getSupportedWakeLockFlags()
    {
        try {
            return mService.getSupportedWakeLockFlags();
        } catch (RemoteException e) {
            return 0;
        }
    }

    /**
      * Returns whether the screen is currently on. The screen could be bright
      * or dim.
      *
      * {@samplecode
      * PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
      * boolean isScreenOn = pm.isScreenOn();
      * }
      *
      * @return whether the screen is on (bright or dim).
      */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.695 -0500", hash_original_method = "50478742CDFBDF2C875183424E636D44", hash_generated_method = "E90AE062DA29F58D5C26EF2FEB3B5203")
    
public boolean isScreenOn()
    {
        try {
            return mService.isScreenOn();
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Reboot the device.  Will not return if the reboot is
     * successful.  Requires the {@link android.Manifest.permission#REBOOT}
     * permission.
     *
     * @param reason code to pass to the kernel (e.g., "recovery") to
     *               request special boot modes, or null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.697 -0500", hash_original_method = "35D8C90A4186EC12B6AC746434DE3AC6", hash_generated_method = "D747215E3EBD5C12C3F5AF57D3FB0952")
    
public void reboot(String reason)
    {
        try {
            mService.reboot(reason);
        } catch (RemoteException e) {
        }
    }
}

