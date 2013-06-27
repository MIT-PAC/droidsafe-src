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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.003 -0400", hash_original_field = "27C9B400936470E0D86B9AA2CDF3AED4", hash_generated_field = "01AEB6BE7A1CFB44C6B781D7301EC317")

    private CompatibilityInfoHolder mCompatibilityInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.004 -0400", hash_original_field = "D29BCBAAD55DD1B1C5A0A9EB22E25252", hash_generated_field = "C3D33931672C9997D02DE67B6B8FC170")

    private int mDisplay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.004 -0400", hash_original_field = "29727137934799BC1D0686EA1284D9AC", hash_generated_field = "A3BE31732297BF4F97F73715693F8671")

    private int mPixelFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.017 -0400", hash_original_field = "96892C3CA593DB3BD1DCFF4EAD9D60E2", hash_generated_field = "3B186DE7AE43652AB2C26B4DC04F9761")

    private float mRefreshRate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.017 -0400", hash_original_field = "174BB9FF4691CBE6254BA90AE9FA0B63", hash_generated_field = "B5DC68677E93FA7FF1DA60AF3938C510")

    float mDensity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.017 -0400", hash_original_field = "E9855EBD17BB366B564310EC3316E0E7", hash_generated_field = "B2E7A1F0CAE99DBD9D3D65E29165C84A")

    float mDpiX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.017 -0400", hash_original_field = "B9AD09C6396CDB2CD033954CBA73419A", hash_generated_field = "BC1908C6E1D0054138584C2D01126D3C")

    float mDpiY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.018 -0400", hash_original_field = "43EB55458C4394666C2FF9CB27BDC008", hash_generated_field = "7E231DFD1AAC1A571329269F4F08E1D4")

    private Point mTmpPoint = new Point();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.018 -0400", hash_original_field = "AE2D8764BEA6AAEE1A7358E2F8934DB6", hash_generated_field = "5D5301E57FDBA96DE0829B22BCB1E421")

    private DisplayMetrics mTmpMetrics = new DisplayMetrics();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.018 -0400", hash_original_field = "D79306417350CE6A12944817CEE2E9C4", hash_generated_field = "362C6D41A17812DA983C811277AF00AE")

    private float mLastGetTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.018 -0400", hash_original_method = "C9519A69B693719AC1491BF9F92C5C8E", hash_generated_method = "ED5490C5F9978E8C2243C4FB5ED0E037")
      Display(int display, CompatibilityInfoHolder compatInfo) {
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.019 -0400", hash_original_method = "107F25776C4AB2DB96852EDD25D31975", hash_generated_method = "70A05B8D26D01E0B710A4FCF85A79CF2")
    public int getDisplayId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_179224349 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_179224349;
        // ---------- Original Method ----------
        //return mDisplay;
    }

    
        static int getDisplayCount() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.019 -0400", hash_original_method = "17F24EABE37BDCE44DDE55CD705BD7B9", hash_generated_method = "FDF8E4C55ED8FDAF0C48488F4AE156B6")
    public void getSize(Point outSize) {
        getSizeInternal(outSize, true);
        addTaint(outSize.getTaint());
        // ---------- Original Method ----------
        //getSizeInternal(outSize, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.036 -0400", hash_original_method = "79B8C4439194701109AF7AA6129A555C", hash_generated_method = "2BAC702BE4BD81FF6D5426335B07F325")
    private void getSizeInternal(Point outSize, boolean doCompat) {
        try 
        {
            IWindowManager wm;
            wm = getWindowManager();
            {
                wm.getDisplaySize(outSize);
                CompatibilityInfo ci;
                {
                    boolean var6BC58437C431C9232DA2904BF16DEF2E_1241002254 = (doCompat && (ci=mCompatibilityInfo.getIfNeeded()) != null);
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
        addTaint(doCompat);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.037 -0400", hash_original_method = "92D5B5EBFB706321BDD6B906C6DF5945", hash_generated_method = "BF8C79659AD014CE2AE182010E7CC16F")
    public void getRectSize(Rect outSize) {
        {
            getSizeInternal(mTmpPoint, true);
            outSize.set(0, 0, mTmpPoint.x, mTmpPoint.y);
        } //End block
        addTaint(outSize.getTaint());
        // ---------- Original Method ----------
        //synchronized (mTmpPoint) {
            //getSizeInternal(mTmpPoint, true);
            //outSize.set(0, 0, mTmpPoint.x, mTmpPoint.y);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.038 -0400", hash_original_method = "404C4EF6FA3AD3B9975B754C597D6C0E", hash_generated_method = "302E273D15BE3FE256E9B579C42E2139")
    public int getMaximumSizeDimension() {
        try 
        {
            IWindowManager wm;
            wm = getWindowManager();
            int varC1FFFA445B088D9F26ADD6B752A76286_1799307058 = (wm.getMaximumSizeDimension());
        } //End block
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_700056867 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_700056867;
        // ---------- Original Method ----------
        //try {
            //IWindowManager wm = getWindowManager();
            //return wm.getMaximumSizeDimension();
        //} catch (RemoteException e) {
            //Slog.w("Display", "Unable to get display maximum size dimension", e);
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.038 -0400", hash_original_method = "2F7FD849240377F4AD58DDE704C1CFAA", hash_generated_method = "37F31E72E55FA4E4CDFA97B58E4C4552")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1914688612 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1914688612;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.039 -0400", hash_original_method = "60FBCC92DE8F9EC729264DB15D46C4E8", hash_generated_method = "5AF2252F15ACA1AA7739AF6C31BCF05F")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1842401977 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1842401977;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.040 -0400", hash_original_method = "B1AC967D724C688D478E66D81CB079DE", hash_generated_method = "E6EE2BCB98894288EEF2071BD08E7C4E")
    public void getRealSize(Point outSize) {
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
        addTaint(outSize.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.041 -0400", hash_original_method = "1DDDF7191F0FF0F7297CF97C1DA4B799", hash_generated_method = "4BC65DFA66FB03720130C6B5D8B78194")
    public int getRawWidth() {
        int w;
        w = getRawWidthNative();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2130700948 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2130700948;
        // ---------- Original Method ----------
        //int w = getRawWidthNative();
        //if (DEBUG_DISPLAY_SIZE) Slog.v(
                //TAG, "Returning raw display width: " + w);
        //return w;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.044 -0400", hash_original_method = "F4A84F8F2FFCAD78922F38438709A2E6", hash_generated_method = "12BA6E5736BA128AD82D05BDF8010217")
    private int getRawWidthNative() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372821047 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372821047;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.044 -0400", hash_original_method = "3ACB8E9BEACC517B317C29EAF3634629", hash_generated_method = "31E179E81673C1AEBFC01A99DAC8E0B4")
    public int getRawHeight() {
        int h;
        h = getRawHeightNative();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450355142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450355142;
        // ---------- Original Method ----------
        //int h = getRawHeightNative();
        //if (DEBUG_DISPLAY_SIZE) Slog.v(
                //TAG, "Returning raw display height: " + h);
        //return h;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.059 -0400", hash_original_method = "0BBCECD524BDD54CA608342D94B23905", hash_generated_method = "A163EDC1F5EEF728B20CEA0C9291D9B2")
    private int getRawHeightNative() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_739401667 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_739401667;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.060 -0400", hash_original_method = "0627945D4A6FEA5F8EF1880CC4DB952B", hash_generated_method = "4A1A6A5E6ED5CD3CDB6A0F898AAC353F")
    public int getRotation() {
        int var3524559B90F7538A184B8F3F95AB6F1B_1457310402 = (getOrientation());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_634433071 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_634433071;
        // ---------- Original Method ----------
        //return getOrientation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.060 -0400", hash_original_method = "6E125A4EC20477CEC647612C37C0ECFE", hash_generated_method = "E103D9D6E1CFD4AF1ACD0CE80016C3AD")
    @Deprecated
    public int getOrientation() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691099267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691099267;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.061 -0400", hash_original_method = "441029F9FCB9AB0438A81D4AE48234F0", hash_generated_method = "3C6782A84911153029F6638EC094ADD8")
    public int getPixelFormat() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000125443 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000125443;
        // ---------- Original Method ----------
        //return mPixelFormat;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.061 -0400", hash_original_method = "79009E426290AE6AA1C61D7B07738692", hash_generated_method = "31F469291900BC7A3673535EE7FF29AB")
    public float getRefreshRate() {
        float var546ADE640B6EDFBC8A086EF31347E768_544408823 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_544408823;
        // ---------- Original Method ----------
        //return mRefreshRate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.062 -0400", hash_original_method = "81980A722EF93A85BC60465488AFFEA3", hash_generated_method = "7E67049CDA625B9591A3791B27BD64E0")
    public void getMetrics(DisplayMetrics outMetrics) {
        {
            getSizeInternal(mTmpPoint, false);
            getMetricsWithSize(outMetrics, mTmpPoint.x, mTmpPoint.y);
        } //End block
        CompatibilityInfo ci;
        ci = mCompatibilityInfo.getIfNeeded();
        {
            ci.applyToDisplayMetrics(outMetrics);
        } //End block
        addTaint(outMetrics.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.062 -0400", hash_original_method = "EF32DD6952DB89EBAA6A7EFF5769279F", hash_generated_method = "AA293FB6D63FF4A72EAD089D4E4247CF")
    public void getRealMetrics(DisplayMetrics outMetrics) {
        {
            getRealSize(mTmpPoint);
            getMetricsWithSize(outMetrics, mTmpPoint.x, mTmpPoint.y);
        } //End block
        addTaint(outMetrics.getTaint());
        // ---------- Original Method ----------
        //synchronized (mTmpPoint) {
            //getRealSize(mTmpPoint);
            //getMetricsWithSize(outMetrics, mTmpPoint.x, mTmpPoint.y);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.062 -0400", hash_original_method = "FDECD188634E4AD18CD2905FF365772D", hash_generated_method = "FE64FACA20BD98479204602C3C7014D8")
    public int getRawExternalWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1771576097 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1771576097;
        // ---------- Original Method ----------
        //return 1280;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.075 -0400", hash_original_method = "376AC17F1270BAB2AB31395345202FD2", hash_generated_method = "0650D75E5E5934B7EABBA81F6BE1F066")
    public int getRawExternalHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_739925965 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_739925965;
        // ---------- Original Method ----------
        //return 720;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.076 -0400", hash_original_method = "9D75A337ADB9CB99DE08523595E3FF43", hash_generated_method = "94169D941E7007B8CED28E23A7435E61")
    public void getMetricsWithSize(DisplayMetrics outMetrics,
            int width, int height) {
        outMetrics.densityDpi   = (int)((mDensity*DisplayMetrics.DENSITY_DEFAULT)+.5f);
        outMetrics.noncompatWidthPixels  = outMetrics.widthPixels = width;
        outMetrics.noncompatHeightPixels = outMetrics.heightPixels = height;
        outMetrics.density = outMetrics.noncompatDensity = mDensity;
        outMetrics.scaledDensity = outMetrics.noncompatScaledDensity = outMetrics.density;
        outMetrics.xdpi = outMetrics.noncompatXdpi = mDpiX;
        outMetrics.ydpi = outMetrics.noncompatYdpi = mDpiY;
        addTaint(outMetrics.getTaint());
        addTaint(width);
        addTaint(height);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.078 -0400", hash_original_method = "CE3A43F20C9E9D8C85E043AD25A6B3E9", hash_generated_method = "86A89056B78EFFB6F1C0AB9CF5755DEE")
    private void init(int display) {
    }

    
        public static Display createCompatibleDisplay(int displayId, CompatibilityInfoHolder compat) {
        return new Display(displayId, compat);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.079 -0400", hash_original_field = "1EBF27F42EEDCBCC0F731E08D860E11F", hash_generated_field = "3CB457B1787CE3437131AC7B54DE9305")

    static String TAG = "Display";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.079 -0400", hash_original_field = "5D5F1111C8AB800CF99BD2FF21D97A63", hash_generated_field = "EFE64C95606BA8B63D9E33AE1AEA5871")

    static boolean DEBUG_DISPLAY_SIZE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.079 -0400", hash_original_field = "6A0F429E8AAC5F34459248C31C56E729", hash_generated_field = "DE0938F6522CA6DA05C305B8778F7B69")

    public static final int DEFAULT_DISPLAY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.079 -0400", hash_original_field = "7170B744DAC66055703A154E1B3F312E", hash_generated_field = "CB2204234DD4AFF5747A32FC8C6E7F90")

    private static Object sStaticInit = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.079 -0400", hash_original_field = "36D6DBDDC3151D8D435DE4367930C71A", hash_generated_field = "815F7815DE01033DD7A51FFFBC42763D")

    private static boolean sInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.079 -0400", hash_original_field = "DE97087D3E19CB4D19590D5EDC0B28DE", hash_generated_field = "9FFB1E54F186971CA192F7BE25683B37")

    private static IWindowManager sWindowManager;
}

