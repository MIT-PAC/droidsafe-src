package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.897 -0400", hash_original_field = "27C9B400936470E0D86B9AA2CDF3AED4", hash_generated_field = "01AEB6BE7A1CFB44C6B781D7301EC317")

    private CompatibilityInfoHolder mCompatibilityInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.897 -0400", hash_original_field = "D29BCBAAD55DD1B1C5A0A9EB22E25252", hash_generated_field = "C3D33931672C9997D02DE67B6B8FC170")

    private int mDisplay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.897 -0400", hash_original_field = "29727137934799BC1D0686EA1284D9AC", hash_generated_field = "A3BE31732297BF4F97F73715693F8671")

    private int mPixelFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.897 -0400", hash_original_field = "96892C3CA593DB3BD1DCFF4EAD9D60E2", hash_generated_field = "3B186DE7AE43652AB2C26B4DC04F9761")

    private float mRefreshRate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.897 -0400", hash_original_field = "174BB9FF4691CBE6254BA90AE9FA0B63", hash_generated_field = "B5DC68677E93FA7FF1DA60AF3938C510")

    float mDensity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.897 -0400", hash_original_field = "E9855EBD17BB366B564310EC3316E0E7", hash_generated_field = "B2E7A1F0CAE99DBD9D3D65E29165C84A")

    float mDpiX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.897 -0400", hash_original_field = "B9AD09C6396CDB2CD033954CBA73419A", hash_generated_field = "BC1908C6E1D0054138584C2D01126D3C")

    float mDpiY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.897 -0400", hash_original_field = "43EB55458C4394666C2FF9CB27BDC008", hash_generated_field = "538425559D2BF0F635F9288868FC8D78")

    private final Point mTmpPoint = new Point();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.897 -0400", hash_original_field = "AE2D8764BEA6AAEE1A7358E2F8934DB6", hash_generated_field = "3C9E4AC56655D3050A4B4F36D2BBE1DC")

    private final DisplayMetrics mTmpMetrics = new DisplayMetrics();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.897 -0400", hash_original_field = "D79306417350CE6A12944817CEE2E9C4", hash_generated_field = "362C6D41A17812DA983C811277AF00AE")

    private float mLastGetTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.897 -0400", hash_original_method = "C9519A69B693719AC1491BF9F92C5C8E", hash_generated_method = "ED5490C5F9978E8C2243C4FB5ED0E037")
      Display(int display, CompatibilityInfoHolder compatInfo) {
        {
            {
                nativeClassInit();
                sInitialized = true;
            } 
        } 
        mCompatibilityInfo = compatInfo != null ? compatInfo : new CompatibilityInfoHolder();
        mDisplay = display;
        init(display);
        
        
            
                
                
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.898 -0400", hash_original_method = "107F25776C4AB2DB96852EDD25D31975", hash_generated_method = "CB95161FDF9B0E0157206BA05BD7B6B3")
    public int getDisplayId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1746350499 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1746350499;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static int getDisplayCount() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2086194105 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2086194105;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.913 -0400", hash_original_method = "17F24EABE37BDCE44DDE55CD705BD7B9", hash_generated_method = "FDF8E4C55ED8FDAF0C48488F4AE156B6")
    public void getSize(Point outSize) {
        getSizeInternal(outSize, true);
        addTaint(outSize.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.913 -0400", hash_original_method = "79B8C4439194701109AF7AA6129A555C", hash_generated_method = "6A627939C850644AE8B1E12826AA6E98")
    private void getSizeInternal(Point outSize, boolean doCompat) {
        try 
        {
            IWindowManager wm = getWindowManager();
            {
                wm.getDisplaySize(outSize);
                CompatibilityInfo ci;
                {
                    if(doCompat && (ci=mCompatibilityInfo.getIfNeeded()) != null)
                    {
                        {
                            mTmpMetrics.noncompatWidthPixels = outSize.x;
                            mTmpMetrics.noncompatHeightPixels = outSize.y;
                            mTmpMetrics.density = mDensity;
                            ci.applyToDisplayMetrics(mTmpMetrics);
                            outSize.x = mTmpMetrics.widthPixels;
                            outSize.y = mTmpMetrics.heightPixels;
                        } 
                    } 
                } 
            } 
            {
                outSize.x = getRawWidth();
                outSize.y = getRawHeight();
            } 
            {
                RuntimeException here = new RuntimeException("here");
                here.fillInStackTrace();
            } 
        } 
        catch (RemoteException e)
        { }
        addTaint(doCompat);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.914 -0400", hash_original_method = "92D5B5EBFB706321BDD6B906C6DF5945", hash_generated_method = "BF8C79659AD014CE2AE182010E7CC16F")
    public void getRectSize(Rect outSize) {
        {
            getSizeInternal(mTmpPoint, true);
            outSize.set(0, 0, mTmpPoint.x, mTmpPoint.y);
        } 
        addTaint(outSize.getTaint());
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.914 -0400", hash_original_method = "404C4EF6FA3AD3B9975B754C597D6C0E", hash_generated_method = "415B20E0EE8800A860C1F8AD479EA00F")
    public int getMaximumSizeDimension() {
        try 
        {
            IWindowManager wm = getWindowManager();
            int varC1FFFA445B088D9F26ADD6B752A76286_1883499594 = (wm.getMaximumSizeDimension());
        } 
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715856232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715856232;
        
        
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.915 -0400", hash_original_method = "2F7FD849240377F4AD58DDE704C1CFAA", hash_generated_method = "C53DD160482F6F53EB1466BF5881C704")
    @Deprecated
    public int getWidth() {
        {
            long now = SystemClock.uptimeMillis();
            {
                getSizeInternal(mTmpPoint, true);
                mLastGetTime = now;
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729852041 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729852041;
        
        
            
            
                
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.915 -0400", hash_original_method = "60FBCC92DE8F9EC729264DB15D46C4E8", hash_generated_method = "86790326E8ACA9A7A41E944DF967FA69")
    @Deprecated
    public int getHeight() {
        {
            long now = SystemClock.uptimeMillis();
            {
                getSizeInternal(mTmpPoint, true);
                mLastGetTime = now;
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_159981507 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_159981507;
        
        
            
            
                
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.916 -0400", hash_original_method = "B1AC967D724C688D478E66D81CB079DE", hash_generated_method = "84F256452C6CC2E720FBC1DE7BB6BB2C")
    public void getRealSize(Point outSize) {
        try 
        {
            IWindowManager wm = getWindowManager();
            {
                wm.getRealDisplaySize(outSize);
            } 
            {
                outSize.x = getRawWidth();
                outSize.y = getRawHeight();
            } 
        } 
        catch (RemoteException e)
        { }
        addTaint(outSize.getTaint());
        
        
            
            
                
            
                
                
            
            
                    
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.916 -0400", hash_original_method = "1DDDF7191F0FF0F7297CF97C1DA4B799", hash_generated_method = "224FD54AC634A605EC2D1583EAFCDD84")
    public int getRawWidth() {
        int w = getRawWidthNative();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_514160060 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_514160060;
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.917 -0400", hash_original_method = "F4A84F8F2FFCAD78922F38438709A2E6", hash_generated_method = "5240DBF8C19881FF7E1893A44B2592CD")
    private int getRawWidthNative() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_281566645 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_281566645;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.917 -0400", hash_original_method = "3ACB8E9BEACC517B317C29EAF3634629", hash_generated_method = "8CFB5588F3B36335DCE016EC61D5ACBB")
    public int getRawHeight() {
        int h = getRawHeightNative();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671899618 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671899618;
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.917 -0400", hash_original_method = "0BBCECD524BDD54CA608342D94B23905", hash_generated_method = "E3292778EB1FF06E094A66248CE23635")
    private int getRawHeightNative() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_337038740 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_337038740;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.918 -0400", hash_original_method = "0627945D4A6FEA5F8EF1880CC4DB952B", hash_generated_method = "8113ECF3B223C50CFF2A6EBF1C7F47BF")
    public int getRotation() {
        int var3524559B90F7538A184B8F3F95AB6F1B_1276992421 = (getOrientation());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1068135391 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1068135391;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.918 -0400", hash_original_method = "6E125A4EC20477CEC647612C37C0ECFE", hash_generated_method = "160C6A1B6A3C1316C1D0444105A51625")
    @Deprecated
    public int getOrientation() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_992558265 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_992558265;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.918 -0400", hash_original_method = "441029F9FCB9AB0438A81D4AE48234F0", hash_generated_method = "604DEAC3B69472627070A5967C31B34A")
    public int getPixelFormat() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1459088691 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1459088691;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.918 -0400", hash_original_method = "79009E426290AE6AA1C61D7B07738692", hash_generated_method = "A821D8C0A49EAA1FA6C8CEFD74560B88")
    public float getRefreshRate() {
        float var546ADE640B6EDFBC8A086EF31347E768_766593332 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_766593332;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.919 -0400", hash_original_method = "81980A722EF93A85BC60465488AFFEA3", hash_generated_method = "592496D265BF4D2B83954253E64BDE80")
    public void getMetrics(DisplayMetrics outMetrics) {
        {
            getSizeInternal(mTmpPoint, false);
            getMetricsWithSize(outMetrics, mTmpPoint.x, mTmpPoint.y);
        } 
        CompatibilityInfo ci = mCompatibilityInfo.getIfNeeded();
        {
            ci.applyToDisplayMetrics(outMetrics);
        } 
        addTaint(outMetrics.getTaint());
        
        
            
            
        
        
        
            
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.919 -0400", hash_original_method = "EF32DD6952DB89EBAA6A7EFF5769279F", hash_generated_method = "AA293FB6D63FF4A72EAD089D4E4247CF")
    public void getRealMetrics(DisplayMetrics outMetrics) {
        {
            getRealSize(mTmpPoint);
            getMetricsWithSize(outMetrics, mTmpPoint.x, mTmpPoint.y);
        } 
        addTaint(outMetrics.getTaint());
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.919 -0400", hash_original_method = "FDECD188634E4AD18CD2905FF365772D", hash_generated_method = "484412BCF55856269F7F1B4CD98DF39E")
    public int getRawExternalWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2034005066 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2034005066;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.920 -0400", hash_original_method = "376AC17F1270BAB2AB31395345202FD2", hash_generated_method = "1FA4ADD189F013487BC3EDF5775EB46B")
    public int getRawExternalHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_343904648 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_343904648;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.920 -0400", hash_original_method = "9D75A337ADB9CB99DE08523595E3FF43", hash_generated_method = "94169D941E7007B8CED28E23A7435E61")
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
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.921 -0400", hash_original_method = "CE3A43F20C9E9D8C85E043AD25A6B3E9", hash_generated_method = "86A89056B78EFFB6F1C0AB9CF5755DEE")
    private void init(int display) {
    }

    
    @DSModeled(DSC.SAFE)
    public static Display createCompatibleDisplay(int displayId, CompatibilityInfoHolder compat) {
        return new Display(displayId, compat);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.921 -0400", hash_original_field = "1EBF27F42EEDCBCC0F731E08D860E11F", hash_generated_field = "223CCD915B07E407EFEFA564FDB2DC20")

    static final String TAG = "Display";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.921 -0400", hash_original_field = "5D5F1111C8AB800CF99BD2FF21D97A63", hash_generated_field = "329D6DE5FD992832882D33C274C4BB6D")

    static final boolean DEBUG_DISPLAY_SIZE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.921 -0400", hash_original_field = "6A0F429E8AAC5F34459248C31C56E729", hash_generated_field = "DE0938F6522CA6DA05C305B8778F7B69")

    public static final int DEFAULT_DISPLAY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.921 -0400", hash_original_field = "7170B744DAC66055703A154E1B3F312E", hash_generated_field = "3688F7B3534C6CD8F91C89CB5E40FE68")

    private static final Object sStaticInit = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.921 -0400", hash_original_field = "36D6DBDDC3151D8D435DE4367930C71A", hash_generated_field = "815F7815DE01033DD7A51FFFBC42763D")

    private static boolean sInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.921 -0400", hash_original_field = "DE97087D3E19CB4D19590D5EDC0B28DE", hash_generated_field = "9FFB1E54F186971CA192F7BE25683B37")

    private static IWindowManager sWindowManager;
}

