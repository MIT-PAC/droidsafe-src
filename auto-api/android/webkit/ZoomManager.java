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
    private WebView mWebView;
    private CallbackProxy mCallbackProxy;
    private ZoomControlEmbedded mEmbeddedZoomControl;
    private ZoomControlExternal mExternalZoomControl;
    private float mDefaultMaxZoomScale;
    private float mDefaultMinZoomScale;
    private float mMaxZoomScale;
    private float mMinZoomScale;
    private boolean mMinZoomScaleFixed = true;
    private boolean mInitialZoomOverview = false;
    private boolean mInZoomOverview = false;
    private int mZoomOverviewWidth;
    private float mInvZoomOverviewWidth;
    private float mZoomCenterX;
    private float mZoomCenterY;
    private float mFocusX;
    private float mFocusY;
    private FocusMovementQueue mFocusMovementQueue;
    private int mAnchorX;
    private int mAnchorY;
    private float mTextWrapScale;
    private float mDefaultScale;
    private float mInvDefaultScale;
    private float mDisplayDensity;
    private float mDoubleTapZoomFactor = 1.0f;
    private float mActualScale;
    private float mInvActualScale;
    private float mInitialScale;
    private float mZoomScale;
    private float mInvInitialZoomScale;
    private float mInvFinalZoomScale;
    private int mInitialScrollX;
    private int mInitialScrollY;
    private long mZoomStart;
    private boolean mSupportMultiTouch;
    private boolean mAllowPanAndScale;
    private ScaleGestureDetector mScaleDetector;
    private boolean mPinchToZoomAnimating = false;
    private boolean mHardwareAccelerated = false;
    private boolean mInHWAcceleratedZoom = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.512 -0400", hash_original_method = "C53EE2007D9BEC2FE01EA607CD54C4FF", hash_generated_method = "E1940279F1EA9246A80322DDE0124FF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ZoomManager(WebView webView, CallbackProxy callbackProxy) {
        dsTaint.addTaint(callbackProxy.dsTaint);
        dsTaint.addTaint(webView.dsTaint);
        setZoomOverviewWidth(WebView.DEFAULT_VIEWPORT_WIDTH);
        mFocusMovementQueue = new FocusMovementQueue();
        // ---------- Original Method ----------
        //mWebView = webView;
        //mCallbackProxy = callbackProxy;
        //setZoomOverviewWidth(WebView.DEFAULT_VIEWPORT_WIDTH);
        //mFocusMovementQueue = new FocusMovementQueue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.513 -0400", hash_original_method = "93CFAAB8556EE96135ADFFE4D2689C29", hash_generated_method = "48AD07AE9F4434A96963C2652E5DE8D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void init(float density) {
        dsTaint.addTaint(density);
        setDefaultZoomScale(density);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.513 -0400", hash_original_method = "2EFEEBFBDE6ACF8543350ABFFB008A8F", hash_generated_method = "569681D1E59A8E10254BA71276B73C5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateDefaultZoomDensity(float density) {
        dsTaint.addTaint(density);
        {
            boolean var55986BB94FD10BB61A37151F90F17CA6_986592269 = (Math.abs(density - mDefaultScale) > MINIMUM_SCALE_INCREMENT);
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
        // ---------- Original Method ----------
        //assert density > 0;
        //if (Math.abs(density - mDefaultScale) > MINIMUM_SCALE_INCREMENT) {
            //final float originalDefault = mDefaultScale;
            //setDefaultZoomScale(density);
            //float scaleChange = (originalDefault > 0.0) ? density / originalDefault: 1.0f;
            //setZoomScale(mActualScale * scaleChange, true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.513 -0400", hash_original_method = "E8BCC867B6D8CCFABF539A9D95032C95", hash_generated_method = "D6F25E32994467129878100CCA485FAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setDefaultZoomScale(float defaultScale) {
        dsTaint.addTaint(defaultScale);
        float originalDefault;
        originalDefault = mDefaultScale;
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
            boolean varD4A51976EA74EEAE11BCC79328DC7589_1433535241 = (!exceedsMinScaleIncrement(mMinZoomScale, mMaxZoomScale));
            {
                mMaxZoomScale = mMinZoomScale;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.513 -0400", hash_original_method = "E0A7D63CBE7BA22AE5FD1D2BCFACA30A", hash_generated_method = "70417BAEEAE615F0A4909B1FCAE494E0")
    @DSModeled(DSC.SAFE)
    public final float getScale() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mActualScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.514 -0400", hash_original_method = "27B2B7D16269E37341CA9CE429E50BD4", hash_generated_method = "9442D950EEF15C3380EFDC275E962659")
    @DSModeled(DSC.SAFE)
    public final float getInvScale() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mInvActualScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.514 -0400", hash_original_method = "420B51415ADFBA4739EC66A8F732263C", hash_generated_method = "7AD5210023F3F78B2B8943DBE5B9B461")
    @DSModeled(DSC.SAFE)
    public final float getTextWrapScale() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTextWrapScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.514 -0400", hash_original_method = "4D84680032231769C697659C881951E3", hash_generated_method = "7DD9AA5199D5F4085E1C6930FDA80A3C")
    @DSModeled(DSC.SAFE)
    public final float getMaxZoomScale() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mMaxZoomScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.514 -0400", hash_original_method = "EF101FB82D6E625D2F7286BB14442128", hash_generated_method = "AB487009FF6A0AE9AC69F92A2BFD6C0A")
    @DSModeled(DSC.SAFE)
    public final float getMinZoomScale() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mMinZoomScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.514 -0400", hash_original_method = "C9287BA17A965D05EE45D11D20F2D047", hash_generated_method = "582FE67121FF4CC3760EF56BFC087698")
    @DSModeled(DSC.SAFE)
    public final float getDefaultScale() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mDefaultScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.514 -0400", hash_original_method = "B68BBC34F3F5ADBA444AF11F55B159F2", hash_generated_method = "B2FF8BB098922AC997063CAF52458D36")
    @DSModeled(DSC.SAFE)
    public final float getReadingLevelScale() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mDisplayDensity * mDoubleTapZoomFactor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.514 -0400", hash_original_method = "150923628532607A08D5A6F81E7006FE", hash_generated_method = "2387CE14CFA6BDB445B1707BD3656D97")
    @DSModeled(DSC.SAFE)
    public final float getInvDefaultScale() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mInvDefaultScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.515 -0400", hash_original_method = "86C1C61E20B5F864D06602058822F40B", hash_generated_method = "B666B3DFF88542FCC26ED0DA89BBAFCF")
    @DSModeled(DSC.SAFE)
    public final float getDefaultMaxZoomScale() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mDefaultMaxZoomScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.515 -0400", hash_original_method = "68697F997D536A00F27515B45D68169D", hash_generated_method = "32CC79F5EBC6766B861E9A5AD542E339")
    @DSModeled(DSC.SAFE)
    public final float getDefaultMinZoomScale() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mDefaultMinZoomScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.515 -0400", hash_original_method = "0D1E90BA2B32E85CA9E1B47821E3129C", hash_generated_method = "D02B8E04A45FF0FACB826D149A96352E")
    @DSModeled(DSC.SAFE)
    public final int getDocumentAnchorX() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAnchorX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.515 -0400", hash_original_method = "6F8EAB28E274BDE9903F29B52FA3CE08", hash_generated_method = "62586B3CAA525150E35650528DAA6992")
    @DSModeled(DSC.SAFE)
    public final int getDocumentAnchorY() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAnchorY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.515 -0400", hash_original_method = "37EC19EE8D577B9FFE8E8612EB136E0D", hash_generated_method = "0979E863D08CE670AE5057D10C3B3325")
    @DSModeled(DSC.SAFE)
    public final void clearDocumentAnchor() {
        mAnchorX = mAnchorY = 0;
        // ---------- Original Method ----------
        //mAnchorX = mAnchorY = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.515 -0400", hash_original_method = "B42B83C0DB8155DA229557A2BD45C477", hash_generated_method = "0557DBB2EFE9DAFCA70C9A4FD25B1536")
    @DSModeled(DSC.SAFE)
    public final void setZoomCenter(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        // ---------- Original Method ----------
        //mZoomCenterX = x;
        //mZoomCenterY = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.515 -0400", hash_original_method = "E17C2AED3C2D9DCFE2D098E038948EA1", hash_generated_method = "59EE9C99E32C54AC80AE5A37088420C0")
    @DSModeled(DSC.SAFE)
    public final void setInitialScaleInPercent(int scaleInPercent) {
        dsTaint.addTaint(scaleInPercent);
        mInitialScale = scaleInPercent * 0.01f;
        // ---------- Original Method ----------
        //mInitialScale = scaleInPercent * 0.01f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.516 -0400", hash_original_method = "CACC1DB3C5C8FBE689456F981994723C", hash_generated_method = "7F13D81128748F6D73B905A8EA1A869A")
    @DSModeled(DSC.SAFE)
    public final float computeScaleWithLimits(float scale) {
        dsTaint.addTaint(scale);
        {
            scale = mMinZoomScale;
        } //End block
        {
            scale = mMaxZoomScale;
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //if (scale < mMinZoomScale) {
            //scale = mMinZoomScale;
        //} else if (scale > mMaxZoomScale) {
            //scale = mMaxZoomScale;
        //}
        //return scale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.516 -0400", hash_original_method = "49E88837FC0437D5B36C3DDB131811B0", hash_generated_method = "DD5A2094FBC4F511B3A1D3143F0DFBAB")
    @DSModeled(DSC.SAFE)
    public final boolean isScaleOverLimits(float scale) {
        dsTaint.addTaint(scale);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return scale <= mMinZoomScale || scale >= mMaxZoomScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.516 -0400", hash_original_method = "EAE2E4FAF7045B63798AAD0EC191C138", hash_generated_method = "12D8653B0410F69DDE00AC319F9EDA26")
    @DSModeled(DSC.SAFE)
    public final boolean isZoomScaleFixed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mMinZoomScale >= mMaxZoomScale;
    }

    
        public static final boolean exceedsMinScaleIncrement(float scaleA, float scaleB) {
        return Math.abs(scaleA - scaleB) >= MINIMUM_SCALE_INCREMENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.516 -0400", hash_original_method = "73353D5825B74E55208D73C06ED7146E", hash_generated_method = "B8A907D9DD5AF853856BBA6AE41AB3BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean willScaleTriggerZoom(float scale) {
        dsTaint.addTaint(scale);
        boolean var6A4063C36BF43452312B6B8657DF0783_586033462 = (exceedsMinScaleIncrement(scale, mActualScale));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return exceedsMinScaleIncrement(scale, mActualScale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.516 -0400", hash_original_method = "577BAEA37EC580D2471F28E52ACC3E90", hash_generated_method = "90C8B9524DF900A95A57B06AC7EAEEEE")
    @DSModeled(DSC.SAFE)
    public final boolean canZoomIn() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mMaxZoomScale - mActualScale > MINIMUM_SCALE_INCREMENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.517 -0400", hash_original_method = "82D91A91E65D0066AFB31608B5056133", hash_generated_method = "378A09E4ED12B60E0434AF6566F0A115")
    @DSModeled(DSC.SAFE)
    public final boolean canZoomOut() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActualScale - mMinZoomScale > MINIMUM_SCALE_INCREMENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.517 -0400", hash_original_method = "1087ACA9FDE3F82506A02D8DB9B3B812", hash_generated_method = "899E91A639ADE45E86295C49CA1B3AC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean zoomIn() {
        boolean var1D72A61B00F4DC9B0382B92DAC1773A6_1953048839 = (zoom(1.25f));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return zoom(1.25f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.517 -0400", hash_original_method = "AF303514C2CE6EE62014ED1CD988BE8F", hash_generated_method = "BDDA54BCF240271A7C09D48C808C9316")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean zoomOut() {
        boolean var3CF167EA70562DB2BA335E1A998DD456_865433305 = (zoom(0.8f));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return zoom(0.8f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.517 -0400", hash_original_method = "0D06D835317E38A4890F08EB962517B9", hash_generated_method = "51CBDC9EA8487501AE90F19140E90815")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean zoom(float zoomMultiplier) {
        dsTaint.addTaint(zoomMultiplier);
        mInitialZoomOverview = false;
        mWebView.switchOutDrawHistory();
        mZoomCenterX = mWebView.getViewWidth() * .5f;
        mZoomCenterY = mWebView.getViewHeight() * .5f;
        mAnchorX = mWebView.viewToContentX((int) mZoomCenterX + mWebView.getScrollX());
        mAnchorY = mWebView.viewToContentY((int) mZoomCenterY + mWebView.getScrollY());
        boolean var90FBEB34589F56F8A92EA96C08461924_967819826 = (startZoomAnimation(mActualScale * zoomMultiplier, 
            !mWebView.getSettings().getUseFixedViewport()));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.518 -0400", hash_original_method = "ABA8C6E97A9C369182835D6347EB12CF", hash_generated_method = "5BA217251B4B3FE48DF892C5609D6CE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean startZoomAnimation(float scale, boolean reflowText) {
        dsTaint.addTaint(scale);
        dsTaint.addTaint(reflowText);
        mInitialZoomOverview = false;
        float oldScale;
        oldScale = mActualScale;
        mInitialScrollX = mWebView.getScrollX();
        mInitialScrollY = mWebView.getScrollY();
        {
            boolean var654B16B46C4BC96AA00B68D2DF42FCA3_324613683 = (!exceedsMinScaleIncrement(scale, getReadingLevelScale()));
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.518 -0400", hash_original_method = "4B2E3C5C63E13C95ACA7AA346AD0833D", hash_generated_method = "6D5159270F2DB6971529B4E9222865B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void animateZoom(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.519 -0400", hash_original_method = "E0C5EE754D896EBEA19BF99FCF86359E", hash_generated_method = "10F6675C4BB479CC48FAC558AA80558C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isZoomAnimating() {
        boolean var68B3C139DA5F66F80A809EBC4526A9C7_1127647626 = (isFixedLengthAnimationInProgress() || mPinchToZoomAnimating);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isFixedLengthAnimationInProgress() || mPinchToZoomAnimating;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.519 -0400", hash_original_method = "351373D4552618F4F14C898A250D84BD", hash_generated_method = "A4EB51AD5BF12F433E907563DF0F93AD")
    @DSModeled(DSC.SAFE)
    public boolean isFixedLengthAnimationInProgress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mZoomScale != 0 || mInHWAcceleratedZoom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.519 -0400", hash_original_method = "38BADAFCA13DD410DF65C206538CBBC7", hash_generated_method = "8399CBA6E780D5E832DB3DF2CD934A66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateDoubleTapZoom(int doubleTapZoom) {
        dsTaint.addTaint(doubleTapZoom);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.519 -0400", hash_original_method = "D0144FE074B01386F16EF11E861F0A7A", hash_generated_method = "7F1DD3F07DB26C5F6F208831D6146290")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void refreshZoomScale(boolean reflowText) {
        dsTaint.addTaint(reflowText);
        setZoomScale(mActualScale, reflowText, true);
        // ---------- Original Method ----------
        //setZoomScale(mActualScale, reflowText, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.519 -0400", hash_original_method = "0CAC496E58068B9E4E1CC3313C83A17E", hash_generated_method = "DE6D0D717DF7BC4F67B006CFD0DACE7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setZoomScale(float scale, boolean reflowText) {
        dsTaint.addTaint(scale);
        dsTaint.addTaint(reflowText);
        setZoomScale(scale, reflowText, false);
        // ---------- Original Method ----------
        //setZoomScale(scale, reflowText, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.520 -0400", hash_original_method = "3A85AAAB95D1CDF586170EB3BBF2667E", hash_generated_method = "4F1AD9154F2A4FFB585E558E09E43689")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setZoomScale(float scale, boolean reflowText, boolean force) {
        dsTaint.addTaint(scale);
        dsTaint.addTaint(force);
        dsTaint.addTaint(reflowText);
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
            boolean var859A3BA800EA204466595DBA45E17C4C_1823722207 = (reflowText && !mWebView.getSettings().getUseFixedViewport());
        } //End collapsed parenthetic
        {
            float oldScale;
            oldScale = mActualScale;
            float oldInvScale;
            oldInvScale = mInvActualScale;
            {
                mCallbackProxy.onScaleChanged(mActualScale, scale);
            } //End block
            mInvActualScale = 1 / scale;
            {
                boolean varA5B0FB0FE0ADFA061475ED90B3BD6BB4_393165803 = (!mWebView.drawHistory() && !mInHWAcceleratedZoom);
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
                        boolean var7404FC6FD99FB1C9740DD855B950B383_1562564969 = (!mWebView.updateScrollCoordinates(scrollX, scrollY));
                        {
                            mWebView.sendOurVisibleRect();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            mWebView.sendViewSizeZoom(reflowText);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.520 -0400", hash_original_method = "6C9BE8F81CD8D5D51E25813EE62B3846", hash_generated_method = "490285484B2D5367C723C86051B9BC74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDoubleTapEnabled() {
        WebSettings settings;
        settings = mWebView.getSettings();
        boolean var0E4816D8885F200857E0CD3978D0DEC6_1822344763 = (settings != null && settings.getUseWideViewPort());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //WebSettings settings = mWebView.getSettings();
        //return settings != null && settings.getUseWideViewPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.521 -0400", hash_original_method = "4C79B03AF1323FEB3700FE89F15D8B06", hash_generated_method = "E2B8C5860D6AFEC29CBA29FCE77714D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleDoubleTap(float lastTouchX, float lastTouchY) {
        dsTaint.addTaint(lastTouchY);
        dsTaint.addTaint(lastTouchX);
        mInitialZoomOverview = false;
        WebSettings settings;
        settings = mWebView.getSettings();
        {
            boolean var39CBEA45FB0B576C23AA565BDB2049CF_1707017915 = (!isDoubleTapEnabled());
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
                boolean var2DE6C60989B3AB3DFD602BE4B0F3FAF8_1997645133 = (mWebView.isRectFitOnScreen(pluginBounds));
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
            boolean varE234C0D200CB3A9FD7D0051550B809BC_2121728208 = (settings.getUseFixedViewport());
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
            boolean varE776BBB08B55EA07333E779A20E76DF6_721747939 = (settings.isNarrowColumnLayout()
                && exceedsMinScaleIncrement(mTextWrapScale, newTextWrapScale)
                && !firstTimeReflow
                && !mInZoomOverview);
            {
                mTextWrapScale = newTextWrapScale;
                refreshZoomScale(true);
            } //End block
            {
                boolean var12B421A3A3971D1660F0A5E98DF868FE_691933618 = (!mInZoomOverview && willScaleTriggerZoom(getZoomOverviewScale()));
                {
                    {
                        boolean varAD4F5B5601E26CC9DE285E4995249A79_1519718533 = (mTextWrapScale > getReadingLevelScale());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.521 -0400", hash_original_method = "712C22BAE7AA3B12B6A5A40165B58905", hash_generated_method = "A6C6ECCF033C6E738F9F90885FACC85E")
    @DSModeled(DSC.SAFE)
    private void setZoomOverviewWidth(int width) {
        dsTaint.addTaint(width);
        {
            mZoomOverviewWidth = WebView.DEFAULT_VIEWPORT_WIDTH;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.521 -0400", hash_original_method = "B42D229ABB1FC24C49B118C5D42DFED9", hash_generated_method = "A6C28F3A5A750E19E73EA640D374E3AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     float getZoomOverviewScale() {
        float varC68098F3B3A8CF52938B6BE93874939F_1023956583 = (mWebView.getViewWidth() * mInvZoomOverviewWidth);
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mWebView.getViewWidth() * mInvZoomOverviewWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.521 -0400", hash_original_method = "C49CAD609BC6A273DA434DC912742003", hash_generated_method = "46B31B925113955DE4CA1E6F5A1BF5DB")
    @DSModeled(DSC.SAFE)
    public boolean isInZoomOverview() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mInZoomOverview;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.521 -0400", hash_original_method = "C0C0965039A172A5A5AAF6C9C4472D2A", hash_generated_method = "ADA58BF70D7FAB3D844B6E2101F2D566")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void zoomToOverview() {
        int scrollY;
        scrollY = mWebView.getScrollY();
        {
            boolean varA858D0DF98219C81D8899CE9E1439021_315526669 = (scrollY < mWebView.getTitleHeight());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.522 -0400", hash_original_method = "6051F287C8BD349D628462D7AA7CF8A8", hash_generated_method = "6CC7625295AC63396168204B2B36FFD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.522 -0400", hash_original_method = "77E44A3E983371F616079D37D03C3B6C", hash_generated_method = "5A9A73DC8787CF4C296CE8D6E47FE35A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateMultiTouchSupport(Context context) {
        dsTaint.addTaint(context.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.522 -0400", hash_original_method = "D759966F5D5714E0336F491E3EEDC527", hash_generated_method = "6E4639B89AF3006ECD1C2D1D79E22783")
    @DSModeled(DSC.SAFE)
    public boolean supportsMultiTouchZoom() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSupportMultiTouch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.523 -0400", hash_original_method = "E2CDCD424944BF66C1EED756BC88611C", hash_generated_method = "32251A117CFF4A67CA85972C79AE17C5")
    @DSModeled(DSC.SAFE)
    public boolean supportsPanDuringZoom() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAllowPanAndScale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.523 -0400", hash_original_method = "DB3FE2513664456015F767E0971235E8", hash_generated_method = "78AACDEF1FCF903F28428E80217EEC52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isPreventingWebkitUpdates() {
        boolean var539C6BCA16155491BB47B574D6ADAA7D_525020635 = (isZoomAnimating());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isZoomAnimating();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.523 -0400", hash_original_method = "D6F4E788215219485BF912038215831B", hash_generated_method = "D1E2E878B4E22C3F87AD7303F07EA8B5")
    @DSModeled(DSC.SAFE)
    public ScaleGestureDetector getMultiTouchGestureDetector() {
        return (ScaleGestureDetector)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mScaleDetector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.523 -0400", hash_original_method = "CAC2F3D27B1973D4CF70D4BE09DB9479", hash_generated_method = "4639043CD741DC44A2A4DCF44BB0A457")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onSizeChanged(int w, int h, int ow, int oh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(w);
        dsTaint.addTaint(ow);
        dsTaint.addTaint(h);
        dsTaint.addTaint(oh);
        {
            boolean varC6631ED5D3F259446C8414A3C535806A_1447061971 = (!isFixedLengthAnimationInProgress());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.524 -0400", hash_original_method = "853C20600470FB7106E8D67215AF9147", hash_generated_method = "F284378594D424CDFAA5C38C2716A16F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateZoomRange(WebViewCore.ViewState viewState,
            int viewWidth, int minPrefWidth) {
        dsTaint.addTaint(minPrefWidth);
        dsTaint.addTaint(viewState.dsTaint);
        dsTaint.addTaint(viewWidth);
        {
            {
                {
                    boolean varEADFD9CA65629F47D38E6EBD32772CB6_269426524 = (minPrefWidth > Math.max(0, viewWidth));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.524 -0400", hash_original_method = "30705697D50ADB9D51B01BF1D1A7F736", hash_generated_method = "6E14EC4D590EA3811581D9BF6812047F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onNewPicture(WebViewCore.DrawData drawData) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(drawData.dsTaint);
        int viewWidth;
        viewWidth = mWebView.getViewWidth();
        boolean zoomOverviewWidthChanged;
        zoomOverviewWidthChanged = setupZoomOverviewWidth(drawData, viewWidth);
        float newZoomOverviewScale;
        newZoomOverviewScale = getZoomOverviewScale();
        WebSettings settings;
        settings = mWebView.getSettings();
        {
            boolean var4FA725D625202F620E985DDF6FBC0A47_1973665479 = (zoomOverviewWidthChanged && settings.isNarrowColumnLayout() &&
            settings.getUseFixedViewport() &&
            (mInitialZoomOverview || mInZoomOverview));
            {
                {
                    boolean varC029B731C62F8B1BF7CA9FB17B55FF95_1944432904 = (exceedsMinScaleIncrement(mTextWrapScale, mDefaultScale) ||
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
            boolean varEDDADBFDAB93A3ADFCA53123BBF6AB92_851039054 = (!mMinZoomScaleFixed || settings.getUseWideViewPort());
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
            boolean varFFB204A70D7C076155163881EAF6A9DF_287142066 = (!mWebView.drawHistory() &&
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
            boolean varBAB1EB72F6CEBD20753D79FB108C2220_532787642 = (drawData.mFirstLayoutForNonStandardLoad && settings.getLoadWithOverviewMode());
            {
                mInitialZoomOverview = mInZoomOverview;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.525 -0400", hash_original_method = "74FCB7875112FE9C3AB647C4DB8DEDB6", hash_generated_method = "42080D9489A0542F195150A3D368D635")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean setupZoomOverviewWidth(WebViewCore.DrawData drawData, final int viewWidth) {
        dsTaint.addTaint(drawData.dsTaint);
        dsTaint.addTaint(viewWidth);
        WebSettings settings;
        settings = mWebView.getSettings();
        int newZoomOverviewWidth;
        newZoomOverviewWidth = mZoomOverviewWidth;
        {
            boolean varBFDE20206CCD6D6A45C02520E4553355_988383361 = (settings.getUseWideViewPort());
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.526 -0400", hash_original_method = "49A97AD028E7397E6545CF950CBFEBF3", hash_generated_method = "DD591BC1E846FB5A28DF6514B3C9EE93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onFirstLayout(WebViewCore.DrawData drawData) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(drawData.dsTaint);
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
            boolean varEDDADBFDAB93A3ADFCA53123BBF6AB92_1075690287 = (!mMinZoomScaleFixed || settings.getUseWideViewPort());
            {
                mMinZoomScale = (mInitialScale > 0) ?
                    Math.min(mInitialScale, overviewScale) : overviewScale;
                mMaxZoomScale = Math.max(mMaxZoomScale, mMinZoomScale);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var72CDC5681BBA9EF2F7C0725FEF71FE87_123133879 = (!mWebView.drawHistory());
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
                        boolean var12EE9A7356F197091F1FCC2C2762EE57_1042698362 = (!settings.getUseWideViewPort()
                    || !settings.getLoadWithOverviewMode());
                        {
                            scale = Math.max(mDefaultScale, scale);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var8AAAF8A664E23A6D3AFCADC2A850C15A_1799277673 = (settings.isNarrowColumnLayout() &&
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
                        boolean var05F160112893383CE2E2D0B7BAA522D8_1536633417 = (settings.getUseFixedViewport());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.526 -0400", hash_original_method = "E88F50435C2D2101D935E91DFBA371A3", hash_generated_method = "F23A76840178F6E82E715FF6EF90871E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void saveZoomState(Bundle b) {
        dsTaint.addTaint(b.dsTaint);
        b.putFloat("scale", mActualScale);
        b.putFloat("textwrapScale", mTextWrapScale);
        b.putBoolean("overview", mInZoomOverview);
        // ---------- Original Method ----------
        //b.putFloat("scale", mActualScale);
        //b.putFloat("textwrapScale", mTextWrapScale);
        //b.putBoolean("overview", mInZoomOverview);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.526 -0400", hash_original_method = "CEABBB6E3216B8D1034C16D61ED63443", hash_generated_method = "1FF0759E911A85DB98F2C08BA948C485")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void restoreZoomState(Bundle b) {
        dsTaint.addTaint(b.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.527 -0400", hash_original_method = "03F547EF9A141661565AD38656124362", hash_generated_method = "9B6B64B5CD7FDD1FD36BB6E5ED6AC928")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ZoomControlBase getCurrentZoomControl() {
        {
            boolean var83F1D2F4A6B5EE964613A457830A6BDF_1205006489 = (mWebView.getSettings() != null && mWebView.getSettings().supportZoom());
            {
                {
                    boolean var1BC924BA3C63EFE4CEFE0945D6BE1E67_1290602465 = (mWebView.getSettings().getBuiltInZoomControls());
                    {
                        {
                            boolean var1598C98885536FE583B80D8148180FBD_998588645 = ((mEmbeddedZoomControl == null)
                        && mWebView.getSettings().getDisplayZoomControls());
                            {
                                mEmbeddedZoomControl = new ZoomControlEmbedded(this, mWebView);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            mExternalZoomControl = new ZoomControlExternal(mWebView);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (ZoomControlBase)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.527 -0400", hash_original_method = "BF64B2CEB07538AA62EA00039BB48680", hash_generated_method = "5679DED4F43BB1F4D8FBD7C4F3DE9810")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.527 -0400", hash_original_method = "0CAEEFDB341BFD4D4CACBFA479A18F98", hash_generated_method = "949470795B924B7155E04B37E54372D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.528 -0400", hash_original_method = "DA055704D86885A7F9C5B74974CF851B", hash_generated_method = "96841126CD1178B2CE36C0A71F1C2F86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isZoomPickerVisible() {
        ZoomControlBase control;
        control = getCurrentZoomControl();
        {
            Object var90D3359E5D07B295D570F6A9F5B367E9_500395887 = (control.isVisible());
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //ZoomControlBase control = getCurrentZoomControl();
        //return (control != null) ? control.isVisible() : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.528 -0400", hash_original_method = "A8AE3510E280FF5955731B404A0A66EC", hash_generated_method = "1B4F458A6B062182C49F459CED4C2034")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.528 -0400", hash_original_method = "65E0B786CE90103F5573BC67CE254CE7", hash_generated_method = "C51021626D75B73C99277EA9C208BA9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.528 -0400", hash_original_method = "295B8076F41B8CC3FCA3F323BF66F29B", hash_generated_method = "912D2A103FF61825F3E4EF2EE2AD45EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getExternalZoomPicker() {
        ZoomControlBase control;
        control = getCurrentZoomControl();
        {
            View varBC71C29C3D37C46151EC80D888E92F67_70485404 = (mExternalZoomControl.getControls());
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ZoomControlBase control = getCurrentZoomControl();
        //if (control != null && control == mExternalZoomControl) {
            //return mExternalZoomControl.getControls();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.529 -0400", hash_original_method = "8D458CBEFE5B6426DEF9072097FF3245", hash_generated_method = "9ADC4F4CBEDBCA89924A04F25DE685B9")
    @DSModeled(DSC.SAFE)
    public void setHardwareAccelerated() {
        mHardwareAccelerated = true;
        // ---------- Original Method ----------
        //mHardwareAccelerated = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.529 -0400", hash_original_method = "35BF52CFA65A672FC707BA33DDD071E9", hash_generated_method = "90F4E350AC2CA0C43D49D89502CE32CA")
    @DSModeled(DSC.SAFE)
     void onPageFinished(String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(url);
        mInitialZoomOverview = false;
        // ---------- Original Method ----------
        //mInitialZoomOverview = false;
    }

    
    private class FocusMovementQueue {
        private float[] mQueue;
        private float mSum;
        private int mSize;
        private int mIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.529 -0400", hash_original_method = "C2CA3F4962FE0D524626245DAD0C9DD6", hash_generated_method = "D4AF6BA17545ED20E2FFAFBAF09FD153")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.530 -0400", hash_original_method = "7BD5EC8FD84F966DA50367EA866227AA", hash_generated_method = "B0BC1E7CD84A9D85BF739DF8776D1957")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.530 -0400", hash_original_method = "BEA568413C11D502CA7CED6FD222D059", hash_generated_method = "412CF907C9483B0F0CE592D2AD9A503A")
        @DSModeled(DSC.SAFE)
        private void add(float focusDelta) {
            dsTaint.addTaint(focusDelta);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.530 -0400", hash_original_method = "D980EABC4C0F2D2A081289A0764FD494", hash_generated_method = "E12AD3068190AC4DCC00BC87CC2EFBB1")
        @DSModeled(DSC.SAFE)
        private float getSum() {
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //return mSum;
        }

        
        private static final int QUEUE_CAPACITY = 5;
    }


    
    private class ScaleDetectorListener implements ScaleGestureDetector.OnScaleGestureListener {
        private float mAccumulatedSpan;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.530 -0400", hash_original_method = "5CC7FD55FBC9EEE9AD71E44EEEB18591", hash_generated_method = "5CC7FD55FBC9EEE9AD71E44EEEB18591")
                public ScaleDetectorListener ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.531 -0400", hash_original_method = "9075B37C27A1752EF4C1C0179D09116C", hash_generated_method = "AEFD1B4C5C43C9BF1A97AE285D2D1CDB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(detector.dsTaint);
            mInitialZoomOverview = false;
            dismissZoomPicker();
            mFocusMovementQueue.clear();
            mFocusX = detector.getFocusX();
            mFocusY = detector.getFocusY();
            mWebView.mViewManager.startZoom();
            mWebView.onPinchToZoomAnimationStart();
            mAccumulatedSpan = 0;
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.531 -0400", hash_original_method = "B0E9BE71CCDF607A4C10071A1E309D43", hash_generated_method = "191FA85734BEDEF23FC7868957766922")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isPanningOnly(ScaleGestureDetector detector) {
            dsTaint.addTaint(detector.dsTaint);
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
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.531 -0400", hash_original_method = "69F2A7AC5DBED7E3BD0F18F39CE3A7B5", hash_generated_method = "02B3F702C9F8107650AABF518D5E80A2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean handleScale(ScaleGestureDetector detector) {
            dsTaint.addTaint(detector.dsTaint);
            float scale;
            scale = detector.getScaleFactor() * mActualScale;
            boolean isScaleLimited;
            isScaleLimited = isScaleOverLimits(scale) || scale < getZoomOverviewScale();
            scale = Math.max(computeScaleWithLimits(scale), getZoomOverviewScale());
            {
                boolean var8FA38A898D1233C0012F264478AD7276_555198484 = (mPinchToZoomAnimating || willScaleTriggerZoom(scale));
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
                        boolean varC4DEEA06E814A1944DC8A9A5323D1750_1835839691 = (Math.abs(scale - mActualScale) < MINIMUM_SCALE_WITHOUT_JITTER);
                    } //End collapsed parenthetic
                    setZoomCenter(detector.getFocusX(), detector.getFocusY());
                    setZoomScale(scale, false);
                    mWebView.invalidate();
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.532 -0400", hash_original_method = "ED0E7724FBEBB5F90A0828B68DD48F69", hash_generated_method = "B69AA66A6817A33785D694169F65882E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onScale(ScaleGestureDetector detector) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(detector.dsTaint);
            {
                boolean varD3734ED0B6DF1B041CFFE69F64B7AFEF_1834251397 = (isPanningOnly(detector) || handleScale(detector));
                {
                    mFocusMovementQueue.clear();
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (isPanningOnly(detector) || handleScale(detector)) {
                //mFocusMovementQueue.clear();
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.532 -0400", hash_original_method = "8B2C3B6F263B86181A105DF4C3A0ECE1", hash_generated_method = "4CA69A14C99C6234D4A5C30170FF7E90")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onScaleEnd(ScaleGestureDetector detector) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(detector.dsTaint);
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
        boolean mUpdateTextWrap;
        boolean mInZoomOverviewBeforeSizeChange;
        boolean mInPortraitMode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.532 -0400", hash_original_method = "987305C98B26834A8CB0058E5C6D93E2", hash_generated_method = "7714859D77E10CC65EBB58C13B49B7CB")
        @DSModeled(DSC.SAFE)
        public PostScale(boolean updateTextWrap,
                         boolean inZoomOverview,
                         boolean inPortraitMode) {
            dsTaint.addTaint(inPortraitMode);
            dsTaint.addTaint(updateTextWrap);
            dsTaint.addTaint(inZoomOverview);
            // ---------- Original Method ----------
            //mUpdateTextWrap = updateTextWrap;
            //mInZoomOverviewBeforeSizeChange = inZoomOverview;
            //mInPortraitMode = inPortraitMode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.533 -0400", hash_original_method = "713D19A11600F821B2CA1C17235BF1BC", hash_generated_method = "A70053C9CA2465F0D68D6E74C65CEDBA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            {
                boolean var0A3519DF8335FF3D7078A97FDBC9E3B4_510587825 = (mWebView.getWebViewCore() != null);
                {
                    float newScale;
                    newScale = mActualScale;
                    {
                        boolean var1DF8C58DD41F9A4D3D32DEAC17429D28_1705101870 = (mWebView.getSettings().getUseWideViewPort() &&
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


    
    static final String LOGTAG = "webviewZoom";
    protected static final float DEFAULT_MAX_ZOOM_SCALE_FACTOR = 4.00f;
    protected static final float DEFAULT_MIN_ZOOM_SCALE_FACTOR = 0.25f;
    private static float MIN_DOUBLE_TAP_SCALE_INCREMENT = 0.5f;
    private static float MINIMUM_SCALE_INCREMENT = 0.007f;
    private static float MINIMUM_SCALE_WITHOUT_JITTER = 0.007f;
    private static final int ZOOM_ANIMATION_LENGTH = 175;
}

