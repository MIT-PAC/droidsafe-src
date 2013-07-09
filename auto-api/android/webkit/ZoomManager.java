package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.256 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.256 -0400", hash_original_field = "957B64C4FA99E51BCE1B62690725D115", hash_generated_field = "62789CA10670C708EA4D387AB18C5F89")

    private CallbackProxy mCallbackProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.256 -0400", hash_original_field = "34902BF967D867A8C3F4CC4010B6E9EF", hash_generated_field = "2DA301B6F95E0EBE97AB103E0F47F9F3")

    private ZoomControlEmbedded mEmbeddedZoomControl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.256 -0400", hash_original_field = "3E28AE1D93462FA1E7D90F056B0F6E1D", hash_generated_field = "E1828D795EA501C93F7B7AE52E32EC0D")

    private ZoomControlExternal mExternalZoomControl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.256 -0400", hash_original_field = "62F3D783B3687CBC0BDB448D90E58278", hash_generated_field = "A75525F777409EAE64A30A85B5ECCBE1")

    private float mDefaultMaxZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.256 -0400", hash_original_field = "8B4997D60CFE283F65068FB0529E4498", hash_generated_field = "52C961320D37FAE0F1AE675CFD1F2BEC")

    private float mDefaultMinZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.256 -0400", hash_original_field = "B473A45F09A23AD2B870CF185D4AA12A", hash_generated_field = "49153CC81AC659E75C57042122CE79CA")

    private float mMaxZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.256 -0400", hash_original_field = "DA19E9676D629B1D45B511C2C1DBDFAB", hash_generated_field = "62544A60744E4E06A4BB732A37B9A75D")

    private float mMinZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.256 -0400", hash_original_field = "49ED4F15B76F494F60E56C2FAEDC5E89", hash_generated_field = "0045D4254134E122CD3AF4AD2A34AE42")

    private boolean mMinZoomScaleFixed = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.256 -0400", hash_original_field = "C5AEF7F4CDDDA63B17EDCA58C1930701", hash_generated_field = "0ED10F26046E2B869A9993F37463D665")

    private boolean mInitialZoomOverview = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.256 -0400", hash_original_field = "998C898FF1863528EFFAB397B8821943", hash_generated_field = "D1063DF321563D8E711FE2915CC13ED6")

    private boolean mInZoomOverview = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.256 -0400", hash_original_field = "13DBB97D624EFD6C45C1709D4D77E1AC", hash_generated_field = "EEF381E8DFAB0F8AFA6DED39CA509D69")

    private int mZoomOverviewWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.256 -0400", hash_original_field = "77077C98D8D725F541F44258326BEA3C", hash_generated_field = "789EB22FC445F5CF4578A1B705BCFD89")

    private float mInvZoomOverviewWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.256 -0400", hash_original_field = "57681D2E7F65B2999AC6DB0157119FFE", hash_generated_field = "73D88F8A1B8C24D1E753BDF66C353FE4")

    private float mZoomCenterX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.256 -0400", hash_original_field = "7BA53A17CCE52B938AB36A19D2D5212D", hash_generated_field = "0905DF24D370C5BABA5C5316D621064E")

    private float mZoomCenterY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.256 -0400", hash_original_field = "A0FE7B7E6572E9A5C03F808D583D21EF", hash_generated_field = "9E3ECCCE67853EF67D401BC85D54FCDD")

    private float mFocusX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "E371837A8119A3AB321FC558BC169293", hash_generated_field = "E01C42CAE2152A2827127C5E1618E0BF")

    private float mFocusY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "87008528F20CC5552B26DB443AC74F67", hash_generated_field = "7AE666B3B95EE2A25725DEE0E0FF8D16")

    private FocusMovementQueue mFocusMovementQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "E7657EDDA986C0D1CC052B8F112FE09D", hash_generated_field = "5F8E058F09826A27700241950A47C51E")

    private int mAnchorX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "87FAE44598E10061776ABA72BF200D70", hash_generated_field = "D3B700F3BB8B795E0ADFEB729C0AE646")

    private int mAnchorY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "3190B9F88CD9ECBDD0CF99CE8D1E0B89", hash_generated_field = "1B5C7663299982C5C7D3FB1CDE2DE612")

    private float mTextWrapScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "F3150A42E04B25673AB01D2C041638C1", hash_generated_field = "2F8E15D8BE82ACCE0EB0157530F26BA2")

    private float mDefaultScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "F76A5E4401A0723AA5E56C29FBB9CF15", hash_generated_field = "403E94F468B3BDF8320A5058252C64CF")

    private float mInvDefaultScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "5CDFBEECE4C65AB1FD80F336D826A9B3", hash_generated_field = "6380DD00339CD0A77C6B25CB19413BC5")

    private float mDisplayDensity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "25E6113202D6CFE1096DA97DA85A393C", hash_generated_field = "35F9B21E3F5F564C990231A1E5CD959C")

    private float mDoubleTapZoomFactor = 1.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "2BD1064E1316AB3431CD233A2DB36D76", hash_generated_field = "EC2D05F087E31D17947841E32358DEC1")

    private float mActualScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "E3D71FEA20B9D8C04A31631606259011", hash_generated_field = "C3F4C4AE5E1BA7A43BA1DC26150BBCED")

    private float mInvActualScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "1D77D2432E524838ACFF4200A870280D", hash_generated_field = "86487DADE4014C689CAFFA37B4818AF4")

    private float mInitialScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "9D28FB72937787644389F529B4276C55", hash_generated_field = "D8F7937535B71ED52FE04BF51381C2E3")

    private float mZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "F5674EF1AB117AA2DB1AAA75A63E4275", hash_generated_field = "DFE1ED1EDAC53623D5358E45BF3F4EBD")

    private float mInvInitialZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "F0D6ED4FFDAF5496002ADD1B08B462FE", hash_generated_field = "424DF48095CC98F0B236E854F4E43A2D")

    private float mInvFinalZoomScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "A2854BA31136A2F81EC6577AEBE1E664", hash_generated_field = "B116C55D4B4D66EE153F454CBA568BE6")

    private int mInitialScrollX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "557FEBE80E5593717A34985067D77EF0", hash_generated_field = "E57D614FBFE0B9BAA23984CC3E7AD606")

    private int mInitialScrollY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "FD4D0FB807AF66279DB4B8659BAA63C5", hash_generated_field = "CCF37C49798D869F18D246B6747FFF61")

    private long mZoomStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "5C62F021E531A91F9743205810E9E171", hash_generated_field = "17F95B8381C48D81ED3F070ABC618EA0")

    private boolean mSupportMultiTouch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "C0A50D2FDF7098353277E4B1046F8BCE", hash_generated_field = "9B444A6905DBFA8226D34C0732D3C33C")

    private boolean mAllowPanAndScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "A0F3C25877DFCDC03E45221E32A4656A", hash_generated_field = "0C270CE12B813847261F32665B4317E0")

    private ScaleGestureDetector mScaleDetector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "65635DB64810CB34B0C3240333C5CD95", hash_generated_field = "45DDE0467059E4D71CD5528DE7734AFC")

    private boolean mPinchToZoomAnimating = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "94CB263926656D6FE605610741F6C504", hash_generated_field = "80FDB96634A8A83890141751180EF1B9")

    private boolean mHardwareAccelerated = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.257 -0400", hash_original_field = "502FB9866E2BA595DDCE2A31361DD0CD", hash_generated_field = "F44E8E20A0C3B070FDDA9A2AECAA2700")

    private boolean mInHWAcceleratedZoom = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.258 -0400", hash_original_method = "C53EE2007D9BEC2FE01EA607CD54C4FF", hash_generated_method = "0190DB67F1A6601D594EAB9FDB61EC8B")
    public  ZoomManager(WebView webView, CallbackProxy callbackProxy) {
        mWebView = webView;
        mCallbackProxy = callbackProxy;
        setZoomOverviewWidth(WebView.DEFAULT_VIEWPORT_WIDTH);
        mFocusMovementQueue = new FocusMovementQueue();
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.258 -0400", hash_original_method = "93CFAAB8556EE96135ADFFE4D2689C29", hash_generated_method = "BAE942C36681C49C4BCAA7C766AB89E9")
    public void init(float density) {
        mDisplayDensity = density;
        setDefaultZoomScale(density);
        mActualScale = density;
        mInvActualScale = 1 / density;
        mTextWrapScale = getReadingLevelScale();
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.258 -0400", hash_original_method = "2EFEEBFBDE6ACF8543350ABFFB008A8F", hash_generated_method = "EE0014DE728835F3C077DA6EAEA43A1A")
    public void updateDefaultZoomDensity(float density) {
        {
            boolean var55986BB94FD10BB61A37151F90F17CA6_850951958 = (Math.abs(density - mDefaultScale) > MINIMUM_SCALE_INCREMENT);
            {
                final float originalDefault = mDefaultScale;
                setDefaultZoomScale(density);
                float scaleChange;
                scaleChange = density / originalDefault;
                scaleChange = 1.0f;
                setZoomScale(mActualScale * scaleChange, true);
            } 
        } 
        addTaint(density);
        
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.259 -0400", hash_original_method = "E8BCC867B6D8CCFABF539A9D95032C95", hash_generated_method = "02E6A5884AF0011D067C180464E46F59")
    private void setDefaultZoomScale(float defaultScale) {
        final float originalDefault = mDefaultScale;
        mDefaultScale = defaultScale;
        mInvDefaultScale = 1 / defaultScale;
        mDefaultMaxZoomScale = defaultScale * DEFAULT_MAX_ZOOM_SCALE_FACTOR;
        mDefaultMinZoomScale = defaultScale * DEFAULT_MIN_ZOOM_SCALE_FACTOR;
        {
            mMaxZoomScale = defaultScale / originalDefault * mMaxZoomScale;
        } 
        {
            mMaxZoomScale = mDefaultMaxZoomScale;
        } 
        {
            mMinZoomScale = defaultScale / originalDefault * mMinZoomScale;
        } 
        {
            mMinZoomScale = mDefaultMinZoomScale;
        } 
        {
            boolean varD4A51976EA74EEAE11BCC79328DC7589_532919382 = (!exceedsMinScaleIncrement(mMinZoomScale, mMaxZoomScale));
            {
                mMaxZoomScale = mMinZoomScale;
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.259 -0400", hash_original_method = "E0A7D63CBE7BA22AE5FD1D2BCFACA30A", hash_generated_method = "D5EC324C046F18413A12DACBFA55AD86")
    public final float getScale() {
        float var546ADE640B6EDFBC8A086EF31347E768_441616645 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_441616645;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.260 -0400", hash_original_method = "27B2B7D16269E37341CA9CE429E50BD4", hash_generated_method = "1A1ED66E17D92EAC4C7486034BE150B6")
    public final float getInvScale() {
        float var546ADE640B6EDFBC8A086EF31347E768_378375291 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_378375291;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.260 -0400", hash_original_method = "420B51415ADFBA4739EC66A8F732263C", hash_generated_method = "C21C6A0D63B8326DAA71AEE9EA135C57")
    public final float getTextWrapScale() {
        float var546ADE640B6EDFBC8A086EF31347E768_1796501863 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1796501863;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.261 -0400", hash_original_method = "4D84680032231769C697659C881951E3", hash_generated_method = "9F9CBE13EA963755B1860160FF59D5CA")
    public final float getMaxZoomScale() {
        float var546ADE640B6EDFBC8A086EF31347E768_398220159 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_398220159;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.261 -0400", hash_original_method = "EF101FB82D6E625D2F7286BB14442128", hash_generated_method = "09C670BC14748F49A221B5D981AAB801")
    public final float getMinZoomScale() {
        float var546ADE640B6EDFBC8A086EF31347E768_324240166 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_324240166;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.262 -0400", hash_original_method = "C9287BA17A965D05EE45D11D20F2D047", hash_generated_method = "A914A3D47690D626C992D58CFFF98369")
    public final float getDefaultScale() {
        float var546ADE640B6EDFBC8A086EF31347E768_1518316941 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1518316941;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.262 -0400", hash_original_method = "B68BBC34F3F5ADBA444AF11F55B159F2", hash_generated_method = "DA8A1CAB9C31D21454B04A55B3ED027C")
    public final float getReadingLevelScale() {
        float var546ADE640B6EDFBC8A086EF31347E768_1493834507 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1493834507;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.262 -0400", hash_original_method = "150923628532607A08D5A6F81E7006FE", hash_generated_method = "B6DAE307CD10D4C4B76DC455992A0C0C")
    public final float getInvDefaultScale() {
        float var546ADE640B6EDFBC8A086EF31347E768_1090054713 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1090054713;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.262 -0400", hash_original_method = "86C1C61E20B5F864D06602058822F40B", hash_generated_method = "E202B6774BF4A983F9052355ACD746EB")
    public final float getDefaultMaxZoomScale() {
        float var546ADE640B6EDFBC8A086EF31347E768_168056370 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_168056370;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.263 -0400", hash_original_method = "68697F997D536A00F27515B45D68169D", hash_generated_method = "78E71A2952C4A6627E28320F0997B3FB")
    public final float getDefaultMinZoomScale() {
        float var546ADE640B6EDFBC8A086EF31347E768_1836529632 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1836529632;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.263 -0400", hash_original_method = "0D1E90BA2B32E85CA9E1B47821E3129C", hash_generated_method = "F50373870231A0FCE00A6993C25DB74A")
    public final int getDocumentAnchorX() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_794601295 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_794601295;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.263 -0400", hash_original_method = "6F8EAB28E274BDE9903F29B52FA3CE08", hash_generated_method = "F7342E8DE3A2A6A40C29408DBDF38505")
    public final int getDocumentAnchorY() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202649500 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202649500;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.263 -0400", hash_original_method = "37EC19EE8D577B9FFE8E8612EB136E0D", hash_generated_method = "0979E863D08CE670AE5057D10C3B3325")
    public final void clearDocumentAnchor() {
        mAnchorX = mAnchorY = 0;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.264 -0400", hash_original_method = "B42B83C0DB8155DA229557A2BD45C477", hash_generated_method = "376A60C9AA8D31A1B7B25334BE2AA077")
    public final void setZoomCenter(float x, float y) {
        mZoomCenterX = x;
        mZoomCenterY = y;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.264 -0400", hash_original_method = "E17C2AED3C2D9DCFE2D098E038948EA1", hash_generated_method = "C3C51A8EAC82BA7545BE75E4A35DC3DA")
    public final void setInitialScaleInPercent(int scaleInPercent) {
        mInitialScale = scaleInPercent * 0.01f;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.264 -0400", hash_original_method = "CACC1DB3C5C8FBE689456F981994723C", hash_generated_method = "1657C4391460C3EE92FA953939EC5032")
    public final float computeScaleWithLimits(float scale) {
        {
            scale = mMinZoomScale;
        } 
        {
            scale = mMaxZoomScale;
        } 
        addTaint(scale);
        float var546ADE640B6EDFBC8A086EF31347E768_13222031 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_13222031;
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.265 -0400", hash_original_method = "49E88837FC0437D5B36C3DDB131811B0", hash_generated_method = "B09066F91B5217FE3F4CC294FFFFE2ED")
    public final boolean isScaleOverLimits(float scale) {
        addTaint(scale);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_824524245 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_824524245;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.268 -0400", hash_original_method = "EAE2E4FAF7045B63798AAD0EC191C138", hash_generated_method = "E9F6A2910543FC0EE4F76D70E1FE1290")
    public final boolean isZoomScaleFixed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1635522009 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1635522009;
        
        
    }

    
    public static final boolean exceedsMinScaleIncrement(float scaleA, float scaleB) {
        return Math.abs(scaleA - scaleB) >= MINIMUM_SCALE_INCREMENT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.269 -0400", hash_original_method = "73353D5825B74E55208D73C06ED7146E", hash_generated_method = "638A9E227CD3BEDEF3A5540CB9A7105E")
    public boolean willScaleTriggerZoom(float scale) {
        boolean var6A4063C36BF43452312B6B8657DF0783_806436459 = (exceedsMinScaleIncrement(scale, mActualScale));
        addTaint(scale);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_97106194 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_97106194;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.269 -0400", hash_original_method = "577BAEA37EC580D2471F28E52ACC3E90", hash_generated_method = "D26729C5B5C6873FFB7209C354606A89")
    public final boolean canZoomIn() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1799408054 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1799408054;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.270 -0400", hash_original_method = "82D91A91E65D0066AFB31608B5056133", hash_generated_method = "B082BC4148D9152B8182667FDB6DF1CC")
    public final boolean canZoomOut() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_833378509 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_833378509;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.270 -0400", hash_original_method = "1087ACA9FDE3F82506A02D8DB9B3B812", hash_generated_method = "407CD295574A61787CE2D169FA8D5926")
    public boolean zoomIn() {
        boolean var1D72A61B00F4DC9B0382B92DAC1773A6_637968721 = (zoom(1.25f));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2030939059 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2030939059;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.270 -0400", hash_original_method = "AF303514C2CE6EE62014ED1CD988BE8F", hash_generated_method = "6D092BB2C2AE22E0A396726A75535D0F")
    public boolean zoomOut() {
        boolean var3CF167EA70562DB2BA335E1A998DD456_1922140006 = (zoom(0.8f));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1556008052 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1556008052;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.271 -0400", hash_original_method = "0D06D835317E38A4890F08EB962517B9", hash_generated_method = "5591EADBF5ACCA276A0D541E0E334C71")
    private boolean zoom(float zoomMultiplier) {
        mInitialZoomOverview = false;
        mWebView.switchOutDrawHistory();
        mZoomCenterX = mWebView.getViewWidth() * .5f;
        mZoomCenterY = mWebView.getViewHeight() * .5f;
        mAnchorX = mWebView.viewToContentX((int) mZoomCenterX + mWebView.getScrollX());
        mAnchorY = mWebView.viewToContentY((int) mZoomCenterY + mWebView.getScrollY());
        boolean var90FBEB34589F56F8A92EA96C08461924_114986485 = (startZoomAnimation(mActualScale * zoomMultiplier, 
            !mWebView.getSettings().getUseFixedViewport()));
        addTaint(zoomMultiplier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_466577508 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_466577508;
        
        
        
        
        
        
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.271 -0400", hash_original_method = "ABA8C6E97A9C369182835D6347EB12CF", hash_generated_method = "6164BDCE746563A58F17F3C3B9869F11")
    public boolean startZoomAnimation(float scale, boolean reflowText) {
        mInitialZoomOverview = false;
        float oldScale = mActualScale;
        mInitialScrollX = mWebView.getScrollX();
        mInitialScrollY = mWebView.getScrollY();
        {
            boolean var654B16B46C4BC96AA00B68D2DF42FCA3_636512783 = (!exceedsMinScaleIncrement(scale, getReadingLevelScale()));
            {
                scale = getReadingLevelScale();
            } 
        } 
        {
            mInHWAcceleratedZoom = true;
        } 
        setZoomScale(scale, reflowText);
        {
            mZoomStart = SystemClock.uptimeMillis();
            mInvInitialZoomScale = 1.0f / oldScale;
            mInvFinalZoomScale = 1.0f / mActualScale;
            mZoomScale = mActualScale;
            mWebView.onFixedLengthZoomAnimationStart();
            mWebView.invalidate();
        } 
        addTaint(scale);
        addTaint(reflowText);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_938089675 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_938089675;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.274 -0400", hash_original_method = "4B2E3C5C63E13C95ACA7AA346AD0833D", hash_generated_method = "DF9E8B44995C083F228601E87A17BB27")
    public void animateZoom(Canvas canvas) {
        mInitialZoomOverview = false;
        float zoomScale;
        int interval = (int) (SystemClock.uptimeMillis() - mZoomStart);
        {
            float ratio = (float) interval / ZOOM_ANIMATION_LENGTH;
            zoomScale = 1.0f / (mInvInitialZoomScale
                    + (mInvFinalZoomScale - mInvInitialZoomScale) * ratio);
            mWebView.invalidate();
        } 
        {
            zoomScale = mZoomScale;
            mZoomScale = 0;
            mWebView.onFixedLengthZoomAnimationEnd();
        } 
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
        {
            mWebView.updateScrollCoordinates(mWebView.getScrollX() - tx, mWebView.getScrollY() - ty);
            canvas.translate(tx, ty);
            setZoomScale(zoomScale, false);
            {
                mInHWAcceleratedZoom = false;
                mWebView.sendViewSizeZoom(false);
            } 
        } 
        {
            canvas.translate(tx, ty);
            canvas.scale(zoomScale, zoomScale);
        } 
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.275 -0400", hash_original_method = "E0C5EE754D896EBEA19BF99FCF86359E", hash_generated_method = "77D2D84961198B900539BA8D1CED2935")
    public boolean isZoomAnimating() {
        boolean var68B3C139DA5F66F80A809EBC4526A9C7_592387138 = (isFixedLengthAnimationInProgress() || mPinchToZoomAnimating);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1314934320 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1314934320;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.275 -0400", hash_original_method = "351373D4552618F4F14C898A250D84BD", hash_generated_method = "05EA89778366553292C25136D7FB6756")
    public boolean isFixedLengthAnimationInProgress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1075137011 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1075137011;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.276 -0400", hash_original_method = "38BADAFCA13DD410DF65C206538CBBC7", hash_generated_method = "C671DFAEE149ACC997BA94DDACE078F2")
    public void updateDoubleTapZoom(int doubleTapZoom) {
        boolean zoomIn = (mTextWrapScale - mActualScale) < .1f;
        mDoubleTapZoomFactor = doubleTapZoom / 100.0f;
        mTextWrapScale = getReadingLevelScale();
        float newScale;
        newScale = mTextWrapScale;
        newScale = Math.min(mTextWrapScale, mActualScale);
        setZoomScale(newScale, true, true);
        
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.276 -0400", hash_original_method = "D0144FE074B01386F16EF11E861F0A7A", hash_generated_method = "3ED3B3EF59DDA41A05F70209A28E5415")
    public void refreshZoomScale(boolean reflowText) {
        setZoomScale(mActualScale, reflowText, true);
        addTaint(reflowText);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.276 -0400", hash_original_method = "0CAC496E58068B9E4E1CC3313C83A17E", hash_generated_method = "ABBD1C09825DB3293B64FAE66D5319DD")
    public void setZoomScale(float scale, boolean reflowText) {
        setZoomScale(scale, reflowText, false);
        addTaint(scale);
        addTaint(reflowText);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.277 -0400", hash_original_method = "3A85AAAB95D1CDF586170EB3BBF2667E", hash_generated_method = "0ABB9AEC59C088EDCF8A49785A9AB802")
    private void setZoomScale(float scale, boolean reflowText, boolean force) {
        final boolean isScaleLessThanMinZoom = scale < mMinZoomScale;
        scale = computeScaleWithLimits(scale);
        {
            mInZoomOverview = true;
        } 
        {
            mInZoomOverview = !exceedsMinScaleIncrement(scale, getZoomOverviewScale());
        } 
        {
            boolean var859A3BA800EA204466595DBA45E17C4C_134379979 = (reflowText && !mWebView.getSettings().getUseFixedViewport());
            {
                mTextWrapScale = scale;
            } 
        } 
        {
            float oldScale = mActualScale;
            float oldInvScale = mInvActualScale;
            {
                mCallbackProxy.onScaleChanged(mActualScale, scale);
            } 
            mActualScale = scale;
            mInvActualScale = 1 / scale;
            {
                boolean varA5B0FB0FE0ADFA061475ED90B3BD6BB4_2077674345 = (!mWebView.drawHistory() && !mInHWAcceleratedZoom);
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
                    {
                        boolean var7404FC6FD99FB1C9740DD855B950B383_1974175427 = (!mWebView.updateScrollCoordinates(scrollX, scrollY));
                        {
                            mWebView.sendOurVisibleRect();
                        } 
                    } 
                } 
            } 
            mWebView.sendViewSizeZoom(reflowText);
        } 
        addTaint(reflowText);
        addTaint(force);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.278 -0400", hash_original_method = "6C9BE8F81CD8D5D51E25813EE62B3846", hash_generated_method = "5A975B38A923D611674F0A1971C171AA")
    public boolean isDoubleTapEnabled() {
        WebSettings settings = mWebView.getSettings();
        boolean var0E4816D8885F200857E0CD3978D0DEC6_1210181980 = (settings != null && settings.getUseWideViewPort());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_995827656 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_995827656;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.278 -0400", hash_original_method = "4C79B03AF1323FEB3700FE89F15D8B06", hash_generated_method = "B7617285749A6636360EEE51397AE7DC")
    public void handleDoubleTap(float lastTouchX, float lastTouchY) {
        mInitialZoomOverview = false;
        WebSettings settings = mWebView.getSettings();
        {
            boolean var39CBEA45FB0B576C23AA565BDB2049CF_626179252 = (!isDoubleTapEnabled());
        } 
        setZoomCenter(lastTouchX, lastTouchY);
        mAnchorX = mWebView.viewToContentX((int) lastTouchX + mWebView.getScrollX());
        mAnchorY = mWebView.viewToContentY((int) lastTouchY + mWebView.getScrollY());
        settings.setDoubleTapToastCount(0);
        dismissZoomPicker();
        Rect pluginBounds = mWebView.getPluginBounds(mAnchorX, mAnchorY);
        {
            {
                boolean var2DE6C60989B3AB3DFD602BE4B0F3FAF8_1279124024 = (mWebView.isRectFitOnScreen(pluginBounds));
                {
                    zoomToOverview();
                } 
                {
                    mWebView.centerFitRect(pluginBounds);
                } 
            } 
        } 
        float newTextWrapScale;
        {
            boolean varE234C0D200CB3A9FD7D0051550B809BC_663077183 = (settings.getUseFixedViewport());
            {
                newTextWrapScale = Math.max(mActualScale, getReadingLevelScale());
            } 
            {
                newTextWrapScale = mActualScale;
            } 
        } 
        final boolean firstTimeReflow = !exceedsMinScaleIncrement(mActualScale, mTextWrapScale);
        {
            mTextWrapScale = newTextWrapScale;
        } 
        {
            boolean varE776BBB08B55EA07333E779A20E76DF6_103380116 = (settings.isNarrowColumnLayout()
                && exceedsMinScaleIncrement(mTextWrapScale, newTextWrapScale)
                && !firstTimeReflow
                && !mInZoomOverview);
            {
                mTextWrapScale = newTextWrapScale;
                refreshZoomScale(true);
            } 
            {
                boolean var12B421A3A3971D1660F0A5E98DF868FE_1667015783 = (!mInZoomOverview && willScaleTriggerZoom(getZoomOverviewScale()));
                {
                    {
                        boolean varAD4F5B5601E26CC9DE285E4995249A79_1504938221 = (mTextWrapScale > getReadingLevelScale());
                        {
                            mTextWrapScale = getReadingLevelScale();
                            refreshZoomScale(true);
                        } 
                    } 
                    zoomToOverview();
                } 
                {
                    zoomToReadingLevelOrMore();
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.279 -0400", hash_original_method = "712C22BAE7AA3B12B6A5A40165B58905", hash_generated_method = "E492D18B389D4439CB6B05ECAFB3EF8C")
    private void setZoomOverviewWidth(int width) {
        {
            mZoomOverviewWidth = WebView.DEFAULT_VIEWPORT_WIDTH;
        } 
        {
            mZoomOverviewWidth = width;
        } 
        mInvZoomOverviewWidth = 1.0f / width;
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.279 -0400", hash_original_method = "B42D229ABB1FC24C49B118C5D42DFED9", hash_generated_method = "7DFDF9C33F6C980A97C4101C5AF96504")
     float getZoomOverviewScale() {
        float varC68098F3B3A8CF52938B6BE93874939F_2003744699 = (mWebView.getViewWidth() * mInvZoomOverviewWidth);
        float var546ADE640B6EDFBC8A086EF31347E768_923322534 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_923322534;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.279 -0400", hash_original_method = "C49CAD609BC6A273DA434DC912742003", hash_generated_method = "4F7C67884648DB6AB780745A34A3E28A")
    public boolean isInZoomOverview() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1898966063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1898966063;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.279 -0400", hash_original_method = "C0C0965039A172A5A5AAF6C9C4472D2A", hash_generated_method = "88A8E4FA67AF23F655FDC22FB821B3A2")
    private void zoomToOverview() {
        int scrollY = mWebView.getScrollY();
        {
            boolean varA858D0DF98219C81D8899CE9E1439021_571582625 = (scrollY < mWebView.getTitleHeight());
            {
                mWebView.updateScrollCoordinates(mWebView.getScrollX(), 0);
            } 
        } 
        startZoomAnimation(getZoomOverviewScale(), 
            !mWebView.getSettings().getUseFixedViewport());
        
        
        
            
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.280 -0400", hash_original_method = "6051F287C8BD349D628462D7AA7CF8A8", hash_generated_method = "057F9997985C19E22B45ECD7E3AA87F8")
    private void zoomToReadingLevelOrMore() {
        final float zoomScale = Math.max(getReadingLevelScale(),
                mActualScale + MIN_DOUBLE_TAP_SCALE_INCREMENT);
        int left = mWebView.nativeGetBlockLeftEdge(mAnchorX, mAnchorY, mActualScale);
        {
            int viewLeft = mWebView.contentToViewX(left < 5 ? 0 : (left - 5))
                    - mWebView.getScrollX();
            {
                mZoomCenterX = viewLeft * zoomScale / (zoomScale - mActualScale);
            } 
            {
                mWebView.scrollBy(viewLeft, 0);
                mZoomCenterX = 0;
            } 
        } 
        startZoomAnimation(zoomScale,
            !mWebView.getSettings().getUseFixedViewport());
        
        
                
        
        
            
                    
            
                
            
                
                
            
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.281 -0400", hash_original_method = "77E44A3E983371F616079D37D03C3B6C", hash_generated_method = "FE05CD1212981E7C01AA218DC99943D9")
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
        {
            mScaleDetector = new ScaleGestureDetector(context, new ScaleDetectorListener());
        } 
        {
            mScaleDetector = null;
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.281 -0400", hash_original_method = "D759966F5D5714E0336F491E3EEDC527", hash_generated_method = "39FB25FD05D6ABD54B2DFFAE3A1D216C")
    public boolean supportsMultiTouchZoom() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_803494184 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_803494184;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.282 -0400", hash_original_method = "E2CDCD424944BF66C1EED756BC88611C", hash_generated_method = "3276C9A9F63C925373A14A7BB5175C2E")
    public boolean supportsPanDuringZoom() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_537150634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_537150634;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.282 -0400", hash_original_method = "DB3FE2513664456015F767E0971235E8", hash_generated_method = "021843F3AF968BB847C3DA47BB0A2FB0")
    public boolean isPreventingWebkitUpdates() {
        boolean var539C6BCA16155491BB47B574D6ADAA7D_118970138 = (isZoomAnimating());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1464776547 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1464776547;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.283 -0400", hash_original_method = "D6F4E788215219485BF912038215831B", hash_generated_method = "139AA1DE6924D4D2F8B830B680B120EE")
    public ScaleGestureDetector getMultiTouchGestureDetector() {
        ScaleGestureDetector varB4EAC82CA7396A68D541C85D26508E83_1799685815 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1799685815 = mScaleDetector;
        varB4EAC82CA7396A68D541C85D26508E83_1799685815.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1799685815;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.285 -0400", hash_original_method = "CAC2F3D27B1973D4CF70D4BE09DB9479", hash_generated_method = "781D85A74C589AC42619FDD3061C813E")
    public void onSizeChanged(int w, int h, int ow, int oh) {
        
        {
            boolean varC6631ED5D3F259446C8414A3C535806A_2047062612 = (!isFixedLengthAnimationInProgress());
            {
                int visibleTitleHeight = mWebView.getVisibleTitleHeight();
                mZoomCenterX = 0;
                mZoomCenterY = visibleTitleHeight;
                mAnchorX = mWebView.viewToContentX(mWebView.getScrollX());
                mAnchorY = mWebView.viewToContentY(visibleTitleHeight + mWebView.getScrollY());
            } 
        } 
        {
            mMinZoomScale = Math.min(1.0f, (float) mWebView.getViewWidth()
                    / (mWebView.drawHistory() ? mWebView.getHistoryPictureWidth()
                            : mZoomOverviewWidth));
            {
                mMinZoomScale = mInitialScale;
            } 
        } 
        dismissZoomPicker();
        mWebView.post(new PostScale(w != ow &&
            !mWebView.getSettings().getUseFixedViewport(), mInZoomOverview, w < ow));
        addTaint(w);
        addTaint(h);
        addTaint(ow);
        addTaint(oh);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.285 -0400", hash_original_method = "853C20600470FB7106E8D67215AF9147", hash_generated_method = "64CD9E69A25C6ADE54965463F6CB4536")
    public void updateZoomRange(WebViewCore.ViewState viewState,
            int viewWidth, int minPrefWidth) {
        {
            {
                {
                    boolean varEADFD9CA65629F47D38E6EBD32772CB6_163485674 = (minPrefWidth > Math.max(0, viewWidth));
                    {
                        mMinZoomScale = (float) viewWidth / minPrefWidth;
                        mMinZoomScaleFixed = false;
                    } 
                    {
                        mMinZoomScale = viewState.mDefaultScale;
                        mMinZoomScaleFixed = true;
                    } 
                } 
            } 
            {
                mMinZoomScale = mDefaultMinZoomScale;
                mMinZoomScaleFixed = false;
            } 
        } 
        {
            mMinZoomScale = viewState.mMinScale;
            mMinZoomScaleFixed = true;
        } 
        {
            mMaxZoomScale = mDefaultMaxZoomScale;
        } 
        {
            mMaxZoomScale = viewState.mMaxScale;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.286 -0400", hash_original_method = "30705697D50ADB9D51B01BF1D1A7F736", hash_generated_method = "3227DBA6C070C929511C47B632748D71")
    public void onNewPicture(WebViewCore.DrawData drawData) {
        
        final int viewWidth = mWebView.getViewWidth();
        final boolean zoomOverviewWidthChanged = setupZoomOverviewWidth(drawData, viewWidth);
        final float newZoomOverviewScale = getZoomOverviewScale();
        WebSettings settings = mWebView.getSettings();
        {
            boolean var4FA725D625202F620E985DDF6FBC0A47_714106363 = (zoomOverviewWidthChanged && settings.isNarrowColumnLayout() &&
            settings.getUseFixedViewport() &&
            (mInitialZoomOverview || mInZoomOverview));
            {
                {
                    boolean varC029B731C62F8B1BF7CA9FB17B55FF95_817551086 = (exceedsMinScaleIncrement(mTextWrapScale, mDefaultScale) ||
                    exceedsMinScaleIncrement(newZoomOverviewScale, mDefaultScale));
                    {
                        mTextWrapScale = getReadingLevelScale();
                    } 
                    {
                        mTextWrapScale = newZoomOverviewScale;
                    } 
                } 
            } 
        } 
        {
            boolean varEDDADBFDAB93A3ADFCA53123BBF6AB92_1793985515 = (!mMinZoomScaleFixed || settings.getUseWideViewPort());
            {
                mMinZoomScale = newZoomOverviewScale;
                mMaxZoomScale = Math.max(mMaxZoomScale, mMinZoomScale);
            } 
        } 
        boolean scaleHasDiff = exceedsMinScaleIncrement(newZoomOverviewScale, mActualScale);
        boolean scaleLessThanOverview = (newZoomOverviewScale - mActualScale) >= MINIMUM_SCALE_INCREMENT;
        boolean mobileSiteInOverview = mInZoomOverview &&
                !exceedsMinScaleIncrement(newZoomOverviewScale, mDefaultScale);
        {
            boolean varFFB204A70D7C076155163881EAF6A9DF_781957050 = (!mWebView.drawHistory() &&
            ((scaleLessThanOverview && settings.getUseWideViewPort())||
                ((mInitialZoomOverview || mobileSiteInOverview) &&
                    scaleHasDiff && zoomOverviewWidthChanged)));
            {
                mInitialZoomOverview = false;
                setZoomScale(newZoomOverviewScale, !willScaleTriggerZoom(mTextWrapScale) &&
                !mWebView.getSettings().getUseFixedViewport());
            } 
            {
                mInZoomOverview = !scaleHasDiff;
            } 
        } 
        {
            boolean varBAB1EB72F6CEBD20753D79FB108C2220_1132814221 = (drawData.mFirstLayoutForNonStandardLoad && settings.getLoadWithOverviewMode());
            {
                mInitialZoomOverview = mInZoomOverview;
            } 
        } 
        addTaint(drawData.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.287 -0400", hash_original_method = "74FCB7875112FE9C3AB647C4DB8DEDB6", hash_generated_method = "9190EBF5AFE75A83EAA4CBE87615B1C6")
    private boolean setupZoomOverviewWidth(WebViewCore.DrawData drawData, final int viewWidth) {
        WebSettings settings = mWebView.getSettings();
        int newZoomOverviewWidth = mZoomOverviewWidth;
        {
            boolean varBFDE20206CCD6D6A45C02520E4553355_1413352135 = (settings.getUseWideViewPort());
            {
                {
                    newZoomOverviewWidth = Math.min(WebView.sMaxViewportWidth,
                    drawData.mContentSize.x);
                } 
            } 
            {
                newZoomOverviewWidth = Math.round(viewWidth / mDefaultScale);
            } 
        } 
        {
            setZoomOverviewWidth(newZoomOverviewWidth);
        } 
        addTaint(drawData.getTaint());
        addTaint(viewWidth);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1389849756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1389849756;
        
        
        
        
            
                
                    
            
        
            
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.288 -0400", hash_original_method = "49A97AD028E7397E6545CF950CBFEBF3", hash_generated_method = "4E94B6E9E84CB05DB836AC8F736F8B9F")
    public void onFirstLayout(WebViewCore.DrawData drawData) {
        
        WebViewCore.ViewState viewState = drawData.mViewState;
        final Point viewSize = drawData.mViewSize;
        updateZoomRange(viewState, viewSize.x, drawData.mMinPrefWidth);
        setupZoomOverviewWidth(drawData, mWebView.getViewWidth());
        final float overviewScale = getZoomOverviewScale();
        WebSettings settings = mWebView.getSettings();
        {
            boolean varEDDADBFDAB93A3ADFCA53123BBF6AB92_1998613194 = (!mMinZoomScaleFixed || settings.getUseWideViewPort());
            {
                mMinZoomScale = (mInitialScale > 0) ?
                    Math.min(mInitialScale, overviewScale) : overviewScale;
                mMaxZoomScale = Math.max(mMaxZoomScale, mMinZoomScale);
            } 
        } 
        {
            boolean var72CDC5681BBA9EF2F7C0725FEF71FE87_1277200189 = (!mWebView.drawHistory());
            {
                float scale;
                {
                    scale = mInitialScale;
                } 
                {
                    scale = (viewState.mViewScale > 0)
                    ? viewState.mViewScale : overviewScale;
                    mTextWrapScale = (viewState.mTextWrapScale > 0)
                    ? viewState.mTextWrapScale : getReadingLevelScale();
                } 
                {
                    scale = overviewScale;
                    {
                        boolean var12EE9A7356F197091F1FCC2C2762EE57_163997701 = (!settings.getUseWideViewPort()
                    || !settings.getLoadWithOverviewMode());
                        {
                            scale = Math.max(mDefaultScale, scale);
                        } 
                    } 
                    {
                        boolean var8AAAF8A664E23A6D3AFCADC2A850C15A_1540676255 = (settings.isNarrowColumnLayout() &&
                    settings.getUseFixedViewport());
                        {
                            mTextWrapScale = getReadingLevelScale();
                        } 
                    } 
                } 
                boolean reflowText = false;
                {
                    {
                        boolean var05F160112893383CE2E2D0B7BAA522D8_344483339 = (settings.getUseFixedViewport());
                        {
                            scale = Math.max(scale, overviewScale);
                            mTextWrapScale = Math.max(mTextWrapScale, overviewScale);
                        } 
                    } 
                    reflowText = exceedsMinScaleIncrement(mTextWrapScale, scale);
                } 
                mInitialZoomOverview = settings.getLoadWithOverviewMode() &&
                    !exceedsMinScaleIncrement(scale, overviewScale);
                setZoomScale(scale, reflowText);
                updateZoomPicker();
            } 
        } 
        addTaint(drawData.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.288 -0400", hash_original_method = "E88F50435C2D2101D935E91DFBA371A3", hash_generated_method = "A042A7A5C53948E2AFB8A24A55152711")
    public void saveZoomState(Bundle b) {
        b.putFloat("scale", mActualScale);
        b.putFloat("textwrapScale", mTextWrapScale);
        b.putBoolean("overview", mInZoomOverview);
        addTaint(b.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.288 -0400", hash_original_method = "CEABBB6E3216B8D1034C16D61ED63443", hash_generated_method = "EBABD371F461EB1D455CA9348748325C")
    public void restoreZoomState(Bundle b) {
        mActualScale = b.getFloat("scale", 1.0f);
        mInvActualScale = 1 / mActualScale;
        mTextWrapScale = b.getFloat("textwrapScale", mActualScale);
        mInZoomOverview = b.getBoolean("overview");
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.289 -0400", hash_original_method = "03F547EF9A141661565AD38656124362", hash_generated_method = "AD3895C75740B7E40C8FC7479C1C03E1")
    private ZoomControlBase getCurrentZoomControl() {
        ZoomControlBase varB4EAC82CA7396A68D541C85D26508E83_1750642035 = null; 
        ZoomControlBase varB4EAC82CA7396A68D541C85D26508E83_1200952115 = null; 
        ZoomControlBase varB4EAC82CA7396A68D541C85D26508E83_1636412634 = null; 
        {
            boolean var83F1D2F4A6B5EE964613A457830A6BDF_497286807 = (mWebView.getSettings() != null && mWebView.getSettings().supportZoom());
            {
                {
                    boolean var1BC924BA3C63EFE4CEFE0945D6BE1E67_372919116 = (mWebView.getSettings().getBuiltInZoomControls());
                    {
                        {
                            boolean var1598C98885536FE583B80D8148180FBD_1268375179 = ((mEmbeddedZoomControl == null)
                        && mWebView.getSettings().getDisplayZoomControls());
                            {
                                mEmbeddedZoomControl = new ZoomControlEmbedded(this, mWebView);
                            } 
                        } 
                        varB4EAC82CA7396A68D541C85D26508E83_1750642035 = mEmbeddedZoomControl;
                    } 
                    {
                        {
                            mExternalZoomControl = new ZoomControlExternal(mWebView);
                        } 
                        varB4EAC82CA7396A68D541C85D26508E83_1200952115 = mExternalZoomControl;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1636412634 = null;
        ZoomControlBase varA7E53CE21691AB073D9660D615818899_148705879; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_148705879 = varB4EAC82CA7396A68D541C85D26508E83_1750642035;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_148705879 = varB4EAC82CA7396A68D541C85D26508E83_1200952115;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_148705879 = varB4EAC82CA7396A68D541C85D26508E83_1636412634;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_148705879.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_148705879;
        
        
            
                
                        
                    
                
                
            
                
                    
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.289 -0400", hash_original_method = "BF64B2CEB07538AA62EA00039BB48680", hash_generated_method = "EA945F604E2F1235971877E664A9BDEE")
    public void invokeZoomPicker() {
        ZoomControlBase control = getCurrentZoomControl();
        {
            control.show();
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.290 -0400", hash_original_method = "0CAEEFDB341BFD4D4CACBFA479A18F98", hash_generated_method = "49C2B103C58CDEF4D53F9FBA09FFB779")
    public void dismissZoomPicker() {
        ZoomControlBase control = getCurrentZoomControl();
        {
            control.hide();
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.290 -0400", hash_original_method = "DA055704D86885A7F9C5B74974CF851B", hash_generated_method = "12A768C3BE5BFE4204B2C939C31C5C87")
    public boolean isZoomPickerVisible() {
        ZoomControlBase control = getCurrentZoomControl();
        {
            Object var90D3359E5D07B295D570F6A9F5B367E9_1013396186 = (control.isVisible());
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_259422659 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_259422659;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.291 -0400", hash_original_method = "A8AE3510E280FF5955731B404A0A66EC", hash_generated_method = "8EB996D9DEF03D764011B98A7288C33E")
    public void updateZoomPicker() {
        ZoomControlBase control = getCurrentZoomControl();
        {
            control.update();
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.291 -0400", hash_original_method = "65E0B786CE90103F5573BC67CE254CE7", hash_generated_method = "A3E49AB0E3F06864E48F7E913D96D070")
    public void keepZoomPickerVisible() {
        ZoomControlBase control = getCurrentZoomControl();
        {
            control.show();
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.292 -0400", hash_original_method = "295B8076F41B8CC3FCA3F323BF66F29B", hash_generated_method = "B76190968617F96C4B7C44A7CC379F22")
    public View getExternalZoomPicker() {
        View varB4EAC82CA7396A68D541C85D26508E83_180251543 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_539931920 = null; 
        ZoomControlBase control = getCurrentZoomControl();
        {
            varB4EAC82CA7396A68D541C85D26508E83_180251543 = mExternalZoomControl.getControls();
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_539931920 = null;
        } 
        View varA7E53CE21691AB073D9660D615818899_1789284822; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1789284822 = varB4EAC82CA7396A68D541C85D26508E83_180251543;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1789284822 = varB4EAC82CA7396A68D541C85D26508E83_539931920;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1789284822.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1789284822;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.292 -0400", hash_original_method = "8D458CBEFE5B6426DEF9072097FF3245", hash_generated_method = "9ADC4F4CBEDBCA89924A04F25DE685B9")
    public void setHardwareAccelerated() {
        mHardwareAccelerated = true;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.292 -0400", hash_original_method = "35BF52CFA65A672FC707BA33DDD071E9", hash_generated_method = "900BB4A97EADB0A4DEA6EBCB26A097C3")
     void onPageFinished(String url) {
        
        mInitialZoomOverview = false;
        addTaint(url.getTaint());
        
        
    }

    
    private class FocusMovementQueue {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.293 -0400", hash_original_field = "2D043F2822EC0D4E2690BDFE63EDDFCA", hash_generated_field = "9639A8B64144BF72B06D4F02EACB0012")

        private float[] mQueue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.293 -0400", hash_original_field = "BACF4F47646DA9E5EF6C6786F47B387A", hash_generated_field = "5C3922C5E22E6E8A5927016DED3BACFE")

        private float mSum;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.293 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

        private int mSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.293 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "B8B828CADFFAE7A5A771AAB7A1527A20")

        private int mIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.293 -0400", hash_original_method = "C2CA3F4962FE0D524626245DAD0C9DD6", hash_generated_method = "D4AF6BA17545ED20E2FFAFBAF09FD153")
          FocusMovementQueue() {
            mQueue = new float[QUEUE_CAPACITY];
            mSize = 0;
            mSum = 0;
            mIndex = 0;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.294 -0400", hash_original_method = "7BD5EC8FD84F966DA50367EA866227AA", hash_generated_method = "A941726517A105A191383A5B9680D16C")
        private void clear() {
            mSize = 0;
            mSum = 0;
            mIndex = 0;
            {
                int i = 0;
                {
                    mQueue[i] = 0;
                } 
            } 
            
            
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.295 -0400", hash_original_method = "BEA568413C11D502CA7CED6FD222D059", hash_generated_method = "E09B726BE53BDEE657056A6D7361163B")
        private void add(float focusDelta) {
            mSum += focusDelta;
            {
                mSum -= mQueue[mIndex];
            } 
            mQueue[mIndex] = focusDelta;
            mIndex = (mIndex + 1) % QUEUE_CAPACITY;
            
            
            
                
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.295 -0400", hash_original_method = "D980EABC4C0F2D2A081289A0764FD494", hash_generated_method = "9D90013ECB76D10B1EDCA6EE47E77D80")
        private float getSum() {
            float var546ADE640B6EDFBC8A086EF31347E768_198797366 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_198797366;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.295 -0400", hash_original_field = "68D6C106EA24FD5D1E9A33FE112A82F8", hash_generated_field = "4AE12D25133F8791AD4CAFB87334ABF4")

        private static final int QUEUE_CAPACITY = 5;
    }


    
    private class ScaleDetectorListener implements ScaleGestureDetector.OnScaleGestureListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.295 -0400", hash_original_field = "09CF021BF536BAB6C30DC7BBD1177879", hash_generated_field = "D9620ED126995C2A7FCE1BBDF87310E8")

        private float mAccumulatedSpan;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.295 -0400", hash_original_method = "BA46F3652F41E17982BE025D7A95EDE2", hash_generated_method = "BA46F3652F41E17982BE025D7A95EDE2")
        public ScaleDetectorListener ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.296 -0400", hash_original_method = "9075B37C27A1752EF4C1C0179D09116C", hash_generated_method = "32A78566D952487EEF6E6C85590E4299")
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            
            mInitialZoomOverview = false;
            dismissZoomPicker();
            mFocusMovementQueue.clear();
            mFocusX = detector.getFocusX();
            mFocusY = detector.getFocusY();
            mWebView.mViewManager.startZoom();
            mWebView.onPinchToZoomAnimationStart();
            mAccumulatedSpan = 0;
            addTaint(detector.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1617673751 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1617673751;
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.296 -0400", hash_original_method = "B0E9BE71CCDF607A4C10071A1E309D43", hash_generated_method = "4C79E5BD3D20A070A62486751E948E1B")
        public boolean isPanningOnly(ScaleGestureDetector detector) {
            float prevFocusX = mFocusX;
            float prevFocusY = mFocusY;
            mFocusX = detector.getFocusX();
            mFocusY = detector.getFocusY();
            float focusDelta;
            focusDelta = 0;
            focusDelta = FloatMath.sqrt((mFocusX - prevFocusX) * (mFocusX - prevFocusX)
                                   + (mFocusY - prevFocusY) * (mFocusY - prevFocusY));
            mFocusMovementQueue.add(focusDelta);
            float deltaSpan = detector.getCurrentSpan() - detector.getPreviousSpan() +
                    mAccumulatedSpan;
            final boolean result = mFocusMovementQueue.getSum() > Math.abs(deltaSpan);
            {
                mAccumulatedSpan += deltaSpan;
            } 
            {
                mAccumulatedSpan = 0;
            } 
            addTaint(detector.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1811741714 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1811741714;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.297 -0400", hash_original_method = "69F2A7AC5DBED7E3BD0F18F39CE3A7B5", hash_generated_method = "B6171756C75C6E93D82A1913B35D91DF")
        public boolean handleScale(ScaleGestureDetector detector) {
            float scale = detector.getScaleFactor() * mActualScale;
            boolean isScaleLimited = isScaleOverLimits(scale) || scale < getZoomOverviewScale();
            scale = Math.max(computeScaleWithLimits(scale), getZoomOverviewScale());
            {
                boolean var8FA38A898D1233C0012F264478AD7276_776320389 = (mPinchToZoomAnimating || willScaleTriggerZoom(scale));
                {
                    mPinchToZoomAnimating = true;
                    {
                        scale = Math.min(scale, mActualScale * 1.25f);
                    } 
                    {
                        scale = Math.max(scale, mActualScale * 0.8f);
                    } 
                    scale = computeScaleWithLimits(scale);
                    {
                        boolean varC4DEEA06E814A1944DC8A9A5323D1750_1872542293 = (Math.abs(scale - mActualScale) < MINIMUM_SCALE_WITHOUT_JITTER);
                    } 
                    setZoomCenter(detector.getFocusX(), detector.getFocusY());
                    setZoomScale(scale, false);
                    mWebView.invalidate();
                } 
            } 
            addTaint(detector.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1569116833 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1569116833;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.297 -0400", hash_original_method = "ED0E7724FBEBB5F90A0828B68DD48F69", hash_generated_method = "D93DA175A7E7F462F036863ACB337915")
        public boolean onScale(ScaleGestureDetector detector) {
            
            {
                boolean varD3734ED0B6DF1B041CFFE69F64B7AFEF_725709373 = (isPanningOnly(detector) || handleScale(detector));
                {
                    mFocusMovementQueue.clear();
                } 
            } 
            addTaint(detector.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1098901185 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1098901185;
            
            
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.298 -0400", hash_original_method = "8B2C3B6F263B86181A105DF4C3A0ECE1", hash_generated_method = "493D6050AB7F6182D4CF5E9690AB85CB")
        public void onScaleEnd(ScaleGestureDetector detector) {
            
            {
                mPinchToZoomAnimating = false;
                mAnchorX = mWebView.viewToContentX((int) mZoomCenterX + mWebView.getScrollX());
                mAnchorY = mWebView.viewToContentY((int) mZoomCenterY + mWebView.getScrollY());
                boolean reflowNow = !canZoomOut() || (mActualScale <= 0.8 * mTextWrapScale);
                refreshZoomScale(reflowNow &&
                    !mWebView.getSettings().getUseFixedViewport());
                mWebView.invalidate();
            } 
            mWebView.mViewManager.endZoom();
            mWebView.onPinchToZoomAnimationEnd(detector);
            addTaint(detector.getTaint());
            
            
                
                
                
                
                
                    
                
            
            
            
        }

        
    }


    
    private class PostScale implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.298 -0400", hash_original_field = "FF619880DF50315F5F0C23464FCB91F9", hash_generated_field = "77CA9D980A43549CDA68DE3DCA6626A5")

        boolean mUpdateTextWrap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.298 -0400", hash_original_field = "3C0CE17CA283A7A032FB13C4CF5E9947", hash_generated_field = "CFCDFC51582F4CFE0A0F368B7A789B49")

        boolean mInZoomOverviewBeforeSizeChange;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.298 -0400", hash_original_field = "91FECCF530559D322CF17336F85F2461", hash_generated_field = "885926B4FFFBA16CECCAF1A99F0266F9")

        boolean mInPortraitMode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.298 -0400", hash_original_method = "987305C98B26834A8CB0058E5C6D93E2", hash_generated_method = "3399CCB2C3E7BA10E96510C264203349")
        public  PostScale(boolean updateTextWrap,
                         boolean inZoomOverview,
                         boolean inPortraitMode) {
            mUpdateTextWrap = updateTextWrap;
            mInZoomOverviewBeforeSizeChange = inZoomOverview;
            mInPortraitMode = inPortraitMode;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.299 -0400", hash_original_method = "713D19A11600F821B2CA1C17235BF1BC", hash_generated_method = "AE8F2123049CCD2DCE267F8A1B0EF5C7")
        public void run() {
            {
                boolean var0A3519DF8335FF3D7078A97FDBC9E3B4_845490499 = (mWebView.getWebViewCore() != null);
                {
                    float newScale = mActualScale;
                    {
                        boolean var1DF8C58DD41F9A4D3D32DEAC17429D28_766350817 = (mWebView.getSettings().getUseWideViewPort() &&
                    mInPortraitMode &&
                    mInZoomOverviewBeforeSizeChange);
                        {
                            newScale = getZoomOverviewScale();
                        } 
                    } 
                    setZoomScale(newScale, mUpdateTextWrap, true);
                    updateZoomPicker();
                } 
            } 
            
            
                
                
                    
                    
                    
                
                
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.299 -0400", hash_original_field = "0DB0A8D0024C30F56EDCF3AFB02E533D", hash_generated_field = "1172DCF442F1B530BFE9216ADBA08AB8")

    static final String LOGTAG = "webviewZoom";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.299 -0400", hash_original_field = "824864C5654B72A6B9F5576381E885DA", hash_generated_field = "01501206C858CCE0B2BAF203972C511B")

    protected static final float DEFAULT_MAX_ZOOM_SCALE_FACTOR = 4.00f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.299 -0400", hash_original_field = "3F514FF5D0C7CF1AF261334CC5737B03", hash_generated_field = "A8E4F36E80550FABF96F35586FC945C0")

    protected static final float DEFAULT_MIN_ZOOM_SCALE_FACTOR = 0.25f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.299 -0400", hash_original_field = "12D317062A7ECE5FD7C63AA57A6DC326", hash_generated_field = "D8861706BAFD8699E50F90FBCF998F7D")

    private static float MIN_DOUBLE_TAP_SCALE_INCREMENT = 0.5f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.299 -0400", hash_original_field = "CC4756180A7EFB1D163EEE2302021E77", hash_generated_field = "9312CAAED499DB8E5F33CA8B59A623F5")

    private static float MINIMUM_SCALE_INCREMENT = 0.007f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.299 -0400", hash_original_field = "2B07A398287AE320F54A1B32AD3EEDC5", hash_generated_field = "3CC1005C93624AF917078598F90C5E0D")

    private static float MINIMUM_SCALE_WITHOUT_JITTER = 0.007f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.299 -0400", hash_original_field = "4061CBCD4A8CBAAAAFDB40A970FAA7C8", hash_generated_field = "D2F744F6BCE3A182CFEB66495ABCBDAE")

    private static final int ZOOM_ANIMATION_LENGTH = 175;
}

