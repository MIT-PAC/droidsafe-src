package android.widget;

// Droidsafe Imports
import java.lang.ref.WeakReference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;

import com.android.internal.R;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class PopupWindow {
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    private Context mContext;
    private WindowManager mWindowManager;
    private boolean mIsShowing;
    private boolean mIsDropdown;
    private View mContentView;
    private View mPopupView;
    private boolean mFocusable;
    private int mInputMethodMode = INPUT_METHOD_FROM_FOCUSABLE;
    private int mSoftInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED;
    private boolean mTouchable = true;
    private boolean mOutsideTouchable = false;
    private boolean mClippingEnabled = true;
    private int mSplitTouchEnabled = -1;
    private boolean mLayoutInScreen;
    private boolean mClipToScreen;
    private boolean mAllowScrollingAnchorParent = true;
    private boolean mLayoutInsetDecor = false;
    private boolean mNotTouchModal;
    private OnTouchListener mTouchInterceptor;
    private int mWidthMode;
    private int mWidth;
    private int mLastWidth;
    private int mHeightMode;
    private int mHeight;
    private int mLastHeight;
    private int mPopupWidth;
    private int mPopupHeight;
    private int[] mDrawingLocation = new int[2];
    private int[] mScreenLocation = new int[2];
    private Rect mTempRect = new Rect();
    private Drawable mBackground;
    private Drawable mAboveAnchorBackgroundDrawable;
    private Drawable mBelowAnchorBackgroundDrawable;
    private boolean mAboveAnchor;
    private int mWindowLayoutType = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;
    private OnDismissListener mOnDismissListener;
    private boolean mIgnoreCheekPress = false;
    private int mAnimationStyle = -1;
    private static final int[] ABOVE_ANCHOR_STATE_SET = new int[] {
        com.android.internal.R.attr.state_above_anchor
    };
    private WeakReference<View> mAnchor;
    private OnScrollChangedListener mOnScrollChangedListener = new OnScrollChangedListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.199 -0400", hash_original_method = "8F0CC5ACEB252AEA9146DA3982ED4810", hash_generated_method = "E00BA9D04CBE299A1FF452DAC446C5BB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onScrollChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            View anchor;
            anchor = mAnchor.get();
            anchor = null;
            {
                WindowManager.LayoutParams p;
                p = (WindowManager.LayoutParams)
                            mPopupView.getLayoutParams();
                updateAboveAnchor(findDropDownPosition(anchor, p, mAnchorXoff, mAnchorYoff));
                update(p.x, p.y, -1, -1, true);
            } //End block
            // ---------- Original Method ----------
            //View anchor = mAnchor != null ? mAnchor.get() : null;
            //if (anchor != null && mPopupView != null) {
                    //WindowManager.LayoutParams p = (WindowManager.LayoutParams)
                            //mPopupView.getLayoutParams();
                    //updateAboveAnchor(findDropDownPosition(anchor, p, mAnchorXoff, mAnchorYoff));
                    //update(p.x, p.y, -1, -1, true);
                //}
        }

        
}; //Transformed anonymous class
    private int mAnchorXoff, mAnchorYoff;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.199 -0400", hash_original_method = "A7D29AF9F459F2E9972F382B06EBA7BC", hash_generated_method = "7DF88709FE861595503E2BC3EF6EF476")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PopupWindow(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.200 -0400", hash_original_method = "366007D96D9B418EA2EA6640B7FB7C46", hash_generated_method = "9FF97F814214A3343E422E7139FFFBEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PopupWindow(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.popupWindowStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.200 -0400", hash_original_method = "FAD82A2A4F32A008B236FC8E4F83669F", hash_generated_method = "DA659830603C846CDDBFF1284FE9CC8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PopupWindow(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, 0);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.200 -0400", hash_original_method = "079F601C7A8694616AB9480B0999FF46", hash_generated_method = "14575EB7D6B72E997FFB68BAECE2694A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PopupWindow(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        dsTaint.addTaint(defStyleRes);
        dsTaint.addTaint(defStyleAttr);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        mWindowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        TypedArray a;
        a = context.obtainStyledAttributes(
                attrs, com.android.internal.R.styleable.PopupWindow, defStyleAttr, defStyleRes);
        mBackground = a.getDrawable(R.styleable.PopupWindow_popupBackground);
        final int animStyle;
        animStyle = a.getResourceId(R.styleable.PopupWindow_popupAnimationStyle, -1);
        mAnimationStyle = animStyle == com.android.internal.R.style.Animation_PopupWindow ? -1 :
                animStyle;
        {
            StateListDrawable background;
            background = (StateListDrawable) mBackground;
            int aboveAnchorStateIndex;
            aboveAnchorStateIndex = background.getStateDrawableIndex(ABOVE_ANCHOR_STATE_SET);
            int count;
            count = background.getStateCount();
            int belowAnchorStateIndex;
            belowAnchorStateIndex = -1;
            {
                int i;
                i = 0;
                {
                    {
                        belowAnchorStateIndex = i;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                mAboveAnchorBackgroundDrawable = background.getStateDrawable(aboveAnchorStateIndex);
                mBelowAnchorBackgroundDrawable = background.getStateDrawable(belowAnchorStateIndex);
            } //End block
            {
                mBelowAnchorBackgroundDrawable = null;
                mAboveAnchorBackgroundDrawable = null;
            } //End block
        } //End block
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.200 -0400", hash_original_method = "E34384426EB8697F688915D9E72B588C", hash_generated_method = "F5AD70BF1572910755B1516D634FF5C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PopupWindow() {
        this(null, 0, 0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.200 -0400", hash_original_method = "57135C41538C9CD08914B3D745201B31", hash_generated_method = "2B0410CA4338ED89AE28CAC2DA2759C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PopupWindow(View contentView) {
        this(contentView, 0, 0);
        dsTaint.addTaint(contentView.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.200 -0400", hash_original_method = "52D8423742F4089F7506898A8921688C", hash_generated_method = "DACA81F8429CCE45F3918D172EE5BD18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PopupWindow(int width, int height) {
        this(null, width, height);
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.200 -0400", hash_original_method = "824FA1289D7F0041B91552EC537ECD03", hash_generated_method = "164DC0DA017447AC92D7E0E872777962")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PopupWindow(View contentView, int width, int height) {
        this(contentView, width, height, false);
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(contentView.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.200 -0400", hash_original_method = "45A20F34B738086A724C95615CA38820", hash_generated_method = "C59963A50B2FB88F6AFABC42597229C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PopupWindow(View contentView, int width, int height, boolean focusable) {
        dsTaint.addTaint(focusable);
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(contentView.dsTaint);
        {
            mContext = contentView.getContext();
            mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        } //End block
        setContentView(contentView);
        setWidth(width);
        setHeight(height);
        setFocusable(focusable);
        // ---------- Original Method ----------
        //if (contentView != null) {
            //mContext = contentView.getContext();
            //mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        //}
        //setContentView(contentView);
        //setWidth(width);
        //setHeight(height);
        //setFocusable(focusable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.200 -0400", hash_original_method = "63340AE07D2726BC056EFE5BE3E2FF29", hash_generated_method = "6960391C7C3078F3459E2D496BCC9985")
    @DSModeled(DSC.SAFE)
    public Drawable getBackground() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBackground;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.200 -0400", hash_original_method = "96D2484B6380046D33AB8470E20080B0", hash_generated_method = "B5A13F4FB654A117A6815610E0A239CE")
    @DSModeled(DSC.SAFE)
    public void setBackgroundDrawable(Drawable background) {
        dsTaint.addTaint(background.dsTaint);
        // ---------- Original Method ----------
        //mBackground = background;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.200 -0400", hash_original_method = "41CA7DA63F7D92402D2B673FD03355D6", hash_generated_method = "AD7D6FDA47288201F962FE4343373BD1")
    @DSModeled(DSC.SAFE)
    public int getAnimationStyle() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAnimationStyle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.201 -0400", hash_original_method = "A2D9F7F5158A57BAC36D16E33D2F221F", hash_generated_method = "5D58601B06DB734CB6E1BCDD26EFC795")
    @DSModeled(DSC.SAFE)
    public void setIgnoreCheekPress() {
        mIgnoreCheekPress = true;
        // ---------- Original Method ----------
        //mIgnoreCheekPress = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.201 -0400", hash_original_method = "46489C40917944BA93E8F6D8658EE802", hash_generated_method = "58C9A76EA4FB6FA33DDE83421CA922E3")
    @DSModeled(DSC.SAFE)
    public void setAnimationStyle(int animationStyle) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(animationStyle);
        // ---------- Original Method ----------
        //mAnimationStyle = animationStyle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.201 -0400", hash_original_method = "1FBDC8A7B1B2CCF1CAFCE9F94E1B072D", hash_generated_method = "D2023C5488A825FB0DE040640FA4D230")
    @DSModeled(DSC.SAFE)
    public View getContentView() {
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContentView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.201 -0400", hash_original_method = "647C3E968C5C98ECF0A359511A938D87", hash_generated_method = "6B5FA205281BE004C4CEA71809C48746")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentView(View contentView) {
        dsTaint.addTaint(contentView.dsTaint);
        {
            boolean var4A685BA46E35F21FC0CB2BDAFA9CFEA5_299524701 = (isShowing());
        } //End collapsed parenthetic
        {
            mContext = mContentView.getContext();
        } //End block
        {
            mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        } //End block
        // ---------- Original Method ----------
        //if (isShowing()) {
            //return;
        //}
        //mContentView = contentView;
        //if (mContext == null && mContentView != null) {
            //mContext = mContentView.getContext();
        //}
        //if (mWindowManager == null && mContentView != null) {
            //mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.201 -0400", hash_original_method = "DE25D00870282EA3EAE9EBB02519A2CA", hash_generated_method = "C841E8F05B480995E3F859950109CEEE")
    @DSModeled(DSC.SAFE)
    public void setTouchInterceptor(OnTouchListener l) {
        dsTaint.addTaint(l.dsTaint);
        // ---------- Original Method ----------
        //mTouchInterceptor = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.201 -0400", hash_original_method = "40BB85E3EB9B026A95FA1376FB5C6D2D", hash_generated_method = "873FBB1FA45FD41E0A8B376DCE80E54C")
    @DSModeled(DSC.SAFE)
    public boolean isFocusable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFocusable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.201 -0400", hash_original_method = "ABAB7A7DE4A915B0505D233953D72C47", hash_generated_method = "8EDB9742DFF093EEC792C3EB630230A3")
    @DSModeled(DSC.SAFE)
    public void setFocusable(boolean focusable) {
        dsTaint.addTaint(focusable);
        // ---------- Original Method ----------
        //mFocusable = focusable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.201 -0400", hash_original_method = "01F2BFCF39394BA4008813FFB1127C10", hash_generated_method = "59F02C6BD0B9C3DF36D41E3AAEC4DC70")
    @DSModeled(DSC.SAFE)
    public int getInputMethodMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mInputMethodMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.201 -0400", hash_original_method = "960CEBA1FA646F0DDCC5CA21C9FFA47A", hash_generated_method = "075FE1DA4A922C866A00275860D795D1")
    @DSModeled(DSC.SAFE)
    public void setInputMethodMode(int mode) {
        dsTaint.addTaint(mode);
        // ---------- Original Method ----------
        //mInputMethodMode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.201 -0400", hash_original_method = "4B11C5E74D17332CC7C67B3F22EF8E33", hash_generated_method = "A0BBDBD039EEC130017F318B480E8CD1")
    @DSModeled(DSC.SAFE)
    public void setSoftInputMode(int mode) {
        dsTaint.addTaint(mode);
        // ---------- Original Method ----------
        //mSoftInputMode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.201 -0400", hash_original_method = "76888AB414E08DF2E7D12678F406D7A5", hash_generated_method = "0A18B4663512CA9715BBCD7460980C1E")
    @DSModeled(DSC.SAFE)
    public int getSoftInputMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSoftInputMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.201 -0400", hash_original_method = "AE839D196CDFD95E127ACD4470F67375", hash_generated_method = "6C371F407B9EBBB0B400A19A8CAB4ABA")
    @DSModeled(DSC.SAFE)
    public boolean isTouchable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTouchable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.201 -0400", hash_original_method = "BEB1F63A70D555DEE12C0C7D4BDF7831", hash_generated_method = "5D510E60E4F6727A139AFA437AAF3E38")
    @DSModeled(DSC.SAFE)
    public void setTouchable(boolean touchable) {
        dsTaint.addTaint(touchable);
        // ---------- Original Method ----------
        //mTouchable = touchable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.201 -0400", hash_original_method = "FF3CAF88B8F1C23DC4869C5AECE8973C", hash_generated_method = "A7B1B981536B5C6E9FA8C5D3E9CAE88F")
    @DSModeled(DSC.SAFE)
    public boolean isOutsideTouchable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mOutsideTouchable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.201 -0400", hash_original_method = "8E0154BCB2D650E765619E048D3C66EA", hash_generated_method = "DBB8192D15682BFBF768C888A5A0EB43")
    @DSModeled(DSC.SAFE)
    public void setOutsideTouchable(boolean touchable) {
        dsTaint.addTaint(touchable);
        // ---------- Original Method ----------
        //mOutsideTouchable = touchable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.201 -0400", hash_original_method = "5D90AAFBBA18C52B8D43E4274612DFE0", hash_generated_method = "2922B4B4E9AD6ED5A30DED25691045DB")
    @DSModeled(DSC.SAFE)
    public boolean isClippingEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mClippingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.201 -0400", hash_original_method = "C644B67739A8A92EE97D978CC897DC79", hash_generated_method = "382B7593A7516AC64C321B3A012F48EC")
    @DSModeled(DSC.SAFE)
    public void setClippingEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        // ---------- Original Method ----------
        //mClippingEnabled = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.202 -0400", hash_original_method = "86AECB53D9496C7054030FB1672ECE9B", hash_generated_method = "0B1A04087EEE5D786FC509457725EAEA")
    @DSModeled(DSC.SAFE)
    public void setClipToScreenEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        setClippingEnabled(!enabled);
        // ---------- Original Method ----------
        //mClipToScreen = enabled;
        //setClippingEnabled(!enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.202 -0400", hash_original_method = "AB712E1EFFE4EAE7A80987CD7E1E8D4B", hash_generated_method = "1752B747FAED1FE68360F93727AB4BE3")
    @DSModeled(DSC.SAFE)
     void setAllowScrollingAnchorParent(boolean enabled) {
        dsTaint.addTaint(enabled);
        // ---------- Original Method ----------
        //mAllowScrollingAnchorParent = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.202 -0400", hash_original_method = "CD003A57AD290217AC32D20DAA9F9760", hash_generated_method = "9A4FBE886A990709B8C6DC19C651FB11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSplitTouchEnabled() {
        {
            boolean varEEA1697260544E0A5861DD090A86C488_246830391 = (mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mSplitTouchEnabled < 0 && mContext != null) {
            //return mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB;
        //}
        //return mSplitTouchEnabled == 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.202 -0400", hash_original_method = "8E279F2F2689369B00326EC855CADBF3", hash_generated_method = "0C480069387F3810A66C1D6CC413F764")
    @DSModeled(DSC.SAFE)
    public void setSplitTouchEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        mSplitTouchEnabled = enabled ? 1 : 0;
        // ---------- Original Method ----------
        //mSplitTouchEnabled = enabled ? 1 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.202 -0400", hash_original_method = "10EB43954998F08298066292E6DC8079", hash_generated_method = "4BA295D7D7A21879EB08A952662A299C")
    @DSModeled(DSC.SAFE)
    public boolean isLayoutInScreenEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLayoutInScreen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.202 -0400", hash_original_method = "181FE02772B59DB435AF1D6C410875BB", hash_generated_method = "21D33110FFA58DE84D7C96EBAD208990")
    @DSModeled(DSC.SAFE)
    public void setLayoutInScreenEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        // ---------- Original Method ----------
        //mLayoutInScreen = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.202 -0400", hash_original_method = "FEA07B591038B9982257E6B6F9EA89DD", hash_generated_method = "7F15349216B34960E3A20C3BAAD57F65")
    @DSModeled(DSC.SAFE)
    public void setLayoutInsetDecor(boolean enabled) {
        dsTaint.addTaint(enabled);
        // ---------- Original Method ----------
        //mLayoutInsetDecor = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.202 -0400", hash_original_method = "7DF3C488F6920E6663FDD36E5737A8E3", hash_generated_method = "D6FD6EAAD277D63D6512893737C18F40")
    @DSModeled(DSC.SAFE)
    public void setWindowLayoutType(int layoutType) {
        dsTaint.addTaint(layoutType);
        // ---------- Original Method ----------
        //mWindowLayoutType = layoutType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.202 -0400", hash_original_method = "B0A202A53A476A9F6F2E7DEE1AC7BFD5", hash_generated_method = "6494DA374160D8F28EB2D0D3ED3066AC")
    @DSModeled(DSC.SAFE)
    public int getWindowLayoutType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWindowLayoutType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.202 -0400", hash_original_method = "B8930E34962345C50EA9D19D5D77CFE8", hash_generated_method = "D89FB25CC45E1B7A22A4B9CD59CAB3E3")
    @DSModeled(DSC.SAFE)
    public void setTouchModal(boolean touchModal) {
        dsTaint.addTaint(touchModal);
        mNotTouchModal = !touchModal;
        // ---------- Original Method ----------
        //mNotTouchModal = !touchModal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.202 -0400", hash_original_method = "756D1E68507199C9976BFEB56A60134A", hash_generated_method = "491C9C3D8ABB6A024723AC40F915EBA3")
    @DSModeled(DSC.SAFE)
    public void setWindowLayoutMode(int widthSpec, int heightSpec) {
        dsTaint.addTaint(heightSpec);
        dsTaint.addTaint(widthSpec);
        // ---------- Original Method ----------
        //mWidthMode = widthSpec;
        //mHeightMode = heightSpec;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.202 -0400", hash_original_method = "0304EDCF78FF45B68A7EB91BFEAAA2CD", hash_generated_method = "CC661CC8E138503D6CC297B15DC90966")
    @DSModeled(DSC.SAFE)
    public int getHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.202 -0400", hash_original_method = "BA89F279BB207625BAE694FF1E8671B8", hash_generated_method = "EDF5C557003AC10FEBF367BBFCD23AE5")
    @DSModeled(DSC.SAFE)
    public void setHeight(int height) {
        dsTaint.addTaint(height);
        // ---------- Original Method ----------
        //mHeight = height;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.202 -0400", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "07BC2C797DF4D699CE54AAE3E293B5BF")
    @DSModeled(DSC.SAFE)
    public int getWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.202 -0400", hash_original_method = "684C7FEA8A4B53DA843B69F25AEC8ECA", hash_generated_method = "6EFF1238033ACDB365605247E4D3A601")
    @DSModeled(DSC.SAFE)
    public void setWidth(int width) {
        dsTaint.addTaint(width);
        // ---------- Original Method ----------
        //mWidth = width;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.202 -0400", hash_original_method = "2222AA4AEDF5C752B222A7F4E8915559", hash_generated_method = "8DC4BCE6EFBC80CA3730D6049F5A3052")
    @DSModeled(DSC.SAFE)
    public boolean isShowing() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsShowing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.202 -0400", hash_original_method = "7355F7E30A53327DA70C15AA0141C8AD", hash_generated_method = "CA10A9EDD0784EA586F589C3C544B4D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showAtLocation(View parent, int gravity, int x, int y) {
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(gravity);
        dsTaint.addTaint(x);
        showAtLocation(parent.getWindowToken(), gravity, x, y);
        // ---------- Original Method ----------
        //showAtLocation(parent.getWindowToken(), gravity, x, y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.203 -0400", hash_original_method = "B99D3AF8D05FDFEAE8059FF95B29B82E", hash_generated_method = "6D72062F9A9B6FFFE13D0BFE3CCE9FCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showAtLocation(IBinder token, int gravity, int x, int y) {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(gravity);
        dsTaint.addTaint(x);
        {
            boolean var9BC9BAF6F3002BB79EBDDA5435C62A79_50018222 = (isShowing() || mContentView == null);
        } //End collapsed parenthetic
        unregisterForScrollChanged();
        mIsShowing = true;
        mIsDropdown = false;
        WindowManager.LayoutParams p;
        p = createPopupLayout(token);
        p.windowAnimations = computeAnimationResource();
        preparePopup(p);
        {
            gravity = Gravity.TOP | Gravity.LEFT;
        } //End block
        p.gravity = gravity;
        p.x = x;
        p.y = y;
        p.height = mLastHeight = mHeightMode;
        p.width = mLastWidth = mWidthMode;
        invokePopup(p);
        // ---------- Original Method ----------
        //if (isShowing() || mContentView == null) {
            //return;
        //}
        //unregisterForScrollChanged();
        //mIsShowing = true;
        //mIsDropdown = false;
        //WindowManager.LayoutParams p = createPopupLayout(token);
        //p.windowAnimations = computeAnimationResource();
        //preparePopup(p);
        //if (gravity == Gravity.NO_GRAVITY) {
            //gravity = Gravity.TOP | Gravity.LEFT;
        //}
        //p.gravity = gravity;
        //p.x = x;
        //p.y = y;
        //if (mHeightMode < 0) p.height = mLastHeight = mHeightMode;
        //if (mWidthMode < 0) p.width = mLastWidth = mWidthMode;
        //invokePopup(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.203 -0400", hash_original_method = "C9F3BB2940AB236715592F07C984C554", hash_generated_method = "EFDF91AD94370CECEE4C8E5886BA9352")
    @DSModeled(DSC.SAFE)
    public void showAsDropDown(View anchor) {
        dsTaint.addTaint(anchor.dsTaint);
        showAsDropDown(anchor, 0, 0);
        // ---------- Original Method ----------
        //showAsDropDown(anchor, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.203 -0400", hash_original_method = "624B6ED3EB88D2A91AFF60DB37AE2E29", hash_generated_method = "BFBFC1106E244C8BF17E5EAE9B41C332")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        dsTaint.addTaint(xoff);
        dsTaint.addTaint(yoff);
        dsTaint.addTaint(anchor.dsTaint);
        {
            boolean var9BC9BAF6F3002BB79EBDDA5435C62A79_1225750586 = (isShowing() || mContentView == null);
        } //End collapsed parenthetic
        registerForScrollChanged(anchor, xoff, yoff);
        mIsShowing = true;
        mIsDropdown = true;
        WindowManager.LayoutParams p;
        p = createPopupLayout(anchor.getWindowToken());
        preparePopup(p);
        updateAboveAnchor(findDropDownPosition(anchor, p, xoff, yoff));
        p.height = mLastHeight = mHeightMode;
        p.width = mLastWidth = mWidthMode;
        p.windowAnimations = computeAnimationResource();
        invokePopup(p);
        // ---------- Original Method ----------
        //if (isShowing() || mContentView == null) {
            //return;
        //}
        //registerForScrollChanged(anchor, xoff, yoff);
        //mIsShowing = true;
        //mIsDropdown = true;
        //WindowManager.LayoutParams p = createPopupLayout(anchor.getWindowToken());
        //preparePopup(p);
        //updateAboveAnchor(findDropDownPosition(anchor, p, xoff, yoff));
        //if (mHeightMode < 0) p.height = mLastHeight = mHeightMode;
        //if (mWidthMode < 0) p.width = mLastWidth = mWidthMode;
        //p.windowAnimations = computeAnimationResource();
        //invokePopup(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.203 -0400", hash_original_method = "ACCF8C7A05331E8E4B71A7F0F84ED581", hash_generated_method = "486525C1433C791510C94DC1D72522E4")
    @DSModeled(DSC.SAFE)
    private void updateAboveAnchor(boolean aboveAnchor) {
        dsTaint.addTaint(aboveAnchor);
        {
            {
                {
                    {
                        mPopupView.setBackgroundDrawable(mAboveAnchorBackgroundDrawable);
                    } //End block
                    {
                        mPopupView.setBackgroundDrawable(mBelowAnchorBackgroundDrawable);
                    } //End block
                } //End block
                {
                    mPopupView.refreshDrawableState();
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (aboveAnchor != mAboveAnchor) {
            //mAboveAnchor = aboveAnchor;
            //if (mBackground != null) {
                //if (mAboveAnchorBackgroundDrawable != null) {
                    //if (mAboveAnchor) {
                        //mPopupView.setBackgroundDrawable(mAboveAnchorBackgroundDrawable);
                    //} else {
                        //mPopupView.setBackgroundDrawable(mBelowAnchorBackgroundDrawable);
                    //}
                //} else {
                    //mPopupView.refreshDrawableState();
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.203 -0400", hash_original_method = "3CCA39FA6959E2A6CCCA2648E4E5EA51", hash_generated_method = "B95BBF5F5B8000CAD379B4024039CF30")
    @DSModeled(DSC.SAFE)
    public boolean isAboveAnchor() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAboveAnchor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.203 -0400", hash_original_method = "DA370B626B41FE86866E281D10A5B6B7", hash_generated_method = "CA2E8A6E75C0B55233A212108AD61FB3")
    @DSModeled(DSC.SAFE)
    private void preparePopup(WindowManager.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("You must specify a valid content view by "
                    + "calling setContentView() before attempting to show the popup.");
        } //End block
        {
            final ViewGroup.LayoutParams layoutParams;
            layoutParams = mContentView.getLayoutParams();
            int height;
            height = ViewGroup.LayoutParams.MATCH_PARENT;
            {
                height = ViewGroup.LayoutParams.WRAP_CONTENT;
            } //End block
            PopupViewContainer popupViewContainer;
            popupViewContainer = new PopupViewContainer(mContext);
            PopupViewContainer.LayoutParams listParams;
            listParams = new PopupViewContainer.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, height
            );
            popupViewContainer.setBackgroundDrawable(mBackground);
            popupViewContainer.addView(mContentView, listParams);
            mPopupView = popupViewContainer;
        } //End block
        {
            mPopupView = mContentView;
        } //End block
        mPopupWidth = p.width;
        mPopupHeight = p.height;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.203 -0400", hash_original_method = "CC3762287DEDA3D715BCCB052800207D", hash_generated_method = "B35679722384DFC0162224A5D689CA93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void invokePopup(WindowManager.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        {
            p.packageName = mContext.getPackageName();
        } //End block
        mPopupView.setFitsSystemWindows(mLayoutInsetDecor);
        mWindowManager.addView(mPopupView, p);
        // ---------- Original Method ----------
        //if (mContext != null) {
            //p.packageName = mContext.getPackageName();
        //}
        //mPopupView.setFitsSystemWindows(mLayoutInsetDecor);
        //mWindowManager.addView(mPopupView, p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.204 -0400", hash_original_method = "D97E1B6317AF67D9DC41A6FB19D27D69", hash_generated_method = "DCD2475C61D23B92951C7D0892B5850C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private WindowManager.LayoutParams createPopupLayout(IBinder token) {
        dsTaint.addTaint(token.dsTaint);
        WindowManager.LayoutParams p;
        p = new WindowManager.LayoutParams();
        p.gravity = Gravity.LEFT | Gravity.TOP;
        p.width = mLastWidth = mWidth;
        p.height = mLastHeight = mHeight;
        {
            p.format = mBackground.getOpacity();
        } //End block
        {
            p.format = PixelFormat.TRANSLUCENT;
        } //End block
        p.flags = computeFlags(p.flags);
        p.type = mWindowLayoutType;
        p.token = token;
        p.softInputMode = mSoftInputMode;
        p.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return (WindowManager.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //WindowManager.LayoutParams p = new WindowManager.LayoutParams();
        //p.gravity = Gravity.LEFT | Gravity.TOP;
        //p.width = mLastWidth = mWidth;
        //p.height = mLastHeight = mHeight;
        //if (mBackground != null) {
            //p.format = mBackground.getOpacity();
        //} else {
            //p.format = PixelFormat.TRANSLUCENT;
        //}
        //p.flags = computeFlags(p.flags);
        //p.type = mWindowLayoutType;
        //p.token = token;
        //p.softInputMode = mSoftInputMode;
        //p.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.204 -0400", hash_original_method = "731A130870E20EEF0406E3AA79CC1D53", hash_generated_method = "501B69BA182947814501D5E5A9A4A2F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int computeFlags(int curFlags) {
        dsTaint.addTaint(curFlags);
        curFlags &= ~(
                WindowManager.LayoutParams.FLAG_IGNORE_CHEEK_PRESSES |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE |
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH |
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS |
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM |
                WindowManager.LayoutParams.FLAG_SPLIT_TOUCH);
        {
            curFlags |= WindowManager.LayoutParams.FLAG_IGNORE_CHEEK_PRESSES;
        } //End block
        {
            curFlags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
            {
                curFlags |= WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
            } //End block
        } //End block
        {
            curFlags |= WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
        } //End block
        {
            curFlags |= WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        } //End block
        {
            curFlags |= WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
        } //End block
        {
            curFlags |= WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
        } //End block
        {
            boolean varC512B087080D8F65FDEBB4C012341A4B_1772597659 = (isSplitTouchEnabled());
            {
                curFlags |= WindowManager.LayoutParams.FLAG_SPLIT_TOUCH;
            } //End block
        } //End collapsed parenthetic
        {
            curFlags |= WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
        } //End block
        {
            curFlags |= WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR;
        } //End block
        {
            curFlags |= WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.204 -0400", hash_original_method = "2B29575EF3002A68968C6947831DCCDB", hash_generated_method = "D7C3D445CC821F17D8D8A92BA7946D43")
    @DSModeled(DSC.SAFE)
    private int computeAnimationResource() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mAnimationStyle == -1) {
            //if (mIsDropdown) {
                //return mAboveAnchor
                        //? com.android.internal.R.style.Animation_DropDownUp
                        //: com.android.internal.R.style.Animation_DropDownDown;
            //}
            //return 0;
        //}
        //return mAnimationStyle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.205 -0400", hash_original_method = "5A11C37B27567E510AD1092CF1C461D0", hash_generated_method = "B93F980D73133B916D0BB89EA870FE6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean findDropDownPosition(View anchor, WindowManager.LayoutParams p,
            int xoff, int yoff) {
        dsTaint.addTaint(xoff);
        dsTaint.addTaint(p.dsTaint);
        dsTaint.addTaint(yoff);
        dsTaint.addTaint(anchor.dsTaint);
        final int anchorHeight;
        anchorHeight = anchor.getHeight();
        anchor.getLocationInWindow(mDrawingLocation);
        p.x = mDrawingLocation[0] + xoff;
        p.y = mDrawingLocation[1] + anchorHeight + yoff;
        boolean onTop;
        onTop = false;
        p.gravity = Gravity.LEFT | Gravity.TOP;
        anchor.getLocationOnScreen(mScreenLocation);
        final Rect displayFrame;
        displayFrame = new Rect();
        anchor.getWindowVisibleDisplayFrame(displayFrame);
        int screenY;
        screenY = mScreenLocation[1] + anchorHeight + yoff;
        final View root;
        root = anchor.getRootView();
        {
            boolean var74CA561700F828A0D92807B977326861_2018950580 = (screenY + mPopupHeight > displayFrame.bottom ||
                p.x + mPopupWidth - root.getWidth() > 0);
            {
                {
                    int scrollX;
                    scrollX = anchor.getScrollX();
                    int scrollY;
                    scrollY = anchor.getScrollY();
                    Rect r;
                    r = new Rect(scrollX, scrollY,  scrollX + mPopupWidth + xoff,
                        scrollY + mPopupHeight + anchor.getHeight() + yoff);
                    anchor.requestRectangleOnScreen(r, true);
                } //End block
                anchor.getLocationInWindow(mDrawingLocation);
                p.x = mDrawingLocation[0] + xoff;
                p.y = mDrawingLocation[1] + anchor.getHeight() + yoff;
                anchor.getLocationOnScreen(mScreenLocation);
                onTop = (displayFrame.bottom - mScreenLocation[1] - anchor.getHeight() - yoff) <
                    (mScreenLocation[1] - yoff - displayFrame.top);
                {
                    p.gravity = Gravity.LEFT | Gravity.BOTTOM;
                    p.y = root.getHeight() - mDrawingLocation[1] + yoff;
                } //End block
                {
                    p.y = mDrawingLocation[1] + anchor.getHeight() + yoff;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            final int displayFrameWidth;
            displayFrameWidth = displayFrame.right - displayFrame.left;
            int right;
            right = p.x + p.width;
            {
                p.x -= right - displayFrameWidth;
            } //End block
            {
                p.x = displayFrame.left;
                p.width = Math.min(p.width, displayFrameWidth);
            } //End block
            {
                int popupTop;
                popupTop = mScreenLocation[1] + yoff - mPopupHeight;
                {
                    p.y += popupTop;
                } //End block
            } //End block
            {
                p.y = Math.max(p.y, displayFrame.top);
            } //End block
        } //End block
        p.gravity |= Gravity.DISPLAY_CLIP_VERTICAL;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.205 -0400", hash_original_method = "023150F59911D5483F51543A59288631", hash_generated_method = "A94E1920C5CC28614EC5957F0E4D5023")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaxAvailableHeight(View anchor) {
        dsTaint.addTaint(anchor.dsTaint);
        int varA711B8768F5CD08E9377B11ECAC1715F_1270431993 = (getMaxAvailableHeight(anchor, 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getMaxAvailableHeight(anchor, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.205 -0400", hash_original_method = "782C0234D711C16ED6DF402CCEC14809", hash_generated_method = "38AD9260D742CD157D229B5E287E41CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaxAvailableHeight(View anchor, int yOffset) {
        dsTaint.addTaint(yOffset);
        dsTaint.addTaint(anchor.dsTaint);
        int var469BE61637FC70E4C9728196B89D54FF_642139251 = (getMaxAvailableHeight(anchor, yOffset, false));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getMaxAvailableHeight(anchor, yOffset, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.205 -0400", hash_original_method = "6127242297D2005B4B3434B0EF072B4C", hash_generated_method = "4B8D979B0613EAB6B0D07C64144EA8F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaxAvailableHeight(View anchor, int yOffset, boolean ignoreBottomDecorations) {
        dsTaint.addTaint(ignoreBottomDecorations);
        dsTaint.addTaint(yOffset);
        dsTaint.addTaint(anchor.dsTaint);
        final Rect displayFrame;
        displayFrame = new Rect();
        anchor.getWindowVisibleDisplayFrame(displayFrame);
        final int[] anchorPos;
        anchorPos = mDrawingLocation;
        anchor.getLocationOnScreen(anchorPos);
        int bottomEdge;
        bottomEdge = displayFrame.bottom;
        {
            Resources res;
            res = anchor.getContext().getResources();
            bottomEdge = res.getDisplayMetrics().heightPixels;
        } //End block
        final int distanceToBottom;
        distanceToBottom = bottomEdge - (anchorPos[1] + anchor.getHeight()) - yOffset;
        final int distanceToTop;
        distanceToTop = anchorPos[1] - displayFrame.top + yOffset;
        int returnedHeight;
        returnedHeight = Math.max(distanceToBottom, distanceToTop);
        {
            mBackground.getPadding(mTempRect);
            returnedHeight -= mTempRect.top + mTempRect.bottom;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.205 -0400", hash_original_method = "206A53D80E1660978DCF21A355028E66", hash_generated_method = "CA10D31EAE931DA8CC95D22E481D1BAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dismiss() {
        {
            boolean var2C554DDD957DC9A014B8B4DE4C803696_484037986 = (isShowing() && mPopupView != null);
            {
                mIsShowing = false;
                unregisterForScrollChanged();
                try 
                {
                    mWindowManager.removeView(mPopupView);
                } //End block
                finally 
                {
                    {
                        ((ViewGroup) mPopupView).removeView(mContentView);
                    } //End block
                    mPopupView = null;
                    {
                        mOnDismissListener.onDismiss();
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isShowing() && mPopupView != null) {
            //mIsShowing = false;
            //unregisterForScrollChanged();
            //try {
                //mWindowManager.removeView(mPopupView);                
            //} finally {
                //if (mPopupView != mContentView && mPopupView instanceof ViewGroup) {
                    //((ViewGroup) mPopupView).removeView(mContentView);
                //}
                //mPopupView = null;
                //if (mOnDismissListener != null) {
                    //mOnDismissListener.onDismiss();
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.205 -0400", hash_original_method = "93E9EBCE36575249CB74D4FBEF26A1CF", hash_generated_method = "FC02A15CABDCED08070E0A573C90A217")
    @DSModeled(DSC.SAFE)
    public void setOnDismissListener(OnDismissListener onDismissListener) {
        dsTaint.addTaint(onDismissListener.dsTaint);
        // ---------- Original Method ----------
        //mOnDismissListener = onDismissListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.206 -0400", hash_original_method = "488D5DDCA6B0F8C983ED8CA34502865A", hash_generated_method = "5B7EB1FB00DE521250F4750A8289D7B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void update() {
        {
            boolean var792B694D840F3959F85BC36B57C55AEF_1969707689 = (!isShowing() || mContentView == null);
        } //End collapsed parenthetic
        WindowManager.LayoutParams p;
        p = (WindowManager.LayoutParams)
                mPopupView.getLayoutParams();
        boolean update;
        update = false;
        final int newAnim;
        newAnim = computeAnimationResource();
        {
            p.windowAnimations = newAnim;
            update = true;
        } //End block
        final int newFlags;
        newFlags = computeFlags(p.flags);
        {
            p.flags = newFlags;
            update = true;
        } //End block
        {
            mWindowManager.updateViewLayout(mPopupView, p);
        } //End block
        // ---------- Original Method ----------
        //if (!isShowing() || mContentView == null) {
            //return;
        //}
        //WindowManager.LayoutParams p = (WindowManager.LayoutParams)
                //mPopupView.getLayoutParams();
        //boolean update = false;
        //final int newAnim = computeAnimationResource();
        //if (newAnim != p.windowAnimations) {
            //p.windowAnimations = newAnim;
            //update = true;
        //}
        //final int newFlags = computeFlags(p.flags);
        //if (newFlags != p.flags) {
            //p.flags = newFlags;
            //update = true;
        //}
        //if (update) {
            //mWindowManager.updateViewLayout(mPopupView, p);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.206 -0400", hash_original_method = "99E415F6DCFBC1202511EEF5D071A55C", hash_generated_method = "B71F0A9CCFB77BD5E6FE3EBC4BAACEA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void update(int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        WindowManager.LayoutParams p;
        p = (WindowManager.LayoutParams)
                mPopupView.getLayoutParams();
        update(p.x, p.y, width, height, false);
        // ---------- Original Method ----------
        //WindowManager.LayoutParams p = (WindowManager.LayoutParams)
                //mPopupView.getLayoutParams();
        //update(p.x, p.y, width, height, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.206 -0400", hash_original_method = "848B641343A16858C863B802CDF64CDF", hash_generated_method = "A92375E6D0E99032AD16DD870264DB7A")
    @DSModeled(DSC.SAFE)
    public void update(int x, int y, int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        update(x, y, width, height, false);
        // ---------- Original Method ----------
        //update(x, y, width, height, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.206 -0400", hash_original_method = "7F49F99468193710A8807FDE38269850", hash_generated_method = "66BFA34AB4F20AB31D6FBE9BF6E564A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void update(int x, int y, int width, int height, boolean force) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(force);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            setWidth(width);
        } //End block
        {
            setHeight(height);
        } //End block
        {
            boolean var792B694D840F3959F85BC36B57C55AEF_122470708 = (!isShowing() || mContentView == null);
        } //End collapsed parenthetic
        WindowManager.LayoutParams p;
        p = (WindowManager.LayoutParams) mPopupView.getLayoutParams();
        boolean update;
        update = force;
        int finalWidth;
        finalWidth = mWidthMode;
        finalWidth = mLastWidth;
        {
            p.width = mLastWidth = finalWidth;
            update = true;
        } //End block
        int finalHeight;
        finalHeight = mHeightMode;
        finalHeight = mLastHeight;
        {
            p.height = mLastHeight = finalHeight;
            update = true;
        } //End block
        {
            p.x = x;
            update = true;
        } //End block
        {
            p.y = y;
            update = true;
        } //End block
        final int newAnim;
        newAnim = computeAnimationResource();
        {
            p.windowAnimations = newAnim;
            update = true;
        } //End block
        final int newFlags;
        newFlags = computeFlags(p.flags);
        {
            p.flags = newFlags;
            update = true;
        } //End block
        {
            mWindowManager.updateViewLayout(mPopupView, p);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.206 -0400", hash_original_method = "2E7624B1CB6DF9766B6E25C708FAA465", hash_generated_method = "5F191946E458A1B871C71223C3E04BCD")
    @DSModeled(DSC.SAFE)
    public void update(View anchor, int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(anchor.dsTaint);
        update(anchor, false, 0, 0, true, width, height);
        // ---------- Original Method ----------
        //update(anchor, false, 0, 0, true, width, height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.206 -0400", hash_original_method = "B8D2EE4CAAF22B5FC8CA5A06E5BF0669", hash_generated_method = "AE2D603576727A2197D14D87D6D1D49B")
    @DSModeled(DSC.SAFE)
    public void update(View anchor, int xoff, int yoff, int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(xoff);
        dsTaint.addTaint(width);
        dsTaint.addTaint(yoff);
        dsTaint.addTaint(anchor.dsTaint);
        update(anchor, true, xoff, yoff, true, width, height);
        // ---------- Original Method ----------
        //update(anchor, true, xoff, yoff, true, width, height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.207 -0400", hash_original_method = "F5290879A773899EB945D797134BA900", hash_generated_method = "C07ED8FE35C693B2B15C509A1855B2E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void update(View anchor, boolean updateLocation, int xoff, int yoff,
            boolean updateDimension, int width, int height) {
        dsTaint.addTaint(updateDimension);
        dsTaint.addTaint(height);
        dsTaint.addTaint(xoff);
        dsTaint.addTaint(width);
        dsTaint.addTaint(yoff);
        dsTaint.addTaint(updateLocation);
        dsTaint.addTaint(anchor.dsTaint);
        {
            boolean var792B694D840F3959F85BC36B57C55AEF_406913421 = (!isShowing() || mContentView == null);
        } //End collapsed parenthetic
        WeakReference<View> oldAnchor;
        oldAnchor = mAnchor;
        final boolean needsUpdate;
        needsUpdate = updateLocation && (mAnchorXoff != xoff || mAnchorYoff != yoff);
        {
            boolean varBA4588A4E37197031A7BA0375487BCBA_429697656 = (oldAnchor == null || oldAnchor.get() != anchor || (needsUpdate && !mIsDropdown));
            {
                registerForScrollChanged(anchor, xoff, yoff);
            } //End block
        } //End collapsed parenthetic
        WindowManager.LayoutParams p;
        p = (WindowManager.LayoutParams) mPopupView.getLayoutParams();
        {
            {
                width = mPopupWidth;
            } //End block
            {
                height = mPopupHeight;
            } //End block
        } //End block
        int x;
        x = p.x;
        int y;
        y = p.y;
        {
            updateAboveAnchor(findDropDownPosition(anchor, p, xoff, yoff));
        } //End block
        {
            updateAboveAnchor(findDropDownPosition(anchor, p, mAnchorXoff, mAnchorYoff));
        } //End block
        update(p.x, p.y, width, height, x != p.x || y != p.y);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.207 -0400", hash_original_method = "032144363E44618DF1C4EE95BC82AD16", hash_generated_method = "F88D3421F71EE5A0FCBF1F486C04CC02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void unregisterForScrollChanged() {
        WeakReference<View> anchorRef;
        anchorRef = mAnchor;
        View anchor;
        anchor = null;
        {
            anchor = anchorRef.get();
        } //End block
        {
            ViewTreeObserver vto;
            vto = anchor.getViewTreeObserver();
            vto.removeOnScrollChangedListener(mOnScrollChangedListener);
        } //End block
        mAnchor = null;
        // ---------- Original Method ----------
        //WeakReference<View> anchorRef = mAnchor;
        //View anchor = null;
        //if (anchorRef != null) {
            //anchor = anchorRef.get();
        //}
        //if (anchor != null) {
            //ViewTreeObserver vto = anchor.getViewTreeObserver();
            //vto.removeOnScrollChangedListener(mOnScrollChangedListener);
        //}
        //mAnchor = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.207 -0400", hash_original_method = "F426C621D66F93AA8E883C7FBA8C8657", hash_generated_method = "47D96E6B1248177AA3D562378C7DE09C")
    @DSModeled(DSC.SAFE)
    private void registerForScrollChanged(View anchor, int xoff, int yoff) {
        dsTaint.addTaint(xoff);
        dsTaint.addTaint(yoff);
        dsTaint.addTaint(anchor.dsTaint);
        unregisterForScrollChanged();
        mAnchor = new WeakReference<View>(anchor);
        ViewTreeObserver vto;
        vto = anchor.getViewTreeObserver();
        {
            vto.addOnScrollChangedListener(mOnScrollChangedListener);
        } //End block
        // ---------- Original Method ----------
        //unregisterForScrollChanged();
        //mAnchor = new WeakReference<View>(anchor);
        //ViewTreeObserver vto = anchor.getViewTreeObserver();
        //if (vto != null) {
            //vto.addOnScrollChangedListener(mOnScrollChangedListener);
        //}
        //mAnchorXoff = xoff;
        //mAnchorYoff = yoff;
    }

    
    private class PopupViewContainer extends FrameLayout {
        private static final String TAG = "PopupWindow.PopupViewContainer";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.207 -0400", hash_original_method = "2CEF1E9B6EE64B78C8FCC7C360A10341", hash_generated_method = "0B5B1F3AEDE34C38E1FF92BAD8B7CCD2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PopupViewContainer(Context context) {
            super(context);
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.207 -0400", hash_original_method = "60250F32C750F199B013D0293AAF47D3", hash_generated_method = "F1E8BAF0C3318E821EBDB011E86FFA1D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected int[] onCreateDrawableState(int extraSpace) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(extraSpace);
            {
                final int[] drawableState;
                drawableState = super.onCreateDrawableState(extraSpace + 1);
                View.mergeDrawableStates(drawableState, ABOVE_ANCHOR_STATE_SET);
            } //End block
            {
                int[] var74CE87D3619881427F9757CCE4F4BF6A_1928454968 = (super.onCreateDrawableState(extraSpace));
            } //End block
            int[] retVal = new int[1];
            retVal[0] = dsTaint.getTaintInt();
            return retVal;
            // ---------- Original Method ----------
            //if (mAboveAnchor) {
                //final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
                //View.mergeDrawableStates(drawableState, ABOVE_ANCHOR_STATE_SET);
                //return drawableState;
            //} else {
                //return super.onCreateDrawableState(extraSpace);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.207 -0400", hash_original_method = "A2DD55E78C6B8B19849AEC8708A214E9", hash_generated_method = "AA4A545E5C8CC4676254A5317BB570ED")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            dsTaint.addTaint(event.dsTaint);
            {
                boolean varC71B767C5D14CF758CFC7EA9349BEE50_1090728810 = (event.getKeyCode() == KeyEvent.KEYCODE_BACK);
                {
                    {
                        boolean var0530024EDAEF285FA074A5D0CCF9FBC3_1200553357 = (getKeyDispatcherState() == null);
                        {
                            boolean var9B794F99509F39111FB8A6A64D542633_1387730650 = (super.dispatchKeyEvent(event));
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varF456D875C94EFA50F4F83E456081D7DC_1665857140 = (event.getAction() == KeyEvent.ACTION_DOWN
                        && event.getRepeatCount() == 0);
                        {
                            KeyEvent.DispatcherState state;
                            state = getKeyDispatcherState();
                            {
                                state.startTracking(event, this);
                            } //End block
                        } //End block
                        {
                            boolean var6A33DE310C5D908541C47FFDD30D2802_762542218 = (event.getAction() == KeyEvent.ACTION_UP);
                            {
                                KeyEvent.DispatcherState state;
                                state = getKeyDispatcherState();
                                {
                                    boolean var220DFBBB57806723689C9C46DFE1C558_231508487 = (state != null && state.isTracking(event) && !event.isCanceled());
                                    {
                                        dismiss();
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                    boolean var97BD0C91372FF8CDE07B475E38FE656A_368450993 = (super.dispatchKeyEvent(event));
                } //End block
                {
                    boolean var97BD0C91372FF8CDE07B475E38FE656A_1147660967 = (super.dispatchKeyEvent(event));
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.208 -0400", hash_original_method = "C7733BB60CAB256C1ABFC72965DD2E24", hash_generated_method = "2A27998C215DCC8E6819A5E7CE170ECC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            dsTaint.addTaint(ev.dsTaint);
            {
                boolean var93C4222DC4A59A9B32842AA419F1377C_255262521 = (mTouchInterceptor != null && mTouchInterceptor.onTouch(this, ev));
            } //End collapsed parenthetic
            boolean varD9CFC974DB9B4187D396B15CE784ECB1_333689275 = (super.dispatchTouchEvent(ev));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (mTouchInterceptor != null && mTouchInterceptor.onTouch(this, ev)) {
                //return true;
            //}
            //return super.dispatchTouchEvent(ev);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.208 -0400", hash_original_method = "2EFE76B74388A6782646D0ACFFECA21F", hash_generated_method = "226B7890A071977E325D22AA3C34F0E3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(event.dsTaint);
            final int x;
            x = (int) event.getX();
            final int y;
            y = (int) event.getY();
            {
                boolean var0FCE2C8AA5CE2F3DB17871F164D2ABD3_1773348021 = ((event.getAction() == MotionEvent.ACTION_DOWN)
                    && ((x < 0) || (x >= getWidth()) || (y < 0) || (y >= getHeight())));
                {
                    dismiss();
                } //End block
                {
                    boolean var267E05D3737D25CB7AC9FBB08A12D390_1694074918 = (event.getAction() == MotionEvent.ACTION_OUTSIDE);
                    {
                        dismiss();
                    } //End block
                    {
                        boolean varEFC6B821CDB4DB5344876A10D775A068_1656408367 = (super.onTouchEvent(event));
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //final int x = (int) event.getX();
            //final int y = (int) event.getY();
            //if ((event.getAction() == MotionEvent.ACTION_DOWN)
                    //&& ((x < 0) || (x >= getWidth()) || (y < 0) || (y >= getHeight()))) {
                //dismiss();
                //return true;
            //} else if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                //dismiss();
                //return true;
            //} else {
                //return super.onTouchEvent(event);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.208 -0400", hash_original_method = "EB4F4EE30B31AEB9BDFF308A3D2D5CAC", hash_generated_method = "774C4105B19BC4AF8E7652E7FE63F4D6")
        @DSModeled(DSC.SAFE)
        @Override
        public void sendAccessibilityEvent(int eventType) {
            dsTaint.addTaint(eventType);
            {
                mContentView.sendAccessibilityEvent(eventType);
            } //End block
            {
                super.sendAccessibilityEvent(eventType);
            } //End block
            // ---------- Original Method ----------
            //if (mContentView != null) {
                //mContentView.sendAccessibilityEvent(eventType);
            //} else {
                //super.sendAccessibilityEvent(eventType);
            //}
        }

        
    }


    
    public interface OnDismissListener {
        
        public void onDismiss();
    }
    
}


