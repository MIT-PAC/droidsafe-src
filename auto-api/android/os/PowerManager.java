package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;

public class PowerManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.255 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "5A93C277105259AF4C607FFD616B68DC")

    IPowerManager mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.255 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.256 -0400", hash_original_method = "CC3F52E82947675044A40593774B54F6", hash_generated_method = "FBF57EA37BF41DE0AFD68D9E02F27504")
    private  PowerManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.270 -0400", hash_original_method = "060274E80C670013EA8E2104C630EB40", hash_generated_method = "987BBA9C2442A389A6642FEC3C9D08F9")
    public  PowerManager(IPowerManager service, Handler handler) {
        mService = service;
        mHandler = handler;
        // ---------- Original Method ----------
        //mService = service;
        //mHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.271 -0400", hash_original_method = "93AAF5370B6BA4BEAC029A2F72D16576", hash_generated_method = "28636ED7D8A34386B7F5E26FD3F3E809")
    public WakeLock newWakeLock(int flags, String tag) {
        WakeLock varB4EAC82CA7396A68D541C85D26508E83_915199933 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("tag is null in PowerManager.newWakeLock");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_915199933 = new WakeLock(flags, tag);
        addTaint(flags);
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_915199933.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_915199933;
        // ---------- Original Method ----------
        //if (tag == null) {
            //throw new NullPointerException("tag is null in PowerManager.newWakeLock");
        //}
        //return new WakeLock(flags, tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.271 -0400", hash_original_method = "C5F540EE3212366BBE1CC045B8933E13", hash_generated_method = "D7DF77ED9D1CC0A2173C5F43DB17A026")
    public void userActivity(long when, boolean noChangeLights) {
        try 
        {
            mService.userActivity(when, noChangeLights);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(when);
        addTaint(noChangeLights);
        // ---------- Original Method ----------
        //try {
            //mService.userActivity(when, noChangeLights);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.272 -0400", hash_original_method = "CD7C7C85680B5F62F444A1BDA84407A2", hash_generated_method = "C1DF087EB11438DDE293186B66FC94C0")
    public void goToSleep(long time) {
        try 
        {
            mService.goToSleep(time);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(time);
        // ---------- Original Method ----------
        //try {
            //mService.goToSleep(time);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.272 -0400", hash_original_method = "1657059AF219261DAAA3A6D217AB2CFE", hash_generated_method = "223F98C4C3869D4A9AFC32062E45911D")
    public void setBacklightBrightness(int brightness) {
        try 
        {
            mService.setBacklightBrightness(brightness);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(brightness);
        // ---------- Original Method ----------
        //try {
            //mService.setBacklightBrightness(brightness);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.273 -0400", hash_original_method = "3FEFDF5F90A1934664CD9ABDDAD0F802", hash_generated_method = "E40EA541681701B49C9AB8B2278FA348")
    public int getSupportedWakeLockFlags() {
        try 
        {
            int var523D03F3D92596C5D29B4B3F266A1185_1445952608 = (mService.getSupportedWakeLockFlags());
        } //End block
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_995608148 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_995608148;
        // ---------- Original Method ----------
        //try {
            //return mService.getSupportedWakeLockFlags();
        //} catch (RemoteException e) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.273 -0400", hash_original_method = "50478742CDFBDF2C875183424E636D44", hash_generated_method = "8F35E4EFF343C2B4EB095AECDFE5EB10")
    public boolean isScreenOn() {
        try 
        {
            boolean var3405A35E39FE7BA8C0D22FE35D82BDAA_1457618832 = (mService.isScreenOn());
        } //End block
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_623329242 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_623329242;
        // ---------- Original Method ----------
        //try {
            //return mService.isScreenOn();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.290 -0400", hash_original_method = "35D8C90A4186EC12B6AC746434DE3AC6", hash_generated_method = "70CB051F4D08FA477B139F6EA91DB16B")
    public void reboot(String reason) {
        try 
        {
            mService.reboot(reason);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        //try {
            //mService.reboot(reason);
        //} catch (RemoteException e) {
        //}
    }

    
    public class WakeLock {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.291 -0400", hash_original_field = "8C000F972038F01199BE709ADEA69D32", hash_generated_field = "EDAD722F66A97D82012CD36ED15E650B")

        Runnable mReleaser = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.291 -0400", hash_original_method = "EE8EB6B44C1ECA6F34C46D68F05D7353", hash_generated_method = "4FB3659F1E09722C30041C679A6091C0")
            public void run() {
                release();
                // ---------- Original Method ----------
                //release();
            }

            
};
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.291 -0400", hash_original_field = "9C3CD7D37D3E1E66BE9B3B005FC98B3A", hash_generated_field = "4E5A87EA4636A8ACF68875B877F3A7B8")

        int mFlags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.291 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "05B32B05746742D3A5261C827E7D8852")

        String mTag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.291 -0400", hash_original_field = "98E8D2ECD335C543A384E2B940159AF2", hash_generated_field = "DD6EB7EC256F1225D4C6DC1A42FB765B")

        IBinder mToken;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.291 -0400", hash_original_field = "DFBC16768366A2556A52E5DCDCD8E737", hash_generated_field = "D01C96038701D525501067476D6E20FD")

        int mCount = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.291 -0400", hash_original_field = "047BD179D9D3B99F5CB555412FF5185D", hash_generated_field = "31018A422B139F36328AD43A1CE83154")

        boolean mRefCounted = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.291 -0400", hash_original_field = "C4F054EB5B2F148D82E2CFBF9BA32E3D", hash_generated_field = "1D98D769EB12EDC0237EF4FD267495CF")

        boolean mHeld = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.291 -0400", hash_original_field = "33F0FDFE72CD4D291DF24A21567DB5C9", hash_generated_field = "842B61DB21B58291FC09444F5B6363D6")

        WorkSource mWorkSource;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.292 -0400", hash_original_method = "F8EACFB6990EF5D4887B3D97C67B44DC", hash_generated_method = "D7928E79985E69EE89CB83FCA39BC9B6")
          WakeLock(int flags, String tag) {
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            //End case default 
            mFlags = flags;
            mTag = tag;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.292 -0400", hash_original_method = "C9C09C089F97F5128A15BBE86111A3BF", hash_generated_method = "494115ABA2B3754EECDF64EBFE873031")
        public void setReferenceCounted(boolean value) {
            mRefCounted = value;
            // ---------- Original Method ----------
            //mRefCounted = value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.301 -0400", hash_original_method = "60F8C5E408EB104B9A6B83E1C96AB086", hash_generated_method = "F1BD6B79BF32AE89D304BF4F460F51E3")
        public void acquire() {
            {
                acquireLocked();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mToken) {
                //acquireLocked();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.308 -0400", hash_original_method = "557ADDA01C2A32642A34A73D3A75D3D5", hash_generated_method = "1FA2E29C42FA3542C713563E00E58ABE")
        public void acquire(long timeout) {
            {
                acquireLocked();
                mHandler.postDelayed(mReleaser, timeout);
            } //End block
            addTaint(timeout);
            // ---------- Original Method ----------
            //synchronized (mToken) {
                //acquireLocked();
                //mHandler.postDelayed(mReleaser, timeout);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.309 -0400", hash_original_method = "E457E28DCC06A4C1478E4841AEE77235", hash_generated_method = "D816D9709B7EC26C97152400BA17AB13")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.309 -0400", hash_original_method = "4304724C92023C406072B166ABF56DE4", hash_generated_method = "06536F16FDC471761CBE2359AB1C490E")
        public void release() {
            release(0);
            // ---------- Original Method ----------
            //release(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.310 -0400", hash_original_method = "4CBF875B7FFD1CFD45FAA62AD6F1991F", hash_generated_method = "CD6D647C4648A37772A0CF245E188996")
        public void release(int flags) {
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
            addTaint(flags);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.311 -0400", hash_original_method = "B8CE240AF6103639736D7EE1F34595B3", hash_generated_method = "3DB90B5FC5EF2C2177904605B65245D5")
        public boolean isHeld() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_837057913 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_837057913;
            // ---------- Original Method ----------
            //synchronized (mToken) {
                //return mHeld;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.314 -0400", hash_original_method = "413F4C2C0B188BB0515F7A7D15C1E054", hash_generated_method = "F8B98A694F644F2D220855FB8E2FCF61")
        public void setWorkSource(WorkSource ws) {
            {
                {
                    boolean varDCFAF0E9E34CB8562A3C2873888A5A3D_293513295 = (ws != null && ws.size() == 0);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.315 -0400", hash_original_method = "8262D389F7698AE191F8346E629CED2D", hash_generated_method = "12272FE80FFAD072D6A0A53E37D3BA02")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_648231427 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_648231427 = "WakeLock{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " held=" + mHeld + ", refCount=" + mCount + "}";
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_648231427.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_648231427;
            // ---------- Original Method ----------
            //synchronized (mToken) {
                //return "WakeLock{"
                    //+ Integer.toHexString(System.identityHashCode(this))
                    //+ " held=" + mHeld + ", refCount=" + mCount + "}";
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.339 -0400", hash_original_method = "E802AB356FE449EE74DB3F74C7A8C8D4", hash_generated_method = "F83B158B2F7AD8C68820BAF5E7DDFAC3")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.339 -0400", hash_original_field = "DDF120CAF6ED4420CFA18099A29DDFF3", hash_generated_field = "D71176D3E675BC5E62036F800F62D464")

        static int RELEASE_WAKE_LOCK = 1;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.339 -0400", hash_original_field = "E8C3AF11B2F6C50D851EEE3EA424AA6D", hash_generated_field = "2D12F0D3A206DC66FE5E8C601605D909")

    private static String TAG = "PowerManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.339 -0400", hash_original_field = "19211123338B420C591A207AFA329DF6", hash_generated_field = "996A74150238FCF5D602A76060473C6D")

    private static int WAKE_BIT_CPU_STRONG = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.340 -0400", hash_original_field = "2DD8AA100D0F732E67E310CF891D7EC0", hash_generated_field = "5436CE437B4AC524CAB42A78A19F1526")

    private static int WAKE_BIT_CPU_WEAK = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.340 -0400", hash_original_field = "64FA4D528368594F4BA7044E6BB5092D", hash_generated_field = "A927B648F6DBDE13CC140569E0F2D2CF")

    private static int WAKE_BIT_SCREEN_DIM = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.340 -0400", hash_original_field = "4E1C9FEBB7C003327838D9CB37C65B4C", hash_generated_field = "CEDF41D0734472317BA219887ABE1F70")

    private static int WAKE_BIT_SCREEN_BRIGHT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.341 -0400", hash_original_field = "AE803F38BC0FAA62295ED420EE291210", hash_generated_field = "1E619ECF5A9B241D4220275F25AB2B56")

    private static int WAKE_BIT_KEYBOARD_BRIGHT = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.341 -0400", hash_original_field = "0740FACA4BEB2366D6EE9D1405136E9B", hash_generated_field = "2F23FC60FC791CD18D9D1647A8E582F2")

    private static int WAKE_BIT_PROXIMITY_SCREEN_OFF = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.341 -0400", hash_original_field = "AC58A11040F96D1D65A052554AB0D8F3", hash_generated_field = "FE1F076EEBDE90489BE82BD1C065FFA9")

    private static int LOCK_MASK = WAKE_BIT_CPU_STRONG
                                        | WAKE_BIT_CPU_WEAK
                                        | WAKE_BIT_SCREEN_DIM
                                        | WAKE_BIT_SCREEN_BRIGHT
                                        | WAKE_BIT_KEYBOARD_BRIGHT
                                        | WAKE_BIT_PROXIMITY_SCREEN_OFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.341 -0400", hash_original_field = "F8152CF66C372203002D8F0B3AFAACFE", hash_generated_field = "AC9BD5A790B134008196B44EB5DB0805")

    public static final int PARTIAL_WAKE_LOCK = WAKE_BIT_CPU_STRONG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.341 -0400", hash_original_field = "6684FBE1CBF83D70FB2C43811368FAA0", hash_generated_field = "2A57113D9BD852DA3FF027A568ECABBA")

    public static final int FULL_WAKE_LOCK = WAKE_BIT_CPU_WEAK | WAKE_BIT_SCREEN_BRIGHT 
                                            | WAKE_BIT_KEYBOARD_BRIGHT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.341 -0400", hash_original_field = "FA43A140C1D80C83BE8A2A1014915A27", hash_generated_field = "F717F611D328BBB864613E8871029C25")

    @Deprecated
    public static final int SCREEN_BRIGHT_WAKE_LOCK = WAKE_BIT_CPU_WEAK | WAKE_BIT_SCREEN_BRIGHT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.341 -0400", hash_original_field = "8F05CF3EDC06D0C1F2B6D054FA71A107", hash_generated_field = "F623936918E89354B54D6D1D9B39860E")

    public static final int SCREEN_DIM_WAKE_LOCK = WAKE_BIT_CPU_WEAK | WAKE_BIT_SCREEN_DIM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.341 -0400", hash_original_field = "1C6A2BE426D19CB6DAA7FCAA6F1D62E3", hash_generated_field = "0708AE34D53A282071D7648E3913507C")

    public static final int PROXIMITY_SCREEN_OFF_WAKE_LOCK = WAKE_BIT_PROXIMITY_SCREEN_OFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.341 -0400", hash_original_field = "F278FFC7DC7268E47F010CAE7DA15285", hash_generated_field = "1296A95FBE3E2E8B9781F7FA52FCB683")

    public static final int WAIT_FOR_PROXIMITY_NEGATIVE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.341 -0400", hash_original_field = "A0309D0D2B9C7C35DB8AEF5C0CF4EB63", hash_generated_field = "121F7BB5CBB7C0F7BA1F50E37F255D93")

    public static final int ACQUIRE_CAUSES_WAKEUP = 0x10000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.341 -0400", hash_original_field = "46661894042BF5A628C41971C71A0419", hash_generated_field = "9E3A5D66F162F0360DDC8F4B1969F42B")

    public static final int ON_AFTER_RELEASE = 0x20000000;
}

