package android.view;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.res.CompatibilityInfo;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.util.DisplayMetrics;




import droidsafe.helpers.DSUtils;

public class Display {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.499 -0400", hash_original_field = "27C9B400936470E0D86B9AA2CDF3AED4", hash_generated_field = "01AEB6BE7A1CFB44C6B781D7301EC317")

    private CompatibilityInfoHolder mCompatibilityInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.499 -0400", hash_original_field = "D29BCBAAD55DD1B1C5A0A9EB22E25252", hash_generated_field = "C3D33931672C9997D02DE67B6B8FC170")

    private int mDisplay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.499 -0400", hash_original_field = "29727137934799BC1D0686EA1284D9AC", hash_generated_field = "A3BE31732297BF4F97F73715693F8671")

    private int mPixelFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.499 -0400", hash_original_field = "96892C3CA593DB3BD1DCFF4EAD9D60E2", hash_generated_field = "3B186DE7AE43652AB2C26B4DC04F9761")

    private float mRefreshRate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.499 -0400", hash_original_field = "174BB9FF4691CBE6254BA90AE9FA0B63", hash_generated_field = "B5DC68677E93FA7FF1DA60AF3938C510")

    float mDensity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.500 -0400", hash_original_field = "E9855EBD17BB366B564310EC3316E0E7", hash_generated_field = "B2E7A1F0CAE99DBD9D3D65E29165C84A")

    float mDpiX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.500 -0400", hash_original_field = "B9AD09C6396CDB2CD033954CBA73419A", hash_generated_field = "BC1908C6E1D0054138584C2D01126D3C")

    float mDpiY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.500 -0400", hash_original_field = "43EB55458C4394666C2FF9CB27BDC008", hash_generated_field = "538425559D2BF0F635F9288868FC8D78")

    private final Point mTmpPoint = new Point();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.500 -0400", hash_original_field = "AE2D8764BEA6AAEE1A7358E2F8934DB6", hash_generated_field = "3C9E4AC56655D3050A4B4F36D2BBE1DC")

    private final DisplayMetrics mTmpMetrics = new DisplayMetrics();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.500 -0400", hash_original_field = "D79306417350CE6A12944817CEE2E9C4", hash_generated_field = "362C6D41A17812DA983C811277AF00AE")

    private float mLastGetTime;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.500 -0400", hash_original_method = "C9519A69B693719AC1491BF9F92C5C8E", hash_generated_method = "119D58D4AE9C571078046828391ECB8B")
      Display(int display, CompatibilityInfoHolder compatInfo) {
        synchronized
(sStaticInit)        {
            if(!sInitialized)            
            {
                nativeClassInit();
                sInitialized = true;
            } //End block
        } //End block
        mCompatibilityInfo = compatInfo != null ? compatInfo : new CompatibilityInfoHolder();
        mDisplay = display;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.501 -0400", hash_original_method = "107F25776C4AB2DB96852EDD25D31975", hash_generated_method = "11203FB29DE87E8B3755D6466B565F04")
    public int getDisplayId() {
        int varD29BCBAAD55DD1B1C5A0A9EB22E25252_1451844598 = (mDisplay);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2038883202 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2038883202;
        // ---------- Original Method ----------
        //return mDisplay;
    }

    
    @DSModeled(DSC.SAFE)
    static int getDisplayCount() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2086194105 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2086194105;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.519 -0400", hash_original_method = "17F24EABE37BDCE44DDE55CD705BD7B9", hash_generated_method = "D29C3D5CFCD464C96B15D3988C7C1F06")
    public void getSize(Point outSize) {
        addTaint(outSize.getTaint());
        getSizeInternal(outSize, true);
        // ---------- Original Method ----------
        //getSizeInternal(outSize, true);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.520 -0400", hash_original_method = "79B8C4439194701109AF7AA6129A555C", hash_generated_method = "CCC57910A60FFFE46777166360FEAAD3")
    private void getSizeInternal(Point outSize, boolean doCompat) {
        addTaint(doCompat);
        try 
        {
            IWindowManager wm = getWindowManager();
            if(wm != null)            
            {
                wm.getDisplaySize(outSize);
                CompatibilityInfo ci;
                if(doCompat && (ci=mCompatibilityInfo.getIfNeeded()) != null)                
                {
                    synchronized
(mTmpMetrics)                    {
                        mTmpMetrics.noncompatWidthPixels = outSize.x;
                        mTmpMetrics.noncompatHeightPixels = outSize.y;
                        mTmpMetrics.density = mDensity;
                        ci.applyToDisplayMetrics(mTmpMetrics);
                        outSize.x = mTmpMetrics.widthPixels;
                        outSize.y = mTmpMetrics.heightPixels;
                    } //End block
                } //End block
            } //End block
            else
            {
                outSize.x = getRawWidth();
                outSize.y = getRawHeight();
            } //End block
            if(false)            
            {
                RuntimeException here = new RuntimeException("here");
                here.fillInStackTrace();
            } //End block
            if(DEBUG_DISPLAY_SIZE && doCompat){ }
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.520 -0400", hash_original_method = "92D5B5EBFB706321BDD6B906C6DF5945", hash_generated_method = "024FABBC46529FFFBC463503BF6BEC82")
    public void getRectSize(Rect outSize) {
        addTaint(outSize.getTaint());
        synchronized
(mTmpPoint)        {
            getSizeInternal(mTmpPoint, true);
            outSize.set(0, 0, mTmpPoint.x, mTmpPoint.y);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mTmpPoint) {
            //getSizeInternal(mTmpPoint, true);
            //outSize.set(0, 0, mTmpPoint.x, mTmpPoint.y);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.520 -0400", hash_original_method = "404C4EF6FA3AD3B9975B754C597D6C0E", hash_generated_method = "9F72D0A1C69A802F93E9E2B86E2A3209")
    public int getMaximumSizeDimension() {
        try 
        {
            IWindowManager wm = getWindowManager();
            int var556D7F09E308F26BC71442FFE07F231F_1946831539 = (wm.getMaximumSizeDimension());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1108308310 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1108308310;
        } //End block
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_914712619 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_271664261 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_271664261;
        } //End block
        // ---------- Original Method ----------
        //try {
            //IWindowManager wm = getWindowManager();
            //return wm.getMaximumSizeDimension();
        //} catch (RemoteException e) {
            //Slog.w("Display", "Unable to get display maximum size dimension", e);
            //return 0;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.520 -0400", hash_original_method = "2F7FD849240377F4AD58DDE704C1CFAA", hash_generated_method = "AD7CBFCA5B7D2C92E0C20B32CF8AB9C2")
    @Deprecated
    public int getWidth() {
        synchronized
(mTmpPoint)        {
            long now = SystemClock.uptimeMillis();
            if(now > (mLastGetTime+20))            
            {
                getSizeInternal(mTmpPoint, true);
                mLastGetTime = now;
            } //End block
            int var50EA1288AB139B5B6750468A284F2C81_1194555465 = (mTmpPoint.x);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_807376366 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_807376366;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.521 -0400", hash_original_method = "60FBCC92DE8F9EC729264DB15D46C4E8", hash_generated_method = "97E31AAA060F07AD76F1AB16ED1910AF")
    @Deprecated
    public int getHeight() {
        synchronized
(mTmpPoint)        {
            long now = SystemClock.uptimeMillis();
            if(now > (mLastGetTime+20))            
            {
                getSizeInternal(mTmpPoint, true);
                mLastGetTime = now;
            } //End block
            int var25849A03021EC6EA8945BF7BEA9B7E0C_513477395 = (mTmpPoint.y);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1106065099 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1106065099;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.521 -0400", hash_original_method = "B1AC967D724C688D478E66D81CB079DE", hash_generated_method = "62C7E3CE07717E516B996020BB6FD984")
    public void getRealSize(Point outSize) {
        addTaint(outSize.getTaint());
        try 
        {
            IWindowManager wm = getWindowManager();
            if(wm != null)            
            {
                wm.getRealDisplaySize(outSize);
            } //End block
            else
            {
                outSize.x = getRawWidth();
                outSize.y = getRawHeight();
            } //End block
            if(DEBUG_DISPLAY_SIZE){ }
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.521 -0400", hash_original_method = "1DDDF7191F0FF0F7297CF97C1DA4B799", hash_generated_method = "53F5931042A3A9ABEB0BD425BAE35711")
    public int getRawWidth() {
        int w = getRawWidthNative();
        if(DEBUG_DISPLAY_SIZE){ }        int varF1290186A5D0B1CEAB27F4E77C0C5D68_1062537658 = (w);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1214869220 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1214869220;
        // ---------- Original Method ----------
        //int w = getRawWidthNative();
        //if (DEBUG_DISPLAY_SIZE) Slog.v(
                //TAG, "Returning raw display width: " + w);
        //return w;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.521 -0400", hash_original_method = "F4A84F8F2FFCAD78922F38438709A2E6", hash_generated_method = "637FA7E97699D4D1A11645BA136790D2")
    private int getRawWidthNative() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1567774368 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1567774368;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.522 -0400", hash_original_method = "3ACB8E9BEACC517B317C29EAF3634629", hash_generated_method = "0DD5CC70672A02C5C6E0CFE6C5F91284")
    public int getRawHeight() {
        int h = getRawHeightNative();
        if(DEBUG_DISPLAY_SIZE){ }        int var2510C39011C5BE704182423E3A695E91_19921183 = (h);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2141844666 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2141844666;
        // ---------- Original Method ----------
        //int h = getRawHeightNative();
        //if (DEBUG_DISPLAY_SIZE) Slog.v(
                //TAG, "Returning raw display height: " + h);
        //return h;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.522 -0400", hash_original_method = "0BBCECD524BDD54CA608342D94B23905", hash_generated_method = "B69213FD63C0422F6B0396F12EF991E3")
    private int getRawHeightNative() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_504669123 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_504669123;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.522 -0400", hash_original_method = "0627945D4A6FEA5F8EF1880CC4DB952B", hash_generated_method = "F5C622C075253C71BD449D9B0DC521F9")
    public int getRotation() {
        int var39ABA20B52E0B25AEA7A16A0988A2804_1973622146 = (getOrientation());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471115705 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471115705;
        // ---------- Original Method ----------
        //return getOrientation();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.522 -0400", hash_original_method = "6E125A4EC20477CEC647612C37C0ECFE", hash_generated_method = "A33D1390FEDA7AFBC7DEFF26E10ACDBE")
    @Deprecated
    public int getOrientation() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1856239683 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1856239683;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.523 -0400", hash_original_method = "441029F9FCB9AB0438A81D4AE48234F0", hash_generated_method = "BF162669D335C181CC3EED8F487101FB")
    public int getPixelFormat() {
        int var29727137934799BC1D0686EA1284D9AC_923416210 = (mPixelFormat);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1034384305 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1034384305;
        // ---------- Original Method ----------
        //return mPixelFormat;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.523 -0400", hash_original_method = "79009E426290AE6AA1C61D7B07738692", hash_generated_method = "1A5BEA550E47A95D66B561236A0254C3")
    public float getRefreshRate() {
        float var96892C3CA593DB3BD1DCFF4EAD9D60E2_811920979 = (mRefreshRate);
                float var546ADE640B6EDFBC8A086EF31347E768_1516553870 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1516553870;
        // ---------- Original Method ----------
        //return mRefreshRate;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.523 -0400", hash_original_method = "81980A722EF93A85BC60465488AFFEA3", hash_generated_method = "EAE44A184D3656423D69A4CFF18B486D")
    public void getMetrics(DisplayMetrics outMetrics) {
        addTaint(outMetrics.getTaint());
        synchronized
(mTmpPoint)        {
            getSizeInternal(mTmpPoint, false);
            getMetricsWithSize(outMetrics, mTmpPoint.x, mTmpPoint.y);
        } //End block
        CompatibilityInfo ci = mCompatibilityInfo.getIfNeeded();
        if(ci != null)        
        {
            ci.applyToDisplayMetrics(outMetrics);
        } //End block
        if(DEBUG_DISPLAY_SIZE){ }
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.523 -0400", hash_original_method = "EF32DD6952DB89EBAA6A7EFF5769279F", hash_generated_method = "CEB9F6CDC024DCF0EC6F879D5778E32C")
    public void getRealMetrics(DisplayMetrics outMetrics) {
        addTaint(outMetrics.getTaint());
        synchronized
(mTmpPoint)        {
            getRealSize(mTmpPoint);
            getMetricsWithSize(outMetrics, mTmpPoint.x, mTmpPoint.y);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mTmpPoint) {
            //getRealSize(mTmpPoint);
            //getMetricsWithSize(outMetrics, mTmpPoint.x, mTmpPoint.y);
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.523 -0400", hash_original_method = "FDECD188634E4AD18CD2905FF365772D", hash_generated_method = "763FA032A6C73A5F121D489A6F4E2EE3")
    public int getRawExternalWidth() {
        int varDA11E8CD1811ACB79CCF0FD62CD58F86_1656875826 = (1280);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1924182824 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1924182824;
        // ---------- Original Method ----------
        //return 1280;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.524 -0400", hash_original_method = "376AC17F1270BAB2AB31395345202FD2", hash_generated_method = "DB8AA79266E59B237C0461FF2BC2753B")
    public int getRawExternalHeight() {
        int var5F2C22CB4A5380AF7CA75622A6426917_669291068 = (720);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_387047971 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_387047971;
        // ---------- Original Method ----------
        //return 720;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.524 -0400", hash_original_method = "9D75A337ADB9CB99DE08523595E3FF43", hash_generated_method = "076F3564DD94D07B124591656DC49DE9")
    public void getMetricsWithSize(DisplayMetrics outMetrics,
            int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(outMetrics.getTaint());
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

    
    @DSModeled(DSC.BAN)
    static IWindowManager getWindowManager() {
        synchronized (sStaticInit) {
            if (sWindowManager == null) {
                sWindowManager = IWindowManager.Stub.asInterface(
                        ServiceManager.getService("window"));
            }
            return sWindowManager;
        }
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeClassInit() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.524 -0400", hash_original_method = "CE3A43F20C9E9D8C85E043AD25A6B3E9", hash_generated_method = "86A89056B78EFFB6F1C0AB9CF5755DEE")
    private void init(int display) {
    }

    
    @DSModeled(DSC.BAN)
    public static Display createCompatibleDisplay(int displayId, CompatibilityInfoHolder compat) {
        return new Display(displayId, compat);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.524 -0400", hash_original_field = "1EBF27F42EEDCBCC0F731E08D860E11F", hash_generated_field = "223CCD915B07E407EFEFA564FDB2DC20")

    static final String TAG = "Display";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.524 -0400", hash_original_field = "5D5F1111C8AB800CF99BD2FF21D97A63", hash_generated_field = "329D6DE5FD992832882D33C274C4BB6D")

    static final boolean DEBUG_DISPLAY_SIZE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.524 -0400", hash_original_field = "6A0F429E8AAC5F34459248C31C56E729", hash_generated_field = "DE0938F6522CA6DA05C305B8778F7B69")

    public static final int DEFAULT_DISPLAY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.524 -0400", hash_original_field = "7170B744DAC66055703A154E1B3F312E", hash_generated_field = "3688F7B3534C6CD8F91C89CB5E40FE68")

    private static final Object sStaticInit = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.525 -0400", hash_original_field = "36D6DBDDC3151D8D435DE4367930C71A", hash_generated_field = "815F7815DE01033DD7A51FFFBC42763D")

    private static boolean sInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.525 -0400", hash_original_field = "DE97087D3E19CB4D19590D5EDC0B28DE", hash_generated_field = "9FFB1E54F186971CA192F7BE25683B37")

    private static IWindowManager sWindowManager;
}

