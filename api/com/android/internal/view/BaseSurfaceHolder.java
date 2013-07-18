package com.android.internal.view;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.Surface;
import android.view.SurfaceHolder;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class BaseSurfaceHolder implements SurfaceHolder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.114 -0400", hash_original_field = "5B2965AE5247A9A1234D4FDCDF03BACD", hash_generated_field = "E2B111E4E2AF9D070F427E06A59175AE")

    public final ArrayList<SurfaceHolder.Callback> mCallbacks = new ArrayList<SurfaceHolder.Callback>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.114 -0400", hash_original_field = "CB3592545E4E8601CEB2C87E04ACA3C8", hash_generated_field = "767D60A6E3C8EEF6EF9A0A1954F0A20E")

    SurfaceHolder.Callback[] mGottenCallbacks;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.114 -0400", hash_original_field = "CE33D374F2ECCAA50E236A8A9FFC4D4A", hash_generated_field = "AF697DFEEDD2FFAC42B82ED08BC1177F")

    boolean mHaveGottenCallbacks;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.114 -0400", hash_original_field = "52392AFCA83FA6F6A2B3A89B48CC1408", hash_generated_field = "75EFD538893F5DD13B0AD54DB0DA969B")

    public final ReentrantLock mSurfaceLock = new ReentrantLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.114 -0400", hash_original_field = "41551392C18EC9CD321667F2791AD52A", hash_generated_field = "1AC64A6B091D59168F964952F2A6F53B")

    public Surface mSurface = new Surface();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.114 -0400", hash_original_field = "8A5806C480FF6E75927A4F1D6AFC8E5D", hash_generated_field = "F9EC238B16254BED53BCBCEFBD6EF45D")

    int mRequestedWidth = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.115 -0400", hash_original_field = "62C4EF08A7A4B3F04161E6472DF8ACF1", hash_generated_field = "C329ECB2BC7D94AC739801F768FE2BE6")

    int mRequestedHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.115 -0400", hash_original_field = "FC2891F47AE8C369C7217A6DCFB264B1", hash_generated_field = "BE1DBBDAE20148CACEDA6DF736D8CA2E")

    protected int mRequestedFormat = PixelFormat.OPAQUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.115 -0400", hash_original_field = "1A329DE391B524BAC042F5A1B7CD3367", hash_generated_field = "65788EBA442CE964EE645934A86AEABE")

    int mRequestedType = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.115 -0400", hash_original_field = "D42022960F60B4E9A38A4C00D0651E27", hash_generated_field = "0FB69CE58A9B36474A3E521462C289A0")

    long mLastLockTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.115 -0400", hash_original_field = "7EC2C3003126A3993EB506D83DE073E3", hash_generated_field = "DE07B82DC42B56613109CDBFD4F50C15")

    int mType = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.115 -0400", hash_original_field = "430EE1EE1C2CEA5C342BF8D9010C8AB2", hash_generated_field = "5FF70CE962F22D930D1FDE55775FEDAE")

    final Rect mSurfaceFrame = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.115 -0400", hash_original_field = "EE99E1DF5AAD9573B58AE4256DDE7025", hash_generated_field = "0C3E6D0D62BE6C4E33545B05306C722E")

    Rect mTmpDirty;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.115 -0400", hash_original_method = "65236AFB54FAB65BD2FC1C8CD2966A75", hash_generated_method = "65236AFB54FAB65BD2FC1C8CD2966A75")
    public BaseSurfaceHolder ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public abstract void onUpdateSurface();

    
    @DSModeled(DSC.SAFE)
    public abstract void onRelayoutContainer();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean onAllowLockCanvas();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.116 -0400", hash_original_method = "3AF431EE7D6883EB1B4141BFAE213C2E", hash_generated_method = "14B17707BD4DAA91279E44A9EEAD3883")
    public int getRequestedWidth() {
        int varDAF12D28BCAFCD8EC4B5B68A0352444B_916000047 = (mRequestedWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349140845 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349140845;
        // ---------- Original Method ----------
        //return mRequestedWidth;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.116 -0400", hash_original_method = "2ED2833D03220673A510D00698E2D0FF", hash_generated_method = "895461B5419E095860DAF2782AA23A29")
    public int getRequestedHeight() {
        int var607ECA59F8428E44FACCC287BB658A06_1227307265 = (mRequestedHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_302122940 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_302122940;
        // ---------- Original Method ----------
        //return mRequestedHeight;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.117 -0400", hash_original_method = "E655118A2C284546E2D290C1F5BE4CAA", hash_generated_method = "8016BC5E79E6C222104C3DA839E36F9B")
    public int getRequestedFormat() {
        int var1D9A5E4502690E61DCBE59F0D63D60CF_1109806493 = (mRequestedFormat);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2018506786 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2018506786;
        // ---------- Original Method ----------
        //return mRequestedFormat;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.117 -0400", hash_original_method = "1ADEF52CA934B4124985C64931FCC871", hash_generated_method = "AB1150BCA72215E58BBD4EAE50642C7D")
    public int getRequestedType() {
        int var041382B53F7833EFA1F8B723782EDE61_689312264 = (mRequestedType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187559505 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187559505;
        // ---------- Original Method ----------
        //return mRequestedType;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.117 -0400", hash_original_method = "A6B53DAA62C6D5AB170B791AD6D4E39D", hash_generated_method = "D7A505DD115C685DA72AFFC736187E58")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.117 -0400", hash_original_method = "C2F2686F3B633A931E5A1A7B954047E4", hash_generated_method = "77768F30AE1B02D539CF364ED7DB66C1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.118 -0400", hash_original_method = "2E153784742E80414EA6460F2018158D", hash_generated_method = "BC03AF31E335FEEDF36609C2A9166636")
    public SurfaceHolder.Callback[] getCallbacks() {
        if(mHaveGottenCallbacks)        
        {
SurfaceHolder.Callback[] var045A4A088B10EA41A936A83AC51470FC_595391051 =             mGottenCallbacks;
            var045A4A088B10EA41A936A83AC51470FC_595391051.addTaint(taint);
            return var045A4A088B10EA41A936A83AC51470FC_595391051;
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
SurfaceHolder.Callback[] var045A4A088B10EA41A936A83AC51470FC_1034857724 =         mGottenCallbacks;
        var045A4A088B10EA41A936A83AC51470FC_1034857724.addTaint(taint);
        return var045A4A088B10EA41A936A83AC51470FC_1034857724;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.118 -0400", hash_original_method = "B038D0F820D93ACBDF8182E2BE5C1116", hash_generated_method = "B4DB9781FDECFBFCC3D06A75C53FB30C")
    public void ungetCallbacks() {
        mHaveGottenCallbacks = false;
        // ---------- Original Method ----------
        //mHaveGottenCallbacks = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.119 -0400", hash_original_method = "00011C38E6EC925AC8838B7EF1A5974E", hash_generated_method = "14A38DDB81B1BF210BA107E1623F7138")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.119 -0400", hash_original_method = "3FBBAABB359B15ECFE32A5B65108D82E", hash_generated_method = "102820B7C68EBAAA880C0400C26C6278")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.120 -0400", hash_original_method = "FD1656C90E0BF9DD59BF1C1951F6D90A", hash_generated_method = "6D399A1395157D1C1B30B10DD37EBD09")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.120 -0400", hash_original_method = "EAFF612A3F1F2919ED355687F3DB192A", hash_generated_method = "4B780B2C456CC5952F8EB8ACACF21493")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.120 -0400", hash_original_method = "62E11A68BFE49B76328D9C868319D907", hash_generated_method = "65F7D3C7162AD3ABACD89853E9317EC9")
    public Canvas lockCanvas() {
Canvas varDE61BB4FF724D2412289EA61714EB9A6_1563848311 =         internalLockCanvas(null);
        varDE61BB4FF724D2412289EA61714EB9A6_1563848311.addTaint(taint);
        return varDE61BB4FF724D2412289EA61714EB9A6_1563848311;
        // ---------- Original Method ----------
        //return internalLockCanvas(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.121 -0400", hash_original_method = "680C567FEFB26BF9B08DD2E5AA0C3FA9", hash_generated_method = "DBF866B4B7D9D11ACBFB29574A7A1DEE")
    public Canvas lockCanvas(Rect dirty) {
        addTaint(dirty.getTaint());
Canvas var78B0430AF4ECF3E90510E88412E9F8FF_1669231997 =         internalLockCanvas(dirty);
        var78B0430AF4ECF3E90510E88412E9F8FF_1669231997.addTaint(taint);
        return var78B0430AF4ECF3E90510E88412E9F8FF_1669231997;
        // ---------- Original Method ----------
        //return internalLockCanvas(dirty);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.121 -0400", hash_original_method = "ACAAC9086C35A7B567CF149ED3F96213", hash_generated_method = "5E9B05112B1A64D7DE962387DAA932A5")
    private final Canvas internalLockCanvas(Rect dirty) {
        addTaint(dirty.getTaint());
        if(mType == SURFACE_TYPE_PUSH_BUFFERS)        
        {
            BadSurfaceTypeException var00366FDD1C7FB26465FD12593DB0FD1A_1292588810 = new BadSurfaceTypeException(
                    "Surface type is SURFACE_TYPE_PUSH_BUFFERS");
            var00366FDD1C7FB26465FD12593DB0FD1A_1292588810.addTaint(taint);
            throw var00366FDD1C7FB26465FD12593DB0FD1A_1292588810;
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
        if(DEBUG){ }        if(c != null)        
        {
            mLastLockTime = SystemClock.uptimeMillis();
Canvas var807FB10045EE51C06BDB74744A6714DF_595513232 =             c;
            var807FB10045EE51C06BDB74744A6714DF_595513232.addTaint(taint);
            return var807FB10045EE51C06BDB74744A6714DF_595513232;
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
Canvas var540C13E9E156B687226421B24F2DF178_5717766 =         null;
        var540C13E9E156B687226421B24F2DF178_5717766.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_5717766;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.122 -0400", hash_original_method = "94198D6DEEC3932A7E8E0C313FB26861", hash_generated_method = "702D8F7FDBE0CD8C6980161491EF2FEB")
    public void unlockCanvasAndPost(Canvas canvas) {
        addTaint(canvas.getTaint());
        mSurface.unlockCanvasAndPost(canvas);
        mSurfaceLock.unlock();
        // ---------- Original Method ----------
        //mSurface.unlockCanvasAndPost(canvas);
        //mSurfaceLock.unlock();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.122 -0400", hash_original_method = "FB03EEF08A419E6F5E4B7D4C32AA13C8", hash_generated_method = "F60BF4E16E1FB9A8559DD9098B50F3E0")
    public Surface getSurface() {
Surface varB7C98568942B156EFD367CE054011CDA_1617466249 =         mSurface;
        varB7C98568942B156EFD367CE054011CDA_1617466249.addTaint(taint);
        return varB7C98568942B156EFD367CE054011CDA_1617466249;
        // ---------- Original Method ----------
        //return mSurface;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.122 -0400", hash_original_method = "BE643F9C45A14CE663214357E2B511D8", hash_generated_method = "BF90D074AD62C4784C28D0EBCDB94A34")
    public Rect getSurfaceFrame() {
Rect varE9ECEDEA5A2368584CD71CAA52747028_1609100046 =         mSurfaceFrame;
        varE9ECEDEA5A2368584CD71CAA52747028_1609100046.addTaint(taint);
        return varE9ECEDEA5A2368584CD71CAA52747028_1609100046;
        // ---------- Original Method ----------
        //return mSurfaceFrame;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.123 -0400", hash_original_method = "B2173B72636D8AF8E14456C4D20DEB0F", hash_generated_method = "3C164CF7F26EF369524BF1E8345A5299")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.123 -0400", hash_original_field = "07DBC32137B9D5FFE392E2171940A81D", hash_generated_field = "25EA1DB5DFEC23EE8B60521742AF8CB0")

    private static final String TAG = "BaseSurfaceHolder";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.123 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")

    static final boolean DEBUG = false;
}

