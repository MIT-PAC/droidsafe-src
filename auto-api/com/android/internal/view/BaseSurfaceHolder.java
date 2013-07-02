package com.android.internal.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.114 -0400", hash_original_field = "5B2965AE5247A9A1234D4FDCDF03BACD", hash_generated_field = "E2B111E4E2AF9D070F427E06A59175AE")

    public final ArrayList<SurfaceHolder.Callback> mCallbacks = new ArrayList<SurfaceHolder.Callback>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.114 -0400", hash_original_field = "CB3592545E4E8601CEB2C87E04ACA3C8", hash_generated_field = "767D60A6E3C8EEF6EF9A0A1954F0A20E")

    SurfaceHolder.Callback[] mGottenCallbacks;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.114 -0400", hash_original_field = "CE33D374F2ECCAA50E236A8A9FFC4D4A", hash_generated_field = "AF697DFEEDD2FFAC42B82ED08BC1177F")

    boolean mHaveGottenCallbacks;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.114 -0400", hash_original_field = "52392AFCA83FA6F6A2B3A89B48CC1408", hash_generated_field = "75EFD538893F5DD13B0AD54DB0DA969B")

    public final ReentrantLock mSurfaceLock = new ReentrantLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.114 -0400", hash_original_field = "41551392C18EC9CD321667F2791AD52A", hash_generated_field = "1AC64A6B091D59168F964952F2A6F53B")

    public Surface mSurface = new Surface();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.114 -0400", hash_original_field = "8A5806C480FF6E75927A4F1D6AFC8E5D", hash_generated_field = "F9EC238B16254BED53BCBCEFBD6EF45D")

    int mRequestedWidth = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.114 -0400", hash_original_field = "62C4EF08A7A4B3F04161E6472DF8ACF1", hash_generated_field = "C329ECB2BC7D94AC739801F768FE2BE6")

    int mRequestedHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.114 -0400", hash_original_field = "FC2891F47AE8C369C7217A6DCFB264B1", hash_generated_field = "BE1DBBDAE20148CACEDA6DF736D8CA2E")

    protected int mRequestedFormat = PixelFormat.OPAQUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.114 -0400", hash_original_field = "1A329DE391B524BAC042F5A1B7CD3367", hash_generated_field = "65788EBA442CE964EE645934A86AEABE")

    int mRequestedType = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.115 -0400", hash_original_field = "D42022960F60B4E9A38A4C00D0651E27", hash_generated_field = "0FB69CE58A9B36474A3E521462C289A0")

    long mLastLockTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.115 -0400", hash_original_field = "7EC2C3003126A3993EB506D83DE073E3", hash_generated_field = "DE07B82DC42B56613109CDBFD4F50C15")

    int mType = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.115 -0400", hash_original_field = "430EE1EE1C2CEA5C342BF8D9010C8AB2", hash_generated_field = "5FF70CE962F22D930D1FDE55775FEDAE")

    final Rect mSurfaceFrame = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.115 -0400", hash_original_field = "EE99E1DF5AAD9573B58AE4256DDE7025", hash_generated_field = "0C3E6D0D62BE6C4E33545B05306C722E")

    Rect mTmpDirty;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.115 -0400", hash_original_method = "65236AFB54FAB65BD2FC1C8CD2966A75", hash_generated_method = "65236AFB54FAB65BD2FC1C8CD2966A75")
    public BaseSurfaceHolder ()
    {
        
    }


    public abstract void onUpdateSurface();

    
    public abstract void onRelayoutContainer();

    
    public abstract boolean onAllowLockCanvas();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.116 -0400", hash_original_method = "3AF431EE7D6883EB1B4141BFAE213C2E", hash_generated_method = "90487B388ABAFC360F3BCAA7386FBA86")
    public int getRequestedWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_806339609 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_806339609;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.116 -0400", hash_original_method = "2ED2833D03220673A510D00698E2D0FF", hash_generated_method = "8874E2AEA35AC3D41271624763741770")
    public int getRequestedHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460876303 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460876303;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.116 -0400", hash_original_method = "E655118A2C284546E2D290C1F5BE4CAA", hash_generated_method = "5D8561A54DF63CEF6125358D3C11EB4D")
    public int getRequestedFormat() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1821517321 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1821517321;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.117 -0400", hash_original_method = "1ADEF52CA934B4124985C64931FCC871", hash_generated_method = "BF4ECB9FE03C9CAF14D3144E370AF34E")
    public int getRequestedType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1109176824 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1109176824;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.117 -0400", hash_original_method = "A6B53DAA62C6D5AB170B791AD6D4E39D", hash_generated_method = "359AF1C4B3FC1CAE0A6A54E9AB5C014D")
    public void addCallback(Callback callback) {
        {
            {
                boolean var79298CC453B6F7A4BA249985464ED319_757785080 = (mCallbacks.contains(callback) == false);
                {
                    mCallbacks.add(callback);
                } 
            } 
        } 
        addTaint(callback.getTaint());
        
        
            
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.117 -0400", hash_original_method = "C2F2686F3B633A931E5A1A7B954047E4", hash_generated_method = "DB035C8CD46FF3BDF3B8256D88449CEF")
    public void removeCallback(Callback callback) {
        {
            mCallbacks.remove(callback);
        } 
        addTaint(callback.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.118 -0400", hash_original_method = "2E153784742E80414EA6460F2018158D", hash_generated_method = "42A547F2C0619495D27B4EAF52FB44FC")
    public SurfaceHolder.Callback[] getCallbacks() {
        SurfaceHolder.Callback[] varB4EAC82CA7396A68D541C85D26508E83_1018052243 = null; 
        SurfaceHolder.Callback[] varB4EAC82CA7396A68D541C85D26508E83_661145861 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1018052243 = mGottenCallbacks;
        } 
        {
            final int N = mCallbacks.size();
            {
                {
                    mGottenCallbacks = new SurfaceHolder.Callback[N];
                } 
                mCallbacks.toArray(mGottenCallbacks);
            } 
            {
                mGottenCallbacks = null;
            } 
            mHaveGottenCallbacks = true;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_661145861 = mGottenCallbacks;
        SurfaceHolder.Callback[] varA7E53CE21691AB073D9660D615818899_296078296; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_296078296 = varB4EAC82CA7396A68D541C85D26508E83_1018052243;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_296078296 = varB4EAC82CA7396A68D541C85D26508E83_661145861;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_296078296.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_296078296;
        
        
            
        
        
            
            
                
                    
                
                
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.119 -0400", hash_original_method = "B038D0F820D93ACBDF8182E2BE5C1116", hash_generated_method = "B4DB9781FDECFBFCC3D06A75C53FB30C")
    public void ungetCallbacks() {
        mHaveGottenCallbacks = false;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.120 -0400", hash_original_method = "00011C38E6EC925AC8838B7EF1A5974E", hash_generated_method = "0528B810B6A42837976DB925182A1716")
    public void setFixedSize(int width, int height) {
        {
            mRequestedWidth = width;
            mRequestedHeight = height;
            onRelayoutContainer();
        } 
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.122 -0400", hash_original_method = "3FBBAABB359B15ECFE32A5B65108D82E", hash_generated_method = "D23D2D70A4076C4419E92C588649BD99")
    public void setSizeFromLayout() {
        {
            mRequestedWidth = mRequestedHeight = -1;
            onRelayoutContainer();
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.123 -0400", hash_original_method = "FD1656C90E0BF9DD59BF1C1951F6D90A", hash_generated_method = "63C253D5078CA68DA1265329990C086C")
    public void setFormat(int format) {
        {
            mRequestedFormat = format;
            onUpdateSurface();
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.124 -0400", hash_original_method = "EAFF612A3F1F2919ED355687F3DB192A", hash_generated_method = "A0000F602262D806B6DDF7A25977B31F")
    public void setType(int type) {
        
        type = SURFACE_TYPE_NORMAL;
        
        
        {
            mRequestedType = type;
            onUpdateSurface();
        } 
        
        
        
        
        
            
            
        
        
        
        
            
                
                
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.125 -0400", hash_original_method = "62E11A68BFE49B76328D9C868319D907", hash_generated_method = "3D49F63E6AD1C2313266A4636026F177")
    public Canvas lockCanvas() {
        Canvas varB4EAC82CA7396A68D541C85D26508E83_1876537202 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1876537202 = internalLockCanvas(null);
        varB4EAC82CA7396A68D541C85D26508E83_1876537202.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1876537202;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.126 -0400", hash_original_method = "680C567FEFB26BF9B08DD2E5AA0C3FA9", hash_generated_method = "5B753A8E0A6D553811DF2A1B358788AE")
    public Canvas lockCanvas(Rect dirty) {
        Canvas varB4EAC82CA7396A68D541C85D26508E83_1268423512 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1268423512 = internalLockCanvas(dirty);
        addTaint(dirty.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1268423512.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1268423512;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.127 -0400", hash_original_method = "ACAAC9086C35A7B567CF149ED3F96213", hash_generated_method = "D961A0ED9FED0827FEF36CBF22A85E4E")
    private final Canvas internalLockCanvas(Rect dirty) {
        Canvas varB4EAC82CA7396A68D541C85D26508E83_14753994 = null; 
        Canvas varB4EAC82CA7396A68D541C85D26508E83_1012586562 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new BadSurfaceTypeException(
                    "Surface type is SURFACE_TYPE_PUSH_BUFFERS");
        } 
        mSurfaceLock.lock();
        Canvas c = null;
        {
            boolean var43C0ADBD79E0A1490425EC9B0C1E3110_320136619 = (onAllowLockCanvas());
            {
                {
                    {
                        mTmpDirty = new Rect();
                    } 
                    mTmpDirty.set(mSurfaceFrame);
                    dirty = mTmpDirty;
                } 
                try 
                {
                    c = mSurface.lockCanvas(dirty);
                } 
                catch (Exception e)
                { }
            } 
        } 
        {
            mLastLockTime = SystemClock.uptimeMillis();
            varB4EAC82CA7396A68D541C85D26508E83_14753994 = c;
        } 
        long now = SystemClock.uptimeMillis();
        long nextTime = mLastLockTime + 100;
        {
            try 
            {
                Thread.sleep(nextTime-now);
            } 
            catch (InterruptedException e)
            { }
            now = SystemClock.uptimeMillis();
        } 
        mLastLockTime = now;
        mSurfaceLock.unlock();
        varB4EAC82CA7396A68D541C85D26508E83_1012586562 = null;
        addTaint(dirty.getTaint());
        Canvas varA7E53CE21691AB073D9660D615818899_2064311796; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2064311796 = varB4EAC82CA7396A68D541C85D26508E83_14753994;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2064311796 = varB4EAC82CA7396A68D541C85D26508E83_1012586562;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2064311796.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2064311796;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.127 -0400", hash_original_method = "94198D6DEEC3932A7E8E0C313FB26861", hash_generated_method = "DF654BF347DD18B3ED2B0613B73B292C")
    public void unlockCanvasAndPost(Canvas canvas) {
        mSurface.unlockCanvasAndPost(canvas);
        mSurfaceLock.unlock();
        addTaint(canvas.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.128 -0400", hash_original_method = "FB03EEF08A419E6F5E4B7D4C32AA13C8", hash_generated_method = "79D888470AA926AD86D3EC6268809772")
    public Surface getSurface() {
        Surface varB4EAC82CA7396A68D541C85D26508E83_1759742916 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1759742916 = mSurface;
        varB4EAC82CA7396A68D541C85D26508E83_1759742916.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1759742916;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.129 -0400", hash_original_method = "BE643F9C45A14CE663214357E2B511D8", hash_generated_method = "D81BBC0C6573503E610A08BCEF6DCB6F")
    public Rect getSurfaceFrame() {
        Rect varB4EAC82CA7396A68D541C85D26508E83_1453863897 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1453863897 = mSurfaceFrame;
        varB4EAC82CA7396A68D541C85D26508E83_1453863897.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1453863897;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.129 -0400", hash_original_method = "B2173B72636D8AF8E14456C4D20DEB0F", hash_generated_method = "3C164CF7F26EF369524BF1E8345A5299")
    public void setSurfaceFrameSize(int width, int height) {
        mSurfaceFrame.top = 0;
        mSurfaceFrame.left = 0;
        mSurfaceFrame.right = width;
        mSurfaceFrame.bottom = height;
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.129 -0400", hash_original_field = "07DBC32137B9D5FFE392E2171940A81D", hash_generated_field = "25EA1DB5DFEC23EE8B60521742AF8CB0")

    private static final String TAG = "BaseSurfaceHolder";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.129 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")

    static final boolean DEBUG = false;
}

