package com.android.internal.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.Surface;
import android.view.SurfaceHolder;

public abstract class BaseSurfaceHolder implements SurfaceHolder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.855 -0500", hash_original_field = "EAFBA95484B3EFA9190AA696CD5D3C5E", hash_generated_field = "25EA1DB5DFEC23EE8B60521742AF8CB0")

    private static final String TAG = "BaseSurfaceHolder";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.857 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")

    static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.860 -0500", hash_original_field = "245DBB681D9BCEAB91C3AF9BEFD14B0B", hash_generated_field = "E2B111E4E2AF9D070F427E06A59175AE")

    public final ArrayList<SurfaceHolder.Callback> mCallbacks
            = new ArrayList<SurfaceHolder.Callback>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.862 -0500", hash_original_field = "767D60A6E3C8EEF6EF9A0A1954F0A20E", hash_generated_field = "767D60A6E3C8EEF6EF9A0A1954F0A20E")

    SurfaceHolder.Callback[] mGottenCallbacks;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.864 -0500", hash_original_field = "AF697DFEEDD2FFAC42B82ED08BC1177F", hash_generated_field = "AF697DFEEDD2FFAC42B82ED08BC1177F")

    boolean mHaveGottenCallbacks;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.866 -0500", hash_original_field = "F02D12B5BB0722412233675ECD5E628C", hash_generated_field = "75EFD538893F5DD13B0AD54DB0DA969B")
    
    public final ReentrantLock mSurfaceLock = new ReentrantLock();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.868 -0500", hash_original_field = "1124ED61F6BA8AE3DABDAA886BC252C4", hash_generated_field = "1AC64A6B091D59168F964952F2A6F53B")

    public Surface mSurface = new Surface();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.870 -0500", hash_original_field = "F9EC238B16254BED53BCBCEFBD6EF45D", hash_generated_field = "F9EC238B16254BED53BCBCEFBD6EF45D")

    int mRequestedWidth = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.872 -0500", hash_original_field = "C329ECB2BC7D94AC739801F768FE2BE6", hash_generated_field = "C329ECB2BC7D94AC739801F768FE2BE6")

    int mRequestedHeight = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.874 -0500", hash_original_field = "864B35ECB9DEE9D1FDC09440C4076385", hash_generated_field = "BE1DBBDAE20148CACEDA6DF736D8CA2E")

    protected int mRequestedFormat = PixelFormat.OPAQUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.877 -0500", hash_original_field = "65788EBA442CE964EE645934A86AEABE", hash_generated_field = "65788EBA442CE964EE645934A86AEABE")

    int mRequestedType = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.879 -0500", hash_original_field = "0FB69CE58A9B36474A3E521462C289A0", hash_generated_field = "0FB69CE58A9B36474A3E521462C289A0")

    long mLastLockTime = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.882 -0500", hash_original_field = "DE07B82DC42B56613109CDBFD4F50C15", hash_generated_field = "DE07B82DC42B56613109CDBFD4F50C15")
    
    int mType = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.884 -0500", hash_original_field = "F621A8E01339D28C0B8365EF1B47521B", hash_generated_field = "5FF70CE962F22D930D1FDE55775FEDAE")

    final Rect mSurfaceFrame = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.887 -0500", hash_original_field = "0C3E6D0D62BE6C4E33545B05306C722E", hash_generated_field = "0C3E6D0D62BE6C4E33545B05306C722E")

    Rect mTmpDirty;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.115 -0400", hash_original_method = "65236AFB54FAB65BD2FC1C8CD2966A75", hash_generated_method = "65236AFB54FAB65BD2FC1C8CD2966A75")
    public BaseSurfaceHolder ()
    {
        //Synthesized constructor
    }
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.889 -0500", hash_original_method = "62B1F3CDE0CFE8F424A091124E64C21C", hash_generated_method = "4C355A9611E681A0E227B95CF7B6B06E")
    
public abstract void onUpdateSurface();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.892 -0500", hash_original_method = "0456BAE58505BE6C54BA87CBC72C93A6", hash_generated_method = "9CD58D2F79A4E3673260F3DE6A20F69A")
    
public abstract void onRelayoutContainer();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.894 -0500", hash_original_method = "18B17FF26B6C18534F6D562146AC8F13", hash_generated_method = "2D402E0D90B2D4C04BEA6806D0BC7652")
    
public abstract boolean onAllowLockCanvas();
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.896 -0500", hash_original_method = "3AF431EE7D6883EB1B4141BFAE213C2E", hash_generated_method = "B67C3BF256340C15E666623C5D80BD7B")
    
public int getRequestedWidth() {
        return mRequestedWidth;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.899 -0500", hash_original_method = "2ED2833D03220673A510D00698E2D0FF", hash_generated_method = "842BAD34755AF8AB84A088EE9F34B280")
    
public int getRequestedHeight() {
        return mRequestedHeight;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.902 -0500", hash_original_method = "E655118A2C284546E2D290C1F5BE4CAA", hash_generated_method = "B260BF7E77F89DAAEA13BEBD7024D418")
    
public int getRequestedFormat() {
        return mRequestedFormat;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.904 -0500", hash_original_method = "1ADEF52CA934B4124985C64931FCC871", hash_generated_method = "DA9E1D51DB5406E1A4891383D6B91A6A")
    
public int getRequestedType() {
        return mRequestedType;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.908 -0500", hash_original_method = "A6B53DAA62C6D5AB170B791AD6D4E39D", hash_generated_method = "30D95F1DFB9C284DED444A79AC31DC07")
    @DSVerified("Calling callbacks ")
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void addCallback(Callback callback) {
        synchronized (mCallbacks) {
            // This is a linear search, but in practice we'll 
            // have only a couple callbacks, so it doesn't matter.
            if (mCallbacks.contains(callback) == false) {      
                mCallbacks.add(callback);
            }
        }
        if (callback != null) {
            callback.surfaceCreated(this);
            callback.surfaceChanged(this, DSUtils.FAKE_INT, DSUtils.FAKE_INT, DSUtils.FAKE_INT);
            callback.surfaceDestroyed(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.910 -0500", hash_original_method = "C2F2686F3B633A931E5A1A7B954047E4", hash_generated_method = "4C1FB150E92184E19C89CA8156735997")
    
public void removeCallback(Callback callback) {
        synchronized (mCallbacks) {
            mCallbacks.remove(callback);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.913 -0500", hash_original_method = "2E153784742E80414EA6460F2018158D", hash_generated_method = "D053F8FC68A3122604228CFFCEB6A1D9")
    
public SurfaceHolder.Callback[] getCallbacks() {
        if (mHaveGottenCallbacks) {
            return mGottenCallbacks;
        }
        
        synchronized (mCallbacks) {
            final int N = mCallbacks.size();
            if (N > 0) {
                if (mGottenCallbacks == null || mGottenCallbacks.length != N) {
                    mGottenCallbacks = new SurfaceHolder.Callback[N];
                }
                mCallbacks.toArray(mGottenCallbacks);
            } else {
                mGottenCallbacks = null;
            }
            mHaveGottenCallbacks = true;
        }
        
        return mGottenCallbacks;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.915 -0500", hash_original_method = "B038D0F820D93ACBDF8182E2BE5C1116", hash_generated_method = "00841F2901E3DB060FA8D4AB019B4A84")
    
public void ungetCallbacks() {
        mHaveGottenCallbacks = false;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.918 -0500", hash_original_method = "00011C38E6EC925AC8838B7EF1A5974E", hash_generated_method = "BCE2DDA22409E04B5512706CFF56F9AF")
    
public void setFixedSize(int width, int height) {
        if (mRequestedWidth != width || mRequestedHeight != height) {
            mRequestedWidth = width;
            mRequestedHeight = height;
            onRelayoutContainer();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.920 -0500", hash_original_method = "3FBBAABB359B15ECFE32A5B65108D82E", hash_generated_method = "2BCE3B9729E846CE579101B1346C68DF")
    
public void setSizeFromLayout() {
        if (mRequestedWidth != -1 || mRequestedHeight != -1) {
            mRequestedWidth = mRequestedHeight = -1;
            onRelayoutContainer();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.922 -0500", hash_original_method = "FD1656C90E0BF9DD59BF1C1951F6D90A", hash_generated_method = "D480D831E75DE0DD69421763C2E4ABED")
    
public void setFormat(int format) {
        if (mRequestedFormat != format) {
            mRequestedFormat = format;
            onUpdateSurface();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.924 -0500", hash_original_method = "EAFF612A3F1F2919ED355687F3DB192A", hash_generated_method = "CE5FF7DDCEF30980A1FD3B2BBC98DF5F")
    
public void setType(int type) {
        switch (type) {
        case SURFACE_TYPE_HARDWARE:
        case SURFACE_TYPE_GPU:
            // these are deprecated, treat as "NORMAL"
            type = SURFACE_TYPE_NORMAL;
            break;
        }
        switch (type) {
        case SURFACE_TYPE_NORMAL:
        case SURFACE_TYPE_PUSH_BUFFERS:
            if (mRequestedType != type) {
                mRequestedType = type;
                onUpdateSurface();
            }
            break;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.927 -0500", hash_original_method = "62E11A68BFE49B76328D9C868319D907", hash_generated_method = "4C0E121027D4B5F23A9CF38E716D9DA7")
    
public Canvas lockCanvas() {
        return internalLockCanvas(null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.930 -0500", hash_original_method = "680C567FEFB26BF9B08DD2E5AA0C3FA9", hash_generated_method = "C79D06113216717AE7F28C1690800E1E")
    
public Canvas lockCanvas(Rect dirty) {
        return internalLockCanvas(dirty);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.933 -0500", hash_original_method = "ACAAC9086C35A7B567CF149ED3F96213", hash_generated_method = "71214A6B5AE9CB6BFAD07E9025A9B3B0")
    
private final Canvas internalLockCanvas(Rect dirty) {
        if (mType == SURFACE_TYPE_PUSH_BUFFERS) {
            throw new BadSurfaceTypeException(
                    "Surface type is SURFACE_TYPE_PUSH_BUFFERS");
        }
        mSurfaceLock.lock();

        if (DEBUG) Log.i(TAG, "Locking canvas..,");

        Canvas c = null;
        if (onAllowLockCanvas()) {
            if (dirty == null) {
                if (mTmpDirty == null) {
                    mTmpDirty = new Rect();
                }
                mTmpDirty.set(mSurfaceFrame);
                dirty = mTmpDirty;
            }

            try {
                c = mSurface.lockCanvas(dirty);
            } catch (Exception e) {
                Log.e(TAG, "Exception locking surface", e);
            }
        }

        if (DEBUG) Log.i(TAG, "Returned canvas: " + c);
        if (c != null) {
            mLastLockTime = SystemClock.uptimeMillis();
            return c;
        }
        
        // If the Surface is not ready to be drawn, then return null,
        // but throttle calls to this function so it isn't called more
        // than every 100ms.
        long now = SystemClock.uptimeMillis();
        long nextTime = mLastLockTime + 100;
        if (nextTime > now) {
            try {
                Thread.sleep(nextTime-now);
            } catch (InterruptedException e) {
            }
            now = SystemClock.uptimeMillis();
        }
        mLastLockTime = now;
        mSurfaceLock.unlock();
        
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.936 -0500", hash_original_method = "94198D6DEEC3932A7E8E0C313FB26861", hash_generated_method = "8D8A8BF4B87BB14390724BCFB51E5EB2")
    
public void unlockCanvasAndPost(Canvas canvas) {
        mSurface.unlockCanvasAndPost(canvas);
        mSurfaceLock.unlock();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.938 -0500", hash_original_method = "FB03EEF08A419E6F5E4B7D4C32AA13C8", hash_generated_method = "2AAD7E290BC377BCEC98E2821A948720")
    
public Surface getSurface() {
        return mSurface;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.941 -0500", hash_original_method = "BE643F9C45A14CE663214357E2B511D8", hash_generated_method = "952442CC0A609055D8F20CD44FE8CA9F")
    
public Rect getSurfaceFrame() {
        return mSurfaceFrame;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:31.944 -0500", hash_original_method = "B2173B72636D8AF8E14456C4D20DEB0F", hash_generated_method = "2142AE9B301E658322B43FA2F8DD3787")
    
public void setSurfaceFrameSize(int width, int height) {
        mSurfaceFrame.addTaint(width + height);
/*
        mSurfaceFrame.top = 0;
        mSurfaceFrame.left = 0;
        mSurfaceFrame.right = width;
        mSurfaceFrame.bottom = height;
*/
    }
}

