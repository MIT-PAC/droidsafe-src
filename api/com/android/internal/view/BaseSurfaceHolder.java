package com.android.internal.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public abstract class BaseSurfaceHolder implements SurfaceHolder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.077 -0400", hash_original_field = "5B2965AE5247A9A1234D4FDCDF03BACD", hash_generated_field = "E2B111E4E2AF9D070F427E06A59175AE")

    public final ArrayList<SurfaceHolder.Callback> mCallbacks = new ArrayList<SurfaceHolder.Callback>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.078 -0400", hash_original_field = "CB3592545E4E8601CEB2C87E04ACA3C8", hash_generated_field = "767D60A6E3C8EEF6EF9A0A1954F0A20E")

    SurfaceHolder.Callback[] mGottenCallbacks;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.078 -0400", hash_original_field = "CE33D374F2ECCAA50E236A8A9FFC4D4A", hash_generated_field = "AF697DFEEDD2FFAC42B82ED08BC1177F")

    boolean mHaveGottenCallbacks;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.078 -0400", hash_original_field = "52392AFCA83FA6F6A2B3A89B48CC1408", hash_generated_field = "75EFD538893F5DD13B0AD54DB0DA969B")

    public final ReentrantLock mSurfaceLock = new ReentrantLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.078 -0400", hash_original_field = "41551392C18EC9CD321667F2791AD52A", hash_generated_field = "1AC64A6B091D59168F964952F2A6F53B")

    public Surface mSurface = new Surface();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.078 -0400", hash_original_field = "8A5806C480FF6E75927A4F1D6AFC8E5D", hash_generated_field = "F9EC238B16254BED53BCBCEFBD6EF45D")

    int mRequestedWidth = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.078 -0400", hash_original_field = "62C4EF08A7A4B3F04161E6472DF8ACF1", hash_generated_field = "C329ECB2BC7D94AC739801F768FE2BE6")

    int mRequestedHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.078 -0400", hash_original_field = "FC2891F47AE8C369C7217A6DCFB264B1", hash_generated_field = "BE1DBBDAE20148CACEDA6DF736D8CA2E")

    protected int mRequestedFormat = PixelFormat.OPAQUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.078 -0400", hash_original_field = "1A329DE391B524BAC042F5A1B7CD3367", hash_generated_field = "65788EBA442CE964EE645934A86AEABE")

    int mRequestedType = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.078 -0400", hash_original_field = "D42022960F60B4E9A38A4C00D0651E27", hash_generated_field = "0FB69CE58A9B36474A3E521462C289A0")

    long mLastLockTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.078 -0400", hash_original_field = "7EC2C3003126A3993EB506D83DE073E3", hash_generated_field = "DE07B82DC42B56613109CDBFD4F50C15")

    int mType = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.078 -0400", hash_original_field = "430EE1EE1C2CEA5C342BF8D9010C8AB2", hash_generated_field = "5FF70CE962F22D930D1FDE55775FEDAE")

    final Rect mSurfaceFrame = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.078 -0400", hash_original_field = "EE99E1DF5AAD9573B58AE4256DDE7025", hash_generated_field = "0C3E6D0D62BE6C4E33545B05306C722E")

    Rect mTmpDirty;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.078 -0400", hash_original_method = "65236AFB54FAB65BD2FC1C8CD2966A75", hash_generated_method = "65236AFB54FAB65BD2FC1C8CD2966A75")
    public BaseSurfaceHolder ()
    {
        //Synthesized constructor
    }


    public abstract void onUpdateSurface();

    
    public abstract void onRelayoutContainer();

    
    public abstract boolean onAllowLockCanvas();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.079 -0400", hash_original_method = "3AF431EE7D6883EB1B4141BFAE213C2E", hash_generated_method = "40B608521E58F7AEFD3215AB24737718")
    public int getRequestedWidth() {
        int varDAF12D28BCAFCD8EC4B5B68A0352444B_344592652 = (mRequestedWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1758422159 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1758422159;
        // ---------- Original Method ----------
        //return mRequestedWidth;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.079 -0400", hash_original_method = "2ED2833D03220673A510D00698E2D0FF", hash_generated_method = "91FD3C7BCDAC45432A29AE461C70CDC1")
    public int getRequestedHeight() {
        int var607ECA59F8428E44FACCC287BB658A06_1603669483 = (mRequestedHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1189253168 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1189253168;
        // ---------- Original Method ----------
        //return mRequestedHeight;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.079 -0400", hash_original_method = "E655118A2C284546E2D290C1F5BE4CAA", hash_generated_method = "128CE4844079B9D00AFF49EF35FF40F3")
    public int getRequestedFormat() {
        int var1D9A5E4502690E61DCBE59F0D63D60CF_1186201880 = (mRequestedFormat);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1470988722 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1470988722;
        // ---------- Original Method ----------
        //return mRequestedFormat;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.079 -0400", hash_original_method = "1ADEF52CA934B4124985C64931FCC871", hash_generated_method = "C6C4AA43C0D77050CFF98880A466D4D8")
    public int getRequestedType() {
        int var041382B53F7833EFA1F8B723782EDE61_42490135 = (mRequestedType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_138966050 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_138966050;
        // ---------- Original Method ----------
        //return mRequestedType;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.079 -0400", hash_original_method = "A6B53DAA62C6D5AB170B791AD6D4E39D", hash_generated_method = "D7A505DD115C685DA72AFFC736187E58")
    public void addCallback(Callback callback) {
        addTaint(callback.getTaint());
        synchronized
(mCallbacks)        {
    if(mCallbacks.contains(callback) == false)            
            {
                mCallbacks.add(callback);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mCallbacks) {
            //if (mCallbacks.contains(callback) == false) {      
                //mCallbacks.add(callback);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.079 -0400", hash_original_method = "C2F2686F3B633A931E5A1A7B954047E4", hash_generated_method = "77768F30AE1B02D539CF364ED7DB66C1")
    public void removeCallback(Callback callback) {
        addTaint(callback.getTaint());
        synchronized
(mCallbacks)        {
            mCallbacks.remove(callback);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mCallbacks) {
            //mCallbacks.remove(callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.080 -0400", hash_original_method = "2E153784742E80414EA6460F2018158D", hash_generated_method = "B78ADE2E1CA7AE53741C8CA2860B1706")
    public SurfaceHolder.Callback[] getCallbacks() {
    if(mHaveGottenCallbacks)        
        {
SurfaceHolder.Callback[] var045A4A088B10EA41A936A83AC51470FC_1777416936 =             mGottenCallbacks;
            var045A4A088B10EA41A936A83AC51470FC_1777416936.addTaint(taint);
            return var045A4A088B10EA41A936A83AC51470FC_1777416936;
        } //End block
        synchronized
(mCallbacks)        {
            final int N = mCallbacks.size();
    if(N > 0)            
            {
    if(mGottenCallbacks == null || mGottenCallbacks.length != N)                
                {
                    mGottenCallbacks = new SurfaceHolder.Callback[N];
                } //End block
                mCallbacks.toArray(mGottenCallbacks);
            } //End block
            else
            {
                mGottenCallbacks = null;
            } //End block
            mHaveGottenCallbacks = true;
        } //End block
SurfaceHolder.Callback[] var045A4A088B10EA41A936A83AC51470FC_952755017 =         mGottenCallbacks;
        var045A4A088B10EA41A936A83AC51470FC_952755017.addTaint(taint);
        return var045A4A088B10EA41A936A83AC51470FC_952755017;
        // ---------- Original Method ----------
        //if (mHaveGottenCallbacks) {
            //return mGottenCallbacks;
        //}
        //synchronized (mCallbacks) {
            //final int N = mCallbacks.size();
            //if (N > 0) {
                //if (mGottenCallbacks == null || mGottenCallbacks.length != N) {
                    //mGottenCallbacks = new SurfaceHolder.Callback[N];
                //}
                //mCallbacks.toArray(mGottenCallbacks);
            //} else {
                //mGottenCallbacks = null;
            //}
            //mHaveGottenCallbacks = true;
        //}
        //return mGottenCallbacks;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.080 -0400", hash_original_method = "B038D0F820D93ACBDF8182E2BE5C1116", hash_generated_method = "B4DB9781FDECFBFCC3D06A75C53FB30C")
    public void ungetCallbacks() {
        mHaveGottenCallbacks = false;
        // ---------- Original Method ----------
        //mHaveGottenCallbacks = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.084 -0400", hash_original_method = "00011C38E6EC925AC8838B7EF1A5974E", hash_generated_method = "14A38DDB81B1BF210BA107E1623F7138")
    public void setFixedSize(int width, int height) {
    if(mRequestedWidth != width || mRequestedHeight != height)        
        {
            mRequestedWidth = width;
            mRequestedHeight = height;
            onRelayoutContainer();
        } //End block
        // ---------- Original Method ----------
        //if (mRequestedWidth != width || mRequestedHeight != height) {
            //mRequestedWidth = width;
            //mRequestedHeight = height;
            //onRelayoutContainer();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.084 -0400", hash_original_method = "3FBBAABB359B15ECFE32A5B65108D82E", hash_generated_method = "102820B7C68EBAAA880C0400C26C6278")
    public void setSizeFromLayout() {
    if(mRequestedWidth != -1 || mRequestedHeight != -1)        
        {
            mRequestedWidth = mRequestedHeight = -1;
            onRelayoutContainer();
        } //End block
        // ---------- Original Method ----------
        //if (mRequestedWidth != -1 || mRequestedHeight != -1) {
            //mRequestedWidth = mRequestedHeight = -1;
            //onRelayoutContainer();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.084 -0400", hash_original_method = "FD1656C90E0BF9DD59BF1C1951F6D90A", hash_generated_method = "6D399A1395157D1C1B30B10DD37EBD09")
    public void setFormat(int format) {
    if(mRequestedFormat != format)        
        {
            mRequestedFormat = format;
            onUpdateSurface();
        } //End block
        // ---------- Original Method ----------
        //if (mRequestedFormat != format) {
            //mRequestedFormat = format;
            //onUpdateSurface();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.084 -0400", hash_original_method = "EAFF612A3F1F2919ED355687F3DB192A", hash_generated_method = "4B780B2C456CC5952F8EB8ACACF21493")
    public void setType(int type) {
switch(type){
        case SURFACE_TYPE_HARDWARE:
        case SURFACE_TYPE_GPU:
        type = SURFACE_TYPE_NORMAL;
        break;
}switch(type){
        case SURFACE_TYPE_NORMAL:
        case SURFACE_TYPE_PUSH_BUFFERS:
    if(mRequestedType != type)        
        {
            mRequestedType = type;
            onUpdateSurface();
        } //End block
        break;
}
        // ---------- Original Method ----------
        //switch (type) {
        //case SURFACE_TYPE_HARDWARE:
        //case SURFACE_TYPE_GPU:
            //type = SURFACE_TYPE_NORMAL;
            //break;
        //}
        //switch (type) {
        //case SURFACE_TYPE_NORMAL:
        //case SURFACE_TYPE_PUSH_BUFFERS:
            //if (mRequestedType != type) {
                //mRequestedType = type;
                //onUpdateSurface();
            //}
            //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.084 -0400", hash_original_method = "62E11A68BFE49B76328D9C868319D907", hash_generated_method = "8DFCA61DFB361EC9C33173A253E68DFE")
    public Canvas lockCanvas() {
Canvas varDE61BB4FF724D2412289EA61714EB9A6_1644893164 =         internalLockCanvas(null);
        varDE61BB4FF724D2412289EA61714EB9A6_1644893164.addTaint(taint);
        return varDE61BB4FF724D2412289EA61714EB9A6_1644893164;
        // ---------- Original Method ----------
        //return internalLockCanvas(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.085 -0400", hash_original_method = "680C567FEFB26BF9B08DD2E5AA0C3FA9", hash_generated_method = "AF0ED2FD0929984611B786157DF23F65")
    public Canvas lockCanvas(Rect dirty) {
        addTaint(dirty.getTaint());
Canvas var78B0430AF4ECF3E90510E88412E9F8FF_1016255250 =         internalLockCanvas(dirty);
        var78B0430AF4ECF3E90510E88412E9F8FF_1016255250.addTaint(taint);
        return var78B0430AF4ECF3E90510E88412E9F8FF_1016255250;
        // ---------- Original Method ----------
        //return internalLockCanvas(dirty);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.085 -0400", hash_original_method = "ACAAC9086C35A7B567CF149ED3F96213", hash_generated_method = "AE244435787D68B74FD3DD6405AEB40F")
    private final Canvas internalLockCanvas(Rect dirty) {
        addTaint(dirty.getTaint());
    if(mType == SURFACE_TYPE_PUSH_BUFFERS)        
        {
            BadSurfaceTypeException var00366FDD1C7FB26465FD12593DB0FD1A_157896212 = new BadSurfaceTypeException(
                    "Surface type is SURFACE_TYPE_PUSH_BUFFERS");
            var00366FDD1C7FB26465FD12593DB0FD1A_157896212.addTaint(taint);
            throw var00366FDD1C7FB26465FD12593DB0FD1A_157896212;
        } //End block
        mSurfaceLock.lock();
    if(DEBUG){ }        Canvas c = null;
    if(onAllowLockCanvas())        
        {
    if(dirty == null)            
            {
    if(mTmpDirty == null)                
                {
                    mTmpDirty = new Rect();
                } //End block
                mTmpDirty.set(mSurfaceFrame);
                dirty = mTmpDirty;
            } //End block
            try 
            {
                c = mSurface.lockCanvas(dirty);
            } //End block
            catch (Exception e)
            {
            } //End block
        } //End block
    if(DEBUG){ }    if(c != null)        
        {
            mLastLockTime = SystemClock.uptimeMillis();
Canvas var807FB10045EE51C06BDB74744A6714DF_484189847 =             c;
            var807FB10045EE51C06BDB74744A6714DF_484189847.addTaint(taint);
            return var807FB10045EE51C06BDB74744A6714DF_484189847;
        } //End block
        long now = SystemClock.uptimeMillis();
        long nextTime = mLastLockTime + 100;
    if(nextTime > now)        
        {
            try 
            {
                Thread.sleep(nextTime-now);
            } //End block
            catch (InterruptedException e)
            {
            } //End block
            now = SystemClock.uptimeMillis();
        } //End block
        mLastLockTime = now;
        mSurfaceLock.unlock();
Canvas var540C13E9E156B687226421B24F2DF178_226829480 =         null;
        var540C13E9E156B687226421B24F2DF178_226829480.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_226829480;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.085 -0400", hash_original_method = "94198D6DEEC3932A7E8E0C313FB26861", hash_generated_method = "702D8F7FDBE0CD8C6980161491EF2FEB")
    public void unlockCanvasAndPost(Canvas canvas) {
        addTaint(canvas.getTaint());
        mSurface.unlockCanvasAndPost(canvas);
        mSurfaceLock.unlock();
        // ---------- Original Method ----------
        //mSurface.unlockCanvasAndPost(canvas);
        //mSurfaceLock.unlock();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.085 -0400", hash_original_method = "FB03EEF08A419E6F5E4B7D4C32AA13C8", hash_generated_method = "D951EDAA6FFF7B7A67EA6348E002DDA7")
    public Surface getSurface() {
Surface varB7C98568942B156EFD367CE054011CDA_778084324 =         mSurface;
        varB7C98568942B156EFD367CE054011CDA_778084324.addTaint(taint);
        return varB7C98568942B156EFD367CE054011CDA_778084324;
        // ---------- Original Method ----------
        //return mSurface;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.085 -0400", hash_original_method = "BE643F9C45A14CE663214357E2B511D8", hash_generated_method = "E19BC4588412D6C9029A2342C67ECC46")
    public Rect getSurfaceFrame() {
Rect varE9ECEDEA5A2368584CD71CAA52747028_1442681064 =         mSurfaceFrame;
        varE9ECEDEA5A2368584CD71CAA52747028_1442681064.addTaint(taint);
        return varE9ECEDEA5A2368584CD71CAA52747028_1442681064;
        // ---------- Original Method ----------
        //return mSurfaceFrame;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.086 -0400", hash_original_method = "B2173B72636D8AF8E14456C4D20DEB0F", hash_generated_method = "3C164CF7F26EF369524BF1E8345A5299")
    public void setSurfaceFrameSize(int width, int height) {
        mSurfaceFrame.top = 0;
        mSurfaceFrame.left = 0;
        mSurfaceFrame.right = width;
        mSurfaceFrame.bottom = height;
        // ---------- Original Method ----------
        //mSurfaceFrame.top = 0;
        //mSurfaceFrame.left = 0;
        //mSurfaceFrame.right = width;
        //mSurfaceFrame.bottom = height;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.086 -0400", hash_original_field = "07DBC32137B9D5FFE392E2171940A81D", hash_generated_field = "25EA1DB5DFEC23EE8B60521742AF8CB0")

    private static final String TAG = "BaseSurfaceHolder";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.086 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")

    static final boolean DEBUG = false;
}

