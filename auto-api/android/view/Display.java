package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private CompatibilityInfoHolder mCompatibilityInfo;
    private int   mDisplay;
    private int         mPixelFormat;
    private float       mRefreshRate;
    float   mDensity;
    float   mDpiX;
    float   mDpiY;
    private Point mTmpPoint = new Point();
    private DisplayMetrics mTmpMetrics = new DisplayMetrics();
    private float mLastGetTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.468 -0400", hash_original_method = "C9519A69B693719AC1491BF9F92C5C8E", hash_generated_method = "1DA1D38FA3D9598A1349C9826C2F1421")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Display(int display, CompatibilityInfoHolder compatInfo) {
        dsTaint.addTaint(compatInfo.dsTaint);
        dsTaint.addTaint(display);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.468 -0400", hash_original_method = "107F25776C4AB2DB96852EDD25D31975", hash_generated_method = "67384B4E561DA2613FE1C9092DA0A245")
    @DSModeled(DSC.SAFE)
    public int getDisplayId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDisplay;
    }

    
        static int getDisplayCount() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.469 -0400", hash_original_method = "17F24EABE37BDCE44DDE55CD705BD7B9", hash_generated_method = "D4C9CC348852DFD917A70C9F7F00186B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getSize(Point outSize) {
        dsTaint.addTaint(outSize.dsTaint);
        getSizeInternal(outSize, true);
        // ---------- Original Method ----------
        //getSizeInternal(outSize, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.469 -0400", hash_original_method = "79B8C4439194701109AF7AA6129A555C", hash_generated_method = "3F18F93B5408AB7ECEF7E4ECB27419D7")
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
                CompatibilityInfo ci;
                {
                    boolean var6BC58437C431C9232DA2904BF16DEF2E_13576920 = (doCompat && (ci=mCompatibilityInfo.getIfNeeded()) != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.469 -0400", hash_original_method = "92D5B5EBFB706321BDD6B906C6DF5945", hash_generated_method = "51E84BE623948B00C10F3DAF6D2EEADF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.470 -0400", hash_original_method = "404C4EF6FA3AD3B9975B754C597D6C0E", hash_generated_method = "AB2777D592066462B924B1CB6ADAC6FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaximumSizeDimension() {
        try 
        {
            IWindowManager wm;
            wm = getWindowManager();
            int varC1FFFA445B088D9F26ADD6B752A76286_785336965 = (wm.getMaximumSizeDimension());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.470 -0400", hash_original_method = "2F7FD849240377F4AD58DDE704C1CFAA", hash_generated_method = "04C5C8F5BFD024F3ACE28FC80B521E49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.470 -0400", hash_original_method = "60FBCC92DE8F9EC729264DB15D46C4E8", hash_generated_method = "7B0D341D1933121592AEBCC10CDDC790")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.470 -0400", hash_original_method = "B1AC967D724C688D478E66D81CB079DE", hash_generated_method = "8BCE451F363D461C61D66CD53138B7E5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.471 -0400", hash_original_method = "1DDDF7191F0FF0F7297CF97C1DA4B799", hash_generated_method = "53A8F03596B954298E5D1A046ABAA28F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.471 -0400", hash_original_method = "F4A84F8F2FFCAD78922F38438709A2E6", hash_generated_method = "7C5953DFA84A3FC6F0143174192F5361")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getRawWidthNative() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.471 -0400", hash_original_method = "3ACB8E9BEACC517B317C29EAF3634629", hash_generated_method = "3BC85AE073A35D5771A6EE293A8B4DD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.471 -0400", hash_original_method = "0BBCECD524BDD54CA608342D94B23905", hash_generated_method = "19656B55E36FB5BCC0613CDD399C7D65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getRawHeightNative() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.471 -0400", hash_original_method = "0627945D4A6FEA5F8EF1880CC4DB952B", hash_generated_method = "D92EAFB4CF8CD32CEA09CE7068DBBC31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getRotation() {
        int var3524559B90F7538A184B8F3F95AB6F1B_1047403947 = (getOrientation());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getOrientation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.471 -0400", hash_original_method = "6E125A4EC20477CEC647612C37C0ECFE", hash_generated_method = "84B8F01E3D0CB0D0BE40A10ABEF842C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getOrientation() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.471 -0400", hash_original_method = "441029F9FCB9AB0438A81D4AE48234F0", hash_generated_method = "14A5D5FFAD9F6C1D84D6EDE85A191069")
    @DSModeled(DSC.SAFE)
    public int getPixelFormat() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPixelFormat;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.472 -0400", hash_original_method = "79009E426290AE6AA1C61D7B07738692", hash_generated_method = "7D8F5D47F53C1CBB157C12D82CEFF670")
    @DSModeled(DSC.SAFE)
    public float getRefreshRate() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mRefreshRate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.472 -0400", hash_original_method = "81980A722EF93A85BC60465488AFFEA3", hash_generated_method = "12D6812CFB92653C5F891BD99B79974F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.472 -0400", hash_original_method = "EF32DD6952DB89EBAA6A7EFF5769279F", hash_generated_method = "96CF1036B3C14217CA2FE2B4473393EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.472 -0400", hash_original_method = "FDECD188634E4AD18CD2905FF365772D", hash_generated_method = "ECAB0E132CEEEABD73C92E561BB9A849")
    @DSModeled(DSC.SAFE)
    public int getRawExternalWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 1280;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.472 -0400", hash_original_method = "376AC17F1270BAB2AB31395345202FD2", hash_generated_method = "00856F282C298C16CB36F46156449604")
    @DSModeled(DSC.SAFE)
    public int getRawExternalHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 720;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.473 -0400", hash_original_method = "9D75A337ADB9CB99DE08523595E3FF43", hash_generated_method = "5FFD8839913FB65785D917A55FD6E9A6")
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

    
        static IWindowManager getWindowManager() {
        synchronized (sStaticInit) {
            if (sWindowManager == null) {
                sWindowManager = IWindowManager.Stub.asInterface(
                        ServiceManager.getService("window"));
            }
            return sWindowManager;
        }
    }

    
        private static void nativeClassInit() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.473 -0400", hash_original_method = "CE3A43F20C9E9D8C85E043AD25A6B3E9", hash_generated_method = "5200C6914697246769AF2CB249C78802")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init(int display) {
        dsTaint.addTaint(display);
    }

    
        public static Display createCompatibleDisplay(int displayId, CompatibilityInfoHolder compat) {
        return new Display(displayId, compat);
    }

    
    static final String TAG = "Display";
    static final boolean DEBUG_DISPLAY_SIZE = false;
    public static final int DEFAULT_DISPLAY = 0;
    private static final Object sStaticInit = new Object();
    private static boolean sInitialized = false;
    private static IWindowManager sWindowManager;
}

