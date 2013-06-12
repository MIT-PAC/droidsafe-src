package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.res.CompatibilityInfo;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Slog;

public class Display {
    static final String TAG = "Display";
    static final boolean DEBUG_DISPLAY_SIZE = false;
    public static final int DEFAULT_DISPLAY = 0;
    private final CompatibilityInfoHolder mCompatibilityInfo;
    private final int   mDisplay;
    private int         mPixelFormat;
    private float       mRefreshRate;
    float   mDensity;
    float   mDpiX;
    float   mDpiY;
    private final Point mTmpPoint = new Point();
    private final DisplayMetrics mTmpMetrics = new DisplayMetrics();
    private float mLastGetTime;
    private static final Object sStaticInit = new Object();
    private static boolean sInitialized = false;
    private static IWindowManager sWindowManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.890 -0400", hash_original_method = "C9519A69B693719AC1491BF9F92C5C8E", hash_generated_method = "A079608BE9C6085E27DD0B70EF39892E")
    @DSModeled(DSC.SAFE)
     Display(int display, CompatibilityInfoHolder compatInfo) {
        dsTaint.addTaint(compatInfo.dsTaint);
        dsTaint.addTaint(display);
        
        mDisplay = display;
        {
            {
                nativeClassInit();
                sInitialized = true;
            } //End block
        } //End block
        mCompatibilityInfo = compatInfo != null ? compatInfo : new CompatibilityInfoHolder();
        init(display);
        // ---------- Original Method ----------
        //synchronized (sStaticInit) {
            //if (!sInitialized) {
                //nativeClassInit();
                //sInitialized = true;
            //}
        //}
        //mCompatibilityInfo = compatInfo != null ? compatInfo : new CompatibilityInfoHolder();
        //mDisplay = display;
        //init(display);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.890 -0400", hash_original_method = "107F25776C4AB2DB96852EDD25D31975", hash_generated_method = "6CBCC78EA59C51FB92FF4683F4C57302")
    @DSModeled(DSC.SAFE)
    public int getDisplayId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDisplay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.890 -0400", hash_original_method = "C7738F3BA7E3CBC02FD1519F5186496C", hash_generated_method = "8EE14134526D7DCD00E8241A0330267B")
    static int getDisplayCount() {
    	DSTaintObject taint = new DSTaintObject();
    	return taint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.890 -0400", hash_original_method = "17F24EABE37BDCE44DDE55CD705BD7B9", hash_generated_method = "4E6B49BDB5AA0979DCBD8C029D8E8525")
    @DSModeled(DSC.SAFE)
    public void getSize(Point outSize) {
        dsTaint.addTaint(outSize.dsTaint);
        getSizeInternal(outSize, true);
        // ---------- Original Method ----------
        //getSizeInternal(outSize, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.890 -0400", hash_original_method = "79B8C4439194701109AF7AA6129A555C", hash_generated_method = "E3A1D61CAAAC2B3E95794F567345EC26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void getSizeInternal(Point outSize, boolean doCompat) {
        dsTaint.addTaint(outSize.dsTaint);
        dsTaint.addTaint(doCompat);
        try 
        {
            IWindowManager wm;
            wm = getWindowManager();
            {
                wm.getDisplaySize(outSize);
                CompatibilityInfo ci = null;
                {
                    boolean var6BC58437C431C9232DA2904BF16DEF2E_1272002993 = (doCompat && (ci=mCompatibilityInfo.getIfNeeded()) != null);
                    {
                        {
                            mTmpMetrics.noncompatWidthPixels = outSize.x;
                            mTmpMetrics.noncompatHeightPixels = outSize.y;
                            mTmpMetrics.density = mDensity;
                            ci.applyToDisplayMetrics(mTmpMetrics);
                            outSize.x = mTmpMetrics.widthPixels;
                            outSize.y = mTmpMetrics.heightPixels;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                outSize.x = getRawWidth();
                outSize.y = getRawHeight();
            } //End block
            {
                RuntimeException here;
                here = new RuntimeException("here");
                here.fillInStackTrace();
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.890 -0400", hash_original_method = "92D5B5EBFB706321BDD6B906C6DF5945", hash_generated_method = "284C82B2EBAA9DA4938DCCC171E955EB")
    @DSModeled(DSC.SAFE)
    public void getRectSize(Rect outSize) {
        dsTaint.addTaint(outSize.dsTaint);
        {
            getSizeInternal(mTmpPoint, true);
            outSize.set(0, 0, mTmpPoint.x, mTmpPoint.y);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mTmpPoint) {
            //getSizeInternal(mTmpPoint, true);
            //outSize.set(0, 0, mTmpPoint.x, mTmpPoint.y);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.890 -0400", hash_original_method = "404C4EF6FA3AD3B9975B754C597D6C0E", hash_generated_method = "629166B0EF2DD40C667878E51428CA0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaximumSizeDimension() {
        try 
        {
            IWindowManager wm;
            wm = getWindowManager();
            int varC1FFFA445B088D9F26ADD6B752A76286_139775001 = (wm.getMaximumSizeDimension());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //IWindowManager wm = getWindowManager();
            //return wm.getMaximumSizeDimension();
        //} catch (RemoteException e) {
            //Slog.w("Display", "Unable to get display maximum size dimension", e);
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.891 -0400", hash_original_method = "2F7FD849240377F4AD58DDE704C1CFAA", hash_generated_method = "8204F04F48441815BBABDF7BB8078B9D")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public int getWidth() {
        {
            long now;
            now = SystemClock.uptimeMillis();
            {
                getSizeInternal(mTmpPoint, true);
                mLastGetTime = now;
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (mTmpPoint) {
            //long now = SystemClock.uptimeMillis();
            //if (now > (mLastGetTime+20)) {
                //getSizeInternal(mTmpPoint, true);
                //mLastGetTime = now;
            //}
            //return mTmpPoint.x;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.891 -0400", hash_original_method = "60FBCC92DE8F9EC729264DB15D46C4E8", hash_generated_method = "BB6D9B014C275776FB574ACBC2E4E58A")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public int getHeight() {
        {
            long now;
            now = SystemClock.uptimeMillis();
            {
                getSizeInternal(mTmpPoint, true);
                mLastGetTime = now;
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (mTmpPoint) {
            //long now = SystemClock.uptimeMillis();
            //if (now > (mLastGetTime+20)) {
                //getSizeInternal(mTmpPoint, true);
                //mLastGetTime = now;
            //}
            //return mTmpPoint.y;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.891 -0400", hash_original_method = "B1AC967D724C688D478E66D81CB079DE", hash_generated_method = "7AE2DC3722633FD337E0C48B5CC5A247")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getRealSize(Point outSize) {
        dsTaint.addTaint(outSize.dsTaint);
        try 
        {
            IWindowManager wm;
            wm = getWindowManager();
            {
                wm.getRealDisplaySize(outSize);
            } //End block
            {
                outSize.x = getRawWidth();
                outSize.y = getRawHeight();
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //IWindowManager wm = getWindowManager();
            //if (wm != null) {
                //wm.getRealDisplaySize(outSize);
            //} else {
                //outSize.x = getRawWidth();
                //outSize.y = getRawHeight();
            //}
            //if (DEBUG_DISPLAY_SIZE) Slog.v(
                    //TAG, "Returning real display size: " + outSize);
        //} catch (RemoteException e) {
            //Slog.w("Display", "Unable to get real display size", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.891 -0400", hash_original_method = "1DDDF7191F0FF0F7297CF97C1DA4B799", hash_generated_method = "2A6F826C9E29D0249CF77334968473FD")
    @DSModeled(DSC.SAFE)
    public int getRawWidth() {
        int w;
        w = getRawWidthNative();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int w = getRawWidthNative();
        //if (DEBUG_DISPLAY_SIZE) Slog.v(
                //TAG, "Returning raw display width: " + w);
        //return w;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.891 -0400", hash_original_method = "F4A84F8F2FFCAD78922F38438709A2E6", hash_generated_method = "ADB67C599E3187D24D102B86EDCAA339")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getRawWidthNative() {
    	return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.891 -0400", hash_original_method = "3ACB8E9BEACC517B317C29EAF3634629", hash_generated_method = "A3F255A52D8DE62C61EBA1A6FD7789E8")
    @DSModeled(DSC.SAFE)
    public int getRawHeight() {
        int h;
        h = getRawHeightNative();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int h = getRawHeightNative();
        //if (DEBUG_DISPLAY_SIZE) Slog.v(
                //TAG, "Returning raw display height: " + h);
        //return h;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.891 -0400", hash_original_method = "0BBCECD524BDD54CA608342D94B23905", hash_generated_method = "6D4C8CE3249D5AAA4278E4E7CF4CC7A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getRawHeightNative() {
    	return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.891 -0400", hash_original_method = "0627945D4A6FEA5F8EF1880CC4DB952B", hash_generated_method = "ED93662AF51C89747E0D14E51439D4A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getRotation() {
        int var3524559B90F7538A184B8F3F95AB6F1B_1869405149 = (getOrientation());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getOrientation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.891 -0400", hash_original_method = "6E125A4EC20477CEC647612C37C0ECFE", hash_generated_method = "C406E3791181B588ABC6580ADF792D46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getOrientation() {
    	return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.891 -0400", hash_original_method = "441029F9FCB9AB0438A81D4AE48234F0", hash_generated_method = "7335F63794ABF5FD84A825A13553FDDA")
    @DSModeled(DSC.SAFE)
    public int getPixelFormat() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPixelFormat;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.891 -0400", hash_original_method = "79009E426290AE6AA1C61D7B07738692", hash_generated_method = "D7896B83F4D96E04E19026881134E178")
    @DSModeled(DSC.SAFE)
    public float getRefreshRate() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mRefreshRate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.892 -0400", hash_original_method = "81980A722EF93A85BC60465488AFFEA3", hash_generated_method = "8B4670A5616140DE994BCE5AF1ED9FB4")
    @DSModeled(DSC.SAFE)
    public void getMetrics(DisplayMetrics outMetrics) {
        dsTaint.addTaint(outMetrics.dsTaint);
        {
            getSizeInternal(mTmpPoint, false);
            getMetricsWithSize(outMetrics, mTmpPoint.x, mTmpPoint.y);
        } //End block
        CompatibilityInfo ci;
        ci = mCompatibilityInfo.getIfNeeded();
        {
            ci.applyToDisplayMetrics(outMetrics);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mTmpPoint) {
            //getSizeInternal(mTmpPoint, false);
            //getMetricsWithSize(outMetrics, mTmpPoint.x, mTmpPoint.y);
        //}
        //CompatibilityInfo ci = mCompatibilityInfo.getIfNeeded();
        //if (ci != null) {
            //ci.applyToDisplayMetrics(outMetrics);
        //}
        //if (DEBUG_DISPLAY_SIZE) Slog.v(TAG, "Returning DisplayMetrics: "
                //+ outMetrics.widthPixels + "x" + outMetrics.heightPixels
                //+ " " + outMetrics.density);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.892 -0400", hash_original_method = "EF32DD6952DB89EBAA6A7EFF5769279F", hash_generated_method = "FA8E477882E66D6B1F4C6D6A85EFD517")
    @DSModeled(DSC.SAFE)
    public void getRealMetrics(DisplayMetrics outMetrics) {
        dsTaint.addTaint(outMetrics.dsTaint);
        {
            getRealSize(mTmpPoint);
            getMetricsWithSize(outMetrics, mTmpPoint.x, mTmpPoint.y);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mTmpPoint) {
            //getRealSize(mTmpPoint);
            //getMetricsWithSize(outMetrics, mTmpPoint.x, mTmpPoint.y);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.892 -0400", hash_original_method = "FDECD188634E4AD18CD2905FF365772D", hash_generated_method = "E791A5CC517A2910811D9717BFFE7028")
    @DSModeled(DSC.SAFE)
    public int getRawExternalWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 1280;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.892 -0400", hash_original_method = "376AC17F1270BAB2AB31395345202FD2", hash_generated_method = "764C52E289B0114B4EE06550F5ABEE39")
    @DSModeled(DSC.SAFE)
    public int getRawExternalHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 720;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.892 -0400", hash_original_method = "9D75A337ADB9CB99DE08523595E3FF43", hash_generated_method = "EC43B121C1D093DE27D157E7215B434B")
    @DSModeled(DSC.SAFE)
    public void getMetricsWithSize(DisplayMetrics outMetrics,
            int width, int height) {
        dsTaint.addTaint(outMetrics.dsTaint);
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        outMetrics.densityDpi   = (int)((mDensity*DisplayMetrics.DENSITY_DEFAULT)+.5f);
        outMetrics.noncompatWidthPixels  = outMetrics.widthPixels = width;
        outMetrics.noncompatHeightPixels = outMetrics.heightPixels = height;
        outMetrics.density = outMetrics.noncompatDensity = mDensity;
        outMetrics.scaledDensity = outMetrics.noncompatScaledDensity = outMetrics.density;
        outMetrics.xdpi = outMetrics.noncompatXdpi = mDpiX;
        outMetrics.ydpi = outMetrics.noncompatYdpi = mDpiY;
        // ---------- Original Method ----------
        //outMetrics.densityDpi   = (int)((mDensity*DisplayMetrics.DENSITY_DEFAULT)+.5f);
        //outMetrics.noncompatWidthPixels  = outMetrics.widthPixels = width;
        //outMetrics.noncompatHeightPixels = outMetrics.heightPixels = height;
        //outMetrics.density = outMetrics.noncompatDensity = mDensity;
        //outMetrics.scaledDensity = outMetrics.noncompatScaledDensity = outMetrics.density;
        //outMetrics.xdpi = outMetrics.noncompatXdpi = mDpiX;
        //outMetrics.ydpi = outMetrics.noncompatYdpi = mDpiY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.892 -0400", hash_original_method = "EAA8F8A14B9F77AE841E750047985ABA", hash_generated_method = "E85C3B1E8EB8D4474C2CFD73095C7800")
    static IWindowManager getWindowManager() {
        synchronized (sStaticInit) {
            if (sWindowManager == null) {
                sWindowManager = IWindowManager.Stub.asInterface(
                        ServiceManager.getService("window"));
            }
            return sWindowManager;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.892 -0400", hash_original_method = "368BCBBAD3F68FEF8C07AE5DC4D2077C", hash_generated_method = "66CFEED3BA0F1B2AF18C8805660BFF70")
    private static void nativeClassInit() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.892 -0400", hash_original_method = "CE3A43F20C9E9D8C85E043AD25A6B3E9", hash_generated_method = "70B7C0BAC8A62B6B3AAAFFF26388D5F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init(int display) {
        dsTaint.addTaint(display);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.892 -0400", hash_original_method = "0B13ECC3F100D49D8BCFE6A30F50129A", hash_generated_method = "EF80024A00D7E526068FD0AA7374CDCF")
    public static Display createCompatibleDisplay(int displayId, CompatibilityInfoHolder compat) {
        return new Display(displayId, compat);
    }

    
}


