package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.FloatMath;
import android.util.Log;
import android.view.ScaleGestureDetector;
import android.view.View;

class ZoomManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "957B64C4FA99E51BCE1B62690725D115", hash_generated_field = "62789CA10670C708EA4D387AB18C5F89")

    private CallbackProxy mCallbackProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "34902BF967D867A8C3F4CC4010B6E9EF", hash_generated_field = "2DA301B6F95E0EBE97AB103E0F47F9F3")

    private ZoomControlEmbedded mEmbeddedZoomControl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "3E28AE1D93462FA1E7D90F056B0F6E1D", hash_generated_field = "E1828D795EA501C93F7B7AE52E32EC0D")

    private ZoomControlExternal mExternalZoomControl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "62F3D783B3687CBC0BDB448D90E58278", hash_generated_field = "A75525F777409EAE64A30A85B5ECCBE1")

    private float mDefaultMaxZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "8B4997D60CFE283F65068FB0529E4498", hash_generated_field = "52C961320D37FAE0F1AE675CFD1F2BEC")

    private float mDefaultMinZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "B473A45F09A23AD2B870CF185D4AA12A", hash_generated_field = "49153CC81AC659E75C57042122CE79CA")

    private float mMaxZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "DA19E9676D629B1D45B511C2C1DBDFAB", hash_generated_field = "62544A60744E4E06A4BB732A37B9A75D")

    private float mMinZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "49ED4F15B76F494F60E56C2FAEDC5E89", hash_generated_field = "0045D4254134E122CD3AF4AD2A34AE42")

    private boolean mMinZoomScaleFixed = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "C5AEF7F4CDDDA63B17EDCA58C1930701", hash_generated_field = "0ED10F26046E2B869A9993F37463D665")

    private boolean mInitialZoomOverview = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "998C898FF1863528EFFAB397B8821943", hash_generated_field = "D1063DF321563D8E711FE2915CC13ED6")

    private boolean mInZoomOverview = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "13DBB97D624EFD6C45C1709D4D77E1AC", hash_generated_field = "EEF381E8DFAB0F8AFA6DED39CA509D69")

    private int mZoomOverviewWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "77077C98D8D725F541F44258326BEA3C", hash_generated_field = "789EB22FC445F5CF4578A1B705BCFD89")

    private float mInvZoomOverviewWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "57681D2E7F65B2999AC6DB0157119FFE", hash_generated_field = "73D88F8A1B8C24D1E753BDF66C353FE4")

    private float mZoomCenterX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "7BA53A17CCE52B938AB36A19D2D5212D", hash_generated_field = "0905DF24D370C5BABA5C5316D621064E")

    private float mZoomCenterY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "A0FE7B7E6572E9A5C03F808D583D21EF", hash_generated_field = "9E3ECCCE67853EF67D401BC85D54FCDD")

    private float mFocusX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "E371837A8119A3AB321FC558BC169293", hash_generated_field = "E01C42CAE2152A2827127C5E1618E0BF")

    private float mFocusY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "87008528F20CC5552B26DB443AC74F67", hash_generated_field = "7AE666B3B95EE2A25725DEE0E0FF8D16")

    private FocusMovementQueue mFocusMovementQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "E7657EDDA986C0D1CC052B8F112FE09D", hash_generated_field = "5F8E058F09826A27700241950A47C51E")

    private int mAnchorX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "87FAE44598E10061776ABA72BF200D70", hash_generated_field = "D3B700F3BB8B795E0ADFEB729C0AE646")

    private int mAnchorY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "3190B9F88CD9ECBDD0CF99CE8D1E0B89", hash_generated_field = "1B5C7663299982C5C7D3FB1CDE2DE612")

    private float mTextWrapScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.965 -0400", hash_original_field = "F3150A42E04B25673AB01D2C041638C1", hash_generated_field = "2F8E15D8BE82ACCE0EB0157530F26BA2")

    private float mDefaultScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.973 -0400", hash_original_field = "F76A5E4401A0723AA5E56C29FBB9CF15", hash_generated_field = "403E94F468B3BDF8320A5058252C64CF")

    private float mInvDefaultScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.973 -0400", hash_original_field = "5CDFBEECE4C65AB1FD80F336D826A9B3", hash_generated_field = "6380DD00339CD0A77C6B25CB19413BC5")

    private float mDisplayDensity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.973 -0400", hash_original_field = "25E6113202D6CFE1096DA97DA85A393C", hash_generated_field = "35F9B21E3F5F564C990231A1E5CD959C")

    private float mDoubleTapZoomFactor = 1.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.973 -0400", hash_original_field = "2BD1064E1316AB3431CD233A2DB36D76", hash_generated_field = "EC2D05F087E31D17947841E32358DEC1")

    private float mActualScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.973 -0400", hash_original_field = "E3D71FEA20B9D8C04A31631606259011", hash_generated_field = "C3F4C4AE5E1BA7A43BA1DC26150BBCED")

    private float mInvActualScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.973 -0400", hash_original_field = "1D77D2432E524838ACFF4200A870280D", hash_generated_field = "86487DADE4014C689CAFFA37B4818AF4")

    private float mInitialScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.973 -0400", hash_original_field = "9D28FB72937787644389F529B4276C55", hash_generated_field = "D8F7937535B71ED52FE04BF51381C2E3")

    private float mZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.973 -0400", hash_original_field = "F5674EF1AB117AA2DB1AAA75A63E4275", hash_generated_field = "DFE1ED1EDAC53623D5358E45BF3F4EBD")

    private float mInvInitialZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.973 -0400", hash_original_field = "F0D6ED4FFDAF5496002ADD1B08B462FE", hash_generated_field = "424DF48095CC98F0B236E854F4E43A2D")

    private float mInvFinalZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.973 -0400", hash_original_field = "A2854BA31136A2F81EC6577AEBE1E664", hash_generated_field = "B116C55D4B4D66EE153F454CBA568BE6")

    private int mInitialScrollX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.973 -0400", hash_original_field = "557FEBE80E5593717A34985067D77EF0", hash_generated_field = "E57D614FBFE0B9BAA23984CC3E7AD606")

    private int mInitialScrollY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.973 -0400", hash_original_field = "FD4D0FB807AF66279DB4B8659BAA63C5", hash_generated_field = "CCF37C49798D869F18D246B6747FFF61")

    private long mZoomStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.973 -0400", hash_original_field = "5C62F021E531A91F9743205810E9E171", hash_generated_field = "17F95B8381C48D81ED3F070ABC618EA0")

    private boolean mSupportMultiTouch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.973 -0400", hash_original_field = "C0A50D2FDF7098353277E4B1046F8BCE", hash_generated_field = "9B444A6905DBFA8226D34C0732D3C33C")

    private boolean mAllowPanAndScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.973 -0400", hash_original_field = "A0F3C25877DFCDC03E45221E32A4656A", hash_generated_field = "0C270CE12B813847261F32665B4317E0")

    private ScaleGestureDetector mScaleDetector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.973 -0400", hash_original_field = "65635DB64810CB34B0C3240333C5CD95", hash_generated_field = "45DDE0467059E4D71CD5528DE7734AFC")

    private boolean mPinchToZoomAnimating = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.974 -0400", hash_original_field = "94CB263926656D6FE605610741F6C504", hash_generated_field = "80FDB96634A8A83890141751180EF1B9")

    private boolean mHardwareAccelerated = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.974 -0400", hash_original_field = "502FB9866E2BA595DDCE2A31361DD0CD", hash_generated_field = "F44E8E20A0C3B070FDDA9A2AECAA2700")

    private boolean mInHWAcceleratedZoom = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.974 -0400", hash_original_method = "C53EE2007D9BEC2FE01EA607CD54C4FF", hash_generated_method = "0190DB67F1A6601D594EAB9FDB61EC8B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.975 -0400", hash_original_method = "93CFAAB8556EE96135ADFFE4D2689C29", hash_generated_method = "BAE942C36681C49C4BCAA7C766AB89E9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.976 -0400", hash_original_method = "2EFEEBFBDE6ACF8543350ABFFB008A8F", hash_generated_method = "EF8678B4FC435FFDE019F5C78EDE3028")
    public void updateDefaultZoomDensity(float density) {
        {
            boolean var55986BB94FD10BB61A37151F90F17CA6_927222432 = (Math.abs(density - mDefaultScale) > MINIMUM_SCALE_INCREMENT);
            {
                float originalDefault;
                originalDefault = mDefaultScale;
                setDefaultZoomScale(density);
                float scaleChange;
                scaleChange = density / originalDefault;
                scaleChange = 1.0f;
                setZoomScale(mActualScale * scaleChange, true);
            } //End block
        } //End collapsed parenthetic
        addTaint(density);
        // ---------- Original Method ----------
        //assert density > 0;
        //if (Math.abs(density - mDefaultScale) > MINIMUM_SCALE_INCREMENT) {
            //final float originalDefault = mDefaultScale;
            //setDefaultZoomScale(density);
            //float scaleChange = (originalDefault > 0.0) ? density / originalDefault: 1.0f;
            //setZoomScale(mActualScale * scaleChange, true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.978 -0400", hash_original_method = "E8BCC867B6D8CCFABF539A9D95032C95", hash_generated_method = "B5EF971FC18C2BDD677C57466F9EC9E0")
    private void setDefaultZoomScale(float defaultScale) {
        float originalDefault;
        originalDefault = mDefaultScale;
        mDefaultScale = defaultScale;
        mInvDefaultScale = 1 / defaultScale;
        mDefaultMaxZoomScale = defaultScale * DEFAULT_MAX_ZOOM_SCALE_FACTOR;
        mDefaultMinZoomScale = defaultScale * DEFAULT_MIN_ZOOM_SCALE_FACTOR;
        {
            mMaxZoomScale = defaultScale / originalDefault * mMaxZoomScale;
        } //End block
        {
            mMaxZoomScale = mDefaultMaxZoomScale;
        } //End block
        {
            mMinZoomScale = defaultScale / originalDefault * mMinZoomScale;
        } //End block
        {
            mMinZoomScale = mDefaultMinZoomScale;
        } //End block
        {
            boolean varD4A51976EA74EEAE11BCC79328DC7589_1812040972 = (!exceedsMinScaleIncrement(mMinZoomScale, mMaxZoomScale));
            {
                mMaxZoomScale = mMinZoomScale;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.978 -0400", hash_original_method = "E0A7D63CBE7BA22AE5FD1D2BCFACA30A", hash_generated_method = "A9739385B382497C0062183CEB17C535")
    public final float getScale() {
        float var546ADE640B6EDFBC8A086EF31347E768_555146053 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_555146053;
        // ---------- Original Method ----------
        //return mActualScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.991 -0400", hash_original_method = "27B2B7D16269E37341CA9CE429E50BD4", hash_generated_method = "237DA2C8F7F6FE1DD737F128C579F2BB")
    public final float getInvScale() {
        float var546ADE640B6EDFBC8A086EF31347E768_1203959982 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1203959982;
        // ---------- Original Method ----------
        //return mInvActualScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.992 -0400", hash_original_method = "420B51415ADFBA4739EC66A8F732263C", hash_generated_method = "BB9DE365C2A5CA430A8FE2B16CF13571")
    public final float getTextWrapScale() {
        float var546ADE640B6EDFBC8A086EF31347E768_1765446401 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1765446401;
        // ---------- Original Method ----------
        //return mTextWrapScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.992 -0400", hash_original_method = "4D84680032231769C697659C881951E3", hash_generated_method = "880F25FA20990537C3DB3F3BBED4799B")
    public final float getMaxZoomScale() {
        float var546ADE640B6EDFBC8A086EF31347E768_1489408107 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1489408107;
        // ---------- Original Method ----------
        //return mMaxZoomScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.992 -0400", hash_original_method = "EF101FB82D6E625D2F7286BB14442128", hash_generated_method = "9B5A41A1D8BF56FA6B594777B2698A06")
    public final float getMinZoomScale() {
        float var546ADE640B6EDFBC8A086EF31347E768_2031926074 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2031926074;
        // ---------- Original Method ----------
        //return mMinZoomScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.000 -0400", hash_original_method = "C9287BA17A965D05EE45D11D20F2D047", hash_generated_method = "C43140AE537BAD22300EEEBCFBC472E3")
    public final float getDefaultScale() {
        float var546ADE640B6EDFBC8A086EF31347E768_1792798299 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1792798299;
        // ---------- Original Method ----------
        //return mDefaultScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.002 -0400", hash_original_method = "B68BBC34F3F5ADBA444AF11F55B159F2", hash_generated_method = "EB381D4C1382D5C0253D0D74B98ED081")
    public final float getReadingLevelScale() {
        float var546ADE640B6EDFBC8A086EF31347E768_235506000 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_235506000;
        // ---------- Original Method ----------
        //return mDisplayDensity * mDoubleTapZoomFactor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.002 -0400", hash_original_method = "150923628532607A08D5A6F81E7006FE", hash_generated_method = "B715F5EA212D87985956AB7C1EB67F28")
    public final float getInvDefaultScale() {
        float var546ADE640B6EDFBC8A086EF31347E768_428460047 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_428460047;
        // ---------- Original Method ----------
        //return mInvDefaultScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.003 -0400", hash_original_method = "86C1C61E20B5F864D06602058822F40B", hash_generated_method = "616B9B29380B0D3AC1ADDC4677A1A438")
    public final float getDefaultMaxZoomScale() {
        float var546ADE640B6EDFBC8A086EF31347E768_1674512905 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1674512905;
        // ---------- Original Method ----------
        //return mDefaultMaxZoomScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.003 -0400", hash_original_method = "68697F997D536A00F27515B45D68169D", hash_generated_method = "C6B75796F393DDDC85B65D6ADCE39C28")
    public final float getDefaultMinZoomScale() {
        float var546ADE640B6EDFBC8A086EF31347E768_517618725 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_517618725;
        // ---------- Original Method ----------
        //return mDefaultMinZoomScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.003 -0400", hash_original_method = "0D1E90BA2B32E85CA9E1B47821E3129C", hash_generated_method = "8A62AF67858DAB9FB019F03088654C63")
    public final int getDocumentAnchorX() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_561235757 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_561235757;
        // ---------- Original Method ----------
        //return mAnchorX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.004 -0400", hash_original_method = "6F8EAB28E274BDE9903F29B52FA3CE08", hash_generated_method = "6566944FD712A8F845BE565B3A5BC25A")
    public final int getDocumentAnchorY() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_159292138 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_159292138;
        // ---------- Original Method ----------
        //return mAnchorY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.004 -0400", hash_original_method = "37EC19EE8D577B9FFE8E8612EB136E0D", hash_generated_method = "0979E863D08CE670AE5057D10C3B3325")
    public final void clearDocumentAnchor() {
        mAnchorX = mAnchorY = 0;
        // ---------- Original Method ----------
        //mAnchorX = mAnchorY = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.005 -0400", hash_original_method = "B42B83C0DB8155DA229557A2BD45C477", hash_generated_method = "376A60C9AA8D31A1B7B25334BE2AA077")
    public final void setZoomCenter(float x, float y) {
        mZoomCenterX = x;
        mZoomCenterY = y;
        // ---------- Original Method ----------
        //mZoomCenterX = x;
        //mZoomCenterY = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.005 -0400", hash_original_method = "E17C2AED3C2D9DCFE2D098E038948EA1", hash_generated_method = "C3C51A8EAC82BA7545BE75E4A35DC3DA")
    public final void setInitialScaleInPercent(int scaleInPercent) {
        mInitialScale = scaleInPercent * 0.01f;
        // ---------- Original Method ----------
        //mInitialScale = scaleInPercent * 0.01f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.018 -0400", hash_original_method = "CACC1DB3C5C8FBE689456F981994723C", hash_generated_method = "1EDE643CD5437283E66E5CFE8047C98F")
    public final float computeScaleWithLimits(float scale) {
        {
            scale = mMinZoomScale;
        } //End block
        {
            scale = mMaxZoomScale;
        } //End block
        addTaint(scale);
        float var546ADE640B6EDFBC8A086EF31347E768_310988769 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_310988769;
        // ---------- Original Method ----------
        //if (scale < mMinZoomScale) {
            //scale = mMinZoomScale;
        //} else if (scale > mMaxZoomScale) {
            //scale = mMaxZoomScale;
        //}
        //return scale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.023 -0400", hash_original_method = "49E88837FC0437D5B36C3DDB131811B0", hash_generated_method = "2EBD35DB63B4567275A46015A74F49ED")
    public final boolean isScaleOverLimits(float scale) {
        addTaint(scale);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_859627397 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_859627397;
        // ---------- Original Method ----------
        //return scale <= mMinZoomScale || scale >= mMaxZoomScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.024 -0400", hash_original_method = "EAE2E4FAF7045B63798AAD0EC191C138", hash_generated_method = "B08218DFDDF11381B995E712EBD5D3E5")
    public final boolean isZoomScaleFixed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2004065997 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2004065997;
        // ---------- Original Method ----------
        //return mMinZoomScale >= mMaxZoomScale;
    }

    
        public static final boolean exceedsMinScaleIncrement(float scaleA, float scaleB) {
        return Math.abs(scaleA - scaleB) >= MINIMUM_SCALE_INCREMENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.024 -0400", hash_original_method = "73353D5825B74E55208D73C06ED7146E", hash_generated_method = "0FA2CAC7E51BE2C185B7AF5CA7FE0648")
    public boolean willScaleTriggerZoom(float scale) {
        boolean var6A4063C36BF43452312B6B8657DF0783_1939715334 = (exceedsMinScaleIncrement(scale, mActualScale));
        addTaint(scale);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1551614203 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1551614203;
        // ---------- Original Method ----------
        //return exceedsMinScaleIncrement(scale, mActualScale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.025 -0400", hash_original_method = "577BAEA37EC580D2471F28E52ACC3E90", hash_generated_method = "B7A6D4A9AA85E18AB3A06F521B3F5783")
    public final boolean canZoomIn() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_132415283 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_132415283;
        // ---------- Original Method ----------
        //return mMaxZoomScale - mActualScale > MINIMUM_SCALE_INCREMENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.025 -0400", hash_original_method = "82D91A91E65D0066AFB31608B5056133", hash_generated_method = "5E75EA0FE7653251342A6382B25D36C8")
    public final boolean canZoomOut() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1649689273 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1649689273;
        // ---------- Original Method ----------
        //return mActualScale - mMinZoomScale > MINIMUM_SCALE_INCREMENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.025 -0400", hash_original_method = "1087ACA9FDE3F82506A02D8DB9B3B812", hash_generated_method = "DA9E81740B383DAE5FC3C8A2876BBEBE")
    public boolean zoomIn() {
        boolean var1D72A61B00F4DC9B0382B92DAC1773A6_1907480686 = (zoom(1.25f));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1338575101 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1338575101;
        // ---------- Original Method ----------
        //return zoom(1.25f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.025 -0400", hash_original_method = "AF303514C2CE6EE62014ED1CD988BE8F", hash_generated_method = "994ADF5F1342852692CE52DA3DA644D0")
    public boolean zoomOut() {
        boolean var3CF167EA70562DB2BA335E1A998DD456_1501816523 = (zoom(0.8f));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_93262452 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_93262452;
        // ---------- Original Method ----------
        //return zoom(0.8f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.026 -0400", hash_original_method = "0D06D835317E38A4890F08EB962517B9", hash_generated_method = "13B00C5F30FA4517CBDBD2E059A1F470")
    private boolean zoom(float zoomMultiplier) {
        mInitialZoomOverview = false;
        mWebView.switchOutDrawHistory();
        mZoomCenterX = mWebView.getViewWidth() * .5f;
        mZoomCenterY = mWebView.getViewHeight() * .5f;
        mAnchorX = mWebView.viewToContentX((int) mZoomCenterX + mWebView.getScrollX());
        mAnchorY = mWebView.viewToContentY((int) mZoomCenterY + mWebView.getScrollY());
        boolean var90FBEB34589F56F8A92EA96C08461924_371381499 = (startZoomAnimation(mActualScale * zoomMultiplier, 
            !mWebView.getSettings().getUseFixedViewport()));
        addTaint(zoomMultiplier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1899466395 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1899466395;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.031 -0400", hash_original_method = "ABA8C6E97A9C369182835D6347EB12CF", hash_generated_method = "731CE445AF674C36B7CB7D194B41B791")
    public boolean startZoomAnimation(float scale, boolean reflowText) {
        mInitialZoomOverview = false;
        float oldScale;
        oldScale = mActualScale;
        mInitialScrollX = mWebView.getScrollX();
        mInitialScrollY = mWebView.getScrollY();
        {
            boolean var654B16B46C4BC96AA00B68D2DF42FCA3_694609604 = (!exceedsMinScaleIncrement(scale, getReadingLevelScale()));
            {
                scale = getReadingLevelScale();
            } //End block
        } //End collapsed parenthetic
        {
            mInHWAcceleratedZoom = true;
        } //End block
        setZoomScale(scale, reflowText);
        {
            mZoomStart = SystemClock.uptimeMillis();
            mInvInitialZoomScale = 1.0f / oldScale;
            mInvFinalZoomScale = 1.0f / mActualScale;
            mZoomScale = mActualScale;
            mWebView.onFixedLengthZoomAnimationStart();
            mWebView.invalidate();
        } //End block
        addTaint(scale);
        addTaint(reflowText);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1700537822 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1700537822;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.051 -0400", hash_original_method = "4B2E3C5C63E13C95ACA7AA346AD0833D", hash_generated_method = "983F60545AB8256B5CC2CACF7FFBD5DA")
    public void animateZoom(Canvas canvas) {
        mInitialZoomOverview = false;
        float zoomScale;
        int interval;
        interval = (int) (SystemClock.uptimeMillis() - mZoomStart);
        {
            float ratio;
            ratio = (float) interval / ZOOM_ANIMATION_LENGTH;
            zoomScale = 1.0f / (mInvInitialZoomScale
                    + (mInvFinalZoomScale - mInvInitialZoomScale) * ratio);
            mWebView.invalidate();
        } //End block
        {
            zoomScale = mZoomScale;
            mZoomScale = 0;
            mWebView.onFixedLengthZoomAnimationEnd();
        } //End block
        float scale;
        scale = zoomScale * mInvInitialZoomScale;
        int tx;
        tx = Math.round(scale * (mInitialScrollX + mZoomCenterX) - mZoomCenterX);
        tx = -WebView.pinLoc(tx, mWebView.getViewWidth(), Math.round(mWebView.getContentWidth()
                * zoomScale)) + mWebView.getScrollX();
        int titleHeight;
        titleHeight = mWebView.getTitleHeight();
        int ty;
        ty = Math.round(scale
                * (mInitialScrollY + mZoomCenterY - titleHeight)
                - (mZoomCenterY - titleHeight));
        ty = -(ty <= titleHeight ? Math.max(ty, 0) : WebView.pinLoc(ty
                - titleHeight, mWebView.getViewHeight(), Math.round(mWebView.getContentHeight()
                * zoomScale)) + titleHeight) + mWebView.getScrollY();
        {
            mWebView.updateScrollCoordinates(mWebView.getScrollX() - tx, mWebView.getScrollY() - ty);
            canvas.translate(tx, ty);
            setZoomScale(zoomScale, false);
            {
                mInHWAcceleratedZoom = false;
                mWebView.sendViewSizeZoom(false);
            } //End block
        } //End block
        {
            canvas.translate(tx, ty);
            canvas.scale(zoomScale, zoomScale);
        } //End block
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.051 -0400", hash_original_method = "E0C5EE754D896EBEA19BF99FCF86359E", hash_generated_method = "2ACA8F00987D3A803CD1267757649489")
    public boolean isZoomAnimating() {
        boolean var68B3C139DA5F66F80A809EBC4526A9C7_1033060758 = (isFixedLengthAnimationInProgress() || mPinchToZoomAnimating);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_429034654 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_429034654;
        // ---------- Original Method ----------
        //return isFixedLengthAnimationInProgress() || mPinchToZoomAnimating;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.052 -0400", hash_original_method = "351373D4552618F4F14C898A250D84BD", hash_generated_method = "BA08E128E72B90B7EFB6A27AE37E48AE")
    public boolean isFixedLengthAnimationInProgress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_872976076 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_872976076;
        // ---------- Original Method ----------
        //return mZoomScale != 0 || mInHWAcceleratedZoom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.052 -0400", hash_original_method = "38BADAFCA13DD410DF65C206538CBBC7", hash_generated_method = "9D84A5FE8B9F356D001C6746D8489A3F")
    public void updateDoubleTapZoom(int doubleTapZoom) {
        boolean zoomIn;
        zoomIn = (mTextWrapScale - mActualScale) < .1f;
        mDoubleTapZoomFactor = doubleTapZoom / 100.0f;
        mTextWrapScale = getReadingLevelScale();
        float newScale;
        newScale = mTextWrapScale;
        newScale = Math.min(mTextWrapScale, mActualScale);
        setZoomScale(newScale, true, true);
        // ---------- Original Method ----------
        //boolean zoomIn = (mTextWrapScale - mActualScale) < .1f;
        //mDoubleTapZoomFactor = doubleTapZoom / 100.0f;
        //mTextWrapScale = getReadingLevelScale();
        //float newScale = zoomIn ? mTextWrapScale
                //: Math.min(mTextWrapScale, mActualScale);
        //setZoomScale(newScale, true, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.053 -0400", hash_original_method = "D0144FE074B01386F16EF11E861F0A7A", hash_generated_method = "3ED3B3EF59DDA41A05F70209A28E5415")
    public void refreshZoomScale(boolean reflowText) {
        setZoomScale(mActualScale, reflowText, true);
        addTaint(reflowText);
        // ---------- Original Method ----------
        //setZoomScale(mActualScale, reflowText, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.069 -0400", hash_original_method = "0CAC496E58068B9E4E1CC3313C83A17E", hash_generated_method = "ABBD1C09825DB3293B64FAE66D5319DD")
    public void setZoomScale(float scale, boolean reflowText) {
        setZoomScale(scale, reflowText, false);
        addTaint(scale);
        addTaint(reflowText);
        // ---------- Original Method ----------
        //setZoomScale(scale, reflowText, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.074 -0400", hash_original_method = "3A85AAAB95D1CDF586170EB3BBF2667E", hash_generated_method = "B31EAD807A4B48A297E552580373D61D")
    private void setZoomScale(float scale, boolean reflowText, boolean force) {
        boolean isScaleLessThanMinZoom;
        isScaleLessThanMinZoom = scale < mMinZoomScale;
        scale = computeScaleWithLimits(scale);
        {
            mInZoomOverview = true;
        } //End block
        {
            mInZoomOverview = !exceedsMinScaleIncrement(scale, getZoomOverviewScale());
        } //End block
        {
            boolean var859A3BA800EA204466595DBA45E17C4C_2046125707 = (reflowText && !mWebView.getSettings().getUseFixedViewport());
            {
                mTextWrapScale = scale;
            } //End block
        } //End collapsed parenthetic
        {
            float oldScale;
            oldScale = mActualScale;
            float oldInvScale;
            oldInvScale = mInvActualScale;
            {
                mCallbackProxy.onScaleChanged(mActualScale, scale);
            } //End block
            mActualScale = scale;
            mInvActualScale = 1 / scale;
            {
                boolean varA5B0FB0FE0ADFA061475ED90B3BD6BB4_297429583 = (!mWebView.drawHistory() && !mInHWAcceleratedZoom);
                {
                    int oldX;
                    oldX = mWebView.getScrollX();
                    int oldY;
                    oldY = mWebView.getScrollY();
                    float ratio;
                    ratio = scale * oldInvScale;
                    float sx;
                    sx = ratio * oldX + (ratio - 1) * mZoomCenterX;
                    float sy;
                    sy = ratio * oldY + (ratio - 1)
                        * (mZoomCenterY - mWebView.getTitleHeight());
                    mWebView.mViewManager.scaleAll();
                    int scrollX;
                    scrollX = mWebView.pinLocX(Math.round(sx));
                    int scrollY;
                    scrollY = mWebView.pinLocY(Math.round(sy));
                    {
                        boolean var7404FC6FD99FB1C9740DD855B950B383_403423990 = (!mWebView.updateScrollCoordinates(scrollX, scrollY));
                        {
                            mWebView.sendOurVisibleRect();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            mWebView.sendViewSizeZoom(reflowText);
        } //End block
        addTaint(reflowText);
        addTaint(force);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.074 -0400", hash_original_method = "6C9BE8F81CD8D5D51E25813EE62B3846", hash_generated_method = "1F097C85F8A501DE33D5C8D8EEC57CE7")
    public boolean isDoubleTapEnabled() {
        WebSettings settings;
        settings = mWebView.getSettings();
        boolean var0E4816D8885F200857E0CD3978D0DEC6_1225981803 = (settings != null && settings.getUseWideViewPort());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1077561590 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1077561590;
        // ---------- Original Method ----------
        //WebSettings settings = mWebView.getSettings();
        //return settings != null && settings.getUseWideViewPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.085 -0400", hash_original_method = "4C79B03AF1323FEB3700FE89F15D8B06", hash_generated_method = "841F9116C65A436D28258F02B4A0F666")
    public void handleDoubleTap(float lastTouchX, float lastTouchY) {
        mInitialZoomOverview = false;
        WebSettings settings;
        settings = mWebView.getSettings();
        {
            boolean var39CBEA45FB0B576C23AA565BDB2049CF_1025740531 = (!isDoubleTapEnabled());
        } //End collapsed parenthetic
        setZoomCenter(lastTouchX, lastTouchY);
        mAnchorX = mWebView.viewToContentX((int) lastTouchX + mWebView.getScrollX());
        mAnchorY = mWebView.viewToContentY((int) lastTouchY + mWebView.getScrollY());
        settings.setDoubleTapToastCount(0);
        dismissZoomPicker();
        Rect pluginBounds;
        pluginBounds = mWebView.getPluginBounds(mAnchorX, mAnchorY);
        {
            {
                boolean var2DE6C60989B3AB3DFD602BE4B0F3FAF8_1741326704 = (mWebView.isRectFitOnScreen(pluginBounds));
                {
                    zoomToOverview();
                } //End block
                {
                    mWebView.centerFitRect(pluginBounds);
                } //End block
            } //End collapsed parenthetic
        } //End block
        float newTextWrapScale;
        {
            boolean varE234C0D200CB3A9FD7D0051550B809BC_106118213 = (settings.getUseFixedViewport());
            {
                newTextWrapScale = Math.max(mActualScale, getReadingLevelScale());
            } //End block
            {
                newTextWrapScale = mActualScale;
            } //End block
        } //End collapsed parenthetic
        boolean firstTimeReflow;
        firstTimeReflow = !exceedsMinScaleIncrement(mActualScale, mTextWrapScale);
        {
            mTextWrapScale = newTextWrapScale;
        } //End block
        {
            boolean varE776BBB08B55EA07333E779A20E76DF6_1260236173 = (settings.isNarrowColumnLayout()
                && exceedsMinScaleIncrement(mTextWrapScale, newTextWrapScale)
                && !firstTimeReflow
                && !mInZoomOverview);
            {
                mTextWrapScale = newTextWrapScale;
                refreshZoomScale(true);
            } //End block
            {
                boolean var12B421A3A3971D1660F0A5E98DF868FE_1254683135 = (!mInZoomOverview && willScaleTriggerZoom(getZoomOverviewScale()));
                {
                    {
                        boolean varAD4F5B5601E26CC9DE285E4995249A79_2034246698 = (mTextWrapScale > getReadingLevelScale());
                        {
                            mTextWrapScale = getReadingLevelScale();
                            refreshZoomScale(true);
                        } //End block
                    } //End collapsed parenthetic
                    zoomToOverview();
                } //End block
                {
                    zoomToReadingLevelOrMore();
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.087 -0400", hash_original_method = "712C22BAE7AA3B12B6A5A40165B58905", hash_generated_method = "E492D18B389D4439CB6B05ECAFB3EF8C")
    private void setZoomOverviewWidth(int width) {
        {
            mZoomOverviewWidth = WebView.DEFAULT_VIEWPORT_WIDTH;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.087 -0400", hash_original_method = "B42D229ABB1FC24C49B118C5D42DFED9", hash_generated_method = "E2D2FF93555FD8086BF5D544CE688976")
     float getZoomOverviewScale() {
        float varC68098F3B3A8CF52938B6BE93874939F_347602960 = (mWebView.getViewWidth() * mInvZoomOverviewWidth);
        float var546ADE640B6EDFBC8A086EF31347E768_1503844012 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1503844012;
        // ---------- Original Method ----------
        //return mWebView.getViewWidth() * mInvZoomOverviewWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.087 -0400", hash_original_method = "C49CAD609BC6A273DA434DC912742003", hash_generated_method = "5360633F4934950665AED2C3B68349D9")
    public boolean isInZoomOverview() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2079643620 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2079643620;
        // ---------- Original Method ----------
        //return mInZoomOverview;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.104 -0400", hash_original_method = "C0C0965039A172A5A5AAF6C9C4472D2A", hash_generated_method = "4E4C557D8A31664B306A1077DD39F61F")
    private void zoomToOverview() {
        int scrollY;
        scrollY = mWebView.getScrollY();
        {
            boolean varA858D0DF98219C81D8899CE9E1439021_309005599 = (scrollY < mWebView.getTitleHeight());
            {
                mWebView.updateScrollCoordinates(mWebView.getScrollX(), 0);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.109 -0400", hash_original_method = "6051F287C8BD349D628462D7AA7CF8A8", hash_generated_method = "6CC7625295AC63396168204B2B36FFD8")
    private void zoomToReadingLevelOrMore() {
        float zoomScale;
        zoomScale = Math.max(getReadingLevelScale(),
                mActualScale + MIN_DOUBLE_TAP_SCALE_INCREMENT);
        int left;
        left = mWebView.nativeGetBlockLeftEdge(mAnchorX, mAnchorY, mActualScale);
        {
            int viewLeft;
            viewLeft = mWebView.contentToViewX(left < 5 ? 0 : (left - 5))
                    - mWebView.getScrollX();//DSFIXME:  CODE0008: Nested ternary operator in expression
            {
                mZoomCenterX = viewLeft * zoomScale / (zoomScale - mActualScale);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.111 -0400", hash_original_method = "77E44A3E983371F616079D37D03C3B6C", hash_generated_method = "3C683946DECB1AA76D8704D63DA4B014")
    public void updateMultiTouchSupport(Context context) {
        WebSettings settings;
        settings = mWebView.getSettings();
        PackageManager pm;
        pm = context.getPackageManager();
        mSupportMultiTouch = 
                (pm.hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH)
                 || pm.hasSystemFeature(PackageManager.FEATURE_FAKETOUCH_MULTITOUCH_DISTINCT))
                && settings.supportZoom() && settings.getBuiltInZoomControls();
        mAllowPanAndScale =
                pm.hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT)
                || pm.hasSystemFeature(PackageManager.FEATURE_FAKETOUCH_MULTITOUCH_DISTINCT);
        {
            mScaleDetector = new ScaleGestureDetector(context, new ScaleDetectorListener());
        } //End block
        {
            mScaleDetector = null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.111 -0400", hash_original_method = "D759966F5D5714E0336F491E3EEDC527", hash_generated_method = "7BC23512105AD55ADC2CE52C82FA6DAC")
    public boolean supportsMultiTouchZoom() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1081202395 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1081202395;
        // ---------- Original Method ----------
        //return mSupportMultiTouch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.112 -0400", hash_original_method = "E2CDCD424944BF66C1EED756BC88611C", hash_generated_method = "23E7517CE821D993A357FCD42068D95E")
    public boolean supportsPanDuringZoom() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1196743040 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1196743040;
        // ---------- Original Method ----------
        //return mAllowPanAndScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.112 -0400", hash_original_method = "DB3FE2513664456015F767E0971235E8", hash_generated_method = "497A69C63F544FFC00CE7051C36CCBB4")
    public boolean isPreventingWebkitUpdates() {
        boolean var539C6BCA16155491BB47B574D6ADAA7D_352121278 = (isZoomAnimating());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1660702274 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1660702274;
        // ---------- Original Method ----------
        //return isZoomAnimating();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.127 -0400", hash_original_method = "D6F4E788215219485BF912038215831B", hash_generated_method = "0146D5138CA73E2E7F0095CAB6ED9577")
    public ScaleGestureDetector getMultiTouchGestureDetector() {
        ScaleGestureDetector varB4EAC82CA7396A68D541C85D26508E83_403275717 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_403275717 = mScaleDetector;
        varB4EAC82CA7396A68D541C85D26508E83_403275717.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_403275717;
        // ---------- Original Method ----------
        //return mScaleDetector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.128 -0400", hash_original_method = "CAC2F3D27B1973D4CF70D4BE09DB9479", hash_generated_method = "7C118E70A2207B852F5B7D0CD3C06F4D")
    public void onSizeChanged(int w, int h, int ow, int oh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varC6631ED5D3F259446C8414A3C535806A_1075754903 = (!isFixedLengthAnimationInProgress());
            {
                int visibleTitleHeight;
                visibleTitleHeight = mWebView.getVisibleTitleHeight();
                mZoomCenterX = 0;
                mZoomCenterY = visibleTitleHeight;
                mAnchorX = mWebView.viewToContentX(mWebView.getScrollX());
                mAnchorY = mWebView.viewToContentY(visibleTitleHeight + mWebView.getScrollY());
            } //End block
        } //End collapsed parenthetic
        {
            mMinZoomScale = Math.min(1.0f, (float) mWebView.getViewWidth()
                    / (mWebView.drawHistory() ? mWebView.getHistoryPictureWidth()
                            : mZoomOverviewWidth));
            {
                mMinZoomScale = mInitialScale;
            } //End block
        } //End block
        dismissZoomPicker();
        mWebView.post(new PostScale(w != ow &&
            !mWebView.getSettings().getUseFixedViewport(), mInZoomOverview, w < ow));
        addTaint(w);
        addTaint(h);
        addTaint(ow);
        addTaint(oh);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.129 -0400", hash_original_method = "853C20600470FB7106E8D67215AF9147", hash_generated_method = "657A883C84C0854CD5349CF6918B8BE8")
    public void updateZoomRange(WebViewCore.ViewState viewState,
            int viewWidth, int minPrefWidth) {
        {
            {
                {
                    boolean varEADFD9CA65629F47D38E6EBD32772CB6_123527613 = (minPrefWidth > Math.max(0, viewWidth));
                    {
                        mMinZoomScale = (float) viewWidth / minPrefWidth;
                        mMinZoomScaleFixed = false;
                    } //End block
                    {
                        mMinZoomScale = viewState.mDefaultScale;
                        mMinZoomScaleFixed = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                mMinZoomScale = mDefaultMinZoomScale;
                mMinZoomScaleFixed = false;
            } //End block
        } //End block
        {
            mMinZoomScale = viewState.mMinScale;
            mMinZoomScaleFixed = true;
        } //End block
        {
            mMaxZoomScale = mDefaultMaxZoomScale;
        } //End block
        {
            mMaxZoomScale = viewState.mMaxScale;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.150 -0400", hash_original_method = "30705697D50ADB9D51B01BF1D1A7F736", hash_generated_method = "C0694A73376B1BE4E61EBD95140DD3DC")
    public void onNewPicture(WebViewCore.DrawData drawData) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int viewWidth;
        viewWidth = mWebView.getViewWidth();
        boolean zoomOverviewWidthChanged;
        zoomOverviewWidthChanged = setupZoomOverviewWidth(drawData, viewWidth);
        float newZoomOverviewScale;
        newZoomOverviewScale = getZoomOverviewScale();
        WebSettings settings;
        settings = mWebView.getSettings();
        {
            boolean var4FA725D625202F620E985DDF6FBC0A47_995316404 = (zoomOverviewWidthChanged && settings.isNarrowColumnLayout() &&
            settings.getUseFixedViewport() &&
            (mInitialZoomOverview || mInZoomOverview));
            {
                {
                    boolean varC029B731C62F8B1BF7CA9FB17B55FF95_565112090 = (exceedsMinScaleIncrement(mTextWrapScale, mDefaultScale) ||
                    exceedsMinScaleIncrement(newZoomOverviewScale, mDefaultScale));
                    {
                        mTextWrapScale = getReadingLevelScale();
                    } //End block
                    {
                        mTextWrapScale = newZoomOverviewScale;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varEDDADBFDAB93A3ADFCA53123BBF6AB92_1553028534 = (!mMinZoomScaleFixed || settings.getUseWideViewPort());
            {
                mMinZoomScale = newZoomOverviewScale;
                mMaxZoomScale = Math.max(mMaxZoomScale, mMinZoomScale);
            } //End block
        } //End collapsed parenthetic
        boolean scaleHasDiff;
        scaleHasDiff = exceedsMinScaleIncrement(newZoomOverviewScale, mActualScale);
        boolean scaleLessThanOverview;
        scaleLessThanOverview = (newZoomOverviewScale - mActualScale) >= MINIMUM_SCALE_INCREMENT;
        boolean mobileSiteInOverview;
        mobileSiteInOverview = mInZoomOverview &&
                !exceedsMinScaleIncrement(newZoomOverviewScale, mDefaultScale);
        {
            boolean varFFB204A70D7C076155163881EAF6A9DF_389107987 = (!mWebView.drawHistory() &&
            ((scaleLessThanOverview && settings.getUseWideViewPort())||
                ((mInitialZoomOverview || mobileSiteInOverview) &&
                    scaleHasDiff && zoomOverviewWidthChanged)));
            {
                mInitialZoomOverview = false;
                setZoomScale(newZoomOverviewScale, !willScaleTriggerZoom(mTextWrapScale) &&
                !mWebView.getSettings().getUseFixedViewport());
            } //End block
            {
                mInZoomOverview = !scaleHasDiff;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBAB1EB72F6CEBD20753D79FB108C2220_1330659860 = (drawData.mFirstLayoutForNonStandardLoad && settings.getLoadWithOverviewMode());
            {
                mInitialZoomOverview = mInZoomOverview;
            } //End block
        } //End collapsed parenthetic
        addTaint(drawData.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.153 -0400", hash_original_method = "74FCB7875112FE9C3AB647C4DB8DEDB6", hash_generated_method = "2938735758606020F9CCED3C7A22E357")
    private boolean setupZoomOverviewWidth(WebViewCore.DrawData drawData, final int viewWidth) {
        WebSettings settings;
        settings = mWebView.getSettings();
        int newZoomOverviewWidth;
        newZoomOverviewWidth = mZoomOverviewWidth;
        {
            boolean varBFDE20206CCD6D6A45C02520E4553355_655948927 = (settings.getUseWideViewPort());
            {
                {
                    newZoomOverviewWidth = Math.min(WebView.sMaxViewportWidth,
                    drawData.mContentSize.x);
                } //End block
            } //End block
            {
                newZoomOverviewWidth = Math.round(viewWidth / mDefaultScale);
            } //End block
        } //End collapsed parenthetic
        {
            setZoomOverviewWidth(newZoomOverviewWidth);
        } //End block
        addTaint(drawData.getTaint());
        addTaint(viewWidth);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_802738515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_802738515;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.155 -0400", hash_original_method = "49A97AD028E7397E6545CF950CBFEBF3", hash_generated_method = "BA8432F55763B49B49C93494D078D504")
    public void onFirstLayout(WebViewCore.DrawData drawData) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        WebViewCore.ViewState viewState;
        viewState = drawData.mViewState;
        Point viewSize;
        viewSize = drawData.mViewSize;
        updateZoomRange(viewState, viewSize.x, drawData.mMinPrefWidth);
        setupZoomOverviewWidth(drawData, mWebView.getViewWidth());
        float overviewScale;
        overviewScale = getZoomOverviewScale();
        WebSettings settings;
        settings = mWebView.getSettings();
        {
            boolean varEDDADBFDAB93A3ADFCA53123BBF6AB92_1226283999 = (!mMinZoomScaleFixed || settings.getUseWideViewPort());
            {
                mMinZoomScale = (mInitialScale > 0) ?
                    Math.min(mInitialScale, overviewScale) : overviewScale;
                mMaxZoomScale = Math.max(mMaxZoomScale, mMinZoomScale);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var72CDC5681BBA9EF2F7C0725FEF71FE87_1777630149 = (!mWebView.drawHistory());
            {
                float scale;
                {
                    scale = mInitialScale;
                } //End block
                {
                    scale = (viewState.mViewScale > 0)
                    ? viewState.mViewScale : overviewScale;
                    mTextWrapScale = (viewState.mTextWrapScale > 0)
                    ? viewState.mTextWrapScale : getReadingLevelScale();
                } //End block
                {
                    scale = overviewScale;
                    {
                        boolean var12EE9A7356F197091F1FCC2C2762EE57_365800871 = (!settings.getUseWideViewPort()
                    || !settings.getLoadWithOverviewMode());
                        {
                            scale = Math.max(mDefaultScale, scale);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var8AAAF8A664E23A6D3AFCADC2A850C15A_114270036 = (settings.isNarrowColumnLayout() &&
                    settings.getUseFixedViewport());
                        {
                            mTextWrapScale = getReadingLevelScale();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                boolean reflowText;
                reflowText = false;
                {
                    {
                        boolean var05F160112893383CE2E2D0B7BAA522D8_1635229768 = (settings.getUseFixedViewport());
                        {
                            scale = Math.max(scale, overviewScale);
                            mTextWrapScale = Math.max(mTextWrapScale, overviewScale);
                        } //End block
                    } //End collapsed parenthetic
                    reflowText = exceedsMinScaleIncrement(mTextWrapScale, scale);
                } //End block
                mInitialZoomOverview = settings.getLoadWithOverviewMode() &&
                    !exceedsMinScaleIncrement(scale, overviewScale);
                setZoomScale(scale, reflowText);
                updateZoomPicker();
            } //End block
        } //End collapsed parenthetic
        addTaint(drawData.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.156 -0400", hash_original_method = "E88F50435C2D2101D935E91DFBA371A3", hash_generated_method = "A042A7A5C53948E2AFB8A24A55152711")
    public void saveZoomState(Bundle b) {
        b.putFloat("scale", mActualScale);
        b.putFloat("textwrapScale", mTextWrapScale);
        b.putBoolean("overview", mInZoomOverview);
        addTaint(b.getTaint());
        // ---------- Original Method ----------
        //b.putFloat("scale", mActualScale);
        //b.putFloat("textwrapScale", mTextWrapScale);
        //b.putBoolean("overview", mInZoomOverview);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.157 -0400", hash_original_method = "CEABBB6E3216B8D1034C16D61ED63443", hash_generated_method = "EBABD371F461EB1D455CA9348748325C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.174 -0400", hash_original_method = "03F547EF9A141661565AD38656124362", hash_generated_method = "A7CA73341478A17F7EB961E8E0CA7426")
    private ZoomControlBase getCurrentZoomControl() {
        ZoomControlBase varB4EAC82CA7396A68D541C85D26508E83_1392751247 = null; //Variable for return #1
        ZoomControlBase varB4EAC82CA7396A68D541C85D26508E83_951164523 = null; //Variable for return #2
        ZoomControlBase varB4EAC82CA7396A68D541C85D26508E83_970129430 = null; //Variable for return #3
        {
            boolean var83F1D2F4A6B5EE964613A457830A6BDF_227451314 = (mWebView.getSettings() != null && mWebView.getSettings().supportZoom());
            {
                {
                    boolean var1BC924BA3C63EFE4CEFE0945D6BE1E67_248167680 = (mWebView.getSettings().getBuiltInZoomControls());
                    {
                        {
                            boolean var1598C98885536FE583B80D8148180FBD_1518107852 = ((mEmbeddedZoomControl == null)
                        && mWebView.getSettings().getDisplayZoomControls());
                            {
                                mEmbeddedZoomControl = new ZoomControlEmbedded(this, mWebView);
                            } //End block
                        } //End collapsed parenthetic
                        varB4EAC82CA7396A68D541C85D26508E83_1392751247 = mEmbeddedZoomControl;
                    } //End block
                    {
                        {
                            mExternalZoomControl = new ZoomControlExternal(mWebView);
                        } //End block
                        varB4EAC82CA7396A68D541C85D26508E83_951164523 = mExternalZoomControl;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_970129430 = null;
        ZoomControlBase varA7E53CE21691AB073D9660D615818899_44094345; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_44094345 = varB4EAC82CA7396A68D541C85D26508E83_1392751247;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_44094345 = varB4EAC82CA7396A68D541C85D26508E83_951164523;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_44094345 = varB4EAC82CA7396A68D541C85D26508E83_970129430;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_44094345.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_44094345;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.175 -0400", hash_original_method = "BF64B2CEB07538AA62EA00039BB48680", hash_generated_method = "5679DED4F43BB1F4D8FBD7C4F3DE9810")
    public void invokeZoomPicker() {
        ZoomControlBase control;
        control = getCurrentZoomControl();
        {
            control.show();
        } //End block
        // ---------- Original Method ----------
        //ZoomControlBase control = getCurrentZoomControl();
        //if (control != null) {
            //control.show();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.184 -0400", hash_original_method = "0CAEEFDB341BFD4D4CACBFA479A18F98", hash_generated_method = "949470795B924B7155E04B37E54372D4")
    public void dismissZoomPicker() {
        ZoomControlBase control;
        control = getCurrentZoomControl();
        {
            control.hide();
        } //End block
        // ---------- Original Method ----------
        //ZoomControlBase control = getCurrentZoomControl();
        //if (control != null) {
            //control.hide();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.184 -0400", hash_original_method = "DA055704D86885A7F9C5B74974CF851B", hash_generated_method = "8AE1294D0BB10AD55C1515C06AD47874")
    public boolean isZoomPickerVisible() {
        ZoomControlBase control;
        control = getCurrentZoomControl();
        {
            Object var90D3359E5D07B295D570F6A9F5B367E9_2143636027 = (control.isVisible());
        } //End flattened ternary
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_640098267 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_640098267;
        // ---------- Original Method ----------
        //ZoomControlBase control = getCurrentZoomControl();
        //return (control != null) ? control.isVisible() : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.185 -0400", hash_original_method = "A8AE3510E280FF5955731B404A0A66EC", hash_generated_method = "1B4F458A6B062182C49F459CED4C2034")
    public void updateZoomPicker() {
        ZoomControlBase control;
        control = getCurrentZoomControl();
        {
            control.update();
        } //End block
        // ---------- Original Method ----------
        //ZoomControlBase control = getCurrentZoomControl();
        //if (control != null) {
            //control.update();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.185 -0400", hash_original_method = "65E0B786CE90103F5573BC67CE254CE7", hash_generated_method = "C51021626D75B73C99277EA9C208BA9D")
    public void keepZoomPickerVisible() {
        ZoomControlBase control;
        control = getCurrentZoomControl();
        {
            control.show();
        } //End block
        // ---------- Original Method ----------
        //ZoomControlBase control = getCurrentZoomControl();
        //if (control != null && control == mExternalZoomControl) {
            //control.show();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.186 -0400", hash_original_method = "295B8076F41B8CC3FCA3F323BF66F29B", hash_generated_method = "A7EAF0E6A2A2C5DA1CF99EE3A36AF1DB")
    public View getExternalZoomPicker() {
        View varB4EAC82CA7396A68D541C85D26508E83_687426461 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_668021714 = null; //Variable for return #2
        ZoomControlBase control;
        control = getCurrentZoomControl();
        {
            varB4EAC82CA7396A68D541C85D26508E83_687426461 = mExternalZoomControl.getControls();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_668021714 = null;
        } //End block
        View varA7E53CE21691AB073D9660D615818899_2069483392; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2069483392 = varB4EAC82CA7396A68D541C85D26508E83_687426461;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2069483392 = varB4EAC82CA7396A68D541C85D26508E83_668021714;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2069483392.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2069483392;
        // ---------- Original Method ----------
        //ZoomControlBase control = getCurrentZoomControl();
        //if (control != null && control == mExternalZoomControl) {
            //return mExternalZoomControl.getControls();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.186 -0400", hash_original_method = "8D458CBEFE5B6426DEF9072097FF3245", hash_generated_method = "9ADC4F4CBEDBCA89924A04F25DE685B9")
    public void setHardwareAccelerated() {
        mHardwareAccelerated = true;
        // ---------- Original Method ----------
        //mHardwareAccelerated = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.186 -0400", hash_original_method = "35BF52CFA65A672FC707BA33DDD071E9", hash_generated_method = "900BB4A97EADB0A4DEA6EBCB26A097C3")
     void onPageFinished(String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mInitialZoomOverview = false;
        addTaint(url.getTaint());
        // ---------- Original Method ----------
        //mInitialZoomOverview = false;
    }

    
    private class FocusMovementQueue {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.186 -0400", hash_original_field = "2D043F2822EC0D4E2690BDFE63EDDFCA", hash_generated_field = "9639A8B64144BF72B06D4F02EACB0012")

        private float[] mQueue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.186 -0400", hash_original_field = "BACF4F47646DA9E5EF6C6786F47B387A", hash_generated_field = "5C3922C5E22E6E8A5927016DED3BACFE")

        private float mSum;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.186 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

        private int mSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.186 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "B8B828CADFFAE7A5A771AAB7A1527A20")

        private int mIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.201 -0400", hash_original_method = "C2CA3F4962FE0D524626245DAD0C9DD6", hash_generated_method = "D4AF6BA17545ED20E2FFAFBAF09FD153")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.203 -0400", hash_original_method = "7BD5EC8FD84F966DA50367EA866227AA", hash_generated_method = "B0BC1E7CD84A9D85BF739DF8776D1957")
        private void clear() {
            mSize = 0;
            mSum = 0;
            mIndex = 0;
            {
                int i;
                i = 0;
                {
                    mQueue[i] = 0;
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //mSize = 0;
            //mSum = 0;
            //mIndex = 0;
            //for (int i = 0; i < QUEUE_CAPACITY; ++i) {
                //mQueue[i] = 0;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.204 -0400", hash_original_method = "BEA568413C11D502CA7CED6FD222D059", hash_generated_method = "E09B726BE53BDEE657056A6D7361163B")
        private void add(float focusDelta) {
            mSum += focusDelta;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.204 -0400", hash_original_method = "D980EABC4C0F2D2A081289A0764FD494", hash_generated_method = "2D9A29823C1AD786315DD2620318F04B")
        private float getSum() {
            float var546ADE640B6EDFBC8A086EF31347E768_1675058578 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1675058578;
            // ---------- Original Method ----------
            //return mSum;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.204 -0400", hash_original_field = "68D6C106EA24FD5D1E9A33FE112A82F8", hash_generated_field = "816E9AC8C498BC8480A2123524172281")

        private static int QUEUE_CAPACITY = 5;
    }


    
    private class ScaleDetectorListener implements ScaleGestureDetector.OnScaleGestureListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.204 -0400", hash_original_field = "09CF021BF536BAB6C30DC7BBD1177879", hash_generated_field = "D9620ED126995C2A7FCE1BBDF87310E8")

        private float mAccumulatedSpan;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.204 -0400", hash_original_method = "BA46F3652F41E17982BE025D7A95EDE2", hash_generated_method = "BA46F3652F41E17982BE025D7A95EDE2")
        public ScaleDetectorListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.205 -0400", hash_original_method = "9075B37C27A1752EF4C1C0179D09116C", hash_generated_method = "5A50AAB0DD725696879E53FE3ED8A1E6")
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mInitialZoomOverview = false;
            dismissZoomPicker();
            mFocusMovementQueue.clear();
            mFocusX = detector.getFocusX();
            mFocusY = detector.getFocusY();
            mWebView.mViewManager.startZoom();
            mWebView.onPinchToZoomAnimationStart();
            mAccumulatedSpan = 0;
            addTaint(detector.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_363944084 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_363944084;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.206 -0400", hash_original_method = "B0E9BE71CCDF607A4C10071A1E309D43", hash_generated_method = "ED082B3B822F6506C4011AF999BA8E2B")
        public boolean isPanningOnly(ScaleGestureDetector detector) {
            float prevFocusX;
            prevFocusX = mFocusX;
            float prevFocusY;
            prevFocusY = mFocusY;
            mFocusX = detector.getFocusX();
            mFocusY = detector.getFocusY();
            float focusDelta;
            focusDelta = 0;
            focusDelta = FloatMath.sqrt((mFocusX - prevFocusX) * (mFocusX - prevFocusX)
                                   + (mFocusY - prevFocusY) * (mFocusY - prevFocusY));
            mFocusMovementQueue.add(focusDelta);
            float deltaSpan;
            deltaSpan = detector.getCurrentSpan() - detector.getPreviousSpan() +
                    mAccumulatedSpan;
            boolean result;
            result = mFocusMovementQueue.getSum() > Math.abs(deltaSpan);
            {
                mAccumulatedSpan += deltaSpan;
            } //End block
            {
                mAccumulatedSpan = 0;
            } //End block
            addTaint(detector.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_42573329 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_42573329;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.218 -0400", hash_original_method = "69F2A7AC5DBED7E3BD0F18F39CE3A7B5", hash_generated_method = "FE0B0B29DE1A5641D926C5BE5DE34F74")
        public boolean handleScale(ScaleGestureDetector detector) {
            float scale;
            scale = detector.getScaleFactor() * mActualScale;
            boolean isScaleLimited;
            isScaleLimited = isScaleOverLimits(scale) || scale < getZoomOverviewScale();
            scale = Math.max(computeScaleWithLimits(scale), getZoomOverviewScale());
            {
                boolean var8FA38A898D1233C0012F264478AD7276_100769483 = (mPinchToZoomAnimating || willScaleTriggerZoom(scale));
                {
                    mPinchToZoomAnimating = true;
                    {
                        scale = Math.min(scale, mActualScale * 1.25f);
                    } //End block
                    {
                        scale = Math.max(scale, mActualScale * 0.8f);
                    } //End block
                    scale = computeScaleWithLimits(scale);
                    {
                        boolean varC4DEEA06E814A1944DC8A9A5323D1750_1046354825 = (Math.abs(scale - mActualScale) < MINIMUM_SCALE_WITHOUT_JITTER);
                    } //End collapsed parenthetic
                    setZoomCenter(detector.getFocusX(), detector.getFocusY());
                    setZoomScale(scale, false);
                    mWebView.invalidate();
                } //End block
            } //End collapsed parenthetic
            addTaint(detector.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_449341902 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_449341902;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.219 -0400", hash_original_method = "ED0E7724FBEBB5F90A0828B68DD48F69", hash_generated_method = "73374CBF9F17D840DDCA622D17CE6A83")
        public boolean onScale(ScaleGestureDetector detector) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varD3734ED0B6DF1B041CFFE69F64B7AFEF_215509501 = (isPanningOnly(detector) || handleScale(detector));
                {
                    mFocusMovementQueue.clear();
                } //End block
            } //End collapsed parenthetic
            addTaint(detector.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_848185271 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_848185271;
            // ---------- Original Method ----------
            //if (isPanningOnly(detector) || handleScale(detector)) {
                //mFocusMovementQueue.clear();
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.220 -0400", hash_original_method = "8B2C3B6F263B86181A105DF4C3A0ECE1", hash_generated_method = "036AECE304DE4FF22566AC6E619894F0")
        public void onScaleEnd(ScaleGestureDetector detector) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                mPinchToZoomAnimating = false;
                mAnchorX = mWebView.viewToContentX((int) mZoomCenterX + mWebView.getScrollX());
                mAnchorY = mWebView.viewToContentY((int) mZoomCenterY + mWebView.getScrollY());
                boolean reflowNow;
                reflowNow = !canZoomOut() || (mActualScale <= 0.8 * mTextWrapScale);
                refreshZoomScale(reflowNow &&
                    !mWebView.getSettings().getUseFixedViewport());
                mWebView.invalidate();
            } //End block
            mWebView.mViewManager.endZoom();
            mWebView.onPinchToZoomAnimationEnd(detector);
            addTaint(detector.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.220 -0400", hash_original_field = "FF619880DF50315F5F0C23464FCB91F9", hash_generated_field = "77CA9D980A43549CDA68DE3DCA6626A5")

        boolean mUpdateTextWrap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.220 -0400", hash_original_field = "3C0CE17CA283A7A032FB13C4CF5E9947", hash_generated_field = "CFCDFC51582F4CFE0A0F368B7A789B49")

        boolean mInZoomOverviewBeforeSizeChange;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.220 -0400", hash_original_field = "91FECCF530559D322CF17336F85F2461", hash_generated_field = "885926B4FFFBA16CECCAF1A99F0266F9")

        boolean mInPortraitMode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.220 -0400", hash_original_method = "987305C98B26834A8CB0058E5C6D93E2", hash_generated_method = "3399CCB2C3E7BA10E96510C264203349")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.231 -0400", hash_original_method = "713D19A11600F821B2CA1C17235BF1BC", hash_generated_method = "E6375E258F83810AA2A14602831719BB")
        public void run() {
            {
                boolean var0A3519DF8335FF3D7078A97FDBC9E3B4_802604185 = (mWebView.getWebViewCore() != null);
                {
                    float newScale;
                    newScale = mActualScale;
                    {
                        boolean var1DF8C58DD41F9A4D3D32DEAC17429D28_960696100 = (mWebView.getSettings().getUseWideViewPort() &&
                    mInPortraitMode &&
                    mInZoomOverviewBeforeSizeChange);
                        {
                            newScale = getZoomOverviewScale();
                        } //End block
                    } //End collapsed parenthetic
                    setZoomScale(newScale, mUpdateTextWrap, true);
                    updateZoomPicker();
                } //End block
            } //End collapsed parenthetic
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.231 -0400", hash_original_field = "0DB0A8D0024C30F56EDCF3AFB02E533D", hash_generated_field = "2BBEAF55F1E918AC3904E93D39813997")

    static String LOGTAG = "webviewZoom";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.231 -0400", hash_original_field = "824864C5654B72A6B9F5576381E885DA", hash_generated_field = "C5534AC879FEE84A2D5A41EFA3D72823")

    protected static float DEFAULT_MAX_ZOOM_SCALE_FACTOR = 4.00f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.231 -0400", hash_original_field = "3F514FF5D0C7CF1AF261334CC5737B03", hash_generated_field = "22C5D36242EFCC90BCE9D83F33481F81")

    protected static float DEFAULT_MIN_ZOOM_SCALE_FACTOR = 0.25f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.231 -0400", hash_original_field = "12D317062A7ECE5FD7C63AA57A6DC326", hash_generated_field = "D8861706BAFD8699E50F90FBCF998F7D")

    private static float MIN_DOUBLE_TAP_SCALE_INCREMENT = 0.5f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.231 -0400", hash_original_field = "CC4756180A7EFB1D163EEE2302021E77", hash_generated_field = "9312CAAED499DB8E5F33CA8B59A623F5")

    private static float MINIMUM_SCALE_INCREMENT = 0.007f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.231 -0400", hash_original_field = "2B07A398287AE320F54A1B32AD3EEDC5", hash_generated_field = "3CC1005C93624AF917078598F90C5E0D")

    private static float MINIMUM_SCALE_WITHOUT_JITTER = 0.007f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.231 -0400", hash_original_field = "4061CBCD4A8CBAAAAFDB40A970FAA7C8", hash_generated_field = "01394E231D049449E5526E28D8CE294C")

    private static int ZOOM_ANIMATION_LENGTH = 175;
}

