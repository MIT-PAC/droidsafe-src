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
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class PopupWindow {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.946 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.946 -0400", hash_original_field = "306519E50E3A91B9733D09F5D8EB985C", hash_generated_field = "3C750A4AE06B71AF3A05B7797C7182A4")

    private WindowManager mWindowManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.946 -0400", hash_original_field = "4100ADFCD62B8FAC1A156667D9A8612E", hash_generated_field = "182408C3124602AF2E2446547BFC5990")

    private boolean mIsShowing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.946 -0400", hash_original_field = "4FAC955900EEC35ED2CDB7752E904C45", hash_generated_field = "9700652AF3F2C5A2E0A0AFE403A12B64")

    private boolean mIsDropdown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.946 -0400", hash_original_field = "9E8FE4D07A56D54AEE159583A4429FE8", hash_generated_field = "9EE0242EB014EEED0CD7F44EEE7EA48F")

    private View mContentView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.946 -0400", hash_original_field = "C0F7B5AE8B2815DB5F788955DE092FEA", hash_generated_field = "677D1CB7D78258D08289E18B4B225566")

    private View mPopupView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.946 -0400", hash_original_field = "07D4AD4D81CD2ED098EE3F04028AD5C2", hash_generated_field = "26ADB48C5A4311C541C946E4573DD3BE")

    private boolean mFocusable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.946 -0400", hash_original_field = "AA7C531BC7795BA5494A7D5EB3204D15", hash_generated_field = "B74EBB15400870AA6ADEE3D1E89366AA")

    private int mInputMethodMode = INPUT_METHOD_FROM_FOCUSABLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.946 -0400", hash_original_field = "4F2735C494280C91B336F362D66AE525", hash_generated_field = "504E8B046E68A38DD3E86D295ED153C0")

    private int mSoftInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.946 -0400", hash_original_field = "A605AEEF51B195DF68B4D03E0A44560B", hash_generated_field = "81D20D477E5343219A40993A2D5A9281")

    private boolean mTouchable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.946 -0400", hash_original_field = "089689A1823B6A453A5E5EAF00F479D6", hash_generated_field = "E535EDD135AEF4C6D12D2FCC5626D0B4")

    private boolean mOutsideTouchable = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.946 -0400", hash_original_field = "DD17DE052A15FBA0E48B98F8543A24F6", hash_generated_field = "1F43204AC614FA8E190D827A0B960C07")

    private boolean mClippingEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.946 -0400", hash_original_field = "DED47B632D01506CCBEBA9571D0A6265", hash_generated_field = "6B0DF01241CF4AF0DF57F3BB0179F510")

    private int mSplitTouchEnabled = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.946 -0400", hash_original_field = "157F17B91F343BA4E168B1E33200F7F1", hash_generated_field = "22CD68096C89BB0267ECAB9CEED72BD4")

    private boolean mLayoutInScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.946 -0400", hash_original_field = "6638D062311A6AB39ECF031AC3F7BA51", hash_generated_field = "F7BA441F0E6563EAA35858C9FBEC3C9D")

    private boolean mClipToScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.946 -0400", hash_original_field = "EFBE09421249670269F0C3BDEB412056", hash_generated_field = "E18DD07EB2577F208D13A033471EF4B0")

    private boolean mAllowScrollingAnchorParent = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.946 -0400", hash_original_field = "25095863FE7BF289ADF304DCC9485C0B", hash_generated_field = "4F2A0AC1A5A72DEAB8A91CCC311892CE")

    private boolean mLayoutInsetDecor = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.946 -0400", hash_original_field = "4EA003FF8B599770ADF79B2AB272C6EB", hash_generated_field = "AA45A743419186F82617924E3E71CD81")

    private boolean mNotTouchModal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.947 -0400", hash_original_field = "DBFE8676BB8E60198A4C3A8DE984769D", hash_generated_field = "72A5C0221AA7C77012D45B0D5814CA05")

    private OnTouchListener mTouchInterceptor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.947 -0400", hash_original_field = "FD104D99D022B917A55C66942C8DD087", hash_generated_field = "E1584971BBD05AECB0B7B9F417D8A13C")

    private int mWidthMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.947 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

    private int mWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.947 -0400", hash_original_field = "6F78086ED489C76AF68CD63FF2E0DD48", hash_generated_field = "8A8A535915DEF11E8818FDD746192E2F")

    private int mLastWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.947 -0400", hash_original_field = "2B9BACF3978ACE4CCEF1FEEF4F5D6DD5", hash_generated_field = "942FD12E1BB37FE50F8815646F385BF0")

    private int mHeightMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.947 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

    private int mHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.947 -0400", hash_original_field = "A96810B37246B550B03551EFDB789584", hash_generated_field = "7D971819672E66B14BFF50845F865AA1")

    private int mLastHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.947 -0400", hash_original_field = "D63213AAA0338DCBF8F6B541183B1E87", hash_generated_field = "3FD6DB919B847EDFE0B5956AF8A9BD61")

    private int mPopupWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.947 -0400", hash_original_field = "9B5836C1C09FF1DDB39EFE31D977DC2D", hash_generated_field = "81FC9D55F4BDFA3779C66DE9184556C7")

    private int mPopupHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.947 -0400", hash_original_field = "1A122A41C440AB3A641940A9089395BC", hash_generated_field = "904FF38CA36EA4CCC3C2CCEC4DCDD3BD")

    private int[] mDrawingLocation = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.947 -0400", hash_original_field = "4334E35BB5E4C72AD7D1AB6B3F817ECA", hash_generated_field = "E837BED31FD3509BD57D12D959724198")

    private int[] mScreenLocation = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.947 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "AFFA54D19F07A10EE8847CF76FC95323")

    private Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.947 -0400", hash_original_field = "0FD12110A291B3958F114906D990C478", hash_generated_field = "0925F2C91F8CBA797C183309FA7634C5")

    private Drawable mBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.947 -0400", hash_original_field = "B8B18092E45BA94D853A507ABDA726EF", hash_generated_field = "E17C64A85543ECD9874F1E70F5E7D722")

    private Drawable mAboveAnchorBackgroundDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.947 -0400", hash_original_field = "EC891369E261116A9AB3441B4699A1D9", hash_generated_field = "FF8C2A1514D8DB3BCCA18DE7013BFFDC")

    private Drawable mBelowAnchorBackgroundDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.947 -0400", hash_original_field = "57D2370CEAFD062F8EF7CD0CD808B39B", hash_generated_field = "0D6DFCDD3C93CA68BA06073646439B09")

    private boolean mAboveAnchor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.947 -0400", hash_original_field = "FB63600BBB7707A2C1DBB29516DB9717", hash_generated_field = "9BD03BD39A060D11ED1286EBFF9AC4DB")

    private int mWindowLayoutType = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.948 -0400", hash_original_field = "B6794399ABC229B6F5098657922184B3", hash_generated_field = "91E70DA930AA00EAD499671BBD6F37EB")

    private OnDismissListener mOnDismissListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.948 -0400", hash_original_field = "2C071A5321FE10E45F0AB6D217FF33C9", hash_generated_field = "2356D264A59ECD4DA5DAEA961FD9C071")

    private boolean mIgnoreCheekPress = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.948 -0400", hash_original_field = "4295100925E097D9FFEFBAC590D9839F", hash_generated_field = "2D667A20717B87BB0939831DD6C37380")

    private int mAnimationStyle = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.948 -0400", hash_original_field = "8A2549E4A331F412E0868B04A8E3C179", hash_generated_field = "841D2F2B9FEBE43FD9F75F29253325CB")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.948 -0400", hash_original_method = "A7D29AF9F459F2E9972F382B06EBA7BC", hash_generated_method = "9C07D03A56300782A8BC762C1E6C14C9")
    public  PopupWindow(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.948 -0400", hash_original_method = "366007D96D9B418EA2EA6640B7FB7C46", hash_generated_method = "E35333C631D87C6A38753FFCDEB9B1E9")
    public  PopupWindow(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.popupWindowStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.949 -0400", hash_original_method = "FAD82A2A4F32A008B236FC8E4F83669F", hash_generated_method = "FF6B64FFD18A670B3310A93EEEE0AA51")
    public  PopupWindow(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, 0);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.951 -0400", hash_original_method = "079F601C7A8694616AB9480B0999FF46", hash_generated_method = "C5EA66CC9670B271CBD1DC65BAA8FD5D")
    public  PopupWindow(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        addTaint(defStyleRes);
        addTaint(defStyleAttr);
        addTaint(attrs.getTaint());
        mContext = context;
        mWindowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        TypedArray a = context.obtainStyledAttributes(
                attrs, com.android.internal.R.styleable.PopupWindow, defStyleAttr, defStyleRes);
        mBackground = a.getDrawable(R.styleable.PopupWindow_popupBackground);
        final int animStyle = a.getResourceId(R.styleable.PopupWindow_popupAnimationStyle, -1);
        mAnimationStyle = animStyle == com.android.internal.R.style.Animation_PopupWindow ? -1 :
                animStyle;
        if(mBackground instanceof StateListDrawable)        
        {
            StateListDrawable background = (StateListDrawable) mBackground;
            int aboveAnchorStateIndex = background.getStateDrawableIndex(ABOVE_ANCHOR_STATE_SET);
            int count = background.getStateCount();
            int belowAnchorStateIndex = -1;
for(int i = 0;i < count;i++)
            {
                if(i != aboveAnchorStateIndex)                
                {
                    belowAnchorStateIndex = i;
                    break;
                } //End block
            } //End block
            if(aboveAnchorStateIndex != -1 && belowAnchorStateIndex != -1)            
            {
                mAboveAnchorBackgroundDrawable = background.getStateDrawable(aboveAnchorStateIndex);
                mBelowAnchorBackgroundDrawable = background.getStateDrawable(belowAnchorStateIndex);
            } //End block
            else
            {
                mBelowAnchorBackgroundDrawable = null;
                mAboveAnchorBackgroundDrawable = null;
            } //End block
        } //End block
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.952 -0400", hash_original_method = "E34384426EB8697F688915D9E72B588C", hash_generated_method = "596F84E29B0A712DA0AAE3A0BA66CFD5")
    public  PopupWindow() {
        this(null, 0, 0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.952 -0400", hash_original_method = "57135C41538C9CD08914B3D745201B31", hash_generated_method = "5D0A2F7305AB92DB61AD479A88482F82")
    public  PopupWindow(View contentView) {
        this(contentView, 0, 0);
        addTaint(contentView.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.952 -0400", hash_original_method = "52D8423742F4089F7506898A8921688C", hash_generated_method = "33712F8F8E5675686C2BD404FF154479")
    public  PopupWindow(int width, int height) {
        this(null, width, height);
        addTaint(height);
        addTaint(width);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.952 -0400", hash_original_method = "824FA1289D7F0041B91552EC537ECD03", hash_generated_method = "5D6D8F1214243EBCEE44933BAB2E6FAC")
    public  PopupWindow(View contentView, int width, int height) {
        this(contentView, width, height, false);
        addTaint(height);
        addTaint(width);
        addTaint(contentView.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.953 -0400", hash_original_method = "45A20F34B738086A724C95615CA38820", hash_generated_method = "5BAAC70F309DF4153CDBCBBE132C1522")
    public  PopupWindow(View contentView, int width, int height, boolean focusable) {
        addTaint(focusable);
        addTaint(height);
        addTaint(width);
        if(contentView != null)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.953 -0400", hash_original_method = "63340AE07D2726BC056EFE5BE3E2FF29", hash_generated_method = "2F7EAC0C485C887C95E063209B40DACD")
    public Drawable getBackground() {
Drawable var6BC48FB27278703ABB1DA72DCD54880A_1823922356 =         mBackground;
        var6BC48FB27278703ABB1DA72DCD54880A_1823922356.addTaint(taint);
        return var6BC48FB27278703ABB1DA72DCD54880A_1823922356;
        // ---------- Original Method ----------
        //return mBackground;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.954 -0400", hash_original_method = "96D2484B6380046D33AB8470E20080B0", hash_generated_method = "D16C3A30D1BEDA85C77BADB55334CCBB")
    public void setBackgroundDrawable(Drawable background) {
        mBackground = background;
        // ---------- Original Method ----------
        //mBackground = background;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.954 -0400", hash_original_method = "41CA7DA63F7D92402D2B673FD03355D6", hash_generated_method = "B530F1F81BE39222968F7CCA0C3C72EA")
    public int getAnimationStyle() {
        int var5B21DAE09A73FD3DD3A01C863D97EF15_538318575 = (mAnimationStyle);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1070801512 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1070801512;
        // ---------- Original Method ----------
        //return mAnimationStyle;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.954 -0400", hash_original_method = "A2D9F7F5158A57BAC36D16E33D2F221F", hash_generated_method = "BCC06A2E85690E757FF10740FDE4D8C7")
    public void setIgnoreCheekPress() {
        mIgnoreCheekPress = true;
        // ---------- Original Method ----------
        //mIgnoreCheekPress = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.954 -0400", hash_original_method = "46489C40917944BA93E8F6D8658EE802", hash_generated_method = "30E663249BFF81A95B0EE39AF735EB89")
    public void setAnimationStyle(int animationStyle) {
        mAnimationStyle = animationStyle;
        // ---------- Original Method ----------
        //mAnimationStyle = animationStyle;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.955 -0400", hash_original_method = "1FBDC8A7B1B2CCF1CAFCE9F94E1B072D", hash_generated_method = "3738133A4AEF235F6D61BAB6D48D91ED")
    public View getContentView() {
View var11075ABCE34FC88A4EDC97AAF35631A1_429390533 =         mContentView;
        var11075ABCE34FC88A4EDC97AAF35631A1_429390533.addTaint(taint);
        return var11075ABCE34FC88A4EDC97AAF35631A1_429390533;
        // ---------- Original Method ----------
        //return mContentView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.955 -0400", hash_original_method = "647C3E968C5C98ECF0A359511A938D87", hash_generated_method = "779A75E06402B317A9975AC7213995AC")
    public void setContentView(View contentView) {
        if(isShowing())        
        {
            return;
        } //End block
        mContentView = contentView;
        if(mContext == null && mContentView != null)        
        {
            mContext = mContentView.getContext();
        } //End block
        if(mWindowManager == null && mContentView != null)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.956 -0400", hash_original_method = "DE25D00870282EA3EAE9EBB02519A2CA", hash_generated_method = "130FE76FE298B90583B66B9C1E8E1782")
    public void setTouchInterceptor(OnTouchListener l) {
        mTouchInterceptor = l;
        // ---------- Original Method ----------
        //mTouchInterceptor = l;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.956 -0400", hash_original_method = "40BB85E3EB9B026A95FA1376FB5C6D2D", hash_generated_method = "8A19287D4AF815B3D2339960234082D7")
    public boolean isFocusable() {
        boolean var07D4AD4D81CD2ED098EE3F04028AD5C2_322225183 = (mFocusable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_560912523 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_560912523;
        // ---------- Original Method ----------
        //return mFocusable;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.956 -0400", hash_original_method = "ABAB7A7DE4A915B0505D233953D72C47", hash_generated_method = "73B30D7B6EF00BF878189A326F3284C3")
    public void setFocusable(boolean focusable) {
        mFocusable = focusable;
        // ---------- Original Method ----------
        //mFocusable = focusable;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.956 -0400", hash_original_method = "01F2BFCF39394BA4008813FFB1127C10", hash_generated_method = "DF85E85C2B1FD0A7305C499C9207561B")
    public int getInputMethodMode() {
        int var467FEA47D39C5390ED034598E023EE40_19690626 = (mInputMethodMode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1113802020 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1113802020;
        // ---------- Original Method ----------
        //return mInputMethodMode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.957 -0400", hash_original_method = "960CEBA1FA646F0DDCC5CA21C9FFA47A", hash_generated_method = "A6E33B617E3054749700BA5054FB5936")
    public void setInputMethodMode(int mode) {
        mInputMethodMode = mode;
        // ---------- Original Method ----------
        //mInputMethodMode = mode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.957 -0400", hash_original_method = "4B11C5E74D17332CC7C67B3F22EF8E33", hash_generated_method = "1D7C1083F51FF0DA3819F794F94DE227")
    public void setSoftInputMode(int mode) {
        mSoftInputMode = mode;
        // ---------- Original Method ----------
        //mSoftInputMode = mode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.957 -0400", hash_original_method = "76888AB414E08DF2E7D12678F406D7A5", hash_generated_method = "E979F1F1B6ECD1C6F3EB672C31309E16")
    public int getSoftInputMode() {
        int var33E2F9EB615FA3DC117548E2AB4E3CB8_1404536174 = (mSoftInputMode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1375710996 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1375710996;
        // ---------- Original Method ----------
        //return mSoftInputMode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.957 -0400", hash_original_method = "AE839D196CDFD95E127ACD4470F67375", hash_generated_method = "3E6682F6976724DF41E268F53994C616")
    public boolean isTouchable() {
        boolean var92DDD08A6D5A6FA86A0DD1484A3DE8DD_817728706 = (mTouchable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1803342343 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1803342343;
        // ---------- Original Method ----------
        //return mTouchable;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.958 -0400", hash_original_method = "BEB1F63A70D555DEE12C0C7D4BDF7831", hash_generated_method = "53CC1C5C2E5530440B2CCE60DCC9D428")
    public void setTouchable(boolean touchable) {
        mTouchable = touchable;
        // ---------- Original Method ----------
        //mTouchable = touchable;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.958 -0400", hash_original_method = "FF3CAF88B8F1C23DC4869C5AECE8973C", hash_generated_method = "8E480559AF2F1ED5CC69727A027B3B8A")
    public boolean isOutsideTouchable() {
        boolean varA9951889E8F0605A19314805297E8617_565843135 = (mOutsideTouchable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1561140996 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1561140996;
        // ---------- Original Method ----------
        //return mOutsideTouchable;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.958 -0400", hash_original_method = "8E0154BCB2D650E765619E048D3C66EA", hash_generated_method = "FE2AEFBB8C4EEBABE5D6E1A098A60CB0")
    public void setOutsideTouchable(boolean touchable) {
        mOutsideTouchable = touchable;
        // ---------- Original Method ----------
        //mOutsideTouchable = touchable;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.958 -0400", hash_original_method = "5D90AAFBBA18C52B8D43E4274612DFE0", hash_generated_method = "219ED90475D448061661E711FF63D47D")
    public boolean isClippingEnabled() {
        boolean varB4A4E16DDC69F62D160D87797D00FD16_573455210 = (mClippingEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_860574659 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_860574659;
        // ---------- Original Method ----------
        //return mClippingEnabled;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.958 -0400", hash_original_method = "C644B67739A8A92EE97D978CC897DC79", hash_generated_method = "684E85C82CBEB4AB4A8C43DA093096AD")
    public void setClippingEnabled(boolean enabled) {
        mClippingEnabled = enabled;
        // ---------- Original Method ----------
        //mClippingEnabled = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.958 -0400", hash_original_method = "86AECB53D9496C7054030FB1672ECE9B", hash_generated_method = "235F8CA48AA18F6B969B7FF20C467B2E")
    public void setClipToScreenEnabled(boolean enabled) {
        mClipToScreen = enabled;
        setClippingEnabled(!enabled);
        // ---------- Original Method ----------
        //mClipToScreen = enabled;
        //setClippingEnabled(!enabled);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.958 -0400", hash_original_method = "AB712E1EFFE4EAE7A80987CD7E1E8D4B", hash_generated_method = "FE43850C7268C6EE8DB37340BB239900")
     void setAllowScrollingAnchorParent(boolean enabled) {
        mAllowScrollingAnchorParent = enabled;
        // ---------- Original Method ----------
        //mAllowScrollingAnchorParent = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.958 -0400", hash_original_method = "CD003A57AD290217AC32D20DAA9F9760", hash_generated_method = "D9C8E0E9279E85C1FB536746C372D3D3")
    public boolean isSplitTouchEnabled() {
        if(mSplitTouchEnabled < 0 && mContext != null)        
        {
            boolean varF828BFCC9D129C357145734EB33F318B_695790962 = (mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1150036154 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1150036154;
        } //End block
        boolean var4836509A66FBEB0F534E659035B1FEF6_1573966612 = (mSplitTouchEnabled == 1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1273557479 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1273557479;
        // ---------- Original Method ----------
        //if (mSplitTouchEnabled < 0 && mContext != null) {
            //return mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB;
        //}
        //return mSplitTouchEnabled == 1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.959 -0400", hash_original_method = "8E279F2F2689369B00326EC855CADBF3", hash_generated_method = "16FCD3DA62C4843F4FE76768308439EA")
    public void setSplitTouchEnabled(boolean enabled) {
        mSplitTouchEnabled = enabled ? 1 : 0;
        // ---------- Original Method ----------
        //mSplitTouchEnabled = enabled ? 1 : 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.959 -0400", hash_original_method = "10EB43954998F08298066292E6DC8079", hash_generated_method = "4EE30F23CA264C78F432D1C7C0FA266C")
    public boolean isLayoutInScreenEnabled() {
        boolean var157F17B91F343BA4E168B1E33200F7F1_1052546070 = (mLayoutInScreen);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_161062214 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_161062214;
        // ---------- Original Method ----------
        //return mLayoutInScreen;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.959 -0400", hash_original_method = "181FE02772B59DB435AF1D6C410875BB", hash_generated_method = "223E785F0B8E3AC353A80B21D7B051A2")
    public void setLayoutInScreenEnabled(boolean enabled) {
        mLayoutInScreen = enabled;
        // ---------- Original Method ----------
        //mLayoutInScreen = enabled;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.959 -0400", hash_original_method = "FEA07B591038B9982257E6B6F9EA89DD", hash_generated_method = "B17F3787A243E7C34D946849ECA3B77D")
    public void setLayoutInsetDecor(boolean enabled) {
        mLayoutInsetDecor = enabled;
        // ---------- Original Method ----------
        //mLayoutInsetDecor = enabled;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.959 -0400", hash_original_method = "7DF3C488F6920E6663FDD36E5737A8E3", hash_generated_method = "86D8C382E8DE29516140D730E3EA62C0")
    public void setWindowLayoutType(int layoutType) {
        mWindowLayoutType = layoutType;
        // ---------- Original Method ----------
        //mWindowLayoutType = layoutType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.959 -0400", hash_original_method = "B0A202A53A476A9F6F2E7DEE1AC7BFD5", hash_generated_method = "2850CAECF02BDAC9DBDE4E5470605FF5")
    public int getWindowLayoutType() {
        int varD7C43EBB36E110258909C535D04189C9_809687727 = (mWindowLayoutType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_224660577 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_224660577;
        // ---------- Original Method ----------
        //return mWindowLayoutType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.959 -0400", hash_original_method = "B8930E34962345C50EA9D19D5D77CFE8", hash_generated_method = "19AEA7D6541C507D6EB32AC9EE42DBE9")
    public void setTouchModal(boolean touchModal) {
        mNotTouchModal = !touchModal;
        // ---------- Original Method ----------
        //mNotTouchModal = !touchModal;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.959 -0400", hash_original_method = "756D1E68507199C9976BFEB56A60134A", hash_generated_method = "386434F8D6065CAF3B8B583908DED42B")
    public void setWindowLayoutMode(int widthSpec, int heightSpec) {
        mWidthMode = widthSpec;
        mHeightMode = heightSpec;
        // ---------- Original Method ----------
        //mWidthMode = widthSpec;
        //mHeightMode = heightSpec;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.959 -0400", hash_original_method = "0304EDCF78FF45B68A7EB91BFEAAA2CD", hash_generated_method = "FB7F2DC6832CEAD5AFB24ED275469603")
    public int getHeight() {
        int var483542B05A951AA16D89C7F809C20811_1286789485 = (mHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1162964100 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1162964100;
        // ---------- Original Method ----------
        //return mHeight;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.959 -0400", hash_original_method = "BA89F279BB207625BAE694FF1E8671B8", hash_generated_method = "5421EB99FBB05FB66E8A75CFDF238048")
    public void setHeight(int height) {
        mHeight = height;
        // ---------- Original Method ----------
        //mHeight = height;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.961 -0400", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "E7845DA2D27681B6F7A8B2E0011C2552")
    public int getWidth() {
        int varA3DB1626A190732E588FD0D14FC8FB31_774771204 = (mWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1323660282 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1323660282;
        // ---------- Original Method ----------
        //return mWidth;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.961 -0400", hash_original_method = "684C7FEA8A4B53DA843B69F25AEC8ECA", hash_generated_method = "708EDDEF80D7966FCCE04921295DE407")
    public void setWidth(int width) {
        mWidth = width;
        // ---------- Original Method ----------
        //mWidth = width;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.961 -0400", hash_original_method = "2222AA4AEDF5C752B222A7F4E8915559", hash_generated_method = "177DAD57C285767ED0519F46FE0BAB86")
    public boolean isShowing() {
        boolean var4100ADFCD62B8FAC1A156667D9A8612E_1605552478 = (mIsShowing);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_326877077 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_326877077;
        // ---------- Original Method ----------
        //return mIsShowing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.961 -0400", hash_original_method = "7355F7E30A53327DA70C15AA0141C8AD", hash_generated_method = "926A96034B801741A47BCD5177240B8F")
    public void showAtLocation(View parent, int gravity, int x, int y) {
        addTaint(y);
        addTaint(x);
        addTaint(gravity);
        addTaint(parent.getTaint());
        showAtLocation(parent.getWindowToken(), gravity, x, y);
        // ---------- Original Method ----------
        //showAtLocation(parent.getWindowToken(), gravity, x, y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.961 -0400", hash_original_method = "B99D3AF8D05FDFEAE8059FF95B29B82E", hash_generated_method = "2064F738DADB98055539D689675E4F6D")
    public void showAtLocation(IBinder token, int gravity, int x, int y) {
        addTaint(y);
        addTaint(x);
        addTaint(gravity);
        addTaint(token.getTaint());
        if(isShowing() || mContentView == null)        
        {
            return;
        } //End block
        unregisterForScrollChanged();
        mIsShowing = true;
        mIsDropdown = false;
        WindowManager.LayoutParams p = createPopupLayout(token);
        p.windowAnimations = computeAnimationResource();
        preparePopup(p);
        if(gravity == Gravity.NO_GRAVITY)        
        {
            gravity = Gravity.TOP | Gravity.LEFT;
        } //End block
        p.gravity = gravity;
        p.x = x;
        p.y = y;
        if(mHeightMode < 0)        
        p.height = mLastHeight = mHeightMode;
        if(mWidthMode < 0)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.962 -0400", hash_original_method = "C9F3BB2940AB236715592F07C984C554", hash_generated_method = "1C4F47AD37481FD1E672BDB9165BEB86")
    public void showAsDropDown(View anchor) {
        addTaint(anchor.getTaint());
        showAsDropDown(anchor, 0, 0);
        // ---------- Original Method ----------
        //showAsDropDown(anchor, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.962 -0400", hash_original_method = "624B6ED3EB88D2A91AFF60DB37AE2E29", hash_generated_method = "FEF3A80B1B7834CF5341F105C5439391")
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        addTaint(yoff);
        addTaint(xoff);
        addTaint(anchor.getTaint());
        if(isShowing() || mContentView == null)        
        {
            return;
        } //End block
        registerForScrollChanged(anchor, xoff, yoff);
        mIsShowing = true;
        mIsDropdown = true;
        WindowManager.LayoutParams p = createPopupLayout(anchor.getWindowToken());
        preparePopup(p);
        updateAboveAnchor(findDropDownPosition(anchor, p, xoff, yoff));
        if(mHeightMode < 0)        
        p.height = mLastHeight = mHeightMode;
        if(mWidthMode < 0)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.962 -0400", hash_original_method = "ACCF8C7A05331E8E4B71A7F0F84ED581", hash_generated_method = "CAA5036FDDA279823E0427DD3CD26139")
    private void updateAboveAnchor(boolean aboveAnchor) {
        if(aboveAnchor != mAboveAnchor)        
        {
            mAboveAnchor = aboveAnchor;
            if(mBackground != null)            
            {
                if(mAboveAnchorBackgroundDrawable != null)                
                {
                    if(mAboveAnchor)                    
                    {
                        mPopupView.setBackgroundDrawable(mAboveAnchorBackgroundDrawable);
                    } //End block
                    else
                    {
                        mPopupView.setBackgroundDrawable(mBelowAnchorBackgroundDrawable);
                    } //End block
                } //End block
                else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.962 -0400", hash_original_method = "3CCA39FA6959E2A6CCCA2648E4E5EA51", hash_generated_method = "9734BF38C12A98AAE6CFE848BAD2D9BD")
    public boolean isAboveAnchor() {
        boolean var57D2370CEAFD062F8EF7CD0CD808B39B_550821176 = (mAboveAnchor);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_828143947 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_828143947;
        // ---------- Original Method ----------
        //return mAboveAnchor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.962 -0400", hash_original_method = "DA370B626B41FE86866E281D10A5B6B7", hash_generated_method = "80D9F62914B43AE659101D517B30575D")
    private void preparePopup(WindowManager.LayoutParams p) {
        if(mContentView == null || mContext == null || mWindowManager == null)        
        {
            IllegalStateException var97B3A8DF176511D046661F5EFD4F2713_1000681723 = new IllegalStateException("You must specify a valid content view by "
                    + "calling setContentView() before attempting to show the popup.");
            var97B3A8DF176511D046661F5EFD4F2713_1000681723.addTaint(taint);
            throw var97B3A8DF176511D046661F5EFD4F2713_1000681723;
        } //End block
        if(mBackground != null)        
        {
            final ViewGroup.LayoutParams layoutParams = mContentView.getLayoutParams();
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            if(layoutParams != null &&
                    layoutParams.height == ViewGroup.LayoutParams.WRAP_CONTENT)            
            {
                height = ViewGroup.LayoutParams.WRAP_CONTENT;
            } //End block
            PopupViewContainer popupViewContainer = new PopupViewContainer(mContext);
            PopupViewContainer.LayoutParams listParams = new PopupViewContainer.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, height
            );
            popupViewContainer.setBackgroundDrawable(mBackground);
            popupViewContainer.addView(mContentView, listParams);
            mPopupView = popupViewContainer;
        } //End block
        else
        {
            mPopupView = mContentView;
        } //End block
        mPopupWidth = p.width;
        mPopupHeight = p.height;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.963 -0400", hash_original_method = "CC3762287DEDA3D715BCCB052800207D", hash_generated_method = "CBBF314CC288E7D7A9D0C8281FC03F65")
    private void invokePopup(WindowManager.LayoutParams p) {
        addTaint(p.getTaint());
        if(mContext != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.963 -0400", hash_original_method = "D97E1B6317AF67D9DC41A6FB19D27D69", hash_generated_method = "E683C62CC2BA4262EB8CB40E5F245F0B")
    private WindowManager.LayoutParams createPopupLayout(IBinder token) {
        addTaint(token.getTaint());
        WindowManager.LayoutParams p = new WindowManager.LayoutParams();
        p.gravity = Gravity.LEFT | Gravity.TOP;
        p.width = mLastWidth = mWidth;
        p.height = mLastHeight = mHeight;
        if(mBackground != null)        
        {
            p.format = mBackground.getOpacity();
        } //End block
        else
        {
            p.format = PixelFormat.TRANSLUCENT;
        } //End block
        p.flags = computeFlags(p.flags);
        p.type = mWindowLayoutType;
        p.token = token;
        p.softInputMode = mSoftInputMode;
        p.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
WindowManager.LayoutParams var74E4690D9F2A026504928C017944E149_1910176166 =         p;
        var74E4690D9F2A026504928C017944E149_1910176166.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_1910176166;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.964 -0400", hash_original_method = "731A130870E20EEF0406E3AA79CC1D53", hash_generated_method = "3CA7A835F7BCF6C7D660291992926DE5")
    private int computeFlags(int curFlags) {
        addTaint(curFlags);
        curFlags &= ~(
                WindowManager.LayoutParams.FLAG_IGNORE_CHEEK_PRESSES |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE |
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH |
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS |
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM |
                WindowManager.LayoutParams.FLAG_SPLIT_TOUCH);
        if(mIgnoreCheekPress)        
        {
            curFlags |= WindowManager.LayoutParams.FLAG_IGNORE_CHEEK_PRESSES;
        } //End block
        if(!mFocusable)        
        {
            curFlags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
            if(mInputMethodMode == INPUT_METHOD_NEEDED)            
            {
                curFlags |= WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
            } //End block
        } //End block
        else
        if(mInputMethodMode == INPUT_METHOD_NOT_NEEDED)        
        {
            curFlags |= WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
        } //End block
        if(!mTouchable)        
        {
            curFlags |= WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        } //End block
        if(mOutsideTouchable)        
        {
            curFlags |= WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
        } //End block
        if(!mClippingEnabled)        
        {
            curFlags |= WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
        } //End block
        if(isSplitTouchEnabled())        
        {
            curFlags |= WindowManager.LayoutParams.FLAG_SPLIT_TOUCH;
        } //End block
        if(mLayoutInScreen)        
        {
            curFlags |= WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
        } //End block
        if(mLayoutInsetDecor)        
        {
            curFlags |= WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR;
        } //End block
        if(mNotTouchModal)        
        {
            curFlags |= WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        } //End block
        int var8B10F02955E772F9A0E96B813B72DC6F_1109260825 = (curFlags);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_900942057 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_900942057;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.964 -0400", hash_original_method = "2B29575EF3002A68968C6947831DCCDB", hash_generated_method = "D5AB907C7DA7675B8C0B8827E5DFEDED")
    private int computeAnimationResource() {
        if(mAnimationStyle == -1)        
        {
            if(mIsDropdown)            
            {
                int var6A7961C2AEB5F8A38D9E003365380FA4_1147041069 = (mAboveAnchor
                        ? com.android.internal.R.style.Animation_DropDownUp
                        : com.android.internal.R.style.Animation_DropDownDown);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792860516 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792860516;
            } //End block
            int varCFCD208495D565EF66E7DFF9F98764DA_10021871 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_673039535 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_673039535;
        } //End block
        int var5B21DAE09A73FD3DD3A01C863D97EF15_1152834409 = (mAnimationStyle);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_297360276 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_297360276;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.965 -0400", hash_original_method = "5A11C37B27567E510AD1092CF1C461D0", hash_generated_method = "6B51A85D0CCDB490A89005163B9C95D5")
    private boolean findDropDownPosition(View anchor, WindowManager.LayoutParams p,
            int xoff, int yoff) {
        addTaint(yoff);
        addTaint(xoff);
        addTaint(p.getTaint());
        addTaint(anchor.getTaint());
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
        if(screenY + mPopupHeight > displayFrame.bottom ||
                p.x + mPopupWidth - root.getWidth() > 0)        
        {
            if(mAllowScrollingAnchorParent)            
            {
                int scrollX = anchor.getScrollX();
                int scrollY = anchor.getScrollY();
                Rect r = new Rect(scrollX, scrollY,  scrollX + mPopupWidth + xoff,
                        scrollY + mPopupHeight + anchor.getHeight() + yoff);
                anchor.requestRectangleOnScreen(r, true);
            } //End block
            anchor.getLocationInWindow(mDrawingLocation);
            p.x = mDrawingLocation[0] + xoff;
            p.y = mDrawingLocation[1] + anchor.getHeight() + yoff;
            anchor.getLocationOnScreen(mScreenLocation);
            onTop = (displayFrame.bottom - mScreenLocation[1] - anchor.getHeight() - yoff) <
                    (mScreenLocation[1] - yoff - displayFrame.top);
            if(onTop)            
            {
                p.gravity = Gravity.LEFT | Gravity.BOTTOM;
                p.y = root.getHeight() - mDrawingLocation[1] + yoff;
            } //End block
            else
            {
                p.y = mDrawingLocation[1] + anchor.getHeight() + yoff;
            } //End block
        } //End block
        if(mClipToScreen)        
        {
            final int displayFrameWidth = displayFrame.right - displayFrame.left;
            int right = p.x + p.width;
            if(right > displayFrameWidth)            
            {
                p.x -= right - displayFrameWidth;
            } //End block
            if(p.x < displayFrame.left)            
            {
                p.x = displayFrame.left;
                p.width = Math.min(p.width, displayFrameWidth);
            } //End block
            if(onTop)            
            {
                int popupTop = mScreenLocation[1] + yoff - mPopupHeight;
                if(popupTop < 0)                
                {
                    p.y += popupTop;
                } //End block
            } //End block
            else
            {
                p.y = Math.max(p.y, displayFrame.top);
            } //End block
        } //End block
        p.gravity |= Gravity.DISPLAY_CLIP_VERTICAL;
        boolean var4B481EAE34231243BF6A90822A6744DC_1207177658 = (onTop);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1021083814 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1021083814;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.965 -0400", hash_original_method = "023150F59911D5483F51543A59288631", hash_generated_method = "4C97418B83D17EF0609D9BF12E8C761D")
    public int getMaxAvailableHeight(View anchor) {
        addTaint(anchor.getTaint());
        int varE0A8E79AFD196727A42F51C906E6F3EA_417341196 = (getMaxAvailableHeight(anchor, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1838322829 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1838322829;
        // ---------- Original Method ----------
        //return getMaxAvailableHeight(anchor, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.966 -0400", hash_original_method = "782C0234D711C16ED6DF402CCEC14809", hash_generated_method = "2F4701AA4416C71BD634DC9644818B3B")
    public int getMaxAvailableHeight(View anchor, int yOffset) {
        addTaint(yOffset);
        addTaint(anchor.getTaint());
        int var18323BD0C7111F8934A12DFB383F142B_1524840295 = (getMaxAvailableHeight(anchor, yOffset, false));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_923491500 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_923491500;
        // ---------- Original Method ----------
        //return getMaxAvailableHeight(anchor, yOffset, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.966 -0400", hash_original_method = "6127242297D2005B4B3434B0EF072B4C", hash_generated_method = "69C44E8B4530A85A58689C8EB424391C")
    public int getMaxAvailableHeight(View anchor, int yOffset, boolean ignoreBottomDecorations) {
        addTaint(ignoreBottomDecorations);
        addTaint(yOffset);
        addTaint(anchor.getTaint());
        final Rect displayFrame = new Rect();
        anchor.getWindowVisibleDisplayFrame(displayFrame);
        final int[] anchorPos = mDrawingLocation;
        anchor.getLocationOnScreen(anchorPos);
        int bottomEdge = displayFrame.bottom;
        if(ignoreBottomDecorations)        
        {
            Resources res = anchor.getContext().getResources();
            bottomEdge = res.getDisplayMetrics().heightPixels;
        } //End block
        final int distanceToBottom = bottomEdge - (anchorPos[1] + anchor.getHeight()) - yOffset;
        final int distanceToTop = anchorPos[1] - displayFrame.top + yOffset;
        int returnedHeight = Math.max(distanceToBottom, distanceToTop);
        if(mBackground != null)        
        {
            mBackground.getPadding(mTempRect);
            returnedHeight -= mTempRect.top + mTempRect.bottom;
        } //End block
        int var78DD425B2CF1217B45AA8B8C89F126CC_1478467914 = (returnedHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1380623537 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1380623537;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.966 -0400", hash_original_method = "206A53D80E1660978DCF21A355028E66", hash_generated_method = "8B460CAE59A790E8562003AF8874D162")
    public void dismiss() {
        if(isShowing() && mPopupView != null)        
        {
            mIsShowing = false;
            unregisterForScrollChanged();
            try 
            {
                mWindowManager.removeView(mPopupView);
            } //End block
            finally 
            {
                if(mPopupView != mContentView && mPopupView instanceof ViewGroup)                
                {
                    ((ViewGroup) mPopupView).removeView(mContentView);
                } //End block
                mPopupView = null;
                if(mOnDismissListener != null)                
                {
                    mOnDismissListener.onDismiss();
                } //End block
            } //End block
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.966 -0400", hash_original_method = "93E9EBCE36575249CB74D4FBEF26A1CF", hash_generated_method = "8A15ECA68636163A82E11179DEBF050D")
    public void setOnDismissListener(OnDismissListener onDismissListener) {
        mOnDismissListener = onDismissListener;
        // ---------- Original Method ----------
        //mOnDismissListener = onDismissListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.967 -0400", hash_original_method = "488D5DDCA6B0F8C983ED8CA34502865A", hash_generated_method = "A1F6251E1F84E9F52C38ABAD8DB211B1")
    public void update() {
        if(!isShowing() || mContentView == null)        
        {
            return;
        } //End block
        WindowManager.LayoutParams p = (WindowManager.LayoutParams)
                mPopupView.getLayoutParams();
        boolean update = false;
        final int newAnim = computeAnimationResource();
        if(newAnim != p.windowAnimations)        
        {
            p.windowAnimations = newAnim;
            update = true;
        } //End block
        final int newFlags = computeFlags(p.flags);
        if(newFlags != p.flags)        
        {
            p.flags = newFlags;
            update = true;
        } //End block
        if(update)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.967 -0400", hash_original_method = "99E415F6DCFBC1202511EEF5D071A55C", hash_generated_method = "DD13E1FDF62A68C37D99E25636B9D854")
    public void update(int width, int height) {
        addTaint(height);
        addTaint(width);
        WindowManager.LayoutParams p = (WindowManager.LayoutParams)
                mPopupView.getLayoutParams();
        update(p.x, p.y, width, height, false);
        // ---------- Original Method ----------
        //WindowManager.LayoutParams p = (WindowManager.LayoutParams)
                //mPopupView.getLayoutParams();
        //update(p.x, p.y, width, height, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.967 -0400", hash_original_method = "848B641343A16858C863B802CDF64CDF", hash_generated_method = "CE9CCD0011F63655E0982A62733B6BB9")
    public void update(int x, int y, int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        update(x, y, width, height, false);
        // ---------- Original Method ----------
        //update(x, y, width, height, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.968 -0400", hash_original_method = "7F49F99468193710A8807FDE38269850", hash_generated_method = "46B5B608F111E2B824FC8DDBB5123E79")
    public void update(int x, int y, int width, int height, boolean force) {
        addTaint(force);
        addTaint(y);
        addTaint(x);
        if(width != -1)        
        {
            mLastWidth = width;
            setWidth(width);
        } //End block
        if(height != -1)        
        {
            mLastHeight = height;
            setHeight(height);
        } //End block
        if(!isShowing() || mContentView == null)        
        {
            return;
        } //End block
        WindowManager.LayoutParams p = (WindowManager.LayoutParams) mPopupView.getLayoutParams();
        boolean update = force;
        final int finalWidth = mWidthMode < 0 ? mWidthMode : mLastWidth;
        if(width != -1 && p.width != finalWidth)        
        {
            p.width = mLastWidth = finalWidth;
            update = true;
        } //End block
        final int finalHeight = mHeightMode < 0 ? mHeightMode : mLastHeight;
        if(height != -1 && p.height != finalHeight)        
        {
            p.height = mLastHeight = finalHeight;
            update = true;
        } //End block
        if(p.x != x)        
        {
            p.x = x;
            update = true;
        } //End block
        if(p.y != y)        
        {
            p.y = y;
            update = true;
        } //End block
        final int newAnim = computeAnimationResource();
        if(newAnim != p.windowAnimations)        
        {
            p.windowAnimations = newAnim;
            update = true;
        } //End block
        final int newFlags = computeFlags(p.flags);
        if(newFlags != p.flags)        
        {
            p.flags = newFlags;
            update = true;
        } //End block
        if(update)        
        {
            mWindowManager.updateViewLayout(mPopupView, p);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.968 -0400", hash_original_method = "2E7624B1CB6DF9766B6E25C708FAA465", hash_generated_method = "3065CDDDC37BCE6C587AA8582F9E8715")
    public void update(View anchor, int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(anchor.getTaint());
        update(anchor, false, 0, 0, true, width, height);
        // ---------- Original Method ----------
        //update(anchor, false, 0, 0, true, width, height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.968 -0400", hash_original_method = "B8D2EE4CAAF22B5FC8CA5A06E5BF0669", hash_generated_method = "8EC4C3513B7F6D8F2952D0174082E2C9")
    public void update(View anchor, int xoff, int yoff, int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(yoff);
        addTaint(xoff);
        addTaint(anchor.getTaint());
        update(anchor, true, xoff, yoff, true, width, height);
        // ---------- Original Method ----------
        //update(anchor, true, xoff, yoff, true, width, height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.969 -0400", hash_original_method = "F5290879A773899EB945D797134BA900", hash_generated_method = "2FB71EBE90CCE13AF11BE8FF18C9359A")
    private void update(View anchor, boolean updateLocation, int xoff, int yoff,
            boolean updateDimension, int width, int height) {
        addTaint(updateDimension);
        addTaint(updateLocation);
        addTaint(anchor.getTaint());
        if(!isShowing() || mContentView == null)        
        {
            return;
        } //End block
        WeakReference<View> oldAnchor = mAnchor;
        final boolean needsUpdate = updateLocation && (mAnchorXoff != xoff || mAnchorYoff != yoff);
        if(oldAnchor == null || oldAnchor.get() != anchor || (needsUpdate && !mIsDropdown))        
        {
            registerForScrollChanged(anchor, xoff, yoff);
        } //End block
        else
        if(needsUpdate)        
        {
            mAnchorXoff = xoff;
            mAnchorYoff = yoff;
        } //End block
        WindowManager.LayoutParams p = (WindowManager.LayoutParams) mPopupView.getLayoutParams();
        if(updateDimension)        
        {
            if(width == -1)            
            {
                width = mPopupWidth;
            } //End block
            else
            {
                mPopupWidth = width;
            } //End block
            if(height == -1)            
            {
                height = mPopupHeight;
            } //End block
            else
            {
                mPopupHeight = height;
            } //End block
        } //End block
        int x = p.x;
        int y = p.y;
        if(updateLocation)        
        {
            updateAboveAnchor(findDropDownPosition(anchor, p, xoff, yoff));
        } //End block
        else
        {
            updateAboveAnchor(findDropDownPosition(anchor, p, mAnchorXoff, mAnchorYoff));
        } //End block
        update(p.x, p.y, width, height, x != p.x || y != p.y);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.969 -0400", hash_original_method = "032144363E44618DF1C4EE95BC82AD16", hash_generated_method = "6D28BE71D8D422C54A307D1CF6ED07E4")
    private void unregisterForScrollChanged() {
        WeakReference<View> anchorRef = mAnchor;
        View anchor = null;
        if(anchorRef != null)        
        {
            anchor = anchorRef.get();
        } //End block
        if(anchor != null)        
        {
            ViewTreeObserver vto = anchor.getViewTreeObserver();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.969 -0400", hash_original_method = "F426C621D66F93AA8E883C7FBA8C8657", hash_generated_method = "8F3C4A7DC826CCF5A4745E96399AA96B")
    private void registerForScrollChanged(View anchor, int xoff, int yoff) {
        unregisterForScrollChanged();
        mAnchor = new WeakReference<View>(anchor);
        ViewTreeObserver vto = anchor.getViewTreeObserver();
        if(vto != null)        
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.970 -0400", hash_original_method = "2CEF1E9B6EE64B78C8FCC7C360A10341", hash_generated_method = "5E9A647D72DC263E9352A7381E95B0CA")
        public  PopupViewContainer(Context context) {
            super(context);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.970 -0400", hash_original_method = "60250F32C750F199B013D0293AAF47D3", hash_generated_method = "7EC87022BEEF8DB8FA79B5F43D0A9B00")
        @Override
        protected int[] onCreateDrawableState(int extraSpace) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(extraSpace);
            if(mAboveAnchor)            
            {
                final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
                View.mergeDrawableStates(drawableState, ABOVE_ANCHOR_STATE_SET);
                int[] var7A12E87773589D809FD51F1A26B9BDA9_1345432152 = (drawableState);
                                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_381528434 = {getTaintInt()};
                return varB4CCCA26F9DB9189C32F33E82D425CFB_381528434;
            } //End block
            else
            {
                int[] var66AAC6FF29C922B79B81CD6E0D9D06DC_1282171262 = (super.onCreateDrawableState(extraSpace));
                                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1803398479 = {getTaintInt()};
                return varB4CCCA26F9DB9189C32F33E82D425CFB_1803398479;
            } //End block
            // ---------- Original Method ----------
            //if (mAboveAnchor) {
                //final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
                //View.mergeDrawableStates(drawableState, ABOVE_ANCHOR_STATE_SET);
                //return drawableState;
            //} else {
                //return super.onCreateDrawableState(extraSpace);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.971 -0400", hash_original_method = "A2DD55E78C6B8B19849AEC8708A214E9", hash_generated_method = "053AF86E350D1F52B768CBB0B9A402AE")
        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            addTaint(event.getTaint());
            if(event.getKeyCode() == KeyEvent.KEYCODE_BACK)            
            {
                if(getKeyDispatcherState() == null)                
                {
                    boolean var639DD27D10E8FF69097B1398D445D1B9_2085916918 = (super.dispatchKeyEvent(event));
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1458018482 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1458018482;
                } //End block
                if(event.getAction() == KeyEvent.ACTION_DOWN
                        && event.getRepeatCount() == 0)                
                {
                    KeyEvent.DispatcherState state = getKeyDispatcherState();
                    if(state != null)                    
                    {
                        state.startTracking(event, this);
                    } //End block
                    boolean varB326B5062B2F0E69046810717534CB09_1600604814 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_310309992 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_310309992;
                } //End block
                else
                if(event.getAction() == KeyEvent.ACTION_UP)                
                {
                    KeyEvent.DispatcherState state = getKeyDispatcherState();
                    if(state != null && state.isTracking(event) && !event.isCanceled())                    
                    {
                        dismiss();
                        boolean varB326B5062B2F0E69046810717534CB09_1814639071 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1850295411 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1850295411;
                    } //End block
                } //End block
                boolean var639DD27D10E8FF69097B1398D445D1B9_1202145407 = (super.dispatchKeyEvent(event));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1143252343 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1143252343;
            } //End block
            else
            {
                boolean var639DD27D10E8FF69097B1398D445D1B9_854598029 = (super.dispatchKeyEvent(event));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1227798171 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1227798171;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.972 -0400", hash_original_method = "C7733BB60CAB256C1ABFC72965DD2E24", hash_generated_method = "A9A699C02B86DF5212687CA1D2400787")
        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            addTaint(ev.getTaint());
            if(mTouchInterceptor != null && mTouchInterceptor.onTouch(this, ev))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1536837194 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_855376361 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_855376361;
            } //End block
            boolean var0AC5BA914EBA28873DD435FB4415A279_1802671215 = (super.dispatchTouchEvent(ev));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975150777 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_975150777;
            // ---------- Original Method ----------
            //if (mTouchInterceptor != null && mTouchInterceptor.onTouch(this, ev)) {
                //return true;
            //}
            //return super.dispatchTouchEvent(ev);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.973 -0400", hash_original_method = "2EFE76B74388A6782646D0ACFFECA21F", hash_generated_method = "924750868552139C6D27943C356F5432")
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            final int x = (int) event.getX();
            final int y = (int) event.getY();
            if((event.getAction() == MotionEvent.ACTION_DOWN)
                    && ((x < 0) || (x >= getWidth()) || (y < 0) || (y >= getHeight())))            
            {
                dismiss();
                boolean varB326B5062B2F0E69046810717534CB09_2036511498 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_595678149 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_595678149;
            } //End block
            else
            if(event.getAction() == MotionEvent.ACTION_OUTSIDE)            
            {
                dismiss();
                boolean varB326B5062B2F0E69046810717534CB09_1949857593 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2144186860 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2144186860;
            } //End block
            else
            {
                boolean varB07EB30996A92905DCA4C49613CBAF5F_1402483542 = (super.onTouchEvent(event));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1776327511 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1776327511;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.973 -0400", hash_original_method = "EB4F4EE30B31AEB9BDFF308A3D2D5CAC", hash_generated_method = "42EAE056648D0D9056B3A45B30739B95")
        @Override
        public void sendAccessibilityEvent(int eventType) {
            addTaint(eventType);
            if(mContentView != null)            
            {
                mContentView.sendAccessibilityEvent(eventType);
            } //End block
            else
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.973 -0400", hash_original_field = "D449010BF1EF4FD4CDACB1483101094D", hash_generated_field = "0B566BDBB758C900741C0BD882C918B7")

        private static final String TAG = "PopupWindow.PopupViewContainer";
    }


    
    public interface OnDismissListener {
        
        public void onDismiss();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.973 -0400", hash_original_field = "873CD8303E150C0023A5A0952E0C3FDE", hash_generated_field = "EC879018D8E62A80ED7D5976B9A1B7A2")

    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.973 -0400", hash_original_field = "6129920895E2F2D47FADD35814B7EF6A", hash_generated_field = "620E7E20B08AC8DE8E08A876F15941F3")

    public static final int INPUT_METHOD_NEEDED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.974 -0400", hash_original_field = "03AFDC5E672A4B0142D6C7FFC5351ED3", hash_generated_field = "34E45A8A1172450CBFBC57CBC51A7F74")

    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.974 -0400", hash_original_field = "049F117D2BC9BFBE1D299F88D069231A", hash_generated_field = "55669BF630688FDF9A58292DE30C4824")

    private static final int[] ABOVE_ANCHOR_STATE_SET = new int[] {
        com.android.internal.R.attr.state_above_anchor
    };
}

