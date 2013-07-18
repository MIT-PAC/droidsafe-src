package android.webkit;

// Droidsafe Imports
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
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

class ZoomManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.796 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.796 -0400", hash_original_field = "957B64C4FA99E51BCE1B62690725D115", hash_generated_field = "62789CA10670C708EA4D387AB18C5F89")

    private CallbackProxy mCallbackProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.796 -0400", hash_original_field = "34902BF967D867A8C3F4CC4010B6E9EF", hash_generated_field = "2DA301B6F95E0EBE97AB103E0F47F9F3")

    private ZoomControlEmbedded mEmbeddedZoomControl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.796 -0400", hash_original_field = "3E28AE1D93462FA1E7D90F056B0F6E1D", hash_generated_field = "E1828D795EA501C93F7B7AE52E32EC0D")

    private ZoomControlExternal mExternalZoomControl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.796 -0400", hash_original_field = "62F3D783B3687CBC0BDB448D90E58278", hash_generated_field = "A75525F777409EAE64A30A85B5ECCBE1")

    private float mDefaultMaxZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.796 -0400", hash_original_field = "8B4997D60CFE283F65068FB0529E4498", hash_generated_field = "52C961320D37FAE0F1AE675CFD1F2BEC")

    private float mDefaultMinZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.796 -0400", hash_original_field = "B473A45F09A23AD2B870CF185D4AA12A", hash_generated_field = "49153CC81AC659E75C57042122CE79CA")

    private float mMaxZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.797 -0400", hash_original_field = "DA19E9676D629B1D45B511C2C1DBDFAB", hash_generated_field = "62544A60744E4E06A4BB732A37B9A75D")

    private float mMinZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.797 -0400", hash_original_field = "49ED4F15B76F494F60E56C2FAEDC5E89", hash_generated_field = "0045D4254134E122CD3AF4AD2A34AE42")

    private boolean mMinZoomScaleFixed = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.797 -0400", hash_original_field = "C5AEF7F4CDDDA63B17EDCA58C1930701", hash_generated_field = "0ED10F26046E2B869A9993F37463D665")

    private boolean mInitialZoomOverview = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.797 -0400", hash_original_field = "998C898FF1863528EFFAB397B8821943", hash_generated_field = "D1063DF321563D8E711FE2915CC13ED6")

    private boolean mInZoomOverview = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.797 -0400", hash_original_field = "13DBB97D624EFD6C45C1709D4D77E1AC", hash_generated_field = "EEF381E8DFAB0F8AFA6DED39CA509D69")

    private int mZoomOverviewWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.797 -0400", hash_original_field = "77077C98D8D725F541F44258326BEA3C", hash_generated_field = "789EB22FC445F5CF4578A1B705BCFD89")

    private float mInvZoomOverviewWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.797 -0400", hash_original_field = "57681D2E7F65B2999AC6DB0157119FFE", hash_generated_field = "73D88F8A1B8C24D1E753BDF66C353FE4")

    private float mZoomCenterX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.797 -0400", hash_original_field = "7BA53A17CCE52B938AB36A19D2D5212D", hash_generated_field = "0905DF24D370C5BABA5C5316D621064E")

    private float mZoomCenterY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.797 -0400", hash_original_field = "A0FE7B7E6572E9A5C03F808D583D21EF", hash_generated_field = "9E3ECCCE67853EF67D401BC85D54FCDD")

    private float mFocusX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.797 -0400", hash_original_field = "E371837A8119A3AB321FC558BC169293", hash_generated_field = "E01C42CAE2152A2827127C5E1618E0BF")

    private float mFocusY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.797 -0400", hash_original_field = "87008528F20CC5552B26DB443AC74F67", hash_generated_field = "7AE666B3B95EE2A25725DEE0E0FF8D16")

    private FocusMovementQueue mFocusMovementQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.797 -0400", hash_original_field = "E7657EDDA986C0D1CC052B8F112FE09D", hash_generated_field = "5F8E058F09826A27700241950A47C51E")

    private int mAnchorX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.797 -0400", hash_original_field = "87FAE44598E10061776ABA72BF200D70", hash_generated_field = "D3B700F3BB8B795E0ADFEB729C0AE646")

    private int mAnchorY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.797 -0400", hash_original_field = "3190B9F88CD9ECBDD0CF99CE8D1E0B89", hash_generated_field = "1B5C7663299982C5C7D3FB1CDE2DE612")

    private float mTextWrapScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.797 -0400", hash_original_field = "F3150A42E04B25673AB01D2C041638C1", hash_generated_field = "2F8E15D8BE82ACCE0EB0157530F26BA2")

    private float mDefaultScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.797 -0400", hash_original_field = "F76A5E4401A0723AA5E56C29FBB9CF15", hash_generated_field = "403E94F468B3BDF8320A5058252C64CF")

    private float mInvDefaultScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.797 -0400", hash_original_field = "5CDFBEECE4C65AB1FD80F336D826A9B3", hash_generated_field = "6380DD00339CD0A77C6B25CB19413BC5")

    private float mDisplayDensity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.798 -0400", hash_original_field = "25E6113202D6CFE1096DA97DA85A393C", hash_generated_field = "35F9B21E3F5F564C990231A1E5CD959C")

    private float mDoubleTapZoomFactor = 1.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.798 -0400", hash_original_field = "2BD1064E1316AB3431CD233A2DB36D76", hash_generated_field = "EC2D05F087E31D17947841E32358DEC1")

    private float mActualScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.798 -0400", hash_original_field = "E3D71FEA20B9D8C04A31631606259011", hash_generated_field = "C3F4C4AE5E1BA7A43BA1DC26150BBCED")

    private float mInvActualScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.798 -0400", hash_original_field = "1D77D2432E524838ACFF4200A870280D", hash_generated_field = "86487DADE4014C689CAFFA37B4818AF4")

    private float mInitialScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.798 -0400", hash_original_field = "9D28FB72937787644389F529B4276C55", hash_generated_field = "D8F7937535B71ED52FE04BF51381C2E3")

    private float mZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.798 -0400", hash_original_field = "F5674EF1AB117AA2DB1AAA75A63E4275", hash_generated_field = "DFE1ED1EDAC53623D5358E45BF3F4EBD")

    private float mInvInitialZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.798 -0400", hash_original_field = "F0D6ED4FFDAF5496002ADD1B08B462FE", hash_generated_field = "424DF48095CC98F0B236E854F4E43A2D")

    private float mInvFinalZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.798 -0400", hash_original_field = "A2854BA31136A2F81EC6577AEBE1E664", hash_generated_field = "B116C55D4B4D66EE153F454CBA568BE6")

    private int mInitialScrollX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.798 -0400", hash_original_field = "557FEBE80E5593717A34985067D77EF0", hash_generated_field = "E57D614FBFE0B9BAA23984CC3E7AD606")

    private int mInitialScrollY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.798 -0400", hash_original_field = "FD4D0FB807AF66279DB4B8659BAA63C5", hash_generated_field = "CCF37C49798D869F18D246B6747FFF61")

    private long mZoomStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.798 -0400", hash_original_field = "5C62F021E531A91F9743205810E9E171", hash_generated_field = "17F95B8381C48D81ED3F070ABC618EA0")

    private boolean mSupportMultiTouch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.798 -0400", hash_original_field = "C0A50D2FDF7098353277E4B1046F8BCE", hash_generated_field = "9B444A6905DBFA8226D34C0732D3C33C")

    private boolean mAllowPanAndScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.798 -0400", hash_original_field = "A0F3C25877DFCDC03E45221E32A4656A", hash_generated_field = "0C270CE12B813847261F32665B4317E0")

    private ScaleGestureDetector mScaleDetector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.798 -0400", hash_original_field = "65635DB64810CB34B0C3240333C5CD95", hash_generated_field = "45DDE0467059E4D71CD5528DE7734AFC")

    private boolean mPinchToZoomAnimating = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.798 -0400", hash_original_field = "94CB263926656D6FE605610741F6C504", hash_generated_field = "80FDB96634A8A83890141751180EF1B9")

    private boolean mHardwareAccelerated = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.798 -0400", hash_original_field = "502FB9866E2BA595DDCE2A31361DD0CD", hash_generated_field = "F44E8E20A0C3B070FDDA9A2AECAA2700")

    private boolean mInHWAcceleratedZoom = false;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.799 -0400", hash_original_method = "C53EE2007D9BEC2FE01EA607CD54C4FF", hash_generated_method = "0190DB67F1A6601D594EAB9FDB61EC8B")
    public  ZoomManager(WebView webView, CallbackProxy callbackProxy) {
        mWebView = webView;
        mCallbackProxy = callbackProxy;
        setZoomOverviewWidth(WebView.DEFAULT_VIEWPORT_WIDTH);
        mFocusMovementQueue = new FocusMovementQueue();
        // ---------- Original Method ----------
        //mWebView = webView;
        //mCallbackProxy = callbackProxy;
        //setZoomOverviewWidth(WebView.DEFAULT_VIEWPORT_WIDTH);
        //mFocusMovementQueue = new FocusMovementQueue();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.801 -0400", hash_original_method = "93CFAAB8556EE96135ADFFE4D2689C29", hash_generated_method = "BAE942C36681C49C4BCAA7C766AB89E9")
    public void init(float density) {
        mDisplayDensity = density;
        setDefaultZoomScale(density);
        mActualScale = density;
        mInvActualScale = 1 / density;
        mTextWrapScale = getReadingLevelScale();
        // ---------- Original Method ----------
        //assert density > 0;
        //mDisplayDensity = density;
        //setDefaultZoomScale(density);
        //mActualScale = density;
        //mInvActualScale = 1 / density;
        //mTextWrapScale = getReadingLevelScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.801 -0400", hash_original_method = "2EFEEBFBDE6ACF8543350ABFFB008A8F", hash_generated_method = "A64373EB5CABF6E6FF174BBD666B2871")
    public void updateDefaultZoomDensity(float density) {
        addTaint(density);
        if(Math.abs(density - mDefaultScale) > MINIMUM_SCALE_INCREMENT)        
        {
            final float originalDefault = mDefaultScale;
            setDefaultZoomScale(density);
            float scaleChange = (originalDefault > 0.0) ? density / originalDefault: 1.0f;
            setZoomScale(mActualScale * scaleChange, true);
        } //End block
        // ---------- Original Method ----------
        //assert density > 0;
        //if (Math.abs(density - mDefaultScale) > MINIMUM_SCALE_INCREMENT) {
            //final float originalDefault = mDefaultScale;
            //setDefaultZoomScale(density);
            //float scaleChange = (originalDefault > 0.0) ? density / originalDefault: 1.0f;
            //setZoomScale(mActualScale * scaleChange, true);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.803 -0400", hash_original_method = "E8BCC867B6D8CCFABF539A9D95032C95", hash_generated_method = "044CA3F35DF3912DC2557C65DFC8C381")
    private void setDefaultZoomScale(float defaultScale) {
        final float originalDefault = mDefaultScale;
        mDefaultScale = defaultScale;
        mInvDefaultScale = 1 / defaultScale;
        mDefaultMaxZoomScale = defaultScale * DEFAULT_MAX_ZOOM_SCALE_FACTOR;
        mDefaultMinZoomScale = defaultScale * DEFAULT_MIN_ZOOM_SCALE_FACTOR;
        if(originalDefault > 0.0 && mMaxZoomScale > 0.0)        
        {
            mMaxZoomScale = defaultScale / originalDefault * mMaxZoomScale;
        } //End block
        else
        {
            mMaxZoomScale = mDefaultMaxZoomScale;
        } //End block
        if(originalDefault > 0.0 && mMinZoomScale > 0.0)        
        {
            mMinZoomScale = defaultScale / originalDefault * mMinZoomScale;
        } //End block
        else
        {
            mMinZoomScale = mDefaultMinZoomScale;
        } //End block
        if(!exceedsMinScaleIncrement(mMinZoomScale, mMaxZoomScale))        
        {
            mMaxZoomScale = mMinZoomScale;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.804 -0400", hash_original_method = "E0A7D63CBE7BA22AE5FD1D2BCFACA30A", hash_generated_method = "CC766343729A1A152EFB821927E4C4BD")
    public final float getScale() {
        float var2BD1064E1316AB3431CD233A2DB36D76_1036991117 = (mActualScale);
                float var546ADE640B6EDFBC8A086EF31347E768_658916402 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_658916402;
        // ---------- Original Method ----------
        //return mActualScale;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.804 -0400", hash_original_method = "27B2B7D16269E37341CA9CE429E50BD4", hash_generated_method = "6BEAF197A189DAE8FB762633BAED5CD4")
    public final float getInvScale() {
        float varE3D71FEA20B9D8C04A31631606259011_1509927475 = (mInvActualScale);
                float var546ADE640B6EDFBC8A086EF31347E768_589733124 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_589733124;
        // ---------- Original Method ----------
        //return mInvActualScale;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.804 -0400", hash_original_method = "420B51415ADFBA4739EC66A8F732263C", hash_generated_method = "08B05E20B8B3A49C0F66264CE6AAD601")
    public final float getTextWrapScale() {
        float var3190B9F88CD9ECBDD0CF99CE8D1E0B89_276921907 = (mTextWrapScale);
                float var546ADE640B6EDFBC8A086EF31347E768_1632934092 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1632934092;
        // ---------- Original Method ----------
        //return mTextWrapScale;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.804 -0400", hash_original_method = "4D84680032231769C697659C881951E3", hash_generated_method = "9099E3F9FCDFCDE957D4D60D5583AA19")
    public final float getMaxZoomScale() {
        float varB473A45F09A23AD2B870CF185D4AA12A_4389371 = (mMaxZoomScale);
                float var546ADE640B6EDFBC8A086EF31347E768_1623827898 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1623827898;
        // ---------- Original Method ----------
        //return mMaxZoomScale;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.804 -0400", hash_original_method = "EF101FB82D6E625D2F7286BB14442128", hash_generated_method = "57505C47A921C32C3E572DD384021AF2")
    public final float getMinZoomScale() {
        float varDA19E9676D629B1D45B511C2C1DBDFAB_2030032766 = (mMinZoomScale);
                float var546ADE640B6EDFBC8A086EF31347E768_1944328085 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1944328085;
        // ---------- Original Method ----------
        //return mMinZoomScale;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.805 -0400", hash_original_method = "C9287BA17A965D05EE45D11D20F2D047", hash_generated_method = "5A0025BDED2C2EF06798BB11CD594729")
    public final float getDefaultScale() {
        float varF3150A42E04B25673AB01D2C041638C1_323518478 = (mDefaultScale);
                float var546ADE640B6EDFBC8A086EF31347E768_1831047571 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1831047571;
        // ---------- Original Method ----------
        //return mDefaultScale;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.805 -0400", hash_original_method = "B68BBC34F3F5ADBA444AF11F55B159F2", hash_generated_method = "F5B9AA75C0441BA400853758C1F10D42")
    public final float getReadingLevelScale() {
        float var1348B6DE8A70A948B2FED42EC3421B20_805781125 = (mDisplayDensity * mDoubleTapZoomFactor);
                float var546ADE640B6EDFBC8A086EF31347E768_1124637595 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1124637595;
        // ---------- Original Method ----------
        //return mDisplayDensity * mDoubleTapZoomFactor;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.805 -0400", hash_original_method = "150923628532607A08D5A6F81E7006FE", hash_generated_method = "C172C838A67AFB1E3F616936D88B7F27")
    public final float getInvDefaultScale() {
        float varF76A5E4401A0723AA5E56C29FBB9CF15_2091577953 = (mInvDefaultScale);
                float var546ADE640B6EDFBC8A086EF31347E768_2030480010 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2030480010;
        // ---------- Original Method ----------
        //return mInvDefaultScale;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.806 -0400", hash_original_method = "86C1C61E20B5F864D06602058822F40B", hash_generated_method = "30D1A003D4CE5E2B0EF68F3078C45850")
    public final float getDefaultMaxZoomScale() {
        float var62F3D783B3687CBC0BDB448D90E58278_1991410493 = (mDefaultMaxZoomScale);
                float var546ADE640B6EDFBC8A086EF31347E768_1299578639 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1299578639;
        // ---------- Original Method ----------
        //return mDefaultMaxZoomScale;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.806 -0400", hash_original_method = "68697F997D536A00F27515B45D68169D", hash_generated_method = "702E64F2D9303470E40B700321779FFD")
    public final float getDefaultMinZoomScale() {
        float var8B4997D60CFE283F65068FB0529E4498_2025967207 = (mDefaultMinZoomScale);
                float var546ADE640B6EDFBC8A086EF31347E768_1318977625 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1318977625;
        // ---------- Original Method ----------
        //return mDefaultMinZoomScale;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.806 -0400", hash_original_method = "0D1E90BA2B32E85CA9E1B47821E3129C", hash_generated_method = "A13176132D441A9E33FA75DBAA6D32C4")
    public final int getDocumentAnchorX() {
        int varE7657EDDA986C0D1CC052B8F112FE09D_493612280 = (mAnchorX);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1558974437 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1558974437;
        // ---------- Original Method ----------
        //return mAnchorX;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.807 -0400", hash_original_method = "6F8EAB28E274BDE9903F29B52FA3CE08", hash_generated_method = "04D9C5B2E47A0403D71DF957659FC88D")
    public final int getDocumentAnchorY() {
        int var87FAE44598E10061776ABA72BF200D70_2104276258 = (mAnchorY);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2125458119 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2125458119;
        // ---------- Original Method ----------
        //return mAnchorY;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.807 -0400", hash_original_method = "37EC19EE8D577B9FFE8E8612EB136E0D", hash_generated_method = "0979E863D08CE670AE5057D10C3B3325")
    public final void clearDocumentAnchor() {
        mAnchorX = mAnchorY = 0;
        // ---------- Original Method ----------
        //mAnchorX = mAnchorY = 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.807 -0400", hash_original_method = "B42B83C0DB8155DA229557A2BD45C477", hash_generated_method = "376A60C9AA8D31A1B7B25334BE2AA077")
    public final void setZoomCenter(float x, float y) {
        mZoomCenterX = x;
        mZoomCenterY = y;
        // ---------- Original Method ----------
        //mZoomCenterX = x;
        //mZoomCenterY = y;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.808 -0400", hash_original_method = "E17C2AED3C2D9DCFE2D098E038948EA1", hash_generated_method = "C3C51A8EAC82BA7545BE75E4A35DC3DA")
    public final void setInitialScaleInPercent(int scaleInPercent) {
        mInitialScale = scaleInPercent * 0.01f;
        // ---------- Original Method ----------
        //mInitialScale = scaleInPercent * 0.01f;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.808 -0400", hash_original_method = "CACC1DB3C5C8FBE689456F981994723C", hash_generated_method = "CE7DFA9A18A2B4E0D4DA2707B4C6F21D")
    public final float computeScaleWithLimits(float scale) {
        addTaint(scale);
        if(scale < mMinZoomScale)        
        {
            scale = mMinZoomScale;
        } //End block
        else
        if(scale > mMaxZoomScale)        
        {
            scale = mMaxZoomScale;
        } //End block
        float var0CB47AEB6E5F9323F0969E628C4E59F5_540558089 = (scale);
                float var546ADE640B6EDFBC8A086EF31347E768_604523986 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_604523986;
        // ---------- Original Method ----------
        //if (scale < mMinZoomScale) {
            //scale = mMinZoomScale;
        //} else if (scale > mMaxZoomScale) {
            //scale = mMaxZoomScale;
        //}
        //return scale;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.808 -0400", hash_original_method = "49E88837FC0437D5B36C3DDB131811B0", hash_generated_method = "58CE5BCA6C17B017CA5CD9131854FFFB")
    public final boolean isScaleOverLimits(float scale) {
        addTaint(scale);
        boolean var21186027870489129E2BB90CED7D2407_2113806982 = (scale <= mMinZoomScale || scale >= mMaxZoomScale);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1356145826 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1356145826;
        // ---------- Original Method ----------
        //return scale <= mMinZoomScale || scale >= mMaxZoomScale;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.808 -0400", hash_original_method = "EAE2E4FAF7045B63798AAD0EC191C138", hash_generated_method = "8043943DAC8EE5245F8F481D09296D5C")
    public final boolean isZoomScaleFixed() {
        boolean var7AD980BD697FA45BDF49A42A65743B26_247242054 = (mMinZoomScale >= mMaxZoomScale);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_547992523 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_547992523;
        // ---------- Original Method ----------
        //return mMinZoomScale >= mMaxZoomScale;
    }

    
    @DSModeled(DSC.SAFE)
    public static final boolean exceedsMinScaleIncrement(float scaleA, float scaleB) {
        return Math.abs(scaleA - scaleB) >= MINIMUM_SCALE_INCREMENT;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.808 -0400", hash_original_method = "73353D5825B74E55208D73C06ED7146E", hash_generated_method = "2259B9F3BB91953483FEB5CC52A6178E")
    public boolean willScaleTriggerZoom(float scale) {
        addTaint(scale);
        boolean var4B082444BC85E7CDD2767F6CEABE60A6_2140914321 = (exceedsMinScaleIncrement(scale, mActualScale));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1151725283 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1151725283;
        // ---------- Original Method ----------
        //return exceedsMinScaleIncrement(scale, mActualScale);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.808 -0400", hash_original_method = "577BAEA37EC580D2471F28E52ACC3E90", hash_generated_method = "69AF9869A75130EAB6B82628B15FD066")
    public final boolean canZoomIn() {
        boolean var3040F56E7060A9E79DFD9F8E4BFB4A87_776511615 = (mMaxZoomScale - mActualScale > MINIMUM_SCALE_INCREMENT);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1132353627 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1132353627;
        // ---------- Original Method ----------
        //return mMaxZoomScale - mActualScale > MINIMUM_SCALE_INCREMENT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.808 -0400", hash_original_method = "82D91A91E65D0066AFB31608B5056133", hash_generated_method = "4F341F65DC08A0251C7AA11B5DD2352B")
    public final boolean canZoomOut() {
        boolean var05A476B88AE9D08CE3524EF37DD6C9E0_405214456 = (mActualScale - mMinZoomScale > MINIMUM_SCALE_INCREMENT);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1252076171 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1252076171;
        // ---------- Original Method ----------
        //return mActualScale - mMinZoomScale > MINIMUM_SCALE_INCREMENT;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.808 -0400", hash_original_method = "1087ACA9FDE3F82506A02D8DB9B3B812", hash_generated_method = "A46BF32D0B6886FC5267F5BFEAA24BEE")
    public boolean zoomIn() {
        boolean varC96C7B9B7FAF53A62021D1FACD428BDF_1105785458 = (zoom(1.25f));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1499350862 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1499350862;
        // ---------- Original Method ----------
        //return zoom(1.25f);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.809 -0400", hash_original_method = "AF303514C2CE6EE62014ED1CD988BE8F", hash_generated_method = "75F590DAD66A224E177EC7950C0DD121")
    public boolean zoomOut() {
        boolean varE40290D775ABE277408E6DFF69232814_2139300083 = (zoom(0.8f));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_815752358 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_815752358;
        // ---------- Original Method ----------
        //return zoom(0.8f);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.809 -0400", hash_original_method = "0D06D835317E38A4890F08EB962517B9", hash_generated_method = "4903C185EE067BC34ABF943FED968BA3")
    private boolean zoom(float zoomMultiplier) {
        addTaint(zoomMultiplier);
        mInitialZoomOverview = false;
        mWebView.switchOutDrawHistory();
        mZoomCenterX = mWebView.getViewWidth() * .5f;
        mZoomCenterY = mWebView.getViewHeight() * .5f;
        mAnchorX = mWebView.viewToContentX((int) mZoomCenterX + mWebView.getScrollX());
        mAnchorY = mWebView.viewToContentY((int) mZoomCenterY + mWebView.getScrollY());
        boolean var7F063624ABE1C39EB42EDDDA78626BD0_93777141 = (startZoomAnimation(mActualScale * zoomMultiplier, 
            !mWebView.getSettings().getUseFixedViewport()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1028904868 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1028904868;
        // ---------- Original Method ----------
        //mInitialZoomOverview = false;
        //mWebView.switchOutDrawHistory();
        //mZoomCenterX = mWebView.getViewWidth() * .5f;
        //mZoomCenterY = mWebView.getViewHeight() * .5f;
        //mAnchorX = mWebView.viewToContentX((int) mZoomCenterX + mWebView.getScrollX());
        //mAnchorY = mWebView.viewToContentY((int) mZoomCenterY + mWebView.getScrollY());
        //return startZoomAnimation(mActualScale * zoomMultiplier, 
            //!mWebView.getSettings().getUseFixedViewport());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.855 -0400", hash_original_method = "ABA8C6E97A9C369182835D6347EB12CF", hash_generated_method = "88B5ECFD498C4DC4E5A5FAACE3F42F8E")
    public boolean startZoomAnimation(float scale, boolean reflowText) {
        addTaint(reflowText);
        addTaint(scale);
        mInitialZoomOverview = false;
        float oldScale = mActualScale;
        mInitialScrollX = mWebView.getScrollX();
        mInitialScrollY = mWebView.getScrollY();
        if(!exceedsMinScaleIncrement(scale, getReadingLevelScale()))        
        {
            scale = getReadingLevelScale();
        } //End block
        if(mHardwareAccelerated)        
        {
            mInHWAcceleratedZoom = true;
        } //End block
        setZoomScale(scale, reflowText);
        if(oldScale != mActualScale)        
        {
            mZoomStart = SystemClock.uptimeMillis();
            mInvInitialZoomScale = 1.0f / oldScale;
            mInvFinalZoomScale = 1.0f / mActualScale;
            mZoomScale = mActualScale;
            mWebView.onFixedLengthZoomAnimationStart();
            mWebView.invalidate();
            boolean varB326B5062B2F0E69046810717534CB09_1749748798 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1361462091 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1361462091;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1520542392 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_319415969 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_319415969;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.856 -0400", hash_original_method = "4B2E3C5C63E13C95ACA7AA346AD0833D", hash_generated_method = "FF74CAFE48138CD77AC4A34421206BF3")
    public void animateZoom(Canvas canvas) {
        addTaint(canvas.getTaint());
        mInitialZoomOverview = false;
        if(mZoomScale == 0)        
        {
            return;
        } //End block
        float zoomScale;
        int interval = (int) (SystemClock.uptimeMillis() - mZoomStart);
        if(interval < ZOOM_ANIMATION_LENGTH)        
        {
            float ratio = (float) interval / ZOOM_ANIMATION_LENGTH;
            zoomScale = 1.0f / (mInvInitialZoomScale
                    + (mInvFinalZoomScale - mInvInitialZoomScale) * ratio);
            mWebView.invalidate();
        } //End block
        else
        {
            zoomScale = mZoomScale;
            mZoomScale = 0;
            mWebView.onFixedLengthZoomAnimationEnd();
        } //End block
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
        if(mHardwareAccelerated)        
        {
            mWebView.updateScrollCoordinates(mWebView.getScrollX() - tx, mWebView.getScrollY() - ty);
            canvas.translate(tx, ty);
            setZoomScale(zoomScale, false);
            if(mZoomScale == 0)            
            {
                mInHWAcceleratedZoom = false;
                mWebView.sendViewSizeZoom(false);
            } //End block
        } //End block
        else
        {
            canvas.translate(tx, ty);
            canvas.scale(zoomScale, zoomScale);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.856 -0400", hash_original_method = "E0C5EE754D896EBEA19BF99FCF86359E", hash_generated_method = "B6340481F4C98F5EB64F707553E2CF6B")
    public boolean isZoomAnimating() {
        boolean var20C287154B59DDE014F3FA6F32CC216A_654031658 = (isFixedLengthAnimationInProgress() || mPinchToZoomAnimating);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_577822472 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_577822472;
        // ---------- Original Method ----------
        //return isFixedLengthAnimationInProgress() || mPinchToZoomAnimating;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.856 -0400", hash_original_method = "351373D4552618F4F14C898A250D84BD", hash_generated_method = "F41F1592DAE20BC56CEB84CFC090A738")
    public boolean isFixedLengthAnimationInProgress() {
        boolean varF358CE6735E2A71C9FC27D3E9180D57D_1299873510 = (mZoomScale != 0 || mInHWAcceleratedZoom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_47679533 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_47679533;
        // ---------- Original Method ----------
        //return mZoomScale != 0 || mInHWAcceleratedZoom;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.856 -0400", hash_original_method = "38BADAFCA13DD410DF65C206538CBBC7", hash_generated_method = "E35B9613CE082137AEF54D573206DF66")
    public void updateDoubleTapZoom(int doubleTapZoom) {
        boolean zoomIn = (mTextWrapScale - mActualScale) < .1f;
        mDoubleTapZoomFactor = doubleTapZoom / 100.0f;
        mTextWrapScale = getReadingLevelScale();
        float newScale = zoomIn ? mTextWrapScale
                : Math.min(mTextWrapScale, mActualScale);
        setZoomScale(newScale, true, true);
        // ---------- Original Method ----------
        //boolean zoomIn = (mTextWrapScale - mActualScale) < .1f;
        //mDoubleTapZoomFactor = doubleTapZoom / 100.0f;
        //mTextWrapScale = getReadingLevelScale();
        //float newScale = zoomIn ? mTextWrapScale
                //: Math.min(mTextWrapScale, mActualScale);
        //setZoomScale(newScale, true, true);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.856 -0400", hash_original_method = "D0144FE074B01386F16EF11E861F0A7A", hash_generated_method = "4E610831276BD997A7712312AC7F5DEE")
    public void refreshZoomScale(boolean reflowText) {
        addTaint(reflowText);
        setZoomScale(mActualScale, reflowText, true);
        // ---------- Original Method ----------
        //setZoomScale(mActualScale, reflowText, true);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.857 -0400", hash_original_method = "0CAC496E58068B9E4E1CC3313C83A17E", hash_generated_method = "D14BD128BEDBE21D008DD99F6F28272E")
    public void setZoomScale(float scale, boolean reflowText) {
        addTaint(reflowText);
        addTaint(scale);
        setZoomScale(scale, reflowText, false);
        // ---------- Original Method ----------
        //setZoomScale(scale, reflowText, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.857 -0400", hash_original_method = "3A85AAAB95D1CDF586170EB3BBF2667E", hash_generated_method = "F9A79B4E7FC1A0C1E09151237D62ED60")
    private void setZoomScale(float scale, boolean reflowText, boolean force) {
        addTaint(force);
        addTaint(reflowText);
        final boolean isScaleLessThanMinZoom = scale < mMinZoomScale;
        scale = computeScaleWithLimits(scale);
        if(isScaleLessThanMinZoom && mMinZoomScale < mDefaultScale)        
        {
            mInZoomOverview = true;
        } //End block
        else
        {
            mInZoomOverview = !exceedsMinScaleIncrement(scale, getZoomOverviewScale());
        } //End block
        if(reflowText && !mWebView.getSettings().getUseFixedViewport())        
        {
            mTextWrapScale = scale;
        } //End block
        if(scale != mActualScale || force)        
        {
            float oldScale = mActualScale;
            float oldInvScale = mInvActualScale;
            if(scale != mActualScale && !mPinchToZoomAnimating)            
            {
                mCallbackProxy.onScaleChanged(mActualScale, scale);
            } //End block
            mActualScale = scale;
            mInvActualScale = 1 / scale;
            if(!mWebView.drawHistory() && !mInHWAcceleratedZoom)            
            {
                int oldX = mWebView.getScrollX();
                int oldY = mWebView.getScrollY();
                float ratio = scale * oldInvScale;
                float sx = ratio * oldX + (ratio - 1) * mZoomCenterX;
                float sy = ratio * oldY + (ratio - 1)
                        * (mZoomCenterY - mWebView.getTitleHeight());
                mWebView.mViewManager.scaleAll();
                int scrollX = mWebView.pinLocX(Math.round(sx));
                int scrollY = mWebView.pinLocY(Math.round(sy));
                if(!mWebView.updateScrollCoordinates(scrollX, scrollY))                
                {
                    mWebView.sendOurVisibleRect();
                } //End block
            } //End block
            mWebView.sendViewSizeZoom(reflowText);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.857 -0400", hash_original_method = "6C9BE8F81CD8D5D51E25813EE62B3846", hash_generated_method = "7DAAD7779E7005ED43B16F9C0DE803E5")
    public boolean isDoubleTapEnabled() {
        WebSettings settings = mWebView.getSettings();
        boolean varACBE5FD0A7991EC90CDBBA348CE5ABCE_1212112084 = (settings != null && settings.getUseWideViewPort());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_74260217 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_74260217;
        // ---------- Original Method ----------
        //WebSettings settings = mWebView.getSettings();
        //return settings != null && settings.getUseWideViewPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.858 -0400", hash_original_method = "4C79B03AF1323FEB3700FE89F15D8B06", hash_generated_method = "0B2172D526770A60B2BEABE6F53974FB")
    public void handleDoubleTap(float lastTouchX, float lastTouchY) {
        mInitialZoomOverview = false;
        WebSettings settings = mWebView.getSettings();
        if(!isDoubleTapEnabled())        
        {
            return;
        } //End block
        setZoomCenter(lastTouchX, lastTouchY);
        mAnchorX = mWebView.viewToContentX((int) lastTouchX + mWebView.getScrollX());
        mAnchorY = mWebView.viewToContentY((int) lastTouchY + mWebView.getScrollY());
        settings.setDoubleTapToastCount(0);
        dismissZoomPicker();
        Rect pluginBounds = mWebView.getPluginBounds(mAnchorX, mAnchorY);
        if(pluginBounds != null)        
        {
            if(mWebView.isRectFitOnScreen(pluginBounds))            
            {
                zoomToOverview();
            } //End block
            else
            {
                mWebView.centerFitRect(pluginBounds);
            } //End block
            return;
        } //End block
        float newTextWrapScale;
        if(settings.getUseFixedViewport())        
        {
            newTextWrapScale = Math.max(mActualScale, getReadingLevelScale());
        } //End block
        else
        {
            newTextWrapScale = mActualScale;
        } //End block
        final boolean firstTimeReflow = !exceedsMinScaleIncrement(mActualScale, mTextWrapScale);
        if(firstTimeReflow || mInZoomOverview)        
        {
            mTextWrapScale = newTextWrapScale;
        } //End block
        if(settings.isNarrowColumnLayout()
                && exceedsMinScaleIncrement(mTextWrapScale, newTextWrapScale)
                && !firstTimeReflow
                && !mInZoomOverview)        
        {
            mTextWrapScale = newTextWrapScale;
            refreshZoomScale(true);
        } //End block
        else
        if(!mInZoomOverview && willScaleTriggerZoom(getZoomOverviewScale()))        
        {
            if(mTextWrapScale > getReadingLevelScale())            
            {
                mTextWrapScale = getReadingLevelScale();
                refreshZoomScale(true);
            } //End block
            zoomToOverview();
        } //End block
        else
        {
            zoomToReadingLevelOrMore();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.858 -0400", hash_original_method = "712C22BAE7AA3B12B6A5A40165B58905", hash_generated_method = "80A23724A250B952CF0FD5DE028ACB94")
    private void setZoomOverviewWidth(int width) {
        if(width == 0)        
        {
            mZoomOverviewWidth = WebView.DEFAULT_VIEWPORT_WIDTH;
        } //End block
        else
        {
            mZoomOverviewWidth = width;
        } //End block
        mInvZoomOverviewWidth = 1.0f / width;
        // ---------- Original Method ----------
        //if (width == 0) {
            //mZoomOverviewWidth = WebView.DEFAULT_VIEWPORT_WIDTH;
        //} else {
            //mZoomOverviewWidth = width;
        //}
        //mInvZoomOverviewWidth = 1.0f / width;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.858 -0400", hash_original_method = "B42D229ABB1FC24C49B118C5D42DFED9", hash_generated_method = "D11EA4E65B75D9FE3C092A36C797B88C")
     float getZoomOverviewScale() {
        float var60A8AB28A2195A459EDCFBAE60FABE3D_1915012967 = (mWebView.getViewWidth() * mInvZoomOverviewWidth);
                float var546ADE640B6EDFBC8A086EF31347E768_1301997598 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1301997598;
        // ---------- Original Method ----------
        //return mWebView.getViewWidth() * mInvZoomOverviewWidth;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.858 -0400", hash_original_method = "C49CAD609BC6A273DA434DC912742003", hash_generated_method = "5BF262C6C7E89E179C56068E01627ED0")
    public boolean isInZoomOverview() {
        boolean var7744930A12D21C1DE605C74E0B045D64_1743699768 = (mInZoomOverview);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1796278696 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1796278696;
        // ---------- Original Method ----------
        //return mInZoomOverview;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.859 -0400", hash_original_method = "C0C0965039A172A5A5AAF6C9C4472D2A", hash_generated_method = "A0DAFE5222C9D5EDCF485B535A45DA26")
    private void zoomToOverview() {
        int scrollY = mWebView.getScrollY();
        if(scrollY < mWebView.getTitleHeight())        
        {
            mWebView.updateScrollCoordinates(mWebView.getScrollX(), 0);
        } //End block
        startZoomAnimation(getZoomOverviewScale(), 
            !mWebView.getSettings().getUseFixedViewport());
        // ---------- Original Method ----------
        //int scrollY = mWebView.getScrollY();
        //if (scrollY < mWebView.getTitleHeight()) {
            //mWebView.updateScrollCoordinates(mWebView.getScrollX(), 0);
        //}
        //startZoomAnimation(getZoomOverviewScale(), 
            //!mWebView.getSettings().getUseFixedViewport());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.859 -0400", hash_original_method = "6051F287C8BD349D628462D7AA7CF8A8", hash_generated_method = "99FAD3E4D224A52901A21B3F6D1C82E2")
    private void zoomToReadingLevelOrMore() {
        final float zoomScale = Math.max(getReadingLevelScale(),
                mActualScale + MIN_DOUBLE_TAP_SCALE_INCREMENT);
        int left = mWebView.nativeGetBlockLeftEdge(mAnchorX, mAnchorY, mActualScale);
        if(left != WebView.NO_LEFTEDGE)        
        {
            int viewLeft = mWebView.contentToViewX(left < 5 ? 0 : (left - 5))
                    - mWebView.getScrollX();
            if(viewLeft > 0)            
            {
                mZoomCenterX = viewLeft * zoomScale / (zoomScale - mActualScale);
            } //End block
            else
            {
                mWebView.scrollBy(viewLeft, 0);
                mZoomCenterX = 0;
            } //End block
        } //End block
        startZoomAnimation(zoomScale,
            !mWebView.getSettings().getUseFixedViewport());
        // ---------- Original Method ----------
        //final float zoomScale = Math.max(getReadingLevelScale(),
                //mActualScale + MIN_DOUBLE_TAP_SCALE_INCREMENT);
        //int left = mWebView.nativeGetBlockLeftEdge(mAnchorX, mAnchorY, mActualScale);
        //if (left != WebView.NO_LEFTEDGE) {
            //int viewLeft = mWebView.contentToViewX(left < 5 ? 0 : (left - 5))
                    //- mWebView.getScrollX();
            //if (viewLeft > 0) {
                //mZoomCenterX = viewLeft * zoomScale / (zoomScale - mActualScale);
            //} else {
                //mWebView.scrollBy(viewLeft, 0);
                //mZoomCenterX = 0;
            //}
        //}
        //startZoomAnimation(zoomScale,
            //!mWebView.getSettings().getUseFixedViewport());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.859 -0400", hash_original_method = "77E44A3E983371F616079D37D03C3B6C", hash_generated_method = "CEBF60E56A20958A5BFFCCDAC1E64719")
    public void updateMultiTouchSupport(Context context) {
        final WebSettings settings = mWebView.getSettings();
        final PackageManager pm = context.getPackageManager();
        mSupportMultiTouch = 
                (pm.hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH)
                 || pm.hasSystemFeature(PackageManager.FEATURE_FAKETOUCH_MULTITOUCH_DISTINCT))
                && settings.supportZoom() && settings.getBuiltInZoomControls();
        mAllowPanAndScale =
                pm.hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT)
                || pm.hasSystemFeature(PackageManager.FEATURE_FAKETOUCH_MULTITOUCH_DISTINCT);
        if(mSupportMultiTouch && (mScaleDetector == null))        
        {
            mScaleDetector = new ScaleGestureDetector(context, new ScaleDetectorListener());
        } //End block
        else
        if(!mSupportMultiTouch && (mScaleDetector != null))        
        {
            mScaleDetector = null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.859 -0400", hash_original_method = "D759966F5D5714E0336F491E3EEDC527", hash_generated_method = "6905172743769CC35FC4837CCDC67B7F")
    public boolean supportsMultiTouchZoom() {
        boolean var5C62F021E531A91F9743205810E9E171_2069322380 = (mSupportMultiTouch);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_465945922 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_465945922;
        // ---------- Original Method ----------
        //return mSupportMultiTouch;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.859 -0400", hash_original_method = "E2CDCD424944BF66C1EED756BC88611C", hash_generated_method = "95A01302CB55DC7CA6C0C858917072E3")
    public boolean supportsPanDuringZoom() {
        boolean varC0A50D2FDF7098353277E4B1046F8BCE_366042984 = (mAllowPanAndScale);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_104661408 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_104661408;
        // ---------- Original Method ----------
        //return mAllowPanAndScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.860 -0400", hash_original_method = "DB3FE2513664456015F767E0971235E8", hash_generated_method = "3E66FA23C347B7262B2B06E4B35F8C39")
    public boolean isPreventingWebkitUpdates() {
        boolean var01176885CC0A7FB647AA0BDEB81201E1_78507500 = (isZoomAnimating());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1907832433 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1907832433;
        // ---------- Original Method ----------
        //return isZoomAnimating();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.860 -0400", hash_original_method = "D6F4E788215219485BF912038215831B", hash_generated_method = "F8D26A6A6597630098C8F81BA98E99BC")
    public ScaleGestureDetector getMultiTouchGestureDetector() {
ScaleGestureDetector varD1305AEC83178DF8791BB9CAB71C5E16_1038541492 =         mScaleDetector;
        varD1305AEC83178DF8791BB9CAB71C5E16_1038541492.addTaint(taint);
        return varD1305AEC83178DF8791BB9CAB71C5E16_1038541492;
        // ---------- Original Method ----------
        //return mScaleDetector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.860 -0400", hash_original_method = "CAC2F3D27B1973D4CF70D4BE09DB9479", hash_generated_method = "0107FEF1AE411DC1E92A8EB3457E28F9")
    public void onSizeChanged(int w, int h, int ow, int oh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(oh);
        addTaint(ow);
        addTaint(h);
        addTaint(w);
        if(!isFixedLengthAnimationInProgress())        
        {
            int visibleTitleHeight = mWebView.getVisibleTitleHeight();
            mZoomCenterX = 0;
            mZoomCenterY = visibleTitleHeight;
            mAnchorX = mWebView.viewToContentX(mWebView.getScrollX());
            mAnchorY = mWebView.viewToContentY(visibleTitleHeight + mWebView.getScrollY());
        } //End block
        if(!mMinZoomScaleFixed)        
        {
            mMinZoomScale = Math.min(1.0f, (float) mWebView.getViewWidth()
                    / (mWebView.drawHistory() ? mWebView.getHistoryPictureWidth()
                            : mZoomOverviewWidth));
            if(mInitialScale > 0 && mInitialScale < mMinZoomScale)            
            {
                mMinZoomScale = mInitialScale;
            } //End block
        } //End block
        dismissZoomPicker();
        mWebView.post(new PostScale(w != ow &&
            !mWebView.getSettings().getUseFixedViewport(), mInZoomOverview, w < ow));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.860 -0400", hash_original_method = "853C20600470FB7106E8D67215AF9147", hash_generated_method = "D5D728797049DE4FB67602697B7D15CD")
    public void updateZoomRange(WebViewCore.ViewState viewState,
            int viewWidth, int minPrefWidth) {
        if(viewState.mMinScale == 0)        
        {
            if(viewState.mMobileSite)            
            {
                if(minPrefWidth > Math.max(0, viewWidth))                
                {
                    mMinZoomScale = (float) viewWidth / minPrefWidth;
                    mMinZoomScaleFixed = false;
                } //End block
                else
                {
                    mMinZoomScale = viewState.mDefaultScale;
                    mMinZoomScaleFixed = true;
                } //End block
            } //End block
            else
            {
                mMinZoomScale = mDefaultMinZoomScale;
                mMinZoomScaleFixed = false;
            } //End block
        } //End block
        else
        {
            mMinZoomScale = viewState.mMinScale;
            mMinZoomScaleFixed = true;
        } //End block
        if(viewState.mMaxScale == 0)        
        {
            mMaxZoomScale = mDefaultMaxZoomScale;
        } //End block
        else
        {
            mMaxZoomScale = viewState.mMaxScale;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.861 -0400", hash_original_method = "30705697D50ADB9D51B01BF1D1A7F736", hash_generated_method = "C86B06D7F2F3030AC43836F40A4F09B3")
    public void onNewPicture(WebViewCore.DrawData drawData) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(drawData.getTaint());
        final int viewWidth = mWebView.getViewWidth();
        final boolean zoomOverviewWidthChanged = setupZoomOverviewWidth(drawData, viewWidth);
        final float newZoomOverviewScale = getZoomOverviewScale();
        WebSettings settings = mWebView.getSettings();
        if(zoomOverviewWidthChanged && settings.isNarrowColumnLayout() &&
            settings.getUseFixedViewport() &&
            (mInitialZoomOverview || mInZoomOverview))        
        {
            if(exceedsMinScaleIncrement(mTextWrapScale, mDefaultScale) ||
                    exceedsMinScaleIncrement(newZoomOverviewScale, mDefaultScale))            
            {
                mTextWrapScale = getReadingLevelScale();
            } //End block
            else
            {
                mTextWrapScale = newZoomOverviewScale;
            } //End block
        } //End block
        if(!mMinZoomScaleFixed || settings.getUseWideViewPort())        
        {
            mMinZoomScale = newZoomOverviewScale;
            mMaxZoomScale = Math.max(mMaxZoomScale, mMinZoomScale);
        } //End block
        boolean scaleHasDiff = exceedsMinScaleIncrement(newZoomOverviewScale, mActualScale);
        boolean scaleLessThanOverview = (newZoomOverviewScale - mActualScale) >= MINIMUM_SCALE_INCREMENT;
        boolean mobileSiteInOverview = mInZoomOverview &&
                !exceedsMinScaleIncrement(newZoomOverviewScale, mDefaultScale);
        if(!mWebView.drawHistory() &&
            ((scaleLessThanOverview && settings.getUseWideViewPort())||
                ((mInitialZoomOverview || mobileSiteInOverview) &&
                    scaleHasDiff && zoomOverviewWidthChanged)))        
        {
            mInitialZoomOverview = false;
            setZoomScale(newZoomOverviewScale, !willScaleTriggerZoom(mTextWrapScale) &&
                !mWebView.getSettings().getUseFixedViewport());
        } //End block
        else
        {
            mInZoomOverview = !scaleHasDiff;
        } //End block
        if(drawData.mFirstLayoutForNonStandardLoad && settings.getLoadWithOverviewMode())        
        {
            mInitialZoomOverview = mInZoomOverview;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.861 -0400", hash_original_method = "74FCB7875112FE9C3AB647C4DB8DEDB6", hash_generated_method = "77A52066D21C916EEF65A1D097E2B9C8")
    private boolean setupZoomOverviewWidth(WebViewCore.DrawData drawData, final int viewWidth) {
        addTaint(viewWidth);
        addTaint(drawData.getTaint());
        WebSettings settings = mWebView.getSettings();
        int newZoomOverviewWidth = mZoomOverviewWidth;
        if(settings.getUseWideViewPort())        
        {
            if(drawData.mContentSize.x > 0)            
            {
                newZoomOverviewWidth = Math.min(WebView.sMaxViewportWidth,
                    drawData.mContentSize.x);
            } //End block
        } //End block
        else
        {
            newZoomOverviewWidth = Math.round(viewWidth / mDefaultScale);
        } //End block
        if(newZoomOverviewWidth != mZoomOverviewWidth)        
        {
            setZoomOverviewWidth(newZoomOverviewWidth);
            boolean varB326B5062B2F0E69046810717534CB09_249032132 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_468879024 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_468879024;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1788677384 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1835747345 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1835747345;
        // ---------- Original Method ----------
        //WebSettings settings = mWebView.getSettings();
        //int newZoomOverviewWidth = mZoomOverviewWidth;
        //if (settings.getUseWideViewPort()) {
            //if (drawData.mContentSize.x > 0) {
                //newZoomOverviewWidth = Math.min(WebView.sMaxViewportWidth,
                    //drawData.mContentSize.x);
            //}
        //} else {
            //newZoomOverviewWidth = Math.round(viewWidth / mDefaultScale);
        //}
        //if (newZoomOverviewWidth != mZoomOverviewWidth) {
            //setZoomOverviewWidth(newZoomOverviewWidth);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.862 -0400", hash_original_method = "49A97AD028E7397E6545CF950CBFEBF3", hash_generated_method = "57C2DDAEAD6A5B05E512ED939D661A09")
    public void onFirstLayout(WebViewCore.DrawData drawData) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(drawData.getTaint());
        WebViewCore.ViewState viewState = drawData.mViewState;
        final Point viewSize = drawData.mViewSize;
        updateZoomRange(viewState, viewSize.x, drawData.mMinPrefWidth);
        setupZoomOverviewWidth(drawData, mWebView.getViewWidth());
        final float overviewScale = getZoomOverviewScale();
        WebSettings settings = mWebView.getSettings();
        if(!mMinZoomScaleFixed || settings.getUseWideViewPort())        
        {
            mMinZoomScale = (mInitialScale > 0) ?
                    Math.min(mInitialScale, overviewScale) : overviewScale;
            mMaxZoomScale = Math.max(mMaxZoomScale, mMinZoomScale);
        } //End block
        if(!mWebView.drawHistory())        
        {
            float scale;
            if(mInitialScale > 0)            
            {
                scale = mInitialScale;
            } //End block
            else
            if(viewState.mIsRestored || viewState.mViewScale > 0)            
            {
                scale = (viewState.mViewScale > 0)
                    ? viewState.mViewScale : overviewScale;
                mTextWrapScale = (viewState.mTextWrapScale > 0)
                    ? viewState.mTextWrapScale : getReadingLevelScale();
            } //End block
            else
            {
                scale = overviewScale;
                if(!settings.getUseWideViewPort()
                    || !settings.getLoadWithOverviewMode())                
                {
                    scale = Math.max(mDefaultScale, scale);
                } //End block
                if(settings.isNarrowColumnLayout() &&
                    settings.getUseFixedViewport())                
                {
                    mTextWrapScale = getReadingLevelScale();
                } //End block
            } //End block
            boolean reflowText = false;
            if(!viewState.mIsRestored)            
            {
                if(settings.getUseFixedViewport())                
                {
                    scale = Math.max(scale, overviewScale);
                    mTextWrapScale = Math.max(mTextWrapScale, overviewScale);
                } //End block
                reflowText = exceedsMinScaleIncrement(mTextWrapScale, scale);
            } //End block
            mInitialZoomOverview = settings.getLoadWithOverviewMode() &&
                    !exceedsMinScaleIncrement(scale, overviewScale);
            setZoomScale(scale, reflowText);
            updateZoomPicker();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.862 -0400", hash_original_method = "E88F50435C2D2101D935E91DFBA371A3", hash_generated_method = "5657D395C49E0CF098230714AF9A5F33")
    public void saveZoomState(Bundle b) {
        addTaint(b.getTaint());
        b.putFloat("scale", mActualScale);
        b.putFloat("textwrapScale", mTextWrapScale);
        b.putBoolean("overview", mInZoomOverview);
        // ---------- Original Method ----------
        //b.putFloat("scale", mActualScale);
        //b.putFloat("textwrapScale", mTextWrapScale);
        //b.putBoolean("overview", mInZoomOverview);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.862 -0400", hash_original_method = "CEABBB6E3216B8D1034C16D61ED63443", hash_generated_method = "EBABD371F461EB1D455CA9348748325C")
    public void restoreZoomState(Bundle b) {
        mActualScale = b.getFloat("scale", 1.0f);
        mInvActualScale = 1 / mActualScale;
        mTextWrapScale = b.getFloat("textwrapScale", mActualScale);
        mInZoomOverview = b.getBoolean("overview");
        // ---------- Original Method ----------
        //mActualScale = b.getFloat("scale", 1.0f);
        //mInvActualScale = 1 / mActualScale;
        //mTextWrapScale = b.getFloat("textwrapScale", mActualScale);
        //mInZoomOverview = b.getBoolean("overview");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.862 -0400", hash_original_method = "03F547EF9A141661565AD38656124362", hash_generated_method = "CC1C4D383F2DDD8D47A2AC3EE062C490")
    private ZoomControlBase getCurrentZoomControl() {
        if(mWebView.getSettings() != null && mWebView.getSettings().supportZoom())        
        {
            if(mWebView.getSettings().getBuiltInZoomControls())            
            {
                if((mEmbeddedZoomControl == null)
                        && mWebView.getSettings().getDisplayZoomControls())                
                {
                    mEmbeddedZoomControl = new ZoomControlEmbedded(this, mWebView);
                } //End block
ZoomControlBase var8A808A718D61DB5FFF3F50E28A1D3205_2106157619 =                 mEmbeddedZoomControl;
                var8A808A718D61DB5FFF3F50E28A1D3205_2106157619.addTaint(taint);
                return var8A808A718D61DB5FFF3F50E28A1D3205_2106157619;
            } //End block
            else
            {
                if(mExternalZoomControl == null)                
                {
                    mExternalZoomControl = new ZoomControlExternal(mWebView);
                } //End block
ZoomControlBase varAA64408F0FF0F3BE3FD16FD887108408_1306013537 =                 mExternalZoomControl;
                varAA64408F0FF0F3BE3FD16FD887108408_1306013537.addTaint(taint);
                return varAA64408F0FF0F3BE3FD16FD887108408_1306013537;
            } //End block
        } //End block
ZoomControlBase var540C13E9E156B687226421B24F2DF178_1906557980 =         null;
        var540C13E9E156B687226421B24F2DF178_1906557980.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1906557980;
        // ---------- Original Method ----------
        //if (mWebView.getSettings() != null && mWebView.getSettings().supportZoom()) {
            //if (mWebView.getSettings().getBuiltInZoomControls()) {
                //if ((mEmbeddedZoomControl == null)
                        //&& mWebView.getSettings().getDisplayZoomControls()) {
                    //mEmbeddedZoomControl = new ZoomControlEmbedded(this, mWebView);
                //}
                //return mEmbeddedZoomControl;
            //} else {
                //if (mExternalZoomControl == null) {
                    //mExternalZoomControl = new ZoomControlExternal(mWebView);
                //}
                //return mExternalZoomControl;
            //}
        //}
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.863 -0400", hash_original_method = "BF64B2CEB07538AA62EA00039BB48680", hash_generated_method = "E8A316D832FF8D0629D764B233F5583E")
    public void invokeZoomPicker() {
        ZoomControlBase control = getCurrentZoomControl();
        if(control != null)        
        {
            control.show();
        } //End block
        // ---------- Original Method ----------
        //ZoomControlBase control = getCurrentZoomControl();
        //if (control != null) {
            //control.show();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.863 -0400", hash_original_method = "0CAEEFDB341BFD4D4CACBFA479A18F98", hash_generated_method = "6CDC33CEA64DC4D5D98C550647C2A8D0")
    public void dismissZoomPicker() {
        ZoomControlBase control = getCurrentZoomControl();
        if(control != null)        
        {
            control.hide();
        } //End block
        // ---------- Original Method ----------
        //ZoomControlBase control = getCurrentZoomControl();
        //if (control != null) {
            //control.hide();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.863 -0400", hash_original_method = "DA055704D86885A7F9C5B74974CF851B", hash_generated_method = "E34400273BE7DE920FD2DD35F1562247")
    public boolean isZoomPickerVisible() {
        ZoomControlBase control = getCurrentZoomControl();
        boolean var694B41C976D53E1A8386BA2DE732002E_1816295008 = ((control != null) ? control.isVisible() : false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_305063082 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_305063082;
        // ---------- Original Method ----------
        //ZoomControlBase control = getCurrentZoomControl();
        //return (control != null) ? control.isVisible() : false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.863 -0400", hash_original_method = "A8AE3510E280FF5955731B404A0A66EC", hash_generated_method = "A8061B19FBF8892A4D6A1B9D79BAFAF9")
    public void updateZoomPicker() {
        ZoomControlBase control = getCurrentZoomControl();
        if(control != null)        
        {
            control.update();
        } //End block
        // ---------- Original Method ----------
        //ZoomControlBase control = getCurrentZoomControl();
        //if (control != null) {
            //control.update();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.864 -0400", hash_original_method = "65E0B786CE90103F5573BC67CE254CE7", hash_generated_method = "AF01FB41BF559ECB1434E44EDB66A6CC")
    public void keepZoomPickerVisible() {
        ZoomControlBase control = getCurrentZoomControl();
        if(control != null && control == mExternalZoomControl)        
        {
            control.show();
        } //End block
        // ---------- Original Method ----------
        //ZoomControlBase control = getCurrentZoomControl();
        //if (control != null && control == mExternalZoomControl) {
            //control.show();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.864 -0400", hash_original_method = "295B8076F41B8CC3FCA3F323BF66F29B", hash_generated_method = "83C24B6FBAD1319DF26B50DB0CFDA423")
    public View getExternalZoomPicker() {
        ZoomControlBase control = getCurrentZoomControl();
        if(control != null && control == mExternalZoomControl)        
        {
View var666BAF608EF4CC9E2F94583B62B00DD5_634496174 =             mExternalZoomControl.getControls();
            var666BAF608EF4CC9E2F94583B62B00DD5_634496174.addTaint(taint);
            return var666BAF608EF4CC9E2F94583B62B00DD5_634496174;
        } //End block
        else
        {
View var540C13E9E156B687226421B24F2DF178_1687687093 =             null;
            var540C13E9E156B687226421B24F2DF178_1687687093.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1687687093;
        } //End block
        // ---------- Original Method ----------
        //ZoomControlBase control = getCurrentZoomControl();
        //if (control != null && control == mExternalZoomControl) {
            //return mExternalZoomControl.getControls();
        //} else {
            //return null;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.864 -0400", hash_original_method = "8D458CBEFE5B6426DEF9072097FF3245", hash_generated_method = "9ADC4F4CBEDBCA89924A04F25DE685B9")
    public void setHardwareAccelerated() {
        mHardwareAccelerated = true;
        // ---------- Original Method ----------
        //mHardwareAccelerated = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.865 -0400", hash_original_method = "35BF52CFA65A672FC707BA33DDD071E9", hash_generated_method = "87431E9868545C347D0F7EC1A24B960B")
     void onPageFinished(String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(url.getTaint());
        mInitialZoomOverview = false;
        // ---------- Original Method ----------
        //mInitialZoomOverview = false;
    }

    
    private class FocusMovementQueue {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.865 -0400", hash_original_field = "2D043F2822EC0D4E2690BDFE63EDDFCA", hash_generated_field = "9639A8B64144BF72B06D4F02EACB0012")

        private float[] mQueue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.865 -0400", hash_original_field = "BACF4F47646DA9E5EF6C6786F47B387A", hash_generated_field = "5C3922C5E22E6E8A5927016DED3BACFE")

        private float mSum;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.865 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

        private int mSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.865 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "B8B828CADFFAE7A5A771AAB7A1527A20")

        private int mIndex;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.865 -0400", hash_original_method = "C2CA3F4962FE0D524626245DAD0C9DD6", hash_generated_method = "D4AF6BA17545ED20E2FFAFBAF09FD153")
          FocusMovementQueue() {
            mQueue = new float[QUEUE_CAPACITY];
            mSize = 0;
            mSum = 0;
            mIndex = 0;
            // ---------- Original Method ----------
            //mQueue = new float[QUEUE_CAPACITY];
            //mSize = 0;
            //mSum = 0;
            //mIndex = 0;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.865 -0400", hash_original_method = "7BD5EC8FD84F966DA50367EA866227AA", hash_generated_method = "8335069DA08E3ECC73E486A4239E7C8F")
        private void clear() {
            mSize = 0;
            mSum = 0;
            mIndex = 0;
for(int i = 0;i < QUEUE_CAPACITY;++i)
            {
                mQueue[i] = 0;
            } //End block
            // ---------- Original Method ----------
            //mSize = 0;
            //mSum = 0;
            //mIndex = 0;
            //for (int i = 0; i < QUEUE_CAPACITY; ++i) {
                //mQueue[i] = 0;
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.865 -0400", hash_original_method = "BEA568413C11D502CA7CED6FD222D059", hash_generated_method = "8FD819B1AFAAC1DD87B484EE364FF3BB")
        private void add(float focusDelta) {
            mSum += focusDelta;
            if(mSize < QUEUE_CAPACITY)            
            {
                mSize++;
            } //End block
            else
            {
                mSum -= mQueue[mIndex];
            } //End block
            mQueue[mIndex] = focusDelta;
            mIndex = (mIndex + 1) % QUEUE_CAPACITY;
            // ---------- Original Method ----------
            //mSum += focusDelta;
            //if (mSize < QUEUE_CAPACITY) {  
                //mSize++;
            //} else {  
                //mSum -= mQueue[mIndex];
            //}
            //mQueue[mIndex] = focusDelta;
            //mIndex = (mIndex + 1) % QUEUE_CAPACITY;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.865 -0400", hash_original_method = "D980EABC4C0F2D2A081289A0764FD494", hash_generated_method = "27E40A102301B63BF6A698EF36181E46")
        private float getSum() {
            float varBACF4F47646DA9E5EF6C6786F47B387A_1320512401 = (mSum);
                        float var546ADE640B6EDFBC8A086EF31347E768_47263080 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_47263080;
            // ---------- Original Method ----------
            //return mSum;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.865 -0400", hash_original_field = "68D6C106EA24FD5D1E9A33FE112A82F8", hash_generated_field = "4AE12D25133F8791AD4CAFB87334ABF4")

        private static final int QUEUE_CAPACITY = 5;
    }


    
    private class ScaleDetectorListener implements ScaleGestureDetector.OnScaleGestureListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.866 -0400", hash_original_field = "09CF021BF536BAB6C30DC7BBD1177879", hash_generated_field = "D9620ED126995C2A7FCE1BBDF87310E8")

        private float mAccumulatedSpan;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.866 -0400", hash_original_method = "BA46F3652F41E17982BE025D7A95EDE2", hash_generated_method = "BA46F3652F41E17982BE025D7A95EDE2")
        public ScaleDetectorListener ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.866 -0400", hash_original_method = "9075B37C27A1752EF4C1C0179D09116C", hash_generated_method = "D1E1B185605E99BFF941D97B27D3DDD1")
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(detector.getTaint());
            mInitialZoomOverview = false;
            dismissZoomPicker();
            mFocusMovementQueue.clear();
            mFocusX = detector.getFocusX();
            mFocusY = detector.getFocusY();
            mWebView.mViewManager.startZoom();
            mWebView.onPinchToZoomAnimationStart();
            mAccumulatedSpan = 0;
            boolean varB326B5062B2F0E69046810717534CB09_1312084898 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2017986801 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2017986801;
            // ---------- Original Method ----------
            //mInitialZoomOverview = false;
            //dismissZoomPicker();
            //mFocusMovementQueue.clear();
            //mFocusX = detector.getFocusX();
            //mFocusY = detector.getFocusY();
            //mWebView.mViewManager.startZoom();
            //mWebView.onPinchToZoomAnimationStart();
            //mAccumulatedSpan = 0;
            //return true;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.867 -0400", hash_original_method = "B0E9BE71CCDF607A4C10071A1E309D43", hash_generated_method = "023E82DFF1FC028CD06FFC0F492AD7D0")
        public boolean isPanningOnly(ScaleGestureDetector detector) {
            addTaint(detector.getTaint());
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
            if(result)            
            {
                mAccumulatedSpan += deltaSpan;
            } //End block
            else
            {
                mAccumulatedSpan = 0;
            } //End block
            boolean varB4A88417B3D0170D754C647C30B7216A_1439255962 = (result);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_918471398 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_918471398;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.869 -0400", hash_original_method = "69F2A7AC5DBED7E3BD0F18F39CE3A7B5", hash_generated_method = "25E6E276B6B5ED0D9FD45C26BFCB5342")
        public boolean handleScale(ScaleGestureDetector detector) {
            addTaint(detector.getTaint());
            float scale = detector.getScaleFactor() * mActualScale;
            boolean isScaleLimited = isScaleOverLimits(scale) || scale < getZoomOverviewScale();
            scale = Math.max(computeScaleWithLimits(scale), getZoomOverviewScale());
            if(mPinchToZoomAnimating || willScaleTriggerZoom(scale))            
            {
                mPinchToZoomAnimating = true;
                if(scale > mActualScale)                
                {
                    scale = Math.min(scale, mActualScale * 1.25f);
                } //End block
                else
                {
                    scale = Math.max(scale, mActualScale * 0.8f);
                } //End block
                scale = computeScaleWithLimits(scale);
                if(Math.abs(scale - mActualScale) < MINIMUM_SCALE_WITHOUT_JITTER)                
                {
                    boolean var1C6268753F1929ED129FB907F631788A_354702876 = (isScaleLimited);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_494451975 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_494451975;
                } //End block
                setZoomCenter(detector.getFocusX(), detector.getFocusY());
                setZoomScale(scale, false);
                mWebView.invalidate();
                boolean varB326B5062B2F0E69046810717534CB09_354101104 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1499660517 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1499660517;
            } //End block
            boolean var1C6268753F1929ED129FB907F631788A_253657850 = (isScaleLimited);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1218030823 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1218030823;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.870 -0400", hash_original_method = "ED0E7724FBEBB5F90A0828B68DD48F69", hash_generated_method = "0EBCBCCD9DE8E9E4C18F4A307536BB8B")
        public boolean onScale(ScaleGestureDetector detector) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(detector.getTaint());
            if(isPanningOnly(detector) || handleScale(detector))            
            {
                mFocusMovementQueue.clear();
                boolean varB326B5062B2F0E69046810717534CB09_1679438205 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1433094902 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1433094902;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_102258164 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1419649885 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1419649885;
            // ---------- Original Method ----------
            //if (isPanningOnly(detector) || handleScale(detector)) {
                //mFocusMovementQueue.clear();
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.870 -0400", hash_original_method = "8B2C3B6F263B86181A105DF4C3A0ECE1", hash_generated_method = "B158EED8D9405307320ADDED67B03D7F")
        public void onScaleEnd(ScaleGestureDetector detector) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(detector.getTaint());
            if(mPinchToZoomAnimating)            
            {
                mPinchToZoomAnimating = false;
                mAnchorX = mWebView.viewToContentX((int) mZoomCenterX + mWebView.getScrollX());
                mAnchorY = mWebView.viewToContentY((int) mZoomCenterY + mWebView.getScrollY());
                boolean reflowNow = !canZoomOut() || (mActualScale <= 0.8 * mTextWrapScale);
                refreshZoomScale(reflowNow &&
                    !mWebView.getSettings().getUseFixedViewport());
                mWebView.invalidate();
            } //End block
            mWebView.mViewManager.endZoom();
            mWebView.onPinchToZoomAnimationEnd(detector);
            // ---------- Original Method ----------
            //if (mPinchToZoomAnimating) {
                //mPinchToZoomAnimating = false;
                //mAnchorX = mWebView.viewToContentX((int) mZoomCenterX + mWebView.getScrollX());
                //mAnchorY = mWebView.viewToContentY((int) mZoomCenterY + mWebView.getScrollY());
                //boolean reflowNow = !canZoomOut() || (mActualScale <= 0.8 * mTextWrapScale);
                //refreshZoomScale(reflowNow &&
                    //!mWebView.getSettings().getUseFixedViewport());
                //mWebView.invalidate();
            //}
            //mWebView.mViewManager.endZoom();
            //mWebView.onPinchToZoomAnimationEnd(detector);
        }

        
    }


    
    private class PostScale implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.870 -0400", hash_original_field = "FF619880DF50315F5F0C23464FCB91F9", hash_generated_field = "77CA9D980A43549CDA68DE3DCA6626A5")

        boolean mUpdateTextWrap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.870 -0400", hash_original_field = "3C0CE17CA283A7A032FB13C4CF5E9947", hash_generated_field = "CFCDFC51582F4CFE0A0F368B7A789B49")

        boolean mInZoomOverviewBeforeSizeChange;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.870 -0400", hash_original_field = "91FECCF530559D322CF17336F85F2461", hash_generated_field = "885926B4FFFBA16CECCAF1A99F0266F9")

        boolean mInPortraitMode;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.871 -0400", hash_original_method = "987305C98B26834A8CB0058E5C6D93E2", hash_generated_method = "3399CCB2C3E7BA10E96510C264203349")
        public  PostScale(boolean updateTextWrap,
                         boolean inZoomOverview,
                         boolean inPortraitMode) {
            mUpdateTextWrap = updateTextWrap;
            mInZoomOverviewBeforeSizeChange = inZoomOverview;
            mInPortraitMode = inPortraitMode;
            // ---------- Original Method ----------
            //mUpdateTextWrap = updateTextWrap;
            //mInZoomOverviewBeforeSizeChange = inZoomOverview;
            //mInPortraitMode = inPortraitMode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.871 -0400", hash_original_method = "713D19A11600F821B2CA1C17235BF1BC", hash_generated_method = "5806FDEFB429D1D62A35E85374E5558C")
        public void run() {
            if(mWebView.getWebViewCore() != null)            
            {
                float newScale = mActualScale;
                if(mWebView.getSettings().getUseWideViewPort() &&
                    mInPortraitMode &&
                    mInZoomOverviewBeforeSizeChange)                
                {
                    newScale = getZoomOverviewScale();
                } //End block
                setZoomScale(newScale, mUpdateTextWrap, true);
                updateZoomPicker();
            } //End block
            // ---------- Original Method ----------
            //if (mWebView.getWebViewCore() != null) {
                //float newScale = mActualScale;
                //if (mWebView.getSettings().getUseWideViewPort() &&
                    //mInPortraitMode &&
                    //mInZoomOverviewBeforeSizeChange) {
                    //newScale = getZoomOverviewScale();
                //}
                //setZoomScale(newScale, mUpdateTextWrap, true);
                //updateZoomPicker();
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.872 -0400", hash_original_field = "0DB0A8D0024C30F56EDCF3AFB02E533D", hash_generated_field = "1172DCF442F1B530BFE9216ADBA08AB8")

    static final String LOGTAG = "webviewZoom";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.872 -0400", hash_original_field = "824864C5654B72A6B9F5576381E885DA", hash_generated_field = "01501206C858CCE0B2BAF203972C511B")

    protected static final float DEFAULT_MAX_ZOOM_SCALE_FACTOR = 4.00f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.872 -0400", hash_original_field = "3F514FF5D0C7CF1AF261334CC5737B03", hash_generated_field = "A8E4F36E80550FABF96F35586FC945C0")

    protected static final float DEFAULT_MIN_ZOOM_SCALE_FACTOR = 0.25f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.872 -0400", hash_original_field = "12D317062A7ECE5FD7C63AA57A6DC326", hash_generated_field = "D8861706BAFD8699E50F90FBCF998F7D")

    private static float MIN_DOUBLE_TAP_SCALE_INCREMENT = 0.5f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.872 -0400", hash_original_field = "CC4756180A7EFB1D163EEE2302021E77", hash_generated_field = "9312CAAED499DB8E5F33CA8B59A623F5")

    private static float MINIMUM_SCALE_INCREMENT = 0.007f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.872 -0400", hash_original_field = "2B07A398287AE320F54A1B32AD3EEDC5", hash_generated_field = "3CC1005C93624AF917078598F90C5E0D")

    private static float MINIMUM_SCALE_WITHOUT_JITTER = 0.007f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.872 -0400", hash_original_field = "4061CBCD4A8CBAAAAFDB40A970FAA7C8", hash_generated_field = "D2F744F6BCE3A182CFEB66495ABCBDAE")

    private static final int ZOOM_ANIMATION_LENGTH = 175;
}

