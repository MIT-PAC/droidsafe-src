package android.os;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.util.Log;





public class PowerManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.324 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "5A93C277105259AF4C607FFD616B68DC")

    IPowerManager mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.324 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.325 -0400", hash_original_method = "CC3F52E82947675044A40593774B54F6", hash_generated_method = "FBF57EA37BF41DE0AFD68D9E02F27504")
    private  PowerManager() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.325 -0400", hash_original_method = "060274E80C670013EA8E2104C630EB40", hash_generated_method = "987BBA9C2442A389A6642FEC3C9D08F9")
    public  PowerManager(IPowerManager service, Handler handler) {
        mService = service;
        mHandler = handler;
        // ---------- Original Method ----------
        //mService = service;
        //mHandler = handler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.326 -0400", hash_original_method = "93AAF5370B6BA4BEAC029A2F72D16576", hash_generated_method = "FC1BD0A28A2223AF1784DFF0FB7FBE8B")
    public WakeLock newWakeLock(int flags, String tag) {
        addTaint(tag.getTaint());
        addTaint(flags);
        if(tag == null)        
        {
            NullPointerException var3013041DE9CCD17410AB8D25ADEA0167_1563256819 = new NullPointerException("tag is null in PowerManager.newWakeLock");
            var3013041DE9CCD17410AB8D25ADEA0167_1563256819.addTaint(taint);
            throw var3013041DE9CCD17410AB8D25ADEA0167_1563256819;
        } //End block
WakeLock var4089891081BA08D4F8E416D6853507C4_340718386 =         new WakeLock(flags, tag);
        var4089891081BA08D4F8E416D6853507C4_340718386.addTaint(taint);
        return var4089891081BA08D4F8E416D6853507C4_340718386;
        // ---------- Original Method ----------
        //if (tag == null) {
            //throw new NullPointerException("tag is null in PowerManager.newWakeLock");
        //}
        //return new WakeLock(flags, tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.327 -0400", hash_original_method = "C5F540EE3212366BBE1CC045B8933E13", hash_generated_method = "0CFAC62A78FB515EA46DF10C555A5D7E")
    public void userActivity(long when, boolean noChangeLights) {
        addTaint(noChangeLights);
        addTaint(when);
        try 
        {
            mService.userActivity(when, noChangeLights);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.userActivity(when, noChangeLights);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.328 -0400", hash_original_method = "CD7C7C85680B5F62F444A1BDA84407A2", hash_generated_method = "CFA19571FC36B4B6DD58B9EF28646504")
    public void goToSleep(long time) {
        addTaint(time);
        try 
        {
            mService.goToSleep(time);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.goToSleep(time);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.328 -0400", hash_original_method = "1657059AF219261DAAA3A6D217AB2CFE", hash_generated_method = "BD838FEB5C0F7DF0D6140291474EDA76")
    public void setBacklightBrightness(int brightness) {
        addTaint(brightness);
        try 
        {
            mService.setBacklightBrightness(brightness);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setBacklightBrightness(brightness);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.329 -0400", hash_original_method = "3FEFDF5F90A1934664CD9ABDDAD0F802", hash_generated_method = "ABAB99F9240A1A37CB9EA2FC284C976E")
    public int getSupportedWakeLockFlags() {
        try 
        {
            int var8E1F0C77F4A230485BA874DB229DEF8F_304224926 = (mService.getSupportedWakeLockFlags());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1978824438 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1978824438;
        } //End block
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1786710023 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1071349135 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1071349135;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getSupportedWakeLockFlags();
        //} catch (RemoteException e) {
            //return 0;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.329 -0400", hash_original_method = "50478742CDFBDF2C875183424E636D44", hash_generated_method = "37AB494BC7D68609F9B08376C06FF997")
    public boolean isScreenOn() {
        try 
        {
            boolean var93CFF79B5D2555DE3023FF73E15B99C9_938062421 = (mService.isScreenOn());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2100287827 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2100287827;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1720594623 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_554244027 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_554244027;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.isScreenOn();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.330 -0400", hash_original_method = "35D8C90A4186EC12B6AC746434DE3AC6", hash_generated_method = "7566611F00AF46F47BC457983492FF0E")
    public void reboot(String reason) {
        addTaint(reason.getTaint());
        try 
        {
            mService.reboot(reason);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.reboot(reason);
        //} catch (RemoteException e) {
        //}
    }

    
    public class WakeLock {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.988 -0400", hash_original_field = "8C000F972038F01199BE709ADEA69D32", hash_generated_field = "F7462AACBEE42AD8546E251CB93CC06F")

        Runnable mReleaser = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.988 -0400", hash_original_method = "EE8EB6B44C1ECA6F34C46D68F05D7353", hash_generated_method = "4FB3659F1E09722C30041C679A6091C0")
            public void run() {
                release();
                
                
            }

            
};
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.330 -0400", hash_original_field = "9C3CD7D37D3E1E66BE9B3B005FC98B3A", hash_generated_field = "4E5A87EA4636A8ACF68875B877F3A7B8")

        int mFlags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.330 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "05B32B05746742D3A5261C827E7D8852")

        String mTag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.330 -0400", hash_original_field = "98E8D2ECD335C543A384E2B940159AF2", hash_generated_field = "DD6EB7EC256F1225D4C6DC1A42FB765B")

        IBinder mToken;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.330 -0400", hash_original_field = "DFBC16768366A2556A52E5DCDCD8E737", hash_generated_field = "D01C96038701D525501067476D6E20FD")

        int mCount = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.330 -0400", hash_original_field = "047BD179D9D3B99F5CB555412FF5185D", hash_generated_field = "31018A422B139F36328AD43A1CE83154")

        boolean mRefCounted = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.330 -0400", hash_original_field = "C4F054EB5B2F148D82E2CFBF9BA32E3D", hash_generated_field = "1D98D769EB12EDC0237EF4FD267495CF")

        boolean mHeld = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.330 -0400", hash_original_field = "33F0FDFE72CD4D291DF24A21567DB5C9", hash_generated_field = "842B61DB21B58291FC09444F5B6363D6")

        WorkSource mWorkSource;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.331 -0400", hash_original_method = "F8EACFB6990EF5D4887B3D97C67B44DC", hash_generated_method = "A9A9367B70EE069EDED8A5A30025F16A")
          WakeLock(int flags, String tag) {
switch(flags & LOCK_MASK){
            case PARTIAL_WAKE_LOCK:
            case SCREEN_DIM_WAKE_LOCK:
            case SCREEN_BRIGHT_WAKE_LOCK:
            case FULL_WAKE_LOCK:
            case PROXIMITY_SCREEN_OFF_WAKE_LOCK:
            break;
            default:
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1182489795 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1182489795.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1182489795;
}            mFlags = flags;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.332 -0400", hash_original_method = "C9C09C089F97F5128A15BBE86111A3BF", hash_generated_method = "494115ABA2B3754EECDF64EBFE873031")
        public void setReferenceCounted(boolean value) {
            mRefCounted = value;
            // ---------- Original Method ----------
            //mRefCounted = value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.332 -0400", hash_original_method = "60F8C5E408EB104B9A6B83E1C96AB086", hash_generated_method = "46122C6ECD562C97704C7C0BAB744350")
        public void acquire() {
            synchronized
(mToken)            {
                acquireLocked();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mToken) {
                //acquireLocked();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.332 -0400", hash_original_method = "557ADDA01C2A32642A34A73D3A75D3D5", hash_generated_method = "D8FC27C997A22C28EAD5ECF3A28CCE11")
        public void acquire(long timeout) {
            addTaint(timeout);
            synchronized
(mToken)            {
                acquireLocked();
                mHandler.postDelayed(mReleaser, timeout);
            } //End block
            // ---------- Original Method ----------
            //synchronized (mToken) {
                //acquireLocked();
                //mHandler.postDelayed(mReleaser, timeout);
            //}
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.333 -0400", hash_original_method = "E457E28DCC06A4C1478E4841AEE77235", hash_generated_method = "B78D792E53F771C0F817469AB3AD3914")
        private void acquireLocked() {
            if(!mRefCounted || mCount++ == 0)            
            {
                mHandler.removeCallbacks(mReleaser);
                try 
                {
                    mService.acquireWakeLock(mFlags, mToken, mTag, mWorkSource);
                } //End block
                catch (RemoteException e)
                {
                } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.335 -0400", hash_original_method = "4304724C92023C406072B166ABF56DE4", hash_generated_method = "06536F16FDC471761CBE2359AB1C490E")
        public void release() {
            release(0);
            // ---------- Original Method ----------
            //release(0);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.337 -0400", hash_original_method = "4CBF875B7FFD1CFD45FAA62AD6F1991F", hash_generated_method = "E3F9EB7B0DF7031DD3ED906E69D151F1")
        public void release(int flags) {
            addTaint(flags);
            synchronized
(mToken)            {
                if(!mRefCounted || --mCount == 0)                
                {
                    mHandler.removeCallbacks(mReleaser);
                    try 
                    {
                        mService.releaseWakeLock(mToken, flags);
                    } //End block
                    catch (RemoteException e)
                    {
                    } //End block
                    mHeld = false;
                } //End block
                if(mCount < 0)                
                {
                    RuntimeException var6CD397036E3CD1212596AC723083AF88_314140100 = new RuntimeException("WakeLock under-locked " + mTag);
                    var6CD397036E3CD1212596AC723083AF88_314140100.addTaint(taint);
                    throw var6CD397036E3CD1212596AC723083AF88_314140100;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.337 -0400", hash_original_method = "B8CE240AF6103639736D7EE1F34595B3", hash_generated_method = "C3C02698BD2FA0C7DF76B76A33E102CC")
        public boolean isHeld() {
            synchronized
(mToken)            {
                boolean varAD25B113814807D236AFB0F5095B0005_399601814 = (mHeld);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_806685754 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_806685754;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mToken) {
                //return mHeld;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.338 -0400", hash_original_method = "413F4C2C0B188BB0515F7A7D15C1E054", hash_generated_method = "E9B7E3A183B86FD31FB4AA18D3029FE8")
        public void setWorkSource(WorkSource ws) {
            synchronized
(mToken)            {
                if(ws != null && ws.size() == 0)                
                {
                    ws = null;
                } //End block
                boolean changed = true;
                if(ws == null)                
                {
                    mWorkSource = null;
                } //End block
                else
                if(mWorkSource == null)                
                {
                    changed = mWorkSource != null;
                    mWorkSource = new WorkSource(ws);
                } //End block
                else
                {
                    changed = mWorkSource.diff(ws);
                    if(changed)                    
                    {
                        mWorkSource.set(ws);
                    } //End block
                } //End block
                if(changed && mHeld)                
                {
                    try 
                    {
                        mService.updateWakeLockWorkSource(mToken, mWorkSource);
                    } //End block
                    catch (RemoteException e)
                    {
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.339 -0400", hash_original_method = "8262D389F7698AE191F8346E629CED2D", hash_generated_method = "9ACF05A7E21A794E3EF4DA52A644640A")
        public String toString() {
            synchronized
(mToken)            {
String var46AB0C184AE74F49DBA6A39856AEEE67_152715798 =                 "WakeLock{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " held=" + mHeld + ", refCount=" + mCount + "}";
                var46AB0C184AE74F49DBA6A39856AEEE67_152715798.addTaint(taint);
                return var46AB0C184AE74F49DBA6A39856AEEE67_152715798;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mToken) {
                //return "WakeLock{"
                    //+ Integer.toHexString(System.identityHashCode(this))
                    //+ " held=" + mHeld + ", refCount=" + mCount + "}";
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.340 -0400", hash_original_method = "E802AB356FE449EE74DB3F74C7A8C8D4", hash_generated_method = "A740AB224144704BFA90C74FE3585501")
        @Override
        protected void finalize() throws Throwable {
            synchronized
(mToken)            {
                if(mHeld)                
                {
                    Log.wtf(TAG, "WakeLock finalized while still held: " + mTag);
                    try 
                    {
                        mService.releaseWakeLock(mToken, 0);
                    } //End block
                    catch (RemoteException e)
                    {
                    } //End block
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.340 -0400", hash_original_field = "DDF120CAF6ED4420CFA18099A29DDFF3", hash_generated_field = "E9017053B54EAB7FB5FC1DB7E6284D86")

        static final int RELEASE_WAKE_LOCK = 1;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.340 -0400", hash_original_field = "E8C3AF11B2F6C50D851EEE3EA424AA6D", hash_generated_field = "C992E04E6F98294D18127FB43220B098")

    private static final String TAG = "PowerManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.340 -0400", hash_original_field = "19211123338B420C591A207AFA329DF6", hash_generated_field = "DA1AF79F5AEB746223D5A080BA0D7B80")

    private static final int WAKE_BIT_CPU_STRONG = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.340 -0400", hash_original_field = "2DD8AA100D0F732E67E310CF891D7EC0", hash_generated_field = "3FFD0B58107F7172B7334E4832AAEDDA")

    private static final int WAKE_BIT_CPU_WEAK = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.340 -0400", hash_original_field = "64FA4D528368594F4BA7044E6BB5092D", hash_generated_field = "A8F004FD62F88DD5D68A7238392A7C3E")

    private static final int WAKE_BIT_SCREEN_DIM = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.340 -0400", hash_original_field = "4E1C9FEBB7C003327838D9CB37C65B4C", hash_generated_field = "C8310B7C352FD2CA790D67F8B6F6AD22")

    private static final int WAKE_BIT_SCREEN_BRIGHT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.340 -0400", hash_original_field = "AE803F38BC0FAA62295ED420EE291210", hash_generated_field = "32E86E15E42DBF8C4A4AAAB26B8E9179")

    private static final int WAKE_BIT_KEYBOARD_BRIGHT = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.340 -0400", hash_original_field = "0740FACA4BEB2366D6EE9D1405136E9B", hash_generated_field = "07D11D2026C96F73E351464C060F0A3D")

    private static final int WAKE_BIT_PROXIMITY_SCREEN_OFF = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.341 -0400", hash_original_field = "AC58A11040F96D1D65A052554AB0D8F3", hash_generated_field = "508DC0C6CE30C8ED2A556800FDE5D29E")

    private static final int LOCK_MASK = WAKE_BIT_CPU_STRONG
                                        | WAKE_BIT_CPU_WEAK
                                        | WAKE_BIT_SCREEN_DIM
                                        | WAKE_BIT_SCREEN_BRIGHT
                                        | WAKE_BIT_KEYBOARD_BRIGHT
                                        | WAKE_BIT_PROXIMITY_SCREEN_OFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.341 -0400", hash_original_field = "F8152CF66C372203002D8F0B3AFAACFE", hash_generated_field = "AC9BD5A790B134008196B44EB5DB0805")

    public static final int PARTIAL_WAKE_LOCK = WAKE_BIT_CPU_STRONG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.341 -0400", hash_original_field = "6684FBE1CBF83D70FB2C43811368FAA0", hash_generated_field = "2A57113D9BD852DA3FF027A568ECABBA")

    public static final int FULL_WAKE_LOCK = WAKE_BIT_CPU_WEAK | WAKE_BIT_SCREEN_BRIGHT 
                                            | WAKE_BIT_KEYBOARD_BRIGHT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.341 -0400", hash_original_field = "FA43A140C1D80C83BE8A2A1014915A27", hash_generated_field = "F717F611D328BBB864613E8871029C25")

    @Deprecated
    public static final int SCREEN_BRIGHT_WAKE_LOCK = WAKE_BIT_CPU_WEAK | WAKE_BIT_SCREEN_BRIGHT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.341 -0400", hash_original_field = "8F05CF3EDC06D0C1F2B6D054FA71A107", hash_generated_field = "F623936918E89354B54D6D1D9B39860E")

    public static final int SCREEN_DIM_WAKE_LOCK = WAKE_BIT_CPU_WEAK | WAKE_BIT_SCREEN_DIM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.341 -0400", hash_original_field = "1C6A2BE426D19CB6DAA7FCAA6F1D62E3", hash_generated_field = "0708AE34D53A282071D7648E3913507C")

    public static final int PROXIMITY_SCREEN_OFF_WAKE_LOCK = WAKE_BIT_PROXIMITY_SCREEN_OFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.341 -0400", hash_original_field = "F278FFC7DC7268E47F010CAE7DA15285", hash_generated_field = "1296A95FBE3E2E8B9781F7FA52FCB683")

    public static final int WAIT_FOR_PROXIMITY_NEGATIVE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.341 -0400", hash_original_field = "A0309D0D2B9C7C35DB8AEF5C0CF4EB63", hash_generated_field = "121F7BB5CBB7C0F7BA1F50E37F255D93")

    public static final int ACQUIRE_CAUSES_WAKEUP = 0x10000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.341 -0400", hash_original_field = "46661894042BF5A628C41971C71A0419", hash_generated_field = "9E3A5D66F162F0360DDC8F4B1969F42B")

    public static final int ON_AFTER_RELEASE = 0x20000000;
}

