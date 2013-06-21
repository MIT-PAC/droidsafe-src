package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.R;
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
import java.lang.ref.WeakReference;

public class PopupWindow {
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
    private WeakReference<View> mAnchor;
    private OnScrollChangedListener mOnScrollChangedListener = new OnScrollChangedListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.982 -0400", hash_original_method = "8F0CC5ACEB252AEA9146DA3982ED4810", hash_generated_method = "1F2D12D00022C0731CEBA3D61231C987")
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.982 -0400", hash_original_method = "A7D29AF9F459F2E9972F382B06EBA7BC", hash_generated_method = "4CED1785F3883C59E0FC404C924B9571")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PopupWindow(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.983 -0400", hash_original_method = "366007D96D9B418EA2EA6640B7FB7C46", hash_generated_method = "ED86D6062F3F7563F812A28DDE36FF66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PopupWindow(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.popupWindowStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.983 -0400", hash_original_method = "FAD82A2A4F32A008B236FC8E4F83669F", hash_generated_method = "E5C17F6FF156DAC590740ABF0EC48517")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PopupWindow(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, 0);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.983 -0400", hash_original_method = "079F601C7A8694616AB9480B0999FF46", hash_generated_method = "72A77036AD1B6A817479CE6CDECDEADB")
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
        int animStyle;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.984 -0400", hash_original_method = "E34384426EB8697F688915D9E72B588C", hash_generated_method = "596F84E29B0A712DA0AAE3A0BA66CFD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PopupWindow() {
        this(null, 0, 0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.984 -0400", hash_original_method = "57135C41538C9CD08914B3D745201B31", hash_generated_method = "6363D595C9485EDD93A35E37FAA8548B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PopupWindow(View contentView) {
        this(contentView, 0, 0);
        dsTaint.addTaint(contentView.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.984 -0400", hash_original_method = "52D8423742F4089F7506898A8921688C", hash_generated_method = "645CB7A245B52DC6931D60CD1F77B123")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PopupWindow(int width, int height) {
        this(null, width, height);
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.984 -0400", hash_original_method = "824FA1289D7F0041B91552EC537ECD03", hash_generated_method = "8F6281BE45B77220CC34BF18DCB7F20E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PopupWindow(View contentView, int width, int height) {
        this(contentView, width, height, false);
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(contentView.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.984 -0400", hash_original_method = "45A20F34B738086A724C95615CA38820", hash_generated_method = "EE68F4E365F847D59C4CD8F89D908CE7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.984 -0400", hash_original_method = "63340AE07D2726BC056EFE5BE3E2FF29", hash_generated_method = "21B193E0967196A34A5D6C5645071B75")
    @DSModeled(DSC.SAFE)
    public Drawable getBackground() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBackground;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.985 -0400", hash_original_method = "96D2484B6380046D33AB8470E20080B0", hash_generated_method = "1709A7CB6DCE0B9E248CAA8B3F402522")
    @DSModeled(DSC.SAFE)
    public void setBackgroundDrawable(Drawable background) {
        dsTaint.addTaint(background.dsTaint);
        // ---------- Original Method ----------
        //mBackground = background;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.985 -0400", hash_original_method = "41CA7DA63F7D92402D2B673FD03355D6", hash_generated_method = "730DA9344EF429DDE0A21685D7304D11")
    @DSModeled(DSC.SAFE)
    public int getAnimationStyle() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAnimationStyle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.985 -0400", hash_original_method = "A2D9F7F5158A57BAC36D16E33D2F221F", hash_generated_method = "BCC06A2E85690E757FF10740FDE4D8C7")
    @DSModeled(DSC.SAFE)
    public void setIgnoreCheekPress() {
        mIgnoreCheekPress = true;
        // ---------- Original Method ----------
        //mIgnoreCheekPress = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.985 -0400", hash_original_method = "46489C40917944BA93E8F6D8658EE802", hash_generated_method = "56972EB16FE174226F722756D1C46EF1")
    @DSModeled(DSC.SAFE)
    public void setAnimationStyle(int animationStyle) {
        dsTaint.addTaint(animationStyle);
        // ---------- Original Method ----------
        //mAnimationStyle = animationStyle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.985 -0400", hash_original_method = "1FBDC8A7B1B2CCF1CAFCE9F94E1B072D", hash_generated_method = "461D848C10F9E16D5F0A59F1E988B6BC")
    @DSModeled(DSC.SAFE)
    public View getContentView() {
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContentView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.986 -0400", hash_original_method = "647C3E968C5C98ECF0A359511A938D87", hash_generated_method = "55259E134A70BB592604D98430EEF811")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentView(View contentView) {
        dsTaint.addTaint(contentView.dsTaint);
        {
            boolean var4A685BA46E35F21FC0CB2BDAFA9CFEA5_1496926777 = (isShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.986 -0400", hash_original_method = "DE25D00870282EA3EAE9EBB02519A2CA", hash_generated_method = "E250301E77142AB38BC647C7BF37EEF4")
    @DSModeled(DSC.SAFE)
    public void setTouchInterceptor(OnTouchListener l) {
        dsTaint.addTaint(l.dsTaint);
        // ---------- Original Method ----------
        //mTouchInterceptor = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.986 -0400", hash_original_method = "40BB85E3EB9B026A95FA1376FB5C6D2D", hash_generated_method = "822D07B496179847F704F9DA37606B14")
    @DSModeled(DSC.SAFE)
    public boolean isFocusable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFocusable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.986 -0400", hash_original_method = "ABAB7A7DE4A915B0505D233953D72C47", hash_generated_method = "327E85E6CD6C09CEB29AF65FE352A7F8")
    @DSModeled(DSC.SAFE)
    public void setFocusable(boolean focusable) {
        dsTaint.addTaint(focusable);
        // ---------- Original Method ----------
        //mFocusable = focusable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.986 -0400", hash_original_method = "01F2BFCF39394BA4008813FFB1127C10", hash_generated_method = "D686AED94BD8264DBE7A8EEF96D79F39")
    @DSModeled(DSC.SAFE)
    public int getInputMethodMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mInputMethodMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.986 -0400", hash_original_method = "960CEBA1FA646F0DDCC5CA21C9FFA47A", hash_generated_method = "7A3F23BAA393C348E5EDD82DC8E08CD2")
    @DSModeled(DSC.SAFE)
    public void setInputMethodMode(int mode) {
        dsTaint.addTaint(mode);
        // ---------- Original Method ----------
        //mInputMethodMode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.986 -0400", hash_original_method = "4B11C5E74D17332CC7C67B3F22EF8E33", hash_generated_method = "DC469E15B2E5E6F5A24BBAF4CFA814F1")
    @DSModeled(DSC.SAFE)
    public void setSoftInputMode(int mode) {
        dsTaint.addTaint(mode);
        // ---------- Original Method ----------
        //mSoftInputMode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.987 -0400", hash_original_method = "76888AB414E08DF2E7D12678F406D7A5", hash_generated_method = "F6408571B6A6D72188F6C92B64A9B6D1")
    @DSModeled(DSC.SAFE)
    public int getSoftInputMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSoftInputMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.987 -0400", hash_original_method = "AE839D196CDFD95E127ACD4470F67375", hash_generated_method = "D460C883FDFBDDBD334E4EBFB1A61577")
    @DSModeled(DSC.SAFE)
    public boolean isTouchable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTouchable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.987 -0400", hash_original_method = "BEB1F63A70D555DEE12C0C7D4BDF7831", hash_generated_method = "0FD3AAE6BAB8F09590819C7326B19728")
    @DSModeled(DSC.SAFE)
    public void setTouchable(boolean touchable) {
        dsTaint.addTaint(touchable);
        // ---------- Original Method ----------
        //mTouchable = touchable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.987 -0400", hash_original_method = "FF3CAF88B8F1C23DC4869C5AECE8973C", hash_generated_method = "CC97289AC4207AEE75FABDA0525822FE")
    @DSModeled(DSC.SAFE)
    public boolean isOutsideTouchable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mOutsideTouchable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.987 -0400", hash_original_method = "8E0154BCB2D650E765619E048D3C66EA", hash_generated_method = "BE9EFA8D4A2B6FC6B4F695E7F1935D91")
    @DSModeled(DSC.SAFE)
    public void setOutsideTouchable(boolean touchable) {
        dsTaint.addTaint(touchable);
        // ---------- Original Method ----------
        //mOutsideTouchable = touchable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.987 -0400", hash_original_method = "5D90AAFBBA18C52B8D43E4274612DFE0", hash_generated_method = "81DCD469B83246BE007FF5E42939B080")
    @DSModeled(DSC.SAFE)
    public boolean isClippingEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mClippingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.988 -0400", hash_original_method = "C644B67739A8A92EE97D978CC897DC79", hash_generated_method = "941A802A957F8D2147BA86494963BB62")
    @DSModeled(DSC.SAFE)
    public void setClippingEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        // ---------- Original Method ----------
        //mClippingEnabled = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.988 -0400", hash_original_method = "86AECB53D9496C7054030FB1672ECE9B", hash_generated_method = "7B9897F4D2904112643C12A1DFCFB25C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setClipToScreenEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        setClippingEnabled(!enabled);
        // ---------- Original Method ----------
        //mClipToScreen = enabled;
        //setClippingEnabled(!enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.988 -0400", hash_original_method = "AB712E1EFFE4EAE7A80987CD7E1E8D4B", hash_generated_method = "5BD67358BC02083831A6B64B981A563A")
    @DSModeled(DSC.SAFE)
     void setAllowScrollingAnchorParent(boolean enabled) {
        dsTaint.addTaint(enabled);
        // ---------- Original Method ----------
        //mAllowScrollingAnchorParent = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.988 -0400", hash_original_method = "CD003A57AD290217AC32D20DAA9F9760", hash_generated_method = "4CBBDE3B9800DC7986014BF58C23E49E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSplitTouchEnabled() {
        {
            boolean varEEA1697260544E0A5861DD090A86C488_1818151017 = (mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mSplitTouchEnabled < 0 && mContext != null) {
            //return mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB;
        //}
        //return mSplitTouchEnabled == 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.988 -0400", hash_original_method = "8E279F2F2689369B00326EC855CADBF3", hash_generated_method = "3B6A79EF6B9F9B33A0C3B8534171DFAF")
    @DSModeled(DSC.SAFE)
    public void setSplitTouchEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        mSplitTouchEnabled = enabled ? 1 : 0;
        // ---------- Original Method ----------
        //mSplitTouchEnabled = enabled ? 1 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.988 -0400", hash_original_method = "10EB43954998F08298066292E6DC8079", hash_generated_method = "CC63D426CCBEAAAE9205650AD85820D4")
    @DSModeled(DSC.SAFE)
    public boolean isLayoutInScreenEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLayoutInScreen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.989 -0400", hash_original_method = "181FE02772B59DB435AF1D6C410875BB", hash_generated_method = "1191DD4D487BBD0FB31E4C8ABC1F81BF")
    @DSModeled(DSC.SAFE)
    public void setLayoutInScreenEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        // ---------- Original Method ----------
        //mLayoutInScreen = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.989 -0400", hash_original_method = "FEA07B591038B9982257E6B6F9EA89DD", hash_generated_method = "8B6BC5EED2281791AD141A4D2F59D50B")
    @DSModeled(DSC.SAFE)
    public void setLayoutInsetDecor(boolean enabled) {
        dsTaint.addTaint(enabled);
        // ---------- Original Method ----------
        //mLayoutInsetDecor = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.989 -0400", hash_original_method = "7DF3C488F6920E6663FDD36E5737A8E3", hash_generated_method = "E54EC64A98D34134B477CF85449F5D79")
    @DSModeled(DSC.SAFE)
    public void setWindowLayoutType(int layoutType) {
        dsTaint.addTaint(layoutType);
        // ---------- Original Method ----------
        //mWindowLayoutType = layoutType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.989 -0400", hash_original_method = "B0A202A53A476A9F6F2E7DEE1AC7BFD5", hash_generated_method = "C9A1EBB3CE9445D9C026410CE350BCD3")
    @DSModeled(DSC.SAFE)
    public int getWindowLayoutType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWindowLayoutType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.989 -0400", hash_original_method = "B8930E34962345C50EA9D19D5D77CFE8", hash_generated_method = "4D2261997BA71B1A5DE91889AA23331C")
    @DSModeled(DSC.SAFE)
    public void setTouchModal(boolean touchModal) {
        dsTaint.addTaint(touchModal);
        mNotTouchModal = !touchModal;
        // ---------- Original Method ----------
        //mNotTouchModal = !touchModal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.989 -0400", hash_original_method = "756D1E68507199C9976BFEB56A60134A", hash_generated_method = "550623870B22A9A2B7740DF42EAD85FE")
    @DSModeled(DSC.SAFE)
    public void setWindowLayoutMode(int widthSpec, int heightSpec) {
        dsTaint.addTaint(heightSpec);
        dsTaint.addTaint(widthSpec);
        // ---------- Original Method ----------
        //mWidthMode = widthSpec;
        //mHeightMode = heightSpec;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.990 -0400", hash_original_method = "0304EDCF78FF45B68A7EB91BFEAAA2CD", hash_generated_method = "3A252BA8FC341E1B5E481922385845B0")
    @DSModeled(DSC.SAFE)
    public int getHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.990 -0400", hash_original_method = "BA89F279BB207625BAE694FF1E8671B8", hash_generated_method = "C3997CC97C69A56FDDF4F88F718D4048")
    @DSModeled(DSC.SAFE)
    public void setHeight(int height) {
        dsTaint.addTaint(height);
        // ---------- Original Method ----------
        //mHeight = height;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.990 -0400", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "3885B1CF593DA65DFEFDA3B3659F368F")
    @DSModeled(DSC.SAFE)
    public int getWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.990 -0400", hash_original_method = "684C7FEA8A4B53DA843B69F25AEC8ECA", hash_generated_method = "333B87DBA0784ECCCA2E5B795A5FD13C")
    @DSModeled(DSC.SAFE)
    public void setWidth(int width) {
        dsTaint.addTaint(width);
        // ---------- Original Method ----------
        //mWidth = width;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.990 -0400", hash_original_method = "2222AA4AEDF5C752B222A7F4E8915559", hash_generated_method = "3A00FE10989B3204EB33117DB09451C8")
    @DSModeled(DSC.SAFE)
    public boolean isShowing() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsShowing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.990 -0400", hash_original_method = "7355F7E30A53327DA70C15AA0141C8AD", hash_generated_method = "8D5CC7E4385A4106ED6AADC08D9063E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showAtLocation(View parent, int gravity, int x, int y) {
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        dsTaint.addTaint(gravity);
        showAtLocation(parent.getWindowToken(), gravity, x, y);
        // ---------- Original Method ----------
        //showAtLocation(parent.getWindowToken(), gravity, x, y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.991 -0400", hash_original_method = "B99D3AF8D05FDFEAE8059FF95B29B82E", hash_generated_method = "D09B84CBAA43617E5F5B4912E3C60B8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showAtLocation(IBinder token, int gravity, int x, int y) {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        dsTaint.addTaint(gravity);
        {
            boolean var9BC9BAF6F3002BB79EBDDA5435C62A79_1729702607 = (isShowing() || mContentView == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.991 -0400", hash_original_method = "C9F3BB2940AB236715592F07C984C554", hash_generated_method = "AC6CC4C5480FD8482636B10BE9A64C05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showAsDropDown(View anchor) {
        dsTaint.addTaint(anchor.dsTaint);
        showAsDropDown(anchor, 0, 0);
        // ---------- Original Method ----------
        //showAsDropDown(anchor, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.991 -0400", hash_original_method = "624B6ED3EB88D2A91AFF60DB37AE2E29", hash_generated_method = "9C715EDDCDD345D7D7366926C8F4E19C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        dsTaint.addTaint(xoff);
        dsTaint.addTaint(yoff);
        dsTaint.addTaint(anchor.dsTaint);
        {
            boolean var9BC9BAF6F3002BB79EBDDA5435C62A79_220805841 = (isShowing() || mContentView == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.992 -0400", hash_original_method = "ACCF8C7A05331E8E4B71A7F0F84ED581", hash_generated_method = "F76666A717A35A019A37C92B467EB7B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.992 -0400", hash_original_method = "3CCA39FA6959E2A6CCCA2648E4E5EA51", hash_generated_method = "9796489715376E79ECE8493BE51AAF20")
    @DSModeled(DSC.SAFE)
    public boolean isAboveAnchor() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAboveAnchor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.992 -0400", hash_original_method = "DA370B626B41FE86866E281D10A5B6B7", hash_generated_method = "3A813AD53E0EF8F800E9A5103FBA2729")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void preparePopup(WindowManager.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("You must specify a valid content view by "
                    + "calling setContentView() before attempting to show the popup.");
        } //End block
        {
            ViewGroup.LayoutParams layoutParams;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.992 -0400", hash_original_method = "CC3762287DEDA3D715BCCB052800207D", hash_generated_method = "CA06179485061D963E8097C0B3E941B6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.993 -0400", hash_original_method = "D97E1B6317AF67D9DC41A6FB19D27D69", hash_generated_method = "B38CC39BA202F94357D8E9E28E9EEE08")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.993 -0400", hash_original_method = "731A130870E20EEF0406E3AA79CC1D53", hash_generated_method = "D6769A4152F3EB506DE3111DB6137F64")
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
            boolean varC512B087080D8F65FDEBB4C012341A4B_1863295943 = (isSplitTouchEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.994 -0400", hash_original_method = "2B29575EF3002A68968C6947831DCCDB", hash_generated_method = "979A41F68930260B7897ED04A23957E9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.995 -0400", hash_original_method = "5A11C37B27567E510AD1092CF1C461D0", hash_generated_method = "412C058893102DD09C1C92297AB60BA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean findDropDownPosition(View anchor, WindowManager.LayoutParams p,
            int xoff, int yoff) {
        dsTaint.addTaint(xoff);
        dsTaint.addTaint(p.dsTaint);
        dsTaint.addTaint(yoff);
        dsTaint.addTaint(anchor.dsTaint);
        int anchorHeight;
        anchorHeight = anchor.getHeight();
        anchor.getLocationInWindow(mDrawingLocation);
        p.x = mDrawingLocation[0] + xoff;
        p.y = mDrawingLocation[1] + anchorHeight + yoff;
        boolean onTop;
        onTop = false;
        p.gravity = Gravity.LEFT | Gravity.TOP;
        anchor.getLocationOnScreen(mScreenLocation);
        Rect displayFrame;
        displayFrame = new Rect();
        anchor.getWindowVisibleDisplayFrame(displayFrame);
        int screenY;
        screenY = mScreenLocation[1] + anchorHeight + yoff;
        View root;
        root = anchor.getRootView();
        {
            boolean var74CA561700F828A0D92807B977326861_621417021 = (screenY + mPopupHeight > displayFrame.bottom ||
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
            int displayFrameWidth;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.995 -0400", hash_original_method = "023150F59911D5483F51543A59288631", hash_generated_method = "971ABFE26E18515961ED688F5FC063A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaxAvailableHeight(View anchor) {
        dsTaint.addTaint(anchor.dsTaint);
        int varA711B8768F5CD08E9377B11ECAC1715F_315207275 = (getMaxAvailableHeight(anchor, 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getMaxAvailableHeight(anchor, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.995 -0400", hash_original_method = "782C0234D711C16ED6DF402CCEC14809", hash_generated_method = "A3E0B777CF7AA9C98C0F2C0767EECFA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaxAvailableHeight(View anchor, int yOffset) {
        dsTaint.addTaint(yOffset);
        dsTaint.addTaint(anchor.dsTaint);
        int var469BE61637FC70E4C9728196B89D54FF_1529470731 = (getMaxAvailableHeight(anchor, yOffset, false));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getMaxAvailableHeight(anchor, yOffset, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.995 -0400", hash_original_method = "6127242297D2005B4B3434B0EF072B4C", hash_generated_method = "0C00DB95DDA0640D1020F7255EF70CD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaxAvailableHeight(View anchor, int yOffset, boolean ignoreBottomDecorations) {
        dsTaint.addTaint(ignoreBottomDecorations);
        dsTaint.addTaint(yOffset);
        dsTaint.addTaint(anchor.dsTaint);
        Rect displayFrame;
        displayFrame = new Rect();
        anchor.getWindowVisibleDisplayFrame(displayFrame);
        int[] anchorPos;
        anchorPos = mDrawingLocation;
        anchor.getLocationOnScreen(anchorPos);
        int bottomEdge;
        bottomEdge = displayFrame.bottom;
        {
            Resources res;
            res = anchor.getContext().getResources();
            bottomEdge = res.getDisplayMetrics().heightPixels;
        } //End block
        int distanceToBottom;
        distanceToBottom = bottomEdge - (anchorPos[1] + anchor.getHeight()) - yOffset;
        int distanceToTop;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.996 -0400", hash_original_method = "206A53D80E1660978DCF21A355028E66", hash_generated_method = "016DE289FC183CD62B9C68152C2E85DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dismiss() {
        {
            boolean var2C554DDD957DC9A014B8B4DE4C803696_1378976437 = (isShowing() && mPopupView != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.996 -0400", hash_original_method = "93E9EBCE36575249CB74D4FBEF26A1CF", hash_generated_method = "643E4F0BCFB41F37F7652CA2F64A2246")
    @DSModeled(DSC.SAFE)
    public void setOnDismissListener(OnDismissListener onDismissListener) {
        dsTaint.addTaint(onDismissListener.dsTaint);
        // ---------- Original Method ----------
        //mOnDismissListener = onDismissListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.996 -0400", hash_original_method = "488D5DDCA6B0F8C983ED8CA34502865A", hash_generated_method = "600CF8F226E51EF9C84C72B1C58B89D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void update() {
        {
            boolean var792B694D840F3959F85BC36B57C55AEF_847951397 = (!isShowing() || mContentView == null);
        } //End collapsed parenthetic
        WindowManager.LayoutParams p;
        p = (WindowManager.LayoutParams)
                mPopupView.getLayoutParams();
        boolean update;
        update = false;
        int newAnim;
        newAnim = computeAnimationResource();
        {
            p.windowAnimations = newAnim;
            update = true;
        } //End block
        int newFlags;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.996 -0400", hash_original_method = "99E415F6DCFBC1202511EEF5D071A55C", hash_generated_method = "E42D4561058D371AB67907EF673BCF2F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.996 -0400", hash_original_method = "848B641343A16858C863B802CDF64CDF", hash_generated_method = "6479C5808B1C141525FABDB6B0543316")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void update(int x, int y, int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        update(x, y, width, height, false);
        // ---------- Original Method ----------
        //update(x, y, width, height, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.997 -0400", hash_original_method = "7F49F99468193710A8807FDE38269850", hash_generated_method = "EDF7DA5427F9DE8E0428A5D6A9132B43")
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
            boolean var792B694D840F3959F85BC36B57C55AEF_1498307684 = (!isShowing() || mContentView == null);
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
        int newAnim;
        newAnim = computeAnimationResource();
        {
            p.windowAnimations = newAnim;
            update = true;
        } //End block
        int newFlags;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.997 -0400", hash_original_method = "2E7624B1CB6DF9766B6E25C708FAA465", hash_generated_method = "15B9CFC31F479DDE1C8FCC35E5CE3D24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void update(View anchor, int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(anchor.dsTaint);
        update(anchor, false, 0, 0, true, width, height);
        // ---------- Original Method ----------
        //update(anchor, false, 0, 0, true, width, height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.997 -0400", hash_original_method = "B8D2EE4CAAF22B5FC8CA5A06E5BF0669", hash_generated_method = "C3232F74E737BB846225473DDA2E55C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.998 -0400", hash_original_method = "F5290879A773899EB945D797134BA900", hash_generated_method = "DF1D1DF714C7445D135F2EF33382236E")
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
            boolean var792B694D840F3959F85BC36B57C55AEF_148607433 = (!isShowing() || mContentView == null);
        } //End collapsed parenthetic
        WeakReference<View> oldAnchor;
        oldAnchor = mAnchor;
        boolean needsUpdate;
        needsUpdate = updateLocation && (mAnchorXoff != xoff || mAnchorYoff != yoff);
        {
            boolean varBA4588A4E37197031A7BA0375487BCBA_1929743214 = (oldAnchor == null || oldAnchor.get() != anchor || (needsUpdate && !mIsDropdown));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.998 -0400", hash_original_method = "032144363E44618DF1C4EE95BC82AD16", hash_generated_method = "3941AAE17C8AC0CB83D0C52071E97C56")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.999 -0400", hash_original_method = "F426C621D66F93AA8E883C7FBA8C8657", hash_generated_method = "6B264676E7764D5612A97FE039702FAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.999 -0400", hash_original_method = "2CEF1E9B6EE64B78C8FCC7C360A10341", hash_generated_method = "C1E8995C9B0B8DAA59A7D7ABE8ADA27A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PopupViewContainer(Context context) {
            super(context);
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.000 -0400", hash_original_method = "60250F32C750F199B013D0293AAF47D3", hash_generated_method = "D3B94D085D9AAF492F2FDEDB280E365B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected int[] onCreateDrawableState(int extraSpace) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(extraSpace);
            {
                int[] drawableState;
                drawableState = super.onCreateDrawableState(extraSpace + 1);
                View.mergeDrawableStates(drawableState, ABOVE_ANCHOR_STATE_SET);
            } //End block
            {
                int[] var74CE87D3619881427F9757CCE4F4BF6A_209211784 = (super.onCreateDrawableState(extraSpace));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.000 -0400", hash_original_method = "A2DD55E78C6B8B19849AEC8708A214E9", hash_generated_method = "E9D457B7099087F4D752B085F0CAE158")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            dsTaint.addTaint(event.dsTaint);
            {
                boolean varC71B767C5D14CF758CFC7EA9349BEE50_317191646 = (event.getKeyCode() == KeyEvent.KEYCODE_BACK);
                {
                    {
                        boolean var0530024EDAEF285FA074A5D0CCF9FBC3_1757979242 = (getKeyDispatcherState() == null);
                        {
                            boolean var9B794F99509F39111FB8A6A64D542633_1113532583 = (super.dispatchKeyEvent(event));
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varF456D875C94EFA50F4F83E456081D7DC_980958647 = (event.getAction() == KeyEvent.ACTION_DOWN
                        && event.getRepeatCount() == 0);
                        {
                            KeyEvent.DispatcherState state;
                            state = getKeyDispatcherState();
                            {
                                state.startTracking(event, this);
                            } //End block
                        } //End block
                        {
                            boolean var6A33DE310C5D908541C47FFDD30D2802_521536213 = (event.getAction() == KeyEvent.ACTION_UP);
                            {
                                KeyEvent.DispatcherState state;
                                state = getKeyDispatcherState();
                                {
                                    boolean var220DFBBB57806723689C9C46DFE1C558_492747236 = (state != null && state.isTracking(event) && !event.isCanceled());
                                    {
                                        dismiss();
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                    boolean var97BD0C91372FF8CDE07B475E38FE656A_1590584591 = (super.dispatchKeyEvent(event));
                } //End block
                {
                    boolean var97BD0C91372FF8CDE07B475E38FE656A_1616636688 = (super.dispatchKeyEvent(event));
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.001 -0400", hash_original_method = "C7733BB60CAB256C1ABFC72965DD2E24", hash_generated_method = "97D9C57E6A97EA385A4602EE74D89791")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            dsTaint.addTaint(ev.dsTaint);
            {
                boolean var93C4222DC4A59A9B32842AA419F1377C_1215706204 = (mTouchInterceptor != null && mTouchInterceptor.onTouch(this, ev));
            } //End collapsed parenthetic
            boolean varD9CFC974DB9B4187D396B15CE784ECB1_2091380976 = (super.dispatchTouchEvent(ev));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (mTouchInterceptor != null && mTouchInterceptor.onTouch(this, ev)) {
                //return true;
            //}
            //return super.dispatchTouchEvent(ev);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.001 -0400", hash_original_method = "2EFE76B74388A6782646D0ACFFECA21F", hash_generated_method = "3DBCB017307CBDBCB1440F20A82654D8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(event.dsTaint);
            int x;
            x = (int) event.getX();
            int y;
            y = (int) event.getY();
            {
                boolean var0FCE2C8AA5CE2F3DB17871F164D2ABD3_988971198 = ((event.getAction() == MotionEvent.ACTION_DOWN)
                    && ((x < 0) || (x >= getWidth()) || (y < 0) || (y >= getHeight())));
                {
                    dismiss();
                } //End block
                {
                    boolean var267E05D3737D25CB7AC9FBB08A12D390_404222089 = (event.getAction() == MotionEvent.ACTION_OUTSIDE);
                    {
                        dismiss();
                    } //End block
                    {
                        boolean varEFC6B821CDB4DB5344876A10D775A068_427204600 = (super.onTouchEvent(event));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.001 -0400", hash_original_method = "EB4F4EE30B31AEB9BDFF308A3D2D5CAC", hash_generated_method = "E864F6754E1C78C6E3715484BB9D1676")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        private static final String TAG = "PopupWindow.PopupViewContainer";
    }


    
    public interface OnDismissListener {
        
        public void onDismiss();
    }
    
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    private static final int[] ABOVE_ANCHOR_STATE_SET = new int[] {
        com.android.internal.R.attr.state_above_anchor
    };
}

