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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "306519E50E3A91B9733D09F5D8EB985C", hash_generated_field = "3C750A4AE06B71AF3A05B7797C7182A4")

    private WindowManager mWindowManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "4100ADFCD62B8FAC1A156667D9A8612E", hash_generated_field = "182408C3124602AF2E2446547BFC5990")

    private boolean mIsShowing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "4FAC955900EEC35ED2CDB7752E904C45", hash_generated_field = "9700652AF3F2C5A2E0A0AFE403A12B64")

    private boolean mIsDropdown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "9E8FE4D07A56D54AEE159583A4429FE8", hash_generated_field = "9EE0242EB014EEED0CD7F44EEE7EA48F")

    private View mContentView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "C0F7B5AE8B2815DB5F788955DE092FEA", hash_generated_field = "677D1CB7D78258D08289E18B4B225566")

    private View mPopupView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "07D4AD4D81CD2ED098EE3F04028AD5C2", hash_generated_field = "26ADB48C5A4311C541C946E4573DD3BE")

    private boolean mFocusable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "AA7C531BC7795BA5494A7D5EB3204D15", hash_generated_field = "B74EBB15400870AA6ADEE3D1E89366AA")

    private int mInputMethodMode = INPUT_METHOD_FROM_FOCUSABLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "4F2735C494280C91B336F362D66AE525", hash_generated_field = "504E8B046E68A38DD3E86D295ED153C0")

    private int mSoftInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "A605AEEF51B195DF68B4D03E0A44560B", hash_generated_field = "81D20D477E5343219A40993A2D5A9281")

    private boolean mTouchable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "089689A1823B6A453A5E5EAF00F479D6", hash_generated_field = "E535EDD135AEF4C6D12D2FCC5626D0B4")

    private boolean mOutsideTouchable = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "DD17DE052A15FBA0E48B98F8543A24F6", hash_generated_field = "1F43204AC614FA8E190D827A0B960C07")

    private boolean mClippingEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "DED47B632D01506CCBEBA9571D0A6265", hash_generated_field = "6B0DF01241CF4AF0DF57F3BB0179F510")

    private int mSplitTouchEnabled = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "157F17B91F343BA4E168B1E33200F7F1", hash_generated_field = "22CD68096C89BB0267ECAB9CEED72BD4")

    private boolean mLayoutInScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "6638D062311A6AB39ECF031AC3F7BA51", hash_generated_field = "F7BA441F0E6563EAA35858C9FBEC3C9D")

    private boolean mClipToScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "EFBE09421249670269F0C3BDEB412056", hash_generated_field = "E18DD07EB2577F208D13A033471EF4B0")

    private boolean mAllowScrollingAnchorParent = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "25095863FE7BF289ADF304DCC9485C0B", hash_generated_field = "4F2A0AC1A5A72DEAB8A91CCC311892CE")

    private boolean mLayoutInsetDecor = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "4EA003FF8B599770ADF79B2AB272C6EB", hash_generated_field = "AA45A743419186F82617924E3E71CD81")

    private boolean mNotTouchModal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "DBFE8676BB8E60198A4C3A8DE984769D", hash_generated_field = "72A5C0221AA7C77012D45B0D5814CA05")

    private OnTouchListener mTouchInterceptor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "FD104D99D022B917A55C66942C8DD087", hash_generated_field = "E1584971BBD05AECB0B7B9F417D8A13C")

    private int mWidthMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

    private int mWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.048 -0400", hash_original_field = "6F78086ED489C76AF68CD63FF2E0DD48", hash_generated_field = "8A8A535915DEF11E8818FDD746192E2F")

    private int mLastWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.049 -0400", hash_original_field = "2B9BACF3978ACE4CCEF1FEEF4F5D6DD5", hash_generated_field = "942FD12E1BB37FE50F8815646F385BF0")

    private int mHeightMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.049 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

    private int mHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.049 -0400", hash_original_field = "A96810B37246B550B03551EFDB789584", hash_generated_field = "7D971819672E66B14BFF50845F865AA1")

    private int mLastHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.063 -0400", hash_original_field = "D63213AAA0338DCBF8F6B541183B1E87", hash_generated_field = "3FD6DB919B847EDFE0B5956AF8A9BD61")

    private int mPopupWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.063 -0400", hash_original_field = "9B5836C1C09FF1DDB39EFE31D977DC2D", hash_generated_field = "81FC9D55F4BDFA3779C66DE9184556C7")

    private int mPopupHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.063 -0400", hash_original_field = "1A122A41C440AB3A641940A9089395BC", hash_generated_field = "904FF38CA36EA4CCC3C2CCEC4DCDD3BD")

    private int[] mDrawingLocation = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.063 -0400", hash_original_field = "4334E35BB5E4C72AD7D1AB6B3F817ECA", hash_generated_field = "E837BED31FD3509BD57D12D959724198")

    private int[] mScreenLocation = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.063 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "AFFA54D19F07A10EE8847CF76FC95323")

    private Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.063 -0400", hash_original_field = "0FD12110A291B3958F114906D990C478", hash_generated_field = "0925F2C91F8CBA797C183309FA7634C5")

    private Drawable mBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.063 -0400", hash_original_field = "B8B18092E45BA94D853A507ABDA726EF", hash_generated_field = "E17C64A85543ECD9874F1E70F5E7D722")

    private Drawable mAboveAnchorBackgroundDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.063 -0400", hash_original_field = "EC891369E261116A9AB3441B4699A1D9", hash_generated_field = "FF8C2A1514D8DB3BCCA18DE7013BFFDC")

    private Drawable mBelowAnchorBackgroundDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.063 -0400", hash_original_field = "57D2370CEAFD062F8EF7CD0CD808B39B", hash_generated_field = "0D6DFCDD3C93CA68BA06073646439B09")

    private boolean mAboveAnchor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.063 -0400", hash_original_field = "FB63600BBB7707A2C1DBB29516DB9717", hash_generated_field = "9BD03BD39A060D11ED1286EBFF9AC4DB")

    private int mWindowLayoutType = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.063 -0400", hash_original_field = "B6794399ABC229B6F5098657922184B3", hash_generated_field = "91E70DA930AA00EAD499671BBD6F37EB")

    private OnDismissListener mOnDismissListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.063 -0400", hash_original_field = "2C071A5321FE10E45F0AB6D217FF33C9", hash_generated_field = "2356D264A59ECD4DA5DAEA961FD9C071")

    private boolean mIgnoreCheekPress = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.063 -0400", hash_original_field = "4295100925E097D9FFEFBAC590D9839F", hash_generated_field = "2D667A20717B87BB0939831DD6C37380")

    private int mAnimationStyle = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.063 -0400", hash_original_field = "8A2549E4A331F412E0868B04A8E3C179", hash_generated_field = "841D2F2B9FEBE43FD9F75F29253325CB")

    private WeakReference<View> mAnchor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.067 -0400", hash_original_field = "8AA9181EAEA04588ABD6B3AB55C1B57C", hash_generated_field = "E86FDACDB44467C59A1D9E8F0EC7BF72")

    private OnScrollChangedListener mOnScrollChangedListener = new OnScrollChangedListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.067 -0400", hash_original_method = "8F0CC5ACEB252AEA9146DA3982ED4810", hash_generated_method = "1F2D12D00022C0731CEBA3D61231C987")
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

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.067 -0400", hash_original_field = "F170BC3F21E6816CF0857FF17CC3E8A8", hash_generated_field = "3E89D2F69E75793719092294948AC6C2")

    private int mAnchorXoff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.067 -0400", hash_original_field = "A2E2D94557B5FCE0E46C1252F1382457", hash_generated_field = "C642333984FB0C821A5D09038A79D9E2")

    private int mAnchorYoff;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.067 -0400", hash_original_method = "A7D29AF9F459F2E9972F382B06EBA7BC", hash_generated_method = "9C07D03A56300782A8BC762C1E6C14C9")
    public  PopupWindow(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.067 -0400", hash_original_method = "366007D96D9B418EA2EA6640B7FB7C46", hash_generated_method = "67F23DFA245DA27CD7B1A7989D056B12")
    public  PopupWindow(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.popupWindowStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.068 -0400", hash_original_method = "FAD82A2A4F32A008B236FC8E4F83669F", hash_generated_method = "FA0128067A513777793AEAE34EBB9F04")
    public  PopupWindow(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.073 -0400", hash_original_method = "079F601C7A8694616AB9480B0999FF46", hash_generated_method = "31D788E3E5C5B8E1C63996BC8AE9B051")
    public  PopupWindow(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        mContext = context;
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
        addTaint(attrs.getTaint());
        addTaint(defStyleAttr);
        addTaint(defStyleRes);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.075 -0400", hash_original_method = "E34384426EB8697F688915D9E72B588C", hash_generated_method = "596F84E29B0A712DA0AAE3A0BA66CFD5")
    public  PopupWindow() {
        this(null, 0, 0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.075 -0400", hash_original_method = "57135C41538C9CD08914B3D745201B31", hash_generated_method = "5D0A2F7305AB92DB61AD479A88482F82")
    public  PopupWindow(View contentView) {
        this(contentView, 0, 0);
        addTaint(contentView.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.076 -0400", hash_original_method = "52D8423742F4089F7506898A8921688C", hash_generated_method = "6D46564051F1A809CC23C28C37B25602")
    public  PopupWindow(int width, int height) {
        this(null, width, height);
        addTaint(width);
        addTaint(height);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.077 -0400", hash_original_method = "824FA1289D7F0041B91552EC537ECD03", hash_generated_method = "8A2E9AA7B1DE5B7B73B9754BC6577B25")
    public  PopupWindow(View contentView, int width, int height) {
        this(contentView, width, height, false);
        addTaint(contentView.getTaint());
        addTaint(width);
        addTaint(height);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.077 -0400", hash_original_method = "45A20F34B738086A724C95615CA38820", hash_generated_method = "F73935062EBDF51F8A924163CE7A1D4F")
    public  PopupWindow(View contentView, int width, int height, boolean focusable) {
        {
            mContext = contentView.getContext();
            mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        } //End block
        setContentView(contentView);
        setWidth(width);
        setHeight(height);
        setFocusable(focusable);
        addTaint(width);
        addTaint(height);
        addTaint(focusable);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.088 -0400", hash_original_method = "63340AE07D2726BC056EFE5BE3E2FF29", hash_generated_method = "85CEF17AFBD1F5F4938F9535D3A96BD7")
    public Drawable getBackground() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1740474137 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1740474137 = mBackground;
        varB4EAC82CA7396A68D541C85D26508E83_1740474137.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1740474137;
        // ---------- Original Method ----------
        //return mBackground;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.088 -0400", hash_original_method = "96D2484B6380046D33AB8470E20080B0", hash_generated_method = "D16C3A30D1BEDA85C77BADB55334CCBB")
    public void setBackgroundDrawable(Drawable background) {
        mBackground = background;
        // ---------- Original Method ----------
        //mBackground = background;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.088 -0400", hash_original_method = "41CA7DA63F7D92402D2B673FD03355D6", hash_generated_method = "3B233C8FDFF7312057E9CD02AF81A2E6")
    public int getAnimationStyle() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_938219625 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_938219625;
        // ---------- Original Method ----------
        //return mAnimationStyle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.089 -0400", hash_original_method = "A2D9F7F5158A57BAC36D16E33D2F221F", hash_generated_method = "BCC06A2E85690E757FF10740FDE4D8C7")
    public void setIgnoreCheekPress() {
        mIgnoreCheekPress = true;
        // ---------- Original Method ----------
        //mIgnoreCheekPress = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.089 -0400", hash_original_method = "46489C40917944BA93E8F6D8658EE802", hash_generated_method = "30E663249BFF81A95B0EE39AF735EB89")
    public void setAnimationStyle(int animationStyle) {
        mAnimationStyle = animationStyle;
        // ---------- Original Method ----------
        //mAnimationStyle = animationStyle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.090 -0400", hash_original_method = "1FBDC8A7B1B2CCF1CAFCE9F94E1B072D", hash_generated_method = "69330D027ACD0A0B5419136A7EACC7B7")
    public View getContentView() {
        View varB4EAC82CA7396A68D541C85D26508E83_895617446 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_895617446 = mContentView;
        varB4EAC82CA7396A68D541C85D26508E83_895617446.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_895617446;
        // ---------- Original Method ----------
        //return mContentView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.094 -0400", hash_original_method = "647C3E968C5C98ECF0A359511A938D87", hash_generated_method = "08B53B8F82DC32A09BE6F226B625CF53")
    public void setContentView(View contentView) {
        {
            boolean var4A685BA46E35F21FC0CB2BDAFA9CFEA5_2049251101 = (isShowing());
        } //End collapsed parenthetic
        mContentView = contentView;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.094 -0400", hash_original_method = "DE25D00870282EA3EAE9EBB02519A2CA", hash_generated_method = "130FE76FE298B90583B66B9C1E8E1782")
    public void setTouchInterceptor(OnTouchListener l) {
        mTouchInterceptor = l;
        // ---------- Original Method ----------
        //mTouchInterceptor = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.101 -0400", hash_original_method = "40BB85E3EB9B026A95FA1376FB5C6D2D", hash_generated_method = "DE207EA95290B388AEAD66CAB9FC147F")
    public boolean isFocusable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1158727932 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1158727932;
        // ---------- Original Method ----------
        //return mFocusable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.102 -0400", hash_original_method = "ABAB7A7DE4A915B0505D233953D72C47", hash_generated_method = "73B30D7B6EF00BF878189A326F3284C3")
    public void setFocusable(boolean focusable) {
        mFocusable = focusable;
        // ---------- Original Method ----------
        //mFocusable = focusable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.102 -0400", hash_original_method = "01F2BFCF39394BA4008813FFB1127C10", hash_generated_method = "9F7033D9F47F37E744CDA17C1A8DD00F")
    public int getInputMethodMode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413939723 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413939723;
        // ---------- Original Method ----------
        //return mInputMethodMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.102 -0400", hash_original_method = "960CEBA1FA646F0DDCC5CA21C9FFA47A", hash_generated_method = "A6E33B617E3054749700BA5054FB5936")
    public void setInputMethodMode(int mode) {
        mInputMethodMode = mode;
        // ---------- Original Method ----------
        //mInputMethodMode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.103 -0400", hash_original_method = "4B11C5E74D17332CC7C67B3F22EF8E33", hash_generated_method = "1D7C1083F51FF0DA3819F794F94DE227")
    public void setSoftInputMode(int mode) {
        mSoftInputMode = mode;
        // ---------- Original Method ----------
        //mSoftInputMode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.103 -0400", hash_original_method = "76888AB414E08DF2E7D12678F406D7A5", hash_generated_method = "071D1A21FF05FB42A0258DAC5A0FC89B")
    public int getSoftInputMode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_507921515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_507921515;
        // ---------- Original Method ----------
        //return mSoftInputMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.109 -0400", hash_original_method = "AE839D196CDFD95E127ACD4470F67375", hash_generated_method = "4A7F5F7E19435C6CA46C4BA23B09EBA9")
    public boolean isTouchable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1124518034 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1124518034;
        // ---------- Original Method ----------
        //return mTouchable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.109 -0400", hash_original_method = "BEB1F63A70D555DEE12C0C7D4BDF7831", hash_generated_method = "53CC1C5C2E5530440B2CCE60DCC9D428")
    public void setTouchable(boolean touchable) {
        mTouchable = touchable;
        // ---------- Original Method ----------
        //mTouchable = touchable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.123 -0400", hash_original_method = "FF3CAF88B8F1C23DC4869C5AECE8973C", hash_generated_method = "0C89C92054B1648B08B5C4771453BBF2")
    public boolean isOutsideTouchable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_280736622 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_280736622;
        // ---------- Original Method ----------
        //return mOutsideTouchable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.123 -0400", hash_original_method = "8E0154BCB2D650E765619E048D3C66EA", hash_generated_method = "FE2AEFBB8C4EEBABE5D6E1A098A60CB0")
    public void setOutsideTouchable(boolean touchable) {
        mOutsideTouchable = touchable;
        // ---------- Original Method ----------
        //mOutsideTouchable = touchable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.124 -0400", hash_original_method = "5D90AAFBBA18C52B8D43E4274612DFE0", hash_generated_method = "EB1D5CCE3013A5D1427E1E9F80BE52EB")
    public boolean isClippingEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_300775700 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_300775700;
        // ---------- Original Method ----------
        //return mClippingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.124 -0400", hash_original_method = "C644B67739A8A92EE97D978CC897DC79", hash_generated_method = "684E85C82CBEB4AB4A8C43DA093096AD")
    public void setClippingEnabled(boolean enabled) {
        mClippingEnabled = enabled;
        // ---------- Original Method ----------
        //mClippingEnabled = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.125 -0400", hash_original_method = "86AECB53D9496C7054030FB1672ECE9B", hash_generated_method = "235F8CA48AA18F6B969B7FF20C467B2E")
    public void setClipToScreenEnabled(boolean enabled) {
        mClipToScreen = enabled;
        setClippingEnabled(!enabled);
        // ---------- Original Method ----------
        //mClipToScreen = enabled;
        //setClippingEnabled(!enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.125 -0400", hash_original_method = "AB712E1EFFE4EAE7A80987CD7E1E8D4B", hash_generated_method = "FE43850C7268C6EE8DB37340BB239900")
     void setAllowScrollingAnchorParent(boolean enabled) {
        mAllowScrollingAnchorParent = enabled;
        // ---------- Original Method ----------
        //mAllowScrollingAnchorParent = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.129 -0400", hash_original_method = "CD003A57AD290217AC32D20DAA9F9760", hash_generated_method = "7D821CA1CC722404EAC4A1ADD110351E")
    public boolean isSplitTouchEnabled() {
        {
            boolean varEEA1697260544E0A5861DD090A86C488_756709821 = (mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1533564247 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1533564247;
        // ---------- Original Method ----------
        //if (mSplitTouchEnabled < 0 && mContext != null) {
            //return mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB;
        //}
        //return mSplitTouchEnabled == 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.130 -0400", hash_original_method = "8E279F2F2689369B00326EC855CADBF3", hash_generated_method = "16FCD3DA62C4843F4FE76768308439EA")
    public void setSplitTouchEnabled(boolean enabled) {
        mSplitTouchEnabled = enabled ? 1 : 0;
        // ---------- Original Method ----------
        //mSplitTouchEnabled = enabled ? 1 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.130 -0400", hash_original_method = "10EB43954998F08298066292E6DC8079", hash_generated_method = "FD299F98231094D2FA6E8F16A4EB285F")
    public boolean isLayoutInScreenEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1690165137 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1690165137;
        // ---------- Original Method ----------
        //return mLayoutInScreen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.130 -0400", hash_original_method = "181FE02772B59DB435AF1D6C410875BB", hash_generated_method = "223E785F0B8E3AC353A80B21D7B051A2")
    public void setLayoutInScreenEnabled(boolean enabled) {
        mLayoutInScreen = enabled;
        // ---------- Original Method ----------
        //mLayoutInScreen = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.145 -0400", hash_original_method = "FEA07B591038B9982257E6B6F9EA89DD", hash_generated_method = "B17F3787A243E7C34D946849ECA3B77D")
    public void setLayoutInsetDecor(boolean enabled) {
        mLayoutInsetDecor = enabled;
        // ---------- Original Method ----------
        //mLayoutInsetDecor = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.146 -0400", hash_original_method = "7DF3C488F6920E6663FDD36E5737A8E3", hash_generated_method = "86D8C382E8DE29516140D730E3EA62C0")
    public void setWindowLayoutType(int layoutType) {
        mWindowLayoutType = layoutType;
        // ---------- Original Method ----------
        //mWindowLayoutType = layoutType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.146 -0400", hash_original_method = "B0A202A53A476A9F6F2E7DEE1AC7BFD5", hash_generated_method = "054CC459384B5065A1F8FD2135734584")
    public int getWindowLayoutType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1179621335 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1179621335;
        // ---------- Original Method ----------
        //return mWindowLayoutType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.146 -0400", hash_original_method = "B8930E34962345C50EA9D19D5D77CFE8", hash_generated_method = "19AEA7D6541C507D6EB32AC9EE42DBE9")
    public void setTouchModal(boolean touchModal) {
        mNotTouchModal = !touchModal;
        // ---------- Original Method ----------
        //mNotTouchModal = !touchModal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.147 -0400", hash_original_method = "756D1E68507199C9976BFEB56A60134A", hash_generated_method = "386434F8D6065CAF3B8B583908DED42B")
    public void setWindowLayoutMode(int widthSpec, int heightSpec) {
        mWidthMode = widthSpec;
        mHeightMode = heightSpec;
        // ---------- Original Method ----------
        //mWidthMode = widthSpec;
        //mHeightMode = heightSpec;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.147 -0400", hash_original_method = "0304EDCF78FF45B68A7EB91BFEAAA2CD", hash_generated_method = "CF1E5619D6F868A441C27DA94B5CE409")
    public int getHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_667997000 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_667997000;
        // ---------- Original Method ----------
        //return mHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.147 -0400", hash_original_method = "BA89F279BB207625BAE694FF1E8671B8", hash_generated_method = "5421EB99FBB05FB66E8A75CFDF238048")
    public void setHeight(int height) {
        mHeight = height;
        // ---------- Original Method ----------
        //mHeight = height;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.148 -0400", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "63C5A5BF21C43903DAAF992C9814EC10")
    public int getWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_295396923 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_295396923;
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.148 -0400", hash_original_method = "684C7FEA8A4B53DA843B69F25AEC8ECA", hash_generated_method = "708EDDEF80D7966FCCE04921295DE407")
    public void setWidth(int width) {
        mWidth = width;
        // ---------- Original Method ----------
        //mWidth = width;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.148 -0400", hash_original_method = "2222AA4AEDF5C752B222A7F4E8915559", hash_generated_method = "6F570C240BD0DF953F4EB39ACEAEAF61")
    public boolean isShowing() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_270072469 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_270072469;
        // ---------- Original Method ----------
        //return mIsShowing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.148 -0400", hash_original_method = "7355F7E30A53327DA70C15AA0141C8AD", hash_generated_method = "222809ADC30D869701C47E5D68E32A45")
    public void showAtLocation(View parent, int gravity, int x, int y) {
        showAtLocation(parent.getWindowToken(), gravity, x, y);
        addTaint(parent.getTaint());
        addTaint(gravity);
        addTaint(x);
        addTaint(y);
        // ---------- Original Method ----------
        //showAtLocation(parent.getWindowToken(), gravity, x, y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.163 -0400", hash_original_method = "B99D3AF8D05FDFEAE8059FF95B29B82E", hash_generated_method = "B0B6DE8191B55F90C75D48EB907BB2C2")
    public void showAtLocation(IBinder token, int gravity, int x, int y) {
        {
            boolean var9BC9BAF6F3002BB79EBDDA5435C62A79_168161683 = (isShowing() || mContentView == null);
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
        addTaint(token.getTaint());
        addTaint(gravity);
        addTaint(x);
        addTaint(y);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.163 -0400", hash_original_method = "C9F3BB2940AB236715592F07C984C554", hash_generated_method = "0C67003C09A325345ECE3D5DC84AF9A7")
    public void showAsDropDown(View anchor) {
        showAsDropDown(anchor, 0, 0);
        addTaint(anchor.getTaint());
        // ---------- Original Method ----------
        //showAsDropDown(anchor, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.164 -0400", hash_original_method = "624B6ED3EB88D2A91AFF60DB37AE2E29", hash_generated_method = "04D96E14424A01A16D7530D4C5663550")
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        {
            boolean var9BC9BAF6F3002BB79EBDDA5435C62A79_1845865586 = (isShowing() || mContentView == null);
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
        addTaint(anchor.getTaint());
        addTaint(xoff);
        addTaint(yoff);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.164 -0400", hash_original_method = "ACCF8C7A05331E8E4B71A7F0F84ED581", hash_generated_method = "94294C75061A1D79AA8D5AA83CE7A91A")
    private void updateAboveAnchor(boolean aboveAnchor) {
        {
            mAboveAnchor = aboveAnchor;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.166 -0400", hash_original_method = "3CCA39FA6959E2A6CCCA2648E4E5EA51", hash_generated_method = "B7239B9C17131E8634F4715E294513C9")
    public boolean isAboveAnchor() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1025853866 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1025853866;
        // ---------- Original Method ----------
        //return mAboveAnchor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.166 -0400", hash_original_method = "DA370B626B41FE86866E281D10A5B6B7", hash_generated_method = "F38306196C0967994DCCEFD9084DDEF8")
    private void preparePopup(WindowManager.LayoutParams p) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.241 -0400", hash_original_method = "CC3762287DEDA3D715BCCB052800207D", hash_generated_method = "787952604DE7997FCECEF5616DE55898")
    private void invokePopup(WindowManager.LayoutParams p) {
        {
            p.packageName = mContext.getPackageName();
        } //End block
        mPopupView.setFitsSystemWindows(mLayoutInsetDecor);
        mWindowManager.addView(mPopupView, p);
        addTaint(p.getTaint());
        // ---------- Original Method ----------
        //if (mContext != null) {
            //p.packageName = mContext.getPackageName();
        //}
        //mPopupView.setFitsSystemWindows(mLayoutInsetDecor);
        //mWindowManager.addView(mPopupView, p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.250 -0400", hash_original_method = "D97E1B6317AF67D9DC41A6FB19D27D69", hash_generated_method = "F662A9D882C78796CF07C0C28546119A")
    private WindowManager.LayoutParams createPopupLayout(IBinder token) {
        WindowManager.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1051048153 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1051048153 = p;
        addTaint(token.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1051048153.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1051048153;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.252 -0400", hash_original_method = "731A130870E20EEF0406E3AA79CC1D53", hash_generated_method = "C3AF80A4C5FD4C38301F93730965C0CC")
    private int computeFlags(int curFlags) {
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
            boolean varC512B087080D8F65FDEBB4C012341A4B_1088928775 = (isSplitTouchEnabled());
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
        addTaint(curFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_52935018 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_52935018;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.269 -0400", hash_original_method = "2B29575EF3002A68968C6947831DCCDB", hash_generated_method = "667258CD436240E1BEA2E227EE906613")
    private int computeAnimationResource() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128323541 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128323541;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.272 -0400", hash_original_method = "5A11C37B27567E510AD1092CF1C461D0", hash_generated_method = "6E9F080AFA705ACAB5CDECC72227687C")
    private boolean findDropDownPosition(View anchor, WindowManager.LayoutParams p,
            int xoff, int yoff) {
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
            boolean var74CA561700F828A0D92807B977326861_2011915293 = (screenY + mPopupHeight > displayFrame.bottom ||
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
        addTaint(anchor.getTaint());
        addTaint(p.getTaint());
        addTaint(xoff);
        addTaint(yoff);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_466144313 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_466144313;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.272 -0400", hash_original_method = "023150F59911D5483F51543A59288631", hash_generated_method = "6AFB2663271496478A92D6240A323FAA")
    public int getMaxAvailableHeight(View anchor) {
        int varA711B8768F5CD08E9377B11ECAC1715F_94636162 = (getMaxAvailableHeight(anchor, 0));
        addTaint(anchor.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2116963069 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2116963069;
        // ---------- Original Method ----------
        //return getMaxAvailableHeight(anchor, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.276 -0400", hash_original_method = "782C0234D711C16ED6DF402CCEC14809", hash_generated_method = "B0AFD9795A270DC9A0420D2B797A1D68")
    public int getMaxAvailableHeight(View anchor, int yOffset) {
        int var469BE61637FC70E4C9728196B89D54FF_692860053 = (getMaxAvailableHeight(anchor, yOffset, false));
        addTaint(anchor.getTaint());
        addTaint(yOffset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1490861879 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1490861879;
        // ---------- Original Method ----------
        //return getMaxAvailableHeight(anchor, yOffset, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.276 -0400", hash_original_method = "6127242297D2005B4B3434B0EF072B4C", hash_generated_method = "10ECA4129C3B05B3B5FE0A2A9B40AA45")
    public int getMaxAvailableHeight(View anchor, int yOffset, boolean ignoreBottomDecorations) {
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
        addTaint(anchor.getTaint());
        addTaint(yOffset);
        addTaint(ignoreBottomDecorations);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907181747 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907181747;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.293 -0400", hash_original_method = "206A53D80E1660978DCF21A355028E66", hash_generated_method = "90F09652F789A296268900807FB61F23")
    public void dismiss() {
        {
            boolean var2C554DDD957DC9A014B8B4DE4C803696_748031445 = (isShowing() && mPopupView != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.293 -0400", hash_original_method = "93E9EBCE36575249CB74D4FBEF26A1CF", hash_generated_method = "8A15ECA68636163A82E11179DEBF050D")
    public void setOnDismissListener(OnDismissListener onDismissListener) {
        mOnDismissListener = onDismissListener;
        // ---------- Original Method ----------
        //mOnDismissListener = onDismissListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.294 -0400", hash_original_method = "488D5DDCA6B0F8C983ED8CA34502865A", hash_generated_method = "83C2D4DC11745D26AEBA464B1C1558EF")
    public void update() {
        {
            boolean var792B694D840F3959F85BC36B57C55AEF_322679876 = (!isShowing() || mContentView == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.294 -0400", hash_original_method = "99E415F6DCFBC1202511EEF5D071A55C", hash_generated_method = "9AA19E688C3FB603C38ADEF0BB4530C4")
    public void update(int width, int height) {
        WindowManager.LayoutParams p;
        p = (WindowManager.LayoutParams)
                mPopupView.getLayoutParams();
        update(p.x, p.y, width, height, false);
        addTaint(width);
        addTaint(height);
        // ---------- Original Method ----------
        //WindowManager.LayoutParams p = (WindowManager.LayoutParams)
                //mPopupView.getLayoutParams();
        //update(p.x, p.y, width, height, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.295 -0400", hash_original_method = "848B641343A16858C863B802CDF64CDF", hash_generated_method = "69135259B53DA7A3D1C53657EF6DFE26")
    public void update(int x, int y, int width, int height) {
        update(x, y, width, height, false);
        addTaint(x);
        addTaint(y);
        addTaint(width);
        addTaint(height);
        // ---------- Original Method ----------
        //update(x, y, width, height, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.300 -0400", hash_original_method = "7F49F99468193710A8807FDE38269850", hash_generated_method = "C94EC44CCBDCB7B4AF7596E44A818AA8")
    public void update(int x, int y, int width, int height, boolean force) {
        {
            mLastWidth = width;
            setWidth(width);
        } //End block
        {
            mLastHeight = height;
            setHeight(height);
        } //End block
        {
            boolean var792B694D840F3959F85BC36B57C55AEF_302812362 = (!isShowing() || mContentView == null);
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
        addTaint(x);
        addTaint(y);
        addTaint(force);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.300 -0400", hash_original_method = "2E7624B1CB6DF9766B6E25C708FAA465", hash_generated_method = "9C50D29725A23526BE8D558D63378C1F")
    public void update(View anchor, int width, int height) {
        update(anchor, false, 0, 0, true, width, height);
        addTaint(anchor.getTaint());
        addTaint(width);
        addTaint(height);
        // ---------- Original Method ----------
        //update(anchor, false, 0, 0, true, width, height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.308 -0400", hash_original_method = "B8D2EE4CAAF22B5FC8CA5A06E5BF0669", hash_generated_method = "00BEEACD1C914FDC0038C32D15766000")
    public void update(View anchor, int xoff, int yoff, int width, int height) {
        update(anchor, true, xoff, yoff, true, width, height);
        addTaint(anchor.getTaint());
        addTaint(xoff);
        addTaint(yoff);
        addTaint(width);
        addTaint(height);
        // ---------- Original Method ----------
        //update(anchor, true, xoff, yoff, true, width, height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.315 -0400", hash_original_method = "F5290879A773899EB945D797134BA900", hash_generated_method = "25577D759FD6B7FAF0AF35FDA802207F")
    private void update(View anchor, boolean updateLocation, int xoff, int yoff,
            boolean updateDimension, int width, int height) {
        {
            boolean var792B694D840F3959F85BC36B57C55AEF_939929018 = (!isShowing() || mContentView == null);
        } //End collapsed parenthetic
        WeakReference<View> oldAnchor;
        oldAnchor = mAnchor;
        boolean needsUpdate;
        needsUpdate = updateLocation && (mAnchorXoff != xoff || mAnchorYoff != yoff);
        {
            boolean varBA4588A4E37197031A7BA0375487BCBA_1603815828 = (oldAnchor == null || oldAnchor.get() != anchor || (needsUpdate && !mIsDropdown));
            {
                registerForScrollChanged(anchor, xoff, yoff);
            } //End block
            {
                mAnchorXoff = xoff;
                mAnchorYoff = yoff;
            } //End block
        } //End collapsed parenthetic
        WindowManager.LayoutParams p;
        p = (WindowManager.LayoutParams) mPopupView.getLayoutParams();
        {
            {
                width = mPopupWidth;
            } //End block
            {
                mPopupWidth = width;
            } //End block
            {
                height = mPopupHeight;
            } //End block
            {
                mPopupHeight = height;
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
        addTaint(anchor.getTaint());
        addTaint(updateLocation);
        addTaint(updateDimension);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.317 -0400", hash_original_method = "032144363E44618DF1C4EE95BC82AD16", hash_generated_method = "3941AAE17C8AC0CB83D0C52071E97C56")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.331 -0400", hash_original_method = "F426C621D66F93AA8E883C7FBA8C8657", hash_generated_method = "EA900A1897E383A4833761149635D656")
    private void registerForScrollChanged(View anchor, int xoff, int yoff) {
        unregisterForScrollChanged();
        mAnchor = new WeakReference<View>(anchor);
        ViewTreeObserver vto;
        vto = anchor.getViewTreeObserver();
        {
            vto.addOnScrollChangedListener(mOnScrollChangedListener);
        } //End block
        mAnchorXoff = xoff;
        mAnchorYoff = yoff;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.332 -0400", hash_original_method = "2CEF1E9B6EE64B78C8FCC7C360A10341", hash_generated_method = "5E9A647D72DC263E9352A7381E95B0CA")
        public  PopupViewContainer(Context context) {
            super(context);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.332 -0400", hash_original_method = "60250F32C750F199B013D0293AAF47D3", hash_generated_method = "FABDA116AB72201C89A7C60F7FB306F5")
        @Override
        protected int[] onCreateDrawableState(int extraSpace) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                int[] drawableState;
                drawableState = super.onCreateDrawableState(extraSpace + 1);
                View.mergeDrawableStates(drawableState, ABOVE_ANCHOR_STATE_SET);
            } //End block
            {
                int[] var74CE87D3619881427F9757CCE4F4BF6A_329068493 = (super.onCreateDrawableState(extraSpace));
            } //End block
            addTaint(extraSpace);
            int[] varB4CCCA26F9DB9189C32F33E82D425CFB_2099611367 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_2099611367;
            // ---------- Original Method ----------
            //if (mAboveAnchor) {
                //final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
                //View.mergeDrawableStates(drawableState, ABOVE_ANCHOR_STATE_SET);
                //return drawableState;
            //} else {
                //return super.onCreateDrawableState(extraSpace);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.333 -0400", hash_original_method = "A2DD55E78C6B8B19849AEC8708A214E9", hash_generated_method = "6078517475F5E8E6EF24095F7E41707D")
        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            {
                boolean varC71B767C5D14CF758CFC7EA9349BEE50_858748395 = (event.getKeyCode() == KeyEvent.KEYCODE_BACK);
                {
                    {
                        boolean var0530024EDAEF285FA074A5D0CCF9FBC3_183910568 = (getKeyDispatcherState() == null);
                        {
                            boolean var9B794F99509F39111FB8A6A64D542633_2117551581 = (super.dispatchKeyEvent(event));
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varF456D875C94EFA50F4F83E456081D7DC_1565914220 = (event.getAction() == KeyEvent.ACTION_DOWN
                        && event.getRepeatCount() == 0);
                        {
                            KeyEvent.DispatcherState state;
                            state = getKeyDispatcherState();
                            {
                                state.startTracking(event, this);
                            } //End block
                        } //End block
                        {
                            boolean var6A33DE310C5D908541C47FFDD30D2802_802810681 = (event.getAction() == KeyEvent.ACTION_UP);
                            {
                                KeyEvent.DispatcherState state;
                                state = getKeyDispatcherState();
                                {
                                    boolean var220DFBBB57806723689C9C46DFE1C558_1998384154 = (state != null && state.isTracking(event) && !event.isCanceled());
                                    {
                                        dismiss();
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                    boolean var97BD0C91372FF8CDE07B475E38FE656A_1966607545 = (super.dispatchKeyEvent(event));
                } //End block
                {
                    boolean var97BD0C91372FF8CDE07B475E38FE656A_1585572014 = (super.dispatchKeyEvent(event));
                } //End block
            } //End collapsed parenthetic
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_646490271 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_646490271;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.334 -0400", hash_original_method = "C7733BB60CAB256C1ABFC72965DD2E24", hash_generated_method = "2C01E29027BF8C5D066BB79C7B159CF1")
        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            {
                boolean var93C4222DC4A59A9B32842AA419F1377C_1596851984 = (mTouchInterceptor != null && mTouchInterceptor.onTouch(this, ev));
            } //End collapsed parenthetic
            boolean varD9CFC974DB9B4187D396B15CE784ECB1_1673738084 = (super.dispatchTouchEvent(ev));
            addTaint(ev.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_890111482 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_890111482;
            // ---------- Original Method ----------
            //if (mTouchInterceptor != null && mTouchInterceptor.onTouch(this, ev)) {
                //return true;
            //}
            //return super.dispatchTouchEvent(ev);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.335 -0400", hash_original_method = "2EFE76B74388A6782646D0ACFFECA21F", hash_generated_method = "E78F2D65C16DCCC35A456E0FEC75FB48")
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            int x;
            x = (int) event.getX();
            int y;
            y = (int) event.getY();
            {
                boolean var0FCE2C8AA5CE2F3DB17871F164D2ABD3_1739929381 = ((event.getAction() == MotionEvent.ACTION_DOWN)
                    && ((x < 0) || (x >= getWidth()) || (y < 0) || (y >= getHeight())));
                {
                    dismiss();
                } //End block
                {
                    boolean var267E05D3737D25CB7AC9FBB08A12D390_2011936940 = (event.getAction() == MotionEvent.ACTION_OUTSIDE);
                    {
                        dismiss();
                    } //End block
                    {
                        boolean varEFC6B821CDB4DB5344876A10D775A068_1001562014 = (super.onTouchEvent(event));
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_572793285 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_572793285;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.351 -0400", hash_original_method = "EB4F4EE30B31AEB9BDFF308A3D2D5CAC", hash_generated_method = "4F9FF4D7D2FB8B0078F4048622D25F4D")
        @Override
        public void sendAccessibilityEvent(int eventType) {
            {
                mContentView.sendAccessibilityEvent(eventType);
            } //End block
            {
                super.sendAccessibilityEvent(eventType);
            } //End block
            addTaint(eventType);
            // ---------- Original Method ----------
            //if (mContentView != null) {
                //mContentView.sendAccessibilityEvent(eventType);
            //} else {
                //super.sendAccessibilityEvent(eventType);
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.351 -0400", hash_original_field = "D449010BF1EF4FD4CDACB1483101094D", hash_generated_field = "82FFDAFFDEC0A4E693DF9CABCBE6F6CF")

        private static String TAG = "PopupWindow.PopupViewContainer";
    }


    
    public interface OnDismissListener {
        
        public void onDismiss();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.351 -0400", hash_original_field = "873CD8303E150C0023A5A0952E0C3FDE", hash_generated_field = "EC879018D8E62A80ED7D5976B9A1B7A2")

    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.351 -0400", hash_original_field = "6129920895E2F2D47FADD35814B7EF6A", hash_generated_field = "620E7E20B08AC8DE8E08A876F15941F3")

    public static final int INPUT_METHOD_NEEDED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.351 -0400", hash_original_field = "03AFDC5E672A4B0142D6C7FFC5351ED3", hash_generated_field = "34E45A8A1172450CBFBC57CBC51A7F74")

    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.351 -0400", hash_original_field = "049F117D2BC9BFBE1D299F88D069231A", hash_generated_field = "F7C47885263AE84AD61ECC758D89A111")

    private static int[] ABOVE_ANCHOR_STATE_SET = new int[] {
        com.android.internal.R.attr.state_above_anchor
    };
}

