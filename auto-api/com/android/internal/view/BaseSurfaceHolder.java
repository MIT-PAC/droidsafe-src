package com.android.internal.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private static String TAG = "BaseSurfaceHolder";
    static boolean DEBUG = false;
    public ArrayList<SurfaceHolder.Callback> mCallbacks
            = new ArrayList<SurfaceHolder.Callback>();
    SurfaceHolder.Callback[] mGottenCallbacks;
    boolean mHaveGottenCallbacks;
    public ReentrantLock mSurfaceLock = new ReentrantLock();
    public Surface mSurface = new Surface();
    int mRequestedWidth = -1;
    int mRequestedHeight = -1;
    protected int mRequestedFormat = PixelFormat.OPAQUE;
    int mRequestedType = -1;
    long mLastLockTime = 0;
    int mType = -1;
    Rect mSurfaceFrame = new Rect();
    Rect mTmpDirty;
    
    public abstract void onUpdateSurface();

    
    public abstract void onRelayoutContainer();

    
    public abstract boolean onAllowLockCanvas();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.790 -0400", hash_original_method = "3AF431EE7D6883EB1B4141BFAE213C2E", hash_generated_method = "827BDA8BAAE9FCFB7F85B32A5BC1C168")
    @DSModeled(DSC.SAFE)
    public int getRequestedWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRequestedWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.819 -0400", hash_original_method = "2ED2833D03220673A510D00698E2D0FF", hash_generated_method = "91D6250E90879B190F6546B73CBCC577")
    @DSModeled(DSC.SAFE)
    public int getRequestedHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRequestedHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.832 -0400", hash_original_method = "E655118A2C284546E2D290C1F5BE4CAA", hash_generated_method = "97797142448066BCC287C9F64A2F4836")
    @DSModeled(DSC.SAFE)
    public int getRequestedFormat() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRequestedFormat;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.849 -0400", hash_original_method = "1ADEF52CA934B4124985C64931FCC871", hash_generated_method = "43B8EC007384CA595D6F7983050C9343")
    @DSModeled(DSC.SAFE)
    public int getRequestedType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRequestedType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.869 -0400", hash_original_method = "A6B53DAA62C6D5AB170B791AD6D4E39D", hash_generated_method = "CFF82E736F74A038CA3E83F67FEE329E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addCallback(Callback callback) {
        dsTaint.addTaint(callback.dsTaint);
        {
            {
                boolean var79298CC453B6F7A4BA249985464ED319_782691299 = (mCallbacks.contains(callback) == false);
                {
                    mCallbacks.add(callback);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (mCallbacks) {
            //if (mCallbacks.contains(callback) == false) {      
                //mCallbacks.add(callback);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.920 -0400", hash_original_method = "C2F2686F3B633A931E5A1A7B954047E4", hash_generated_method = "76281467CAA4559B07B8C21C20C09EDD")
    @DSModeled(DSC.SAFE)
    public void removeCallback(Callback callback) {
        dsTaint.addTaint(callback.dsTaint);
        {
            mCallbacks.remove(callback);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mCallbacks) {
            //mCallbacks.remove(callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.949 -0400", hash_original_method = "2E153784742E80414EA6460F2018158D", hash_generated_method = "602133F373112F3A81B3449AB37F5ACB")
    @DSModeled(DSC.SAFE)
    public SurfaceHolder.Callback[] getCallbacks() {
        {
            int N;
            N = mCallbacks.size();
            {
                {
                    mGottenCallbacks = new SurfaceHolder.Callback[N];
                } //End block
                mCallbacks.toArray(mGottenCallbacks);
            } //End block
            {
                mGottenCallbacks = null;
            } //End block
            mHaveGottenCallbacks = true;
        } //End block
        return (SurfaceHolder.Callback[])dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.977 -0400", hash_original_method = "B038D0F820D93ACBDF8182E2BE5C1116", hash_generated_method = "C591FEA46BA62808D5311FF61A73ED45")
    @DSModeled(DSC.SAFE)
    public void ungetCallbacks() {
        mHaveGottenCallbacks = false;
        // ---------- Original Method ----------
        //mHaveGottenCallbacks = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.005 -0400", hash_original_method = "00011C38E6EC925AC8838B7EF1A5974E", hash_generated_method = "627A2CF34C78AA038990BC5F62E82EA8")
    @DSModeled(DSC.SAFE)
    public void setFixedSize(int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        {
            onRelayoutContainer();
        } //End block
        // ---------- Original Method ----------
        //if (mRequestedWidth != width || mRequestedHeight != height) {
            //mRequestedWidth = width;
            //mRequestedHeight = height;
            //onRelayoutContainer();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.021 -0400", hash_original_method = "3FBBAABB359B15ECFE32A5B65108D82E", hash_generated_method = "9E56F1F2A9C2B82BE3D8A051F81FA2AF")
    @DSModeled(DSC.SAFE)
    public void setSizeFromLayout() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.027 -0400", hash_original_method = "FD1656C90E0BF9DD59BF1C1951F6D90A", hash_generated_method = "3BFA7F7E65B4FEB933E37F73E185823A")
    @DSModeled(DSC.SAFE)
    public void setFormat(int format) {
        dsTaint.addTaint(format);
        {
            onUpdateSurface();
        } //End block
        // ---------- Original Method ----------
        //if (mRequestedFormat != format) {
            //mRequestedFormat = format;
            //onUpdateSurface();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.068 -0400", hash_original_method = "EAFF612A3F1F2919ED355687F3DB192A", hash_generated_method = "398E2117A2207C9876E3AE69DF8390B7")
    @DSModeled(DSC.SAFE)
    public void setType(int type) {
        dsTaint.addTaint(type);
        //Begin case SURFACE_TYPE_HARDWARE SURFACE_TYPE_GPU 
        type = SURFACE_TYPE_NORMAL;
        //End case SURFACE_TYPE_HARDWARE SURFACE_TYPE_GPU 
        //Begin case SURFACE_TYPE_NORMAL SURFACE_TYPE_PUSH_BUFFERS 
        {
            onUpdateSurface();
        } //End block
        //End case SURFACE_TYPE_NORMAL SURFACE_TYPE_PUSH_BUFFERS 
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.109 -0400", hash_original_method = "62E11A68BFE49B76328D9C868319D907", hash_generated_method = "194A02660A651EC22881208FFDD6071F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Canvas lockCanvas() {
        Canvas varDCD444076620679FEBFD5654E04995DA_742372938 = (internalLockCanvas(null));
        return (Canvas)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return internalLockCanvas(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.130 -0400", hash_original_method = "680C567FEFB26BF9B08DD2E5AA0C3FA9", hash_generated_method = "F2CD78013E2489895BECC1472563389A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Canvas lockCanvas(Rect dirty) {
        dsTaint.addTaint(dirty.dsTaint);
        Canvas varAE30442AF157E58DE00BC863D96B2D4A_1280117013 = (internalLockCanvas(dirty));
        return (Canvas)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return internalLockCanvas(dirty);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.192 -0400", hash_original_method = "ACAAC9086C35A7B567CF149ED3F96213", hash_generated_method = "A1822B6A7095407942F41F03A12D81EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final Canvas internalLockCanvas(Rect dirty) {
        dsTaint.addTaint(dirty.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new BadSurfaceTypeException(
                    "Surface type is SURFACE_TYPE_PUSH_BUFFERS");
        } //End block
        mSurfaceLock.lock();
        Canvas c;
        c = null;
        {
            boolean var43C0ADBD79E0A1490425EC9B0C1E3110_1892300419 = (onAllowLockCanvas());
            {
                {
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
                { }
            } //End block
        } //End collapsed parenthetic
        {
            mLastLockTime = SystemClock.uptimeMillis();
        } //End block
        long now;
        now = SystemClock.uptimeMillis();
        long nextTime;
        nextTime = mLastLockTime + 100;
        {
            try 
            {
                Thread.sleep(nextTime-now);
            } //End block
            catch (InterruptedException e)
            { }
            now = SystemClock.uptimeMillis();
        } //End block
        mLastLockTime = now;
        mSurfaceLock.unlock();
        return (Canvas)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.222 -0400", hash_original_method = "94198D6DEEC3932A7E8E0C313FB26861", hash_generated_method = "9ACFE5B580BE043B7235595332F94CB9")
    @DSModeled(DSC.SAFE)
    public void unlockCanvasAndPost(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        mSurface.unlockCanvasAndPost(canvas);
        mSurfaceLock.unlock();
        // ---------- Original Method ----------
        //mSurface.unlockCanvasAndPost(canvas);
        //mSurfaceLock.unlock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.243 -0400", hash_original_method = "FB03EEF08A419E6F5E4B7D4C32AA13C8", hash_generated_method = "C6283542455A71726493ABA0EB18310B")
    @DSModeled(DSC.SAFE)
    public Surface getSurface() {
        return (Surface)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSurface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.249 -0400", hash_original_method = "BE643F9C45A14CE663214357E2B511D8", hash_generated_method = "85CFB6277076C7B3AE3561A9083FAF91")
    @DSModeled(DSC.SAFE)
    public Rect getSurfaceFrame() {
        return (Rect)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSurfaceFrame;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.271 -0400", hash_original_method = "B2173B72636D8AF8E14456C4D20DEB0F", hash_generated_method = "B4FA526266AAFED55E07500772461F9C")
    @DSModeled(DSC.SAFE)
    public void setSurfaceFrameSize(int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
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

    
}


