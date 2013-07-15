package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.res.CompatibilityInfo;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Slog;

public class Display {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.587 -0400", hash_original_field = "27C9B400936470E0D86B9AA2CDF3AED4", hash_generated_field = "01AEB6BE7A1CFB44C6B781D7301EC317")

    private CompatibilityInfoHolder mCompatibilityInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.587 -0400", hash_original_field = "D29BCBAAD55DD1B1C5A0A9EB22E25252", hash_generated_field = "C3D33931672C9997D02DE67B6B8FC170")

    private int mDisplay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.588 -0400", hash_original_field = "29727137934799BC1D0686EA1284D9AC", hash_generated_field = "A3BE31732297BF4F97F73715693F8671")

    private int mPixelFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.588 -0400", hash_original_field = "96892C3CA593DB3BD1DCFF4EAD9D60E2", hash_generated_field = "3B186DE7AE43652AB2C26B4DC04F9761")

    private float mRefreshRate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.588 -0400", hash_original_field = "174BB9FF4691CBE6254BA90AE9FA0B63", hash_generated_field = "B5DC68677E93FA7FF1DA60AF3938C510")

    float mDensity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.588 -0400", hash_original_field = "E9855EBD17BB366B564310EC3316E0E7", hash_generated_field = "B2E7A1F0CAE99DBD9D3D65E29165C84A")

    float mDpiX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.588 -0400", hash_original_field = "B9AD09C6396CDB2CD033954CBA73419A", hash_generated_field = "BC1908C6E1D0054138584C2D01126D3C")

    float mDpiY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.588 -0400", hash_original_field = "43EB55458C4394666C2FF9CB27BDC008", hash_generated_field = "538425559D2BF0F635F9288868FC8D78")

    private final Point mTmpPoint = new Point();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.588 -0400", hash_original_field = "AE2D8764BEA6AAEE1A7358E2F8934DB6", hash_generated_field = "3C9E4AC56655D3050A4B4F36D2BBE1DC")

    private final DisplayMetrics mTmpMetrics = new DisplayMetrics();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.588 -0400", hash_original_field = "D79306417350CE6A12944817CEE2E9C4", hash_generated_field = "362C6D41A17812DA983C811277AF00AE")

    private float mLastGetTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.589 -0400", hash_original_method = "C9519A69B693719AC1491BF9F92C5C8E", hash_generated_method = "119D58D4AE9C571078046828391ECB8B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.589 -0400", hash_original_method = "107F25776C4AB2DB96852EDD25D31975", hash_generated_method = "3341481E15AF1BB0FA6281F6EFF0EE0F")
    public int getDisplayId() {
        int varD29BCBAAD55DD1B1C5A0A9EB22E25252_664221787 = (mDisplay);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1420417609 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1420417609;
        // ---------- Original Method ----------
        //return mDisplay;
    }

    
    @DSModeled(DSC.SAFE)
    static int getDisplayCount() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2086194105 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2086194105;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.590 -0400", hash_original_method = "17F24EABE37BDCE44DDE55CD705BD7B9", hash_generated_method = "D29C3D5CFCD464C96B15D3988C7C1F06")
    public void getSize(Point outSize) {
        addTaint(outSize.getTaint());
        getSizeInternal(outSize, true);
        // ---------- Original Method ----------
        //getSizeInternal(outSize, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.592 -0400", hash_original_method = "79B8C4439194701109AF7AA6129A555C", hash_generated_method = "CCC57910A60FFFE46777166360FEAAD3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.593 -0400", hash_original_method = "92D5B5EBFB706321BDD6B906C6DF5945", hash_generated_method = "024FABBC46529FFFBC463503BF6BEC82")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.593 -0400", hash_original_method = "404C4EF6FA3AD3B9975B754C597D6C0E", hash_generated_method = "3E432814770B368CF9F10B65B9BC28EA")
    public int getMaximumSizeDimension() {
        try 
        {
            IWindowManager wm = getWindowManager();
            int var556D7F09E308F26BC71442FFE07F231F_1297121560 = (wm.getMaximumSizeDimension());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_919550370 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_919550370;
        } //End block
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1537664559 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1801723142 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1801723142;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.594 -0400", hash_original_method = "2F7FD849240377F4AD58DDE704C1CFAA", hash_generated_method = "1CBF4CAE275E4860B26CB4887464FA37")
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
            int var50EA1288AB139B5B6750468A284F2C81_591835238 = (mTmpPoint.x);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_817283904 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_817283904;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.594 -0400", hash_original_method = "60FBCC92DE8F9EC729264DB15D46C4E8", hash_generated_method = "CC9EED8BB87263B193D53321FF341353")
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
            int var25849A03021EC6EA8945BF7BEA9B7E0C_747536991 = (mTmpPoint.y);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1285066819 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1285066819;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.595 -0400", hash_original_method = "B1AC967D724C688D478E66D81CB079DE", hash_generated_method = "62C7E3CE07717E516B996020BB6FD984")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.595 -0400", hash_original_method = "1DDDF7191F0FF0F7297CF97C1DA4B799", hash_generated_method = "F9A766C277FF6E923C7C8D6929824154")
    public int getRawWidth() {
        int w = getRawWidthNative();
    if(DEBUG_DISPLAY_SIZE){ }        int varF1290186A5D0B1CEAB27F4E77C0C5D68_925051157 = (w);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1667604136 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1667604136;
        // ---------- Original Method ----------
        //int w = getRawWidthNative();
        //if (DEBUG_DISPLAY_SIZE) Slog.v(
                //TAG, "Returning raw display width: " + w);
        //return w;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.595 -0400", hash_original_method = "F4A84F8F2FFCAD78922F38438709A2E6", hash_generated_method = "4AB5E769AF3FBF3FD5AA12EE7A9B10CA")
    private int getRawWidthNative() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1638065195 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1638065195;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.596 -0400", hash_original_method = "3ACB8E9BEACC517B317C29EAF3634629", hash_generated_method = "EC496BCF0A94E55FDC99BA461A54352B")
    public int getRawHeight() {
        int h = getRawHeightNative();
    if(DEBUG_DISPLAY_SIZE){ }        int var2510C39011C5BE704182423E3A695E91_1037288924 = (h);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_409440151 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_409440151;
        // ---------- Original Method ----------
        //int h = getRawHeightNative();
        //if (DEBUG_DISPLAY_SIZE) Slog.v(
                //TAG, "Returning raw display height: " + h);
        //return h;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.596 -0400", hash_original_method = "0BBCECD524BDD54CA608342D94B23905", hash_generated_method = "A613FC34477C91C6D0D608DC6E1B8F66")
    private int getRawHeightNative() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1588802331 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1588802331;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.596 -0400", hash_original_method = "0627945D4A6FEA5F8EF1880CC4DB952B", hash_generated_method = "9BDC04FFFEF2C0EF4642474137CF3AB0")
    public int getRotation() {
        int var39ABA20B52E0B25AEA7A16A0988A2804_1452125637 = (getOrientation());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_31861802 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_31861802;
        // ---------- Original Method ----------
        //return getOrientation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.596 -0400", hash_original_method = "6E125A4EC20477CEC647612C37C0ECFE", hash_generated_method = "C2FA149E62A794694006C0454514076A")
    @Deprecated
    public int getOrientation() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1373895626 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1373895626;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.597 -0400", hash_original_method = "441029F9FCB9AB0438A81D4AE48234F0", hash_generated_method = "C6A011DB9413EE78E5FBB61CB0E0A07D")
    public int getPixelFormat() {
        int var29727137934799BC1D0686EA1284D9AC_514552177 = (mPixelFormat);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1961941667 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1961941667;
        // ---------- Original Method ----------
        //return mPixelFormat;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.597 -0400", hash_original_method = "79009E426290AE6AA1C61D7B07738692", hash_generated_method = "DDE3432FFF64D1109BC7267170490AA5")
    public float getRefreshRate() {
        float var96892C3CA593DB3BD1DCFF4EAD9D60E2_1094961193 = (mRefreshRate);
                float var546ADE640B6EDFBC8A086EF31347E768_304552352 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_304552352;
        // ---------- Original Method ----------
        //return mRefreshRate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.597 -0400", hash_original_method = "81980A722EF93A85BC60465488AFFEA3", hash_generated_method = "EAE44A184D3656423D69A4CFF18B486D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.598 -0400", hash_original_method = "EF32DD6952DB89EBAA6A7EFF5769279F", hash_generated_method = "CEB9F6CDC024DCF0EC6F879D5778E32C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.598 -0400", hash_original_method = "FDECD188634E4AD18CD2905FF365772D", hash_generated_method = "DCC90D3EC61E60F5FAF2B5D744099843")
    public int getRawExternalWidth() {
        int varDA11E8CD1811ACB79CCF0FD62CD58F86_796864573 = (1280);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_799208513 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_799208513;
        // ---------- Original Method ----------
        //return 1280;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.599 -0400", hash_original_method = "376AC17F1270BAB2AB31395345202FD2", hash_generated_method = "64B76A5CD59B982454C2B361EC6F5304")
    public int getRawExternalHeight() {
        int var5F2C22CB4A5380AF7CA75622A6426917_1665705836 = (720);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_818073599 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_818073599;
        // ---------- Original Method ----------
        //return 720;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.601 -0400", hash_original_method = "9D75A337ADB9CB99DE08523595E3FF43", hash_generated_method = "076F3564DD94D07B124591656DC49DE9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.602 -0400", hash_original_method = "CE3A43F20C9E9D8C85E043AD25A6B3E9", hash_generated_method = "86A89056B78EFFB6F1C0AB9CF5755DEE")
    private void init(int display) {
    }

    
        public static Display createCompatibleDisplay(int displayId, CompatibilityInfoHolder compat) {
        return new Display(displayId, compat);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.603 -0400", hash_original_field = "1EBF27F42EEDCBCC0F731E08D860E11F", hash_generated_field = "223CCD915B07E407EFEFA564FDB2DC20")

    static final String TAG = "Display";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.603 -0400", hash_original_field = "5D5F1111C8AB800CF99BD2FF21D97A63", hash_generated_field = "329D6DE5FD992832882D33C274C4BB6D")

    static final boolean DEBUG_DISPLAY_SIZE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.603 -0400", hash_original_field = "6A0F429E8AAC5F34459248C31C56E729", hash_generated_field = "DE0938F6522CA6DA05C305B8778F7B69")

    public static final int DEFAULT_DISPLAY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.603 -0400", hash_original_field = "7170B744DAC66055703A154E1B3F312E", hash_generated_field = "3688F7B3534C6CD8F91C89CB5E40FE68")

    private static final Object sStaticInit = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.603 -0400", hash_original_field = "36D6DBDDC3151D8D435DE4367930C71A", hash_generated_field = "815F7815DE01033DD7A51FFFBC42763D")

    private static boolean sInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.603 -0400", hash_original_field = "DE97087D3E19CB4D19590D5EDC0B28DE", hash_generated_field = "9FFB1E54F186971CA192F7BE25683B37")

    private static IWindowManager sWindowManager;
}

