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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.204 -0400", hash_original_field = "5B2965AE5247A9A1234D4FDCDF03BACD", hash_generated_field = "DAD5B9AEA76C8FEEB47BD2ED52F068FB")

    public ArrayList<SurfaceHolder.Callback> mCallbacks = new ArrayList<SurfaceHolder.Callback>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.204 -0400", hash_original_field = "CB3592545E4E8601CEB2C87E04ACA3C8", hash_generated_field = "767D60A6E3C8EEF6EF9A0A1954F0A20E")

    SurfaceHolder.Callback[] mGottenCallbacks;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.204 -0400", hash_original_field = "CE33D374F2ECCAA50E236A8A9FFC4D4A", hash_generated_field = "AF697DFEEDD2FFAC42B82ED08BC1177F")

    boolean mHaveGottenCallbacks;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.204 -0400", hash_original_field = "52392AFCA83FA6F6A2B3A89B48CC1408", hash_generated_field = "593BD5F967ACB75D5BFC0F7CDB6A5A31")

    public ReentrantLock mSurfaceLock = new ReentrantLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.204 -0400", hash_original_field = "41551392C18EC9CD321667F2791AD52A", hash_generated_field = "1AC64A6B091D59168F964952F2A6F53B")

    public Surface mSurface = new Surface();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.204 -0400", hash_original_field = "8A5806C480FF6E75927A4F1D6AFC8E5D", hash_generated_field = "F9EC238B16254BED53BCBCEFBD6EF45D")

    int mRequestedWidth = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.204 -0400", hash_original_field = "62C4EF08A7A4B3F04161E6472DF8ACF1", hash_generated_field = "C329ECB2BC7D94AC739801F768FE2BE6")

    int mRequestedHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.205 -0400", hash_original_field = "FC2891F47AE8C369C7217A6DCFB264B1", hash_generated_field = "BE1DBBDAE20148CACEDA6DF736D8CA2E")

    protected int mRequestedFormat = PixelFormat.OPAQUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.205 -0400", hash_original_field = "1A329DE391B524BAC042F5A1B7CD3367", hash_generated_field = "65788EBA442CE964EE645934A86AEABE")

    int mRequestedType = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.205 -0400", hash_original_field = "D42022960F60B4E9A38A4C00D0651E27", hash_generated_field = "0FB69CE58A9B36474A3E521462C289A0")

    long mLastLockTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.205 -0400", hash_original_field = "7EC2C3003126A3993EB506D83DE073E3", hash_generated_field = "DE07B82DC42B56613109CDBFD4F50C15")

    int mType = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.205 -0400", hash_original_field = "430EE1EE1C2CEA5C342BF8D9010C8AB2", hash_generated_field = "F621A8E01339D28C0B8365EF1B47521B")

    Rect mSurfaceFrame = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.205 -0400", hash_original_field = "EE99E1DF5AAD9573B58AE4256DDE7025", hash_generated_field = "0C3E6D0D62BE6C4E33545B05306C722E")

    Rect mTmpDirty;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.205 -0400", hash_original_method = "65236AFB54FAB65BD2FC1C8CD2966A75", hash_generated_method = "65236AFB54FAB65BD2FC1C8CD2966A75")
    public BaseSurfaceHolder ()
    {
        //Synthesized constructor
    }


    public abstract void onUpdateSurface();

    
    public abstract void onRelayoutContainer();

    
    public abstract boolean onAllowLockCanvas();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.206 -0400", hash_original_method = "3AF431EE7D6883EB1B4141BFAE213C2E", hash_generated_method = "961EC3DC8F11762A4F7073E30EC5BA0F")
    public int getRequestedWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960658755 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960658755;
        // ---------- Original Method ----------
        //return mRequestedWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.206 -0400", hash_original_method = "2ED2833D03220673A510D00698E2D0FF", hash_generated_method = "2EE51EAD374CF43B114CE9BD0BE5CECE")
    public int getRequestedHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1540557893 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1540557893;
        // ---------- Original Method ----------
        //return mRequestedHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.206 -0400", hash_original_method = "E655118A2C284546E2D290C1F5BE4CAA", hash_generated_method = "A35F5AE803F54E534947B13632273F11")
    public int getRequestedFormat() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1007368888 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1007368888;
        // ---------- Original Method ----------
        //return mRequestedFormat;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.206 -0400", hash_original_method = "1ADEF52CA934B4124985C64931FCC871", hash_generated_method = "0EBE0244137EB5E4AED2AF18890C513E")
    public int getRequestedType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_958077427 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_958077427;
        // ---------- Original Method ----------
        //return mRequestedType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.211 -0400", hash_original_method = "A6B53DAA62C6D5AB170B791AD6D4E39D", hash_generated_method = "FFD6200C5ACBE670628BA9CD8F993DCE")
    public void addCallback(Callback callback) {
        {
            {
                boolean var79298CC453B6F7A4BA249985464ED319_125785796 = (mCallbacks.contains(callback) == false);
                {
                    mCallbacks.add(callback);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //synchronized (mCallbacks) {
            //if (mCallbacks.contains(callback) == false) {      
                //mCallbacks.add(callback);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.212 -0400", hash_original_method = "C2F2686F3B633A931E5A1A7B954047E4", hash_generated_method = "DB035C8CD46FF3BDF3B8256D88449CEF")
    public void removeCallback(Callback callback) {
        {
            mCallbacks.remove(callback);
        } //End block
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //synchronized (mCallbacks) {
            //mCallbacks.remove(callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.229 -0400", hash_original_method = "2E153784742E80414EA6460F2018158D", hash_generated_method = "366E74307375BD3462CF7FC499E794E7")
    public SurfaceHolder.Callback[] getCallbacks() {
        SurfaceHolder.Callback[] varB4EAC82CA7396A68D541C85D26508E83_1443990343 = null; //Variable for return #1
        SurfaceHolder.Callback[] varB4EAC82CA7396A68D541C85D26508E83_57889290 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1443990343 = mGottenCallbacks;
        } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_57889290 = mGottenCallbacks;
        SurfaceHolder.Callback[] varA7E53CE21691AB073D9660D615818899_1462422212; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1462422212 = varB4EAC82CA7396A68D541C85D26508E83_1443990343;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1462422212 = varB4EAC82CA7396A68D541C85D26508E83_57889290;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1462422212.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1462422212;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.229 -0400", hash_original_method = "B038D0F820D93ACBDF8182E2BE5C1116", hash_generated_method = "B4DB9781FDECFBFCC3D06A75C53FB30C")
    public void ungetCallbacks() {
        mHaveGottenCallbacks = false;
        // ---------- Original Method ----------
        //mHaveGottenCallbacks = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.229 -0400", hash_original_method = "00011C38E6EC925AC8838B7EF1A5974E", hash_generated_method = "0528B810B6A42837976DB925182A1716")
    public void setFixedSize(int width, int height) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.230 -0400", hash_original_method = "3FBBAABB359B15ECFE32A5B65108D82E", hash_generated_method = "D23D2D70A4076C4419E92C588649BD99")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.230 -0400", hash_original_method = "FD1656C90E0BF9DD59BF1C1951F6D90A", hash_generated_method = "63C253D5078CA68DA1265329990C086C")
    public void setFormat(int format) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.231 -0400", hash_original_method = "EAFF612A3F1F2919ED355687F3DB192A", hash_generated_method = "A0000F602262D806B6DDF7A25977B31F")
    public void setType(int type) {
        //Begin case SURFACE_TYPE_HARDWARE SURFACE_TYPE_GPU 
        type = SURFACE_TYPE_NORMAL;
        //End case SURFACE_TYPE_HARDWARE SURFACE_TYPE_GPU 
        //Begin case SURFACE_TYPE_NORMAL SURFACE_TYPE_PUSH_BUFFERS 
        {
            mRequestedType = type;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.231 -0400", hash_original_method = "62E11A68BFE49B76328D9C868319D907", hash_generated_method = "B3063DA918F61AC78E37ABAC353356C6")
    public Canvas lockCanvas() {
        Canvas varB4EAC82CA7396A68D541C85D26508E83_2100671831 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2100671831 = internalLockCanvas(null);
        varB4EAC82CA7396A68D541C85D26508E83_2100671831.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2100671831;
        // ---------- Original Method ----------
        //return internalLockCanvas(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.238 -0400", hash_original_method = "680C567FEFB26BF9B08DD2E5AA0C3FA9", hash_generated_method = "9BEFB4F61E43C0EDEB5AA1B0801875B3")
    public Canvas lockCanvas(Rect dirty) {
        Canvas varB4EAC82CA7396A68D541C85D26508E83_784030763 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_784030763 = internalLockCanvas(dirty);
        addTaint(dirty.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_784030763.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_784030763;
        // ---------- Original Method ----------
        //return internalLockCanvas(dirty);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.243 -0400", hash_original_method = "ACAAC9086C35A7B567CF149ED3F96213", hash_generated_method = "88B6E5338F9CF1A3D6378AEE5C684453")
    private final Canvas internalLockCanvas(Rect dirty) {
        Canvas varB4EAC82CA7396A68D541C85D26508E83_818410159 = null; //Variable for return #1
        Canvas varB4EAC82CA7396A68D541C85D26508E83_1283772545 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new BadSurfaceTypeException(
                    "Surface type is SURFACE_TYPE_PUSH_BUFFERS");
        } //End block
        mSurfaceLock.lock();
        Canvas c;
        c = null;
        {
            boolean var43C0ADBD79E0A1490425EC9B0C1E3110_333053601 = (onAllowLockCanvas());
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
            varB4EAC82CA7396A68D541C85D26508E83_818410159 = c;
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
        varB4EAC82CA7396A68D541C85D26508E83_1283772545 = null;
        addTaint(dirty.getTaint());
        Canvas varA7E53CE21691AB073D9660D615818899_1588742789; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1588742789 = varB4EAC82CA7396A68D541C85D26508E83_818410159;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1588742789 = varB4EAC82CA7396A68D541C85D26508E83_1283772545;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1588742789.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1588742789;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.247 -0400", hash_original_method = "94198D6DEEC3932A7E8E0C313FB26861", hash_generated_method = "DF654BF347DD18B3ED2B0613B73B292C")
    public void unlockCanvasAndPost(Canvas canvas) {
        mSurface.unlockCanvasAndPost(canvas);
        mSurfaceLock.unlock();
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        //mSurface.unlockCanvasAndPost(canvas);
        //mSurfaceLock.unlock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.251 -0400", hash_original_method = "FB03EEF08A419E6F5E4B7D4C32AA13C8", hash_generated_method = "485ADABFDE4B9494DF7A968476C4258A")
    public Surface getSurface() {
        Surface varB4EAC82CA7396A68D541C85D26508E83_227209240 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_227209240 = mSurface;
        varB4EAC82CA7396A68D541C85D26508E83_227209240.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_227209240;
        // ---------- Original Method ----------
        //return mSurface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.252 -0400", hash_original_method = "BE643F9C45A14CE663214357E2B511D8", hash_generated_method = "4D514CEED0520ED7161A4FF79EEFFE33")
    public Rect getSurfaceFrame() {
        Rect varB4EAC82CA7396A68D541C85D26508E83_590761117 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_590761117 = mSurfaceFrame;
        varB4EAC82CA7396A68D541C85D26508E83_590761117.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_590761117;
        // ---------- Original Method ----------
        //return mSurfaceFrame;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.252 -0400", hash_original_method = "B2173B72636D8AF8E14456C4D20DEB0F", hash_generated_method = "3C164CF7F26EF369524BF1E8345A5299")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.252 -0400", hash_original_field = "07DBC32137B9D5FFE392E2171940A81D", hash_generated_field = "CF7B63DD90334249074F02CC6CCA3555")

    private static String TAG = "BaseSurfaceHolder";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.252 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "99DFF1318F5BF79C590B7B00A696225C")

    static boolean DEBUG = false;
}

