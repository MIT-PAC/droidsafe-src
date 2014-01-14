package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.FloatMath;
import android.view.ScaleGestureDetector;
import android.view.View;

class ZoomManager {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.079 -0500", hash_original_method = "0CE84A24F36FD0C437C261366453F75E", hash_generated_method = "F48ACBA9CDF97743EA25FDE6367504D1")
    
public static final boolean exceedsMinScaleIncrement(float scaleA, float scaleB) {
        return Math.abs(scaleA - scaleB) >= MINIMUM_SCALE_INCREMENT;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.891 -0500", hash_original_field = "9EC6060D953E4B241D0862A24E232718", hash_generated_field = "1172DCF442F1B530BFE9216ADBA08AB8")

    static final String LOGTAG = "webviewZoom";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.902 -0500", hash_original_field = "986D8AB24558B30256E6BFE6832A539D", hash_generated_field = "01501206C858CCE0B2BAF203972C511B")

    protected static final float DEFAULT_MAX_ZOOM_SCALE_FACTOR = 4.00f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.904 -0500", hash_original_field = "F9CC5877B9A5958C469ADD36730195B9", hash_generated_field = "A8E4F36E80550FABF96F35586FC945C0")

    protected static final float DEFAULT_MIN_ZOOM_SCALE_FACTOR = 0.25f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.951 -0500", hash_original_field = "F43F9CEDE0299EC942B92C6AB9B827FA", hash_generated_field = "D8861706BAFD8699E50F90FBCF998F7D")

    private static float MIN_DOUBLE_TAP_SCALE_INCREMENT = 0.5f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.959 -0500", hash_original_field = "EE10B18CD2FFC70433BA5BBBE118CCA8", hash_generated_field = "9312CAAED499DB8E5F33CA8B59A623F5")

    private static float MINIMUM_SCALE_INCREMENT = 0.007f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.999 -0500", hash_original_field = "4508CB38D63D81546F950D92244E6C86", hash_generated_field = "3CC1005C93624AF917078598F90C5E0D")

    private static float MINIMUM_SCALE_WITHOUT_JITTER = 0.007f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.014 -0500", hash_original_field = "76A297309DBE139DBD3937D9A86A0D2B", hash_generated_field = "D2F744F6BCE3A182CFEB66495ABCBDAE")

    private static final int ZOOM_ANIMATION_LENGTH = 175;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.893 -0500", hash_original_field = "E044D69EE05B24F4B93E3A3B208F5343", hash_generated_field = "99346B50377E115231263981E00655CA")

    private  WebView mWebView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.895 -0500", hash_original_field = "C50B804397335F4C59F495D6A5AAA565", hash_generated_field = "62789CA10670C708EA4D387AB18C5F89")

    private  CallbackProxy mCallbackProxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.897 -0500", hash_original_field = "C0EC6A891B23E0319427F0A53D7AD13F", hash_generated_field = "2DA301B6F95E0EBE97AB103E0F47F9F3")

    private ZoomControlEmbedded mEmbeddedZoomControl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.899 -0500", hash_original_field = "78F0A316C80DF33CDE798483AAE32EFC", hash_generated_field = "E1828D795EA501C93F7B7AE52E32EC0D")

    private ZoomControlExternal mExternalZoomControl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.906 -0500", hash_original_field = "BC30C0256BC0C82E7FEA031317AC695B", hash_generated_field = "A75525F777409EAE64A30A85B5ECCBE1")

    private float mDefaultMaxZoomScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.908 -0500", hash_original_field = "42898D976553DD82818AFF2572A58B73", hash_generated_field = "52C961320D37FAE0F1AE675CFD1F2BEC")

    private float mDefaultMinZoomScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.911 -0500", hash_original_field = "1E404EBA92AD0127E3001A4C01B3FA6F", hash_generated_field = "7E5A3B4262F4F9926BCE7E3BC720EA86")

    // meta-tag.
    private float mMaxZoomScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.913 -0500", hash_original_field = "3684419759C727AAF6D5D503213E14ED", hash_generated_field = "62544A60744E4E06A4BB732A37B9A75D")

    private float mMinZoomScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.915 -0500", hash_original_field = "F1ACF5B4244BAB7FF80319E2D8461D3F", hash_generated_field = "0045D4254134E122CD3AF4AD2A34AE42")

    private boolean mMinZoomScaleFixed = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.917 -0500", hash_original_field = "E689F1248728AE4E5D430461B5EB7712", hash_generated_field = "0ED10F26046E2B869A9993F37463D665")

    private boolean mInitialZoomOverview = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.919 -0500", hash_original_field = "CB3432B5DA47BA9D794CF604AE4496A6", hash_generated_field = "D1063DF321563D8E711FE2915CC13ED6")

    private boolean mInZoomOverview = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.921 -0500", hash_original_field = "D029D1FF5EB940496296F0E5B636599F", hash_generated_field = "EEF381E8DFAB0F8AFA6DED39CA509D69")

    private int mZoomOverviewWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.923 -0500", hash_original_field = "B00695933AC4B49A7A9357D899E74462", hash_generated_field = "789EB22FC445F5CF4578A1B705BCFD89")

    private float mInvZoomOverviewWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.925 -0500", hash_original_field = "3BC5EB02A3CBC813E53EAEAF955D7188", hash_generated_field = "73D88F8A1B8C24D1E753BDF66C353FE4")

    private float mZoomCenterX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.927 -0500", hash_original_field = "54FCAC21658AD3618A187DD3E166827C", hash_generated_field = "0905DF24D370C5BABA5C5316D621064E")

    private float mZoomCenterY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.929 -0500", hash_original_field = "94A353B58E248D99854FB0B964DBEA35", hash_generated_field = "9E3ECCCE67853EF67D401BC85D54FCDD")

    private float mFocusX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.932 -0500", hash_original_field = "C5B54888D0BE6CAF4CFCD322A758FD24", hash_generated_field = "E01C42CAE2152A2827127C5E1618E0BF")

    private float mFocusY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.934 -0500", hash_original_field = "B042D48447B262C84F278D54669E271E", hash_generated_field = "7AE666B3B95EE2A25725DEE0E0FF8D16")

    private FocusMovementQueue mFocusMovementQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.936 -0500", hash_original_field = "4E9F1D0675C6E9FD9207FBE824AD8A0F", hash_generated_field = "5F8E058F09826A27700241950A47C51E")

    private int mAnchorX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.938 -0500", hash_original_field = "A5A5BAD4084BA0905925E24FE8CC16A6", hash_generated_field = "D3B700F3BB8B795E0ADFEB729C0AE646")

    private int mAnchorY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.940 -0500", hash_original_field = "B2BB1FC05073BD7B5469AA68A14F4A2A", hash_generated_field = "1B5C7663299982C5C7D3FB1CDE2DE612")

    private float mTextWrapScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.942 -0500", hash_original_field = "1BF737CEB256195165CA6AA7F00EB0A0", hash_generated_field = "2F8E15D8BE82ACCE0EB0157530F26BA2")

    private float mDefaultScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.944 -0500", hash_original_field = "E7F2088E3186ED6E711B20C9CC726111", hash_generated_field = "403E94F468B3BDF8320A5058252C64CF")

    private float mInvDefaultScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.946 -0500", hash_original_field = "A38D70A6C205F5BB4B6F0165EFD894AE", hash_generated_field = "6380DD00339CD0A77C6B25CB19413BC5")

    private float mDisplayDensity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.948 -0500", hash_original_field = "FC5998D66C89C9DCFBA1B163428C729D", hash_generated_field = "35F9B21E3F5F564C990231A1E5CD959C")

    private float mDoubleTapZoomFactor = 1.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.953 -0500", hash_original_field = "AD7D759DCB4263C6CE0E7A0291D94DCB", hash_generated_field = "EC2D05F087E31D17947841E32358DEC1")

    private float mActualScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.955 -0500", hash_original_field = "55BBAECB892DB3DEF835E766F0890A76", hash_generated_field = "C3F4C4AE5E1BA7A43BA1DC26150BBCED")

    private float mInvActualScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:59.957 -0500", hash_original_field = "2CE8EF6C987808D366DDEC86FE1DF12B", hash_generated_field = "86487DADE4014C689CAFFA37B4818AF4")

    private float mInitialScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.001 -0500", hash_original_field = "24526CC49D6791258FDFAD11F67EC267", hash_generated_field = "D8F7937535B71ED52FE04BF51381C2E3")

    private float mZoomScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.004 -0500", hash_original_field = "389543112DC9B6A0E41F04D1D8DEBFD8", hash_generated_field = "DFE1ED1EDAC53623D5358E45BF3F4EBD")

    private float mInvInitialZoomScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.005 -0500", hash_original_field = "AF062D4027643F1909751829968CD2CC", hash_generated_field = "424DF48095CC98F0B236E854F4E43A2D")

    private float mInvFinalZoomScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.008 -0500", hash_original_field = "8DC50DB8A996D09B805BC4397ACCBDDD", hash_generated_field = "B116C55D4B4D66EE153F454CBA568BE6")

    private int mInitialScrollX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.010 -0500", hash_original_field = "575A9B3AE6500CDBE4005B80E8DFC4C2", hash_generated_field = "E57D614FBFE0B9BAA23984CC3E7AD606")

    private int mInitialScrollY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.012 -0500", hash_original_field = "D99CAC257B10C078AFD83E35646877BE", hash_generated_field = "CCF37C49798D869F18D246B6747FFF61")

    private long mZoomStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.016 -0500", hash_original_field = "34526DBD4BA2774723EB45C2D1E3CE50", hash_generated_field = "17F95B8381C48D81ED3F070ABC618EA0")

    private boolean mSupportMultiTouch;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.018 -0500", hash_original_field = "1820FE56B414DC5A67A7D0677D0840DA", hash_generated_field = "9B444A6905DBFA8226D34C0732D3C33C")

    private boolean mAllowPanAndScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.021 -0500", hash_original_field = "1C7A0C94887904520CDF3D24017D37ED", hash_generated_field = "0C270CE12B813847261F32665B4317E0")

    private ScaleGestureDetector mScaleDetector;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.023 -0500", hash_original_field = "50D1A0CCD01BE1B93CE55B989341A107", hash_generated_field = "45DDE0467059E4D71CD5528DE7734AFC")

    private boolean mPinchToZoomAnimating = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.025 -0500", hash_original_field = "0F1E2DB2EED19077409EEEAC2482EC34", hash_generated_field = "80FDB96634A8A83890141751180EF1B9")

    private boolean mHardwareAccelerated = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.027 -0500", hash_original_field = "E6CF695CF82C963C5C3827E8A3977AA4", hash_generated_field = "F44E8E20A0C3B070FDDA9A2AECAA2700")

    private boolean mInHWAcceleratedZoom = false;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.029 -0500", hash_original_method = "C53EE2007D9BEC2FE01EA607CD54C4FF", hash_generated_method = "3785EBC01FA1C4F5700179AFEC726722")
    
public ZoomManager(WebView webView, CallbackProxy callbackProxy) {
        mWebView = webView;
        mCallbackProxy = callbackProxy;

        /*
         * Ideally mZoomOverviewWidth should be mContentWidth. But sites like
         * ESPN and Engadget always have wider mContentWidth no matter what the
         * viewport size is.
         */
        setZoomOverviewWidth(WebView.DEFAULT_VIEWPORT_WIDTH);

        mFocusMovementQueue = new FocusMovementQueue();
    }

    /**
     * Initialize both the default and actual zoom scale to the given density.
     *
     * @param density The logical density of the display. This is a scaling factor
     * for the Density Independent Pixel unit, where one DIP is one pixel on an
     * approximately 160 dpi screen (see android.util.DisplayMetrics.density).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.031 -0500", hash_original_method = "93CFAAB8556EE96135ADFFE4D2689C29", hash_generated_method = "E6F0C5AC03E54EF67D95CA417E603EAC")
    
public void init(float density) {
        assert density > 0;

        mDisplayDensity = density;
        setDefaultZoomScale(density);
        mActualScale = density;
        mInvActualScale = 1 / density;
        mTextWrapScale = getReadingLevelScale();
    }

    /**
     * Update the default zoom scale using the given density. It will also reset
     * the current min and max zoom scales to the default boundaries as well as
     * ensure that the actual scale falls within those boundaries.
     *
     * @param density The logical density of the display. This is a scaling factor
     * for the Density Independent Pixel unit, where one DIP is one pixel on an
     * approximately 160 dpi screen (see android.util.DisplayMetrics.density).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.033 -0500", hash_original_method = "2EFEEBFBDE6ACF8543350ABFFB008A8F", hash_generated_method = "7B0BD1B0AF3F3A86E7737297B110FC69")
    
public void updateDefaultZoomDensity(float density) {
        assert density > 0;

        if (Math.abs(density - mDefaultScale) > MINIMUM_SCALE_INCREMENT) {
            // Remember the current zoom density before it gets changed.
            final float originalDefault = mDefaultScale;
            // set the new default density
            setDefaultZoomScale(density);
            float scaleChange = (originalDefault > 0.0) ? density / originalDefault: 1.0f;
            // adjust the scale if it falls outside the new zoom bounds
            setZoomScale(mActualScale * scaleChange, true);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.036 -0500", hash_original_method = "E8BCC867B6D8CCFABF539A9D95032C95", hash_generated_method = "51EB7CE29967EC5AE80233E1964549D1")
    
private void setDefaultZoomScale(float defaultScale) {
        final float originalDefault = mDefaultScale;
        mDefaultScale = defaultScale;
        mInvDefaultScale = 1 / defaultScale;
        mDefaultMaxZoomScale = defaultScale * DEFAULT_MAX_ZOOM_SCALE_FACTOR;
        mDefaultMinZoomScale = defaultScale * DEFAULT_MIN_ZOOM_SCALE_FACTOR;
        if (originalDefault > 0.0 && mMaxZoomScale > 0.0) {
            // Keeps max zoom scale when zoom density changes.
            mMaxZoomScale = defaultScale / originalDefault * mMaxZoomScale;
        } else {
            mMaxZoomScale = mDefaultMaxZoomScale;
        }
        if (originalDefault > 0.0 && mMinZoomScale > 0.0) {
            // Keeps min zoom scale when zoom density changes.
            mMinZoomScale = defaultScale / originalDefault * mMinZoomScale;
        } else {
            mMinZoomScale = mDefaultMinZoomScale;
        }
        if (!exceedsMinScaleIncrement(mMinZoomScale, mMaxZoomScale)) {
            mMaxZoomScale = mMinZoomScale;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.039 -0500", hash_original_method = "E0A7D63CBE7BA22AE5FD1D2BCFACA30A", hash_generated_method = "A150440779A82C875482425F9B56B40A")
    
public final float getScale() {
        return mActualScale;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.041 -0500", hash_original_method = "27B2B7D16269E37341CA9CE429E50BD4", hash_generated_method = "89378C275E408CFEB1DF41845265A487")
    
public final float getInvScale() {
        return mInvActualScale;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.043 -0500", hash_original_method = "420B51415ADFBA4739EC66A8F732263C", hash_generated_method = "1B017D7B25B1B6CB821B0EA1E40C0848")
    
public final float getTextWrapScale() {
        return mTextWrapScale;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.045 -0500", hash_original_method = "4D84680032231769C697659C881951E3", hash_generated_method = "E6E64462C7CEAC10AD605329F2675017")
    
public final float getMaxZoomScale() {
        return mMaxZoomScale;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.047 -0500", hash_original_method = "EF101FB82D6E625D2F7286BB14442128", hash_generated_method = "0A97972A05CE1132406A8819E8619170")
    
public final float getMinZoomScale() {
        return mMinZoomScale;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.050 -0500", hash_original_method = "C9287BA17A965D05EE45D11D20F2D047", hash_generated_method = "4B7AB3C2F8FE3AC00BBED1F7CFA9903B")
    
public final float getDefaultScale() {
        return mDefaultScale;
    }

    /**
     * Returns the zoom scale used for reading text on a double-tap.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.052 -0500", hash_original_method = "B68BBC34F3F5ADBA444AF11F55B159F2", hash_generated_method = "AABB77F48C85B30AE57D94FF12410459")
    
public final float getReadingLevelScale() {
        return mDisplayDensity * mDoubleTapZoomFactor;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.054 -0500", hash_original_method = "150923628532607A08D5A6F81E7006FE", hash_generated_method = "B2E218CAD4490E737DAFA45232E83039")
    
public final float getInvDefaultScale() {
        return mInvDefaultScale;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.056 -0500", hash_original_method = "86C1C61E20B5F864D06602058822F40B", hash_generated_method = "EDD8465E0486F28C5B7E4D2D23857EF2")
    
public final float getDefaultMaxZoomScale() {
        return mDefaultMaxZoomScale;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.059 -0500", hash_original_method = "68697F997D536A00F27515B45D68169D", hash_generated_method = "362719130226A1DE15762B47DC7469B0")
    
public final float getDefaultMinZoomScale() {
        return mDefaultMinZoomScale;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.061 -0500", hash_original_method = "0D1E90BA2B32E85CA9E1B47821E3129C", hash_generated_method = "D38368F1B0BBCD633B627409A1480B5F")
    
public final int getDocumentAnchorX() {
        return mAnchorX;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.063 -0500", hash_original_method = "6F8EAB28E274BDE9903F29B52FA3CE08", hash_generated_method = "C78FDEEE83323ABF560CB87A50F26068")
    
public final int getDocumentAnchorY() {
        return mAnchorY;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.066 -0500", hash_original_method = "37EC19EE8D577B9FFE8E8612EB136E0D", hash_generated_method = "22B9D1124A6D8D8F5A2978DCEF2DD6BD")
    
public final void clearDocumentAnchor() {
        mAnchorX = mAnchorY = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.068 -0500", hash_original_method = "B42B83C0DB8155DA229557A2BD45C477", hash_generated_method = "6E0F9E066E9809FA1F1D8F66688C282F")
    
public final void setZoomCenter(float x, float y) {
        mZoomCenterX = x;
        mZoomCenterY = y;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.070 -0500", hash_original_method = "E17C2AED3C2D9DCFE2D098E038948EA1", hash_generated_method = "F9736CAE86B77E9F37F5A1B4A523234C")
    
public final void setInitialScaleInPercent(int scaleInPercent) {
        mInitialScale = scaleInPercent * 0.01f;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.072 -0500", hash_original_method = "CACC1DB3C5C8FBE689456F981994723C", hash_generated_method = "4D086CC3E24CF29B22C019364D380414")
    
public final float computeScaleWithLimits(float scale) {
        if (scale < mMinZoomScale) {
            scale = mMinZoomScale;
        } else if (scale > mMaxZoomScale) {
            scale = mMaxZoomScale;
        }
        return scale;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.074 -0500", hash_original_method = "49E88837FC0437D5B36C3DDB131811B0", hash_generated_method = "238E8158F890E53D070989D6937BF62B")
    
public final boolean isScaleOverLimits(float scale) {
        return scale <= mMinZoomScale || scale >= mMaxZoomScale;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.076 -0500", hash_original_method = "EAE2E4FAF7045B63798AAD0EC191C138", hash_generated_method = "84F21B2ECBF570FB0233A1320ACDDF97")
    
public final boolean isZoomScaleFixed() {
        return mMinZoomScale >= mMaxZoomScale;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.081 -0500", hash_original_method = "73353D5825B74E55208D73C06ED7146E", hash_generated_method = "AFD4EF55BB4B1386D1604529738A97A2")
    
public boolean willScaleTriggerZoom(float scale) {
        return exceedsMinScaleIncrement(scale, mActualScale);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.083 -0500", hash_original_method = "577BAEA37EC580D2471F28E52ACC3E90", hash_generated_method = "9DB46A8AC90999683FE44B65E3FB7C9E")
    
public final boolean canZoomIn() {
        return mMaxZoomScale - mActualScale > MINIMUM_SCALE_INCREMENT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.086 -0500", hash_original_method = "82D91A91E65D0066AFB31608B5056133", hash_generated_method = "CC3263579B855613058D5EC6F97CEC9C")
    
public final boolean canZoomOut() {
        return mActualScale - mMinZoomScale > MINIMUM_SCALE_INCREMENT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.088 -0500", hash_original_method = "1087ACA9FDE3F82506A02D8DB9B3B812", hash_generated_method = "62A1E84D7FA4CA9730D473C9263468C4")
    
public boolean zoomIn() {
        return zoom(1.25f);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.090 -0500", hash_original_method = "AF303514C2CE6EE62014ED1CD988BE8F", hash_generated_method = "E4300A71B58B20B29A0C9A17B7E703C9")
    
public boolean zoomOut() {
        return zoom(0.8f);
    }

    // returns TRUE if zoom out succeeds and FALSE if no zoom changes.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.092 -0500", hash_original_method = "0D06D835317E38A4890F08EB962517B9", hash_generated_method = "8FD242627139C80C62C92726BEF2E23F")
    
private boolean zoom(float zoomMultiplier) {
        mInitialZoomOverview = false;
        // TODO: alternatively we can disallow this during draw history mode
        mWebView.switchOutDrawHistory();
        // Center zooming to the center of the screen.
        mZoomCenterX = mWebView.getViewWidth() * .5f;
        mZoomCenterY = mWebView.getViewHeight() * .5f;
        mAnchorX = mWebView.viewToContentX((int) mZoomCenterX + mWebView.getScrollX());
        mAnchorY = mWebView.viewToContentY((int) mZoomCenterY + mWebView.getScrollY());
        return startZoomAnimation(mActualScale * zoomMultiplier, 
            !mWebView.getSettings().getUseFixedViewport());
    }

    /**
     * Initiates an animated zoom of the WebView.
     *
     * @return true if the new scale triggered an animation and false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.095 -0500", hash_original_method = "ABA8C6E97A9C369182835D6347EB12CF", hash_generated_method = "8A65B7C39D98D059FA6DE22AD18BC4F6")
    
public boolean startZoomAnimation(float scale, boolean reflowText) {
        mInitialZoomOverview = false;
        float oldScale = mActualScale;
        mInitialScrollX = mWebView.getScrollX();
        mInitialScrollY = mWebView.getScrollY();

        // snap to reading level scale if it is close
        if (!exceedsMinScaleIncrement(scale, getReadingLevelScale())) {
            scale = getReadingLevelScale();
        }

        if (mHardwareAccelerated) {
            mInHWAcceleratedZoom = true;
        }

        setZoomScale(scale, reflowText);

        if (oldScale != mActualScale) {
            // use mZoomPickerScale to see zoom preview first
            mZoomStart = SystemClock.uptimeMillis();
            mInvInitialZoomScale = 1.0f / oldScale;
            mInvFinalZoomScale = 1.0f / mActualScale;
            mZoomScale = mActualScale;
            mWebView.onFixedLengthZoomAnimationStart();
            mWebView.invalidate();
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is called by the WebView's drawing code when a fixed length zoom
     * animation is occurring. Its purpose is to animate the zooming of the canvas
     * to the desired scale which was specified in startZoomAnimation(...).
     *
     * A fixed length animation begins when startZoomAnimation(...) is called and
     * continues until the ZOOM_ANIMATION_LENGTH time has elapsed. During that
     * interval each time the WebView draws it calls this function which is 
     * responsible for generating the animation.
     *
     * Additionally, the WebView can check to see if such an animation is currently
     * in progress by calling isFixedLengthAnimationInProgress().
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.098 -0500", hash_original_method = "4B2E3C5C63E13C95ACA7AA346AD0833D", hash_generated_method = "78AA0F41E5A5393BE9D7C73BF0536F4B")
    
public void animateZoom(Canvas canvas) {
        mInitialZoomOverview = false;
        if (mZoomScale == 0) {
            Log.w(LOGTAG, "A WebView is attempting to perform a fixed length "
                    + "zoom animation when no zoom is in progress");
            return;
        }

        float zoomScale;
        int interval = (int) (SystemClock.uptimeMillis() - mZoomStart);
        if (interval < ZOOM_ANIMATION_LENGTH) {
            float ratio = (float) interval / ZOOM_ANIMATION_LENGTH;
            zoomScale = 1.0f / (mInvInitialZoomScale
                    + (mInvFinalZoomScale - mInvInitialZoomScale) * ratio);
            mWebView.invalidate();
        } else {
            zoomScale = mZoomScale;
            // set mZoomScale to be 0 as we have finished animating
            mZoomScale = 0;
            mWebView.onFixedLengthZoomAnimationEnd();
        }
        // calculate the intermediate scroll position. Since we need to use
        // zoomScale, we can't use the WebView's pinLocX/Y functions directly.
        float scale = zoomScale * mInvInitialZoomScale;
        int tx = Math.round(scale * (mInitialScrollX + mZoomCenterX) - mZoomCenterX);
        tx = -WebView.pinLoc(tx, mWebView.getViewWidth(), Math.round(mWebView.getContentWidth()
                * zoomScale)) + mWebView.getScrollX();
        int titleHeight = mWebView.getTitleHeight();
        int ty = Math.round(scale
                * (mInitialScrollY + mZoomCenterY - titleHeight)
                - (mZoomCenterY - titleHeight));
        ty = -(ty <= titleHeight ? Math.max(ty, 0) : WebView.pinLoc(ty
                - titleHeight, mWebView.getViewHeight(), Math.round(mWebView.getContentHeight()
                * zoomScale)) + titleHeight) + mWebView.getScrollY();

        if (mHardwareAccelerated) {
            mWebView.updateScrollCoordinates(mWebView.getScrollX() - tx, mWebView.getScrollY() - ty);
            // By adding webView matrix, we need to offset the canvas a bit
            // to make the animation smooth.
            canvas.translate(tx, ty);
            setZoomScale(zoomScale, false);

            if (mZoomScale == 0) {
                // We've reached the end of the zoom animation.
                mInHWAcceleratedZoom = false;

                // Ensure that the zoom level is pushed to WebCore. This has not
                // yet occurred because we prevent it from happening while
                // mInHWAcceleratedZoom is true.
                mWebView.sendViewSizeZoom(false);
            }
        } else {
            canvas.translate(tx, ty);
            canvas.scale(zoomScale, zoomScale);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.100 -0500", hash_original_method = "E0C5EE754D896EBEA19BF99FCF86359E", hash_generated_method = "BE50670EFE1E12DFEC04C0DCEE799109")
    
public boolean isZoomAnimating() {
        return isFixedLengthAnimationInProgress() || mPinchToZoomAnimating;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.102 -0500", hash_original_method = "351373D4552618F4F14C898A250D84BD", hash_generated_method = "2FC1FD6A68FB28B65B0B2F5739A422F1")
    
public boolean isFixedLengthAnimationInProgress() {
        return mZoomScale != 0 || mInHWAcceleratedZoom;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.104 -0500", hash_original_method = "38BADAFCA13DD410DF65C206538CBBC7", hash_generated_method = "6A4CCEC24DF0FC179D7A9EB237386082")
    
public void updateDoubleTapZoom(int doubleTapZoom) {
        boolean zoomIn = (mTextWrapScale - mActualScale) < .1f;
        mDoubleTapZoomFactor = doubleTapZoom / 100.0f;
        mTextWrapScale = getReadingLevelScale();
        float newScale = zoomIn ? mTextWrapScale
                : Math.min(mTextWrapScale, mActualScale);
        setZoomScale(newScale, true, true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.106 -0500", hash_original_method = "D0144FE074B01386F16EF11E861F0A7A", hash_generated_method = "000A5F1EE9C703449D17A9F99C7CA5C2")
    
public void refreshZoomScale(boolean reflowText) {
        setZoomScale(mActualScale, reflowText, true);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.109 -0500", hash_original_method = "0CAC496E58068B9E4E1CC3313C83A17E", hash_generated_method = "6A86D3B849FD1AD4DE308764F80800FB")
    
public void setZoomScale(float scale, boolean reflowText) {
        setZoomScale(scale, reflowText, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.113 -0500", hash_original_method = "3A85AAAB95D1CDF586170EB3BBF2667E", hash_generated_method = "B9F3883AE0204845FB5B1CF8AE4BC2B1")
    
private void setZoomScale(float scale, boolean reflowText, boolean force) {
        final boolean isScaleLessThanMinZoom = scale < mMinZoomScale;
        scale = computeScaleWithLimits(scale);

        // determine whether or not we are in the zoom overview mode
        if (isScaleLessThanMinZoom && mMinZoomScale < mDefaultScale) {
            mInZoomOverview = true;
        } else {
            mInZoomOverview = !exceedsMinScaleIncrement(scale, getZoomOverviewScale());
        }

        if (reflowText && !mWebView.getSettings().getUseFixedViewport()) {
            mTextWrapScale = scale;
        }

        if (scale != mActualScale || force) {
            float oldScale = mActualScale;
            float oldInvScale = mInvActualScale;

            if (scale != mActualScale && !mPinchToZoomAnimating) {
                mCallbackProxy.onScaleChanged(mActualScale, scale);
            }

            mActualScale = scale;
            mInvActualScale = 1 / scale;

            if (!mWebView.drawHistory() && !mInHWAcceleratedZoom) {

                // If history Picture is drawn, don't update scroll. They will
                // be updated when we get out of that mode.
                // update our scroll so we don't appear to jump
                // i.e. keep the center of the doc in the center of the view
                // If this is part of a zoom on a HW accelerated canvas, we
                // have already updated the scroll so don't do it again.
                int oldX = mWebView.getScrollX();
                int oldY = mWebView.getScrollY();
                float ratio = scale * oldInvScale;
                float sx = ratio * oldX + (ratio - 1) * mZoomCenterX;
                float sy = ratio * oldY + (ratio - 1)
                        * (mZoomCenterY - mWebView.getTitleHeight());

                // Scale all the child views
                mWebView.mViewManager.scaleAll();

                // as we don't have animation for scaling, don't do animation
                // for scrolling, as it causes weird intermediate state
                int scrollX = mWebView.pinLocX(Math.round(sx));
                int scrollY = mWebView.pinLocY(Math.round(sy));
                if(!mWebView.updateScrollCoordinates(scrollX, scrollY)) {
                    // the scroll position is adjusted at the beginning of the
                    // zoom animation. But we want to update the WebKit at the
                    // end of the zoom animation. See comments in onScaleEnd().
                    mWebView.sendOurVisibleRect();
                }
            }

            // if the we need to reflow the text then force the VIEW_SIZE_CHANGED
            // event to be sent to WebKit
            mWebView.sendViewSizeZoom(reflowText);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.115 -0500", hash_original_method = "6C9BE8F81CD8D5D51E25813EE62B3846", hash_generated_method = "52C14BC8B8CE1CD9176F2522CE3EE293")
    
public boolean isDoubleTapEnabled() {
        WebSettings settings = mWebView.getSettings();
        return settings != null && settings.getUseWideViewPort();
    }

    /**
     * The double tap gesture can result in different behaviors depending on the
     * content that is tapped.
     *
     * (1) PLUGINS: If the taps occur on a plugin then we maximize the plugin on
     * the screen. If the plugin is already maximized then zoom the user into
     * overview mode.
     *
     * (2) HTML/OTHER: If the taps occur outside a plugin then the following
     * heuristic is used.
     *   A. If the current text wrap scale differs from newly calculated and the
     *      layout algorithm specifies the use of NARROW_COLUMNS, then fit to
     *      column by reflowing the text.
     *   B. If the page is not in overview mode then change to overview mode.
     *   C. If the page is in overmode then change to the default scale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.117 -0500", hash_original_method = "4C79B03AF1323FEB3700FE89F15D8B06", hash_generated_method = "3F7A0473178F8E8594DCDC7C6BBB2C0D")
    
public void handleDoubleTap(float lastTouchX, float lastTouchY) {
        // User takes action, set initial zoom overview to false.
        mInitialZoomOverview = false;
        WebSettings settings = mWebView.getSettings();
        if (!isDoubleTapEnabled()) {
            return;
        }

        setZoomCenter(lastTouchX, lastTouchY);
        mAnchorX = mWebView.viewToContentX((int) lastTouchX + mWebView.getScrollX());
        mAnchorY = mWebView.viewToContentY((int) lastTouchY + mWebView.getScrollY());
        settings.setDoubleTapToastCount(0);

        // remove the zoom control after double tap
        dismissZoomPicker();

        /*
         * If the double tap was on a plugin then either zoom to maximize the
         * plugin on the screen or scale to overview mode.
         */
        Rect pluginBounds = mWebView.getPluginBounds(mAnchorX, mAnchorY);
        if (pluginBounds != null) {
            if (mWebView.isRectFitOnScreen(pluginBounds)) {
                zoomToOverview();
            } else {
                mWebView.centerFitRect(pluginBounds);
            }
            return;
        }

        final float newTextWrapScale;
        if (settings.getUseFixedViewport()) {
            newTextWrapScale = Math.max(mActualScale, getReadingLevelScale());
        } else {
            newTextWrapScale = mActualScale;
        }
        final boolean firstTimeReflow = !exceedsMinScaleIncrement(mActualScale, mTextWrapScale);
        if (firstTimeReflow || mInZoomOverview) {
            // In case first time reflow or in zoom overview mode, let reflow and zoom
            // happen at the same time.
            mTextWrapScale = newTextWrapScale;
        }
        if (settings.isNarrowColumnLayout()
                && exceedsMinScaleIncrement(mTextWrapScale, newTextWrapScale)
                && !firstTimeReflow
                && !mInZoomOverview) {
            // Reflow only.
            mTextWrapScale = newTextWrapScale;
            refreshZoomScale(true);
        } else if (!mInZoomOverview && willScaleTriggerZoom(getZoomOverviewScale())) {
            // Reflow, if necessary.
            if (mTextWrapScale > getReadingLevelScale()) {
                mTextWrapScale = getReadingLevelScale();
                refreshZoomScale(true);
            }
            zoomToOverview();
        } else {
            zoomToReadingLevelOrMore();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.120 -0500", hash_original_method = "712C22BAE7AA3B12B6A5A40165B58905", hash_generated_method = "0769B498ED18DD4448A2A8DCAC358CB8")
    
private void setZoomOverviewWidth(int width) {
        if (width == 0) {
            mZoomOverviewWidth = WebView.DEFAULT_VIEWPORT_WIDTH;
        } else {
            mZoomOverviewWidth = width;
        }
        mInvZoomOverviewWidth = 1.0f / width;
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.121 -0500", hash_original_method = "B42D229ABB1FC24C49B118C5D42DFED9", hash_generated_method = "B42D229ABB1FC24C49B118C5D42DFED9")
    
float getZoomOverviewScale() {
        return mWebView.getViewWidth() * mInvZoomOverviewWidth;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.123 -0500", hash_original_method = "C49CAD609BC6A273DA434DC912742003", hash_generated_method = "A0BB9850EF7448EAD9F93737E28F819E")
    
public boolean isInZoomOverview() {
        return mInZoomOverview;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.126 -0500", hash_original_method = "C0C0965039A172A5A5AAF6C9C4472D2A", hash_generated_method = "98858A1F492C45744BC6EB3273EE4A33")
    
private void zoomToOverview() {
        // Force the titlebar fully reveal in overview mode
        int scrollY = mWebView.getScrollY();
        if (scrollY < mWebView.getTitleHeight()) {
            mWebView.updateScrollCoordinates(mWebView.getScrollX(), 0);
        }
        startZoomAnimation(getZoomOverviewScale(), 
            !mWebView.getSettings().getUseFixedViewport());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.129 -0500", hash_original_method = "6051F287C8BD349D628462D7AA7CF8A8", hash_generated_method = "9558E0E68E7B9A83D57BAFDCADC7C59C")
    
private void zoomToReadingLevelOrMore() {
        final float zoomScale = Math.max(getReadingLevelScale(),
                mActualScale + MIN_DOUBLE_TAP_SCALE_INCREMENT);

        int left = mWebView.nativeGetBlockLeftEdge(mAnchorX, mAnchorY, mActualScale);
        if (left != WebView.NO_LEFTEDGE) {
            // add a 5pt padding to the left edge.
            int viewLeft = mWebView.contentToViewX(left < 5 ? 0 : (left - 5))
                    - mWebView.getScrollX();
            // Re-calculate the zoom center so that the new scroll x will be
            // on the left edge.
            if (viewLeft > 0) {
                mZoomCenterX = viewLeft * zoomScale / (zoomScale - mActualScale);
            } else {
                mWebView.scrollBy(viewLeft, 0);
                mZoomCenterX = 0;
            }
        }
        startZoomAnimation(zoomScale,
            !mWebView.getSettings().getUseFixedViewport());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.131 -0500", hash_original_method = "77E44A3E983371F616079D37D03C3B6C", hash_generated_method = "77B473D50D403A6C270140E45AC14639")
    
public void updateMultiTouchSupport(Context context) {
        // check the preconditions
        assert mWebView.getSettings() != null;

        final WebSettings settings = mWebView.getSettings();
        final PackageManager pm = context.getPackageManager();
        mSupportMultiTouch = 
                (pm.hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH)
                 || pm.hasSystemFeature(PackageManager.FEATURE_FAKETOUCH_MULTITOUCH_DISTINCT))
                && settings.supportZoom() && settings.getBuiltInZoomControls();
        mAllowPanAndScale =
                pm.hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT)
                || pm.hasSystemFeature(PackageManager.FEATURE_FAKETOUCH_MULTITOUCH_DISTINCT);

        if (mSupportMultiTouch && (mScaleDetector == null)) {
            mScaleDetector = new ScaleGestureDetector(context, new ScaleDetectorListener());
        } else if (!mSupportMultiTouch && (mScaleDetector != null)) {
            mScaleDetector = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.133 -0500", hash_original_method = "D759966F5D5714E0336F491E3EEDC527", hash_generated_method = "0E66941ECA741A1D7CF3147AD755BE51")
    
public boolean supportsMultiTouchZoom() {
        return mSupportMultiTouch;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.136 -0500", hash_original_method = "E2CDCD424944BF66C1EED756BC88611C", hash_generated_method = "94F62589EBF8431E17B2B9B424B1FB1D")
    
public boolean supportsPanDuringZoom() {
        return mAllowPanAndScale;
    }

    /**
     * Notifies the caller that the ZoomManager is requesting that scale related
     * updates should not be sent to webkit. This can occur in cases where the
     * ZoomManager is performing an animation and does not want webkit to update
     * until the animation is complete.
     *
     * @return true if scale related updates should not be sent to webkit and
     *         false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.138 -0500", hash_original_method = "DB3FE2513664456015F767E0971235E8", hash_generated_method = "D8F974B133FEC957A11D4C56787360D6")
    
public boolean isPreventingWebkitUpdates() {
        // currently only animating a multi-touch zoom and fixed length
        // animations prevent updates, but others can add their own conditions
        // to this method if necessary.
        return isZoomAnimating();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.140 -0500", hash_original_method = "D6F4E788215219485BF912038215831B", hash_generated_method = "D1D7D4DCBD17F4DE34B948A236271E0C")
    
public ScaleGestureDetector getMultiTouchGestureDetector() {
        return mScaleDetector;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.184 -0500", hash_original_method = "CAC2F3D27B1973D4CF70D4BE09DB9479", hash_generated_method = "6BF3FB475273A35B51810312FF5DB22B")
    
public void onSizeChanged(int w, int h, int ow, int oh) {
        // reset zoom and anchor to the top left corner of the screen
        // unless we are already zooming
        if (!isFixedLengthAnimationInProgress()) {
            int visibleTitleHeight = mWebView.getVisibleTitleHeight();
            mZoomCenterX = 0;
            mZoomCenterY = visibleTitleHeight;
            mAnchorX = mWebView.viewToContentX(mWebView.getScrollX());
            mAnchorY = mWebView.viewToContentY(visibleTitleHeight + mWebView.getScrollY());
        }

        // update mMinZoomScale if the minimum zoom scale is not fixed
        if (!mMinZoomScaleFixed) {
            // when change from narrow screen to wide screen, the new viewWidth
            // can be wider than the old content width. We limit the minimum
            // scale to 1.0f. The proper minimum scale will be calculated when
            // the new picture shows up.
            mMinZoomScale = Math.min(1.0f, (float) mWebView.getViewWidth()
                    / (mWebView.drawHistory() ? mWebView.getHistoryPictureWidth()
                            : mZoomOverviewWidth));
            // limit the minZoomScale to the initialScale if it is set
            if (mInitialScale > 0 && mInitialScale < mMinZoomScale) {
                mMinZoomScale = mInitialScale;
            }
        }

        dismissZoomPicker();

        // onSizeChanged() is called during WebView layout. And any
        // requestLayout() is blocked during layout. As refreshZoomScale() will
        // cause its child View to reposition itself through ViewManager's
        // scaleAll(), we need to post a Runnable to ensure requestLayout().
        // Additionally, only update the text wrap scale if the width changed.
        mWebView.post(new PostScale(w != ow &&
            !mWebView.getSettings().getUseFixedViewport(), mInZoomOverview, w < ow));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.201 -0500", hash_original_method = "853C20600470FB7106E8D67215AF9147", hash_generated_method = "71AE93E4FCDDDD14DDE98A830729F062")
    
public void updateZoomRange(WebViewCore.ViewState viewState,
            int viewWidth, int minPrefWidth) {
        if (viewState.mMinScale == 0) {
            if (viewState.mMobileSite) {
                if (minPrefWidth > Math.max(0, viewWidth)) {
                    mMinZoomScale = (float) viewWidth / minPrefWidth;
                    mMinZoomScaleFixed = false;
                } else {
                    mMinZoomScale = viewState.mDefaultScale;
                    mMinZoomScaleFixed = true;
                }
            } else {
                mMinZoomScale = mDefaultMinZoomScale;
                mMinZoomScaleFixed = false;
            }
        } else {
            mMinZoomScale = viewState.mMinScale;
            mMinZoomScaleFixed = true;
        }
        if (viewState.mMaxScale == 0) {
            mMaxZoomScale = mDefaultMaxZoomScale;
        } else {
            mMaxZoomScale = viewState.mMaxScale;
        }
    }

    /**
     * Updates zoom values when Webkit produces a new picture. This method
     * should only be called from the UI thread's message handler.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.203 -0500", hash_original_method = "30705697D50ADB9D51B01BF1D1A7F736", hash_generated_method = "283227C74339C960563B2FCBB51B1CC4")
    
public void onNewPicture(WebViewCore.DrawData drawData) {
        final int viewWidth = mWebView.getViewWidth();
        final boolean zoomOverviewWidthChanged = setupZoomOverviewWidth(drawData, viewWidth);
        final float newZoomOverviewScale = getZoomOverviewScale();
        WebSettings settings = mWebView.getSettings();
        if (zoomOverviewWidthChanged && settings.isNarrowColumnLayout() &&
            settings.getUseFixedViewport() &&
            (mInitialZoomOverview || mInZoomOverview)) {
            // Keep mobile site's text wrap scale unchanged.  For mobile sites,
            // the text wrap scale is the same as zoom overview scale.
            if (exceedsMinScaleIncrement(mTextWrapScale, mDefaultScale) ||
                    exceedsMinScaleIncrement(newZoomOverviewScale, mDefaultScale)) {
                mTextWrapScale = getReadingLevelScale();
            } else {
                mTextWrapScale = newZoomOverviewScale;
            }
        }

        if (!mMinZoomScaleFixed || settings.getUseWideViewPort()) {
            mMinZoomScale = newZoomOverviewScale;
            mMaxZoomScale = Math.max(mMaxZoomScale, mMinZoomScale);
        }
        // fit the content width to the current view for the first new picture
        // after first layout.
        boolean scaleHasDiff = exceedsMinScaleIncrement(newZoomOverviewScale, mActualScale);
        // Make sure the actual scale is no less than zoom overview scale.
        boolean scaleLessThanOverview =
                (newZoomOverviewScale - mActualScale) >= MINIMUM_SCALE_INCREMENT;
        // Make sure mobile sites are correctly handled since mobile site will
        // change content width after rotating.
        boolean mobileSiteInOverview = mInZoomOverview &&
                !exceedsMinScaleIncrement(newZoomOverviewScale, mDefaultScale);
        if (!mWebView.drawHistory() &&
            ((scaleLessThanOverview && settings.getUseWideViewPort())||
                ((mInitialZoomOverview || mobileSiteInOverview) &&
                    scaleHasDiff && zoomOverviewWidthChanged))) {
            mInitialZoomOverview = false;
            setZoomScale(newZoomOverviewScale, !willScaleTriggerZoom(mTextWrapScale) &&
                !mWebView.getSettings().getUseFixedViewport());
        } else {
            mInZoomOverview = !scaleHasDiff;
        }
        if (drawData.mFirstLayoutForNonStandardLoad && settings.getLoadWithOverviewMode()) {
            // Set mInitialZoomOverview in case this is the first picture for non standard load,
            // so next new picture could be forced into overview mode if it's true.
            mInitialZoomOverview = mInZoomOverview;
        }
    }

    /**
     * Set up correct zoom overview width based on different settings.
     *
     * @param drawData webviewcore draw data
     * @param viewWidth current view width
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.206 -0500", hash_original_method = "74FCB7875112FE9C3AB647C4DB8DEDB6", hash_generated_method = "4C5C216BCA3C83B546A6D18C0A0847F2")
    
private boolean setupZoomOverviewWidth(WebViewCore.DrawData drawData, final int viewWidth) {
        WebSettings settings = mWebView.getSettings();
        int newZoomOverviewWidth = mZoomOverviewWidth;
        if (settings.getUseWideViewPort()) {
            if (drawData.mContentSize.x > 0) {
                // The webkitDraw for layers will not populate contentSize, and it'll be
                // ignored for zoom overview width update.
                newZoomOverviewWidth = Math.min(WebView.sMaxViewportWidth,
                    drawData.mContentSize.x);
            }
        } else {
            // If not use wide viewport, use view width as the zoom overview width.
            newZoomOverviewWidth = Math.round(viewWidth / mDefaultScale);
        }
        if (newZoomOverviewWidth != mZoomOverviewWidth) {
            setZoomOverviewWidth(newZoomOverviewWidth);
            return true;
        }
        return false;
    }

    /**
     * Updates zoom values after Webkit completes the initial page layout. It
     * is called when visiting a page for the first time as well as when the
     * user navigates back to a page (in which case we may need to restore the
     * zoom levels to the state they were when you left the page). This method
     * should only be called from the UI thread's message handler.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.209 -0500", hash_original_method = "49A97AD028E7397E6545CF950CBFEBF3", hash_generated_method = "13A108A9888D950A3EBEC0B4D19CF619")
    
public void onFirstLayout(WebViewCore.DrawData drawData) {
        // precondition check
        assert drawData != null;
        assert drawData.mViewState != null;
        assert mWebView.getSettings() != null;

        WebViewCore.ViewState viewState = drawData.mViewState;
        final Point viewSize = drawData.mViewSize;
        updateZoomRange(viewState, viewSize.x, drawData.mMinPrefWidth);
        setupZoomOverviewWidth(drawData, mWebView.getViewWidth());
        final float overviewScale = getZoomOverviewScale();
        WebSettings settings = mWebView.getSettings();
        if (!mMinZoomScaleFixed || settings.getUseWideViewPort()) {
            mMinZoomScale = (mInitialScale > 0) ?
                    Math.min(mInitialScale, overviewScale) : overviewScale;
            mMaxZoomScale = Math.max(mMaxZoomScale, mMinZoomScale);
        }

        if (!mWebView.drawHistory()) {
            float scale;
            if (mInitialScale > 0) {
                scale = mInitialScale;
            } else if (viewState.mIsRestored || viewState.mViewScale > 0) {
                scale = (viewState.mViewScale > 0)
                    ? viewState.mViewScale : overviewScale;
                mTextWrapScale = (viewState.mTextWrapScale > 0)
                    ? viewState.mTextWrapScale : getReadingLevelScale();
            } else {
                scale = overviewScale;
                if (!settings.getUseWideViewPort()
                    || !settings.getLoadWithOverviewMode()) {
                    scale = Math.max(mDefaultScale, scale);
                }
                if (settings.isNarrowColumnLayout() &&
                    settings.getUseFixedViewport()) {
                    // When first layout, reflow using the reading level scale to avoid
                    // reflow when double tapped.
                    mTextWrapScale = getReadingLevelScale();
                }
            }
            boolean reflowText = false;
            if (!viewState.mIsRestored) {
                if (settings.getUseFixedViewport()) {
                    // Override the scale only in case of fixed viewport.
                    scale = Math.max(scale, overviewScale);
                    mTextWrapScale = Math.max(mTextWrapScale, overviewScale);
                }
                reflowText = exceedsMinScaleIncrement(mTextWrapScale, scale);
            }
            mInitialZoomOverview = settings.getLoadWithOverviewMode() &&
                    !exceedsMinScaleIncrement(scale, overviewScale);
            setZoomScale(scale, reflowText);

            // update the zoom buttons as the scale can be changed
            updateZoomPicker();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.212 -0500", hash_original_method = "E88F50435C2D2101D935E91DFBA371A3", hash_generated_method = "922E438C7FEBB85E9E36CFAEB0A463F4")
    
public void saveZoomState(Bundle b) {
        b.putFloat("scale", mActualScale);
        b.putFloat("textwrapScale", mTextWrapScale);
        b.putBoolean("overview", mInZoomOverview);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.214 -0500", hash_original_method = "CEABBB6E3216B8D1034C16D61ED63443", hash_generated_method = "2FA471265CAB275B617DD3EF731AE233")
    
public void restoreZoomState(Bundle b) {
        // as getWidth() / getHeight() of the view are not available yet, set up
        // mActualScale, so that when onSizeChanged() is called, the rest will
        // be set correctly
        mActualScale = b.getFloat("scale", 1.0f);
        mInvActualScale = 1 / mActualScale;
        mTextWrapScale = b.getFloat("textwrapScale", mActualScale);
        mInZoomOverview = b.getBoolean("overview");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.217 -0500", hash_original_method = "03F547EF9A141661565AD38656124362", hash_generated_method = "7BAECD6A8B495F1B8A89BFAE4CFA4188")
    
private ZoomControlBase getCurrentZoomControl() {
        if (mWebView.getSettings() != null && mWebView.getSettings().supportZoom()) {
            if (mWebView.getSettings().getBuiltInZoomControls()) {
                if ((mEmbeddedZoomControl == null)
                        && mWebView.getSettings().getDisplayZoomControls()) {
                    mEmbeddedZoomControl = new ZoomControlEmbedded(this, mWebView);
                }
                return mEmbeddedZoomControl;
            } else {
                if (mExternalZoomControl == null) {
                    mExternalZoomControl = new ZoomControlExternal(mWebView);
                }
                return mExternalZoomControl;
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.219 -0500", hash_original_method = "BF64B2CEB07538AA62EA00039BB48680", hash_generated_method = "D9BFE51CCA1F9D1D1196C6D31623A70D")
    
public void invokeZoomPicker() {
        ZoomControlBase control = getCurrentZoomControl();
        if (control != null) {
            control.show();
        }
    }
    
    private class FocusMovementQueue {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.143 -0500", hash_original_field = "E19B63E4E45A737A04C050233EDE6F3F", hash_generated_field = "4AE12D25133F8791AD4CAFB87334ABF4")

        private static final int QUEUE_CAPACITY = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.145 -0500", hash_original_field = "F81E50F043B636ACAD3559B552E83FAF", hash_generated_field = "9639A8B64144BF72B06D4F02EACB0012")

        private float[] mQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.147 -0500", hash_original_field = "F95B05EA14A6B2F86529A0648F15118D", hash_generated_field = "5C3922C5E22E6E8A5927016DED3BACFE")

        private float mSum;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.149 -0500", hash_original_field = "205262C28D2B190751535A4911B3B259", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

        private int mSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.151 -0500", hash_original_field = "3FE793BBC68255EAC5B3588E7DE2E2C6", hash_generated_field = "B8B828CADFFAE7A5A771AAB7A1527A20")

        private int mIndex;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.154 -0500", hash_original_method = "C2CA3F4962FE0D524626245DAD0C9DD6", hash_generated_method = "C2CA3F4962FE0D524626245DAD0C9DD6")
        
FocusMovementQueue() {
            mQueue = new float[QUEUE_CAPACITY];
            mSize = 0;
            mSum = 0;
            mIndex = 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.156 -0500", hash_original_method = "7BD5EC8FD84F966DA50367EA866227AA", hash_generated_method = "5D477912809672A1747C91B1CA9D0030")
        
private void clear() {
            mSize = 0;
            mSum = 0;
            mIndex = 0;
            for (int i = 0; i < QUEUE_CAPACITY; ++i) {
                mQueue[i] = 0;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.158 -0500", hash_original_method = "BEA568413C11D502CA7CED6FD222D059", hash_generated_method = "774AC94289319B1C94B440A5471E97F1")
        
private void add(float focusDelta) {
            mSum += focusDelta;
            if (mSize < QUEUE_CAPACITY) {  // fill up the queue.
                mSize++;
            } else {  // circulate the queue.
                mSum -= mQueue[mIndex];
            }
            mQueue[mIndex] = focusDelta;
            mIndex = (mIndex + 1) % QUEUE_CAPACITY;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.161 -0500", hash_original_method = "D980EABC4C0F2D2A081289A0764FD494", hash_generated_method = "B3CAD0331A91B3C0510B9DEABC0C6468")
        
private float getSum() {
            return mSum;
        }
    }
    
    private class ScaleDetectorListener implements ScaleGestureDetector.OnScaleGestureListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.165 -0500", hash_original_field = "3B1B8AF562D750C4F3FE86E844B3F0CA", hash_generated_field = "D9620ED126995C2A7FCE1BBDF87310E8")

        private float mAccumulatedSpan;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.866 -0400", hash_original_method = "BA46F3652F41E17982BE025D7A95EDE2", hash_generated_method = "BA46F3652F41E17982BE025D7A95EDE2")
        public ScaleDetectorListener ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.168 -0500", hash_original_method = "9075B37C27A1752EF4C1C0179D09116C", hash_generated_method = "BCFF0E7F7141130D5A33440A58FA6295")
        
public boolean onScaleBegin(ScaleGestureDetector detector) {
            mInitialZoomOverview = false;
            dismissZoomPicker();
            mFocusMovementQueue.clear();
            mFocusX = detector.getFocusX();
            mFocusY = detector.getFocusY();
            mWebView.mViewManager.startZoom();
            mWebView.onPinchToZoomAnimationStart();
            mAccumulatedSpan = 0;
            return true;
        }

            // If the user moves the fingers but keeps the same distance between them,
            // we should do panning only.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.170 -0500", hash_original_method = "B0E9BE71CCDF607A4C10071A1E309D43", hash_generated_method = "5DD00A3D5F32B0165A380431D49DD005")
        
public boolean isPanningOnly(ScaleGestureDetector detector) {
            float prevFocusX = mFocusX;
            float prevFocusY = mFocusY;
            mFocusX = detector.getFocusX();
            mFocusY = detector.getFocusY();
            float focusDelta = (prevFocusX == 0 && prevFocusY == 0) ? 0 :
                    FloatMath.sqrt((mFocusX - prevFocusX) * (mFocusX - prevFocusX)
                                   + (mFocusY - prevFocusY) * (mFocusY - prevFocusY));
            mFocusMovementQueue.add(focusDelta);
            float deltaSpan = detector.getCurrentSpan() - detector.getPreviousSpan() +
                    mAccumulatedSpan;
            final boolean result = mFocusMovementQueue.getSum() > Math.abs(deltaSpan);
            if (result) {
                mAccumulatedSpan += deltaSpan;
            } else {
                mAccumulatedSpan = 0;
            }
            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.173 -0500", hash_original_method = "69F2A7AC5DBED7E3BD0F18F39CE3A7B5", hash_generated_method = "747D74A2BF8D68EF08FFFE5D8FD48D7E")
        
public boolean handleScale(ScaleGestureDetector detector) {
            float scale = detector.getScaleFactor() * mActualScale;

            // if scale is limited by any reason, don't zoom but do ask
            // the detector to update the event.
            boolean isScaleLimited =
                    isScaleOverLimits(scale) || scale < getZoomOverviewScale();

            // Prevent scaling beyond overview scale.
            scale = Math.max(computeScaleWithLimits(scale), getZoomOverviewScale());

            if (mPinchToZoomAnimating || willScaleTriggerZoom(scale)) {
                mPinchToZoomAnimating = true;
                // limit the scale change per step
                if (scale > mActualScale) {
                    scale = Math.min(scale, mActualScale * 1.25f);
                } else {
                    scale = Math.max(scale, mActualScale * 0.8f);
                }
                scale = computeScaleWithLimits(scale);
                // if the scale change is too small, regard it as jitter and skip it.
                if (Math.abs(scale - mActualScale) < MINIMUM_SCALE_WITHOUT_JITTER) {
                    return isScaleLimited;
                }
                setZoomCenter(detector.getFocusX(), detector.getFocusY());
                setZoomScale(scale, false);
                mWebView.invalidate();
                return true;
            }
            return isScaleLimited;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.176 -0500", hash_original_method = "ED0E7724FBEBB5F90A0828B68DD48F69", hash_generated_method = "1BB5D51B9218F5BBDF18FB702B9A7F36")
        
public boolean onScale(ScaleGestureDetector detector) {
            if (isPanningOnly(detector) || handleScale(detector)) {
                mFocusMovementQueue.clear();
                return true;
            }
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.179 -0500", hash_original_method = "8B2C3B6F263B86181A105DF4C3A0ECE1", hash_generated_method = "3C9BC014CEE08A8AC7C119C3FA744403")
        
public void onScaleEnd(ScaleGestureDetector detector) {
            if (mPinchToZoomAnimating) {
                mPinchToZoomAnimating = false;
                mAnchorX = mWebView.viewToContentX((int) mZoomCenterX + mWebView.getScrollX());
                mAnchorY = mWebView.viewToContentY((int) mZoomCenterY + mWebView.getScrollY());
                // don't reflow when zoom in; when zoom out, do reflow if the
                // new scale is almost minimum scale.
                boolean reflowNow = !canZoomOut() || (mActualScale <= 0.8 * mTextWrapScale);
                // force zoom after mPreviewZoomOnly is set to false so that the
                // new view size will be passed to the WebKit
                refreshZoomScale(reflowNow &&
                    !mWebView.getSettings().getUseFixedViewport());
                // call invalidate() to draw without zoom filter
                mWebView.invalidate();
            }

            mWebView.mViewManager.endZoom();
            mWebView.onPinchToZoomAnimationEnd(detector);
        }
        
    }
    
    private class PostScale implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.187 -0500", hash_original_field = "77CA9D980A43549CDA68DE3DCA6626A5", hash_generated_field = "77CA9D980A43549CDA68DE3DCA6626A5")

         boolean mUpdateTextWrap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.189 -0500", hash_original_field = "CFCDFC51582F4CFE0A0F368B7A789B49", hash_generated_field = "3E6C4A746767EEC896A2A8AB17A6F5FF")

        // it could be changed between the time this callback is initiated and
        // the time it's actually run.
         boolean mInZoomOverviewBeforeSizeChange;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.191 -0500", hash_original_field = "885926B4FFFBA16CECCAF1A99F0266F9", hash_generated_field = "885926B4FFFBA16CECCAF1A99F0266F9")

         boolean mInPortraitMode;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.194 -0500", hash_original_method = "987305C98B26834A8CB0058E5C6D93E2", hash_generated_method = "3E7379990CFABCD42FE744E50B9A458E")
        
public PostScale(boolean updateTextWrap,
                         boolean inZoomOverview,
                         boolean inPortraitMode) {
            mUpdateTextWrap = updateTextWrap;
            mInZoomOverviewBeforeSizeChange = inZoomOverview;
            mInPortraitMode = inPortraitMode;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.196 -0500", hash_original_method = "713D19A11600F821B2CA1C17235BF1BC", hash_generated_method = "A47388E94181A5862D3C23D305875B64")
        
public void run() {
            if (mWebView.getWebViewCore() != null) {
                // we always force, in case our height changed, in which case we
                // still want to send the notification over to webkit.
                // Keep overview mode unchanged when rotating.
                float newScale = mActualScale;
                if (mWebView.getSettings().getUseWideViewPort() &&
                    mInPortraitMode &&
                    mInZoomOverviewBeforeSizeChange) {
                    newScale = getZoomOverviewScale();
                }
                setZoomScale(newScale, mUpdateTextWrap, true);
                // update the zoom buttons as the scale can be changed
                updateZoomPicker();
            }
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.221 -0500", hash_original_method = "0CAEEFDB341BFD4D4CACBFA479A18F98", hash_generated_method = "ADE7BB370B33A597479F384C8DFC7848")
    
public void dismissZoomPicker() {
        ZoomControlBase control = getCurrentZoomControl();
        if (control != null) {
            control.hide();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.223 -0500", hash_original_method = "DA055704D86885A7F9C5B74974CF851B", hash_generated_method = "66E613991265D64E414D20F183FF59B2")
    
public boolean isZoomPickerVisible() {
        ZoomControlBase control = getCurrentZoomControl();
        return (control != null) ? control.isVisible() : false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.225 -0500", hash_original_method = "A8AE3510E280FF5955731B404A0A66EC", hash_generated_method = "9E3ABA20FB3E667390CEE0D1CA4B3716")
    
public void updateZoomPicker() {
        ZoomControlBase control = getCurrentZoomControl();
        if (control != null) {
            control.update();
        }
    }

    /**
     * The embedded zoom control intercepts touch events and automatically stays
     * visible. The external control needs to constantly refresh its internal
     * timer to stay visible.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.227 -0500", hash_original_method = "65E0B786CE90103F5573BC67CE254CE7", hash_generated_method = "443D77B734F979270FD63A599E4DC80F")
    
public void keepZoomPickerVisible() {
        ZoomControlBase control = getCurrentZoomControl();
        if (control != null && control == mExternalZoomControl) {
            control.show();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.230 -0500", hash_original_method = "295B8076F41B8CC3FCA3F323BF66F29B", hash_generated_method = "D7F3BEDCC9BD4305BCADD478B9647280")
    
public View getExternalZoomPicker() {
        ZoomControlBase control = getCurrentZoomControl();
        if (control != null && control == mExternalZoomControl) {
            return mExternalZoomControl.getControls();
        } else {
            return null;
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.232 -0500", hash_original_method = "8D458CBEFE5B6426DEF9072097FF3245", hash_generated_method = "AD21D2A72F8735CBBFBD61A12669EEE2")
    
public void setHardwareAccelerated() {
        mHardwareAccelerated = true;
    }

    /**
     * OnPageFinished called by webview when a page is fully loaded.
     */
    /* package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:00.234 -0500", hash_original_method = "35BF52CFA65A672FC707BA33DDD071E9", hash_generated_method = "387FC867EE6AF00187E803EFD322939F")
    
void onPageFinished(String url) {
        // Turn off initial zoom overview flag when a page is fully loaded.
        mInitialZoomOverview = false;
    }
}

