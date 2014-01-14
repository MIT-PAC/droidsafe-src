package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

public class PopupWindow {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.844 -0500", hash_original_field = "701591F0360276A28E327627FEB76715", hash_generated_field = "EC879018D8E62A80ED7D5976B9A1B7A2")

    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.848 -0500", hash_original_field = "CFE7F778928351FCBB8904DEB0AF6515", hash_generated_field = "620E7E20B08AC8DE8E08A876F15941F3")

    public static final int INPUT_METHOD_NEEDED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.850 -0500", hash_original_field = "A81153CED44F08901CFF54DBA0551876", hash_generated_field = "34E45A8A1172450CBFBC57CBC51A7F74")

    public static final int INPUT_METHOD_NOT_NEEDED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.933 -0500", hash_original_field = "9FE260B460E2BB7B31A6488C7DE8A4D7", hash_generated_field = "55669BF630688FDF9A58292DE30C4824")
    
    private static final int[] ABOVE_ANCHOR_STATE_SET = new int[] {
        com.android.internal.R.attr.state_above_anchor
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.852 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")
    
    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.854 -0500", hash_original_field = "83A062836C11DD52DC32F4325712F233", hash_generated_field = "3C750A4AE06B71AF3A05B7797C7182A4")

    private WindowManager mWindowManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.856 -0500", hash_original_field = "731D4FF487F586CBA45F6AF9BC0AC916", hash_generated_field = "182408C3124602AF2E2446547BFC5990")
    
    private boolean mIsShowing;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.858 -0500", hash_original_field = "85CF3D7C1422B3521D1680A0F9D316B2", hash_generated_field = "9700652AF3F2C5A2E0A0AFE403A12B64")

    private boolean mIsDropdown;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.860 -0500", hash_original_field = "A280952DD6B837BA6E44884878875510", hash_generated_field = "9EE0242EB014EEED0CD7F44EEE7EA48F")

    private View mContentView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.862 -0500", hash_original_field = "D74AA1A40F9547715935515E6E4885E3", hash_generated_field = "677D1CB7D78258D08289E18B4B225566")

    private View mPopupView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.864 -0500", hash_original_field = "FD2E2ACB1AAEDC120DD0791EC0DD9F41", hash_generated_field = "26ADB48C5A4311C541C946E4573DD3BE")

    private boolean mFocusable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.867 -0500", hash_original_field = "E2903A2EDEC3C92DD380155CB9AF455B", hash_generated_field = "B74EBB15400870AA6ADEE3D1E89366AA")

    private int mInputMethodMode = INPUT_METHOD_FROM_FOCUSABLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.869 -0500", hash_original_field = "1EDFB55A130D41A1D771B96736A8D07A", hash_generated_field = "504E8B046E68A38DD3E86D295ED153C0")

    private int mSoftInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.871 -0500", hash_original_field = "2629CBBE06CF95BC3C11A1BD3C424674", hash_generated_field = "81D20D477E5343219A40993A2D5A9281")

    private boolean mTouchable = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.872 -0500", hash_original_field = "2361C1B3511878EBDE894BC1815D0BEC", hash_generated_field = "E535EDD135AEF4C6D12D2FCC5626D0B4")

    private boolean mOutsideTouchable = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.874 -0500", hash_original_field = "E90C4C0E3E70A6E8DBEDB6E57DB1AD4B", hash_generated_field = "1F43204AC614FA8E190D827A0B960C07")

    private boolean mClippingEnabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.876 -0500", hash_original_field = "41A6FDA841280881CFA421D852CB74CB", hash_generated_field = "6B0DF01241CF4AF0DF57F3BB0179F510")

    private int mSplitTouchEnabled = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.878 -0500", hash_original_field = "EA5E62FF90986EE4E333AEFC43D2B9A1", hash_generated_field = "22CD68096C89BB0267ECAB9CEED72BD4")

    private boolean mLayoutInScreen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.881 -0500", hash_original_field = "8132183C7C1F243608AC88B0422867BA", hash_generated_field = "F7BA441F0E6563EAA35858C9FBEC3C9D")

    private boolean mClipToScreen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.884 -0500", hash_original_field = "573FF805B49B624945C9ED12990B8069", hash_generated_field = "E18DD07EB2577F208D13A033471EF4B0")

    private boolean mAllowScrollingAnchorParent = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.886 -0500", hash_original_field = "13B177D26AFD0E4245E9F612027CC30C", hash_generated_field = "4F2A0AC1A5A72DEAB8A91CCC311892CE")

    private boolean mLayoutInsetDecor = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.888 -0500", hash_original_field = "5C2201347BB1AC22985DB692C9D234D7", hash_generated_field = "AA45A743419186F82617924E3E71CD81")

    private boolean mNotTouchModal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.890 -0500", hash_original_field = "DAD3E254CE9B6EB14C5F5887DE6B1D9F", hash_generated_field = "72A5C0221AA7C77012D45B0D5814CA05")

    private OnTouchListener mTouchInterceptor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.892 -0500", hash_original_field = "49C607A261C36ED620A93DA50B91053D", hash_generated_field = "E1584971BBD05AECB0B7B9F417D8A13C")
    
    private int mWidthMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.894 -0500", hash_original_field = "AF6410B200BC05DCA2CF0BE65165448A", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

    private int mWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.896 -0500", hash_original_field = "AA7646C98EBC5ADDDD6C189C2578D779", hash_generated_field = "8A8A535915DEF11E8818FDD746192E2F")

    private int mLastWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.898 -0500", hash_original_field = "C949F7A2DC998240C9C2333A86A829AA", hash_generated_field = "942FD12E1BB37FE50F8815646F385BF0")

    private int mHeightMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.900 -0500", hash_original_field = "7DDAE255893B528E7BEBEC203BC2D9F3", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

    private int mHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.902 -0500", hash_original_field = "09178556439E1BD84C5333093B7DEC65", hash_generated_field = "7D971819672E66B14BFF50845F865AA1")

    private int mLastHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.904 -0500", hash_original_field = "D23E8AE5915E7E5B876DFDF4DB92A7B0", hash_generated_field = "3FD6DB919B847EDFE0B5956AF8A9BD61")

    private int mPopupWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.906 -0500", hash_original_field = "37FC35FE9758B11A847C155825325C05", hash_generated_field = "81FC9D55F4BDFA3779C66DE9184556C7")

    private int mPopupHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.908 -0500", hash_original_field = "9C1449E8E0E043F6FA25FE8E63FF414E", hash_generated_field = "904FF38CA36EA4CCC3C2CCEC4DCDD3BD")

    private int[] mDrawingLocation = new int[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.911 -0500", hash_original_field = "0BC4AEC5360AE77A35764FA8927D9DD6", hash_generated_field = "E837BED31FD3509BD57D12D959724198")

    private int[] mScreenLocation = new int[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.912 -0500", hash_original_field = "1732EB32F2D77CCA26590AEEA670A175", hash_generated_field = "AFFA54D19F07A10EE8847CF76FC95323")

    private Rect mTempRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.915 -0500", hash_original_field = "1414D97CE5ED674A74A05A07F83AE3BF", hash_generated_field = "0925F2C91F8CBA797C183309FA7634C5")
    
    private Drawable mBackground;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.917 -0500", hash_original_field = "4269741F761E423EA211C462AD050A9B", hash_generated_field = "E17C64A85543ECD9874F1E70F5E7D722")

    private Drawable mAboveAnchorBackgroundDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.919 -0500", hash_original_field = "E5EAE4CAC3B6B5E75EA70E6F5FE86D70", hash_generated_field = "FF8C2A1514D8DB3BCCA18DE7013BFFDC")

    private Drawable mBelowAnchorBackgroundDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.921 -0500", hash_original_field = "F4B2ADC1C848EABB9ED10150CF9EAF1D", hash_generated_field = "0D6DFCDD3C93CA68BA06073646439B09")

    private boolean mAboveAnchor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.923 -0500", hash_original_field = "4AF3A3DBE227F284DF0C57CC290F4807", hash_generated_field = "9BD03BD39A060D11ED1286EBFF9AC4DB")

    private int mWindowLayoutType = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.926 -0500", hash_original_field = "C468C3A0691741B1E7D18572879CE879", hash_generated_field = "91E70DA930AA00EAD499671BBD6F37EB")
    
    private OnDismissListener mOnDismissListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.928 -0500", hash_original_field = "CC3ADF22EDFB5591EF2B18B9A6E29780", hash_generated_field = "2356D264A59ECD4DA5DAEA961FD9C071")

    private boolean mIgnoreCheekPress = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.931 -0500", hash_original_field = "4FD3C82C55184B42F7F8171EA4DB9804", hash_generated_field = "2D667A20717B87BB0939831DD6C37380")

    private int mAnimationStyle = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.935 -0500", hash_original_field = "05E211AF06F4F4DDD0130728FFB6A304", hash_generated_field = "841D2F2B9FEBE43FD9F75F29253325CB")

    private WeakReference<View> mAnchor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.470 -0400", hash_original_field = "8AA9181EAEA04588ABD6B3AB55C1B57C", hash_generated_field = "2B651957906EF3EE2A8FF3D73794B10C")

    private OnScrollChangedListener mOnScrollChangedListener = new OnScrollChangedListener() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.470 -0400", hash_original_method = "8F0CC5ACEB252AEA9146DA3982ED4810", hash_generated_method = "7EF06A3B1EE135961B1267F768F6EA1D")
        public void onScrollChanged() {
            
            View anchor;
            anchor = mAnchor.get();
            anchor = null;
            {
                WindowManager.LayoutParams p = (WindowManager.LayoutParams)
                            mPopupView.getLayoutParams();
                updateAboveAnchor(findDropDownPosition(anchor, p, mAnchorXoff, mAnchorYoff));
                update(p.x, p.y, -1, -1, true);
            }
                
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.948 -0400", hash_original_field = "F170BC3F21E6816CF0857FF17CC3E8A8", hash_generated_field = "3E89D2F69E75793719092294948AC6C2")

    private int mAnchorXoff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.948 -0400", hash_original_field = "A2E2D94557B5FCE0E46C1252F1382457", hash_generated_field = "C642333984FB0C821A5D09038A79D9E2")

    private int mAnchorYoff;

    /**
     * <p>Create a new empty, non focusable popup window of dimension (0,0).</p>
     *
     * <p>The popup does provide a background.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.945 -0500", hash_original_method = "A7D29AF9F459F2E9972F382B06EBA7BC", hash_generated_method = "BC7439675D95C559B6F05DEB3FB3F6E5")
    
public PopupWindow(Context context) {
        this(context, null);
    }

    /**
     * <p>Create a new empty, non focusable popup window of dimension (0,0).</p>
     *
     * <p>The popup does provide a background.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.947 -0500", hash_original_method = "366007D96D9B418EA2EA6640B7FB7C46", hash_generated_method = "ADF8BD67CC99DCCEC266EC66A9A07380")
    
public PopupWindow(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.popupWindowStyle);
    }

    /**
     * <p>Create a new empty, non focusable popup window of dimension (0,0).</p>
     *
     * <p>The popup does provide a background.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.949 -0500", hash_original_method = "FAD82A2A4F32A008B236FC8E4F83669F", hash_generated_method = "B1C51459EF0A71358D06997A7FBC0604")
    
public PopupWindow(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, 0);
    }
    
    /**
     * <p>Create a new, empty, non focusable popup window of dimension (0,0).</p>
     * 
     * <p>The popup does not provide a background.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.953 -0500", hash_original_method = "079F601C7A8694616AB9480B0999FF46", hash_generated_method = "39A7B7E503EB311EC20421F4E5732CDD")
    
public PopupWindow(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        mContext = context;
        mWindowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);

        TypedArray a =
            context.obtainStyledAttributes(
                attrs, com.android.internal.R.styleable.PopupWindow, defStyleAttr, defStyleRes);

        mBackground = a.getDrawable(R.styleable.PopupWindow_popupBackground);

        final int animStyle = a.getResourceId(R.styleable.PopupWindow_popupAnimationStyle, -1);
        mAnimationStyle = animStyle == com.android.internal.R.style.Animation_PopupWindow ? -1 :
                animStyle;

        // If this is a StateListDrawable, try to find and store the drawable to be
        // used when the drop-down is placed above its anchor view, and the one to be
        // used when the drop-down is placed below its anchor view. We extract
        // the drawables ourselves to work around a problem with using refreshDrawableState
        // that it will take into account the padding of all drawables specified in a
        // StateListDrawable, thus adding superfluous padding to drop-down views.
        //
        // We assume a StateListDrawable will have a drawable for ABOVE_ANCHOR_STATE_SET and
        // at least one other drawable, intended for the 'below-anchor state'.
        if (mBackground instanceof StateListDrawable) {
            StateListDrawable background = (StateListDrawable) mBackground;

            // Find the above-anchor view - this one's easy, it should be labeled as such.
            int aboveAnchorStateIndex = background.getStateDrawableIndex(ABOVE_ANCHOR_STATE_SET);
            
            // Now, for the below-anchor view, look for any other drawable specified in the
            // StateListDrawable which is not for the above-anchor state and use that.
            int count = background.getStateCount();
            int belowAnchorStateIndex = -1;
            for (int i = 0; i < count; i++) {
                if (i != aboveAnchorStateIndex) {
                    belowAnchorStateIndex = i;
                    break;
                }
            }
            
            // Store the drawables we found, if we found them. Otherwise, set them both
            // to null so that we'll just use refreshDrawableState.
            if (aboveAnchorStateIndex != -1 && belowAnchorStateIndex != -1) {
                mAboveAnchorBackgroundDrawable = background.getStateDrawable(aboveAnchorStateIndex);
                mBelowAnchorBackgroundDrawable = background.getStateDrawable(belowAnchorStateIndex);
            } else {
                mBelowAnchorBackgroundDrawable = null;
                mAboveAnchorBackgroundDrawable = null;
            }
        }
        
        a.recycle();
    }

    /**
     * <p>Create a new empty, non focusable popup window of dimension (0,0).</p>
     *
     * <p>The popup does not provide any background. This should be handled
     * by the content view.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.957 -0500", hash_original_method = "E34384426EB8697F688915D9E72B588C", hash_generated_method = "A33D4E1EFE4B410E56E7CFC190D37881")
    
public PopupWindow() {
        this(null, 0, 0);
    }

    /**
     * <p>Create a new non focusable popup window which can display the
     * <tt>contentView</tt>. The dimension of the window are (0,0).</p>
     *
     * <p>The popup does not provide any background. This should be handled
     * by the content view.</p>
     *
     * @param contentView the popup's content
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.959 -0500", hash_original_method = "57135C41538C9CD08914B3D745201B31", hash_generated_method = "E0F06A0571E810AAF16232CFEE2A9725")
    
public PopupWindow(View contentView) {
        this(contentView, 0, 0);
    }

    /**
     * <p>Create a new empty, non focusable popup window. The dimension of the
     * window must be passed to this constructor.</p>
     *
     * <p>The popup does not provide any background. This should be handled
     * by the content view.</p>
     *
     * @param width the popup's width
     * @param height the popup's height
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.961 -0500", hash_original_method = "52D8423742F4089F7506898A8921688C", hash_generated_method = "7B450D1149C936FFDF9B287C0DDB0171")
    
public PopupWindow(int width, int height) {
        this(null, width, height);
    }

    /**
     * <p>Create a new non focusable popup window which can display the
     * <tt>contentView</tt>. The dimension of the window must be passed to
     * this constructor.</p>
     *
     * <p>The popup does not provide any background. This should be handled
     * by the content view.</p>
     *
     * @param contentView the popup's content
     * @param width the popup's width
     * @param height the popup's height
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.964 -0500", hash_original_method = "824FA1289D7F0041B91552EC537ECD03", hash_generated_method = "D730601345BF8D11B375DA06A7185D0F")
    
public PopupWindow(View contentView, int width, int height) {
        this(contentView, width, height, false);
    }

    /**
     * <p>Create a new popup window which can display the <tt>contentView</tt>.
     * The dimension of the window must be passed to this constructor.</p>
     *
     * <p>The popup does not provide any background. This should be handled
     * by the content view.</p>
     *
     * @param contentView the popup's content
     * @param width the popup's width
     * @param height the popup's height
     * @param focusable true if the popup can be focused, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.966 -0500", hash_original_method = "45A20F34B738086A724C95615CA38820", hash_generated_method = "2E97AA486D053350CC8C99BC5AE19E2F")
    
public PopupWindow(View contentView, int width, int height, boolean focusable) {
        if (contentView != null) {
            mContext = contentView.getContext();
            mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        }
        setContentView(contentView);
        setWidth(width);
        setHeight(height);
        setFocusable(focusable);
    }

    /**
     * <p>Return the drawable used as the popup window's background.</p>
     *
     * @return the background drawable or null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.969 -0500", hash_original_method = "63340AE07D2726BC056EFE5BE3E2FF29", hash_generated_method = "9FB8C8C54E4BA0866CDF1D4CECF45471")
    
public Drawable getBackground() {
        return mBackground;
    }

    /**
     * <p>Change the background drawable for this popup window. The background
     * can be set to null.</p>
     *
     * @param background the popup's background
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.970 -0500", hash_original_method = "96D2484B6380046D33AB8470E20080B0", hash_generated_method = "A0DFB48E4CB1CF8D919A91C6F4B5587D")
    
public void setBackgroundDrawable(Drawable background) {
        mBackground = background;
    }

    /**
     * <p>Return the animation style to use the popup appears and disappears</p>
     *
     * @return the animation style to use the popup appears and disappears
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.973 -0500", hash_original_method = "41CA7DA63F7D92402D2B673FD03355D6", hash_generated_method = "CB1996CA776F9ADD4773CB78ECAEDAB9")
    
public int getAnimationStyle() {
        return mAnimationStyle;
    }
    
    /**
     * Set the flag on popup to ignore cheek press eventt; by default this flag
     * is set to false
     * which means the pop wont ignore cheek press dispatch events.
     * 
     * <p>If the popup is showing, calling this method will take effect only
     * the next time the popup is shown or through a manual call to one of
     * the {@link #update()} methods.</p>
     * 
     * @see #update()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.975 -0500", hash_original_method = "A2D9F7F5158A57BAC36D16E33D2F221F", hash_generated_method = "54059CAD594D2F51634F0F1C43EDD405")
    
public void setIgnoreCheekPress() {
        mIgnoreCheekPress = true;
    }

    /**
     * <p>Change the animation style resource for this popup.</p>
     *
     * <p>If the popup is showing, calling this method will take effect only
     * the next time the popup is shown or through a manual call to one of
     * the {@link #update()} methods.</p>
     *
     * @param animationStyle animation style to use when the popup appears
     *      and disappears.  Set to -1 for the default animation, 0 for no
     *      animation, or a resource identifier for an explicit animation.
     *      
     * @see #update()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.977 -0500", hash_original_method = "46489C40917944BA93E8F6D8658EE802", hash_generated_method = "F33B41417B853BC111FC277E3CFAF9C9")
    
public void setAnimationStyle(int animationStyle) {
        mAnimationStyle = animationStyle;
    }
    
    /**
     * <p>Return the view used as the content of the popup window.</p>
     *
     * @return a {@link android.view.View} representing the popup's content
     *
     * @see #setContentView(android.view.View)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.980 -0500", hash_original_method = "1FBDC8A7B1B2CCF1CAFCE9F94E1B072D", hash_generated_method = "0FD10DCF7ED5F1F6B15F07AF1CED9A3A")
    
public View getContentView() {
        return mContentView;
    }

    /**
     * <p>Change the popup's content. The content is represented by an instance
     * of {@link android.view.View}.</p>
     *
     * <p>This method has no effect if called when the popup is showing.</p>
     *
     * @param contentView the new content for the popup
     *
     * @see #getContentView()
     * @see #isShowing()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.982 -0500", hash_original_method = "647C3E968C5C98ECF0A359511A938D87", hash_generated_method = "58745F4F8A05350F1F371C5ADBBFF03C")
    
public void setContentView(View contentView) {
        if (isShowing()) {
            return;
        }

        mContentView = contentView;

        if (mContext == null && mContentView != null) {
            mContext = mContentView.getContext();
        }

        if (mWindowManager == null && mContentView != null) {
            mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        }
    }

    /**
     * Set a callback for all touch events being dispatched to the popup
     * window.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.984 -0500", hash_original_method = "DE25D00870282EA3EAE9EBB02519A2CA", hash_generated_method = "AAA0C8A346D367B28D45AC9671953120")
    
public void setTouchInterceptor(OnTouchListener l) {
        mTouchInterceptor = l;
    }
    
    /**
     * <p>Indicate whether the popup window can grab the focus.</p>
     *
     * @return true if the popup is focusable, false otherwise
     *
     * @see #setFocusable(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.986 -0500", hash_original_method = "40BB85E3EB9B026A95FA1376FB5C6D2D", hash_generated_method = "FE61322C4A4AC0DC993A0F8E82914AD4")
    
public boolean isFocusable() {
        return mFocusable;
    }

    /**
     * <p>Changes the focusability of the popup window. When focusable, the
     * window will grab the focus from the current focused widget if the popup
     * contains a focusable {@link android.view.View}.  By default a popup
     * window is not focusable.</p>
     *
     * <p>If the popup is showing, calling this method will take effect only
     * the next time the popup is shown or through a manual call to one of
     * the {@link #update()} methods.</p>
     *
     * @param focusable true if the popup should grab focus, false otherwise.
     *
     * @see #isFocusable()
     * @see #isShowing() 
     * @see #update()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.988 -0500", hash_original_method = "ABAB7A7DE4A915B0505D233953D72C47", hash_generated_method = "83E10BFF45FBA3B9C420966C45377BB9")
    
public void setFocusable(boolean focusable) {
        mFocusable = focusable;
    }

    /**
     * Return the current value in {@link #setInputMethodMode(int)}.
     * 
     * @see #setInputMethodMode(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.991 -0500", hash_original_method = "01F2BFCF39394BA4008813FFB1127C10", hash_generated_method = "EFBEC74DA9D23332CBF484E30669D202")
    
public int getInputMethodMode() {
        return mInputMethodMode;
        
    }
    
    /**
     * Control how the popup operates with an input method: one of
     * {@link #INPUT_METHOD_FROM_FOCUSABLE}, {@link #INPUT_METHOD_NEEDED},
     * or {@link #INPUT_METHOD_NOT_NEEDED}.
     * 
     * <p>If the popup is showing, calling this method will take effect only
     * the next time the popup is shown or through a manual call to one of
     * the {@link #update()} methods.</p>
     * 
     * @see #getInputMethodMode()
     * @see #update()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.993 -0500", hash_original_method = "960CEBA1FA646F0DDCC5CA21C9FFA47A", hash_generated_method = "C1419FF2783E149D1243C2DB4AD458D9")
    
public void setInputMethodMode(int mode) {
        mInputMethodMode = mode;
    }

    /**
     * Sets the operating mode for the soft input area.
     *
     * @param mode The desired mode, see
     *        {@link android.view.WindowManager.LayoutParams#softInputMode}
     *        for the full list
     *
     * @see android.view.WindowManager.LayoutParams#softInputMode
     * @see #getSoftInputMode()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.995 -0500", hash_original_method = "4B11C5E74D17332CC7C67B3F22EF8E33", hash_generated_method = "4C88C8FADB5F13F1F4C154A97EE1BAAB")
    
public void setSoftInputMode(int mode) {
        mSoftInputMode = mode;
    }

    /**
     * Returns the current value in {@link #setSoftInputMode(int)}.
     *
     * @see #setSoftInputMode(int)
     * @see android.view.WindowManager.LayoutParams#softInputMode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.997 -0500", hash_original_method = "76888AB414E08DF2E7D12678F406D7A5", hash_generated_method = "988402AC1498A99620921C5855E6C891")
    
public int getSoftInputMode() {
        return mSoftInputMode;
    }
    
    /**
     * <p>Indicates whether the popup window receives touch events.</p>
     * 
     * @return true if the popup is touchable, false otherwise
     * 
     * @see #setTouchable(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:07.999 -0500", hash_original_method = "AE839D196CDFD95E127ACD4470F67375", hash_generated_method = "C5CB780AC95D6CC57B3C7956FB3A6237")
    
public boolean isTouchable() {
        return mTouchable;
    }

    /**
     * <p>Changes the touchability of the popup window. When touchable, the
     * window will receive touch events, otherwise touch events will go to the
     * window below it. By default the window is touchable.</p>
     *
     * <p>If the popup is showing, calling this method will take effect only
     * the next time the popup is shown or through a manual call to one of
     * the {@link #update()} methods.</p>
     *
     * @param touchable true if the popup should receive touch events, false otherwise
     *
     * @see #isTouchable()
     * @see #isShowing() 
     * @see #update()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.002 -0500", hash_original_method = "BEB1F63A70D555DEE12C0C7D4BDF7831", hash_generated_method = "D04EC093C1107575A980DF4672B41956")
    
public void setTouchable(boolean touchable) {
        mTouchable = touchable;
    }

    /**
     * <p>Indicates whether the popup window will be informed of touch events
     * outside of its window.</p>
     * 
     * @return true if the popup is outside touchable, false otherwise
     * 
     * @see #setOutsideTouchable(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.004 -0500", hash_original_method = "FF3CAF88B8F1C23DC4869C5AECE8973C", hash_generated_method = "A14E3E0A46CAD0D8AC76557322B5A0B5")
    
public boolean isOutsideTouchable() {
        return mOutsideTouchable;
    }

    /**
     * <p>Controls whether the pop-up will be informed of touch events outside
     * of its window.  This only makes sense for pop-ups that are touchable
     * but not focusable, which means touches outside of the window will
     * be delivered to the window behind.  The default is false.</p>
     *
     * <p>If the popup is showing, calling this method will take effect only
     * the next time the popup is shown or through a manual call to one of
     * the {@link #update()} methods.</p>
     *
     * @param touchable true if the popup should receive outside
     * touch events, false otherwise
     *
     * @see #isOutsideTouchable()
     * @see #isShowing() 
     * @see #update()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.006 -0500", hash_original_method = "8E0154BCB2D650E765619E048D3C66EA", hash_generated_method = "9C3C87BFAD63146F8F41B4FE283570D0")
    
public void setOutsideTouchable(boolean touchable) {
        mOutsideTouchable = touchable;
    }

    /**
     * <p>Indicates whether clipping of the popup window is enabled.</p>
     * 
     * @return true if the clipping is enabled, false otherwise
     * 
     * @see #setClippingEnabled(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.008 -0500", hash_original_method = "5D90AAFBBA18C52B8D43E4274612DFE0", hash_generated_method = "E0C764A4C7706B891E177391606FB142")
    
public boolean isClippingEnabled() {
        return mClippingEnabled;
    }

    /**
     * <p>Allows the popup window to extend beyond the bounds of the screen. By default the
     * window is clipped to the screen boundaries. Setting this to false will allow windows to be
     * accurately positioned.</p>
     * 
     * <p>If the popup is showing, calling this method will take effect only
     * the next time the popup is shown or through a manual call to one of
     * the {@link #update()} methods.</p>
     *
     * @param enabled false if the window should be allowed to extend outside of the screen
     * @see #isShowing() 
     * @see #isClippingEnabled()
     * @see #update()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.010 -0500", hash_original_method = "C644B67739A8A92EE97D978CC897DC79", hash_generated_method = "1C7E01309B9D4A5FE791B8435EDB707D")
    
public void setClippingEnabled(boolean enabled) {
        mClippingEnabled = enabled;
    }

    /**
     * Clip this popup window to the screen, but not to the containing window.
     *
     * @param enabled True to clip to the screen.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.012 -0500", hash_original_method = "86AECB53D9496C7054030FB1672ECE9B", hash_generated_method = "7441C1901588B58C1D443C4125A0478D")
    
public void setClipToScreenEnabled(boolean enabled) {
        mClipToScreen = enabled;
        setClippingEnabled(!enabled);
    }

    /**
     * Allow PopupWindow to scroll the anchor's parent to provide more room
     * for the popup. Enabled by default.
     *
     * @param enabled True to scroll the anchor's parent when more room is desired by the popup.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.014 -0500", hash_original_method = "AB712E1EFFE4EAE7A80987CD7E1E8D4B", hash_generated_method = "AB712E1EFFE4EAE7A80987CD7E1E8D4B")
    
void setAllowScrollingAnchorParent(boolean enabled) {
        mAllowScrollingAnchorParent = enabled;
    }
    
    /**
     * <p>Indicates whether the popup window supports splitting touches.</p>
     * 
     * @return true if the touch splitting is enabled, false otherwise
     * 
     * @see #setSplitTouchEnabled(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.016 -0500", hash_original_method = "CD003A57AD290217AC32D20DAA9F9760", hash_generated_method = "D46005E946D6B956EEE36F7003DBD2F7")
    
public boolean isSplitTouchEnabled() {
        if (mSplitTouchEnabled < 0 && mContext != null) {
            return mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB;
        }
        return mSplitTouchEnabled == 1;
    }

    /**
     * <p>Allows the popup window to split touches across other windows that also
     * support split touch.  When this flag is false, the first pointer
     * that goes down determines the window to which all subsequent touches
     * go until all pointers go up.  When this flag is true, each pointer
     * (not necessarily the first) that goes down determines the window
     * to which all subsequent touches of that pointer will go until that
     * pointer goes up thereby enabling touches with multiple pointers
     * to be split across multiple windows.</p>
     *
     * @param enabled true if the split touches should be enabled, false otherwise
     * @see #isSplitTouchEnabled()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.019 -0500", hash_original_method = "8E279F2F2689369B00326EC855CADBF3", hash_generated_method = "BF1D833D1DD6753529547824DAB73425")
    
public void setSplitTouchEnabled(boolean enabled) {
        mSplitTouchEnabled = enabled ? 1 : 0;
    }

    /**
     * <p>Indicates whether the popup window will be forced into using absolute screen coordinates
     * for positioning.</p>
     *
     * @return true if the window will always be positioned in screen coordinates.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.021 -0500", hash_original_method = "10EB43954998F08298066292E6DC8079", hash_generated_method = "A3AB8242DAAB55D1EA0AD65A49A9A632")
    
public boolean isLayoutInScreenEnabled() {
        return mLayoutInScreen;
    }

    /**
     * <p>Allows the popup window to force the flag
     * {@link WindowManager.LayoutParams#FLAG_LAYOUT_IN_SCREEN}, overriding default behavior.
     * This will cause the popup to be positioned in absolute screen coordinates.</p>
     *
     * @param enabled true if the popup should always be positioned in screen coordinates
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.023 -0500", hash_original_method = "181FE02772B59DB435AF1D6C410875BB", hash_generated_method = "16205F49DC709219DF0C25363529B2CE")
    
public void setLayoutInScreenEnabled(boolean enabled) {
        mLayoutInScreen = enabled;
    }

    /**
     * Allows the popup window to force the flag
     * {@link WindowManager.LayoutParams#FLAG_LAYOUT_INSET_DECOR}, overriding default behavior.
     * This will cause the popup to inset its content to account for system windows overlaying
     * the screen, such as the status bar.
     *
     * <p>This will often be combined with {@link #setLayoutInScreenEnabled(boolean)}.
     *
     * @param enabled true if the popup's views should inset content to account for system windows,
     *                the way that decor views behave for full-screen windows.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.025 -0500", hash_original_method = "FEA07B591038B9982257E6B6F9EA89DD", hash_generated_method = "C0AE6990E74D1924CE4759821A314B7E")
    
public void setLayoutInsetDecor(boolean enabled) {
        mLayoutInsetDecor = enabled;
    }

    /**
     * Set the layout type for this window. Should be one of the TYPE constants defined in
     * {@link WindowManager.LayoutParams}.
     *
     * @param layoutType Layout type for this window.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.027 -0500", hash_original_method = "7DF3C488F6920E6663FDD36E5737A8E3", hash_generated_method = "3E092F285D304F68E4D30FE124D9EE82")
    
public void setWindowLayoutType(int layoutType) {
        mWindowLayoutType = layoutType;
    }

    /**
     * @return The layout type for this window.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.029 -0500", hash_original_method = "B0A202A53A476A9F6F2E7DEE1AC7BFD5", hash_generated_method = "502C134A193F17AF9D07CE99CBEE5CA6")
    
public int getWindowLayoutType() {
        return mWindowLayoutType;
    }

    /**
     * Set whether this window is touch modal or if outside touches will be sent to
     * other windows behind it.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.032 -0500", hash_original_method = "B8930E34962345C50EA9D19D5D77CFE8", hash_generated_method = "EDD8C4CCC83997A190BF0831DB56D22D")
    
public void setTouchModal(boolean touchModal) {
        mNotTouchModal = !touchModal;
    }

    /**
     * <p>Change the width and height measure specs that are given to the
     * window manager by the popup.  By default these are 0, meaning that
     * the current width or height is requested as an explicit size from
     * the window manager.  You can supply
     * {@link ViewGroup.LayoutParams#WRAP_CONTENT} or 
     * {@link ViewGroup.LayoutParams#MATCH_PARENT} to have that measure
     * spec supplied instead, replacing the absolute width and height that
     * has been set in the popup.</p>
     *
     * <p>If the popup is showing, calling this method will take effect only
     * the next time the popup is shown.</p>
     *
     * @param widthSpec an explicit width measure spec mode, either
     * {@link ViewGroup.LayoutParams#WRAP_CONTENT},
     * {@link ViewGroup.LayoutParams#MATCH_PARENT}, or 0 to use the absolute
     * width.
     * @param heightSpec an explicit height measure spec mode, either
     * {@link ViewGroup.LayoutParams#WRAP_CONTENT},
     * {@link ViewGroup.LayoutParams#MATCH_PARENT}, or 0 to use the absolute
     * height.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.033 -0500", hash_original_method = "756D1E68507199C9976BFEB56A60134A", hash_generated_method = "4406A74A8DE8C7CB5AB3641C0E54D25C")
    
public void setWindowLayoutMode(int widthSpec, int heightSpec) {
        mWidthMode = widthSpec;
        mHeightMode = heightSpec;
    }
    
    /**
     * <p>Return this popup's height MeasureSpec</p>
     *
     * @return the height MeasureSpec of the popup
     *
     * @see #setHeight(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.035 -0500", hash_original_method = "0304EDCF78FF45B68A7EB91BFEAAA2CD", hash_generated_method = "7B60B7C518DA05BF980E6A0812F1B814")
    
public int getHeight() {
        return mHeight;
    }

    /**
     * <p>Change the popup's height MeasureSpec</p>
     *
     * <p>If the popup is showing, calling this method will take effect only
     * the next time the popup is shown.</p>
     *
     * @param height the height MeasureSpec of the popup
     *
     * @see #getHeight()
     * @see #isShowing() 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.037 -0500", hash_original_method = "BA89F279BB207625BAE694FF1E8671B8", hash_generated_method = "93DE08FEA5F0FFD7F7B76EF121B3FDFA")
    
public void setHeight(int height) {
        mHeight = height;
    }

    /**
     * <p>Return this popup's width MeasureSpec</p>
     *
     * @return the width MeasureSpec of the popup
     *
     * @see #setWidth(int) 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.039 -0500", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "76288D230877FA0A2BAF233CBE4CB19E")
    
public int getWidth() {
        return mWidth;
    }

    /**
     * <p>Change the popup's width MeasureSpec</p>
     *
     * <p>If the popup is showing, calling this method will take effect only
     * the next time the popup is shown.</p>
     *
     * @param width the width MeasureSpec of the popup
     *
     * @see #getWidth()
     * @see #isShowing()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.041 -0500", hash_original_method = "684C7FEA8A4B53DA843B69F25AEC8ECA", hash_generated_method = "35066D50A292592B544899DE8BE49678")
    
public void setWidth(int width) {
        mWidth = width;
    }

    /**
     * <p>Indicate whether this popup window is showing on screen.</p>
     *
     * @return true if the popup is showing, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.043 -0500", hash_original_method = "2222AA4AEDF5C752B222A7F4E8915559", hash_generated_method = "2E0F6F1B588E696988D1DA04864ABA11")
    
public boolean isShowing() {
        return mIsShowing;
    }

    /**
     * <p>
     * Display the content view in a popup window at the specified location. If the popup window
     * cannot fit on screen, it will be clipped. See {@link android.view.WindowManager.LayoutParams}
     * for more information on how gravity and the x and y parameters are related. Specifying
     * a gravity of {@link android.view.Gravity#NO_GRAVITY} is similar to specifying
     * <code>Gravity.LEFT | Gravity.TOP</code>.
     * </p>
     * 
     * @param parent a parent view to get the {@link android.view.View#getWindowToken()} token from
     * @param gravity the gravity which controls the placement of the popup window
     * @param x the popup's x location offset
     * @param y the popup's y location offset
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.046 -0500", hash_original_method = "7355F7E30A53327DA70C15AA0141C8AD", hash_generated_method = "53DE9E76D5542F2E299C435ACCE475FA")
    
public void showAtLocation(View parent, int gravity, int x, int y) {
        showAtLocation(parent.getWindowToken(), gravity, x, y);
    }

    /**
     * Display the content view in a popup window at the specified location.
     *
     * @param token Window token to use for creating the new window
     * @param gravity the gravity which controls the placement of the popup window
     * @param x the popup's x location offset
     * @param y the popup's y location offset
     *
     * @hide Internal use only. Applications should use
     *       {@link #showAtLocation(View, int, int, int)} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.049 -0500", hash_original_method = "B99D3AF8D05FDFEAE8059FF95B29B82E", hash_generated_method = "7CDCC7435C5DF0C3ADF03798689849D9")
    
public void showAtLocation(IBinder token, int gravity, int x, int y) {
        if (isShowing() || mContentView == null) {
            return;
        }

        unregisterForScrollChanged();

        mIsShowing = true;
        mIsDropdown = false;

        WindowManager.LayoutParams p = createPopupLayout(token);
        p.windowAnimations = computeAnimationResource();
       
        preparePopup(p);
        if (gravity == Gravity.NO_GRAVITY) {
            gravity = Gravity.TOP | Gravity.LEFT;
        }
        p.gravity = gravity;
        p.x = x;
        p.y = y;
        if (mHeightMode < 0) p.height = mLastHeight = mHeightMode;
        if (mWidthMode < 0) p.width = mLastWidth = mWidthMode;
        invokePopup(p);
    }

    /**
     * <p>Display the content view in a popup window anchored to the bottom-left
     * corner of the anchor view. If there is not enough room on screen to show
     * the popup in its entirety, this method tries to find a parent scroll
     * view to scroll. If no parent scroll view can be scrolled, the bottom-left
     * corner of the popup is pinned at the top left corner of the anchor view.</p>
     *
     * @param anchor the view on which to pin the popup window
     *
     * @see #dismiss()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.051 -0500", hash_original_method = "C9F3BB2940AB236715592F07C984C554", hash_generated_method = "20E9C3A6ABB1BE050EB9AC5925ED0954")
    
public void showAsDropDown(View anchor) {
        showAsDropDown(anchor, 0, 0);
    }

    /**
     * <p>Display the content view in a popup window anchored to the bottom-left
     * corner of the anchor view offset by the specified x and y coordinates.
     * If there is not enough room on screen to show
     * the popup in its entirety, this method tries to find a parent scroll
     * view to scroll. If no parent scroll view can be scrolled, the bottom-left
     * corner of the popup is pinned at the top left corner of the anchor view.</p>
     * <p>If the view later scrolls to move <code>anchor</code> to a different
     * location, the popup will be moved correspondingly.</p>
     *
     * @param anchor the view on which to pin the popup window
     *
     * @see #dismiss()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.053 -0500", hash_original_method = "624B6ED3EB88D2A91AFF60DB37AE2E29", hash_generated_method = "10FF533197F45415A64AF110010A46C5")
    
public void showAsDropDown(View anchor, int xoff, int yoff) {
        if (isShowing() || mContentView == null) {
            return;
        }

        registerForScrollChanged(anchor, xoff, yoff);

        mIsShowing = true;
        mIsDropdown = true;

        WindowManager.LayoutParams p = createPopupLayout(anchor.getWindowToken());
        preparePopup(p);

        updateAboveAnchor(findDropDownPosition(anchor, p, xoff, yoff));

        if (mHeightMode < 0) p.height = mLastHeight = mHeightMode;
        if (mWidthMode < 0) p.width = mLastWidth = mWidthMode;

        p.windowAnimations = computeAnimationResource();

        invokePopup(p);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.056 -0500", hash_original_method = "ACCF8C7A05331E8E4B71A7F0F84ED581", hash_generated_method = "7ED3D7192D8393AF04B621CD8C83B50A")
    
private void updateAboveAnchor(boolean aboveAnchor) {
        if (aboveAnchor != mAboveAnchor) {
            mAboveAnchor = aboveAnchor;

            if (mBackground != null) {
                // If the background drawable provided was a StateListDrawable with above-anchor
                // and below-anchor states, use those. Otherwise rely on refreshDrawableState to
                // do the job.
                if (mAboveAnchorBackgroundDrawable != null) {
                    if (mAboveAnchor) {
                        mPopupView.setBackgroundDrawable(mAboveAnchorBackgroundDrawable);
                    } else {
                        mPopupView.setBackgroundDrawable(mBelowAnchorBackgroundDrawable);
                    }
                } else {
                    mPopupView.refreshDrawableState();
                }
            }
        }
    }

    /**
     * Indicates whether the popup is showing above (the y coordinate of the popup's bottom
     * is less than the y coordinate of the anchor) or below the anchor view (the y coordinate
     * of the popup is greater than y coordinate of the anchor's bottom).
     *
     * The value returned
     * by this method is meaningful only after {@link #showAsDropDown(android.view.View)}
     * or {@link #showAsDropDown(android.view.View, int, int)} was invoked.
     *
     * @return True if this popup is showing above the anchor view, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.058 -0500", hash_original_method = "3CCA39FA6959E2A6CCCA2648E4E5EA51", hash_generated_method = "D3C7C64D5C41E93DD3D223668E1B64AE")
    
public boolean isAboveAnchor() {
        return mAboveAnchor;
    }

    /**
     * <p>Prepare the popup by embedding in into a new ViewGroup if the
     * background drawable is not null. If embedding is required, the layout
     * parameters' height is mnodified to take into account the background's
     * padding.</p>
     *
     * @param p the layout parameters of the popup's content view
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.061 -0500", hash_original_method = "DA370B626B41FE86866E281D10A5B6B7", hash_generated_method = "526CD2A8EA2DC736D50A7EAF0BACEA3C")
    
private void preparePopup(WindowManager.LayoutParams p) {
        if (mContentView == null || mContext == null || mWindowManager == null) {
            throw new IllegalStateException("You must specify a valid content view by "
                    + "calling setContentView() before attempting to show the popup.");
        }

        if (mBackground != null) {
            final ViewGroup.LayoutParams layoutParams = mContentView.getLayoutParams();
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            if (layoutParams != null &&
                    layoutParams.height == ViewGroup.LayoutParams.WRAP_CONTENT) {
                height = ViewGroup.LayoutParams.WRAP_CONTENT;
            }

            // when a background is available, we embed the content view
            // within another view that owns the background drawable
            PopupViewContainer popupViewContainer = new PopupViewContainer(mContext);
            PopupViewContainer.LayoutParams listParams = new PopupViewContainer.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, height
            );
            popupViewContainer.setBackgroundDrawable(mBackground);
            popupViewContainer.addView(mContentView, listParams);

            mPopupView = popupViewContainer;
        } else {
            mPopupView = mContentView;
        }
        mPopupWidth = p.width;
        mPopupHeight = p.height;
    }

    /**
     * <p>Invoke the popup window by adding the content view to the window
     * manager.</p>
     *
     * <p>The content view must be non-null when this method is invoked.</p>
     *
     * @param p the layout parameters of the popup's content view
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.063 -0500", hash_original_method = "CC3762287DEDA3D715BCCB052800207D", hash_generated_method = "DD9AB0F63FBC1D5319C76EA59B6A7608")
    
private void invokePopup(WindowManager.LayoutParams p) {
        if (mContext != null) {
            p.packageName = mContext.getPackageName();
        }
        mPopupView.setFitsSystemWindows(mLayoutInsetDecor);
        mWindowManager.addView(mPopupView, p);
    }

    /**
     * <p>Generate the layout parameters for the popup window.</p>
     *
     * @param token the window token used to bind the popup's window
     *
     * @return the layout parameters to pass to the window manager
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.066 -0500", hash_original_method = "D97E1B6317AF67D9DC41A6FB19D27D69", hash_generated_method = "E2098F9CB22E1FAC6A213A69490B4C93")
    
private WindowManager.LayoutParams createPopupLayout(IBinder token) {
        // generates the layout parameters for the drop down
        // we want a fixed size view located at the bottom left of the anchor
        WindowManager.LayoutParams p = new WindowManager.LayoutParams();
        // these gravity settings put the view at the top left corner of the
        // screen. The view is then positioned to the appropriate location
        // by setting the x and y offsets to match the anchor's bottom
        // left corner
        p.gravity = Gravity.LEFT | Gravity.TOP;
        p.width = mLastWidth = mWidth;
        p.height = mLastHeight = mHeight;
        if (mBackground != null) {
            p.format = mBackground.getOpacity();
        } else {
            p.format = PixelFormat.TRANSLUCENT;
        }
        p.flags = computeFlags(p.flags);
        p.type = mWindowLayoutType;
        p.token = token;
        p.softInputMode = mSoftInputMode;
        p.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));

        return p;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.069 -0500", hash_original_method = "731A130870E20EEF0406E3AA79CC1D53", hash_generated_method = "1E01973C1EDDA45B7BEA98EB2AE26272")
    
private int computeFlags(int curFlags) {
        curFlags &= ~(
                WindowManager.LayoutParams.FLAG_IGNORE_CHEEK_PRESSES |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE |
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH |
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS |
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM |
                WindowManager.LayoutParams.FLAG_SPLIT_TOUCH);
        if(mIgnoreCheekPress) {
            curFlags |= WindowManager.LayoutParams.FLAG_IGNORE_CHEEK_PRESSES;
        }
        if (!mFocusable) {
            curFlags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
            if (mInputMethodMode == INPUT_METHOD_NEEDED) {
                curFlags |= WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
            }
        } else if (mInputMethodMode == INPUT_METHOD_NOT_NEEDED) {
            curFlags |= WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
        }
        if (!mTouchable) {
            curFlags |= WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        }
        if (mOutsideTouchable) {
            curFlags |= WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
        }
        if (!mClippingEnabled) {
            curFlags |= WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
        }
        if (isSplitTouchEnabled()) {
            curFlags |= WindowManager.LayoutParams.FLAG_SPLIT_TOUCH;
        }
        if (mLayoutInScreen) {
            curFlags |= WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
        }
        if (mLayoutInsetDecor) {
            curFlags |= WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR;
        }
        if (mNotTouchModal) {
            curFlags |= WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        }
        return curFlags;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.072 -0500", hash_original_method = "2B29575EF3002A68968C6947831DCCDB", hash_generated_method = "C4E180F5937461453AE8246FED71CAD6")
    
private int computeAnimationResource() {
        if (mAnimationStyle == -1) {
            if (mIsDropdown) {
                return mAboveAnchor
                        ? com.android.internal.R.style.Animation_DropDownUp
                        : com.android.internal.R.style.Animation_DropDownDown;
            }
            return 0;
        }
        return mAnimationStyle;
    }
    
    /**
     * <p>Positions the popup window on screen. When the popup window is too
     * tall to fit under the anchor, a parent scroll view is seeked and scrolled
     * up to reclaim space. If scrolling is not possible or not enough, the
     * popup window gets moved on top of the anchor.</p>
     *
     * <p>The height must have been set on the layout parameters prior to
     * calling this method.</p>
     *
     * @param anchor the view on which the popup window must be anchored
     * @param p the layout parameters used to display the drop down
     *
     * @return true if the popup is translated upwards to fit on screen
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.075 -0500", hash_original_method = "5A11C37B27567E510AD1092CF1C461D0", hash_generated_method = "33040EF58CA35D0933DBC9DDF3BC8ED7")
    
private boolean findDropDownPosition(View anchor, WindowManager.LayoutParams p,
            int xoff, int yoff) {

        final int anchorHeight = anchor.getHeight();
        anchor.getLocationInWindow(mDrawingLocation);
        p.x = mDrawingLocation[0] + xoff;
        p.y = mDrawingLocation[1] + anchorHeight + yoff;
        
        boolean onTop = false;

        p.gravity = Gravity.LEFT | Gravity.TOP;
        
        anchor.getLocationOnScreen(mScreenLocation);
        final Rect displayFrame = new Rect();
        anchor.getWindowVisibleDisplayFrame(displayFrame);

        int screenY = mScreenLocation[1] + anchorHeight + yoff;
        
        final View root = anchor.getRootView();
        if (screenY + mPopupHeight > displayFrame.bottom ||
                p.x + mPopupWidth - root.getWidth() > 0) {
            // if the drop down disappears at the bottom of the screen. we try to
            // scroll a parent scrollview or move the drop down back up on top of
            // the edit box
            if (mAllowScrollingAnchorParent) {
                int scrollX = anchor.getScrollX();
                int scrollY = anchor.getScrollY();
                Rect r = new Rect(scrollX, scrollY,  scrollX + mPopupWidth + xoff,
                        scrollY + mPopupHeight + anchor.getHeight() + yoff);
                anchor.requestRectangleOnScreen(r, true);
            }

            // now we re-evaluate the space available, and decide from that
            // whether the pop-up will go above or below the anchor.
            anchor.getLocationInWindow(mDrawingLocation);
            p.x = mDrawingLocation[0] + xoff;
            p.y = mDrawingLocation[1] + anchor.getHeight() + yoff;
            
            // determine whether there is more space above or below the anchor
            anchor.getLocationOnScreen(mScreenLocation);
            
            onTop = (displayFrame.bottom - mScreenLocation[1] - anchor.getHeight() - yoff) <
                    (mScreenLocation[1] - yoff - displayFrame.top);
            if (onTop) {
                p.gravity = Gravity.LEFT | Gravity.BOTTOM;
                p.y = root.getHeight() - mDrawingLocation[1] + yoff;
            } else {
                p.y = mDrawingLocation[1] + anchor.getHeight() + yoff;
            }
        }

        if (mClipToScreen) {
            final int displayFrameWidth = displayFrame.right - displayFrame.left;

            int right = p.x + p.width;
            if (right > displayFrameWidth) {
                p.x -= right - displayFrameWidth;
            }
            if (p.x < displayFrame.left) {
                p.x = displayFrame.left;
                p.width = Math.min(p.width, displayFrameWidth);
            }

            if (onTop) {
                int popupTop = mScreenLocation[1] + yoff - mPopupHeight;
                if (popupTop < 0) {
                    p.y += popupTop;
                }
            } else {
                p.y = Math.max(p.y, displayFrame.top);
            }
        }

        p.gravity |= Gravity.DISPLAY_CLIP_VERTICAL;
        
        return onTop;
    }
    
    /**
     * Returns the maximum height that is available for the popup to be
     * completely shown. It is recommended that this height be the maximum for
     * the popup's height, otherwise it is possible that the popup will be
     * clipped.
     * 
     * @param anchor The view on which the popup window must be anchored.
     * @return The maximum available height for the popup to be completely
     *         shown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.077 -0500", hash_original_method = "023150F59911D5483F51543A59288631", hash_generated_method = "7A444F5743BCCEE72E893C3DA5F59A87")
    
public int getMaxAvailableHeight(View anchor) {
        return getMaxAvailableHeight(anchor, 0);
    }

    /**
     * Returns the maximum height that is available for the popup to be
     * completely shown. It is recommended that this height be the maximum for
     * the popup's height, otherwise it is possible that the popup will be
     * clipped.
     *
     * @param anchor The view on which the popup window must be anchored.
     * @param yOffset y offset from the view's bottom edge
     * @return The maximum available height for the popup to be completely
     *         shown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.079 -0500", hash_original_method = "782C0234D711C16ED6DF402CCEC14809", hash_generated_method = "D60B23B7F82B50B7961D9F761C3A96EA")
    
public int getMaxAvailableHeight(View anchor, int yOffset) {
        return getMaxAvailableHeight(anchor, yOffset, false);
    }
    
    /**
     * Returns the maximum height that is available for the popup to be
     * completely shown, optionally ignoring any bottom decorations such as
     * the input method. It is recommended that this height be the maximum for
     * the popup's height, otherwise it is possible that the popup will be
     * clipped.
     * 
     * @param anchor The view on which the popup window must be anchored.
     * @param yOffset y offset from the view's bottom edge
     * @param ignoreBottomDecorations if true, the height returned will be
     *        all the way to the bottom of the display, ignoring any
     *        bottom decorations
     * @return The maximum available height for the popup to be completely
     *         shown.
     *         
     * @hide Pending API council approval.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.082 -0500", hash_original_method = "6127242297D2005B4B3434B0EF072B4C", hash_generated_method = "2880ACC0CCC6B66901713FDEAF235DBC")
    
public int getMaxAvailableHeight(View anchor, int yOffset, boolean ignoreBottomDecorations) {
        final Rect displayFrame = new Rect();
        anchor.getWindowVisibleDisplayFrame(displayFrame);

        final int[] anchorPos = mDrawingLocation;
        anchor.getLocationOnScreen(anchorPos);
        
        int bottomEdge = displayFrame.bottom;
        if (ignoreBottomDecorations) {
            Resources res = anchor.getContext().getResources();
            bottomEdge = res.getDisplayMetrics().heightPixels;
        }
        final int distanceToBottom = bottomEdge - (anchorPos[1] + anchor.getHeight()) - yOffset;
        final int distanceToTop = anchorPos[1] - displayFrame.top + yOffset;

        // anchorPos[1] is distance from anchor to top of screen
        int returnedHeight = Math.max(distanceToBottom, distanceToTop);
        if (mBackground != null) {
            mBackground.getPadding(mTempRect);
            returnedHeight -= mTempRect.top + mTempRect.bottom; 
        }
        
        return returnedHeight;
    }
    
    /**
     * <p>Dispose of the popup window. This method can be invoked only after
     * {@link #showAsDropDown(android.view.View)} has been executed. Failing that, calling
     * this method will have no effect.</p>
     *
     * @see #showAsDropDown(android.view.View) 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.084 -0500", hash_original_method = "206A53D80E1660978DCF21A355028E66", hash_generated_method = "CEC8DFB2A3209A7E61BF66F395830959")
    
public void dismiss() {
        if (isShowing() && mPopupView != null) {
            mIsShowing = false;

            unregisterForScrollChanged();

            try {
                mWindowManager.removeView(mPopupView);                
            } finally {
                if (mPopupView != mContentView && mPopupView instanceof ViewGroup) {
                    ((ViewGroup) mPopupView).removeView(mContentView);
                }
                mPopupView = null;
    
                if (mOnDismissListener != null) {
                    mOnDismissListener.onDismiss();
                }
            }
        }
    }

    /**
     * Sets the listener to be called when the window is dismissed.
     * 
     * @param onDismissListener The listener.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.086 -0500", hash_original_method = "93E9EBCE36575249CB74D4FBEF26A1CF", hash_generated_method = "1C8C837118CFC7539F8885F9B9866EF5")
    
public void setOnDismissListener(OnDismissListener onDismissListener) {
        mOnDismissListener = onDismissListener;
    }
    
    /**
     * Updates the state of the popup window, if it is currently being displayed,
     * from the currently set state.  This include:
     * {@link #setClippingEnabled(boolean)}, {@link #setFocusable(boolean)},
     * {@link #setIgnoreCheekPress()}, {@link #setInputMethodMode(int)},
     * {@link #setTouchable(boolean)}, and {@link #setAnimationStyle(int)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.088 -0500", hash_original_method = "488D5DDCA6B0F8C983ED8CA34502865A", hash_generated_method = "8A93997AE614F22271F0A3121EB90CE3")
    
public void update() {
        if (!isShowing() || mContentView == null) {
            return;
        }
        
        WindowManager.LayoutParams p = (WindowManager.LayoutParams)
                mPopupView.getLayoutParams();
        
        boolean update = false;
        
        final int newAnim = computeAnimationResource();
        if (newAnim != p.windowAnimations) {
            p.windowAnimations = newAnim;
            update = true;
        }

        final int newFlags = computeFlags(p.flags);
        if (newFlags != p.flags) {
            p.flags = newFlags;
            update = true;
        }
        
        if (update) {
            mWindowManager.updateViewLayout(mPopupView, p);
        }
    }

    /**
     * <p>Updates the dimension of the popup window. Calling this function
     * also updates the window with the current popup state as described
     * for {@link #update()}.</p>
     *
     * @param width the new width
     * @param height the new height
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.091 -0500", hash_original_method = "99E415F6DCFBC1202511EEF5D071A55C", hash_generated_method = "B106EB6DEF9A73C69777BA1DD9BE350D")
    
public void update(int width, int height) {
        WindowManager.LayoutParams p = (WindowManager.LayoutParams)
                mPopupView.getLayoutParams();
        update(p.x, p.y, width, height, false);
    }
    
    /**
     * <p>Updates the position and the dimension of the popup window. Width and
     * height can be set to -1 to update location only.  Calling this function
     * also updates the window with the current popup state as
     * described for {@link #update()}.</p>
     *
     * @param x the new x location
     * @param y the new y location
     * @param width the new width, can be -1 to ignore
     * @param height the new height, can be -1 to ignore
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.093 -0500", hash_original_method = "848B641343A16858C863B802CDF64CDF", hash_generated_method = "373ECA42D8F8D00000AD71E7C9CBB0B2")
    
public void update(int x, int y, int width, int height) {
        update(x, y, width, height, false);
    }

    /**
     * <p>Updates the position and the dimension of the popup window. Width and
     * height can be set to -1 to update location only.  Calling this function
     * also updates the window with the current popup state as
     * described for {@link #update()}.</p>
     *
     * @param x the new x location
     * @param y the new y location
     * @param width the new width, can be -1 to ignore
     * @param height the new height, can be -1 to ignore
     * @param force reposition the window even if the specified position
     *              already seems to correspond to the LayoutParams
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.096 -0500", hash_original_method = "7F49F99468193710A8807FDE38269850", hash_generated_method = "397758BA0068FB838F5FDD2B9449A418")
    
public void update(int x, int y, int width, int height, boolean force) {
        if (width != -1) {
            mLastWidth = width;
            setWidth(width);
        }

        if (height != -1) {
            mLastHeight = height;
            setHeight(height);
        }

        if (!isShowing() || mContentView == null) {
            return;
        }

        WindowManager.LayoutParams p = (WindowManager.LayoutParams) mPopupView.getLayoutParams();

        boolean update = force;

        final int finalWidth = mWidthMode < 0 ? mWidthMode : mLastWidth;
        if (width != -1 && p.width != finalWidth) {
            p.width = mLastWidth = finalWidth;
            update = true;
        }

        final int finalHeight = mHeightMode < 0 ? mHeightMode : mLastHeight;
        if (height != -1 && p.height != finalHeight) {
            p.height = mLastHeight = finalHeight;
            update = true;
        }

        if (p.x != x) {
            p.x = x;
            update = true;
        }

        if (p.y != y) {
            p.y = y;
            update = true;
        }

        final int newAnim = computeAnimationResource();
        if (newAnim != p.windowAnimations) {
            p.windowAnimations = newAnim;
            update = true;
        }

        final int newFlags = computeFlags(p.flags);
        if (newFlags != p.flags) {
            p.flags = newFlags;
            update = true;
        }

        if (update) {
            mWindowManager.updateViewLayout(mPopupView, p);
        }
    }

    /**
     * <p>Updates the position and the dimension of the popup window. Calling this
     * function also updates the window with the current popup state as described
     * for {@link #update()}.</p>
     *
     * @param anchor the popup's anchor view
     * @param width the new width, can be -1 to ignore
     * @param height the new height, can be -1 to ignore
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.099 -0500", hash_original_method = "2E7624B1CB6DF9766B6E25C708FAA465", hash_generated_method = "4463EF16B0B7E42074A9ADB20C25917B")
    
public void update(View anchor, int width, int height) {
        update(anchor, false, 0, 0, true, width, height);
    }
    
    private class PopupViewContainer extends FrameLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.114 -0500", hash_original_field = "49D2493E4F7F43F338146BEAC3857EBA", hash_generated_field = "0B566BDBB758C900741C0BD882C918B7")

        private static final String TAG = "PopupWindow.PopupViewContainer";

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.117 -0500", hash_original_method = "2CEF1E9B6EE64B78C8FCC7C360A10341", hash_generated_method = "C168CDEC1EC39D3EC06CE6AFA8C3AA2E")
        
public PopupViewContainer(Context context) {
            super(context);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.119 -0500", hash_original_method = "60250F32C750F199B013D0293AAF47D3", hash_generated_method = "90B6378D11B9792F9393183600AF3E54")
        
@Override
        protected int[] onCreateDrawableState(int extraSpace) {
            if (mAboveAnchor) {
                // 1 more needed for the above anchor state
                final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
                View.mergeDrawableStates(drawableState, ABOVE_ANCHOR_STATE_SET);
                return drawableState;
            } else {
                return super.onCreateDrawableState(extraSpace);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.122 -0500", hash_original_method = "A2DD55E78C6B8B19849AEC8708A214E9", hash_generated_method = "664BD3635A69F63DA63D458E4E589915")
        
@Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
                if (getKeyDispatcherState() == null) {
                    return super.dispatchKeyEvent(event);
                }

                if (event.getAction() == KeyEvent.ACTION_DOWN
                        && event.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState state = getKeyDispatcherState();
                    if (state != null) {
                        state.startTracking(event, this);
                    }
                    return true;
                } else if (event.getAction() == KeyEvent.ACTION_UP) {
                    KeyEvent.DispatcherState state = getKeyDispatcherState();
                    if (state != null && state.isTracking(event) && !event.isCanceled()) {
                        dismiss();
                        return true;
                    }
                }
                return super.dispatchKeyEvent(event);
            } else {
                return super.dispatchKeyEvent(event);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.125 -0500", hash_original_method = "C7733BB60CAB256C1ABFC72965DD2E24", hash_generated_method = "13DD784DBE88B27401F50D8341618267")
        
@Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            if (mTouchInterceptor != null && mTouchInterceptor.onTouch(this, ev)) {
                return true;
            }
            return super.dispatchTouchEvent(ev);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.127 -0500", hash_original_method = "2EFE76B74388A6782646D0ACFFECA21F", hash_generated_method = "DFBA853240CA4E40C497E55531DAFC99")
        
@Override
        public boolean onTouchEvent(MotionEvent event) {
            final int x = (int) event.getX();
            final int y = (int) event.getY();
            
            if ((event.getAction() == MotionEvent.ACTION_DOWN)
                    && ((x < 0) || (x >= getWidth()) || (y < 0) || (y >= getHeight()))) {
                dismiss();
                return true;
            } else if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                dismiss();
                return true;
            } else {
                return super.onTouchEvent(event);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.129 -0500", hash_original_method = "EB4F4EE30B31AEB9BDFF308A3D2D5CAC", hash_generated_method = "92046F7B9DC15AB1762CE271BC620B7E")
        
@Override
        public void sendAccessibilityEvent(int eventType) {
            // clinets are interested in the content not the container, make it event source
            if (mContentView != null) {
                mContentView.sendAccessibilityEvent(eventType);
            } else {
                super.sendAccessibilityEvent(eventType);
            }
        }
    }
    
    public interface OnDismissListener {
        
        public void onDismiss();
    }

    /**
     * <p>Updates the position and the dimension of the popup window. Width and
     * height can be set to -1 to update location only.  Calling this function
     * also updates the window with the current popup state as
     * described for {@link #update()}.</p>
     *
     * <p>If the view later scrolls to move <code>anchor</code> to a different
     * location, the popup will be moved correspondingly.</p>
     *
     * @param anchor the popup's anchor view
     * @param xoff x offset from the view's left edge
     * @param yoff y offset from the view's bottom edge
     * @param width the new width, can be -1 to ignore
     * @param height the new height, can be -1 to ignore
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.101 -0500", hash_original_method = "B8D2EE4CAAF22B5FC8CA5A06E5BF0669", hash_generated_method = "91609FE96C86FFA6D74A85BF08411CD6")
    
public void update(View anchor, int xoff, int yoff, int width, int height) {
        update(anchor, true, xoff, yoff, true, width, height);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.104 -0500", hash_original_method = "F5290879A773899EB945D797134BA900", hash_generated_method = "579C7E829556C3698E48D25A8DE37367")
    
private void update(View anchor, boolean updateLocation, int xoff, int yoff,
            boolean updateDimension, int width, int height) {

        if (!isShowing() || mContentView == null) {
            return;
        }

        WeakReference<View> oldAnchor = mAnchor;
        final boolean needsUpdate = updateLocation && (mAnchorXoff != xoff || mAnchorYoff != yoff);
        if (oldAnchor == null || oldAnchor.get() != anchor || (needsUpdate && !mIsDropdown)) {
            registerForScrollChanged(anchor, xoff, yoff);
        } else if (needsUpdate) {
            // No need to register again if this is a DropDown, showAsDropDown already did.
            mAnchorXoff = xoff;
            mAnchorYoff = yoff;
        }

        WindowManager.LayoutParams p = (WindowManager.LayoutParams) mPopupView.getLayoutParams();

        if (updateDimension) {
            if (width == -1) {
                width = mPopupWidth;
            } else {
                mPopupWidth = width;
            }
            if (height == -1) {
                height = mPopupHeight;
            } else {
                mPopupHeight = height;
            }
        }

        int x = p.x;
        int y = p.y;

        if (updateLocation) {
            updateAboveAnchor(findDropDownPosition(anchor, p, xoff, yoff));
        } else {
            updateAboveAnchor(findDropDownPosition(anchor, p, mAnchorXoff, mAnchorYoff));            
        }
        
        update(p.x, p.y, width, height, x != p.x || y != p.y);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.109 -0500", hash_original_method = "032144363E44618DF1C4EE95BC82AD16", hash_generated_method = "3D54223C61DAD57A9FE0B4D4C1E721A3")
    
private void unregisterForScrollChanged() {
        WeakReference<View> anchorRef = mAnchor;
        View anchor = null;
        if (anchorRef != null) {
            anchor = anchorRef.get();
        }
        if (anchor != null) {
            ViewTreeObserver vto = anchor.getViewTreeObserver();
            vto.removeOnScrollChangedListener(mOnScrollChangedListener);
        }
        mAnchor = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:08.111 -0500", hash_original_method = "F426C621D66F93AA8E883C7FBA8C8657", hash_generated_method = "782793FDDE3C363EC69AC2EA7BEEFACD")
    
private void registerForScrollChanged(View anchor, int xoff, int yoff) {
        unregisterForScrollChanged();

        mAnchor = new WeakReference<View>(anchor);
        ViewTreeObserver vto = anchor.getViewTreeObserver();
        if (vto != null) {
            vto.addOnScrollChangedListener(mOnScrollChangedListener);
        }

        mAnchorXoff = xoff;
        mAnchorYoff = yoff;
    }
}

